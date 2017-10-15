
package dto;

import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.genericEAO.PersistenceClassNotFoundException;
import openjanela.model.eao.partner.adjustmentRO_EAO.AdjustmentRO_EAO;
import openjanela.model.eao.partner.adjustmentRO_EAO.AdjustmentRO_PersistenceEAO;
import openjanela.model.entities.orderEntry.OrderItemsCart;
import openjanela.model.entities.orderEntry.OrderItemsCartPK;
import openjanela.model.entities.partner.AdjustmentRo;
import openjanela.model.entities.partner.AdjustmentRoPK;
import orderEntryUtility.UOMConvertData;

import org.apache.log4j.Logger;
import org.openjanela.commons.util.zip.GZipFile;

import util.ImageUtils;
import util.UOMConvert;
import Model.JobItemModel;
import Presentation.CostPricePanel;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved. User: Eddy Montenegro
 * Date: 12-26-12 Time: 11:00 AM
 */
public class OrderItemsCartDTO {

    // Apache log4j
    private static final Logger logger = Logger.getLogger(OrderItemsCart.class);

    /**
     * This method return a OrderItemsCart object value from opening event
     *
     * @param jobItemModel , JobItemModel
     * @return OrderItemsCart
     * @throws DTOTransformationError , Error
     */
    public static OrderItemsCart getOpenOrderItemsCart(JobItemModel jobItemModel, OrderItemsCart orderItemsCart)
            throws DTOTransformationError {

        if (jobItemModel == null) {
            throw new DTOTransformationError();
        }

        if (orderItemsCart == null) {
            throw new DTOTransformationError();
        }

        // Setting and configure values to UI
        jobItemModel.myParent.myTopPanel.description.setText(orderItemsCart.getDescription());
        jobItemModel.myParent.myTopPanel.qty.setText(orderItemsCart.getQuantity() + "");
        jobItemModel._WIDTH_Metric = orderItemsCart.getWidth();
        jobItemModel._HEIGHT_Metric = orderItemsCart.getHeight();
        jobItemModel._WIDTH_Imp = orderItemsCart.getWidthI();
        jobItemModel._HEIGHT_Imp = orderItemsCart.getHeightI();

        if (jobItemModel.myParent.currentUOM == 1) {

        	jobItemModel.myParent.myTopPanel.fW.setText(String.valueOf(orderItemsCart.getWidth() / 100d));
            jobItemModel.myParent.myTopPanel.fH.setText(String.valueOf(orderItemsCart.getHeight() / 100d));
            jobItemModel.myParent.myTopPanel.oW.setText(String.valueOf(orderItemsCart.getRoWidth() / 100d));
            jobItemModel.myParent.myTopPanel.oH.setText(String.valueOf(orderItemsCart.getRoHeight() / 100d));

        } else if (jobItemModel.myParent.currentUOM == 2) {

        	jobItemModel.myParent.myTopPanel.fW.setText(String.valueOf(orderItemsCart.getWidthI() / 64d));
            jobItemModel.myParent.myTopPanel.fH.setText(String.valueOf(orderItemsCart.getHeightI() / 64d));
            jobItemModel.myParent.myTopPanel.oW.setText(String.valueOf(orderItemsCart.getRoWidhtI() / 64d));
            jobItemModel.myParent.myTopPanel.oW.setText(String.valueOf(orderItemsCart.getRoHeightI() / 64d));

        } else if (jobItemModel.myParent.currentUOM == 3) {
        	try {
				jobItemModel.myParent.myTopPanel.fW.setText(UOMConvert.imperialToFraction(String.valueOf(orderItemsCart.getWidthI() / 64d)));
				jobItemModel.myParent.myTopPanel.fH.setText(UOMConvert.imperialToFraction(String.valueOf(orderItemsCart.getHeightI() / 64d)));
				jobItemModel.myParent.myTopPanel.oW.setText(UOMConvert.imperialToFraction(String.valueOf(orderItemsCart.getRoWidth() / 64d)));
				jobItemModel.myParent.myTopPanel.oH.setText(UOMConvert.imperialToFraction(String.valueOf(orderItemsCart.getRoHeight() / 64d)));
			} catch (Exception e) {
				e.printStackTrace();
			}
        }

        jobItemModel.myParent.myTopPanel.reference.setText(orderItemsCart.getReference());
        jobItemModel.myParent.partnerID = orderItemsCart.getSupplierId();
        jobItemModel.seriesid = orderItemsCart.getSeriesId();
        jobItemModel.myParent.textArea.setText(orderItemsCart.getNotes());

        //*************************************************************************
        // Find for Adjustment RO
        //*************************************************************************
        try {

            AdjustmentRO_EAO adjustmentROEAO = new AdjustmentRO_PersistenceEAO();

            AdjustmentRoPK adjustmentRoPK = new AdjustmentRoPK();
            adjustmentRoPK.setId(orderItemsCart.getRoAdjustmentId());
            adjustmentRoPK.setSeriesId(orderItemsCart.getSeriesId());
            AdjustmentRo adjustmentRo = adjustmentROEAO.findById(adjustmentRoPK);

            jobItemModel.myParent.myTopPanel.combRoadjust.setSelectedItem(adjustmentRo);
            jobItemModel.myParent.myTopPanel.myRO = adjustmentRo;

        } catch (PersistenceClassNotFoundException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        }

        jobItemModel.myParent.myTopPanel.qty.setText(orderItemsCart.getShipqty() + "");
        jobItemModel.myParent.currentUOM = orderItemsCart.getPriceUOM();
        jobItemModel.myParent.metricscale = orderItemsCart.getMetricScale();
        jobItemModel.myParent.imperialscale = orderItemsCart.getImperialScale();

        // **********************************************************************
        // Setting Financial Summary
        // **********************************************************************
        return orderItemsCart;
    }

    /**
     * Return Order Items Cart Entity Object
     *
     * @param jobItemModel , JobItemModel
     * @return OrderItemsCart
     * @throws DTOTransformationError , Error
     */
    public static OrderItemsCart getOrderItemsCartEntity(JobItemModel jobItemModel) throws DTOTransformationError {

        if (jobItemModel == null) {
            throw new DTOTransformationError();
        }

        //Get Canvas original values to restore
        int c_width = jobItemModel.myCanvas.getWidth();
        int c_height = jobItemModel.myCanvas.getHeight();

		/* Prepare canvas image to take a photo */
        jobItemModel.myCanvas.setSize(700, 500);
        byte[] image = jobItemModel.myCanvas.drawToImage(true);

        // Refactor the canvas to the original dimension
        jobItemModel.myCanvas.setSize(c_width, c_height);

        // Creating thumbnail image
        byte[] thumbnail = ImageUtils.createThumbnail(image, 150, 150);

        // ************************************************************** /*
        // Create Order Items cart */
        // **************************************************************
		/* Create order items carts primary key value */
        OrderItemsCartPK orderItemsCartPK = new OrderItemsCartPK();
        orderItemsCartPK.setId(jobItemModel.myParent.userID);
        orderItemsCartPK.setOrderId(jobItemModel.myParent.jobID);
        orderItemsCartPK.setItemId(jobItemModel.myParent.itemID);
        orderItemsCartPK.setVersionId(jobItemModel.myParent.versionID);

        OrderItemsCart orderItemsCart = new OrderItemsCart(orderItemsCartPK);

        orderItemsCart.setTypeId(jobItemModel.myParent.itemType);
        orderItemsCart.setActive(true);
        orderItemsCart.setDeleted(false);
        orderItemsCart.setPartId(0);

        orderItemsCart.setDescription(jobItemModel.myParent.myTopPanel.description.getText());
        orderItemsCart.setQuantity(Integer.parseInt(jobItemModel.myParent.myTopPanel.qty.getText()));

        orderItemsCart.setWidth(jobItemModel._WIDTH_Metric);
        orderItemsCart.setWidthI(jobItemModel._WIDTH_Imp);
        orderItemsCart.setHeight(jobItemModel._HEIGHT_Metric);
        orderItemsCart.setHeightI(jobItemModel._HEIGHT_Imp);

        try {

            if (jobItemModel.myParent.currentUOM == 1) {

                orderItemsCart.setRoWidth((int) (Double.parseDouble(jobItemModel.myParent.myTopPanel.oW.getText()) * 100));
                orderItemsCart.setRoHeight((int) (Double.parseDouble(jobItemModel.myParent.myTopPanel.oH.getText()) * 100));
                orderItemsCart.setRoWidhtI((int) Double.parseDouble(UOMConvertData
                        .metricToSixtyFourth(jobItemModel.myParent.myTopPanel.oW.getText())));
                orderItemsCart.setRoHeightI((int) Double.parseDouble(UOMConvertData
                        .metricToSixtyFourth(jobItemModel.myParent.myTopPanel.oH.getText())));

            } else if (jobItemModel.myParent.currentUOM == 2) {

                orderItemsCart.setRoWidhtI((int) (Double.parseDouble(jobItemModel.myParent.myTopPanel.oW.getText()) * 64d));
                orderItemsCart.setRoHeightI((int) (Double.parseDouble(jobItemModel.myParent.myTopPanel.oH.getText()) * 64d));
                orderItemsCart.setRoWidth((int) (Double.parseDouble(UOMConvertData
                        .imperialTometric(jobItemModel.myParent.myTopPanel.oW.getText())) * 100));
                orderItemsCart.setRoHeight((int) (Double.parseDouble(UOMConvertData
                        .imperialTometric(jobItemModel.myParent.myTopPanel.oH.getText())) * 100));

            } else if (jobItemModel.myParent.currentUOM == 3) {

                orderItemsCart.setRoWidhtI((int) (Double.parseDouble(UOMConvertData
                        .fractionToImperial(jobItemModel.myParent.myTopPanel.oW.getText())) * 64d));
                orderItemsCart.setRoHeightI((int) (Double.parseDouble(UOMConvertData
                        .fractionToImperial(jobItemModel.myParent.myTopPanel.oH.getText())) * 64d));
                orderItemsCart.setRoWidth((int) (Double.parseDouble(UOMConvertData
                        .fractionToMetric(jobItemModel.myParent.myTopPanel.oW.getText())) * 100));
                orderItemsCart.setRoHeight((int) (Double.parseDouble(UOMConvertData
                        .fractionToMetric(jobItemModel.myParent.myTopPanel.oH.getText())) * 100));

            }
        } catch (NumberFormatException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        }

        orderItemsCart.setSize(0); // TODO: Update value
        orderItemsCart.setSizeI(0); // TODO: Update value

        orderItemsCart.setReference(jobItemModel.myParent.myTopPanel.reference.getText());

        orderItemsCart.setLocationId(0); // TODO: Update value
        orderItemsCart.setLocationText(jobItemModel.myParent.myTopPanel.locationT.getText());

        orderItemsCart.setSupplierId(jobItemModel.myParent.supplierID);
        orderItemsCart.setSeriesId(jobItemModel.myParent.supplierPanel.getSupplierController().getSeriesSelected().getId());
        orderItemsCart.setNotes(jobItemModel.myParent.textArea.getText());

        orderItemsCart.setRoAdjustmentId(jobItemModel.myParent.myTopPanel.myRO.getAdjustmentRoPK().getId());
        orderItemsCart.setHsAdjustmentId(0);

        // ***********************************************************
        // Compress Image data values
        // ***********************************************************
        try {
            orderItemsCart.setImage(GZipFile.gzipCompress(image));
            orderItemsCart.setThumbnail(GZipFile.gzipCompress(thumbnail));
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        }

        orderItemsCart.setShipqty(Integer.parseInt(jobItemModel.myParent.myTopPanel.qty.getText()));
        orderItemsCart.setInit(0); // TODO: Update value
        orderItemsCart.setDone(0); // TODO: Update value
        orderItemsCart.setInprocess(0); // TODO: Update value
        orderItemsCart.setWidthFlat(0); // TODO: Update value
        orderItemsCart.setHeightFlat(0); // TODO: Update value
        orderItemsCart.setWidthFlatI(0); // TODO: Update value
        orderItemsCart.setHeightFlatI(0); // TODO: Update value
        orderItemsCart.setWidthOut(0); // TODO: Update value
        orderItemsCart.setWidthOutI(0); // TODO: Update value
        orderItemsCart.setWidthIn(0); // TODO: Update value
        orderItemsCart.setWidthInI(0); // TODO: Update value
        orderItemsCart.setGap(0); // TODO: Update value
        orderItemsCart.setGapI(0); // TODO: Update value
        orderItemsCart.setOpeningWidth(0); // TODO: Update value
        orderItemsCart.setOpeningWidthI(0); // TODO: Update value
        orderItemsCart.setDepth(0); // TODO: Updata value
        orderItemsCart.setDepthI(0); // TODO: Update value
        orderItemsCart.setExtension(0); // TODO: Update value
        orderItemsCart.setExtensionI(0); // TODO: Update value
        orderItemsCart.setProjectionIn(0); // TODO: Update value
        orderItemsCart.setProjectionInI(0); // TODO: Update value
        orderItemsCart.setProjectionOut(0); // TODO: Update value
        orderItemsCart.setProjectionOutI(0); // TODO: Update value
        orderItemsCart.setAngle(0); // TODO: Update value
        orderItemsCart.setUnitWidth(0); // TODO: Update value
        orderItemsCart.setUnitWidthI(0); // TODO: Update value
        orderItemsCart.setCenterUnit(0); // TODO: Update value
        orderItemsCart.setCenterUnitI(0); // TODO: Update value
        orderItemsCart.setMeasure(jobItemModel.myParent.currentUOM);
        orderItemsCart.setMetricScale(jobItemModel.myParent.metricscale);
        orderItemsCart.setImperialScale(jobItemModel.myParent.imperialscale);

        orderItemsCart.setStockCode(""); // TODO: Update value
        orderItemsCart.setPartType(0); // TODO: Update value
        orderItemsCart.setPriceGroup(0); // TODO: Update value
        orderItemsCart.setPriceMeasure(0); // TODO: Update value
        orderItemsCart.setPriceUOM(jobItemModel.myParent.currentUOM);
        orderItemsCart.setTaxable(true); // TODO: Update value
        orderItemsCart.setDiscountable(true); // TODO: Update value
        orderItemsCart.setRadius1(0); // TODO: Update value
        orderItemsCart.setRadius2(0); // TODO: Update value
        orderItemsCart.setRadius1i(0); // TODO: Update value
        orderItemsCart.setRadius2i(0); // TODO: Update value
        orderItemsCart.setLeftAngle(0); // TODO: Update value
        orderItemsCart.setRightAngle(0); // TODO: Update value
        orderItemsCart.setCustomPart(true); // TODO: Update value

        // **********************************************************************
        // Setting Financial Summary
        // **********************************************************************
        orderItemsCart.setCost(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.COST));
        orderItemsCart.setCostUser(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.COST_USER));
        orderItemsCart.setTotalCost(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.COST).multiply(new BigDecimal(orderItemsCart.getShipqty())));
        orderItemsCart.setDiscount(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.DISCOUNT));
        orderItemsCart.setPrice(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.PRICE));

        orderItemsCart.setPriceUser(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.NET_PRICE));
        orderItemsCart.setTotalPrice(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.NET_PRICE).multiply(new BigDecimal(orderItemsCart.getShipqty())));

        orderItemsCart.setCostBase(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.BASE, CostPricePanel.COST));
        orderItemsCart.setCostBaseUser(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.BASE, CostPricePanel.COST_USER));
        orderItemsCart.setPriceBase(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.BASE, CostPricePanel.PRICE));
        orderItemsCart.setPriceBaseUser(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.BASE, CostPricePanel.PRICE_USER));
        orderItemsCart.setDiscountBase(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.BASE, CostPricePanel.DISCOUNT));

        orderItemsCart.setCostOptions(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.OPTIONS, CostPricePanel.COST));
        orderItemsCart.setPriceOptions(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.OPTIONS, CostPricePanel.PRICE));
        orderItemsCart.setPriceOptionsUser(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.OPTIONS, CostPricePanel.PRICE_USER));
        orderItemsCart.setDiscountOptions(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.OPTIONS, CostPricePanel.DISCOUNT));

        orderItemsCart.setCostGlass(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.GLASS, CostPricePanel.COST));
        orderItemsCart.setCostGlassUser(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.GLASS, CostPricePanel.COST_USER));
        orderItemsCart.setPriceGlass(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.GLASS, CostPricePanel.PRICE));
        orderItemsCart.setPriceGlassUser(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.GLASS, CostPricePanel.PRICE_USER));
        orderItemsCart.setDiscountGlass(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.GLASS, CostPricePanel.DISCOUNT));

        orderItemsCart.setCostGrids(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.GRID, CostPricePanel.COST));
        orderItemsCart.setCostGridsUser(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.GRID, CostPricePanel.COST_USER));
        orderItemsCart.setPriceGrids(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.GRID, CostPricePanel.PRICE));
        orderItemsCart.setPriceGridsUser(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.GRID, CostPricePanel.PRICE_USER));
        orderItemsCart.setDiscountGrids(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.GRID, CostPricePanel.DISCOUNT));

        orderItemsCart.setCostLabor(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.LABOR, CostPricePanel.COST));
        orderItemsCart.setCostLaborUser(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.LABOR, CostPricePanel.COST_USER));
        orderItemsCart.setPriceLabor(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.LABOR, CostPricePanel.PRICE));
        orderItemsCart.setPriceLaborUser(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.LABOR, CostPricePanel.PRICE_USER));
        orderItemsCart.setDiscountLabor(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.LABOR, CostPricePanel.DISCOUNT));

        orderItemsCart.setCostShip(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.SHIPPING, CostPricePanel.COST));
        orderItemsCart.setCostShipUser(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.SHIPPING, CostPricePanel.COST_USER));
        orderItemsCart.setPriceShip(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.SHIPPING, CostPricePanel.PRICE));
        orderItemsCart.setPriceShipUser(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.SHIPPING, CostPricePanel.PRICE_USER));
        orderItemsCart.setDiscountShip(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.SHIPPING, CostPricePanel.DISCOUNT));

        orderItemsCart.setCostInstall(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.SERVICES, CostPricePanel.COST));
        orderItemsCart.setCostInstallUser(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.SERVICES, CostPricePanel.COST_USER));
        orderItemsCart.setPriceInstall(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.SERVICES, CostPricePanel.PRICE));
        orderItemsCart.setPriceInstallUser(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.SERVICES, CostPricePanel.PRICE_USER));
        orderItemsCart.setDiscountInstall(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.SERVICES, CostPricePanel.DISCOUNT));

        orderItemsCart.setCostOther(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.OTHER, CostPricePanel.COST));
        orderItemsCart.setCostOtherUser(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.OTHER, CostPricePanel.COST_USER));
        orderItemsCart.setPriceOther(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.OTHER, CostPricePanel.PRICE));
        orderItemsCart.setPriceOtherUser(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.OTHER, CostPricePanel.PRICE_USER));
        orderItemsCart.setDiscountOther(jobItemModel.myParent.costPricePanel.getPrice(CostPricePanel.OTHER, CostPricePanel.DISCOUNT));

        return orderItemsCart;
    }

}

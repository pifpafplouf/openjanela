package dto;

import openjanela.model.entities.orderEntry.OrderItems;
import openjanela.model.entities.orderEntry.OrderItemsCart;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 03-06-13
 *          Time: 08:03 PM
 */
public class OrderItemsDTO {

    /**
     * Return a OrderItems from OrderItemsCart object
     *
     * @param orderItemsCart, OrderItemsCart
     * @return OrderItems
     * @throws DTOTransformationError, Error
     */
    public OrderItems getOrderItems(OrderItemsCart orderItemsCart) throws DTOTransformationError {

        OrderItems orderItems = new OrderItems();
        orderItems.setTypeId(orderItemsCart.getTypeId());
        orderItems.setActive(orderItemsCart.isActive());
        orderItems.setDeleted(orderItemsCart.isDeleted());
        orderItems.setDeleted(orderItemsCart.isDeleted());
        orderItems.setPartId(orderItemsCart.getPartId());
        orderItems.setDescription(orderItemsCart.getDescription());
        orderItems.setStockCode(orderItemsCart.getStockCode());
        orderItems.setReference(orderItemsCart.getReference());
        orderItems.setQuantity(orderItemsCart.getQuantity());
        orderItems.setWidth(orderItemsCart.getWidth());
        orderItems.setWidthI(orderItemsCart.getWidthI());
        orderItems.setHeight(orderItemsCart.getHeight());
        orderItems.setHeightI(orderItemsCart.getHeightI());
        orderItems.setRoWidth(orderItemsCart.getRoWidth());
        orderItems.setRoWidhtI(orderItemsCart.getRoWidhtI());
        orderItems.setRoHeight(orderItemsCart.getRoHeight());
        orderItems.setRoHeightI(orderItemsCart.getRoHeightI());
        orderItems.setSize(orderItemsCart.getSize());
        orderItems.setSizeI(orderItemsCart.getSizeI());
        orderItems.setLocationId(orderItemsCart.getLocationId());
        orderItems.setLocationText(orderItemsCart.getLocationText());
        orderItems.setImage(orderItemsCart.getImage());
        orderItems.setSupplierId(orderItemsCart.getSupplierId());
        orderItems.setSeriesId(orderItemsCart.getSeriesId());
        orderItems.setNotes(orderItemsCart.getNotes());
        orderItems.setThumbnail(orderItemsCart.getThumbnail());
        orderItems.setRoAdjustmentId(orderItemsCart.getRoAdjustmentId());
        orderItems.setHsAdjustmentId(orderItemsCart.getHsAdjustmentId());
        orderItems.setCost(orderItemsCart.getCost());
        orderItems.setPrice(orderItemsCart.getPrice());
        orderItems.setShipQty(orderItemsCart.getShipqty());
        orderItems.setInit(orderItemsCart.getInit());
        orderItems.setDone(orderItemsCart.getDone());
        orderItems.setInProcess(orderItemsCart.getInprocess());
        orderItems.setWidthFlat(orderItemsCart.getWidthFlat());
        orderItems.setHeightFlat(orderItemsCart.getHeightFlat());
        orderItems.setWidthFlatI(orderItemsCart.getWidthFlatI());
        orderItems.setHeightFlatI(orderItemsCart.getHeightFlatI());
        orderItems.setWidthOut(orderItemsCart.getWidthOut());
        orderItems.setWidthOutI(orderItemsCart.getWidthOutI());
        orderItems.setWidthIn(orderItemsCart.getWidthIn());
        orderItems.setWidthInI(orderItemsCart.getWidthInI());
        orderItems.setGap(orderItemsCart.getGap());
        orderItems.setGapI(orderItemsCart.getGapI());
        orderItems.setOpeningWidth(orderItemsCart.getOpeningWidth());
        orderItems.setOpeningWidthI(orderItemsCart.getOpeningWidthI());
        orderItems.setDepth(orderItemsCart.getDepth());
        orderItems.setDepthI(orderItemsCart.getDepthI());
        orderItems.setExtension(orderItemsCart.getExtension());
        orderItems.setExtensionI(orderItemsCart.getExtensionI());
        orderItems.setProjectionIn(orderItemsCart.getProjectionIn());
        orderItems.setProjectionInI(orderItemsCart.getProjectionInI());
        orderItems.setProjectionOut(orderItemsCart.getProjectionOut());
        orderItems.setProjectionOutI(orderItemsCart.getProjectionOutI());
        orderItems.setAngle(orderItemsCart.getAngle());
        orderItems.setUnitWidth(orderItemsCart.getUnitWidth());
        orderItems.setUnitWidthI(orderItemsCart.getUnitWidthI());
        orderItems.setCenterUnit(orderItemsCart.getCenterUnit());
        orderItems.setCenterUnitI(orderItemsCart.getCenterUnitI());
        orderItems.setMeasure(orderItemsCart.getMeasure());
        orderItems.setMetricScale(orderItemsCart.getMetricScale());
        orderItems.setImperialScale(orderItemsCart.getImperialScale());
        orderItems.setPriceUser(orderItemsCart.getPriceUser());
        orderItems.setPriceShip(orderItemsCart.getPriceShip());
        orderItems.setPriceInstall(orderItemsCart.getPriceInstall());
        orderItems.setPriceShipUser(orderItemsCart.getPriceShipUser());
        orderItems.setPriceInstallUser(orderItemsCart.getPriceInstallUser());
        orderItems.setPartType(orderItemsCart.getPartType());
        orderItems.setPriceGroup(orderItemsCart.getPriceGroup());
        orderItems.setTotalPrice(orderItemsCart.getTotalPrice());
        orderItems.setTotalCost(orderItemsCart.getTotalCost());
        orderItems.setDiscount(orderItemsCart.getDiscount());
        orderItems.setPriceMeasure(orderItemsCart.getPriceMeasure());
        orderItems.setPriceUOM(orderItemsCart.getPriceUOM());
        orderItems.setTaxable(orderItemsCart.isTaxable());
        orderItems.setDiscountable(orderItemsCart.isDiscountable());
        orderItems.setRadius1(orderItemsCart.getRadius1());
        orderItems.setRadius2(orderItemsCart.getRadius2());
        orderItems.setRadius1i(orderItemsCart.getRadius1i());
        orderItems.setRadius2i(orderItemsCart.getRadius2i());
        orderItems.setLeftAngle(orderItemsCart.getLeftAngle());
        orderItems.setRightAngle(orderItemsCart.getRightAngle());
        orderItems.setCustomPart(orderItemsCart.isCustomPart());
        orderItems.setPriceBase(orderItemsCart.getPriceBase());
        orderItems.setPriceOptions(orderItemsCart.getPriceOptions());
        orderItems.setPriceGlass(orderItemsCart.getPriceGlass());
        orderItems.setPriceGrids(orderItemsCart.getPriceGrids());
        orderItems.setPriceLabor(orderItemsCart.getPriceLabor());
        orderItems.setPriceOther(orderItemsCart.getPriceOther());
        orderItems.setPriceBaseUser(orderItemsCart.getPriceBaseUser());
        orderItems.setPriceOptionsUser(orderItemsCart.getPriceOptionsUser());
        orderItems.setPriceGlassUser(orderItemsCart.getPriceGlassUser());
        orderItems.setPriceGridsUser(orderItemsCart.getPriceGridsUser());
        orderItems.setPriceLaborUser(orderItemsCart.getPriceLaborUser());
        orderItems.setPriceOtherUser(orderItemsCart.getPriceOtherUser());
        orderItems.setCostBase(orderItemsCart.getCostBase());
        orderItems.setCostOptions(orderItemsCart.getCostOptions());
        orderItems.setCostGlass(orderItemsCart.getCostGlass());
        orderItems.setCostGrids(orderItemsCart.getCostGrids());
        orderItems.setCostLabor(orderItemsCart.getCostLabor());
        orderItems.setCostShip(orderItemsCart.getCostShip());
        orderItems.setCostInstall(orderItemsCart.getCostInstall());
        orderItems.setCostOther(orderItemsCart.getCostOther());

        return orderItems;
    }
}

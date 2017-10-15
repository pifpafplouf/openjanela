package openjanela.app.configuration.controller.calculation;

import java.math.BigDecimal;

import Presentation.ItemFrame;
import openjanela.app.configuration.controller.BaseController;
import openjanela.model.eao.partner.pricingGroupEAO.PricingGroupEAO;
import openjanela.model.eao.partner.pricingGroupEAO.PricingGroupPersistenceEAO;
import openjanela.model.entities.orderEntry.PricingGroup;
import openjanela.model.entities.partner.SystemsMeasurement;
import orderEntryUtility.OEUtility;

import org.apache.log4j.Logger;

import Model.GlassSU;
import Model.OpeningObject;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 10-23-12
 * Time: 10:26 PM
 */
public class GlassSUController extends BaseController {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(GlassSUController.class);

    //******************************************************************************
    //Glass SU Object model
    //******************************************************************************
    private final GlassSU glassSU;

    //******************************************************************************
    //Entity Access objects
    //******************************************************************************
    private final PricingGroupEAO pricingGroupEAO;

    /**
     * GlassSU Controller default constructor
     */
    public GlassSUController(GlassSU glassSU) {

        //Setting glassSU Value
        this.glassSU = glassSU;

        //Setting Entity Access Objects values
        pricingGroupEAO = new PricingGroupPersistenceEAO();
    }

    /**
     * Calculate Width GlassSU
     *
     * @param systemMeasurement, System measurement
     * @return BigDecimal
     * @throws Exception, Exception
     */
    public BigDecimal calculateWidth(int systemMeasurement) throws Exception {

        //Search for pricing group
        PricingGroup pricingGroup = ItemFrame.getApplicationBase().getPricingGroup(glassSU.priceGroupId);

        //Calculate Width from metric measurement
        if (systemMeasurement == SystemsMeasurement.Metric.getValue()) {

            //Calculating length round for width
            //width / lengthRounding(i) = x | Math.ceil(x) * lengthRounding = y
            BigDecimal width = new BigDecimal(glassSU.widthM).divide(new BigDecimal("100"));
            width = width.divide(new BigDecimal(pricingGroup.getLengthRounding()));
            width = new BigDecimal(Math.ceil(width.doubleValue())).multiply(new BigDecimal(pricingGroup.getLengthRounding()));

            return width;
        }

        //Calculate Width from Imperial measurement
        if (glassSU.measure == SystemsMeasurement.Imperial.getValue()) {

            //Calculating length rounding for width
            BigDecimal width = new BigDecimal(glassSU.widthI).divide(new BigDecimal("64"));
            width = width.divide(new BigDecimal(pricingGroup.getLengthRoundingI()));
            width = new BigDecimal(Math.ceil(width.doubleValue())).multiply(new BigDecimal(pricingGroup.getLengthRoundingI()));

            return width;
        }

        return new BigDecimal("0");

    }

    /**
     * Calculate heigth GlassSU
     *
     * @param systemMeasurement, System measurement
     * @return BigDecimal
     * @throws Exception, Exception
     */
    public BigDecimal calculateHeigth(int systemMeasurement) throws Exception {

        //Search for pricing group
        PricingGroup pricingGroup = ItemFrame.getApplicationBase().getPricingGroup(glassSU.priceGroupId);

        //Calculate Width from metric measurement
        if (systemMeasurement == SystemsMeasurement.Metric.getValue()) {
            //Calculation length rounding for heigth
            BigDecimal heigth = new BigDecimal(glassSU.heightM).divide(new BigDecimal("100"));
            heigth = heigth.divide(new BigDecimal(pricingGroup.getLengthRounding()));
            heigth = new BigDecimal(OEUtility.roundLength(pricingGroup.getLengthRounding(), heigth.doubleValue(), true));

            return heigth;
        }

        //Calculate Width from Imperial measurement
        if (glassSU.measure == SystemsMeasurement.Imperial.getValue()) {
            //Calculating length rounding for heigth
            BigDecimal heigth = new BigDecimal(glassSU.heightI).divide(new BigDecimal("64"));
            heigth = heigth.divide(new BigDecimal(pricingGroup.getLengthRoundingI()));
            heigth = new BigDecimal(OEUtility.roundLength(pricingGroup.getLengthRoundingI(), heigth.doubleValue(), true));

            return heigth;
        }

        return new BigDecimal("0");

    }

    /**
     * Calculate Nominal Width from Parent Opening
     *
     * @param openingObject,      OpeningObject
     * @param systemsMeasurement, Systems measurement
     * @return BigDecimal
     * @throws Exception, Exception
     */
    public BigDecimal calculateNominalWidth(OpeningObject openingObject, int systemsMeasurement) throws Exception {

        logger.debug("Calculating glass width from opening values");

        BigDecimal endX;
        BigDecimal startX;
        BigDecimal widthPix;

        // Calculating endX
        if (openingObject.myMullionRight != null) {
            endX = new BigDecimal(Math.max(openingObject.myMullionRight.centerXs, openingObject.myMullionRight.centerXe));
        } else {
            endX = new BigDecimal(Math.max(openingObject.myParent.bCX2, openingObject.myParent.bCX3));
        }

        // Calculating startX
        if (openingObject.myMullionLeft != null) {
            startX = new BigDecimal(Math.min(openingObject.myMullionLeft.centerXs, openingObject.myMullionLeft.centerXe));
        } else {
            startX = new BigDecimal(Math.min(openingObject.myParent.startingCX, openingObject.myParent.bCX4));
        }

        widthPix = endX.subtract(startX);

        if (systemsMeasurement == SystemsMeasurement.Metric.getValue()) {
            widthPix = widthPix.divide(openingObject.myFrame2.metricscale.multiply(new BigDecimal(100)), 6,
                    BigDecimal.ROUND_UP);
            widthPix = widthPix.divide(new BigDecimal(1000), 6, BigDecimal.ROUND_UP);
        }

        if (systemsMeasurement == SystemsMeasurement.Imperial.getValue() ||
                systemsMeasurement == SystemsMeasurement.Fraction.getValue()) {
            widthPix = widthPix.divide(openingObject.myFrame2.imperialscale, 2, BigDecimal.ROUND_UP)
                    .divide(new BigDecimal(768), 6, BigDecimal.ROUND_UP);
        }

        return widthPix;
    }

    /**
     * Calculate Nominal Height Glass From Parent Opening
     *
     * @param openingObject,      OpeningObject
     * @param systemsMeasurement, Systems measurements
     * @return BigDecimal
     * @throws Exception, Exception
     */
    public BigDecimal calculateNominalHeight(OpeningObject openingObject, int systemsMeasurement) throws Exception {

        logger.debug("Calculating glass height from opening values");

        BigDecimal highestY;
        BigDecimal lowestY;
        BigDecimal heightPix;

        // Calculation highestY
        if (openingObject.myMullionTop != null) {
            highestY = new BigDecimal(Math.min(openingObject.myMullionTop.centerYs, openingObject.myMullionBot.centerYe));
        } else {
            highestY = new BigDecimal(openingObject.myParent.highestY);
        }

        //Calculation lowestY
        if (openingObject.myMullionBot != null) {
            lowestY = new BigDecimal(Math.max(openingObject.myMullionBot.centerYs, openingObject.myMullionBot.centerYe));
        } else {
            lowestY = new BigDecimal(openingObject.myParent.lowestYC);
        }

        heightPix = lowestY.subtract(highestY);

        if (systemsMeasurement == SystemsMeasurement.Metric.getValue()) {
            heightPix = heightPix.divide(openingObject.myFrame2.metricscale.multiply(new BigDecimal(100)), 2,
                    BigDecimal.ROUND_UP).divide(new BigDecimal(1000), 20, BigDecimal.ROUND_UP);
        }

        if (systemsMeasurement == SystemsMeasurement.Imperial.getValue() ||
                systemsMeasurement == SystemsMeasurement.Fraction.getValue()) {
            heightPix = heightPix.divide(openingObject.myFrame2.imperialscale, 20, BigDecimal.ROUND_UP)
                    .divide(new BigDecimal(768), 20, BigDecimal.ROUND_UP);
        }

        return heightPix;
    }

    /**
     * Calculate Area Glass
     *
     * @param systemsMeasurement, Systems measurement
     * @return BigDecimal
     * @throws Exception, Exception
     */
    public BigDecimal calculateAreaGlass(int systemsMeasurement) throws Exception {

        //Search for pricing group
        PricingGroup pricingGroup = ItemFrame.getApplicationBase().getPricingGroup(glassSU.priceGroupId);

        if (systemsMeasurement == SystemsMeasurement.Metric.getValue()) {

            BigDecimal width = calculateWidth(systemsMeasurement);
            BigDecimal heigth = calculateHeigth(systemsMeasurement);

            //Calculation area rounding for area
            //area / areaRounding(i) = x | Math.ceil(x) * areaRounding = y
            BigDecimal glassArea = width.divide(new BigDecimal("1000").multiply(heigth.divide(new BigDecimal("1000"))).
                    setScale(20, BigDecimal.ROUND_UP));
            glassArea = glassArea.divide(new BigDecimal(pricingGroup.getAreaRounding()));
            glassArea = new BigDecimal(OEUtility.roundLength(pricingGroup.getAreaRounding(), glassArea.doubleValue(), true));

            //If glassArea is less than min_pricing_area equals to this value
            if (glassArea.compareTo(new BigDecimal(glassSU.minPricingArea)) <= -1 ||
                    glassArea.compareTo(new BigDecimal(glassSU.minPricingArea)) == 0) {
                glassArea = new BigDecimal(glassSU.minPricingArea);
            }

            return glassArea;
        }

        if (glassSU.measure == SystemsMeasurement.Imperial.getValue()) {

            BigDecimal width = calculateWidth(systemsMeasurement);
            BigDecimal heigth = calculateHeigth(systemsMeasurement);

            //Calculating area rounding for area
            BigDecimal glassArea = width.multiply(heigth).divide(new BigDecimal("144")).setScale(20, BigDecimal.ROUND_UP);
            glassArea = glassArea.divide(new BigDecimal(pricingGroup.getAreaRoundingI()));
            glassArea = new BigDecimal(OEUtility.roundLength(pricingGroup.getAreaRoundingI(), glassArea.doubleValue(), true));

            //If glassArea is less than min_pricing_area equals to this value
            if (glassArea.compareTo(new BigDecimal(glassSU.minPricingAreaImp)) <= -1 ||
                    glassArea.compareTo(new BigDecimal(glassSU.minPricingAreaImp)) == 0) {
                glassArea = new BigDecimal(glassSU.minPricingAreaImp);
            }

            return glassArea;
        }

        return new BigDecimal("0");
    }

    /**
     * Calculate Area Glass from opening
     *
     * @param openingObject,      OpeningObject
     * @param systemsMeasurement, Systems measurement
     * @return BigDecimal
     * @throws Exception, Exception
     */
    public BigDecimal calculateNominalAreaGlass(OpeningObject openingObject, int systemsMeasurement) throws Exception {

        logger.debug("Calculating area glass from opening values");

        //Calculate Width from opening
        BigDecimal width = calculateNominalWidth(openingObject, systemsMeasurement);
        BigDecimal height = calculateNominalHeight(openingObject, systemsMeasurement);

        return width.multiply(height);

//        if (matrixHeader.getMeasure() == SystemsMeasurement.Metric.getValue()) {
//            width = glassSUController.calculateWidthGlassFromOpening(glassSU.myParentO,
//                    matrixHeader.getMeasure()).divide(new BigDecimal("100").divide(new BigDecimal("1000")));
//            height = glassSUController.calculateHeightGlassFromOpening(glassSU.myParentO,
//                    matrixHeader.getMeasure()).divide(new BigDecimal("100").divide(new BigDecimal("1000")));
//            area = width.multiply(height);
//            area = new BigDecimal(OEUtility.roundLength(pricingGroup.getAreaRounding(), area.doubleValue(), forPrice));
//        }
//
//        if (matrixHeader.getMeasure() == SystemsMeasurement.Imperial.getValue() ||
//                matrixHeader.getMeasure() == SystemsMeasurement.Fraction.getValue()) {
//            width = glassSUController.calculateWidthGlassFromOpening(glassSU.myParentO,
//                    matrixHeader.getMeasure()).divide(new BigDecimal("64"));
//            height = glassSUController.calculateHeightGlassFromOpening(glassSU.myParentO,
//                    matrixHeader.getMeasure()).divide(new BigDecimal("64"));
//            area = width.multiply(height).divide(new BigDecimal("144"));
//            area = new BigDecimal(OEUtility.roundLength(pricingGroup.getAreaRoundingI(), area.doubleValue(), forPrice));
//        }
//
//        if (matrixHeader.getMeasure() == SystemsMeasurement.Not_Applicable.getValue()) {
//            area = new BigDecimal("-1");
//        }
//
//        if (area.compareTo(new BigDecimal("0")) <= -1 || area.compareTo(new BigDecimal("0")) == 0) {
//            this.validResultMatrix = false;
//        }
    }

    /**
     * Calculate Width from matrix
     *
     * @param systemMeasurement, System Measurement
     * @return BigDecimal
     * @throws Exception, Exception
     */
    public BigDecimal calculateWidthFromMatrix(int systemMeasurement) throws Exception {
        
        logger.debug("Calculating width from matrix");

        //Search for pricing group
        PricingGroup pricingGroup = ItemFrame.getApplicationBase().getPricingGroup(glassSU.priceGroupId);

        //Calculating nominal width from parent opening and system measurement
        BigDecimal width = calculateNominalWidth(glassSU.myParentO, systemMeasurement);

        if (systemMeasurement == SystemsMeasurement.Metric.getValue()) {
            width = new BigDecimal(OEUtility.roundLength(pricingGroup.getLengthRounding(),
                    width.doubleValue(), true)).multiply(new BigDecimal("100"));
        }

        if (systemMeasurement == SystemsMeasurement.Imperial.getValue() ||
                systemMeasurement == SystemsMeasurement.Fraction.getValue()) {
            width = new BigDecimal(OEUtility.roundLength(pricingGroup.getLengthRoundingI(),
                    width.doubleValue(), true));
        }

        if (systemMeasurement == SystemsMeasurement.Not_Applicable.getValue()) {
            width = new BigDecimal("-1");
        }

        if (width.compareTo(new BigDecimal("0")) <= -1 || width.compareTo(new BigDecimal("0")) == 0) {
            width = new BigDecimal("-1");
        }

        return width;
    }

    /**
     * Calculate Height from matrix
     *
     * @param systemMeasurement, System Measurement
     * @return BigDecimal
     * @throws Exception, Exception
     */
    public BigDecimal calculateHeightFromMatrix(int systemMeasurement) throws Exception {

        //Search for pricing group
        PricingGroup pricingGroup = ItemFrame.getApplicationBase().getPricingGroup(glassSU.priceGroupId);

        //Calculating nominal height from parent opening and system measurement
        BigDecimal height = calculateNominalHeight(glassSU.myParentO, systemMeasurement).divide(new BigDecimal(100));

        if (systemMeasurement == SystemsMeasurement.Metric.getValue()) {              
            height = new BigDecimal(OEUtility.roundLength(pricingGroup.getLengthRounding(),
                    height.doubleValue(), true)).multiply(new BigDecimal("100"));
        }

        if (systemMeasurement == SystemsMeasurement.Imperial.getValue() ||
                systemMeasurement == SystemsMeasurement.Fraction.getValue()) {
            height = new BigDecimal(OEUtility.roundLength(pricingGroup.getLengthRoundingI(),
                    height.doubleValue(), true));
        }

        if (systemMeasurement == SystemsMeasurement.Not_Applicable.getValue()) {
            height = new BigDecimal("-1");
        }

        if (height.compareTo(new BigDecimal("0")) <= -1 || height.compareTo(new BigDecimal("0")) == 0) {
            height = new BigDecimal("-1");
        }
        
        return height;
    }

    /**
     * Calculate UI for Glass object model
     *
     * @param systemMeasurement, System Measurement
     * @return BigDecimal
     * @throws Exception, Exception
     */
    public BigDecimal calculateUI(int systemMeasurement) throws Exception {

        //Search for pricing group
        PricingGroup pricingGroup = ItemFrame.getApplicationBase().getPricingGroup(glassSU.priceGroupId);

        BigDecimal width = calculateNominalWidth(glassSU.myParentO, systemMeasurement).divide(new BigDecimal("100"));
        BigDecimal height = calculateNominalHeight(glassSU.myParentO, systemMeasurement).divide(new BigDecimal("100"));
        BigDecimal ui = new BigDecimal("-1");

        if (systemMeasurement == SystemsMeasurement.Metric.getValue()) {
            ui = width.add(height);
            ui = new BigDecimal(OEUtility.roundLength(pricingGroup.getUiRounding(), ui.doubleValue(), true));
        }

        if (systemMeasurement == SystemsMeasurement.Imperial.getValue() ||
                systemMeasurement == SystemsMeasurement.Fraction.getValue()) {
            ui = width.add(height);
            ui = new BigDecimal(OEUtility.roundLength(pricingGroup.getUiRounding(), ui.doubleValue(), true));
        }

        if (systemMeasurement == SystemsMeasurement.Not_Applicable.getValue()) {
            ui = new BigDecimal("-1");
        }
        
        return ui;
    }


}

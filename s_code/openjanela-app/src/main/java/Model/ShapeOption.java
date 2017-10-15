package Model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import Model.ProfileParts.Profiles;
import openjanela.model.entities.partner.OptionAnswers;
import openjanela.model.entities.partner.OptionDefinitions;

/**
 * Copyright (c) 2013, OpenJanela. All rights reserved.
 * User: Eddy Montenegro
 * Date: 18-02-13
 * Time: 11:00 AM
 */
public class ShapeOption implements Cloneable {

    public int ruleno = 0;

    public int a_levelID = 0;
    public int a_sequenceID = 11;
    public int a_assemblyLevel = 0;
    public int a_1Level = 0;
    public int a_1Sequence = 0;
    public int a_2Level = 0;
    public int a_2Sequence = 0;
    public int a_3Level = 0;
    public int a_3Sequence = 0;
    public int a_4Level = 0;
    public int a_4Sequence = 0;
    public int a_5Level = 0;
    public int a_5Sequence = 0;
    public int a_6Level = 0;
    public int a_6Sequence = 0;
    public int a_7Level = 0;
    public int a_7Sequence = 0;
    public int a_8Level = 0;
    public int a_8Sequence = 0;
    public int a_9Level = 0;
    public int a_9Sequence = 0;
    public int a_10Level = 0;
    public int a_10Sequence = 0;
    public int a_11Level = 0;
    public int a_11Sequence = 0;
    public int a_12Level = 0;
    public int a_12Sequence = 0;
    public int a_13Level = 0;
    public int a_13Sequence = 0;
    public int a_14Level = 0;
    public int a_14Sequence = 0;
    public int a_15Level = 0;
    public int a_15Sequence = 0;
    public int a_16Level = 0;
    public int a_16Sequence = 0;
    public int a_17Level = 0;
    public int a_17Sequence = 0;
    public int a_18Level = 0;
    public int a_18Sequence = 0;
    public int a_19Level = 0;
    public int a_19Sequence = 0;
    public int a_20Level = 0;
    public int a_20Sequence = 0;
    public int a_21Level = 0;
    public int a_21Sequence = 0;
    public int a_22Level = 0;
    public int a_22Sequence = 0;

    public int optionid = 0;
    public int answerid = 0;
    public int sizeanswer = 0;
    public int sizeansweri = 0;
    public int depthanswer = 0;
    public int depthansweri = 0;
    public int adjust = 0;
    public int adjusti = 0;
    public int w = 0;
    public int h = 0;
    public int wi = 0;
    public int hi = 0;
    public int d = 0;
    public int di = 0;
    public int l = 0;
    public int li = 0;
    public int priceuom = 0;
    public int costuom = 0;
    public int pricemeasure = 0;
    public int seriesid = 0;

    public int rgb_R = 255;
    public int rgb_G = 255;
    public int rgb_B = 255;

    public boolean isAuto = false;
    public boolean remove = false;

    public double discountP = 0;
    public double qtyanswer = 0;

    public String textAnswer = "";

    public BigDecimal price = new BigDecimal(0);
    public BigDecimal priceUser = new BigDecimal(0);
    public BigDecimal cost = new BigDecimal(0);
    public BigDecimal priceTotal = new BigDecimal(0);
    public BigDecimal priceTotalUser = new BigDecimal(0);
    public BigDecimal costTotal = new BigDecimal(0);

    public OptionDefinitions myoption;

    public OptionAnswers myanswer;

    public boolean global = false;

    public Collection<OptionAnswers> optionsAllowedAnswers = new ArrayList();

    public int supplierId = 0;
    public int supplierSeriesId = 0;
    public boolean remote = false;
    public int parentRule =0;

    public boolean isForShape(ShapeObject myShape) {

        boolean isequal = false;

        if (a_levelID == myShape.a_levelID &&
                a_sequenceID == myShape.a_sequenceID &&
                a_assemblyLevel == myShape.a_assemblyLevel &&
                a_1Level == myShape.a_1Level &&
                a_1Sequence == myShape.a_1Sequence &&
                a_2Level == myShape.a_2Level &&
                a_2Sequence == myShape.a_2Sequence &&
                a_3Level == myShape.a_3Level &&
                a_3Sequence == myShape.a_3Sequence &&
                a_4Level == myShape.a_4Level &&
                a_4Sequence == myShape.a_4Sequence &&
                a_5Level == myShape.a_5Level &&
                a_5Sequence == myShape.a_5Sequence &&
                a_6Level == myShape.a_6Level &&
                a_6Sequence == myShape.a_6Sequence &&
                a_7Level == myShape.a_7Level &&
                a_7Sequence == myShape.a_7Sequence &&
                a_8Level == myShape.a_8Level &&
                a_8Sequence == myShape.a_8Sequence &&
                a_9Level == myShape.a_9Level &&
                a_9Sequence == myShape.a_9Sequence &&
                a_10Level == myShape.a_10Level &&
                a_11Sequence == myShape.a_11Sequence &&
                a_12Sequence == myShape.a_12Sequence &&
                a_13Sequence == myShape.a_13Sequence &&
                a_14Sequence == myShape.a_14Sequence &&
                a_15Sequence == myShape.a_15Sequence &&
                a_16Sequence == myShape.a_16Sequence &&
                a_17Sequence == myShape.a_17Sequence &&
                a_18Sequence == myShape.a_18Sequence &&
                a_19Sequence == myShape.a_19Sequence &&
                a_20Sequence == myShape.a_20Sequence &&
                a_21Sequence == myShape.a_21Sequence &&
                a_22Sequence == myShape.a_22Sequence) {
            isequal = true;
        }
        return isequal;
    }
    
    public boolean isForSameAssembly(ShapeOption so) {

        boolean isequal = false;

        if (a_levelID == so.a_levelID &&
                a_sequenceID == so.a_sequenceID &&
                a_assemblyLevel == so.a_assemblyLevel &&
                a_1Level == so.a_1Level &&
                a_1Sequence == so.a_1Sequence &&
                a_2Level == so.a_2Level &&
                a_2Sequence == so.a_2Sequence &&
                a_3Level == so.a_3Level &&
                a_3Sequence == so.a_3Sequence &&
                a_4Level == so.a_4Level &&
                a_4Sequence == so.a_4Sequence &&
                a_5Level == so.a_5Level &&
                a_5Sequence == so.a_5Sequence &&
                a_6Level == so.a_6Level &&
                a_6Sequence == so.a_6Sequence &&
                a_7Level == so.a_7Level &&
                a_7Sequence == so.a_7Sequence &&
                a_8Level == so.a_8Level &&
                a_8Sequence == so.a_8Sequence &&
                a_9Level == so.a_9Level &&
                a_9Sequence == so.a_9Sequence &&
                a_10Level == so.a_10Level &&
                a_11Sequence == so.a_11Sequence &&
                a_12Sequence == so.a_12Sequence &&
                a_13Sequence == so.a_13Sequence &&
                a_14Sequence == so.a_14Sequence &&
                a_15Sequence == so.a_15Sequence &&
                a_16Sequence == so.a_16Sequence &&
                a_17Sequence == so.a_17Sequence &&
                a_18Sequence == so.a_18Sequence &&
                a_19Sequence == so.a_19Sequence &&
                a_20Sequence == so.a_20Sequence &&
                a_21Sequence == so.a_21Sequence &&
                a_22Sequence == so.a_22Sequence) {
            isequal = true;
        }
        return isequal;
    }

    public boolean isForMC(Profiles myShape) {

        boolean isequal = false;

        if (a_levelID == myShape.a_levelID && a_sequenceID == myShape.a_sequenceID
                && a_assemblyLevel == myShape.a_assemblyLevel && a_1Level == myShape.a_1Level
                && a_1Sequence == myShape.a_1Sequence && a_2Level == myShape.a_2Level
                && a_2Sequence == myShape.a_2Sequence && a_3Level == myShape.a_3Level
                && a_3Sequence == myShape.a_3Sequence && a_4Level == myShape.a_4Level
                && a_4Sequence == myShape.a_4Sequence && a_5Level == myShape.a_5Level
                && a_5Sequence == myShape.a_5Sequence && a_6Level == myShape.a_6Level
                && a_6Sequence == myShape.a_6Sequence && a_7Level == myShape.a_7Level
                && a_7Sequence == myShape.a_7Sequence && a_8Level == myShape.a_8Level
                && a_8Sequence == myShape.a_8Sequence && a_9Level == myShape.a_9Level
                && a_9Sequence == myShape.a_9Sequence && a_10Level == myShape.a_10Level
                && a_11Sequence == myShape.a_11Sequence && a_12Sequence == myShape.a_12Sequence
                && a_13Sequence == myShape.a_13Sequence && a_14Sequence == myShape.a_14Sequence
                && a_15Sequence == myShape.a_15Sequence && a_16Sequence == myShape.a_16Sequence
                && a_17Sequence == myShape.a_17Sequence && a_18Sequence == myShape.a_18Sequence
                && a_19Sequence == myShape.a_19Sequence && a_20Sequence == myShape.a_20Sequence
                && a_21Sequence == myShape.a_21Sequence && a_22Sequence == myShape.a_22Sequence) {
            isequal = true;
        }
        return isequal;
    }

    public boolean isForProfile(Profiles myShape) {

        boolean isequal = false;

        if (a_levelID == myShape.a_levelID && a_sequenceID == myShape.a_sequenceID
                && a_assemblyLevel == myShape.a_assemblyLevel && a_1Level == myShape.a_1Level
                && a_1Sequence == myShape.a_1Sequence && a_2Level == myShape.a_2Level
                && a_2Sequence == myShape.a_2Sequence && a_3Level == myShape.a_3Level
                && a_3Sequence == myShape.a_3Sequence && a_4Level == myShape.a_4Level
                && a_4Sequence == myShape.a_4Sequence && a_5Level == myShape.a_5Level
                && a_5Sequence == myShape.a_5Sequence && a_6Level == myShape.a_6Level
                && a_6Sequence == myShape.a_6Sequence && a_7Level == myShape.a_7Level
                && a_7Sequence == myShape.a_7Sequence && a_8Level == myShape.a_8Level
                && a_8Sequence == myShape.a_8Sequence && a_9Level == myShape.a_9Level
                && a_9Sequence == myShape.a_9Sequence && a_10Level == myShape.a_10Level
                && a_11Sequence == myShape.a_11Sequence && a_12Sequence == myShape.a_12Sequence
                && a_13Sequence == myShape.a_13Sequence && a_14Sequence == myShape.a_14Sequence
                && a_15Sequence == myShape.a_15Sequence && a_16Sequence == myShape.a_16Sequence
                && a_17Sequence == myShape.a_17Sequence && a_18Sequence == myShape.a_18Sequence
                && a_19Sequence == myShape.a_19Sequence && a_20Sequence == myShape.a_20Sequence
                && a_21Sequence == myShape.a_21Sequence && a_22Sequence == myShape.a_22Sequence) {
            isequal = true;
        }
        return isequal;
    }

    public boolean shapeOptionEqualsDesignOption(DesignOption myDesignOption) {

        boolean isequal = false;

        if (a_levelID == myDesignOption.a_levelID && a_sequenceID == myDesignOption.a_sequenceID
                && a_assemblyLevel == myDesignOption.a_assemblyLevel && a_1Level == myDesignOption.a_1Level
                && a_1Sequence == myDesignOption.a_1Sequence && a_2Level == myDesignOption.a_2Level
                && a_2Sequence == myDesignOption.a_2Sequence && a_3Level == myDesignOption.a_3Level
                && a_3Sequence == myDesignOption.a_3Sequence && a_4Level == myDesignOption.a_4Level
                && a_4Sequence == myDesignOption.a_4Sequence && a_5Level == myDesignOption.a_5Level
                && a_5Sequence == myDesignOption.a_5Sequence && a_6Level == myDesignOption.a_6Level
                && a_6Sequence == myDesignOption.a_6Sequence && a_7Level == myDesignOption.a_7Level
                && a_7Sequence == myDesignOption.a_7Sequence && a_8Level == myDesignOption.a_8Level
                && a_8Sequence == myDesignOption.a_8Sequence && a_9Level == myDesignOption.a_9Level
                && a_9Sequence == myDesignOption.a_9Sequence && a_10Level == myDesignOption.a_10Level
                && a_10Sequence == myDesignOption.a_10Sequence && ruleno == myDesignOption.ruleno) {
            isequal = true;
        }

        return isequal;
    }

    public ShapeOption clone(ShapeOption original) {

        ShapeOption shapeOption = new ShapeOption();
        shapeOption.a_levelID = original.a_levelID;
        shapeOption.a_sequenceID = original.a_sequenceID;
        shapeOption.a_assemblyLevel = original.a_assemblyLevel;
        shapeOption.a_1Level = original.a_1Level;
        shapeOption.a_1Sequence = original.a_1Sequence;
        shapeOption.a_2Level = original.a_2Level;
        shapeOption.a_2Sequence = original.a_2Sequence;
        shapeOption.a_3Level = original.a_3Level;
        shapeOption.a_3Sequence = original.a_3Sequence;
        shapeOption.a_4Level = original.a_4Level;
        shapeOption.a_4Sequence = original.a_4Sequence;
        shapeOption.a_5Level = original.a_5Level;
        shapeOption.a_5Sequence = original.a_5Sequence;
        shapeOption.a_6Level = original.a_6Level;
        shapeOption.a_6Sequence = original.a_6Sequence;
        shapeOption.a_7Level = original.a_7Level;
        shapeOption.a_7Sequence = original.a_7Sequence;
        shapeOption.a_8Level = original.a_8Level;
        shapeOption.a_8Sequence = original.a_8Sequence;
        shapeOption.a_9Level = original.a_9Level;
        shapeOption.a_9Sequence = original.a_9Sequence;
        shapeOption.a_10Level = original.a_10Level;
        shapeOption.a_10Sequence = original.a_10Sequence;

        shapeOption.optionid = original.optionid;
        shapeOption.answerid = original.answerid;
        shapeOption.myoption = original.myoption;
        shapeOption.myanswer = original.myanswer;
        shapeOption.qtyanswer = original.qtyanswer;
        shapeOption.sizeanswer = original.sizeanswer;
        shapeOption.sizeansweri = original.sizeansweri;
        shapeOption.depthanswer = original.depthanswer;
        shapeOption.depthansweri = original.depthansweri;

        shapeOption.adjust = original.adjust;
        shapeOption.adjusti = original.adjusti;
        shapeOption.textAnswer = original.textAnswer;

        shapeOption.rgb_R = original.rgb_R;
        shapeOption.rgb_G = original.rgb_G;
        shapeOption.rgb_B = original.rgb_B;

        shapeOption.price = original.price;
        shapeOption.discountP = original.discountP;
        shapeOption.priceUser = original.priceUser;
        shapeOption.cost = original.cost;

        shapeOption.w = original.w;
        shapeOption.h = original.h;
        shapeOption.wi = original.wi;
        shapeOption.hi = original.hi;
        shapeOption.d = original.d;
        shapeOption.di = original.di;
        shapeOption.l = original.l;
        shapeOption.li = original.li;

        shapeOption.priceuom = original.priceuom;
        shapeOption.costuom = original.costuom;
        shapeOption.pricemeasure = original.pricemeasure;
        shapeOption.priceTotal = original.priceTotal;
        shapeOption.priceTotalUser = original.priceTotalUser;
        shapeOption.costTotal = original.costTotal;
        shapeOption.seriesid = original.seriesid;
        shapeOption.ruleno = original.ruleno;
        shapeOption.optionsAllowedAnswers.addAll(original.optionsAllowedAnswers);
        shapeOption.isAuto = original.isAuto;

        shapeOption.supplierId = original.supplierId;
        shapeOption.supplierSeriesId = original.supplierSeriesId;
        shapeOption.remote = original.remote;
        shapeOption.parentRule = original.parentRule;
        
        return shapeOption;
    }

    public ShapeOption clone() throws CloneNotSupportedException {

        ShapeOption newShapeOption = (ShapeOption) super.clone();
        newShapeOption.price = new BigDecimal(newShapeOption.price.doubleValue());
        newShapeOption.priceUser = new BigDecimal(newShapeOption.priceUser.doubleValue());
        newShapeOption.cost = new BigDecimal(newShapeOption.cost.doubleValue());
        newShapeOption.priceTotal = new BigDecimal(newShapeOption.priceTotal.doubleValue());
        newShapeOption.priceTotalUser = new BigDecimal(newShapeOption.priceTotalUser.doubleValue());
        newShapeOption.costTotal = new BigDecimal(newShapeOption.costTotal.doubleValue());
        newShapeOption.parentRule = newShapeOption.parentRule;
        

        //Clone options allow answers                                               
        Collection<OptionAnswers> optionsAllowedAnswers = new ArrayList<OptionAnswers>();
        for (OptionAnswers optionAnswers : newShapeOption.optionsAllowedAnswers) {
            OptionAnswers newObject = new OptionAnswers();
            newObject.setId(optionAnswers.getId());
            newObject.setStockcode(optionAnswers.getStockcode());
            newObject.setDescription(optionAnswers.getDescription());
            newObject.setAbbreviation(optionAnswers.getAbbreviation());
            newObject.setPricing_uom_id(optionAnswers.getPricing_uom_id());
            newObject.setPrice_matrix_id(optionAnswers.getPrice_matrix_id());
            newObject.setPrice(optionAnswers.getPrice());
            newObject.setPrice_group_id(optionAnswers.getPrice_group_id());
            newObject.setThickness(optionAnswers.getThickness());
            newObject.setMin_price(optionAnswers.getMin_price());
            newObject.setCosting_uom_id(optionAnswers.getCosting_uom_id());
            newObject.setCost(optionAnswers.getCost());
            newObject.setPriceMeasure(optionAnswers.getPriceMeasure());
            newObject.setTaxable(optionAnswers.isTaxable());
            newObject.setDiscountable(optionAnswers.isDiscountable());
            newObject.setPriceFromCost(optionAnswers.isPriceFromCost());
            newObject.setPriceMarkup(optionAnswers.getPriceMarkup());
            newObject.setCostMarkup(optionAnswers.getCostMarkup());

            newObject.setSupplierId(optionAnswers.getSupplierId());
            newObject.setRemote(optionAnswers.isRemote());

            optionsAllowedAnswers.add(newObject);
        }
        newShapeOption.optionsAllowedAnswers = optionsAllowedAnswers;

        return newShapeOption;
    }

    @Override
    public String toString() {
        return myoption.toString();
    }
}

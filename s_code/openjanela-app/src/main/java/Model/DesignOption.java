package Model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import openjanela.model.entities.partner.OptionAnswers;
import openjanela.model.entities.partner.OptionDefinitions;
import Model.ProfileParts.Profiles;

import org.apache.log4j.Logger;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Sherif ElDibani
 * @author Eddy Montenegro
 * @version 2.0.8
 */
public class DesignOption implements Cloneable {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(DesignOption.class);

    public Integer seq = 0;

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

    public OptionDefinitions myoption;
    public OptionAnswers myanswer;

    public String textAnswer = "";

    public int rgb_R = 255;
    public int rgb_G = 255;
    public int rgb_B = 255;

    public double qtyanswer = 0;
    public double discountP = 0;

    public int seriesid = 0;
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

    public BigDecimal price = new BigDecimal(0);
    public BigDecimal priceUser = new BigDecimal(0);
    public BigDecimal cost = new BigDecimal(0);
    public BigDecimal priceTotal = new BigDecimal(0);
    public BigDecimal priceTotalUser = new BigDecimal(0);
    public BigDecimal costTotal = new BigDecimal(0);

    public boolean isMixed = false;
    public boolean isAuto = false;
    public boolean remove = false;
    public boolean global = false;

    public int supplierID = 0;
    public int supplierSeriesID = 0;
    public boolean remote = false;
    public int parentRule = 0;
    public Collection<OptionAnswers> optionsAllowedAnswers = new ArrayList();

    public DesignOption() {}

    public DesignOption setDesignOptions(DesignOption designOption, ShapeOption shapeOption) {

        designOption.a_levelID = shapeOption.a_levelID;
        designOption.a_sequenceID = shapeOption.a_sequenceID;
        designOption.a_assemblyLevel = shapeOption.a_assemblyLevel;
        designOption.a_1Level = shapeOption.a_1Level;
        designOption.a_1Sequence = shapeOption.a_1Sequence;
        designOption.a_2Level = shapeOption.a_2Level;
        designOption.a_2Sequence = shapeOption.a_2Sequence;
        designOption.a_3Level = shapeOption.a_3Level;
        designOption.a_3Sequence = shapeOption.a_3Sequence;
        designOption.a_4Level = shapeOption.a_4Level;
        designOption.a_4Sequence = shapeOption.a_4Sequence;
        designOption.a_5Level = shapeOption.a_5Level;
        designOption.a_5Sequence = shapeOption.a_5Sequence;
        designOption.a_6Level = shapeOption.a_6Level;
        designOption.a_6Sequence = shapeOption.a_6Sequence;
        designOption.a_7Level = shapeOption.a_7Level;
        designOption.a_7Sequence = shapeOption.a_7Sequence;
        designOption.a_8Level = shapeOption.a_8Level;
        designOption.a_8Sequence = shapeOption.a_8Sequence;
        designOption.a_9Level = shapeOption.a_9Level;
        designOption.a_9Sequence = shapeOption.a_9Sequence;
        designOption.a_10Level = shapeOption.a_10Level;
        designOption.a_10Sequence = shapeOption.a_10Sequence;
        designOption.a_11Level = shapeOption.a_11Level;
        designOption.a_11Sequence = shapeOption.a_11Sequence;
        designOption.a_12Level = shapeOption.a_12Level;
        designOption.a_12Sequence = shapeOption.a_12Sequence;
        designOption.a_13Level = shapeOption.a_13Level;
        designOption.a_13Sequence = shapeOption.a_13Sequence;
        designOption.a_14Level = shapeOption.a_14Level;
        designOption.a_14Sequence = shapeOption.a_14Sequence;
        designOption.a_15Level = shapeOption.a_15Level;
        designOption.a_15Sequence = shapeOption.a_15Sequence;
        designOption.a_16Level = shapeOption.a_16Level;
        designOption.a_16Sequence = shapeOption.a_16Sequence;
        designOption.a_17Level = shapeOption.a_17Level;
        designOption.a_17Sequence = shapeOption.a_17Sequence;
        designOption.a_18Level = shapeOption.a_18Level;
        designOption.a_18Sequence = shapeOption.a_18Sequence;
        designOption.a_19Level = shapeOption.a_19Level;
        designOption.a_19Sequence = shapeOption.a_19Sequence;
        designOption.a_20Level = shapeOption.a_20Level;
        designOption.a_20Sequence = shapeOption.a_20Sequence;
        designOption.a_21Level = shapeOption.a_21Level;
        designOption.a_21Sequence = shapeOption.a_21Sequence;
        designOption.a_22Level = shapeOption.a_22Level;
        designOption.a_22Sequence = shapeOption.a_22Sequence;

        designOption.optionid = shapeOption.optionid;
        designOption.answerid = shapeOption.answerid;
        designOption.myoption = shapeOption.myoption;
        designOption.myanswer = shapeOption.myanswer;
        designOption.qtyanswer = shapeOption.qtyanswer;
        designOption.sizeanswer = shapeOption.sizeanswer;
        designOption.sizeansweri = shapeOption.sizeansweri;
        designOption.depthanswer = shapeOption.depthanswer;
        designOption.depthansweri = shapeOption.depthansweri;
        designOption.adjust = shapeOption.adjust;
        designOption.adjusti = shapeOption.adjusti;
        designOption.textAnswer = shapeOption.textAnswer;
        designOption.rgb_R = shapeOption.rgb_R;
        designOption.rgb_G = shapeOption.rgb_G;
        designOption.rgb_B = shapeOption.rgb_B;
        designOption.price = shapeOption.price;
        designOption.discountP = shapeOption.discountP;
        designOption.priceUser = shapeOption.priceUser;
        designOption.cost = shapeOption.cost;
        designOption.w = shapeOption.w;
        designOption.h = shapeOption.h;
        designOption.wi = shapeOption.wi;
        designOption.hi = shapeOption.hi;
        designOption.d = shapeOption.d;
        designOption.di = shapeOption.di;
        designOption.l = shapeOption.l;
        designOption.li = shapeOption.li;
        designOption.priceuom = shapeOption.priceuom;
        designOption.costuom = shapeOption.costuom;
        designOption.pricemeasure = shapeOption.pricemeasure;
        designOption.priceTotal = shapeOption.priceTotal;
        designOption.priceTotalUser = shapeOption.priceTotalUser;
        designOption.costTotal = shapeOption.costTotal;
        designOption.seriesid = shapeOption.seriesid;
        designOption.ruleno = shapeOption.ruleno;
        designOption.optionsAllowedAnswers.addAll(shapeOption.optionsAllowedAnswers);

        designOption.isAuto = shapeOption.isAuto;
        designOption.global = shapeOption.global;

        designOption.seriesid = shapeOption.seriesid;
        designOption.supplierID = shapeOption.supplierId;
        designOption.supplierSeriesID = shapeOption.supplierSeriesId;
        designOption.remote = shapeOption.remote;
        designOption.parentRule = shapeOption.parentRule;

        return designOption;
    }

    public boolean isForLevel(int level) {
        boolean isequal = false;

        if (this.a_assemblyLevel <= level) {
            isequal = true;
        }
        return isequal;
    }

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

    @Override
    public boolean equals(Object object) {

        DesignOption other = (DesignOption) object;

        boolean isequal = false;

        if (optionid == other.optionid && answerid == other.answerid
                || (optionid == other.optionid && answerid != other.answerid && isMixed)) {
            isequal = true;
        }
        return isequal;
    }

    public boolean isForSameAssembly(DesignOption so) {

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
    
    
    @Override
    public String toString() {
    	return myoption.toString();
    }

    @Override
    public DesignOption clone() {

        try {

            DesignOption newDesignOption = (DesignOption)super.clone();

            newDesignOption.optionid = newDesignOption.myoption.getId();
            newDesignOption.answerid = newDesignOption.myanswer.getId().getId();

            //Setting options reference null
            newDesignOption.myoption = null;
            newDesignOption.myanswer = null;
            newDesignOption.optionsAllowedAnswers = null;

            return newDesignOption;

        } catch (CloneNotSupportedException e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }

}

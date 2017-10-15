package Model;

import org.apache.log4j.Logger;

import Model.ProfileParts.Profiles;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 06-02-13
 *          Time: 02:45 PM
 */
public class ShapeNotes implements Cloneable {

    // Apache log4j
    private static final Logger logger = Logger.getLogger(BillOfMat.class);

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

    public int bomId;
    public int orderid;
    public int itemno;
    public int versionid;
    public int ruleid;
    public int seriesid;

    public int partid;
    public int level;
    public int position;
    public int orientation;
    public int openingid;
    public int sash;
    public int row;
    public int col;

    public int assemblyid;
    public int parentbomid;
    public int parentAssembly;

    public int ruleno;

    public int suType;

    public String frameDescription;
    public String frameStockCode;
    public String glassDescription;
    public String glassStockCode;

    public String stockcode = "";
    public String description = "";

    public double value = 0;
    public boolean showQty = false;

    public int supplierId;
    public int supplierSeriesId;
    public boolean remote;

    /**
     * Shape Notes Constructor
     */
    public ShapeNotes() {
    }

    /**
     * Setting Notes Values
     *
     * @param billOfMat, Bill Of Material
     */
    public void setNotesValues(BillOfMat billOfMat) {
        if (billOfMat != null) {
            this.a_levelID = billOfMat.a_levelID;
            this.a_sequenceID = billOfMat.a_sequenceID;
            this.a_assemblyLevel = billOfMat.a_assemblyLevel;

            this.a_1Level = billOfMat.a_1Level;
            this.a_1Sequence = billOfMat.a_1Sequence;
            this.a_2Level = billOfMat.a_2Level;
            this.a_2Sequence = billOfMat.a_2Sequence;
            this.a_3Level = billOfMat.a_3Level;
            this.a_3Sequence = billOfMat.a_3Sequence;
            this.a_4Level = billOfMat.a_4Level;
            this.a_4Sequence = billOfMat.a_4Sequence;
            this.a_5Level = billOfMat.a_5Level;
            this.a_5Sequence = billOfMat.a_5Sequence;
            this.a_6Level = billOfMat.a_6Level;
            this.a_6Sequence = billOfMat.a_6Sequence;
            this.a_7Level = billOfMat.a_7Level;
            this.a_7Sequence = billOfMat.a_7Sequence;
            this.a_8Level = billOfMat.a_8Level;
            this.a_8Sequence = billOfMat.a_8Sequence;
            this.a_9Level = billOfMat.a_9Level;
            this.a_9Sequence = billOfMat.a_9Sequence;
            this.a_10Level = billOfMat.a_10Level;
            this.a_10Sequence = billOfMat.a_10Sequence;
            this.a_11Level = billOfMat.a_11Level;
            this.a_11Sequence = billOfMat.a_11Sequence;
            this.a_12Level = billOfMat.a_12Level;
            this.a_12Sequence = billOfMat.a_12Sequence;
            this.a_13Level = billOfMat.a_13Level;
            this.a_13Sequence = billOfMat.a_13Sequence;
            this.a_14Level = billOfMat.a_14Level;
            this.a_14Sequence = billOfMat.a_14Sequence;
            this.a_15Level = billOfMat.a_15Level;
            this.a_15Sequence = billOfMat.a_15Sequence;
            this.a_16Level = billOfMat.a_16Level;
            this.a_16Sequence = billOfMat.a_16Sequence;
            this.a_17Level = billOfMat.a_17Level;
            this.a_17Sequence = billOfMat.a_17Sequence;
            this.a_18Level = billOfMat.a_18Level;
            this.a_18Sequence = billOfMat.a_18Sequence;
            this.a_19Level = billOfMat.a_19Level;
            this.a_19Sequence = billOfMat.a_19Sequence;
            this.a_20Level = billOfMat.a_20Level;
            this.a_20Sequence = billOfMat.a_20Sequence;
            this.a_21Level = billOfMat.a_21Level;
            this.a_21Sequence = billOfMat.a_21Sequence;
            this.a_22Level = billOfMat.a_22Level;
            this.a_22Sequence = billOfMat.a_22Sequence;

            this.bomId = billOfMat.bomId;
            this.orderid = billOfMat.orderid;
            this.itemno = billOfMat.itemno;
            this.versionid = billOfMat.versionid;
            this.ruleid = billOfMat.ruleno;
            this.seriesid = billOfMat.seriesid;

            this.partid = billOfMat.partid;
            this.level = billOfMat.level;
            this.position = billOfMat.position;
            this.orientation = billOfMat.orientation;
            this.openingid = billOfMat.openingid;
            this.sash = billOfMat.sash;
            this.row = billOfMat.row;
            this.col = billOfMat.col;

            this.assemblyid = billOfMat.assemblyid;
            this.parentbomid = billOfMat.parentbomid;
            this.parentAssembly = billOfMat.parentAssembly;

            this.ruleno = billOfMat.ruleno;

            this.stockcode = billOfMat.stockcode;
            this.description = billOfMat.description;

            this.value = billOfMat.qty;
            this.showQty = true;

            this.supplierId = billOfMat.supplierRemoteId;
            this.supplierSeriesId = billOfMat.supplierSeriesId;
            this.remote = billOfMat.remote;
        }
    }

    public void setNotesCommonElements(ShapeObject shape) {

        a_levelID = shape.a_levelID;
        a_sequenceID = shape.a_sequenceID;
        a_assemblyLevel = shape.a_assemblyLevel;
        a_1Level = shape.a_1Level;
        a_1Sequence = shape.a_1Sequence;
        a_2Level = shape.a_2Level;
        a_2Sequence = shape.a_2Sequence;
        a_3Level = shape.a_3Level;
        a_3Sequence = shape.a_3Sequence;
        a_4Level = shape.a_4Level;
        a_4Sequence = shape.a_4Sequence;
        a_5Level = shape.a_5Level;
        a_5Sequence = shape.a_5Sequence;
        a_6Level = shape.a_6Level;
        a_6Sequence = shape.a_6Sequence;
        a_7Level = shape.a_7Level;
        a_7Sequence = shape.a_7Sequence;
        a_8Level = shape.a_8Level;
        a_8Sequence = shape.a_8Sequence;
        a_9Level = shape.a_9Level;
        a_9Sequence = shape.a_9Sequence;
        a_10Level = shape.a_10Level;
        a_10Sequence = shape.a_10Sequence;
        a_11Level = shape.a_11Level;
        a_11Sequence = shape.a_11Sequence;
        a_12Level = shape.a_12Level;
        a_12Sequence = shape.a_12Sequence;
        a_13Level = shape.a_13Level;
        a_13Sequence = shape.a_13Sequence;
        a_14Level = shape.a_14Level;
        a_14Sequence = shape.a_14Sequence;
        a_15Level = shape.a_15Level;
        a_15Sequence = shape.a_15Sequence;
        a_16Level = shape.a_16Level;
        a_16Sequence = shape.a_16Sequence;
        a_17Level = shape.a_17Level;
        a_17Sequence = shape.a_17Sequence;
        a_17Sequence = shape.a_17Sequence;
        a_18Sequence = shape.a_18Sequence;
        a_19Level = shape.a_19Level;
        a_19Sequence = shape.a_19Sequence;
        a_20Level = shape.a_20Level;
        a_20Sequence = shape.a_20Sequence;
        a_21Level = shape.a_21Level;
        a_21Sequence = shape.a_21Sequence;
        a_22Level = shape.a_22Level;
        a_22Sequence = shape.a_22Sequence;
    }

    public void setNotesCommonElements(Profiles profile) {}

    /**
     * Evaluate Levels & Sequence for Profiles
     *
     * @param profile, Profile
     * @return boolean
     */
    public boolean equalsProfiles(Profiles profile) {
        
        if (this.a_levelID != profile.a_levelID) return false;
        if (this.a_sequenceID != profile.a_sequenceID) return false;
        if (this.a_assemblyLevel != profile.a_assemblyLevel) return false;

        if (this.a_1Level != profile.a_1Level) return false;
        if (this.a_2Level != profile.a_2Level) return false;
        if (this.a_3Level != profile.a_3Level) return false;
        if (this.a_4Level != profile.a_4Level) return false;
        if (this.a_5Level != profile.a_5Level) return false;
        if (this.a_6Level != profile.a_6Level) return false;
        if (this.a_7Level != profile.a_7Level) return false;
        if (this.a_8Level != profile.a_8Level) return false;
        if (this.a_9Level != profile.a_9Level) return false;
        if (this.a_10Level != profile.a_10Level) return false;
        if (this.a_11Level != profile.a_11Level) return false;
        if (this.a_12Level != profile.a_12Level) return false;
        if (this.a_13Level != profile.a_13Level) return false;
        if (this.a_14Level != profile.a_14Level) return false;
        if (this.a_15Level != profile.a_15Level) return false;
        if (this.a_16Level != profile.a_16Level) return false;
        if (this.a_17Level != profile.a_17Level) return false;
        if (this.a_18Level != profile.a_18Level) return false;
        if (this.a_19Level != profile.a_19Level) return false;
        if (this.a_20Level != profile.a_20Level) return false;
        if (this.a_21Level != profile.a_21Level) return false;
        if (this.a_22Level != profile.a_22Level) return false;
        if (this.a_1Sequence != profile.a_1Sequence) return false;
        if (this.a_2Sequence != profile.a_2Sequence) return false;
        if (this.a_3Sequence != profile.a_3Sequence) return false;
        if (this.a_4Sequence != profile.a_4Sequence) return false;
        if (this.a_5Sequence != profile.a_5Sequence) return false;
        if (this.a_6Sequence != profile.a_6Sequence) return false;
        if (this.a_7Sequence != profile.a_7Sequence) return false;
        if (this.a_8Sequence != profile.a_8Sequence) return false;
        if (this.a_9Sequence != profile.a_9Sequence) return false;
        if (this.a_10Sequence != profile.a_10Sequence) return false;
        if (this.a_11Sequence != profile.a_11Sequence) return false;
        if (this.a_12Sequence != profile.a_12Sequence) return false;
        if (this.a_13Sequence != profile.a_13Sequence) return false;
        if (this.a_14Sequence != profile.a_14Sequence) return false;
        if (this.a_15Sequence != profile.a_15Sequence) return false;
        if (this.a_16Sequence != profile.a_16Sequence) return false;
        if (this.a_17Sequence != profile.a_17Sequence) return false;
        if (this.a_18Sequence != profile.a_18Sequence) return false;
        if (this.a_19Sequence != profile.a_19Sequence) return false;
        if (this.a_20Sequence != profile.a_20Sequence) return false;
        if (this.a_21Sequence != profile.a_21Sequence) return false;
        if (this.a_22Sequence != profile.a_22Sequence) return false;

        return true;
    }

    /**
     * Evaluate Levels & Sequence for ShapeObject notes
     *
     * @param shapeObject, ShapeObject
     * @return boolean
     */
    public boolean equalsShapeObject(ShapeObject shapeObject) {

        if (this.a_levelID != shapeObject.a_levelID) return false;
        if (this.a_sequenceID != shapeObject.a_sequenceID) return false;
        if (this.a_assemblyLevel != shapeObject.a_assemblyLevel) return false;

        if (this.a_1Level != shapeObject.a_1Level) return false;
        if (this.a_2Level != shapeObject.a_2Level) return false;
        if (this.a_3Level != shapeObject.a_3Level) return false;
        if (this.a_4Level != shapeObject.a_4Level) return false;
        if (this.a_5Level != shapeObject.a_5Level) return false;
        if (this.a_6Level != shapeObject.a_6Level) return false;
        if (this.a_7Level != shapeObject.a_7Level) return false;
        if (this.a_8Level != shapeObject.a_8Level) return false;
        if (this.a_9Level != shapeObject.a_9Level) return false;
        if (this.a_10Level != shapeObject.a_10Level) return false;
        if (this.a_11Level != shapeObject.a_11Level) return false;
        if (this.a_12Level != shapeObject.a_12Level) return false;
        if (this.a_13Level != shapeObject.a_13Level) return false;
        if (this.a_14Level != shapeObject.a_14Level) return false;
        if (this.a_15Level != shapeObject.a_15Level) return false;
        if (this.a_16Level != shapeObject.a_16Level) return false;
        if (this.a_17Level != shapeObject.a_17Level) return false;
        if (this.a_18Level != shapeObject.a_18Level) return false;
        if (this.a_19Level != shapeObject.a_19Level) return false;
        if (this.a_20Level != shapeObject.a_20Level) return false;
        if (this.a_21Level != shapeObject.a_21Level) return false;
        if (this.a_22Level != shapeObject.a_22Level) return false;
        if (this.a_1Sequence != shapeObject.a_1Sequence) return false;
        if (this.a_2Sequence != shapeObject.a_2Sequence) return false;
        if (this.a_3Sequence != shapeObject.a_3Sequence) return false;
        if (this.a_4Sequence != shapeObject.a_4Sequence) return false;
        if (this.a_5Sequence != shapeObject.a_5Sequence) return false;
        if (this.a_6Sequence != shapeObject.a_6Sequence) return false;
        if (this.a_7Sequence != shapeObject.a_7Sequence) return false;
        if (this.a_8Sequence != shapeObject.a_8Sequence) return false;
        if (this.a_9Sequence != shapeObject.a_9Sequence) return false;
        if (this.a_10Sequence != shapeObject.a_10Sequence) return false;
        if (this.a_11Sequence != shapeObject.a_11Sequence) return false;
        if (this.a_12Sequence != shapeObject.a_12Sequence) return false;
        if (this.a_13Sequence != shapeObject.a_13Sequence) return false;
        if (this.a_14Sequence != shapeObject.a_14Sequence) return false;
        if (this.a_15Sequence != shapeObject.a_15Sequence) return false;
        if (this.a_16Sequence != shapeObject.a_16Sequence) return false;
        if (this.a_17Sequence != shapeObject.a_17Sequence) return false;
        if (this.a_18Sequence != shapeObject.a_18Sequence) return false;
        if (this.a_19Sequence != shapeObject.a_19Sequence) return false;
        if (this.a_20Sequence != shapeObject.a_20Sequence) return false;
        if (this.a_21Sequence != shapeObject.a_21Sequence) return false;
        if (this.a_22Sequence != shapeObject.a_22Sequence) return false;

        return true;
    }

    public boolean equals(Object obj) {

        ShapeNotes that = (ShapeNotes) obj;

        if (this.a_1Level != that.a_1Level) return false;
        if (this.a_2Level != that.a_2Level) return false;
        if (this.a_3Level != that.a_3Level) return false;
        if (this.a_4Level != that.a_4Level) return false;
        if (this.a_5Level != that.a_5Level) return false;
        if (this.a_6Level != that.a_6Level) return false;
        if (this.a_7Level != that.a_7Level) return false;
        if (this.a_8Level != that.a_8Level) return false;
        if (this.a_9Level != that.a_9Level) return false;
        if (this.a_10Level != that.a_10Level) return false;
        if (this.a_11Level != that.a_11Level) return false;
        if (this.a_12Level != that.a_12Level) return false;
        if (this.a_13Level != that.a_13Level) return false;
        if (this.a_14Level != that.a_14Level) return false;
        if (this.a_15Level != that.a_15Level) return false;
        if (this.a_16Level != that.a_16Level) return false;
        if (this.a_17Level != that.a_17Level) return false;
        if (this.a_18Level != that.a_18Level) return false;
        if (this.a_19Level != that.a_19Level) return false;
        if (this.a_20Level != that.a_20Level) return false;
        if (this.a_21Level != that.a_21Level) return false;
        if (this.a_22Level != that.a_22Level) return false;
        if (this.a_1Sequence != that.a_1Sequence) return false;
        if (this.a_2Sequence != that.a_2Sequence) return false;
        if (this.a_3Sequence != that.a_3Sequence) return false;
        if (this.a_4Sequence != that.a_4Sequence) return false;
        if (this.a_5Sequence != that.a_5Sequence) return false;
        if (this.a_6Sequence != that.a_6Sequence) return false;
        if (this.a_7Sequence != that.a_7Sequence) return false;
        if (this.a_8Sequence != that.a_8Sequence) return false;
        if (this.a_9Sequence != that.a_9Sequence) return false;
        if (this.a_10Sequence != that.a_10Sequence) return false;
        if (this.a_11Sequence != that.a_11Sequence) return false;
        if (this.a_12Sequence != that.a_12Sequence) return false;
        if (this.a_13Sequence != that.a_13Sequence) return false;
        if (this.a_14Sequence != that.a_14Sequence) return false;
        if (this.a_15Sequence != that.a_15Sequence) return false;
        if (this.a_16Sequence != that.a_16Sequence) return false;
        if (this.a_17Sequence != that.a_17Sequence) return false;
        if (this.a_18Sequence != that.a_18Sequence) return false;
        if (this.a_19Sequence != that.a_19Sequence) return false;
        if (this.a_20Sequence != that.a_20Sequence) return false;
        if (this.a_21Sequence != that.a_21Sequence) return false;
        if (this.a_22Sequence != that.a_22Sequence) return false;
        if (this.partid != that.partid) return false;
        if (this.level != that.level) return false;
        if (this.partid != that.partid) return false;
        if (this.level != that.level) return false;
        if (this.position != that.position) return false;
        if (this.orientation != that.orientation) return false;
        if (this.openingid != that.openingid) return false;
        if (this.sash != that.sash) return false;
        if (this.row != that.row) return false;
        if (this.col != that.col) return false;
        if (this.assemblyid != that.assemblyid) return false;
        if (this.parentbomid != that.parentbomid) return false;
        if (this.parentAssembly != that.parentAssembly) return false;
        if (this.ruleno != that.ruleno) return false;
        if (!this.description.equals(that.description)) return false;
        if (!this.stockcode.equals(that.stockcode)) return false;
        if (this.value != that.value) return false;
        if (this.showQty != that.showQty) return false;

        return true;
    }

    @Override
    public ShapeNotes clone() {

        try {

            // Clone Bill of Materials
            return (ShapeNotes) super.clone();

        } catch (CloneNotSupportedException e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }

}

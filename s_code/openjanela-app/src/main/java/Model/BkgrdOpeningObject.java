/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Model;


import java.awt.geom.GeneralPath;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import dto.*;
import openjanela.model.entities.design.BkgrdOpeningEntityObject;
import openjanela.model.entities.design.ProfileEntityObject;
import openjanela.model.entities.design.ProfileLimitObject;
import openjanela.model.entities.partner.Rules;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;

import Model.ProfileParts.Bot1Object;
import Model.ProfileParts.Bot2Object;
import Model.ProfileParts.Bot3Object;
import Model.ProfileParts.LeftObject;
import Model.ProfileParts.Profiles;
import Model.ProfileParts.RightObject;
import Model.ProfileParts.Top1Object;
import Model.ProfileParts.Top2Object;
import Model.ProfileParts.Top3Object;
import Operations.CreateOpenings;
import Presentation.ItemFrame;


public class BkgrdOpeningObject extends ShapeObject implements Cloneable {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(BkgrdOpeningObject.class);

    public int contentIn = 0;
    public int contentMid = 1;
    public int contentOut = 0;

    public GlassSU myGlassIn = null;
    public GlassSU myGlassMid = null;
    public GlassSU myGlassOut = null;

    public SashTypeObject sashObjectIn = null;
    public SashTypeObject sashObjectMid = null;
    public SashTypeObject sashObjectOut = null;

    public Collection glazingBeadsMid = new ArrayList();
    public Collection glazingBeadsIn = new ArrayList();
    public Collection glazingBeadsOut = new ArrayList();

    public DLO dloMid = null;
    public DLO dloIn = null;
    public DLO dloOut = null;

    public int order = 0;

    public Profiles mullion = new Profiles(); // Vertical mullions
    public Profiles mullionH = new Profiles();
    ; //Horizontal mullions

    public Profiles myProfilesV;
    public Profiles myProfilesH;
    public Profiles myProfilesHb;
    public Profiles myProfilesVr;
    public Profiles myProfilesHa;

    public Object[] mullionObjectsV;
    public Object[] mullionObjectsH;

    public Collection mullions = new ArrayList();
    public Collection mullionsH = new ArrayList();

    public double newRowH = 0;

    public GeneralPath myMullions = new GeneralPath();
    public GeneralPath myMullionsH = new GeneralPath();

    /**
     * Create BkgrdOpening model object
     */
    public BkgrdOpeningObject() {

        //Level Id
        a_levelID = 5;
        //Assambly level config
        a_assemblyLevel = 20;
    }

    /**
     * Create BkgrdOpening model object
     *
     * @param parent,  ShapeObject
     * @param shape,   shape
     * @param startC,  start column
     * @param startR,  start row
     * @param endC,    end column
     * @param endR,    end row
     * @param myframe, ItemFrame
     */
    public BkgrdOpeningObject(ShapeObject parent, int shape, int startC, int startR, int endC,
                              int endR, ItemFrame myframe) {

        //Call main constructor
        this();

        myParent = parent;
        shapeID = shape;
        startCol = startC;
        startRow = startR;
        endCol = endC;
        endRow = endR;
        myFrame2 = myframe;
        ((ShapeObject) this).myFrame2 = myFrame2;
    }

    /**
     * Create BkgrdOpening model object
     *
     * @param parent,       ShapeObject
     * @param myFrame,      ItemFrame
     * @param bkgrdOpening, BkgrdOpeningEntityObject
     */
    public BkgrdOpeningObject(ShapeObject parent, ItemFrame myFrame, BkgrdOpeningEntityObject bkgrdOpening) {

        //Call main constructor
        this();

        //Setting shape object parent
        myParent = parent;
        //Setting Item frame
        myFrame2 = myFrame;

        //Setting values BkgrdOpening object
        createBkgrdObjectModel(bkgrdOpening);
    }

    /**
     * Create BkgrdOpeningObject
     *
     * @param myframe, ItemFrame
     */
    public BkgrdOpeningObject(ItemFrame myframe) {

        //Call main constructor
        this();

        this.myFrame2 = myframe;
        //myFrame2.jobItem = myFrame2.jobItem;

        BkgrdOpeningObject.this.myFrame2 = myFrame2;
    }

    public BkgrdOpeningObject(ShapeObject parent, double wt, double hl, double wtc, double hlc, int shape, int sequence,
                              double startingX, double startingY, int startCol, int endCol, int startRow, int endRow, double bX2,
                              double bY2, double bX3, double bY3, double bX4, double bY4, double dimA1, double dimA2, double dimA3,
                              double dimA4, double dimA5, double dimA0, double dimB1, double dimB2, double dimB3, double dimB4,
                              double dimB5, double dimB0, double dimC1, double dimC2, double dimC3, double dimC4, double dimC5,
                              double dimC0, double dimD1, double dimD2, double dimD3, double dimD4, double dimD5, double dimD0,
                              boolean wire, double centerPointX, double centerPointY, double centerPointX2, double centerPointY2,
                              double radius1, double radius2, double startAngle, double endAngle, double bkgrdStartX, double bkgrdStartY,
                              double centralAngle, double startingCX, double startingCY, double bCX2, double bCY2, double bCX3,
                              double bCY3, double bCX4, double bCY4, boolean topIn, boolean botIn, boolean rightIn, boolean leftIn,
                              int lean, int lean2, int lean3, int lean4, int noSides, int sidesTop, int sidesBot, int sidesLeft,
                              int sidesRight, double parentStartX, double parentStartY, double tm, double bm, double lm, double rm,
                              double ta, double ba, double la, double ra, ItemFrame myframe2) {

        //Call main constructor
        this();

        myFrame2 = myframe2;
        myParent = parent;
        shapeID = shape;

        this.startingX = startingX;
        this.startingY = startingY;
        this.startCol = startCol;
        this.endCol = endCol;
        this.startRow = startRow;
        this.endRow = endRow;

        widthPix = wt;
        this.startingX = startingX;
        this.startingY = startingY;

        this.radius1 = radius1;
        this.radius2 = radius2;

        this.bkgrdStartX = bkgrdStartX;
        this.bkgrdStartY = bkgrdStartY;

        this.noSides = noSides;
        noSidesTop = sidesTop;
        noSidesBot = sidesBot;
        noSidesLeft = sidesLeft;
        noSidesRight = sidesRight;

        this.centerPointX = centerPointX;
        this.centerPointX2 = centerPointX2;
        this.centerPointY = centerPointY;
        this.centerPointY2 = centerPointY2;

        this.bX2 = bX2;
        this.bY2 = bY2;
        this.bX3 = bX3;
        this.bY3 = bY3;
        this.bX4 = bX4;
        this.bY4 = bY4;
        this.startingCX = startingCX;
        this.startingCY = startingCY;

        this.bCX2 = bCX2;
        this.bCY2 = bCY2;
        this.bCX3 = bCX3;
        this.bCY3 = bCY3;
        this.bCX4 = bCX4;
        this.bCY4 = bCY4;
        this.dimA1 = dimA1;
        this.dimA2 = dimA2;
        this.dimA3 = dimA3;
        this.dimA4 = dimA4;
        this.dimA5 = dimA5;
        this.dimA0 = dimA0;
        this.dimB1 = dimB1;
        this.dimB2 = dimB2;
        this.dimB3 = dimB3;
        this.dimB4 = dimB4;
        this.dimB5 = dimB5;
        this.dimB0 = dimB0;
        this.dimC1 = dimC1;
        this.dimC2 = dimC2;
        this.dimC3 = dimC3;
        this.dimC4 = dimC4;
        this.dimC5 = dimC5;
        this.dimC0 = dimC0;
        this.dimD1 = dimD1;
        this.dimD2 = dimD2;
        this.dimD3 = dimD3;
        this.dimD4 = dimD4;
        this.dimD5 = dimD5;
        this.dimD0 = dimD0;

        dimTM = tm;
        dimBM = bm;
        dimLM = lm;
        dimRM = rm;
        dimTA = ta;
        dimBA = ba;
        dimLA = la;
        dimRA = rm;

        this.topIn = topIn;
        this.botIn = botIn;
        this.leftIn = leftIn;
        this.rightIn = rightIn;

        this.lean = lean;
        this.lean2 = lean2;
        this.lean3 = lean3;
        this.lean4 = lean4;

        parentH = myParent.heightPix;
        parentW = myParent.widthPix;
        this.parentStartY = parentStartY;
        this.parentStartX = parentStartX;
        parentRadius1 = myParent.dimD2;
        parentCX = myParent.top1.x1;
        parentCY = myParent.top1.y1;
        parentCX2 = myParent.top1.x2;
        parentCY2 = myParent.top1.y2;
        parentShape = myParent.shapeID;

    }

    /**
     * This method create BkgrdOpeningObject from model entity
     *
     * @param bkgrdOpening , BkgrdOpeningEntityObject
     */
    private void createBkgrdObjectModel(BkgrdOpeningEntityObject bkgrdOpening) {

        // Shape object model transformation for BkgrdOpening
        ShapeObjectDTO.getShapeObjectModel(bkgrdOpening, this, BkgrdOpeningObject.class);

        // *******************************************************
        // Adding profiles
        // *******************************************************
        if (bkgrdOpening.getProfiles() != null && !bkgrdOpening.getProfiles().isEmpty()) {
            this.mullions = new ArrayList();
            this.mullionsH = new ArrayList();

            for (ProfileEntityObject profile : bkgrdOpening.getProfiles()) {

                Profiles profiles = new Profiles(this, profile);
                profiles.myParent = this; //Setting BkgrOpening parent

                if (profile.getOrientation() == 1) {
                    this.mullions.add(profiles);
                } else {
                    this.mullionsH.add(profiles);
                }
            }
        }

        // *******************************************************
        // Do GeneralPath BkgrdOpening
        // *******************************************************
        CreateOpenings createOpening = new CreateOpenings(this, myFrame2);
        createOpening.doGeneralPathBkgrdOpening(this);
    }

    /**
     * This method create BkgrdOpeningEntityObject from model design
     *
     * @return BkgrdOpeningEntityObject
     */
    public BkgrdOpeningEntityObject createBkgrdEntityObject() {

        // Creating BkgrdOpening to save
        BkgrdOpeningEntityObject bkgrdOpeningEntity = (BkgrdOpeningEntityObject) ShapeObjectDTO.getShapeAbstractObject(this,
                BkgrdOpeningEntityObject.class);

        // *******************************************************
        // Adding profiles
        // *******************************************************
        Set<ProfileEntityObject> dividers = new HashSet<ProfileEntityObject>();
        Object[] rmp = this.mullions.toArray();
        for (Object v : rmp) {
            Profiles profiles = (Profiles) v;
            dividers.add(profiles.createProfileEntityObject(bkgrdOpeningEntity));
        }

        Object[] rmp_h = this.mullionsH.toArray();
        for (Object v : rmp_h) {
            Profiles profiles = (Profiles) v;
            dividers.add(profiles.createProfileEntityObject(bkgrdOpeningEntity));
        }

        bkgrdOpeningEntity.setProfiles(dividers);

        return bkgrdOpeningEntity;
    }

    /**
     * This method create a copy of javabeans with a clone of properties values
     *
     * @param bkgrdOpeningEntity, BkgrdOpeningEntity
     * @return BkgrdOpeningEntityObject
     */
    public BkgrdOpeningEntityObject cloneObjectModel(BkgrdOpeningEntityObject bkgrdOpeningEntity) {

        //Clone BkgrdOpeningEntityObject
        BkgrdOpeningEntityObject bkgrdOpening = (BkgrdOpeningEntityObject) ShapeObjectDTO.
                cloneShapeAbstractObject(bkgrdOpeningEntity, BkgrdOpeningEntityObject.class);

        bkgrdOpening.setProfiles(null);

        //Clone Mullions horizontals and verticals
        if (bkgrdOpeningEntity.getProfiles() != null && !bkgrdOpeningEntity.getProfiles().isEmpty()) {

            Set<ProfileEntityObject> dividers = new HashSet<ProfileEntityObject>();
            for (ProfileEntityObject profileEntity : bkgrdOpeningEntity.getProfiles()) {
                ProfileEntityObject profile = (ProfileEntityObject) ProfileDTO.cloneProfileAbstractObject(profileEntity,
                        ProfileEntityObject.class);

                profile.setLimitStartX1a(null);
                profile.setLimitStartX1(null);
                profile.setLimitStartXC(null);
                profile.setLimitStartX2(null);
                profile.setLimitStartX2c(null);
                profile.setLimitStartY1a(null);
                profile.setLimitStartY1(null);
                profile.setLimitStartYC(null);
                profile.setLimitStartY2(null);
                profile.setLimitStartY2c(null);
                profile.setLimitEndX4a(null);
                profile.setLimitEndX4(null);
                profile.setLimitEndXC(null);
                profile.setLimitEndX3(null);
                profile.setLimitEndX3c(null);
                profile.setLimitEndY4a(null);
                profile.setLimitEndY4(null);
                profile.setLimitEndYC(null);
                profile.setLimitEndY3(null);
                profile.setLimitEndY3c(null);

                if (profileEntity.getLimitStartX1a() != null) {
                    profile.setLimitStartX1a((ProfileLimitObject) ProfileDTO.cloneProfileAbstractObject(
                            profileEntity.getLimitStartX1a(), ProfileLimitObject.class));
                }

                if (profileEntity.getLimitStartX1() != null) {
                    profile.setLimitStartX1((ProfileLimitObject) ProfileDTO.cloneProfileAbstractObject(
                            profileEntity.getLimitStartX1(), ProfileLimitObject.class));
                }

                if (profileEntity.getLimitStartXC() != null) {
                    profile.setLimitStartXC((ProfileLimitObject) ProfileDTO.cloneProfileAbstractObject(
                            profileEntity.getLimitStartXC(), ProfileLimitObject.class));
                }

                if (profileEntity.getLimitStartX2() != null) {
                    profile.setLimitStartX2((ProfileLimitObject) ProfileDTO.cloneProfileAbstractObject(
                            profileEntity.getLimitStartX2(), ProfileLimitObject.class));
                }

                if (profileEntity.getLimitStartX2c() != null) {
                    profile.setLimitStartX2c((ProfileLimitObject) ProfileDTO.cloneProfileAbstractObject(
                            profileEntity.getLimitStartX2c(), ProfileLimitObject.class));
                }

                if (profileEntity.getLimitStartY1a() != null) {
                    profile.setLimitStartY1a((ProfileLimitObject) ProfileDTO.cloneProfileAbstractObject(
                            profileEntity.getLimitStartY1a(), ProfileLimitObject.class));
                }

                if (profileEntity.getLimitStartY1() != null) {
                    profile.setLimitStartY1((ProfileLimitObject) ProfileDTO.cloneProfileAbstractObject(
                            profileEntity.getLimitStartY1(), ProfileLimitObject.class));
                }

                if (profileEntity.getLimitStartYC() != null) {
                    profile.setLimitStartYC((ProfileLimitObject) ProfileDTO.cloneProfileAbstractObject(
                            profileEntity.getLimitStartYC(), ProfileLimitObject.class));
                }

                if (profileEntity.getLimitStartY2() != null) {
                    profile.setLimitStartY2((ProfileLimitObject) ProfileDTO.cloneProfileAbstractObject(
                            profileEntity.getLimitStartY2(), ProfileLimitObject.class));
                }

                if (profileEntity.getLimitStartY2c() != null) {
                    profile.setLimitStartY2c((ProfileLimitObject) ProfileDTO.cloneProfileAbstractObject(
                            profileEntity.getLimitStartY2c(), ProfileLimitObject.class));
                }

                if (profileEntity.getLimitEndX4a() != null) {
                    profile.setLimitEndX4a((ProfileLimitObject) ProfileDTO.cloneProfileAbstractObject(
                            profileEntity.getLimitEndX4a(), ProfileLimitObject.class));
                }

                if (profileEntity.getLimitEndX4() != null) {
                    profile.setLimitEndX4((ProfileLimitObject) ProfileDTO.cloneProfileAbstractObject(
                            profileEntity.getLimitEndX4(), ProfileLimitObject.class));
                }

                if (profileEntity.getLimitEndXC() != null) {
                    profile.setLimitEndXC((ProfileLimitObject) ProfileDTO.cloneProfileAbstractObject(
                            profileEntity.getLimitEndXC(), ProfileLimitObject.class));
                }

                if (profileEntity.getLimitEndX3() != null) {
                    profile.setLimitEndX3((ProfileLimitObject) ProfileDTO.cloneProfileAbstractObject(
                            profileEntity.getLimitEndX3(), ProfileLimitObject.class));
                }

                if (profileEntity.getLimitEndX3c() != null) {
                    profile.setLimitEndX3c((ProfileLimitObject) ProfileDTO.cloneProfileAbstractObject(
                            profileEntity.getLimitEndX3c(), ProfileLimitObject.class));
                }

                if (profileEntity.getLimitEndY4a() != null) {
                    profile.setLimitEndY4a((ProfileLimitObject) ProfileDTO.cloneProfileAbstractObject(
                            profileEntity.getLimitEndY4a(), ProfileLimitObject.class));
                }

                if (profileEntity.getLimitEndY4() != null) {
                    profile.setLimitEndY4((ProfileLimitObject) ProfileDTO.cloneProfileAbstractObject(
                            profileEntity.getLimitEndY4(), ProfileLimitObject.class));
                }

                if (profileEntity.getLimitEndYC() != null) {
                    profile.setLimitEndYC((ProfileLimitObject) ProfileDTO.cloneProfileAbstractObject(
                            profileEntity.getLimitEndYC(), ProfileLimitObject.class));
                }

                if (profileEntity.getLimitEndY3() != null) {
                    profile.setLimitEndY3((ProfileLimitObject) ProfileDTO.cloneProfileAbstractObject(
                            profileEntity.getLimitEndY3(), ProfileLimitObject.class));
                }

                if (profileEntity.getLimitEndY3c() != null) {
                    profile.setLimitEndY3c((ProfileLimitObject) ProfileDTO.cloneProfileAbstractObject(
                            profileEntity.getLimitEndY3c(), ProfileLimitObject.class));
                }

                dividers.add(profile);
            }

            bkgrdOpening.setProfiles(dividers);
        }

        return bkgrdOpening;
    }

    public BkgrdOpeningObject cloneBkgrdOpening(BkgrdOpeningObject original) {

        BkgrdOpeningObject newBkgrd = cloneBkgrdOpeningShape(original);
        newBkgrd.myFrame2 = original.myFrame2;

        // if (original.myParentO != null) {
        // newBkgrd.myParentO =
        // original.myParentO.cloneOpening(original.myParentO);
        // }

        Collection newc = new ArrayList();
        Object[] rmp = original.mullions.toArray();
        for (final Object v : rmp) {
            newc.add(((Profiles) v).cloneProfile((Profiles) v, newBkgrd));
        }

        newBkgrd.mullions = newc;

        newc = new ArrayList();
        rmp = original.mullionsH.toArray();
        for (final Object v : rmp) {
            newc.add(((Profiles) v).cloneProfile((Profiles) v, newBkgrd));
        }
        newBkgrd.mullionsH = newc;
        newBkgrd.newRowH = original.newRowH;

        newBkgrd.myMullions = (GeneralPath) original.myMullions.clone();
        newBkgrd.myMullionsH = (GeneralPath) original.myMullionsH.clone();

        return newBkgrd;
    }

    public BkgrdOpeningObject cloneBkgrdOpeningShape(BkgrdOpeningObject original) {

        BkgrdOpeningObject newOV = new BkgrdOpeningObject(original.myParent, original.shapeID, original.startCol,
                original.startRow, original.endCol, original.endRow, original.myFrame2);

        // Setting level ID Compound

        newOV.myFrame2 = original.myFrame2;
        newOV.myParent = original.myParent;
        newOV.myParentO = original.myParentO;
        newOV.shapeID = original.shapeID;
        newOV.rID = original.rID;
        newOV.parentid = original.parentid;

        newOV.startCol = original.startCol;
        newOV.startRow = original.startRow;

        newOV.endCol = original.endCol;
        newOV.endRow = original.endRow;

        newOV.a_levelID = original.a_levelID;
        newOV.a_sequenceID = original.a_sequenceID;

        // Setting starting point for X & Y

        newOV.a_1Level = original.a_1Level;
        newOV.a_1Sequence = original.a_1Sequence;
        newOV.a_2Level = original.a_2Level;
        newOV.a_2Sequence = original.a_2Sequence;
        newOV.a_3Level = original.a_3Level;
        newOV.a_3Sequence = original.a_3Sequence;
        newOV.a_4Level = original.a_4Level;
        newOV.a_4Sequence = original.a_4Sequence;
        newOV.a_5Level = original.a_5Level;
        newOV.a_5Sequence = original.a_5Sequence;
        newOV.a_6Level = original.a_6Level;
        newOV.a_6Sequence = original.a_6Sequence;
        newOV.a_7Level = original.a_7Level;
        newOV.a_7Sequence = original.a_7Sequence;
        newOV.a_8Level = original.a_8Level;
        newOV.a_8Sequence = original.a_8Sequence;
        newOV.a_9Level = original.a_9Level;
        newOV.a_9Sequence = original.a_9Sequence;
        newOV.a_10Level = original.a_10Level;
        newOV.a_10Sequence = original.a_10Sequence;

        newOV.a_11Level = original.a_11Level;
        newOV.a_11Sequence = original.a_11Sequence;
        newOV.a_12Level = original.a_12Level;
        newOV.a_12Sequence = original.a_12Sequence;
        newOV.a_13Level = original.a_13Level;
        newOV.a_13Sequence = original.a_13Sequence;
        newOV.a_14Level = original.a_14Level;
        newOV.a_14Sequence = original.a_14Sequence;
        newOV.a_15Level = original.a_15Level;
        newOV.a_15Sequence = original.a_15Sequence;
        newOV.a_16Level = original.a_16Level;
        newOV.a_16Sequence = original.a_16Sequence;
        newOV.a_17Level = original.a_17Level;
        newOV.a_17Sequence = original.a_17Sequence;
        newOV.a_18Level = original.a_18Level;
        newOV.a_18Sequence = original.a_18Sequence;
        newOV.a_19Level = original.a_19Level;
        newOV.a_19Sequence = original.a_19Sequence;
        newOV.a_20Level = original.a_20Level;
        newOV.a_20Sequence = original.a_20Sequence;
        newOV.a_21Level = original.a_21Level;
        newOV.a_21Sequence = original.a_21Sequence;
        newOV.a_22Level = original.a_22Level;
        newOV.a_22Sequence = original.a_22Sequence;

        // Setting frame execution parent

        // Setting values coordinates
        newOV.widthPix = original.widthPix;
        newOV.heightPix = original.heightPix;
        newOV.highestX = original.highestX;
        newOV.lowestX = original.lowestX;
        newOV.highestY = original.highestY;
        newOV.lowestY = original.lowestY;
        newOV.highestYC = original.highestYC;
        newOV.lowestYC = original.lowestYC;
        newOV.isStdW = original.isStdW;
        newOV.isStdH = original.isStdH;
        newOV.stdWM = original.stdWM;
        newOV.stdWI = original.stdWI;
        newOV.stdHM = original.stdHM;
        newOV.stdHI = original.stdHI;

        newOV.removedParts = this.cloneCollections(original.removedParts);

        newOV.noPartsTop1 = original.noPartsTop1;
        newOV.noPartsTop2 = original.noPartsTop2;
        newOV.noPartsTop3 = original.noPartsTop3;
        newOV.noPartsBot1 = original.noPartsBot1;
        newOV.noPartsBot2 = original.noPartsBot2;
        newOV.noPartsBot3 = original.noPartsBot3;
        newOV.noPartsLeft = original.noPartsLeft;
        newOV.noPartsRight = original.noPartsRight;

        newOV.isNewFrame = original.isNewFrame;
        newOV.newRowH = original.newRowH;
        newOV.myFrame2 = original.myFrame2;
        newOV.newDesign = original.newDesign;

        newOV.frameStartCol = original.frameStartCol;
        newOV.frameStartRow = original.frameStartRow;
        newOV.frameEndCol = original.frameEndCol;
        newOV.frameEndRow = original.frameEndRow;
        newOV.myRow = original.myRow;
        newOV.myCol = original.myCol;
        newOV.myShapeID = original.myShapeID;
        newOV.myPrevShape = original.myPrevShape;
        newOV.myNewShape = original.myNewShape;
        newOV.myOpeningID = original.myOpeningID;
        newOV.mynewOpeningID = original.mynewOpeningID;
        newOV.mynewOpenindType = original.mynewOpenindType;
        newOV.newWidthTop = original.newWidthTop;
        newOV.newWidthBot = original.newWidthBot;
        newOV.newStartingY = original.newStartingY;
        newOV.newStartingX = original.newStartingX;
        newOV.newHL = original.newHL;
        newOV.newHR = original.newHR;
        newOV.newstartX = original.newstartX;
        newOV.newendX = original.newendX;
        newOV.newstartY = original.newstartY;
        newOV.newendY = original.newendY;

        newOV.newDimD2 = original.newDimD2;
        newOV.newDimB1 = original.newDimB1;

        newOV.rowColToAdd = original.rowColToAdd;
        newOV.addRow = original.addRow;

        newOV.dividedCentral = original.dividedCentral;
        newOV.myCouplerThickness = original.myCouplerThickness;
        newOV.setLeanTo = original.setLeanTo;

        newOV.minLeg = original.minLeg;
        newOV.wireFrame = original.wireFrame;

        newOV.parentid = original.parentid;
        newOV.parentStartRow = original.parentStartRow;

        newOV.startingXBA = original.startingXBA;
        newOV.startingYBA = original.startingYBA;

        newOV.startingXA = original.startingXA;
        newOV.startingYA = original.startingYA;
        newOV.bX2A = original.bX2A;
        newOV.bY2A = original.bY2A;
        newOV.bX3A = original.bX3A;
        newOV.bY3A = original.bX3A;

        newOV.bX4A = original.bX4A;
        newOV.bY4A = original.bY4A;
        newOV.bX2B = original.bX2B;
        newOV.bY2B = original.bY2B;
        newOV.bX3B = original.bX3B;
        newOV.bY3B = original.bY3B;
        newOV.bX4B = original.bX4B;
        newOV.bY4B = original.bY4B;
        newOV.openingW = original.openingW;
        newOV.openingH = original.openingH;
        newOV.openingWc = original.openingWc;
        newOV.openingHc = original.openingHc;
        newOV.openingWB = original.openingWB;
        newOV.openingHR = original.openingHR;
        newOV.openingWcB = original.openingWcB;
        newOV.openingHcR = original.openingHcR;
        newOV.openingWA = original.openingWA;
        newOV.openingHA = original.openingHA;
        newOV.openingWBA = original.openingWBA;
        newOV.openingHRA = original.openingHRA;
        newOV.dimTM = original.dimTM;
        newOV.dimBM = original.dimBM;
        newOV.dimLM = original.dimLM;
        newOV.dimRM = original.dimRM;
        newOV.dimTA = original.dimTA;
        newOV.dimBA = original.dimBA;
        newOV.dimLA = original.dimLA;
        newOV.dimRA = original.dimRA;
        newOV.a_sequenceID = original.a_sequenceID;
        newOV.lastSeq = original.lastSeq;
        newOV.xCols = original.xCols;
        newOV.yRows = original.yRows;
        newOV.noTracks = original.noTracks;
        newOV.openOut = original.openOut;
        newOV.glazedOut = original.glazedOut;
        newOV.radius1A = original.radius1A;
        newOV.radius2A = original.radius2A;
        newOV.startAngleA = original.startAngleA;
        newOV.endAngleA = original.endAngleA;
        newOV.bkgrdStartXA = original.bkgrdStartXA;
        newOV.bkgrdStartYA = original.bkgrdStartYA;
        newOV.centralAngleA = original.centralAngleA;
        newOV.px1 = original.px1;
        newOV.py1 = original.py1;
        newOV.px2 = original.px2;
        newOV.py2 = original.py2;
        newOV.px3 = original.px3;
        newOV.py3 = original.py3;
        newOV.px4 = original.px4;
        newOV.py4 = original.py4;
        newOV.px5 = original.px5;
        newOV.py5 = original.py5;
        newOV.px6 = original.px6;
        newOV.py6 = original.py6;
        newOV.px7 = original.px7;
        newOV.py7 = original.py7;
        newOV.px8 = original.px8;
        newOV.py8 = original.py8;
        newOV.px1A = original.px1A;
        newOV.py1A = original.py1A;
        newOV.px2A = original.px2A;
        newOV.py2A = original.py2A;
        newOV.px3A = original.px3A;
        newOV.py3A = original.py3A;
        newOV.px4A = original.px4A;
        newOV.py4A = original.py4A;
        newOV.px5A = original.px5A;
        newOV.py5A = original.py5A;
        newOV.px6A = original.px6A;
        newOV.py6A = original.py6A;
        newOV.px7A = original.px7A;
        newOV.py7A = original.py7A;
        newOV.px8A = original.px8A;
        newOV.py8A = original.py8A;
        newOV.px1c = original.px1c;
        newOV.py1c = original.py1c;
        newOV.px2c = original.px2c;
        newOV.py2c = original.py2c;
        newOV.px3c = original.px3c;
        newOV.py3c = original.py3c;
        newOV.px4c = original.px4c;
        newOV.py4c = original.py4c;
        newOV.px5c = original.px5c;
        newOV.py5c = original.py5c;
        newOV.px6c = original.px6c;
        newOV.py6c = original.py6c;
        newOV.px7c = original.px7c;
        newOV.py7c = original.py7c;
        newOV.px8c = original.px8c;
        newOV.py8c = original.py8c;

        newOV.hasSash = original.hasSash;
        newOV.unGlazed = original.unGlazed;
        newOV.openingClass = original.openingClass;
        newOV.userDefinedOpeningID = original.userDefinedOpeningID;
        newOV.outSash = original.outSash;
        newOV.inSash = original.inSash;
        newOV.midSash = original.midSash;
        newOV.myGlass = original.myGlass;
        newOV.outSashTracks = original.outSashTracks;
        newOV.inSashTracks = original.inSashTracks;
        newOV.midSashTracks = original.midSashTracks;

        newOV.id = original.id;
        newOV.rID = original.rID;
        newOV.a_levelID = original.a_levelID;
        newOV.shapeID = original.shapeID;

        newOV.openIn = original.openIn;
        newOV.lean = original.lean;
        newOV.lean2 = original.lean2;
        newOV.lean3 = original.lean3;
        newOV.lean4 = original.lean4;
        newOV.noSides = original.noSides;
        newOV.noSidesTop = original.noSidesTop;
        newOV.noSidesBot = original.noSidesBot;
        newOV.noSidesLeft = original.noSidesLeft;
        newOV.noSidesRight = original.noSidesRight;
        newOV.startingX = original.startingX;
        newOV.startingY = original.startingY;
        newOV.bX2 = original.bX2;
        newOV.bY2 = original.bY2;
        newOV.bX3 = original.bX3;
        newOV.bY3 = original.bY3;
        newOV.bX4 = original.bX4;
        newOV.bY4 = original.bY4;
        newOV.startingCX = original.startingCX;
        newOV.startingCY = original.startingCY;
        newOV.bCX2 = original.bCX2;
        newOV.bCY2 = original.bCY2;
        newOV.bCX3 = original.bCX3;
        newOV.bCY3 = original.bCY3;
        newOV.bCX4 = original.bCX4;
        newOV.bCY4 = original.bCY4;
        newOV.topShape = original.topShape;
        newOV.rightShape = original.rightShape;
        newOV.botShape = original.botShape;
        newOV.leftShape = original.leftShape;
        newOV.levelW = original.levelW;
        newOV.levelH = original.levelH;
        newOV.dimA1 = original.dimA1;
        newOV.dimA2 = original.dimA2;
        newOV.dimA3 = original.dimA3;
        newOV.dimA4 = original.dimA4;
        newOV.dimA5 = original.dimA5;
        newOV.dimA0 = original.dimA0;
        newOV.dimB1 = original.dimB1;
        newOV.dimB2 = original.dimB2;
        newOV.dimB3 = original.dimB3;
        newOV.dimB4 = original.dimB4;
        newOV.dimB5 = original.dimB5;
        newOV.dimB0 = original.dimB0;
        newOV.dimC1 = original.dimC1;
        newOV.dimC2 = original.dimC2;
        newOV.dimC3 = original.dimC3;
        newOV.dimC4 = original.dimC4;
        newOV.dimC5 = original.dimC5;
        newOV.dimC0 = original.dimC0;
        newOV.dimD1 = original.dimD1;
        newOV.dimD2 = original.dimD2;
        newOV.dimD3 = original.dimD3;
        newOV.dimD4 = original.dimD4;
        newOV.dimD5 = original.dimD5;
        newOV.dimD0 = original.dimD0;
        newOV.pA1 = original.pA1;
        newOV.pA2 = original.pA2;
        newOV.pA3 = original.pA3;
        newOV.pA4 = original.pA4;
        newOV.pA5 = original.pA5;
        newOV.pA0 = original.pA0;
        newOV.pB1 = original.pB1;
        newOV.pB2 = original.pB2;
        newOV.pB3 = original.pB3;
        newOV.pB4 = original.pB4;
        newOV.pB5 = original.pB5;
        newOV.pB0 = original.pB0;
        newOV.pC1 = original.pC1;
        newOV.pC2 = original.pC2;
        newOV.pC3 = original.pC3;
        newOV.pC4 = original.pC4;
        newOV.pC5 = original.pC5;
        newOV.pC0 = original.pC0;
        newOV.pD1 = original.pD1;
        newOV.pD2 = original.pD2;
        newOV.pD3 = original.pD3;
        newOV.pD4 = original.pD4;
        newOV.pD5 = original.pD5;
        newOV.pD0 = original.pD0;

        newOV.wire = original.wire;
        newOV.centerPointX = original.centerPointX;
        newOV.centerPointY = original.centerPointY;
        newOV.centerPointX2 = original.centerPointX2;
        newOV.centerPointY2 = original.centerPointY2;
        newOV.radius1 = original.radius1;
        newOV.radius2 = original.radius2;
        newOV.startAngle = original.startAngle;
        newOV.endAngle = original.endAngle;
        newOV.bkgrdStartX = original.bkgrdStartX;
        newOV.bkgrdStartY = original.bkgrdStartY;
        newOV.centralAngle = original.centralAngle;
        newOV.startCol = original.startCol;
        newOV.endCol = original.endCol;
        newOV.startRow = original.startRow;
        newOV.endRow = original.endRow;

        newOV.parentW = original.parentW;
        newOV.parentH = original.parentH;
        newOV.parentStartY = original.parentStartY;
        newOV.parentStartX = original.parentStartX;
        newOV.parentRadius1 = original.parentRadius1;

        newOV.myX = original.myX;
        newOV.myY = original.myY;
        newOV.topIn = original.topIn;
        newOV.rightIn = original.rightIn;
        newOV.botIn = original.botIn;
        newOV.leftIn = original.leftIn;

        newOV.deltaA1 = original.deltaA1;
        newOV.deltaC2 = original.deltaC2;
        newOV.deltaD1 = original.deltaD1;

        newOV.shapeChanged = original.shapeChanged;
        newOV.arcType = original.arcType;
        newOV.parentCX = original.parentCX;
        newOV.parentCY = original.parentCY;
        newOV.parentCX2 = original.parentCX2;
        newOV.parentCY2 = original.parentCY2;
        newOV.parentShape = original.parentShape;
        newOV.newPart = original.newPart;
        newOV.clearanceTop = original.clearanceTop;
        newOV.clearanceBot = original.clearanceBot;
        newOV.clearanceLeft = original.clearanceLeft;
        newOV.clearanceRight = original.clearanceRight;

        newOV.topObjectPath = (GeneralPath) original.topObjectPath.clone();

        newOV.top1 = (Top1Object) top1.cloneProfile(original.top1);
        newOV.top2 = (Top2Object) top2.cloneProfile(original.top2);
        newOV.top3 = (Top3Object) top3.cloneProfile(original.top3);
        newOV.right = (RightObject) right.cloneProfile(original.right);
        newOV.left = (LeftObject) left.cloneProfile(original.left);
        newOV.bot1 = (Bot1Object) bot1.cloneProfile(original.bot1);
        newOV.bot2 = (Bot2Object) bot2.cloneProfile(original.bot2);
        newOV.bot3 = (Bot3Object) bot3.cloneProfile(original.bot3);

        newOV.top1Part = (Profiles) newOV.top1Part.cloneProfile(original.top1Part);
        newOV.top2Part = (Profiles) newOV.top2Part.cloneProfile(original.top2Part);
        newOV.top3Part = (Profiles) newOV.top3Part.cloneProfile(original.top3Part);
        newOV.rightPart = (Profiles) newOV.rightPart.cloneProfile(original.rightPart);
        newOV.leftPart = (Profiles) newOV.leftPart.cloneProfile(original.leftPart);
        newOV.bot1Part = (Profiles) newOV.bot1Part.cloneProfile(original.bot1Part);
        newOV.bot2Part = (Profiles) newOV.bot2Part.cloneProfile(original.bot2Part);
        newOV.bot3Part = (Profiles) newOV.bot3Part.cloneProfile(original.bot3Part);

        newOV.partObjects = this.cloneCollections(original.partObjects);
        newOV.gp = (GeneralPath) original.gp.clone();

        if (original.myMullionBot != null) {
            newOV.myMullionBot = original.myMullionBot.cloneProfile(original.myMullionBot, newOV);
        }

        if (original.myMullionTop != null) {
            newOV.myMullionTop = original.myMullionTop.cloneProfile(original.myMullionTop, newOV);
        }

        if (original.myMullionLeft != null) {
            newOV.myMullionLeft = original.myMullionLeft.cloneProfile(original.myMullionLeft, newOV);
        }

        if (original.myMullionRight != null) {
            newOV.myMullionRight = original.myMullionRight.cloneProfile(original.myMullionRight, newOV);
        }

        newOV.findDLO = original.findDLO;
        newOV.analyseShape = original.analyseShape;
        newOV.myCanvas = original.myCanvas;
        newOV.verify = original.verify;
        newOV.setLeanTo = original.setLeanTo;
        newOV.createOpenings = original.createOpenings;

        newOV.supplierId = original.supplierId;
        newOV.supplierSeriesId = original.supplierSeriesId;
        newOV.remote = original.remote;

        // Cloning Options
        if (original.options != null) {
            Collection newc = new ArrayList();
            Object[] rmp = original.options.toArray();

            for (final Object v : rmp) {
                newc.add(((ShapeOption) v).clone((ShapeOption) v));
            }
            newOV.options = newc;

        }

        return newOV;
    }

    /**
     * Reset Shape Notes Collection for Design
     *
     * @throws Exception, Exception
     */
    public void resetShapeNotes() throws Exception {

        for (Object vm : this.mullions) {
            this.myFrame2.jobItem.shapeNotes.addAll(((Profiles) vm).notes);
        }

        for (Object hm : this.mullionsH) {
            this.myFrame2.jobItem.shapeNotes.addAll(((Profiles) hm).notes);
        }
    }

    @Override
    public BkgrdOpeningObject clone() {

        try {

            BkgrdOpeningObject newBkgrdOpening = (BkgrdOpeningObject) super.clone();

            //Clone verticals mullions objects
            Collection mullionsV = new ArrayList();
            for (Object vm : newBkgrdOpening.mullions) {
                Profiles mullion = ((Profiles) vm).clone();
                mullionsV.add(mullion);
            }
            newBkgrdOpening.mullions = mullionsV;

            //Clone horizontal mullions objects
            Collection mullionsH = new ArrayList();
            for (Object hm : newBkgrdOpening.mullionsH) {
                Profiles mullion = ((Profiles) hm).clone();
                mullionsH.add(mullion);
            }
            newBkgrdOpening.mullionsH = mullionsH;

            return newBkgrdOpening;

        } catch (DTOTransformationError e) {
            logger.error(e.getMessage(), e);
        } catch (CloneNotSupportedException e) {
            logger.error(e.getMessage(), e);
        }

        return null;

    }

    @Override
    public void isMatchingBOMRule(Rules rule, boolean doBOM) {

        // Execute Rule for Overall
        if (this.isMatchingRule(rule)) {
            executePartRules(rule, doBOM);
        }

        // *******************************************************
        // Adding profiles
        // *******************************************************
        if (this.mullions != null && this.mullions.size() > 0) {
            for (Object mullion : this.mullions) {
                if (((Profiles) mullion).isMatchingRule(rule)) {
                    ((Profiles) mullion).executePartRules(rule, doBOM);
                }
            }
        }

        if (this.mullionsH != null && this.mullionsH.size() > 0) {
            for (Object mullion : this.mullionsH) {
                if (((Profiles) mullion).isMatchingRule(rule)) {
                    ((Profiles) mullion).executePartRules(rule, doBOM);
                }
            }
        }
    }

    @Override
    public void loadBOMParts() {

        //Load BOM Parts
        if (this.bom != null && this.bom.size() > 0) {
            this.myFrame2.jobItem.bom.addAll(this.bom);
        }

        // *******************************************************
        // Load BOM Profiles
        // *******************************************************
        if (this.mullions != null && this.mullions.size() > 0) {
            for (Object mullion : this.mullions) {
                Profiles profile = (Profiles)mullion;
                profile.myFrame2 = this.myFrame2;

                profile.loadBOMParts();
            }
        }

        if (this.mullionsH != null && this.mullionsH.size() > 0) {
            for (Object mullion : this.mullionsH) {
                Profiles profile = (Profiles)mullion;
                profile.myFrame2 = this.myFrame2;

                profile.loadBOMParts();
            }
        }
    }

    @Override
    public void clearBOMParts() {

        //Clear BOM Parts
        if (this.bom != null && this.bom.size() > 0) {
            this.bom.clear();
            this.notes.clear();
        }

        // *******************************************************
        // Adding profiles
        // *******************************************************
        if (this.mullions != null && this.mullions.size() > 0) {
            for (Object mullion : this.mullions) {
                ((Profiles) mullion).clearBOMParts();
            }
        }

        if (this.mullionsH != null && this.mullionsH.size() > 0) {
            for (Object mullion : this.mullionsH) {
                ((Profiles) mullion).clearBOMParts();
            }
        }

    }

    @Override
    public void loadOptionsAll() {

        //Clear BOM Parts
        if (this.options != null && this.options.size() > 0) {
            for (ShapeOption shapeOption : this.options)  {
                if (!shapeOption.global) {

                    DesignOption designOption = new DesignOption();
                    designOption = designOption.setDesignOptions(designOption, shapeOption);

                    //Adding to Design Options All
                    this.myFrame2.designOptionsAll.add(designOption);
                }
            }
        }

        // *******************************************************
        // Adding profiles
        // *******************************************************
        if (this.mullions != null && this.mullions.size() > 0) {
            for (Object mullion : this.mullions) {
                ((Profiles) mullion).loadOptionsAll();
            }
        }

        if (this.mullionsH != null && this.mullionsH.size() > 0) {
            for (Object mullion : this.mullionsH) {
                ((Profiles) mullion).loadOptionsAll();
            }
        }

    }

}

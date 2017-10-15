/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Model;


import java.math.BigDecimal;
import java.util.*;

import openjanela.model.entities.design.FacetEntityObject;
import openjanela.model.entities.design.FrameEntityObject;
import openjanela.model.entities.design.GlazingBeadsLocations;
import openjanela.model.entities.design.Metrics;
import openjanela.model.entities.design.OpeningEntityObject;
import openjanela.model.entities.design.ProfileGlazingBeadsEntityObject;
import openjanela.model.entities.design.ProfileMyMullionObject;
import openjanela.model.entities.design.SashLeafEntityObject;
import openjanela.model.entities.design.SubFacetEntityObject;
import openjanela.model.entities.partner.RuleTest;
import openjanela.model.entities.partner.Rules;
import openjanela.model.entities.partner.SeriesValidOpeningShape;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;

import Model.ProfileParts.Bot1Object;
import Model.ProfileParts.Bot2Object;
import Model.ProfileParts.Bot3Object;
import Model.ProfileParts.LeftObject;
import Model.ProfileParts.ProfileParts;
import Model.ProfileParts.Profiles;
import Model.ProfileParts.ProfilesType;
import Model.ProfileParts.RightObject;
import Model.ProfileParts.Top1Object;
import Model.ProfileParts.Top2Object;
import Model.ProfileParts.Top3Object;
import Operations.CreateOpenings;
import Operations.CreateShapeMethods;
import Presentation.ItemFrame;
import dto.ConstructionMapDTO;
import dto.DTOTransformationError;
import dto.ProfileDTO;
import dto.ShapeObjectDTO;


public class OpeningObject extends ShapeObject implements Cloneable {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(OpeningObject.class);

    public int contentIn = 0;
    public int contentMid = 1; // 1= glass, 2 sash, 3 subFrame
    public int contentOut = 0;

    public GlassSU myGlassIn = null;
    public GlassSU myGlassMid = null;
    public GlassSU myGlassOut = null;

    public SashTypeObject sashObjectIn = null;
    public SashTypeObject sashObjectMid = null;
    public SashTypeObject sashObjectOut = null;

    public Facet subFacet = null;

    public Collection glazingBeadsMid = new ArrayList();
    public Collection glazingBeadsIn = new ArrayList();
    public Collection glazingBeadsOut = new ArrayList();

    public boolean topRemoved = false;
    public boolean botRemoved = false;

    public DLO dloMid = null;
    public DLO dloIn = null;
    public DLO dloOut = null;

    public GlazingBeads glazingBeadIn = null;
    public GlazingBeads glazingBeadMid = null;
    public GlazingBeads glazingBeadOut = null;

    /**
     * Creating Opening Object
     */
    public OpeningObject() {
        this.a_levelID = 5;
        this.a_assemblyLevel = 40;
    }

    /**
     * Create Opening object
     *
     * @param myframe, ItemFrame
     */
    public OpeningObject(ItemFrame myframe) {

        //Call main constructor
        this();

        //Setting ItemFrame
        myFrame2 = myframe;

        //setting metric scale
        scaleM = myFrame2.scale;
    }

    /**
     * Create Opening object
     *
     * @param parent,  ShapeObject
     * @param shape,   shape
     * @param startC,  start column
     * @param startR,  start row
     * @param endC,    end column
     * @param endR,    end row
     * @param myframe, ItemFrame
     */
    public OpeningObject(ShapeObject parent, int shape, int startC, int startR, int endC, int endR, ItemFrame myframe) {

        //Call main constructor
        this();

        //Setting ShapeObject
        myParent = parent;

        //Setting shapeID
        shapeID = shape;
        //Setting starting point
        startCol = startC;
        startRow = startR;
        //setting ending point
        endCol = endC;
        endRow = endR;
        //Setting ItemFrame
        myFrame2 = myframe;
        ((ShapeObject) this).myFrame2 = myFrame2;
        OpeningObject.this.myFrame2 = myFrame2;

        //Setting metric scale
        scaleM = myFrame2.scale;
    }

    /**
     * Create Opening object
     *
     * @param parent,        ShapeObject
     * @param myFrame,       ItemFrame
     * @param openingEntity, OpeningEntityObject
     */
    public OpeningObject(ShapeObject parent, ItemFrame myFrame, OpeningEntityObject openingEntity) {

        //Call main constructor
        this();

        //Setting ShapeObject
        this.myParent = parent;
        //Setting ItemFrame
        this.myFrame2 = myFrame;

        //Setting metric scale
        scaleM = myFrame2.scale;

        //Create Opening object
        createOpeningObjectModel(openingEntity);
    }

    public OpeningObject(ShapeObject parent, int wt, int hl, int wtc, int hlc, int shape, int sequence, double startingX,
                         double startingY, int startCol, int endCol, int startRow, int endRow, double bX2, double bY2, double bX3,
                         double bY3, double bX4, double bY4, double dimA1, double dimA2, double dimA3, double dimA4, double dimA5,
                         double dimA0, double dimB1, double dimB2, double dimB3, double dimB4, double dimB5, double dimB0, double dimC1,
                         double dimC2, double dimC3, double dimC4, double dimC5, double dimC0, double dimD1, double dimD2, double dimD3,
                         double dimD4, double dimD5, double dimD0, boolean wire, double centerPointX, double centerPointY, double centerPointX2,
                         double centerPointY2, double radius1, double radius2, double startAngle, double endAngle, double bkgrdStartX,
                         double bkgrdStartY, double centralAngle, double startingCX, double startingCY, double bCX2, double bCY2,
                         double bCX3, double bCY3, double bCX4, double bCY4, boolean topIn, boolean botIn, boolean rightIn, boolean leftIn,
                         int lean, int lean2, int lean3, int lean4, int noSides, int sidesTop, int sidesBot, int sidesLeft, int sidesRight,
                         double parentStartX, double parentStartY, double tm, double bm, double lm, double rm, double ta, double ba,
                         double la, double ra, ItemFrame myframe) {

        //Call main constructor
        this();

        this.myParent = parent;
        this.myFrame2 = myframe;
        this.shapeID = shape;

        this.startingX = startingX;
        this.startingY = startingY;
        this.startCol = startCol;
        this.endCol = endCol;
        this.startRow = startRow;
        this.endRow = endRow;

        this.widthPix = wt;
        this.heightPix = hl;
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

        this.dimTM = tm;
        this.dimBM = bm;
        this.dimLM = lm;
        this.dimRM = rm;
        this.dimTA = ta;
        this.dimBA = ba;
        this.dimLA = la;
        this.dimRA = rm;

        this.topIn = topIn;
        this.botIn = botIn;
        this.leftIn = leftIn;
        this.rightIn = rightIn;

        this.lean = lean;
        this.lean2 = lean2;
        this.lean3 = lean3;
        this.lean4 = lean4;

        this.parentH = myParent.heightPix;
        this.parentW = myParent.widthPix;
        this.parentStartY = parentStartY;
        this.parentStartX = parentStartX;
        this.parentRadius1 = myParent.dimD2;

        this.parentCX = myParent.top1.x1;
        this.parentCY = myParent.top1.y1;
        this.parentCX2 = myParent.top1.x2;
        this.parentCY2 = myParent.top1.y2;
        this.parentShape = myParent.shapeID;
    }

    /**
     * Clone Opening
     *
     * @param original, OpeningObject
     * @return OpeningObject
     */
    public OpeningObject cloneOpening(OpeningObject original) {

        OpeningObject newOpen = this.cloneOpeningShape(original);

        newOpen.contentIn = original.contentIn;
        newOpen.contentMid = original.contentMid;
        newOpen.contentOut = original.contentOut;

        newOpen.openingClass = original.openingClass;
        newOpen.userDefinedOpeningID = original.userDefinedOpeningID;

        //*****************************************************
        //Creating Glass
        //*****************************************************
        if (original.myGlassIn != null) {
            newOpen.myGlassIn = original.myGlassIn.cloneGlass(original.myGlassIn);
        }
        if (original.myGlassMid != null) {
            newOpen.myGlassMid = original.myGlassMid.cloneGlass(original.myGlassMid);
        }
        if (original.myGlassOut != null) {
            newOpen.myGlassOut = original.myGlassOut.cloneGlass(original.myGlassOut);
        }

        //*****************************************************
        //Creating SashType
        //*****************************************************
        if (original.sashObjectIn != null) {
            newOpen.sashObjectIn = original.sashObjectIn.cloneSashType(original.sashObjectIn);
        }
        if (original.sashObjectMid != null) {
            newOpen.sashObjectMid = original.sashObjectMid.cloneSashType(original.sashObjectMid);
        }
        if (original.sashObjectOut != null) {
            newOpen.sashObjectOut = original.sashObjectOut.cloneSashType(original.sashObjectOut);
        }

        //*****************************************************
        //Creating GlazingBeads
        //*****************************************************
        if (original.glazingBeadsMid != null) {
            newOpen.glazingBeadsMid = this.cloneCollections(original.glazingBeadsMid);
        }
        if (original.glazingBeadsIn != null) {
            newOpen.glazingBeadsIn = this.cloneCollections(original.glazingBeadsIn);
        }
        if (original.glazingBeadsOut != null) {
            newOpen.glazingBeadsOut = this.cloneCollections(original.glazingBeadsOut);
        }

        //*****************************************************
        //Creating DLO
        //*****************************************************
        if (original.dloMid != null) {
            newOpen.dloMid = original.dloMid.cloneDLO(original.dloMid);
        }
        if (original.dloIn != null) {
            newOpen.dloIn = original.dloIn.cloneDLO(original.dloIn);
        }
        if (original.dloOut != null) {
            newOpen.dloOut = original.dloOut.cloneDLO(original.dloOut);
        }

        //*****************************************************
        //Creating SubFacet
        //*****************************************************
        if (original.subFacet != null) {
            newOpen.subFacet = original.subFacet.cloneFacet(original.subFacet);
        }


        return newOpen;
    }

    /**
     * Clone Opening Shape object
     *
     * @param original, OpeningObject
     * @return OpeningObject
     */
    public OpeningObject cloneOpeningShape(OpeningObject original) {

        //Creating opening object
        OpeningObject newOV = new OpeningObject(original.myFrame2);

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

        newOV.myParentF = original.myParentF;
        newOV.myFacet = original.myFacet;

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

        // newOV.ellipses = original.ellipses;
        newOV.setLeanTo = original.setLeanTo;

        newOV.minLeg = original.minLeg;
        newOV.wireFrame = original.wireFrame;

        newOV.parentid = original.parentid;
        newOV.parentStartRow = original.parentStartRow;
        newOV.parentStartCol = newOV.parentStartCol;

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

        newOV.top1 = (Top1Object) newOV.top1.cloneProfile(original.top1);
        newOV.top2 = (Top2Object) newOV.top2.cloneProfile(original.top2);
        newOV.top3 = (Top3Object) newOV.top3.cloneProfile(original.top3);
        newOV.right = (RightObject) newOV.right.cloneProfile(original.right);
        newOV.left = (LeftObject) newOV.left.cloneProfile(original.left);
        newOV.bot1 = (Bot1Object) newOV.bot1.cloneProfile(original.bot1);
        newOV.bot2 = (Bot2Object) newOV.bot2.cloneProfile(original.bot2);
        newOV.bot3 = (Bot3Object) newOV.bot3.cloneProfile(original.bot3);

        newOV.top1Part = (Profiles) newOV.top1Part.cloneProfile(original.top1Part);
        newOV.top2Part = (Profiles) newOV.top2Part.cloneProfile(original.top2Part);
        newOV.top3Part = (Profiles) newOV.top3Part.cloneProfile(original.top3Part);
        newOV.rightPart = (Profiles) newOV.rightPart.cloneProfile(original.rightPart);
        newOV.leftPart = (Profiles) newOV.leftPart.cloneProfile(original.leftPart);
        newOV.bot1Part = (Profiles) newOV.bot1Part.cloneProfile(original.bot1Part);
        newOV.bot2Part = (Profiles) newOV.bot2Part.cloneProfile(original.bot2Part);
        newOV.bot3Part = (Profiles) newOV.bot3Part.cloneProfile(original.bot3Part);

        newOV.partObjects = this.cloneCollections(original.partObjects);

        if (original.myMullionBot != null) {
            newOV.myMullionBot = original.myMullionBot.cloneProfile(original.myMullionBot, original.myParent.bOpeningObject);
        }

        if (original.myMullionTop != null) {
            newOV.myMullionTop = original.myMullionTop.cloneProfile(original.myMullionTop, original.myParent.bOpeningObject);
        }

        if (original.myMullionLeft != null) {
            newOV.myMullionLeft = original.myMullionLeft
                    .cloneProfile(original.myMullionLeft, original.myParent.bOpeningObject);
        }

        if (original.myMullionRight != null) {
            newOV.myMullionRight = original.myMullionRight.cloneProfile(original.myMullionRight,
                    original.myParent.bOpeningObject);
        }
        //
        // newOV.findDLO= original.findDLO;
        // newOV.analyseShape= original.analyseShape;
        // newOV.myCanvas= original.myCanvas;
        // newOV.verify= original.verify;
        // newOV.setLeanTo= original.setLeanTo;
        // newOV.createOpenings= original.createOpenings;
        //

        // Cloning Options
        if (original.options != null) {
            Collection newc = new ArrayList();
            Object[] rmp = original.options.toArray();

            for (final Object v : rmp) {
                newc.add(((ShapeOption) v).clone((ShapeOption) v));
            }
            newOV.options = newc;

        }


        newOV.leafNo = original.leafNo;
        newOV.trackNo = original.trackNo;
        newOV.paneType = original.paneType;

        newOV.supplierId = original.supplierId;
        newOV.supplierSeriesId = original.supplierSeriesId;
        newOV.remote = original.remote;

        return newOV;
    }

    /**
     * This method create OpeningObjectModel
     *
     * @param opening, OpeningEntityObject
     */
    private void createOpeningObjectModel(OpeningEntityObject opening) {

        //Shape object model transformation for OpeningObject
        ShapeObjectDTO.getShapeObjectModel(opening, this, OpeningObject.class);
        this.contentIn = opening.getContentIn();
        this.contentMid = opening.getContentMid();
        this.contentOut = opening.getContentOut();

        //*************************************************
        //Creating subFacet
        //*************************************************
        if (opening.getSubFacet() != null) {
            this.subFacet = new Facet(this.myFrame2, this.myFrame2.jobItem, opening.getSubFacet(), this);
        }

        //*************************************************
        //Creating glasses
        //*************************************************
        if (opening.getGlassIn() != null) {
            this.myGlassIn = new GlassSU(this, this.myFrame2, opening.getGlassIn());
        }

        if (opening.getGlassMid() != null) {
            this.myGlassMid = new GlassSU(this, this.myFrame2, opening.getGlassMid());
        }

        if (opening.getGlassOut() != null) {
            this.myGlassOut = new GlassSU(this, this.myFrame2, opening.getGlassOut());
        }

        //*************************************************
        //Creating sash type
        //*************************************************
        if (opening.getSashTypeIn() != null) {
            this.sashObjectIn = new SashTypeObject(this, this.myFrame2, opening.getSashTypeIn());
        }

        if (opening.getSashTypeMid() != null) {
            this.sashObjectMid = new SashTypeObject(this, this.myFrame2, opening.getSashTypeMid());
        }

        if (opening.getSashTypeOut() != null) {
            this.sashObjectOut = new SashTypeObject(this, this.myFrame2, opening.getSashTypeOut());
        }

        //*************************************************
        //Creating glazing beads
        //*************************************************
        if (opening.getGlazingBeads() != null && !opening.getGlazingBeads().isEmpty()) {

            //Initialize glazing beads arraylist
            this.glazingBeadsIn = new ArrayList();
            this.glazingBeadsMid = new ArrayList();
            this.glazingBeadsOut = new ArrayList();

            for (ProfileGlazingBeadsEntityObject glazingBeadsEntity : opening.getGlazingBeads()) {

                //Creating Profile parts
                ProfileParts profilePart = new Profiles(this.myFrame2);
                ProfileDTO.createProfiles(profilePart, glazingBeadsEntity);
                ConstructionMapDTO.copyConstructionMap(profilePart, this);

                //Setting parent Object Opening
                profilePart.myParent = this;
                profilePart.myFrame2 = this.myFrame2;

                if (glazingBeadsEntity.getLocation() == GlazingBeadsLocations.IN.getValue()) {
                    this.glazingBeadsIn.add(profilePart);
                }

                if (glazingBeadsEntity.getLocation() == GlazingBeadsLocations.MID.getValue()) {
                    this.glazingBeadsMid.add(profilePart);
                }

                if (glazingBeadsEntity.getLocation() == GlazingBeadsLocations.OUT.getValue()) {
                    this.glazingBeadsOut.add(profilePart);
                }
            }

            CreateShapeMethods createShape = new CreateShapeMethods(this, 2, myFrame2);
            if (this.glazingBeadsIn != null && !this.glazingBeadsIn.isEmpty()) {
                this.glazingBeadsIn = createShape.doGPParts(this.glazingBeadsIn, this, this.glazedOut);
            }

            if (this.glazingBeadsMid != null && !this.glazingBeadsMid.isEmpty()) {
                this.glazingBeadsMid = createShape.doGPParts(this.glazingBeadsMid, this, this.glazedOut);
            }

            if (this.glazingBeadsOut != null && !this.glazingBeadsOut.isEmpty()) {
                this.glazingBeadsOut = createShape.doGPParts(this.glazingBeadsOut, this, this.glazedOut);
            }
        }

        if (opening.getGlazingBeadIn() != null) {
            this.glazingBeadIn = new GlazingBeads(this, this.myFrame2, opening.getGlazingBeadIn());
            this.glazingBeadsIn = this.glazingBeadIn.partObjects;
        }

        if (opening.getGlazingBeadMid() != null) {
            this.glazingBeadMid = new GlazingBeads(this, this.myFrame2, opening.getGlazingBeadMid());
            this.glazingBeadsMid = this.glazingBeadMid.partObjects;
        }

        if (opening.getGlazingBeadOut() != null) {
            this.glazingBeadOut = new GlazingBeads(this, this.myFrame2, opening.getGlazingBeadOut());
            this.glazingBeadsOut = this.glazingBeadOut.partObjects;
        }

        //*************************************************
        //Creating DLO
        //*************************************************
        if (opening.getDloIn() != null) {
            this.dloIn = new DLO(this.myFrame2, opening.getDloIn(), this);
            if (myGlassIn != null) {
                this.dloIn.myParentGlass = myGlassIn;
                this.dloIn.myParentO = myGlassIn.myParentO;
                this.dloIn.myParent = myGlassIn.myParentO.myParent;
            }
        }

        if (opening.getDloMid() != null) {
            this.dloMid = new DLO(this.myFrame2, opening.getDloMid(), this);
            if (myGlassMid != null) {
                this.dloMid.myParentGlass = myGlassMid;
                this.dloMid.myParentO = myGlassMid.myParentO;
                this.dloMid.myParent = myGlassMid.myParentO.myParent;
            }
        }

        if (opening.getDloOut() != null) {
            this.dloOut = new DLO(this.myFrame2, opening.getDloOut(), this);
            if (myGlassOut != null) {
                this.dloOut.myParentGlass = myGlassOut;
                this.dloOut.myParentO = myGlassOut.myParentO;
                this.dloOut.myParent = myGlassOut.myParentO.myParent;
            }
        }

        if (opening.getOpeningsObject() != null && !opening.getOpeningsObject().isEmpty()) {
            this.openings = new ArrayList();
            for (OpeningEntityObject op : opening.getOpeningsObject()) {
                this.openings.add(new OpeningObject(this, this.myFrame2, op));
            }
        }

        //*******************************************************
        //Do GeneralPath Opening
        //*******************************************************
        CreateOpenings createOpening = new CreateOpenings(this, myFrame2);
        this.gp = createOpening.doGeneralPathMainOpening(this);
    }

    /**
     * This method creating OpeningEntityObject from model design
     *
     * @param facet,    FacetEntityObject
     * @param subFacet, SubFacetEntityObject
     * @param frame,    FrameEntityObject
     * @param sashLeaf, SashLeafEntityObject
     * @return OpeningEntityObject
     */
    public OpeningEntityObject createOpeningEntityObject(FacetEntityObject facet, SubFacetEntityObject subFacet,
                                                         FrameEntityObject frame, SashLeafEntityObject sashLeaf) {

        //Returning object transformation
        OpeningEntityObject opening = (OpeningEntityObject) ShapeObjectDTO.getShapeAbstractObject(this, OpeningEntityObject.class);
        opening.setContentIn(this.contentIn);
        opening.setContentMid(this.contentMid);
        opening.setContentOut(this.contentOut);

        //*************************************************
        //Creating subFacet
        //*************************************************
        if (this.subFacet != null) {
            opening.setSubFacet(this.subFacet.createSubFacetEntityObject());
        }

        //*************************************************
        //Creating glasses
        //*************************************************
        if (this.myGlassIn != null) {
            opening.setGlassIn(this.myGlassIn.createGlassSUEntityObject());
        }

        if (this.myGlassMid != null) {
            opening.setGlassMid(this.myGlassMid.createGlassSUEntityObject());
        }

        if (this.myGlassOut != null) {
            opening.setGlassOut(this.myGlassOut.createGlassSUEntityObject());
        }

        //*************************************************
        //Creating sash type
        //*************************************************
        if (this.sashObjectIn != null) {
            opening.setSashTypeIn(this.sashObjectIn.createSashTypeEntityObject());
        }

        if (this.sashObjectMid != null) {
            opening.setSashTypeMid(this.sashObjectMid.createSashTypeEntityObject());
        }

        if (this.sashObjectOut != null) {
            opening.setSashTypeOut(this.sashObjectOut.createSashTypeEntityObject());
        }

        //*************************************************
        //Creating glazing beads
        //*************************************************
        Set<ProfileGlazingBeadsEntityObject> glazingBeads = new HashSet<ProfileGlazingBeadsEntityObject>();

        if (this.glazingBeadsIn != null && !this.glazingBeadsIn.isEmpty()) {
            Object[] rmp = this.glazingBeadsIn.toArray();
            for (Object v : rmp) {
                Profiles glazingBead = (Profiles) v;
                ProfileGlazingBeadsEntityObject profileGlazingBead = (ProfileGlazingBeadsEntityObject) ProfileDTO.
                        getProfileAbstractObject(glazingBead, ProfileGlazingBeadsEntityObject.class, 0, null);
                profileGlazingBead.setLocation(GlazingBeadsLocations.IN.getValue());
                glazingBeads.add(profileGlazingBead);
            }
        }

        if (this.glazingBeadsMid != null && !this.glazingBeadsMid.isEmpty()) {
            Object[] rmp = this.glazingBeadsMid.toArray();
            for (Object v : rmp) {
                Profiles glazingBead = (Profiles) v;
                ProfileGlazingBeadsEntityObject profileGlazingBead = (ProfileGlazingBeadsEntityObject) ProfileDTO.
                        getProfileAbstractObject(glazingBead, ProfileGlazingBeadsEntityObject.class, 0, null);
                profileGlazingBead.setLocation(GlazingBeadsLocations.MID.getValue());
                glazingBeads.add(profileGlazingBead);
            }
        }

        if (this.glazingBeadsOut != null && !this.glazingBeadsOut.isEmpty()) {
            Object[] rmp = this.glazingBeadsOut.toArray();
            for (Object v : rmp) {
                Profiles glazingBead = (Profiles) v;
                ProfileGlazingBeadsEntityObject profileGlazingBead = (ProfileGlazingBeadsEntityObject) ProfileDTO.
                        getProfileAbstractObject(glazingBead, ProfileGlazingBeadsEntityObject.class, 0, null);
                profileGlazingBead.setLocation(GlazingBeadsLocations.OUT.getValue());
                glazingBeads.add(profileGlazingBead);
            }
        }

        //Setting glazing beads
        opening.setGlazingBeads(glazingBeads);

        if (this.glazingBeadIn != null) {
            opening.setGlazingBeadIn(this.glazingBeadIn.createGlazingBeadsEntityObject(opening,
                    GlazingBeadsLocations.IN.getValue()));
        }

        if (this.glazingBeadMid != null) {
            opening.setGlazingBeadMid(this.glazingBeadMid.createGlazingBeadsEntityObject(opening,
                    GlazingBeadsLocations.MID.getValue()));
        }

        if (this.glazingBeadOut != null) {
            opening.setGlazingBeadOut(this.glazingBeadOut.createGlazingBeadsEntityObject(opening,
                    GlazingBeadsLocations.OUT.getValue()));
        }

        //*************************************************
        //Creating DLO
        //*************************************************
        if (this.dloIn != null) {
            opening.setDloIn(this.dloIn.createDLOEntityObject());
        }

        if (this.dloMid != null) {
            opening.setDloMid(this.dloMid.createDLOEntityObject());
        }

        if (this.dloOut != null) {
            opening.setDloOut(this.dloOut.createDLOEntityObject());
        }

        //********************************************************
        // Creating Openings objects
        //********************************************************
        if (!this.openings.isEmpty()) {
            Set<OpeningEntityObject> openings = new HashSet<OpeningEntityObject>();
            Object[] rmp = this.openings.toArray();
            for (Object v : rmp) {
                OpeningObject op = (OpeningObject) v;
                openings.add(op.createOpeningEntityObject(null, null, null, null));
            }
            opening.setOpeningsObject(openings);
        }

        return opening;
    }

    /**
     * This method create a copy of javabeans with a clone of properties values
     *
     * @param openingEntity, OpeningEntityObject
     * @return OpeningEntityObject
     */
    public OpeningEntityObject cloneObjectModel(OpeningEntityObject openingEntity) {

		/* Clone Opening Entity Object */
        OpeningEntityObject opening = (OpeningEntityObject) ShapeObjectDTO.cloneShapeAbstractObject(openingEntity,
                OpeningEntityObject.class);

        opening.setMyMullions(null);
        opening.setSubFacet(null);
        opening.setGlassIn(null);
        opening.setGlassMid(null);
        opening.setGlassOut(null);
        opening.setSashTypeIn(null);
        opening.setSashTypeMid(null);
        opening.setSashTypeOut(null);
        opening.setGlazingBeads(null);
        opening.setDloIn(null);
        opening.setDloMid(null);
        opening.setDloOut(null);
        opening.setOpeningsObject(null);

		/* Clone my mullions collection */
        Hibernate.initialize(openingEntity.getMyMullions());
        if (openingEntity.getMyMullions() != null && !openingEntity.getMyMullions().isEmpty()) {
            Set<ProfileMyMullionObject> myMullions = new HashSet<ProfileMyMullionObject>();

            for (ProfileMyMullionObject myMullionObject : openingEntity.getMyMullions()) {
                ProfileMyMullionObject myMullion = (ProfileMyMullionObject) ProfileDTO.cloneProfileAbstractObject(myMullionObject,
                        ProfileMyMullionObject.class);
                myMullion.set_part_object(myMullionObject.get_part_object());

                myMullions.add(myMullion);
            }

            opening.setMyMullions(myMullions);
        }

		/* Clone subFacet */
        Hibernate.initialize(openingEntity.getSubFacet());
        if (openingEntity.getSubFacet() != null) {
            Facet facet = new Facet();
            facet.cloneSubFacetObjectModel(openingEntity.getSubFacet());
        }

		/* Clone glasses */
        GlassSU glassSU = new GlassSU();

        Hibernate.initialize(openingEntity.getGlassIn());
        if (openingEntity.getGlassIn() != null) {
            opening.setGlassIn(glassSU.cloneObjectModel(openingEntity.getGlassIn()));
        }

        Hibernate.initialize(openingEntity.getGlassMid());
        if (openingEntity.getGlassMid() != null) {
            opening.setGlassMid(glassSU.cloneObjectModel(openingEntity.getGlassMid()));
        }

        Hibernate.initialize(openingEntity.getGlassOut());
        if (openingEntity.getGlassOut() != null) {
            opening.setGlassOut(glassSU.cloneObjectModel(openingEntity.getGlassOut()));
        }

		/* Clone sash type */
        SashTypeObject sashType = new SashTypeObject();

        Hibernate.initialize(openingEntity.getSashTypeIn());
        if (openingEntity.getSashTypeIn() != null) {
            opening.setSashTypeIn(sashType.cloneObjectModel(openingEntity.getSashTypeIn()));
        }

        Hibernate.initialize(openingEntity.getSashTypeMid());
        if (openingEntity.getSashTypeMid() != null) {
            opening.setSashTypeMid(sashType.cloneObjectModel(openingEntity.getSashTypeMid()));
        }

        Hibernate.initialize(openingEntity.getSashTypeOut());
        if (openingEntity.getSashTypeOut() != null) {
            opening.setSashTypeOut(sashType.cloneObjectModel(openingEntity.getSashTypeOut()));
        }

		/* Clone glazing beads */
        Hibernate.initialize(openingEntity.getGlazingBeads());
        if (openingEntity.getGlazingBeads() != null && !openingEntity.getGlazingBeads().isEmpty()) {
            Set<ProfileGlazingBeadsEntityObject> glazingBeadsCollection = new HashSet<ProfileGlazingBeadsEntityObject>();

            for (ProfileGlazingBeadsEntityObject profileGlazingEntity : openingEntity.getGlazingBeads()) {
                ProfileGlazingBeadsEntityObject glazingBeads = (ProfileGlazingBeadsEntityObject) ProfileDTO.
                        cloneProfileAbstractObject(profileGlazingEntity, ProfileGlazingBeadsEntityObject.class);
                glazingBeads.setLocation(profileGlazingEntity.getLocation());

                glazingBeadsCollection.add(glazingBeads);
            }

            opening.setGlazingBeads(glazingBeadsCollection);
        }

		/* Clone dlo */
        DLO dlo = new DLO();

        Hibernate.initialize(openingEntity.getDloIn());
        if (openingEntity.getDloIn() != null) {
            opening.setDloIn(dlo.cloneObjectModel(openingEntity.getDloIn()));
        }

        Hibernate.initialize(openingEntity.getDloMid());
        if (openingEntity.getDloMid() != null) {
            opening.setDloMid(dlo.cloneObjectModel(openingEntity.getDloMid()));
        }

        Hibernate.initialize(openingEntity.getDloOut());
        if (openingEntity.getDloOut() != null) {
            opening.setDloOut(dlo.cloneObjectModel(openingEntity.getDloOut()));
        }

        /* Clone Openings */
        Hibernate.initialize(openingEntity.getOpeningsObject());
        if (openingEntity.getOpeningsObject() != null && !openingEntity.getOpeningsObject().isEmpty()) {
            Set<OpeningEntityObject> openings = new HashSet<OpeningEntityObject>();

            OpeningObject openingObject = new OpeningObject();
            for (OpeningEntityObject object : openingEntity.getOpeningsObject()) {
                openings.add(openingObject.cloneObjectModel(object));
            }

            opening.setOpeningsObject(openings);
        }

        if (!this.openings.isEmpty()) {
            Set<OpeningEntityObject> openings = new HashSet<OpeningEntityObject>();
            Object[] rmp = this.openings.toArray();
            for (Object v : rmp) {
                OpeningObject op = (OpeningObject) v;
                openings.add(op.createOpeningEntityObject(null, null, null, null));
            }
            opening.setOpeningsObject(openings);
        }

        return opening;
    }

    /**
     * Reset Glass Bom Collection
     *
     * @throws Exception, Exception
     */
    public void resetGlassBom() throws Exception {

        //******************************************************************
        // Reset Glass Bom for SubFacet
        //******************************************************************
        if (this.subFacet != null) {
            this.subFacet.resetGlassBom();
        }

        //******************************************************************
        // Reset Glass Bom for Glasses
        //******************************************************************
        if (this.myGlassIn != null) {
            this.myGlassIn.gridID = this.dloIn.gridID;
            this.myGlassIn.gridType = this.dloIn.gridType;
            this.myGlassIn.noGridsV = this.dloIn.noGridsV;
            this.myGlassIn.noGridsH = this.dloIn.noGridsH;
            this.myGlassIn.noGridsR = this.dloIn.noGridsR;
            this.myGlassIn.noGridsS = this.dloIn.noGridsS;

            this.myGlassIn.resetGlassBom();
        }

        if (this.myGlassMid != null) {
            this.myGlassMid.gridID = this.dloMid.gridID;
            this.myGlassMid.gridType = this.dloMid.gridType;
            this.myGlassMid.noGridsV = this.dloMid.noGridsV;
            this.myGlassMid.noGridsH = this.dloMid.noGridsH;
            this.myGlassMid.noGridsR = this.dloMid.noGridsR;
            this.myGlassMid.noGridsS = this.dloMid.noGridsS;

            this.myGlassMid.resetGlassBom();
        }

        if (this.myGlassOut != null) {
            this.myGlassOut.gridID = this.dloOut.gridID;
            this.myGlassOut.gridType = this.dloOut.gridType;
            this.myGlassOut.noGridsV = this.dloOut.noGridsV;
            this.myGlassOut.noGridsH = this.dloOut.noGridsH;
            this.myGlassOut.noGridsR = this.dloOut.noGridsR;
            this.myGlassOut.noGridsS = this.dloOut.noGridsS;

            this.myGlassOut.resetGlassBom();
        }

        //******************************************************************
        // Reset Glass Bom for Sash Type
        //******************************************************************
        if (this.sashObjectIn != null) {
            this.sashObjectIn.resetGlassBom();
        }

        if (this.sashObjectMid != null) {
            this.sashObjectMid.resetGlassBom();
        }

        if (this.sashObjectOut != null) {
            this.sashObjectOut.resetGlassBom();
        }

        //******************************************************************
        // Reset Glass Bom for Openings
        //******************************************************************
        if (!this.openings.isEmpty()) {
            for (Object v : this.openings) {
                ((OpeningObject) v).resetGlassBom();
            }
        }
    }

    /**
     * Reset Grids Bom Collection
     *
     * @throws Exception, Exception
     */
    public void resetGridsBom() throws Exception {

        //******************************************************************
        // Reset Glass Bom for SubFacet
        //******************************************************************
        if (this.subFacet != null) {
            this.subFacet.resetGridsBom();
        }

        //******************************************************************
        // Reset Glass Bom for Glasses
        //******************************************************************
        if (this.dloIn != null) {
            this.dloIn.resetGridsBom(this);
        }

        if (this.dloMid != null) {
            this.dloMid.resetGridsBom(this);
        }

        if (this.dloOut != null) {
            this.dloOut.resetGridsBom(this);
        }

        //******************************************************************
        // Reset Glass Bom for Sash Type
        //******************************************************************
        if (this.sashObjectIn != null) {
            this.sashObjectIn.resetGridsBom();
        }

        if (this.sashObjectMid != null) {
            this.sashObjectMid.resetGridsBom();
        }

        if (this.sashObjectOut != null) {
            this.sashObjectOut.resetGridsBom();
        }

        //******************************************************************
        // Reset Glass Bom for Openings
        //******************************************************************
        if (!this.openings.isEmpty()) {
            for (Object v : this.openings) {
                ((OpeningObject) v).resetGridsBom();
            }
        }
    }

    /**
     * This method return a Glass SU from his child Design Glass BOM
     *
     * @param designGlass, DesignGlass
     * @return ShapeObject
     * @throws Exception, Exception
     */
    public GlassSU getGlassSU(DesignGlass designGlass) throws Exception {

        GlassSU glassSU = null;

        //******************************************************************
        // Reset Glass Bom for SubFacet
        //******************************************************************
        if (this.subFacet != null) {
            GlassSU glass = this.subFacet.getGlassSU(designGlass);
            if (glass != null) {
                glassSU = glass;
            }
        }

        //******************************************************************
        // Reset Glass Bom for Glasses
        //******************************************************************
        if (this.myGlassIn != null) {
            GlassSU glass = this.myGlassIn.isForGlassSU(designGlass);
            if (glass != null) {
                glassSU = glass;
            }
        }

        if (this.myGlassMid != null) {
            GlassSU glass = this.myGlassMid.isForGlassSU(designGlass);
            if (glass != null) {
                glassSU = glass;
            }
        }

        if (this.myGlassOut != null) {
            GlassSU glass = this.myGlassOut.isForGlassSU(designGlass);
            if (glass != null) {
                glassSU = glass;
            }
        }

        //******************************************************************
        // Reset Glass Bom for Sash Type
        //******************************************************************
        if (this.sashObjectIn != null) {
            GlassSU glass = this.sashObjectIn.getGlassSU(designGlass);
            if (glass != null) {
                glassSU = glass;
            }
        }

        if (this.sashObjectMid != null) {
            GlassSU glass = this.sashObjectMid.getGlassSU(designGlass);
            if (glass != null) {
                glassSU = glass;
            }
        }

        if (this.sashObjectOut != null) {
            GlassSU glass = this.sashObjectOut.getGlassSU(designGlass);
            if (glass != null) {
                glassSU = glass;
            }
        }

        //******************************************************************
        // Reset Glass Bom for Openings
        //******************************************************************
        if (!this.openings.isEmpty()) {
            for (Object v : this.openings) {
                GlassSU glass = ((OpeningObject) v).getGlassSU(designGlass);
                if (glass != null) {
                    glassSU = glass;
                }
            }
        }

        return glassSU;
    }

    /**
     * Reset Shapes Notes Collection
     *
     * @throws Exception, Exception
     */
    public void resetShapeNotes() throws Exception {

        //Add ShapeObject notes to collection
        this.myFrame2.jobItem.shapeNotes.addAll(this.notes);

        //Reset Shapes notes for SubFacet
        if (this.subFacet != null) {
            this.subFacet.resetShapeNotes();
        }

        //Reset Shapes notes for Glasses
        if (this.myGlassIn != null) {
            this.myGlassIn.resetShapeNotes();
        }

        if (this.myGlassMid != null) {
            this.myGlassMid.resetShapeNotes();
        }

        if (this.myGlassOut != null) {
            this.myGlassOut.resetShapeNotes();
        }

        //Reset Shapes notes for SashObject
        if (this.sashObjectIn != null) {
            this.sashObjectIn.resetShapeNotes();
        }

        if (this.sashObjectMid != null) {
            this.sashObjectMid.resetShapeNotes();
        }

        if (this.sashObjectOut != null) {
            this.sashObjectOut.resetShapeNotes();
        }

        //Reset Shape notes for Openings
        if (!this.openings.isEmpty()) {
            for (Object v : this.openings) {
                ((OpeningObject) v).resetShapeNotes();
            }
        }
    }

    //**********************************************************************************************
    //Implementing methods for Matrix calculation
    //**********************************************************************************************
    public OpeningObject cloneOpeningFromBkgrdO(OpeningObject newO, BkgrdOpeningObject bkgrdO) {

        newO.rID = bkgrdO.myParent.rID;
        newO.myFrame2 = bkgrdO.myParent.myFrame2;

        newO.myParent = bkgrdO.myParent;

        newO.shapeID = bkgrdO.myParent.shapeID;
        newO.a_sequenceID = bkgrdO.myParent.a_sequenceID;

        newO.a_1Level = bkgrdO.myParent.a_assemblyLevel;
        newO.a_1Sequence = bkgrdO.myParent.a_sequenceID;
        newO.a_2Level = bkgrdO.myParent.a_1Level;
        newO.a_2Sequence = bkgrdO.myParent.a_1Sequence;
        newO.a_3Level = bkgrdO.myParent.a_2Level;
        newO.a_3Sequence = bkgrdO.myParent.a_2Sequence;
        newO.a_4Level = bkgrdO.myParent.a_3Level;
        newO.a_4Sequence = bkgrdO.myParent.a_3Sequence;

        newO.a_5Level = bkgrdO.myParent.a_4Level;
        newO.a_5Sequence = bkgrdO.myParent.a_4Sequence;
        newO.a_6Level = bkgrdO.myParent.a_5Level;
        newO.a_6Sequence = bkgrdO.myParent.a_5Sequence;
        newO.a_7Level = bkgrdO.myParent.a_6Level;
        newO.a_7Sequence = bkgrdO.myParent.a_6Sequence;
        newO.a_8Level = bkgrdO.myParent.a_7Level;
        newO.a_8Sequence = bkgrdO.myParent.a_7Sequence;
        newO.a_9Level = bkgrdO.myParent.a_8Level;
        newO.a_9Sequence = bkgrdO.myParent.a_8Sequence;
        newO.a_10Level = bkgrdO.myParent.a_9Level;
        newO.a_10Sequence = bkgrdO.myParent.a_9Sequence;

        newO.a_11Level = bkgrdO.myParent.a_10Level;
        newO.a_11Sequence = bkgrdO.myParent.a_10Sequence;
        newO.a_12Level = bkgrdO.myParent.a_11Level;
        newO.a_12Sequence = bkgrdO.myParent.a_11Sequence;
        newO.a_13Level = bkgrdO.myParent.a_12Level;
        newO.a_13Sequence = bkgrdO.myParent.a_12Sequence;
        newO.a_14Level = bkgrdO.myParent.a_13Level;
        newO.a_15Sequence = bkgrdO.myParent.a_13Sequence;
        newO.a_15Level = bkgrdO.myParent.a_14Level;
        newO.a_15Sequence = bkgrdO.myParent.a_14Sequence;
        newO.a_16Level = bkgrdO.myParent.a_15Level;
        newO.a_16Sequence = bkgrdO.myParent.a_15Sequence;
        newO.a_17Level = bkgrdO.myParent.a_16Level;
        newO.a_17Sequence = bkgrdO.myParent.a_16Sequence;
        newO.a_18Level = bkgrdO.myParent.a_17Level;
        newO.a_18Sequence = bkgrdO.myParent.a_17Sequence;
        newO.a_19Level = bkgrdO.myParent.a_18Level;
        newO.a_19Sequence = bkgrdO.myParent.a_18Sequence;
        newO.a_20Level = bkgrdO.myParent.a_19Level;
        newO.a_20Sequence = bkgrdO.myParent.a_19Sequence;
        newO.a_21Level = bkgrdO.myParent.a_20Level;
        newO.a_21Sequence = bkgrdO.myParent.a_20Sequence;
        newO.a_22Level = bkgrdO.myParent.a_21Level;
        newO.a_22Sequence = bkgrdO.myParent.a_21Sequence;

        newO.myFacet = bkgrdO.myParent.myFacet;

        newO.myParentF = bkgrdO.myParentF;

        newO.widthPix = bkgrdO.widthPix;
        newO.heightPix = bkgrdO.heightPix;

        newO.widthM = bkgrdO.widthM;
        newO.heightM = bkgrdO.heightM;
        newO.widthMN = bkgrdO.widthMN;
        newO.heightMN = bkgrdO.heightMN;
        newO.widthMO = bkgrdO.widthMO;
        newO.heightMO = bkgrdO.heightMO;
        newO.widthI = bkgrdO.widthI;
        newO.heightI = bkgrdO.heightI;
        newO.widthIN = bkgrdO.widthIN;
        newO.heightIN = bkgrdO.heightIN;
        newO.widthIO = bkgrdO.widthIO;
        newO.heightIO = bkgrdO.heightIO;

        newO.highestX = bkgrdO.highestX;
        newO.lowestX = bkgrdO.lowestX;
        newO.highestY = bkgrdO.highestY;
        newO.lowestY = bkgrdO.lowestY;
        newO.highestYC = bkgrdO.highestYC;

        newO.lowestYC = bkgrdO.lowestYC;
        newO.startCol = bkgrdO.startCol;
        newO.glazedOut = bkgrdO.glazedOut;
        newO.endCol = bkgrdO.endCol;
        newO.startRow = bkgrdO.startRow;
        newO.endRow = bkgrdO.endRow;

        newO.noPartsTop1 = bkgrdO.noPartsTop1;
        newO.noPartsTop2 = bkgrdO.noPartsTop2;
        newO.noPartsTop3 = bkgrdO.noPartsTop3;
        newO.noPartsBot1 = bkgrdO.noPartsBot1;
        newO.noPartsBot2 = bkgrdO.noPartsBot2;
        newO.noPartsBot3 = bkgrdO.noPartsBot3;
        newO.noPartsLeft = bkgrdO.noPartsLeft;
        newO.noPartsRight = bkgrdO.noPartsRight;

        newO.isNewFrame = bkgrdO.isNewFrame;

        newO.newRowH = bkgrdO.newRowH;

        newO.myFrame2 = bkgrdO.myFrame2;

        newO.newDesign = bkgrdO.newDesign;

        newO.leafNo = bkgrdO.leafNo;

        newO.trackNo = bkgrdO.trackNo;

        newO.paneType = bkgrdO.paneType;

        newO.frameStartCol = bkgrdO.frameStartCol;
        newO.frameStartRow = bkgrdO.frameStartRow;
        newO.frameEndCol = bkgrdO.frameEndCol;
        newO.frameEndRow = bkgrdO.frameEndRow;
        newO.myRow = bkgrdO.myRow;
        newO.myCol = bkgrdO.myCol;
        newO.myShapeID = bkgrdO.myShapeID;
        newO.myPrevShape = bkgrdO.myPrevShape;
        newO.myNewShape = bkgrdO.myNewShape;
        newO.myOpeningID = bkgrdO.myOpeningID;
        newO.mynewOpeningID = bkgrdO.mynewOpeningID;
        newO.mynewOpenindType = bkgrdO.mynewOpenindType;
        newO.newWidthTop = bkgrdO.newWidthTop;
        newO.newWidthBot = bkgrdO.newWidthBot;
        newO.newStartingY = bkgrdO.newStartingY;
        newO.newStartingX = bkgrdO.newStartingX;
        newO.newHL = bkgrdO.newHL;
        newO.newHR = bkgrdO.newHR;
        newO.newstartX = bkgrdO.newstartX;
        newO.newendX = bkgrdO.newendX;
        newO.newstartY = bkgrdO.newstartY;
        newO.newendY = bkgrdO.newendY;

        newO.newDimD2 = bkgrdO.newDimD2;
        newO.newDimB1 = bkgrdO.newDimB1;

        newO.rowColToAdd = bkgrdO.rowColToAdd;
        newO.addRow = bkgrdO.addRow;

        newO.dividedCentral = bkgrdO.dividedCentral;
        newO.myCouplerThickness = bkgrdO.myCouplerThickness;

        // newOV.ellipses = myNewOpening.ellipses;
        newO.setLeanTo = bkgrdO.setLeanTo;

        newO.minLeg = bkgrdO.minLeg;
        newO.wireFrame = bkgrdO.wireFrame;

        newO.parentid = bkgrdO.parentid;
        newO.parentStartRow = bkgrdO.parentStartRow;
        newO.parentStartCol = bkgrdO.parentStartCol;

        newO.startingXBA = bkgrdO.startingXBA;
        newO.startingYBA = bkgrdO.startingYBA;

        newO.startingXA = bkgrdO.startingXA;
        newO.startingYA = bkgrdO.startingYA;
        newO.bX2A = bkgrdO.bX2A;
        newO.bY2A = bkgrdO.bY2A;
        newO.bX3A = bkgrdO.bX3A;
        newO.bY3A = bkgrdO.bX3A;

        newO.bX4A = bkgrdO.bX4A;
        newO.bY4A = bkgrdO.bY4A;
        newO.bX2B = bkgrdO.bX2B;
        newO.bY2B = bkgrdO.bY2B;
        newO.bX3B = bkgrdO.bX3B;
        newO.bY3B = bkgrdO.bY3B;
        newO.bX4B = bkgrdO.bX4B;
        newO.bY4B = bkgrdO.bY4B;
        newO.openingW = bkgrdO.openingW;
        newO.openingH = bkgrdO.openingH;
        newO.openingWc = bkgrdO.openingWc;
        newO.openingHc = bkgrdO.openingHc;
        newO.openingWB = bkgrdO.openingWB;
        newO.openingHR = bkgrdO.openingHR;
        newO.openingWcB = bkgrdO.openingWcB;
        newO.openingHcR = bkgrdO.openingHcR;
        newO.openingWA = bkgrdO.openingWA;
        newO.openingHA = bkgrdO.openingHA;
        newO.openingWBA = bkgrdO.openingWBA;
        newO.openingHRA = bkgrdO.openingHRA;
        newO.dimTM = bkgrdO.dimTM;
        newO.dimBM = bkgrdO.dimBM;
        newO.dimLM = bkgrdO.dimLM;
        newO.dimRM = bkgrdO.dimRM;
        newO.dimTA = bkgrdO.dimTA;
        newO.dimBA = bkgrdO.dimBA;
        newO.dimLA = bkgrdO.dimLA;
        newO.dimRA = bkgrdO.dimRA;
        newO.a_sequenceID = bkgrdO.a_sequenceID;
        newO.lastSeq = bkgrdO.lastSeq;
        newO.xCols = bkgrdO.xCols;
        newO.yRows = bkgrdO.yRows;
        newO.noTracks = bkgrdO.noTracks;
        newO.openOut = bkgrdO.openOut;

        newO.radius1A = bkgrdO.radius1A;
        newO.radius2A = bkgrdO.radius2A;
        newO.startAngleA = bkgrdO.startAngleA;
        newO.endAngleA = bkgrdO.endAngleA;
        newO.bkgrdStartXA = bkgrdO.bkgrdStartXA;
        newO.bkgrdStartYA = bkgrdO.bkgrdStartYA;
        newO.centralAngleA = bkgrdO.centralAngleA;
        newO.px1 = bkgrdO.px1;
        newO.py1 = bkgrdO.py1;
        newO.px2 = bkgrdO.px2;
        newO.py2 = bkgrdO.py2;
        newO.px3 = bkgrdO.px3;
        newO.py3 = bkgrdO.py3;
        newO.px4 = bkgrdO.px4;
        newO.py4 = bkgrdO.py4;
        newO.px5 = bkgrdO.px5;
        newO.py5 = bkgrdO.py5;
        newO.px6 = bkgrdO.px6;
        newO.py6 = bkgrdO.py6;
        newO.px7 = bkgrdO.px7;
        newO.py7 = bkgrdO.py7;
        newO.px8 = bkgrdO.px8;
        newO.py8 = bkgrdO.py8;
        newO.px1A = bkgrdO.px1A;
        newO.py1A = bkgrdO.py1A;
        newO.px2A = bkgrdO.px2A;
        newO.py2A = bkgrdO.py2A;
        newO.px3A = bkgrdO.px3A;
        newO.py3A = bkgrdO.py3A;
        newO.px4A = bkgrdO.px4A;
        newO.py4A = bkgrdO.py4A;
        newO.px5A = bkgrdO.px5A;
        newO.py5A = bkgrdO.py5A;
        newO.px6A = bkgrdO.px6A;
        newO.py6A = bkgrdO.py6A;
        newO.px7A = bkgrdO.px7A;
        newO.py7A = bkgrdO.py7A;
        newO.px8A = bkgrdO.px8A;
        newO.py8A = bkgrdO.py8A;
        newO.px1c = bkgrdO.px1c;
        newO.py1c = bkgrdO.py1c;
        newO.px2c = bkgrdO.px2c;
        newO.py2c = bkgrdO.py2c;
        newO.px3c = bkgrdO.px3c;
        newO.py3c = bkgrdO.py3c;
        newO.px4c = bkgrdO.px4c;
        newO.py4c = bkgrdO.py4c;
        newO.px5c = bkgrdO.px5c;
        newO.py5c = bkgrdO.py5c;
        newO.px6c = bkgrdO.px6c;
        newO.py6c = bkgrdO.py6c;
        newO.px7c = bkgrdO.px7c;
        newO.py7c = bkgrdO.py7c;
        newO.px8c = bkgrdO.px8c;
        newO.py8c = bkgrdO.py8c;

        newO.hasSash = bkgrdO.hasSash;
        newO.unGlazed = bkgrdO.unGlazed;
        newO.openingClass = bkgrdO.openingClass;
        newO.userDefinedOpeningID = bkgrdO.userDefinedOpeningID;
        newO.outSash = bkgrdO.outSash;
        newO.inSash = bkgrdO.inSash;
        newO.midSash = bkgrdO.midSash;
        newO.myGlass = bkgrdO.myGlass;
        newO.outSashTracks = bkgrdO.outSashTracks;
        newO.inSashTracks = bkgrdO.inSashTracks;
        newO.midSashTracks = bkgrdO.midSashTracks;

        newO.id = bkgrdO.id;
        newO.rID = bkgrdO.rID;

        newO.openIn = bkgrdO.openIn;
        newO.lean = bkgrdO.lean;
        newO.lean2 = bkgrdO.lean2;
        newO.lean3 = bkgrdO.lean3;
        newO.lean4 = bkgrdO.lean4;
        newO.noSides = bkgrdO.noSides;
        newO.noSidesTop = bkgrdO.noSidesTop;
        newO.noSidesBot = bkgrdO.noSidesBot;
        newO.noSidesLeft = bkgrdO.noSidesLeft;
        newO.noSidesRight = bkgrdO.noSidesRight;
        newO.startingX = bkgrdO.startingX;
        newO.startingY = bkgrdO.startingY;
        newO.bX2 = bkgrdO.bX2;
        newO.bY2 = bkgrdO.bY2;
        newO.bX3 = bkgrdO.bX3;
        newO.bY3 = bkgrdO.bY3;
        newO.bX4 = bkgrdO.bX4;
        newO.bY4 = bkgrdO.bY4;
        newO.startingCX = bkgrdO.startingCX;
        newO.startingCY = bkgrdO.startingCY;
        newO.bCX2 = bkgrdO.bCX2;
        newO.bCY2 = bkgrdO.bCY2;
        newO.bCX3 = bkgrdO.bCX3;
        newO.bCY3 = bkgrdO.bCY3;
        newO.bCX4 = bkgrdO.bCX4;
        newO.bCY4 = bkgrdO.bCY4;
        newO.topShape = bkgrdO.topShape;
        newO.rightShape = bkgrdO.rightShape;
        newO.botShape = bkgrdO.botShape;
        newO.leftShape = bkgrdO.leftShape;
        newO.levelW = bkgrdO.levelW;
        newO.levelH = bkgrdO.levelH;
        newO.dimA1 = bkgrdO.dimA1;
        newO.dimA2 = bkgrdO.dimA2;
        newO.dimA3 = bkgrdO.dimA3;
        newO.dimA4 = bkgrdO.dimA4;
        newO.dimA5 = bkgrdO.dimA5;
        newO.dimA0 = bkgrdO.dimA0;
        newO.dimB1 = bkgrdO.dimB1;
        newO.dimB2 = bkgrdO.dimB2;
        newO.dimB3 = bkgrdO.dimB3;
        newO.dimB4 = bkgrdO.dimB4;
        newO.dimB5 = bkgrdO.dimB5;
        newO.dimB0 = bkgrdO.dimB0;
        newO.dimC1 = bkgrdO.dimC1;
        newO.dimC2 = bkgrdO.dimC2;
        newO.dimC3 = bkgrdO.dimC3;
        newO.dimC4 = bkgrdO.dimC4;
        newO.dimC5 = bkgrdO.dimC5;
        newO.dimC0 = bkgrdO.dimC0;
        newO.dimD1 = bkgrdO.dimD1;
        newO.dimD2 = bkgrdO.dimD2;
        newO.dimD3 = bkgrdO.dimD3;
        newO.dimD4 = bkgrdO.dimD4;
        newO.dimD5 = bkgrdO.dimD5;
        newO.dimD0 = bkgrdO.dimD0;
        newO.pA1 = bkgrdO.pA1;
        newO.pA2 = bkgrdO.pA2;
        newO.pA3 = bkgrdO.pA3;
        newO.pA4 = bkgrdO.pA4;
        newO.pA5 = bkgrdO.pA5;
        newO.pA0 = bkgrdO.pA0;
        newO.pB1 = bkgrdO.pB1;
        newO.pB2 = bkgrdO.pB2;
        newO.pB3 = bkgrdO.pB3;
        newO.pB4 = bkgrdO.pB4;
        newO.pB5 = bkgrdO.pB5;
        newO.pB0 = bkgrdO.pB0;
        newO.pC1 = bkgrdO.pC1;
        newO.pC2 = bkgrdO.pC2;
        newO.pC3 = bkgrdO.pC3;
        newO.pC4 = bkgrdO.pC4;
        newO.pC5 = bkgrdO.pC5;
        newO.pC0 = bkgrdO.pC0;
        newO.pD1 = bkgrdO.pD1;
        newO.pD2 = bkgrdO.pD2;
        newO.pD3 = bkgrdO.pD3;
        newO.pD4 = bkgrdO.pD4;
        newO.pD5 = bkgrdO.pD5;
        newO.pD0 = bkgrdO.pD0;

        newO.wire = bkgrdO.wire;
        newO.centerPointX = bkgrdO.centerPointX;
        newO.centerPointY = bkgrdO.centerPointY;
        newO.centerPointX2 = bkgrdO.centerPointX2;
        newO.centerPointY2 = bkgrdO.centerPointY2;
        newO.radius1 = bkgrdO.radius1;
        newO.radius2 = bkgrdO.radius2;
        newO.startAngle = bkgrdO.startAngle;
        newO.endAngle = bkgrdO.endAngle;
        newO.bkgrdStartX = bkgrdO.bkgrdStartX;
        newO.bkgrdStartY = bkgrdO.bkgrdStartY;
        newO.centralAngle = bkgrdO.centralAngle;

        newO.parentW = bkgrdO.parentW;
        newO.parentH = bkgrdO.parentH;
        newO.parentStartY = bkgrdO.parentStartY;
        newO.parentStartX = bkgrdO.parentStartX;
        newO.parentRadius1 = bkgrdO.parentRadius1;

        newO.topIn = bkgrdO.topIn;
        newO.rightIn = bkgrdO.rightIn;
        newO.botIn = bkgrdO.botIn;
        newO.leftIn = bkgrdO.leftIn;

        newO.deltaA1 = bkgrdO.deltaA1;
        newO.deltaC2 = bkgrdO.deltaC2;
        newO.deltaD1 = bkgrdO.deltaD1;

        newO.shapeChanged = bkgrdO.shapeChanged;
        newO.arcType = bkgrdO.arcType;
        newO.parentCX = bkgrdO.parentCX;
        newO.parentCY = bkgrdO.parentCY;
        newO.parentCX2 = bkgrdO.parentCX2;
        newO.parentCY2 = bkgrdO.parentCY2;
        newO.parentShape = bkgrdO.parentShape;
        newO.newPart = bkgrdO.newPart;
        newO.clearanceTop = bkgrdO.clearanceTop;
        newO.clearanceBot = bkgrdO.clearanceBot;
        newO.clearanceLeft = bkgrdO.clearanceLeft;
        newO.clearanceRight = bkgrdO.clearanceRight;

        newO.top1 = (Top1Object) newO.top1.cloneProfile(bkgrdO.top1Part);
        newO.top2 = (Top2Object) newO.top2.cloneProfile(bkgrdO.top2Part);
        newO.top3 = (Top3Object) newO.top3.cloneProfile(bkgrdO.top3Part);

        newO.right = (RightObject) newO.right.cloneProfile(bkgrdO.right);

        newO.left = (LeftObject) newO.left.cloneProfile(bkgrdO.left);

        newO.bot1 = (Bot1Object) newO.bot1.cloneProfile(bkgrdO.bot1);
        newO.bot2 = (Bot2Object) newO.bot2.cloneProfile(bkgrdO.bot2);
        newO.bot3 = (Bot3Object) newO.bot3.cloneProfile(bkgrdO.bot3);

        newO.top1Part = (Profiles) bkgrdO.top1Part.cloneProfile(bkgrdO.top1Part);
        newO.top2Part = (Profiles) bkgrdO.top2Part.cloneProfile(bkgrdO.top2Part);
        newO.top3Part = (Profiles) bkgrdO.top3Part.cloneProfile(bkgrdO.top3Part);
        newO.rightPart = (Profiles) bkgrdO.rightPart.cloneProfile(bkgrdO.rightPart);
        newO.leftPart = (Profiles) bkgrdO.leftPart.cloneProfile(bkgrdO.leftPart);
        newO.bot1Part = (Profiles) bkgrdO.bot1Part.cloneProfile(bkgrdO.bot1Part);
        newO.bot2Part = (Profiles) bkgrdO.bot2Part.cloneProfile(bkgrdO.bot2Part);
        newO.bot3Part = (Profiles) bkgrdO.bot3Part.cloneProfile(bkgrdO.bot3Part);

        if (bkgrdO.myMullionBot != null) {
            newO.myMullionBot = bkgrdO.myMullionBot.cloneProfile(bkgrdO.myMullionBot, bkgrdO.myParent.bOpeningObject);
        }

        if (bkgrdO.myMullionTop != null) {
            newO.myMullionTop = bkgrdO.myMullionTop.cloneProfile(bkgrdO.myMullionTop, bkgrdO.myParent.bOpeningObject);
        }

        if (bkgrdO.myMullionLeft != null) {
            newO.myMullionLeft = bkgrdO.myMullionLeft.cloneProfile(bkgrdO.myMullionLeft, bkgrdO.myParent.bOpeningObject);
        }

        if (bkgrdO.myMullionRight != null) {
            newO.myMullionRight = bkgrdO.myMullionRight.cloneProfile(bkgrdO.myMullionRight, bkgrdO.myParent.bOpeningObject);
        }

        return newO;
    }

    //**********************************************************************************************
    //Implementing methods for Matrix calculation
    //**********************************************************************************************

    public OpeningObject limitedCloneOpeningFromBkgrdO(OpeningObject newO, BkgrdOpeningObject bkgrdO) {

        newO.rID = bkgrdO.myParent.rID;
        newO.myFrame2 = bkgrdO.myParent.myFrame2;

        newO.myParent = bkgrdO.myParent;

        newO.shapeID = bkgrdO.myParent.shapeID;
        newO.a_sequenceID = bkgrdO.myParent.a_sequenceID;

        newO.a_1Level = bkgrdO.myParent.a_assemblyLevel;
        newO.a_1Sequence = bkgrdO.myParent.a_sequenceID;
        newO.a_2Level = bkgrdO.myParent.a_1Level;
        newO.a_2Sequence = bkgrdO.myParent.a_1Sequence;
        newO.a_3Level = bkgrdO.myParent.a_2Level;
        newO.a_3Sequence = bkgrdO.myParent.a_2Sequence;
        newO.a_4Level = bkgrdO.myParent.a_3Level;
        newO.a_4Sequence = bkgrdO.myParent.a_3Sequence;

        newO.a_5Level = bkgrdO.myParent.a_4Level;
        newO.a_5Sequence = bkgrdO.myParent.a_4Sequence;
        newO.a_6Level = bkgrdO.myParent.a_5Level;
        newO.a_6Sequence = bkgrdO.myParent.a_5Sequence;
        newO.a_7Level = bkgrdO.myParent.a_6Level;
        newO.a_7Sequence = bkgrdO.myParent.a_6Sequence;
        newO.a_8Level = bkgrdO.myParent.a_7Level;
        newO.a_8Sequence = bkgrdO.myParent.a_7Sequence;
        newO.a_9Level = bkgrdO.myParent.a_8Level;
        newO.a_9Sequence = bkgrdO.myParent.a_8Sequence;
        newO.a_10Level = bkgrdO.myParent.a_9Level;
        newO.a_10Sequence = bkgrdO.myParent.a_9Sequence;

        newO.a_11Level = bkgrdO.myParent.a_10Level;
        newO.a_11Sequence = bkgrdO.myParent.a_10Sequence;
        newO.a_12Level = bkgrdO.myParent.a_11Level;
        newO.a_12Sequence = bkgrdO.myParent.a_11Sequence;
        newO.a_13Level = bkgrdO.myParent.a_12Level;
        newO.a_13Sequence = bkgrdO.myParent.a_12Sequence;
        newO.a_14Level = bkgrdO.myParent.a_13Level;
        newO.a_15Sequence = bkgrdO.myParent.a_13Sequence;
        newO.a_15Level = bkgrdO.myParent.a_14Level;
        newO.a_15Sequence = bkgrdO.myParent.a_14Sequence;
        newO.a_16Level = bkgrdO.myParent.a_15Level;
        newO.a_16Sequence = bkgrdO.myParent.a_15Sequence;
        newO.a_17Level = bkgrdO.myParent.a_16Level;
        newO.a_17Sequence = bkgrdO.myParent.a_16Sequence;
        newO.a_18Level = bkgrdO.myParent.a_17Level;
        newO.a_18Sequence = bkgrdO.myParent.a_17Sequence;
        newO.a_19Level = bkgrdO.myParent.a_18Level;
        newO.a_19Sequence = bkgrdO.myParent.a_18Sequence;
        newO.a_20Level = bkgrdO.myParent.a_19Level;
        newO.a_20Sequence = bkgrdO.myParent.a_19Sequence;
        newO.a_21Level = bkgrdO.myParent.a_20Level;
        newO.a_21Sequence = bkgrdO.myParent.a_20Sequence;
        newO.a_22Level = bkgrdO.myParent.a_21Level;
        newO.a_22Sequence = bkgrdO.myParent.a_21Sequence;

        newO.myFacet = bkgrdO.myParent.myFacet;

        newO.myParentF = bkgrdO.myParentF;

        newO.widthPix = bkgrdO.widthPix;
        newO.heightPix = bkgrdO.heightPix;

        newO.widthM = bkgrdO.widthM;
        newO.heightM = bkgrdO.heightM;
        newO.widthMN = bkgrdO.widthMN;
        newO.heightMN = bkgrdO.heightMN;
        newO.widthMO = bkgrdO.widthMO;
        newO.heightMO = bkgrdO.heightMO;
        newO.widthI = bkgrdO.widthI;
        newO.heightI = bkgrdO.heightI;
        newO.widthIN = bkgrdO.widthIN;
        newO.heightIN = bkgrdO.heightIN;
        newO.widthIO = bkgrdO.widthIO;
        newO.heightIO = bkgrdO.heightIO;

        newO.highestX = bkgrdO.highestX;
        newO.lowestX = bkgrdO.lowestX;
        newO.highestY = bkgrdO.highestY;
        newO.lowestY = bkgrdO.lowestY;
        newO.highestYC = bkgrdO.highestYC;

        newO.lowestYC = bkgrdO.lowestYC;
        newO.startCol = bkgrdO.startCol;
        newO.glazedOut = bkgrdO.glazedOut;
        newO.endCol = bkgrdO.endCol;
        newO.startRow = bkgrdO.startRow;
        newO.endRow = bkgrdO.endRow;

        newO.noPartsTop1 = bkgrdO.noPartsTop1;
        newO.noPartsTop2 = bkgrdO.noPartsTop2;
        newO.noPartsTop3 = bkgrdO.noPartsTop3;
        newO.noPartsBot1 = bkgrdO.noPartsBot1;
        newO.noPartsBot2 = bkgrdO.noPartsBot2;
        newO.noPartsBot3 = bkgrdO.noPartsBot3;
        newO.noPartsLeft = bkgrdO.noPartsLeft;
        newO.noPartsRight = bkgrdO.noPartsRight;

        newO.isNewFrame = bkgrdO.isNewFrame;

        newO.newRowH = bkgrdO.newRowH;

        newO.myFrame2 = bkgrdO.myFrame2;

        newO.newDesign = bkgrdO.newDesign;

        newO.frameStartCol = bkgrdO.frameStartCol;
        newO.frameStartRow = bkgrdO.frameStartRow;

        newO.frameEndCol = bkgrdO.frameEndCol;
        newO.frameEndRow = bkgrdO.frameEndRow;

        newO.myRow = bkgrdO.myRow;
        newO.myCol = bkgrdO.myCol;

        newO.myShapeID = bkgrdO.myShapeID;

        newO.myPrevShape = bkgrdO.myPrevShape;

        newO.myNewShape = bkgrdO.myNewShape;

        newO.newWidthTop = bkgrdO.newWidthTop;
        newO.newWidthBot = bkgrdO.newWidthBot;
        newO.newStartingY = bkgrdO.newStartingY;
        newO.newStartingX = bkgrdO.newStartingX;
        newO.newHL = bkgrdO.newHL;
        newO.newHR = bkgrdO.newHR;
        newO.newstartX = bkgrdO.newstartX;
        newO.newendX = bkgrdO.newendX;
        newO.newstartY = bkgrdO.newstartY;
        newO.newendY = bkgrdO.newendY;

        newO.newDimD2 = bkgrdO.newDimD2;
        newO.newDimB1 = bkgrdO.newDimB1;

        newO.rowColToAdd = bkgrdO.rowColToAdd;
        newO.addRow = bkgrdO.addRow;

        newO.dividedCentral = bkgrdO.dividedCentral;
        newO.myCouplerThickness = bkgrdO.myCouplerThickness;

        // newOV.ellipses = myNewOpening.ellipses;
        newO.setLeanTo = bkgrdO.setLeanTo;

        newO.minLeg = bkgrdO.minLeg;
        newO.wireFrame = bkgrdO.wireFrame;

        newO.parentid = bkgrdO.parentid;
        newO.parentStartRow = bkgrdO.parentStartRow;
        newO.parentStartCol = bkgrdO.parentStartCol;

        newO.startingXBA = bkgrdO.startingXBA;
        newO.startingYBA = bkgrdO.startingYBA;

        newO.startingXA = bkgrdO.startingXA;
        newO.startingYA = bkgrdO.startingYA;

        newO.bX2A = bkgrdO.bX2A;
        newO.bY2A = bkgrdO.bY2A;
        newO.bX3A = bkgrdO.bX3A;
        newO.bY3A = bkgrdO.bX3A;

        newO.bX4A = bkgrdO.bX4A;
        newO.bY4A = bkgrdO.bY4A;
        newO.bX2B = bkgrdO.bX2B;
        newO.bY2B = bkgrdO.bY2B;
        newO.bX3B = bkgrdO.bX3B;
        newO.bY3B = bkgrdO.bY3B;
        newO.bX4B = bkgrdO.bX4B;
        newO.bY4B = bkgrdO.bY4B;

        newO.openingW = bkgrdO.openingW;
        newO.openingH = bkgrdO.openingH;

        newO.openingWc = bkgrdO.openingWc;
        newO.openingHc = bkgrdO.openingHc;

        newO.openingWB = bkgrdO.openingWB;
        newO.openingHR = bkgrdO.openingHR;

        newO.openingWcB = bkgrdO.openingWcB;
        newO.openingHcR = bkgrdO.openingHcR;

        newO.openingWA = bkgrdO.openingWA;
        newO.openingHA = bkgrdO.openingHA;
        newO.openingWBA = bkgrdO.openingWBA;
        newO.openingHRA = bkgrdO.openingHRA;

        newO.dimTM = bkgrdO.dimTM;
        newO.dimBM = bkgrdO.dimBM;
        newO.dimLM = bkgrdO.dimLM;
        newO.dimRM = bkgrdO.dimRM;
        newO.dimTA = bkgrdO.dimTA;
        newO.dimBA = bkgrdO.dimBA;
        newO.dimLA = bkgrdO.dimLA;
        newO.dimRA = bkgrdO.dimRA;

        newO.a_sequenceID = bkgrdO.a_sequenceID;

        newO.lastSeq = bkgrdO.lastSeq;

        newO.xCols = bkgrdO.xCols;
        newO.yRows = bkgrdO.yRows;


        newO.radius1A = bkgrdO.radius1A;
        newO.radius2A = bkgrdO.radius2A;

        newO.startAngleA = bkgrdO.startAngleA;
        newO.endAngleA = bkgrdO.endAngleA;

        newO.bkgrdStartXA = bkgrdO.bkgrdStartXA;
        newO.bkgrdStartYA = bkgrdO.bkgrdStartYA;

        newO.centralAngleA = bkgrdO.centralAngleA;

        newO.px1 = bkgrdO.px1;
        newO.py1 = bkgrdO.py1;
        newO.px2 = bkgrdO.px2;
        newO.py2 = bkgrdO.py2;
        newO.px3 = bkgrdO.px3;
        newO.py3 = bkgrdO.py3;
        newO.px4 = bkgrdO.px4;
        newO.py4 = bkgrdO.py4;
        newO.px5 = bkgrdO.px5;
        newO.py5 = bkgrdO.py5;
        newO.px6 = bkgrdO.px6;
        newO.py6 = bkgrdO.py6;
        newO.px7 = bkgrdO.px7;
        newO.py7 = bkgrdO.py7;
        newO.px8 = bkgrdO.px8;
        newO.py8 = bkgrdO.py8;

        newO.px1A = bkgrdO.px1A;
        newO.py1A = bkgrdO.py1A;
        newO.px2A = bkgrdO.px2A;
        newO.py2A = bkgrdO.py2A;
        newO.px3A = bkgrdO.px3A;
        newO.py3A = bkgrdO.py3A;
        newO.px4A = bkgrdO.px4A;
        newO.py4A = bkgrdO.py4A;
        newO.px5A = bkgrdO.px5A;
        newO.py5A = bkgrdO.py5A;
        newO.px6A = bkgrdO.px6A;
        newO.py6A = bkgrdO.py6A;
        newO.px7A = bkgrdO.px7A;
        newO.py7A = bkgrdO.py7A;
        newO.px8A = bkgrdO.px8A;
        newO.py8A = bkgrdO.py8A;

        newO.px1c = bkgrdO.px1c;
        newO.py1c = bkgrdO.py1c;
        newO.px2c = bkgrdO.px2c;
        newO.py2c = bkgrdO.py2c;
        newO.px3c = bkgrdO.px3c;
        newO.py3c = bkgrdO.py3c;
        newO.px4c = bkgrdO.px4c;
        newO.py4c = bkgrdO.py4c;
        newO.px5c = bkgrdO.px5c;
        newO.py5c = bkgrdO.py5c;
        newO.px6c = bkgrdO.px6c;
        newO.py6c = bkgrdO.py6c;
        newO.px7c = bkgrdO.px7c;
        newO.py7c = bkgrdO.py7c;
        newO.px8c = bkgrdO.px8c;
        newO.py8c = bkgrdO.py8c;

        newO.id = bkgrdO.id;
        newO.rID = bkgrdO.rID;

        newO.lean = bkgrdO.lean;
        newO.lean2 = bkgrdO.lean2;
        newO.lean3 = bkgrdO.lean3;
        newO.lean4 = bkgrdO.lean4;

        newO.noSides = bkgrdO.noSides;
        newO.noSidesTop = bkgrdO.noSidesTop;
        newO.noSidesBot = bkgrdO.noSidesBot;
        newO.noSidesLeft = bkgrdO.noSidesLeft;
        newO.noSidesRight = bkgrdO.noSidesRight;

        newO.startingX = bkgrdO.startingX;
        newO.startingY = bkgrdO.startingY;

        newO.bX2 = bkgrdO.bX2;
        newO.bY2 = bkgrdO.bY2;
        newO.bX3 = bkgrdO.bX3;
        newO.bY3 = bkgrdO.bY3;
        newO.bX4 = bkgrdO.bX4;
        newO.bY4 = bkgrdO.bY4;

        newO.startingCX = bkgrdO.startingCX;
        newO.startingCY = bkgrdO.startingCY;

        newO.bCX2 = bkgrdO.bCX2;
        newO.bCY2 = bkgrdO.bCY2;
        newO.bCX3 = bkgrdO.bCX3;
        newO.bCY3 = bkgrdO.bCY3;
        newO.bCX4 = bkgrdO.bCX4;
        newO.bCY4 = bkgrdO.bCY4;

        newO.topShape = bkgrdO.topShape;

        newO.rightShape = bkgrdO.rightShape;

        newO.botShape = bkgrdO.botShape;

        newO.leftShape = bkgrdO.leftShape;

        newO.levelW = bkgrdO.levelW;
        newO.levelH = bkgrdO.levelH;
        newO.dimA1 = bkgrdO.dimA1;
        newO.dimA2 = bkgrdO.dimA2;
        newO.dimA3 = bkgrdO.dimA3;
        newO.dimA4 = bkgrdO.dimA4;
        newO.dimA5 = bkgrdO.dimA5;
        newO.dimA0 = bkgrdO.dimA0;
        newO.dimB1 = bkgrdO.dimB1;
        newO.dimB2 = bkgrdO.dimB2;
        newO.dimB3 = bkgrdO.dimB3;
        newO.dimB4 = bkgrdO.dimB4;
        newO.dimB5 = bkgrdO.dimB5;
        newO.dimB0 = bkgrdO.dimB0;
        newO.dimC1 = bkgrdO.dimC1;
        newO.dimC2 = bkgrdO.dimC2;
        newO.dimC3 = bkgrdO.dimC3;
        newO.dimC4 = bkgrdO.dimC4;
        newO.dimC5 = bkgrdO.dimC5;
        newO.dimC0 = bkgrdO.dimC0;
        newO.dimD1 = bkgrdO.dimD1;
        newO.dimD2 = bkgrdO.dimD2;
        newO.dimD3 = bkgrdO.dimD3;
        newO.dimD4 = bkgrdO.dimD4;
        newO.dimD5 = bkgrdO.dimD5;
        newO.dimD0 = bkgrdO.dimD0;
        newO.pA1 = bkgrdO.pA1;
        newO.pA2 = bkgrdO.pA2;
        newO.pA3 = bkgrdO.pA3;
        newO.pA4 = bkgrdO.pA4;
        newO.pA5 = bkgrdO.pA5;
        newO.pA0 = bkgrdO.pA0;
        newO.pB1 = bkgrdO.pB1;
        newO.pB2 = bkgrdO.pB2;
        newO.pB3 = bkgrdO.pB3;
        newO.pB4 = bkgrdO.pB4;
        newO.pB5 = bkgrdO.pB5;
        newO.pB0 = bkgrdO.pB0;
        newO.pC1 = bkgrdO.pC1;
        newO.pC2 = bkgrdO.pC2;
        newO.pC3 = bkgrdO.pC3;
        newO.pC4 = bkgrdO.pC4;
        newO.pC5 = bkgrdO.pC5;
        newO.pC0 = bkgrdO.pC0;
        newO.pD1 = bkgrdO.pD1;
        newO.pD2 = bkgrdO.pD2;
        newO.pD3 = bkgrdO.pD3;
        newO.pD4 = bkgrdO.pD4;
        newO.pD5 = bkgrdO.pD5;
        newO.pD0 = bkgrdO.pD0;

        newO.wire = bkgrdO.wire;
        newO.centerPointX = bkgrdO.centerPointX;
        newO.centerPointY = bkgrdO.centerPointY;
        newO.centerPointX2 = bkgrdO.centerPointX2;
        newO.centerPointY2 = bkgrdO.centerPointY2;
        newO.radius1 = bkgrdO.radius1;
        newO.radius2 = bkgrdO.radius2;
        newO.startAngle = bkgrdO.startAngle;
        newO.endAngle = bkgrdO.endAngle;
        newO.bkgrdStartX = bkgrdO.bkgrdStartX;
        newO.bkgrdStartY = bkgrdO.bkgrdStartY;
        newO.centralAngle = bkgrdO.centralAngle;

        newO.parentW = bkgrdO.parentW;
        newO.parentH = bkgrdO.parentH;
        newO.parentStartY = bkgrdO.parentStartY;
        newO.parentStartX = bkgrdO.parentStartX;
        newO.parentRadius1 = bkgrdO.parentRadius1;

        newO.topIn = bkgrdO.topIn;
        newO.rightIn = bkgrdO.rightIn;
        newO.botIn = bkgrdO.botIn;
        newO.leftIn = bkgrdO.leftIn;

        newO.deltaA1 = bkgrdO.deltaA1;
        newO.deltaC2 = bkgrdO.deltaC2;
        newO.deltaD1 = bkgrdO.deltaD1;

        newO.shapeChanged = bkgrdO.shapeChanged;

        newO.arcType = bkgrdO.arcType;
        newO.parentCX = bkgrdO.parentCX;
        newO.parentCY = bkgrdO.parentCY;
        newO.parentCX2 = bkgrdO.parentCX2;
        newO.parentCY2 = bkgrdO.parentCY2;
        newO.parentShape = bkgrdO.parentShape;

        newO.newPart = bkgrdO.newPart;

        newO.clearanceTop = bkgrdO.clearanceTop;
        newO.clearanceBot = bkgrdO.clearanceBot;
        newO.clearanceLeft = bkgrdO.clearanceLeft;
        newO.clearanceRight = bkgrdO.clearanceRight;

        newO.top1 = (Top1Object) newO.top1.cloneProfile(bkgrdO.top1Part);
        newO.top2 = (Top2Object) newO.top2.cloneProfile(bkgrdO.top2Part);
        newO.top3 = (Top3Object) newO.top3.cloneProfile(bkgrdO.top3Part);

        newO.right = (RightObject) newO.right.cloneProfile(bkgrdO.right);

        newO.left = (LeftObject) newO.left.cloneProfile(bkgrdO.left);

        newO.bot1 = (Bot1Object) newO.bot1.cloneProfile(bkgrdO.bot1);
        newO.bot2 = (Bot2Object) newO.bot2.cloneProfile(bkgrdO.bot2);
        newO.bot3 = (Bot3Object) newO.bot3.cloneProfile(bkgrdO.bot3);

        newO.top1Part = (Profiles) bkgrdO.top1Part.cloneProfile(bkgrdO.top1Part);
        newO.top2Part = (Profiles) bkgrdO.top2Part.cloneProfile(bkgrdO.top2Part);
        newO.top3Part = (Profiles) bkgrdO.top3Part.cloneProfile(bkgrdO.top3Part);
        newO.rightPart = (Profiles) bkgrdO.rightPart.cloneProfile(bkgrdO.rightPart);
        newO.leftPart = (Profiles) bkgrdO.leftPart.cloneProfile(bkgrdO.leftPart);
        newO.bot1Part = (Profiles) bkgrdO.bot1Part.cloneProfile(bkgrdO.bot1Part);
        newO.bot2Part = (Profiles) bkgrdO.bot2Part.cloneProfile(bkgrdO.bot2Part);
        newO.bot3Part = (Profiles) bkgrdO.bot3Part.cloneProfile(bkgrdO.bot3Part);

        return newO;
    }

    public boolean glazedTest() {

        boolean pass = false;

        if (this.myGlassMid != null || myGlassOut != null || myGlassIn != null) {

            return true;
        }


        return pass;
    }

    public Object[] checkOpeningLimit(OpeningObject opening, SeriesValidOpeningShape myType) {

        // Opening to verify limits

        int pass = 1;
        String message = "";

        BigDecimal width = new BigDecimal("0");
        BigDecimal height = new BigDecimal("0");
        BigDecimal maxArea = new BigDecimal("0");

        if (myParent.myFrame2.currentUOM == Metrics.METRIC.getValue()) {

            width = new BigDecimal(opening.widthM / 100);
            height = new BigDecimal(opening.heightM / 100);
            maxArea = width.divide(new BigDecimal(1000)).multiply(height.divide(new BigDecimal(1000)));

            if (width.doubleValue() < myType.getMinWidth() / 100) {
                message = ("Opening Too Narrow - Width Error");
                pass = 0;
            }

            if (pass == 1 && width.doubleValue() > myType.getMaxWidth() / 100) {
                message = ("Opening Too Wide - Width Error");
                pass = 0;
            }

            if (pass == 1 && height.doubleValue() < myType.getMinHeight() / 100) {
                message = ("Opening Too Short - Height Error");
                pass = 0;
            }

            if (pass == 1 && height.doubleValue() > myType.getMaxHeight() / 100) {
                message = ("Opening Too High - Height Error");
                pass = 0;
            }

            if (pass == 1 && maxArea.doubleValue() > myType.getMaxArea()) {
                message = ("Opening Area too big - Size Error");
                pass = 0;
            }

        } else if (myParent.myFrame2.currentUOM > Metrics.METRIC.getValue()) {

            width = new BigDecimal(opening.widthI / 64d);
            height = new BigDecimal(opening.heightI / 64d);
            maxArea = width.divide(new BigDecimal(12), 20, BigDecimal.ROUND_HALF_EVEN).multiply(height.
                    divide(new BigDecimal(12), 20, BigDecimal.ROUND_HALF_EVEN));

            if (width.doubleValue() < myType.getMinWidthImp() / 64d) {
                message = ("Opening Too Narrow - Width Error");
                pass = 0;
            }

            if (pass == 1 && width.doubleValue() > myType.getMaxWidthImp() / 64d) {
                message = ("Opening Too Wide - Width Error");
                pass = 0;
            }

            if (pass == 1 && height.doubleValue() < myType.getMinHeightImp() / 64d) {
                message = ("Opening Too Short - Height Error");
                pass = 0;
            }

            if (pass == 1 && height.doubleValue() > myType.getMaxHeightImp() / 64d) {
                message = ("Opening Too High - Height Error");
                pass = 0;
            }

            if (pass == 1 && maxArea.doubleValue() > myType.getMaxAreaImp()) {
                message = ("Opening Area too big - Area Error");
                pass = 0;
            }
        }

        Object[] myReturn = new Object[2];
        myReturn[0] = pass;
        myReturn[1] = message;

        return myReturn;
    }

    /**
     * Clone Opening small
     *
     * @return OpeningObject
     */
    public OpeningObject clone_opening() {

        try {

            //Clone Opening object model
            OpeningObject newOpening = (OpeningObject) super.clone();

            return newOpening;

        } catch (DTOTransformationError e) {
            logger.error(e.getMessage(), e);
        } catch (CloneNotSupportedException e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }

    @Override
    public OpeningObject clone() {

        try {

            //Clone Opening object model
            OpeningObject newOpening = (OpeningObject) super.clone();

            //Clone SubFacet
            if (newOpening.subFacet != null) {
                Facet subFacet = newOpening.subFacet.clone();
                newOpening.subFacet = subFacet;
            }

            //Clone Glass object model
            if (newOpening.myGlassIn != null) {
                GlassSU glassIn = newOpening.myGlassIn.clone();
                newOpening.myGlassIn = glassIn;
            }

            if (newOpening.myGlassMid != null) {
                GlassSU glassMid = newOpening.myGlassMid.clone();
                newOpening.myGlassMid = glassMid;
            }

            if (newOpening.myGlassOut != null) {
                GlassSU glassOut = newOpening.myGlassOut.clone();
                newOpening.myGlassOut = glassOut;
            }

            //Clone Sash Type object model
            if (newOpening.sashObjectIn != null) {
                SashTypeObject sashType = newOpening.sashObjectIn.clone();
                sashType.myParent = newOpening;
                sashType.myFacet = newOpening.myFacet;
                sashType.myOverall = newOpening.myOverall;

                newOpening.sashObjectIn = sashType;
            }

            if (newOpening.sashObjectMid != null) {
                SashTypeObject sashType = newOpening.sashObjectMid.clone();
                sashType.myParent = newOpening;
                sashType.myFacet = newOpening.myFacet;
                sashType.myOverall = newOpening.myOverall;

                newOpening.sashObjectMid = sashType;
            }

            if (newOpening.sashObjectOut != null) {
                SashTypeObject sashType = newOpening.sashObjectOut.clone();
                sashType.myParent = newOpening;
                sashType.myFacet = newOpening.myFacet;
                sashType.myOverall = newOpening.myOverall;

                newOpening.sashObjectOut = sashType;
            }

            //Clone Glazing Beads object model
            if (newOpening.glazingBeadsIn != null) {
                Collection<Profiles> _glazingBeadsIn = new ArrayList<Profiles>();
                for (Object glazingBead : newOpening.glazingBeadsIn) {
                    Profiles profile = ((Profiles) glazingBead).clone();
                    _glazingBeadsIn.add(profile);
                }
                newOpening.glazingBeadsIn = new ArrayList<Profiles>(_glazingBeadsIn);
            }

            if (newOpening.glazingBeadsMid != null) {
                Collection<Profiles> _glazingBeadsMid = new ArrayList<Profiles>();
                for (Object glazingBead : newOpening.glazingBeadsMid) {
                    Profiles profile = ((Profiles) glazingBead).clone();
                    _glazingBeadsMid.add(profile);
                }
                newOpening.glazingBeadsMid = new ArrayList<Profiles>(_glazingBeadsMid);
            }

            if (newOpening.glazingBeadsOut != null) {
                Collection<Profiles> _glazingBeadsOut = new ArrayList<Profiles>();
                for (Object glazingBead : newOpening.glazingBeadsOut) {
                    Profiles profile = ((Profiles) glazingBead).clone();
                    _glazingBeadsOut.add(profile);
                }
                newOpening.glazingBeadsOut = new ArrayList<Profiles>(_glazingBeadsOut);
            }

            //Clone DLO object model
            if (newOpening.dloIn != null) {
                newOpening.dloIn = this.dloIn.clone();
                newOpening.myParentO = this;
            }

            if (newOpening.dloMid != null) {
                newOpening.dloMid = this.dloMid.clone();
                newOpening.myParentO = this;
            }

            if (newOpening.dloOut != null) {
                newOpening.dloOut = this.dloOut.clone();
                newOpening.myParentO = this;
            }

            //Clone Opening collection object
            if (newOpening.openings != null) {
                List _openings = new ArrayList();
                for (Object opening : newOpening.openings) {
                    OpeningObject openingObject = ((OpeningObject) opening).clone();
                    _openings.add(openingObject);
                }

                Collections.sort(_openings, ShapeObjectComparator._SEQUENCE_ID);
                newOpening.openings = _openings;
            }

            return newOpening;

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

        //*************************************************
        //Matching Rule for subFacet
        //*************************************************
        if (this.subFacet != null) {
            this.subFacet.isMatchingBOMRule(rule, doBOM);
        }

        //*************************************************
        //Creating glasses
        //*************************************************
        if (this.myGlassIn != null) {
            this.myGlassIn.isMatchingBOMRule(rule, doBOM);
        }

        if (this.myGlassMid != null) {
            this.myGlassMid.isMatchingBOMRule(rule, doBOM);
        }

        if (this.myGlassOut != null) {
            this.myGlassOut.isMatchingBOMRule(rule, doBOM);
        }

        //*************************************************
        //Creating sash type
        //*************************************************
        if (this.sashObjectIn != null) {
            this.sashObjectIn.isMatchingBOMRule(rule, doBOM);
        }

        if (this.sashObjectMid != null) {
            this.sashObjectMid.isMatchingBOMRule(rule, doBOM);
        }

        if (this.sashObjectOut != null) {
            this.sashObjectOut.isMatchingBOMRule(rule, doBOM);
        }

        //*************************************************
        //Creating glazing beads
        //*************************************************
        if (this.glazingBeadsIn != null && this.glazingBeadsIn.size() > 0) {
            Object[] rmp = this.glazingBeadsIn.toArray();
            for (Object v : rmp) {
                if (((Profiles) v).isMatchingRule(rule)) {
                    ((Profiles) v).executePartRules(rule, doBOM);
                }
            }
        }

        if (this.glazingBeadsMid != null && this.glazingBeadsMid.size() > 0) {
            Object[] rmp = this.glazingBeadsMid.toArray();
            for (Object v : rmp) {
                if (((Profiles) v).isMatchingRule(rule)) {
                    ((Profiles) v).executePartRules(rule, doBOM);
                }
            }
        }

        if (this.glazingBeadsOut != null && this.glazingBeadsOut.size() > 0) {
            Object[] rmp = this.glazingBeadsOut.toArray();
            for (Object v : rmp) {
                if (((Profiles) v).isMatchingRule(rule)) {
                    ((Profiles) v).executePartRules(rule, doBOM);
                }
            }
        }

        if (this.glazingBeadIn != null) {
            this.glazingBeadIn.isMatchingBOMRule(rule, doBOM);
        }

        if (this.glazingBeadMid != null) {
            this.glazingBeadMid.isMatchingBOMRule(rule, doBOM);
        }

        if (this.glazingBeadOut != null) {
            this.glazingBeadOut.isMatchingBOMRule(rule, doBOM);
        }

        //*************************************************
        //Creating DLO
        //*************************************************
        if (this.dloIn != null) {
            this.dloIn.isMatchingBOMRule(rule, doBOM);

            for (BillOfMat billOfMat : this.dloIn.bom) {
                billOfMat.shapeObject = this;
            }

        }

        if (this.dloMid != null) {
            this.dloMid.isMatchingBOMRule(rule, doBOM);

            for (BillOfMat billOfMat : this.dloMid.bom) {
                billOfMat.shapeObject = this;
            }
        }

        if (this.dloOut != null) {
            this.dloOut.isMatchingBOMRule(rule, doBOM);

            for (BillOfMat billOfMat : this.dloOut.bom) {
                billOfMat.shapeObject = this;
            }
        }

        //********************************************************
        // Creating Openings objects
        //********************************************************
        if (!this.openings.isEmpty()) {
            Object[] rmp = this.openings.toArray();
            for (Object v : rmp) {
                OpeningObject op = (OpeningObject) v;
                op.isMatchingBOMRule(rule, doBOM);
            }
        }
    }

    @Override
    public void loadBOMParts() {

        //Load BOM Parts
        if (this.bom != null && this.bom.size() > 0) {
            this.myFrame2.jobItem.bom.addAll(bom);
        }

        //*************************************************
        //Load BOM for subFacet
        //*************************************************
        if (this.subFacet != null) {
            this.subFacet.loadBOMParts();
        }

        //*************************************************
        //Load BOM for Glass
        //*************************************************
        if (this.myGlassIn != null) {
            this.myGlassIn.loadBOMParts();
        }

        if (this.myGlassMid != null) {
            this.myGlassMid.loadBOMParts();
        }

        if (this.myGlassOut != null) {
            this.myGlassOut.loadBOMParts();
        }

        //*************************************************
        //Load BOM for Sash type
        //*************************************************
        if (this.sashObjectIn != null) {
            this.sashObjectIn.loadBOMParts();
        }

        if (this.sashObjectMid != null) {
            this.sashObjectMid.loadBOMParts();
        }

        if (this.sashObjectOut != null) {
            this.sashObjectOut.loadBOMParts();
        }

        //*************************************************
        //Load BOM for glazing Beads Profile Parts
        //*************************************************
//        if (this.glazingBeadsIn != null && this.glazingBeadsIn.size() > 0) {
//            for (Object profile : this.glazingBeadsIn) {
//                Profiles p = (Profiles)profile;
//                p.myFrame2 = this.myFrame2;
//
//                p.loadBOMParts();
//            }
//        }
//
//        if (this.glazingBeadsMid != null && this.glazingBeadsMid.size() > 0) {
//            for (Object profile : this.glazingBeadsMid) {
//                Profiles p = (Profiles)profile;
//                p.myFrame2 = this.myFrame2;
//
//                p.loadBOMParts();
//            }
//        }
//
//        if (this.glazingBeadsOut != null && this.glazingBeadsOut.size() > 0) {
//            for (Object profile : this.glazingBeadsOut) {
//                Profiles p = (Profiles)profile;
//                p.myFrame2 = this.myFrame2;
//
//                p.loadBOMParts();
//            }
//        }

        //*************************************************
        //Load BOM for glazing beads
        //*************************************************
        if (this.glazingBeadIn != null) {
            this.glazingBeadIn.loadBOMParts();
        }

        if (this.glazingBeadMid != null) {
            this.glazingBeadMid.loadBOMParts();
        }

        if (this.glazingBeadOut != null) {
            this.glazingBeadOut.loadBOMParts();
        }

        //*************************************************
        //Load BOM for DLO
        //*************************************************
        if (this.dloIn != null) {
            this.dloIn.loadBOMParts();
        }

        if (this.dloMid != null) {
            this.dloMid.loadBOMParts();
        }

        if (this.dloOut != null) {
            this.dloOut.loadBOMParts();
        }

        //********************************************************
        //Load BOM for Openings objects
        //********************************************************
        if (!this.openings.isEmpty()) {
            Object[] rmp = this.openings.toArray();
            for (Object v : rmp) {
                OpeningObject op = (OpeningObject) v;
                op.loadBOMParts();
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

        //*************************************************
        //Clear BOM for subFacet
        //*************************************************
        if (this.subFacet != null) {
            this.subFacet.clearBOMParts();
        }

        //*************************************************
        //Clear BOM for Glass
        //*************************************************
        if (this.myGlassIn != null) {
            this.myGlassIn.clearBOMParts();
        }

        if (this.myGlassMid != null) {
            this.myGlassMid.clearBOMParts();
        }

        if (this.myGlassOut != null) {
            this.myGlassOut.clearBOMParts();
        }

        //*************************************************
        //Clear BOM for Sash type
        //*************************************************
        if (this.sashObjectIn != null) {
            this.sashObjectIn.clearBOMParts();
        }

        if (this.sashObjectMid != null) {
            this.sashObjectMid.clearBOMParts();
        }

        if (this.sashObjectOut != null) {
            this.sashObjectOut.clearBOMParts();
        }

        //*************************************************
        //Clear BOM for glazing Beads Profile Parts
        //*************************************************
        if (this.glazingBeadsIn != null && this.glazingBeadsIn.size() > 0) {
            for (Object profile : this.glazingBeadsIn) {
                Profiles p = (Profiles) profile;
                p.clearBOMParts();
            }
        }

        if (this.glazingBeadsMid != null && this.glazingBeadsMid.size() > 0) {
            for (Object profile : this.glazingBeadsMid) {
                Profiles p = (Profiles) profile;
                p.clearBOMParts();
            }
        }

        if (this.glazingBeadsOut != null && this.glazingBeadsOut.size() > 0) {
            for (Object profile : this.glazingBeadsOut) {
                Profiles p = (Profiles) profile;
                p.clearBOMParts();
            }
        }

        //*************************************************
        //Clear BOM for glazing beads
        //*************************************************
        if (this.glazingBeadIn != null) {
            this.glazingBeadIn.clearBOMParts();
        }

        if (this.glazingBeadMid != null) {
            this.glazingBeadMid.clearBOMParts();
        }

        if (this.glazingBeadOut != null) {
            this.glazingBeadOut.clearBOMParts();
        }

        //*************************************************
        //Clear BOM for DLO
        //*************************************************
        if (this.dloIn != null) {
            this.dloIn.clearBOMParts();
        }

        if (this.dloMid != null) {
            this.dloMid.clearBOMParts();
        }

        if (this.dloOut != null) {
            this.dloOut.clearBOMParts();
        }

        //********************************************************
        //Clear BOM for Openings objects
        //********************************************************
        if (!this.openings.isEmpty()) {
            Object[] rmp = this.openings.toArray();
            for (Object v : rmp) {
                OpeningObject op = (OpeningObject) v;
                op.clearBOMParts();
            }
        }
    }

    @Override
    public void loadOptionsAll() {

        //Load BOM Parts
        if (this.options != null && this.options.size() > 0) {
            for (ShapeOption shapeOption : this.options) {
                if (!shapeOption.global) {

                    DesignOption designOption = new DesignOption();
                    designOption = designOption.setDesignOptions(designOption, shapeOption);

                    //Adding to Design Options All
                    this.myFrame2.designOptionsAll.add(designOption);
                }
            }
        }

        //*************************************************
        //Load BOM for subFacet
        //*************************************************
        if (this.subFacet != null) {
            this.subFacet.loadOptionsAll();
        }

        //*************************************************
        //Load BOM for Glass
        //*************************************************
        if (this.myGlassIn != null) {
            this.myGlassIn.loadOptionsAll();
        }

        if (this.myGlassMid != null) {
            this.myGlassMid.loadOptionsAll();
        }

        if (this.myGlassOut != null) {
            this.myGlassOut.loadOptionsAll();
        }

        //*************************************************
        //Load BOM for Sash type
        //*************************************************
        if (this.sashObjectIn != null) {
            this.sashObjectIn.loadOptionsAll();
        }

        if (this.sashObjectMid != null) {
            this.sashObjectMid.loadOptionsAll();
        }

        if (this.sashObjectOut != null) {
            this.sashObjectOut.loadOptionsAll();
        }

        //*************************************************
        //Load BOM for glazing Beads Profile Parts
        //*************************************************
//        if (this.glazingBeadsIn != null && this.glazingBeadsIn.size() > 0) {
//            for (Object profile : this.glazingBeadsIn) {
//                Profiles p = (Profiles)profile;
//                p.myFrame2 = this.myFrame2;
//
//                p.loadBOMParts();
//            }
//        }
//
//        if (this.glazingBeadsMid != null && this.glazingBeadsMid.size() > 0) {
//            for (Object profile : this.glazingBeadsMid) {
//                Profiles p = (Profiles)profile;
//                p.myFrame2 = this.myFrame2;
//
//                p.loadBOMParts();
//            }
//        }
//
//        if (this.glazingBeadsOut != null && this.glazingBeadsOut.size() > 0) {
//            for (Object profile : this.glazingBeadsOut) {
//                Profiles p = (Profiles)profile;
//                p.myFrame2 = this.myFrame2;
//
//                p.loadBOMParts();
//            }
//        }

        //*************************************************
        //Load BOM for glazing beads
        //*************************************************
        if (this.glazingBeadIn != null) {
            this.glazingBeadIn.loadOptionsAll();
        }

        if (this.glazingBeadMid != null) {
            this.glazingBeadMid.loadOptionsAll();
        }

        if (this.glazingBeadOut != null) {
            this.glazingBeadOut.loadOptionsAll();
        }

        //*************************************************
        //Load BOM for DLO
        //*************************************************
        if (this.dloIn != null) {
            this.dloIn.loadOptionsAll();
        }

        if (this.dloMid != null) {
            this.dloMid.loadOptionsAll();
        }

        if (this.dloOut != null) {
            this.dloOut.loadOptionsAll();
        }

        //********************************************************
        //Load BOM for Openings objects
        //********************************************************
        if (!this.openings.isEmpty()) {
            Object[] rmp = this.openings.toArray();
            for (Object v : rmp) {
                OpeningObject op = (OpeningObject) v;
                op.loadOptionsAll();
            }
        }

    }

}

/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Model;


import Model.ProfileParts.*;
import Operations.AnalyseShape;
import Operations.CreateOpenings;
import Operations.CreateShapeMethods;
import Presentation.ItemFrame;
import dto.DTOTransformationError;
import dto.ShapeNotesDTO;
import dto.ShapeObjectDTO;
import openjanela.model.entities.design.*;
import openjanela.model.entities.partner.RuleTest;
import openjanela.model.entities.partner.Rules;

import org.apache.log4j.Logger;
import org.openjanela.data.ApplicationBaseApp;

import java.awt.geom.GeneralPath;
import java.math.BigDecimal;
import java.util.*;


public class Frame extends ShapeObject implements Cloneable {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(Frame.class);

    public boolean glazedout = false;

    //Shape Notes Fenestration Ratings
    public List<ShapeNotes> shapeNotesRatings = new ArrayList<ShapeNotes>();


    /**
     * Creating Frame Object
     */
    public Frame() {
        this.a_assemblyLevel = 3;
        this.a_levelID = 3;
    }

    /**
     * Create Frame Object
     *
     * @param parent,  ShapeObject
     * @param shape,   shape
     * @param startC,  starting column
     * @param startR,  staring row
     * @param endC,    ending column
     * @param endR,    ending row
     * @param myframe, ItemFrame
     */
    public Frame(ShapeObject parent, int shape, int startC, int startR, int endC, int endR, ItemFrame myframe) {

        //Call main constructor
        this();

        myFrame2 = myframe;
        myFacet = myframe.facetUsed;
        myParent = parent;
        shapeID = shape;
        startCol = startC;
        startRow = startR;
        endCol = endC;
        endRow = endR;

        //Create openings
        createOpenings = new CreateOpenings(this, myFrame2);
        ((ShapeObject) this).myFrame2 = myFrame2;

        BigDecimal myScale = new BigDecimal(0);

        if (myFrame2.myTopPanel.metric.isSelected()) {
            myScale = myFrame2.scale.multiply(new BigDecimal(100));
        } else {
            myScale = myFrame2.scale;
        }

        //Analyse shape object
        analyseShape = new AnalyseShape(this, false, parent.myFrame2, myScale);
    }

    /**
     * Create Frame Object model
     *
     * @param parent,      ShapeObject
     * @param myFrame,     ItemFrame
     * @param frameEntity, FrameEntityObject
     */
    public Frame(ShapeObject parent, ItemFrame myFrame, OpeningObject opening, FrameEntityObject frameEntity) {

        //Call main constructor
        this();

        //Setting parent
        this.myParent = parent;
        //Setting facet
        this.myFacet = parent;
        //Setting opening
        this.myParentO = opening;
        //Setting ItemFrame
        this.myFrame2 = myFrame;

        //Create Frame Object model
        createFrameObjectModel(frameEntity);
    }

    /**
     * Create Frame object
     */
    public Frame(ShapeObject parent, double wt, double hl, int shape, int sequence, double startingX, double startingY,
                 int startCol, int endCol, int startRow, int endRow, double bX2, double bY2, double bX3, double bY3,
                 double bX4, double bY4, double dimA1, double dimA2, double dimA3, double dimA4, double dimA5, double dimA0,
                 double dimB1, double dimB2, double dimB3, double dimB4, double dimB5, double dimB0, double dimC1, double dimC2,
                 double dimC3, double dimC4, double dimC5, double dimC0, double dimD1, double dimD2, double dimD3, double dimD4,
                 double dimD5, double dimD0, boolean wire, double centerPointX, double centerPointY, double centerPointX2,
                 double centerPointY2, double radius1, double radius2, double startAngle, double endAngle, double bkgrdStartX,
                 double bkgrdStartY, double centralAngle, double startingCX, double startingCY, double bCX2, double bCY2,
                 double bCX3, double bCY3, double bCX4, double bCY4, boolean topIn, boolean botIn, boolean rightIn, boolean leftIn,
                 int lean, int lean2, int lean3, int lean4, boolean shapeMod, boolean newPart, ItemFrame myframe) {

        //Call main constructor
        this();

        myFrame2 = myframe;
        myFacet = myframe.facetUsed;

        if (top1 == null) {
            top1 = new Top1Object();
            top2 = new Top2Object();
            top3 = new Top3Object();
            right = new RightObject();
            bot1 = new Bot1Object();
            bot2 = new Bot2Object();
            bot3 = new Bot3Object();
            left = new LeftObject();
        }

        myFacet = myframe.facetUsed;
        myParent = parent;
        shapeID = shape;

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
        this.radius1 = radius2;
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

        this.wire = wire;
        this.centerPointX = centerPointX;
        this.centerPointY = centerPointY;
        this.centerPointX2 = centerPointX2;
        this.centerPointY2 = centerPointY2;
        this.radius1 = radius1;
        this.radius2 = radius2;
        this.startAngle = startAngle;
        this.endAngle = endAngle;
        this.bkgrdStartX = bkgrdStartX;
        this.bkgrdStartY = bkgrdStartY;
        this.centralAngle = centralAngle;
        this.topIn = topIn;
        this.botIn = botIn;
        this.leftIn = leftIn;
        this.rightIn = rightIn;
        this.lean = lean;
        this.lean2 = lean2;
        this.lean3 = lean3;
        this.lean4 = lean4;
        this.shapeChanged = shapeMod;
        this.parentH = heightPix;
        this.parentW = widthPix;
        this.parentStartY = this.startingY;
        this.parentStartX = this.startingX;
        this.parentRadius1 = this.dimD2;

        this.parentCX = top1.x1;
        this.parentCY = top1.y1;
        this.parentCX2 = top1.x2;
        this.parentCY2 = top1.y2;
        this.parentShape = shapeID;

        if (shapeID == 450) {
            this.dimD2 = Math.sqrt(Math.pow(widthPix, 2) - Math.pow((widthPix / 2), 2));
            this.dimA1 = widthPix / 2;
            this.dimA2 = this.dimA1;
            this.dimB1 = this.dimD2;

        } else if (shapeID == 453) {
            this.dimD2 = Math.sqrt(Math.pow(widthPix, 2) - Math.pow((widthPix / 2), 2));
            widthPix = heightPix;
            this.dimA1 = widthPix / 2;
            this.dimA2 = this.dimA1;
        }

    }

    public Frame cloneFrame(final Frame original) {

        Frame newF = cloneFrameShape(original);
        newF.myFrame2.jobItem = original.myFrame2.jobItem;

        return newF;

    }

    public Frame cloneFrameShape(Frame original) {

        final Frame newOV = new Frame();

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

        // Cloning openings
        if (original.openings != null) {
            Collection newc = new ArrayList();
            Object[] rmp = original.openings.toArray();
            for (Object v : rmp) {
                newc.add(((OpeningObject) v).cloneOpening((OpeningObject) v));
            }
            newOV.openings = newc;
        }

        if (original.bOpeningObjectIn != null) {
            newOV.bOpeningObjectIn = original.bOpeningObjectIn.cloneBkgrdOpening(original.bOpeningObjectIn);
        }
        if (original.bOpeningObject != null) {
            newOV.bOpeningObject = original.bOpeningObject.cloneBkgrdOpening(original.bOpeningObject);
        }
        if (original.bOpeningObjectOut != null) {
            newOV.bOpeningObjectOut = original.bOpeningObjectOut.cloneBkgrdOpening(original.bOpeningObjectOut);
        }
        newOV.newRowH = original.newRowH;

        // Cloning frames
        if (original.frames != null) {
            Collection newc = new ArrayList();
            Object[] rmp = original.frames.toArray();
            for (final Object v : rmp) {
                newc.add(((Frame) v).cloneFrame(((Frame) v)));
            }
            newOV.frames = newc;
        }

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

        // newOV.ellipses = original.ellipses;
        newOV.setLeanTo = original.setLeanTo;
        newOV.minLeg = original.minLeg;
        newOV.wireFrame = original.wireFrame;
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
        newOV.gp = (GeneralPath) original.gp.clone();

        newOV.widthIO = original.widthIO;
        newOV.heightIO = original.heightIO;
        newOV.originalScaleI = original.originalScaleI;

        newOV.widthMO = original.widthMO;
        newOV.heightMO = original.heightMO;
        newOV.originalScaleM = original.originalScaleM;

        newOV.supplierId = original.supplierId;
        newOV.supplierSeriesId = original.supplierSeriesId;
        newOV.remote = original.remote;

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

        if (original.options != null) {
            Collection newc = new ArrayList();
            Object[] rmp = original.options.toArray();
            for (final Object v : rmp) {
                newc.add(((ShapeOption) v).clone(((ShapeOption) v)));
            }
            this.options = newc;
        }

        return newOV;
    }

    /**
     * This method create Frame Object Model
     *
     * @param frame, FrameEntityObject
     */
    private void createFrameObjectModel(FrameEntityObject frame) {

        //Create shape object model
        ShapeObjectDTO.getShapeObjectModel(frame, this, Frame.class);

        //********************************************************
        // 1. Creating background opening
        //********************************************************
        if (frame.getBkgrdOpening() != null) {
            this.bOpeningObject = new BkgrdOpeningObject(this, this.myFrame2, frame.getBkgrdOpening());

            //Do mullions object
            this.doMullions(this.bOpeningObject);
        }

        //********************************************************
        // 2. Creating Openings objects
        //********************************************************
        if (frame.getOpeningsObject() != null && !frame.getOpeningsObject().isEmpty()) {
            this.openings = new ArrayList();
            for (OpeningEntityObject opening : frame.getOpeningsObject()) {
                this.openings.add(new OpeningObject(this, this.myFrame2, opening));
            }
        }

        //*******************************************************
        //Do GeneralPath Parts Object Frames
        //*******************************************************
        CreateShapeMethods createShape = new CreateShapeMethods(this.myParentO, 2, myFrame2);
        createShape.doGPParts(this.partObjects, this, this.glazedOut);

        //Creating GeneralPath for parts objects adding a collection
        Collection<Profiles> partsObjects = new ArrayList<Profiles>();
        partsObjects.add(this.top1Part);
        partsObjects.add(this.top2Part);
        partsObjects.add(this.top3Part);
        partsObjects.add(this.leftPart);
        partsObjects.add(this.rightPart);
        partsObjects.add(this.bot1Part);
        partsObjects.add(this.bot2Part);
        partsObjects.add(this.bot3Part);

        createShape.doGPParts(partsObjects, this, this.glazedOut);
    }

    /**
     * This method create Frame Entity Object
     *
     * @param subFacet, SubFacetEntityObject
     * @return FrameEntityObject
     */
    public FrameEntityObject createFrameEntityObject(FacetEntityObject facet, SubFacetEntityObject subFacet) {

        //Create Frame entity object
        FrameEntityObject frameEntityObject = (FrameEntityObject) ShapeObjectDTO.getShapeAbstractObject(this, FrameEntityObject.class);

        //********************************************************
        // 1. Creating background opening
        //********************************************************
        if (this.bOpeningObject != null) {
            frameEntityObject.setBkgrdOpening(this.bOpeningObject.createBkgrdEntityObject());
        }

        //********************************************************
        // 2. Creating Openings objects
        //********************************************************
        if (!this.openings.isEmpty()) {

            //**********************************************************************************************************
            //Evaluate Fenestration Ratings Values
            //**********************************************************************************************************

            //Init Design Glass Ratings
            frameEntityObject.setDesignGlassRatings(new HashSet<DesignGlassRatingsEntityObject>());

            Set<OpeningEntityObject> openings = new HashSet<OpeningEntityObject>();
            Object[] rmp = this.openings.toArray();

            // ********************************************************
            // Creating Fenestration Products Code
            // ********************************************************

            //Clear frame shape notes collection
            this.myFrame2.jobItem.frameShapeNotes.clear();

            if (this.myFrame2.jobItem.shapeNotes.size() > 0) {

                Collection<ShapeNotes> notes = this.myFrame2.jobItem.shapeNotes;
                for (ShapeNotes shapeNotes : notes) {
                    boolean equals = shapeNotes.equalsShapeObject(this);
                    if (equals) {

                        //Update Stock Code & Description
                        shapeNotes.glassStockCode = shapeNotes.stockcode;
                        shapeNotes.glassDescription = shapeNotes.description;

                        //Adding Shape Notes to collection of frames
                        this.myFrame2.jobItem.frameShapeNotes.add(shapeNotes);
                    }
                }
            }

            for (Object v : rmp) {

                OpeningObject opening = (OpeningObject) v;
                openings.add(opening.createOpeningEntityObject(null, null, frameEntityObject, null));

                //*******************************************************************
                //Resolved fenestration glass ratings
                //*******************************************************************
                List<ShapeNotesEntityObject> notes = new ArrayList<ShapeNotesEntityObject>();
                for (ShapeNotes shapeNotes : this.myFrame2.jobItem.frameShapeNotes) {
                    notes.add(ShapeNotesDTO.getShapeNotesEntityObject(shapeNotes));
                }

                //*******************************************************************
                //Adding Design Glass Rating Object
                //*******************************************************************

                //Resolved Fenestration rating values from collection
                DesignGlassRatingsEntityObject designGlassRating = ShapeNotesDTO.getFenestrationRatingValue(frameEntityObject,
                        notes, this.supplierId, this.remote);

                //Select correct frame bom assign to
                for (BillOfMaterialEntityObject bom : frameEntityObject.getBoms()) {

                    //Return part type
                    int partType = 0;
                    if (bom.isRemote()) {
                        partType =  ItemFrame.getApplicationRemoteBaseRules().getPart(bom.getSupplierRemoteId(), bom.getPartId()).getParttype();
                    } else {
                        partType = ItemFrame.getApplicationBase().getPart(bom.getPartId()).getParttype();
                    }

                    if ((bom.getPartId() == bom.getAssemblyId()) && (partType == 12 || partType == 13)) {
                        designGlassRating.setFrameDescription(bom.getDescription());
                        designGlassRating.setFrameStockCode(bom.getStockCode());
                        designGlassRating.setBomId(bom.getBomId());
                    }
                }

                frameEntityObject.getDesignGlassRatings().add(designGlassRating);
            }

            frameEntityObject.setOpeningsObject(openings);
        }

        return frameEntityObject;
    }

    /**
     * This method create a copy of javabeans with a clone of properties values
     *
     * @param frameEntity, FrameEntityObject
     * @return FrameEntityObject
     */
    public FrameEntityObject cloneObjectModel(FrameEntityObject frameEntity) {

        /* Clone FrameEntityObject */
        FrameEntityObject frame = (FrameEntityObject) ShapeObjectDTO.cloneShapeAbstractObject(frameEntity,
                FrameEntityObject.class);

        frame.setBkgrdOpening(null);
        frame.setOpeningsObject(null);

        /* Clone background opening */
        if (frameEntity.getBkgrdOpening() != null) {
            BkgrdOpeningObject bkgrdOpening = new BkgrdOpeningObject();
            frame.setBkgrdOpening(bkgrdOpening.cloneObjectModel(frameEntity.getBkgrdOpening()));
        }

        /* Clone Opening objects */
        if (frameEntity.getOpeningsObject() != null && !frameEntity.getOpeningsObject().isEmpty()) {
            OpeningObject openingObject = new OpeningObject();

            Set<OpeningEntityObject> openings = new HashSet<OpeningEntityObject>();
            for (OpeningEntityObject openingEntity : frameEntity.getOpeningsObject()) {
                openings.add(openingObject.cloneObjectModel(openingEntity));
            }

            frame.setOpeningsObject(openings);
        }

        return frame;
    }

    /**
     * Reset Glass Bom Collection
     *
     * @throws Exception, Exception
     */
    public void resetGlassBom() throws Exception {

        //Reset Glass Bom
        if (!this.openings.isEmpty()) {
            for (Object v : this.openings) {
                ((OpeningObject) v).resetGlassBom();
            }
        }
    }

    /**
     * Reset Grids Bom Collection for Design
     *
     * @throws Exception, Exception
     */
    public void resetGridsBom() throws Exception {

        //Reset Grids Bom
        if (!this.openings.isEmpty()) {
            for (Object v : this.openings) {
                ((OpeningObject) v).resetGridsBom();
            }
        }
    }

    /**
     * Reset Shapes Notes Collection
     *
     * @throws Exception, Exception
     */
    public void resetShapeNotes() throws Exception {

        //Add ShapeObject notes to collection
        this.myFrame2.jobItem.shapeNotes.addAll(this.notes);

        //Reset Shape Notes Bkgrd Opening
        this.bOpeningObject.resetShapeNotes();

        if (!this.openings.isEmpty()) {
            for (Object v : this.openings) {
                ((OpeningObject) v).resetShapeNotes();
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

    @Override
    public Frame clone() {

        try {

            //Clone Frame object model
            Frame newFrame = (Frame) super.clone();

            //Clone parents
            if (newFrame.myParentO != null) {
                newFrame.myParentO = newFrame.myParentO.clone_opening();
                newFrame.myParentO.myParent = newFrame.myFacet;
                newFrame.myParentO.myFacet = newFrame.myFacet;
            }

            //Clone BkgrdOpening object model
            newFrame.bOpeningObject = this.bOpeningObject.clone();
            newFrame.bOpeningObject.myParent = newFrame;
            newFrame.bOpeningObject.myFacet = newFrame.myFacet;
            newFrame.bOpeningObject.myParentO = newFrame.myParentO;

            //Clone Openings object model
            List<OpeningObject> _openings = new ArrayList<OpeningObject>();
            for (Object opening : newFrame.openings) {
                OpeningObject o = ((OpeningObject) opening).clone();
                o.myParent = newFrame;
                o.myFacet = newFrame.myFacet;
                o.myOverall = newFrame.myOverall;

                _openings.add(o);
            }

            Collections.sort(_openings, ShapeObjectComparator._SEQUENCE_ID);
            newFrame.openings = new ArrayList<OpeningObject>(_openings);

            return newFrame;

        } catch (DTOTransformationError e) {
            logger.error(e.getMessage(), e);
        } catch (CloneNotSupportedException e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }

    //**********************************************************************************************
    //Implementing methods for Matrix calculation
    //**********************************************************************************************

    @Override
    public BigDecimal returnOpeningClassID() {
        return new BigDecimal(this.controlOpeningClass);
    }

    @Override
    public BigDecimal returnUserDefinedOpeningID() {
        return new BigDecimal(this.controlUserDefinedOpeningID);
    }

    @Override
    public boolean udOpeningTest(RuleTest test, List myRuleTestValues) {

        boolean pass = false;

        if (test.isrange) {
            pass = isWithinRange(test.value1, test.value2, this.controlUserDefinedOpeningID);

        } else {
            pass = isWithinValues(controlUserDefinedOpeningID, 0, myRuleTestValues.toArray());

        }

        /**
         * 1,0,Overall,1 2,1,Facet,1 3,3,Frame,1 4,121,Sash Type,1 5,12,Sash,1
         * 6,21,Glass/Glazing,1 7,0,Glazing Bead,1 8,22,DLO,1 20,5,Bkgrd
         * Opening,1 30,0,Divider,1 31,2,Coupler,1 32,4,Mullion,1 32,0,Grids,1
         * 40,5,Opening,1 200,1,Sub-Facet,1 400,121,Sub-Sash,1 902,0,Object,2
         * 903,0,Object,3 904,0,Object,4 905,0,Object,5 906,0,Object,6
         * 907,0,Object,7
         */

        if (test.isnot) {
            pass = !pass;
        }

        return pass;
    }

    @Override
    public boolean openingClassTest(RuleTest test, List myRuleTestValues) {

        boolean pass = false;

        if (test.isrange) {
            pass = isWithinRange(test.value1, test.value2, controlOpeningClass);

        } else {
            pass = isWithinValues(controlOpeningClass, 0, myRuleTestValues.toArray());

        }

        /**
         * 1,0,Overall,1 2,1,Facet,1 3,3,Frame,1 4,121,Sash Type,1 5,12,Sash,1
         * 6,21,Glass/Glazing,1 7,0,Glazing Bead,1 8,22,DLO,1 20,5,Bkgrd
         * Opening,1 30,0,Divider,1 31,2,Coupler,1 32,4,Mullion,1 32,0,Grids,1
         * 40,5,Opening,1 200,1,Sub-Facet,1 400,121,Sub-Sash,1 902,0,Object,2
         * 903,0,Object,3 904,0,Object,4 905,0,Object,5 906,0,Object,6
         * 907,0,Object,7
         */

        if (test.isnot) {
            pass = !pass;
        }

        return pass;
    }

	@Override
	public void isMatchingBOMRule(Rules rule, boolean doBOM) {

		// Execute Rule for Overall
		if (this.isMatchingRule(rule)) {
			executePartRules(rule, doBOM);
		}
		
		//********************************************************
        // 1. Creating background opening
        //********************************************************
        if (this.bOpeningObject != null) {
            this.bOpeningObject.isMatchingBOMRule(rule, doBOM);
        }

        //********************************************************
        // 2. Creating Openings
        //********************************************************
        if (!this.openings.isEmpty()) {
            Object[] rmp = this.openings.toArray();
            for (Object v : rmp) {
                OpeningObject opening = (OpeningObject) v;
                opening.isMatchingBOMRule(rule, doBOM);
            }
        }
	}

    @Override
    public void loadBOMParts() {

        //Load BOM Parts
        if (this.bom != null && this.bom.size() > 0) {
            this.myFrame2.jobItem.bom.addAll(this.bom);
        }

        //********************************************************
        // 1. Load BOM for background opening
        //********************************************************
        if (this.bOpeningObject != null) {
            this.bOpeningObject.loadBOMParts();
        }

        //********************************************************
        // 2. Load BOM for Openings
        //********************************************************
        if (!this.openings.isEmpty()) {
            Object[] rmp = this.openings.toArray();
            for (Object v : rmp) {
                OpeningObject opening = (OpeningObject) v;
                opening.loadBOMParts();
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

        //********************************************************
        // 1. Clear BOM for background opening
        //********************************************************
        if (this.bOpeningObject != null) {
            this.bOpeningObject.clearBOMParts();
        }

        //********************************************************
        // 2. Clear BOM for Openings
        //********************************************************
        if (!this.openings.isEmpty()) {
            Object[] rmp = this.openings.toArray();
            for (Object v : rmp) {
                OpeningObject opening = (OpeningObject) v;
                opening.clearBOMParts();
            }
        }
    }

    @Override
    public void loadOptionsAll() {

        //Load BOM Parts
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

        //********************************************************
        // 1. Load BOM for background opening
        //********************************************************
        if (this.bOpeningObject != null) {
            this.bOpeningObject.loadOptionsAll();
        }

        //********************************************************
        // 2. Load BOM for Openings
        //********************************************************
        if (!this.openings.isEmpty()) {
            Object[] rmp = this.openings.toArray();
            for (Object v : rmp) {
                OpeningObject opening = (OpeningObject) v;
                opening.loadOptionsAll();
            }
        }

    }

}

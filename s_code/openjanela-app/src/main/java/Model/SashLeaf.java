/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Model;


import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import openjanela.model.entities.design.*;
import openjanela.model.entities.partner.RuleTest;
import openjanela.model.entities.partner.Rules;

import org.apache.log4j.Logger;

import Model.ProfileParts.Bot1Object;
import Model.ProfileParts.Bot2Object;
import Model.ProfileParts.Bot3Object;
import Model.ProfileParts.LeftObject;
import Model.ProfileParts.Profiles;
import Model.ProfileParts.RightObject;
import Model.ProfileParts.Top1Object;
import Model.ProfileParts.Top2Object;
import Model.ProfileParts.Top3Object;
import Operations.AnalyseShape;
import Operations.CreateOpenings;
import Operations.CreateSash;
import Operations.CreateShapeMethods;
import Presentation.ItemFrame;
import dto.ShapeObjectDTO;


public class SashLeaf extends ShapeObject implements Cloneable {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(SashLeaf.class);

    //SashTypeObject parent
    public SashTypeObject myParent;

    public Collection symbol = new ArrayList();
    public Line2D mySymbolLine;

    /**
     * Create SashLeaf object
     */
    public SashLeaf() {
        a_assemblyLevel = 5;
        a_levelID = 12;
    }

    /**
     * Create SashLeaf EntityObject
     *
     * @param myFrame,        ItemFrame
     * @param sashLeafEntity, SashLeafEntityObject
     */
    public SashLeaf(ItemFrame myFrame, SashLeafEntityObject sashLeafEntity, SashTypeObject sashType) {

        //Call main constructor
        this();

        //Setting myParent object
        this.myParent = sashType;

        //Setting myParent opening object
        this.myParentO = sashType.myParentO;

        //Setting ItemFrame
        this.myFrame2 = myFrame;

        //Create SashLeaf model object
        createSashLeafModelObject(sashLeafEntity);

        //Create openings
        createOpenings = new CreateOpenings(this, myFrame2);
    }

    /**
     * Create SashLeaf object
     *
     * @param parent,   OpeningObject
     * @param sashType, int
     * @param myframe,  ItemFrame
     */
    public SashLeaf(OpeningObject parent, int sashType, ItemFrame myframe) {

        //Call former constructor
        this();

        this.myFrame2 = myframe;

        //Create openings
        this.createOpenings = new CreateOpenings(this, myFrame2);

        if (top1 == null) {

            top1 = new Top1Object();
            top2 = new Top2Object();
            top3 = new Top3Object();
            right = new RightObject();
            bot1 = new Bot1Object();
            bot2 = new Bot2Object();
            bot3 = new Bot3Object();
            left = new LeftObject();
            BigDecimal myScale = new BigDecimal(0);

            if (myFrame2.myTopPanel.metric.isSelected()) {
                myScale = myFrame2.scale.multiply(new BigDecimal(100));
            } else {
                myScale = myFrame2.scale;
            }
            analyseShape = new AnalyseShape(this, false, myFrame2, myScale);
        }

    }

    public SashLeaf cloneSashLeaf(SashLeaf original) {

        SashLeaf newSO = cloneSashShape(original);

        // Extend Specific Attributes Here

        newSO.leafNo = original.leafNo;
        newSO.trackNo = original.trackNo;

        newSO.symbol = this.cloneCollections(original.symbol);

        if (original.mySymbolLine != null) {
            newSO.mySymbolLine = (Line2D) original.mySymbolLine.clone();
        }

        return newSO;
    }

    public SashLeaf cloneSashShape(final SashLeaf original) {

        SashLeaf newOV = new SashLeaf(original.myParentO, original.paneType, myFrame2);

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

        if (original.openings != null) {
            newOV.openings = this.cloneCollections(original.openings);
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

        // newOV.ellipses = original.ellipses;
        newOV.setLeanTo = original.setLeanTo;
        newOV.minLeg = original.minLeg;
        newOV.wireFrame = original.wireFrame;

        newOV.parentid = original.parentid;
        newOV.parentStartRow = original.parentStartRow;
        newOV.parentStartCol = original.parentStartCol;

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

        // newOV.top1 = original.myTop1Clone(newOV.top1, original.top1);
        // newOV.top2 = original.myTop2Clone(newOV.top2, original.top2);
        // newOV.top3 = original.myTop3Clone(newOV.top3, original.top3);
        // newOV.right = original.myRightClone(newOV.right, original.right);
        // newOV.left = original.myLeftClone(newOV.left, original.left);
        // newOV.bot1 = original.myBot1Clone(newOV.bot1, original.bot1);
        // newOV.bot2 = original.myBot2Clone(newOV.bot2, original.bot2);
        // newOV.bot3 = original.myBot3Clone(newOV.bot3, original.bot3);
        // newOV.top1Part = original.top1Part.cloneProfile(original.top1Part);
        // newOV.top2Part = original.top2Part.cloneProfile(original.top2Part);
        // newOV.top3Part = original.top3Part.cloneProfile(original.top3Part);
        // newOV.rightPart =
        // original.rightPart.cloneProfile(original.rightPart);
        // newOV.leftPart = original.leftPart.cloneProfile(original.leftPart);
        // newOV.bot1Part = original.bot1Part.cloneProfile(original.bot1Part);
        // newOV.bot2Part = original.bot2Part.cloneProfile(original.bot2Part);
        // newOV.bot3Part = original.bot3Part.cloneProfile(original.bot3Part);

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

        if (original.myMullionBot != null) {
            newOV.myMullionBot = original.myMullionBot.cloneProfile(original.myMullionBot,
                    original.myParent.myParentFrame.bOpeningObject);
        }

        if (original.myMullionTop != null) {
            newOV.myMullionTop = original.myMullionTop.cloneProfile(original.myMullionTop,
                    original.myParent.myParentFrame.bOpeningObject);
        }

        if (original.myMullionLeft != null) {
            newOV.myMullionLeft = original.myMullionLeft.cloneProfile(original.myMullionLeft,
                    original.myParent.myParentFrame.bOpeningObject);
        }

        if (original.myMullionRight != null) {
            newOV.myMullionRight = original.myMullionRight.cloneProfile(original.myMullionRight,
                    original.myParent.myParentFrame.bOpeningObject);
        }

        newOV.findDLO = original.findDLO;
        newOV.analyseShape = original.analyseShape;
        newOV.myCanvas = original.myCanvas;
        newOV.verify = original.verify;
        newOV.setLeanTo = original.setLeanTo;
        newOV.createOpenings = original.createOpenings;

        // Cloning Options
        if (original.options != null) {
            Collection newc = new ArrayList();
            Object[] rmp = original.options.toArray();

            for (final Object v : rmp) {
                newc.add(((ShapeOption) v).clone((ShapeOption) v));
            }
            newOV.options = newc;

        }

        newOV.supplierId = original.supplierId;
        newOV.supplierSeriesId = original.supplierSeriesId;
        newOV.remote = original.remote;

        return newOV;
    }

    /**
     * This method create SashLeaf Model Object
     *
     * @param sashLeaf, SashLeafEntityObject
     */
    private void createSashLeafModelObject(SashLeafEntityObject sashLeaf) {

        //Creating SashLeaf model object
        ShapeObjectDTO.getShapeObjectModel(sashLeaf, this, SashLeaf.class);

        this.leafNo = sashLeaf.getLeafNo();
        this.trackNo = sashLeaf.getTrackNo();
        this.paneType = sashLeaf.getPaneType();

        //********************************************************
        // 1. Create Background opening
        //********************************************************
        if (sashLeaf.getBkgrdOpening() != null) {
            this.bOpeningObject = new BkgrdOpeningObject(this, this.myFrame2, sashLeaf.getBkgrdOpening());

            //Do mullions object
            this.doMullions(this.bOpeningObject);
        }

        //********************************************************
        // 2. Creating Openings objects
        //********************************************************
        if (sashLeaf.getOpenings() != null && !sashLeaf.getOpenings().isEmpty()) {
            this.openings = new ArrayList();
            for (OpeningEntityObject opening : sashLeaf.getOpenings()) {
          	  this.openings.add(new OpeningObject(this, this.myFrame2, opening));
            }
        }

        //********************************************************
        // Creating General Paths
        //********************************************************
        CreateShapeMethods createShape = new CreateShapeMethods(this.myParent, 2, this.myFrame2);
        createShape.doGPParts(this.partObjects, this, this.glazedOut);

        //********************************************************
        // Creating SashSymbol
        //********************************************************
        CreateSash createSash = new CreateSash(this);
        createSash.notracks = this.noTracks;
        createSash.ntracks = this.myParent.noTracks;

        if (ItemFrame.getApplicationBaseRules().getSeriesValidOpeningById(myParent.userDefinedOpeningID) != null) {
            createSash.fixedSashOuttrack = ItemFrame.getApplicationBaseRules().
                    getSeriesValidOpeningById(myParent.userDefinedOpeningID).isOutTrackFixed();
        } else {
            createSash.fixedSashOuttrack = ItemFrame.getApplicationRemoteBaseRules().
                    getSeriesValidOpeningById(myParent.userDefinedOpeningID).isOutTrackFixed();
        }

        createSash.doSashSymbol(this);

        //********************************************************
        // Creating couplers
        //********************************************************
        this.doCouplers();
    }

    /**
     * This method create SashLeaf entity object
     *
     * @return SashLeafEntityObject
     */
    public SashLeafEntityObject CreateSashLeafEntityObject() {

        //Creating Sash Leaf entity object
        SashLeafEntityObject sashLeaf = (SashLeafEntityObject) ShapeObjectDTO.getShapeAbstractObject(this, SashLeafEntityObject.class);

        sashLeaf.setLeafNo(this.leafNo);
        sashLeaf.setTrackNo(this.trackNo);
        sashLeaf.setPaneType(this.paneType);

        //********************************************************
        // 1. Create Background opening
        //********************************************************
        if (this.bOpeningObject != null) {
            sashLeaf.setBkgrdOpening(this.bOpeningObject.createBkgrdEntityObject());
        }

        //********************************************************
        // 2. Creating Openings objects
        //********************************************************
        if (!this.openings.isEmpty()) {
            Set<OpeningEntityObject> openings = new HashSet<OpeningEntityObject>();
            Object[] rmp = this.openings.toArray();
            for (Object v : rmp) {
                OpeningObject opening = (OpeningObject) v;
                openings.add(opening.createOpeningEntityObject(null, null, null, sashLeaf));
            }
            sashLeaf.setOpenings(openings);
        }

        return sashLeaf;
    }

    /**
     * Reset Glass Bom Collection
     *
     * @throws Exception, Exception
     */
    public void resetGlassBom() throws Exception {

        //Reset Opening Glass Bom
        if (!this.openings.isEmpty()) {
            for (Object v : this.openings) {
                ((OpeningObject)v).resetGlassBom();
            }
        }
    }

    /**
     * Reset Grids Bom Collection
     *
     * @throws Exception, Exception
     */
    public void resetGridsBom() throws Exception {

        //Reset Opening Grids Bom
        if (!this.openings.isEmpty()) {
            for (Object v : this.openings) {
                ((OpeningObject)v).resetGridsBom();
            }
        }
    }

    /**
     * Reset Shapes Notes Collection
     *
     * @throws Exception, Exception
     */
    public void resetShapeNotes() throws Exception {

        //Adding Glass Bom for GlassSU to JobItem
        this.myFrame2.jobItem.shapeNotes.addAll(this.notes);

        if (!this.openings.isEmpty()) {
            for (Object v : this.openings) {
                ((OpeningObject)v).resetShapeNotes();
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
                GlassSU glass = ((OpeningObject)v).getGlassSU(designGlass);
                if (glass != null) {
                    glassSU = glass;
                }
            }
        }

        return glassSU;
    }

    /**
     * This method create a copy of javabeans with a clone of properties values
     *
     * @param sashLeafEntity, SashLeafEntity
     * @return SashLeafEntityObject
     */
    public SashLeafEntityObject cloneObjectModel(SashLeafEntityObject sashLeafEntity) {

        /* Clone Sash Leaf Entity Object */
        SashLeafEntityObject sashLeaf = (SashLeafEntityObject) ShapeObjectDTO.cloneShapeAbstractObject(sashLeafEntity,
                SashLeafEntityObject.class);

        sashLeaf.setLeafNo(sashLeafEntity.getLeafNo());
        sashLeaf.setTrackNo(sashLeafEntity.getTrackNo());
        sashLeaf.setPaneType(sashLeafEntity.getPaneType());

        sashLeaf.setBkgrdOpening(null);
        sashLeaf.setOpenings(null);

        /* Clone BkgrdOpening Entity Object */
        if (sashLeafEntity.getBkgrdOpening() != null) {
            BkgrdOpeningObject bkgrdOpeningObject = new BkgrdOpeningObject();
            BkgrdOpeningEntityObject bkgrdOpening = bkgrdOpeningObject.cloneObjectModel(sashLeafEntity.getBkgrdOpening());
            sashLeaf.setBkgrdOpening(bkgrdOpening);
        }

        //Clone Openings
        if (sashLeafEntity.getOpenings() != null && !sashLeafEntity.getOpenings().isEmpty()) {
            OpeningObject openingObject = new OpeningObject();

            Set<OpeningEntityObject> openings = new HashSet<OpeningEntityObject>();
            for (OpeningEntityObject opening : sashLeafEntity.getOpenings()) {
                openings.add(openingObject.cloneObjectModel(opening));
            }

            sashLeaf.setOpenings(openings);
        }

        return sashLeaf;
    }

    @Override
    public SashLeaf clone() {

        try {

            //Clone Sash Leaf object model
            SashLeaf newSashLeaf = (SashLeaf) super.clone();

            //Clone BkgrdOpening object
            newSashLeaf.bOpeningObject = this.bOpeningObject.clone();

            //Clone symbol line sash
            Collection _symbols = new ArrayList();
            for (Object symbol : newSashLeaf.symbol) {
                Line2D _symbol = (Line2D)((Line2D)symbol).clone();
                _symbols.add(_symbol);
            }
            newSashLeaf.symbol = _symbols;

            //Clone Opening collection
            Collection _openings = new ArrayList();
            for (Object opening : newSashLeaf.openings) {
                _openings.add(((OpeningObject) opening).clone());
            }
            newSashLeaf.openings = _openings;

            return newSashLeaf;

        } catch (CloneNotSupportedException e) {
            logger.error(e.getMessage());
        }

        return null;
    }

    //**********************************************************************************************
    //Implementing methods for Matrix calculation
    //**********************************************************************************************
    @Override
    public boolean sashNoTest(RuleTest test, List myRuleTestValues) {

        boolean pass = false;

        if (test.isrange) {
            pass = isWithinRange(test.value1, test.value2, leafNo);

        } else {
            pass = isWithinValues(leafNo, 0, myRuleTestValues.toArray());

        }

        if (test.isnot) {
            pass = !pass;
        }

        return pass;
    }

    @Override
    public boolean trackNoTest(RuleTest test, List myRuleTestValues) {

        boolean pass = false;

        if (test.isrange) {
            pass = isWithinRange(test.value1, test.value2, trackNo);

        } else {
            pass = isWithinValues(trackNo, 0, myRuleTestValues.toArray());

        }

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

		// ************************************************
		// 1. Creating background opening
		// ************************************************
		this.bOpeningObject.isMatchingBOMRule(rule, doBOM);

		// ************************************************
		// 2. Creating openings entity objects
		// ************************************************
		if (this.openings != null) {
			Object[] rmp = this.openings.toArray();
			for (Object v : rmp) {
				((OpeningObject) v).isMatchingBOMRule(rule, doBOM);
			}
		}

	}

    @Override
    public void loadBOMParts() {

        //Load BOM Parts
        if (this.bom != null && this.bom.size() > 0) {
            this.myFrame2.jobItem.bom.addAll(this.bom);
        }

        // ************************************************
        // 1. Load BOM background opening
        // ************************************************
        this.bOpeningObject.loadBOMParts();

        // ************************************************
        // 2. Load BOM openings entity objects
        // ************************************************
        if (this.openings != null) {
            Object[] rmp = this.openings.toArray();
            for (Object v : rmp) {
                ((OpeningObject) v).loadBOMParts();
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

        // ************************************************
        // 1. Creating background opening
        // ************************************************
        this.bOpeningObject.clearBOMParts();

        // ************************************************
        // 2. Creating openings entity objects
        // ************************************************
        if (this.openings != null) {
            Object[] rmp = this.openings.toArray();
            for (Object v : rmp) {
                ((OpeningObject) v).clearBOMParts();
            }
        }
    }

    @Override
    public void loadOptionsAll() {

    }

}

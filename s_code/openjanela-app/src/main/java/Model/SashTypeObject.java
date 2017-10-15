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
import java.util.List;
import java.util.Set;

import openjanela.model.entities.design.BkgrdOpeningEntityObject;
import openjanela.model.entities.design.OpeningEntityObject;
import openjanela.model.entities.design.SashLeafEntityObject;
import openjanela.model.entities.design.SashTypeEntityObject;
import openjanela.model.entities.partner.RuleTest;
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
import Operations.CreateShapeMethods;
import Presentation.ItemFrame;
import dto.DTOTransformationError;
import dto.ShapeObjectDTO;


public class SashTypeObject extends ShapeObject implements Cloneable {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(SashTypeObject.class);

    public ShapeObject myParentFrame;

    public int sashClassType = 0;
   
    
    public int louvreStdSizeM = 15000;
	public int louvreStdSizeI = 6 * 64;
	public int louvreOverlapM = 2000;
	public int louvreOverlapI = 64;
	public boolean louvrePartial= true;
	public boolean isglazed= true;
	
	

    public int noOfLeafs = 0;
    public int noTracks = 1;
    public int[] sashOnTrack;
    public int whichPos = 0;
    public int opens = 0;

    // 0= slide/fold
    // 1=In
    // 2 = out
    public boolean isOriel = false;
    public double split = 0;

    public double percentA = 0;
    public double percentB = 0;
    public double percentC = 0;

    public int sequenceID = 0;

    public boolean[] sashGlazedOut;

    public String systemName = "SysName ";
    public String userDefName = "User Defined Name";

    public int[] paneType;
    public int[] interLocks;
    public double extraExtend = 0;
    public int openingTypeClass = 1;    /*1=window, 2=door, 3=entry, 4=Standard Size Window.*/


    /**
     * Create SashType Object
     */
    public SashTypeObject() {

    }

    /**
     * Create SashType Object
     *
     * @param myframe, ItemFrame
     */
    public SashTypeObject(ItemFrame myframe) {

        this.a_levelID = 121;
        this.a_assemblyLevel = 4;
        this.myFrame2 = myframe;

        this.scaleM = myFrame2.scale;

        this.systemName = "SysName ";
        this.userDefName = "User Defined Name";
    }

    /**
     * SashType entity object
     *
     * @param parent,   OpeningObject
     * @param myFrame,  ItemFrame
     * @param sashType, SashTypeEntityObject
     */
    public SashTypeObject(OpeningObject parent, ItemFrame myFrame, SashTypeEntityObject sashType) {

        //Call main constructor
        this(myFrame);

        //Setting parent object
        this.myParentO = parent;

        //Setting parent object
        this.myParent = parent.myParent;

        //Setting myParentFrame object
        this.myParentFrame = parent.myParent;

        //Setting myFacet object
        this.myFacet = myParent.myParent;

        //Create SashTypeObject
        createSashTypeModelObject(sashType);

    }

    /**
     * Create SashType Object
     *
     * @param parentO,       OpeningObject
     * @param mySashType,    int
     * @param mySashID,      int
     * @param myNoOfLeafs,   int
     * @param myNotracks,    int
     * @param myPos,         int
     * @param myOpens,       int
     * @param mySplit,       double
     * @param mySashOnTrack, int[]
     * @param myparent,      ShapeObject
     * @param glazedout,     boolean
     * @param myframe,       ItemFrame
     */
    public SashTypeObject(OpeningObject parentO, int mySashType, int mySashID, int myNoOfLeafs, int myNotracks,
                          int myPos, int myOpens, double mySplit, int[] mySashOnTrack, ShapeObject myparent,
                          boolean glazedout, ItemFrame myframe) {

        //Call super constructor
        this(myframe);

        myParentO = parentO;
        sashClassType = mySashType;
        userDefinedOpeningID = mySashID;
        noOfLeafs = myNoOfLeafs;
        sashOnTrack = mySashOnTrack;
        noTracks = myNotracks;
        whichPos = myPos;
        opens = myOpens; // 0= slide/fold 1= In 2 = out
        split = mySplit;
        glazedOut = glazedout;
        myParentFrame = myparent;
    }

    public SashTypeObject cloneSashType(final SashTypeObject original) {

        final SashTypeObject newSash = cloneSashTypeShape(original);

        // Extend Specific Attributes Here

        newSash.sashClassType = original.sashClassType;

        newSash.userDefinedOpeningID = original.userDefinedOpeningID;
        newSash.noOfLeafs = original.noOfLeafs;
        newSash.noTracks = original.noTracks;
        newSash.sashOnTrack = original.sashOnTrack;
        newSash.whichPos = original.whichPos;
        newSash.a_levelID = original.a_levelID;
        newSash.opens = original.opens;
        newSash.isOriel = original.isOriel;
        newSash.split = original.split;
        newSash.sequenceID = original.sequenceID;

        newSash.sashGlazedOut = original.sashGlazedOut;
        newSash.paneType = original.paneType;
        newSash.interLocks = original.interLocks;
        newSash.extraExtend = original.extraExtend;

        newSash.systemName = original.systemName;
        newSash.userDefName = original.userDefName;
        
        newSash.louvreOverlapI = original.louvreOverlapI;
        newSash.louvreOverlapM = original.louvreOverlapM;
        newSash.louvreStdSizeI = original.louvreStdSizeI;
        newSash.louvreStdSizeM = original.louvreStdSizeM;
        newSash.louvrePartial = original.louvrePartial;
        newSash.isglazed = original.isglazed;
        

        return newSash;

    }

    /**
     * Clone Sash Type
     *
     * @param original , SashTypeObject
     * @return SashTypeObject
     */
    public SashTypeObject cloneSashTypeShape(SashTypeObject original) {

        // Create SashType object
        SashTypeObject newOV = new SashTypeObject(original.myParentO, original.sashClassType, original.userDefinedOpeningID,
                original.noOfLeafs,
                original.noTracks, original.whichPos, original.opens, original.split, original.sashOnTrack,
                original.myParentFrame, original.glazedOut, myFrame2);

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
                newc.add(((SashLeaf) v).cloneSashLeaf((SashLeaf) v));
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

        newOV.louvreOverlapI = original.louvreOverlapI;
        newOV.louvreOverlapM = original.louvreOverlapM;
        newOV.louvreStdSizeI = original.louvreStdSizeI;
        newOV.louvreStdSizeM = original.louvreStdSizeM;
        newOV.louvrePartial = original.louvrePartial;
        newOV.isglazed = original.isglazed;

        newOV.supplierId = original.supplierId;
        newOV.supplierSeriesId = original.supplierSeriesId;
        newOV.remote = original.remote;

        return newOV;
    }

    /**
     * This method create SashType model object
     *
     * @param sashType, SashTypeEntityObject
     */
    public void createSashTypeModelObject(SashTypeEntityObject sashType) {

        //Creating SashType entity object
        ShapeObjectDTO.getShapeObjectModel(sashType, this, SashTypeObject.class);
        this.sashClassType = sashType.getSashType();
        this.userDefinedOpeningID = sashType.getSashID();
        this.noOfLeafs = sashType.getNoOfLeafs();
        this.noTracks = sashType.getNoTracks();
        
        this.louvreOverlapI = sashType.getLouvreOverlapI();
        this.louvreOverlapM = sashType.getLouvreOverlapM();
        this.louvreStdSizeI = sashType.getStdLouvreSizeI();
        this.louvreStdSizeM = sashType.getStdLouvreSizeM();
        
        this.louvrePartial = sashType.isLouvrePartial();
        this.isglazed = sashType.isGlazed();
        
        
        this.whichPos = sashType.getWhichPos();
        this.opens = sashType.getOpens();
        this.isOriel = sashType.isOriel();
        this.split = sashType.getSplit().doubleValue();
        this.percentA = sashType.getPercentA().doubleValue();
        this.percentB = sashType.getPercentB().doubleValue();
        this.percentC = sashType.getPercentC().doubleValue();
        this.sashGlazedOut = sashType.getSashGlazedOut();
        this.sashOnTrack = sashType.getSashOnTrack();
        this.paneType = sashType.getPaneType();
        this.interLocks = sashType.getInterLocks();

        //*******************************************************
        // 1. Creating background opening
        //*******************************************************
        if (sashType.getBkgrdOpening() != null) {
            this.bOpeningObject = new BkgrdOpeningObject(this, this.myFrame2, sashType.getBkgrdOpening());

            //Do mullions object
            this.doMullions(this.bOpeningObject);
        }

        //*******************************************************
        //2. Creating openings entity objects
        //*******************************************************
        if (sashType.getOpenings() != null && !sashType.getOpenings().isEmpty()) {
            this.openings = new ArrayList();
            for (OpeningEntityObject opening : sashType.getOpenings()) {
                openings.add(new OpeningObject(this, this.myFrame2, opening));
            }
        }

        //*******************************************************
        // 3. Creating sash leaf
        //*******************************************************
        if (sashType.getSashLeafes() != null && !sashType.getSashLeafes().isEmpty()) {
            this.frames = new ArrayList();
            for (SashLeafEntityObject sashLeaf : sashType.getSashLeafes()) {
                this.frames.add(new SashLeaf(this.myFrame2, sashLeaf, this));
            }
        }

        //*******************************************************
        //Do GeneralPath Parts Object Frames
        //*******************************************************
        CreateShapeMethods createShape = new CreateShapeMethods(this.myParentO, 2, myFrame2);
        createShape.doGPParts(this.partObjects, this, this.glazedOut);
    }

    /**
     * This method create SashType entity object
     *
     * @return SashTypeEntityObject
     */
    public SashTypeEntityObject createSashTypeEntityObject() {

        //Creating sash type entity object
        SashTypeEntityObject sashType = (SashTypeEntityObject) ShapeObjectDTO.getShapeAbstractObject(this, SashTypeEntityObject.class);
        sashType.setSashType(this.sashClassType);
        sashType.setSashID(this.userDefinedOpeningID);
        sashType.setStdLouvreSizeI(this.louvreStdSizeI);
        sashType.setStdLouvreSizeM(this.louvreStdSizeM);
        sashType.setLouvreOverlapI(this.louvreOverlapI);
        sashType.setLouvreOverlapM(this.louvreOverlapM);
        sashType.setLouvrePartial(louvrePartial);
        sashType.setGlazed(isglazed);
        sashType.setNoOfLeafs(this.noOfLeafs);
        sashType.setNoTracks(this.noTracks);
        sashType.setWhichPos(this.whichPos);
        sashType.setOpens(this.opens);
        sashType.setOriel(this.isOriel);
        sashType.setSplit(new BigDecimal(this.split + ""));
        sashType.setPercentA(new BigDecimal(this.percentA + ""));
        sashType.setPercentB(new BigDecimal(this.percentB + ""));
        sashType.setPercentC(new BigDecimal(this.percentC + ""));
        sashType.setSashGlazedOut(this.sashGlazedOut);
        sashType.setSashOnTrack(this.sashOnTrack);
        sashType.setPaneType(this.paneType);
        sashType.setInterLocks(this.interLocks);

        //****************************************************
        // 1. Creating background opening
        //****************************************************
        if (this.bOpeningObject != null) {
            sashType.setBkgrdOpening(this.bOpeningObject.createBkgrdEntityObject());
        }

        //****************************************************
        //2. Creating openings entity objects
        //****************************************************
        if (this.openings != null) {
            Set<OpeningEntityObject> openings = new HashSet<OpeningEntityObject>();
            Object[] rmp = this.openings.toArray();
            for (Object v : rmp) {
                openings.add(((OpeningObject) v).createOpeningEntityObject(null, null, null, null));
            }
            sashType.setOpenings(openings);
        }

        //****************************************************
        // 3. Creating sashLeaf
        //****************************************************
        if (this.frames != null && this.frames.size() > 0) {
            Set<SashLeafEntityObject> sashLeafs = new HashSet<SashLeafEntityObject>();
            Object[] rmp = this.frames.toArray();
            for (Object v : rmp) {
                SashLeaf sashLeaf = (SashLeaf) v;
                sashLeafs.add(sashLeaf.CreateSashLeafEntityObject());
            }
            sashType.setSashLeafes(sashLeafs);
        }

        return sashType;
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
                ((OpeningObject) v).resetGlassBom();
            }
        }

        //Reset Frames Glass Bom
        if (!this.frames.isEmpty()) {
            for (Object v : this.frames) {
                ((SashLeaf) v).resetGlassBom();
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
                ((OpeningObject) v).resetGridsBom();
            }
        }

        //Reset Frames Grids Bom
        if (!this.frames.isEmpty()) {
            for (Object v : this.frames) {
                ((SashLeaf) v).resetGridsBom();
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

        //Reset Shape Notes Bkgrd Opening
        this.bOpeningObject.resetShapeNotes();

        if (!this.openings.isEmpty()) {
            for (Object v : this.openings) {
                ((OpeningObject) v).resetShapeNotes();
            }
        }

        if (!this.frames.isEmpty()) {
            for (Object v : this.frames) {
                ((SashLeaf) v).resetShapeNotes();
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

        if (!this.frames.isEmpty()) {
            for (Object v : this.frames) {
                GlassSU glass = ((SashLeaf) v).getGlassSU(designGlass);
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
     * @param sashTypeEntity, SashTypeEntity
     * @return OverallEntityObject
     */
    public SashTypeEntityObject cloneObjectModel(SashTypeEntityObject sashTypeEntity) {
		
		/* Clone SashType entity object */
        SashTypeEntityObject sashType = (SashTypeEntityObject) ShapeObjectDTO.cloneShapeAbstractObject(sashTypeEntity,
                SashTypeEntityObject.class);

        sashType.setSashType(sashTypeEntity.getSashType());
        sashType.setSashID(sashTypeEntity.getSashID());
        sashType.setStdLouvreSizeI(sashTypeEntity.getStdLouvreSizeI());
        sashType.setStdLouvreSizeM(sashTypeEntity.getStdLouvreSizeM());
        sashType.setLouvreOverlapI(sashTypeEntity.getLouvreOverlapI());
        sashType.setLouvreOverlapM(sashTypeEntity.getLouvreOverlapM());
        sashType.setLouvrePartial(sashTypeEntity.isLouvrePartial());
        sashType.setGlazed(sashTypeEntity.isGlazed());
        sashType.setNoOfLeafs(sashTypeEntity.getNoOfLeafs());
        sashType.setNoTracks(sashTypeEntity.getNoTracks());
        sashType.setWhichPos(sashTypeEntity.getWhichPos());
        sashType.setOpens(sashTypeEntity.getOpens());
        sashType.setOriel(sashTypeEntity.isOriel());
        sashType.setSplit(sashTypeEntity.getSplit());
        sashType.setPercentA(sashTypeEntity.getPercentA());
        sashType.setPercentB(sashTypeEntity.getPercentB());
        sashType.setPercentC(sashTypeEntity.getPercentC());

        sashType.setBkgrdOpening(null);
        sashType.setOpenings(null);
        sashType.setSashLeafes(null);
		
		/* Clone BkgrdOpening object model */
        if (sashTypeEntity.getBkgrdOpening() != null) {
            BkgrdOpeningObject bkgrdOpeningObject = new BkgrdOpeningObject();
            BkgrdOpeningEntityObject bkgrdOpening = bkgrdOpeningObject.cloneObjectModel(sashTypeEntity.getBkgrdOpening());
            sashType.setBkgrdOpening(bkgrdOpening);
        }
		
		/* Clone Openings object model */
        if (sashTypeEntity.getOpenings() != null && !sashTypeEntity.getOpenings().isEmpty()) {
            OpeningObject openingObject = new OpeningObject();

            Set<OpeningEntityObject> openings = new HashSet<OpeningEntityObject>();
            for (OpeningEntityObject opening : sashTypeEntity.getOpenings()) {
                openings.add(openingObject.cloneObjectModel(opening));
            }

            sashType.setOpenings(openings);
        }
		
		/* Clone sash leafs object model */
        if (sashTypeEntity.getSashLeafes() != null && !sashTypeEntity.getSashLeafes().isEmpty()) {
            SashLeaf sashLeafObject = new SashLeaf();

            Set<SashLeafEntityObject> sashLeafs = new HashSet<SashLeafEntityObject>();
            for (SashLeafEntityObject sashLeaf : sashTypeEntity.getSashLeafes()) {
                sashLeafs.add(sashLeafObject.cloneObjectModel(sashLeaf));
            }

            sashType.setSashLeafes(sashLeafs);
        }

        return sashType;
    }

    @Override
    public SashTypeObject clone() {

        try {

            //Clone Sash Type object model
            SashTypeObject newSashType = (SashTypeObject) super.clone();

            //Clone BkgrdOpening object model
            newSashType.bOpeningObject = this.bOpeningObject.clone();

            //Clone Opening opening collection
            Collection _openings = new ArrayList();
            for (Object opening : newSashType.openings) {
                _openings.add(((OpeningObject) opening).clone());
            }
            newSashType.openings = _openings;

            //Clone SashLeaf collection
            Collection _sashLeafs = new ArrayList();
            for (Object sashLeaf : newSashType.frames) {
                _sashLeafs.add(((SashLeaf) sashLeaf).clone());
            }
            newSashType.frames = _sashLeafs;

            return newSashType;

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
    public boolean noTrackTest(RuleTest test, int uom, List myRuleTestValues) {

        boolean pass = false;

        if (test.isrange) {
            pass = isWithinRange(test.value1, test.value2, this.noTracks);

        } else {
            pass = isWithinValues(this.noTracks, 0, myRuleTestValues.toArray());

        }

        if (test.isnot) {
            pass = !pass;
        }

        return pass;
    }

    @Override
    public boolean noSashesTest(RuleTest test, int uom, List myRuleTestValues) {

        boolean pass = false;

        if (test.isrange) {
            pass = isWithinRange(test.value1, test.value2, this.noOfLeafs);

        } else {
            pass = isWithinValues(this.noOfLeafs, 0, myRuleTestValues.toArray());

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

        //************************************************
        //1. Creating background opening
        //************************************************
        this.bOpeningObject.isMatchingBOMRule(rule, doBOM);

        //************************************************
        //2. Creating openings entity objects
        //************************************************
        if (this.openings != null) {
            Object[] rmp = this.openings.toArray();
            for (Object v : rmp) {
                ((OpeningObject) v).isMatchingBOMRule(rule, doBOM);
            }
        }

        //************************************************
        //3. Creating facets entity objects
        //************************************************
        if (!this.frames.isEmpty()) {
            Object[] rmp = this.frames.toArray();
            for (Object v : rmp) {
                ((SashLeaf) v).isMatchingBOMRule(rule, doBOM);
            }
        }
    }

    @Override
    public void loadBOMParts() {

        //Load BOM Parts
        if (this.bom != null && this.bom.size() > 0) {
            this.myFrame2.jobItem.bom.addAll(this.bom);
        }

        //************************************************
        //1. Load BOM for background opening
        //************************************************
        this.bOpeningObject.loadBOMParts();

        //************************************************
        //2. Load BOM for openings entity objects
        //************************************************
        if (this.openings != null) {
            Object[] rmp = this.openings.toArray();
            for (Object v : rmp) {
                ((OpeningObject) v).loadBOMParts();
            }
        }

        //************************************************
        //3. Load BOM for facets entity objects
        //************************************************
        if (!this.frames.isEmpty()) {
            Object[] rmp = this.frames.toArray();
            for (Object v : rmp) {
                ((SashLeaf) v).loadBOMParts();
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

        //************************************************
        //1. Creating background opening
        //************************************************
        this.bOpeningObject.clearBOMParts();

        //************************************************
        //2. Creating openings entity objects
        //************************************************
        if (this.openings != null) {
            Object[] rmp = this.openings.toArray();
            for (Object v : rmp) {
                ((OpeningObject) v).clearBOMParts();
            }
        }

        //************************************************
        //3. Creating facets entity objects
        //************************************************
        if (!this.frames.isEmpty()) {
            Object[] rmp = this.frames.toArray();
            for (Object v : rmp) {
                ((SashLeaf) v).clearBOMParts();
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

        //************************************************
        //1. Load BOM for background opening
        //************************************************
        this.bOpeningObject.loadOptionsAll();

        //************************************************
        //2. Load BOM for openings entity objects
        //************************************************
        if (this.openings != null) {
            Object[] rmp = this.openings.toArray();
            for (Object v : rmp) {
                ((OpeningObject) v).loadOptionsAll();
            }
        }

        //************************************************
        //3. Load BOM for facets entity objects
        //************************************************
        if (!this.frames.isEmpty()) {
            Object[] rmp = this.frames.toArray();
            for (Object v : rmp) {
                ((SashLeaf) v).loadOptionsAll();
            }
        }
    }

}

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
import java.util.*;

import dto.*;
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
import Model.matrix.MatrixDictionaryDLO;
import Operations.CreateShapeMethods;
import Operations.FindBiggestDLO;
import Presentation.ItemFrame;

import Rules.*;

import org.openjanela.data.ApplicationBaseApp;
import org.openjanela.data.ApplicationBaseRulesApp;

public class DLO extends ShapeObject implements MatrixDictionaryDLO, Cloneable {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(DLO.class);

    public GlassSU myParentGlass;
    public ShapeObject myParent;

    public Line2D mySymbolLine;

    public double msx = 0;
    public double mex = 0;
    public double msy = 0;
    public double mey = 0;

    public boolean masterW = false;
    public boolean masterH = false;
    public boolean hasGrids = false;

    public int gridID = 0;
    public int gridType = 0;
    public int gridForm = 0;

    public int crossConnectors = 0;
    public int tConnectors = 0;
    public int lConnectors = 0;

    //clips = spacer connectors
    public int spacerConnectors = 0;
    public int hubConnector = 0;
    public int spokeConnectors = 0;

    public Collection gridPartsH = new ArrayList();
    public Collection gridPartsV = new ArrayList();
    public Collection gridPartsS = new ArrayList();
    public Collection spokes = new ArrayList();
    public Collection anchorsV = new ArrayList();
    public Collection anchorsH = new ArrayList();
    public Collection anchorsS = new ArrayList();
    public Collection gridMasksV = new ArrayList();
    public Collection gridMasksH = new ArrayList();
    public Collection gridMasksS = new ArrayList();

    public double gridThick = 0;
    public int continuity = 0;
    public int continuityOut = 0;

    public double idealGW = 0;
    public double idealGH = 0;

    public double maxGW = 0;
    public double maxGH = 0;
    public double minGW = 0;
    public double minGH = 0;

    public double gridRemovalZoneW = 0;
    public double gridRemovalZoneH = 0;

    public double liteW;
    public double liteH;

    public DLO myMasterH = null;
    public DLO myMasterW = null;

    public double perimeterV = 0;
    public double perimeterH = 0;

    public int noGridsV = 0;
    public int noGridsH = 0;
    public int noGridsS = 0;
    public int noGridsR = 0;

    public int lastNVGrid = 0;
    public int lastNHGrid = 0;
    public int lastNSGrid = 0;

    public int noIntersect4ways = 0;
    public int noIntersect3ways = 0;
    public int noIntersect2ways = 0;

    public int eval = 0;

    // Bom Grids Collection
    private List<DesignGrid> gridsBom = new ArrayList<DesignGrid>();

    /**
     * Create DLO Model Object
     */
    public DLO() {
        this.a_levelID = 22;
        this.a_assemblyLevel = 8;
       
    }

    /**
     * Create DLO
     *
     * @param myframe, ItemFrame
     */
    public DLO(ItemFrame myframe) {

        //Call main constructor
        this();

        //Setting ItemFrame
        this.myFrame2 = myframe;

        //DLO.this.myFrame2 = myFrame2;
        ((ShapeObject) this).myFrame2 = myFrame2;
        
        myMasterH = new DLO();
        myMasterW = new DLO();
        
    }

    /**
     * Create DLO Model Object
     *
     * @param myFrame,   ItemFrame
     * @param dloEntity, DLOEntityObject
     */
    public DLO(ItemFrame myFrame, DLOEntityObject dloEntity, OpeningObject opening) {

        //Call main constructor
        this();

        //Setting ItemFrame
        this.myFrame2 = myFrame;

        //Setting myParent Object
        this.myParent = opening.myParent;
        //Setting myParent Opening Object
        this.myParentO = opening;

        //Create DLO Model object
        createDLOModelObject(opening, dloEntity);
        
        myMasterH = new DLO();
        myMasterW = new DLO();
        
    }

    public DLO cloneDLO(DLO original) {

        DLO newDLO = (DLO) original.cloneShapeObject(original);

        newDLO.gridPartsH = original.cloneCollections(original.gridPartsH);
        newDLO.gridPartsV = original.cloneCollections(original.gridPartsV);
        newDLO.anchorsV = original.cloneCollections(original.anchorsV);
        newDLO.anchorsH = original.cloneCollections(original.anchorsH);

        newDLO.gridThick = original.gridThick;
        newDLO.continuity = original.continuity;
        newDLO.idealGW = original.idealGW;
        newDLO.idealGH = original.idealGH;
        newDLO.maxGW = original.maxGW;
        newDLO.maxGH = original.maxGH;
        newDLO.minGW = original.minGW;
        newDLO.minGH = original.minGH;
        newDLO.gridRemovalZoneW = original.gridRemovalZoneW;
        newDLO.gridRemovalZoneH = original.gridRemovalZoneH;
        newDLO.liteW = original.liteW;
        newDLO.liteH = original.liteH;

        newDLO.myMasterH = original.myMasterH;
        newDLO.myMasterW = original.myMasterW;
        newDLO.noGridsV = original.noGridsV;
        newDLO.noGridsH = original.noGridsH;


        return newDLO;
    }

    public DLO cloneDLOShape(final DLO original) {

        final DLO newOV = new DLO(myFrame2);
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

        // newOV.isNewFrame = original.isNewFrame;
        //
        // newOV.opening = original.opening;
        // newOV.myClickedOpening = original.myClickedOpening;

        // if(original.myParent!=null)
        // {
        // newOV.myParent =
        // original.myParent.cloneGlass(original.myParent);
        // }
        //
        // newOV.openingObjects = original.openingObjects;
        // newOV.initOpeningObjects = original.initOpeningObjects;
        //
        //
        // newOV.openings = cloneCollections(original.openings);
        newOV.myFacet = original.myFacet;

        newOV.bOpeningObjectIn = original.bOpeningObjectIn;
        newOV.bOpeningObject = original.bOpeningObject;
        newOV.bOpeningObjectOut = original.bOpeningObjectOut;
        newOV.newRowH = original.newRowH;

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
        newOV.a_levelID = 22;
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
        newOV.myMullionBot = null;
        newOV.myMullionTop = null;
        newOV.myMullionLeft = null;
        newOV.myMullionRight = null;

        return newOV;
    }

    /**
     * This method create DLO Model Object
     *
     * @param dlo, DLOEntityObject
     */
    private void createDLOModelObject(OpeningObject opening, DLOEntityObject dlo) {

        //Create ShapeAbstract Object Model
        ShapeObjectDTO.getShapeObjectModel(dlo, this, DLO.class);

        BigDecimal _starting_x = new BigDecimal(this.myFrame2.jobItem.startingX + "");
        BigDecimal _starting_y = new BigDecimal(this.myFrame2.jobItem.startingY + "");
        BigDecimal _original_scale = new BigDecimal(this.myFrame2.jobItem.originalScaleS + "");
        BigDecimal _new_scale = new BigDecimal(this.myFrame2.jobItem.newScaleS + "");

        //Setting additional values
        this.msx = dlo.getMsx().subtract(_starting_x).divide(_original_scale, 20, BigDecimal.ROUND_UP).
                multiply(_new_scale).add(_starting_x).doubleValue();
        this.mex = dlo.getMex().subtract(_starting_x).divide(_original_scale, 20, BigDecimal.ROUND_UP).
                multiply(_new_scale).add(_starting_x).doubleValue();
        this.msy = dlo.getMsy().subtract(_starting_y).divide(_original_scale, 20, BigDecimal.ROUND_UP).
                multiply(_new_scale).add(_starting_y).doubleValue();
        this.mey = dlo.getMey().subtract(_starting_y).divide(_original_scale, 20, BigDecimal.ROUND_UP).
                multiply(_new_scale).add(_starting_y).doubleValue();
        this.masterW = dlo.isMasterW();
        this.masterH = dlo.isMasterH();
        this.hasGrids = dlo.isHasGrids();
        this.gridID = dlo.getGridID();
        this.gridType = dlo.getGridType();
        this.gridForm = dlo.getGridForm();
        this.gridThick = dlo.getGridThick().doubleValue();
        this.continuity = dlo.getContinuity();
        this.idealGW = dlo.getIdealGW().doubleValue();
        this.idealGH = dlo.getIdealGH().doubleValue();
        this.minGW = dlo.getMinGW().doubleValue();
        this.minGH = dlo.getMinGH().doubleValue();
        this.maxGW = dlo.getMaxGW().doubleValue();
        this.maxGH = dlo.getMaxGH().doubleValue();
        this.gridRemovalZoneW = dlo.getGridRemovalZoneW().doubleValue();
        this.gridRemovalZoneH = dlo.getGridRemovalZoneH().doubleValue();
        this.liteW = dlo.getLiteW().divide(_original_scale, 20, BigDecimal.ROUND_UP).multiply(_new_scale).doubleValue();
        this.liteH = dlo.getLiteH().divide(_original_scale, 20, BigDecimal.ROUND_UP).multiply(_new_scale).doubleValue();
        this.perimeterV = dlo.getPerimeterV().doubleValue();
        this.perimeterH = dlo.getPerimeterH().doubleValue();
        this.noGridsV = dlo.getNoGridsW();
        this.noGridsH = dlo.getNoGridsH();
        this.noGridsR = dlo.getNoGridsR();
        this.noGridsS = dlo.getNoGridsS();
        this.lastNVGrid = dlo.getLastNVGrid();
        this.lastNHGrid = dlo.getLastNHGrid();
        this.lastNSGrid = dlo.getLastNSGrid();

        //********************************************************
        // Open profile grids collections objects
        //********************************************************

        //Evaluate if this DLO has grids
        if (this.gridID > 0) {
            if (this.remote) {
                myFrame2.gridsPanel.myGrid = ItemFrame.getApplicationRemoteBaseRules().
                        getGrids(dlo.getSupplierRemoteId(), this.gridID);
            }else {
                myFrame2.gridsPanel.myGrid = ItemFrame.getApplicationBaseRules().getGrids(this.gridID);
            }
        }

        if (dlo.getGridsSpokes() != null && !dlo.getGridsSpokes().isEmpty()) {
            this.gridPartsS = new ArrayList();
            for (ProfileGridSpokeObject grid : dlo.getGridsSpokes()) {
                Profiles profiles = new Profiles(this, grid);
                ConstructionMapDTO.copyConstructionMap(profiles, this);

                //Create spokes polygon
                FindBiggestDLO findBiggestDLO = new FindBiggestDLO(myFrame2);
                findBiggestDLO.doGridPolygon(profiles);

                this.gridPartsS.add(profiles);
            }
        }

        if (dlo.getGrids() != null && !dlo.getGrids().isEmpty()) {
            this.gridPartsH = new ArrayList();
            this.gridPartsV = new ArrayList();

            //Order Collection by sequence save
            List<ProfileGridObject> grids = new ArrayList<ProfileGridObject>(dlo.getGrids());
            Collections.sort(grids, ProfileAbstractObjectComparator._SEQUENCE_NO);

            for (ProfileGridObject grid : grids) {

                Profiles profiles = new Profiles(this, grid);
                if (grid.getOrientation() == 1) {
                    this.gridPartsV.add(profiles);
                } else if (grid.getOrientation() == 2) {
                    this.gridPartsH.add(profiles);
                }
            }
        }

        //********************************************************
        // Open profile grids mask collections objects
        //********************************************************
        if (dlo.getGridsMask() != null && !dlo.getGridsMask().isEmpty()) {
            this.gridMasksH = new ArrayList();
            this.gridMasksV = new ArrayList();

            for (ProfileGridMaskObject gridMask : dlo.getGridsMask()) {

                Profiles profiles = new Profiles(this, gridMask);
                ConstructionMapDTO.copyConstructionMap(profiles, this);

                if (gridMask.getOrientation() == 1) {
                    gridMasksV.add(profiles);
                } else {
                    gridMasksH.add(profiles);
                }
            }
        }

        //********************************************************
        // Open anchors collections objects
        //********************************************************
        if (dlo.getAnchorsGrids() != null && !dlo.getAnchorsGrids().isEmpty()) {
            this.anchorsH = new ArrayList();
            this.anchorsV = new ArrayList();
            for (AnchorsGrid anchorGrid : dlo.getAnchorsGrids()) {
                if (anchorGrid.getAnchorH() > 0 && anchorGrid.getAnchorV() <= 0) {
                    this.anchorsH.add(anchorGrid.getAnchorH());
                } else if (anchorGrid.getAnchorV() > 0 && anchorGrid.getAnchorH() <= 0) {
                    this.anchorsV.add(anchorGrid.getAnchorV());
                }
            }
        }

        //********************************************************
        //1. Creating background opening
        //********************************************************
        if (dlo.getBkgrdOpening() != null) {
            this.bOpeningObject = new BkgrdOpeningObject(this, myFrame2, dlo.getBkgrdOpening());

            //Constructing mullions
            this.doMullions(this.bOpeningObject);
        }

        //********************************************************
        // 2. Creating Openings
        //********************************************************
        if (dlo.getOpenings() != null && !dlo.getOpenings().isEmpty()) {
            this.openings = new ArrayList();
            for (OpeningEntityObject openingEntity : dlo.getOpenings()) {
                OpeningObject openingModel = new OpeningObject(this, this.myFrame2, openingEntity);
                this.openings.add(openingModel);
            }
        }

        //********************************************************
        //Do GeneralPath Opening
        //********************************************************
        CreateShapeMethods createShape = new CreateShapeMethods(opening, 2, myFrame2);
        this.gp = createShape.doGeneralPathOpeningII(this);
    }

    /**
     * This method create DLO Entity Object
     *
     * @return DLOEntityObject
     */
    public DLOEntityObject createDLOEntityObject() {

        //Creating DLO Entity Object
        DLOEntityObject dlo = (DLOEntityObject) ShapeObjectDTO.getShapeAbstractObject(this, DLOEntityObject.class);
        dlo.setMsx(new BigDecimal(this.msx + ""));
        dlo.setMex(new BigDecimal(this.mex + ""));
        dlo.setMsy(new BigDecimal(this.msy + ""));
        dlo.setMey(new BigDecimal(this.mey + ""));
        dlo.setMasterW(this.masterW);
        dlo.setMasterH(this.masterH);
        dlo.setHasGrids(this.hasGrids);
        dlo.setGridID(this.gridID);
        dlo.setGridType(this.gridType);
        dlo.setGridForm(this.gridForm);
        dlo.setGridThick(new BigDecimal(this.gridThick + ""));
        dlo.setContinuity(this.continuity);
        dlo.setIdealGW(new BigDecimal(this.idealGW + ""));
        dlo.setIdealGH(new BigDecimal(this.idealGH + ""));
        dlo.setMinGW(new BigDecimal(this.minGW + ""));
        dlo.setMinGH(new BigDecimal(this.minGH + ""));
        dlo.setMaxGW(new BigDecimal(this.maxGW + ""));
        dlo.setMaxGH(new BigDecimal(this.maxGH + ""));
        dlo.setGridRemovalZoneW(new BigDecimal(this.gridRemovalZoneW + ""));
        dlo.setGridRemovalZoneH(new BigDecimal(this.gridRemovalZoneH + ""));
        dlo.setLiteW(new BigDecimal(this.liteW + ""));
        dlo.setLiteH(new BigDecimal(this.liteH + ""));
        dlo.setPerimeterV(new BigDecimal(this.perimeterV + ""));
        dlo.setPerimeterH(new BigDecimal(this.perimeterH + ""));
        dlo.setNoGridsW(this.noGridsV);
        dlo.setNoGridsH(this.noGridsH);
        dlo.setNoGridsR(this.noGridsR);
        dlo.setNoGridsS(this.noGridsS);
        dlo.setLastNVGrid(this.lastNVGrid);
        dlo.setLastNHGrid(this.lastNHGrid);
        dlo.setLastNSGrid(this.lastNSGrid);

        //********************************************************
        // Saving profiles collections grids
        //********************************************************
        Set<ProfileGridSpokeObject> profilesGridsSpoke = new HashSet<ProfileGridSpokeObject>();
        Object[] gridsS = this.gridPartsS.toArray();
        for (Object grid : gridsS) {
            Profiles profiles = (Profiles) grid;
            profilesGridsSpoke.add(profiles.createProfileGridSpokeObject());
        }

        dlo.setGridsSpokes(profilesGridsSpoke);

        //Represents a sequence to save and open grids parts V and H
        int sequence = 1;

        Set<ProfileGridObject> profilesGrids = new HashSet<ProfileGridObject>();
        Object[] gridsH = this.gridPartsH.toArray();

        for (Object grid : gridsH) {
            Profiles profiles = (Profiles) grid;

            ProfileGridObject profileGridObject = profiles.createProfileGridObject(dlo);
            profileGridObject.setOrientation(2);
            profileGridObject.set_sequence(sequence++);
            profilesGrids.add(profileGridObject);
        }

        Object[] gridsV = this.gridPartsV.toArray();
        for (Object grid : gridsV) {
            Profiles profiles = (Profiles) grid;

            ProfileGridObject profileGridObject = profiles.createProfileGridObject(dlo);
            profileGridObject.setOrientation(1);
            profileGridObject.set_sequence(sequence++);
            profilesGrids.add(profileGridObject);
        }

        dlo.setGrids(profilesGrids);

        //********************************************************
        // Saving profiles collections grids mask
        //********************************************************
        Set<ProfileGridMaskObject> profilesGridsMask = new HashSet<ProfileGridMaskObject>();
        Object[] gridsMaskH = this.gridMasksH.toArray();
        for (Object grid : gridsMaskH) {
            Profiles profiles = (Profiles) grid;
            profilesGridsMask.add(profiles.createProfileGridMaskObject(dlo));
        }

        Object[] gridMaskV = this.gridMasksV.toArray();
        for (Object grid : gridMaskV) {
            Profiles profiles = (Profiles) grid;
            profilesGridsMask.add(profiles.createProfileGridMaskObject(dlo));
        }

        dlo.setGridsMask(profilesGridsMask);

        //********************************************************
        // Saving anchors collections
        //********************************************************
        Set<AnchorsGrid> anchorsGrids = new HashSet<AnchorsGrid>();
        Object[] anchorsH = this.anchorsH.toArray();
        for (Object object : anchorsH) {
            AnchorsGrid anchorGrid = new AnchorsGrid();
            anchorGrid.setAnchorV(0.0);
            anchorGrid.setAnchorH((Double) object);

            anchorsGrids.add(anchorGrid);
        }

        Object[] anchorsV = this.anchorsV.toArray();
        for (Object object : anchorsV) {
            AnchorsGrid anchorsGrid = new AnchorsGrid();
            anchorsGrid.setAnchorV((Double) object);
            anchorsGrid.setAnchorH(0.0);

            anchorsGrids.add(anchorsGrid);
        }

        dlo.setAnchorsGrids(anchorsGrids);

        //********************************************************
        // 1. Creating background opening
        //********************************************************
        dlo.setBkgrdOpening(this.bOpeningObject.createBkgrdEntityObject());

        //********************************************************
        // 2. Creating Openings
        //********************************************************
        if (!this.openings.isEmpty()) {
            Set<OpeningEntityObject> openings = new HashSet<OpeningEntityObject>();
            Object[] rmp = this.openings.toArray();
            for (Object v : rmp) {
                OpeningObject opening = (OpeningObject) v;
                openings.add(opening.createOpeningEntityObject(null, null, null, null));
            }
            dlo.setOpenings(openings);
        }

        return dlo;
    }

    /**
     * This method create a copy of javabeans with a clone of properties values
     *
     * @param dloEntity, DLOEntityObject
     * @return DLOEntityObject
     */
    public DLOEntityObject cloneObjectModel(DLOEntityObject dloEntity) {
        
        /* Clone DLO Entity Object */
        DLOEntityObject dlo = (DLOEntityObject) ShapeObjectDTO.cloneShapeAbstractObject(dloEntity, DLOEntityObject.class);

        dlo.setMsx(dloEntity.getMsx());
        dlo.setMex(dloEntity.getMex());
        dlo.setMsy(dloEntity.getMsy());
        dlo.setMey(dloEntity.getMey());
        dlo.setMasterW(dloEntity.isMasterW());
        dlo.setMasterH(dloEntity.isMasterH());
        dlo.setHasGrids(dloEntity.isHasGrids());
        dlo.setGridID(dloEntity.getGridID());
        dlo.setGridType(dloEntity.getGridType());
        dlo.setGridForm(dloEntity.getGridForm());
        dlo.setGridThick(dloEntity.getGridThick());
        dlo.setContinuity(dloEntity.getContinuity());
        dlo.setIdealGW(dloEntity.getIdealGW());
        dlo.setIdealGH(dloEntity.getIdealGH());
        dlo.setMinGW(dloEntity.getMinGW());
        dlo.setMinGH(dloEntity.getMinGH());
        dlo.setMaxGW(dloEntity.getMaxGW());
        dlo.setMaxGH(dloEntity.getMaxGH());
        dlo.setGridRemovalZoneW(dloEntity.getGridRemovalZoneW());
        dlo.setGridRemovalZoneH(dloEntity.getGridRemovalZoneH());
        dlo.setLiteW(dloEntity.getLiteW());
        dlo.setLiteH(dloEntity.getLiteH());
        dlo.setPerimeterV(dloEntity.getPerimeterV());
        dlo.setPerimeterH(dloEntity.getPerimeterH());
        dlo.setNoGridsW(dloEntity.getNoGridsW());
        dlo.setNoGridsH(dloEntity.getNoGridsH());
        dlo.setNoGridsR(dloEntity.getNoGridsR());
        dlo.setNoGridsS(dloEntity.getNoGridsS());
        dlo.setLastNVGrid(dloEntity.getLastNVGrid());
        dlo.setLastNHGrid(dloEntity.getLastNHGrid());
        dlo.setLastNSGrid(dloEntity.getLastNSGrid());
        dlo.setHasGrids(dloEntity.isHasGrids());

        dlo.setGrids(null);
        dlo.setGridsMask(null);
        dlo.setGridsSpokes(null);
        dlo.setAnchorsGrids(null);
        dlo.setBkgrdOpening(null);
        dlo.setOpenings(null);
        
        /* Clone Profile Grids Spokes */
        if (dloEntity.getGridsSpokes() != null && !dloEntity.getGridsSpokes().isEmpty()) {

            Set<ProfileGridSpokeObject> profileSpokes = new HashSet<ProfileGridSpokeObject>();
            for (ProfileGridSpokeObject profileSpoke : dloEntity.getGridsSpokes()) {
                profileSpokes.add((ProfileGridSpokeObject) ProfileDTO.cloneProfileAbstractObject(profileSpoke,
                        ProfileGridSpokeObject.class));
            }

            dlo.setGridsSpokes(profileSpokes);
        }

        /* Clone Profile Grids parts */
        if (dloEntity.getGrids() != null && !dloEntity.getGrids().isEmpty()) {
            Set<ProfileGridObject> profileGrids = new HashSet<ProfileGridObject>();

            for (ProfileGridObject profileGrid : dloEntity.getGrids()) {
                ProfileGridObject profileGridEntity = (ProfileGridObject) ProfileDTO.cloneProfileAbstractObject(profileGrid,
                        ProfileGridObject.class);
                profileGridEntity.setOrientation(profileGrid.getOrientation());

                profileGrids.add(profileGridEntity);
            }

            dlo.setGrids(profileGrids);
        }

        /* Clone Profile Grid Mask */
        if (dloEntity.getGridsMask() != null && !dloEntity.getGridsMask().isEmpty()) {

            Set<ProfileGridMaskObject> profileGridsMask = new HashSet<ProfileGridMaskObject>();
            for (ProfileGridMaskObject profileGridMask : dloEntity.getGridsMask()) {
                ProfileGridMaskObject profileGridMaskEntity = (ProfileGridMaskObject) ProfileDTO.
                        cloneProfileAbstractObject(profileGridMask, ProfileGridMaskObject.class);
                profileGridMaskEntity.setOrientation(profileGridMask.getOrientation());

                profileGridsMask.add(profileGridMaskEntity);
            }

            dlo.setGridsMask(profileGridsMask);
        }

        /* Clone anchors collection */
        if (dloEntity.getAnchorsGrids() != null && !dloEntity.getAnchorsGrids().isEmpty()) {

            Set<AnchorsGrid> anchorsGrids = new HashSet<AnchorsGrid>();
            for (AnchorsGrid anchorGrid : dloEntity.getAnchorsGrids()) {
                AnchorsGrid anchorsGridEntity = new AnchorsGrid();
                anchorsGridEntity.setAnchorH(anchorGrid.getAnchorH());
                anchorsGridEntity.setAnchorV(anchorGrid.getAnchorV());

                anchorsGrids.add(anchorsGridEntity);
            }

            dlo.setAnchorsGrids(anchorsGrids);
        }

        /* Clone background opening object model */
        if (dloEntity.getBkgrdOpening() != null) {
            BkgrdOpeningObject bkgrdOpeningObject = new BkgrdOpeningObject();
            BkgrdOpeningEntityObject bkgrdOpening = bkgrdOpeningObject.cloneObjectModel(dloEntity.getBkgrdOpening());
            dlo.setBkgrdOpening(bkgrdOpening);
        }

        //Clone Openings model object
        if (dloEntity.getOpenings() != null && !dloEntity.getOpenings().isEmpty()) {
            OpeningObject openingObject = new OpeningObject();

            Set<OpeningEntityObject> openings = new HashSet<OpeningEntityObject>();
            for (OpeningEntityObject opening : dloEntity.getOpenings()) {
                openings.add(openingObject.cloneObjectModel(opening));
            }

            dlo.setOpenings(openings);
        }

        return dlo;
    }

    //**********************************************************************************************
    // Prepared Grid Bom for DLO
    //**********************************************************************************************

    /**
     * Reset Grid Boms Collection
     *
     * @param openingObject
     * @throws Exception, Exception
     */
    public void resetGridsBom(OpeningObject openingObject) throws Exception {

        // Clear Collection of Grids
        this.gridsBom.clear();

        //Execute GridRules to generate Grid BOM
        ExecuteGridRules executeGridRules = new ExecuteGridRules(this.myFrame2);
        List<DesignGrid> gridsBom = executeGridRules.executeGridRules(openingObject, this);

        //Add grids Boms to collection
        this.gridsBom.addAll(gridsBom);

        //Adding Grids Boms to JobItem
        this.myFrame2.jobItem.gridsBOM.addAll(this.gridsBom);
    }

    @Override
    public DLO clone() {

        try {

            DLO newDLO = (DLO) super.clone();

            //Clone anchors Spokes
            Collection _anchorsS = new ArrayList();
            for (Object anchor : newDLO.anchorsS) {
                Double value = ((Double) anchor).doubleValue();
                _anchorsS.add(value);
            }
            newDLO.anchorsS = _anchorsS;

            //Clone anchors Vertical
            Collection _anchorsV = new ArrayList();
            for (Object anchor : newDLO.anchorsV) {
                Double value = ((Double) anchor).doubleValue();
                _anchorsV.add(value);
            }
            newDLO.anchorsV = _anchorsV;

            //Clone anchors Horizontal
            Collection _anchorsH = new ArrayList();
            for (Object anchor : newDLO.anchorsH) {
                Double value = ((Double) anchor).doubleValue();
                _anchorsH.add(value);
            }
            newDLO.anchorsH = _anchorsH;

            //Clone Grid Parts Spokes
            Collection _gridPartsS = new ArrayList();
            for (Object grid : newDLO.gridPartsS) {
                Profiles profile = ((Profiles) grid).clone();
                _gridPartsS.add(profile);
            }
            newDLO.gridPartsS = _gridPartsS;

            //Clone Grid Parts Horizontal
            Collection _gridPartsH = new ArrayList();
            for (Object grid : newDLO.gridPartsH) {
                Profiles profile = ((Profiles) grid).clone();
                _gridPartsH.add(profile);
            }
            newDLO.gridPartsH = _gridPartsH;

            //Clone Grid parts Vertical
            Collection _gridPartsV = new ArrayList();
            for (Object grid : newDLO.gridPartsV) {
                Profiles profile = ((Profiles) grid).clone();
                _gridPartsV.add(profile);
            }
            newDLO.gridPartsV = _gridPartsV;

            //Clone Grid Mask Spokes
            Collection _gridMaskS = new ArrayList();
            for (Object gridMask : newDLO.gridMasksS) {
                Profiles profile = ((Profiles) gridMask).clone();
                _gridMaskS.add(profile);
            }
            newDLO.gridMasksS = _gridMaskS;

            //Clone Grid Mask Horizontal
            Collection _gridMaskH = new ArrayList();
            for (Object gridMask : newDLO.gridMasksH) {
                Profiles profile = ((Profiles) gridMask).clone();
                _gridMaskH.add(profile);
            }
            newDLO.gridMasksH = _gridMaskH;

            //Clone Grid Mask Vertical
            Collection _gridMaskV = new ArrayList();
            for (Object gridMask : newDLO.gridMasksV) {
                Profiles profile = ((Profiles) gridMask).clone();
                _gridMaskV.add(profile);
            }
            newDLO.gridMasksV = _gridMaskV;

            //Clone BkgrdOpening object model
            newDLO.bOpeningObject = this.bOpeningObject.clone();

            //Clone Opening collection
            Collection _openings = new ArrayList();
            for (Object opening : newDLO.openings) {
                _openings.add(((OpeningObject) opening).clone());
            }
            newDLO.openings = _openings;

            return newDLO;

        } catch (DTOTransformationError e) {
            logger.error(e.getMessage(), e);
        } catch (CloneNotSupportedException e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }

    /**
     * Clear Bill Of Material for DLO
     */
    public void clearBomForDLO() {

        Object[] boms = this.myFrame2.jobItem.bom.toArray();

        this.myFrame2.jobItem.bom.clear();

        for (Object b : boms) {
            if (!((BillOfMat) b).isForDLO(this)) {
                this.myFrame2.jobItem.bom.add((BillOfMat) b);
            }
        }

    }

    public DLO cloneDLOFromOpening(DLO mySashType2, OpeningObject original) {

        mySashType2.myFrame2 = myFrame2;

        mySashType2.a_1Level = myParent.a_assemblyLevel;
        mySashType2.a_1Sequence = myParent.a_sequenceID;
        mySashType2.a_2Level = myParent.a_1Level;
        mySashType2.a_2Sequence = myParent.a_1Sequence;
        mySashType2.a_3Level = myParent.a_2Level;
        mySashType2.a_3Sequence = myParent.a_2Sequence;
        mySashType2.a_4Level = myParent.a_3Level;
        mySashType2.a_4Sequence = myParent.a_3Sequence;

        mySashType2.a_5Level = myParent.a_4Level;
        mySashType2.a_5Sequence = myParent.a_4Sequence;
        mySashType2.a_6Level = myParent.a_5Level;
        mySashType2.a_6Sequence = myParent.a_5Sequence;
        mySashType2.a_7Level = myParent.a_6Level;
        mySashType2.a_7Sequence = myParent.a_6Sequence;
        mySashType2.a_8Level = myParent.a_7Level;
        mySashType2.a_8Sequence = myParent.a_7Sequence;
        mySashType2.a_9Level = myParent.a_8Level;
        mySashType2.a_9Sequence = myParent.a_8Sequence;
        mySashType2.a_10Level = myParent.a_9Level;
        mySashType2.a_10Sequence = myParent.a_9Sequence;

        mySashType2.a_11Level = myParent.a_10Level;
        mySashType2.a_11Sequence = myParent.a_10Sequence;
        mySashType2.a_12Level = myParent.a_11Level;
        mySashType2.a_12Sequence = myParent.a_11Sequence;
        mySashType2.a_13Level = myParent.a_12Level;
        mySashType2.a_13Sequence = myParent.a_12Sequence;
        mySashType2.a_14Level = myParent.a_13Level;
        mySashType2.a_15Sequence = myParent.a_13Sequence;
        mySashType2.a_15Level = myParent.a_14Level;
        mySashType2.a_15Sequence = myParent.a_14Sequence;
        mySashType2.a_16Level = myParent.a_15Level;
        mySashType2.a_16Sequence = myParent.a_15Sequence;
        mySashType2.a_17Level = myParent.a_16Level;
        mySashType2.a_17Sequence = myParent.a_16Sequence;
        mySashType2.a_18Level = myParent.a_17Level;
        mySashType2.a_18Sequence = myParent.a_17Sequence;
        mySashType2.a_19Level = myParent.a_18Level;
        mySashType2.a_19Sequence = myParent.a_18Sequence;
        mySashType2.a_20Level = myParent.a_19Level;
        mySashType2.a_20Sequence = myParent.a_19Sequence;
        mySashType2.a_21Level = myParent.a_20Level;
        mySashType2.a_21Sequence = myParent.a_20Sequence;
        mySashType2.a_22Level = myParent.a_21Level;
        mySashType2.a_22Sequence = myParent.a_21Sequence;


        mySashType2.shapeID = original.shapeID;

        mySashType2.highestY = original.highestY;
        mySashType2.lowestY = original.lowestY;
        mySashType2.startingX = original.startingX;
        mySashType2.startingY = original.startingY;
        mySashType2.startCol = original.startCol;
        mySashType2.endCol = original.endCol;
        mySashType2.startRow = original.startRow;
        mySashType2.endRow = original.endRow;
        mySashType2.rID = original.rID;
        mySashType2.a_levelID = original.a_levelID;
        mySashType2.widthPix = original.widthPix;
        mySashType2.heightPix = original.heightPix;

        mySashType2.widthMN = original.widthMN;
        mySashType2.heightMN = original.heightMN;
        mySashType2.widthIN = original.widthIN;
        mySashType2.heightIN = original.heightIN;

        mySashType2.shapeID = original.shapeID;
        mySashType2.startingX = original.startingX;
        mySashType2.startingY = original.startingY;

        mySashType2.radius1 = original.radius1;
        mySashType2.radius2 = original.radius2;

        mySashType2.bkgrdStartX = original.bkgrdStartX;
        mySashType2.bkgrdStartY = original.bkgrdStartY;

        mySashType2.noSides = original.noSides;
        mySashType2.noSidesTop = original.noSidesTop;
        mySashType2.noSidesBot = original.noSidesBot;
        mySashType2.noSidesLeft = original.noSidesLeft;
        mySashType2.noSidesRight = original.noSidesRight;

        mySashType2.centerPointX = original.centerPointX;
        mySashType2.centerPointX2 = original.centerPointX2;
        mySashType2.centerPointY = original.centerPointY;
        mySashType2.centerPointY2 = original.centerPointY2;

        mySashType2.bX2 = original.bX2;
        mySashType2.bY2 = original.bY2;
        mySashType2.bX3 = original.bX3;
        mySashType2.bY3 = original.bY3;
        mySashType2.bX4 = original.bX4;
        mySashType2.bY4 = original.bY4;
        mySashType2.startingCX = original.startingCX;
        mySashType2.startingCY = original.startingCY;

        mySashType2.bCX2 = original.bCX2;
        mySashType2.bCY2 = original.bCY2;
        mySashType2.bCX3 = original.bCX3;
        mySashType2.bCY3 = original.bCY3;
        mySashType2.bCX4 = original.bCX4;
        mySashType2.bCY4 = original.bCY4;

        mySashType2.dimTM = original.dimTM;
        mySashType2.dimBM = original.dimBM;
        mySashType2.dimLM = original.dimLM;
        mySashType2.dimRM = original.dimRM;
        mySashType2.dimTA = original.dimTA;
        mySashType2.dimBA = original.dimBA;
        mySashType2.dimLA = original.dimLA;
        mySashType2.dimRA = original.dimRA;

        mySashType2.topIn = original.topIn;
        mySashType2.botIn = original.botIn;
        mySashType2.leftIn = original.leftIn;
        mySashType2.rightIn = original.rightIn;

        mySashType2.lean = 0;
        mySashType2.lean2 = 0;
        mySashType2.lean3 = 0;
        mySashType2.lean4 = 0;

        mySashType2.parentH = original.parentH;
        mySashType2.parentW = original.parentW;
        mySashType2.parentStartY = original.parentStartY;
        mySashType2.parentStartX = original.parentStartX;
        mySashType2.parentRadius1 = original.parentRadius1;// *
        // 2;

        mySashType2.parentCX = original.parentCX;
        mySashType2.parentCY = original.parentCY;
        mySashType2.parentCX2 = original.parentCX2;
        mySashType2.parentCY2 = original.parentCY2;
        mySashType2.parentShape = original.parentShape;

        mySashType2.openingClass = original.openingClass;
        mySashType2.userDefinedOpeningID = original.userDefinedOpeningID;

        mySashType2.px1 = original.px1;
        mySashType2.py1 = original.py1;
        mySashType2.px2 = original.px2;
        mySashType2.py2 = original.py2;
        mySashType2.px3 = original.px3;
        mySashType2.py3 = original.py3;
        mySashType2.px4 = original.px4;
        mySashType2.py4 = original.py4;
        mySashType2.px5 = original.px5;
        mySashType2.py5 = original.py5;
        mySashType2.px6 = original.px6;
        mySashType2.py6 = original.py6;
        mySashType2.px7 = original.px7;
        mySashType2.py7 = original.py7;
        mySashType2.px8 = original.px8;
        mySashType2.py8 = original.py8;
        final CreateShapeMethods createShape = new CreateShapeMethods(mySashType2.myParentO, 2, myFrame2);

        mySashType2.top1 = (Top1Object) mySashType2.top1.cloneProfile(original.top1Part);
        mySashType2.top2 = (Top2Object) mySashType2.top2.cloneProfile(original.top2Part);
        mySashType2.top3 = (Top3Object) mySashType2.top3.cloneProfile(original.top3Part);

        mySashType2.bot1 = (Bot1Object) mySashType2.bot1.cloneProfile(original.bot1Part);
        mySashType2.bot2 = (Bot2Object) mySashType2.bot2.cloneProfile(original.bot2Part);
        mySashType2.bot3 = (Bot3Object) mySashType2.bot3.cloneProfile(original.bot3Part);

        mySashType2.left = (LeftObject) mySashType2.left.cloneProfile(original.leftPart);
        mySashType2.right = (RightObject) mySashType2.right.cloneProfile(original.rightPart);

        mySashType2.top1Part = (Profiles) mySashType2.top1Part.cloneProfile(original.top1Part);
        mySashType2.top2Part = (Profiles) mySashType2.top2Part.cloneProfile(original.top2Part);
        mySashType2.top3Part = (Profiles) mySashType2.top3Part.cloneProfile(original.top3Part);
        mySashType2.bot1Part = (Profiles) mySashType2.bot1Part.cloneProfile(original.bot1Part);
        mySashType2.bot2Part = (Profiles) mySashType2.bot2Part.cloneProfile(original.bot2Part);
        mySashType2.bot3Part = (Profiles) mySashType2.bot3Part.cloneProfile(original.bot3Part);
        mySashType2.leftPart = (Profiles) mySashType2.leftPart.cloneProfile(original.leftPart);
        mySashType2.rightPart = (Profiles) mySashType2.rightPart.cloneProfile(original.rightPart);

        return mySashType2;
    }

    //**********************************************************************************************
    //Implementing methods for Matrix calculation
    //**********************************************************************************************

    @Override
    public BigDecimal returnGridType() {
        return new BigDecimal(this.gridType);
    }

    @Override
    public BigDecimal returnGridID() {
        return new BigDecimal(this.gridID);
    }

    @Override
    public BigDecimal returnNumberGridsW() {
        return new BigDecimal(this.noGridsV);
    }

    @Override
    public BigDecimal returnNumberGridsH() {

        return new BigDecimal(this.noGridsH);
    }

    @Override
    public BigDecimal returnNumberSpokes() {

        return new BigDecimal(this.noGridsS);
    }

    @Override
    public BigDecimal returnNumberRadii() {

        return new BigDecimal(this.noGridsR);
    }

    @Override
    public boolean gridIDTest(RuleTest test, List myRuleTestValues) {

        boolean pass = false;

        if (test.isrange) {
            pass = isWithinRange(test.value1, test.value2, this.gridID);

        } else {
            pass = isWithinValues(gridID, 0, myRuleTestValues.toArray());

        }

        if (test.isnot) {
            pass = !pass;
        }

        return pass;
    }

    @Override
    public boolean gridTypeTest(RuleTest test, List myRuleTestValues) {

        boolean pass = false;

        if (test.isrange) {
            pass = isWithinRange(test.value1, test.value2, this.gridType);

        } else {
            pass = isWithinValues(gridType, 0, myRuleTestValues.toArray());

        }

        if (test.isnot) {
            pass = !pass;
        }

        return pass;
    }

    @Override
    public boolean noGridHTest(RuleTest test, List myRuleTestValues) {

        boolean pass = false;

        if (test.isrange) {
            pass = isWithinRange(test.value1, test.value2, this.noGridsH);

        } else {
            pass = isWithinValues(noGridsH, 0, myRuleTestValues.toArray());

        }

        if (test.isnot) {
            pass = !pass;
        }

        return pass;
    }

    @Override
    public boolean noGridVTest(RuleTest test, List myRuleTestValues) {

        boolean pass = false;

        if (test.isrange) {
            pass = isWithinRange(test.value1, test.value2, this.noGridsV);

        } else {
            pass = isWithinValues(noGridsV, 0, myRuleTestValues.toArray());

        }

        if (test.isnot) {
            pass = !pass;
        }

        return pass;
    }

    @Override
    public boolean noGridRTest(RuleTest test, List myRuleTestValues) {

        boolean pass = false;

        if (test.isrange) {
            pass = isWithinRange(test.value1, test.value2, this.noGridsR);

        } else {
            pass = isWithinValues(noGridsR, 0, myRuleTestValues.toArray());

        }

        if (test.isnot) {
            pass = !pass;
        }

        return pass;
    }

    @Override
    public boolean noGridSTest(RuleTest test, List myRuleTestValues) {

        boolean pass = false;

        if (test.isrange) {
            pass = isWithinRange(test.value1, test.value2, this.noGridsS);

        } else {
            pass = isWithinValues(noGridsS, 0, myRuleTestValues.toArray());

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
    }

    @Override
    public void loadBOMParts() {

        //Load BOM Parts
        if (this.bom != null && this.bom.size() > 0) {
            this.myFrame2.jobItem.bom.addAll(this.bom);
        }

        //********************************************************
        // Load BOM Parts from profiles collections grids
        //********************************************************
        Object[] gridsS = this.gridPartsS.toArray();
        for (Object grid : gridsS) {
            ((Profiles) grid).loadBOMParts();
        }

        Object[] gridsH = this.gridPartsH.toArray();
        for (Object grid : gridsH) {
            if (((Profiles) grid).partForm > 1) {
                ((Profiles) grid).loadBOMParts();
            }
        }

        //********************************************************
        // Load BOM Parts from profiles collections grids mask
        //********************************************************
//        Object[] gridsMaskH = this.gridMasksH.toArray();
//        for (Object grid : gridsMaskH) {
//           ((Profiles) grid).loadBOMParts();
//        }
//
//        Object[] gridMaskV = this.gridMasksV.toArray();
//        for (Object grid : gridMaskV) {
//            ((Profiles) grid).loadBOMParts();
//        }

        //********************************************************
        // Load BOM Parts from background opening
        //********************************************************
        if (bOpeningObject != null) {
            this.bOpeningObject.loadBOMParts();
        }

        //********************************************************
        // Load BOM Parts from Openings
        //********************************************************
        if (!this.openings.isEmpty()) {
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
        // Load BOM Parts from profiles collections grids
        //********************************************************
        Object[] gridsS = this.gridPartsS.toArray();
        for (Object grid : gridsS) {
            ((Profiles) grid).loadOptionsAll();
        }

        Object[] gridsH = this.gridPartsH.toArray();
        for (Object grid : gridsH) {
            ((Profiles) grid).loadOptionsAll();
        }

        Object[] gridsV = this.gridPartsV.toArray();
        for (Object grid : gridsV) {
            ((Profiles) grid).loadOptionsAll();
        }

        //********************************************************
        // Load BOM Parts from profiles collections grids mask
        //********************************************************
        Object[] gridsMaskH = this.gridMasksH.toArray();
        for (Object grid : gridsMaskH) {
            ((Profiles) grid).loadOptionsAll();
        }

        Object[] gridMaskV = this.gridMasksV.toArray();
        for (Object grid : gridMaskV) {
            ((Profiles) grid).loadOptionsAll();
        }

        //********************************************************
        // Load BOM Parts from background opening
        //********************************************************
        if (bOpeningObject != null) {
            this.bOpeningObject.loadOptionsAll();
        }

        //********************************************************
        // Load BOM Parts from Openings
        //********************************************************
        if (!this.openings.isEmpty()) {
            Object[] rmp = this.openings.toArray();
            for (Object v : rmp) {
                ((OpeningObject) v).loadOptionsAll();
            }
        }
    }

}

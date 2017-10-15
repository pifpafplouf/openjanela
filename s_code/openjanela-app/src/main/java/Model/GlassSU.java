/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 */

package Model;

import Model.ProfileParts.*;
import Model.matrix.MatrixDictionaryGlass;
import Operations.CreateShapeMethods;
import Presentation.ItemFrame;
import dto.DesignGlassDTO;
import dto.ShapeObjectDTO;
import openjanela.app.configuration.controller.calculation.GlassSUController;
import openjanela.model.entities.design.DesignGlassEntityObject;
import openjanela.model.entities.design.GlassSUEntityObject;
import openjanela.model.entities.design.OpeningEntityObject;
import openjanela.model.entities.partner.RuleTest;
import openjanela.model.entities.partner.Rules;
import openjanela.model.entities.partner.SUType;

import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.*;

public class GlassSU extends ShapeObject implements MatrixDictionaryGlass, Cloneable {

    // Apache log4j
    private static final Logger logger = Logger.getLogger(GlassSU.class);

    // *****************************************************************
    // Execution properties
    // *****************************************************************
    public boolean is_selected = false;

    // *****************************************************************
    // SU Type information properties
    // *****************************************************************
    public int suID;

    public String stockCode = "@@";

    public String description = "@@";

    public String abbrev = "@@";

    public double minArea = 0;

    public double minAreaImp = 0;

    public double maxArea = 0;

    public double maxAreaImp = 0;

    public int minWidth = 0;

    public int minWidthImp = 0;

    public int minHeight = 0;

    public int minHeightImp = 0;

    public int maxWidth = 0;

    public int maxWidthImp = 0;

    public int maxHeight = 0;

    public int maxHeightImp = 0;

    public double whRatio = 0;

    public int pricingUOMId = -1;

    public boolean priceActualSize = false;

    public BigDecimal cost = new BigDecimal("0.00");

    public boolean costActualSize = false;

    public int priceMatrixId = -1;

    public BigDecimal price = new BigDecimal("0.00");

    public double minPricingArea = 0;

    public double minPricingAreaImp = 0;

    public BigDecimal minPrice = new BigDecimal("0.00");

    public int costGroupId = -1;

    public int priceGroupId = -1;

    public Date startDate = new Date();

    public Date endDate = new Date();

    public int partnerGroupId = -1;

    public int nextItem = -1;

    public boolean display = false;

    public double waste = 0;

    public boolean madeIn = false;

    public int supplierId = -1;

    public int leadTime = 0;

    public double minCostArea = 0;

    public double minCostAreaImp = 0;

    public int productionLine = -1;

    public int sortSeq = -1;

    public int glazingType = 1;// 0 = unglazed 1 = glass 2 = SU

    public boolean isCustom = false;

    public int numOfLeaves = 0;

    public double thickness = 0;

    public double thicknessImp = 0;

    public int leaf1 = 0;

    public int leaf2 = 0;

    public int leaf3 = 0;

    public int leaf4 = 0;

    public int spacer1 = 0;

    public int spacer2 = 0;

    public int spacer3 = 0;

    public double glassToSpacer = 0;

    public double glassToSpacerImp = 0;

    public int gas1 = 0;

    public int gas2 = 0;

    public int gas3 = 0;

    public int film1 = 0;

    public int film2 = 0;

    public int film3 = 0;

    public int film4 = 0;

    public int process1 = 0;

    public int process2 = 0;

    public int process3 = 0;

    public int process4 = 0;

    public int cavityProcess1 = 0;

    public int cavityProcess2 = 0;

    public int cavityProcess3 = 0;

    public int cavity1Process2 = 0;

    public int cavity2Process2 = 0;

    public int cavity3Process2 = 0;

    public int cavity1Process3 = 0;

    public int cavity2Process3 = 0;

    public int cavity3Process3 = 0;

    public int externalProcess1 = 0;

    public int externalProcess2 = 0;

    public int externalProcess3 = 0;

    public int externalProcess4 = 0;

    public int external1Process2 = 0;

    public int external2Process2 = 0;

    public int external3Process2 = 0;

    public int external4Process2 = 0;

    public int external1Process3 = 0;

    public int external2Process3 = 0;

    public int external3Process3 = 0;

    public int external4Process3 = 0;

    public int glass1 = 0;

    public int glass2 = 0;

    public int glass3 = 0;

    public int glass4 = 0;

    public int glass1Process2 = 0;

    public int glass2Process2 = 0;

    public int glass3Process2 = 0;

    public int glass4Process2 = 0;

    public int glass1Process3 = 0;

    public int glass2Process3 = 0;

    public int glass3Process3 = 0;

    public int glass4Process3 = 0;

    public int sealantPartId = -1;

    public int familyId = -1;

    public int insert1Id = -1;

    public int insert2Id = -1;

    public int insert3Id = -1;

    public int leafIn = 0;

    public int leafOut = 0;

    public double spacerThick1 = 0;

    public double spacerThick2 = 0;

    public double spacerThick3 = 0;

    public double airSpace1 = 0;

    public double airSpace2 = 0;

    public double airSpace3 = 0;

    /**
     * TODO
     * <p/>
     * Add following int Glass Object for Save
     */
    public double spacerThick1i = 0;

    public double spacerThick2i = 0;

    public double spacerThick3i = 0;

    public double airSpace1i = 0;

    public double airSpace2i = 0;

    public double airSpace3i = 0;

    public int assemblyID = 0;

    public boolean inHouse = false;

    public int measure = 0;

    public int gridID = 0;

    public int gridType = 0;

    public int noGridsV = 0;

    public int noGridsH = 0;

    public int noGridsS = 0;

    public int noGridsR = 0;

    public int partFamily = 0;

    // Glass SU Color
    public int r_rgb = 0;
    public int g_rgb = 0;
    public int b_rgb = 0;
    public int a_rgb = 0;

    // Bom Glass Collection
    private List<DesignGlass> glassBom = new ArrayList<DesignGlass>();

    // ******************************************************************
    // Glass SU Controller
    // ******************************************************************
    private GlassSUController glassSUController;

    /**
     * Creating GlassSU
     */
    public GlassSU() {

        a_assemblyLevel = 6;
        a_levelID = 21;

        // Initializing controller
        glassSUController = new GlassSUController(this);
    }

    /**
     * Create GlassSU
     *
     * @param parent  , OpeningObject
     * @param myframe , ItemFrame
     */
    public GlassSU(OpeningObject parent, ItemFrame myframe) {

        // Call main constructor
        this();

        // this.myParent = parent;
        myParentO = parent;
        myFrame2 = myframe;
    }

    /**
     * Create GlassSU Object model
     *
     * @param parent        , OpeningObject
     * @param myFrame       , ItemFrame
     * @param glassSUEntity , GlassSUEntityObject
     */
    public GlassSU(OpeningObject parent, ItemFrame myFrame, GlassSUEntityObject glassSUEntity) {

        // Call main constructor
        this();

        // Setting parent object
        myParentO = parent;
        // Setting ItemFrame
        myFrame2 = myFrame;

        // Create GlassSU Model Object
        createGlassSUModelObject(parent, glassSUEntity);
    }

    /**
     * Clone glass
     *
     * @param original , GlassSU
     * @return GlassSU
     */
    public GlassSU cloneGlass(GlassSU original) {

        GlassSU newGlass = cloneGlassShape(original);

        // Extend Specific Attributes Here

        newGlass.leafIn = original.leafIn; // Inside
        newGlass.leaf2 = original.leaf2;
        newGlass.leaf3 = original.leaf3;
        newGlass.leafOut = original.leafOut;
        newGlass.spacer1 = original.spacer1;
        newGlass.spacer2 = original.spacer2;
        newGlass.spacer3 = original.spacer3;
        newGlass.spacerThick1 = original.spacerThick1;
        newGlass.spacerThick2 = original.spacerThick2;
        newGlass.spacerThick3 = original.spacerThick3;
        newGlass.glassToSpacer = original.glassToSpacer;
        newGlass.airSpace1 = original.airSpace1;
        newGlass.airSpace2 = original.airSpace2;
        newGlass.airSpace3 = original.airSpace3;
        newGlass.gas1 = original.gas1;
        newGlass.gas2 = original.gas2;
        newGlass.gas3 = original.gas3;
        newGlass.film1 = original.film1;
        newGlass.film4 = original.film4;
        newGlass.process1 = original.process1;
        newGlass.process2 = original.process2;
        newGlass.process3 = original.process3;
        newGlass.process4 = original.process4;
        newGlass.cavityProcess1 = original.cavityProcess1;
        newGlass.cavityProcess2 = original.cavityProcess2;
        newGlass.cavityProcess3 = original.cavityProcess3;
        newGlass.externalProcess1 = original.externalProcess1;
        newGlass.externalProcess2 = original.externalProcess2;
        newGlass.externalProcess3 = original.externalProcess3;
        newGlass.externalProcess4 = original.externalProcess4;

        newGlass.gridID = original.gridID;
        newGlass.gridType = original.gridType;
        newGlass.noGridsV = original.noGridsV;
        newGlass.noGridsH = original.noGridsH;
        newGlass.noGridsS = original.noGridsS;
        newGlass.noGridsR = original.noGridsR;
        newGlass.partFamily = original.partFamily;

        return newGlass;
    }

    /**
     * Clone Glass Shape
     *
     * @param original , GlassSU
     * @return GlassSU
     */
    public GlassSU cloneGlassShape(GlassSU original) {

        GlassSU newOV = new GlassSU(original.myParentO, myFrame2);

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

        newOV.stockCode = original.stockCode;
        newOV.description = original.description;
        newOV.abbrev = original.abbrev;
        newOV.minArea = original.minArea;
        newOV.minAreaImp = original.minAreaImp;
        newOV.maxArea = original.maxArea;
        newOV.maxAreaImp = original.maxAreaImp;
        newOV.minWidth = original.minWidth;
        newOV.minWidthImp = original.minWidthImp;
        newOV.minHeight = original.minHeight;
        newOV.minHeightImp = original.minHeightImp;
        newOV.whRatio = original.whRatio;
        newOV.pricingUOMId = original.pricingUOMId;
        newOV.priceActualSize = original.priceActualSize;
        newOV.cost = original.cost;
        newOV.costActualSize = original.costActualSize;
        newOV.priceMatrixId = original.priceMatrixId;
        newOV.price = original.price;
        newOV.minPricingArea = original.minPricingArea;
        newOV.minPricingAreaImp = original.minPricingAreaImp;
        newOV.minPrice = original.minPrice;
        newOV.costGroupId = original.costGroupId;
        newOV.priceGroupId = original.priceGroupId;
        newOV.startDate = original.startDate;
        newOV.endDate = original.endDate;
        newOV.partnerGroupId = original.partnerGroupId;
        newOV.nextItem = original.nextItem;
        newOV.display = original.display;
        newOV.waste = original.waste;
        newOV.madeIn = original.madeIn;
        newOV.supplierId = original.supplierId;
        newOV.leadTime = original.leadTime;
        newOV.minCostArea = original.minCostArea;
        newOV.minCostAreaImp = original.minCostAreaImp;
        newOV.productionLine = original.productionLine;
        newOV.sortSeq = original.sortSeq;
        newOV.glazingType = original.glazingType;
        newOV.isCustom = original.isCustom;
        newOV.numOfLeaves = original.numOfLeaves;
        newOV.thickness = original.thickness;
        newOV.thicknessImp = original.thicknessImp;
        newOV.leafNo = original.leafNo;
        newOV.leftIn = original.leftIn;
        newOV.leafOut = original.leafOut;
        newOV.leaf1 = original.leaf1;
        newOV.leaf2 = original.leaf2;
        newOV.leaf3 = original.leaf3;
        newOV.leaf4 = original.leaf4;
        newOV.spacer1 = original.spacer1;
        newOV.spacer2 = original.spacer2;
        newOV.spacer3 = original.spacer3;
        newOV.spacerThick1 = original.spacerThick1;
        newOV.spacerThick2 = original.spacerThick2;
        newOV.spacerThick3 = original.spacerThick3;
        newOV.glassToSpacer = original.glassToSpacer;
        newOV.glassToSpacerImp = original.glassToSpacerImp;
        newOV.airSpace1 = original.airSpace1;
        newOV.airSpace2 = original.airSpace2;
        newOV.airSpace3 = original.airSpace3;
        newOV.gas1 = original.gas1;
        newOV.gas2 = original.gas2;
        newOV.gas3 = original.gas3;
        newOV.film1 = original.film1;
        newOV.film2 = original.film2;
        newOV.film3 = original.film3;
        newOV.film4 = original.film4;
        newOV.process1 = original.process1;
        newOV.process2 = original.process2;
        newOV.process3 = original.process3;
        newOV.process4 = original.process4;
        newOV.cavityProcess1 = original.cavityProcess1;
        newOV.cavityProcess2 = original.cavityProcess2;
        newOV.cavityProcess3 = original.cavityProcess3;
        newOV.cavity1Process2 = original.cavity1Process2;
        newOV.cavity2Process2 = original.cavity2Process2;
        newOV.cavity3Process2 = original.cavity3Process2;
        newOV.cavity1Process3 = original.cavity1Process3;
        newOV.cavity2Process3 = original.cavity2Process3;
        newOV.cavity3Process3 = original.cavity3Process3;
        newOV.externalProcess1 = original.externalProcess1;
        newOV.externalProcess2 = original.externalProcess2;
        newOV.externalProcess3 = original.externalProcess3;
        newOV.externalProcess4 = original.externalProcess4;
        newOV.external1Process2 = original.external1Process2;
        newOV.external2Process2 = original.external2Process2;
        newOV.external3Process2 = original.external3Process2;
        newOV.external4Process2 = original.external4Process2;
        newOV.external1Process3 = original.external1Process3;
        newOV.external2Process3 = original.external2Process3;
        newOV.external3Process3 = original.external3Process3;
        newOV.external4Process3 = original.external4Process3;
        newOV.glass1 = original.glass1;
        newOV.glass2 = original.glass2;
        newOV.glass3 = original.glass3;
        newOV.glass4 = original.glass4;
        newOV.glass1Process2 = original.glass1Process2;
        newOV.glass2Process2 = original.glass2Process2;
        newOV.glass3Process2 = original.glass3Process2;
        newOV.glass4Process2 = original.glass4Process2;
        newOV.glass1Process3 = original.glass1Process3;
        newOV.glass2Process3 = original.glass2Process3;
        newOV.glass3Process3 = original.glass3Process3;
        newOV.glass4Process3 = original.glass4Process3;
        newOV.familyId = original.familyId;
        newOV.insert1Id = original.insert1Id;
        newOV.insert2Id = original.insert2Id;
        newOV.insert3Id = original.insert3Id;

        newOV.highestX = original.highestX;
        newOV.lowestX = original.lowestX;
        newOV.highestY = original.highestY;
        newOV.lowestY = original.lowestY;
        newOV.highestYC = original.highestYC;
        newOV.lowestYC = original.lowestYC;

        newOV.removedParts = this.cloneCollections(original.removedParts);
        newOV.isStdW = original.isStdW;
        newOV.isStdH = original.isStdH;
        newOV.stdWM = original.stdWM;
        newOV.stdWI = original.stdWI;
        newOV.stdHM = original.stdHM;
        newOV.stdHI = original.stdHI;
        newOV.noPartsTop1 = original.noPartsTop1;
        newOV.noPartsTop2 = original.noPartsTop2;
        newOV.noPartsTop3 = original.noPartsTop3;
        newOV.noPartsBot1 = original.noPartsBot1;
        newOV.noPartsBot2 = original.noPartsBot2;
        newOV.noPartsBot3 = original.noPartsBot3;
        newOV.noPartsLeft = original.noPartsLeft;
        newOV.noPartsRight = original.noPartsRight;

        newOV.isNewFrame = original.isNewFrame;
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

        newOV.gridID = original.gridID;
        newOV.gridType = original.gridType;
        newOV.noGridsV = original.noGridsV;
        newOV.noGridsH = original.noGridsH;
        newOV.noGridsS = original.noGridsS;
        newOV.noGridsR = original.noGridsR;
        newOV.partFamily = original.partFamily;


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

        if (original.options != null) {
            Collection newc = new ArrayList();
            Object[] rmp = original.options.toArray();
            for (final Object v : rmp) {
                newc.add(((ShapeOption) v).clone(((ShapeOption) v)));
            }
            this.options = newc;
        }

        newOV.supplierId = original.supplierId;
        newOV.supplierSeriesId = original.supplierSeriesId;
        newOV.remote = original.remote;

        return newOV;
    }

    /**
     * This method create GlassSU Model Object
     *
     * @param opening , OpeningObject
     * @param glassSU , GlassSUEntityObject
     */
    private void createGlassSUModelObject(OpeningObject opening, GlassSUEntityObject glassSU) {

        // ShapeObject DTO
        ShapeObjectDTO.getShapeObjectModel(glassSU, this, GlassSU.class);

        // Setting aditional values
        this.suID = glassSU.getSuId();
        this.assemblyID = glassSU.getAssemblyID();
        this.stockCode = glassSU.getStockCode();
        this.description = glassSU.getDescription();
        this.abbrev = glassSU.getAbbrev();
        this.minArea = glassSU.getMinArea().doubleValue();
        this.minAreaImp = glassSU.getMinAreaImp().doubleValue();
        this.maxArea = glassSU.getMaxArea().doubleValue();
        this.maxAreaImp = glassSU.getMaxAreaImp().doubleValue();
        this.minWidth = glassSU.getMinWidth();
        this.minWidthImp = glassSU.getMinWidthImp();
        this.minHeight = glassSU.getMinHeight();
        this.minHeightImp = glassSU.getMinHeightImp();
        this.whRatio = glassSU.getWhRatio().doubleValue();
        this.pricingUOMId = glassSU.getPricingUOMId();
        this.priceActualSize = glassSU.isPriceActualSize();
        this.cost = glassSU.getCost();
        this.costActualSize = glassSU.isCostActualSize();
        this.priceMatrixId = glassSU.getPriceMatrixId();
        this.price = glassSU.getPrice();
        this.minPricingArea = glassSU.getMinPricingArea().doubleValue();
        this.minPricingAreaImp = glassSU.getMinPricingAreaImp().doubleValue();
        this.minPrice = glassSU.getMinPrice();
        this.costGroupId = glassSU.getCostGroupId();
        this.priceGroupId = glassSU.getPriceGroupId();
        this.startDate = glassSU.getStartDate();
        this.endDate = glassSU.getEndDate();
        this.partnerGroupId = glassSU.getPartnerGroupId();
        this.nextItem = glassSU.getNextItem();
        this.display = glassSU.isDisplay();
        this.waste = glassSU.getWaste().doubleValue();
        this.madeIn = glassSU.isMadeIn();
        this.supplierId = glassSU.getSupplierId();
        this.leadTime = glassSU.getLeadTime();
        this.minCostArea = glassSU.getMinCostArea().doubleValue();
        this.minCostAreaImp = glassSU.getMinCostAreaImp().doubleValue();
        this.productionLine = glassSU.getProductionLine();
        this.sortSeq = glassSU.getSortSeq();
        this.glazingType = glassSU.getGlazingType();
        this.isCustom = glassSU.isCustom();
        this.numOfLeaves = glassSU.getNumOfLeaves();
        this.thickness = glassSU.getThickness().doubleValue();
        this.thicknessImp = glassSU.getThicknessImp().doubleValue();
        this.leafNo = glassSU.getLeafNo();
        this.leftIn = glassSU.isLeftIn();
        this.leafOut = glassSU.getLeafOut();
        this.leaf1 = glassSU.getLeaf_1();
        this.leaf2 = glassSU.getLeaf_2();
        this.leaf3 = glassSU.getLeaf_3();
        this.leaf4 = glassSU.getLeaf_4();
        this.spacer1 = glassSU.getSpacer_1();
        this.spacer2 = glassSU.getSpacer_2();
        this.spacer3 = glassSU.getSpacer_3();
        this.spacerThick1 = glassSU.getSpacerThick_1() != null ? glassSU.getSpacerThick_1().doubleValue() : 0;
        this.spacerThick2 = glassSU.getSpacerThick_2() != null ? glassSU.getSpacerThick_2().doubleValue() : 0;
        this.spacerThick3 = glassSU.getSpacerThick_3() != null ? glassSU.getSpacerThick_3().doubleValue() : 0;
        this.spacerThick1i = glassSU.getSpacerThick_1_i() != null ? glassSU.getSpacerThick_1_i().doubleValue() : 0;
        this.spacerThick2i = glassSU.getSpacerThick_2_i() != null ? glassSU.getSpacerThick_2_i().doubleValue() : 0;
        this.spacerThick3i = glassSU.getSpacerThick_3_i() != null ? glassSU.getSpacerThick_3_i().doubleValue() : 0;
        this.glassToSpacer = glassSU.getGlassToSpacer() != null ? glassSU.getGlassToSpacer().doubleValue() : 0;
        this.glassToSpacerImp = glassSU.getGlassToSpacerImp().doubleValue();
        this.airSpace1 = glassSU.getAirSpace_1() != null ? glassSU.getAirSpace_1().doubleValue() : 0;
        this.airSpace2 = glassSU.getAirSpace_2() != null ? glassSU.getAirSpace_2().doubleValue() : 0;
        this.airSpace3 = glassSU.getAirSpace_3() != null ? glassSU.getAirSpace_3().doubleValue() : 0;
        this.airSpace1i = glassSU.getAirSpace_1_i() != null ? glassSU.getAirSpace_1_i().doubleValue() : 0;
        this.airSpace2i = glassSU.getAirSpace_2_i() != null ? glassSU.getAirSpace_2_i().doubleValue() : 0;
        this.airSpace3i = glassSU.getAirSpace_3_i() != null ? glassSU.getAirSpace_3_i().doubleValue() : 0;
        this.gas1 = glassSU.getGas_1();
        this.gas2 = glassSU.getGas_2();
        this.gas3 = glassSU.getGas_3();
        this.film1 = glassSU.getFilm_1();
        this.film2 = glassSU.getFilm_2();
        this.film3 = glassSU.getFilm_3();
        this.film4 = glassSU.getFilm_4();
        this.process1 = glassSU.getProcess_1();
        this.process2 = glassSU.getProcess_2();
        this.process3 = glassSU.getProcess_3();
        this.process4 = glassSU.getProcess_4();
        this.cavityProcess1 = glassSU.getCavityProcess_1();
        this.cavityProcess2 = glassSU.getCavityProcess_2();
        this.cavityProcess3 = glassSU.getCavityProcess_3();
        this.cavity1Process2 = glassSU.getCavity_1_Process_2();
        this.cavity2Process2 = glassSU.getCavity_2_Process_2();
        this.cavity3Process2 = glassSU.getCavity_3_Process_2();
        this.cavity1Process3 = glassSU.getCavity_1_Process_3();
        this.cavity2Process3 = glassSU.getCavity_2_Process_3();
        this.cavity3Process3 = glassSU.getCavity_3_Process_3();
        this.externalProcess1 = glassSU.getExternalProcess_1();
        this.externalProcess2 = glassSU.getExternalProcess_2();
        this.externalProcess3 = glassSU.getExternalProcess_3();
        this.externalProcess4 = glassSU.getExternalProcess_4();
        this.external1Process2 = glassSU.getExternal_1_Process_2();
        this.external2Process2 = glassSU.getExternal_2_Process_2();
        this.external3Process2 = glassSU.getExternal_3_Process_2();
        this.external4Process2 = glassSU.getExternal_4_Process_2();
        this.external1Process3 = glassSU.getExternal_1_Process_3();
        this.external2Process3 = glassSU.getExternal_2_Process_3();
        this.external3Process3 = glassSU.getExternal_3_Process_3();
        this.external4Process3 = glassSU.getExternal_4_Process_3();
        this.glass1 = glassSU.getGlass_1();
        this.glass2 = glassSU.getGlass_2();
        this.glass3 = glassSU.getGlass_3();
        this.glass4 = glassSU.getGlass_4();
        this.glass1Process2 = glassSU.getGlass_1_Process_2();
        this.glass2Process2 = glassSU.getGlass_2_Process_2();
        this.glass3Process2 = glassSU.getGlass_3_Process_2();
        this.glass4Process2 = glassSU.getGlass_4_Process_2();
        this.glass1Process3 = glassSU.getGlass_1_Process_3();
        this.glass2Process3 = glassSU.getGlass_2_Process_3();
        this.glass3Process3 = glassSU.getGlass_3_Process_3();
        this.glass4Process3 = glassSU.getGlass_4_Process_3();
        this.familyId = glassSU.getFamily_id();
        this.insert1Id = glassSU.getInsert_id_1();
        this.insert2Id = glassSU.getInsert_id_2();
        this.insert3Id = glassSU.getInsert_id_3();

        this.gridID = glassSU.getGridID();
        this.gridType = glassSU.getGridType();
        this.noGridsV = glassSU.getNoGridsV();
        this.noGridsH = glassSU.getNoGridsH();
        this.noGridsS = glassSU.getNoGridsS();
        this.noGridsR = glassSU.getNoGridsR();
        this.partFamily = glassSU.getPartFamily();

        //********************************************************
        // 1. Creating background opening
        //********************************************************
        if (glassSU.getBkgrdOpening() != null) {
            this.bOpeningObject = new BkgrdOpeningObject(this, this.myFrame2, glassSU.getBkgrdOpening());

            //Do mullions object
            this.doMullions(this.bOpeningObject);
        }

        // ********************************************************
        // 2. Creating Openings objects
        // ********************************************************
        if (glassSU.getOpenings() != null && !glassSU.getOpenings().isEmpty()) {
            this.openings = new ArrayList();
            for (OpeningEntityObject openingEntity : glassSU.getOpenings()) {
                this.openings.add(new OpeningObject(this, this.myFrame2, openingEntity));
            }
        }

        // ********************************************************
        // 3. Creating Glass Boms
        // ********************************************************
        if (glassSU.getGlassBom() != null && !glassSU.getGlassBom().isEmpty()) {
            List<DesignGlass> glassBom = new ArrayList<DesignGlass>();
            for (DesignGlassEntityObject designGlass : glassSU.getGlassBom()) {
                glassBom.add(DesignGlassDTO.getDesignGlassModel(designGlass));
            }

            this.glassBom.addAll(glassBom);
        }

        // ********************************************************
        // Seting GlassSU to Glass Panel Design
        // ********************************************************
        this.myFrame2.glassPanel.setSelectedGlassList(this);

        // ********************************************************
        // Generate General Path
        // ********************************************************
        CreateShapeMethods createShape = new CreateShapeMethods(opening, 2, this.myFrame2);
        this.gp = createShape.doGeneralPathOpeningII(this);
    }

    /**
     * This method creating GlassSUEntityObject
     *
     * @return GlassSUEntityObject
     */
    public GlassSUEntityObject createGlassSUEntityObject() {

        GlassSUEntityObject glassSUEntityObject = (GlassSUEntityObject) ShapeObjectDTO.getShapeAbstractObject(this,
                GlassSUEntityObject.class);

        glassSUEntityObject.setSuId(this.suID);
        glassSUEntityObject.setAssemblyID(this.assemblyID);
        glassSUEntityObject.setStockCode(this.stockCode);
        glassSUEntityObject.setDescription(this.description);
        glassSUEntityObject.setAbbrev(this.abbrev);
        glassSUEntityObject.setMinArea(new BigDecimal(this.minArea + ""));
        glassSUEntityObject.setMinAreaImp(new BigDecimal(this.minAreaImp + ""));
        glassSUEntityObject.setMaxArea(new BigDecimal(this.maxArea + ""));
        glassSUEntityObject.setMaxAreaImp(new BigDecimal(this.maxAreaImp + ""));
        glassSUEntityObject.setMinWidth(this.minWidth);
        glassSUEntityObject.setMinWidthImp(this.minWidthImp);
        glassSUEntityObject.setMinHeight(this.minHeight);
        glassSUEntityObject.setMinHeightImp(this.minHeightImp);
        glassSUEntityObject.setWhRatio(new BigDecimal(this.whRatio + ""));
        glassSUEntityObject.setPricingUOMId(this.pricingUOMId);
        glassSUEntityObject.setPriceActualSize(this.priceActualSize);
        glassSUEntityObject.setCost(this.cost);
        glassSUEntityObject.setCostActualSize(this.costActualSize);
        glassSUEntityObject.setPriceMatrixId(this.priceMatrixId);
        glassSUEntityObject.setPrice(this.price);
        glassSUEntityObject.setMinPricingArea(new BigDecimal(this.minPricingArea + ""));
        glassSUEntityObject.setMinPricingAreaImp(new BigDecimal(this.minPricingAreaImp + ""));
        glassSUEntityObject.setMinPrice(this.minPrice);
        glassSUEntityObject.setCostGroupId(this.costGroupId);
        glassSUEntityObject.setPriceGroupId(this.priceGroupId);
        glassSUEntityObject.setStartDate(this.startDate);
        glassSUEntityObject.setEndDate(this.endDate);
        glassSUEntityObject.setPartnerGroupId(this.partnerGroupId);
        glassSUEntityObject.setNextItem(this.nextItem);
        glassSUEntityObject.setDisplay(this.display);
        glassSUEntityObject.setWaste(new BigDecimal(this.waste + ""));
        glassSUEntityObject.setMadeIn(this.madeIn);
        glassSUEntityObject.setSupplierId(this.supplierId);
        glassSUEntityObject.setLeadTime(this.leadTime);
        glassSUEntityObject.setMinCostArea(new BigDecimal(this.minCostArea + ""));
        glassSUEntityObject.setMinCostAreaImp(new BigDecimal(this.minCostAreaImp + ""));
        glassSUEntityObject.setProductionLine(this.productionLine);
        glassSUEntityObject.setSortSeq(this.sortSeq);
        glassSUEntityObject.setGlazingType(this.glazingType);
        glassSUEntityObject.setCustom(this.isCustom);
        glassSUEntityObject.setNumOfLeaves(this.numOfLeaves);
        glassSUEntityObject.setThickness(new BigDecimal(this.thickness + ""));
        glassSUEntityObject.setThicknessImp(new BigDecimal(this.thicknessImp + ""));
        glassSUEntityObject.setLeafNo(this.leafNo);
        glassSUEntityObject.setLeftIn(this.leftIn);
        glassSUEntityObject.setLeafOut(this.leafOut);
        glassSUEntityObject.setLeaf_1(this.leaf1);
        glassSUEntityObject.setLeaf_2(this.leaf2);
        glassSUEntityObject.setLeaf_3(this.leaf3);
        glassSUEntityObject.setLeaf_4(this.leaf4);
        glassSUEntityObject.setSpacer_1(this.spacer1);
        glassSUEntityObject.setSpacer_2(this.spacer2);
        glassSUEntityObject.setSpacer_3(this.spacer3);
        glassSUEntityObject.setSpacerThick_1(new BigDecimal(this.spacerThick1 + ""));
        glassSUEntityObject.setSpacerThick_2(new BigDecimal(this.spacerThick2 + ""));
        glassSUEntityObject.setSpacerThick_3(new BigDecimal(this.spacerThick3 + ""));
        glassSUEntityObject.setSpacerThick_1_i(new BigDecimal(this.spacerThick1i + ""));
        glassSUEntityObject.setSpacerThick_2_i(new BigDecimal(this.spacerThick2i + ""));
        glassSUEntityObject.setSpacerThick_3_i(new BigDecimal(this.spacerThick3i + ""));
        glassSUEntityObject.setGlassToSpacer(new BigDecimal(this.glassToSpacer + ""));
        glassSUEntityObject.setGlassToSpacerImp(new BigDecimal(this.glassToSpacerImp + ""));
        glassSUEntityObject.setAirSpace_1(new BigDecimal(this.airSpace1 + ""));
        glassSUEntityObject.setAirSpace_2(new BigDecimal(this.airSpace2 + ""));
        glassSUEntityObject.setAirSpace_3(new BigDecimal(this.airSpace3 + ""));
        glassSUEntityObject.setAirSpace_1_i(new BigDecimal(this.airSpace1i + ""));
        glassSUEntityObject.setAirSpace_2_i(new BigDecimal(this.airSpace2i + ""));
        glassSUEntityObject.setAirSpace_3_i(new BigDecimal(this.airSpace3i + ""));
        glassSUEntityObject.setGas_1(this.gas1);
        glassSUEntityObject.setGas_2(this.gas2);
        glassSUEntityObject.setGas_3(this.gas3);
        glassSUEntityObject.setFilm_1(this.film1);
        glassSUEntityObject.setFilm_2(this.film2);
        glassSUEntityObject.setFilm_3(this.film3);
        glassSUEntityObject.setFilm_4(this.film4);
        glassSUEntityObject.setProcess_1(this.process1);
        glassSUEntityObject.setProcess_2(this.process2);
        glassSUEntityObject.setProcess_3(this.process3);
        glassSUEntityObject.setProcess_4(this.process4);
        glassSUEntityObject.setCavityProcess_1(this.cavityProcess1);
        glassSUEntityObject.setCavityProcess_2(this.cavityProcess2);
        glassSUEntityObject.setCavityProcess_3(this.cavityProcess3);
        glassSUEntityObject.setCavity_1_Process_2(this.cavity1Process2);
        glassSUEntityObject.setCavity_2_Process_2(this.cavity2Process2);
        glassSUEntityObject.setCavity_3_Process_2(this.cavity3Process2);
        glassSUEntityObject.setCavity_1_Process_3(this.cavity1Process3);
        glassSUEntityObject.setCavity_2_Process_3(this.cavity2Process3);
        glassSUEntityObject.setCavity_3_Process_3(this.cavity3Process3);
        glassSUEntityObject.setExternalProcess_1(this.externalProcess1);
        glassSUEntityObject.setExternalProcess_2(this.externalProcess2);
        glassSUEntityObject.setExternalProcess_3(this.externalProcess3);
        glassSUEntityObject.setExternalProcess_4(this.externalProcess4);
        glassSUEntityObject.setExternal_1_Process_2(this.external1Process2);
        glassSUEntityObject.setExternal_2_Process_2(this.external2Process2);
        glassSUEntityObject.setExternal_3_Process_2(this.external3Process2);
        glassSUEntityObject.setExternal_4_Process_2(this.external4Process2);
        glassSUEntityObject.setExternal_1_Process_3(this.external1Process3);
        glassSUEntityObject.setExternal_2_Process_3(this.external2Process3);
        glassSUEntityObject.setExternal_3_Process_3(this.external3Process3);
        glassSUEntityObject.setExternal_4_Process_3(this.external4Process3);
        glassSUEntityObject.setGlass_1(this.glass1);
        glassSUEntityObject.setGlass_2(this.glass2);
        glassSUEntityObject.setGlass_3(this.glass3);
        glassSUEntityObject.setGlass_4(this.glass4);
        glassSUEntityObject.setGlass_1_Process_2(this.glass1Process2);
        glassSUEntityObject.setGlass_2_Process_2(this.glass2Process2);
        glassSUEntityObject.setGlass_3_Process_2(this.glass3Process2);
        glassSUEntityObject.setGlass_4_Process_2(this.glass4Process2);
        glassSUEntityObject.setGlass_1_Process_3(this.glass1Process3);
        glassSUEntityObject.setGlass_2_Process_3(this.glass2Process3);
        glassSUEntityObject.setGlass_3_Process_3(this.glass3Process3);
        glassSUEntityObject.setGlass_4_Process_3(this.glass4Process3);
        glassSUEntityObject.setFamily_id(this.familyId);
        glassSUEntityObject.setInsert_id_1(this.insert1Id);
        glassSUEntityObject.setInsert_id_2(this.insert2Id);
        glassSUEntityObject.setInsert_id_3(this.insert3Id);

        glassSUEntityObject.setGridID(gridID);
        glassSUEntityObject.setGridType(gridType);
        glassSUEntityObject.setNoGridsV(noGridsV);
        glassSUEntityObject.setNoGridsH(noGridsH);
        glassSUEntityObject.setNoGridsS(noGridsS);
        glassSUEntityObject.setNoGridsR(noGridsR);
        glassSUEntityObject.setPartFamily(partFamily);

        // ********************************************************
        // 1. Creating BkgrdOpening object
        // ********************************************************
        if (this.bOpeningObject != null) {
            glassSUEntityObject.setBkgrdOpening(this.bOpeningObject.createBkgrdEntityObject());
        }

        // ********************************************************
        // 2. Creating Openings objects
        // ********************************************************
        if (!this.openings.isEmpty()) {
            Set<OpeningEntityObject> openings = new HashSet<OpeningEntityObject>();
            Object[] rmp = this.openings.toArray();
            for (Object v : rmp) {
                OpeningObject opening = (OpeningObject) v;
                openings.add(opening.createOpeningEntityObject(null, null, null, null));
            }
            glassSUEntityObject.setOpenings(openings);
        }

        // ********************************************************
        // 3. Creating Glass Bom
        // ********************************************************
        if (!this.glassBom.isEmpty()) {
            Set<DesignGlassEntityObject> glassBoms = new HashSet<DesignGlassEntityObject>();
            for (DesignGlass v : this.glassBom) {
                glassBoms.add(DesignGlassDTO.getDesignGlassEntity(this.myFrame2, v));
            }
            glassSUEntityObject.setGlassBom(glassBoms);
        }

        // ********************************************************
        // 4. Creating Fenestration Ratings Glass
        // ********************************************************
        if (this.myFrame2.jobItem.shapeNotes.size() > 0) {

            Collection<ShapeNotes> notes = this.myFrame2.jobItem.shapeNotes;
            for (ShapeNotes shapeNotes : notes) {
                boolean equals = shapeNotes.equalsShapeObject(this);
                if (equals) {
                    shapeNotes.glassDescription = this.description;
                    shapeNotes.glassStockCode = this.stockCode;
                    shapeNotes.suType = this.suID;

                    //Get Glass Description
                    String _glass_desc = getDetailGlassDescription();

                    shapeNotes.glassDescription = _glass_desc;
                    shapeNotes.glassStockCode = _glass_desc;

                    //Add Shapes Notes to Frame Shape Notes
                    this.myFrame2.jobItem.frameShapeNotes.add(shapeNotes);
                }
            }
        }

        return glassSUEntityObject;
    }

    /**
     * Return Detail Glass Description
     *
     * @return String
     */
    public String getDetailGlassDescription() {

        String _glazingType = "";
        String _gasFillType = "";

        String _leaf_1_desc = "";
        String _leaf_2_desc = "";
        String _leaf_3_desc = "";
        String _leaf_4_desc = "";

        String _w_grids_desc = "";

        //************************************************************************************
        //Search Glazing Type
        //************************************************************************************
        if (this.numOfLeaves == 2) {
            _glazingType = "Double Glazing";
        }

        if (this.numOfLeaves == 3) {
            _glazingType = "Triple Glazing";
        }

        if (this.numOfLeaves == 4) {
            _glazingType = "Quadruple Glazing";
        }

        //************************************************************************************
        //Search Gas Descriptions
        //************************************************************************************
        if (this.description.toLowerCase().contains("arg")) {
            _gasFillType = "Argon Fill";
        }

        if (this.description.toLowerCase().contains("kry")) {
            _gasFillType = "Krypton Fill";
        }

        if (this.description.toLowerCase().contains("oxy")) {
            _gasFillType = "Oxygen Fill";
        }

        if (this.description.toLowerCase().contains("nit")) {
            _gasFillType = "Nitrogen Fill";
        }

        //************************************************************************************
        //Search Leaf Descriptions
        //************************************************************************************

        //Remote Call Object
        if (this.remote) {

            if (this.leaf1 > 0) {
                _leaf_1_desc = ItemFrame.getApplicationRemoteBaseRules().getSUType(this.supplierId, this.leaf1).getDescription();
            }

            if (this.leaf2 > 0) {
                _leaf_2_desc = ItemFrame.getApplicationRemoteBaseRules().getSUType(this.supplierId, this.leaf2).getDescription();
            }

            if (this.leaf3 > 0) {
                _leaf_3_desc = ItemFrame.getApplicationRemoteBaseRules().getSUType(this.supplierId, this.leaf3).getDescription();
            }

            if (this.leaf4 > 0) {
                _leaf_4_desc = ItemFrame.getApplicationRemoteBaseRules().getSUType(this.supplierId, this.leaf4).getDescription();
            }
        }

        //Local Call Object
        if (!this.remote) {

            if (this.leaf1 > 0) {
                _leaf_1_desc = ItemFrame.getApplicationBaseRules().getSUType(this.leaf1).getDescription();
            }

            if (this.leaf2 > 0) {
                _leaf_2_desc = ItemFrame.getApplicationBaseRules().getSUType(this.leaf2).getDescription();
            }

            if (this.leaf3 > 0) {
                _leaf_3_desc = ItemFrame.getApplicationBaseRules().getSUType(this.leaf3).getDescription();
            }

            if (this.leaf4 > 0) {
                _leaf_4_desc = ItemFrame.getApplicationBaseRules().getSUType(this.leaf4).getDescription();
            }
        }

        //************************************************************************************
        //Load Grids Description
        //************************************************************************************

        if (this.gridID > 0) {
            _w_grids_desc = ", Grids";
        }

        //************************************************************************************
        //Construct Glass description
        //************************************************************************************

        String glassDescription = "";
        if (_glazingType.length() > 0) {
            glassDescription = glassDescription + _glazingType;
        }

        if (_leaf_1_desc.length() > 0) {
            glassDescription = glassDescription + " * " + _leaf_1_desc;
        }

        if (_leaf_2_desc.length() > 0) {
            glassDescription = glassDescription + " * " + _leaf_2_desc;
        }

        if (_leaf_3_desc.length() > 0) {
            glassDescription = glassDescription + " * " + _leaf_3_desc;
        }

        if (_leaf_4_desc.length() > 0) {
            glassDescription = glassDescription + " * " + _leaf_4_desc;
        }

        if (_gasFillType.length() > 0) {
            glassDescription = glassDescription + " * " + _gasFillType;
        }

        if (_w_grids_desc.length() > 0) {
            glassDescription = glassDescription + _w_grids_desc;
        }

        return glassDescription;
    }

    /**
     * Reset Glass Bom Collection
     *
     * @throws Exception, Exception
     */
    public void resetGlassBom() throws Exception {

        // Setting grid values to BOM
        for (DesignGlass glassBOM : this.glassBom) {
            glassBOM.gridID = this.gridID;
            glassBOM.gridType = this.gridType;
            glassBOM.noGridsV = this.noGridsV;
            glassBOM.noGridsH = this.noGridsH;
            glassBOM.noGridsS = this.noGridsS;
            glassBOM.noGridsR = this.noGridsR;
        }

        // Adding Glass Bom for GlassSU to JobItem
        this.myFrame2.jobItem.glassBOM.addAll(this.glassBom);

        // Reset Glass Bom for Opening
        if (!this.openings.isEmpty()) {
            for (Object v : this.openings) {
                ((OpeningObject) v).resetGlassBom();
            }
        }
    }

    /**
     * Reset Shapes Notes Collection
     *
     * @throws Exception , Exception
     */
    public void resetShapeNotes() throws Exception {

        // Adding Glass Bom for GlassSU to JobItem
        this.myFrame2.jobItem.shapeNotes.addAll(this.notes);

        // Reset Shape Notes Bkgrd Opening
        this.bOpeningObject.resetShapeNotes();

        if (!this.openings.isEmpty()) {
            for (Object v : this.openings) {
                ((OpeningObject) v).resetShapeNotes();
            }
        }
    }

    /**
     * Is for GlassSU
     *
     * @return GlassSU
     * @throws Exception , Exception
     */
    public GlassSU isForGlassSU(DesignGlass designGlass) throws Exception {

        Map<Integer, LevelSequence> _glass_su = this.shapeMapLevels(this.getClass(), this);
        Map<Integer, LevelSequence> _glass_bom = this.shapeMapLevels(designGlass.getClass(), designGlass);

        // ************************************************************************
        // Compare levels for child and Parent
        // ************************************************************************
        int sizeChildLevels = _glass_su.size();
        int sizeParentLevels = _glass_bom.size();

        if (sizeChildLevels == sizeParentLevels) {

            for (int i = 1; i <= sizeChildLevels; i++) {
                LevelSequence childSequence = _glass_su.get(i);
                LevelSequence parentSequence = _glass_bom.get(i);

                if (childSequence.levelID != parentSequence.levelID || childSequence.sequenceID != parentSequence.sequenceID) {
                    return null;
                }
            }

            return this;
        }

        return null;
    }

    /**
     * Return Glass Bom Collection
     *
     * @return List<DesignGlass>
     */
    public List<DesignGlass> getGlassBom() {
        return this.glassBom;
    }

    /**
     * This method create a copy of javabeans with a clone of properties values
     *
     * @param glassSUEntity , GlassSUEntityObject
     * @return GlassSUEntityObject
     */
    public GlassSUEntityObject cloneObjectModel(GlassSUEntityObject glassSUEntity) {

		/* Clone GlassSU Entity object */
        GlassSUEntityObject glassSU = (GlassSUEntityObject) ShapeObjectDTO.cloneShapeAbstractObject(glassSUEntity,
                GlassSUEntityObject.class);

        glassSU.setSuId(glassSUEntity.getSuId());
        glassSU.setStockCode(glassSUEntity.getStockCode());
        glassSU.setDescription(glassSUEntity.getDescription());
        glassSU.setAbbrev(glassSUEntity.getAbbrev());
        glassSU.setMinArea(glassSUEntity.getMinArea());
        glassSU.setMinAreaImp(glassSUEntity.getMinAreaImp());
        glassSU.setMaxArea(glassSUEntity.getMaxArea());
        glassSU.setMaxAreaImp(glassSUEntity.getMaxAreaImp());
        glassSU.setMinWidth(glassSUEntity.getMinWidth());
        glassSU.setMinWidthImp(glassSUEntity.getMinWidthImp());
        glassSU.setMinHeight(glassSUEntity.getMinHeight());
        glassSU.setMinHeightImp(glassSUEntity.getMinHeightImp());
        glassSU.setWhRatio(glassSUEntity.getWhRatio());
        glassSU.setPricingUOMId(glassSUEntity.getPricingUOMId());
        glassSU.setPriceActualSize(glassSUEntity.isPriceActualSize());
        glassSU.setCost(glassSUEntity.getCost());
        glassSU.setCostActualSize(glassSUEntity.isCostActualSize());
        glassSU.setPriceMatrixId(glassSUEntity.getPriceMatrixId());
        glassSU.setPrice(glassSUEntity.getPrice());
        glassSU.setMinPricingArea(glassSUEntity.getMinPricingArea());
        glassSU.setMinPricingAreaImp(glassSUEntity.getMinPricingAreaImp());
        glassSU.setMinPrice(glassSUEntity.getMinPrice());
        glassSU.setCostGroupId(glassSUEntity.getCostGroupId());
        glassSU.setPriceGroupId(glassSUEntity.getPriceGroupId());
        glassSU.setStartDate(glassSUEntity.getStartDate());
        glassSU.setEndDate(glassSUEntity.getEndDate());
        glassSU.setPartnerGroupId(glassSUEntity.getPartnerGroupId());
        glassSU.setNextItem(glassSUEntity.getNextItem());
        glassSU.setDisplay(glassSUEntity.isDisplay());
        glassSU.setWaste(glassSUEntity.getWaste());
        glassSU.setMadeIn(glassSUEntity.isMadeIn());
        glassSU.setSupplierId(glassSUEntity.getSupplierId());
        glassSU.setLeadTime(glassSUEntity.getLeadTime());
        glassSU.setMinCostArea(glassSUEntity.getMinCostArea());
        glassSU.setMinCostAreaImp(glassSUEntity.getMinCostAreaImp());
        glassSU.setProductionLine(glassSUEntity.getProductionLine());
        glassSU.setSortSeq(glassSUEntity.getSortSeq());
        glassSU.setGlazingType(glassSUEntity.getGlazingType());
        glassSU.setCustom(glassSUEntity.isCustom());
        glassSU.setNumOfLeaves(glassSUEntity.getNumOfLeaves());
        glassSU.setThickness(glassSUEntity.getThickness());
        glassSU.setThicknessImp(glassSUEntity.getThicknessImp());
        glassSU.setLeafNo(glassSUEntity.getLeafNo());
        glassSU.setLeftIn(glassSUEntity.isLeftIn());
        glassSU.setLeafOut(glassSUEntity.getLeafOut());
        glassSU.setLeaf_1(glassSUEntity.getLeaf_1());
        glassSU.setLeaf_2(glassSUEntity.getLeaf_2());
        glassSU.setLeaf_3(glassSUEntity.getLeaf_3());
        glassSU.setLeaf_4(glassSUEntity.getLeaf_4());
        glassSU.setSpacer_1(glassSUEntity.getSpacer_1());
        glassSU.setSpacer_2(glassSUEntity.getSpacer_2());
        glassSU.setSpacer_3(glassSUEntity.getSpacer_3());
        glassSU.setSpacerThick_1(glassSUEntity.getSpacerThick_1());
        glassSU.setSpacerThick_2(glassSUEntity.getSpacerThick_2());
        glassSU.setSpacerThick_3(glassSUEntity.getSpacerThick_3());
        glassSU.setGlassToSpacer(glassSUEntity.getGlassToSpacer());
        glassSU.setGlassToSpacerImp(glassSUEntity.getGlassToSpacerImp());
        glassSU.setAirSpace_1(glassSUEntity.getAirSpace_1());
        glassSU.setAirSpace_2(glassSUEntity.getAirSpace_2());
        glassSU.setAirSpace_3(glassSUEntity.getAirSpace_3());
        glassSU.setGas_1(glassSUEntity.getGas_1());
        glassSU.setGas_2(glassSUEntity.getGas_2());
        glassSU.setGas_3(glassSUEntity.getGas_3());
        glassSU.setFilm_1(glassSUEntity.getFilm_1());
        glassSU.setFilm_2(glassSUEntity.getFilm_2());
        glassSU.setFilm_3(glassSUEntity.getFilm_3());
        glassSU.setFilm_4(glassSUEntity.getFilm_4());
        glassSU.setProcess_1(glassSUEntity.getProcess_1());
        glassSU.setProcess_2(glassSUEntity.getProcess_2());
        glassSU.setProcess_3(glassSUEntity.getProcess_3());
        glassSU.setProcess_4(glassSUEntity.getProcess_4());
        glassSU.setCavityProcess_1(glassSUEntity.getCavityProcess_1());
        glassSU.setCavityProcess_2(glassSUEntity.getCavityProcess_2());
        glassSU.setCavityProcess_3(glassSUEntity.getCavityProcess_3());
        glassSU.setCavity_1_Process_2(glassSUEntity.getCavity_1_Process_2());
        glassSU.setCavity_2_Process_2(glassSUEntity.getCavity_2_Process_2());
        glassSU.setCavity_3_Process_2(glassSUEntity.getCavity_3_Process_2());
        glassSU.setCavity_1_Process_3(glassSUEntity.getCavity_1_Process_3());
        glassSU.setCavity_2_Process_3(glassSUEntity.getCavity_2_Process_3());
        glassSU.setCavity_3_Process_3(glassSUEntity.getCavity_3_Process_3());
        glassSU.setExternalProcess_1(glassSUEntity.getExternalProcess_1());
        glassSU.setExternalProcess_2(glassSUEntity.getExternalProcess_2());
        glassSU.setExternalProcess_3(glassSUEntity.getExternalProcess_3());
        glassSU.setExternalProcess_4(glassSUEntity.getExternalProcess_4());
        glassSU.setExternal_1_Process_2(glassSUEntity.getExternal_1_Process_2());
        glassSU.setExternal_2_Process_2(glassSUEntity.getExternal_2_Process_2());
        glassSU.setExternal_3_Process_2(glassSUEntity.getExternal_3_Process_2());
        glassSU.setExternal_4_Process_2(glassSUEntity.getExternal_4_Process_2());
        glassSU.setExternal_1_Process_3(glassSUEntity.getExternal_1_Process_3());
        glassSU.setExternal_2_Process_3(glassSUEntity.getExternal_2_Process_3());
        glassSU.setExternal_3_Process_3(glassSUEntity.getExternal_3_Process_3());
        glassSU.setExternal_4_Process_3(glassSUEntity.getExternal_4_Process_3());
        glassSU.setGlass_1(glassSUEntity.getGlass_1());
        glassSU.setGlass_2(glassSUEntity.getGlass_2());
        glassSU.setGlass_3(glassSUEntity.getGlass_3());
        glassSU.setGlass_4(glassSUEntity.getGlass_4());
        glassSU.setGlass_1_Process_2(glassSUEntity.getGlass_1_Process_2());
        glassSU.setGlass_2_Process_2(glassSUEntity.getGlass_2_Process_2());
        glassSU.setGlass_3_Process_2(glassSUEntity.getGlass_3_Process_2());
        glassSU.setGlass_4_Process_2(glassSUEntity.getGlass_4_Process_2());
        glassSU.setGlass_1_Process_3(glassSUEntity.getGlass_1_Process_3());
        glassSU.setGlass_2_Process_3(glassSUEntity.getGlass_2_Process_3());
        glassSU.setGlass_3_Process_3(glassSUEntity.getGlass_3_Process_3());
        glassSU.setGlass_4_Process_3(glassSUEntity.getGlass_4_Process_3());
        glassSU.setFamily_id(glassSUEntity.getFamily_id());
        glassSU.setInsert_id_1(glassSUEntity.getInsert_id_1());
        glassSU.setInsert_id_2(glassSUEntity.getInsert_id_2());
        glassSU.setInsert_id_3(glassSUEntity.getInsert_id_3());
        glassSU.setGridID(glassSUEntity.getGridID());
        glassSU.setGridType(glassSUEntity.getGridType());
        glassSU.setNoGridsV(glassSUEntity.getNoGridsV());
        glassSU.setNoGridsH(glassSUEntity.getNoGridsH());
        glassSU.setNoGridsS(glassSUEntity.getNoGridsS());
        glassSU.setNoGridsR(glassSUEntity.getNoGridsR());
        glassSU.setPartFamily(glassSUEntity.getPartFamily());

        glassSU.setOpenings(null);

        // Clone Openings
        if (glassSUEntity.getOpenings() != null && !glassSUEntity.getOpenings().isEmpty()) {
            OpeningObject openingObject = new OpeningObject();

            Set<OpeningEntityObject> openings = new HashSet<OpeningEntityObject>();
            for (OpeningEntityObject opening : glassSUEntity.getOpenings()) {
                openings.add(openingObject.cloneObjectModel(opening));
            }

            glassSU.setOpenings(openings);
        }

        return glassSU;
    }

    @Override
    public GlassSU clone() {

        try {

            GlassSU newGlassSU = (GlassSU) super.clone();

            // Clone opening collections
            Collection _openings = new ArrayList();
            for (Object opening : newGlassSU.openings) {
                _openings.add(((OpeningObject) opening).clone());
            }
            newGlassSU.openings = _openings;

            return newGlassSU;

        } catch (CloneNotSupportedException e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }

    /**
     * Clone SUType to GlassSU
     */
    public void cloneSUType(SUType suType) {

        this.suID = suType.getId();
        this.stockCode = suType.getStockCode();
        this.description = suType.getDescription();
        this.abbrev = suType.getAbbrev();
        this.minArea = suType.getMinArea();
        this.minAreaImp = suType.getMinAreaImp();
        this.maxArea = suType.getMaxArea();
        this.maxAreaImp = suType.getMaxAreaImp();
        this.minWidth = suType.getMinWidth();
        this.minWidthImp = suType.getMinWidthImp();
        this.maxWidth = suType.getMaxWidth();
        this.maxWidthImp = suType.getMaxWidthImp();
        this.minHeight = suType.getMinHeight();
        this.minHeightImp = suType.getMinHeightImp();
        this.whRatio = suType.getWhRatio();
        this.pricingUOMId = suType.getPricingUOMId();
        this.priceActualSize = suType.getPriceActualSize();
        this.cost = new BigDecimal(0);
        this.costActualSize = suType.getCostActualSize();
        this.priceMatrixId = suType.getPriceMatrixId();
        this.price = new BigDecimal(0);
        this.minPricingArea = suType.getMinPricingArea();
        this.minPricingAreaImp = suType.getMinPricingAreaImp();
        this.minPrice = suType.getMinPrice();
        this.costGroupId = suType.getCostGroupId();
        this.priceGroupId = suType.getPriceGroupId();
        this.startDate = suType.getStartDate();
        this.endDate = suType.getEndDate();
        this.partnerGroupId = suType.getPartnerGroupId();
        this.nextItem = suType.getNextItem();
        this.display = suType.getDisplay();
        this.waste = suType.getWaste();
        this.madeIn = suType.getMadeIn();
        this.supplierId = suType.getSupplierId();
        this.leadTime = suType.getLeadTime();
        this.minCostArea = suType.getMinCostArea();
        this.minCostAreaImp = suType.getMinCostAreaImp();
        this.productionLine = suType.getProductionLine();
        this.sortSeq = suType.getSortSeq();
        this.glazingType = suType.getGlazingType();
        this.isCustom = suType.getCustom();
        this.numOfLeaves = suType.getNumOfLeaves();
        this.thickness = suType.getThickness();
        this.thicknessImp = suType.getThicknessImp();
        this.leaf1 = suType.getLeaf1Id() != null ? suType.getLeaf1Id() : 0;
        this.leaf2 = suType.getLeaf2Id() != null ? suType.getLeaf2Id() : 0;
        this.leaf3 = suType.getLeaf3Id() != null ? suType.getLeaf3Id() : 0;
        this.leaf4 = suType.getLeaf4Id() != null ? suType.getLeaf4Id() : 0;
        this.spacer1 = suType.getSpacer1PartId() != null ? suType.getSpacer1PartId() : 0;
        this.spacer2 = suType.getSpacer2PartId() != null ? suType.getSpacer2PartId() : 0;
        this.spacer3 = suType.getSpacer3PartId() != null ? suType.getSpacer3PartId() : 0;
        this.glassToSpacer = suType.getGlassEdgeToSpacerIn() != null ? suType.getGlassEdgeToSpacerIn() : 0;
        this.glassToSpacerImp = suType.getGlassEdgeToSpacerInImp() != null ? suType.getGlassEdgeToSpacerInImp() : 0;
        this.gas1 = suType.getGas1PartId() != null ? suType.getGas1PartId() : 0;
        this.gas2 = suType.getGas2PartId() != null ? suType.getGas2PartId() : 0;
        this.gas3 = suType.getGas3PartId() != null ? suType.getGas3PartId() : 0;
        this.film1 = suType.getGlass1FilmPartId() != null ? suType.getGlass1FilmPartId() : 0;
        this.film2 = suType.getGlass2FilmPartId() != null ? suType.getGlass2FilmPartId() : 0;
        this.film3 = suType.getGlass3FilmPartId() != null ? suType.getGlass3FilmPartId() : 0;
        this.film4 = suType.getGlass4FilmPartId() != null ? suType.getGlass4FilmPartId() : 0;
        this.process1 = suType.getGlass1ProcessId() != null ? suType.getGlass1ProcessId() : 0;
        this.process2 = suType.getGlass2ProcessId() != null ? suType.getGlass2ProcessId() : 0;
        this.process3 = suType.getGlass3ProcessId() != null ? suType.getGlass3ProcessId() : 0;
        this.process4 = suType.getGlass4ProcessId() != null ? suType.getGlass4ProcessId() : 0;
        this.cavityProcess1 = suType.getCavity1ProcessId() != null ? suType.getCavity1ProcessId() : 0;
        this.cavityProcess2 = suType.getCavity2ProcessId() != null ? suType.getCavity2ProcessId() : 0;
        this.cavityProcess3 = suType.getCavity3ProcessId() != null ? suType.getCavity3ProcessId() : 0;
        this.cavity1Process2 = suType.getCavity1Process2Id() != null ? suType.getCavity1Process2Id() : 0;
        this.cavity2Process2 = suType.getCavity2Process2Id() != null ? suType.getCavity2Process2Id() : 0;
        this.cavity3Process2 = suType.getCavity3Process2Id() != null ? suType.getCavity3Process2Id() : 0;
        this.cavity1Process3 = suType.getCavity1Process3Id() != null ? suType.getCavity1Process3Id() : 0;
        this.cavity2Process3 = suType.getCavity2Process3Id() != null ? suType.getCavity2Process3Id() : 0;
        this.cavity3Process3 = suType.getCavity3Process3Id() != null ? suType.getCavity3Process3Id() : 0;
        this.externalProcess1 = suType.getExternal1ProcessId() != null ? suType.getExternal1ProcessId() : 0;
        this.externalProcess2 = suType.getExternal2ProcessId() != null ? suType.getExternal2ProcessId() : 0;
        this.externalProcess3 = suType.getExternal3ProcessId() != null ? suType.getExternal3ProcessId() : 0;
        this.externalProcess4 = suType.getExternal4ProcessId() != null ? suType.getExternal4ProcessId() : 0;
        this.external1Process2 = suType.getExternal1Process2Id() != null ? suType.getExternal1Process2Id() : 0;
        this.external2Process2 = suType.getExternal2Process2Id() != null ? suType.getExternal2Process2Id() : 0;
        this.external3Process2 = suType.getExternal3Process2Id() != null ? suType.getExternal3Process2Id() : 0;
        this.external4Process2 = suType.getExternal4Process2Id() != null ? suType.getExternal4Process2Id() : 0;
        this.external1Process3 = suType.getExternal1Process3Id() != null ? suType.getExternal1Process3Id() : 0;
        this.external2Process3 = suType.getExternal2Process3Id() != null ? suType.getExternal2Process3Id() : 0;
        this.external3Process3 = suType.getExternal3Process3Id() != null ? suType.getExternal3Process3Id() : 0;
        this.external4Process3 = suType.getExternal4Process3Id() != null ? suType.getExternal4Process3Id() : 0;
        this.glass1 = suType.getGlass1ProcessId() != null ? suType.getGlass1ProcessId() : 0;
        this.glass2 = suType.getGlass2ProcessId() != null ? suType.getGlass2ProcessId() : 0;
        this.glass3 = suType.getGlass3ProcessId() != null ? suType.getGlass3ProcessId() : 0;
        this.glass4 = suType.getGlass4ProcessId() != null ? suType.getGlass4ProcessId() : 0;
        this.glass1Process2 = suType.getGlass1Process2Id() != null ? suType.getGlass1Process2Id() : 0;
        this.glass2Process2 = suType.getGlass2Process2Id() != null ? suType.getGlass2Process2Id() : 0;
        this.glass3Process2 = suType.getGlass3Process2Id() != null ? suType.getGlass3ProcessId() : 0;
        this.glass4Process2 = suType.getGlass4Process2Id() != null ? suType.getGlass4Process2Id() : 0;
        this.glass1Process3 = suType.getGlass1Process3Id() != null ? suType.getGlass1Process3Id() : 0;
        this.glass2Process3 = suType.getGlass2Process3Id() != null ? suType.getGlass2Process3Id() : 0;
        this.glass3Process3 = suType.getGlass3Process3Id() != null ? suType.getGlass3Process3Id() : 0;
        this.glass4Process3 = suType.getGlass4Process3Id() != null ? suType.getGlass4Process3Id() : 0;
        this.sealantPartId = suType.getSealantPartId() != null ? suType.getSealantPartId() : -1;
        this.familyId = suType.getFamilyId() != null ? suType.getFamilyId() : -1;
        this.insert1Id = suType.getInsert1Id() != null ? suType.getInsert1Id() : -1;
        this.insert2Id = suType.getInsert2Id() != null ? suType.getInsert2Id() : -1;
        this.insert3Id = suType.getInsert3Id() != null ? suType.getInsert3Id() : -1;
        this.measure = suType.getMeasure() != null ? suType.getMeasure() : -1;
        this.inHouse = suType.isInHouse();
        this.partFamily = suType.getPartFamily();

        this.assemblyID = suType.getAssemblyId() != null ? suType.getAssemblyId() : -1;

        this.supplierId = suType.getSupplierRemoteId();
        this.supplierSeriesId = suType.getSupplierSeriesId();
        this.remote = suType.isRemote();
    }

    // **********************************************************************************************
    // Implementing methods for Matrix calculation
    // **********************************************************************************************

    @Override
    public BigDecimal returnOpeningClassID() {
        return new BigDecimal(myParentO.openingClass);
    }

    @Override
    public BigDecimal returnShapeID() {
        return new BigDecimal(shapeID);
    }

    @Override
    public BigDecimal returnUserDefinedOpeningID() {
        return new BigDecimal(myParentO.userDefinedOpeningID);
    }

    @Override
    public BigDecimal returnPartnerIdentificationID() {

        if (myFrame2.supplierPanel.getSupplierController().getPartnerSelected() != null)
            return new BigDecimal(myFrame2.supplierPanel.getSupplierController().getPartnerSelected().getPartnerid());

        return new BigDecimal(-1);
    }

    @Override
    public BigDecimal returnPartnerGroupID() {

        if (myFrame2.supplierPanel.getSupplierController().getPartnerSelected() != null)
            return new BigDecimal(myFrame2.supplierPanel.getSupplierController().getPartnerSelected().getGroupId());

        return new BigDecimal(-1);
    }

    @Override
    public BigDecimal returnDesignID() {
        return new BigDecimal(-1);
    }

    @Override
    public BigDecimal returnStdProductID() {
        return new BigDecimal(-1);
    }

    @Override
    public BigDecimal calculateWidth(int systemMeasurement) {

        try {
            return glassSUController.calculateWidthFromMatrix(systemMeasurement);
        } catch (Exception e) {
            // Throw message error
        }

        return new BigDecimal("-1");
    }

    @Override
    public BigDecimal calculateHeight(int systemMeasurement) {
        try {
            return glassSUController.calculateHeightFromMatrix(systemMeasurement);
        } catch (Exception e) {
            // Throw message error
        }

        return new BigDecimal("-1");
    }

    @Override
    public BigDecimal calculateUI(int systemMeasurement) {
        try {
            return glassSUController.calculateUI(systemMeasurement);
        } catch (Exception e) {
            // Throw message error
        }

        return new BigDecimal("-1");
    }

    @Override
    public BigDecimal calculateArea(int systemMeasurement) {
        try {
            return glassSUController.calculateNominalAreaGlass(this.myParentO, systemMeasurement);
        } catch (Exception e) {
            // Throw message error
        }

        return new BigDecimal("-1");
    }

    @Override
    public BigDecimal returnNumberRadii() {
        return new BigDecimal("-1");
    }

    @Override
    public BigDecimal returnProductType() {
        return new BigDecimal("-1");
    }

    @Override
    public BigDecimal calculateLength(int systemMeasurement) {
        return new BigDecimal("-1");
    }

    @Override
    public BigDecimal returnQty() {
        return new BigDecimal("1");
    }

    @Override
    public BigDecimal calculateVolume(int systemMeasurement) {
        return new BigDecimal("-1");
    }

    @Override
    public BigDecimal returnStockCode() {
        return new BigDecimal("-1");
    }

    @Override
    public BigDecimal returnGlassSUID() {
        return new BigDecimal(suID);
    }

    @Override
    public boolean suTypeTest(RuleTest test, List myRuleTestValues) {
        boolean pass = false;

        if (test.isrange) {
            pass = isWithinRange(test.value1, test.value2, suID);

        } else {
            pass = isWithinValues(suID, 0, myRuleTestValues.toArray());

        }

        if (test.isnot) {
            pass = !pass;
        }

        return pass;
    }

    @Override
    public boolean suGlass1Test(RuleTest test, List myRuleTestValues) {
        boolean pass = false;

        if (test.isrange) {
            pass = isWithinRange(test.value1, test.value2, this.glass1);

        } else {
            pass = isWithinValues(this.glass1, 0, myRuleTestValues.toArray());

        }

        if (test.isnot) {
            pass = !pass;
        }

        return pass;
    }

    @Override
    public boolean suGlass2Test(RuleTest test, List myRuleTestValues) {
        boolean pass = false;

        if (test.isrange) {
            pass = isWithinRange(test.value1, test.value2, this.glass2);

        } else {
            pass = isWithinValues(this.glass2, 0, myRuleTestValues.toArray());

        }

        if (test.isnot) {
            pass = !pass;
        }

        return pass;
    }

    @Override
    public boolean suGlass3Test(RuleTest test, List myRuleTestValues) {
        boolean pass = false;

        if (test.isrange) {
            pass = isWithinRange(test.value1, test.value2, this.glass3);

        } else {
            pass = isWithinValues(this.glass3, 0, myRuleTestValues.toArray());

        }

        if (test.isnot) {
            pass = !pass;
        }

        return pass;
    }

    @Override
    public boolean suGlass4Test(RuleTest test, List myRuleTestValues) {
        boolean pass = false;

        if (test.isrange) {
            pass = isWithinRange(test.value1, test.value2, this.glass4);

        } else {
            pass = isWithinValues(this.glass4, 0, myRuleTestValues.toArray());

        }

        if (test.isnot) {
            pass = !pass;
        }

        return pass;
    }

    @Override
    public boolean suIDTest(RuleTest test, List myRuleTestValues) {

        boolean pass = false;

        if (test.isrange) {
            pass = isWithinRange(test.value1, test.value2, suID);

        } else {
            pass = isWithinValues(suID, 0, myRuleTestValues.toArray());

        }

        if (test.isnot) {
            pass = !pass;
        }

        return pass;
    }

    @Override
    public boolean suFamilyTest(RuleTest test, List myRuleTestValues) {

        boolean pass = false;

        if (test.isrange) {
            pass = isWithinRange(test.value1, test.value2, this.familyId);

        } else {
            pass = isWithinValues(familyId, 0, myRuleTestValues.toArray());

        }

        if (test.isnot) {
            pass = !pass;
        }

        return pass;
    }

    @Override
    public boolean suThicknessTest(RuleTest test, int uom, List myRuleTestValues) {

        boolean pass = false;

        if (test.isrange) {
            if (uom == 1) {
                pass = isWithinRange(test.value1, test.value2, this.thickness);
            } else {
                pass = isWithinRange(test.value1i, test.value2i, this.thicknessImp);
            }

        } else {
            if (uom == 1) {
                pass = isWithinValues(thickness, uom, myRuleTestValues.toArray());
            } else {
                pass = isWithinValues(thicknessImp, uom, myRuleTestValues.toArray());
            }

        }

        if (test.isnot) {
            pass = !pass;
        }

        return pass;
    }

    @Override
    public boolean airSpaceTest(RuleTest test, int uom, List myRuleTestValues, int space) {

        boolean pass = false;

        double aspacem = airSpace1;
        double aspacei = airSpace1i;
        if (space == 2) {
            aspacem = airSpace2;
            aspacei = airSpace2i;
        } else if (space == 3) {
            aspacem = airSpace3;
            aspacei = airSpace3i;
        }

        if (test.isrange) {
            if (uom == 1) {
                pass = isWithinRange(test.value1, test.value2, aspacem);
            } else {
                pass = isWithinRange(test.value1i, test.value2i, aspacei);
            }

        } else {
            if (uom == 1) {
                pass = isWithinValues(aspacem, uom, myRuleTestValues.toArray());
            } else {
                pass = isWithinValues(aspacei, uom, myRuleTestValues.toArray());
            }

        }

        if (test.isnot) {
            pass = !pass;
        }

        return pass;
    }

    /**
     * Show String description object
     *
     * @return String
     */
    @Override
    public String toString() {
        return this.description;
    }

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
    public boolean gridIDTest(RuleTest test, List myRuleTestValues) {

        boolean pass = false;

        if (test.isrange) {
            pass = isWithinRange(test.value1, test.value2, gridID);

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
            pass = isWithinRange(test.value1, test.value2, gridType);

        } else {
            pass = isWithinValues(gridType, 0, myRuleTestValues.toArray());

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
            executePartRules(rule, true);
        }

        // ********************************************************
        // 1. Creating background opening
        // ********************************************************
        if (this.bOpeningObject != null) {
            this.bOpeningObject.isMatchingBOMRule(rule, doBOM);
        }

        // ********************************************************
        // 2. Creating Openings objects
        // ********************************************************
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

        // ********************************************************
        // 1. Load BOM for background opening
        // ********************************************************
        if (this.bOpeningObject != null) {
            this.bOpeningObject.loadBOMParts();
        }

        // ********************************************************
        // 2. Load BOM for Openings objects
        // ********************************************************
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
            this.bom.clear();
        }

        // ********************************************************
        // 1. Creating background opening
        // ********************************************************
        if (this.bOpeningObject != null) {
            this.bOpeningObject.clearBOMParts();
        }

        // ********************************************************
        // 2. Creating Openings objects
        // ********************************************************
        if (this.openings != null) {
            Object[] rmp = this.openings.toArray();
            for (Object v : rmp) {
                ((OpeningObject) v).clearBOMParts();
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

        // ********************************************************
        // 1. Load BOM for background opening
        // ********************************************************
        if (this.bOpeningObject != null) {
            this.bOpeningObject.loadOptionsAll();
        }

        // ********************************************************
        // 2. Load BOM for Openings objects
        // ********************************************************
        if (this.openings != null) {
            Object[] rmp = this.openings.toArray();
            for (Object v : rmp) {
                ((OpeningObject) v).loadOptionsAll();
            }
        }

    }

    @Override
    public BigDecimal returnSUFamiles() {
        return new BigDecimal(this.familyId);
    }

}

/**
 * Copyright (c) 2009, OpenJanela. All rights reserved.
 * User: Sherif El Dibani
 */

package Model;

import Model.ProfileParts.*;
import Model.TextObjects.FacetBotText;
import Model.TextObjects.TextFieldLeft;
import Model.TextObjects.TextFieldTop;
import Model.matrix.MatrixDictionaryCalculation;
import Operations.*;
import Presentation.DrawCanvas;
import Presentation.ItemFrame;
import Presentation.ShapeDimensionDialog;
import dto.ConstructionMapDTO;
import dto.ProfileDTO;
import openjanela.model.entities.design.ConstructionMap;
import openjanela.model.entities.design.OpeningContentTypes;
import openjanela.model.entities.partner.*;

import org.apache.log4j.Logger;
import org.openjanela.data.ApplicationBaseApp;

import util.UOMConvert;

import javax.swing.*;

import java.awt.*;
import java.awt.geom.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;

public abstract class ShapeObject implements MatrixDictionaryCalculation,
		Cloneable {

	// Apache log4j
	private static final Logger logger = Logger.getLogger(ShapeObject.class);

	public int a_assemblyLevel = 0; // OK

	public int a_1Level = 0; // OK

	public int a_1Sequence = 0; // OK

	public int a_2Level = 0; // OK

	public int a_2Sequence = 0; // OK

	public int a_3Level = 0; // OK

	public int a_3Sequence = 0; // OK

	public int a_4Level = 0; // OK

	public int a_4Sequence = 0; // OK

	public int a_5Level = 0; // OK

	public int a_5Sequence = 0; // OK

	public int a_6Level = 0; // OK

	public int a_6Sequence = 0; // OK

	public int a_7Level = 0; // OK

	public int a_7Sequence = 0; // OK

	public int a_8Level = 0; // OK

	public int a_8Sequence = 0; // OK

	public int a_9Level = 0; // OK

	public int a_9Sequence = 0; // OK

	public int a_10Level = 0; // OK

	public int a_10Sequence = 0; // OK

	public int a_11Level = 0; // OK

	public int a_11Sequence = 0; // OK

	public int a_12Level = 0; // OK

	public int a_12Sequence = 0; // OK

	public int a_13Level = 0; // OK

	public int a_13Sequence = 0; // OK

	public int a_14Level = 0; // OK

	public int a_14Sequence = 0; // OK

	public int a_15Level = 0; // OK

	public int a_15Sequence = 0; // OK

	public int a_16Level = 0; // OK

	public int a_16Sequence = 0; // OK

	public int a_17Level = 0; // OK

	public int a_17Sequence = 0; // OK

	public int a_18Level = 0; // OK

	public int a_18Sequence = 0; // OK

	public int a_19Level = 0; // OK

	public int a_19Sequence = 0; // OK

	public int a_20Level = 0; // OK

	public int a_20Sequence = 0; // OK

	public int a_21Level = 0; // OK

	public int a_21Sequence = 0; // OK

	public int a_22Level = 0; // OK

	public int a_22Sequence = 0; // OK

	public int id = 0; // OK

	public int rID = 0; // OK

	public int a_levelID = 0; // OK

	public int a_sequenceID = 11; // OK

	public int widthM = 0; // OK

	public int heightM = 0; // OK

	public int widthI = 0; // OK

	public int heightI = 0; // OK

	public int widthMN = 0; // OK

	public int heightMN = 0; // OK

	public int widthIN = 0; // OK

	public int heightIN = 0; // OK

	public int widthMO = 0; // OK

	public int heightMO = 0; // OK

	public int widthIO = 0; // OK

	public int heightIO = 0; // OK

	public boolean isStdW = false; // OK

	public boolean isStdH = false; // OK

	public int stdWM = 0; // OK

	public int stdHM = 0; // OK

	public int stdWI = 0; // OK

	public int stdHI = 0; // OK

	public BigDecimal originalScaleM = new BigDecimal(0); // OK

	public BigDecimal originalScaleI = new BigDecimal(0); // OK

	public Collection removedParts = new ArrayList();

	public int noPartsTop1 = 0; // OK

	public int noPartsTop2 = 0; // OK

	public int noPartsTop3 = 0; // OK

	public int noPartsBot1 = 0; // OK

	public int noPartsBot2 = 0; // OK

	public int noPartsBot3 = 0; // OK

	public int noPartsLeft = 0; // OK

	public int noPartsRight = 0; // OK

	public OpeningObject opening;

	public ShapeObject myParent;

	public Collection openings = new ArrayList();

	public ShapeObject myFacet;

	public ShapeObject myOverall;

	public BkgrdOpeningObject bOpeningObjectIn;

	public BkgrdOpeningObject bOpeningObject;

	public BkgrdOpeningObject bOpeningObjectOut;

	public Collection frames = new ArrayList();

	public boolean newDesign = true; // OK

	public int frameStartCol = 0; // OK

	public int frameStartRow = 0; // OK

	public int frameEndCol = 0; // OK

	public int frameEndRow = 0; // OK

	public int xCols = 1; // OK

	public int yRows = 1; // OK

	/* number of Rows from either Couplers or Mullions */

	public int noTracks = 1; // OK

	public boolean openOut = false; // OK

	/* Open in Put From OpeningType or ID */

	public boolean glazedOut = false; // OK

	public double radius1A = 0; // OK

	public double radius2A = 0; // OK

	public double startAngleA = 0; // OK

	public double endAngleA = 0; // OK

	public double centralAngleA = 0; // OK

	public Profiles myMullionBot = null;

	public Profiles myMullionTop = null;

	public Profiles myMullionLeft = null;

	public Profiles myMullionRight = null;

	public boolean hasSash = false; // OK

	public boolean unGlazed = false; // OK

	public int openingClass = 1; // OK

	/*
	 * Sash/Picture Opening Class ID IF !hassash = 1 *
	 * 
	 * * series_valid_opening_shape.opening_id
	 */
	public int userDefinedOpeningID = 0; // OK

	/*
	 * Actual sashid(as user defined) == select user
	 * 
	 * User Defined Opening.
	 * 
	 * series_valid_opening_shape.id
	 * 
	 * PictureType
	 */

	public SashLeaf outSash;

	public SashLeaf inSash;

	public SashLeaf midSash;

	public GlassSU myGlass;

	public int outSashTracks = 1; // OK

	public int inSashTracks = 1; // OK

	public int midSashTracks = 1; // OK

	public int shapeID = 1; // OK

	public boolean openIn = false; // OK

	public int lean = 0; // on

	// //OK

	public int lean2 = 0; // OK

	public int lean3 = 0; // OK

	public int lean4 = 0; // OK

	/*
	 * for lean 1 : 0 no lean, 1 right ...---, 2 3 centered ...---... for lean
	 * 2: 0 no lean, 2 Bottom ...---b, 1 Top t---...., 3 centered t..--..b for
	 * Lean 3: 0 no lean ,2 Left, 1 Right, 3 for Lean 4: 0 no lean , 2 top , 1
	 * bottom, 3
	 */

	public int noSides = 4; // OK

	public int noSidesTop = 1; // OK

	public int noSidesBot = 1; // OK

	public int noSidesLeft = 1; // OK

	public int noSidesRight = 1; // OK

	public int topShape = 1; // OK

	public int rightShape = 1; // OK

	public int botShape = 1; // OK

	public int leftShape = 1; // OK

	public int dimA1M = 0; // OK

	public int dimA2M = 0; // OK

	public int dimA3M = 0; // OK

	public int dimA4M = 0; // OK

	public int dimA5M = 0; // OK

	public int dimA0M = 0; // OK

	public int dimB1M = 0; // OK

	public int dimB2M = 0; // OK

	public int dimB3M = 0; // OK

	public int dimB4M = 0; // OK

	public int dimB5M = 0; // OK

	public int dimB0M = 0; // OK

	public int dimC1M = 0; // OK

	public int dimC2M = 0; // OK

	public int dimC3M = 0; // OK

	public int dimC4M = 0; // OK

	public int dimC5M = 0; // OK

	public int dimC0M = 0; // OK

	public int dimD1M = 0; // OK

	public int dimD2M = 0; // OK

	public int dimD3M = 0; // OK

	public int dimD4M = 0; // OK

	public int dimD5M = 0; // OK

	public int dimD0M = 0; // OK

	public int dimA1I = 0; // OK

	public int dimA2I = 0; // OK

	public int dimA3I = 0; // OK

	public int dimA4I = 0; // OK

	public int dimA5I = 0; // OK

	public int dimA0I = 0; // OK

	public int dimB1I = 0; // OK

	public int dimB2I = 0; // OK

	public int dimB3I = 0; // OK

	public int dimB4I = 0; // OK

	public int dimB5I = 0; // OK

	public int dimB0I = 0; // OK

	public int dimC1I = 0; // OK

	public int dimC2I = 0; // OK

	public int dimC3I = 0; // OK

	public int dimC4I = 0; // OK

	public int dimC5I = 0; // OK

	public int dimC0I = 0; // OK

	public int dimD1I = 0; // OK

	public int dimD2I = 0; // OK

	public int dimD3I = 0; // OK

	public int dimD4I = 0; // OK

	public int dimD5I = 0; // OK

	public int dimD0I = 0; // OK

	// ******************************************************************
	// Do not save objects
	public Top1Object top1 = new Top1Object();

	public Top2Object top2 = new Top2Object();

	public Top3Object top3 = new Top3Object();

	public RightObject right = new RightObject();

	public LeftObject left = new LeftObject();

	public Bot1Object bot1 = new Bot1Object();

	public Bot2Object bot2 = new Bot2Object();

	public Bot3Object bot3 = new Bot3Object();

	public Profiles top1Part = new Profiles();

	public Profiles top2Part = new Profiles();

	public Profiles top3Part = new Profiles();

	public Profiles rightPart = new Profiles();

	public Profiles leftPart = new Profiles();

	public Profiles bot1Part = new Profiles();

	public Profiles bot2Part = new Profiles();

	public Profiles bot3Part = new Profiles();

	public Collection partObjects = new ArrayList();

	// **************************************************

	public double radius1 = 0; // OK

	public double radius2 = 0; // OK

	public double startAngle = 0; // OK

	public double endAngle = 0; // OK

	public double centralAngle; // OK

	public int startCol = 0; // OK

	public int endCol = 0; // OK

	public int startRow = 0; // OK

	public int endRow = 0; // OK

	public boolean topIn = false; // in

	// //OK

	public boolean rightIn = false; // OK

	public boolean botIn = false; // OK

	public boolean leftIn = false; // OK

	public double clearanceTop = 0; // OK

	public double clearanceBot = 0; // OK

	public double clearanceLeft = 0; // OK

	public double clearanceRight = 0; // OK

	public BigDecimal scaleM = new BigDecimal(0); // OK

	public BigDecimal scaleImp = new BigDecimal(0); // OK

	public int baseUOM = 1; // OK

	/*
	 * //////////////////////////////// //////Calculated variable //////
	 * ////////////////////////////////
	 */
	public double widthPix = 0;

	public double heightPix = 0;

	public double minLeg = 120;

	public double minW = 80;

	public double minH = 80;

	public double minArea = 3600;

	public double minDiagonal = 200;

	public double minAspectRatio = 4 / 5;

	public double maxW = 1000000000f;

	public double maxH = 1000000000f;

	public double maxArea = 1000000000f;

	public double maxDiagonal = 1000000000f;

	public boolean autoW = true;

	public boolean autoH = true;

	public double highestX = 0;

	public double lowestX = 0;

	public double highestY = 0;

	public double lowestY = 0;

	public double highestYC = 0;

	public double lowestYC = 0;

	public boolean isNewFrame = true;

	public boolean affected = false;

	public ShapeObject myClickedOpening;

	public double newRowH = 0;

	public ShapeObject myClickedFrame;

	public ShapeObject myClickedSash;

	public ItemFrame myFrame2;

	public int myRow = 0;

	public int myCol = 0;

	public int myShapeID = 0;

	public int myPrevShape = 0;

	public int myNewShape = 0;

	public int myOpeningID = 0;

	public int mynewOpeningID = 0;

	public int mynewOpenindType = 0;

	public double newWidthTop = 0;

	public double newWidthBot = 0;

	public double newStartingY = 0;

	public double newStartingX = 0;

	public double newHL = 0;

	public double newHR = 0;

	public double newstartX = 0;

	public double newendX = 0;

	public double newstartY = 0;

	public double newendY = 0;

	public double newDimD2 = 0;

	public double newDimB1 = 0;

	public int rowColToAdd = 0; // if

	public int addRow = 0;

	public double dividedCentral = 0;

	public double myCouplerThickness = 0;

	public boolean wireFrame = false;

	public int parentid = 1;

	public int parentStartRow = 0;

	public int parentStartCol = 0;

	public double startingXBA = 0;

	public double startingYBA = 0;

	public double startingXA = 0;

	public double startingYA = 0;

	public double bX2A = 0;

	public double bY2A = 0;

	public double bX3A = 0;

	public double bY3A = 0;

	public double bX4A = 0;

	public double bY4A = 0;

	public double bX2B = 0;

	public double bY2B = 0;

	public double bX3B = 0;

	public double bY3B = 0;

	public double bX4B = 0;

	public double bY4B = 0;

	public double openingW = 0;

	public double openingH = 0;

	public double openingWc = 0;

	public double openingHc = 0;

	public double openingWB = 0;

	public double openingHR = 0;

	public double openingWcB = 0;

	public double openingHcR = 0;

	public double openingWA = 0;

	public double openingHA = 0;

	public double openingWBA = 0;

	public double openingHRA = 0;

	public double dimTM = 0;

	public double dimBM = 0;

	public double dimLM = 0;

	public double dimRM = 0;

	public double dimTA = 0;

	public double dimBA = 0;

	public double dimLA = 0;

	public double dimRA = 0;

	public int lastSeq = 0;

	/**
	 * Main Group TYpe: Windows, Doors, Entrances Etc.
	 */
	public int controlOpeningClassType = 1;

	/**
	 * Opening Class
	 */
	public int controlOpeningClass = 1;

	/**
	 * User Defined Opening TYpe
	 */
	public int controlUserDefinedOpeningID = 1;

	/**
	 * Which Opening Controls the Type of Frame
	 * <p/>
	 * For example Casement Frame, Slider Frame etc. Especially useful when
	 * Mixed Openings in 1 frame
	 */
	public int controlOpSeq = 11;

	public double bkgrdStartXA;

	public double bkgrdStartYA;

	public double px1 = 0;

	public double py1 = 0;

	public double px2 = 0;

	public double py2 = 0;

	public double px3 = 0;

	public double py3 = 0;

	public double px4 = 0;

	public double py4 = 0;

	public double px5 = 0;

	public double py5 = 0;

	public double px6 = 0;

	public double py6 = 0;

	public double px7 = 0;

	public double py7 = 0;

	public double px8 = 0;

	public double py8 = 0;

	public double px1A = 0;

	public double py1A = 0;

	public double px2A = 0;

	public double py2A = 0;

	public double px3A = 0;

	public double py3A = 0;

	public double px4A = 0;

	public double py4A = 0;

	public double px5A = 0;

	public double py5A = 0;

	public double px6A = 0;

	public double py6A = 0;

	public double px7A = 0;

	public double py7A = 0;

	public double px8A = 0;

	public double py8A = 0;

	public double px1c = 0;

	public double py1c = 0;

	public double px2c = 0;

	public double py2c = 0;

	public double px3c = 0;

	public double py3c = 0;

	public double px4c = 0;

	public double py4c = 0;

	public double px5c = 0;

	public double py5c = 0;

	public double px6c = 0;

	public double py6c = 0;

	public double px7c = 0;

	public double py7c = 0;

	public double px8c = 0;

	public double py8c = 0;

	public GeneralPath gp = new GeneralPath();

	public double startingX = 0;

	public double startingY = 0;

	public double bX2 = 0;

	public double bY2 = 0;

	public double bX3 = 0;

	public double bY3 = 0;

	public double bX4 = 0;

	public double bY4 = 0;

	public double startingCX = 0; // Edge

	public double startingCY = 0;

	public double bCX2 = 0;

	public double bCY2 = 0;

	public double bCX3 = 0;

	public double bCY3 = 0;

	public double bCX4 = 0;

	public double bCY4 = 0;

	public double levelW = 0;

	public double levelH = 0;

	public double dimA1 = 0;

	public double dimA2 = 0;

	public double dimA3 = 0;

	public double dimA4 = 0;

	public double dimA5 = 0;

	public double dimA0 = 0;

	public double dimB1 = 0;

	public double dimB2 = 0;

	public double dimB3 = 0;

	public double dimB4 = 0;

	public double dimB5 = 0;

	public double dimB0 = 0;

	public double dimC1 = 0;

	public double dimC2 = 0;

	public double dimC3 = 0;

	public double dimC4 = 0;

	public double dimC5 = 0;

	public double dimC0 = 0;

	public double dimD1 = 0;

	public double dimD2 = 0;

	public double dimD3 = 0;

	public double dimD4 = 0;

	public double dimD5 = 0;

	public double dimD0 = 0;

	public double pA1 = 0;

	public double pA2 = 0;

	public double pA3 = 0;

	public double pA4 = 0;

	public double pA5 = 0;

	public double pA0 = 0;

	public double pB1 = 0;

	public double pB2 = 0;

	public double pB3 = 0;

	public double pB4 = 0;

	public double pB5 = 0;

	public double pB0 = 0;

	public double pC1 = 0;

	public double pC2 = 0;

	public double pC3 = 0;

	public double pC4 = 0;

	public double pC5 = 0;

	public double pC0 = 0;

	public double pD1 = 0;

	public double pD2 = 0;

	public double pD3 = 0;

	public double pD4 = 0;

	public double pD5 = 0;

	public double pD0 = 0;

	public boolean wire = false;

	public double centerPointX = 0;

	public double centerPointY = 0;

	public double centerPointX2 = 0;

	public double centerPointY2 = 0;

	public double bkgrdStartX;

	public double bkgrdStartY;

	public double parentW = 0;

	public double parentH = 0;

	public double parentStartY = 0;

	public double parentStartX = 0;

	public double parentRadius1 = 0;

	public Collection xCoordB = new ArrayList();

	public Collection yCoordB = new ArrayList();

	Collection xCoordBA = new ArrayList();

	Collection yCoordBA = new ArrayList();

	Collection xCoordA = new ArrayList();

	Collection yCoordA = new ArrayList();

	Object[] xCoordBo;

	Object[] yCoordBo;

	Object[] xCoordBoBA;

	Object[] yCoordBoBA;

	Object[] xCoordBoA;

	Object[] yCoordBoA;

	double myX = 0;

	double myY = 0;

	GeneralPath topObjectPath = new GeneralPath();

	public double deltaA1 = 0;

	public double deltaC2 = 0;

	public double deltaD1 = 0;

	public boolean frameWRounded = false;

	public boolean frameHRounded = false;

	public boolean facetWRounded = false;

	public boolean facetHRounded = false;

	public boolean shapeChanged = false;

	public int arcType = 0;

	public double parentCX = 0;

	public double parentCY = 0;

	public double parentCX2 = 0;

	public double parentCY2 = 0;

	public int parentShape = 0;

	public boolean newPart = true;

	public FindBiggestDLO findDLO;

	public AnalyseShape analyseShape;

	public DrawCanvas myCanvas;

	public EndTypeVerification verify;

	public SetLeanTo setLeanTo;

	public CreateOpenings createOpenings;

	public boolean frameShapeChanged = false;

	public Frame frame;

	public Facet facet;

	public BigDecimal myScale = new BigDecimal(0);

	public GeneralPath myLine = new GeneralPath();

	public boolean extDone = false;

	public boolean doframes = false;

	public OpeningObject myParentO;

	public ShapeObject myParentF;

	public Collection<ShapeOption> options = new ArrayList();

	public List<BillOfMat> bom = new ArrayList();

	public Collection<ShapeNotes> notes = new ArrayList();

	// added from sashType
	public int leafNo = 0;

	public int trackNo = 0;

	public int paneType = 0;

	public boolean addCoupler = false;

	public boolean drawShape = false;

	public int supplierId = 0;

	public int supplierSeriesId = 0;

	public boolean remote = false;

	// ///////////////////////////////////////////////

	public ShapeObject() {
	}

	public ShapeObject(JobItemModel jobItem, ItemFrame frame2, int shapeID,
			double scale, int recordID, int parentItem) {

		myFrame2 = frame2;

		scaleM = myFrame2.scale;
		this.shapeID = shapeID;
		startingX = myFrame2.jobItem.startingX;
		startingY = myFrame2.jobItem.startingY;
		rID = recordID;

		a_levelID = 1;

	}

	/**
	 * Create side shapes
	 * 
	 * @param newPart
	 *            , Creating a new part
	 * @param shapeChange
	 *            , Shape object change
	 * @param scale
	 *            , Scale object
	 */
	public void createSideShapes(boolean newPart, boolean shapeChange,
			BigDecimal scale) {

		if (a_levelID != 2 || a_levelID != 4 || a_levelID != 7
				|| a_levelID != 9 || a_levelID != 12 || a_levelID != 14
				|| a_levelID != 17 || a_levelID != 19 || a_levelID != 22
				|| a_levelID != 25) {

			top1 = new Top1Object(this, newPart);
			top2 = new Top2Object(this, newPart);
			top3 = new Top3Object(this, newPart);
			bot1 = new Bot1Object(this, newPart);
			bot2 = new Bot2Object(this, newPart);
			bot3 = new Bot3Object(this, newPart);
			left = new LeftObject(this, newPart);
			right = new RightObject(this, newPart);
		}

		analyseShape = new AnalyseShape(this, shapeChange, myFrame2, scale);
		analyseShape = null;
	}

	// //////////FRAME METHODS//////////////////////
	public void resetParts() throws Exception {

		this.setProfilesFromPartObjects();
		this.resetRemovedParts();
		this.setLevelShapeParts();
		this.setnoParts();
	}

	public void setPartObjectsFromProfiles() {

		top1 = (Top1Object) top1.cloneProfile(top1Part);
		top2 = (Top2Object) top2.cloneProfile(top2Part);
		top3 = (Top3Object) top3.cloneProfile(top3Part);
		bot1 = (Bot1Object) bot1.cloneProfile(bot1Part);
		bot2 = (Bot2Object) bot2.cloneProfile(bot2Part);
		bot3 = (Bot3Object) bot3.cloneProfile(bot3Part);

		left = (LeftObject) left.cloneProfile(leftPart);
		right = (RightObject) right.cloneProfile(rightPart);

		myFacet.partObjects.clear();

		if (myFacet.noSidesTop == 1) {
			myFacet.partObjects.add(myFacet.top1Part);
		} else if (myFacet.noSidesTop == 2) {
			myFacet.partObjects.add(myFacet.top1Part);
			myFacet.partObjects.add(myFacet.top2Part);
		} else if (myFacet.noSidesTop == 3) {
			myFacet.partObjects.add(myFacet.top1Part);
			myFacet.partObjects.add(myFacet.top2Part);
			myFacet.partObjects.add(myFacet.top3Part);
		}
		if (myFacet.noSidesBot == 1) {
			myFacet.partObjects.add(myFacet.bot1Part);
		} else if (myFacet.noSidesBot == 2) {
			myFacet.partObjects.add(myFacet.bot1Part);
			myFacet.partObjects.add(myFacet.bot2Part);
		} else if (myFacet.noSidesBot == 3) {
			myFacet.partObjects.add(myFacet.bot1Part);
			myFacet.partObjects.add(myFacet.bot2Part);
			myFacet.partObjects.add(myFacet.bot3Part);
		}
		if (myFacet.noSidesLeft == 1) {
			myFacet.partObjects.add(myFacet.leftPart);
		}
		if (myFacet.noSidesRight == 1) {
			myFacet.partObjects.add(myFacet.rightPart);
		}

	}

	public void setProfilesFromPartObjects() {

		partObjects.clear();

		top1Part = (Profiles) top1Part.cloneProfile(top1);

		top1Part.leftIn = false;
		top1Part.rightIn = false;

		top2Part = (Profiles) top2Part.cloneProfile(top2);
		top3Part = (Profiles) top3Part.cloneProfile(top3);

		rightPart = (Profiles) rightPart.cloneProfile(right);
		leftPart = (Profiles) leftPart.cloneProfile(left);

		bot1Part = (Profiles) bot1Part.cloneProfile(bot1);
		bot1Part.leftIn = false;
		bot1Part.rightIn = false;

		bot2Part = (Profiles) bot2Part.cloneProfile(bot2);
		bot3Part = (Profiles) bot3Part.cloneProfile(bot3);

		top1Part.myParent = this;
		top2Part.myParent = this;
		top3Part.myParent = this;
		bot1Part.myParent = this;
		bot2Part.myParent = this;
		bot3Part.myParent = this;
		rightPart.myParent = this;
		leftPart.myParent = this;

		if (noSidesTop == 1) {
			partObjects.add(top1Part);
		} else if (noSidesTop == 2) {
			partObjects.add(top1Part);
			partObjects.add(top2Part);
		} else if (noSidesTop == 3) {
			partObjects.add(top1Part);
			partObjects.add(top2Part);
			partObjects.add(top3Part);
		}

		if (noSidesBot == 1) {
			partObjects.add(bot1Part);
		} else if (noSidesBot == 2) {
			partObjects.add(bot1Part);
			partObjects.add(bot2Part);
		} else if (noSidesBot == 3) {
			partObjects.add(bot1Part);
			partObjects.add(bot2Part);
			partObjects.add(bot3Part);
		}

		if (noSidesLeft == 1) {
			partObjects.add(leftPart);
		}

		if (noSidesRight == 1) {
			partObjects.add(rightPart);
		}
	}

	/**
	 * Removing parts for shape object
	 */
	public void resetRemovedParts() throws Exception {

		Object[] parts = partObjects.toArray();
		partObjects.clear();
		Object[] remParts = removedParts.toArray();

		for (Object P : parts) {
			for (Object rP : remParts) {
				if (((Profiles) P).position == ((RemovedParts) rP).position
						&& ((Profiles) P).seq == ((RemovedParts) rP).seq) {
					((Profiles) P).remove = true;
					this.removeBot(((Profiles) P));
				} else {
					((Profiles) P).remove = false;
				}
			}
			partObjects.add(P);
		}

	}

	public void resetOpeningGlazed() throws Exception {

		Object[] VM = bOpeningObject.mullions.toArray();
		bOpeningObject.mullions.clear();

		for (Object M : VM) {
			((Profiles) M).partLeft = true;
			((Profiles) M).partRight = true;
			bOpeningObject.mullions.add(M);
		}

		Object[] Op = openings.toArray();
		openings.clear();

		for (Object O : Op) {

			if (((OpeningObject) O).unGlazed) {

				((OpeningObject) O).unGlazed = false;

				if (((OpeningObject) O).myGlassIn != null) {
					this.redoInGlass(O);
				}
				if (((OpeningObject) O).myGlassMid != null) {
					this.redoMidGlass(O, true);
				}
				if (((OpeningObject) O).myGlassOut != null) {
					this.redoOutGlass(O);
				}
			}
			openings.add(O);
		}
	}

	@SuppressWarnings("unchecked")
	public void resetOpeningGP() throws Exception { // after removal of parts

		Object[] parts = partObjects.toArray();
		partObjects.clear();
		Object[] remParts = removedParts.toArray();
		for (Object P : parts) {
			for (Object rP : remParts) {
				if (((Profiles) P).position == ((RemovedParts) rP).position
						&& ((Profiles) P).seq == ((RemovedParts) rP).seq) {
					((Profiles) P).remove = true;
					this.removeBot(((Profiles) P));
				} else {
					((Profiles) P).remove = false;
				}
			}
			partObjects.add(P);
		}
	}

	public void removeBot(Profiles myPart) throws Exception {

		Profiles leftM = null;
		Profiles rightM = null;

		if (myPart.leftIn) {
			bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
			bOpeningObject.mullions.clear();

			for (Object MV : bOpeningObject.mullionObjectsV) {
				if ((Profiles) MV == myPart.mullionLeft) {
					((Profiles) MV).endTypeRB = 2;
					((Profiles) MV).partRight = false;
					((Profiles) MV).y3cl = ((Profiles) MV).y3;
					leftM = (Profiles) MV;

				}
				bOpeningObject.mullions.add(MV);
			}

		}
		if (myPart.rightIn) {
			bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
			bOpeningObject.mullions.clear();

			for (Object MV : bOpeningObject.mullionObjectsV) {
				if ((Profiles) MV == myPart.mullionRight) {
					((Profiles) MV).endTypeRB = 2;
					((Profiles) MV).partLeft = false;
					((Profiles) MV).y4al = ((Profiles) MV).y4;
					rightM = (Profiles) MV;
				}
				bOpeningObject.mullions.add(MV);
			}

		}

		if (!myPart.leftIn) {
			leftPart.startYA = leftPart.startYBA;
			leftPart.stopAsX = 0;
			leftPart.stopAsY = 0;
			left.startYA = left.startYBA;
			left.stopAsX = 0;
			left.stopAsY = 0;

		}
		if (!myPart.rightIn) {
			rightPart.endYA = rightPart.endYBA;
			rightPart.stopAeX = 0;
			rightPart.stopAeY = 0;
			right.endYA = right.endYBA;
			right.stopAeX = 0;
			right.stopAeY = 0;

		}
		if (!myPart.leftIn || !myPart.rightIn) {
			this.setProfilesFromPartObjects();
			this.setnoParts();
			if (glazedOut) {
				this.doGPParts(true);
			} else {
				this.doGPParts(false);
			}

		}

		this.recheckOpening(myPart, leftM, rightM, 2);
	}

	public void setLevelShapeParts() {

	}

	public void setnoParts() {

		noPartsTop1 = 0;
		noPartsBot1 = 0;
		for (final Object P : partObjects) {
			if (((Profiles) P).position == 1) {
				noPartsTop1 = noPartsTop1 + 1;

			}
			if (((Profiles) P).position == 2) {
				noPartsTop2 = 1;
			}
			if (((Profiles) P).position == 3) {
				noPartsTop3 = 1;
			}
			if (((Profiles) P).position == 5) {
				noPartsBot1 = noPartsBot1 + 1;

			}
			if (((Profiles) P).position == 6) {
				noPartsBot2 = 1;
			}
			if (((Profiles) P).position == 7) {
				noPartsBot3 = 1;
			}
			if (((Profiles) P).position == 8) {
				noPartsLeft = 1;
			}
			if (((Profiles) P).position == 4) {
				noPartsRight = 1;
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void doGPParts(boolean doBA) {

		final Object[] myparts = partObjects.toArray();
		partObjects.clear();

		for (final Object P : myparts) {
			if (((Profiles) P).partForm == 1) {
				((Profiles) P).gp = ((Profiles) P).doGPProfiles(((Profiles) P),
						widthPix, heightPix, shapeID, top1Part, bot1Part, 0,
						leftIn, rightIn, doBA);
				((Profiles) P).polygon = ((Profiles) P).doGPProfilesPoly(
						((Profiles) P), widthPix, heightPix, shapeID, top1Part,
						bot1Part, 0, leftIn, rightIn);
			} else if (((Profiles) P).partForm > 1) {
				((Profiles) P).gp = ((Profiles) P).doGPProfiles(((Profiles) P),
						widthPix, heightPix, shapeID, top1Part, bot1Part, 0,
						leftIn, rightIn, doBA);
				((Profiles) P).curveB = ((Profiles) P).doGPProfiles(
						((Profiles) P), widthPix, heightPix, shapeID, top1Part,
						bot1Part, 1, leftIn, rightIn, doBA);
				((Profiles) P).curveBA = ((Profiles) P).doGPProfiles(
						((Profiles) P), widthPix, heightPix, shapeID, top1Part,
						bot1Part, 2, leftIn, rightIn, doBA);
				((Profiles) P).curveA = ((Profiles) P).doGPProfiles(
						((Profiles) P), widthPix, heightPix, shapeID, top1Part,
						bot1Part, 3, leftIn, rightIn, doBA);
			}
			// ((Profiles) P).rgb_R = 255;
			// ((Profiles) P).rgb_G = 255;
			// ((Profiles) P).rgb_B = 255;

			partObjects.add(P);
		}

	}

	public void recheckOpening(final Profiles myPart, final Profiles leftM,
			final Profiles rightM, final int whichRemoved) throws Exception {

		/* whichRemoved 1 Top 2 Bot 0 None */
		final Object[] openingObjects = openings.toArray();
		openings.clear();

		for (final Object O : openingObjects) {

			if (myPart.position == 5
					&& ((OpeningObject) O).bX3 >= myPart.endXBA
					&& ((OpeningObject) O).bX4 <= myPart.startXBA
					&& ((OpeningObject) O).endRow == ((OpeningObject) O).myParent.yRows
					||

					myPart.position <= 3
					&& ((OpeningObject) O).bX2 >= myPart.endXBA
					&& ((OpeningObject) O).startingX <= myPart.startXBA
					&& ((OpeningObject) O).startRow == 1) {

				if (!((OpeningObject) O).botIn
						&& ((OpeningObject) O).leftIn
						&& ((OpeningObject) O).rightIn
						&& ((OpeningObject) O).myMullionLeft.rowCol == leftM.rowCol
						&& ((OpeningObject) O).myMullionRight.rowCol == rightM.rowCol) {
					((OpeningObject) O).bCY4 = leftM.y3;
					((OpeningObject) O).bY4 = leftM.y3;

					((OpeningObject) O).bCY3 = rightM.y4;
					((OpeningObject) O).bY3 = rightM.y4;
					if (((OpeningObject) O).topIn) {

						((OpeningObject) O).py4 = ((OpeningObject) O).py4c = ((OpeningObject) O).py4A = leftM.y3;
						((OpeningObject) O).py3 = ((OpeningObject) O).py3c = ((OpeningObject) O).py3A = rightM.y4;
						((OpeningObject) O).bot1.startY = ((OpeningObject) O).bot1Part.startYC = ((OpeningObject) O).py3;
						((OpeningObject) O).right.endY = ((OpeningObject) O).rightPart.endYC = ((OpeningObject) O).py3;
						((OpeningObject) O).bot1.endY = ((OpeningObject) O).bot1Part.endYC = ((OpeningObject) O).py4;
						((OpeningObject) O).bot1.startYA = ((OpeningObject) O).bot1Part.startYA = ((OpeningObject) O).py3A;
						((OpeningObject) O).right.endYA = ((OpeningObject) O).rightPart.endYA = ((OpeningObject) O).py3A;
						((OpeningObject) O).bot1.endYA = ((OpeningObject) O).bot1Part.endYA = ((OpeningObject) O).py4A;
					}
					if (!((OpeningObject) O).topIn
							&& ((OpeningObject) O).noSidesTop == 1) {

						((OpeningObject) O).py4 = ((OpeningObject) O).py4c = leftM.y3;
						((OpeningObject) O).py3 = ((OpeningObject) O).py3c = rightM.y4;
						((OpeningObject) O).right.endY = ((OpeningObject) O).rightPart.endYC = ((OpeningObject) O).py3;
						((OpeningObject) O).bot1.startY = ((OpeningObject) O).bot1Part.startYC = ((OpeningObject) O).py3;
						((OpeningObject) O).bot1.endY = ((OpeningObject) O).bot1Part.endYC = ((OpeningObject) O).py4;
						((OpeningObject) O).py4A = leftM.y3;
						((OpeningObject) O).py3A = rightM.y4;
						((OpeningObject) O).right.endYA = ((OpeningObject) O).rightPart.endYA = ((OpeningObject) O).py3A;
						((OpeningObject) O).bot1.startYA = ((OpeningObject) O).bot1Part.startYA = ((OpeningObject) O).py3A;
						((OpeningObject) O).bot1.endYA = ((OpeningObject) O).bot1Part.endYA = ((OpeningObject) O).py4A;

					} else if (!((OpeningObject) O).topIn
							&& ((OpeningObject) O).noSidesTop == 2) {
						((OpeningObject) O).py5 = ((OpeningObject) O).py5c = leftM.y3;
						((OpeningObject) O).py4 = ((OpeningObject) O).py4c = rightM.y4;
						((OpeningObject) O).heightPix = ((OpeningObject) O).heightPix
								+ myPart.partDimB;
						((OpeningObject) O).bot1.startY = ((OpeningObject) O).bot1Part.startYC = ((OpeningObject) O).py4;
						((OpeningObject) O).right.endY = ((OpeningObject) O).rightPart.endYC = ((OpeningObject) O).py4;
						((OpeningObject) O).bot1.endY = ((OpeningObject) O).bot1Part.endYC = ((OpeningObject) O).py5;

						((OpeningObject) O).py5A = leftM.y3;
						((OpeningObject) O).py4A = rightM.y4;

						((OpeningObject) O).bot1.startYA = ((OpeningObject) O).bot1Part.startYA = ((OpeningObject) O).py4A;
						((OpeningObject) O).right.endYA = ((OpeningObject) O).rightPart.endYA = ((OpeningObject) O).py4A;
						((OpeningObject) O).bot1.endYA = ((OpeningObject) O).bot1Part.endYA = ((OpeningObject) O).py5A;
					} else if (!((OpeningObject) O).topIn
							&& ((OpeningObject) O).noSidesTop == 3) {
						((OpeningObject) O).py6 = ((OpeningObject) O).py6c = leftM.y3;
						((OpeningObject) O).py5 = ((OpeningObject) O).py5c = rightM.y4;
						((OpeningObject) O).bot1.startY = ((OpeningObject) O).bot1Part.startYC = ((OpeningObject) O).py5;
						((OpeningObject) O).right.endY = ((OpeningObject) O).rightPart.endYC = ((OpeningObject) O).py5;
						((OpeningObject) O).bot1.endY = ((OpeningObject) O).bot1Part.endYC = ((OpeningObject) O).py6;

						((OpeningObject) O).py6A = leftM.y3;
						((OpeningObject) O).py5A = rightM.y4;
						((OpeningObject) O).bot1.startYA = ((OpeningObject) O).bot1Part.startYA = ((OpeningObject) O).py5A;
						((OpeningObject) O).right.endYA = ((OpeningObject) O).rightPart.endYA = ((OpeningObject) O).py5A;
						((OpeningObject) O).bot1.endYA = ((OpeningObject) O).bot1Part.endYA = ((OpeningObject) O).py6A;
					}

				} else if (!((OpeningObject) O).botIn
						&& !((OpeningObject) O).leftIn
						&& ((OpeningObject) O).rightIn

						&& ((OpeningObject) O).myMullionRight.rowCol == rightM.rowCol) {
					((OpeningObject) O).bCY4 = ((OpeningObject) O).leftPart.startYC;
					((OpeningObject) O).bY4 = ((OpeningObject) O).myParent.leftPart.startYBA;

					((OpeningObject) O).bCY3 = rightM.y4;
					((OpeningObject) O).bY3 = rightM.y4;
					if (((OpeningObject) O).noSidesTop == 1) {

						((OpeningObject) O).py4 = ((OpeningObject) O).py4c = ((OpeningObject) O).py4A = ((OpeningObject) O).myParent.leftPart.startYBA;

						((OpeningObject) O).py3 = ((OpeningObject) O).py3c = ((OpeningObject) O).py3A = rightM.y4;

						((OpeningObject) O).right.endY = ((OpeningObject) O).rightPart.endYC = ((OpeningObject) O).py3;

						((OpeningObject) O).right.endYA = ((OpeningObject) O).rightPart.endYA = ((OpeningObject) O).py3;

						((OpeningObject) O).bot1.startY = ((OpeningObject) O).bot1.startYA = ((OpeningObject) O).bot1Part.startYC = ((OpeningObject) O).bot1Part.startYA = ((OpeningObject) O).py3;

						((OpeningObject) O).bot1.endY = ((OpeningObject) O).bot1Part.endYC = ((OpeningObject) O).bot1.endYA = ((OpeningObject) O).bot1Part.endYA = ((OpeningObject) O).py4;
					} else if (((OpeningObject) O).noSidesTop == 2) {
						((OpeningObject) O).py5 = ((OpeningObject) O).py5c = ((OpeningObject) O).py5A = ((OpeningObject) O).myParent.leftPart.startYBA;

						((OpeningObject) O).py4 = ((OpeningObject) O).py4c = ((OpeningObject) O).py4A = rightM.y4;

						((OpeningObject) O).right.endY = ((OpeningObject) O).rightPart.endYC = ((OpeningObject) O).py4;

						((OpeningObject) O).right.endYA = ((OpeningObject) O).rightPart.endYA = ((OpeningObject) O).py4;

						((OpeningObject) O).bot1.startY = ((OpeningObject) O).bot1.startYA = ((OpeningObject) O).bot1Part.startYC = ((OpeningObject) O).bot1Part.startYA = ((OpeningObject) O).py4;

						((OpeningObject) O).bot1.endY = ((OpeningObject) O).bot1Part.endYC = ((OpeningObject) O).bot1.endYA = ((OpeningObject) O).bot1Part.endYA = ((OpeningObject) O).py5;

					} else if (((OpeningObject) O).noSidesTop == 3) {
						((OpeningObject) O).py6 = ((OpeningObject) O).py6c = ((OpeningObject) O).py6A = ((OpeningObject) O).myParent.leftPart.startYBA;

						((OpeningObject) O).py5 = ((OpeningObject) O).py5c = ((OpeningObject) O).py5A = rightM.y4;

						((OpeningObject) O).right.endY = ((OpeningObject) O).rightPart.endYC = ((OpeningObject) O).py5;

						((OpeningObject) O).right.endYA = ((OpeningObject) O).rightPart.endYA = ((OpeningObject) O).py5;

						((OpeningObject) O).bot1.startY = ((OpeningObject) O).bot1.startYA = ((OpeningObject) O).bot1Part.startYC = ((OpeningObject) O).bot1Part.startYA = ((OpeningObject) O).py5;

						((OpeningObject) O).bot1.endY = ((OpeningObject) O).bot1Part.endYC = ((OpeningObject) O).bot1.endYA = ((OpeningObject) O).bot1Part.endYA = ((OpeningObject) O).py6;
					}
				} else if (!((OpeningObject) O).botIn
						&& ((OpeningObject) O).leftIn
						&& !((OpeningObject) O).rightIn

						&& ((OpeningObject) O).myMullionLeft.rowCol == leftM.rowCol) {
					((OpeningObject) O).bCY3 = ((OpeningObject) O).myParent.rightPart.endYC;
					((OpeningObject) O).bY3 = ((OpeningObject) O).myParent.rightPart.endYBA;

					((OpeningObject) O).bCY4 = leftM.y3;
					((OpeningObject) O).bY4 = leftM.y3;

					if (((OpeningObject) O).noSidesTop == 1) {

						((OpeningObject) O).py4 = ((OpeningObject) O).py4c = ((OpeningObject) O).py4A = leftM.y3;

						((OpeningObject) O).py3 = ((OpeningObject) O).py3c = ((OpeningObject) O).py3A = ((OpeningObject) O).myParent.rightPart.endYBA;
						;

						((OpeningObject) O).right.endY = ((OpeningObject) O).rightPart.endYC = ((OpeningObject) O).py3;

						((OpeningObject) O).right.endYA = ((OpeningObject) O).rightPart.endYA = ((OpeningObject) O).py3;

						((OpeningObject) O).bot1.startY = ((OpeningObject) O).bot1.startYA = ((OpeningObject) O).bot1Part.startYC = ((OpeningObject) O).bot1Part.startYA = ((OpeningObject) O).py3;

						((OpeningObject) O).bot1.endY = ((OpeningObject) O).bot1Part.endYC = ((OpeningObject) O).bot1.endYA = ((OpeningObject) O).bot1Part.endYA = ((OpeningObject) O).py4;
					} else if (((OpeningObject) O).noSidesTop == 2) {
						((OpeningObject) O).py5 = ((OpeningObject) O).py5c = ((OpeningObject) O).py5A = leftM.y3;

						((OpeningObject) O).py4 = ((OpeningObject) O).py4c = ((OpeningObject) O).py4A = ((OpeningObject) O).myParent.rightPart.endYBA;

						((OpeningObject) O).right.endY = ((OpeningObject) O).rightPart.endYC = ((OpeningObject) O).py4;

						((OpeningObject) O).right.endYA = ((OpeningObject) O).rightPart.endYA = ((OpeningObject) O).py4;

						((OpeningObject) O).bot1.startY = ((OpeningObject) O).bot1.startYA = ((OpeningObject) O).bot1Part.startYC = ((OpeningObject) O).bot1Part.startYA = ((OpeningObject) O).py4;

						((OpeningObject) O).bot1.endY = ((OpeningObject) O).bot1Part.endYC = ((OpeningObject) O).bot1.endYA = ((OpeningObject) O).bot1Part.endYA = ((OpeningObject) O).py5;

					} else if (((OpeningObject) O).noSidesTop == 3) {
						((OpeningObject) O).py6 = ((OpeningObject) O).py6c = ((OpeningObject) O).py6A = leftM.y3;

						((OpeningObject) O).py5 = ((OpeningObject) O).py5c = ((OpeningObject) O).py5A = ((OpeningObject) O).myParent.rightPart.endYBA;

						((OpeningObject) O).right.endY = ((OpeningObject) O).rightPart.endYC = ((OpeningObject) O).py5;

						((OpeningObject) O).right.endYA = ((OpeningObject) O).rightPart.endYA = ((OpeningObject) O).py5;

						((OpeningObject) O).bot1.startY = ((OpeningObject) O).bot1.startYA = ((OpeningObject) O).bot1Part.startYC = ((OpeningObject) O).bot1Part.startYA = ((OpeningObject) O).py5;

						((OpeningObject) O).bot1.endY = ((OpeningObject) O).bot1Part.endYC = ((OpeningObject) O).bot1.endYA = ((OpeningObject) O).bot1Part.endYA = ((OpeningObject) O).py6;
					}
				} else if (!((OpeningObject) O).botIn
						&& !((OpeningObject) O).leftIn
						&& !((OpeningObject) O).rightIn) {
					((OpeningObject) O).bCY3 = ((OpeningObject) O).myParent.rightPart.endYC;
					((OpeningObject) O).bY3 = ((OpeningObject) O).myParent.rightPart.endYBA;

					((OpeningObject) O).bCY4 = ((OpeningObject) O).myParent.leftPart.startYC;

					((OpeningObject) O).bY4 = ((OpeningObject) O).myParent.leftPart.startYBA;

					if (((OpeningObject) O).noSidesTop == 1) {

						((OpeningObject) O).py4 = ((OpeningObject) O).py4c = ((OpeningObject) O).py4A = ((OpeningObject) O).myParent.leftPart.startYBA;

						((OpeningObject) O).py3 = ((OpeningObject) O).py3c = ((OpeningObject) O).py3A = ((OpeningObject) O).myParent.rightPart.endYBA;

						((OpeningObject) O).right.endY = ((OpeningObject) O).rightPart.endYC = ((OpeningObject) O).py3;

						((OpeningObject) O).right.endYA = ((OpeningObject) O).rightPart.endYA = ((OpeningObject) O).py3;

						((OpeningObject) O).bot1.startY = ((OpeningObject) O).bot1.startYA = ((OpeningObject) O).bot1Part.startYC = ((OpeningObject) O).bot1Part.startYA = ((OpeningObject) O).py3;

						((OpeningObject) O).bot1.endY = ((OpeningObject) O).bot1Part.endYC = ((OpeningObject) O).bot1.endYA = ((OpeningObject) O).bot1Part.endYA = ((OpeningObject) O).py4;
					} else if (((OpeningObject) O).noSidesTop == 2) {
						((OpeningObject) O).py5 = ((OpeningObject) O).py5c = ((OpeningObject) O).py5A = ((OpeningObject) O).myParent.leftPart.startYBA;

						((OpeningObject) O).py4 = ((OpeningObject) O).py4c = ((OpeningObject) O).py4A = ((OpeningObject) O).myParent.rightPart.endYBA;

						((OpeningObject) O).right.endY = ((OpeningObject) O).rightPart.endYC = ((OpeningObject) O).py4;

						((OpeningObject) O).right.endYA = ((OpeningObject) O).rightPart.endYA = ((OpeningObject) O).py4;

						((OpeningObject) O).bot1.startY = ((OpeningObject) O).bot1.startYA = ((OpeningObject) O).bot1Part.startYC = ((OpeningObject) O).bot1Part.startYA = ((OpeningObject) O).py4;

						((OpeningObject) O).bot1.endY = ((OpeningObject) O).bot1Part.endYC = ((OpeningObject) O).bot1.endYA = ((OpeningObject) O).bot1Part.endYA = ((OpeningObject) O).py5;

					} else if (((OpeningObject) O).noSidesTop == 3) {
						((OpeningObject) O).py6 = ((OpeningObject) O).py6c = ((OpeningObject) O).py6A = ((OpeningObject) O).myParent.leftPart.startYBA;

						((OpeningObject) O).py5 = ((OpeningObject) O).py5c = ((OpeningObject) O).py5A = ((OpeningObject) O).myParent.rightPart.endYBA;

						((OpeningObject) O).right.endY = ((OpeningObject) O).rightPart.endYC = ((OpeningObject) O).py5;

						((OpeningObject) O).right.endYA = ((OpeningObject) O).rightPart.endYA = ((OpeningObject) O).py5;

						((OpeningObject) O).bot1.startY = ((OpeningObject) O).bot1.startYA = ((OpeningObject) O).bot1Part.startYC = ((OpeningObject) O).bot1Part.startYA = ((OpeningObject) O).py5;

						((OpeningObject) O).bot1.endY = ((OpeningObject) O).bot1Part.endYC = ((OpeningObject) O).bot1.endYA = ((OpeningObject) O).bot1Part.endYA = ((OpeningObject) O).py6;
					}
				}

				((OpeningObject) O).heightPix = ((OpeningObject) O).heightPix
						+ myPart.partDimB;

				((OpeningObject) O).unGlazed = true;

				if (((OpeningObject) O).myGlassIn != null) {
					this.redoInGlass(O);
				}
				if (((OpeningObject) O).myGlassMid != null) {
					this.redoMidGlass(O, false);
				}
				if (((OpeningObject) O).myGlassOut != null) {
					this.redoOutGlass(O);
				}

				createOpenings = new CreateOpenings(this, myFrame2);
				((OpeningObject) O).gp = createOpenings
						.doGeneralPathOpening(((OpeningObject) O));

			}
			if (whichRemoved == 1) {
				((OpeningObject) O).topRemoved = true;
			} else if (whichRemoved == 2) {
				((OpeningObject) O).botRemoved = true;
			}

			openings.add(O);

		}
		createOpenings = null;
	}

	public void redoInGlass(final Object O) throws Exception {

		Object[] gb = ((OpeningObject) O).glazingBeadsIn.toArray();
		((OpeningObject) O).glazingBeadsIn.clear();

		for (Object b : gb) {
			if (((Profiles) b).position == 4) {
				((Profiles) b).endXC = ((Profiles) b).endXBA = ((OpeningObject) O).px3;
				((Profiles) b).endYC = ((Profiles) b).endYBA = ((OpeningObject) O).py3;
				((Profiles) b).endXA = ((Profiles) b).endXA = ((OpeningObject) O).px3A;
				((Profiles) b).endYA = ((Profiles) b).endYA = ((OpeningObject) O).py3A;
			} else if (((Profiles) b).position == 8) {
				((Profiles) b).startXC = ((Profiles) b).startXBA = ((OpeningObject) O).px4;
				((Profiles) b).startYC = ((Profiles) b).startYBA = ((OpeningObject) O).py4;
				((Profiles) b).startXA = ((OpeningObject) O).px4A;
				((Profiles) b).startYA = ((OpeningObject) O).py4A;
			}

			if (((Profiles) b).position != 6) {
				CreateGlazingStops createStops = new CreateGlazingStops(
						((OpeningObject) O), myFrame2);

				((Profiles) b).gp = createStops
						.doGeneralPathGlass(((Profiles) b));
				((OpeningObject) O).glazingBeadsIn.add(b);
				createStops = null;
			}
		}

		if (((OpeningObject) O).myParent.shapeID != 10
				&& !((OpeningObject) O).unGlazed) {

			CreateGlass createGlass = new CreateGlass(((OpeningObject) O),
					myFrame2);

			SUType suType = ItemFrame.getApplicationBaseRules().getSUType(
					((OpeningObject) O).myGlassIn.suID);

			((OpeningObject) O).myGlassIn = createGlass.doGlass(suType);
			createGlass = null;

			CreateGlazingStops createStops = new CreateGlazingStops(
					((OpeningObject) O), myFrame2);

			GlazingBeads glazingBeads = createStops.doBeads(suType);
			((OpeningObject) O).glazingBeadsIn = glazingBeads.partObjects;

			createStops = null;

			((OpeningObject) O).glazingBeadIn = glazingBeads;
		}
	}

	public void redoMidGlass(Object O, boolean doBeads) throws Exception {

		Object[] gb = ((OpeningObject) O).glazingBeadsMid.toArray();
		((OpeningObject) O).glazingBeadsMid.clear();

		for (Object b : gb) {

			if (((Profiles) b).position == 4) {
				((Profiles) b).endXC = ((Profiles) b).endXBA = ((OpeningObject) O).px3;
				((Profiles) b).endYC = ((Profiles) b).endYBA = ((OpeningObject) O).py3;
				((Profiles) b).endXA = ((Profiles) b).endXA = ((OpeningObject) O).px3A;
				((Profiles) b).endYA = ((Profiles) b).endYA = ((OpeningObject) O).py3A;
			} else if (((Profiles) b).position == 8) {
				((Profiles) b).startXC = ((Profiles) b).startXBA = ((OpeningObject) O).px4;
				((Profiles) b).startYC = ((Profiles) b).startYBA = ((OpeningObject) O).py4;
				((Profiles) b).startXA = ((OpeningObject) O).px4A;
				((Profiles) b).startYA = ((OpeningObject) O).py4A;
			}
			if (((Profiles) b).position != 6) {
				if (doBeads) {
					CreateGlazingStops createStops = new CreateGlazingStops(
							((OpeningObject) O), myFrame2);

					((Profiles) b).gp = createStops
							.doGeneralPathGlass(((Profiles) b));
					((OpeningObject) O).glazingBeadsMid.add(b);
					createStops = null;
				}
			}
		}

		if (((OpeningObject) O).myParent.shapeID != 10
				&& !((OpeningObject) O).unGlazed) {
			CreateGlass createGlass = new CreateGlass(((OpeningObject) O),
					myFrame2);
			SUType suType = ItemFrame.getApplicationBaseRules().getSUType(
					((OpeningObject) O).myGlassMid.suID);

			((OpeningObject) O).myGlassMid = createGlass.doGlass(suType);
			createGlass = null;

			CreateGlazingStops createStops = new CreateGlazingStops(
					((OpeningObject) O), myFrame2);

			GlazingBeads glazingBeads = createStops.doBeads(suType);
			((OpeningObject) O).glazingBeadsMid = glazingBeads.partObjects;

			createStops = null;

			((OpeningObject) O).glazingBeadMid = glazingBeads;
		}
	}

	public void redoOutGlass(final Object O) throws Exception {

		Object[] gb = ((OpeningObject) O).glazingBeadsOut.toArray();
		((OpeningObject) O).glazingBeadsOut.clear();
		CreateGlazingStops createStops = null;
		CreateGlass createGlass = null;

		for (final Object b : gb) {
			if (((Profiles) b).position == 4) {
				((Profiles) b).endXC = ((Profiles) b).endXBA = ((OpeningObject) O).px3;
				((Profiles) b).endYC = ((Profiles) b).endYBA = ((OpeningObject) O).py3;
				((Profiles) b).endXA = ((Profiles) b).endXA = ((OpeningObject) O).px3A;
				((Profiles) b).endYA = ((Profiles) b).endYA = ((OpeningObject) O).py3A;
			} else if (((Profiles) b).position == 8) {
				((Profiles) b).startXC = ((Profiles) b).startXBA = ((OpeningObject) O).px4;
				((Profiles) b).startYC = ((Profiles) b).startYBA = ((OpeningObject) O).py4;
				((Profiles) b).startXA = ((OpeningObject) O).px4A;
				((Profiles) b).startYA = ((OpeningObject) O).py4A;
			}
			if (((Profiles) b).position != 6) {
				createStops = new CreateGlazingStops(((OpeningObject) O),
						myFrame2);

				((Profiles) b).gp = createStops
						.doGeneralPathGlass(((Profiles) b));
				((OpeningObject) O).glazingBeadsOut.add(b);

			}
		}

		if (((OpeningObject) O).myParent.shapeID != 10
				&& !((OpeningObject) O).unGlazed) {
			createGlass = new CreateGlass(((OpeningObject) O), myFrame2);

			SUType suType = ItemFrame.getApplicationBaseRules().getSUType(
					((OpeningObject) O).myGlassOut.suID);

			((OpeningObject) O).myGlassOut = createGlass.doGlass(suType);

			createStops = new CreateGlazingStops(((OpeningObject) O), myFrame2);

			GlazingBeads glazingBeads = createStops.doBeads(suType);

			((OpeningObject) O).glazingBeadsOut = glazingBeads.partObjects;

			((OpeningObject) O).glazingBeadOut = glazingBeads;
		}

		createGlass = null;
		createStops = null;
	}

	/**
	 * Do mullions from BkgrdOpeningObject
	 * 
	 * @param opening
	 *            , BkgrdOpeningObject
	 * @return BkgrdOpeningObject
	 */
	public BkgrdOpeningObject doMullions(BkgrdOpeningObject opening) {

		opening.myMullions.reset();
		opening.myMullionsH.reset();

		if (a_levelID == 22) {
			opening = doMullionVOLD(opening);
			opening = doMullionHOLD(opening);
		} else {
			opening = doMullionV(opening);
			opening = doMullionH(opening);
		}

		return opening;
	}

	private void setSashMullions(final Object[] leafs) {

		for (final Object S : leafs) {
			((SashLeaf) S).bOpeningObject.myMullions.reset();
			((SashLeaf) S).bOpeningObject.myMullionsH.reset();

			((SashLeaf) S).bOpeningObject.mullionObjectsV = null;
			((SashLeaf) S).bOpeningObject.mullionObjectsV = ((SashLeaf) S).bOpeningObject.mullions
					.toArray();
			((SashLeaf) S).bOpeningObject.mullions.clear();
			((SashLeaf) S).bOpeningObject.mullionObjectsH = null;
			((SashLeaf) S).bOpeningObject.mullionObjectsH = ((SashLeaf) S).bOpeningObject.mullionsH
					.toArray();
			((SashLeaf) S).bOpeningObject.mullionsH.clear();

			this.doMullionV(((SashLeaf) S).bOpeningObject);
			this.doMullionH(((SashLeaf) S).bOpeningObject);
		}
	}

	/**
	 * Do Vertical Mullions
	 * 
	 * @param opening
	 *            , BkgrdOpeningObject
	 * @return BkgrdOpeningObject
	 */
	private BkgrdOpeningObject doMullionV(BkgrdOpeningObject opening) {

		if (a_levelID == 1 && myFrame2.shapesPanel.selectedShapeLevel == 2) {

			Collection extrasVL = new ArrayList();
			Collection extrasVR = new ArrayList();

			Object[] mVs = opening.mullions.toArray();
			opening.mullions.clear();
			Object[] values = new Object[3];

			for (Object element : mVs) {

				if (!((Profiles) element).remove
						&& !((Profiles) element).isExtra) {

					values = this.checkVCNeighbors((Profiles) element,
							extrasVL, extrasVR);
					element = values[0];
				}

				// ((Profiles) element).executeRulesMethod();

				((Profiles) element).length = Math.max(
						((Profiles) element).y4al, ((Profiles) element).y3cl)
						- Math.min(((Profiles) element).y1al,
								((Profiles) element).y2cl);

				((Profiles) element).lengthM = (int) (new BigDecimal(
						((Profiles) element).length).divide(
						myFrame2.metricscale, 20, BigDecimal.ROUND_UP))
						.doubleValue();

				((Profiles) element).lengthI = (int) (new BigDecimal(
						((Profiles) element).length).divide(
						myFrame2.imperialscale, 20, BigDecimal.ROUND_UP))
						.doubleValue();

				((Profiles) element).options.clear();
				((Profiles) element)
						.executeRulesMethod("shapeobejct.addMullionV.1900");

				((Profiles) element).bom.clear();
				((Profiles) element).clearBomForProfile();

				// element = myFrame2.executePartRules.executePartRules(null,
				// null,
				// ((Profiles) element), ((Profiles) element).a_assemblyLevel,
				// true, true,
				// "shapeobject.domullionV 1906", true);

				if (!((Profiles) element).isExtra) {

					opening.mullions.add(element);
				}

			}

			mVs = opening.mullions.toArray();
			if (mVs.length > 0) {
				extrasVL = (Collection) values[1];
				extrasVR = (Collection) values[2];
				Object[] myExtraVLs = extrasVL.toArray();
				Object[] myExtraVRs = extrasVR.toArray();
				extrasVL.clear();
				extrasVR.clear();

				if (myExtraVLs.length > 0) {

					for (Object vl : myExtraVLs) {

						Profiles myNewCV = (Profiles) ((Profiles) vl)
								.cloneProfile((Profiles) vl);

						for (Object vr : myExtraVRs) {
							if (((Profiles) vl).startPos == ((Profiles) vr).startPos
									&& ((Profiles) vl).endPos == ((Profiles) vr).endPos) {

								myNewCV.y1 = myNewCV.y1a = myNewCV.y1b = myNewCV.y1al = myNewCV.y1a3 = myNewCV.y2 = myNewCV.y2a = myNewCV.y2cl = myNewCV.y2a3 = myNewCV.y2b = myNewCV.centerYs = myNewCV.ycs = Math
										.max(((Profiles) vl).y1,
												((Profiles) vr).y1);

								myNewCV.y4 = myNewCV.y4a = myNewCV.y4al = myNewCV.y4a3 = myNewCV.y4b = myNewCV.yce = myNewCV.y3 = myNewCV.y3a = myNewCV.y3cl = myNewCV.y3a3 = myNewCV.y3b = myNewCV.centerYe = Math
										.min(((Profiles) vl).y4,
												((Profiles) vr).y4);

								myNewCV.length = Math.max(
										Math.max(myNewCV.y4, myNewCV.y3),
										myNewCV.yce)
										- Math.min(Math.min(myNewCV.y1,
												myNewCV.y2), myNewCV.ycs);
								myNewCV.isExtra = true;
							}

						}

						opening.mullions.add(myNewCV);
					}
				}
				if (myExtraVRs.length > 0) {
					for (Object vr : myExtraVRs) {
						Profiles myNewCV = (Profiles) ((Profiles) vr)
								.cloneProfile((Profiles) vr);

						for (final Object vl : myExtraVLs) {
							if (((Profiles) vr).startPos == ((Profiles) vl).startPos
									&& ((Profiles) vr).endPos == ((Profiles) vl).endPos) {

								myNewCV.y1 = myNewCV.y1a = myNewCV.y1b = myNewCV.y1al = myNewCV.y1a3 = myNewCV.y2 = myNewCV.y2a = myNewCV.y2cl = myNewCV.y2a3 = myNewCV.y2b = myNewCV.centerYs = myNewCV.ycs = Math
										.max(((Profiles) vl).y1,
												((Profiles) vr).y1);

								myNewCV.y4 = myNewCV.y4a = myNewCV.y4al = myNewCV.y4a3 = myNewCV.y4b = myNewCV.yce = myNewCV.y3 = myNewCV.y3a = myNewCV.y3cl = myNewCV.y3a3 = myNewCV.y3b = myNewCV.centerYe = Math
										.min(((Profiles) vl).y4,
												((Profiles) vr).y4);

								myNewCV.length = Math.max(
										Math.max(myNewCV.y4, myNewCV.y3),
										myNewCV.yce)
										- Math.min(Math.min(myNewCV.y1,
												myNewCV.y2), myNewCV.ycs);
								myNewCV.isExtra = true;
							}

						}

						opening.mullions.add(myNewCV);
					}
				}
				myExtraVLs = null;
				myExtraVRs = null;
			}

		}

		Object[] mVs = opening.mullions.toArray();
		opening.mullions.clear();
		PartsNotching partsNotching = null;

		for (final Object element : mVs) {
			if (((Profiles) element).isValid && !((Profiles) element).remove
					&& (((Profiles) element).x1al != ((Profiles) element).x2cl)) {

				if (a_levelID == 1) {

				}

				partsNotching = new PartsNotching();
				final Polygon m = new Polygon();

				m.addPoint((int) ((Profiles) element).x1al,
						(int) ((Profiles) element).y1a);

				if (((Profiles) element).notches.size() > 0
						&& ((Profiles) element).cOrM != 7
						&& ((Profiles) element).cOrM != 1) {
					((Profiles) element).myNothcesLT = partsNotching
							.getLNotches(((Profiles) element).notches);

					if (((Profiles) element).myNothcesLT != null) {
						Object[] myLeftNotches = ((Profiles) element).myNothcesLT
								.toArray();

						for (Object elementN : myLeftNotches) {

							if (((PartsNotching) elementN).nothchType == 3
									&& ((PartsNotching) elementN).x7 > 0
									&& ((PartsNotching) elementN).y7 > 0
									&& ((PartsNotching) elementN).x6 > 0
									&& ((PartsNotching) elementN).y6 > 0
									&& ((PartsNotching) elementN).x5 > 0
									&& ((PartsNotching) elementN).y5 > 0
									&& ((PartsNotching) elementN).xcenter > 0
									&& ((PartsNotching) elementN).ycenter > 0
									&& ((PartsNotching) elementN).x3 > 0
									&& ((PartsNotching) elementN).y3 > 0
									&& ((PartsNotching) elementN).x2 > 0
									&& ((PartsNotching) elementN).y2 > 0
									&& ((PartsNotching) elementN).x1 > 0
									&& ((PartsNotching) elementN).y1 > 0
									&& ((PartsNotching) elementN).y1 > ((Profiles) element).y1a
									&& ((PartsNotching) elementN).y1 < ((Profiles) element).y4a) {
								m.addPoint((int) ((PartsNotching) elementN).x1,
										(int) ((PartsNotching) elementN).y1);
								m.addPoint((int) ((PartsNotching) elementN).x2,
										(int) ((PartsNotching) elementN).y2);
								m.addPoint((int) ((PartsNotching) elementN).x3,
										(int) ((PartsNotching) elementN).y3);
								m.addPoint(
										(int) ((PartsNotching) elementN).xcenter,
										(int) ((PartsNotching) elementN).ycenter);
								m.addPoint((int) ((PartsNotching) elementN).x5,
										(int) ((PartsNotching) elementN).y5);
								m.addPoint((int) ((PartsNotching) elementN).x6,
										(int) ((PartsNotching) elementN).y6);
								m.addPoint((int) ((PartsNotching) elementN).x7,
										(int) ((PartsNotching) elementN).y7);
							} else if (((PartsNotching) elementN).nothchType == 1
									&& ((PartsNotching) elementN).x7 > 0
									&& ((PartsNotching) elementN).y7 > 0
									&& ((PartsNotching) elementN).x6 > 0
									&& ((PartsNotching) elementN).y6 > 0
									&& ((PartsNotching) elementN).x5 > 0
									&& ((PartsNotching) elementN).y5 > 0
									&& ((PartsNotching) elementN).xcenter > 0
									&& ((PartsNotching) elementN).ycenter > 0
									&& ((PartsNotching) elementN).x3 > 0
									&& ((PartsNotching) elementN).y3 > 0
									&& ((PartsNotching) elementN).x2 > 0
									&& ((PartsNotching) elementN).y2 > 0
									&& ((PartsNotching) elementN).x1 > 0
									&& ((PartsNotching) elementN).y1 > 0
									&& ((PartsNotching) elementN).y1 > ((Profiles) element).y1a
									&& ((PartsNotching) elementN).y1 < ((Profiles) element).y4a) {

								m.addPoint((int) ((PartsNotching) elementN).x1,
										(int) ((PartsNotching) elementN).y1);

								m.addPoint(
										(int) ((PartsNotching) elementN).xcenter,
										(int) ((PartsNotching) elementN).ycenter);

								m.addPoint((int) ((PartsNotching) elementN).x7,
										(int) ((PartsNotching) elementN).y7);
							}
						}

					}
				}

				m.addPoint((int) ((Profiles) element).x4al,
						(int) ((Profiles) element).y4a);
				if (((Profiles) element).endTypeRB == 2
						&& ((Profiles) element).partLeft) {
					final double xp = this.intersectX(
					//
							((Profiles) element).x4al, //
							((Profiles) element).y4a, //
							((Profiles) element).x4al + 300, //
							((Profiles) element).y4a, //

							((Profiles) element).x1, //
							((Profiles) element).y1, //
							((Profiles) element).x4, //
							((Profiles) element).y4 //
							);
					final double yp = this.intersectY(
					//
							((Profiles) element).x4al, //
							((Profiles) element).y4a, //
							((Profiles) element).x4al + 300, //
							((Profiles) element).y4a, //

							((Profiles) element).x1, //
							((Profiles) element).y1, //
							((Profiles) element).x4, //
							((Profiles) element).y4 //
							);
					m.addPoint((int) xp, (int) yp);
				}
				if (((Profiles) element).endTypeRB == 1
						&& ((Profiles) element).cOrM == 2) {

				} else {
					m.addPoint((int) ((Profiles) element).x4,
							(int) ((Profiles) element).y4b);
				}
				m.addPoint((int) ((Profiles) element).centerXe,
						(int) ((Profiles) element).yce);

				if (((Profiles) element).endTypeRB == 1
						&& ((Profiles) element).cOrM == 2) {

				} else {
					m.addPoint((int) ((Profiles) element).x3,
							(int) ((Profiles) element).y3b);
				}

				if (((Profiles) element).endTypeRB == 2
						&& ((Profiles) element).partRight) {
					double xp = this.intersectX(
					//
							((Profiles) element).x3cl, //
							((Profiles) element).y3a, //
							((Profiles) element).x3cl + 300, //
							((Profiles) element).y3a, //

							((Profiles) element).x2, //
							((Profiles) element).y2, //
							((Profiles) element).x3, //
							((Profiles) element).y3 //
							);
					double yp = this.intersectY(
					//
							((Profiles) element).x3cl, //
							((Profiles) element).y3a, //
							((Profiles) element).x3cl + 300, //
							((Profiles) element).y3a, //

							((Profiles) element).x2, //
							((Profiles) element).y2, //
							((Profiles) element).x3, //
							((Profiles) element).y3 //
							);
					m.addPoint((int) xp, (int) yp);
				}

				m.addPoint((int) ((Profiles) element).x3cl,
						(int) ((Profiles) element).y3a);

				if (((Profiles) element).notches.size() > 0
						&& ((Profiles) element).cOrM != 7
						&& ((Profiles) element).cOrM != 1) {
					((Profiles) element).myNothcesRB = partsNotching
							.getRNotches(((Profiles) element).notches);
					if (((Profiles) element).myNothcesRB != null) {
						Object[] myRightNotches = ((Profiles) element).myNothcesRB
								.toArray();

						for (int i = myRightNotches.length - 1; i >= 0; i--) {
							if (((PartsNotching) myRightNotches[i]).nothchType == 3
									&& ((PartsNotching) myRightNotches[i]).x7 > 0
									&& ((PartsNotching) myRightNotches[i]).y7 > 0
									&& ((PartsNotching) myRightNotches[i]).x6 > 0
									&& ((PartsNotching) myRightNotches[i]).y6 > 0
									&& ((PartsNotching) myRightNotches[i]).x5 > 0
									&& ((PartsNotching) myRightNotches[i]).y5 > 0
									&& ((PartsNotching) myRightNotches[i]).xcenter > 0
									&& ((PartsNotching) myRightNotches[i]).ycenter > 0
									&& ((PartsNotching) myRightNotches[i]).x3 > 0
									&& ((PartsNotching) myRightNotches[i]).y3 > 0
									&& ((PartsNotching) myRightNotches[i]).x2 > 0
									&& ((PartsNotching) myRightNotches[i]).y2 > 0
									&& ((PartsNotching) myRightNotches[i]).x1 > 0
									&& ((PartsNotching) myRightNotches[i]).y1 > 0
									&& ((PartsNotching) myRightNotches[i]).y1 > ((Profiles) element).y1a
									&& ((PartsNotching) myRightNotches[i]).y1 < ((Profiles) element).y4a) {
								m.addPoint(
										(int) ((PartsNotching) myRightNotches[i]).x7,
										(int) ((PartsNotching) myRightNotches[i]).y7);
								m.addPoint(
										(int) ((PartsNotching) myRightNotches[i]).x6,
										(int) ((PartsNotching) myRightNotches[i]).y6);
								m.addPoint(
										(int) ((PartsNotching) myRightNotches[i]).x5,
										(int) ((PartsNotching) myRightNotches[i]).y5);
								m.addPoint(
										(int) ((PartsNotching) myRightNotches[i]).xcenter,
										(int) ((PartsNotching) myRightNotches[i]).ycenter);
								m.addPoint(
										(int) ((PartsNotching) myRightNotches[i]).x3,
										(int) ((PartsNotching) myRightNotches[i]).y3);
								m.addPoint(
										(int) ((PartsNotching) myRightNotches[i]).x2,
										(int) ((PartsNotching) myRightNotches[i]).y2);
								m.addPoint(
										(int) ((PartsNotching) myRightNotches[i]).x1,
										(int) ((PartsNotching) myRightNotches[i]).y1);
							} else if (((PartsNotching) myRightNotches[i]).nothchType == 1
									&& ((PartsNotching) myRightNotches[i]).x7 > 0
									&& ((PartsNotching) myRightNotches[i]).y7 > 0
									&& ((PartsNotching) myRightNotches[i]).x6 > 0
									&& ((PartsNotching) myRightNotches[i]).y6 > 0
									&& ((PartsNotching) myRightNotches[i]).x5 > 0
									&& ((PartsNotching) myRightNotches[i]).y5 > 0
									&& ((PartsNotching) myRightNotches[i]).xcenter > 0
									&& ((PartsNotching) myRightNotches[i]).ycenter > 0
									&& ((PartsNotching) myRightNotches[i]).x3 > 0
									&& ((PartsNotching) myRightNotches[i]).y3 > 0
									&& ((PartsNotching) myRightNotches[i]).x2 > 0
									&& ((PartsNotching) myRightNotches[i]).y2 > 0
									&& ((PartsNotching) myRightNotches[i]).x1 > 0
									&& ((PartsNotching) myRightNotches[i]).y1 > 0
									&& ((PartsNotching) myRightNotches[i]).y1 > ((Profiles) element).y1a
									&& ((PartsNotching) myRightNotches[i]).y1 < ((Profiles) element).y4a) {
								m.addPoint(
										(int) ((PartsNotching) myRightNotches[i]).x7,
										(int) ((PartsNotching) myRightNotches[i]).y7);

								m.addPoint(
										(int) ((PartsNotching) myRightNotches[i]).xcenter,
										(int) ((PartsNotching) myRightNotches[i]).ycenter);

								m.addPoint(
										(int) ((PartsNotching) myRightNotches[i]).x1,
										(int) ((PartsNotching) myRightNotches[i]).y1);
							}
						}
					}
				}

				m.addPoint((int) ((Profiles) element).x2cl,
						(int) ((Profiles) element).y2a);

				if (((Profiles) element).endTypeLT == 2) {

					double xp = this.intersectX(
					//
							((Profiles) element).x1al, //
							((Profiles) element).y1a, //
							((Profiles) element).x2cl + 300, //
							((Profiles) element).y2a, //

							((Profiles) element).x2, //
							((Profiles) element).y2, //
							((Profiles) element).x3, //
							((Profiles) element).y3 //
							);
					double yp = this.intersectY(
					//
							((Profiles) element).x1al, //
							((Profiles) element).y1a, // ((Profiles)
														// element).y2a
							((Profiles) element).x2cl + 300, //
							((Profiles) element).y2a, //

							((Profiles) element).x2, //
							((Profiles) element).y2, //
							((Profiles) element).x3, //
							((Profiles) element).y3 //
							);

					m.addPoint((int) xp, (int) yp);
				}
				if (((Profiles) element).endTypeLT == 1
						&& ((Profiles) element).cOrM == 2) {

				} else {
					m.addPoint((int) ((Profiles) element).x2,
							(int) ((Profiles) element).y2b);
				}
				m.addPoint((int) ((Profiles) element).centerXs,
						(int) ((Profiles) element).ycs);
				if (((Profiles) element).endTypeLT == 1
						&& ((Profiles) element).cOrM == 2) {

				} else {
					m.addPoint((int) ((Profiles) element).x1,
							(int) ((Profiles) element).y1b);
				}
				if (((Profiles) element).endTypeLT == 2) {
					double xp = this.intersectX(
							((Profiles) element).x1al,
							((Profiles) element).y1a,
							((Profiles) element).x2cl + 300, //
							((Profiles) element).y2a, ((Profiles) element).x1,
							((Profiles) element).y1, ((Profiles) element).x4, //
							((Profiles) element).y4);
					double yp = this.intersectY(((Profiles) element).x1al,
							((Profiles) element).y1a,
							((Profiles) element).x2cl + 300,
							((Profiles) element).y2a, ((Profiles) element).x1,
							((Profiles) element).y1, ((Profiles) element).x4,
							((Profiles) element).y4);
					m.addPoint((int) xp, (int) yp);
				}
				m.addPoint((int) ((Profiles) element).x1al,
						(int) ((Profiles) element).y1a);

				final GeneralPath polylineA = new GeneralPath();

				polylineA.moveTo((int) ((Profiles) element).x1,
						(int) ((Profiles) element).y1);

				if (((Profiles) element).notches.size() > 0
						&& ((Profiles) element).cOrM != 7
						&& ((Profiles) element).cOrM != 1) {
					((Profiles) element).myNothcesLT = partsNotching
							.getLNotches(((Profiles) element).notches);
					if (((Profiles) element).myNothcesLT != null) {
						final Object[] myLeftNotches = ((Profiles) element).myNothcesLT
								.toArray();

						for (final Object elementN : myLeftNotches) {
							if (((PartsNotching) elementN).x7 > 0
									&& ((PartsNotching) elementN).y7 > 0
									&& ((PartsNotching) elementN).x6 > 0
									&& ((PartsNotching) elementN).y6 > 0
									&& ((PartsNotching) elementN).x5 > 0
									&& ((PartsNotching) elementN).y5 > 0
									&& ((PartsNotching) elementN).xcenter > 0
									&& ((PartsNotching) elementN).ycenter > 0
									&& ((PartsNotching) elementN).x3 > 0
									&& ((PartsNotching) elementN).y3 > 0
									&& ((PartsNotching) elementN).x2 > 0
									&& ((PartsNotching) elementN).y2 > 0
									&& ((PartsNotching) elementN).x1 > 0
									&& ((PartsNotching) elementN).y1 > 0
									&& ((PartsNotching) elementN).y1 > ((Profiles) element).y1a
									&& ((PartsNotching) elementN).y1 < ((Profiles) element).y4a) {

								polylineA.lineTo(
										(int) ((PartsNotching) elementN).x3,
										(int) ((PartsNotching) elementN).y3);
								polylineA
										.lineTo((int) ((PartsNotching) elementN).xcenter,
												(int) ((PartsNotching) elementN).ycenter);
								polylineA.lineTo(
										(int) ((PartsNotching) elementN).x5,
										(int) ((PartsNotching) elementN).y5);
							}

						}

					}
				}
				polylineA.lineTo((int) ((Profiles) element).x4,
						(int) ((Profiles) element).y4);

				GeneralPath polylineC = new GeneralPath();

				polylineC.moveTo((int) ((Profiles) element).x2,
						(int) ((Profiles) element).y2);

				if (((Profiles) element).notches.size() > 0
						&& ((Profiles) element).cOrM != 7
						&& ((Profiles) element).cOrM != 1) {
					((Profiles) element).myNothcesRB = partsNotching
							.getRNotches(((Profiles) element).notches);
					if (((Profiles) element).myNothcesRB != null) {
						Object[] myLeftNotches = ((Profiles) element).myNothcesRB
								.toArray();

						for (Object elementN : myLeftNotches) {
							if (((PartsNotching) elementN).x7 > 0
									&& ((PartsNotching) elementN).y7 > 0
									&& ((PartsNotching) elementN).x6 > 0
									&& ((PartsNotching) elementN).y6 > 0
									&& ((PartsNotching) elementN).x5 > 0
									&& ((PartsNotching) elementN).y5 > 0
									&& ((PartsNotching) elementN).xcenter > 0
									&& ((PartsNotching) elementN).ycenter > 0
									&& ((PartsNotching) elementN).x3 > 0
									&& ((PartsNotching) elementN).y3 > 0
									&& ((PartsNotching) elementN).x2 > 0
									&& ((PartsNotching) elementN).y2 > 0
									&& ((PartsNotching) elementN).x1 > 0
									&& ((PartsNotching) elementN).y1 > 0
									&& ((PartsNotching) elementN).y1 > ((Profiles) element).y1a
									&& ((PartsNotching) elementN).y1 < ((Profiles) element).y4a) {

								polylineC.lineTo(
										(int) ((PartsNotching) elementN).x3,
										(int) ((PartsNotching) elementN).y3);
								polylineC
										.lineTo((int) ((PartsNotching) elementN).xcenter,
												(int) ((PartsNotching) elementN).ycenter);
								polylineC.lineTo(
										(int) ((PartsNotching) elementN).x5,
										(int) ((PartsNotching) elementN).y5);
							}

						}

					}
				}

				polylineC.lineTo((int) ((Profiles) element).x3,
						(int) ((Profiles) element).y3);

				opening.myMullions.append(m, false);
				// }
				((Profiles) element).poly = m;
				((Profiles) element).gp = opening.myMullions;

				// ((Profiles) element).rgb_B = 255;
				// ((Profiles) element).rgb_G = 255;
				// ((Profiles) element).rgb_R = 255;
				//
				// ((Profiles) element).rgb_Bt = ((Profiles) element).rgb_B;
				// ((Profiles) element).rgb_Gt = ((Profiles) element).rgb_G;
				// ((Profiles) element).rgb_Rt = ((Profiles) element).rgb_R;

			}
			((Profiles) element).setMullionColor();
			opening.mullions.add(element);
		}
		partsNotching = null;
		return opening;
	}

	public Object[] checkVCNeighbors(final Profiles cv,
			final Collection extrasVL, final Collection extrasVR) {

		final Object[] ops = this.openings.toArray();

		double sY1 = cv.y1;
		double sY2 = cv.y2;

		double sY4 = cv.y4;
		double sY3 = cv.y3;

		boolean sy1t = false;
		boolean sy2t = false;
		boolean sy3b = false;
		boolean sy4b = false;

		final Object[] values = new Object[3];

		for (final Object o : ops) {
			if (((OpeningObject) o).endCol == cv.rowCol
					&& ((OpeningObject) o).startRow <= cv.startPos
					&& ((OpeningObject) o).endRow <= cv.endPos
					|| ((OpeningObject) o).endCol == cv.rowCol
					&& ((OpeningObject) o).shapeID == 10) {
				if (((OpeningObject) o).startRow == 1) {
					sY1 = ((OpeningObject) o).bY2;
				} else if (((OpeningObject) o).startRow > 1
						&& sY1 == ((OpeningObject) o).highestY) {
					sY1 = ((OpeningObject) o).bY2;
				}
				if (((OpeningObject) o).lean2 == 1
						|| ((OpeningObject) o).lean2 == 3
						|| ((OpeningObject) o).lean3 == 2
						|| ((OpeningObject) o).lean3 == 3
						|| ((OpeningObject) o).lean == 1
						|| ((OpeningObject) o).lean == 3) {
					sY1 = ((OpeningObject) o).lowestY;
					if (((OpeningObject) o).botIn) {
						sY1 = ((OpeningObject) o).lowestY
								+ ((OpeningObject) o).myMullionBot.thickness;
					}
					if (((OpeningObject) o).shapeID != 1
							&& (((OpeningObject) o).lean2 == 1 || ((OpeningObject) o).lean2 == 3)) {

						Profiles myNewCV = (Profiles) cv.cloneProfile(cv);

						myNewCV.y1 = myNewCV.y1a = myNewCV.ycs = myNewCV.y1b = myNewCV.y1al = myNewCV.y1a3 = myNewCV.y2 = myNewCV.y2a = myNewCV.y2cl = myNewCV.y2a3 = myNewCV.y2b = myNewCV.centerYs = ((OpeningObject) o).bY2;

						myNewCV.y4 = myNewCV.y4a = myNewCV.y4al = myNewCV.y4a3 = myNewCV.y4b = myNewCV.yce = myNewCV.y3 = myNewCV.y3a = myNewCV.y3cl = myNewCV.y3a3 = myNewCV.y3b = myNewCV.centerYe = ((OpeningObject) o).bY3;

						myNewCV.length = Math.max(
								Math.max(myNewCV.y4, myNewCV.y3), myNewCV.yce)
								- Math.min(Math.min(myNewCV.y1, myNewCV.y2),
										myNewCV.ycs);

						myNewCV.startPos = myNewCV.endPos = ((OpeningObject) o).endRow;

						myNewCV.isExtra = true;

						myNewCV.options.clear();
						myNewCV.executeRulesMethod("shapeobejct.checkVCNeighbors.2381");
						myNewCV.bom.clear();
						myNewCV.clearBomForProfile();

						// myNewCV = (Profiles)
						// myFrame2.executePartRules.executePartRules(null,
						// null,
						// myNewCV, myNewCV.a_assemblyLevel, true, true,
						// "shapeObject.checkVCNeighbors 2386", true);

						extrasVL.add(myNewCV);
					}
				}
				if (((OpeningObject) o).shapeID == 10) {
					sY1 = ((OpeningObject) o).lowestY;
					if (((OpeningObject) o).botIn) {
						sY1 = ((OpeningObject) o).lowestY
								+ ((OpeningObject) o).myMullionBot.thickness;
					}
				}

			}
		}
		for (final Object o : ops) {
			if (((OpeningObject) o).startCol == cv.rowCol + 1
					&& ((OpeningObject) o).startRow == cv.startPos
					&& ((OpeningObject) o).endRow <= cv.endPos
					|| ((OpeningObject) o).startCol == cv.rowCol + 1
					&& ((OpeningObject) o).shapeID == 10) {
				if (((OpeningObject) o).startRow == 1) {
					sY2 = ((OpeningObject) o).startingY;
				} else if (((OpeningObject) o).startRow > 1
						&& sY2 == ((OpeningObject) o).highestY
								- ((OpeningObject) o).myMullionTop.thickness) {
					sY2 = ((OpeningObject) o).startingY;
				}

				if (((OpeningObject) o).lean4 == 2
						|| ((OpeningObject) o).lean4 == 3
						|| ((OpeningObject) o).lean3 == 2
						|| ((OpeningObject) o).lean3 == 3
						|| ((OpeningObject) o).lean == 2

						|| ((OpeningObject) o).lean == 3) {
					sY2 = ((OpeningObject) o).lowestY;
					if (((OpeningObject) o).botIn) {
						sY2 = ((OpeningObject) o).lowestY
								+ ((OpeningObject) o).myMullionBot.thickness;
					}
					if (((OpeningObject) o).shapeID != 1
							&& (((OpeningObject) o).lean4 == 1 || ((OpeningObject) o).lean4 == 3)) {

						Profiles myNewCV = (Profiles) cv.cloneProfile(cv);

						myNewCV.y1 = myNewCV.y1a = myNewCV.ycs = myNewCV.y1b = myNewCV.y1al = myNewCV.y1a3 = myNewCV.y2 = myNewCV.y2a = myNewCV.y2cl = myNewCV.y2a3 = myNewCV.y2b = myNewCV.centerYs = ((OpeningObject) o).startingY;

						myNewCV.y4 = myNewCV.y4a = myNewCV.y4al = myNewCV.y4a3 = myNewCV.y4b = myNewCV.yce = myNewCV.y3 = myNewCV.y3a = myNewCV.y3cl = myNewCV.y3a3 = myNewCV.y3b = myNewCV.centerYe = ((OpeningObject) o).bY4;

						myNewCV.length = Math.max(
								Math.max(myNewCV.y4, myNewCV.y3), myNewCV.yce)
								- Math.min(Math.min(myNewCV.y1, myNewCV.y2),
										myNewCV.ycs);

						myNewCV.startPos = myNewCV.endPos = ((OpeningObject) o).endRow;

						myNewCV.isExtra = true;

						myNewCV.executeRulesMethod("shapeobejct.checkVCNeighbors.2435");
						myNewCV.bom.clear();
						myNewCV.clearBomForProfile();

						// myNewCV = (Profiles)
						// myFrame2.executePartRules.executePartRules(null,
						// null,
						// myNewCV, myNewCV.a_assemblyLevel, true, true,
						// "shapeobject.checkneighbors 2448", true);

						extrasVR.add(myNewCV);
					}
				}
				// break;
				if (((OpeningObject) o).shapeID == 10) {
					sY2 = ((OpeningObject) o).lowestY;
					if (((OpeningObject) o).botIn) {
						sY2 = ((OpeningObject) o).lowestY
								+ ((OpeningObject) o).myMullionBot.thickness;
					}
				}
			}

		}
		for (final Object o : ops) {
			if (((OpeningObject) o).endCol == cv.rowCol
					&& ((OpeningObject) o).startRow >= cv.startPos
					&& ((OpeningObject) o).endRow == cv.endPos) {
				if (((OpeningObject) o).endRow == ((OpeningObject) o).myParent.yRows) {
					sY4 = ((OpeningObject) o).bY3;
				} else if (((OpeningObject) o).endRow < ((OpeningObject) o).myParent.yRows
						&& sY4 == ((OpeningObject) o).lowestY) {
					sY4 = ((OpeningObject) o).bY3;
				}

				if ((((OpeningObject) o).lean2 == 1
						|| ((OpeningObject) o).lean2 == 3
						|| ((OpeningObject) o).lean3 == 2
						|| ((OpeningObject) o).lean3 == 3
						|| ((OpeningObject) o).lean == 1 || ((OpeningObject) o).lean == 3)
						&& cv.endPos > cv.startPos) {
					if (((OpeningObject) o).topIn) {
						sY4 = ((OpeningObject) o).highestY
								- ((OpeningObject) o).myMullionTop.thickness;
					} else {
						sY4 = ((OpeningObject) o).highestY;
					}
					if (((OpeningObject) o).shapeID != 1
							&& (((OpeningObject) o).lean2 == 2 || ((OpeningObject) o).lean2 == 3)) {

						Profiles myNewCV = (Profiles) cv.cloneProfile(cv);

						myNewCV.y1 = myNewCV.y1a = myNewCV.ycs = myNewCV.y1b = myNewCV.y1al = myNewCV.y1a3 = myNewCV.y2 = myNewCV.y2a = myNewCV.y2cl = myNewCV.y2a3 = myNewCV.y2b = myNewCV.centerYs = ((OpeningObject) o).bY2;

						myNewCV.y4 = myNewCV.y4a = myNewCV.y4al = myNewCV.y4a3 = myNewCV.y4b = myNewCV.yce = myNewCV.y3 = myNewCV.y3a = myNewCV.y3cl = myNewCV.y3a3 = myNewCV.y3b = myNewCV.centerYe = ((OpeningObject) o).bY3;

						myNewCV.length = Math.max(
								Math.max(myNewCV.y4, myNewCV.y3), myNewCV.yce)
								- Math.min(Math.min(myNewCV.y1, myNewCV.y2),
										myNewCV.ycs);

						myNewCV.startPos = myNewCV.endPos = ((OpeningObject) o).endRow;

						myNewCV.isExtra = true;

						myNewCV.executeRulesMethod("shapeobejct.checkVCNeighbors.2489");
						myNewCV.bom.clear();
						myNewCV.clearBomForProfile();

						// myNewCV = (Profiles)
						// myFrame2.executePartRules.executePartRules(null,
						// null,
						// myNewCV, myNewCV.a_assemblyLevel, true, true,
						// "shapeobject.checkVGneigbors.2494", true);

						extrasVL.add(myNewCV);
					}

				} else if (cv.endPos == cv.startPos) {
					sY4 = ((OpeningObject) o).bY3;
				}
				if (((OpeningObject) o).shapeID == 10) {
					sY4 = ((OpeningObject) o).highestY;
					if (((OpeningObject) o).topIn) {
						sY4 = ((OpeningObject) o).highestY
								- ((OpeningObject) o).myMullionTop.thickness;
					}
				}
			}
		}
		for (final Object o : ops) {
			if (((OpeningObject) o).startCol == cv.rowCol + 1
					&& ((OpeningObject) o).startRow >= cv.startPos
					&& ((OpeningObject) o).endRow == cv.endPos) {
				if (((OpeningObject) o).endRow == ((OpeningObject) o).myParent.yRows) {
					sY3 = ((OpeningObject) o).bY4;
				} else if (((OpeningObject) o).endRow < ((OpeningObject) o).myParent.yRows
						&& sY3 == ((OpeningObject) o).lowestY) {
					sY3 = ((OpeningObject) o).bY4;
				}

				if ((((OpeningObject) o).lean4 == 1
						|| ((OpeningObject) o).lean4 == 3
						|| ((OpeningObject) o).lean3 == 1
						|| ((OpeningObject) o).lean3 == 3
						|| ((OpeningObject) o).lean == 2 || ((OpeningObject) o).lean == 3)
						&& cv.endPos > cv.startPos) {
					if (((OpeningObject) o).topIn) {
						sY3 = ((OpeningObject) o).highestY
								- ((OpeningObject) o).myMullionTop.thickness;
					} else {
						sY3 = ((OpeningObject) o).highestY;
					}
					if (((OpeningObject) o).shapeID != 1
							&& (((OpeningObject) o).lean4 == 1 || ((OpeningObject) o).lean4 == 3)) {

						Profiles myNewCV = (Profiles) cv.cloneProfile(cv);

						myNewCV.y1 = myNewCV.y1a = myNewCV.ycs = myNewCV.y1b = myNewCV.y1al = myNewCV.y1a3 = myNewCV.y2 = myNewCV.y2a = myNewCV.y2cl = myNewCV.y2a3 = myNewCV.y2b = myNewCV.centerYs = ((OpeningObject) o).startingY;

						myNewCV.y4 = myNewCV.y4a = myNewCV.y4al = myNewCV.y4a3 = myNewCV.y4b = myNewCV.yce = myNewCV.y3 = myNewCV.y3a = myNewCV.y3cl = myNewCV.y3a3 = myNewCV.y3b = myNewCV.centerYe = ((OpeningObject) o).bY4;

						myNewCV.length = Math.max(
								Math.max(myNewCV.y4, myNewCV.y3), myNewCV.yce)
								- Math.min(Math.min(myNewCV.y1, myNewCV.y2),
										myNewCV.ycs);

						myNewCV.startPos = myNewCV.endPos = ((OpeningObject) o).endRow;

						myNewCV.isExtra = true;

						myNewCV.executeRulesMethod("shapeobejct.checkVCNeighbors.2544");
						myNewCV.bom.clear();
						myNewCV.clearBomForProfile();

						// myNewCV = (Profiles)
						// myFrame2.executePartRules.executePartRules(null,
						// null,
						// myNewCV, myNewCV.a_assemblyLevel, true, true,
						// "shapeobject.checkVGneigbors.2549", true);

						extrasVR.add(myNewCV);
					}
				} else if (cv.endPos == cv.startPos) {
					sY3 = ((OpeningObject) o).bY4;
				}
				if (((OpeningObject) o).shapeID == 10) {
					sY3 = ((OpeningObject) o).highestY;
					if (((OpeningObject) o).topIn) {
						sY3 = ((OpeningObject) o).highestY
								- ((OpeningObject) o).myMullionTop.thickness;
					}
				}
			}

		}

		if (sY1 > sY4 || sY1 > sY3 || sY2 > sY3 || sY2 > sY4) {
			sY2 = sY3 = sY4 = Math.max(sY1, sY2);
		}

		cv.y1 = cv.y1a = cv.y1al = cv.y1a3 = cv.y1b = cv.ycs = Math.max(sY1,
				sY2);
		cv.y2 = cv.y2a = cv.y2cl = cv.y2a3 = cv.y2b = Math.max(sY1, sY2);

		cv.y4 = cv.y4a = cv.y4al = cv.y4a3 = cv.y4b = cv.yce = Math.min(sY3,
				sY4);
		cv.y3 = cv.y3a = cv.y3cl = cv.y3a3 = cv.y3b = Math.min(sY3, sY4);

		cv.length = Math.max(Math.max(cv.y4, cv.y3), cv.yce)
				- Math.min(Math.min(cv.y1, cv.y2), cv.ycs);

		if (cv.length <= 0.5) {
			cv.isValid = false;
		} else {
			cv.isValid = true;
		}

		values[0] = cv;
		values[1] = extrasVL;
		values[2] = extrasVR;

		return values;
	}

	public Object[] checkHCNeighbors(final Profiles cv,
			final Collection extrasVT, final Collection extrasVB) {

		final Object[] ops = this.openings.toArray();
		double sX1 = cv.x1;
		double sX2 = cv.x2;

		double sX4 = cv.x4;
		double sX3 = cv.x3;

		boolean noShape = false;
		final Object[] values = new Object[3];

		final double deltaX1X2 = Math.abs(cv.x2 - cv.x1);
		final double deltaX3X4 = Math.abs(cv.x3 - cv.x4);

		for (final Object o : ops) {
			if (((OpeningObject) o).endRow == cv.rowCol
					&& ((OpeningObject) o).startCol == cv.startPos
					&& ((OpeningObject) o).endCol <= cv.endPos) {

				// sX2 = ((OpeningObject) o).bX4;

				if (((OpeningObject) o).startCol > 1
						&& sX2 == Math.min(((OpeningObject) o).startingX,
								((OpeningObject) o).bX4)) {
					sX2 = ((OpeningObject) o).bX4;
				}
				if (((OpeningObject) o).lean2 == 1
						|| ((OpeningObject) o).lean2 == 3
						|| ((OpeningObject) o).lean3 == 2
						|| ((OpeningObject) o).lean3 == 3
						|| ((OpeningObject) o).lean4 == 2
						|| ((OpeningObject) o).lean4 == 3) {
					sX2 = Math.max(((OpeningObject) o).bX3,
							((OpeningObject) o).bX2);

					if (((OpeningObject) o).rightIn) {
						sX2 = sX2
								+ ((OpeningObject) o).myMullionRight.thickness;
					}

					if (((OpeningObject) o).shapeID != 1
							&& (((OpeningObject) o).lean3 == 2 || ((OpeningObject) o).lean3 == 3)) {

						final Profiles myNewCV = (Profiles) cv.cloneProfile(cv);

						if (((OpeningObject) o).noSidesBot == 1) {
							myNewCV.x1 = myNewCV.x1a = myNewCV.x1al = myNewCV.x1a3 = myNewCV.x1b = myNewCV.xcs = myNewCV.centerXs = myNewCV.x2 = myNewCV.x2a = myNewCV.x2cl = myNewCV.x2a3 = myNewCV.x2b = ((OpeningObject) o).bot1Part.endXC;

							myNewCV.x4 = myNewCV.x4a = myNewCV.x4al = myNewCV.x4a3 = myNewCV.x4b = myNewCV.xce = myNewCV.x3 = myNewCV.x3a = myNewCV.x3cl = myNewCV.x3a3 = myNewCV.x3b = myNewCV.centerXe = ((OpeningObject) o).bot1Part.startXC;

						} else if (((OpeningObject) o).noSidesBot == 2
								&& ((OpeningObject) o).lean3 == 1) {
							myNewCV.x1 = myNewCV.x1a = myNewCV.x1al = myNewCV.x1a3 = myNewCV.x1b = myNewCV.xcs = myNewCV.centerXs = myNewCV.x2 = myNewCV.x2a = myNewCV.x2cl = myNewCV.x2a3 = myNewCV.x2b = ((OpeningObject) o).bot1Part.endXC;

							myNewCV.x4 = myNewCV.x4a = myNewCV.x4al = myNewCV.x4a3 = myNewCV.x4b = myNewCV.xce = myNewCV.x3 = myNewCV.x3a = myNewCV.x3cl = myNewCV.x3a3 = myNewCV.x3b = myNewCV.centerXe = ((OpeningObject) o).bot1Part.startXC;
						} else if (((OpeningObject) o).noSidesBot == 2
								&& ((OpeningObject) o).lean3 == 2) {
							myNewCV.x1 = myNewCV.x1a = myNewCV.x1al = myNewCV.x1a3 = myNewCV.x1b = myNewCV.xcs = myNewCV.centerXs = myNewCV.x2 = myNewCV.x2a = myNewCV.x2cl = myNewCV.x2a3 = myNewCV.x2b = ((OpeningObject) o).bot2Part.endXC;

							myNewCV.x4 = myNewCV.x4a = myNewCV.x4al = myNewCV.x4a3 = myNewCV.x4b = myNewCV.xce = myNewCV.x3 = myNewCV.x3a = myNewCV.x3cl = myNewCV.x3a3 = myNewCV.x3b = myNewCV.centerXe = ((OpeningObject) o).bot2Part.startXC;

						} else if (((OpeningObject) o).noSidesBot == 2
								&& ((OpeningObject) o).lean3 == 3) {
							myNewCV.x1 = myNewCV.x1a = myNewCV.x1al = myNewCV.x1a3 = myNewCV.x1b = myNewCV.xcs = myNewCV.centerXs = myNewCV.x2 = myNewCV.x2a = myNewCV.x2cl = myNewCV.x2a3 = myNewCV.x2b = ((OpeningObject) o).bot3Part.endXC;

							myNewCV.x4 = myNewCV.x4a = myNewCV.x4al = myNewCV.x4a3 = myNewCV.x4b = myNewCV.xce = myNewCV.x3 = myNewCV.x3a = myNewCV.x3cl = myNewCV.x3a3 = myNewCV.x3b = myNewCV.centerXe = ((OpeningObject) o).bot3Part.startXC;
						}

						myNewCV.length = Math.max(
								Math.max(myNewCV.x4, myNewCV.x3), myNewCV.xce)
								- Math.min(Math.min(myNewCV.x1, myNewCV.x2),
										myNewCV.xcs);

						myNewCV.startPos = myNewCV.endPos = ((OpeningObject) o).endCol;

						myNewCV.isExtra = true;

						extrasVT.add(myNewCV);
					}
				}

				if (((OpeningObject) o).shapeID == 10) {
					noShape = true;
				}
			}

		}

		for (final Object o : ops) {
			if (((OpeningObject) o).startRow == cv.rowCol + 1
					&& ((OpeningObject) o).startCol == cv.startPos
					&& ((OpeningObject) o).endCol <= cv.endPos) {
				// if(((OpeningObject) o).startCol==1) {
				// sX1 = ((OpeningObject) o).startingX;
				// }else
				if (((OpeningObject) o).startCol > 1
						&& sX1 == Math.min(((OpeningObject) o).startingX,
								((OpeningObject) o).bX4)) {
					sX1 = ((OpeningObject) o).bX4;
				}
				if (((OpeningObject) o).lean2 == 2
						|| ((OpeningObject) o).lean2 == 3
						|| ((OpeningObject) o).lean4 == 1
						|| ((OpeningObject) o).lean4 == 3
						|| ((OpeningObject) o).lean == 1
						|| ((OpeningObject) o).lean == 3) {
					sX1 = Math.max(((OpeningObject) o).bX3,
							((OpeningObject) o).bX2);

					if (((OpeningObject) o).rightIn) {
						sX1 = sX1
								+ ((OpeningObject) o).myMullionRight.thickness;
					}

					if (((OpeningObject) o).shapeID != 1
							&& (((OpeningObject) o).lean == 1 || ((OpeningObject) o).lean == 3)) {

						final Profiles myNewCV = (Profiles) cv.cloneProfile(cv);

						if (((OpeningObject) o).noSidesTop == 1) {
							myNewCV.x1 = myNewCV.x1a = myNewCV.x1al = myNewCV.x1a3 = myNewCV.x1b = myNewCV.xcs = myNewCV.centerXs = myNewCV.x2 = myNewCV.x2a = myNewCV.x2cl = myNewCV.x2a3 = myNewCV.x2b = ((OpeningObject) o).top1Part.startXC;

							myNewCV.x4 = myNewCV.x4a = myNewCV.x4al = myNewCV.x4a3 = myNewCV.x4b = myNewCV.xce = myNewCV.x3 = myNewCV.x3a = myNewCV.x3cl = myNewCV.x3a3 = myNewCV.x3b = myNewCV.centerXe = ((OpeningObject) o).top1Part.endXC;

						} else if (((OpeningObject) o).noSidesTop == 2
								&& ((OpeningObject) o).lean == 1) {

							myNewCV.x1 = myNewCV.x1a = myNewCV.x1al = myNewCV.x1a3 = myNewCV.x1b = myNewCV.xcs = myNewCV.centerXs = myNewCV.x2 = myNewCV.x2a = myNewCV.x2cl = myNewCV.x2a3 = myNewCV.x2b = ((OpeningObject) o).top1Part.startXC;

							myNewCV.x4 = myNewCV.x4a = myNewCV.x4al = myNewCV.x4a3 = myNewCV.x4b = myNewCV.xce = myNewCV.x3 = myNewCV.x3a = myNewCV.x3cl = myNewCV.x3a3 = myNewCV.x3b = myNewCV.centerXe = ((OpeningObject) o).top1Part.endXC;

						} else if (((OpeningObject) o).noSidesTop == 3) {
							myNewCV.x1 = myNewCV.x1a = myNewCV.x1al = myNewCV.x1a3 = myNewCV.x1b = myNewCV.xcs = myNewCV.centerXs = myNewCV.x2 = myNewCV.x2a = myNewCV.x2cl = myNewCV.x2a3 = myNewCV.x2b = ((OpeningObject) o).top3Part.startXC;

							myNewCV.x4 = myNewCV.x4a = myNewCV.x4al = myNewCV.x4a3 = myNewCV.x4b = myNewCV.xce = myNewCV.x3 = myNewCV.x3a = myNewCV.x3cl = myNewCV.x3a3 = myNewCV.x3b = myNewCV.centerXe = ((OpeningObject) o).top3Part.endXC;
						}

						myNewCV.length = Math.max(
								Math.max(myNewCV.x4, myNewCV.x3), myNewCV.xce)
								- Math.min(Math.min(myNewCV.x1, myNewCV.x2),
										myNewCV.xcs);

						myNewCV.startPos = myNewCV.endPos = ((OpeningObject) o).endCol;

						myNewCV.isExtra = true;

						extrasVB.add(myNewCV);
					}

				}
				if (((OpeningObject) o).shapeID == 10) {
					noShape = true;
				}

			}

		}

		for (final Object o : ops) {
			if (((OpeningObject) o).endRow == cv.rowCol
					&& ((OpeningObject) o).startCol >= cv.startPos
					&& ((OpeningObject) o).endCol == cv.endPos) {
				// sX3 = ((OpeningObject) o).bX3;

				if (((OpeningObject) o).lean2 == 1
						|| ((OpeningObject) o).lean2 == 3
						|| ((OpeningObject) o).lean4 == 2
						|| ((OpeningObject) o).lean4 == 3
						|| ((OpeningObject) o).lean3 == 2
						|| ((OpeningObject) o).lean3 == 3) {

					sX3 = ((OpeningObject) o).bX3;

					if (((OpeningObject) o).rightIn) {
						sX3 = sX3
								+ ((OpeningObject) o).myMullionRight.thickness;
					}

				}

				if (((OpeningObject) o).shapeID == 10) {
					noShape = true;
				}

			}
		}
		for (final Object o : ops) {
			if (((OpeningObject) o).startRow == cv.rowCol + 1
					&& ((OpeningObject) o).startCol >= cv.startPos
					&& ((OpeningObject) o).endCol == cv.endPos) {

				// sX4 = ((OpeningObject) o).bX2;

				if (((OpeningObject) o).lean2 == 2
						|| ((OpeningObject) o).lean2 == 3
						|| ((OpeningObject) o).lean4 == 1
						|| ((OpeningObject) o).lean4 == 3
						|| ((OpeningObject) o).lean == 1
						|| ((OpeningObject) o).lean == 3) {

					sX4 = ((OpeningObject) o).bX3;

					if (((OpeningObject) o).rightIn) {
						sX4 = sX4
								+ ((OpeningObject) o).myMullionRight.thickness;
					}

				}

				if (((OpeningObject) o).shapeID == 10) {
					noShape = true;
				}
			}

		}

		if (sX1 >= sX4 || sX2 >= sX3) {
			if (sX2 >= sX3) {
				sX1 = sX2;
				sX3 = sX4;
			}
			if (sX1 >= sX4) {
				sX2 = sX1;
				sX4 = sX3;
			}

		}

		final double dX1X2 = Math.abs(sX1 - sX2);
		final double dX3X4 = Math.abs(sX3 - sX4);

		if (dX1X2 == deltaX1X2) {

		} else {
			if (sX2 != sX1) {
				sX2 = sX1 = Math.max(sX2, sX1);
			}
			cv.x1 = cv.x1a = cv.x1al = cv.x1a3 = cv.x1b = sX1;
			cv.xcs = Math.max(sX1, sX2);
			cv.x2 = cv.x2a = cv.x2cl = cv.x2a3 = cv.x2b = Math.max(sX1, sX2);
		}

		if (dX3X4 == deltaX3X4) {

		} else {
			if (sX3 != sX4) {
				sX3 = sX4 = Math.max(sX3, sX4);
			}
			cv.x4 = cv.x4a = cv.x4al = cv.x4a3 = cv.x4b = cv.xce = Math.max(
					sX3, sX4);
			cv.x3 = cv.x3a = cv.x3cl = cv.x3a3 = cv.x3b = Math.max(sX3, sX4);

		}
		cv.length = Math.max(Math.max(cv.x4, cv.x3), cv.xce)
				- Math.min(Math.min(cv.x1, cv.x2), cv.xcs);

		if (cv.length <= 0.5) {
			cv.isValid = false;
		} else {
			cv.isValid = true;
		}
		if (noShape) {
			cv.isValid = false;
		}
		values[0] = cv;
		values[1] = extrasVT;
		values[2] = extrasVB;

		return values;
	}

	private BkgrdOpeningObject doMullionVOLD(BkgrdOpeningObject opening) {

		Object[] mVs = opening.mullions.toArray();
		opening.mullions.clear();
		PartsNotching partsNotching = null;

		for (Object element : mVs) {

			if (((Profiles) element).isValid && !((Profiles) element).remove) {

				partsNotching = new PartsNotching();
				Polygon m = new Polygon();
				m.addPoint((int) ((Profiles) element).x1al,
						(int) ((Profiles) element).y1al);

				if (((Profiles) element).notches.size() > 0
						&& ((Profiles) element).cOrM != 7) {
					((Profiles) element).myNothcesLT = partsNotching
							.getLNotches(((Profiles) element).notches);

					if (((Profiles) element).myNothcesLT != null) {

						Object[] myLeftNotches = ((Profiles) element).myNothcesLT
								.toArray();

						for (Object elementN : myLeftNotches) {

							if (((PartsNotching) elementN).nothchType == 3) {

								m.addPoint((int) ((PartsNotching) elementN).x1,
										(int) ((PartsNotching) elementN).y1);
								m.addPoint((int) ((PartsNotching) elementN).x2,
										(int) ((PartsNotching) elementN).y2);
								m.addPoint((int) ((PartsNotching) elementN).x3,
										(int) ((PartsNotching) elementN).y3);
								m.addPoint(
										(int) ((PartsNotching) elementN).xcenter,
										(int) ((PartsNotching) elementN).ycenter);
								m.addPoint((int) ((PartsNotching) elementN).x5,
										(int) ((PartsNotching) elementN).y5);
								m.addPoint((int) ((PartsNotching) elementN).x6,
										(int) ((PartsNotching) elementN).y6);
								m.addPoint((int) ((PartsNotching) elementN).x7,
										(int) ((PartsNotching) elementN).y7);

							} else if (((PartsNotching) elementN).nothchType == 1) {

								m.addPoint((int) ((PartsNotching) elementN).x1,
										(int) ((PartsNotching) elementN).y1);
								m.addPoint(
										(int) ((PartsNotching) elementN).xcenter,
										(int) ((PartsNotching) elementN).ycenter);
								m.addPoint((int) ((PartsNotching) elementN).x7,
										(int) ((PartsNotching) elementN).y7);
							}
						}
					}
				}

				m.addPoint((int) ((Profiles) element).x4al,
						(int) ((Profiles) element).y4al);

				if (((Profiles) element).endTypeRB == 2
						&& ((Profiles) element).partLeft) {

					double xp = this.intersectX(
							((Profiles) element).x4al,
							((Profiles) element).y4al,
							((Profiles) element).x4al + 300, //
							((Profiles) element).y4al, ((Profiles) element).x1,
							((Profiles) element).y1, ((Profiles) element).x4, //
							((Profiles) element).y4);

					double yp = this.intersectY(
							((Profiles) element).x4al,
							((Profiles) element).y4al,
							((Profiles) element).x4al + 300, //
							((Profiles) element).y4al, ((Profiles) element).x1,
							((Profiles) element).y1, ((Profiles) element).x4, //
							((Profiles) element).y4);

					m.addPoint((int) xp, (int) yp);
				}
				m.addPoint((int) ((Profiles) element).x4,
						(int) ((Profiles) element).y4);
				m.addPoint((int) ((Profiles) element).centerXe,
						(int) ((Profiles) element).centerYe);
				m.addPoint((int) ((Profiles) element).x3,
						(int) ((Profiles) element).y3);

				if (((Profiles) element).endTypeRB == 2
						&& ((Profiles) element).partRight) {

					double xp = this.intersectX(
							((Profiles) element).x3cl,
							((Profiles) element).y3cl,
							((Profiles) element).x3cl + 300, //
							((Profiles) element).y3cl, ((Profiles) element).x2,
							((Profiles) element).y2, ((Profiles) element).x3, //
							((Profiles) element).y3);

					double yp = this.intersectY(
							((Profiles) element).x3cl,
							((Profiles) element).y3cl,
							((Profiles) element).x3cl + 300, //
							((Profiles) element).y3cl, ((Profiles) element).x2,
							((Profiles) element).y2, ((Profiles) element).x3, //
							((Profiles) element).y3);

					m.addPoint((int) xp, (int) yp);
				}

				m.addPoint((int) ((Profiles) element).x3cl,
						(int) ((Profiles) element).y3cl);

				if (((Profiles) element).notches.size() > 0
						&& ((Profiles) element).cOrM != 7) {
					((Profiles) element).myNothcesRB = partsNotching
							.getRNotches(((Profiles) element).notches);

					if (((Profiles) element).myNothcesRB != null) {
						Object[] myRightNotches = ((Profiles) element).myNothcesRB
								.toArray();

						for (int i = myRightNotches.length - 1; i >= 0; i--) {
							if (((PartsNotching) myRightNotches[i]).nothchType == 3) {
								m.addPoint(
										(int) ((PartsNotching) myRightNotches[i]).x7,
										(int) ((PartsNotching) myRightNotches[i]).y7);
								m.addPoint(
										(int) ((PartsNotching) myRightNotches[i]).x6,
										(int) ((PartsNotching) myRightNotches[i]).y6);
								m.addPoint(
										(int) ((PartsNotching) myRightNotches[i]).x5,
										(int) ((PartsNotching) myRightNotches[i]).y5);
								m.addPoint(
										(int) ((PartsNotching) myRightNotches[i]).xcenter,
										(int) ((PartsNotching) myRightNotches[i]).ycenter);
								m.addPoint(
										(int) ((PartsNotching) myRightNotches[i]).x3,
										(int) ((PartsNotching) myRightNotches[i]).y3);
								m.addPoint(
										(int) ((PartsNotching) myRightNotches[i]).x2,
										(int) ((PartsNotching) myRightNotches[i]).y2);
								m.addPoint(
										(int) ((PartsNotching) myRightNotches[i]).x1,
										(int) ((PartsNotching) myRightNotches[i]).y1);
							} else if (((PartsNotching) myRightNotches[i]).nothchType == 1) {
								m.addPoint(
										(int) ((PartsNotching) myRightNotches[i]).x7,
										(int) ((PartsNotching) myRightNotches[i]).y7);
								m.addPoint(
										(int) ((PartsNotching) myRightNotches[i]).xcenter,
										(int) ((PartsNotching) myRightNotches[i]).ycenter);
								m.addPoint(
										(int) ((PartsNotching) myRightNotches[i]).x1,
										(int) ((PartsNotching) myRightNotches[i]).y1);
							}
						}
					}
				}

				m.addPoint((int) ((Profiles) element).x2cl,
						(int) ((Profiles) element).y2cl);

				if (((Profiles) element).endTypeLT == 2) {

					double xp = this.intersectX(
							((Profiles) element).x1al,
							((Profiles) element).y1al,
							((Profiles) element).x2cl, //
							((Profiles) element).y2cl, ((Profiles) element).x2,
							((Profiles) element).y2, ((Profiles) element).x3, //
							((Profiles) element).y3);
					double yp = this.intersectY(
							((Profiles) element).x1al,
							((Profiles) element).y1al,
							((Profiles) element).x2cl, //
							((Profiles) element).y2cl, ((Profiles) element).x2,
							((Profiles) element).y2, ((Profiles) element).x3, //
							((Profiles) element).y3 //
							);
					m.addPoint((int) xp, (int) yp);
				}
				m.addPoint((int) ((Profiles) element).x2,
						(int) ((Profiles) element).y2);
				m.addPoint((int) ((Profiles) element).centerXs,
						(int) ((Profiles) element).centerYs);
				m.addPoint((int) ((Profiles) element).x1,
						(int) ((Profiles) element).y1);

				if (((Profiles) element).endTypeLT == 2) {

					double xp = this.intersectX(
							((Profiles) element).x1al,
							((Profiles) element).y1al,
							((Profiles) element).x2cl, //
							((Profiles) element).y2cl, ((Profiles) element).x1,
							((Profiles) element).y1, ((Profiles) element).x4, //
							((Profiles) element).y4);
					double yp = this.intersectY(
							((Profiles) element).x1al,
							((Profiles) element).y1al,
							((Profiles) element).x2cl, //
							((Profiles) element).y2cl, ((Profiles) element).x1,
							((Profiles) element).y1, ((Profiles) element).x4, //
							((Profiles) element).y4);
					m.addPoint((int) xp, (int) yp);
				}

				m.addPoint((int) ((Profiles) element).x1al,
						(int) ((Profiles) element).y1al);

				GeneralPath polylineA = new GeneralPath();
				polylineA.moveTo((int) ((Profiles) element).x1,
						(int) ((Profiles) element).y1);

				if (((Profiles) element).notches.size() > 0
						&& ((Profiles) element).cOrM != 7) {
					((Profiles) element).myNothcesLT = partsNotching
							.getLNotches(((Profiles) element).notches);

					if (((Profiles) element).myNothcesLT != null) {
						Object[] myLeftNotches = ((Profiles) element).myNothcesLT
								.toArray();

						for (Object elementN : myLeftNotches) {

							polylineA.lineTo(
									(int) ((PartsNotching) elementN).x3,
									(int) ((PartsNotching) elementN).y3);
							polylineA.lineTo(
									(int) ((PartsNotching) elementN).xcenter,
									(int) ((PartsNotching) elementN).ycenter);
							polylineA.lineTo(
									(int) ((PartsNotching) elementN).x5,
									(int) ((PartsNotching) elementN).y5);
						}
					}
				}

				polylineA.lineTo((int) ((Profiles) element).x4,
						(int) ((Profiles) element).y4);

				GeneralPath polylineC = new GeneralPath();
				polylineC.moveTo((int) ((Profiles) element).x2,
						(int) ((Profiles) element).y2);

				if (((Profiles) element).notches.size() > 0
						&& ((Profiles) element).cOrM != 7) {

					((Profiles) element).myNothcesRB = partsNotching
							.getRNotches(((Profiles) element).notches);
					if (((Profiles) element).myNothcesRB != null) {

						Object[] myLeftNotches = ((Profiles) element).myNothcesRB
								.toArray();

						for (Object elementN : myLeftNotches) {

							polylineC.lineTo(
									(int) ((PartsNotching) elementN).x3,
									(int) ((PartsNotching) elementN).y3);
							polylineC.lineTo(
									(int) ((PartsNotching) elementN).xcenter,
									(int) ((PartsNotching) elementN).ycenter);
							polylineC.lineTo(
									(int) ((PartsNotching) elementN).x5,
									(int) ((PartsNotching) elementN).y5);

						}

					}
				}

				polylineC.lineTo((int) ((Profiles) element).x3,
						(int) ((Profiles) element).y3);
				opening.myMullions.append(m, false);

				((Profiles) element).poly = m;
				((Profiles) element).gp = opening.myMullions;

				// ((Profiles) element).rgb_B = 255;
				// ((Profiles) element).rgb_G = 255;
				// ((Profiles) element).rgb_R = 255;
				// ((Profiles) element).rgb_Bt = ((Profiles) element).rgb_B;
				// ((Profiles) element).rgb_Gt = ((Profiles) element).rgb_G;
				// ((Profiles) element).rgb_Rt = ((Profiles) element).rgb_R;

			}
			// ((Profiles) element).setMullionColor();
			opening.mullions.add(element);
		}

		partsNotching = null;

		return opening;
	}

	private BkgrdOpeningObject doMullionH(final BkgrdOpeningObject opening) {

		if (a_levelID == 1 && myFrame2.shapesPanel.selectedShapeLevel == 2) {

			Collection extrasVT = new ArrayList();
			Collection extrasVB = new ArrayList();

			Object[] mVs = opening.mullionsH.toArray();
			opening.mullionsH.clear();
			Object[] values = new Object[3];

			for (Object element : mVs) {
				if (!((Profiles) element).remove
						&& !((Profiles) element).isExtra) {

					values = this.checkHCNeighbors((Profiles) element,
							extrasVT, extrasVB);
					element = values[0];
				}

				((Profiles) element).length = Math.max(
						((Profiles) element).x4al, ((Profiles) element).x3cl)
						- Math.min(((Profiles) element).x1al,
								((Profiles) element).x2cl);

				((Profiles) element).lengthM = (int) (new BigDecimal(
						((Profiles) element).length).divide(
						myFrame2.metricscale, 20, BigDecimal.ROUND_UP))
						.doubleValue();

				((Profiles) element).lengthI = (int) (new BigDecimal(
						((Profiles) element).length).divide(
						myFrame2.imperialscale, 20, BigDecimal.ROUND_UP))
						.doubleValue();

				((Profiles) element).bom.clear();
				((Profiles) element).clearBomForProfile();

				// element = myFrame2.executePartRules.executePartRules(null,
				// null,
				// ((Profiles) element), ((Profiles) element).a_assemblyLevel,
				// true, true,
				// "shapeobject.domullionH.3090", true);

				if (!((Profiles) element).isExtra) {
					opening.mullionsH.add(element);
				}
			}

			mVs = opening.mullionsH.toArray();
			if (mVs.length > 0) {
				extrasVT = (Collection) values[1];
				extrasVB = (Collection) values[2];
				Object[] myExtraVTs = extrasVT.toArray();
				Object[] myExtraVBs = extrasVB.toArray();
				extrasVT.clear();
				extrasVB.clear();
				if (myExtraVTs.length > 0) {
					for (final Object vl : myExtraVTs) {
						final Profiles myNewCV = (Profiles) ((Profiles) vl)
								.cloneProfile((Profiles) vl);

						for (final Object vr : myExtraVBs) {
							if (((Profiles) vl).startPos == ((Profiles) vr).startPos
									&& ((Profiles) vl).endPos == ((Profiles) vr).endPos) {

								myNewCV.x1 = myNewCV.x1a = myNewCV.x1al = myNewCV.x1a3 = myNewCV.x1b = myNewCV.xcs = myNewCV.centerXs = myNewCV.x2 = myNewCV.x2a = myNewCV.x2cl = myNewCV.x2a3 = myNewCV.x2b = Math
										.max(((Profiles) vl).x1,
												((Profiles) vr).x1);

								myNewCV.x4 = myNewCV.x4a = myNewCV.x4al = myNewCV.x4a3 = myNewCV.x4b = myNewCV.xce = myNewCV.x3 = myNewCV.x3a = myNewCV.x3cl = myNewCV.x3a3 = myNewCV.x3b = myNewCV.centerXe = Math
										.min(((Profiles) vl).x4,
												((Profiles) vr).x4);

								myNewCV.length = Math.max(
										Math.max(myNewCV.x4, myNewCV.x3),
										myNewCV.xce)
										- Math.min(Math.min(myNewCV.x1,
												myNewCV.x2), myNewCV.xcs);
								myNewCV.isExtra = true;
							}

						}

						opening.mullionsH.add(myNewCV);
					}
				}
				if (myExtraVBs.length > 0) {
					for (final Object vr : myExtraVBs) {
						final Profiles myNewCV = (Profiles) ((Profiles) vr)
								.cloneProfile((Profiles) vr);

						for (final Object vl : myExtraVTs) {
							if (((Profiles) vr).startPos == ((Profiles) vl).startPos
									&& ((Profiles) vr).endPos == ((Profiles) vl).endPos) {

								myNewCV.x1 = myNewCV.x1a = myNewCV.x1al = myNewCV.x1a3 = myNewCV.x1b = myNewCV.xcs = myNewCV.centerXs = myNewCV.x2 = myNewCV.x2a = myNewCV.x2cl = myNewCV.x2a3 = myNewCV.x2b = Math
										.max(((Profiles) vl).x1,
												((Profiles) vr).x1);

								myNewCV.x4 = myNewCV.x4a = myNewCV.x4al = myNewCV.x4a3 = myNewCV.x4b = myNewCV.xce = myNewCV.x3 = myNewCV.x3a = myNewCV.x3cl = myNewCV.x3a3 = myNewCV.x3b = myNewCV.centerXe = Math
										.min(((Profiles) vl).x4,
												((Profiles) vr).x4);

								myNewCV.length = Math.max(
										Math.max(myNewCV.x4, myNewCV.x3),
										myNewCV.xce)
										- Math.min(Math.min(myNewCV.x1,
												myNewCV.x2), myNewCV.xcs);
								myNewCV.isExtra = true;
							}

						}

						opening.mullionsH.add(myNewCV);
					}
				}
				myExtraVTs = null;
				myExtraVBs = null;
			}

		}
		final Object[] mHs = opening.mullionsH.toArray();
		opening.mullionsH.clear();
		PartsNotching partsNotching = null;
		for (final Object element : mHs) {

			if (!((Profiles) element).remove) {
				partsNotching = new PartsNotching();
				if (((Profiles) element).isValid
						&& ((Profiles) element).partForm == 1) {
					final Polygon m = new Polygon();

					if (((Profiles) element).endTypeLT == 1) {
						m.addPoint((int) ((Profiles) element).x1al,
								(int) ((Profiles) element).y1al);
						m.addPoint((int) ((Profiles) element).x1,
								(int) ((Profiles) element).y1);
						m.addPoint((int) ((Profiles) element).centerXs,
								(int) ((Profiles) element).centerYs);
						m.addPoint((int) ((Profiles) element).x2,
								(int) ((Profiles) element).y2);
						m.addPoint((int) ((Profiles) element).x2cl,
								(int) ((Profiles) element).y2cl);
					} else {
						m.addPoint((int) ((Profiles) element).x1a,
								(int) ((Profiles) element).y1al);

						m.addPoint((int) ((Profiles) element).x2a,
								(int) ((Profiles) element).y2cl);
					}
					// ////
					if (((Profiles) element).notches.size() > 0
							&& ((Profiles) element).cOrM != 7
							&& ((Profiles) element).cOrM != 1) {
						((Profiles) element).myNothcesLT = partsNotching
								.getTNotches(((Profiles) element).notches);
						if (((Profiles) element).myNothcesLT != null) {
							final Object[] myLeftNotches = ((Profiles) element).myNothcesLT
									.toArray();

							for (final Object elementN : myLeftNotches) {
								if (((PartsNotching) elementN).nothchType == 3) {
									m.addPoint(
											(int) ((PartsNotching) elementN).x1,
											(int) ((PartsNotching) elementN).y1);
									m.addPoint(
											(int) ((PartsNotching) elementN).x2,
											(int) ((PartsNotching) elementN).y2);
									m.addPoint(
											(int) ((PartsNotching) elementN).x3,
											(int) ((PartsNotching) elementN).y3);
									m.addPoint(
											(int) ((PartsNotching) elementN).xcenter,
											(int) ((PartsNotching) elementN).ycenter);
									m.addPoint(
											(int) ((PartsNotching) elementN).x5,
											(int) ((PartsNotching) elementN).y5);
									m.addPoint(
											(int) ((PartsNotching) elementN).x6,
											(int) ((PartsNotching) elementN).y6);
									m.addPoint(
											(int) ((PartsNotching) elementN).x7,
											(int) ((PartsNotching) elementN).y7);
								} else if (((PartsNotching) elementN).nothchType == 1) {

									m.addPoint(
											(int) ((PartsNotching) elementN).x1,
											(int) ((PartsNotching) elementN).y1);

									m.addPoint(
											(int) ((PartsNotching) elementN).xcenter,
											(int) ((PartsNotching) elementN).ycenter);

									m.addPoint(
											(int) ((PartsNotching) elementN).x7,
											(int) ((PartsNotching) elementN).y7);
								}
							}

						}
					}
					// ///

					if (((Profiles) element).endTypeRB == 1) {
						m.addPoint((int) ((Profiles) element).x3cl,
								(int) ((Profiles) element).y3cl);
						m.addPoint((int) ((Profiles) element).x3,
								(int) ((Profiles) element).y3);
						m.addPoint((int) ((Profiles) element).centerXe,
								(int) ((Profiles) element).centerYe);
						m.addPoint((int) ((Profiles) element).x4,
								(int) ((Profiles) element).y4);
						m.addPoint((int) ((Profiles) element).x4al,
								(int) ((Profiles) element).y4al);
					} else {
						m.addPoint((int) ((Profiles) element).x3a,
								(int) ((Profiles) element).y3cl);
						m.addPoint((int) ((Profiles) element).x4a,
								(int) ((Profiles) element).y4al);
					}
					if (((Profiles) element).notches.size() > 0
							&& ((Profiles) element).cOrM != 7
							&& ((Profiles) element).cOrM != 1) {
						((Profiles) element).myNothcesRB = partsNotching
								.getBNotches(((Profiles) element).notches);
						if (((Profiles) element).myNothcesRB != null) {
							final Object[] myRightNotches = ((Profiles) element).myNothcesRB
									.toArray();

							for (int i = myRightNotches.length - 1; i >= 0; i--) {
								if (((PartsNotching) myRightNotches[i]).nothchType == 3) {
									m.addPoint(
											(int) ((PartsNotching) myRightNotches[i]).x7,
											(int) ((PartsNotching) myRightNotches[i]).y7);
									m.addPoint(
											(int) ((PartsNotching) myRightNotches[i]).x6,
											(int) ((PartsNotching) myRightNotches[i]).y6);
									m.addPoint(
											(int) ((PartsNotching) myRightNotches[i]).x5,
											(int) ((PartsNotching) myRightNotches[i]).y5);
									m.addPoint(
											(int) ((PartsNotching) myRightNotches[i]).xcenter,
											(int) ((PartsNotching) myRightNotches[i]).ycenter);
									m.addPoint(
											(int) ((PartsNotching) myRightNotches[i]).x3,
											(int) ((PartsNotching) myRightNotches[i]).y3);
									m.addPoint(
											(int) ((PartsNotching) myRightNotches[i]).x2,
											(int) ((PartsNotching) myRightNotches[i]).y2);
									m.addPoint(
											(int) ((PartsNotching) myRightNotches[i]).x1,
											(int) ((PartsNotching) myRightNotches[i]).y1);
								} else if (((PartsNotching) myRightNotches[i]).nothchType == 1) {
									m.addPoint(
											(int) ((PartsNotching) myRightNotches[i]).x7,
											(int) ((PartsNotching) myRightNotches[i]).y7);

									m.addPoint(
											(int) ((PartsNotching) myRightNotches[i]).xcenter,
											(int) ((PartsNotching) myRightNotches[i]).ycenter);

									m.addPoint(
											(int) ((PartsNotching) myRightNotches[i]).x1,
											(int) ((PartsNotching) myRightNotches[i]).y1);
								}
							}
						}
					}

					final GeneralPath polylineA = new GeneralPath();
					polylineA.moveTo((int) ((Profiles) element).x1,
							(int) ((Profiles) element).y1);

					if (((Profiles) element).notches.size() > 0
							&& ((Profiles) element).cOrM != 7
							&& ((Profiles) element).cOrM != 1) {
						((Profiles) element).myNothcesRB = partsNotching
								.getBNotches(((Profiles) element).notches);
						if (((Profiles) element).myNothcesRB != null) {
							final Object[] myLeftNotches = ((Profiles) element).myNothcesRB
									.toArray();

							for (final Object elementN : myLeftNotches) {

								polylineA.lineTo(
										(int) ((PartsNotching) elementN).x3,
										(int) ((PartsNotching) elementN).y3);

								polylineA
										.lineTo((int) ((PartsNotching) elementN).xcenter,
												(int) ((PartsNotching) elementN).ycenter);

								polylineA.lineTo(
										(int) ((PartsNotching) elementN).x5,
										(int) ((PartsNotching) elementN).y5);

							}

						}
					}
					polylineA.lineTo((int) ((Profiles) element).x4,
							(int) ((Profiles) element).y4);

					final GeneralPath polylineC = new GeneralPath();
					polylineC.moveTo((int) ((Profiles) element).x2,
							(int) ((Profiles) element).y2);

					if (((Profiles) element).notches.size() > 0
							&& ((Profiles) element).cOrM != 7
							&& ((Profiles) element).cOrM != 1) {
						((Profiles) element).myNothcesLT = partsNotching
								.getTNotches(((Profiles) element).notches);
						if (((Profiles) element).myNothcesLT != null) {
							final Object[] myLeftNotches = ((Profiles) element).myNothcesLT
									.toArray();

							for (final Object elementN : myLeftNotches) {

								polylineC.lineTo(
										(int) ((PartsNotching) elementN).x3,
										(int) ((PartsNotching) elementN).y3);

								polylineC
										.lineTo((int) ((PartsNotching) elementN).xcenter,
												(int) ((PartsNotching) elementN).ycenter);

								polylineC.lineTo(
										(int) ((PartsNotching) elementN).x5,
										(int) ((PartsNotching) elementN).y5);

							}

						}
					}
					polylineC.lineTo((int) ((Profiles) element).x3,
							(int) ((Profiles) element).y3);

					opening.myMullionsH.append(m, false);

					((Profiles) element).gp = opening.myMullionsH;
					((Profiles) element).poly = m;
					// ((Profiles) element).rgb_B = 255;
					// ((Profiles) element).rgb_G = 255;
					// ((Profiles) element).rgb_R = 255;

					((Profiles) element).rgb_Bt = ((Profiles) element).rgb_B;
					((Profiles) element).rgb_Gt = ((Profiles) element).rgb_G;
					((Profiles) element).rgb_Rt = ((Profiles) element).rgb_R;

				}
				//

				else if (((Profiles) element).partForm == 3) { // Cubic
					CubicCurve2D curve = null;
					curve = new CubicCurve2D.Double(((Profiles) element).x2cl
							+ ((Profiles) element).deltaTL,
							((Profiles) element).y2cl,
							((Profiles) element).x2cl
									+ ((Profiles) element).curveCenterTL, //
							((Profiles) element).y2cl, //
							((Profiles) element).x3cl
									- ((Profiles) element).curveCenterRB, //
							((Profiles) element).y3cl,//
							((Profiles) element).x3cl
									- ((Profiles) element).deltaRB,//
							((Profiles) element).y3cl);

					xCoordBo = null;
					yCoordBo = null;

					xCoordB.clear();
					yCoordB.clear();

					this.getPoints(curve);
					xCoordBo = xCoordB.toArray();
					yCoordBo = yCoordB.toArray();

					opening.myMullionsH.moveTo((int) ((Profiles) element).x1al,
							(int) ((Profiles) element).y1al);
					opening.myMullionsH.lineTo((int) ((Profiles) element).x1,
							(int) ((Profiles) element).y1);
					opening.myMullionsH.lineTo(
							(int) ((Profiles) element).centerXs,
							(int) ((Profiles) element).centerYs);
					opening.myMullionsH.lineTo((int) ((Profiles) element).x2,
							(int) ((Profiles) element).y2);
					opening.myMullionsH.lineTo((int) ((Profiles) element).x2cl,
							(int) ((Profiles) element).y2cl);
					opening.myMullionsH.lineTo((int) ((Profiles) element).x2cl
							+ ((Profiles) element).deltaTL,
							(int) ((Profiles) element).y2cl);
					opening.myMullionsH.curveTo((int) ((Profiles) element).x2cl
							+ ((Profiles) element).curveCenterTL, //
							(int) ((Profiles) element).y2cl, //
							(int) ((Profiles) element).x3cl
									- ((Profiles) element).curveCenterRB, //
							(int) ((Profiles) element).y3cl,//
							(int) ((Profiles) element).x3cl
									- ((Profiles) element).deltaRB,//
							(int) ((Profiles) element).y3cl);
					opening.myMullionsH.lineTo((int) ((Profiles) element).x3cl,
							(int) ((Profiles) element).y3cl);

					opening.myMullionsH.lineTo((int) ((Profiles) element).x3,
							(int) ((Profiles) element).y3);
					opening.myMullionsH.lineTo(
							(int) ((Profiles) element).centerXe,
							(int) ((Profiles) element).centerYe);
					opening.myMullionsH.lineTo((int) ((Profiles) element).x4,
							(int) ((Profiles) element).y4);
					opening.myMullionsH.lineTo((int) ((Profiles) element).x4al,
							(int) ((Profiles) element).y4al);

					opening.myMullionsH.lineTo((int) ((Profiles) element).x4al
							- ((Profiles) element).deltaRB,
							(int) ((Profiles) element).y4al);

					boolean leftHigh = true;
					if (((Profiles) element).offsetTL > ((Profiles) element).offsetRB) {
						leftHigh = false;
					}

					this.bezier(((Profiles) element).partDimC
							+ ((Profiles) element).partDimA
							+ ((Profiles) element).partDimB,
							(int) ((Profiles) element).x1al
									+ ((Profiles) element).deltaTL,
							(int) ((Profiles) element).y1al,
							(int) ((Profiles) element).x4al
									- ((Profiles) element).deltaRB,
							(int) ((Profiles) element).y4al, leftHigh);

					for (int i = xCoordBoBA.length - 10; i > 0; i--) {
						if (i > 10) {
							opening.myMullionsH.lineTo(
									((Double) xCoordBoBA[i - 1]),
									((Double) yCoordBoBA[i - 1]));
						}
					}

					opening.myMullionsH.lineTo((int) ((Profiles) element).x1al,
							(int) ((Profiles) element).y1al);
					Line2D lineA = null;

					lineA = new Line2D.Double(
							(int) ((Profiles) element).x1,
							(int) ((Profiles) element).y1,
							(int) ((Profiles) element).x1
									+ ((Profiles) element).deltaTL
									+ (((Profiles) element).x1al - ((Profiles) element).x1),
							(int) ((Profiles) element).y1);

					opening.myMullionsH.append(lineA, false);

					this.bezier(
							((Profiles) element).partDimC
									+ ((Profiles) element).partDimB,
							(int) ((Profiles) element).x1
									+ ((Profiles) element).deltaTL
									+ (((Profiles) element).x1al - ((Profiles) element).x1),
							(int) ((Profiles) element).y1,
							(int) ((Profiles) element).x4
									- ((Profiles) element).deltaRB,
							(int) ((Profiles) element).y4, leftHigh);

					for (int i = xCoordBoBA.length; i > 0; i--) {
						if (i > 2) {
							opening.myMullionsH.append(new Line2D.Double(
									((Double) xCoordBoBA[i - 1]),
									((Double) yCoordBoBA[i - 1]),
									((Double) xCoordBoBA[i - 2]),
									((Double) yCoordBoBA[i - 2])), false);
						}
					}
					Line2D lineA2 = null;
					lineA2 = new Line2D.Double(
							(int) ((Profiles) element).x4
									- ((Profiles) element).deltaRB
									- (((Profiles) element).x4 - ((Profiles) element).x4al),
							(int) ((Profiles) element).y4,
							(int) ((Profiles) element).x4,
							(int) ((Profiles) element).y4);
					opening.myMullionsH.append(lineA2, false);
					Line2D lineC = null;
					lineC = new Line2D.Double(
							(int) ((Profiles) element).x2,
							(int) ((Profiles) element).y2,
							(int) ((Profiles) element).x2
									+ ((Profiles) element).deltaTL
									+ (((Profiles) element).x2cl - ((Profiles) element).x2),
							(int) ((Profiles) element).y2);
					opening.myMullionsH.append(lineC, false);

					this.bezier(
							((Profiles) element).partDimC,
							(int) ((Profiles) element).x2
									+ ((Profiles) element).deltaTL
									+ (((Profiles) element).x2cl - ((Profiles) element).x2),
							(int) ((Profiles) element).y2,
							(int) ((Profiles) element).x3
									- ((Profiles) element).deltaRB,
							(int) ((Profiles) element).y3, leftHigh);

					for (int i = xCoordBoBA.length; i > 0; i--) {
						if (i > 2) {
							opening.myMullionsH.append(new Line2D.Double(
									((Double) xCoordBoBA[i - 1]),
									((Double) yCoordBoBA[i - 1]),
									((Double) xCoordBoBA[i - 2]),
									((Double) yCoordBoBA[i - 2])), false);
						}
					}
					Line2D lineC2 = null;
					lineC2 = new Line2D.Double(
							(int) ((Profiles) element).x3
									- ((Profiles) element).deltaRB
									- (((Profiles) element).x3 - ((Profiles) element).x3cl),
							(int) ((Profiles) element).y3,
							(int) ((Profiles) element).x3,
							(int) ((Profiles) element).y3);
					opening.myMullionsH.append(lineC2, false);

				}
				// //// Mod Cubic
				// else if (((Profiles)
				// element).partForm ==
				// 2)
				// {
				//
				// }
				// ////////// Quad
				// else if (((Profiles) element).partForm == 4)
				// {
				//
				// }
				// ////////// Arc
				else if (((Profiles) element).partForm == 2) {

					((Profiles) element).gp = this.curvePart(element, 0, false);
					((Profiles) element).curveB = this.curvePart(element, 1,
							false);
					((Profiles) element).curveBA = this.curvePart(element, 2,
							true);
					((Profiles) element).curveA = this.curvePart(element, 3,
							false);

					// ((Profiles) element).rgb_B = 255;
					// ((Profiles) element).rgb_G = 255;
					// ((Profiles) element).rgb_R = 255;
					//
					// ((Profiles) element).rgb_Bt = ((Profiles)
					// element).rgb_B;
					// ((Profiles) element).rgb_Gt = ((Profiles)
					// element).rgb_G;
					// ((Profiles) element).rgb_Rt = ((Profiles)
					// element).rgb_R;

				}
			}
			((Profiles) element).setMullionColor();
			opening.mullionsH.add(element);

		}
		partsNotching = null;
		return opening;
	}

	private BkgrdOpeningObject doMullionHOLD(BkgrdOpeningObject opening) {

		final Object[] mHs = opening.mullionsH.toArray();
		opening.mullionsH.clear();
		PartsNotching partsNotching = null;
		for (final Object element : mHs) {

			if (!((Profiles) element).remove) {
				partsNotching = new PartsNotching();
				if (((Profiles) element).isValid
						&& ((Profiles) element).partForm == 1) {
					final Polygon m = new Polygon();

					m.addPoint((int) ((Profiles) element).x1al,
							(int) ((Profiles) element).y1al);
					m.addPoint((int) ((Profiles) element).x1,
							(int) ((Profiles) element).y1);

					m.addPoint((int) ((Profiles) element).centerXs,
							(int) ((Profiles) element).centerYs);

					m.addPoint((int) ((Profiles) element).x2,
							(int) ((Profiles) element).y2);
					m.addPoint((int) ((Profiles) element).x2cl,
							(int) ((Profiles) element).y2cl);

					// ////
					if (((Profiles) element).notches.size() > 0
							&& ((Profiles) element).cOrM != 7) {
						((Profiles) element).myNothcesLT = partsNotching
								.getTNotches(((Profiles) element).notches);
						if (((Profiles) element).myNothcesLT != null) {
							final Object[] myLeftNotches = ((Profiles) element).myNothcesLT
									.toArray();

							for (final Object elementN : myLeftNotches) {
								if (((PartsNotching) elementN).nothchType == 3) {
									m.addPoint(
											(int) ((PartsNotching) elementN).x1,
											(int) ((PartsNotching) elementN).y1);
									m.addPoint(
											(int) ((PartsNotching) elementN).x2,
											(int) ((PartsNotching) elementN).y2);
									m.addPoint(
											(int) ((PartsNotching) elementN).x3,
											(int) ((PartsNotching) elementN).y3);
									m.addPoint(
											(int) ((PartsNotching) elementN).xcenter,
											(int) ((PartsNotching) elementN).ycenter);
									m.addPoint(
											(int) ((PartsNotching) elementN).x5,
											(int) ((PartsNotching) elementN).y5);
									m.addPoint(
											(int) ((PartsNotching) elementN).x6,
											(int) ((PartsNotching) elementN).y6);
									m.addPoint(
											(int) ((PartsNotching) elementN).x7,
											(int) ((PartsNotching) elementN).y7);
								} else if (((PartsNotching) elementN).nothchType == 1) {

									m.addPoint(
											(int) ((PartsNotching) elementN).x1,
											(int) ((PartsNotching) elementN).y1);

									m.addPoint(
											(int) ((PartsNotching) elementN).xcenter,
											(int) ((PartsNotching) elementN).ycenter);

									m.addPoint(
											(int) ((PartsNotching) elementN).x7,
											(int) ((PartsNotching) elementN).y7);
								}
							}

						}
					}
					// ///

					m.addPoint((int) ((Profiles) element).x3cl,
							(int) ((Profiles) element).y3cl);
					m.addPoint((int) ((Profiles) element).x3,
							(int) ((Profiles) element).y3);

					m.addPoint((int) ((Profiles) element).centerXe,
							(int) ((Profiles) element).centerYe);

					m.addPoint((int) ((Profiles) element).x4,
							(int) ((Profiles) element).y4);
					m.addPoint((int) ((Profiles) element).x4al,
							(int) ((Profiles) element).y4al);
					if (((Profiles) element).notches.size() > 0
							&& ((Profiles) element).cOrM != 7) {
						((Profiles) element).myNothcesRB = partsNotching
								.getBNotches(((Profiles) element).notches);
						if (((Profiles) element).myNothcesRB != null) {
							final Object[] myRightNotches = ((Profiles) element).myNothcesRB
									.toArray();

							for (int i = myRightNotches.length - 1; i >= 0; i--) {
								if (((PartsNotching) myRightNotches[i]).nothchType == 3) {
									m.addPoint(
											(int) ((PartsNotching) myRightNotches[i]).x7,
											(int) ((PartsNotching) myRightNotches[i]).y7);
									m.addPoint(
											(int) ((PartsNotching) myRightNotches[i]).x6,
											(int) ((PartsNotching) myRightNotches[i]).y6);
									m.addPoint(
											(int) ((PartsNotching) myRightNotches[i]).x5,
											(int) ((PartsNotching) myRightNotches[i]).y5);
									m.addPoint(
											(int) ((PartsNotching) myRightNotches[i]).xcenter,
											(int) ((PartsNotching) myRightNotches[i]).ycenter);
									m.addPoint(
											(int) ((PartsNotching) myRightNotches[i]).x3,
											(int) ((PartsNotching) myRightNotches[i]).y3);
									m.addPoint(
											(int) ((PartsNotching) myRightNotches[i]).x2,
											(int) ((PartsNotching) myRightNotches[i]).y2);
									m.addPoint(
											(int) ((PartsNotching) myRightNotches[i]).x1,
											(int) ((PartsNotching) myRightNotches[i]).y1);
								} else if (((PartsNotching) myRightNotches[i]).nothchType == 1) {
									m.addPoint(
											(int) ((PartsNotching) myRightNotches[i]).x7,
											(int) ((PartsNotching) myRightNotches[i]).y7);

									m.addPoint(
											(int) ((PartsNotching) myRightNotches[i]).xcenter,
											(int) ((PartsNotching) myRightNotches[i]).ycenter);

									m.addPoint(
											(int) ((PartsNotching) myRightNotches[i]).x1,
											(int) ((PartsNotching) myRightNotches[i]).y1);
								}
							}
						}
					}

					final GeneralPath polylineA = new GeneralPath();
					polylineA.moveTo((int) ((Profiles) element).x1,
							(int) ((Profiles) element).y1);

					if (((Profiles) element).notches.size() > 0
							&& ((Profiles) element).cOrM != 7) {
						((Profiles) element).myNothcesRB = partsNotching
								.getBNotches(((Profiles) element).notches);
						if (((Profiles) element).myNothcesRB != null) {
							final Object[] myLeftNotches = ((Profiles) element).myNothcesRB
									.toArray();

							for (final Object elementN : myLeftNotches) {

								polylineA.lineTo(
										(int) ((PartsNotching) elementN).x3,
										(int) ((PartsNotching) elementN).y3);

								polylineA
										.lineTo((int) ((PartsNotching) elementN).xcenter,
												(int) ((PartsNotching) elementN).ycenter);

								polylineA.lineTo(
										(int) ((PartsNotching) elementN).x5,
										(int) ((PartsNotching) elementN).y5);

							}

						}
					}
					polylineA.lineTo((int) ((Profiles) element).x4,
							(int) ((Profiles) element).y4);

					final GeneralPath polylineC = new GeneralPath();
					polylineC.moveTo((int) ((Profiles) element).x2,
							(int) ((Profiles) element).y2);

					if (((Profiles) element).notches.size() > 0
							&& ((Profiles) element).cOrM != 7) {
						((Profiles) element).myNothcesLT = partsNotching
								.getTNotches(((Profiles) element).notches);
						if (((Profiles) element).myNothcesLT != null) {
							final Object[] myLeftNotches = ((Profiles) element).myNothcesLT
									.toArray();

							for (final Object elementN : myLeftNotches) {

								polylineC.lineTo(
										(int) ((PartsNotching) elementN).x3,
										(int) ((PartsNotching) elementN).y3);

								polylineC
										.lineTo((int) ((PartsNotching) elementN).xcenter,
												(int) ((PartsNotching) elementN).ycenter);

								polylineC.lineTo(
										(int) ((PartsNotching) elementN).x5,
										(int) ((PartsNotching) elementN).y5);

							}

						}
					}
					polylineC.lineTo((int) ((Profiles) element).x3,
							(int) ((Profiles) element).y3);

					opening.myMullionsH.append(m, false);

					((Profiles) element).gp = opening.myMullionsH;
					((Profiles) element).poly = m;
					// ((Profiles) element).rgb_B = 255;
					// ((Profiles) element).rgb_G = 255;
					// ((Profiles) element).rgb_R = 255;
					//
					// ((Profiles) element).rgb_Bt = ((Profiles)
					// element).rgb_B;
					// ((Profiles) element).rgb_Gt = ((Profiles)
					// element).rgb_G;
					// ((Profiles) element).rgb_Rt = ((Profiles)
					// element).rgb_R;

				}
				//

				else if (((Profiles) element).partForm == 3) { // Cubic
					CubicCurve2D curve = null;
					curve = new CubicCurve2D.Double(((Profiles) element).x2cl
							+ ((Profiles) element).deltaTL,
							((Profiles) element).y2cl,
							((Profiles) element).x2cl
									+ ((Profiles) element).curveCenterTL, //
							((Profiles) element).y2cl, //
							((Profiles) element).x3cl
									- ((Profiles) element).curveCenterRB, //
							((Profiles) element).y3cl,//
							((Profiles) element).x3cl
									- ((Profiles) element).deltaRB,//
							((Profiles) element).y3cl);

					xCoordBo = null;
					yCoordBo = null;

					xCoordB.clear();
					yCoordB.clear();

					this.getPoints(curve);
					xCoordBo = xCoordB.toArray();
					yCoordBo = yCoordB.toArray();

					opening.myMullionsH.moveTo((int) ((Profiles) element).x1al,
							(int) ((Profiles) element).y1al);
					opening.myMullionsH.lineTo((int) ((Profiles) element).x1,
							(int) ((Profiles) element).y1);
					opening.myMullionsH.lineTo(
							(int) ((Profiles) element).centerXs,
							(int) ((Profiles) element).centerYs);
					opening.myMullionsH.lineTo((int) ((Profiles) element).x2,
							(int) ((Profiles) element).y2);
					opening.myMullionsH.lineTo((int) ((Profiles) element).x2cl,
							(int) ((Profiles) element).y2cl);
					opening.myMullionsH.lineTo((int) ((Profiles) element).x2cl
							+ ((Profiles) element).deltaTL,
							(int) ((Profiles) element).y2cl);
					opening.myMullionsH.curveTo((int) ((Profiles) element).x2cl
							+ ((Profiles) element).curveCenterTL, //
							(int) ((Profiles) element).y2cl, //
							(int) ((Profiles) element).x3cl
									- ((Profiles) element).curveCenterRB, //
							(int) ((Profiles) element).y3cl,//
							(int) ((Profiles) element).x3cl
									- ((Profiles) element).deltaRB,//
							(int) ((Profiles) element).y3cl);
					opening.myMullionsH.lineTo((int) ((Profiles) element).x3cl,
							(int) ((Profiles) element).y3cl);

					opening.myMullionsH.lineTo((int) ((Profiles) element).x3,
							(int) ((Profiles) element).y3);
					opening.myMullionsH.lineTo(
							(int) ((Profiles) element).centerXe,
							(int) ((Profiles) element).centerYe);
					opening.myMullionsH.lineTo((int) ((Profiles) element).x4,
							(int) ((Profiles) element).y4);
					opening.myMullionsH.lineTo((int) ((Profiles) element).x4al,
							(int) ((Profiles) element).y4al);

					opening.myMullionsH.lineTo((int) ((Profiles) element).x4al
							- ((Profiles) element).deltaRB,
							(int) ((Profiles) element).y4al);

					boolean leftHigh = true;
					if (((Profiles) element).offsetTL > ((Profiles) element).offsetRB) {
						leftHigh = false;
					}

					this.bezier(((Profiles) element).partDimC
							+ ((Profiles) element).partDimA
							+ ((Profiles) element).partDimB,
							(int) ((Profiles) element).x1al
									+ ((Profiles) element).deltaTL,
							(int) ((Profiles) element).y1al,
							(int) ((Profiles) element).x4al
									- ((Profiles) element).deltaRB,
							(int) ((Profiles) element).y4al, leftHigh);

					for (int i = xCoordBoBA.length - 10; i > 0; i--) {
						if (i > 10) {
							opening.myMullionsH.lineTo(
									((Double) xCoordBoBA[i - 1]),
									((Double) yCoordBoBA[i - 1]));
						}
					}

					opening.myMullionsH.lineTo((int) ((Profiles) element).x1al,
							(int) ((Profiles) element).y1al);
					Line2D lineA = null;

					lineA = new Line2D.Double(
							(int) ((Profiles) element).x1,
							(int) ((Profiles) element).y1,
							(int) ((Profiles) element).x1
									+ ((Profiles) element).deltaTL
									+ (((Profiles) element).x1al - ((Profiles) element).x1),
							(int) ((Profiles) element).y1);

					opening.myMullionsH.append(lineA, false);

					this.bezier(
							((Profiles) element).partDimC
									+ ((Profiles) element).partDimB,
							(int) ((Profiles) element).x1
									+ ((Profiles) element).deltaTL
									+ (((Profiles) element).x1al - ((Profiles) element).x1),
							(int) ((Profiles) element).y1,
							(int) ((Profiles) element).x4
									- ((Profiles) element).deltaRB,
							(int) ((Profiles) element).y4, leftHigh);

					for (int i = xCoordBoBA.length; i > 0; i--) {
						if (i > 2) {
							opening.myMullionsH.append(new Line2D.Double(
									((Double) xCoordBoBA[i - 1]),
									((Double) yCoordBoBA[i - 1]),
									((Double) xCoordBoBA[i - 2]),
									((Double) yCoordBoBA[i - 2])), false);
						}
					}
					Line2D lineA2 = null;
					lineA2 = new Line2D.Double(
							(int) ((Profiles) element).x4
									- ((Profiles) element).deltaRB
									- (((Profiles) element).x4 - ((Profiles) element).x4al),
							(int) ((Profiles) element).y4,
							(int) ((Profiles) element).x4,
							(int) ((Profiles) element).y4);
					opening.myMullionsH.append(lineA2, false);
					Line2D lineC = null;
					lineC = new Line2D.Double(
							(int) ((Profiles) element).x2,
							(int) ((Profiles) element).y2,
							(int) ((Profiles) element).x2
									+ ((Profiles) element).deltaTL
									+ (((Profiles) element).x2cl - ((Profiles) element).x2),
							(int) ((Profiles) element).y2);
					opening.myMullionsH.append(lineC, false);

					this.bezier(
							((Profiles) element).partDimC,
							(int) ((Profiles) element).x2
									+ ((Profiles) element).deltaTL
									+ (((Profiles) element).x2cl - ((Profiles) element).x2),
							(int) ((Profiles) element).y2,
							(int) ((Profiles) element).x3
									- ((Profiles) element).deltaRB,
							(int) ((Profiles) element).y3, leftHigh);

					for (int i = xCoordBoBA.length; i > 0; i--) {
						if (i > 2) {
							opening.myMullionsH.append(new Line2D.Double(
									((Double) xCoordBoBA[i - 1]),
									((Double) yCoordBoBA[i - 1]),
									((Double) xCoordBoBA[i - 2]),
									((Double) yCoordBoBA[i - 2])), false);
						}
					}
					Line2D lineC2 = null;
					lineC2 = new Line2D.Double(
							(int) ((Profiles) element).x3
									- ((Profiles) element).deltaRB
									- (((Profiles) element).x3 - ((Profiles) element).x3cl),
							(int) ((Profiles) element).y3,
							(int) ((Profiles) element).x3,
							(int) ((Profiles) element).y3);
					opening.myMullionsH.append(lineC2, false);

				}
				// //// Mod Cubic
				// else if (((Profiles)
				// element).partForm ==
				// 2)
				// {
				//
				// }
				// ////////// Quad
				// else if (((Profiles) element).partForm == 4)
				// {
				//
				// }
				// ////////// Arc
				else if (((Profiles) element).partForm == 2) {

					((Profiles) element).gp = this.curvePart(element, 0, false);
					((Profiles) element).curveB = this.curvePart(element, 1,
							false);
					((Profiles) element).curveBA = this.curvePart(element, 2,
							true);
					((Profiles) element).curveA = this.curvePart(element, 3,
							false);

					// ((Profiles) element).rgb_B = 255;
					// ((Profiles) element).rgb_G = 255;
					// ((Profiles) element).rgb_R = 255;
					//
					// ((Profiles) element).rgb_Bt = ((Profiles)
					// element).rgb_B;
					// ((Profiles) element).rgb_Gt = ((Profiles)
					// element).rgb_G;
					// ((Profiles) element).rgb_Rt = ((Profiles)
					// element).rgb_R;

				}
			}
			// ((Profiles) element).setMullionColor();
			opening.mullionsH.add(element);

		}
		partsNotching = null;
		return opening;
	}

	public GeneralPath curvePart(final Object P, final int type,
			final boolean doBA) {

		final GeneralPath gp = new GeneralPath();
		final GeneralPath gpB = new GeneralPath();
		final GeneralPath gpBA = new GeneralPath();
		final GeneralPath gpA = new GeneralPath();
		Line2D endR = null;
		Line2D endL = null;
		Arc2D arcB = null;
		Arc2D arcA = null;
		Arc2D arcBA = null;
		double totalThick = 0;
		if (type == 1) {
			arcB = new Arc2D.Double((int) ((Profiles) P).bkgrdStartX,
					(int) ((Profiles) P).bkgrdStartY,
					(int) ((Profiles) P).bkgrdWidth,
					(int) ((Profiles) P).bkgrdHeight,
					((Profiles) P).startAngle, ((Profiles) P).endAngle,
					Arc2D.OPEN);
			gpB.append(arcB, false);

		} else if (type == 3) {
			arcA = new Arc2D.Double((int) ((Profiles) P).bkgrdStartXA,
					(int) ((Profiles) P).bkgrdStartYA,
					(int) ((Profiles) P).bkgrdWidthA,
					(int) ((Profiles) P).bkgrdHeightA,
					((Profiles) P).startAngleA, ((Profiles) P).endAngleA,
					Arc2D.OPEN);

			gpA.append(arcA, false);
		} else if (type == 2 && doBA) {
			arcBA = new Arc2D.Double((int) ((Profiles) P).bkgrdStartXBA,
					(int) ((Profiles) P).bkgrdStartYBA,
					(int) ((Profiles) P).bkgrdWidthBA,
					(int) ((Profiles) P).bkgrdHeightBA,
					((Profiles) P).startAngleBA, ((Profiles) P).endAngleBA,
					Arc2D.OPEN);
			gpBA.append(arcBA, false);
		}
		if (type == 0) {

			if (((Profiles) P).myParent != null
					&& ((Profiles) P).myParent.a_levelID == 12) {
				totalThick = ((Profiles) P).partDimC + ((Profiles) P).partDimB
						+ ((Profiles) P).partDimA;
			} else {
				totalThick = ((Profiles) P).partDimB + ((Profiles) P).partDimA;
			}

			gp.append(this.fillArc(P, totalThick), false);
		}

		if (((Profiles) P).endTypeRB == 2) {
			endL = new Line2D.Double((int) ((Profiles) P).startXBA,
					(int) ((Profiles) P).startYBA,
					(int) ((Profiles) P).startXC, (int) ((Profiles) P).startYC);
			gpA.append(endL, false);
			gp.append(endL, false);
			gpB.append(endL, false);
			gpBA.append(endL, false);
		}
		if (((Profiles) P).endTypeLT == 2) {
			endR = new Line2D.Double((int) ((Profiles) P).endXC,
					(int) ((Profiles) P).endYC, (int) ((Profiles) P).endXBA,
					(int) ((Profiles) P).endYBA);
			gp.append(endR, false);
			gpB.append(endR, false);
			gpBA.append(endR, false);
			gpA.append(endR, false);
		}

		if (((Profiles) P).myParent != null
				&& ((Profiles) P).myParent.shapeID >= 450
				&& ((Profiles) P).myParent.shapeID <= 461
				&& ((Profiles) P).position == 1) {
			endR = new Line2D.Double((int) ((Profiles) P).endXC,
					(int) ((Profiles) P).endYC, (int) ((Profiles) P).endXA,
					(int) ((Profiles) P).endYA);

		}
		GeneralPath mygp = new GeneralPath();

		if (type == 0) {
			mygp = gp;
		}
		if (type == 1) {
			mygp = gpB;
		}
		if (type == 2) {
			mygp = gpBA;
		}
		if (type == 3) {
			mygp = gpA;
		}

		return mygp;
	}

	public GeneralPath fillArc(final Object P, final double totalThick) {

		final GeneralPath fill = new GeneralPath();

		for (double l = 0; l < totalThick; l += 0.5) {
			Arc2D.Double arcF = new Arc2D.Double(
					((Profiles) P).bkgrdStartX + l, ((Profiles) P).bkgrdStartY
							+ l, ((Profiles) P).bkgrdWidth - l - l,
					((Profiles) P).bkgrdHeight - l - l,
					((Profiles) P).startAngle, ((Profiles) P).endAngle,
					Arc2D.OPEN);
			if (((Profiles) P).x1 < ((Profiles) P).endXC
					&& ((Profiles) P).x1 > ((Profiles) P).startXC) {
				if (((Profiles) P).endTypeLT != 1
						&& ((Profiles) P).endTypeRB != 1) {

					double startAngle = ((Profiles) P).startAngle
							- (((Profiles) P).startAngle - Math
									.toDegrees(Math
											.acos((((Profiles) P).endXC - ((Profiles) P).x1)
													/ (((Profiles) P).radius1 - l))));
					double extent = ((Profiles) P).endAngle
							+ 180
							- (((Profiles) P).endAngle +

							((Profiles) P).startAngle - (((Profiles) P).startAngle - Math
									.toDegrees(Math
											.acos((((Profiles) P).endXC - ((Profiles) P).x1)
													/ (((Profiles) P).radius1 - l)))))
							- Math.toDegrees(Math
									.acos((((Profiles) P).x1 - ((Profiles) P).startXC)
											/ (((Profiles) P).radius1 - l)));
					if (Double.isNaN(startAngle)) {
						startAngle = 0;
					}
					if (Double.isNaN(extent)) {
						extent = 180;
					}
					arcF = new Arc2D.Double(((Profiles) P).bkgrdStartX + l,
							((Profiles) P).bkgrdStartY + l,
							((Profiles) P).bkgrdWidth - l - l,
							((Profiles) P).bkgrdHeight - l - l, startAngle,
							extent, Arc2D.OPEN);

				} else if (((Profiles) P).endTypeLT != 1
						&& ((Profiles) P).endTypeRB == 1) {

					double startAngle = ((Profiles) P).startAngle
							- (((Profiles) P).startAngle - Math
									.toDegrees(Math
											.acos((((Profiles) P).endXC - ((Profiles) P).x1)
													/ (((Profiles) P).radius1 - l))));
					double extent = ((Profiles) P).endAngle;

					if (Double.isNaN(startAngle)) {
						startAngle = 0;
					}
					if (Double.isNaN(extent)) {
						extent = 180;
					}
					arcF = new Arc2D.Double(((Profiles) P).bkgrdStartX + l,
							((Profiles) P).bkgrdStartY + l,
							((Profiles) P).bkgrdWidth - l - l,
							((Profiles) P).bkgrdHeight - l - l, startAngle,
							extent, Arc2D.OPEN);
				} else if (((Profiles) P).endTypeLT == 1
						&& ((Profiles) P).endTypeRB != 1) {
					double startAngle = ((Profiles) P).startAngle;
					double extent = ((Profiles) P).endAngle
							+ 180
							- (((Profiles) P).endAngle + ((Profiles) P).startAngle)
							- Math.toDegrees(Math
									.acos((((Profiles) P).x1 - ((Profiles) P).startXC)
											/ (((Profiles) P).radius1 - l)));

					if (Double.isNaN(startAngle)) {
						startAngle = 0;
					}
					if (Double.isNaN(extent)) {
						extent = 180;
					}
					arcF = new Arc2D.Double(((Profiles) P).bkgrdStartX + l,
							((Profiles) P).bkgrdStartY + l,
							((Profiles) P).bkgrdWidth - l - l,
							((Profiles) P).bkgrdHeight - l - l, startAngle,
							extent, Arc2D.OPEN);
				}
			}

			fill.append(arcF, false);

		}
		return fill;
	}

	public void doCouplersPoints() {

		Object[] VCs = bOpeningObject.mullions.toArray();

		bOpeningObject.mullions.clear();

		for (final Object element : VCs) {
			if (!((Profiles) element).finalVerify) {

			}

			bOpeningObject.mullions.add(element);
		}
		VCs = null;

		Object[] HCs = bOpeningObject.mullionsH.toArray();

		bOpeningObject.mullionsH.clear();

		for (final Object element : HCs) {
			if (!((Profiles) element).finalVerify) {
				((Profiles) element).x1a = ((Profiles) element).x1al;
				((Profiles) element).x2a = ((Profiles) element).x2cl;
				((Profiles) element).x4a = ((Profiles) element).x4al;
				((Profiles) element).x3a = ((Profiles) element).x3cl;

				((Profiles) element).y1a = ((Profiles) element).y1al;
				((Profiles) element).y2a = ((Profiles) element).y2cl;
				((Profiles) element).y4a = ((Profiles) element).y4al;
				((Profiles) element).y3a = ((Profiles) element).y3cl;
			}
			bOpeningObject.mullionsH.add(element);

		}
		HCs = null;
	}

	private BkgrdOpeningObject doCouplersShapeV() {

		final Object[] VCs = bOpeningObject.mullions.toArray();

		bOpeningObject.mullions.clear();

		for (final Object element : VCs) {
			if (myFrame2.facetUsed.frameShapeChanged) {
				((Profiles) element).recalcVCPosition();
			}

			((Profiles) element).poly = new Polygon();
			;
			((Profiles) element).gp = new GeneralPath();

			if (((Profiles) element).thickness >= 5) {
				((Profiles) element).poly.addPoint(
						(int) ((Profiles) element).x1a,
						(int) ((Profiles) element).y1a);
				((Profiles) element).poly.addPoint(
						(int) ((Profiles) element).x2a,
						(int) ((Profiles) element).y2a);
				((Profiles) element).poly.addPoint(
						(int) ((Profiles) element).x3a,
						(int) ((Profiles) element).y3a);
				((Profiles) element).poly.addPoint(
						(int) ((Profiles) element).x4a,
						(int) ((Profiles) element).y4a);
				((Profiles) element).poly.addPoint(
						(int) ((Profiles) element).x1a,
						(int) ((Profiles) element).y1a);
			} else {
				final int delta = 5 - (int) ((Profiles) element).thickness;
				((Profiles) element).poly.addPoint(
						(int) ((Profiles) element).x1a - delta,
						(int) ((Profiles) element).y1a);
				((Profiles) element).poly.addPoint(
						(int) ((Profiles) element).x2a + delta,
						(int) ((Profiles) element).y2a);
				((Profiles) element).poly.addPoint(
						(int) ((Profiles) element).x3a + delta,
						(int) ((Profiles) element).y3a);
				((Profiles) element).poly.addPoint(
						(int) ((Profiles) element).x4a - delta,
						(int) ((Profiles) element).y4a);
				((Profiles) element).poly.addPoint(
						(int) ((Profiles) element).x1a - delta,
						(int) ((Profiles) element).y1a);
			}
			((Profiles) element).gp.moveTo((int) ((Profiles) element).x1a,
					(int) ((Profiles) element).y1a);
			((Profiles) element).gp.lineTo((int) ((Profiles) element).x2a,
					(int) ((Profiles) element).y2a);
			((Profiles) element).gp.lineTo((int) ((Profiles) element).x3a,
					(int) ((Profiles) element).y3a);
			((Profiles) element).gp.lineTo((int) ((Profiles) element).x4a,
					(int) ((Profiles) element).y4a);
			((Profiles) element).gp.lineTo((int) ((Profiles) element).x1a,
					(int) ((Profiles) element).y1a);

			// ((Profiles) element).rgb_R = 255;
			// ((Profiles) element).rgb_G = 255;
			// ((Profiles) element).rgb_B = 255;

			bOpeningObject.mullions.add(element);

		}

		return bOpeningObject;

	}

	private BkgrdOpeningObject doCouplersShapeH() {

		final Object[] HCs = bOpeningObject.mullionsH.toArray();
		bOpeningObject.mullionsH.clear();
		for (final Object element : HCs) {

			((Profiles) element).poly = new Polygon();

			((Profiles) element).gp = new GeneralPath();

			if (((Profiles) element).thickness >= 5) {
				((Profiles) element).poly.addPoint(
						(int) ((Profiles) element).x1a,
						(int) ((Profiles) element).y1a);
				((Profiles) element).poly.addPoint(
						(int) ((Profiles) element).x2a,
						(int) ((Profiles) element).y2a);
				((Profiles) element).poly.addPoint(
						(int) ((Profiles) element).x3a,
						(int) ((Profiles) element).y3a);
				((Profiles) element).poly.addPoint(
						(int) ((Profiles) element).x4a,
						(int) ((Profiles) element).y4a);
				((Profiles) element).poly.addPoint(
						(int) ((Profiles) element).x1a,
						(int) ((Profiles) element).y1a);
			} else {
				final int delta = 5 - (int) ((Profiles) element).thickness;
				((Profiles) element).poly.addPoint(
						(int) ((Profiles) element).x1a,
						(int) ((Profiles) element).y1a + delta);
				((Profiles) element).poly.addPoint(
						(int) ((Profiles) element).x2a,
						(int) ((Profiles) element).y2a - delta);
				((Profiles) element).poly.addPoint(
						(int) ((Profiles) element).x3a,
						(int) ((Profiles) element).y3a - delta);
				((Profiles) element).poly.addPoint(
						(int) ((Profiles) element).x4a,
						(int) ((Profiles) element).y4a + delta);
				((Profiles) element).poly.addPoint(
						(int) ((Profiles) element).x1a,
						(int) ((Profiles) element).y1a + delta);
			}

			((Profiles) element).gp.moveTo((int) ((Profiles) element).x1a,
					(int) ((Profiles) element).y1a);
			((Profiles) element).gp.lineTo((int) ((Profiles) element).x2a,
					(int) ((Profiles) element).y2a);
			((Profiles) element).gp.lineTo((int) ((Profiles) element).x3a,
					(int) ((Profiles) element).y3a);
			((Profiles) element).gp.lineTo((int) ((Profiles) element).x4a,
					(int) ((Profiles) element).y4a);
			((Profiles) element).gp.lineTo((int) ((Profiles) element).x1a,
					(int) ((Profiles) element).y1a);
			// ((Profiles) element).rgb_R = 255;
			// ((Profiles) element).rgb_G = 255;
			// ((Profiles) element).rgb_B = 255;

			bOpeningObject.mullionsH.add(element);
		}
		return bOpeningObject;
	}

	public void setMullionVColor(final int r, final int g, final int b,
			final BkgrdOpeningObject opening) {

		opening.mullionObjectsV = null;
		opening.mullionObjectsV = opening.mullions.toArray();
		opening.mullions.clear();
		for (final Object element : opening.mullionObjectsV) {

			((Profiles) element).rgb_Bt = ((Profiles) element).rgb_B;
			((Profiles) element).rgb_Gt = ((Profiles) element).rgb_G;
			((Profiles) element).rgb_Rt = ((Profiles) element).rgb_R;
			((Profiles) element).rgb_B = b;
			((Profiles) element).rgb_G = g;
			((Profiles) element).rgb_R = r;

			opening.mullions.add(element);
		}
	}

	public void doOpenings() throws Exception {

		CreateOpenings createOpening = new CreateOpenings(this, myFrame2);
		// doMainOpening();

		createOpening.createOpenings();
		createOpening = null;
	}

	/**
	 * Create BkgrdOpeningObject
	 * 
	 * @return BkgrdOpeningObject
	 */
	public BkgrdOpeningObject doMainOpening() throws Exception {

		CreateOpenings createOpening = new CreateOpenings(this, myFrame2);
		BkgrdOpeningObject bkgrdOpening = createOpening.doMainOpening();
		createOpening = null;

		return bkgrdOpening;
	}

	public void bezier(double distance, double movetoX, double movetoY,
			double endX, double endY, boolean leftHigh) {// 1=top

		// 2
		// =
		// bot
		double xs = 0;
		double ys = 0;
		double myNewY = 0;
		double myNewX = 0;
		xCoordBA = new ArrayList();
		yCoordBA = new ArrayList();
		double lastX = -1;
		double lastY = -1;

		double slopeLine = 0;
		double slopePerp = 0;
		double thetaSlopeLine = 0;
		double deltaYS = 0;
		double deltaXS = 0;

		if (leftHigh) {

			lastY = -1;
		} else {

			lastY = 1000;
		}
		for (int i = 0; i < xCoordBo.length; i++) {
			xs = (Double) xCoordBo[i];
			ys = (Double) yCoordBo[i];// p+

			if ((Double) xCoordBo[i] <= endX) {
				if ((Double) xCoordBo[i] >= 0) {
					if (i > 0) {
						slopeLine = ((Double) xCoordBo[i - 1] - (Double) xCoordBo[i])
								/ ((Double) yCoordBo[i - 1] - (Double) yCoordBo[i]);
						slopePerp = -1 / slopeLine;
						thetaSlopeLine = Math.atan(slopePerp);
						deltaYS = distance * Math.cos(thetaSlopeLine);
						deltaXS = distance * Math.sin(thetaSlopeLine);
						myNewY = ys + deltaYS;
						myNewX = xs + deltaXS;
						if (myNewX < movetoX) {
							myNewY = movetoY;
							myNewX = movetoX;
						}
						if (myNewX > endX - 2) {
							myNewY = endY;
							myNewX = endX;
						}

					}

					if (myNewX > 0) {
						if (myNewX > lastX && myNewY > lastY && leftHigh) {
							xCoordBA.add(myNewX);
							yCoordBA.add(myNewY);
							lastX = myNewX;
							lastY = myNewY;

						} else if (myNewX > lastX && myNewY < lastY
								&& !leftHigh) {
							xCoordBA.add(myNewX);
							yCoordBA.add(myNewY);
							lastX = myNewX;
							lastY = myNewY;

						}

					}

				}

			}

		}
		xCoordBoBA = xCoordBA.toArray();
		yCoordBoBA = yCoordBA.toArray();

	}

	public double intersectX2(final double x1, final double y1,
			final double x2, final double y2, final double bx1,
			final double by1, final double bx2, final double by2) {

		double x = 0;
		final double px = x1, py = y1, rx = x2 - px, ry = y2 - py;
		final double qx = bx1, qy = by1, sx = bx2 - qx, sy = by2 - qy;

		final double det = sx * ry - sy * rx;
		if (det == 0) {
			return x;
		} else {
			final double z = (sx * (qy - py) + sy * (px - qx)) / det;
			if (z == 0 || z == 1) {
				return x; // intersection at
				// end
				// point!
			}
			x = (px + z * rx);// ,

		}
		return x;

	} // end intersection line-line

	public double intersectY2(final double x1, final double y1,
			final double x2, final double y2, final double bx1,
			final double by1, final double bx2, final double by2) {

		double y = 0;
		final double px = x1, py = y1, rx = x2 - px, ry = y2 - py;
		final double qx = bx1, qy = by1, sx = bx2 - qx, sy = by2 - qy;

		final double det = sx * ry - sy * rx;
		if (det == 0) {
			return y;
		} else {
			final double z = (sx * (qy - py) + sy * (px - qx)) / det;
			if (z == 0 || z == 1) {
				return y; // intersection at
				// end
				// point!
			}
			y = (py + z * ry);
		}
		return y;
	} // end intersection l

	public double intersectX(final double x1, final double y1, final double x2,
			final double y2, final double bx1, final double by1,
			final double bx2, final double by2) {

		double x = 0;
		final double px = x1, py = y1, rx = x2 - px, ry = y2 - py;
		final double qx = bx1, qy = by1, sx = bx2 - qx, sy = by2 - qy;

		final double det = sx * ry - sy * rx;
		if (det == 0) {
			return x;
		} else {
			final double z = (sx * (qy - py) + sy * (px - qx)) / det;
			// if (z == 0 || z == 1) {
			// return x; // intersection at end
			// point!
			// }
			x = (px + z * rx);// ,
			// (double)(py+z*ry));
		}
		return x;// , (double)(py+z*ry));

	} // end intersection line-line

	public double intersectY(final double x1, final double y1, final double x2,
			final double y2, final double bx1, final double by1,
			final double bx2, final double by2) {

		double y = 0;
		final double px = x1, py = y1, rx = x2 - px, ry = y2 - py;
		final double qx = bx1, qy = by1, sx = bx2 - qx, sy = by2 - qy;

		final double det = sx * ry - sy * rx;
		if (det == 0) {
			return y;
		} else {
			final double z = (sx * (qy - py) + sy * (px - qx)) / det;
			// if (z == 0 || z == 1) {
			// return y; // intersection at end
			// point!
			// }
			y = (py + z * ry);
		}
		return y;
	} // end intersection l

	public void getPoints(final CubicCurve2D curve) {

		final double flatness = 0.000001f;
		final PathIterator pit = curve.getPathIterator(null, flatness);
		final double[] coords = new double[6];
		int count = 0;

		while (!pit.isDone()) {
			final int type = pit.currentSegment(coords);
			switch (type) {

			case PathIterator.SEG_MOVETO:
				myX = coords[0];
				myY = coords[1];
				xCoordB.add(myX);
				yCoordB.add(myY);
				count++;
				break;

			case PathIterator.SEG_LINETO:
				if (coords[0] > 0) {
					myX = coords[0];
					myY = coords[1];
					xCoordB.add(myX);
					yCoordB.add(myY);

				}
				count++;
				break;
			default:
				System.out.println("unexpected type: " + type);
			}
			pit.next();
		}
	}

	public void getPoints(final QuadCurve2D curve) {

		final double flatness = 0.000001f;
		final PathIterator pit = curve.getPathIterator(null, flatness);
		final double[] coords = new double[6];
		int count = 0;

		while (!pit.isDone()) {
			final int type = pit.currentSegment(coords);
			switch (type) {

			case PathIterator.SEG_MOVETO:
				myX = coords[0];
				myY = coords[1];
				xCoordB.add(myX);
				yCoordB.add(myY);
				count++;
				break;

			case PathIterator.SEG_LINETO:
				if (coords[0] > 0) {
					myX = coords[0];
					myY = coords[1];
					xCoordB.add(myX);
					yCoordB.add(myY);

				}
				count++;
				break;
			default:
				System.out.println("unexpected type: " + type);
			}
			pit.next();
		}
	}

	public boolean extendMullions(final Profiles master, final Profiles slave,
			final int orientation) {

		boolean extendPerformed = false;

		AddMullionV addMullion = new AddMullionV(bOpeningObject,
				myFrame2.jobItem, myFrame2, 2);

		AddMullionH addMullionH = new AddMullionH(bOpeningObject,
				myFrame2.jobItem, myFrame2, 2);

		if (orientation == 1) {

			bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
			bOpeningObject.mullions.clear();

			for (final Object vc : bOpeningObject.mullionObjectsV) {

				if (((Profiles) vc).equals(master)) {

					if (((Profiles) vc).endPos < slave.startPos) {

						((Profiles) vc).endPos = slave.endPos;
						((Profiles) vc).y4 = slave.y4;
						((Profiles) vc).y3 = slave.y3;
						((Profiles) vc).centerYe = slave.centerYe;
						((Profiles) vc).y4al = slave.y4al;
						((Profiles) vc).y3cl = slave.y3cl;
						master.endPos = slave.endPos;
						master.y4 = slave.y4;
						master.y3 = slave.y3;
						master.centerYe = slave.centerYe;
						master.y4al = slave.y4al;
						master.y3cl = slave.y3cl;
						master.endTypeRB = slave.endTypeRB;
						master.endIn = slave.endIn;

						extendPerformed = true;
					}
					if (slave.endPos < ((Profiles) vc).startPos) {
						((Profiles) vc).startPos = slave.startPos;
						((Profiles) vc).y1 = slave.y1;
						((Profiles) vc).y2 = slave.y2;
						((Profiles) vc).centerYs = slave.centerYs;
						((Profiles) vc).y1al = slave.y1al;
						((Profiles) vc).y2cl = slave.y2cl;
						master.startPos = slave.startPos;
						master.y1 = slave.y1;
						master.y2 = slave.y2;
						master.centerYs = slave.centerYs;
						master.y1al = slave.y1al;
						master.y2cl = slave.y2cl;
						master.endTypeLT = slave.endTypeLT;
						master.startIn = slave.startIn;
						extendPerformed = true;

					}

					if (!master.startIn && !master.endIn) {
						master.posCondition = 1;
					} else if (!master.startIn && master.endIn) {
						master.posCondition = 2;
					} else if (master.startIn && !master.endIn) {
						master.posCondition = 3;
					} else {
						master.posCondition = 4;
					}
					if (myFrame2.mySeries.getSeriesUom() == 1) {
						addMullion.partDimA = ((Profiles) vc).partDimA;
						addMullion.partDimB = ((Profiles) vc).partDimB;
						addMullion.partDimC = ((Profiles) vc).partDimC;
						addMullion.partDimD = ((Profiles) vc).partDimD;
						addMullion.partDimBtoC = ((Profiles) vc).partDimBtoC;
					} else {
						addMullion.partDimA = ((Profiles) vc).partDimAi;
						addMullion.partDimB = ((Profiles) vc).partDimBi;
						addMullion.partDimC = ((Profiles) vc).partDimCi;
						addMullion.partDimD = ((Profiles) vc).partDimDi;
						addMullion.partDimBtoC = ((Profiles) vc).partDimBtoCi;
					}

					addMullion.vcEndY = ((Profiles) vc).centerYe;
					addMullion.vcEnd = ((Profiles) vc).endPos;

					addMullion.isNew = false;
					addMullion.newStartingYCenter = ((Profiles) vc).centerYs;

					addMullion.newStartingXCenter = ((Profiles) vc).centerXs;

					addMullion.getDimsForMullion(xCols, 2);

					addMullion.getNewPositionsXY(((Profiles) vc), false, true);
					addMullion.verifyLimitLR(((Profiles) vc));

					addMullion.calcMullion = new CalculateMullionV(addMullion);

					addMullion.calcMullion.calculateCoord(((Profiles) vc));

					if (master.cOrM == 1) {
						((Profiles) vc).profileSelected = 0;
						((Profiles) vc).potentialS = false;
					}
					bOpeningObject.mullions.add(vc);

				} else if (!((Profiles) vc).equals(slave)) {
					bOpeningObject.mullions.add(vc);
				}

			}
			bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
			for (final Object vc : bOpeningObject.mullionObjectsV) {
				if (((Profiles) vc).rowCol == master.rowCol
						&& ((Profiles) vc).startPos == master.startPos
						&& ((Profiles) vc).endPos == master.endPos) {
					bOpeningObject.myProfilesV = (Profiles) vc;
				}
			}
			bOpeningObject.mullionObjectsH = null;
			bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();
			bOpeningObject.mullionsH.clear();

			for (int c = 0; c < bOpeningObject.mullionObjectsH.length; c++) {

				if (((Profiles) bOpeningObject.mullionObjectsH[c]).endPos > master.rowCol
						&& ((Profiles) bOpeningObject.mullionObjectsH[c]).startPos <= master.rowCol
						&& master.y2 < ((Profiles) bOpeningObject.mullionObjectsH[c]).y2
						&& master.y4 > ((Profiles) bOpeningObject.mullionObjectsH[c]).y1) {
					addMullion.addMullionHSplit(
							((Profiles) bOpeningObject.mullionObjectsH[c]),
							bOpeningObject.myProfilesV, c);
					extendPerformed = true;

				} else {
					bOpeningObject.mullionsH
							.add(bOpeningObject.mullionObjectsH[c]);
				}

			}// for Loop V mul

		} else {
			bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();
			bOpeningObject.mullionsH.clear();

			for (final Object hc : bOpeningObject.mullionObjectsH) {
				if (((Profiles) hc).equals(master)) {
					if (((Profiles) hc).endPos < slave.startPos) {
						((Profiles) hc).endPos = slave.endPos;
						((Profiles) hc).x4 = slave.x4;
						((Profiles) hc).x3 = slave.x3;
						((Profiles) hc).centerXe = slave.centerXe;
						((Profiles) hc).x4al = slave.x4al;
						((Profiles) hc).x3cl = slave.x3cl;
						master.endPos = slave.endPos;
						master.x4 = slave.x4;
						master.x3 = slave.x3;
						master.centerXe = slave.centerXe;
						master.x4al = slave.x4al;
						master.x3cl = slave.x3cl;
						master.endTypeRB = slave.endTypeRB;
						master.endIn = slave.endIn;
						extendPerformed = true;
					}
					if (slave.endPos < ((Profiles) hc).startPos) {
						((Profiles) hc).startPos = slave.startPos;
						((Profiles) hc).x1 = slave.x1;
						((Profiles) hc).x2 = slave.x2;
						((Profiles) hc).centerXs = slave.centerXs;
						((Profiles) hc).x1al = slave.x1al;
						((Profiles) hc).x2cl = slave.x2cl;
						master.startPos = slave.startPos;
						master.x1 = slave.x1;
						master.x2 = slave.x2;
						master.centerXs = slave.centerXs;
						master.x1al = slave.x1al;
						master.x2cl = slave.x2cl;
						master.endTypeLT = slave.endTypeLT;
						master.startIn = slave.startIn;
						extendPerformed = true;
					}
					if (!master.startIn && !master.endIn) {
						master.posCondition = 1;
					} else if (!master.startIn && master.endIn) {
						master.posCondition = 2;
					} else if (master.startIn && !master.endIn) {
						master.posCondition = 3;
					} else {
						master.posCondition = 4;
					}

					if (myFrame2.mySeries.getSeriesUom() == 1) {
						addMullionH.partDimA = ((Profiles) hc).partDimA;
						addMullionH.partDimB = ((Profiles) hc).partDimB;
						addMullionH.partDimC = ((Profiles) hc).partDimC;
						addMullionH.partDimD = ((Profiles) hc).partDimD;
						addMullionH.partDimBtoC = ((Profiles) hc).partDimBtoC;
					} else {
						addMullionH.partDimA = ((Profiles) hc).partDimAi;
						addMullionH.partDimB = ((Profiles) hc).partDimBi;
						addMullionH.partDimC = ((Profiles) hc).partDimCi;
						addMullionH.partDimD = ((Profiles) hc).partDimDi;
						addMullionH.partDimBtoC = ((Profiles) hc).partDimBtoCi;
					}

					addMullionH.hcStartX = ((Profiles) hc).centerXs;

					addMullionH.hcEnd = ((Profiles) hc).endPos;

					addMullionH.newMullion = false;

					addMullionH.newStartingYCenter = ((Profiles) hc).centerYs;

					addMullionH.newStartingXCenter = ((Profiles) hc).centerXs;

					addMullionH.getDimsForMullion(0, 0);

					addMullionH.getPointsXY(((Profiles) hc), false, true);

					addMullionH.verifyLimitLR(((Profiles) hc));

					addMullionH.calcMullion = new CalculateMullionHii(
							addMullionH);

					if (master.cOrM == 1) {
						((Profiles) hc).profileSelected = 0;
						((Profiles) hc).potentialS = false;
					}

					addMullionH.calcMullion.calculateCoord(((Profiles) hc));

					bOpeningObject.mullionsH.add(hc);

				} else if (!((Profiles) hc).equals(slave)) {
					bOpeningObject.mullionsH.add(hc);
				}

			}

			bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();
			for (final Object vc : bOpeningObject.mullionObjectsH) {
				if (((Profiles) vc).rowCol == master.rowCol
						&& ((Profiles) vc).startPos == master.startPos
						&& ((Profiles) vc).endPos == master.endPos) {
					bOpeningObject.myProfilesH = (Profiles) vc;
				}
			}

			bOpeningObject.mullionObjectsV = null;
			bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
			bOpeningObject.mullions.clear();

			for (int c = 0; c < bOpeningObject.mullionObjectsV.length; c++) {

				if (((Profiles) bOpeningObject.mullionObjectsV[c]).endPos > master.rowCol
						&& ((Profiles) bOpeningObject.mullionObjectsV[c]).startPos <= master.rowCol
						&& master.x2cl < ((Profiles) bOpeningObject.mullionObjectsV[c]).x1
						&& master.x4al > ((Profiles) bOpeningObject.mullionObjectsV[c]).x3) {
					addMullionH.addMullionVSplit(
							((Profiles) bOpeningObject.mullionObjectsV[c]),
							bOpeningObject.myProfilesH, c);

				} else {
					bOpeningObject.mullions
							.add(bOpeningObject.mullionObjectsV[c]);
				}
			}// for Loop V mullion

		}

		// if (extendPerformed && master.cOrM>1)
		// {
		myFrame2.jobItem.resetGraphics();

		myFrame2.ellipses.clear();
		myFrame2.topTexts.clear();
		myFrame2.botTexts.clear();
		myFrame2.leftTexts.clear();
		myFrame2.rightTexts.clear();
		addMullionH.recalcVCCoords();
		addMullion.recalcHCCoords();
		addMullion.reOrderVNotches();
		addMullionH.reOrderHMNotches();

		this.bOpeningObject = this.doMullions(bOpeningObject);

		myFrame2.modifyDims = true;
		myFrame2.resetAlign();
		myFrame2.hideAlign();

		if (extendPerformed && master.cOrM == 1) {
			myFrame2.mullionsPanel.edit.setEnabled(false);
		}

		myFrame2.resetAlign();
		myFrame2.dimAction();

		addMullion = null;
		addMullionH = null;

		return extendPerformed;

	}

	/*
	 * public void changeVerifyEndTypesTop(final Object P, final boolean
	 * rchanged, final boolean lchanged) {
	 * 
	 * if (((Profiles) P).position == 1 && noSidesTop == 1) { top1.partID =
	 * ((Profiles) P).partID; top1.partDimB = ((Profiles) P).partDimB;
	 * top1.partDimM = ((Profiles) P).partDimM; top1.partDimA = ((Profiles)
	 * P).partDimA; top1.partDimC = ((Profiles) P).partDimC; if (lchanged) {
	 * top1.endTypeLT = ((Profiles) P).endTypeLT; } if (rchanged) {
	 * top1.endTypeRB = ((Profiles) P).endTypeRB; } if (noSidesLeft == 1) { if
	 * (top1.endTypeRB == 1) { left.endTypeLT = 1; } if (top1.endTypeRB == 2) {
	 * left.endTypeLT = 3; } if (top1.endTypeLT == 3) { left.endTypeLT = 2; } }
	 * else if (noSidesLeft == 0) { if (noSidesBot == 1) { if (top1.endTypeRB ==
	 * 1) { bot1.endTypeLT = 1; } if (top1.endTypeRB == 2) { bot1.endTypeLT = 3;
	 * } if (top1.endTypeLT == 3) { bot1.endTypeLT = 2; } } else { if
	 * (top1.endTypeRB == 1) { bot2.endTypeLT = 1; } if (top1.endTypeRB == 2) {
	 * bot2.endTypeLT = 3; } if (top1.endTypeLT == 3) { bot2.endTypeLT = 2; } }
	 * } if (noSidesRight == 1) { if (top1.endTypeLT == 1) { right.endTypeRB =
	 * 1; } if (top1.endTypeLT == 2) { right.endTypeRB = 3; } if (top1.endTypeLT
	 * == 3) { right.endTypeRB = 2; } } else { if (noSidesBot <= 2) { if
	 * (top1.endTypeLT == 1) { bot1.endTypeRB = 1; } if (top1.endTypeLT == 2) {
	 * bot1.endTypeRB = 3; } if (top1.endTypeLT == 3) { bot1.endTypeRB = 2; } }
	 * else { if (top1.endTypeLT == 1) { bot2.endTypeRB = 1; } if
	 * (top1.endTypeLT == 2) { bot2.endTypeRB = 3; } if (top1.endTypeLT == 3) {
	 * bot2.endTypeRB = 2; } } } if (top1.partDimB != left.partDimB ||
	 * top1.partDimA != left.partDimA && top1.endTypeRB == 1) {
	 * JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeRB = 3;
	 * top1.endTypeRB = 3; left.endTypeLT = 2; } if (top1.partDimB !=
	 * right.partDimB || top1.partDimA != right.partDimA && top1.endTypeLT == 1)
	 * { JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeLT = 3;
	 * top1.endTypeLT = 3; right.endTypeRB = 2; }
	 * 
	 * } else if (((Profiles) P).position == 1 && noSidesTop > 1) { top1.partID
	 * = ((Profiles) P).partID; top1.partDimB = ((Profiles) P).partDimB;
	 * top1.partDimM = ((Profiles) P).partDimM; top1.partDimA = ((Profiles)
	 * P).partDimA; top1.partDimC = ((Profiles) P).partDimC; top1.endTypeRB =
	 * ((Profiles) P).endTypeRB; top1.endTypeLT = ((Profiles) P).endTypeLT;
	 * 
	 * if (noSidesLeft == 1) { if (top1.endTypeRB == 1) { left.endTypeLT = 1; }
	 * if (top1.endTypeRB == 2) { left.endTypeLT = 3; } if (top1.endTypeLT == 3)
	 * { left.endTypeLT = 2; } } else if (noSidesLeft == 0) { if (noSidesBot ==
	 * 1) { if (top1.endTypeRB == 1) { bot1.endTypeLT = 1; } if (top1.endTypeRB
	 * == 2) { bot1.endTypeLT = 3; } if (top1.endTypeLT == 3) { bot1.endTypeLT =
	 * 2; } } else { if (top1.endTypeRB == 1) { bot2.endTypeLT = 1; } if
	 * (top1.endTypeRB == 2) { bot2.endTypeLT = 3; } if (top1.endTypeLT == 3) {
	 * bot2.endTypeLT = 2; } } }
	 * 
	 * if (noSidesTop == 2) { if (top1.endTypeLT == 1) { top2.endTypeRB = 1; }
	 * if (top1.endTypeLT == 2) { top2.endTypeRB = 3; } if (top1.endTypeLT == 3)
	 * { top2.endTypeRB = 2; }
	 * 
	 * if (top1.partDimB != top2.partDimB || top1.partDimA != top2.partDimA &&
	 * top1.endTypeLT == 1) { JOptionPane.showMessageDialog(null,
	 * "End Type Conflict! \n" + "Appropriate End Types will be set.",
	 * "End Type Conflict - Warning!", JOptionPane.WARNING_MESSAGE); ((Profiles)
	 * P).endTypeLT = 3; top1.endTypeLT = 3; top2.endTypeRB = 2; }
	 * 
	 * } else if (noSidesTop == 3) { if (top1.endTypeLT == 1) { top3.endTypeRB =
	 * 1; } if (top1.endTypeLT == 2) { top3.endTypeRB = 3; } if (top1.endTypeLT
	 * == 3) { top3.endTypeRB = 2; } if (top1.partDimB != top3.partDimB ||
	 * top1.partDimA != top3.partDimA && top1.endTypeLT == 1) {
	 * JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeLT = 3;
	 * top1.endTypeLT = 3; top3.endTypeRB = 2; } } if (top1.partDimB !=
	 * left.partDimB || top1.partDimA != left.partDimA && top1.endTypeLT == 1) {
	 * JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeRB = 3;
	 * top1.endTypeRB = 3; left.endTypeLT = 2; }
	 * 
	 * } else if (((Profiles) P).position == 2 && noSidesTop > 1) { top2.partID
	 * = ((Profiles) P).partID; top2.partDimB = ((Profiles) P).partDimB;
	 * top2.partDimM = ((Profiles) P).partDimM; top2.partDimA = ((Profiles)
	 * P).partDimA; top2.partDimC = ((Profiles) P).partDimC; top2.endTypeRB =
	 * ((Profiles) P).endTypeRB; top2.endTypeLT = ((Profiles) P).endTypeLT; if
	 * (noSidesRight == 1) { if (top2.endTypeLT == 1) { right.endTypeRB = 1; }
	 * else if (top2.endTypeLT == 2) { right.endTypeRB = 3; } else if
	 * (top2.endTypeLT == 3) { right.endTypeRB = 2; } } else { if (noSidesBot <=
	 * 2) { if (top2.endTypeLT == 1) { bot1.endTypeRB = 1; } else if
	 * (top2.endTypeLT == 2) { bot1.endTypeRB = 3; } else if (top2.endTypeLT ==
	 * 3) { bot1.endTypeRB = 2; } } else { if (top2.endTypeLT == 1) {
	 * bot3.endTypeRB = 1; } else if (top2.endTypeLT == 2) { bot3.endTypeRB = 3;
	 * } else if (top2.endTypeLT == 3) { bot3.endTypeRB = 2; } } } if
	 * (noSidesTop == 2) { if (top2.endTypeRB == 1) { top1.endTypeLT = 1; } else
	 * if (top2.endTypeRB == 2) { top1.endTypeLT = 3; } else if (top2.endTypeRB
	 * == 3) { top1.endTypeLT = 2; } if (top2.partDimB != top1.partDimB ||
	 * top2.partDimA != top1.partDimA && top2.endTypeRB == 1) {
	 * JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeRB = 3;
	 * top2.endTypeRB = 3; top1.endTypeLT = 2; }
	 * 
	 * } else if (noSidesTop == 3) { if (top2.endTypeRB == 1) { top3.endTypeLT =
	 * 1; } else if (top2.endTypeRB == 2) { top3.endTypeLT = 3; } else if
	 * (top2.endTypeRB == 3) { top3.endTypeLT = 2; } if (top2.partDimB !=
	 * top3.partDimB || top2.partDimA != top3.partDimA && top2.endTypeRB == 1) {
	 * JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeRB = 3;
	 * top2.endTypeRB = 3; top3.endTypeLT = 2; } }
	 * 
	 * if (top2.partDimB != right.partDimB || top2.partDimA != right.partDimA &&
	 * top2.endTypeLT == 1) { JOptionPane.showMessageDialog(null,
	 * "End Type Conflict! \n" + "Appropriate End Types will be set.",
	 * "End Type Conflict - Warning!", JOptionPane.WARNING_MESSAGE); ((Profiles)
	 * P).endTypeLT = 3; top2.endTypeLT = 3; right.endTypeRB = 2; }
	 * 
	 * } else if (((Profiles) P).position == 3) { top3.partID = ((Profiles)
	 * P).partID; top3.partDimB = ((Profiles) P).partDimB; top3.partDimM =
	 * ((Profiles) P).partDimM; top3.partDimA = ((Profiles) P).partDimA;
	 * top3.partDimC = ((Profiles) P).partDimC; top3.endTypeRB = ((Profiles)
	 * P).endTypeRB; top3.endTypeLT = ((Profiles) P).endTypeLT;
	 * 
	 * if (top3.endTypeRB == 1) { top1.endTypeLT = 1; } else if (top3.endTypeRB
	 * == 2) { top1.endTypeLT = 3; } else if (top3.endTypeRB == 3) {
	 * top1.endTypeLT = 2; }
	 * 
	 * if (top3.endTypeLT == 1) { top2.endTypeRB = 1; } else if (top3.endTypeLT
	 * == 2) { top2.endTypeRB = 3; } else if (top3.endTypeLT == 3) {
	 * top2.endTypeRB = 2; }
	 * 
	 * if (top3.partDimB != top1.partDimB || top3.partDimA != top1.partDimA &&
	 * top3.endTypeRB == 1) { JOptionPane.showMessageDialog(null,
	 * "End Type Conflict! \n" + "Appropriate End Types will be set.",
	 * "End Type Conflict - Warning!", JOptionPane.WARNING_MESSAGE); ((Profiles)
	 * P).endTypeRB = 3; top3.endTypeRB = 3; top1.endTypeLT = 2; } if
	 * (top3.partDimB != top2.partDimB || top3.partDimA != top2.partDimA &&
	 * top3.endTypeRB == 1) { JOptionPane.showMessageDialog(null,
	 * "End Type Conflict! \n" + "Appropriate End Types will be set.",
	 * "End Type Conflict - Warning!", JOptionPane.WARNING_MESSAGE); ((Profiles)
	 * P).endTypeLT = 3; top3.endTypeLT = 3; top2.endTypeRB = 2; }
	 * 
	 * } }
	 * 
	 * public void changeVerifyEndTypesBot(final Object P, final boolean
	 * rchanged, final boolean lchanged) {
	 * 
	 * if (((Profiles) P).position == 5 && noSidesBot == 1) { bot1.partID =
	 * ((Profiles) P).partID;
	 * 
	 * bot1.partDimB = ((Profiles) P).partDimB; bot1.partDimM = ((Profiles)
	 * P).partDimM; bot1.partDimA = ((Profiles) P).partDimA; bot1.partDimC =
	 * ((Profiles) P).partDimC;
	 * 
	 * bot1.partDimBi = ((Profiles) P).partDimBi; bot1.partDimMi = ((Profiles)
	 * P).partDimMi; bot1.partDimAi = ((Profiles) P).partDimAi; bot1.partDimCi =
	 * ((Profiles) P).partDimCi;
	 * 
	 * if (lchanged) { bot1.endTypeLT = ((Profiles) P).endTypeLT; } if
	 * (rchanged) { bot1.endTypeRB = ((Profiles) P).endTypeRB; } if
	 * (bot1.endTypeRB == 1 && noSidesRight == 1) { right.endTypeLT = 1; } if
	 * (bot1.endTypeRB == 1 && noSidesRight == 0) { top1.endTypeLT = 1; } if
	 * (bot1.endTypeRB == 2 && noSidesRight == 0) { if (noSidesTop == 1) {
	 * top1.endTypeLT = 3; } else { top2.endTypeLT = 3; } } if (bot1.endTypeRB
	 * == 3 && noSidesRight == 1) { right.endTypeLT = 2; if (rchanged)
	 * right.endTypeLTByUser = true; }
	 * 
	 * if (bot1.endTypeRB == 3 && noSidesRight == 0) { if (noSidesTop == 1) {
	 * top1.endTypeLT = 2; if (rchanged) top1.endTypeLTByUser = true; } else {
	 * top2.endTypeLT = 2; if (rchanged) top2.endTypeLTByUser = true; } }
	 * 
	 * if (bot1.endTypeLT == 1) { left.endTypeRB = 1; if (lchanged)
	 * left.endTypeRBByUser = true; } if (bot1.endTypeLT == 2 && noSidesLeft ==
	 * 1) { left.endTypeRB = 3; if (lchanged) left.endTypeRBByUser = true; }
	 * 
	 * if (bot1.endTypeLT == 2 && noSidesLeft == 0) { top1.endTypeRB = 3; if
	 * (lchanged) top1.endTypeRBByUser = true; } if (bot1.endTypeLT == 3 &&
	 * noSidesLeft == 1) { left.endTypeRB = 2; if (lchanged)
	 * left.endTypeRBByUser = true; }
	 * 
	 * if (bot1.endTypeLT == 3 && noSidesLeft == 0) { top1.endTypeRB = 2; if
	 * (lchanged) top1.endTypeRBByUser = true; } if (myFrame2.currentUOM == 1) {
	 * if (bot1.partDimB != right.partDimB || bot1.partDimA != right.partDimA &&
	 * bot1.endTypeRB == 1) { JOptionPane.showMessageDialog(null,
	 * "End Type Conflict! \n" + "Appropriate End Types will be set.",
	 * "End Type Conflict - Warning!", JOptionPane.WARNING_MESSAGE); ((Profiles)
	 * P).endTypeRB = 3; bot1.endTypeRB = 3; right.endTypeLT = 2; } if
	 * (bot1.partDimB != left.partDimB || bot1.partDimA != left.partDimA &&
	 * bot1.endTypeLT == 1) { JOptionPane.showMessageDialog(null,
	 * "End Type Conflict! \n" + "Appropriate End Types will be set.",
	 * "End Type Conflict - Warning!", JOptionPane.WARNING_MESSAGE); ((Profiles)
	 * P).endTypeLT = 3; bot1.endTypeLT = 3; left.endTypeRB = 2; } } else { if
	 * (bot1.partDimBi != right.partDimBi || bot1.partDimAi != right.partDimAi
	 * && bot1.endTypeRB == 1) { JOptionPane.showMessageDialog(null,
	 * "End Type Conflict! \n" + "Appropriate End Types will be set.",
	 * "End Type Conflict - Warning!", JOptionPane.WARNING_MESSAGE); ((Profiles)
	 * P).endTypeRB = 3; bot1.endTypeRB = 3; right.endTypeLT = 2; } if
	 * (bot1.partDimBi != left.partDimBi || bot1.partDimAi != left.partDimAi &&
	 * bot1.endTypeLT == 1) { JOptionPane.showMessageDialog(null,
	 * "End Type Conflict! \n" + "Appropriate End Types will be set.",
	 * "End Type Conflict - Warning!", JOptionPane.WARNING_MESSAGE); ((Profiles)
	 * P).endTypeLT = 3; bot1.endTypeLT = 3; left.endTypeRB = 2; } }
	 * 
	 * } else if (((Profiles) P).position == 1 && noSidesBot > 1) { bot1.partID
	 * = ((Profiles) P).partID; bot1.partDimB = ((Profiles) P).partDimB;
	 * bot1.partDimM = ((Profiles) P).partDimM; bot1.partDimA = ((Profiles)
	 * P).partDimA; bot1.partDimC = ((Profiles) P).partDimC; bot1.endTypeRB =
	 * ((Profiles) P).endTypeRB; bot1.endTypeLT = ((Profiles) P).endTypeLT;
	 * 
	 * bot1.partDimBi = ((Profiles) P).partDimBi; bot1.partDimMi = ((Profiles)
	 * P).partDimMi; bot1.partDimAi = ((Profiles) P).partDimAi; bot1.partDimCi =
	 * ((Profiles) P).partDimCi;
	 * 
	 * if (noSidesBot == 2) {
	 * 
	 * if (bot1.endTypeRB == 1 && noSidesRight == 1) { right.endTypeLT = 1; if
	 * (rchanged) right.endTypeLTByUser = true; } if (bot1.endTypeRB == 1 &&
	 * noSidesRight == 0) { top1.endTypeLT = 1; if (rchanged)
	 * top1.endTypeLTByUser = true; } if (bot1.endTypeRB == 2 && noSidesRight ==
	 * 0) { if (noSidesTop == 1) { top1.endTypeLT = 3; if (rchanged)
	 * top1.endTypeLTByUser = true; } else { top2.endTypeLT = 3; if (rchanged)
	 * top2.endTypeLTByUser = true; } } if (bot1.endTypeRB == 3 && noSidesRight
	 * == 1) { right.endTypeLT = 2; if (rchanged) right.endTypeLTByUser = true;
	 * }
	 * 
	 * if (bot1.endTypeRB == 3 && noSidesRight == 0) { if (noSidesTop == 1) {
	 * top1.endTypeLT = 2; if (rchanged) top1.endTypeLTByUser = true; } else {
	 * top2.endTypeLT = 2; if (rchanged) top2.endTypeLTByUser = true; } }
	 * 
	 * if (noSidesBot == 2) { if (bot1.endTypeLT == 1) { bot2.endTypeRB = 1; if
	 * (lchanged) bot2.endTypeRBByUser = true; } if (bot1.endTypeLT == 2) {
	 * bot2.endTypeRB = 3; if (lchanged) bot2.endTypeRBByUser = true; } if
	 * (bot1.endTypeLT == 3) { bot2.endTypeRB = 2; if (lchanged)
	 * bot2.endTypeRBByUser = true; } } if (noSidesBot == 3) { if
	 * (bot1.endTypeLT == 1) { bot3.endTypeRB = 1; if (lchanged)
	 * bot3.endTypeRBByUser = true; } if (bot1.endTypeLT == 2) { bot3.endTypeRB
	 * = 3; if (lchanged) bot3.endTypeRBByUser = true; } if (bot1.endTypeLT ==
	 * 3) { bot3.endTypeRB = 2; if (lchanged) bot3.endTypeRBByUser = true; } }
	 * 
	 * if (myFrame2.currentUOM == 1) { if (bot1.partDimB != bot2.partDimB ||
	 * bot1.partDimA != bot2.partDimA && bot1.endTypeLT == 1) {
	 * JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeLT = 3;
	 * bot1.endTypeLT = 3; bot2.endTypeRB = 2; }
	 * 
	 * if (bot1.partDimB != right.partDimB || bot1.partDimA != right.partDimA &&
	 * bot1.endTypeLT == 1) { JOptionPane.showMessageDialog(null,
	 * "End Type Conflict! \n" + "Appropriate End Types will be set.",
	 * "End Type Conflict - Warning!", JOptionPane.WARNING_MESSAGE); ((Profiles)
	 * P).endTypeRB = 3; bot1.endTypeRB = 3; right.endTypeLT = 2; } } else { if
	 * (bot1.partDimBi != bot2.partDimBi || bot1.partDimAi != bot2.partDimAi &&
	 * bot1.endTypeLT == 1) { JOptionPane.showMessageDialog(null,
	 * "End Type Conflict! \n" + "Appropriate End Types will be set.",
	 * "End Type Conflict - Warning!", JOptionPane.WARNING_MESSAGE); ((Profiles)
	 * P).endTypeLT = 3; bot1.endTypeLT = 3; bot2.endTypeRB = 2; }
	 * 
	 * if (bot1.partDimBi != right.partDimBi || bot1.partDimAi !=
	 * right.partDimAi && bot1.endTypeLT == 1) {
	 * JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeRB = 3;
	 * bot1.endTypeRB = 3; right.endTypeLT = 2; } }
	 * 
	 * } else if (noSidesTop == 3) { if (bot1.endTypeLT == 1) { bot3.endTypeRB =
	 * 1; } if (bot1.endTypeLT == 2) { bot3.endTypeRB = 3; } if (bot1.endTypeLT
	 * == 3) { bot3.endTypeRB = 2; }
	 * 
	 * if (bot1.endTypeLT == 1) { bot2.endTypeRB = 1; } if (bot1.endTypeLT == 2)
	 * { bot2.endTypeRB = 3; } if (bot1.endTypeLT == 3) { bot2.endTypeRB = 2; }
	 * if (myFrame2.currentUOM == 1) if (bot1.partDimB != bot2.partDimB ||
	 * bot1.partDimA != bot2.partDimA && bot1.endTypeLT == 1) {
	 * JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeLT = 3;
	 * bot1.endTypeLT = 3; bot2.endTypeRB = 2; } if (bot1.partDimB !=
	 * bot3.partDimB || bot1.partDimA != bot3.partDimA && bot1.endTypeLT == 1) {
	 * JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeLT = 3;
	 * bot1.endTypeLT = 3; bot3.endTypeRB = 2; }
	 * 
	 * else { if (bot1.partDimBi != bot2.partDimBi || bot1.partDimAi !=
	 * bot2.partDimAi && bot1.endTypeLT == 1) {
	 * JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeLT = 3;
	 * bot1.endTypeLT = 3; bot2.endTypeRB = 2; } if (bot1.partDimBi !=
	 * bot3.partDimBi || bot1.partDimAi != bot3.partDimAi && bot1.endTypeLT ==
	 * 1) { JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeLT = 3;
	 * bot1.endTypeLT = 3; bot3.endTypeRB = 2; } } }
	 * 
	 * } else if (((Profiles) P).position == 2 && noSidesBot > 1) { bot2.partID
	 * = ((Profiles) P).partID; bot2.partDimB = ((Profiles) P).partDimB;
	 * bot2.partDimM = ((Profiles) P).partDimM; bot2.partDimA = ((Profiles)
	 * P).partDimA; bot2.partDimC = ((Profiles) P).partDimC; bot2.endTypeRB =
	 * ((Profiles) P).endTypeRB; bot2.endTypeLT = ((Profiles) P).endTypeLT; if
	 * (bot2.endTypeLT == 1 && noSidesLeft == 1) { left.endTypeRB = 1; } else if
	 * (bot2.endTypeLT == 2 && noSidesLeft == 1) { left.endTypeRB = 3; } else if
	 * (bot2.endTypeLT == 3 && noSidesLeft == 1) { left.endTypeRB = 2; } if
	 * (bot2.endTypeLT == 1 && noSidesLeft == 0) { top1.endTypeRB = 1; } else if
	 * (bot2.endTypeLT == 2 && noSidesLeft == 0) { top1.endTypeRB = 3; } else if
	 * (bot2.endTypeLT == 3 && noSidesLeft == 0) { top1.endTypeRB = 2; } if
	 * (noSidesBot >= 2) { if (bot2.endTypeRB == 1) { bot1.endTypeLT = 1; } else
	 * if (bot2.endTypeRB == 2) { bot1.endTypeLT = 3; } else if (bot2.endTypeRB
	 * == 3) { bot1.endTypeLT = 2; }
	 * 
	 * if (myFrame2.currentUOM == 1) { if (bot2.partDimB != bot1.partDimB ||
	 * bot2.partDimA != bot1.partDimA && bot2.endTypeRB == 1) {
	 * JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeRB = 3;
	 * bot2.endTypeRB = 3; bot1.endTypeLT = 2; } } else { if (bot2.partDimBi !=
	 * bot1.partDimBi || bot2.partDimAi != bot1.partDimAi && bot2.endTypeRB ==
	 * 1) { JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeRB = 3;
	 * bot2.endTypeRB = 3; bot1.endTypeLT = 2; } }
	 * 
	 * }
	 * 
	 * if (myFrame2.currentUOM == 1 && (bot2.partDimB != left.partDimB ||
	 * bot2.partDimA != left.partDimA && bot2.endTypeLT == 1)) {
	 * JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeLT = 3;
	 * bot2.endTypeLT = 3; left.endTypeRB = 2; } else if (myFrame2.currentUOM >
	 * 1 && (bot2.partDimBi != left.partDimBi || bot2.partDimAi !=
	 * left.partDimAi && bot2.endTypeLT == 1)) {
	 * JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeLT = 3;
	 * bot2.endTypeLT = 3; left.endTypeRB = 2; }
	 * 
	 * } else if (((Profiles) P).position == 3) { bot3.partID = ((Profiles)
	 * P).partID; bot3.partDimB = ((Profiles) P).partDimB; bot3.partDimM =
	 * ((Profiles) P).partDimM; bot3.partDimA = ((Profiles) P).partDimA;
	 * bot3.partDimC = ((Profiles) P).partDimC; bot3.endTypeRB = ((Profiles)
	 * P).endTypeRB; bot3.endTypeLT = ((Profiles) P).endTypeLT;
	 * 
	 * if (bot3.endTypeRB == 1 && noSidesRight == 1) { right.endTypeLT = 1; }
	 * else if (bot3.endTypeRB == 2 && noSidesRight == 1) { right.endTypeLT = 3;
	 * } else if (bot3.endTypeRB == 3 && noSidesRight == 1) { right.endTypeLT =
	 * 2; } if (noSidesRight == 0 && noSidesTop == 1) { if (bot3.endTypeRB == 1)
	 * { top1.endTypeLT = 1; } else if (bot3.endTypeRB == 2) { top1.endTypeLT =
	 * 3; } else if (bot3.endTypeRB == 3) { top1.endTypeLT = 2; } } if
	 * (noSidesRight == 0 && noSidesTop == 2) { if (bot3.endTypeRB == 1) {
	 * top2.endTypeLT = 1; } else if (bot3.endTypeRB == 2) { top2.endTypeLT = 3;
	 * } else if (bot3.endTypeRB == 3) { top2.endTypeLT = 2; } }
	 * 
	 * if (bot3.endTypeLT == 1) { bot1.endTypeRB = 1; } else if (bot3.endTypeLT
	 * == 2) { bot1.endTypeRB = 3; } else if (bot3.endTypeLT == 3) {
	 * bot1.endTypeRB = 2; }
	 * 
	 * if (myFrame2.currentUOM == 1) { if (bot3.partDimB != right.partDimB ||
	 * bot3.partDimA != right.partDimA && bot3.endTypeRB == 1) {
	 * JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeRB = 3;
	 * bot3.endTypeRB = 3; right.endTypeLT = 2; } if (bot3.partDimB !=
	 * bot1.partDimB || bot3.partDimA != bot1.partDimA && bot3.endTypeRB == 1) {
	 * JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeLT = 3;
	 * bot3.endTypeLT = 3; bot1.endTypeRB = 2; } } else { if (bot3.partDimBi !=
	 * right.partDimBi || bot3.partDimAi != right.partDimAi && bot3.endTypeRB ==
	 * 1) { JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeRB = 3;
	 * bot3.endTypeRB = 3; right.endTypeLT = 2; } if (bot3.partDimBi !=
	 * bot1.partDimBi || bot3.partDimAi != bot1.partDimAi && bot3.endTypeRB ==
	 * 1) { JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeLT = 3;
	 * bot3.endTypeLT = 3; bot1.endTypeRB = 2; } }
	 * 
	 * } }
	 * 
	 * public void changeVerifyEndTypesLeft(final Object P) {
	 * 
	 * if (((Profiles) P).position == 8) { left.partID = ((Profiles) P).partID;
	 * left.partDimB = ((Profiles) P).partDimB; left.partDimM = ((Profiles)
	 * P).partDimM; left.partDimA = ((Profiles) P).partDimA; left.partDimC =
	 * ((Profiles) P).partDimC; left.endTypeLT = ((Profiles) P).endTypeLT;
	 * left.endTypeRB = ((Profiles) P).endTypeRB; if (noSidesBot == 1) { if
	 * (left.endTypeRB == 1) { bot1.endTypeLT = 1; } if (left.endTypeRB == 2) {
	 * bot1.endTypeLT = 3; } if (left.endTypeRB == 3) { bot1.endTypeLT = 2; } if
	 * (myFrame2.currentUOM == 1 && (left.partDimB != bot1.partDimB ||
	 * left.partDimA != bot1.partDimA && left.endTypeRB == 1)) {
	 * JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeRB = 3;
	 * left.endTypeRB = 3; bot1.endTypeLT = 2; } else if (myFrame2.currentUOM >
	 * 1 && (left.partDimBi != bot1.partDimBi || left.partDimAi !=
	 * bot1.partDimAi && left.endTypeRB == 1)) {
	 * JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeRB = 3;
	 * left.endTypeRB = 3; bot1.endTypeLT = 2; } } if (noSidesBot > 1) { if
	 * (left.endTypeRB == 1) { bot2.endTypeLT = 1; } if (left.endTypeRB == 2) {
	 * bot2.endTypeLT = 3; } if (left.endTypeRB == 3) { bot2.endTypeLT = 2; } if
	 * (myFrame2.currentUOM == 1 && (left.partDimB != bot2.partDimB ||
	 * left.partDimA != bot2.partDimA && left.endTypeRB == 1)) {
	 * JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeRB = 3;
	 * left.endTypeRB = 3; bot2.endTypeLT = 2; } else if (myFrame2.currentUOM >
	 * 1 && (left.partDimBi != bot2.partDimBi || left.partDimAi !=
	 * bot2.partDimAi && left.endTypeRB == 1)) {
	 * JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeRB = 3;
	 * left.endTypeRB = 3; bot2.endTypeLT = 2; } } if (left.endTypeLT == 1) {
	 * top1.endTypeRB = 1; } if (left.endTypeLT == 2) { top1.endTypeRB = 3; } if
	 * (left.endTypeLT == 3) { top1.endTypeRB = 2; } if (myFrame2.currentUOM ==
	 * 1 && (left.partDimB != top1.partDimB || left.partDimA != top1.partDimA &&
	 * left.endTypeLT == 1)) { JOptionPane.showMessageDialog(null,
	 * "End Type Conflict! \n" + "Appropriate End Types will be set.",
	 * "End Type Conflict - Warning!", JOptionPane.WARNING_MESSAGE); ((Profiles)
	 * P).endTypeLT = 3; left.endTypeLT = 3; top1.endTypeRB = 2; } else if
	 * (myFrame2.currentUOM > 1 && (left.partDimBi != top1.partDimBi ||
	 * left.partDimAi != top1.partDimAi && left.endTypeLT == 1)) {
	 * JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeLT = 3;
	 * left.endTypeLT = 3; top1.endTypeRB = 2; }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * public void changeVerifyEndTypesRight(final Object P) {
	 * 
	 * if (((Profiles) P).position == 4) { right.partID = ((Profiles) P).partID;
	 * right.partDimB = ((Profiles) P).partDimB; right.partDimM = ((Profiles)
	 * P).partDimM; right.partDimA = ((Profiles) P).partDimA; right.partDimC =
	 * ((Profiles) P).partDimC; right.endTypeLT = ((Profiles) P).endTypeLT;
	 * right.endTypeRB = ((Profiles) P).endTypeRB; if (noSidesBot == 1) { if
	 * (right.endTypeLT == 1) { bot1.endTypeRB = 1; } if (right.endTypeLT == 2)
	 * { bot1.endTypeRB = 3; } if (right.endTypeLT == 3) { bot1.endTypeRB = 2; }
	 * if (myFrame2.currentUOM == 1 && (right.partDimB != bot1.partDimB ||
	 * right.partDimA != bot1.partDimA && right.endTypeLT == 1)) {
	 * JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeLT = 3;
	 * right.endTypeLT = 3; bot1.endTypeRB = 2; } else if (myFrame2.currentUOM >
	 * 1 && (right.partDimBi != bot1.partDimBi || right.partDimAi !=
	 * bot1.partDimAi && right.endTypeLT == 1)) {
	 * JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeLT = 3;
	 * right.endTypeLT = 3; bot1.endTypeRB = 2; } } if (noSidesBot == 3) { if
	 * (right.endTypeLT == 1) { bot3.endTypeRB = 1; } if (right.endTypeLT == 2)
	 * { bot3.endTypeRB = 3; } if (right.endTypeLT == 3) { bot3.endTypeRB = 2; }
	 * if (myFrame2.currentUOM == 1 && (right.partDimB != bot3.partDimB ||
	 * right.partDimA != bot3.partDimA && right.endTypeLT == 1)) {
	 * JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeLT = 3;
	 * right.endTypeLT = 3; bot3.endTypeRB = 2; } else if (myFrame2.currentUOM >
	 * 1 && (right.partDimBi != bot3.partDimBi || right.partDimAi !=
	 * bot3.partDimAi && right.endTypeLT == 1)) {
	 * JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeLT = 3;
	 * right.endTypeLT = 3; bot3.endTypeRB = 2; } } if (noSidesTop == 1) { if
	 * (right.endTypeRB == 1) { top1.endTypeLT = 1; } if (right.endTypeRB == 2)
	 * { top1.endTypeLT = 3; } if (right.endTypeRB == 3) { top1.endTypeLT = 2; }
	 * if (myFrame2.currentUOM == 1 && (right.partDimB != top1.partDimB ||
	 * right.partDimA != top1.partDimA && right.endTypeRB == 1)) {
	 * JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeRB = 3;
	 * right.endTypeRB = 3; top1.endTypeLT = 2; } else if (myFrame2.currentUOM >
	 * 1 && (right.partDimBi != top1.partDimBi || right.partDimAi !=
	 * top1.partDimAi && right.endTypeRB == 1)) {
	 * JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeRB = 3;
	 * right.endTypeRB = 3; top1.endTypeLT = 2; } } if (noSidesTop > 1) { if
	 * (right.endTypeRB == 1) { top2.endTypeLT = 1; } if (right.endTypeRB == 2)
	 * { top2.endTypeLT = 3; } if (right.endTypeRB == 3) { top2.endTypeLT = 2; }
	 * if (myFrame2.currentUOM == 1 && (right.partDimB != top2.partDimB ||
	 * right.partDimA != top2.partDimA && right.endTypeRB == 1)) {
	 * JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeRB = 3;
	 * right.endTypeRB = 3; top2.endTypeLT = 2; } else if (myFrame2.currentUOM >
	 * 1 && (right.partDimBi != top2.partDimBi || right.partDimAi !=
	 * top2.partDimAi && right.endTypeRB == 1)) {
	 * JOptionPane.showMessageDialog(null, "End Type Conflict! \n" +
	 * "Appropriate End Types will be set.", "End Type Conflict - Warning!",
	 * JOptionPane.WARNING_MESSAGE); ((Profiles) P).endTypeRB = 3;
	 * right.endTypeRB = 3; top2.endTypeLT = 2; } }
	 * 
	 * }
	 * 
	 * }
	 */

	public void changeVerifyEndTypesTopP(final Object P,
			final boolean rchanged, final boolean lchanged) {

		if (((Profiles) P).position == 1 && noSidesTop == 1) {
			top1Part.partID = ((Profiles) P).partID;
			top1Part.partDimB = ((Profiles) P).partDimB;
			top1Part.partDimM = ((Profiles) P).partDimM;
			top1Part.partDimA = ((Profiles) P).partDimA;
			top1Part.partDimC = ((Profiles) P).partDimC;

			top1Part.partDimBi = ((Profiles) P).partDimBi;
			top1Part.partDimMi = ((Profiles) P).partDimMi;
			top1Part.partDimAi = ((Profiles) P).partDimAi;
			top1Part.partDimCi = ((Profiles) P).partDimCi;

			top1Part.partIDByUser = ((Profiles) P).partIDByUser;

			if (lchanged) {
				top1Part.endTypeLT = ((Profiles) P).endTypeLT;
				top1Part.endTypeLTByUser = true;
			}
			if (rchanged) {
				top1Part.endTypeRB = ((Profiles) P).endTypeRB;
				top1Part.endTypeRBByUser = true;

			}

			if (noSidesLeft == 1) {
				if (top1Part.endTypeRB == 1) {
					leftPart.endTypeLT = 1;

				}
				if (top1Part.endTypeRB == 2) {
					leftPart.endTypeLT = 3;

				}
				if (top1Part.endTypeLT == 3) {
					leftPart.endTypeLT = 2;

				}
				leftPart.endTypeLTByUser = true;

			} else if (noSidesLeft == 0) {
				if (noSidesBot == 1) {
					if (top1Part.endTypeRB == 1) {
						bot1Part.endTypeLT = 1;

					}
					if (top1Part.endTypeRB == 2) {
						bot1Part.endTypeLT = 3;

					}
					if (top1Part.endTypeLT == 3) {
						bot1Part.endTypeLT = 2;

					}
					bot1Part.endTypeLTByUser = true;

				} else {
					if (top1Part.endTypeRB == 1) {
						bot2Part.endTypeLT = 1;

					}
					if (top1Part.endTypeRB == 2) {
						bot2Part.endTypeLT = 3;

					}
					if (top1Part.endTypeLT == 3) {
						bot2Part.endTypeLT = 2;

					}
					bot2Part.endTypeLTByUser = true;

				}
			}
			if (noSidesRight == 1) {
				if (top1Part.endTypeLT == 1) {
					rightPart.endTypeRB = 1;

				}
				if (top1Part.endTypeLT == 2) {
					rightPart.endTypeRB = 3;

				}
				if (top1Part.endTypeLT == 3) {
					rightPart.endTypeRB = 2;

				}
				rightPart.endTypeRBByUser = true;

			} else {
				if (noSidesBot <= 2) {
					if (top1Part.endTypeLT == 1) {
						bot1Part.endTypeRB = 1;

					}
					if (top1Part.endTypeLT == 2) {
						bot1Part.endTypeRB = 3;

					}
					if (top1Part.endTypeLT == 3) {
						bot1Part.endTypeRB = 2;

					}
					bot1Part.endTypeRBByUser = true;

				} else {
					if (top1Part.endTypeLT == 1) {
						bot2Part.endTypeRB = 1;

					}
					if (top1Part.endTypeLT == 2) {
						bot2Part.endTypeRB = 3;

					}
					if (top1Part.endTypeLT == 3) {
						bot2Part.endTypeRB = 2;

					}
					bot1Part.endTypeRBByUser = true;

				}
			}

			if (myFrame2.mySeries.getSeriesUom() == 1) {
				if (top1Part.partDimB != leftPart.partDimB
						|| top1Part.partDimA != leftPart.partDimA
						&& top1Part.endTypeRB == 1) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeRB = 3;
					top1Part.endTypeRB = 3;
					leftPart.endTypeLT = 2;
					top1Part.endTypeRBByUser = false;
					leftPart.endTypeLTByUser = false;

				}
				if (top1Part.partDimB != rightPart.partDimB
						|| top1Part.partDimA != rightPart.partDimA
						&& top1Part.endTypeLT == 1) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeLT = 3;
					top1Part.endTypeLT = 3;
					rightPart.endTypeRB = 2;
					rightPart.endTypeRBByUser = false;
					top1Part.endTypeLTByUser = false;

				}
			} else {
				if (top1Part.partDimBi != leftPart.partDimBi
						|| top1Part.partDimAi != leftPart.partDimAi
						&& top1Part.endTypeRB == 1) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeRB = 3;
					top1Part.endTypeRB = 3;
					leftPart.endTypeLT = 2;
					top1Part.endTypeRBByUser = false;
					leftPart.endTypeLTByUser = false;

				}
				if (top1Part.partDimBi != rightPart.partDimBi
						|| top1Part.partDimAi != rightPart.partDimAi
						&& top1Part.endTypeLT == 1) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeLT = 3;
					top1Part.endTypeLT = 3;
					rightPart.endTypeRB = 2;
					rightPart.endTypeRBByUser = false;
					top1Part.endTypeLTByUser = false;

				}
			}

		} else if (((Profiles) P).position == 1 && noSidesTop > 1) {
			top1Part.partID = ((Profiles) P).partID;
			top1Part.partDimB = ((Profiles) P).partDimB;
			top1Part.partDimM = ((Profiles) P).partDimM;
			top1Part.partDimA = ((Profiles) P).partDimA;
			top1Part.partDimC = ((Profiles) P).partDimC;
			top1Part.endTypeRB = ((Profiles) P).endTypeRB;
			top1Part.endTypeLT = ((Profiles) P).endTypeLT;
			top1Part.partIDByUser = ((Profiles) P).partIDByUser;
			top1Part.endTypeRBByUser = ((Profiles) P).endTypeRBByUser;
			top1Part.endTypeLTByUser = ((Profiles) P).endTypeLTByUser;

			if (noSidesLeft == 1) {
				if (top1Part.endTypeRB == 1) {
					leftPart.endTypeLT = 1;

				}
				if (top1Part.endTypeRB == 2) {
					leftPart.endTypeLT = 3;

				}
				if (top1Part.endTypeLT == 3) {
					leftPart.endTypeLT = 2;

				}
				leftPart.endTypeLTByUser = true;

			} else if (noSidesLeft == 0) {
				if (noSidesBot == 1) {
					if (top1Part.endTypeRB == 1) {
						bot1Part.endTypeLT = 1;

					}
					if (top1Part.endTypeRB == 2) {
						bot1Part.endTypeLT = 3;

					}
					if (top1Part.endTypeLT == 3) {
						bot1Part.endTypeLT = 2;

					}
					bot1Part.endTypeLTByUser = true;

				} else {
					if (top1Part.endTypeRB == 1) {
						bot2Part.endTypeLT = 1;

					}
					if (top1Part.endTypeRB == 2) {
						bot2Part.endTypeLT = 3;

					}
					if (top1Part.endTypeLT == 3) {
						bot2Part.endTypeLT = 2;

					}
					bot2Part.endTypeLTByUser = true;

				}
			}

			if (noSidesTop == 2) {
				if (top1Part.endTypeLT == 1) {
					top2Part.endTypeRB = 1;

				}
				if (top1Part.endTypeLT == 2) {
					top2Part.endTypeRB = 3;

				}
				if (top1Part.endTypeLT == 3) {
					top2Part.endTypeRB = 2;

				}

				top2Part.endTypeRBByUser = true;

				if (myFrame2.mySeries.getSeriesUom() == 1
						&& (top1Part.partDimB != top2Part.partDimB || top1Part.partDimA != top2Part.partDimA)
						&& top1Part.endTypeLT == 1) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeLT = 3;
					top1Part.endTypeLT = 3;
					top2Part.endTypeRB = 2;
					top1Part.endTypeLTByUser = false;
					top2Part.endTypeRBByUser = false;

				} else if (myFrame2.mySeries.getSeriesUom() > 1
						&& (top1Part.partDimBi != top2Part.partDimBi || top1Part.partDimAi != top2Part.partDimAi)
						&& top1Part.endTypeLT == 1) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeLT = 3;
					top1Part.endTypeLT = 3;
					top2Part.endTypeRB = 2;
					top1Part.endTypeLTByUser = false;
					top2Part.endTypeRBByUser = false;

				}

			} else if (noSidesTop == 3) {
				if (top1Part.endTypeLT == 1) {
					top3Part.endTypeRB = 1;

				}
				if (top1Part.endTypeLT == 2) {
					top3Part.endTypeRB = 3;

				}
				if (top1Part.endTypeLT == 3) {
					top3Part.endTypeRB = 2;

				}

				top3Part.endTypeRBByUser = true;

				if (myFrame2.mySeries.getSeriesUom() == 1
						&& (top1Part.partDimB != top3Part.partDimB || top1Part.partDimA != top3Part.partDimA)
						&& top1Part.endTypeLT == 1) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeLT = 3;
					top1Part.endTypeLT = 3;
					top3Part.endTypeRB = 2;
					top1Part.endTypeLTByUser = false;
					top3Part.endTypeRBByUser = false;

				} else if (myFrame2.mySeries.getSeriesUom() > 1
						&& (top1Part.partDimBi != top3Part.partDimBi || top1Part.partDimAi != top3Part.partDimAi)
						&& top1Part.endTypeLT == 1) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeLT = 3;
					top1Part.endTypeLT = 3;
					top3Part.endTypeRB = 2;
					top1Part.endTypeLTByUser = false;
					top3Part.endTypeRBByUser = false;

				}
			}

			if (myFrame2.mySeries.getSeriesUom() == 1
					&& (top1Part.partDimB != leftPart.partDimB || top1Part.partDimA != leftPart.partDimA
							&& top1Part.endTypeLT == 1)) {
				JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
						+ "Appropriate End Types will be set.",
						"End Type Conflict - Warning!",
						JOptionPane.WARNING_MESSAGE);
				((Profiles) P).endTypeRB = 3;
				top1Part.endTypeRB = 3;
				leftPart.endTypeLT = 2;
				top1Part.endTypeRBByUser = false;
				leftPart.endTypeLTByUser = false;

			} else if (myFrame2.mySeries.getSeriesUom() > 1
					&& (top1Part.partDimBi != leftPart.partDimBi || top1Part.partDimAi != leftPart.partDimAi
							&& top1Part.endTypeLT == 1)) {
				JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
						+ "Appropriate End Types will be set.",
						"End Type Conflict - Warning!",
						JOptionPane.WARNING_MESSAGE);
				((Profiles) P).endTypeRB = 3;
				top1Part.endTypeRB = 3;
				leftPart.endTypeLT = 2;
				top1Part.endTypeRBByUser = false;
				leftPart.endTypeLTByUser = false;

			}

		} else if (((Profiles) P).position == 2 && noSidesTop > 1) {
			top2Part.partID = ((Profiles) P).partID;
			top2Part.partDimB = ((Profiles) P).partDimB;
			top2Part.partDimM = ((Profiles) P).partDimM;
			top2Part.partDimA = ((Profiles) P).partDimA;
			top2Part.partDimC = ((Profiles) P).partDimC;
			top2Part.endTypeRB = ((Profiles) P).endTypeRB;
			top2Part.endTypeLT = ((Profiles) P).endTypeLT;
			top2Part.partIDByUser = ((Profiles) P).partIDByUser;
			top2Part.endTypeRBByUser = ((Profiles) P).endTypeRBByUser;
			top2Part.endTypeLTByUser = ((Profiles) P).endTypeLTByUser;

			if (noSidesRight == 1) {
				if (top2Part.endTypeLT == 1) {
					rightPart.endTypeRB = 1;

				} else if (top2Part.endTypeLT == 2) {
					rightPart.endTypeRB = 3;

				} else if (top2Part.endTypeLT == 3) {
					rightPart.endTypeRB = 2;

				}
				rightPart.endTypeRBByUser = true;

			} else {
				if (noSidesBot <= 2) {
					if (top2Part.endTypeLT == 1) {
						bot1Part.endTypeRB = 1;

					} else if (top2Part.endTypeLT == 2) {
						bot1Part.endTypeRB = 3;

					} else if (top2Part.endTypeLT == 3) {
						bot1Part.endTypeRB = 2;

					}
					bot1Part.endTypeRBByUser = true;

				} else {
					if (top2Part.endTypeLT == 1) {
						bot3Part.endTypeRB = 1;

					} else if (top2Part.endTypeLT == 2) {
						bot3Part.endTypeRB = 3;

					} else if (top2Part.endTypeLT == 3) {
						bot3Part.endTypeRB = 2;

					}

					bot3Part.endTypeRBByUser = true;

				}
			}
			if (noSidesTop == 2) {
				if (top2Part.endTypeRB == 1) {
					top1Part.endTypeLT = 1;

				} else if (top2Part.endTypeRB == 2) {
					top1Part.endTypeLT = 3;

				} else if (top2Part.endTypeRB == 3) {
					top1Part.endTypeLT = 2;
				}

				top1Part.endTypeLTByUser = true;

				if (myFrame2.mySeries.getSeriesUom() == 1
						&& (top2Part.partDimB != top1Part.partDimB || top2Part.partDimA != top1Part.partDimA
								&& top2Part.endTypeRB == 1)) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeRB = 3;
					top2Part.endTypeRB = 3;
					top1Part.endTypeLT = 2;
					top2Part.endTypeRBByUser = false;
					top1Part.endTypeLTByUser = false;
				} else if (myFrame2.mySeries.getSeriesUom() > 1
						&& (top2Part.partDimBi != top1Part.partDimBi || top2Part.partDimAi != top1Part.partDimAi
								&& top2Part.endTypeRB == 1)) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeRB = 3;
					top2Part.endTypeRB = 3;
					top1Part.endTypeLT = 2;
					top2Part.endTypeRBByUser = false;
					top1Part.endTypeLTByUser = false;
				}

			} else if (noSidesTop == 3) {
				if (top2Part.endTypeRB == 1) {
					top3Part.endTypeLT = 1;

				} else if (top2Part.endTypeRB == 2) {
					top3Part.endTypeLT = 3;

				} else if (top2Part.endTypeRB == 3) {
					top3Part.endTypeLT = 2;

				}

				top3Part.endTypeLTByUser = true;

				if (myFrame2.mySeries.getSeriesUom() == 1
						&& (top2Part.partDimB != top3Part.partDimB || top2Part.partDimA != top3Part.partDimA
								&& top2Part.endTypeRB == 1)) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeRB = 3;
					top2Part.endTypeRB = 3;
					top3Part.endTypeLT = 2;
					top3Part.endTypeLTByUser = false;
					top2Part.endTypeRBByUser = false;

				} else if (myFrame2.mySeries.getSeriesUom() > 1
						&& (top2Part.partDimBi != top3Part.partDimBi || top2Part.partDimAi != top3Part.partDimAi
								&& top2Part.endTypeRB == 1)) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeRB = 3;
					top2Part.endTypeRB = 3;
					top3Part.endTypeLT = 2;
					top3Part.endTypeLTByUser = false;
					top2Part.endTypeRBByUser = false;

				}
			}

			if (myFrame2.mySeries.getSeriesUom() == 1
					&& (top2Part.partDimB != rightPart.partDimB || top2Part.partDimA != rightPart.partDimA
							&& top2Part.endTypeLT == 1)) {
				JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
						+ "Appropriate End Types will be set.",
						"End Type Conflict - Warning!",
						JOptionPane.WARNING_MESSAGE);
				((Profiles) P).endTypeLT = 3;
				top2Part.endTypeLT = 3;
				rightPart.endTypeRB = 2;
				rightPart.endTypeRBByUser = false;
				top2Part.endTypeLTByUser = false;
			} else if (myFrame2.mySeries.getSeriesUom() > 1
					&& (top2Part.partDimBi != rightPart.partDimBi || top2Part.partDimAi != rightPart.partDimAi
							&& top2Part.endTypeLT == 1)) {
				JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
						+ "Appropriate End Types will be set.",
						"End Type Conflict - Warning!",
						JOptionPane.WARNING_MESSAGE);
				((Profiles) P).endTypeLT = 3;
				top2Part.endTypeLT = 3;
				rightPart.endTypeRB = 2;
				rightPart.endTypeRBByUser = false;
				top2Part.endTypeLTByUser = false;
			}

		} else if (((Profiles) P).position == 3) {
			top3Part.partID = ((Profiles) P).partID;
			top3Part.partDimB = ((Profiles) P).partDimB;
			top3Part.partDimM = ((Profiles) P).partDimM;
			top3Part.partDimA = ((Profiles) P).partDimA;
			top3Part.partDimC = ((Profiles) P).partDimC;
			top3Part.endTypeRB = ((Profiles) P).endTypeRB;
			top3Part.endTypeLT = ((Profiles) P).endTypeLT;
			top3Part.partIDByUser = ((Profiles) P).partIDByUser;
			top3Part.endTypeRBByUser = ((Profiles) P).endTypeRBByUser;
			top3Part.endTypeLTByUser = ((Profiles) P).endTypeLTByUser;

			if (top3Part.endTypeRB == 1) {
				top1Part.endTypeLT = 1;

			} else if (top3Part.endTypeRB == 2) {
				top1Part.endTypeLT = 3;

			} else if (top3Part.endTypeRB == 3) {
				top1Part.endTypeLT = 2;

			}

			top1Part.endTypeLTByUser = true;

			if (top3Part.endTypeLT == 1) {
				top2Part.endTypeRB = 1;

			} else if (top3Part.endTypeLT == 2) {
				top2Part.endTypeRB = 3;

			} else if (top3Part.endTypeLT == 3) {
				top2Part.endTypeRB = 2;

			}

			top2Part.endTypeRBByUser = true;

			if (myFrame2.mySeries.getSeriesUom() == 1) {
				if (top3Part.partDimB != top1Part.partDimB
						|| top3Part.partDimA != top1Part.partDimA
						&& top3Part.endTypeRB == 1) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeRB = 3;
					top3Part.endTypeRB = 3;
					top1Part.endTypeLT = 2;
					top3Part.endTypeRBByUser = false;
					top1Part.endTypeLTByUser = false;
				}
				if (top3Part.partDimB != top2Part.partDimB
						|| top3Part.partDimA != top2Part.partDimA
						&& top3Part.endTypeRB == 1) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeLT = 3;
					top3Part.endTypeLT = 3;
					top2Part.endTypeRB = 2;
					top3Part.endTypeLTByUser = false;
					top2Part.endTypeRBByUser = false;

				}
			} else {
				if (top3Part.partDimBi != top1Part.partDimBi
						|| top3Part.partDimAi != top1Part.partDimAi
						&& top3Part.endTypeRB == 1) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeRB = 3;
					top3Part.endTypeRB = 3;
					top1Part.endTypeLT = 2;
					top3Part.endTypeRBByUser = false;
					top1Part.endTypeLTByUser = false;
				}
				if (top3Part.partDimBi != top2Part.partDimBi
						|| top3Part.partDimAi != top2Part.partDimAi
						&& top3Part.endTypeRB == 1) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeLT = 3;
					top3Part.endTypeLT = 3;
					top2Part.endTypeRB = 2;
					top3Part.endTypeLTByUser = false;
					top2Part.endTypeRBByUser = false;

				}
			}

		}

		setUserEndTypesPart();
	}

	public void changeVerifyEndTypesBotP(final Object P,
			final boolean rchanged, final boolean lchanged) {

		if (((Profiles) P).position == 5 && noSidesBot == 1) {
			bot1Part.partID = ((Profiles) P).partID;
			bot1Part.partDimB = ((Profiles) P).partDimB;
			bot1Part.partDimM = ((Profiles) P).partDimM;
			bot1Part.partDimA = ((Profiles) P).partDimA;
			bot1Part.partDimC = ((Profiles) P).partDimC;

			bot1Part.partDimBi = ((Profiles) P).partDimBi;
			bot1Part.partDimMi = ((Profiles) P).partDimMi;
			bot1Part.partDimAi = ((Profiles) P).partDimAi;
			bot1Part.partDimCi = ((Profiles) P).partDimCi;

			bot1Part.partIDByUser = ((Profiles) P).partIDByUser;

			if (lchanged) {
				bot1Part.endTypeLT = ((Profiles) P).endTypeLT;
				bot1Part.endTypeLTByUser = true;
			}
			if (rchanged) {
				bot1Part.endTypeRB = ((Profiles) P).endTypeRB;
				bot1Part.endTypeRBByUser = true;

			}
			if (bot1Part.endTypeRB == 1 && noSidesRight == 1) {
				rightPart.endTypeLT = 1;
				rightPart.endTypeLTByUser = true;
			}
			if (bot1Part.endTypeRB == 1 && noSidesRight == 0) {
				top1Part.endTypeLT = 1;
				top1Part.endTypeLTByUser = true;
			}
			if (bot1Part.endTypeRB == 2 && noSidesRight == 0) {
				if (noSidesTop == 1) {
					top1Part.endTypeLT = 3;
					top1Part.endTypeLTByUser = true;
				} else {
					top2Part.endTypeLT = 3;
					top2Part.endTypeLTByUser = true;
				}
			}
			if (bot1Part.endTypeRB == 3 && noSidesRight == 1) {
				rightPart.endTypeLT = 2;
				rightPart.endTypeLTByUser = true;
			}

			if (bot1Part.endTypeRB == 3 && noSidesRight == 0) {
				if (noSidesTop == 1) {
					top1Part.endTypeLT = 2;
					top1Part.endTypeLTByUser = true;
				} else {
					top2Part.endTypeLT = 2;
					top2Part.endTypeLTByUser = true;
				}
			}

			if (bot1Part.endTypeLT == 1) {
				leftPart.endTypeRB = 1;
				leftPart.endTypeRBByUser = true;
			}
			if (bot1Part.endTypeLT == 2 && noSidesLeft == 1) {
				leftPart.endTypeRB = 3;
				leftPart.endTypeRBByUser = true;
			}

			if (bot1Part.endTypeLT == 2 && noSidesLeft == 0) {
				top1Part.endTypeRB = 3;
				leftPart.endTypeRBByUser = true;
			}
			if (bot1Part.endTypeLT == 3 && noSidesLeft == 1) {
				leftPart.endTypeRB = 2;
				leftPart.endTypeRBByUser = true;
			}

			if (bot1Part.endTypeLT == 3 && noSidesLeft == 0) {
				top1Part.endTypeRB = 2;
				top1Part.endTypeRBByUser = true;
			}

			if (myFrame2.mySeries.getSeriesUom() == 1) {
				if (bot1Part.partDimB != rightPart.partDimB
						|| bot1Part.partDimA != rightPart.partDimA
						&& bot1Part.endTypeRB == 1) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeRB = 3;
					bot1Part.endTypeRB = 3;
					rightPart.endTypeLT = 2;
					bot1Part.endTypeRBByUser = false;
					rightPart.endTypeLTByUser = false;
				}
				if (bot1Part.partDimB != leftPart.partDimB
						|| bot1Part.partDimA != leftPart.partDimA
						&& bot1Part.endTypeLT == 1) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeLT = 3;
					bot1Part.endTypeLT = 3;
					leftPart.endTypeRB = 2;
					bot1Part.endTypeLTByUser = false;
					leftPart.endTypeRBByUser = false;
				}
			} else {
				if (bot1Part.partDimBi != rightPart.partDimBi
						|| bot1Part.partDimAi != rightPart.partDimAi
						&& bot1Part.endTypeRB == 1) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeRB = 3;
					bot1Part.endTypeRB = 3;
					rightPart.endTypeLT = 2;
					bot1Part.endTypeRBByUser = false;
					rightPart.endTypeLTByUser = false;
				}
				if (bot1Part.partDimBi != leftPart.partDimBi
						|| bot1Part.partDimAi != leftPart.partDimAi
						&& bot1Part.endTypeLT == 1) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeLT = 3;
					bot1Part.endTypeLT = 3;
					leftPart.endTypeRB = 2;
					bot1Part.endTypeLTByUser = false;
					leftPart.endTypeRBByUser = false;
				}
			}

		} else if (((Profiles) P).position == 1 && noSidesBot > 1) {
			bot1Part.partID = ((Profiles) P).partID;
			bot1Part.partDimB = ((Profiles) P).partDimB;
			bot1Part.partDimM = ((Profiles) P).partDimM;
			bot1Part.partDimA = ((Profiles) P).partDimA;
			bot1Part.partDimC = ((Profiles) P).partDimC;
			bot1Part.endTypeRB = ((Profiles) P).endTypeRB;
			bot1Part.endTypeLT = ((Profiles) P).endTypeLT;
			bot1Part.partIDByUser = ((Profiles) P).partIDByUser;
			bot1Part.endTypeLTByUser = ((Profiles) P).endTypeLTByUser;
			bot1Part.endTypeRBByUser = ((Profiles) P).endTypeRBByUser;

			if (noSidesBot == 2) {

				if (bot1Part.endTypeRB == 1 && noSidesRight == 1) {
					rightPart.endTypeLT = 1;
					rightPart.endTypeLTByUser = true;
				}
				if (bot1Part.endTypeRB == 1 && noSidesRight == 0) {
					top1Part.endTypeLT = 1;
					top1Part.endTypeLTByUser = true;
				}
				if (bot1Part.endTypeRB == 2 && noSidesRight == 0) {
					if (noSidesTop == 1) {
						top1Part.endTypeLT = 3;
						top1Part.endTypeLTByUser = true;
					} else {
						top2Part.endTypeLT = 3;
						top2Part.endTypeLTByUser = true;
					}
				}
				if (bot1Part.endTypeRB == 3 && noSidesRight == 1) {
					rightPart.endTypeLT = 2;
					rightPart.endTypeLTByUser = true;
				}

				if (bot1Part.endTypeRB == 3 && noSidesRight == 0) {
					if (noSidesTop == 1) {
						top1Part.endTypeLT = 2;
						top1Part.endTypeLTByUser = true;
					} else {
						top2Part.endTypeLT = 2;
						top2Part.endTypeLTByUser = true;
					}
				}

				if (bot1Part.endTypeLT == 1) {
					bot2Part.endTypeRB = 1;
				}
				if (bot1Part.endTypeLT == 2) {
					bot2Part.endTypeRB = 3;
				}
				if (bot1Part.endTypeLT == 3) {
					bot2Part.endTypeRB = 2;
				}

				bot2Part.endTypeRBByUser = true;

				if (myFrame2.mySeries.getSeriesUom() == 1) {
					if (bot1Part.partDimB != bot2Part.partDimB
							|| bot1Part.partDimA != bot2Part.partDimA
							&& bot1Part.endTypeLT == 1) {
						JOptionPane.showMessageDialog(null,
								"End Type Conflict! \n"
										+ "Appropriate End Types will be set.",
								"End Type Conflict - Warning!",
								JOptionPane.WARNING_MESSAGE);
						((Profiles) P).endTypeLT = 3;
						bot1Part.endTypeLT = 3;
						bot2Part.endTypeRB = 2;
						bot1Part.endTypeLTByUser = false;
						bot2Part.endTypeRBByUser = false;
					}

					if (bot1Part.partDimB != rightPart.partDimB
							|| bot1Part.partDimA != rightPart.partDimA
							&& bot1Part.endTypeLT == 1) {
						JOptionPane.showMessageDialog(null,
								"End Type Conflict! \n"
										+ "Appropriate End Types will be set.",
								"End Type Conflict - Warning!",
								JOptionPane.WARNING_MESSAGE);
						((Profiles) P).endTypeRB = 3;
						bot1Part.endTypeRB = 3;
						rightPart.endTypeLT = 2;
						bot1Part.endTypeRBByUser = false;
						rightPart.endTypeLTByUser = false;
					}
				} else {
					if (bot1Part.partDimBi != bot2Part.partDimBi
							|| bot1Part.partDimAi != bot2Part.partDimAi
							&& bot1Part.endTypeLT == 1) {
						JOptionPane.showMessageDialog(null,
								"End Type Conflict! \n"
										+ "Appropriate End Types will be set.",
								"End Type Conflict - Warning!",
								JOptionPane.WARNING_MESSAGE);
						((Profiles) P).endTypeLT = 3;
						bot1Part.endTypeLT = 3;
						bot2Part.endTypeRB = 2;
						bot1Part.endTypeLTByUser = false;
						bot2Part.endTypeRBByUser = false;
					}

					if (bot1Part.partDimBi != rightPart.partDimBi
							|| bot1Part.partDimAi != rightPart.partDimAi
							&& bot1Part.endTypeLT == 1) {
						JOptionPane.showMessageDialog(null,
								"End Type Conflict! \n"
										+ "Appropriate End Types will be set.",
								"End Type Conflict - Warning!",
								JOptionPane.WARNING_MESSAGE);
						((Profiles) P).endTypeRB = 3;
						bot1Part.endTypeRB = 3;
						rightPart.endTypeLT = 2;
						bot1Part.endTypeRBByUser = false;
						rightPart.endTypeLTByUser = false;
					}
				}

			} else if (noSidesTop == 3) {
				if (bot1Part.endTypeLT == 1) {
					bot3Part.endTypeRB = 1;
				}
				if (bot1Part.endTypeLT == 2) {
					bot3Part.endTypeRB = 3;
				}
				if (bot1Part.endTypeLT == 3) {
					bot3Part.endTypeRB = 2;
				}

				bot3Part.endTypeRBByUser = true;

				if (bot1Part.endTypeLT == 1) {
					bot2Part.endTypeRB = 1;
				}
				if (bot1Part.endTypeLT == 2) {
					bot2Part.endTypeRB = 3;
				}
				if (bot1Part.endTypeLT == 3) {
					bot2Part.endTypeRB = 2;
				}

				bot2Part.endTypeLTByUser = true;

				if (myFrame2.mySeries.getSeriesUom() == 1) {
					if (bot1Part.partDimB != bot2Part.partDimB
							|| bot1Part.partDimA != bot2Part.partDimA
							&& bot1Part.endTypeLT == 1) {
						JOptionPane.showMessageDialog(null,
								"End Type Conflict! \n"
										+ "Appropriate End Types will be set.",
								"End Type Conflict - Warning!",
								JOptionPane.WARNING_MESSAGE);
						((Profiles) P).endTypeLT = 3;
						bot1Part.endTypeLT = 3;
						bot2Part.endTypeRB = 2;

						bot1Part.endTypeLTByUser = false;
						bot2Part.endTypeRBByUser = false;
					}
					if (bot1Part.partDimB != bot3Part.partDimB
							|| bot1Part.partDimA != bot3Part.partDimA
							&& bot1Part.endTypeLT == 1) {
						JOptionPane.showMessageDialog(null,
								"End Type Conflict! \n"
										+ "Appropriate End Types will be set.",
								"End Type Conflict - Warning!",
								JOptionPane.WARNING_MESSAGE);
						((Profiles) P).endTypeLT = 3;
						bot1Part.endTypeLT = 3;
						bot3Part.endTypeRB = 2;

						bot1Part.endTypeLTByUser = false;
						bot3Part.endTypeRBByUser = false;
					}
				} else {
					if (bot1Part.partDimBi != bot2Part.partDimBi
							|| bot1Part.partDimAi != bot2Part.partDimAi
							&& bot1Part.endTypeLT == 1) {
						JOptionPane.showMessageDialog(null,
								"End Type Conflict! \n"
										+ "Appropriate End Types will be set.",
								"End Type Conflict - Warning!",
								JOptionPane.WARNING_MESSAGE);
						((Profiles) P).endTypeLT = 3;
						bot1Part.endTypeLT = 3;
						bot2Part.endTypeRB = 2;

						bot1Part.endTypeLTByUser = false;
						bot2Part.endTypeRBByUser = false;
					}
					if (bot1Part.partDimBi != bot3Part.partDimBi
							|| bot1Part.partDimAi != bot3Part.partDimAi
							&& bot1Part.endTypeLT == 1) {
						JOptionPane.showMessageDialog(null,
								"End Type Conflict! \n"
										+ "Appropriate End Types will be set.",
								"End Type Conflict - Warning!",
								JOptionPane.WARNING_MESSAGE);
						((Profiles) P).endTypeLT = 3;
						bot1Part.endTypeLT = 3;
						bot3Part.endTypeRB = 2;

						bot1Part.endTypeLTByUser = false;
						bot3Part.endTypeRBByUser = false;
					}
				}
			}

		} else if (((Profiles) P).position == 2 && noSidesBot > 1) {
			bot2Part.partID = ((Profiles) P).partID;
			bot2Part.partDimB = ((Profiles) P).partDimB;
			bot2Part.partDimM = ((Profiles) P).partDimM;
			bot2Part.partDimA = ((Profiles) P).partDimA;
			bot2Part.partDimC = ((Profiles) P).partDimC;
			bot2Part.endTypeRB = ((Profiles) P).endTypeRB;
			bot2Part.endTypeLT = ((Profiles) P).endTypeLT;

			bot2Part.partIDByUser = ((Profiles) P).partIDByUser;
			bot2Part.endTypeLTByUser = ((Profiles) P).endTypeLTByUser;
			bot2Part.endTypeRBByUser = ((Profiles) P).endTypeRBByUser;

			if (bot2Part.endTypeLT == 1 && noSidesLeft == 1) {
				leftPart.endTypeRB = 1;
				leftPart.endTypeRBByUser = true;
			} else if (bot2Part.endTypeLT == 2 && noSidesLeft == 1) {
				leftPart.endTypeRB = 3;
				leftPart.endTypeRBByUser = true;
			} else if (bot2Part.endTypeLT == 3 && noSidesLeft == 1) {
				leftPart.endTypeRB = 2;
				leftPart.endTypeRBByUser = true;
			}

			leftPart.endTypeRBByUser = true;

			if (bot2Part.endTypeLT == 1 && noSidesLeft == 0) {
				top1Part.endTypeRB = 1;
				top1Part.endTypeRBByUser = true;
			} else if (bot2Part.endTypeLT == 2 && noSidesLeft == 0) {
				top1Part.endTypeRB = 3;
				top1Part.endTypeRBByUser = true;
			} else if (bot2Part.endTypeLT == 3 && noSidesLeft == 0) {
				top1Part.endTypeRB = 2;
				top1Part.endTypeRBByUser = true;
			}

			if (noSidesBot >= 2) {
				if (bot2Part.endTypeRB == 1) {
					bot1Part.endTypeLT = 1;

				} else if (bot2Part.endTypeRB == 2) {
					bot1Part.endTypeLT = 3;
				} else if (bot2Part.endTypeRB == 3) {
					bot1Part.endTypeLT = 2;
				}

				bot1Part.endTypeLTByUser = true;

				if (myFrame2.mySeries.getSeriesUom() == 1
						&& (bot2Part.partDimB != bot1Part.partDimB || bot2Part.partDimA != bot1Part.partDimA
								&& bot2Part.endTypeRB == 1)) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeRB = 3;
					bot2Part.endTypeRB = 3;
					bot1Part.endTypeLT = 2;
					bot2Part.endTypeRBByUser = false;
					bot1Part.endTypeLTByUser = false;
				} else if (myFrame2.mySeries.getSeriesUom() > 1
						&& (bot2Part.partDimBi != bot1Part.partDimBi || bot2Part.partDimAi != bot1Part.partDimAi
								&& bot2Part.endTypeRB == 1)) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeRB = 3;
					bot2Part.endTypeRB = 3;
					bot1Part.endTypeLT = 2;
					bot2Part.endTypeRBByUser = false;
					bot1Part.endTypeLTByUser = false;
				}

			}

			if (myFrame2.mySeries.getSeriesUom() == 1
					&& (bot2Part.partDimB != leftPart.partDimB || bot2Part.partDimA != leftPart.partDimA
							&& bot2Part.endTypeLT == 1)) {
				JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
						+ "Appropriate End Types will be set.",
						"End Type Conflict - Warning!",
						JOptionPane.WARNING_MESSAGE);
				((Profiles) P).endTypeLT = 3;

				bot2Part.endTypeLT = 3;
				leftPart.endTypeRB = 2;

				bot2Part.endTypeLTByUser = false;
				leftPart.endTypeRBByUser = false;
			} else if (myFrame2.mySeries.getSeriesUom() > 1
					&& (bot2Part.partDimBi != leftPart.partDimBi || bot2Part.partDimAi != leftPart.partDimAi
							&& bot2Part.endTypeLT == 1)) {
				JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
						+ "Appropriate End Types will be set.",
						"End Type Conflict - Warning!",
						JOptionPane.WARNING_MESSAGE);
				((Profiles) P).endTypeLT = 3;

				bot2Part.endTypeLT = 3;
				leftPart.endTypeRB = 2;

				bot2Part.endTypeLTByUser = false;
				leftPart.endTypeRBByUser = false;

			}

		} else if (((Profiles) P).position == 3) {
			bot3Part.partID = ((Profiles) P).partID;
			bot3Part.partDimB = ((Profiles) P).partDimB;
			bot3Part.partDimM = ((Profiles) P).partDimM;
			bot3Part.partDimA = ((Profiles) P).partDimA;
			bot3Part.partDimC = ((Profiles) P).partDimC;
			bot3Part.endTypeRB = ((Profiles) P).endTypeRB;
			bot3Part.endTypeLT = ((Profiles) P).endTypeLT;

			bot3Part.partIDByUser = ((Profiles) P).partIDByUser;
			bot3Part.endTypeLTByUser = ((Profiles) P).endTypeLTByUser;
			bot3Part.endTypeRBByUser = ((Profiles) P).endTypeRBByUser;

			if (bot3Part.endTypeRB == 1 && noSidesRight == 1) {
				rightPart.endTypeLT = 1;
				rightPart.endTypeLTByUser = true;
			} else if (bot3Part.endTypeRB == 2 && noSidesRight == 1) {
				rightPart.endTypeLT = 3;
				rightPart.endTypeLTByUser = true;

			} else if (bot3Part.endTypeRB == 3 && noSidesRight == 1) {
				rightPart.endTypeLT = 2;
				rightPart.endTypeLTByUser = true;
			}
			if (noSidesRight == 0 && noSidesTop == 1) {
				if (bot3Part.endTypeRB == 1) {
					top1Part.endTypeLT = 1;
				} else if (bot3Part.endTypeRB == 2) {
					top1Part.endTypeLT = 3;
				} else if (bot3Part.endTypeRB == 3) {
					top1Part.endTypeLT = 2;
				}
				top1Part.endTypeLTByUser = true;
			}
			if (noSidesRight == 0 && noSidesTop == 2) {
				if (bot3Part.endTypeRB == 1) {
					top2Part.endTypeLT = 1;
				} else if (bot3Part.endTypeRB == 2) {
					top2Part.endTypeLT = 3;
				} else if (bot3Part.endTypeRB == 3) {
					top2Part.endTypeLT = 2;
				}
				top2Part.endTypeLTByUser = true;
			}

			if (bot3Part.endTypeLT == 1) {
				bot1Part.endTypeRB = 1;
			} else if (bot3Part.endTypeLT == 2) {
				bot1Part.endTypeRB = 3;
			} else if (bot3Part.endTypeLT == 3) {
				bot1Part.endTypeRB = 2;
			}

			bot1Part.endTypeRBByUser = true;

			if (myFrame2.mySeries.getSeriesUom() == 1) {
				if (bot3Part.partDimB != rightPart.partDimB
						|| bot3Part.partDimA != rightPart.partDimA
						&& bot3Part.endTypeRB == 1) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeRB = 3;
					bot3Part.endTypeRB = 3;
					rightPart.endTypeLT = 2;

					bot3Part.endTypeRBByUser = false;
					rightPart.endTypeLTByUser = false;

				}
				if (bot3Part.partDimB != bot1Part.partDimB
						|| bot3Part.partDimA != bot1Part.partDimA
						&& bot3Part.endTypeRB == 1) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeLT = 3;
					bot3Part.endTypeLT = 3;
					bot1Part.endTypeRB = 2;

					bot3Part.endTypeLTByUser = false;
					bot1Part.endTypeRBByUser = false;

				}
			} else {
				if (bot3Part.partDimBi != rightPart.partDimBi
						|| bot3Part.partDimAi != rightPart.partDimAi
						&& bot3Part.endTypeRB == 1) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeRB = 3;
					bot3Part.endTypeRB = 3;
					rightPart.endTypeLT = 2;

					bot3Part.endTypeRBByUser = false;
					rightPart.endTypeLTByUser = false;

				}
				if (bot3Part.partDimBi != bot1Part.partDimBi
						|| bot3Part.partDimAi != bot1Part.partDimAi
						&& bot3Part.endTypeRB == 1) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeLT = 3;
					bot3Part.endTypeLT = 3;
					bot1Part.endTypeRB = 2;

					bot3Part.endTypeLTByUser = false;
					bot1Part.endTypeRBByUser = false;

				}
			}

		}

		// CreateShapeMethods createShape = new
		// CreateShapeMethods(this.myParentO, 2, myFrame2);

		setUserEndTypesPart();

	}

	public void changeVerifyEndTypesLeftP(final Object P) {

		if (((Profiles) P).position == 8) {
			leftPart.partID = ((Profiles) P).partID;

			leftPart.partDimB = ((Profiles) P).partDimB;
			leftPart.partDimM = ((Profiles) P).partDimM;
			leftPart.partDimA = ((Profiles) P).partDimA;
			leftPart.partDimC = ((Profiles) P).partDimC;

			leftPart.partDimBi = ((Profiles) P).partDimBi;
			leftPart.partDimMi = ((Profiles) P).partDimMi;
			leftPart.partDimAi = ((Profiles) P).partDimAi;
			leftPart.partDimCi = ((Profiles) P).partDimCi;

			leftPart.endTypeLT = ((Profiles) P).endTypeLT;
			leftPart.endTypeRB = ((Profiles) P).endTypeRB;

			leftPart.partIDByUser = ((Profiles) P).partIDByUser;
			leftPart.endTypeLTByUser = ((Profiles) P).endTypeLTByUser;
			leftPart.endTypeRBByUser = ((Profiles) P).endTypeRBByUser;

			if (noSidesBot == 1) {
				if (leftPart.endTypeRB == 1) {
					bot1Part.endTypeLT = 1;

				}
				if (leftPart.endTypeRB == 2) {
					bot1Part.endTypeLT = 3;
				}
				if (leftPart.endTypeRB == 3) {
					bot1Part.endTypeLT = 2;
				}

				bot1Part.endTypeLTByUser = true;

				if (myFrame2.mySeries.getSeriesUom() == 1
						&& (leftPart.partDimB != bot1Part.partDimB || leftPart.partDimA != bot1Part.partDimA
								&& leftPart.endTypeRB == 1)) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeRB = 3;
					leftPart.endTypeRB = 3;
					bot1Part.endTypeLT = 2;

					leftPart.endTypeRBByUser = false;
					bot1Part.endTypeLTByUser = false;
				} else if (myFrame2.mySeries.getSeriesUom() > 1
						&& (leftPart.partDimBi != bot1Part.partDimBi || leftPart.partDimAi != bot1Part.partDimAi
								&& leftPart.endTypeRB == 1)) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeRB = 3;
					leftPart.endTypeRB = 3;
					bot1Part.endTypeLT = 2;

					leftPart.endTypeRBByUser = false;
					bot1Part.endTypeLTByUser = false;
				}
			}
			if (noSidesBot > 1) {
				if (leftPart.endTypeRB == 1) {
					bot2Part.endTypeLT = 1;

				}
				if (leftPart.endTypeRB == 2) {
					bot2Part.endTypeLT = 3;
				}
				if (leftPart.endTypeRB == 3) {
					bot2Part.endTypeLT = 2;
				}
				bot2Part.endTypeLTByUser = true;
				if (myFrame2.mySeries.getSeriesUom() == 1
						&& (leftPart.partDimB != bot2Part.partDimB || leftPart.partDimA != bot2Part.partDimA
								&& leftPart.endTypeRB == 1)) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeRB = 3;
					leftPart.endTypeRB = 3;
					bot2Part.endTypeLT = 2;
					leftPart.endTypeRBByUser = false;
					bot2Part.endTypeLTByUser = false;
				} else if (myFrame2.mySeries.getSeriesUom() > 1
						&& (leftPart.partDimBi != bot2Part.partDimBi || leftPart.partDimAi != bot2Part.partDimAi
								&& leftPart.endTypeRB == 1)) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeRB = 3;
					leftPart.endTypeRB = 3;
					bot2Part.endTypeLT = 2;
					leftPart.endTypeRBByUser = false;
					bot2Part.endTypeLTByUser = false;
				}
			}
			if (leftPart.endTypeLT == 1) {
				top1Part.endTypeRB = 1;
			}
			if (leftPart.endTypeLT == 2) {
				top1Part.endTypeRB = 3;
			}
			if (leftPart.endTypeLT == 3) {
				top1Part.endTypeRB = 2;
			}
			top1Part.endTypeRBByUser = true;

			if (myFrame2.mySeries.getSeriesUom() == 1
					&& (leftPart.partDimB != top1Part.partDimB || leftPart.partDimA != top1Part.partDimA
							&& leftPart.endTypeLT == 1)) {
				JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
						+ "Appropriate End Types will be set.",
						"End Type Conflict - Warning!",
						JOptionPane.WARNING_MESSAGE);
				((Profiles) P).endTypeLT = 3;
				leftPart.endTypeLT = 3;
				top1Part.endTypeRB = 2;
				leftPart.endTypeLTByUser = false;
				top1Part.endTypeRBByUser = false;
			} else if (myFrame2.mySeries.getSeriesUom() > 1
					&& (leftPart.partDimBi != top1Part.partDimBi || leftPart.partDimAi != top1Part.partDimAi
							&& leftPart.endTypeLT == 1)) {
				JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
						+ "Appropriate End Types will be set.",
						"End Type Conflict - Warning!",
						JOptionPane.WARNING_MESSAGE);
				((Profiles) P).endTypeLT = 3;
				leftPart.endTypeLT = 3;
				top1Part.endTypeRB = 2;
				leftPart.endTypeLTByUser = false;
				top1Part.endTypeRBByUser = false;
			}

		}

		setUserEndTypesPart();

	}

	public void changeVerifyEndTypesRightP(final Object P) {

		if (((Profiles) P).position == 4) {
			rightPart.partID = ((Profiles) P).partID;

			rightPart.partDimB = ((Profiles) P).partDimB;
			rightPart.partDimM = ((Profiles) P).partDimM;
			rightPart.partDimA = ((Profiles) P).partDimA;
			rightPart.partDimC = ((Profiles) P).partDimC;

			rightPart.partDimBi = ((Profiles) P).partDimBi;
			rightPart.partDimMi = ((Profiles) P).partDimMi;
			rightPart.partDimAi = ((Profiles) P).partDimAi;
			rightPart.partDimCi = ((Profiles) P).partDimCi;

			rightPart.endTypeLT = ((Profiles) P).endTypeLT;
			rightPart.endTypeRB = ((Profiles) P).endTypeRB;

			rightPart.partIDByUser = ((Profiles) P).partIDByUser;
			rightPart.endTypeLTByUser = ((Profiles) P).endTypeLTByUser;
			rightPart.endTypeRBByUser = ((Profiles) P).endTypeRBByUser;

			if (noSidesBot == 1) {
				if (rightPart.endTypeLT == 1) {
					bot1Part.endTypeRB = 1;
				}
				if (rightPart.endTypeLT == 2) {
					bot1Part.endTypeRB = 3;
				}
				if (rightPart.endTypeLT == 3) {
					bot1Part.endTypeRB = 2;
				}

				bot1Part.endTypeRBByUser = false;

				if (myFrame2.mySeries.getSeriesUom() == 1
						&& (rightPart.partDimB != bot1Part.partDimB || rightPart.partDimA != bot1Part.partDimA
								&& rightPart.endTypeLT == 1)) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeLT = 3;
					rightPart.endTypeLT = 3;
					bot1Part.endTypeRB = 2;

					rightPart.endTypeLTByUser = false;
					bot1Part.endTypeRBByUser = false;
				} else if (myFrame2.mySeries.getSeriesUom() > 1
						&& (rightPart.partDimBi != bot1Part.partDimBi || rightPart.partDimAi != bot1Part.partDimAi
								&& rightPart.endTypeLT == 1)) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeLT = 3;
					rightPart.endTypeLT = 3;
					bot1Part.endTypeRB = 2;

					rightPart.endTypeLTByUser = false;
					bot1Part.endTypeRBByUser = false;
				}
			}
			if (noSidesBot == 3) {
				if (rightPart.endTypeLT == 1) {
					bot3Part.endTypeRB = 1;
				}
				if (rightPart.endTypeLT == 2) {
					bot3Part.endTypeRB = 3;
				}
				if (rightPart.endTypeLT == 3) {
					bot3Part.endTypeRB = 2;
				}
				bot3Part.endTypeRBByUser = true;

				if (myFrame2.mySeries.getSeriesUom() == 1
						&& (rightPart.partDimB != bot3Part.partDimB || rightPart.partDimA != bot3Part.partDimA
								&& rightPart.endTypeLT == 1)) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeLT = 3;
					rightPart.endTypeLT = 3;
					bot3Part.endTypeRB = 2;

					rightPart.endTypeLTByUser = false;
					bot3Part.endTypeRBByUser = false;
				} else if (myFrame2.mySeries.getSeriesUom() > 1
						&& (rightPart.partDimBi != bot3Part.partDimBi || rightPart.partDimAi != bot3Part.partDimAi
								&& rightPart.endTypeLT == 1)) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeLT = 3;
					rightPart.endTypeLT = 3;
					bot3Part.endTypeRB = 2;

					rightPart.endTypeLTByUser = false;
					bot3Part.endTypeRBByUser = false;
				}
			}

			if (noSidesTop == 1) {

				if (rightPart.endTypeRB == 1) {
					top1Part.endTypeLT = 1;
				}
				if (rightPart.endTypeRB == 2) {
					top1Part.endTypeLT = 3;
				}
				if (rightPart.endTypeRB == 3) {
					top1Part.endTypeLT = 2;
				}
				top1Part.endTypeLTByUser = true;

				if (myFrame2.mySeries.getSeriesUom() == 1
						&& (rightPart.partDimB != top1Part.partDimB || rightPart.partDimA != top1Part.partDimA
								&& rightPart.endTypeRB == 1)) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeRB = 3;
					rightPart.endTypeRB = 3;
					top1Part.endTypeLT = 2;

					top1Part.endTypeLTByUser = false;
					rightPart.endTypeRBByUser = false;
				} else if (myFrame2.mySeries.getSeriesUom() > 1
						&& (rightPart.partDimBi != top1Part.partDimBi || rightPart.partDimAi != top1Part.partDimAi
								&& rightPart.endTypeRB == 1)) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeRB = 3;
					rightPart.endTypeRB = 3;
					top1Part.endTypeLT = 2;

					top1Part.endTypeLTByUser = false;
					rightPart.endTypeRBByUser = false;
				}
			}
			if (noSidesTop > 1) {
				if (rightPart.endTypeRB == 1) {
					top2Part.endTypeLT = 1;
				}
				if (rightPart.endTypeRB == 2) {
					top2Part.endTypeLT = 3;
				}
				if (rightPart.endTypeRB == 3) {
					top2Part.endTypeLT = 2;
				}
				top2Part.endTypeLTByUser = true;

				if (myFrame2.mySeries.getSeriesUom() == 1
						&& (rightPart.partDimB != top2Part.partDimB || rightPart.partDimA != top2Part.partDimA
								&& rightPart.endTypeRB == 1)) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeRB = 3;
					rightPart.endTypeRB = 3;
					top2Part.endTypeLT = 2;

					top2Part.endTypeLTByUser = false;
					rightPart.endTypeRBByUser = false;
				} else if (myFrame2.mySeries.getSeriesUom() > 1
						&& (rightPart.partDimBi != top2Part.partDimBi || rightPart.partDimAi != top2Part.partDimAi
								&& rightPart.endTypeRB == 1)) {
					JOptionPane.showMessageDialog(null, "End Type Conflict! \n"
							+ "Appropriate End Types will be set.",
							"End Type Conflict - Warning!",
							JOptionPane.WARNING_MESSAGE);
					((Profiles) P).endTypeRB = 3;
					rightPart.endTypeRB = 3;
					top2Part.endTypeLT = 2;

					top2Part.endTypeLTByUser = false;
					rightPart.endTypeRBByUser = false;
				}
			}

		}

		setUserEndTypesPart();
	}

	public void setUserEndTypesPart() {

		top1 = (Top1Object) top1.cloneProfile(top1Part);
		top2 = (Top2Object) top2.cloneProfile(top2Part);
		top3 = (Top3Object) top3.cloneProfile(top3Part);

		bot1 = (Bot1Object) bot1.cloneProfile(bot1Part);
		bot2 = (Bot2Object) bot2.cloneProfile(bot2Part);
		bot3 = (Bot3Object) bot3.cloneProfile(bot3Part);

		left = (LeftObject) left.cloneProfile(leftPart);

		right = (RightObject) right.cloneProfile(rightPart);

	}

	public void addDivider(final int x, final int y, final int colORrow, // orientation
			// 1V 2H
			final int type, // 1 Coupler 2 Mullion 0
			// FacetDivide
			final int typeNo, // ?? coupler/ mullion /
			// grid?
			final int pos, final boolean doCheck, final Profiles exist)
			throws Exception // Mid
	// =
	// 2,
	// In
	// =
	// 3,
	// Out =
	// 1
	{

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}
		newDesign = false;
		top1.topFillShape.reset();
		top1.topObjectPath.reset();

		if (x <= bX2 && x >= startingX && y > startingY && y < bY4) {

			this.reInitDraw();

			if (colORrow == 1) {

				final AddMullionV addMullionV = new AddMullionV(
						myFrame2.jobItem.design.bOpeningObject,
						myFrame2.jobItem, myFrame2, 1);

				addMullionV.getProfileDims(null);

				double myTotalMCThick = addMullionV.thickness;

				myTotalMCThick = myTotalMCThick + addMullionV.getTotalMCThick();
				Object[] returns = new Object[2];
				returns = checkOverallWidth(UOMConvert.getBigDecimalConversion(
						myTotalMCThick, myScale, 2));
				boolean doRecalc = false;
				if (myFrame2.currentUOM == 1) {
					if ((Double) returns[1] != myFrame2.jobItem.design.widthM / 100) {
						doRecalc = true;
					}
				} else {
					if ((Double) returns[1] != myFrame2.jobItem.design.widthI) {
						doRecalc = true;
					}
				}
				if (doRecalc) {
					myFrame2.wEntered = false;
					myFrame2.doResetOverallSize((Double) returns[1], UOMConvert
							.getBigDecimalConversion(
									myFrame2.jobItem._HEIGHTpix, myScale, 2),
							myFrame2.jobItem.design, 0, true, false);
				}

				myFrame2.resetModTextsV = true;

				myFrame2.jobItem.design = myFrame2.jobItem.design
						.doAddDividerV(x, y, pos, 1);

				Object[] myMs = myFrame2.jobItem.design.bOpeningObject.mullions
						.toArray();

				final double[] deltas = new double[myMs.length];
				int count = 0;
				for (final Object m : myMs) {
					if (((Profiles) m).exists == 1) {
						deltas[count] = ((Profiles) m).centerXs;
						count++;
					}

				}

				Arrays.sort(deltas);

				myMs = myFrame2.jobItem.design.bOpeningObject.mullions
						.toArray();
				myFrame2.jobItem.design.bOpeningObject.mullions.clear();
				int order = 1;
				for (final Object d : deltas) {
					for (final Object m : myMs) {

						if (Double.parseDouble(d.toString()) == ((Profiles) m).centerXs) {
							((Profiles) m).order = order;
							order++;
							myFrame2.jobItem.design.bOpeningObject.mullions
									.add(m);
						}

					}
				}

				myMs = myFrame2.jobItem.design.bOpeningObject.mullions
						.toArray();
			} else if (colORrow == 2) {
				myFrame2.resetModTextsH = true;
				myFrame2.jobItem.design.doAddDividerH(x, y, typeNo, pos, 1,
						myFrame2.jobItem.design);

			}

		} else {
			// error Message
		}

		xCols = bOpeningObject.xCols;
		yRows = bOpeningObject.yRows;

		myFrame2.jobItem.myCanvas.selectedRadioForCol = 1;
		myFrame2.jobItem.myCanvas.selectedRadioForRow = 1;

		if (type != 0) {

			this.reDrawRadioRowCol(bOpeningObject.yRows, bOpeningObject.xCols,
					1, myFrame2.jobItem.myCanvas.selectedRadioForRow,
					myFrame2.jobItem.myCanvas.selectedRadioForCol, this);
		}

	}

	/**
	 * Adding coupler or mullion to shape object
	 * 
	 * @param x
	 *            , Axis x position
	 * @param y
	 *            , Axis y position
	 * @param orientation
	 *            , Vertical or horizontal position
	 * @param type
	 *            , Coupler or mullion
	 * @param typeNo
	 * @param pos
	 *            , WhichPos added
	 * @param doCheck
	 *            , Do check
	 * @param profile
	 *            , ProfilePart
	 * @param myOpening
	 *            , OpeningObject
	 */
	public void addCouplerMullion(int x, int y, int orientation, int type,
			int typeNo, int pos, boolean doCheck, Profiles profile,
			OpeningObject myOpening) throws Exception {

		this.addCoupler = true;

		Object[] returns = new Object[2];
		returns[0] = 0.0;
		double myTotalMCThick = 0;
		boolean autoWH = ApplicationBaseApp.getInstance()
				.getCompanyPreferences().isVerifyOverallWh();
		boolean newPosition = false;

		boolean startIn = false;
		boolean endIn = false;

		int startC = 0;
		int startR = 0;
		int endC = 0;
		int endR = 0;

		boolean wChange = false;
		boolean hChange = false;

		double ovW = UOMConvert.getBigDecimalConversion(
				myFrame2.facetUsed.widthPix, myScale, 2);
		double ovH = UOMConvert.getBigDecimalConversion(
				myFrame2.facetUsed.heightPix, myScale, 2);

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100)).setScale(20,
					BigDecimal.ROUND_UP);
		} else {
			myScale = myFrame2.scale;
		}

		newDesign = false;
		top1.topFillShape.reset();
		top1.topObjectPath.reset();

		if (x <= bX2 && x >= startingX && y > highestY && y < lowestY) {

			// this.reInitDraw();

			if (type == ValidCouplerMullions.COUPLER.getValue()) {

				if (orientation == ValidOrientations.VERTICAL.getValue()) {

					// Initialize coupler mullion vertical
					AddMullionV addMullionV = new AddMullionV(
							this.myFrame2.facetUsed.bOpeningObject,
							this.myFrame2.jobItem, this.myFrame2, 1);

					// Get coupler part dimensions
					addMullionV.getProfileDims(null);

					// Check if already exist coupler
					addMullionV.alreadyExistii(x, y);

					startR = addMullionV.vcStart;
					endR = addMullionV.vcEnd;

					if (addMullionV.alreadyExist == 1) {

						// Get coupler thick from selected Coupler
						if (myFrame2.mySeries.getSeriesUom() == 1) {
							myTotalMCThick = UOMConvert
									.getBigDecimalConversion(
											this.myFrame2.mullionsPanel
													.getCouplerMullionController()
													.getPartsSelected()
													.getDimb(),
											this.myFrame2.metricscale, 1);

						} else { // Get Thickness from chosen Feature
							myTotalMCThick = UOMConvert
									.getBigDecimalConversion(
											this.myFrame2.mullionsPanel
													.getCouplerMullionController()
													.getPartsSelected()
													.getDimbi(),
											this.myFrame2.imperialscale, 1);
						}

						Object[] mVs = myFrame2.facetUsed.bOpeningObject.mullions
								.toArray();

						for (Object element : mVs) { // TODO: Check calculation
														// of scale
							if (((Profiles) element).exists == 1) {

								if (this.myFrame2.mySeries.getSeriesUom() == 1) {
									myTotalMCThick = myTotalMCThick
											+ ((Profiles) element).partDimB;
								} else {
									myTotalMCThick = myTotalMCThick
											+ ((Profiles) element).partDimBi;
								}

							}
						}

						startIn = addMullionV.startIn;
						endIn = addMullionV.endIn;
						newPosition = true;

						// Check facet width

						returns = checkFacetWidth(UOMConvert
								.getBigDecimalConversion(myTotalMCThick,
										myScale, 2));

						// Destroy add mullion vertical operation
						addMullionV = null;

						myFrame2.wEntered = false;
						myFrame2.hEntered = false;

						boolean doChangeSize = false;

						BigDecimal mywidth = new BigDecimal((Double) returns[1])
								.divide(new BigDecimal("64"), 20,
										BigDecimal.ROUND_UP);

						if (mywidth.doubleValue() != (Double) returns[1]
								&& autoWH) {

							// JOptionPane.showMessageDialog(null,
							// "New Overall/Frame width will be calculated.",
							// "WARNING!",
							// JOptionPane.WARNING_MESSAGE);

							doChangeSize = true;

							if (doChangeSize) {

								wChange = true;

								if (this.myFrame2.currentUOM > 1) { // Imperial
																	// Unit of
																	// Measure

									// Calculate Width
									BigDecimal width = new BigDecimal(
											(Double) returns[1]).divide(
											new BigDecimal("64"), 20,
											BigDecimal.ROUND_UP);

									// Calculate Height
									BigDecimal height = new BigDecimal(
											UOMConvert
													.getBigDecimalConversion(
															this.myFrame2.jobItem._HEIGHTpix,
															myScale, 2))
											.divide(new BigDecimal("64"), 20,
													BigDecimal.ROUND_UP);

									// Reset Overall Size
									this.myFrame2.doResetOverallSize(
											width.doubleValue(),
											height.doubleValue(),
											this.myFrame2.jobItem.design, 0,
											true, false);

								} else { // Metric Unit of Measure

									// Calculate Width
									BigDecimal width = new BigDecimal(
											(Double) returns[1]).divide(
											new BigDecimal("100"), 20,
											BigDecimal.ROUND_UP);

									// Calculate Height
									BigDecimal height = new BigDecimal(
											UOMConvert
													.getBigDecimalConversion(
															this.myFrame2.jobItem._HEIGHTpix,
															myScale, 2))
											.divide(new BigDecimal("100"), 20,
													BigDecimal.ROUND_UP);

									// Reset Overall Size
									this.myFrame2.doResetOverallSize(
											width.doubleValue(),
											height.doubleValue(),
											this.myFrame2.jobItem.design, 0,
											true, false);
								}
							}
						}

						myFrame2.changeFacetW = false;
						myFrame2.changeFacetH = false;

						Object[] facets = myFrame2.jobItem.design.frames
								.toArray();

						for (Object facet : facets) {
							if (((Facet) facet).a_sequenceID == myFrame2.facetUsed.a_sequenceID) {
								myFrame2.facetUsed = (Facet) facet;
								break;
							}
						}

						if (myFrame2.myTopPanel.metric.isSelected()) {
							this.myScale = this.myFrame2.scale.multiply(
									new BigDecimal("100")).setScale(20,
									BigDecimal.ROUND_UP);
						} else {
							this.myScale = this.myFrame2.scale;
						}

						this.myFrame2.resetModTextsV = true;
						this.myFrame2.resetModTextsH = false;

						// Calculate Width
						BigDecimal calcW = new BigDecimal((Double) returns[0])
								.multiply(this.myScale).setScale(20,
										BigDecimal.ROUND_UP);

						// Add Coupler Mullion
						this.myFrame2.facetUsed.doAddC(x, y, pos, orientation,
								calcW.doubleValue(), 0, newPosition, startR,
								endR, startC, endC);

					} else if (addMullionV.alreadyExist > 1) {

						addMullionV = null;
						newPosition = false;

						// Calculate Width
						BigDecimal calcW = new BigDecimal((Double) returns[0])
								.multiply(this.myScale).setScale(20,
										BigDecimal.ROUND_UP);

						// Add Coupler Mullion
						myFrame2.facetUsed.doAddC(x, y, pos, orientation,
								calcW.doubleValue(), 0, newPosition, startR,
								endR, startC, endC);
					}

					myFrame2.wEntered = false;
					myFrame2.hEntered = false;
					myFrame2.resetModTextsV = false;
					myFrame2.resetModTextsH = false;

				} else if (orientation == ValidOrientations.HORIZONTAL
						.getValue()) {

					// Get coupler thick from parts selected
					myTotalMCThick = 0;

					// Initialize coupler mullion Horizontal
					AddMullionH addMullionH = new AddMullionH(
							myFrame2.facetUsed.bOpeningObject,
							myFrame2.jobItem, myFrame2, 1);

					// Get coupler horizontal parts dimensions
					addMullionH.getProfileDims(null);

					// Checking if alredy exist
					addMullionH.alreadyExistii(x, y);
					startC = addMullionH.hcStart;
					endC = addMullionH.hcEnd;
					if (addMullionH.alreadyExist == 1) {

						if (myFrame2.mySeries.getSeriesUom() == 1) {

							myTotalMCThick = UOMConvert
									.getBigDecimalConversion(
											myFrame2.mullionsPanel
													.getCouplerMullionController()
													.getPartsSelected()
													.getDimb(),
											myFrame2.metricscale, 1);

						} else {

							myTotalMCThick = UOMConvert
									.getBigDecimalConversion(
											myFrame2.mullionsPanel
													.getCouplerMullionController()
													.getPartsSelected()
													.getDimbi(),
											myFrame2.imperialscale, 1);

						}

						// **********************************************************************
						// Get H and calculate total thick
						// **********************************************************************

						Object[] mHs = myFrame2.facetUsed.bOpeningObject.mullionsH
								.toArray();

						for (Object element : mHs) {
							if (((Profiles) element).exists == 1) {
								myTotalMCThick = myTotalMCThick
										+ ((Profiles) element).partDimB;
							}
						}

						startIn = addMullionH.startIn;
						endIn = addMullionH.endIn;
						newPosition = true;

						// Checking facet height
						returns = checkFacetHeight(UOMConvert
								.getBigDecimalConversion(myTotalMCThick,
										myScale, 2));

						// Destroy add coupler mullion horizontal
						addMullionH = null;

						myFrame2.wEntered = false;
						myFrame2.hEntered = false;

						boolean doChangeSize = false;

						BigDecimal myheight = new BigDecimal(
								(Double) returns[1]).divide(
								new BigDecimal("64"), 20, BigDecimal.ROUND_UP);

						if (myheight.doubleValue() != (Double) returns[1]
								&& autoWH) {

							// JOptionPane.showMessageDialog(null,
							// "New Overall/Frame Height will be calculated.",
							// "WARNING!", JOptionPane.WARNING_MESSAGE);

							doChangeSize = true;

							if (doChangeSize) {
								hChange = true;

								if (myFrame2.currentUOM > 1) {

									// Calculate Width
									BigDecimal width = new BigDecimal(
											UOMConvert
													.getBigDecimalConversion(
															this.myFrame2.jobItem._WIDTHpix,
															myScale, 2))
											.divide(new BigDecimal("64"), 20,
													BigDecimal.ROUND_UP);

									// Calculate Height
									BigDecimal height = new BigDecimal(
											(Double) returns[1]).divide(
											new BigDecimal("64"), 20,
											BigDecimal.ROUND_UP);

									myFrame2.doResetOverallSize(
											width.doubleValue(),
											height.doubleValue(),
											this.myFrame2.jobItem.design, 0,
											true, false);

								} else {

									// Calculate Width
									BigDecimal width = new BigDecimal(
											UOMConvert
													.getBigDecimalConversion(
															this.myFrame2.jobItem._WIDTHpix,
															myScale, 2))
											.divide(new BigDecimal("100"), 20,
													BigDecimal.ROUND_UP);

									// Calculate Height
									BigDecimal height = new BigDecimal(
											(Double) returns[1]).divide(
											new BigDecimal("100"), 20,
											BigDecimal.ROUND_UP);

									myFrame2.doResetOverallSize(
											width.doubleValue(),
											height.doubleValue(),
											this.myFrame2.jobItem.design, 0,
											true, false);

								}
							}
						}

						myFrame2.changeFacetW = false;
						myFrame2.changeFacetH = false;

						myFrame2.resetModTextsH = true;
						myFrame2.resetModTextsV = false;

						Object[] facets = myFrame2.jobItem.design.frames
								.toArray();

						for (Object facet : facets) {
							if (((Facet) facet).a_sequenceID == myFrame2.facetUsed.a_sequenceID) {
								myFrame2.facetUsed = (Facet) facet;
								break;
							}
						}

						if (myFrame2.myTopPanel.metric.isSelected()) {
							myScale = myFrame2.scale.multiply(
									new BigDecimal(100)).setScale(20,
									BigDecimal.ROUND_UP);
						} else {
							myScale = myFrame2.scale;
						}

						// Calculate width
						BigDecimal width = new BigDecimal((Double) returns[0])
								.multiply(this.myScale).setScale(20,
										BigDecimal.ROUND_UP);

						// Add Coupler value
						this.myFrame2.facetUsed.doAddC(x, y, pos, orientation,
								0, width.doubleValue(), newPosition, startR,
								endR, startC, endC);

					} else if (addMullionH.alreadyExist > 1) {

						addMullionH = null;
						newPosition = false;

						// Calculate width
						BigDecimal width = new BigDecimal((Double) returns[0])
								.multiply(this.myScale).setScale(20,
										BigDecimal.ROUND_UP);

						// Add Coupler Value
						this.myFrame2.facetUsed.doAddC(x, y, pos, orientation,
								0, width.doubleValue(), newPosition, startR,
								endR, startC, endC);
					}

					myFrame2.wEntered = false;
					myFrame2.hEntered = false;
					myFrame2.resetModTextsV = false;
					myFrame2.resetModTextsH = false;
				}

			} else if (type == ValidCouplerMullions.MULLION.getValue()) {

				if (orientation == ValidOrientations.VERTICAL.getValue()) {
					myFrame2.resetModTextsV = true;
					this.doAddMNew(x, y, pos, orientation, myOpening);

				} else if (orientation == ValidOrientations.HORIZONTAL
						.getValue()) {
					myFrame2.resetModTextsH = true;
					this.doAddMNew(x, y, pos, orientation, myOpening);
				}

			}

		} else {
			// error Message
		}

		xCols = bOpeningObject.xCols;
		yRows = bOpeningObject.yRows;

		myFrame2.jobItem.myCanvas.selectedRadioForCol = 1;
		myFrame2.jobItem.myCanvas.selectedRadioForRow = 1;
		if (type != 0) {

			this.reDrawRadioRowCol(bOpeningObject.yRows, bOpeningObject.xCols,
					1, myFrame2.jobItem.myCanvas.selectedRadioForRow,
					myFrame2.jobItem.myCanvas.selectedRadioForCol, this);
		}
		this.addCoupler = false;

	}

	/**
	 * Check Facet Width Dimension
	 * 
	 * @param totalMCThick
	 *            , total mullion coupler thickness
	 * @return Object[]
	 */
	public Object[] checkFacetWidth(double totalMCThick) {

		Object[] returns = new Object[2];

		Object[] Ms = myFrame2.facetUsed.bOpeningObject.mullions.toArray();

		int count = 0;
		for (final Object mV : Ms) {
			if (((Profiles) mV).exists == 1) {
				count++;
			}
		}

		int cols = count + 2;

		double newW = 0;
		double roundedW = 0;
		double newFacetW = 0;

		if (myFrame2.currentUOM == 1) {
			newW = new BigDecimal(myFrame2.facetUsed.widthMO + "")
					.divide(new BigDecimal("100"), 20, BigDecimal.ROUND_UP)
					.subtract(new BigDecimal(totalMCThick + ""))
					.divide(new BigDecimal(cols + ""), 20, BigDecimal.ROUND_UP)
					.doubleValue();

			roundedW = myFrame2.roundDim(newW, 1, myFrame2.metricRound, 1);

		} else {
			newW = new BigDecimal(myFrame2.facetUsed.widthIO + "")
					.subtract(new BigDecimal(totalMCThick + ""))
					.divide(new BigDecimal(cols), 20, BigDecimal.ROUND_UP)
					.doubleValue();

			roundedW = myFrame2.roundDim(newW, 1, myFrame2.impRound, 2);
		}
		if (myFrame2.layoutP.bay.isSelected()
				|| myFrame2.layoutP.bow.isSelected()) {
			roundedW = newW;
		}

		double newOverallW = new BigDecimal(cols + "")
				.multiply(new BigDecimal(roundedW + ""))
				.setScale(20, BigDecimal.ROUND_UP).doubleValue();

		if (cols * roundedW * myScale.doubleValue() != myFrame2.facetUsed.widthPix) {

			newOverallW = 0;
			newFacetW = new BigDecimal(cols + "")
					.multiply(new BigDecimal(roundedW + ""))
					.setScale(20, BigDecimal.ROUND_UP).doubleValue();

			Object[] texts = myFrame2.fcolTextObjects.toArray();

			if (texts.length > 0) {

				myFrame2.fcolTextObjects.clear();

				for (int j = 0; j < texts.length; j++) {

					if (myFrame2.facetUsed.startCol - 1 == j) {
						myFrame2.fcolTextObjects.add(newFacetW + "");

						newOverallW = new BigDecimal(newOverallW + "")
								.add(new BigDecimal(newFacetW + ""))
								.setScale(20, BigDecimal.ROUND_UP)
								.doubleValue();

					} else {

						myFrame2.fcolTextObjects.add(texts[j].toString());

						newOverallW = new BigDecimal(newOverallW + "")
								.add(new BigDecimal(texts[j].toString()))
								.setScale(20, BigDecimal.ROUND_UP)
								.doubleValue();
					}

				}
			}

			myFrame2.changeFacetW = true;

			if (texts.length == 0) {
				newOverallW = new BigDecimal(cols + "")
						.multiply(new BigDecimal(roundedW + ""))
						.setScale(20, BigDecimal.ROUND_UP).doubleValue();
			}

		}

		newOverallW = new BigDecimal(newOverallW + "")
				.add(new BigDecimal(totalMCThick + ""))
				.setScale(20, BigDecimal.ROUND_UP).doubleValue();

		returns[0] = roundedW;
		returns[1] = newOverallW;

		return returns;
	}

	/**
	 * Check facet Height
	 * 
	 * @param totalMCThick
	 *            , total mullion coupler thickness
	 * @return Object[]
	 */
	public Object[] checkFacetHeight(double totalMCThick) {

		Object[] returns = new Object[2];

		Object[] Ms = myFrame2.facetUsed.bOpeningObject.mullionsH.toArray();
		int count = 0;
		for (final Object mH : Ms) {
			if (((Profiles) mH).exists == 1) {
				count++;
			}
		}

		int rows = count + 2;

		double newH = 0;
		double roundedH = 0;
		double newFacetH = 0;

		double fH = 0;
		if (myFrame2.currentUOM == 1) {
			fH = myFrame2.facetUsed.heightMO;

		} else {
			fH = myFrame2.facetUsed.heightIO;
		}

		if (myFrame2.currentUOM == 1) {
			newH = (myFrame2.facetUsed.heightMO / 100 - totalMCThick) / rows;

			// if(rows-1==1 && myFrame2.facetUsed.top1Part.partForm>1){
			// newH =
			// ((myFrame2.facetUsed.highestY+myFrame2.facetUsed.top1Part.startYA)/myFrame2.metricscale.doubleValue())
			// + totalMCThick/2;
			// }

			roundedH = myFrame2.roundDim(newH, 1, myFrame2.metricRound, 1);
		} else {
			newH = (myFrame2.facetUsed.heightIO - totalMCThick) / rows;

			// if(rows-1==1 && myFrame2.facetUsed.top1Part.partForm>1){
			// newH =
			// ((myFrame2.facetUsed.highestY+myFrame2.facetUsed.top1Part.startYA)/myFrame2.imperialscale.doubleValue())
			// + totalMCThick/2;
			// }

			roundedH = myFrame2.roundDim(newH, 1, myFrame2.impRound, 2);
		}

		double newOverallH = rows * roundedH;
		if (rows * roundedH * myScale.doubleValue() != myFrame2.facetUsed.heightPix) {
			newOverallH = 0;
			newFacetH = rows * roundedH;

			final Object[] texts = myFrame2.frowTextObjects.toArray();
			if (texts.length > 0) {
				myFrame2.frowTextObjects.clear();
				for (int j = 0; j < texts.length; j++) {
					if (myFrame2.facetUsed.startRow - 1 == j) {
						myFrame2.frowTextObjects.add(newFacetH + "");
						newOverallH = newOverallH + newFacetH;
					} else {
						myFrame2.frowTextObjects.add(texts[j].toString());
						newOverallH = newOverallH
								+ Double.parseDouble(texts[j].toString());
					}

				}
			}

			myFrame2.changeFacetH = true;

			if (texts.length == 0) {
				newOverallH = rows * roundedH;
			}

		}
		newOverallH = newOverallH + totalMCThick;

		returns[0] = roundedH;
		returns[1] = newOverallH;

		return returns;
	}

	public Object[] checkFacetHeightNEW(final double totalMCThick) {

		final Object[] returns = new Object[2];

		final Object[] Ms = myFrame2.facetUsed.bOpeningObject.mullionsH
				.toArray();
		final int rows = Ms.length + 2;
		double newH = 0;
		double roundedH = 0;
		if (myFrame2.currentUOM == 1) {
			newH = (myFrame2.facetUsed.heightMO / 100 - totalMCThick) / rows;
			roundedH = myFrame2.roundDim(newH, 1, myFrame2.metricRound, 1);
		} else {
			newH = (myFrame2.facetUsed.heightIO - totalMCThick) / rows;
			roundedH = myFrame2.roundDim(newH, 1, myFrame2.impRound, 2);
		}

		double newOverallH = rows * roundedH + totalMCThick;

		returns[0] = roundedH;
		returns[1] = newOverallH;

		return returns;
	}

	public Object[] checkOverallWidth(final double totalMCThick) {

		Object[] returns = new Object[2];

		Object[] Ms = myFrame2.jobItem.design.bOpeningObject.mullions.toArray();

		int cols = 0;// Ms.length + 2;
		for (Object m : Ms) {
			if (((Profiles) m).exists == 1) {
				cols++;
			}
		}
		cols = cols + 2;

		double newW = 0;
		double roundedW = 0;

		if (myFrame2.currentUOM == 1) {
			newW = (myFrame2.jobItem.design.widthMO / 100 - totalMCThick)
					/ cols;
			roundedW = myFrame2.roundDim(newW, 1, myFrame2.metricRound, 1);
		} else {
			newW = (myFrame2.jobItem.design.widthIO - totalMCThick) / cols;
			roundedW = myFrame2.roundDim(newW, 1, myFrame2.impRound, 2);
		}
		if (myFrame2.layoutP.bay.isSelected()
				|| myFrame2.layoutP.bow.isSelected()) {
			roundedW = newW;
		} // sumPrev

		double newOverallW = cols * roundedW;

		if (cols * roundedW * myScale.doubleValue() != myFrame2.jobItem.design.widthPix) {
			newOverallW = 0;
			newOverallW = cols * roundedW;
		}

		newOverallW = newOverallW + totalMCThick;

		returns[0] = roundedW;
		returns[1] = newOverallW;

		return returns;
	}

	public void reInitDraw() {

		myFrame2.jobItem.myCanvas.clearDrawObjects();
		this.clearTexts();
		this.resetPanels();
	}

	public void clearTexts() {

		myFrame2.topTexts.clear();
		myFrame2.botTexts.clear();
		myFrame2.leftTexts.clear();
		myFrame2.rightTexts.clear();
		myFrame2.myTextRow = null;
		myFrame2.myTextLeft = null;

		myFrame2.mainColCheck = null;
		myFrame2.mainRowCheck = null;
	}

	public void resetPanels() {

		myFrame2.jobItem.myCanvas = new DrawCanvas(myFrame2,
				myFrame2.jobItem.myCanvas.selectedRadioForRow,
				myFrame2.jobItem.myCanvas.selectedRadioForCol,
				myFrame2.jobItem.myCanvas.selectedRadioForRowo,
				myFrame2.jobItem.myCanvas.selectedRadioForColo);

		myFrame2.jobItem.myCanvas.drawTextTop = true;
		myFrame2.jobItem.myCanvas.drawTextLeft = true;

		myFrame2.lastSelectedCol = 0;
		myFrame2.lastSelectedColBot = 0;
		myFrame2.modSeqUndo = 0;
		myFrame2.modSeqUndoBot = 0;
		myFrame2.mainFramePanel.removeAll();
	}

	public void reDrawRadioRowCol(int rows, int cols, int dimLevel, int row,
			int col, ShapeObject ov) {

		myFrame2.jobItem.myCanvas.createChecksforCols(col, ov);
		myFrame2.jobItem.myCanvas.createChecksforRows(row, ov);

		myFrame2.jobItem.myCanvas
				.createRadioforFacets(myFrame2.jobItem.myCanvas.selectedfBot);

	}

	public void reDrawTextsforRowCol(int row, int col, boolean doModText,
			ShapeObject ov) throws Exception {

		this.resetTextsforRowCol(row, col,
				myFrame2.jobItem.myCanvas.selectedRadioForRowo,
				myFrame2.jobItem.myCanvas.selectedRadioForColo, false);

		if (!doModText) {
			this.doTopBotTextMod(row);
			this.doLeftRightTextMod(col);
		}

		if (!frameWRounded && !frameHRounded
				|| myFrame2.mullionsPanel.divideFacet) {

			if (!myFrame2.mullionsPanel.divideFacet && !myFrame2.wEntered
					&& !myFrame2.hEntered
					&& myFrame2.jobItem.design.frames.size() > 1) {
			}

			this.reDraw(false, true, null, false, true, false);

			if (!myFrame2.dim.isSash.isSelected()) {
				this.reDrawRadioRowCol(yRows, bOpeningObject.xCols,
						myFrame2.selectedDim,
						myFrame2.jobItem.myCanvas.selectedRadioForRow,
						myFrame2.jobItem.myCanvas.selectedRadioForCol, ov);
			}

		} else {
			// myFrame2.topDeltas = Math.ceil(myFrame2.topDeltas);
			// myFrame2.leftDeltas = Math.ceil(myFrame2.leftDeltas);
			//
			// new Facet();
			//
			// if (myFrame2.currentUOM == 1) {
			//
			// if (frameWRounded && !frameHRounded) {
			// myFrame2.doResetFacetSize(
			// myFrame2.roundDim(
			// new BigDecimal(widthPix).divide(myFrame2.scale, 20,
			// BigDecimal.ROUND_UP).doubleValue()
			// - myFrame2.topDeltas, 1, myFrame2.metricRound, 1),
			// new BigDecimal(heightPix).divide(myFrame2.scale, 20,
			// BigDecimal.ROUND_UP).doubleValue(), (Facet) this, 0);
			//
			// } else if (!frameWRounded && frameHRounded) {
			//
			// myFrame2.doResetFacetSize(
			// new BigDecimal(widthPix)
			// .divide(myFrame2.scale, 20, BigDecimal.ROUND_UP).doubleValue(),
			// myFrame2.roundDim(
			// new BigDecimal(heightPix).divide(myFrame2.scale, 20,
			// BigDecimal.ROUND_UP).doubleValue()
			// - myFrame2.leftDeltas, 1, myFrame2.impRound, 2),
			// (Facet) this, 0);
			// } else if (frameWRounded && frameHRounded) {
			//
			// myFrame2.doResetFacetSize(
			// myFrame2.roundDim(
			// new BigDecimal(widthPix).divide(myFrame2.scale, 20,
			// BigDecimal.ROUND_UP).doubleValue()
			// - myFrame2.topDeltas, 1, myFrame2.impRound, 2),
			// myFrame2.roundDim(
			// new BigDecimal(heightPix).divide(myFrame2.scale, 20,
			// BigDecimal.ROUND_UP).doubleValue()
			// - myFrame2.leftDeltas, 1, myFrame2.impRound, 2),
			// (Facet) this, 0);
			// }
			//
			// } else if (myFrame2.currentUOM == 2) {
			//
			// if (frameWRounded && !frameHRounded) {
			// myFrame2.doResetFacetSize(
			// myFrame2.roundDim(
			// new BigDecimal(widthPix).divide(myFrame2.scale, 20,
			// BigDecimal.ROUND_UP).doubleValue()
			// - myFrame2.topDeltas, 1, myFrame2.impRound, 2) / 64,
			// new BigDecimal(heightPix).divide(myFrame2.scale, 20,
			// BigDecimal.ROUND_UP).doubleValue() / 64, (Facet) this, 0);
			// } else if (!frameWRounded && frameHRounded) {
			//
			// // myFrame2.doResetFacetSize(
			// // new BigDecimal(widthPix)
			// // .divide(myFrame2.scale, 20, BigDecimal.ROUND_UP).doubleValue()
			// / 64,
			// // myFrame2.roundDim(
			// // new BigDecimal(heightPix).divide(myFrame2.scale, 20,
			// // BigDecimal.ROUND_UP).doubleValue()
			// // - myFrame2.leftDeltas, 1, myFrame2.impRound, 2) / 64,
			// // (Facet) this, 0);
			//
			// } else if (frameWRounded && frameHRounded) {
			// myFrame2.doResetFacetSize(
			// myFrame2.roundDim(
			// new BigDecimal(widthPix).divide(myFrame2.scale, 20,
			// BigDecimal.ROUND_UP).doubleValue()
			// - myFrame2.topDeltas, 1, myFrame2.impRound, 2) / 64,
			// myFrame2.roundDim(
			// new BigDecimal(heightPix).divide(myFrame2.scale, 20,
			// BigDecimal.ROUND_UP).doubleValue()
			// - myFrame2.leftDeltas, 1, myFrame2.impRound, 2) / 64,
			// (Facet) this, 0);
			// }
			//
			// } else if (myFrame2.currentUOM == 3) {
			// if (frameWRounded && !frameHRounded) {
			// myFrame2.doResetFacetSize(
			// myFrame2.roundDim(
			// new BigDecimal(widthPix).divide(myFrame2.scale, 20,
			// BigDecimal.ROUND_UP).doubleValue()
			// - myFrame2.topDeltas, 1, myFrame2.impRound, 2) / 64,
			// new BigDecimal(heightPix).divide(myFrame2.scale, 20,
			// BigDecimal.ROUND_UP).doubleValue() / 64, (Facet) this, 0);
			// } else if (!frameWRounded && frameHRounded) {
			// myFrame2.doResetFacetSize(
			// new BigDecimal(widthPix)
			// .divide(myFrame2.scale, 20, BigDecimal.ROUND_UP).doubleValue() /
			// 64,
			// myFrame2.roundDim(
			// new BigDecimal(heightPix).divide(myFrame2.scale, 20,
			// BigDecimal.ROUND_UP).doubleValue()
			// - myFrame2.leftDeltas, 1, myFrame2.impRound, 2) / 64,
			// (Facet) this, 0);
			// } else if (frameWRounded && frameHRounded) {
			// myFrame2.doResetFacetSize(
			// myFrame2.roundDim(
			// new BigDecimal(widthPix).divide(myFrame2.scale, 20,
			// BigDecimal.ROUND_UP).doubleValue()
			// - myFrame2.topDeltas, 1, myFrame2.impRound, 2) / 64,
			// myFrame2.roundDim(
			// new BigDecimal(heightPix).divide(myFrame2.scale, 20,
			// BigDecimal.ROUND_UP).doubleValue()
			// - myFrame2.leftDeltas, 1, myFrame2.impRound, 2) / 64,
			// (Facet) this, 0);
			// }
			//
			// }
			//
			if (!myFrame2.dim.isSash.isSelected()) {
				this.reDrawRadioRowCol(yRows, bOpeningObject.xCols,
						myFrame2.selectedDim,
						myFrame2.jobItem.myCanvas.selectedRadioForRow,
						myFrame2.jobItem.myCanvas.selectedRadioForCol, ov);
			}

		}// Do Rounding On Facet, Then On
			// Overall

		// Reset Options values
		this.myFrame2.options.initValues();

		myFrame2.topDeltas = 0;
		myFrame2.leftDeltas = 0;
		frameWRounded = false;
		frameHRounded = false;
		facetWRounded = false;
		facetHRounded = false;

	}

	public void facetWidthChangeAction() {

		Object[] myTextOriginal = new Object[2];
		try {
			myTextOriginal = myFrame2.readConvertText(myFrame2.myTopPanel.fW);
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final Object[] dVs = bOpeningObject.mullions.toArray();
		double totalThicks = 0;
		int countFacets = 1;
		for (final Object d : dVs) {
			if (!((Profiles) d).divideFacet) {
				totalThicks = totalThicks + ((Profiles) d).thickness;
				countFacets++;
			}
		}
		final double oText = Double.parseDouble(myTextOriginal[0].toString());
		Object[] fs = myFrame2.fcolTextObjects.toArray();
		double newW = 0;
		myFrame2.fcolTextObjects.clear();
		for (int j = 0; j < fs.length; j++) {
			if (myFrame2.jobItem.myCanvas.selectedfBot - 1 == j) {
				double w = 0;
				if (widthPix / myFrame2.scale.doubleValue()
						- Math.floor(widthPix / myFrame2.scale.doubleValue()) >= 0.999) {
					w = Math.ceil(widthPix / myFrame2.scale.doubleValue());
				} else {
					w = widthPix / myFrame2.scale.doubleValue();
					if (myFrame2.currentUOM == 1) {
						w = myFrame2.roundDim(w, 1, myFrame2.metricRound, 1);
					} else {
						w = myFrame2.roundDim(w, 2, myFrame2.impRound, 2);
					}
				}
				myFrame2.fcolTextObjects.add(w);
			} else {
				myFrame2.fcolTextObjects.add(fs[j].toString());
			}

		}

		fs = myFrame2.fcolTextObjects.toArray();
		for (int j = 0; j < fs.length; j++) {
			newW = newW + Double.parseDouble(fs[j].toString());
		}

		newW = newW + totalThicks / myFrame2.scale.doubleValue();

		if (oText != newW) {

			myFrame2.myTopPanel.resetSize(true);

		}
	}

	public void OverallWidthChangeAddDivider(final double newColW) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		myFrame2.myTopPanel.fW.getText();
		final Object[] dVs = bOpeningObject.mullions.toArray();

		double totalThicks = 0;
		int countFacets = 1;
		for (final Object d : dVs) {
			if (((Profiles) d).divideFacet && ((Profiles) d).exists == 1) {
				totalThicks = totalThicks + ((Profiles) d).thickness;
				countFacets++;
			}
		}

		double newW = countFacets * newColW;

		newW = UOMConvert.getBigDecimalConversion((newW + totalThicks),
				myScale, 2);
		if (newW - Math.floor(newW) >= 0.999) {
			newW = Math.ceil(newW);
		}

		try {
			myFrame2.dimConvert(newW, true);
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final Object[] fs = myFrame2.fcolTextObjects.toArray();
		if (fs.length > 1) {
			myFrame2.fcolTextObjects.clear();
			for (int j = 0; j < fs.length; j++) {
				myFrame2.fcolTextObjects.add(UOMConvert
						.getBigDecimalConversion(newColW, myScale, 2));

			}

			myFrame2.changeFacetW = true;
		}

		myFrame2.wEntered = false;
		myFrame2.hEntered = false;

		myFrame2.doResetOverallSize(newW, UOMConvert.getBigDecimalConversion(
				myFrame2.jobItem.design.heightPix, myScale, 2),
				myFrame2.jobItem.design, 0, false, false);
		// }

		myFrame2.changeFacetW = false;

		final Object[] facets = myFrame2.jobItem.design.frames.toArray();
		myFrame2.jobItem.design.frames.clear();
		for (final Object f : facets) {
			((Facet) f).setDimsChange(((Facet) f).widthPix,
					((Facet) f).heightPix);
			((Facet) f).widthMO = ((Facet) f).widthM;
			((Facet) f).widthIO = ((Facet) f).widthI;

			myFrame2.jobItem.design.frames.add(f);
		}

	}

	public void OverallHeightChangeAddDivider(final double newRowH) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		myFrame2.myTopPanel.fH.getText();
		final Object[] dHs = bOpeningObject.mullionsH.toArray();
		double totalThicks = 0;
		int countFacets = 1;
		for (final Object d : dHs) {
			if (((Profiles) d).divideFacet && ((Profiles) d).exists == 1) {
				totalThicks = totalThicks + ((Profiles) d).thickness;
				countFacets++;
			}
		}

		double newH = countFacets * newRowH;

		newH = UOMConvert.getBigDecimalConversion((newH + totalThicks),
				myScale, 2);
		if (newH - Math.floor(newH) >= 0.999) {
			newH = Math.ceil(newH);
		}

		try {
			myFrame2.dimConvert(newH, true);
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final Object[] fs = myFrame2.frowTextObjects.toArray();
		if (fs.length > 1) {
			myFrame2.frowTextObjects.clear();
			for (int j = 0; j < fs.length; j++) {
				myFrame2.frowTextObjects.add(UOMConvert
						.getBigDecimalConversion(newRowH, myScale, 2));

			}

			myFrame2.changeFacetH = true;
		}

		myFrame2.wEntered = false;
		myFrame2.hEntered = false;

		myFrame2.doResetOverallSize(UOMConvert.getBigDecimalConversion(
				myFrame2.jobItem.design.widthPix, myScale, 2), newH,
				myFrame2.jobItem.design, 0, false, false);

		myFrame2.changeFacetH = false;

		final Object[] facets = myFrame2.jobItem.design.frames.toArray();
		myFrame2.jobItem.design.frames.clear();
		for (final Object f : facets) {
			((Facet) f).setDimsChange(((Facet) f).widthPix,
					((Facet) f).heightPix);
			((Facet) f).widthMO = ((Facet) f).widthM;
			((Facet) f).widthIO = ((Facet) f).widthI;

			myFrame2.jobItem.design.frames.add(f);
		}

	}

	public void resetTextsforRowCol(final int row, final int col,
			final int rowo, final int colo, final boolean opening) {

		// myFrame2.jobItem.resetGraphics();
		myFrame2.jobItem.myCanvas.clearDrawCanvasComponents();
		myFrame2.ellipses.clear();
		myFrame2.gpFillShapes.clear();
		myFrame2.gpColors.clear();
		myFrame2.gpObjects.clear();

		myFrame2.selectedRadioForCol = myFrame2.jobItem.myCanvas.selectedRadioForCol = myFrame2.lastRC = col;
		myFrame2.selectedRadioForRow = myFrame2.jobItem.myCanvas.selectedRadioForRow = myFrame2.lastRR = row;
		myFrame2.selectedRadioForColo = myFrame2.jobItem.myCanvas.selectedRadioForColo = myFrame2.lastRCo = colo;
		myFrame2.selectedRadioForRowo = myFrame2.jobItem.myCanvas.selectedRadioForRowo = myFrame2.lastRRo = rowo;

		myFrame2.clearItemFrameTextObjects();
		myFrame2.clearFacetTexts();

		final Object[] myFacets = myFrame2.jobItem.design.frames.toArray();

		for (final Object facet : myFacets) {
			((Facet) facet).doFacetDimsBot(row, col);
		}

		Object[] myFrames = frames.toArray();

		if (myFrame2.subFClicked && myFrame2.dim.sFLevel.isSelected()) {
			myFrames = myFrame2.facetUsed.frames.toArray();
		}

		if (myFrame2.facetUsed.shapeID != 1) {
			myFrame2.roundH = false;
			myFrame2.roundW = false;
		}

		if (!myFrame2.dim.isSash.isSelected()) {
			if (!opening) {

				for (final Object frameObject : myFrames) {
					((Frame) frameObject).doShapeDimsTop(row, col);
					((Frame) frameObject).doShapeDimsLeft(row, col);

				}
				if (myFrame2.subFClicked && myFrame2.dim.sFLevel.isSelected()) {
					reDrawRadioRowCol(myFrame2.facetUsed.yRows,
							myFrame2.facetUsed.xCols, myFrame2.selectedDim,
							row, col, myFrame2.facetUsed);
				}

			} else {
				for (final Object f : myFrames) {
					if (((Frame) f).startRow == myFrame2.jobItem.myCanvas.selectedRadioForRow
							&& ((Frame) f).startCol == myFrame2.jobItem.myCanvas.selectedRadioForCol) {
						((Frame) f).prepareOpenings(row, col, rowo, colo,
								myFrame2.selectedDim, 2);
					}
				}
			}
		} else {
			if (myFrame2.mySelectedSash != null) {
				myFrame2.jobItem.myCanvas
						.createRadioforFacets(myFrame2.jobItem.myCanvas.selectedfBot);

				final Object[] leafs = ((SashTypeObject) myFrame2.mySelectedSash).frames
						.toArray();
				final Object[] ops = ((SashTypeObject) myFrame2.mySelectedSash).openings
						.toArray();
				for (final Object o : ops) {
					if (myFrame2.selectedDim <= 4) {

						if (myFrame2.selectedDim <= 2) {

							if (((OpeningObject) o).startRow == myFrame2.jobItem.myCanvas.selectedRadioForRow) {
								((OpeningObject) o).doShapeDimsTop(
										((OpeningObject) o).startRow,
										((OpeningObject) o).startCol);
							}

							if (((OpeningObject) o).startCol == myFrame2.jobItem.myCanvas.selectedRadioForCol) {
								((OpeningObject) o).doShapeDimsLeft(
										((OpeningObject) o).startRow,
										((OpeningObject) o).startCol);
							}

							break;
						}

					} else {
						if (((OpeningObject) o).contentMid == 2) {
							for (final Object f : leafs) {

								if (((SashLeaf) f).startCol == myFrame2.lastRC
										&& ((SashLeaf) f).startRow == myFrame2.lastRR) {

									((SashLeaf) f)
											.prepareOpenings(row, col, rowo,
													colo, myFrame2.selectedDim,
													2);
								}
							}

							break;
						} else if (((OpeningObject) o).contentMid == 1) {
							((OpeningObject) o).prepareOpenings(row, col, rowo,
									colo, myFrame2.selectedDim, 2);
							break;
						}

					}
				}
			}

		}
	}

	public void reDrawTextsforRowColOp(int row, int col, int rowo, int colo,
			boolean doModText, int dimType) {

		// if((rowo!= myFrame2.lastRRo) || (colo!=myFrame2.lastRCo))
		// {
		// this.resetTextsforRowCol(
		// row,
		// col,
		// myFrame2.lastRRo,
		// myFrame2.lastRCo,
		// true);
		// }else {
		this.resetTextsforRowCol(row, col, rowo, colo, true);
		// }
		if (doModText && dimType >= 5 && dimType <= 8) {
			if (!myFrame2.dim.isSash.isSelected()) {
				// this.doTopTextModOpening(
				// myFrame2.jobItem.myCanvas.selectedRadioForRow,
				// myFrame2.jobItem.myCanvas.selectedRadioForCol,
				// myFrame2.jobItem.myCanvas.selectedRadioForRowo,
				// myFrame2.jobItem.myCanvas.selectedRadioForColo);
				//
				// this.doLeftTextModOpening(
				// myFrame2.jobItem.myCanvas.selectedRadioForRow,
				// myFrame2.jobItem.myCanvas.selectedRadioForCol,
				// myFrame2.jobItem.myCanvas.selectedRadioForRowo,
				// myFrame2.jobItem.myCanvas.selectedRadioForColo);
			}
		} else if (doModText && dimType == 9) {

		}
		myFrame2.jobItem.myCanvas.drawTextTop = true;
		myFrame2.jobItem.myCanvas.drawTextLeft = true;

		// Clear draw canvas components
		myFrame2.jobItem.myCanvas.clearDrawCanvasComponents();

		myFrame2.jobItem.myCanvas.createTextFieldsTop();
		myFrame2.jobItem.myCanvas.createTextFieldsLeft();
		myFrame2.jobItem.myCanvas.createTextFieldsFacet();
		myFrame2.jobItem.myCanvas.createTextFieldsCoupler();

		if (myFrame2.subFClicked && myFrame2.dim.sFLevel.isSelected()) {

		} else if (myFrame2.dim.isSash.isSelected()) {

		}

		final Object[] frames = myFrame2.facetUsed.frames.toArray();

		for (final Object frameObject : frames) {
			if (((ShapeObject) frameObject).startRow == myFrame2.jobItem.myCanvas.selectedRadioForRow
					&& ((ShapeObject) frameObject).startCol == myFrame2.jobItem.myCanvas.selectedRadioForCol
					&& !myFrame2.dim.isSash.isSelected()) {

			}
		}

	}

	public void doAddC(int x, int y, int pos, int orientation, double colW,
			double rowH, boolean newPos, int startR, int endR, int startC,
			int endC) throws Exception {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		AddMullionV addMullionV = null;
		AddMullionH addMullionH = null;
		Object[] returns = new Object[2];
		boolean isGood = true;

		Object[] facets = myFrame2.jobItem.design.frames.toArray();

		myFrame2.jobItem.design.frames.clear();

		for (Object facet : facets) {

			if (((Facet) facet).a_sequenceID == myFrame2.facetUsed.a_sequenceID) {

				Object[] frames = ((Facet) facet).frames.toArray();
				((Facet) facet).frames.clear();

				for (final Object frame : frames) {

					((Frame) frame).isNewFrame = false;

					((Frame) frame).affected = false;

					if (newPos) {// && !startIn && !endIn){
						// if (orientation == 1
						// && (((Frame) frame).startRow <= endR && ((Frame)
						// frame).endRow >= startR)) {
						// ((Frame) frame).affected = true;
						//
						// }
						// if (orientation == 2
						// && (((Frame) frame).startCol <= endC && ((Frame)
						// frame).endCol >= startC)) {
						((Frame) frame).affected = true;

					}

					else if (((Frame) frame).equals(myFrame2.mySelectedFrame)) {
						((Frame) frame).affected = true;
					}

					((Facet) facet).frames.add(frame);
				}

				if (orientation == 1) {
					addMullionV = new AddMullionV(
							((Facet) facet).bOpeningObject, myFrame2.jobItem,
							myFrame2, 1);
					addMullionV.getProfileDims(null);

					returns = addMullionV.doAddMullionsV(x, y, true,
							myFrame2.mullionsPanel.mType,
							myFrame2.mullionsPanel.mullionPartForm,
							myFrame2.mullionsPanel.offsetTL,
							myFrame2.mullionsPanel.offsetBR,
							myFrame2.mullionsPanel.deltaTL,
							myFrame2.mullionsPanel.deltaRB,
							myFrame2.mullionsPanel.curveCenterTL,
							myFrame2.mullionsPanel.curveCenterRB,
							myFrame2.mullionsPanel
									.getCouplerMullionController()
									.getPartsSelected().getId(), 1, 0,
							myFrame2.mullionsPanel.whichPos, true, colW, 31,
							myFrame2.mullionsPanel.typeID, 0);

					((Facet) facet).bOpeningObject = (BkgrdOpeningObject) returns[1];
					isGood = Boolean.parseBoolean(returns[0].toString());

					Object[] myMs = ((Facet) facet).bOpeningObject.mullions
							.toArray();

					double[] deltas = new double[myMs.length];
					int count = 0;

					for (Object m : myMs) {
						if (((Profiles) m).exists == 1) {
							deltas[count] = ((Profiles) m).centerXs;
							count++;
						}
					}

					Arrays.sort(deltas);

					myMs = ((Facet) facet).bOpeningObject.mullions.toArray();
					((Facet) facet).bOpeningObject.mullions.clear();
					int order = 1;

					for (Object d : deltas) {
						for (Object m : myMs) {

							if (Double.parseDouble(d.toString()) == ((Profiles) m).centerXs) {
								((Profiles) m).order = order;
								order++;
								((Facet) facet).bOpeningObject.mullions.add(m);
							}
						}
					}

				} else {
					addMullionH = new AddMullionH(
							((Facet) facet).bOpeningObject,
							((Facet) facet).myFrame2.jobItem,
							((Facet) facet).myFrame2, 1);
					addMullionH.getProfileDims(null);

					returns = addMullionH.doAddMullionsH(x, y, true,
							myFrame2.mullionsPanel.mType,
							myFrame2.mullionsPanel.mullionPartForm,
							myFrame2.mullionsPanel.offsetTL,
							myFrame2.mullionsPanel.offsetBR,
							myFrame2.mullionsPanel.deltaTL,
							myFrame2.mullionsPanel.deltaRB,
							myFrame2.mullionsPanel.curveCenterTL,
							myFrame2.mullionsPanel.curveCenterRB,
							myFrame2.mullionsPanel
									.getCouplerMullionController()
									.getPartsSelected().getId(), 0, 0,
							myFrame2.mullionsPanel.whichPos, true, rowH, 31,
							myFrame2.mullionsPanel.typeID);

					((Facet) facet).bOpeningObject = (BkgrdOpeningObject) returns[1];
					isGood = Boolean.parseBoolean(returns[0].toString());

					Object[] myMs = ((Facet) facet).bOpeningObject.mullionsH
							.toArray();

					double[] deltas = new double[myMs.length];
					int count = 0;
					for (Object m : myMs) {
						if (((Profiles) m).exists == 1) {
							deltas[count] = ((Profiles) m).centerYs;
							count++;
						}

					}

					Arrays.sort(deltas);

					myMs = ((Facet) facet).bOpeningObject.mullionsH.toArray();
					((Facet) facet).bOpeningObject.mullionsH.clear();
					int order = 1;

					for (Object d : deltas) {
						for (Object m : myMs) {

							if (Double.parseDouble(d.toString()) == ((Profiles) m).centerYs) {
								((Profiles) m).order = order;
								order++;
								((Facet) facet).bOpeningObject.mullionsH.add(m);
							}

						}
					}
					myFrame2.facetUsed = (Facet) facet;
				}

				myFrame2.facetUsed = (Facet) facet;
			}
			myFrame2.jobItem.design.frames.add(facet);
		}

		if (isGood) {

			this.reDraw(true, true, null, false, true, false);
			if (orientation == 1) {
				this.doTopBotTextMod(myFrame2.jobItem.myCanvas.selectedRadioForRow);
				this.doTopTextModOpening(
						myFrame2.jobItem.myCanvas.selectedRadioForRow,
						myFrame2.jobItem.myCanvas.selectedRadioForCol,
						myFrame2.jobItem.myCanvas.selectedRadioForRowo,
						myFrame2.jobItem.myCanvas.selectedRadioForColo);
			} else {
				this.doLeftRightTextMod(myFrame2.jobItem.myCanvas.selectedRadioForCol);
				this.doLeftTextModOpening(
						myFrame2.jobItem.myCanvas.selectedRadioForRow,
						myFrame2.jobItem.myCanvas.selectedRadioForCol,
						myFrame2.jobItem.myCanvas.selectedRadioForRowo,
						myFrame2.jobItem.myCanvas.selectedRadioForColo);
			}

			myFrame2.shapesPanel
					.getShapesButtonsMap()
					.get(new Integer(90))
					.setEnabled(
							myFrame2.shapesPanel.getShapeController()
									.isContainsValidShapes(90));
			myFrame2.shapesPanel
					.getShapesButtonsMap()
					.get(new Integer(91))
					.setEnabled(
							myFrame2.shapesPanel.getShapeController()
									.isContainsValidShapes(91));
			myFrame2.shapesPanel
					.getShapesButtonsMap()
					.get(new Integer(92))
					.setEnabled(
							myFrame2.shapesPanel.getShapeController()
									.isContainsValidShapes(92));
			myFrame2.shapesPanel
					.getShapesButtonsMap()
					.get(new Integer(93))
					.setEnabled(
							myFrame2.shapesPanel.getShapeController()
									.isContainsValidShapes(93));
			myFrame2.shapesPanel
					.getShapesButtonsMap()
					.get(new Integer(301))
					.setEnabled(
							myFrame2.shapesPanel.getShapeController()
									.isContainsValidShapes(301));
			myFrame2.shapesPanel
					.getShapesButtonsMap()
					.get(new Integer(302))
					.setEnabled(
							myFrame2.shapesPanel.getShapeController()
									.isContainsValidShapes(302));
			myFrame2.shapesPanel
					.getShapesButtonsMap()
					.get(new Integer(303))
					.setEnabled(
							myFrame2.shapesPanel.getShapeController()
									.isContainsValidShapes(303));

		}

		addMullionV = null;
		addMullionH = null;

	}

	/**
	 * Adding new Mullion
	 * 
	 * @param x
	 *            , Axis x position
	 * @param y
	 *            , Axis y position
	 * @param pos
	 *            ,
	 * @param orientation
	 *            , Orientation vertical or horizontal
	 * @param myOpening
	 *            , Opening object
	 */
	public void doAddMNew(int x, int y, int pos, int orientation,
			OpeningObject myOpening) throws Exception {

		boolean isGood = true;
		Object[] returns = new Object[2];
		final Object[] facets = myFrame2.jobItem.design.frames.toArray();
		myFrame2.jobItem.design.frames.clear();

		for (Object facet : facets) {

			if (((Facet) facet).a_sequenceID == myFrame2.facetUsed.a_sequenceID) {
				myFrame2.facetUsed = null;
				Object[] frames = ((Facet) facet).frames.toArray();
				((Facet) facet).frames.clear();
				for (Object frame : frames) {

					frame = recalcFrame(frame);

					((Frame) frame).isNewFrame = false;
					if (pos == 1) {
						if (myOpening.contentIn == 1) {
						} else if (myOpening.contentIn == 2) {
						} else {
							// subFrame
						}
					} else if (pos == 2) {
						if (myOpening.contentMid == 1) {
							if (((Frame) frame).a_sequenceID == myOpening.myParent.a_sequenceID) {
								returns = addMullionInFrame(x, y, orientation,
										frame);
								isGood = Boolean.parseBoolean(returns[0]
										.toString());
								frame = returns[1];
							}

						} else if (myOpening.contentMid == 2) {
							if (((Frame) frame).a_sequenceID == myOpening.myParent.a_sequenceID) {
								returns = addMullionInSash(x, y, orientation,
										myOpening, frame);
								isGood = Boolean.parseBoolean(returns[0]
										.toString());
								frame = returns[1];
							}

						} else {
							// subFrame
						}

					} else if (pos == 3) {
						if (myOpening.contentOut == 1) {

						} else if (myOpening.contentOut == 1) {

						} else {
							// subFrame
						}
					}

					((Frame) frame).bom.clear();
					((Frame) frame).clearBomForShape();
					((Frame) frame).executePartRules(true, true,
							"shapeobject.doassMNew.7871");

					((Facet) facet).frames.add(frame);
				}

				// myFrame2.facetUsed = (Facet) facet;

				myFrame2.facetUsed = ((Facet) facet).cloneFacet((Facet) facet);
			}
			myFrame2.jobItem.design.frames.add(facet);
		}

		if (isGood && !myFrame2.dim.isSash.isSelected()) {
			this.drawFrames();

			if (orientation == 1) {
				this.doTopBotTextMod(myFrame2.jobItem.myCanvas.selectedRadioForRow);
				this.doTopTextModOpening(
						myFrame2.jobItem.myCanvas.selectedRadioForRow,
						myFrame2.jobItem.myCanvas.selectedRadioForCol,
						myFrame2.jobItem.myCanvas.selectedRadioForRowo,
						myFrame2.jobItem.myCanvas.selectedRadioForColo);
			} else {
				this.doLeftRightTextMod(myFrame2.jobItem.myCanvas.selectedRadioForCol);
				this.doLeftTextModOpening(
						myFrame2.jobItem.myCanvas.selectedRadioForRow,
						myFrame2.jobItem.myCanvas.selectedRadioForCol,
						myFrame2.jobItem.myCanvas.selectedRadioForRowo,
						myFrame2.jobItem.myCanvas.selectedRadioForColo);
			}

			myFrame2.shapesPanel
					.getShapesButtonsMap()
					.get(new Integer(90))
					.setEnabled(
							myFrame2.shapesPanel.getShapeController()
									.isContainsValidShapes(90));
			myFrame2.shapesPanel
					.getShapesButtonsMap()
					.get(new Integer(91))
					.setEnabled(
							myFrame2.shapesPanel.getShapeController()
									.isContainsValidShapes(91));
			myFrame2.shapesPanel
					.getShapesButtonsMap()
					.get(new Integer(92))
					.setEnabled(
							myFrame2.shapesPanel.getShapeController()
									.isContainsValidShapes(92));
			myFrame2.shapesPanel
					.getShapesButtonsMap()
					.get(new Integer(93))
					.setEnabled(
							myFrame2.shapesPanel.getShapeController()
									.isContainsValidShapes(93));
			myFrame2.shapesPanel
					.getShapesButtonsMap()
					.get(new Integer(301))
					.setEnabled(
							myFrame2.shapesPanel.getShapeController()
									.isContainsValidShapes(301));
			myFrame2.shapesPanel
					.getShapesButtonsMap()
					.get(new Integer(302))
					.setEnabled(
							myFrame2.shapesPanel.getShapeController()
									.isContainsValidShapes(302));
			myFrame2.shapesPanel
					.getShapesButtonsMap()
					.get(new Integer(303))
					.setEnabled(
							myFrame2.shapesPanel.getShapeController()
									.isContainsValidShapes(303));

		}

	}

	public Object recalcFrame(Object frame) throws Exception {

		if (((Frame) frame).top1Part.startX == 0) {
			Object[] openings = ((Frame) frame).openings.toArray();
			SashTypeObject in = new SashTypeObject();
			SashTypeObject mid = new SashTypeObject();
			SashTypeObject out = new SashTypeObject();
			for (Object o : openings) {
				if (((OpeningObject) o).a_sequenceID == 11) {
					in = ((OpeningObject) o).sashObjectIn;
					mid = ((OpeningObject) o).sashObjectMid;
					out = ((OpeningObject) o).sashObjectOut;
				}

			}
			Collection existingFrames = new ArrayList();
			existingFrames.add(frame);
			CreateFrames createFrame = new CreateFrames(
					((Frame) frame).myParentO, existingFrames, myFrame2);
			frame = createFrame.doFrame(((Frame) frame).controlOpeningClass,
					((Frame) frame).controlUserDefinedOpeningID,
					((Frame) frame).controlOpeningClass, in, mid, out,
					((Frame) frame).glazedOut, true, true, false);

			((Frame) frame).bOpeningObject = ((Frame) frame)
					.doMullions(((Frame) frame).bOpeningObject);
		}
		return frame;
	}

	/**
	 * Adding mullion in Frame object
	 * 
	 * @param x
	 *            , Axis x position
	 * @param y
	 *            , Axis y position
	 * @param orientation
	 *            , Verticar or Horizontal position
	 * @param frame
	 *            , Frame
	 * @return Object[]
	 */
	public Object[] addMullionInFrame(int x, int y, int orientation,
			Object frame) throws Exception {

		boolean isGood = true;

		// Adding mullion vertical
		AddMullionV addMullionV = null;
		// Adding mullion horizontal
		AddMullionH addMullionH = null;

		// Get ArrayList of 2 objects
		Object[] getreturns = new Object[2];
		Object[] returns = new Object[2];

		// ****************************************************************
		// Adding a vertical mullion
		// ****************************************************************
		if (orientation == ValidOrientations.VERTICAL.getValue()) {

			// Adding mullion verticals
			addMullionV = new AddMullionV(((Frame) frame).bOpeningObject,
					myFrame2.jobItem, myFrame2, 2);

			// Get mullion parts dimension
			addMullionV.getProfileDims(null);

			// Do add mullions vertical
			getreturns = addMullionV.doAddMullionsV(x, y, true,
					myFrame2.mullionsPanel.mType,
					myFrame2.mullionsPanel.mullionPartForm,
					myFrame2.mullionsPanel.offsetTL,
					myFrame2.mullionsPanel.offsetBR,
					myFrame2.mullionsPanel.deltaTL,
					myFrame2.mullionsPanel.deltaRB,
					myFrame2.mullionsPanel.curveCenterTL,
					myFrame2.mullionsPanel.curveCenterRB, 0, 1, 0,
					myFrame2.mullionsPanel.whichPos, true, 0, 32,
					myFrame2.mullionsPanel.typeID, 0);

			((Frame) frame).bOpeningObject = (BkgrdOpeningObject) getreturns[1];

			isGood = Boolean.parseBoolean(getreturns[0].toString());

			int count = 0;

			Object[] myMs = ((Frame) frame).bOpeningObject.mullions.toArray();

			double[] deltas = new double[myMs.length];

			for (Object m : myMs) {
				if (((Profiles) m).exists == 1) {
					deltas[count] = ((Profiles) m).centerXs;
					((Profiles) m).order = 0;
					count++;
				}
			}

			Arrays.sort(deltas);

			myMs = ((Frame) frame).bOpeningObject.mullions.toArray();
			((Frame) frame).bOpeningObject.mullions.clear();

			int order = 1;
			for (Object d : deltas) {
				for (Object m : myMs) {
					if (Double.parseDouble(d.toString()) == ((Profiles) m).centerXs) {
						((Profiles) m).order = order;
						order++;
						((Frame) frame).bOpeningObject.mullions.add(m);
					}
				}

			}
			myMs = ((Frame) frame).bOpeningObject.mullions.toArray();

		} else {

			addMullionH = new AddMullionH(((Frame) frame).bOpeningObject,
					myFrame2.jobItem, myFrame2, 2);
			addMullionH.getProfileDims(null);

			getreturns = addMullionH.doAddMullionsH(x, y, true,
					myFrame2.mullionsPanel.mType,
					myFrame2.mullionsPanel.mullionPartForm,
					myFrame2.mullionsPanel.offsetTL,
					myFrame2.mullionsPanel.offsetBR,
					myFrame2.mullionsPanel.deltaTL,
					myFrame2.mullionsPanel.deltaRB,
					myFrame2.mullionsPanel.curveCenterTL,
					myFrame2.mullionsPanel.curveCenterRB, 0, 0, 0,
					myFrame2.mullionsPanel.whichPos, true, 0, 32,
					myFrame2.mullionsPanel.typeID);

			((Frame) frame).bOpeningObject = (BkgrdOpeningObject) getreturns[1];

			isGood = Boolean.parseBoolean(getreturns[0].toString());

			Object[] myMs = ((Frame) frame).bOpeningObject.mullionsH.toArray();

			double[] deltas = new double[myMs.length];
			int count = 0;

			for (Object m : myMs) {
				if (((Profiles) m).exists == 1) {
					deltas[count] = ((Profiles) m).centerYs;
					count++;
				}
			}

			Arrays.sort(deltas);

			myMs = ((Frame) frame).bOpeningObject.mullionsH.toArray();
			((Frame) frame).bOpeningObject.mullionsH.clear();
			int order = 1;

			for (Object d : deltas) {
				for (Object m : myMs) {

					if (Double.parseDouble(d.toString()) == ((Profiles) m).centerYs) {
						((Profiles) m).order = order;
						order++;
						((Frame) frame).bOpeningObject.mullionsH.add(m);
					}

				}
			}

		}

		addMullionV = null;
		addMullionH = null;
		returns[0] = isGood;
		returns[1] = frame;
		return returns;
	}

	public Object[] addMullionInSash(int x, int y, int orientation,
			OpeningObject myOpening, Object frame) throws Exception {

		boolean isGood = true;
		Object[] getreturns = new Object[2];
		final Object[] returns = new Object[2];

		final Object[] openings = ((Frame) frame).openings.toArray();
		((Frame) frame).openings.clear();
		for (Object op : openings) {

			if (((OpeningObject) op).a_sequenceID == myOpening.a_sequenceID) {
				Object[] leaves = ((OpeningObject) op).sashObjectMid.frames
						.toArray();
				((OpeningObject) op).sashObjectMid.frames.clear();
				for (Object sash : leaves) {
					if (((SashLeaf) sash).startingX <= x
							&& ((SashLeaf) sash).bX4 <= x
							&& ((SashLeaf) sash).bX2 >= x
							&& ((SashLeaf) sash).bX3 >= x
							&& ((SashLeaf) sash).highestY <= y
							&& ((SashLeaf) sash).lowestY >= y) {

						AddMullionV addMullionV = null;
						AddMullionH addMullionH = null;

						if (orientation == 1) {

							addMullionV = new AddMullionV(
									((SashLeaf) sash).bOpeningObject,
									myFrame2.jobItem, myFrame2, 2);

							addMullionV.getProfileDims(null);

							getreturns = addMullionV.doAddMullionsV(x, y, true,
									myFrame2.mullionsPanel.mType,
									myFrame2.mullionsPanel.mullionPartForm,
									myFrame2.mullionsPanel.offsetTL,
									myFrame2.mullionsPanel.offsetBR,
									myFrame2.mullionsPanel.deltaTL,
									myFrame2.mullionsPanel.deltaRB,
									myFrame2.mullionsPanel.curveCenterTL,
									myFrame2.mullionsPanel.curveCenterRB, 0, 1,
									0, myFrame2.mullionsPanel.whichPos, true,
									0, 32, myFrame2.mullionsPanel.typeID, 0);

							((SashLeaf) sash).bOpeningObject = (BkgrdOpeningObject) getreturns[1];
							isGood = Boolean.parseBoolean(getreturns[0]
									.toString());

							Object[] myMs = ((SashLeaf) sash).bOpeningObject.mullions
									.toArray();

							double[] deltas = new double[myMs.length];
							int count = 0;

							for (Object m : myMs) {

								if (((Profiles) m).exists == 1) {
									deltas[count] = ((Profiles) m).centerXs;
									count++;
								}

							}

							Arrays.sort(deltas);

							myMs = ((SashLeaf) sash).bOpeningObject.mullions
									.toArray();
							((SashLeaf) sash).bOpeningObject.mullions.clear();
							int order = 1;
							for (Object d : deltas) {
								for (Object m : myMs) {

									if (Double.parseDouble(d.toString()) == ((Profiles) m).centerXs) {
										((Profiles) m).order = order;
										order++;
										((SashLeaf) sash).bOpeningObject.mullions
												.add(m);
									}

								}

							}

						} else {

							addMullionH = new AddMullionH(
									((SashLeaf) sash).bOpeningObject,
									myFrame2.jobItem, myFrame2, 2);

							addMullionH.getProfileDims(null);

							getreturns = addMullionH.doAddMullionsH(x, y, true,
									myFrame2.mullionsPanel.mType,
									myFrame2.mullionsPanel.mullionPartForm,
									myFrame2.mullionsPanel.offsetTL,
									myFrame2.mullionsPanel.offsetBR,
									myFrame2.mullionsPanel.deltaTL,
									myFrame2.mullionsPanel.deltaRB,
									myFrame2.mullionsPanel.curveCenterTL,
									myFrame2.mullionsPanel.curveCenterRB, 0, 0,
									0, myFrame2.mullionsPanel.whichPos, true,
									0, 32, myFrame2.mullionsPanel.typeID);

							((SashLeaf) sash).bOpeningObject = (BkgrdOpeningObject) getreturns[1];
							isGood = Boolean.parseBoolean(getreturns[0]
									.toString());

							Object[] myMs = ((SashLeaf) sash).bOpeningObject.mullionsH
									.toArray();

							double[] deltas = new double[myMs.length];
							int count = 0;
							for (Object m : myMs) {
								if (((Profiles) m).exists == 1) {
									deltas[count] = ((Profiles) m).centerYs;
									count++;
								}

							}

							Arrays.sort(deltas);

							myMs = ((SashLeaf) sash).bOpeningObject.mullionsH
									.toArray();
							((SashLeaf) sash).bOpeningObject.mullionsH.clear();
							int order = 1;
							for (Object d : deltas) {
								for (Object m : myMs) {
									{
										if (Double.parseDouble(d.toString()) == ((Profiles) m).centerYs) {
											((Profiles) m).order = order;
											order++;

										}

									}
									((SashLeaf) sash).bOpeningObject.mullionsH
											.add(m);
								}
							}

						}

					}
					((OpeningObject) op).sashObjectMid.frames.add(sash);
				}

			}
			((Frame) frame).openings.add(op);
		}

		returns[0] = isGood;
		returns[1] = frame;
		return returns;
	}

	public void doAddM(final int x, final int y, final int pos, final int type,
			final int orientation, final OpeningObject myOpening)
			throws Exception {

		final Object[] frames = myFrame2.facetUsed.frames.toArray();
		myFrame2.facetUsed.frames.clear();
		for (final Object F : frames) {
			if (((Frame) F).equals(myClickedFrame)) {
				((Frame) F).isNewFrame = false;
			}
			myFrame2.facetUsed.frames.add(F);
		}
		if (type == 2) {
			this.getOpeningForMullion(x, y, pos, myFrame2.facetUsed);

		} else {
			myClickedFrame = this;

		}
		AddMullionV addMullionV = null;
		AddMullionH addMullionH = null;

		if (orientation == 1) {

			myClickedFrame.isNewFrame = false;
			if (myClickedFrame.a_levelID == 1) {
				myClickedFrame.bOpeningObject.order++;
				addMullionV = new AddMullionV(myClickedFrame.bOpeningObject,
						myFrame2.jobItem, myFrame2, 1);

			} else if (myClickedFrame.a_levelID == 3) {
				myClickedFrame.bOpeningObject.order++;
				addMullionV = new AddMullionV(myClickedFrame.bOpeningObject,
						myFrame2.jobItem, myFrame2, 2);
			} else if (myClickedFrame.a_levelID == 12) {
				myClickedFrame.bOpeningObject.order++;
				addMullionV = new AddMullionV(myClickedFrame.bOpeningObject,
						myFrame2.jobItem, myFrame2, 2);
			}
			addMullionV.getProfileDims(null);
			addMullionV.doAddMullionsV(x, y, true,
					myFrame2.mullionsPanel.mType,
					myFrame2.mullionsPanel.mullionPartForm,
					myFrame2.mullionsPanel.offsetTL,
					myFrame2.mullionsPanel.offsetBR,
					myFrame2.mullionsPanel.deltaTL,
					myFrame2.mullionsPanel.deltaRB,
					myFrame2.mullionsPanel.curveCenterTL,
					myFrame2.mullionsPanel.curveCenterRB, 0, 1, 0,
					myFrame2.mullionsPanel.whichPos, true, 0, 32,
					myFrame2.mullionsPanel.typeID, 0);
		} else if (orientation == 2) {

			myClickedFrame.isNewFrame = false;
			if (myClickedFrame.a_levelID == 1) {
				myClickedFrame.bOpeningObject.order++;
				addMullionH = new AddMullionH(myClickedFrame.bOpeningObject,
						((Facet) myClickedFrame).myFrame2.jobItem,
						((Facet) myClickedFrame).myFrame2, 1);

			} else if (myClickedFrame.a_levelID == 3) {
				myClickedFrame.bOpeningObject.order++;
				addMullionH = new AddMullionH(myClickedFrame.bOpeningObject,
						((Frame) myClickedFrame).myFrame2.jobItem,
						((Frame) myClickedFrame).myFrame2, 2);
			} else if (myClickedFrame.a_levelID == 12) {
				myClickedFrame.bOpeningObject.order++;
				addMullionH = new AddMullionH(
						myClickedFrame.bOpeningObject,
						((Frame) ((SashLeaf) myClickedFrame).myParentO.myParent).myFrame2.jobItem,
						((Frame) ((SashLeaf) myClickedFrame).myParentO.myParent).myFrame2,
						2);
			}
			addMullionH.getProfileDims(null);
			addMullionH.doAddMullionsH(x, y, true,
					myFrame2.mullionsPanel.mType,
					myFrame2.mullionsPanel.mullionPartForm,
					myFrame2.mullionsPanel.offsetTL,
					myFrame2.mullionsPanel.offsetBR,
					myFrame2.mullionsPanel.deltaTL,
					myFrame2.mullionsPanel.deltaRB,
					myFrame2.mullionsPanel.curveCenterTL,
					myFrame2.mullionsPanel.curveCenterRB, 0, 0, 0,
					myFrame2.mullionsPanel.whichPos, true, 0, 32,
					myFrame2.mullionsPanel.typeID);
		}
		boolean isGood = true;

		if (orientation == 1) {
			isGood = addMullionV.goodToGo;
		} else if (orientation == 2) {
			isGood = addMullionH.goodToGo;
		}

		if (isGood) {
			if (type == 1) {
				this.reDraw(true, true, null, false, false, false);
			} else {
				this.drawFrames();
			}
			if (orientation == 1) {
				this.doTopBotTextMod(myFrame2.jobItem.myCanvas.selectedRadioForRow);
				this.doTopTextModOpening(
						myFrame2.jobItem.myCanvas.selectedRadioForRow,
						myFrame2.jobItem.myCanvas.selectedRadioForCol,
						myFrame2.jobItem.myCanvas.selectedRadioForRowo,
						myFrame2.jobItem.myCanvas.selectedRadioForColo);
			} else {
				this.doLeftRightTextMod(myFrame2.jobItem.myCanvas.selectedRadioForCol);
				this.doLeftTextModOpening(
						myFrame2.jobItem.myCanvas.selectedRadioForRow,
						myFrame2.jobItem.myCanvas.selectedRadioForCol,
						myFrame2.jobItem.myCanvas.selectedRadioForRowo,
						myFrame2.jobItem.myCanvas.selectedRadioForColo);
			}

			myFrame2.shapesPanel.shapeButton[2].setEnabled(false);

			myFrame2.shapesPanel.shapeButton[3].setEnabled(false);

			myFrame2.shapesPanel.shapeButton[4].setEnabled(false);

			myFrame2.shapesPanel.shapeButton[5].setEnabled(false);

			myFrame2.shapesPanel.shapeButton[59].setEnabled(false);

			myFrame2.shapesPanel.shapeButton[60].setEnabled(false);

			myFrame2.shapesPanel.shapeButton[61].setEnabled(false);

		}
		if (orientation == 1) {
			addMullionV.goodToGo = true;
			addMullionV = null;
		} else if (orientation == 2) {
			addMullionH.goodToGo = true;
			addMullionH = null;
		}

	}

	public Overall doAddDividerV(final int x, final int y, final int pos,
			final int type) throws Exception {

		final Object[] frames = myFrame2.jobItem.design.frames.toArray();
		myFrame2.jobItem.design.frames.clear();

		for (final Object F : frames) {

			((Facet) F).isNewFrame = false;

			myFrame2.jobItem.design.frames.add(F);
		}

		AddMullionV addMullionV = null;

		myFrame2.jobItem.design.isNewFrame = false;

		myFrame2.jobItem.design.bOpeningObject.order++;

		addMullionV = new AddMullionV(myFrame2.jobItem.design.bOpeningObject,
				myFrame2.jobItem, myFrame2, 1);

		addMullionV.getProfileDims(null);
		myFrame2.jobItem.design.bOpeningObject = addMullionV.doAddDividerV(x,
				y, true, myFrame2.mullionsPanel.mType,
				myFrame2.mullionsPanel.mullionPartForm,
				myFrame2.mullionsPanel.offsetTL,
				myFrame2.mullionsPanel.offsetBR,
				myFrame2.mullionsPanel.deltaTL, myFrame2.mullionsPanel.deltaRB,
				myFrame2.mullionsPanel.curveCenterTL,
				myFrame2.mullionsPanel.curveCenterRB, 0, 1, 0,
				myFrame2.mullionsPanel.whichPos, true);

		myFrame2.jobItem.myCanvas.createTextFieldsCoupler();
		//
		// }
		addMullionV.goodToGo = true;
		addMullionV = null;

		final Object[] facets = myFrame2.jobItem.design.frames.toArray();
		myFrame2.jobItem.design.frames.clear();

		for (final Object f : facets) {
			if (((Facet) f).startCol == 1) {
				((Facet) f).inUse = true;

				myFrame2.jobItem.myCanvas.mySelectedFacet = (Facet) f;

			} else {
				((Facet) f).inUse = false;
			}
			((Facet) f).autoW = true;
			myFrame2.jobItem.design.frames.add(f);
		}
		myFrame2.facetUsed = myFrame2.jobItem.myCanvas.mySelectedFacet;

		myFrame2.doFacetRadioClick();

		return myFrame2.jobItem.design;

	}

	public void doAddDividerH(final int x, final int y, final int mType,
			final int pos, final int type, final ShapeObject overallUsed)
			throws Exception {

		final Object[] frames = overallUsed.frames.toArray();
		overallUsed.frames.clear();
		for (final Object F : frames) {
			if (((Facet) F).equals(myClickedFrame)) {
				((Facet) F).isNewFrame = false;
			}
			overallUsed.frames.add(F);
		}

		myClickedFrame = this;

		AddMullionH addMullionH = null;

		myClickedFrame.isNewFrame = false;

		myClickedFrame.bOpeningObject.order++;
		addMullionH = new AddMullionH(

		myClickedFrame.bOpeningObject,
				((Overall) myClickedFrame).myFrame2.jobItem,
				((Overall) myClickedFrame).myFrame2, 1);

		addMullionH.getProfileDims(null);

		addMullionH.doAddMullionsH(x, y, true, myFrame2.mullionsPanel.mType,
				myFrame2.mullionsPanel.mullionPartForm,
				myFrame2.mullionsPanel.offsetTL,
				myFrame2.mullionsPanel.offsetBR,
				myFrame2.mullionsPanel.deltaTL, myFrame2.mullionsPanel.deltaRB,
				myFrame2.mullionsPanel.curveCenterTL,
				myFrame2.mullionsPanel.curveCenterRB, 0, 0, 0,
				myFrame2.mullionsPanel.whichPos, true, 0, 30,
				myFrame2.mullionsPanel.typeID);

		if (addMullionH.goodToGo) {
			this.doCouplers();

			this.doFacets(false, false, true, false);
			this.drawFacets();

		}
		addMullionH.goodToGo = true;
		addMullionH = null;
	}

	public void doTopBotTextMod(final int row) {

		if (myFrame2.resetModTextsV || myFrame2.topTextsMod == null) {
			bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();

			int countStartRow = 0;
			for (final Object element : bOpeningObject.mullionObjectsV) {
				if (((Profiles) element).startPos == row
						|| ((Profiles) element).startPos <= row
						&& ((Profiles) element).endPos >= row) {
					countStartRow++;
				}
			}

			myFrame2.topTextsMod = new int[countStartRow + 1];

		}

	}

	public void doLeftRightTextMod(final int col) {

		int countStartCol = 0;
		if (myFrame2.resetModTextsH || myFrame2.leftTextsMod == null) {
			bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();
			countStartCol = 0;

			for (final Object element : bOpeningObject.mullionObjectsH) {
				if (((Profiles) element).startPos == col
						|| ((Profiles) element).startPos <= col
						&& ((Profiles) element).endPos >= col) {
					countStartCol++;
				}
			}

			myFrame2.leftTextsMod = new int[countStartCol + 1];
			// myFrame2.leftTextsMod= new
			// int[myFrame2.rowTextObjects.size()];

		}

	}

	public void doTopTextModOpening(final int pr, final int pc, final int row,
			final int col) {

		int countStartRow = 0;
		if (myFrame2.resetModTextsV || myFrame2.topTextsModo == null) {

			if (myFrame2.selectedDim < 9) {
				final Object[] mVs = bOpeningObject.mullions.toArray();
				for (final Object element : mVs) {
					if (((Profiles) element).startPos == row
							|| ((Profiles) element).startPos <= row
							&& ((Profiles) element).endPos >= row) {
						countStartRow++;
					}
				}
			} else {
				final Object[] ops = openings.toArray();

				for (final Object o : ops) {
					if (((OpeningObject) o).startRow == row
							&& ((OpeningObject) o).startCol == col) {
						if (((OpeningObject) o).contentMid == 1
								&& ((OpeningObject) o).dloMid != null) {
							if (!((OpeningObject) o).unGlazed) {
								countStartRow = ((OpeningObject) o).dloMid.bOpeningObject.mullions
										.size();
							}
						} else if (((OpeningObject) o).contentMid == 2
								&& ((OpeningObject) o).dloMid != null) {
							final Object[] sTypeO = ((OpeningObject) o).sashObjectMid.openings
									.toArray();
							for (final Object sTO : sTypeO) {
								if (((OpeningObject) sTO).contentMid == 1
										&& ((OpeningObject) o).dloMid != null) {
									final Object[] sTops = ((OpeningObject) sTO).openings
											.toArray();
									for (final Object sTo : sTops) {
										if (!((OpeningObject) sTo).unGlazed
												&& ((OpeningObject) sTo).dloMid != null) {
											countStartRow = ((OpeningObject) sTo).dloMid.bOpeningObject.mullions
													.size();
										}
									}
								}
							}

							final Object[] sL = ((OpeningObject) o).sashObjectMid.frames
									.toArray();

							for (final Object l : sL) {
								final Object[] sLo = ((SashLeaf) l).openings
										.toArray();
								for (final Object so : sLo) {

									if (!((OpeningObject) so).unGlazed
											&& ((OpeningObject) so).dloMid != null) {
										countStartRow = ((OpeningObject) so).dloMid.bOpeningObject.mullions
												.size();
									}

								}

							}

						}
					}
				}

			}

			myFrame2.topTextsModo = new int[countStartRow + 1];
		}

	}

	public void doTopTextModGrid(final int pr, final int pc, final int row,
			final int col) {

		int countStartRow = 0;
		if (myFrame2.resetModTextsV || myFrame2.topTextsModo == null) {

			final Object[] mVs = bOpeningObject.mullions.toArray();
			for (final Object element : mVs) {
				if (((Profiles) element).startPos == row
						|| ((Profiles) element).startPos <= row
						&& ((Profiles) element).endPos >= row) {
					countStartRow++;
				}
			}

			myFrame2.topTextsModo = new int[countStartRow + 1];
		}

	}

	public void doLeftTextModOpening(final int pr, final int pc, final int row,
			final int col) {

		int countStartCol = 0;

		if (myFrame2.resetModTextsH || myFrame2.leftTextsModo == null) {

			countStartCol = 0;

			final Object[] mHs = this.bOpeningObject.mullionsH.toArray();

			for (final Object element : mHs) {
				if (((Profiles) element).startPos == col
						|| ((Profiles) element).startPos <= col
						&& ((Profiles) element).endPos >= col) {
					countStartCol++;
				}
			}

			myFrame2.leftTextsModo = new int[countStartCol + 1];

		}

	}

	public void doLeftTextModGrid(final int pr, final int pc, final int row,
			final int col) {

		int countStartCol = 0;

		if (myFrame2.resetModTextsH || myFrame2.leftTextsModo == null) {

			countStartCol = 0;

			final Object[] mHs = this.bOpeningObject.mullionsH.toArray();

			for (final Object element : mHs) {
				if (((Profiles) element).startPos == col
						|| ((Profiles) element).startPos <= col
						&& ((Profiles) element).endPos >= col) {
					countStartCol++;
				}
			}

			myFrame2.leftTextsModo = new int[countStartCol + 1];

		}

	}

	public void reDraw(final boolean drawFrames, boolean sameParts,
			final Frame mySelectedFrame, final boolean modInternalDims,
			final boolean recalc, boolean frameShapeChange) throws Exception {

		sameParts = true;

		Object[] frameObjects = frames.toArray();

		if (myFrame2.selectedDim == 3 || myFrame2.selectedDim == 4) {

			for (final Object frameObject : frameObjects) {

				if (((Frame) frameObject).startRow == myFrame2.jobItem.myCanvas.selectedRadioForRow
						&& ((Frame) frameObject).startCol == myFrame2.jobItem.myCanvas.selectedRadioForCol) {

					if (((Frame) frameObject).bOpeningObject.mullionObjectsV != null
							&& ((Frame) frameObject).bOpeningObject.mullionObjectsV.length > 0) {

						myFrame2.jobItem.myCanvas.drawTextTop = true;

						// Clear draw canvas components
						myFrame2.jobItem.myCanvas.clearDrawCanvasComponents();

						myFrame2.jobItem.myCanvas.createTextFieldsTop();
						myFrame2.jobItem.myCanvas.createTextFieldsFacet();
						myFrame2.jobItem.myCanvas.createTextFieldsCoupler();
					}
					if (((Frame) frameObject).bOpeningObject.mullionObjectsH != null
							&& ((Frame) frameObject).bOpeningObject.mullionObjectsH.length > 0) {
						myFrame2.jobItem.myCanvas.drawTextLeft = true;
						myFrame2.jobItem.myCanvas.createTextFieldsLeft();
						// myFrame2.facetUsed.bOpeningObject.mullionsH;
						myFrame2.jobItem.myCanvas.drawTextLeft = true;
					}
				}
			}

		} else {
			myFrame2.jobItem.myCanvas.drawTextTop = true;
			myFrame2.jobItem.myCanvas.drawTextLeft = true;

			// Clear draw canvas components
			myFrame2.jobItem.myCanvas.clearDrawCanvasComponents();

			myFrame2.jobItem.myCanvas.createTextFieldsTop();
			myFrame2.jobItem.myCanvas.createTextFieldsLeft();
			myFrame2.jobItem.myCanvas.createTextFieldsFacet();
			myFrame2.jobItem.myCanvas.createTextFieldsCoupler();

		}

		bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
		bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();

		if (drawFrames) {

			CreateFrames createFrame = null;

			final Object[] oo = openings.toArray();

			openings.clear();

			final Collection existingFrames = new ArrayList();

			existingFrames.addAll(frames);

			final Object[] fs = existingFrames.toArray();

			frames.clear();

			int totalFrames = 0;

			for (final Object O : oo) {

				int controlType = 1;

				if (((OpeningObject) O).a_sequenceID == 11
						&& ((OpeningObject) O).sashObjectMid != null) {

					controlType = ((OpeningObject) O).sashObjectMid.openingTypeClass;

				}

				createFrame = new CreateFrames((OpeningObject) O,
						existingFrames, myFrame2);

				SashTypeObject sIn = null;
				SashTypeObject sMid = null;
				SashTypeObject sOut = null;

				int sID = 0;

				int sType = 0;

				boolean gOut = false;

				Frame myFrame = new Frame();

				boolean isSelectedFrame = false;

				for (final Object f : fs) {
					if (this.myFrame2.shapeChangeFrame != null
							&& frameShapeChange) {
						double x1s = this.myFrame2.shapeChangeFrame.startingX;
						double x4s = this.myFrame2.shapeChangeFrame.bX4;
						double x2s = this.myFrame2.shapeChangeFrame.bX2;
						double x3s = this.myFrame2.shapeChangeFrame.bX3;
						double hy = this.myFrame2.shapeChangeFrame.highestY;
						double ly = this.myFrame2.shapeChangeFrame.lowestY;

						double cx = (Math.min(((Frame) f).startingX,
								((Frame) f).bX4) + Math.max(((Frame) f).bX2,
								((Frame) f).bX3)) / 2;

						double cy = (((Frame) f).highestY + ((Frame) f).lowestY) / 2;

						if (cx >= Math.min(x1s, x4s)
								&& cx <= Math.max(x2s, x3s) && cy >= hy
								&& cy <= ly && frameShapeChange) {

							isSelectedFrame = true;

						}
					}

					if (((Frame) f).myParentO.a_sequenceID == ((OpeningObject) O).lastSeq
							|| oo.length == 1) {

						final Object[] fo = ((Frame) f).openings.toArray();

						if (mySelectedFrame != null
								&& ((Frame) f).a_sequenceID != mySelectedFrame.a_sequenceID) {

							sameParts = true;

						}

						for (final Object o : fo) {

							if (((OpeningObject) o).a_sequenceID == 11) {

								if (((OpeningObject) o).sashObjectMid != null) {
									sType = ((OpeningObject) o).sashObjectMid.sashClassType;
									gOut = ((OpeningObject) o).sashObjectMid.glazedOut;
									sID = ((OpeningObject) o).sashObjectMid.userDefinedOpeningID;

								}

								if (sType < 1) {
									sType = ((OpeningObject) o).myParent.openingClass;
									gOut = ((OpeningObject) o).myParent.glazedOut;
									sID = ((OpeningObject) o).myParent.userDefinedOpeningID;

								}

								sIn = ((OpeningObject) o).sashObjectIn;
								sMid = ((OpeningObject) o).sashObjectMid;
								sOut = ((OpeningObject) o).sashObjectOut;

							}

						}
						boolean doframe = true;

						if (((Frame) f).affected && addCoupler) {
							myFrame = createFrame.doFrame(sType, sID,
									controlType, sIn, sMid, sOut, gOut,
									sameParts, recalc, true);// subF
							myFrame.isNewFrame = false;
							frames.add(myFrame);
						} else if (!addCoupler && !frameShapeChange) {

							myFrame = createFrame.doFrame(sType, sID,
									controlType, sIn, sMid, sOut, gOut,
									sameParts, recalc, true);// subF
							myFrame.isNewFrame = false;
							frames.add(myFrame);

						} else if (frameShapeChange && isSelectedFrame) {

							myFrame = createFrame.doFrame(sType, sID,
									controlType, sIn, sMid, sOut, gOut,
									sameParts, recalc, true);// subF
							myFrame.isNewFrame = false;
							frames.add(myFrame);

						} else if (!((Frame) f).affected) {

							myFrame.isNewFrame = false;
							frames.add((Frame) f);

						}

						totalFrames++;

						break;

					} else if (fs.length != oo.length
							&& totalFrames != oo.length) {
						if (((OpeningObject) O).lastSeq <= 0) {
							final int[] info = myFrame2.getDefaultSashTypeBy();
							sType = info[0];
							gOut = false;
							sID = info[1];
							if (info[2] == 1) {
								gOut = true;
							}

							sIn = null;
							sMid = null;
							sOut = null;
							((OpeningObject) O).lastSeq = ((OpeningObject) O).a_sequenceID;
							myFrame = createFrame.doFrame(sType, sID,
									controlType, sIn, sMid, sOut,
									// subF,
									gOut, sameParts, recalc, true);
							myFrame.isNewFrame = false;
							frames.add(myFrame);

							totalFrames++;
							break;
						}
					}

				}

				((OpeningObject) O).isNewFrame = false;
				((OpeningObject) O).lastSeq = ((OpeningObject) O).a_sequenceID;
				openings.add(O);

				createFrame = null;
			}
			existingFrames.clear();

		}
		frameObjects = frames.toArray();
		for (final Object frameObject : frameObjects) {
			((ShapeObject) frameObject).resetRemovedParts();
		}
		if (drawFrames && !frameShapeChange) {
			// myFrame2.facetUsed.bOpeningObject.mullionsH;
			this.recalcCouplersH();
			// myFrame2.facetUsed.bOpeningObject.mullionsH;
			this.bOpeningObject = this.doMullions(this.bOpeningObject);

		}
	}

	public void getFrameClicked(final int x, final int y) {

		final Object[] frameObjects = frames.toArray();

		for (final Object frameObject : frameObjects) {

			if (Math.min((int) ((Frame) frameObject).startingX,
					(int) ((Frame) frameObject).bX4) <= x
					&& (int) ((Frame) frameObject).highestY <= y
					&& Math.max((int) ((Frame) frameObject).bX2,
							(int) ((Frame) frameObject).bX3) >= x
					&& Math.max((int) ((Frame) frameObject).bY3,
							(int) ((Frame) frameObject).bY4) >= y) {

				myClickedFrame = (Frame) frameObject;

				frameStartCol = ((Frame) frameObject).startCol;
				frameStartRow = ((Frame) frameObject).startRow;
				frameEndCol = ((Frame) frameObject).endCol;
				frameEndRow = ((Frame) frameObject).endRow;
				myRow = frameStartRow;
				myCol = frameStartCol;
				myShapeID = ((Frame) frameObject).shapeID;
				myOpeningID = ((Frame) frameObject).userDefinedOpeningID;
			}
		}
	}

	public void getFrameClickedRC(final int row, final int col) {

		final Object[] frameObjects = frames.toArray();

		for (final Object frameObject : frameObjects) {

			if (((ShapeObject) frameObject).startRow == row
					&& ((ShapeObject) frameObject).startCol == col) {

				myClickedFrame = (ShapeObject) frameObject;

				frameStartCol = ((ShapeObject) frameObject).startCol;
				frameStartRow = ((ShapeObject) frameObject).startRow;
				frameEndCol = ((ShapeObject) frameObject).endCol;
				frameEndRow = ((ShapeObject) frameObject).endRow;
				myRow = frameStartRow;
				myCol = frameStartCol;
				myShapeID = ((ShapeObject) frameObject).shapeID;
				myOpeningID = ((ShapeObject) frameObject).userDefinedOpeningID;
				break;
			}
		}

	}

	public void getOpeningForMullion(final int x, final int y,
			final int whichPos, final ShapeObject overallUsed) {

		final Object[] frameObjects = overallUsed.frames.toArray();
		boolean found = false;
		for (final Object frameObject : frameObjects) {
			if (found) {
				break;
			}
			final Object[] openingObjects = ((Frame) frameObject).openings
					.toArray();
			for (final Object O : openingObjects) {
				if (whichPos == 1) {

					if ((int) ((OpeningObject) O).startingX <= x
							&& (int) ((OpeningObject) O).highestY <= y
							&& (int) ((OpeningObject) O).bX2 >= x

							&& (int) ((OpeningObject) O).bX3 >= x
							&& (int) ((OpeningObject) O).bY3 >= y
							&& (int) ((OpeningObject) O).bX4 <= x
							&& (int) ((OpeningObject) O).bY4 >= y) {
						if (((OpeningObject) O).contentIn == 1) {
							myClickedOpening = (OpeningObject) O;
							myClickedFrame = (Frame) frameObject;
							found = true;
						} else if (((OpeningObject) O).contentIn >= 2) {

							found = this.checkContentIn(x, y, frameObject,
									((OpeningObject) O));
							if (found) {
								break;
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"Selected track for Mulliion is Not in Use!\n"
											+ "Please Change Track.",
									"Invalid Track - Error!",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				} else if (whichPos == 2) {
					if ((int) ((OpeningObject) O).startingX <= x
							&& (int) ((OpeningObject) O).highestY <= y
							&& (int) ((OpeningObject) O).bX2 >= x

							&& (int) ((OpeningObject) O).bX3 >= x
							&& (int) ((OpeningObject) O).bY3 >= y
							&& (int) ((OpeningObject) O).bX4 <= x
							&& (int) ((OpeningObject) O).bY4 >= y) {
						if (((OpeningObject) O).contentMid == 1) {
							myClickedOpening = (OpeningObject) O;
							myClickedFrame = (Frame) frameObject;
							found = true;
						} else if (((OpeningObject) O).contentMid == 2) {

							found = this.checkContentMid(x, y, frameObject,
									((OpeningObject) O));

							if (found) {
								break;
							}
						} else if (((OpeningObject) O).contentMid == 3) {

							found = this.checkContentMid(x, y, frameObject,
									((OpeningObject) O));

							if (found) {
								break;
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"Selected track for Mulliion is Not in Use!\n"
											+ "Please Change Track.",
									"Invalid Track - Error!",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				} else if (whichPos == 3) {
					if ((int) ((OpeningObject) O).startingX <= x
							&& (int) ((OpeningObject) O).highestY <= y
							&& (int) ((OpeningObject) O).bX2 >= x

							&& (int) ((OpeningObject) O).bX3 >= x
							&& (int) ((OpeningObject) O).bY3 >= y
							&& (int) ((OpeningObject) O).bX4 <= x
							&& (int) ((OpeningObject) O).bY4 >= y) {
						if (((OpeningObject) O).contentOut == 1) {
							myClickedOpening = (OpeningObject) O;
							myClickedFrame = (Frame) frameObject;
							found = true;
						} else if (((OpeningObject) O).contentOut >= 2) {

							found = this.checkContentOut(x, y, frameObject,
									((OpeningObject) O));
							if (found) {
								break;
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"Selected track for Mulliion is Not in Use!\n"
											+ "Please Change Track.",
									"Invalid Track - Error!",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}

			}
		}

	}

	public boolean checkContentIn(final int x, final int y,
			final Object frameObject, final OpeningObject O) {

		boolean found = false;
		if (O.contentIn == 2) {
			final Object[] frameObjects = O.sashObjectIn.frames.toArray();
			for (final Object S : frameObjects) {
				if ((int) ((SashLeaf) S).startingX <= x
						&& (int) ((SashLeaf) S).highestY <= y
						&& (int) ((SashLeaf) S).bX2 >= x

						&& (int) ((SashLeaf) S).bX3 >= x
						&& (int) ((SashLeaf) S).bY3 >= y
						&& (int) ((SashLeaf) S).bX4 <= x
						&& (int) ((SashLeaf) S).bY4 >= y) {
					final Object[] openingObjects = ((SashLeaf) S).openings
							.toArray();
					for (final Object O2 : openingObjects) {
						if (((OpeningObject) O2).contentMid == 2) {
							if ((int) ((OpeningObject) O2).startingX <= x
									&& (int) ((OpeningObject) O2).highestY <= y
									&& (int) ((OpeningObject) O2).bX2 >= x

									&& (int) ((OpeningObject) O2).bX3 >= x
									&& (int) ((OpeningObject) O2).bY3 >= y
									&& (int) ((OpeningObject) O2).bX4 <= x
									&& (int) ((OpeningObject) O2).bY4 >= y) {

								final Object[] frameObjectsIn = ((OpeningObject) O2).sashObjectIn.frames
										.toArray();
								for (final Object S2 : frameObjectsIn) {
									if ((int) ((SashLeaf) S2).startingX <= x
											&& (int) ((SashLeaf) S2).highestY <= y
											&& (int) ((SashLeaf) S2).bX2 >= x

											&& (int) ((SashLeaf) S2).bX3 >= x
											&& (int) ((SashLeaf) S2).bY3 >= y
											&& (int) ((SashLeaf) S2).bX4 <= x
											&& (int) ((SashLeaf) S2).bY4 >= y) {
										myClickedFrame = (SashLeaf) S2;
										myClickedOpening = (OpeningObject) O2;
										found = true;
										break;
									}
								}
								if (found) {
									break;
								}
							}

						} else {
							myClickedFrame = (SashLeaf) S;
							myClickedOpening = O;
							found = true;
							break;
						}
					}
				}
			}

		} else if (O.contentIn == 3) {

		}

		return found;
	}

	public boolean checkContentMid(final int x, final int y,
			final Object frameObject, final OpeningObject O) {

		boolean found = false;
		if (O.contentMid == 2) {
			final Object[] frameObjects = O.sashObjectMid.frames.toArray();
			for (final Object S : frameObjects) {
				if ((int) ((SashLeaf) S).startingX <= x
						&& (int) ((SashLeaf) S).highestY <= y
						&& (int) ((SashLeaf) S).bX2 >= x

						&& (int) ((SashLeaf) S).bX3 >= x
						&& (int) ((SashLeaf) S).bY3 >= y
						&& (int) ((SashLeaf) S).bX4 <= x
						&& (int) ((SashLeaf) S).bY4 >= y) {
					final Object[] openingObjects = ((SashLeaf) S).openings
							.toArray();

					for (final Object O2 : openingObjects) {

						if (((OpeningObject) O2).contentMid == 2) {
							if ((int) ((OpeningObject) O2).startingX <= x
									&& (int) ((OpeningObject) O2).highestY <= y
									&& (int) ((OpeningObject) O2).bX2 >= x

									&& (int) ((OpeningObject) O2).bX3 >= x
									&& (int) ((OpeningObject) O2).bY3 >= y
									&& (int) ((OpeningObject) O2).bX4 <= x
									&& (int) ((OpeningObject) O2).bY4 >= y) {

								final Object[] frameObjectsMid = ((OpeningObject) O2).sashObjectMid.frames
										.toArray();
								for (final Object S2 : frameObjectsMid) {
									if ((int) ((SashLeaf) S2).startingX <= x
											&& (int) ((SashLeaf) S2).highestY <= y
											&& (int) ((SashLeaf) S2).bX2 >= x

											&& (int) ((SashLeaf) S2).bX3 >= x
											&& (int) ((SashLeaf) S2).bY3 >= y
											&& (int) ((SashLeaf) S2).bX4 <= x
											&& (int) ((SashLeaf) S2).bY4 >= y) {
										myClickedFrame = (SashLeaf) S2;
										myClickedOpening = (OpeningObject) O2;
										found = true;
										break;
									}
								}
								if (found) {

									break;
								}
							}

						} else {
							myClickedFrame = (SashLeaf) S;
							myClickedOpening = O;
							found = true;
							break;
						}

					}
				}
			}

		} else if (O.contentMid == 3) {
			myClickedFrame = (Frame) frameObject;
			myClickedOpening = O;
		}

		return found;
	}

	public boolean checkContentOut(final int x, final int y,
			final Object frameObject, final OpeningObject O) {

		boolean found = false;
		if (O.contentOut == 2) {
			final Object[] frameObjects = O.sashObjectOut.frames.toArray();
			for (final Object S : frameObjects) {
				if ((int) ((SashLeaf) S).startingX <= x
						&& (int) ((SashLeaf) S).highestY <= y
						&& (int) ((SashLeaf) S).bX2 >= x

						&& (int) ((SashLeaf) S).bX3 >= x
						&& (int) ((SashLeaf) S).bY3 >= y
						&& (int) ((SashLeaf) S).bX4 <= x
						&& (int) ((SashLeaf) S).bY4 >= y) {
					final Object[] openingObjects = ((SashLeaf) S).openings
							.toArray();
					for (final Object O2 : openingObjects) {
						if (((OpeningObject) O2).contentMid == 2) {
							if ((int) ((OpeningObject) O2).startingX <= x
									&& (int) ((OpeningObject) O2).highestY <= y
									&& (int) ((OpeningObject) O2).bX2 >= x

									&& (int) ((OpeningObject) O2).bX3 >= x
									&& (int) ((OpeningObject) O2).bY3 >= y
									&& (int) ((OpeningObject) O2).bX4 <= x
									&& (int) ((OpeningObject) O2).bY4 >= y) {

								final Object[] frameObjectsOut = ((OpeningObject) O2).sashObjectMid.frames
										.toArray();
								for (final Object S2 : frameObjectsOut) {
									if ((int) ((SashLeaf) S2).startingX <= x
											&& (int) ((SashLeaf) S2).highestY <= y
											&& (int) ((SashLeaf) S2).bX2 >= x

											&& (int) ((SashLeaf) S2).bX3 >= x
											&& (int) ((SashLeaf) S2).bY3 >= y
											&& (int) ((SashLeaf) S2).bX4 <= x
											&& (int) ((SashLeaf) S2).bY4 >= y) {
										myClickedFrame = (SashLeaf) S2;
										myClickedOpening = (OpeningObject) O2;
										found = true;
										break;
									}
								}
								if (found) {
									break;
								}
							}

						} else {
							myClickedFrame = (SashLeaf) S;
							myClickedOpening = O;
							found = true;
							break;
						}
					}
				}
			}

		} else if (O.contentOut == 3) {

		}

		return found;
	}

	public void drawFacets() throws Exception {

		final Object[] myFacets = frames.toArray();

		for (final Object facet : myFacets) {
			if (myFacets.length == 1) {
				myFrame2.facetUsed = (Facet) facet;

			}

			if (((Facet) facet).bOpeningObject.mullions.size() > 0
					|| ((Facet) facet).bOpeningObject.mullionsH.size() > 0) {
				((Facet) facet).bOpeningObject = ((Facet) facet)
						.doMullions(((Facet) facet).bOpeningObject);
				((Facet) facet).resetRemovedParts();

			}
		}
	}

	/**
	 * Drawing frames for this shapeObject selected
	 */
	public void drawFrames() throws Exception {

		// Get array of frames
		Object[] fs = frames.toArray();

		for (Object frameObject : fs) {

			if (((ShapeObject) frameObject).shapeID != 10) {

				if (((ShapeObject) frameObject).bOpeningObject.mullions.size() > 0
						|| ((ShapeObject) frameObject).bOpeningObject.mullionsH
								.size() > 0) {
					((ShapeObject) frameObject).resetRemovedParts();
				}

				if (myFrame2.selectedDim <= 3) {
					((ShapeObject) frameObject).createTextObjectsTopInit();
					((ShapeObject) frameObject).createTextObjectsLeftInit();
				}
			}
		}
	}

	public void resetRowsCols(final int xcol, final int yrow) {
		yRows = yrow;
		xCols = xcol;

	}

	public void doCouplers() {
		bOpeningObject = this.doMullions(bOpeningObject);
	}

	/**
	 * Create frames object Shape Object
	 * 
	 * @param change
	 *            , boolean
	 * @param recalcMullions
	 *            , boolean
	 * @param initLevelShape
	 *            , boolean
	 * @param recalcFrames
	 *            , boolean
	 */
	public void doFrames(boolean change, boolean recalcMullions,
			boolean initLevelShape, boolean recalcFrames) throws Exception {

		// Create a new collection existing frames
		Collection existingFrames = new ArrayList();

		// Adding all frames loaded
		existingFrames.addAll(frames);

		// Clear frames collection variables
		frames.clear();

		/**
		 * 
		 * Check Get existign Opening Types in Frame Openind - so that we do not
		 * loose the opening in a frame after such operations as Shape Change
		 * 
		 */
		for (Object o : openings.toArray()) {

			OpeningObject opening = (OpeningObject) o;

			if (existingFrames.size() > 0) {

				for (Object f : existingFrames) {

					Frame frame = (Frame) f;

					if (frame.myParentO.a_sequenceID == opening.a_sequenceID) {

						// Get array of openings from Frame object
						Object[] openings = frame.openings.toArray();

						for (Object op : openings) {

							OpeningObject openingFrame = (OpeningObject) op;

							if (frame.controlOpSeq == openingFrame.a_sequenceID) {

								if (openingFrame.contentMid == 2)
									myFrame2.sashType = openingFrame.sashObjectMid;
								else
									myFrame2.getSashType(openingFrame);
							}
						}
					}
				}

			} else {

				if (opening.shapeID == 0)
					opening.shapeID = 1;

				if (myFrame2.sashType == null) {
					myFrame2.getSashType(opening);
				} else {
					myFrame2.setSashType(opening);
				}
			}

			// This is WRONG //////////////////////
			// Initializing sash type with an opening
			// myFrame2.getSashType(opening);
			// /////////////////////////

			// Create a Class drawing and create frames
			CreateFrames createFrame = new CreateFrames(opening,
					existingFrames, myFrame2);

			// Create frame object
			Frame myFrame = createFrame.doFrame(
					myFrame2.sashType.sashClassType,
					myFrame2.sashType.userDefinedOpeningID,
					myFrame2.sashType.openingTypeClass, null,
					myFrame2.sashType, null, myFrame2.sashType.glazedOut,
					change, recalcFrames, true);

			// Setting facet this frame
			myFrame.myFacet = this;

			// Adding frame to collection
			frames.add(myFrame);
		}
	}

	/**
	 * Create facets
	 * 
	 * @param change
	 *            , boolean
	 * @param recalcMullions
	 *            , boolean
	 * @param initLevelShape
	 *            , boolean
	 */
	public void doFacets(boolean change, boolean recalcMullions,
			boolean initLevelShape, boolean sameDims) throws Exception {

		Collection existingFacets = new ArrayList();

		existingFacets.addAll(frames);

		frames.clear();

		Object[] oo = openings.toArray();
		if (!sameDims) {
			for (Object O : oo) {

				if (((OpeningObject) O).shapeID == 0) {
					((OpeningObject) O).shapeID = 1;
				}

				Facet myFacet = new Facet();

				final CreateFacets createFacet = new CreateFacets(
						(OpeningObject) O, existingFacets, myFrame2);

				myFacet = createFacet.doFacet(false, recalcMullions, false,
						true);
				

				myFacet.doCouplers();

				myFacet.doFrames(false, false, false, true);
				myFacet.drawFrames();
				

//				if (this.myFrame2.topRowShapes.size() > 0) {
//					Object[] ops = myFacet.openings.toArray();
//					myFrame2.facetUsed = myFacet;
////					myFacet.openings.clear();
//					boolean goodToGo = false;
//					for (Object o : ops) {
//						for (Object s : this.myFrame2.topRowShapes.toArray()) {
//							if (((OpeningObject) o).a_sequenceID == ((OpeningObject) s).a_sequenceID) {
//								
//								((OpeningObject) o).shapeID = ((OpeningObject) s).shapeID;
//								
//								myFrame2.shapesPanel.selectedShapeLevel = 2;
//								
//								int xxx = (int)(((OpeningObject) s).startingX + 
//										(Math.max(((OpeningObject) s).bX2, ((OpeningObject) s).bX3) 
//										- (Math.min(((OpeningObject) s).startingX, ((OpeningObject) s).bX4))));
//							
//								int yyy =	 (int) (((OpeningObject) s).highestY + 
//										(((OpeningObject) s).lowestY -((OpeningObject) s).highestY));	
//								
//								GetSelectedFrame getSelectedFrame = new GetSelectedFrame(
//										xxx, yyy, myFacet.frames);
//								
//								ShapeObject selectedOpening = this.myFrame2.shapeChangeFrame = getSelectedFrame
//										.getSelectedFrame();
//
//								if (selectedOpening == null) {
//									getSelectedFrame = new GetSelectedFrame(
//											xxx, yyy,
//											myFacet.openings);
//									selectedOpening = getSelectedFrame
//											.getSelectedOpening();
//								}
//								
//								int selectedFrameNo=0;
//								
//								if (((OpeningObject) s).shapeID == 203
//										&& (int) (((OpeningObject) o).widthPix / 2) != (int) ((OpeningObject) o).heightPix) {
//
//									selectedFrameNo = ((OpeningObject) o).startRow;
//
//									Object[] rto = myFrame2.rowTextObjects.toArray();
//
//									myFrame2.rowTextObjects.clear();
//									int i = 0;
//									for (Object r : rto) {
//
//										String w = r.toString();
//
//										if (i == selectedFrameNo - 1) {
//											BigDecimal d = new BigDecimal(
//													(((OpeningObject) o).widthPix / 2));
//											w = d + "";
//										}
//										i++;
//
//										myFrame2.rowTextObjects.add(w);
//									}
//
//									Object[] textFields = myFrame2.myTextLeft;
//
//									for (Object textField : textFields) {
//										JTextField txt = (JTextField) textField;
//										if (((OpeningObject) o).startRow == Integer
//												.parseInt(txt.getName())) {
//											txt.setText(((OpeningObject) o).widthPix / 2
//													+ "");
//											break;
//										}
//
//									}
//
//									myFrame2.jobItem.myCanvas.modFrameRowH(((OpeningObject) o).widthPix / 2);
//
//									myFrame2.jobItem.myCanvas.validate();
//									myFrame2.jobItem.myCanvas.repaint();
//								}
//
//								double minL = ((OpeningObject) o).bot1Part.partDimB;
//								if (myFrame2.currentUOM == 1) {
//									minL = ((OpeningObject) o).bot1Part.partDimB;
//								} else {
//									minL = ((OpeningObject) o).bot1Part.partDimBi;
//								}
//							
//								if (((OpeningObject) s).shapeID == 200
//										&& (int) ((OpeningObject) o).heightPix < minL * 2
//												+ (int) (((OpeningObject) o).widthPix / 2)) {
//									
//									
//				
//								}
//
//								
//								if ((((OpeningObject) s).shapeID == 204 || ((OpeningObject) s).shapeID == 205)
//										&& (int) ((OpeningObject) o).widthPix != (int) ((OpeningObject) o).heightPix) {
//									
//
//								}
//
//								if (((OpeningObject) s).shapeID >= 700
//										&& ((OpeningObject) s).shapeID < 800) {
//									if (selectedOpening.xCols > 1
//											&& selectedOpening.yRows > 1) {
//										
//										
//									
//									}
//								}
//
//								// New LeanTo
//								SetLeanTo setlean = new SetLeanTo(
//										((OpeningObject) s).shapeID, 0, 0, 0, 0);
//
//				
//							
//								myFrame2.resetModTextsV = true;
//								myFrame2.resetModTextsH = true;
//								
//								ShapeDimensionDialog shapeDialog = new ShapeDimensionDialog(myFrame2.jobItem.myCanvas,
//										selectedOpening, xxx, yyy, 2, ((OpeningObject) s).shapeID);
//								
//								
//								
//								
//								
//							}
//						}
//						
//						
//					}
//					
//					
//
//					this.myFrame2.topRowShapes.clear();
//				} 

				myFacet.setOriginalDimsInit(myFacet.widthPix, myFacet.heightPix);
				myFacet.setDimsChange(myFacet.widthPix, myFacet.heightPix);

				frames.add(myFacet);

			}
		} else {
			for (Object f : existingFacets) {
				((Facet) f).drawFrames();
				((Facet) f).setOriginalDimsInit(((Facet) f).widthPix,
						((Facet) f).heightPix);
				((Facet) f).setDimsChange(((Facet) f).widthPix,
						((Facet) f).heightPix);

				frames.add(myFacet);
			}
		}

		existingFacets = null;
	}

	public void addRows() {
		yRows = yRows + 1;
	}

	public void addColumn(final int pos) {
		xCols = xCols + 1;
	}

	public void removeColumn() {
		xCols = xCols - 1;

	}

	public void removeRows() {
		yRows = yRows - 1;
	}

	private void addNewVCoupler(final Profiles mycoupler, final int startRow,
			final int endRow, final int endCol, final double y1,
			final double y2, final double ys, final double y3, final double y4,
			final double ye) {

		final double thickness = mycoupler.thickness;

		final Profiles coupler = new Profiles();

		coupler.isExtra = true;
		coupler.rowCol = mycoupler.rowCol;
		coupler.startPos = startRow;
		coupler.endPos = endRow;
		coupler.x1 = mycoupler.x1;
		coupler.x2 = mycoupler.x2;
		coupler.x3 = mycoupler.x3;
		coupler.x4 = mycoupler.x4;
		coupler.x1a = mycoupler.x1a;
		coupler.x2a = mycoupler.x2a;
		coupler.x3a = mycoupler.x3a;
		coupler.x4a = mycoupler.x4a;
		coupler.centerXs = mycoupler.centerXs;
		coupler.centerXe = mycoupler.centerXe;
		coupler.thickness = thickness;
		coupler.y1 = y1;
		coupler.y2 = y2;
		coupler.y3 = y3;
		coupler.y4 = y4;
		coupler.y1a = y1;
		coupler.y2a = y2;
		coupler.y3a = y3;
		coupler.y4a = y4;
		coupler.centerYs = ys;
		coupler.centerYe = ye;

		this.bOpeningObject = doMullions(this.bOpeningObject);
		bOpeningObject.mullions.add(coupler);

	}

	private void addNewHCoupler(final Profiles mycoupler, final int startRow,
			final int endRow, final int endCol, final double x1,
			final double x2, final double xs, final double x3, final double x4,
			final double xe) {

		final double thickness = mycoupler.thickness;

		final Profiles coupler = new Profiles();

		coupler.isExtra = true;
		coupler.rowCol = mycoupler.rowCol;
		coupler.startPos = startRow;
		coupler.endPos = endRow;
		coupler.y1 = mycoupler.y1;
		coupler.y2 = mycoupler.y2;
		coupler.y3 = mycoupler.y3;
		coupler.y4 = mycoupler.y4;
		coupler.y1a = mycoupler.y1a;
		coupler.y2a = mycoupler.y2a;
		coupler.y3a = mycoupler.y3a;
		coupler.y4a = mycoupler.y4a;
		coupler.centerYs = mycoupler.centerYs;
		coupler.centerYe = mycoupler.centerYe;
		coupler.thickness = thickness;
		coupler.x1 = coupler.x1a = x1;
		coupler.x2 = coupler.x2a = x2;
		coupler.x3 = coupler.x3a = x3;
		coupler.x4 = coupler.x4a = x4;
		coupler.centerXs = xs;
		coupler.centerXe = xe;

		this.bOpeningObject = doMullions(this.bOpeningObject);
		bOpeningObject.mullions.add(coupler);

	}

	public void recalcCouplersV() {

		Object[] VCs = this.bOpeningObject.mullions.toArray();
		this.bOpeningObject.mullions.clear();
		for (final Object VC : VCs) {

			if (!((Profiles) VC).isExtra && ((Profiles) VC).startPos == 1) {
				this.getframesLR(((Profiles) VC), 1);

				this.bOpeningObject.mullions.add(VC);

			} else if (!((Profiles) VC).isExtra) {

				this.bOpeningObject.mullions.add(VC);
			}
		}

		VCs = bOpeningObject.mullions.toArray();

		this.bOpeningObject.mullions.clear();

		for (final Object VC : VCs) {
			if (!((Profiles) VC).isExtra && ((Profiles) VC).endPos == yRows) {
				this.getframesLR(((Profiles) VC), yRows);

				this.bOpeningObject.mullions.add(VC);
			} else if (!((Profiles) VC).isExtra) {

				this.bOpeningObject.mullions.add(VC);
			}
		}

	}

	public void recalcCouplersH() {

		final Object[] HCs = this.bOpeningObject.mullionsH.toArray();

		// ((ShapeObject) this).bOpeningObject.mullionsH
		// .clear();

		for (final Object HC : HCs) {

			// break Mullion into small pieces 1
			// for each
			// frame

			if (!((Profiles) HC).isExtra) {
				this.getframesTB((Profiles) HC, ((Profiles) HC).startPos);

				// ((ShapeObject) this).bOpeningObject.mullionsH
				// .add(HC);

			} else if (!((Profiles) HC).isExtra) {

				this.bOpeningObject.mullionsH.add(HC);
			}
		}

	}

	public void getframesLR(final Profiles cv, final int row) {

		final Object[] frameObjects = frames.toArray();
		Frame l = null;
		Frame r = null;

		for (final Object frameObject : frameObjects) {
			if (row == 1) {
				if (((Frame) frameObject).endCol == cv.rowCol
						&& ((Frame) frameObject).startRow == row
						&& ((Frame) frameObject).endRow <= cv.endPos) {
					l = (Frame) frameObject;

				} // if shape change
				if (((Frame) frameObject).startCol == cv.rowCol + 1
						&& ((Frame) frameObject).startRow == row
						&& ((Frame) frameObject).endRow <= cv.endPos) {
					r = (Frame) frameObject;

				}
			} else {
				if (((Frame) frameObject).endCol == cv.rowCol
						&& ((Frame) frameObject).startRow <= row
						&& ((Frame) frameObject).endRow >= row) {
					l = (Frame) frameObject;

				} // if shape change
				if (((Frame) frameObject).startCol == cv.rowCol + 1
						&& ((Frame) frameObject).startRow <= row
						&& ((Frame) frameObject).endRow >= row) {
					r = (Frame) frameObject;

				}
			}
			if (l != null && r != null) {
				break;
			}

		}// for frame
		if (l != null && r != null) {
			this.verifyCouplersV(l, r, cv, row);
		}

	}

	public Object[] getframesTB(final Profiles HC, final int col) {

		final Object[] tbF = new Object[2];

		final Object[] frameObjects = frames.toArray();
		Frame t = null;
		Frame b = null;

		for (final Object frameObject : frameObjects) {
			if (((Frame) frameObject).endRow == HC.rowCol
					&& ((Frame) frameObject).startCol == col
					&& ((Frame) frameObject).endCol <= HC.endPos) {
				t = (Frame) frameObject;
				tbF[0] = t;

			} // if shape change
			if (((Frame) frameObject).startRow == HC.rowCol + 1
					&& ((Frame) frameObject).startCol == col
					&& ((Frame) frameObject).endCol <= HC.endPos) {
				b = (Frame) frameObject;
				tbF[1] = t;

			}
			if (t != null && b != null) {
				break;
			}

		}// for frame

		if (t != null && b != null) {
			// this.verifyCouplersH(t, b, HC, col);
		}
		return tbF;

	}

	private void verifyCouplersV(final Frame l, final Frame r,
			final Profiles VC, final int row) {

		double rowHrow1L = 0;
		double rowHrow1R = 0;

		final Object[] couplerObjectsH = this.bOpeningObject.mullionsH
				.toArray();

		Profiles myBotMullionHL = null;
		Profiles myBotMullionHR = null;
		for (final Object element : couplerObjectsH) {

			if (((Profiles) element).rowCol == 1
					&& ((Profiles) element).endPos == VC.rowCol) {
				rowHrow1L = ((Profiles) element).y4 - l.bY2;
				myBotMullionHL = (Profiles) element;

			}
			if (((Profiles) element).rowCol == 1
					&& ((Profiles) element).startPos - 1 == VC.rowCol) {
				rowHrow1R = ((Profiles) element).y4 - l.bY2;
				myBotMullionHR = (Profiles) element;

			}

		}

		Math.max(rowHrow1L, rowHrow1R);

		double rowHrowLastL = 0;
		double rowHrowLastR = 0;

		for (final Object element : couplerObjectsH) {

			if (((Profiles) element).rowCol == yRows - 1
					&& ((Profiles) element).endPos == VC.rowCol) {
				rowHrowLastL = ((Profiles) element).y1;

			}
			if (((Profiles) element).rowCol == 1
					&& ((Profiles) element).startPos - 1 == VC.rowCol) {
				rowHrowLastR = ((Profiles) element).y1;

			}

		}
		Math.max(rowHrowLastL, rowHrowLastR);

		if (l.shapeID == 10 || r.shapeID == 10) {
			Math.max(rowHrowLastL, rowHrowLastR);
		}
		VC.x1a = VC.x1;

		VC.x4a = VC.x4;

		VC.x2a = VC.x2;
		VC.x3a = VC.x3;

		VC.y1a = VC.y1b = VC.y1a3 = VC.ycs = VC.y1;

		VC.y4a = VC.y4b = VC.y4a3 = VC.yce = VC.y4;

		VC.y2a = VC.y2b = VC.y2a3 = VC.y2;
		VC.y3a = VC.y3b = VC.y3a3 = VC.y3;

		if (r.shapeID == 10 || l.shapeID == 10) {
			if (VC.startPos != yRows) {
				if (myBotMullionHL != null && myBotMullionHR != null) {
					VC.y1a = VC.y1b = VC.y1a3 = VC.ycs = Math.max(
							myBotMullionHL.y4, myBotMullionHR.y1);
				} else if (myBotMullionHL == null && myBotMullionHR != null) {
					VC.y1a = VC.y1b = VC.y1a3 = VC.ycs = myBotMullionHR.y1;
				} else if (myBotMullionHL != null && myBotMullionHR == null) {
					VC.y1a = VC.y1b = VC.y1a3 = VC.ycs = myBotMullionHL.y4;
				}
				VC.y2a = VC.y1a;
				VC.y3a = VC.y3;
				VC.y4a = VC.yce = VC.y4;
			}

			if (VC.endPos == yRows
					&& (r.endRow == yRows && r.shapeID == 10 || l.endRow == yRows
							&& l.shapeID == 10)) {
				VC.y1a = VC.y1b = VC.y1a3 = VC.ycs = VC.y1;
				VC.y2a = VC.y2;
				VC.y3a = VC.y3b = VC.y3a3 = Math.min(myBotMullionHL.y2,
						myBotMullionHR.y3);
				VC.y4a = VC.yce = VC.y3a;
			}
		} else if (l.lean2 == 1 && r.lean4 == 2 && l.shapeID != 10
				&& r.shapeID != 10) {

			this.addNewVCoupler(VC, l.startRow, l.startRow, l.endCol,
					Math.max(l.bY2, r.startingY), Math.max(l.bY2, r.startingY),
					Math.max(l.bY2, r.startingY), Math.max(l.bY2, r.startingY),
					Math.max(l.bY2, r.startingY), Math.max(l.bY2, r.startingY));
			VC.finalVerify = true;

		} else if ((l.lean2 == 1 && r.lean4 == 0 || l.lean2 == 0
				&& r.lean4 == 2)
				&& l.shapeID != 10 && r.shapeID != 10) {

			this.addNewVCoupler(VC, l.startRow, l.startRow, l.endCol,
					Math.max(l.bY2, r.startingY), Math.max(l.bY2, r.startingY),
					Math.max(l.bY2, r.startingY), Math.max(l.bY2, r.startingY),
					Math.max(l.bY2, r.startingY), Math.max(l.bY2, r.startingY));

		} else if ((l.lean2 == 3 || r.lean4 == 3) && l.shapeID != 10
				&& r.shapeID != 10) {

			this.addNewVCoupler(VC, l.startRow, l.startRow, l.endCol,
					Math.max(l.bY2, r.startingY), Math.max(l.bY2, r.startingY),
					Math.max(l.bY2, r.startingY),

					Math.max(l.bY2, r.startingY), Math.max(l.bY2, r.startingY),
					Math.max(l.bY2, r.startingY));
			VC.finalVerify = true;

		} else if ((l.lean2 == 2 || l.lean2 == 0)
				&& (r.lean4 == 0 || r.lean4 == 1) && l.shapeID != 10
				&& r.shapeID != 10) {
			if (row == 1) {

				VC.y1a = VC.y1b = VC.y1a3 = VC.ycs = Math.max(l.bY2,
						r.startingY);

				VC.y2a = VC.y2b = VC.y2a3 = Math.max(l.bY2, r.startingY);

				VC.y3a = VC.y3b = VC.y3a3 = VC.y3;

				VC.y4a = VC.y4b = VC.y4a3 = VC.yce = VC.y4;

				VC.length = Math.max(VC.y3a, VC.y4a) - Math.min(VC.y2a, VC.y1a);
				VC.finalVerify = true;
			} else {

			}

		}

		if (VC.y1a == VC.y4a) {
			VC.x2a = VC.x1;
			VC.x3a = VC.x4;
		}

	}

	private void verifyCouplersHNEW() {

		final Object[] frameObjects = frames.toArray();

		final Object[] HCs = this.bOpeningObject.mullionsH.toArray();

		final Collection hMBot = new ArrayList();
		boolean addM = false;
		for (final Object f : frameObjects) {

			Profiles myM = new Profiles();

			if (((Frame) f).botIn && ((Frame) f).shapeID != 10) {
				if (((Frame) f).lean4 == 0 || ((Frame) f).lean4 == 1) {
					if (((Frame) f).lean2 == 0 || ((Frame) f).lean2 == 2) {
						if (((Frame) f).noSidesBot == 1) {
							for (final Object hc : HCs) {
								myM = ((Profiles) hc).cloneProfile(
										((Profiles) hc), this.bOpeningObject);
								if (((Profiles) hc).rowCol == ((Frame) f).endRow) {

									myM.x4 = myM.x3 = myM.x4a = myM.x3a = ((Frame) f).bot1Part.startXC;
									myM.x1 = myM.x2 = myM.x1a = myM.x2a = ((Frame) f).bot1Part.endXC;
									myM.endPos = ((Frame) f).endCol;
									myM.startPos = ((Frame) f).startCol;
									myM.rowCol = ((Frame) f).endRow;
									addM = true;
									break;
								}
							}

						}
						if (((Frame) f).noSidesBot == 2) {
							if (((Frame) f).lean4 == 0) {
								for (final Object hc : HCs) {
									myM = ((Profiles) hc).cloneProfile(
											((Profiles) hc),
											this.bOpeningObject);
									if (((Profiles) hc).rowCol == ((Frame) f).endRow) {
										// myM
										// = ((Profiles)
										// hc).cloneProfile(((Profiles)
										// hc));
										myM.x4 = myM.x3 = ((Frame) f).bot2Part.startXC;
										myM.x1 = myM.x2 = ((Frame) f).bot2Part.endXC;
										myM.x4a = myM.x3a = ((Frame) f).bot2Part.startXC;
										myM.x1a = myM.x2a = ((Frame) f).bot2Part.endXC;
										myM.endPos = ((Frame) f).endCol;
										myM.startPos = ((Frame) f).startCol;
										myM.rowCol = ((Frame) f).endRow;
										addM = true;
										break;
									}
								}
							} else if (((Frame) f).lean4 == 2) {
								for (final Object hc : HCs) {
									myM = (Profiles) ((Profiles) hc)
											.cloneProfile(((Profiles) hc));
									if (((Profiles) hc).rowCol == ((Frame) f).endRow) {
										// myM
										// = ((Profiles)
										// hc).cloneProfile(((Profiles)
										// hc));
										myM.x4 = myM.x3 = ((Frame) f).bot1Part.startXC;
										myM.x1 = myM.x2 = ((Frame) f).bot1Part.endXC;
										myM.x4a = myM.x3a = ((Frame) f).bot1Part.startXC;
										myM.x1a = myM.x2a = ((Frame) f).bot1Part.endXC;
										myM.endPos = ((Frame) f).endCol;
										myM.startPos = ((Frame) f).startCol;
										myM.rowCol = ((Frame) f).endRow;
										addM = true;
										break;
									}
								}
							} else if (((Frame) f).noSidesBot == 3) {
								for (final Object hc : HCs) {
									myM = ((Profiles) hc).cloneProfile(
											((Profiles) hc),
											this.bOpeningObject);
									if (((Profiles) hc).rowCol == ((Frame) f).endRow) {
										// myM
										// = ((Profiles)
										// hc).cloneProfile(((Profiles)
										// hc));
										myM.x4 = myM.x3 = ((Frame) f).bot3Part.startXC;
										myM.x1 = myM.x2 = ((Frame) f).bot3Part.endXC;
										myM.x4a = myM.x3a = ((Frame) f).bot3Part.startXC;
										myM.x1a = myM.x2a = ((Frame) f).bot3Part.endXC;
										myM.endPos = ((Frame) f).endCol;
										myM.startPos = ((Frame) f).startCol;
										myM.rowCol = ((Frame) f).endRow;
										addM = true;
										break;
									}
								}
							}
						}
					}
				}
				if (addM) {
					myM.length = Math.max(myM.x3a, myM.x4a)
							- Math.min(myM.x1a, myM.x2a);
					myM.finalVerify = true;
					hMBot.add(myM); // add
					// if not 10 and
					// BotIn = true
				}

			} else if (((Frame) f).botIn && ((Frame) f).shapeID == 10) {
				for (final Object hc : HCs) {
					myM = ((Profiles) hc).cloneProfile(((Profiles) hc),
							this.bOpeningObject);
					if (((Profiles) hc).rowCol == ((Frame) f).endRow) {

						myM.x4 = myM.x3 = myM.x4a = myM.x3a = ((Frame) f).bX3;
						myM.x1 = myM.x2 = myM.x1a = myM.x2a = ((Frame) f).bX4;
						myM.endPos = ((Frame) f).endCol;
						myM.startPos = ((Frame) f).startCol;
						myM.rowCol = ((Frame) f).endRow;
						myM.isValid = false;
						addM = true;
						break;
					}
				}
				if (addM) {
					myM.length = Math.max(myM.x3a, myM.x4a)
							- Math.min(myM.x1a, myM.x2a);
					myM.finalVerify = true;
					hMBot.add(myM); // add
					// if not 10 and
					// BotIn = true
				}
			}

		}

		final Collection hMTop = new ArrayList();

		hMBot.toArray();

		for (final Object f : frameObjects) {

			Profiles myM = new Profiles();

			if (((Frame) f).topIn && ((Frame) f).shapeID != 10) {
				if (((Frame) f).lean4 == 0 || ((Frame) f).lean4 == 2) {
					if (((Frame) f).lean2 == 0 || ((Frame) f).lean2 == 1) {
						if (((Frame) f).noSidesTop == 1) {
							for (final Object hc : HCs) {
								myM = ((Profiles) hc).cloneProfile(
										((Profiles) hc), this.bOpeningObject);
								if (((Profiles) hc).rowCol == ((Frame) f).startRow - 1) {

									myM.x4 = myM.x3 = myM.x4a = myM.x3a = ((Frame) f).top1Part.endXC;
									myM.x1 = myM.x2 = myM.x1a = myM.x2a = ((Frame) f).top1Part.startXC;
									myM.endPos = ((Frame) f).endCol;
									myM.startPos = ((Frame) f).startCol;
									myM.rowCol = ((Frame) f).startRow - 1;
									addM = true;
									break;
								}
							}

						}
						if (((Frame) f).noSidesTop == 2) {
							if (((Frame) f).lean4 == 1) {
								for (final Object hc : HCs) {
									myM = ((Profiles) hc).cloneProfile(
											((Profiles) hc),
											this.bOpeningObject);
									if (((Profiles) hc).rowCol == ((Frame) f).startRow - 1) {
										// myM
										// = ((Profiles)
										// hc).cloneProfile(((Profiles)
										// hc));
										myM.x4 = myM.x3 = ((Frame) f).top2Part.endXC;
										myM.x1 = myM.x2 = ((Frame) f).top2Part.startXC;
										myM.x4a = myM.x3a = ((Frame) f).top2Part.endXC;
										myM.x1a = myM.x2a = ((Frame) f).top2Part.startXC;
										myM.endPos = ((Frame) f).endCol;
										myM.startPos = ((Frame) f).startCol;
										myM.rowCol = ((Frame) f).startRow - 1;
										addM = true;
										break;
									}
								}
							} else if (((Frame) f).lean2 == 2) {
								for (final Object hc : HCs) {
									myM = (Profiles) ((Profiles) hc)
											.cloneProfile(((Profiles) hc));
									if (((Profiles) hc).rowCol == ((Frame) f).startRow - 1) {
										// myM
										// = ((Profiles)
										// hc).cloneProfile(((Profiles)
										// hc));
										myM.x4 = myM.x3 = ((Frame) f).top1Part.endXC;
										myM.x1 = myM.x2 = ((Frame) f).top1Part.startXC;
										myM.x4a = myM.x3a = ((Frame) f).top1Part.endXC;
										myM.x1a = myM.x2a = ((Frame) f).top1Part.startXC;
										myM.endPos = ((Frame) f).endCol;
										myM.startPos = ((Frame) f).startCol;
										myM.rowCol = ((Frame) f).startRow - 1;
										addM = true;
										break;
									}
								}
							} else if (((Frame) f).noSidesTop == 3) {
								for (final Object hc : HCs) {
									myM = ((Profiles) hc).cloneProfile(
											((Profiles) hc),
											this.bOpeningObject);
									if (((Profiles) hc).rowCol == ((Frame) f).startRow - 1) {
										// myM
										// = ((Profiles)
										// hc).cloneProfile(((Profiles)
										// hc));
										myM.x4 = myM.x3 = ((Frame) f).top3Part.endXC;
										myM.x1 = myM.x2 = ((Frame) f).top3Part.startXC;
										myM.x4a = myM.x3a = ((Frame) f).top3Part.endXC;
										myM.x1a = myM.x2a = ((Frame) f).top3Part.startXC;
										myM.endPos = ((Frame) f).endCol;
										myM.startPos = ((Frame) f).startCol;
										myM.rowCol = ((Frame) f).startRow - 1;
										addM = true;
										break;

									}
								}
							}
						}
					}
				}
				if (addM) {
					myM.length = Math.max(myM.x3a, myM.x4a)
							- Math.min(myM.x1a, myM.x2a);
					myM.finalVerify = true;
					hMTop.add(myM); // add
					// if not 10 and
					// BotIn = true
				}

			} else if (((Frame) f).topIn && ((Frame) f).shapeID == 10) {
				for (final Object hc : HCs) {
					myM = ((Profiles) hc).cloneProfile(((Profiles) hc),
							this.bOpeningObject);
					if (((Profiles) hc).rowCol == ((Frame) f).startRow - 1) {

						myM.x4 = myM.x3 = myM.x4a = myM.x3a = ((Frame) f).bX3;
						myM.x1 = myM.x2 = myM.x1a = myM.x2a = ((Frame) f).bX4;
						myM.endPos = ((Frame) f).endCol;
						myM.startPos = ((Frame) f).startCol;
						myM.rowCol = ((Frame) f).startRow - 1;
						myM.isValid = false;
						addM = true;
						break;
					}
				}
				if (addM) {
					myM.length = Math.max(myM.x3a, myM.x4a)
							- Math.min(myM.x1a, myM.x2a);
					myM.finalVerify = true;
					hMTop.add(myM); // add
					// if not 10 and
					// BotIn = true
				}
			}

		}

		final Collection finalHs = new ArrayList();

		final Object[] myBots = hMBot.toArray();
		final Object[] myTops = hMTop.toArray();
		int endp = 0;
		for (final Object b : myBots) {
			for (final Object t : myTops) {
				if (((Profiles) b).rowCol == ((Profiles) t).rowCol
						&& ((Profiles) b).startPos >= endp
						&& ((Profiles) t).startPos >= endp) {

					Profiles myM = new Profiles();

					if (((Profiles) b).length < ((Profiles) t).length) {
						if (((Profiles) t).isValid) {
							myM = ((Profiles) t).cloneProfile(((Profiles) t),
									bOpeningObject);

							for (final Object b2 : myBots) {
								if (!((Profiles) b2).isValid
										&& ((Profiles) b2).rowCol == myM.rowCol
										&& ((Profiles) b2).startPos >= myM.startPos
										&& ((Profiles) b2).endPos <= myM.endPos
										&& ((Profiles) b2).endPos < bOpeningObject.xCols) {

									myM.startPos = ((Profiles) b2).endPos + 1;
									myM.x1 = ((Profiles) b2).x4;
									myM.x1a = ((Profiles) b2).x4a;
									myM.x2 = ((Profiles) b2).x3;
									myM.x2a = ((Profiles) b2).x3a;

									myM.length = Math.max(myM.x3a, myM.x4a)
											- Math.min(myM.x1a, myM.x2a);

								}
								if (!((Profiles) b2).isValid
										&& ((Profiles) b2).rowCol == myM.rowCol
										&& ((Profiles) b2).startPos >= myM.startPos
										&& ((Profiles) b2).endPos <= myM.endPos
										&& ((Profiles) b2).endPos == bOpeningObject.xCols) {

									myM.endPos = ((Profiles) b2).startPos - 1;
									myM.x4 = ((Profiles) b2).x1;
									myM.x4a = ((Profiles) b2).x1a;
									myM.x3 = ((Profiles) b2).x2;
									myM.x3a = ((Profiles) b2).x2a;

									myM.length = Math.max(myM.x3a, myM.x4a)
											- Math.min(myM.x1a, myM.x2a);

								}

							}
							endp = myM.endPos;
						}

					} else if (((Profiles) b).length > ((Profiles) t).length) {

						myM = ((Profiles) b).cloneProfile(((Profiles) b),
								bOpeningObject);

					} else if (((Profiles) b).length == ((Profiles) t).length) {

						myM = (Profiles) b;

					}

					finalHs.add(myM);
					//
				}
			}
		}

		if (finalHs.size() > 0) {

			this.bOpeningObject.mullionsH.clear();

			this.bOpeningObject.mullionsH.addAll(finalHs);

		}

	}

	public Profiles whichMullion(final Profiles mfb, final Profiles mft) {

		Profiles myM = new Profiles();
		// int endp =0;
		// int startp =0;
		if (mfb.length < mft.length) {
			myM = mft.cloneProfile(mft, bOpeningObject);

		} else if (mfb.length > mft.length) {

			myM = mfb.cloneProfile(mfb, bOpeningObject);

		} else if (mfb.length == mft.length) {
			myM = mfb;
		}

		return myM;
	}

	private void verifyCouplersH(final Frame t, final Frame b,
			final Profiles HC, final int col) {

		// / Change HERE
		/*
		 * If V Mullion Thick is 0 and H Mullion Continous. We need to make sure
		 * that the H Mullion is Split into pieces under the existing frames.
		 * ?????????
		 */

		if (t.shapeChanged || b.shapeChanged) {

			if (t.shapeID == 10 || b.shapeID == 10 || t.lean4 == 2
					|| t.lean4 == 3 || t.lean2 == 1 || t.lean2 == 3
					|| t.lean3 == 2 || t.lean3 == 3

					|| b.lean == 3 || b.lean == 1 || b.lean4 == 1
					|| b.lean4 == 3 || b.lean2 == 2 || b.lean3 == 3) {

				HC.x1a = HC.x4;

				HC.x4a = HC.x4;

				HC.x2a = HC.x4;
				HC.x3a = HC.x4;

				HC.y1a = HC.y4;
				HC.y2a = HC.y4;
				HC.y3a = HC.y4;
				HC.y4a = HC.y4;

				HC.length = Math.max(HC.x2a, HC.x1a) - Math.min(HC.x3a, HC.x4a);

				HC.finalVerify = true;

				if (t.lean3 == 2 && b.lean == 1 && t.shapeID != 10
						&& b.shapeID != 10) {

					this.addNewVCoupler(HC, t.startCol, t.startCol, t.endRow,
							Math.max(t.bX4, b.startingX),
							Math.max(t.bX4, b.startingX),
							Math.max(t.bX4, b.startingX),

							Math.max(t.bX4, b.startingX),

							Math.max(t.bX4, b.startingX),

							Math.max(t.bX4, b.startingX));

				} else if ((t.lean3 == 2 && b.lean == 0 || t.lean3 == 0
						&& b.lean == 1)
						&& t.shapeID != 10 && b.shapeID != 10) {

					this.addNewVCoupler(HC, t.startCol, t.startCol, t.endRow,
							Math.max(t.bX4, b.startingX),
							Math.max(t.bX4, b.startingX),
							Math.max(t.bX4, b.startingX),

							Math.max(t.bX4, b.startingX),

							Math.max(t.bX4, b.startingX),

							Math.max(t.bX4, b.startingX));

				} else if ((t.lean2 == 3 || b.lean == 3) && t.shapeID != 10
						&& b.shapeID != 10) {

					this.addNewVCoupler(
							HC,
							t.startCol,
							t.startCol,
							t.endRow,
							Math.max(t.bX4, b.startingX),
							Math.max(t.bX4, b.startingX),
							Math.max(t.bX4, b.startingX),

							Math.max(t.bX4, b.startingX)
									+ Math.min(t.bX4, b.startingX),

							Math.max(t.bX4, b.startingX)
									+ Math.min(t.bX4, b.startingX),

							Math.max(t.bX4, b.startingX)
									+ Math.min(t.bX4, b.startingX));

				}

			} else if (t.lean3 == 0 && b.lean == 0) {

				HC.x1a = HC.x1;
				HC.x2a = HC.x2;
				HC.x3a = HC.x3;
				HC.x4a = HC.x4;
				HC.y1a = HC.y1;
				HC.y2a = HC.y2;
				HC.y3a = HC.y3;
				HC.y4a = HC.y4;
				HC.length = Math.max(HC.x2a, HC.x1a) - Math.min(HC.x3a, HC.x4a);

				HC.finalVerify = false;

			} else if ((t.lean3 == 1 || t.lean3 == 0)
					&& (b.lean == 0 || b.lean4 == 2)) {
				if (col == 1) {
					HC.x1a = Math.max(t.bX4, b.startingX);

					HC.x4a = Math.max(t.bX4, b.startingX);

				} else {
					HC.x1a = Math.min(t.bX4, b.startingX);

					HC.x4a = Math.min(t.bX4, b.startingX);
					HC.x2a = Math.min(t.bX4, b.startingX);

					HC.x3a = Math.min(t.bX4, b.startingX);
				}
				HC.length = Math.max(HC.x2a, HC.x1a) - Math.min(HC.x3a, HC.x4a);
				HC.finalVerify = true;
			}

			// ///////////////////////
			// ////////////////////////////////
		}
	}

	public void modifyInternalDims(final int position, final int orientation)
			throws Exception {// 1 Top orientation

		// 1=Widths
		// 2=Heights

		if (!myFrame2.modifyDims) {
			newDesign = false;
			top1.topFillShape.reset();
			top1.topObjectPath.reset();
			// myFrame2.jobItem.myCanvas
			// .clearDrawObjects();
			myFrame2.myTextRow = null;
			// myFrame2.myTextBot =
			// null;
			myFrame2.myTextLeft = null;
			myFrame2.myTextRight = null;
			myFrame2.jobItem.myCanvas = new DrawCanvas(myFrame2,
					myFrame2.jobItem.myCanvas.selectedRadioForRow,
					myFrame2.jobItem.myCanvas.selectedRadioForCol,
					myFrame2.jobItem.myCanvas.selectedRadioForRowo,
					myFrame2.jobItem.myCanvas.selectedRadioForColo);
			myFrame2.mainFramePanel.removeAll();

			if (orientation == 1) {
				this.modifyVMullionPos(position);

			} else {
				this.modifyHMullionPos(position);

			}
			myFrame2.jobItem.resetGraphics();

			myFrame2.ellipses.clear();
			myFrame2.topTexts.clear();
			myFrame2.botTexts.clear();
			myFrame2.leftTexts.clear();
			myFrame2.rightTexts.clear();

			this.doFrames(true, true, true, true);

			myFrame2.modifyDims = true;
			myFrame2.jobItem.resetGraphics();

		}
	}

	public void resizeSashes(final Collection sashes, final Object[] myFrames)
			throws Exception {

		if (sashes.size() > 0) {
			frames.clear();
			for (final Object f : myFrames) {
				final Collection mySashes = new ArrayList();
				for (final Object s : sashes) {

					if (((SashTypeObject) s).myParentO != null
							&& ((SashTypeObject) s).myParentO.myParent.a_sequenceID == ((Frame) f).a_sequenceID) {
						mySashes.add(s);
					}

				}

				final Object[] op = ((Frame) f).openings.toArray();
				((Frame) f).openings.clear();

				for (Object o : op) {

					for (final Object ss : mySashes.toArray()) {
						if (((OpeningObject) o).a_sequenceID == ((SashTypeObject) ss).myParentO.a_sequenceID) {

							CreateSash createSash = new CreateSash(
									((OpeningObject) o),
									((SashTypeObject) ss).sashClassType,
									((SashTypeObject) ss).userDefinedOpeningID,
									((SashTypeObject) ss).noOfLeafs,
									((SashTypeObject) ss).noTracks,
									((SashTypeObject) ss).sashOnTrack, 2,
									((SashTypeObject) ss).split,
									((SashTypeObject) ss).opens, null,
									((SashTypeObject) ss).glazedOut,
									((SashTypeObject) ss).sashGlazedOut,
									((SashTypeObject) ss).paneType,
									((SashTypeObject) ss).isOriel,
									((SashTypeObject) ss).interLocks,
									((SashTypeObject) ss).extraExtend,
									myFrame2,
									((SashTypeObject) ss).openingTypeClass);

							o = createSash.doNewSash(((SashTypeObject) ss),
									true, null);

							createSash = null;
						}

					}
					((Frame) f).openings.add(o);
				}
				frames.add(f);
			}
		}

		myFrame2.jobItem.resetGraphics();

	}

	public void initFacetObject() throws Exception {

		xCols = xCols;
		yRows = yRows;
		widthPix = myFrame2.jobItem.design_flat_WIDTHpix;

		heightPix = myFrame2.jobItem._HEIGHTpix;
		levelW = myFrame2.jobItem.design_flat_WIDTHpix;

		levelH = myFrame2.jobItem._HEIGHTpix;

		this.setNumSides(shapeID);

		bX2 = startingX + myFrame2.jobItem.design_flat_WIDTHpix;
		bY2 = startingY;
		bX3 = bX2;
		bY3 = startingY + myFrame2.jobItem._HEIGHTpix;
		bX4 = startingX;
		bY4 = bY3;

		this.doFrames(false, false, true, true);
	}

	public void startGrids(int gridID, int gridType, int pos, int type) {

		this.myFrame2.jobItem.gridType = gridID;

		System.gc();

		if (findDLO == null) {
			findDLO = new FindBiggestDLO(myFrame2);
		} else {
			findDLO.setGridInfo();
		}

		if (pos == 1) {
			findDLO.getAllDLOsIn();
		} else if (pos == 2) {
			findDLO.getAllDLOsMid(type);
		} else if (pos == 3) {
			findDLO.getAllDLOsOut();
		}

		myFrame2.gridsPanel.l2.setText("");
		this.resetGrids();
		System.gc();
	}

	public void resetGrids() {

		if (myFrame2.selectedDim == 9) {

			this.reDrawTextsforRowColOp(
					myFrame2.jobItem.myCanvas.selectedRadioForRow,
					myFrame2.jobItem.myCanvas.selectedRadioForCol,
					myFrame2.jobItem.myCanvas.selectedRadioForRowo,
					myFrame2.jobItem.myCanvas.selectedRadioForColo, false,
					myFrame2.selectedDim);
		} else {

		}
	}

	/**
	 * Setting SUType Configuration values
	 */
	public void searchOpeningAnsSetSUType() {

		try {

			// Get all facets
			Object[] facets = this.frames.toArray();

			// Clear facets collection
			this.frames.clear();

			for (Object f : facets) {

				Facet facet = (Facet) f;

				// Get all frames
				Object[] frms = facet.frames.toArray();

				// Clear frames collection
				facet.frames.clear();

				for (Object frm : frms) {

					Frame frame = (Frame) frm;

					if (frame.shapeID != 10) {

						// Get all openings
						Object[] ops = frame.openings.toArray();

						// Clear opening objects
						frame.openings.clear();

						for (Object op : ops) {

							OpeningObject opening = (OpeningObject) op;

							// if selected Position is IN
							if (myFrame2.glassPanel.whichPos == 1) {
								opening = doGlassForPosition1(opening, 0, 0);
							}

							// if selected Position is MID
							else if (myFrame2.glassPanel.whichPos == 2) {
								opening = doGlassForPosition2(opening, 0, 0);
							}

							// if selected Position is OUT
							else if (myFrame2.glassPanel.whichPos == 3) {
								opening = doGlassForPosition3(opening, 0, 0);
							}

							frame.openings.add(opening);

						}
					}

					facet.frames.add(frame);
				}

				frames.add(facet);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			JOptionPane
					.showMessageDialog(
							null,
							e.getMessage()
									+ " Exception Occured at ShapeObject.searchOpeningAndSetSU",
							"GLASS ERROR!", JOptionPane.ERROR_MESSAGE);
		}

		this.myFrame2.options.buildOptionsTables();
	}

	/**
	 * Setting SUType configuration values
	 * 
	 * @param selectedOpening
	 *            , OpeningObject
	 * @param xpos
	 *            , Axis X Position
	 * @param ypos
	 *            , Axis Y Position
	 */
	public void searchOpeningAndSetSUType(OpeningObject selectedOpening,
			int xpos, int ypos) {

		try {

			// Get all facets
			Object[] facets = this.frames.toArray();

			// Clear facets collection
			this.frames.clear();

			for (Object f : facets) {

				Facet facet = (Facet) f;

				// Get all frames
				Object[] frms = facet.frames.toArray();

				// Clear frames collection
				facet.frames.clear();

				for (Object frm : frms) {

					Frame frame = (Frame) frm;

					if (frame.shapeID != 10) {

						// Get all openings
						Object[] ops = frame.openings.toArray();

						// Clear opening objects
						frame.openings.clear();

						for (Object op : ops) {

							OpeningObject opening = (OpeningObject) op;

							if (opening.isForShape(selectedOpening)) {

								// if selected Position is IN
								if (myFrame2.glassPanel.whichPos == 1) {
									opening = doGlassForPosition1(opening,
											xpos, ypos);
								}

								// if selected Position is MID
								else if (myFrame2.glassPanel.whichPos == 2) {
									opening = doGlassForPosition2(opening,
											xpos, ypos);
								}

								// if selected Position is OUT
								else if (myFrame2.glassPanel.whichPos == 3) {
									opening = doGlassForPosition3(opening,
											xpos, ypos);
								}

							}

							frame.openings.add(opening);

						}
					}

					facet.frames.add(frame);
				}

				frames.add(facet);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			JOptionPane
					.showMessageDialog(
							null,
							e.getMessage()
									+ " Exception Occured at ShapeObject.searchOpeningAndSetSU",
							"GLASS ERROR!", JOptionPane.ERROR_MESSAGE);
		}

		this.myFrame2.options.buildOptionsTables();
	}

	public OpeningObject doGlassForPosition1(OpeningObject opening, int xpos,
			int ypos) throws Exception {
		/*
		 * Evaluate if the design is open and edit is false for searching SUType
		 * from GlassSU is alredy config
		 */
		SUType suType = this.myFrame2.mySelectedSUIn;

		// Create a Point selected
		Point p = new Point(xpos, ypos);

		// If Content is Sash
		if (opening.contentIn == OpeningContentTypes.SASH.getValue()) {

			// Get All Sash Leafs for SashIN
			Object[] leafs = opening.sashObjectMid.frames.toArray();

			// For each Sash Leaf
			for (Object s : leafs) {

				// Get all Openings
				Object[] lopenings = ((SashLeaf) s).openings.toArray();
				((SashLeaf) s).openings.clear();

				for (Object lopening : lopenings) {

					OpeningObject o = (OpeningObject) lopening;

					// If Content of MID (only available for sash)
					if (o.contentMid == OpeningContentTypes.SASH.getValue()) {

						// Get All Leafs
						Object[] leafss = o.sashObjectMid.frames.toArray();

						for (Object ss : leafss) {

							// Get all Openings
							Object[] llopenings = ((SashLeaf) ss).openings
									.toArray();
							((SashLeaf) ss).openings.clear();

							for (Object llopening : llopenings) {

								OpeningObject op = (OpeningObject) llopening;

								if (this.myFrame2.glassPanel.oneGlass
										.isSelected()) {
									if (op.gp.contains(p) || xpos <= op.bX2
											&& xpos <= op.bX3 && xpos >= op.bX4
											&& ypos >= op.bY4 - op.heightPix
											&& ypos <= op.bY3 && ypos <= op.bY4) {
										op = setMidGlass(suType, op);
									}
								}

								if (this.myFrame2.glassPanel.allGlass
										.isSelected()) {
									op = setMidGlass(suType, op);
								}
								((SashLeaf) ss).openings.add(op);
							}
						}

					} else if (o.contentIn == OpeningContentTypes.GLASS
							.getValue()) {

						if (this.myFrame2.glassPanel.oneGlass.isSelected()) {
							if (o.gp.contains(p) || xpos <= o.bX2
									&& xpos <= o.bX3 && xpos >= o.bX4
									&& ypos >= o.bY4 - o.heightPix
									&& ypos <= o.bY3 && ypos <= o.bY4) {
								o = setMidGlass(suType, o);
							}
						}

						if (this.myFrame2.glassPanel.allGlass.isSelected()) {
							o = setMidGlass(suType, o);
						}
					}

					((SashLeaf) s).openings.add(o);
				}
			}
		} else if (opening.contentIn == OpeningContentTypes.GLASS.getValue()) {

			if (this.myFrame2.glassPanel.oneGlass.isSelected()) {
				if (opening.gp.contains(p) || xpos <= opening.bX2
						&& xpos <= opening.bX3 && xpos >= opening.bX4
						&& ypos >= opening.bY4 - opening.heightPix
						&& ypos <= opening.bY3 && ypos <= opening.bY4) {
					opening = setMidGlass(suType, opening);
				}
			}

			if (this.myFrame2.glassPanel.allGlass.isSelected()) {
				opening = setMidGlass(suType, opening);
			}

		} else if (opening.contentIn == OpeningContentTypes.SUBFRAME.getValue()) {
			searchOpeningAndSetSUType(opening, xpos, ypos);
		}

		return opening;
	}

	/**
	 * Do Glass for Position 2
	 * 
	 * @param opening
	 *            , Opening Object
	 * @param xpos
	 *            , Axis X Position selected
	 * @param ypos
	 *            , Axis Y Position selected
	 * @return OpeningObject
	 * @throws Exception
	 *             , Exception
	 */
	public OpeningObject doGlassForPosition2(OpeningObject opening, int xpos,
			int ypos) throws Exception {

		// Sealed Unit Type selected
		SUType suType = myFrame2.mySelectedSUMid;

		// Create a Point selected
		Point p = new Point(xpos, ypos);

		// If Content is Sash
		if (opening.contentMid == OpeningContentTypes.SASH.getValue()) {

			Object[] ops = opening.sashObjectMid.openings.toArray();
			opening.sashObjectMid.openings.clear();

			for (Object o : ops) {

				OpeningObject op = (OpeningObject) o;

				if (op.contentMid == 1) {

					if (this.myFrame2.glassPanel.oneGlass.isSelected()) {
						if (op.gp.contains(p) || xpos <= op.bX2
								&& xpos <= op.bX3 && xpos >= op.bX4
								&& ypos >= op.bY4 - op.heightPix
								&& ypos <= op.bY3 && ypos <= op.bY4) {
							op = setMidGlass(suType, op);
						}
					}

					if (this.myFrame2.glassPanel.allGlass.isSelected()) {
						op = setMidGlass(suType, op);
					}
				}

				opening.sashObjectMid.openings.add(op);
			}

			// Get All Sash Leafs for SashIN
			Object[] leafs = opening.sashObjectMid.frames.toArray();

			// For each Sash Leaf
			for (Object s : leafs) {

				// Get all Openings
				Object[] lopenings = ((SashLeaf) s).openings.toArray();
				((SashLeaf) s).openings.clear();

				for (Object lopening : lopenings) {

					OpeningObject o = (OpeningObject) lopening;

					// If Content of MID (only available for sash)
					if (o.contentMid == OpeningContentTypes.SASH.getValue()) {

						// Get All Leafs
						Object[] leafss = o.sashObjectMid.frames.toArray();

						for (Object ss : leafss) {

							// Get all Openings
							Object[] llopenings = ((SashLeaf) ss).openings
									.toArray();

							((SashLeaf) ss).openings.clear();

							for (Object llopening : llopenings) {

								OpeningObject op = (OpeningObject) llopening;

								if (this.myFrame2.glassPanel.oneGlass
										.isSelected()) {
									if (op.gp.contains(p) || xpos <= op.bX2
											&& xpos <= op.bX3 && xpos >= op.bX4
											&& ypos >= op.bY4 - op.heightPix
											&& ypos <= op.bY3 && ypos <= op.bY4) {
										op = setMidGlass(suType, op);
									}
								}

								if (this.myFrame2.glassPanel.allGlass
										.isSelected()) {
									op = setMidGlass(suType, op);
								}

								((SashLeaf) ss).openings.add(op);
							}
						}

					} else if (((OpeningObject) lopening).contentMid == OpeningContentTypes.GLASS
							.getValue()) {

						if (this.myFrame2.glassPanel.oneGlass.isSelected()) {
							if (o.gp.contains(p) || xpos <= o.bX2
									&& xpos <= o.bX3 && xpos >= o.bX4
									&& ypos >= o.bY4 - o.heightPix
									&& ypos <= o.bY3 && ypos <= o.bY4) {
								o = setMidGlass(suType, o);
							}
						}

						if (this.myFrame2.glassPanel.allGlass.isSelected()) {
							o = setMidGlass(suType, o);
						}
					}

					((SashLeaf) s).openings.add(o);
				}
			}

		} else if (opening.contentMid == OpeningContentTypes.GLASS.getValue()) {

			if (this.myFrame2.glassPanel.oneGlass.isSelected()) {
				if (opening.gp.contains(p) || xpos <= opening.bX2
						&& xpos <= opening.bX3 && xpos >= opening.bX4
						&& ypos >= opening.bY4 - opening.heightPix
						&& ypos <= opening.bY3 && ypos <= opening.bY4) {
					opening = setMidGlass(suType, opening);
				}
			}

			if (this.myFrame2.glassPanel.allGlass.isSelected()) {
				opening = setMidGlass(suType, opening);
			}

		} else if (opening.contentMid == OpeningContentTypes.SUBFRAME
				.getValue()) {
			searchOpeningAndSetSUType(opening, xpos, ypos);
		}

		return opening;
	}

	public OpeningObject doGlassForPosition3(OpeningObject opening, int xpos,
			int ypos) throws Exception {

		// Get Selected Sealed Unit
		SUType suType = this.myFrame2.mySelectedSUOut;

		// Create a Point selected
		Point p = new Point(xpos, ypos);

		// If Content is Sash
		if (opening.contentOut == OpeningContentTypes.SASH.getValue()) {

			// Get All Sash Leafs for SashIN
			Object[] leafs = opening.sashObjectOut.frames.toArray();

			// For each Sash Leaf
			for (Object s : leafs) {

				// Get all Openings
				Object[] lopenings = ((SashLeaf) s).openings.toArray();
				((SashLeaf) s).openings.clear();

				for (Object lopening : lopenings) {

					OpeningObject o = (OpeningObject) lopening;

					// If Content of MID (only available for sash)
					if (o.contentOut == OpeningContentTypes.SASH.getValue()) {

						// Get All Leafs
						Object[] leafss = o.sashObjectOut.frames.toArray();

						for (Object ss : leafss) {

							// Get all Openings
							Object[] llopenings = ((SashLeaf) ss).openings
									.toArray();
							((SashLeaf) ss).openings.clear();

							for (Object llopening : llopenings) {

								OpeningObject op = (OpeningObject) llopening;

								if (this.myFrame2.glassPanel.oneGlass
										.isSelected()) {
									if (op.gp.contains(p) || xpos <= op.bX2
											&& xpos <= op.bX3 && xpos >= op.bX4
											&& ypos >= op.bY4 - op.heightPix
											&& ypos <= op.bY3 && ypos <= op.bY4) {
										op = setMidGlass(suType, op);
									}
								}

								if (this.myFrame2.glassPanel.allGlass
										.isSelected()) {
									op = setMidGlass(suType, op);
								}

								((SashLeaf) ss).openings.add(op);
							}
						}

					} else if (o.contentOut == OpeningContentTypes.GLASS
							.getValue()) {
						if (this.myFrame2.glassPanel.oneGlass.isSelected()) {
							if (o.gp.contains(p) || xpos <= o.bX2
									&& xpos <= o.bX3 && xpos >= o.bX4
									&& ypos >= o.bY4 - o.heightPix
									&& ypos <= o.bY3 && ypos <= o.bY4) {
								o = setMidGlass(suType, o);
							}
						}

						if (this.myFrame2.glassPanel.allGlass.isSelected()) {
							o = setMidGlass(suType, o);
						}
					}

					((SashLeaf) s).openings.add(o);
				}
			}

		} else if (opening.contentOut == OpeningContentTypes.GLASS.getValue()) {
			if (this.myFrame2.glassPanel.oneGlass.isSelected()) {
				if (opening.gp.contains(p) || xpos <= opening.bX2
						&& xpos <= opening.bX3 && xpos >= opening.bX4
						&& ypos >= opening.bY4 - opening.heightPix
						&& ypos <= opening.bY3 && ypos <= opening.bY4) {
					opening = setMidGlass(suType, opening);
				}
			}

			if (this.myFrame2.glassPanel.allGlass.isSelected()) {
				opening = setMidGlass(suType, opening);
			}

		} else if (opening.contentOut == OpeningContentTypes.SUBFRAME
				.getValue()) {
			searchOpeningAndSetSUType(opening, xpos, ypos);

		}

		return opening;

	}

	public OpeningObject setInGlass(SUType suType, OpeningObject lopening)
			throws Exception {

		CreateGlass createGlass = new CreateGlass(opening, myFrame2);
		lopening.myGlassIn = createGlass.doGlass(suType);
		createGlass = null;
		return lopening;
	}

	public OpeningObject setMidGlass(SUType suType, OpeningObject llopening)
			throws Exception {

		CreateGlass createGlass = new CreateGlass(llopening, myFrame2);
		llopening.myGlassMid = createGlass.doGlass(suType);
		createGlass = null;
		return llopening;
	}

	public OpeningObject setOutGlass(SUType suType, OpeningObject opening)
			throws Exception {

		CreateGlass createGlass = new CreateGlass(opening, myFrame2);
		opening.myGlassMid = createGlass.doGlass(suType);
		createGlass = null;
		return opening;
	}

	public void setNumSides(int shape) {

		SetSides setSides = new SetSides(shapeID);

		noSides = setSides.noSides;
		noSidesTop = setSides.noSidesTop;
		noSidesBot = setSides.noSidesBot;
		noSidesLeft = setSides.noSidesLeft;
		noSidesRight = setSides.noSidesRight;
		setSides = null;
	}

	public Facet modifyFacetParts(final Facet F) {

		Object[] parts = F.partObjects.toArray();

		boolean lChanged = false;
		boolean rChanged = false;

		F.partObjects.clear();
		for (final Object P : parts) {
			if (((Profiles) P).profileSelected == 1) {

				if (((Profiles) P).partID != myFrame2.partID
						&& myFrame2.editor.part.isSelected()) {
					((Profiles) P).partID = myFrame2.partID;
					((Profiles) P).partIDByUser = true;

					((Profiles) P).partDimB = myFrame2.partDimB
							/ myFrame2.scale.doubleValue();
					((Profiles) P).partDimM = myFrame2.partDimM
							/ myFrame2.scale.doubleValue();
					((Profiles) P).partDimA = myFrame2.partDimA
							/ myFrame2.scale.doubleValue();
					((Profiles) P).partDimC = myFrame2.partDimC
							/ myFrame2.scale.doubleValue();
				}
				if (myFrame2.editor.endTypeLT.isSelected()

				&& ((Profiles) P).position <= 4
						&& ((Profiles) P).endTypeRB != myFrame2.endRB) {
					((Profiles) P).endTypeRB = myFrame2.endRB;
					if (!((Profiles) P).leftIn) {
						rChanged = true;
					} else {
						rChanged = false;
					}
				}
				if (myFrame2.editor.endTypeRB.isSelected()

				&& ((Profiles) P).position <= 4
						&& ((Profiles) P).endTypeLT != myFrame2.endLT) {
					((Profiles) P).endTypeLT = myFrame2.endLT;
					if (!((Profiles) P).rightIn) {
						lChanged = true;
					} else {
						lChanged = false;
					}
				}
				if (myFrame2.editor.endTypeLT.isSelected()
						&& myFrame2.endLT > 0 && ((Profiles) P).position <= 8
						&& ((Profiles) P).position > 4) {
					((Profiles) P).endTypeLT = myFrame2.endLT;
					if (!((Profiles) P).leftIn) {
						lChanged = true;
					} else {
						lChanged = false;
					}
				}
				if (myFrame2.editor.endTypeRB.isSelected()
						&& myFrame2.endRB > 0 && ((Profiles) P).position <= 8
						&& ((Profiles) P).position > 4) {
					((Profiles) P).endTypeRB = myFrame2.endRB;
					if (!((Profiles) P).rightIn) {
						rChanged = true;
					} else {
						rChanged = false;
					}
				}
				if (((Profiles) P).position <= 3) {//
					// this.changeVerifyEndTypesTop(P, rChanged, lChanged);
					this.changeVerifyEndTypesTopP(P, rChanged, lChanged);

				} else if (((Profiles) P).position > 4
						&& ((Profiles) P).position <= 7) {
					// this.changeVerifyEndTypesBot(P, rChanged, lChanged);
					this.changeVerifyEndTypesBotP(P, rChanged, lChanged);

				} else if (((Profiles) P).position == 4) {
					// this.changeVerifyEndTypesRight(P);
					this.changeVerifyEndTypesRightP(P);

				} else if (((Profiles) P).position == 8) {
					// this.changeVerifyEndTypesLeft(P);
					this.changeVerifyEndTypesLeftP(P);

				}

			}

			F.partObjects.add(P);

		}

		return F;
	}

	public void modifyParts() throws Exception {

		final Object[] parts = partObjects.toArray();

		boolean lChanged = false;
		boolean rChanged = false;

		partObjects.clear();

		for (Object P : parts) {
			if (((Profiles) P).profileSelected == 1) {
				/**
				 * If changed partID: Rest partID and Dims from Selection in
				 * Editor
				 */
				if (((Profiles) P).partID != myFrame2.partID
						&& myFrame2.editor.part.isSelected()) {

					((Profiles) P).partID = myFrame2.partID;
					((Profiles) P).partIDByUser = true;

					P = ((Profiles) P).setProfileDimsMIScale((Profiles) P);

					((Profiles) P).partDimByUser = true;

					modifyProfilePart123Dims(this, P);

				}
				if (myFrame2.editor.endTypeLT.isSelected()
						&& ((Profiles) P).position <= 4
						&& ((Profiles) P).endTypeRB != myFrame2.endRB) {
					((Profiles) P).endTypeRB = myFrame2.endRB;
					((Profiles) P).endTypeRBByUser = true;

					if (((Profiles) P).position == 1) {
						top1Part.endTypeRBByUser = true;
					}
					if (((Profiles) P).position == 2) {
						top2Part.endTypeRBByUser = true;
					}
					if (((Profiles) P).position == 3) {
						top3Part.endTypeRBByUser = true;
					}
					if (((Profiles) P).position == 4) {
						rightPart.endTypeRBByUser = true;
					}

					if (!((Profiles) P).leftIn) {
						rChanged = true;
					} else {
						rChanged = false;
					}
				}
				if (myFrame2.editor.endTypeRB.isSelected()

				&& ((Profiles) P).position <= 4
						&& ((Profiles) P).endTypeLT != myFrame2.endLT) {
					((Profiles) P).endTypeLT = myFrame2.endLT;
					((Profiles) P).endTypeLTByUser = true;

					if (((Profiles) P).position == 1) {
						top1Part.endTypeLTByUser = true;
					}
					if (((Profiles) P).position == 2) {
						top2Part.endTypeLTByUser = true;
					}
					if (((Profiles) P).position == 3) {
						top3Part.endTypeLTByUser = true;
					}
					if (((Profiles) P).position == 4) {
						rightPart.endTypeLTByUser = true;
					}

					if (!((Profiles) P).rightIn) {
						lChanged = true;
					} else {
						lChanged = false;
					}
				}
				if (myFrame2.editor.endTypeLT.isSelected()
						&& myFrame2.endLT > 0 && ((Profiles) P).position <= 8
						&& ((Profiles) P).position > 4) {
					((Profiles) P).endTypeLT = myFrame2.endLT;
					((Profiles) P).endTypeLTByUser = true;

					if (((Profiles) P).position == 5) {
						bot1Part.endTypeLTByUser = true;
					}
					if (((Profiles) P).position == 6) {
						bot2Part.endTypeLTByUser = true;
					}
					if (((Profiles) P).position == 7) {
						bot3Part.endTypeLTByUser = true;
					}
					if (((Profiles) P).position == 8) {
						leftPart.endTypeLTByUser = true;
					}

					if (!((Profiles) P).leftIn) {
						lChanged = true;
					} else {
						lChanged = false;
					}
				}
				if (myFrame2.editor.endTypeRB.isSelected()
						&& myFrame2.endRB > 0 && ((Profiles) P).position <= 8
						&& ((Profiles) P).position > 4) {
					((Profiles) P).endTypeRB = myFrame2.endRB;
					((Profiles) P).endTypeRBByUser = true;

					if (((Profiles) P).position == 5) {
						bot1Part.endTypeRBByUser = true;
					}
					if (((Profiles) P).position == 6) {
						bot2Part.endTypeRBByUser = true;
					}
					if (((Profiles) P).position == 7) {
						bot3Part.endTypeRBByUser = true;
					}
					if (((Profiles) P).position == 8) {
						leftPart.endTypeRBByUser = true;
					}

					if (!((Profiles) P).rightIn) {
						rChanged = true;
					} else {
						rChanged = false;
					}
				}
				if (((Profiles) P).position <= 3) {
					// this.changeVerifyEndTypesTop(P, rChanged, lChanged);
					this.changeVerifyEndTypesTopP(P, rChanged, lChanged);

				} else if (((Profiles) P).position > 4
						&& ((Profiles) P).position <= 7) {
					// this.changeVerifyEndTypesBot(P, rChanged, lChanged);
					this.changeVerifyEndTypesBotP(P, rChanged, lChanged);

				} else if (((Profiles) P).position == 4) {
					// this.changeVerifyEndTypesRight(P);
					this.changeVerifyEndTypesRightP(P);

				} else if (((Profiles) P).position == 8) {
					// this.changeVerifyEndTypesLeft(P);
					this.changeVerifyEndTypesLeftP(P);

				}

			}

			// F.partObjects.add(P);

		}

		if (a_levelID != 12) {
			new SetLeanTo(this);

			CreateShapeMethods createShape = new CreateShapeMethods(
					this.myParentO, 2, myFrame2);

			createShape.makeSidesStraight(this);

			createShape.doParts(this, true);

			createShape.setBaseInfo(this, 1, true);

			top1 = (Top1Object) top1.cloneProfile(top1Part);
			top2 = (Top2Object) top2.cloneProfile(top2Part);
			top3 = (Top3Object) top3.cloneProfile(top3Part);

			bot1 = (Bot1Object) bot1.cloneProfile(bot1Part);
			bot2 = (Bot2Object) bot2.cloneProfile(bot2Part);
			bot3 = (Bot3Object) bot3.cloneProfile(bot3Part);

			left = (LeftObject) left.cloneProfile(leftPart);
			right = (RightObject) right.cloneProfile(rightPart);

			bOpeningObject = doMainOpening();

			bOpeningObject.unGlazed = true;

			/*
			 * if Undo no need to change anything
			 * 
			 * if add sash no need to change X position just recalc Y Only
			 * needed if adding new Mullion.
			 */

			if (myFrame2.getActionTypeEvent() == 1
					|| myFrame2.getActionTypeEvent() == 0) {

				bOpeningObject = bOpeningObject
						.modifyVMCEqualize(bOpeningObject);

				bOpeningObject = bOpeningObject
						.modifyHMCEqualize(bOpeningObject);
			} else if (myFrame2.isUndo || myFrame2.getActionTypeEvent() == 2
					|| myFrame2.getActionTypeEvent() == 3
					|| myFrame2.getActionTypeEvent() >= 6) {
				bOpeningObject = modifyVMHeight(bOpeningObject);
				bOpeningObject = bOpeningObject.modifyHMWidth(bOpeningObject);

			}

			if (bOpeningObject.mullions.size() > 0
					|| bOpeningObject.mullionsH.size() > 0) {
				doOpenings();
			}
			// // Check

			bOpeningObject = doMullions(bOpeningObject);

			// Do Extensions????

			partObjects = createShape.setPartObjectsAndCollection(this);

			bom.clear();
			clearBomForShape();
			executePartRules(true, true, "shapeObject.modifyParts.10815");

			partObjects = createShape.doGPParts(partObjects, this, glazedOut);

			myFrame2.facetUsed.reDraw(false, true, null, false, false, false);

		} else {
			CreateOpenings createOpening = new CreateOpenings(
					((SashLeaf) this).myParentO.myParent, myFrame2);
			CreateSash createSash;

			if (((SashLeaf) this).myParentO.contentIn == 2) {

				final Collection mySashLeafs = ((SashLeaf) this).myParentO.sashObjectIn.frames;

				createSash = createOpening.doSashInOpening(
						((SashLeaf) this).myParentO, mySashLeafs);

				((SashLeaf) this).myParentO = createSash.doNewSash(
						((SashLeaf) this).myParentO.sashObjectIn, true,
						mySashLeafs);

			}
			if (((SashLeaf) this).myParentO.contentMid == 2) {

				final Collection mySashLeafs = ((SashLeaf) this).myParentO.sashObjectMid.frames;

				createSash = createOpening.doSashInOpening(
						((SashLeaf) this).myParentO, mySashLeafs);
				((SashLeaf) this).myParentO = createSash.doNewSash(
						((SashLeaf) this).myParentO.sashObjectMid, true,
						mySashLeafs);

			}
			if (((SashLeaf) this).myParentO.contentOut == 2) {

				final Collection mySashLeafs = ((SashLeaf) this).myParentO.sashObjectOut.frames;

				createSash = createOpening.doSashInOpening(
						((SashLeaf) this).myParentO, mySashLeafs);
				((SashLeaf) this).myParentO = createSash.doNewSash(
						((SashLeaf) this).myParentO.sashObjectOut, true,
						mySashLeafs);

			}

			createOpening = null;
			createSash = null;
			myFrame2.facetUsed.reDraw(false, true, null, false, false, false);
			System.gc();
		}

	}

	public void modifyProfilePart123Dims(final ShapeObject F, final Object P) {

		if (((Profiles) P).position == 1) {

			F.top1Part.endTypeRBByUser = true;
			F.top1Part.partID = myFrame2.partID;
			F.top1Part.partIDByUser = true;

			F.top1Part = F.top1Part.setProfileDimsMIScale(F.top1Part);

			F.top1Part.partDimByUser = true;

		}
		if (((Profiles) P).position == 2) {

			F.top2Part.endTypeRBByUser = true;
			F.top2Part.partID = myFrame2.partID;
			F.top2Part.partIDByUser = true;

			F.top2Part = F.top2Part.setProfileDimsMIScale(F.top2Part);

			F.top2Part.partDimByUser = true;

		}
		if (((Profiles) P).position == 3) {
			F.top3Part.endTypeRBByUser = true;
			F.top3Part.partID = myFrame2.partID;
			F.top3Part.partIDByUser = true;

			F.top3Part = F.top3Part.setProfileDimsMIScale(F.top3Part);

			F.top3Part.partDimByUser = true;
		}
		if (((Profiles) P).position == 4) {

			F.rightPart.endTypeRBByUser = true;
			F.rightPart.partID = myFrame2.partID;
			F.rightPart.partIDByUser = true;

			F.rightPart = F.rightPart.setProfileDimsMIScale(F.rightPart);

			F.rightPart.partDimByUser = true;
		}
		if (((Profiles) P).position == 5) {

			F.bot1Part.endTypeRBByUser = true;
			F.bot1Part.partID = myFrame2.partID;
			F.bot1Part.partIDByUser = true;

			F.bot1Part = F.bot1Part.setProfileDimsMIScale(F.bot1Part);

			F.bot1Part.partDimByUser = true;
		}
		if (((Profiles) P).position == 6) {

			F.bot2Part.endTypeRBByUser = true;
			F.bot2Part.partID = myFrame2.partID;
			F.bot2Part.partIDByUser = true;
			F.bot2Part = F.bot2Part.setProfileDimsMIScale(F.bot2Part);

			F.bot2Part.partDimByUser = true;
		}
		if (((Profiles) P).position == 7) {

			F.bot3Part.endTypeRBByUser = true;
			F.bot3Part.partID = myFrame2.partID;
			F.bot3Part.partIDByUser = true;

			F.bot3Part = F.bot3Part.setProfileDimsMIScale(F.bot3Part);

			F.bot3Part.partDimByUser = true;
		}
		if (((Profiles) P).position == 8) {

			F.leftPart.endTypeRBByUser = true;
			F.leftPart.partID = myFrame2.partID;
			F.leftPart.partIDByUser = true;
			F.leftPart = F.leftPart.setProfileDimsMIScale(F.leftPart);

			F.leftPart.partDimByUser = true;
		}
	}

	public void startFrameParts() throws Exception {

		new SetLeanTo(this);

		this.createSideShapes(newPart, false, myFrame2.scale);

		centerPointX = top1.x1;
		centerPointX2 = top1.x2;
		centerPointY = top1.y1;
		centerPointY2 = top1.y2;
		radius1 = top1.radius1;
		radius2 = top1.radius2;

		this.resetParts();

		executeOptionRules("shapeObject.startframeparts.10960");
		executeClearanceRules();
		executePartRules(true, true, "shapeObject.startframeparts.10960");

		this.doMainOpening();

		if (glazedOut) {
			this.doGPParts(true);
		} else {
			this.doGPParts(false);
		}

	}

	public void setLeanTo(final int lean, final int lean2, final int lean3,
			final int lean4) {

		this.lean = lean;
		this.lean2 = lean2;
		this.lean3 = lean3;
		this.lean4 = lean4;
	}

	public void setMargins() {

		startingX = myFrame2.jobItem.startingX;
		startingY = myFrame2.jobItem.startingY;
	}

	public void setInitDimABCD(final double a1, final double a2,
			final double a3, final double a4, final double a5, final double a0,
			final double b1, final double b2, final double b3, final double b4,
			final double b5, final double b0, final double c1, final double c2,
			final double c3, final double c4, final double c5, final double c0,
			final double d1, final double d2, final double d3, final double d4,
			final double d5, final double d0) {

		dimA1 = a1;
		dimA2 = a2;
		dimA3 = a3;
		dimA4 = a4;
		dimA5 = a5;
		dimA0 = a0;
		dimB1 = b1;
		dimB2 = b2;
		dimB3 = b3;
		dimB4 = b4;
		dimB5 = b5;
		dimB0 = b0;
		dimC1 = c1;
		dimC2 = c2;
		dimC3 = c3;
		dimC4 = c4;
		dimC5 = c5;
		dimC0 = c0;
		dimD1 = d1;
		dimD2 = d2;
		dimD3 = d3;
		dimD4 = d4;
		dimD5 = d5;
		dimD0 = d0;

	}

	public void setShapeDims(final ShapeObject shape) {

		dimA1 = shape.dimA1;
		dimA2 = shape.dimA2;
		dimA3 = shape.dimA3;
		dimA4 = shape.dimA4;
		dimA5 = shape.dimA5;
		dimA0 = shape.dimA0;
		dimB1 = shape.dimB1;
		dimB2 = shape.dimB2;
		dimB3 = shape.dimB3;
		dimB4 = shape.dimB4;
		dimB5 = shape.dimB5;
		dimB0 = shape.dimB0;
		dimC1 = shape.dimC1;
		dimC2 = shape.dimC2;
		dimC3 = shape.dimC3;
		dimC4 = shape.dimC4;
		dimC5 = shape.dimC5;
		dimC0 = shape.dimC0;
		dimD1 = shape.dimD1;
		dimD2 = shape.dimD2;
		dimD3 = shape.dimD3;
		dimD4 = shape.dimD4;
		dimD5 = shape.dimD5;
		dimD0 = shape.dimD0;

		bOpeningObject.dimA1 = shape.dimA1;
		bOpeningObject.dimA2 = shape.dimA2;
		bOpeningObject.dimA3 = shape.dimA3;
		bOpeningObject.dimA4 = shape.dimA4;
		bOpeningObject.dimA5 = shape.dimA5;
		bOpeningObject.dimA0 = shape.dimA0;
		bOpeningObject.dimB1 = shape.dimB1;
		bOpeningObject.dimB2 = shape.dimB2;
		bOpeningObject.dimB3 = shape.dimB3;
		bOpeningObject.dimB4 = shape.dimB4;
		bOpeningObject.dimB5 = shape.dimB5;
		bOpeningObject.dimB0 = shape.dimB0;
		bOpeningObject.dimC1 = shape.dimC1;
		bOpeningObject.dimC2 = shape.dimC2;
		bOpeningObject.dimC3 = shape.dimC3;
		bOpeningObject.dimC4 = shape.dimC4;
		bOpeningObject.dimC5 = shape.dimC5;
		bOpeningObject.dimC0 = shape.dimC0;
		bOpeningObject.dimD1 = shape.dimD1;
		bOpeningObject.dimD2 = shape.dimD2;
		bOpeningObject.dimD3 = shape.dimD3;
		bOpeningObject.dimD4 = shape.dimD4;
		bOpeningObject.dimD5 = shape.dimD5;
		bOpeningObject.dimD0 = shape.dimD0;

	}

	public void setDimABCDFromShapeChange(double a1, double a2, double a3,
			double a4, double a5, double a0, double b1, double b2, double b3,
			double b4, double b5, double b0, double c1, double c2, double c3,
			double c4, double c5, double c0, double d1, double d2, double d3,
			double d4, double d5, double d0) {

		dimA1 = a1;
		dimA2 = a2;
		dimA3 = a3;
		dimA4 = a4;
		dimA5 = a5;
		dimA0 = a0;
		dimB1 = b1;
		dimB2 = b2;
		dimB3 = b3;
		dimB4 = b4;
		dimB5 = b5;
		dimB0 = b0;
		dimC1 = c1;
		dimC2 = c2;
		dimC3 = c3;
		dimC4 = c4;
		dimC5 = c5;
		dimC0 = c0;
		dimD1 = d1;
		dimD2 = d2;
		dimD3 = d3;
		dimD4 = d4;
		dimD5 = d5;
		dimD0 = d0;

		if (myFrame2.currentUOM == 1) {

		}

		if (bOpeningObject != null) {
			bOpeningObject.dimA1 = a1;
			bOpeningObject.dimA2 = a2;
			bOpeningObject.dimA3 = a3;
			bOpeningObject.dimA4 = a4;
			bOpeningObject.dimA5 = a5;
			bOpeningObject.dimA0 = a0;
			bOpeningObject.dimB1 = b1;
			bOpeningObject.dimB2 = b2;
			bOpeningObject.dimB3 = b3;
			bOpeningObject.dimB4 = b4;
			bOpeningObject.dimB5 = b5;
			bOpeningObject.dimB0 = b0;
			bOpeningObject.dimC1 = c1;
			bOpeningObject.dimC2 = c2;
			bOpeningObject.dimC3 = c3;
			bOpeningObject.dimC4 = c4;
			bOpeningObject.dimC5 = c5;
			bOpeningObject.dimC0 = c0;
			bOpeningObject.dimD1 = d1;
			bOpeningObject.dimD2 = d2;
			bOpeningObject.dimD3 = d3;
			bOpeningObject.dimD4 = d4;
			bOpeningObject.dimD5 = d5;
			bOpeningObject.dimD0 = d0;
		}
	}

	public void modifyVDividerPosEqualize() throws Exception {// Need to

		// test on
		// Row Col
		AddMullionV addMullion = new AddMullionV(bOpeningObject,
				myFrame2.jobItem, myFrame2, 1);

		final Object[] mVs = bOpeningObject.mullions.toArray();
		final Collection doneRows = new Vector();
		doneRows.add(0);
		int myCol = 1;
		double maxThickForRow = 0;
		double myThickness = 0;
		double totalThick = 0;
		for (final Object element : mVs) {
			addMullion.getProfileDims((Profiles) element);

			myThickness = addMullion.thickness;

			myCol = ((Profiles) element).rowCol;
			if (!doneRows.contains(myCol)) {
				for (final Object element2 : mVs) {
					if (((Profiles) element2).rowCol == myCol) {
						myCol = ((Profiles) element2).rowCol;
						doneRows.add(myCol);
						if (myThickness > maxThickForRow) {
							maxThickForRow = addMullion.thickness;
						}
					}
				}
				totalThick = totalThick + maxThickForRow;
			}
		}

		bOpeningObject.mullions.clear();

		// final double newW
		// =Double.parseDouble(myFrame2.myTopPanel.fW.getText())*myFrame2.scale
		// / (mVs.length+1);

		final double newW = (myFrame2.jobItem.design_flat_WIDTHpix - totalThick)
				/ (mVs.length + 1);

		// final double newW
		// =(myFrame2.jobItem.design_flat_WIDTHpix)
		// / (mVs.length+1);

		double newPos = 0;
		int count = 0;

		for (final Object vc : mVs) {
			double sumPrev = 0;
			for (final Object vc2 : mVs) {
				if (((Profiles) vc2).rowCol < ((Profiles) vc).rowCol) {
					sumPrev = sumPrev + ((Profiles) vc2).thickness;
				}
			}
			count++;

			Profiles newMullion = new Profiles();

			newMullion = newMullion.cloneProfile(((Profiles) vc),
					bOpeningObject);

			newMullion = addMullion.getProfileDims(newMullion);
			newPos = startingX + newW * count + sumPrev;

			newMullion.x1 = newPos;

			newMullion.x2 = newMullion.x1 + newMullion.thickness;

			newMullion.x4 = newPos;

			newMullion.x3 = newMullion.x4 + newMullion.thickness;

			newMullion.centerXs = newMullion.x1 + newMullion.thickness / 2;

			newMullion.centerXe = newMullion.x4 + newMullion.thickness / 2;

			newMullion.x1al = newMullion.x1a = newMullion.x1
					- newMullion.partDimA;

			newMullion.x2cl = newMullion.x2a = newMullion.x2
					+ newMullion.partDimC;

			newMullion.x4al = newMullion.x4a = newMullion.x4
					- newMullion.partDimA;

			newMullion.x3cl = newMullion.x3a = newMullion.x3
					+ newMullion.partDimC;

			// newMullion.x1 = newMullion.x1 + deltaX;
			//
			// newMullion.x2 = newMullion.x2 + deltaX;
			//
			// newMullion.x4 = newMullion.x4 + deltaX;
			//
			// newMullion.x3 = newMullion.x3 + deltaX;
			//
			// newMullion.centerXs = newMullion.centerXs + deltaX;
			//
			// newMullion.centerXe = newMullion.centerXe + deltaX;
			//
			// newMullion.x1al = newMullion.x1al + deltaX;
			//
			// newMullion.x2cl = newMullion.x2cl + deltaX;
			//
			// newMullion.x4al = newMullion.x4al + deltaX;
			//
			// newMullion.x3cl = newMullion.x3cl + deltaX;

			addMullion.verifyLimitLR(newMullion);

			addMullion.calcMullion = new CalculateMullionV(addMullion);

			addMullion.newStartingXCenter = newMullion.centerXs;

			addMullion.newStartingXRTc = newMullion.x2cl;

			addMullion.newStartingXRT = newMullion.x2;

			addMullion.newStartingXLB = newMullion.x1;

			addMullion.newStartingXLBa = newMullion.x1al;
			addMullion.vcEndY = Math.max(bY3, bY4);
			addMullion.calcMullion.calculateCoord(newMullion);

			bOpeningObject.mullions.add(newMullion);

		}

		openings.toArray();
		bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
		bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();

		addMullion.recalcHCCoords();
		addMullion.reOrderVNotches();
		partObjects.clear();
		this.resetParts();

		addMullion.splitParts(null, false, false);
		this.doOpenings();
		addMullion = null;
	}

	public void modifyHDividerPosEqualize() throws Exception {// Need to

		AddMullionH addMullionH = new AddMullionH(bOpeningObject,
				myFrame2.jobItem, myFrame2, 1);

		final Object[] mHs = bOpeningObject.mullionsH.toArray();
		final Collection doneRows = new Vector();
		doneRows.add(0);
		int myCol = 1;
		double maxThickForRow = 0;
		double myThickness = 0;
		double totalThick = 0;
		for (final Object element : mHs) {
			addMullionH.getProfileDims((Profiles) element);

			myThickness = addMullionH.thickness;

			myCol = ((Profiles) element).rowCol;
			if (!doneRows.contains(myCol)) {
				for (final Object element2 : mHs) {
					if (((Profiles) element2).rowCol == myCol) {
						myCol = ((Profiles) element2).rowCol;
						doneRows.add(myCol);
						if (myThickness > maxThickForRow) {
							maxThickForRow = addMullionH.thickness;
						}
					}
				}
				totalThick = totalThick + maxThickForRow;
			}
		}

		bOpeningObject.mullionsH.clear();

		final double newH = (myFrame2.jobItem.design_flat_HEIGHTpix - totalThick)
				/ (mHs.length + 1);

		double newPos = 0;
		int count = 0;

		for (final Object vc : mHs) {
			double sumPrev = 0;
			for (final Object vc2 : mHs) {
				if (((Profiles) vc2).rowCol < ((Profiles) vc).rowCol) {
					sumPrev = sumPrev + ((Profiles) vc2).thickness;
				}
			}
			count++;

			Profiles newMullion = new Profiles();

			newMullion = newMullion.cloneProfile(((Profiles) vc),
					bOpeningObject);

			newMullion = addMullionH.getProfileDims(newMullion);

			newPos = highestY + newH * count + sumPrev;

			newMullion.y2 = newPos;

			newMullion.y1 = newMullion.y2 + newMullion.thickness;

			newMullion.y3 = newPos;

			newMullion.y4 = newMullion.y3 + newMullion.thickness;

			newMullion.centerYs = newMullion.y2 + newMullion.thickness / 2;

			newMullion.centerYe = newMullion.y3 + newMullion.thickness / 2;

			newMullion.y2cl = newMullion.y2a = newMullion.y2
					- newMullion.partDimC;

			newMullion.y1al = newMullion.y1a = newMullion.y1
					+ newMullion.partDimA;

			newMullion.x4al = newMullion.x4a = newMullion.y1
					+ newMullion.partDimA;

			newMullion.y3cl = newMullion.y3a = newMullion.y3
					- newMullion.partDimC;

			addMullionH.verifyLimitLR(newMullion);

			addMullionH.calcMullion = new CalculateMullionHii(addMullionH);

			addMullionH.newStartingYCenter = newMullion.centerYs;

			addMullionH.newStartingYRTc = newMullion.x2cl;

			addMullionH.newStartingYRT = newMullion.x2;

			addMullionH.newStartingYLB = newMullion.x1;

			addMullionH.newStartingYLBa = newMullion.x1al;

			addMullionH.hcEndX = Math.max(bX2, bX3);

			addMullionH.calcMullion.calculateCoord(newMullion);

			bOpeningObject.mullionsH.add(newMullion);

		}

		openings.toArray();
		bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
		bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();

		addMullionH.recalcVCCoords();
		addMullionH.reOrderHMNotches();

		partObjects.clear();
		this.resetParts();

		// addMullion.splitParts(null, false, false);
		this.doOpenings();
		addMullionH = null;
	}

	public void modifyVDividerPosChangeW() throws Exception {// Need to

		AddMullionV addMullion = new AddMullionV(bOpeningObject,
				myFrame2.jobItem, myFrame2, 1);

		final Object[] mVs = bOpeningObject.mullions.toArray();

		frames.toArray();

		bOpeningObject.mullions.clear();

		int count = 0;

		Object[] texts = myFrame2.fcolTextObjects.toArray();

		if (texts.length == 0) {
			myFrame2.fcolTextObjects.add(myFrame2.jobItem._WIDTHpix
					/ myFrame2.scale.doubleValue() + "");
			texts = myFrame2.fcolTextObjects.toArray();
		}
		count = 0;
		new ArrayList();
		double newSX = startingX;
		for (final Object t : texts) {
			for (final Object vc : mVs) {

				if (((Profiles) vc).rowCol == count + 1) {

					Profiles newMullion = new Profiles();
					newMullion = newMullion.cloneProfile(((Profiles) vc),
							bOpeningObject);
					newMullion = addMullion.getProfileDims(newMullion);

					BigDecimal myScale = new BigDecimal(0);
					if (myFrame2.myTopPanel.metric.isSelected()) {
						myScale = myFrame2.scale.multiply(new BigDecimal(100));
					} else {
						myScale = myFrame2.scale;
					}
					newMullion.x1 = newSX + Double.parseDouble(t.toString())
							* myScale.doubleValue();
					newMullion.x4 = newSX + Double.parseDouble(t.toString())
							* myScale.doubleValue();
					newMullion.x2 = newMullion.x1 + newMullion.thickness;
					newMullion.x3 = newMullion.x4 + newMullion.thickness;
					newMullion.centerXs = newMullion.x1 + newMullion.thickness
							/ 2;
					newMullion.centerXe = newMullion.x4 + newMullion.thickness
							/ 2;

					newMullion.x1al = newMullion.x1a = newMullion.x1
							- newMullion.partDimA;
					newMullion.x2cl = newMullion.x2a = newMullion.x2
							+ newMullion.partDimC;
					newMullion.x4al = newMullion.x4a = newMullion.x4
							- newMullion.partDimA;
					newMullion.x3cl = newMullion.x3a = newMullion.x3
							+ newMullion.partDimC;

					newSX = newMullion.x2;

					addMullion.verifyLimitLR(newMullion);

					addMullion.calcMullion = new CalculateMullionV(addMullion);

					addMullion.newStartingXCenter = newMullion.centerXs;

					addMullion.newStartingXRTc = newMullion.x2cl;

					addMullion.newStartingXRT = newMullion.x2;

					addMullion.newStartingXLB = newMullion.x1;

					addMullion.newStartingXLBa = newMullion.x1al;
					addMullion.vcEndY = Math.max(bY3, bY4);
					addMullion.calcMullion.calculateCoord(newMullion);

					addMullion.resetRecalcMullionBom(newMullion);

					bOpeningObject.mullions.add(newMullion);
					break;

				}

			}
			count++;
		}

		bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
		bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();

		addMullion.recalcHCCoords();
		addMullion.reOrderVNotches();
		partObjects.clear();
		this.resetParts();

		addMullion.splitParts(null, false, false);
		this.doOpenings();
		addMullion = null;

	}

	public void modifyHDividerPosChangeH() throws Exception {// Need to

		AddMullionH addMullionH = new AddMullionH(bOpeningObject,
				myFrame2.jobItem, myFrame2, 1);

		// if (!this.modifyDims) {

		final Object[] mHs = bOpeningObject.mullionsH.toArray();

		frames.toArray();

		bOpeningObject.mullionsH.clear();

		int count = 0;

		Object[] texts = myFrame2.frowTextObjects.toArray();

		if (texts.length == 0) {
			myFrame2.frowTextObjects.add(myFrame2.jobItem._WIDTHpix
					/ myFrame2.scale.doubleValue() + "");
			texts = myFrame2.frowTextObjects.toArray();
		}
		count = 0;
		new ArrayList();
		double newSY = highestY;
		for (final Object t : texts) {
			for (final Object vc : mHs) {

				if (((Profiles) vc).rowCol == count + 1) {

					Profiles newMullion = new Profiles();
					newMullion = newMullion.cloneProfile(((Profiles) vc),
							bOpeningObject);
					newMullion = addMullionH.getProfileDims(newMullion);

					newMullion.y2 = newSY + Double.parseDouble(t.toString())
							* myFrame2.scale.doubleValue();
					newMullion.y3 = newSY + Double.parseDouble(t.toString())
							* myFrame2.scale.doubleValue();
					newMullion.y1 = newMullion.y2 + newMullion.thickness;
					newMullion.y4 = newMullion.y3 + newMullion.thickness;
					newMullion.centerYs = newMullion.y2 + newMullion.thickness
							/ 2;
					newMullion.centerYe = newMullion.y3 + newMullion.thickness
							/ 2;

					newMullion.y2cl = newMullion.y2a = newMullion.y2
							- newMullion.partDimC;
					newMullion.x3cl = newMullion.y3a = newMullion.y3
							- newMullion.partDimC;
					newMullion.y1al = newMullion.y1a = newMullion.y1
							+ newMullion.partDimA;
					newMullion.y4al = newMullion.y4a = newMullion.y4
							+ newMullion.partDimA;

					newSY = newMullion.y1;

					addMullionH.verifyLimitLR(newMullion);

					addMullionH.calcMullion = new CalculateMullionHii(
							addMullionH);

					addMullionH.newStartingYCenter = newMullion.centerYs;

					addMullionH.newStartingYRTc = newMullion.x2cl;

					addMullionH.newStartingYRT = newMullion.x2;

					addMullionH.newStartingYLB = newMullion.x1;

					addMullionH.newStartingYLBa = newMullion.x1al;

					addMullionH.hcEndX = Math.max(bX2, bX3);

					addMullionH.calcMullion.calculateCoord(newMullion);

					addMullionH.resetRecalcMullionBom(newMullion);

					bOpeningObject.mullionsH.add(newMullion);
					break;

				}

			}
			count++;
		}

		bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
		bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();

		addMullionH.recalcVCCoords();
		addMullionH.reOrderHMNotches();
		partObjects.clear();
		this.resetParts();

		// addMullion.splitParts(null, false, false);
		this.doOpenings();
		addMullionH = null;

	}

	public void modifyVMullionPos(final int pos) throws Exception {// Need to

		// test on
		// Row Col
		AddMullionV addMullion = new AddMullionV(bOpeningObject,
				myFrame2.jobItem, myFrame2, 2);
		new AddMullionH(bOpeningObject, myFrame2.jobItem, myFrame2, 2);

		// if (!this.modifyDims) {
		bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();

		bOpeningObject.mullions.clear();

		final Object[] myTopTexts = myFrame2.topTexts.toArray();

		myFrame2.botTexts.toArray();

		double deltaX = 0;
		double startX = 0;
		for (final Object vc : bOpeningObject.mullionObjectsV) {
			if (pos != 99) {
				if (((Profiles) vc).startPos <= pos
						&& ((Profiles) vc).endPos >= pos) {
					for (final Object text : myTopTexts) {

						if (((Profiles) vc).rowCol == ((TextFieldTop) text).endRowCol) {

							if (this.myFrame2.jobItem.myCanvas.dimensionType == 5) {
								deltaX = ((TextFieldTop) text).newSize
										- ((TextFieldTop) text).size;
							} else {
								deltaX = ((TextFieldTop) text).newPose
										- ((Profiles) vc).x1;
							}

							resetVMullionPosUsingDeltaX(deltaX, vc);

							break;
						}
					}

					recalcMullionRedraw(addMullion, vc);

					for (final Object vc2 : bOpeningObject.mullionObjectsV) {
						if (((Profiles) vc).rowCol == ((Profiles) vc2).rowCol
								&& ((Profiles) vc2).startPos != pos) {
							for (final Object text : myTopTexts) {
								if (((Profiles) vc2).rowCol == ((TextFieldTop) text).endRowCol) {
									deltaX = ((TextFieldTop) text).newPose
											- ((Profiles) vc2).x1;

									resetVMullionPosUsingDeltaX(deltaX, vc2);

									break;
								}
							}

							recalcMullionRedraw(addMullion, vc2);
						}
					}
				}
				//
			}

		}

		for (final Object vc2 : bOpeningObject.mullionObjectsV) {
			bOpeningObject.mullions.add(vc2);
		}

		openings.toArray();
		bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
		bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();

		addMullion.recalcHCCoords();
		addMullion.reOrderVNotches();

		partObjects.clear();
		this.resetParts();

		addMullion.splitParts(null, false, false);
		this.doOpenings();
		this.doMullions(this.bOpeningObject);
		addMullion = null;
	}

	private void resetVMullionPosUsingDeltaX(double deltaX, final Object vc) {
		((Profiles) vc).x1 = ((Profiles) vc).x1 + deltaX;
		((Profiles) vc).x2 = ((Profiles) vc).x2 + deltaX;
		((Profiles) vc).x4 = ((Profiles) vc).x4 + deltaX;
		((Profiles) vc).x3 = ((Profiles) vc).x3 + deltaX;

		((Profiles) vc).x1a = ((Profiles) vc).x1a + deltaX;
		((Profiles) vc).x2a = ((Profiles) vc).x2a + deltaX;
		((Profiles) vc).x4a = ((Profiles) vc).x4a + deltaX;
		((Profiles) vc).x3a = ((Profiles) vc).x3a + deltaX;

		((Profiles) vc).x1b = ((Profiles) vc).x1b + deltaX;
		((Profiles) vc).x2b = ((Profiles) vc).x2b + deltaX;
		((Profiles) vc).x4b = ((Profiles) vc).x4b + deltaX;
		((Profiles) vc).x3b = ((Profiles) vc).x3b + deltaX;

		((Profiles) vc).x1a3 = ((Profiles) vc).x1a3 + deltaX;
		((Profiles) vc).x2a3 = ((Profiles) vc).x2a3 + deltaX;
		((Profiles) vc).x4a3 = ((Profiles) vc).x4a3 + deltaX;
		((Profiles) vc).x3a3 = ((Profiles) vc).x3a3 + deltaX;

		((Profiles) vc).centerXs = ((Profiles) vc).centerXs + deltaX;
		((Profiles) vc).centerXe = ((Profiles) vc).centerXe + deltaX;
		((Profiles) vc).x1al = ((Profiles) vc).x1al + deltaX;
		((Profiles) vc).x2cl = ((Profiles) vc).x2cl + deltaX;
		((Profiles) vc).x4al = ((Profiles) vc).x4al + deltaX;
		((Profiles) vc).x3cl = ((Profiles) vc).x3cl + deltaX;
	}

	public void recalcMullionRedraw(AddMullionV addMullion, final Object vc) {

		addMullion.verifyLimitLR(((Profiles) vc));

		addMullion.calcMullion = new CalculateMullionV(addMullion);

		addMullion.newStartingXCenter = ((Profiles) vc).centerXs;

		addMullion.newStartingXRTc = ((Profiles) vc).x2cl;

		addMullion.newStartingXRT = ((Profiles) vc).x2;

		addMullion.newStartingXLB = ((Profiles) vc).x1;

		addMullion.newStartingXLBa = ((Profiles) vc).x1al;
		addMullion.vcEndY = Math.max(bY3, bY4);
		addMullion.calcMullion.calculateCoord(((Profiles) vc));
	}

	public void modifyVMullionPosGlass(final int pos) throws Exception {// Need

		// to

		// test on
		// Row Col
		AddMullionV addMullion = new AddMullionV(bOpeningObject,
				myFrame2.jobItem, myFrame2, 2);
		new AddMullionH(bOpeningObject, myFrame2.jobItem, myFrame2, 2);
		// if (!this.modifyDims) {
		bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
		bOpeningObject.mullions.clear();

		final Object[] myTopTexts = myFrame2.topTexts.toArray();

		myFrame2.botTexts.toArray();

		double x1 = 0;
		double x1al = 0;
		double x2 = 0;
		double x2cl = 0;
		double xc = 0;

		double x4 = 0;
		double x4al = 0;
		double x3 = 0;
		double x3cl = 0;
		double xe = 0;

		for (final Object vc : bOpeningObject.mullionObjectsV) {
			if (pos != 99) {
				if (((Profiles) vc).startPos <= pos
						&& ((Profiles) vc).endPos >= pos) {
					for (final Object text : myTopTexts) {
						if (((Profiles) vc).rowCol == ((TextFieldTop) text).colNo
								&& !((TextFieldTop) text).isSash) {
							x1 = ((Profiles) vc).x1
									- ((TextFieldTop) text).pose;

							x1al = ((Profiles) vc).x1al
									- ((TextFieldTop) text).pose;

							x2 = ((Profiles) vc).x2
									- ((TextFieldTop) text).pose;

							x2cl = ((Profiles) vc).x2cl
									- ((TextFieldTop) text).pose;

							xc = ((Profiles) vc).centerXs
									- ((TextFieldTop) text).pose;

							x4 = ((Profiles) vc).x4
									- ((TextFieldTop) text).pose;

							x4al = ((Profiles) vc).x4al
									- ((TextFieldTop) text).pose;

							x3 = ((Profiles) vc).x3
									- ((TextFieldTop) text).pose;

							x3cl = ((Profiles) vc).x3cl
									- ((TextFieldTop) text).pose;

							xe = ((Profiles) vc).centerXe
									- ((TextFieldTop) text).pose;

							((Profiles) vc).x1 = ((TextFieldTop) text).newPose
									+ x1;

							((Profiles) vc).x2 = ((TextFieldTop) text).newPose
									+ x2;

							((Profiles) vc).centerXs = ((TextFieldTop) text).newPose
									+ xc;

							((Profiles) vc).x4 = ((TextFieldTop) text).newPose
									+ x4;

							((Profiles) vc).x3 = ((TextFieldTop) text).newPose
									+ x3;

							((Profiles) vc).centerXe = ((TextFieldTop) text).newPose
									+ xe;

							((Profiles) vc).x1al = ((TextFieldTop) text).newPose
									+ x1al;

							((Profiles) vc).x2cl = ((TextFieldTop) text).newPose
									+ x2cl;

							((Profiles) vc).x4al = ((TextFieldTop) text).newPose
									+ x4al;

							((Profiles) vc).x3cl = ((TextFieldTop) text).newPose
									+ x3cl;

							break;
						}

					}
					recalcMullionRedraw(addMullion, vc);

					for (final Object vc2 : bOpeningObject.mullionObjectsV) {
						if (((Profiles) vc).rowCol == ((Profiles) vc2).rowCol
								&& ((Profiles) vc2).startPos != pos) {
							for (final Object text : myTopTexts) {
								if (((Profiles) vc2).rowCol == ((TextFieldTop) text).colNo) {
									x1 = ((Profiles) vc2).x1
											- ((TextFieldTop) text).pose;

									x1al = ((Profiles) vc2).x1al
											- ((TextFieldTop) text).pose;

									x2 = ((Profiles) vc2).x2
											- ((TextFieldTop) text).pose;

									x2cl = ((Profiles) vc2).x2cl
											- ((TextFieldTop) text).pose;

									xc = ((Profiles) vc2).centerXs
											- ((TextFieldTop) text).pose;

									x4 = ((Profiles) vc2).x4
											- ((TextFieldTop) text).pose;

									x4al = ((Profiles) vc2).x4al
											- ((TextFieldTop) text).pose;

									x3 = ((Profiles) vc2).x3
											- ((TextFieldTop) text).pose;

									x3cl = ((Profiles) vc2).x3cl
											- ((TextFieldTop) text).pose;

									xe = ((Profiles) vc2).centerXe
											- ((TextFieldTop) text).pose;

									((Profiles) vc2).x1 = ((TextFieldTop) text).newPose
											+ x1;

									((Profiles) vc2).x2 = ((TextFieldTop) text).newPose
											+ x2;

									((Profiles) vc2).centerXs = ((TextFieldTop) text).newPose
											+ xc;

									((Profiles) vc2).x4 = ((TextFieldTop) text).newPose
											+ x4;

									((Profiles) vc2).x3 = ((TextFieldTop) text).newPose
											+ x3;

									((Profiles) vc2).centerXe = ((TextFieldTop) text).newPose
											+ xe;

									((Profiles) vc2).x1al = ((TextFieldTop) text).newPose
											+ x1al;

									((Profiles) vc2).x2cl = ((TextFieldTop) text).newPose
											+ x2cl;

									((Profiles) vc2).x4al = ((TextFieldTop) text).newPose
											+ x4al;

									((Profiles) vc2).x3cl = ((TextFieldTop) text).newPose
											+ x3cl;

									break;
								}
							}
							recalcMullionRedraw(addMullion, vc2);
						}
					}
				}
				//
			}

		}

		for (final Object vc2 : bOpeningObject.mullionObjectsV) {

			bOpeningObject.mullions.add(vc2);
		}

		openings.toArray();
		bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
		bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();

		addMullion.recalcHCCoords();
		addMullion.reOrderVNotches();
		partObjects.clear();
		this.resetParts();

		addMullion.splitParts(null, false, false);
		this.doOpenings();
		bOpeningObject = this.doMullions(bOpeningObject);
		addMullion = null;
	}

	public boolean modifyVMullion(final Profiles myMullion,
			final Object myMaster, final int type, final boolean masterAbove,
			final boolean sameFrame) throws Exception {// Need

		boolean alignPerformed = false;
		// to
		Profiles myChangedMullion = myMullion; // test
		// on
		// Row Col

		AddMullionV addMullion = new AddMullionV(bOpeningObject,
				myFrame2.jobItem, myFrame2, 2);
		AddMullionH addMullionH = new AddMullionH(bOpeningObject,
				myFrame2.jobItem, myFrame2, 2);

		bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
		bOpeningObject.mullions.clear();
		// clearDrawingALL();

		double deltaX = 0;
		double newX = 0;
		if (masterAbove) {
			newX = ((Profiles) myMaster).centerXe;
			deltaX = newX - myMullion.centerXs;

		} else if (!masterAbove) {
			newX = ((Profiles) myMaster).centerXs;
			deltaX = newX - myMullion.centerXs;

		}

		int masterORC = 0;
		int newMasterRC = 0;
		double masterOX = 0;
		int masterExists = 1;

		masterExists = ((Profiles) myMaster).exists;

		newMasterRC = ((Profiles) myMaster).rowCol;
		if (masterAbove) {
			masterOX = ((Profiles) myMaster).centerXe;
		} else {
			masterOX = ((Profiles) myMaster).centerXs;
		}

		masterORC = ((Profiles) myMaster).rowCol;

		final int slaveORC = myMullion.rowCol;
		int newSlaveRC = myMullion.rowCol;
		double slaveOX = myMullion.centerXs;

		boolean mRCChanged = false;
		boolean noColChanged = false;
		isNewFrame = false;
		bOpeningObject.mullions.toArray();

		if (type == 2) {

			for (final Object vc : bOpeningObject.mullionObjectsV) {

				if (((Profiles) vc).equals(myMullion)) {
					if (masterAbove) {
						slaveOX = ((Profiles) vc).centerXs;
					} else {
						slaveOX = ((Profiles) vc).centerXe;
					}

					((Profiles) vc).x1 = ((Profiles) vc).x1 + deltaX;
					((Profiles) vc).x2 = ((Profiles) vc).x2 + deltaX;
					((Profiles) vc).x4 = ((Profiles) vc).x4 + deltaX;
					((Profiles) vc).x3 = ((Profiles) vc).x3 + deltaX;
					((Profiles) vc).centerXs = ((Profiles) vc).centerXs
							+ deltaX;
					((Profiles) vc).centerXe = ((Profiles) vc).centerXe
							+ deltaX;
					((Profiles) vc).x1al = ((Profiles) vc).x1al + deltaX;
					((Profiles) vc).x2cl = ((Profiles) vc).x2cl + deltaX;
					((Profiles) vc).x4al = ((Profiles) vc).x4al + deltaX;
					((Profiles) vc).x3cl = ((Profiles) vc).x3cl + deltaX;
					alignPerformed = true;

					if (masterExists == 1 && masterAbove && sameFrame) {
						((Profiles) vc).exists = 2;
					} else if (masterExists == 1 && !masterAbove && sameFrame) {
						((Profiles) vc).exists = 1;
					} else if (masterExists > 1 && masterAbove && sameFrame) {
						((Profiles) vc).exists = 2;
					} else if (masterExists > 1 && !masterAbove && sameFrame) {
						((Profiles) vc).exists = 2;
					}

					if (masterOX > slaveOX && sameFrame) {
						// masterORC
						// =
						// ((Profiles)
						// vc).rowCol;
						newMasterRC = ((Profiles) vc).rowCol;
						mRCChanged = true;
					}
					if (sameFrame) {
						if (mRCChanged) {
							((Profiles) vc).rowCol = newMasterRC;
						} else {
							((Profiles) vc).rowCol = masterORC;
						}
						newSlaveRC = ((Profiles) vc).rowCol;
						if (newSlaveRC != slaveORC || newMasterRC < masterORC) {
							xCols = xCols - 1;
							bOpeningObject.xCols = bOpeningObject.xCols - 1;
							noColChanged = true;
						}
					}

					recalcMullionRedraw(addMullion, vc);
					if (masterAbove && sameFrame) {
						myChangedMullion = (Profiles) vc;
					} else {
						bOpeningObject.mullions.add(vc);
					}
				} else if (((Profiles) vc).equals(myMaster)) {
					if (masterORC == 1 && masterAbove) {

					} else if (masterORC == 1 && !masterAbove) {
						((Profiles) vc).exists = 2;
					} else if (masterORC > 1 && masterAbove) {

					} else if (masterORC > 1 && !masterAbove) {

					}
					if (newMasterRC != masterORC) {
						((Profiles) vc).rowCol = newMasterRC;
					}
					bOpeningObject.mullions.add(vc);
					if (masterAbove && sameFrame) {
						bOpeningObject.mullions.add(myChangedMullion);
					}
				} else {
					bOpeningObject.mullions.add(vc);
				}
			}

			bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
			bOpeningObject.mullions.clear();
			for (final Object vc2 : bOpeningObject.mullionObjectsV) {
				if (((Profiles) vc2).rowCol == slaveORC
						&& ((Profiles) vc2).exists > 1
						&& ((Profiles) vc2).profileSelected == 0) {
					((Profiles) vc2).rowCol = newSlaveRC;

					((Profiles) vc2).x1 = ((Profiles) vc2).x1 + deltaX;
					((Profiles) vc2).x2 = ((Profiles) vc2).x2 + deltaX;
					((Profiles) vc2).x4 = ((Profiles) vc2).x4 + deltaX;
					((Profiles) vc2).x3 = ((Profiles) vc2).x3 + deltaX;
					((Profiles) vc2).centerXs = ((Profiles) vc2).centerXs
							+ deltaX;
					((Profiles) vc2).centerXe = ((Profiles) vc2).centerXe
							+ deltaX;
					((Profiles) vc2).x1al = ((Profiles) vc2).x1al + deltaX;
					((Profiles) vc2).x2cl = ((Profiles) vc2).x2cl + deltaX;
					((Profiles) vc2).x4al = ((Profiles) vc2).x4al + deltaX;
					((Profiles) vc2).x3cl = ((Profiles) vc2).x3cl + deltaX;
					alignPerformed = true;

					addMullion.verifyLimitLR(((Profiles) vc2));

					addMullion.calcMullion = new CalculateMullionV(addMullion);

					addMullion.newStartingXCenter = ((Profiles) vc2).centerXs;

					addMullion.newStartingXRTc = ((Profiles) vc2).x2cl;

					addMullion.newStartingXRT = ((Profiles) vc2).x2;

					addMullion.newStartingXLB = ((Profiles) vc2).x1;

					addMullion.newStartingXLBa = ((Profiles) vc2).x1al;
					// addMullion.vcEndY
					// =
					// Math.max(this.bY3,
					// bY4);
					addMullion.calcMullion.calculateCoord(((Profiles) vc2));

				}
				bOpeningObject.mullions.add(vc2);
			}

			// /REORDER Mullions
			bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
			bOpeningObject.mullions.clear();
			for (final Object vc2 : bOpeningObject.mullionObjectsV) {
				if (((Profiles) vc2).rowCol > masterORC
						&& (mRCChanged || noColChanged)) {
					((Profiles) vc2).rowCol = ((Profiles) vc2).rowCol - 1;
				}
				bOpeningObject.mullions.add(vc2);
			}

			bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();
			bOpeningObject.mullionsH.clear();
			for (final Object hc : bOpeningObject.mullionObjectsH) {
				if (((Profiles) hc).y3 > ((Profiles) myMaster).y1
						&& ((Profiles) hc).y4 <= ((Profiles) myMaster).y4) {
					if (((Profiles) hc).endPos == masterORC && mRCChanged) {
						((Profiles) hc).endPos = newMasterRC;
					}
					if (((Profiles) hc).endPos > masterORC && mRCChanged) {
						((Profiles) hc).endPos = ((Profiles) hc).endPos - 1;
					}
					if (((Profiles) hc).startPos >= masterORC + 1 && mRCChanged) {
						((Profiles) hc).startPos = ((Profiles) hc).startPos - 1;
					}
					if (((Profiles) hc).startPos > masterORC + 1 && !mRCChanged
							&& noColChanged) {
						((Profiles) hc).startPos = ((Profiles) hc).startPos - 1;
					}
					//

				} else if (((Profiles) hc).y3 > myMullion.y1
						&& ((Profiles) hc).y4 <= myMullion.y4) {
					if (((Profiles) hc).endPos == slaveORC) {
						((Profiles) hc).endPos = newSlaveRC;
					}
					if (((Profiles) hc).endPos > slaveORC && noColChanged) {
						((Profiles) hc).endPos = ((Profiles) hc).endPos - 1;
					}
					if (((Profiles) hc).startPos == slaveORC + 1) {
						((Profiles) hc).startPos = newSlaveRC + 1;
					}
					if (((Profiles) hc).startPos > slaveORC + 1 && noColChanged) {
						((Profiles) hc).startPos = ((Profiles) hc).startPos - 1;
					}

				} else {
					if (noColChanged) {
						if (((Profiles) hc).startPos >= masterORC
								&& ((Profiles) hc).startPos != 1 && mRCChanged) {
							((Profiles) hc).startPos = newMasterRC + 1;
						}
						if (((Profiles) hc).endPos >= newMasterRC) {
							((Profiles) hc).endPos = ((Profiles) hc).endPos - 1;
						}
					}
				}
				addMullionH.verifyLimitLR(((Profiles) hc));

				addMullionH.calcMullion = new CalculateMullionHii(addMullionH);

				addMullionH.newStartingYCenter = ((Profiles) hc).centerYs;

				addMullionH.newStartingYRTc = ((Profiles) hc).y2cl;

				addMullionH.newStartingYRT = ((Profiles) hc).y2;

				addMullionH.newStartingYLB = ((Profiles) hc).y1;

				addMullionH.newStartingYLBa = ((Profiles) hc).y1al;
				// addMullion.vcEndX =
				// Math.max(this.bY3,
				// bY4);
				addMullionH.calcMullion.calculateCoord(((Profiles) hc));
				bOpeningObject.mullionsH.add(hc);
			}

			final Object[] openingObjects = openings.toArray();
			openings.clear();

			for (final Object op : openingObjects) {

				if (((OpeningObject) op).startRow <= ((Profiles) myMaster).startPos
						&& ((OpeningObject) op).endRow >= ((Profiles) myMaster).endPos) {

					if (mRCChanged) {
						if (((OpeningObject) op).endCol == masterORC) {
							((OpeningObject) op).endCol = newMasterRC;
						}
						if (((OpeningObject) op).startCol >= masterORC + 1) {
							((OpeningObject) op).startCol = ((OpeningObject) op).startCol - 1;
							((OpeningObject) op).endCol = ((OpeningObject) op).endCol - 1;

						}
					} else if (!mRCChanged) {
						if (((OpeningObject) op).startCol >= masterORC + 1
								&& noColChanged) {

							((OpeningObject) op).endCol = ((OpeningObject) op).endCol - 1;

							if (((OpeningObject) op).endCol < ((OpeningObject) op).startCol) {
								((OpeningObject) op).startCol = ((OpeningObject) op).endCol;
							}
						}
					}

				} else if (((OpeningObject) op).startRow >= myMullion.startPos
						&& ((OpeningObject) op).endRow <= myMullion.endPos) {
					if (((OpeningObject) op).endCol == slaveORC) {
						((OpeningObject) op).endCol = newSlaveRC;
					}
					if (((OpeningObject) op).startCol >= slaveORC + 1
							&& newSlaveRC != slaveORC) {
						((OpeningObject) op).startCol = ((OpeningObject) op).startCol - 1;
						((OpeningObject) op).endCol = ((OpeningObject) op).endCol - 1;
					}
					if (((OpeningObject) op).startCol == slaveORC + 1
							&& newSlaveRC == slaveORC && noColChanged) {

						((OpeningObject) op).endCol = ((OpeningObject) op).endCol - 1;
					}
					if (((OpeningObject) op).startCol > slaveORC + 1
							&& newSlaveRC == slaveORC && noColChanged) {
						((OpeningObject) op).startCol = ((OpeningObject) op).startCol - 1;
						((OpeningObject) op).endCol = ((OpeningObject) op).endCol - 1;
					}
				} else {
					if (noColChanged) {
						if (((OpeningObject) op).startCol >= masterORC
								&& ((OpeningObject) op).startCol != 1) {
							((OpeningObject) op).startCol = ((OpeningObject) op).startCol - 1;
						}
						if (((OpeningObject) op).endCol >= newMasterRC) {
							((OpeningObject) op).endCol = ((OpeningObject) op).endCol - 1;
						}
					}
				}
				openings.add(op);

			}

		} else {// // COUPLER MASTER
			for (final Object vc : bOpeningObject.mullionObjectsV) {

				if (((Profiles) vc).equals(myMullion)) {
					if (masterAbove) {
						slaveOX = ((Profiles) vc).centerXs;
					} else {
						slaveOX = ((Profiles) vc).centerXe;
					}

					((Profiles) vc).x1 = myMullion.x1 = ((Profiles) vc).x1
							+ deltaX;
					((Profiles) vc).x2 = myMullion.x2 = ((Profiles) vc).x2
							+ deltaX;
					((Profiles) vc).x4 = myMullion.x4 = ((Profiles) vc).x4
							+ deltaX;
					((Profiles) vc).x3 = myMullion.x3 = ((Profiles) vc).x3
							+ deltaX;
					((Profiles) vc).centerXs = myMullion.centerXs = ((Profiles) vc).centerXs
							+ deltaX;
					((Profiles) vc).centerXe = myMullion.centerXe = ((Profiles) vc).centerXe
							+ deltaX;
					((Profiles) vc).x1al = myMullion.x1al = ((Profiles) vc).x1al
							+ deltaX;
					((Profiles) vc).x2cl = myMullion.x2cl = ((Profiles) vc).x2cl
							+ deltaX;
					((Profiles) vc).x4al = myMullion.x4al = ((Profiles) vc).x4al
							+ deltaX;
					((Profiles) vc).x3cl = myMullion.x3cl = ((Profiles) vc).x3cl
							+ deltaX;
					alignPerformed = true;
					recalcMullionRedraw(addMullion, vc);
					bOpeningObject.mullions.add(vc);
				} else {
					bOpeningObject.mullions.add(vc);
				}
			}

			// /REORDER Mullions
			bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
			bOpeningObject.mullions.clear();
			for (final Object vc2 : bOpeningObject.mullionObjectsV) {
				if (((Profiles) vc2).rowCol == slaveORC
						&& ((Profiles) vc2).exists > 1) {
					((Profiles) vc2).rowCol = newSlaveRC;

					((Profiles) vc2).x1 = ((Profiles) vc2).x1 + deltaX;
					((Profiles) vc2).x2 = ((Profiles) vc2).x2 + deltaX;
					((Profiles) vc2).x4 = ((Profiles) vc2).x4 + deltaX;
					((Profiles) vc2).x3 = ((Profiles) vc2).x3 + deltaX;
					((Profiles) vc2).centerXs = ((Profiles) vc2).centerXs
							+ deltaX;
					((Profiles) vc2).centerXe = ((Profiles) vc2).centerXe
							+ deltaX;
					((Profiles) vc2).x1al = ((Profiles) vc2).x1al + deltaX;
					((Profiles) vc2).x2cl = ((Profiles) vc2).x2cl + deltaX;
					((Profiles) vc2).x4al = ((Profiles) vc2).x4al + deltaX;
					((Profiles) vc2).x3cl = ((Profiles) vc2).x3cl + deltaX;
					alignPerformed = true;
					addMullion.verifyLimitLR(((Profiles) vc2));

					addMullion.calcMullion = new CalculateMullionV(addMullion);

					addMullion.newStartingXCenter = ((Profiles) vc2).centerXs;

					addMullion.newStartingXRTc = ((Profiles) vc2).x2cl;

					addMullion.newStartingXRT = ((Profiles) vc2).x2;

					addMullion.newStartingXLB = ((Profiles) vc2).x1;

					addMullion.newStartingXLBa = ((Profiles) vc2).x1al;
					// addMullion.vcEndY
					// =
					// Math.max(this.bY3,
					// bY4);
					addMullion.calcMullion.calculateCoord(((Profiles) vc2));

				}
				bOpeningObject.mullions.add(vc2);
			}

			bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();
			bOpeningObject.mullionsH.clear();
			for (final Object hc : bOpeningObject.mullionObjectsH) {
				if (((Profiles) hc).y3 > myMullion.y1
						&& ((Profiles) hc).y4 <= myMullion.y4) {
					if (((Profiles) hc).endPos == slaveORC) {
						((Profiles) hc).endPos = newSlaveRC;
					}
					if (((Profiles) hc).endPos > slaveORC && noColChanged) {
						((Profiles) hc).endPos = ((Profiles) hc).endPos - 1;
					}
					if (((Profiles) hc).startPos == slaveORC + 1) {
						((Profiles) hc).startPos = newSlaveRC + 1;
					}

				}

				addMullionH.verifyLimitLR(((Profiles) hc));

				addMullionH.calcMullion = new CalculateMullionHii(addMullionH);

				addMullionH.newStartingYCenter = ((Profiles) hc).centerYs;

				addMullionH.newStartingYRTc = ((Profiles) hc).y2cl;

				addMullionH.newStartingYRT = ((Profiles) hc).y2;

				addMullionH.newStartingYLB = ((Profiles) hc).y1;

				addMullionH.newStartingYLBa = ((Profiles) hc).y1al;
				// addMullion.vcEndX =
				// Math.max(this.bY3,
				// bY4);
				addMullionH.calcMullion.calculateCoord(((Profiles) hc));
				bOpeningObject.mullionsH.add(hc);
			}

			final Object[] openingObjects = openings.toArray();
			openings.clear();

			for (final Object op : openingObjects) {
				if (((OpeningObject) op).startRow >= myMullion.startPos
						&& ((OpeningObject) op).endRow <= myMullion.endPos) {
					if (((OpeningObject) op).endCol == slaveORC) {
						((OpeningObject) op).endCol = newSlaveRC;
					}
					if (((OpeningObject) op).startCol >= slaveORC + 1
							&& newSlaveRC != slaveORC) {
						((OpeningObject) op).startCol = ((OpeningObject) op).startCol - 1;
						((OpeningObject) op).endCol = ((OpeningObject) op).endCol - 1;
					}
				} else {
					if (noColChanged) {
						if (((OpeningObject) op).startCol >= newMasterRC
								&& ((OpeningObject) op).startCol != 1) {
							((OpeningObject) op).startCol = ((OpeningObject) op).startCol - 1;
						}
						if (((OpeningObject) op).endCol >= newMasterRC) {
							((OpeningObject) op).endCol = ((OpeningObject) op).endCol - 1;
						}
					}
				}
				openings.add(op);
			}

		}

		if (alignPerformed) {

			myFrame2.jobItem.resetGraphics();

			myFrame2.ellipses.clear();
			myFrame2.topTexts.clear();
			myFrame2.botTexts.clear();
			myFrame2.leftTexts.clear();
			myFrame2.rightTexts.clear();

			addMullion.recalcHCCoords();
			addMullion.reOrderVNotches();
			addMullionH.reOrderHMNotches();

			partObjects.clear();
			this.resetParts();

			addMullion.splitParts(null, false, false);

			if (a_levelID <= 3) {
				this.doOpenings();
				myFrame2.facetUsed.drawFrames();
			} else {
				this.doOpenings();
				bOpeningObject = doMullions(bOpeningObject);
			}

			myFrame2.modifyDims = true;
			myFrame2.resetAlign();
			myFrame2.hideAlign();
			if (myFrame2.hasGrids) {
				myFrame2.gridsPanel.bSetSelectedGrid.doClick();
			}

			// Clear draw canvas components
			myFrame2.jobItem.myCanvas.clearDrawCanvasComponents();

			myFrame2.jobItem.myCanvas.createTextFieldsTop();
			myFrame2.jobItem.myCanvas.createTextFieldsLeft();
			myFrame2.jobItem.myCanvas.createTextFieldsFacet();
			myFrame2.jobItem.myCanvas.createTextFieldsCoupler();

			this.reDrawRadioRowCol(yRows, xCols, 1,
					myFrame2.jobItem.myCanvas.selectedRadioForRow,
					myFrame2.jobItem.myCanvas.selectedRadioForCol,
					myFrame2.facetUsed);

			myFrame2.jobItem.myCanvas.validate();
			myFrame2.jobItem.myCanvas.repaint();
		}
		addMullion = null;
		addMullionH = null;

		return alignPerformed;
	}

	public void clearDrawingALL() {

		newDesign = false;
		top1.topFillShape.reset();
		top1.topObjectPath.reset();

		myFrame2.jobItem.myCanvas.clearDrawObjects();

		myFrame2.myTextRow = null;
		myFrame2.myTextBot = null;
		myFrame2.myTextLeft = null;
		myFrame2.myTextRight = null;

		myFrame2.facetUsed.resetPanels();

	}

	public boolean modifyHMullion(final Profiles myMullion,
			final Object myMaster, final int type, final boolean masterLeft,
			final boolean sameFrame) throws Exception {

		boolean alignPerformed = false;
		Profiles myChangedMullion = myMullion; // test

		AddMullionV addMullion = new AddMullionV(bOpeningObject,
				myFrame2.jobItem, myFrame2, 2);
		AddMullionH addMullionH = new AddMullionH(bOpeningObject,
				myFrame2.jobItem, myFrame2, 2);

		bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();
		bOpeningObject.mullionsH.clear();
		this.clearDrawingALL();

		double deltaY = 0;
		double newY = 0;
		if (masterLeft) {
			newY = ((Profiles) myMaster).centerYe;
			deltaY = newY - myMullion.centerYs;

		} else if (!masterLeft) {
			newY = ((Profiles) myMaster).centerYs;
			deltaY = newY - myMullion.centerYs;

		} else if (type == 1 && masterLeft) {
			newY = ((Profiles) myMaster).centerYe;
			deltaY = newY - myMullion.centerYs;

		} else if (type == 1 && !masterLeft) {
			newY = ((Profiles) myMaster).centerYs;
			deltaY = newY - myMullion.centerYe;

		}
		int masterORC = 0;
		int newMasterRC = 0;
		double masterOY = 0;
		int masterExists = 1;
		// if (type == 2)
		// {
		masterExists = ((Profiles) myMaster).exists;
		newMasterRC = ((Profiles) myMaster).rowCol;
		if (masterLeft) {
			masterOY = ((Profiles) myMaster).centerYe;
		} else {
			masterOY = ((Profiles) myMaster).centerYs;
		}
		if (type == 2) {
			masterORC = ((Profiles) myMaster).rowCol;
		}
		// }
		// else
		// {
		// newMasterRC =
		// ((Profiles) myMaster).rowCol;
		// if (masterLeft)
		// {
		// masterOY =
		// ((Profiles) myMaster).centerYe;
		// }
		// else
		// {
		// masterOY =
		// ((Profiles) myMaster).centerYs;
		// }
		// if (type == 2)
		// {
		// masterORC =
		// ((Profiles) myMaster).rowCol;
		// }
		// }
		final int slaveORC = myMullion.rowCol;
		int newSlaveRC = myMullion.rowCol;
		double slaveOY = myMullion.centerYs;

		boolean mRCChanged = false;
		boolean noRowChanged = false;
		if (type == 2) {
			for (final Object vc : bOpeningObject.mullionObjectsH) {

				if (((Profiles) vc).equals(myMullion)) {
					if (masterLeft) {
						slaveOY = ((Profiles) vc).centerYs;
					} else {
						slaveOY = ((Profiles) vc).centerYe;
					}

					((Profiles) vc).y1 = ((Profiles) vc).y1 + deltaY;
					((Profiles) vc).y2 = ((Profiles) vc).y2 + deltaY;
					((Profiles) vc).y4 = ((Profiles) vc).y4 + deltaY;
					((Profiles) vc).y3 = ((Profiles) vc).y3 + deltaY;
					((Profiles) vc).centerYs = ((Profiles) vc).centerYs
							+ deltaY;
					((Profiles) vc).centerYe = ((Profiles) vc).centerYe
							+ deltaY;
					((Profiles) vc).y1al = ((Profiles) vc).y1al + deltaY;
					((Profiles) vc).y2cl = ((Profiles) vc).y2cl + deltaY;
					((Profiles) vc).y4al = ((Profiles) vc).y4al + deltaY;
					((Profiles) vc).y3cl = ((Profiles) vc).y3cl + deltaY;
					alignPerformed = true;
					if (masterExists == 1 && masterLeft && sameFrame) {
						((Profiles) vc).exists = 2;
					} else if (masterExists == 1 && !masterLeft && sameFrame) {
						((Profiles) vc).exists = 1;
					} else if (masterExists > 1 && masterLeft && sameFrame) {
						((Profiles) vc).exists = 2;
					} else if (masterExists > 1 && !masterLeft && sameFrame) {
						((Profiles) vc).exists = 2;
					}

					if (masterOY > slaveOY && sameFrame) {
						// masterORC
						// =
						// ((Profiles)
						// vc).rowCol;
						newMasterRC = ((Profiles) vc).rowCol;
						mRCChanged = true;
					}

					if (sameFrame) {
						if (mRCChanged) {
							((Profiles) vc).rowCol = newMasterRC;
						} else {
							((Profiles) vc).rowCol = masterORC;
						}
						newSlaveRC = ((Profiles) vc).rowCol;
						if (newSlaveRC != slaveORC || newMasterRC < masterORC) {
							yRows = yRows - 1;
							bOpeningObject.yRows = bOpeningObject.yRows - 1;
							noRowChanged = true;
						}
					}

					addMullionH.verifyLimitLR(((Profiles) vc));

					addMullionH.calcMullion = new CalculateMullionHii(
							addMullionH);

					addMullionH.newStartingYCenter = ((Profiles) vc).centerYs;

					addMullionH.newStartingYRTc = ((Profiles) vc).y2cl;

					addMullionH.newStartingYRT = ((Profiles) vc).y2;

					addMullionH.newStartingYLB = ((Profiles) vc).y1;

					addMullionH.newStartingYLBa = ((Profiles) vc).y1al;
					// addMullionH.vcEndY
					// =
					// Math.max(this.bY3,
					// bY4);
					addMullionH.calcMullion.calculateCoord(((Profiles) vc));

					if (masterLeft && sameFrame) {
						myChangedMullion = (Profiles) vc;
					} else {
						bOpeningObject.mullionsH.add(vc);
					}

				} else if (((Profiles) vc).equals(myMaster)) {
					if (masterORC == 1 && masterLeft) {

					} else if (masterORC == 1 && !masterLeft) {
						((Profiles) vc).exists = 2;
					} else if (masterORC > 1 && masterLeft) {

					} else if (masterORC > 1 && !masterLeft) {

					}
					if (newMasterRC != masterORC) {
						((Profiles) vc).rowCol = newMasterRC;
					}
					bOpeningObject.mullionsH.add(vc);
					if (masterLeft && sameFrame) {
						bOpeningObject.mullionsH.add(myChangedMullion);
					}
				} else {
					bOpeningObject.mullionsH.add(vc);
				}
			}

			bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();
			bOpeningObject.mullionsH.clear();
			for (final Object vc2 : bOpeningObject.mullionObjectsH) {
				if (((Profiles) vc2).rowCol == slaveORC
						&& ((Profiles) vc2).exists > 1
						&& ((Profiles) vc2).profileSelected == 0) {
					((Profiles) vc2).rowCol = newSlaveRC;

					((Profiles) vc2).y1 = ((Profiles) vc2).y1 + deltaY;
					((Profiles) vc2).y2 = ((Profiles) vc2).y2 + deltaY;
					((Profiles) vc2).y4 = ((Profiles) vc2).y4 + deltaY;
					((Profiles) vc2).y3 = ((Profiles) vc2).y3 + deltaY;
					((Profiles) vc2).centerYs = ((Profiles) vc2).centerYs
							+ deltaY;
					((Profiles) vc2).centerYe = ((Profiles) vc2).centerYe
							+ deltaY;
					((Profiles) vc2).y1al = ((Profiles) vc2).y1al + deltaY;
					((Profiles) vc2).y2cl = ((Profiles) vc2).y2cl + deltaY;
					((Profiles) vc2).y4al = ((Profiles) vc2).y4al + deltaY;
					((Profiles) vc2).y3cl = ((Profiles) vc2).y3cl + deltaY;
					alignPerformed = true;
					addMullionH.verifyLimitLR(((Profiles) vc2));

					addMullionH.calcMullion = new CalculateMullionHii(
							addMullionH);

					addMullionH.newStartingYCenter = ((Profiles) vc2).centerYs;

					addMullionH.newStartingYRTc = ((Profiles) vc2).y2cl;

					addMullionH.newStartingYRT = ((Profiles) vc2).y2;

					addMullionH.newStartingYLB = ((Profiles) vc2).y1;

					addMullionH.newStartingYLBa = ((Profiles) vc2).y1al;

					addMullionH.calcMullion.calculateCoord(((Profiles) vc2));

				}
				bOpeningObject.mullionsH.add(vc2);
			}

			// /REORDER Mullions
			bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();
			bOpeningObject.mullionsH.clear();
			for (final Object vc2 : bOpeningObject.mullionObjectsH) {
				if (((Profiles) vc2).rowCol > masterORC
						&& (mRCChanged || noRowChanged)) {
					((Profiles) vc2).rowCol = ((Profiles) vc2).rowCol - 1;
				}
				bOpeningObject.mullionsH.add(vc2);
			}

			bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
			bOpeningObject.mullions.clear();
			for (final Object hc : bOpeningObject.mullionObjectsV) {
				if (((Profiles) hc).x4 > ((Profiles) myMaster).x2
						&& ((Profiles) hc).x3 <= ((Profiles) myMaster).x3) {
					if (((Profiles) hc).endPos == masterORC && mRCChanged) {
						((Profiles) hc).endPos = newMasterRC;
					}
					if (((Profiles) hc).endPos > masterORC && mRCChanged) {
						((Profiles) hc).endPos = ((Profiles) hc).endPos - 1;
					}
					if (((Profiles) hc).startPos > masterORC + 1 && mRCChanged) {
						((Profiles) hc).startPos = ((Profiles) hc).startPos - 1;
					}
					if (((Profiles) hc).startPos > masterORC + 1 && !mRCChanged
							&& noRowChanged) {
						((Profiles) hc).startPos = ((Profiles) hc).startPos - 1;
					}
					if (((Profiles) hc).endPos > masterORC && !mRCChanged
							&& noRowChanged) {
						((Profiles) hc).endPos = ((Profiles) hc).endPos - 1;
					}

				} else if (((Profiles) hc).x4 > myMullion.x2
						&& ((Profiles) hc).x3 <= myMullion.x3) {
					if (((Profiles) hc).endPos == slaveORC) {
						((Profiles) hc).endPos = newSlaveRC;
					}
					if (((Profiles) hc).endPos > slaveORC && noRowChanged) {
						((Profiles) hc).endPos = ((Profiles) hc).endPos - 1;
					}
					if (((Profiles) hc).startPos == slaveORC + 1) {
						((Profiles) hc).startPos = newSlaveRC + 1;
					}

				} else {
					if (noRowChanged) {
						if (((Profiles) hc).startPos > newMasterRC
								&& ((Profiles) hc).startPos != 1) {
							((Profiles) hc).startPos = ((Profiles) hc).startPos - 1;
						}
						if (((Profiles) hc).endPos >= newMasterRC) {
							((Profiles) hc).endPos = ((Profiles) hc).endPos - 1;
						}
					}
				}
				recalcMullionRedraw(addMullion, hc);
				bOpeningObject.mullions.add(hc);
			}

			final Object[] openingObjects = openings.toArray();
			openings.clear();

			for (final Object op : openingObjects) {

				if (((OpeningObject) op).startCol >= ((Profiles) myMaster).startPos
						&& ((OpeningObject) op).endCol <= ((Profiles) myMaster).endPos) {
					if (((OpeningObject) op).endRow == masterORC && mRCChanged) {
						((OpeningObject) op).endRow = newMasterRC;
					}
					if (((OpeningObject) op).startRow == masterORC + 1
							&& mRCChanged) {
						((OpeningObject) op).startRow = ((OpeningObject) op).startRow - 1;
						((OpeningObject) op).endRow = ((OpeningObject) op).endRow - 1;

					}
					if (((OpeningObject) op).startRow == masterORC + 1
							&& !mRCChanged && noRowChanged) {

						((OpeningObject) op).endRow = ((OpeningObject) op).endRow - 1;

					}
					if (((OpeningObject) op).startRow > masterORC + 1
							&& !mRCChanged && noRowChanged) {

						((OpeningObject) op).startRow = ((OpeningObject) op).startRow - 1;
						((OpeningObject) op).endRow = ((OpeningObject) op).endRow - 1;

					}

				} else if (((OpeningObject) op).startCol >= myMullion.startPos
						&& ((OpeningObject) op).endCol <= myMullion.endPos) {
					if (((OpeningObject) op).endRow == slaveORC) {
						((OpeningObject) op).endRow = newSlaveRC;
					}
					if (((OpeningObject) op).startRow >= slaveORC + 1
							&& newSlaveRC != slaveORC) {
						((OpeningObject) op).startRow = ((OpeningObject) op).startRow - 1;
						((OpeningObject) op).endRow = ((OpeningObject) op).endRow - 1;
					}
					if (((OpeningObject) op).startRow >= slaveORC + 1
							&& mRCChanged) {

						((OpeningObject) op).endRow = ((OpeningObject) op).endRow - 1;
					}
				} else {
					if (noRowChanged) {
						if (((OpeningObject) op).startRow >= newMasterRC
								&& ((OpeningObject) op).startRow != 1) {
							((OpeningObject) op).startRow = ((OpeningObject) op).startRow - 1;
						}
						if (((OpeningObject) op).endRow >= newMasterRC) {
							((OpeningObject) op).endRow = ((OpeningObject) op).endRow - 1;
						}
					}
				}
				openings.add(op);
			}

		} else {// coupler
			for (final Object vc : bOpeningObject.mullionObjectsH) {

				if (((Profiles) vc).equals(myMullion)) {
					if (masterLeft) {
						slaveOY = ((Profiles) vc).centerYs;
					} else {
						slaveOY = ((Profiles) vc).centerYe;
					}

					((Profiles) vc).y1 = myMullion.y1 = ((Profiles) vc).y1
							+ deltaY;
					((Profiles) vc).y2 = myMullion.y2 = ((Profiles) vc).y2
							+ deltaY;
					((Profiles) vc).y4 = myMullion.y4 = ((Profiles) vc).y4
							+ deltaY;
					((Profiles) vc).y3 = myMullion.y3 = ((Profiles) vc).y3
							+ deltaY;
					((Profiles) vc).centerYs = myMullion.centerYs = ((Profiles) vc).centerYs
							+ deltaY;
					((Profiles) vc).centerYe = myMullion.centerYe = ((Profiles) vc).centerYe
							+ deltaY;
					((Profiles) vc).y1al = myMullion.y1al = ((Profiles) vc).y1al
							+ deltaY;
					((Profiles) vc).y2cl = myMullion.y2cl = ((Profiles) vc).y2cl
							+ deltaY;
					((Profiles) vc).y4al = myMullion.y4al = ((Profiles) vc).y4al
							+ deltaY;
					((Profiles) vc).y3cl = myMullion.y3cl = ((Profiles) vc).y3cl
							+ deltaY;
					alignPerformed = true;
					addMullionH.verifyLimitLR(((Profiles) vc));

					addMullionH.calcMullion = new CalculateMullionHii(
							addMullionH);

					addMullionH.newStartingYCenter = ((Profiles) vc).centerYs;

					addMullionH.newStartingYRTc = ((Profiles) vc).y2cl;

					addMullionH.newStartingYRT = ((Profiles) vc).y2;

					addMullionH.newStartingYLB = ((Profiles) vc).y1;

					addMullionH.newStartingYLBa = ((Profiles) vc).y1al;
					// addMullionH.vcEndY
					// =
					// Math.max(this.bY3,
					// bY4);
					addMullionH.calcMullion.calculateCoord(((Profiles) vc));
					bOpeningObject.mullionsH.add(vc);
				} else {
					bOpeningObject.mullionsH.add(vc);
				}
			}

			// /REORDER Mullions
			bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();
			bOpeningObject.mullionsH.clear();
			for (final Object vc2 : bOpeningObject.mullionObjectsH) {
				if (((Profiles) vc2).rowCol == slaveORC
						&& ((Profiles) vc2).exists > 1) {
					((Profiles) vc2).rowCol = newSlaveRC;

					((Profiles) vc2).y1 = myMullion.y1 = ((Profiles) vc2).y1
							+ deltaY;
					((Profiles) vc2).y2 = myMullion.y2 = ((Profiles) vc2).y2
							+ deltaY;
					((Profiles) vc2).y4 = myMullion.y4 = ((Profiles) vc2).y4
							+ deltaY;
					((Profiles) vc2).y3 = myMullion.y3 = ((Profiles) vc2).y3
							+ deltaY;
					((Profiles) vc2).centerYs = myMullion.centerYs = ((Profiles) vc2).centerYs
							+ deltaY;
					((Profiles) vc2).centerYe = myMullion.centerYe = ((Profiles) vc2).centerYe
							+ deltaY;
					((Profiles) vc2).y1al = myMullion.y1al = ((Profiles) vc2).y1al
							+ deltaY;
					((Profiles) vc2).y2cl = myMullion.y2cl = ((Profiles) vc2).y2cl
							+ deltaY;
					((Profiles) vc2).y4al = myMullion.y4al = ((Profiles) vc2).y4al
							+ deltaY;
					((Profiles) vc2).y3cl = myMullion.y3cl = ((Profiles) vc2).y3cl
							+ deltaY;
					alignPerformed = true;
					addMullionH.verifyLimitLR(((Profiles) vc2));

					addMullionH.calcMullion = new CalculateMullionHii(
							addMullionH);

					addMullionH.newStartingYCenter = ((Profiles) vc2).centerYs;

					addMullionH.newStartingYRTc = ((Profiles) vc2).y2cl;

					addMullionH.newStartingYRT = ((Profiles) vc2).y2;

					addMullionH.newStartingYLB = ((Profiles) vc2).y1;

					addMullionH.newStartingYLBa = ((Profiles) vc2).y1al;

					addMullionH.calcMullion.calculateCoord(((Profiles) vc2));

				}
				bOpeningObject.mullionsH.add(vc2);
			}

			bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
			bOpeningObject.mullions.clear();
			for (final Object hc : bOpeningObject.mullionObjectsV) {
				if (((Profiles) hc).x4 > myMullion.x2
						&& ((Profiles) hc).x3 <= myMullion.y3) {
					if (((Profiles) hc).endPos == slaveORC) {
						((Profiles) hc).endPos = newSlaveRC;
					}
					if (((Profiles) hc).endPos > slaveORC && noRowChanged) {
						((Profiles) hc).endPos = ((Profiles) hc).endPos - 1;
					}
					if (((Profiles) hc).startPos == slaveORC + 1) {
						((Profiles) hc).startPos = newSlaveRC + 1;
					}
					alignPerformed = true;
				}

				addMullion.verifyLimitLR(((Profiles) hc));

				addMullion.calcMullion = new CalculateMullionV(addMullion);

				addMullion.newStartingXCenter = ((Profiles) hc).centerXs;

				addMullion.newStartingXRTc = ((Profiles) hc).x2cl;

				addMullion.newStartingXRT = ((Profiles) hc).x2;

				addMullion.newStartingXLB = ((Profiles) hc).x1;

				addMullion.newStartingXLBa = ((Profiles) hc).x1al;
				// addMullion.vcEndX =
				// Math.max(this.bY3,
				// bY4);
				addMullion.calcMullion.calculateCoord(((Profiles) hc));
				bOpeningObject.mullions.add(hc);
			}

			final Object[] openingObjects = openings.toArray();
			openings.clear();

			for (final Object op : openingObjects) {
				if (((OpeningObject) op).startCol >= myMullion.startPos
						&& ((OpeningObject) op).endCol <= myMullion.endPos) {
					if (((OpeningObject) op).endRow == slaveORC) {
						((OpeningObject) op).endRow = newSlaveRC;
					}
					if (((OpeningObject) op).startRow >= slaveORC + 1
							&& newSlaveRC != slaveORC) {
						((OpeningObject) op).startRow = ((OpeningObject) op).startRow - 1;
						((OpeningObject) op).endRow = ((OpeningObject) op).endRow - 1;
					}
					alignPerformed = true;
				} else {
					if (noRowChanged) {
						if (((OpeningObject) op).startRow >= newMasterRC
								&& ((OpeningObject) op).startRow != 1) {
							((OpeningObject) op).startRow = ((OpeningObject) op).startRow - 1;
						}
						if (((OpeningObject) op).endRow >= newMasterRC) {
							((OpeningObject) op).endRow = ((OpeningObject) op).endRow - 1;
						}
					}
					alignPerformed = true;
				}
				openings.add(op);
			}

		}

		if (alignPerformed) {
			myFrame2.jobItem.resetGraphics();

			myFrame2.ellipses.clear();
			myFrame2.topTexts.clear();
			myFrame2.botTexts.clear();
			myFrame2.leftTexts.clear();
			myFrame2.rightTexts.clear();

			addMullion.recalcHCCoords();
			addMullion.reOrderVNotches();
			addMullionH.reOrderHMNotches();

			partObjects.clear();
			this.resetParts();

			addMullion.splitParts(null, false, false);

			if (a_levelID <= 3) {
				this.doOpenings();
				myFrame2.facetUsed.drawFrames();
			} else {
				this.doOpenings();
				bOpeningObject = myParent.doMullions(bOpeningObject);
			}

			myFrame2.modifyDims = true;
			myFrame2.resetAlign();
			myFrame2.hideAlign();
			if (myFrame2.hasGrids) {
				myFrame2.gridsPanel.bSetSelectedGrid.doClick();
			}
			myFrame2.jobItem.resetGraphics();
		} else {
			myFrame2.modifyDims = false;
			// myMainPanel.resetAlign();
			// myMainPanel.hideAlign();
			if (myFrame2.hasGrids) {
				myFrame2.gridsPanel.bSetSelectedGrid.doClick();
			}

			myFrame2.jobItem.resetGraphics();

		}
		addMullion = null;
		addMullionH = null;

		return alignPerformed;

	}

	public void doFinalModifyMullions(AddMullionV addMullion,
			AddMullionH addMullionH) throws Exception {

		myFrame2.jobItem.resetGraphics();
		// myMainPanel.myElevation.reset();
		bOpeningObject.myMullions.reset();
		bOpeningObject.myMullionsH.reset();

		myFrame2.ellipses.clear();
		myFrame2.topTexts.clear();
		myFrame2.botTexts.clear();
		myFrame2.leftTexts.clear();
		myFrame2.rightTexts.clear();
		bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
		bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();
		openings.toArray();

		addMullion.recalcHCCoords();
		addMullionH.recalcVCCoords();
		addMullionH.reOrderHMNotches();

		myFrame2.facetUsed.drawFrames();
		myFrame2.facetUsed.reDraw(true, true, null, false, false, false);

		myFrame2.facetUsed.reDrawRadioRowCol(yRows, xCols,
				myFrame2.selectedDim,
				myFrame2.jobItem.myCanvas.selectedRadioForRow,
				myFrame2.jobItem.myCanvas.selectedRadioForCol,
				myFrame2.facetUsed);
		// this.doOpenings(false);
		if (myFrame2.selectedDim <= 2) {
			myFrame2.facetUsed.reDrawTextsforRowCol(
					myFrame2.jobItem.myCanvas.selectedRadioForRow,
					myFrame2.jobItem.myCanvas.selectedRadioForCol, false,
					myFrame2.facetUsed);
		} else if (myFrame2.selectedDim >= 3 || myFrame2.selectedDim <= 9) {
			myFrame2.facetUsed.reDrawTextsforRowColOp(
					myFrame2.jobItem.myCanvas.selectedRadioForRow,
					myFrame2.jobItem.myCanvas.selectedRadioForCol,
					myFrame2.jobItem.myCanvas.selectedRadioForRowo,
					myFrame2.jobItem.myCanvas.selectedRadioForColo, false,
					myFrame2.selectedDim);
		}

		bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
		bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();
		myFrame2.modifyDims = true;
		myFrame2.facetUsed.myFrame2.resetAlign();
		myFrame2.facetUsed.myFrame2.hideAlign();
		myFrame2.jobItem.resetGraphics();
		addMullion = null;
		addMullionH = null;
	}

	public void modifyHMullionPos(final int pos) throws Exception {

		new AddMullionV(bOpeningObject, myFrame2.jobItem, myFrame2, 2);
		AddMullionH addMullionH = new AddMullionH(bOpeningObject,
				myFrame2.jobItem, myFrame2, 2);
		// if (!this.modifyDims) {
		bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();
		bOpeningObject.mullionsH.clear();

		final Object[] myLeftTexts = myFrame2.leftTexts.toArray();
		myFrame2.rightTexts.toArray();
		double deltaY = 0;
		Profiles myChangedMullion = null;
		for (final Object hc : bOpeningObject.mullionObjectsH) {
			if (pos != 99) {
				// if (((Profiles)
				// hc).startPos
				// == pos) {
				for (final Object text : myLeftTexts) {
					if (((Profiles) hc).rowCol == ((TextFieldLeft) text).endRowCol) {
						deltaY = ((TextFieldLeft) text).newPose
								- ((Profiles) hc).y2;

						((Profiles) hc).y2 = ((Profiles) hc).y2 + deltaY;
						((Profiles) hc).y1 = ((Profiles) hc).y1 + deltaY;
						((Profiles) hc).y3 = ((Profiles) hc).y3 + deltaY;
						((Profiles) hc).y4 = ((Profiles) hc).y4 + deltaY;

						((Profiles) hc).y2a = ((Profiles) hc).y2a + deltaY;
						((Profiles) hc).y1a = ((Profiles) hc).y1a + deltaY;
						((Profiles) hc).y3a = ((Profiles) hc).y3a + deltaY;
						((Profiles) hc).y4a = ((Profiles) hc).y4a + deltaY;

						((Profiles) hc).y2b = ((Profiles) hc).y2b + deltaY;
						((Profiles) hc).y1b = ((Profiles) hc).y1b + deltaY;
						((Profiles) hc).y3b = ((Profiles) hc).y3b + deltaY;
						((Profiles) hc).y4b = ((Profiles) hc).y4b + deltaY;

						((Profiles) hc).y2a3 = ((Profiles) hc).y2a3 + deltaY;
						((Profiles) hc).y1a3 = ((Profiles) hc).y1a3 + deltaY;
						((Profiles) hc).y3a3 = ((Profiles) hc).y3a3 + deltaY;
						((Profiles) hc).y4a3 = ((Profiles) hc).y4a3 + deltaY;

						((Profiles) hc).centerYs = ((Profiles) hc).centerYs
								+ deltaY;
						((Profiles) hc).centerYe = ((Profiles) hc).centerYe
								+ deltaY;
						((Profiles) hc).y1al = ((Profiles) hc).y1al + deltaY;
						((Profiles) hc).y4al = ((Profiles) hc).y4al + deltaY;
						((Profiles) hc).y2cl = ((Profiles) hc).y2cl + deltaY;
						((Profiles) hc).y3cl = ((Profiles) hc).y3cl + deltaY;
						//
						break;
					}
				}

			}
			addMullionH.posChanged = false;

			final double posY = addMullionH.getPosYverified(((Profiles) hc).y2,
					((Profiles) hc));

			if (addMullionH.posChanged) {

				deltaY = posY - ((Profiles) hc).y2;

				((Profiles) hc).y2 = ((Profiles) hc).y2 + deltaY;
				((Profiles) hc).y1 = ((Profiles) hc).y1 + deltaY;
				((Profiles) hc).y3 = ((Profiles) hc).y3 + deltaY;
				((Profiles) hc).y4 = ((Profiles) hc).y4 + deltaY;

				((Profiles) hc).y2a = ((Profiles) hc).y2a + deltaY;
				((Profiles) hc).y1a = ((Profiles) hc).y1a + deltaY;
				((Profiles) hc).y3a = ((Profiles) hc).y3a + deltaY;
				((Profiles) hc).y4a = ((Profiles) hc).y4a + deltaY;

				((Profiles) hc).y2b = ((Profiles) hc).y2b + deltaY;
				((Profiles) hc).y1b = ((Profiles) hc).y1b + deltaY;
				((Profiles) hc).y3b = ((Profiles) hc).y3b + deltaY;
				((Profiles) hc).y4b = ((Profiles) hc).y4b + deltaY;

				((Profiles) hc).y2a3 = ((Profiles) hc).y2a3 + deltaY;
				((Profiles) hc).y1a3 = ((Profiles) hc).y1a3 + deltaY;
				((Profiles) hc).y3a3 = ((Profiles) hc).y3a3 + deltaY;
				((Profiles) hc).y4a3 = ((Profiles) hc).y4a3 + deltaY;

				((Profiles) hc).centerYs = ((Profiles) hc).centerYs + deltaY;
				((Profiles) hc).centerYe = ((Profiles) hc).centerYe + deltaY;
				((Profiles) hc).y1al = ((Profiles) hc).y1al + deltaY;
				((Profiles) hc).y4al = ((Profiles) hc).y4al + deltaY;
				((Profiles) hc).y2cl = ((Profiles) hc).y2cl + deltaY;
				((Profiles) hc).y3cl = ((Profiles) hc).y3cl + deltaY;
				myChangedMullion = (Profiles) hc;

			}

			if (myChangedMullion != null
					&& ((Profiles) hc).rowCol == myChangedMullion.rowCol
					&& ((Profiles) hc).exists != myChangedMullion.exists) {
				deltaY = myChangedMullion.y2 - ((Profiles) hc).y2;
				((Profiles) hc).y2 = ((Profiles) hc).y2 + deltaY;
				((Profiles) hc).y1 = ((Profiles) hc).y1 + deltaY;
				((Profiles) hc).y3 = ((Profiles) hc).y3 + deltaY;
				((Profiles) hc).y4 = ((Profiles) hc).y4 + deltaY;

				((Profiles) hc).y2a = ((Profiles) hc).y2a + deltaY;
				((Profiles) hc).y1a = ((Profiles) hc).y1a + deltaY;
				((Profiles) hc).y3a = ((Profiles) hc).y3a + deltaY;
				((Profiles) hc).y4a = ((Profiles) hc).y4a + deltaY;

				((Profiles) hc).y2b = ((Profiles) hc).y2b + deltaY;
				((Profiles) hc).y1b = ((Profiles) hc).y1b + deltaY;
				((Profiles) hc).y3b = ((Profiles) hc).y3b + deltaY;
				((Profiles) hc).y4b = ((Profiles) hc).y4b + deltaY;

				((Profiles) hc).y2a3 = ((Profiles) hc).y2a3 + deltaY;
				((Profiles) hc).y1a3 = ((Profiles) hc).y1a3 + deltaY;
				((Profiles) hc).y3a3 = ((Profiles) hc).y3a3 + deltaY;
				((Profiles) hc).y4a3 = ((Profiles) hc).y4a3 + deltaY;

				((Profiles) hc).centerYs = ((Profiles) hc).centerYs + deltaY;
				((Profiles) hc).centerYe = ((Profiles) hc).centerYe + deltaY;
				((Profiles) hc).y1al = ((Profiles) hc).y1al + deltaY;
				((Profiles) hc).y4al = ((Profiles) hc).y4al + deltaY;
				((Profiles) hc).y2cl = ((Profiles) hc).y2cl + deltaY;
				((Profiles) hc).y3cl = ((Profiles) hc).y3cl + deltaY;
			}
			addMullionH.posChanged = false;
			//

			addMullionH.verifyLimitLR(((Profiles) hc));

			addMullionH.calcMullion = new CalculateMullionHii(addMullionH);

			addMullionH.newStartingYCenter = ((Profiles) hc).centerYs;

			addMullionH.newStartingYRTc = ((Profiles) hc).y2cl;

			addMullionH.newStartingYRT = ((Profiles) hc).y2;

			addMullionH.newStartingYLB = ((Profiles) hc).y1;

			addMullionH.newStartingYLBa = ((Profiles) hc).y1al;
			// addMullion.vcEndX =
			// Math.max(this.bY3,
			// bY4);
			addMullionH.calcMullion.calculateCoord(((Profiles) hc));
			// ((Profiles) hc).x1a =
			// ((Profiles) hc).x1;
			// ((Profiles) hc).y1a =
			// ((Profiles) hc).y1;
			// ((Profiles) hc).x2a =
			// ((Profiles) hc).x2;
			// ((Profiles) hc).y2a =
			// ((Profiles) hc).y2;
			// ((Profiles) hc).x3a =
			// ((Profiles) hc).x3;
			// ((Profiles) hc).y3a =
			// ((Profiles) hc).y3;
			// ((Profiles) hc).x4a =
			// ((Profiles) hc).x4;
			// ((Profiles) hc).y4a =
			// ((Profiles) hc).y4;
			bOpeningObject.mullionsH.add(hc);
			openings.toArray();
			bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
			bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();

		}

		addMullionH.recalcVCCoords();
		addMullionH.reOrderHMNotches();

		this.doOpenings();
		this.doMullions(this.bOpeningObject);
		addMullionH = null;
	}

	// /////////////////////////////////////////////
	// ////////////////////////////////////////////

	// /////////OVERALL METHODS////////////////////

	public void modifyHMullionPosGlass(final int pos) throws Exception {

		new AddMullionV(bOpeningObject, myFrame2.jobItem, myFrame2, 2);
		AddMullionH addMullionH = new AddMullionH(bOpeningObject,
				myFrame2.jobItem, myFrame2, 2);
		// if (!this.modifyDims) {
		bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();
		bOpeningObject.mullionsH.clear();

		final Object[] myLeftTexts = myFrame2.leftTexts.toArray();
		myFrame2.rightTexts.toArray();
		double deltaY = 0;
		Profiles myChangedMullion = null;

		double y1 = 0;
		double y1al = 0;
		double y2 = 0;
		double y2cl = 0;
		double yc = 0;

		double y4 = 0;
		double y4al = 0;
		double y3 = 0;
		double y3cl = 0;
		double ye = 0;

		for (final Object hc : bOpeningObject.mullionObjectsH) {
			if (pos != 99) {
				// if (((Profiles)
				// hc).startPos
				// == pos) {
				for (final Object text : myLeftTexts) {
					if (((Profiles) hc).rowCol == ((TextFieldLeft) text).rowNo) {
						y1 = ((Profiles) hc).y1 - ((TextFieldLeft) text).pose;

						y1al = ((Profiles) hc).y1al
								- ((TextFieldLeft) text).pose;

						y2 = ((Profiles) hc).y2 - ((TextFieldLeft) text).pose;

						y2cl = ((Profiles) hc).y2cl
								- ((TextFieldLeft) text).pose;

						yc = ((Profiles) hc).centerYs
								- ((TextFieldLeft) text).pose;

						y4 = ((Profiles) hc).y4 - ((TextFieldLeft) text).pose;

						y4al = ((Profiles) hc).y4al
								- ((TextFieldLeft) text).pose;

						y3 = ((Profiles) hc).y3 - ((TextFieldLeft) text).pose;

						y3cl = ((Profiles) hc).y3cl
								- ((TextFieldLeft) text).pose;

						ye = ((Profiles) hc).centerYe
								- ((TextFieldLeft) text).pose;

						((Profiles) hc).y1 = ((TextFieldLeft) text).newPose
								+ y1;

						((Profiles) hc).y2 = ((TextFieldLeft) text).newPose
								+ y2;

						((Profiles) hc).centerYs = ((TextFieldLeft) text).newPose
								+ yc;

						((Profiles) hc).y4 = ((TextFieldLeft) text).newPose
								+ y4;

						((Profiles) hc).y3 = ((TextFieldLeft) text).newPose
								+ y3;

						((Profiles) hc).centerYe = ((TextFieldLeft) text).newPose
								+ ye;

						((Profiles) hc).y1al = ((TextFieldLeft) text).newPose
								+ y1al;

						((Profiles) hc).y2cl = ((TextFieldLeft) text).newPose
								+ y2cl;

						((Profiles) hc).y4al = ((TextFieldLeft) text).newPose
								+ y4al;

						((Profiles) hc).y3cl = ((TextFieldLeft) text).newPose
								+ y3cl;
						//
						break;
					}
				}

			}
			addMullionH.posChanged = false;

			final double posY = addMullionH.getPosYverified(((Profiles) hc).y2,
					((Profiles) hc));

			if (addMullionH.posChanged) {

				deltaY = posY - ((Profiles) hc).y2;
				((Profiles) hc).y2 = ((Profiles) hc).y2 + deltaY;
				((Profiles) hc).y1 = ((Profiles) hc).y1 + deltaY;
				((Profiles) hc).y3 = ((Profiles) hc).y3 + deltaY;
				((Profiles) hc).y4 = ((Profiles) hc).y4 + deltaY;
				((Profiles) hc).centerYs = ((Profiles) hc).centerYs + deltaY;
				((Profiles) hc).centerYe = ((Profiles) hc).centerYe + deltaY;
				((Profiles) hc).y1al = ((Profiles) hc).y1al + deltaY;
				((Profiles) hc).y4al = ((Profiles) hc).y4al + deltaY;
				((Profiles) hc).y2cl = ((Profiles) hc).y2cl + deltaY;
				((Profiles) hc).y3cl = ((Profiles) hc).y3cl + deltaY;
				myChangedMullion = (Profiles) hc;

			}

			if (myChangedMullion != null
					&& ((Profiles) hc).rowCol == myChangedMullion.rowCol
					&& ((Profiles) hc).exists != myChangedMullion.exists) {
				deltaY = myChangedMullion.y2 - ((Profiles) hc).y2;
				((Profiles) hc).y2 = ((Profiles) hc).y2 + deltaY;
				((Profiles) hc).y1 = ((Profiles) hc).y1 + deltaY;
				((Profiles) hc).y3 = ((Profiles) hc).y3 + deltaY;
				((Profiles) hc).y4 = ((Profiles) hc).y4 + deltaY;
				((Profiles) hc).centerYs = ((Profiles) hc).centerYs + deltaY;
				((Profiles) hc).centerYe = ((Profiles) hc).centerYe + deltaY;
				((Profiles) hc).y1al = ((Profiles) hc).y1al + deltaY;
				((Profiles) hc).y4al = ((Profiles) hc).y4al + deltaY;
				((Profiles) hc).y2cl = ((Profiles) hc).y2cl + deltaY;
				((Profiles) hc).y3cl = ((Profiles) hc).y3cl + deltaY;
			}
			addMullionH.posChanged = false;
			//

			addMullionH.verifyLimitLR(((Profiles) hc));

			addMullionH.calcMullion = new CalculateMullionHii(addMullionH);

			addMullionH.newStartingYCenter = ((Profiles) hc).centerYs;

			addMullionH.newStartingYRTc = ((Profiles) hc).y2cl;

			addMullionH.newStartingYRT = ((Profiles) hc).y2;

			addMullionH.newStartingYLB = ((Profiles) hc).y1;

			addMullionH.newStartingYLBa = ((Profiles) hc).y1al;
			// addMullion.vcEndX =
			// Math.max(this.bY3,
			// bY4);
			addMullionH.calcMullion.calculateCoord(((Profiles) hc));
			// ((Profiles) hc).x1a =
			// ((Profiles) hc).x1;
			// ((Profiles) hc).y1a =
			// ((Profiles) hc).y1;
			// ((Profiles) hc).x2a =
			// ((Profiles) hc).x2;
			// ((Profiles) hc).y2a =
			// ((Profiles) hc).y2;
			// ((Profiles) hc).x3a =
			// ((Profiles) hc).x3;
			// ((Profiles) hc).y3a =
			// ((Profiles) hc).y3;
			// ((Profiles) hc).x4a =
			// ((Profiles) hc).x4;
			// ((Profiles) hc).y4a =
			// ((Profiles) hc).y4;
			bOpeningObject.mullionsH.add(hc);
			openings.toArray();
			bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
			bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();

		}

		addMullionH.recalcVCCoords();
		addMullionH.reOrderHMNotches();

		this.doOpenings();
		addMullionH = null;
	}

	public void doOverallChange(final int myShape, final boolean doOpenings)
			throws Exception {

		shapeChanged = true;
		frameShapeChanged = false;
		final Object[] myFrames = frames.toArray();
		frames.clear();

		for (final Object F : myFrames) {
			if (((Frame) F).shapeID != 10) {
				((Frame) F).shapeChanged = true;
			} else {
				((Frame) F).shapeChanged = false;
				((Frame) F).shapeID = 10;
			}
			((Frame) F).isNewFrame = true;
			frames.add(F);
		}

		shapeID = myShape;

		bOpeningObject.myParent.setLeanTo(bOpeningObject.lean,
				bOpeningObject.lean2, bOpeningObject.lean3,
				bOpeningObject.lean4);

		bOpeningObject.setLeanTo(bOpeningObject.lean, bOpeningObject.lean2,
				bOpeningObject.lean3, bOpeningObject.lean4);

		bOpeningObject.myParent.setDimABCDFromShapeChange(bOpeningObject.dimA1,
				bOpeningObject.dimA2, bOpeningObject.dimA3,
				bOpeningObject.dimA4, bOpeningObject.dimA5,
				bOpeningObject.dimA0, bOpeningObject.dimB1,
				bOpeningObject.dimB2, bOpeningObject.dimB3,
				bOpeningObject.dimB4, bOpeningObject.dimB5,
				bOpeningObject.dimB0, bOpeningObject.dimC1,
				bOpeningObject.dimC2, bOpeningObject.dimC3,
				bOpeningObject.dimC4, bOpeningObject.dimC5,
				bOpeningObject.dimC0, bOpeningObject.dimD1,
				bOpeningObject.dimD2, bOpeningObject.dimD3,
				bOpeningObject.dimD4, bOpeningObject.dimD5,
				bOpeningObject.dimD0);

		((Facet) bOpeningObject.myParent).widthPix =

		myFrame2.jobItem.design_flat_WIDTHpix;

		((Facet) bOpeningObject.myParent).heightPix =

		myFrame2.jobItem._HEIGHTpix;

		if (shapeID > 10 && shapeID < 100 || shapeID >= 800) {
			((Facet) bOpeningObject.myParent).widthPix =

			myFrame2.jobItem.design_flat_WIDTHpix = bOpeningObject.widthPix;

			((Facet) bOpeningObject.myParent).heightPix =

			myFrame2.jobItem._HEIGHTpix = bOpeningObject.heightPix;
		}

		((Facet) bOpeningObject.myParent).createSideShapes(false, true,
				myFrame2.scale);

		((Facet) bOpeningObject.myParent).setBAandA();

		bOpeningObject.myParent.doMainOpening();

		((Facet) bOpeningObject.myParent)
				.setNumSides(((Facet) bOpeningObject.myParent).shapeID);

		((Facet) bOpeningObject.myParent).myFacet = bOpeningObject.myParent;

		if (bOpeningObject.myParent.bOpeningObject.mullions.size() > 0
				|| bOpeningObject.myParent.bOpeningObject.mullionsH.size() > 0) {
			final AddMullionV changeMullion = new AddMullionV(bOpeningObject,
					bOpeningObject.myParent.myFrame2.jobItem,
					bOpeningObject.myParent.myFrame2, 1);

			final AddMullionH changeMullionH = new AddMullionH(bOpeningObject,
					bOpeningObject.myParent.myFrame2.jobItem,
					bOpeningObject.myParent.myFrame2, 1);

			changeMullion.doChangeMullionsV(doOpenings, false);
			changeMullionH.doChangeMullionsH(doOpenings, false);

			if (!doOpenings) {
				doOpenings();
			}
		} else {
			// bOpeningObject.myParent.doOpenings(false);
		}

	}

	public void setBAandA() {

		if (top1.startXBA > 0) {
			top1.startingX = top1.startingXA = top1.startingXBA;
			top1.startingY = top1.startingYA = top1.startingYBA;
			top1.startX = top1.startXA = top1.startXBA;
			top1.startY = top1.startYA = top1.startYBA;
			top1.endX = top1.endXA = top1.endXBA;
			top1.endY = top1.endYA = top1.endYBA;

			top1.startAngle = top1.startAngleA = top1.startAngleBA;
			top1.endAngle = top1.endAngleA = top1.endAngleBA;

			top1.radius1 = top1.radius1A = top1.radius1BA;
			top1.radius2 = top1.radius2A = top1.radius2BA;

			top1.bkgrdStartX = top1.bkgrdStartXA = top1.bkgrdStartXBA;
			top1.bkgrdStartY = top1.bkgrdStartYA = top1.bkgrdStartYBA;

			top2.startX = top2.startXA = top2.startXBA;
			top2.startY = top2.startYA = top2.startYBA;
			top2.endX = top2.endXA = top2.endXBA;
			top2.endY = top2.endYA = top2.endYBA;

			top2.startAngle = top2.startAngleA = top2.startAngleBA;
			top2.endAngle = top2.endAngleA = top2.endAngleBA;

			top2.radius1 = top2.radius1A = top2.radius1BA;
			top2.radius2 = top2.radius2A = top2.radius2BA;

			top2.bkgrdStartX = top2.bkgrdStartXA = top2.bkgrdStartXBA;
			top2.bkgrdStartY = top2.bkgrdStartYA = top2.bkgrdStartYBA;

			top3.startX = top3.startXA = top3.startXBA;
			top3.startY = top3.startYA = top3.startYBA;
			top3.endX = top3.endXA = top3.endXBA;
			top3.endY = top3.endYA = top3.endYBA;

			bot1.startX = bot1.startXA = bot1.startXBA;
			bot1.startY = bot1.startYA = bot1.startYBA;
			bot1.endX = bot1.endXA = bot1.endXBA;
			bot1.endY = bot1.endYA = bot1.endYBA;

			bot1.startAngle = bot1.startAngleA = bot1.startAngleBA;
			bot1.endAngle = bot1.endAngleA = bot1.endAngleBA;

			bot1.radius1 = bot1.radius1A = bot1.radius1BA;
			bot1.radius2 = bot1.radius2A = bot1.radius2BA;

			bot1.bkgrdStartX = bot1.bkgrdStartXA = bot1.bkgrdStartXBA;
			bot1.bkgrdStartY = bot1.bkgrdStartYA = bot1.bkgrdStartYBA;

			bot2.startX = bot2.startXA = bot2.startXBA;
			bot2.startY = bot2.startYA = bot2.startYBA;
			bot2.endX = bot2.endXA = bot2.endXBA;
			bot2.endY = bot2.endYA = bot2.endYBA;

			bot2.startAngle = bot2.startAngleA = bot2.startAngleBA;
			bot2.endAngle = bot2.endAngleA = bot2.endAngleBA;

			bot2.radius1 = bot2.radius1A = bot2.radius1BA;
			bot2.radius2 = bot2.radius2A = bot2.radius2BA;

			bot2.bkgrdStartX = bot2.bkgrdStartXA = bot2.bkgrdStartXBA;
			bot2.bkgrdStartY = bot2.bkgrdStartYA = bot2.bkgrdStartYBA;

			bot3.startX = bot3.startXA = bot3.startXBA;
			bot3.startY = bot3.startYA = bot3.startYBA;
			bot3.endX = bot3.endXA = bot3.endXBA;
			bot3.endY = bot3.endYA = bot3.endYBA;

			bot3.startAngle = bot3.startAngleA = bot3.startAngleBA;
			bot3.endAngle = bot3.endAngleA = bot3.endAngleBA;

			bot3.radius1 = bot3.radius1A = bot3.radius1BA;
			bot3.radius2 = bot3.radius2A = bot3.radius2BA;

			bot3.bkgrdStartX = bot3.bkgrdStartXA = bot3.bkgrdStartXBA;
			bot3.bkgrdStartY = bot3.bkgrdStartYA = bot3.bkgrdStartYBA;

			left.startX = left.startXA = left.startXBA;
			left.startY = left.startYA = left.startYBA;
			left.endX = left.endXA = left.endXBA;
			left.endY = left.endYA = left.endYBA;

			right.startX = right.startXA = right.startXBA;
			right.startY = right.startYA = right.startYBA;
			right.endX = right.endXA = right.endXBA;
			right.endY = right.endYA = right.endYBA;

		} else {
			top1.startingXBA = top1.startingXA = top1.startingX;
			top1.startingYBA = top1.startingYA = top1.startingY;
			top1.startXBA = top1.startXA = top1.startX;
			top1.startYBA = top1.startYA = top1.startY;
			top1.endXBA = top1.endXA = top1.endX;
			top1.endYBA = top1.endYA = top1.endY;

			top1.startAngleBA = top1.startAngleA = top1.startAngle;
			top1.endAngleBA = top1.endAngleA = top1.endAngle;

			top1.radius1BA = top1.radius1A = top1.radius1;
			top1.radius2BA = top1.radius2A = top1.radius2;

			top1.bkgrdStartXBA = top1.bkgrdStartXA = top1.bkgrdStartX;
			top1.bkgrdStartYBA = top1.bkgrdStartYA = top1.bkgrdStartY;

			top2.startXBA = top2.startXA = top2.startX;
			top2.startYBA = top2.startYA = top2.startY;
			top2.endXBA = top2.endXA = top2.endX;
			top2.endYBA = top2.endYA = top2.endY;

			top2.startAngleBA = top2.startAngleA = top2.startAngle;
			top2.endAngleBA = top2.endAngleA = top2.endAngle;

			top2.radius1BA = top2.radius1A = top2.radius1;
			top2.radius2BA = top2.radius2A = top2.radius2;

			top2.bkgrdStartXBA = top2.bkgrdStartXA = top2.bkgrdStartX;
			top2.bkgrdStartYBA = top2.bkgrdStartYA = top2.bkgrdStartY;

			top3.startXBA = top3.startXA = top3.startX;
			top3.startYBA = top3.startYA = top3.startY;
			top3.endXBA = top3.endXA = top3.endX;
			top3.endYBA = top3.endYA = top3.endY;

			bot1.startXBA = bot1.startXA = bot1.startX;
			bot1.startYBA = bot1.startYA = bot1.startY;
			bot1.endXBA = bot1.endXA = bot1.endX;
			bot1.endYBA = bot1.endYA = bot1.endY;

			bot1.startAngleBA = bot1.startAngleA = bot1.startAngle;
			bot1.endAngleBA = bot1.endAngleA = bot1.endAngle;

			bot1.radius1BA = bot1.radius1A = bot1.radius1;
			bot1.radius2BA = bot1.radius2A = bot1.radius2;

			bot1.bkgrdStartXBA = bot1.bkgrdStartXA = bot1.bkgrdStartX;
			bot1.bkgrdStartYBA = bot1.bkgrdStartYA = bot1.bkgrdStartY;

			bot2.startXBA = bot2.startXA = bot2.startX;
			bot2.startYBA = bot2.startYA = bot2.startY;
			bot2.endXBA = bot2.endXA = bot2.endX;
			bot2.endYBA = bot2.endYA = bot2.endY;

			bot2.startAngleBA = bot2.startAngleA = bot2.startAngle;
			bot2.endAngleBA = bot2.endAngleA = bot2.endAngle;

			bot2.radius1BA = bot2.radius1A = bot2.radius1;
			bot2.radius2BA = bot2.radius2A = bot2.radius2;

			bot2.bkgrdStartXBA = bot2.bkgrdStartXA = bot2.bkgrdStartX;
			bot2.bkgrdStartYBA = bot2.bkgrdStartYA = bot2.bkgrdStartY;

			bot3.startXBA = bot3.startXA = bot3.startX;
			bot3.startYBA = bot3.startYA = bot3.startY;
			bot3.endXBA = bot3.endXA = bot3.endX;
			bot3.endYBA = bot3.endYA = bot3.endY;

			bot3.startAngleBA = bot3.startAngleA = bot3.startAngle;
			bot3.endAngleBA = bot3.endAngleA = bot3.endAngle;

			bot3.radius1BA = bot3.radius1A = bot3.radius1;
			bot3.radius2BA = bot3.radius2A = bot3.radius2;

			bot3.bkgrdStartXBA = bot3.bkgrdStartXA = bot3.bkgrdStartX;
			bot3.bkgrdStartYBA = bot3.bkgrdStartYA = bot3.bkgrdStartY;

			left.startXBA = left.startXA = left.startX;
			left.startYBA = left.startYA = left.startY;
			left.endXBA = left.endXA = left.endX;
			left.endYBA = left.endYA = left.endY;

			right.startXBA = right.startXA = right.startX;
			right.startYBA = right.startYA = right.startY;
			right.endXBA = right.endXA = right.endX;
			right.endYBA = right.endYA = right.endY;
		}

		// //////////////////////////////////////

		if (this.shapeID >= 800) {
			top1.bkgrdWidth = top1.endX - top1.startX;
			top1.bkgrdWidthBA = top1.endXBA - top1.startXBA;
			top1.bkgrdWidthA = top1.endXA - top1.startXA;
		}

		top1.bkgrdWidth = top1.endX - top1.startX;
		top1.bkgrdWidthBA = top1.endXBA - top1.startXBA;
		top1.bkgrdWidthA = top1.endXA - top1.startXA;

		top1.bkgrdHeight = lowestY - highestY;
		top1.bkgrdHeightBA = lowestY - highestY
				- (top1.partDimB + bot1.partDimB);
		top1.bkgrdHeightA = lowestY - highestY
				- (top1.partDimB + bot1.partDimB)
				- (top1.partDimA + bot1.partDimA);

		this.setProfilesFromPartObjects();
	}

	public Collection cloneCollections(final Collection original) {

		final Collection newc = new ArrayList();
		final Object[] rmp = original.toArray();
		for (final Object v : rmp) {
			newc.add(v);
		}
		return newc;
	}

	public Object[] cloneObjects(final Object[] original) {

		final Object[] newc = original.clone();
		return newc;
	}

	/**
	 * Init Overall ShapeObject
	 * 
	 * @param w
	 *            , Width size
	 * @param h
	 *            , Height size
	 * @param uom
	 *            , Unit of metric
	 */
	public void initOverall(double w, double h, int uom) throws Exception {

		// Columns for axis X and Y
		xCols = 1;
		yRows = 1;

		// Starting columns and rows
		startCol = endCol = startRow = endRow = 1;

		// Unit of Metric basic
		baseUOM = uom;

		if (myFrame2.myTopPanel.metric.isSelected()) {
			levelW = widthPix = w;
			levelH = heightPix = h;
		} else {
			levelW = widthPix = w;
			levelH = heightPix = h;
		}

		bX2 = bCX2 = startingX + widthPix;
		bY2 = bCY2 = startingY;
		bX3 = bCX3 = bX2;
		bY3 = bCY3 = startingY + heightPix;
		bX4 = bCX4 = startingX;
		bY4 = bCY4 = bY3;
		startingCX = startingX;
		startingCY = startingY;
		lowestY = lowestYC = Math.max(bY4, bY3);
		highestY = highestYC = Math.min(startingY, bY2);

		// Creating side shapes
		this.createSideShapes(false, false, scaleM);

		this.setBAandA();
		// Doing bkgrdOpening object
		// myFrame2.doOptions = false;
		bOpeningObject = this.doMainOpening();

		startingCX = bOpeningObject.startingCX = bOpeningObject.startingX;
		startingCY = bOpeningObject.startingCY = bOpeningObject.startingY;

		bCX2 = bOpeningObject.bCX2 = bX2;
		bCY2 = bOpeningObject.bCY2 = bY2;
		bCX3 = bOpeningObject.bCX3 = bX3;
		bCY3 = bOpeningObject.bCY3 = bY3;
		bCX4 = bOpeningObject.bCX4 = bX4;
		bCY4 = bOpeningObject.bCY4 = bY4;

		this.setNumSides(shapeID);

		new SetLeanTo(this);

		/**
		 * 
		 * Execute Rules:
		 * 
		 * Options, Parts
		 * 
		 */

		this.myFrame2.jobItem.design.options.clear();

		options.clear();

		this.myFrame2.executePartRules.setParentAssembly = 0;
		this.myFrame2.executePartRules.setAssembly = 0;
		this.myFrame2.executePartRules.setColorid = 0;
		this.myFrame2.executePartRules.setColorAbbrev = "";
		this.myFrame2.executePartRules.setColorAnswer = null;

		options.clear();
		myFrame2.doOptions = true;
		executeOptionRules("shapeObject.initOverall.13651");

		// **************************************************************************************
		// Execute Part Rules
		// **************************************************************************************
		this.myFrame2.executePartRules.resetExecutionValues();

		executePartRules(true, true, "shapeObject.initOverall.13653");
		executePartRules(true);

		this.doCouplers();

		this.doFacets(false, false, true, false);
		this.drawFacets();

		this.myFrame2.options.buildOptionsTables();
	}

	public void executeOptionRules(String from) {
		myFrame2.cleanColorList();
		this.myFrame2.executePartRules.executeOptionRules(this, null, null,
				this.a_assemblyLevel, from);
		// myFrame2.jobItem.design.loadOptionsAll();
		// myFrame2.resetAllOptionsFromDesignOptions();
		// boolean dd = false;
	}

	/**
	 * Set ShapeObject Clearances
	 */
	public void executeClearanceRules() {

		Object[] clearances = new Object[8];
		clearances[0] = 0;
		clearances[1] = 0;
		clearances[2] = 0;
		clearances[3] = 0;
		clearances[4] = 0;
		clearances[5] = 0;
		clearances[6] = 0;
		clearances[7] = 0;

		clearances = this.myFrame2.executePartRules.executeClearanceRules(this,
				null, null);

		double ct = 0.0;
		double cb = 0.0;
		double cl = 0.0;
		double cr = 0.0;

		if (myFrame2.mySeries.getSeriesUom() == 1) {

			ct = (new BigDecimal(((Integer) clearances[0])).multiply(
					myFrame2.metricscale).setScale(20, BigDecimal.ROUND_UP)
					.doubleValue());

			cb = (new BigDecimal(((Integer) clearances[2])).multiply(
					myFrame2.metricscale).setScale(20, BigDecimal.ROUND_UP)
					.doubleValue());

			cl = (new BigDecimal(((Integer) clearances[4])).multiply(
					myFrame2.metricscale).setScale(20, BigDecimal.ROUND_UP)
					.doubleValue());

			cr = (new BigDecimal(((Integer) clearances[6])).multiply(
					myFrame2.metricscale).setScale(20, BigDecimal.ROUND_UP)
					.doubleValue());

		} else {
			ct = (new BigDecimal(((Integer) clearances[1])).multiply(
					myFrame2.imperialscale).setScale(20, BigDecimal.ROUND_UP)
					.doubleValue());
			cb = (new BigDecimal(((Integer) clearances[3])).multiply(
					myFrame2.imperialscale).setScale(20, BigDecimal.ROUND_UP)
					.doubleValue());
			cl = (new BigDecimal(((Integer) clearances[5])).multiply(
					myFrame2.imperialscale).setScale(20, BigDecimal.ROUND_UP)
					.doubleValue());
			cr = (new BigDecimal(((Integer) clearances[7])).multiply(
					myFrame2.imperialscale).setScale(20, BigDecimal.ROUND_UP)
					.doubleValue());
		}

		// if (ct != 0)
		// {
		this.clearanceTop = ct;
		// }
		// if (cb != 0)
		// {
		this.clearanceBot = cb;
		// }
		// if (cl != 0)
		// {
		this.clearanceLeft = cl;
		// }
		// if (cr != 0)
		// {
		this.clearanceRight = cr;
		// }
	}

	/**
	 * Execute Rules for Shape
	 */
	public void executePartRules(boolean doErrors, boolean doAll, String form) {

		// Clean Error and Warning for Shape
		bom.clear();
		clearBomForShape();

		myFrame2.buildErrorList();
		myFrame2.initInfoList();
	}

	/**
	 * Execute Part Rules for Shape
	 * 
	 * @param rule
	 *            , Rules
	 */
	public void executePartRules(Rules rule, boolean doBom) {
		// Execute Part Rules
		myFrame2.cleanColorList();
		this.myFrame2.executePartRules
				.executePartRules(rule, this, null, doBom);
	}

	/**
	 * Execute Part Rules for Shape
	 */
	public void executePartRules(boolean doBom) {

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// Get All part Rules
		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		List<Rules> rules;
		if (doBom) {
			rules = this.myFrame2.executePartRules.getAllpartRules(ItemFrame
					.getApplicationBaseRules().getRulesShapeObject(
							ItemFrame.seriesID, this));
		} else {
			rules = this.myFrame2.executePartRules.getPartRules(ItemFrame
					.getApplicationBaseRules().getRulesShapeObject(
							ItemFrame.seriesID, this));
		}

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// Get All Rule-Segments Rules
		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		int i = 1;

		Map<Integer, SeriesSegmentExec> subSegments = new HashMap<Integer, SeriesSegmentExec>();

		List<Rules> mRules = new ArrayList<Rules>();
		mRules.addAll(rules);
		rules.clear();

		for (Rules rule : mRules) {
			boolean passLocalTest = this.myFrame2.executePartRules
					.filterArraysAndTest(rule, ItemFrame
							.getApplicationBaseRules().getRuleAnswers(),
							ItemFrame.getApplicationBaseRules()
									.getRuleTestByRuleNo(rule),
							ItemFrame.seriesID);
			if (rule.getRuletype() == 9) {

				if (passLocalTest) {
					if (!subSegments.containsKey(rule.getRulevalue())) {
						SeriesSegmentExec seriesSegment = new SeriesSegmentExec(
								rule.getRulevalue(), rule.getSupplierId(),
								rule.isRemote());
						subSegments.put(i++, seriesSegment);
					}
				}

			} else {
				if (passLocalTest) {
					rules.add(rule);
				}
			}
		}

		rules = ItemFrame.getApplicationBaseRules().addSubRules(rules,
				subSegments, this);

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// Get All Rule-Segments Rules
		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		Object[] rs = rules.toArray();
		rules.clear();

		/*
		 * Change: used to be testing == this.a_levelID which was wrong...
		 * changed by sherif --- Apr 17.2014
		 */

		for (Object r : rs) {
			if (doBom) {
				if (((Rules) r).getAssemblyID() == this.a_assemblyLevel) { // a_levelID
					rules.add((Rules) r);
				}
			} else {
				if (((Rules) r).getAssemblyID() == a_assemblyLevel
						&& (((Rules) r).getRuletype() == 11 || ((Rules) r)
								.getAffectsdesign())) {
					rules.add((Rules) r);
				}
			}
		}

		// Clean Error and Warning for Shape
		this.myFrame2.cleanColorList();

		for (Rules rule : rules) {
			// Execute Part Rules
			this.myFrame2.executePartRules.executePartRules(rule, this, null,
					doBom);
		}
	}

	/**
	 * Init open overall design for editing drawing
	 * 
	 * @param w
	 *            , Width size
	 * @param h
	 *            , Height size
	 */
	public void initOpenOverall(double w, double h) throws Exception {

		// ***********************************************************
		// Initialize profileDTO
		// ***********************************************************
		ProfileDTO profileDTO = new ProfileDTO();

		// ***********************************************************
		// Creating side shapes
		// ***********************************************************
		this.createSideShapes(false, false, scaleM);

		// ***********************************************************
		// Initialize partObjects
		// ***********************************************************
		this.top1 = (Top1Object) profileDTO.profilesClone(this.top1,
				this.top1Part);
		this.top2 = (Top2Object) profileDTO.profilesClone(this.top2,
				this.top2Part);
		this.top3 = (Top3Object) profileDTO.profilesClone(this.top3,
				this.top3Part);
		this.left = (LeftObject) profileDTO.profilesClone(this.left,
				this.leftPart);
		this.right = (RightObject) profileDTO.profilesClone(this.right,
				this.rightPart);
		this.bot1 = (Bot1Object) profileDTO.profilesClone(this.bot1,
				this.bot1Part);
		this.bot2 = (Bot2Object) profileDTO.profilesClone(this.bot2,
				this.bot2Part);
		this.bot3 = (Bot3Object) profileDTO.profilesClone(this.bot3,
				this.bot3Part);

		// ***********************************************************
		// Initialize BkgrdOpening objects
		// ***********************************************************
		CreateOpenings createOpening = new CreateOpenings(this, myFrame2);
		bOpeningObject = createOpenings.doOpenMainOpening();

		startingCX = bOpeningObject.startingCX = bOpeningObject.startingX;
		startingCY = bOpeningObject.startingCY = bOpeningObject.startingY;

		bCX2 = bOpeningObject.bCX2 = bX2;
		bCY2 = bOpeningObject.bCY2 = bY2;
		bCX3 = bOpeningObject.bCX3 = bX3;
		bCY3 = bOpeningObject.bCY3 = bY3;
		bCX4 = bOpeningObject.bCX4 = bX4;
		bCY4 = bOpeningObject.bCY4 = bY4;

		this.setNumSides(shapeID);

		new SetLeanTo(this);

		this.doCouplers();

		this.doFacets(false, false, true, false);

		this.drawFacets();

		myFrame2.options.buildOptionsTables();
	}

	public Facet initFacet(final double w, final double h, final int uom,
			final double sX, final double sY) throws Exception {

		final Facet myFacet = new Facet(myFrame2, myFrame2.jobItem, 1,
				myFrame2.jobItem.rID, 0);

		myFacet.xCols = 1;
		myFacet.yRows = 1;
		myFacet.startCol = myFacet.endCol = myFacet.startRow = myFacet.endRow = 1;

		myFacet.baseUOM = uom;
		if (myFrame2.myTopPanel.metric.isSelected()) {
			myFacet.levelW = myFacet.widthPix = w;
			myFacet.levelH = myFacet.heightPix = h;
		} else {
			myFacet.levelW = myFacet.widthPix = w;
			myFacet.levelH = myFacet.heightPix = h;
		}

		myFacet.bX2 = myFacet.bCX2 = sX + w;
		myFacet.bY2 = myFacet.bCY2 = sY;
		myFacet.bX3 = myFacet.bCX3 = myFacet.bX2;
		myFacet.bY3 = myFacet.bCY3 = sY + h;
		myFacet.bX4 = myFacet.bCX4 = sX;
		myFacet.bY4 = myFacet.bCY4 = myFacet.bY3;
		myFacet.startingCX = sX;
		myFacet.startingCY = sY;
		myFacet.lowestY = Math.max(myFacet.bY4, myFacet.bY3);
		this.createSideShapes(false, false, scaleM);

		myFacet.setBAandA();

		myFacet.doMainOpening();

		myFacet.startingCX = myFacet.bOpeningObject.startingCX = myFacet.bOpeningObject.startingX;
		myFacet.startingCY = myFacet.bOpeningObject.startingCY = myFacet.bOpeningObject.startingY;

		myFacet.bCX2 = myFacet.bOpeningObject.bCX2 = myFacet.bX2;
		myFacet.bCY2 = myFacet.bOpeningObject.bCY2 = myFacet.bY2;
		myFacet.bCX3 = myFacet.bOpeningObject.bCX3 = myFacet.bX3;
		myFacet.bCY3 = myFacet.bOpeningObject.bCY3 = myFacet.bY3;
		myFacet.bCX4 = myFacet.bOpeningObject.bCX4 = myFacet.bX4;
		myFacet.bCY4 = myFacet.bOpeningObject.bCY4 = myFacet.bY4;

		new ShapeLeanToLocal(myFacet);

		myFacet.setNumSides(shapeID);
		new SetLeanTo(myFacet);

		myFacet.doCouplers();

		myFacet.doFrames(false, false, true, true);
		myFacet.drawFrames();

		return myFacet;

	}

	public void initOverallSize(double w, double h, double ow, double oh,
			ShapeObject newOverall, int dimChange, boolean sameDims)
			throws Exception {

		if (!sameDims) {
			startCol = endCol = startRow = endRow = 1;

			if (myFrame2.myTopPanel.metric.isSelected()) {
				levelW = widthPix = w;
				levelH = heightPix = h;
			} else {
				levelW = widthPix = w;
				levelH = heightPix = h;
			}

			bX2 = bCX2 = startingX + widthPix;
			bY2 = bCY2 = startingY;
			bX3 = bCX3 = bX2;
			bY3 = bCY3 = startingY + heightPix;
			bX4 = bCX4 = startingX;
			bY4 = bCY4 = bY3;
			startingCX = startingX;
			startingCY = startingY;

			lowestY = lowestYC = Math.max(bY4, bY3);
			highestY = highestYC = Math.min(startingY, bY2);

			this.createSideShapes(false, false, myFrame2.scale);

			this.setBAandA();

			this.doMainOpening();

			setDimsChange(w, h);

			if (!myFrame2.changeFacetW) {
				modifyVDividerPosEqualize();

			} else {
				modifyVDividerPosChangeW();

			}

			this.bOpeningObject = this.doMullions(bOpeningObject);

			if (!myFrame2.mullionsPanel.divideFacet) {
				final Object[] oo = openings.toArray();
				openings.clear();

				for (final Object O : oo) {
					if (myFrame2.facetUsed != null
							&& ((OpeningObject) O).startCol == myFrame2.facetUsed.startCol) {

						((OpeningObject) O).originalScaleM = myFrame2.metricscale;
						((OpeningObject) O).originalScaleI = myFrame2.imperialscale;

						/* do set width(s) again based in facet if */

						// ((OpeningObject) O).widthI = ((OpeningObject)
						// O).widthIO = myFrame2.facetUsed.widthIO;
						// ((OpeningObject) O).heightI = ((OpeningObject)
						// O).heightIO = myFrame2.facetUsed.heightIO;
						// ((OpeningObject) O).widthM = ((OpeningObject)
						// O).widthMO = myFrame2.facetUsed.widthMO;
						// ((OpeningObject) O).heightM = ((OpeningObject)
						// O).heightMO = myFrame2.facetUsed.heightMO;
					}

					openings.add(O);
				}

			} else {
				final Object[] oo = openings.toArray();
				openings.clear();

				for (final Object O : oo) {
					if (((OpeningObject) O).startCol == myFrame2.facetUsed.startCol) {

						((OpeningObject) O).widthM = ((OpeningObject) O).widthMO = (int) (((OpeningObject) O).widthPix / myFrame2.scale
								.doubleValue());
						((OpeningObject) O).heightM = ((OpeningObject) O).heightMO = (int) (((OpeningObject) O).heightPix / myFrame2.scale
								.doubleValue());
						((OpeningObject) O).originalScaleM = myFrame2.metricscale;
						((OpeningObject) O).originalScaleI = myFrame2.imperialscale;
						((OpeningObject) O).widthI = ((OpeningObject) O).widthIO = (int) (((OpeningObject) O).widthPix * myFrame2.imperialscale
								.doubleValue());
						((OpeningObject) O).heightI = ((OpeningObject) O).heightIO = (int) (((OpeningObject) O).heightPix / myFrame2.imperialscale
								.doubleValue());

					}

					openings.add(O);
				}
			}

			this.setChangeDims(w, h, ow, oh);

			options.clear();

			executeOptionRules("shapeObject.initOverall.13651");

			// *******************************************************************************
			// Execute Part Rules
			// *******************************************************************************
			this.myFrame2.executePartRules.resetExecutionValues();
			this.executePartRules(true, true, "shapeObject.initOverall.13653");
			this.executePartRules(true);

			this.doCouplers();

			if (dimChange == 0) {
				this.doFacets(false, true, true, sameDims);
			} else if (dimChange > 0) {
				this.doFacets(false, false, true, sameDims);
			}
		} else {
			this.doFacets(false, false, true, sameDims);
		}

		this.drawFacets();

		if (myFrame2.hasGrids && dimChange == 0) {
			myFrame2.gridsPanel.bSetSelectedGrid.doClick();
		}

		this.myFrame2.options.buildOptionsTables();

		// this.doCouplers();

		// myFrame2.jobItem.resetGraphics();
		myFrame2.jobItem.myCanvas.validate();
		myFrame2.jobItem.myCanvas.repaint();

	}

	public void changeOverallSize(final double w, final double h,
			final double ow, final double oh, final ShapeObject newOverall,
			final int dimChange) throws Exception {

		// myFacet = newOverall;

		startCol = endCol = startRow = endRow = 1;

		if (myFrame2.myTopPanel.metric.isSelected()) {
			levelW = widthPix = w;
			levelH = heightPix = h;
		} else {
			levelW = widthPix = w;
			levelH = heightPix = h;
		}

		bX2 = bCX2 = startingX + widthPix;

		bY2 = bCY2 = startingY;

		bX3 = bCX3 = bX2;

		bY3 = bCY3 = startingY + heightPix;

		bX4 = bCX4 = startingX;

		bY4 = bCY4 = bY3;

		startingCX = startingX;

		startingCY = startingY;

		lowestY = lowestYC = Math.max(bY4, bY3);
		highestY = highestYC = Math.min(startingY, bY2);

		this.createSideShapes(false, true, myFrame2.scale);

		this.setBAandA();

		this.doMainOpening();
		this.bOpeningObject = this.doMullions(bOpeningObject);
		// if(!myFrame2.changeFacetW) {
		// modifyVDividerPosEqualize();
		// doOpenings();
		// }else {
		// modifyVDividerPosChangeW();
		//
		// }

		this.setChangeDims(w, h, ow, oh);

		this.doCouplers();

		this.doFacets(false, false, true, false);
		this.drawFacets();

		if (myFrame2.hasGrids && dimChange == 0) {

			myFrame2.gridsPanel.bSetSelectedGrid.doClick();

		}

		// this.doCouplers();

		// myFrame2.jobItem.resetGraphics();
		myFrame2.jobItem.myCanvas.validate();
		myFrame2.jobItem.myCanvas.repaint();

	}

	public Facet initFacetSize(final double w, final double h, final double ow,
			final double oh, final ShapeObject newOverall, final int dimChange)
			throws Exception {

		// xCols = 1;
		// yRows = 1;

		myFacet = newOverall;

		startCol = endCol = startRow = endRow = 1;

		if (myFrame2.myTopPanel.metric.isSelected()) {
			levelW = widthPix = w;
			levelH = heightPix = h;
		} else {
			levelW = widthPix = w;
			levelH = heightPix = h;
		}

		bX2 = bCX2 = startingX + widthPix;

		bY2 = bCY2 = startingY;

		bX3 = bCX3 = bX2;

		bY3 = bCY3 = startingY + heightPix;

		bX4 = bCX4 = startingX;

		bY4 = bCY4 = bY3;

		startingCX = startingX;

		startingCY = startingY;

		lowestY = Math.max(bY4, bY3);

		this.createSideShapes(false, true, myFrame2.scale);

		this.setBAandA();

		this.doMainOpening();

		this.setChangeDims(w, h, ow, oh);

		this.doOverallChange(shapeID, false);

		clearTexts();
		this.reDraw(true, false, null, false, false, false);

		this.doFrames(false, true, true, false);

		if (myFrame2.hasGrids && dimChange == 0) {

			myFrame2.gridsPanel.bSetSelectedGrid.doClick();

		}

		// myFrame2.setgrids();
		// Sequence Frame

		this.doCouplers();
		// myFrame2.overallUsed = (Facet) this;
		// myFrame2.jobItem.resetGraphics();
		myFrame2.jobItem.myCanvas.validate();
		myFrame2.jobItem.myCanvas.repaint();

		return (Facet) this;

	}

	public void setChangeDims(final double w, final double h, final double ow,
			final double oh) {

		bOpeningObject.dimA0 = dimA0 = dimA0 * w / ow;
		bOpeningObject.dimA1 = dimA1 = dimA1 * w / ow;
		bOpeningObject.dimA2 = dimA2 = dimA2 * w / ow;
		bOpeningObject.dimA3 = dimA3 = dimA3 * w / ow;
		bOpeningObject.dimB0 = dimB0 = dimB0 * h / oh;
		bOpeningObject.dimB1 = dimB1 = dimB1 * h / oh;
		bOpeningObject.dimB2 = dimB2 = dimB2 * h / oh;
		bOpeningObject.dimC0 = dimC0 = dimC0 * w / ow;
		bOpeningObject.dimC1 = dimC1 = dimC1 * w / ow;
		bOpeningObject.dimC2 = dimC2 = dimC2 * w / ow;
		bOpeningObject.dimD0 = dimD0 = dimD0 * h / oh;
		bOpeningObject.dimD1 = dimD1 = dimD1 * h / oh;
		bOpeningObject.dimD2 = dimD2 = dimD2 * h / oh;

		bOpeningObject.shapeChanged = false;
		bOpeningObject.shapeID = shapeID;

		myClickedOpening = bOpeningObject;

		bOpeningObject.newDesign = false;

		this.clearTexts();

		bOpeningObject.mullions.toArray();
		bOpeningObject.mullionsH.toArray();

	}

	@SuppressWarnings("unchecked")
	public void startLevelShape(final boolean isCheckBox, final int row,
			final int col, final boolean initLevelShape) throws Exception {

		this.startFrameParts();

		if (!isCheckBox) {
			this.createTextObjectsTopInit();
			this.createTextObjectsLeftInit();
		} else {
			if (!myFrame2.dim.isSash.isSelected()) {
				this.doShapeDimsTop(row, col);
				this.doShapeDimsLeft(row, col);
			} else {

			}
		}

	}

	public void initSides() throws Exception {

		BigDecimal myScale = new BigDecimal(0);
		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}
		analyseShape = new AnalyseShape(this, false, myFrame2, myScale);

		centerPointX = top1.x1;
		centerPointX2 = top1.x2;
		centerPointY = top1.y1;
		centerPointY2 = top1.y2;
		radius1 = top1.radius1;
		radius2 = top1.radius2;
		this.resetParts();
		this.doMainOpening();
		analyseShape = null;

	}

	public void initLevelShape() {

	}

	public void modifyInternalDims(final int position, final int orientation,
			final int dimType) throws Exception {// 1

		// Top
		// //orientation
		// 1=Widths
		// 2=Heights

		if (!myFrame2.modifyDims) {
			newDesign = false;
			// this.top1.topFillShape.reset();
			// this.top1.topObjectPath.reset();
			// myFrame2.jobItem.myCanvas
			// .clearDrawObjects();
			myFrame2.myTextRow = null;

			myFrame2.myTextLeft = null;
			myFrame2.myTextRight = null;
			myFrame2.jobItem.myCanvas = new DrawCanvas(myFrame2,
					myFrame2.jobItem.myCanvas.selectedRadioForRow,
					myFrame2.jobItem.myCanvas.selectedRadioForCol,
					myFrame2.jobItem.myCanvas.selectedRadioForRowo,
					myFrame2.jobItem.myCanvas.selectedRadioForColo);
			myFrame2.mainFramePanel.removeAll();

			modifyVAndHMullions(position, orientation, dimType, this);

		}
		AddMullionV addMullion = null;
		AddMullionH addMullionH = null;

		if (myFrame2.modifyDims) {
			myFrame2.jobItem.resetGraphics();

			myFrame2.ellipses.clear();
			myFrame2.topTexts.clear();
			myFrame2.botTexts.clear();
			myFrame2.leftTexts.clear();
			myFrame2.rightTexts.clear();

			bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
			bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();
			// if (orientation == 1) {
			addMullion = new AddMullionV(bOpeningObject, myFrame2.jobItem,
					myFrame2, 2);
			addMullionH = new AddMullionH(bOpeningObject, myFrame2.jobItem,
					myFrame2, 2);

			addMullion.recalcHCCoords();
			addMullion.reOrderVNotches();
			addMullionH.reOrderHMNotches();
			addMullionH.recalcVCCoords();

			partObjects.clear();
			this.resetParts();

			addMullion.splitParts(null, false, false);
			myFacet.drawFrames();
			this.doOpenings();

			if (a_levelID > 3) {

				bOpeningObject = doMullions(bOpeningObject);
			}

			myFacet.reDrawTextsforRowCol(
					myFrame2.jobItem.myCanvas.selectedRadioForRow,
					myFrame2.jobItem.myCanvas.selectedRadioForCol, true,
					myFacet);
			myFacet.reDrawTextsforRowColOp(
					myFrame2.jobItem.myCanvas.selectedRadioForRow,
					myFrame2.jobItem.myCanvas.selectedRadioForCol,
					myFrame2.jobItem.myCanvas.selectedRadioForRowo,
					myFrame2.jobItem.myCanvas.selectedRadioForColo, true,
					myFrame2.selectedDim);
			myFrame2.modifyDims = true;
			myFrame2.resetAlign();
			myFrame2.hideAlign();

			/*
			 * took this out
			 */
			// Clear draw canvas components
			myFrame2.jobItem.myCanvas.clearDrawCanvasComponents();

			myFrame2.jobItem.myCanvas.createTextFieldsTop();
			myFrame2.jobItem.myCanvas.createTextFieldsLeft();
			myFrame2.jobItem.myCanvas.createTextFieldsFacet();
			myFrame2.jobItem.myCanvas.createTextFieldsCoupler();

			this.reDrawRadioRowCol(yRows, xCols, 1,
					myFrame2.jobItem.myCanvas.selectedRadioForRow,
					myFrame2.jobItem.myCanvas.selectedRadioForCol,
					myFrame2.facetUsed);

			myFrame2.jobItem.myCanvas.validate();
			myFrame2.jobItem.myCanvas.repaint();

			// myFrame2.jobItem.resetGraphics();
		}
		addMullion = null;
		addMullionH = null;

	}

	public void modifyVAndHMullions(final int position, final int orientation,
			final int dimType, final ShapeObject shape) throws Exception {

		// if(!myFrame2.isSash.isSelected()) {
		if (dimType != 7 && dimType != 8) {
			if (orientation == 1) {
				shape.modifyVMullionPos(position);
				myFrame2.modifyDims = true;
			} else {
				shape.modifyHMullionPos(position);
				myFrame2.modifyDims = true;
			}
		} else {
			if (orientation == 1) {
				shape.modifyVMullionPosGlass(position);
				myFrame2.modifyDims = true;
			} else {
				shape.modifyHMullionPosGlass(position);
				myFrame2.modifyDims = true;
			}
		}
		// }else {
		// if (orientation == 1)
		// {
		// shape
		// .modifyVMullionPosGlass(position);
		// myFrame2.modifyDims =
		// true;
		// }
		// else
		// {
		// shape
		// .modifyHMullionPosGlass(position);
		// myFrame2.modifyDims =
		// true;
		// }
		// }
	}

	public ShapeObject removeFramePart() throws Exception {

		Object[] parts = partObjects.toArray();

		Profiles myPart = new Profiles();
		partObjects.clear();
		for (final Object P : parts) {
			if (((Profiles) P).profileSelected == 1) {
				((Profiles) P).remove = true;

				myPart = (Profiles) P;
			}
			partObjects.add(P);
		}

		if (myPart.position == 6) {
			this.removeBot(myPart);
		}
		parts = partObjects.toArray();
		final RemovedParts removedParts = new RemovedParts();
		for (final Object P : parts) {
			if (((Profiles) P).remove) {
				removedParts.position = ((Profiles) P).position;
				removedParts.seq = ((Profiles) P).seq;
				this.removedParts.add(removedParts);

			}

		}

		myFrame2.jobItem.myCanvas.setSelectedDims(myFrame2.selectedDim);
		myFrame2.resetActive();
		myFacet.reDraw(false, true, null, false, false, false);

		// myFacet.reDrawRadioRowCol(
		// yRows,
		// xCols,
		// myFrame2.selectedDim,
		// myFrame2.lastRR,
		// myFrame2.lastRC, myFacet);

		// myFrame2.jobItem.resetGraphics();
		this.myFrame2.jobItem.myCanvas.validate();
		this.myFrame2.jobItem.myCanvas.repaint();

		return this;
	}

	public void setFinalDimensions() {

		startingX = top1.startingX;
		startingY = top1.startingY;
		bX2 = top1.startingX + widthPix;

		bX3 = top1.startingX + widthPix;
		// check no of side top and bot to determine
		// which
		// endX and Y
		bX4 = startingX;
		bY2 = top1.startingY; // what
		// about
		// slopes?
		bY3 = top1.startingY + heightPix;
		bY4 = top1.startingY + heightPix;
		radius1 = top1.radius1;
		radius2 = top1.radius2;
		centerPointX = top1.x1;
		centerPointY = top1.y1;
		centerPointX2 = top1.x2;
		centerPointY2 = top1.y2;

	}

	public void prepareOpenings(final int row, final int col, final int rowo,
			final int colo, final int dimlevel, final int pos) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			this.myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		if (dimlevel == 1 || dimlevel == 2) {

			if (startRow == row) {

				this.doShapeDimsTop(row, col);

			}
			if (startCol == col) {

				this.doShapeDimsLeft(row, col);

			}

		} else if (dimlevel == 4 || dimlevel == 3) {

			if (startRow == row) {

				this.doBkgrdOpeningDimsTop(row, col);

			}
			if (startCol == col) {

				this.doBkgrdOpeningDimsLeft(row, col);
			}

		} else if (dimlevel == 5) {

			if (startRow == row && startCol == col) {
				this.doOpeningDimsTop(rowo, colo);

				this.doOpeningDimsLeft(rowo, colo);
			}

		} else if (dimlevel == 6) {

			if (startRow == row && startCol == col) {
				this.doOpeningDimsTop(rowo, colo);
				this.doOpeningDimsLeft(rowo, colo);
			}

		} else if (dimlevel == 7) {

			if (startRow == row && startCol == col) {

				this.doGlassDimsTop(rowo, colo, pos);
				this.doGlassDimsLeft(rowo, colo, pos);

			}

		} else if (dimlevel == 8) {

			if (startRow == row && startCol == col) {

				this.doDLODimsTop(rowo, colo, pos);
				this.doDLODimsLeft(rowo, colo, pos);

			}

		} else if (dimlevel == 9) {
			if (startRow == row && startCol == col) {
				doGridDims(rowo, colo, pos);
			}
		}
		if (myFrame2.resetModTextsV || myFrame2.topTextsModo == null) {
			myFrame2.topTextsModo = new int[myFrame2.colTextObjects.size()];
		}
		if (myFrame2.resetModTextsH || myFrame2.leftTextsModo == null) {
			myFrame2.leftTextsModo = new int[myFrame2.rowTextObjects.size()];
		}

	}

	public void doPrepSashDimsTop(final int row, final int col, final int pos) {

		boolean found = false;
		final Object[] myOpenings = openings.toArray();
		for (final Object myOpening : myOpenings) {
			if ((((OpeningObject) myOpening).startRow == row || ((OpeningObject) myOpening).endRow >= row
					&& ((OpeningObject) myOpening).startRow <= row)
					&& (((OpeningObject) myOpening).startCol == col || ((OpeningObject) myOpening).endCol >= col
							&& ((OpeningObject) myOpening).startCol <= col))

			{

				if (pos == 1) {
					if (((OpeningObject) myOpening).contentIn == 2) {
						final Object[] leafs = ((OpeningObject) myOpening).sashObjectIn.frames
								.toArray();
						for (final Object s : leafs) {
							this.doShapeDimsTop(row, col);
							found = true;
						}

					}
				}// pos

				else if (pos == 2) {
					if (((OpeningObject) myOpening).contentMid == 2) {
						final Object[] leafs = ((OpeningObject) myOpening).sashObjectMid.frames
								.toArray();
						for (final Object s : leafs) {
							doShapeDimsTop(row, col);
							found = true;
						}

					}

				}// pos

				else if (pos == 3) {
					if (((OpeningObject) myOpening).contentOut == 2) {
						final Object[] leafs = ((OpeningObject) myOpening).sashObjectOut.frames
								.toArray();
						for (final Object s : leafs) {
							doShapeDimsTop(row, col);
							found = true;
						}

					}

				}// pos

			}
		}

		if (!found) {
			JOptionPane.showMessageDialog(null,
					"Sash not found in selected Row/Col.",
					"Invalid Row/Col - Error!", JOptionPane.ERROR_MESSAGE);

		}

	}

	public void doPrepSashDimsLeft(final int row, final int col, final int pos) {

		boolean found = false;
		final Object[] myOpenings = openings.toArray();
		for (final Object myOpening : myOpenings) {
			if ((((OpeningObject) myOpening).startRow == row || ((OpeningObject) myOpening).endRow >= row
					&& ((OpeningObject) myOpening).startRow <= row)
					&& (((OpeningObject) myOpening).startCol == col || ((OpeningObject) myOpening).endCol >= col
							&& ((OpeningObject) myOpening).startCol <= col)) {

				if (pos == 1) {
					if (((OpeningObject) myOpening).contentIn == 2) {
						final Object[] leafs = ((OpeningObject) myOpening).sashObjectIn.frames
								.toArray();
						for (final Object s : leafs) {
							doShapeDimsLeft(row, col);
							found = true;
						}

					}

				}// pos
				else if (pos == 2) {
					if (((OpeningObject) myOpening).contentMid == 2) {
						final Object[] leafs = ((OpeningObject) myOpening).sashObjectMid.frames
								.toArray();
						for (final Object s : leafs) {
							doShapeDimsLeft(row, col);
							found = true;
						}

					}

				}// pos
				else if (pos == 3) {
					if (((OpeningObject) myOpening).contentOut == 2) {
						final Object[] leafs = ((OpeningObject) myOpening).sashObjectOut.frames
								.toArray();
						for (final Object s : leafs) {
							doShapeDimsLeft(row, col);
							found = true;
						}

					}

				}// pos

			}
		}

		if (!found) {
			JOptionPane.showMessageDialog(null,
					"Sash not found in selected Row/Col.",
					"Invalid Row/Col - Error!", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void doShapeDimsTop(final int row, final int col) {

		myParent.frameWRounded = false;
		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}
		double SX = Math.min(startingX, bX4);

		double EX = Math.max(bX2, bX3);

		double SCX = Math.min(startingX, bX4);

		double ECX = Math.max(bX2, bX3);

		if (myFrame2.selectedDim == 1) {
			if (this.leftIn
					&& (myMullionLeft.isValid && this.myMullionLeft != null
							&& this.myMullionLeft.ycs <= this.startingY && this.myMullionLeft.yce >= this.bY4)) {
				SCX = Math.min(startingCX, bCX4);
			}
			if (this.rightIn
					&& (myMullionRight.isValid && this.myMullionRight != null
							&& this.myMullionRight.ycs <= this.bY2 && this.myMullionRight.yce >= this.bY3)) {
				ECX = Math.max(bCX2, bCX3);
			}
		}

		if (myFrame2.selectedDim <= 2 && shapeID != 10) {

			if (startRow == row || endRow >= row && startRow <= row) {

				String w = "";

				if (myFrame2.myTopPanel.metric.isSelected()) {

					w = myFrame2.oneDecimal.format(UOMConvert
							.getBigDecimalConversion((EX - SX), myScale, 2));
					double roundw = Math.round(Double.parseDouble(w));
					final double wd = (int) myFrame2.roundDim(roundw, 2,
							myFrame2.metricRound, 1);

					if (wd != roundw) {
						frameWRounded = true;
						myFrame2.topDeltas = myFrame2.topDeltas + roundw - wd;
						w = myFrame2.oneDecimal.format(wd) + "";

					}
					if (myFrame2.topDeltas < 0.00000000) {
						myParent.frameWRounded = false;
						myFrame2.topDeltas = 0;
						w = ((int) (Double.valueOf(w) * 1000000000))
								/ 100000000 + "";
					}

					myFrame2.colTextObjects.add(w);

				} else if (myFrame2.myTopPanel.percent.isSelected()) {

					w = myFrame2.twoDecimal.format((EX - SX)
							/ myFrame2.jobItem.design_flat_WIDTHpix);

					myFrame2.colTextObjects.add(w);

				} else if (myFrame2.myTopPanel.impDec.isSelected()) {

					w = myFrame2.sixDecimal
							.format(UOMConvert.getBigDecimalConversion(
									(EX - SX), myScale, 2) / 64);
					double roundw = Math.round(Double.parseDouble(w) * 64);
					final double wd = (int) myFrame2.roundDim(roundw, 2,
							myFrame2.impRound, 2);

					if (wd != roundw) {
						frameWRounded = true;
						myFrame2.topDeltas = myFrame2.topDeltas + roundw - wd;

						w = myFrame2.sixDecimal.format(wd / 64) + "";
					}
					if (myFrame2.topDeltas < 0.00000000) {
						myParent.frameWRounded = false;
						myFrame2.topDeltas = 0;
						w = ((int) (Double.valueOf(w) * 1000000000))
								/ 100000000 + "";
					}

					myFrame2.colTextObjects.add(w);

				} else if (myFrame2.myTopPanel.impFrac.isSelected()) {

					try {
						w = UOMConvert.imperialToFraction(""
								+ String.valueOf(UOMConvert
										.getBigDecimalConversion((EX - SX),
												myScale, 2) / 64));
						double roundw = Math.round(Double.parseDouble(w) * 64);
						final double wd = (int) myFrame2.roundDim(roundw, 1,
								myFrame2.impRound, 2);

						if (wd != roundw) {
							frameWRounded = true;
							myFrame2.topDeltas = myFrame2.topDeltas + roundw
									- wd;
							w = UOMConvert.imperialToFraction("" + wd / 64);

						}
						if (myFrame2.topDeltas < 0.00000000) {
							myParent.frameWRounded = false;
							myFrame2.topDeltas = 0;
							w = ((int) (Double.valueOf(w) * 1000000000))
									/ 100000000 + "";
						}

						myFrame2.colTextObjects.add(w);

					} catch (final Exception e) {
						// TODO
						// Auto-generated
						// catch
						// block
						e.printStackTrace();
					}

				} else if (myFrame2.myTopPanel.feet.isSelected()) {

					try {
						w = myFrame2.sixDecimal
								.format(UOMConvert.getBigDecimalConversion(
										(EX - SX), myScale, 2) / 64);

						double roundw = Math.round(Double.parseDouble(w) * 64);
						final double wd = (int) myFrame2.roundDim(roundw, 1,
								myFrame2.impRound, 2);

						if (wd != roundw) {
							frameWRounded = true;
							myFrame2.topDeltas = myFrame2.topDeltas + roundw
									- wd;
							w = UOMConvert.imperialToFraction("" + wd / 64);

						}
						if (myFrame2.topDeltas < 0.00000000) {
							myParent.frameWRounded = false;
							myFrame2.topDeltas = 0;
							w = ((int) (Double.valueOf(w) * 1000000000))
									/ 100000000 + "";
						}

						w = UOMConvert.imperialToFeetInch(w, 0);

						myFrame2.colTextObjects.add(w);

					} catch (final Exception e) {
						// TODO
						// Auto-generated
						// catch
						// block
						e.printStackTrace();
					}

				}

				myFrame2.colTextPosXs.add(startingX);
				myFrame2.colTextPosXe.add(startingX + (EX - SX));

				w = "";

				if (myFrame2.myTopPanel.metric.isSelected()) {

					w = myFrame2.oneDecimal.format(UOMConvert
							.getBigDecimalConversion((ECX - SCX), myScale, 2));

					myFrame2.colTextObjectsc.add(w);

				} else if (myFrame2.myTopPanel.percent.isSelected()) {

					w = myFrame2.twoDecimal.format((ECX - SCX)
							/ myFrame2.jobItem.design_flat_WIDTHpix);

					myFrame2.colTextObjectsc.add(w);

				} else if (myFrame2.myTopPanel.impDec.isSelected()) {

					w = myFrame2.sixDecimal
							.format(UOMConvert.getBigDecimalConversion(
									(ECX - SCX), myScale, 2) / 64);

					myFrame2.colTextObjectsc.add(w);

				} else if (myFrame2.myTopPanel.impFrac.isSelected()) {

					try {
						w = UOMConvert.imperialToFraction("".concat(String
								.valueOf(String.valueOf(UOMConvert
										.getBigDecimalConversion((ECX - SCX),
												myScale, 2) / 64))));

						myFrame2.colTextObjectsc.add(w);

					} catch (final Exception e) {
						// TODO
						// Auto-generated
						// catch
						// block
						e.printStackTrace();
					}

				}

				if (shapeID == 10) {
					myFrame2.textLeft.visible = false;
				}

				myFrame2.colTextPosXsc.add(SCX);
				myFrame2.colTextPosXec.add(ECX);

				myFrame2.textTop = new TextFieldTop();

				myFrame2.textTop.active = true;
				myFrame2.textTop.size = widthPix;
				myFrame2.textTop.sizeC = ECX - SCX;
				myFrame2.textTop.pos = startingX;
				myFrame2.textTop.pose = startingX + (EX - SX);
				myFrame2.textTop.posc = SCX;
				myFrame2.textTop.posec = ECX;
				myFrame2.textTop.startRowCol = startCol;
				myFrame2.textTop.endRowCol = endCol;

				if (!this.leftIn) {
					myFrame2.textTop.deltaL = Math.abs(SX - startingX);
				} else {
					myFrame2.textTop.deltaL = Math.abs(SX - startingCX);
				}

				if (!this.rightIn) {
					myFrame2.textTop.deltaR = Math.abs(bX2 - EX);
				} else {
					myFrame2.textTop.deltaR = Math.abs(bCX2 - EX);
				}

				myFrame2.textTop.colNo = startCol;
				myFrame2.textTop.seqID = myFrame2.topTexts.size() + 1;
				if (myFrame2.layoutP != null
						&& !myFrame2.layoutP.flat.isSelected()) {
					myFrame2.textTop.active = false;
				}

				myFrame2.topTexts.add(myFrame2.textTop);

			}

		} else if (myFrame2.jobItem.myCanvas.dimensionType == 3) {

		}

		if (myFrame2.resetModTextsV || myFrame2.topTextsMod == null
		// || myFrame2.topTexts.size()!= myFrame2.topTextsMod.length
		) {
			myFrame2.topTextsMod = new int[myFrame2.colTextObjects.size()];
		}

		if (myFrame2.layoutP != null && myFrame2.layoutP.active != null
				&& !myFrame2.layoutP.flat.isSelected()) {
			final Object[] topTs = myFrame2.topTexts.toArray();
			myFrame2.topTexts.clear();
			int count = 1;
			for (final Object tt : topTs) {
				for (int i = 0; i < myFrame2.layoutP.active.length; i++) {

					if (count == i + 1) {
						((TextFieldTop) tt).active = myFrame2.layoutP.active[i];
						break;
					}

				}
				count++;
				myFrame2.topTexts.add(tt);
			}
		}

	}

	public void doShapeDimsLeft(final int row, final int col) {

		myParent.frameHRounded = false;

		if (myFrame2.myTopPanel.metric.isSelected()) {
			this.myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		if (lowestY == 0) {
			lowestY = highestY + heightPix;
		}

		double SY = this.highestY;

		double EY = this.lowestY;

		double SCY = this.highestY;

		double ECY = this.lowestY;

		if (myFrame2.selectedDim == 1) {
			if (this.topIn
					&& (myMullionTop.isValid && this.myMullionTop != null
							&& this.myMullionTop.xcs != 0
							&& this.myMullionTop.xcs <= this.startingX && this.myMullionTop.xce >= this.bX4)) {

				SCY = this.highestYC;

			}
			if (this.botIn
					&& (myMullionBot.isValid && this.myMullionBot != null
							&& this.myMullionBot.xcs != 0
							&& this.myMullionBot.xcs <= this.startingX && this.myMullionBot.xce >= this.bX4)) {

				ECY = this.lowestYC;

			}
		}

		if (myFrame2.jobItem.myCanvas.dimensionType <= 2 && shapeID != 10) {

			if (startCol == col || endCol >= col && startCol <= col) {

				String h = "";

				if (myFrame2.myTopPanel.metric.isSelected()) {

					h = myFrame2.oneDecimal.format(UOMConvert
							.getBigDecimalConversion((EY - SY), myScale, 2));
					double hround = Math.round(Double.valueOf(h));
					final double hd = myFrame2.roundDim(hround, 2,
							myFrame2.metricRound, 1);

					if (hd != hround && myFrame2.roundH) {

						myParent.frameHRounded = true;
						myFrame2.leftDeltas = myFrame2.leftDeltas + hround - hd;
						h = myFrame2.oneDecimal.format(hd);

					}
					if (myFrame2.leftDeltas < 0.00000000) {
						myParent.frameHRounded = false;
						myFrame2.leftDeltas = 0;
						h = ((int) (Double.valueOf(h) * 1000000000))
								/ 100000000 + "";
					}

					myFrame2.rowTextObjects.add(h);

				} else if (myFrame2.myTopPanel.percent.isSelected()) {

					h = myFrame2.twoDecimal.format((EY - SY)
							/ myFrame2.jobItem._HEIGHTpix);

					myFrame2.rowTextObjects.add(h);

				} else if (myFrame2.myTopPanel.impDec.isSelected()) {

					h = myFrame2.sixDecimal
							.format(UOMConvert.getBigDecimalConversion(
									(EY - SY), myScale, 2) / 64);
					double hround = Math.round(Double.valueOf(h) * 64);
					final double hd = myFrame2.roundDim(hround, 1,
							myFrame2.impRound, 2);

					if (hd != hround && myFrame2.roundH) {
						myParent.frameHRounded = true;

						myFrame2.leftDeltas = myFrame2.leftDeltas + hround - hd;

						h = myFrame2.sixDecimal.format(hd / 64);

					}

					if (myFrame2.leftDeltas < 0.00000000) {
						myParent.frameHRounded = false;
						myFrame2.leftDeltas = 0;
						h = ((int) (Double.valueOf(h) * 1000000000))
								/ 100000000 + "";
					}

					myFrame2.rowTextObjects.add(h);

				} else if (myFrame2.myTopPanel.impFrac.isSelected()) {

					try {

						h = UOMConvert.imperialToFraction("".concat(String
								.valueOf(UOMConvert.getBigDecimalConversion(
										(EY - SY), myScale, 2) / 64)));
						double hround = Math.round(Double.valueOf(h) * 64);
						final double hd = myFrame2.roundDim(hround, 1,
								myFrame2.impRound, 2);

						if (hd != hround && myFrame2.roundH) {
							myParent.frameHRounded = true;

							myFrame2.leftDeltas = myFrame2.leftDeltas + hround
									- hd;

							h = UOMConvert.imperialToFraction("" + hd / 64);

						}
						if (myFrame2.leftDeltas < 0.00000000) {
							myParent.frameHRounded = false;
							myFrame2.leftDeltas = 0;
							h = ((int) (Double.valueOf(h) * 1000000000))
									/ 100000000 + "";
						}
						myFrame2.rowTextObjects.add(h);

					} catch (final Exception e) {
						// TODO
						// Auto-generated
						// catch
						// block
						e.printStackTrace();
					}

				} else if (myFrame2.myTopPanel.feet.isSelected()) {

					try {
						h = myFrame2.sixDecimal
								.format(UOMConvert.getBigDecimalConversion(
										(EY - SY), myScale, 2) / 64);

						double hround = Math.round(Double.valueOf(h) * 64);
						final double hd = myFrame2.roundDim(hround, 1,
								myFrame2.impRound, 2);

						if (hd != hround && myFrame2.roundH) {
							myParent.frameHRounded = true;

							myFrame2.leftDeltas = myFrame2.leftDeltas
									+ Double.valueOf(h) * 64 - hd;

							h = UOMConvert.imperialToFraction("" + hd / 64);

						}
						if (myFrame2.leftDeltas < 0.00000000) {
							myParent.frameHRounded = false;
							myFrame2.leftDeltas = 0;
							h = ((int) (Double.valueOf(h) * 1000000000))
									/ 100000000 + "";
						}
						h = UOMConvert.imperialToFeetInch(h, 0);
						myFrame2.rowTextObjects.add(h);
					} catch (final Exception e) {
						// TODO
						// Auto-generated
						// catch
						// block
						e.printStackTrace();
					}

				}

				myFrame2.rowTextPosYs.add(SY);

				myFrame2.rowTextPosYe.add(EY);

				h = "";

				if (myFrame2.myTopPanel.metric.isSelected()) {

					h = myFrame2.oneDecimal.format(UOMConvert
							.getBigDecimalConversion((ECY - SCY), myScale, 2));

					myFrame2.rowTextObjectsc.add(h);

				} else if (myFrame2.myTopPanel.percent.isSelected()) {

					h = myFrame2.twoDecimal.format((ECY - SCY)
							/ myFrame2.jobItem._HEIGHTpix);

					myFrame2.rowTextObjects.add(h);

				} else if (myFrame2.myTopPanel.impDec.isSelected()) {

					h = myFrame2.sixDecimal
							.format(UOMConvert.getBigDecimalConversion(
									(ECY - SCY), myScale, 2) / 64);

					myFrame2.rowTextObjectsc.add(h);

				} else if (myFrame2.myTopPanel.impFrac.isSelected()) {

					try {

						h = UOMConvert.imperialToFraction("".concat(String
								.valueOf(String.valueOf(UOMConvert
										.getBigDecimalConversion((ECY - SCY),
												myScale, 2) / 64))));

						myFrame2.rowTextObjectsc.add(h);

					} catch (final Exception e) {
						// TODO
						// Auto-generated
						// catch
						// block
						e.printStackTrace();
					}

				}

				myFrame2.rowTextPosYsc.add(SCY);
				myFrame2.rowTextPosYec.add(ECY);

				myFrame2.textLeft = new TextFieldLeft();
				if (myParent != null && myParent.endRow == 1
						&& endRow == myParent.endRow && startRow == endRow) {

					myFrame2.textLeft.active = false;

				}
				if (myParent != null && myParent.endRow > 1
						&& endRow <= myParent.endRow && startRow >= 1) {

					myFrame2.textLeft.active = true;

				}

				if (shapeID == 10) {
					myFrame2.textLeft.visible = false;
				}

				myFrame2.textLeft.size = heightPix;
				myFrame2.textLeft.sizeC = ECY - SCY;
				myFrame2.textLeft.pos = SY;
				myFrame2.textLeft.pose = EY;
				myFrame2.textLeft.posc = SCY;
				myFrame2.textLeft.posec = ECY;
				myFrame2.textLeft.startRowCol = startRow;
				myFrame2.textLeft.endRowCol = endRow;

				if (!this.topIn) {
					myFrame2.textLeft.deltaLT = Math.abs(SY - highestY);
				} else {
					myFrame2.textLeft.deltaLT = Math.abs(SY - highestYC);
				}
				if (!this.botIn) {
					myFrame2.textLeft.deltaRB = Math.abs(EY - lowestY);
				} else {
					myFrame2.textLeft.deltaRB = Math.abs(EY - lowestYC);
				}

				myFrame2.textLeft.rowNo = startRow;
				myFrame2.textLeft.seqID = myFrame2.leftTexts.size() + 1;

				myFrame2.leftTexts.add(myFrame2.textLeft);
			}

		}

		if (myFrame2.resetModTextsH || myFrame2.leftTextsMod == null
		// || myFrame2.leftTextsMod.length != myFrame2.leftTexts.size()
		) {
			myFrame2.leftTextsMod = new int[myFrame2.rowTextObjects.size()];
		}
	}

	public void doFacetDimsBot(final int row, final int col) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		final double SX = Math.min(startingCX, bCX4);

		final double EX = Math.max(bCX2, bCX3);

		if (myFrame2.selectedDim <= 2) {

			if (startRow == row || endRow >= row && startRow <= row) {

				String w = "";

				if (myFrame2.myTopPanel.metric.isSelected()) {
					w = myFrame2.oneDecimal.format(UOMConvert
							.getBigDecimalConversion(widthPix, myScale, 2));

					final double wd = myFrame2.roundDim(Double.parseDouble(w),
							2, myFrame2.metricRound, 1);

					if (wd != Double.parseDouble(w) && myFrame2.roundW) {
						facetWRounded = true;
						myFrame2.topDeltas = myFrame2.topDeltas
								+ Double.parseDouble(w) - wd;
						w = myFrame2.oneDecimal.format(wd) + "";
					}
					if (myFrame2.topDeltas < 0.00000000) {
						myParent.facetWRounded = false;
						myFrame2.topDeltas = 0;
						w = ((int) (Double.valueOf(w) * 1000000000))
								/ 100000000 + "";
					}

					myFrame2.fcolTextObjects.add(w);
					myFrame2.fcolTextObjectsc.add(w);
				} else if (myFrame2.myTopPanel.percent.isSelected()) {
					w = myFrame2.twoDecimal.format(widthPix
							/ myFrame2.jobItem.design_flat_WIDTHpix);

					myFrame2.fcolTextObjects.add(w);
					myFrame2.fcolTextObjectsc.add(w);
				} else if (myFrame2.myTopPanel.impDec.isSelected()) {
					w = myFrame2.sixDecimal
							.format(UOMConvert.getBigDecimalConversion(
									widthPix, myScale, 2) / 64);

					final double wd = myFrame2.roundDim(Double.valueOf(w) * 64,
							2, myFrame2.impRound, 2);

					if (wd != Double.valueOf(w) * 64d && myFrame2.roundW) {
						facetWRounded = true;
						myFrame2.topDeltas = myFrame2.topDeltas
								+ UOMConvert.getBigDecimalConversion(widthPix,
										myScale, 2) - wd;

						w = myFrame2.sixDecimal.format(wd / 64) + "";
					}
					if (myFrame2.topDeltas < 0.00000000) {
						myParent.facetWRounded = false;
						myFrame2.topDeltas = 0;
						w = ((int) (Double.valueOf(w) * 1000000000))
								/ 100000000 + "";
					}

					myFrame2.fcolTextObjects.add(w);
					myFrame2.fcolTextObjectsc.add(w);

				} else if (myFrame2.myTopPanel.impFrac.isSelected()) {

					try {
						w = UOMConvert.imperialToFraction(""
								+ String.valueOf(UOMConvert
										.getBigDecimalConversion(widthPix,
												myScale, 2) / 64));

						final double wd = myFrame2.roundDim(UOMConvert
								.getBigDecimalConversion(widthPix, myScale, 2),
								1, myFrame2.impRound, 2);

						if (wd != Double.valueOf(w) * 64d && myFrame2.roundW) {
							facetWRounded = true;
							myFrame2.topDeltas = myFrame2.topDeltas
									+ UOMConvert.getBigDecimalConversion(
											widthPix, myScale, 2) - wd;
							w = UOMConvert.imperialToFraction("" + wd / 64);

						}
						if (myFrame2.topDeltas < 0.00000000) {
							myParent.facetWRounded = false;
							myFrame2.topDeltas = 0;
							w = ((int) (Double.valueOf(w) * 1000000000))
									/ 100000000 + "";
						}

						myFrame2.fcolTextObjects.add(w);
						myFrame2.fcolTextObjectsc.add(w);

					} catch (final Exception e) {
						// TODO
						// Auto-generated
						// catch
						// block
						e.printStackTrace();
					}

				}

				myFrame2.fcolTextPosXs.add(startingX);
				myFrame2.fcolTextPosXe.add(startingX + widthPix);

				w = "";

				myFrame2.fcolTextPosXsc.add(SX);
				myFrame2.fcolTextPosXec.add(EX);

				myFrame2.fcolText = new FacetBotText();

				//
				myFrame2.fcolText.active = true;
				myFrame2.fcolText.size = widthPix;
				myFrame2.fcolText.sizeC = EX - SX;
				myFrame2.fcolText.pos = startingX;
				myFrame2.fcolText.pose = startingX + widthPix;
				myFrame2.fcolText.posc = SX;
				myFrame2.fcolText.posec = EX;
				myFrame2.fcolText.startRowCol = startCol;
				myFrame2.fcolText.endRowCol = endCol;
				myFrame2.fcolText.deltaL = Math.abs(SX - startingX);
				myFrame2.fcolText.deltaR = Math.abs(bX2 - EX);

				myFrame2.fcolText.colNo = startCol;
				// myFrame2.fcolText.seqID = myFrame2.fcolTexts.size()+1;
				if (myFrame2.layoutP != null
						&& !myFrame2.layoutP.flat.isSelected()) {
					myFrame2.fcolText.active = false;
				}

				myFrame2.fcolTexts.add(myFrame2.fcolText);

			}

		} else if (myFrame2.jobItem.myCanvas.dimensionType == 3) {

		}
		if (myFrame2.resetModTextsV || myFrame2.fbotTextsMod == null) {
			myFrame2.fbotTextsMod = new int[myFrame2.fcolTextObjects.size()];
		}

	}

	public void doBkgrdOpeningDimsTop(final int row, final int col) {
		this.bOpeningObject.doOpeningTopDimsBkgrd(false);
	}

	public void doBkgrdOpeningDimsLeft(final int row, final int col) {
		this.bOpeningObject.doOpeningLeftDimsBkgrd(false);
	}

	public void doBkgrdOpeningDimsTopS(final int row, final int col,
			final int pos) {

		boolean found = false;
		final Object[] myOpenings = openings.toArray();
		for (final Object myOpening : myOpenings) {
			if (((OpeningObject) myOpening).startRow == row
					|| ((OpeningObject) myOpening).endRow >= row
					&& ((OpeningObject) myOpening).startRow <= row
					|| ((OpeningObject) myOpening).startCol == col
					|| ((OpeningObject) myOpening).endCol >= col
					&& ((OpeningObject) myOpening).startCol <= col)

			{
				if (((OpeningObject) myOpening).startRow <= row
						&& ((OpeningObject) myOpening).endRow >= row) {
					if (pos == 1) {
						if (((OpeningObject) myOpening).contentIn == 2) {
							final Object[] leafs = ((OpeningObject) myOpening).sashObjectIn.frames
									.toArray();
							for (final Object s : leafs) {

								((SashLeaf) s).bOpeningObject
										.doOpeningTopDimsBkgrd(true);

								found = true;
							}

						}

					}// pos
					else if (pos == 2) {
						if (((OpeningObject) myOpening).contentMid == 2) {
							final Object[] leafs = ((OpeningObject) myOpening).sashObjectMid.frames
									.toArray();
							for (final Object s : leafs) {

								((SashLeaf) s).bOpeningObject
										.doOpeningTopDimsBkgrd(true);
								found = true;
							}

						}

					}// pos
					else if (pos == 3) {
						if (((OpeningObject) myOpening).contentOut == 2) {
							final Object[] leafs = ((OpeningObject) myOpening).sashObjectOut.frames
									.toArray();
							for (final Object s : leafs) {

								((SashLeaf) s).bOpeningObject
										.doOpeningTopDimsBkgrd(true);
								found = true;
							}

						}
						//
					}// pos

				}// Row
			}
		}
		if (!found) {
			JOptionPane.showMessageDialog(null,
					"Sash not found in selected Row/Col.",
					"Invalid Row/Col - Error!", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void doBkgrdOpeningDimsLeftS(final int row, final int col,
			final int pos) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		boolean found = false;
		final Object[] myOpenings = openings.toArray();
		for (final Object myOpening : myOpenings) {
			if (((OpeningObject) myOpening).startRow == row
					|| ((OpeningObject) myOpening).endRow >= row
					&& ((OpeningObject) myOpening).startRow <= row
					|| ((OpeningObject) myOpening).startCol == col
					|| ((OpeningObject) myOpening).endCol >= col
					&& ((OpeningObject) myOpening).startCol <= col)

			{

				if (((OpeningObject) myOpening).startCol <= col
						&& ((OpeningObject) myOpening).endCol >= col) {
					if (pos == 1) {
						if (((OpeningObject) myOpening).contentIn == 2) {
							final Object[] leafs = ((OpeningObject) myOpening).sashObjectIn.frames
									.toArray();
							for (final Object s : leafs) {

								((SashLeaf) s).bOpeningObject
										.doOpeningLeftDimsBkgrd(true);
								found = true;
							}
						}

					}// pos
					else if (pos == 2) {
						if (((OpeningObject) myOpening).contentMid == 2) {
							final Object[] leafs = ((OpeningObject) myOpening).sashObjectMid.frames
									.toArray();
							for (final Object s : leafs) {

								((SashLeaf) s).bOpeningObject
										.doOpeningLeftDimsBkgrd(true);
								found = true;
							}

						}

					}// pos
					else if (pos == 3) {
						if (((OpeningObject) myOpening).contentOut == 2) {
							final Object[] leafs = ((OpeningObject) myOpening).sashObjectOut.frames
									.toArray();
							for (final Object s : leafs) {

								((SashLeaf) s).bOpeningObject
										.doOpeningLeftDimsBkgrd(true);
								found = true;
							}

						}

					}// pos

				}// Row
			}
		}
		if (!found) {
			JOptionPane.showMessageDialog(null,
					"Sash not found in selected Row/Col.",
					"Invalid Row/Col - Error!", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void doOpeningDimsTop(final int row, final int col) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}
		this.myScale = myScale;
		final Object[] myOpenings = openings.toArray();
		for (final Object myOpening : myOpenings) {
			if (((OpeningObject) myOpening).startRow == row
					|| ((OpeningObject) myOpening).endRow >= row
					&& ((OpeningObject) myOpening).startRow <= row
					|| ((OpeningObject) myOpening).startCol == col
					|| ((OpeningObject) myOpening).endCol >= col
					&& ((OpeningObject) myOpening).startCol <= col) {

				if (((OpeningObject) myOpening).startRow <= row
						&& ((OpeningObject) myOpening).endRow >= row) {

					((OpeningObject) myOpening).doOpeningTopDims(false, true);

				}

			}
		}
	}

	public void doOpeningDimsLeft(final int row, final int col) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		final Object[] myOpenings = openings.toArray();
		for (final Object myOpening : myOpenings) {
			if (((OpeningObject) myOpening).startRow == row
					|| ((OpeningObject) myOpening).endRow >= row
					&& ((OpeningObject) myOpening).startRow <= row
					|| ((OpeningObject) myOpening).startCol == col
					|| ((OpeningObject) myOpening).endCol >= col
					&& ((OpeningObject) myOpening).startCol <= col) {

				if (((OpeningObject) myOpening).startCol <= col
						&& ((OpeningObject) myOpening).endCol >= col) {

					((OpeningObject) myOpening).doOpeningLeftDims(false, true);

				}
			}
		}
	}

	public void doOpeningDimsTopS(final int row, final int col, final int pos) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		boolean found = false;
		final Object[] myOpenings = openings.toArray();
		for (final Object myOpening : myOpenings) {
			if (((OpeningObject) myOpening).startRow == row
					|| ((OpeningObject) myOpening).endRow >= row
					&& ((OpeningObject) myOpening).startRow <= row
					|| ((OpeningObject) myOpening).startCol == col
					|| ((OpeningObject) myOpening).endCol >= col
					&& ((OpeningObject) myOpening).startCol <= col)

			{
				if (((OpeningObject) myOpening).startRow <= row
						&& ((OpeningObject) myOpening).endRow >= row) {
					if (pos == 1) {
						if (((OpeningObject) myOpening).contentIn == 2) {
							// this
							// .doOpeningTopDims((OpeningObject)
							// myOpening, false, false);

							final Object[] leafs = ((OpeningObject) myOpening).sashObjectIn.frames
									.toArray();
							for (final Object s : leafs) {
								final Object[] sashOps = ((SashLeaf) s).openings
										.toArray();
								for (final Object so : sashOps) {
									((OpeningObject) so).doOpeningTopDims(true,
											true);
									found = true;
								}

							}

						} else {
							// this
							// .doOpeningTopDims((OpeningObject)
							// myOpening, false, true);

						}

					}// pos
					else if (pos == 2) {
						if (((OpeningObject) myOpening).contentMid == 2) {
							// this
							// .doOpeningTopDims((OpeningObject)
							// myOpening, false, false);

							final Object[] leafs = ((OpeningObject) myOpening).sashObjectMid.frames
									.toArray();
							for (final Object s : leafs) {
								final Object[] sashOps = ((SashLeaf) s).openings
										.toArray();
								for (final Object so : sashOps) {
									((OpeningObject) so).doOpeningTopDims(true,
											true);
									found = true;
								}
							}

						} else {
							// this
							// .doOpeningTopDims(((OpeningObject)
							// myOpening), false, true);
						}

					}// pos
					else if (pos == 3) {
						if (((OpeningObject) myOpening).contentOut == 2) {

							// this
							// .doOpeningTopDims(((OpeningObject)
							// myOpening), false, false);

							final Object[] leafs = ((OpeningObject) myOpening).sashObjectOut.frames
									.toArray();
							for (final Object s : leafs) {
								final Object[] sashOps = ((SashLeaf) s).openings
										.toArray();
								for (final Object so : sashOps) {
									((OpeningObject) so).doOpeningTopDims(true,
											true);
									found = true;
								}
							}

						} else {
							// this
							// .doOpeningTopDims((OpeningObject)
							// myOpening, false, true);
						}
						//
					}// pos

				}// Row
			}
		}
		if (!found) {
			JOptionPane.showMessageDialog(null,
					"Sash not found in selected Row/Col.",
					"Invalid Row/Col - Error!", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void doOpeningDimsLeftS(final int row, final int col, final int pos) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		boolean found = false;
		final Object[] myOpenings = openings.toArray();
		for (final Object myOpening : myOpenings) {
			if (((OpeningObject) myOpening).startRow == row
					|| ((OpeningObject) myOpening).endRow >= row
					&& ((OpeningObject) myOpening).startRow <= row
					|| ((OpeningObject) myOpening).startCol == col
					|| ((OpeningObject) myOpening).endCol >= col
					&& ((OpeningObject) myOpening).startCol <= col)

			{

				if (((OpeningObject) myOpening).startCol <= col
						&& ((OpeningObject) myOpening).endCol >= col) {
					if (pos == 1) {
						if (((OpeningObject) myOpening).contentIn == 2) {
							((OpeningObject) myOpening).doOpeningLeftDims(
									false, false);

							final Object[] leafs = ((OpeningObject) myOpening).sashObjectIn.frames
									.toArray();

							for (final Object s : leafs) {
								final Object[] sashOps = ((SashLeaf) s).openings
										.toArray();
								for (final Object so : sashOps) {
									((OpeningObject) myOpening)
											.doOpeningLeftDims(true, true);
									found = true;
								}
							}

						} else {
							// this
							// .doOpeningLeftDims((OpeningObject)
							// myOpening, false, true);
						}

					}// pos
					else if (pos == 2) {
						if (((OpeningObject) myOpening).contentMid == 2) {
							((OpeningObject) myOpening).doOpeningLeftDims(
									false, false);
							final Object[] leafs = ((OpeningObject) myOpening).sashObjectMid.frames
									.toArray();
							for (final Object s : leafs) {
								final Object[] sashOps = ((SashLeaf) s).openings
										.toArray();
								for (final Object so : sashOps) {
									((OpeningObject) myOpening)
											.doOpeningLeftDims(true, true);
									found = true;
								}
							}

						} else {
							// this
							// .doOpeningLeftDims((OpeningObject)
							// myOpening, false, true);
						}

					}// pos
					else if (pos == 3) {
						if (((OpeningObject) myOpening).contentOut == 2) {
							((OpeningObject) myOpening).doOpeningLeftDims(
									false, false);
							final Object[] leafs = ((OpeningObject) myOpening).sashObjectOut.frames
									.toArray();
							for (final Object s : leafs) {
								final Object[] sashOps = ((SashLeaf) s).openings
										.toArray();
								for (final Object so : sashOps) {
									((OpeningObject) myOpening)
											.doOpeningLeftDims(true, true);
									found = true;
								}
							}

						} else {
							// this
							// .doOpeningLeftDims((OpeningObject)
							// myOpening, false, true);
						}

					}// pos

				}// Row
			}
		}
		if (!found) {
			JOptionPane.showMessageDialog(null,
					"Sash not found in selected Row/Col.",
					"Invalid Row/Col - Error!", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void doGlassDimsTop(final int row, final int col, final int pos) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		final Object[] myOpenings = openings.toArray();
		for (final Object myOpening : myOpenings) {
			if (((OpeningObject) myOpening).startRow == row
					|| ((OpeningObject) myOpening).endRow >= row
					&& ((OpeningObject) myOpening).startRow <= row
					|| ((OpeningObject) myOpening).startCol == col
					|| ((OpeningObject) myOpening).endCol >= col
					&& ((OpeningObject) myOpening).startCol <= col)

			{
				if (((OpeningObject) myOpening).startRow <= row
						&& ((OpeningObject) myOpening).endRow >= row) {
					if (pos == 1) {

						if (((OpeningObject) myOpening).contentIn == 1) {

							this.doOpeningTopDimsGlassDLO(
									((OpeningObject) myOpening).myGlassIn,
									false, true);

						} else {

							((OpeningObject) myOpening).doOpeningTopDims(false,
									false);

						}
					}// pos
					else if (pos == 2) {

						if (((OpeningObject) myOpening).contentMid == 1) {

							this.doOpeningTopDimsGlassDLO(
									((OpeningObject) myOpening).myGlassMid,
									false, true);

						} else {

							// doPrepSashDimsTop(row, col, pos);
							((OpeningObject) myOpening).doOpeningTopDims(false,
									false);
						}
					}// pos
					else if (pos == 3) {

						if (((OpeningObject) myOpening).contentOut == 1) {

							this.doOpeningTopDimsGlassDLO(
									((OpeningObject) myOpening).myGlassOut,
									false, true);

						} else {
							((OpeningObject) myOpening).doOpeningTopDims(false,
									false);
						}
					}// pos

				}// Row

			}
		}
		// myFrame2.topTextsMod= new
		// int[myFrame2.colTextObjects.size()];
	}

	public void doGlassDimsLeft(final int row, final int col, final int pos) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		final Object[] myOpenings = openings.toArray();
		for (final Object myOpening : myOpenings) {
			if (((OpeningObject) myOpening).startRow == row
					|| ((OpeningObject) myOpening).endRow >= row
					&& ((OpeningObject) myOpening).startRow <= row
					|| ((OpeningObject) myOpening).startCol == col
					|| ((OpeningObject) myOpening).endCol >= col
					&& ((OpeningObject) myOpening).startCol <= col) {

				if (((OpeningObject) myOpening).startCol <= col
						&& ((OpeningObject) myOpening).endCol >= col) {
					if (pos == 1) {

						if (((OpeningObject) myOpening).contentIn == 1) {

							this.doOpeningLeftDimsGlassDLO(
									((OpeningObject) myOpening).myGlassIn,
									false, true);

						} else {
							((OpeningObject) myOpening).doOpeningLeftDims(
									false, false);
						}
					}// pos
					else if (pos == 2) {

						if (((OpeningObject) myOpening).contentMid == 1) {

							this.doOpeningLeftDimsGlassDLO(
									((OpeningObject) myOpening).myGlassMid,
									false, true);

						} else {
							((OpeningObject) myOpening).doOpeningLeftDims(
									false, false);
						}
					}// pos
					else if (pos == 3) {

						if (((OpeningObject) myOpening).contentOut == 1) {

							this.doOpeningLeftDimsGlassDLO(
									((OpeningObject) myOpening).myGlassOut,
									false, true);

						} else {
							((OpeningObject) myOpening).doOpeningLeftDims(
									false, false);
						}
					}// pos

				}// Row
			}
		}
	}

	public void doGlassDimsTopS(final int row, final int col, final int pos) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		boolean found = false;
		final Object[] myOpenings = openings.toArray();

		for (final Object myOpening : myOpenings) {
			if (((OpeningObject) myOpening).startRow == row
					|| ((OpeningObject) myOpening).endRow >= row
					&& ((OpeningObject) myOpening).startRow <= row
					|| ((OpeningObject) myOpening).startCol == col
					|| ((OpeningObject) myOpening).endCol >= col
					&& ((OpeningObject) myOpening).startCol <= col)

			{

				if (pos == 1) {
					if (((OpeningObject) myOpening).contentIn == 2) {
						final Object[] leafs = ((OpeningObject) myOpening).sashObjectIn.frames
								.toArray();
						for (final Object s : leafs) {
							final Object[] sashOps = ((SashLeaf) s).openings
									.toArray();
							for (final Object so : sashOps) {
								this.doOpeningTopDimsGlassDLO(
										((OpeningObject) so).myGlassIn, true,
										true);
								found = true;
							}

						}

					} else {
						// this
						// .doOpeningTopDimsGlassDLO(
						// ((OpeningObject)
						// myOpening).myGlassIn,
						// false);
					}

				}// pos
				else if (pos == 2) {
					if (((OpeningObject) myOpening).contentMid == 2) {
						final Object[] leafs = ((OpeningObject) myOpening).sashObjectMid.frames
								.toArray();
						for (final Object s : leafs) {
							final Object[] sashOps = ((SashLeaf) s).openings
									.toArray();
							for (final Object so : sashOps) {
								this.doOpeningTopDimsGlassDLO(
										((OpeningObject) so).myGlassMid, true,
										true);
								found = true;
							}
						}

					} else {
						// this
						// .doOpeningTopDimsGlassDLO(
						// ((OpeningObject)
						// myOpening).myGlassMid,
						// false);
					}

				}// pos
				else if (pos == 3) {
					if (((OpeningObject) myOpening).contentOut == 2) {
						final Object[] leafs = ((OpeningObject) myOpening).sashObjectOut.frames
								.toArray();
						for (final Object s : leafs) {
							final Object[] sashOps = ((SashLeaf) s).openings
									.toArray();
							for (final Object so : sashOps) {
								this.doOpeningTopDimsGlassDLO(
										((OpeningObject) so).myGlassOut, true,
										true);
								found = true;
							}
						}

					} else {
						// this
						// .doOpeningTopDimsGlassDLO(
						// ((OpeningObject)
						// myOpening).myGlassOut,
						// false);
					}

				}// pos

			}
		}
		if (!found) {
			JOptionPane.showMessageDialog(null,
					"Sash not found in selected Row/Col.",
					"Invalid Row/Col - Error!", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void doGlassDimsLeftS(final int row, final int col, final int pos) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		boolean found = false;
		final Object[] myOpenings = openings.toArray();
		for (final Object myOpening : myOpenings) {
			if (((OpeningObject) myOpening).startRow == row
					|| ((OpeningObject) myOpening).endRow >= row
					&& ((OpeningObject) myOpening).startRow <= row
					|| ((OpeningObject) myOpening).startCol == col
					|| ((OpeningObject) myOpening).endCol >= col
					&& ((OpeningObject) myOpening).startCol <= col) {

				if (pos == 1) {
					if (((OpeningObject) myOpening).contentIn == 2) {
						final Object[] leafs = ((OpeningObject) myOpening).sashObjectIn.frames
								.toArray();
						for (final Object s : leafs) {
							final Object[] sashOps = ((SashLeaf) s).openings
									.toArray();
							for (final Object so : sashOps) {
								this.doOpeningLeftDimsGlassDLO(
										((OpeningObject) so).myGlassIn, true,
										true);
								found = true;
							}
						}

					} else {
						// this
						// .doOpeningLeftDimsGlassDLO(
						// ((OpeningObject)
						// myOpening).myGlassIn,
						// false);
					}

				}// pos
				else if (pos == 2) {
					if (((OpeningObject) myOpening).contentMid == 2) {
						final Object[] leafs = ((OpeningObject) myOpening).sashObjectMid.frames
								.toArray();
						for (final Object s : leafs) {
							final Object[] sashOps = ((SashLeaf) s).openings
									.toArray();
							for (final Object so : sashOps) {
								this.doOpeningLeftDimsGlassDLO(
										((OpeningObject) so).myGlassMid, true,
										true);
								found = true;
							}
						}

					} else {
						// this
						// .doOpeningLeftDimsGlassDLO(
						// ((OpeningObject)
						// myOpening).myGlassMid,
						// false);
					}

				}// pos
				else if (pos == 3) {
					if (((OpeningObject) myOpening).contentOut == 2) {
						final Object[] leafs = ((OpeningObject) myOpening).sashObjectOut.frames
								.toArray();
						for (final Object s : leafs) {
							final Object[] sashOps = ((SashLeaf) s).openings
									.toArray();
							for (final Object so : sashOps) {
								this.doOpeningLeftDimsGlassDLO(
										((OpeningObject) so).myGlassOut, true,
										true);
								found = true;
							}
						}

					} else {
						// this
						// .doOpeningLeftDimsGlassDLO(
						// ((OpeningObject)
						// myOpening).myGlassOut,
						// false);
					}

				}// pos

			}
		}
		if (!found) {
			JOptionPane.showMessageDialog(null,
					"Sash not found in selected Row/Col.",
					"Invalid Row/Col - Error!", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void doDLODimsTop(final int row, final int col, final int pos) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		final Object[] myOpenings = openings.toArray();
		for (final Object myOpening : myOpenings) {
			if (((OpeningObject) myOpening).startRow == row
					|| ((OpeningObject) myOpening).endRow >= row
					&& ((OpeningObject) myOpening).startRow <= row
					|| ((OpeningObject) myOpening).startCol == col
					|| ((OpeningObject) myOpening).endCol >= col
					&& ((OpeningObject) myOpening).startCol <= col) {
				if (((OpeningObject) myOpening).startRow <= row
						&& ((OpeningObject) myOpening).endRow >= row) {
					if (pos == 1) {

						if (((OpeningObject) myOpening).contentIn == 1) {

							this.doOpeningTopDimsDLO(
									((OpeningObject) myOpening).dloIn, false,
									true);

						} else {
							((OpeningObject) myOpening).doOpeningTopDims(false,
									false);

						}
					}// pos
					else if (pos == 2) {

						if (((OpeningObject) myOpening).contentMid == 1) {

							this.doOpeningTopDimsDLO(
									((OpeningObject) myOpening).dloMid, false,
									true);

						} else {
							((OpeningObject) myOpening).doOpeningTopDims(false,
									false);
						}
					}// pos
					else if (pos == 3) {

						if (((OpeningObject) myOpening).contentOut == 1) {

							this.doOpeningTopDimsDLO(
									((OpeningObject) myOpening).dloOut, false,
									true);

						} else {
							((OpeningObject) myOpening).doOpeningTopDims(false,
									false);
						}
					}// pos

				}// Row

			}
		}
	}

	public void doDLODimsLeft(final int row, final int col, final int pos) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		final Object[] myOpenings = openings.toArray();
		for (final Object myOpening : myOpenings) {
			if (((OpeningObject) myOpening).startRow == row
					|| ((OpeningObject) myOpening).endRow >= row
					&& ((OpeningObject) myOpening).startRow <= row
					|| ((OpeningObject) myOpening).startCol == col
					|| ((OpeningObject) myOpening).endCol >= col
					&& ((OpeningObject) myOpening).startCol <= col) {

				if (((OpeningObject) myOpening).startCol <= col
						&& ((OpeningObject) myOpening).endCol >= col) {
					if (pos == 1) {

						if (((OpeningObject) myOpening).contentIn == 1) {

							this.doOpeningLeftDimsDLO(
									((OpeningObject) myOpening).dloIn, false,
									true);

						} else {

							((OpeningObject) myOpening).doOpeningLeftDims(
									false, false);

						}
					}// pos
					else if (pos == 2) {
						if (((OpeningObject) myOpening).contentMid == 1) {

							this.doOpeningLeftDimsDLO(
									((OpeningObject) myOpening).dloMid, false,
									true);

						} else {
							((OpeningObject) myOpening).doOpeningLeftDims(
									false, false);
						}
					}// pos
					else if (pos == 3) {

						if (((OpeningObject) myOpening).contentOut == 1) {

							this.doOpeningLeftDimsDLO(
									((OpeningObject) myOpening).dloOut, false,
									true);

						} else {
							((OpeningObject) myOpening).doOpeningLeftDims(
									false, false);

						}
					}// pos

				}// Row
			}
		}
	}

	public void doDLODimsTopS(final int row, final int col, final int pos) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		boolean found = false;
		final Object[] myOpenings = openings.toArray();
		for (final Object myOpening : myOpenings) {
			if (((OpeningObject) myOpening).startRow == row
					|| ((OpeningObject) myOpening).endRow >= row
					&& ((OpeningObject) myOpening).startRow <= row
					|| ((OpeningObject) myOpening).startCol == col
					|| ((OpeningObject) myOpening).endCol >= col
					&& ((OpeningObject) myOpening).startCol <= col) {
				if (((OpeningObject) myOpening).startRow <= row
						&& ((OpeningObject) myOpening).endRow >= row) {
					if (pos == 1) {
						if (((OpeningObject) myOpening).contentIn == 2) {
							final Object[] leafs = ((OpeningObject) myOpening).sashObjectIn.frames
									.toArray();
							for (final Object s : leafs) {
								final Object[] sashOps = ((SashLeaf) s).openings
										.toArray();
								for (final Object so : sashOps) {
									this.doOpeningTopDimsDLO(
											((OpeningObject) so).dloIn, true,
											true);
									found = true;
								}

							}

						} else {
							// this
							// .doOpeningTopDimsDLO(
							// ((OpeningObject)
							// myOpening).dloIn,
							// false);
						}

					}// pos
					else if (pos == 2) {
						if (((OpeningObject) myOpening).contentMid == 2) {
							final Object[] leafs = ((OpeningObject) myOpening).sashObjectMid.frames
									.toArray();
							for (final Object s : leafs) {
								final Object[] sashOps = ((SashLeaf) s).openings
										.toArray();
								for (final Object so : sashOps) {
									this.doOpeningTopDimsDLO(
											((OpeningObject) so).dloMid, true,
											true);
									found = true;
								}
							}

						} else {
							// this
							// .doOpeningTopDimsDLO(
							// ((OpeningObject)
							// myOpening).dloMid,
							// //
							// false);
						}

					}// pos
					else if (pos == 3) {
						if (((OpeningObject) myOpening).contentOut == 2) {
							final Object[] leafs = ((OpeningObject) myOpening).sashObjectOut.frames
									.toArray();
							for (final Object s : leafs) {
								final Object[] sashOps = ((SashLeaf) s).openings
										.toArray();
								for (final Object so : sashOps) {
									this.doOpeningTopDimsDLO(
											((OpeningObject) so).dloOut, true,
											true);
									found = true;
								}
							}

						} else {
							// this
							// .doOpeningTopDimsDLO(
							// ((OpeningObject)
							// myOpening).dloOut,
							// false);
						}

					}// pos

				}// Row

			}
		}
		if (!found) {
			JOptionPane.showMessageDialog(null,
					"Sash not found in selected Row/Col.",
					"Invalid Row/Col - Error!", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void doDLODimsLeftS(final int row, final int col, final int pos) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		boolean found = false;
		final Object[] myOpenings = openings.toArray();
		for (final Object myOpening : myOpenings) {
			if (((OpeningObject) myOpening).startRow == row
					|| ((OpeningObject) myOpening).endRow >= row
					&& ((OpeningObject) myOpening).startRow <= row
					|| ((OpeningObject) myOpening).startCol == col
					|| ((OpeningObject) myOpening).endCol >= col
					&& ((OpeningObject) myOpening).startCol <= col) {

				if (((OpeningObject) myOpening).startCol <= col
						&& ((OpeningObject) myOpening).endCol >= col) {
					if (pos == 1) {
						if (((OpeningObject) myOpening).contentIn == 2) {
							final Object[] leafs = ((OpeningObject) myOpening).sashObjectIn.frames
									.toArray();
							for (final Object s : leafs) {
								final Object[] sashOps = ((SashLeaf) s).openings
										.toArray();
								for (final Object so : sashOps) {
									this.doOpeningLeftDimsDLO(
											((OpeningObject) so).dloIn, true,
											true);
									found = true;
								}
							}
						}

					}// pos
					else if (pos == 2) {
						if (((OpeningObject) myOpening).contentMid == 2) {
							final Object[] leafs = ((OpeningObject) myOpening).sashObjectMid.frames
									.toArray();
							for (final Object s : leafs) {
								final Object[] sashOps = ((SashLeaf) s).openings
										.toArray();
								for (final Object so : sashOps) {
									this.doOpeningLeftDimsDLO(
											((OpeningObject) so).dloMid, true,
											true);
									found = true;
								}
							}

						}

					}// pos
					else if (pos == 3) {
						if (((OpeningObject) myOpening).contentOut == 2) {
							final Object[] leafs = ((OpeningObject) myOpening).sashObjectOut.frames
									.toArray();
							for (final Object s : leafs) {
								final Object[] sashOps = ((SashLeaf) s).openings
										.toArray();
								for (final Object so : sashOps) {
									this.doOpeningLeftDimsDLO(
											((OpeningObject) so).dloOut, true,
											true);
									found = true;
								}
							}

						}

					}// pos

				}// Row
			}
		}
		if (!found) {
			JOptionPane.showMessageDialog(null,
					"Sash not found in selected Row/Col.",
					"Invalid Row/Col - Error!", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void doGridDims(final int row, final int col, final int pos) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		final Object[] myOpenings = openings.toArray();
		for (final Object myOpening : myOpenings) {
			if (((OpeningObject) myOpening).startRow == row
					&& ((OpeningObject) myOpening).startCol == col) {
				if (((OpeningObject) myOpening).startRow <= row
						&& ((OpeningObject) myOpening).endRow >= row) {
					if (pos == 1) {
						if (((OpeningObject) myOpening).contentIn == 2) {
							final Object[] leafs = ((OpeningObject) myOpening).sashObjectIn.frames
									.toArray();
							for (final Object s : leafs) {
								final Object[] sashOps = ((SashLeaf) s).openings
										.toArray();
								for (final Object so : sashOps) {
									// final
									// Object[] lites
									// =
									// ((OpeningObject)
									// so).dloIn.openings
									// .toArray();
									//
									// myFrame2.topTextsModo
									// =
									// new
									// int[lites.length];
									// for
									// (final Object soe
									// : lites)
									// {
									// if
									// (((OpeningObject)
									// soe).startRow == 1)
									// {
									// this
									// .doGridTopDimsOLD(((OpeningObject)
									// soe));
									// }
									// }
									final Object[] lites = ((OpeningObject) so).dloIn.anchorsV
											.toArray();
									if (lites.length > 0) {
										doVGridDims(((OpeningObject) so).dloIn,
												lites);
									}

								}

							}

						}
						if (((OpeningObject) myOpening).contentIn == 1) {
							// final
							// Object[] lites =
							// ((OpeningObject)
							// myOpening).dloIn.openings
							// .toArray();
							// myFrame2.topTextsModo
							// =
							// new
							// int[lites.length];
							// for
							// (final Object soe :
							// lites)
							// {
							// if
							// (((OpeningObject)
							// soe).startRow == 1)
							// {
							// this
							// .doGridTopDimsOLD(((OpeningObject)
							// soe));
							// }
							// }
							final Object[] lites = ((OpeningObject) myOpening).dloIn.anchorsV
									.toArray();
							if (lites.length > 0) {
								doVGridDims(((OpeningObject) myOpening).dloIn,
										lites);
							}

						}
					}// pos
					else if (pos == 2) {
						if (((OpeningObject) myOpening).contentMid == 2) {
							final Object[] leafs = ((OpeningObject) myOpening).sashObjectMid.frames
									.toArray();
							for (final Object s : leafs) {
								final Object[] sashOps = ((SashLeaf) s).openings
										.toArray();
								for (final Object so : sashOps) {
									final Object[] lites = ((OpeningObject) so).dloMid.anchorsV
											.toArray();
									if (lites.length > 0) {
										doVGridDims(
												((OpeningObject) so).dloMid,
												lites);
									}

									// .toArray();
									// myFrame2.topTextsModo
									// =
									// new
									// int[lites.length];
									// for
									// (final Object soe
									// : lites)
									// {
									// if
									// (((OpeningObject)
									// soe).startRow == 1)
									// {
									// this
									// .doGridTopDimsOLD(((OpeningObject)
									// soe));
									// }
									// }

								}
							}

						}
						if (((OpeningObject) myOpening).contentMid == 1) {

							final Object[] lites = ((OpeningObject) myOpening).dloMid.anchorsV
									.toArray();
							if (lites.length > 0) {
								doVGridDims(((OpeningObject) myOpening).dloMid,
										lites);
							}

						}
					}// pos
					else if (pos == 3) {
						if (((OpeningObject) myOpening).contentOut == 2) {
							final Object[] leafs = ((OpeningObject) myOpening).sashObjectOut.frames
									.toArray();
							for (final Object s : leafs) {
								final Object[] sashOps = ((SashLeaf) s).openings
										.toArray();
								for (final Object so : sashOps) {
									// final
									// Object[] lites
									// =
									// ((OpeningObject)
									// so).dloOut.openings
									// .toArray();
									// myFrame2.topTextsModo
									// =
									// new
									// int[lites.length];
									// for
									// (final Object soe
									// : lites)
									// {
									// if
									// (((OpeningObject)
									// soe).startRow == 1)
									// {
									// this
									// .doGridTopDimsOLD(((OpeningObject)
									// soe));
									// }
									// }

									final Object[] lites = ((OpeningObject) so).dloOut.anchorsV
											.toArray();
									if (lites.length > 0) {
										doVGridDims(
												((OpeningObject) so).dloOut,
												lites);
									}

								}
							}

						}
						if (((OpeningObject) myOpening).contentOut == 1) {

							// final
							// Object[] lites =
							// ((OpeningObject)
							// myOpening).dloOut.openings
							// .toArray();
							// myFrame2.topTextsModo
							// =
							// new
							// int[lites.length];
							// for
							// (final Object soe :
							// lites)
							// {
							// if
							// (((OpeningObject)
							// soe).startRow == 1)
							// {
							// this
							// .doGridTopDimsOLD(((OpeningObject)
							// soe));
							// }
							// }

							final Object[] lites = ((OpeningObject) myOpening).dloOut.anchorsV
									.toArray();
							if (lites.length > 0) {
								doVGridDims(((OpeningObject) myOpening).dloOut,
										lites);
							}

						}
					}// pos

				}// Row
				if (((OpeningObject) myOpening).startCol <= col
						&& ((OpeningObject) myOpening).endCol >= col) {
					if (pos == 1) {
						if (((OpeningObject) myOpening).contentIn == 2) {
							final Object[] leafs = ((OpeningObject) myOpening).sashObjectIn.frames
									.toArray();
							for (final Object s : leafs) {
								final Object[] sashOps = ((SashLeaf) s).openings
										.toArray();
								for (final Object so : sashOps) {
									// final
									// Object[] lites
									// =
									// ((OpeningObject)
									// so).dloIn.openings
									// .toArray();
									// myFrame2.leftTextsModo
									// =
									// new
									// int[lites.length];
									// for
									// (final Object soe
									// : lites)
									// {
									// if
									// (((OpeningObject)
									// soe).startCol == 1)
									// {
									// this
									// .doGridLeftDimsOLD(((OpeningObject)
									// soe));
									// }
									// }
									final Object[] lites = ((OpeningObject) so).dloIn.anchorsH
											.toArray();
									if (lites.length > 0) {
										doHGridDims(((OpeningObject) so).dloIn,
												lites);
									}

								}
							}

						}
						if (((OpeningObject) myOpening).contentIn == 1) {

							// final
							// Object[] lites =
							// ((OpeningObject)
							// myOpening).dloIn.openings
							// .toArray();
							// myFrame2.leftTextsModo
							// =
							// new
							// int[lites.length];
							// for
							// (final Object soe :
							// lites)
							// {
							// if
							// (((OpeningObject)
							// soe).startCol == 1)
							// {
							// this
							// .doGridLeftDimsOLD(((OpeningObject)
							// soe));
							// }
							// }

							final Object[] lites = ((OpeningObject) myOpening).dloIn.anchorsH
									.toArray();
							if (lites.length > 0) {
								doHGridDims(((OpeningObject) myOpening).dloIn,
										lites);
							}

						}
					}// pos
					else if (pos == 2) {
						if (((OpeningObject) myOpening).contentMid == 2) {
							final Object[] leafs = ((OpeningObject) myOpening).sashObjectMid.frames
									.toArray();
							for (final Object s : leafs) {
								final Object[] sashOps = ((SashLeaf) s).openings
										.toArray();
								for (final Object so : sashOps) {
									// final
									// Object[] lites
									// =
									// ((OpeningObject)
									// so).dloMid.openings
									// .toArray();
									// myFrame2.leftTextsModo
									// =
									// new
									// int[lites.length];
									// for
									// (final Object so2
									// : lites)
									// {
									// if
									// (((OpeningObject)
									// so2).startCol == 1)
									// {
									// this
									// .doGridLeftDimsOLD(((OpeningObject)
									// so2));
									// }
									// }
									final Object[] lites = ((OpeningObject) so).dloMid.anchorsH
											.toArray();
									if (lites.length > 0) {
										doHGridDims(
												((OpeningObject) so).dloMid,
												lites);
									}

								}
							}

						}
						if (((OpeningObject) myOpening).contentMid == 1) {

							// final
							// Object[] lites =
							// ((OpeningObject)
							// myOpening).dloMid.openings
							// .toArray();
							// myFrame2.leftTextsModo
							// =
							// new
							// int[lites.length];
							// for
							// (final Object so2 :
							// lites)
							// {
							// if
							// (((OpeningObject)
							// so2).startCol == 1)
							// {
							// this
							// .doGridLeftDimsOLD(((OpeningObject)
							// so2));
							// }
							// }

							final Object[] lites = ((OpeningObject) myOpening).dloMid.anchorsH
									.toArray();
							if (lites.length > 0) {
								doHGridDims(((OpeningObject) myOpening).dloMid,
										lites);
							}

						}
					}// pos
					else if (pos == 3) {
						if (((OpeningObject) myOpening).contentOut == 2) {
							final Object[] leafs = ((OpeningObject) myOpening).sashObjectOut.frames
									.toArray();
							for (final Object s : leafs) {
								final Object[] sashOps = ((SashLeaf) s).openings
										.toArray();
								for (final Object so : sashOps) {
									// final
									// Object[] lites
									// =
									// ((OpeningObject)
									// so).dloOut.openings
									// .toArray();
									// myFrame2.leftTextsModo
									// =
									// new
									// int[lites.length];
									// for
									// (final Object so2
									// : lites)
									// {
									// if
									// (((OpeningObject)
									// so2).startCol == 1)
									// {
									// this
									// .doGridLeftDimsOLD(((OpeningObject)
									// so2));
									// }
									// }
									final Object[] lites = ((OpeningObject) so).dloOut.anchorsH
											.toArray();
									if (lites.length > 0) {
										doHGridDims(
												((OpeningObject) so).dloOut,
												lites);
									}

								}
							}

						}
						if (((OpeningObject) myOpening).contentOut == 1) {

							// final
							// Object[] lites =
							// ((OpeningObject)
							// myOpening).dloOut.openings
							// .toArray();
							// myFrame2.leftTextsModo
							// =
							// new
							// int[lites.length];
							// for
							// (final Object so2 :
							// lites)
							// {
							// if
							// (((OpeningObject)
							// so2).startCol == 1)
							// {
							// this
							// .doGridLeftDimsOLD(((OpeningObject)
							// so2));
							// }
							// }
							final Object[] lites = ((OpeningObject) myOpening).dloOut.anchorsH
									.toArray();
							if (lites.length > 0) {
								doHGridDims(((OpeningObject) myOpening).dloOut,
										lites);
							}
						}
					}// pos

				}// Row
			}
		}
	}

	public void doVGridDims(final DLO dlo, final Object[] lites) {

		// if (myFrame2.myTopPanel.metric.isSelected()) {
		// myScale = myFrame2.scale.multiply(new BigDecimal(100));
		// } else {
		myScale = myFrame2.scale;
		// }

		// myFrame2.topTextsModo =
		// new int[lites.length+1];

		final double[] av = new double[lites.length];
		int count = 0;
		for (final Object soe : lites) {

			av[count] = Double.parseDouble(soe.toString());
			count++;

		}
		double lastAnchor = 0;

		Grids myGrid = myFrame2.getApplicationBaseRules().getGrids(dlo.gridID);
		double thick = 0;
		double mythick = 0;
		if (myFrame2.currentUOM == 1) {
			thick = myGrid.getThickness();
		} else {
			thick = myGrid.getThicknessImp();
		}

		mythick = thick / 2 * myFrame2.scale.doubleValue();

		for (int i = 0; i < dlo.xCols; i++) {
			if (i == 0) {

				this.doGridTopDimsNEW(av[i] - dlo.startingX - mythick, mythick,
						i + 1, dlo.startingX, dlo.xCols);
				lastAnchor = av[i];

			} else if (i < dlo.xCols - 1) {

				this.doGridTopDimsNEW(av[i] - lastAnchor - thick
						* myFrame2.scale.doubleValue(), mythick, i + 1,
						lastAnchor + mythick, dlo.xCols);
				lastAnchor = av[i];

			} else {
				final double width = dlo.top1Part.endX - lastAnchor - mythick;
				this.doGridTopDimsNEW(width, mythick, i + 1, lastAnchor
						+ mythick, dlo.xCols);

			}
		}
	}

	public void doHGridDims(final DLO dlo, final Object[] lites) {

		// if (myFrame2.myTopPanel.metric.isSelected()) {
		// myScale = myFrame2.scale.doubleValue().multiply(new BigDecimal(100));
		// } else {
		myScale = myFrame2.scale;
		// }

		//
		// myFrame2.leftTextsModo =
		// new int[lites.length+1];
		final double[] ah = new double[lites.length];
		int count = 0;
		for (final Object soe : lites) {

			ah[count] = Double.parseDouble(soe.toString());
			count++;

		}
		double lastAnchor = 0;

		Grids myGrid = myFrame2.getApplicationBaseRules().getGrids(dlo.gridID);
		double thick = 0;
		double mythick = 0;
		if (myFrame2.currentUOM == 1) {
			thick = myGrid.getThickness();
		} else {
			thick = myGrid.getThicknessImp();
		}

		mythick = thick / 2 * myFrame2.scale.doubleValue();

		for (int i = 0; i < dlo.yRows; i++) {
			if (i == 0) {

				this.doGridLeftDimsNEW(ah[i] - dlo.highestY - mythick, mythick,
						i + 1, dlo.highestY, dlo.yRows);
				lastAnchor = ah[i];

			} else if (i < dlo.yRows - 1) {

				this.doGridLeftDimsNEW(ah[i] - lastAnchor - thick
						* myFrame2.scale.doubleValue(), mythick, i + 1,
						lastAnchor + mythick, dlo.yRows);
				lastAnchor = ah[i];

			} else {
				final double height = dlo.lowestY - lastAnchor - mythick;
				this.doGridLeftDimsNEW(height, mythick, i + 1, lastAnchor
						+ mythick, dlo.yRows);

			}
		}
	}

	public void doOpeningTopDims(final boolean isSash, final boolean visible) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		double SX = 0;
		double EX = 0;
		double SXc = 0;
		double EXc = 0;

		SX = Math.min(startingX, bX4);
		EX = Math.max(bX2, bX3);

		if (myFrame2.selectedDim == 5) {

			SX = Math.min(startingCX, bCX4);
			EX = Math.max(bCX2, bCX3);

		} else if (myFrame2.selectedDim == 6) {

			SX = Math.min(startingX, bX4);
			EX = Math.max(bX2, bX3);

		}

		SXc = Math.min(startingCX, bCX4);

		EXc = Math.max(bCX2, bCX3);

		if (myFrame2.selectedDim == 5) {

			if (this.leftIn) {
				SX = Math.min(startingCX, bCX4);

			}
			if (this.rightIn) {
				EX = Math.max(bCX2, bCX3);

			}

		}

		String w = "";

		if (myFrame2.myTopPanel.metric.isSelected()) {
			w = myFrame2.oneDecimal.format(UOMConvert.getBigDecimalConversion(
					(EX - SX), myScale, 2));
			myFrame2.colTextObjects.add(w);
		} else if (myFrame2.myTopPanel.impDec.isSelected()) {
			w = myFrame2.sixDecimal.format(UOMConvert.getBigDecimalConversion(
					(EX - SX), myScale, 2) / 64);
			myFrame2.colTextObjects.add(w);
		} else if (myFrame2.myTopPanel.impFrac.isSelected()) {

			try {
				w = UOMConvert
						.imperialToFraction("".concat(String.valueOf(String
								.valueOf(UOMConvert.getBigDecimalConversion(
										(EX - SX), myScale, 2) / 64))));
				myFrame2.colTextObjects.add(w);
			} catch (final Exception e) {

				e.printStackTrace();
			}

		}
		// //////
		w = "";

		if (myFrame2.myTopPanel.metric.isSelected()) {
			w = myFrame2.oneDecimal.format(UOMConvert.getBigDecimalConversion(
					(EXc - SXc), myScale, 2));
			myFrame2.colTextObjectsc.add(w);
		} else if (myFrame2.myTopPanel.impDec.isSelected()) {
			w = myFrame2.sixDecimal.format(UOMConvert.getBigDecimalConversion(
					(EXc - SXc), myScale, 2) / 64);
			myFrame2.colTextObjectsc.add(w);
		} else if (myFrame2.myTopPanel.impFrac.isSelected()) {

			try {
				w = UOMConvert.imperialToFraction("".concat(String
						.valueOf(String.valueOf(UOMConvert
								.getBigDecimalConversion((EXc - SXc), myScale,
										2) / 64))));
				myFrame2.colTextObjectsc.add(w);
			} catch (final Exception e) {
				e.printStackTrace();
			}

		}

		myFrame2.colTextPosXs.add(SX);

		myFrame2.colTextPosXe.add(SX + EX - SX);

		myFrame2.colTextPosXsc.add(SXc);

		myFrame2.colTextPosXec.add(EXc);

		myFrame2.textTop = new TextFieldTop();

		myFrame2.textTop.size = EX - SX;

		myFrame2.textTop.sizeC = EXc - SXc;

		myFrame2.textTop.pos = SX;

		myFrame2.textTop.pose = SX + EX - SX;

		myFrame2.textTop.posc = SXc;

		myFrame2.textTop.posec = EXc;

		myFrame2.textTop.startRowCol = startCol;

		myFrame2.textTop.endRowCol = endCol;

		myFrame2.textTop.deltaL = Math.abs(SXc - SX);

		myFrame2.textTop.deltaR = Math.abs(EX - EXc);

		myFrame2.textTop.parent = this;
		myFrame2.textTop.isSash = isSash;
		myFrame2.textTop.visible = visible;

		myFrame2.textTop.colNo = this.startCol;
		// myOverall.countTopo;
		myFrame2.textTop.seqID = myFrame2.topTexts.size() + 1;
		myFrame2.topTexts.add(myFrame2.textTop);
	}

	@SuppressWarnings("unchecked")
	public void doOpeningLeftDims(final boolean isSash, final boolean visible) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		double SY = this.highestY;

		double EY = this.lowestY;

		double SYc = this.highestYC;

		double EYc = this.lowestYC;

		if (myFrame2.selectedDim == 5) {

			SY = highestYC;
			EY = lowestYC;

		} else if (myFrame2.selectedDim == 6) {

			SY = highestY;
			EY = lowestY;

		}

		String h = "";

		if (myFrame2.myTopPanel.metric.isSelected()) {
			h = myFrame2.oneDecimal.format(UOMConvert.getBigDecimalConversion(
					(EY - SY), myScale, 2));
			myFrame2.rowTextObjects.add(h);
		} else if (myFrame2.myTopPanel.impDec.isSelected()) {
			h = myFrame2.sixDecimal.format(UOMConvert.getBigDecimalConversion(
					(EY - SY), myScale, 2) / 64);
			myFrame2.rowTextObjects.add(h);
		} else if (myFrame2.myTopPanel.impFrac.isSelected()) {

			try {
				h = UOMConvert
						.imperialToFraction("".concat(String.valueOf(String
								.valueOf(UOMConvert.getBigDecimalConversion(
										(EY - SY), myScale, 2) / 64))));
				myFrame2.rowTextObjects.add(h);
			} catch (final Exception e) {
				// TODO Auto-generated catch
				// block
				e.printStackTrace();
			}

		}
		// //////////

		h = "";

		if (myFrame2.myTopPanel.metric.isSelected()) {
			h = myFrame2.oneDecimal.format(UOMConvert.getBigDecimalConversion(
					(EYc - SYc), myScale, 2));
			myFrame2.rowTextObjectsc.add(h);
		} else if (myFrame2.myTopPanel.impDec.isSelected()) {
			h = myFrame2.sixDecimal.format(UOMConvert.getBigDecimalConversion(
					(EYc - SYc), myScale, 2) / 64f);

			myFrame2.rowTextObjectsc.add(h);
		} else if (myFrame2.myTopPanel.impFrac.isSelected()) {

			try {
				h = UOMConvert.imperialToFraction("".concat(String
						.valueOf(String.valueOf(UOMConvert
								.getBigDecimalConversion((EYc - SYc), myScale,
										2) / 64))));
				myFrame2.rowTextObjectsc.add(h);
			} catch (final Exception e) {
				// TODO Auto-generated catch
				// block
				e.printStackTrace();
			}

		}

		myFrame2.rowTextPosYs.add(SY);

		myFrame2.rowTextPosYe.add(lowestY);

		myFrame2.rowTextPosYsc.add(SYc);

		myFrame2.rowTextPosYec.add(lowestYC);

		myFrame2.textLeft = new TextFieldLeft();

		myFrame2.textLeft.size = lowestY - highestY;

		myFrame2.textLeft.sizeC = lowestYC - highestYC;

		myFrame2.textLeft.pos = SY;

		myFrame2.textLeft.pose = lowestY;

		myFrame2.textLeft.posc = SYc;

		myFrame2.textLeft.posec = lowestYC;

		myFrame2.textLeft.startRowCol = startRow;

		myFrame2.textLeft.endRowCol = endRow;

		myFrame2.textLeft.deltaLT = Math.abs(SYc - SY);

		myFrame2.textLeft.deltaRB = Math.abs(lowestYC - lowestY);

		myFrame2.textLeft.parent = this;
		myFrame2.textLeft.isSash = isSash;
		myFrame2.textLeft.visible = visible;

		myFrame2.textLeft.rowNo = startRow;
		// myFacet.countLefto;
		myFrame2.textLeft.seqID = myFrame2.leftTexts.size() + 1;
		myFrame2.leftTexts.add(myFrame2.textLeft);
	}

	public void doGridTopDimsNEW(final double width, final double halfThick,
			final int num, final double startX, final int cols) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		double startingX = 0;
		double endX = 0;
		double startingXc = 0;
		double endXc = 0;

		startingX = startX;
		startingXc = startX;

		endX = startingX + width;
		endXc = endX;

		String w = "";

		if (myFrame2.myTopPanel.metric.isSelected()) {
			w = myFrame2.oneDecimal.format(UOMConvert.getBigDecimalConversion(
					(endX - startingX), myScale, 2));

			myFrame2.colTextObjects.add(w);
		} else if (myFrame2.myTopPanel.impDec.isSelected()) {
			w = myFrame2.sixDecimal.format(UOMConvert.getBigDecimalConversion(
					(endX - startingX), myScale, 2) / 64);

			myFrame2.colTextObjects.add(w);
		} else if (myFrame2.myTopPanel.impFrac.isSelected()) {

			try {
				w = UOMConvert.imperialToFraction("".concat(String
						.valueOf(String.valueOf(UOMConvert
								.getBigDecimalConversion((endX - startingX),
										myScale, 2) / 64))));

				myFrame2.colTextObjects.add(w);
			} catch (final Exception e) {
				// TODO Auto-generated catch
				// block
				e.printStackTrace();
			}

		}

		myFrame2.colTextPosXs.add(startingX);
		myFrame2.colTextPosXe.add(startingX + endX - startingX);
		myFrame2.colTextObjectsc.add(myFrame2.sixDecimal
				.format((endXc - startingXc) * myScale.doubleValue()));
		myFrame2.colTextPosXsc.add(startingXc);
		myFrame2.colTextPosXec.add(endXc);
		myFrame2.textTop = new TextFieldTop();
		myFrame2.textTop.size = endX - startingX;
		myFrame2.textTop.sizeC = endXc - startingXc;
		myFrame2.textTop.pos = startingX;
		myFrame2.textTop.pose = startingX + endX - startingX;

		myFrame2.textTop.posc = startingXc;
		myFrame2.textTop.posec = endXc;
		myFrame2.textTop.startRowCol = num;
		myFrame2.textTop.endRowCol = num;
		myFrame2.textTop.deltaL = Math.abs(startingXc - startingX);
		myFrame2.textTop.deltaR = Math.abs(endX - endXc);

		myFrame2.textTop.colNo = num;
		myFrame2.textTop.seqID = myFrame2.topTexts.size() + 1;
		myFrame2.topTexts.add(myFrame2.textTop);

	}

	public void doGridLeftDimsNEW(final double height, final double halfThick,
			final int num, final double startY, final int rows) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		double sYC = 0;
		double sY = 0;

		double eY = 0;
		sY = sYC = startY;

		eY = sY + height;

		String h = "";

		if (myFrame2.myTopPanel.metric.isSelected()) {
			h = myFrame2.oneDecimal.format(UOMConvert.getBigDecimalConversion(
					(eY - sY), myScale, 2));
			myFrame2.rowTextObjects.add(h);
		} else if (myFrame2.myTopPanel.impDec.isSelected()) {
			h = myFrame2.sixDecimal.format(UOMConvert.getBigDecimalConversion(
					(eY - sY), myScale, 2) / 64);
			myFrame2.rowTextObjects.add(h);
		} else if (myFrame2.myTopPanel.impFrac.isSelected()) {

			try {
				h = UOMConvert
						.imperialToFraction("".concat(String.valueOf(String
								.valueOf(UOMConvert.getBigDecimalConversion(
										(eY - sY), myScale, 2) / 64))));
				myFrame2.rowTextObjects.add(h);
			} catch (final Exception e) {
				// TODO Auto-generated catch
				// block
				e.printStackTrace();
			}

		}

		myFrame2.rowTextPosYs.add(sY);
		myFrame2.rowTextPosYe.add(eY);// startingY
		// +
		// opening.height);
		myFrame2.rowTextObjectsc.add(myFrame2.sixDecimal.format((eY - sYC)
				* myScale.doubleValue()));
		myFrame2.rowTextPosYsc.add(sYC);
		myFrame2.rowTextPosYec.add(eY);// startingYC
		// +
		// endYC -
		// startingYC);

		myFrame2.textLeft = new TextFieldLeft();
		myFrame2.textLeft.size = eY - sY;
		myFrame2.textLeft.sizeC = eY - sY;// height;//endYC
		// -
		// startingYC;//

		myFrame2.textLeft.pos = sY;
		myFrame2.textLeft.pose = eY;// endY;
		myFrame2.textLeft.posc = sYC;
		myFrame2.textLeft.posec = eY;// endYC;
		myFrame2.textLeft.startRowCol = num;
		myFrame2.textLeft.endRowCol = num;
		myFrame2.textLeft.deltaLT = Math.abs(sYC - sY);

		myFrame2.textLeft.deltaRB = Math.abs(eY - eY);

		myFrame2.textLeft.rowNo = num;
		// myFrame2.textLeft.rowNo+1;
		myFrame2.textLeft.seqID = myFrame2.leftTexts.size() + 1;
		myFrame2.leftTexts.add(myFrame2.textLeft);
	}

	public void doGridTopDimsOLD(final OpeningObject opening) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		double startingX = 0;
		double endX = 0;
		double startingXc = 0;
		double endXc = 0;

		startingX = opening.startingX;
		startingXc = opening.startingCX;

		endX = opening.bX2;
		endXc = opening.bCX2;
		//
		// myFrame2.colTextObjects
		// .add(myFrame2.sixDecimal
		// .format((endX - startingX) *
		// myScale));

		String w = "";

		if (myFrame2.myTopPanel.metric.isSelected()) {
			w = myFrame2.oneDecimal.format(UOMConvert.getBigDecimalConversion(
					(endX - startingX), myScale, 2));

			myFrame2.colTextObjects.add(w);
		} else if (myFrame2.myTopPanel.impDec.isSelected()) {
			w = myFrame2.sixDecimal.format(UOMConvert.getBigDecimalConversion(
					(endX - startingX), myScale, 2) / 64);

			myFrame2.colTextObjects.add(w);
		} else if (myFrame2.myTopPanel.impFrac.isSelected()) {

			try {
				w = UOMConvert.imperialToFraction("".concat(String
						.valueOf(String.valueOf(UOMConvert
								.getBigDecimalConversion((endX - startingX),
										myScale, 2) / 64))));

				myFrame2.colTextObjects.add(w);
			} catch (final Exception e) {
				// TODO Auto-generated catch
				// block
				e.printStackTrace();
			}

		}

		myFrame2.colTextPosXs.add(startingX);
		myFrame2.colTextPosXe.add(startingX + endX - startingX);
		myFrame2.colTextObjectsc.add(myFrame2.sixDecimal
				.format((endXc - startingXc) * myScale.doubleValue()));
		myFrame2.colTextPosXsc.add(startingXc);
		myFrame2.colTextPosXec.add(endXc);
		myFrame2.textTop = new TextFieldTop();
		myFrame2.textTop.size = endX - startingX;
		myFrame2.textTop.sizeC = endXc - startingXc;
		myFrame2.textTop.pos = startingX;
		myFrame2.textTop.pose = startingX + endX - startingX;

		myFrame2.textTop.posc = startingXc;
		myFrame2.textTop.posec = endXc;
		myFrame2.textTop.startRowCol = opening.startCol;
		myFrame2.textTop.endRowCol = opening.endCol;
		myFrame2.textTop.deltaL = Math.abs(startingXc - startingX);
		myFrame2.textTop.deltaR = Math.abs(endX - endXc);

		myFrame2.textTop.colNo = startCol;
		myFrame2.textTop.seqID = myFrame2.topTexts.size() + 1;
		myFrame2.topTexts.add(myFrame2.textTop);
	}

	public void doGridLeftDimsOLD(final OpeningObject opening) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		double sYC = 0;
		double sY = 0;

		sY = sYC = Math.min(opening.highestY, opening.bY2);

		// myFrame2.rowTextObjects
		// .add(myFrame2.sixDecimal
		// .format((opening.bY4-sY) *
		// myScale));

		String h = "";

		if (myFrame2.myTopPanel.metric.isSelected()) {
			h = myFrame2.oneDecimal.format(UOMConvert.getBigDecimalConversion(
					(opening.bY4 - sY), myScale, 2));
			myFrame2.rowTextObjects.add(h);
		} else if (myFrame2.myTopPanel.impDec.isSelected()) {
			h = myFrame2.sixDecimal.format(UOMConvert.getBigDecimalConversion(
					(opening.bY4 - sY), myScale, 2) / 64);
			myFrame2.rowTextObjects.add(h);
		} else if (myFrame2.myTopPanel.impFrac.isSelected()) {

			try {
				h = UOMConvert.imperialToFraction("".concat(String
						.valueOf(String.valueOf(UOMConvert
								.getBigDecimalConversion((opening.bY4 - sY),
										myScale, 2) / 64))));
				myFrame2.rowTextObjects.add(h);
			} catch (final Exception e) {
				// TODO Auto-generated catch
				// block
				e.printStackTrace();
			}

		}

		myFrame2.rowTextPosYs.add(sY);
		myFrame2.rowTextPosYe.add(opening.bY4);// startingY
		// +
		// opening.height);
		myFrame2.rowTextObjectsc.add(myFrame2.sixDecimal
				.format((opening.bCY4 - sYC) * myScale.doubleValue()));
		myFrame2.rowTextPosYsc.add(sYC);
		myFrame2.rowTextPosYec.add(opening.bCY4);// startingYC
		// +
		// endYC -
		// startingYC);

		myFrame2.textLeft = new TextFieldLeft();
		myFrame2.textLeft.size = opening.bY4 - sY;
		myFrame2.textLeft.sizeC = opening.bY4 - sY;// height;//endYC
		// -
		// startingYC;//

		myFrame2.textLeft.pos = sY;
		myFrame2.textLeft.pose = opening.bY4;// endY;
		myFrame2.textLeft.posc = sYC;
		myFrame2.textLeft.posec = opening.bCY4;// endYC;
		myFrame2.textLeft.startRowCol = opening.startRow;
		myFrame2.textLeft.endRowCol = opening.endRow;
		myFrame2.textLeft.deltaLT = Math.abs(sYC - sY);

		myFrame2.textLeft.deltaRB = Math.abs(opening.bCY4 - opening.bY4);

		myFrame2.textLeft.rowNo = myFrame2.textLeft.rowNo + 1;
		myFrame2.textLeft.seqID = myFrame2.leftTexts.size() + 1;
		myFrame2.leftTexts.add(myFrame2.textLeft);
	}

	public void doOpeningTopDimsBkgrd(final boolean isSash) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		double startingX = 0;
		double endX = 0;
		double startingXc = 0;
		double endXc = 0;
		if (startingX == 0) {
			startingX = startingXc = bkgrdStartX;

		} else {
			startingX = startingX;
			startingXc = startingCX;
		}
		if (!leftIn && startingX > myParent.bOpeningObject.startingX) {
			startingX = myParent.bOpeningObject.startingX;
			startingXc = myParent.bOpeningObject.startingCX;
		}

		endX = bX2;
		endXc = bCX2;
		if (!rightIn && startingX >= myParent.bOpeningObject.startingX) {
			endX = myParent.bOpeningObject.bX2;
			endXc = myParent.bOpeningObject.bCX2;
		}

		String w = "";

		if (myFrame2.myTopPanel.metric.isSelected()) {
			w = myFrame2.oneDecimal.format(UOMConvert.getBigDecimalConversion(
					(endX - startingX), myScale, 2));
			myFrame2.colTextObjects.add(w);
		} else if (myFrame2.myTopPanel.impDec.isSelected()) {
			w = myFrame2.sixDecimal.format(UOMConvert.getBigDecimalConversion(
					(endX - startingX), myScale, 2) / 64);
			myFrame2.colTextObjects.add(w);
		} else if (myFrame2.myTopPanel.impFrac.isSelected()) {

			try {
				w = UOMConvert.imperialToFraction("".concat(String
						.valueOf(String.valueOf(UOMConvert
								.getBigDecimalConversion((endX - startingX),
										myScale, 2) / 64))));
				myFrame2.colTextObjects.add(w);
			} catch (final Exception e) {
				// TODO Auto-generated catch
				// block
				e.printStackTrace();
			}

		}

		myFrame2.colTextPosXs.add(startingX);
		myFrame2.colTextPosXe.add(startingX + endX - startingX);

		w = "";

		if (myFrame2.myTopPanel.metric.isSelected()) {
			w = myFrame2.oneDecimal.format(UOMConvert.getBigDecimalConversion(
					(endXc - startingXc), myScale, 2));
			myFrame2.colTextObjectsc.add(w);
		} else if (myFrame2.myTopPanel.impDec.isSelected()) {
			w = myFrame2.sixDecimal.format(UOMConvert.getBigDecimalConversion(
					(endXc - startingXc), myScale, 2) / 64);
			myFrame2.colTextObjectsc.add(w);
		} else if (myFrame2.myTopPanel.impFrac.isSelected()) {

			try {
				w = UOMConvert.imperialToFraction("".concat(String
						.valueOf(String.valueOf(UOMConvert
								.getBigDecimalConversion((endXc - startingXc),
										myScale, 2) / 64))));
				myFrame2.colTextObjectsc.add(w);
			} catch (final Exception e) {
				// TODO Auto-generated catch
				// block
				e.printStackTrace();
			}

		}
		myFrame2.colTextPosXsc.add(startingXc);
		myFrame2.colTextPosXec.add(endXc);
		myFrame2.textTop = new TextFieldTop();
		myFrame2.textTop.size = endX - startingX;
		myFrame2.textTop.sizeC = endXc - startingXc;
		myFrame2.textTop.pos = startingX;
		myFrame2.textTop.pose = startingX + endX - startingX;

		myFrame2.textTop.posc = startingXc;
		myFrame2.textTop.posec = endXc;
		myFrame2.textTop.startRowCol = startCol;
		myFrame2.textTop.endRowCol = endCol;
		myFrame2.textTop.deltaL = Math.abs(startingXc - startingX);
		myFrame2.textTop.deltaR = Math.abs(endX - endXc);

		myFrame2.textTop.colNo = startCol;

		myFrame2.textTop.seqID = myFrame2.topTexts.size() + 1;
		myFrame2.textTop.parent = this;
		myFrame2.textTop.isSash = isSash;

		myFrame2.topTexts.add(myFrame2.textTop);
	}

	public void doOpeningLeftDimsBkgrd(final boolean isSash) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		double sYC = 0;
		double sY = 0;

		if (!topIn) {
			sYC = Math.min(myParent.highestY, Math.min(startingCY, bCY2));// highestY;//highestCYL;
		} else {
			sYC = Math.min(startingCY, bCY2);// highestY;//highestCYL;
		}

		sY = Math.min(highestY, bY2);

		// myFrame2.rowTextObjects
		// .add(myFrame2.sixDecimal
		// .format( height *
		// myScale));

		String h = "";

		if (myFrame2.myTopPanel.metric.isSelected()) {
			h = myFrame2.oneDecimal.format(UOMConvert.getBigDecimalConversion(
					heightPix, myScale, 2));
			myFrame2.rowTextObjects.add(h);
		} else if (myFrame2.myTopPanel.impDec.isSelected()) {
			h = myFrame2.sixDecimal.format(UOMConvert.getBigDecimalConversion(
					heightPix, myScale, 2) / 64);
			myFrame2.rowTextObjects.add(h);
		} else if (myFrame2.myTopPanel.impFrac.isSelected()) {

			try {
				h = UOMConvert
						.imperialToFraction("".concat(String.valueOf(String
								.valueOf(UOMConvert.getBigDecimalConversion(
										heightPix, myScale, 2) / 64))));
				myFrame2.rowTextObjects.add(h);
			} catch (final Exception e) {
				// TODO Auto-generated catch
				// block
				e.printStackTrace();
			}

		}

		myFrame2.rowTextPosYs.add(sY);
		myFrame2.rowTextPosYe.add(bY4);

		h = "";

		if (myFrame2.myTopPanel.metric.isSelected()) {
			h = myFrame2.oneDecimal.format(UOMConvert.getBigDecimalConversion(
					(bCY4 - sYC), myScale, 2));
			myFrame2.rowTextObjectsc.add(h);
		} else if (myFrame2.myTopPanel.impDec.isSelected()) {
			h = myFrame2.sixDecimal.format(UOMConvert.getBigDecimalConversion(
					(bCY4 - sYC), myScale, 2) / 64f);

			myFrame2.rowTextObjectsc.add(h);
		} else if (myFrame2.myTopPanel.impFrac.isSelected()) {

			try {
				h = UOMConvert.imperialToFraction("".concat(String
						.valueOf(String.valueOf(UOMConvert
								.getBigDecimalConversion((bCY4 - sYC), myScale,
										2) / 64))));
				myFrame2.rowTextObjectsc.add(h);
			} catch (final Exception e) {
				// TODO Auto-generated catch
				// block
				e.printStackTrace();
			}

		}

		myFrame2.rowTextPosYsc.add(sYC);
		myFrame2.rowTextPosYec.add(bCY4);// startingYC
		// +
		// endYC -
		// startingYC);

		myFrame2.textLeft = new TextFieldLeft();
		myFrame2.textLeft.size = heightPix;
		myFrame2.textLeft.sizeC = lowestYC - highestYC;

		myFrame2.textLeft.pos = sY;
		myFrame2.textLeft.pose = bY4;// endY;
		myFrame2.textLeft.posc = sYC;
		myFrame2.textLeft.posec = bCY4;// endYC;
		myFrame2.textLeft.startRowCol = startRow;
		myFrame2.textLeft.endRowCol = endRow;
		myFrame2.textLeft.deltaLT = Math.abs(sYC - sY);

		myFrame2.textLeft.deltaRB = Math.abs(bCY4 - bY4);

		myFrame2.textLeft.rowNo = startRow;

		myFrame2.textLeft.seqID = myFrame2.leftTexts.size() + 1;
		myFrame2.textLeft.parent = opening;
		myFrame2.textLeft.isSash = isSash;

		myFrame2.leftTexts.add(myFrame2.textLeft);
	}

	public void doOpeningTopDimsSash(final SashLeaf opening) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		double startingX = 0;
		double endX = 0;
		double startingXc = 0;
		double endXc = 0;

		startingX = opening.startingX;
		startingXc = opening.startingX;

		endX = opening.bX2;
		endXc = opening.bX2;

		String w = "";

		if (myFrame2.myTopPanel.metric.isSelected()) {
			w = myFrame2.oneDecimal.format(UOMConvert.getBigDecimalConversion(
					(endX - startingX), myScale, 2));
			myFrame2.colTextObjects.add(w);
		} else if (myFrame2.myTopPanel.impDec.isSelected()) {
			w = myFrame2.sixDecimal.format(UOMConvert.getBigDecimalConversion(
					(endX - startingX), myScale, 2) / 64);
			myFrame2.colTextObjects.add(w);
		} else if (myFrame2.myTopPanel.impFrac.isSelected()) {

			try {
				w = UOMConvert.imperialToFraction("".concat(String
						.valueOf(String.valueOf(UOMConvert
								.getBigDecimalConversion((endX - startingX),
										myScale, 2) / 64))));
				myFrame2.colTextObjects.add(w);
			} catch (final Exception e) {
				// TODO Auto-generated catch
				// block
				e.printStackTrace();
			}

		}

		myFrame2.colTextPosXs.add(startingX);
		myFrame2.colTextPosXe.add(startingX + endX - startingX);
		myFrame2.colTextObjectsc.add(myFrame2.sixDecimal
				.format((endXc - startingXc) * myScale.doubleValue()));
		myFrame2.colTextPosXsc.add(startingXc);
		myFrame2.colTextPosXec.add(endXc);
		myFrame2.textTop = new TextFieldTop();
		myFrame2.textTop.size = endX - startingX;
		myFrame2.textTop.sizeC = endXc - startingXc;
		myFrame2.textTop.pos = startingX;
		myFrame2.textTop.pose = startingX + endX - startingX;

		myFrame2.textTop.posc = startingXc;
		myFrame2.textTop.posec = endXc;
		myFrame2.textTop.startRowCol = opening.startCol;
		myFrame2.textTop.endRowCol = opening.endCol;
		myFrame2.textTop.deltaL = Math.abs(startingXc - startingX);
		myFrame2.textTop.deltaR = Math.abs(endX - endXc);

		myFrame2.textTop.colNo = opening.startCol;
		myFrame2.textTop.seqID = myFrame2.topTexts.size() + 1;
		myFrame2.textTop.parent = opening;
		myFrame2.textTop.isSash = true;
		myFrame2.topTexts.add(myFrame2.textTop);
	}

	public void doOpeningLeftDimsSash(final ShapeObject opening) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		double sYC = 0;
		double sY = 0;

		sYC = Math.min(opening.highestYC, opening.bCY2);// highestY;//highestCYL;

		sY = Math.min(opening.highestY, opening.bY2);

		// myFrame2.rowTextObjects
		// .add(myFrame2.sixDecimal
		// .format(opening.height *
		// myScale));

		String h = "";

		if (myFrame2.myTopPanel.metric.isSelected()) {
			h = myFrame2.oneDecimal.format(UOMConvert.getBigDecimalConversion(
					opening.heightPix, myScale, 2));
			myFrame2.rowTextObjects.add(h);
		} else if (myFrame2.myTopPanel.impDec.isSelected()) {
			h = myFrame2.sixDecimal.format(UOMConvert.getBigDecimalConversion(
					opening.heightPix, myScale, 2) / 64);
			myFrame2.rowTextObjects.add(h);
		} else if (myFrame2.myTopPanel.impFrac.isSelected()) {

			try {
				h = UOMConvert.imperialToFraction("".concat(String
						.valueOf(String.valueOf(UOMConvert
								.getBigDecimalConversion(opening.heightPix,
										myScale, 2) / 64))));
				myFrame2.rowTextObjects.add(h);
			} catch (final Exception e) {
				// TODO Auto-generated catch
				// block
				e.printStackTrace();
			}

		}

		myFrame2.rowTextPosYs.add(sY);
		myFrame2.rowTextPosYe.add(opening.bY4);// startingY
		// +
		// opening.height);
		myFrame2.rowTextObjectsc.add(myFrame2.sixDecimal
				.format((opening.bCY4 - sYC) * myScale.doubleValue()));
		myFrame2.rowTextPosYsc.add(sYC);
		myFrame2.rowTextPosYec.add(opening.bCY4);// startingYC
		// +
		// endYC -
		// startingYC);

		myFrame2.textLeft = new TextFieldLeft();
		myFrame2.textLeft.size = opening.heightPix;
		myFrame2.textLeft.sizeC = opening.lowestYC - opening.highestYC;

		myFrame2.textLeft.pos = sY;
		myFrame2.textLeft.pose = opening.bY4;// endY;
		myFrame2.textLeft.posc = sYC;
		myFrame2.textLeft.posec = opening.bCY4;// endYC;
		myFrame2.textLeft.startRowCol = opening.startRow;
		myFrame2.textLeft.endRowCol = opening.endRow;
		myFrame2.textLeft.deltaLT = Math.abs(sYC - sY);

		myFrame2.textLeft.deltaRB = Math.abs(opening.bCY4 - opening.bY4);

		myFrame2.textLeft.rowNo = opening.startRow;
		myFrame2.textLeft.seqID = myFrame2.leftTexts.size() + 1;
		myFrame2.textLeft.parent = opening;
		myFrame2.textLeft.isSash = true;
		myFrame2.leftTexts.add(myFrame2.textLeft);
	}

	public void doOpeningTopDimsGlassDLO(final GlassSU opening,
			final boolean isSash, final boolean visible) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		double startingX = 0;
		double endX = 0;
		double startingXc = 0;
		double endXc = 0;

		startingX = opening.startingX;
		startingXc = opening.myParentO.startingCX;

		endX = opening.bX2;
		endXc = opening.myParentO.bCX2;
		final double wd = opening.widthPix;
		final double wdc = opening.myParentO.widthPix;
		String w = opening.widthPix + "";

		if (myFrame2.myTopPanel.metric.isSelected()) {
			w = myFrame2.oneDecimal.format(UOMConvert.getBigDecimalConversion(
					wd, myScale, 2));
			myFrame2.colTextObjects.add(w);
		} else if (myFrame2.myTopPanel.impDec.isSelected()) {
			w = myFrame2.sixDecimal.format(UOMConvert.getBigDecimalConversion(
					wd, myScale, 2) / 64);
			myFrame2.colTextObjects.add(w);
		} else if (myFrame2.myTopPanel.impFrac.isSelected()) {

			try {
				w = UOMConvert
						.imperialToFraction("".concat(String.valueOf(String
								.valueOf(UOMConvert.getBigDecimalConversion(wd,
										myScale, 2) / 64))));
				myFrame2.colTextObjects.add(w);
			} catch (final Exception e) {
				// TODO Auto-generated catch
				// block
				e.printStackTrace();
			}

		}

		myFrame2.colTextPosXs.add(startingX);
		myFrame2.colTextPosXe.add(endX);
		myFrame2.colTextObjectsc.add(myFrame2.sixDecimal
				.format((endXc - startingXc) * myScale.doubleValue()));
		myFrame2.colTextPosXsc.add(startingXc);
		myFrame2.colTextPosXec.add(endXc);
		myFrame2.textTop = new TextFieldTop();
		myFrame2.textTop.size = wd;
		myFrame2.textTop.sizeC = wdc;
		myFrame2.textTop.pos = startingX;
		myFrame2.textTop.pose = endX;

		myFrame2.textTop.posc = startingXc;
		myFrame2.textTop.posec = endXc;
		myFrame2.textTop.startRowCol = opening.startCol;
		myFrame2.textTop.endRowCol = opening.endCol;

		myFrame2.textTop.deltaL = Math.abs(startingXc - startingX);// +opening.clearanceLeft;
		myFrame2.textTop.deltaR = Math.abs(endX - endXc);// +opening.clearanceRight;
		myFrame2.textTop.clearanceL = opening.clearanceLeft;
		myFrame2.textTop.clearanceR = opening.clearanceRight;

		myFrame2.textTop.colNo = opening.startCol;

		myFrame2.textTop.seqID = myFrame2.topTexts.size() + 1;
		myFrame2.textTop.parent = opening;
		myFrame2.textTop.isSash = isSash;
		myFrame2.textTop.visible = visible;

		myFrame2.topTexts.add(myFrame2.textTop);
	}

	@SuppressWarnings("unchecked")
	public void doOpeningLeftDimsGlassDLO(final GlassSU opening,
			final boolean isSash, final boolean visible) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		double sYC = 0;
		double sY = 0;

		if (!opening.topIn) {
			sYC = Math.min(opening.myParentO.highestY,
					Math.min(opening.startingCY, opening.bCY2));// highestY;//highestCYL;
		} else {
			sYC = Math.min(opening.startingCY, opening.bCY2);// highestY;//highestCYL;
		}

		sY = Math.min(opening.highestY, opening.bY2);

		String h = "";

		if (myFrame2.myTopPanel.metric.isSelected()) {
			h = myFrame2.oneDecimal.format(UOMConvert.getBigDecimalConversion(
					opening.heightPix, myScale, 2));
			myFrame2.rowTextObjects.add(h);
		} else if (myFrame2.myTopPanel.impDec.isSelected()) {
			h = myFrame2.sixDecimal.format(UOMConvert.getBigDecimalConversion(
					opening.heightPix, myScale, 2) / 64);
			myFrame2.rowTextObjects.add(h);
		} else if (myFrame2.myTopPanel.impFrac.isSelected()) {

			try {
				h = UOMConvert.imperialToFraction("".concat(String
						.valueOf(String.valueOf(UOMConvert
								.getBigDecimalConversion(opening.heightPix,
										myScale, 2) / 64))));
				myFrame2.rowTextObjects.add(h);
			} catch (final Exception e) {
				// TODO Auto-generated catch
				// block
				e.printStackTrace();
			}

		}
		// //////////

		h = "";

		if (myFrame2.myTopPanel.metric.isSelected()) {
			h = myFrame2.oneDecimal.format(UOMConvert.getBigDecimalConversion(
					(Math.max(opening.bCY4, opening.bCY3) - sYC), myScale, 2));
			myFrame2.rowTextObjectsc.add(h);
		} else if (myFrame2.myTopPanel.impDec.isSelected()) {
			h = myFrame2.sixDecimal
					.format(UOMConvert.getBigDecimalConversion(
							(Math.max(opening.bCY4, opening.bCY3) - sYC),
							myScale, 2) / 64f);

			myFrame2.rowTextObjectsc.add(h);
		} else if (myFrame2.myTopPanel.impFrac.isSelected()) {

			try {
				h = UOMConvert.imperialToFraction("".concat(String
						.valueOf(String.valueOf(UOMConvert
								.getBigDecimalConversion(
										Math.max(opening.bCY4, opening.bCY3)
												- sYC, myScale, 2) / 64))));
				myFrame2.rowTextObjectsc.add(h);
			} catch (final Exception e) {
				// TODO Auto-generated catch

				e.printStackTrace();
			}

		}

		myFrame2.rowTextPosYs.add(sY);

		myFrame2.rowTextPosYe.add(opening.bY4);

		myFrame2.rowTextPosYsc.add(sYC);

		myFrame2.rowTextPosYec.add(opening.bCY4);

		myFrame2.textLeft = new TextFieldLeft();

		myFrame2.textLeft.size = opening.heightPix;

		myFrame2.textLeft.sizeC = opening.lowestYC - opening.highestYC;

		myFrame2.textLeft.pos = sY;

		myFrame2.textLeft.pose = opening.bY4;

		myFrame2.textLeft.posc = sYC;

		myFrame2.textLeft.posec = opening.bCY4;

		myFrame2.textLeft.startRowCol = opening.startRow;

		myFrame2.textLeft.endRowCol = opening.endRow;

		myFrame2.textLeft.deltaLT = Math.abs(sYC - sY) + opening.clearanceBot;

		myFrame2.textLeft.deltaRB = Math.abs(opening.bCY4 - opening.bY4)
				+ opening.clearanceTop;

		myFrame2.textLeft.parent = opening;
		myFrame2.textLeft.isSash = isSash;
		myFrame2.textLeft.visible = visible;

		myFrame2.textLeft.rowNo = opening.startRow;
		myFrame2.textLeft.seqID = myFrame2.leftTexts.size() + 1;

		myFrame2.leftTexts.add(myFrame2.textLeft);
	}

	public void doOpeningTopDimsDLO(final DLO opening, final boolean isSash,
			final boolean visible) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		double startingX = 0;
		double endX = 0;
		double startingXc = 0;
		double endXc = 0;

		startingX = opening.startingX;
		startingXc = opening.myParentO.startingCX;

		endX = opening.bX2;
		endXc = opening.myParentO.bCX2;
		final double wd = opening.widthPix;
		final double wdc = opening.myParentO.widthPix;
		String w = opening.widthPix + "";

		if (myFrame2.myTopPanel.metric.isSelected()) {
			w = myFrame2.oneDecimal.format(UOMConvert.getBigDecimalConversion(
					wd, myScale, 2));
			myFrame2.colTextObjects.add(w);
		} else if (myFrame2.myTopPanel.impDec.isSelected()) {
			w = myFrame2.sixDecimal.format(UOMConvert.getBigDecimalConversion(
					wd, myScale, 2) / 64);
			myFrame2.colTextObjects.add(w);
		} else if (myFrame2.myTopPanel.impFrac.isSelected()) {

			try {
				w = UOMConvert
						.imperialToFraction("".concat(String.valueOf(String
								.valueOf(UOMConvert.getBigDecimalConversion(wd,
										myScale, 2) / 64))));
				myFrame2.colTextObjects.add(w);
			} catch (final Exception e) {
				// TODO Auto-generated catch
				// block
				e.printStackTrace();
			}

		}

		myFrame2.colTextPosXs.add(startingX);
		myFrame2.colTextPosXe.add(endX);
		myFrame2.colTextObjectsc.add(myFrame2.sixDecimal
				.format((endXc - startingXc) * myScale.doubleValue()));
		myFrame2.colTextPosXsc.add(startingXc);
		myFrame2.colTextPosXec.add(endXc);
		myFrame2.textTop = new TextFieldTop();
		myFrame2.textTop.size = wd;
		myFrame2.textTop.sizeC = wdc;
		myFrame2.textTop.pos = startingX;
		myFrame2.textTop.pose = endX;

		myFrame2.textTop.posc = startingXc;
		myFrame2.textTop.posec = endXc;
		myFrame2.textTop.startRowCol = opening.startCol;
		myFrame2.textTop.endRowCol = opening.endCol;

		myFrame2.textTop.deltaL = Math.abs(startingXc - startingX);// +opening.clearanceLeft;
		myFrame2.textTop.deltaR = Math.abs(endX - endXc);// +opening.clearanceRight;
		myFrame2.textTop.clearanceL = opening.clearanceLeft;
		myFrame2.textTop.clearanceR = opening.clearanceRight;

		myFrame2.textTop.parent = opening;

		myFrame2.textTop.isSash = isSash;
		myFrame2.textTop.visible = visible;

		myFrame2.textTop.colNo = opening.myParentO.startCol;
		myFrame2.textTop.seqID = myFrame2.topTexts.size() + 1;
		myFrame2.topTexts.add(myFrame2.textTop);
	}

	@SuppressWarnings("unchecked")
	public void doOpeningLeftDimsDLO(final DLO opening, final boolean isSash,
			final boolean visible) {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		double sYC = 0;
		double sY = 0;

		if (!opening.topIn) {
			sYC = Math.min(opening.myParent.highestY,
					Math.min(opening.startingCY, opening.bCY2));// highestY;//highestCYL;
		} else {
			sYC = Math.min(opening.startingCY, opening.bCY2);// highestY;//highestCYL;
		}

		sY = Math.min(opening.highestY, opening.bY2);

		String h = "";

		if (myFrame2.myTopPanel.metric.isSelected()) {
			h = myFrame2.oneDecimal.format(UOMConvert.getBigDecimalConversion(
					opening.heightPix, myScale, 2));
			myFrame2.rowTextObjects.add(h);
		} else if (myFrame2.myTopPanel.impDec.isSelected()) {
			h = myFrame2.sixDecimal.format(UOMConvert.getBigDecimalConversion(
					opening.heightPix, myScale, 2) / 64);
			myFrame2.rowTextObjects.add(h);
		} else if (myFrame2.myTopPanel.impFrac.isSelected()) {

			try {
				h = UOMConvert.imperialToFraction("".concat(String
						.valueOf(String.valueOf(UOMConvert
								.getBigDecimalConversion(opening.heightPix,
										myScale, 2) / 64))));
				myFrame2.rowTextObjects.add(h);
			} catch (final Exception e) {
				// TODO Auto-generated catch
				// block
				e.printStackTrace();
			}

		}
		// //////////

		h = "";

		if (myFrame2.myTopPanel.metric.isSelected()) {
			h = myFrame2.oneDecimal.format(UOMConvert.getBigDecimalConversion(
					(Math.max(opening.bCY4, opening.bCY3) - sYC), myScale, 2));
			myFrame2.rowTextObjectsc.add(h);
		} else if (myFrame2.myTopPanel.impDec.isSelected()) {
			h = myFrame2.sixDecimal
					.format(UOMConvert.getBigDecimalConversion(
							(Math.max(opening.bCY4, opening.bCY3) - sYC),
							myScale, 2) / 64f);

			myFrame2.rowTextObjectsc.add(h);
		} else if (myFrame2.myTopPanel.impFrac.isSelected()) {

			try {
				h = UOMConvert
						.imperialToFraction("".concat(String.valueOf(String.valueOf(UOMConvert.getBigDecimalConversion(
								(Math.max(opening.bCY4, opening.bCY3) - sYC),
								myScale, 2) / 64))));
				myFrame2.rowTextObjectsc.add(h);
			} catch (final Exception e) {
				// TODO Auto-generated catch

				e.printStackTrace();
			}

		}

		myFrame2.rowTextPosYs.add(sY);

		myFrame2.rowTextPosYe.add(opening.bY4);

		myFrame2.rowTextPosYsc.add(sYC);

		myFrame2.rowTextPosYec.add(opening.bCY4);

		myFrame2.textLeft = new TextFieldLeft();

		myFrame2.textLeft.size = opening.heightPix;

		myFrame2.textLeft.sizeC = opening.lowestYC - opening.highestYC;

		myFrame2.textLeft.pos = sY;

		myFrame2.textLeft.pose = opening.bY4;

		myFrame2.textLeft.posc = sYC;

		myFrame2.textLeft.posec = opening.bCY4;

		myFrame2.textLeft.startRowCol = opening.startRow;

		myFrame2.textLeft.endRowCol = opening.endRow;

		myFrame2.textLeft.deltaLT = Math.abs(sYC - sY) + opening.clearanceBot;

		myFrame2.textLeft.deltaRB = Math.abs(opening.bCY4 - opening.bY4)
				+ opening.clearanceTop;

		myFrame2.textLeft.parent = opening;
		myFrame2.textLeft.isSash = isSash;
		myFrame2.textLeft.visible = visible;

		myFrame2.textLeft.rowNo = opening.myParentO.startRow;

		myFrame2.textLeft.seqID = myFrame2.leftTexts.size() + 1;
		myFrame2.leftTexts.add(myFrame2.textLeft);
	}

	@SuppressWarnings("unchecked")
	public void createTextObjectsTopInit() {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			this.myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		double SX = Math.min(startingX, bX4);

		double EX = Math.max(bX2, bX3);

		if (this.leftIn) {
			SX = Math.min(startingCX, bCX4);
		}
		if (this.rightIn) {
			EX = Math.max(bCX2, bCX3);
		}

		if (!topIn) {

			myFrame2.colTextPosXs.add(SX);
			myFrame2.colTextPosXe.add(SX + (EX - SX));

			String w = "";

			if (myFrame2.myTopPanel.metric.isSelected()) {
				w = myFrame2.oneDecimal.format(UOMConvert
						.getBigDecimalConversion((EX - SX), myScale, 2));
				final double wd = (int) myFrame2.roundDim(
						Double.parseDouble(w), 2, myFrame2.metricRound, 1);

				if (wd != Double.parseDouble(w) && myFrame2.roundW) {
					frameWRounded = true;
					myFrame2.topDeltas = myFrame2.topDeltas
							+ Double.parseDouble(w) - wd;
				}

				if (myFrame2.topDeltas < 0.00000000) {
					myParent.frameHRounded = false;
					myFrame2.topDeltas = 0;
					w = ((int) (Double.valueOf(w) * 1000000000)) / 100000000
							+ "";
				}

				myFrame2.colTextObjectsc.add(w);
				myFrame2.colTextObjects.add(w);
			} else if (myFrame2.myTopPanel.impDec.isSelected()) {
				w = myFrame2.sixDecimal.format(UOMConvert
						.getBigDecimalConversion((EX - SX), myScale, 2) / 64);

				final double wd = (int) myFrame2.roundDim(
						Double.parseDouble(w) * 64, 1, myFrame2.impRound, 2);

				if (wd != Double.valueOf(w) * 64d && myFrame2.roundW) {
					frameWRounded = true;
					myFrame2.topDeltas = myFrame2.topDeltas
							+ Double.parseDouble(w) * 64 - wd;
				}
				if (myFrame2.topDeltas < 0.00000000) {
					myParent.frameHRounded = false;
					myFrame2.topDeltas = 0;
					w = ((int) (Double.valueOf(w) * 1000000000)) / 100000000
							+ "";
				}

				myFrame2.colTextObjectsc.add(w);
				myFrame2.colTextObjects.add(w);
			} else if (myFrame2.myTopPanel.impFrac.isSelected()) {

				try {
					w = UOMConvert.imperialToFraction("".concat(String
							.valueOf(UOMConvert.getBigDecimalConversion(
									(EX - SX), myScale, 2) / 64)));

					final double wd = (int) myFrame2
							.roundDim(Double.parseDouble(w) * 64, 1,
									myFrame2.impRound, 2);

					if (wd != Double.valueOf(w) * 64d && myFrame2.roundW) {
						frameWRounded = true;
						myFrame2.topDeltas = myFrame2.topDeltas
								+ Double.parseDouble(w) * 64 - wd;
					}
					if (myFrame2.topDeltas < 0.00000000) {
						myParent.frameHRounded = false;
						myFrame2.topDeltas = 0;
						w = ((int) (Double.valueOf(w) * 1000000000))
								/ 100000000 + "";
					}

					myFrame2.colTextObjectsc.add(w);
					myFrame2.colTextObjects.add(w);
				} catch (final Exception e) {
					// TODO
					// Auto-generated
					// catch
					// block
					e.printStackTrace();
				}

			} else if (myFrame2.myTopPanel.feet.isSelected()) {

				try {
					w = myFrame2.sixDecimal
							.format(UOMConvert.getBigDecimalConversion(
									(EX - SX), myScale, 2) / 64);
					w = UOMConvert.imperialToFeetInch(w, 0);

					final double wd = (int) myFrame2
							.roundDim(Double.parseDouble(w) * 64, 1,
									myFrame2.impRound, 2);

					if (wd != Double.valueOf(w) * 64d && myFrame2.roundW) {
						frameWRounded = true;
						myFrame2.topDeltas = myFrame2.topDeltas
								+ Double.parseDouble(w) * 64 - wd;
					}
					if (myFrame2.topDeltas < 0.00000000) {
						myParent.frameHRounded = false;
						myFrame2.topDeltas = 0;
						w = ((int) (Double.valueOf(w) * 1000000000))
								/ 100000000 + "";
					}

					myFrame2.colTextObjectsc.add(w);
					myFrame2.colTextObjects.add(w);
				} catch (final Exception e) {
					// TODO
					// Auto-generated
					// catch
					// block
					e.printStackTrace();
				}

			}

			myFrame2.colTextPosXsc.add(SX);
			myFrame2.colTextPosXec.add(EX);

			myFrame2.textTop = new TextFieldTop();
			myFrame2.textTop.active = true;
			myFrame2.textTop.size = widthPix;
			myFrame2.textTop.sizeC = EX - SX;
			myFrame2.textTop.pos = startingX;
			myFrame2.textTop.pose = startingX + (EX - SX);
			myFrame2.textTop.posc = SX;
			myFrame2.textTop.posec = EX;
			myFrame2.textTop.startRowCol = startCol;
			myFrame2.textTop.endRowCol = endCol;
			myFrame2.textTop.deltaL = Math.abs(SX - startingX);
			myFrame2.textTop.deltaR = Math.abs(bX2 - EX);

			myFrame2.textTop.colNo = startCol;
			myFrame2.textTop.seqID = myFrame2.topTexts.size() + 1;
			myFrame2.topTexts.add(myFrame2.textTop);

		}
		if (myFrame2.resetModTextsV || myFrame2.topTextsMod == null) {
			myFrame2.topTextsMod = new int[myFrame2.colTextObjects.size()];
		}

	}

	public void createTextObjectsLeftInit() {

		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		if (lowestY == 0) {
			lowestY = highestY + heightPix;
		}

		double SY = this.highestY;

		double EY = this.lowestY;

		if (this.topIn) {

			SY = this.highestYC;

		}
		if (this.botIn) {

			EY = this.lowestYC;

		}

		if (!leftIn) {

			myFrame2.rowTextPosYs.add(SY);
			myFrame2.rowTextPosYe.add(SY + (EY - SY));

			String h = "";

			if (myFrame2.myTopPanel.metric.isSelected()) {
				h = myFrame2.oneDecimal.format(UOMConvert
						.getBigDecimalConversion((EY - SY), myScale, 2));

				final double hd = (int) myFrame2.roundDim(
						Double.parseDouble(h), 2, myFrame2.metricRound, 1);

				if (hd != Double.parseDouble(h) && myFrame2.roundH) {
					myParent.frameHRounded = true;
					myFrame2.leftDeltas = myFrame2.leftDeltas
							+ Double.parseDouble(h) - hd;
				}
				if (myFrame2.leftDeltas < 0.00000000) {
					myParent.frameHRounded = false;
					myFrame2.leftDeltas = 0;
					h = ((int) (Double.valueOf(h) * 1000000000)) / 100000000
							+ "";
				}

				myFrame2.rowTextObjectsc.add(h);
				myFrame2.rowTextObjects.add(h);
			} else if (myFrame2.myTopPanel.impDec.isSelected()) {
				h = myFrame2.sixDecimal.format(UOMConvert
						.getBigDecimalConversion((EY - SY), myScale, 2) / 64);
				final double hd = (int) (Double.parseDouble(h) * 64 / myFrame2.impRound)
						* myFrame2.impRound;

				if (hd != Double.valueOf(h) * 64d && myFrame2.roundH) {
					myParent.frameHRounded = true;
					myFrame2.leftDeltas = myFrame2.leftDeltas
							+ Double.parseDouble(h) * 64 - hd;
				}
				if (myFrame2.leftDeltas < 0.00000000) {
					myParent.frameHRounded = false;
					myFrame2.leftDeltas = 0;
					h = ((int) (Double.valueOf(h) * 1000000000)) / 100000000
							+ "";
				}
				myFrame2.rowTextObjectsc.add(h);
				myFrame2.rowTextObjects.add(h);
			} else if (myFrame2.myTopPanel.impFrac.isSelected()) {

				try {
					h = UOMConvert.imperialToFraction("".concat(String
							.valueOf(UOMConvert.getBigDecimalConversion(
									(EY - SY), myScale, 2) / 64)));
					final double hd = (int) myFrame2
							.roundDim(Double.parseDouble(h) * 64, 1,
									myFrame2.impRound, 2);

					if (hd != Double.valueOf(h) * 64d && myFrame2.roundH) {
						myParent.frameHRounded = true;
						myFrame2.leftDeltas = myFrame2.leftDeltas
								+ Double.parseDouble(h) * 64 - hd;
					}

					if (myFrame2.leftDeltas < 0.00000000) {
						myParent.frameHRounded = false;
						myFrame2.leftDeltas = 0;
						h = ((int) (Double.valueOf(h) * 1000000000))
								/ 100000000 + "";
					}

					myFrame2.rowTextObjectsc.add(h);
					myFrame2.rowTextObjects.add(h);
				} catch (final Exception e) {
					// TODO
					// Auto-generated
					// catch
					// block
					e.printStackTrace();
				}

			} else if (myFrame2.myTopPanel.feet.isSelected()) {

				try {
					h = myFrame2.sixDecimal
							.format(UOMConvert.getBigDecimalConversion(
									(EY - SY), myScale, 2) / 64);
					h = UOMConvert.imperialToFeetInch(h, 0);
					final double hd = (int) myFrame2
							.roundDim(Double.parseDouble(h) * 64, 1,
									myFrame2.impRound, 2);

					if (hd != Double.valueOf(h) * 64d && myFrame2.roundH) {
						myParent.frameHRounded = true;
						myFrame2.leftDeltas = myFrame2.leftDeltas
								+ Double.parseDouble(h) * 64 - hd;
					}

					if (myFrame2.leftDeltas < 0.00000000) {
						myParent.frameHRounded = false;
						myFrame2.leftDeltas = 0;
						h = ((int) (Double.valueOf(h) * 1000000000))
								/ 100000000 + "";
					}

					myFrame2.rowTextObjectsc.add(h);
					myFrame2.rowTextObjects.add(h);
				} catch (final Exception e) {
					// TODO
					// Auto-generated
					// catch
					// block
					e.printStackTrace();
				}

			}

			myFrame2.rowTextPosYsc.add(SY);
			myFrame2.rowTextPosYec.add(EY);

			myFrame2.textLeft = new TextFieldLeft();
			myFrame2.textLeft.active = false;
			myFrame2.textLeft.size = heightPix;
			myFrame2.textLeft.sizeC = EY - SY;
			myFrame2.textLeft.pos = startingY;
			myFrame2.textLeft.pose = bY4;
			myFrame2.textLeft.posc = SY;
			myFrame2.textLeft.posec = EY;
			myFrame2.textLeft.startRowCol = startRow;
			myFrame2.textLeft.endRowCol = endRow;
			myFrame2.textLeft.deltaLT = Math.abs(startingY - SY);
			myFrame2.textLeft.deltaRB = Math.abs(EY - bY4);
			myFrame2.textLeft.deltaRB = Math.abs(EY - bY4);

			myFrame2.textLeft.rowNo = startRow;
			myFrame2.textLeft.seqID = myFrame2.leftTexts.size() + 1;
			myFrame2.leftTexts.add(myFrame2.textLeft);
		}
		if (myFrame2.resetModTextsH || myFrame2.leftTextsMod == null) {
			myFrame2.leftTextsMod = new int[myFrame2.rowTextObjects.size()];
		}

	}

	public void setOriginalDimsInit(final double ow, final double oh) {

		if (widthMO == 0) {

			widthM = widthMO = (int) // (ow / myFrame2.metricscale);
			(new BigDecimal(ow).divide(myFrame2.metricscale, 20,
					BigDecimal.ROUND_UP)).doubleValue();

			heightM = heightMO = (int) // (oh / myFrame2.metricscale);
			(new BigDecimal(oh).divide(myFrame2.metricscale, 20,
					BigDecimal.ROUND_UP)).doubleValue();

			heightM = heightMO = (int) ((heightM * myFrame2.metricRound) / myFrame2.metricRound);

			originalScaleM = myFrame2.metricscale;

			originalScaleI = myFrame2.imperialscale;

			widthI = widthIO = (int) (new BigDecimal(ow).divide(
					myFrame2.imperialscale, 10, BigDecimal.ROUND_UP))
					.doubleValue();
			widthM = widthMO = (int) ((widthM * myFrame2.metricRound) / myFrame2.metricRound);
			widthI = widthIO = (int) ((widthI * myFrame2.impRound) / myFrame2.impRound);

			heightI = heightIO = (int) (new BigDecimal(oh).divide(
					myFrame2.imperialscale, 10, BigDecimal.ROUND_UP))
					.doubleValue();

			heightI = heightIO = (int) ((heightI * myFrame2.impRound) / myFrame2.impRound);

		}
	}

	public void setDimsChange(final double ow, final double oh) {

		widthPix = ow;
		heightPix = oh;
		// Changed Here 2/28/13
		// widthM = (int) (ow / myFrame2.metricscale);
		//
		// heightM = (int) (oh / myFrame2.metricscale);

		// widthI = (int) (myFrame2.roundDim(ow / myFrame2.imperialscale / 64,
		// 2, myFrame2.impRound, 2) * 64);
		//
		// heightI = (int) (myFrame2.roundDim(oh / myFrame2.imperialscale /
		// 64, 2, myFrame2.impRound, 2) * 64);

	}

	public BkgrdOpeningObject modifyVHMCPartDim(
			BkgrdOpeningObject bOpeningObject) {

		AddMullionV addMullion = new AddMullionV(bOpeningObject,
				myFrame2.jobItem, myFrame2, 1);

		Object[] mVs = bOpeningObject.mullions.toArray();

		bOpeningObject.mullions.clear();

		for (Object vc : mVs) {

			// Clone mullion object to new object
			Profiles newMullion = (Profiles) ((Profiles) vc)
					.cloneProfile(((Profiles) vc));

			// Clean options collection
			newMullion.options.clear();

			// Execute Rules methods
			newMullion
					.executeRulesMethod("shapeobejct.modifyVHMCPartDim.18258");

			// Clear boms collections
			newMullion.bom.clear();
			// Clear boms for profiles
			newMullion.clearBomForProfile();

			// Execute Parts rules
			// newMullion = (Profiles)
			// myFrame2.executePartRules.executePartRules(null, null,
			// newMullion, newMullion.a_assemblyLevel, true, true,
			// "shapeobject.modifyVHMCpartDim.18267", true);

			// Recalculate mullion boms
			addMullion.resetRecalcMullionBom(newMullion);// this.myFrame2.executePartRules.executePartRules(rule,
															// null,
															// (Profiles)this,
															// doBom);

			// Adding mullion to background opening
			bOpeningObject.mullions.add(newMullion);
		}

		AddMullionH addMullionH = new AddMullionH(bOpeningObject,
				myFrame2.jobItem, myFrame2, 1);

		Object[] mHs = bOpeningObject.mullionsH.toArray();

		bOpeningObject.mullionsH.clear();

		for (Object hc : mHs) {

			// Clone mullion object to new object
			Profiles newMullion = (Profiles) ((Profiles) hc)
					.cloneProfile(((Profiles) hc));

			// Execute Rules methods
			newMullion
					.executeRulesMethod("shapeobejct.modifyVHMCPartDim.18288");

			// Clear boms collections
			newMullion.bom.clear();
			// Clear boms for profiles
			newMullion.clearBomForProfile();

			// Execute Parts rules
			// newMullion = (Profiles)
			// myFrame2.executePartRules.executePartRules(null, null,
			// newMullion, newMullion.a_assemblyLevel, true, true,
			// "shapeobject.modifyVHMCpartDim.18297", true);

			// Recalculate mullion boms
			addMullionH.resetRecalcMullionBom(newMullion);

			// Adding mullion to background opening
			bOpeningObject.mullionsH.add(newMullion);
		}

		return bOpeningObject;
	}

	/**
	 * This method modify Vertical (Mullion or Coupler Equilize) values for new
	 * position into BkgrdOpening for division of ShapeObject
	 * 
	 * @param bOpeningObject
	 *            , BkgrdOpeningObject
	 * @return BkgrdOpeningObject
	 */
	public BkgrdOpeningObject modifyVMCEqualize(
			BkgrdOpeningObject bOpeningObject) throws Exception {

		/**
		 * Evaluate if vertical mullions collection is not empty
		 */
		if (bOpeningObject != null && bOpeningObject.mullions != null
				&& bOpeningObject.mullions.size() > 0) {

			// Create AddMullion Vertical class for processing collection
			AddMullionV addMullion = new AddMullionV(bOpeningObject,
					myFrame2.jobItem, myFrame2, 1);

			// Calculate dimension for mullion with number of columns for
			// division
			addMullion.getDimsForMullion(bOpeningObject.xCols, 2);

			// Init array of mullions
			Object[] mVs = bOpeningObject.mullions.toArray();
			// Clear actual vertical mullion collection for BkgrdOpening
			bOpeningObject.mullions.clear();

			// Init count for mullions objects
			int count = 0;

			for (Object vc : mVs) {

				// Clone mullion object to new object
				Profiles newMullion = (Profiles) ((Profiles) vc)
						.cloneProfile(((Profiles) vc));

				double partDimA = 0;
				double partDimB = 0;
				double partDimBtoC = 0;
				double partDimC = 0;
				double partDimD = 0;
				double partDimM = 0;

				if (this.myFrame2.mySeries.getSeriesUom() == 1) {
					partDimA = addMullion.partDimA = newMullion.partDimA;
					partDimB = addMullion.partDimB = addMullion.thickness = newMullion.thickness = newMullion.partDimB;
					partDimC = addMullion.partDimC = newMullion.partDimC;
					partDimD = addMullion.partDimD = newMullion.partDimD;
					partDimM = addMullion.partDimM = newMullion.partDimM;
					partDimBtoC = addMullion.partDimBtoC = newMullion.partDimBtoC;

				} else {
					partDimA = addMullion.partDimA = newMullion.partDimAi;
					partDimB = addMullion.partDimB = addMullion.thickness = newMullion.thickness = newMullion.partDimBi;
					partDimC = addMullion.partDimC = newMullion.partDimCi;
					partDimD = addMullion.partDimD = newMullion.partDimDi;
					partDimM = addMullion.partDimM = newMullion.partDimMi;
					partDimBtoC = addMullion.partDimBtoC = newMullion.partDimBtoCi;
				}

				if (newMullion.exists == 1) {
					count++;
				}

				// Init offserts values to zero
				newMullion.offsetTL = 0;
				newMullion.offsetRB = 0;

				// Sum thickness values for collection mullions
				double sumPrev = 0;

				for (final Object vc2 : mVs) {
					if (((Profiles) vc2).rowCol < ((Profiles) vc).rowCol
							&& ((Profiles) vc2).exists == 1) {
						sumPrev = sumPrev + ((Profiles) vc2).thickness;
					}
				}

				// Get thickness value from mullion
				double thick = newMullion.thickness;
				// Get minimum value from BkgrdOpening

				double sX = Math.min(bOpeningObject.startingX,
						bOpeningObject.bX4);
				double myCCalc = partDimB - partDimBtoC;

				/**
				 * Get X position from mullion and evaluate if calculate
				 * position is lesser than original position. If this condition
				 * is true, we should override this value to respect the
				 * original design.
				 */
				// Calculate new position X for mullion
				double posX = sX + addMullion.newColW * newMullion.rowCol
						+ sumPrev;

				if (myFrame2.initDesign) {
					double poscX = posX + myCCalc;

					if (this.myFrame2.jobItem.getDimensionOptions() != null) {
						poscX = newMullion.centerXs
								- this.myFrame2.jobItem.getDimensionOptions()
										.get_starting_X();

						BigDecimal widthPorc = new BigDecimal(poscX)
								.divide(new BigDecimal(myFrame2.jobItem
										.getDimensionOptions().get_WIDTH_Pix()),
										20, BigDecimal.ROUND_UP);

						BigDecimal columnW = widthPorc
								.multiply(
										new BigDecimal(
												bOpeningObject.myFrame2.jobItem._WIDTHpix))
								.setScale(20, BigDecimal.ROUND_UP);

						// Calculate position X for mullion from original
						// dimension
						poscX = sX + columnW.doubleValue();

						posX = poscX + partDimBtoC - partDimB;
					}
				}

				double myD = Math.max(newMullion.offsetTL, newMullion.offsetRB)
						- Math.min(newMullion.offsetTL, newMullion.offsetRB);

				if (newMullion.offsetTL != 0) {

					addMullion.getDeltaAndTheta(newMullion, myD);

					final double hypBtoC = partDimBtoC;
					final double hypC = partDimC;
					final double hypB = partDimB;
					final double hypA = partDimA;
					final double offsetXc = 0;

					addMullion.newStartingXCenter = posX + partDimB
							- partDimBtoC + newMullion.offsetTL + offsetXc;

					addMullion.newStartingXRTc = addMullion.newStartingXCenter
							+ hypBtoC + hypC;

					addMullion.newStartingXRT = addMullion.newStartingXCenter
							+ hypBtoC;

					addMullion.newStartingXLB = addMullion.newStartingXCenter
							+ hypBtoC - hypB;

					addMullion.newStartingXLBa = addMullion.newStartingXLB
							- hypA;

				} else if (newMullion.offsetTL == 0) {

					addMullion.newStartingXCenter = posX + partDimB
							- partDimBtoC + newMullion.offsetTL;

					addMullion.newStartingXRTc = addMullion.newStartingXCenter
							+ partDimBtoC + partDimC;

					addMullion.newStartingXRT = addMullion.newStartingXCenter
							+ partDimBtoC;

					addMullion.newStartingXLB = addMullion.newStartingXCenter
							+ partDimBtoC - partDimB;

					addMullion.newStartingXLBa = addMullion.newStartingXLB
							- partDimA;
				}

				newMullion.x1 = addMullion.newStartingXLB;

				newMullion.x2 = addMullion.newStartingXRT;

				newMullion.x1al = addMullion.newStartingXLBa;

				newMullion.x2cl = addMullion.newStartingXRTc;

				newMullion.centerXs = addMullion.newStartingXCenter;

				if (newMullion.offsetRB != 0) {
					addMullion.getDeltaAndTheta(newMullion, myD);

					final double hypBtoC = partDimBtoC;
					final double hypC = partDimC;
					final double hypB = partDimB;
					final double hypA = partDimA;
					final double offsetXc = 0;

					newMullion.centerXe = posX + partDimB - partDimBtoC
							+ newMullion.offsetRB + offsetXc;

					newMullion.x3 = newMullion.centerXe + hypBtoC;

					newMullion.x3cl = newMullion.x3 + hypC;

					newMullion.x4 = newMullion.x3 - hypB;

					newMullion.x4al = newMullion.x4 - hypA;

				} else if (newMullion.offsetRB == 0) {

					newMullion.centerXe = posX + partDimB - partDimBtoC
							- newMullion.offsetRB;

					newMullion.x3 = newMullion.centerXe + partDimBtoC;

					newMullion.x3cl = newMullion.x3 + partDimC;

					newMullion.x4 = newMullion.x3 - partDimB;

					newMullion.x4al = newMullion.x4 - partDimA;
				}

				// Verify Left and Right limits
				addMullion.verifyLimitLR(newMullion);

				// Init calculate mullion vertical
				addMullion.calcMullion = new CalculateMullionV(addMullion);

				addMullion.newStartingXCenter = newMullion.centerXs;
				addMullion.newStartingXRTc = newMullion.x2cl;
				addMullion.newStartingXRT = newMullion.x2;
				addMullion.newStartingXLB = newMullion.x1;
				addMullion.newStartingXLBa = newMullion.x1al;

				// Calculate maximum value from by3 and by4
				addMullion.vcEndY = Math.max(bOpeningObject.bY3,
						bOpeningObject.bY4);

				// Calculate coordinatates
				addMullion.calcMullion.calculateCoord(newMullion);

				// Recalculate mullion boms
				addMullion.resetRecalcMullionBom(newMullion);

				// Adding mullion to background opening
				bOpeningObject.mullions.add(newMullion);
			}

			// Parse opening collection to array of values
			// bOpeningObject.openings.toArray();

			// addMullion.recalcInitOpenings();

			// Setting mullions vertical & horizontal to mullionObject
			// collections
			bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
			bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();

			// Recalculate horizontal coordinates
			addMullion.recalcHCCoords();
			// Recalculate Vertical corrdinates
			addMullion.reOrderVNotches();

			// Clear parts objects collection
			bOpeningObject.partObjects.clear();

			// Reset parts objects
			bOpeningObject.resetParts();

			addMullion.splitParts(null, false, false);

			// bOpeningObject.myParent.doOpenings();
		}

		return bOpeningObject;
	}

	/**
	 * This method modify Vertical (Coupler Equilize) values for new position
	 * into BkgrdOpening for division of ShapeObject
	 * 
	 * @param bOpeningObject
	 *            , BkgrdOpeningObject
	 * @return BkgrdOpeningObject
	 */
	public BkgrdOpeningObject modifyHMCEqualize(
			BkgrdOpeningObject bOpeningObject) throws Exception {

		/**
		 * Evaluate if horizontal mullions is not empty
		 */
		if (bOpeningObject != null && bOpeningObject.mullionsH != null
				&& bOpeningObject.mullionsH.size() > 0) {

			// Initialize Add mullion classe
			AddMullionH addMullion = new AddMullionH(bOpeningObject,
					myFrame2.jobItem, myFrame2, 1);

			// Get coupler dimension
			addMullion.getDimsForMullion(bOpeningObject.yRows, 2);

			// Parse horizontal mulion collection to array
			Object[] mHs = bOpeningObject.mullionsH.toArray();

			// Clear horizontal mullions collection
			bOpeningObject.mullionsH.clear();

			int count = 0;

			for (Object vc : mHs) {

				// Clone mullion profiles object
				Profiles newMullion = (Profiles) ((Profiles) vc)
						.cloneProfile((Profiles) vc);

				double partDimA = 0;
				double partDimB = 0;
				double partDimBtoC = 0; // Where the Center of Mullion (screw
										// Ports is)
				double partDimC = 0;
				double partDimD = 0;
				double partDimM = 0;

				if (this.myFrame2.mySeries.getSeriesUom() == 1) {
					partDimA = addMullion.partDimA = newMullion.partDimA;
					partDimB = addMullion.partDimB = addMullion.thickness = newMullion.partDimB;
					partDimC = addMullion.partDimC = newMullion.partDimC;
					partDimD = addMullion.partDimD = newMullion.partDimD;
					partDimM = addMullion.partDimM = newMullion.partDimM;
					partDimBtoC = addMullion.partDimBtoC = newMullion.partDimBtoC;

				} else {
					partDimA = addMullion.partDimA = newMullion.partDimAi;
					partDimB = addMullion.partDimB = addMullion.thickness = newMullion.partDimBi;
					partDimC = addMullion.partDimC = newMullion.partDimCi;
					partDimD = addMullion.partDimD = newMullion.partDimDi;
					partDimM = addMullion.partDimM = newMullion.partDimMi;
					partDimBtoC = addMullion.partDimBtoC = newMullion.partDimBtoCi;
				}

				if (newMullion.exists == 1) {
					count++;
				}

				// Init offsets values to zero
				newMullion.offsetTL = 0;
				newMullion.offsetRB = 0;

				// Sum thickness values for collection mullions
				double sumPrev = 0;

				for (Object vc2 : mHs) {

					if (((Profiles) vc2).rowCol < ((Profiles) vc).rowCol
							&& ((Profiles) vc2).exists == 1) {
						sumPrev = sumPrev + ((Profiles) vc2).thickness;
					}
				}

				// Init thickness value
				double thick = newMullion.thickness;

				// Set continuity value
				addMullion.continuity = newMullion.continuity;

				/**
				 * Get X position from mullion and evaluate if calculate
				 * position is lesser than original position. If this condition
				 * is true, we should override this value to respect the
				 * original design.
				 */

				// Calculate new center position for mullion position
				double posY = bOpeningObject.highestY + addMullion.newRowH
						* ((Profiles) vc).rowCol + sumPrev;
				if (this.myParent.a_assemblyLevel == 2) {
					Object[] ops = myParent.openings.toArray();

					for (Object o : ops) {

						if (((OpeningObject) o).startRow == 1
								&& ((OpeningObject) o).shapeID != 1
								&& ((OpeningObject) o).shapeID != 10) {
							this.myFrame2.topRowShapes.add((OpeningObject) o);

						}
					}
				}

				double myCCalc = partDimB - partDimBtoC;

				if (myFrame2.initDesign) {

					double poscY = posY + myCCalc;

					if (this.myFrame2.jobItem.getDimensionOptions() != null) {

						poscY = newMullion.centerYs
								- this.myFrame2.jobItem.getDimensionOptions()
										.get_starting_Y();

						BigDecimal heightPorc = new BigDecimal(poscY)
								.divide(new BigDecimal(myFrame2.jobItem
										.getDimensionOptions().get_HEIGHT_Pix()),
										20, BigDecimal.ROUND_UP);

						BigDecimal rowH = heightPorc
								.multiply(
										new BigDecimal(
												bOpeningObject.myFrame2.jobItem._HEIGHTpix))
								.setScale(20, BigDecimal.ROUND_UP);

						poscY = bOpeningObject.highestY + rowH.doubleValue();// +

						posY = poscY + partDimBtoC - partDimB;

					}
				}

				double myD = Math.max(newMullion.offsetTL, newMullion.offsetRB)
						- Math.min(newMullion.offsetTL, newMullion.offsetRB);

				if (newMullion.offsetTL != 0) {

					addMullion.newStartingYCenter = posY + myCCalc
							+ newMullion.offsetTL;

					addMullion.newStartingYRTc = addMullion.newStartingYCenter
							- partDimBtoC - partDimC;

					addMullion.newStartingYRT = addMullion.newStartingYCenter
							- partDimBtoC;

					addMullion.newStartingYLB = addMullion.newStartingYCenter
							- partDimBtoC + partDimB;

					addMullion.newStartingYLBa = addMullion.newStartingYLB
							+ partDimA;

				} else if (newMullion.offsetTL == 0) {

					addMullion.newStartingYCenter = posY + myCCalc
							+ newMullion.offsetTL;

					addMullion.newStartingYRTc = addMullion.newStartingYCenter
							- partDimBtoC - partDimC;

					addMullion.newStartingYRT = addMullion.newStartingYCenter
							- partDimBtoC;

					addMullion.newStartingYLB = addMullion.newStartingYCenter
							- partDimBtoC + partDimB;

					addMullion.newStartingYLBa = addMullion.newStartingYCenter
							- partDimBtoC + partDimB + partDimA;
				}

				newMullion.y1 = addMullion.newStartingYLB;
				newMullion.y2 = addMullion.newStartingYRT;
				newMullion.y1al = addMullion.newStartingYLBa;
				newMullion.y2cl = addMullion.newStartingYRTc;
				newMullion.centerYs = addMullion.newStartingYCenter;

				if (newMullion.offsetRB != 0) {

					newMullion.centerYe = posY + myCCalc + newMullion.offsetRB;
					newMullion.y3 = newMullion.centerYe - partDimBtoC;
					newMullion.y3cl = newMullion.centerYe - partDimBtoC
							- partDimC;
					newMullion.y4 = newMullion.centerYe - partDimBtoC
							+ partDimB;
					newMullion.y4al = newMullion.y4 + partDimA;

				} else if (newMullion.offsetRB == 0) {

					newMullion.centerYe = posY + myCCalc + newMullion.offsetRB;
					newMullion.y3 = newMullion.centerYe - partDimBtoC;
					newMullion.y3cl = newMullion.centerYe - partDimBtoC
							- partDimC;
					newMullion.y4 = newMullion.centerYe - partDimBtoC
							+ partDimB;
					newMullion.y4al = newMullion.centerYe - partDimBtoC
							+ partDimB + partDimA;
				}

				// Verify limits Left & Right for mullion
				addMullion.verifyLimitLR(newMullion);

				// Init calculation mullion
				addMullion.calcMullion = new CalculateMullionHii(addMullion);
				addMullion.newStartingYCenter = newMullion.centerYe;
				addMullion.newStartingYRTc = newMullion.y3cl;
				addMullion.newStartingYRT = newMullion.y2;
				addMullion.newStartingYLB = newMullion.y1;
				addMullion.newStartingYLBa = newMullion.y1al;

				// Calculate maximum value from bx3 & bx2
				addMullion.hcEndX = Math.max(bOpeningObject.bX3,
						bOpeningObject.bX2);

				// Calculate coordinates for mullion
				addMullion.calcMullion.calculateCoord(newMullion);

				// Recalculate mullion bill of materials
				addMullion.resetRecalcMullionBom(newMullion);

				// Adding horizontal mullion to background Opening collection
				bOpeningObject.mullionsH.add(newMullion);
			}

			// Parse opening collection to array of values
			// bOpeningObject.openings.toArray();

			// Parsing mullions collection to mullion objects collection
			bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
			bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();

			// Recalculate vertical coordinates
			addMullion.recalcVCCoords();
			// Reorder notches values
			addMullion.reOrderHMNotches();

			// Clear parts objects
			bOpeningObject.partObjects.clear();

			// Reset parts objects
			bOpeningObject.resetParts();

			// bOpeningObject.myParent.doOpenings();
		}

		return bOpeningObject;
	}

	public BkgrdOpeningObject VMCGEqualize(BkgrdOpeningObject bOpeningObject)
			throws Exception {

		/**
		 * Evaluate if vertical mullions collection is not empty
		 */
		if (bOpeningObject != null && bOpeningObject.mullions != null
				&& bOpeningObject.mullions.size() > 0) {

			// Create AddMullion Vertical class for processing collection
			AddMullionV addMullion = new AddMullionV(bOpeningObject,
					myFrame2.jobItem, myFrame2, 1);

			// Calculate dimension for mullion with number of columns for
			// division
			addMullion.getDimsForMullion(bOpeningObject.xCols, 2);

			// Init array of mullions
			Object[] mVs = bOpeningObject.mullions.toArray();
			bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
			// Clear actual vertical mullion collection for BkgrdOpening
			bOpeningObject.mullions.clear();

			// Init count for mullions objects
			int count = 0;

			for (Object vc : mVs) {

				// Clone mullion object to new object
				Profiles newMullion = (Profiles) ((Profiles) vc)
						.cloneProfile(((Profiles) vc));

				newMullion.clearBomForProfile();

				newMullion.executeRulesMethod("shapeObject.VMCGEqualise.18587");

				newMullion.executePartRules(true, true,
						"shapeObject.VMCGEqualise.18587");

				double partDimA = 0;
				double partDimB = 0;
				double partDimBtoC = 0; // Where the Center of Mullion
				// (screw Ports is)
				double partDimC = 0;
				double partDimD = 0;
				double partDimM = 0;

				if (this.myFrame2.mySeries.getSeriesUom() == 1) {
					partDimA = addMullion.partDimA = newMullion.partDimA;
					partDimB = addMullion.partDimB = addMullion.thickness = newMullion.partDimB;
					partDimC = addMullion.partDimC = newMullion.partDimC;
					partDimD = addMullion.partDimD = newMullion.partDimD;
					partDimM = addMullion.partDimM = newMullion.partDimM;
					partDimBtoC = addMullion.partDimBtoC = newMullion.partDimBtoC;

				} else {
					partDimA = addMullion.partDimA = newMullion.partDimAi;
					partDimB = addMullion.partDimB = addMullion.thickness = newMullion.partDimBi;
					partDimC = addMullion.partDimC = newMullion.partDimCi;
					partDimD = addMullion.partDimD = newMullion.partDimDi;
					partDimM = addMullion.partDimM = newMullion.partDimMi;
					partDimBtoC = addMullion.partDimBtoC = newMullion.partDimBtoCi;
				}

				if (newMullion.exists == 1) {
					count++;
				}

				// Init offserts values to zero
				newMullion.offsetTL = 0;
				newMullion.offsetRB = 0;

				// Sum thickness values for collection mullions
				double sumPrev = 0;

				for (final Object vc2 : mVs) {
					if (((Profiles) vc2).rowCol < ((Profiles) vc).rowCol
							&& ((Profiles) vc2).exists == 1) {
						sumPrev = sumPrev + ((Profiles) vc2).thickness;
					}
				}

				double posX = Math.min(bOpeningObject.startingX,
						bOpeningObject.bX4)
						+ addMullion.newColW
						* newMullion.rowCol + sumPrev;

				final double myD = Math.max(newMullion.offsetTL,
						newMullion.offsetRB)
						- Math.min(newMullion.offsetTL, newMullion.offsetRB);

				if (newMullion.offsetTL != 0) {

					addMullion.getDeltaAndTheta(newMullion, myD);

					final double hypBtoC = partDimBtoC;
					final double hypC = partDimC;
					final double hypB = partDimB;
					final double hypA = partDimA;
					final double offsetXc = 0;

					addMullion.newStartingXCenter = posX + partDimB
							- partDimBtoC + newMullion.offsetTL + offsetXc;

					addMullion.newStartingXRTc = addMullion.newStartingXCenter
							+ hypBtoC + hypC;

					addMullion.newStartingXRT = addMullion.newStartingXCenter
							+ hypBtoC;

					addMullion.newStartingXLB = addMullion.newStartingXCenter
							+ hypBtoC - hypB;

					addMullion.newStartingXLBa = addMullion.newStartingXLB
							- hypA;

				} else if (newMullion.offsetTL == 0) {

					addMullion.newStartingXCenter = posX + partDimB
							- partDimBtoC + newMullion.offsetTL;

					addMullion.newStartingXRTc = addMullion.newStartingXCenter
							+ partDimBtoC + partDimC;

					addMullion.newStartingXRT = addMullion.newStartingXCenter
							+ partDimBtoC;

					addMullion.newStartingXLB = addMullion.newStartingXCenter
							+ partDimBtoC - partDimB;

					addMullion.newStartingXLBa = addMullion.newStartingXLB
							- partDimA;
				}

				newMullion.x1 = addMullion.newStartingXLB;

				newMullion.x2 = addMullion.newStartingXRT;

				newMullion.x1al = addMullion.newStartingXLBa;

				newMullion.x2cl = addMullion.newStartingXRTc;

				newMullion.centerXs = addMullion.newStartingXCenter;

				if (newMullion.offsetRB != 0) {
					addMullion.getDeltaAndTheta(newMullion, myD);

					final double hypBtoC = partDimBtoC;
					final double hypC = partDimC;
					final double hypB = partDimB;
					final double hypA = partDimA;
					final double offsetXc = 0;

					newMullion.centerXe = posX + partDimB - partDimBtoC
							+ newMullion.offsetRB + offsetXc;

					newMullion.x3 = newMullion.centerXe + hypBtoC;

					newMullion.x3cl = newMullion.x3 + hypC;

					newMullion.x4 = newMullion.x3 - hypB;

					newMullion.x4al = newMullion.x4 - hypA;

				} else if (newMullion.offsetRB == 0) {

					newMullion.centerXe = posX + partDimB - partDimBtoC

					- newMullion.offsetRB;

					newMullion.x3 = newMullion.centerXe + partDimBtoC;

					newMullion.x3cl = newMullion.x3 + partDimC;

					newMullion.x4 = newMullion.x3 - partDimB;

					newMullion.x4al = newMullion.x4 - partDimA;
				}

				// Verify Left and Right limits
				addMullion.verifyLimitLR(newMullion);

				// Init calculate mullion vertical
				addMullion.calcMullion = new CalculateMullionV(addMullion);

				addMullion.calcMullion.calculateCoord(newMullion);
				newMullion.length = Math.abs(newMullion.centerYe
						- newMullion.centerYs);
				newMullion.isNew = false;

				// Recalculate mullion boms
				addMullion.resetRecalcMullionBom(newMullion);

				// Adding mullion to background opening
				bOpeningObject.mullions.add(newMullion);
			}

			// Parse opening collection to array of values
			bOpeningObject.openings.toArray();

			// Setting mullions vertical & horizontal to mullionObject
			// collections
			bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
			bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();

			// Recalculate horizontal coordinates
			addMullion.recalcHCCoords();
			// Recalculate Vertical corrdinates
			addMullion.reOrderVNotches();

			// Clear parts objects collection
			// bOpeningObject.partObjects.clear();

			// Reset parts objects
			bOpeningObject.resetParts();

			addMullion.splitParts(null, false, false);
		}

		return bOpeningObject;
	}

	public BkgrdOpeningObject modifyVMHeight(BkgrdOpeningObject bOpeningObject)
			throws Exception {

		/**
		 * Evaluate if horizontal mullions is not empty
		 */
		if (bOpeningObject.mullions.size() > 0) {

			// Create AddMullion Vertical class for processing collection
			AddMullionV addMullion = new AddMullionV(bOpeningObject,
					myFrame2.jobItem, myFrame2, 1);

			// Calculate mullion dimension
			addMullion.getDimsForMullion(bOpeningObject.xCols, 2);

			// Inicialize
			Object[] mVs = bOpeningObject.mullions.toArray();

			bOpeningObject.mullions.clear();

			final double newW = addMullion.newColW;

			for (final Object vc : mVs) {

				Profiles newMullion = (Profiles) ((Profiles) vc)
						.cloneProfile(((Profiles) vc));

				newMullion
						.executeRulesMethod("shapeobejct.modifyVMheight.18790");

				newMullion.bom.clear();
				newMullion.clearBomForProfile();

				// newMullion = (Profiles)
				// myFrame2.executePartRules.executePartRules(null, null,
				// newMullion, newMullion.a_assemblyLevel, true, true,
				// "shapeobject.modifyVMHeight.18796", true);

				double partDimA = 0;

				double partDimB = 0;

				double partDimBtoC = 0; // Where the Center of Mullion
				// (screw Ports is)

				double partDimC = 0;

				double partDimD = 0;

				double partDimM = 0;

				if (this.myFrame2.mySeries.getSeriesUom() == 1) {

					partDimA = addMullion.partDimA = newMullion.partDimA;
					partDimB = addMullion.partDimA = addMullion.thickness = newMullion.partDimB;
					partDimC = addMullion.partDimC = newMullion.partDimC;
					partDimD = addMullion.partDimD = newMullion.partDimD;
					partDimM = addMullion.partDimM = newMullion.partDimM;
					partDimBtoC = addMullion.partDimBtoC = newMullion.partDimBtoC;

				} else {
					partDimA = addMullion.partDimA = newMullion.partDimAi;
					partDimB = addMullion.partDimA = addMullion.thickness = newMullion.partDimBi;
					partDimC = addMullion.partDimC = newMullion.partDimCi;
					partDimD = addMullion.partDimD = newMullion.partDimDi;
					partDimM = addMullion.partDimM = newMullion.partDimMi;
					partDimBtoC = addMullion.partDimBtoC = newMullion.partDimBtoCi;
				}

				addMullion.vcStartY = bOpeningObject.startingY;

				addMullion.newStartingYRT = addMullion.vcStartY;

				addMullion.newStartingYRTc = addMullion.vcStartY;

				addMullion.newStartingYLB = addMullion.vcStartY;

				addMullion.newStartingYLBa = addMullion.vcStartY;

				addMullion.newStartingYCenter = addMullion.vcStartY;

				addMullion.verifyLimitLR(newMullion);

				addMullion.calcMullion = new CalculateMullionV(addMullion);

				addMullion.newStartingXCenter = newMullion.centerXs;

				addMullion.newStartingXRTc = newMullion.x2cl;

				addMullion.newStartingXRT = newMullion.x2;

				addMullion.newStartingXLB = newMullion.x1;

				addMullion.newStartingXLBa = newMullion.x1al;

				addMullion.vcEndY = Math.max(bOpeningObject.bY3,
						bOpeningObject.bY4);

				addMullion.calcMullion.calculateCoord(newMullion);

				addMullion.resetRecalcMullionBom(newMullion);

				bOpeningObject.mullions.add(newMullion);

			}

			bOpeningObject.openings.toArray();

			bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
			bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();

			addMullion.recalcHCCoords();
			addMullion.reOrderVNotches();

			bOpeningObject.partObjects.clear();
			bOpeningObject.resetParts();

			addMullion.splitParts(null, false, false);
			addMullion = null;
		}
		//
		return bOpeningObject;
	}

	/**
	 * This method modify Horizontal (Mullion) values for new position into
	 * BkgrdOpening for division of ShapeObject
	 * 
	 * @param bOpeningObject
	 *            , BkgrdOpeningObject
	 * @return BkgrdOpeningObject
	 */
	public BkgrdOpeningObject modifyHMWidth(
			final BkgrdOpeningObject bOpeningObject) throws Exception {// Need

		// to

		/**
		 * Process mullion horizontal collection if not empty
		 */
		if (bOpeningObject.mullionsH.size() > 0) {

			// Instantiate horizontal mullion class
			AddMullionH addMullion = new AddMullionH(bOpeningObject,
					myFrame2.jobItem, myFrame2, 1);

			// Init collection of horizontal mullions
			Object[] mHs = bOpeningObject.mullionsH.toArray();
			// Clear original mullions horizontal
			bOpeningObject.mullionsH.clear();

			for (Object vc : mHs) {

				// Clone original mullion
				Profiles newMullion = (Profiles) ((Profiles) vc)
						.cloneProfile((Profiles) vc);

				// Execute rules methods
				newMullion
						.executeRulesMethod("shapeobejct.modifyHMWidth.19129");

				// Clear mullions boms collection
				newMullion.bom.clear();

				// Clear profile boms collection
				newMullion.clearBomForProfile();

				// Execute parts rules for profiles
				// newMullion = (Profiles)
				// myFrame2.executePartRules.executePartRules(null, null,
				// newMullion, newMullion.a_assemblyLevel, true, true,
				// "shapeobject.modifyHMWidth.19139", true);

				// Get profile dimensions
				newMullion = addMullion.getProfileDims(newMullion);

				// Setting continuity value
				addMullion.continuity = newMullion.continuity;

				// Get mullion dimension vvalue
				addMullion.getDimsForMullion(bOpeningObject.yRows, 2);

				addMullion.hcStartX = bOpeningObject.startingX;
				addMullion.newStartingXRT = addMullion.hcStartX;
				addMullion.newStartingXLB = addMullion.hcStartX;
				addMullion.newStartingXRTc = addMullion.hcStartX;
				addMullion.newStartingXLBa = addMullion.hcStartX;
				addMullion.newStartingXCenter = addMullion.hcStartX;

				// Verify Left & Right limits
				addMullion.verifyLimitLR(newMullion);

				addMullion.calcMullion = new CalculateMullionHii(addMullion);
				addMullion.newStartingYCenter = newMullion.centerYs;
				addMullion.newStartingYRTc = newMullion.y2cl;
				addMullion.newStartingYRT = newMullion.y2;
				addMullion.newStartingYLB = newMullion.y1;
				addMullion.newStartingYLBa = newMullion.y1al;
				addMullion.hcEndX = Math.max(bOpeningObject.bX3,
						bOpeningObject.bX2);

				// Calculate coordinates
				addMullion.calcMullion.calculateCoord(newMullion);

				// Recalculate mullion boms
				newMullion = addMullion.resetRecalcMullionBom(newMullion);

				// Adding clone mullion to BkgrdOpening collection
				bOpeningObject.mullionsH.add(newMullion);
			}

			// Parse opening collection to array
			bOpeningObject.openings.toArray();

			// Set mullions collection to mullion object arrays
			bOpeningObject.mullionObjectsV = bOpeningObject.mullions.toArray();
			bOpeningObject.mullionObjectsH = bOpeningObject.mullionsH.toArray();

			// Recalculate coordinates and notches
			addMullion.recalcVCCoords();
			addMullion.reOrderHMNotches();

			// Clear parts object collection
			bOpeningObject.partObjects.clear();

			// Reset parts object collection
			bOpeningObject.resetParts();
		}

		return bOpeningObject;
	}

	public boolean widthTest(RuleTest test, int condition, int myUOM,
			List myRuleTestValues) {

		boolean pass = false;

		if (test.isrange) {
			if (condition != 4) {
				if (myUOM <= 1) {

					pass = isWithinRange(test.value1, test.value2, widthM);

				} else {

					pass = isWithinRange(test.value1i, test.value2i, widthI);

				}

			} else
			// Nominal <--- ---> condition 4
			{
				if (myUOM <= 1) {
					pass = isWithinRange(test.value1, test.value2, widthMN);

				} else {

					pass = isWithinRange(test.value1i, test.value2i, widthIN);

				}
			}

		} else {

			if (condition != 4) {
				if (myUOM <= 1) {

					pass = isWithinValues(widthM, myUOM,
							myRuleTestValues.toArray());

				} else {

					pass = isWithinValues(widthI, myUOM,
							myRuleTestValues.toArray());

				}

			} else {// Nominal <--- ---> Condition == 4
				if (myUOM <= 1) {

					pass = isWithinValues(widthMN, myUOM,
							myRuleTestValues.toArray());

				} else {

					pass = isWithinValues(widthIN, myUOM,
							myRuleTestValues.toArray());

				}

			}

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

	public boolean heightTest(RuleTest test, int condition, int myUOM,
			List myRuleTestValues) {

		boolean pass = false;

		if (test.isrange) {
			if (condition != 4) {
				if (myUOM <= 1) {

					pass = isWithinRange(test.value1, test.value2, heightM);

				} else {

					pass = isWithinRange(test.value1i, test.value2i, heightI);

				}

			} else
			// Nominal <--- ---> condition 4
			{
				if (myUOM <= 1) {
					pass = isWithinRange(test.value1, test.value2, heightMN);

				} else {

					pass = isWithinRange(test.value1i, test.value2i, heightIN);

				}
			}

		} else {

			if (condition != 4) {
				if (myUOM <= 1) {

					pass = isWithinValues(heightM, myUOM,
							myRuleTestValues.toArray());

				} else {

					pass = isWithinValues(heightI, myUOM,
							myRuleTestValues.toArray());

				}

			} else {// Nominal <--- ---> Condition == 4
				if (myUOM <= 1) {

					pass = isWithinValues(heightMN, myUOM,
							myRuleTestValues.toArray());

				} else {

					pass = isWithinValues(heightIN, myUOM,
							myRuleTestValues.toArray());

				}

			}

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

	public boolean areaTest(RuleTest test, int condition, int myUOM,
			List myRuleTestValues) {

		boolean pass = false;
		double area = 0;
		if (test.isrange) {
			if (condition != 4) {
				if (myUOM <= 1) {

					area = (widthM / 100 / 1000 * heightM / 100 / 1000);
					pass = isWithinRange(test.value1, test.value2, area);

				} else {

					area = (widthI / 64 * heightI / 64) / 144;
					pass = isWithinRange(test.value1i, test.value2i, area);

				}
			} else
			// Nominal <--- ---> condition 4
			{
				if (myUOM <= 1) {

					area = (widthMN / 100 / 1000 * heightMN / 100 / 1000);
					pass = isWithinRange(test.value1, test.value2, area);

				} else {

					area = (widthIN / 64 * heightIN / 64) / 144;
					pass = isWithinRange(test.value1, test.value2, area);

				}
			}

		} else {

			if (condition != 4) {
				if (myUOM <= 1) {

					area = (widthM / 100 / 1000 * heightM / 100 / 1000);
					pass = isWithinValues(area, myUOM,
							myRuleTestValues.toArray());

				} else {

					area = (widthI / 64 * heightI / 64) / 144;
					pass = isWithinValues(area, myUOM,
							myRuleTestValues.toArray());

				}
			} else
			// Nominal <--- ---> condition 4
			{
				if (myUOM <= 1) {
					area = (widthMN / 100 / 1000 * heightMN / 100 / 1000);
					pass = isWithinValues(area, myUOM,
							myRuleTestValues.toArray());

				} else {

					area = (widthIN / 64 * heightIN / 64) / 144;
					pass = isWithinValues(area, myUOM,
							myRuleTestValues.toArray());

				}
			}

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

	public boolean uiTest(RuleTest test, int condition, int myUOM,
			List myRuleTestValues) {

		boolean pass = false;
		double united = 0;
		if (test.isrange) {
			if (condition != 4) {
				if (myUOM <= 1) {

					united = (widthM / 100 + heightM / 100);
					pass = isWithinRange(test.value1 / 100, test.value2 / 100,
							united);

				} else {

					united = (widthI / 64 + heightI / 64);
					pass = isWithinRange(test.value1i / 64, test.value2i / 64,
							united);

				}
			} else
			// Nominal <--- ---> condition 4
			{
				if (myUOM <= 1) {

					united = (widthMN / 100 + heightMN / 100);
					pass = isWithinRange(test.value1 / 100, test.value2 / 100,
							united);

				} else {

					united = (widthIN / 64 + heightIN / 64);
					pass = isWithinRange(test.value1i / 64, test.value2i / 64,
							united);

				}
			}

		} else {

			if (condition != 4) {
				if (myUOM <= 1) {

					united = (widthM / 100 + heightM / 100);
					pass = isWithinValues(united * 100, myUOM,
							myRuleTestValues.toArray());

				} else {
					united = (widthI / 64 + heightI / 64);
					pass = isWithinValues(united * 64, myUOM,
							myRuleTestValues.toArray());

				}
			} else
			// Nominal <--- ---> condition 4
			{
				if (myUOM <= 1) {

					united = (widthMN / 100 + heightMN / 100);
					pass = isWithinValues(united * 100, myUOM,
							myRuleTestValues.toArray());

				} else {

					united = (widthIN / 64 + heightIN / 64);
					pass = isWithinValues(united * 64, myUOM,
							myRuleTestValues.toArray());

				}
			}

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

	public boolean optionTest(RuleTest test, int myUOM, List myRuleTestValues,
			OptionDefinitions myOption) {

		boolean pass = false;

		Object[] options = this.options.toArray();

		if (test.getRuleTestPK().getRuleno() == 111) {
			options = this.options.toArray();
		}

		for (Object op : options) {

			if (((ShapeOption) op).optionid == myOption.getId()) {

				if (myOption.getOptiontypeid() == 1) {// Answer
					if (test.isrange) {
						pass = isWithinRange(test.value1, test.value2,
								((ShapeOption) op).answerid);
					} else {
						pass = isWithinValues(((ShapeOption) op).answerid,
								myUOM, myRuleTestValues.toArray());
					}

				} else if (myOption.getOptiontypeid() == 2) {// Color

					if (test.isrange) {
						pass = isWithinRange(test.value1, test.value2,
								((ShapeOption) op).answerid);
					} else {
						pass = isWithinValues(((ShapeOption) op).answerid,
								myUOM, myRuleTestValues.toArray());
					}
				} else if (myOption.getOptiontypeid() == 3) {// quantity

					if (test.isrange) {
						pass = isWithinRange(test.value1, test.value2,
								((ShapeOption) op).qtyanswer);
					} else {
						pass = isWithinValues(((ShapeOption) op).qtyanswer,
								myUOM, myRuleTestValues.toArray());
					}
				} else if (myOption.getOptiontypeid() == 4) {// size
					if (test.isrange) {
						if (myUOM <= 1) {
							pass = isWithinRange(test.value1, test.value2,
									((ShapeOption) op).sizeanswer);
						} else {
							pass = isWithinRange(test.value1, test.value2,
									((ShapeOption) op).sizeansweri);
						}
					} else {
						if (myUOM <= 1) {
							pass = isWithinValues(
									((ShapeOption) op).sizeanswer, myUOM,
									myRuleTestValues.toArray());
						} else {
							pass = isWithinValues(
									((ShapeOption) op).sizeansweri, myUOM,
									myRuleTestValues.toArray());
						}
					}

				} else if (myOption.getOptiontypeid() == 5) {// depth
					if (test.isrange) {
						if (myUOM <= 1) {
							pass = isWithinRange(test.value1, test.value2,
									((ShapeOption) op).depthanswer);
						} else {
							pass = isWithinRange(test.value1, test.value2,
									((ShapeOption) op).depthansweri);
						}
					} else {
						if (myUOM <= 1) {
							pass = isWithinValues(
									((ShapeOption) op).depthanswer, myUOM,
									myRuleTestValues.toArray());
						} else {
							pass = isWithinValues(
									((ShapeOption) op).depthansweri, myUOM,
									myRuleTestValues.toArray());
						}
					}
				} else if (myOption.getOptiontypeid() == 6) {// text

				} else if (myOption.getOptiontypeid() == 7) {// adjust +/-
					if (test.isrange) {
						if (myUOM <= 1) {
							pass = isWithinRange(test.value1, test.value2,
									((ShapeOption) op).adjust);
						} else {
							pass = isWithinRange(test.value1, test.value2,
									((ShapeOption) op).adjusti);
						}
					} else {
						if (myUOM <= 1) {
							pass = isWithinValues(((ShapeOption) op).adjust,
									myUOM, myRuleTestValues.toArray());
						} else {
							pass = isWithinValues(((ShapeOption) op).adjusti,
									myUOM, myRuleTestValues.toArray());
						}
					}
				}
			}
		}

		return pass;
	}

	public boolean udOpeningTest(RuleTest test, List myRuleTestValues) {

		boolean pass = false;

		if (test.isrange) {

			pass = isWithinRange(test.value1, test.value2,
					this.userDefinedOpeningID);

		} else {

			pass = isWithinValues(userDefinedOpeningID, 0,
					myRuleTestValues.toArray());

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

	public boolean openingClassTest(RuleTest test, List myRuleTestValues) {

		boolean pass = false;

		if (test.isrange) {
			pass = isWithinRange(test.value1, test.value2, openingClass);

		} else {
			pass = isWithinValues(openingClass, 0, myRuleTestValues.toArray());

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

	public boolean shapeTest(RuleTest test, List myRuleTestValues) {

		boolean pass = false;

		if (test.isrange) {
			pass = isWithinRange(test.value1, test.value2, shapeID);

		} else {
			pass = isWithinValues(shapeID, 0, myRuleTestValues.toArray());

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

	public boolean sashNoTest(RuleTest test, List myRuleTestValues) {
		return false;
	}

	public boolean trackNoTest(RuleTest test, List myRuleTestValues) {
		return false;
	}

	public boolean suTypeTest(RuleTest test, List myRuleTestValues) {
		return false;
	}

	public boolean suIDTest(RuleTest test, List myRuleTestValues) {
		return false;
	}

	public boolean gridIDTest(RuleTest test, List myRuleTestValues) {
		return false;
	}

	public boolean gridTypeTest(RuleTest test, List myRuleTestValues) {
		return false;
	}

	public boolean noGridHTest(RuleTest test, List myRuleTestValues) {

		return false;
	}

	public boolean noGridVTest(RuleTest test, List myRuleTestValues) {

		return false;
	}

	public boolean noGridRTest(RuleTest test, List myRuleTestValues) {

		return false;
	}

	public boolean noGridSTest(RuleTest test, List myRuleTestValues) {

		return false;
	}

	public boolean gridIntersect4WaysTest(RuleTest test, List myRuleTestValues) {

		return false;
	}

	public boolean gridIntersect3WaysTest(RuleTest test, List myRuleTestValues) {

		return false;
	}

	public boolean gridIntersect2WaysTest(RuleTest test, List myRuleTestValues) {

		return false;
	}

	public boolean suThicknessTest(RuleTest test, int uom, List myRuleTestValues) {

		return false;
	}

	public boolean airSpaceTest(RuleTest test, int uom, List myRuleTestValues,
			int space) {

		return false;
	}

	public boolean parentLevelTest(RuleTest test, int uom,
			List myRuleTestValues, int level) {

		boolean pass = false;
		int parentLevel = 0;
		if (level == 1) {
			parentLevel = this.a_1Level;
		} else if (level == 2) {
			parentLevel = this.a_2Level;
		} else if (level == 3) {
			parentLevel = this.a_3Level;
		} else if (level == 4) {
			parentLevel = this.a_4Level;
		} else if (level == 5) {
			parentLevel = this.a_5Level;
		} else if (level == 6) {
			parentLevel = this.a_6Level;
		} else if (level == 7) {
			parentLevel = this.a_7Level;
		} else if (level == 8) {
			parentLevel = this.a_8Level;
		} else if (level == 9) {
			parentLevel = this.a_9Level;
		} else if (level == 10) {
			parentLevel = this.a_10Level;
		}

		if (test.isrange) {
			pass = isWithinRange(test.value1, test.value2, parentLevel);

		} else {
			pass = isWithinValues(parentLevel, 0, myRuleTestValues.toArray());

		}

		if (test.isnot) {
			pass = !pass;
		}

		return pass;
	}

	public boolean sequenceTest(RuleTest test, int uom, List myRuleTestValues,
			int level) {

		boolean pass = false;
		int parentSeq = 0;

		if (level == 0) {
			parentSeq = this.a_sequenceID;
		} else if (level == 1) {
			parentSeq = this.a_1Sequence;
		} else if (level == 2) {
			parentSeq = this.a_2Sequence;
		} else if (level == 3) {
			parentSeq = this.a_3Sequence;
		} else if (level == 4) {
			parentSeq = this.a_4Sequence;
		} else if (level == 5) {
			parentSeq = this.a_5Sequence;
		} else if (level == 6) {
			parentSeq = this.a_6Sequence;
		} else if (level == 7) {
			parentSeq = this.a_7Sequence;
		} else if (level == 8) {
			parentSeq = this.a_8Sequence;
		} else if (level == 9) {
			parentSeq = this.a_9Sequence;
		} else if (level == 10) {
			parentSeq = this.a_10Sequence;
		}

		if (test.isrange) {
			pass = isWithinRange(test.value1, test.value2, parentSeq);

		} else {
			pass = isWithinValues(parentSeq, 0, myRuleTestValues.toArray());

		}

		if (test.isnot) {
			pass = !pass;
		}

		return pass;
	}

	public boolean noColTest(RuleTest test, int uom, List myRuleTestValues) {

		boolean pass = false;

		if (test.isrange) {
			pass = isWithinRange(test.value1, test.value2, this.xCols);

		} else {
			pass = isWithinValues(this.xCols, 0, myRuleTestValues.toArray());

		}

		if (test.isnot) {
			pass = !pass;
		}

		return pass;
	}

	public boolean noRowTest(RuleTest test, int uom, List myRuleTestValues) {

		boolean pass = false;

		if (test.isrange) {
			pass = isWithinRange(test.value1, test.value2, this.yRows);

		} else {
			pass = isWithinValues(this.yRows, 0, myRuleTestValues.toArray());

		}

		if (test.isnot) {
			pass = !pass;
		}

		return pass;
	}

	public boolean noTrackTest(RuleTest test, int uom, List myRuleTestValues) {

		return false;
	}

	public boolean noSashesTest(RuleTest test, int uom, List myRuleTestValues) {

		return false;
	}

	public boolean radius1Test(RuleTest test, int uom, List myRuleTestValues) {

		boolean pass = false;

		if (test.isrange) {
			pass = isWithinRange(test.value1, test.value2, this.radius1);

		} else {
			pass = isWithinValues(this.radius1, 0, myRuleTestValues.toArray());

		}

		if (test.isnot) {
			pass = !pass;
		}

		return pass;
	}

	public boolean radius2Test(RuleTest test, int uom, List myRuleTestValues) {

		boolean pass = false;

		if (test.isrange) {
			pass = isWithinRange(test.value1, test.value2, this.radius2);

		} else {
			pass = isWithinValues(this.radius2, 0, myRuleTestValues.toArray());

		}

		if (test.isnot) {
			pass = !pass;
		}

		return pass;
	}

	public boolean isWithinRange(double value1, double value2, double value) {

		return value >= value1 && value <= value2;
	}

	public boolean isWithinValues(double value, int myUOM, Object[] objects) {

		boolean pass = false;
		if (myUOM <= 1) {
			for (Object tv : objects) {
				if (((RuleTestValue) tv).getRuleTestValuePK().getValue() == value) {
					pass = true;
					break;
				}
			}

		} else if (myUOM >= 2) {
			for (Object tv : objects) {
				if (((RuleTestValue) tv).getRuleTestValuePK().getValuei() == value) {
					pass = true;
					break;
				}
			}
		}
		return pass;
	}

	@Override
	public BigDecimal calculateWidth(int measure) {

		BigDecimal myRet = new BigDecimal(0);

		if (measure == 1) {

			myRet = new BigDecimal(widthM);

			// Nominal = widthMN;

		} else if (measure == 2 || measure == 3) {

			myRet = new BigDecimal(widthI);

			// Nominal = widthIN;

		} else if (measure == 4) {
			myRet = new BigDecimal(-1);

		}

		if (Double.parseDouble(myRet.toString()) <= 0) {
			// this.validResult = false;
		}

		return myRet;
	}

	@Override
	public BigDecimal calculateHeight(int measure) {

		BigDecimal myRet = new BigDecimal(0);

		if (measure == 1) {

			myRet = new BigDecimal(heightM);

		} else if (measure == 2 || measure == 3) {

			myRet = new BigDecimal(heightI);

		} else if (measure == 4) {
			myRet = new BigDecimal(-1);

		}

		if (Double.parseDouble(myRet.toString()) <= 0) {
			// this.validResult = false;
		}

		return myRet;
	}

	@Override
	public BigDecimal calculateArea(int measure) {

		BigDecimal myRet = new BigDecimal(0);

		if (measure == 1) {

			myRet = new BigDecimal(heightM / 100 / 1000 * widthM / 100 / 100);

		} else if (measure == 2 || measure == 3) {

			myRet = new BigDecimal(heightM / 64 / 12 * widthM / 64 / 12);

		} else if (measure == 4) {
			myRet = new BigDecimal(-1);

		}

		if (Double.parseDouble(myRet.toString()) <= 0) {
			// this.validResult = false;
		}

		return myRet;
	}

	@Override
	public BigDecimal calculateUI(int measure) {

		BigDecimal myRet = new BigDecimal(0);

		if (measure == 1) {

			myRet = new BigDecimal(heightM + widthM);

		} else if (measure == 2 || measure == 3) {

			myRet = new BigDecimal(heightI + widthI);

		} else if (measure == 4) {
			myRet = new BigDecimal(-1);

		}

		if (Double.parseDouble(myRet.toString()) <= 0) {
			// this.validResult = false;
		}

		return myRet;
	}

	@Override
	public BigDecimal returnOpeningClassID() {
		return new BigDecimal(this.openingClass);
	}

	@Override
	public BigDecimal returnShapeID() {
		return new BigDecimal(shapeID);
	}

	@Override
	public BigDecimal returnOptionAndAnswer(int optionid, int uom) {

		// Search All Options for Options fro this matrixCalculation
		// Why Search All options?
		// because we do not know if the
		// Shape was modified and options reset.

		BigDecimal returnValue = new BigDecimal(0);

		// Object[] optionsAll = myFrame2.designOptionsAll.toArray();
		Object[] optionsAll = options.toArray();
		for (Object o : optionsAll) {
			// if (((DesignOption) o).isForShape(this)) {
			if (((ShapeOption) o).optionid == optionid) {
				if (((ShapeOption) o).myoption.getOptiontypeid() <= 2) {
					returnValue = new BigDecimal(((ShapeOption) o).answerid);
					break;
				}
				if (((ShapeOption) o).myoption.getOptiontypeid() == 3) {
					returnValue = new BigDecimal(((ShapeOption) o).qtyanswer);
				} else if (((ShapeOption) o).myoption.getOptiontypeid() == 4) {
					if (uom == 1) {
						returnValue = new BigDecimal(
								((ShapeOption) o).sizeanswer);
						break;
					} else {
						returnValue = new BigDecimal(
								((ShapeOption) o).sizeansweri);
						break;
					}

				} else if (((ShapeOption) o).myoption.getOptiontypeid() == 5) {
					if (uom == 1) {
						returnValue = new BigDecimal(
								((ShapeOption) o).depthanswer);
						break;
					} else {
						returnValue = new BigDecimal(
								((ShapeOption) o).depthansweri);
						break;
					}
				} else if (((ShapeOption) o).myoption.getOptiontypeid() == 6) {
					returnValue = new BigDecimal(((ShapeOption) o).textAnswer);
					break;
				} else if (((ShapeOption) o).myoption.getOptiontypeid() == 7) {
					if (uom == 1) {
						returnValue = new BigDecimal(((ShapeOption) o).adjust);
						break;
					} else {
						returnValue = new BigDecimal(((ShapeOption) o).adjusti);
						break;
					}
				}
				// break; //??????
			}
		}
		return returnValue;
	}

	@Override
	public BigDecimal returnUserDefinedOpeningID() {
		return new BigDecimal(this.userDefinedOpeningID);
	}

	@Override
	public BigDecimal returnPartnerIdentificationID() {
		return new BigDecimal(myFrame2.myCustomer.getId());
	}

	@Override
	public BigDecimal returnPartnerGroupID() {
		return new BigDecimal(myFrame2.myCustomer.getGroupId());
	}

	@Override
	public BigDecimal returnDesignID() {
		return new BigDecimal(myFrame2.jobItem.designID);
	}

	@Override
	public BigDecimal returnStdProductID() {
		return new BigDecimal(myFrame2.jobItem.stdProdCode);
	}

	@Override
	public BigDecimal returnProductType() {
		return new BigDecimal(-1);
	}

	@Override
	public BigDecimal calculateLength(int systemMeasurement) {
		return new BigDecimal(-1);
	}

	@Override
	public BigDecimal returnQty() {
		return new BigDecimal(-1);
	}

	@Override
	public BigDecimal calculateVolume(int systemMeasurement) {
		return new BigDecimal(-1);
	}

	@Override
	public BigDecimal returnStockCode() {
		return new BigDecimal(-1);
	}

	@Override
	public BigDecimal returnGridType() {
		return new BigDecimal(-1);
	}

	@Override
	public BigDecimal returnGridID() {
		return new BigDecimal(-1);
	}

	@Override
	public BigDecimal returnNumberGridsW() {
		return new BigDecimal(-1);
	}

	@Override
	public BigDecimal returnNumberGridsH() {
		return new BigDecimal(-1);
	}

	@Override
	public BigDecimal returnNumberSpokes() {
		return new BigDecimal(-1);
	}

	@Override
	public BigDecimal returnNumberRadii() {
		return new BigDecimal(-1);
	}

	@Override
	public BigDecimal returnSUFamiles() {
		return new BigDecimal(-1);
	}

	public boolean isMatchingRule(Rules rule) {

		boolean match = false;

		if (rule.assemblyid == this.a_assemblyLevel) {
			if (rule.p1 > 0) {
				if (rule.p1 == a_1Level) {
					if (rule.p2 > 0) {
						if (rule.p2 == a_2Level) {
							if (rule.p3 > 0) {
								if (rule.p3 == a_3Level) {
									if (rule.p4 > 0) {
										if (rule.p4 == a_4Level) {
											if (rule.p5 > 0) {
												if (rule.p5 == a_5Level) {
													if (rule.p6 > 0) {
														if (rule.p6 == a_6Level) {
															if (rule.p7 > 0) {

																if (rule.p7 == a_7Level) {
																	if (rule.p8 > 0) {

																		if (rule.p8 == a_8Level) {
																			if (rule.p9 > 0) {
																				if (rule.p9 == a_9Level) {
																					if (rule.p10 > 0) {
																						if (rule.p10 == a_10Level) {
																							if (rule.p11 > 0) {
																								if (rule.p1 == a_11Level) {
																									if (rule.p12 > 0) {
																										if (rule.p12 == a_12Level) {
																											if (rule.p13 > 0) {
																												if (rule.p13 == a_13Level) {
																													if (rule.p14 > 0) {
																														if (rule.p15 == a_15Level) {
																															if (rule.p16 > 0) {
																																if (rule.p16 == a_16Level) {
																																	if (rule.p17 > 0) {
																																		if (rule.p17 == a_17Level) {
																																			if (rule.p18 > 0) {
																																				if (rule.p18 == a_18Level) {
																																					if (rule.p19 > 0) {
																																						if (rule.p19 == a_19Level) {
																																							if (rule.p20 > 0) {
																																								if (rule.p20 == a_20Level) {
																																									if (rule.p21 > 0) {
																																										if (rule.p21 == a_21Level) {
																																											if (rule.p22 > 0) {
																																												if (rule.p22 == a_22Level) {

																																													match = true;

																																												}
																																											} else {
																																												// match
																																												// =
																																												// true;
																																											}
																																										}
																																									} else {
																																										match = true;
																																									}
																																								}
																																							} else {
																																								match = true;
																																							}
																																						}
																																					} else {
																																						match = true;
																																					}
																																				}
																																			} else {
																																				match = true;
																																			}
																																		}
																																	} else {
																																		match = true;
																																	}
																																}
																															} else {
																																match = true;
																															}
																														}
																													} else {
																														match = true;
																													}
																												}
																											} else {
																												match = true;
																											}
																										}
																									} else {
																										match = true;
																									}
																								}
																							} else {
																								match = true;
																							}
																						}
																					} else {
																						match = true;
																					}
																				}
																			} else {
																				match = true;// p8
																				// match
																			}
																		}// p8

																	} else {
																		match = true;// p7
																		// match
																	}
																}// p7
															} else {
																match = true;// p6
																// match
															}
														}// p6
													} else {
														match = true;// p5
														// match
													}
												}
											} else {
												match = true;
											}
										}
									} else {
										match = true;
									}
								}
							} else {
								match = true;
							}
						}
					} else {
						match = true;
					}
				}
			} else {
				match = true;
			}

		}

		//
		// if(rule.getAssemblyID()>1){
		//
		// if(rule.getAssemblyID() >= this.a_levelID){
		//
		// if (((rule.getRuletype()>= 9 && rule.getRuletype()<= 18) ||
		// (rule.getRuletype()>= 90 && rule.getRuletype()<= 94)) ) {
		//
		// match = true;
		//
		// }
		// }
		// }

		return match;
	}

	public boolean isMatchingRuleII(Rules rule) {

		boolean match = false;
		if (rule.getRulesPK().getId() == 148) {
			match = false;
		}
		if (rule.assemblyid == this.a_assemblyLevel) {
			if (rule.p1 > 0) {
				if (rule.p1 >= a_1Level) {
					if (rule.p2 > 0) {
						if (rule.p2 >= a_2Level) {
							if (rule.p3 > 0) {
								if (rule.p3 >= a_3Level) {
									if (rule.p4 > 0) {
										if (rule.p4 >= a_4Level) {
											if (rule.p5 > 0) {
												if (rule.p5 >= a_5Level) {
													if (rule.p6 > 0) {
														if (rule.p6 >= a_6Level) {
															if (rule.p7 > 0) {

																if (rule.p7 >= a_7Level) {
																	if (rule.p8 > 0) {

																		if (rule.p8 >= a_8Level) {
																			if (rule.p9 > 0) {
																				if (rule.p9 >= a_9Level) {
																					if (rule.p10 > 0) {
																						if (rule.p10 >= a_10Level) {
																							if (rule.p11 > 0) {
																								if (rule.p1 >= a_11Level) {
																									if (rule.p12 > 0) {
																										if (rule.p12 >= a_12Level) {
																											if (rule.p13 > 0) {
																												if (rule.p13 >= a_13Level) {
																													if (rule.p14 > 0) {
																														if (rule.p15 >= a_15Level) {
																															if (rule.p16 > 0) {
																																if (rule.p16 >= a_16Level) {
																																	if (rule.p17 > 0) {
																																		if (rule.p17 >= a_17Level) {
																																			if (rule.p18 > 0) {
																																				if (rule.p18 >= a_18Level) {
																																					if (rule.p19 > 0) {
																																						if (rule.p19 >= a_19Level) {
																																							if (rule.p20 > 0) {
																																								if (rule.p20 >= a_20Level) {
																																									if (rule.p21 > 0) {
																																										if (rule.p21 >= a_21Level) {
																																											if (rule.p22 > 0) {
																																												if (rule.p22 >= a_22Level) {

																																													match = true;

																																												}
																																											} else {
																																												match = true;
																																											}
																																										}
																																									} else {
																																										match = true;
																																									}
																																								}
																																							} else {
																																								match = true;
																																							}
																																						}
																																					} else {
																																						match = true;
																																					}
																																				}
																																			} else {
																																				match = true;
																																			}
																																		}
																																	} else {
																																		match = true;
																																	}
																																}
																															} else {
																																match = true;
																															}
																														}
																													} else {
																														match = true;
																													}
																												}
																											} else {
																												match = true;
																											}
																										}
																									} else {
																										match = true;
																									}
																								}
																							} else {
																								match = true;
																							}
																						}
																					} else {
																						match = true;
																					}
																				}
																			} else {
																				match = true;// p8
																				// match
																			}
																		}// p8

																	} else {
																		match = true;// p7
																		// match
																	}
																}// p7
															} else {
																match = true;// p6
																// match
															}
														}// p6
													} else {
														match = true;// p5
														// match
													}
												}
											} else {
												match = true;
											}
										}
									} else {
										match = true;
									}
								}
							} else {
								match = true;
							}
						}
					} else {
						match = true;
					}
				}
			} else {
				match = true;
			}

		}

		return match;
	}

	public boolean isMatchingOptionRule(Rules rule) {

		boolean match = false;

		if ((rule.getAssemblyID() <= this.a_assemblyLevel)// ||
															// rule.getLevelID()
															// <= this.a_1Level)
				&& (rule.getAssemblyID() >= 40 || rule.getAssemblyID() <= 28)
				&& rule.getAssemblyID() != 30 && rule.getAssemblyID() != 31) {

			match = true;

		}

		return match;
	}

	public boolean isExactMatchingOptionRule(Rules rule) {

		boolean match = false;

		if ((rule.getAssemblyID() == this.a_assemblyLevel)// ||
															// rule.getLevelID()
															// <= this.a_1Level)
				&& (rule.getAssemblyID() >= 40 || rule.getAssemblyID() <= 28)
				&& rule.getAssemblyID() != 30 && rule.getAssemblyID() != 31) {

			match = true;

		}

		return match;
	}

	public ShapeObject copyParts(final ShapeObject original) {

		this.top1Part.partDimC = original.top1Part.partDimC;
		this.top1Part.partDimB = original.top1Part.partDimB;
		this.top1Part.partDimA = original.top1Part.partDimA;
		this.top1Part.partDimM = original.top1Part.partDimM;
		this.top1Part.partID = original.top1Part.partID;
		this.top1Part.partForm = original.top1Part.partForm;
		this.top1Part.endTypeLT = original.top1Part.endTypeLT;
		this.top1Part.endTypeRB = original.top1Part.endTypeRB;

		this.top2Part.partDimC = original.top2Part.partDimC;
		this.top2Part.partDimB = original.top2Part.partDimB;
		this.top2Part.partDimA = original.top2Part.partDimA;
		this.top2Part.partDimM = original.top2Part.partDimM;
		this.top2Part.partID = original.top2Part.partID;
		this.top2Part.partForm = original.top2Part.partForm;
		this.top2Part.endTypeLT = original.top2Part.endTypeLT;
		this.top2Part.endTypeRB = original.top2Part.endTypeRB;

		this.top3Part.partDimC = original.top3Part.partDimC;
		this.top3Part.partDimB = original.top3Part.partDimB;
		this.top3Part.partDimA = original.top3Part.partDimA;
		this.top3Part.partDimM = original.top3Part.partDimM;
		this.top3Part.partID = original.top3Part.partID;
		this.top3Part.partForm = original.top3Part.partForm;
		this.top3Part.endTypeLT = original.top3Part.endTypeLT;
		this.top3Part.endTypeRB = original.top3Part.endTypeRB;

		this.bot1Part.partDimC = original.bot1Part.partDimC;
		this.bot1Part.partDimB = original.bot1Part.partDimB;
		this.bot1Part.partDimA = original.bot1Part.partDimA;
		this.bot1Part.partDimM = original.bot1Part.partDimM;
		this.bot1Part.partID = original.bot1Part.partID;
		this.bot1Part.partForm = original.bot1Part.partForm;
		this.bot1Part.endTypeLT = original.bot1Part.endTypeLT;
		this.bot1Part.endTypeRB = original.bot1Part.endTypeRB;

		this.bot2Part.partDimC = original.bot2Part.partDimC;
		this.bot2Part.partDimB = original.bot2Part.partDimB;
		this.bot2Part.partDimA = original.bot2Part.partDimA;
		this.bot2Part.partDimM = original.bot2Part.partDimM;
		this.bot2Part.partID = original.bot2Part.partID;
		this.bot2Part.partForm = original.bot2Part.partForm;
		this.bot2Part.endTypeLT = original.bot2Part.endTypeLT;
		this.bot2Part.endTypeRB = original.bot2Part.endTypeRB;

		this.bot3Part.partDimC = original.bot3Part.partDimC;
		this.bot3Part.partDimB = original.bot3Part.partDimB;
		this.bot3Part.partDimA = original.bot3Part.partDimA;
		this.bot3Part.partDimM = original.bot3Part.partDimM;
		this.bot3Part.partID = original.bot3Part.partID;
		this.bot3Part.partForm = original.bot3Part.partForm;
		this.bot3Part.endTypeLT = original.bot3Part.endTypeLT;
		this.bot3Part.endTypeRB = original.bot3Part.endTypeRB;

		this.leftPart.partDimC = original.leftPart.partDimC;
		this.leftPart.partDimB = original.leftPart.partDimB;
		this.leftPart.partDimA = original.leftPart.partDimA;
		this.leftPart.partDimM = original.leftPart.partDimM;
		this.leftPart.partID = original.leftPart.partID;
		this.leftPart.partForm = original.leftPart.partForm;
		this.leftPart.endTypeLT = original.leftPart.endTypeLT;
		this.leftPart.endTypeRB = original.leftPart.endTypeRB;

		this.rightPart.partDimC = original.rightPart.partDimC;
		this.rightPart.partDimB = original.rightPart.partDimB;
		this.rightPart.partDimA = original.rightPart.partDimA;
		this.rightPart.partDimM = original.rightPart.partDimM;
		this.rightPart.partID = original.rightPart.partID;
		this.rightPart.partForm = original.rightPart.partForm;
		this.rightPart.endTypeLT = original.rightPart.endTypeLT;
		this.rightPart.endTypeRB = original.rightPart.endTypeRB;

		this.top1.partDimC = original.top1.partDimC;
		this.top1.partDimB = original.top1.partDimB;
		this.top1.partDimA = original.top1.partDimA;
		this.top1.partDimM = original.top1.partDimM;
		this.top1.partID = original.top1.partID;
		this.top1.partForm = original.top1.partForm;

		this.top2.partDimC = original.top2.partDimC;
		this.top2.partDimB = original.top2.partDimB;
		this.top2.partDimA = original.top2.partDimA;
		this.top2.partDimM = original.top2.partDimM;
		this.top2.partID = original.top2.partID;
		this.top2.partForm = original.top2.partForm;

		this.top3.partDimC = original.top3.partDimC;
		this.top3.partDimB = original.top3.partDimB;
		this.top3.partDimA = original.top3.partDimA;
		this.top3.partDimM = original.top3.partDimM;
		this.top3.partID = original.top3.partID;
		this.top3.partForm = original.top3.partForm;

		this.bot1.partDimC = original.bot1.partDimC;
		this.bot1.partDimB = original.bot1.partDimB;
		this.bot1.partDimA = original.bot1.partDimA;
		this.bot1.partDimM = original.bot1.partDimM;
		this.bot1.partID = original.bot1.partID;
		this.bot1.partForm = original.bot1.partForm;

		this.bot2.partDimC = original.bot2.partDimC;
		this.bot2.partDimB = original.bot2.partDimB;
		this.bot2.partDimA = original.bot2.partDimA;
		this.bot2.partDimM = original.bot2.partDimM;
		this.bot2.partID = original.bot2.partID;
		this.bot2.partForm = original.bot2.partForm;

		this.bot3.partDimC = original.bot3.partDimC;
		this.bot3.partDimB = original.bot3.partDimB;
		this.bot3.partDimA = original.bot3.partDimA;
		this.bot3.partDimM = original.bot3.partDimM;
		this.bot3.partID = original.bot3.partID;
		this.bot3.partForm = original.bot3.partForm;

		this.left.partDimC = original.left.partDimC;
		this.left.partDimB = original.left.partDimB;
		this.left.partDimA = original.left.partDimA;
		this.left.partDimM = original.left.partDimM;
		this.left.partID = original.left.partID;
		this.left.partForm = original.left.partForm;

		this.right.partDimC = original.right.partDimC;
		this.right.partDimB = original.right.partDimB;
		this.right.partDimA = original.right.partDimA;
		this.right.partDimM = original.right.partDimM;
		this.right.partID = original.right.partID;
		this.right.partForm = original.right.partForm;

		return this;

	}

	public void clearBomForShape() {
		// sherif
		Object[] boms = this.myFrame2.jobItem.bom.toArray();

		this.myFrame2.jobItem.bom.clear();

		for (Object b : boms) {
			if (!((BillOfMat) b).isForShape(this)) {
				this.myFrame2.jobItem.bom.add((BillOfMat) b);
			}
		}

	}

	public void clearGlassBomForShape() {

		Object[] boms = this.myFrame2.jobItem.glassBOM.toArray();

		this.myFrame2.jobItem.glassBOM.clear();

		for (Object b : boms) {
			if (!((DesignGlass) b).isForShape(this)) {
				this.myFrame2.jobItem.glassBOM.add((DesignGlass) b);
			}
		}

	}

	public ShapeObject cloneShapeFromParentOpening(ShapeObject op) {

		this.rID = op.rID;
		this.myFrame2 = op.myFrame2;
		this.myParentO = (OpeningObject) op;
		this.myParent = this.myOverall = this.myFacet = op.myParent;
		this.myParentF = op.myParentF;

		this.shapeID = op.shapeID;
		this.a_sequenceID = op.a_sequenceID;

		this.a_1Level = op.a_assemblyLevel;
		this.a_1Sequence = op.a_sequenceID;
		this.a_2Level = op.a_1Level;
		this.a_2Sequence = op.a_1Sequence;
		this.a_3Level = op.a_2Level;
		this.a_3Sequence = op.a_2Sequence;
		this.a_4Level = op.a_3Level;
		this.a_4Sequence = op.a_3Sequence;

		this.a_5Level = op.a_4Level;
		this.a_5Sequence = op.a_4Sequence;
		this.a_6Level = op.a_5Level;
		this.a_6Sequence = op.a_5Sequence;
		this.a_7Level = op.a_6Level;
		this.a_7Sequence = op.a_6Sequence;
		this.a_8Level = op.a_7Level;
		this.a_8Sequence = op.a_7Sequence;
		this.a_9Level = op.a_8Level;
		this.a_9Sequence = op.a_8Sequence;
		this.a_10Level = op.a_9Level;
		this.a_10Sequence = op.a_9Sequence;

		this.a_11Level = op.a_10Level;
		this.a_11Sequence = op.a_10Sequence;
		this.a_12Level = op.a_11Level;
		this.a_12Sequence = op.a_11Sequence;
		this.a_13Level = op.a_12Level;
		this.a_13Sequence = op.a_12Sequence;
		this.a_14Level = op.a_13Level;
		this.a_15Sequence = op.a_13Sequence;
		this.a_15Level = op.a_14Level;
		this.a_15Sequence = op.a_14Sequence;
		this.a_16Level = op.a_15Level;
		this.a_16Sequence = op.a_15Sequence;
		this.a_17Level = op.a_16Level;
		this.a_17Sequence = op.a_16Sequence;
		this.a_18Level = op.a_17Level;
		this.a_18Sequence = op.a_17Sequence;
		this.a_19Level = op.a_18Level;
		this.a_19Sequence = op.a_18Sequence;
		this.a_20Level = op.a_19Level;
		this.a_20Sequence = op.a_19Sequence;
		this.a_21Level = op.a_20Level;
		this.a_21Sequence = op.a_20Sequence;
		this.a_22Level = op.a_21Level;
		this.a_22Sequence = op.a_21Sequence;

		this.leafNo = op.leafNo;

		this.trackNo = op.trackNo;
		this.paneType = op.paneType;

		this.wire = op.wire;

		this.highestY = op.highestY;
		this.highestYC = op.highestYC;

		if (highestY > 0 && highestYC <= 0) {
			highestYC = highestY;
		}

		this.lowestY = op.lowestY;
		this.lowestYC = op.lowestYC;
		if (lowestY > 0 && lowestYC <= 0) {
			lowestYC = lowestY;
		}
		this.startingX = op.startingX;
		this.startingY = op.startingY;

		this.startCol = op.startCol;
		this.endCol = op.endCol;
		this.startRow = op.startRow;
		this.endRow = op.endRow;

		this.widthPix = op.widthPix;
		this.heightPix = op.heightPix;

		this.widthM = op.widthM;
		this.widthMO = op.widthMO;
		this.widthMN = op.widthMN;
		this.heightM = op.heightM;
		this.heightMN = op.heightMN;
		this.heightMO = op.heightMO;

		this.widthI = op.widthI;
		this.widthIN = op.widthIN;
		this.widthIO = op.widthIO;
		this.heightI = op.heightI;
		this.heightIN = op.heightIN;
		this.heightIO = op.heightIO;

		// this.startingX = op.startingX;
		// this.startingY = op.startingY;

		this.radius1 = op.radius1;
		this.radius2 = op.radius2;

		this.shapeChanged = op.shapeChanged;

		this.bkgrdStartX = op.bkgrdStartX;
		this.bkgrdStartY = op.bkgrdStartY;

		this.noSides = op.noSides;
		this.noSidesTop = op.noSidesTop;
		this.noSidesBot = op.noSidesBot;
		this.noSidesLeft = op.noSidesLeft;
		this.noSidesRight = op.noSidesRight;

		this.centerPointX = op.centerPointX;
		this.centerPointX2 = op.centerPointX2;
		this.centerPointY = op.centerPointY;
		this.centerPointY2 = op.centerPointY2;

		this.bX2 = op.bX2;
		this.bY2 = op.bY2;
		this.bX3 = op.bX3;
		this.bY3 = op.bY3;
		this.bX4 = op.bX4;
		this.bY4 = op.bY4;

		this.startingCX = op.startingCX;
		this.startingCY = op.startingCY;

		this.bCX2 = op.bCX2;
		this.bCY2 = op.bCY2;
		this.bCX3 = op.bCX3;
		this.bCY3 = op.bCY3;
		this.bCX4 = op.bCX4;
		this.bCY4 = op.bCY4;

		this.dimA1 = op.dimA1;
		this.dimA2 = op.dimA2;
		this.dimA3 = op.dimA3;
		this.dimA4 = op.dimA4;
		this.dimA5 = op.dimA5;
		this.dimA0 = op.dimA0;
		this.dimB1 = op.dimB1;
		this.dimB2 = op.dimB2;
		this.dimB3 = op.dimB3;
		this.dimB4 = op.dimB4;
		this.dimB5 = op.dimB5;
		this.dimB0 = op.dimB0;
		this.dimC1 = op.dimC1;
		this.dimC2 = op.dimC2;
		this.dimC3 = op.dimC3;
		this.dimC4 = op.dimC4;
		this.dimC5 = op.dimC5;
		this.dimC0 = op.dimC0;
		this.dimD1 = op.dimD1;
		this.dimD2 = op.dimD2;
		this.dimD3 = op.dimD3;
		this.dimD4 = op.dimD4;
		this.dimD5 = op.dimD5;
		this.dimD0 = op.dimD0;

		this.dimTM = op.dimTM;
		this.dimBM = op.dimBM;
		this.dimLM = op.dimLM;
		this.dimRM = op.dimRM;
		this.dimTA = op.dimTA;
		this.dimBA = op.dimBA;
		this.dimLA = op.dimLA;
		this.dimRA = op.dimRA;

		this.topIn = op.topIn;
		this.botIn = op.botIn;
		this.leftIn = op.leftIn;
		this.rightIn = op.rightIn;

		this.lean = op.lean;
		this.lean2 = op.lean2;
		this.lean3 = op.lean3;
		this.lean4 = op.lean4;

		this.parentH = op.parentH;
		this.parentW = op.parentW;

		this.parentStartY = op.parentStartY;
		this.parentStartX = op.parentStartX;
		this.parentRadius1 = op.parentRadius1;

		this.parentCX = op.parentCX;
		this.parentCY = op.parentCY;
		this.parentCX2 = op.parentCX2;
		this.parentCY2 = op.parentCY2;
		this.parentShape = op.parentShape;

		this.px1 = op.px1;
		this.py1 = op.py1;
		this.px2 = op.px2;
		this.py2 = op.py2;
		this.px3 = op.px3;
		this.py3 = op.py3;
		this.px4 = op.px4;
		this.py4 = op.py4;
		this.px5 = op.px5;
		this.py5 = op.py5;
		this.px6 = op.px6;
		this.py6 = op.py6;
		this.px7 = op.px7;
		this.py7 = op.py7;
		this.px8 = op.px8;
		this.py8 = op.py8;

		this.startingCX = op.startingCX;
		this.startingCY = op.startingCY;

		this.px1c = op.px1c;
		this.py1c = op.py1c;
		this.px2c = op.px2c;
		this.py2c = op.py2c;
		this.px3c = op.px3c;
		this.py3c = op.py3c;
		this.px4c = op.px4c;
		this.py4c = op.py4c;
		this.px5c = op.px5c;
		this.py5c = op.py5c;
		this.px6c = op.px6c;
		this.py6c = op.py6c;
		this.px7c = op.px7c;
		this.py7c = op.py7c;
		this.px8c = op.px8c;
		this.py8c = op.py8c;

		this.bCX2 = op.bCX2;
		this.bCY2 = op.bCY2;
		this.bCX3 = op.bCX3;
		this.bCY3 = op.bCY3;
		this.bCX4 = op.bCX4;
		this.bCY4 = op.bCY4;

		this.top1Part = (Profiles) this.top1Part.cloneProfile(op.top1Part);
		this.top2Part = (Profiles) this.top2Part.cloneProfile(op.top2Part);
		this.top3Part = (Profiles) this.top3Part.cloneProfile(op.top3Part);
		this.rightPart = (Profiles) this.rightPart.cloneProfile(op.rightPart);
		this.leftPart = (Profiles) this.leftPart.cloneProfile(op.leftPart);
		this.bot1Part = (Profiles) this.bot1Part.cloneProfile(op.bot1Part);
		this.bot2Part = (Profiles) this.bot2Part.cloneProfile(op.bot2Part);
		this.bot3Part = (Profiles) this.bot3Part.cloneProfile(op.bot3Part);

		this.userDefinedOpeningID = op.userDefinedOpeningID;
		this.openingClass = op.openingClass;
		this.unGlazed = op.unGlazed;

		this.trackNo = op.trackNo;

		return this;
	}

	public ShapeObject cloneShapeObject(ShapeObject original) {

		this.myFrame2 = original.myFrame2;
		this.myParent = original.myParent;
		this.myParentO = original.myParentO;
		this.shapeID = original.shapeID;
		this.startCol = original.startCol;
		this.startRow = original.startRow;

		this.endCol = original.endCol;
		this.endRow = original.endRow;

		this.a_levelID = original.a_levelID;
		this.a_sequenceID = original.a_sequenceID;
		this.a_assemblyLevel = original.a_assemblyLevel;
		this.a_1Level = original.a_1Level;
		this.a_1Sequence = original.a_1Sequence;
		this.a_2Level = original.a_2Level;
		this.a_2Sequence = original.a_2Sequence;
		this.a_3Level = original.a_3Level;
		this.a_3Sequence = original.a_3Sequence;
		this.a_4Level = original.a_4Level;
		this.a_4Sequence = original.a_4Sequence;
		this.a_5Level = original.a_5Level;
		this.a_5Sequence = original.a_5Sequence;
		this.a_6Level = original.a_6Level;
		this.a_6Sequence = original.a_6Sequence;
		this.a_7Level = original.a_7Level;
		this.a_7Sequence = original.a_7Sequence;
		this.a_8Level = original.a_8Level;
		this.a_8Sequence = original.a_8Sequence;
		this.a_9Level = original.a_9Level;
		this.a_9Sequence = original.a_9Sequence;
		this.a_10Level = original.a_10Level;
		this.a_10Sequence = original.a_10Sequence;
		this.a_11Level = original.a_11Level;
		this.a_11Sequence = original.a_11Sequence;
		this.a_12Level = original.a_12Level;
		this.a_12Sequence = original.a_12Sequence;
		this.a_13Level = original.a_13Level;
		this.a_13Sequence = original.a_13Sequence;
		this.a_14Level = original.a_14Level;
		this.a_14Sequence = original.a_14Sequence;
		this.a_15Level = original.a_15Level;
		this.a_15Sequence = original.a_15Sequence;
		this.a_16Level = original.a_16Level;
		this.a_16Sequence = original.a_16Sequence;
		this.a_17Level = original.a_17Level;
		this.a_17Sequence = original.a_17Sequence;
		this.a_18Level = original.a_18Level;
		this.a_18Sequence = original.a_18Sequence;
		this.a_19Level = original.a_19Level;
		this.a_19Sequence = original.a_19Sequence;
		this.a_20Level = original.a_20Level;
		this.a_20Sequence = original.a_20Sequence;
		this.a_21Level = original.a_21Level;
		this.a_21Sequence = original.a_21Sequence;
		this.a_22Level = original.a_22Level;
		this.a_22Sequence = original.a_22Sequence;

		// Setting values coordinates
		this.widthPix = original.widthPix;
		this.heightPix = original.heightPix;
		this.highestX = original.highestX;
		this.lowestX = original.lowestX;
		this.highestY = original.highestY;
		this.lowestY = original.lowestY;
		this.highestYC = original.highestYC;
		this.lowestYC = original.lowestYC;
		this.isStdW = original.isStdW;
		this.isStdH = original.isStdH;
		this.stdWM = original.stdWM;
		this.stdWI = original.stdWI;
		this.stdHM = original.stdHM;
		this.stdHI = original.stdHI;

		// Cloning removed parts
		this.removedParts = this.cloneCollections(original.removedParts);

		// Number parts object
		this.noPartsTop1 = original.noPartsTop1;
		this.noPartsTop2 = original.noPartsTop2;
		this.noPartsTop3 = original.noPartsTop3;
		this.noPartsBot1 = original.noPartsBot1;
		this.noPartsBot2 = original.noPartsBot2;
		this.noPartsBot3 = original.noPartsBot3;
		this.noPartsLeft = original.noPartsLeft;
		this.noPartsRight = original.noPartsRight;

		this.isNewFrame = original.isNewFrame;

		// Cloning openings objects

		// Cloning openings
		if (original.openings != null) {
			Collection newc = new ArrayList();
			Object[] rmp = original.openings.toArray();
			for (Object v : rmp) {
				newc.add(((OpeningObject) v).cloneOpening((OpeningObject) v));
			}
			this.openings = newc;
		}

		// this.openings = this.cloneCollections(original.openings);

		// Clone background openings
		if (original.bOpeningObjectIn != null) {
			this.bOpeningObjectIn = original.bOpeningObjectIn
					.cloneBkgrdOpening(original.bOpeningObjectIn);
		}
		if (original.bOpeningObject != null) {
			this.bOpeningObject = original.bOpeningObject
					.cloneBkgrdOpening(original.bOpeningObject);
		}
		if (original.bOpeningObjectOut != null) {
			this.bOpeningObjectOut = original.bOpeningObjectOut
					.cloneBkgrdOpening(original.bOpeningObjectOut);
		}

		this.newRowH = original.newRowH;

		// Cloning frames
		// if (original.frames != null)
		// {
		// Collection newc = new ArrayList();
		// Object[] rmp = original.frames.toArray();
		// for (final Object v : rmp)
		// {
		// newc.add(((Facet) v).cloneFacet(((Facet) v)));
		// }
		// this.frames = newc;
		// }

		// this.frames = this.cloneCollections(original.frames);

		this.newDesign = original.newDesign;

		this.frameStartCol = original.frameStartCol;
		this.frameStartRow = original.frameStartRow;
		this.frameEndCol = original.frameEndCol;
		this.frameEndRow = original.frameEndRow;
		this.myRow = original.myRow;
		this.myCol = original.myCol;
		this.myShapeID = original.myShapeID;
		this.myPrevShape = original.myPrevShape;
		this.myNewShape = original.myNewShape;
		this.myOpeningID = original.myOpeningID;
		this.mynewOpeningID = original.mynewOpeningID;
		this.mynewOpenindType = original.mynewOpenindType;
		this.newWidthTop = original.newWidthTop;
		this.newWidthBot = original.newWidthBot;
		this.newStartingY = original.newStartingY;
		this.newStartingX = original.newStartingX;
		this.newHL = original.newHL;
		this.newHR = original.newHR;
		this.newstartX = original.newstartX;
		this.newendX = original.newendX;
		this.newstartY = original.newstartY;
		this.newendY = original.newendY;

		this.newDimD2 = original.newDimD2;
		this.newDimB1 = original.newDimB1;

		this.rowColToAdd = original.rowColToAdd;
		this.addRow = original.addRow;

		this.dividedCentral = original.dividedCentral;
		this.myCouplerThickness = original.myCouplerThickness;

		// this.ellipses = original.ellipses;
		this.setLeanTo = original.setLeanTo;

		this.minLeg = original.minLeg;
		this.wireFrame = original.wireFrame;

		this.parentStartRow = original.parentStartRow;
		this.parentStartCol = original.parentStartCol;

		this.startingXBA = original.startingXBA;
		this.startingYBA = original.startingYBA;

		this.startingXA = original.startingXA;
		this.startingYA = original.startingYA;
		this.bX2A = original.bX2A;
		this.bY2A = original.bY2A;
		this.bX3A = original.bX3A;
		this.bY3A = original.bX3A;

		this.bX4A = original.bX4A;
		this.bY4A = original.bY4A;
		this.bX2B = original.bX2B;
		this.bY2B = original.bY2B;
		this.bX3B = original.bX3B;
		this.bY3B = original.bY3B;
		this.bX4B = original.bX4B;
		this.bY4B = original.bY4B;
		this.openingW = original.openingW;
		this.openingH = original.openingH;
		this.openingWc = original.openingWc;
		this.openingHc = original.openingHc;
		this.openingWB = original.openingWB;
		this.openingHR = original.openingHR;
		this.openingWcB = original.openingWcB;
		this.openingHcR = original.openingHcR;
		this.openingWA = original.openingWA;
		this.openingHA = original.openingHA;
		this.openingWBA = original.openingWBA;
		this.openingHRA = original.openingHRA;
		this.dimTM = original.dimTM;
		this.dimBM = original.dimBM;
		this.dimLM = original.dimLM;
		this.dimRM = original.dimRM;
		this.dimTA = original.dimTA;
		this.dimBA = original.dimBA;
		this.dimLA = original.dimLA;
		this.dimRA = original.dimRA;
		this.a_sequenceID = original.a_sequenceID;
		this.lastSeq = original.lastSeq;
		this.xCols = original.xCols;
		this.yRows = original.yRows;
		this.noTracks = original.noTracks;
		this.openOut = original.openOut;
		this.glazedOut = original.glazedOut;
		this.radius1A = original.radius1A;
		this.radius2A = original.radius2A;
		this.startAngleA = original.startAngleA;
		this.endAngleA = original.endAngleA;
		this.bkgrdStartXA = original.bkgrdStartXA;
		this.bkgrdStartYA = original.bkgrdStartYA;
		this.centralAngleA = original.centralAngleA;
		this.px1 = original.px1;
		this.py1 = original.py1;
		this.px2 = original.px2;
		this.py2 = original.py2;
		this.px3 = original.px3;
		this.py3 = original.py3;
		this.px4 = original.px4;
		this.py4 = original.py4;
		this.px5 = original.px5;
		this.py5 = original.py5;
		this.px6 = original.px6;
		this.py6 = original.py6;
		this.px7 = original.px7;
		this.py7 = original.py7;
		this.px8 = original.px8;
		this.py8 = original.py8;
		this.px1A = original.px1A;
		this.py1A = original.py1A;
		this.px2A = original.px2A;
		this.py2A = original.py2A;
		this.px3A = original.px3A;
		this.py3A = original.py3A;
		this.px4A = original.px4A;
		this.py4A = original.py4A;
		this.px5A = original.px5A;
		this.py5A = original.py5A;
		this.px6A = original.px6A;
		this.py6A = original.py6A;
		this.px7A = original.px7A;
		this.py7A = original.py7A;
		this.px8A = original.px8A;
		this.py8A = original.py8A;
		this.px1c = original.px1c;
		this.py1c = original.py1c;
		this.px2c = original.px2c;
		this.py2c = original.py2c;
		this.px3c = original.px3c;
		this.py3c = original.py3c;
		this.px4c = original.px4c;
		this.py4c = original.py4c;
		this.px5c = original.px5c;
		this.py5c = original.py5c;
		this.px6c = original.px6c;
		this.py6c = original.py6c;
		this.px7c = original.px7c;
		this.py7c = original.py7c;
		this.px8c = original.px8c;
		this.py8c = original.py8c;

		this.hasSash = original.hasSash;
		this.unGlazed = original.unGlazed;
		this.openingClass = original.openingClass;
		this.userDefinedOpeningID = original.userDefinedOpeningID;
		this.outSash = original.outSash;
		this.inSash = original.inSash;
		this.midSash = original.midSash;
		this.myGlass = original.myGlass;
		this.outSashTracks = original.outSashTracks;
		this.inSashTracks = original.inSashTracks;
		this.midSashTracks = original.midSashTracks;

		this.id = original.id;

		this.a_levelID = original.a_levelID;

		this.openIn = original.openIn;
		this.lean = original.lean;
		this.lean2 = original.lean2;
		this.lean3 = original.lean3;
		this.lean4 = original.lean4;
		this.noSides = original.noSides;
		this.noSidesTop = original.noSidesTop;
		this.noSidesBot = original.noSidesBot;
		this.noSidesLeft = original.noSidesLeft;
		this.noSidesRight = original.noSidesRight;
		this.startingX = original.startingX;
		this.startingY = original.startingY;
		this.bX2 = original.bX2;
		this.bY2 = original.bY2;
		this.bX3 = original.bX3;
		this.bY3 = original.bY3;
		this.bX4 = original.bX4;
		this.bY4 = original.bY4;
		this.startingCX = original.startingCX;
		this.startingCY = original.startingCY;
		this.bCX2 = original.bCX2;
		this.bCY2 = original.bCY2;
		this.bCX3 = original.bCX3;
		this.bCY3 = original.bCY3;
		this.bCX4 = original.bCX4;
		this.bCY4 = original.bCY4;
		this.topShape = original.topShape;
		this.rightShape = original.rightShape;
		this.botShape = original.botShape;
		this.leftShape = original.leftShape;
		this.levelW = original.levelW;
		this.levelH = original.levelH;
		this.dimA1 = original.dimA1;
		this.dimA2 = original.dimA2;
		this.dimA3 = original.dimA3;
		this.dimA4 = original.dimA4;
		this.dimA5 = original.dimA5;
		this.dimA0 = original.dimA0;
		this.dimB1 = original.dimB1;
		this.dimB2 = original.dimB2;
		this.dimB3 = original.dimB3;
		this.dimB4 = original.dimB4;
		this.dimB5 = original.dimB5;
		this.dimB0 = original.dimB0;
		this.dimC1 = original.dimC1;
		this.dimC2 = original.dimC2;
		this.dimC3 = original.dimC3;
		this.dimC4 = original.dimC4;
		this.dimC5 = original.dimC5;
		this.dimC0 = original.dimC0;
		this.dimD1 = original.dimD1;
		this.dimD2 = original.dimD2;
		this.dimD3 = original.dimD3;
		this.dimD4 = original.dimD4;
		this.dimD5 = original.dimD5;
		this.dimD0 = original.dimD0;
		this.pA1 = original.pA1;
		this.pA2 = original.pA2;
		this.pA3 = original.pA3;
		this.pA4 = original.pA4;
		this.pA5 = original.pA5;
		this.pA0 = original.pA0;
		this.pB1 = original.pB1;
		this.pB2 = original.pB2;
		this.pB3 = original.pB3;
		this.pB4 = original.pB4;
		this.pB5 = original.pB5;
		this.pB0 = original.pB0;
		this.pC1 = original.pC1;
		this.pC2 = original.pC2;
		this.pC3 = original.pC3;
		this.pC4 = original.pC4;
		this.pC5 = original.pC5;
		this.pC0 = original.pC0;
		this.pD1 = original.pD1;
		this.pD2 = original.pD2;
		this.pD3 = original.pD3;
		this.pD4 = original.pD4;
		this.pD5 = original.pD5;
		this.pD0 = original.pD0;

		this.wire = original.wire;

		this.centerPointX = original.centerPointX;
		this.centerPointY = original.centerPointY;
		this.centerPointX2 = original.centerPointX2;
		this.centerPointY2 = original.centerPointY2;

		this.radius1 = original.radius1;
		this.radius2 = original.radius2;

		this.startAngle = original.startAngle;
		this.endAngle = original.endAngle;

		this.bkgrdStartX = original.bkgrdStartX;
		this.bkgrdStartY = original.bkgrdStartY;

		this.centralAngle = original.centralAngle;

		this.startCol = original.startCol;
		this.endCol = original.endCol;
		this.startRow = original.startRow;
		this.endRow = original.endRow;

		this.parentW = original.parentW;
		this.parentH = original.parentH;
		this.parentStartY = original.parentStartY;
		this.parentStartX = original.parentStartX;
		this.parentRadius1 = original.parentRadius1;

		this.myX = original.myX;
		this.myY = original.myY;
		this.topIn = original.topIn;
		this.rightIn = original.rightIn;
		this.botIn = original.botIn;
		this.leftIn = original.leftIn;

		this.deltaA1 = original.deltaA1;
		this.deltaC2 = original.deltaC2;
		this.deltaD1 = original.deltaD1;

		this.shapeChanged = original.shapeChanged;
		this.arcType = original.arcType;

		this.parentCY = original.parentCY;
		this.parentCX2 = original.parentCX2;
		this.parentCY2 = original.parentCY2;
		this.parentShape = original.parentShape;
		this.newPart = original.newPart;

		this.clearanceTop = original.clearanceTop;
		this.clearanceBot = original.clearanceBot;
		this.clearanceLeft = original.clearanceLeft;
		this.clearanceRight = original.clearanceRight;

		this.topObjectPath = (GeneralPath) original.topObjectPath.clone();

		this.supplierId = original.supplierId;
		this.supplierSeriesId = original.supplierSeriesId;
		this.remote = original.remote;

		this.top1 = (Top1Object) this.top1.cloneProfile(original.top1);
		this.top2 = (Top2Object) this.top2.cloneProfile(original.top2);
		this.top3 = (Top3Object) this.top3.cloneProfile(original.top3);
		this.right = (RightObject) this.right.cloneProfile(original.right);
		this.left = (LeftObject) this.left.cloneProfile(original.left);
		this.bot1 = (Bot1Object) this.bot1.cloneProfile(original.bot1);
		this.bot2 = (Bot2Object) this.bot2.cloneProfile(original.bot2);
		this.bot3 = (Bot3Object) this.bot3.cloneProfile(original.bot3);

		this.top1Part = (Profiles) this.top1Part
				.cloneProfile(original.top1Part);
		this.top2Part = (Profiles) this.top2Part
				.cloneProfile(original.top2Part);
		this.top3Part = (Profiles) this.top3Part
				.cloneProfile(original.top3Part);
		this.rightPart = (Profiles) this.rightPart
				.cloneProfile(original.rightPart);
		this.leftPart = (Profiles) this.leftPart
				.cloneProfile(original.leftPart);
		this.bot1Part = (Profiles) this.bot1Part
				.cloneProfile(original.bot1Part);
		this.bot2Part = (Profiles) this.bot2Part
				.cloneProfile(original.bot2Part);
		this.bot3Part = (Profiles) this.bot3Part
				.cloneProfile(original.bot3Part);

		this.partObjects = this.cloneCollections(original.partObjects);

		this.gp = (GeneralPath) original.gp.clone();

		if (original.options != null) {
			Collection newc = new ArrayList();
			Object[] rmp = original.options.toArray();
			for (final Object v : rmp) {
				newc.add(((ShapeOption) v).clone(((ShapeOption) v)));
			}
			this.options = newc;
		}

		// this.options = this.cloneCollections(original.options);

		return this;
	}

	/**
	 * Evaluate Levels & Sequences for Shape Object Compatibility
	 * 
	 * @param shape
	 *            , ShapeObject
	 * @return boolean
	 */
	public boolean isForShape(ShapeObject shape) {

		boolean match = false;

		if (shape.a_assemblyLevel == this.a_assemblyLevel
				&& shape.a_1Level == this.a_1Level
				&& shape.a_2Level == this.a_2Level
				&& shape.a_3Level == this.a_3Level
				&& shape.a_4Level == this.a_4Level
				&& shape.a_5Level == this.a_5Level
				&& shape.a_6Level == this.a_6Level
				&& shape.a_7Level == this.a_7Level
				&& shape.a_8Level == this.a_8Level
				&& shape.a_9Level == this.a_9Level
				&& shape.a_10Level == this.a_10Level
				&& shape.a_11Level == this.a_11Level
				&& shape.a_12Level == this.a_12Level
				&& shape.a_13Level == this.a_13Level
				&& shape.a_14Level == this.a_14Level
				&& shape.a_15Level == this.a_15Level
				&& shape.a_16Level == this.a_16Level
				&& shape.a_17Level == this.a_17Level
				&& shape.a_18Level == this.a_18Level
				&& shape.a_19Level == this.a_19Level
				&& shape.a_20Level == this.a_20Level
				&& shape.a_21Level == this.a_21Level
				&& shape.a_22Level == this.a_22Level
				&& shape.a_sequenceID == this.a_sequenceID
				&& shape.a_1Sequence == this.a_1Sequence
				&& shape.a_2Sequence == this.a_2Sequence
				&& shape.a_3Sequence == this.a_3Sequence
				&& shape.a_4Sequence == this.a_4Sequence
				&& shape.a_5Sequence == this.a_5Sequence
				&& shape.a_6Sequence == this.a_6Sequence
				&& shape.a_7Sequence == this.a_7Sequence
				&& shape.a_8Sequence == this.a_8Sequence
				&& shape.a_9Sequence == this.a_9Sequence
				&& shape.a_10Sequence == this.a_10Sequence
				&& shape.a_11Sequence == this.a_11Sequence
				&& shape.a_12Sequence == this.a_12Sequence
				&& shape.a_13Sequence == this.a_13Sequence
				&& shape.a_14Sequence == this.a_14Sequence
				&& shape.a_15Sequence == this.a_15Sequence
				&& shape.a_16Sequence == this.a_16Sequence
				&& shape.a_17Sequence == this.a_17Sequence
				&& shape.a_18Sequence == this.a_18Sequence
				&& shape.a_19Sequence == this.a_19Sequence
				&& shape.a_20Sequence == this.a_20Sequence
				&& shape.a_21Sequence == this.a_21Sequence
				&& shape.a_22Sequence == this.a_22Sequence) {

			match = true;

		}

		return match;
	}

	/**
	 * Evaluate Levels & Sequences for Shape Object Compatibility
	 * 
	 * @param constructionMap
	 *            , ConstructionMap
	 * @return boolean
	 */
	public boolean isForShape(ConstructionMap constructionMap) {

		boolean match = false;

		if (constructionMap.get_a_assemblyLevel() == this.a_assemblyLevel
				&& constructionMap.get_a_1Level() == this.a_1Level
				&& constructionMap.get_a_2Level() == this.a_2Level
				&& constructionMap.get_a_3Level() == this.a_3Level
				&& constructionMap.get_a_4Level() == this.a_4Level
				&& constructionMap.get_a_5Level() == this.a_5Level
				&& constructionMap.get_a_6Level() == this.a_6Level
				&& constructionMap.get_a_7Level() == this.a_7Level
				&& constructionMap.get_a_8Level() == this.a_8Level
				&& constructionMap.get_a_9Level() == this.a_9Level
				&& constructionMap.get_a_9Level() == this.a_10Level
				&& constructionMap.get_a_11Level() == this.a_11Level
				&& constructionMap.get_a_12Level() == this.a_12Level
				&& constructionMap.get_a_13Level() == this.a_13Level
				&& constructionMap.get_a_14Level() == this.a_14Level
				&& constructionMap.get_a_15Level() == this.a_15Level
				&& constructionMap.get_a_16Level() == this.a_16Level
				&& constructionMap.get_a_17Level() == this.a_17Level
				&& constructionMap.get_a_18Level() == this.a_18Level
				&& constructionMap.get_a_19Level() == this.a_19Level
				&& constructionMap.get_a_20Level() == this.a_20Level
				&& constructionMap.get_a_21Level() == this.a_21Level
				&& constructionMap.get_a_22Level() == this.a_22Level
				&& constructionMap.get_a_assemblySequence() == this.a_sequenceID
				&& constructionMap.get_a_1Sequence() == this.a_1Sequence
				&& constructionMap.get_a_2Sequence() == this.a_2Sequence
				&& constructionMap.get_a_3Sequence() == this.a_3Sequence
				&& constructionMap.get_a_4Sequence() == this.a_4Sequence
				&& constructionMap.get_a_5Sequence() == this.a_5Sequence
				&& constructionMap.get_a_6Sequence() == this.a_6Sequence
				&& constructionMap.get_a_7Sequence() == this.a_7Sequence
				&& constructionMap.get_a_8Sequence() == this.a_8Sequence
				&& constructionMap.get_a_9Sequence() == this.a_9Sequence
				&& constructionMap.get_a_10Sequence() == this.a_10Sequence
				&& constructionMap.get_a_11Sequence() == this.a_11Sequence
				&& constructionMap.get_a_12Sequence() == this.a_12Sequence
				&& constructionMap.get_a_13Sequence() == this.a_13Sequence
				&& constructionMap.get_a_14Sequence() == this.a_14Sequence
				&& constructionMap.get_a_15Sequence() == this.a_15Sequence
				&& constructionMap.get_a_16Sequence() == this.a_16Sequence
				&& constructionMap.get_a_17Sequence() == this.a_17Sequence
				&& constructionMap.get_a_18Sequence() == this.a_18Sequence
				&& constructionMap.get_a_19Sequence() == this.a_19Sequence
				&& constructionMap.get_a_20Sequence() == this.a_20Sequence
				&& constructionMap.get_a_21Sequence() == this.a_21Sequence
				&& constructionMap.get_a_22Sequence() == this.a_22Sequence) {

			match = true;

		}

		return match;
	}

	/**
	 * Evaluate Levels & Sequences for Shape Object Compatibility
	 * 
	 * @param validate
	 *            , Boolean
	 * @param constructionMap
	 *            , ConstructionMap
	 * @return boolean
	 */
	public boolean isForFrame(boolean validate, ConstructionMap constructionMap) {

		try {

			// Not Required Validation for construction map [ShapeObject]
			if (!validate) {
				return true;
			}

			// Load Construction Map
			Map<Integer, LevelSequence> _construction_map = ConstructionMapDTO
					.shapeMapLevels(constructionMap.getClass(), constructionMap);

			// ************************************************************************
			// Compare assembly level & sequence for frame
			// ************************************************************************
			if (constructionMap.get_a_assemblyLevel() == this.a_levelID
					&& constructionMap.get_a_assemblySequence() == this.a_sequenceID) {
				return true;
			}

			// ************************************************************************
			// Compare levels for child and Parent
			// ************************************************************************
			int sizeParentLevels = _construction_map.size();

			for (int i = 1; i <= sizeParentLevels; i++) {
				LevelSequence parent_sequence = _construction_map.get(i);

				// Check Child to Frame Level
				if (parent_sequence.levelID.intValue() == this.a_levelID
						&& parent_sequence.sequenceID.intValue() == this.a_sequenceID) {
					return true;
				}
			}

		} catch (IllegalAccessException e) {
			logger.error(e.getMessage(), e);
		} catch (InvocationTargetException e) {
			logger.error(e.getMessage(), e);
		}

		return false;
	}

	@Override
	public ShapeObject clone() throws CloneNotSupportedException {

		// Clone Shape Object model
		ShapeObject newShapeObject = (ShapeObject) super.clone();

		newShapeObject.originalScaleM = new BigDecimal(
				newShapeObject.originalScaleM.doubleValue() + "");
		newShapeObject.originalScaleI = new BigDecimal(
				newShapeObject.originalScaleI.doubleValue() + "");
		newShapeObject.scaleM = new BigDecimal(
				newShapeObject.scaleM.doubleValue() + "");
		newShapeObject.scaleImp = new BigDecimal(
				newShapeObject.scaleImp.doubleValue() + "");

		// Clone parts object
		newShapeObject.top1Part = newShapeObject.top1Part.clone();
		newShapeObject.top1Part.myParent = newShapeObject;

		newShapeObject.top2Part = newShapeObject.top2Part.clone();
		newShapeObject.top2Part.myParent = newShapeObject;

		newShapeObject.top3Part = newShapeObject.top3Part.clone();
		newShapeObject.top3Part.myParent = newShapeObject;

		newShapeObject.bot1Part = newShapeObject.bot1Part.clone();
		newShapeObject.bot1Part.myParent = newShapeObject;

		newShapeObject.bot2Part = newShapeObject.bot2Part.clone();
		newShapeObject.bot2Part.myParent = newShapeObject;

		newShapeObject.bot3Part = newShapeObject.bot3Part.clone();
		newShapeObject.bot3Part.myParent = newShapeObject;

		newShapeObject.leftPart = newShapeObject.leftPart.clone();
		newShapeObject.leftPart.myParent = newShapeObject;

		newShapeObject.rightPart = newShapeObject.rightPart.clone();
		newShapeObject.rightPart.myParent = newShapeObject;

		newShapeObject.top1 = newShapeObject.top1.clone();
		newShapeObject.top1.myParent = newShapeObject;

		newShapeObject.top2 = newShapeObject.top2.clone();
		newShapeObject.top2.myParent = newShapeObject;

		newShapeObject.top3 = newShapeObject.top3.clone();
		newShapeObject.top3.myParent = newShapeObject;

		newShapeObject.bot1 = newShapeObject.bot1.clone();
		newShapeObject.bot1.myParent = newShapeObject;

		newShapeObject.bot2 = newShapeObject.bot2.clone();
		newShapeObject.bot2.myParent = newShapeObject;

		newShapeObject.bot3 = newShapeObject.bot3.clone();
		newShapeObject.bot3.myParent = newShapeObject;

		newShapeObject.left = newShapeObject.left.clone();
		newShapeObject.left.myParent = newShapeObject;

		newShapeObject.right = newShapeObject.right.clone();
		newShapeObject.right.myParent = newShapeObject;

		// Clone parts collection object
		Collection<Profiles> partObjects = new ArrayList<Profiles>();
		for (Object object : newShapeObject.partObjects) {
			Profiles profile = ((Profiles) object).clone();
			profile.myParent = newShapeObject;

			partObjects.add(profile);
		}
		newShapeObject.partObjects = partObjects;

		// Clone removed parts collection object
		Collection<Profiles> removedParts = new ArrayList<Profiles>();
		for (Object object : newShapeObject.removedParts) {
			Profiles profile = ((Profiles) object).clone();
			profile.myParent = newShapeObject;

			removedParts.add(profile);
		}
		newShapeObject.removedParts = removedParts;

		// ************************************************
		// Clone my mullions objects
		// ************************************************
		if (newShapeObject.myMullionTop != null) {
			newShapeObject.myMullionTop = newShapeObject.myMullionTop.clone();
		}

		if (newShapeObject.myMullionBot != null) {
			newShapeObject.myMullionBot = newShapeObject.myMullionBot.clone();
		}

		if (newShapeObject.myMullionLeft != null) {
			newShapeObject.myMullionLeft = newShapeObject.myMullionLeft.clone();
		}

		if (newShapeObject.myMullionRight != null) {
			newShapeObject.myMullionRight = newShapeObject.myMullionRight
					.clone();
		}

		// Clone Shape options
		Collection<ShapeOption> shapeOptions = new ArrayList<ShapeOption>();
		for (ShapeOption option : newShapeObject.options) {
			ShapeOption newOption = option.clone();
			shapeOptions.add(newOption);
		}
		newShapeObject.options = shapeOptions;

		// Clone Bill of Materials
		List<BillOfMat> bom = new ArrayList<BillOfMat>();
		for (BillOfMat object : newShapeObject.bom) {
			BillOfMat newObject = object.clone();
			bom.add(newObject);
		}
		newShapeObject.bom = bom;

		Collection<ShapeNotes> notes = new ArrayList<ShapeNotes>();
		for (ShapeNotes object : newShapeObject.notes) {
			ShapeNotes newObject = object.clone();
			notes.add(newObject);
		}
		newShapeObject.notes = notes;

		return newShapeObject;
	}

	/**
	 * Return a List of Map Levels for Shape Object
	 * 
	 * @param shapeClazz
	 *            , Class Shape Object
	 * @param object
	 *            , Object to process
	 * @return Map
	 */
	public Map<Integer, LevelSequence> shapeMapLevels(Class shapeClazz,
			Object object) throws IllegalAccessException {

		// Levels map for shapeObject
		Map<Integer, LevelSequence> levels = new HashMap<Integer, LevelSequence>();

		// Start and Finish level count for Shape Object Map
		int position = 1;
		int startLevel = 1;
		int maxLevels = 22;

		Field[] childFields = shapeClazz.getFields();
		if (shapeClazz.getSuperclass().getFields().length > 0) {
			childFields = shapeClazz.getSuperclass().getFields();
		}

		for (Field level : childFields) {

			String levelName = level.getName();

			if (startLevel <= maxLevels) {

				if (levelName.equals("a_" + startLevel + "Level")) {

					for (Field sequence : childFields) {

						String sequenceName = sequence.getName();

						if (sequenceName.equals("a_" + startLevel + "Sequence")) {
							Integer levelID = level.getInt(object);
							Integer sequenceID = sequence.getInt(object);

							if (levelID > 0 && sequenceID > 0) {
								LevelSequence childSequence = new LevelSequence(
										level.getInt(object),
										sequence.getInt(object));
								levels.put(position, childSequence);

								position++;
							}
						}
					}

					startLevel++;
				}
			}
		}

		return levels;
	}

	public boolean suFamilyTest(RuleTest test, List myRuleTestValues) {
		return false;
	}

	/**
	 * Execute rules for matching with Shape Object Model
	 * 
	 * @param rule
	 *            , Rules
	 * @param doBOM
	 *            , Indicate if need to calculate all bill of materials
	 */
	public abstract void isMatchingBOMRule(Rules rule, boolean doBOM);

	/**
	 * Load Bill Of Materials Parts
	 */
	public abstract void loadBOMParts();

	/**
	 * Clear Bill Of Materials Parts
	 */
	public abstract void clearBOMParts();

	/**
	 * Load Options All
	 */
	public abstract void loadOptionsAll();

	public boolean suGlass1Test(RuleTest test, List myRuleTestValues) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean suGlass2Test(RuleTest test, List myRuleTestValues) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean suGlass3Test(RuleTest test, List myRuleTestValues) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean suGlass4Test(RuleTest test, List myRuleTestValues) {
		// TODO Auto-generated method stub
		return false;
	}

}

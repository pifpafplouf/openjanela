package Model.ProfileParts;

import java.awt.Polygon;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openjanela.data.ApplicationBaseApp;
import org.openjanela.data.ApplicationBaseRulesApp;
import org.openjanela.data.ApplicationMainBaseApp;

import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.partner.optionsEAO.OptionsEAO;
import openjanela.model.eao.partner.optionsEAO.OptionsPersistenceEAO;
import openjanela.model.entities.partner.OptionAnswers;
import openjanela.model.entities.partner.OptionDefinitions;
import openjanela.model.entities.partner.RuleTest;
import openjanela.model.entities.partner.RuleTestValue;
import openjanela.model.entities.partner.Rules;
import openjanela.model.entities.parts.Parts;
import Model.BillOfMat;
import Model.DesignOption;
import Model.JobItemModel;
import Model.ShapeNotes;
import Model.ShapeObject;
import Model.ShapeOption;
import Model.matrix.MatrixDictionaryCalculation;
import Presentation.ItemFrame;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * <p/>
 * This class represents the generic profile parts
 * User: emontenegro
 * Date: 04-12-12
 * Time: 04:29 PM
 * To change this template use File | Settings | File Templates.
 */

/*   
-- End Type Specs -- 
End Type:

Left: 	bottom 	RB		Top 	LT

top: 	Left  	RB		right	LT

right:	Top		RB		Bottom	LT

Bot:		Right	LT		Bottom	RB 

*/


public abstract class ProfileParts implements MatrixDictionaryCalculation {
	
	//JobItem model
	public JobItemModel myJobItem;
	//Item frame
	public ItemFrame myFrame2;
	
	public int a_levelID = 0; 	
	public int a_sequenceID = 0;	
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
	
	public int shapeID = 0;
	public int ABClines = 0;
	public double bkgrdHeight = 0;
	public double bkgrdHeightA = 0;
	public double bkgrdHeightBA = 0;
	public double bkgrdHeightBC = 0;
	public double bkgrdStartX = 0;
	public double bkgrdStartXA = 0;
	public double bkgrdStartXBA = 0;
	public double bkgrdStartXBC = 0;
	public double bkgrdStartY = 0;
	public double bkgrdStartYA = 0;
	public double bkgrdStartYBA = 0;
	public double bkgrdStartYBC = 0;
	public double bkgrdWidth = 0;
	public double bkgrdWidthA = 0;
	public double bkgrdWidthBA = 0;
	public double bkgrdWidthBC = 0;
	public double centralAngle = 0;
	public double centralAngleA = 0;
	public double centralAngleBA = 0;
	public double centralAngleBC = 0;
	public double dimB1A = 0;
	public double dimB1B = 0;
	public double endAngle = 0;
	public double endAngleA = 0;
	public double endAngleBA = 0;
	public double endAngleBC = 0;
	public double endXC = 0;
	public double centerEndX = 0;
	public double endX = 0;
	
	public double endXA = 0;
	public double endXBA = 0;
	public double endXBC = 0;
	public double endYC = 0;
	public double endY = 0;
	
	public double endYA = 0;
	public double endYBA = 0;
	public double endYBC = 0;
	public double centerEndY = 0;
	public double focal1X = 0;
	public double focal1XA = 0;
	public double focal1XBA = 0;
	public double focal1XBC = 0;
	public double focal1Y = 0;
	public double focal1YA = 0;
	public double focal1YBA = 0;
	public double focal1YBC = 0;
	public double focal2X = 0;
	public double focal2XA = 0;
	public double focal2XBA = 0;
	public double focal2XBC = 0;
	public double focal2Y = 0;
	public double focal2YA = 0;
	public double focal2YBA = 0;
	public double focal2YBC = 0;
	public double glazingDepth = 0; //used for scale Imp
	public double inLaminateArea = 0;
	public double inPaintArea = 0;
	public double length = 0;
	public double lengthA = 0;
	public double lengthBA = 0;
	public double lengthBC = 0;
	
	public double ltAngle = 90;
	
	public double ltAngleA = 90;
	
	public double ltAngleBA = 90;
	
	public double ltAngleBC = 90;
	public double mitreLengthLT = 0;
	public double mitreLengthRB = 0;
	public ShapeObject myParent;
	public ShapeObject myLevelShape;
	public ShapeObject myFrame;
	public double myWidth = 0;
	public double myWidthA = 0;
	public double myWidthBA = 0;
	public double newX = 0;
	public double newXA = 0;
	public double newY = 0;
	public double newYA = 0;
	public double outLaminateArea = 0;
	public double outPaintArea = 0;
	
	public double partDimA = 0;
	public double partDimA2 = 0;
	
	public double partDimAi = 0;
	public double partDimB = 0;
	public double partDimB2 = 0;
	
	public double partDimBi = 0;
	public double partDimC = 0;
	public double partDimC2 = 0;
	
	public double partDimCi = 0;
	
	public double partDimD = 0;
	
	public double partDimDi = 0;
	
	public double partDimBtoC = 0;
	
	// Where the Center of Mullion
	// (screw Ports is)
	
	public double partDimBtoCi = 0;
	
	public double partDimM = 0;
	
	public double partDimMi = 0;
	
	public int partID = 0;
	
	public int partForm = 1;
	public int partShape = 0;
	public int position = 1;
	public int seq = 1;

	public double radianCentralAngle = 0;
	public double radius1 = 0;
	public double radius1A = 0;
	public double radius1BA = 0;
	public double radius1BC = 0;
	public double radiusXY2cl = 0;
	public double radiusXY2 = 0;
	public double radiusXYCenter = 0;
	public double radiusXY1 = 0;
	public double radiusXY1al = 0;
	public double radius2 = 0;
	public double radius2A = 0;
	public double radius2BA = 0;
	public double radius2BC = 0;
	public double radsStart = 0;
	public double radsStart2 = 0;
	public double radsStart2A = 0;
	public double radsStart2BA = 0;
	public double radsStartA = 0;
	public double radsStartBA = 0;
	
	public double rbAngle = 90;
	
	public double rbAngleA = 90;
	
	public double rbAngleBA = 90;
	
	public double rbAngleBC = 90;
	public int rID = 0;
	public double rlAngle = 0;
	public double rlAngleA = 0;
	public double rlAngleBA = 0; //radius to left side angle
	public double rlSlope = 0;   // left radius slope
	public double rlSlopeA = 0;  // left radius slope
	public double rlSlopeBA = 0; // left radius slope
	public double rrAngle = 0;  // radius to right side angle
	public double rrAngleA = 0; // radius to right side angle
	public double rrAngleBA = 0; // radius to right side angle
	public double rrSlope = 0;  // right radius slope
	public double rrSlopeA = 0; // right radius slope
	public double rrSlopeBA = 0; // right radius slope
	public double slope = 0;
	public double slopeA = 0;
	public double slopeBA = 0;
	public double slopeBC = 0;
	public double startAngle = 0;
	public double startAngleA = 0;
	public double startAngleBA = 0;
	public double startAngleBC = 0;
	public double startingX = 0; //called with the end point of the last line
	public double startingXA = 0;
	public double startingXBA = 0;
	public double startingXBC = 0;
	public double startingY = 0;
	public double startingYA = 0;
	public double startingYBA = 0;
	public double startingYBC = 0;
	public double startX = 0;
	
	public double startXC = 0;
	public double startXA = 0;
	public double startXBA = 0;
	public double startXBC = 0;
	public double startY = 0;
	
	public double startYC = 0;
	public double startYA = 0;
	public double startYBA = 0;
	public double startYBC = 0;
	public double centerStartX = 0;
	public double centerStartY = 0;
	public String stockCode = "";
	public double stopAeX = 0;
	public double stopAeY = 0;
	public double stopAsX = 0;
	public double stopAsY = 0;
	public double totalDepth = 0;
	public double totalSurfaceArea = 0;
	public boolean wire = false;
	public double x1 = 0;
	public double x1A = 0;
	public double x1BA = 0;
	public double x1BC = 0;
	public double x2 = 0;
	public double x2A = 0;
	public double x2BA = 0;
	public double x2BC = 0;
	public double y1 = 0;
	public double y1A = 0;
	public double y1BA = 0;
	public double y1BC = 0;
	public double y2 = 0;
	public double y2A = 0;
	public double y2BA = 0;
	public double y2BC = 0;
	public double x3 = 0;
	public double x3A = 0;
	public double x3BA = 0;
	public double x3BC = 0;
	public double x4 = 0;
	public double x4A = 0;
	public double x4BA = 0;
	public double x4BC = 0;
	public double y3 = 0;
	public double y3A = 0;
	public double y3BA = 0;
	public double y3BC = 0;
	public double y4 = 0;
	public double y4A = 0;
	public double y4BA = 0;
	public double y4BC = 0;
	public int endTypeLT = 1;
	public int endTypeRB = 1;
	public double parentW = 0;
	public int myLean = 0;
	public int myLean2 = 0;
	public int myLean3 = 0;
	public int myLean4 = 0;
	double myTopWidth = 0;
	public PartsNotching partNotching;
	public PartsNotching myNotchLB;
	public PartsNotching myNotchRT;
	public Object[] myNothcesLB;
	public Object[] myNothcesRT;
	public Collection xCoordB = new ArrayList();
	public Collection yCoordB = new ArrayList();
	public Collection xCoordBA = new ArrayList();
	public Collection yCoordBA = new ArrayList();
	public Collection xCoordA = new ArrayList();
	public Collection yCoordA = new ArrayList();
	public Object[] xCoordBo;
	public Object[] yCoordBo;
	public Object[] xCoordBoBA;
	public Object[] yCoordBoBA;
	public Object[] xCoordBoA;
	public Object[] yCoordBoA;
	public double myX = 0;
	public double myY = 0;
	public boolean topIn = false;
	public boolean rightIn = false;
	public boolean botIn = false;
	public boolean leftIn = false;
	public boolean posInUse = true;
	public int color = 0;
	public int colorIn = 0;
	public int colorOut = 0;
	
	public int rgb_R = 255;
	
	public int rgb_G = 255;
	
	public int rgb_B = 255;
	
	public int rgb_Rin = 255;
	
	public int rgb_Gin = 255;
	
	public int rgb_Bin = 255;
	
	public int rgb_Rout = 255;
	
	public int rgb_Gout = 255;
	
	public int rgb_Bout = 255;
	
	public int rgb_Rt = 255;
	
	public int rgb_Gt = 255;
	
	public int rgb_Bt = 255;

	public int transp = 255;

    public int profileSelected = 0;
	public Profiles mullionLeft = null;
	public Profiles mullionRight = null;
	public Object top1Part = null;
	public Object top2Part = null;
	public Object top3Part = null;
	public Object bot1Part = null;
	public Object bot2Part = null;
	public Object bot3Part = null;
	public Object leftPart = null;
	public Object rightPart = null;
	public Arc2D arc2B = null;
	public Arc2D arc2BA = null;
	public Arc2D arc2A = null;
	public Arc2D arcB = null;
	public Arc2D arcBA = null;
	public Arc2D arcA = null;
	public Line2D endL = null;
	public Line2D endR = null;
	public GeneralPath gp = new GeneralPath();
	public Polygon polygon = new Polygon();
	public GeneralPath gpShapes = new GeneralPath();
	public GeneralPath fillShape = new GeneralPath();
	public GeneralPath curveB = new GeneralPath();
	public GeneralPath curveBA = new GeneralPath();
	public GeneralPath curveA = new GeneralPath();
	public GeneralPath topObjectPath = new GeneralPath();
	public GeneralPath topFillShape = new GeneralPath();
	public int noPartsTop1 = 0;
	public int noPartsTop2 = 0;
	public int noPartsTop3 = 0;
	public int noPartsBot1 = 0;
	public int noPartsBot2 = 0;
	public int noPartsBot3 = 0;
	public int noPartsLeft = 0;
	public int noPartsRight = 0;
	public boolean glazedOut = true;
	public Profiles top1 = null;
	public Profiles bot1 = null;
	public double levelW = 0;
	public double levelH = 0;
	public boolean leftInf = false;
	public boolean rightInf = false;
	public Polygon poly = new Polygon();
	public boolean remove = false;
	public double deltaX = 0;
	public int levelID = 0;
	public int parentid = 0;
	public int continuity = 2; // 1=V  2=H
	public int order = 0; // 3=none
	public PartsNotching partsNotching;
	public PartsNotching myNotchLT;
	public PartsNotching myNotchRB;
	public Collection myNothcesLT;
	public Collection myNothcesRB;
	public Collection notches = new ArrayList();
	public Collection myOpeningsLT = new ArrayList();
	public Collection myOpeningsRB = new ArrayList();
	
	public int startPos = 0; // start row or column depending on H or V
	public int endPos = 0;
	public double centerXsa = 0; // actual for length and drawing
	public double centerYsa = 0;
	public double centerXea = 0;
	public double centerYea = 0;
	public double x1al = 0; // background for calculation of Frame positions
	public double y1al = 0;
	public double x2cl = 0;
	public double y2cl = 0;
	public double x3cl = 0;
	public double y3cl = 0;
	public double x4al = 0;
	public double y4al = 0;
	public double centerXs = 0;
	public double centerYs = 0;
	public double centerXe = 0;
	public double centerYe = 0;
	public double dx1 = 0; // Drawing Coordinates for calculation of frame positions
	public double dy1 = 0;
	public double dx2 = 0;
	public double dy2 = 0;
	public double dx3 = 0;
	public double dy3 = 0;
	public double dx4 = 0;
	public double dy4 = 0;
	public double dx1al = 0; // background for calculation of Frame positions
	public double dy1al = 0;
	public double dx2cl = 0;
	public double dy2cl = 0;
	public double dx3cl = 0;
	public double dy3cl = 0;
	public double dx4al = 0;
	public double dy4al = 0;
	public double dcenterXs = 0;
	public double dcenterYs = 0;
	public double dcenterXe = 0;
	public double dcenterYe = 0;
	public BigDecimal scale = new BigDecimal(0);
	
	public double thickness = 0;
	public int CouplerShapeID = 0; // 1 Rect, 2 Arc, 3 Quad, 4 Cubic
	public int orientation = 0; // Vertical = 1, Horizontal = 2
    public int rowCol = 0;
	public int frameLTid = 0;
	public int frameRBid = 0;
	public double centralAnglec = 0; // for drawing of arcs
	public double centralAnglec1 = 0; // for drawing of arcs
	public double centralAnglea1 = 0; // for drawing of arcs
	public double centralAnglea = 0; // for drawing of arcs
	public double radius1c = 0; // for drawing of arcs
	public double radius1c1 = 0; // for drawing of arcs
	public double radius1a1 = 0; // for drawing of arcs
	public double radius1a = 0; // for drawing of arcs
	public double arcH = 50;
	public double startAnglec = 0; // for drawing of arcs
	public double endAnglec = 0;
	public double startAnglec1 = 0; // for drawing of arcs
	public double endAnglec1 = 0;
	public double startAnglea1 = 0; // for drawing of arcs
	public double endAnglea1 = 0;
	public double startAnglea = 0; // for drawing of arcs
	public double endAnglea = 0;
	public int couplerTypeID = 0; // identifies the type of Coupler
	public int openingLT = 0; // if Level is not Overall
	public int openingRB = 0; // if level is not Overall
	public int whichPos = 0; // 1=In 2=mid 3=out
	public double baseRT = 0;
	public double baseLB = 0;
	public double baseCenter = 0;
	public double newAlpha = 0;
	public double newStartingYRT = 0; // Left top
	public double newStartingXRT = 0;
	public double newAlpha2 = 0;
	public double newStartingYLB = 0; // Right Bottom
	public double newStartingXLB = 0; // Right Bottom
	public double newAlpha3 = 0;
	public double newStartingYCenter = 0;
	public double newStartingXCenter = 0;
	public double newAlphaA = 0;
	public double newAlphaC = 0;
	public double baseLBa = 0;
	public double baseRTc = 0;
	public double newStartingXLBa = 0; // Right Bottom
	public double newStartingXRTc = 0;
	public double newStartingYLBa = 0; // Right Bottom
	public double newStartingYRTc = 0;
	public double newBeta;
	public double theta = 0;
	public double alpha = 0;
	public double newYLeft = 0;
	public double newYRight = 0;
	public double newYCenter = 0;
	public double newXcenterStart = 0;
	public double tempDelta = 0;
	public int isBefore = 0;
	public int endCID = 0;
	public int startCID = 0;
	public boolean isValid = true;
	public double angleTLa = 0; // top/Left Angle Left
	public double angleBLa = 0; // bot public double angleTRc = 0; top/Left Angle Right
	public double angleTRc = 0; // top Left
	public double angleBRc = 0;
	public double offsetTL = 0; // offset from center (-or +)
	public double offsetRB = 0;
	public double deltaTL = 0;
	public double deltaRB = 0;
	public double curveCenterTL = 0;
	public double curveCenterRB = 0;
	public double bcSP0x = 0;
	public double bcSP1x = 0;
	public double bcCP1x = 0;
	public double bcCP2x = 0;
	public double bcEP1x = 0;
	public double bcEP0x = 0;
	public double bcSP0y = 0;
	public double bcSP1y = 0;
	public double bcCP1y = 0;
	public double bcCP2y = 0;
	public double bcEP1y = 0;
	public double bcEP0y = 0;
	public boolean joinM = false;
	public int posCondition = 1; // 1= |--| 2=|--* 3= *--| 4= *--*
	public int mType = 1; // up to 6 types, number of icons on UI
	//public boolean remove = false;
	public int exists = 0; // already exist type 1, 2 or 3
	public boolean potentialS = false;
	public double delta = 0;
	public boolean startIn = false;
	public boolean endIn = false;
	public boolean partLeft = true;
	public boolean partRight = true;
	public int cOrM = 0;
	public double x1a = 0;
	public double x1b = 0;
	public double x1a3 = 0;// Glzed O. View O
	public double y1a = 0;
	public double y1b = 0;
	public double y1a3 = 0;
	public double x2a = 0;
	public double x2b = 0;
	public double x2a3 = 0;
	public double y2a = 0;
	public double y2b = 0;
	public double y2a3 = 0;
	public double x3a = 0;
	public double x3b = 0;
	public double x3a3 = 0;
	public double y3a = 0;
	public double y3b = 0;
	public double y3a3 = 0;
	public double x4a = 0;
	public double x4b = 0;
	public double x4a3 = 0;
	public double y4a = 0;
	public double y4b = 0;
	public double y4a3 = 0;
	public double ycs = 0;
	public double yce = 0;
	public double xcs = 0;
	public double xce = 0;
	public boolean drawcoupler = false;
	public int joinC = 0;
	public boolean opDone = false;
	public boolean finalVerify = false;
	public boolean unique = false;
	public boolean followFrame = false;
	public ShapeObject whichFrame;
	public boolean isExtra = false;
	public boolean isNew = false;
	public int openingTypeLB = 0;
	public int openingIDLB = 0;
	public int openingTypeRT = 0;
	public int openingIDRT = 0;
	public boolean manualPos = false;
	public boolean fixedAngle = true;
	public double angle = 180;
	public double minAngle = 5;
	public double maxAngle = 355;
	public boolean phantom = true;// Used for frameJoins V
	public boolean divideFacet = true;
	public int isSelected = 0;
	public Profiles limitStartX1a;
	public Profiles limitStartX1;
	public Profiles limitStartXC;
	public Profiles limitStartX2;
	public Profiles limitStartX2c;
	public Profiles limitStartY1a;
	public Profiles limitStartY1;
	public Profiles limitStartYC;
	public Profiles limitStartY2;
	public Profiles limitStartY2c;
	public Profiles limitEndX4a;
	public Profiles limitEndX4;
	public Profiles limitEndXC;
	public Profiles limitEndX3;
	public Profiles limitEndX3c;
	public Profiles limitEndY4a;
	public Profiles limitEndY4;
	public Profiles limitEndYC;
	public Profiles limitEndY3;
	public Profiles limitEndY3c;
	
	//*****************************************************
	//TOP PARTS COMPOSITION
	//*****************************************************
	
	
	public int lengthM = 0;
	
	public int lengthI = 0;
	
	public int lengthMN = 0;
	
	public int lengthIN = 0;
	
	public Collection<ShapeOption> options = new ArrayList();
	
	public Collection<BillOfMat> bom = new ArrayList();
	
	public Collection<ShapeNotes> notes = new ArrayList();
	
	// C,M,D, type_coupler_mullion.id
	public int typeID = 0;
	
	public boolean partDimByUser = false;
	
	public boolean endTypeLTByUser = false;
	
	public boolean endTypeRBByUser = false;
	
	public boolean partIDByUser = false;
	
	public String notchLT = "";
	
	public String notchRB = "";
	
	public String notchLTi = "";
	
	public String notchRBi = "";

    public int udControlOpeningID = 0;
    public int openingClass = 0;

    public int supplierId = 0;
    public boolean remote = false;

    /////////////////////////////////
    //Grids Options
    ////////////////////////////////
    public int gridID = 0;
    public int gridTypeID = 0;

    // //////////////////////////
	
	public ProfileParts() {
	}
	
	public boolean profileIDTest(RuleTest test, List myRuleTestValues) {
		
		boolean pass = false;
		
		if (test.isrange) {
			pass = isWithinRange(test.value1, test.value2, partID);
			
		} else {
			pass = isWithinValues(partID, 0, myRuleTestValues.toArray());
			
		}
		
		if (test.isnot) {
			pass = !pass;
		}
		
		return pass;
	}
	
	public boolean typeTest(RuleTest test, List myRuleTestValues) {
		
		boolean pass = false;
		
		if (test.isrange) {
			pass = isWithinRange(test.value1, test.value2, typeID);
			
		} else {
			pass = isWithinValues(typeID, 0, myRuleTestValues.toArray());
			
		}
		
		if (test.isnot) {
			pass = !pass;
		}
		
		return pass;
	}
	
	public boolean classTest(RuleTest test, List myRuleTestValues) {
		
		boolean pass = false;
		
		if (test.isrange) {
			pass = isWithinRange(test.value1, test.value2, cOrM);
			
		} else {
			pass = isWithinValues(cOrM, 0, myRuleTestValues.toArray());
			
		}
		
		if (test.isnot) {
			pass = !pass;
		}
		
		return pass;
	}
	
	public boolean opClassTest(RuleTest test, List myRuleTestValues) {
		
		boolean pass = false;
		
		if (test.isrange) {
			pass = isWithinRange(test.value1, test.value2, this.openingClass);
			
		} else {
			pass = isWithinValues(this.openingClass, 0, myRuleTestValues.toArray());
			
		}
		
		if (test.isnot) {
			pass = !pass;
		}
		
		return pass;
	}
	
	public boolean udOpeningTest(RuleTest test, List myRuleTestValues) {
		
		boolean pass = false;
		
		if (test.isrange) {
			pass = isWithinRange(test.value1, test.value2, this.udControlOpeningID);
			
		} else {
			pass = isWithinValues(this.udControlOpeningID, 0, myRuleTestValues.toArray());
			
		}
		
		if (test.isnot) {
			pass = !pass;
		}
		
		return pass;
	}

	public boolean formTest(RuleTest test, List myRuleTestValues) {
		
		boolean pass = false;
		
		if (test.isrange) {
			pass = isWithinRange(test.value1, test.value2, this.partForm);
			
		} else {
			pass = isWithinValues(partForm, 0, myRuleTestValues.toArray());
			
		}
		
		if (test.isnot) {
			pass = !pass;
		}
		
		return pass;
	}
	
	public boolean angleTest(RuleTest test, List myRuleTestValues) {
		
		boolean pass = false;
		
		if (test.isrange) {
			pass = isWithinRange(test.value1, test.value2, this.angle);
			
		} else {
			pass = isWithinValues(angle, 0, myRuleTestValues.toArray());
			
		}
		
		if (test.isnot) {
			pass = !pass;
		}
		
		return pass;
	}
	
	public void recalcProfileDims(){

        Parts parts = null;
        if (this.remote) {
            parts = ItemFrame.getApplicationRemoteBaseRules().getPart(this.supplierId, this.partID);
        } else {
            parts = ItemFrame.getApplicationBaseRules().getPart(this.partID);
        }

        if (parts != null) {

            this.partDimA = new BigDecimal(parts.getDima()).multiply(this.myFrame2.metricscale).doubleValue();
            this.partDimB = new BigDecimal(parts.getDimb()).multiply(this.myFrame2.metricscale).doubleValue();
            this.partDimC = new BigDecimal(parts.getDimc()).multiply(this.myFrame2.metricscale).doubleValue();
            this.partDimD = new BigDecimal(parts.getDimd()).multiply(this.myFrame2.metricscale).doubleValue();
            this.partDimBtoC = new BigDecimal(parts.getDimbtoc()).multiply(this.myFrame2.metricscale).doubleValue();
            this.partDimM = new BigDecimal(parts.getDimm()).multiply(this.myFrame2.metricscale).doubleValue();


            this.partDimAi = new BigDecimal(parts.getDimai()).multiply(this.myFrame2.imperialscale).doubleValue();
            this.partDimBi = new BigDecimal(parts.getDimbi()).multiply(this.myFrame2.imperialscale).doubleValue();
            this.partDimCi = new BigDecimal(parts.getDimci()).multiply(this.myFrame2.imperialscale).doubleValue();
            this.partDimDi = new BigDecimal(parts.getDimdi()).multiply(this.myFrame2.imperialscale).doubleValue();
            this.partDimBtoCi = new BigDecimal(parts.getDimbtoc_imp()).multiply(this.myFrame2.imperialscale).doubleValue();
            this.partDimMi = new BigDecimal(parts.getDimm_imp() / 64).multiply(this.myFrame2.imperialscale).doubleValue();
        }
    }

	public boolean lengthTest(RuleTest test, int condition, int myUOM, List myRuleTestValues) {
		
		boolean pass = false;
		
		if (test.isrange) {
			if (condition != 4) {
				if (myUOM == 1) {
					pass = isWithinRange(test.value1, test.value2, this.lengthM);
				} else {
					pass = isWithinRange(test.value1i, test.value2i, lengthI);
				}
				
			} else
				// Nominal <--- ---> condition 4
			{
				if (myUOM == 1) {
                    pass = isWithinRange(test.value1, test.value2, lengthMN);
					
				} else {
					pass = isWithinRange(test.value1i, test.value2i, lengthIN);
					
				}
			}
			
		} else {
			
			if (condition != 4) {
				if (myUOM == 1) {
					
					pass = isWithinValues(lengthM, myUOM, myRuleTestValues.toArray());
					
				} else {
					
					pass = isWithinValues(lengthI, myUOM, myRuleTestValues.toArray());
					
				}
				
			} else {// Nominal <--- ---> Condition == 4
				if (myUOM == 1) {
					
					pass = isWithinValues(lengthMN, myUOM, myRuleTestValues.toArray());
					
				} else {
					
					pass = isWithinValues(lengthIN, myUOM, myRuleTestValues.toArray());
					
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
	
	public boolean optionTest(RuleTest test, int myUOM, List myRuleTestValues) {
		
		boolean pass = false;
		
		Object[] options = this.options.toArray();
		
		OptionDefinitions myOption = new OptionDefinitions();
		if (test.isRemote()) {
            myOption = ItemFrame.getApplicationRemoteBaseRules().getOptionDefinitions(test.getSupplierId(), test.value1.intValue());
        } else {
		    myOption = ItemFrame.getApplicationBaseRules().getOptionDefinitions(test.value1.intValue());
        }
		
		for (Object op : options) {
			
			if (((ShapeOption) op).optionid == myOption.getId()) {
				
				if (myOption.getOptiontypeid() == 1) {// Answer
					if (test.isrange) {
						pass = isWithinRange(test.value1, test.value2, ((ShapeOption) op).answerid);
					} else {
						pass = isWithinValues(((ShapeOption) op).answerid, myUOM, myRuleTestValues.toArray());
					}
					
				} else if (myOption.getOptiontypeid() == 2) {// Color
					
					if (test.isrange) {
						pass = isWithinRange(test.value1, test.value2, ((ShapeOption) op).answerid);
					} else {
						pass = isWithinValues(((ShapeOption) op).answerid, myUOM, myRuleTestValues.toArray());
					}
				} else if (myOption.getOptiontypeid() == 3) {// quantity
					
					if (test.isrange) {
						pass = isWithinRange(test.value1, test.value2, ((ShapeOption) op).qtyanswer);
					} else {
						pass = isWithinValues(((ShapeOption) op).qtyanswer, myUOM, myRuleTestValues.toArray());
					}
				} else if (myOption.getOptiontypeid() == 4) {// size
					if (test.isrange) {
						if (myUOM == 1) {
							pass = isWithinRange(test.value1, test.value2, ((ShapeOption) op).sizeanswer);
						} else {
							pass = isWithinRange(test.value1, test.value2, ((ShapeOption) op).sizeansweri);
						}
					} else {
						if (myUOM == 1) {
							pass = isWithinValues(((ShapeOption) op).sizeanswer, myUOM, myRuleTestValues.toArray());
						} else {
							pass = isWithinValues(((ShapeOption) op).sizeansweri, myUOM, myRuleTestValues.toArray());
						}
					}
					
				} else if (myOption.getOptiontypeid() == 5) {// depth
					if (test.isrange) {
						if (myUOM == 1) {
							pass = isWithinRange(test.value1, test.value2, ((ShapeOption) op).depthanswer);
						} else {
							pass = isWithinRange(test.value1, test.value2, ((ShapeOption) op).depthansweri);
						}
					} else {
						if (myUOM == 1) {
							pass = isWithinValues(((ShapeOption) op).depthanswer, myUOM, myRuleTestValues.toArray());
						} else {
							pass = isWithinValues(((ShapeOption) op).depthansweri, myUOM, myRuleTestValues.toArray());
						}
					}
				} else if (myOption.getOptiontypeid() == 6) {// text
					
				} else if (myOption.getOptiontypeid() == 7) {// adjust +/-
					if (test.isrange) {
						if (myUOM == 1) {
							pass = isWithinRange(test.value1, test.value2, ((ShapeOption) op).adjust);
						} else {
							pass = isWithinRange(test.value1, test.value2, ((ShapeOption) op).adjusti);
						}
					} else {
						if (myUOM == 1) {
							pass = isWithinValues(((ShapeOption) op).adjust, myUOM, myRuleTestValues.toArray());
						} else {
							pass = isWithinValues(((ShapeOption) op).adjusti, myUOM, myRuleTestValues.toArray());
						}
					}
				}
			}
		}
		
		return pass;
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
		if (myUOM <= 1)
		{
			for (Object tv : objects) {
				if (((RuleTestValue) tv).getRuleTestValuePK().getValue() == value) {
					pass = true;
					break;
				}
			}
			
		} else {
			for (Object tv : objects) {
				if (((RuleTestValue) tv).getRuleTestValuePK().getValuei() == value) {
					pass = true;
					break;
				}
			}
		}
		return pass;
	}

    public void executeRulesMethod(String from) {
        if (myFrame2 != null) {
            this.myFrame2.executePartRules.executeOptionRules(null, null, (Profiles) this, this.a_assemblyLevel, from);
        }
    }


    /**
	 * Execute Rules for Shape
	 * 
	 */
    public void executePartRules(boolean doErrors, boolean doAll, String from) throws Exception {
//        this.myFrame2.executePartRules.executePartRules(null, null, (Profiles) this, this.a_assemblyLevel, doErrors, doAll, from, true);
    }
    
    /**
     * Execute Part Rules for Profiles
     * @param rule, Rules
     * @throws Exception, Exception
     */
    public void executePartRules(Rules rule, boolean doBom) {
        this.myFrame2.executePartRules.executePartRules(rule, null, (Profiles)this, doBom);
    }
    
    /**
     * Execute Part Rules for Shape
     */
    public Profiles executePartRules(boolean doBom) {

        //Get all part rules
        List<Rules> rules = this.myFrame2.executePartRules.getAllpartRules(ItemFrame.getApplicationBaseRules().
                getRulesProfiles(this.myFrame2.seriesID, (Profiles) this));

        for (Rules rule : rules) {
            //Execute Part Rules
            this.myFrame2.executePartRules.executePartRules(rule, null, (Profiles)this, doBom);
        }
       
        return ((Profiles)this);
    }

    /**
     * Load Bill Of Material Components
     */
    public void loadBOMParts() {

        //Load BOM Parts
        if (this.bom != null && this.bom.size() > 0) {
            this.myFrame2.jobItem.bom.addAll(this.bom);
        }
    }

    /**
     *  Clear Bill Of Material Components
     */
    public void clearBOMParts() {

        //Clear BOM Parts
        if (this.bom != null && this.bom.size() > 0) {
            this.bom.clear();
            this.notes.clear();
        }
    }

    /**
     * Load Options All
     */
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

    }


    public void setMullionColor() {

        int rgb_r = 255;
        int rgb_g = 255;
        int rgb_b = 255;

        Object[] myOpts = options.toArray();

        if (options.size() == 0) {
            myOpts = this.myParent.options.toArray();
        }

        for (Object o : myOpts) {
            ShapeOption shapeOption = (ShapeOption)o;

            int iscolor = 0;
            
            OptionDefinitions option = null;
            OptionAnswers answer = null;
            if (shapeOption.remote) {
                option = ItemFrame.getApplicationRemoteBaseRules().getOptionDefinitions(shapeOption.supplierId,
                        shapeOption.optionid);
                answer = ItemFrame.getApplicationRemoteBaseRules().getOptionAnswers(shapeOption.supplierId, 
                		shapeOption.optionid, shapeOption.answerid);
            } else {
            	option = ItemFrame.getApplicationBaseRules().getOptionDefinitions(
                        shapeOption.optionid);
                answer = ItemFrame.getApplicationBaseRules().getOptionAnswers(
                		shapeOption.optionid, shapeOption.answerid);
                
            }
            iscolor = option.getOptiontypeid();
            
            if (iscolor == 2 ) {
                rgb_b = answer.getRgb_B();
                rgb_g = answer.getRgb_G();
                rgb_r = answer.getRgb_R();
            }
        }
        if (myOpts.length > 0) {
            rgb_B = rgb_b;
            rgb_R = rgb_r;
            rgb_G = rgb_g;
        }

    }

    @Override
	public BigDecimal calculateWidth(int measure)
	{
		
		return new BigDecimal(-1);
	}
	
	@Override
	public BigDecimal calculateHeight(int measure)
	{
		
		return new BigDecimal(-1);
	}
	
	@Override
	public BigDecimal calculateArea(int measure)
	{
		
		return new BigDecimal(-1);
	}
	
	@Override
	public BigDecimal calculateUI(int measure)
	{
		return new BigDecimal(-1);
	}
	
	@Override
	public BigDecimal returnOpeningClassID()
	{
		return new BigDecimal(-1);
	}
	
	@Override
	public BigDecimal returnShapeID()
	{
		return new BigDecimal(-1);
	}
	
	@Override
	public BigDecimal returnSUFamiles() {
		// TODO Auto-generated method stub
		return new BigDecimal(-1);
	}

	
	@Override
	public BigDecimal returnOptionAndAnswer(int optionid, int uom)
	{
		
		// Search All Options for Options fro this matrixCalculation
		// Why Search All options?
		// because we do not know if the
		// Shape was modified and options reset.
		
		BigDecimal returnValue = new BigDecimal(0);
		
		Object[] optionsAll = myFrame2.designOptionsAll.toArray();
		 
		for (Object o : optionsAll)
		{
			if (((DesignOption) o).optionid == optionid && ((DesignOption) o).isForLevel(((Profiles) this).a_assemblyLevel))
			{
				
				if (((DesignOption) o).myoption.getOptiontypeid() <= 2)
				{
					returnValue = new BigDecimal(((DesignOption) o).answerid);
				}
				if (((DesignOption) o).myoption.getOptiontypeid() == 3)
				{
					returnValue = new BigDecimal(((DesignOption) o).qtyanswer);
				}
				else if (((DesignOption) o).myoption.getOptiontypeid() == 4)
				{
					if (uom == 1)
					{
						returnValue = new BigDecimal(((DesignOption) o).sizeanswer);
					}
					else
					{
						returnValue = new BigDecimal(((DesignOption) o).sizeansweri);
					}
					
				}
				else if (((DesignOption) o).myoption.getOptiontypeid() == 5)
				{
					if (uom == 1)
					{
						returnValue = new BigDecimal(((DesignOption) o).depthanswer);
					}
					else
					{
						returnValue = new BigDecimal(((DesignOption) o).depthansweri);
					}
				}
				else if (((DesignOption) o).myoption.getOptiontypeid() == 6)
				{
					returnValue = new BigDecimal(((DesignOption) o).textAnswer);
				}
				else if (((DesignOption) o).myoption.getOptiontypeid() == 7)
				{
					if (uom == 1)
					{
						returnValue = new BigDecimal(((DesignOption) o).adjust);
					}
					else
					{
						returnValue = new BigDecimal(((DesignOption) o).adjusti);
					}
				}
				// break;//?????
			}
			
		}
		return returnValue;
	}
	
	@Override
	public BigDecimal returnUserDefinedOpeningID()
	{
		return new BigDecimal(-1);
	}
	
	@Override
	public BigDecimal returnPartnerIdentificationID()
	{
		return new BigDecimal(myFrame2.myCustomer.getId());
	}
	
	@Override
	public BigDecimal returnPartnerGroupID()
	{
		return new BigDecimal(myFrame2.myCustomer.getGroupId());
	}
	
	@Override
	public BigDecimal returnDesignID()
	{
		return new BigDecimal(myFrame2.jobItem.designID);
	}
	
	@Override
	public BigDecimal returnStdProductID()
	{
		return new BigDecimal(myFrame2.jobItem.stdProdCode);
	}
	
	@Override
	public BigDecimal returnProductType()
	{
		return new BigDecimal(-1);
	}
	
	@Override
	public BigDecimal calculateLength(int systemMeasurement)
	{
		if (systemMeasurement == 1)
		{
			return new BigDecimal(this.length);
		}
		else
		{
			return new BigDecimal(this.lengthI);
		}
	}
	
	@Override
	public BigDecimal returnQty()
	{
		return new BigDecimal(-1);
	}
	
	@Override
	public BigDecimal calculateVolume(int systemMeasurement)
	{
		
		return new BigDecimal(-1);
	}
	
	@Override
	public BigDecimal returnStockCode()
	{
		
		return new BigDecimal(stockCode);
	}
	
	@Override
	public BigDecimal returnGridType()
	{
		
		return new BigDecimal(this.gridTypeID);
	}

	@Override
	public BigDecimal returnGridID()
	{
		
		return new BigDecimal(this.gridID);
	}
	
	@Override
	public BigDecimal returnNumberGridsW()
	{
		
		return new BigDecimal(-1);
	}
	
	@Override
	public BigDecimal returnNumberGridsH()
	{
		
		return new BigDecimal(-1);
	}
	
	@Override
	public BigDecimal returnNumberSpokes()
	{
		
		return new BigDecimal(-1);
	}
	
	@Override
	public BigDecimal returnNumberRadii()
	{
		
		return new BigDecimal(-1);
	}
	
	public ProfileParts resetPartDims(ProfileParts original)
	{
		
		original.partDimBtoC = 0;
		original.partDimBtoCi = 0;
		original.partDimA = 0;
		original.partDimAi = 0;
		original.partDimB = 0;
		original.partDimBi = 0;
		original.partDimC = 0;
		original.partDimCi = 0;
		original.partDimM = 0;
		original.partDimMi = 0;
		
		return original;
	}
	
	public ProfileParts cloneProfile(ProfileParts original)
	{
		
		this.myParent = original.myParent;
		this.myFrame2 = myFrame2;
		
		
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
		
		this.bkgrdHeight = original.bkgrdHeight;
		this.bkgrdHeightA = original.bkgrdHeightA;
		this.bkgrdHeightBA = original.bkgrdHeightBA;
		this.bkgrdHeightBC = original.bkgrdHeightBC;
		
		this.bkgrdWidth = original.bkgrdWidth;
		this.bkgrdWidthA = original.bkgrdWidthA;
		this.bkgrdWidthBA = original.bkgrdWidthBA;
		this.bkgrdWidthBC = original.bkgrdWidthBC;
		
		this.bkgrdStartX = original.bkgrdStartX;
		this.bkgrdStartXA = original.bkgrdStartXA;
		this.bkgrdStartXBA = original.bkgrdStartXBA;
		this.bkgrdStartXBC = original.bkgrdStartXBC;
		
		this.bkgrdStartY = original.bkgrdStartY;
		this.bkgrdStartYA = original.bkgrdStartYA;
		this.bkgrdStartYBA = original.bkgrdStartYBA;
		this.bkgrdStartYBC = original.bkgrdStartYBC;
		
		this.focal1X = original.focal1X;
		this.focal1XA = original.focal1XA;
		this.focal1XBA = original.focal1XBA;
		this.focal1XBC = original.focal1XBC;
		this.focal1Y = original.focal1Y;
		this.focal1YA = original.focal1YA;
		this.focal1YBA = original.focal1YBA;
		this.focal1YBC = original.focal1YBC;
		this.focal2X = original.focal2X;
		this.focal2XA = original.focal2XA;
		this.focal2XBA = original.focal2XBA;
		this.focal2XBC = original.focal2XBC;
		this.focal2Y = original.focal2Y;
		this.focal2YA = original.focal2YA;
		this.focal2YBA = original.focal2YBA;
		this.focal2YBC = original.focal2YBC;
		
		this.glazingDepth = original.glazingDepth;
		
		
		
		this.length = original.length;
		this.lengthA = original.lengthA;
		this.lengthBA = original.lengthBA;
		this.lengthBC = original.lengthBC;
		
		lengthM = original.lengthM;
		lengthI = original.lengthI;
		lengthMN = original.lengthMN;
		lengthIN = original.lengthIN;
		
		this.mitreLengthLT = original.mitreLengthLT;
		this.mitreLengthRB = original.mitreLengthRB;
		
		this.myWidth = original.myWidth;
		this.myWidthA = original.myWidthA;
		this.myWidthBA = original.myWidthBA;
		
		this.outLaminateArea = original.outLaminateArea;
		this.outPaintArea = original.outPaintArea;
		this.inLaminateArea = original.inLaminateArea;
		this.inPaintArea = original.inPaintArea;
		
		this.partDimBtoC = original.partDimBtoC;
		this.partDimBtoCi = original.partDimBtoCi;
		this.partDimA = original.partDimA;
		this.partDimAi = original.partDimAi;
		this.partDimB = original.partDimB;
		this.partDimBi = original.partDimBi;
		this.partDimC = original.partDimC;
		this.partDimCi = original.partDimCi;
		this.partDimM = original.partDimM;
		this.partDimMi = original.partDimMi;
		
		this.partForm = original.partForm;
		/**
		 * 1 lines, 2 arc, 3 Ellipse
		 */
		
		this.partID = original.partID;
		this.partShape = original.partShape;
		/**
		 * L, t, z, i, h
		 */
		
		this.position = original.position;
		/**
		 * 1,2,3 TOP 4 RIGHT, 5,6,7 BOT 8 LEFT
		 */
		
		this.seq = original.seq;
		
		this.radianCentralAngle = original.radianCentralAngle;
		
		this.radius1 = original.radius1;
		this.radius1A = original.radius1A;
		this.radius1BA = original.radius1BA;
		this.radius1BC = original.radius1BC;
		this.radius2 = original.radius2;
		this.radius2A = original.radius2A;
		this.radius2BA = original.radius2BA;
		this.radius2BC = original.radius2BC;
		
		
		// From Level Shape and Calculates
		
		this.rID = original.rID;
		
		/**
		 * radius to left/rIGHT side angle
		 */
		
		this.rbAngle = original.rbAngle;
		this.rbAngleA = original.rbAngleA;
		this.rbAngleBA = original.rbAngleBA;
		this.rbAngleBC = original.rbAngleBC;
		this.rlAngle = original.rlAngle;
		this.rlAngleA = original.rlAngleA;
		this.rlAngleBA = original.rlAngleBA;
		
		/**
		 * radius to left/rIGHT side SLOPE
		 */
		this.rlSlope = original.rlSlope;
		this.rlSlopeA = original.rlSlopeA;
		this.rlSlopeBA = original.rlSlopeBA;
		this.rrAngle = original.rrAngle;
		this.rrAngleA = original.rrAngleA;
		this.rrAngleBA = original.rrAngleBA;
		this.rrSlope = original.rrSlope;
		this.rrSlopeA = original.rrSlopeA;
		this.rrSlopeBA = original.rrSlopeBA;
		
		this.slope = original.slope;
		this.slopeA = original.slopeA;
		this.slopeBA = original.slopeBA;
		this.slopeBC = original.slopeBC;
		
		this.startAngle = original.startAngle;
		this.startAngleA = original.startAngleA;
		this.startAngleBA = original.startAngleBA;
		this.startAngleBC = original.startAngleBC;
		
		this.startingX = original.startingX; // called
		this.startingXA = original.startingXA; // called
		this.startingXBA = original.startingXBA; // called
		this.startingXBC = original.startingXBC; // called
		
		this.startingY = original.startingY;
		this.startingYA = original.startingYA;
		this.startingYBA = original.startingYBA;
		this.startingYBC = original.startingYBC;
		
		
		this.startXC = original.startXC;
		this.startYC = original.startYC;
		this.startX = original.startX;
		this.startY = original.startY;
		this.startXA = original.startXA;
		this.startYA = original.startYA;
		this.startXBA = original.startXBA;
		this.startYBA = original.startYBA;
		
		
		this.endXC = original.endXC;
		this.endYC = original.endYC;
		this.endX = original.endX;
		this.endY = original.endY;
		this.endXA = original.endXA;
		this.endYA = original.endYA;
		this.endXBA = original.endXBA;
		this.endYBA = original.endYBA;
		
		this.stopAeX = original.stopAeX;
		this.stopAeY = original.stopAeY;
		this.stopAsX = original.stopAsX;
		this.stopAsY = original.stopAsY;
		
		
		
		this.stockCode = original.stockCode;
		
		this.color = original.color;
		
		// From Rules
		
		this.totalDepth = original.totalDepth;
		this.totalSurfaceArea = original.totalSurfaceArea;
		
		this.endTypeLT = original.endTypeLT;
		this.endTypeRB = original.endTypeRB;
		
		
		this.parentW = original.parentW;
		
		this.rgb_R = original.rgb_R;
		this.rgb_G = original.rgb_G;
		this.rgb_B = original.rgb_B;
		
		this.rgb_Rt = original.rgb_Rt;
		this.rgb_Gt = original.rgb_Gt;
		this.rgb_Bt = original.rgb_Bt;
		
		this.profileSelected = original.profileSelected;
		
		this.mullionLeft = original.mullionLeft;
		this.mullionRight = original.mullionRight;
		
		this.posInUse = original.posInUse;
		
		
		
		this.rowCol = original.rowCol;
		
		this.exists = original.exists;
		
		
		
		
		this.bkgrdHeight = original.bkgrdHeight;
		this.bkgrdHeightA = original.bkgrdHeightA;
		this.bkgrdHeightBA = original.bkgrdHeightBA;
		this.bkgrdHeightBC = original.bkgrdHeightBC;
		
		this.bkgrdWidth = original.bkgrdWidth;
		this.bkgrdWidthA = original.bkgrdWidthA;
		this.bkgrdWidthBA = original.bkgrdWidthBA;
		this.bkgrdWidthBC = original.bkgrdWidthBC;
		
		this.bkgrdStartX = original.bkgrdStartX;
		this.bkgrdStartXA = original.bkgrdStartXA;
		this.bkgrdStartXBA = original.bkgrdStartXBA;
		this.bkgrdStartXBC = original.bkgrdStartXBC;
		this.bkgrdStartY = original.bkgrdStartY;
		this.bkgrdStartYA = original.bkgrdStartYA;
		this.bkgrdStartYBA = original.bkgrdStartYBA;
		this.bkgrdStartYBC = original.bkgrdStartYBC;
		
		
		this.centralAngle = original.centralAngle;
		this.centralAngleA = original.centralAngleA;
		this.centralAngleBA = original.centralAngleBA;
		this.centralAngleBC = original.centralAngleBC;
		
		this.endAngle = original.endAngle;
		this.endAngleA = original.endAngleA;
		this.endAngleBA = original.endAngleBA;
		this.endAngleBC = original.endAngleBC;
		
		this.dimB1A = original.dimB1A;
		this.dimB1B = original.dimB1B;
		
		this.ltAngle = original.ltAngle;
		this.ltAngleA = original.ltAngleA;
		this.ltAngleBA = original.ltAngleBA;
		this.ltAngleBC = original.ltAngleBC;
		
		
		
		this.continuity = original.continuity;
		
		if (original.notches != null && original.notches.size() > 0)
		{
			Collection newNothches = new ArrayList();
			Object[] notches = original.notches.toArray();
			for (final Object n : notches)
			{
				newNothches.add(((PartsNotching) n).cloneNotches(((PartsNotching) n)));
			}
			this.notches = newNothches;
		}
		
		this.myOpeningsLT = this.cloneCollections(original.myOpeningsLT);
		
		this.myOpeningsRB = this.cloneCollections(original.myOpeningsRB);
		
		
		
		this.startPos = original.startPos;
		this.endPos = original.endPos;
		
		this.centerXsa = original.centerXsa;
		this.centerYsa = original.centerYsa;
		this.centerXea = original.centerXea;
		this.centerYea = original.centerYea;
		
		this.xcs = original.xcs;
		this.ycs = original.ycs;
		
		this.xce = original.xce;
		this.yce = original.yce;
		
		this.x1 = original.x1;
		this.x1a = original.x1a;
		this.x2 = original.x2;
		this.x2a = original.x2a;
		this.x3 = original.x3;
		this.x3a = original.x3a;
		this.x4 = original.x4;
		this.x4a = original.x4a;
		
		this.y1 = original.y1;
		this.y1a = original.y1a;
		this.y2 = original.y2;
		this.y2a = original.y2a;
		this.y3 = original.y3;
		this.y3a = original.y3a;
		this.y4 = original.y4;
		this.y4a = original.y4a;
		
		this.x1al = original.x1al;
		this.y1al = original.y1al;
		this.x2cl = original.x2cl;
		this.y2cl = original.y2cl;
		this.x3cl = original.x3cl;
		this.y3cl = original.y3cl;
		this.x4al = original.x4al;
		this.y4al = original.y4al;
		
		this.x1a = original.x1a;
		this.y1a = original.y1a;
		this.x2a = original.x2a;
		this.y2a = original.y2a;
		this.x3a = original.x3a;
		this.y3a = original.y3a;
		this.x4a = original.x4a;
		this.y4a = original.y4a;
		
		this.x1a3 = original.x1a3;
		this.y1a3 = original.y1a3;
		this.x2a3 = original.x2a3;
		this.y2a3 = original.y2a3;
		this.x3a3 = original.x3a3;
		this.y3a3 = original.y3a3;
		this.x4a3 = original.x4a3;
		this.y4a3 = original.y4a3;
		
		this.x1b = original.x1b;
		this.y1b = original.y1b;
		this.x2b = original.x2b;
		this.y2b = original.y2b;
		this.x3b = original.x3b;
		this.y3b = original.y3b;
		this.x4b = original.x4b;
		this.y4b = original.y4b;
		
		this.centerXs = original.centerXs;
		this.centerYs = original.centerYs;
		this.centerXe = original.centerXe;
		this.centerYe = original.centerYe;
		
		this.dx1 = original.dx1;
		this.dy1 = original.dy1;
		this.dx2 = original.dx2;
		this.dy2 = original.dy2;
		this.dx3 = original.dx3;
		this.dy3 = original.dy3;
		this.dx4 = original.dx4;
		this.dy4 = original.dy4;
		this.dx1al = original.dx1al;
		this.dy1al = original.dy1al;
		this.dx2cl = original.dx2cl;
		this.dy2cl = original.dy3cl;
		this.dx3cl = original.dx3cl;
		this.dy3cl = original.dy3cl;
		this.dx4al = original.dx4al;
		this.dy4al = original.dy4al;
		this.dcenterXs = original.dcenterXs;
		this.dcenterYs = original.dcenterYs;
		this.dcenterXe = original.dcenterXe;
		this.dcenterYe = original.dcenterYe;
		
		this.scale = original.scale;
		
		this.thickness = original.thickness;
		
		this.CouplerShapeID = original.CouplerShapeID;
		
		this.orientation = original.orientation;
		this.frameLTid = original.frameLTid;
		this.frameRBid = original.frameRBid;
		
		this.radius1c = original.radius1c;
		this.radius1c1 = original.radius1c1;
		this.radius1a1 = original.radius1a1;
		this.radius1a = original.radius1a;
		this.arcH = original.arcH;
		
		this.endAnglec = original.endAnglec;
		this.startAnglec1 = original.startAnglec1;
		this.endAnglec1 = original.endAnglec1;
		this.startAnglea1 = original.startAnglea1;
		this.endAnglea1 = original.endAnglea1;
		this.startAnglea = original.startAnglea;
		this.endAnglea = original.endAnglea;
		this.couplerTypeID = original.couplerTypeID;
		this.openingLT = original.openingLT;
		this.openingRB = original.openingRB;
		this.whichPos = original.whichPos;
		this.baseRT = original.baseRT;
		this.baseLB = original.baseLB;
		this.baseCenter = original.baseCenter;
		this.newAlpha = original.newAlpha;
		this.newStartingYRT = original.newStartingYRT;
		this.newStartingXRT = original.newStartingXRT;
		this.newAlpha2 = original.newAlpha2;
		this.newStartingYLB = original.newStartingYLB;
		this.newStartingXLB = original.newStartingXLB;
		this.newAlpha3 = original.newAlpha3;
		this.newStartingYCenter = original.newStartingYCenter;
		this.newStartingXCenter = original.newStartingXCenter;
		this.newAlphaA = original.newAlphaA;
		this.newAlphaC = original.newAlphaC;
		this.baseLBa = original.baseLBa;
		this.baseRTc = original.baseRTc;
		this.newStartingXLBa = original.newStartingXLBa;
		this.newStartingXRTc = original.newStartingXRTc;
		this.newStartingYLBa = original.newStartingYLBa;
		this.newStartingYRTc = original.newStartingYRTc;
		this.newBeta = original.newBeta;
		this.theta = original.theta;
		this.alpha = original.alpha;
		this.newYLeft = original.newYLeft;
		this.newYRight = original.newYRight;
		this.newYCenter = original.newYCenter;
		this.newXcenterStart = original.newXcenterStart;
		this.tempDelta = original.tempDelta;
		this.isBefore = original.isBefore;
		this.endCID = original.endCID;
		this.startCID = original.startCID;
		this.isValid = original.isValid;
		this.angleTLa = original.angleTLa;
		this.angleBLa = original.angleBLa;
		this.angleTRc = original.angleTRc;
		this.angleBRc = original.angleBRc;
		this.offsetTL = original.offsetTL;
		this.offsetRB = original.offsetRB;
		this.deltaTL = original.deltaTL;
		this.deltaRB = original.deltaRB;
		this.curveCenterTL = original.curveCenterTL;
		this.curveCenterRB = original.curveCenterRB;
		this.bcSP0x = original.bcSP0x;
		this.bcSP1x = original.bcSP1x;
		this.bcCP1x = original.bcCP1x;
		this.bcCP2x = original.bcCP2x;
		this.bcEP1x = original.bcEP1x;
		this.bcEP0x = original.bcEP0x;
		this.bcSP0y = original.bcSP0y;
		this.bcSP1y = original.bcSP1y;
		this.bcCP1y = original.bcCP1y;
		this.bcCP2y = original.bcCP2y;
		this.bcEP1y = original.bcEP1y;
		this.bcEP0y = original.bcEP0y;
		this.joinM = original.joinM;
		this.posCondition = original.posCondition;
		this.mType = original.mType;
		this.remove = original.remove;
		
		this.potentialS = original.potentialS;
		this.delta = original.delta;
		this.startIn = original.startIn;
		this.endIn = original.endIn;
		this.partLeft = original.partLeft;
		this.partRight = original.partRight;
		this.cOrM = original.cOrM;
		
		
		this.drawcoupler = original.drawcoupler;
		this.joinC = original.joinC;
		this.opDone = original.opDone;
		this.finalVerify = original.finalVerify;
		this.unique = original.unique;
		this.followFrame = original.followFrame;
		this.isExtra = original.isExtra;
		this.isNew = original.isNew;
		this.openingTypeLB = original.openingTypeLB;
		this.openingIDLB = original.openingIDLB;
		this.openingTypeRT = original.openingTypeRT;
		this.openingIDRT = original.openingIDRT;
		this.manualPos = original.manualPos;
		this.angle = original.angle;
		this.fixedAngle = original.fixedAngle;
		this.phantom = original.phantom;
		this.order = original.order;
		
		this.limitStartX1 = original.limitStartX1;
		this.limitStartX1a = original.limitStartX1a;
		this.limitEndX3 = original.limitEndX3;
		this.limitEndX3c = original.limitEndX3c;
		this.limitEndX4 = original.limitEndX4;
		this.limitEndX4a = original.limitEndX4a;
		this.limitEndXC = original.limitEndXC;
		this.limitEndY3 = original.limitEndY3;
		this.limitEndY3c = original.limitEndY3c;
		this.limitEndY4 = original.limitEndY4;
		this.limitEndY4a = original.limitEndY4a;
		this.limitEndYC = original.limitEndYC;
		this.limitStartX2 = original.limitStartX2;
		this.limitStartX2c = original.limitStartX2c;
		this.limitStartXC = original.limitStartXC;
		this.limitStartY1 = original.limitStartY1;
		this.limitStartY1a = original.limitStartY1a;
		this.limitStartY2 = original.limitStartY2;
		this.limitStartY2c = original.limitStartY2c;
		this.limitStartYC = original.limitStartYC;
		
		this.partIDByUser = original.partIDByUser;
		this.endTypeLTByUser = original.endTypeLTByUser;
		this.endTypeRBByUser = original.endTypeRBByUser;
		
		this.notchLT = original.notchLT;
		this.notchLTi = original.notchLTi;
		this.notchRB = original.notchRB;
		this.notchRBi = original.notchRBi;
		this.udControlOpeningID = original.udControlOpeningID;
		this.openingClass = original.openingClass;

        this.supplierId = original.supplierId;
        this.remote = original.remote;

		return this;
	}
	
	public void calcAngles()
	{
		
		if (position != 4 && position != 8)
		{
//			if (startX != startXBA)
//			{
				ltAngle = Math.toDegrees(Math.atan((startX - startXA) / (startY - startYA)));
				
				rbAngle = Math.toDegrees(Math.atan((endX - endXA) / (endY - endYA)));
//			}
//			else
//			{
//				double o = startY - endY;
//				ltAngle = Math.toDegrees(Math.asin(o / length));
//				o = endY - startY;
//				rbAngle = Math.toDegrees(Math.asin(o / length));
//			}
		}
		else if (position == 4)
		{
//			if (startY != startYBA)
//			{
				ltAngle = Math.toDegrees(Math.atan((startX - startXBA) / (startY - startYBA)));
//			}
//			else
//			{
//				double b = Math.sqrt((Math.pow(partDimB, 2)) - (Math.pow(startX - startXBA, 2)));
//				ltAngle = Math.toDegrees(Math.asin(b / (startX - startXBA)));
//			}
			
//			if (endY != endYBA)
				rbAngle = Math.toDegrees(Math.atan((endX - endXBA) / (endY - endYBA)));
			
//			else
//			{
//				double b = Math.sqrt((Math.pow(partDimB, 2)) - (Math.pow(startX - startXBA, 2)));
//				rbAngle = Math.toDegrees(Math.asin(b / (startX - startXBA)));
//			}
		}
		
		else if (position == 8)
		{
//			if (startY != startYBA)
//			{
				ltAngle = Math.toDegrees(Math.atan((startX - startXBA) / (startY - startYBA)));
//			}
//			else
//			{
//				double b = Math.sqrt((Math.pow(partDimB, 2)) - (Math.pow(startX - startXBA, 2)));
//				ltAngle = Math.toDegrees(Math.asin(b / (startX - startXBA)));
//			}
//			
//			if (endY != endYBA)
				rbAngle = Math.toDegrees(Math.atan((endX - endXBA) / (endY - endYBA)));
//			
//			else
//			{
//				double b = Math.sqrt((Math.pow(partDimB, 2)) - (Math.pow(startX - startXBA, 2)));
//				rbAngle = Math.toDegrees(Math.asin(b / (startX - startXBA)));
//			}
		}
		
		
		if (ltAngle == 0 || Double.isNaN(ltAngle))
		{
			ltAngle = 90;
		}
		if (rbAngle == 0 || Double.isNaN(rbAngle))
		{
			rbAngle = 90;
		}
		
		BigDecimal bd = new BigDecimal(ltAngle).setScale(20, RoundingMode.UP);
		ltAngle = bd.doubleValue();
		
		bd = new BigDecimal(rbAngle).setScale(20, RoundingMode.UP);
		rbAngle = bd.doubleValue();
	}
	
	public Collection cloneCollections(final Collection original)
	{
		
		final Collection newc = new ArrayList();
		final Object[] rmp = original.toArray();
		for (final Object v : rmp)
		{
			newc.add(v);
		}
		return newc;
	}
	
	public boolean isMatchingOptionRule(Rules rule)
	{
		
		boolean match = false;
	
		if (rule.getAssemblyID() <= this.a_assemblyLevel && rule.getLevelID() <= this.a_1Level)
		{
			
			match = true;
			
		}
		
		return match;
	}
	
	public boolean isMatchingRule(Rules rule)
	{
		
		boolean match = false;
		
		if (rule.assemblyid == this.a_assemblyLevel)
		{
			if (rule.p1 > 0)
			{
				if (rule.p1 == a_1Level)
				{
					if (rule.p2 > 0)
					{
						if (rule.p2 == a_2Level)
						{
							if (rule.p3 > 0)
							{
								if (rule.p3 == a_3Level)
								{
									if (rule.p4 > 0)
									{
										if (rule.p4 == a_4Level)
										{
											if (rule.p5 > 0)
											{
												if (rule.p5 == a_5Level)
												{
													if (rule.p6 > 0)
													{
														if (rule.p6 == a_6Level)
														{
															if (rule.p7 > 0)
															{
																if (rule.p8 == a_8Level)
																{
																	if (rule.p9 > 0)
																	{
																		if (rule.p9 == a_9Level)
																		{
																			if (rule.p10 > 0)
																			{
																				if (rule.p10 == a_10Level)
																				{
																					if (rule.p11 > 0)
																					{
																						if (rule.p1 == a_11Level)
																						{
																							if (rule.p12 > 0)
																							{
																								if (rule.p12 == a_12Level)
																								{
																									if (rule.p13 > 0)
																									{
																										if (rule.p13 == a_13Level)
																										{
																											if (rule.p14 > 0)
																											{
																												if (rule.p15 == a_15Level)
																												{
																													if (rule.p16 > 0)
																													{
																														if (rule.p16 == a_16Level)
																														{
																															if (rule.p17 > 0)
																															{
																																if (rule.p17 == a_17Level)
																																{
																																	if (rule.p18 > 0)
																																	{
																																		if (rule.p18 == a_18Level)
																																		{
																																			if (rule.p19 > 0)
																																			{
																																				if (rule.p19 == a_19Level)
																																				{
																																					if (rule.p20 > 0)
																																					{
																																						if (rule.p20 == a_20Level)
																																						{
																																							if (rule.p21 > 0)
																																							{
																																								if (rule.p21 == a_21Level)
																																								{
																																									if (rule.p22 > 0)
																																									{
																																										if (rule.p22 == a_22Level)
																																										{
																																											
																																											match = true;
																																											
																																										}
																																									}
																																									else
																																									{
																																										match = true;
																																									}
																																								}
																																							}
																																							else
																																							{
																																								match = true;
																																							}
																																						}
																																					}
																																					else
																																					{
																																						match = true;
																																					}
																																				}
																																			}
																																			else
																																			{
																																				match = true;
																																			}
																																		}
																																	}
																																	else
																																	{
																																		match = true;
																																	}
																																}
																															}
																															else
																															{
																																match = true;
																															}
																														}
																													}
																													else
																													{
																														match = true;
																													}
																												}
																											}
																											else
																											{
																												match = true;
																											}
																										}
																									}
																									else
																									{
																										match = true;
																									}
																								}
																							}
																							else
																							{
																								match = true;
																							}
																						}
																					}
																					else
																					{
																						match = true;
																					}
																				}
																			}
																			else
																			{
																				match = true;
																			}
																		}
																	}
																	else
																	{
																		match = true;
																	}
																}
															}
															else
															{
																match = true;
															}
														}
													}
													else
													{
														match = true;
													}
												}
											}
											else
											{
												match = true;
											}
										}
									}
									else
									{
										match = true;
									}
								}
							}
							else
							{
								match = true;
							}
						}
					}
					else
					{
						match = true;
					}
				}
			}
			
		}
		
		if(this.a_levelID == 32 || this.a_levelID == 33 || this.a_levelID == 34 || this.a_levelID == 35 || 
				this.a_levelID == 36 || this.a_levelID == 38 || this.a_levelID == 39){
        	if(rule.assemblyid ==  a_levelID){
        		 match = true;
        	}
        }
//		
//		 if(rule.getAssemblyID()>1){
//	        	
//	        	if(rule.getAssemblyID() >= this.a_levelID){
//	        		
//			        if (((rule.getRuletype()>= 9 && rule.getRuletype()<= 18) ||
//			        		(rule.getRuletype()>= 90 && rule.getRuletype()<= 94)) ) {
//			        	 
//			        	match = true;
//			        	
//			        }
//	        	}
//	        }
		
		
		
		return match;
	}
	
	//Test Implementation
    public boolean gridIDTest(RuleTest test, List myRuleTestValues) {

        boolean pass = false;

        if (test.isrange) {
            pass = isWithinRange(test.value1, test.value2, this.gridID);

        } else {
            pass = isWithinValues(this.gridID, 0, myRuleTestValues.toArray());

        }

        if (test.isnot) {
            pass = !pass;
        }

        return pass;
    }

    public boolean gridTypeTest(RuleTest test, List myRuleTestValues) {

        boolean pass = false;

        if (test.isrange) {
            pass = isWithinRange(test.value1, test.value2, this.gridTypeID);

        } else {
            pass = isWithinValues(this.gridTypeID, 0, myRuleTestValues.toArray());

        }

        if (test.isnot) {
            pass = !pass;
        }

        return pass;
    }
}

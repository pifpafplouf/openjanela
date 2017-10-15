/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/

package Operations;

import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import openjanela.model.entities.partner.SeriesValidOpeningShape;
import Model.ShapeObject;
import Model.ProfileParts.Bot1Object;
import Model.ProfileParts.Bot2Object;
import Model.ProfileParts.Bot3Object;
import Model.ProfileParts.LeftObject;
import Model.ProfileParts.Profiles;
import Model.ProfileParts.RightObject;
import Model.ProfileParts.Top1Object;
import Model.ProfileParts.Top2Object;
import Model.ProfileParts.Top3Object;
import Presentation.ItemFrame;

public class CreateShapeMethods {
	
	public ShapeObject myFacet = null;
	
	public double frameStartAngle = 0;
	
	public double frameEndAngle = 0;
	
	public double frameCentralAngle = 0;
	
	public int myfirstRowinColumnBelow = 1000;
	
	public int myfirstRowinColumnAbove = 0;
	
	public double myFrameWidth = 0;
	
	public double myFrameHeight = 0;
	
	public int orientation = 0;
	
	public int cNo = 0;
	
	public int myshape = 0;
	
	public double wt = 0; // actual
	
	public double hl = 0;
	
	public double wtc = 0; // Center
	
	public double hlc = 0;
	
	public double wb = 0; // actual
	
	public double hr = 0;
	
	public double wbc = 0; // Center
	
	public double hrc = 0;
	
	public int shape = 0;
	
	public int sequence = 0;
	
	public double startingX = 0;
	
	public double startingY = 0;
	
	public double startingXB = 0;
	
	public double startingYB = 0;
	
	public double startingXA = 0;
	
	public double startingYA = 0;
	
	public double startingXC = 0;
	
	public double startingYC = 0;
	
	public int startCol = 0;
	
	public int endCol = 0;
	
	public int startRow = 0;
	
	public int endRow = 0;
	
	public double bX1C = 0;
	
	public double bY1C = 0;
	
	public double bX2C = 0;
	
	public double bY2C = 0;
	
	public double bX3C = 0;
	
	public double bY3C = 0;
	
	public double bX4C = 0;
	
	public double bY4C = 0;
	
	public double bX1 = 0;
	
	public double bY1 = 0;
	
	public double bX2 = 0;
	
	public double bY2 = 0;
	
	public double bX3 = 0;
	
	public double bY3 = 0;
	
	public double bX4 = 0;
	
	public double bY4 = 0;
	
	public double t1t2X = 0;
	
	public double t1t2Y = 0;
	
	public double t1t3X = 0;
	
	public double t1t3Y = 0;
	
	public double t3t2X = 0;
	
	public double t3t2Y = 0;
	
	public double b1b2X = 0;
	
	public double b1b2Y = 0;
	
	public double b3b2XC = 0;
	
	public double b3b2YC = 0;
	
	public double b3b2X = 0;
	
	public double b3b2Y = 0;
	
	public double b1b3X = 0;
	
	public double b1b3Y = 0;
	
	public double bX1B = 0;
	
	public double bY1B = 0;
	
	public double bX2B = 0;
	
	public double bY2B = 0;
	
	public double bX3B = 0;
	
	public double bY3B = 0;
	
	public double bX4B = 0;
	
	public double bY4B = 0;
	
	public double t1t2XB = 0;
	
	public double t1t2YB = 0;
	
	public double t1t3XB = 0;
	
	public double t1t3YB = 0;
	
	public double t3t2XB = 0;
	
	public double t3t2YB = 0;
	
	public double b1b2XB = 0;
	
	public double b1b2YB = 0;
	
	public double b3b2XB = 0;
	
	public double b3b2YB = 0;
	
	public double b1b3XB = 0;
	
	public double b1b3YB = 0;
	
	public double bX1A = 0;
	
	public double bY1A = 0;
	
	public double bX2A = 0;
	
	public double bY2A = 0;
	
	public double bX3A = 0;
	
	public double bY3A = 0;
	
	public double bX4A = 0;
	
	public double bY4A = 0;
	
	public double t1t2XA = 0;
	
	public double t1t2YA = 0;
	
	public double t1t3XA = 0;
	
	public double t1t3YA = 0;
	
	public double t3t2XA = 0;
	
	public double t3t2YA = 0;
	
	public double b1b2XA = 0;
	
	public double b1b2YA = 0;
	
	public double b3b2XA = 0;
	
	public double b3b2YA = 0;
	
	public double b1b3XA = 0;
	
	public double b1b3YA = 0;
	
	public double t1t2XC = 0;
	
	public double t1t2YC = 0;
	
	public double t1t3XC = 0;
	
	public double t1t3YC = 0;
	
	public double t3t2XC = 0;
	
	public double t3t2YC = 0;
	
	public double b1b2XC = 0;
	
	public double b1b2YC = 0;
	
	public double b1b3XC = 0;
	
	public double b1b3YC = 0;
	
	public double centerPointX = 0;
	
	public double centerPointY = 0;
	
	public double centerPointX2 = 0;
	
	public double centerPointY2 = 0;
	
	public double radius1 = 0;
	
	public double radius2 = 0;
	
	public double startAngle = 0;
	
	public double endAngle = 0;
	
	public double bkgrdStartX = 0;
	
	public double bkgrdStartY = 0;
	
	public double centralAngle = 0;
	
	public double centerPointXs = 0;
	
	public double centerPointYs = 0;
	
	public double centerPointX2B = 0;
	
	public double centerPointY2B = 0;
	
	public double radius1s = 0;
	
	public double radius2s = 0;
	
	public double startAngles = 0;
	
	public double endAngles = 0;
	
	public double bkgrdStartXs = 0;
	
	public double bkgrdStartYs = 0;
	
	public double centralAngles = 0;
	
	public double startingCX = 0;
	
	public double startingCY = 0;
	
	public double bCX2 = 0;
	
	public double bCY2 = 0;
	
	public double bCX3 = 0;
	
	public double bCY3 = 0;
	
	public double bCX4 = 0;
	
	public double bCY4 = 0;
	
	public boolean topIn = false;
	
	public boolean botIn = false;
	
	public boolean rightIn = false;
	
	public boolean leftIn = false;
	
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
	
	public double px1B = 0;
	
	public double py1B = 0;
	
	public double px2B = 0;
	
	public double py2B = 0;
	
	public double px3B = 0;
	
	public double py3B = 0;
	
	public double px4B = 0;
	
	public double py4B = 0;
	
	public double px5B = 0;
	
	public double py5B = 0;
	
	public double px6B = 0;
	
	public double py6B = 0;
	
	public double px7B = 0;
	
	public double py7B = 0;
	
	public double px8B = 0;
	
	public double py8B = 0;
	
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
	
	double top1SXC = 0;
	
	double top1EXC = 0;
	
	double top1SX = 0;
	
	double top1EX = 0;
	
	double top1SXBA = 0;
	
	double top1EXBA = 0;
	
	double top1SXA = 0;
	
	double top1EXA = 0;
	
	double top2SXC = 0;
	
	double top2EXC = 0;
	
	double top2SX = 0;
	
	double top2EX = 0;
	
	double top2SXBA = 0;
	
	double top2EXBA = 0;
	
	double top2SXA = 0;
	
	double top2EXA = 0;
	
	double top3SXC = 0;
	
	double top3EXC = 0;
	
	double top3SX = 0;
	
	double top3EX = 0;
	
	double top3SXBA = 0;
	
	double top3EXBA = 0;
	
	double top3SXA = 0;
	
	double top3EXA = 0;
	
	double bot1SXC = 0;
	
	double bot1EXC = 0;
	
	double bot1SX = 0;
	
	double bot1EX = 0;
	
	double bot1SXBA = 0;
	
	double bot1EXBA = 0;
	
	double bot1SXA = 0;
	
	double bot1EXA = 0;
	
	double bot2SXC = 0;
	
	double bot2EXC = 0;
	
	double bot2SX = 0;
	
	double bot2EX = 0;
	
	double bot2SXBA = 0;
	
	double bot2EXBA = 0;
	
	double bot2SXA = 0;
	
	double bot2EXA = 0;
	
	double bot3SXC = 0;
	
	double bot3EXC = 0;
	
	double bot3SX = 0;
	
	double bot3EX = 0;
	
	double bot3SXBA = 0;
	
	double bot3EXBA = 0;
	
	double bot3SXA = 0;
	
	double bot3EXA = 0;
	
	double leftSXC = 0;
	
	double leftEXC = 0;
	
	double leftSX = 0;
	
	double leftEX = 0;
	
	double leftSXBA = 0;
	
	double leftEXBA = 0;
	
	double leftSXA = 0;
	
	double leftEXA = 0;
	
	double rightSXC = 0;
	
	double rightEXC = 0;
	
	double rightSX = 0;
	
	double rightEX = 0;
	
	double rightSXBA = 0;
	
	double rightEXBA = 0;
	
	double rightSXA = 0;
	
	double rightEXA = 0;
	
	double top1SYC = 0;
	
	double top1EYC = 0;
	
	double top1SY = 0;
	
	double top1EY = 0;
	
	double top1SYBA = 0;
	
	double top1EYBA = 0;
	
	double top1SYA = 0;
	
	double top1EYA = 0;
	
	double top2SYC = 0;
	
	double top2EYC = 0;
	
	double top2SY = 0;
	
	double top2EY = 0;
	
	double top2SYBA = 0;
	
	double top2EYBA = 0;
	
	double top2SYA = 0;
	
	double top2EYA = 0;
	
	double top3SYC = 0;
	
	double top3EYC = 0;
	
	double top3SY = 0;
	
	double top3EY = 0;
	
	double top3SYBA = 0;
	
	double top3EYBA = 0;
	
	double top3SYA = 0;
	
	double top3EYA = 0;
	
	double bot1SYC = 0;
	
	double bot1EYC = 0;
	
	double bot1SY = 0;
	
	double bot1EY = 0;
	
	double bot1SYBA = 0;
	
	double bot1EYBA = 0;
	
	double bot1SYA = 0;
	
	double bot1EYA = 0;
	
	double bot2SYC = 0;
	
	double bot2EYC = 0;
	
	double bot2SY = 0;
	
	double bot2EY = 0;
	
	double bot2SYBA = 0;
	
	double bot2EYBA = 0;
	
	double bot2SYA = 0;
	
	double bot2EYA = 0;
	
	double bot3SYC = 0;
	
	double bot3EYC = 0;
	
	double bot3SY = 0;
	
	double bot3EY = 0;
	
	double bot3SYBA = 0;
	
	double bot3EYBA = 0;
	
	double bot3SYA = 0;
	
	double bot3EYA = 0;
	
	double leftSYC = 0;
	
	double leftEYC = 0;
	
	double leftSY = 0;
	
	double leftEY = 0;
	
	double leftSYBA = 0;
	
	double leftEYBA = 0;
	
	double leftSYA = 0;
	
	double leftEYA = 0;
	
	double rightSYC = 0;
	
	double rightEYC = 0;
	
	double rightSY = 0;
	
	double rightEY = 0;
	
	double rightSYBA = 0;
	
	double rightEYBA = 0;
	
	double rightSYA = 0;
	
	double rightEYA = 0;
	
	public double myStartingXB = 0;
	
	public double myStartingYB = 0;
	
	public double myEndingXB = 0;
	
	public double myEndingYB = 0;
	
	public double myStartingXA = 0;
	
	public double myStartingYA = 0;
	
	public double myEndingXA = 0;
	
	public double myEndingYA = 0;
	
	public double myStartingXC = 0;
	
	public double myStartingYC = 0;
	
	public double myEndingXC = 0;
	
	public double myEndingYC = 0;
	
	public ShapeObject myParent;
	
	public double top1DimBo = 0;
	
	public double top1DimAo = 0;
	
	public double top1DimCo = 0;
	
	public double top1DimMo = 0;
	
	public double top2DimBo = 0;
	
	public double top2DimAo = 0;
	
	public double top2DimCo = 0;
	
	public double top2DimMo = 0;
	
	public double top3DimBo = 0;
	
	public double top3DimAo = 0;
	
	public double top3DimCo = 0;
	
	public double top3DimMo = 0;
	
	public double leftDimBo = 0;
	
	public double leftDimAo = 0;
	
	public double leftDimCo = 0;
	
	public double leftDimMo = 0;
	
	public double rightDimBo = 0;
	
	public double rightDimAo = 0;
	
	public double rightDimCo = 0;
	
	public double rightDimMo = 0;
	
	public double bot1DimBo = 0;
	
	public double bot1DimAo = 0;
	
	public double bot1DimCo = 0;
	
	public double bot1DimMo = 0;
	
	public double bot2DimBo = 0;
	
	public double bot2DimAo = 0;
	
	public double bot2DimCo = 0;
	
	public double bot2DimMo = 0;
	
	public double bot3DimBo = 0;
	
	public double bot3DimAo = 0;
	
	public double bot3DimCo = 0;
	
	public double bot3DimMo = 0;
	
	public double top1DimB = 0;
	
	public double top1DimA = 0;
	
	public double top1DimC = 0;
	
	public double top1DimM = 0;
	
	public double top2DimB = 0;
	
	public double top2DimA = 0;
	
	public double top2DimC = 0;
	
	public double top2DimM = 0;
	
	public double top3DimB = 0;
	
	public double top3DimA = 0;
	
	public double top3DimC = 0;
	
	public double top3DimM = 0;
	
	public double leftDimB = 0;
	
	public double leftDimA = 0;
	
	public double leftDimC = 0;
	
	public double leftDimM = 0;
	
	public double rightDimB = 0;
	
	public double rightDimA = 0;
	
	public double rightDimC = 0;
	
	public double rightDimM = 0;
	
	public double bot1DimB = 0;
	
	public double bot1DimA = 0;
	
	public double bot1DimC = 0;
	
	public double bot1DimM = 0;
	
	public double bot2DimB = 0;
	
	public double bot2DimA = 0;
	
	public double bot2DimC = 0;
	
	public double bot2DimM = 0;
	
	public double bot3DimB = 0;
	
	public double bot3DimA = 0;
	
	public double bot3DimC = 0;
	
	public double bot3DimM = 0;
	
	//
	
	Collection xCoordB = new ArrayList();
	
	Collection yCoordB = new ArrayList();
	
	Collection pCoordArc = new ArrayList();
	
	Collection pCoordLine = new ArrayList();
	
	Object[] xCoordBo = null;
	
	Object[] yCoordBo = null;
	
	Collection xCoordBL = new ArrayList();
	
	Collection yCoordBL = new ArrayList();
	
	Object[] xCoordBoL = null;
	
	Object[] yCoordBoL = null;
	
	double myX = 0;
	
	double myY = 0;
	
	double myXL = 0;
	
	double myYL = 0;
	
	boolean doStops = true;
	
	double top1Clearance = 0;
	
	double top2Clearance = 0;
	
	double top3Clearance = 0;
	
	double bot1Clearance = 0;
	
	double bot2Clearance = 0;
	
	double bot3Clearance = 0;
	
	double leftClearance = 0;
	
	double rightClearance = 0;
	
	double top1ClearanceB = 0;
	
	double top2ClearanceB = 0;
	
	double top3ClearanceB = 0;
	
	double bot1ClearanceB = 0;
	
	double bot2ClearanceB = 0;
	
	double bot3ClearanceB = 0;
	
	double leftClearanceB = 0;
	
	double rightClearanceB = 0;
	
	double top1ClearanceA = 0;
	
	double top2ClearanceA = 0;
	
	double top3ClearanceA = 0;
	
	double bot1ClearanceA = 0;
	
	double bot2ClearanceA = 0;
	
	double bot3ClearanceA = 0;
	
	double leftClearanceA = 0;
	
	double rightClearanceA = 0;
	
	boolean isNew = false;
	
	boolean isNewPart = true;
	
	int whichPos = 0;
	
	ItemFrame myFrame2;
	
	boolean leanChanged = false;
	
	/**
	 * Creating Shape Methods
	 * 
	 * @param myparent
	 *             , ShapeObject
	 * @param whichpos
	 *             , WhichPos
	 * @param myframe2
	 *             , ItemFrame
	 */
	
	public CreateShapeMethods(ShapeObject myparent, int whichpos, ItemFrame myframe2) {
	
		myParent = myparent;
		isNewPart = false;
		myFrame2 = myframe2;
		whichPos = whichpos;
		
		startingCX = myParent.startingCX;
		startingCY = myParent.startingCY;
		
		if (myParent.a_levelID == 1)
		{
			myFacet = myParent;
		}
		else
		{
			myFacet = myParent.myFacet;
		}
		
		px1c = myParent.px1c;
		py1c = myParent.py1c;
		px2c = myParent.px2c;
		py2c = myParent.py2c;
		px3c = myParent.px3c;
		py3c = myParent.py3c;
		px4c = myParent.px4c;
		py4c = myParent.py4c;
		px5c = myParent.px5c;
		py5c = myParent.py5c;
		px6c = myParent.px6c;
		py6c = myParent.py6c;
		px7c = myParent.px7c;
		py7c = myParent.py7c;
		px8c = myParent.px8c;
		py8c = myParent.py8c;
		
		bCX2 = myParent.bCX2;
		bCY2 = myParent.bCY2;
		bCX3 = myParent.bCX3;
		bCY3 = myParent.bCY3;
		bCX4 = myParent.bCX4;
		bCY4 = myParent.bCY4;
		
	}
	
	@SuppressWarnings("unchecked")
	public ShapeObject doShape(ShapeObject myShape, final int BorBA)
	{
	
		myShape.myFrame2 = myFrame2;
		
		if (BorBA == 1)
		{
			this.getClearance(myShape);
			myShape = this.doShapeBkgrd(myShape);
		}
		else if (BorBA == 2)
		{
			this.getClearanceBA(myShape);
			myShape = this.doShapeBkgrdBA(myShape);
		}
		else if (BorBA == 3)
		{
			this.getClearanceA(myShape);
		}
		
		this.getXYpointsMain(myShape);
		
		myShape = this.makeSides(myShape);
		
		myShape = this.doParts(myShape, true);
		
		myShape = this.setBaseInfo(myShape, BorBA, true);
		
		myShape.top1Part.myParent = myShape;
		myShape.top2Part.myParent = myShape;
		myShape.top3Part.myParent = myShape;
		myShape.bot1Part.myParent = myShape;
		myShape.bot2Part.myParent = myShape;
		myShape.bot3Part.myParent = myShape;
		myShape.leftPart.myParent = myShape;
		myShape.rightPart.myParent = myShape;
		
		myShape.partObjects.clear();
		myShape.partObjects.add(myShape.top1Part);
		myShape.partObjects.add(myShape.top2Part);
		myShape.partObjects.add(myShape.top3Part);
		myShape.partObjects.add(myShape.bot1Part);
		myShape.partObjects.add(myShape.bot2Part);
		myShape.partObjects.add(myShape.bot3Part);
		myShape.partObjects.add(myShape.leftPart);
		myShape.partObjects.add(myShape.rightPart);
		
		myShape.partObjects = this.doGPParts(myShape.partObjects, myShape, myShape.glazedOut);
		
		// myShape.top1 =
		// this.myTop1Clone(myShape.top1, myShape.top1Part);
		// myShape.top2 =
		// this.myTop2Clone(myShape.top2, myShape.top2Part);
		// myShape.top3 =
		// this.myTop3Clone(myShape.top3, myShape.top3Part);
		// myShape.bot1 =
		// this.myBot1Clone(myShape.bot1, myShape.bot1Part);
		// myShape.bot2 =
		// this.myBot2Clone(myShape.bot2, myShape.bot2Part);
		// myShape.bot3 =
		// this.myBot3Clone(myShape.bot3, myShape.bot3Part);
		//
		// myShape.left =
		// this.myLeftClone(myShape.left, myShape.leftPart);
		// myShape.right =
		// this.myRightClone(myShape.right, myShape.rightPart);
		
		myShape.top1 = (Top1Object) myShape.top1.cloneProfile(myShape.top1Part);
		myShape.top2 = (Top2Object) myShape.top2.cloneProfile(myShape.top2Part);
		myShape.top3 = (Top3Object) myShape.top3.cloneProfile(myShape.top3Part);
		
		myShape.bot1 = (Bot1Object) myShape.bot1.cloneProfile(myShape.bot1Part);
		myShape.bot2 = (Bot2Object) myShape.bot2.cloneProfile(myShape.bot2Part);
		myShape.bot3 = (Bot3Object) myShape.bot3.cloneProfile(myShape.bot3Part);
		
		myShape.left = (LeftObject) myShape.left.cloneProfile(myShape.leftPart);
		myShape.right = (RightObject) myShape.right.cloneProfile(myShape.rightPart);
		
		return myShape;
	}
	
	public void setOriginalDims(final ShapeObject myShape)
	{
	
		top1DimBo = myShape.top1Part.partDimB;
		top1DimAo = myShape.top1Part.partDimA;
		top1DimCo = myShape.top1Part.partDimC;
		top1DimMo = myShape.top1Part.partDimM;
		bot1DimBo = myShape.bot1Part.partDimB;
		bot1DimAo = myShape.bot1Part.partDimA;
		bot1DimCo = myShape.bot1Part.partDimC;
		bot1DimMo = myShape.bot1Part.partDimM;
		leftDimBo = myShape.leftPart.partDimB;
		leftDimAo = myShape.leftPart.partDimA;
		leftDimCo = myShape.leftPart.partDimC;
		leftDimMo = myShape.leftPart.partDimM;
		rightDimBo = myShape.rightPart.partDimB;
		rightDimAo = myShape.rightPart.partDimA;
		rightDimCo = myShape.rightPart.partDimC;
		rightDimMo = myShape.rightPart.partDimM;
		
	}
	
	public ShapeObject initCenters(final ShapeObject myShape)
	{
	
		myShape.startingCX = myParent.startingCX;
		myShape.startingCY = myParent.startingCY;
		
		myShape.px1c = myParent.px1c;
		myShape.py1c = myParent.py1c;
		myShape.px2c = myParent.px2c;
		myShape.py2c = myParent.py2c;
		myShape.px3c = myParent.px3c;
		myShape.py3c = myParent.py3c;
		myShape.px4c = myParent.px4c;
		myShape.py4c = myParent.py4c;
		myShape.px5c = myParent.px5c;
		myShape.py5c = myParent.py5c;
		myShape.px6c = myParent.px6c;
		myShape.py6c = myParent.py6c;
		myShape.px7c = myParent.px7c;
		myShape.py7c = myParent.py7c;
		myShape.px8c = myParent.px8c;
		myShape.py8c = myParent.py8c;
		
		myShape.bCX2 = myParent.bCX2;
		myShape.bCY2 = myParent.bCY2;
		myShape.bCX3 = myParent.bCX3;
		myShape.bCY3 = myParent.bCY3;
		myShape.bCX4 = myParent.bCX4;
		myShape.bCY4 = myParent.bCY4;
		
		return myShape;
	}
	
	public ShapeObject doShapeBkgrd(ShapeObject myShape)
	{
	
		this.initCenters(myShape);
		
		myShape = this.doShapeXYpoints(myShape);
		
		if (bY1 == 0)
		{
			bY1 = myShape.startingY;
			bY2 = myShape.bY2;
			bY3 = myShape.bY3;
			bY4 = myShape.bY4;
			bX1 = myShape.startingX;
			bX2 = myShape.bX2;
			bX3 = myShape.bX3;
			bX4 = myShape.bX4;
		}
		
		getXYpointsMain(myShape);
		
		myShape.lean = myParent.lean;
		myShape.lean2 = myParent.lean2;
		myShape.lean3 = myParent.lean3;
		myShape.lean4 = myParent.lean4;
		
		myShape.startingY = Math.min(bY1, bY2);
		myShape.startingX = Math.min(bX1, bX4);
		
		myShape.bkgrdStartX = myShape.startingCX;
		myShape.bkgrdStartY = myShape.startingCY;
		
		myShape.scaleM = myFrame2.metricscale;
		myShape.scaleImp = myFrame2.imperialscale;
		
		myShape.widthPix = wt = Math.max(myShape.bX2, myShape.bX3) - Math.min(myShape.startingX, myShape.bX4);
		
		myShape.highestY = myShape.highestY = Math.min(py1, Math.min(py2, Math.min(py3, py4)));
		
		myShape.lowestY = Math.max(py3, Math.max(py4, Math.max(py5, Math.max(py6, py7))));
		
		if (myParent.top1Part.partForm == 2)
		{
			
			myShape.highestY = myParent.top1Part.y1 - myParent.top1Part.radius1;
			
		}
		
		if (myShape.bot1Part.partForm == 2)
		{
			
			myShape.lowestY = myParent.bot1Part.y1 + myParent.bot1Part.radius1;
			
		}
		
		myShape.heightPix = hl = hr = myShape.lowestY - myShape.highestY;
		
		myShape.widthM = (int) (new BigDecimal(wt).divide(myFrame2.metricscale, 20, BigDecimal.ROUND_UP)).doubleValue();
		
		myShape.widthI = (int) (new BigDecimal(wt).divide(myFrame2.imperialscale, 10, BigDecimal.ROUND_UP)).doubleValue();
		
		myShape.heightM = (int) (new BigDecimal(myShape.heightPix).divide(myFrame2.metricscale, 10, BigDecimal.ROUND_UP))
					.doubleValue();
		
		myShape.heightI = (int) (new BigDecimal(myShape.heightPix).divide(myFrame2.imperialscale, 10, BigDecimal.ROUND_UP))
					.doubleValue();
		
		myShape.setOriginalDimsInit(wt, hl);
		
		if (myParent.noSidesTop > 1)
		{
			if (myParent.noSidesTop >= 2)
			{
				myShape.dimA1 = t1t2X - bX1;
				myShape.dimA2 = bX2 - t1t2X;
			}
			if (myParent.noSidesTop == 3)
			{
				myShape.dimA1 = t1t3X - bX1;
				myShape.dimA2 = bX2 - t3t2X;
				myShape.dimA3 = t3t2X - t1t3X;
			}
		}
		else
		{
			if (myShape.lean == 0)
			{
				myShape.dimA1 = 0;
				myShape.dimA2 = 0;
				myShape.dimA3 = 0;
				myShape.dimA0 = 0;
			}
			else if (myShape.lean == 2)
			{
				myShape.dimA2 = bX2 - bX1;
				myShape.dimA1 = Math.max(wt, wb) - myShape.dimA2;
			}
			else if (myShape.lean == 1)
			{
				myShape.dimA1 = bX2 - bX1;
				myShape.dimA2 = Math.max(wt, wb) - myShape.dimA1;
			}
			else if (myShape.lean == 3)
			{
				
				myShape.dimA0 = bX1 - bX4;
				myShape.dimA2 = bX3 - bX2;
				myShape.dimA1 = Math.max(wt, wb) - (myShape.dimA2 + myShape.dimA0);
			}
		}
		
		if (myShape.lean2 == 0)
		{
			myShape.dimB2 = 0;
			myShape.dimB1 = 0;
			myShape.dimB0 = 0;
		}
		else if (myShape.lean2 == 2)
		{
			myShape.dimB2 = bY3 - bY2;
			myShape.dimB1 = Math.max(hl, hr) - myShape.dimB2;
		}
		else if (myShape.lean2 == 1)
		{
			myShape.dimB1 = bY3 - bY2;
			myShape.dimB2 = Math.max(hl, hr) - myShape.dimB1;
		}
		else if (myShape.lean2 == 3)
		{
			myShape.dimB0 = bY2 - bY1;
			myShape.dimB1 = bY3 - bY2;
			myShape.dimB2 = Math.max(hl, hr) - (myShape.dimB1 + myShape.dimB0);
		}
		
		if (myParent.noSidesBot > 1)
		{
			if (myParent.noSidesBot == 2)
			{
				myShape.dimC1 = bX3 - b1b2X;
				myShape.dimC2 = b1b2X - bX4;
			}
			if (myParent.noSidesBot == 3)
			{
				myShape.dimC0 = myShape.dimC3 = bX3 - b1b3X;
				myShape.dimC1 = b1b3X - b3b2X;
				myShape.dimC2 = b3b2X - bX4;
			}
		}
		else
		{
			if (myShape.lean3 == 0)
			{
				myShape.dimC1 = 0;
				myShape.dimC2 = 0;
				myShape.dimC3 = 0;
				myShape.dimC0 = 0;
			}
			else if (myShape.lean3 == 2)
			{
				myShape.dimC2 = bX3 - bX4;
				myShape.dimC1 = Math.max(wt, wb) - myShape.dimC2;
			}
			else if (myShape.lean3 == 1)
			{
				myShape.dimC1 = bX3 - bX4;
				myShape.dimC2 = Math.max(wt, wb) - myShape.dimC1;
			}
			if (myShape.lean3 == 3)
			{
				myShape.dimC0 = bX2 - bX3;
				myShape.dimC2 = bX4 - bX1;
				myShape.dimC1 = Math.max(wt, wb) - (myShape.dimC2 + myShape.dimC0);
			}
		}
		
		myShape.dimD1 = bY4 - bY1;
		
		if (myShape.lean4 == 0)
		{
			myShape.dimD1 = 0;
			myShape.dimD2 = 0;
			myShape.dimD0 = 0;
		}
		if (myShape.lean4 == 1)
		{
			myShape.dimD1 = bY4 - bY1;
			myShape.dimD2 = Math.max(hl, hr) - myShape.dimD1;
		}
		if (myShape.lean4 == 2)
		{
			myShape.dimD2 = bY4 - bY1;
			myShape.dimD1 = Math.max(hl, hr) - myShape.dimD2;
		}
		if (myShape.lean4 == 3)
		{
			myShape.dimD0 = bY3 - bY4;
			myShape.dimD2 = bY2 - bY1;
			myShape.dimD1 = Math.max(hl, hr) - (myShape.dimD2 + myShape.dimD0);
		}
		
		if (myShape.top1Part.partForm > 1)
		{
			if (myShape.highestY < bY1)
			{
				myShape.dimD2 = bY1 - myShape.highestY;
			}
			if (myShape.highestY < bY2)
			{
				myShape.dimB1 = bY2 - myShape.highestY;
			}
		}
		if (myShape.bot1Part.partForm > 1)
		{
			if (myShape.lowestY > bY4)
			{
				if (myShape.dimD0 > 0)
				{
					myShape.dimD0 = myShape.lowestY - bY4;
				}
				else
				{
					myShape.dimD1 = myShape.lowestY - bY4;
				}
			}
			if (myShape.lowestY < bY2)
			{
				myShape.dimB2 = myShape.lowestY - bY2;
			}
			if (myShape.shapeID >= 800)
			{
				myShape.dimB2 = myShape.lowestY - bY2;
			}
		}
		
		if (myShape.shapeID >= 90 && myShape.shapeID < 100 || myShape.shapeID >= 700 && myShape.shapeID < 800)
		{
			
			ShapeLeanDisallow verifyDims = null;
			if (myShape.myFrame2 != null)
			{
				verifyDims = new ShapeLeanDisallow(myShape.shapeID, myShape.widthPix, myShape.heightPix, myShape.minLeg,
							myFrame2.currentUOM, myFrame2);
			}
			else if (myParent.myFrame2 != null)
			{
				verifyDims = new ShapeLeanDisallow(myShape.shapeID, myShape.widthPix, myShape.heightPix,
				
				myShape.minLeg, myFrame2.currentUOM, myFrame2);
			}
			myShape.lean = verifyDims.lean;
			myShape.lean2 = verifyDims.lean2;
			myShape.lean3 = verifyDims.lean3;
			myShape.lean4 = verifyDims.lean4;
			myShape.dimA1 = verifyDims.dimA1;
			myShape.dimA2 = verifyDims.dimA2;
			myShape.dimA3 = verifyDims.dimA3;
			myShape.dimA0 = verifyDims.dimA0;
			myShape.dimB1 = verifyDims.dimB1;
			myShape.dimB2 = verifyDims.dimB2;
			myShape.dimB0 = verifyDims.dimB0;
			myShape.dimC1 = verifyDims.dimC1;
			myShape.dimC2 = verifyDims.dimC2;
			myShape.dimC0 = verifyDims.dimC0;
			myShape.dimD1 = verifyDims.dimD1;
			myShape.dimD2 = verifyDims.dimD2;
			myShape.dimD0 = verifyDims.dimD0;
			
		}
		
		myShape.radius1 = myParent.radius1 + myShape.clearanceTop - top1DimC;
		myShape.radius2 = myParent.radius2 + myShape.clearanceTop - top1DimC;
		
		myShape.top1 = new Top1Object(myShape, true);
		myShape.top2 = new Top2Object(myShape, true);
		myShape.top3 = new Top3Object(myShape, true);
		myShape.bot1 = new Bot1Object(myShape, true);
		myShape.bot2 = new Bot2Object(myShape, true);
		myShape.bot3 = new Bot3Object(myShape, true);
		myShape.left = new LeftObject(myShape, true);
		myShape.right = new RightObject(myShape, true);
		
		if (!myShape.topIn && myShape.leftIn && myShape.rightIn)
		{
			myShape.right = new RightObject(myShape, true);
		}
		
		/** TODO Check logic for following lines */
		
		if (myParent.dimB1 > myParent.radius1)
		{
			myParent.dimB1 = myParent.radius1;
			
		}
		if (myParent.dimD2 > myParent.radius1)
		{
			myParent.dimD2 = myParent.radius1;
		}
		
		if (myParent.noSidesTop == 1 && myParent.top1Part.partForm >= 2 && myParent.dimB1 == myParent.radius1
					&& myParent.rightPart.posInUse && myParent.leftPart.posInUse)
		{
			
			if (!myShape.rightIn)
			{
				
				myShape.bY2 = myShape.bY2B = myShape.bY2A = bY2B = bY2A = bY2;
			}
			
		}
		
		if (myParent.noSidesTop == 1 && myParent.top1Part.partForm >= 2
		
		&& myParent.dimD2 == myParent.radius1 && myParent.rightPart.posInUse && myParent.leftPart.posInUse)
		{
			
			if (!myShape.leftIn)
			{
				myShape.startingY = myShape.startingYBA = myShape.startingYA = bY1B = bY1A = bY1;
			}
			
		}
		
		if (myParent.noSidesTop == 2 && myParent.top1Part.partForm >= 2 && myParent.top2Part.partForm >= 2
					&& myParent.rightPart.posInUse && myParent.leftPart.posInUse)
		{
			
			if (!myShape.rightIn)
			{
				
				myShape.bY2 = myShape.bY2B = myShape.bY2A = bY2B = bY2A = bY2;
			}
			
			if (!myShape.leftIn)
			{
				myShape.startingY = myShape.startingYBA = myShape.startingYA = bY1B = bY1A = bY1;
			}
			
		}
		
		if (myParent.noSidesTop == 2 && myParent.top1Part.partForm >= 2 && myParent.top2Part.partForm == 1
					&& myParent.leftPart.posInUse)
		{
			
			if (!myShape.leftIn)
			{
				
				myShape.startingY = myShape.startingYBA = myShape.startingYA = bY1B = bY1A = bY1;
				
			}
			
		}
		
		if (myParent.noSidesTop == 2 && myParent.top1Part.partForm == 1 && myParent.top2Part.partForm >= 2
					&& myParent.rightPart.posInUse)
		{
			
			if (!myShape.rightIn)
			{
				
				myShape.bY2 = myShape.bY2B = myShape.bY2A = bY2B = bY2A = bY2;
				
			}
			
		}
		if (myParent.noSidesTop == 3 && myParent.top1Part.partForm >= 2 && myParent.top2Part.partForm >= 2
					&& myParent.rightPart.posInUse && myParent.leftPart.posInUse)
		{
			if (!myShape.rightIn)
			{
				
				myShape.bY2 = myShape.bY2B = myShape.bY2A = bY2B = bY2A = bY2;
			}
			
			if (!myShape.leftIn)
			{
				myShape.startingY = myShape.startingYBA = myShape.startingYA = bY1B = bY1A = bY1;
			}
		}
		
		if (myParent.myMullionTop != null && myShape.topIn)
		{
			myShape.myMullionTop = myParent.myMullionTop;
		}
		if (myParent.myMullionBot != null && myShape.botIn)
		{
			myShape.myMullionBot = myParent.myMullionBot;
		}
		if (myParent.myMullionLeft != null && myShape.leftIn)
		{
			myShape.myMullionLeft = myParent.myMullionLeft;
		}
		if (myParent.myMullionRight != null && myShape.rightIn)
		{
			myShape.myMullionRight = myParent.myMullionRight;
		}
		
		myShape.highestYC = myShape.highestY;
		
		if (myParent.highestYC == 0 && !myShape.topIn)
		{
			myShape.highestYC = myShape.highestY;
		}
		
		if (myShape.highestY < myShape.highestYC)
		{
			myShape.highestYC = myShape.highestY;
		}
		
		if (myShape.top1Part.partDimC > 0)
		{
			
			myShape.highestYC = myShape.highestY - this.top1DimC;
			
		}
		
		if (myShape.bot1Part.partDimC > 0)
		{
			
			myShape.lowestYC = myShape.lowestY + this.bot1DimC;
			
		}
		
		if (myShape.bot3Part.posInUse)
		{
			
			myShape.lowestYC = myShape.lowestY + this.bot3DimC;
		}
		
		checkSidesInOut(myShape);
		
		return myShape;
	}
	
	public void checkSidesInOut(ShapeObject myShape)
	{
	
		if (myShape.topIn && myShape.myMullionTop != null)
		{
			myShape.highestYC = myShape.highestY - (myShape.highestY - myShape.myMullionTop.centerYs);
			
		}
		
		if (myShape.botIn && myShape.myMullionBot != null)
		{
			myShape.lowestYC = myShape.lowestY + myShape.myMullionBot.centerYs - myShape.lowestY;
			
		}
		
		if (myShape.leftIn && myShape.myMullionLeft != null)
		{
			
			myShape.startingCX = this.intersectX(myShape.startingCX, myShape.startingCY, myShape.bCX2, myShape.bCY2,
						myShape.myMullionLeft.centerXs, myShape.myMullionLeft.centerYs, myShape.myMullionLeft.centerXe,
						myShape.myMullionLeft.centerYe);
			
			myShape.bCX4 = this.intersectX(myShape.bCX4, myShape.bCY4, myShape.bCX3, myShape.bCY3,
						myShape.myMullionLeft.centerXs, myShape.myMullionLeft.centerYs, myShape.myMullionLeft.centerXe,
						myShape.myMullionLeft.centerYe);
			
		}
		if (myShape.rightIn && myShape.myMullionRight != null)
		{
			
			myShape.bCX2 = this.intersectX(myShape.startingCX, myShape.startingCY, myShape.bCX2, myShape.bCY2,
						myShape.myMullionRight.centerXs, myShape.myMullionRight.centerYs, myShape.myMullionRight.centerXe,
						myShape.myMullionRight.centerYe);
			
			myShape.bCX3 = this.intersectX(myShape.bCX4, myShape.bCY4, myShape.bCX3, myShape.bCY3,
						myShape.myMullionRight.centerXs, myShape.myMullionRight.centerYs, myShape.myMullionRight.centerXe,
						myShape.myMullionRight.centerYe);
			
		}
	}
	
	public ShapeObject doShapeXYpoints(ShapeObject myShape)
	{
	
		if (myParent.noSides == 2 && myParent.shapeID < 800)
		{
			myShape.startingCX = bX1C = myParent.bot1Part.endX + myShape.clearanceTop - top1DimCo;
			myShape.startingX = bX1 = myParent.bot1Part.endX + myShape.clearanceTop;
			bX1B = bX1 + top1DimBo;
			bX1A = bX1B + top1DimAo;
			
			myShape.startingCY = bY1C = myParent.bot1Part.endY - myShape.clearanceBot + bot1DimCo;
			myShape.startingY = bY1 = myParent.bot1Part.endY - myShape.clearanceBot;
			bY1B = bY1 - bot1DimBo;
			bY1A = bY1B - bot1DimAo;
			
			myShape.bCX2 = bX2C = myParent.bot1Part.startX - myShape.clearanceTop + top1DimCo;
			myShape.bX2 = bX2 = myParent.bot1Part.startX - myShape.clearanceTop;
			myShape.bX2B = bX2B = bX2 - top1DimBo;
			myShape.bX2A = bX2A = bX2B - top1DimAo;
			
			myShape.bCY2 = bY2C = myParent.bot1Part.startY - myShape.clearanceBot + bot1DimCo;
			myShape.bY2 = bY2 = myParent.bot1Part.startY - myShape.clearanceBot;
			myShape.bY2B = bY2B = bY2 - bot1DimBo;
			myShape.bY2A = bY2A = bY2B - bot1DimAo;
			
			myShape.bCX4 = bX4C = myShape.startingCX;
			myShape.bX4 = bX4 = myShape.startingX;
			myShape.bX4B = bX4B = bX1B;
			myShape.bX4A = bX4A = bX1A;
			
			myShape.bCY4 = bY4C = myShape.startingCY;
			myShape.bY4 = bY4 = myShape.startingY;
			myShape.bY4B = bY4B = bY1B;
			myShape.bY4A = bY4A = bY1A;
			
			myShape.bCX3 = bX3C = myShape.bCX2;
			myShape.bX3 = bX3 = myShape.bX2;
			myShape.bX3B = bX3B = myShape.bX2B;
			myShape.bX3A = bX3A = myShape.bX2A;
			
			myShape.bCY3 = bY3C = myShape.bCY2;
			myShape.bY3 = bY3 = myShape.bY2;
			myShape.bY3B = bY3B = bY2B;
			myShape.bY3A = bY3A = bY2A;
			
		}
		else if (myParent.noSides == 2 && myParent.shapeID >= 800)
		{
			myShape.startingCX = bX1C = myShape.bCX4 = bX4C = myParent.top1Part.startX + myShape.clearanceTop - top1DimCo;
			myShape.startingX = bX1 = myShape.bX4 = bX4 = myParent.top1Part.startX + myShape.clearanceTop;
			bX1B = bX4B = bX1 + top1DimBo;
			bX1A = bX4A = bX1B + top1DimAo;
			
			myShape.startingCY = bY1C = myShape.bCY4 = bY4C = myParent.top1Part.startY + myShape.clearanceTop - top1DimCo;
			myShape.startingY = bY1 = myShape.bY4 = bY4 = myParent.top1Part.startY + myShape.clearanceTop;
			bY1B = bY4B = bY1 - bot1DimBo;
			bY1A = bY4A = bY1B - bot1DimAo;
			
			myShape.bCX2 = bX2C = myShape.bCX3 = bX3C = myParent.top1Part.endX - myShape.clearanceTop + top1DimCo;
			myShape.bX2 = bX2 = myShape.bX3 = bX3 = myParent.top1Part.endX - myShape.clearanceTop;
			myShape.bX2B = bX2B = myShape.bX3B = bX3B = bX2 - top1DimBo;
			myShape.bX2A = bX2A = myShape.bX3A = bX3A = bX2B - top1DimAo;
			
			myShape.bCY2 = bY2C = myShape.bCY3 = bY3C = myParent.top1Part.endY - myShape.clearanceTop + top1DimCo;
			myShape.bY2 = bY2 = myShape.bY3 = bY3 = myParent.top1Part.endY - myShape.clearanceTop;
			myShape.bY2B = bY2B = myShape.bY3B = bY3B = bY2 - top1DimBo;
			myShape.bY2A = bY2A = myShape.bY3A = bY3A = bY2B - top1DimAo;
			
			myShape.lowestY = myParent.lowestY + myShape.clearanceBot;
			
			myShape.highestY = myParent.highestY - myShape.clearanceTop;
			
		}
		else if (myParent.noSides == 3 && myParent.noSidesRight == 1 && myParent.top1Part.partForm > 1)
		{
			
			myShape.startingCX = bX1C = myParent.bot1Part.endX + myShape.clearanceTop - top1DimCo;
			myShape.startingX = bX1 = myParent.bot1Part.endX + myShape.clearanceTop;
			bX1B = bX1 + top1DimBo;
			bX1A = bX1B + top1DimAo;
			
			myShape.startingCY = bY1C = myParent.bot1Part.endY - myShape.clearanceBot + bot1DimCo;
			myShape.startingY = bY1 = myParent.bot1Part.endY - myShape.clearanceBot;
			bY1B = bY1 - bot1DimBo;
			bY1A = bY1B - bot1DimAo;
			
			myShape.bCX2 = bX2C = myParent.rightPart.startX - myShape.clearanceRight + rightDimCo;
			myShape.bX2 = bX2 = myParent.rightPart.startX - myShape.clearanceRight;
			myShape.bX2B = bX2B = bX2 - rightDimBo;
			myShape.bX2A = bX2A = bX2B - rightDimAo;
			
			myShape.bCY2 = bY2C = myParent.top1Part.endY - myShape.clearanceTop + top1DimCo;
			myShape.bY2 = bY2 = myParent.top1Part.endY - myShape.clearanceTop;
			myShape.bY2B = bY2B = bY2 - top1DimBo;
			myShape.bY2A = bY2A = bY2B - top1DimAo;
			
			myShape.bCX3 = bX3C = myParent.rightPart.endX - myShape.clearanceRight + rightDimCo;
			myShape.bX3 = bX3 = myParent.rightPart.endX - myShape.clearanceRight;
			myShape.bX3B = bX3B = bX3 - rightDimBo;
			myShape.bX3A = bX3A = bX2B - rightDimAo;
			
			myShape.bCY3 = bY3C = myParent.bot1Part.startY - myShape.clearanceBot + bot1DimCo;
			myShape.bY3 = bY3 = myParent.bot1Part.startY - myShape.clearanceBot;
			myShape.bY3B = bY3B = bY3 - bot1DimBo;
			myShape.bY3A = bY3A = bY3B - bot1DimAo;
			
			myShape.bCX4 = bX4C = myParent.bot1Part.endX + myShape.clearanceTop - top1DimCo;
			myShape.bX4 = bX4 = myParent.bot1Part.endX + myShape.clearanceTop;
			myShape.bX4B = bX4B = bX4 + top1DimBo;
			myShape.bX4A = bX4A = bX4B + top1DimAo;
			
			myShape.bCY4 = bY4C = myParent.bot1Part.endY - myShape.clearanceBot + bot1DimCo;
			myShape.bY4 = bY4 = myParent.bot1Part.endY - myShape.clearanceBot;
			myShape.bY4B = bY4B = bY4 - bot1DimBo;
			myShape.bY4A = bY4A = bY4B - bot1DimAo;
			
		}
		else if (myParent.noSides == 3 && myParent.noSidesLeft == 1 && myParent.top1Part.partForm > 1)
		{
			
			myShape.startingCX = bX1C = myParent.leftPart.endX + myShape.clearanceLeft - leftDimCo;
			myShape.startingX = bX1 = myParent.leftPart.endX + myShape.clearanceLeft;
			bX1B = bX1 + leftDimBo;
			bX1A = bX1B + leftDimAo;
			
			myShape.startingCY = bY1C = myParent.top1Part.startY + myShape.clearanceTop - top1DimCo;
			myShape.startingY = bY1 = myParent.top1Part.startY + myShape.clearanceTop;
			bY1B = bY1 + top1DimBo;
			bY1A = bY1B + top1DimAo;
			
			myShape.bCX2 = bX2C = myParent.top1Part.endX + myShape.clearanceTop - top1DimCo;
			myShape.bX2 = bX2 = myParent.top1Part.endX + myShape.clearanceTop;
			myShape.bX2B = bX2B = bX2 + top1DimBo;
			myShape.bX2A = bX2A = bX2B + top1DimAo;
			
			myShape.bCY2 = bY2C = myParent.bot1Part.startY - myShape.clearanceBot + bot1DimCo;
			myShape.bY2 = bY2 = myParent.bot1Part.startY - myShape.clearanceBot;
			myShape.bY2B = bY2B = bY2 - bot1DimBo;
			myShape.bY2A = bY2A = bY2B - bot1DimAo;
			
			myShape.bCX3 = bX3C = myParent.top1Part.endX + myShape.clearanceTop - top1DimCo;
			myShape.bX3 = bX3 = myParent.top1Part.endX + myShape.clearanceTop;
			myShape.bX3B = bX3B = bX3 + top1DimBo;
			myShape.bX3A = bX3A = bX3B + top1DimAo;
			
			myShape.bCY3 = bY3C = myParent.bot1Part.startY - myShape.clearanceBot + bot1DimCo;
			myShape.bY3 = bY3 = myParent.bot1Part.startY - myShape.clearanceBot;
			myShape.bY3B = bY3B = bY3 - bot1DimBo;
			myShape.bY3A = bY3A = bY3B - bot1DimAo;
			
			myShape.bCX4 = bX4C = myParent.leftPart.startX + myShape.clearanceLeft - leftDimCo;
			myShape.bX4 = bX4 = myParent.leftPart.startX + myShape.clearanceLeft;
			myShape.bX4B = bX4B = bX4 + leftDimBo;
			myShape.bX4A = bX4A = bX4B + leftDimAo;
			
			myShape.bCY4 = bY4C = myParent.bot1Part.endY - myShape.clearanceBot + bot1DimCo;
			myShape.bY4 = bY4 = myParent.bot1Part.endY - myShape.clearanceBot;
			myShape.bY4B = bY4B = bY4 - bot1DimBo;
			myShape.bY4A = bY4A = bY4B - bot1DimAo;
			
		}
		else
		{
			if (myParent.noSidesLeft > 0)
			{
				
				myShape.startingCX = bX1C = this.intersectX(myParent.top1Part.startX, myParent.top1Part.startY
							+ top1Clearance - top1DimC, myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance
							- top1DimC, myParent.leftPart.startX + leftClearance - leftDimC, myParent.leftPart.startY,
							myParent.leftPart.endX + leftClearance - leftDimC, myParent.leftPart.endY);
				
				myShape.startingX = bX1 = this.intersectX(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance,
							myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance, myParent.leftPart.startX
										+ leftClearance, myParent.leftPart.startY, myParent.leftPart.endX
										+ leftClearance, myParent.leftPart.endY);
				
				bX1B = this.intersectX(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance + top1DimB,
							myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance + top1DimB,
							myParent.leftPart.startX + leftClearance + leftDimB, myParent.leftPart.startY,
							myParent.leftPart.endX + leftClearance + leftDimB, myParent.leftPart.endY);
				
				bX1A = this.intersectX(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance + top1DimB
							+ top1DimA, myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance + top1DimB
							+ top1DimA, myParent.leftPart.startX + leftClearance + leftDimB + leftDimA,
							myParent.leftPart.startY, myParent.leftPart.endX + leftClearance + leftDimB + leftDimA,
							myParent.leftPart.endY);
				
				myShape.startingCY = bY1C = this.intersectY(myParent.top1Part.startX, myParent.top1Part.startY
							+ top1Clearance - top1DimC, myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance
							- top1DimC, myParent.leftPart.startX + leftClearance - leftDimC, myParent.leftPart.startY,
							myParent.leftPart.endX + leftClearance - leftDimC, myParent.leftPart.endY);
				
				myShape.startingY = bY1 = this.intersectY(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance,
							myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance, myParent.leftPart.startX
										+ leftClearance, myParent.leftPart.startY, myParent.leftPart.endX
										+ leftClearance, myParent.leftPart.endY);
				
				bY1B = this.intersectY(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance + top1DimB,
							myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance + top1DimB,
							myParent.leftPart.startX + leftClearance + leftDimB, myParent.leftPart.startY,
							myParent.leftPart.endX + leftClearance + leftDimB, myParent.leftPart.endY);
				
				bY1A = this.intersectY(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance + top1DimB
							+ top1DimA, myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance + top1DimB
							+ top1DimA, myParent.leftPart.startX + leftClearance + leftDimB + top1DimA,
							myParent.leftPart.startY, myParent.leftPart.endX + leftClearance + leftDimB + top1DimA,
							myParent.leftPart.endY);
				
				if (myParent.noSidesTop >= 2 && myParent.top1Part.partForm >= 2)
				{
					bY1B = bY1A = bY1;
				}
				
			}
			else if (myParent.noSidesBot == 1)
			{
				
				myShape.startingCX = bX1C = this.intersectX(myParent.top1Part.startX, myParent.top1Part.startY
							+ top1Clearance - top1DimC, myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance
							- top1DimC, myParent.bot1Part.startX, myParent.bot1Part.startY - bot1Clearance + bot1DimC,
							myParent.bot1Part.endX, myParent.bot1Part.endY - bot1Clearance + bot1DimC);
				
				myShape.startingCY = bY1C = this.intersectY(myParent.top1Part.startX, myParent.top1Part.startY
							+ top1Clearance - top1DimC, myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance
							- top1DimC, myParent.bot1Part.startX, myParent.bot1Part.startY - bot1Clearance + bot1DimC,
							myParent.bot1Part.endX, myParent.bot1Part.endY - bot1Clearance + bot1DimC);
				
				myShape.startingX = bX1 = this.intersectX(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance,
							myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance, myParent.bot1Part.startX,
							myParent.bot1Part.startY - bot1Clearance, myParent.bot1Part.endX, myParent.bot1Part.endY
										- bot1Clearance);
				
				myShape.startingY = bY1 = this.intersectY(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance,
							myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance, myParent.bot1Part.startX,
							myParent.bot1Part.startY - bot1Clearance, myParent.bot1Part.endX, myParent.bot1Part.endY
										- bot1Clearance);
				
				bX1B = this.intersectX(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance + top1DimB,
							myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance + top1DimB,
							myParent.bot1Part.startX, myParent.bot1Part.startY - bot1Clearance - bot1DimB,
							myParent.bot1Part.endX, myParent.bot1Part.endY - bot1Clearance - bot1DimB);
				
				bY1B = this.intersectY(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance + top1DimB,
							myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance + top1DimB,
							myParent.bot1Part.startX, myParent.bot1Part.startY - bot1Clearance - bot1DimB,
							myParent.bot1Part.endX, myParent.bot1Part.endY - bot1Clearance - bot1DimB);
				
				bX1B = this.intersectX(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance + top1DimB
							+ top1DimA, myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance + top1DimB
							+ top1DimA, myParent.bot1Part.startX, myParent.bot1Part.startY - bot1Clearance - bot1DimB
							- bot1DimA, myParent.bot1Part.endX, myParent.bot1Part.endY - bot1Clearance - bot1DimB
							- bot1DimA);
				
				bY1B = this.intersectY(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance + top1DimB
							+ top1DimA, myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance + top1DimB
							+ top1DimA, myParent.bot1Part.startX, myParent.bot1Part.startY - bot1Clearance - bot1DimB
							- bot1DimA, myParent.bot1Part.endX, myParent.bot1Part.endY - bot1Clearance - bot1DimB
							- bot1DimA);
				
			}
			else if (myParent.noSidesBot > 1)
			{
				
				myShape.startingCX = bX1C = this.intersectX(myParent.top1Part.startX, myParent.top1Part.startY
							+ top1Clearance - top1DimC, myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance
							- top1DimC, myParent.bot2Part.startX, myParent.bot2Part.startY - bot2Clearance + bot2DimC,
							myParent.bot2Part.endX, myParent.bot2Part.endY - bot2Clearance + bot2DimC);
				
				myShape.startingCY = bY1C = this.intersectY(myParent.top1Part.startX, myParent.top1Part.startY
							+ top1Clearance - top1DimC, myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance
							- top1DimC, myParent.bot2Part.startX, myParent.bot2Part.startY - bot2Clearance + bot2DimC,
							myParent.bot2Part.endX, myParent.bot2Part.endY - bot2Clearance + bot2DimC);
				
				myShape.startingX = bX1 = this.intersectX(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance,
							myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance, myParent.bot2Part.startX,
							myParent.bot2Part.startY - bot2Clearance, myParent.bot2Part.endX, myParent.bot2Part.endY
										- bot2Clearance);
				
				myShape.startingY = bY1 = this.intersectY(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance,
							myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance, myParent.bot2Part.startX,
							myParent.bot2Part.startY - bot2Clearance, myParent.bot2Part.endX, myParent.bot2Part.endY
										- bot2Clearance);
				
				bX1B = this.intersectX(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance + top1DimB,
							myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance + top1DimB,
							myParent.bot2Part.startX, myParent.bot2Part.startY - bot2Clearance - bot2DimB,
							myParent.bot2Part.endX, myParent.bot2Part.endY - bot2Clearance - bot2DimB);
				
				bY1B = this.intersectY(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance + top1DimB,
							myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance + top1DimB,
							myParent.bot2Part.startX, myParent.bot2Part.startY - bot2Clearance - bot2DimB,
							myParent.bot2Part.endX, myParent.bot2Part.endY - bot2Clearance - bot2DimB);
				
				bX1B = this.intersectX(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance + top1DimB
							+ top1DimA, myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance + top1DimB
							+ top1DimA, myParent.bot2Part.startX, myParent.bot2Part.startY - bot2Clearance - bot2DimB
							- bot2DimA, myParent.bot2Part.endX, myParent.bot2Part.endY - bot2Clearance - bot2DimB
							- bot2DimA);
				
				bY1B = this.intersectY(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance + top1DimB
							+ top1DimA, myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance + top1DimB
							+ top1DimA, myParent.bot2Part.startX, myParent.bot2Part.startY - bot2Clearance - bot2DimB
							- bot2DimA, myParent.bot2Part.endX, myParent.bot2Part.endY - bot2Clearance - bot2DimB
							- bot2DimA);
				
			}
			
			// //////// X2,Y2
			if (myParent.noSidesTop == 1)
			{
				if (myParent.noSidesRight > 0)
				{
					
					myShape.bCX2 = bX2C = this.intersectX(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance
								- top1DimC, myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance - top1DimC,
								myParent.rightPart.startX - rightClearance + rightDimC, myParent.rightPart.startY,
								myParent.rightPart.endX - rightClearance + rightDimC, myParent.rightPart.endY);
					
					myShape.bCY2 = bY2C = this.intersectY(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance
								- top1DimC, myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance - top1DimC,
								myParent.rightPart.startX - rightClearance + rightDimC, myParent.rightPart.startY,
								myParent.rightPart.endX - rightClearance + rightDimC, myParent.rightPart.endY);
					
					myShape.bX2 = bX2 = this.intersectX(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance,
								myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance, myParent.rightPart.startX
											- rightClearance, myParent.rightPart.startY, myParent.rightPart.endX
											- rightClearance, myParent.rightPart.endY);
					
					myShape.bY2 = bY2 = this.intersectY(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance,
								myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance, myParent.rightPart.startX
											- rightClearance, myParent.rightPart.startY, myParent.rightPart.endX
											- rightClearance, myParent.rightPart.endY);
					
					myShape.bX2B = bX2B = this.intersectX(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance
								+ top1DimB, myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance + top1DimB,
								myParent.rightPart.startX - rightClearance - rightDimB, myParent.rightPart.startY,
								myParent.rightPart.endX - rightClearance - rightDimB, myParent.rightPart.endY);
					
					myShape.bY2B = bY2B = this.intersectY(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance
								+ top1DimB, myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance + top1DimB,
								myParent.rightPart.startX - rightClearance - rightDimB, myParent.rightPart.startY,
								myParent.rightPart.endX - rightClearance - rightDimB, myParent.rightPart.endY);
					
					myShape.bX2A = bX2A = this.intersectX(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance
								+ top1DimB + top1DimA, myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance
								+ top1DimB + top1DimA,
								myParent.rightPart.startX - rightClearance - rightDimB - rightDimA,
								myParent.rightPart.startY, myParent.rightPart.endX - rightClearance - rightDimB
											- rightDimA, myParent.rightPart.endY);
					
					myShape.bY2A = bY2A = this.intersectY(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance
								+ top1DimB + top1DimA, myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance
								+ top1DimB + top1DimA,
								myParent.rightPart.startX - rightClearance - rightDimB - rightDimA,
								myParent.rightPart.startY, myParent.rightPart.endX - rightClearance - rightDimB
											- rightDimA, myParent.rightPart.endY);
					
				}
				else
				{
					if (myParent.noSidesBot <= 3) // Control Whare Bot3 is
											// Here!!!!
					{
						
						myShape.bCX2 = bX2C = this.intersectX(myParent.top1Part.startX, myParent.top1Part.startY
									+ top1Clearance - top1DimC, myParent.top1Part.endX, myParent.top1Part.endY
									+ top1Clearance - top1DimC, myParent.bot1Part.startX, myParent.bot1Part.startY
									- bot1Clearance + bot1DimC, myParent.bot1Part.endX, myParent.bot1Part.endY
									- bot1Clearance + bot1DimC);
						
						myShape.bCY2 = bY2C = this.intersectY(myParent.top1Part.startX, myParent.top1Part.startY
									+ top1Clearance - top1DimC, myParent.top1Part.endX, myParent.top1Part.endY
									+ top1Clearance - top1DimC, myParent.bot1Part.startX, myParent.bot1Part.startY
									- bot1Clearance + bot1DimC, myParent.bot1Part.endX, myParent.bot1Part.endY
									- bot1Clearance + bot1DimC);
						
						myShape.bX2 = bX2 = this.intersectX(myParent.top1Part.startX, myParent.top1Part.startY
									+ top1Clearance, myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance,
									myParent.bot1Part.startX, myParent.bot1Part.startY - bot1Clearance,
									myParent.bot1Part.endX, myParent.bot1Part.endY - bot1Clearance);
						
						myShape.bY2 = bY2 = this.intersectY(myParent.top1Part.startX, myParent.top1Part.startY
									+ top1Clearance, myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance,
									myParent.bot1Part.startX, myParent.bot1Part.startY - bot1Clearance,
									myParent.bot1Part.endX, myParent.bot1Part.endY - bot1Clearance);
						
						myShape.bX2B = bX2B = this.intersectX(myParent.top1Part.startX, myParent.top1Part.startY
									+ top1Clearance + top1DimB, myParent.top1Part.endX, myParent.top1Part.endY
									+ top1Clearance + top1DimB, myParent.bot1Part.startX - bot1Clearance - bot1DimB,
									myParent.bot1Part.startY, myParent.bot1Part.endX - bot1Clearance - bot1DimB,
									myParent.bot1Part.endY);
						
						myShape.bY2B = bY2B = this.intersectY(myParent.top1Part.startX, myParent.top1Part.startY
									+ top1Clearance + top1DimB, myParent.top1Part.endX, myParent.top1Part.endY
									+ top1Clearance + top1DimB, myParent.bot1Part.startX - bot1Clearance - bot1DimB,
									myParent.bot1Part.startY, myParent.bot1Part.endX - bot1Clearance - bot1DimB,
									myParent.bot1Part.endY);
						
						myShape.bX2A = bX2A = this.intersectX(myParent.top1Part.startX, myParent.top1Part.startY
									+ top1Clearance + top1DimB + top1DimA, myParent.top1Part.endX,
									myParent.top1Part.endY + top1Clearance + top1DimB + top1DimA,
									myParent.bot1Part.startX - bot1Clearance - bot1DimB - bot1DimA,
									myParent.bot1Part.startY, myParent.bot1Part.endX - bot1Clearance - bot1DimB
												- bot1DimA, myParent.bot1Part.endY);
						
						myShape.bY2A = bY2A = this.intersectY(myParent.top1Part.startX, myParent.top1Part.startY
									+ top1Clearance + top1DimB + top1DimA, myParent.top1Part.endX,
									myParent.top1Part.endY + top1Clearance + top1DimB + top1DimA,
									myParent.bot1Part.startX - bot1Clearance - bot1DimB - bot1DimA,
									myParent.bot1Part.startY, myParent.bot1Part.endX - bot1Clearance - bot1DimB
												- bot1DimA, myParent.bot1Part.endY);
						
					}
					
				}
				
			}
			if (myParent.noSidesTop > 1)
			{
				double t2sxC = myParent.top2Part.startX;
				double t2exC = myParent.top2Part.endX;
				double t2syC = myParent.top2Part.startY + top2Clearance - top2DimC;
				double t2eyC = myParent.top2Part.endY + top2Clearance - top2DimC;
				
				double t2sx = myParent.top2Part.startX;
				double t2ex = myParent.top2Part.endX;
				double t2sy = myParent.top2Part.startY + top2Clearance;
				double t2ey = myParent.top2Part.endY + top2Clearance;
				
				double t2sxB = t2sx;
				double t2exB = t2ex;
				double t2syB = t2sy + top2DimB;
				double t2eyB = t2ey + top2DimB;
				
				double t2sxA = t2sxB;
				double t2exA = t2exB;
				double t2syA = t2syB + top2DimA;
				double t2eyA = t2eyB + top2DimA;
				
				if (myParent.top2Part.startY < myParent.top2Part.endY)
				{
					t2sxC = myParent.top2Part.startX - top2Clearance + top2DimC;
					t2exC = myParent.top2Part.endX - top2Clearance + top2DimC;
					t2syC = myParent.top2Part.startY;
					t2eyC = myParent.top2Part.endY;
					
					t2sx = myParent.top2Part.startX - top2Clearance;
					t2ex = myParent.top2Part.endX - top2Clearance;
					t2sy = myParent.top2Part.startY;
					t2ey = myParent.top2Part.endY;
					
					t2sxB = t2sx - top2DimB;
					t2exB = t2ex - top2DimB;
					t2syB = t2sy;
					t2eyB = t2ey;
					
					t2sxA = t2sxB - top2DimA;
					t2exA = t2exB - top2DimA;
					t2syA = t2syB;
					t2eyA = t2eyB;
					
				}
				
				if (myParent.noSidesRight > 0)
				{
					
					myShape.bCX2 = bX2C = this.intersectX(t2sxC, t2syC, t2exC, t2eyC, myParent.rightPart.startX
								- rightClearance + rightDimC, myParent.rightPart.startY, myParent.rightPart.endX
								- rightClearance + rightDimC, myParent.rightPart.endY);
					
					myShape.bCY2 = bY2C = this.intersectY(t2sxC, t2syC, t2exC, t2eyC, myParent.rightPart.startX
								- rightClearance + rightDimC, myParent.rightPart.startY, myParent.rightPart.endX
								- rightClearance + rightDimC, myParent.rightPart.endY);
					
					myShape.bX2 = bX2 = this.intersectX(t2sx, t2sy, t2ex, t2ey, myParent.rightPart.startX - rightClearance,
								myParent.rightPart.startY, myParent.rightPart.endX - rightClearance,
								myParent.rightPart.endY);
					
					myShape.bY2 = bY2 = this.intersectY(t2sx, t2sy, t2ex, t2ey, myParent.rightPart.startX - rightClearance,
								myParent.rightPart.startY, myParent.rightPart.endX - rightClearance,
								myParent.rightPart.endY);
					
					myShape.bX2B = bX2B = this.intersectX(t2sxB, t2syB, t2exB, t2eyB, myParent.rightPart.startX
								- rightClearance - rightDimB, myParent.rightPart.startY, myParent.rightPart.endX
								- rightClearance - rightDimB, myParent.rightPart.endY);
					
					myShape.bY2B = bY2B = this.intersectY(t2sxB, t2syB, t2exB, t2eyB, myParent.rightPart.startX
								- rightClearance - rightDimB, myParent.rightPart.startY, myParent.rightPart.endX
								- rightClearance - rightDimB, myParent.rightPart.endY);
					
					myShape.bX2A = bX2A = this
								.intersectX(t2sxA, t2syA, t2exA, t2eyA, myParent.rightPart.startX - rightClearance
											- rightDimB - rightDimA, myParent.rightPart.startY,
											myParent.rightPart.endX - rightClearance - rightDimB - rightDimA,
											myParent.rightPart.endY);
					
					myShape.bY2A = bY2A = this
								.intersectY(t2sxA, t2syA, t2exA, t2eyA, myParent.rightPart.startX - rightClearance
											- rightDimB - rightDimA, myParent.rightPart.startY,
											myParent.rightPart.endX - rightClearance - rightDimB - rightDimA,
											myParent.rightPart.endY);
					
					if (myParent.noSidesTop >= 2 && myParent.top2Part.partForm >= 2)
					{
						bY2B = bY2A = bY2;
					}
					
				}
				else if (myParent.noSidesBot <= 3)
				{
					
					myShape.bCX2 = bX2C = this.intersectX(t2sxC, t2syC, t2exC, t2eyC, myParent.bot1Part.startX,
								myParent.bot1Part.startY - bot1Clearance + bot1DimC, myParent.bot1Part.endX,
								myParent.bot1Part.endY - bot1Clearance + bot1DimC);
					
					myShape.bX2 = bX2 = this.intersectX(t2sx, t2sy, t2ex, t2ey, myParent.bot1Part.startX,
								myParent.bot1Part.startY - bot1Clearance, myParent.bot1Part.endX, myParent.bot1Part.endY
											- bot1Clearance);
					
					myShape.bCY2 = bY2C = this.intersectY(t2sxC, t2syC, t2exC, t2eyC, myParent.bot1Part.startX,
								myParent.bot1Part.startY - bot1Clearance + bot1DimC, myParent.bot1Part.endX,
								myParent.bot1Part.endY - bot1Clearance + bot1DimC);
					
					myShape.bY2 = bY2 = this.intersectY(t2sx, t2sy, t2ex, t2ey, myParent.bot1Part.startX,
								myParent.bot1Part.startY - bot1Clearance, myParent.bot1Part.endX, myParent.bot1Part.endY
											- bot1Clearance);
					
					myShape.bX2B = bX2B = this.intersectX(t2sxB, t2syB, t2exB, t2eyB, myParent.bot1Part.startX
								- bot1Clearance - bot1DimB, myParent.bot1Part.startY, myParent.bot1Part.endX
								- bot1Clearance - bot1DimB, myParent.bot1Part.endY);
					
					myShape.bY2B = bY2B = this.intersectY(t2sxB, t2syB, t2exB, t2eyB, myParent.bot1Part.startX
								- bot1Clearance - bot1DimB, myParent.bot1Part.startY, myParent.bot1Part.endX
								- bot1Clearance - bot1DimB, myParent.bot1Part.endY);
					
					myShape.bX2A = bX2A = this.intersectX(t2sxA, t2syA, t2exA, t2eyA, myParent.bot1Part.startX
								- bot1Clearance - bot1DimB, myParent.bot1Part.startY, myParent.bot1Part.endX
								- bot1Clearance - bot1DimB, myParent.bot1Part.endY);
					
					myShape.bY2A = bY2A = this.intersectY(t2sxA, t2syA, t2exA, t2eyA, myParent.bot1Part.startX
								- bot1Clearance - bot1DimB - bot1DimA, myParent.bot1Part.startY, myParent.bot1Part.endX
								- bot1Clearance - bot1DimB - bot1DimA, myParent.bot1Part.endY);
					
				}
				
			}
			// /////// X3,Y3
			if (myParent.noSidesBot <= 3)
			{
				if (myParent.noSidesRight > 0)
				{
					
					myShape.bCX3 = bX3C = this.intersectX(myParent.bot1Part.startX, myParent.bot1Part.startY - bot1Clearance
								+ bot1DimC, myParent.bot1Part.endX, myParent.bot1Part.endY - bot1Clearance + bot1DimC,
								myParent.rightPart.startX - rightClearance + rightDimC, myParent.rightPart.startY,
								myParent.rightPart.endX - rightClearance + rightDimC, myParent.rightPart.endY);
					
					myShape.bCY3 = bY3C = this.intersectY(myParent.bot1Part.startX, myParent.bot1Part.startY - bot1Clearance
								+ bot1DimC, myParent.bot1Part.endX, myParent.bot1Part.endY - bot1Clearance + bot1DimC,
								myParent.rightPart.startX - rightClearance + rightDimC, myParent.rightPart.startY,
								myParent.rightPart.endX - rightClearance + rightDimC, myParent.rightPart.endY);
					
					myShape.bX3 = bX3 = this.intersectX(myParent.bot1Part.startX, myParent.bot1Part.startY - bot1Clearance,
								myParent.bot1Part.endX, myParent.bot1Part.endY - bot1Clearance, myParent.rightPart.startX
											- rightClearance, myParent.rightPart.startY, myParent.rightPart.endX
											- rightClearance, myParent.rightPart.endY);
					
					myShape.bY3 = bY3 = this.intersectY(myParent.bot1Part.startX, myParent.bot1Part.startY - bot1Clearance,
								myParent.bot1Part.endX, myParent.bot1Part.endY - bot1Clearance, myParent.rightPart.startX
											- rightClearance, myParent.rightPart.startY, myParent.rightPart.endX
											- rightClearance, myParent.rightPart.endY);
					
					myShape.bX3B = bX3B = this.intersectX(myParent.bot1Part.startX, myParent.bot1Part.startY - bot1Clearance
								- bot1DimB, myParent.bot1Part.endX, myParent.bot1Part.endY - bot1Clearance - bot1DimB,
								myParent.rightPart.startX - rightClearance - rightDimB, myParent.rightPart.startY,
								myParent.rightPart.endX - rightClearance - rightDimB, myParent.rightPart.endY);
					
					myShape.bY3B = bY3B = this.intersectY(myParent.bot1Part.startX, myParent.bot1Part.startY - bot1Clearance
								- bot1DimB, myParent.bot1Part.endX, myParent.bot1Part.endY - bot1Clearance - bot1DimB,
								myParent.rightPart.startX - rightClearance - rightDimB, myParent.rightPart.startY,
								myParent.rightPart.endX - rightClearance - rightDimB, myParent.rightPart.endY);
					
					myShape.bX3A = bX3A = this.intersectX(myParent.bot1Part.startX, myParent.bot1Part.startY - bot1Clearance
								- bot1DimB - bot1DimA, myParent.bot1Part.endX, myParent.bot1Part.endY - bot1Clearance
								- bot1DimB - bot1DimA,
								myParent.rightPart.startX - rightClearance - rightDimB - rightDimA,
								myParent.rightPart.startY, myParent.rightPart.endX - rightClearance - rightDimB
											- rightDimA, myParent.rightPart.endY);
					
					myShape.bY3A = bY3A = this.intersectY(myParent.bot1Part.startX, myParent.bot1Part.startY - bot1Clearance
								- bot1DimB - bot1DimA, myParent.bot1Part.endX, myParent.bot1Part.endY - bot1Clearance
								- bot1DimB - bot1DimA,
								myParent.rightPart.startX - rightClearance - rightDimB - rightDimA,
								myParent.rightPart.startY, myParent.rightPart.endX - rightClearance - rightDimB
											- rightDimA, myParent.rightPart.endY);
					
				}
				else if (myParent.noSidesRight == 0)
				{
					
					myShape.bX3 = myShape.bX2;
					myShape.bY3 = myShape.bY2;
					myShape.bX3B = bX3B = bX2B;
					myShape.bY3B = bY3B = bY2B;
					myShape.bX3A = bX3A = bX2A;
					myShape.bY3A = bY3A = bY2A;
					
				}
				
			}
			
			// /////// X4,Y4
			if (myParent.noSidesBot == 1)
			{
				
				if (myParent.noSidesLeft > 0)
				{
					
					myShape.bCX4 = bX4C = this.intersectX(myParent.bot1Part.startX, myParent.bot1Part.startY - bot1Clearance
								+ bot1DimC, myParent.bot1Part.endX, myParent.bot1Part.endY - bot1Clearance + bot1DimC,
								myParent.leftPart.startX + leftClearance - leftDimC, myParent.leftPart.startY,
								myParent.leftPart.endX + leftClearance - leftDimC, myParent.leftPart.endY);
					
					myShape.bCY4 = bY4C = this.intersectY(myParent.bot1Part.startX, myParent.bot1Part.startY - bot1Clearance
								+ bot1DimC, myParent.bot1Part.endX, myParent.bot1Part.endY - bot1Clearance + bot1DimC,
								myParent.leftPart.startX + leftClearance - leftDimC, myParent.leftPart.startY,
								myParent.leftPart.endX + leftClearance - leftDimC, myParent.leftPart.endY);
					
					myShape.bX4 = bX4 = this.intersectX(myParent.bot1Part.startX, myParent.bot1Part.startY - bot1Clearance,
								myParent.bot1Part.endX, myParent.bot1Part.endY - bot1Clearance, myParent.leftPart.startX
											+ leftClearance, myParent.leftPart.startY, myParent.leftPart.endX
											+ leftClearance, myParent.leftPart.endY);
					
					myShape.bY4 = bY4 = this.intersectY(myParent.bot1Part.startX, myParent.bot1Part.startY - bot1Clearance,
								myParent.bot1Part.endX, myParent.bot1Part.endY - bot1Clearance, myParent.leftPart.startX
											+ leftClearance, myParent.leftPart.startY, myParent.leftPart.endX
											+ leftClearance, myParent.leftPart.endY);
					
					myShape.bX4B = bX4B = this.intersectX(myParent.bot1Part.startX, myParent.bot1Part.startY - bot1Clearance
								- bot1DimB, myParent.bot1Part.endX, myParent.bot1Part.endY - bot1Clearance - bot1DimB,
								myParent.leftPart.startX + leftClearance + leftDimB, myParent.leftPart.startY,
								myParent.leftPart.endX + leftClearance + leftDimB, myParent.leftPart.endY);
					
					myShape.bY4B = bY4B = this.intersectY(myParent.bot1Part.startX, myParent.bot1Part.startY - bot1Clearance
								- bot1DimB, myParent.bot1Part.endX, myParent.bot1Part.endY - bot1Clearance - bot1DimB,
								myParent.leftPart.startX + leftClearance + leftDimB, myParent.leftPart.startY,
								myParent.leftPart.endX + leftClearance + leftDimB, myParent.leftPart.endY);
					
					myShape.bX4A = bX4A = this.intersectX(myParent.bot1Part.startX, myParent.bot1Part.startY - bot1Clearance
								- bot1DimB - bot1DimA, myParent.bot1Part.endX, myParent.bot1Part.endY - bot1Clearance
								- bot1DimB - bot1DimA, myParent.leftPart.startX + leftClearance + leftDimB + leftDimA,
								myParent.leftPart.startY, myParent.leftPart.endX + leftClearance + leftDimB + leftDimA,
								myParent.leftPart.endY);
					
					myShape.bY4A = bY4A = this.intersectY(myParent.bot1Part.startX, myParent.bot1Part.startY - bot1Clearance
								- bot1DimB - bot1DimA, myParent.bot1Part.endX, myParent.bot1Part.endY - bot1Clearance
								- bot1DimB - bot1DimA, myParent.leftPart.startX + leftClearance + leftDimB + leftDimA,
								myParent.leftPart.startY, myParent.leftPart.endX + leftClearance + leftDimB + leftDimA,
								myParent.leftPart.endY);
					
				}
				else if (myParent.noSidesLeft == 0)
				{
					
					myShape.bX4 = bX4 = myShape.startingX = bX1;
					myShape.bY4 = bY4 = myShape.startingY = bY1;
					myShape.bX4B = bX4B = bX1B;
					myShape.bY4B = bY4B = bY1B;
					myShape.bX4A = bX4A = bX1A;
					myShape.bY4A = bY4A = bY1A;
					
				}
				
			}
			else if (myParent.noSidesBot > 1)
			{
				if (myParent.noSidesLeft > 0)
				{
					
					myShape.bCX4 = bX4C = this.intersectX(myParent.bot2Part.startX, myParent.bot2Part.startY - bot2Clearance
								+ bot2DimC, myParent.bot2Part.endX, myParent.bot2Part.endY - bot2Clearance + bot2DimC,
								myParent.leftPart.startX + leftClearance - leftDimC, myParent.leftPart.startY,
								myParent.leftPart.endX + leftClearance - leftDimC, myParent.leftPart.endY);
					
					myShape.bCY4 = bY4C = this.intersectY(myParent.bot2Part.startX, myParent.bot2Part.startY - bot2Clearance
								+ bot2DimC, myParent.bot2Part.endX, myParent.bot2Part.endY - bot2Clearance + bot2DimC,
								myParent.leftPart.startX + leftClearance - leftDimC, myParent.leftPart.startY,
								myParent.leftPart.endX + leftClearance - leftDimC, myParent.leftPart.endY);
					
					myShape.bX4 = bX4 = this.intersectX(myParent.bot2Part.startX, myParent.bot2Part.startY - bot2Clearance,
								myParent.bot2Part.endX, myParent.bot2Part.endY - bot2Clearance, myParent.leftPart.startX
											+ leftClearance, myParent.leftPart.startY, myParent.leftPart.endX
											+ leftClearance, myParent.leftPart.endY);
					
					myShape.bY4 = bY4 = this.intersectY(myParent.bot2Part.startX, myParent.bot2Part.startY - bot2Clearance,
								myParent.bot2Part.endX, myParent.bot2Part.endY - bot2Clearance, myParent.leftPart.startX
											+ leftClearance, myParent.leftPart.startY, myParent.leftPart.endX
											+ leftClearance, myParent.leftPart.endY);
					
					myShape.bX4B = bX4B = this.intersectX(myParent.bot2Part.startX, myParent.bot2Part.startY - bot2Clearance
								- bot2DimB, myParent.bot2Part.endX, myParent.bot2Part.endY - bot2Clearance - bot2DimB,
								myParent.leftPart.startX + leftClearance + leftDimB, myParent.leftPart.startY,
								myParent.leftPart.endX + leftClearance + leftDimB, myParent.leftPart.endY);
					
					myShape.bY4B = bY4B = this.intersectY(myParent.bot2Part.startX, myParent.bot2Part.startY - bot2Clearance
								- bot2DimB, myParent.bot2Part.endX, myParent.bot2Part.endY - bot2Clearance - bot2DimB,
								myParent.leftPart.startX + leftClearance + leftDimB, myParent.leftPart.startY,
								myParent.leftPart.endX + leftClearance + leftDimB, myParent.leftPart.endY);
					
					myShape.bX4A = bX4A = this.intersectX(myParent.bot2Part.startX, myParent.bot2Part.startY - bot2Clearance
								- bot2DimB - bot2DimA, myParent.bot2Part.endX, myParent.bot2Part.endY - bot2Clearance
								- bot2DimB - bot2DimA, myParent.leftPart.startX + leftClearance + leftDimB + leftDimA,
								myParent.leftPart.startY, myParent.leftPart.endX + leftClearance + leftDimB + leftDimA,
								myParent.leftPart.endY);
					
					myShape.bY4A = bY4A = this.intersectY(myParent.bot2Part.startX, myParent.bot2Part.startY - bot2Clearance
								- bot2DimB - bot2DimA, myParent.bot2Part.endX, myParent.bot2Part.endY - bot2Clearance
								- bot2DimB - bot2DimA, myParent.leftPart.startX + leftClearance + leftDimB + leftDimA,
								myParent.leftPart.startY, myParent.leftPart.endX + leftClearance + leftDimB + leftDimA,
								myParent.leftPart.endY);
					
				}
				else if (myParent.noSidesLeft == 0)
				{
					
					myShape.bX4 = bX4 = myShape.startingX = bX1;
					myShape.bY4 = bY4 = myShape.startingY = bY1;
					myShape.bX4B = bX4B = bX1B;
					myShape.bY4B = bY4B = bY1B;
					myShape.bX4A = bX4A = bX1A;
					myShape.bY4A = bY4A = bY1A;
					
				}
			}
			
			if (myParent.noSidesTop == 2)
			{
				
				if (myParent.top1Part.startYC > myParent.top2Part.startYC
							&& myParent.top2Part.endYC <= myParent.top1Part.endYC)
				{
					
					t1t2XC = this.intersectX(myParent.top1Part.startX + top1Clearance - top1DimC, myParent.top1Part.startY,
								myParent.top1Part.endX + top1Clearance - top1DimC, myParent.top1Part.endY,
								myParent.top2Part.startX, myParent.top2Part.startY + top2Clearance - top2DimC,
								myParent.top2Part.endX, myParent.top2Part.endY + top2Clearance - top2DimC);
					
					t1t2X = this.intersectX(myParent.top1Part.startX + top1Clearance, myParent.top1Part.startY,
								myParent.top1Part.endX + top1Clearance, myParent.top1Part.endY, myParent.top2Part.startX,
								myParent.top2Part.startY + top2Clearance, myParent.top2Part.endX, myParent.top2Part.endY
											+ top2Clearance);
					
					t1t2XB = this.intersectX(myParent.top1Part.startX + top1Clearance + top1DimB, myParent.top1Part.startY,
								myParent.top1Part.endX + top1Clearance + top1DimB, myParent.top1Part.endY,
								myParent.top2Part.startX, myParent.top2Part.startY + top2Clearance + top2DimB,
								myParent.top2Part.endX, myParent.top2Part.endY + top2Clearance + top2DimB);
					
					t1t2XA = this.intersectX(myParent.top1Part.startX + top1Clearance + top1DimB + top1DimA,
								myParent.top1Part.startY, myParent.top1Part.endX + top1Clearance + top1DimB + top1DimA,
								myParent.top1Part.endY, myParent.top2Part.startX, myParent.top2Part.startY
											+ top2Clearance + top2DimB + top2DimA, myParent.top2Part.endX,
								myParent.top2Part.endY + top2Clearance + top2DimB + top2DimA);
					
					t1t2YC = this.intersectY(myParent.top1Part.startX + top1Clearance - top1DimC, myParent.top1Part.startY,
								myParent.top1Part.endX + top1Clearance - top1DimC, myParent.top1Part.endY,
								myParent.top2Part.startX, myParent.top2Part.startY + top2Clearance - top2DimC,
								myParent.top2Part.endX, myParent.top2Part.endY + top2Clearance - top2DimC);
					
					t1t2Y = this.intersectY(myParent.top1Part.startX + top1Clearance, myParent.top1Part.startY,
								myParent.top1Part.endX + top1Clearance, myParent.top1Part.endY, myParent.top2Part.startX,
								myParent.top2Part.startY + top2Clearance, myParent.top2Part.endX, myParent.top2Part.endY
											+ top2Clearance);
					
					t1t2YB = this.intersectY(myParent.top1Part.startX + top1Clearance + top1DimB, myParent.top1Part.startY,
								myParent.top1Part.endX + top1Clearance + top1DimB, myParent.top1Part.endY,
								myParent.top2Part.startX, myParent.top2Part.startY + top2Clearance + top2DimB,
								myParent.top2Part.endX, myParent.top2Part.endY + top2Clearance + top2DimB);
					
					t1t2YA = this.intersectY(myParent.top1Part.startX + top1Clearance + top1DimB + top1DimA,
								myParent.top1Part.startY, myParent.top1Part.endX + top1Clearance + top1DimB + top1DimA,
								myParent.top1Part.endY, myParent.top2Part.startX, myParent.top2Part.startY
											+ top2Clearance + top2DimB + top2DimA, myParent.top2Part.endX,
								myParent.top2Part.endY + top2Clearance + top2DimB + top2DimA);
					
				}
				else
				{
					
					t1t2XC = this.intersectX(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance - top1DimC,
								myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance - top1DimC,
								myParent.top2Part.startX + top2Clearance - top2DimC, myParent.top2Part.startY,
								myParent.top2Part.endX + top2Clearance - top2DimC, myParent.top2Part.endY);
					
					t1t2X = this.intersectX(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance,
								myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance, myParent.top2Part.startX
											+ top2Clearance, myParent.top2Part.startY, myParent.top2Part.endX
											+ top2Clearance, myParent.top2Part.endY);
					
					t1t2XB = this.intersectX(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance + top1DimB,
								myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance + top1DimB,
								myParent.top2Part.startX - top2Clearance - top2DimB, myParent.top2Part.startY,
								myParent.top2Part.endX - top2Clearance - top2DimB, myParent.top2Part.endY);
					
					t1t2XA = this.intersectX(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance + top1DimB
								+ top1DimA, myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance + top1DimB
								+ top1DimA, myParent.top2Part.startX - top2Clearance - top2DimB - top2DimA,
								myParent.top2Part.startY, myParent.top2Part.endX - top2Clearance - top2DimB - top2DimA,
								myParent.top2Part.endY);
					
					t1t2YC = this.intersectY(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance - top1DimC,
								myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance - top1DimC,
								myParent.top2Part.startX - top2Clearance + top2DimC, myParent.top2Part.startY,
								myParent.top2Part.endX - top2Clearance + top2DimC, myParent.top2Part.endY);
					
					t1t2Y = this.intersectY(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance,
								myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance, myParent.top2Part.startX
											- top2Clearance, myParent.top2Part.startY, myParent.top2Part.endX
											- top2Clearance, myParent.top2Part.endY);
					
					t1t2YB = this.intersectY(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance + top1DimB,
								myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance + top1DimB,
								myParent.top2Part.startX - top2Clearance - top2DimB, myParent.top2Part.startY,
								myParent.top2Part.endX - top2Clearance - top2DimB, myParent.top2Part.endY);
					
					t1t2YA = this.intersectY(myParent.top1Part.startX, myParent.top1Part.startY + top1Clearance + top1DimB
								+ top1DimA, myParent.top1Part.endX, myParent.top1Part.endY + top1Clearance + top1DimB
								+ top1DimA, myParent.top2Part.startX - top2Clearance - top2DimB - top2DimA,
								myParent.top2Part.startY, myParent.top2Part.endX - top2Clearance - top2DimB - top2DimA,
								myParent.top2Part.endY);
					
				}
				
			}
			else if (myParent.noSidesTop == 3)
			{
				
				t1t3XC = this.intersectX(myParent.top1Part.startX + top1Clearance - top1DimC, myParent.top1Part.startY,
							myParent.top1Part.endX + top1Clearance - top1DimC, myParent.top1Part.endY,
							myParent.top3Part.startX, myParent.top3Part.startY + top3Clearance - top3DimC,
							myParent.top3Part.endX, myParent.top3Part.endY + top3Clearance - top3DimC);
				
				t1t3X = this.intersectX(myParent.top1Part.startX + top1Clearance, myParent.top1Part.startY,
							myParent.top1Part.endX + top1Clearance, myParent.top1Part.endY, myParent.top3Part.startX,
							myParent.top3Part.startY + top3Clearance, myParent.top3Part.endX, myParent.top3Part.endY
										+ top3Clearance);
				
				t1t3XB = this.intersectX(myParent.top1Part.startX + top1Clearance + top1DimB, myParent.top1Part.startY,
							myParent.top1Part.endX + top1Clearance + top1DimB, myParent.top1Part.endY,
							myParent.top3Part.startX, myParent.top3Part.startY + top3Clearance + top3DimB,
							myParent.top3Part.endX, myParent.top3Part.endY + top3Clearance + top3DimB);
				
				t1t3XA = this.intersectX(myParent.top1Part.startX + top1Clearance + top1DimB + top1DimA,
							myParent.top1Part.startY, myParent.top1Part.endX + top1Clearance + top1DimB + top1DimA,
							myParent.top1Part.endY, myParent.top3Part.startX, myParent.top3Part.startY + top3Clearance
										+ top3DimB + top3DimA, myParent.top3Part.endX, myParent.top3Part.endY
										+ top3Clearance + top3DimB + top3DimA);
				
				t1t3YC = this.intersectY(myParent.top1Part.startX + top1Clearance - top1DimC, myParent.top1Part.startY,
							myParent.top1Part.endX + top1Clearance - top1DimC, myParent.top1Part.endY,
							myParent.top3Part.startX, myParent.top3Part.startY + top3Clearance - top3DimC,
							myParent.top3Part.endX, myParent.top3Part.endY + top3Clearance - top3DimC);
				
				t1t3Y = this.intersectY(myParent.top1Part.startX + top1Clearance, myParent.top1Part.startY,
							myParent.top1Part.endX + top1Clearance, myParent.top1Part.endY, myParent.top3Part.startX,
							myParent.top3Part.startY + top3Clearance, myParent.top3Part.endX, myParent.top3Part.endY
										+ top3Clearance);
				
				t1t3YB = this.intersectY(myParent.top1Part.startX + top1Clearance + top1DimB, myParent.top1Part.startY,
							myParent.top1Part.endX + top1Clearance + top1DimB, myParent.top1Part.endY,
							myParent.top3Part.startX, myParent.top3Part.startY + top3Clearance + top3DimB,
							myParent.top3Part.endX, myParent.top3Part.endY + top3Clearance + top3DimB);
				
				t1t3YA = this.intersectY(myParent.top1Part.startX + top1Clearance + top1DimB + top1DimA,
							myParent.top1Part.startY, myParent.top1Part.endX + top1Clearance + top1DimB + top1DimA,
							myParent.top1Part.endY, myParent.top3Part.startX, myParent.top3Part.startY + top3Clearance
										+ top3DimB + top3DimA, myParent.top3Part.endX, myParent.top3Part.endY
										+ top3Clearance + top3DimB + top3DimA);
				
				t3t2XC = this.intersectX(myParent.top3Part.startX, myParent.top3Part.startY + top3Clearance - top3DimC,
							myParent.top3Part.endX, myParent.top3Part.endY + top3Clearance - top3DimC,
							myParent.top2Part.startX - top2Clearance + top2DimC, myParent.top2Part.startY,
							myParent.top2Part.endX - top2Clearance + top2DimC, myParent.top2Part.endY);
				
				t3t2X = this.intersectX(myParent.top3Part.startX, myParent.top3Part.startY + top3Clearance,
							myParent.top3Part.endX, myParent.top3Part.endY + top3Clearance, myParent.top2Part.startX
										- top2Clearance, myParent.top2Part.startY, myParent.top2Part.endX
										- top2Clearance, myParent.top2Part.endY);
				
				t3t2XB = this.intersectX(myParent.top3Part.startX, myParent.top3Part.startY + top3Clearance + top3DimB,
							myParent.top3Part.endX, myParent.top3Part.endY + top3Clearance + top3DimB,
							myParent.top2Part.startX - top2Clearance - top2DimB, myParent.top2Part.startY,
							myParent.top2Part.endX - top2Clearance - top2DimB, myParent.top2Part.endY);
				
				t3t2XA = this.intersectX(myParent.top3Part.startX, myParent.top3Part.startY + top3Clearance + top3DimB
							+ top3DimA, myParent.top3Part.endX, myParent.top3Part.endY + top3Clearance + top3DimB
							+ top3DimA, myParent.top2Part.startX - top2Clearance - top2DimB - top2DimA,
							myParent.top2Part.startY, myParent.top2Part.endX - top2Clearance - top2DimB - top2DimA,
							myParent.top2Part.endY);
				
				t3t2YC = this.intersectY(myParent.top3Part.startX, myParent.top3Part.startY + top3Clearance - top3DimC,
							myParent.top3Part.endX, myParent.top3Part.endY + top3Clearance - top3DimC,
							myParent.top2Part.startX - top2Clearance + top2DimC, myParent.top2Part.startY,
							myParent.top2Part.endX - top2Clearance + top2DimC, myParent.top2Part.endY);
				
				t3t2Y = this.intersectY(myParent.top3Part.startX, myParent.top3Part.startY + top3Clearance,
							myParent.top3Part.endX, myParent.top3Part.endY + top3Clearance, myParent.top2Part.startX
										- top2Clearance, myParent.top2Part.startY, myParent.top2Part.endX
										- top2Clearance, myParent.top2Part.endY);
				
				t3t2YB = this.intersectY(myParent.top3Part.startX, myParent.top3Part.startY + top3Clearance + top3DimB,
							myParent.top3Part.endX, myParent.top3Part.endY + top3Clearance + top3DimB,
							myParent.top2Part.startX - top2Clearance - top2DimB, myParent.top2Part.startY,
							myParent.top2Part.endX - top2Clearance - top2DimB, myParent.top2Part.endY);
				
				t3t2YA = this.intersectY(myParent.top3Part.startX, myParent.top3Part.startY + top3Clearance + top3DimB
							+ top3DimA, myParent.top3Part.endX, myParent.top3Part.endY + top3Clearance + top3DimB
							+ top3DimA, myParent.top2Part.startX - top2Clearance - top2DimB - top2DimA,
							myParent.top2Part.startY, myParent.top2Part.endX - top2Clearance - top2DimB - top2DimA,
							myParent.top2Part.endY);
				
			}
			
			if (myParent.noSidesBot == 2)
			{
				
				b1b2XC = this.intersectX(myParent.bot1Part.startX - bot1Clearance + bot1DimC, myParent.bot1Part.startY,
							myParent.bot1Part.endX - bot1Clearance + bot1DimC, myParent.bot1Part.endY,
							myParent.bot2Part.startX, myParent.bot2Part.startY - bot2Clearance + bot2DimC,
							myParent.bot2Part.endX, myParent.bot2Part.endY - bot2Clearance + bot2DimC);
				
				b1b2X = this.intersectX(myParent.bot1Part.startX - bot1Clearance, myParent.bot1Part.startY,
							myParent.bot1Part.endX - bot1Clearance, myParent.bot1Part.endY, myParent.bot2Part.startX,
							myParent.bot2Part.startY - bot2Clearance, myParent.bot2Part.endX, myParent.bot2Part.endY
										- bot2Clearance);
				
				b1b2XB = this.intersectX(myParent.bot1Part.startX - bot1Clearance - bot1DimB, myParent.bot1Part.startY,
							myParent.bot1Part.endX - bot1Clearance - bot1DimB, myParent.bot1Part.endY,
							myParent.bot2Part.startX, myParent.bot2Part.startY - bot2Clearance - bot2DimB,
							myParent.bot2Part.endX, myParent.bot2Part.endY - bot2Clearance - bot2DimB);
				
				b1b2XA = this.intersectX(myParent.bot1Part.startX - bot1Clearance - bot1DimB - bot1DimA,
							myParent.bot1Part.startY, myParent.bot1Part.endX - bot1Clearance - bot1DimB - bot1DimA,
							myParent.bot1Part.endY, myParent.bot2Part.startX, myParent.bot2Part.startY - bot2Clearance
										- bot2DimB - bot2DimA, myParent.bot2Part.endX, myParent.bot2Part.endY
										- bot2Clearance - bot2DimB - bot2DimA);
				
				b1b2YC = this.intersectY(myParent.bot1Part.startX - bot1Clearance + bot1DimC, myParent.bot1Part.startY,
							myParent.bot1Part.endX - bot1Clearance + bot1DimC, myParent.bot1Part.endY,
							myParent.bot2Part.startX, myParent.bot2Part.startY - bot2Clearance + bot2DimC,
							myParent.bot2Part.endX, myParent.bot2Part.endY - bot2Clearance + bot2DimC);
				
				b1b2Y = this.intersectY(myParent.bot1Part.startX - bot1Clearance, myParent.bot1Part.startY,
							myParent.bot1Part.endX - bot1Clearance, myParent.bot1Part.endY, myParent.bot2Part.startX,
							myParent.bot2Part.startY - bot2Clearance, myParent.bot2Part.endX, myParent.bot2Part.endY
										- bot2Clearance);
				
				b1b2YB = this.intersectY(myParent.bot1Part.startX - bot1Clearance - bot1DimB, myParent.bot1Part.startY,
							myParent.bot1Part.endX - bot1Clearance - bot1DimB, myParent.bot1Part.endY,
							myParent.bot2Part.startX, myParent.bot2Part.startY - bot2Clearance - bot2DimB,
							myParent.bot2Part.endX, myParent.bot2Part.endY - bot2Clearance - bot2DimB);
				
				b1b2YA = this.intersectY(myParent.bot1Part.startX - bot1Clearance - bot1DimB - bot1DimA,
							myParent.bot1Part.startY, myParent.bot1Part.endX - bot1Clearance - bot1DimB - bot1DimA,
							myParent.bot1Part.endY, myParent.bot2Part.startX, myParent.bot2Part.startY - bot2Clearance
										- bot2DimB - bot2DimA, myParent.bot2Part.endX, myParent.bot2Part.endY
										- bot2Clearance - bot2DimB - bot2DimA);
				
			}
			else if (myParent.noSidesBot == 3)
			{
				
				b1b3XC = this.intersectX(myParent.bot1Part.startX - bot1Clearance + bot1DimC, myParent.bot1Part.startY,
							myParent.bot1Part.endX - bot1Clearance + bot1DimC, myParent.bot1Part.endY,
							myParent.bot3Part.startX, myParent.bot3Part.startY - bot3Clearance + bot3DimC,
							myParent.bot3Part.endX, myParent.bot3Part.endY - bot3Clearance + bot3DimC);
				
				b1b3X = this.intersectX(myParent.bot1Part.startX - bot1Clearance, myParent.bot1Part.startY,
							myParent.bot1Part.endX - bot1Clearance, myParent.bot1Part.endY, myParent.bot3Part.startX,
							myParent.bot3Part.startY - bot3Clearance, myParent.bot3Part.endX, myParent.bot3Part.endY
										- bot3Clearance);
				
				b1b3XB = this.intersectX(myParent.bot1Part.startX - bot1Clearance - bot1DimB, myParent.bot1Part.startY,
							myParent.bot1Part.endX - bot1Clearance - bot1DimB, myParent.bot1Part.endY,
							myParent.bot3Part.startX, myParent.bot3Part.startY - bot3Clearance - bot3DimB,
							myParent.bot3Part.endX, myParent.bot3Part.endY - bot3Clearance - bot3DimB);
				
				b1b3XA = this.intersectX(myParent.bot1Part.startX - bot1Clearance - bot1DimB - bot1DimA,
							myParent.bot1Part.startY, myParent.bot1Part.endX - bot1Clearance - bot1DimB - bot1DimA,
							myParent.bot1Part.endY, myParent.bot3Part.startX, myParent.bot3Part.startY - bot3Clearance
										- bot3DimB - bot3DimA, myParent.bot3Part.endX, myParent.bot3Part.endY
										- bot3Clearance - bot3DimB - bot3DimA);
				
				b1b3YC = this.intersectY(myParent.bot1Part.startX - bot1Clearance + bot1DimC, myParent.bot1Part.startY,
							myParent.bot1Part.endX - bot1Clearance + bot1DimC, myParent.bot1Part.endY,
							myParent.bot3Part.startX, myParent.bot3Part.startY - bot3Clearance + bot3DimC,
							myParent.bot3Part.endX, myParent.bot3Part.endY - bot3Clearance + bot3DimC);
				
				b1b3Y = this.intersectY(myParent.bot1Part.startX - bot1Clearance, myParent.bot1Part.startY,
							myParent.bot1Part.endX - bot1Clearance, myParent.bot1Part.endY, myParent.bot3Part.startX,
							myParent.bot3Part.startY - bot3Clearance, myParent.bot3Part.endX, myParent.bot3Part.endY
										- bot3Clearance);
				
				b1b3YB = this.intersectY(myParent.bot1Part.startX - bot1Clearance - bot1DimB, myParent.bot1Part.startY,
							myParent.bot1Part.endX - bot1Clearance - bot1DimB, myParent.bot1Part.endY,
							myParent.bot3Part.startX, myParent.bot3Part.startY - bot3Clearance - bot3DimB,
							myParent.bot3Part.endX, myParent.bot3Part.endY - bot3Clearance - bot3DimB);
				
				b1b3YA = this.intersectY(myParent.bot1Part.startX - bot1Clearance - bot1DimB - bot1DimA,
							myParent.bot1Part.startY, myParent.bot1Part.endX - bot1Clearance - bot1DimB - bot1DimA,
							myParent.bot1Part.endY, myParent.bot3Part.startX, myParent.bot3Part.startY - bot3Clearance
										- bot3DimB - bot3DimA, myParent.bot3Part.endX, myParent.bot3Part.endY
										- bot3Clearance - bot3DimB - bot3DimA);
				
				b3b2XC = this.intersectX(myParent.bot2Part.startX + bot2Clearance - bot2DimC, myParent.bot2Part.startY,
							myParent.bot2Part.endX + bot2Clearance - bot2DimC, myParent.bot2Part.endY,
							myParent.bot3Part.startX, myParent.bot3Part.startY - bot3Clearance + bot3DimC,
							myParent.bot3Part.endX, myParent.bot3Part.endY - bot3Clearance + bot3DimC);
				
				b3b2X = this.intersectX(myParent.bot2Part.startX + bot2Clearance, myParent.bot2Part.startY,
							myParent.bot2Part.endX + bot2Clearance, myParent.bot2Part.endY, myParent.bot3Part.startX,
							myParent.bot3Part.startY - bot3Clearance, myParent.bot3Part.endX, myParent.bot3Part.endY
										- bot3Clearance);
				
				b3b2XB = this.intersectX(myParent.bot2Part.startX + bot2Clearance + bot2DimB, myParent.bot2Part.startY,
							myParent.bot2Part.endX + bot2Clearance + bot2DimB, myParent.bot2Part.endY,
							myParent.bot3Part.startX, myParent.bot3Part.startY - bot3Clearance - bot3DimB,
							myParent.bot3Part.endX, myParent.bot3Part.endY - bot3Clearance - bot3DimB);
				
				b3b2XA = this.intersectX(myParent.bot2Part.startX + bot2Clearance + bot2DimB + bot2DimA,
							myParent.bot2Part.startY, myParent.bot2Part.endX + bot2Clearance + bot2DimB + bot2DimA,
							myParent.bot2Part.endY, myParent.bot3Part.startX, myParent.bot3Part.startY - bot3Clearance
										- bot3DimB - bot3DimA, myParent.bot3Part.endX, myParent.bot3Part.endY
										- bot3Clearance - bot3DimB - bot3DimA);
				
				b3b2YC = this.intersectY(myParent.bot2Part.startX + bot2Clearance - bot2DimC, myParent.bot2Part.startY,
							myParent.bot2Part.endX + bot2Clearance - bot2DimC, myParent.bot2Part.endY,
							myParent.bot3Part.startX, myParent.bot3Part.startY - bot3Clearance + bot3DimC,
							myParent.bot3Part.endX, myParent.bot3Part.endY - bot3Clearance + bot3DimC);
				
				b3b2Y = this.intersectY(myParent.bot2Part.startX + bot2Clearance, myParent.bot2Part.startY,
							myParent.bot2Part.endX + bot2Clearance, myParent.bot2Part.endY, myParent.bot3Part.startX,
							myParent.bot3Part.startY - bot3Clearance, myParent.bot3Part.endX, myParent.bot3Part.endY
										- bot3Clearance);
				
				b3b2YB = this.intersectY(myParent.bot2Part.startX + bot2Clearance + bot2DimB, myParent.bot2Part.startY,
							myParent.bot2Part.endX + bot2Clearance + bot2DimB, myParent.bot2Part.endY,
							myParent.bot3Part.startX, myParent.bot3Part.startY - bot3Clearance - bot3DimB,
							myParent.bot3Part.endX, myParent.bot3Part.endY - bot3Clearance - bot3DimB);
				
				b3b2YA = this.intersectY(myParent.bot2Part.startX + bot2Clearance + bot2DimB + bot2DimA,
							myParent.bot2Part.startY, myParent.bot2Part.endX + bot2Clearance + bot2DimB + bot2DimA,
							myParent.bot2Part.endY, myParent.bot3Part.startX, myParent.bot3Part.startY - bot3Clearance
										- bot3DimB - bot3DimA, myParent.bot3Part.endX, myParent.bot3Part.endY
										- bot3Clearance - bot3DimB - bot3DimA);
				
			}
			
		}
		
		startingCX = myShape.startingCX;
		startingCY = myShape.startingCY;
		
		return myShape;
		
	}
	
	public ShapeObject doShapeBkgrdBA(final ShapeObject myShape)
	{
	
		this.initCenters(myShape);
		if (myParent.noSides == 2)
		{
			
			myShape.startingX = bX1 = myParent.bot1Part.endXBA + myShape.clearanceTop - top1DimCo;
			
			bX1B = myParent.bot1Part.endXBA + myShape.clearanceTop + top1DimBo;
			bX1A = bX1B + top1DimAo;
			
			myShape.startingY = bY1 = myParent.bot1Part.endYBA - myShape.clearanceBot + bot1DimCo;
			
			bY1B = myParent.bot1Part.endYBA - myShape.clearanceBot - bot1DimBo;
			bY1A = bY1B - bot1DimAo;
			
			myShape.bX2 = bX2 = myParent.bot1Part.startXBA - myShape.clearanceTop + top1DimCo;
			
			bX2B = myParent.bot1Part.startXBA - myShape.clearanceTop - top1DimBo;
			bX2A = bX2B - top1DimAo;
			
			myShape.bY2 = bY2 = myParent.bot1Part.startYBA - myShape.clearanceBot + bot1DimCo;
			
			bY2B = myParent.bot1Part.startYBA - myShape.clearanceBot - bot1DimBo;
			bY2A = bY2B - bot1DimAo;
			
		}
		else if (myParent.noSides == 3 && myParent.noSidesRight == 1 && myParent.top1Part.partForm > 1)
		{
			
			myShape.startingX = myShape.bX4 = bX1 = bX4 = myParent.top1Part.startXBA + myShape.clearanceTop - top1DimCo;
			bX1B = bX4B = myParent.top1Part.startXBA + myShape.clearanceTop + top1DimBo;
			bX1A = bX4A = bX1B + top1DimAo;
			
			myShape.startingY = bY4 = bY1 = myParent.bot1Part.endYBA - myShape.clearanceBot + bot1DimCo;
			bY1B = bY4B = myParent.bot1Part.endYBA - myShape.clearanceBot - bot1DimBo;
			bY1A = bY4A = bY1B - bot1DimAo;
			
			myShape.bX2 = bX2 = myParent.rightPart.startXBA - myShape.clearanceRight + rightDimCo;
			
			bX2B = myParent.rightPart.startXBA - myShape.clearanceRight - rightDimBo;
			bX2A = bX2B - rightDimAo;
			
			myShape.bY2 = bY2 = myParent.top1Part.endYBA + myShape.clearanceTop - top1DimCo;
			bY2B = myParent.top1Part.endYBA + myShape.clearanceTop + top1DimBo;
			bY2A = bY2B + top1DimAo;
			
			myShape.bX3 = bX3 = myParent.rightPart.endXBA - myShape.clearanceRight + rightDimCo;
			bX3B = myParent.rightPart.endXBA - myShape.clearanceRight - rightDimBo;
			bX3A = bX3B - rightDimAo;
			
			myShape.bY3 = bY3 = myParent.bot1Part.startYBA - myShape.clearanceBot + bot1DimCo;
			
			bY3B = myParent.bot1Part.startYBA - myShape.clearanceBot - bot1DimBo;
			bY3A = bY3B - bot1DimAo;
			
		}
		else if (myParent.noSides == 3 && myParent.noSidesLeft == 1 && myParent.top1Part.partForm > 1)
		{
			
			myShape.startingX = bX1 = myParent.leftPart.endXBA + myShape.clearanceLeft - leftDimCo;
			
			bX1B = myParent.leftPart.endXBA + myShape.clearanceLeft + top1DimBo;
			
			bX1A = bX1B + top1DimAo;
			
			myShape.startingY = bY1 = myParent.top1Part.startYBA + myShape.clearanceTop - top1DimCo;
			
			bY1B = myParent.top1Part.startYBA + myShape.clearanceTop + top1DimBo;
			
			bY1A = bY1B + top1DimAo;
			
			myShape.bX2 = bX2 = myParent.top1Part.endXBA - myShape.clearanceTop + top1DimCo;
			
			bX2B = myParent.top1Part.endXBA - myShape.clearanceTop - top1DimBo;
			bX2A = bX2B - top1DimAo;
			
			myShape.bY2 = bY2 = myParent.bot1Part.startYBA - myShape.clearanceBot + bot1DimCo;
			
			bY2B = myParent.bot1Part.startYBA - myShape.clearanceBot - bot1DimBo;
			
			bY2A = bY2B - bot1DimAo;
			bX3 = bX2;
			bY3 = bY2;
			bY3B = bY2B;
			bY3A = bY2A;
			
			myShape.bX4 = bX4 = myParent.leftPart.startXBA + myShape.clearanceLeft - leftDimCo;
			
			bX4B = myParent.leftPart.startXBA + myShape.clearanceLeft + rightDimBo;
			
			bX4A = bX4B + rightDimAo;
			
			myShape.bY4 = bY4 = myParent.bot1Part.endYBA - myShape.clearanceBot + bot1DimCo;
			
			bY4B = myParent.bot1Part.endYBA - myShape.clearanceBot - bot1DimBo;
			bY4A = bY4B - bot1DimAo;
			
		}
		else
		{
			if (myParent.noSidesLeft > 0)
			{
				
				myShape.startingX = bX1 = this.intersectX(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimC,
							myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimC, myParent.leftPart.startXBA
										+ leftDimC, myParent.leftPart.startYBA, myParent.leftPart.endXBA + leftDimC,
							myParent.leftPart.endYBA);
				
				bX1B = this.intersectX(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimB,
							myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimB, myParent.leftPart.startXBA
										+ leftDimB, myParent.leftPart.startYBA, myParent.leftPart.endXBA + leftDimB,
							myParent.leftPart.endYBA);
				
				bX1A = this.intersectX(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimA,
							myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimA, myParent.leftPart.startXBA
										+ leftDimA, myParent.leftPart.startYBA, myParent.leftPart.endXBA + leftDimA,
							myParent.leftPart.endYBA);
				
				myShape.startingCY = bY1 = this.intersectY(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimC,
							myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimC, myParent.leftPart.startXBA
										+ leftDimC, myParent.leftPart.startYBA, myParent.leftPart.endXBA + leftDimC,
							myParent.leftPart.endYBA);
				
				bY1B = this.intersectY(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimB,
							myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimB, myParent.leftPart.startXBA
										+ leftDimB, myParent.leftPart.startYBA, myParent.leftPart.endXBA + leftDimB,
							myParent.leftPart.endYBA);
				
				bY1A = this.intersectY(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimA,
							myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimA, myParent.leftPart.startXBA
										+ leftDimA, myParent.leftPart.startYBA, myParent.leftPart.endXBA + leftDimA,
							myParent.leftPart.endYBA);
				
			}
			else if (myParent.noSidesBot == 1)
			{
				
				myShape.startingX = bX1 = this.intersectX(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimC,
							myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimC, myParent.bot1Part.startXBA,
							myParent.bot1Part.startYBA - bot1DimC, myParent.bot1Part.endXBA, myParent.bot1Part.endYBA
										- bot1DimC);
				
				bX1B = this.intersectX(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimB,
							myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimB, myParent.bot1Part.startXBA,
							myParent.bot1Part.startYBA - bot1DimB, myParent.bot1Part.endXBA, myParent.bot1Part.endYBA
										- bot1DimB);
				
				bX1A = this.intersectX(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimA,
							myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimA, myParent.bot1Part.startXBA,
							myParent.bot1Part.startYBA - bot1DimA, myParent.bot1Part.endXBA, myParent.bot1Part.endYBA
										- bot1DimA);
				
				myShape.startingCY = this.intersectY(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimC,
							myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimC, myParent.bot1Part.startXBA,
							myParent.bot1Part.startYBA - bot1DimC, myParent.bot1Part.endXBA, myParent.bot1Part.endYBA
										- bot1DimC);
				
				bY1B = this.intersectY(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimB,
							myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimB, myParent.bot1Part.startXBA,
							myParent.bot1Part.startYBA - bot1DimB, myParent.bot1Part.endXBA, myParent.bot1Part.endYBA
										- bot1DimB);
				
				bY1A = this.intersectY(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimA,
							myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimA, myParent.bot1Part.startXBA,
							myParent.bot1Part.startYBA - bot1DimA, myParent.bot1Part.endXBA, myParent.bot1Part.endYBA
										- bot1DimA);
				
			}
			else if (myParent.noSidesBot > 1)
			{
				
				myShape.startingX = bX1 = this.intersectX(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimC,
							myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimC, myParent.bot2Part.startXBA,
							myParent.bot2Part.startYBA - bot2DimC, myParent.bot2Part.endXBA, myParent.bot2Part.endYBA
										- bot2DimC);
				
				bX1B = this.intersectX(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimB,
							myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimB, myParent.bot2Part.startXBA,
							myParent.bot2Part.startYBA - bot2DimB, myParent.bot2Part.endXBA, myParent.bot2Part.endYBA
										- bot2DimB);
				
				bX1A = this.intersectX(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimA,
							myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimA, myParent.bot2Part.startXBA,
							myParent.bot2Part.startYBA - bot2DimA, myParent.bot2Part.endXBA, myParent.bot2Part.endYBA
										- bot2DimA);
				
				myShape.startingCY = this.intersectY(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimC,
							myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimC, myParent.bot2Part.startXBA,
							myParent.bot2Part.startYBA - bot2DimC, myParent.bot2Part.endXBA, myParent.bot2Part.endYBA
										- bot2DimC);
				
				bY1B = this.intersectY(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimB,
							myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimB, myParent.bot2Part.startXBA,
							myParent.bot2Part.startYBA - bot2DimB, myParent.bot2Part.endXBA, myParent.bot2Part.endYBA
										- bot2DimB);
				
				bY1A = this.intersectY(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimA,
							myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimA, myParent.bot2Part.startXBA,
							myParent.bot2Part.startYBA - bot2DimA, myParent.bot2Part.endXBA, myParent.bot2Part.endYBA
										- bot2DimA);
				
			}
			
			// myShape.bkgrdStartX =
			// myShape.startingX;
			// myShape.bkgrdStartY =
			// myShape.startingY;
			
			// //////// X2,Y2
			if (myParent.noSidesTop == 1)
			{
				if (myParent.noSidesRight > 0)
				{
					
					myShape.bX2 = bX2 = this.intersectX(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimC,
								myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimC,
								myParent.rightPart.startXBA - rightDimC, myParent.rightPart.startYBA,
								myParent.rightPart.endXBA - rightDimC, myParent.rightPart.endYBA);
					
					bX2B = this.intersectX(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimB,
								myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimB,
								myParent.rightPart.startXBA - rightDimB, myParent.rightPart.startYBA,
								myParent.rightPart.endXBA - rightDimB, myParent.rightPart.endYBA);
					
					bX2A = this.intersectX(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimA,
								myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimA,
								myParent.rightPart.startXBA - rightDimA, myParent.rightPart.startYBA,
								myParent.rightPart.endXBA - rightDimA, myParent.rightPart.endYBA);
					
					myShape.bY2 = bY2 = this.intersectY(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimC,
								myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimC,
								myParent.rightPart.startXBA - rightDimC, myParent.rightPart.startYBA,
								myParent.rightPart.endXBA - rightDimC, myParent.rightPart.endYBA);
					
					bY2B = this.intersectY(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimB,
								myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimB,
								myParent.rightPart.startXBA - rightDimB, myParent.rightPart.startYBA,
								myParent.rightPart.endXBA - rightDimB, myParent.rightPart.endYBA);
					
					bY2A = this.intersectY(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimA,
								myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimA,
								myParent.rightPart.startXBA - rightDimA, myParent.rightPart.startYBA,
								myParent.rightPart.endXBA - rightDimA, myParent.rightPart.endYBA);
					
				}
				else
				{
					if (myParent.noSidesBot == 1)
					{
						
						myShape.bX2 = bX2 = this.intersectX(myParent.top1Part.startXBA, myParent.top1Part.startYBA
									+ top1DimC, myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimC,
									myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimC,
									myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimC);
						
						bX2B = this.intersectX(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimB,
									myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimB,
									myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimB,
									myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimB);
						
						bX2A = this.intersectX(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimA,
									myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimA,
									myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimA,
									myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimA);
						
						myShape.bY2 = bY2 = this.intersectY(myParent.top1Part.startXBA, myParent.top1Part.startYBA
									+ top1DimC, myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimC,
									myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimC,
									myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimC);
						
						bY2B = this.intersectY(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimB,
									myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimB,
									myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimB,
									myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimB);
						
						bY2A = this.intersectY(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimA,
									myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimA,
									myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimA,
									myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimA);
						
					}
					else if (myParent.noSidesBot == 2)
					{
						
						myShape.bX2 = bX2 = this.intersectX(myParent.top1Part.startXBA + top1DimC,
									myParent.top1Part.startYBA, myParent.top1Part.endXBA + top1DimC,
									myParent.top1Part.endYBA, myParent.bot1Part.startXBA, myParent.bot1Part.startYBA
												- bot1DimC, myParent.bot1Part.endXBA, myParent.bot1Part.endYBA
												- bot1DimC);
						
						bX2B = this.intersectX(myParent.top1Part.startXBA + top1DimB, myParent.top1Part.startYBA,
									myParent.top1Part.endXBA + top1DimB, myParent.top1Part.endYBA,
									myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimB,
									myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimB);
						
						bX2A = this.intersectX(myParent.top1Part.startXBA + top1DimA, myParent.top1Part.startYBA,
									myParent.top1Part.endXBA + top1DimA, myParent.top1Part.endYBA,
									myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimA,
									myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimA);
						
						myShape.bY2 = bY2 = this.intersectY(myParent.top1Part.startXBA + top1DimC,
									myParent.top1Part.startYBA, myParent.top1Part.endXBA + top1DimC,
									myParent.top1Part.endYBA, myParent.bot1Part.startXBA, myParent.bot1Part.startYBA
												- bot1DimC, myParent.bot1Part.endXBA, myParent.bot1Part.endYBA
												- bot1DimC);
						
						bY2B = this.intersectY(myParent.top1Part.startXBA + top1DimB, myParent.top1Part.startYBA,
									myParent.top1Part.endXBA + top1DimB, myParent.top1Part.endYBA,
									myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimB,
									myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimB);
						
						bY2A = this.intersectY(myParent.top1Part.startXBA + top1DimA, myParent.top1Part.startYBA,
									myParent.top1Part.endXBA + top1DimA, myParent.top1Part.endYBA,
									myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimA,
									myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimA);
						
					}
					else if (myParent.noSidesBot == 3)
					{
						
						myShape.bX2 = bX2 = this.intersectX(myParent.top1Part.startXBA + top1DimC,
									myParent.top1Part.startYBA, myParent.top1Part.endXBA + top1DimC,
									myParent.top1Part.endYBA, myParent.bot3Part.startXBA, myParent.bot3Part.startYBA
												- bot3DimC, myParent.bot3Part.endXBA, myParent.bot3Part.endYBA
												- bot3DimC);
						
						bX2B = this.intersectX(myParent.top1Part.startXBA + top1DimB, myParent.top1Part.startYBA,
									myParent.top1Part.endXBA + top1DimB, myParent.top1Part.endYBA,
									myParent.bot3Part.startXBA, myParent.bot3Part.startYBA - bot3DimB,
									myParent.bot3Part.endXBA, myParent.bot3Part.endYBA - bot3DimB);
						
						bX2A = this.intersectX(myParent.top1Part.startXBA + top1DimA, myParent.top1Part.startYBA,
									myParent.top1Part.endXBA + top1DimA, myParent.top1Part.endYBA,
									myParent.bot3Part.startXBA, myParent.bot3Part.startYBA - bot3DimA,
									myParent.bot3Part.endXBA, myParent.bot3Part.endYBA - bot3DimA);
						
						myShape.bY2 = bY2 = this.intersectY(myParent.top1Part.startXBA + top1DimC,
									myParent.top1Part.startYBA, myParent.top1Part.endXBA + top1DimC,
									myParent.top1Part.endYBA, myParent.bot3Part.startXBA, myParent.bot3Part.startYBA,
									myParent.bot3Part.endXBA - bot3DimC, myParent.bot3Part.endYBA - bot3DimC);
						
						bY2B = this.intersectY(myParent.top1Part.startXBA + top1DimB, myParent.top1Part.startYBA,
									myParent.top1Part.endXBA + top1DimB, myParent.top1Part.endYBA,
									myParent.bot3Part.startXBA, myParent.bot3Part.startYBA, myParent.bot3Part.endXBA
												- bot3DimB, myParent.bot3Part.endYBA - bot3DimB);
						
						bY2A = this.intersectY(myParent.top1Part.startXBA + top1DimA, myParent.top1Part.startYBA,
									myParent.top1Part.endXBA + top1DimA, myParent.top1Part.endYBA,
									myParent.bot3Part.startXBA, myParent.bot3Part.startYBA, myParent.bot3Part.endXBA
												- bot3DimA, myParent.bot3Part.endYBA - bot3DimA);
						
					}
				}
				
			}
			if (myParent.noSidesTop > 1)
			{
				if (myParent.noSidesRight > 0)
				{
					
					myShape.bX2 = bX2 = this.intersectX(myParent.top2Part.startXBA, myParent.top2Part.startYBA + top2DimC,
								myParent.top2Part.endXBA, myParent.top2Part.endYBA + top2DimC,
								myParent.rightPart.startXBA - rightDimC, myParent.rightPart.startYBA,
								myParent.rightPart.endXBA - rightDimC, myParent.rightPart.endYBA);
					
					bX2B = this.intersectX(myParent.top2Part.startXBA, myParent.top2Part.startYBA + top2DimB,
								myParent.top2Part.endXBA, myParent.top2Part.endYBA + top2DimB,
								myParent.rightPart.startXBA - rightDimB, myParent.rightPart.startYBA,
								myParent.rightPart.endXBA - rightDimB, myParent.rightPart.endYBA);
					
					bX2A = this.intersectX(myParent.top2Part.startXBA, myParent.top2Part.startYBA + top2DimA,
								myParent.top2Part.endXBA, myParent.top2Part.endYBA + top2DimA,
								myParent.rightPart.startXBA - rightDimA, myParent.rightPart.startYBA,
								myParent.rightPart.endXBA - rightDimA, myParent.rightPart.endYBA);
					
					myShape.bY2 = bY2 = this.intersectY(myParent.top2Part.startXBA, myParent.top2Part.startYBA + top2DimC,
								myParent.top2Part.endXBA, myParent.top2Part.endYBA + top2DimC,
								myParent.rightPart.startXBA - rightDimC, myParent.rightPart.startYBA,
								myParent.rightPart.endXBA - rightDimC, myParent.rightPart.endYBA);
					
					bY2B = this.intersectY(myParent.top2Part.startXBA, myParent.top2Part.startYBA + top2DimB,
								myParent.top2Part.endXBA, myParent.top2Part.endYBA + top2DimB,
								myParent.rightPart.startXBA - rightDimB, myParent.rightPart.startYBA,
								myParent.rightPart.endXBA - rightDimB, myParent.rightPart.endYBA);
					
					bY2A = this.intersectY(myParent.top2Part.startXBA, myParent.top2Part.startYBA + top2DimA,
								myParent.top2Part.endXBA, myParent.top2Part.endYBA + top2DimA,
								myParent.rightPart.startXBA - rightDimA, myParent.rightPart.startYBA,
								myParent.rightPart.endXBA - rightDimA, myParent.rightPart.endYBA);
					
				}
				else if (myParent.noSidesBot == 1)
				{
					
					myShape.bX2 = bX2 = this.intersectX(myParent.top2Part.startXBA - top2DimC, myParent.top2Part.startYBA,
								myParent.top2Part.endXBA - top2DimC, myParent.top2Part.endYBA,
								myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimC,
								myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimC);
					
					bX2B = this.intersectX(myParent.top2Part.startXBA - top2DimB, myParent.top2Part.startYBA,
								myParent.top2Part.endXBA - top2DimB, myParent.top2Part.endYBA,
								myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimB,
								myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimB);
					
					bX2A = this.intersectX(myParent.top2Part.startXBA - top2DimA, myParent.top2Part.startYBA,
								myParent.top2Part.endXBA - top2DimA, myParent.top2Part.endYBA,
								myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimA,
								myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimA);
					
					myShape.bY2 = bY2 = this.intersectY(myParent.top2Part.startXBA - top2DimC, myParent.top2Part.startYBA,
								myParent.top2Part.endXBA - top2DimC, myParent.top2Part.endYBA,
								myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimC,
								myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimC);
					
					bY2B = this.intersectY(myParent.top2Part.startXBA - top2DimB, myParent.top2Part.startYBA,
								myParent.top2Part.endXBA - top2DimB, myParent.top2Part.endYBA,
								myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimB,
								myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimB);
					
					bY2A = this.intersectY(myParent.top2Part.startXBA - top2DimA, myParent.top2Part.startYBA,
								myParent.top2Part.endXBA - top2DimA, myParent.top2Part.endYBA,
								myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimA,
								myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimA);
					
				}
				else if (myParent.noSidesBot == 2)
				{
					
					myShape.bX2 = bX2 = this.intersectX(myParent.top2Part.startXBA - top2DimC, myParent.top2Part.startYBA,
								myParent.top2Part.endXBA - top2DimC, myParent.top2Part.endYBA,
								myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimC,
								myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimC);
					
					bX2B = this.intersectX(myParent.top2Part.startXBA - top2DimB, myParent.top2Part.startYBA,
								myParent.top2Part.endXBA - top2DimB, myParent.top2Part.endYBA,
								myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimB,
								myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimB);
					bX2A = this.intersectX(myParent.top2Part.startXBA - top2DimA, myParent.top2Part.startYBA,
								myParent.top2Part.endXBA - top2DimA, myParent.top2Part.endYBA,
								myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimA,
								myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimA);
					
					myShape.bY2 = bY2 = this.intersectY(myParent.top2Part.startXBA - top2DimC, myParent.top2Part.startYBA,
								myParent.top2Part.endXBA - top2DimC, myParent.top2Part.endYBA,
								myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimC,
								myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimC);
					
					bY2B = this.intersectY(myParent.top2Part.startXBA - top2DimB, myParent.top2Part.startYBA,
								myParent.top2Part.endXBA - top2DimB, myParent.top2Part.endYBA,
								myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimB,
								myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimB);
					
					bY2A = this.intersectY(myParent.top2Part.startXBA - top2DimA, myParent.top2Part.startYBA,
								myParent.top2Part.endXBA - top2DimA, myParent.top2Part.endYBA,
								myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimA,
								myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimA);
					
				}
				else if (myParent.noSidesBot == 3)
				{
					
					myShape.bX2 = bX2 = this.intersectX(myParent.top2Part.startXBA - top2DimC, myParent.top2Part.startYBA,
								myParent.top2Part.endXBA - top2DimC, myParent.top2Part.endYBA,
								myParent.bot3Part.startXBA, myParent.bot3Part.startYBA - bot3DimC,
								myParent.bot3Part.endXBA, myParent.bot3Part.endYBA - bot3DimC);
					
					bX2B = this.intersectX(myParent.top2Part.startXBA - top2DimB, myParent.top2Part.startYBA,
								myParent.top2Part.endXBA - top2DimB, myParent.top2Part.endYBA,
								myParent.bot3Part.startXBA, myParent.bot3Part.startYBA - bot3DimB,
								myParent.bot3Part.endXBA, myParent.bot3Part.endYBA - bot3DimB);
					
					bX2A = this.intersectX(myParent.top2Part.startXBA - top2DimA, myParent.top2Part.startYBA,
								myParent.top2Part.endXBA - top2DimA, myParent.top2Part.endYBA,
								myParent.bot3Part.startXBA, myParent.bot3Part.startYBA - bot3DimA,
								myParent.bot3Part.endXBA, myParent.bot3Part.endYBA - bot3DimA);
					
					myShape.bY2 = bY2 = this.intersectY(myParent.top2Part.startXBA - top2DimC, myParent.top2Part.startYBA,
								myParent.top2Part.endXBA - top2DimC, myParent.top2Part.endYBA,
								myParent.bot3Part.startXBA, myParent.bot3Part.startYBA - bot3DimC,
								myParent.bot3Part.endXBA, myParent.bot3Part.endYBA - bot3DimC);
					
					bY2B = this.intersectY(myParent.top2Part.startXBA - top2DimB, myParent.top2Part.startYBA,
								myParent.top2Part.endXBA - top2DimB, myParent.top2Part.endYBA,
								myParent.bot3Part.startXBA, myParent.bot3Part.startYBA - bot3DimB,
								myParent.bot3Part.endXBA, myParent.bot3Part.endYBA - bot3DimB);
					
					bY2A = this.intersectY(myParent.top2Part.startXBA - top2DimA, myParent.top2Part.startYBA,
								myParent.top2Part.endXBA - top2DimA, myParent.top2Part.endYBA,
								myParent.bot3Part.startXBA, myParent.bot3Part.startYBA - bot3DimA,
								myParent.bot3Part.endXBA, myParent.bot3Part.endYBA - bot3DimA);
					
				}
				
			}
			// /////// X3,Y3
			if (myParent.noSidesBot <= 2)
			{
				if (myParent.noSidesRight > 0)
				{
					
					myShape.bX3 = bX3 = this.intersectX(myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimC,
								myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimC,
								myParent.rightPart.startXBA - rightDimC, myParent.rightPart.startYBA,
								myParent.rightPart.endXBA - rightDimC, myParent.rightPart.endYBA);
					
					bX3B = this.intersectX(myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimB,
								myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimB,
								myParent.rightPart.startXBA - rightDimB, myParent.rightPart.startYBA,
								myParent.rightPart.endXBA - rightDimB, myParent.rightPart.endYBA);
					
					bX3A = this.intersectX(myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimA,
								myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimA,
								myParent.rightPart.startXBA - rightDimA, myParent.rightPart.startYBA,
								myParent.rightPart.endXBA - rightDimA, myParent.rightPart.endYBA);
					
					myShape.bY3 = bY3 = this.intersectY(myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimC,
								myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimC,
								myParent.rightPart.startXBA - rightDimC, myParent.rightPart.startYBA,
								myParent.rightPart.endXBA - rightDimC, myParent.rightPart.endYBA);
					
					bY3B = this.intersectY(myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimB,
								myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimB,
								myParent.rightPart.startXBA - rightDimB, myParent.rightPart.startYBA,
								myParent.rightPart.endXBA - rightDimB, myParent.rightPart.endYBA);
					
					bY3A = this.intersectY(myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimA,
								myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimA,
								myParent.rightPart.startXBA - rightDimA, myParent.rightPart.startYBA,
								myParent.rightPart.endXBA - rightDimA, myParent.rightPart.endYBA);
					
				}
				else if (myParent.noSidesRight == 0)
				{
					if (myParent.noSidesTop == 1)
					{
						
						myShape.bX3 = myShape.bX2;
						myShape.bY3 = myShape.bY2;
						bX3B = bX2B;
						bY3B = bY2B;
						bX3A = bX2A;
						bY3A = bY2A;
						
					}
					else if (myParent.noSidesTop > 1)
					{
						myShape.bX3 = myShape.bX2;
						myShape.bY3 = myShape.bY2;
						bX3B = bX2B;
						bY3B = bY2B;
						bX3A = bX2A;
						bY3A = bY2A;
						
					}
					
				}
				
			}
			else if (myParent.noSidesBot == 3)
			{
				if (myParent.noSidesRight > 0)
				{
					
					myShape.bX3 = this.intersectX(myParent.bot3Part.startXBA, myParent.bot3Part.startYBA - bot3DimC,
								myParent.bot3Part.endXBA, myParent.bot3Part.endYBA - bot3DimC,
								myParent.rightPart.startXBA - rightDimC, myParent.rightPart.startYBA,
								myParent.rightPart.endXBA - rightDimC, myParent.rightPart.endYBA);
					
					bX3B = this.intersectX(myParent.bot3Part.startXBA, myParent.bot3Part.startYBA - bot3DimB,
								myParent.bot3Part.endXBA, myParent.bot3Part.endYBA - bot3DimB,
								myParent.rightPart.startXBA - rightDimB, myParent.rightPart.startYBA,
								myParent.rightPart.endXBA - rightDimB, myParent.rightPart.endYBA);
					
					bX3A = this.intersectX(myParent.bot3Part.startXBA, myParent.bot3Part.startYBA - bot3DimA,
								myParent.bot3Part.endXBA, myParent.bot3Part.endYBA - bot3DimA,
								myParent.rightPart.startXBA - rightDimA, myParent.rightPart.startYBA,
								myParent.rightPart.endXBA - rightDimA, myParent.rightPart.endYBA);
					
					myShape.bY3 = this.intersectY(myParent.bot3Part.startXBA, myParent.bot3Part.startYBA - bot3DimC,
								myParent.bot3Part.endXBA, myParent.bot3Part.endYBA - bot3DimC,
								myParent.rightPart.startXBA - rightDimC, myParent.rightPart.startYBA,
								myParent.rightPart.endXBA - rightDimC, myParent.rightPart.endYBA);
					
					bY3B = this.intersectY(myParent.bot3Part.startXBA, myParent.bot3Part.startYBA - bot3DimB,
								myParent.bot3Part.endXBA, myParent.bot3Part.endYBA - bot3DimB,
								myParent.rightPart.startXBA - rightDimB, myParent.rightPart.startYBA,
								myParent.rightPart.endXBA - rightDimB, myParent.rightPart.endYBA);
					
					bY3A = this.intersectY(myParent.bot3Part.startXBA, myParent.bot3Part.startYBA - bot3DimA,
								myParent.bot3Part.endXBA, myParent.bot3Part.endYBA - bot3DimA,
								myParent.rightPart.startXBA - rightDimA, myParent.rightPart.startYBA,
								myParent.rightPart.endXBA - rightDimA, myParent.rightPart.endYBA);
					
				}
				else if (myParent.noSidesRight == 0)
				{
					if (myParent.noSidesTop == 1)
					{
						myShape.bX3 = myShape.bX2;
						myShape.bY3 = myShape.bY2;
						bX3B = bX2B;
						bY3B = bY2B;
						bX3A = bX2A;
						bY3A = bY2A;
						
					}
					else if (myParent.noSidesTop > 1)
					{
						myShape.bX3 = myShape.bX2;
						myShape.bY3 = myShape.bY2;
						bX3B = bX2B;
						bY3B = bY2B;
						bX3A = bX2A;
						bY3A = bY2A;
						
					}
					
				}
				
			}
			// /////// X4,Y4
			if (myParent.noSidesBot == 1)
			{
				
				if (myParent.noSidesLeft > 0)
				{
					myShape.bX4 = bX4 = this.intersectX(myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimC,
								myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimC, myParent.leftPart.startXBA
											+ leftDimC, myParent.leftPart.startYBA, myParent.leftPart.endXBA
											+ leftDimC, myParent.leftPart.endYBA);
					
					bX4B = this.intersectX(myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimB,
								myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimB, myParent.leftPart.startXBA
											+ leftDimB, myParent.leftPart.startYBA, myParent.leftPart.endXBA
											+ leftDimB, myParent.leftPart.endYBA);
					
					bX4A = this.intersectX(myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimA,
								myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimA, myParent.leftPart.startXBA
											+ leftDimA, myParent.leftPart.startYBA, myParent.leftPart.endXBA
											+ leftDimA, myParent.leftPart.endYBA);
					
					myShape.bY4 = bY4 = this.intersectY(myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimC,
								myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimC, myParent.leftPart.startXBA
											+ leftDimC, myParent.leftPart.startYBA, myParent.leftPart.endXBA
											+ leftDimC, myParent.leftPart.endYBA);
					
					bY4B = this.intersectY(myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimB,
								myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimB, myParent.leftPart.startXBA
											+ leftDimB, myParent.leftPart.startYBA, myParent.leftPart.endXBA
											+ leftDimB, myParent.leftPart.endYBA);
					
					bY4A = this.intersectY(myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimA,
								myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimA, myParent.leftPart.startXBA
											+ leftDimA, myParent.leftPart.startYBA, myParent.leftPart.endXBA
											+ leftDimA, myParent.leftPart.endYBA);
					
				}
				else if (myParent.noSidesLeft == 0)
				{
					
					myShape.bX4 = myShape.startingX;
					myShape.bY4 = myShape.startingY;
					bX4B = bX1B;
					bY4B = bY1B;
					bX4A = bX1A;
					bY4A = bY1A;
					
				}
				
			}
			else if (myParent.noSidesBot > 1)
			{
				if (myParent.noSidesLeft > 0)
				{
					
					myShape.bX4 = this.intersectX(myParent.bot2Part.startXBA, myParent.bot2Part.startYBA - bot2DimC,
								myParent.bot2Part.endXBA, myParent.bot2Part.endYBA - bot2DimC, myParent.leftPart.startXBA
											+ leftDimC, myParent.leftPart.startYBA, myParent.leftPart.endXBA
											+ leftDimC, myParent.leftPart.endYBA);
					
					bX4B = this.intersectX(myParent.bot2Part.startXBA, myParent.bot2Part.startYBA - bot2DimB,
								myParent.bot2Part.endXBA, myParent.bot2Part.endYBA - bot2DimB, myParent.leftPart.startXBA
											+ leftDimB, myParent.leftPart.startYBA, myParent.leftPart.endXBA
											+ leftDimB, myParent.leftPart.endYBA);
					
					bX4A = this.intersectX(myParent.bot2Part.startXBA, myParent.bot2Part.startYBA - bot2DimA,
								myParent.bot2Part.endXBA, myParent.bot2Part.endYBA - bot2DimA, myParent.leftPart.startXBA
											+ leftDimA, myParent.leftPart.startYBA, myParent.leftPart.endXBA
											+ leftDimA, myParent.leftPart.endYBA);
					
					myShape.bY4 = this.intersectY(myParent.bot2Part.startXBA, myParent.bot2Part.startYBA - bot2DimC,
								myParent.bot2Part.endXBA, myParent.bot2Part.endYBA - bot2DimC, myParent.leftPart.startXBA
											+ leftDimC, myParent.leftPart.startYBA, myParent.leftPart.endXBA
											+ leftDimC, myParent.leftPart.endYBA);
					
					bY4B = this.intersectY(myParent.bot2Part.startXBA, myParent.bot2Part.startYBA - bot2DimB,
								myParent.bot2Part.endXBA, myParent.bot2Part.endYBA - bot2DimB, myParent.leftPart.startXBA
											+ leftDimB, myParent.leftPart.startYBA, myParent.leftPart.endXBA
											+ leftDimB, myParent.leftPart.endYBA);
					
					bY4A = this.intersectY(myParent.bot2Part.startXBA, myParent.bot2Part.startYBA - bot2DimA,
								myParent.bot2Part.endXBA, myParent.bot2Part.endYBA - bot2DimA, myParent.leftPart.startXBA
											+ leftDimA, myParent.leftPart.startYBA, myParent.leftPart.endXBA
											+ leftDimA, myParent.leftPart.endYBA);
					
				}
				else if (myParent.noSidesLeft == 0)
				{
					
					myShape.bX4 = myShape.startingX;
					myShape.bY4 = myShape.startingY;
					
					bX4B = bX1B;
					bY4B = bY1B;
					bX4A = bX1A;
					bY4A = bY1A;
					
				}
				
			}
			// ////////////////////////
			
			this.geMultiSideIntersections();
		}
		// ////////////////////////
		if (myParent.shapeID == 800 || myParent.shapeID == 801 || myParent.shapeID == 802)
		{
			myShape.startingY = bY1 = myParent.bY4 - myParent.bot1Part.partDimB - myShape.clearanceBot + bot1DimC;
			
			bY1B = myParent.bY4 - myParent.bot1Part.partDimB - myShape.clearanceBot + bot1DimB;
			
			bY1A = myParent.bY4 - myParent.bot1Part.partDimB - myShape.clearanceBot + bot1DimA;
		}
		myShape.startingY = Math.min(bY1, bY2);
		myShape.startingX = Math.min(bX1, bX4);
		myShape.widthPix = wt = Math.max(myShape.bX2, myShape.bX3) - Math.min(myShape.startingX, myShape.bX4);
		
		if (!myShape.topIn)
		{
			myShape.highestY = myParent.highestY + top1Clearance - myShape.top1Part.partDimC;
		}
		else
		{
			if (myShape.noSidesTop == 1)
			{
				myShape.highestY = Math.min(py1, py2);
			}
			else if (myShape.noSidesTop == 2)
			{
				myShape.highestY = Math.min(py1, Math.min(py2, py3));
			}
			else if (myShape.noSidesTop == 3)
			{
				myShape.highestY = Math.min(py1, Math.min(py2, Math.min(py3, py4)));
			}
			
		}
		if (myShape.lowestY == 0)
		{
			myShape.lowestY = Math.max(myParent.bY3, myParent.bY4);
		}
		if (!myShape.botIn)
		{
			myShape.lowestY = myParent.lowestY - bot1Clearance + myShape.bot1Part.partDimC;
		}
		else
		{
			
			myShape.lowestY = Math.max(py1, Math.max(py2, Math.max(py3, Math.max(py4, Math.max(py5, Math.max(py6, Math.max(
						py7, py8)))))));
			
		}
		if (myShape.a_levelID > 3)
		{
			myShape.lowestY = myShape.lowestY - bot1Clearance + myShape.bot1Part.partDimC;
			myShape.highestY = myShape.highestY + top1Clearance - myShape.top1Part.partDimC;
			
			myShape.heightPix = hl = myShape.lowestY - myParent.highestY - (top1Clearance + bot1Clearance)
						+ myShape.top1Part.partDimC + myShape.bot1Part.partDimC;
			
		}
		else
		{
			myShape.lowestY = myShape.lowestY - myShape.bot1Part.partDimB;
			myShape.highestY = myShape.highestY + myShape.top1Part.partDimB;
			myShape.heightPix = hl = myShape.lowestY - myParent.highestY - (top1Clearance + bot1Clearance);
			
		}
		
		if (myParent.noSidesTop > 1)
		{
			if (myParent.noSidesTop >= 2)
			{
				myShape.dimA1 = t1t2X - bX1;
				myShape.dimA2 = bX2 - t1t2X;
			}
			if (myParent.noSidesTop == 3)
			{
				myShape.dimA1 = t1t3X - bX1;
				myShape.dimA2 = bX2 - t3t2X;
				myShape.dimA3 = t3t2X - t1t3X;
			}
		}
		else
		{
			if (myShape.lean == 0)
			{
				myShape.dimA1 = 0;
				myShape.dimA2 = 0;
				myShape.dimA3 = 0;
				myShape.dimA0 = 0;
			}
			else if (myShape.lean == 2)
			{
				myShape.dimA2 = bX2 - bX1;
				myShape.dimA1 = Math.max(wt, wb) - myShape.dimA2;
			}
			else if (myShape.lean == 1)
			{
				myShape.dimA1 = bX2 - bX1;
				myShape.dimA2 = Math.max(wt, wb) - myShape.dimA1;
			}
			else if (myShape.lean == 3)
			{
				
				myShape.dimA0 = bX1 - bX4;
				myShape.dimA2 = bX3 - bX2;
				myShape.dimA1 = Math.max(wt, wb) - (myShape.dimA2 + myShape.dimA0);
			}
		}
		
		if (myShape.lean2 == 0)
		{
			myShape.dimB2 = 0;
			myShape.dimB1 = 0;
			myShape.dimB0 = 0;
		}
		else if (myShape.lean2 == 2)
		{
			myShape.dimB2 = bY3 - bY2;
			myShape.dimB1 = Math.max(hl, hr) - myShape.dimB2;
		}
		else if (myShape.lean2 == 1)
		{
			myShape.dimB1 = bY3 - bY2;
			myShape.dimB2 = Math.max(hl, hr) - myShape.dimB1;
		}
		else if (myShape.lean2 == 3)
		{
			myShape.dimB0 = bY2 - bY1;
			myShape.dimB1 = bY3 - bY2;
			myShape.dimB2 = Math.max(hl, hr) - (myShape.dimB1 + myShape.dimB0);
		}
		
		if (myParent.noSidesBot > 1)
		{
			if (myParent.noSidesBot == 2)
			{
				myShape.dimC1 = bX3 - b1b2X;
				myShape.dimC2 = b1b2X - bX4;
			}
			if (myParent.noSidesBot == 3)
			{
				myShape.dimC3 = bX3 - b1b3X;
				myShape.dimC1 = b1b3X - b1b2X;
				myShape.dimC2 = b1b2X - bX4;
			}
		}
		else
		{
			if (myShape.lean3 == 0)
			{
				myShape.dimC1 = 0;
				myShape.dimC2 = 0;
				myShape.dimC3 = 0;
				myShape.dimC0 = 0;
			}
			else if (myShape.lean3 == 2)
			{
				myShape.dimC2 = bX3 - bX4;
				myShape.dimC1 = Math.max(wt, wb) - myShape.dimC2;
			}
			else if (myShape.lean3 == 1)
			{
				myShape.dimC1 = bX3 - bX4;
				myShape.dimC2 = Math.max(wt, wb) - myShape.dimC1;
			}
			if (myShape.lean3 == 3)
			{
				myShape.dimC0 = bX2 - bX3;
				myShape.dimC2 = bX4 - bX1;
				myShape.dimC1 = Math.max(wt, wb) - (myShape.dimC2 + myShape.dimC0);
			}
		}
		
		myShape.dimD1 = bY4 - bY1;
		
		if (myShape.lean4 == 0)
		{
			myShape.dimD1 = 0;
			myShape.dimD2 = 0;
			myShape.dimD0 = 0;
		}
		if (myShape.lean4 == 1)
		{
			myShape.dimD1 = bY4 - bY1;
			myShape.dimD2 = Math.max(hl, hr) - myShape.dimD1;
		}
		if (myShape.lean4 == 2)
		{
			myShape.dimD2 = bY4 - bY1;
			myShape.dimD1 = Math.max(hl, hr) - myShape.dimD2;
		}
		if (myShape.lean4 == 3)
		{
			myShape.dimD0 = bY3 - bY4;
			myShape.dimD2 = bY2 - bY1;
			myShape.dimD1 = Math.max(hl, hr) - (myShape.dimD2 + myShape.dimD0);
		}
		
		if (myShape.top1.partForm > 1 || myShape.top1Part.partForm > 1)
		{
			if (myShape.highestY < bY1)
			{
				myShape.dimD2 = bY1 - myShape.highestY;
			}
			if (myShape.highestY < bY2)
			{
				myShape.dimB1 = bY2 - myShape.highestY;
			}
		}
		if (myShape.bot1.partForm > 1 || myShape.bot1Part.partForm > 1)
		{
			if (myShape.lowestY > bY4)
			{
				if (myShape.dimD0 > 0)
				{
					myShape.dimD0 = myShape.lowestY - bY4;
				}
				else
				{
					myShape.dimD1 = myShape.lowestY - bY4;
				}
			}
			if (myShape.lowestY < bY2)
			{
				myShape.dimB2 = myShape.lowestY - bY2;
			}
		}
		
		myShape.bkgrdStartX = Math.min(bX1, bX4);
		myShape.bkgrdStartY = Math.min(bY1, bY2);
		
		myShape.radius1 = myParent.radius1 - myShape.clearanceTop + top1DimC;
		myShape.radius2 = myParent.radius2 - myShape.clearanceTop + top1DimC;
		
		myShape.top1 = new Top1Object(myShape, true);
		myShape.top2 = new Top2Object(myShape, true);
		myShape.top3 = new Top3Object(myShape, true);
		myShape.bot1 = new Bot1Object(myShape, true);
		myShape.bot2 = new Bot2Object(myShape, true);
		myShape.bot3 = new Bot3Object(myShape, true);
		myShape.left = new LeftObject(myShape, true);
		myShape.right = new RightObject(myShape, true);
		
		if (myParent.dimB1 > myParent.radius1)
		{
			myParent.dimB1 = myParent.radius1;
			
		}
		if (myParent.dimD2 > myParent.radius1)
		{
			myParent.dimD2 = myParent.radius1;
		}
		
		if (myParent.noSidesTop == 1 && myParent.top1Part.partForm >= 2 && myParent.dimB1 == myParent.dimD2
					&& myParent.dimB1 == myParent.radius1 && myParent.rightPart.posInUse && myParent.leftPart.posInUse)
		{
			if (!myShape.rightIn)
			{
				myShape.bY2 = bY2 = bY2B = bY2A = myParent.rightPart.startYC;
			}
			if (!myShape.leftIn)
			{
				myShape.startingY = bY1 = bY1B = bY1A = myParent.leftPart.endYC;
			}
		}
		if (myParent.noSidesTop == 1 && myParent.top1Part.partForm >= 2
		
		&& myParent.dimD2 == myParent.radius1 && myParent.rightPart.posInUse && myParent.leftPart.posInUse)
		{
			
			if (!myShape.leftIn)
			{
				myShape.startingY = bY1 = bY1B = bY1A = myParent.leftPart.endYC;
			}
		}
		if (myParent.noSidesTop == 1 && myParent.top1Part.partForm >= 2
		
		&& myParent.dimB1 == myParent.radius1 && myParent.rightPart.posInUse && myParent.leftPart.posInUse)
		{
			if (!myShape.rightIn)
			{
				myShape.bY2 = bY2 = bY2B = bY2A = myParent.rightPart.startYC;
			}
			if (!myShape.leftIn)
			{
				myShape.startingY = bY1 = bY1B = bY1A = myParent.leftPart.endYC;
			}
		}
		if (myParent.noSidesTop == 2 && myParent.top1Part.partForm >= 2 && myParent.top2Part.partForm >= 2)
		{
			if (!myShape.rightIn)
			{
				myShape.bY2 = bY2 = bY2B = bY2A = myParent.rightPart.startYC;
			}
			if (!myShape.leftIn)
			{
				myShape.startingY = bY1 = bY1B = bY1A = myParent.leftPart.endYC;
			}
		}
		
		if (myParent.noSidesTop == 2 && myParent.top1Part.partForm >= 2 && myParent.top2Part.partForm == 1)
		{
			
			if (!myShape.leftIn)
			{
				myShape.startingY = bY1 = bY1B = bY1A = myParent.leftPart.endYC;
			}
		}
		if (myParent.noSidesTop == 2 && myParent.top1Part.partForm == 1 && myParent.top2Part.partForm >= 2)
		{
			
			if (!myShape.rightIn)
			{
				myShape.bY2 = bY2 = bY2B = bY2A = myParent.rightPart.startYC;
			}
		}
		if (myParent.noSidesTop == 3 && myParent.top1Part.partForm >= 2 && myParent.top2Part.partForm >= 2)
		{
			if (!myShape.rightIn)
			{
				myShape.bY2 = bY2 = bY2B = bY2A = myParent.rightPart.startYC;
			}
			if (!myShape.leftIn)
			{
				myShape.startingY = bY1 = bY1B = bY1A = myParent.leftPart.endYC;
			}
		}
		
		if (myParent.myMullionTop != null && myShape.topIn)
		{
			myShape.myMullionTop = myParent.myMullionTop;
		}
		if (myParent.myMullionBot != null && myShape.botIn)
		{
			myShape.myMullionBot = myParent.myMullionBot;
		}
		if (myParent.myMullionLeft != null && myShape.leftIn)
		{
			myShape.myMullionLeft = myParent.myMullionLeft;
		}
		if (myParent.myMullionRight != null && myShape.rightIn)
		{
			myShape.myMullionRight = myParent.myMullionRight;
		}
		if (myShape.topIn && myShape.myMullionTop != null)
		{
			myShape.highestYC = myShape.highestY - (myShape.highestY - myShape.myMullionTop.centerYs);
			
		}
		if (myShape.botIn && myShape.myMullionBot != null)
		{
			myShape.lowestYC = myShape.lowestY + myShape.myMullionBot.centerYs - myShape.lowestY;
			
		}
		
		return myShape;
	}
	
	public void geMultiSideIntersections()
	{
	
		if (myParent.noSidesTop == 2)
		{
			
			t1t2X = this.intersectX(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimC,
						myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimC, myParent.top2Part.startXBA,
						myParent.top2Part.startYBA + top2DimC, myParent.top2Part.endXBA, myParent.top2Part.endYBA
									+ top2DimC);
			
			t1t2XB = this.intersectX(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimB,
						myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimB, myParent.top2Part.startXBA,
						myParent.top2Part.startYBA + top2DimB, myParent.top2Part.endXBA, myParent.top2Part.endYBA
									+ top2DimB);
			
			t1t2XA = this.intersectX(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimA,
						myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimA, myParent.top2Part.startXBA,
						myParent.top2Part.startYBA + top2DimA, myParent.top2Part.endXBA, myParent.top2Part.endYBA
									+ top2DimA);
			
			t1t2Y = this.intersectY(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimC,
						myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimC, myParent.top2Part.startXBA,
						myParent.top2Part.startYBA + top2DimC, myParent.top2Part.endXBA, myParent.top2Part.endYBA
									+ top2DimC);
			
			t1t2YB = this.intersectY(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimB,
						myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimB, myParent.top2Part.startXBA,
						myParent.top2Part.startYBA + top2DimB, myParent.top2Part.endXBA, myParent.top2Part.endYBA
									+ top2DimB);
			
			t1t2YA = this.intersectY(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimA,
						myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimA, myParent.top2Part.startXBA,
						myParent.top2Part.startYBA + top2DimA, myParent.top2Part.endXBA, myParent.top2Part.endYBA
									+ top2DimA);
			
		}
		else if (myParent.noSidesTop == 3)
		{
			
			t1t3X = this.intersectX(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimC,
						myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimC, myParent.top3Part.startXBA,
						myParent.top3Part.startYBA + top3DimC, myParent.top3Part.endXBA, myParent.top3Part.endYBA
									+ top3DimC);
			
			t1t3XB = this.intersectX(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimB,
						myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimB, myParent.top3Part.startXBA,
						myParent.top3Part.startYBA + top3DimB, myParent.top3Part.endXBA, myParent.top3Part.endYBA
									+ top3DimB);
			
			t1t3XA = this.intersectX(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimA,
						myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimA, myParent.top3Part.startXBA,
						myParent.top3Part.startYBA + top3DimA, myParent.top3Part.endXBA, myParent.top3Part.endYBA
									+ top3DimA);
			
			t1t3Y = this.intersectY(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimC,
						myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimC, myParent.top3Part.startXBA,
						myParent.top3Part.startYBA + top3DimC, myParent.top3Part.endXBA, myParent.top3Part.endYBA
									+ top3DimC);
			
			t1t3YB = this.intersectY(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimB,
						myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimB, myParent.top3Part.startXBA,
						myParent.top3Part.startYBA + top3DimB, myParent.top3Part.endXBA, myParent.top3Part.endYBA
									+ top3DimB);
			
			t1t3YA = this.intersectY(myParent.top1Part.startXBA, myParent.top1Part.startYBA + top1DimA,
						myParent.top1Part.endXBA, myParent.top1Part.endYBA + top1DimA, myParent.top3Part.startXBA,
						myParent.top3Part.startYBA + top3DimA, myParent.top3Part.endXBA, myParent.top3Part.endYBA
									+ top3DimA);
			
			t3t2X = this.intersectX(myParent.top2Part.startXBA, myParent.top2Part.startYBA + top2DimC,
						myParent.top2Part.endXBA, myParent.top2Part.endYBA + top2DimC, myParent.top3Part.startXBA,
						myParent.top3Part.startYBA + top3DimC, myParent.top3Part.endXBA, myParent.top3Part.endYBA
									+ top3DimC);
			
			t3t2XB = this.intersectX(myParent.top2Part.startXBA, myParent.top2Part.startYBA + top2DimB,
						myParent.top2Part.endXBA, myParent.top2Part.endYBA + top2DimB, myParent.top3Part.startXBA,
						myParent.top3Part.startYBA + top3DimB, myParent.top3Part.endXBA, myParent.top3Part.endYBA
									+ top3DimB);
			
			t3t2XA = this.intersectX(myParent.top2Part.startXBA, myParent.top2Part.startYBA + top2DimA,
						myParent.top2Part.endXBA, myParent.top2Part.endYBA + top2DimA, myParent.top3Part.startXBA,
						myParent.top3Part.startYBA + top3DimA, myParent.top3Part.endXBA, myParent.top3Part.endYBA
									+ top3DimA);
			
			t3t2Y = this.intersectY(myParent.top2Part.startXBA, myParent.top2Part.startYBA + top2DimC,
						myParent.top2Part.endXBA, myParent.top2Part.endYBA + top2DimC, myParent.top3Part.startXBA,
						myParent.top3Part.startYBA + top3DimC, myParent.top3Part.endXBA, myParent.top3Part.endYBA
									+ top3DimC);
			
			t3t2YB = this.intersectY(myParent.top2Part.startXBA, myParent.top2Part.startYBA + top2DimB,
						myParent.top2Part.endXBA, myParent.top2Part.endYBA + top2DimB, myParent.top3Part.startXBA,
						myParent.top3Part.startYBA + top3DimB, myParent.top3Part.endXBA, myParent.top3Part.endYBA
									+ top3DimB);
			
			t3t2YA = this.intersectY(myParent.top2Part.startXBA, myParent.top2Part.startYBA + top2DimA,
						myParent.top2Part.endXBA, myParent.top2Part.endYBA + top2DimA, myParent.top3Part.startXBA,
						myParent.top3Part.startYBA + top3DimA, myParent.top3Part.endXBA, myParent.top3Part.endYBA
									+ top3DimA);
			
		}
		
		if (myParent.noSidesBot >= 2)
		{
			
			b1b2X = this.intersectX(myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimC,
						myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimC, myParent.bot2Part.startXBA,
						myParent.bot2Part.startYBA - bot2DimC, myParent.bot2Part.endXBA, myParent.bot2Part.endYBA
									- bot2DimC);
			
			b1b2XB = this.intersectX(myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimB,
						myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimB, myParent.bot2Part.startXBA,
						myParent.bot2Part.startYBA - bot2DimB, myParent.bot2Part.endXBA, myParent.bot2Part.endYBA
									- bot2DimB);
			
			b1b2XA = this.intersectX(myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimA,
						myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimA, myParent.bot2Part.startXBA,
						myParent.bot2Part.startYBA - bot2DimA, myParent.bot2Part.endXBA, myParent.bot2Part.endYBA
									- bot2DimA);
			
			b1b2Y = this.intersectY(myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimC,
						myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimC, myParent.bot2Part.startXBA,
						myParent.bot2Part.startYBA - bot2DimC, myParent.bot2Part.endXBA, myParent.bot2Part.endYBA
									- bot2DimC);
			
			b1b2YB = this.intersectY(myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimB,
						myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimB, myParent.bot2Part.startXBA,
						myParent.bot2Part.startYBA - bot2DimB, myParent.bot2Part.endXBA, myParent.bot2Part.endYBA
									- bot2DimB);
			
			b1b2YA = this.intersectY(myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimA,
						myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimA, myParent.bot2Part.startXBA,
						myParent.bot2Part.startYBA - bot2DimA, myParent.bot2Part.endXBA, myParent.bot2Part.endYBA
									- bot2DimA);
			
		}
		else if (myParent.noSidesBot == 3)
		{
			
			b1b3X = this.intersectX(myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimC,
						myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimC, myParent.bot3Part.startXBA,
						myParent.bot3Part.startYBA - bot3DimC, myParent.bot3Part.endXBA, myParent.bot3Part.endYBA
									- bot3DimC);
			
			b1b3XB = this.intersectX(myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimB,
						myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimB, myParent.bot3Part.startXBA,
						myParent.bot3Part.startYBA - bot3DimB, myParent.bot3Part.endXBA, myParent.bot3Part.endYBA
									- bot3DimB);
			
			b1b3XA = this.intersectX(myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimA,
						myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimA, myParent.bot3Part.startXBA,
						myParent.bot3Part.startYBA - bot3DimA, myParent.bot3Part.endXBA, myParent.bot3Part.endYBA
									- bot3DimA);
			
			b1b3Y = this.intersectY(myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimC,
						myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimC, myParent.bot3Part.startXBA,
						myParent.bot3Part.startYBA - bot3DimC, myParent.bot3Part.endXBA, myParent.bot3Part.endYBA
									- bot3DimC);
			
			b1b3YB = this.intersectY(myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimB,
						myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimB, myParent.bot3Part.startXBA,
						myParent.bot3Part.startYBA - bot3DimB, myParent.bot3Part.endXBA, myParent.bot3Part.endYBA
									- bot3DimB);
			
			b1b3YA = this.intersectY(myParent.bot1Part.startXBA, myParent.bot1Part.startYBA - bot1DimA,
						myParent.bot1Part.endXBA, myParent.bot1Part.endYBA - bot1DimA, myParent.bot3Part.startXBA,
						myParent.bot3Part.startYBA - bot3DimA, myParent.bot3Part.endXBA, myParent.bot3Part.endYBA
									- bot3DimA);
			
		}
	}
	
	public ShapeObject setTop1ArcInfo(final ShapeObject myShape, final int BorBA)
	{
	
		if (myParent.noSidesTop == 2 && myShape.leftIn && !myShape.topIn && myShape.leftPart.endXC >= myParent.top1Part.endXC)
		{
			if (BorBA == 1)
			{
				myShape.top1Part.radius1 = myParent.top2Part.radius1 - myShape.clearanceTop + top2DimCo;
				myShape.top1Part.radius2 = myParent.top2Part.radius2 - myShape.clearanceTop + top2DimCo;
				myShape.top1Part.radius1BA = myParent.top2Part.radius1 - myShape.clearanceTop - top2DimBo;
				myShape.top1Part.radius2BA = myParent.top2Part.radius2 - myShape.clearanceTop - top2DimBo;
				myShape.top1Part.radius1A = myShape.top2Part.radius1BA - top2DimAo;
				myShape.top1Part.radius2A = myShape.top2Part.radius2BA - top2DimAo;
				myShape.top1Part.radius1c = myParent.top2Part.radius1 + top2DimBo;
			}
			else if (BorBA == 2)
			{
				myShape.top1Part.radius1 = myParent.top2Part.radius1BA - myShape.clearanceTop + top2DimCo;
				myShape.top1Part.radius2 = myParent.top2Part.radius2BA - myShape.clearanceTop + top2DimCo;
				myShape.top1Part.radius1BA = myParent.top2Part.radius1BA - myShape.clearanceTop - top2DimBo;
				myShape.top1Part.radius2BA = myParent.top2Part.radius2BA - myShape.clearanceTop - top2DimBo;
				myShape.top1Part.radius1A = myShape.top2Part.radius1BA - top2DimAo;
				myShape.top1Part.radius2A = myShape.top2Part.radius2BA - top2DimAo;
				myShape.top1Part.radius1c = myParent.top2Part.radius1 + top2DimBo;
			}
			
		}
		else
		{
			if (BorBA == 1)
			{
				myShape.top1Part.radius1 = myParent.top1Part.radius1 - myShape.clearanceTop + top1DimCo;
				myShape.top1Part.radius2 = myParent.top1Part.radius2 - myShape.clearanceTop + top1DimCo;
				myShape.top1Part.radius1BA = myParent.top1Part.radius1 - myShape.clearanceTop - top1DimBo;
				myShape.top1Part.radius2BA = myParent.top1Part.radius2 - myShape.clearanceTop - top1DimBo;
				myShape.top1Part.radius1A = myShape.top1Part.radius1BA - top1DimAo;
				myShape.top1Part.radius2A = myShape.top1Part.radius2BA - top1DimAo;
				myShape.top1Part.radius1c = myParent.top2Part.radius1 + top2DimBo;
			}
			else if (BorBA == 2)
			{
				myShape.top1Part.radius1 = myParent.top1Part.radius1BA - myShape.clearanceTop + top1DimCo;
				myShape.top1Part.radius2 = myParent.top1Part.radius2BA - myShape.clearanceTop + top1DimCo;
				myShape.top1Part.radius1BA = myParent.top1Part.radius1BA - myShape.clearanceTop - top1DimBo;
				myShape.top1Part.radius2BA = myParent.top1Part.radius2BA - myShape.clearanceTop - top1DimBo;
				myShape.top1Part.radius1A = myShape.top1Part.radius1BA - top1DimAo;
				myShape.top1Part.radius2A = myShape.top1Part.radius2BA - top1DimAo;
				myShape.top1Part.radius1c = myParent.top2Part.radius1 + top2DimBo;
			}
		}
		myShape.radius1 = myShape.top1Part.radius1;
		myShape.radius2 = myShape.top1Part.radius2;
		
		myShape.top1Part.bkgrdWidth = myShape.top1Part.bkgrdHeight = myShape.top1Part.radius1 * 2;
		myShape.top1Part.bkgrdWidthBA = myShape.top1Part.bkgrdHeightBA = myShape.top1Part.radius1BA * 2;
		myShape.top1Part.bkgrdWidthA = myShape.top1Part.bkgrdHeightA = myShape.top1Part.radius1A * 2;
		if (myParent.noSidesTop == 2 && myShape.leftIn && !myShape.topIn && myShape.leftPart.endXC >= myParent.top1Part.endXC)
		{
			myShape.top1Part.x1 = myShape.top1Part.x1BA = myShape.top1Part.x1A = myParent.top2Part.x1;
			
			myShape.top1Part.y1 = myShape.top1Part.y1BA = myShape.top1Part.y1A = myParent.top2Part.y1;
			
			myShape.top1Part.x2 = myShape.top1Part.x2BA = myShape.top1Part.x2A = myParent.top2Part.x2;
			
			myShape.top1Part.y2 = myShape.top1Part.y2BA = myShape.top1Part.y2A = myParent.top2Part.y2;
			
		}
		else
		{
			myShape.top1Part.x1 = myShape.top1Part.x1BA = myShape.top1Part.x1A = myParent.top1Part.x1;
			
			myShape.top1Part.y1 = myShape.top1Part.y1BA = myShape.top1Part.y1A = myParent.top1Part.y1;
			
			myShape.top1Part.x2 = myShape.top1Part.x2BA = myShape.top1Part.x2A = myParent.top1Part.x2;
			
			myShape.top1Part.y2 = myShape.top1Part.y2BA = myShape.top1Part.y2A = myParent.top1Part.y2;
			
		}
		
		if (myShape.shapeID >= 800)
		{
			myShape.top1Part.x1 = myShape.top1Part.x1BA = myShape.top1Part.x1A = myShape.startingX + myShape.widthPix / 2;
			
			myShape.top1Part.y1 = myShape.top1Part.y1BA = myShape.top1Part.y1A = myShape.highestY + myShape.dimD2;
		}
		
		myShape.centerPointX = myShape.top1Part.x1;
		myShape.centerPointY = myShape.top1Part.y1;
		myShape.centerPointX2 = myShape.top1Part.x2;
		myShape.centerPointY2 = myShape.top1Part.y2;
		
		myShape.top1Part.bkgrdStartX = myShape.top1Part.x1 - myShape.radius1;
		
		myShape.top1Part.bkgrdStartY = myShape.top1Part.y1 - myShape.radius1;
		
		
		myShape.top1Part.bkgrdStartXBA = myShape.top1Part.x1 - myShape.top1Part.radius1BA;// myShape.top1Part.bkgrdStartX
		// +
		// top1DimCo
		// +
		// top1DimBo
		// ;
		
		myShape.top1Part.bkgrdStartYBA = myShape.top1Part.y1 - myShape.top1Part.radius1BA;
		
		myShape.top1Part.bkgrdStartXA = myShape.top1Part.x1 - myShape.top1Part.radius1A;
		
		myShape.top1Part.bkgrdStartYA = myShape.top1Part.y1 - myShape.top1Part.radius1A;
		
		myShape.bkgrdStartX = myShape.top1Part.bkgrdStartX;
		myShape.bkgrdStartY = myShape.top1Part.bkgrdStartY;
		
		myShape.bkgrdStartXA = myShape.top1Part.bkgrdStartXA;
		myShape.bkgrdStartYA = myShape.top1Part.bkgrdStartYA;
		
		return myShape;
	}
	
	public ShapeObject setTop2ArcInfo(final ShapeObject myShape, final int BorBA)
	{
	
		if (myShape.top2Part.partForm > 1)
		{
			if (myShape.noSidesTop >= 2)
			{
				if (BorBA == 1)
				{
					myShape.top2Part.radius1 = myParent.top2Part.radius1 - myShape.clearanceTop + top2DimCo;
					myShape.top2Part.radius2 = myParent.top2Part.radius2 - myShape.clearanceTop + top2DimCo;
					myShape.top2Part.radius1BA = myParent.top2Part.radius1 - myShape.clearanceTop - top2DimBo;
					myShape.top2Part.radius2BA = myParent.top2Part.radius2 - myShape.clearanceTop - top2DimBo;
					myShape.top2Part.radius1A = myShape.top2Part.radius1BA - top2DimAo;
					myShape.top2Part.radius2A = myShape.top2Part.radius2BA - top2DimAo;
					myShape.top2Part.radius1c = myParent.top2Part.radius1 + top2DimBo;
				}
				else if (BorBA == 2)
				{
					myShape.top2Part.radius1 = myParent.top2Part.radius1BA - myShape.clearanceTop + top2DimCo;
					myShape.top2Part.radius2 = myParent.top2Part.radius2BA - myShape.clearanceTop + top2DimCo;
					myShape.top2Part.radius1BA = myParent.top2Part.radius1BA - myShape.clearanceTop - top2DimBo;
					myShape.top2Part.radius2BA = myParent.top2Part.radius2BA - myShape.clearanceTop - top2DimBo;
					myShape.top2Part.radius1A = myShape.top2Part.radius1BA - top2DimAo;
					myShape.top2Part.radius2A = myShape.top2Part.radius2BA - top2DimAo;
					myShape.top2Part.radius1c = myParent.top2Part.radius1 + top2DimBo;
				}
				
				myShape.top2Part.bkgrdWidth = myShape.top2Part.bkgrdHeight = myShape.top2Part.radius1 * 2;
				myShape.top2Part.bkgrdWidthBA = myShape.top2Part.bkgrdHeightBA = myShape.top2Part.radius1BA * 2;
				myShape.top2Part.bkgrdWidthA = myShape.top2Part.bkgrdHeightA = myShape.top2Part.radius1A * 2;
				
				myShape.top2Part.x1 = myShape.top2Part.x1BA = myShape.top2Part.x1A = myParent.top2Part.x1;
				
				myShape.top2Part.y1 = myShape.top2Part.y1BA = myShape.top2Part.y1A = myParent.top2Part.y1;
				
				myShape.top2Part.x2 = myShape.top2Part.x2BA = myShape.top2Part.x2A = myParent.top2Part.x2;
				
				myShape.top2Part.y2 = myShape.top2Part.y2BA = myShape.top2Part.y2A = myParent.top2Part.y2;
				
				myShape.top2Part.bkgrdStartX = myShape.top2Part.x1 - myShape.top2Part.radius1;
				
				myShape.top2Part.bkgrdStartY = myShape.top2Part.y1 - myShape.top2Part.radius1;
				
				myShape.top2Part.bkgrdStartXBA = myShape.top2Part.x1 - myShape.top2Part.radius1BA;
				
				myShape.top2Part.bkgrdStartYBA = myShape.top2Part.y1 - myShape.top2Part.radius1BA;
				
				myShape.top2Part.bkgrdStartXA = myShape.top2Part.x1 - myShape.top2Part.radius1A;
				
				myShape.top2Part.bkgrdStartYA = myShape.top2Part.y1 - myShape.top2Part.radius1A;
				
			}
		}
		
		if (myShape.noSidesTop == 2 && myShape.top1Part.partForm == 2 && myShape.top2Part.partForm == 2)
		{
			myShape.top2Part.startXC = myShape.top2Part.startXBA //
			= myShape.top2Part.startXA = myShape.top1Part.endXBA //
			= myShape.top1Part.endXA = myShape.top1Part.endXC//
			= myShape.startingX + (myShape.bX2 - myShape.startingX) / 2;
		}
		
		return myShape;
	}
	
	/**
	 * Setting base info
	 * 
	 * @param myShape
	 *             , ShapeObject
	 * @param BorBA
	 *             , int
	 * @param setRowCol
	 *             , boolean
	 * @return ShapeObject
	 */
	public ShapeObject setBaseInfo(ShapeObject myShape, int BorBA, boolean setRowCol)
	{
	
		if (myShape.shapeID < 800)
		{
			
			if (!myShape.topIn && myShape.botIn && myShape.rightIn)
			{
				myShape.top1Part.position = 1;
			}
			
			if (!myShape.topIn && myShape.botIn && myShape.noSidesLeft == 0)
			{
				myShape.top1Part.position = 1;
			}
			
			if (setRowCol)
			{
				myShape.startCol = myParent.startCol;
				myShape.endCol = myParent.endCol;
				myShape.startRow = myParent.startRow;
				myShape.endRow = myParent.endRow;
			}
			
			myShape.top1Part.position = 1;
			myShape.top2Part.position = 2;
			myShape.top3Part.position = 3;
			myShape.bot3Part.position = 6;
			myShape.bot2Part.position = 7;
			myShape.bot1Part.position = 5;
			myShape.leftPart.position = 8;
			myShape.rightPart.position = 4;
			
			EllipseLineIntersections arcX = new EllipseLineIntersections();
			
			if (myShape.a_levelID == 3 && myShape.top1Part.partForm >= 2)
			{
				myShape = this.setTop1ArcInfo(myShape, BorBA);
				myShape = this.setTop2ArcInfo(myShape, BorBA);
			}
			else if (myShape.top1Part.partForm >= 2)
			{
				myShape = this.setTop1ArcInfo(myShape, BorBA);
				myShape = this.setTop2ArcInfo(myShape, BorBA);
			}
			
			boolean useYL = false;
			boolean useYR = false;
			
			if (myShape.noSidesLeft == 0)
			{
				useYL = true;
			}
			
			if (myShape.noSidesRight == 0)
			{
				useYR = true;
			}
			// //////////////////////////////////////////////////////////////////
			
			if (myShape.noSidesTop == 2 && myShape.top1Part.partForm >= 2 && myShape.top2Part.partForm == 1)
			{
				this.top1Top2StraightIntersectionX(myShape, arcX);
			}
			
			// //////////////////////////////////////////////////////////////////
			
			if (myShape.noSidesTop == 2 && myShape.top1Part.partForm == 1 && myShape.top2Part.partForm >= 2)
			{
				this.top1StraightTop2IntersectionX(myShape, arcX);
			}
			
			// //////////////////////////////////////////////////////////////
			
			if (myShape.noSidesTop == 3 && myShape.top1Part.partForm >= 2)
			{
				this.top1Top3IntersectionX(myShape, arcX);
			}
			
			// ////////////////////////////////////////////////////////////////////
			
			if (myShape.noSidesTop == 3 && myShape.top2Part.partForm >= 2)
			{
				this.top2Top3IntersectionX(myShape, arcX);
			}
			
			// ////////////////////////////////////////////////////////////////////
			if (myShape.top1Part.partForm >= 2 && myShape.noSidesLeft == 1)
			{
				this.top1LeftIntersectionYStart(myShape, arcX);
			}
			else if (myShape.noSidesTop >= 2 && myShape.top1Part.partForm >= 2 && myShape.noSidesLeft == 0)
			{
				this.top1BotIntersectionX(myShape, arcX, false);
			}
			
			// /////////////////////////////
			if (myShape.noSidesTop == 1 && myShape.top1Part.partForm >= 2 && myShape.noSidesRight >= 1)
			{
				this.top1RightIntersectionY(myShape, arcX);
			}
			// /////////////////////////////
			else if (myShape.noSidesTop >= 2 && myShape.top2Part.partForm >= 2 && myShape.noSidesRight >= 1)
			{
				this.top2RightIntersectionY(myShape, arcX);
			}
			else if (myShape.noSidesTop >= 2 && myShape.top2Part.partForm == 2 && myShape.noSidesRight == 0)
			{
				this.top2BotIntersectionX(myShape, arcX, true);
			}
			// /////////////////////////////
			if (myShape.noSides == 3 && myShape.noSidesLeft == 0 && myShape.top1Part.partForm >= 2 && myShape.noSidesTop == 1)
			{
				this.top1BotIntersectionX(myShape, arcX, false);
			}
			// /////////////////////////////
			
			if (myShape.noSides == 3 && myShape.noSidesRight == 0 && myShape.top1Part.partForm >= 2 && myShape.noSidesTop == 1)
			{
				this.topBotIntersectionRightSideX(myShape, arcX);
			}
			
			// ///////////////////////////
			
			if (myShape.noSides == 2 && myShape.shapeID < 800)
			{
				if (myShape.a_levelID == 3)
				{
					myShape.noSides = 2;
				}
				this.top1BotIntersectionX(myShape, arcX, false);
				this.top1BotIntersectionY(myShape, arcX);
				this.topBotIntersectionRightSideX(myShape, arcX);
				this.top1BotIntersectionYRightSide(myShape, arcX);
				
			}
			// ////////////////////////////////////////////////////////
			if (myShape.a_levelID == 3 && myShape.top1Part.partForm >= 2)
			{
				this.top1StartStopAngles(myShape, useYL, useYR);
			}
			else
			{
				this.top1StartStopAngles(myShape, useYL, useYR);
			}
			
			if (myShape.top2Part.posInUse && myShape.top2Part.partForm == 2)
			{
				this.top2StartStopAngles(myShape, useYL, useYR);
			}
			
			// ////////////////////////////////////////////////////////////////////
		}
		
		if (myShape.shapeID >= 800)
		{
			
			if (myShape.a_levelID == 21)
			{
				myShape.top1Part.position = 1;
			}
			
			myShape.top1Part.position = 1;
			myShape.bot1Part.position = 2;
			
			myShape.top1Part.startAngle = myShape.top1Part.startAngleBA = myShape.top1Part.startAngleA = 0;
			myShape.top1Part.endAngle = myShape.top1Part.endAngleBA = myShape.top1Part.endAngleA = 180;
			
			myShape.top1Part.bkgrdStartX = myShape.startingX;
			myShape.top1Part.bkgrdStartXBA = myShape.startingX + top1DimBo;
			myShape.top1Part.bkgrdStartXA = myShape.top1Part.bkgrdStartXBA + top1DimAo;
			myShape.top1Part.bkgrdStartY = myShape.highestY;
			myShape.top1Part.bkgrdStartYBA = myShape.highestY + top1DimBo;
			myShape.top1Part.bkgrdStartYA = myShape.highestY + top1DimBo + top1DimAo;
			
			if (myShape.widthI > myShape.heightI)
			{
				myShape.radius1 = myShape.top1Part.radius1;
				myShape.radius2 = myShape.top1Part.radius2;
			}
			else if (myShape.widthI < myShape.heightI)
			{
				myShape.radius1 = myShape.top1Part.radius1;
				myShape.radius2 = myShape.top1Part.radius2;
			}
			else
			{
				myShape.top1Part.radius1 = myShape.radius1 = myShape.top1Part.startingY - myShape.highestY;
				myShape.radius2 = myShape.top1Part.radius2;
			}
			
			myShape.top1Part.radius1BA = myShape.top1Part.radius1 - top1DimBo;
			myShape.top1Part.radius1A = myShape.top1Part.radius1BA - top1DimAo;
			myShape.top1Part.radius2BA = myShape.top1Part.radius2 - top1DimBo;
			myShape.top1Part.radius2A = myShape.top1Part.radius2BA - top1DimAo;
			
			if (myShape.widthI > myShape.heightI)
			{
				myShape.top1Part.bkgrdWidth = myShape.top1Part.bkgrdWidth;
				myShape.top1Part.bkgrdHeight = myShape.top1Part.bkgrdHeight;
				
				myShape.top1Part.bkgrdWidthBA = myShape.top1Part.bkgrdWidth - 2 * top1DimBo;
				myShape.top1Part.bkgrdHeightBA = myShape.top1Part.bkgrdHeight - 2 * top1DimBo;
				myShape.top1Part.bkgrdWidthA = myShape.top1Part.bkgrdWidth - 2 * (top1DimBo + top1DimAo);
				myShape.top1Part.bkgrdHeightA = myShape.top1Part.bkgrdHeight - 2 * (top1DimBo + top1DimAo);
				
			}
			else if (myShape.widthI < myShape.heightI)
			{
				myShape.top1Part.bkgrdWidth = myShape.top1Part.bkgrdWidth;
				myShape.top1Part.bkgrdHeight = myShape.top1Part.bkgrdHeight;
				
				myShape.top1Part.bkgrdWidthBA = myShape.top1Part.bkgrdWidth - 2 * top1DimBo;
				myShape.top1Part.bkgrdHeightBA = myShape.top1Part.bkgrdHeight - 2 * top1DimBo;
				myShape.top1Part.bkgrdWidthA = myShape.top1Part.bkgrdWidth - 2 * (top1DimBo + top1DimAo);
				myShape.top1Part.bkgrdHeightA = myShape.top1Part.bkgrdHeight - 2 * (top1DimBo + top1DimAo);
				
			}
			else
			{
				
				myShape.top1Part.bkgrdWidth = myShape.top1Part.bkgrdHeight = myShape.top1Part.radius1 * 2;
				myShape.top1Part.bkgrdWidthBA = myShape.top1Part.bkgrdHeightBA = myShape.top1Part.radius1BA * 2;
				myShape.top1Part.bkgrdWidthA = myShape.top1Part.bkgrdHeightA = myShape.top1Part.radius1A * 2;
			}
			
			myShape.top1Part.x1 = myShape.top1Part.x1BA = myShape.top1Part.x1A = myShape.startingX + myShape.widthPix / 2;
			myShape.top1Part.y1 = myShape.top1Part.y1BA = myShape.top1Part.y1A = myShape.startingY;
			myShape.top1Part.x2 = myShape.top1Part.x2BA = myShape.top1Part.x2A = 0;
			myShape.top1Part.y2 = myShape.top1Part.y2BA = myShape.top1Part.y2A = 0;
			
			myShape.bot1Part.partForm = myShape.top1Part.partForm;
			myShape.bot1Part.startAngle = 180;
			myShape.bot1Part.endAngle = 180;
			
			myShape.bot1Part.bkgrdStartX = myShape.top1Part.bkgrdStartX;
			myShape.bot1Part.bkgrdStartY = myShape.top1Part.bkgrdStartY;
			myShape.bot1Part.radius1 = myShape.top1Part.radius1;
			myShape.bot1Part.radius2 = myShape.top1Part.radius2;
			myShape.bot1Part.startAngleBA = 180;
			myShape.bot1Part.endAngleBA = 180;
			
			myShape.bot1Part.bkgrdStartXBA = myShape.bot1Part.bkgrdStartX + bot1DimBo;
			myShape.bot1Part.bkgrdStartYBA = myShape.bot1Part.bkgrdStartY + bot1DimBo;
			myShape.bot1Part.radius1BA = myShape.bot1Part.radius1 - bot1DimBo;
			myShape.bot1Part.radius2BA = myShape.bot1Part.radius2 - bot1DimBo;
			myShape.bot1Part.startAngleA = 180;
			myShape.bot1Part.endAngleA = 180;
			myShape.bot1Part.bkgrdStartXA = myShape.bot1Part.bkgrdStartXBA + bot1DimAo;
			myShape.bot1Part.bkgrdStartYA = myShape.bot1Part.bkgrdStartYBA + bot1DimAo;
			myShape.bot1Part.radius1A = myShape.bot1Part.radius1BA - bot1DimAo;
			myShape.bot1Part.radius2A = myShape.bot1Part.radius2BA - bot1DimAo;
			
			if (myShape.widthI > myShape.heightI)
			{
				
				myShape.bot1Part.bkgrdWidth = myShape.top1Part.bkgrdWidth;
				myShape.bot1Part.bkgrdHeight = myShape.top1Part.bkgrdHeight;
				myShape.bot1Part.bkgrdWidthBA = myShape.top1Part.bkgrdWidth - 2 * top1DimBo;
				myShape.bot1Part.bkgrdHeightBA = myShape.top1Part.bkgrdHeight - 2 * top1DimBo;
				myShape.bot1Part.bkgrdWidthA = myShape.top1Part.bkgrdWidth - 2 * (top1DimBo + top1DimAo);
				myShape.bot1Part.bkgrdHeightA = myShape.top1Part.bkgrdHeight - 2 * (top1DimBo + top1DimAo);
				
			}
			else if (myShape.widthI < myShape.heightI)
			{
				myShape.bot1Part.bkgrdWidth = myShape.top1Part.bkgrdWidth;
				myShape.bot1Part.bkgrdHeight = myShape.top1Part.bkgrdHeight;
				
				myShape.bot1Part.bkgrdWidthBA = myShape.top1Part.bkgrdWidth - 2 * top1DimBo;
				myShape.bot1Part.bkgrdHeightBA = myShape.top1Part.bkgrdHeight - 2 * top1DimBo;
				myShape.bot1Part.bkgrdWidthA = myShape.top1Part.bkgrdWidth - 2 * (top1DimBo + top1DimAo);
				myShape.bot1Part.bkgrdHeightA = myShape.top1Part.bkgrdHeight - 2 * (top1DimBo + top1DimAo);
				
			}
			else
			{
				myShape.bot1Part.bkgrdWidth = myShape.bot1Part.bkgrdHeight = myShape.bot1Part.radius1 * 2;
				myShape.bot1Part.bkgrdWidthBA = myShape.bot1Part.bkgrdHeightBA = myShape.bot1Part.radius1BA * 2;
				myShape.bot1Part.bkgrdWidthA = myShape.bot1Part.bkgrdHeightA = myShape.bot1Part.radius1A * 2;
			}
			
			myShape.bot1Part.x1 = myShape.bot1Part.x1BA = myShape.bot1Part.x1A = myShape.top1Part.x1;
			myShape.bot1Part.y1 = myShape.bot1Part.y1BA = myShape.bot1Part.y1A = myShape.top1Part.y1;
			myShape.bot1Part.x2 = myShape.bot1Part.x2BA = myShape.bot1Part.x2A = myShape.top1Part.x2;
			myShape.bot1Part.y2 = myShape.bot1Part.y2BA = myShape.bot1Part.y2A = myShape.top1Part.y2;
			
		}
		else
		{
			
			if (myParent.bot1 != null && myShape.bot1Part.partForm > 1)
			{
				
				myShape.bot1Part.partForm = myParent.bot1Part.partForm;
				myShape.bot1Part.startAngle = myParent.bot1Part.startAngle;
				myShape.bot1Part.endAngle = myParent.bot1Part.endAngle;
				myShape.bot1Part.bkgrdStartX = myParent.bot1Part.bkgrdStartX + myShape.clearanceLeft;
				myShape.bot1Part.bkgrdStartY = myParent.bot1Part.bkgrdStartY - myShape.clearanceBot;
				
				myShape.bot1Part.radius1 = myParent.bot1Part.radius1 - myShape.clearanceBot;
				myShape.bot1Part.radius2 = myParent.bot1Part.radius2 - myShape.clearanceBot;
				
				myShape.bot1Part.startAngleBA = myParent.bot1Part.startAngle;
				myShape.bot1Part.endAngleBA = myParent.bot1Part.endAngle;
				myShape.bot1Part.bkgrdStartXBA = myParent.bot1Part.bkgrdStartX + leftDimC;
				myShape.bot1Part.bkgrdStartYBA = myParent.bot1Part.bkgrdStartY - bot1DimC;
				
				myShape.bot1Part.radius1BA = myParent.bot1Part.radius1 - bot1DimC;
				myShape.bot1Part.radius2BA = myParent.bot1Part.radius2 - bot1DimC;
				
				myShape.bot1Part.startAngleA = myParent.bot1Part.startAngle;
				myShape.bot1Part.endAngleA = myParent.bot1Part.endAngle;
				myShape.bot1Part.bkgrdStartXA = myParent.bot1Part.bkgrdStartX + leftDimC;
				myShape.bot1Part.bkgrdStartYA = myParent.bot1Part.bkgrdStartY - bot1DimC;
				
				myShape.bot1Part.radius1A = myParent.bot1Part.radius1 - bot1DimC;
				myShape.bot1Part.radius2A = myParent.bot1Part.radius2 - bot1DimC;
				
				if (myShape.widthI > myShape.heightI)
				{
					
				}
				else if (myShape.widthI < myShape.heightI)
				{
					
				}
				else
				{
					myShape.bot1Part.bkgrdWidth = myShape.bot1Part.bkgrdHeight = myShape.bot1Part.radius1 * 2;
					myShape.bot1Part.bkgrdWidthBA = myShape.bot1Part.bkgrdHeightBA = myShape.bot1Part.radius1BA * 2;
					myShape.bot1Part.bkgrdWidthA = myShape.bot1Part.bkgrdHeightA = myShape.bot1Part.radius1A * 2;
				}
				
				myShape.bot1Part.x1 = myParent.bot1Part.x1BA;
				myShape.bot1Part.x1BA = myShape.bot1Part.x1;
				myShape.bot1Part.x1A = myShape.bot1Part.x1;
				myShape.bot1Part.y1 = myParent.bot1Part.y1BA;
				myShape.bot1Part.y1BA = myShape.bot1Part.y1;
				myShape.bot1Part.y1A = myShape.bot1Part.y1;
				myShape.bot1Part.x2 = myParent.bot1Part.x2BA;
				myShape.bot1Part.x2BA = myShape.bot1Part.x2;
				myShape.bot1Part.x2A = myShape.bot1Part.x2;
				myShape.bot1Part.y2 = myParent.bot1Part.y2BA;
				myShape.bot1Part.y2BA = myShape.bot1Part.y2;
				myShape.bot1Part.y2A = myShape.bot1Part.y2;
			}
			
			if (myParent.bot2 != null && myShape.bot2Part.posInUse && myShape.bot2Part.partForm > 1)
			{
				// myShape.bot2Part.partForm
				// myParent.bot2Part.partForm;
				myShape.bot2Part.startAngle = myParent.bot2Part.startAngle;
				myShape.bot2Part.endAngle = myParent.bot2Part.endAngle;
				myShape.bot2Part.bkgrdStartX = myParent.bot2Part.bkgrdStartX + leftDimC;
				myShape.bot2Part.bkgrdStartY = myParent.bot2Part.bkgrdStartY - bot2DimC;
				myShape.bot2Part.bkgrdWidth = myShape.bot2Part.bkgrdHeight = myParent.bot2Part.bkgrdHeight - leftDimC
							- rightDimC;
				myShape.bot2Part.radius1 = myParent.bot2Part.radius1 - bot2DimC;
				myShape.bot2Part.radius2 = myParent.bot2Part.radius2 - bot2DimC;
				
				myShape.bot2Part.startAngleBA = myParent.bot2Part.startAngle;
				myShape.bot2Part.endAngleBA = myParent.bot2Part.endAngle;
				myShape.bot2Part.bkgrdStartX = myParent.bot2Part.bkgrdStartX + leftDimC;
				myShape.bot2Part.bkgrdStartYBA = myParent.bot2Part.bkgrdStartY - bot2DimC;
				myShape.bot2Part.bkgrdWidthBA = myShape.bot2Part.bkgrdHeightBA = myParent.bot2Part.bkgrdHeight - leftDimC
							- rightDimC;
				myShape.bot2Part.radius1BA = myParent.bot2Part.radius1 - bot2DimC;
				myShape.bot2Part.radius2BA = myParent.bot2Part.radius2 - bot2DimC;
				
				myShape.bot2Part.startAngleA = myParent.bot2Part.startAngle;
				myShape.bot2Part.endAngleA = myParent.bot2Part.endAngle;
				myShape.bot2Part.bkgrdStartX = myParent.bot2Part.bkgrdStartX + leftDimC;
				myShape.bot2Part.bkgrdStartYA = myParent.bot2Part.bkgrdStartY - bot2DimC;
				myShape.bot2Part.bkgrdWidthA = myShape.bot2Part.bkgrdHeightA = myParent.bot2Part.bkgrdHeight - leftDimC
							- rightDimC;
				myShape.bot2Part.radius1A = myParent.bot2Part.radius1 - bot2DimC;
				myShape.bot2Part.radius2A = myParent.bot2Part.radius2 - bot2DimC;
			}
			
			if (myParent.bot3 != null && myShape.bot3Part.posInUse && myShape.bot2Part.partForm > 1)
			{
				// myShape.bot3Part.partForm
				// =
				// myParent.bot3Part.partForm;
				myShape.bot3Part.startAngle = myParent.bot3Part.startAngle;
				myShape.bot3Part.endAngle = myParent.bot3Part.endAngle;
				myShape.bot3Part.bkgrdStartX = myParent.bot3Part.bkgrdStartX + leftDimC;
				myShape.bot3Part.bkgrdStartY = myParent.bot3Part.bkgrdStartY - bot2DimC;
				myShape.bot3Part.bkgrdWidth = myShape.bot3Part.bkgrdHeight = myParent.bot3Part.bkgrdHeight - leftDimC
							- rightDimC;
				myShape.bot3Part.radius1 = myParent.bot3Part.radius1 - bot2DimC;
				myShape.bot3Part.radius2 = myParent.bot3Part.radius2 - bot2DimC;
				
				myShape.bot3Part.startAngleBA = myParent.bot3Part.startAngle;
				myShape.bot3Part.endAngleBA = myParent.bot3Part.endAngle;
				myShape.bot3Part.bkgrdStartX = myParent.bot3Part.bkgrdStartX + leftDimC;
				myShape.bot3Part.bkgrdStartYBA = myParent.bot3Part.bkgrdStartY - bot2DimC;
				myShape.bot3Part.bkgrdWidthBA = myShape.bot3Part.bkgrdHeightBA = myParent.bot3Part.bkgrdHeight - leftDimC
							- rightDimC;
				myShape.bot3Part.radius1BA = myParent.bot3Part.radius1 - bot2DimC;
				myShape.bot3Part.radius2BA = myParent.bot3Part.radius2 - bot2DimC;
				
				myShape.bot3Part.startAngleA = myParent.bot3Part.startAngle;
				myShape.bot3Part.endAngleA = myParent.bot3Part.endAngle;
				myShape.bot3Part.bkgrdStartX = myParent.bot3Part.bkgrdStartX + leftDimC;
				myShape.bot3Part.bkgrdStartYA = myParent.bot3Part.bkgrdStartY - bot2DimC;
				myShape.bot3Part.bkgrdWidthA = myShape.bot3Part.bkgrdHeightA = myParent.bot3Part.bkgrdHeight - leftDimC
							- rightDimC;
				myShape.bot3Part.radius1A = myParent.bot3Part.radius1 - bot2DimC;
				myShape.bot3Part.radius2A = myParent.bot3Part.radius2 - bot2DimC;
				
			}
		}
		
		// myShape.executeOptionRules();
		
		return myShape;
	}
	
	public void top1StraightTop2IntersectionX(final ShapeObject myShape, final EllipseLineIntersections arcX)
	{
	
		if (myShape.top1Part.endTypeLT == 1)
		{
			myShape.top2Part.startXC = arcX.getXusingY(myShape.top1Part.startXC, myShape.top1Part.startYC,
						myShape.top1Part.endXC, myShape.top1Part.endYC, myShape.top2Part.radius1, myShape.top2Part.x1,
						myShape.top2Part.y1, true);
			
			myShape.top2Part.startXBA = arcX.getXusingY(myShape.top1Part.startXBA, myShape.top1Part.startYBA,
						myShape.top1Part.endXBA, myShape.top1Part.endYBA, myShape.top2Part.radius1BA, myShape.top2Part.x1,
						myShape.top2Part.y1, true);
			
			myShape.top2Part.startXA = arcX.getXusingY(myShape.top1Part.startXA, myShape.top1Part.startYA,
						myShape.top1Part.endXA, myShape.top1Part.endYA, myShape.top2Part.radius1A, myShape.top2Part.x1,
						myShape.top2Part.y1, true);
			
			myShape.top2Part.endTypeRB = 1;
			myShape.top1Part.endXC = myShape.top2Part.startXC;
			myShape.top1Part.endXA = myShape.top2Part.startXA;
			myShape.top1Part.endXBA = myShape.top2Part.startXBA;
			
		}
		else if (myShape.top1Part.endTypeLT == 3)
		{
			myShape.top2Part.startXC = arcX.getXusingY(myShape.top1Part.startXC, myShape.top1Part.startYC,
						myShape.top1Part.endXC, myShape.top1Part.endYC, myShape.top2Part.radius1, myShape.top2Part.x1,
						myShape.top2Part.y1, true);
			
			myShape.top2Part.startXBA = arcX.getXusingY(myShape.top1Part.startXC, myShape.top1Part.startYC,
						myShape.top1Part.endXC, myShape.top1Part.endYC, myShape.top2Part.radius1BA, myShape.top2Part.x1,
						myShape.top2Part.y1, true);
			
			myShape.top2Part.startXA = arcX.getXusingY(myShape.top1Part.startXA, myShape.top1Part.startYA,
						myShape.top1Part.endXA, myShape.top1Part.endYA, myShape.top2Part.radius1A, myShape.top2Part.x1,
						myShape.top2Part.y1, true);
			
			myShape.top2Part.endTypeRB = 2;
			myShape.top1Part.endXC =
			
			arcX.getXusingY(myShape.top1Part.startXC, myShape.top1Part.startYC, myShape.top1Part.endXC,
						myShape.top1Part.endYC, myShape.top2Part.radius1BA, myShape.top2Part.x1, myShape.top2Part.y1, false);
			myShape.top1Part.endXA =
			
			arcX.getXusingY(myShape.top1Part.startXA, myShape.top1Part.startYA, myShape.top1Part.endXA,
						myShape.top1Part.endYA, myShape.top2Part.radius1A, myShape.top2Part.x1, myShape.top2Part.y1, false);
			
			myShape.top1Part.endXBA =
			
			arcX.getXusingY(myShape.top1Part.startXBA, myShape.top1Part.startYBA, myShape.top1Part.endXBA,
						myShape.top1Part.endYBA, myShape.top2Part.radius1, myShape.top2Part.x1, myShape.top2Part.y1, false);
			
		}
		else if (myShape.top1Part.endTypeLT == 2)
		{
			myShape.top2Part.startXC = arcX.getXusingY(myShape.top1Part.startXBA, myShape.top1Part.startYBA,
						myShape.top1Part.endXBA, myShape.top1Part.endYBA, myShape.top2Part.radius1, myShape.top2Part.x1,
						myShape.top2Part.y1, true);
			
			myShape.top2Part.startXBA = arcX.getXusingY(myShape.top1Part.startXBA, myShape.top1Part.startYBA,
						myShape.top1Part.endXBA, myShape.top1Part.endYBA, myShape.top2Part.radius1BA, myShape.top2Part.x1,
						myShape.top2Part.y1, true);
			
			myShape.top2Part.startXA = arcX.getXusingY(myShape.top1Part.startXBA, myShape.top1Part.startYBA,
						myShape.top1Part.endXBA, myShape.top1Part.endYBA, myShape.top2Part.radius1A, myShape.top2Part.x1,
						myShape.top2Part.y1, true);
			
			myShape.top2Part.endTypeRB = 3;
			myShape.top1Part.endXC =
			
			arcX.getXusingY(myShape.top1Part.startXC, myShape.top1Part.startYC, myShape.top1Part.endXC,
						myShape.top1Part.endYC, myShape.top2Part.radius1, myShape.top2Part.x1, myShape.top2Part.y1, true);
			myShape.top1Part.endXA =
			
			arcX.getXusingY(myShape.top1Part.startXA, myShape.top1Part.startYA, myShape.top1Part.endXA,
						myShape.top1Part.endYA, myShape.top2Part.radius1A, myShape.top2Part.x1, myShape.top2Part.y1, true);
			
			myShape.top1Part.endXBA =
			
			arcX.getXusingY(myShape.top1Part.startXBA, myShape.top1Part.startYBA, myShape.top1Part.endXBA,
						myShape.top1Part.endYBA, myShape.top2Part.radius1, myShape.top2Part.x1, myShape.top2Part.y1, true);
			
		}
	}
	
	public void top1Top2StraightIntersectionX(ShapeObject myShape, EllipseLineIntersections arcX)
	{
	
		if (myShape.top1Part.endTypeLT == 1)
		{
			myShape.top1Part.endXC = arcX.getXusingY(myShape.top2Part.startXC, myShape.top2Part.startYC,
						myShape.top2Part.endXC, myShape.top2Part.endYC, myShape.top1Part.radius1, myShape.top1Part.x1,
						myShape.top1Part.y1, false);
			
			myShape.top1Part.endXBA = arcX.getXusingY(myShape.top2Part.startXBA, myShape.top2Part.startYBA,
						myShape.top2Part.endXBA, myShape.top2Part.endYBA, myShape.top1Part.radius1BA, myShape.top1Part.x1,
						myShape.top1Part.y1, false);
			
			myShape.top1Part.endXA = arcX.getXusingY(myShape.top2Part.startXA, myShape.top2Part.startYA,
						myShape.top2Part.endXA, myShape.top2Part.endYA, myShape.top1Part.radius1A, myShape.top1Part.x1,
						myShape.top1Part.y1, false);
			
			myShape.top2Part.endTypeRB = 1;
			myShape.top2Part.startXC = myShape.top1Part.endXC;
			myShape.top2Part.startXA = myShape.top1Part.endXA;
			myShape.top2Part.startXBA = myShape.top1Part.endXBA;
			
		}
		else if (myShape.top1Part.endTypeLT == 2)
		{
			myShape.top1Part.endXC =
			
			arcX.getXusingY(myShape.top2Part.startXC, myShape.top2Part.startYC, myShape.top2Part.endXC,
						myShape.top2Part.endYC, myShape.top1Part.radius1, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.top1Part.endXBA = arcX.getXusingY(myShape.top2Part.startXC, myShape.top2Part.startYC,
						myShape.top2Part.endXC, myShape.top2Part.endYC, myShape.top1Part.radius1BA, myShape.top1Part.x1,
						myShape.top1Part.y1, false);
			myShape.top1Part.endXA = arcX.getXusingY(myShape.top2Part.startXA, myShape.top2Part.startYA,
						myShape.top2Part.endXA, myShape.top2Part.endYA,
						
						myShape.top1Part.radius1A, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.top2Part.endTypeRB = 3;
			myShape.top2Part.startXC =
			
			arcX.getXusingY(myShape.top2Part.startXC, myShape.top2Part.startYC, myShape.top2Part.endXC,
						myShape.top2Part.endYC, myShape.top1Part.radius1BA, myShape.top1Part.x1, myShape.top1Part.y1, false);
			myShape.top2Part.startXA =
			
			arcX.getXusingY(myShape.top2Part.startXA, myShape.top2Part.startYA, myShape.top2Part.endXA,
						myShape.top2Part.endYA, myShape.top1Part.radius1BA, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.top2Part.startXBA =
			
			arcX.getXusingY(myShape.top2Part.startXBA, myShape.top2Part.startYBA, myShape.top2Part.endXBA,
						myShape.top2Part.endYBA, myShape.top1Part.radius1BA, myShape.top1Part.x1, myShape.top1Part.y1,
						false);
			
		}
		else if (myShape.top1Part.endTypeLT == 3)
		{
			myShape.top1Part.endXC =
			
			arcX.getXusingY(myShape.top2Part.startXBA, myShape.top2Part.startYBA,
			
			myShape.top2Part.endXBA, myShape.top2Part.endYBA,
			
			myShape.top1Part.radius1, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.top1Part.endXBA =
			
			arcX.getXusingY(myShape.top2Part.startXBA, myShape.top2Part.startYBA,
			
			myShape.top2Part.endXBA, myShape.top2Part.endYBA, myShape.top1Part.radius1BA, myShape.top1Part.x1,
						myShape.top1Part.y1, false);
			
			myShape.top1Part.endXA = arcX.getXusingY(myShape.top2Part.startXBA, myShape.top2Part.startYBA,
			
			myShape.top2Part.endXBA, myShape.top2Part.endYBA, myShape.top1Part.radius1A, myShape.top1Part.x1,
						myShape.top1Part.y1, false);
			
			myShape.top2Part.endTypeRB = 2;
			myShape.top2Part.startXC =
			
			arcX.getXusingY(myShape.top2Part.startXC, myShape.top2Part.startYC, myShape.top2Part.endXC,
						myShape.top2Part.endYC, myShape.top1Part.radius1, myShape.top1Part.x1, myShape.top1Part.y1, false);
			myShape.top2Part.startXA =
			
			arcX.getXusingY(myShape.top2Part.startXA, myShape.top2Part.startYA, myShape.top2Part.endXA,
						myShape.top2Part.endYA, myShape.top1Part.radius1A, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.top2Part.startXBA =
			
			arcX.getXusingY(myShape.top2Part.startXBA, myShape.top2Part.startYBA, myShape.top2Part.endXBA,
						myShape.top2Part.endYBA, myShape.top1Part.radius1, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
		}
	}
	
	public void top2StartStopAngles(final ShapeObject myShape, final boolean useYL, final boolean useYR)
	{
	
		double[] anglesOut;
		double[] anglesMid;
		double[] anglesIn;
		anglesOut = this
					.getArchesAngles(myShape.top2Part.startXC, myShape.top2Part.endXC, myShape.top2Part.startYC,
								myShape.top2Part.endYC, myShape.top2Part.radius1, myShape.top2Part.x1,
								myShape.top2Part.y1, useYL, useYR);
		
		anglesMid = this.getArchesAngles(myShape.top2Part.startXBA, myShape.top2Part.endXBA, myShape.top2Part.startYBA,
					myShape.top2Part.endYBA, myShape.top2Part.radius1BA, myShape.top2Part.x1, myShape.top2Part.y1, useYL,
					useYR);
		
		anglesIn = this.getArchesAngles(myShape.top2Part.startXA, myShape.top2Part.endXA, myShape.top2Part.startYA,
					myShape.top2Part.endYA, myShape.top2Part.radius1A, myShape.top2Part.x1, myShape.top2Part.y1, useYL,
					useYR);
		
		myShape.top2Part.startAngle = anglesOut[0];
		myShape.top2Part.endAngle = anglesOut[1];
		
		myShape.top2Part.startAngleBA = anglesMid[0];
		myShape.top2Part.endAngleBA = anglesMid[1];
		
		myShape.top2Part.startAngleA = anglesIn[0];
		myShape.top2Part.endAngleA = anglesIn[1];
	}
	
	public void top1StartStopAngles(final ShapeObject myShape, final boolean useYL, final boolean useYR)
	{
	
		double[] anglesOut;
		double[] anglesMid;
		double[] anglesIn;
		if (myShape.top1Part.partForm >= 2)
		{
			
			double x = 0;
			if (myShape.a_levelID == 3)
			{
				
				x = myShape.top1Part.startXC;
				
			}
			else
			{
				x = myShape.top1Part.startXC;
			}
			
			anglesOut = this.getArchesAngles(
						x,// myShape.top1Part.startX,
						myShape.top1Part.endXC, myShape.top1Part.startYC, myShape.top1Part.endYC, myShape.top1Part.radius1,
						myShape.top1Part.x1, myShape.top1Part.y1, useYL, useYR);
			
			anglesMid = this.getArchesAngles(myShape.top1Part.startXBA, myShape.top1Part.endXBA, myShape.top1Part.startYBA,
						myShape.top1Part.endYBA, myShape.top1Part.radius1BA, myShape.top1Part.x1, myShape.top1Part.y1,
						useYL, useYR);
			
			anglesIn = this.getArchesAngles(myShape.top1Part.startXA, myShape.top1Part.endXA, myShape.top1Part.startYA,
						myShape.top1Part.endYA, myShape.top1Part.radius1A, myShape.top1Part.x1, myShape.top1Part.y1, useYL,
						useYR);
			
			if (myShape.shapeID == 200 && myShape.a_levelID == 3)
			{
				// anglesMid = anglesIn = anglesOut;
			}
			
			myShape.top1Part.startAngle = anglesOut[0];
			myShape.top1Part.endAngle = anglesOut[1];
			
			myShape.top1Part.startAngleBA = anglesMid[0];
			myShape.top1Part.endAngleBA = anglesMid[1];
			
			myShape.top1Part.startAngleA = anglesIn[0];
			myShape.top1Part.endAngleA = anglesIn[1];
		}
	}
	
	public void top2Top3IntersectionX(final ShapeObject myShape, final EllipseLineIntersections arcX)
	{
	
		if (myShape.top2Part.endTypeRB == 1)
		{
			myShape.top2Part.startXC = arcX.getXusingY(myShape.top3Part.startXC, myShape.top3Part.startYC,
						myShape.top3Part.endXC, myShape.top3Part.endYC, myShape.top2Part.radius1, myShape.top2Part.x1,
						myShape.top2Part.y1, true);
			
			myShape.top2Part.startXBA = arcX.getXusingY(myShape.top3Part.startXBA, myShape.top3Part.startYBA,
						myShape.top3Part.endXBA, myShape.top3Part.endYBA, myShape.top2Part.radius1BA, myShape.top2Part.x1,
						myShape.top2Part.y1, true);
			
			myShape.top2Part.startXA = arcX.getXusingY(myShape.top3Part.startXA, myShape.top3Part.startYA,
						myShape.top3Part.endXA, myShape.top3Part.endYA, myShape.top2Part.radius1A, myShape.top2Part.x1,
						myShape.top2Part.y1, true);
			
			myShape.top3Part.endTypeLT = 1;
			myShape.top3Part.endXC = myShape.top2Part.startXC;
			myShape.top3Part.endXA = myShape.top2Part.startXA;
			myShape.top3Part.endXBA = myShape.top2Part.startXBA;
			
		}
		else if (myShape.top2Part.endTypeLT == 2)
		{
			myShape.top2Part.startXC = arcX.getXusingY(myShape.top3Part.startXC, myShape.top3Part.startYC,
						myShape.top3Part.endXC, myShape.top3Part.endYC, myShape.top2Part.radius1, myShape.top2Part.x1,
						myShape.top2Part.y1, true);
			
			myShape.top2Part.startXBA = arcX.getXusingY(myShape.top3Part.startXC, myShape.top3Part.startYC,
						myShape.top3Part.endXC, myShape.top3Part.endYC, myShape.top2Part.radius1BA, myShape.top2Part.x1,
						myShape.top2Part.y1, true);
			
			myShape.top2Part.startXA = arcX.getXusingY(myShape.top3Part.startXA, myShape.top3Part.startYA,
						myShape.top3Part.endXA, myShape.top3Part.endYA, myShape.top2Part.radius1A, myShape.top2Part.x1,
						myShape.top2Part.y1, true);
			
			myShape.top3Part.endTypeLT = 3;
			myShape.top3Part.endXC =
			
			arcX.getXusingY(myShape.top3Part.startXC, myShape.top3Part.startYC, myShape.top3Part.endXC,
						myShape.top3Part.endYC, myShape.top2Part.radius1BA, myShape.top2Part.x1, myShape.top2Part.y1, true);
			myShape.top3Part.endXA =
			
			arcX.getXusingY(myShape.top3Part.startXA, myShape.top3Part.startYA, myShape.top3Part.endXA,
						myShape.top3Part.endYA, myShape.top2Part.radius1A, myShape.top2Part.x1, myShape.top2Part.y1, true);
			
			myShape.top3Part.endXBA =
			
			arcX.getXusingY(myShape.top3Part.startXBA, myShape.top3Part.startYBA, myShape.top3Part.endXBA,
						myShape.top3Part.endYBA, myShape.top2Part.radius1, myShape.top2Part.x1, myShape.top2Part.y1, true);
			
		}
		else if (myShape.top2Part.endTypeLT == 3)
		{
			myShape.top2Part.startXC = arcX.getXusingY(myShape.top3Part.startXBA, myShape.top3Part.startYBA,
						myShape.top3Part.endXBA, myShape.top3Part.endYBA, myShape.top2Part.radius1, myShape.top2Part.x1,
						myShape.top2Part.y1, true);
			
			myShape.top2Part.startXBA = arcX.getXusingY(myShape.top3Part.startXBA, myShape.top3Part.startYBA,
						myShape.top3Part.endXBA, myShape.top3Part.endYBA, myShape.top2Part.radius1BA, myShape.top2Part.x1,
						myShape.top2Part.y1, true);
			
			myShape.top2Part.startXA = arcX.getXusingY(myShape.top3Part.startXBA, myShape.top3Part.startYBA,
						myShape.top3Part.endXBA, myShape.top3Part.endYBA, myShape.top2Part.radius1A, myShape.top2Part.x1,
						myShape.top2Part.y1, true);
			
			myShape.top3Part.endTypeLT = 2;
			myShape.top3Part.endXC =
			
			arcX.getXusingY(myShape.top3Part.startXC, myShape.top3Part.startYC, myShape.top3Part.endXC,
						myShape.top3Part.endYC, myShape.top2Part.radius1, myShape.top2Part.x1, myShape.top2Part.y1, true);
			myShape.top3Part.endXA =
			
			arcX.getXusingY(myShape.top3Part.startXA, myShape.top3Part.startYA, myShape.top3Part.endXA,
						myShape.top3Part.endYA, myShape.top2Part.radius1A, myShape.top2Part.x1, myShape.top2Part.y1, true);
			
			myShape.top3Part.endXBA =
			
			arcX.getXusingY(myShape.top3Part.startXBA, myShape.top3Part.startYBA, myShape.top3Part.endXBA,
						myShape.top3Part.endYBA, myShape.top2Part.radius1, myShape.top2Part.x1, myShape.top2Part.y1, true);
			
		}
	}
	
	public void top1Top3IntersectionX(final ShapeObject myShape, final EllipseLineIntersections arcX)
	{
	
		if (myShape.top1Part.endTypeLT == 1)
		{
			myShape.top1Part.endXC = arcX.getXusingY(myShape.top3Part.startXC, myShape.top3Part.startYC,
						myShape.top3Part.endXC, myShape.top3Part.endYC, myShape.top1Part.radius1, myShape.top1Part.x1,
						myShape.top1Part.y1, false);
			
			myShape.top1Part.endXBA = arcX.getXusingY(myShape.top3Part.startXBA, myShape.top3Part.startYBA,
						myShape.top3Part.endXBA, myShape.top3Part.endYBA, myShape.top1Part.radius1BA, myShape.top1Part.x1,
						myShape.top1Part.y1, false);
			
			myShape.top1Part.endXA = arcX.getXusingY(myShape.top3Part.startXA, myShape.top3Part.startYA,
						myShape.top3Part.endXA, myShape.top3Part.endYA, myShape.top1Part.radius1A, myShape.top1Part.x1,
						myShape.top1Part.y1, false);
			
			myShape.top3Part.endTypeRB = 1;
			myShape.top3Part.startXC = myShape.top1Part.endXC;
			myShape.top3Part.startXA = myShape.top1Part.endXA;
			myShape.top3Part.startXBA = myShape.top1Part.endXBA;
			
		}
		else if (myShape.top1Part.endTypeLT == 2)
		{
			myShape.top1Part.endXC =
			
			arcX.getXusingY(myShape.top3Part.startXC, myShape.top3Part.startYC, myShape.top3Part.endXC,
						myShape.top3Part.endYC, myShape.top1Part.radius1, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.top1Part.endXBA = arcX.getXusingY(myShape.top3Part.startXC, myShape.top3Part.startYC,
						myShape.top3Part.endXC, myShape.top3Part.endYC, myShape.top1Part.radius1BA, myShape.top1Part.x1,
						myShape.top1Part.y1, false);
			myShape.top1Part.endXA = arcX.getXusingY(myShape.top3Part.startXA, myShape.top3Part.startYA,
						myShape.top3Part.endXA, myShape.top3Part.endYA,
						
						myShape.top1Part.radius1A, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.top3Part.endTypeRB = 3;
			myShape.top3Part.startXC =
			
			arcX.getXusingY(myShape.top3Part.startXC, myShape.top3Part.startYC, myShape.top3Part.endXC,
						myShape.top3Part.endYC, myShape.top1Part.radius1BA, myShape.top1Part.x1, myShape.top1Part.y1, false);
			myShape.top3Part.startXA =
			
			arcX.getXusingY(myShape.top3Part.startXA, myShape.top3Part.startYA, myShape.top3Part.endXA,
						myShape.top3Part.endYA, myShape.top1Part.radius1BA, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.top3Part.startXBA =
			
			arcX.getXusingY(myShape.top3Part.startXBA, myShape.top3Part.startYBA, myShape.top3Part.endXBA,
						myShape.top3Part.endYBA, myShape.top1Part.radius1BA, myShape.top1Part.x1, myShape.top1Part.y1,
						false);
			
		}
		else if (myShape.top1Part.endTypeLT == 3)
		{
			myShape.top1Part.endXC =
			
			arcX.getXusingY(myShape.top3Part.startXBA, myShape.top3Part.startYBA,
			
			myShape.top3Part.endXBA, myShape.top3Part.endYBA,
			
			myShape.top1Part.radius1, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.top1Part.endXBA =
			
			arcX.getXusingY(myShape.top3Part.startXBA, myShape.top3Part.startYBA,
			
			myShape.top3Part.endXBA, myShape.top3Part.endYBA, myShape.top1Part.radius1BA, myShape.top1Part.x1,
						myShape.top1Part.y1, false);
			
			myShape.top1Part.endXA = arcX.getXusingY(myShape.top3Part.startXBA, myShape.top3Part.startYBA,
			
			myShape.top3Part.endXBA, myShape.top3Part.endYBA, myShape.top1Part.radius1A, myShape.top1Part.x1,
						myShape.top1Part.y1, false);
			
			myShape.top3Part.endTypeRB = 2;
			myShape.top3Part.startXC =
			
			arcX.getXusingY(myShape.top3Part.startXC, myShape.top3Part.startYC, myShape.top3Part.endXC,
						myShape.top3Part.endYC, myShape.top1Part.radius1, myShape.top1Part.x1, myShape.top1Part.y1, false);
			myShape.top3Part.startXA =
			
			arcX.getXusingY(myShape.top3Part.startXA, myShape.top3Part.startYA, myShape.top3Part.endXA,
						myShape.top3Part.endYA, myShape.top1Part.radius1A, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.top3Part.startXBA =
			
			arcX.getXusingY(myShape.top3Part.startXBA, myShape.top3Part.startYBA, myShape.top3Part.endXBA,
						myShape.top3Part.endYBA, myShape.top1Part.radius1, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
		}
	}
	
	public void top1LeftIntersectionYStart(final ShapeObject myShape, final EllipseLineIntersections arcX)
	{
	
		if (myShape.top1Part.endTypeRB == 1)
		{
			myShape.leftPart.endTypeLT = 1;
			myShape.top1Part.startYC = myShape.leftPart.endYC = arcX.getYusingX(myShape.leftPart.startXC,
					myShape.leftPart.startYC, myShape.leftPart.endXC, myShape.leftPart.endYC,
					myShape.top1Part.radius1, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.top1Part.startYBA = myShape.leftPart.endYBA = arcX.getYusingX(myShape.leftPart.startXBA,
						myShape.leftPart.startYBA, myShape.leftPart.endXBA, myShape.leftPart.endYBA,
						myShape.top1Part.radius1BA, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.top1Part.startYA = myShape.leftPart.endYA = arcX.getYusingX(myShape.leftPart.startXA,
						myShape.leftPart.startYA, myShape.leftPart.endXA, myShape.leftPart.endYA,
						myShape.top1Part.radius1A, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
		}
		else if (myShape.top1Part.endTypeRB == 2)
		{
			myShape.leftPart.endTypeLT = 3;
			
			myShape.top1Part.startYC =
			
			arcX.getYusingX(myShape.leftPart.startXC, myShape.leftPart.startYC, myShape.leftPart.endXC,
						myShape.leftPart.endYC, myShape.top1Part.radius1, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.top1Part.startYBA =
			
			arcX.getYusingX(myShape.leftPart.startXC, myShape.leftPart.startYC, myShape.leftPart.endXC,
						myShape.leftPart.endYC, myShape.top1Part.radius1BA, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.top1Part.startYA =
			
			arcX.getYusingX(myShape.leftPart.startXA, myShape.leftPart.startYA, myShape.leftPart.endXA,
						myShape.leftPart.endYA, myShape.top1Part.radius1A, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.leftPart.endYC =
			
			arcX.getYusingX(myShape.leftPart.startXC, myShape.leftPart.startYC, myShape.leftPart.endXC,
						myShape.leftPart.endYC, myShape.top1Part.radius1BA, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.leftPart.endYBA =
			
			arcX.getYusingX(myShape.leftPart.startXBA, myShape.leftPart.startYBA, myShape.leftPart.endXBA,
						myShape.leftPart.endYBA, myShape.top1Part.radius1BA, myShape.top1Part.x1, myShape.top1Part.y1,
						false);
			
			myShape.leftPart.endYA =
			
			arcX.getYusingX(myShape.leftPart.startXA, myShape.leftPart.startYA, myShape.leftPart.endXA,
						myShape.leftPart.endYA, myShape.top1Part.radius1BA, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
		}
		else if (myShape.top1Part.endTypeRB == 3)
		{
			
			myShape.leftPart.endTypeLT = 2;
			
			myShape.top1Part.startYC =
			
			arcX.getYusingX(myShape.leftPart.startXBA, myShape.leftPart.startYBA, myShape.leftPart.endXBA,
						myShape.leftPart.endYBA, myShape.top1Part.radius1, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.top1Part.startYBA =
			
			arcX.getYusingX(myShape.leftPart.startXBA, myShape.leftPart.startYBA, myShape.leftPart.endXBA,
						myShape.leftPart.endYBA, myShape.top1Part.radius1BA, myShape.top1Part.x1, myShape.top1Part.y1,
						false);
			
			myShape.top1Part.startYA =
			
			arcX.getYusingX(myShape.leftPart.startXBA, myShape.leftPart.startYBA, myShape.leftPart.endXBA,
						myShape.leftPart.endYBA, myShape.top1Part.radius1BA, myShape.top1Part.x1, myShape.top1Part.y1,
						false);
			
			myShape.leftPart.endYC =
			
			arcX.getYusingX(myShape.leftPart.startXC, myShape.leftPart.startYC, myShape.leftPart.endXC,
						myShape.leftPart.endYC, myShape.top1Part.radius1, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.leftPart.endYBA =
			
			arcX.getYusingX(myShape.leftPart.startXBA, myShape.leftPart.startYBA, myShape.leftPart.endXBA,
						myShape.leftPart.endYBA, myShape.top1Part.radius1BA, myShape.top1Part.x1, myShape.top1Part.y1,
						false);
			
			myShape.leftPart.endYA =
			
			arcX.getYusingX(myShape.leftPart.startXA, myShape.leftPart.startYA, myShape.leftPart.endXA,
						myShape.leftPart.endYA, myShape.top1Part.radius1A, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
		}
	}
	
	public void top2BotIntersectionX(final ShapeObject myShape, final EllipseLineIntersections arcX, final boolean pos)
	{
	
		if (myShape.top2Part.endTypeLT == 1)
		{
			myShape.bot1Part.endTypeRB = 1;
			myShape.top2Part.endXC = myShape.bot1Part.startXC = arcX.getXusingY(myShape.bot1Part.startXC,
						myShape.bot1Part.startYC, myShape.bot1Part.endXC, myShape.bot1Part.endYC, myShape.top2Part.radius1,
						myShape.top2Part.x1, myShape.top2Part.y1, pos);
			
			myShape.top2Part.endXBA = myShape.bot1Part.startXBA = arcX.getXusingY(myShape.bot1Part.startXBA,
						myShape.bot1Part.startYBA, myShape.bot1Part.endXBA, myShape.bot1Part.endYBA,
						myShape.top2Part.radius1BA, myShape.top2Part.x1, myShape.top2Part.y1, pos);
			
			myShape.top2Part.endXA = myShape.bot1Part.startXA = arcX.getXusingY(myShape.bot1Part.startXA,
						myShape.bot1Part.startYA, myShape.bot1Part.endXA, myShape.bot1Part.endYA,
						myShape.top2Part.radius1A, myShape.top2Part.x1, myShape.top2Part.y1, pos);
		}
		if (myShape.top2Part.endTypeLT == 2)
		{
			myShape.bot1Part.endTypeRB = 3;
			myShape.top2Part.endXC =
			
			arcX.getXusingY(myShape.bot1Part.startXC, myShape.bot1Part.startYC, myShape.bot1Part.endXC,
						myShape.bot1Part.endYC, myShape.top2Part.radius1, myShape.top2Part.x1, myShape.top2Part.y1, pos);
			
			myShape.top2Part.endXBA =
			
			arcX.getXusingY(myShape.bot1Part.startXC, myShape.bot1Part.startYC, myShape.bot1Part.endXC,
						myShape.bot1Part.endYC, myShape.top2Part.radius1BA, myShape.top2Part.x1, myShape.top2Part.y1, pos);
			
			myShape.top2Part.endXA =
			
			arcX.getXusingY(myShape.bot1Part.startXA, myShape.bot1Part.startYA, myShape.bot1Part.endXA,
						myShape.bot1Part.endYA, myShape.top2Part.radius1A, myShape.top2Part.x1, myShape.top2Part.y1, pos);
			
			myShape.bot1Part.startXC =
			
			arcX.getXusingY(myShape.bot1Part.startXC, myShape.bot1Part.startYC, myShape.bot1Part.endXC,
						myShape.bot1Part.endYC, myShape.top2Part.radius1BA, myShape.top2Part.x1, myShape.top2Part.y1, pos);
			
			myShape.bot1Part.startXBA =
			
			arcX.getXusingY(myShape.bot1Part.startXC, myShape.bot1Part.startYC, myShape.bot1Part.endXC,
						myShape.bot1Part.endYC, myShape.top2Part.radius1BA, myShape.top2Part.x1, myShape.top2Part.y1, pos);
			
			myShape.bot1Part.startXA =
			
			arcX.getXusingY(myShape.bot1Part.startXA, myShape.bot1Part.startYA, myShape.bot1Part.endXA,
						myShape.bot1Part.endYA, myShape.top2Part.radius1BA, myShape.top2Part.x1, myShape.top2Part.y1, pos);
		}
		if (myShape.top2Part.endTypeLT == 3)
		{
			myShape.bot1Part.endTypeRB = 2;
			myShape.top2Part.endXC =
			
			arcX.getXusingY(myShape.bot1Part.startXBA, myShape.bot1Part.startYBA, myShape.bot1Part.endXBA,
						myShape.bot1Part.endYBA, myShape.top2Part.radius1, myShape.top2Part.x1, myShape.top2Part.y1, pos);
			
			myShape.top2Part.endXBA =
			
			arcX.getXusingY(myShape.bot1Part.startXBA, myShape.bot1Part.startYBA, myShape.bot1Part.endXBA,
						myShape.bot1Part.endYBA, myShape.top2Part.radius1BA, myShape.top2Part.x1, myShape.top2Part.y1, pos);
			
			myShape.top2Part.endXA =
			
			arcX.getXusingY(myShape.bot1Part.startXBA, myShape.bot1Part.startYBA, myShape.bot1Part.endXBA,
						myShape.bot1Part.endYBA, myShape.top2Part.radius1A, myShape.top2Part.x1, myShape.top2Part.y1, pos);
			
			myShape.bot1Part.startXC =
			
			arcX.getXusingY(myShape.bot1Part.startXC, myShape.bot1Part.startYC, myShape.bot1Part.endXC,
						myShape.bot1Part.endYC, myShape.top2Part.radius1, myShape.top2Part.x1, myShape.top2Part.y1, pos);
			
			myShape.bot1Part.startXBA =
			
			arcX.getXusingY(myShape.bot1Part.startXC, myShape.bot1Part.startYC, myShape.bot1Part.endXC,
						myShape.bot1Part.endYC, myShape.top2Part.radius1, myShape.top2Part.x1, myShape.top2Part.y1, pos);
			
			myShape.bot1Part.startXA =
			
			arcX.getXusingY(myShape.bot1Part.startXA, myShape.bot1Part.startYA, myShape.bot1Part.endXA,
						myShape.bot1Part.endYA, myShape.top2Part.radius1A, myShape.top2Part.x1, myShape.top2Part.y1, pos);
		}
	}
	
	public void top1RightIntersectionY(final ShapeObject myShape, final EllipseLineIntersections arcX)
	{
	
		if (myShape.top1Part.endTypeLT == 1)
		{
			myShape.rightPart.endTypeRB = 1;
			myShape.top1Part.endYC = myShape.rightPart.startYC = arcX.getYusingX(myShape.rightPart.startXC,
						myShape.rightPart.startYC, myShape.rightPart.endXC, myShape.rightPart.endYC,
						myShape.top1Part.radius1, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.top1Part.endYBA = myShape.rightPart.startYBA = arcX.getYusingX(myShape.rightPart.startXBA,
						myShape.rightPart.startYBA, myShape.rightPart.endXBA, myShape.rightPart.endYBA,
						myShape.top1Part.radius1BA, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.top1Part.endYA = myShape.rightPart.startYA = arcX.getYusingX(myShape.rightPart.startXA,
						myShape.rightPart.startYA, myShape.rightPart.endXA, myShape.rightPart.endYA,
						myShape.top1Part.radius1A, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
		}
		else if (myShape.top1Part.endTypeLT == 2)
		{
			myShape.rightPart.endTypeRB = 3;
			
			myShape.top1Part.endYC =
			
			arcX.getYusingX(myShape.rightPart.startXC, myShape.rightPart.startYC, myShape.rightPart.endXC,
						myShape.rightPart.endYC, myShape.top1Part.radius1, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.top1Part.endYBA =
			
			arcX.getYusingX(myShape.rightPart.startXC, myShape.rightPart.startYC, myShape.rightPart.endXC,
						myShape.rightPart.endYC, myShape.top1Part.radius1BA, myShape.top1Part.x1, myShape.top1Part.y1,
						false);
			
			myShape.top1Part.endYA =
			
			arcX.getYusingX(myShape.rightPart.startXA, myShape.rightPart.startYA, myShape.rightPart.endXA,
						myShape.rightPart.endYA, myShape.top1Part.radius1A, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.rightPart.startYC =
			
			arcX.getYusingX(myShape.rightPart.startXC, myShape.rightPart.startYC, myShape.rightPart.endXC,
						myShape.rightPart.endYC, myShape.top1Part.radius1, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.rightPart.startYBA =
			
			arcX.getYusingX(myShape.rightPart.startXBA, myShape.rightPart.startYBA, myShape.rightPart.endXBA,
						myShape.rightPart.endYBA, myShape.top1Part.radius1BA, myShape.top1Part.x1, myShape.top1Part.y1,
						false);
			
			myShape.rightPart.startYA =
			
			arcX.getYusingX(myShape.rightPart.startXA, myShape.rightPart.startYA, myShape.rightPart.endXA,
						myShape.rightPart.endYA, myShape.top1Part.radius1A, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
		}
		else if (myShape.top1Part.endTypeLT == 3)
		{
			
			myShape.rightPart.endTypeRB = 2;
			
			myShape.top1Part.endYC =
			
			arcX.getYusingX(myShape.rightPart.startXBA, myShape.rightPart.startYBA, myShape.rightPart.endXBA,
						myShape.rightPart.endYBA, myShape.top1Part.radius1, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.top1Part.endYBA =
			
			arcX.getYusingX(myShape.rightPart.startXBA, myShape.rightPart.startYBA, myShape.rightPart.endXBA,
						myShape.rightPart.endYBA, myShape.top1Part.radius1BA, myShape.top1Part.x1, myShape.top1Part.y1,
						false);
			
			myShape.top1Part.endYA =
			
			arcX.getYusingX(myShape.rightPart.startXBA, myShape.rightPart.startYBA, myShape.rightPart.endXBA,
						myShape.rightPart.endYBA, myShape.top1Part.radius1A, myShape.top1Part.x1, myShape.top1Part.y1,
						false);
			
			myShape.rightPart.startYC =
			
			arcX.getYusingX(myShape.rightPart.startXC, myShape.rightPart.startYC, myShape.rightPart.endXC,
						myShape.rightPart.endYC, myShape.top1Part.radius1, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.rightPart.startYBA =
			
			arcX.getYusingX(myShape.rightPart.startXBA, myShape.rightPart.startYBA, myShape.rightPart.endXBA,
						myShape.rightPart.endYBA, myShape.top1Part.radius1BA, myShape.top1Part.x1, myShape.top1Part.y1,
						false);
			
			myShape.rightPart.startYA =
			
			arcX.getYusingX(myShape.rightPart.startXA, myShape.rightPart.startYA, myShape.rightPart.endXA,
						myShape.rightPart.endYA, myShape.top1Part.radius1A, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
		}
		
		if (myShape.shapeID == 200 || myShape.shapeID == 201)
		{
			myShape.top1Part.startYBA = myShape.top1Part.startYA = myShape.top1Part.startYC;
		}
		if (myShape.shapeID == 200 || myShape.shapeID == 202)
		{
			myShape.top1Part.endYBA = myShape.top1Part.endYA = myShape.top1Part.endYC;
		}
		
	}
	
	public void top2RightIntersectionY(final ShapeObject myShape, final EllipseLineIntersections arcX)
	{
	
		if (myShape.top1Part.endTypeLT == 1)
		{
			myShape.rightPart.endTypeRB = 1;
			myShape.top2Part.endYC = myShape.rightPart.startYC = arcX.getYusingX(myShape.rightPart.startXC,
						myShape.rightPart.startYC, myShape.rightPart.endXC, myShape.rightPart.endYC,
						myShape.top2Part.radius1, myShape.top2Part.x1, myShape.top2Part.y1, false);
			
			myShape.top2Part.endYBA = myShape.rightPart.startYBA = arcX.getYusingX(myShape.rightPart.startXBA,
						myShape.rightPart.startYBA, myShape.rightPart.endXBA, myShape.rightPart.endYBA,
						myShape.top2Part.radius1BA, myShape.top2Part.x1, myShape.top2Part.y1, false);
			
			myShape.top2Part.endYA = myShape.rightPart.startYA = arcX.getYusingX(myShape.rightPart.startXA,
						myShape.rightPart.startYA, myShape.rightPart.endXA, myShape.rightPart.endYA,
						myShape.top2Part.radius1A, myShape.top2Part.x1, myShape.top2Part.y1, false);
			
		}
		else if (myShape.top2Part.endTypeLT == 2)
		{
			myShape.rightPart.endTypeRB = 3;
			
			myShape.top2Part.endYC =
			
			arcX.getYusingX(myShape.rightPart.startXC, myShape.rightPart.startYC, myShape.rightPart.endXC,
						myShape.rightPart.endYC, myShape.top2Part.radius1, myShape.top2Part.x1, myShape.top2Part.y1, false);
			
			myShape.top2Part.endYBA =
			
			arcX.getYusingX(myShape.rightPart.startXC, myShape.rightPart.startYC, myShape.rightPart.endXC,
						myShape.rightPart.endYC, myShape.top2Part.radius1BA, myShape.top2Part.x1, myShape.top2Part.y1,
						false);
			
			myShape.top2Part.endYA =
			
			arcX.getYusingX(myShape.rightPart.startXA, myShape.rightPart.startYA, myShape.rightPart.endXA,
						myShape.rightPart.endYA, myShape.top2Part.radius1A, myShape.top2Part.x1, myShape.top2Part.y1, false);
			
			myShape.rightPart.startYC =
			
			arcX.getYusingX(myShape.rightPart.startXC, myShape.rightPart.startYC, myShape.rightPart.endXC,
						myShape.rightPart.endYC, myShape.top2Part.radius1BA, myShape.top2Part.x1, myShape.top2Part.y1,
						false);
			
			myShape.rightPart.startYBA =
			
			arcX.getYusingX(myShape.rightPart.startXBA, myShape.rightPart.startYBA, myShape.rightPart.endXBA,
						myShape.rightPart.endYBA, myShape.top2Part.radius1BA, myShape.top2Part.x1, myShape.top2Part.y1,
						false);
			
			myShape.rightPart.startYA =
			
			arcX.getYusingX(myShape.rightPart.startXA, myShape.rightPart.startYA, myShape.rightPart.endXA,
						myShape.rightPart.endYA, myShape.top2Part.radius1BA, myShape.top2Part.x1, myShape.top2Part.y1,
						false);
			
		}
		else if (myShape.top2Part.endTypeLT == 3)
		{
			
			myShape.rightPart.endTypeRB = 2;
			
			myShape.top2Part.endYC =
			
			arcX.getYusingX(myShape.rightPart.startXBA, myShape.rightPart.startYBA, myShape.rightPart.endXBA,
						myShape.rightPart.endYBA, myShape.top2Part.radius1, myShape.top2Part.x1, myShape.top2Part.y1, false);
			
			myShape.top2Part.endYBA =
			
			arcX.getYusingX(myShape.rightPart.startXBA, myShape.rightPart.startYBA, myShape.rightPart.endXBA,
						myShape.rightPart.endYBA, myShape.top2Part.radius1BA, myShape.top2Part.x1, myShape.top2Part.y1,
						false);
			
			myShape.top2Part.endYA =
			
			arcX.getYusingX(myShape.rightPart.startXBA, myShape.rightPart.startYBA, myShape.rightPart.endXBA,
						myShape.rightPart.endYBA, myShape.top2Part.radius1BA, myShape.top2Part.x1, myShape.top2Part.y1,
						false);
			
			myShape.rightPart.startYC =
			
			arcX.getYusingX(myShape.rightPart.startXC, myShape.rightPart.startYC, myShape.rightPart.endXC,
						myShape.rightPart.endYC, myShape.top2Part.radius1, myShape.top2Part.x1, myShape.top2Part.y1, false);
			
			myShape.rightPart.startYBA =
			
			arcX.getYusingX(myShape.rightPart.startXBA, myShape.rightPart.startYBA, myShape.rightPart.endXBA,
						myShape.rightPart.endYBA, myShape.top2Part.radius1, myShape.top2Part.x1, myShape.top2Part.y1, false);
			
			myShape.rightPart.startYA =
			
			arcX.getYusingX(myShape.rightPart.startXA, myShape.rightPart.startYA, myShape.rightPart.endXA,
						myShape.rightPart.endYA, myShape.top2Part.radius1A, myShape.top2Part.x1, myShape.top2Part.y1, false);
			
		}
	}
	
	public void top1BotIntersectionX(final ShapeObject myShape, final EllipseLineIntersections arcX, final boolean pos)
	{
	
		if (myShape.top1Part.endTypeRB == 1)
		{
			myShape.bot1Part.endTypeLT = 1;
			myShape.top1Part.startXC = myShape.bot1Part.endXC = arcX.getXusingY(myShape.bot1Part.startXC,
						myShape.bot1Part.startYC, myShape.bot1Part.endXC, myShape.bot1Part.endYC, myShape.top1Part.radius1,
						myShape.top1Part.x1, myShape.top1Part.y1, pos);
			
			myShape.top1Part.startXBA = myShape.bot1Part.endXBA = arcX.getXusingY(myShape.bot1Part.startXBA,
						myShape.bot1Part.startYBA, myShape.bot1Part.endXBA, myShape.bot1Part.endYBA,
						myShape.top1Part.radius1BA, myShape.top1Part.x1, myShape.top1Part.y1, pos);
			
			myShape.top1Part.startXA = myShape.bot1Part.endXA = arcX.getXusingY(myShape.bot1Part.startXA,
						myShape.bot1Part.startYA, myShape.bot1Part.endXA, myShape.bot1Part.endYA,
						myShape.top1Part.radius1A, myShape.top1Part.x1, myShape.top1Part.y1, pos);
			
		}
		else if (myShape.top1Part.endTypeRB == 2)
		{
			myShape.bot1Part.endTypeLT = 3;
			
			myShape.top1Part.startXC = arcX.getXusingY(myShape.bot1Part.startXC, myShape.bot1Part.startYC,
						myShape.bot1Part.endXC, myShape.bot1Part.endYC, myShape.top1Part.radius1, myShape.top1Part.x1,
						myShape.top1Part.y1, pos);
			
			myShape.top1Part.startXBA = arcX.getXusingY(myShape.bot1Part.startXC, myShape.bot1Part.startYC,
						myShape.bot1Part.endXC, myShape.bot1Part.endYC, myShape.top1Part.radius1BA, myShape.top1Part.x1,
						myShape.top1Part.y1, pos);
			
			myShape.top1Part.startXA = arcX.getXusingY(myShape.bot1Part.startXA, myShape.bot1Part.startYA,
						myShape.bot1Part.endXA, myShape.bot1Part.endYA, myShape.top1Part.radius1A, myShape.top1Part.x1,
						myShape.top1Part.y1, pos);
			
			myShape.bot1Part.endXC = arcX.getXusingY(myShape.bot1Part.startXC, myShape.bot1Part.startYC,
						myShape.bot1Part.endXC, myShape.bot1Part.endYC, myShape.top1Part.radius1BA, myShape.top1Part.x1,
						myShape.top1Part.y1, pos);
			
			myShape.bot1Part.endXBA = arcX.getXusingY(myShape.bot1Part.startXBA, myShape.bot1Part.startYBA,
						myShape.bot1Part.endXBA, myShape.bot1Part.endYBA, myShape.top1Part.radius1BA, myShape.top1Part.x1,
						myShape.top1Part.y1, pos);
			
			myShape.bot1Part.endXA = arcX.getXusingY(myShape.bot1Part.startXA, myShape.bot1Part.startYA,
						myShape.bot1Part.endXA, myShape.bot1Part.endYA, myShape.top1Part.radius1BA, myShape.top1Part.x1,
						myShape.top1Part.y1, pos);
			
		}
		else if (myShape.top1Part.endTypeRB == 3)
		{
			myShape.bot1Part.endTypeLT = 2;
			
			myShape.top1Part.startXC = arcX.getXusingY(myShape.bot1Part.startXBA, myShape.bot1Part.startYBA,
						myShape.bot1Part.endXBA, myShape.bot1Part.endYBA, myShape.top1Part.radius1, myShape.top1Part.x1,
						myShape.top1Part.y1, pos);
			
			myShape.top1Part.startXBA = arcX.getXusingY(myShape.bot1Part.startXBA, myShape.bot1Part.startYBA,
						myShape.bot1Part.endXBA, myShape.bot1Part.endYBA, myShape.top1Part.radius1BA, myShape.top1Part.x1,
						myShape.top1Part.y1, pos);
			
			myShape.top1Part.startXA = arcX.getXusingY(myShape.bot1Part.startXBA, myShape.bot1Part.startYBA,
						myShape.bot1Part.endXBA, myShape.bot1Part.endYBA, myShape.top1Part.radius1A, myShape.top1Part.x1,
						myShape.top1Part.y1, pos);
			
			myShape.bot1Part.endXC = arcX.getXusingY(myShape.bot1Part.startXC, myShape.bot1Part.startYC,
						myShape.bot1Part.endXC, myShape.bot1Part.endYC, myShape.top1Part.radius1, myShape.top1Part.x1,
						myShape.top1Part.y1, pos);
			
			myShape.bot1Part.endXBA = arcX.getXusingY(myShape.bot1Part.startXBA, myShape.bot1Part.startYBA,
						myShape.bot1Part.endXBA, myShape.bot1Part.endYBA, myShape.top1Part.radius1, myShape.top1Part.x1,
						myShape.top1Part.y1, pos);
			
			myShape.bot1Part.endXA = arcX.getXusingY(myShape.bot1Part.startXA, myShape.bot1Part.startYA,
						myShape.bot1Part.endXA, myShape.bot1Part.endYA, myShape.top1Part.radius1A, myShape.top1Part.x1,
						myShape.top1Part.y1, pos);
			
		}
	}
	
	public void top1BotIntersectionY(final ShapeObject myShape, final EllipseLineIntersections arcX)
	{
	
		if (myShape.top1Part.endTypeRB == 1)
		{
			myShape.bot1Part.endTypeLT = 1;
			myShape.top1Part.startYC = myShape.bot1Part.endYC = arcX.getYusingX(myShape.bot1Part.endXC,
						myShape.bot1Part.endYC, myShape.bot1Part.startXC, myShape.bot1Part.startYC,
						
						myShape.top1Part.radius1, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.top1Part.startYBA = myShape.bot1Part.endYBA = arcX.getYusingX(myShape.bot1Part.endXBA,
						myShape.bot1Part.endYBA, myShape.bot1Part.startXBA, myShape.bot1Part.startYBA,
						
						myShape.top1Part.radius1BA, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.top1Part.startYA = myShape.bot1Part.endYA = arcX.getYusingX(myShape.bot1Part.endXA,
						myShape.bot1Part.endYA, myShape.bot1Part.startXA, myShape.bot1Part.startYA,
						
						myShape.top1Part.radius1A, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
		}
		else if (myShape.top1Part.endTypeRB == 2)
		{
			myShape.bot1Part.endTypeLT = 3;
			
			myShape.top1Part.startYC = arcX.getYusingX(myShape.bot1Part.startXC, myShape.bot1Part.startYC,
						myShape.bot1Part.endXC, myShape.bot1Part.endYC, myShape.top1Part.radius1, myShape.top1Part.x1,
						myShape.top1Part.y1, false);
			
			myShape.top1Part.startYBA = arcX.getYusingX(myShape.bot1Part.startXC, myShape.bot1Part.startYC,
						myShape.bot1Part.endXC, myShape.bot1Part.endYC, myShape.top1Part.radius1BA, myShape.top1Part.x1,
						myShape.top1Part.y1, false);
			
			myShape.top1Part.startYA = arcX.getYusingX(myShape.bot1Part.startXA, myShape.bot1Part.startYA,
						myShape.bot1Part.endXA, myShape.bot1Part.endYA, myShape.top1Part.radius1A, myShape.top1Part.x1,
						myShape.top1Part.y1, false);
			
			myShape.bot1Part.endYC = arcX.getYusingX(myShape.bot1Part.startXC, myShape.bot1Part.startYC,
						myShape.bot1Part.endXC, myShape.bot1Part.endYC, myShape.top1Part.radius1BA, myShape.top1Part.x1,
						myShape.top1Part.y1, false);
			
			myShape.bot1Part.endYBA = arcX.getYusingX(myShape.bot1Part.startXBA, myShape.bot1Part.startYBA,
						myShape.bot1Part.endXBA, myShape.bot1Part.endYBA, myShape.top1Part.radius1BA, myShape.top1Part.x1,
						myShape.top1Part.y1, false);
			
			myShape.bot1Part.endYA = arcX.getYusingX(myShape.bot1Part.startXA, myShape.bot1Part.startYA,
						myShape.bot1Part.endXA, myShape.bot1Part.endYA, myShape.top1Part.radius1BA, myShape.top1Part.x1,
						myShape.top1Part.y1, false);
			
		}
		else if (myShape.top1Part.endTypeRB == 3)
		{
			
		}
	}
	
	public void topBotIntersectionRightSideX(final ShapeObject myShape, final EllipseLineIntersections arcX)
	{
	
		if (myShape.top1Part.endTypeLT == 1)
		{
			myShape.bot1Part.endTypeRB = 1;
			myShape.top1Part.endXC = myShape.bot1Part.startXC = arcX.getXusingY(myShape.bot1Part.startXC,
						myShape.bot1Part.startYC, myShape.bot1Part.endXC, myShape.bot1Part.endYC, myShape.top1Part.radius1,
						myShape.top1Part.x1, myShape.top1Part.y1, true);
			
			myShape.top1Part.endXBA = myShape.bot1Part.startXBA = arcX.getXusingY(myShape.bot1Part.startXBA,
						myShape.bot1Part.startYBA, myShape.bot1Part.endXBA, myShape.bot1Part.endYBA,
						myShape.top1Part.radius1BA, myShape.top1Part.x1, myShape.top1Part.y1, true);
			
			myShape.top1Part.endXA = myShape.bot1Part.startXA = arcX.getXusingY(myShape.bot1Part.startXA,
						myShape.bot1Part.startYA, myShape.bot1Part.endXA, myShape.bot1Part.endYA,
						myShape.top1Part.radius1A, myShape.top1Part.x1, myShape.top1Part.y1, true);
		}
		if (myShape.top1Part.endTypeLT == 2)
		{
			myShape.bot1Part.endTypeRB = 3;
			myShape.top1Part.endXC =
			
			arcX.getXusingY(myShape.bot1Part.startXC, myShape.bot1Part.startYC, myShape.bot1Part.endXC,
						myShape.bot1Part.endYC, myShape.top1Part.radius1, myShape.top1Part.x1, myShape.top1Part.y1, true);
			
			myShape.top1Part.endXBA = arcX.getXusingY(myShape.bot1Part.startXC, myShape.bot1Part.startYC,
						myShape.bot1Part.endXC, myShape.bot1Part.endYC, myShape.top1Part.radius1BA, myShape.top1Part.x1,
						myShape.top1Part.y1, true);
			
			myShape.top1Part.endXA = arcX.getXusingY(myShape.bot1Part.startXA, myShape.bot1Part.startYA,
						myShape.bot1Part.endXA, myShape.bot1Part.endYA, myShape.top1Part.radius1A, myShape.top1Part.x1,
						myShape.top1Part.y1, true);
			
			myShape.bot1Part.startXC = arcX.getXusingY(myShape.bot1Part.startXC, myShape.bot1Part.startYC,
						myShape.bot1Part.endXC, myShape.bot1Part.endYC, myShape.top1Part.radius1BA, myShape.top1Part.x1,
						myShape.top1Part.y1, true);
			
			myShape.bot1Part.startXBA = arcX.getXusingY(myShape.bot1Part.startXC, myShape.bot1Part.startYC,
						myShape.bot1Part.endXC, myShape.bot1Part.endYC, myShape.top1Part.radius1BA, myShape.top1Part.x1,
						myShape.top1Part.y1, true);
			
			myShape.bot1Part.startXA = arcX.getXusingY(myShape.bot1Part.startXA, myShape.bot1Part.startYA,
						myShape.bot1Part.endXA, myShape.bot1Part.endYA, myShape.top1Part.radius1BA, myShape.top1Part.x1,
						myShape.top1Part.y1, true);
		}
		if (myShape.top1Part.endTypeLT == 3)
		{
			myShape.bot1Part.endTypeRB = 2;
			myShape.top1Part.endXC = arcX.getXusingY(myShape.bot1Part.startXBA, myShape.bot1Part.startYBA,
						myShape.bot1Part.endXBA, myShape.bot1Part.endYBA, myShape.top1Part.radius1, myShape.top1Part.x1,
						myShape.top1Part.y1, true);
			
			myShape.top1Part.endXBA = arcX.getXusingY(myShape.bot1Part.startXBA, myShape.bot1Part.startYBA,
						myShape.bot1Part.endXBA, myShape.bot1Part.endYBA, myShape.top1Part.radius1BA, myShape.top1Part.x1,
						myShape.top1Part.y1, true);
			
			myShape.top1Part.endXA = arcX.getXusingY(myShape.bot1Part.startXBA, myShape.bot1Part.startYBA,
						myShape.bot1Part.endXBA, myShape.bot1Part.endYBA, myShape.top1Part.radius1A, myShape.top1Part.x1,
						myShape.top1Part.y1, true);
			
			myShape.bot1Part.startXC = arcX.getXusingY(myShape.bot1Part.startXC, myShape.bot1Part.startYC,
						myShape.bot1Part.endXC, myShape.bot1Part.endYC, myShape.top1Part.radius1, myShape.top1Part.x1,
						myShape.top1Part.y1, true);
			
			myShape.bot1Part.startXBA = arcX.getXusingY(myShape.bot1Part.startXC, myShape.bot1Part.startYC,
						myShape.bot1Part.endXC, myShape.bot1Part.endYC, myShape.top1Part.radius1, myShape.top1Part.x1,
						myShape.top1Part.y1, true);
			
			myShape.bot1Part.startXA = arcX.getXusingY(myShape.bot1Part.startXA, myShape.bot1Part.startYA,
						myShape.bot1Part.endXA, myShape.bot1Part.endYA, myShape.top1Part.radius1A, myShape.top1Part.x1,
						myShape.top1Part.y1, true);
		}
	}
	
	public void top1BotIntersectionYRightSide(final ShapeObject myShape, final EllipseLineIntersections arcX)
	{
	
		if (myShape.top1Part.endTypeRB == 1)
		{
			myShape.bot1Part.endTypeLT = 1;
			myShape.top1Part.endYC = myShape.bot1Part.startYC = arcX.getYusingX(myShape.bot1Part.startXC,
						myShape.bot1Part.startYC, myShape.bot1Part.endXC, myShape.bot1Part.endYC, myShape.top1Part.radius1,
						myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.top1Part.endYBA = myShape.bot1Part.startYBA = arcX.getYusingX(myShape.bot1Part.startXBA,
						myShape.bot1Part.startYBA, myShape.bot1Part.endXBA, myShape.bot1Part.endYBA,
						myShape.top1Part.radius1BA, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
			myShape.top1Part.endYA = myShape.bot1Part.startYA = arcX.getYusingX(myShape.bot1Part.startXA,
						myShape.bot1Part.startYA, myShape.bot1Part.endXA, myShape.bot1Part.endYA,
						myShape.top1Part.radius1A, myShape.top1Part.x1, myShape.top1Part.y1, false);
			
		}
		else if (myShape.top1Part.endTypeRB == 2)
		{
			myShape.bot1Part.endTypeLT = 3;
			
			myShape.top1Part.endYC = arcX.getYusingX(myShape.bot1Part.startXC, myShape.bot1Part.startYC,
						myShape.bot1Part.endXC, myShape.bot1Part.endYC, myShape.top1Part.radius1, myShape.top1Part.x1,
						myShape.top1Part.y1, false);
			
			myShape.top1Part.endYBA = arcX.getYusingX(myShape.bot1Part.startXC, myShape.bot1Part.startYC,
						myShape.bot1Part.endXC, myShape.bot1Part.endYC, myShape.top1Part.radius1BA, myShape.top1Part.x1,
						myShape.top1Part.y1, false);
			
			myShape.top1Part.endYA = arcX.getYusingX(myShape.bot1Part.startXA, myShape.bot1Part.startYA,
						myShape.bot1Part.endXA, myShape.bot1Part.endYA, myShape.top1Part.radius1A, myShape.top1Part.x1,
						myShape.top1Part.y1, false);
			
			myShape.bot1Part.startYC = arcX.getYusingX(myShape.bot1Part.startXC, myShape.bot1Part.startYC,
						myShape.bot1Part.endXC, myShape.bot1Part.endYC, myShape.top1Part.radius1BA, myShape.top1Part.x1,
						myShape.top1Part.y1, false);
			
			myShape.bot1Part.startYBA = arcX.getYusingX(myShape.bot1Part.startXBA, myShape.bot1Part.startYBA,
						myShape.bot1Part.endXBA, myShape.bot1Part.endYBA, myShape.top1Part.radius1BA, myShape.top1Part.x1,
						myShape.top1Part.y1, false);
			
			myShape.bot1Part.startYA = arcX.getYusingX(myShape.bot1Part.startXA, myShape.bot1Part.startYA,
						myShape.bot1Part.endXA, myShape.bot1Part.endYA, myShape.top1Part.radius1BA, myShape.top1Part.x1,
						myShape.top1Part.y1, false);
			
		}
		else if (myShape.top1Part.endTypeRB == 3)
		{
			myShape.bot1Part.endTypeLT = 2;
			
		}
	}
	
	public void setPart2CurveInfo(final ShapeObject myShape)
	{
	
		if (myParent.topIn && myParent.botIn && myParent.leftIn)
		{
			
		}
		boolean useYL = false;
		boolean useYR = false;
		if (myShape.noSidesLeft == 0)
		{
			useYL = true;
		}
		if (myShape.noSidesRight == 0)
		{
			useYR = true;
		}
		
		if (myParent.noSidesTop == 2 && myParent.top2Part.partForm >= 2)
		{
			
			myShape.top2Part.radius1 = myParent.top2Part.radius1 - myShape.clearanceTop + top2DimCo;
			myShape.top2Part.radius2 = myParent.top2Part.radius2 - myShape.clearanceTop + top2DimCo;
			myShape.top2Part.radius1BA = myParent.top2Part.radius1 - myShape.clearanceTop - top2DimBo;
			myShape.top2Part.radius2BA = myParent.top2Part.radius2 - myShape.clearanceTop - top2DimBo;
			myShape.top2Part.radius1A = myParent.top2Part.radius1 - top2DimAo - top2DimBo;
			myShape.top2Part.radius2A = myParent.top2Part.radius2 - top2DimAo - top2DimBo;
			
			myShape.top2Part.bkgrdWidth = myShape.top2Part.bkgrdHeight = myShape.top2Part.radius1 * 2;
			myShape.top2Part.bkgrdWidthBA = myShape.top2Part.bkgrdHeightBA = myShape.top2Part.radius1BA * 2;
			myShape.top2Part.bkgrdWidthA = myShape.top2Part.bkgrdHeightA = myShape.top2Part.radius1A * 2;
			
			myShape.top2Part.x1 = myShape.top2Part.x1BA = myShape.top2Part.x1A = myParent.top2Part.x1;
			
			myShape.top2Part.y1 = myShape.top2Part.y1BA = myShape.top2Part.y1A = myParent.top2Part.y1;
			
			myShape.top2Part.x2 = myShape.top2Part.x2BA = myShape.top2Part.x2A = myParent.top2Part.x2;
			
			myShape.top2Part.y2 = myShape.top2Part.y2BA = myShape.top2Part.y2A = myParent.top2Part.y2;
			
			myShape.top2Part.bkgrdStartX = myShape.top2Part.x1 - myShape.radius1;
			
			myShape.top2Part.bkgrdStartY = myShape.top2Part.y1 - myShape.radius1;
			
			myShape.top2Part.bkgrdStartXBA = myShape.top2Part.x1 - myShape.top2Part.radius1BA;
			
			myShape.top2Part.bkgrdStartYBA = myShape.top2Part.y1 - myShape.top2Part.radius1BA;
			
			myShape.top2Part.bkgrdStartXA = myShape.top2Part.x1 - myShape.top2Part.radius1A;
			
			myShape.top2Part.bkgrdStartYA = myShape.top2Part.y1 - myShape.top2Part.radius1A;
			
		}
		else if (myParent.noSidesTop == 1 && myParent.top1Part.partForm >= 2 && myShape.top2Part.partForm >= 2)
		{
			myShape.top2Part.radius1 = myParent.top1Part.radius1 - myShape.clearanceTop + top1DimCo;
			myShape.top2Part.radius2 = myParent.top1Part.radius2 - myShape.clearanceTop + top1DimCo;
			myShape.top2Part.radius1BA = myParent.top1Part.radius1 - myShape.clearanceTop - top1DimBo;
			myShape.top2Part.radius2BA = myParent.top1Part.radius2 - myShape.clearanceTop - top1DimBo;
			myShape.top2Part.radius1A = myParent.top1Part.radius1BA - top1DimAo;
			myShape.top2Part.radius2A = myParent.top1Part.radius2BA - top1DimAo;
			
			myShape.top2Part.bkgrdWidth = myShape.top2Part.bkgrdHeight = myShape.top2Part.radius1 * 2;
			myShape.top2Part.bkgrdWidthBA = myShape.top2Part.bkgrdHeightBA = myShape.top2Part.radius1BA * 2;
			myShape.top2Part.bkgrdWidthA = myShape.top2Part.bkgrdHeightA = myShape.top2Part.radius1A * 2;
			
			myShape.top2Part.x1 = myShape.top2Part.x1BA = myShape.top2Part.x1A = myParent.top1Part.x1;
			
			myShape.top2Part.y1 = myShape.top2Part.y1BA = myShape.top2Part.y1A = myParent.top1Part.y1;
			
			myShape.top2Part.x2 = myShape.top2Part.x2BA = myShape.top2Part.x2A = myParent.top1Part.x2;
			
			myShape.top2Part.y2 = myShape.top2Part.y2BA = myShape.top2Part.y2A = myParent.top1Part.y2;
			
			myShape.top2Part.bkgrdStartX = myShape.top2Part.x1 - myShape.radius1;
			
			myShape.top2Part.bkgrdStartY = myShape.top2Part.y1 - myShape.radius1;
			
			myShape.top2Part.bkgrdStartXBA = myShape.top2Part.x1 - myShape.top2Part.radius1BA;
			
			myShape.top2Part.bkgrdStartYBA = myShape.top2Part.y1 - myShape.top2Part.radius1BA;
			
			myShape.top2Part.bkgrdStartXA = myShape.top2Part.x1 - myShape.top2Part.radius1A;
			
			myShape.top2Part.bkgrdStartYA = myShape.top2Part.y1 - myShape.top2Part.radius1A;
		}
		double[] anglesOut = this
					.getArchesAngles(myShape.top2Part.startXC, myShape.top2Part.endXC, myShape.top2Part.startYC,
								myShape.top2Part.endYC, myShape.top2Part.radius1, myShape.top2Part.x1,
								myShape.top2Part.y1, useYL, useYR);
		
		double[] anglesMid = this.getArchesAngles(myShape.top2Part.startXBA, myShape.top2Part.endXBA,
					myShape.top2Part.startYBA, myShape.top2Part.endYBA, myShape.top2Part.radius1BA, myShape.top2Part.x1,
					myShape.top2Part.y1, useYL, useYR);
		
		double[] anglesIn = this.getArchesAngles(myShape.top2Part.startXA, myShape.top2Part.endXA, myShape.top2Part.startYA,
					myShape.top2Part.endYA, myShape.top2Part.radius1A, myShape.top2Part.x1, myShape.top2Part.y1, useYL,
					useYR);
		
		myShape.top2Part.startAngle = anglesOut[0];
		myShape.top2Part.endAngle = anglesOut[1];
		
		myShape.top2Part.startAngleBA = anglesMid[0];
		myShape.top2Part.endAngleBA = anglesMid[1];
		
		myShape.top2Part.startAngleA = anglesIn[0];
		myShape.top2Part.endAngleA = anglesIn[1];
		if (myShape.noSidesRight > 0)
		{
			if (myShape.top2Part.endTypeLT == 1 || myShape.top2Part.endTypeLT == 3)
			{
				anglesOut = this.getArchesAngles(myShape.top2Part.startXC, myShape.rightPart.startXC, 0, 0,
							myShape.top2Part.radius1, myShape.top2Part.x1, myShape.top2Part.y1, false, false);
			}
			else if (myShape.top2Part.endTypeLT == 2)
			{
				anglesOut = this.getArchesAngles(myShape.top2Part.startXBA, myShape.rightPart.startXC,
				
				0, 0, myShape.top2Part.radius1BA, myShape.top2Part.x1, myShape.top2Part.y1, false, false);
			}
			if (myShape.top2Part.endTypeLT == 1 || myShape.top2Part.endTypeLT == 2)
			{
				anglesMid = this.getArchesAngles(myShape.top2Part.startXBA, myShape.rightPart.startXBA,
				
				0, 0, myShape.top2Part.radius1BA, myShape.top2Part.x1, myShape.top2Part.y1, false, false);
			}
			else if (myShape.top2Part.endTypeLT == 3)
			{
				anglesMid = this.getArchesAngles(myShape.top2Part.startXC, myShape.rightPart.startXBA, 0, 0,
							myShape.top2Part.radius1, myShape.top2Part.x1, myShape.top2Part.y1, false, false);
			}
			if (myShape.top2Part.endTypeLT == 1 || myShape.top2Part.endTypeLT == 3)
			{
				anglesIn = this.getArchesAngles(myShape.top2Part.startXA, myShape.rightPart.startXA, 0, 0,
							myShape.top2Part.radius1A, myShape.top2Part.x1, myShape.top2Part.y1, false, false);
			}
			else if (myShape.top2Part.endTypeLT == 2)
			{
				anglesIn = this.getArchesAngles(myShape.top2Part.startXBA, myShape.rightPart.startXA,
				
				0, 0, myShape.top2Part.radius1BA, myShape.top2Part.x1, myShape.top2Part.y1, false, false);
			}
			
			myShape.rightPart.startYC = anglesOut[3];
			myShape.rightPart.startYBA = anglesMid[3];
			myShape.rightPart.startYA = anglesIn[3];
			myShape.rightPart.stopAsX = myShape.top2Part.endXA;
			myShape.rightPart.stopAsY = myShape.top2Part.endYA;
			
			if (myShape.top2Part.endTypeLT == 1)
			{
				myShape.rightPart.startYC = myShape.top2Part.endYC;
				myShape.rightPart.startYBA = myShape.top2Part.endYBA;
				myShape.rightPart.startYA = myShape.top2Part.endYA;
			}
		}
		
		if (myParent.noSidesTop == 2 && myShape.top1Part.partForm == 1 && myShape.top2Part.partForm == 2)
		{
			final EllipseLineIntersections arcX = new EllipseLineIntersections();
			if (myShape.top1Part.endTypeRB == 1)
			{
				myShape.top2Part.startXC = arcX.getXusingY(myShape.top1Part.startXC, myShape.top1Part.startYC,
							myShape.top1Part.endXC, myShape.top1Part.endYC, myShape.top2Part.radius1, myShape.top2Part.x1,
							myShape.top2Part.y1, true);
				
				myShape.top2Part.startXBA = arcX.getXusingY(myShape.top1Part.startXBA, myShape.top1Part.startYBA,
							myShape.top1Part.endXBA, myShape.top1Part.endYBA, myShape.top2Part.radius1BA,
							myShape.top2Part.x1, myShape.top2Part.y1, true);
				
				myShape.top2Part.endXA = arcX.getXusingY(myShape.top1Part.startXA, myShape.top1Part.startYA,
							myShape.top1Part.endXA, myShape.top1Part.endYA, myShape.top2Part.radius1A,
							myShape.top2Part.x1, myShape.top2Part.y1, true);
				
				myShape.top2Part.endTypeLT = 1;
				myShape.top1Part.endXC = myShape.top2Part.startXC;
				myShape.top1Part.endXA = myShape.top2Part.startXA;
				myShape.top1Part.endXBA = myShape.top2Part.startXBA;
				
			}
			else if (myShape.top1Part.endTypeLT == 3)
			{
				myShape.top2Part.startXC = arcX.getXusingY(myShape.top1Part.startXC, myShape.top1Part.startYC,
							myShape.top1Part.endXC, myShape.top1Part.endYC, myShape.top2Part.radius1, myShape.top2Part.x1,
							myShape.top2Part.y1, true);
				
				myShape.top2Part.startXBA = arcX.getXusingY(myShape.top1Part.startXC, myShape.top1Part.startYC,
							myShape.top1Part.endXC, myShape.top1Part.endYC, myShape.top2Part.radius1BA,
							myShape.top2Part.x1, myShape.top2Part.y1, true);
				
				myShape.top2Part.endXA = arcX.getXusingY(myShape.top1Part.startXA, myShape.top1Part.startYA,
							myShape.top1Part.endXA, myShape.top1Part.endYA, myShape.top2Part.radius1A,
							myShape.top2Part.x1, myShape.top2Part.y1, true);
				
				myShape.top2Part.endTypeLT = 2;
				myShape.top1Part.endXC =
				
				arcX.getXusingY(myShape.top1Part.startXC, myShape.top1Part.startYC, myShape.top1Part.endXC,
							myShape.top1Part.endYC, myShape.top2Part.radius1BA, myShape.top2Part.x1, myShape.top2Part.y1,
							false);
				myShape.top1Part.endXA =
				
				arcX.getXusingY(myShape.top1Part.startXA, myShape.top1Part.startYA, myShape.top1Part.endXA,
							myShape.top1Part.endYA, myShape.top2Part.radius1A, myShape.top2Part.x1, myShape.top2Part.y1,
							false);
				
				myShape.top1Part.endXBA =
				
				arcX.getXusingY(myShape.top1Part.startXBA, myShape.top1Part.startYBA, myShape.top1Part.endXBA,
							myShape.top1Part.endYBA, myShape.top2Part.radius1, myShape.top2Part.x1, myShape.top2Part.y1,
							false);
				
			}
			else if (myShape.top1Part.endTypeLT == 2)
			{
				myShape.top2Part.startXC = arcX.getXusingY(myShape.top1Part.startXBA, myShape.top1Part.startYBA,
							myShape.top1Part.endXBA, myShape.top1Part.endYBA, myShape.top2Part.radius1,
							myShape.top2Part.x1, myShape.top2Part.y1, true);
				
				myShape.top2Part.startXBA = arcX.getXusingY(myShape.top1Part.startXBA, myShape.top1Part.startYBA,
							myShape.top1Part.endXBA, myShape.top1Part.endYBA, myShape.top2Part.radius1BA,
							myShape.top2Part.x1, myShape.top2Part.y1, true);
				
				myShape.top2Part.endXA = arcX.getXusingY(myShape.top1Part.startXBA, myShape.top1Part.startYBA,
							myShape.top1Part.endXBA, myShape.top1Part.endYBA, myShape.top2Part.radius1A,
							myShape.top2Part.x1, myShape.top2Part.y1, true);
				
				myShape.top2Part.endTypeLT = 3;
				myShape.top1Part.endXC =
				
				arcX.getXusingY(myShape.top1Part.startXC, myShape.top1Part.startYC, myShape.top1Part.endXC,
							myShape.top1Part.endYC, myShape.top2Part.radius1, myShape.top2Part.x1, myShape.top2Part.y1,
							false);
				myShape.top1Part.endXA =
				
				arcX.getXusingY(myShape.top1Part.startXA, myShape.top1Part.startYA, myShape.top1Part.endXA,
							myShape.top1Part.endYA, myShape.top2Part.radius1A, myShape.top2Part.x1, myShape.top2Part.y1,
							false);
				
				myShape.top1Part.endXBA =
				
				arcX.getXusingY(myShape.top1Part.startXBA, myShape.top1Part.startYBA, myShape.top1Part.endXBA,
							myShape.top1Part.endYBA, myShape.top2Part.radius1, myShape.top2Part.x1, myShape.top2Part.y1,
							false);
				
			}
		}
		
	}
	
	public Collection setPartObjectsAndCollection(ShapeObject myShape)
	{
	
		Collection myParts = new ArrayList();
		
		myParts.clear();
		
		if (myShape.noSidesTop == 1)
		{
			myParts.add(myShape.top1Part);
		}
		else if (myShape.noSidesTop == 2)
		{
			myParts.add(myShape.top1Part);
			myParts.add(myShape.top2Part);
		}
		else if (myShape.noSidesTop == 3)
		{
			myParts.add(myShape.top1Part);
			myParts.add(myShape.top2Part);
			myParts.add(myShape.top3Part);
		}
		if (myShape.noSidesBot == 1)
		{
			myParts.add(myShape.bot1Part);
		}
		else if (myShape.noSidesBot == 2)
		{
			myParts.add(myShape.bot1Part);
			myParts.add(myShape.bot2Part);
		}
		else if (myShape.noSidesBot == 3)
		{
			myParts.add(myShape.bot1Part);
			myParts.add(myShape.bot2Part);
			myParts.add(myShape.bot3Part);
		}
		if (myShape.noSidesLeft == 1)
		{
			myParts.add(myShape.leftPart);
		}
		if (myShape.noSidesRight == 1)
		{
			myParts.add(myShape.rightPart);
		}
		
		return myParts;
	}
	
	public ShapeObject setPartObjectFromProfiles(final ShapeObject myShape)
	{
	
		// myShape.top1 =
		// this.myTop1Clone(myShape.top1, myShape.top1Part);
		// myShape.top2 =
		// this.myTop2Clone(myShape.top2, myShape.top2Part);
		// myShape.top3 =
		// this.myTop3Clone(myShape.top3, myShape.top3Part);
		// myShape.bot1 =
		// this.myBot1Clone(myShape.bot1, myShape.bot1Part);
		// myShape.bot2 =
		// this.myBot2Clone(myShape.bot2, myShape.bot2Part);
		// myShape.bot3 =
		// this.myBot3Clone(myShape.bot3, myShape.bot3Part);
		//
		// myShape.left =
		// this.myLeftClone(myShape.left, myShape.leftPart);
		// myShape.right =
		// this.myRightClone(myShape.right, myShape.rightPart);
		
		myShape.top1 = (Top1Object) myShape.top1.cloneProfile(myShape.top1Part);
		myShape.top2 = (Top2Object) myShape.top2.cloneProfile(myShape.top2Part);
		myShape.top3 = (Top3Object) myShape.top3.cloneProfile(myShape.top3Part);
		
		myShape.bot1 = (Bot1Object) myShape.bot1.cloneProfile(myShape.bot1Part);
		myShape.bot2 = (Bot2Object) myShape.bot2.cloneProfile(myShape.bot2Part);
		myShape.bot3 = (Bot3Object) myShape.bot3.cloneProfile(myShape.bot3Part);
		
		myShape.left = (LeftObject) myShape.left.cloneProfile(myShape.leftPart);
		myShape.right = (RightObject) myShape.right.cloneProfile(myShape.rightPart);
		
		// myShape.top1Part = (Profiles)
		// myShape.top1Part.cloneProfile(original.top1Part);
		// myShape.top2Part = (Profiles)
		// myShape.top2Part.cloneProfile(original.top2Part);
		// myShape.top3Part = (Profiles)
		// myShape.top3Part.cloneProfile(original.top3Part);
		// myShape.bot1Part = (Profiles)
		// myShape.bot1Part.cloneProfile(original.bot1Part);
		// myShape.bot2Part = (Profiles)
		// myShape.bot2Part.cloneProfile(original.bot2Part);
		// myShape.bot3Part = (Profiles)
		// myShape.bot3Part.cloneProfile(original.bot3Part);
		// myShape.leftPart = (Profiles)
		// myShape.leftPart.cloneProfile(original.leftPart);
		// myShape.rightPart = (Profiles)
		// myShape.rightPart.cloneProfile(original.rightPart);
		
		return myShape;
	}
	
	public ShapeObject doParts(ShapeObject myShape, boolean do2Sided)
	{
	
		/*
		 * -- End Type Specs -- End Type:
		 * 
		 * Left: bottom RB Top LT
		 * 
		 * top: Left RB right LT
		 * 
		 * right: Top RB Bottom LT
		 * 
		 * Bot: Right LT Bottom RB
		 */
		if (myShape.noSides == 2)
		{
			
		}
		else
		{
			this.startTop1(myShape);
			
			// //////// X2,Y2
			this.noSidesTop1(myShape);
			this.noSidesTop2(myShape);
			this.noSidesTop3(myShape);
			
			// /////// X3,Y3
			
			if (myShape.noSidesRight > 0)
			{
				
				if (myShape.bot1Part.endTypeRB == 1)
				{
					
					/* B1: C B BA A R: C B BA A */
					
					myShape.bot1Part.startXC = this.intersectX(bot1SXC, bot1SYC, bot1EXC, bot1EYC, rightSXC, rightSYC,
								rightEXC, rightEYC);
					
					myShape.bot1Part.startYC = this.intersectY(bot1SXC, bot1SYC, bot1EXC, bot1EYC, rightSXC, rightSYC,
								rightEXC, rightEYC);
					
					myShape.bot1Part.startX = this.intersectX(bot1SX, bot1SY, bot1EX, bot1EY, rightSX, rightSY, rightEX,
								rightEY);
					
					myShape.bot1Part.startY = this.intersectY(bot1SX, bot1SY, bot1EX, bot1EY, rightSX, rightSY, rightEX,
								rightEY);
					
					myShape.bot1Part.startXBA = this.intersectX(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, rightSXBA,
								rightSYBA, rightEXBA, rightEYBA);
					
					myShape.bot1Part.startYBA = this.intersectY(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, rightSXBA,
								rightSYBA, rightEXBA, rightEYBA);
					
					myShape.bot1Part.startXA = this.intersectX(bot1SXA, bot1SYA, bot1EXA, bot1EYA, rightSXA, rightSYA,
								rightEXA, rightEYA);
					
					myShape.bot1Part.startYA = this.intersectY(bot1SXA, bot1SYA, bot1EXA, bot1EYA, rightSXA, rightSYA,
								rightEXA, rightEYA);
					
					myShape.rightPart.endTypeLT = 1;
					
					myShape.rightPart.endXC = myShape.bot1Part.startXC;
					myShape.rightPart.endYC = myShape.bot1Part.startYC;
					
					myShape.rightPart.endX = myShape.bot1Part.startX;
					myShape.rightPart.endY = myShape.bot1Part.startY;
					
					myShape.rightPart.endXBA = myShape.bot1Part.startXBA;
					myShape.rightPart.endYBA = myShape.bot1Part.startYBA;
					myShape.rightPart.endXA = myShape.bot1Part.startXA;
					myShape.rightPart.endYA = myShape.bot1Part.startYA;
					
				}
				if (myShape.bot1Part.endTypeRB == 2)
				{
					
					/* B1: C B BA A-A R: C */
					
					myShape.bot1Part.startXC = this.intersectX(bot1SXC, bot1SYC, bot1EXC, bot1EY, rightSXC, rightSYC,
								rightEXC, rightEYC);
					
					myShape.bot1Part.startYC = this.intersectY(bot1SXC, bot1SYC, bot1EXC, bot1EY, rightSXC, rightSYC,
								rightEXC, rightEYC);
					
					myShape.bot1Part.startX = this.intersectX(bot1SX, bot1SY, bot1EX, bot1EY, rightSXC, rightSYC, rightEXC,
								rightEYC);
					
					myShape.bot1Part.startY = this.intersectY(bot1SX, bot1SY, bot1EX, bot1EY, rightSXC, rightSYC, rightEXC,
								rightEYC);
					
					myShape.bot1Part.startXBA = this.intersectX(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, rightSXC, rightSYC,
								rightEXC, rightEYC);
					
					myShape.bot1Part.startYBA = this.intersectY(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, rightSXC, rightSYC,
								rightEXC, rightEYC);
					
					myShape.bot1Part.startXA = this.intersectX(bot1SXA, bot1SYA, bot1EXA, bot1EYA, rightSXA, rightSYA,
								rightEXA, rightEYA);
					
					myShape.bot1Part.startYA = this.intersectY(bot1SXA, bot1SYA, bot1EXA, bot1EYA, rightSXA, rightSYA,
								rightEXA, rightEYA);
					
					myShape.bot1Part.stopAsX = this.intersectX(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, rightSXA, rightSYA,
								rightEXA, rightEYA);
					
					myShape.bot1Part.stopAsY = this.intersectY(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, rightSXA, rightSYA,
								rightEXA, rightEYA);
					
					// /////////////////////////////////////////
					
					myShape.rightPart.endTypeLT = 3;
					
					/* B1: BA R: C B BA A */
					
					myShape.rightPart.endXC = this.intersectX(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, rightSXC, rightSYC,
								rightEXC, rightEYC);
					
					myShape.rightPart.endYC = this.intersectY(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, rightSXC, rightSYC,
								rightEXC, rightEYC);
					
					myShape.rightPart.endX = this.intersectX(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, rightSX, rightSY,
								rightEX, rightEY);
					
					myShape.rightPart.endY = this.intersectY(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, rightSX, rightSY,
								rightEX, rightEY);
					
					myShape.rightPart.endXBA = this.intersectX(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, rightSXBA, rightSYBA,
								rightEXBA, rightEYBA);
					
					myShape.rightPart.endYBA = this.intersectY(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, rightSXBA, rightSYBA,
								rightEXBA, rightEYBA);
					
					myShape.rightPart.endXA = this.intersectX(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, rightSXA, rightSYA,
								rightEXA, rightEYA);
					
					myShape.rightPart.endYA = this.intersectY(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, rightSXA, rightSYA,
								rightEXA, rightEYA);
					// ////
					
				}
				if (myShape.bot1Part.endTypeRB == 3)
				{
					
					/* B1: C B BA A R: BA */
					
					myShape.bot1Part.startXC = this.intersectX(bot1SXC, bot1SYC, bot1EXC, bot1EYC, rightSXBA, rightSYBA,
								rightEXBA, rightEYBA);
					
					myShape.bot1Part.startYC = this.intersectY(bot1SXC, bot1SYC, bot1EXC, bot1EYC, rightSXBA, rightSYBA,
								rightEXBA, rightEYBA);
					
					myShape.bot1Part.startX = this.intersectX(bot1SX, bot1SY, bot1EX, bot1EY, rightSXBA, rightSYBA,
								rightEXBA, rightEYBA);
					
					myShape.bot1Part.startY = this.intersectY(bot1SX, bot1SY, bot1EX, bot1EY, rightSXBA, rightSYBA,
								rightEXBA, rightEYBA);
					
					myShape.bot1Part.startXBA = this.intersectX(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, rightSXBA,
								rightSYBA, rightEXBA, rightEYBA);
					
					myShape.bot1Part.startYBA = this.intersectY(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, rightSXBA,
								rightSYBA, rightEXBA, rightEYBA);
					
					myShape.bot1Part.startXA = this.intersectX(bot1SXA, bot1SYA, bot1EXA, bot1EYA, rightSXBA, rightSYBA,
								rightEXBA, rightEYBA);
					
					myShape.bot1Part.startYA = this.intersectY(bot1SXA, bot1SYA, bot1EXA, bot1EYA, rightSXBA, rightSYBA,
								rightEXBA, rightEYBA);
					
					// ///////////////////////////////////
					
					myShape.rightPart.endTypeLT = 2;
					
					/* B1: C R: C B BA A-A */
					
					myShape.rightPart.endXC = myShape.rightPart.endX = this.intersectX(bot1SXC, bot1SYC, bot1EXC, bot1EYC,
								rightSXC, rightSYC, rightEXC, rightEYC);
					
					myShape.rightPart.endYC = myShape.rightPart.endY = this.intersectY(bot1SXC, bot1SYC, bot1EXC, bot1EYC,
								rightSXC, rightSYC, rightEXC, rightEYC);
					
					myShape.rightPart.endX = this.intersectX(bot1SXC, bot1SYC, bot1EXC, bot1EYC, rightSX, rightSY, rightEX,
								rightEY);
					
					myShape.rightPart.endY = this.intersectY(bot1SXC, bot1SYC, bot1EXC, bot1EYC, rightSX, rightSY, rightEX,
								rightEY);
					
					myShape.rightPart.endXBA = this.intersectX(bot1SXC, bot1SYC, bot1EXC, bot1EYC, rightSXBA, rightSYBA,
								rightEXBA, rightEYBA);
					
					myShape.rightPart.endYBA = this.intersectY(bot1SXC, bot1SYC, bot1EXC, bot1EYC, rightSXBA, rightSYBA,
								rightEXBA, rightEYBA);
					
					myShape.rightPart.endXA = this.intersectX(bot1SXA, bot1SYA, bot1EXA, bot1EYA, rightSXA, rightSYA,
								rightEXA, rightEYA);
					
					myShape.rightPart.endYA = this.intersectY(bot1SXA, bot1SYA, bot1EXA, bot1EYA, rightSXA, rightSYA,
								rightEXA, rightEYA);
					
					myShape.rightPart.stopAeX = this.intersectX(bot1SXA, bot1SYA, bot1EXA, bot1EYA, rightSXBA, rightSYBA,
								rightEXBA, rightEYBA);
					
					myShape.rightPart.stopAeY = this.intersectY(bot1SXA, bot1SYA, bot1EXA, bot1EYA, rightSXBA, rightSYBA,
								rightEXBA, rightEYBA);
				}
				
			} // //////////
			
			if (myShape.noSidesBot == 3)
			{
				noSidesBot3(myShape);
			}
			else if (myShape.noSidesBot == 2)
			{
				noSidesBot2(myShape);
			}
			
			if (myShape.noSidesLeft > 0)
			{
				if (myShape.noSidesBot == 1)
				{
					if (myShape.bot1Part.endTypeLT == 1)
					{
						
						/* B1: C B BA A L: C B BA A */
						
						myShape.bot1Part.endXC = this.intersectX(bot1SXC, bot1SYC, bot1EXC, bot1EYC, leftSXC, leftSYC,
									leftEXC, leftEYC);
						
						myShape.bot1Part.endYC = this.intersectY(bot1SXC, bot1SYC, bot1EXC, bot1EYC, leftSXC, leftSYC,
									leftEXC, leftEYC);
						
						myShape.bot1Part.endX = this.intersectX(bot1SX, bot1SY, bot1EX, bot1EY, leftSX, leftSY, leftEX,
									leftEY);
						
						myShape.bot1Part.endY = this.intersectY(bot1SX, bot1SY, bot1EX, bot1EY, leftSX, leftSY, leftEX,
									leftEY);
						
						myShape.bot1Part.endXBA = this.intersectX(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, leftSXBA,
									leftSYBA, leftEXBA, leftEYBA);
						
						myShape.bot1Part.endYBA = this.intersectY(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, leftSXBA,
									leftSYBA, leftEXBA, leftEYBA);
						
						myShape.bot1Part.endXA = this.intersectX(bot1SXA, bot1SYA, bot1EXA, bot1EYA, leftSXA, leftSYA,
									leftEXA, leftEYA);
						
						myShape.bot1Part.endYA = this.intersectY(bot1SXA, bot1SYA, bot1EXA, bot1EYA, leftSXA, leftSYA,
									leftEXA, leftEYA);
						
						// ////////////////////////////////////////
						
						myShape.leftPart.endTypeRB = 1;
						
						myShape.leftPart.startXC = myShape.bot1Part.endXC;
						myShape.leftPart.startYC = myShape.bot1Part.endYC;
						
						myShape.leftPart.startX = myShape.bot1Part.endX;
						myShape.leftPart.startY = myShape.bot1Part.endY;
						
						myShape.leftPart.startXBA = myShape.bot1Part.endXBA;
						myShape.leftPart.startYBA = myShape.bot1Part.endYBA;
						myShape.leftPart.startXA = myShape.bot1Part.endXA;
						myShape.leftPart.startYA = myShape.bot1Part.endYA;
						
					}
					if (myShape.bot1Part.endTypeLT == 2)
					{
						
						/* B1: C B BA A-A L: C */
						
						myShape.bot1Part.endXC = this.intersectX(bot1SXC, bot1SYC, bot1EXC, bot1EYC, leftSXC, leftSYC,
									leftEXC, leftEYC);
						
						myShape.bot1Part.endYC = this.intersectY(bot1SXC, bot1SYC, bot1EXC, bot1EYC, leftSXC, leftSYC,
									leftEXC, leftEYC);
						
						myShape.bot1Part.endX = this.intersectX(bot1SX, bot1SY, bot1EX, bot1EY, leftSXC, leftSYC, leftEXC,
									leftEYC);
						
						myShape.bot1Part.endY = this.intersectY(bot1SX, bot1SY, bot1EX, bot1EY, leftSXC, leftSYC, leftEXC,
									leftEYC);
						
						myShape.bot1Part.endXBA = this.intersectX(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, leftSXC, leftSYC,
									leftEXC, leftEYC);
						
						myShape.bot1Part.endYBA = this.intersectY(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, leftSXC, leftSYC,
									leftEXC, leftEYC);
						
						myShape.bot1Part.endXA = this.intersectX(bot1SXA, bot1SYA, bot1EXA, bot1EYA, leftSXA, leftSYA,
									leftEXA, leftEYA);
						
						myShape.bot1Part.endYA = this.intersectY(bot1SXA, bot1SYA, bot1EXA, bot1EYA, leftSXA, leftSYA,
									leftEXA, leftEYA);
						
						myShape.bot1Part.stopAeX = this.intersectX(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, leftSXA,
									leftSYA, leftEXA, leftEYA);
						
						myShape.bot1Part.stopAeY = this.intersectY(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, leftSXA,
									leftSYA, leftEXA, leftEYA);
						
						// //////////////////////////////////////////
						
						myShape.leftPart.endTypeRB = 3;
						
						/* B1: BA L: C B BA A */
						
						myShape.leftPart.startXC = this.intersectX(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, leftSXC,
									leftSYC, leftEXC, leftEYC);
						
						myShape.leftPart.startYC = this.intersectY(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, leftSXC,
									leftSYC, leftEXC, leftEYC);
						
						myShape.leftPart.startX = this.intersectX(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, leftSX, leftSY,
									leftEX, leftEY);
						
						myShape.leftPart.startY = this.intersectY(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, leftSX, leftSY,
									leftEX, leftEY);
						
						myShape.leftPart.startXBA = this.intersectX(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, leftSXBA,
									leftSYBA, leftEXBA, leftEYBA);
						
						myShape.leftPart.startYBA = this.intersectY(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, leftSXBA,
									leftSYBA, leftEXBA, leftEYBA);
						
						myShape.leftPart.startXA = this.intersectX(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, leftSXA,
									leftSYA, leftEXA, leftEYA);
						
						myShape.leftPart.startYA = this.intersectY(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, leftSXA,
									leftSYA, leftEXA, leftEYA);
						// //////
						
						// ////
						
					}
					if (myShape.bot1Part.endTypeLT == 3)
					{
						
						/* B1: C B BA A L: BA */
						
						myShape.bot1Part.endXC = this.intersectX(bot1SXC, bot1SYC, bot1EXC, bot1EYC, leftSXBA, leftSYBA,
									leftEXBA, leftEYBA);
						
						myShape.bot1Part.endYC = this.intersectY(bot1SXC, bot1SYC, bot1EXC, bot1EYC, leftSXBA, leftSYBA,
									leftEXBA, leftEYBA);
						
						myShape.bot1Part.endX = this.intersectX(bot1SX, bot1SY, bot1EX, bot1EY, leftSXBA, leftSYBA,
									leftEXBA, leftEYBA);
						
						myShape.bot1Part.endY = this.intersectY(bot1SX, bot1SY, bot1EX, bot1EY, leftSXBA, leftSYBA,
									leftEXBA, leftEYBA);
						
						myShape.bot1Part.endXBA = this.intersectX(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, leftSXBA,
									leftSYBA, leftEXBA, leftEYBA);
						
						myShape.bot1Part.endYBA = this.intersectY(bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA, leftSXBA,
									leftSYBA, leftEXBA, leftEYBA);
						
						myShape.bot1Part.endXA = this.intersectX(bot1SXA, bot1SYA, bot1EXA, bot1EYA, leftSXBA, leftSYBA,
									leftEXBA, leftEYBA);
						
						myShape.bot1Part.endYA = this.intersectY(bot1SXA, bot1SYA, bot1EXA, bot1EYA, leftSXBA, leftSYBA,
									leftEXBA, leftEYBA);
						
						// ////////////////////////////////////
						
						myShape.leftPart.endTypeRB = 2;
						
						/* B1: C L: C B BA A-A */
						
						myShape.leftPart.startXC = this.intersectX(bot1SXC, bot1SYC, bot1EXC, bot1EYC, leftSXC, leftSYC,
									leftEXC, leftEYC);
						
						myShape.leftPart.startYC = this.intersectY(bot1SXC, bot1SYC, bot1EXC, bot1EYC, leftSXC, leftSYC,
									leftEXC, leftEYC);
						
						myShape.leftPart.startX = this.intersectX(bot1SXC, bot1SYC, bot1EXC, bot1EYC, leftSX, leftSY,
									leftEX, leftEY);
						
						myShape.leftPart.startY = this.intersectY(bot1SXC, bot1SYC, bot1EXC, bot1EYC, leftSX, leftSY,
									leftEX, leftEY);
						
						myShape.leftPart.startXBA = this.intersectX(bot1SXC, bot1SYC, bot1EXC, bot1EYC, leftSXBA, leftSYBA,
									leftEXBA, leftEYBA);
						
						myShape.leftPart.startYBA = this.intersectY(bot1SXC, bot1SYC, bot1EXC, bot1EYC, leftSXBA, leftSYBA,
									leftEXBA, leftEYBA);
						
						myShape.leftPart.startXA = this.intersectX(bot1SXA, bot1SYA, bot1EXA, bot1EYA, leftSXA, leftSYA,
									leftEXA, leftEYA);
						
						myShape.leftPart.startYA = this.intersectY(bot1SXA, bot1SYA, bot1EXA, bot1EYA, leftSXA, leftSYA,
									leftEXA, leftEYA);
						
						myShape.leftPart.stopAsX = this.intersectX(bot1SXA, bot1SYA, bot1EXA, bot1EYA, leftSXBA, leftSYBA,
									leftEXBA, leftEYBA);
						
						myShape.leftPart.stopAsY = this.intersectY(bot1SXA, bot1SYA, bot1EXA, bot1EYA, leftSXBA, leftSYBA,
									leftEXBA, leftEYBA);
						
					}
				}
				else
				{
					// ///////////////////////
					if (myShape.noSidesBot == 2)
					{
						
						if (myShape.bot2Part.endTypeLT == 1)
						{
							
							/* B2: C B BA A L: C B BA A */
							
							myShape.bot2Part.endXC = this.intersectX(bot2SXC, bot2SYC, bot2EXC, bot2EYC, leftSXC, leftSYC,
										leftEXC, leftEYC);
							
							myShape.bot2Part.endYC = this.intersectY(bot2SXC, bot2SYC, bot2EXC, bot2EYC, leftSXC, leftSYC,
										leftEXC, leftEYC);
							
							myShape.bot2Part.endX = this.intersectX(bot2SX, bot2SY, bot2EX, bot2EY, leftSX, leftSY,
										leftEX, leftEY);
							
							myShape.bot2Part.endY = this.intersectY(bot2SX, bot2SY, bot2EX, bot2EY, leftSX, leftSY,
										leftEX, leftEY);
							
							myShape.bot2Part.endXBA = this.intersectX(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSXBA,
										leftSYBA, leftEXBA, leftEYBA);
							
							myShape.bot2Part.endYBA = this.intersectY(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSXBA,
										leftSYBA, leftEXBA, leftEYBA);
							
							myShape.bot2Part.endXA = this.intersectX(bot2SXA, bot2SYA, bot2EXA, bot2EYA, leftSXA, leftSYA,
										leftEXA, leftEYA);
							
							myShape.bot2Part.endYA = this.intersectY(bot2SXA, bot2SYA, bot2EXA, bot2EYA, leftSXA, leftSYA,
										leftEXA, leftEYA);
							
							myShape.leftPart.endTypeRB = 1;
							
							myShape.leftPart.startXC = myShape.bot2Part.endXC;
							myShape.leftPart.startYC = myShape.bot2Part.endYC;
							
							myShape.leftPart.startX = myShape.bot2Part.endX;
							myShape.leftPart.startY = myShape.bot2Part.endY;
							
							myShape.leftPart.startXBA = myShape.bot2Part.endXBA;
							myShape.leftPart.startYBA = myShape.bot2Part.endYBA;
							myShape.leftPart.startXA = myShape.bot2Part.endXA;
							myShape.leftPart.startYA = myShape.bot2Part.endYA;
							
						}
						if (myShape.bot2Part.endTypeLT == 2)
						{
							
							/* B2: C B BA A-A L: C */
							
							myShape.bot2Part.endXC = this.intersectX(bot2SXC, bot2SYC, bot2EXC, bot2EYC, leftSXC, leftSYC,
										leftEXC, leftEYC);
							
							myShape.bot2Part.endYC = this.intersectY(bot2SXC, bot2SYC, bot2EXC, bot2EYC, leftSXC, leftSYC,
										leftEXC, leftEYC);
							
							myShape.bot2Part.endX = this.intersectX(bot2SX, bot2SY, bot2EX, bot2EY, leftSXC, leftSYC,
										leftEXC, leftEYC);
							
							myShape.bot2Part.endY = this.intersectY(bot2SX, bot2SY, bot2EX, bot2EY, leftSXC, leftSYC,
										leftEXC, leftEYC);
							
							myShape.bot2Part.endXBA = this.intersectX(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSXC,
										leftSYC, leftEXC, leftEYC);
							
							myShape.bot2Part.endYBA = this.intersectY(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSXC,
										leftSYC, leftEXC, leftEYC);
							
							// A-A
							
							myShape.bot2Part.endXA = this.intersectX(bot2SXA, bot2SYA, bot2EXA, bot2EYA, leftSXA, leftSYA,
										leftEXA, leftEYA);
							
							myShape.bot2Part.endYA = this.intersectY(bot2SXA, bot2SYA, bot2EXA, bot2EYA, leftSXA, leftSYA,
										leftEXA, leftEYA);
							
							myShape.bot2Part.stopAeX = this.intersectX(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSXA,
										leftSYA, leftEXA, leftEYA);
							
							myShape.bot2Part.stopAeY = this.intersectY(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSXA,
										leftSYA, leftEXA, leftEYA);
							
							// //////////////////////////////////////
							
							myShape.leftPart.endTypeRB = 3;
							
							/* B2:BA L: C B BA A */
							
							myShape.leftPart.startXC = this.intersectX(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSXC,
										leftSYC, leftEXC, leftEYC);
							
							myShape.leftPart.startYC = this.intersectY(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSXC,
										leftSYC, leftEXC, leftEYC);
							
							myShape.leftPart.startX = this.intersectX(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSX,
										leftSY, leftEX, leftEY);
							
							myShape.leftPart.startYC = this.intersectY(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSX,
										leftSY, leftEX, leftEY);
							
							myShape.leftPart.startXBA = this.intersectX(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSXBA,
										leftSYBA, leftEXBA, leftEYBA);
							
							myShape.leftPart.startYBA = this.intersectY(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSXBA,
										leftSYBA, leftEXBA, leftEYBA);
							
							myShape.leftPart.startXA = this.intersectX(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSXA,
										leftSYA, leftEXA, leftEYA);
							
							myShape.leftPart.startYA = this.intersectY(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSXA,
										leftSYA, leftEXA, leftEYA);
							// //////
							
							// ////
							
						}
						if (myShape.bot2Part.endTypeLT == 3)
						{
							
							/* B2: C B BA A L: BA */
							
							myShape.bot2Part.endXC = this.intersectX(bot2SXC, bot2SYC, bot2EXC, bot2EYC, leftSXBA,
										leftSYBA, leftEXBA, leftEYBA);
							
							myShape.bot2Part.endYC = this.intersectY(bot2SXC, bot2SYC, bot2EXC, bot2EYC, leftSXBA,
										leftSYBA, leftEXBA, leftEYBA);
							
							myShape.bot2Part.endX = this.intersectX(bot2SX, bot2SY, bot2EX, bot2EY, leftSXBA, leftSYBA,
										leftEXBA, leftEYBA);
							
							myShape.bot2Part.endY = this.intersectY(bot2SX, bot2SY, bot2EX, bot2EY, leftSXBA, leftSYBA,
										leftEXBA, leftEYBA);
							
							myShape.bot2Part.endXBA = this.intersectX(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSXBA,
										leftSYBA, leftEXBA, leftEYBA);
							
							myShape.bot2Part.endYBA = this.intersectY(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSXBA,
										leftSYBA, leftEXBA, leftEYBA);
							
							myShape.bot2Part.endXA = this.intersectX(bot2SXA, bot2SYA, bot2EXA, bot2EYA, leftSXBA,
										leftSYBA, leftEXBA, leftEYBA);
							
							myShape.bot2Part.endYA = this.intersectY(bot2SXA, bot2SYA, bot2EXA, bot2EYA, leftSXBA,
										leftSYBA, leftEXBA, leftEYBA);
							
							// //////////////////////////////////////
							
							myShape.leftPart.endTypeRB = 2;
							
							/* B2: C L: C B BA A-A */
							
							myShape.leftPart.startXC = this.intersectX(bot2SXC, bot2SYC, bot2EXC, bot2EYC, leftSXC,
										leftSYC, leftEXC, leftEYC);
							
							myShape.leftPart.startYC = this.intersectY(bot2SXC, bot2SYC, bot2EXC, bot2EYC, leftSXC,
										leftSYC, leftEXC, leftEYC);
							
							myShape.leftPart.startX = this.intersectX(bot2SXC, bot2SYC, bot2EXC, bot2EYC, leftSX, leftSY,
										leftEX, leftEY);
							
							myShape.leftPart.startY = this.intersectY(bot2SXC, bot2SYC, bot2EXC, bot2EYC, leftSX, leftSY,
										leftEX, leftEY);
							
							myShape.leftPart.startXBA = this.intersectX(bot2SXC, bot2SYC, bot2EXC, bot2EYC, leftSXBA,
										leftSYBA, leftEXBA, leftEYBA);
							
							myShape.leftPart.startYBA = this.intersectY(bot2SXC, bot2SYC, bot2EXC, bot2EYC, leftSXBA,
										leftSYBA, leftEXBA, leftEYBA);
							
							myShape.leftPart.startXA = this.intersectX(bot2SXA, bot2SYA, bot2EXA, bot2EYA, leftSXA,
										leftSYA, leftEXA, leftEYA);
							
							myShape.leftPart.startYA = this.intersectY(bot2SXA, bot2SYA, bot2EXA, bot2EYA, leftSXA,
										leftSYA, leftEXA, leftEYA);
							
							myShape.leftPart.stopAsX = this.intersectX(bot2SXA, bot2SYA, bot2EXA, bot2EYA, leftSXBA,
										leftSYBA, leftEXBA, leftEYBA);
							
							myShape.leftPart.stopAsY = this.intersectY(bot2SXA, bot2SYA, bot2EXA, bot2EYA, leftSXBA,
										leftSYBA, leftEXBA, leftEYBA);
							
						}
						// ////////////////////////////////////////
					}//
					
				}
			}
		}
		setProfileAngles(myShape);
		
		setProfileLength(myShape);
		
		return myShape;
		
	}
	
	public ShapeObject makeSidesStraightOLD(final ShapeObject myShape)
	{
	
		// ////////////////////////////
		top1SX = top1SXBA = top1SXA = myParent.top1Part.startXC;
		top1EX = top1EXBA = top1EXA = myParent.top1Part.endXC;
		
		top1SY = myParent.top1Part.startYC + top1DimC;
		top1SYBA = myParent.top1Part.startYC + top1DimB;
		top1SYA = myParent.top1Part.startYC + top1DimA;
		
		top1EY = myParent.top1Part.endYC + top1DimC;
		top1EYBA = myParent.top1Part.endYC + top1DimB;
		top1EYA = myParent.top1Part.endYC + top1DimA;
		
		myShape.top1Part.startXC = top1SX;
		myShape.top1Part.startXBA = top1SXBA;
		myShape.top1Part.startXA = top1SXA;
		
		myShape.top1Part.startYC = top1SY;
		myShape.top1Part.startYBA = top1SYBA;
		myShape.top1Part.startYA = top1SYA;
		
		myShape.top1Part.endXC = top1EX;
		myShape.top1Part.endXBA = top1EXBA;
		myShape.top1Part.endXA = top1EXA;
		
		myShape.top1Part.endYC = top1EY;
		myShape.top1Part.endYBA = top1EYBA;
		myShape.top1Part.endYA = top1EYA;
		
		// ////////////////////////////
		
		top2SX = top2SXBA = top2SXA = myParent.top2Part.startXC;
		top2EX = top2EXBA = top2EXA = myParent.top2Part.endXC;
		
		top2SY = myParent.top2Part.startYC + top2DimC;
		top2SYBA = myParent.top2Part.startYC + top2DimB;
		top2SYA = myParent.top2Part.startYC + top2DimA;
		
		top2EY = myParent.top2Part.endYC + top2DimC;
		top2EYBA = myParent.top2Part.endYC + top2DimB;
		top2EYA = myParent.top2Part.endYC + top2DimA;
		
		myShape.top2Part.startXC = top2SX;
		myShape.top2Part.startXBA = top2SXBA;
		myShape.top2Part.startXA = top2SXA;
		
		myShape.top2Part.startYC = top2SY;
		myShape.top2Part.startYBA = top2SYBA;
		myShape.top2Part.startYA = top2SYA;
		
		myShape.top2Part.endXC = top2EX;
		myShape.top2Part.endXBA = top2EXBA;
		myShape.top2Part.endXA = top2EXA;
		
		myShape.top2Part.endYC = top2EY;
		myShape.top2Part.endYBA = top2EYBA;
		myShape.top2Part.endYA = top2EYA;
		
		// ////////////////////////////
		
		top3SX = top3SXBA = top3SXA = myParent.top3Part.startXC;
		top3EX = top3EXBA = top3EXA = myParent.top3Part.endXC;
		
		top3SY = myParent.top3Part.startYC + top3DimC;
		top3SYBA = myParent.top3Part.startYC + top3DimB;
		top3SYA = myParent.top3Part.startYC + top3DimA;
		
		top3EY = myParent.top3Part.endYC + top3DimC;
		top3EYBA = myParent.top3Part.endYC + top3DimB;
		top3EYA = myParent.top3Part.endYC + top3DimA;
		
		myShape.top3Part.startXC = top3SX;
		myShape.top3Part.startXBA = top3SXBA;
		myShape.top3Part.startXA = top3SXA;
		
		myShape.top3Part.startYC = top3SY;
		myShape.top3Part.startYBA = top3SYBA;
		myShape.top3Part.startYA = top3SYA;
		
		myShape.top3Part.endXC = top3EX;
		myShape.top3Part.endXBA = top3EXBA;
		myShape.top3Part.endXA = top3EXA;
		
		myShape.top3Part.endYC = top3EY;
		myShape.top3Part.endYBA = top3EYBA;
		myShape.top3Part.endYA = top3EYA;
		
		// ////////////////////////////
		bot1SX = bot1SXBA = bot1SXA = myParent.bot1Part.startXC;
		bot1EX = bot1EXBA = bot1EXA = myParent.bot1Part.endXC;
		
		bot1SY = myParent.bot1Part.startYC - bot1DimC;
		bot1SYBA = myParent.bot1Part.startYC - bot1DimB;
		bot1SYA = myParent.bot1Part.startYC - bot1DimA;
		
		bot1EY = myParent.bot1Part.endYC - bot1DimC;
		bot1EYBA = myParent.bot1Part.endYC - bot1DimB;
		bot1EYA = myParent.bot1Part.endYC - bot1DimA;
		
		myShape.bot1Part.startXC = bot1SX;
		myShape.bot1Part.startXBA = bot1SXBA;
		myShape.bot1Part.startXA = bot1SXA;
		
		myShape.bot1Part.startYC = bot1SY;
		myShape.bot1Part.startYBA = bot1SYBA;
		myShape.bot1Part.startYA = bot1SYA;
		
		myShape.bot1Part.endXC = bot1EX;
		myShape.bot1Part.endXBA = bot1EXBA;
		myShape.bot1Part.endXA = bot1EXA;
		
		myShape.bot1Part.endYC = bot1EY;
		myShape.bot1Part.endYBA = bot1EYBA;
		myShape.bot1Part.endYA = bot1EYA;
		// ////////////////////////////
		bot2SX = bot2SXBA = bot2SXA = myParent.bot2Part.startXC;
		bot2EX = bot2EXBA = bot2EXA = myParent.bot2Part.endXC;
		
		bot2SY = myParent.bot2Part.startYC - bot2DimC;
		bot2SYBA = myParent.bot2Part.startYC - bot2DimB;
		bot2SYA = myParent.bot2Part.startYC - bot2DimA;
		
		bot2EY = myParent.bot2Part.endYC - bot2DimC;
		bot2EYBA = myParent.bot2Part.endYC - bot2DimB;
		bot2EYA = myParent.bot2Part.endYC - bot2DimA;
		
		myShape.bot2Part.startXC = bot2SX;
		myShape.bot2Part.startXBA = bot2SXBA;
		myShape.bot2Part.startXA = bot2SXA;
		
		myShape.bot2Part.startYC = bot2SY;
		myShape.bot2Part.startYBA = bot2SYBA;
		myShape.bot2Part.startYA = bot2SYA;
		
		myShape.bot2Part.endXC = bot2EX;
		myShape.bot2Part.endXBA = bot2EXBA;
		myShape.bot2Part.endXA = bot2EXA;
		
		myShape.bot2Part.endYC = bot2EY;
		myShape.bot2Part.endYBA = bot2EYBA;
		myShape.bot2Part.endYA = bot2EYA;
		// ////////////////////////////
		
		bot3SX = bot3SXBA = bot3SXA = myParent.bot3Part.startXC;
		bot3EX = bot3EXBA = bot3EXA = myParent.bot3Part.endXC;
		
		bot3SY = myParent.bot3Part.startYC - bot3DimC;
		bot3SYBA = myParent.bot3Part.startYC - bot3DimB;
		bot3SYA = myParent.bot3Part.startYC - bot3DimA;
		
		bot3EY = myParent.bot3Part.endYC - bot3DimC;
		bot3EYBA = myParent.bot3Part.endYC - bot3DimB;
		bot3EYA = myParent.bot3Part.endYC - bot3DimA;
		
		myShape.bot3Part.startXC = bot3SX;
		myShape.bot3Part.startXBA = bot3SXBA;
		myShape.bot3Part.startXA = bot3SXA;
		
		myShape.bot3Part.startYC = bot3SY;
		myShape.bot3Part.startYBA = bot3SYBA;
		myShape.bot3Part.startYA = bot3SYA;
		
		myShape.bot3Part.endXC = bot3EX;
		myShape.bot3Part.endXBA = bot3EXBA;
		myShape.bot3Part.endXA = bot3EXA;
		
		myShape.bot3Part.endYC = bot3EY;
		myShape.bot3Part.endYBA = bot3EYBA;
		myShape.bot3Part.endYA = bot3EYA;
		// ////////////////////////////
		rightSX = myParent.rightPart.startXC - rightDimC;
		rightSXBA = myParent.rightPart.startXC - rightDimB;
		rightSXA = myParent.rightPart.startXC - rightDimA;
		
		rightSY = rightSYBA = rightSYA = myParent.rightPart.startYC;
		
		rightEX = myParent.rightPart.endXC - rightDimC;
		rightEXBA = myParent.rightPart.endXC - rightDimB;
		rightEXA = myParent.rightPart.endXC - rightDimA;
		
		rightEY = rightEYBA = rightEYA = myParent.rightPart.endYC;
		
		myShape.rightPart.startXC = rightSX;
		myShape.rightPart.startXBA = rightSXBA;
		myShape.rightPart.startXA = rightSXA;
		
		myShape.rightPart.startYC = rightSY;
		myShape.rightPart.startYBA = rightSYBA;
		myShape.rightPart.startYA = rightSYA;
		
		myShape.rightPart.endXC = rightEX;
		myShape.rightPart.endXBA = rightEXBA;
		myShape.rightPart.endXA = rightEXA;
		
		myShape.rightPart.endYC = rightEY;
		myShape.rightPart.endYBA = rightEYBA;
		myShape.rightPart.endYA = rightEYA;
		// ////////////////////////////
		leftSX = myParent.leftPart.startXC + leftDimC;
		leftSXBA = myParent.leftPart.startXC + leftDimB;
		leftSXA = myParent.leftPart.startXC + leftDimA;
		
		leftSY = leftSYBA = leftSYA = myParent.leftPart.startYC;
		
		leftEX = myParent.leftPart.endXC + leftDimC;
		leftEXBA = myParent.leftPart.endXC + leftDimB;
		leftEXA = myParent.leftPart.endXC + leftDimA;
		
		leftEY = leftEYBA = leftEYA = myParent.leftPart.endYC;
		
		myShape.leftPart.startXC = leftSX;
		myShape.leftPart.startXBA = leftSXBA;
		myShape.leftPart.startXA = leftSXA;
		
		myShape.leftPart.startYC = leftSY;
		myShape.leftPart.startYBA = leftSYBA;
		myShape.leftPart.startYA = leftSYA;
		
		myShape.leftPart.endXC = leftEX;
		myShape.leftPart.endXBA = leftEXBA;
		myShape.leftPart.endXA = leftEXA;
		
		myShape.leftPart.endYC = leftEY;
		myShape.leftPart.endYBA = leftEYBA;
		myShape.leftPart.endYA = leftEYA;
		// ////////////////////////////
		
		return myShape;
		
	}
	
	public ShapeObject makeSidesStraight(final ShapeObject myShape)
	{
	
		// ////////////////////////////
		top1SXC = myShape.top1Part.startXC;
		top1SX = myShape.top1Part.startX;
		top1SXBA = myShape.top1Part.startXBA;
		top1SXA = myShape.top1Part.startXA;
		
		top1EXC = myShape.top1Part.endXC;
		top1EX = myShape.top1Part.endX;
		top1EXBA = myShape.top1Part.endXBA;
		top1EXA = myShape.top1Part.endXA;
		
		top1SYC = myShape.top1Part.startYC;
		top1SY = myShape.top1Part.startY;
		top1SYBA = myShape.top1Part.startYBA;
		top1SYA = myShape.top1Part.startYA;
		
		top1EYC = myShape.top1Part.endYC;
		top1EY = myShape.top1Part.endY;
		top1EYBA = myShape.top1Part.endYBA;
		top1EYA = myShape.top1Part.endYA;
		
		// ////////////////////////////
		
		top2SXC = myShape.top2Part.startXC;
		top2SX = myShape.top2Part.startX;
		top2SXBA = myShape.top2Part.startXBA;
		top2SXA = myShape.top2Part.startXA;
		
		top2EXC = myShape.top2Part.endXC;
		top2EX = myShape.top2Part.endX;
		top2EXBA = myShape.top2Part.endXBA;
		top2EXA = myShape.top2Part.endXA;
		
		top2SYC = myShape.top2Part.startYC;
		top2SY = myShape.top2Part.startY;
		top2SYBA = myShape.top2Part.startYBA;
		top2SYA = myShape.top2Part.startYA;
		
		top2EYC = myShape.top2Part.endYC;
		top2EY = myShape.top2Part.endY;
		top2EYBA = myShape.top2Part.endYBA;
		top2EYA = myShape.top2Part.endYA;
		
		// ////////////////////////////
		
		top3SXC = myShape.top3Part.startXC;
		top3SX = myShape.top3Part.startX;
		top3SXBA = myShape.top3Part.startXBA;
		top3SXA = myShape.top3Part.startXA;
		
		top3EXC = myShape.top3Part.endXC;
		top3EX = myShape.top3Part.endX;
		top3EXBA = myShape.top3Part.endXBA;
		top3EXA = myShape.top3Part.endXA;
		
		top3SYC = myShape.top3Part.startYC;
		top3SY = myShape.top3Part.startY;
		top3SYBA = myShape.top3Part.startYBA;
		top3SYA = myShape.top3Part.startYA;
		
		top3EYC = myShape.top3Part.endYC;
		top3EY = myShape.top3Part.endY;
		top3EYBA = myShape.top3Part.endYBA;
		top3EYA = myShape.top3Part.endYA;
		
		// ////////////////////////////
		bot1SXC = myShape.bot1Part.startXC;
		bot1SX = myShape.bot1Part.startX;
		bot1SXBA = myShape.bot1Part.startXBA;
		bot1SXA = myShape.bot1Part.startXA;
		
		bot1EXC = myShape.bot1Part.endXC;
		bot1EX = myShape.bot1Part.endX;
		bot1EXBA = myShape.bot1Part.endXBA;
		bot1EXA = myShape.bot1Part.endXA;
		
		bot1SYC = myShape.bot1Part.startYC;
		bot1SY = myShape.bot1Part.startY;
		bot1SYBA = myShape.bot1Part.startYBA;
		bot1SYA = myShape.bot1Part.startYA;
		
		bot1EYC = myShape.bot1Part.endYC;
		bot1EY = myShape.bot1Part.endY;
		bot1EYBA = myShape.bot1Part.endYBA;
		bot1EYA = myShape.bot1Part.endYA;
		
		// ////////////////////////////
		bot2SXC = myShape.bot2Part.startXC;
		bot2SX = myShape.bot2Part.startX;
		bot2SXBA = myShape.bot2Part.startXBA;
		bot2SXA = myShape.bot2Part.startXA;
		
		bot2EXC = myShape.bot2Part.endXC;
		bot2EX = myShape.bot2Part.endX;
		bot2EXBA = myShape.bot2Part.endXBA;
		bot2EXA = myShape.bot2Part.endXA;
		
		bot2SYC = myShape.bot2Part.startYC;
		bot2SY = myShape.bot2Part.startY;
		bot2SYBA = myShape.bot2Part.startYBA;
		bot2SYA = myShape.bot2Part.startYA;
		
		bot2EYC = myShape.bot2Part.endYC;
		bot2EY = myShape.bot2Part.endY;
		bot2EYBA = myShape.bot2Part.endYBA;
		bot2EYA = myShape.bot2Part.endYA;
		
		// ////////////////////////////
		
		bot3SXC = myShape.bot3Part.startXC;
		bot3SX = myShape.bot3Part.startX;
		bot3SXBA = myShape.bot3Part.startXBA;
		bot3SXA = myShape.bot3Part.startXA;
		
		bot3EXC = myShape.bot3Part.endXC;
		bot3EX = myShape.bot3Part.endX;
		bot3EXBA = myShape.bot3Part.endXBA;
		bot3EXA = myShape.bot3Part.endXA;
		
		bot3SYC = myShape.bot3Part.startYC;
		bot3SY = myShape.bot3Part.startY;
		bot3SYBA = myShape.bot3Part.startYBA;
		bot3SYA = myShape.bot3Part.startYA;
		
		bot3EYC = myShape.bot3Part.endYC;
		bot3EY = myShape.bot3Part.endY;
		bot3EYBA = myShape.bot3Part.endYBA;
		bot3EYA = myShape.bot3Part.endYA;
		
		// ////////////////////////////
		
		rightSXC = myShape.rightPart.startXC;
		rightSX = myShape.rightPart.startX;
		rightSXBA = myShape.rightPart.startXBA;
		rightSXA = myShape.rightPart.startXA;
		
		rightEXC = myShape.rightPart.endXC;
		rightEX = myShape.rightPart.endX;
		rightEXBA = myShape.rightPart.endXBA;
		rightEXA = myShape.rightPart.endXA;
		
		rightSYC = myShape.rightPart.startYC;
		rightSY = myShape.rightPart.startY;
		rightSYBA = myShape.rightPart.startYBA;
		rightSYA = myShape.rightPart.startYA;
		
		rightEYC = myShape.rightPart.endYC;
		rightEY = myShape.rightPart.endY;
		rightEYBA = myShape.rightPart.endYBA;
		rightEYA = myShape.rightPart.endYA;
		
		// ////////////////////////////
		
		leftSXC = myShape.leftPart.startXC;
		leftSX = myShape.leftPart.startX;
		leftSXBA = myShape.leftPart.startXBA;
		leftSXA = myShape.leftPart.startXA;
		
		leftEXC = myShape.leftPart.endXC;
		leftEX = myShape.leftPart.endX;
		leftEXBA = myShape.leftPart.endXBA;
		leftEXA = myShape.leftPart.endXA;
		
		leftSYC = myShape.leftPart.startYC;
		leftSY = myShape.leftPart.startY;
		leftSYBA = myShape.leftPart.startYBA;
		leftSYA = myShape.leftPart.startYA;
		
		leftEYC = myShape.leftPart.endYC;
		leftEY = myShape.leftPart.endY;
		leftEYBA = myShape.leftPart.endYBA;
		leftEYA = myShape.leftPart.endYA;
		
		// ////////////////////////////
		
		return myShape;
		
	}
	
	/**
	 * Make sides ShapeObject
	 * 
	 * @param myShape
	 *             , ShapeObject
	 * @return ShapeObject
	 */
	public ShapeObject makeSides(ShapeObject myShape)
	{
	
		this.makeShapeBkgrdPointsFromPxy(myShape);
		
		myShape.top1Part.startXC = px1c;
		myShape.top1Part.startYC = py1c;
		myShape.top1Part.endXC = px2c;
		myShape.top1Part.endYC = py2c;
		
		myShape.top1Part.startX = myShape.top1Part.startingX = px1;
		myShape.top1Part.startY = myShape.top1Part.startingY = py1;
		
		myShape.top1Part.endX = px2;
		myShape.top1Part.endY = py2;
		
		myShape.top1Part.startXBA = myShape.startingXBA = px1B;
		myShape.top1Part.startYBA = myShape.startingYBA = py1B;
		
		myShape.top1Part.endXBA = px2B;
		myShape.top1Part.endYBA = py2B;
		
		myShape.top1Part.startXA = myShape.startingXA = px1A;
		myShape.top1Part.startYA = myShape.startingYA = py1A;
		
		myShape.top1Part.endXA = px2A;
		myShape.top1Part.endYA = py2A;
		
		if (myShape.noSides == 2)
		{
			
			myShape.top1Part.startXC = px1c;
			myShape.top1Part.startYC = py1c;
			
			myShape.top1Part.startX = myShape.top1Part.startingX = px1;
			myShape.top1Part.startY = myShape.top1Part.startingY = py1;
			
			myShape.top1Part.startXBA = myShape.startingXBA = px1B;
			myShape.top1Part.startYBA = myShape.startingYBA = py1B;
			
			myShape.top1Part.startXA = myShape.startingXA = px1A;
			myShape.top1Part.startYA = myShape.startingYA = py1A;
			
			myShape.top1Part.endXC = px2c;
			myShape.top1Part.endYC = py2c;
			
			myShape.top1Part.endX = px2;
			myShape.top1Part.endY = py2;
			
			myShape.top1Part.endXBA = px2B;
			myShape.top1Part.endYBA = py2B;
			
			myShape.top1Part.endXA = px2A;
			myShape.top1Part.endYA = py2A;
			
			myShape.bot1Part.endXC = px1c;
			myShape.bot1Part.endYC = py1c;
			
			myShape.bot1Part.endX = px1;
			myShape.bot1Part.endY = py1;
			
			myShape.bot1Part.endXBA = px1B;
			myShape.bot1Part.endYBA = py1B;
			
			myShape.bot1Part.endXA = px1A;
			myShape.bot1Part.endYA = py1A;
			
			myShape.bot1Part.startXC = px2c;
			myShape.bot1Part.startYC = py2c;
			
			myShape.bot1Part.startX = px2;
			myShape.bot1Part.startY = py2;
			
			myShape.bot1Part.startXBA = px2B;
			myShape.bot1Part.startYBA = py2B;
			
			myShape.bot1Part.startXA = px2A;
			myShape.bot1Part.startYA = py2A;
			
		}
		else
		{
			
			if (myShape.noSidesTop == 2)
			{
				
				myShape.top2Part.startXC = px2c;
				myShape.top2Part.startYC = py2c;
				
				myShape.top2Part.endXC = px3c;
				myShape.top2Part.endYC = py3c;
				
				myShape.top2Part.startX = myShape.top2Part.startingX = px2;
				myShape.top2Part.startY = myShape.top2Part.startingY = py2;
				
				myShape.top2Part.endX = px3;
				myShape.top2Part.endY = py3;
				
				myShape.top2Part.startXBA = px2B;
				myShape.top2Part.startYBA = py2B;
				
				myShape.top2Part.endXBA = px3B;
				myShape.top2Part.endYBA = py3B;
				
				myShape.top2Part.startXA = px2A;
				myShape.top2Part.startYA = py2A;
				
				myShape.top2Part.endXA = px3A;
				myShape.top2Part.endYA = py3A;
				
			}
			
			if (myShape.noSidesTop == 3)
			{
				
				myShape.top3Part.startXC = px2c;
				myShape.top3Part.startYC = py2c;
				
				myShape.top3Part.endXC = px3c;
				myShape.top3Part.endYC = py3c;
				
				myShape.top3Part.startX = myShape.top3Part.startingX = px2;
				myShape.top3Part.startY = myShape.top3Part.startingY = py2;
				
				myShape.top3Part.endX = px3;
				myShape.top3Part.endY = py3;
				
				myShape.top3Part.startXBA = px2B;
				myShape.top3Part.startYBA = py2B;
				
				myShape.top3Part.endXBA = px3B;
				myShape.top3Part.endYBA = py3B;
				
				myShape.top3Part.startXA = px2A;
				myShape.top3Part.startYA = py2A;
				
				myShape.top3Part.endXA = px3A;
				myShape.top3Part.endYA = py3A;
				
				myShape.top2Part.startXC = px3c;
				myShape.top2Part.startYC = py3c;
				
				myShape.top2Part.startX = px3;
				myShape.top2Part.startY = py3;
				
				myShape.top2Part.endXC = px4c;
				myShape.top2Part.endYC = py4c;
				
				myShape.top2Part.endX = px4;
				myShape.top2Part.endY = py4;
				
				myShape.top2Part.startXBA = px3B;
				myShape.top2Part.startYBA = py3B;
				
				myShape.top2Part.endXBA = px4B;
				myShape.top2Part.endYBA = py4B;
				
				myShape.top2Part.startXA = px3A;
				myShape.top2Part.startYA = py3A;
				
				myShape.top2Part.endXA = px4A;
				myShape.top2Part.endYA = py4A;
				
				// /here
			}
			
			if (myShape.noSidesRight == 1)
			{
				
				if (myShape.noSidesTop == 1)
				{
					
					myShape.rightPart.startXC = px2c;
					myShape.rightPart.startYC = py2c;
					
					myShape.rightPart.endXC = px3c;
					myShape.rightPart.endYC = py3c;
					
					myShape.rightPart.startX = px2;
					myShape.rightPart.startY = py2;
					
					myShape.rightPart.endX = px3;
					myShape.rightPart.endY = py3;
					
					myShape.rightPart.startXBA = px2B;
					myShape.rightPart.startYBA = py2B;
					
					myShape.rightPart.endXBA = px3B;
					myShape.rightPart.endYBA = py3B;
					
					myShape.rightPart.startXA = px2A;
					myShape.rightPart.startYA = py2A;
					
					myShape.rightPart.endXA = px3A;
					myShape.rightPart.endYA = py3A;
					
				}
				else if (myShape.noSidesTop == 2)
				{
					
					myShape.rightPart.startXC = px3c;
					myShape.rightPart.startYC = py3c;
					
					myShape.rightPart.endXC = px4c;
					myShape.rightPart.endYC = py4c;
					
					myShape.rightPart.startX = px3;
					myShape.rightPart.startY = py3;
					
					myShape.rightPart.endX = px4;
					myShape.rightPart.endY = py4;
					
					myShape.rightPart.startXBA = px3B;
					myShape.rightPart.startYBA = py3B;
					
					myShape.rightPart.endXBA = px4B;
					myShape.rightPart.endYBA = py4B;
					
					myShape.rightPart.startXA = px3A;
					myShape.rightPart.startYA = py3A;
					
					myShape.rightPart.endXA = px4A;
					myShape.rightPart.endYA = py4A;
					
				}
				else if (myShape.noSidesTop == 3)
				{
					
					myShape.rightPart.startXC = px4c;
					myShape.rightPart.startYC = py4c;
					
					myShape.rightPart.endXC = px5c;
					myShape.rightPart.endYC = py5c;
					
					myShape.rightPart.startX = px4;
					myShape.rightPart.startY = py4;
					
					myShape.rightPart.endX = px5;
					myShape.rightPart.endY = py5;
					
					myShape.rightPart.startXBA = px4B;
					myShape.rightPart.startYBA = py4B;
					
					myShape.rightPart.endXBA = px5B;
					myShape.rightPart.endYBA = py5B;
					
					myShape.rightPart.startXA = px4A;
					myShape.rightPart.startYA = py4A;
					
					myShape.rightPart.endXA = px5A;
					myShape.rightPart.endYA = py5A;
					
				}
			}
			if (myShape.noSidesBot == 1)
			{
				
				if (myShape.noSidesTop == 1 && myShape.noSidesRight == 1)
				{
					
					myShape.bot1Part.startXC = px3c;
					myShape.bot1Part.startYC = py3c;
					
					myShape.bot1Part.endXC = px4c;
					myShape.bot1Part.endYC = py4c;
					
					myShape.bot1Part.startX = px3;
					myShape.bot1Part.startY = py3;
					
					myShape.bot1Part.endX = px4;
					myShape.bot1Part.endY = py4;
					
					myShape.bot1Part.startXBA = px3B;
					myShape.bot1Part.startYBA = py3B;
					
					myShape.bot1Part.endXBA = px4B;
					myShape.bot1Part.endYBA = py4B;
					
					myShape.bot1Part.startXA = px3A;
					myShape.bot1Part.startYA = py3A;
					
					myShape.bot1Part.endXA = px4A;
					myShape.bot1Part.endYA = py4A;
					
					if (myShape.noSidesLeft == 1)
					{
						
						myShape.leftPart.startXC = px4c;
						myShape.leftPart.startYC = py4c;
						
						myShape.leftPart.endXC = px1c;
						myShape.leftPart.endYC = py1c;
						
						myShape.leftPart.startX = px4;
						myShape.leftPart.startY = py4;
						
						myShape.leftPart.endX = px1;
						myShape.leftPart.endY = py1;
						
						myShape.leftPart.startXBA = px4B;
						myShape.leftPart.startYBA = py4B;
						
						myShape.leftPart.endXBA = px1B;
						myShape.leftPart.endYBA = py1B;
						
						myShape.leftPart.startXA = px4A;
						myShape.leftPart.startYA = py4A;
						
						myShape.leftPart.endXA = px1A;
						myShape.leftPart.endYA = py1A;
					}
					
				}
				else if (myShape.noSidesTop == 1 && myShape.noSidesRight == 0)
				{
					
					myShape.bot1Part.startXC = px2c;
					myShape.bot1Part.startYC = py2c;
					
					myShape.bot1Part.startX = px2;
					myShape.bot1Part.startY = py2;
					
					if (myShape.noSides >= 3)
					{
						
						myShape.bot1Part.endXC = px3c;
						myShape.bot1Part.endYC = py3c;
						
						myShape.bot1Part.endX = px3;
						myShape.bot1Part.endY = py3;
						
						myShape.bot1Part.endXBA = px3B;
						myShape.bot1Part.endYBA = py3B;
						
						myShape.bot1Part.endXA = px3A;
						myShape.bot1Part.endYA = py3A;
						
					}
					else
					{
						
						myShape.bot1Part.endXC = px1c;
						myShape.bot1Part.endYC = py1c;
						
						myShape.bot1Part.endX = px1;
						myShape.bot1Part.endY = py1;
						
						myShape.bot1Part.endXBA = px1B;
						myShape.bot1Part.endYBA = py1B;
						
						myShape.bot1Part.endXA = px1A;
						myShape.bot1Part.endYA = py1A;
						
					}
					
					myShape.bot1Part.startXBA = px2B;
					myShape.bot1Part.startYBA = py2B;
					
					myShape.bX3B = px2B;
					myShape.bY3B = py2B;
					
					myShape.bot1Part.startXA = px2A;
					myShape.bot1Part.startYA = py2A;
					
					myShape.bX3A = px2A;
					myShape.bY3A = py2A;
					
					if (myShape.noSidesLeft == 1)
					{
						
						myShape.leftPart.startXC = px3c;
						myShape.leftPart.startYC = py3c;
						
						myShape.leftPart.endXC = px1c;
						myShape.leftPart.endYC = py1c;
						
						myShape.leftPart.startX = px3;
						myShape.leftPart.startY = py3;
						
						myShape.leftPart.endX = px1;
						myShape.leftPart.endY = py1;
						
						myShape.leftPart.startXBA = px3B;
						myShape.leftPart.startYBA = py3B;
						
						myShape.leftPart.endXBA = px1B;
						myShape.leftPart.endYBA = py1B;
						
						myShape.leftPart.startXA = px3A;
						myShape.leftPart.startYA = py3A;
						
						myShape.leftPart.endXA = px1A;
						myShape.leftPart.endYA = py1A;
						
						myShape.bot1Part.endXBA = px3B;
						myShape.bot1Part.endYBA = py3B;
						
						myShape.bot1Part.endXA = px3A;
						myShape.bot1Part.endYA = py3A;
						
					}
					else
					{
						
						myShape.bot1Part.endXBA = px1B;
						myShape.bot1Part.endYBA = py1B;
						
						myShape.bot1Part.endXA = px1A;
						myShape.bot1Part.endYA = py1A;
						
					}
				}
				if (myShape.noSidesTop == 2 && myShape.noSidesRight == 1)
				{
					
					myShape.bot1Part.startXC = px4c;
					myShape.bot1Part.startYC = py4c;
					
					myShape.bot1Part.startX = px4;
					myShape.bot1Part.startY = py4;
					
					myShape.bX3 = px4;
					myShape.bY3 = py4;
					
					myShape.bot1Part.startXBA = px4B;
					myShape.bot1Part.startYBA = py4B;
					
					myShape.bX3B = px4B;
					myShape.bY3B = py4B;
					
					myShape.bot1Part.startXA = px4A;
					myShape.bot1Part.startYA = py4A;
					
					myShape.bX3A = px4A;
					myShape.bY3A = py4A;
					
					myShape.bCX3 = bCX3 = px4c;
					myShape.bCY3 = bCY3 = py4c;
					
					if (myShape.noSidesLeft == 1)
					{
						
						myShape.leftPart.startXC = px5c;
						myShape.leftPart.startYC = py5c;
						
						myShape.leftPart.endXC = px1c;
						myShape.leftPart.endYC = py1c;
						
						myShape.leftPart.startX = px5;
						myShape.leftPart.startY = py5;
						
						myShape.leftPart.endX = px1;
						myShape.leftPart.endY = py1;
						
						myShape.leftPart.startXBA = px5B;
						myShape.leftPart.startYBA = py5B;
						
						myShape.leftPart.endXBA = px1B;
						myShape.leftPart.endYBA = py1B;
						
						myShape.leftPart.startXA = px5A;
						myShape.leftPart.startYA = py5A;
						
						myShape.leftPart.endXA = px1A;
						myShape.leftPart.endYA = py1A;
						
						myShape.bot1Part.endXC = px5;
						myShape.bot1Part.endYC = py5;
						
						myShape.bot1Part.endXBA = px5B;
						myShape.bot1Part.endYBA = py5B;
						
						myShape.bot1Part.endXA = px5A;
						myShape.bot1Part.endYA = py5A;
						
					}
					else
					{
						
						myShape.bot1Part.endXC = px1c;
						myShape.bot1Part.endYC = py1c;
						
						myShape.bot1Part.endX = px1;
						myShape.bot1Part.endY = py1;
						
						myShape.bot1Part.endXBA = px1B;
						myShape.bot1Part.endYBA = py1B;
						
						myShape.bot1Part.endXA = px1A;
						myShape.bot1Part.endYA = py1A;
					}
					
				}
				else if (myShape.noSidesTop == 2 && myShape.noSidesRight == 0)
				{
					
					myShape.bot1Part.startXC = px3c;
					myShape.bot1Part.startYC = py3c;
					
					myShape.bot1Part.startX = px3;
					myShape.bot1Part.startY = py3;
					
					myShape.bot1Part.startXBA = px3B;
					myShape.bot1Part.startYBA = py3B;
					
					myShape.bot1Part.startXA = px3A;
					myShape.bot1Part.startYA = py3A;
					
					if (myShape.noSidesLeft == 1)
					{
						
						myShape.leftPart.startXC = px4c;
						myShape.leftPart.startYC = py4c;
						
						myShape.leftPart.endXC = px1c;
						myShape.leftPart.endYC = py1c;
						
						myShape.leftPart.startX = px4;
						myShape.leftPart.startY = py4;
						
						myShape.leftPart.endX = px1;
						myShape.leftPart.endY = py1;
						
						myShape.leftPart.startXBA = px4B;
						myShape.leftPart.startYBA = py4B;
						
						myShape.leftPart.endXBA = px1B;
						myShape.leftPart.endYBA = py1B;
						
						myShape.leftPart.startXA = px4A;
						myShape.leftPart.startYA = py4A;
						
						myShape.leftPart.endXA = px1A;
						myShape.leftPart.endYA = py1A;
						
						myShape.bot1Part.endXC = px4c;
						myShape.bot1Part.endYC = py4c;
						
						myShape.bot1Part.endX = px4;
						myShape.bot1Part.endY = py4;
						
						myShape.bot1Part.endXBA = px4B;
						myShape.bot1Part.endYBA = py4B;
						
						myShape.bot1Part.endXA = px4A;
						myShape.bot1Part.endYA = py4A;
						
					}
					else
					{
						
						myShape.bot1Part.endXC = px1c;
						myShape.bot1Part.endYC = py1c;
						
						myShape.bot1Part.endX = px1;
						myShape.bot1Part.endY = py1;
						
						myShape.bot1Part.endXBA = px1B;
						myShape.bot1Part.endYBA = py1B;
						
						myShape.bot1Part.endXA = px1A;
						myShape.bot1Part.endYA = py1A;
						
					}
				}
				
				if (myShape.noSidesTop == 3 && myShape.noSidesRight == 1)
				{
					
					myShape.bot1Part.startXC = px5c;
					myShape.bot1Part.startYC = py5c;
					
					myShape.bot1Part.startX = px5;
					myShape.bot1Part.startY = py5;
					
					myShape.bot1Part.startXBA = px5B;
					myShape.bot1Part.startYBA = py5B;
					
					myShape.bot1Part.startXA = px5A;
					myShape.bot1Part.startYA = py5A;
					
					if (myShape.noSidesLeft == 1)
					{
						
						myShape.leftPart.startXC = px6c;
						myShape.leftPart.startYC = py6c;
						
						myShape.leftPart.endXC = px1c;
						myShape.leftPart.endYC = py1c;
						
						myShape.leftPart.startX = px6;
						myShape.leftPart.startY = py6;
						
						myShape.leftPart.endX = px1;
						myShape.leftPart.endY = py1;
						
						myShape.leftPart.startXBA = px6B;
						myShape.leftPart.startYBA = py6B;
						
						myShape.leftPart.endXBA = px1B;
						myShape.leftPart.endYBA = py1B;
						
						myShape.leftPart.startXA = px6A;
						myShape.leftPart.startYA = py6A;
						
						myShape.leftPart.endXA = px1A;
						myShape.leftPart.endYA = py1A;
						
						myShape.bot1Part.endXC = px6c;
						myShape.bot1Part.endYC = py6c;
						
						myShape.bot1Part.endX = px6;
						myShape.bot1Part.endY = py6;
						
						myShape.bot1Part.endXBA = px6B;
						myShape.bot1Part.endYBA = py6B;
						
						myShape.bot1Part.endXA = px6A;
						myShape.bot1Part.endYA = py6A;
						
					}
					else
					{
						
						myShape.bot1Part.endXC = px1c;
						myShape.bot1Part.endYC = py1c;
						
						myShape.bot1Part.endX = px1;
						myShape.bot1Part.endY = py1;
						
						myShape.bot1Part.endXBA = px1B;
						myShape.bot1Part.endYBA = py1B;
						
						myShape.bot1Part.endXA = px1A;
						myShape.bot1Part.endYA = py1A;
					}
					
				}
				else if (myShape.noSidesTop == 3 && myShape.noSidesRight == 0)
				{
					
					myShape.bot1Part.startXC = px4c;
					myShape.bot1Part.startYC = py4c;
					
					myShape.bot1Part.startX = px4;
					myShape.bot1Part.startY = py4;
					
					myShape.bot1Part.startXBA = px4B;
					myShape.bot1Part.startYBA = py4B;
					
					myShape.bot1Part.startXA = px4A;
					myShape.bot1Part.startYA = py4A;
					
					if (myShape.noSidesLeft == 1)
					{
						
						myShape.leftPart.startXC = px5c;
						myShape.leftPart.startYC = py5c;
						
						myShape.leftPart.endXC = px1c;
						myShape.leftPart.endYC = py1c;
						
						myShape.leftPart.startX = px5;
						myShape.leftPart.startY = py5;
						
						myShape.leftPart.endX = px1;
						myShape.leftPart.endY = py1;
						
						myShape.leftPart.startXBA = px5B;
						myShape.leftPart.startYBA = py5B;
						
						myShape.leftPart.endXBA = px1B;
						myShape.leftPart.endYBA = py1B;
						
						myShape.leftPart.startXA = px5A;
						myShape.leftPart.startYA = py5A;
						
						myShape.leftPart.endXA = px1A;
						myShape.leftPart.endYA = py1A;
						
						myShape.bot1Part.endXC = px5c;
						myShape.bot1Part.endYC = py5c;
						
						myShape.bot1Part.endX = px5;
						myShape.bot1Part.endY = py5;
						
						myShape.bot1Part.endXBA = px5B;
						myShape.bot1Part.endYBA = py5B;
						
						myShape.bot1Part.endXA = px5A;
						myShape.bot1Part.endYA = py5A;
						
					}
					else
					{
						
						myShape.bot1Part.endXC = px1c;
						myShape.bot1Part.endYC = py1c;
						
						myShape.bot1Part.endX = px1;
						myShape.bot1Part.endY = py1;
						
						myShape.bot1Part.endXBA = px1B;
						myShape.bot1Part.endYBA = py1B;
						myShape.bot1Part.endXA = px1A;
						myShape.bot1Part.endYA = py1A;
					}
				}
				
			}
			else if (myShape.noSidesBot == 2)
			{
				
				if (myShape.noSidesTop == 1 && myShape.noSidesRight == 1)
				{
					
					myShape.bot1Part.startXC = px3c;
					myShape.bot1Part.startYC = py3c;
					
					myShape.bot1Part.endXC = px4c;
					myShape.bot1Part.endYC = py4c;
					
					myShape.bot1Part.startX = px3;
					myShape.bot1Part.startY = py3;
					
					myShape.bot1Part.endX = px4;
					myShape.bot1Part.endY = py4;
					
					myShape.bot1Part.startXBA = px3B;
					myShape.bot1Part.startYBA = py3B;
					
					myShape.bot1Part.endXBA = px4B;
					myShape.bot1Part.endYBA = py4B;
					
					myShape.bot1Part.startXA = px3A;
					myShape.bot1Part.startYA = py3A;
					
					myShape.bot1Part.endXA = px4A;
					myShape.bot1Part.endYA = py4A;
					
					myShape.bot2Part.startXC = px4c;
					myShape.bot2Part.startYC = py4c;
					
					myShape.bot2Part.endXC = px5c;
					myShape.bot2Part.endYC = py5c;
					
					myShape.bot2Part.startX = px4;
					myShape.bot2Part.startY = py4;
					
					myShape.bot2Part.endX = px5;
					myShape.bot2Part.endY = py5;
					
					myShape.bot2Part.startXBA = px4B;
					myShape.bot2Part.startYBA = py4B;
					
					myShape.bot2Part.endXBA = px5B;
					myShape.bot2Part.endYBA = py5B;
					
					myShape.bot2Part.startXA = px4A;
					myShape.bot2Part.startYA = py4A;
					
					myShape.bot2Part.endXA = px5A;
					myShape.bot2Part.endYA = py5A;
					
					if (myShape.noSidesLeft == 1)
					{
						
						myShape.leftPart.startXC = px5c;
						myShape.leftPart.startYC = py5c;
						
						myShape.leftPart.endXC = px1c;
						myShape.leftPart.endYC = py1c;
						
						myShape.leftPart.startX = px5;
						myShape.leftPart.startY = py5;
						
						myShape.leftPart.endX = px1;
						myShape.leftPart.endY = py1;
						
						myShape.leftPart.startXBA = px5B;
						myShape.leftPart.startYBA = py5B;
						
						myShape.leftPart.endXBA = px1B;
						myShape.leftPart.endYBA = py1B;
						
						myShape.leftPart.startXA = px5A;
						myShape.leftPart.startYA = py5A;
						
						myShape.leftPart.endXA = px1A;
						myShape.leftPart.endYA = py1A;
					}
					
				}
				else if (myShape.noSidesTop == 1 && myShape.noSidesRight == 0)
				{
					
					myShape.bot1Part.startXC = px2c;
					myShape.bot1Part.startYC = py2c;
					
					myShape.bot1Part.endXC = px3c;
					myShape.bot1Part.endYC = py3c;
					
					myShape.bot1Part.startX = px2;
					myShape.bot1Part.startY = py2;
					
					myShape.bot1Part.endX = px3;
					myShape.bot1Part.endY = py3;
					
					myShape.bot1Part.startXBA = px2B;
					myShape.bot1Part.startYBA = py2B;
					
					myShape.bot1Part.endXBA = px3B;
					myShape.bot1Part.endYBA = py3B;
					
					myShape.bot1Part.startXA = px2A;
					myShape.bot1Part.startYA = py2A;
					
					myShape.bot1Part.endXA = px3A;
					myShape.bot1Part.endYA = py3A;
					
					myShape.bot2Part.startXC = px3c;
					myShape.bot2Part.startYC = py3c;
					
					myShape.bot2Part.endXC = px4c;
					myShape.bot2Part.endYC = py4c;
					
					myShape.bot2Part.startX = px3;
					myShape.bot2Part.startY = py3;
					
					myShape.bot2Part.endX = px4;
					myShape.bot2Part.endY = py4;
					
					myShape.bot2Part.startXBA = px3B;
					myShape.bot2Part.startYBA = py3B;
					
					myShape.bot2Part.endXBA = px4B;
					myShape.bot2Part.endYBA = py4B;
					
					myShape.bot2Part.startXA = px3A;
					myShape.bot2Part.startYA = py3A;
					
					myShape.bot2Part.endXA = px4A;
					myShape.bot2Part.endYA = py4A;
					
					if (myShape.noSidesLeft == 1)
					{
						
						myShape.leftPart.startXC = px4c;
						myShape.leftPart.startYC = py4c;
						
						myShape.leftPart.endXC = px1c;
						myShape.leftPart.endYC = py1c;
						
						myShape.leftPart.startX = px4;
						myShape.leftPart.startY = py4;
						
						myShape.leftPart.endX = px1;
						myShape.leftPart.endY = py1;
						
						myShape.leftPart.startXBA = px4B;
						myShape.leftPart.startYBA = py4B;
						
						myShape.leftPart.endXBA = px1B;
						myShape.leftPart.endYBA = py1B;
						
						myShape.leftPart.startXA = px4A;
						myShape.leftPart.startYA = py4A;
						
						myShape.leftPart.endXA = px1A;
						myShape.leftPart.endYA = py1A;
					}
					
				}
				if (myShape.noSidesTop == 2 && myShape.noSidesRight == 1)
				{
					
					myShape.bot1Part.startXC = px4c;
					myShape.bot1Part.startYC = py4c;
					myShape.bot1Part.endXC = px5c;
					myShape.bot1Part.endYC = py5c;
					
					myShape.bot1Part.startX = px4;
					myShape.bot1Part.startY = py4;
					myShape.bot1Part.endX = px5;
					myShape.bot1Part.endY = py5;
					
					myShape.bot1Part.startXBA = px4B;
					myShape.bot1Part.startYBA = py4B;
					
					myShape.bot1Part.endXBA = px5B;
					myShape.bot1Part.endYBA = py5B;
					
					myShape.bot1Part.startXA = px4A;
					myShape.bot1Part.startYA = py4A;
					
					myShape.bot1Part.endXA = px5A;
					myShape.bot1Part.endYA = py5A;
					
					myShape.bot2Part.startXC = px5c;
					myShape.bot2Part.startYC = py5c;
					
					myShape.bot2Part.endXC = px6c;
					myShape.bot2Part.endYC = py6c;
					
					myShape.bot2Part.startX = px5;
					myShape.bot2Part.startY = py5;
					
					myShape.bot2Part.endX = px6;
					myShape.bot2Part.endY = py6;
					
					myShape.bot2Part.startXBA = px5B;
					myShape.bot2Part.startYBA = py5B;
					
					myShape.bot2Part.endXBA = px6B;
					myShape.bot2Part.endYBA = py6B;
					
					myShape.bot2Part.startXA = px5A;
					myShape.bot2Part.startYA = py5A;
					
					myShape.bot2Part.endXA = px6A;
					myShape.bot2Part.endYA = py6A;
					
					if (myShape.noSidesLeft == 1)
					{
						
						myShape.leftPart.startXC = px6c;
						myShape.leftPart.startYC = py6c;
						
						myShape.leftPart.endXC = px1c;
						myShape.leftPart.endYC = py1c;
						
						myShape.leftPart.startX = px6;
						myShape.leftPart.startY = py6;
						
						myShape.leftPart.endX = px1;
						myShape.leftPart.endY = py1;
						
						myShape.leftPart.startXBA = px6B;
						myShape.leftPart.startYBA = py6B;
						
						myShape.leftPart.endXBA = px1B;
						myShape.leftPart.endYBA = py1B;
						
						myShape.leftPart.startXA = px6A;
						myShape.leftPart.startYA = py6A;
						
						myShape.leftPart.endXA = px1A;
						myShape.leftPart.endYA = py1A;
					}
					
				}
				else if (myShape.noSidesTop == 2 && myShape.noSidesRight == 0)
				{
					
					myShape.bot1Part.startXC = px2c;
					myShape.bot1Part.startYC = py2c;
					
					myShape.bot1Part.endXC = px3c;
					myShape.bot1Part.endYC = py3c;
					
					myShape.bot1Part.startX = px2;
					myShape.bot1Part.startY = py2;
					
					myShape.bot1Part.endX = px3;
					myShape.bot1Part.endY = py3;
					
					myShape.bot1Part.startXBA = px2B;
					myShape.bot1Part.startYBA = py2B;
					
					myShape.bot1Part.endXBA = px3B;
					myShape.bot1Part.endYBA = py3B;
					
					myShape.bot1Part.startXA = px2A;
					myShape.bot1Part.startYA = py2A;
					
					myShape.bot1Part.endXA = px3A;
					myShape.bot1Part.endYA = py3A;
					
					myShape.bot2Part.startXC = px3c;
					myShape.bot2Part.startYC = py3c;
					
					myShape.bot2Part.endXC = px4c;
					myShape.bot2Part.endYC = py4c;
					
					myShape.bot2Part.startX = px3;
					myShape.bot2Part.startY = py3;
					
					myShape.bot2Part.endX = px4;
					myShape.bot2Part.endY = py4;
					
					myShape.bot2Part.startXBA = px3B;
					myShape.bot2Part.startYBA = py3B;
					
					myShape.bot2Part.endXBA = px4B;
					myShape.bot2Part.endYBA = py4B;
					
					myShape.bot2Part.startXA = px3A;
					myShape.bot2Part.startYA = py3A;
					
					myShape.bot2Part.endXA = px4A;
					myShape.bot2Part.endYA = py4A;
					
					if (myShape.noSidesLeft == 1)
					{
						
						myShape.leftPart.startXC = px4c;
						myShape.leftPart.startYC = py4c;
						
						myShape.leftPart.endXC = px1c;
						myShape.leftPart.endYC = py1c;
						
						myShape.leftPart.startX = px4;
						myShape.leftPart.startY = py4;
						
						myShape.leftPart.endX = px1;
						myShape.leftPart.endY = py1;
						
						myShape.leftPart.startXBA = px4B;
						myShape.leftPart.startYBA = py4B;
						
						myShape.leftPart.endXBA = px1B;
						myShape.leftPart.endYBA = py1B;
						
						myShape.leftPart.startXA = px4A;
						myShape.leftPart.startYA = py4A;
						
						myShape.leftPart.endXA = px1A;
						myShape.leftPart.endYA = py1A;
					}
					
				}
				if (myShape.noSidesTop == 3 && myShape.noSidesRight == 1)
				{
					
					myShape.bot3Part.startXC = px5c;
					myShape.bot3Part.startYC = py5c;
					
					myShape.bot3Part.endXC = px6c;
					myShape.bot3Part.endYC = py6c;
					
					myShape.bot3Part.startX = px5;
					myShape.bot3Part.startY = py5;
					
					myShape.bot3Part.endX = px6;
					myShape.bot3Part.endY = py6;
					
					myShape.bot3Part.startXBA = px5B;
					myShape.bot3Part.startYBA = py5B;
					
					myShape.bot3Part.endXBA = px6B;
					myShape.bot3Part.endYBA = py6B;
					
					myShape.bot3Part.startXA = px5A;
					myShape.bot3Part.startYA = py5A;
					
					myShape.bot3Part.endXA = px6A;
					myShape.bot3Part.endYA = py6A;
					
					myShape.bot1Part.startXC = px6c;
					myShape.bot1Part.startYC = py6c;
					
					myShape.bot1Part.endXC = px7c;
					myShape.bot1Part.endYC = py7c;
					
					myShape.bot1Part.startX = px6;
					myShape.bot1Part.startY = py6;
					
					myShape.bot1Part.endX = px7;
					myShape.bot1Part.endY = py7;
					
					myShape.bot1Part.startXBA = px6B;
					myShape.bot1Part.startYBA = py6B;
					
					myShape.bot1Part.endXBA = px7B;
					myShape.bot1Part.endYBA = py7B;
					
					myShape.bot1Part.startXA = px6A;
					myShape.bot1Part.startYA = py6A;
					
					myShape.bot1Part.endXA = px7A;
					myShape.bot1Part.endYA = py7A;
					
					myShape.bot2Part.startXC = px7c;
					myShape.bot2Part.startYC = py7c;
					
					myShape.bot2Part.endXC = px8c;
					myShape.bot2Part.endYC = py8c;
					
					myShape.bot2Part.startX = px7;
					myShape.bot2Part.startY = py7;
					
					myShape.bot2Part.endX = px8;
					myShape.bot2Part.endY = py8;
					
					myShape.bot2Part.startXBA = px7B;
					myShape.bot2Part.startYBA = py7B;
					
					myShape.bot2Part.endXBA = px8B;
					myShape.bot2Part.endYBA = py8B;
					
					myShape.bot2Part.startXA = px7A;
					myShape.bot2Part.startYA = py7A;
					
					myShape.bot2Part.endXA = px8A;
					myShape.bot2Part.endYA = py8A;
					
					if (myShape.noSidesLeft == 1)
					{
						
						myShape.leftPart.startXC = px8c;
						myShape.leftPart.startYC = py8c;
						
						myShape.leftPart.endXC = px1c;
						myShape.leftPart.endYC = py1c;
						
						myShape.leftPart.startX = px8;
						myShape.leftPart.startY = py8;
						
						myShape.leftPart.endX = px1;
						myShape.leftPart.endY = py1;
						
						myShape.leftPart.startXBA = px8B;
						myShape.leftPart.startYBA = py8B;
						
						myShape.leftPart.endXBA = px1B;
						myShape.leftPart.endYBA = py1B;
						
						myShape.leftPart.startXA = px8A;
						myShape.leftPart.startYA = py8A;
						
						myShape.leftPart.endXA = px1A;
						myShape.leftPart.endYA = py1A;
						
					}
					
				}
				else if (myShape.noSidesTop == 3 && myShape.noSidesRight == 0)
				{
					
					myShape.bot3Part.startXC = px4c;
					myShape.bot3Part.startYC = py4c;
					
					myShape.bot3Part.endXC = px5c;
					myShape.bot3Part.endYC = py5c;
					
					myShape.bot3Part.startX = px4;
					myShape.bot3Part.startY = py4;
					
					myShape.bot3Part.endX = px5;
					myShape.bot3Part.endY = py5;
					
					myShape.bot3Part.startXBA = px4B;
					myShape.bot3Part.startYBA = py4B;
					
					myShape.bot3Part.endXBA = px5B;
					myShape.bot3Part.endYBA = py5B;
					
					myShape.bot3Part.startXA = px4A;
					myShape.bot3Part.startYA = py4A;
					
					myShape.bot3Part.endXA = px5A;
					myShape.bot3Part.endYA = py5A;
					
					myShape.bot1Part.startXC = px5c;
					myShape.bot1Part.startYC = py5c;
					
					myShape.bot1Part.endXC = px6c;
					myShape.bot1Part.endYC = py6c;
					
					myShape.bot1Part.startX = px5;
					myShape.bot1Part.startY = py5;
					
					myShape.bot1Part.endX = px6;
					myShape.bot1Part.endY = py6;
					
					myShape.bot1Part.startXBA = px5B;
					myShape.bot1Part.startYBA = py5B;
					
					myShape.bot1Part.endXBA = px6B;
					myShape.bot1Part.endYBA = py6B;
					
					myShape.bot1Part.startXA = px5A;
					myShape.bot1Part.startYA = py5A;
					
					myShape.bot1Part.endXA = px6A;
					myShape.bot1Part.endYA = py6A;
					
					myShape.bot2Part.startXC = px6c;
					myShape.bot2Part.startYC = py6c;
					
					myShape.bot2Part.endXC = px7c;
					myShape.bot2Part.endYC = py7c;
					
					myShape.bot2Part.startX = px6;
					myShape.bot2Part.startY = py6;
					
					myShape.bot2Part.endX = px7;
					myShape.bot2Part.endY = py7;
					
					myShape.bot2Part.startXBA = px6B;
					myShape.bot2Part.startYBA = py6B;
					
					myShape.bot2Part.endXBA = px7B;
					myShape.bot2Part.endYBA = py7B;
					
					myShape.bot2Part.startXA = px6A;
					myShape.bot2Part.startYA = py6A;
					
					myShape.bot2Part.endXA = px7A;
					myShape.bot2Part.endYA = py7A;
					
					if (myShape.noSidesLeft == 1)
					{
						
						myShape.leftPart.startXC = px7c;
						myShape.leftPart.startYC = py7c;
						
						myShape.leftPart.endXC = px1c;
						myShape.leftPart.endYC = py1c;
						
						myShape.leftPart.startX = px7;
						myShape.leftPart.startY = py7;
						
						myShape.leftPart.endX = px1;
						myShape.leftPart.endY = py1;
						
						myShape.leftPart.startXBA = px7B;
						myShape.leftPart.startYBA = py7B;
						
						myShape.leftPart.endXBA = px1B;
						myShape.leftPart.endYBA = py1B;
						
						myShape.leftPart.startXA = px7A;
						myShape.leftPart.startYA = py7A;
						
						myShape.leftPart.endXA = px1A;
						myShape.leftPart.endYA = py1A;
					}
				}
			}
			else if (myShape.noSidesBot == 3)
			{
				
				if (myShape.noSidesTop == 1 && myShape.noSidesRight == 1)
				{
					
					myShape.bot1Part.startXC = px3c;
					myShape.bot1Part.startYC = py3c;
					myShape.bot1Part.endXC = px4c;
					myShape.bot1Part.endYC = py4c;
					
					myShape.bot1Part.startX = px3;
					myShape.bot1Part.startY = py3;
					myShape.bot1Part.endX = px4;
					myShape.bot1Part.endY = py4;
					
					myShape.bot1Part.startXBA = px3B;
					myShape.bot1Part.startYBA = py3B;
					
					myShape.bot1Part.endXBA = px4B;
					myShape.bot1Part.endYBA = py4B;
					
					myShape.bot1Part.startXA = px3A;
					myShape.bot1Part.startYA = py3A;
					
					myShape.bot1Part.endXA = px4A;
					myShape.bot1Part.endYA = py4A;
					
					myShape.bot3Part.startXC = px4c;
					myShape.bot3Part.startYC = py4c;
					
					myShape.bot3Part.endXC = px5c;
					myShape.bot3Part.endYC = py5c;
					
					myShape.bot3Part.startX = px4;
					myShape.bot3Part.startY = py4;
					
					myShape.bot3Part.endX = px5;
					myShape.bot3Part.endY = py5;
					
					myShape.bot3Part.startXBA = px4B;
					myShape.bot3Part.startYBA = py4B;
					
					myShape.bot3Part.endXBA = px5B;
					myShape.bot3Part.endYBA = py5B;
					
					myShape.bot3Part.startXA = px4A;
					myShape.bot3Part.startYA = py4A;
					
					myShape.bot3Part.endXA = px5A;
					myShape.bot3Part.endYA = py5A;
					
					myShape.bot2Part.startXC = px5c;
					myShape.bot2Part.startYC = py5c;
					
					myShape.bot2Part.endXC = px6c;
					myShape.bot2Part.endYC = py6c;
					
					myShape.bot2Part.startX = px5;
					myShape.bot2Part.startY = py5;
					
					myShape.bot2Part.endX = px6;
					myShape.bot2Part.endY = py6;
					
					myShape.bot2Part.startXBA = px5B;
					myShape.bot2Part.startYBA = py5B;
					
					myShape.bot2Part.endXBA = px6B;
					myShape.bot2Part.endYBA = py6B;
					
					myShape.bot2Part.startXA = px5A;
					myShape.bot2Part.startYA = py5A;
					
					myShape.bot2Part.endXA = px6A;
					myShape.bot2Part.endYA = py6A;
					
					if (myShape.noSidesLeft == 1)
					{
						
						myShape.leftPart.startXC = px6c;
						myShape.leftPart.startYC = py6c;
						
						myShape.leftPart.endXC = px1c;
						myShape.leftPart.endYC = py1c;
						
						myShape.leftPart.startX = px6;
						myShape.leftPart.startY = py6;
						
						myShape.leftPart.endX = px1;
						myShape.leftPart.endY = py1;
						
						myShape.leftPart.startXBA = px6B;
						myShape.leftPart.startYBA = py6B;
						
						myShape.leftPart.endXBA = px1B;
						myShape.leftPart.endYBA = py1B;
						
						myShape.leftPart.startXA = px6A;
						myShape.leftPart.startYA = py6A;
						
						myShape.leftPart.endXA = px1A;
						myShape.leftPart.endYA = py1A;
					}
					
				}
				else if (myShape.noSidesTop == 1 && myShape.noSidesRight == 0)
				{
					
					myShape.bot1Part.startXC = px2c;
					myShape.bot1Part.startYC = py2c;
					
					myShape.bot1Part.endXC = px3c;
					myShape.bot1Part.endYC = py3c;
					
					myShape.bot1Part.startX = px2;
					myShape.bot1Part.startY = py2;
					
					myShape.bot1Part.endX = px3;
					myShape.bot1Part.endY = py3;
					
					myShape.bot1Part.startXBA = px2B;
					myShape.bot1Part.startYBA = py2B;
					
					myShape.bot1Part.endXBA = px3B;
					myShape.bot1Part.endYBA = py3B;
					
					myShape.bot1Part.startXA = px2A;
					myShape.bot1Part.startYA = py2A;
					
					myShape.bot1Part.endXA = px3A;
					myShape.bot1Part.endYA = py3A;
					
					myShape.bot3Part.startXC = px3c;
					myShape.bot3Part.startYC = py3c;
					
					myShape.bot3Part.endXC = px4c;
					myShape.bot3Part.endYC = py4c;
					
					myShape.bot3Part.startX = px3;
					myShape.bot3Part.startY = py3;
					
					myShape.bot3Part.endX = px4;
					myShape.bot3Part.endY = py4;
					
					myShape.bot3Part.startXBA = px3B;
					myShape.bot3Part.startYBA = py3B;
					
					myShape.bot3Part.endXBA = px4B;
					myShape.bot3Part.endYBA = py4B;
					
					myShape.bot3Part.startXA = px3A;
					myShape.bot3Part.startYA = py3A;
					
					myShape.bot3Part.endXA = px4A;
					myShape.bot3Part.endYA = py4A;
					
					myShape.bot2Part.startXC = px4c;
					myShape.bot2Part.startYC = py4c;
					
					myShape.bot2Part.endXC = px5c;
					myShape.bot2Part.endYC = py5c;
					
					myShape.bot2Part.startX = px4;
					myShape.bot2Part.startY = py4;
					
					myShape.bot2Part.endX = px5;
					myShape.bot2Part.endYC = py5;
					
					myShape.bot2Part.startXBA = px4B;
					myShape.bot2Part.startYBA = py4B;
					
					myShape.bot2Part.endXBA = px5B;
					myShape.bot2Part.endYBA = py5B;
					
					myShape.bot2Part.startXA = px4A;
					myShape.bot2Part.startYA = py4A;
					
					myShape.bot2Part.endXA = px5A;
					myShape.bot2Part.endYA = py5A;
					
					if (myShape.noSidesLeft == 1)
					{
						
						myShape.leftPart.startXC = px5c;
						myShape.leftPart.startYC = py5c;
						
						myShape.leftPart.endXC = px1c;
						myShape.leftPart.endYC = py1c;
						
						myShape.leftPart.startX = px5;
						myShape.leftPart.startY = py5;
						
						myShape.leftPart.endX = px1;
						myShape.leftPart.endY = py1;
						
						myShape.leftPart.startXBA = px5B;
						myShape.leftPart.startYBA = py5B;
						
						myShape.leftPart.endXBA = px1B;
						myShape.leftPart.endYBA = py1B;
						
						myShape.leftPart.startXA = px5A;
						myShape.leftPart.startYA = py5A;
						
						myShape.leftPart.endXA = px1A;
						myShape.leftPart.endYA = py1A;
					}
					
				}
				
				if (myShape.noSidesTop == 2 && myShape.noSidesRight == 1)
				{
					
					myShape.bot1Part.startXC = px4c;
					myShape.bot1Part.startYC = py4c;
					
					myShape.bot1Part.endXC = px5c;
					myShape.bot1Part.endYC = py5c;
					
					myShape.bot1Part.startX = px4;
					myShape.bot1Part.startY = py4;
					
					myShape.bot1Part.endX = px5;
					myShape.bot1Part.endY = py5;
					
					myShape.bot1Part.startXBA = px4B;
					myShape.bot1Part.startYBA = py4B;
					myShape.bot1Part.endXBA = px5B;
					myShape.bot1Part.endYBA = py5B;
					
					myShape.bX3B = px4B;
					myShape.bY3B = py4B;
					
					myShape.bot1Part.startXA = px4A;
					myShape.bot1Part.startYA = py4A;
					myShape.bot1Part.endXA = px5A;
					myShape.bot1Part.endYA = py5A;
					
					myShape.bX3A = px4A;
					myShape.bY3A = py4A;
					
					myShape.bCX3 = bCX3 = px4c;
					myShape.bCY3 = bCY3 = py4c;
					
					myShape.bot3Part.startXC = px5c;
					myShape.bot3Part.startYC = py5c;
					
					myShape.bot3Part.endXC = px6c;
					myShape.bot3Part.endYC = py6c;
					
					myShape.bot3Part.startX = px5;
					myShape.bot3Part.startY = py5;
					
					myShape.bot3Part.endX = px6;
					myShape.bot3Part.endY = py6;
					
					myShape.bot3Part.startXBA = px5B;
					myShape.bot3Part.startYBA = py5B;
					myShape.bot3Part.endXBA = px6B;
					myShape.bot3Part.endYBA = py6B;
					
					myShape.bot3Part.startXA = px5A;
					myShape.bot3Part.startYA = py5A;
					myShape.bot3Part.endXA = px6A;
					myShape.bot3Part.endYA = py6A;
					
					myShape.bot2Part.startXC = px6c;
					myShape.bot2Part.startYC = py6c;
					
					myShape.bot2Part.endXC = px7c;
					myShape.bot2Part.endYC = py7c;
					
					myShape.bot2Part.startX = px6;
					myShape.bot2Part.startY = py6;
					
					myShape.bot2Part.endX = px7;
					myShape.bot2Part.endY = py7;
					
					myShape.bot2Part.startXBA = px6B;
					myShape.bot2Part.startYBA = py6B;
					
					myShape.bot2Part.endXBA = px7B;
					myShape.bot2Part.endYBA = py7B;
					
					myShape.bot2Part.startXA = px6A;
					myShape.bot2Part.startYA = py6A;
					
					myShape.bot2Part.endXA = px7A;
					myShape.bot2Part.endYA = py7A;
					
					myShape.bCX4 = bCX4 = px7c;
					myShape.bCY4 = bCY4 = py7c;
					
					if (myShape.noSidesLeft == 1)
					{
						
						myShape.leftPart.startXC = px7c;
						myShape.leftPart.startYC = py7c;
						myShape.leftPart.endXC = px1c;
						myShape.leftPart.endYC = py1c;
						
						myShape.leftPart.startX = px7;
						myShape.leftPart.startY = py7;
						myShape.leftPart.endX = px1;
						myShape.leftPart.endY = py1;
						
						myShape.leftPart.startXBA = px7B;
						myShape.leftPart.startYBA = py7B;
						myShape.leftPart.endXBA = px1B;
						myShape.leftPart.endYBA = py1B;
						
						myShape.leftPart.startXA = px7A;
						myShape.leftPart.startYA = py7A;
						myShape.leftPart.endXA = px1A;
						myShape.leftPart.endYA = py1A;
					}
					
				}
				else if (myShape.noSidesTop == 2 && myShape.noSidesRight == 0)
				{
					
					myShape.bot1Part.startXC = px3c;
					myShape.bot1Part.startYC = py3c;
					myShape.bot1Part.endXC = px4c;
					myShape.bot1Part.endYC = py4c;
					
					myShape.bot1Part.startX = px3;
					myShape.bot1Part.startY = py3;
					myShape.bot1Part.endX = px4;
					myShape.bot1Part.endY = py4;
					
					myShape.bot1Part.startXBA = px3B;
					myShape.bot1Part.startYBA = py3B;
					myShape.bot1Part.endXBA = px4B;
					myShape.bot1Part.endYBA = py4B;
					
					myShape.bot1Part.startXA = px3A;
					myShape.bot1Part.startYA = py3A;
					myShape.bot1Part.endXA = px4A;
					myShape.bot1Part.endYA = py4A;
					myShape.bX3A = px3A;
					myShape.bY3A = py3A;
					
					myShape.bot3Part.startXC = px4c;
					myShape.bot3Part.startYC = py4c;
					myShape.bot3Part.endXC = px5c;
					myShape.bot3Part.endYC = py5c;
					
					myShape.bot3Part.startX = px4;
					myShape.bot3Part.startY = py4;
					myShape.bot3Part.endX = px5;
					myShape.bot3Part.endY = py5;
					
					myShape.bot3Part.startXBA = px4B;
					myShape.bot3Part.startYBA = py4B;
					myShape.bot3Part.endXBA = px5B;
					myShape.bot3Part.endYBA = py5B;
					
					myShape.bot3Part.startXA = px4A;
					myShape.bot3Part.startYA = py4A;
					myShape.bot3Part.endXA = px5A;
					myShape.bot3Part.endYA = py5A;
					
					myShape.bot2Part.startXC = px5c;
					myShape.bot2Part.startYC = py5c;
					myShape.bot2Part.endXC = px6c;
					myShape.bot2Part.endYC = py6c;
					
					myShape.bot2Part.startX = px5;
					myShape.bot2Part.startY = py5;
					myShape.bot2Part.endX = px6;
					myShape.bot2Part.endY = py6;
					
					myShape.bot2Part.startXBA = px5B;
					myShape.bot2Part.startYBA = py5B;
					myShape.bot2Part.endXBA = px6B;
					myShape.bot2Part.endYBA = py6B;
					
					myShape.bot2Part.startXA = px5A;
					myShape.bot2Part.startYA = py5A;
					myShape.bot2Part.endXA = px6A;
					myShape.bot2Part.endYA = py6A;
					
					myShape.bX4B = px6B;
					myShape.bY4B = py6B;
					
					myShape.bX4A = px6A;
					myShape.bY4A = py6A;
					
					myShape.bCX4 = bCX4 = px6c;
					myShape.bCY4 = bCY4 = py6c;
					
					if (myShape.noSidesLeft == 1)
					{
						
						myShape.leftPart.startXC = px6c;
						myShape.leftPart.startYC = py6c;
						myShape.leftPart.endXC = px1c;
						myShape.leftPart.endYC = py1c;
						
						myShape.leftPart.startX = px6;
						myShape.leftPart.startY = py6;
						myShape.leftPart.endX = px1;
						myShape.leftPart.endY = py1;
						
						myShape.leftPart.startXBA = px6B;
						myShape.leftPart.startYBA = py6B;
						myShape.leftPart.endXBA = px1B;
						myShape.leftPart.endYBA = py1B;
						myShape.leftPart.startXA = px6A;
						myShape.leftPart.startYA = py6A;
						myShape.leftPart.endXA = px1A;
						myShape.leftPart.endYA = py1A;
					}
					
				}
				
				if (myShape.noSidesTop == 3 && myShape.noSidesRight == 1)
				{
					
					myShape.bot1Part.startXC = px5c;
					myShape.bot1Part.startYC = py5c;
					myShape.bot1Part.endXC = px6c;
					myShape.bot1Part.endYC = py6c;
					
					myShape.bot1Part.startX = px5;
					myShape.bot1Part.startY = py5;
					myShape.bot1Part.endX = px6;
					myShape.bot1Part.endY = py6;
					
					myShape.bot1Part.startXBA = px5B;
					myShape.bot1Part.startYBA = py5B;
					myShape.bot1Part.endXBA = px6B;
					myShape.bot1Part.endYBA = py6B;
					myShape.bX3B = px5B;
					myShape.bY3B = py5B;
					
					myShape.bot1Part.startXA = px5A;
					myShape.bot1Part.startYA = py5A;
					myShape.bot1Part.endXA = px6A;
					myShape.bot1Part.endYA = py6A;
					
					myShape.bot3Part.startXC = px6c;
					myShape.bot3Part.startYC = py6c;
					myShape.bot3Part.endXC = px7c;
					myShape.bot3Part.endYC = py7c;
					
					myShape.bot3Part.startX = px6;
					myShape.bot3Part.startY = py6;
					myShape.bot3Part.endX = px7;
					myShape.bot3Part.endY = py7;
					
					myShape.bot3Part.startXBA = px6B;
					myShape.bot3Part.startYBA = py6B;
					myShape.bot3Part.endXBA = px7B;
					myShape.bot3Part.endYBA = py7B;
					
					myShape.bot3Part.startXA = px6A;
					myShape.bot3Part.startYA = py6A;
					myShape.bot3Part.endXA = px7A;
					myShape.bot3Part.endYA = py7A;
					
					myShape.bot2Part.startXC = px7c;
					myShape.bot2Part.startYC = py7c;
					myShape.bot2Part.endXC = px8c;
					myShape.bot2Part.endYC = py8c;
					
					myShape.bot2Part.startX = px7;
					myShape.bot2Part.startY = py7;
					myShape.bot2Part.endX = px8;
					myShape.bot2Part.endY = py8;
					
					myShape.bot2Part.startXBA = px7B;
					myShape.bot2Part.startYBA = py7B;
					myShape.bot2Part.endXBA = px8B;
					myShape.bot2Part.endYBA = py8B;
					
					myShape.bot2Part.startXA = px7A;
					myShape.bot2Part.startYA = py7A;
					myShape.bot2Part.endXA = px8A;
					myShape.bot2Part.endYA = py8A;
					
					if (myShape.noSidesLeft == 1)
					{
						
						myShape.leftPart.startXC = px8c;
						myShape.leftPart.startYC = py8c;
						myShape.leftPart.endXC = px1c;
						myShape.leftPart.endYC = py1c;
						
						myShape.leftPart.startX = px8;
						myShape.leftPart.startY = py8;
						myShape.leftPart.endX = px1;
						myShape.leftPart.endY = py1;
						
						myShape.leftPart.startXBA = px8B;
						myShape.leftPart.startYBA = py8B;
						myShape.leftPart.endXBA = px1B;
						myShape.leftPart.endYBA = py1B;
						
						myShape.leftPart.startXA = px8A;
						myShape.leftPart.startYA = py8A;
						myShape.leftPart.endXA = px1A;
						myShape.leftPart.endYA = py1A;
					}
					
				}
				else if (myShape.noSidesTop == 3 && myShape.noSidesRight == 0)
				{
					
					myShape.bot1Part.startXC = px4c;
					myShape.bot1Part.startYC = py4c;
					myShape.bot1Part.endXC = px5c;
					myShape.bot1Part.endYC = py5c;
					
					myShape.bot1Part.startX = px4;
					myShape.bot1Part.startY = py4;
					myShape.bot1Part.endX = px5;
					myShape.bot1Part.endY = py5;
					
					myShape.bot1Part.startXBA = px4B;
					myShape.bot1Part.startYBA = py4B;
					myShape.bot1Part.endXBA = px5B;
					myShape.bot1Part.endYBA = py5B;
					
					myShape.bot1Part.startXA = px4A;
					myShape.bot1Part.startYA = py4A;
					myShape.bot1Part.endXA = px5A;
					myShape.bot1Part.endYA = py5A;
					
					myShape.bot3Part.startXC = px5c;
					myShape.bot3Part.startYC = py5c;
					myShape.bot3Part.endXC = px6c;
					myShape.bot3Part.endYC = py6c;
					
					myShape.bot3Part.startX = px5;
					myShape.bot3Part.startY = py5;
					myShape.bot3Part.endX = px6;
					myShape.bot3Part.endY = py6;
					
					myShape.bot3Part.startXBA = px5B;
					myShape.bot3Part.startYBA = py5B;
					myShape.bot3Part.endXBA = px6B;
					myShape.bot3Part.endYBA = py6B;
					
					myShape.bot3Part.startXA = px5A;
					myShape.bot3Part.startYA = py5A;
					myShape.bot3Part.endXA = px6A;
					myShape.bot3Part.endYA = py6A;
					
					myShape.bot2Part.startXC = px6;
					myShape.bot2Part.startYC = py6;
					myShape.bot2Part.endXC = px7;
					myShape.bot2Part.endYC = py7;
					
					myShape.bot2Part.startXBA = px6B;
					myShape.bot2Part.startYBA = py6B;
					myShape.bot2Part.endXBA = px7B;
					myShape.bot2Part.endYBA = py7B;
					
					myShape.bot2Part.startXA = px6A;
					myShape.bot2Part.startYA = py6A;
					myShape.bot2Part.endXA = px7A;
					myShape.bot2Part.endYA = py7A;
					
					if (myShape.noSidesLeft == 1)
					{
						
						myShape.leftPart.startXC = px7c;
						myShape.leftPart.startYC = py7c;
						myShape.leftPart.endXC = px1c;
						myShape.leftPart.endYC = py1c;
						
						myShape.leftPart.startX = px7;
						myShape.leftPart.startY = py7;
						myShape.leftPart.endX = px1;
						myShape.leftPart.endY = py1;
						
						myShape.leftPart.startXBA = px7B;
						myShape.leftPart.startYBA = py7B;
						myShape.leftPart.endXBA = px1B;
						myShape.leftPart.endYBA = py1B;
						
						myShape.leftPart.startXA = px7A;
						myShape.leftPart.startYA = py7A;
						myShape.leftPart.endXA = px1A;
						myShape.leftPart.endYA = py1A;
					}
					
				}
			}
		}
		
		setProfileAngles(myShape);
		
		setProfileLength(myShape);
		
		// Recheck If sides In Out - Go to Centers
		
		checkSidesInOut(myShape);
		
		myShape.widthMN = (int) (new BigDecimal((Math.max(myShape.bCX3 - myShape.bCX4, myShape.bCX2 - myShape.startingCX)))
					.divide(myFrame2.metricscale, 20, BigDecimal.ROUND_HALF_UP)).doubleValue();
		
		myShape.widthIN = (int) (new BigDecimal((Math.max(myShape.bCX3 - myShape.bCX4, myShape.bCX2 - myShape.startingCX)))
					.divide(myFrame2.imperialscale, 20, BigDecimal.ROUND_HALF_UP)).doubleValue();
		
		myShape.heightMN = (int) (new BigDecimal((myShape.lowestYC - myShape.highestYC)).divide(myFrame2.metricscale, 20,
					BigDecimal.ROUND_HALF_UP)).doubleValue();
		
		myShape.heightIN = (int) (new BigDecimal((myShape.lowestYC - myShape.highestYC)).divide(myFrame2.imperialscale, 20,
					BigDecimal.ROUND_HALF_UP)).doubleValue();
		
		setWH_MI(myShape);
		
		myShape.widthIO = myShape.widthIO;
		
		return myShape;
	}
	
	public ShapeObject makeShapeBkgrdPointsFromPxy(ShapeObject myShape)
	{
	
		myShape.startingCX = px1c;
		myShape.startingCY = py1c;
		
		myShape.startingX = px1;
		myShape.startingY = py1;
		
		myShape.startingXBA = px1B;
		myShape.startingYBA = py1B;
		
		myShape.startingXA = px1A;
		myShape.startingYA = py1A;
		
		myShape.bCX2 = px2c;
		myShape.bCY2 = py2c;
		
		myShape.bX2 = px2;
		myShape.bY2 = py2;
		
		myShape.bX2B = px2B;
		myShape.bY2B = py2B;
		
		myShape.bX2A = px2A;
		myShape.bY2A = py2A;
		
		myShape.bCX3 = px3c;
		myShape.bCY3 = py3c;
		
		myShape.bX3 = px3;
		myShape.bY3 = py3;
		
		myShape.bX3B = px3B;
		myShape.bY3B = py3B;
		
		myShape.bX3A = px3A;
		myShape.bY3A = py3A;
		
		myShape.bCX4 = px4c;
		myShape.bCY4 = py4c;
		
		myShape.bX4 = px4;
		myShape.bY4 = py4;
		
		myShape.bX4B = px4B;
		myShape.bY4B = py4B;
		
		myShape.bX4A = px4A;
		myShape.bY4A = py4A;
		
		if (myShape.noSides == 2)
		{
			
			myShape.bCX4 = bCX4 = myShape.px4c = px4c = px1c;
			myShape.bCY4 = bCY4 = myShape.py4c = py4c = py1c;
			
			myShape.bX4 = bX4 = myShape.px4 = px4 = px1;
			myShape.bY4 = bY4 = myShape.py4 = py4 = py1;
			
			myShape.bX4B = bX4B = px4B = px1B;
			myShape.bY4B = bY4B = py4B = py1B;
			
			myShape.bX4A = bX4A = myShape.px4 = px4A = px1A;
			myShape.bY4A = bY4A = myShape.py4 = py4A = py1A;
			
			myShape.bCX3 = bCX3 = myShape.px3c = px3c = px2c;
			myShape.bCY3 = bCY3 = myShape.py3c = py3c = py2c;
			
			myShape.bX3 = bX3 = myShape.px3 = px3 = px2;
			myShape.bY3 = bY3 = myShape.py3 = py3 = py2;
			
			myShape.bX3B = bX3B = px3B = px2B;
			myShape.bY3B = bY3B = py3B = py2B;
			
			myShape.bX3A = bX3A = myShape.px3 = px3A = px2A;
			myShape.bY3A = bY3A = myShape.py3 = py3A = py2A;
			
		}
		else
		{
			
			if (myShape.noSidesTop == 2)
			{
				
				myShape.bCX2 = bCX2 = px3c;
				myShape.bCY2 = bCY2 = py3c;
				
				myShape.bX2 = px3;
				myShape.bY2 = py3;
				
				myShape.bX2B = px3B;
				myShape.bY2B = py3B;
				
				myShape.bX2A = px3A;
				myShape.bY2A = py3A;
				
			}
			
			if (myShape.noSidesTop == 3)
			{
				
				myShape.bX2 = px4;
				myShape.bY2 = py4;
				
				myShape.bCX2 = bCX2 = px4c;
				myShape.bCY2 = bCY2 = py4c;
				
				myShape.bX2B = px4B;
				myShape.bY2B = py4B;
				
				myShape.bX2A = px4A;
				myShape.bY2A = py4A;
			}
			
			if (myShape.noSidesRight == 1)
			{
				
				if (myShape.noSidesTop == 1)
				{
					
					myShape.bX3 = px3;
					myShape.bY3 = py3;
					
					myShape.bCX3 = bCX3 = px3c;
					myShape.bCY3 = bCY3 = py3c;
					
					myShape.bX3B = px3B;
					myShape.bY3B = py3B;
					
					myShape.bX3A = px3A;
					myShape.bY3A = py3A;
					
				}
				else if (myShape.noSidesTop == 2)
				{
					
					myShape.bX3 = px4;
					myShape.bY3 = py4;
					
					myShape.bX3B = px4B;
					myShape.bY3B = py4B;
					
					myShape.bX3A = px4A;
					myShape.bY3A = py4A;
					
					myShape.bCX3 = bCX3 = px4c;
					myShape.bCY3 = bCY3 = py4c;
					
				}
				else if (myShape.noSidesTop == 3)
				{
					
					myShape.bX3 = px5;
					myShape.bY3 = py5;
					
					myShape.bCX3 = bCX3 = px5c;
					myShape.bCY3 = bCY3 = py5c;
					
					myShape.bX3B = px5B;
					myShape.bY3B = py5B;
					
					myShape.bX3A = px5A;
					myShape.bY3A = py5A;
					
				}
			}
			if (myShape.noSidesBot == 1)
			{
				
				if (myShape.noSidesTop == 1 && myShape.noSidesRight == 1)
				{
					
					myShape.bX4 = px4;
					myShape.bY4 = py4;
					
					myShape.bCX4 = bCX4 = px4c;
					myShape.bCY4 = bCY4 = py4c;
					
					myShape.bX4B = px4B;
					myShape.bY4B = py4B;
					
					myShape.bX4A = px4A;
					myShape.bY4A = py4A;
					
				}
				else if (myShape.noSidesTop == 1 && myShape.noSidesRight == 0)
				{
					
					myShape.bX3 = px2;
					myShape.bY3 = py2;
					
					myShape.bCX3 = px2c;
					myShape.bCY3 = py2c;
					
					myShape.bX3B = px2B;
					myShape.bY3B = py2B;
					
					myShape.bX3A = px2A;
					myShape.bY3A = py2A;
					
					if (myShape.noSidesLeft == 1)
					{
						
						myShape.bX4 = px3;
						myShape.bY4 = py3;
						myShape.bCX4 = bCX4 = px3c;
						myShape.bCY4 = bCY4 = py3c;
						myShape.bX4B = px3B;
						myShape.bY4B = py3B;
						myShape.bX4A = px3A;
						myShape.bY4A = py3A;
						
					}
					else
					{
						
						myShape.bX4 = px1;
						myShape.bY4 = py1;
						
						myShape.bCX4 = bCX4 = px1c;
						myShape.bCY4 = bCY4 = py1c;
						
						myShape.bX4B = px1B;
						myShape.bY4B = py1B;
						
						myShape.bX4A = px1A;
						myShape.bY4A = py1A;
					}
				}
				if (myShape.noSidesTop == 2 && myShape.noSidesRight == 1)
				{
					
					myShape.bX3 = px4;
					myShape.bY3 = py4;
					
					myShape.bX3B = px4B;
					myShape.bY3B = py4B;
					
					myShape.bX3A = px4A;
					myShape.bY3A = py4A;
					
					myShape.bCX3 = bCX3 = px4c;
					myShape.bCY3 = bCY3 = py4c;
					
					if (myShape.noSidesLeft == 1)
					{
						
						myShape.bX4 = px5;
						myShape.bY4 = py5;
						
						myShape.bX4B = px5B;
						myShape.bY4B = py5B;
						
						myShape.bX4A = px5A;
						myShape.bY4A = py5A;
						
						myShape.bCX4 = bCX4 = px5c;
						myShape.bCY4 = bCY4 = py5c;
						
					}
					
				}
				else if (myShape.noSidesTop == 2 && myShape.noSidesRight == 0)
				{
					
					myShape.bX3 = px3;
					myShape.bY3 = py3;
					
					myShape.bX3B = px3B;
					myShape.bY3B = py3B;
					
					myShape.bX3A = px3A;
					myShape.bY3A = py3A;
					
					myShape.bCX3 = bCX3 = px3c;
					myShape.bCY3 = bCY3 = py3c;
					
					if (myShape.noSidesLeft == 1)
					{
						
						myShape.bX4 = px4;
						myShape.bY4 = py4;
						
						myShape.bX4B = px4B;
						myShape.bY4B = py4B;
						
						myShape.bX4A = px4A;
						myShape.bY4A = py4A;
						
						myShape.bCX4 = bCX4 = px4c;
						myShape.bCY4 = bCY3 = py4c;
						
					}
					else
					{
						
						myShape.bX4 = px1;
						myShape.bY4 = py1;
						
						myShape.bX4B = px1B;
						myShape.bY4B = py1B;
						
						myShape.bX4A = px1A;
						myShape.bY4A = py1A;
						
						myShape.bCX4 = bCX4 = px1c;
						myShape.bCY4 = bCY3 = py1c;
						
					}
				}
				
				if (myShape.noSidesTop == 3 && myShape.noSidesRight == 1)
				{
					
					myShape.bX3 = px5;
					myShape.bY3 = py5;
					
					myShape.bCX3 = px5c;
					myShape.bCY3 = py5c;
					
					myShape.bX3B = px5B;
					myShape.bY3B = py5B;
					
					myShape.bX3A = px5A;
					myShape.bY3A = py5A;
					
					if (myShape.noSidesLeft == 1)
					{
						
						myShape.bX4 = px6;
						myShape.bY4 = py6;
						
						myShape.bCX4 = bCX4 = px6c;
						myShape.bCY4 = bCY4 = py6c;
						
						myShape.bX4B = px6B;
						myShape.bY4B = py6B;
						
						myShape.bX4A = px6A;
						myShape.bY4A = py6A;
						
						myShape.bot1Part.endXC = px6;
						myShape.bot1Part.endYC = py6;
						
						myShape.bot1Part.endXBA = px6B;
						myShape.bot1Part.endYBA = py6B;
						
						myShape.bot1Part.endXA = px6A;
						myShape.bot1Part.endYA = py6A;
						
					}
					else
					{
						myShape.bX4 = px5;
						myShape.bY4 = py5;
						
						myShape.bCX4 = bCX4 = px5c;
						myShape.bCY4 = bCY4 = py5c;
						
						myShape.bX4B = px5B;
						myShape.bY4B = py5B;
						
						myShape.bX4A = px5A;
						myShape.bY4A = py5A;
						
					}
					
				}
				else if (myShape.noSidesTop == 3 && myShape.noSidesRight == 0)
				{
					
					myShape.bX3 = px4;
					myShape.bY3 = py4;
					
					myShape.bCX3 = bCX3 = px4c;
					myShape.bCY3 = bCY3 = py4c;
					
					myShape.bX3B = px4B;
					myShape.bY3B = py4B;
					
					myShape.bX3A = px4A;
					myShape.bY3A = py4A;
					
					if (myShape.noSidesLeft == 1)
					{
						
						myShape.bX4 = px5;
						myShape.bY4 = py5;
						
						myShape.bCX4 = bCX4 = px5c;
						myShape.bCY4 = bCY4 = py5c;
						
						myShape.bX4B = px5B;
						myShape.bY4B = py5B;
						
						myShape.bX4A = px5A;
						myShape.bY4A = py5A;
						
					}
					else
					{
						
						myShape.bX4 = px1;
						myShape.bY4 = py1;
						
						myShape.bCX4 = bCX4 = px1c;
						myShape.bCY4 = bCY4 = py1c;
						
						myShape.bX4B = px1B;
						myShape.bY4B = py1B;
						
						myShape.bX4A = px1A;
						myShape.bY4A = py1A;
					}
				}
				
			}
			else if (myShape.noSidesBot == 2)
			{
				
				if (myShape.noSidesTop == 1 && myShape.noSidesRight == 1)
				{
					
					myShape.bX3 = px3;
					myShape.bY3 = py3;
					
					myShape.bX3B = px3B;
					myShape.bY3B = py3B;
					
					myShape.bX3A = px3A;
					myShape.bY3A = py3A;
					
					myShape.bCX3 = bCX3 = px3c;
					myShape.bCY3 = bCY3 = py3c;
					
					myShape.bX4 = px5;
					myShape.bY4 = py5;
					
					myShape.bX4B = px5B;
					myShape.bY4B = py5B;
					
					myShape.bX4A = px5A;
					myShape.bY4A = py5A;
					
					myShape.bCX4 = bCX4 = px5c;
					myShape.bCY4 = bCY4 = py5c;
					
				}
				else if (myShape.noSidesTop == 1 && myShape.noSidesRight == 0)
				{
					
					myShape.bX3 = px2;
					myShape.bY3 = py2;
					
					myShape.bX3B = px2B;
					myShape.bY3B = py2B;
					
					myShape.bX3A = px2A;
					myShape.bY3A = py2A;
					
					myShape.bCX3 = bCX3 = px2c;
					myShape.bCY3 = bCY3 = py2c;
					
					myShape.bX4 = px4;
					myShape.bY4 = py4;
					
					myShape.bX4B = px4B;
					myShape.bY4B = py4B;
					
					myShape.bX4A = px4A;
					myShape.bY4A = py4A;
					
					myShape.bCX4 = bCX4 = px4c;
					myShape.bCY4 = bCY4 = py4c;
					
				}
				if (myShape.noSidesTop == 2 && myShape.noSidesRight == 1)
				{
					
					myShape.bX3 = px4;
					myShape.bY3 = py4;
					
					myShape.bCX3 = bCX3 = px4c;
					myShape.bCY3 = bCY3 = py4c;
					
					myShape.bX3B = px4B;
					myShape.bY3B = py4B;
					
					myShape.bX3A = px4A;
					myShape.bY3A = py4A;
					
					myShape.bX4 = px6;
					myShape.bY4 = py6;
					
					myShape.bX4B = px6B;
					myShape.bY4B = py6B;
					
					myShape.bX4A = px6A;
					myShape.bY4A = py6A;
					
					myShape.bCX4 = bCX4 = px6c;
					myShape.bCY4 = bCY4 = py6c;
					
				}
				else if (myShape.noSidesTop == 2 && myShape.noSidesRight == 0)
				{
					
					myShape.bX3 = px2;
					myShape.bY3 = py2;
					
					myShape.bX3B = px2B;
					myShape.bY3B = py2B;
					
					myShape.bX3A = px2A;
					myShape.bY3A = py2A;
					
					myShape.bCX3 = bCX3 = px2c;
					myShape.bCY3 = bCY3 = py2c;
					
					myShape.bX4 = px4;
					myShape.bY4 = py4;
					
					myShape.bX4B = px4B;
					myShape.bY4B = py4B;
					
					myShape.bX4A = px4A;
					myShape.bY4A = py4A;
					
					myShape.bCX4 = bCX4 = px4c;
					myShape.bCY4 = bCY4 = py4c;
					
				}
				if (myShape.noSidesTop == 3 && myShape.noSidesRight == 1)
				{
					
					myShape.bX3 = px5;
					myShape.bY3 = py5;
					
					myShape.bX3B = bCX3 = px5B;
					myShape.bY3B = bCY3 = py5B;
					
					myShape.bX3A = px5A;
					myShape.bY3A = py5A;
					
					myShape.bCX3 = px5c;
					myShape.bCY3 = py5c;
					
					myShape.bX4 = px8;
					myShape.bY4 = py8;
					
					myShape.bX4B = px8B;
					myShape.bY4B = py8B;
					
					myShape.bX4A = px8A;
					myShape.bY4A = py8A;
					
					myShape.bCX4 = bCX4 = px8c;
					myShape.bCY4 = bCY3 = py8c;
					
				}
				else if (myShape.noSidesTop == 3 && myShape.noSidesRight == 0)
				{
					
					myShape.bX3 = px4;
					myShape.bY3 = py4;
					
					myShape.bX3B = px4B;
					myShape.bY3B = py4B;
					
					myShape.bX3A = px4A;
					myShape.bY3A = py4A;
					
					myShape.bCX3 = bCX3 = px4c;
					myShape.bCY3 = bCY3 = py4c;
					
					myShape.bX4 = px7;
					myShape.bY4 = py7;
					
					myShape.bX4B = px7B;
					myShape.bY4B = py7B;
					
					myShape.bX4A = px7A;
					myShape.bY4A = py7A;
					
					myShape.bCX4 = bCX4 = px7c;
					myShape.bCY4 = bCY4 = py7c;
					
				}
			}
			else if (myShape.noSidesBot == 3)
			{
				
				if (myShape.noSidesTop == 1 && myShape.noSidesRight == 1)
				{
					
					myShape.bX3 = px3;
					myShape.bY3 = py3;
					
					myShape.bX3B = px3B;
					myShape.bY3B = py3B;
					
					myShape.bX3A = px3A;
					myShape.bY3A = py3A;
					
					myShape.bCX3 = bCX3 = px3c;
					myShape.bCY3 = bCY3 = py3c;
					
					myShape.bX4 = px6;
					myShape.bY4 = py6;
					
					myShape.bX4B = px6B;
					myShape.bY4B = py6B;
					
					myShape.bX4A = px6A;
					myShape.bY4A = py6A;
					
					myShape.bCX4 = bCX4 = px6c;
					myShape.bCY4 = bCY4 = py6c;
					
				}
				else if (myShape.noSidesTop == 1 && myShape.noSidesRight == 0)
				{
					
					myShape.bX3 = px2;
					myShape.bY3 = py2;
					
					myShape.bX3B = px2B;
					myShape.bY3B = py2B;
					
					myShape.bX3A = px2A;
					myShape.bY3A = py2A;
					
					myShape.bCX3 = bCX3 = px2c;
					myShape.bCY3 = bCY3 = py2c;
					
					myShape.bX4 = px5;
					myShape.bY4 = py5;
					myShape.bX4B = px5B;
					myShape.bY4B = py5B;
					
					myShape.bCX4 = bCX4 = px5c;
					myShape.bCY4 = bCY4 = py5c;
					
				}
				
				if (myShape.noSidesTop == 2 && myShape.noSidesRight == 1)
				{
					
					myShape.bX3 = px4;
					myShape.bY3 = py4;
					
					myShape.bX3B = px4B;
					myShape.bY3B = py4B;
					
					myShape.bX3A = px4A;
					myShape.bY3A = py4A;
					
					myShape.bCX3 = bCX3 = px4c;
					myShape.bCY3 = bCY3 = py4c;
					
					myShape.bX4 = px7;
					myShape.bY4 = py7;
					
					myShape.bX4B = px7B;
					myShape.bY4B = py7B;
					
					myShape.bX4A = px7A;
					myShape.bY4A = py7A;
					
					myShape.bCX4 = bCX4 = px7c;
					myShape.bCY4 = bCY4 = py7c;
					
				}
				else if (myShape.noSidesTop == 2 && myShape.noSidesRight == 0)
				{
					
					myShape.bX3 = px3;
					myShape.bY3 = py3;
					
					myShape.bX3B = px3B;
					myShape.bY3B = py3B;
					
					myShape.bCX3 = bCX3 = px3c;
					myShape.bCY3 = bCY3 = py3c;
					
					myShape.bX3A = px3A;
					myShape.bY3A = py3A;
					
					myShape.bX4 = px6;
					myShape.bY4 = py6;
					
					myShape.bX4B = px6B;
					myShape.bY4B = py6B;
					
					myShape.bX4A = px6A;
					myShape.bY4A = py6A;
					
					myShape.bCX4 = bCX4 = px6c;
					myShape.bCY4 = bCY4 = py6c;
					
				}
				
				if (myShape.noSidesTop == 3 && myShape.noSidesRight == 1)
				{
					
					myShape.bX3 = px5;
					myShape.bY3 = py5;
					
					myShape.bX3B = px5B;
					myShape.bY3B = py5B;
					
					myShape.bX3A = px5A;
					myShape.bY3A = py5A;
					
					myShape.bCX3 = bCX3 = px5c;
					myShape.bCY3 = bCY3 = py5c;
					
					myShape.bX4 = px8;
					myShape.bY4 = py8;
					
					myShape.bX4B = px8B;
					myShape.bY4B = py8B;
					
					myShape.bX4A = px8A;
					myShape.bY4A = py8A;
					
					myShape.bCX4 = bCX4 = px8c;
					myShape.bCY4 = bCY4 = py8c;
					
				}
				else if (myShape.noSidesTop == 3 && myShape.noSidesRight == 0)
				{
					
					myShape.bX3 = px4;
					myShape.bY3 = py4;
					
					myShape.bX3B = px4B;
					myShape.bY3B = py4B;
					
					myShape.bX3A = px4A;
					myShape.bY3A = py4A;
					
					myShape.bCX3 = bCX3 = px4c;
					myShape.bCY3 = bCY3 = py4c;
					
					myShape.bX4 = px7;
					myShape.bY4 = py7;
					
					myShape.bX4B = px7B;
					myShape.bY4B = py7B;
					
					myShape.bX4A = px7A;
					myShape.bY4A = py7A;
					
					myShape.bCX4 = bCX4 = px7c;
					myShape.bCY4 = bCY4 = py7c;
					
				}
			}
		}
		
		return myShape;
	}
	
	public ShapeObject startTop1(final ShapeObject myShape)
	{
	
		/*
		 * -- End Type Specs -- End Type:
		 * 
		 * Left: bottom RB Top LT
		 * 
		 * top: Left RB right LT
		 * 
		 * right: Top RB Bottom LT
		 * 
		 * Bot: Right LT Bottom RB
		 */
		
		if (myParent.noSidesLeft > 0)
		{
			
			if (myShape.top1Part.endTypeRB == 1)
			{
				
				/*
				 * T: C B BA A L: C B BA A
				 */
				
				myShape.top1Part.startXC = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, leftSXC, leftSYC, leftEXC,
							leftEYC);
				
				myShape.top1Part.startYC = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, leftSXC, leftSYC, leftEXC,
							leftEYC);
				
				myShape.top1Part.startX = this.intersectX(top1SX, top1SY, top1EX, top1EY, leftSX, leftSY, leftEX, leftEY);
				
				myShape.top1Part.startY = this.intersectY(top1SX, top1SY, top1EX, top1EY, leftSX, leftSY, leftEX, leftEY);
				
				myShape.top1Part.startXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, leftSXBA, leftSYBA,
							leftEXBA, leftEYBA);
				
				myShape.top1Part.startYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, leftSXBA, leftSYBA,
							leftEXBA, leftEYBA);
				
				myShape.top1Part.startXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, leftSXA, leftSYA, leftEXA,
							leftEYA);
				
				myShape.top1Part.startYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, leftSXA, leftSYA, leftEXA,
							leftEYA);
				
				// ///////////////////////////////
				
				myShape.leftPart.endTypeLT = 1;
				
				/*
				 * T: C B BA A L: C B BA A
				 */
				
				myShape.leftPart.endXC = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, leftSXC, leftSYC, leftEXC,
							leftEYC);
				
				myShape.leftPart.endYC = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, leftSXC, leftSYC, leftEXC,
							leftEYC);
				
				myShape.leftPart.endX = this.intersectX(top1SX, top1SY, top1EX, top1EY, leftSX, leftSY, leftEX, leftEY);
				
				myShape.leftPart.endY = this.intersectY(top1SX, top1SY, top1EX, top1EY, leftSX, leftSY, leftEX, leftEY);
				
				myShape.leftPart.endXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, leftSXBA, leftSYBA,
							leftEXBA, leftEYBA);
				
				myShape.leftPart.endYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, leftSXBA, leftSYBA,
							leftEXBA, leftEYBA);
				
				myShape.leftPart.endXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, leftSXA, leftSYA, leftEXA,
							leftEYA);
				
				myShape.leftPart.endYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, leftSXA, leftSYA, leftEXA,
							leftEYA);
				
			}
			if (myShape.top1Part.endTypeRB == 2)
			{
				
				/*
				 * T: C B BA A L: C A->A
				 */
				
				myShape.top1Part.startXC = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, leftSXC, leftSYC, leftEXC,
							leftEYC);
				
				myShape.top1Part.startYC = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, leftSXC, leftSYC, leftEXC,
							leftEYC);
				
				myShape.top1Part.startX = this.intersectX(top1SX, top1SY, top1EX, top1EY, leftSXC, leftSYC, leftEXC, leftEYC);
				
				myShape.top1Part.startY = this.intersectY(top1SX, top1SY, top1EX, top1EY, leftSXC, leftSYC, leftEXC, leftEYC);
				
				myShape.top1Part.startXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, leftSXC, leftSYC,
							leftEXC, leftEYC);
				
				myShape.top1Part.startYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, leftSXC, leftSYC,
							leftEXC, leftEYC);
				
				myShape.top1Part.startXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, leftSXA, leftSYA, leftEXA,
							leftEYA);
				
				myShape.top1Part.startYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, leftSXA, leftSYA, leftEXA,
							leftEYA);
				
				myShape.top1Part.stopAsX = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, leftSXA, leftSYA, leftEXA,
							leftEYA);
				
				myShape.top1Part.stopAsY = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, leftSXA, leftSYA, leftEXA,
							leftEYA);
				
				// /////////////////////////////////
				
				myShape.leftPart.endTypeLT = 3;
				
				/*
				 * T: BA L:C B BA A
				 */
				
				myShape.leftPart.endXC = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, leftSX, leftSY, leftEX,
							leftEY);
				
				myShape.leftPart.endYC = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, leftSX, leftSY, leftEX,
							leftEY);
				
				myShape.leftPart.endX = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, leftSX, leftSY, leftEX,
							leftEY);
				
				myShape.leftPart.endY = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, leftSX, leftSY, leftEX,
							leftEY);
				
				myShape.leftPart.endXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, leftSXBA, leftSYBA,
							leftEXBA, leftEYBA);
				
				myShape.leftPart.endYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, leftSXBA, leftSYBA,
							leftEXBA, leftEYBA);
				
				myShape.leftPart.endXA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, leftSXA, leftSYA, leftEXA,
							leftEYA);
				
				myShape.leftPart.endYA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, leftSXA, leftSYA, leftEXA,
							leftEYA);
				
				// ////
				
			}
			if (myShape.top1Part.endTypeRB == 3)
			{
				
				/* T: C B BA A L: BA */
				
				myShape.top1Part.startXC = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, leftSXBA, leftSYBA, leftEXBA,
							leftEYBA);
				
				myShape.top1Part.startYC = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, leftSXBA, leftSYBA, leftEXBA,
							leftEYBA);
				
				myShape.top1Part.startX = this.intersectX(top1SX, top1SY, top1EX, top1EY, leftSXBA, leftSYBA, leftEXBA,
							leftEYBA);
				
				myShape.top1Part.startY = this.intersectY(top1SX, top1SY, top1EX, top1EY, leftSXBA, leftSYBA, leftEXBA,
							leftEYBA);
				
				myShape.top1Part.startXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, leftSXBA, leftSYBA,
							leftEXBA, leftEYBA);
				
				myShape.top1Part.startYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, leftSXBA, leftSYBA,
							leftEXBA, leftEYBA);
				
				myShape.top1Part.startXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, leftSXBA, leftSYBA, leftEXBA,
							leftEYBA);
				
				myShape.top1Part.startYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, leftSXBA, leftSYBA, leftEXBA,
							leftEYBA);
				
				// /////////////////////////////
				
				myShape.leftPart.endTypeLT = 2;
				
				/* T: C L: C B BA A A->A */
				
				myShape.leftPart.endXC = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, leftSXC, leftSYC, leftEXC,
							leftEYC);
				
				myShape.leftPart.endYC = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, leftSXC, leftSYC, leftEXC,
							leftEYC);
				
				myShape.leftPart.endX = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, leftSX, leftSY, leftEX, leftEY);
				
				myShape.leftPart.endY = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, leftSX, leftSY, leftEX, leftEY);
				
				myShape.leftPart.endXBA = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, leftSXBA, leftSYBA, leftEXBA,
							leftEYBA);
				
				myShape.leftPart.endYBA = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, leftSXBA, leftSYBA, leftEXBA,
							leftEYBA);
				
				myShape.leftPart.endXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, leftSXA, leftSYA, leftEXA,
							leftEYA);
				
				myShape.leftPart.endYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, leftSXA, leftSYA, leftEXA,
							leftEYA);
				
				myShape.leftPart.stopAeX = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, leftSXBA, leftSYBA, leftEXBA,
							leftEYBA);
				
				myShape.leftPart.stopAeY = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, leftSXBA, leftSYBA, leftEXBA,
							leftEYBA);
				
			}
			
		}
		else if (myShape.noSidesBot == 1)
		{ // N0 Left Part
		
			if (myShape.top1Part.endTypeRB == 1)
			{
				
				/* T: C B BA A B: C B BA A */
				
				myShape.top1Part.startXC = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, bot1SXC, bot1SYC, bot1EXC,
							bot1EYC);
				
				myShape.top1Part.startYC = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, bot1SXC, bot1SYC, bot1EXC,
							bot1EYC);
				
				myShape.top1Part.startX = this.intersectX(top1SX, top1SY, top1EX, top1EY, bot1SX, bot1SY, bot1EX, bot1EY);
				
				myShape.top1Part.startY = this.intersectY(top1SX, top1SY, top1EX, top1EY, bot1SX, bot1SY, bot1EX, bot1EY);
				
				myShape.top1Part.startXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXBA, bot1SYBA,
							bot1EXBA, bot1EYBA);
				
				myShape.top1Part.startYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXBA, bot1SYBA,
							bot1EXBA, bot1EYBA);
				
				myShape.top1Part.startXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
				// ////////////////////////////////
				
				myShape.bot1Part.endTypeLT = 1;
				
				/* T: C B BA A B: C B BA A */
				
				myShape.top1Part.startYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
				myShape.bot1Part.endXC = myShape.bot1Part.endX = this.intersectX(top1SX, top1SY, top1EX, top1EY, bot1SX,
							bot1SY, bot1EX, bot1EY);
				
				myShape.bot1Part.endYC = myShape.bot1Part.endY = this.intersectY(top1SX, top1SY, top1EX, top1EY, bot1SX,
							bot1SY, bot1EX, bot1EY);
				
				myShape.bot1Part.endXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXBA, bot1SYBA,
							bot1EXBA, bot1EYBA);
				
				myShape.bot1Part.endYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXBA, bot1SYBA,
							bot1EXBA, bot1EYBA);
				
				myShape.bot1Part.endXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
				myShape.bot1Part.endYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
			}
			if (myShape.top1Part.endTypeRB == 2)
			{
				
				/* T: C B BA A B: C A-A */
				
				myShape.top1Part.startXC = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, bot1SXC, bot1SYC, bot1EXC,
							bot1EYC);
				
				myShape.top1Part.startYC = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, bot1SXC, bot1SYC, bot1EXC,
							bot1EYC);
				
				myShape.top1Part.startX = this.intersectX(top1SX, top1SY, top1EX, top1EY, bot1SXC, bot1SYC, bot1EXC, bot1EYC);
				
				myShape.top1Part.startY = this.intersectY(top1SX, top1SY, top1EX, top1EY, bot1SXC, bot1SYC, bot1EXC, bot1EYC);
				
				myShape.top1Part.startXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXC, bot1SYC,
							bot1EXC, bot1EYC);
				
				myShape.top1Part.startYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXC, bot1SYC,
							bot1EXC, bot1EYC);
				
				myShape.top1Part.startXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
				myShape.top1Part.startYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
				myShape.top1Part.stopAsX = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
				myShape.top1Part.stopAsY = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
				// /////////////////////////////////////////
				
				myShape.bot1Part.endTypeLT = 3;
				
				/* T:BA B: C B BA A */
				
				myShape.bot1Part.endXC = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXC, bot1SYC, bot1EXC,
							bot1EYC);
				
				myShape.bot1Part.endYC = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXC, bot1SYC, bot1EXC,
							bot1EYC);
				
				myShape.bot1Part.endX = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SX, bot1SY, bot1EX,
							bot1EY);
				
				myShape.bot1Part.endY = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SX, bot1SY, bot1EX,
							bot1EY);
				
				myShape.bot1Part.endXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXBA, bot1SYBA,
							bot1EXBA, bot1EYBA);
				
				myShape.bot1Part.endYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXBA, bot1SYBA,
							bot1EXBA, bot1EYBA);
				
				myShape.bot1Part.endXA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
				myShape.bot1Part.endYA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
			}
			if (myShape.top1Part.endTypeRB == 3)
			{
				
				/* T: C B BA A B: BA */
				
				myShape.top1Part.startXC = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, bot1SXBA, bot1SYBA, bot1EXBA,
							bot1EYBA);
				
				myShape.top1Part.startYC = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, bot1SXBA, bot1SYBA, bot1EXBA,
							bot1EYBA);
				
				myShape.top1Part.startX = this.intersectX(top1SX, top1SY, top1EX, top1EY, bot1SXBA, bot1SYBA, bot1EXBA,
							bot1EYBA);
				
				myShape.top1Part.startY = this.intersectY(top1SX, top1SY, top1EX, top1EY, bot1SXBA, bot1SYBA, bot1EXBA,
							bot1EYBA);
				
				myShape.top1Part.startXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXBA, bot1SYBA,
							bot1EXBA, bot1EYBA);
				
				myShape.top1Part.startYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXBA, bot1SYBA,
							bot1EXBA, bot1EYBA);
				
				myShape.top1Part.startXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, bot1SXBA, bot1SYBA, bot1EXBA,
							bot1EYBA);
				
				myShape.top1Part.startYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, bot1SXBA, bot1SYBA, bot1EXBA,
							bot1EYBA);
				
				// ////////////////////////////////////////
				
				myShape.bot1Part.endTypeLT = 2;
				
				/* T: C B: C B BA A A-A */
				
				myShape.bot1Part.endXC = myShape.bot1Part.endX = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, bot1SXC,
							bot1SYC, bot1EXC, bot1EYC);
				
				myShape.bot1Part.endYC = myShape.bot1Part.endY = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, bot1SXC,
							bot1SYC, bot1EXC, bot1EYC);
				
				myShape.bot1Part.endX = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, bot1SX, bot1SY, bot1EX, bot1EY);
				
				myShape.bot1Part.endY = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, bot1SX, bot1SY, bot1EX, bot1EY);
				
				myShape.bot1Part.endXBA = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, bot1SXBA, bot1SYBA, bot1EXBA,
							bot1EYBA);
				
				myShape.bot1Part.endYBA = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, bot1SXBA, bot1SYBA, bot1EXBA,
							bot1EYBA);
				
				myShape.bot1Part.endXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
				myShape.bot1Part.endYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
				myShape.bot1Part.stopAeX = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, bot1SXBA, bot1SYBA, bot1EXBA,
							bot1EYBA);
				
				myShape.bot1Part.stopAeY = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, bot1SXBA, bot1SYBA, bot1EXBA,
							bot1EYBA);
				
			}
			
		}
		else if (myShape.noSidesBot > 1)
		{
			
			if (myShape.top1Part.endTypeRB == 1)
			{
				
				/* T: C B BA A B: C B BA A */
				
				myShape.top1Part.startXC = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, bot2SXC, bot2SYC, bot2EXC,
							bot2EYC);
				
				myShape.top1Part.startYC = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, bot2SXC, bot2SYC, bot2EXC,
							bot2EYC);
				
				myShape.top1Part.startX = this.intersectX(top1SX, top1SY, top1EX, top1EY, bot2SX, bot2SY, bot2EX, bot2EY);
				
				myShape.top1Part.startY = this.intersectY(top1SX, top1SY, top1EX, top1EY, bot2SX, bot2SY, bot2EX, bot2EY);
				
				myShape.top1Part.startXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot2SXBA, bot2SYBA,
							bot2EXBA, bot2EYBA);
				
				myShape.top1Part.startYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot2SXBA, bot2SYBA,
							bot2EXBA, bot2EYBA);
				
				myShape.top1Part.startXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, bot2SXA, bot2SYA, bot2EXA,
							bot2EYA);
				
				// ////////////////////////////////
				
				myShape.bot2Part.endTypeLT = 1;
				
				/* T: C B BA A B: C B BA A */
				
				myShape.top1Part.startYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, bot2SXA, bot2SYA, bot2EXA,
							bot2EYA);
				
				myShape.bot2Part.endXC = myShape.bot2Part.endX = this.intersectX(top1SX, top1SY, top1EX, top1EY, bot2SX,
							bot2SY, bot2EX, bot2EY);
				
				myShape.bot2Part.endYC = myShape.bot2Part.endY = this.intersectY(top1SX, top1SY, top1EX, top1EY, bot2SX,
							bot2SY, bot2EX, bot2EY);
				
				myShape.bot2Part.endXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot2SXBA, bot2SYBA,
							bot2EXBA, bot2EYBA);
				
				myShape.bot2Part.endYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot2SXBA, bot2SYBA,
							bot2EXBA, bot2EYBA);
				
				myShape.bot2Part.endXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, bot2SXA, bot2SYA, bot2EXA,
							bot2EYA);
				
				myShape.bot2Part.endYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, bot2SXA, bot2SYA, bot2EXA,
							bot2EYA);
				
			}
			if (myShape.top1Part.endTypeRB == 2)
			{
				
				/* T: C B BA A B: C A-A */
				
				myShape.top1Part.startXC = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, bot2SXC, bot2SYC, bot2EXC,
							bot2EYC);
				
				myShape.top1Part.startYC = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, bot2SXC, bot2SYC, bot2EXC,
							bot2EYC);
				
				myShape.top1Part.startX = this.intersectX(top1SX, top1SY, top1EX, top1EY, bot2SXC, bot2SYC, bot2EXC, bot2EYC);
				
				myShape.top1Part.startY = this.intersectY(top1SX, top1SY, top1EX, top1EY, bot2SXC, bot2SYC, bot2EXC, bot2EYC);
				
				myShape.top1Part.startXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot2SXC, bot2SYC,
							bot2EXC, bot2EYC);
				
				myShape.top1Part.startYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot2SXC, bot2SYC,
							bot2EXC, bot2EYC);
				
				myShape.top1Part.startXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, bot2SXA, bot2SYA, bot2EXA,
							bot2EYA);
				
				myShape.top1Part.startYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, bot2SXA, bot2SYA, bot2EXA,
							bot2EYA);
				
				myShape.top1Part.stopAsX = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot2SXA, bot2SYA, bot2EXA,
							bot2EYA);
				
				myShape.top1Part.stopAsY = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot2SXA, bot2SYA, bot2EXA,
							bot2EYA);
				
				// /////////////////////////////////////////
				
				myShape.bot2Part.endTypeLT = 3;
				
				/* T:BA B: C B BA A */
				
				myShape.bot2Part.endXC = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot2SXC, bot2SYC, bot2EXC,
							bot2EYC);
				
				myShape.bot2Part.endYC = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot2SXC, bot2SYC, bot2EXC,
							bot2EYC);
				
				myShape.bot2Part.endX = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot2SX, bot2SY, bot2EX,
							bot2EY);
				
				myShape.bot2Part.endY = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot2SX, bot2SY, bot2EX,
							bot2EY);
				
				myShape.bot2Part.endXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot2SXBA, bot2SYBA,
							bot2EXBA, bot2EYBA);
				
				myShape.bot2Part.endYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot2SXBA, bot2SYBA,
							bot2EXBA, bot2EYBA);
				
				myShape.bot2Part.endXA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot2SXA, bot2SYA, bot2EXA,
							bot2EYA);
				
				myShape.bot2Part.endYA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot2SXA, bot2SYA, bot2EXA,
							bot2EYA);
			}
			if (myShape.top1Part.endTypeRB == 3)
			{
				
				/* T: C B BA A B: BA */
				
				myShape.top1Part.startXC = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, bot2SXBA, bot2SYBA, bot2EXBA,
							bot2EYBA);
				
				myShape.top1Part.startYC = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, bot2SXBA, bot2SYBA, bot2EXBA,
							bot2EYBA);
				
				myShape.top1Part.startX = this.intersectX(top1SX, top1SY, top1EX, top1EY, bot2SXBA, bot2SYBA, bot2EXBA,
							bot2EYBA);
				
				myShape.top1Part.startY = this.intersectY(top1SX, top1SY, top1EX, top1EY, bot2SXBA, bot2SYBA, bot2EXBA,
							bot2EYBA);
				
				myShape.top1Part.startXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot2SXBA, bot2SYBA,
							bot2EXBA, bot2EYBA);
				
				myShape.top1Part.startYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot2SXBA, bot2SYBA,
							bot2EXBA, bot2EYBA);
				
				myShape.top1Part.startXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, bot2SXBA, bot2SYBA, bot2EXBA,
							bot2EYBA);
				
				myShape.top1Part.startYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, bot2SXBA, bot2SYBA, bot2EXBA,
							bot2EYBA);
				
				// ////////////////////////////////////////
				
				myShape.bot2Part.endTypeLT = 2;
				
				/* T: C B: C B BA A A-A */
				
				myShape.bot2Part.endXC = myShape.bot2Part.endX = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, bot2SXC,
							bot2SYC, bot2EXC, bot2EYC);
				
				myShape.bot2Part.endYC = myShape.bot2Part.endY = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, bot2SXC,
							bot2SYC, bot2EXC, bot2EYC);
				
				myShape.bot2Part.endX = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, bot2SX, bot2SY, bot2EX, bot2EY);
				
				myShape.bot2Part.endY = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, bot2SX, bot2SY, bot2EX, bot2EY);
				
				myShape.bot2Part.endXBA = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, bot2SXBA, bot2SYBA, bot2EXBA,
							bot2EYBA);
				
				myShape.bot2Part.endYBA = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, bot2SXBA, bot2SYBA, bot2EXBA,
							bot2EYBA);
				
				myShape.bot2Part.endXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, bot2SXA, bot2SYA, bot2EXA,
							bot2EYA);
				
				myShape.bot2Part.endYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, bot2SXA, bot2SYA, bot2EXA,
							bot2EYA);
				
				myShape.bot2Part.stopAeX = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, bot2SXBA, bot2SYBA, bot2EXBA,
							bot2EYBA);
				
				myShape.bot2Part.stopAeY = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, bot2SXBA, bot2SYBA, bot2EXBA,
							bot2EYBA);
				
			}
		}
		
		return myShape;
	}
	
	public ShapeObject noSidesTop1(final ShapeObject myShape)
	{
	
		if (myShape.noSidesTop == 1)
		{
			
			if (myShape.noSidesRight > 0)
			{
				
				if (myShape.top1Part.endTypeLT == 1)
				{
					
					/* T: C B BA A R: C B BA A */
					
					myShape.top1Part.endXC = myShape.top1Part.endX = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC,
								rightSXC, rightSYC, rightEXC, rightEYC);
					
					myShape.top1Part.endYC = myShape.top1Part.endY = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC,
								rightSXC, rightSYC, rightEXC, rightEYC);
					
					myShape.top1Part.endX = this.intersectX(top1SX, top1SY, top1EX, top1EY, rightSX, rightSY, rightEX,
								rightEY);
					
					myShape.top1Part.endY = this.intersectY(top1SX, top1SY, top1EX, top1EY, rightSX, rightSY, rightEX,
								rightEY);
					
					myShape.top1Part.endXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, rightSXBA, rightSYBA,
								rightEXBA, rightEYBA);
					
					myShape.top1Part.endYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, rightSXBA, rightSYBA,
								rightEXBA, rightEYBA);
					
					myShape.top1Part.endXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, rightSXA, rightSYA,
								rightEXA, rightEYA);
					
					myShape.top1Part.endYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, rightSXA, rightSYA,
								rightEXA, rightEYA);
					
					// ///////////////////////////////////////////////
					
					myShape.rightPart.endTypeRB = 1;
					
					/* T: C B BA A R: C B BA A */
					
					myShape.rightPart.startXC = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, rightSXC, rightSYC,
								rightEXC, rightEYC);
					
					myShape.rightPart.startYC = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, rightSXC, rightSYC,
								rightEXC, rightEYC);
					
					myShape.rightPart.startX = this.intersectX(top1SX, top1SY, top1EX, top1EY, rightSX, rightSY, rightEX,
								rightEY);
					
					myShape.rightPart.startY = this.intersectY(top1SX, top1SY, top1EX, top1EY, rightSX, rightSY, rightEX,
								rightEY);
					
					myShape.rightPart.startXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, rightSXBA,
								rightSYBA, rightEXBA, rightEYBA);
					
					myShape.rightPart.startYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, rightSXBA,
								rightSYBA, rightEXBA, rightEYBA);
					
					myShape.rightPart.startXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, rightSXA, rightSYA,
								rightEXA, rightEYA);
					
					myShape.rightPart.startYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, rightSXA, rightSYA,
								rightEXA, rightEYA);
					
				}
				if (myShape.top1Part.endTypeLT == 2)
				{
					
					/* T: C B BA A-A R: C */
					
					myShape.top1Part.endXC = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, rightSXC, rightSYC,
								rightEXC, rightEYC);
					
					myShape.top1Part.endYC = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, rightSXC, rightSYC,
								rightEXC, rightEYC);
					
					myShape.top1Part.endX = this.intersectX(top1SX, top1SY, top1EX, top1EY, rightSXC, rightSYC, rightEXC,
								rightEYC);
					
					myShape.top1Part.endY = this.intersectY(top1SX, top1SY, top1EX, top1EY, rightSXC, rightSYC, rightEXC,
								rightEYC);
					
					myShape.top1Part.endXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, rightSXC, rightSYC,
								rightEXC, rightEYC);
					
					myShape.top1Part.endYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, rightSXC, rightSYC,
								rightEXC, rightEYC);
					
					myShape.top1Part.endXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, rightSXA, rightSYA,
								rightEXA, rightEYA);
					
					myShape.top1Part.endYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, rightSXA, rightSYA,
								rightEXA, rightEYA);
					
					myShape.top1Part.stopAeX = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, rightSXA, rightSYA,
								rightEXA, rightEYA);
					
					myShape.top1Part.stopAeY = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, rightSXA, rightSYA,
								rightEXA, rightEYA);
					
					// /////////////////////////////////
					
					myShape.rightPart.endTypeRB = 3;
					
					/* T: BA R: C B BA A */
					
					myShape.rightPart.startXC = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, rightSXC, rightSYC,
								rightEXC, rightEYC);
					
					myShape.rightPart.startYC = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, rightSXC, rightSYC,
								rightEXC, rightEYC);
					
					myShape.rightPart.startX = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, rightSX, rightSY,
								rightEX, rightEY);
					
					myShape.rightPart.startY = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, rightSX, rightSY,
								rightEX, rightEY);
					
					myShape.rightPart.startXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, rightSXBA,
								rightSYBA, rightEXBA, rightEYBA);
					
					myShape.rightPart.startYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, rightSXBA,
								rightSYBA, rightEXBA, rightEYBA);
					
					myShape.rightPart.startXA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, rightSXA, rightSYA,
								rightEXA, rightEYA);
					
					myShape.rightPart.startYA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, rightSXA, rightSYA,
								rightEXA, rightEYA);
					
				}
				if (myShape.top1Part.endTypeLT == 3)
				{
					
					/* T: C B BA A R: BA */
					
					myShape.top1Part.endXC = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, rightSXBA, rightSYBA,
								rightEXBA, rightEYBA);
					
					myShape.top1Part.endYC = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, rightSXBA, rightSYBA,
								rightEXBA, rightEYBA);
					
					myShape.top1Part.endX = this.intersectX(top1SX, top1SY, top1EX, top1EY, rightSXBA, rightSYBA, rightEXBA,
								rightEYBA);
					
					myShape.top1Part.endY = this.intersectY(top1SX, top1SY, top1EX, top1EY, rightSXBA, rightSYBA, rightEXBA,
								rightEYBA);
					
					myShape.top1Part.endXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, rightSXBA, rightSYBA,
								rightEXBA, rightEYBA);
					
					myShape.top1Part.endYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, rightSXBA, rightSYBA,
								rightEXBA, rightEYBA);
					
					myShape.top1Part.endXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, rightSXBA, rightSYBA,
								rightEXBA, rightEYBA);
					
					myShape.top1Part.endYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, rightSXBA, rightSYBA,
								rightEXBA, rightEYBA);
					
					// //////////////////////////////////////
					
					myShape.rightPart.endTypeRB = 2;
					
					/* T: C R: C B BA A-A */
					
					myShape.rightPart.startXC = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, rightSXC, rightSYC,
								rightEXC, rightEYC);
					
					myShape.rightPart.startYC = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, rightSXC, rightSYC,
								rightEXC, rightEYC);
					
					myShape.rightPart.startXC = myShape.rightPart.startX = this.intersectX(top1SXC, top1SYC, top1EXC,
								top1EYC, rightSX, rightSY, rightEX, rightEY);
					
					myShape.rightPart.startYC = myShape.rightPart.startY = this.intersectY(top1SXC, top1SYC, top1EXC,
								top1EYC, rightSX, rightSY, rightEX, rightEY);
					
					myShape.rightPart.startXBA = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, rightSXBA, rightSYBA,
								rightEXBA, rightEYBA);
					
					myShape.rightPart.startYBA = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, rightSXBA, rightSYBA,
								rightEXBA, rightEYBA);
					
					myShape.rightPart.startXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, rightSXA, rightSYA,
								rightEXA, rightEYA);
					
					myShape.rightPart.startYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, rightSXA, rightSYA,
								rightEXA, rightEYA);
					
					myShape.rightPart.stopAsX = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, rightSXBA, rightSYBA,
								rightEXBA, rightEYBA);
					
					myShape.rightPart.stopAsY = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, rightSXBA, rightSYBA,
								rightEXBA, rightEYBA);
				}
				
			}
			else
			{
				
				if (myShape.noSidesBot <= 3)
				{
					
					if (myShape.top1Part.endTypeLT == 1)
					{
						
						/* T: C B BA A B: C B BA A */
						
						myShape.top1Part.endXC = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, bot1SXC, bot1SYC,
									bot1EXC, bot1EYC);
						
						myShape.top1Part.endYC = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, bot1SXC, bot1SYC,
									bot1EXC, bot1EYC);
						
						myShape.top1Part.endX = this.intersectX(top1SX, top1SY, top1EX, top1EY, bot1SX, bot1SY, bot1EX,
									bot1EY);
						
						myShape.top1Part.endY = this.intersectY(top1SX, top1SY, top1EX, top1EY, bot1SX, bot1SY, bot1EX,
									bot1EY);
						
						myShape.top1Part.endXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXBA,
									bot1SYBA, bot1EXBA, bot1EYBA);
						
						myShape.top1Part.endYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXBA,
									bot1SYBA, bot1EXBA, bot1EYBA);
						
						myShape.top1Part.endXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, bot1SXA, bot1SYA,
									bot1EXA, bot1EYA);
						
						myShape.top1Part.endYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, bot1SXA, bot1SYA,
									bot1EXA, bot1EYA);
						
						myShape.bot1Part.endTypeRB = 1;
						
						myShape.bot1Part.startXC = myShape.top1Part.endXC;
						myShape.bot1Part.startX = myShape.top1Part.endX;
						myShape.bot1Part.startYC = myShape.top1Part.endYC;
						myShape.bot1Part.startY = myShape.top1Part.endY;
						myShape.bot1Part.startXBA = myShape.top1Part.endXBA;
						myShape.bot1Part.startYBA = myShape.top1Part.endYBA;
						myShape.bot1Part.startXA = myShape.top1Part.endXA;
						myShape.bot1Part.startYA = myShape.top1Part.endYA;
						
					}
					if (myShape.top1Part.endTypeLT == 2)
					{
						
						/* T: C B BA A-A B: C */
						
						myShape.top1Part.endXC = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, bot1SXC, bot1SYC,
									bot1EXC, bot1EYC);
						
						myShape.top1Part.endYC = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, bot1SXC, bot1SYC,
									bot1EXC, bot1EYC);
						
						myShape.top1Part.endX = this.intersectX(top1SX, top1SY, top1EX, top1EY, bot1SXC, bot1SYC, bot1EXC,
									bot1EYC);
						
						myShape.top1Part.endY = this.intersectY(top1SX, top1SY, top1EX, top1EY, bot1SXC, bot1SYC, bot1EXC,
									bot1EYC);
						
						myShape.top1Part.endXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXC, bot1SYC,
									bot1EXC, bot1EYC);
						
						myShape.top1Part.endYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXC, bot1SYC,
									bot1EXC, bot1EYC);
						
						myShape.top1Part.endXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, bot1SXA, bot1SYA,
									bot1EXA, bot1EYA);
						
						myShape.top1Part.endYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, bot1SXA, bot1SYA,
									bot1EXA, bot1EYA);
						
						myShape.top1Part.stopAeX = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXA,
									bot1SYA, bot1EXA, bot1EYA);
						
						myShape.top1Part.stopAeY = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXA,
									bot1SYA, bot1EXA, bot1EYA);
						
						// ///////////////////////////////////////////////
						
						myShape.bot1Part.endTypeRB = 3;
						
						/* T: BA B: C B BA A */
						
						myShape.bot1Part.startXC = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXC,
									bot1SYC, bot1EXC, bot1EYC);
						
						myShape.bot1Part.startYC = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXC,
									bot1SYC, bot1EXC, bot1EYC);
						
						myShape.bot1Part.startX = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SX, bot1SY,
									bot1EX, bot1EY);
						
						myShape.bot1Part.startY = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SX, bot1SY,
									bot1EX, bot1EY);
						
						myShape.bot1Part.startXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXBA,
									bot1SYBA, bot1EXBA, bot1EYBA);
						
						myShape.bot1Part.startYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXBA,
									bot1SYBA, bot1EXBA, bot1EYBA);
						
						myShape.bot1Part.startXA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXA,
									bot1SYA, bot1EXA, bot1EYBA);
						
						myShape.bot1Part.startYA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXA,
									bot1SYA, bot1EXA, bot1EYBA);
						
					}
					if (myShape.top1Part.endTypeLT == 3)
					{
						
						/* T: C B BA A B: BA */
						
						myShape.top1Part.endXC = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, bot1SXBA, bot1SYBA,
									bot1EXBA, bot1EYBA);
						
						myShape.top1Part.endYC = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, bot1SXBA, bot1SYBA,
									bot1EXBA, bot1EYBA);
						
						myShape.top1Part.endX = this.intersectX(top1SX, top1SY, top1EX, top1EY, bot1SXBA, bot1SYBA,
									bot1EXBA, bot1EYBA);
						
						myShape.top1Part.endY = this.intersectY(top1SX, top1SY, top1EX, top1EY, bot1SXBA, bot1SYBA,
									bot1EXBA, bot1EYBA);
						
						myShape.top1Part.endXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXBA,
									bot1SYBA, bot1EXBA, bot1EYBA);
						
						myShape.top1Part.endYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, bot1SXBA,
									bot1SYBA, bot1EXBA, bot1EYBA);
						
						myShape.top1Part.endXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, bot1SXBA, bot1SYBA,
									bot1EXBA, bot1EYBA);
						
						myShape.top1Part.endYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, bot1SXBA, bot1SYBA,
									bot1EXBA, bot1EYBA);
						
						// ////////////////////////////////
						
						myShape.bot1Part.endTypeRB = 2;
						
						/* T: C B: C B BA A-A */
						
						myShape.bot1Part.startXC = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, bot1SXC, bot1SYC,
									bot1EXC, bot1EYC);
						
						myShape.bot1Part.startYC = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, bot1SXC, bot1SYC,
									bot1EXC, bot1EYC);
						
						myShape.bot1Part.startX = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, bot1SX, bot1SY,
									bot1EX, bot1EY);
						
						myShape.bot1Part.startY = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, bot1SX, bot1SY,
									bot1EX, bot1EY);
						
						myShape.bot1Part.startXBA = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, bot1SXBA, bot1SYBA,
									bot1EXBA, bot1EYBA);
						
						myShape.bot1Part.startYBA = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, bot1SXBA, bot1SYBA,
									bot1EXBA, bot1EYBA);
						
						myShape.bot1Part.startXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, bot1SXA, bot1SYA,
									bot1EXA, bot1EYA);
						
						myShape.bot1Part.startYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, bot1SXA, bot1SYA,
									bot1EXA, bot1EYA);
						
						myShape.bot1Part.stopAsX = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, bot1SXBA, bot1SYBA,
									bot1EXBA, bot1EYBA);
						
						myShape.bot1Part.stopAsY = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, bot1SXBA, bot1SYBA,
									bot1EXBA, bot1EYBA);
						
					}
					
				}
			}
			
		}
		return myShape;
	}
	
	public ShapeObject noSidesTop2(final ShapeObject myShape)
	{
	
		if (myShape.noSidesTop == 2)
		{
			
			if (myShape.top1Part.endTypeLT == 1)
			{
				
				/* T: C B BA A T2: C B BA A */
				
				myShape.top2Part.startXC = myShape.top1Part.endXC = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC,
							top2SXC, top2SYC, top2EXC, top2EYC);
				
				myShape.top2Part.startYC = myShape.top1Part.endYC = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC,
							top2SXC, top2SYC, top2EXC, top2EYC);
				
				myShape.top2Part.startX = myShape.top1Part.endX = this.intersectX(top1SX, top1SY, top1EX, top1EY, top2SX,
							top2SY, top2EX, top2EY);
				
				myShape.top2Part.startY = myShape.top1Part.endY = this.intersectY(top1SX, top1SY, top1EX, top1EY, top2SX,
							top2SY, top2EX, top2EY);
				
				myShape.top2Part.startXBA = myShape.top1Part.endXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA,
							top2SXBA, top2SYBA, top2EXBA, top2EYBA);
				
				myShape.top2Part.startYBA = myShape.top1Part.endYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA,
							top2SXBA, top2SYBA, top2EXBA, top2EYBA);
				
				myShape.top2Part.startXA = myShape.top1Part.endXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA,
							top2SXA, top2SYA, top2EXA, top2EYA);
				
				myShape.top2Part.startYA = myShape.top1Part.endYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA,
							top2SXA, top2SYA, top2EXA, top2EYA);
				
			}
			if (myShape.top1Part.endTypeLT == 2)
			{
				
				/* T: C B BA A-A T2: C */
				
				myShape.top1Part.endXC = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, top2SXC, top2SYC, top2EXC,
							top2EYC);
				
				myShape.top1Part.endYC = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, top2SXC, top2SYC, top2EXC,
							top2EYC);
				
				myShape.top1Part.endX = this.intersectX(top1SX, top1SY, top1EX, top1EY, top2SXC, top2SYC, top2EXC, top2EYC);
				
				myShape.top1Part.endY = this.intersectY(top1SX, top1SY, top1EX, top1EY, top2SXC, top2SYC, top2EXC, top2EYC);
				
				myShape.top1Part.endXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top2SXC, top2SYC, top2EXC,
							top2EYC);
				
				myShape.top1Part.endYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top2SXC, top2SYC, top2EXC,
							top2EYC);
				
				myShape.top1Part.endXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, top2SXA, top2SYA, top2EXA,
							top2EYA);
				
				myShape.top1Part.endYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, top2SXA, top2SYA, top2EXA,
							top2EYA);
				
				myShape.top1Part.stopAeX = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top2SXA, top2SYA, top2EXA,
							top2EYA);
				
				myShape.top1Part.stopAeY = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top2SXA, top2SYA, top2EXA,
							top2EYA);
				
				// ///////////////////////////////
				
				myShape.top2Part.endTypeRB = 3;
				
				/* T: BA T2: C B BA A */
				
				myShape.top2Part.startXC = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top2SXC, top2SYC, top2EXC,
							top2EYC);
				
				myShape.top2Part.startYC = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top2SXC, top2SYC, top2EXC,
							top2EYC);
				
				myShape.top2Part.startX = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top2SX, top2SY, top2EX,
							top2EY);
				
				myShape.top2Part.startY = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top2SX, top2SY, top2EX,
							top2EY);
				
				myShape.top2Part.startXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top2SXBA, top2SYBA,
							top2EXBA, top2EYBA);
				
				myShape.top2Part.startYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top2SXBA, top2SYBA,
							top2EXBA, top2EYBA);
				
				myShape.top2Part.startXA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top2SXA, top2SYA, top2EXA,
							top2EYA);
				
				myShape.top2Part.startYA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top2SXA, top2SYA, top2EXA,
							top2EYA);
				
			}
			if (myShape.top1Part.endTypeLT == 3)
			{
				
				/* T: C B BA A T2: BA */
				
				myShape.top1Part.endXC = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, top2SXBA, top2SYBA, top2EXBA,
							top2EYBA);
				
				myShape.top1Part.endYC = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, top2SXBA, top2SYBA, top2EXBA,
							top2EYBA);
				
				myShape.top1Part.endX = this.intersectX(top1SX, top1SY, top1EX, top1EY, top2SXBA, top2SYBA, top2EXBA,
							top2EYBA);
				
				myShape.top1Part.endY = this.intersectY(top1SX, top1SY, top1EX, top1EY, top2SXBA, top2SYBA, top2EXBA,
							top2EYBA);
				
				myShape.top1Part.endXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top2SXBA, top2SYBA,
							top2EXBA, top2EYBA);
				
				myShape.top1Part.endYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top2SXBA, top2SYBA,
							top2EXBA, top2EYBA);
				
				myShape.top1Part.endXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, top2SXBA, top2SYBA, top2EXBA,
							top2EYBA);
				
				myShape.top1Part.endYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, top2SXBA, top2SYBA, top2EXBA,
							top2EYBA);
				
				// /////////////////////////////////////
				
				myShape.top2Part.endTypeRB = 2;
				
				/* T: C T2:C B BA A A-A */
				
				myShape.top2Part.startXC = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, top2SXC, top2SYC, top2EXC,
							top2EYC);
				
				myShape.top2Part.startYC = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, top2SXC, top2SYC, top2EXC,
							top2EYC);
				
				myShape.top2Part.startX = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, top2SX, top2SY, top2EX, top2EY);
				
				myShape.top2Part.startY = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, top2SX, top2SY, top2EX, top2EY);
				
				myShape.top2Part.startXBA = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, top2SXBA, top2SYBA, top2EXBA,
							top2EYBA);
				
				myShape.top2Part.startYBA = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, top2SXBA, top2SYBA, top2EXBA,
							top2EYBA);
				
				myShape.top2Part.startXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, top2SXA, top2SYA, top2EXA,
							top2EYA);
				
				myShape.top2Part.startYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, top2SXA, top2SYA, top2EXA,
							top2EYA);
				
				myShape.top2Part.stopAsX = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, top2SXBA, top2SYBA, top2EXBA,
							top2EYBA);
				
				myShape.top2Part.stopAsY = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, top2SXBA, top2SYBA, top2EXBA,
							top2EYBA);
				
			}
			// //////////////////////
			
			if (myShape.noSidesRight > 0)
			{
				this.top2Right(myShape);
				
			}
			else if (myShape.noSidesBot <= 3)
			{
				this.top2Bot1(myShape);
			}
			// else if (myShape.noSidesBot == 3)
			// {
			// this.top2Bot3(myShape);
			// }
			
		}
		return myShape;
	}
	
	public ShapeObject top2Bot1(final ShapeObject myShape)
	{
	
		if (myShape.top2Part.endTypeLT == 1)
		{
			
			/* T2: C B BA A B1:C B BA A */
			
			myShape.top2Part.endXC = this.intersectX(myShape.top2Part.startXC, myShape.top2Part.startYC,
						myShape.top2Part.endXC, myShape.top2Part.endYC, myShape.bot1Part.startXC, myShape.bot1Part.startYC,
						myShape.bot1Part.endXC, myShape.bot1Part.endYC);
			
			myShape.top2Part.endYC = this.intersectY(myShape.top2Part.startXC, myShape.top2Part.startYC,
						myShape.top2Part.endXC, myShape.top2Part.endYC, myShape.bot1Part.startXC, myShape.bot1Part.startYC,
						myShape.bot1Part.endXC, myShape.bot1Part.endYC);
			
			myShape.top2Part.endX = this.intersectX(myShape.top2Part.startX, myShape.top2Part.startY, myShape.top2Part.endX,
						myShape.top2Part.endY, myShape.bot1Part.startX, myShape.bot1Part.startY, myShape.bot1Part.endX,
						myShape.bot1Part.endY);
			
			myShape.top2Part.endY = this.intersectY(myShape.top2Part.startX, myShape.top2Part.startY, myShape.top2Part.endX,
						myShape.top2Part.endY, myShape.bot1Part.startX, myShape.bot1Part.startY, myShape.bot1Part.endX,
						myShape.bot1Part.endY);
			
			myShape.top2Part.endXBA = this.intersectX(myShape.top2Part.startXBA, myShape.top2Part.startYBA,
						myShape.top2Part.endXBA, myShape.top2Part.endYBA, myShape.bot1Part.startXBA,
						myShape.bot1Part.startYBA, myShape.bot1Part.endXBA, myShape.bot1Part.endYBA);
			
			myShape.top2Part.endYBA = this.intersectY(myShape.top2Part.startXBA, myShape.top2Part.startYBA,
						myShape.top2Part.endXBA, myShape.top2Part.endYBA, myShape.bot1Part.startXBA,
						myShape.bot1Part.startYBA, myShape.bot1Part.endXBA, myShape.bot1Part.endYBA);
			
			myShape.top2Part.endXA = this.intersectX(myShape.top2Part.startXA, myShape.top2Part.startYA,
						myShape.top2Part.endXA, myShape.top2Part.endYA, myShape.bot1Part.startXA, myShape.bot1Part.startYA,
						myShape.bot1Part.endXA, myShape.bot1Part.endYA);
			
			myShape.top2Part.endYA = this.intersectY(myShape.top2Part.startXA, myShape.top2Part.startYA,
						myShape.top2Part.endXA, myShape.top2Part.endYA, myShape.bot1Part.startXA, myShape.bot1Part.startYA,
						myShape.bot1Part.endXA, myShape.bot1Part.endYA);
			
			myShape.bot1Part.endTypeRB = 1;
			
			myShape.bot1Part.startXC = myShape.top2Part.endXC;
			myShape.bot1Part.startYC = myShape.top2Part.endYC;
			
			myShape.bot1Part.startXBA = myShape.top2Part.endXBA;
			myShape.bot1Part.startYBA = myShape.top2Part.endYBA;
			
			myShape.bot1Part.startXA = myShape.top2Part.endXA;
			myShape.bot1Part.startYA = myShape.top2Part.endYA;
			
		}
		if (myShape.top2Part.endTypeLT == 2)
		{
			
			/* T2: C B BA A A-A B1:C */
			
			myShape.top2Part.endXC = this.intersectX(myShape.top2Part.startXC, myShape.top2Part.startYC,
						myShape.top2Part.endXC, myShape.top2Part.endYC, myShape.bot1Part.startXC, myShape.bot1Part.startYC,
						myShape.bot1Part.endXC, myShape.bot1Part.endYC);
			
			myShape.top2Part.endYC = this.intersectY(myShape.top2Part.startXC, myShape.top2Part.startYC,
						myShape.top2Part.endXC, myShape.top2Part.endYC, myShape.bot1Part.startXC, myShape.bot1Part.startYC,
						myShape.bot1Part.endXC, myShape.bot1Part.endYC);
			
			myShape.top2Part.endX = this.intersectX(myShape.top2Part.startX, myShape.top2Part.startY, myShape.top2Part.endX,
						myShape.top2Part.endY, myShape.bot1Part.startXC, myShape.bot1Part.startYC, myShape.bot1Part.endXC,
						myShape.bot1Part.endYC);
			
			myShape.top2Part.endY = this.intersectY(myShape.top2Part.startX, myShape.top2Part.startY, myShape.top2Part.endX,
						myShape.top2Part.endY, myShape.bot1Part.startXC, myShape.bot1Part.startYC, myShape.bot1Part.endXC,
						myShape.bot1Part.endYC);
			
			myShape.top2Part.endXBA = this.intersectX(myShape.top2Part.startXBA, myShape.top2Part.startYBA,
						myShape.top2Part.endXBA, myShape.top2Part.endYBA, myShape.bot1Part.startXC,
						myShape.bot1Part.startYC, myShape.bot1Part.endXC, myShape.bot1Part.endYC);
			
			myShape.top2Part.endYBA = this.intersectY(myShape.top2Part.startXBA, myShape.top2Part.startYBA,
						myShape.top2Part.endXBA, myShape.top2Part.endYBA, myShape.bot1Part.startXC,
						myShape.bot1Part.startYC, myShape.bot1Part.endXC, myShape.bot1Part.endYC);
			
			// A-A
			
			myShape.top2Part.endXA = this.intersectX(myShape.top2Part.startXA, myShape.top2Part.startYA,
						myShape.top2Part.endXA, myShape.top2Part.endYA, myShape.bot1Part.startXA, myShape.bot1Part.startYA,
						myShape.bot1Part.endXA, myShape.bot1Part.endYA);
			
			myShape.top2Part.endYA = this.intersectY(myShape.top2Part.startXA, myShape.top2Part.startYA,
						myShape.top2Part.endXA, myShape.top2Part.endYA, myShape.bot1Part.startXA, myShape.bot1Part.startYA,
						myShape.bot1Part.endXA, myShape.bot1Part.endYA);
			
			myShape.top2Part.stopAeX = this.intersectX(myShape.top2Part.startXBA, myShape.top2Part.startYBA,
						myShape.top2Part.endXBA, myShape.top2Part.endYBA, myShape.bot1Part.startXA,
						myShape.bot1Part.startYA, myShape.bot1Part.endXA, myShape.bot1Part.endYA);
			
			myShape.top2Part.stopAeY = this.intersectY(myShape.top2Part.startXBA, myShape.top2Part.startYBA,
						myShape.top2Part.endXBA, myShape.top2Part.endYBA, myShape.bot1Part.startXA,
						myShape.bot1Part.startYA, myShape.bot1Part.endXA, myShape.bot1Part.endYA);
			
			// ///////////////////////////////////
			
			myShape.bot1Part.endTypeRB = 3;
			
			/* T2: BA B1: C B BA A */
			
			myShape.bot1Part.startXC = this.intersectX(myShape.top2Part.startXBA, myShape.top2Part.startYBA,
						myShape.top2Part.endXBA, myShape.top2Part.endYBA, myShape.bot1Part.startXC,
						myShape.bot1Part.startYC, myShape.bot1Part.endXC, myShape.bot1Part.endYC);
			
			myShape.bot1Part.startYC = this.intersectY(myShape.top2Part.startXBA, myShape.top2Part.startYBA,
						myShape.top2Part.endXBA, myShape.top2Part.endYBA, myShape.bot1Part.startXC,
						myShape.bot1Part.startYC, myShape.bot1Part.endXC, myShape.bot1Part.endYC);
			
			myShape.bot1Part.startX = this.intersectX(myShape.top2Part.startXBA, myShape.top2Part.startYBA,
						myShape.top2Part.endXBA, myShape.top2Part.endYBA, myShape.bot1Part.startX, myShape.bot1Part.startY,
						myShape.bot1Part.endX, myShape.bot1Part.endY);
			
			myShape.bot1Part.startY = this.intersectY(myShape.top2Part.startXBA, myShape.top2Part.startYBA,
						myShape.top2Part.endXBA, myShape.top2Part.endYBA, myShape.bot1Part.startX, myShape.bot1Part.startY,
						myShape.bot1Part.endX, myShape.bot1Part.endY);
			
			myShape.bot1Part.startXBA = this.intersectX(myShape.top2Part.startXBA, myShape.top2Part.startYBA,
						myShape.top2Part.endXBA, myShape.top2Part.endYBA, myShape.bot1Part.startXBA,
						myShape.bot1Part.startYBA, myShape.bot1Part.endXBA, myShape.bot1Part.endYBA);
			
			myShape.bot1Part.startYBA = this.intersectY(myShape.top2Part.startXBA, myShape.top2Part.startYBA,
						myShape.top2Part.endXBA, myShape.top2Part.endYBA, myShape.bot1Part.startXBA,
						myShape.bot1Part.startYBA, myShape.bot1Part.endXBA, myShape.bot1Part.endYBA);
			
			myShape.bot1Part.startXA = this.intersectX(myShape.top2Part.startXBA, myShape.top2Part.startYBA,
						myShape.top2Part.endXBA, myShape.top2Part.endYBA, myShape.bot1Part.startXA,
						myShape.bot1Part.startYA, myShape.bot1Part.endXA, myShape.bot1Part.endYA);
			
			myShape.bot1Part.startYA = this.intersectY(myShape.top2Part.startXBA, myShape.top2Part.startYBA,
						myShape.top2Part.endXBA, myShape.top2Part.endYBA, myShape.bot1Part.startXA,
						myShape.bot1Part.startYA, myShape.bot1Part.endXA, myShape.bot1Part.endYA);
			
		}
		if (myShape.top2Part.endTypeLT == 3)
		{
			
			/* T2: C B BA A B1: BA */
			
			myShape.top2Part.endXC = this.intersectX(myShape.top2Part.startXC, myShape.top2Part.startYC,
						myShape.top2Part.endXC, myShape.top2Part.endYC, myShape.bot1Part.startXBA,
						myShape.bot1Part.startYBA, myShape.bot1Part.endXBA, myShape.bot1Part.endYBA);
			
			myShape.top2Part.endYC = this.intersectY(myShape.top2Part.startXC, myShape.top2Part.startYC,
						myShape.top2Part.endXC, myShape.top2Part.endYC, myShape.bot1Part.startXBA,
						myShape.bot1Part.startYBA, myShape.bot1Part.endXBA, myShape.bot1Part.endYBA);
			
			myShape.top2Part.endX = this.intersectX(myShape.top2Part.startX, myShape.top2Part.startY, myShape.top2Part.endX,
						myShape.top2Part.endY, myShape.bot1Part.startXBA, myShape.bot1Part.startYBA,
						myShape.bot1Part.endXBA, myShape.bot1Part.endYBA);
			
			myShape.top2Part.endY = this.intersectY(myShape.top2Part.startX, myShape.top2Part.startY, myShape.top2Part.endX,
						myShape.top2Part.endY, myShape.bot1Part.startXBA, myShape.bot1Part.startYBA,
						myShape.bot1Part.endXBA, myShape.bot1Part.endYBA);
			
			myShape.top2Part.endXBA = this.intersectX(myShape.top2Part.startXBA, myShape.top2Part.startYBA,
						myShape.top2Part.endXBA, myShape.top2Part.endYBA, myShape.bot1Part.startXBA,
						myShape.bot1Part.startYBA, myShape.bot1Part.endXBA, myShape.bot1Part.endYBA);
			
			myShape.top2Part.endYBA = this.intersectY(myShape.top2Part.startXBA, myShape.top2Part.startYBA,
						myShape.top2Part.endXBA, myShape.top2Part.endYBA, myShape.bot1Part.startXBA,
						myShape.bot1Part.startYBA, myShape.bot1Part.endXBA, myShape.bot1Part.endYBA);
			
			myShape.top2Part.endXA = this.intersectX(myShape.top2Part.startXA, myShape.top2Part.startYA,
						myShape.top2Part.endXA, myShape.top2Part.endYA, myShape.bot1Part.startXBA,
						myShape.bot1Part.startYBA, myShape.bot1Part.endXBA, myShape.bot1Part.endYBA);
			
			myShape.top2Part.endYA = this.intersectY(myShape.top2Part.startXA, myShape.top2Part.startYA,
						myShape.top2Part.endXA, myShape.top2Part.endYA, myShape.bot1Part.startXBA,
						myShape.bot1Part.startYBA, myShape.bot1Part.endXBA, myShape.bot1Part.endYBA);
			
			// //////////////////////////////////////
			
			myShape.bot1Part.endTypeRB = 2;
			
			/* T2: C B1: C B BA A-A */
			
			myShape.bot1Part.startXC = this.intersectX(myShape.top2Part.startXC, myShape.top2Part.startYC,
						myShape.top2Part.endXC, myShape.top2Part.endYC, myShape.bot1Part.startXC, myShape.bot1Part.startYC,
						myShape.bot1Part.endXC, myShape.bot1Part.endYC);
			
			myShape.bot1Part.startYC = this.intersectY(myShape.top2Part.startXC, myShape.top2Part.startYC,
						myShape.top2Part.endXC, myShape.top2Part.endYC, myShape.bot1Part.startXC, myShape.bot1Part.startYC,
						myShape.bot1Part.endXC, myShape.bot1Part.endYC);
			
			myShape.bot1Part.startXBA = this.intersectX(myShape.top2Part.startXC, myShape.top2Part.startYC,
						myShape.top2Part.endXC, myShape.top2Part.endYC, myShape.bot1Part.startXBA,
						myShape.bot1Part.startYBA, myShape.bot1Part.endXBA, myShape.bot1Part.endYBA);
			
			myShape.bot1Part.startYBA = this.intersectY(myShape.top2Part.startXC, myShape.top2Part.startYC,
						myShape.top2Part.endXC, myShape.top2Part.endYC, myShape.bot1Part.startXBA,
						myShape.bot1Part.startYBA, myShape.bot1Part.endXBA, myShape.bot1Part.endYBA);
			
			myShape.bot1Part.startXA = this.intersectX(myShape.top2Part.startXA, myShape.top2Part.startYA,
						myShape.top2Part.endXA, myShape.top2Part.endYA, myShape.bot1Part.startXA, myShape.bot1Part.startYA,
						myShape.bot1Part.endXA, myShape.bot1Part.endYA);
			
			myShape.bot1Part.startYA = this.intersectY(myShape.top2Part.startXA, myShape.top2Part.startYA,
						myShape.top2Part.endXA, myShape.top2Part.endYA, myShape.bot1Part.startXA, myShape.bot1Part.startYA,
						myShape.bot1Part.endXA, myShape.bot1Part.endYA);
			
			myShape.bot1Part.stopAsX = this.intersectX(myShape.top2Part.startXA, myShape.top2Part.startYA,
						myShape.top2Part.endXA, myShape.top2Part.endYA, myShape.bot1Part.startXBA,
						myShape.bot1Part.startYBA, myShape.bot1Part.endXBA, myShape.bot1Part.endYBA);
			
			myShape.bot1Part.stopAsY = this.intersectY(myShape.top2Part.startXA, myShape.top2Part.startYA,
						myShape.top2Part.endXA, myShape.top2Part.endYA, myShape.bot1Part.startXBA,
						myShape.bot1Part.startYBA, myShape.bot1Part.endXBA, myShape.bot1Part.endYBA);
			
		}
		return myShape;
	}
	
	public ShapeObject top2Right(final ShapeObject myShape)
	{
	
		if (myShape.top2Part.endTypeLT == 1)
		{
			
			/* T2: C B BA A R: C B BA A */
			
			myShape.top2Part.endXC = this.intersectX(top2SXC, top2SYC, top2EXC, top2EYC, rightSXC, rightSYC, rightEXC,
						rightEYC);
			
			myShape.top2Part.endYC = this.intersectY(top2SXC, top2SYC, top2EXC, top2EYC, rightSXC, rightSYC, rightEXC,
						rightEYC);
			
			myShape.top2Part.endX = this.intersectX(top2SX, top2SY, top2EX, top2EY, rightSX, rightSY, rightEX, rightEY);
			
			myShape.top2Part.endY = this.intersectY(top2SX, top2SY, top2EX, top2EY, rightSX, rightSY, rightEX, rightEY);
			
			myShape.top2Part.endXBA = this.intersectX(top2SXBA, top2SYBA, top2EXBA, top2EYBA, rightSXBA, rightSYBA, rightEXBA,
						rightEY);
			
			myShape.top2Part.endYBA = this.intersectY(top2SXBA, top2SYBA, top2EXBA, top2EYBA, rightSXBA, rightSYBA, rightEXBA,
						rightEY);
			
			myShape.top2Part.endXA = this
						.intersectX(top2SXA, top2SYA, top2EXA, top2EYA, rightSXA, rightSYA, rightEXA, rightEY);
			
			myShape.top2Part.endYA = this
						.intersectY(top2SXA, top2SYA, top2EXA, top2EYA, rightSXA, rightSYA, rightEXA, rightEY);
			
			// /////////////////////////////////////////
			myShape.rightPart.endTypeRB = 1;
			
			myShape.rightPart.startXC = myShape.top2Part.endXC;
			myShape.rightPart.startX = myShape.top2Part.endX;
			myShape.rightPart.startYC = myShape.top2Part.endYC;
			myShape.rightPart.startY = myShape.top2Part.endY;
			myShape.rightPart.startXBA = myShape.top2Part.endXBA;
			myShape.rightPart.startYBA = myShape.top2Part.endYBA;
			myShape.rightPart.startXA = myShape.top2Part.endXA;
			myShape.rightPart.startYA = myShape.top2Part.endYA;
			
		}
		if (myShape.top2Part.endTypeLT == 2)
		{
			
			/* T2: C B BA A-A R: C */
			
			myShape.top2Part.endXC = this.intersectX(top2SXC, top2SYC, top2EXC, top2EYC, rightSXC, rightSYC, rightEXC,
						rightEYC);
			
			myShape.top2Part.endYC = this.intersectY(top2SXC, top2SYC, top2EXC, top2EYC, rightSXC, rightSYC, rightEXC,
						rightEYC);
			
			myShape.top2Part.endX = this.intersectX(top2SX, top2SY, top2EX, top2EY, rightSXC, rightSYC, rightEXC, rightEYC);
			
			myShape.top2Part.endY = this.intersectY(top2SX, top2SY, top2EX, top2EY, rightSXC, rightSYC, rightEXC, rightEYC);
			
			myShape.top2Part.endXBA = this.intersectX(top2SXBA, top2SYBA, top2EXBA, top2EYBA, rightSXC, rightSYC, rightEXC,
						rightEYC);
			
			myShape.top2Part.endYBA = this.intersectY(top2SXBA, top2SYBA, top2EXBA, top2EYBA, rightSXC, rightSYC, rightEXC,
						rightEYC);
			
			myShape.top2Part.endXA = this.intersectX(top2SXA, top2SYA, top2EXA, top2EYA, rightSXA, rightSYA, rightEXA,
						rightEYA);
			
			myShape.top2Part.endYA = this.intersectY(top2SXA, top2SYA, top2EXA, top2EYA, rightSXA, rightSYA, rightEXA,
						rightEYA);
			
			myShape.top2Part.stopAeX = this.intersectX(top2SXBA, top2SYBA, top2EXBA, top2EYBA, rightSXA, rightSYA, rightEXA,
						rightEYA);
			
			myShape.top2Part.stopAeY = this.intersectY(top2SXBA, top2SYBA, top2EXBA, top2EYBA, rightSXA, rightSYA, rightEXA,
						rightEYA);
			
			// ////////////////////////////////////////////
			
			myShape.rightPart.endTypeRB = 3;
			
			/* T2: BA R: C B BA A */
			
			myShape.rightPart.startXC = this.intersectX(top2SXBA, top2SYBA, top2EXBA, top2EYBA, rightSXC, rightSYC, rightEXC,
						rightEYC);
			
			myShape.rightPart.startYC = this.intersectY(top2SXBA, top2SYBA, top2EXBA, top2EYBA, rightSXC, rightSYC, rightEXC,
						rightEYC);
			
			myShape.rightPart.startX = this.intersectX(top2SXBA, top2SYBA, top2EXBA, top2EYBA, rightSX, rightSY, rightEX,
						rightEY);
			
			myShape.rightPart.startY = this.intersectY(top2SXBA, top2SYBA, top2EXBA, top2EYBA, rightSX, rightSY, rightEX,
						rightEY);
			
			myShape.rightPart.startXBA = this.intersectX(top2SXBA, top2SYBA, top2EXBA, top2EYBA, rightSXBA, rightSYBA,
						rightEXBA, rightEYBA);
			
			myShape.rightPart.startYBA = this.intersectY(top2SXBA, top2SYBA, top2EXBA, top2EYBA, rightSXBA, rightSYBA,
						rightEXBA, rightEYBA);
			
			myShape.rightPart.startXA = this.intersectX(top2SXBA, top2SYBA, top2EXBA, top2EYBA, rightSXA, rightSYA, rightEXA,
						rightEYA);
			
			myShape.rightPart.startYA = this.intersectY(top2SXBA, top2SYBA, top2EXBA, top2EYBA, rightSXA, rightSYA, rightEXA,
						rightEYA);
			
		}
		if (myShape.top2Part.endTypeLT == 3)
		{
			
			/* T2: C B BA A R: BA */
			
			myShape.top2Part.endXC = this.intersectX(top2SXC, top2SYC, top2EXC, top2EYC, rightSXBA, rightSYBA, rightEXBA,
						rightEYBA);
			
			myShape.top2Part.endYC = this.intersectY(top2SXC, top2SYC, top2EXC, top2EYC, rightSXBA, rightSYBA, rightEXBA,
						rightEYBA);
			
			myShape.top2Part.endX = this
						.intersectX(top2SX, top2SY, top2EX, top2EY, rightSXBA, rightSYBA, rightEXBA, rightEYBA);
			
			myShape.top2Part.endY = this
						.intersectY(top2SX, top2SY, top2EX, top2EY, rightSXBA, rightSYBA, rightEXBA, rightEYBA);
			
			myShape.top2Part.endXBA = this.intersectX(top2SXBA, top2SYBA, top2EXBA, top2EYBA, rightSXBA, rightSYBA, rightEXBA,
						rightEYBA);
			
			myShape.top2Part.endYBA = this.intersectY(top2SXBA, top2SYBA, top2EXBA, top2EYBA, rightSXBA, rightSYBA, rightEXBA,
						rightEYBA);
			
			myShape.top2Part.endXA = this.intersectX(top2SXA, top2SYA, top2EXA, top2EYA, rightSXBA, rightSYBA, rightEXBA,
						rightEYBA);
			
			myShape.top2Part.endYA = this.intersectY(top2SXA, top2SYA, top2EXA, top2EYA, rightSXBA, rightSYBA, rightEXBA,
						rightEYBA);
			
			// /////////////////////////////////////
			
			myShape.rightPart.endTypeRB = 2;
			
			/* T2: C R: C B BA A-A */
			
			myShape.rightPart.startXC = this.intersectX(top2SXC, top2SYC, top2EXC, top2EYC, rightSXC, rightSYC, rightEXC,
						rightEYC);
			
			myShape.rightPart.startYC = this.intersectY(top2SXC, top2SYC, top2EXC, top2EYC, rightSXC, rightSYC, rightEXC,
						rightEYC);
			
			myShape.rightPart.startX = this.intersectX(top2SXC, top2SYC, top2EXC, top2EYC, rightSX, rightSY, rightEX, rightEY);
			
			myShape.rightPart.startY = this.intersectY(top2SXC, top2SYC, top2EXC, top2EYC, rightSX, rightSY, rightEX, rightEY);
			
			myShape.rightPart.startXBA = this.intersectX(top2SXC, top2SYC, top2EXC, top2EYC, rightSXBA, rightSYBA, rightEXBA,
						rightEYBA);
			
			myShape.rightPart.startYBA = this.intersectY(top2SXC, top2SYC, top2EXC, top2EYC, rightSXBA, rightSYBA, rightEXBA,
						rightEYBA);
			
			// A-A
			
			myShape.rightPart.startXA = this.intersectX(top2SXA, top2SYA, top2EXA, top2EYA, rightSXA, rightSYA, rightEXA,
						rightEYA);
			
			myShape.rightPart.startYA = this.intersectY(top2SXA, top2SYA, top2EXA, top2EYA, rightSXA, rightSYA, rightEXA,
						rightEYA);
			
			myShape.rightPart.stopAsX = this.intersectX(top2SXA, top2SYA, top2EXA, top2EYA, rightSXBA, rightSYBA, rightEXBA,
						rightEYBA);
			myShape.rightPart.stopAsY = this.intersectY(top2SXA, top2SYA, top2EXA, top2EYA, rightSXBA, rightSYBA, rightEXBA,
						rightEYBA);
			
		}
		return myShape;
	}
	
	public ShapeObject noSidesTop3(final ShapeObject myShape)
	{
	
		if (myShape.noSidesTop == 3)
		{
			
			if (myShape.top1Part.endTypeLT == 1)
			{
				
				/* T1: C B BA A T3: C B BA A */
				
				myShape.top1Part.endXC = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, top3SXC, top3SYC, top3EXC,
							top3EYC);
				
				myShape.top1Part.endYC = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, top3SXC, top3SYC, top3EXC,
							top3EYC);
				
				myShape.top1Part.endX = this.intersectX(top1SX, top1SY, top1EX, top1EY, top3SX, top3SY, top3EX, top3EY);
				
				myShape.top1Part.endY = this.intersectY(top1SX, top1SY, top1EX, top1EY, top3SX, top3SY, top3EX, top3EY);
				
				myShape.top1Part.endXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top3SXBA, top3SYBA,
							top3EXBA, top3EYBA);
				
				myShape.top1Part.endYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top3SXBA, top3SYBA,
							top3EXBA, top3EYBA);
				
				myShape.top1Part.endXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, top3SXA, top3SYA, top3EXA,
							top3EYA);
				
				myShape.top1Part.endYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, top3SXA, top3SYA, top3EXA,
							top3EYA);
				
				myShape.top3Part.endTypeRB = 1;
				
				myShape.top3Part.startXC = myShape.top1Part.endXC;
				myShape.top3Part.startYC = myShape.top1Part.endYC;
				myShape.top3Part.startX = myShape.top1Part.endX;
				myShape.top3Part.startY = myShape.top1Part.endY;
				myShape.top3Part.startXBA = myShape.top1Part.endXBA;
				myShape.top3Part.startYBA = myShape.top1Part.endYBA;
				myShape.top3Part.startXA = myShape.top1Part.endXA;
				myShape.top3Part.startYA = myShape.top1Part.endYA;
				
			}
			if (myShape.top1Part.endTypeLT == 2)
			{
				
				/* T1: C B BA A-A T3: C */
				
				myShape.top1Part.endXC = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, top3SXC, top3SYC, top3EXC,
							top3EYC);
				
				myShape.top1Part.endYC = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, top3SXC, top3SYC, top3EXC,
							top3EYC);
				
				myShape.top1Part.endX = this.intersectX(top1SX, top1SY, top1EX, top1EY, top3SXC, top3SYC, top3EXC, top3EYC);
				
				myShape.top1Part.endY = this.intersectY(top1SX, top1SY, top1EX, top1EY, top3SXC, top3SYC, top3EXC, top3EYC);
				
				myShape.top1Part.endXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top3SXC, top3SYC, top3EXC,
							top3EYC);
				
				myShape.top1Part.endYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top3SXC, top3SYC, top3EXC,
							top3EYC);
				
				myShape.top1Part.endXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, top3SXA, top3SYA, top3EXA,
							top3EYA);
				
				myShape.top1Part.endYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, top3SXA, top3SYA, top3EXA,
							top3EYA);
				
				myShape.top1Part.stopAeX = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top3SXA, top3SYA, top3EXA,
							top3EYA);
				
				myShape.top1Part.stopAeY = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top3SXA, top3SYA, top3EXA,
							top3EYA);
				
				// ///////////////////////////////////
				
				myShape.top3Part.endTypeRB = 3;
				
				/* T1: BA T3: C B BA A */
				
				myShape.top3Part.startXC = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top3SXC, top3SYC, top3EXC,
							top3EYC);
				
				myShape.top3Part.startYC = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top3SXC, top3SYC, top3EXC,
							top3EYC);
				
				myShape.top3Part.startX = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top3SX, top3SY, top3EX,
							top3EY);
				
				myShape.top3Part.startY = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top3SX, top3SY, top3EX,
							top3EY);
				
				myShape.top3Part.startXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top3SXBA, top3SYBA,
							top3EXBA, top3EYBA);
				
				myShape.top3Part.startYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top3SXBA, top3SYBA,
							top3EXBA, top3EYBA);
				
				myShape.top3Part.startXA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top3SXA, top3SYA, top3EXA,
							top3EYA);
				
				myShape.top3Part.startYA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top3SXA, top3SYA, top3EXA,
							top3EYA);
				
			}
			// /////////
			if (myShape.top1Part.endTypeLT == 3)
			{
				
				/* T1: C B BA A T3:BA */
				
				myShape.top1Part.endXC = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, top3SXBA, top3SYBA, top3EXBA,
							top3EYBA);
				
				myShape.top1Part.endYC = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, top3SXBA, top3SYBA, top3EXBA,
							top3EYBA);
				
				myShape.top1Part.endX = this.intersectX(top1SX, top1SY, top1EX, top1EY, top3SXBA, top3SYBA, top3EXBA,
							top3EYBA);
				
				myShape.top1Part.endY = this.intersectY(top1SX, top1SY, top1EX, top1EY, top3SX, top3SY, top3EX, top3EY);
				
				myShape.top1Part.endXBA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top3SXBA, top3SYBA,
							top3EXBA, top3EYBA);
				
				myShape.top1Part.endYBA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top3SXBA, top3SYBA,
							top3EXBA, top3EYBA);
				
				myShape.top1Part.endXA = this.intersectX(top1SXA, top1SYA, top1EXA, top1EYA, top3SXBA, top3SYBA, top3EXBA,
							top3EYBA);
				
				myShape.top1Part.endYA = this.intersectY(top1SXA, top1SYA, top1EXA, top1EYA, top3SXBA, top3SYBA, top3EXBA,
							top3EYBA);
				
				// //////////////////////////////////////////
				
				myShape.top3Part.endTypeRB = 2;
				
				/* T1: C T3:C B BA A-A */
				
				myShape.top3Part.startXC = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, top3SXC, top3SYC, top3EXC,
							top3EYC);
				
				myShape.top3Part.startYC = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, top3SXC, top3SYC, top3EXC,
							top3EYC);
				
				myShape.top3Part.startX = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, top3SX, top3SY, top3EX, top3EY);
				
				myShape.top3Part.startY = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, top3SX, top3SY, top3EX, top3EY);
				
				myShape.top3Part.startXBA = this.intersectX(top1SXC, top1SYC, top1EXC, top1EYC, top3SXBA, top3SYBA, top3EXBA,
							top3EYBA);
				
				myShape.top3Part.startYBA = this.intersectY(top1SXC, top1SYC, top1EXC, top1EYC, top3SXBA, top3SYBA, top3EXBA,
							top3EYBA);
				
				myShape.top3Part.startXA = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top3SXA, top3SYA, top3EXA,
							top3EYA);
				
				myShape.top3Part.startYA = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top3SXA, top3SYA, top3EXA,
							top3EYA);
				
				myShape.top3Part.stopAsX = this.intersectX(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top3SXBA, top3SYBA,
							top3EXBA, top3EYBA);
				
				myShape.top3Part.stopAsY = this.intersectY(top1SXBA, top1SYBA, top1EXBA, top1EYBA, top3SXBA, top3SYBA,
							top3EXBA, top3EYBA);
				
			}
			if (myShape.top2Part.endTypeRB == 1)
			{
				
				/* T2: C B BA A T3: C B BA A */
				
				myShape.top2Part.startXC = this.intersectX(top2SXC, top2SYC, top2EXC, top2EYC, top3SXC, top3SYC, top3EXC,
							top3EYC);
				
				myShape.top2Part.startYC = this.intersectY(top2SXC, top2SYC, top2EXC, top2EYC, top3SXC, top3SYC, top3EXC,
							top3EYC);
				
				myShape.top2Part.startX = this.intersectX(top2SX, top2SY, top2EX, top2EY, top3SX, top3SY, top3EX, top3EY);
				
				myShape.top2Part.startY = this.intersectY(top2SX, top2SY, top2EX, top2EY, top3SX, top3SY, top3EX, top3EY);
				
				myShape.top2Part.startXBA = this.intersectX(top2SXBA, top2SYBA, top2EXBA, top2EYBA, top3SXBA, top3SYBA,
							top3EXBA, top3EYBA);
				
				myShape.top2Part.startYBA = this.intersectY(top2SXBA, top2SYBA, top2EXBA, top2EYBA, top3SXBA, top3SYBA,
							top3EXBA, top3EYBA);
				
				myShape.top2Part.startXA = this.intersectX(top2SXA, top2SYA, top2EXA, top2EYA, top3SXA, top3SYA, top3EXA,
							top3EYA);
				
				myShape.top2Part.startYA = this.intersectY(top2SXA, top2SYA, top2EXA, top2EYA, top3SXA, top3SYA, top3EXA,
							top3EYA);
				
				myShape.top3Part.endTypeLT = 1;
				
				myShape.top3Part.endXC = myShape.top2Part.startXC;
				myShape.top3Part.endYC = myShape.top2Part.startYC;
				myShape.top3Part.endX = myShape.top2Part.startX;
				myShape.top3Part.endY = myShape.top2Part.startY;
				
				myShape.top3Part.endXBA = myShape.top2Part.startXBA;
				myShape.top3Part.endYBA = myShape.top2Part.startYBA;
				myShape.top3Part.endXA = myShape.top2Part.startXA;
				myShape.top3Part.endYA = myShape.top2Part.startYA;
				
			}
			if (myShape.top2Part.endTypeRB == 2)
			{
				
				/* T2: C B BA A-A T3: C */
				
				myShape.top2Part.startXC = this.intersectX(top2SXC, top2SYC, top2EXC, top2EYC, top3SXC, top3SYC, top3EXC,
							top3EYC);
				
				myShape.top2Part.startYC = this.intersectY(top2SXC, top2SYC, top2EXC, top2EYC, top3SXC, top3SYC, top3EXC,
							top3EYC);
				
				myShape.top2Part.startX = this.intersectX(top2SX, top2SY, top2EX, top2EY, top3SXC, top3SYC, top3EXC, top3EYC);
				
				myShape.top2Part.startY = this.intersectY(top2SX, top2SY, top2EX, top2EY, top3SXC, top3SYC, top3EXC, top3EYC);
				
				myShape.top2Part.startXBA = this.intersectX(top2SXBA, top2SYBA, top2EXBA, top2EYBA, top3SXC, top3SYC,
							top3EXC, top3EYC);
				
				myShape.top2Part.startYBA = this.intersectY(top2SXBA, top2SYBA, top2EXBA, top2EYBA, top3SXC, top3SYC,
							top3EXC, top3EYC);
				
				myShape.top2Part.startXA = this.intersectX(top2SXA, top2SYA, top2EXA, top2EYA, top3SXA, top3SYA, top3EXA,
							top3EYA);
				
				myShape.top2Part.startYA = this.intersectY(top2SXA, top2SYA, top2EXA, top2EYA, top3SXA, top3SYA, top3EXA,
							top3EYA);
				
				myShape.top2Part.stopAsX = this.intersectX(top2SXBA, top2SYBA, top2EXBA, top2EYBA, top3SXA, top3SYA, top3EXA,
							top3EYA);
				
				myShape.top2Part.stopAsY = this.intersectY(top2SXBA, top2SYBA, top2EXBA, top2EYBA, top3SXA, top3SYA, top3EXA,
							top3EYA);
				
				// //////////////////////////////////////
				
				myShape.top3Part.endTypeLT = 3;
				
				/* T2: BA T3: C B BA A */
				
				myShape.top3Part.endXC = this.intersectX(top2SXBA, top2SYBA, top2EXBA, top2EYBA, top3SXC, top3SYC, top3EXC,
							top3EYC);
				
				myShape.top3Part.endYC = this.intersectY(top2SXBA, top2SYBA, top2EXBA, top2EYBA, top3SXC, top3SYC, top3EXC,
							top3EYC);
				
				myShape.top3Part.endX = this.intersectX(top2SXBA, top2SYBA, top2EXBA, top2EYBA, top3SX, top3SY, top3EX,
							top3EY);
				
				myShape.top3Part.endY = this.intersectY(top2SX, top2SY, top2EX, top2EY, top3SX, top3SY, top3EX, top3EY);
				
				myShape.top3Part.endXBA = this.intersectX(top2SXBA, top2SYBA, top2EXBA, top2EYBA, top3SXBA, top3SYBA,
							top3EXBA, top3EYBA);
				
				myShape.top3Part.endYBA = this.intersectY(top2SXBA, top2SYBA, top2EXBA, top2EYBA, top3SXBA, top3SYBA,
							top3EXBA, top3EYBA);
				
				myShape.top3Part.endXA = this.intersectX(top2SXBA, top2SYBA, top2EXBA, top2EYBA, top3SXA, top3SYA, top3EXA,
							top3EYA);
				
				myShape.top3Part.endYA = this.intersectY(top2SXBA, top2SYBA, top2EXBA, top2EYBA, top3SXA, top3SYA, top3EXA,
							top3EYA);
				
			}
			// ////////
			
			if (myShape.top2Part.endTypeRB == 3)
			{
				
				/* T2: C B BA A T3: BA */
				
				myShape.top2Part.startXC = this.intersectX(top2SXC, top2SYC, top2EXC, top2EYC, top3SXBA, top3SYBA, top3EXBA,
							top3EYBA);
				
				myShape.top2Part.startYC = this.intersectY(top2SXC, top2SYC, top2EXC, top2EYC, top3SXBA, top3SYBA, top3EXBA,
							top3EYBA);
				
				myShape.top2Part.startX = this.intersectX(top2SX, top2SY, top2EX, top2EY, top3SXBA, top3SYBA, top3EXBA,
							top3EYBA);
				
				myShape.top2Part.startY = this.intersectY(top2SX, top2SY, top2EX, top2EY, top3SXBA, top3SYBA, top3EXBA,
							top3EYBA);
				
				myShape.top2Part.startXBA = this.intersectX(top2SXBA, top2SYBA, top2EXBA, top2EYBA, top3SXBA, top3SYBA,
							top3EXBA, top3EYBA);
				
				myShape.top2Part.startYBA = this.intersectY(top2SXBA, top2SYBA, top2EXBA, top2EYBA, top3SXBA, top3SYBA,
							top3EXBA, top3EYBA);
				
				myShape.top2Part.startXA = this.intersectX(top2SXA, top2SYA, top2EXA, top2EYA, top3SXBA, top3SYBA, top3EXBA,
							top3EYBA);
				
				myShape.top2Part.startYA = this.intersectY(top2SXA, top2SYA, top2EXA, top2EYA, top3SXBA, top3SYBA, top3EXBA,
							top3EYBA);
				
				// ////////////////////////////////////
				
				myShape.top3Part.endTypeLT = 2;
				
				/* T2: C T3: C B BA A-A */
				
				myShape.top3Part.endXC = this.intersectX(top2SXC, top2SYC, top2EXC, top2EYC, top3SXC, top3SYC, top3EXC,
							top3EYC);
				
				myShape.top3Part.endYC = this.intersectY(top2SXC, top2SYC, top2EXC, top2EYC, top3SXC, top3SYC, top3EXC,
							top3EYC);
				
				myShape.top3Part.endX = this.intersectX(top2SXC, top2SYC, top2EXC, top2EYC, top3SX, top3SY, top3EX, top3EY);
				
				myShape.top3Part.endY = this.intersectY(top2SXC, top2SYC, top2EXC, top2EYC, top3SX, top3SY, top3EX, top3EY);
				
				myShape.top3Part.endXBA = this.intersectX(top2SXC, top2SYC, top2EXC, top2EYC, top3SXBA, top3SYBA, top3EXBA,
							top3EYBA);
				
				myShape.top3Part.endYBA = this.intersectY(top2SXC, top2SYC, top2EXC, top2EYC, top3SXBA, top3SYBA, top3EXBA,
							top3EYBA);
				
				myShape.top3Part.endXA = this.intersectX(top2SXA, top2SYA, top2EXA, top2EYA, top3SXA, top3SYA, top3EXA,
							top3EYA);
				
				myShape.top3Part.endYA = this.intersectY(top2SXA, top2SYA, top2EXA, top2EYA, top3SXA, top3SYA, top3EXA,
							top3EYA);
				
				myShape.top3Part.stopAeX = this.intersectX(top2SXA, top2SYA, top2EXA, top2EYA, top3SXBA, top3SYBA, top3EXBA,
							top3EYBA);
				
				myShape.top3Part.stopAeY = this.intersectY(top2SXA, top2SYA, top2EXA, top2EYA, top3SXBA, top3SYBA, top3EXBA,
							top3EYBA);
				
			}
			
			if (myShape.noSidesRight > 0)
			{
				this.top2Right(myShape);
			}
			else if (myShape.noSidesBot <= 3)
			{
				this.top2Bot1(myShape);
			}
			// else if (myShape.noSidesBot == 3) {
			// this.top2Bot3(myShape);
			// }
			
		}
		return myShape;
	}
	
	public void noSidesBot2(final ShapeObject myShape)
	{
	
		if (myShape.noSidesBot == 2)
		{
			if (myShape.bot2Part.endTypeRB == 1)
			{
				
				myShape.bot1Part.endTypeLT = 1;
				/* B2: C B BA A B1: C B BA A */
				
				myShape.bot2Part.startXC = myShape.bot1Part.endXC = this.intersectX(bot2SXC, bot2SYC, bot2EXC, bot2EYC,
							bot1SXC, bot1SYC, bot1EXC, bot1EYC);
				
				myShape.bot2Part.startYC = myShape.bot1Part.endYC = this.intersectY(bot2SXC, bot2SYC, bot2EXC, bot2EYC,
							bot1SXC, bot1SYC, bot1EXC, bot1EYC);
				
				myShape.bot2Part.startX = myShape.bot1Part.endX = this.intersectX(bot2SX, bot2SY, bot2EX, bot2EY, bot1SX,
							bot1SY, bot1EX, bot1EY);
				
				myShape.bot2Part.startY = myShape.bot1Part.endY = this.intersectY(bot2SX, bot2SY, bot2EX, bot2EY, bot1SX,
							bot1SY, bot1EX, bot1EY);
				
				myShape.bot2Part.startXBA = myShape.bot1Part.endXBA = this.intersectX(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA,
							bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA);
				
				myShape.bot2Part.startYBA = myShape.bot1Part.endYBA = this.intersectY(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA,
							bot1SXBA, bot1SYBA, bot1EXBA, bot1EYBA);
				
				myShape.bot2Part.startXA = myShape.bot1Part.endXA = this.intersectX(bot2SXA, bot2SYA, bot2EXA, bot2EYA,
							bot1SXA, bot1SYA, bot1EXA, bot1EYA);
				
				myShape.bot2Part.startYA = myShape.bot1Part.endYA = this.intersectY(bot2SXA, bot2SYA, bot2EXA, bot2EYA,
							bot1SXA, bot1SYA, bot1EXA, bot1EYA);
				
			}
			if (myShape.bot2Part.endTypeRB == 2)
			{
				
				/* B2: C B BA A-A B1: C */
				
				myShape.bot2Part.startXC = this.intersectX(bot2SXC, bot2SYC, bot2EXC, bot2EYC, bot1SXC, bot1SYC, bot1EXC,
							bot1EYC);
				
				myShape.bot2Part.startYC = this.intersectY(bot2SXC, bot2SYC, bot2EXC, bot2EYC, bot1SXC, bot1SYC, bot1EXC,
							bot1EYC);
				
				myShape.bot2Part.startX = this.intersectX(bot2SX, bot2SY, bot2EX, bot2EY, bot1SXC, bot1SYC, bot1EXC, bot1EYC);
				
				myShape.bot2Part.startY = this.intersectY(bot2SX, bot2SY, bot2EX, bot2EY, bot1SXC, bot1SYC, bot1EXC, bot1EYC);
				
				myShape.bot2Part.startXBA = this.intersectX(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, bot1SXC, bot1SYC,
							bot1EXC, bot1EYC);
				
				myShape.bot2Part.startYBA = this.intersectY(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, bot1SXC, bot1SYC,
							bot1EXC, bot1EYC);
				
				myShape.bot2Part.startXA = this.intersectX(bot2SXA, bot2SYA, bot2EXA, bot2EYA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
				myShape.bot2Part.startYA = this.intersectY(bot2SXA, bot2SYA, bot2EXA, bot2EYA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
				myShape.bot2Part.stopAsX = this.intersectX(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
				myShape.bot2Part.stopAsY = this.intersectY(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
				// ///////////////////////////////////
				
				myShape.bot1Part.endTypeLT = 3;
				
				/* B2: BA B1: C B BA A */
				
				myShape.bot1Part.endXC = this.intersectX(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, bot1SXC, bot1SYC, bot1EXC,
							bot1EYC);
				
				myShape.bot1Part.endYC = this.intersectY(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, bot1SXC, bot1SYC, bot1EXC,
							bot1EYC);
				
				myShape.bot1Part.endX = this.intersectX(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, bot1SX, bot1SY, bot1EX,
							bot1EY);
				
				myShape.bot1Part.endY = this.intersectY(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, bot1SX, bot1SY, bot1EX,
							bot1EY);
				
				myShape.bot1Part.endXBA = this.intersectX(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, bot1SXBA, bot1SYBA,
							bot1EXBA, bot1EYBA);
				
				myShape.bot1Part.endYBA = this.intersectY(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, bot1SXBA, bot1SYBA,
							bot1EXBA, bot1EYBA);
				
				myShape.bot1Part.endXA = this.intersectX(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
				myShape.bot1Part.endYA = this.intersectY(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
			}
			if (myShape.bot2Part.endTypeRB == 3)
			{
				
				/* B2: C B BA A B1: BA */
				
				myShape.bot2Part.startXC = this.intersectX(bot2SXC, bot2SYC, bot2EXC, bot2EYC, bot1SXBA, bot1SYBA, bot1EXBA,
							bot1EYBA);
				
				myShape.bot2Part.startYC = this.intersectY(bot2SXC, bot2SYC, bot2EXC, bot2EYC, bot1SXBA, bot1SYBA, bot1EXBA,
							bot1EYBA);
				
				myShape.bot2Part.startX = this.intersectX(bot2SX, bot2SY, bot2EX, bot2EY, bot1SXBA, bot1SYBA, bot1EXBA,
							bot1EYBA);
				
				myShape.bot2Part.startY = this.intersectY(bot2SX, bot2SY, bot2EX, bot2EY, bot1SXBA, bot1SYBA, bot1EXBA,
							bot1EYBA);
				
				myShape.bot2Part.startXBA = this.intersectX(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, bot1SXBA, bot1SYBA,
							bot1EXBA, bot1EYBA);
				
				myShape.bot2Part.startYBA = this.intersectY(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, bot1SXBA, bot1SYBA,
							bot1EXBA, bot1EYBA);
				
				myShape.bot2Part.startXA = this.intersectX(bot2SXA, bot2SYA, bot2EXA, bot2EYA, bot1SXBA, bot1SYBA, bot1EXBA,
							bot1EYBA);
				
				myShape.bot2Part.startYA = this.intersectY(bot2SXA, bot2SYA, bot2EXA, bot2EYA, bot1SXBA, bot1SYBA, bot1EXBA,
							bot1EYBA);
				
				// /////////////////////////////////////
				
				myShape.bot1Part.endTypeLT = 2;
				
				/* B2: C B1: C B BA A-A */
				
				myShape.bot1Part.endXC = this.intersectX(bot2SXC, bot2SYC, bot2EXC, bot2EYC, bot1SXC, bot1SYC, bot1EXC,
							bot1EYC);
				
				myShape.bot1Part.endYC = this.intersectY(bot2SXC, bot2SYC, bot2EXC, bot2EYC, bot1SXC, bot1SYC, bot1EXC,
							bot1EYC);
				
				myShape.bot1Part.endX = this.intersectX(bot2SXC, bot2SYC, bot2EXC, bot2EYC, bot1SX, bot1SY, bot1EX, bot1EY);
				
				myShape.bot1Part.endY = this.intersectY(bot2SXC, bot2SYC, bot2EXC, bot2EYC, bot1SX, bot1SY, bot1EX, bot1EY);
				
				myShape.bot1Part.endXBA = this.intersectX(bot2SXC, bot2SYC, bot2EXC, bot2EYC, bot1SXBA, bot1SYBA, bot1EXBA,
							bot1EYBA);
				
				myShape.bot1Part.endYBA = this.intersectY(bot2SXC, bot2SYC, bot2EXC, bot2EYC, bot1SXBA, bot1SYBA, bot1EXBA,
							bot1EYBA);
				
				myShape.bot1Part.endXA = this.intersectX(bot2SXA, bot2SYA, bot2EXA, bot2EYA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
				myShape.bot1Part.endYA = this.intersectY(bot2SXA, bot2SYA, bot2EXA, bot2EYA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
				myShape.bot1Part.stopAeX = this.intersectX(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
				myShape.bot1Part.stopAeY = this.intersectY(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
			}
			
			if (myShape.bot2Part.endTypeLT == 1)
			{
				
				myShape.leftPart.endTypeRB = 1;
				
				/* B2: C B BA A L: C B BA A */
				
				myShape.bot2Part.endXC = myShape.leftPart.startXC = this.intersectX(bot2SXC, bot2SYC, bot2EXC, bot2EYC,
							leftSXC, leftSYC, leftEXC, leftEYC);
				
				myShape.bot2Part.endYC = myShape.leftPart.startYC = this.intersectY(bot2SXC, bot2SYC, bot2EXC, bot2EYC,
							leftSXC, leftSYC, leftEXC, leftEYC);
				
				myShape.bot2Part.endX = myShape.leftPart.startX = this.intersectX(bot2SX, bot2SY, bot2EX, bot2EY, leftSX,
							leftSY, leftEX, leftEY);
				
				myShape.bot2Part.endY = myShape.leftPart.startY = this.intersectY(bot2SX, bot2SY, bot2EX, bot2EY, leftSX,
							leftSY, leftEX, leftEY);
				
				myShape.bot2Part.endXBA = myShape.leftPart.startXBA = this.intersectX(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA,
							leftSXBA, leftSYBA, leftEXBA, leftEYBA);
				
				myShape.bot2Part.endYBA = myShape.leftPart.startYBA = this.intersectY(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA,
							leftSXBA, leftSYBA, leftEXBA, leftEYBA);
				
				myShape.bot2Part.endXA = myShape.leftPart.startXA = this.intersectX(bot2SXA, bot2SYA, bot2EXA, bot2EYA,
							leftSXA, leftSYA, leftEXA, leftEYA);
				
				myShape.bot2Part.endYA = myShape.leftPart.startYA = this.intersectY(bot2SXA, bot2SYA, bot2EXA, bot2EYA,
							leftSXA, leftSYA, leftEXA, leftEYA);
				
			}
			if (myShape.bot2Part.endTypeLT == 2)
			{
				
				/* B2: C B BA A-A L: C */
				
				myShape.bot2Part.endXC = this.intersectX(bot2SXC, bot2SYC, bot2EXC, bot2EYC, leftSXC, leftSYC, leftEXC,
							leftEYC);
				
				myShape.bot2Part.endYC = this.intersectY(bot2SXC, bot2SYC, bot2EXC, bot2EYC, leftSXC, leftSYC, leftEXC,
							leftEYC);
				
				myShape.bot2Part.endX = this.intersectX(bot2SX, bot2SY, bot2EX, bot2EY, leftSXC, leftSYC, leftEXC, leftEYC);
				
				myShape.bot2Part.endY = this.intersectY(bot2SX, bot2SY, bot2EX, bot2EY, leftSXC, leftSYC, leftEXC, leftEYC);
				
				myShape.bot2Part.endXBA = this.intersectX(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSXC, leftSYC, leftEXC,
							leftEYC);
				
				myShape.bot2Part.endYBA = this.intersectY(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSXC, leftSYC, leftEXC,
							leftEYC);
				
				// A-A
				
				myShape.bot2Part.endXA = this.intersectX(bot2SXA, bot2SYA, bot2EXA, bot2EYA, leftSXA, leftSYA, leftEXA,
							leftEYA);
				
				myShape.bot2Part.endYA = this.intersectY(bot2SXA, bot2SYA, bot2EXA, bot2EYA, leftSXA, leftSYA, leftEXA,
							leftEYA);
				
				myShape.bot2Part.stopAeX = this.intersectX(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSXA, leftSYA, leftEXA,
							leftEYA);
				
				myShape.bot2Part.stopAeY = this.intersectY(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSXA, leftSYA, leftEXA,
							leftEYA);
				
				// ////////////////////////////////////
				
				myShape.leftPart.endTypeRB = 3;
				
				/* B2:BA L: C B BA A */
				
				myShape.leftPart.startXC = this.intersectX(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSXC, leftSYC, leftEXC,
							leftEYC);
				
				myShape.bot2Part.startYC = this.intersectY(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSXC, leftSYC, leftEXC,
							leftEYC);
				
				myShape.leftPart.startX = this.intersectX(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSX, leftSY, leftEX,
							leftEY);
				
				myShape.bot2Part.startY = this.intersectY(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSX, leftSY, leftEX,
							leftEY);
				
				myShape.bot2Part.startXBA = this.intersectX(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSXBA, leftSYBA,
							leftEXBA, leftEYBA);
				
				myShape.bot2Part.startYBA = this.intersectY(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSXBA, leftSYBA,
							leftEXBA, leftEYBA);
				
				myShape.bot2Part.startXA = this.intersectX(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSXA, leftSYA, leftEXA,
							leftEYA);
				
				myShape.bot2Part.startYA = this.intersectY(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSXA, leftSYA, leftEXA,
							leftEYA);
				// //////
				
				// ////
				
			}
			if (myShape.bot2Part.endTypeLT == 3)
			{
				
				/* B2:C B BA A L: BA */
				
				myShape.bot2Part.endXC = this.intersectX(bot2SXC, bot2SYC, bot2EXC, bot2EYC, leftSXBA, leftSYBA, leftEXBA,
							leftEYBA);
				
				myShape.bot2Part.endYC = this.intersectY(bot2SXC, bot2SYC, bot2EXC, bot2EYC, leftSXBA, leftSYBA, leftEXBA,
							leftEYBA);
				
				myShape.bot2Part.endX = this.intersectX(bot2SX, bot2SY, bot2EX, bot2EY, leftSXBA, leftSYBA, leftEXBA,
							leftEYBA);
				
				myShape.bot2Part.endY = this.intersectY(bot2SX, bot2SY, bot2EX, bot2EY, leftSXBA, leftSYBA, leftEXBA,
							leftEYBA);
				
				myShape.bot2Part.endXBA = this.intersectX(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSXBA, leftSYBA,
							leftEXBA, leftEYBA);
				
				myShape.bot2Part.endYBA = this.intersectY(bot2SXBA, bot2SYBA, bot2EXBA, bot2EYBA, leftSXBA, leftSYBA,
							leftEXBA, leftEYBA);
				
				myShape.bot2Part.endXA = this.intersectX(bot2SXA, bot2SYA, bot2EXA, bot2EYA, leftSXBA, leftSYBA, leftEXBA,
							leftEYBA);
				
				myShape.bot2Part.endYA = this.intersectY(bot2SXA, bot2SYA, bot2EXA, bot2EYA, leftSXBA, leftSYBA, leftEXBA,
							leftEYBA);
				
				// //////////////////////////////////////
				
				myShape.leftPart.endTypeRB = 2;
				
				/* B2: C L: C B BA A-A */
				
				myShape.bot2Part.startXC = this.intersectX(bot2SXC, bot2SYC, bot2EXC, bot2EYC, leftSXC, leftSYC, leftEXC,
							leftEYC);
				
				myShape.bot2Part.startYC = this.intersectY(bot2SXC, bot2SYC, bot2EXC, bot2EYC, leftSXC, leftSYC, leftEXC,
							leftEYC);
				
				myShape.bot2Part.startX = this.intersectX(bot2SXC, bot2SYC, bot2EXC, bot2EYC, leftSX, leftSY, leftEX, leftEY);
				
				myShape.bot2Part.startY = this.intersectY(bot2SXC, bot2SYC, bot2EXC, bot2EYC, leftSX, leftSY, leftEX, leftEY);
				
				myShape.bot2Part.startXBA = this.intersectX(bot2SXC, bot2SYC, bot2EXC, bot2EYC, leftSXBA, leftSYBA, leftEXBA,
							leftEYBA);
				
				myShape.bot2Part.startYBA = this.intersectY(bot2SXC, bot2SYC, bot2EXC, bot2EYC, leftSXBA, leftSYBA, leftEXBA,
							leftEYBA);
				
				myShape.bot2Part.startXA = this.intersectX(bot2SXA, bot2SYA, bot2EXA, bot2EYA, leftSXA, leftSYA, leftEXA,
							leftEYA);
				
				myShape.bot2Part.startYA = this.intersectY(bot2SXA, bot2SYA, bot2EXA, bot2EYA, leftSXA, leftSYA, leftEXA,
							leftEYA);
				
				myShape.bot2Part.stopAsX = this.intersectX(bot2SXA, bot2SYA, bot2EXA, bot2EYA, leftSXBA, leftSYBA, leftEXBA,
							leftEYBA);
				
				myShape.bot2Part.stopAsY = this.intersectY(bot2SXA, bot2SYA, bot2EXA, bot2EYA, leftSXBA, leftSYBA, leftEXBA,
							leftEYBA);
				
			}
		}
	}
	
	public void noSidesBot3(final ShapeObject myShape)
	{
	
		if (myShape.noSidesBot == 3)
		{
			if (myShape.bot3Part.endTypeRB == 1)
			{
				
				/* B3: C B BA A B1: C B BA A */
				
				myShape.bot1Part.endTypeLT = 1;
				
				myShape.bot3Part.startXC = this.intersectX(bot3SXC, bot3SYC, bot3EXC, bot3EYC, bot1SXC, bot1SYC, bot1EXC,
							bot1EYC);
				
				myShape.bot3Part.startYC = this.intersectY(bot3SXC, bot3SYC, bot3EXC, bot3EYC, bot1SXC, bot1SYC, bot1EXC,
							bot1EYC);
				
				myShape.bot3Part.startX = this.intersectX(bot3SX, bot3SY, bot3EX, bot3EY, bot1SX, bot1SY, bot1EX, bot1EY);
				
				myShape.bot3Part.startY = this.intersectY(bot3SX, bot3SY, bot3EX, bot3EY, bot1SX, bot1SY, bot1EX, bot1EY);
				
				myShape.bot3Part.startXBA = this.intersectX(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot1SXBA, bot1SYBA,
							bot1EXBA, bot1EYBA);
				
				myShape.bot3Part.startYBA = this.intersectY(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot1SXBA, bot1SYBA,
							bot1EXBA, bot1EYBA);
				
				myShape.bot3Part.startXA = this.intersectX(bot3SXA, bot3SYA, bot3EXA, bot3EYA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
				myShape.bot3Part.startYA = this.intersectY(bot3SXA, bot3SYA, bot3EXA, bot3EYA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
				myShape.bot1Part.endXC = myShape.bot3Part.startXC;
				myShape.bot1Part.endYC = myShape.bot3Part.startYC;
				
				myShape.bot1Part.endX = myShape.bot3Part.startX;
				myShape.bot1Part.endY = myShape.bot3Part.startY;
				
				myShape.bot1Part.endXBA = myShape.bot3Part.startXBA;
				myShape.bot1Part.endYBA = myShape.bot3Part.startYBA;
				myShape.bot1Part.endXA = myShape.bot3Part.startXA;
				myShape.bot1Part.endYA = myShape.bot3Part.startYA;
				
			}
			if (myShape.bot3Part.endTypeRB == 2)
			{
				
				/* B3: C B BA A-A B1: C */
				
				myShape.bot3Part.startXC = this.intersectX(bot3SXC, bot3SYC, bot3EXC, bot3EYC, bot1SXC, bot1SYC, bot1EXC,
							bot1EYC);
				
				myShape.bot3Part.startYC = this.intersectY(bot3SXC, bot3SYC, bot3EXC, bot3EYC, bot1SXC, bot1SYC, bot1EXC,
							bot1EYC);
				
				myShape.bot3Part.startX = this.intersectX(bot3SX, bot3SY, bot3EX, bot3EY, bot1SXC, bot1SYC, bot1EXC, bot1EYC);
				
				myShape.bot3Part.startY = this.intersectY(bot3SX, bot3SY, bot3EX, bot3EY, bot1SXC, bot1SYC, bot1EXC, bot1EYC);
				
				myShape.bot3Part.startXBA = this.intersectX(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot1SXC, bot1SYC,
							bot1EXC, bot1EYC);
				
				myShape.bot3Part.startYBA = this.intersectY(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot1SXC, bot1SYC,
							bot1EXC, bot1EYC);
				
				myShape.bot3Part.startXA = this.intersectX(bot3SXA, bot3SYA, bot3EXA, bot3EYA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
				myShape.bot3Part.startYA = this.intersectY(bot3SXA, bot3SYA, bot3EXA, bot3EYA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
				myShape.bot3Part.stopAsX = this.intersectX(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
				myShape.bot3Part.stopAsY = this.intersectY(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
				// /////////////////////////////////////
				
				myShape.bot1Part.endTypeLT = 3;
				
				/* B3: BA B1: C B BA A */
				
				myShape.bot1Part.endXC = this.intersectX(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot1SX, bot1SY, bot1EX,
							bot1EY);
				
				myShape.bot1Part.endYC = this.intersectY(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot1SX, bot1SY, bot1EX,
							bot1EY);
				
				myShape.bot1Part.endX = this.intersectX(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot1SX, bot1SY, bot1EX,
							bot1EY);
				
				myShape.bot1Part.endY = this.intersectY(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot1SX, bot1SY, bot1EX,
							bot1EY);
				
				myShape.bot1Part.endXBA = this.intersectX(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot1SXBA, bot1SYBA,
							bot1EXBA, bot1EYBA);
				
				myShape.bot1Part.endYBA = this.intersectY(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot1SXBA, bot1SYBA,
							bot1EXBA, bot1EYBA);
				
				myShape.bot1Part.endXA = this.intersectX(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
				myShape.bot1Part.endYA = this.intersectY(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
				// ////
				
			}
			if (myShape.bot3Part.endTypeRB == 3)
			{
				
				/* B3: C B BA A B1: BA */
				
				myShape.bot3Part.startXC = this.intersectX(bot3SXC, bot3SYC, bot3EXC, bot3EYC, bot1SXBA, bot1SYBA, bot1EXBA,
							bot1EYBA);
				
				myShape.bot3Part.startYC = this.intersectY(bot3SXC, bot3SYC, bot3EXC, bot3EYC, bot1SXBA, bot1SYBA, bot1EXBA,
							bot1EYBA);
				
				myShape.bot3Part.startX = this.intersectX(bot3SX, bot3SY, bot3EX, bot3EY, bot1SXBA, bot1SYBA, bot1EXBA,
							bot1EYBA);
				
				myShape.bot3Part.startY = this.intersectY(bot3SX, bot3SY, bot3EX, bot3EY, bot1SXBA, bot1SYBA, bot1EXBA,
							bot1EYBA);
				
				myShape.bot3Part.startXBA = this.intersectX(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot1SXBA, bot1SYBA,
							bot1EXBA, bot1EYBA);
				
				myShape.bot3Part.startYBA = this.intersectY(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot1SXBA, bot1SYBA,
							bot1EXBA, bot1EYBA);
				
				myShape.bot3Part.startXA = this.intersectX(bot3SXA, bot3SYA, bot3EXA, bot3EYA, bot1SXBA, bot1SYBA, bot1EXBA,
							bot1EYBA);
				
				myShape.bot3Part.startYA = this.intersectY(bot3SXA, bot3SYA, bot3EXA, bot3EYA, bot1SXBA, bot1SYBA, bot1EXBA,
							bot1EYBA);
				
				// ///////////////////////////////////////
				
				myShape.bot1Part.endTypeLT = 2;
				
				/* B3: C B1: C B BA A-A */
				
				myShape.bot1Part.endXC = this.intersectX(bot3SXC, bot3SYC, bot3EXC, bot3EYC, bot1SXC, bot1SYC, bot1EXC,
							bot1EYC);
				
				myShape.bot1Part.endYC = this.intersectY(bot3SXC, bot3SYC, bot3EXC, bot3EYC, bot1SXC, bot1SYC, bot1EXC,
							bot1EYC);
				
				myShape.bot1Part.endX = this.intersectX(bot3SXC, bot3SYC, bot3EXC, bot3EYC, bot1SX, bot1SY, bot1EX, bot1EY);
				
				myShape.bot1Part.endY = this.intersectY(bot3SXC, bot3SYC, bot3EXC, bot3EYC, bot1SX, bot1SY, bot1EX, bot1EY);
				
				myShape.bot1Part.endXBA = this.intersectX(bot3SXC, bot3SYC, bot3EXC, bot3EYC, bot1SXBA, bot1SYBA, bot1EXBA,
							bot1EYBA);
				
				myShape.bot1Part.endYBA = this.intersectY(bot3SXC, bot3SYC, bot3EXC, bot3EYC, bot1SXBA, bot1SYBA, bot1EXBA,
							bot1EYBA);
				
				myShape.bot1Part.endXA = this.intersectX(bot3SXA, bot3SYA, bot3EXA, bot3EYA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
				myShape.bot1Part.endYA = this.intersectY(bot3SXA, bot3SYA, bot3EXA, bot3EYA, bot1SXA, bot1SYA, bot1EXA,
							bot1EYA);
				
				myShape.bot1Part.stopAeX = this.intersectX(bot3SXA, bot3SYA, bot3EXA, bot3EYA, bot1SXBA, bot1SYBA, bot1EXBA,
							bot1EYBA);
				
				myShape.bot1Part.stopAeY = this.intersectY(bot3SXA, bot3SYA, bot3EXA, bot3EYA, bot1SXBA, bot1SYBA, bot1EXBA,
							bot1EYBA);
				
			}
			
			if (myShape.bot3Part.endTypeLT == 1)
			{
				
				myShape.bot2Part.endTypeRB = 1;
				
				/* B2: C B BA A B3: C B BA A */
				
				myShape.bot2Part.startXC = this.intersectX(bot3SXC, bot3SYC, bot3EXC, bot3EYC, bot2SXC, bot2SYC, bot2EXC,
							bot2EYC);
				
				myShape.bot2Part.startYC = this.intersectY(bot3SXC, bot3SYC, bot3EXC, bot3EYC, bot2SXC, bot2SYC, bot2EXC,
							bot2EYC);
				
				myShape.bot2Part.startX = this.intersectX(bot3SX, bot3SY, bot3EX, bot3EY, bot2SX, bot2SY, bot2EX, bot2EY);
				
				myShape.bot2Part.startY = this.intersectY(bot3SX, bot3SY, bot3EX, bot3EY, bot2SX, bot2SY, bot2EX, bot2EY);
				
				myShape.bot2Part.startXBA = this.intersectX(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot2SXBA, bot2SYBA,
							bot2EXBA, bot2EYBA);
				
				myShape.bot2Part.startYBA = this.intersectY(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot2SXBA, bot2SYBA,
							bot2EXBA, bot2EYBA);
				
				myShape.bot2Part.startXA = this.intersectX(bot3SXA, bot3SYA, bot3EXA, bot3EYA, bot2SXA, bot2SYA, bot2EXA,
							bot2EYA);
				
				myShape.bot2Part.startYA = this.intersectY(bot3SXA, bot3SYA, bot3EXA, bot3EYA, bot2SXA, bot2SYA, bot2EXA,
							bot2EYA);
				
				myShape.bot3Part.endXC = myShape.bot2Part.startXC;
				myShape.bot3Part.endYC = myShape.bot2Part.startYC;
				
				myShape.bot3Part.endX = myShape.bot2Part.startX;
				myShape.bot3Part.endY = myShape.bot2Part.startY;
				
				myShape.bot3Part.endXBA = myShape.bot2Part.startXBA;
				myShape.bot3Part.endYBA = myShape.bot2Part.startYBA;
				myShape.bot3Part.endXA = myShape.bot2Part.startXA;
				myShape.bot3Part.endYA = myShape.bot2Part.startYA;
				
			}
			if (myShape.bot3Part.endTypeLT == 2)
			{
				
				/* B2: C B3: C B BA A-A */
				
				myShape.bot3Part.endXC = this.intersectX(bot3SXC, bot3SYC, bot3EXC, bot3EYC, bot2SXC, bot2SYC, bot2EXC,
							bot2EYC);
				
				myShape.bot3Part.endYC = this.intersectY(bot3SXC, bot3SYC, bot3EXC, bot3EYC, bot2SXC, bot2SYC, bot2EXC,
							bot2EYC);
				
				myShape.bot3Part.endX = this.intersectX(bot3SX, bot3SY, bot3EX, bot3EY, bot2SXC, bot2SYC, bot2EXC, bot2EYC);
				
				myShape.bot3Part.endY = this.intersectY(bot3SX, bot3SY, bot3EX, bot3EY, bot2SXC, bot2SYC, bot2EXC, bot2EYC);
				
				myShape.bot3Part.endXBA = this.intersectX(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot2SXC, bot2SYC, bot2EXC,
							bot2EYC);
				
				myShape.bot3Part.endYBA = this.intersectY(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot2SXC, bot2SYC, bot2EXC,
							bot2EYC);
				
				myShape.bot3Part.endXA = this.intersectX(bot3SXA, bot3SYA, bot3EXA, bot3EYA, bot2SXA, bot2SYA, bot2EXA,
							bot2EYA);
				
				myShape.bot3Part.endYA = this.intersectY(bot3SXA, bot3SYA, bot3EXA, bot3EYA, bot2SXA, bot2SYA, bot2EXA,
							bot2EYA);
				
				myShape.bot3Part.stopAeX = this.intersectX(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot2SXA, bot2SYA, bot2EXA,
							bot2EYA);
				
				myShape.bot3Part.stopAeY = this.intersectY(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot2SXA, bot2SYA, bot2EXA,
							bot2EYA);
				
				// ////////////////////////////////////
				
				myShape.bot2Part.endTypeRB = 3;
				
				/* B2: C B BA A B3: BA */
				
				myShape.bot2Part.startXC = this.intersectX(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot2SXC, bot2SYC, bot2EXC,
							bot2EYC);
				
				myShape.bot2Part.startYC = this.intersectY(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot2SXC, bot2SYC, bot2EXC,
							bot2EYC);
				
				myShape.bot2Part.startX = this.intersectX(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot2SX, bot2SY, bot2EX,
							bot2EY);
				
				myShape.bot2Part.startY = this.intersectY(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot2SX, bot2SY, bot2EX,
							bot2EY);
				
				myShape.bot2Part.startXBA = this.intersectX(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot2SXBA, bot2SYBA,
							bot2EXBA, bot2EYBA);
				
				myShape.bot2Part.startYBA = this.intersectY(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot2SXBA, bot2SYBA,
							bot2EXBA, bot2EYBA);
				
				myShape.bot2Part.startXA = this.intersectX(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot2SXA, bot2SYA, bot2EXA,
							bot2EYA);
				
				myShape.bot2Part.startYA = this.intersectY(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot2SXA, bot2SYA, bot2EXA,
							bot2EYA);
				// //////
				
				// ////
				
			}
			if (myShape.bot3Part.endTypeLT == 3)
			{
				
				/* B2: BA B3: C B BA A */
				
				myShape.bot3Part.endXC = this.intersectX(bot3SXC, bot3SYC, bot3EXC, bot3EYC, bot2SXBA, bot2SYBA, bot2EXBA,
							bot2EYBA);
				
				myShape.bot3Part.endYC = this.intersectY(bot3SXC, bot3SYC, bot3EXC, bot3EYC, bot2SXBA, bot2SYBA, bot2EXBA,
							bot2EYBA);
				
				myShape.bot3Part.endX = this.intersectX(bot3SX, bot3SY, bot3EX, bot3EY, bot2SXBA, bot2SYBA, bot2EXBA,
							bot2EYBA);
				
				myShape.bot3Part.endY = this.intersectY(bot3SX, bot3SY, bot3EX, bot3EY, bot2SXBA, bot2SYBA, bot2EXBA,
							bot2EYBA);
				
				myShape.bot3Part.endXBA = this.intersectX(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot2SXBA, bot2SYBA,
							bot2EXBA, bot2EYBA);
				
				myShape.bot3Part.endYBA = this.intersectY(bot3SXBA, bot3SYBA, bot3EXBA, bot3EYBA, bot2SXBA, bot2SYBA,
							bot2EXBA, bot2EYBA);
				
				myShape.bot3Part.endXA = this.intersectX(bot3SXA, bot3SYA, bot3EXA, bot3EYA, bot2SXBA, bot2SYBA, bot2EXBA,
							bot2EYBA);
				
				myShape.bot3Part.endYA = this.intersectY(bot3SXA, bot3SYA, bot3EXA, bot3EYA, bot2SXBA, bot2SYBA, bot2EXBA,
							bot2EYBA);
				
				// /////////////////////////////////////////
				
				myShape.bot2Part.endTypeRB = 2;
				
				/* B2: C B BA A-A B3: C */
				
				myShape.bot2Part.startXC = this.intersectX(bot3SXC, bot3SYC, bot3EXC, bot3EYC, bot2SXC, bot2SYC, bot2EXC,
							bot2EYC);
				
				myShape.bot2Part.startYC = this.intersectY(bot3SXC, bot3SYC, bot3EXC, bot3EYC, bot2SXC, bot2SYC, bot2EXC,
							bot2EYC);
				
				myShape.bot2Part.startX = this.intersectX(bot3SXC, bot3SYC, bot3EXC, bot3EYC, bot2SX, bot2SY, bot2EX, bot2EY);
				
				myShape.bot2Part.startY = this.intersectY(bot3SXC, bot3SYC, bot3EXC, bot3EYC, bot2SX, bot2SY, bot2EX, bot2EY);
				
				myShape.bot2Part.startXBA = this.intersectX(bot3SXC, bot3SYC, bot3EXC, bot3EYC, bot2SXBA, bot2SYBA, bot2EXBA,
							bot2EYBA);
				
				myShape.bot2Part.startYBA = this.intersectY(bot3SXC, bot3SYC, bot3EXC, bot3EYC, bot2SXBA, bot2SYBA, bot2EXBA,
							bot2EYBA);
				
				myShape.bot2Part.startXA = this.intersectX(bot3SXA, bot3SYA, bot3EXA, bot3EYA, bot2SXA, bot2SYA, bot2EXA,
							bot2EYA);
				
				myShape.bot2Part.startYA = this.intersectY(bot3SXA, bot3SYA, bot3EXA, bot3EYA, bot2SXA, bot2SYA, bot2EXA,
							bot2EYA);
				
				myShape.bot2Part.stopAsX = this.intersectX(bot3SXA, bot3SYA, bot3EXA, bot3EYA, bot2SXBA, bot2SYBA, bot2EXBA,
							bot2EYBA);
				
				myShape.bot2Part.stopAsY = this.intersectY(bot3SXA, bot3SYA, bot3EXA, bot3EYA, bot2SXBA, bot2SYBA, bot2EXBA,
							bot2EYBA);
				
			}
		}
	}
	
	public void getXYpointsMain(final ShapeObject myShape)
	{
	
		px1c = bX1C;
		py1c = bY1C;
		
		px1 = bX1;
		py1 = bY1;
		
		px1B = bX1B;
		py1B = bY1B;
		
		px1A = bX1A;
		py1A = bY1A;
		
		// Why Set to Parent Centers????
		//
		
		px2c = myParent.px2c;
		py2c = myParent.py2c;
		px3c = myParent.px3c;
		py3c = myParent.py3c;
		px4c = myParent.px4c;
		py4c = myParent.py4c;
		px5c = myParent.px5c;
		py5c = myParent.py5c;
		px6c = myParent.px6c;
		py6c = myParent.py6c;
		px7c = myParent.px7c;
		py7c = myParent.py7c;
		px8c = myParent.px8c;
		py8c = myParent.py8c;
		
		if (myParent.noSides == 2)
		{
			
			px3 = px2 = bX2;
			py3 = py2 = bY2;
			
			px3B = px2B = bX2B;
			py3B = py2B = bY2B;
			
			px3A = px2A = bX2A;
			py3A = py2A = bY2A;
			
			px3c = px2c = bX2C;
			py3c = py2c = bY2C;
			
			px4c = px1c;
			py4c = py1c;
			
			px4 = px1;
			py4 = py1;
			
			px4B = px1B;
			py4B = py1B;
			
			px4A = px1A;
			px4A = py1A;
			
		}
		else
		{
			
			if (myParent.noSidesTop == 1)
			{
				
				px2c = bX2C;
				py2c = bY2C;
				
				px2 = bX2;
				py2 = bY2;
				
				px2B = bX2B;
				py2B = bY2B;
				
				px2A = bX2A;
				py2A = bY2A;
				
				if (myParent.noSidesBot == 1)
				{
					if (myParent.noSidesRight > 0)
					{
						
						px3c = bX3C;
						py3c = bY3C;
						
						px3 = bX3;
						py3 = bY3;
						
						px3B = bX3B;
						py3B = bY3B;
						
						px3A = bX3A;
						py3A = bY3A;
						
						px4c = bX4C;
						py4c = bY4C;
						
						px4 = bX4;
						py4 = bY4;
						
						px4B = bX4B;
						py4B = bY4B;
						
						px4A = bX4A;
						py4A = bY4A;
						
					}
					else
					{
						if (myParent.noSides >= 3)
						{
							px3c = bX4C;
							py3c = bY4C;
							
							px3 = bX4;
							py3 = bY4;
							
							px3B = bX4B;
							py3B = bY4B;
							
							px3A = bX4A;
							py3A = bY4A;
							
						}
					}
					
				}
				else if (myParent.noSidesBot == 2)
				{
					if (myParent.noSidesRight > 0)
					{
						
						px3c = bX3C;
						px4c = b1b2XC;
						px5c = bX4C;
						
						py3c = bY3C;
						py4c = b1b2YC;
						py5c = bY4C;
						
						px3 = bX3;
						px4 = b1b2X;
						px5 = bX4;
						
						py3 = bY3;
						py4 = b1b2Y;
						py5 = bY4;
						
						px3B = bX3B;
						px4B = b1b2XB;
						px5B = bX4B;
						py3B = bY3B;
						py4B = b1b2YB;
						py5B = bY4B;
						
						px3A = bX3A;
						px4A = b1b2XA;
						px5A = bX4A;
						py3A = bY3A;
						py4A = b1b2YA;
						py5A = bY4A;
						
					}
					else
					{
						
						px3c = b1b2XC;
						px4c = bX4C;
						
						py3c = b1b2YC;
						py4c = bY4C;
						
						px3 = b1b2X;
						px4 = bX4;
						
						py3 = b1b2Y;
						py4 = bY4;
						
						px3B = b1b2XB;
						px4B = bX4B;
						
						py3B = b1b2YB;
						py4B = bY4B;
						
						px3A = b1b2XA;
						px4A = bX4A;
						
						py3A = b1b2YA;
						py4A = bY4A;
						
					}
					
				}
				else if (myParent.noSidesBot == 3)
				{
					if (myParent.noSidesRight > 0)
					{
						
						px3c = bX3C;
						px4c = b1b3XC;
						px5c = b3b2XC;
						px6c = bX4C;
						
						py3c = bY3C;
						py4c = b1b3YC;
						py5c = b3b2YC;
						py6c = bY4C;
						
						px3 = bX3;
						px4 = b1b3X;
						px5 = b3b2X;
						px6 = bX4;
						
						py3 = bY3;
						py4 = b1b3Y;
						py5 = b3b2Y;
						py6 = bY4;
						
						px3B = bX3B;
						px4B = b1b3XB;
						px5B = b3b2XB;
						px6B = bX4B;
						py3B = bY3B;
						py4B = b1b3YB;
						py5B = b3b2YB;
						py6B = bY4B;
						
						px3A = bX3A;
						px4A = b1b3XA;
						px5A = b3b2XA;
						px6A = bX4A;
						py3A = bY3A;
						py4A = b1b3YA;
						py5A = b3b2YA;
						py6A = bY4A;
						
					}
					else
					{
						
						px3c = b1b3XC;
						px4c = b3b2XC;
						px5c = bX4C;
						
						py3c = b1b3YC;
						py4c = b3b2YC;
						py5c = bY4C;
						
						px3 = b1b3X;
						px4 = b3b2X;
						px5 = bX4;
						
						py3 = b1b3Y;
						py4 = b3b2Y;
						py5 = bY4;
						
						px3B = b1b3XB;
						px4B = b3b2XB;
						px5B = bX4B;
						
						py3B = b1b3YB;
						py4B = b3b2YB;
						py5B = bY4B;
						
						px3A = b1b3XA;
						px4A = b3b2XA;
						px5A = bX4A;
						
						py3A = b1b3YA;
						py4A = b3b2YA;
						py5A = bY4A;
						
					}
				}
			}
			else if (myParent.noSidesTop == 2)
			{
				
				px2c = t1t2XC;
				px3c = bX2C;
				
				py2c = t1t2YC;
				py3c = bY2C;
				
				px2 = t1t2X;
				px3 = bX2;
				py2 = t1t2Y;
				py3 = bY2;
				
				px2B = t1t2XB;
				px3B = bX2B;
				py2B = t1t2YB;
				py3B = bY2B;
				
				px2A = t1t2XA;
				px3A = bX2A;
				py2A = t1t2YA;
				py3A = bY2A;
				
				if (myParent.noSidesBot == 1)
				{
					if (myParent.noSidesRight > 0)
					{
						
						px4c = bX3C;
						px5c = bX4C;
						
						py4c = bY3C;
						py5c = bY4C;
						
						px4 = bX3;
						px5 = bX4;
						py4 = bY3;
						py5 = bY4;
						px4B = bX3B;
						px5B = bX4B;
						py4B = bY3B;
						py5B = bY4B;
						
						px4A = bX3A;
						px5A = bX4A;
						py4A = bY3A;
						py5A = bY4A;
						
					}
					else
					{
						
						px4c = bX4C;
						py4c = bY4C;
						
						px4 = bX4;
						
						py4 = bY4;
						
						px4B = bX4B;
						
						py4B = bY4B;
						
						px4A = bX4A;
						
						py4A = bY4A;
						
					}
					
				}
				else if (myParent.noSidesBot == 2)
				{
					if (myParent.noSidesRight > 0)
					{
						
						px4c = bX3C;
						px5c = b1b2XC;
						px6c = bX4C;
						
						py4c = bY3C;
						py5c = b1b2YC;
						py6c = bY4C;
						
						px4 = bX3;
						px5 = b1b2X;
						px6 = bX4;
						py4 = bY3;
						py5 = b1b2Y;
						py6 = bY4;
						px4B = bX3B;
						px5B = b1b2XB;
						px6B = bX4B;
						py4B = bY3B;
						py5B = b1b2YB;
						py6B = bY4B;
						
						px4A = bX3A;
						px5A = b1b2XA;
						px6A = bX4A;
						py4A = bY3A;
						py5A = b1b2YA;
						py6A = bY4A;
						
					}
					else
					{
						
						px4c = b1b2XC;
						px5c = bX4C;
						
						py4c = b1b2YC;
						py5c = bY4C;
						
						px4 = b1b2X;
						px5 = bX4;
						
						py4 = b1b2Y;
						py5 = bY4;
						
						px4B = b1b2XB;
						px5B = bX4B;
						
						py4B = b1b2YB;
						py5B = bY4B;
						
						px4A = b1b2XA;
						px5A = bX4A;
						
						py4A = b1b2YA;
						py5A = bY4A;
						
					}
					
				}
				else if (myParent.noSidesBot == 3)
				{
					
					if (myParent.noSidesRight > 0)
					{
						
						px4c = bX3C;
						px5c = b1b3XC;
						px6c = b3b2XC;
						px7c = bX4C;
						
						py4c = bY3C;
						py5c = b1b3YC;
						py6c = b3b2YC;
						py7c = bY4C;
						
						px4 = bX3;
						px5 = b1b3X;
						px6 = b3b2X;
						px7 = bX4;
						py4 = bY3;
						py5 = b1b3Y;
						py6 = b3b2Y;
						py7 = bY4;
						
						px4B = bX3B;
						px5B = b1b3XB;
						px6B = b3b2XB;
						px7B = bX4B;
						py4B = bY3B;
						py5B = b1b3YB;
						py6B = b3b2YB;
						py7B = bY4B;
						
						px4A = bX3A;
						px5A = b1b3XA;
						px6A = b3b2XA;
						px7A = bX4A;
						py4A = bY3A;
						py5A = b1b3YA;
						py6A = b3b2YA;
						py7A = bY4A;
						
					}
					else
					{
						
						px4c = b1b3XC;
						px5c = b3b2XC;
						px6c = bX4C;
						
						py4c = b1b3YC;
						py5c = b3b2YC;
						py6c = bY4C;
						
						px4 = b1b3X;
						px5 = b3b2X;
						px6 = bX4;
						
						py4 = b1b3Y;
						py5 = b3b2Y;
						py6 = bY4;
						
						px4B = b1b3XB;
						px5B = b3b2XB;
						px6B = bX4B;
						
						py4B = b1b3YB;
						py5B = b3b2YB;
						py6B = bY4B;
						
						px4A = b1b3XA;
						px5A = b3b2XA;
						px6A = bX4A;
						
						py4A = b1b3YA;
						py5A = b3b2YA;
						py6A = bY4A;
						
					}
				}
			}
			else if (myParent.noSidesTop == 3)
			{
				
				px2c = t1t3XC;
				px3c = t3t2XC;
				px4c = bX2C;
				
				py2c = t1t3YC;
				py3c = t3t2YC;
				py4c = bY2C;
				
				px2 = t1t3X;
				px3 = t3t2X;
				px4 = bX2;
				py2 = t1t3Y;
				py3 = t3t2Y;
				py4 = bY2;
				
				px2B = t1t3XB;
				px3B = t3t2XB;
				px4B = bX2B;
				py2B = t1t3YB;
				py3B = t3t2YB;
				py4B = bY2B;
				
				px2A = t1t3XA;
				px3A = t3t2XA;
				px4A = bX2A;
				py2A = t1t3YA;
				py3A = t3t2YA;
				py4A = bY2A;
				
				if (myParent.noSidesBot == 1)
				{
					if (myParent.noSidesRight > 0)
					{
						
						px5c = bX3C;
						px6c = bX4C;
						
						py5c = bY3C;
						py6c = bY4C;
						
						px5 = bX3;
						px6 = bX4;
						py5 = bY3;
						py6 = bY4;
						
						px5B = bX3B;
						px6B = bX4B;
						py5B = bY3B;
						py6B = bY4B;
						
						px5A = bX3A;
						px6A = bX4A;
						py5A = bY3A;
						py6A = bY4A;
						
					}
					else
					{
						
						px5c = bX4C;
						py5c = bY4C;
						
						px5 = bX4;
						
						py5 = bY4;
						
						px5B = bX4B;
						
						py5B = bY4B;
						
						px5A = bX4A;
						
						py5A = bY4A;
						
					}
					
				}
				else if (myParent.noSidesBot == 2)
				{
					if (myParent.noSidesRight > 0)
					{
						
						px5c = bX3C;
						px6c = b1b2XC;
						px7c = bX4C;
						
						py5c = bY3C;
						py6c = b1b2YC;
						py7c = bY4C;
						
						px5 = bX3;
						px6 = b1b2X;
						px7 = bX4;
						
						py5 = bY3;
						py6 = b1b2Y;
						py7 = bY4;
						
						px5B = bX3B;
						px6B = b1b2XB;
						px7B = bX4B;
						py5B = bY3B;
						py6B = b1b2YB;
						py7B = bY4B;
						
						px5A = bX3A;
						px6A = b1b2XA;
						px7A = bX4A;
						py5A = bY3A;
						py6A = b1b2YA;
						py7A = bY4A;
						
					}
					else
					{
						
						px5c = b1b2XC;
						px6c = bX4C;
						
						py5c = b1b2YC;
						py6c = bY4C;
						
						px5 = b1b2X;
						px6 = bX4;
						
						py5 = b1b2Y;
						py6 = bY4;
						
						px5B = b1b2XB;
						px6B = bX4B;
						
						py5B = b1b2YB;
						py6B = bY4B;
						
						px5A = b1b2XA;
						px6A = bX4A;
						
						py5A = b1b2YA;
						py6A = bY4A;
						
					}
				}
				else if (myParent.noSidesBot == 3)
				{
					if (myParent.noSidesRight > 0)
					{
						
						px5c = bX3C;
						px6c = b1b3XC;
						px7c = b3b2XC;
						px8c = bX4C;
						
						py5c = bY3C;
						py6c = b1b3YC;
						py7c = b3b2YC;
						py8c = bY4C;
						
						px5 = bX3;
						px6 = b1b3X;
						px7 = b3b2X;
						px8 = bX4;
						
						py5 = bY3;
						py6 = b1b3Y;
						py7 = b3b2Y;
						py8 = bY4;
						
						px5B = bX3B;
						px6B = b1b3XB;
						px7B = b3b2XB;
						px8B = bX4B;
						
						py5B = bY3B;
						py6B = b1b3YB;
						py7B = b3b2YB;
						py8B = bY4B;
						
						px5A = bX3A;
						px6A = b1b3XA;
						px7A = b3b2XA;
						px8A = bX4A;
						
						py5A = bY3A;
						py6A = b1b3YA;
						py7A = b3b2YA;
						py8A = bY4A;
						
					}
					else
					{
						
						px5c = b1b3XC;
						px6c = b3b2XC;
						px7c = bX4C;
						
						py5c = b1b3YC;
						py6c = b3b2YC;
						py7c = bY4C;
						
						px5 = b1b3X;
						px6 = b3b2X;
						px7 = bX4;
						
						py5 = b1b3Y;
						py6 = b3b2Y;
						py7 = bY4;
						
						px5B = b1b3XB;
						px6B = b3b2XB;
						px7B = bX4B;
						
						py5B = b1b3YB;
						py6B = b3b2YB;
						py7B = bY4B;
						
						px5A = b1b3XA;
						px6A = b3b2XA;
						px7A = bX4A;
						
						py5A = b1b3YA;
						py6A = b3b2YA;
						py7A = bY4A;
						
					}
				}
			}
		}
	}
	
	/**
	 * Setting pxpy point
	 */
	public void setpXpY(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4, double x5,
				double y5, double x6, double y6, double x7, double y7, double x8, double y8, double x1c, double y1c,
				double x2c, double y2c, double x3c, double y3c, double x4c, double y4c, double x5c, double y5c, double x6c,
				double y6c, double x7c, double y7c, double x8c, double y8c, double x1B, double y1B, double x2B, double y2B,
				double x3B, double y3B, double x4B, double y4B, double x5B, double y5B, double x6B, double y6B, double x7B,
				double y7B, double x8B, double y8B, double x1A, double y1A, double x2A, double y2A, double x3A, double y3A,
				double x4A, double y4A, double x5A, double y5A, double x6A, double y6A, double x7A, double y7A, double x8A,
				double y8A, double x1C, double y1C, double x2C, double y2C, double x3C, double y3C, double x4C, double y4C,
				double x5C, double y5C, double x6C, double y6C, double x7C, double y7C, double x8C, double y8C)
	{
	
		px1 = x1;
		py1 = y1;
		px2 = x2;
		py2 = y2;
		px3 = x3;
		py3 = y3;
		px4 = x4;
		py4 = y4;
		px5 = x5;
		py5 = y5;
		px6 = x6;
		py6 = y6;
		px7 = x7;
		py7 = y7;
		px8 = x8;
		py8 = y8;
		
		// if (myParent.a_levelID == 1) {
		// px1c = x1;
		// py1c = y1;
		// px2c = x2;
		// py2c = y2;
		// px3c = x3;
		// py3c = y3;
		// px4c = x4;
		// py4c = y4;
		// px5c = x5;
		// py5c = y5;
		// px6c = x6;
		// py6c = y6;
		// px7c = x7;
		// py7c = y7;
		// px8c = x8;
		// py8c = y8;
		//
		// } else {
		
		px1c = x1c;
		py1c = y1c;
		px2c = x2c;
		py2c = y2c;
		px3c = x3c;
		py3c = y3c;
		px4c = x4c;
		py4c = y4c;
		px5c = x5c;
		py5c = y5c;
		px6c = x6c;
		py6c = y6c;
		px7c = x7c;
		py7c = y7c;
		px8c = x8c;
		py8c = y8c;
		// }
		
		px1B = x1B;
		py1B = y1B;
		px2B = x2B;
		py2B = y2B;
		px3B = x3B;
		py3B = y3B;
		px4B = x4B;
		py4B = y4B;
		px5B = x5B;
		py5B = y5B;
		px6B = x6B;
		py6B = y6B;
		px7B = x7B;
		py7B = y7B;
		px8B = x8B;
		py8B = y8B;
		
		px1A = x1A;
		py1A = y1A;
		px2A = x2A;
		py2A = y2A;
		px3A = x3A;
		py3A = y3A;
		px4A = x4A;
		py4A = y4A;
		px5A = x5A;
		py5A = y5A;
		px6A = x6A;
		py6A = y6A;
		px7A = x7A;
		py7A = y7A;
		px8A = x8A;
		py8A = y8A;
	}

    public void setProfileAngles(ShapeObject myShape) {

        myShape.top1Part.calcAngles();
        myShape.top2Part.calcAngles();
        myShape.top3Part.calcAngles();
        myShape.bot1Part.calcAngles();
        myShape.bot2Part.calcAngles();
        myShape.bot3Part.calcAngles();
        myShape.leftPart.calcAngles();
        myShape.rightPart.calcAngles();
    }

    public void setProfileLength(ShapeObject myShape) {

        if (myShape.top1Part.partForm == 1) {

            myShape.top1Part.length = Math.sqrt(Math.pow((Math.max(myShape.top1Part.endXC, myShape.top1Part.startXC) -
                    Math.min(myShape.top1Part.endXC, myShape.top1Part.startXC)), 2) +
                    Math.pow((Math.max(myShape.top1Part.endYC, myShape.top1Part.startYC) -
                            Math.min(myShape.top1Part.endYC, myShape.top1Part.startYC)), 2));

            myShape.top1Part.lengthM = (new BigDecimal(myShape.top1Part.length).divide(myFrame2.metricscale, 1, BigDecimal.ROUND_UP)).intValue();
            myShape.top1Part.lengthI = (new BigDecimal(myShape.top1Part.length).divide(myFrame2.imperialscale, 1, BigDecimal.ROUND_UP)).intValue();

        } else if (myShape.top1Part.partForm == 2) {
            myShape.top1Part.length = 2 * Math.PI * myShape.top1Part.radius1 * myShape.top1Part.centralAngle / 360;

        } else if (myShape.top1Part.partForm == 3) {
            double w = myShape.widthPix + (2 * myShape.top1Part.partDimC);
            double h1 = Math.pow((myShape.dimB1 - w / 2), 2) / Math.pow((myShape.dimB1 + w / 2), 2);
            double factorial = 1 + 0.25f * h1 + 1 / 64 * (Math.pow(h1, 2) + 1 / 256 * Math.pow(h1, 3) + 25 / 16384 * Math.pow(h1, 4));

            myShape.top1Part.length = Math.PI * (w / 2 + myShape.dimB1) * factorial;
        }

        if (myShape.top2Part.partForm == 1) {
            myShape.top2Part.length = Math.sqrt(Math.pow((Math.max(myShape.top2Part.endXC, myShape.top2Part.startXC) -
                    Math.min(myShape.top2Part.endXC, myShape.top2Part.startXC)), 2) +
                    Math.pow((Math.max(myShape.top2Part.endYC, myShape.top2Part.startYC) -
                            Math.min(myShape.top2Part.endYC, myShape.top2Part.startYC)), 2));

        } else if (myShape.top2Part.partForm == 2) {
            myShape.top2Part.length = 2 * Math.PI * myShape.top2Part.radius1 * myShape.top2Part.centralAngle / 360;

        } else if (myShape.top2Part.partForm == 3) {
            double w = myShape.widthPix + (2 * myShape.top2Part.partDimC);

            double h1 = Math.pow((myShape.dimB1 - w / 2), 2) / Math.pow((myShape.dimB1 + w / 2), 2);
            double factorial = 1 + 0.25f * h1 + 1 / 64 * (Math.pow(h1, 2) + 1 / 256 * Math.pow(h1, 3) + 25 / 16384 * Math.pow(h1, 4));
            myShape.top2Part.length = Math.PI * (w / 2 + myShape.dimB1) * factorial;
        }

        if (myShape.top3Part.partForm == 1) {
            myShape.top3Part.length = Math.sqrt(Math.pow((Math.max(myShape.top3Part.endXC, myShape.top3Part.startXC) -
                    Math.min(myShape.top3Part.endXC, myShape.top3Part.startXC)), 2) +
                    Math.pow((Math.max(myShape.top3Part.endYC, myShape.top3Part.startYC) -
                            Math.min(myShape.top3Part.endYC, myShape.top3Part.startYC)), 2));

        } else if (myShape.top3Part.partForm == 2) {
            myShape.top3Part.length = 2 * Math.PI * myShape.top3Part.radius1 * myShape.top3Part.centralAngle / 360;
        }

        if (myShape.bot1Part.partForm == 1) {
            myShape.bot1Part.length = Math.sqrt(Math.pow((Math.max(myShape.bot1Part.endXC, myShape.bot1Part.startXC) -
                    Math.min(myShape.bot1Part.endXC, myShape.bot1Part.startXC)), 2) +
                    Math.pow((Math.max(myShape.bot1Part.endYC, myShape.bot1Part.startYC) -
                            Math.min(myShape.bot1Part.endYC, myShape.bot1Part.startYC)), 2));

        } else if (myShape.bot1Part.partForm == 2) {
            myShape.bot1Part.length = 2 * Math.PI * myShape.bot1Part.radius1 * myShape.bot1Part.centralAngle / 360;
        }

        if (myShape.bot2Part.partForm == 1) {
            myShape.bot2Part.length = Math.sqrt(Math.pow((Math.max(myShape.bot2Part.endXC, myShape.bot2Part.startXC) -
                    Math.min(myShape.bot2Part.endXC, myShape.bot2Part.startXC)), 2) +
                    Math.pow((Math.max(myShape.bot2Part.endYC, myShape.bot2Part.startYC) -
                            Math.min(myShape.bot2Part.endYC, myShape.bot2Part.startYC)), 2));

        } else if (myShape.bot2Part.partForm == 2) {
            myShape.bot2Part.length = 2 * Math.PI * myShape.bot2Part.radius1 * myShape.bot2Part.centralAngle / 360;
        }

        if (myShape.bot3Part.partForm == 1) {
            myShape.bot3Part.length = Math.sqrt(Math.pow((Math.max(myShape.bot3Part.endXC, myShape.bot3Part.startXC) -
                    Math.min(myShape.bot3Part.endXC, myShape.bot3Part.startXC)), 2) +
                    Math.pow((Math.max(myShape.bot3Part.endYC, myShape.bot3Part.startYC) -
                            Math.min(myShape.bot3Part.endYC, myShape.bot3Part.startYC)), 2));

        } else if (myShape.bot3Part.partForm == 2) {
            myShape.bot3Part.length = 2 * Math.PI * myShape.bot3Part.radius1 * myShape.bot3Part.centralAngle / 360;
        }

        if (myShape.leftPart.partForm == 1) {
            myShape.leftPart.length = Math.sqrt(Math.pow((Math.max(myShape.leftPart.endXC, myShape.leftPart.startXC) -
                    Math.min(myShape.leftPart.endXC, myShape.leftPart.startXC)), 2) +
                    Math.pow((Math.max(myShape.leftPart.endYC, myShape.leftPart.startYC) -
                            Math.min(myShape.leftPart.endYC, myShape.leftPart.startYC)), 2));
        }

        if (myShape.rightPart.partForm == 1) {
            myShape.rightPart.length = Math.sqrt(Math.pow((Math.max(myShape.rightPart.endXC, myShape.rightPart.startXC) -
                    Math.min(myShape.rightPart.endXC, myShape.rightPart.startXC)), 2) +
                    Math.pow((Math.max(myShape.rightPart.endYC, myShape.rightPart.startYC) -
                            Math.min(myShape.rightPart.endYC, myShape.rightPart.startYC)), 2));
        }

        myShape.top1Part.lengthM = (new BigDecimal(myShape.top1Part.length).divide(myFrame2.metricscale, 1, BigDecimal.ROUND_UP)).intValue();
        myShape.top1Part.lengthI = (new BigDecimal(myShape.top1Part.length).divide(myFrame2.imperialscale, 1, BigDecimal.ROUND_UP)).intValue();
        myShape.top2Part.lengthM = (new BigDecimal(myShape.top2Part.length).divide(myFrame2.metricscale, 1, BigDecimal.ROUND_UP)).intValue();
        myShape.top2Part.lengthI = (new BigDecimal(myShape.top2Part.length).divide(myFrame2.imperialscale, 1, BigDecimal.ROUND_UP)).intValue();
        myShape.top3Part.lengthM = (new BigDecimal(myShape.top3Part.length).divide(myFrame2.metricscale, 1, BigDecimal.ROUND_UP)).intValue();
        myShape.top3Part.lengthI = (new BigDecimal(myShape.top3Part.length).divide(myFrame2.imperialscale, 1, BigDecimal.ROUND_UP)).intValue();
        myShape.bot1Part.lengthM = (new BigDecimal(myShape.bot1Part.length).divide(myFrame2.metricscale, 1, BigDecimal.ROUND_UP)).intValue();
        myShape.bot1Part.lengthI = (new BigDecimal(myShape.bot1Part.length).divide(myFrame2.imperialscale, 1, BigDecimal.ROUND_UP)).intValue();
        myShape.bot2Part.lengthM = (new BigDecimal(myShape.bot2Part.length).divide(myFrame2.metricscale, 1, BigDecimal.ROUND_UP)).intValue();
        myShape.bot2Part.lengthI = (new BigDecimal(myShape.bot2Part.length).divide(myFrame2.imperialscale, 1, BigDecimal.ROUND_UP)).intValue();
        myShape.bot3Part.lengthM = (new BigDecimal(myShape.bot3Part.length).divide(myFrame2.metricscale, 1, BigDecimal.ROUND_UP)).intValue();
        myShape.bot3Part.lengthI = (new BigDecimal(myShape.bot3Part.length).divide(myFrame2.imperialscale, 1, BigDecimal.ROUND_UP)).intValue();
        myShape.leftPart.lengthM = (new BigDecimal(myShape.leftPart.length).divide(myFrame2.metricscale, 1, BigDecimal.ROUND_UP)).intValue();
        myShape.leftPart.lengthI = (new BigDecimal(myShape.leftPart.length).divide(myFrame2.imperialscale, 1, BigDecimal.ROUND_UP)).intValue();
        myShape.rightPart.lengthM = (new BigDecimal(myShape.rightPart.length).divide(myFrame2.metricscale, 1, BigDecimal.ROUND_UP)).intValue();
        myShape.rightPart.lengthI = (new BigDecimal(myShape.rightPart.length).divide(myFrame2.imperialscale, 1, BigDecimal.ROUND_UP)).intValue();
    }

    /**
	 * Calculate opening dimensions for width and height from axis points in X & Y
	 * 
	 * @param myShape, ShapeObject
	 * @return ShapeObject
	 */
    public ShapeObject setOpeningDims(final ShapeObject myShape) {

        // Calculate Width pixels
        myShape.widthPix = wt = Math.max(myShape.bX2, myShape.bX3) - Math.min(myShape.startingX, myShape.bX4);

        myShape.highestY = Math.min(py1, Math.min(py2, Math.min(py3, py4)));
        myShape.highestYC = myParent.highestYC;// Math.min(myParent.py1, Math.min(myParent.py2, Math.min(myParent.py3, myParent.py4)));
       
        myShape.lowestY = Math.max(py3, Math.max(py4, Math.max(py5, Math.max(py6, py7))));
        myShape.lowestYC = Math.max( myParent.py3, 
        		Math.max( myParent.py4, Math.max( myParent.py5, Math.max( myParent.py6,  myParent.py7))));

        if (myParent.top1Part.partForm > 1) {
            myShape.highestY  = myShape.top1Part.y1 - myShape.top1Part.radius1;
            myShape.highestYC = myParent.top1Part.y1 - myParent.top1Part.radius1;
        }

        if (myShape.bot1Part.partForm > 1) {
            myShape.lowestY = myShape.bot1Part.y1 + myShape.bot1Part.radius1;
            myShape.lowestYC = myParent.bot1Part.y1 + myParent.bot1Part.radius1;
        }

        myShape.heightPix = hl = myShape.lowestY - myShape.highestY;

        myShape.widthM = (new BigDecimal(wt).divide(myFrame2.metricscale, 1, BigDecimal.ROUND_UP)).intValue();
        myShape.heightM = (new BigDecimal(myShape.heightPix).divide(myFrame2.metricscale, 1, BigDecimal.ROUND_UP)).intValue();

        myShape.widthI = (new BigDecimal(wt).divide(myFrame2.imperialscale, 1, BigDecimal.ROUND_UP)).intValue();
        myShape.heightI = (new BigDecimal(myShape.heightPix).divide(myFrame2.imperialscale, 1, BigDecimal.ROUND_UP)).intValue();

        // Clear Lean values
        checkLeanTo(myShape);

        if (leanChanged || myShape.lean > 0) {
            checkLeanTo(myShape);
        }

        if (myParent.a_levelID == 1 && leanChanged && myShape.shapeID == 1 || myShape.shapeID == 0) {
            ShapeIDCalc calcShape = new ShapeIDCalc();
            calcShape.calc(myShape);
            myShape.shapeID = calcShape.shapeID;
            calcShape = null;
        }

        if (myParent.noSidesTop > 1) {

            if (myParent.noSidesTop >= 2) {
                myShape.dimA1 = myShape.px2 - myShape.startingX;
                myShape.dimA2 = myShape.bX2 - myShape.px2;
            }

            if (myParent.noSidesTop == 3) {
                myShape.dimA1 = myShape.px3 - myShape.startingX;
                myShape.dimA2 = myShape.bX2 - myShape.px3;
                myShape.dimA3 = myShape.px3 - myShape.px2;
            }

        } else {

            if (myShape.lean == 0) {
                myShape.dimA1 = 0;
                myShape.dimA2 = 0;
                myShape.dimA3 = 0;
                myShape.dimA0 = 0;
            } else if (myShape.lean == 2) {
                myShape.dimA2 = myShape.bX2 - myShape.startingX;
                myShape.dimA1 = Math.max(wt, wb) - myShape.dimA2;
            } else if (myShape.lean == 1) {
                myShape.dimA1 = myShape.bX2 - myShape.startingX;
                myShape.dimA2 = Math.max(wt, wb) - myShape.dimA1;
            } else if (myShape.lean == 3) {
                myShape.dimA0 = myShape.startingX - myShape.bX4;
                myShape.dimA2 = myShape.bX3 - myShape.bX2;
                myShape.dimA1 = Math.max(wt, wb) - (myShape.dimA2 + myShape.dimA0);
            }
        }

        if (myShape.lean2 == 0) {
            myShape.dimB2 = 0;
            myShape.dimB1 = 0;
            myShape.dimB0 = 0;
        } else if (myShape.lean2 == 2) {
            myShape.dimB2 = myShape.bY3 - myShape.bY2;
            myShape.dimB1 = Math.max(hl, hr) - myShape.dimB2;
        } else if (myShape.lean2 == 1) {
            myShape.dimB1 = myShape.bY3 - myShape.bY2;
            myShape.dimB2 = Math.max(hl, hr) - myShape.dimB1;
        } else if (myShape.lean2 == 3) {
            myShape.dimB0 = myShape.bY2 - myShape.startingY;
            myShape.dimB1 = myShape.bY3 - myShape.bY2;
            myShape.dimB2 = Math.max(hl, hr) - (myShape.dimB1 + myShape.dimB0);
        }

        if (myParent.noSidesBot > 1) {

            if (myParent.noSidesBot == 2) {
                myShape.dimC1 = myShape.bX3 - b1b2X;
                myShape.dimC2 = b1b2X - myShape.bX4;
            }

            if (myParent.noSidesBot == 3) {
                myShape.dimC3 = myShape.bX3 - b1b3X;
                myShape.dimC1 = b1b3X - b1b2X;
                myShape.dimC2 = b1b2X - myShape.bX4;
            }

        } else {

            if (myShape.lean3 == 0) {
                myShape.dimC1 = 0;
                myShape.dimC2 = 0;
                myShape.dimC3 = 0;
                myShape.dimC0 = 0;
            } else if (myShape.lean3 == 2) {
                myShape.dimC2 = myShape.bX3 - myShape.bX4;
                myShape.dimC1 = Math.max(wt, wb) - myShape.dimC2;
            } else if (myShape.lean3 == 1) {
                myShape.dimC1 = myShape.bX3 - myShape.bX4;
                myShape.dimC2 = Math.max(wt, wb) - myShape.dimC1;
            }
            if (myShape.lean3 == 3) {
                myShape.dimC0 = myShape.bX2 - myShape.bX3;
                myShape.dimC2 = myShape.bX4 - myShape.startingX;
                myShape.dimC1 = Math.max(wt, wb) - (myShape.dimC2 + myShape.dimC0);
            }

        }

//		myShape.dimD1 = myShape.bY4 - myShape.startingY;

        if (myShape.lean4 == 0) {
            myShape.dimD1 = 0;
            myShape.dimD2 = 0;
            myShape.dimD0 = 0;
        }
        if (myShape.lean4 == 1) {
            myShape.dimD1 = myShape.bY4 - myShape.startingY;
            myShape.dimD2 = Math.max(hl, hr) - myShape.dimD1;
        }
        if (myShape.lean4 == 2) {
            myShape.dimD2 = myShape.bY4 - myShape.startingY;
            myShape.dimD1 = Math.max(hl, hr) - myShape.dimD2;
        }
        if (myShape.lean4 == 3) {
            myShape.dimD0 = myShape.bY3 - myShape.bY4;
            myShape.dimD2 = myShape.bY2 - myShape.startingY;
            myShape.dimD1 = Math.max(hl, hr) - (myShape.dimD2 + myShape.dimD0);
        }

        if (myShape.top1.partForm > 1 || myShape.top1Part.partForm > 1) {
            if (myShape.highestY < myShape.startingY) {
                myShape.dimD2 = myShape.startingY - myShape.highestY;
            }

            if (myShape.highestY < myShape.bY2) {
                myShape.dimB1 = myShape.bY2 - myShape.highestY;
            }
        }

        if (myShape.bot1.partForm > 1 || myShape.bot1Part.partForm > 1) {

            if (myShape.lowestY > myShape.bY4) {
                if (myShape.dimD0 > 0) {
                    myShape.dimD0 = myShape.lowestY - myShape.bY4;
                } else {
                    myShape.dimD1 = myShape.lowestY - myShape.bY4;
                }
            }

            if (myShape.lowestY < myShape.bY2) {
                myShape.dimB2 = myShape.lowestY - myShape.bY2;
            }
        }

        if (myShape.radius1 > 0) {

            myShape.radius1 = myShape.radius1 - myShape.clearanceTop;
            myShape.radius2 = myShape.radius2 - myShape.clearanceTop;

            if (myParent.dimB1 > myParent.radius1) {
                myParent.dimB1 = myParent.radius1;
            }

            if (myParent.dimD2 > myParent.radius1) {
                myParent.dimD2 = myParent.radius1;
            }

        }

        if (myParent.noSidesTop == 1 && myParent.top1Part.partForm >= 2 && myParent.dimB1 == myParent.dimD2
                && myParent.dimB1 == myParent.radius1 && myParent.rightPart.posInUse && myParent.leftPart.posInUse) {

            if (!myShape.rightIn) {
                myShape.bY2 = bY2 = bY2A = myParent.rightPart.startYC;
            }

            if (!myShape.leftIn) {
                myShape.startingY = bY1 = bY1A = myParent.leftPart.endYC;
            }
        }

        if (myParent.noSidesTop == 1 && myParent.top1Part.partForm >= 2 && myParent.dimD2 == myParent.radius1
                && myParent.rightPart.posInUse && myParent.leftPart.posInUse) {

            if (!myShape.leftIn) {
                myShape.startingY = bY1 = bY1A = myParent.leftPart.endYC;
            }
        }

        if (myParent.noSidesTop == 1 && myParent.top1Part.partForm >= 2 && myParent.dimB1 == myParent.radius1
                && myParent.rightPart.posInUse && myParent.leftPart.posInUse) {

            if (!myShape.rightIn) {
                myShape.bY2 = bY2 = bY2A = myParent.rightPart.startYC;
            }

            if (!myShape.leftIn) {
                myShape.startingY = bY1 = bY1A = myParent.leftPart.endYC;
            }
        }

        if (myParent.noSidesTop == 2 && myParent.top1Part.partForm >= 2 && myParent.top2Part.partForm >= 2) {

            if (!myShape.rightIn) {
                myShape.bY2 = bY2 = bY2A = myParent.rightPart.startYC;
            }

            if (!myShape.leftIn) {
                myShape.startingY = bY1 = bY1A = myParent.leftPart.endYC;
            }
        }

        if (myParent.noSidesTop == 2 && myParent.top1Part.partForm >= 2 && myParent.top2Part.partForm == 1) {

            if (!myShape.leftIn) {
                myShape.startingY = bY1 = bY1A = myParent.leftPart.endYC;
            }
        }

        if (myParent.noSidesTop == 2 && myParent.top1Part.partForm == 1 && myParent.top2Part.partForm >= 2) {

            if (!myShape.rightIn) {
                myShape.bY2 = bY2 = bY2A = myParent.rightPart.startYC;
            }
        }

        if (myParent.noSidesTop == 3 && myParent.top1Part.partForm >= 2 && myParent.top2Part.partForm >= 2) {

            if (!myShape.rightIn) {
                myShape.bY2 = bY2 = bY2A = myParent.rightPart.startYC;
            }

            if (!myShape.leftIn) {
                myShape.startingY = bY1 = bY1A = myParent.leftPart.endYC;
            }
        }

        if (myShape.topIn && myShape.myMullionTop != null) {
            myShape.highestY = Math.min(myShape.myMullionTop.y1, myShape.myMullionTop.y4);
            myShape.highestYC = Math.min(myShape.myMullionTop.centerYs, myShape.myMullionTop.centerYe);

        }
        if (myShape.botIn && myShape.myMullionBot != null) {
            myShape.lowestY = Math.max(myShape.myMullionBot.y2, myShape.myMullionBot.y3);
            myShape.lowestYC = Math.max(myShape.myMullionBot.centerYs, myShape.myMullionBot.centerYe);

        }

       

        if (myShape.leftIn && myShape.myMullionLeft != null) {

            myShape.startingCX = this.intersectX(myShape.startingCX, myShape.startingCY, myShape.bCX2, myShape.bCY2,
                    myShape.myMullionLeft.centerXs, myShape.myMullionLeft.centerYs, myShape.myMullionLeft.centerXe,
                    myShape.myMullionLeft.centerYe);

            myShape.bCX4 = this.intersectX(myShape.bCX4, myShape.bCY4, myShape.bCX3, myShape.bCY3,
                    myShape.myMullionLeft.centerXs, myShape.myMullionLeft.centerYs, myShape.myMullionLeft.centerXe,
                    myShape.myMullionLeft.centerYe);

        }

        if (myShape.rightIn && myShape.myMullionRight != null) {

            myShape.bCX2 = this.intersectX(myShape.startingCX, myShape.startingCY, myShape.bCX2, myShape.bCY2,
                    myShape.myMullionRight.centerXs, myShape.myMullionRight.centerYs, myShape.myMullionRight.centerXe,
                    myShape.myMullionRight.centerYe);

            myShape.bCX3 = this.intersectX(myShape.bCX4, myShape.bCY4, myShape.bCX3, myShape.bCY3,
                    myShape.myMullionRight.centerXs, myShape.myMullionRight.centerYs, myShape.myMullionRight.centerXe,
                    myShape.myMullionRight.centerYe);
        }

        // if (myShape.leftPart.partDimC > 0)
        // {
        //
        // myShape.startingCX = myShape.startingCX - this.leftDimC;
        //
        // myShape.startingCX = this.intersectX(myShape.startingCX,
        // myShape.startingCY, myShape.bCX2, myShape.bCY2,
        // myShape.leftPart.startingXBC, myShape.leftPart.startingYBC,
        // myShape.leftPart.endXBC,
        // myShape.leftPart.endYBC);
        //
        // myShape.bCX4 = this.intersectX(myShape.bCX4, myShape.bCY4,
        // myShape.bCX3, myShape.bCY3,
        // myShape.leftPart.startingXBC, myShape.leftPart.startingYBC,
        // myShape.leftPart.endXBC,
        // myShape.leftPart.endYBC);
        //
        // }
        // if (myShape.rightPart.partDimC > 0)
        // {
        //
        // myShape.bCX2 = this.intersectX(myShape.startingCX,
        // myShape.startingCY, myShape.bCX2, myShape.bCY2,
        // myShape.rightPart.startingXBC, myShape.rightPart.startingYBC,
        // myShape.rightPart.endXBC,
        // myShape.rightPart.endYBC);
        //
        // myShape.bCX3 = this.intersectX(myShape.bCX4, myShape.bCY4,
        // myShape.bCX3, myShape.bCY3,
        // myShape.rightPart.startingXBC, myShape.rightPart.startingYBC,
        // myShape.rightPart.endXBC,
        // myShape.rightPart.endYBC);
        //
        // }

        myShape.widthMN = (new BigDecimal((Math.max(myShape.bCX3 - myShape.bCX4, myShape.bCX2 - myShape.startingCX)))
                .divide(myFrame2.metricscale, 1, BigDecimal.ROUND_HALF_UP)).intValue();

        myShape.widthIN = (new BigDecimal((Math.max(myShape.bCX3 - myShape.bCX4, myShape.bCX2 - myShape.startingCX)))
                .divide(myFrame2.imperialscale, 1, BigDecimal.ROUND_HALF_UP)).intValue();

        myShape.heightMN = (new BigDecimal((myShape.lowestYC - myShape.highestYC)).divide(myFrame2.metricscale, 1,
                BigDecimal.ROUND_HALF_UP)).intValue();

        myShape.heightIN = (new BigDecimal((myShape.lowestYC - myShape.highestYC)).divide(myFrame2.imperialscale, 1,
                BigDecimal.ROUND_HALF_UP)).intValue();

        setWH_MI(myShape);

        return myShape;
    }

    public void setWH_MI(ShapeObject myShape) {

        myShape.widthM = (new BigDecimal((Math.max(myShape.bX3 - myShape.bX4, myShape.bX2 - myShape.startingX))).divide(
                myFrame2.metricscale, 1, BigDecimal.ROUND_HALF_UP)).intValue();

        myShape.widthI = (new BigDecimal((Math.max(myShape.bX3 - myShape.bX4, myShape.bX2 - myShape.startingX))).divide(
                myFrame2.imperialscale, 1, BigDecimal.ROUND_HALF_UP)).intValue();

        myShape.heightM = (new BigDecimal((myShape.lowestY - myShape.highestY)).divide(myFrame2.metricscale, 1,
                BigDecimal.ROUND_HALF_UP)).intValue();

        myShape.heightI = (new BigDecimal((myShape.lowestY - myShape.highestY)).divide(myFrame2.imperialscale, 1,
                BigDecimal.ROUND_HALF_UP)).intValue();

        if (this.myFrame2.myTopPanel.isWAction || myShape.widthMO == 0) {

            myShape.widthMO = (new BigDecimal((Math.max(myShape.bX3 - myShape.bX4, myShape.bX2 - myShape.startingX)))
                    .divide(myFrame2.metricscale, 1, BigDecimal.ROUND_HALF_UP)).intValue();

            myShape.widthIO = (new BigDecimal((Math.max(myShape.bX3 - myShape.bX4, myShape.bX2 - myShape.startingX)))
                    .divide(myFrame2.imperialscale, 1, BigDecimal.ROUND_HALF_UP)).intValue();
        }

        if (this.myFrame2.myTopPanel.isHAction || myShape.heightMO == 0) {
            myShape.heightMO = (new BigDecimal((myShape.lowestY - myShape.highestY)).divide(myFrame2.metricscale, 1,
                    BigDecimal.ROUND_HALF_UP)).intValue();

            myShape.heightIO = (new BigDecimal((myShape.lowestY - myShape.highestY)).divide(myFrame2.imperialscale, 1,
                    BigDecimal.ROUND_HALF_UP)).intValue();
        }
    }

    public void checkLeanTo(final ShapeObject myShape) {

        final int l1 = myShape.lean;
        final int l2 = myShape.lean2;
        final int l3 = myShape.lean3;
        final int l4 = myShape.lean4;

        if ((int) (myShape.bY2 * 1000) / 1000 > (int) (myShape.highestY * 1000) / 1000 && myShape.lean2 == 0) {
            myShape.lean2 = 2;
        }
        if ((int) (myShape.startingY * 1000) / 1000 > (int) (myShape.highestY * 1000) / 1000 && myShape.lean4 == 0) {
            myShape.lean4 = 1;
        }
        if ((int) (myShape.bY3 * 1000) / 1000 < (int) (myShape.lowestY * 1000) / 1000
                && (int) (myShape.bY2 * 1000) / 1000 > (int) (myShape.highestY * 1000) / 1000 && myShape.lean2 == 0) {
            myShape.lean2 = 3;
        }
        if ((int) (myShape.bY3 * 1000) / 1000 < (int) (myShape.lowestY * 1000) / 1000
                && (int) (myShape.bY2 * 1000) / 1000 == (int) (myShape.highestY * 1000) / 1000 && myShape.lean2 == 0) {
            myShape.lean2 = 1;
        }
        if ((int) (myShape.bY4 * 1000) / 1000 < (int) (myShape.lowestY * 1000) / 1000
                && (int) (myShape.startingY * 1000) / 1000 > (int) (myShape.highestY * 1000) / 1000
                && myShape.lean4 == 0) {
            myShape.lean4 = 3;
        }
        if ((int) (myShape.bY4 * 1000) / 1000 < (int) (myShape.lowestY * 1000) / 1000
                && (int) (myShape.startingY * 1000) / 1000 == (int) (myShape.highestY * 1000) / 1000
                && myShape.lean4 == 0) {
            myShape.lean4 = 2;
        }
        if (myShape.noSidesTop == 1 && myShape.lean == 0) {
            if ((int) (myShape.startingX * 1000) / 1000 > (int) (myShape.bX4 * 1000) / 1000
                    && (int) (myShape.bX2 * 1000) / 1000 >= (int) (myShape.bX3 * 1000) / 1000) {
                myShape.lean = 2;
            }
            if ((int) (myShape.bX2 * 1000) / 1000 < (int) (myShape.bX3 * 1000) / 1000
                    && (int) (myShape.startingX * 1000) / 1000 <= (int) (myShape.bX4 * 1000) / 1000) {
                myShape.lean = 1;
            }
            if ((int) (myShape.startingX * 1000) / 1000 > (int) (myShape.bX4 * 1000) / 1000
                    && (int) (myShape.bX2 * 1000) / 1000 < (int) (myShape.bX3 * 1000) / 1000) {
                myShape.lean = 3;
            }

        }
        if (myShape.noSidesTop == 2 && myShape.lean == 0) {
            if ((int) (myShape.py1 * 1000) / 1000 > (int) (myShape.py2 * 1000) / 1000) {
                myShape.lean4 = 1;
                myShape.lean = 2;
            }
            if (myShape.py2 < myShape.py3) {
                myShape.lean2 = 2;
                myShape.lean = 1;
            }

        }
        if (myShape.noSidesTop == 3 && myShape.lean == 0) {
            if ((int) (myShape.py1 * 1000) / 1000 > (int) (myShape.py2 * 1000) / 1000) {
                myShape.lean4 = 1;
            }
            if ((int) (myShape.py3 * 1000) / 1000 < (int) (myShape.py4 * 1000) / 1000) {
                myShape.lean2 = 2;
            }
            myShape.lean = 0;
        }
        if (myShape.noSidesBot == 1 && myShape.lean3 == 0) {
            if ((int) (myShape.bX4 * 1000) / 1000 > (int) (myShape.startingX * 1000) / 1000
                    && (int) (myShape.bX2 * 1000) / 1000 >= (int) (myShape.bX3 * 1000) / 1000) {
                myShape.lean3 = 1;
            }
            if ((int) (myShape.bX2 * 1000) / 1000 > (int) (myShape.bX3 * 1000) / 1000
                    && (int) (myShape.startingX * 1000) / 1000 <= (int) (myShape.bX4 * 1000) / 1000) {
                myShape.lean3 = 2;
            }
            if ((int) (myShape.bX4 * 1000) / 1000 > (int) (myShape.startingX * 1000) / 1000
                    && (int) (myShape.bX2 * 1000) / 1000 > (int) (myShape.bX3 * 1000) / 1000) {
                myShape.lean3 = 3;
            }

        }

        if (myShape.noSidesBot == 2 && myShape.lean3 == 0) {
            if (myShape.noSidesTop == 1 && myShape.noSidesLeft == 1) {
                if (myShape.py3 == myShape.py4) {
                    myShape.lean3 = 1;
                } else {
                    myShape.lean3 = 2;
                }
            } else if (myShape.noSidesTop == 1 && myShape.noSidesLeft == 0) {
                if (myShape.py2 == myShape.py3) {
                    myShape.lean3 = 1;
                } else {
                    myShape.lean3 = 2;
                }
            } else if (myShape.noSidesTop == 2 && myShape.noSidesLeft == 1) {
                if (myShape.py4 == myShape.py5) {
                    myShape.lean3 = 1;
                } else {
                    myShape.lean3 = 2;
                }
            } else if (myShape.noSidesTop == 2 && myShape.noSidesLeft == 0) {
                if (myShape.py3 == myShape.py4) {
                    myShape.lean3 = 1;
                } else {
                    myShape.lean3 = 2;
                }
            } else if (myShape.noSidesTop == 3 && myShape.noSidesLeft == 1) {
                if (myShape.py5 == myShape.py6) {
                    myShape.lean3 = 1;
                } else {
                    myShape.lean3 = 2;
                }
            } else if (myShape.noSidesTop == 3 && myShape.noSidesLeft == 0) {
                if (myShape.py4 == myShape.py5) {
                    myShape.lean3 = 1;
                } else {
                    myShape.lean3 = 2;
                }
            }
        }
        if (myShape.noSidesBot == 3 && myShape.lean3 == 0) {
            myShape.lean2 = 3;
            myShape.lean3 = 3;
            myShape.lean4 = 3;
        }

        if (l1 != myShape.lean || l2 != myShape.lean2 || l3 != myShape.lean3 || l4 != myShape.lean4) {
            leanChanged = true;
        }
    }

    public double intersectXDOUBLE(final double x1, final double y1, final double x2, final double y2, final double bx1,
                                   final double by1, final double bx2, final double by2) {

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
            x = px + z * rx;// ,
            // (double)(py+z*ry));
        }
        return x;// , (double)(py+z*ry));

    } // end intersection line-line

    public double intersectX(final double x1, final double y1, final double x2, final double y2, final double bx1,
                             final double by1, final double bx2, final double by2) {

        BigDecimal x = new BigDecimal(0);
        final BigDecimal px = new BigDecimal(x1), py = new BigDecimal(y1),
                rx = new BigDecimal(x2).subtract(px), ry = new BigDecimal(y2).subtract(py);
        final BigDecimal qx = new BigDecimal(bx1), qy = new BigDecimal(by1),
                sx = new BigDecimal(bx2).subtract(qx), sy = new BigDecimal(by2).subtract(qy);

        final BigDecimal det = sx.multiply(ry).subtract(sy.multiply(rx));

        if (det.doubleValue() == 0) {
            return x.doubleValue();
        } else {
            BigDecimal pA = sx.multiply((qy.subtract(py)));
            BigDecimal pB = sy.multiply((px.subtract(qx)));
            final BigDecimal z = (pA.add(pB)).divide(det, 20, BigDecimal.ROUND_HALF_EVEN);
            // if (z == 0 || z == 1) {
            // return x; // intersection at end
            // point!
            // }
            //x = px + z * rx;// ,
            x = px.add((z.multiply(rx)));

            // (double)(py+z*ry));
        }
        return x.doubleValue();// , (double)(py+z*ry));

    } // end intersection line-line

    public double intersectYDOUBLE(final double x1, final double y1, final double x2, final double y2, final double bx1,
                                   final double by1, final double bx2, final double by2) {

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
            y = py + z * ry;
        }
        return y;
    } // end intersection l

    public double intersectY(final double x1, final double y1, final double x2, final double y2, final double bx1,
                             final double by1, final double bx2, final double by2) {

        BigDecimal y = new BigDecimal(0);
        final BigDecimal px = new BigDecimal(x1),
                py = new BigDecimal(y1), rx = new BigDecimal(x2).subtract(px),
                ry = new BigDecimal(y2).subtract(py);
        final BigDecimal qx = new BigDecimal(bx1), qy = new BigDecimal(by1),
                sx = new BigDecimal(bx2).subtract(qx), sy = new BigDecimal(by2).subtract(qy);

//	final double det = sx * ry - sy * rx;
        final BigDecimal det = sx.multiply(ry).subtract(sy.multiply(rx));
        if (det.doubleValue() == 0) {
            return y.doubleValue();
        } else {
//		final double z = (sx * (qy - py) + sy * (px - qx)) / det;
            BigDecimal pA = sx.multiply((qy.subtract(py)));
            BigDecimal pB = sy.multiply((px.subtract(qx)));
            final BigDecimal z = (pA.add(pB)).divide(det, 20, BigDecimal.ROUND_HALF_EVEN);
            // if (z == 0 || z == 1) {
            // return y; // intersection at end
            // point!
            // }
//		y = py + z * ry;
            y = py.add(z.multiply(ry));
        }
        return y.doubleValue();

    } // end intersection l

    public ShapeObject doarches(final ShapeObject myNewShape) {

        if (myParent.top1Part.partForm > 1 || myParent.top2Part.partForm > 1) {

            double[] myAngles = new double[4];

            if (myParent.noSidesTop == 2 && myParent.top1Part.partForm == 2 && myParent.top2Part.partForm == 2
                    && myParent.endCol == myParent.xCols && myParent.top1Part.partForm == 2 && myParent.noSidesTop == 1) {
                myAngles = this.getArchesTopGeneric(myParent, myNewShape.top1Part.startXC, myNewShape.top1Part.startYC,
                        myNewShape.top1Part.endXC, myNewShape.top1Part.endYC, myNewShape.top2Part.startXC,
                        myNewShape.top2Part.startYC, myNewShape.top2Part.endXC, myNewShape.top2Part.endYC, true);
                myNewShape.top1Part.startAngle = myAngles[0];
                myNewShape.top1Part.endAngle = myAngles[1];

            } else {

                myAngles = this.getArchesTopGeneric(myParent, myNewShape.top1Part.startXC, myNewShape.top1Part.startYC,
                        myNewShape.top1Part.endXC, myNewShape.top1Part.endYC, myNewShape.top2Part.startXC,
                        myNewShape.top2Part.startYC, myNewShape.top2Part.endXC, myNewShape.top2Part.endYC, false);

                myNewShape.top1Part.startAngle = myAngles[0];
                myNewShape.top1Part.endAngle = myAngles[1];
                myNewShape.top2Part.startAngle = myAngles[2];
                myNewShape.top2Part.endAngle = myAngles[3];

                myAngles = this.getArchesTopGeneric(myParent, myNewShape.top1Part.startXBA, myNewShape.top1Part.startYBA,
                        myNewShape.top1Part.endXBA, myNewShape.top1Part.endYBA, myNewShape.top2Part.startXBA,
                        myNewShape.top2Part.startYBA, myNewShape.top2Part.endXBA, myNewShape.top2Part.endYBA, false);

                myNewShape.top1Part.startAngleBA = myAngles[0];
                myNewShape.top1Part.endAngleBA = myAngles[1];
                myNewShape.top2Part.startAngleBA = myAngles[2];
                myNewShape.top2Part.endAngleBA = myAngles[3];

                myAngles = this.getArchesTopGeneric(myParent, myNewShape.top1Part.startXA, myNewShape.top1Part.startYA,
                        myNewShape.top1Part.endXA, myNewShape.top1Part.endYA, myNewShape.top2Part.startXA,
                        myNewShape.top2Part.startYA, myNewShape.top2Part.endXA, myNewShape.top2Part.endYA, false);

                myNewShape.top1Part.startAngleA = myAngles[0];
                myNewShape.top1Part.endAngleA = myAngles[1];
                myNewShape.top2Part.startAngleA = myAngles[2];
                myNewShape.top2Part.endAngleA = myAngles[3];

            }
        }
        return myNewShape;
    }

    public void getClearance(final ShapeObject myShape) {

        boolean t2Vertical = false;
        if (myParent.top2Part.startY < myParent.top2Part.endY) {
            t2Vertical = true;

        }

        // Clearance Dims calculated for Slopes

        top1Clearance = this.getDistance(myParent.top1Part.startX, myParent.top1Part.startY, myParent.top1Part.endX,
                myParent.top1Part.endY, myShape.clearanceTop, false, myParent.top1Part.partForm);

        top2Clearance = this.getDistance(myParent.top2Part.startX, myParent.top2Part.startY, myParent.top2Part.endX,
                myParent.top2Part.endY, myShape.clearanceTop, t2Vertical, myParent.top2Part.partForm);

        top3Clearance = this.getDistance(myParent.top3Part.startX, myParent.top3Part.startY, myParent.top3Part.endX,
                myParent.top3Part.endY, myShape.clearanceTop, false, myParent.top3Part.partForm);

        bot1Clearance = this.getDistance(myParent.bot1Part.startX, myParent.bot1Part.startY, myParent.bot1Part.endX,
                myParent.bot1Part.endY, myShape.clearanceBot, false, myParent.bot1Part.partForm);

        bot2Clearance = this.getDistance(myParent.bot2Part.startX, myParent.bot2Part.startY, myParent.bot2Part.endX,
                myParent.bot2Part.endY, myShape.clearanceBot, false, myParent.bot2Part.partForm);

        bot3Clearance = this.getDistance(myParent.bot3Part.startX, myParent.bot3Part.startY, myParent.bot3Part.endX,
                myParent.bot3Part.endY, myShape.clearanceBot, false, myParent.bot3Part.partForm);

        leftClearance = this.getDistance(myParent.leftPart.startX, myParent.leftPart.startY, myParent.leftPart.endX,
                myParent.leftPart.endY, myShape.clearanceLeft, true, myParent.leftPart.partForm);

        rightClearance = this.getDistance(myParent.rightPart.startX, myParent.rightPart.startY, myParent.rightPart.endX,
                myParent.rightPart.endY, myShape.clearanceRight, true, myParent.rightPart.partForm);

        // dimB calculated for Slopes

        if (leftDimBo > 0) {
            leftDimBo = leftDimBo;
        }

        top1DimB = this.getDistance(myParent.top1Part.startX, myParent.top1Part.startY, myParent.top1Part.endX,
                myParent.top1Part.endY, top1DimBo, false, myParent.top1Part.partForm);

        top2DimB = this.getDistance(myParent.top2Part.startX, myParent.top2Part.startY, myParent.top2Part.endX,
                myParent.top2Part.endY, top2DimBo, t2Vertical, myParent.top2Part.partForm);

        top3DimB = this.getDistance(myParent.top3Part.startX, myParent.top3Part.startY, myParent.top3Part.endX,
                myParent.top3Part.endY, top3DimBo, false, myParent.top3Part.partForm);

        leftDimB = this.getDistance(myParent.leftPart.startX, myParent.leftPart.startY, myParent.leftPart.endX,
                myParent.leftPart.endY, leftDimBo, true, myParent.leftPart.partForm);

        rightDimB = this.getDistance(myParent.rightPart.startX, myParent.rightPart.startY, myParent.rightPart.endX,
                myParent.rightPart.endY, rightDimBo, true, myParent.rightPart.partForm);

        bot1DimB = this.getDistance(myParent.bot1Part.startX, myParent.bot1Part.startY, myParent.bot1Part.endX,
                myParent.bot1Part.endY, bot1DimBo, false, myParent.bot1Part.partForm);

        bot2DimB = this.getDistance(myParent.bot2Part.startX, myParent.bot2Part.startY, myParent.bot2Part.endX,
                myParent.bot2Part.endY, bot2DimBo, false, myParent.bot2Part.partForm);

        bot3DimB = this.getDistance(myParent.bot3Part.startX, myParent.bot3Part.startY, myParent.bot3Part.endX,
                myParent.bot3Part.endY, bot3DimBo, false, myParent.bot3Part.partForm);

        // dimA calculated for Slopes

        top1DimA = this.getDistance(myParent.top1Part.startX, myParent.top1Part.startY, myParent.top1Part.endX,
                myParent.top1Part.endY, top1DimAo, false, myParent.top1Part.partForm);

        top2DimA = this.getDistance(myParent.top2Part.startX, myParent.top2Part.startY, myParent.top2Part.endX,
                myParent.top2Part.endY, top2DimAo, t2Vertical, myParent.top2Part.partForm);

        top3DimA = this.getDistance(myParent.top3Part.startX, myParent.top3Part.startY, myParent.top3Part.endX,
                myParent.top3Part.endY, top3DimAo, false, myParent.top3Part.partForm);

        leftDimA = this.getDistance(myParent.leftPart.startX, myParent.leftPart.startY, myParent.leftPart.endX,
                myParent.leftPart.endY, leftDimAo, true, myParent.leftPart.partForm);

        rightDimA = this.getDistance(myParent.rightPart.startX, myParent.rightPart.startY, myParent.rightPart.endX,
                myParent.rightPart.endY, rightDimAo, true, myParent.rightPart.partForm);

        bot1DimA = this.getDistance(myParent.bot1Part.startX, myParent.bot1Part.startY, myParent.bot1Part.endX,
                myParent.bot1Part.endY, bot1DimAo, false, myParent.bot1Part.partForm);

        bot2DimA = this.getDistance(myParent.bot2Part.startX, myParent.bot2Part.startY, myParent.bot2Part.endX,
                myParent.bot2Part.endY, bot2DimAo, false, myParent.bot2Part.partForm);

        bot3DimA = this.getDistance(myParent.bot3Part.startX, myParent.bot3Part.startY, myParent.bot3Part.endX,
                myParent.bot3Part.endY, bot3DimAo, false, myParent.bot3Part.partForm);

        // dimC calculated for Slopes

        top1DimC = this.getDistance(myParent.top1Part.startX, myParent.top1Part.startY, myParent.top1Part.endX,
                myParent.top1Part.endY, top1DimCo, false, myParent.top1Part.partForm);

        top2DimC = this.getDistance(myParent.top2Part.startX, myParent.top2Part.startY, myParent.top2Part.endX,
                myParent.top2Part.endY, top2DimCo, t2Vertical, myParent.top2Part.partForm);

        top3DimC = this.getDistance(myParent.top3Part.startX, myParent.top3Part.startY, myParent.top3Part.endX,
                myParent.top3Part.endY, top3DimCo, false, myParent.top3Part.partForm);

        leftDimC = this.getDistance(myParent.leftPart.startX, myParent.leftPart.startY, myParent.leftPart.endX,
                myParent.leftPart.endY, leftDimCo, true, myParent.leftPart.partForm);

        rightDimC = this.getDistance(myParent.rightPart.startX, myParent.rightPart.startY, myParent.rightPart.endX,
                myParent.rightPart.endY, rightDimCo, true, myParent.rightPart.partForm);

        bot1DimC = this.getDistance(myParent.bot1Part.startX, myParent.bot1Part.startY, myParent.bot1Part.endX,
                myParent.bot1Part.endY, bot1DimCo, false, myParent.bot1Part.partForm);

        bot2DimC = this.getDistance(myParent.bot2Part.startX, myParent.bot2Part.startY, myParent.bot2Part.endX,
                myParent.bot2Part.endY, bot2DimCo, false, myParent.bot2Part.partForm);

        bot3DimC = this.getDistance(myParent.bot3Part.startX, myParent.bot3Part.startY, myParent.bot3Part.endX,
                myParent.bot3Part.endY, bot3DimCo, false, myParent.bot3Part.partForm);

    }

    public void getClearanceBA(final ShapeObject myShape) {

        top1Clearance = this.getDistance(myParent.top1Part.startXBA, myParent.top1Part.startYBA, myParent.top1Part.endXBA,
                myParent.top1Part.endYBA, myShape.clearanceTop, false, myParent.top1Part.partForm);

        top2Clearance = this.getDistance(myParent.top2Part.startXBA, myParent.top2Part.startYBA, myParent.top2Part.endXBA,
                myParent.top2Part.endYBA, myShape.clearanceTop, false, myParent.top2Part.partForm);

        top3Clearance = this.getDistance(myParent.top3Part.startXBA, myParent.top3Part.startYBA, myParent.top3Part.endXBA,
                myParent.top3Part.endYBA, myShape.clearanceTop, false, myParent.top3Part.partForm);

        bot1Clearance = this.getDistance(myParent.bot1Part.startXBA, myParent.bot1Part.startYBA, myParent.bot1Part.endXBA,
                myParent.bot1Part.endYBA, myShape.clearanceBot, false, myParent.bot1Part.partForm);

        bot2Clearance = this.getDistance(myParent.bot2Part.startXBA, myParent.bot2Part.startYBA, myParent.bot2Part.endXBA,
                myParent.bot2Part.endYBA, myShape.clearanceBot, false, myParent.bot2Part.partForm);

        bot3Clearance = this.getDistance(myParent.bot3Part.startXBA, myParent.bot3Part.startYBA, myParent.bot3Part.endXBA,
                myParent.bot3Part.endYBA, myShape.clearanceBot, false, myParent.bot3Part.partForm);

        leftClearance = this.getDistance(myParent.leftPart.startXBA, myParent.leftPart.startYBA, myParent.leftPart.endXBA,
                myParent.leftPart.endYBA, myShape.clearanceLeft, true, myParent.leftPart.partForm);

        rightClearance = this.getDistance(myParent.rightPart.startXBA, myParent.rightPart.startYBA, myParent.rightPart.endXBA,
                myParent.rightPart.endYBA, myShape.clearanceRight, true, myParent.rightPart.partForm);

        top1DimB = this.getDistance(myParent.top1Part.startXBA, myParent.top1Part.startYBA, myParent.top1Part.endXBA,
                myParent.top1Part.endYBA, top1DimBo, false, myParent.top1Part.partForm)
                + top1Clearance;

        top2DimB = this.getDistance(myParent.top2Part.startXBA, myParent.top2Part.startYBA, myParent.top2Part.endXBA,
                myParent.top2Part.endYBA, top2DimBo, false, myParent.top2Part.partForm)
                + top2Clearance;

        top3DimB = this.getDistance(myParent.top3Part.startXBA, myParent.top3Part.startYBA, myParent.top3Part.endXBA,
                myParent.top3Part.endYBA, top3DimBo, false, myParent.top3Part.partForm)
                + top3Clearance;

        leftDimB = this.getDistance(myParent.leftPart.startXBA, myParent.leftPart.startYBA, myParent.leftPart.endXBA,
                myParent.leftPart.endYBA, leftDimBo, true, myParent.leftPart.partForm)
                + leftClearance;

        rightDimB = this.getDistance(myParent.rightPart.startXBA, myParent.rightPart.startYBA, myParent.rightPart.endXBA,
                myParent.rightPart.endYBA, rightDimBo, true, myParent.rightPart.partForm)
                + rightClearance;

        bot1DimB = this.getDistance(myParent.bot1Part.startXBA, myParent.bot1Part.startYBA, myParent.bot1Part.endXBA,
                myParent.bot1Part.endYBA, bot1DimBo, false, myParent.bot1Part.partForm)
                + bot1Clearance;

        bot2DimB = this.getDistance(myParent.bot2Part.startXBA, myParent.bot2Part.startYBA, myParent.bot2Part.endXBA,
                myParent.bot2Part.endYBA, bot2DimBo, false, myParent.bot2Part.partForm)
                + bot2Clearance;

        bot3DimB = this.getDistance(myParent.bot3Part.startXBA, myParent.bot3Part.startYBA, myParent.bot3Part.endXBA,
                myParent.bot3Part.endYBA, bot3DimBo, false, myParent.bot3Part.partForm)
                + bot3Clearance;
        // ///////////////////////////
        top1DimA = this.getDistance(myParent.top1Part.startXBA, myParent.top1Part.startYBA, myParent.top1Part.endXBA,
                myParent.top1Part.endYBA, top1DimAo, false, myParent.top1Part.partForm)
                + top1Clearance;

        top2DimA = this.getDistance(myParent.top2Part.startXBA, myParent.top2Part.startYBA, myParent.top2Part.endXBA,
                myParent.top2Part.endYBA, top2DimAo, false, myParent.top2Part.partForm)
                + top2Clearance;

        top3DimA = this.getDistance(myParent.top3Part.startXBA, myParent.top3Part.startYBA, myParent.top3Part.endXBA,
                myParent.top3Part.endYBA, top3DimAo, false, myParent.top3Part.partForm)
                + top3Clearance;

        leftDimA = this.getDistance(myParent.leftPart.startXBA, myParent.leftPart.startYBA, myParent.leftPart.endXBA,
                myParent.leftPart.endYBA, leftDimAo, true, myParent.leftPart.partForm)
                + leftClearance;

        rightDimA = this.getDistance(myParent.rightPart.startXBA, myParent.rightPart.startYBA, myParent.rightPart.endXBA,
                myParent.rightPart.endYBA, rightDimAo, true, myParent.rightPart.partForm)
                + rightClearance;

        bot1DimA = this.getDistance(myParent.bot1Part.startXBA, myParent.bot1Part.startYBA, myParent.bot1Part.endXBA,
                myParent.bot1Part.endYBA, bot1DimAo, false, myParent.bot1Part.partForm)
                + bot1Clearance;

        bot2DimA = this.getDistance(myParent.bot2Part.startXBA, myParent.bot2Part.startYBA, myParent.bot2Part.endXBA,
                myParent.bot2Part.endYBA, bot2DimAo, false, myParent.bot2Part.partForm)
                + bot2Clearance;

        bot3DimA = this.getDistance(myParent.bot3Part.startXBA, myParent.bot3Part.startYBA, myParent.bot3Part.endXBA,
                myParent.bot3Part.endYBA, bot3DimAo, false, myParent.bot3Part.partForm)
                + bot3Clearance;

        // /////////////////////////
        top1DimC = this.getDistance(myParent.top1Part.startXBA, myParent.top1Part.startYBA, myParent.top1Part.endXBA,
                myParent.top1Part.endYBA, top1DimCo, false, myParent.top1Part.partForm)
                + top1Clearance;

        top2DimC = this.getDistance(myParent.top2Part.startXBA, myParent.top2Part.startYBA, myParent.top2Part.endXBA,
                myParent.top2Part.endYBA, top2DimCo, false, myParent.top2Part.partForm)
                + top2Clearance;

        top3DimC = this.getDistance(myParent.top3Part.startXBA, myParent.top3Part.startYBA, myParent.top3Part.endXBA,
                myParent.top3Part.endYBA, top3DimCo, false, myParent.top3Part.partForm)
                + top3Clearance;

        leftDimC = this.getDistance(myParent.leftPart.startXBA, myParent.leftPart.startYBA, myParent.leftPart.endXBA,
                myParent.leftPart.endYBA, leftDimCo, true, myParent.leftPart.partForm)
                + leftClearance;

        rightDimC = this.getDistance(myParent.rightPart.startXBA, myParent.rightPart.startYBA, myParent.rightPart.endXBA,
                myParent.rightPart.endYBA, rightDimCo, true, myParent.rightPart.partForm)
                + rightClearance;

        bot1DimC = this.getDistance(myParent.bot1Part.startXBA, myParent.bot1Part.startYBA, myParent.bot1Part.endXBA,
                myParent.bot1Part.endYBA, bot1DimCo, false, myParent.bot1Part.partForm)
                + bot1Clearance;

        bot2DimC = this.getDistance(myParent.bot2Part.startXBA, myParent.bot2Part.startYBA, myParent.bot2Part.endXBA,
                myParent.bot2Part.endYBA, bot2DimCo, false, myParent.bot2Part.partForm)
                + bot2Clearance;

        bot3DimC = this.getDistance(myParent.bot3Part.startXBA, myParent.bot3Part.startYBA, myParent.bot3Part.endXBA,
                myParent.bot3Part.endYBA, bot3DimCo, false, myParent.bot3Part.partForm)
                + bot3Clearance;

    }

    public void getClearanceA(final ShapeObject myShape) {

        top1Clearance = this.getDistance(myParent.top1Part.startXA, myParent.top1Part.startYA, myParent.top1Part.endXA,
                myParent.top1Part.endYA, myShape.clearanceTop, false, myParent.top1Part.partForm);

        top2Clearance = this.getDistance(myParent.top2Part.startXA, myParent.top2Part.startYA, myParent.top2Part.endXA,
                myParent.top2Part.endYA, myShape.clearanceTop, false, myParent.top2Part.partForm);

        top3Clearance = this.getDistance(myParent.top3Part.startXA, myParent.top3Part.startYA, myParent.top3Part.endXA,
                myParent.top3Part.endYA, myShape.clearanceTop, false, myParent.top3Part.partForm);

        bot1Clearance = this.getDistance(myParent.bot1Part.startXA, myParent.bot1Part.startYA, myParent.bot1Part.endXA,
                myParent.bot1Part.endYA, myShape.clearanceBot, false, myParent.bot1Part.partForm);

        bot2Clearance = this.getDistance(myParent.bot2Part.startXA, myParent.bot2Part.startYA, myParent.bot2Part.endXA,
                myParent.bot2Part.endYA, myShape.clearanceBot, false, myParent.bot2Part.partForm);

        bot3Clearance = this.getDistance(myParent.bot3Part.startXA, myParent.bot3Part.startYA, myParent.bot3Part.endXA,
                myParent.bot3Part.endYA, myShape.clearanceBot, false, myParent.bot3Part.partForm);

        leftClearance = this.getDistance(myParent.leftPart.startXA, myParent.leftPart.startYA, myParent.leftPart.endXA,
                myParent.leftPart.endYA, myShape.clearanceLeft, true, myParent.leftPart.partForm);

        rightClearance = this.getDistance(myParent.rightPart.startXA, myParent.rightPart.startYA, myParent.rightPart.endXA,
                myParent.rightPart.endYA, myShape.clearanceRight, true, myParent.rightPart.partForm);

        top1DimB = this.getDistance(myParent.top1Part.startXA, myParent.top1Part.startYA, myParent.top1Part.endXA,
                myParent.top1Part.endYA, top1DimBo, false, myParent.top1Part.partForm)
                + top1Clearance;

        top2DimB = this.getDistance(myParent.top2Part.startXA, myParent.top2Part.startYA, myParent.top2Part.endXA,
                myParent.top2Part.endYA, top2DimBo, false, myParent.top2Part.partForm)
                + top2Clearance;

        top3DimB = this.getDistance(myParent.top3Part.startXA, myParent.top3Part.startYA, myParent.top3Part.endXA,
                myParent.top3Part.endYA, top3DimBo, false, myParent.top3Part.partForm)
                + top3Clearance;

        leftDimB = this.getDistance(myParent.leftPart.startXA, myParent.leftPart.startYA, myParent.leftPart.endXA,
                myParent.leftPart.endYA, leftDimBo, true, myParent.leftPart.partForm)
                + leftClearance;

        rightDimB = this.getDistance(myParent.rightPart.startXA, myParent.rightPart.startYA, myParent.rightPart.endXA,
                myParent.rightPart.endYA, rightDimBo, true, myParent.rightPart.partForm)
                + rightClearance;

        bot1DimB = this.getDistance(myParent.bot1Part.startXA, myParent.bot1Part.startYA, myParent.bot1Part.endXA,
                myParent.bot1Part.endYA, bot1DimBo, false, myParent.bot1Part.partForm)
                + bot1Clearance;

        bot2DimB = this.getDistance(myParent.bot2Part.startXA, myParent.bot2Part.startYA, myParent.bot2Part.endXA,
                myParent.bot2Part.endYA, bot2DimBo, false, myParent.bot2Part.partForm)
                + bot2Clearance;

        bot3DimB = this.getDistance(myParent.bot3Part.startXA, myParent.bot3Part.startYA, myParent.bot3Part.endXA,
                myParent.bot3Part.endYA, bot3DimBo, false, myParent.bot3Part.partForm)
                + bot3Clearance;
        // ///////////////////////////
        top1DimA = this.getDistance(myParent.top1Part.startXA, myParent.top1Part.startYA, myParent.top1Part.endXA,
                myParent.top1Part.endYA, top1DimAo, false, myParent.top1Part.partForm)
                + top1Clearance;

        top2DimA = this.getDistance(myParent.top2Part.startXA, myParent.top2Part.startYA, myParent.top2Part.endXA,
                myParent.top2Part.endYA, top2DimAo, false, myParent.top2Part.partForm)
                + top2Clearance;

        top3DimA = this.getDistance(myParent.top3Part.startXA, myParent.top3Part.startYA, myParent.top3Part.endXA,
                myParent.top3Part.endYA, top3DimAo, false, myParent.top3Part.partForm)
                + top3Clearance;

        leftDimA = this.getDistance(myParent.leftPart.startXA, myParent.leftPart.startYA, myParent.leftPart.endXA,
                myParent.leftPart.endYA, leftDimAo, true, myParent.leftPart.partForm)
                + leftClearance;

        rightDimA = this.getDistance(myParent.rightPart.startXA, myParent.rightPart.startYA, myParent.rightPart.endXA,
                myParent.rightPart.endYA, rightDimAo, true, myParent.rightPart.partForm)
                + rightClearance;

        bot1DimA = this.getDistance(myParent.bot1Part.startXA, myParent.bot1Part.startYA, myParent.bot1Part.endXA,
                myParent.bot1Part.endYA, bot1DimAo, false, myParent.bot1Part.partForm)
                + bot1Clearance;

        bot2DimA = this.getDistance(myParent.bot2Part.startXA, myParent.bot2Part.startYA, myParent.bot2Part.endXA,
                myParent.bot2Part.endYA, bot2DimAo, false, myParent.bot3Part.partForm)
                + bot2Clearance;

        bot3DimA = this.getDistance(myParent.bot3Part.startXA, myParent.bot3Part.startYA, myParent.bot3Part.endXA,
                myParent.bot3Part.endYA, bot3DimAo, false, myParent.bot3Part.partForm)
                + bot3Clearance;

        // /////////////////////////
        top1DimC = this.getDistance(myParent.top1Part.startXA, myParent.top1Part.startYA, myParent.top1Part.endXA,
                myParent.top1Part.endYA, top1DimCo, false, myParent.top1Part.partForm)
                + top1Clearance;

        top2DimC = this.getDistance(myParent.top2Part.startXA, myParent.top2Part.startYA, myParent.top2Part.endXA,
                myParent.top2Part.endYA, top2DimCo, false, myParent.top2Part.partForm)
                + top2Clearance;

        top3DimC = this.getDistance(myParent.top3Part.startXA, myParent.top3Part.startYA, myParent.top3Part.endXA,
                myParent.top3Part.endYA, top3DimCo, false, myParent.top3Part.partForm)
                + top3Clearance;

        leftDimC = this.getDistance(myParent.leftPart.startXA, myParent.leftPart.startYA, myParent.leftPart.endXA,
                myParent.leftPart.endYA, leftDimCo, true, myParent.leftPart.partForm)
                + leftClearance;

        rightDimC = this.getDistance(myParent.rightPart.startXA, myParent.rightPart.startYA, myParent.rightPart.endXA,
                myParent.rightPart.endYA, rightDimCo, true, myParent.rightPart.partForm)
                + rightClearance;

        bot1DimC = this.getDistance(myParent.bot1Part.startXA, myParent.bot1Part.startYA, myParent.bot1Part.endXA,
                myParent.bot1Part.endYA, bot1DimCo, false, myParent.bot1Part.partForm)
                + bot1Clearance;

        bot2DimC = this.getDistance(myParent.bot2Part.startXA, myParent.bot2Part.startYA, myParent.bot2Part.endXA,
                myParent.bot2Part.endYA, bot2DimCo, false, myParent.bot2Part.partForm)
                + bot2Clearance;

        bot3DimC = this.getDistance(myParent.bot3Part.startXA, myParent.bot3Part.startYA, myParent.bot3Part.endXA,
                myParent.bot3Part.endYA, bot3DimCo, false, myParent.bot3Part.partForm)
                + bot3Clearance;

    }

    private double getDistance(final double x1, final double y1, final double x2, final double y2, final double clearance,
                               final boolean isTan, final int partForm) {

        double distance = clearance;
        if (partForm < 2) {
            double slopeofBLimit = 0;
            if (isTan) {
                slopeofBLimit = (Math.max(y1, y2) - Math.min(y1, y2)) / (Math.max(x1, x2) - Math.min(x1, x2));
            } else {
                slopeofBLimit = (x2 - x1) / (y2 - y1);
            }

            double theta = 0;
            if (!Double.isInfinite(slopeofBLimit) && !Double.isNaN(slopeofBLimit)) {

                theta = Math.atan(slopeofBLimit);

                if (Math.toDegrees(theta) > 90) {
                    theta = Math.toRadians(180) - theta;
                }
                if (theta != 0) {
                    distance = clearance / Math.abs(Math.sin(theta));
                }
            }
        }

        return distance;
    }

    public GeneralPath doGeneralPathGlass(final Profiles part) {

        final GeneralPath myOpen = new GeneralPath();

        myOpen.moveTo(part.startYBA, part.startYC);

        if (part.partForm == 2) {
            final Arc2D mytopb = new Arc2D.Double(part.bkgrdStartXBA, part.bkgrdStartYBA, part.bkgrdWidthBA,
                    part.bkgrdHeightBA, part.startAngleBA, part.endAngleBA, Arc2D.OPEN);

            xCoordB = new ArrayList();
            yCoordB = new ArrayList();
            this.getPoints(mytopb, 1, part.startXC);

            xCoordBo = xCoordB.toArray();
            yCoordBo = yCoordB.toArray();

            myOpen.moveTo(part.startXC, part.startYC);

            for (int i = xCoordBo.length; i >= 1; i--) {
                if ((Double) xCoordBo[i - 1] >= 0) {
                    myOpen.lineTo(((Double) xCoordBo[i - 1]), ((Double) yCoordBo[i - 1]));
                }
            }

        } else {
            myOpen.lineTo(part.endXC, part.endYC);

        }
        myOpen.lineTo(part.endXA, part.endYA);

        if (part.partForm == 2) {

            final Arc2D mytopa = new Arc2D.Double(part.bkgrdStartXA, part.bkgrdStartYA, part.bkgrdWidthA, part.bkgrdHeightA,
                    part.startAngleA, part.endAngleA, Arc2D.OPEN);
            xCoordB = new ArrayList();
            yCoordB = new ArrayList();
            this.getPoints(mytopa, 1, part.startXA);

            xCoordBo = xCoordB.toArray();
            yCoordBo = yCoordB.toArray();

            // myOpen.moveTo((int) part.startXA,
            // (int)
            // part.startYA);

            for (int i = 0; i < xCoordBo.length; i++) {
                // if ((Double) xCoordBo[i +
                // 1] >= 0)
                // {
                myOpen.lineTo(((Double) xCoordBo[i]), ((Double) yCoordBo[i]));
                // }
            }

            // myOpen.moveTo((int) part.startXA,
            // (int)
            // part.startYA);
        } else {
            myOpen.lineTo(part.startXA, part.startYA);
        }

        myOpen.lineTo(part.startXC, part.startYC);

        return myOpen;

    }

    public GeneralPath doGeneralPathOpening(final ShapeObject opening) {

        final GeneralPath myOpen = new GeneralPath();

        myOpen.moveTo((int) opening.top1Part.startXC, (int) opening.top1Part.startYC);

        if (opening.top1Part.partForm == 2)

        {
            myOpen.moveTo((int) opening.top1Part.endXC, (int) opening.top1Part.endYC);
            final Arc2D mytop = new Arc2D.Double(opening.top1Part.bkgrdStartX, opening.top1Part.bkgrdStartY,
                    opening.top1Part.bkgrdWidth, opening.top1Part.bkgrdHeight, opening.top1Part.startAngle,
                    opening.top1Part.endAngle, Arc2D.OPEN);
            myOpen.append(mytop, false);
            myOpen.moveTo((int) opening.top1Part.endXC, (int) opening.top1Part.endYC);
        } else {
            myOpen.lineTo((int) opening.top1Part.endXC, (int) opening.top1Part.endYC);
        }

        if (opening.noSidesTop == 2) {
            if (opening.top2Part.partForm == 2) {
                myOpen.moveTo((int) opening.top2Part.endXC, (int) opening.top2Part.endYC);
                final Arc2D mytop2 = new Arc2D.Double(opening.top2Part.bkgrdStartX, opening.top2Part.bkgrdStartY,
                        opening.top2Part.bkgrdWidth, opening.top2Part.bkgrdHeight, opening.top2Part.startAngle,
                        opening.top2Part.endAngle, Arc2D.OPEN);
                myOpen.append(mytop2, false);
                myOpen.moveTo((int) opening.top2Part.endXC, (int) opening.top2Part.endYC);
            } else {
                myOpen.lineTo((int) opening.top2Part.endXC, (int) opening.top2Part.endYC);
            }

        } else if (opening.noSidesTop == 3) {

            myOpen.lineTo((int) opening.top3Part.endXC, (int) opening.top3Part.endYC);

            if (opening.top2Part.partForm == 2) {
                myOpen.moveTo((int) opening.top2Part.endXC, (int) opening.top2Part.endYC);
                final Arc2D mytop3 = new Arc2D.Double(opening.top2Part.bkgrdStartX, opening.top2Part.bkgrdStartY,
                        opening.top2Part.bkgrdWidth, opening.top2Part.bkgrdHeight, opening.top2Part.startAngle,
                        opening.top2Part.endAngle, Arc2D.OPEN);
                myOpen.append(mytop3, false);
                myOpen.moveTo((int) opening.top2Part.endXC, (int) opening.top2Part.endYC);
            } else {
                myOpen.lineTo((int) opening.top2Part.endXC, (int) opening.top2Part.endYC);
            }
        }

        if (opening.noSidesRight == 1) {

            myOpen.lineTo((int) opening.rightPart.endXC, (int) opening.rightPart.endYC);

        }
        // myOpen.moveTo((int) ((OpeningObject)
        // element).bot1.startX,
        // (int) opening.bot1Part.startY);
        if (opening.noSidesBot == 1 || opening.noSidesBot == 2) {
            if (opening.bot1Part.partForm == 2) {
                final Arc2D mytop4 = new Arc2D.Double(opening.bot1Part.bkgrdStartX, opening.bot1Part.bkgrdStartY,
                        opening.bot1Part.bkgrdWidth, opening.bot1Part.bkgrdHeight, opening.bot1Part.startAngle,
                        opening.bot1Part.endAngle, Arc2D.OPEN);
                myOpen.append(mytop4, false);
            } else {
                myOpen.lineTo((int) opening.bot1Part.endXC, (int) opening.bot1Part.endYC);
            }
            if (opening.bot2Part.partForm == 2 && opening.noSidesBot == 2) {
                final Arc2D mytop5 = new Arc2D.Double(opening.bot2Part.bkgrdStartX, opening.bot2Part.bkgrdStartY,
                        opening.bot2Part.bkgrdWidth, opening.bot2Part.bkgrdHeight, opening.bot2Part.startAngle,
                        opening.bot2Part.endAngle, Arc2D.OPEN);
                myOpen.append(mytop5, false);
            } else if (opening.bot2Part.partForm == 1 && opening.noSidesBot == 2) {
                myOpen.lineTo((int) opening.bot2Part.endXC, (int) opening.bot2Part.endYC);
            }
        } else if (opening.noSidesBot == 3) {
            if (opening.bot3Part.partForm == 2) {
                final Arc2D mytop6 = new Arc2D.Double(opening.bot3Part.bkgrdStartX, opening.bot3Part.bkgrdStartY,
                        opening.bot3Part.bkgrdWidth, opening.bot3Part.bkgrdHeight, opening.bot3Part.startAngle,
                        opening.bot3Part.endAngle, Arc2D.OPEN);
                myOpen.append(mytop6, false);
            } else {
                myOpen.lineTo((int) opening.bot3Part.endXC, (int) opening.bot3Part.endYC);
            }
            if (opening.bot1Part.partForm == 2) {
                Arc2D mytop7 = new Arc2D.Double(opening.bot1Part.bkgrdStartX, opening.bot1Part.bkgrdStartY,
                        opening.bot1Part.bkgrdWidth, opening.bot1Part.bkgrdHeight, opening.bot1Part.startAngle,
                        opening.bot1Part.endAngle, Arc2D.OPEN);
                myOpen.append(mytop7, false);
            } else {
                myOpen.lineTo((int) opening.bot1Part.endXC, (int) opening.bot1Part.endYC);
            }
            if (opening.bot2Part.partForm == 2) {
                Arc2D mytop8 = new Arc2D.Double(opening.bot2Part.bkgrdStartX, opening.bot2Part.bkgrdStartY,
                        opening.bot2Part.bkgrdWidth, opening.bot2Part.bkgrdHeight, opening.bot2Part.startAngle,
                        opening.bot2Part.endAngle, Arc2D.OPEN);
                myOpen.append(mytop8, false);
            } else {
                myOpen.lineTo((int) opening.bot2Part.endXC, (int) opening.bot2Part.endYC);
            }

        }

        if (opening.noSidesLeft == 1) {
            myOpen.lineTo((int) opening.leftPart.endXC, (int) opening.leftPart.endYC);
        }

        return myOpen;

    }

    /**
	 * Do General Path Opening II
	 * 
	 * @param opening
	 *             , ShapeObject
	 * @return GeneralPath
	 */
    public GeneralPath doGeneralPathOpeningII(ShapeObject opening) {

        GeneralPath myOpen = new GeneralPath();

        if (opening.noSidesTop > 1) {

            myOpen.moveTo((int) opening.top2Part.endXC, (int) opening.top2Part.endYC);

            if (opening.top2Part.partForm >= 2) {
                Arc2D mytop = new Arc2D.Double(opening.top2Part.bkgrdStartX, opening.top2Part.bkgrdStartY,
                        opening.top2Part.bkgrdWidth, opening.top2Part.bkgrdHeight, opening.top2Part.startAngle,
                        opening.top2Part.endAngle, Arc2D.OPEN);
                myOpen.append(mytop, false);
            } else {
                myOpen.lineTo((int) opening.top2Part.startXC, (int) opening.top2Part.startYC);
            }

            if (opening.top3Part.posInUse && opening.top3Part.startXC > 0 && opening.top3Part.startYC > 0) {
                myOpen.lineTo((int) opening.top3Part.startXC, (int) opening.top3Part.startYC);
            }

            if (opening.top1Part.partForm == 1) {
                myOpen.lineTo((int) opening.top1Part.startXC, (int) opening.top1Part.startYC);
            } else if (opening.top1Part.partForm >= 2) {
                Arc2D mytop = new Arc2D.Double(opening.top1Part.bkgrdStartX, opening.top1Part.bkgrdStartY,
                        opening.top1Part.bkgrdWidth, opening.top1Part.bkgrdHeight, opening.top1Part.startAngle,
                        opening.top1Part.endAngle, Arc2D.OPEN);
                myOpen.append(mytop, false);
            }
            if (opening.leftPart.posInUse && opening.noSidesLeft == 1) {
                myOpen.lineTo((int) opening.leftPart.startXC, (int) opening.leftPart.startYC);
            }

            if (opening.noSidesBot == 1) {
                myOpen.lineTo((int) opening.bot1Part.startXC, (int) opening.bot1Part.startYC);
            } else {
                if (opening.noSidesBot == 2) {
                    myOpen.lineTo((int) opening.bot2Part.startXC, (int) opening.bot2Part.startYC);
                    myOpen.lineTo((int) opening.bot1Part.startXC, (int) opening.bot1Part.startYC);
                } else if (opening.noSidesBot == 3) {
                    myOpen.lineTo((int) opening.bot2Part.startXC, (int) opening.bot2Part.startYC);
                    myOpen.lineTo((int) opening.bot3Part.startXC, (int) opening.bot3Part.startYC);
                    myOpen.lineTo((int) opening.bot1Part.startXC, (int) opening.bot1Part.startYC);
                }

            }
            if (opening.rightPart.posInUse && opening.noSidesRight == 1) {
                myOpen.lineTo((int) opening.rightPart.startXC, (int) opening.rightPart.startYC);
            }

        }

        if (opening.noSidesTop == 1) {

            myOpen.moveTo((int) opening.top1Part.endXC, (int) opening.top1Part.endYC);

            if (opening.top1Part.partForm >= 2) {
                Arc2D mytop = new Arc2D.Double(opening.top1Part.bkgrdStartX, opening.top1Part.bkgrdStartY,
                        opening.top1Part.bkgrdWidth, opening.top1Part.bkgrdHeight, opening.top1Part.startAngle,
                        opening.top1Part.endAngle, Arc2D.OPEN);
                myOpen.append(mytop, false);
            } else {
                myOpen.lineTo((int) opening.top1Part.startXC, (int) opening.top1Part.startYC);
            }
            if (opening.leftPart.posInUse && opening.noSidesLeft == 1) {
                myOpen.lineTo((int) opening.leftPart.startXC, (int) opening.leftPart.startYC);
            }
            if (opening.noSidesBot == 1) {
                if (opening.bot1Part.partForm == 1) {
                    myOpen.lineTo((int) opening.bot1Part.startXC, (int) opening.bot1Part.startYC);
                }
                if (opening.bot1Part.partForm >= 2) {
                    Arc2D myBot = new Arc2D.Double(opening.bot1Part.bkgrdStartX, opening.bot1Part.bkgrdStartY,
                            opening.bot1Part.bkgrdWidth, opening.bot1Part.bkgrdHeight, opening.bot1Part.startAngle,
                            opening.bot1Part.endAngle, Arc2D.OPEN);
                    myOpen.append(myBot, false);
                }
            } else {
                if (opening.noSidesBot == 2) {
                    myOpen.lineTo((int) opening.bot2Part.startXC, (int) opening.bot2Part.startYC);
                    myOpen.lineTo((int) opening.bot1Part.startXC, (int) opening.bot1Part.startYC);
                } else if (opening.noSidesBot == 3) {
                    myOpen.lineTo((int) opening.bot2Part.startXC, (int) opening.bot2Part.startYC);
                    myOpen.lineTo((int) opening.bot3Part.startXC, (int) opening.bot3Part.startYC);
                    myOpen.lineTo((int) opening.bot1Part.startXC, (int) opening.bot1Part.startYC);
                }

            }
            if (opening.rightPart.posInUse && opening.noSidesRight == 1) {
                myOpen.lineTo((int) opening.rightPart.startXC, (int) opening.rightPart.startYC);
            }
        }

        return myOpen;

    }

    public GeneralPath doGeneralPathLouvre(ShapeObject opening) {

        GeneralPath myOpen = new GeneralPath();

        SeriesValidOpeningShape s = ItemFrame.getApplicationBaseRules().getSeriesValidOpeningById(opening.userDefinedOpeningID);
        double overlap = 0;

        if (myFrame2.mySeries.getSeriesUom() == 1) {

            overlap = new BigDecimal(s.getLouvreoverlap()).multiply(
                    myFrame2.metricscale).doubleValue();

        } else {


            overlap = new BigDecimal(s.getLouvreoverlapi()).multiply(
                    myFrame2.imperialscale).doubleValue();

        }

        myOpen.moveTo((int) opening.px1 + 2, (int) opening.py1 + 1);
        myOpen.lineTo((int) opening.px2 - 2, (int) opening.py2 + 1);

        if (opening.trackNo == 1) {
            myOpen.lineTo((int) opening.px3 - 2, (int) opening.py3);
            myOpen.lineTo((int) opening.px4 + 2, (int) opening.py4);
        } else {
            myOpen.lineTo((int) opening.px3 - 2, (int) opening.py3 + overlap);
            myOpen.lineTo((int) opening.px4 + 2, (int) opening.py4 + overlap);
        }
        myOpen.lineTo((int) opening.px1 + 2, (int) opening.py1);


        return myOpen;

    }

    public void getPoints(final Arc2D arc, final int topBot, final double startX) {

        final double flatness = 0.000001f;
        final PathIterator pit = arc.getPathIterator(null, flatness);
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
                        if (topBot == 1) {
                            if (myX >= startX) {

                                xCoordB.add(myX);
                                yCoordB.add(myY);
                            }
                        } else {
                            if (myX <= startX) {

                                xCoordB.add(myX);
                                yCoordB.add(myY);
                            }
                        }
                    }
                    count++;
                    break;
                default:
                    System.out.println("unexpected type: " + type);
            }
            pit.next();
        }
    }

    /**
	 * Do GeneralPath Parts Object ShapeObject
	 * 
	 * @param partObjects
	 *             , Collection
	 * @param myShape
	 *             , ShapeObject
	 * @param doBA
	 *             , boolean
	 * @return Collection
	 */
    public Collection doGPParts(Collection partObjects, ShapeObject myShape, boolean doBA) {

        Object[] myparts = partObjects.toArray();
        partObjects.clear();

        for (Object P : myparts) {
            if (!((Profiles) P).remove) {
                if (((Profiles) P).partForm == 1) {

                    ((Profiles) P).gp = ((Profiles) P).doGPProfiles(((Profiles) P), myShape.widthPix, myShape.heightPix,
                            myShape.shapeID, myShape.top1Part, myShape.bot1Part, 0, myShape.leftIn, myShape.rightIn,
                            doBA);
                    ((Profiles) P).polygon = ((Profiles) P).doGPProfilesPoly(((Profiles) P), myShape.widthPix,
                            myShape.heightPix, myShape.shapeID, myShape.top1Part, myShape.bot1Part, 0,
                            myShape.leftIn, myShape.rightIn);

                } else if (((Profiles) P).partForm > 1) {

                    ((Profiles) P).gp = ((Profiles) P).doGPProfiles(((Profiles) P), myShape.widthPix, myShape.heightPix,
                            myShape.shapeID, myShape.top1Part, myShape.bot1Part, 0, myShape.leftIn, myShape.rightIn,
                            doBA);
                    ((Profiles) P).curveB = ((Profiles) P).doGPProfiles(((Profiles) P), myShape.widthPix, myShape.heightPix,
                            myShape.shapeID, myShape.top1Part, myShape.bot1Part, 1, myShape.leftIn, myShape.rightIn,
                            doBA);

                    ((Profiles) P).curveBA = ((Profiles) P).doGPProfiles(((Profiles) P), myShape.widthPix,
                            myShape.heightPix, myShape.shapeID, myShape.top1Part, myShape.bot1Part, 2,
                            myShape.leftIn, myShape.rightIn, doBA);

                    ((Profiles) P).curveA = ((Profiles) P).doGPProfiles(((Profiles) P), myShape.widthPix, myShape.heightPix,
                            myShape.shapeID, myShape.top1Part, myShape.bot1Part, 3, myShape.leftIn, myShape.rightIn,
                            doBA);

                }

                // ((Profiles) P).rgb_R = 255;
                // ((Profiles) P).rgb_G = 255;
                // ((Profiles) P).rgb_B = 255;

                partObjects.add(P);
            } else {
                partObjects.add(P);
            }
        }

        return partObjects;
    }

    public Collection doGPPartsBEADS(Collection partObjects, ShapeObject myShape, boolean doBA) {

        Object[] myparts = partObjects.toArray();
        partObjects.clear();

        for (Object P : myparts) {

            if (!((Profiles) P).remove) {

                if (((Profiles) P).partForm == 1) {

                    ((Profiles) P).gp = ((Profiles) P).doGPProfiles(((Profiles) P), myShape.widthPix, myShape.heightPix,
                            myShape.shapeID, myShape.top1Part, myShape.bot1Part, 0, myShape.leftIn, myShape.rightIn,
                            doBA);

                    ((Profiles) P).polygon = ((Profiles) P).doGPProfilesPoly(((Profiles) P), myShape.widthPix,
                            myShape.heightPix, myShape.shapeID, myShape.top1Part, myShape.bot1Part, 0,
                            myShape.leftIn, myShape.rightIn);

                } else if (((Profiles) P).partForm > 1) {

                    ((Profiles) P).gp = ((Profiles) P).doGPProfiles(((Profiles) P), myShape.widthPix, myShape.heightPix,
                            myShape.shapeID, myShape.top1Part, myShape.bot1Part, 0, myShape.leftIn, myShape.rightIn,
                            doBA);

                    ((Profiles) P).curveB = ((Profiles) P).doGPProfiles(((Profiles) P), myShape.widthPix, myShape.heightPix,
                            myShape.shapeID, myShape.top1Part, myShape.bot1Part, 1, myShape.leftIn, myShape.rightIn,
                            doBA);

                    ((Profiles) P).curveBA = ((Profiles) P).doGPProfiles(((Profiles) P), myShape.widthPix,
                            myShape.heightPix, myShape.shapeID, myShape.top1Part, myShape.bot1Part, 2,
                            myShape.leftIn, myShape.rightIn, doBA);

                    ((Profiles) P).curveA = ((Profiles) P).doGPProfiles(((Profiles) P), myShape.widthPix, myShape.heightPix,
                            myShape.shapeID, myShape.top1Part, myShape.bot1Part, 3, myShape.leftIn, myShape.rightIn,
                            doBA);

                }

                // ((Profiles) P).rgb_R = 255;
                // ((Profiles) P).rgb_G = 255;
                // ((Profiles) P).rgb_B = 255;

                partObjects.add(P);

            } else {
                partObjects.add(P);
            }
        }

        return partObjects;
    }

    public Point2D getIntersectionLineArc(
				//
				final double bsX,
				final double bsY, //
				final double w,
				final double h, //
				final double sA,
				final double eA, //
				final double cX, final double cY, final double sX, final double sY, final double eX, final double eY,
				final int pos, final boolean isP)
	{

		Point2D myP = new Point2D.Double();

		if (pos == 1)
		{// Top Part

			final Point2D myPs = new Point2D.Double(sX, sY);
			final Point2D myPe = new Point2D.Double(eX, eY);

			myP = this.getLineCircleIntersection(bsX, bsY, w, h, cX, cY, myPs, myPe, isP);
		}

		return myP;

	}
	
	public Point2D getLineCircleIntersection(final double bsX, final double bsY, final double wW, final double hH,
				final double centerX, final double centerY, final Point2D source, final Point2D p, final boolean isP)
	{
	
		// final Rectangle2D r = view.getBounds2D();
		
		final double a = wW / 2;// r.getWidth() +
		// 1;/// 2;
		final double b = hH / 2;// r.getHeight() +
		// 1;// / 2;
		
		// x0,y0 - center of ellipse
		final double x0 = centerX;// view.getCenterX();//x
		// +
		// a;
		final double y0 = centerY;// view.getCenterY();//y
		// +
		// b;
		
		// x1, y1 - point
		
		double x1 = 0; // was p
		double y1 = 0;
		if (!isP)
		{
			x1 = source.getX(); // was p
			y1 = source.getY();
		}
		else
		{
			x1 = p.getX();
			y1 = p.getY();
		}
		
		// Calculates straight line equation through
		// point
		// and ellipse center
		// y = d * x + h
		final double dx = x1 - x0;
		final double dy = y1 - y0;
		
		if (dx == 0)
		{
			return new Point2D.Double(x0, (y0 + b * dy / Math.abs(dy)));
		}
		
		final double d = dy / dx;
		final double h = y0 - d * x0;
		
		// Calculates intersection
		final double e = a * a * d * d + b * b;
		final double f = -2 * x0 * e;
		final double g = a * a * d * d * x0 * x0 + b * b * x0 * x0 - a * a * b * b;
		
		final double det = Math.sqrt(f * f - 4 * e * g);
		
		// Two solutions (perimeter points)
		final double xout1 = (-f + det) / (2 * e);
		final double xout2 = (-f - det) / (2 * e);
		final double yout1 = d * xout1 + h;
		final double yout2 = d * xout2 + h;
		
		final double dist1 = Math.sqrt(Math.pow((xout1 - x1), 2) + Math.pow((yout1 - y1), 2));
		final double dist2 = Math.sqrt(Math.pow((xout2 - x1), 2) + Math.pow((yout2 - y1), 2));
		
		// Correct solution
		double xout, yout;
		
		if (dist1 < dist2)
		{
			xout = xout1;
			yout = yout1;
		}
		else
		{
			xout = xout2;
			yout = yout2;
		}
		
		return new Point2D.Double(xout, yout);
	}
	
	public double[] getArchesAngles(final double sX, final double eX, final double sY, final double eY, final double radius,
				final double x1, final double y1, final boolean useYL, final boolean useYR)
	{
	
		final double[] myAngles = new double[4];
		double startAngle = 0;
		double endAngle = 0;
		double extentAngle = 0;
		double baseR = 0;
		double baseL = 0;
		double hR = 0;
		double hL = 0;
		double yS = 0;
		double yE = 0;
		
		if (!useYR)
		{
			if (x1 > sX && x1 <= eX)
			{
				baseR = eX - x1;
				
				startAngle = Math.abs(Math.toDegrees(Math.acos(baseR / radius)));
				if (baseR > radius)
				{
					startAngle = 0;
				}
				
				hR = radius * Math.sin(Math.toRadians(startAngle));
				
				yE = y1 - hR;
				
			}
			else if (x1 > eX)
			{
				baseR = x1 - eX;
				
				startAngle = 180 - Math.abs(Math.toDegrees(Math.acos(baseR / radius)));
				if (baseR > radius)
				{
					startAngle = 0;
				}
				
				hR = radius * Math.sin(Math.abs(Math.acos(baseR / radius)));
				
				yE = y1 - hR;
				
			}
			else if (x1 <= sX)
			{
				baseR = eX - x1;
				
				startAngle = Math.abs(Math.toDegrees(Math.acos(baseR / radius)));
				if (baseR > radius)
				{
					startAngle = 0;
				}
				
				hR = radius * Math.sin(Math.toRadians(startAngle));
				
				yE = y1 - hR;
				
			}
			
		}
		else
		{
			if (x1 > sX && x1 <= eX)
			{
				baseR = eX - x1;
				
				hR = y1 - eY;
				
				startAngle = Math.abs(Math.toDegrees(Math.atan(hR / baseR)));
				
				yE = eY;
				
			}
			else if (x1 > eX)
			{
				baseR = x1 - eX;
				
				hR = y1 - eY;
				
				startAngle = 180 - Math.abs(Math.toDegrees(Math.atan(hR / baseR)));
				
				yE = eY;
				
			}
			else if (x1 <= sX)
			{
				baseR = eX - x1;
				hR = y1 - eY;
				startAngle = Math.abs(Math.toDegrees(Math.atan(hR / baseR)));
				
				yE = eY;
				
			}
			
		}
		
		// endAngles Start Here
		
		if (!useYL)
		{
			if (x1 > sX && x1 <= eX)
			{
				
				baseL = x1 - sX;
				
				endAngle = Math.abs(Math.toDegrees(Math.acos(baseL / radius)));
				if (baseL > radius)
				{
					endAngle = 0;
				}
				
				hL = radius * Math.sin(Math.toRadians(endAngle));
				
				yS = y1 - hL;
				
			}
			else if (x1 > eX)
			{
				
				baseL = x1 - sX;
				
				endAngle = Math.abs(Math.toDegrees(Math.acos(baseL / radius)));
				
				if (baseL > radius)
				{
					endAngle = 0;
				}
				
				hL = radius * Math.sin(Math.toRadians(endAngle));
				
				yS = y1 - hL;
				
			}
			else if (x1 <= sX)
			{
				
				baseL = sX - x1;
				
				endAngle = Math.abs(Math.toDegrees(Math.acos(baseL / radius)));
				if (baseL > radius)
				{
					endAngle = 0;
				}
				hL = radius * Math.sin(Math.toRadians(endAngle));
				
				yS = y1 - hL;
			}
			
		}
		else
		{
			if (x1 > sX && x1 <= eX)
			{
				
				baseL = x1 - sX;
				
				hL = y1 - sY;
				
				endAngle = Math.abs(Math.toDegrees(Math.atan(hL / baseL)));
				
				yS = sY;
				
			}
			else if (x1 > eX)
			{
				
				baseL = x1 - sX;
				hL = y1 - sY;
				
				endAngle = Math.abs(Math.toDegrees(Math.atan(hL / baseL)));
				
				yS = sY;
				
			}
			else if (x1 <= sX)
			{
				
				baseL = sX - x1;
				hL = y1 - sY;
				
				endAngle = Math.abs(Math.toDegrees(Math.atan(hL / baseL)));
				// extentAngle = endAngle -
				// startAngle;
				
				yS = sY;
			}
			
		}
		
		if (x1 > sX && x1 <= eX)
		{
			extentAngle = 180 - (endAngle + startAngle);
		}
		else if (x1 > eX)
		{
			extentAngle = 180 - (endAngle + startAngle);
		}
		else if (x1 <= sX)
		{
			extentAngle = endAngle - startAngle;
		}
		
		myAngles[0] = startAngle;
		myAngles[1] = extentAngle;
		myAngles[2] = yS;
		myAngles[3] = yE;
		
		return myAngles;
		
		// top2
	}
	
	//
	// /**
	// * Clone Profile to Top1Object
	// *
	// * @param newTop, Top1Object
	// * @param original, Profiles
	// * @return Top1Object
	// */
	// public Top1Object myTop1Clone(Top1Object newTop, Profiles original) {
	//
	// newTop.bkgrdHeight = original.bkgrdHeight;
	// newTop.bkgrdHeightA = original.bkgrdHeightA;
	// newTop.bkgrdHeightBA = original.bkgrdHeightBA;
	// newTop.bkgrdHeightBC = original.bkgrdHeightBC;
	// newTop.bkgrdStartX = original.bkgrdStartX;
	// newTop.bkgrdStartXA = original.bkgrdStartXA;
	// newTop.bkgrdStartXBA = original.bkgrdStartXBA;
	// newTop.x1 = original.x1;
	// newTop.y1 = original.y1;
	// newTop.x2 = original.x2;
	// newTop.y2 = original.y2;
	// newTop.x1A = original.x1A;
	// newTop.y1A = original.y1A;
	// newTop.x2A = original.x2A;
	// newTop.y2A = original.y2A;
	// newTop.x1BA = original.x1BA;
	// newTop.y1BA = original.y1BA;
	// newTop.x2BA = original.x2BA;
	// newTop.y2BA = original.y2BA;
	//
	// newTop.bkgrdStartXBC = original.bkgrdStartXBC;
	// newTop.bkgrdStartY = original.bkgrdStartY;
	//
	// newTop.bkgrdStartYA = original.bkgrdStartYA;
	// newTop.bkgrdStartYBA = original.bkgrdStartYBA;
	// newTop.bkgrdStartYBC = original.bkgrdStartYBC;
	//
	// newTop.bkgrdWidth = original.bkgrdWidth;
	// newTop.bkgrdWidthA = original.bkgrdWidthA;
	//
	// newTop.bkgrdWidthBA = original.bkgrdWidthBA;
	// newTop.bkgrdWidthBC = original.bkgrdWidthBC;
	// newTop.centralAngle = original.centralAngle;
	// newTop.centralAngleA = original.centralAngleA;
	//
	// newTop.centralAngleBA = original.centralAngleBA;
	//
	// newTop.centralAngleBC = original.centralAngleBC;
	// newTop.dimB1A = original.dimB1A;
	//
	// newTop.dimB1B = original.dimB1B;
	// newTop.endAngle = original.endAngle;
	//
	// newTop.endAngleA = original.endAngleA;
	//
	// newTop.endAngleBA = original.endAngleBA;
	// newTop.endAngleBC = original.endAngleBC;
	//
	// newTop.endX = original.endXC;
	// newTop.endXA = original.endXA;
	//
	// newTop.endXBA = original.endXBA;
	// newTop.endXBC = original.endXBC;
	// newTop.endY = original.endYC;
	//
	// newTop.endYA = original.endYA;
	// newTop.endYBA = original.endYBA;
	//
	// newTop.endYBC = original.endYBC;
	// newTop.focal1X = original.focal1X;
	//
	// newTop.focal1XA = original.focal1XA;
	// newTop.focal1XBA = original.focal1XBA;
	// newTop.focal1XBC = original.focal1XBC;
	// newTop.focal1Y = original.focal1Y;
	//
	// newTop.focal1YA = original.focal1YA;
	// newTop.focal1YBA = original.focal1YBA;
	//
	// newTop.focal1YBC = original.focal1YBC;
	//
	// newTop.focal2X = original.focal2X;
	// newTop.focal2XA = original.focal2XA;
	//
	// newTop.focal2XBA = original.focal2XBA;
	// newTop.focal2XBC = original.focal2XBC;
	//
	// newTop.focal2Y = original.focal2Y;
	//
	// newTop.focal2YA = original.focal2YA;
	// newTop.focal2YBA = original.focal2YBA;
	//
	// newTop.focal2YBC = original.focal2YBC;
	// newTop.glazingDepth = original.glazingDepth;
	//
	// newTop.inLaminateArea = original.inLaminateArea;
	// newTop.inPaintArea = original.inPaintArea;
	//
	// newTop.length = original.length;
	// newTop.lengthA = original.lengthA;
	// newTop.lengthBA = original.lengthBA;
	//
	// newTop.lengthBC = original.lengthBC;
	// newTop.ltAngle = original.ltAngle;
	//
	// newTop.ltAngleA = original.ltAngleA;
	// newTop.ltAngleBA = original.ltAngleBA;
	//
	// newTop.ltAngleBC = original.ltAngleBC;
	// newTop.mitreLengthLT = original.mitreLengthLT;
	// newTop.mitreLengthRB = original.mitreLengthRB;
	//
	// newTop.myWidth = original.myWidth;
	// newTop.myWidthA = original.myWidthA;
	//
	// newTop.myWidthBA = original.myWidthBA;
	//
	// newTop.outLaminateArea = original.outLaminateArea;
	// newTop.outPaintArea = original.outPaintArea;
	//
	// newTop.partDimA = original.partDimA;
	// // newTop.partDimA2 = original.partDimAi;
	// newTop.partDimB = original.partDimB;
	// // newTop.partDimB2 = original.partDimBi;
	// newTop.partDimC = original.partDimC;
	// // newTop.partDimC2 = original.partDimCi;
	// newTop.partDimM = original.partDimM;
	// newTop.partForm = original.partForm; // 1 lines, 2 arc, 3 Ellipse
	//
	// newTop.partID = original.partID;
	// newTop.partShape = original.partShape; // L, T, Z, I, H,
	//
	// newTop.position = original.position; // 1 top, 2 right, 3 bot, 4 left
	// newTop.seq = original.seq;
	// newTop.radianCentralAngle = original.radianCentralAngle;
	//
	// newTop.radius1 = original.radius1;
	// newTop.radius1A = original.radius1A;
	// newTop.radius1BA = original.radius1BA;
	// newTop.radius1BC = original.radius1BC;
	//
	// newTop.radius2 = original.radius2;
	//
	// newTop.radius2A = original.radius2A;
	// newTop.radius2BA = original.radius2BA;
	//
	// newTop.radius2BC = original.radius2BC;
	//
	// newTop.rbAngle = original.rbAngle;
	// newTop.rbAngleA = original.rbAngleA;
	// newTop.rbAngleBA = original.rbAngleBA;
	// newTop.rbAngleBC = original.rbAngleBC;
	// // From Level Shape and Calculates
	// newTop.rID = original.rID; // Get next record ID from DB
	// newTop.rlAngle = original.rlAngle; //to left side angle
	// newTop.rlAngleA = original.rlAngleA; // to left side angle
	// newTop.rlAngleBA = original.rlAngleBA; // to left side angle
	// newTop.rlSlope = original.rlSlope;
	// newTop.rlSlopeA = original.rlSlopeA;
	// newTop.rlSlopeBA = original.rlSlopeBA;
	// newTop.rrAngle = original.rrAngle; // to right side angle
	// newTop.rrAngleA = original.rrAngleA; // to right side angle
	// newTop.rrAngleBA = original.rrAngleBA; // to right side angle
	// newTop.rrSlope = original.rrSlope;
	// newTop.rrSlopeA = original.rrSlopeA;
	// newTop.rrSlopeBA = original.rrSlopeBA;
	// newTop.slope = original.slope;
	// newTop.slopeA = original.slopeA;
	// newTop.slopeBA = original.slopeBA;
	// newTop.slopeBC = original.slopeBC;
	// newTop.startAngle = original.startAngle;
	// newTop.startAngleA = original.startAngleA;
	// newTop.startAngleBA = original.startAngleBA;
	// newTop.startAngleBC = original.startAngleBC;
	// newTop.startingX = original.startingX;
	// newTop.startingXA = original.startingXA;
	// newTop.startingXBA = original.startingXBA;
	// newTop.startingXBC = original.startingXBC;
	// newTop.startingY = original.startingY;
	// newTop.startingYA = original.startingYA;
	// newTop.startingYBA = original.startingYBA;
	// newTop.startingYBC = original.startingYBC;
	// newTop.startX = original.startXC;
	// newTop.startXA = original.startXA;
	// newTop.startXBA = original.startXBA;
	// newTop.startXBC = original.startXBC;
	// newTop.startY = original.startYC;
	// newTop.startYA = original.startYA;
	// newTop.startYBA = original.startYBA;
	// newTop.startYBC = original.startYBC;
	// newTop.stockCode = original.stockCode;
	// newTop.color = original.color;// From Rules
	// newTop.totalDepth = original.totalDepth;
	// newTop.totalSurfaceArea = original.totalSurfaceArea;
	// newTop.endTypeLT = original.endTypeLT;
	// newTop.endTypeRB = original.endTypeRB;
	// newTop.parentW = original.parentW;
	//
	// newTop.rgb_R = original.rgb_R;
	// newTop.rgb_G = original.rgb_G;
	// newTop.rgb_B = original.rgb_B;
	//
	// newTop.rgb_Rt = original.rgb_Rt;
	// newTop.rgb_Gt = original.rgb_Gt;
	// newTop.rgb_Bt = original.rgb_Bt;
	//
	// newTop.profileSelected = 0;
	//
	// newTop.mullionLeft = original.mullionLeft;
	// newTop.mullionRight = original.mullionRight;
	//
	// newTop.posInUse = original.posInUse;
	// newTop.stopAeX = original.stopAeX;
	// newTop.stopAeY = original.stopAeY;
	// newTop.stopAsX = original.stopAsX;
	// newTop.stopAsY = original.stopAsY;
	//
	// return newTop;
	// }
	//
	// /**
	// * Clone profiles to Top2Object
	// *
	// * @param newTop, Top2Object
	// * @param original, Profiles
	// * @return Top2Object
	// */
	// public Top2Object myTop2Clone(Top2Object newTop, Profiles original) {
	//
	// newTop.bkgrdHeight = original.bkgrdHeight;
	// newTop.bkgrdHeightA = original.bkgrdHeightA;
	// newTop.bkgrdHeightBA = original.bkgrdHeightBA;
	// newTop.bkgrdHeightBC = original.bkgrdHeightBC;
	// newTop.bkgrdStartX = original.bkgrdStartX;
	// newTop.bkgrdStartXA = original.bkgrdStartXA;
	// newTop.bkgrdStartXBA = original.bkgrdStartXBA;
	//
	// newTop.bkgrdStartXBC = original.bkgrdStartXBC;
	// newTop.bkgrdStartY = original.bkgrdStartY;
	// newTop.x1 = original.x1;
	// newTop.y1 = original.y1;
	// newTop.x2 = original.x2;
	// newTop.y2 = original.y2;
	// newTop.x1A = original.x1A;
	// newTop.y1A = original.y1A;
	// newTop.x2A = original.x2A;
	// newTop.y2A = original.y2A;
	// newTop.x1BA = original.x1BA;
	// newTop.y1BA = original.y1BA;
	// newTop.x2BA = original.x2BA;
	// newTop.y2BA = original.y2BA;
	// newTop.bkgrdStartYA = original.bkgrdStartYA;
	// newTop.bkgrdStartYBA = original.bkgrdStartYBA;
	// newTop.bkgrdStartYBC = original.bkgrdStartYBC;
	//
	// newTop.bkgrdWidth = original.bkgrdWidth;
	// newTop.bkgrdWidthA = original.bkgrdWidthA;
	// newTop.bkgrdWidthBA = original.bkgrdWidthBA;
	// newTop.bkgrdWidthBC = original.bkgrdWidthBC;
	// newTop.centralAngle = original.centralAngle;
	// newTop.centralAngleA = original.centralAngleA;
	// newTop.centralAngleBA = original.centralAngleBA;
	// newTop.centralAngleBC = original.centralAngleBC;
	// newTop.dimB1A = original.dimB1A;
	// newTop.dimB1B = original.dimB1B;
	// newTop.endAngle = original.endAngle;
	// newTop.endAngleA = original.endAngleA;
	// newTop.endAngleBA = original.endAngleBA;
	// newTop.endAngleBC = original.endAngleBC;
	// newTop.endX = original.endXC;
	// newTop.endXA = original.endXA;
	// newTop.endXBA = original.endXBA;
	// newTop.endXBC = original.endXBC;
	// newTop.endY = original.endYC;
	// newTop.endYA = original.endYA;
	// newTop.endYBA = original.endYBA;
	// newTop.endYBC = original.endYBC;
	// newTop.focal1X = original.focal1X;
	// newTop.focal1XA = original.focal1XA;
	// newTop.focal1XBA = original.focal1XBA;
	// newTop.focal1XBC = original.focal1XBC;
	// newTop.focal1Y = original.focal1Y;
	// newTop.focal1YA = original.focal1YA;
	// newTop.focal1YBA = original.focal1YBA;
	// newTop.focal1YBC = original.focal1YBC;
	// newTop.focal2X = original.focal2X;
	// newTop.focal2XA = original.focal2XA;
	//
	// newTop.focal2XBA = original.focal2XBA;
	// newTop.focal2XBC = original.focal2XBC;
	//
	// newTop.focal2Y = original.focal2Y;
	//
	// newTop.focal2YA = original.focal2YA;
	// newTop.focal2YBA = original.focal2YBA;
	//
	// newTop.focal2YBC = original.focal2YBC;
	// newTop.glazingDepth = original.glazingDepth;
	//
	// newTop.inLaminateArea = original.inLaminateArea;
	// newTop.inPaintArea = original.inPaintArea;
	//
	// newTop.length = original.length;
	// newTop.lengthA = original.lengthA;
	// newTop.lengthBA = original.lengthBA;
	//
	// newTop.lengthBC = original.lengthBC;
	// newTop.ltAngle = original.ltAngle;
	//
	// newTop.ltAngleA = original.ltAngleA;
	// newTop.ltAngleBA = original.ltAngleBA;
	//
	// newTop.ltAngleBC = original.ltAngleBC;
	// newTop.mitreLengthLT = original.mitreLengthLT;
	// newTop.mitreLengthRB = original.mitreLengthRB;
	//
	// newTop.myWidth = original.myWidth;
	// newTop.myWidthA = original.myWidthA;
	//
	// newTop.myWidthBA = original.myWidthBA;
	//
	// newTop.outLaminateArea = original.outLaminateArea;
	// newTop.outPaintArea = original.outPaintArea;
	//
	// newTop.partDimA = original.partDimA;
	// // newTop.partDimA2 = original.partDimAi;
	// newTop.partDimB = original.partDimB;
	// // newTop.partDimB2 = original.partDimBi;
	// newTop.partDimC = original.partDimC;
	// // newTop.partDimC2 = original.partDimCi;
	// newTop.partDimM = original.partDimM;
	// newTop.partForm = original.partForm; // 1 lines, 2 arc, 3 Ellipse
	// newTop.partID = original.partID;
	// newTop.partShape = original.partShape; // L, T, Z, I, H,
	// newTop.position = original.position; // 1 top, 2 right, 3 bot, 4 left
	// newTop.seq = original.seq;
	// newTop.radianCentralAngle = original.radianCentralAngle;
	//
	// newTop.radius1 = original.radius1;
	// newTop.radius1A = original.radius1A;
	// newTop.radius1BA = original.radius1BA;
	// newTop.radius1BC = original.radius1BC;
	//
	// newTop.radius2 = original.radius2;
	//
	// newTop.radius2A = original.radius2A;
	// newTop.radius2BA = original.radius2BA;
	//
	// newTop.radius2BC = original.radius2BC;
	//
	// newTop.rbAngle = original.rbAngle;
	// newTop.rbAngleA = original.rbAngleA;
	// newTop.rbAngleBA = original.rbAngleBA;
	// newTop.rbAngleBC = original.rbAngleBC;
	// // From Level Shape and Calculates
	// newTop.rID = original.rID;
	// newTop.rlAngle = original.rlAngle;
	// newTop.rlAngleA = original.rlAngleA;
	// newTop.rlAngleBA = original.rlAngleBA;
	//
	// newTop.rlSlope = original.rlSlope;
	// newTop.rlSlopeA = original.rlSlopeA;
	// newTop.rlSlopeBA = original.rlSlopeBA;
	//
	// newTop.rrAngle = original.rrAngle;
	// newTop.rrAngleA = original.rrAngleA;
	// newTop.rrAngleBA = original.rrAngleBA;
	//
	// newTop.rrSlope = original.rrSlope;
	// newTop.rrSlopeA = original.rrSlopeA;
	// newTop.rrSlopeBA = original.rrSlopeBA;
	// newTop.slope = original.slope;
	// newTop.slopeA = original.slopeA;
	// newTop.slopeBA = original.slopeBA;
	// newTop.slopeBC = original.slopeBC;
	// newTop.startAngle = original.startAngle;
	// newTop.startAngleA = original.startAngleA;
	// newTop.startAngleBA = original.startAngleBA;
	// newTop.startAngleBC = original.startAngleBC;
	// newTop.startingX = original.startingX;
	// newTop.startingXA = original.startingXA;
	// newTop.startingXBA = original.startingXBA;
	// newTop.startingXBC = original.startingXBC;
	// newTop.startingY = original.startingY;
	// newTop.startingYA = original.startingYA;
	// newTop.startingYBA = original.startingYBA;
	// newTop.startingYBC = original.startingYBC;
	// newTop.startX = original.startXC;
	// newTop.startXA = original.startXA;
	// newTop.startXBA = original.startXBA;
	// newTop.startXBC = original.startXBC;
	// newTop.startY = original.startYC;
	// newTop.startYA = original.startYA;
	// newTop.startYBA = original.startYBA;
	// newTop.startYBC = original.startYBC;
	// newTop.stockCode = original.stockCode;
	// newTop.color = original.color;
	// // From Rules
	//
	// newTop.totalDepth = original.totalDepth;
	// newTop.totalSurfaceArea = original.totalSurfaceArea;
	//
	// newTop.endTypeLT = original.endTypeLT;
	// newTop.endTypeRB = original.endTypeRB;
	// newTop.parentW = original.parentW;
	//
	// newTop.rgb_R = original.rgb_R;
	// newTop.rgb_G = original.rgb_G;
	// newTop.rgb_B = original.rgb_B;
	//
	// newTop.rgb_Rt = original.rgb_Rt;
	// newTop.rgb_Gt = original.rgb_Gt;
	// newTop.rgb_Bt = original.rgb_Bt;
	//
	// newTop.profileSelected = 0;
	//
	// newTop.mullionLeft = original.mullionLeft;
	// newTop.mullionRight = original.mullionRight;
	// newTop.posInUse = original.posInUse;
	// newTop.stopAeX = original.stopAeX;
	// newTop.stopAeY = original.stopAeY;
	// newTop.stopAsX = original.stopAsX;
	// newTop.stopAsY = original.stopAsY;
	//
	// newTop.partForm = original.partForm;
	//
	// return newTop;
	// }
	//
	// /**
	// * Cloning Profile to Top3Object
	// *
	// * @param newTop, Top3Object
	// * @param original, Profiles
	// * @return Top3Object
	// */
	// public Top3Object myTop3Clone(Top3Object newTop, Profiles original) {
	//
	// newTop.bkgrdHeight = original.bkgrdHeight;
	// newTop.bkgrdHeightA = original.bkgrdHeightA;
	// newTop.bkgrdHeightBA = original.bkgrdHeightBA;
	// newTop.bkgrdHeightBC = original.bkgrdHeightBC;
	// newTop.bkgrdStartX = original.bkgrdStartX;
	// newTop.bkgrdStartXA = original.bkgrdStartXA;
	// newTop.bkgrdStartXBA = original.bkgrdStartXBA;
	// newTop.x1 = original.x1;
	// newTop.y1 = original.y1;
	// newTop.x2 = original.x2;
	// newTop.y2 = original.y2;
	// newTop.x1A = original.x1A;
	// newTop.y1A = original.y1A;
	// newTop.x2A = original.x2A;
	// newTop.y2A = original.y2A;
	// newTop.x1BA = original.x1BA;
	// newTop.y1BA = original.y1BA;
	// newTop.x2BA = original.x2BA;
	// newTop.y2BA = original.y2BA;
	// newTop.bkgrdStartXBC = original.bkgrdStartXBC;
	// newTop.bkgrdStartY = original.bkgrdStartY;
	// newTop.bkgrdStartYA = original.bkgrdStartYA;
	// newTop.bkgrdStartYBA = original.bkgrdStartYBA;
	// newTop.bkgrdStartYBC = original.bkgrdStartYBC;
	// newTop.bkgrdWidth = original.bkgrdWidth;
	// newTop.bkgrdWidthA = original.bkgrdWidthA;
	//
	// newTop.bkgrdWidthBA = original.bkgrdWidthBA;
	// newTop.bkgrdWidthBC = original.bkgrdWidthBC;
	// newTop.centralAngle = original.centralAngle;
	// newTop.centralAngleA = original.centralAngleA;
	//
	// newTop.centralAngleBA = original.centralAngleBA;
	//
	// newTop.centralAngleBC = original.centralAngleBC;
	// newTop.dimB1A = original.dimB1A;
	//
	// newTop.dimB1B = original.dimB1B;
	// newTop.endAngle = original.endAngle;
	//
	// newTop.endAngleA = original.endAngleA;
	//
	// newTop.endAngleBA = original.endAngleBA;
	// newTop.endAngleBC = original.endAngleBC;
	//
	// newTop.endX = original.endXC;
	// newTop.endXA = original.endXA;
	//
	// newTop.endXBA = original.endXBA;
	// newTop.endXBC = original.endXBC;
	// newTop.endY = original.endYC;
	//
	// newTop.endYA = original.endYA;
	// newTop.endYBA = original.endYBA;
	//
	// newTop.endYBC = original.endYBC;
	// newTop.focal1X = original.focal1X;
	//
	// newTop.focal1XA = original.focal1XA;
	// newTop.focal1XBA = original.focal1XBA;
	// newTop.focal1XBC = original.focal1XBC;
	// newTop.focal1Y = original.focal1Y;
	//
	// newTop.focal1YA = original.focal1YA;
	// newTop.focal1YBA = original.focal1YBA;
	//
	// newTop.focal1YBC = original.focal1YBC;
	//
	// newTop.focal2X = original.focal2X;
	// newTop.focal2XA = original.focal2XA;
	//
	// newTop.focal2XBA = original.focal2XBA;
	// newTop.focal2XBC = original.focal2XBC;
	//
	// newTop.focal2Y = original.focal2Y;
	//
	// newTop.focal2YA = original.focal2YA;
	// newTop.focal2YBA = original.focal2YBA;
	//
	// newTop.focal2YBC = original.focal2YBC;
	// newTop.glazingDepth = original.glazingDepth;
	//
	// newTop.inLaminateArea = original.inLaminateArea;
	// newTop.inPaintArea = original.inPaintArea;
	//
	// newTop.length = original.length;
	// newTop.lengthA = original.lengthA;
	// newTop.lengthBA = original.lengthBA;
	//
	// newTop.lengthBC = original.lengthBC;
	// newTop.ltAngle = original.ltAngle;
	//
	// newTop.ltAngleA = original.ltAngleA;
	// newTop.ltAngleBA = original.ltAngleBA;
	//
	// newTop.ltAngleBC = original.ltAngleBC;
	// newTop.mitreLengthLT = original.mitreLengthLT;
	// newTop.mitreLengthRB = original.mitreLengthRB;
	//
	// newTop.myWidth = original.myWidth;
	// newTop.myWidthA = original.myWidthA;
	//
	// newTop.myWidthBA = original.myWidthBA;
	//
	// newTop.outLaminateArea = original.outLaminateArea;
	// newTop.outPaintArea = original.outPaintArea;
	//
	// newTop.partDimA = original.partDimA;
	// // newTop.partDimA2 = original.partDimAi;
	// newTop.partDimB = original.partDimB;
	// // newTop.partDimB2 = original.partDimBi;
	// newTop.partDimC = original.partDimC;
	// // newTop.partDimC2 = original.partDimCi;
	// newTop.partDimM = original.partDimM;
	// newTop.partForm = original.partForm; // 1 lines, 2 arc, 3 Ellipse
	// newTop.partID = original.partID;
	// newTop.partShape = original.partShape; // L, T, Z,I, H,
	//
	// newTop.position = original.position; // 1 top, 2 right, 3 bot, 4 left
	// newTop.seq = original.seq;
	// newTop.radianCentralAngle = original.radianCentralAngle;
	//
	// newTop.radius1 = original.radius1;
	// newTop.radius1A = original.radius1A;
	// newTop.radius1BA = original.radius1BA;
	// newTop.radius1BC = original.radius1BC;
	//
	// newTop.radius2 = original.radius2;
	//
	// newTop.radius2A = original.radius2A;
	// newTop.radius2BA = original.radius2BA;
	//
	// newTop.radius2BC = original.radius2BC;
	//
	// newTop.rbAngle = original.rbAngle;
	// newTop.rbAngleA = original.rbAngleA;
	// newTop.rbAngleBA = original.rbAngleBA;
	// newTop.rbAngleBC = original.rbAngleBC;
	// // From Level Shape and Calculates
	// newTop.rID = original.rID;
	// newTop.rlAngle = original.rlAngle;
	// newTop.rlAngleA = original.rlAngleA;
	// newTop.rlAngleBA = original.rlAngleBA;
	// newTop.rlSlope = original.rlSlope;
	// newTop.rlSlopeA = original.rlSlopeA;
	// newTop.rlSlopeBA = original.rlSlopeBA;
	// newTop.rrAngle = original.rrAngle;
	// newTop.rrAngleA = original.rrAngleA;
	// newTop.rrAngleBA = original.rrAngleBA;
	// newTop.rrSlope = original.rrSlope;
	// newTop.rrSlopeA = original.rrSlopeA;
	// newTop.rrSlopeBA = original.rrSlopeBA;
	//
	// newTop.slope = original.slope;
	// newTop.slopeA = original.slopeA;
	// newTop.slopeBA = original.slopeBA;
	// newTop.slopeBC = original.slopeBC;
	// newTop.startAngle = original.startAngle;
	// newTop.startAngleA = original.startAngleA;
	// newTop.startAngleBA = original.startAngleBA;
	// newTop.startAngleBC = original.startAngleBC;
	// newTop.startingX = original.startingX;
	// newTop.startingXA = original.startingXA;
	//
	// newTop.startingXBA = original.startingXBA;
	//
	// newTop.startingXBC = original.startingXBC;
	//
	// newTop.startingY = original.startingY;
	// newTop.startingYA = original.startingYA;
	// newTop.startingYBA = original.startingYBA;
	// newTop.startingYBC = original.startingYBC;
	// newTop.startX = original.startXC;
	// newTop.startXA = original.startXA;
	// newTop.startXBA = original.startXBA;
	// newTop.startXBC = original.startXBC;
	// newTop.startY = original.startYC;
	// newTop.startYA = original.startYA;
	// newTop.startYBA = original.startYBA;
	// newTop.startYBC = original.startYBC;
	// newTop.stockCode = original.stockCode;
	// newTop.color = original.color;
	// // From Rules
	//
	// newTop.totalDepth = original.totalDepth;
	// newTop.totalSurfaceArea = original.totalSurfaceArea;
	//
	// newTop.endTypeLT = original.endTypeLT;
	// newTop.endTypeRB = original.endTypeRB;
	// newTop.parentW = original.parentW;
	//
	// newTop.rgb_R = original.rgb_R;
	// newTop.rgb_G = original.rgb_G;
	// newTop.rgb_B = original.rgb_B;
	//
	// newTop.rgb_Rt = original.rgb_Rt;
	// newTop.rgb_Gt = original.rgb_Gt;
	// newTop.rgb_Bt = original.rgb_Bt;
	//
	// newTop.profileSelected = 0;
	//
	// newTop.mullionLeft = original.mullionLeft;
	// newTop.mullionRight = original.mullionRight;
	//
	// newTop.posInUse = original.posInUse;
	// newTop.stopAeX = original.stopAeX;
	// newTop.stopAeY = original.stopAeY;
	// newTop.stopAsX = original.stopAsX;
	// newTop.stopAsY = original.stopAsY;
	// return newTop;
	// }
	//
	// /**
	// * Cloning Profiles to Bot1Object
	// *
	// * @param newTop, Bot1Object
	// * @param original, Profiles
	// * @return Bo1Object
	// */
	// public Bot1Object myBot1Clone(Bot1Object newTop, Profiles original) {
	//
	// newTop.bkgrdHeight = original.bkgrdHeight;
	// newTop.bkgrdHeightA = original.bkgrdHeightA;
	// newTop.bkgrdHeightBA = original.bkgrdHeightBA;
	// newTop.bkgrdHeightBC = original.bkgrdHeightBC;
	// newTop.bkgrdStartX = original.bkgrdStartX;
	// newTop.bkgrdStartXA = original.bkgrdStartXA;
	// newTop.bkgrdStartXBA = original.bkgrdStartXBA;
	// newTop.x1 = original.x1;
	// newTop.y1 = original.y1;
	// newTop.x2 = original.x2;
	// newTop.y2 = original.y2;
	// newTop.x1A = original.x1A;
	// newTop.y1A = original.y1A;
	// newTop.x2A = original.x2A;
	// newTop.y2A = original.y2A;
	// newTop.x1BA = original.x1BA;
	// newTop.y1BA = original.y1BA;
	// newTop.x2BA = original.x2BA;
	// newTop.y2BA = original.y2BA;
	// newTop.bkgrdStartXBC = original.bkgrdStartXBC;
	// newTop.bkgrdStartY = original.bkgrdStartY;
	//
	// newTop.bkgrdStartYA = original.bkgrdStartYA;
	// newTop.bkgrdStartYBA = original.bkgrdStartYBA;
	// newTop.bkgrdStartYBC = original.bkgrdStartYBC;
	//
	// newTop.bkgrdWidth = original.bkgrdWidth;
	// newTop.bkgrdWidthA = original.bkgrdWidthA;
	//
	// newTop.bkgrdWidthBA = original.bkgrdWidthBA;
	// newTop.bkgrdWidthBC = original.bkgrdWidthBC;
	// newTop.centralAngle = original.centralAngle;
	// newTop.centralAngleA = original.centralAngleA;
	//
	// newTop.centralAngleBA = original.centralAngleBA;
	//
	// newTop.centralAngleBC = original.centralAngleBC;
	// newTop.dimB1A = original.dimB1A;
	//
	// newTop.dimB1B = original.dimB1B;
	// newTop.endAngle = original.endAngle;
	//
	// newTop.endAngleA = original.endAngleA;
	//
	// newTop.endAngleBA = original.endAngleBA;
	// newTop.endAngleBC = original.endAngleBC;
	//
	// newTop.endX = original.endXC;
	// newTop.endXA = original.endXA;
	//
	// newTop.endXBA = original.endXBA;
	// newTop.endXBC = original.endXBC;
	// newTop.endY = original.endYC;
	//
	// newTop.endYA = original.endYA;
	// newTop.endYBA = original.endYBA;
	//
	// newTop.endYBC = original.endYBC;
	// newTop.focal1X = original.focal1X;
	//
	// newTop.focal1XA = original.focal1XA;
	// newTop.focal1XBA = original.focal1XBA;
	// newTop.focal1XBC = original.focal1XBC;
	// newTop.focal1Y = original.focal1Y;
	//
	// newTop.focal1YA = original.focal1YA;
	// newTop.focal1YBA = original.focal1YBA;
	//
	// newTop.focal1YBC = original.focal1YBC;
	//
	// newTop.focal2X = original.focal2X;
	// newTop.focal2XA = original.focal2XA;
	//
	// newTop.focal2XBA = original.focal2XBA;
	// newTop.focal2XBC = original.focal2XBC;
	//
	// newTop.focal2Y = original.focal2Y;
	//
	// newTop.focal2YA = original.focal2YA;
	// newTop.focal2YBA = original.focal2YBA;
	//
	// newTop.focal2YBC = original.focal2YBC;
	// newTop.glazingDepth = original.glazingDepth;
	//
	// newTop.inLaminateArea = original.inLaminateArea;
	// newTop.inPaintArea = original.inPaintArea;
	//
	// newTop.length = original.length;
	// newTop.lengthA = original.lengthA;
	// newTop.lengthBA = original.lengthBA;
	//
	// newTop.lengthBC = original.lengthBC;
	// newTop.ltAngle = original.ltAngle;
	//
	// newTop.ltAngleA = original.ltAngleA;
	// newTop.ltAngleBA = original.ltAngleBA;
	//
	// newTop.ltAngleBC = original.ltAngleBC;
	// newTop.mitreLengthLT = original.mitreLengthLT;
	// newTop.mitreLengthRB = original.mitreLengthRB;
	//
	// newTop.myWidthA = original.myWidthA;
	//
	// newTop.myWidthBA = original.myWidthBA;
	//
	// newTop.outLaminateArea = original.outLaminateArea;
	// newTop.outPaintArea = original.outPaintArea;
	//
	// newTop.partDimA = original.partDimA;
	// // newTop.partDimA2 = original.partDimAi;
	// newTop.partDimB = original.partDimB;
	// // newTop.partDimB2 = original.partDimBi;
	// newTop.partDimC = original.partDimC;
	// // newTop.partDimC2 = original.partDimCi;
	// newTop.partDimM = original.partDimM;
	// newTop.partForm = original.partForm; // 1
	// // lines, 2
	// // arc, 3
	// // Ellipse
	//
	// newTop.partID = original.partID;
	// newTop.partShape = original.partShape; // L,
	// // T, Z,
	// // I, H,
	//
	// newTop.position = original.position; // 1
	// // top, 2
	// // right, 3
	// // bot, 4 left
	// newTop.seq = original.seq;
	// newTop.radianCentralAngle = original.radianCentralAngle;
	//
	// newTop.radius1 = original.radius1;
	// newTop.radius1A = original.radius1A;
	// newTop.radius1BA = original.radius1BA;
	// newTop.radius1BC = original.radius1BC;
	//
	// newTop.radius2 = original.radius2;
	//
	// newTop.radius2A = original.radius2A;
	// newTop.radius2BA = original.radius2BA;
	//
	// newTop.radius2BC = original.radius2BC;
	//
	// newTop.rbAngle = original.rbAngle;
	// newTop.rbAngleA = original.rbAngleA;
	// newTop.rbAngleBA = original.rbAngleBA;
	// newTop.rbAngleBC = original.rbAngleBC;
	// // From Level Shape and Calculates
	// newTop.rID = original.rID; // Get next
	// // record ID
	// // from DB
	// newTop.rlAngle = original.rlAngle;
	// // to left
	// // side angle
	// newTop.rlAngleA = original.rlAngleA;
	// // to
	// // left side
	// // angle
	// newTop.rlAngleBA = original.rlAngleBA;
	// // to
	// // left side
	// // angle
	// newTop.rlSlope = original.rlSlope;
	//
	// newTop.rlSlopeA = original.rlSlopeA;
	//
	// newTop.rlSlopeBA = original.rlSlopeBA;
	//
	// newTop.rrAngle = original.rrAngle;
	// // to
	// // right side
	// // angle
	// newTop.rrAngleA = original.rrAngleA;
	// // to
	// // right side
	// // angle
	// newTop.rrAngleBA = original.rrAngleBA;
	// // to
	// // right side
	// // angle
	// newTop.rrSlope = original.rrSlope;
	//
	// newTop.rrSlopeA = original.rrSlopeA;
	//
	// newTop.rrSlopeBA = original.rrSlopeBA;
	//
	// newTop.slope = original.slope;
	// newTop.slopeA = original.slopeA;
	// newTop.slopeBA = original.slopeBA;
	// newTop.slopeBC = original.slopeBC;
	// newTop.startAngle = original.startAngle;
	// newTop.startAngleA = original.startAngleA;
	// newTop.startAngleBA = original.startAngleBA;
	// newTop.startAngleBC = original.startAngleBC;
	// newTop.startingX = original.startingX;
	//
	// newTop.startingXA = original.startingXA;
	//
	// newTop.startingXBA = original.startingXBA;
	//
	// newTop.startingXBC = original.startingXBC;
	//
	// newTop.startingY = original.startingY;
	// newTop.startingYA = original.startingYA;
	// newTop.startingYBA = original.startingYBA;
	// newTop.startingYBC = original.startingYBC;
	// newTop.startX = original.startXC;
	// newTop.startXA = original.startXA;
	// newTop.startXBA = original.startXBA;
	// newTop.startXBC = original.startXBC;
	// newTop.startY = original.startYC;
	// newTop.startYA = original.startYA;
	// newTop.startYBA = original.startYBA;
	// newTop.startYBC = original.startYBC;
	// newTop.stockCode = original.stockCode;
	//
	// // From Rules
	//
	// newTop.totalDepth = original.totalDepth;
	// newTop.totalSurfaceArea = original.totalSurfaceArea;
	//
	// newTop.endTypeLT = original.endTypeLT;
	// newTop.endTypeRB = original.endTypeRB;
	//
	// newTop.rgb_R = original.rgb_R;
	// newTop.rgb_G = original.rgb_G;
	// newTop.rgb_B = original.rgb_B;
	//
	// newTop.rgb_Rt = original.rgb_Rt;
	// newTop.rgb_Gt = original.rgb_Gt;
	// newTop.rgb_Bt = original.rgb_Bt;
	//
	// newTop.profileSelected = 0;
	//
	// newTop.mullionLeft = original.mullionLeft;
	// newTop.mullionRight = original.mullionRight;
	// newTop.posInUse = original.posInUse;
	// newTop.stopAeX = original.stopAeX;
	// newTop.stopAeY = original.stopAeY;
	// newTop.stopAsX = original.stopAsX;
	// newTop.stopAsY = original.stopAsY;
	//
	// return newTop;
	// }
	//
	// /**
	// * Cloning Profiles to Bot2Object
	// *
	// * @param newTop, Bot2Object
	// * @param original, Profiles
	// * @return Bot2Object
	// */
	// public Bot2Object myBot2Clone(Bot2Object newTop, Profiles original) {
	//
	// newTop.bkgrdHeight = original.bkgrdHeight;
	// newTop.bkgrdHeightA = original.bkgrdHeightA;
	// newTop.bkgrdHeightBA = original.bkgrdHeightBA;
	// newTop.bkgrdHeightBC = original.bkgrdHeightBC;
	// newTop.bkgrdStartX = original.bkgrdStartX;
	// newTop.bkgrdStartXA = original.bkgrdStartXA;
	// newTop.bkgrdStartXBA = original.bkgrdStartXBA;
	// newTop.x1 = original.x1;
	// newTop.y1 = original.y1;
	// newTop.x2 = original.x2;
	// newTop.y2 = original.y2;
	// newTop.x1A = original.x1A;
	// newTop.y1A = original.y1A;
	// newTop.x2A = original.x2A;
	// newTop.y2A = original.y2A;
	// newTop.x1BA = original.x1BA;
	// newTop.y1BA = original.y1BA;
	// newTop.x2BA = original.x2BA;
	// newTop.y2BA = original.y2BA;
	// newTop.bkgrdStartXBC = original.bkgrdStartXBC;
	// newTop.bkgrdStartY = original.bkgrdStartY;
	//
	// newTop.bkgrdStartYA = original.bkgrdStartYA;
	// newTop.bkgrdStartYBA = original.bkgrdStartYBA;
	// newTop.bkgrdStartYBC = original.bkgrdStartYBC;
	//
	// newTop.bkgrdWidth = original.bkgrdWidth;
	// newTop.bkgrdWidthA = original.bkgrdWidthA;
	//
	// newTop.bkgrdWidthBA = original.bkgrdWidthBA;
	// newTop.bkgrdWidthBC = original.bkgrdWidthBC;
	// newTop.centralAngle = original.centralAngle;
	// newTop.centralAngleA = original.centralAngleA;
	//
	// newTop.centralAngleBA = original.centralAngleBA;
	//
	// newTop.centralAngleBC = original.centralAngleBC;
	// newTop.dimB1A = original.dimB1A;
	//
	// newTop.dimB1B = original.dimB1B;
	// newTop.endAngle = original.endAngle;
	//
	// newTop.endAngleA = original.endAngleA;
	//
	// newTop.endAngleBA = original.endAngleBA;
	// newTop.endAngleBC = original.endAngleBC;
	//
	// newTop.endX = original.endXC;
	// newTop.endXA = original.endXA;
	//
	// newTop.endXBA = original.endXBA;
	// newTop.endXBC = original.endXBC;
	// newTop.endY = original.endYC;
	//
	// newTop.endYA = original.endYA;
	// newTop.endYBA = original.endYBA;
	//
	// newTop.endYBC = original.endYBC;
	// newTop.focal1X = original.focal1X;
	//
	// newTop.focal1XA = original.focal1XA;
	// newTop.focal1XBA = original.focal1XBA;
	// newTop.focal1XBC = original.focal1XBC;
	// newTop.focal1Y = original.focal1Y;
	//
	// newTop.focal1YA = original.focal1YA;
	// newTop.focal1YBA = original.focal1YBA;
	//
	// newTop.focal1YBC = original.focal1YBC;
	//
	// newTop.focal2X = original.focal2X;
	// newTop.focal2XA = original.focal2XA;
	//
	// newTop.focal2XBA = original.focal2XBA;
	// newTop.focal2XBC = original.focal2XBC;
	//
	// newTop.focal2Y = original.focal2Y;
	//
	// newTop.focal2YA = original.focal2YA;
	// newTop.focal2YBA = original.focal2YBA;
	//
	// newTop.focal2YBC = original.focal2YBC;
	// newTop.glazingDepth = original.glazingDepth;
	//
	// newTop.inLaminateArea = original.inLaminateArea;
	// newTop.inPaintArea = original.inPaintArea;
	//
	// newTop.length = original.length;
	// newTop.lengthA = original.lengthA;
	// newTop.lengthBA = original.lengthBA;
	//
	// newTop.lengthBC = original.lengthBC;
	// newTop.ltAngle = original.ltAngle;
	//
	// newTop.ltAngleA = original.ltAngleA;
	// newTop.ltAngleBA = original.ltAngleBA;
	//
	// newTop.ltAngleBC = original.ltAngleBC;
	// newTop.mitreLengthLT = original.mitreLengthLT;
	// newTop.mitreLengthRB = original.mitreLengthRB;
	//
	// newTop.myWidthA = original.myWidthA;
	//
	// newTop.myWidthBA = original.myWidthBA;
	//
	// newTop.outLaminateArea = original.outLaminateArea;
	// newTop.outPaintArea = original.outPaintArea;
	//
	// newTop.partDimA = original.partDimA;
	// // newTop.partDimA2 = original.partDimAi;
	// newTop.partDimB = original.partDimB;
	// // newTop.partDimB2 = original.partDimBi;
	// newTop.partDimC = original.partDimC;
	// // newTop.partDimC2 = original.partDimCi;
	// newTop.partDimM = original.partDimM;
	// newTop.partForm = original.partForm; // 1
	// // lines, 2
	// // arc, 3
	// // Ellipse
	//
	// newTop.partID = original.partID;
	// newTop.partShape = original.partShape; // L,
	// // T, Z,
	// // I, H,
	//
	// newTop.position = original.position; // 1
	// // top, 2
	// // right, 3
	// // bot, 4 left
	// newTop.seq = original.seq;
	// newTop.radianCentralAngle = original.radianCentralAngle;
	//
	// newTop.radius1 = original.radius1;
	// newTop.radius1A = original.radius1A;
	// newTop.radius1BA = original.radius1BA;
	// newTop.radius1BC = original.radius1BC;
	//
	// newTop.radius2 = original.radius2;
	//
	// newTop.radius2A = original.radius2A;
	// newTop.radius2BA = original.radius2BA;
	//
	// newTop.radius2BC = original.radius2BC;
	//
	// newTop.rbAngle = original.rbAngle;
	// newTop.rbAngleA = original.rbAngleA;
	// newTop.rbAngleBA = original.rbAngleBA;
	// newTop.rbAngleBC = original.rbAngleBC;
	// // From Level Shape and Calculates
	// newTop.rID = original.rID; // Get next
	// // record ID
	// // from DB
	// newTop.rlAngle = original.rlAngle;
	// // to left
	// // side angle
	// newTop.rlAngleA = original.rlAngleA;
	// // to
	// // left side
	// // angle
	// newTop.rlAngleBA = original.rlAngleBA;
	// // to
	// // left side
	// // angle
	// newTop.rlSlope = original.rlSlope;
	//
	// newTop.rlSlopeA = original.rlSlopeA;
	//
	// newTop.rlSlopeBA = original.rlSlopeBA;
	//
	// newTop.rrAngle = original.rrAngle;
	// // to
	// // right side
	// // angle
	// newTop.rrAngleA = original.rrAngleA;
	// // to
	// // right side
	// // angle
	// newTop.rrAngleBA = original.rrAngleBA;
	// // to
	// // right side
	// // angle
	// newTop.rrSlope = original.rrSlope;
	//
	// newTop.rrSlopeA = original.rrSlopeA;
	//
	// newTop.rrSlopeBA = original.rrSlopeBA;
	//
	// newTop.slope = original.slope;
	// newTop.slopeA = original.slopeA;
	// newTop.slopeBA = original.slopeBA;
	// newTop.slopeBC = original.slopeBC;
	// newTop.startAngle = original.startAngle;
	// newTop.startAngleA = original.startAngleA;
	// newTop.startAngleBA = original.startAngleBA;
	// newTop.startAngleBC = original.startAngleBC;
	// newTop.startingX = original.startingX;
	//
	// newTop.startingXA = original.startingXA;
	//
	// newTop.startingXBA = original.startingXBA;
	//
	// newTop.startingXBC = original.startingXBC;
	//
	// newTop.startingY = original.startingY;
	// newTop.startingYA = original.startingYA;
	// newTop.startingYBA = original.startingYBA;
	// newTop.startingYBC = original.startingYBC;
	// newTop.startX = original.startXC;
	// newTop.startXA = original.startXA;
	// newTop.startXBA = original.startXBA;
	// newTop.startXBC = original.startXBC;
	// newTop.startY = original.startYC;
	// newTop.startYA = original.startYA;
	// newTop.startYBA = original.startYBA;
	// newTop.startYBC = original.startYBC;
	// newTop.stockCode = original.stockCode;
	//
	// // From Rules
	//
	// newTop.totalDepth = original.totalDepth;
	// newTop.totalSurfaceArea = original.totalSurfaceArea;
	//
	// newTop.endTypeLT = original.endTypeLT;
	// newTop.endTypeRB = original.endTypeRB;
	//
	// newTop.rgb_R = original.rgb_R;
	// newTop.rgb_G = original.rgb_G;
	// newTop.rgb_B = original.rgb_B;
	//
	// newTop.rgb_Rt = original.rgb_Rt;
	// newTop.rgb_Gt = original.rgb_Gt;
	// newTop.rgb_Bt = original.rgb_Bt;
	//
	// newTop.profileSelected = 0;
	//
	// newTop.mullionLeft = original.mullionLeft;
	// newTop.mullionRight = original.mullionRight;
	// newTop.posInUse = original.posInUse;
	// newTop.stopAeX = original.stopAeX;
	// newTop.stopAeY = original.stopAeY;
	// newTop.stopAsX = original.stopAsX;
	// newTop.stopAsY = original.stopAsY;
	//
	// return newTop;
	// }
	//
	// /**
	// * Cloning Profiles to Bot3Object
	// *
	// * @param newTop, Bot3Object
	// * @param original, Profiles
	// * @return Bot3Object
	// */
	// public Bot3Object myBot3Clone(Bot3Object newTop, Profiles original) {
	//
	// newTop.bkgrdHeight = original.bkgrdHeight;
	// newTop.bkgrdHeightA = original.bkgrdHeightA;
	// newTop.bkgrdHeightBA = original.bkgrdHeightBA;
	// newTop.bkgrdHeightBC = original.bkgrdHeightBC;
	// newTop.bkgrdStartX = original.bkgrdStartX;
	// newTop.bkgrdStartXA = original.bkgrdStartXA;
	// newTop.bkgrdStartXBA = original.bkgrdStartXBA;
	// newTop.x1 = original.x1;
	// newTop.y1 = original.y1;
	// newTop.x2 = original.x2;
	// newTop.y2 = original.y2;
	// newTop.x1A = original.x1A;
	// newTop.y1A = original.y1A;
	// newTop.x2A = original.x2A;
	// newTop.y2A = original.y2A;
	// newTop.x1BA = original.x1BA;
	// newTop.y1BA = original.y1BA;
	// newTop.x2BA = original.x2BA;
	// newTop.y2BA = original.y2BA;
	// newTop.bkgrdStartXBC = original.bkgrdStartXBC;
	// newTop.bkgrdStartY = original.bkgrdStartY;
	//
	// newTop.bkgrdStartYA = original.bkgrdStartYA;
	// newTop.bkgrdStartYBA = original.bkgrdStartYBA;
	// newTop.bkgrdStartYBC = original.bkgrdStartYBC;
	//
	// newTop.bkgrdWidth = original.bkgrdWidth;
	// newTop.bkgrdWidthA = original.bkgrdWidthA;
	//
	// newTop.bkgrdWidthBA = original.bkgrdWidthBA;
	// newTop.bkgrdWidthBC = original.bkgrdWidthBC;
	// newTop.centralAngle = original.centralAngle;
	// newTop.centralAngleA = original.centralAngleA;
	//
	// newTop.centralAngleBA = original.centralAngleBA;
	//
	// newTop.centralAngleBC = original.centralAngleBC;
	// newTop.dimB1A = original.dimB1A;
	//
	// newTop.dimB1B = original.dimB1B;
	// newTop.endAngle = original.endAngle;
	//
	// newTop.endAngleA = original.endAngleA;
	//
	// newTop.endAngleBA = original.endAngleBA;
	// newTop.endAngleBC = original.endAngleBC;
	//
	// newTop.endX = original.endXC;
	// newTop.endXA = original.endXA;
	//
	// newTop.endXBA = original.endXBA;
	// newTop.endXBC = original.endXBC;
	// newTop.endY = original.endYC;
	//
	// newTop.endYA = original.endYA;
	// newTop.endYBA = original.endYBA;
	//
	// newTop.endYBC = original.endYBC;
	// newTop.focal1X = original.focal1X;
	//
	// newTop.focal1XA = original.focal1XA;
	// newTop.focal1XBA = original.focal1XBA;
	// newTop.focal1XBC = original.focal1XBC;
	// newTop.focal1Y = original.focal1Y;
	//
	// newTop.focal1YA = original.focal1YA;
	// newTop.focal1YBA = original.focal1YBA;
	//
	// newTop.focal1YBC = original.focal1YBC;
	//
	// newTop.focal2X = original.focal2X;
	// newTop.focal2XA = original.focal2XA;
	//
	// newTop.focal2XBA = original.focal2XBA;
	// newTop.focal2XBC = original.focal2XBC;
	//
	// newTop.focal2Y = original.focal2Y;
	//
	// newTop.focal2YA = original.focal2YA;
	// newTop.focal2YBA = original.focal2YBA;
	//
	// newTop.focal2YBC = original.focal2YBC;
	// newTop.glazingDepth = original.glazingDepth;
	//
	// newTop.inLaminateArea = original.inLaminateArea;
	// newTop.inPaintArea = original.inPaintArea;
	//
	// newTop.length = original.length;
	// newTop.lengthA = original.lengthA;
	// newTop.lengthBA = original.lengthBA;
	//
	// newTop.lengthBC = original.lengthBC;
	// newTop.ltAngle = original.ltAngle;
	//
	// newTop.ltAngleA = original.ltAngleA;
	// newTop.ltAngleBA = original.ltAngleBA;
	//
	// newTop.ltAngleBC = original.ltAngleBC;
	// newTop.mitreLengthLT = original.mitreLengthLT;
	// newTop.mitreLengthRB = original.mitreLengthRB;
	//
	// newTop.myWidthA = original.myWidthA;
	//
	// newTop.myWidthBA = original.myWidthBA;
	//
	// newTop.outLaminateArea = original.outLaminateArea;
	// newTop.outPaintArea = original.outPaintArea;
	//
	// newTop.partDimA = original.partDimA;
	// // newTop.partDimA2 = original.partDimAi;
	// newTop.partDimB = original.partDimB;
	// // newTop.partDimB2 = original.partDimBi;
	// newTop.partDimC = original.partDimC;
	// // newTop.partDimC2 = original.partDimCi;
	// newTop.partDimM = original.partDimM;
	//
	// newTop.partForm = original.partForm; // 1
	// // lines, 2
	// // arc, 3
	// // Ellipse
	//
	// newTop.partID = original.partID;
	// newTop.partShape = original.partShape; // L,
	// // T, Z,
	// // I, H,
	//
	// newTop.position = original.position; // 1
	// // top, 2
	// // right, 3
	// // bot, 4 left
	// newTop.seq = original.seq;
	// newTop.radianCentralAngle = original.radianCentralAngle;
	//
	// newTop.radius1 = original.radius1;
	// newTop.radius1A = original.radius1A;
	// newTop.radius1BA = original.radius1BA;
	// newTop.radius1BC = original.radius1BC;
	//
	// newTop.radius2 = original.radius2;
	//
	// newTop.radius2A = original.radius2A;
	// newTop.radius2BA = original.radius2BA;
	//
	// newTop.radius2BC = original.radius2BC;
	//
	// newTop.rbAngle = original.rbAngle;
	// newTop.rbAngleA = original.rbAngleA;
	// newTop.rbAngleBA = original.rbAngleBA;
	// newTop.rbAngleBC = original.rbAngleBC;
	//
	// newTop.rID = original.rID;
	//
	// newTop.rlAngle = original.rlAngle;
	// // to left
	// // side angle
	// newTop.rlAngleA = original.rlAngleA;
	// // to
	// // left side
	// // angle
	// newTop.rlAngleBA = original.rlAngleBA;
	// // to
	// // left side
	// // angle
	// newTop.rlSlope = original.rlSlope;
	//
	// newTop.rlSlopeA = original.rlSlopeA;
	//
	// newTop.rlSlopeBA = original.rlSlopeBA;
	//
	// newTop.rrAngle = original.rrAngle;
	// // to
	// // right side
	// // angle
	// newTop.rrAngleA = original.rrAngleA;
	// // to
	// // right side
	// // angle
	// newTop.rrAngleBA = original.rrAngleBA;
	// // to
	// // right side
	// // angle
	// newTop.rrSlope = original.rrSlope;
	//
	// newTop.rrSlopeA = original.rrSlopeA;
	//
	// newTop.rrSlopeBA = original.rrSlopeBA;
	//
	// newTop.slope = original.slope;
	// newTop.slopeA = original.slopeA;
	// newTop.slopeBA = original.slopeBA;
	// newTop.slopeBC = original.slopeBC;
	// newTop.startAngle = original.startAngle;
	// newTop.startAngleA = original.startAngleA;
	// newTop.startAngleBA = original.startAngleBA;
	// newTop.startAngleBC = original.startAngleBC;
	// newTop.startingX = original.startingX;
	//
	// newTop.startingXA = original.startingXA;
	//
	// newTop.startingXBA = original.startingXBA;
	//
	// newTop.startingXBC = original.startingXBC;
	//
	// newTop.startingY = original.startingY;
	// newTop.startingYA = original.startingYA;
	// newTop.startingYBA = original.startingYBA;
	// newTop.startingYBC = original.startingYBC;
	// newTop.startX = original.startXC;
	// newTop.startXA = original.startXA;
	// newTop.startXBA = original.startXBA;
	// newTop.startXBC = original.startXBC;
	// newTop.startY = original.startYC;
	// newTop.startYA = original.startYA;
	// newTop.startYBA = original.startYBA;
	// newTop.startYBC = original.startYBC;
	// newTop.stockCode = original.stockCode;
	//
	// // From Rules
	//
	// newTop.totalDepth = original.totalDepth;
	// newTop.totalSurfaceArea = original.totalSurfaceArea;
	//
	// newTop.endTypeLT = original.endTypeLT;
	// newTop.endTypeRB = original.endTypeRB;
	//
	// newTop.rgb_R = original.rgb_R;
	// newTop.rgb_G = original.rgb_G;
	// newTop.rgb_B = original.rgb_B;
	//
	// newTop.rgb_Rt = original.rgb_Rt;
	// newTop.rgb_Gt = original.rgb_Gt;
	// newTop.rgb_Bt = original.rgb_Bt;
	//
	// newTop.profileSelected = 0;
	//
	// newTop.mullionLeft = original.mullionLeft;
	// newTop.mullionRight = original.mullionRight;
	// newTop.posInUse = original.posInUse;
	// newTop.stopAeX = original.stopAeX;
	// newTop.stopAeY = original.stopAeY;
	// newTop.stopAsX = original.stopAsX;
	// newTop.stopAsY = original.stopAsY;
	//
	// return newTop;
	// }
	//
	// /**
	// * Cloning Bot1Object to Bot3Object
	// *
	// * @param newTop, Bot3Object
	// * @param original, Bot1Object
	// * @return Bot3Object
	// */
	// public Bot3Object myBot3Clone(Bot3Object newTop, Bot1Object original) {
	//
	// newTop.bkgrdHeight = original.bkgrdHeight;
	// newTop.bkgrdHeightA = original.bkgrdHeightA;
	// newTop.bkgrdHeightBA = original.bkgrdHeightBA;
	// newTop.bkgrdHeightBC = original.bkgrdHeightBC;
	// newTop.bkgrdStartX = original.bkgrdStartX;
	// newTop.bkgrdStartXA = original.bkgrdStartXA;
	// newTop.bkgrdStartXBA = original.bkgrdStartXBA;
	// newTop.x1 = original.x1;
	// newTop.y1 = original.y1;
	// newTop.x2 = original.x2;
	// newTop.y2 = original.y2;
	// newTop.x1A = original.x1A;
	// newTop.y1A = original.y1A;
	// newTop.x2A = original.x2A;
	// newTop.y2A = original.y2A;
	// newTop.x1BA = original.x1BA;
	// newTop.y1BA = original.y1BA;
	// newTop.x2BA = original.x2BA;
	// newTop.y2BA = original.y2BA;
	// newTop.bkgrdStartXBC = original.bkgrdStartXBC;
	// newTop.bkgrdStartY = original.bkgrdStartY;
	//
	// newTop.bkgrdStartYA = original.bkgrdStartYA;
	// newTop.bkgrdStartYBA = original.bkgrdStartYBA;
	// newTop.bkgrdStartYBC = original.bkgrdStartYBC;
	//
	// newTop.bkgrdWidth = original.bkgrdWidth;
	// newTop.bkgrdWidthA = original.bkgrdWidthA;
	//
	// newTop.bkgrdWidthBA = original.bkgrdWidthBA;
	// newTop.bkgrdWidthBC = original.bkgrdWidthBC;
	// newTop.centralAngle = original.centralAngle;
	// newTop.centralAngleA = original.centralAngleA;
	//
	// newTop.centralAngleBA = original.centralAngleBA;
	//
	// newTop.centralAngleBC = original.centralAngleBC;
	// newTop.dimB1A = original.dimB1A;
	//
	// newTop.dimB1B = original.dimB1B;
	// newTop.endAngle = original.endAngle;
	//
	// newTop.endAngleA = original.endAngleA;
	//
	// newTop.endAngleBA = original.endAngleBA;
	// newTop.endAngleBC = original.endAngleBC;
	//
	// newTop.endX = original.endX;
	// newTop.endXA = original.endXA;
	//
	// newTop.endXBA = original.endXBA;
	// newTop.endXBC = original.endXBC;
	// newTop.endY = original.endY;
	//
	// newTop.endYA = original.endYA;
	// newTop.endYBA = original.endYBA;
	//
	// newTop.endYBC = original.endYBC;
	// newTop.focal1X = original.focal1X;
	//
	// newTop.focal1XA = original.focal1XA;
	// newTop.focal1XBA = original.focal1XBA;
	// newTop.focal1XBC = original.focal1XBC;
	// newTop.focal1Y = original.focal1Y;
	//
	// newTop.focal1YA = original.focal1YA;
	// newTop.focal1YBA = original.focal1YBA;
	//
	// newTop.focal1YBC = original.focal1YBC;
	//
	// newTop.focal2X = original.focal2X;
	// newTop.focal2XA = original.focal2XA;
	//
	// newTop.focal2XBA = original.focal2XBA;
	// newTop.focal2XBC = original.focal2XBC;
	//
	// newTop.focal2Y = original.focal2Y;
	//
	// newTop.focal2YA = original.focal2YA;
	// newTop.focal2YBA = original.focal2YBA;
	//
	// newTop.focal2YBC = original.focal2YBC;
	// newTop.glazingDepth = original.glazingDepth;
	//
	// newTop.inLaminateArea = original.inLaminateArea;
	// newTop.inPaintArea = original.inPaintArea;
	//
	// newTop.length = original.length;
	// newTop.lengthA = original.lengthA;
	// newTop.lengthBA = original.lengthBA;
	//
	// newTop.lengthBC = original.lengthBC;
	// newTop.ltAngle = original.ltAngle;
	//
	// newTop.ltAngleA = original.ltAngleA;
	// newTop.ltAngleBA = original.ltAngleBA;
	//
	// newTop.ltAngleBC = original.ltAngleBC;
	// newTop.mitreLengthLT = original.mitreLengthLT;
	// newTop.mitreLengthRB = original.mitreLengthRB;
	//
	// newTop.myWidthA = original.myWidthA;
	//
	// newTop.myWidthBA = original.myWidthBA;
	//
	// newTop.outLaminateArea = original.outLaminateArea;
	// newTop.outPaintArea = original.outPaintArea;
	//
	// newTop.partDimA = original.partDimA;
	// newTop.partDimA2 = original.partDimA2;
	// newTop.partDimB = original.partDimB;
	// newTop.partDimB2 = original.partDimB2;
	// newTop.partDimC = original.partDimC;
	// newTop.partDimC2 = original.partDimC2;
	// newTop.partDimM = original.partDimM;
	// newTop.partForm = original.partForm;
	// // lines, 2
	// // arc, 3
	// // Ellipse
	//
	// newTop.partID = original.partID;
	// newTop.partShape = original.partShape;
	//
	// newTop.position = original.position;
	// newTop.seq = original.seq;
	// newTop.radianCentralAngle = original.radianCentralAngle;
	//
	// newTop.radius1 = original.radius1;
	// newTop.radius1A = original.radius1A;
	// newTop.radius1BA = original.radius1BA;
	// newTop.radius1BC = original.radius1BC;
	//
	// newTop.radius2 = original.radius2;
	//
	// newTop.radius2A = original.radius2A;
	// newTop.radius2BA = original.radius2BA;
	//
	// newTop.radius2BC = original.radius2BC;
	//
	// newTop.rbAngle = original.rbAngle;
	// newTop.rbAngleA = original.rbAngleA;
	// newTop.rbAngleBA = original.rbAngleBA;
	// newTop.rbAngleBC = original.rbAngleBC;
	//
	// newTop.rID = original.rID;
	// newTop.rlAngle = original.rlAngle;
	//
	// newTop.rlAngleA = original.rlAngleA;
	//
	// newTop.rlAngleBA = original.rlAngleBA;
	//
	// newTop.rlSlope = original.rlSlope;
	//
	// newTop.rlSlopeA = original.rlSlopeA;
	//
	// newTop.rlSlopeBA = original.rlSlopeBA;
	//
	// newTop.rrAngle = original.rrAngle;
	// // to
	// // right side
	// // angle
	// newTop.rrAngleA = original.rrAngleA;
	// // to
	// // right side
	// // angle
	// newTop.rrAngleBA = original.rrAngleBA;
	// // to
	// // right side
	// // angle
	// newTop.rrSlope = original.rrSlope;
	//
	// newTop.rrSlopeA = original.rrSlopeA;
	//
	// newTop.rrSlopeBA = original.rrSlopeBA;
	//
	// newTop.slope = original.slope;
	// newTop.slopeA = original.slopeA;
	// newTop.slopeBA = original.slopeBA;
	// newTop.slopeBC = original.slopeBC;
	// newTop.startAngle = original.startAngle;
	// newTop.startAngleA = original.startAngleA;
	// newTop.startAngleBA = original.startAngleBA;
	// newTop.startAngleBC = original.startAngleBC;
	// newTop.startingX = original.startingX;
	//
	// newTop.startingXA = original.startingXA;
	//
	// newTop.startingXBA = original.startingXBA;
	//
	// newTop.startingXBC = original.startingXBC;
	//
	// newTop.startingY = original.startingY;
	// newTop.startingYA = original.startingYA;
	// newTop.startingYBA = original.startingYBA;
	// newTop.startingYBC = original.startingYBC;
	// newTop.startX = original.startX;
	// newTop.startXA = original.startXA;
	// newTop.startXBA = original.startXBA;
	// newTop.startXBC = original.startXBC;
	// newTop.startY = original.startY;
	// newTop.startYA = original.startYA;
	// newTop.startYBA = original.startYBA;
	// newTop.startYBC = original.startYBC;
	// newTop.stockCode = original.stockCode;
	//
	// // From Rules
	//
	// newTop.totalDepth = original.totalDepth;
	// newTop.totalSurfaceArea = original.totalSurfaceArea;
	//
	// newTop.endTypeLT = original.endTypeLT;
	// newTop.endTypeRB = original.endTypeRB;
	//
	// newTop.rgb_R = original.rgb_R;
	// newTop.rgb_G = original.rgb_G;
	// newTop.rgb_B = original.rgb_B;
	//
	// newTop.rgb_Rt = original.rgb_Rt;
	// newTop.rgb_Gt = original.rgb_Gt;
	// newTop.rgb_Bt = original.rgb_Bt;
	//
	// newTop.profileSelected = 0;
	//
	// newTop.mullionLeft = original.mullionLeft;
	// newTop.mullionRight = original.mullionRight;
	// newTop.posInUse = original.posInUse;
	// newTop.stopAeX = original.stopAeX;
	// newTop.stopAeY = original.stopAeY;
	// newTop.stopAsX = original.stopAsX;
	// newTop.stopAsY = original.stopAsY;
	//
	// return newTop;
	// }
	//
	// /**
	// * Cloning Profiles to LeftObject
	// *
	// * @param newTop, LeftObject
	// * @param original, Profiles
	// * @return LeftObject
	// */
	// public LeftObject myLeftClone(LeftObject newTop, Profiles original) {
	//
	// newTop.bkgrdHeight = original.bkgrdHeight;
	// newTop.bkgrdHeightA = original.bkgrdHeightA;
	// newTop.bkgrdHeightBA = original.bkgrdHeightBA;
	// newTop.bkgrdHeightBC = original.bkgrdHeightBC;
	// newTop.bkgrdStartX = original.bkgrdStartX;
	// newTop.bkgrdStartXA = original.bkgrdStartXA;
	// newTop.bkgrdStartXBA = original.bkgrdStartXBA;
	// newTop.x1 = original.x1;
	// newTop.y1 = original.y1;
	// newTop.x2 = original.x2;
	// newTop.y2 = original.y2;
	// newTop.x1A = original.x1A;
	// newTop.y1A = original.y1A;
	// newTop.x2A = original.x2A;
	// newTop.y2A = original.y2A;
	// newTop.x1BA = original.x1BA;
	// newTop.y1BA = original.y1BA;
	// newTop.x2BA = original.x2BA;
	// newTop.y2BA = original.y2BA;
	// newTop.bkgrdStartXBC = original.bkgrdStartXBC;
	// newTop.bkgrdStartY = original.bkgrdStartY;
	//
	// newTop.bkgrdStartYA = original.bkgrdStartYA;
	// newTop.bkgrdStartYBA = original.bkgrdStartYBA;
	// newTop.bkgrdStartYBC = original.bkgrdStartYBC;
	//
	// newTop.bkgrdWidth = original.bkgrdWidth;
	// newTop.bkgrdWidthA = original.bkgrdWidthA;
	//
	// newTop.bkgrdWidthBA = original.bkgrdWidthBA;
	// newTop.bkgrdWidthBC = original.bkgrdWidthBC;
	// newTop.centralAngle = original.centralAngle;
	// newTop.centralAngleA = original.centralAngleA;
	//
	// newTop.centralAngleBA = original.centralAngleBA;
	//
	// newTop.centralAngleBC = original.centralAngleBC;
	// newTop.dimB1A = original.dimB1A;
	//
	// newTop.dimB1B = original.dimB1B;
	// newTop.endAngle = original.endAngle;
	//
	// newTop.endAngleA = original.endAngleA;
	//
	// newTop.endAngleBA = original.endAngleBA;
	// newTop.endAngleBC = original.endAngleBC;
	//
	// newTop.endX = original.endXC;
	// newTop.endXA = original.endXA;
	//
	// newTop.endXBA = original.endXBA;
	// newTop.endXBC = original.endXBC;
	// newTop.endY = original.endYC;
	//
	// newTop.endYA = original.endYA;
	// newTop.endYBA = original.endYBA;
	//
	// newTop.endYBC = original.endYBC;
	// newTop.focal1X = original.focal1X;
	//
	// newTop.focal1XA = original.focal1XA;
	// newTop.focal1XBA = original.focal1XBA;
	// newTop.focal1XBC = original.focal1XBC;
	// newTop.focal1Y = original.focal1Y;
	//
	// newTop.focal1YA = original.focal1YA;
	// newTop.focal1YBA = original.focal1YBA;
	//
	// newTop.focal1YBC = original.focal1YBC;
	//
	// newTop.focal2X = original.focal2X;
	// newTop.focal2XA = original.focal2XA;
	//
	// newTop.focal2XBA = original.focal2XBA;
	// newTop.focal2XBC = original.focal2XBC;
	//
	// newTop.focal2Y = original.focal2Y;
	//
	// newTop.focal2YA = original.focal2YA;
	// newTop.focal2YBA = original.focal2YBA;
	//
	// newTop.focal2YBC = original.focal2YBC;
	// newTop.glazingDepth = original.glazingDepth;
	//
	// newTop.inLaminateArea = original.inLaminateArea;
	// newTop.inPaintArea = original.inPaintArea;
	//
	// newTop.length = original.length;
	// newTop.lengthA = original.lengthA;
	// newTop.lengthBA = original.lengthBA;
	//
	// newTop.lengthBC = original.lengthBC;
	// newTop.ltAngle = original.ltAngle;
	//
	// newTop.ltAngleA = original.ltAngleA;
	// newTop.ltAngleBA = original.ltAngleBA;
	//
	// newTop.ltAngleBC = original.ltAngleBC;
	// newTop.mitreLengthLT = original.mitreLengthLT;
	// newTop.mitreLengthRB = original.mitreLengthRB;
	//
	// newTop.myWidthA = original.myWidthA;
	//
	// newTop.myWidthBA = original.myWidthBA;
	//
	// newTop.outLaminateArea = original.outLaminateArea;
	// newTop.outPaintArea = original.outPaintArea;
	//
	// newTop.partDimA = original.partDimA;
	// // newTop.partDimA2 = original.partDimAi;
	// newTop.partDimB = original.partDimB;
	// // newTop.partDimB2 = original.partDimBi;
	// newTop.partDimC = original.partDimC;
	// // newTop.partDimC2 = original.partDimCi;
	// newTop.partDimM = original.partDimM;
	// newTop.partForm = original.partForm; // 1
	// // lines, 2
	// // arc, 3
	// // Ellipse
	//
	// newTop.partID = original.partID;
	// newTop.partShape = original.partShape; // L,
	// // T, Z,
	// // I, H,
	//
	// newTop.position = original.position; // 1
	// // top, 2
	// // right, 3
	// // bot, 4 left
	// newTop.seq = original.seq;
	// newTop.radianCentralAngle = original.radianCentralAngle;
	//
	// newTop.radius1 = original.radius1;
	// newTop.radius1A = original.radius1A;
	// newTop.radius1BA = original.radius1BA;
	// newTop.radius1BC = original.radius1BC;
	//
	// newTop.radius2 = original.radius2;
	//
	// newTop.radius2A = original.radius2A;
	// newTop.radius2BA = original.radius2BA;
	//
	// newTop.radius2BC = original.radius2BC;
	//
	// newTop.rbAngle = original.rbAngle;
	// newTop.rbAngleA = original.rbAngleA;
	// newTop.rbAngleBA = original.rbAngleBA;
	// newTop.rbAngleBC = original.rbAngleBC;
	// // From Level Shape and Calculates
	// newTop.rID = original.rID; // Get next
	// // record ID
	// // from DB
	// newTop.rlAngle = original.rlAngle;
	// // to left
	// // side angle
	// newTop.rlAngleA = original.rlAngleA;
	// // to
	// // left side
	// // angle
	// newTop.rlAngleBA = original.rlAngleBA;
	// // to
	// // left side
	// // angle
	// newTop.rlSlope = original.rlSlope;
	//
	// newTop.rlSlopeA = original.rlSlopeA;
	//
	// newTop.rlSlopeBA = original.rlSlopeBA;
	//
	// newTop.rrAngle = original.rrAngle;
	// // to
	// // right side
	// // angle
	// newTop.rrAngleA = original.rrAngleA;
	// // to
	// // right side
	// // angle
	// newTop.rrAngleBA = original.rrAngleBA;
	// // to
	// // right side
	// // angle
	// newTop.rrSlope = original.rrSlope;
	//
	// newTop.rrSlopeA = original.rrSlopeA;
	//
	// newTop.rrSlopeBA = original.rrSlopeBA;
	//
	// newTop.slope = original.slope;
	// newTop.slopeA = original.slopeA;
	// newTop.slopeBA = original.slopeBA;
	// newTop.slopeBC = original.slopeBC;
	// newTop.startAngle = original.startAngle;
	// newTop.startAngleA = original.startAngleA;
	// newTop.startAngleBA = original.startAngleBA;
	// newTop.startAngleBC = original.startAngleBC;
	// newTop.startingX = original.startingX;
	//
	// newTop.startingXA = original.startingXA;
	//
	// newTop.startingXBA = original.startingXBA;
	//
	// newTop.startingXBC = original.startingXBC;
	//
	// newTop.startingY = original.startingY;
	// newTop.startingYA = original.startingYA;
	// newTop.startingYBA = original.startingYBA;
	// newTop.startingYBC = original.startingYBC;
	// newTop.startX = original.startXC;
	// newTop.startXA = original.startXA;
	// newTop.startXBA = original.startXBA;
	// newTop.startXBC = original.startXBC;
	// newTop.startY = original.startYC;
	// newTop.startYA = original.startYA;
	// newTop.startYBA = original.startYBA;
	// newTop.startYBC = original.startYBC;
	// newTop.stockCode = original.stockCode;
	//
	// // From Rules
	//
	// newTop.totalDepth = original.totalDepth;
	// newTop.totalSurfaceArea = original.totalSurfaceArea;
	//
	// newTop.endTypeLT = original.endTypeLT;
	// newTop.endTypeRB = original.endTypeRB;
	//
	// newTop.rgb_R = original.rgb_R;
	// newTop.rgb_G = original.rgb_G;
	// newTop.rgb_B = original.rgb_B;
	//
	// newTop.rgb_Rt = original.rgb_Rt;
	// newTop.rgb_Gt = original.rgb_Gt;
	// newTop.rgb_Bt = original.rgb_Bt;
	//
	// newTop.profileSelected = 0;
	//
	// newTop.mullionLeft = original.mullionLeft;
	// newTop.mullionRight = original.mullionRight;
	// newTop.posInUse = original.posInUse;
	// newTop.stopAeX = original.stopAeX;
	// newTop.stopAeY = original.stopAeY;
	// newTop.stopAsX = original.stopAsX;
	// newTop.stopAsY = original.stopAsY;
	//
	// return newTop;
	// }
	//
	// /**
	// * Cloning Profiles to RightObject
	// *
	// * @param newTop, RightObject
	// * @param original, Profiles
	// * @return RightObject
	// */
	// public RightObject myRightClone(RightObject newTop, Profiles original) {
	//
	// newTop.bkgrdHeight = original.bkgrdHeight;
	// newTop.bkgrdHeightA = original.bkgrdHeightA;
	// newTop.bkgrdHeightBA = original.bkgrdHeightBA;
	// newTop.bkgrdHeightBC = original.bkgrdHeightBC;
	// newTop.bkgrdStartX = original.bkgrdStartX;
	// newTop.bkgrdStartXA = original.bkgrdStartXA;
	// newTop.bkgrdStartXBA = original.bkgrdStartXBA;
	// newTop.x1 = original.x1;
	// newTop.y1 = original.y1;
	// newTop.x2 = original.x2;
	// newTop.y2 = original.y2;
	// newTop.x1A = original.x1A;
	// newTop.y1A = original.y1A;
	// newTop.x2A = original.x2A;
	// newTop.y2A = original.y2A;
	// newTop.x1BA = original.x1BA;
	// newTop.y1BA = original.y1BA;
	// newTop.x2BA = original.x2BA;
	// newTop.y2BA = original.y2BA;
	// newTop.bkgrdStartXBC = original.bkgrdStartXBC;
	// newTop.bkgrdStartY = original.bkgrdStartY;
	//
	// newTop.bkgrdStartYA = original.bkgrdStartYA;
	// newTop.bkgrdStartYBA = original.bkgrdStartYBA;
	// newTop.bkgrdStartYBC = original.bkgrdStartYBC;
	//
	// newTop.bkgrdWidth = original.bkgrdWidth;
	// newTop.bkgrdWidthA = original.bkgrdWidthA;
	//
	// newTop.bkgrdWidthBA = original.bkgrdWidthBA;
	// newTop.bkgrdWidthBC = original.bkgrdWidthBC;
	// newTop.centralAngle = original.centralAngle;
	// newTop.centralAngleA = original.centralAngleA;
	//
	// newTop.centralAngleBA = original.centralAngleBA;
	//
	// newTop.centralAngleBC = original.centralAngleBC;
	// newTop.dimB1A = original.dimB1A;
	//
	// newTop.dimB1B = original.dimB1B;
	// newTop.endAngle = original.endAngle;
	//
	// newTop.endAngleA = original.endAngleA;
	//
	// newTop.endAngleBA = original.endAngleBA;
	// newTop.endAngleBC = original.endAngleBC;
	//
	// newTop.endX = original.endXC;
	// newTop.endXA = original.endXA;
	//
	// newTop.endXBA = original.endXBA;
	// newTop.endXBC = original.endXBC;
	// newTop.endY = original.endYC;
	//
	// newTop.endYA = original.endYA;
	// newTop.endYBA = original.endYBA;
	//
	// newTop.endYBC = original.endYBC;
	// newTop.focal1X = original.focal1X;
	//
	// newTop.focal1XA = original.focal1XA;
	// newTop.focal1XBA = original.focal1XBA;
	// newTop.focal1XBC = original.focal1XBC;
	// newTop.focal1Y = original.focal1Y;
	//
	// newTop.focal1YA = original.focal1YA;
	// newTop.focal1YBA = original.focal1YBA;
	//
	// newTop.focal1YBC = original.focal1YBC;
	//
	// newTop.focal2X = original.focal2X;
	// newTop.focal2XA = original.focal2XA;
	//
	// newTop.focal2XBA = original.focal2XBA;
	// newTop.focal2XBC = original.focal2XBC;
	//
	// newTop.focal2Y = original.focal2Y;
	//
	// newTop.focal2YA = original.focal2YA;
	// newTop.focal2YBA = original.focal2YBA;
	//
	// newTop.focal2YBC = original.focal2YBC;
	// newTop.glazingDepth = original.glazingDepth;
	//
	// newTop.inLaminateArea = original.inLaminateArea;
	// newTop.inPaintArea = original.inPaintArea;
	//
	// newTop.length = original.length;
	// newTop.lengthA = original.lengthA;
	// newTop.lengthBA = original.lengthBA;
	//
	// newTop.lengthBC = original.lengthBC;
	// newTop.ltAngle = original.ltAngle;
	//
	// newTop.ltAngleA = original.ltAngleA;
	// newTop.ltAngleBA = original.ltAngleBA;
	//
	// newTop.ltAngleBC = original.ltAngleBC;
	// newTop.mitreLengthLT = original.mitreLengthLT;
	// newTop.mitreLengthRB = original.mitreLengthRB;
	//
	// newTop.myWidthA = original.myWidthA;
	//
	// newTop.myWidthBA = original.myWidthBA;
	//
	// newTop.outLaminateArea = original.outLaminateArea;
	// newTop.outPaintArea = original.outPaintArea;
	//
	// newTop.partDimA = original.partDimA;
	// // newTop.partDimA2 = original.partDimAi;
	// newTop.partDimB = original.partDimB;
	// // newTop.partDimB2 = original.partDimBi;
	// newTop.partDimC = original.partDimC;
	// // newTop.partDimC2 = original.partDimCi;
	// newTop.partDimM = original.partDimM;
	// newTop.partForm = original.partForm; // 1
	// // lines, 2
	// // arc, 3
	// // Ellipse
	//
	// newTop.partID = original.partID;
	// newTop.partShape = original.partShape; // L,
	// // T, Z,
	// // I, H,
	//
	// newTop.position = original.position; // 1
	// // top, 2
	// // right, 3
	// // bot, 4 left
	// newTop.seq = original.seq;
	// newTop.radianCentralAngle = original.radianCentralAngle;
	//
	// newTop.radius1 = original.radius1;
	// newTop.radius1A = original.radius1A;
	// newTop.radius1BA = original.radius1BA;
	// newTop.radius1BC = original.radius1BC;
	//
	// newTop.radius2 = original.radius2;
	//
	// newTop.radius2A = original.radius2A;
	// newTop.radius2BA = original.radius2BA;
	//
	// newTop.radius2BC = original.radius2BC;
	//
	// newTop.rbAngle = original.rbAngle;
	// newTop.rbAngleA = original.rbAngleA;
	// newTop.rbAngleBA = original.rbAngleBA;
	// newTop.rbAngleBC = original.rbAngleBC;
	// // From Level Shape and Calculates
	// newTop.rID = original.rID; // Get next
	// // record ID
	// // from DB
	// newTop.rlAngle = original.rlAngle;
	// // to left
	// // side angle
	// newTop.rlAngleA = original.rlAngleA;
	// // to
	// // left side
	// // angle
	// newTop.rlAngleBA = original.rlAngleBA;
	// // to
	// // left side
	// // angle
	// newTop.rlSlope = original.rlSlope;
	//
	// newTop.rlSlopeA = original.rlSlopeA;
	//
	// newTop.rlSlopeBA = original.rlSlopeBA;
	//
	// newTop.rrAngle = original.rrAngle;
	// // to
	// // right side
	// // angle
	// newTop.rrAngleA = original.rrAngleA;
	// // to
	// // right side
	// // angle
	// newTop.rrAngleBA = original.rrAngleBA;
	// // to
	// // right side
	// // angle
	// newTop.rrSlope = original.rrSlope;
	//
	// newTop.rrSlopeA = original.rrSlopeA;
	//
	// newTop.rrSlopeBA = original.rrSlopeBA;
	//
	// newTop.slope = original.slope;
	// newTop.slopeA = original.slopeA;
	// newTop.slopeBA = original.slopeBA;
	// newTop.slopeBC = original.slopeBC;
	// newTop.startAngle = original.startAngle;
	// newTop.startAngleA = original.startAngleA;
	// newTop.startAngleBA = original.startAngleBA;
	// newTop.startAngleBC = original.startAngleBC;
	// newTop.startingX = original.startingX;
	//
	// newTop.startingXA = original.startingXA;
	//
	// newTop.startingXBA = original.startingXBA;
	//
	// newTop.startingXBC = original.startingXBC;
	//
	// newTop.startingY = original.startingY;
	// newTop.startingYA = original.startingYA;
	// newTop.startingYBA = original.startingYBA;
	// newTop.startingYBC = original.startingYBC;
	// newTop.startX = original.startXC;
	// newTop.startXA = original.startXA;
	// newTop.startXBA = original.startXBA;
	// newTop.startXBC = original.startXBC;
	// newTop.startY = original.startYC;
	// newTop.startYA = original.startYA;
	// newTop.startYBA = original.startYBA;
	// newTop.startYBC = original.startYBC;
	// newTop.stockCode = original.stockCode;
	//
	// // From Rules
	//
	// newTop.totalDepth = original.totalDepth;
	// newTop.totalSurfaceArea = original.totalSurfaceArea;
	//
	// newTop.endTypeLT = original.endTypeLT;
	// newTop.endTypeRB = original.endTypeRB;
	//
	// newTop.rgb_R = original.rgb_R;
	// newTop.rgb_G = original.rgb_G;
	// newTop.rgb_B = original.rgb_B;
	//
	// newTop.rgb_Rt = original.rgb_Rt;
	// newTop.rgb_Gt = original.rgb_Gt;
	// newTop.rgb_Bt = original.rgb_Bt;
	//
	// newTop.profileSelected = 0;
	//
	// newTop.mullionLeft = original.mullionLeft;
	// newTop.mullionRight = original.mullionRight;
	//
	// newTop.posInUse = original.posInUse;
	// newTop.stopAeX = original.stopAeX;
	// newTop.stopAeY = original.stopAeY;
	// newTop.stopAsX = original.stopAsX;
	// newTop.stopAsY = original.stopAsY;
	//
	// return newTop;
	// }
	
	public double[] getArchesTopGeneric(final ShapeObject myInitOpening, final double sX, final double sY, final double eX,
				final double eY, final double sX2, final double sY2, final double eX2, final double eY2, final boolean reverse)
	{
	
		final double[] myAngles = new double[4];
		double mycenter1 = myInitOpening.myParent.top1Part.x1;
		double mycenter2 = myInitOpening.myParent.top1Part.x1;
		
		if (myInitOpening.myParent.shapeID >= 450 && myInitOpening.myParent.shapeID <= 461)
		{
			mycenter1 = myInitOpening.myParent.top1Part.x1;
			
			mycenter2 = myInitOpening.myParent.top2Part.x1;
			
		}
		if (reverse)
		{
			mycenter1 = myInitOpening.myParent.top2Part.x1;
			
		}
		
		if (myInitOpening.top1.partForm == 2 && myInitOpening.top1.endX <= myInitOpening.myParent.top1Part.endXC)
		{
			
			double baseR = mycenter1 - eX;
			double baseL = mycenter1 - sX;
			
			final double heightR = myInitOpening.myParent.top1Part.y1 - eY;
			
			final double heightL = myInitOpening.myParent.top1Part.y1 - sY;
			
			double startAngle = 0;
			double endAngle = 0;
			double extentAngle = 0;
			
			if (baseR > 0)
			{
				if (heightR > 0)
				{
					startAngle = Math.abs(Math.toDegrees(Math.toRadians(180) - Math.atan(heightR / baseR)));
					
				}
				if (heightL > 0)
				{
					endAngle = Math.abs(Math.toDegrees(Math.toRadians(180) - Math.atan(heightL / baseL)));
					
				}
				else
				{
					endAngle = 180;
					
				}
				
				extentAngle = endAngle - startAngle;
				
			}
			if (baseR < 0 && baseL < 0)
			{
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);
				
				startAngle = Math.abs(Math.toDegrees(Math.atan(heightR / baseR)));
				
				if (heightL > 0)
				{
					endAngle = Math.abs(Math.toDegrees(Math.atan(heightL / baseL)));
					
				}
				else
				{
					endAngle = 180;
					
				}
				
				extentAngle = endAngle - startAngle;
				
			}
			if (baseR < 0 && baseL > 0)
			{
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);
				
				startAngle = Math.abs(Math.toDegrees(Math.atan(heightR / baseR)));
				
				if (heightL > 0)
				{
					endAngle = Math.abs(Math.toDegrees(Math.toRadians(180) - Math.atan(heightL / baseL)));
					
				}
				else
				{
					endAngle = 180;
					
				}
				
				extentAngle = endAngle - startAngle;
				
			}
			if (baseR < 0 && baseL == 0)
			{
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);
				
				startAngle = Math.abs(Math.toDegrees(Math.atan(heightR / baseR)));
				
				endAngle = 90;
				
				extentAngle = endAngle - startAngle;
				
			}
			if (baseR == 0 && baseL < 0)
			{
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);
				
				startAngle = 90;
				
				endAngle = Math.abs(Math.toDegrees(Math.toRadians(180) - Math.atan(heightL / baseL)));
				
				extentAngle = endAngle - startAngle;
				
				extentAngle = endAngle - startAngle;
			}
			
			myAngles[0] = startAngle;
			myAngles[1] = extentAngle;
			
		}
		else if (myInitOpening.top1.partForm == 2 && myInitOpening.top1.startX >= myInitOpening.myParent.top1Part.endXC)
		{
			
			double baseR = mycenter1 - eX;
			double baseL = mycenter1 - sX;
			
			final double heightR = myInitOpening.myParent.top1Part.y1 - eY;
			
			final double heightL = myInitOpening.myParent.top1Part.y1 - sY;
			
			double startAngle = 0;
			double endAngle = 0;
			double extentAngle = 0;
			
			if (baseR > 0)
			{
				if (heightR > 0)
				{
					startAngle = Math.abs(Math.toDegrees(Math.toRadians(180) - Math.atan(heightR / baseR)));
				}
				if (heightL > 0)
				{
					endAngle = Math.abs(Math.toDegrees(Math.toRadians(180) - Math.atan(heightL / baseL)));
				}
				else
				{
					endAngle = 180;
				}
				
				extentAngle = endAngle - startAngle;
				
			}
			if (baseR < 0 && baseL < 0)
			{
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);
				
				startAngle = Math.abs(Math.toDegrees(Math.atan(heightR / baseR)));
				if (heightL > 0)
				{
					endAngle = Math.abs(Math.toDegrees(Math.atan(heightL / baseL)));
				}
				else
				{
					endAngle = 180;
				}
				
				extentAngle = endAngle - startAngle;
			}
			if (baseR < 0 && baseL > 0)
			{
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);
				
				startAngle = Math.abs(Math.toDegrees(Math.atan(heightR / baseR)));
				if (heightL > 0)
				{
					endAngle = Math.abs(Math.toDegrees(Math.toRadians(180) - Math.atan(heightL / baseL)));
				}
				else
				{
					endAngle = 180;
				}
				
				extentAngle = endAngle - startAngle;
			}
			if (baseR < 0 && baseL == 0)
			{
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);
				
				startAngle = Math.abs(Math.toDegrees(Math.atan(heightR / baseR)));
				
				endAngle = 90;
				
				extentAngle = endAngle - startAngle;
			}
			if (baseR == 0 && baseL < 0)
			{
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);
				
				startAngle = 90;
				
				endAngle = Math.abs(Math.toDegrees(Math.toRadians(180) - Math.atan(heightL / baseL)));
				
				extentAngle = endAngle - startAngle;
			}
			
			myAngles[0] = startAngle;
			myAngles[1] = extentAngle;
			
			// ////A//////
			
		}
		// /////////////////////////////////////////////////////////////////////
		
		if (myInitOpening.top2.partForm == 2 && myInitOpening.noSidesTop > 1)
		{
			
			double baseR = mycenter2 - eX2;
			double baseL = mycenter2 - sX2;
			
			final double heightR = myInitOpening.myParent.top1Part.y1 - eY2;
			
			final double heightL = myInitOpening.myParent.top1Part.y1 - sY2;
			
			double startAngle = 0;
			double endAngle = 0;
			double extentAngle = 0;
			if (baseR > 0)
			{
				if (heightR > 0)
				{
					startAngle = Math.abs(Math.toDegrees(Math.toRadians(180) - Math.atan(heightR / baseR)));
				}
				if (heightL > 0)
				{
					endAngle = Math.abs(Math.toDegrees(Math.toRadians(180) - Math.atan(heightL / baseL)));
				}
				else
				{
					endAngle = 180;
				}
				
				extentAngle = endAngle - startAngle;
				
			}
			if (baseR < 0 && baseL < 0)
			{
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);
				
				startAngle = Math.abs(Math.toDegrees(Math.atan(heightR / baseR)));
				if (heightL > 0)
				{
					endAngle = Math.abs(Math.toDegrees(Math.atan(heightL / baseL)));
				}
				else
				{
					endAngle = 180;
				}
				
				extentAngle = endAngle - startAngle;
			}
			if (baseR < 0 && baseL > 0)
			{
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);
				
				startAngle = Math.abs(Math.toDegrees(Math.atan(heightR / baseR)));
				if (heightL > 0)
				{
					endAngle = Math.abs(Math.toDegrees(Math.toRadians(180) - Math.atan(heightL / baseL)));
				}
				else
				{
					endAngle = 180;
				}
				
				extentAngle = endAngle - startAngle;
			}
			if (baseR < 0 && baseL == 0)
			{
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);
				
				startAngle = Math.abs(Math.toDegrees(Math.atan(heightR / baseR)));
				
				endAngle = 90;
				
				extentAngle = endAngle - startAngle;
			}
			if (baseR == 0 && baseL < 0)
			{
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);
				
				startAngle = 90;
				
				endAngle = Math.abs(Math.toDegrees(Math.toRadians(180) - Math.atan(heightL / baseL)));
				
				extentAngle = endAngle - startAngle;
			}
			
			myAngles[2] = startAngle;
			
			if (myInitOpening.topIn)
			{
				myAngles[3] = extentAngle;
			}
			else
			{
				myAngles[3] = myInitOpening.top1.endAngle;
				
			}
		}
		// /////////////////////////////////////////////////
		if (myInitOpening.leftIn && myInitOpening.rightIn && myInitOpening.noSidesTop == 2)
		{
			double baseR = mycenter1 - eX;
			double baseL = mycenter1 - sX;
			
			double heightR = myInitOpening.myParent.bOpeningObject.myParent.top1Part.y1 - myInitOpening.top1.endY;
			
			double heightL = myInitOpening.myParent.bOpeningObject.myParent.top1Part.y1 - myInitOpening.top1.startY;
			
			double startAngle = 0;
			double endAngle = 0;
			double extentAngle = 0;
			
			if (baseR > 0)
			{
				if (heightR > 0)
				{
					startAngle = Math.abs(Math.toDegrees(Math.toRadians(180) - Math.atan(heightR / baseR)));
				}
				if (heightL > 0)
				{
					endAngle = Math.abs(Math.toDegrees(Math.toRadians(180) - Math.atan(heightL / baseL)));
				}
				else
				{
					endAngle = 180;
				}
				
				extentAngle = endAngle - startAngle;
				
			}
			if (baseR < 0 && baseL < 0)
			{
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);
				
				startAngle = Math.abs(Math.toDegrees(Math.atan(heightR / baseR)));
				if (heightL > 0)
				{
					endAngle = Math.abs(Math.toDegrees(Math.atan(heightL / baseL)));
				}
				else
				{
					endAngle = 180;
				}
				
				extentAngle = endAngle - startAngle;
			}
			if (baseR < 0 && baseL > 0)
			{
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);
				
				startAngle = Math.abs(Math.toDegrees(Math.atan(heightR / baseR)));
				if (heightL > 0)
				{
					endAngle = Math.abs(Math.toDegrees(Math.toRadians(180) - Math.atan(heightL / baseL)));
				}
				else
				{
					endAngle = 180;
				}
				
				extentAngle = endAngle - startAngle;
			}
			if (baseR < 0 && baseL == 0)
			{
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);
				
				startAngle = Math.abs(Math.toDegrees(Math.atan(heightR / baseR)));
				
				endAngle = 90;
				
				extentAngle = endAngle - startAngle;
			}
			if (baseR == 0 && baseL < 0)
			{
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);
				
				startAngle = 90;
				
				endAngle = Math.abs(Math.toDegrees(Math.toRadians(180) - Math.atan(heightL / baseL)));
				
				extentAngle = endAngle - startAngle;
			}
			
			myAngles[0] = startAngle;
			myAngles[1] = extentAngle;
			
			baseR = mycenter2 - eX2;
			baseL = mycenter2 - sX2;
			
			heightR = myInitOpening.myParent.bOpeningObject.myParent.top1Part.y1 - eY2;
			
			heightL = myInitOpening.myParent.bOpeningObject.myParent.top1Part.y1 - sY2;
			
			startAngle = 0;
			endAngle = 0;
			extentAngle = 0;
			if (baseR > 0)
			{
				if (heightR > 0)
				{
					startAngle = Math.abs(Math.toDegrees(Math.toRadians(180) - Math.atan(heightR / baseR)));
				}
				if (heightL > 0)
				{
					endAngle = Math.abs(Math.toDegrees(Math.toRadians(180) - Math.atan(heightL / baseL)));
				}
				else
				{
					endAngle = 180;
				}
				
				extentAngle = endAngle - startAngle;
				
			}
			if (baseR < 0 && baseL < 0)
			{
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);
				
				startAngle = Math.abs(Math.toDegrees(Math.atan(heightR / baseR)));
				if (heightL > 0)
				{
					endAngle = Math.abs(Math.toDegrees(Math.atan(heightL / baseL)));
				}
				else
				{
					endAngle = 180;
				}
				
				extentAngle = endAngle - startAngle;
			}
			if (baseR < 0 && baseL > 0)
			{
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);
				
				startAngle = Math.abs(Math.toDegrees(Math.atan(heightR / baseR)));
				if (heightL > 0)
				{
					endAngle = Math.abs(Math.toDegrees(Math.toRadians(180) - Math.atan(heightL / baseL)));
				}
				else
				{
					endAngle = 180;
				}
				
				extentAngle = endAngle - startAngle;
			}
			if (baseR < 0 && baseL == 0)
			{
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);
				
				startAngle = Math.abs(Math.toDegrees(Math.atan(heightR / baseR)));
				
				endAngle = 90;
				
				extentAngle = endAngle - startAngle;
			}
			if (baseR == 0 && baseL < 0)
			{
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);
				
				startAngle = 90;
				
				endAngle = Math.abs(Math.toDegrees(Math.toRadians(180) - Math.atan(heightL / baseL)));
				
				extentAngle = endAngle - startAngle;
			}
			
			myAngles[2] = startAngle;
			
			myAngles[3] = extentAngle;
			
			// /////A////////
			
		}
		return myAngles;
		
	}
	
}

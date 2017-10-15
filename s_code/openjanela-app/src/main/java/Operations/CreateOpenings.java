/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/

package Operations;

import Model.*;
import Model.ProfileParts.*;
import Presentation.ItemFrame;
import dto.ProfileDTO;
import openjanela.model.eao.partner.seriesValidOpeningShapeEAO.SeriesValidOpeningShapeEAO;
import openjanela.model.eao.partner.seriesValidOpeningShapeEAO.SeriesValidOpeningShapePersistenceEAO;
import openjanela.model.entities.partner.SUType;
import openjanela.model.entities.partner.SeriesValidOpeningShape;

import javax.swing.*;

import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public class CreateOpenings {

	public ShapeObject myParent;

	public double couplerX1 = 0;

	public double couplerX2 = 0;

	public double couplerX3 = 0;

	public double couplerX4 = 0;

	public double couplerCX = 0;

	public double couplerCXe = 0;

	public double couplerY1 = 0;

	public double couplerY2 = 0;

	public double couplerY3 = 0;

	public double couplerY4 = 0;

	public double couplerCY = 0;

	public double couplerCYe = 0;

	public double couplerX1r = 0;

	public double couplerX2r = 0;

	public double couplerX3r = 0;

	public double couplerX4r = 0;

	public double couplerCXr = 0;

	public double couplerCXre = 0;

	public double couplerY1r = 0;

	public double couplerY2r = 0;

	public double couplerY3r = 0;

	public double couplerY4r = 0;

	public double couplerCYr = 0;

	public double couplerCYre = 0;

	public double couplerX1h = 0;

	public double couplerX2h = 0;

	public double couplerX3h = 0;

	public double couplerX4h = 0;

	public double couplerCXh = 0;

	public double couplerCXhe = 0;

	public double couplerY1h = 0;

	public double couplerY2h = 0;

	public double couplerY3h = 0;

	public double couplerY4h = 0;

	public double couplerCYh = 0;

	public double couplerCYhe = 0;

	public double couplerX1rh = 0;

	public double couplerX2rh = 0;

	public double couplerX3rh = 0;

	public double couplerX4rh = 0;

	public double couplerCXrh = 0;

	public double couplerCXrhe = 0;

	public double couplerY1rh = 0;

	public double couplerY2rh = 0;

	public double couplerY3rh = 0;

	public double couplerY4rh = 0;

	public double couplerCYrh = 0;

	public double couplerCYrhe = 0;

	public double couplerThickTotal = 0;

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

	public int lean = 0;

	public int lean2 = 0;

	public int lean3 = 0;

	public int lean4 = 0;

	public int pLevel = 0;
	public int pSequence = 0;
	public int gpLevel = 0;
	public int a_2Sequence = 0;
	public int ggpLevel = 0;
	public int ga_2Sequence = 0;
	public int gggpLevel = 0;
	public int gga_2Sequence = 0;

	public boolean changeShape = false;

	public int whichOpening = 0;

	public Object myFrame;

	public Object[] myOpeningObjects;

	public double wt = 0; // actual

	public double hl = 0;

	public double wtc = 0; // Center

	public double hlc = 0;

	public double wb = 0; // actual

	public double hr = 0;

	public double wbc = 0; // Center

	public double hrc = 0;

	public double wtA = 0; // actual

	public double hlA = 0;

	public double wbA = 0; // actual

	public double hrA = 0;

	public int shape = 0;

	public int sequence = 0;

	public double startingX = 0;

	public double startingY = 0;

	public int startCol = 0;

	public int endCol = 0;

	public int startRow = 0;

	public int endRow = 0;

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

	public double b1b3X = 0;

	public double b1b3Y = 0;

	public double t1t2XA = 0;

	public double t1t2YA = 0;

	public double t1t3XA = 0;

	public double t1t3YA = 0;

	public double t3t2XA = 0;

	public double t3t2YA = 0;

	public double b1b2XA = 0;

	public double b1b2YA = 0;

	public double b1b3XA = 0;

	public double b1b3YA = 0;

	public double a1 = 0;

	public double a2 = 0;

	public double a3 = 0;

	public double a4 = 0;

	public double a5 = 0;

	public double a0 = 0;

	public double b1 = 0;

	public double b2 = 0;

	public double b3 = 0;

	public double b4 = 0;

	public double b5 = 0;

	public double b0 = 0;

	public double c1 = 0;

	public double c2 = 0;

	public double c3 = 0;

	public double c4 = 0;

	public double c5 = 0;

	public double c0 = 0;

	public double d1 = 0;

	public double d2 = 0;

	public double d3 = 0;

	public double d4 = 0;

	public double d5 = 0;

	public double d0 = 0;

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

	public double bkgrdStartXA = 0;

	public double bkgrdStartYA = 0;

	public double centralAngle = 0;

	public double startingCX = 0;

	public double startingCY = 0;

	public double bCX2 = 0;

	public double bCY2 = 0;

	public double bCX3 = 0;

	public double bCY3 = 0;

	public double bCX4 = 0;

	public double bCY4 = 0;

	public double startingXA = 0;

	public double startingYA = 0;

	public double bX1A = 0;

	public double bY1A = 0;

	public double bX2A = 0;

	public double bY2A = 0;

	public double bX3A = 0;

	public double bY3A = 0;

	public double bX4A = 0;

	public double bY4A = 0;

	public boolean topIn = false;

	public boolean botIn = false;

	public boolean rightIn = false;

	public boolean leftIn = false;

	public double myStartingX = 0;

	public double myStartingY = 0;

	public double myEndingX = 0;

	public double myEndingY = 0;

	public double myStartingXA = 0;

	public double myStartingYA = 0;

	public double myEndingXA = 0;

	public double myEndingYA = 0;

	public OpeningObject myNewOpening;

	public double dimTM = 0;

	public double dimBM = 0;

	public double dimLM = 0;

	public double dimRM = 0;

	public double dimTA = 0;

	public double dimBA = 0;

	public double dimLA = 0;

	public double dimRA = 0;

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

	public int top1Form = 1;

	public int top2Form = 1;

	public int top3Form = 1;

	public int bot1Form = 1;

	public int bot2Form = 1;

	public int bot3Form = 1;

	public int leftForm = 1;

	public int rightForm = 1;

	Top1Object top1Object;

	Top2Object top2Object;

	Top3Object top3Object;

	RightObject rightObject;

	Bot1Object bot1Object;

	Bot2Object bot2Object;

	Bot3Object bot3Object;

	LeftObject leftObject;

	Object[] parts = null;

	public double highestX = 0;

	public double lowestX = 0;

	public double highestY = 0;

	public double lowestY = 0;

	public double highestYC = 0;

	public double lowestYC = 0;

	// ///
	double tx1 = 0;

	double ty1 = 0;

	double tx2 = 0;

	double ty2 = 0;

	double tx1A = 0;

	double ty1A = 0;

	double tx2A = 0;

	double ty2A = 0;

	double tx1c = 0;

	double ty1c = 0;

	double tx2c = 0;

	double ty2c = 0;

	double t2x1 = 0;

	double t2y1 = 0;

	double t2x2 = 0;

	double t2y2 = 0;

	double t2x1A = 0;

	double t2y1A = 0;

	double t2x2A = 0;

	double t2y2A = 0;

	double t2x1c = 0;

	double t2y1c = 0;

	double t2x2c = 0;

	double t2y2c = 0;

	double t3x1 = 0;

	double t3y1 = 0;

	double t3x2 = 0;

	double t3y2 = 0;

	double t3x1A = 0;

	double t3y1A = 0;

	double t3x2A = 0;

	double t3y2A = 0;

	double t3x1c = 0;

	double t3y1c = 0;

	double t3x2c = 0;

	double t3y2c = 0;

	int t1s = 1;

	int t2s = 1;

	int t3s = 1;

	int b1s = 1;

	int b2s = 1;

	int b3s = 1;

	// /////

	double bx1 = 0;

	double by1 = 0;

	double bx2 = 0;

	double by2 = 0;

	double bx1A = 0;

	double by1A = 0;

	double bx2A = 0;

	double by2A = 0;

	double bx1c = 0;

	double by1c = 0;

	double bx2c = 0;

	double by2c = 0;

	double b2x1 = 0;

	double b2y1 = 0;

	double b2x2 = 0;

	double b2y2 = 0;

	double b2x1A = 0;

	double b2y1A = 0;

	double b2x2A = 0;

	double b2y2A = 0;

	double b2x1c = 0;

	double b2y1c = 0;

	double b2x2c = 0;

	double b2y2c = 0;

	double b3x1 = 0;

	double b3y1 = 0;

	double b3x2 = 0;

	double b3y2 = 0;

	double b3x1A = 0;

	double b3y1A = 0;

	double b3x2A = 0;

	double b3y2A = 0;

	double b3x1c = 0;

	double b3y1c = 0;

	double b3x2c = 0;

	double b3y2c = 0;

	// //////

	double lx1 = 0;

	double ly1 = 0;

	double lx2 = 0;

	double ly2 = 0;

	double lx1A = 0;

	double ly1A = 0;

	double lx2A = 0;

	double ly2A = 0;

	double lx1c = 0;

	double ly1c = 0;

	double lx2c = 0;

	double ly2c = 0;

	// //////

	double rx1 = 0;

	double ry1 = 0;

	double rx2 = 0;

	double ry2 = 0;

	double rx1A = 0;

	double ry1A = 0;

	double rx2A = 0;

	double ry2A = 0;

	double rx1c = 0;

	double ry1c = 0;

	double rx2c = 0;

	double ry2c = 0;

	public BkgrdOpeningObject myBOpening = null;

	double scale = 0;

	ItemFrame myFrame2;

	boolean leanChanged = false;

	/**
	 * Create opening
	 * 
	 * @param parent
	 *            , ShapeObject
	 * @param frame
	 *            , ItemFrame
	 */
	public CreateOpenings(ShapeObject parent, ItemFrame frame) {

		myParent = parent;
		myFrame2 = frame;
		scale = myFrame2.scale.doubleValue();

		startingCX = myParent.startingCX;
		startingCY = myParent.startingCY;
		bCX2 = myParent.bCX2;
		bCY2 = myParent.bCY2;
		bCX3 = myParent.bCX3;
		bCY3 = myParent.bCY3;
		bCX4 = myParent.bCX4;
		bCY4 = myParent.bCY4;

		if (myParent.bOpeningObject != null) {
			myBOpening = myParent.bOpeningObject;
		}

	}

	public void createOpenings() throws Exception {

		/*
		 * for Column , we need to check if from 0 to yRows where the first H
		 * coupler occurs, if found, then Hcoupler is the endRow of NewFrame, if
		 * not found, then loop to the bottom, and then Parent bot y is the end.
		 */
		myBOpening.mullionObjectsH = null;
		myBOpening.mullionObjectsV = null;

		myBOpening.mullionObjectsV = myBOpening.mullions.toArray();

		myBOpening.mullionObjectsH = myBOpening.mullionsH.toArray();

		myOpeningObjects = myParent.openings.toArray();

		myParent.openings.clear();

		lean = myParent.lean;
		lean2 = myParent.lean2;
		lean3 = myParent.lean3;
		lean4 = myParent.lean4;
		myshape = myParent.shapeID;

		if (myOpeningObjects.length >= 1) {

			for (Object element : myOpeningObjects) {

				OpeningObject O = new OpeningObject(myFrame2);
				O = O.cloneOpening((OpeningObject) element);
				((ShapeObject) O).myFrame2 = myFrame2;
				O.myFrame2 = myFrame2;
				O = this.doOpenings((OpeningObject) element);

				myParent.openings.add(O);
			}
		}
		myshape = myParent.shapeID;
	}

	/**
	 * Open and validate BkgrdOpeningObject
	 * 
	 * @return BkgrdOpeningObject
	 */
	public BkgrdOpeningObject doOpenMainOpening() throws Exception {

		// *********************************************************
		// Setting ItemFrame
		// *********************************************************
		myParent.bOpeningObject.myFrame2 = myFrame2;

		// *********************************************************
		// Creating parts objects
		// *********************************************************
		myParent.bOpeningObject.top1 = new Top1Object();
		myParent.bOpeningObject.top2 = new Top2Object();
		myParent.bOpeningObject.top3 = new Top3Object();
		myParent.bOpeningObject.right = new RightObject();
		myParent.bOpeningObject.bot1 = new Bot1Object();
		myParent.bOpeningObject.bot2 = new Bot2Object();
		myParent.bOpeningObject.bot3 = new Bot3Object();
		myParent.bOpeningObject.left = new LeftObject();

		// ********************************************************
		// Cloning parts objects
		// ********************************************************
		ProfileDTO profileDTO = new ProfileDTO();
		myParent.bOpeningObject.top1 = (Top1Object) profileDTO.profilesClone(
				myParent.bOpeningObject.top1, myParent.bOpeningObject.top1Part);
		myParent.bOpeningObject.top2 = (Top2Object) profileDTO.profilesClone(
				myParent.bOpeningObject.top2, myParent.bOpeningObject.top2Part);
		myParent.bOpeningObject.top3 = (Top3Object) profileDTO.profilesClone(
				myParent.bOpeningObject.top3, myParent.bOpeningObject.top3Part);
		myParent.bOpeningObject.left = (LeftObject) profileDTO.profilesClone(
				myParent.bOpeningObject.left, myParent.bOpeningObject.leftPart);
		myParent.bOpeningObject.right = (RightObject) profileDTO.profilesClone(
				myParent.bOpeningObject.right,
				myParent.bOpeningObject.rightPart);
		myParent.bOpeningObject.bot1 = (Bot1Object) profileDTO.profilesClone(
				myParent.bOpeningObject.bot1, myParent.bOpeningObject.bot1Part);
		myParent.bOpeningObject.bot2 = (Bot2Object) profileDTO.profilesClone(
				myParent.bOpeningObject.bot2, myParent.bOpeningObject.bot2Part);
		myParent.bOpeningObject.bot3 = (Bot3Object) profileDTO.profilesClone(
				myParent.bOpeningObject.bot3, myParent.bOpeningObject.bot3Part);

		// *********************************************************
		// Setting myFacet depending of LevelID
		// *********************************************************
		if (myParent.a_levelID == 1) {
			myNewOpening.myFacet = myParent;
		} else {
			myNewOpening.myFacet = myParent.myFacet;
		}

		// *********************************************************
		// Creating frame opening object
		// *********************************************************

		// Get array of openings
		Object[] openings = myParent.openings.toArray();

		// Clear list of openings
		myParent.openings.clear();

		for (Object opening : openings) {

			// Setting itemFrame
			((OpeningObject) opening).myFrame2 = myParent.myFrame2;
			// Setting parent shape object
			((OpeningObject) opening).myParent = myParent;

			// Creating parts object
			((OpeningObject) opening).top1 = new Top1Object();
			((OpeningObject) opening).top2 = new Top2Object();
			((OpeningObject) opening).top3 = new Top3Object();
			((OpeningObject) opening).left = new LeftObject();
			((OpeningObject) opening).right = new RightObject();
			((OpeningObject) opening).bot1 = new Bot1Object();
			((OpeningObject) opening).bot2 = new Bot2Object();
			((OpeningObject) opening).bot3 = new Bot3Object();

			// Cloning parts object
			((OpeningObject) opening).top1 = (Top1Object) profileDTO
					.profilesClone(myParent.bOpeningObject.top1,
							myParent.bOpeningObject.top1Part);
			((OpeningObject) opening).top2 = (Top2Object) profileDTO
					.profilesClone(myParent.bOpeningObject.top2,
							myParent.bOpeningObject.top2Part);
			((OpeningObject) opening).top3 = (Top3Object) profileDTO
					.profilesClone(myParent.bOpeningObject.top3,
							myParent.bOpeningObject.top3Part);
			((OpeningObject) opening).left = (LeftObject) profileDTO
					.profilesClone(myParent.bOpeningObject.left,
							myParent.bOpeningObject.leftPart);
			((OpeningObject) opening).right = (RightObject) profileDTO
					.profilesClone(myParent.bOpeningObject.right,
							myParent.bOpeningObject.rightPart);
			((OpeningObject) opening).bot1 = (Bot1Object) profileDTO
					.profilesClone(myParent.bOpeningObject.bot1,
							myParent.bOpeningObject.bot1Part);
			((OpeningObject) opening).bot2 = (Bot2Object) profileDTO
					.profilesClone(myParent.bOpeningObject.bot2,
							myParent.bOpeningObject.bot2Part);
			((OpeningObject) opening).bot3 = (Bot3Object) profileDTO
					.profilesClone(myParent.bOpeningObject.bot3,
							myParent.bOpeningObject.bot3Part);

			// Do opening object
			opening = this.doOpenings((OpeningObject) opening);

			// Adding process opening to arrayList
			myParent.openings.add(opening);
		}

		return myParent.bOpeningObject;
	}

	/**
	 * Do Main Opening
	 * 
	 * @return BkgrdOpeningObject
	 */
	public BkgrdOpeningObject doMainOpening() throws Exception {

		lean = myParent.lean;
		lean2 = myParent.lean2;
		lean3 = myParent.lean3;
		lean4 = myParent.lean4;
		shape = myParent.shapeID;

		if (myParent.noSides == 2) {

			if (shape < 800) {
				startingCX = myParent.top1.startX;
				startingCY = myParent.top1.startY;
				bCX2 = myParent.top1.endX;
				bCY2 = myParent.top1.endY;
				bCX3 = bCX2;
				bCY3 = bCY2;
				bCX4 = startingCX;
				bCY4 = startingCY;
				myStartingX = bX1 = myParent.top1.startXBA;
				myStartingY = bY1 = myParent.top1.startYBA;
				bX2 = myParent.top1.endXBA;
				bY2 = myParent.top1.endYBA;
				myStartingXA = bX1A = myParent.top1.startXA;
				myStartingYA = bY1A = myParent.top1.startYA;
				bX2A = myParent.top1.endXA;
				bY2A = myParent.top1.endYA;
				bX3 = bX2;
				bY3 = bY2;
				bX3A = myParent.top1.endXA;
				bY3A = myParent.top1.endYA;
				bX4 = bX1;
				bY4 = bY1;
				bX4A = myParent.top1.startXA;
				bY4A = myParent.top1.startYA;
			} else {
				startingCX = myParent.top1.startX;
				startingCY = myParent.top1.startY;
				bCX2 = myParent.top1.endX;
				bCY2 = myParent.top1.endY;
				bCX3 = bCX2;
				bCY3 = bCY2;
				bCX4 = startingCX;
				bCY4 = startingCY;
				myStartingX = bX1 = myParent.top1.startXBA;
				myStartingY = bY1 = myParent.top1.startYBA;
				bX2 = myParent.top1.endXBA;
				bY2 = myParent.top1.endYBA;
				myStartingXA = bX1A = myParent.top1.startXA;
				myStartingYA = bY1A = myParent.top1.startYA;
				bX2A = myParent.top1.endXA;
				bY2A = myParent.top1.endYA;
				bX3 = bX2;
				bY3 = bY2;
				bX4 = bX1;
				bY4 = bY1;
			}

		} else {

			if (myParent.noSidesLeft > 0) {

				myStartingX = bX1 = this.intersectX(myParent.top1.startXBA,
						myParent.top1.startYBA, myParent.top1.endXBA,
						myParent.top1.endYBA, myParent.left.startXBA,
						myParent.left.startYBA, myParent.left.endXBA,
						myParent.left.endYBA);

				startingCX = this.intersectX(myParent.top1.startX,
						myParent.top1.startY, myParent.top1.endX,
						myParent.top1.endY, myParent.left.startX,
						myParent.left.startY, myParent.left.endX,
						myParent.left.endY);

				startingCY = this.intersectY(myParent.top1.startX,
						myParent.top1.startY, myParent.top1.endX,
						myParent.top1.endY, myParent.left.startX,
						myParent.left.startY, myParent.left.endX,
						myParent.left.endY);

				myStartingXA = bX1A = this.intersectX(myParent.top1.startXA,
						myParent.top1.startYA, myParent.top1.endXA,
						myParent.top1.endYA, myParent.left.startXA,
						myParent.left.startYA, myParent.left.endXA,
						myParent.left.endYA);

			} else if (myParent.noSidesBot == 1) {

				myStartingX = bX1 = this.intersectX(myParent.top1.startXBA,
						myParent.top1.startYBA, myParent.top1.endXBA,
						myParent.top1.endYBA, myParent.bot1.startXBA,
						myParent.bot1.startYBA, myParent.bot1.endXBA,
						myParent.bot1.endYBA);

				startingCX = this.intersectX(myParent.top1.startX,
						myParent.top1.startY, myParent.top1.endX,
						myParent.top1.endY, myParent.bot1.startX,
						myParent.bot1.startY, myParent.bot1.endX,
						myParent.bot1.endY);

				startingCY = this.intersectY(myParent.top1.startX,
						myParent.top1.startY, myParent.top1.endX,
						myParent.top1.endY, myParent.bot1.startX,
						myParent.bot1.startY, myParent.bot1.endX,
						myParent.bot1.endY);

				myStartingXA = bX1A = this.intersectX(myParent.top1.startXA,
						myParent.top1.startYA, myParent.top1.endXA,
						myParent.top1.endYA, myParent.bot1.startXA,
						myParent.bot1.startYA, myParent.bot1.endXA,
						myParent.bot1.endYA);

			} else if (myParent.noSidesBot > 1) {

				myStartingX = bX1 = this.intersectX(myParent.top1.startXBA,
						myParent.top1.startYBA, myParent.top1.endXBA,
						myParent.top1.endYBA, myParent.bot2.startXBA,
						myParent.bot2.startYBA, myParent.bot2.endXBA,
						myParent.bot2.endYBA);

				startingCX = this.intersectX(myParent.top1.startX,
						myParent.top1.startY, myParent.top1.endX,
						myParent.top1.endY, myParent.bot2.startX,
						myParent.bot2.startY, myParent.bot2.endX,
						myParent.bot2.endY);

				startingCY = this.intersectY(myParent.top1.startX,
						myParent.top1.startY, myParent.top1.endX,
						myParent.top1.endY, myParent.bot2.startX,
						myParent.bot2.startY, myParent.bot2.endX,
						myParent.bot2.endY);

				myStartingXA = bX1A = this.intersectX(myParent.top1.startXA,
						myParent.top1.startYA, myParent.top1.endXA,
						myParent.top1.endYA, myParent.bot2.startXA,
						myParent.bot2.startYA, myParent.bot2.endXA,
						myParent.bot2.endYA);
			}

			if (myParent.noSidesLeft > 0) {
				myStartingY = bY1 = this.intersectY(myParent.top1.startXBA,
						myParent.top1.startYBA, myParent.top1.endXBA,
						myParent.top1.endYBA, myParent.left.startXBA,
						myParent.left.startYBA, myParent.left.endXBA,
						myParent.left.endYBA);

				myStartingYA = bY1A = this.intersectY(myParent.top1.startXA,
						myParent.top1.startYA, myParent.top1.endXA,
						myParent.top1.endYA, myParent.left.startXA,
						myParent.left.startYA, myParent.left.endXA,
						myParent.left.endYA);

			} else if (myParent.noSidesBot == 1) {
				myStartingY = bY1 = this.intersectY(myParent.top1.startXBA,
						myParent.top1.startYBA, myParent.top1.endXBA,
						myParent.top1.endYBA, myParent.bot1.startXBA,
						myParent.bot1.startYBA, myParent.bot1.endXBA,
						myParent.bot1.endYBA);

				myStartingYA = bY1A = this.intersectY(myParent.top1.startXA,
						myParent.top1.startYA, myParent.top1.endXA,
						myParent.top1.endYA, myParent.bot1.startXA,
						myParent.bot1.startYA, myParent.bot1.endXA,
						myParent.bot1.endYA);

			} else if (myParent.noSidesBot > 1) {
				myStartingY = bY1 = this.intersectY(myParent.top1.startXBA,
						myParent.top1.startYBA, myParent.top1.endXBA,
						myParent.top1.endYBA, myParent.bot2.startXBA,
						myParent.bot2.startYBA, myParent.bot2.endXBA,
						myParent.bot2.endYBA);

				myStartingYA = bY1A = this.intersectY(myParent.top1.startXA,
						myParent.top1.startYA, myParent.top1.endXA,
						myParent.top1.endYA, myParent.bot2.startXA,
						myParent.bot2.startYA, myParent.bot2.endXA,
						myParent.bot2.endYA);
			}

			// //////// X2,Y2
			if (myParent.noSidesTop == 1) {

				if (myParent.noSidesRight > 0) {

					bX2 = myEndingX = this.intersectX(myParent.top1.startXBA,
							myParent.top1.startYBA, myParent.top1.endXBA,
							myParent.top1.endYBA, myParent.right.startXBA,
							myParent.right.startYBA, myParent.right.endXBA,
							myParent.right.endYBA);

					bCX2 = this.intersectX(myParent.top1.startX,
							myParent.top1.startY, myParent.top1.endX,
							myParent.top1.endY, myParent.right.startX,
							myParent.right.startY, myParent.right.endX,
							myParent.right.endY);

					bCY2 = this.intersectY(myParent.top1.startX,
							myParent.top1.startY, myParent.top1.endX,
							myParent.top1.endY, myParent.right.startX,
							myParent.right.startY, myParent.right.endX,
							myParent.right.endY);

					bX2A = myEndingXA = this.intersectX(myParent.top1.startXA,
							myParent.top1.startYA, myParent.top1.endXA,
							myParent.top1.endYA, myParent.right.startXA,
							myParent.right.startYA, myParent.right.endXA,
							myParent.right.endYA);

				} else if (myParent.noSidesBot == 1) {

					bX2 = myEndingX = this.intersectX(myParent.top1.startXBA,
							myParent.top1.startYBA, myParent.top1.endXBA,
							myParent.top1.endYBA, myParent.bot1.startXBA,
							myParent.bot1.startYBA, myParent.bot1.endXBA,
							myParent.bot1.endYBA);

					bCX2 = this.intersectX(myParent.top1.startX,
							myParent.top1.startY, myParent.top1.endX,
							myParent.top1.endY, myParent.bot1.startX,
							myParent.bot1.startY, myParent.bot1.endX,
							myParent.bot1.endY);

					bCY2 = this.intersectY(myParent.top1.startX,
							myParent.top1.startY, myParent.top1.endX,
							myParent.top1.endY, myParent.bot1.startX,
							myParent.bot1.startY, myParent.bot1.endX,
							myParent.bot1.endY);

					bX2A = myEndingXA = this.intersectX(myParent.top1.startXA,
							myParent.top1.startYA, myParent.top1.endXA,
							myParent.top1.endYA, myParent.bot1.startXA,
							myParent.bot1.startYA, myParent.bot1.endXA,
							myParent.bot1.endYA);

				} else if (myParent.noSidesBot == 2) {

					bX2 = myEndingX = this.intersectX(myParent.top1.startXBA,
							myParent.top1.startYBA, myParent.top1.endXBA,
							myParent.top1.endYBA, myParent.bot1.startXBA,
							myParent.bot1.startYBA, myParent.bot1.endXBA,
							myParent.bot1.endYBA);

					bCX2 = this.intersectX(myParent.top1.startX,
							myParent.top1.startY, myParent.top1.endX,
							myParent.top1.endY, myParent.bot1.startX,
							myParent.bot1.startY, myParent.bot1.endX,
							myParent.bot1.endY);

					bCY2 = this.intersectY(myParent.top1.startX,
							myParent.top1.startY, myParent.top1.endX,
							myParent.top1.endY, myParent.bot1.startX,
							myParent.bot1.startY, myParent.bot1.endX,
							myParent.bot1.endY);

					bX2A = myEndingXA = this.intersectX(myParent.top1.startXA,
							myParent.top1.startYA, myParent.top1.endXA,
							myParent.top1.endYA, myParent.bot1.startXA,
							myParent.bot1.startYA, myParent.bot1.endXA,
							myParent.bot1.endYA);

				} else if (myParent.noSidesBot == 3) {

					bX2 = myEndingX = this.intersectX(myParent.top1.startXBA,
							myParent.top1.startYBA, myParent.top1.endXBA,
							myParent.top1.endYBA, myParent.bot3.startXBA,
							myParent.bot3.startYBA, myParent.bot3.endXBA,
							myParent.bot3.endYBA);

					bCX2 = this.intersectX(myParent.top1.startX,
							myParent.top1.startY, myParent.top1.endX,
							myParent.top1.endY, myParent.bot3.startX,
							myParent.bot3.startY, myParent.bot3.endX,
							myParent.bot3.endY);

					bCY2 = this.intersectY(myParent.top1.startX,
							myParent.top1.startY, myParent.top1.endX,
							myParent.top1.endY, myParent.bot3.startX,
							myParent.bot3.startY, myParent.bot3.endX,
							myParent.bot3.endY);

					bX2A = myEndingXA = this.intersectX(myParent.top1.startXA,
							myParent.top1.startYA, myParent.top1.endXA,
							myParent.top1.endYA, myParent.bot3.startXA,
							myParent.bot3.startYA, myParent.bot3.endXA,
							myParent.bot3.endYA);
				}

				if (myParent.noSidesRight > 0) {
					bY2 = this.intersectY(myParent.top1.startXBA,
							myParent.top1.startYBA, myParent.top1.endXBA,
							myParent.top1.endYBA, myParent.right.startXBA,
							myParent.right.startYBA, myParent.right.endXBA,
							myParent.right.endYBA);

					bY2A = this.intersectY(myParent.top1.startXA,
							myParent.top1.startYA, myParent.top1.endXA,
							myParent.top1.endYA, myParent.right.startXA,
							myParent.right.startYA, myParent.right.endXA,
							myParent.right.endYA);

				} else if (myParent.noSidesBot == 1) {

					bY2 = this.intersectY(myParent.top1.startXBA,
							myParent.top1.startYBA, myParent.top1.endXBA,
							myParent.top1.endYBA, myParent.bot1.startXBA,
							myParent.bot1.startYBA, myParent.bot1.endXBA,
							myParent.bot1.endYBA);

					bY2A = this.intersectY(myParent.top1.startXA,
							myParent.top1.startYA, myParent.top1.endXA,
							myParent.top1.endYA, myParent.bot1.startXA,
							myParent.bot1.startYA, myParent.bot1.endXA,
							myParent.bot1.endYA);

				} else if (myParent.noSidesBot == 2) {

					bY2 = this.intersectY(myParent.top1.startXBA,
							myParent.top1.startYBA, myParent.top1.endXBA,
							myParent.top1.endYBA, myParent.bot1.startXBA,
							myParent.bot1.startYBA, myParent.bot1.endXBA,
							myParent.bot1.endYBA);

					bY2A = this.intersectY(myParent.top1.startXA,
							myParent.top1.startYA, myParent.top1.endXA,
							myParent.top1.endYA, myParent.bot1.startXA,
							myParent.bot1.startYA, myParent.bot1.endXA,
							myParent.bot1.endYA);

				} else if (myParent.noSidesBot == 3) {

					bY2 = this.intersectY(myParent.top1.startXBA,
							myParent.top1.startYBA, myParent.top1.endXBA,
							myParent.top1.endYBA, myParent.bot3.startXBA,
							myParent.bot3.startYBA, myParent.bot3.endXBA,
							myParent.bot3.endYBA);

					bY2A = this.intersectY(myParent.top1.startXA,
							myParent.top1.startYA, myParent.top1.endXA,
							myParent.top1.endYA, myParent.bot3.startXA,
							myParent.bot3.startYA, myParent.bot3.endXA,
							myParent.bot3.endYA);
				}
			}

			if (myParent.noSidesTop > 1) {

				if (myParent.noSidesRight > 0) {

					bX2 = myEndingX = this.intersectX(myParent.top2.startXBA,
							myParent.top2.startYBA, myParent.top2.endXBA,
							myParent.top2.endYBA, myParent.right.startXBA,
							myParent.right.startYBA, myParent.right.endXBA,
							myParent.right.endYBA);

					bCX2 = this.intersectX(myParent.top2.startX,
							myParent.top2.startY, myParent.top2.endX,
							myParent.top2.endY, myParent.right.startX,
							myParent.right.startY, myParent.right.endX,
							myParent.right.endY);

					bCY2 = this.intersectY(myParent.top2.startX,
							myParent.top2.startY, myParent.top2.endX,
							myParent.top2.endY, myParent.right.startX,
							myParent.right.startY, myParent.right.endX,
							myParent.right.endY);

					bX2A = myEndingX = this.intersectX(myParent.top2.startXA,
							myParent.top2.startYA, myParent.top2.endXA,
							myParent.top2.endYA, myParent.right.startXA,
							myParent.right.startYA, myParent.right.endXA,
							myParent.right.endYA);

				} else if (myParent.noSidesBot == 1) {

					bX2 = myEndingX = this.intersectX(myParent.top2.startXBA,
							myParent.top2.startYBA, myParent.top2.endXBA,
							myParent.top2.endYBA, myParent.bot1.startXBA,
							myParent.bot1.startYBA, myParent.bot1.endXBA,
							myParent.bot1.endYBA);

					bCX2 = this.intersectX(myParent.top2.startX,
							myParent.top2.startY, myParent.top2.endX,
							myParent.top2.endY, myParent.bot1.startX,
							myParent.bot1.startY, myParent.bot1.endX,
							myParent.bot1.endY);

					bCY2 = this.intersectY(myParent.top2.startX,
							myParent.top2.startY, myParent.top2.endX,
							myParent.top2.endY, myParent.bot1.startX,
							myParent.bot1.startY, myParent.bot1.endX,
							myParent.bot1.endY);

					bX2A = myEndingX = this.intersectX(myParent.top2.startXA,
							myParent.top2.startYA, myParent.top2.endXA,
							myParent.top2.endYA, myParent.bot1.startXA,
							myParent.bot1.startYA, myParent.bot1.endXA,
							myParent.bot1.endYA);

				} else if (myParent.noSidesBot == 2) {

					bX2 = myEndingX = this.intersectX(myParent.top2.startXBA,
							myParent.top2.startYBA, myParent.top2.endXBA,
							myParent.top2.endYBA, myParent.bot1.startXBA,
							myParent.bot1.startYBA, myParent.bot1.endXBA,
							myParent.bot1.endYBA);

					bCX2 = this.intersectX(myParent.top2.startX,
							myParent.top2.startY, myParent.top2.endX,
							myParent.top2.endY, myParent.bot1.startX,
							myParent.bot1.startY, myParent.bot1.endX,
							myParent.bot1.endY);

					bCY2 = this.intersectY(myParent.top2.startX,
							myParent.top2.startY, myParent.top2.endX,
							myParent.top2.endY, myParent.bot1.startX,
							myParent.bot1.startY, myParent.bot1.endX,
							myParent.bot1.endY);

					bX2A = myEndingX = this.intersectX(myParent.top2.startXA,
							myParent.top2.startYA, myParent.top2.endXA,
							myParent.top2.endYA, myParent.bot1.startXA,
							myParent.bot1.startYA, myParent.bot1.endXA,
							myParent.bot1.endYA);

				} else if (myParent.noSidesBot == 3) {

					bX2 = myEndingX = this.intersectX(myParent.top2.startXBA,
							myParent.top2.startYBA, myParent.top2.endXBA,
							myParent.top2.endYBA, myParent.bot3.startXBA,
							myParent.bot3.startYBA, myParent.bot3.endXBA,
							myParent.bot3.endYBA);

					bCX2 = this.intersectX(myParent.top2.startX,
							myParent.top2.startY, myParent.top2.endX,
							myParent.top2.endY, myParent.bot3.startX,
							myParent.bot3.startY, myParent.bot3.endX,
							myParent.bot3.endY);

					bCY2 = this.intersectY(myParent.top2.startX,
							myParent.top2.startY, myParent.top2.endX,
							myParent.top2.endY, myParent.bot3.startX,
							myParent.bot3.startY, myParent.bot3.endX,
							myParent.bot3.endY);

					bX2A = myEndingX = this.intersectX(myParent.top2.startXA,
							myParent.top2.startYA, myParent.top2.endXA,
							myParent.top2.endYA, myParent.bot3.startXA,
							myParent.bot3.startYA, myParent.bot3.endXA,
							myParent.bot3.endYA);
				}

				if (myParent.noSidesRight > 0) {

					bY2 = this.intersectY(myParent.top2.startXBA,
							myParent.top2.startYBA, myParent.top2.endXBA,
							myParent.top2.endYBA, myParent.right.startXBA,
							myParent.right.startYBA, myParent.right.endXBA,
							myParent.right.endYBA);

					bY2A = this.intersectY(myParent.top2.startXA,
							myParent.top2.startYA, myParent.top2.endXA,
							myParent.top2.endYA, myParent.right.startXA,
							myParent.right.startYA, myParent.right.endXA,
							myParent.right.endYA);

				} else if (myParent.noSidesBot == 1) {

					bY2 = this.intersectY(myParent.top2.startXBA,
							myParent.top2.startYBA, myParent.top2.endXBA,
							myParent.top2.endYBA, myParent.bot1.startXBA,
							myParent.bot1.startYBA, myParent.bot1.endYBA,
							myParent.bot1.endXBA);

					bY2A = this.intersectY(myParent.top2.startXA,
							myParent.top2.startYA, myParent.top2.endXA,
							myParent.top2.endYA, myParent.bot1.startXA,
							myParent.bot1.startYA, myParent.bot1.endYA,
							myParent.bot1.endXA);

				} else if (myParent.noSidesBot == 2) {

					bY2 = this.intersectY(myParent.top2.startXBA,
							myParent.top2.startYBA, myParent.top2.endXBA,
							myParent.top2.endYBA, myParent.bot1.startXBA,
							myParent.bot1.startYBA, myParent.bot1.endXBA,
							myParent.bot1.endYBA);

					bY2A = this.intersectY(myParent.top2.startXA,
							myParent.top2.startYA, myParent.top2.endXA,
							myParent.top2.endYA, myParent.bot1.startXA,
							myParent.bot1.startYA, myParent.bot1.endXA,
							myParent.bot1.endYA);

				} else if (myParent.noSidesBot == 3) {

					bY2 = this.intersectY(myParent.top2.startXBA,
							myParent.top2.startYBA, myParent.top2.endXBA,
							myParent.top2.endYBA, myParent.bot3.startXBA,
							myParent.bot3.startYBA, myParent.bot3.endXBA,
							myParent.bot3.endYBA);

					bY2A = this.intersectY(myParent.top2.startXA,
							myParent.top2.startYA, myParent.top2.endXA,
							myParent.top2.endYA, myParent.bot3.startXA,
							myParent.bot3.startYA, myParent.bot3.endXA,
							myParent.bot3.endYA);
				}
			}

			if (myParent.noSidesBot <= 2) {

				if (myParent.noSidesRight > 0) {

					bX3 = this.intersectX(myParent.bot1.startXBA,
							myParent.bot1.startYBA, myParent.bot1.endXBA,
							myParent.bot1.endYBA, myParent.right.startXBA,
							myParent.right.startYBA, myParent.right.endXBA,
							myParent.right.endYBA);

					bCX3 = this.intersectX(myParent.bot1.startX,
							myParent.bot1.startY, myParent.bot1.endX,
							myParent.bot1.endY, myParent.right.startX,
							myParent.right.startY, myParent.right.endX,
							myParent.right.endY);

					bCY3 = this.intersectY(myParent.bot1.startX,
							myParent.bot1.startY, myParent.bot1.endX,
							myParent.bot1.endY, myParent.right.startX,
							myParent.right.startY, myParent.right.endX,
							myParent.right.endY);

					bX3A = this.intersectX(myParent.bot1.startXA,
							myParent.bot1.startYA, myParent.bot1.endXA,
							myParent.bot1.endYA, myParent.right.startXA,
							myParent.right.startYA, myParent.right.endXA,
							myParent.right.endYA);

				} else if (myParent.noSidesRight == 0) {

					if (myParent.noSidesTop == 1) {

						bX3 = this.intersectX(myParent.top1.startXBA,
								myParent.top1.startYBA, myParent.top1.endXBA,
								myParent.top1.endYBA, myParent.bot1.startXBA,
								myParent.bot1.startYBA, myParent.bot1.endXBA,
								myParent.bot1.endYBA);

						bCX3 = this.intersectX(myParent.top1.startX,
								myParent.top1.startY, myParent.top1.endX,
								myParent.top1.endY, myParent.bot1.startX,
								myParent.bot1.startY, myParent.bot1.endX,
								myParent.bot1.endY);

						bCY3 = this.intersectY(myParent.top1.startX,
								myParent.top1.startY, myParent.top1.endX,
								myParent.top1.endY, myParent.bot1.startX,
								myParent.bot1.startY, myParent.bot1.endX,
								myParent.bot1.endY);

						bX3A = this.intersectX(myParent.top1.startXA,
								myParent.top1.startYA, myParent.top1.endXA,
								myParent.top1.endYA, myParent.bot1.startXA,
								myParent.bot1.startYA, myParent.bot1.endXA,
								myParent.bot1.endYA);

					} else if (myParent.noSidesTop > 1) {

						bX3 = this.intersectX(myParent.top2.startXBA,
								myParent.top2.startYBA, myParent.top2.endXBA,
								myParent.top2.endYBA, myParent.bot1.startXBA,
								myParent.bot1.startYBA, myParent.bot1.endXBA,
								myParent.bot1.endYBA);

						bCX3 = this.intersectX(myParent.top2.startX,
								myParent.top2.startY, myParent.top2.endX,
								myParent.top2.endY, myParent.bot1.startX,
								myParent.bot1.startY, myParent.bot1.endX,
								myParent.bot1.endY);

						bCY3 = this.intersectY(myParent.top2.startX,
								myParent.top2.startY, myParent.top2.endX,
								myParent.top2.endY, myParent.bot1.startX,
								myParent.bot1.startY, myParent.bot1.endX,
								myParent.bot1.endY);

						bX3A = this.intersectX(myParent.top2.startXA,
								myParent.top2.startYA, myParent.top2.endXA,
								myParent.top2.endYA, myParent.bot1.startXA,
								myParent.bot1.startYA, myParent.bot1.endXA,
								myParent.bot1.endYA);
					}
				}

				if (myParent.noSidesRight > 0) {
					bY3 = myEndingY = this.intersectY(myParent.bot1.startXBA,
							myParent.bot1.startYBA, myParent.bot1.endXBA,
							myParent.bot1.endYBA, myParent.right.startXBA,
							myParent.right.startYBA, myParent.right.endXBA,
							myParent.right.endYBA);

					bY3A = myEndingY = this.intersectY(myParent.bot1.startXA,
							myParent.bot1.startYA, myParent.bot1.endXA,
							myParent.bot1.endYA, myParent.right.startXA,
							myParent.right.startYA, myParent.right.endXA,
							myParent.right.endYA);

				} else if (myParent.noSidesRight == 0) {

					if (myParent.noSidesTop == 1) {

						bY3 = myEndingY = this.intersectY(
								myParent.top1.startXBA, myParent.top1.startYBA,
								myParent.top1.endXBA, myParent.top1.endYBA,
								myParent.bot1.startXBA, myParent.bot1.startYBA,
								myParent.bot1.endXBA, myParent.bot1.endYBA);

						bY3A = myEndingY = this.intersectY(
								myParent.top1.startXA, myParent.top1.startYA,
								myParent.top1.endXA, myParent.top1.endYA,
								myParent.bot1.startXA, myParent.bot1.startYA,
								myParent.bot1.endXA, myParent.bot1.endYA);

					} else if (myParent.noSidesTop > 1) {

						bY3 = myEndingY = this.intersectY(
								myParent.top2.startXBA, myParent.top2.startYBA,
								myParent.top2.endXBA, myParent.top2.endYBA,
								myParent.bot1.startXBA, myParent.bot1.startYBA,
								myParent.bot1.endXBA, myParent.bot1.endYBA);

						bY3A = myEndingY = this.intersectY(
								myParent.top2.startXA, myParent.top2.startYA,
								myParent.top2.endXA, myParent.top2.endYA,
								myParent.bot1.startXA, myParent.bot1.startYA,
								myParent.bot1.endXA, myParent.bot1.endYA);
					}

				}

			} else if (myParent.noSidesBot == 3) {

				if (myParent.noSidesRight > 0) {

					bX3 = this.intersectX(myParent.bot1.startXBA,
							myParent.bot1.startYBA, myParent.bot1.endXBA,
							myParent.bot1.endYBA, myParent.right.startXBA,
							myParent.right.startYBA, myParent.right.endXBA,
							myParent.right.endYBA);

					bCX3 = this.intersectX(myParent.bot1.startX,
							myParent.bot1.startY, myParent.bot1.endX,
							myParent.bot1.endY, myParent.right.startX,
							myParent.right.startY, myParent.right.endX,
							myParent.right.endY);

					bCY3 = this.intersectY(myParent.bot1.startX,
							myParent.bot1.startY, myParent.bot1.endX,
							myParent.bot1.endY, myParent.right.startX,
							myParent.right.startY, myParent.right.endX,
							myParent.right.endY);

					bX3A = this.intersectX(myParent.bot1.startXA,
							myParent.bot1.startYA, myParent.bot1.endXA,
							myParent.bot1.endYA, myParent.right.startXA,
							myParent.right.startYA, myParent.right.endXA,
							myParent.right.endYA);

				} else if (myParent.noSidesRight == 0) {

					if (myParent.noSidesTop == 1) {
						bX3 = this.intersectX(myParent.top1.startXBA,
								myParent.top1.startYBA, myParent.top1.endXBA,
								myParent.top1.endYBA, myParent.bot1.startXBA,
								myParent.bot1.startYBA, myParent.bot1.endXBA,
								myParent.bot1.endYBA);

						bCX3 = this.intersectX(myParent.top1.startX,
								myParent.top1.startY, myParent.top1.endX,
								myParent.top1.endY, myParent.bot1.startX,
								myParent.bot1.startY, myParent.bot1.endX,
								myParent.bot1.endY);

						bCY3 = this.intersectY(myParent.top1.startX,
								myParent.top1.startY, myParent.top1.endX,
								myParent.top1.endY, myParent.bot1.startX,
								myParent.bot1.startY, myParent.bot1.endX,
								myParent.bot1.endY);

						bX3A = this.intersectX(myParent.top1.startXA,
								myParent.top1.startYA, myParent.top1.endXA,
								myParent.top1.endYA, myParent.bot1.startXA,
								myParent.bot1.startYA, myParent.bot1.endXA,
								myParent.bot1.endYA);

					} else if (myParent.noSidesTop > 1) {

						bX3 = this.intersectX(myParent.top2.startXBA,
								myParent.top2.startYBA, myParent.top2.endXBA,
								myParent.top2.endYBA, myParent.bot1.startXBA,
								myParent.bot1.startYBA, myParent.bot1.endXBA,
								myParent.bot1.endYBA);

						bCX3 = this.intersectX(myParent.top2.startX,
								myParent.top2.startY, myParent.top2.endX,
								myParent.top2.endY, myParent.bot1.startX,
								myParent.bot1.startY, myParent.bot1.endX,
								myParent.bot1.endY);

						bCY3 = this.intersectY(myParent.top2.startX,
								myParent.top2.startY, myParent.top2.endX,
								myParent.top2.endY, myParent.bot1.startX,
								myParent.bot1.startY, myParent.bot1.endX,
								myParent.bot1.endY);

						bX3A = this.intersectX(myParent.top2.startXA,
								myParent.top2.startYA, myParent.top2.endXA,
								myParent.top2.endYA, myParent.bot1.startXA,
								myParent.bot1.startYA, myParent.bot1.endXA,
								myParent.bot1.endYA);
					}

				}
				if (myParent.noSidesRight > 0) {

					bY3 = myEndingY = this.intersectY(myParent.bot1.startXBA,
							myParent.bot1.startYBA, myParent.bot1.endXBA,
							myParent.bot1.endYBA, myParent.right.startXBA,
							myParent.right.startYBA, myParent.right.endXBA,
							myParent.right.endYBA);
					bY3A = myEndingY = this.intersectY(myParent.bot1.startXA,
							myParent.bot1.startYA, myParent.bot1.endXA,
							myParent.bot1.endYA, myParent.right.startXA,
							myParent.right.startYA, myParent.right.endXA,
							myParent.right.endYA);

				} else if (myParent.noSidesRight == 0) {

					if (myParent.noSidesTop == 1) {

						bY3 = myEndingY = this.intersectY(
								myParent.top1.startXBA, myParent.top1.startYBA,
								myParent.top1.endXBA, myParent.top1.endYBA,
								myParent.bot1.startXBA, myParent.bot1.startYBA,
								myParent.bot1.endXBA, myParent.bot1.endYBA);

						bY3A = myEndingY = this.intersectY(
								myParent.top1.startXA, myParent.top1.startYA,
								myParent.top1.endXA, myParent.top1.endYA,
								myParent.bot1.startXA, myParent.bot1.startYA,
								myParent.bot1.endXA, myParent.bot1.endYA);

					} else if (myParent.noSidesTop > 1) {

						bY3 = myEndingY = this.intersectY(
								myParent.top2.startXBA, myParent.top2.startYBA,
								myParent.top2.endXBA, myParent.top2.endYBA,
								myParent.bot1.startXBA, myParent.bot1.startYBA,
								myParent.bot1.endXBA, myParent.bot1.endYBA);

						bY3A = myEndingY = this.intersectY(
								myParent.top2.startXA, myParent.top2.startYA,
								myParent.top2.endXA, myParent.top2.endYA,
								myParent.bot1.startXA, myParent.bot1.startYA,
								myParent.bot1.endXA, myParent.bot1.endYA);
					}

				}

			}
			// /////// X4,Y4
			if (myParent.noSidesBot == 1) {

				if (myParent.noSidesLeft > 0) {

					bX4 = this.intersectX(myParent.bot1.startXBA,
							myParent.bot1.startYBA, myParent.bot1.endXBA,
							myParent.bot1.endYBA, myParent.left.startXBA,
							myParent.left.startYBA, myParent.left.endXBA,
							myParent.left.endYBA);

					bCX4 = this.intersectX(myParent.bot1.startX,
							myParent.bot1.startY, myParent.bot1.endX,
							myParent.bot1.endY, myParent.left.startX,
							myParent.left.startY, myParent.left.endX,
							myParent.left.endY);

					bCY4 = this.intersectY(myParent.bot1.startX,
							myParent.bot1.startY, myParent.bot1.endX,
							myParent.bot1.endY, myParent.left.startX,
							myParent.left.startY, myParent.left.endX,
							myParent.left.endY);

					bX4A = this.intersectX(myParent.bot1.startXA,
							myParent.bot1.startYA, myParent.bot1.endXA,
							myParent.bot1.endYA, myParent.left.startXA,
							myParent.left.startYA, myParent.left.endXBA,
							myParent.left.endYBA);

					bY4 = this.intersectY(myParent.bot1.startXBA,
							myParent.bot1.startYBA, myParent.bot1.endXBA,
							myParent.bot1.endYBA, myParent.left.startXBA,
							myParent.left.startYBA, myParent.left.endXBA,
							myParent.left.endYBA);

					bY4A = this.intersectY(myParent.bot1.startXA,
							myParent.bot1.startYA, myParent.bot1.endXA,
							myParent.bot1.endYA, myParent.left.startXA,
							myParent.left.startYA, myParent.left.endXA,
							myParent.left.endYA);

				} else if (myParent.noSidesLeft == 0) {

					bX4 = this.intersectX(myParent.top1.startXBA,
							myParent.top1.startYBA, myParent.top1.endXBA,
							myParent.top1.endYBA, myParent.bot1.startXBA,
							myParent.bot1.startYBA, myParent.bot1.endXBA,
							myParent.bot1.endYBA);

					bY4 = this.intersectY(myParent.top1.startXBA,
							myParent.top1.startYBA, myParent.top1.endXBA,
							myParent.top1.endYBA, myParent.bot1.startXBA,
							myParent.bot1.startYBA, myParent.bot1.endXBA,
							myParent.bot1.endYBA);

					bCX4 = this.intersectX(myParent.top1.startX,
							myParent.top1.startY, myParent.top1.endX,
							myParent.top1.endY, myParent.bot1.startX,
							myParent.bot1.startY, myParent.bot1.endX,
							myParent.bot1.endY);

					bCY4 = this.intersectY(myParent.top1.startX,
							myParent.top1.startY, myParent.top1.endX,
							myParent.top1.endY, myParent.bot1.startX,
							myParent.bot1.startY, myParent.bot1.endX,
							myParent.bot1.endY);

					bX4A = this.intersectX(myParent.top1.startXA,
							myParent.top1.startYA, myParent.top1.endXA,
							myParent.top1.endYA, myParent.bot1.startXA,
							myParent.bot1.startYA, myParent.bot1.endXA,
							myParent.bot1.endYA);

					bY4A = this.intersectY(myParent.top1.startXA,
							myParent.top1.startYA, myParent.top1.endXA,
							myParent.top1.endYA, myParent.bot1.startXA,
							myParent.bot1.startYA, myParent.bot1.endXA,
							myParent.bot1.endYA);
				}

			} else if (myParent.noSidesBot > 1) {

				if (myParent.noSidesLeft > 0) {

					bX4 = this.intersectX(myParent.bot2.startXBA,
							myParent.bot2.startYBA, myParent.bot2.endXBA,
							myParent.bot2.endYBA, myParent.left.startXBA,
							myParent.left.startYBA, myParent.left.endXBA,
							myParent.left.endYBA);

					bY4 = this.intersectY(myParent.bot2.startXBA,
							myParent.bot2.startYBA, myParent.bot2.endXBA,
							myParent.bot2.endYBA, myParent.left.startXBA,
							myParent.left.startYBA, myParent.left.endXBA,
							myParent.left.endYBA);

					bCX4 = this.intersectX(myParent.bot2.startX,
							myParent.bot2.startY, myParent.bot2.endX,
							myParent.bot2.endY, myParent.left.startX,
							myParent.left.startY, myParent.left.endX,
							myParent.left.endY);

					bCY4 = this.intersectY(myParent.bot2.startX,
							myParent.bot2.startY, myParent.bot2.endX,
							myParent.bot2.endY, myParent.left.startX,
							myParent.left.startY, myParent.left.endX,
							myParent.left.endY);

					bX4A = this.intersectX(myParent.bot2.startXA,
							myParent.bot2.startYA, myParent.bot2.endXA,
							myParent.bot2.endYA, myParent.left.startXA,
							myParent.left.startYA, myParent.left.endXA,
							myParent.left.endYA);

					bY4A = this.intersectY(myParent.bot2.startXA,
							myParent.bot2.startYA, myParent.bot2.endXA,
							myParent.bot2.endYA, myParent.left.startXA,
							myParent.left.startYA, myParent.left.endXA,
							myParent.left.endYA);

				} else if (myParent.noSidesLeft == 0) {

					bX4 = this.intersectX(myParent.top1.startXBA,
							myParent.top1.startYBA, myParent.top1.endXBA,
							myParent.top1.endYBA, myParent.bot2.startXBA,
							myParent.bot2.startYBA, myParent.bot2.endXBA,
							myParent.bot2.endYBA);

					bY4 = this.intersectY(myParent.top1.startXBA,
							myParent.top1.startYBA, myParent.top1.endXBA,
							myParent.top1.endYBA, myParent.bot2.startXBA,
							myParent.bot2.startYBA, myParent.bot2.endXBA,
							myParent.bot2.endYBA);

					bCX4 = this.intersectX(myParent.top1.startX,
							myParent.top1.startY, myParent.top1.endX,
							myParent.top1.endY, myParent.bot2.startX,
							myParent.bot2.startY, myParent.bot2.endX,
							myParent.bot2.endY);

					bCY4 = this.intersectY(myParent.top1.startX,
							myParent.top1.startY, myParent.top1.endX,
							myParent.top1.endY, myParent.bot2.startX,
							myParent.bot2.startY, myParent.bot2.endX,
							myParent.bot2.endY);

					bX4A = this.intersectX(myParent.top1.startXA,
							myParent.top1.startYBA, myParent.top1.endXA,
							myParent.top1.endYA, myParent.bot2.startXA,
							myParent.bot2.startYA, myParent.bot2.endXA,
							myParent.bot2.endYA);

					bY4A = this.intersectY(myParent.top1.startXA,
							myParent.top1.startYA, myParent.top1.endXA,
							myParent.top1.endYA, myParent.bot2.startXA,
							myParent.bot2.startYA, myParent.bot2.endXA,
							myParent.bot2.endYA);
				}

			}
			// ////////////////////////
			if (myParent.noSidesTop == 2) {

				t1t2X = this.intersectX(myParent.top1.startXBA,
						myParent.top1.startYBA, myParent.top1.endXBA,
						myParent.top1.endYBA, myParent.top2.startXBA,
						myParent.top2.startYBA, myParent.top2.endXBA,
						myParent.top2.endYBA);

				t1t2Y = this.intersectY(myParent.top1.startXBA,
						myParent.top1.startYBA, myParent.top1.endXBA,
						myParent.top1.endYBA, myParent.top2.startXBA,
						myParent.top2.startYBA, myParent.top2.endXBA,
						myParent.top2.endYBA);

				t1t2XA = this.intersectX(myParent.top1.startXA,
						myParent.top1.startYA, myParent.top1.endXA,
						myParent.top1.endYA, myParent.top2.startXA,
						myParent.top2.startYA, myParent.top2.endXA,
						myParent.top2.endYA);

				t1t2YA = this.intersectY(myParent.top1.startXA,
						myParent.top1.startYA, myParent.top1.endXA,
						myParent.top1.endYA, myParent.top2.startXA,
						myParent.top2.startYA, myParent.top2.endXA,
						myParent.top2.endYA);

			} else if (myParent.noSidesTop == 3) {

				t1t3X = this.intersectX(myParent.top1.startXBA,
						myParent.top1.startYBA, myParent.top1.endXBA,
						myParent.top1.endYBA, myParent.top3.startXBA,
						myParent.top3.startYBA, myParent.top3.endXBA,
						myParent.top3.endYBA);

				t1t3Y = this.intersectY(myParent.top1.startXBA,
						myParent.top1.startYBA, myParent.top1.endXBA,
						myParent.top1.endYBA, myParent.top3.startXBA,
						myParent.top3.startYBA, myParent.top3.endXBA,
						myParent.top3.endYBA);

				t3t2X = this.intersectX(myParent.top2.startXBA,
						myParent.top2.startYBA, myParent.top2.endXBA,
						myParent.top2.endYBA, myParent.top3.startXBA,
						myParent.top3.startYBA, myParent.top3.endXBA,
						myParent.top3.endYBA);

				t3t2Y = this.intersectY(myParent.top2.startXBA,
						myParent.top2.startYBA, myParent.top2.endXBA,
						myParent.top2.endYBA, myParent.top3.startXBA,
						myParent.top3.startYBA, myParent.top3.endXBA,
						myParent.top3.endYBA);

				t1t3XA = this.intersectX(myParent.top1.startXA,
						myParent.top1.startYA, myParent.top1.endXA,
						myParent.top1.endYA, myParent.top3.startXA,
						myParent.top3.startYA, myParent.top3.endXA,
						myParent.top3.endYA);

				t1t3YA = this.intersectY(myParent.top1.startXA,
						myParent.top1.startYA, myParent.top1.endXA,
						myParent.top1.endYA, myParent.top3.startXA,
						myParent.top3.startYA, myParent.top3.endXA,
						myParent.top3.endYA);

				t3t2XA = this.intersectX(myParent.top2.startXA,
						myParent.top2.startYA, myParent.top2.endXA,
						myParent.top2.endYA, myParent.top3.startXA,
						myParent.top3.startYA, myParent.top3.endXA,
						myParent.top3.endYA);

				t3t2YA = this.intersectY(myParent.top2.startXA,
						myParent.top2.startYA, myParent.top2.endXA,
						myParent.top2.endYA, myParent.top3.startXA,
						myParent.top3.startYA, myParent.top3.endXA,
						myParent.top3.endYA);
			}

			if (myParent.noSidesBot == 2) {

				b1b2X = this.intersectX(myParent.bot1.startXBA,
						myParent.bot1.startYBA, myParent.bot1.endXBA,
						myParent.bot1.endYBA, myParent.bot2.startXBA,
						myParent.bot2.startYBA, myParent.bot2.endXBA,
						myParent.bot2.endYBA);

				b1b2Y = this.intersectY(myParent.bot1.startXBA,
						myParent.bot1.startYBA, myParent.bot1.endXBA,
						myParent.bot1.endYBA, myParent.bot2.startXBA,
						myParent.bot2.startYBA, myParent.bot2.endXBA,
						myParent.bot2.endYBA);

				b1b2XA = this.intersectX(myParent.bot1.startXA,
						myParent.bot1.startYA, myParent.bot1.endXA,
						myParent.bot1.endYA, myParent.bot2.startXA,
						myParent.bot2.startYA, myParent.bot2.endXA,
						myParent.bot2.endYA);

				b1b2YA = this.intersectY(myParent.bot1.startXA,
						myParent.bot1.startYA, myParent.bot1.endXA,
						myParent.bot1.endYA, myParent.bot2.startXA,
						myParent.bot2.startYA, myParent.bot2.endXA,
						myParent.bot2.endYA);
			}

			if (myParent.noSidesBot == 3) {

				b1b3X = this.intersectX(myParent.bot1.startXBA,
						myParent.bot1.startYBA, myParent.bot1.endXBA,
						myParent.bot1.endYBA, myParent.bot3.startXBA,
						myParent.bot3.startYBA, myParent.bot3.endXBA,
						myParent.bot3.endYBA);

				b1b3Y = this.intersectY(myParent.bot1.startXBA,
						myParent.bot1.startYBA, myParent.bot1.endXBA,
						myParent.bot1.endYBA, myParent.bot3.startXBA,
						myParent.bot3.startYBA, myParent.bot3.endXBA,
						myParent.bot3.endYBA);

				b1b3XA = this.intersectX(myParent.bot1.startXA,
						myParent.bot1.startYA, myParent.bot1.endXA,
						myParent.bot1.endYA, myParent.bot3.startXA,
						myParent.bot3.startYA, myParent.bot3.endXA,
						myParent.bot3.endYA);

				b1b3YA = this.intersectY(myParent.bot1.startXA,
						myParent.bot1.startYA, myParent.bot1.endXA,
						myParent.bot1.endYA, myParent.bot3.startXA,
						myParent.bot3.startYA, myParent.bot3.endXA,
						myParent.bot3.endYA);

				b1b2X = this.intersectX(myParent.bot3.startXBA,
						myParent.bot3.startYBA, myParent.bot3.endXBA,
						myParent.bot3.endYBA, myParent.bot2.startXBA,
						myParent.bot2.startYBA, myParent.bot2.endXBA,
						myParent.bot2.endYBA);

				b1b2Y = this.intersectY(myParent.bot3.startXBA,
						myParent.bot3.startYBA, myParent.bot3.endXBA,
						myParent.bot3.endYBA, myParent.bot2.startXBA,
						myParent.bot2.startYBA, myParent.bot2.endXBA,
						myParent.bot2.endYBA);

				b1b2XA = this.intersectX(myParent.bot3.startXA,
						myParent.bot3.startYA, myParent.bot3.endXA,
						myParent.bot3.endYA, myParent.bot2.startXA,
						myParent.bot2.startYA, myParent.bot2.endXA,
						myParent.bot2.endYA);

				b1b2YA = this.intersectY(myParent.bot3.startXA,
						myParent.bot3.startYA, myParent.bot3.endXA,
						myParent.bot3.endYA, myParent.bot2.startXA,
						myParent.bot2.startYA, myParent.bot2.endXA,
						myParent.bot2.endYA);

			}
		}

		// *********************************************************************************
		// ShapeID equals 800 || 801 || 802 modify myStartingY and myStartingYA
		// *********************************************************************************
		if (myParent.shapeID == 800 || myParent.shapeID == 801
				|| myParent.shapeID == 802) {
			myStartingY = myParent.bY4 - myParent.bot1.partDimB;
			myStartingYA = myParent.bY4 - myParent.bot1.partDimB
					- myParent.bot1.partDimA;
		}

		wt = bX2 - bX1;
		wb = bX3 - bX4;
		wt = Math.max(wt, wb);

		hl = myParent.heightPix;
		hr = myParent.heightPix;

		if (hl == 0 || hr == 0) {
			wtc = myParent.widthPix;
		}

		wtc = myParent.widthPix;
		wbc = myParent.widthPix;

		this.checkAutoPolygons();

		lowestY = lowestYC = Math.max(myParent.bot1Part.endYC,
				myParent.bot1Part.startYC);

		if (lowestY == 0) {
			lowestY = Math.max(myParent.bY3, myParent.bY4);
		}

		if (myParent.a_levelID > 3) {

			lowestY = myParent.lowestY - myParent.bot1Part.partDimC
					- myParent.bot1Part.partDimB;
			lowestYC = myParent.lowestY;

			if (lowestY <= 0) {
				lowestY = Math.max(myParent.bY3B, myParent.bY4B);
				lowestYC = Math.max(myParent.bY3, myParent.bY4);
			}

			highestY = myParent.highestY + myParent.top1Part.partDimC
					+ myParent.top1Part.partDimB;
			highestYC = myParent.highestY;

			if (highestY == 0) {
				highestY = myParent.top1Part.startingY;
			}

			hl = lowestY - highestY;
			hr = lowestY - highestY;

		} else if (myParent.a_levelID == 3) {

			lowestY = myParent.lowestY - myParent.bot1Part.partDimB;
			lowestYC = myParent.lowestY;

			if (lowestY == 0) {
				lowestY = Math.max(myParent.bY3, myParent.bY4)
						- myParent.bot1Part.partDimB;
				lowestYC = lowestY = Math.max(myParent.bY3, myParent.bY4);
			}

			highestY = myParent.highestY + myParent.top1Part.partDimB;
			highestYC = myParent.highestY;

			if (highestY == 0) {
				highestY = myParent.top1Part.startingYBA;
				highestYC = myParent.top1Part.startingY;
			}

			hl = lowestY - highestY;
			hr = lowestY - highestY;

			this.checkAutoPolygons();

		} else {

			if (myParent.lowestY > 0 && myParent.highestY > 0) {
				lowestY = myParent.lowestY - myParent.bot1Part.partDimB;
				lowestYC = myParent.lowestY;

				if (lowestY == 0) {
					lowestY = Math.max(myParent.bY3, myParent.bY4)
							- myParent.bot1Part.partDimB;
				}

				highestY = myParent.highestY + myParent.top1Part.partDimB;
				highestYC = myParent.highestY;

			} else {

				lowestY = Math.max(myParent.bY4, myParent.bY3)
						- myParent.bot1Part.partDimB;
				lowestYC = myParent.lowestY;
				highestY = myParent.highestY + myParent.top1Part.partDimB;
				highestYC = myParent.highestY;

				if (highestYC == 0) {
					highestYC = highestY;
				}
			}

			hl = lowestY - highestY;
			hr = lowestY - highestY;
		}

		// if((myParent.noSides==2 || myParent.noSides==3) &&
		// myParent.top1Part.partForm>1){
		// this.highestY = myParent.top1Part.bkgrdStartYBA;
		// }

		bkgrdStartY = highestY;
		bkgrdStartX = myStartingX;
		hlc = myParent.heightPix;
		hrc = myParent.heightPix;

		wtA = bX2A - myStartingXA;
		wbA = bX3A - bX4A;
		hlA = bY4A
				- (myParent.highestY + myParent.top1.partDimB + myParent.top1.partDimA);
		hrA = bY3A
				- (myParent.highestY + myParent.top1.partDimB + myParent.top1.partDimA);

		this.checkAutoPolygons();

		dimTM = myParent.top1.partDimB - myParent.top1.partDimM;
		dimBM = myParent.bot1.partDimB - myParent.bot1.partDimM;
		dimLM = myParent.left.partDimB - myParent.left.partDimM;
		dimRM = myParent.right.partDimB - myParent.right.partDimM;

		dimTA = myParent.top1.partDimA;
		dimBA = myParent.bot1.partDimA;
		dimLA = myParent.left.partDimA;
		dimRA = myParent.right.partDimA;

		if (myParent.noSidesTop > 1) {

			if (myParent.noSidesTop >= 2) {
				a1 = t1t2X - myStartingX;
				a2 = myEndingX - t1t2X;
			}

			if (myParent.noSidesTop == 3) {
				a1 = t1t3X - myStartingX;
				a2 = myEndingX - t3t2X;
				a3 = t3t2X - t1t3X;
			}

		} else {

			if (lean == 0) {
				a1 = 0;
				a2 = 0;
				a3 = 0;
				a0 = 0;
			} else if (lean == 2) {
				a2 = myEndingX - myStartingX;
				a1 = Math.max(wt, wb) - a2;
			} else if (lean == 1) {
				a1 = myEndingX - myStartingX;
				a2 = Math.max(wt, wb) - a1;
			} else if (lean == 3) {
				a0 = myStartingX - bX4;
				a2 = bX3 - myEndingX;
				a1 = Math.max(wt, wb) - (a2 + a0);
			}
		}

		if (lean2 == 0) {
			b2 = 0;
			b1 = 0;
			b0 = 0;
		} else if (lean2 == 2) {
			b2 = bY3 - bY2;
			b1 = Math.max(hl, hr) - b2;
		} else if (lean2 == 1) {
			b1 = bY3 - bY2;
			b2 = Math.max(hl, hr) - b1;
		} else if (lean2 == 3) {
			b0 = bY2 - bY1;
			b1 = bY3 - bY2;
			b2 = Math.max(hl, hr) - (b1 + b0);
		}

		if (myParent.noSidesBot > 1) {

			if (myParent.noSidesBot == 2) {
				c1 = bX3 - b1b2X;
				c2 = b1b2X - bX4;
			} else if (myParent.noSidesBot == 3) {
				c3 = bX3 - b1b3X;
				c1 = b1b3X - b1b2X;
				c2 = b1b2X - bX4;
			}

		} else {

			if (lean3 == 0) {
				c1 = 0;
				c2 = 0;
				c3 = 0;
				c0 = 0;
			} else if (lean3 == 2) {
				c2 = bX3 - bX4;
				c1 = Math.max(wt, wb) - c2;
			} else if (lean3 == 1) {
				c1 = bX3 - bX4;
				c2 = Math.max(wt, wb) - c1;
			} else if (lean3 == 3) {
				c0 = bX2 - bX3;
				c2 = bX4 - bX1;
				c1 = Math.max(wt, wb) - (c2 + c0);
			}
		}

		d1 = bY4 - bY1;

		if (lean4 == 0) {
			d1 = 0;
			d2 = 0;
			d0 = 0;
		} else if (lean4 == 1) {
			d1 = bY4 - bY1;
			d2 = Math.max(hl, hr) - d1;
		} else if (lean4 == 2) {
			d2 = bY4 - bY1;
			d1 = Math.max(hl, hr) - d2;
		} else if (lean4 == 3) {
			d0 = bY3 - bY4;
			d2 = bY2 - bY1;
			d1 = Math.max(hl, hr) - (d2 + d0);
		}

		if (shape == 10) {

		}

		// ***********************************************************
		// Creating XY Points
		// ***********************************************************
		this.getXYpointsMain();

		// ***********************************************************
		// Creating BkgrdOpeningObject
		// ***********************************************************
		BkgrdOpeningObject myNewOpening = new BkgrdOpeningObject(myParent, wt,
				hl, wtc, hlc, myParent.shapeID, myParent.a_sequenceID,
				myStartingX, myStartingY, 1, myParent.xCols, 1, myParent.yRows,
				bX2, bY2, bX3, bY3, bX4, bY4, a1, a2, a3, a4, a5, a0, b1, b2,
				b3, b4, b5, b0, c1, c2, c3, c4, c5, c0, d1, d2, d3, d4, d5, d0,
				false, myParent.top1.x1, myParent.top1.y1, myParent.top1.x2,
				myParent.top1.y2, myParent.top1.radius1BA,
				myParent.top1.radius2BA, myParent.top1.startAngleBA,
				myParent.top1.endAngleBA, bkgrdStartX, bkgrdStartY,
				myParent.top1.centralAngleBA, startingCX, startingCY, bCX2,
				bCY2, bCX3, bCY3, bCX4, bCY4, myParent.topIn, myParent.botIn,
				myParent.rightIn, myParent.leftIn, myParent.lean,
				myParent.lean2, myParent.lean3, myParent.lean4,
				myParent.noSides, myParent.noSidesTop, myParent.noSidesBot,
				myParent.noSidesLeft, myParent.noSidesRight,
				myParent.startingX, myParent.startingY, dimTM, dimBM, dimLM,
				dimRM, dimTA, dimBA, dimLA, dimRA, myFrame2);

		myNewOpening.myFrame2 = myFrame2;

		myNewOpening.noSides = myParent.noSides;
		myNewOpening.noSidesTop = myParent.noSidesTop;
		myNewOpening.noSidesBot = myParent.noSidesBot;
		myNewOpening.noSidesLeft = myParent.noSidesLeft;
		myNewOpening.noSidesRight = myParent.noSidesRight;

		myNewOpening.openingClass = myParent.openingClass;
		myNewOpening.userDefinedOpeningID = myParent.userDefinedOpeningID;

		myNewOpening.parentStartX = myParent.startingX;
		myNewOpening.parentStartY = myParent.startingY;
		myNewOpening.shapeID = myParent.shapeID;
		myNewOpening.bkgrdStartX = bkgrdStartX;
		myNewOpening.bkgrdStartY = bkgrdStartY;
		myNewOpening.xCols = myParent.xCols;
		myNewOpening.yRows = myParent.yRows;
		myNewOpening.px1 = px1;
		myNewOpening.py1 = py1;
		myNewOpening.px2 = px2;
		myNewOpening.py2 = py2;
		myNewOpening.px3 = px3;
		myNewOpening.py3 = py3;
		myNewOpening.px4 = px4;
		myNewOpening.py4 = py4;
		myNewOpening.px5 = px5;
		myNewOpening.py5 = py5;
		myNewOpening.px6 = px6;
		myNewOpening.py6 = py6;
		myNewOpening.px7 = px7;
		myNewOpening.py7 = py7;
		myNewOpening.px8 = px8;
		myNewOpening.py8 = py8;

		myNewOpening.px1A = px1A;
		myNewOpening.py1A = py1A;
		myNewOpening.px2A = px2A;
		myNewOpening.py2A = py2A;
		myNewOpening.px3A = px3A;
		myNewOpening.py3A = py3A;
		myNewOpening.px4A = px4A;
		myNewOpening.py4A = py4A;
		myNewOpening.px5A = px5A;
		myNewOpening.py5A = py5A;
		myNewOpening.px6A = px6A;
		myNewOpening.py6A = py6A;
		myNewOpening.px7A = px7A;
		myNewOpening.py7A = py7A;
		myNewOpening.px8A = px8A;
		myNewOpening.py8A = py8A;

		myNewOpening.px1c = px1c;
		myNewOpening.py1c = py1c;
		myNewOpening.px2c = px2c;
		myNewOpening.py2c = py2c;
		myNewOpening.px3c = px3c;
		myNewOpening.py3c = py3c;
		myNewOpening.px4c = px4c;
		myNewOpening.py4c = py4c;
		myNewOpening.px5c = px5c;
		myNewOpening.py5c = py5c;
		myNewOpening.px6c = px6c;
		myNewOpening.py6c = py6c;
		myNewOpening.px7c = px7c;
		myNewOpening.py7c = py7c;
		myNewOpening.px8c = px8c;
		myNewOpening.py8c = py8c;

		// Creating parts objects
		myNewOpening.top1 = new Top1Object();
		myNewOpening.top2 = new Top2Object();
		myNewOpening.top3 = new Top3Object();
		myNewOpening.right = new RightObject();
		myNewOpening.bot1 = new Bot1Object();
		myNewOpening.bot2 = new Bot2Object();
		myNewOpening.bot3 = new Bot3Object();
		myNewOpening.left = new LeftObject();

		myNewOpening.top1Part = new Profiles();
		myNewOpening.top2Part = new Profiles();
		myNewOpening.top3Part = new Profiles();
		myNewOpening.rightPart = new Profiles();
		myNewOpening.bot1Part = new Profiles();
		myNewOpening.bot2Part = new Profiles();
		myNewOpening.bot3Part = new Profiles();
		myNewOpening.leftPart = new Profiles();

		if (myParent.a_levelID == 1) {
			myNewOpening.myFacet = myParent;
		} else {
			myNewOpening.myFacet = myParent.myFacet;
		}

		myNewOpening.top1 = (Top1Object) myNewOpening.top1
				.cloneProfile(myParent.top1Part);

		// Cloning top2Part to top2
		if (myParent.top2Part.posInUse) {
			myNewOpening.top2 = (Top2Object) myNewOpening.top2
					.cloneProfile(myParent.top2Part);

		} else if (!myParent.top2Part.posInUse) {
			myNewOpening.top2 = (Top2Object) myNewOpening.top2
					.cloneProfile(myParent.top1Part);
		}

		// Cloning top3Parto to top3
		myNewOpening.top3 = (Top3Object) myNewOpening.top3
				.cloneProfile(myParent.top3Part);

		// Cloning Bot1Part to bot1
		myNewOpening.bot1 = (Bot1Object) myNewOpening.bot1
				.cloneProfile(myParent.bot1Part);
		// Cloning Bot2Part to bot2
		myNewOpening.bot2 = (Bot2Object) myNewOpening.bot2
				.cloneProfile(myParent.bot2Part);
		// Cloning Bot3Part to bot3
		myNewOpening.bot3 = (Bot3Object) myNewOpening.bot3
				.cloneProfile(myParent.bot3Part);
		// Cloning LeftPart to left
		myNewOpening.left = (LeftObject) myNewOpening.left
				.cloneProfile(myParent.leftPart);
		// Cloning RightPart to right
		myNewOpening.right = (RightObject) myNewOpening.right
				.cloneProfile(myParent.rightPart);

		myNewOpening.top1 = (Top1Object) myNewOpening.top1
				.resetPartDims(myNewOpening.top1);

		myNewOpening.top2 = (Top2Object) myNewOpening.top2
				.resetPartDims(myNewOpening.top2);

		myNewOpening.top3 = (Top3Object) myNewOpening.top3
				.resetPartDims(myNewOpening.top3);

		myNewOpening.bot1 = (Bot1Object) myNewOpening.bot1
				.resetPartDims(myNewOpening.bot1);

		myNewOpening.bot2 = (Bot2Object) myNewOpening.bot2
				.resetPartDims(myNewOpening.bot2);

		myNewOpening.bot3 = (Bot3Object) myNewOpening.bot3
				.resetPartDims(myNewOpening.bot3);

		myNewOpening.left = (LeftObject) myNewOpening.left
				.resetPartDims(myNewOpening.left);

		myNewOpening.right = (RightObject) myNewOpening.right
				.resetPartDims(myNewOpening.right);

		// myNewOpening.setOriginalDimsInit(myNewOpening.widthPix,
		// myNewOpening.heightPix);

		myNewOpening.centerPointX = myParent.top1.x1;// centerPointX;
		myNewOpening.centerPointX2 = myParent.top1.x2;
		myNewOpening.centerPointY = myParent.top1.y1;
		myNewOpening.centerPointY2 = myParent.top1.y2;

		myNewOpening.bX2 = myNewOpening.bX2B = bX2;
		myNewOpening.bY2 = myNewOpening.bY2B = bY2;
		myNewOpening.bX3 = myNewOpening.bX3B = bX3;
		myNewOpening.bY3 = myNewOpening.bY3B = bY3;
		myNewOpening.bX4 = myNewOpening.bX4B = bX4;
		myNewOpening.bY4 = myNewOpening.bX4B = bY4;

		myNewOpening.bX2A = bX2A;
		myNewOpening.bY2A = bY2A;
		myNewOpening.bX3A = bX3A;
		myNewOpening.bY3A = bY3A;
		myNewOpening.bX4A = bX4A;
		myNewOpening.bY4A = bY4A;

		myNewOpening.startingCX = startingCX;
		myNewOpening.startingCY = startingCY;

		myNewOpening.dimTM = dimTM;
		myNewOpening.dimBM = dimBM;
		myNewOpening.dimLM = dimLM;
		myNewOpening.dimRM = dimRM;
		myNewOpening.dimTA = dimTA;
		myNewOpening.dimBA = dimBA;
		myNewOpening.dimLA = dimLA;
		myNewOpening.dimRA = dimRA;

		myNewOpening.bCX2 = bCX2;
		myNewOpening.bCY2 = bCY2;
		myNewOpening.bCX3 = bCX3;
		myNewOpening.bCY3 = bCY3;
		myNewOpening.bCX4 = bCX4;
		myNewOpening.bCY4 = bCY4;

		if (startingCX == 0) {

			myNewOpening.startingCX = startingCX = px1c;
			myNewOpening.startingCY = startingCY = py1c;
			myNewOpening.bCX2 = myParent.bCX2 = px2c;
			myNewOpening.bCY2 = myParent.bCY2 = py2c;
			myNewOpening.bCX3 = myParent.bCX3 = px3c;
			myNewOpening.bCY3 = myParent.bCY3 = py3c;
			myNewOpening.bCX4 = myParent.bCX4 = px4c;
			myNewOpening.bCY4 = myParent.bCY4 = py4c;
		}

		myNewOpening.dimA1 = a1;
		myNewOpening.dimA2 = a2;
		myNewOpening.dimA3 = a3;
		myNewOpening.dimA4 = a4;
		myNewOpening.dimA5 = a5;
		myNewOpening.dimA0 = a0;
		myNewOpening.dimB1 = b1;
		myNewOpening.dimB2 = b2;
		myNewOpening.dimB3 = b3;
		myNewOpening.dimB4 = b4;
		myNewOpening.dimB5 = b5;
		myNewOpening.dimB0 = b0;
		myNewOpening.dimC1 = c1;
		myNewOpening.dimC2 = c2;
		myNewOpening.dimC3 = c3;
		myNewOpening.dimC4 = c4;
		myNewOpening.dimC5 = c5;
		myNewOpening.dimC0 = c0;
		myNewOpening.dimD1 = d1;
		myNewOpening.dimD2 = d2;
		myNewOpening.dimD3 = d3;
		myNewOpening.dimD4 = d4;
		myNewOpening.dimD5 = d5;
		myNewOpening.dimD0 = d0;

		myNewOpening.lean = lean;
		myNewOpening.lean2 = lean2;
		myNewOpening.lean3 = lean3;
		myNewOpening.lean4 = lean4;

		myNewOpening.parentH = myParent.heightPix;
		myNewOpening.parentW = myParent.widthPix;

		myNewOpening.parentStartY = myParent.startingY;
		myNewOpening.parentStartX = myParent.startingX;
		myNewOpening.parentRadius1 = myParent.dimD2;// * 2;

		myNewOpening.parentCX = myParent.top1.x1;
		myNewOpening.parentCY = myParent.top1.y1;
		myNewOpening.parentCX2 = myParent.top1.x2;
		myNewOpening.parentCY2 = myParent.top1.y2;
		myNewOpening.parentShape = myParent.shapeID;

		myNewOpening.startingX = myStartingX;
		myNewOpening.startingY = myStartingY;

		myNewOpening.startingXA = myStartingXA;
		myNewOpening.startingYA = myStartingYA;

		myNewOpening.highestY = highestY;
		myNewOpening.lowestY = lowestY;
		myNewOpening.highestYC = highestYC;
		myNewOpening.lowestYC = lowestYC;

		myNewOpening.setBAandA(); // to set BkgrdH

		myNewOpening.widthPix = Math.abs(Math.min(myNewOpening.startingX,
				myNewOpening.bX4)
				- Math.max(myNewOpening.bX3, myNewOpening.bX2));

		myNewOpening.heightPix = Math.abs(myNewOpening.lowestY
				- myNewOpening.highestY);

		myNewOpening.widthMN = myParent.widthMN;
		myNewOpening.heightMN = myParent.heightMN;
		myNewOpening.widthIN = myParent.widthIN;
		myNewOpening.heightIN = myParent.heightIN;

		myNewOpening.widthM = myNewOpening.widthMO = (int) (new BigDecimal(
				myNewOpening.widthPix).divide(myFrame2.metricscale, 20,
				BigDecimal.ROUND_HALF_UP)).doubleValue();

		myNewOpening.heightM = myNewOpening.heightMO = (int) (new BigDecimal(
				myNewOpening.heightPix).divide(myFrame2.metricscale, 20,
				BigDecimal.ROUND_HALF_UP)).doubleValue();

		myNewOpening.widthI = myNewOpening.widthIO = (int) (new BigDecimal(
				myNewOpening.widthPix).divide(myFrame2.imperialscale, 20,
				BigDecimal.ROUND_HALF_UP)).doubleValue();

		myNewOpening.heightI = myNewOpening.heightIO = (int) (new BigDecimal(
				myNewOpening.heightPix).divide(myFrame2.imperialscale, 20,
				BigDecimal.ROUND_HALF_UP)).doubleValue();

		if (this.myParent.a_levelID <= 1) {
			myNewOpening.widthM = (int) (((int) (myNewOpening.widthM / myFrame2.metricRound)) * myFrame2.metricRound);
			myNewOpening.widthI = (int) ((int) (myNewOpening.widthI / myFrame2.impRound) * myFrame2.impRound);

			myNewOpening.heightM = (int) (((int) (myNewOpening.heightM / myFrame2.metricRound)) * myFrame2.metricRound);
			myNewOpening.heightI = (int) (((int) (myNewOpening.heightI / myFrame2.impRound)) * myFrame2.impRound);
		}

		boolean doOpening = true;
		boolean found = false;

		if (myBOpening != null) {
			myParent.isNewFrame = false;
		}

		if (myParent.openings.size() > 0) {
			myParent.isNewFrame = false;
		}
		if (myNewOpening.shapeID > 10
				&& (myNewOpening.shapeID < 100 || myNewOpening.shapeID >= 800)) {
			myParent.isNewFrame = true;
		}

		if ((!myParent.isNewFrame || myParent.shapeChanged)
				&& myBOpening != null
				&& (myBOpening.mullions != null
						&& myBOpening.mullions.size() > 0 || myBOpening.mullionsH != null
						&& myBOpening.mullionsH.size() > 0)) {

			myNewOpening.mullions.addAll(myBOpening.mullions);
			myNewOpening.mullionsH.addAll(myBOpening.mullionsH);

			myNewOpening = myNewOpening.modifyVHMCPartDim(myNewOpening);

			myNewOpening.xCols = myBOpening.xCols;
			myNewOpening.yRows = myBOpening.yRows;

			myNewOpening.unGlazed = true;
			doOpening = false;
			found = false;
		}

		if (myParent.shapeChanged) {
			myParent.isNewFrame = true;
		}

		myNewOpening.top1Part.posInUse = myParent.top1.posInUse;
		myNewOpening.top2Part.posInUse = myParent.top2.posInUse;
		myNewOpening.top3Part.posInUse = myParent.top3.posInUse;
		myNewOpening.bot1Part.posInUse = myParent.bot1.posInUse;
		myNewOpening.bot2Part.posInUse = myParent.bot2.posInUse;
		myNewOpening.bot3Part.posInUse = myParent.bot3.posInUse;
		myNewOpening.leftPart.posInUse = myParent.left.posInUse;
		myNewOpening.rightPart.posInUse = myParent.right.posInUse;

		myNewOpening.top1Part.endTypeLT = 3;
		myNewOpening.top2Part.endTypeLT = 3;
		myNewOpening.top3Part.endTypeLT = 3;
		myNewOpening.bot1Part.endTypeLT = 3;
		myNewOpening.bot2Part.endTypeLT = 3;
		myNewOpening.bot3Part.endTypeLT = 3;
		myNewOpening.leftPart.endTypeLT = 3;
		myNewOpening.rightPart.endTypeLT = 3;

		myNewOpening.top1Part.endTypeRB = 3;
		myNewOpening.top2Part.endTypeRB = 3;
		myNewOpening.top3Part.endTypeRB = 3;
		myNewOpening.bot1Part.endTypeRB = 3;
		myNewOpening.bot2Part.endTypeRB = 3;
		myNewOpening.bot3Part.endTypeRB = 3;
		myNewOpening.leftPart.endTypeRB = 3;
		myNewOpening.rightPart.endTypeRB = 3;

		myNewOpening.topIn = myParent.topIn;
		myNewOpening.botIn = myParent.botIn;
		myNewOpening.leftIn = myParent.leftIn;
		myNewOpening.rightIn = myParent.rightIn;

		// myNewOpening.executeOptionRules();

		CreateShapeMethods createShape = new CreateShapeMethods(myParent, 2,
				myFrame2);

		if (!myNewOpening.top2Part.posInUse) {

			myNewOpening.top2Part = (Profiles) myNewOpening.top2Part
					.cloneProfile(myNewOpening.top1Part);
			myNewOpening.top2Part.posInUse = false;
			myParent.top2Part.lengthM = 0;
			myParent.top2Part.lengthI = 0;
		}

		if (myParent.a_levelID == 1) {

			myParent.centerPointX = myParent.top1.x1;// centerPointX;
			myParent.centerPointX2 = myParent.top1.x2;
			myParent.centerPointY = myParent.top1.y1;
			myParent.centerPointY2 = myParent.top1.y2;

			myParent.highestY = highestY;
			myParent.lowestY = lowestY;

			myParent.bkgrdStartX = myNewOpening.bkgrdStartX;
			myParent.bkgrdStartXA = myNewOpening.bkgrdStartXA;

			myParent.bkgrdStartY = myNewOpening.bkgrdStartY;
			myParent.bkgrdStartYA = myNewOpening.bkgrdStartYA;

			myParent.radius1 = myNewOpening.radius1;
			myParent.radius2 = myNewOpening.radius2;
			myParent.radius1A = myNewOpening.radius1A;
			myParent.radius2A = myNewOpening.radius2A;

			if (!myParent.top2Part.posInUse) {

				myParent.top2Part = (Profiles) myParent.top2Part
						.cloneProfile(myParent.top1Part);
				myParent.top2Part.posInUse = false;
				myParent.top2Part.lengthM = 0;
				myParent.top2Part.lengthI = 0;
				myParent.top2 = (Top2Object) myParent.top2
						.cloneProfile(myParent.top2Part);

				myParent.top2.posInUse = false;

			}

		}

		if (!myParent.top2Part.posInUse) {

			myParent.top2Part = (Profiles) myParent.top2Part
					.cloneProfile(myParent.top1Part);
			myParent.top2Part.posInUse = false;
			myParent.top2Part.lengthM = 0;
			myParent.top2Part.lengthI = 0;
			myParent.top2 = (Top2Object) myParent.top2
					.cloneProfile(myParent.top2Part);

			myParent.top2.posInUse = false;

		}

		myNewOpening.a_sequenceID = 11;

		// myNewOpening.gp = this.doGeneralPathBkgrdOpening(myNewOpening);

		myNewOpening = this.doBkgrdPartPos(myNewOpening);

		myNewOpening.glazedOut = myParent.glazedOut;

		myNewOpening.a_1Level = myParent.a_assemblyLevel;
		myNewOpening.a_1Sequence = myParent.a_sequenceID;
		myNewOpening.a_2Level = myParent.a_1Level;
		myNewOpening.a_2Sequence = myParent.a_1Sequence;
		myNewOpening.a_3Level = myParent.a_2Level;
		myNewOpening.a_3Sequence = myParent.a_2Sequence;
		myNewOpening.a_4Level = myParent.a_3Level;
		myNewOpening.a_4Sequence = myParent.a_3Sequence;

		myNewOpening.a_5Level = myParent.a_4Level;
		myNewOpening.a_5Sequence = myParent.a_4Sequence;
		myNewOpening.a_6Level = myParent.a_5Level;
		myNewOpening.a_6Sequence = myParent.a_5Sequence;
		myNewOpening.a_7Level = myParent.a_6Level;
		myNewOpening.a_7Sequence = myParent.a_6Sequence;
		myNewOpening.a_8Level = myParent.a_7Level;
		myNewOpening.a_8Sequence = myParent.a_7Sequence;
		myNewOpening.a_9Level = myParent.a_8Level;
		myNewOpening.a_9Sequence = myParent.a_8Sequence;
		myNewOpening.a_10Level = myParent.a_9Level;
		myNewOpening.a_10Sequence = myParent.a_9Sequence;

		myNewOpening.a_11Level = myParent.a_10Level;
		myNewOpening.a_11Sequence = myParent.a_10Sequence;
		myNewOpening.a_12Level = myParent.a_11Level;
		myNewOpening.a_12Sequence = myParent.a_11Sequence;
		myNewOpening.a_13Level = myParent.a_12Level;
		myNewOpening.a_13Sequence = myParent.a_12Sequence;
		myNewOpening.a_14Level = myParent.a_13Level;
		myNewOpening.a_14Sequence = myParent.a_13Sequence;

		myNewOpening.a_15Level = myParent.a_14Level;
		myNewOpening.a_15Sequence = myParent.a_14Sequence;
		myNewOpening.a_16Level = myParent.a_15Level;
		myNewOpening.a_16Sequence = myParent.a_15Sequence;
		myNewOpening.a_17Level = myParent.a_16Level;
		myNewOpening.a_17Sequence = myParent.a_16Sequence;
		myNewOpening.a_18Level = myParent.a_17Level;
		myNewOpening.a_18Sequence = myParent.a_17Sequence;
		myNewOpening.a_19Level = myParent.a_18Level;
		myNewOpening.a_19Sequence = myParent.a_18Sequence;
		myNewOpening.a_20Level = myParent.a_19Level;
		myNewOpening.a_20Sequence = myParent.a_19Sequence;
		myNewOpening.a_21Level = myParent.a_20Level;
		myNewOpening.a_21Sequence = myParent.a_20Sequence;
		myNewOpening.a_22Level = myParent.a_21Level;
		myNewOpening.a_22Sequence = myParent.a_21Sequence;

		if (myParent.a_levelID == 3) {
			myNewOpening.myParentF = myParent;
		}

		myNewOpening.trackNo = myParent.trackNo;
		myNewOpening.leafNo = myParent.leafNo;
		myNewOpening.paneType = myParent.paneType;

		myNewOpening.top1Part.calcAngles();

		myNewOpening.top2Part.calcAngles();

		myNewOpening.top3Part.calcAngles();

		myNewOpening.bot1Part.calcAngles();

		myNewOpening.bot2Part.calcAngles();

		myNewOpening.bot3Part.calcAngles();

		myNewOpening.leftPart.calcAngles();

		myNewOpening.rightPart.calcAngles();

		myNewOpening = (BkgrdOpeningObject) setProfileLength(myNewOpening);

		myNewOpening.partObjects = createShape
				.setPartObjectsAndCollection(myNewOpening);

		myNewOpening.options.clear();

		if (myFrame2.doOptions) {
			myNewOpening
					.executeOptionRules("createOpening.doMainOpening.2472 - OK BkgrdOpening belonging to Parent Shape");
		}

		myNewOpening.bom.clear();
		myNewOpening.clearBomForShape();

		myNewOpening.executePartRules(true, true,
				"createOpening.doMainOpening.2476");

		myNewOpening.unGlazed = myParent.unGlazed;

		myParent.bOpeningObject = myNewOpening;
		myBOpening = myNewOpening;
		createShape = null;

		if (!myParent.isNewFrame && !found) {

			if (myParent.openings.toArray().length > 0) {
				doOpening = false;
			}

			Object[] openings = myParent.openings.toArray();

			myParent.openings.clear();

			for (Object O : openings) {
//				if (((OpeningObject) O).shapeID == myBOpening.shapeID) {
					O = this.doOpenings((OpeningObject) O);

					myParent.openings.add(O);

//					doOpening = false;

//				} else {
//					doOpening = true;
////					myParent.openings.add(O);
//				}

			}

			// myParent.doOpenings();

		}

		if (doOpening) {

			myParent.openings.clear();

			OpeningObject newOpening = this.doFrameOpening(myBOpening, null);
			newOpening.shapeChanged = false;
			myParent.openings.add(newOpening);
		}

		if (myParent.isNewFrame) {
			// this.myParent.doOpenings(false);
		}

		myNewOpening.shapeChanged = false;
		return myNewOpening;
	}

	/**
	 * Doing openings
	 * 
	 * @param element
	 *            , OpeningObject
	 * @return OpeningObject
	 */
	public OpeningObject doOpenings(OpeningObject element) throws Exception {

		if (myParent.bOpeningObject != null) {

			myBOpening = myParent.bOpeningObject;

		} else {

			myBOpening = element.myParent.bOpeningObject;

		}

		this.setOpeningBackgroundI(element);

		return doOpeningOperations(element);

	}

	OpeningObject doOpeningOperations(OpeningObject element) throws Exception {

		CreateGlass createGlass;
		CreateSash createSash;
		CreateGlazingStops createStops;

		element.gp = this.doGeneralPathOpening(element);

		element.glazedOut = myParent.glazedOut;

		boolean sameParts = true;

		if (myParent.newPart) {
			sameParts = false;
		}

		if (element.myParent.shapeID != 10 && element.myParent.a_levelID > 1) {

			createGlass = new CreateGlass(element.clone(), myFrame2);
			createStops = new CreateGlazingStops(element.clone(), myFrame2);
			CreateDLO createDLO = new CreateDLO(element.clone(), myFrame2);

			GlazingBeads glazingBeads;

			if (element.contentIn == 1) {
				if (!element.unGlazed) {
					openingInContent1(element, createGlass, createStops,
							createDLO);
				}

			} else if (element.contentIn == 2) {

				element = openingInContent2(element, sameParts);

			}

			if (element.contentMid == 1) {

				if (!element.unGlazed) {
					openingMidContent1(element, createGlass, createStops,
							createDLO);
				}

			} else if (element.contentMid == 2) {

				element = openingMidContent2(element, createGlass, createStops,
						sameParts, createDLO);

			} else if (element.contentMid == 3) {

				openingMidContent3(element);

			}

			if (element.contentOut == 1) {
				if (!element.unGlazed) {
					openingOutContent1(element, createGlass, createStops,
							createDLO);
				}

			} else if (element.contentOut == 2) {

				element = openingOutContent2(element, sameParts);

			}
		}

		createGlass = null;
		createSash = null;
		createStops = null;
		return element;
	}

	public void openingInContent1(OpeningObject element,
			CreateGlass createGlass, CreateGlazingStops createStops,
			CreateDLO createDLO) throws Exception {

		GlazingBeads glazingBeads = new GlazingBeads();

		SUType suType = null;

		if (element.myGlassIn != null && element.myGlassMid.suID > 0) {
			if (element.myGlassIn.remote) {
				suType = ItemFrame.getApplicationRemoteBaseRules().getSUType(
						element.myGlassMid.supplierId, element.myGlassMid.suID);
			} else {
				suType = ItemFrame.getApplicationBaseRules().getSUType(
						element.myGlassIn.suID);
			}
		} else {
			suType = myFrame2.mySelectedSUIn;
		}

		createStops.myParentFO = element;
		glazingBeads = createStops.doBeads(suType);

		element.myGlassIn = null;
		createGlass.myParentFO = element;
		element.myGlassIn = createGlass.doGlass(suType);

		element.options.clear();
		if (myFrame2.doOptions) {
			element.executeOptionRules("createOpening.openingInContent1.2647");
		}
		element.bom.clear();
		element.clearBomForShape();
		element.executePartRules(false, true,
				"createOpening.OpeninhInCentent1.2651");

		element.glazingBeadsIn = glazingBeads.partObjects;
		element.glazingBeadIn = glazingBeads;

		createDLO = new CreateDLO(createDLO.myParentFO.cloneOpeningFromBkgrdO(
				createDLO.myParentFO, glazingBeads.bOpeningObject), myFrame2);

		element.dloIn = createDLO.doDLO();
		element.dloIn.myParentGlass = element.myGlassIn;
		element.dloIn.myParentO = element.myGlassIn.myParentO;
		element.dloIn.myParent = element.myGlassIn.myParentO.myParent;
		element.dloIn.myFacet = element.myParent.myFacet;
	}

	public OpeningObject openingInContent2(OpeningObject element,
			boolean sameParts) throws Exception {

		CreateSash createSash;
		Collection mySashLeafs = element.sashObjectIn.frames;

		createSash = this.doSashInOpening(element, mySashLeafs);
		element = createSash.doNewSash(element.sashObjectIn, sameParts,
				mySashLeafs);
		return element;
	}

	public void openingMidContent1(OpeningObject element,
			CreateGlass createGlass, CreateGlazingStops createStops,
			CreateDLO createDLO) throws Exception {

		GlazingBeads glazingBeads = new GlazingBeads();

		SUType suType = null;
		if (element.myGlassMid != null && element.myGlassMid.suID > 0) {
			if (element.myGlassMid.remote) {
				suType = ItemFrame.getApplicationRemoteBaseRules().getSUType(
						element.myGlassMid.supplierId, element.myGlassMid.suID);
			} else {
				suType = ItemFrame.getApplicationBaseRules().getSUType(
						element.myGlassMid.suID);
			}
		} else {
			suType = myFrame2.mySelectedSUMid;
		}

		createStops.myParentFO = element.clone();
		glazingBeads = createStops.doBeads(suType);

		element.myGlassMid = null;
		createGlass.myParentFO = element.clone();
		element.myGlassMid = createGlass.doGlass(suType);

		element.glazingBeadsMid = glazingBeads.partObjects;
		element.glazingBeadMid = glazingBeads;

		createDLO = new CreateDLO(createDLO.myParentFO.cloneOpeningFromBkgrdO(
				createDLO.myParentFO, glazingBeads.bOpeningObject.clone()),
				myFrame2);

		element.dloMid = createDLO.doDLO();
		element.dloMid.myParentGlass = element.myGlassMid;
		element.dloMid.myParentO = element.myGlassMid.myParentO;
		element.dloMid.myParent = element.myGlassMid.myParentO.myParent;
		element.dloMid.myFacet = element.myParent.myFacet;
	}

	public OpeningObject openingMidContent2(OpeningObject element,
			CreateGlass createGlass, CreateGlazingStops createStops,
			boolean sameParts, CreateDLO createDLO) throws Exception {

		CreateSash createSash;
		element.myGlassMid = null;
		element.glazingBeadsMid = null;

		Object[] returns = this.checkOpenings(element);

		if (Integer.valueOf(returns[0].toString()) == 1) {

			Collection mySashLeafs = new ArrayList();

			if (element.sashObjectMid != null) {
				mySashLeafs.addAll(element.sashObjectMid.frames);

				createSash = this.doSashInOpening(element, mySashLeafs);
				createSash.myExistingSashes = mySashLeafs;
				element.sashObjectMid.frames.clear();
				element = createSash.doNewSash(element.sashObjectMid,
						sameParts, mySashLeafs);
			}
		} else {
			JOptionPane.showMessageDialog(null, returns[1].toString()
					+ "/nSash will be removed!", "Error",
					JOptionPane.ERROR_MESSAGE);

			element.contentMid = 1;
			element.sashObjectMid = null;
			openingMidContent1(element, createGlass, createStops, createDLO);
		}
		return element;
	}

	public void openingMidContent3(OpeningObject element) throws Exception {

		Collection existingFacets = new ArrayList();

		existingFacets.add(element.subFacet);

		element.subFacet = new Facet();

		CreateFacets createFacet = new CreateFacets(element, existingFacets,
				myFrame2);

		element.subFacet = createFacet.doFacet(false, false, true, true);
		element.subFacet.doOpenings();
		element.subFacet.doCouplers();
		element.subFacet.doFrames(true, true, true, true);

		element.subFacet.a_levelID = 101;

		element.subFacet.drawFrames();

		element.subFacet.setOriginalDimsInit(element.subFacet.widthPix,
				element.subFacet.heightPix);

		element.subFacet.setDimsChange(element.subFacet.widthPix,
				element.subFacet.heightPix);
		existingFacets = null;
	}

	public void openingOutContent1(OpeningObject element,
			CreateGlass createGlass, CreateGlazingStops createStops,
			CreateDLO createDLO) throws Exception {

		GlazingBeads glazingBeads = new GlazingBeads();
		SUType suType = null;

		if (element.myGlassOut != null && element.myGlassOut.suID > 0) {
			if (element.myGlassOut.remote) {
				suType = ItemFrame.getApplicationRemoteBaseRules().getSUType(
						element.myGlassOut.supplierId, element.myGlassOut.suID);
			} else {
				suType = ItemFrame.getApplicationBaseRules().getSUType(
						element.myGlassOut.suID);
			}
		} else {
			suType = myFrame2.mySelectedSUOut;
		}

		createStops.myParentFO = element;
		glazingBeads = createStops.doBeads(suType);

		element.myGlassOut = null;
		createGlass.myParentFO = element;
		element.myGlassOut = createGlass.doGlass(suType);

		createStops.myParentFO = element;
		glazingBeads = createStops.doBeads(suType);

		element.glazingBeadsOut = glazingBeads.partObjects;
		element.glazingBeadOut = glazingBeads;

		createDLO = new CreateDLO(createDLO.myParentFO.cloneOpeningFromBkgrdO(
				createDLO.myParentFO, glazingBeads.bOpeningObject), myFrame2);

		element.dloOut = createDLO.doDLO();
		element.dloOut.myParentGlass = element.myGlassOut;
		element.dloOut.myParentO = element.myGlassOut.myParentO;
		element.dloOut.myParent = element.myGlassOut.myParentO.myParent;
		element.dloOut.myFacet = element.myParent.myFacet;
	}

	public OpeningObject openingOutContent2(OpeningObject element,
			boolean sameParts) throws Exception {

		CreateSash createSash;
		Collection mySashLeafs = element.sashObjectOut.frames;

		createSash = this.doSashInOpening(element, mySashLeafs);
		element = createSash.doNewSash(element.sashObjectOut, sameParts,
				mySashLeafs);
		return element;
	}

	public CreateSash doSashInOpening(OpeningObject element,
			Collection mySashLeafs) {

		CreateSash createSash = new CreateSash(element,
				element.sashObjectMid.sashClassType,
				element.sashObjectMid.userDefinedOpeningID,
				element.sashObjectMid.noOfLeafs,
				element.sashObjectMid.noTracks,
				element.sashObjectMid.sashOnTrack,
				element.sashObjectMid.whichPos, element.sashObjectMid.split,
				element.sashObjectMid.opens, mySashLeafs, element.glazedOut,
				element.sashObjectMid.sashGlazedOut,
				element.sashObjectMid.paneType, element.sashObjectMid.isOriel,
				element.sashObjectMid.interLocks,
				element.sashObjectMid.extraExtend, myFrame2,
				element.sashObjectMid.openingTypeClass);

		return createSash;
	}

	public OpeningObject setBaseInfo(final OpeningObject opening) {
		if (myFrame2.doOptions) {
			opening.executeOptionRules("createopenings.setBaseinfo.2830");
		}
		opening.top1Part.posInUse = opening.myParent.top1.posInUse;
		opening.top2Part.posInUse = opening.myParent.top2.posInUse;
		opening.top3Part.posInUse = opening.myParent.top3.posInUse;
		opening.bot1Part.posInUse = opening.myParent.bot1.posInUse;
		opening.bot2Part.posInUse = opening.myParent.bot2.posInUse;
		opening.bot3Part.posInUse = opening.myParent.bot3.posInUse;
		opening.leftPart.posInUse = opening.myParent.left.posInUse;
		opening.rightPart.posInUse = opening.myParent.right.posInUse;

		return opening;
	}

	public void getXYpointsMain() {

		px1 = bX1;
		py1 = bY1;
		px1A = bX1A;
		py1A = bY1A;
		px1c = myParent.top1.startX;
		py1c = myParent.top1.startY;

		if (myParent.noSidesTop == 1) {
			px2 = bX2;
			py2 = bY2;
			px2A = bX2A;
			py2A = bY2A;
			px2c = myParent.top1.endX;
			py2c = myParent.top1.endY;

			if (myParent.noSidesBot == 1) {
				if (myParent.noSidesRight > 0) {
					px3 = bX3;
					px4 = bX4;
					py3 = bY3;
					py4 = bY4;
					px3A = bX3A;
					px4A = bX4A;
					py3A = bY3A;
					py4A = bY4A;
					px3c = myParent.bot1.startX;
					px4c = myParent.bot1.endX;
					py3c = myParent.bot1.startY;
					py4c = myParent.bot1.endY;
				} else {
					if (myParent.noSides >= 3) {
						bX3 = bX2;
						bY3 = bY2;

						px3 = bX4;

						py3 = bY4;
						bX3A = bX2A;
						bY3A = bY2A;

						px3A = bX4A;

						py3A = bY4A;

						px3c = myParent.bot1.endX;

						py3c = myParent.bot1.endY;
					} else {
						px1 = bX1;
						py1 = bY1;
						px1A = bX1A;
						py1A = bY1A;
						px1c = myParent.top1.startX;
						py1c = myParent.top1.startY;
						px2 = bX2;
						py2 = bY2;
						px2A = bX2A;
						py2A = bY2A;
						px2c = myParent.top1.endX;
						py2c = myParent.top1.endY;
					}

				}
			} else if (myParent.noSidesBot == 2) {
				if (myParent.noSidesRight > 0) {
					px3 = bX3;
					px4 = b1b2X;
					px5 = bX4;
					py3 = bY3;
					py4 = b1b2Y;
					py5 = bY4;
					px3A = bX3A;
					px4A = b1b2XA;
					px5A = bX4A;
					py3A = bY3A;
					py4A = b1b2YA;
					py5A = bY4A;
					px3c = myParent.bot1.startX;
					px4c = myParent.bot1.endX;
					px5c = myParent.bot2.endX;
					py3c = myParent.bot3.startY;
					py4c = myParent.bot1.endY;
					py5c = myParent.bot2.endY;

				} else {
					if (myParent.noSides >= 3) {
						px3 = b1b2X;
						px4 = bX4;

						py3 = b1b2Y;
						py4 = bY4;

						px3A = b1b2XA;
						px4A = bX4A;

						py3A = b1b2YA;
						py4A = bY4A;

						px3c = myParent.bot1.endX;
						px4c = myParent.bot2.endX;

						py3c = myParent.bot1.endY;
						py4c = myParent.bot2.endY;
					}

				}
			} else if (myParent.noSidesBot == 3) {
				if (myParent.noSidesRight > 0) {
					px3 = bX3;
					px4 = b1b3X;
					px5 = b1b2X;
					px6 = bX4;
					py3 = bY3;
					py4 = b1b3Y;
					py5 = b1b2Y;
					py6 = bY4;

					px3A = bX3A;
					px4A = b1b3XA;
					px5A = b1b2XA;
					px6A = bX4A;
					py3A = bY3A;
					py4A = b1b3YA;
					py5A = b1b2YA;
					py6A = bY4A;

					px3c = myParent.bot3.startX;
					px4c = myParent.bot1.startX;
					px5c = myParent.bot2.startX;
					px6c = myParent.bot2.endX;
					py3c = myParent.bot3.startY;
					py4c = myParent.bot1.startY;
					py5c = myParent.bot2.startY;
					py6c = myParent.bot2.endY;
				} else {
					if (myParent.noSides >= 3) {
						px3 = b1b3X;
						px4 = b1b2X;
						px5 = bX4;

						py3 = b1b3Y;
						py4 = b1b2Y;
						py5 = bY4;

						px3A = b1b3XA;
						px4A = b1b2XA;
						px5A = bX4A;

						py3A = b1b3YA;
						py4A = b1b2YA;
						py5A = bY4A;

						px3c = myParent.bot3.endX;
						px4c = myParent.bot1.endX;
						px5c = myParent.bot2.endX;

						py3c = myParent.bot1.endY;
						py4c = myParent.bot2.endY;
						py5c = myParent.bot2.endY;
					}
				}
			}
		} else if (myParent.noSidesTop == 2) {
			px2 = t1t2X;
			px3 = bX2;
			py2 = t1t2Y;
			py3 = bY2;

			px2A = t1t2XA;
			px3A = bX2A;
			py2A = t1t2YA;
			py3A = bY2A;

			px2c = myParent.top1.endX;
			px3c = myParent.top2.endX;
			py2c = myParent.top1.endY;
			py3c = myParent.top2.endY;
			if (myParent.noSidesBot == 1) {
				if (myParent.noSidesRight > 0) {
					px4 = bX3;
					px5 = bX4;
					py4 = bY3;
					py5 = bY4;

					px4A = bX3A;
					px5A = bX4A;
					py4A = bY3A;
					py5A = bY4A;

					px4c = myParent.bot1.startX;
					px5c = myParent.bot1.endX;
					py4c = myParent.bot1.startY;
					py5c = myParent.bot1.endY;
				} else {
					if (myParent.noSides >= 3) {
						px4 = bX4;

						py4 = bY4;

						px4A = bX4A;

						py4A = bY4A;

						px4c = myParent.bot1.endX;

						py4c = myParent.bot1.endY;
					}
				}

			} else if (myParent.noSidesBot == 2) {
				if (myParent.noSidesRight > 0) {
					px4 = bX3;
					px5 = b1b2X;
					px6 = bX4;
					py4 = bY3;
					py5 = b1b2Y;
					py6 = bY4;

					px4A = bX3A;
					px5A = b1b2XA;
					px6A = bX4A;
					py4A = bY3A;
					py5A = b1b2YA;
					py6A = bY4A;

					px4c = myParent.bot1.startX;
					px5c = myParent.bot1.endX;
					px6c = myParent.bot2.endX;
					py4c = myParent.bot1.startY;
					py5c = myParent.bot1.endY;
					py6c = myParent.bot2.endY;
				} else {
					if (myParent.noSides >= 3) {
						px4 = b1b2X;
						px5 = bX4;

						py4 = b1b2Y;
						py5 = bY4;

						px4A = b1b2XA;
						px5A = bX4A;

						py4A = b1b2YA;
						py5A = bY4A;

						px4c = myParent.bot1.endX;
						px5c = myParent.bot2.endX;

						py4c = myParent.bot1.endY;
						py5c = myParent.bot2.endY;
					}
				}
			} else if (myParent.noSidesBot == 3) {
				if (myParent.noSidesRight > 0) {
					px4 = bX3;
					px5 = b1b3X;
					px6 = b1b2X;
					px7 = bX4;
					py4 = bY3;
					py5 = b1b3Y;
					py6 = b1b2Y;
					py7 = bY4;

					px4A = bX3A;
					px5A = b1b3XA;
					px6A = b1b2XA;
					px7A = bX4A;
					py4A = bY3A;
					py5A = b1b3YA;
					py6A = b1b2YA;
					py7A = bY4A;

					px4c = myParent.bot3.startX;
					px5c = myParent.bot1.startX;
					px6c = myParent.bot2.startX;
					px7c = myParent.bot2.endX;
					py4c = myParent.bot3.startY;
					py5c = myParent.bot1.startY;
					py6c = myParent.bot2.startY;
					py7c = myParent.bot2.endY;
				} else {
					if (myParent.noSides >= 3) {
						px4 = b1b3X;
						px5 = b1b2X;
						px6 = bX4;

						py4 = b1b3Y;
						py5 = b1b2Y;
						py6 = bY4;

						px4A = b1b3XA;
						px5A = b1b2XA;
						px6A = bX4A;

						py4A = b1b3YA;
						py5A = b1b2YA;
						py6A = bY4A;

						px4c = myParent.bot3.endX;
						px5c = myParent.bot1.endX;
						px6c = myParent.bot2.endX;

						py4c = myParent.bot3.endY;
						py5c = myParent.bot1.endY;
						py6c = myParent.bot2.endY;
					}
				}
			}
		} else if (myParent.noSidesTop == 3) {
			px2 = t1t3X;
			px3 = t3t2X;
			px4 = bX2;
			py2 = t1t3Y;
			py3 = t3t2Y;
			py4 = bY2;

			px2A = t1t3XA;
			px3A = t3t2XA;
			px4A = bX2A;
			py2A = t1t3YA;
			py3A = t3t2YA;
			py4A = bY2A;

			px2c = myParent.top1.endX;
			px3c = myParent.top3.endX;
			px4c = myParent.top2.endX;
			py2c = myParent.top1.endY;
			py3c = myParent.top3.endY;
			py4c = myParent.top2.endY;

			if (myParent.noSidesBot == 1) {
				if (myParent.noSidesRight > 0) {
					px5 = bX3;
					px6 = bX4;
					py5 = bY3;
					py6 = bY4;

					px5A = bX3A;
					px6A = bX4A;
					py5A = bY3A;
					py6A = bY4A;

					px5c = myParent.bot1.startX;
					px6c = myParent.bot1.endX;
					py5c = myParent.bot1.startY;
					py6c = myParent.bot1.endY;
				} else {
					if (myParent.noSides >= 3) {
						px5 = bX4;

						py5 = bY4;

						px5A = bX4A;

						py5A = bY4A;

						px5c = myParent.bot1.endX;

						py5c = myParent.bot1.endY;
					}
				}

			} else if (myParent.noSidesBot == 2) {
				if (myParent.noSidesRight > 0) {
					px5 = bX3;
					px6 = b1b2X;
					px7 = bX4;
					py5 = bY3;
					py6 = b1b2Y;
					py7 = bY4;

					px5A = bX3A;
					px6A = b1b2XA;
					px7A = bX4A;
					py5A = bY3A;
					py6A = b1b2YA;
					py7A = bY4A;

					px5c = myParent.bot1.startXBA;
					px6c = myParent.bot1.endX;
					px7c = myParent.bot2.endX;
					py5c = myParent.bot1.startY;
					py6c = myParent.bot1.endY;
					py7c = myParent.bot2.endY;
				} else {
					if (myParent.noSides >= 3) {
						px5 = b1b2X;
						px6 = bX4;

						py5 = b1b2Y;
						py6 = bY4;

						px5A = b1b2XA;
						px6A = bX4A;

						py5A = b1b2YA;
						py6A = bY4A;

						px5c = myParent.bot1.endX;
						px6c = myParent.bot2.endX;

						py5c = myParent.bot1.endY;
						py6c = myParent.bot2.endY;
					}
				}
			} else if (myParent.noSidesBot == 3) {
				if (myParent.noSidesRight > 0) {
					px5 = bX3;
					px6 = b1b3X;
					px7 = b1b2X;
					px8 = bX4;
					py5 = bY3;
					py6 = b1b3Y;
					py7 = b1b2Y;
					py8 = bY4;

					px5A = bX3A;
					px6A = b1b3XA;
					px7A = b1b2XA;
					px8A = bX4A;
					py5A = bY3A;
					py6A = b1b3YA;
					py7A = b1b2YA;
					py8A = bY4A;

					px5c = myParent.bot1.startX;
					px6c = myParent.bot3.startX;
					px7c = myParent.bot2.startX;
					px8c = myParent.bot2.endX;
					py5c = myParent.bot1.startY;
					py6c = myParent.bot3.startY;
					py7c = myParent.bot2.startY;
					py8c = myParent.bot2.endY;
				} else {
					if (myParent.noSides >= 3) {
						px5 = b1b3X;
						px6 = b1b2X;
						px7 = bX4;

						py5 = b1b3Y;
						py6 = b1b2Y;
						py7 = bY4;

						px5A = b1b3XA;
						px6A = b1b2XA;
						px7A = bX4A;

						py5A = b1b3YA;
						py6A = b1b2YA;
						py7A = bY4A;

						px5c = myParent.bot3.endX;
						px6c = myParent.bot2.startX;
						px7c = myParent.bot2.endX;

						py5c = myParent.bot3.endY;
						py6c = myParent.bot2.startY;
						py7c = myParent.bot2.endY;
					}
				}
			}
		}
	}

	public OpeningObject setXYpointsCenter(final OpeningObject opening) {

		if (opening.noSidesLeft == 0) {
			if (opening.noSidesBot == 1) {
				tx1c = opening.px1c;
				ty1c = opening.py1c;

			} else if (opening.noSidesBot > 1) {

			}
		} else if (opening.noSidesLeft == 1) {
			tx1c = opening.px1c;
			ty1c = opening.py1c;

		}

		// / End general Px1 Py1 Start

		switch (opening.noSidesTop) {
		case 1: // top 1
			switch (opening.noSidesRight) {

			case 1: // R1
				opening.px2 = this.intersectX(tx1, //
						ty1, //
						tx2, //
						ty2, //
						rx1, //
						ry1, //
						rx2, //
						ry2); //
				opening.py2 = this.intersectY(tx1, //
						ty1, //
						tx2, //
						ty2, //
						rx1, //
						ry1, //
						rx2, //
						ry2); //

				switch (opening.noSidesBot) {

				case 1: // bot
					// 1
					opening.px3 = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					opening.py3 = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					switch (opening.noSidesLeft) {

					case 1: // left
						// 1
						opening.px4 = this.intersectX(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						opening.py4 = this.intersectY(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						opening.px4 = opening.px1; //
						opening.py4 = opening.py1; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot1

				case 2: // bot
					// 2
					opening.px3 = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					opening.py3 = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					opening.px4 = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					opening.py4 = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					switch (opening.noSidesLeft) {
					case 1: // left
						// 1
						opening.px5 = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						opening.py5 = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						opening.px5 = opening.px1;
						opening.py5 = opening.py1; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 2

				case 3: // bot
					// 3
					opening.px3 = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					opening.py3 = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					opening.px4 = this.intersectX(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					opening.py4 = this.intersectY(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					opening.px5 = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					opening.py5 = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					switch (opening.noSidesLeft) {

					case 1: // left
						// 1
						opening.px6 = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						opening.py6 = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						break;// left
					// 1

					case 0:// left
							// 0
						opening.px6 = opening.px1; //
						opening.py6 = opening.py1; //
						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 3

				} // Case Bot

				break;// R1

			case 0: // R0

				switch (opening.noSidesBot) {

				case 1: // bot
					// 1
					opening.px2 = this.intersectX(tx1, //
							ty1, //
							tx2, //
							ty2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					opening.py2 = this.intersectY(tx1, //
							ty1, //
							tx2, //
							ty2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					if (opening.px2 == 0) {
						opening.px2 = bx1;
						opening.py2 = by1;
					}
					switch (opening.noSidesLeft) {

					case 1: // left
						// 1
						opening.px3 = this.intersectX(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						opening.py3 = this.intersectY(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						opening.px3 = opening.px1; //
						opening.py3 = opening.py1; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot1

				case 2: // bot
					// 2
					opening.px2 = this.intersectX(tx1, //
							ty1, //
							tx2, //
							ty2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					opening.py2 = this.intersectY(tx1, //
							ty1, //
							tx2, //
							ty2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					if (opening.px2 == 0) {
						opening.px2 = bx1;
						opening.py2 = by1;
					}
					opening.px3 = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					opening.py3 = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					switch (opening.noSidesLeft) {
					case 1: // left
						// 1
						opening.px4 = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						opening.py4 = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						opening.px4 = opening.px1;
						opening.py4 = opening.py1; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 2

				case 3: // bot
					// 3
					opening.px2 = this.intersectX(tx1, //
							ty1, //
							tx2, //
							ty2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					opening.py2 = this.intersectY(tx1, //
							ty1, //
							tx2, //
							ty2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //
					if (opening.px2 == 0) {
						opening.px2 = b3x1;
						opening.py2 = b3y1;
					}

					opening.px3 = this.intersectX(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					opening.py3 = this.intersectY(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					opening.px4 = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					opening.py4 = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					switch (opening.noSidesLeft) {

					case 1: // left
						// 1
						opening.px5 = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						opening.py5 = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						break;// left
					// 1

					case 0:// left
							// 0
						opening.px5 = opening.px1; //
						opening.py5 = opening.py1; //
						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 3

				} // Case Bot

				break;// R0

			}// Case Right

			break; // Top 1
		// ////////////////////////////////////////////////////
		case 2: // Top 2

			opening.px2 = this.intersectX(tx1, //
					ty1, //
					tx2, //
					ty2, //
					t2x1, //
					t2y1, //
					t2x2, //
					t2y2); //
			opening.py2 = this.intersectY(tx1, //
					ty1, //
					tx2, //
					ty2, //
					t2x1, //
					t2y1, //
					t2x2, //
					t2y2); //
			if (opening.px2 == 0) {
				opening.px2 = t2x1;
				opening.py2 = t2y1;
			}

			switch (opening.noSidesRight) {

			case 1: // R1
				opening.px3 = this.intersectX(t2x1, //
						t2y1, //
						t2x2, //
						t2y2, //
						rx1, //
						ry1, //
						rx2, //
						ry2); //
				opening.py3 = this.intersectY(t2x1, //
						t2y1, //
						t2x2, //
						t2y2, //
						rx1, //
						ry1, //
						rx2, //
						ry2); //

				switch (opening.noSidesBot) {

				case 1: // bot
					// 1
					opening.px4 = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					opening.py4 = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					switch (opening.noSidesLeft) {

					case 1: // left
						// 1
						opening.px5 = this.intersectX(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						opening.py5 = this.intersectY(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						opening.px5 = opening.px1; //
						opening.py5 = opening.py1; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot1

				case 2: // bot
					// 2
					opening.px4 = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					opening.py4 = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					opening.px5 = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					opening.py5 = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					switch (opening.noSidesLeft) {
					case 1: // left
						// 1
						opening.px6 = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						opening.py6 = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						opening.px6 = opening.px1;
						opening.py6 = opening.py1; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 2

				case 3: // bot
					// 3
					opening.px4 = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					opening.py4 = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					opening.px5 = this.intersectX(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					opening.py5 = this.intersectY(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					opening.px6 = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					opening.py6 = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					switch (opening.noSidesLeft) {

					case 1: // left
						// 1
						opening.px7 = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						opening.py7 = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						break;// left
					// 1

					case 0:// left
							// 0
						opening.px7 = opening.px1; //
						opening.py7 = opening.py1; //
						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 3

				} // Case Bot

				break;// R1

			case 0: // R0

				switch (opening.noSidesBot) {

				case 1: // bot
					// 1
					opening.px3 = this.intersectX(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					opening.py3 = this.intersectY(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					if (opening.px3 == 0) {
						opening.px3 = bx1;
						opening.py3 = by1;
					}

					switch (opening.noSidesLeft) {

					case 1: // left
						// 1
						opening.px4 = this.intersectX(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						opening.py4 = this.intersectY(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						opening.px4 = opening.px1; //
						opening.py4 = opening.py1; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot1

				case 2: // bot
					// 2
					opening.px3 = this.intersectX(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					opening.py3 = this.intersectY(tx1, //
							ty1, //
							tx2, //
							ty2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					if (opening.px3 == 0) {
						opening.px3 = bx1;
						opening.py3 = by1;
					}
					opening.px4 = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					opening.py4 = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					switch (opening.noSidesLeft) {
					case 1: // left
						// 1
						opening.px5 = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						opening.py5 = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						opening.px5 = opening.px1;
						opening.py5 = opening.py1; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 2

				case 3: // bot
					// 3
					opening.px3 = this.intersectX(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					opening.py3 = this.intersectY(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					if (opening.px3 == 0) {
						opening.px3 = b3x1;
						opening.py3 = b3y1;
					}

					opening.px4 = this.intersectX(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					opening.py4 = this.intersectY(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					opening.px5 = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					opening.py5 = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					switch (opening.noSidesLeft) {

					case 1: // left
						// 1
						opening.px6 = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						opening.py6 = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						break;// left
					// 1

					case 0:// left
							// 0
						opening.px6 = opening.px1; //
						opening.py6 = opening.py1; //
						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 3

				} // Case Bot

				break;// R0

			}// Case Right

			break; // Top 2
		// /////////////////////////////////////////////////////////////////
		case 3: // Top 3

			opening.px2 = this.intersectX(tx1, //
					ty1, //
					tx2, //
					ty2, //
					t3x1, //
					t3y1, //
					t3x2, //
					t3y2); //
			opening.py2 = this.intersectY(tx1, //
					ty1, //
					tx2, //
					ty2, //
					t3x1, //
					t3y1, //
					t3x2, //
					t3y2); //

			if (opening.px2 == 0) {
				opening.px2 = t3x1;
				opening.py2 = t3y1;
			}

			opening.px3 = this.intersectX(t3x1, //
					t3y1, //
					t3x2, //
					t3y2, //
					t2x1, //
					t2y1, //
					t2x2, //
					t2y2); //
			opening.py3 = this.intersectY(t3x1, //
					t3y1, //
					t3x2, //
					t3y2, //
					t2x1, //
					t2y1, //
					t2x2, //
					t2y2); //

			if (opening.px3 == 0) {
				opening.px3 = t3x2;
				opening.py3 = t3y2;
			}

			switch (opening.noSidesRight) {

			case 1: // R1

				opening.px4 = this.intersectX(t2x1, //
						t2y1, //
						t2x2, //
						t2y2, //
						rx1, //
						ry1, //
						rx2, //
						ry2); //
				opening.py4 = this.intersectY(t2x1, //
						t2y1, //
						t2x2, //
						t2y2, //
						rx1, //
						ry1, //
						rx2, //
						ry2); //

				switch (opening.noSidesBot) {

				case 1: // bot
					// 1
					opening.px5 = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					opening.py5 = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					switch (opening.noSidesLeft) {

					case 1: // left
						// 1
						opening.px6 = this.intersectX(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						opening.py6 = this.intersectY(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						opening.px6 = opening.px1; //
						opening.py6 = opening.py1; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot1

				case 2: // bot
					// 2
					opening.px5 = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					opening.py5 = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					opening.px6 = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					opening.py6 = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					switch (opening.noSidesLeft) {
					case 1: // left
						// 1
						opening.px7 = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						opening.py7 = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						opening.px7 = opening.px1;
						opening.py7 = opening.py1; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 2

				case 3: // bot
					// 3
					opening.px5 = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					opening.py5 = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					opening.px6 = this.intersectX(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					opening.py6 = this.intersectY(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					opening.px7 = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					opening.py7 = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					switch (opening.noSidesLeft) {

					case 1: // left
						// 1
						opening.px8 = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						opening.py8 = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						break;// left
					// 1

					case 0:// left
							// 0
						opening.px8 = opening.px1; //
						opening.py8 = opening.py1; //
						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 3

				} // Case Bot

				break;// R1

			case 0: // R0

				switch (opening.noSidesBot) {

				case 1: // bot
					// 1
					opening.px4 = this.intersectX(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					opening.py4 = this.intersectY(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					if (opening.px4 == 0) {
						opening.px4 = bx1;
						opening.py4 = by1;
					}

					switch (opening.noSidesLeft) {

					case 1: // left
						// 1
						opening.px5 = this.intersectX(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						opening.py5 = this.intersectY(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						opening.px5 = opening.px1; //
						opening.py5 = opening.py1; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot1

				case 2: // bot
					// 2
					opening.px4 = this.intersectX(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					opening.py4 = this.intersectY(tx1, //
							ty1, //
							tx2, //
							ty2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					if (opening.px4 == 0) {
						opening.px4 = bx1;
						opening.py4 = by1;
					}

					opening.px5 = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					opening.py5 = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					switch (opening.noSidesLeft) {
					case 1: // left
						// 1
						opening.px6 = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						opening.py6 = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						opening.px6 = opening.px1;
						opening.py6 = opening.py1; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 2

				case 3: // bot
					// 3
					opening.px4 = this.intersectX(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					opening.py4 = this.intersectY(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //
					if (opening.px4 == 0) {
						opening.px4 = b3x1;
						opening.py4 = b3y1;
					}

					opening.px5 = this.intersectX(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					opening.py5 = this.intersectY(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					opening.px6 = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					opening.py6 = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					switch (opening.noSidesLeft) {

					case 1: // left
						// 1
						opening.px6 = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						opening.py6 = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						break;// left
					// 1

					case 0:// left
							// 0
						opening.px6 = opening.px1; //
						opening.py6 = opening.py1; //
						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 3

				} // Case Bot

				break;// R0

			}// Case Right

			break; // Top 3

		}
		return opening;
	}

	public void makeSides(final OpeningObject myInitOpening) {

		if (myInitOpening.endCol == myInitOpening.myParent.xCols
				&& myInitOpening.myParent.noSidesTop == 2
				&& myInitOpening.topIn && myParent.top1.partForm == 2
				&& myParent.top2.partForm == 2) {
			myInitOpening.top1Part.bkgrdStartX = myInitOpening.top1Part.bkgrdStartXBA = myParent.top2.bkgrdStartXBA;
			myInitOpening.top1Part.bkgrdStartY = myInitOpening.top1Part.bkgrdStartYBA = myParent.top2.bkgrdStartYBA;

			myInitOpening.bkgrdStartX = myParent.top2.bkgrdStartXBA;
			myInitOpening.bkgrdStartY = myParent.top2.bkgrdStartYBA;
			myInitOpening.top1Part.bkgrdStartXA = myParent.top2.bkgrdStartXA;
			myInitOpening.top1Part.bkgrdStartYA = myParent.top2.bkgrdStartYA;
			myInitOpening.top1Part.bkgrdWidth = myInitOpening.top1Part.bkgrdHeight = myParent.top2.bkgrdHeightBA;
			myInitOpening.top1Part.bkgrdWidthA = myInitOpening.top1Part.bkgrdHeightA = myParent.top2.bkgrdHeightA;

		}

		myInitOpening.top1Part.startXC = myInitOpening.px1;
		myInitOpening.top1Part.startYC = myInitOpening.py1;
		myInitOpening.top1Part.startXBA = myInitOpening.px1;
		myInitOpening.top1Part.startYBA = myInitOpening.py1;

		myInitOpening.startingX = myInitOpening.px1;
		myInitOpening.startingY = myInitOpening.py1;
		myInitOpening.startingXBA = myInitOpening.px1;
		myInitOpening.startingYBA = myInitOpening.py1;

		myInitOpening.top1Part.startXA = myInitOpening.px1A;
		myInitOpening.top1Part.startYA = myInitOpening.py1A;

		myInitOpening.startingXA = myInitOpening.px1A;
		myInitOpening.startingYA = myInitOpening.py1A;

		myInitOpening.startingCX = myInitOpening.px1c;
		myInitOpening.startingCY = myInitOpening.py1c;

		myInitOpening.top1Part.endXC = myInitOpening.px2;
		myInitOpening.top1Part.endYC = myInitOpening.py2;
		myInitOpening.top1Part.endXBA = myInitOpening.px2;
		myInitOpening.top1Part.endYBA = myInitOpening.py2;

		myInitOpening.top1Part.endXA = myInitOpening.px2A;
		myInitOpening.top1Part.endYA = myInitOpening.py2A;

		myInitOpening.bX2 = myInitOpening.px2;
		myInitOpening.bY2 = myInitOpening.py2;
		myInitOpening.bX2A = myInitOpening.px2A;
		myInitOpening.bY2A = myInitOpening.py2A;
		myInitOpening.bCX2 = myInitOpening.px2c;
		myInitOpening.bCY2 = myInitOpening.py2c;

		// } else
		if (myInitOpening.noSidesTop == 2) {
			if (myInitOpening.top2Part.partForm == 2
					&& myInitOpening.myParent.noSidesTop == 2
					&& myInitOpening.myParent.top1.partForm == 2
					&& myInitOpening.myParent.top2.partForm == 2) {
				myInitOpening.top2Part.bkgrdWidth = myInitOpening.top2Part.bkgrdWidthBA = myInitOpening.top2Part.bkgrdHeight = myInitOpening.top2Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.top2Part.bkgrdStartX = myInitOpening.top2Part.bkgrdStartXBA = myInitOpening.top2Part.bkgrdStartX;// myInitOpening.bkgrdStartX;
				myInitOpening.top2Part.bkgrdStartY = myInitOpening.top2Part.bkgrdStartYBA = myInitOpening.top2Part.bkgrdStartY;// myInitOpening.bkgrdStartY;
			}
			myInitOpening.top2Part.startXC = myInitOpening.px2;
			myInitOpening.top2Part.startYC = myInitOpening.py2;
			myInitOpening.top2Part.startXBA = myInitOpening.px2;
			myInitOpening.top2Part.startYBA = myInitOpening.py2;
			myInitOpening.top2Part.endXC = myInitOpening.px3;
			myInitOpening.top2Part.endYC = myInitOpening.py3;
			myInitOpening.top2Part.endXBA = myInitOpening.px3;
			myInitOpening.top2Part.endYBA = myInitOpening.py3;
			myInitOpening.bX2 = myInitOpening.px3;
			myInitOpening.bY2 = myInitOpening.py3;

			// myInitOpening.top2Part.bkgrdWidthA
			// =
			// myInitOpening.top2Part.bkgrdHeightA
			// = myInitOpening.radius1A * 2;
			// myInitOpening.top2Part.bkgrdStartXA
			// =
			// myInitOpening.top1Part.bkgrdStartXA;//
			// myInitOpening.bkgrdStartX;
			// myInitOpening.top2Part.bkgrdStartYA
			// =
			// myInitOpening.top1Part.bkgrdStartYA;//
			// myInitOpening.bkgrdStartY;
			// myInitOpening.top2Part.radius1A =
			// myInitOpening.radius1A;
			// myInitOpening.top2Part.radius2A =
			// myInitOpening.radius2A;
			myInitOpening.top2Part.startXA = myInitOpening.px2A;
			myInitOpening.top2Part.startYA = myInitOpening.py2A;
			myInitOpening.top2Part.endXA = myInitOpening.px3A;
			myInitOpening.top2Part.endYA = myInitOpening.py3A;
			myInitOpening.bX2A = myInitOpening.px3A;
			myInitOpening.bY2A = myInitOpening.py3A;

			myInitOpening.bCX2 = myInitOpening.px3c;
			myInitOpening.bCY2 = myInitOpening.py3c;

		}
		if (myInitOpening.noSidesTop == 3) {
			myInitOpening.top3Part.bkgrdWidth = myInitOpening.top3Part.bkgrdHeight = myInitOpening.top3Part.bkgrdWidthBA = myInitOpening.top3Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
			myInitOpening.top3Part.bkgrdStartX = myInitOpening.top3Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
			myInitOpening.top3Part.bkgrdStartY = myInitOpening.top3Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
			// myInitOpening.top3Part.radius1 =
			// myInitOpening.top3Part.radius1BA
			// =
			// myInitOpening.radius1;
			// myInitOpening.top3Part.radius2 =
			// myInitOpening.top3Part.radius2BA
			// =
			// myInitOpening.radius2;
			myInitOpening.top3Part.startXC = myInitOpening.top3Part.startXBA = myInitOpening.px2;
			myInitOpening.top3Part.startYC = myInitOpening.top3Part.startYBA = myInitOpening.py2;
			myInitOpening.top3Part.endXC = myInitOpening.top3Part.endXBA = myInitOpening.px3;
			myInitOpening.top3Part.endYC = myInitOpening.top3Part.endYBA = myInitOpening.py3;

			myInitOpening.top2Part.bkgrdWidth = myInitOpening.top2Part.bkgrdHeight = myInitOpening.top2Part.bkgrdWidthBA = myInitOpening.top2Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
			myInitOpening.top2Part.bkgrdStartX = myInitOpening.top2Part.bkgrdStartXBA = myInitOpening.top2Part.bkgrdStartX;// myInitOpening.bkgrdStartX;
			myInitOpening.top2Part.bkgrdStartY = myInitOpening.top2Part.bkgrdStartYBA = myInitOpening.top2Part.bkgrdStartY;// myInitOpening.bkgrdStartY;
			// myInitOpening.top2Part.radius1 =
			// myInitOpening.top2Part.radius1BA
			// =
			// myInitOpening.radius1;
			// myInitOpening.top2Part.radius2 =
			// myInitOpening.top2Part.radius2BA
			// =
			// myInitOpening.radius2;
			myInitOpening.top2Part.startXC = myInitOpening.top2Part.startXBA = myInitOpening.px3;
			myInitOpening.top2Part.startYC = myInitOpening.top2Part.startYBA = myInitOpening.py3;
			myInitOpening.top2Part.endXC = myInitOpening.top2Part.endXBA = myInitOpening.px4;
			myInitOpening.top2Part.endYC = myInitOpening.top2Part.endYBA = myInitOpening.py4;
			myInitOpening.bX2 = myInitOpening.px4;
			myInitOpening.bY2 = myInitOpening.py4;

			myInitOpening.top3Part.bkgrdWidthA = myInitOpening.top3Part.bkgrdHeightA = myInitOpening.radius1A * 2;
			myInitOpening.top3Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
			myInitOpening.top3Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
			// myInitOpening.top3Part.radius1A =
			// myInitOpening.radius1A;
			// myInitOpening.top3Part.radius2A =
			// myInitOpening.radius2A;
			myInitOpening.top3Part.startXA = myInitOpening.px2A;
			myInitOpening.top3Part.startYA = myInitOpening.py2A;
			myInitOpening.top3Part.endXA = myInitOpening.px3A;
			myInitOpening.top3Part.endYA = myInitOpening.py3A;

			myInitOpening.top2Part.bkgrdWidthA = myInitOpening.top2Part.bkgrdHeightA = myInitOpening.radius1A * 2;
			myInitOpening.top2Part.bkgrdStartXA = myInitOpening.top2Part.bkgrdStartXA;// myInitOpening.bkgrdStartX;
			myInitOpening.top2Part.bkgrdStartYA = myInitOpening.top2Part.bkgrdStartYA;// myInitOpening.bkgrdStartY;
			// myInitOpening.top2Part.radius1A =
			// myInitOpening.radius1A;
			// myInitOpening.top2Part.radius2A =
			// myInitOpening.radius2A;
			myInitOpening.top2Part.startXA = myInitOpening.px3A;
			myInitOpening.top2Part.startYA = myInitOpening.py3A;
			myInitOpening.top2Part.endXA = myInitOpening.px4A;
			myInitOpening.top2Part.endYA = myInitOpening.py4A;
			myInitOpening.bX2A = myInitOpening.px4A;
			myInitOpening.bY2A = myInitOpening.py4A;

			myInitOpening.bCX2 = myInitOpening.px4c;
			myInitOpening.bCY2 = myInitOpening.py4c;

		}
		if (myInitOpening.noSidesRight == 1) {
			if (myInitOpening.noSidesTop == 1) {
				myInitOpening.rightPart.bkgrdWidth = myInitOpening.rightPart.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.rightPart.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.rightPart.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.rightPart.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.rightPart.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.rightPart.startXC = myInitOpening.px2;
				myInitOpening.rightPart.startYC = myInitOpening.py2;
				myInitOpening.rightPart.endXC = myInitOpening.px3;
				myInitOpening.rightPart.endYC = myInitOpening.py3;

				myInitOpening.rightPart.bkgrdWidthBA = myInitOpening.rightPart.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.rightPart.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.rightPart.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.rightPart.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.rightPart.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.rightPart.startXBA = myInitOpening.px2;
				myInitOpening.rightPart.startYBA = myInitOpening.py2;
				myInitOpening.rightPart.endXBA = myInitOpening.px3;
				myInitOpening.rightPart.endYBA = myInitOpening.py3;

				myInitOpening.rightPart.bkgrdWidthA = myInitOpening.rightPart.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.rightPart.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.rightPart.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.rightPart.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.rightPart.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.rightPart.startXA = myInitOpening.px2A;
				myInitOpening.rightPart.startYA = myInitOpening.py2A;
				myInitOpening.rightPart.endXA = myInitOpening.px3A;
				myInitOpening.rightPart.endYA = myInitOpening.py3A;

				myInitOpening.bX3 = myInitOpening.px3;
				myInitOpening.bY3 = myInitOpening.py3;
				myInitOpening.bX3A = myInitOpening.px3A;
				myInitOpening.bY3A = myInitOpening.py3A;

				myInitOpening.bCX3 = myInitOpening.px3c;
				myInitOpening.bCY3 = myInitOpening.py3c;

			} else if (myInitOpening.noSidesTop == 2) {
				myInitOpening.rightPart.bkgrdWidth = myInitOpening.rightPart.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.rightPart.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.rightPart.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.rightPart.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.rightPart.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.rightPart.startXC = myInitOpening.px3;
				myInitOpening.rightPart.startYC = myInitOpening.py3;
				myInitOpening.rightPart.endXC = myInitOpening.px4;
				myInitOpening.rightPart.endYC = myInitOpening.py4;
				myInitOpening.bX3 = myInitOpening.px4;
				myInitOpening.bY3 = myInitOpening.py4;

				myInitOpening.rightPart.bkgrdWidthBA = myInitOpening.rightPart.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.rightPart.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.rightPart.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.rightPart.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.rightPart.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.rightPart.startXBA = myInitOpening.px3;
				myInitOpening.rightPart.startYBA = myInitOpening.py3;
				myInitOpening.rightPart.endXBA = myInitOpening.px4;
				myInitOpening.rightPart.endYBA = myInitOpening.py4;

				myInitOpening.rightPart.bkgrdWidthA = myInitOpening.rightPart.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.rightPart.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.rightPart.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.rightPart.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.rightPart.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.rightPart.startXA = myInitOpening.px3A;
				myInitOpening.rightPart.startYA = myInitOpening.py3A;
				myInitOpening.rightPart.endXA = myInitOpening.px4A;
				myInitOpening.rightPart.endYA = myInitOpening.py4A;
				myInitOpening.bX3A = myInitOpening.px4A;
				myInitOpening.bY3A = myInitOpening.py4A;

				myInitOpening.bCX3 = myInitOpening.px4c;
				myInitOpening.bCY3 = myInitOpening.py4c;

			} else if (myInitOpening.noSidesTop == 3) {
				myInitOpening.rightPart.bkgrdWidth = myInitOpening.rightPart.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.rightPart.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.rightPart.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.rightPart.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.rightPart.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.rightPart.startXC = myInitOpening.px4;
				myInitOpening.rightPart.startYC = myInitOpening.py4;
				myInitOpening.rightPart.endXC = myInitOpening.px5;
				myInitOpening.rightPart.endYC = myInitOpening.py5;
				myInitOpening.bX3 = myInitOpening.px5;
				myInitOpening.bY3 = myInitOpening.py5;
				myInitOpening.bCX3 = myInitOpening.px5c;
				myInitOpening.bCY3 = myInitOpening.py5c;

				myInitOpening.rightPart.bkgrdWidthBA = myInitOpening.rightPart.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.rightPart.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.rightPart.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.rightPart.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.rightPart.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.rightPart.startXBA = myInitOpening.px4;
				myInitOpening.rightPart.startYBA = myInitOpening.py4;
				myInitOpening.rightPart.endXBA = myInitOpening.px5;
				myInitOpening.rightPart.endYBA = myInitOpening.py5;

				myInitOpening.rightPart.bkgrdWidthA = myInitOpening.rightPart.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.rightPart.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.rightPart.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.rightPart.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.rightPart.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.rightPart.startXA = myInitOpening.px4A;
				myInitOpening.rightPart.startYA = myInitOpening.py4A;
				myInitOpening.rightPart.endXA = myInitOpening.px5A;
				myInitOpening.rightPart.endYA = myInitOpening.py5A;
				myInitOpening.bX3A = myInitOpening.px5A;
				myInitOpening.bY3A = myInitOpening.py5A;

			}
		}
		if (myInitOpening.noSidesBot == 1) {
			if (myInitOpening.noSidesTop == 1
					&& myInitOpening.noSidesRight == 1) {
				myInitOpening.bot1Part.bkgrdWidth = myInitOpening.bot1Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXC = myInitOpening.px3;
				myInitOpening.bot1Part.startYC = myInitOpening.py3;

				myInitOpening.bot1Part.endXC = myInitOpening.px4;
				myInitOpening.bot1Part.endYC = myInitOpening.py4;
				myInitOpening.bX4 = myInitOpening.px4;
				myInitOpening.bY4 = myInitOpening.py4;

				myInitOpening.bot1Part.bkgrdWidthBA = myInitOpening.bot1Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXBA = myInitOpening.px3;
				myInitOpening.bot1Part.startYBA = myInitOpening.py3;

				myInitOpening.bot1Part.endXBA = myInitOpening.px4;
				myInitOpening.bot1Part.endYBA = myInitOpening.py4;

				myInitOpening.bot1Part.bkgrdWidthA = myInitOpening.bot1Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot1Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot1Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot1Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot1Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot1Part.startXA = myInitOpening.px3A;
				myInitOpening.bot1Part.startYA = myInitOpening.py3A;

				myInitOpening.bot1Part.endXA = myInitOpening.px4A;
				myInitOpening.bot1Part.endYA = myInitOpening.py4A;
				myInitOpening.bX4A = myInitOpening.px4A;
				myInitOpening.bY4A = myInitOpening.py4A;

				myInitOpening.bCX4 = myInitOpening.px4c;
				myInitOpening.bCY4 = myInitOpening.py4c;
				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidth = myInitOpening.leftPart.bkgrdHeight = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartX = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartY = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXC = myInitOpening.px4;
					myInitOpening.leftPart.startYC = myInitOpening.py4;
					myInitOpening.leftPart.endXC = myInitOpening.px1;
					myInitOpening.leftPart.endYC = myInitOpening.py1;

					myInitOpening.leftPart.bkgrdWidthBA = myInitOpening.leftPart.bkgrdHeightBA = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartXBA = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartYBA = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1BA
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2BA
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXBA = myInitOpening.px4;
					myInitOpening.leftPart.startYBA = myInitOpening.py4;
					myInitOpening.leftPart.endXBA = myInitOpening.px1;
					myInitOpening.leftPart.endYBA = myInitOpening.py1;

					myInitOpening.leftPart.bkgrdWidthA = myInitOpening.leftPart.bkgrdHeightA = myInitOpening.radius1A * 2;
					myInitOpening.leftPart.bkgrdStartXA = myInitOpening.bkgrdStartXA;
					myInitOpening.leftPart.bkgrdStartYA = myInitOpening.bkgrdStartYA;
					// myInitOpening.leftPart.radius1A
					// =
					// myInitOpening.radius1A;
					// myInitOpening.leftPart.radius2A
					// =
					// myInitOpening.radius2A;
					myInitOpening.leftPart.startXA = myInitOpening.px4A;
					myInitOpening.leftPart.startYA = myInitOpening.py4A;
					myInitOpening.leftPart.endXA = myInitOpening.px1A;
					myInitOpening.leftPart.endYA = myInitOpening.py1A;

				}
			} else if (myInitOpening.noSidesTop == 1
					&& myInitOpening.noSidesRight == 0) {
				myInitOpening.bot1Part.bkgrdWidth = myInitOpening.bot1Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXC = myInitOpening.px2;
				myInitOpening.bot1Part.startYC = myInitOpening.py2;

				myInitOpening.bot1Part.bkgrdWidthBA = myInitOpening.bot1Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXBA = myInitOpening.px2;
				myInitOpening.bot1Part.startYBA = myInitOpening.py2;

				myInitOpening.bot1Part.bkgrdWidthA = myInitOpening.bot1Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot1Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot1Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot1Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot1Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot1Part.startXA = myInitOpening.px2A;
				myInitOpening.bot1Part.startYA = myInitOpening.py2A;

				if (myInitOpening.noSides >= 3) {
					myInitOpening.bot1Part.endXC = myInitOpening.px3;
					myInitOpening.bot1Part.endYC = myInitOpening.py3;
					myInitOpening.bot1Part.endXBA = myInitOpening.px3;
					myInitOpening.bot1Part.endYBA = myInitOpening.py3;
					myInitOpening.bot1Part.endXA = myInitOpening.px3A;
					myInitOpening.bot1Part.endYA = myInitOpening.py3A;
					myInitOpening.bX3 = myInitOpening.px2;
					myInitOpening.bY3 = myInitOpening.py2;
					myInitOpening.bCX3 = myInitOpening.px2c;
					myInitOpening.bCY3 = myInitOpening.py2c;
					myInitOpening.bX4 = myInitOpening.px3;
					myInitOpening.bY4 = myInitOpening.py3;
					myInitOpening.bX3A = myInitOpening.px2A;
					myInitOpening.bY3A = myInitOpening.py2A;

					myInitOpening.bX4A = myInitOpening.px3A;
					myInitOpening.bY4A = myInitOpening.py3A;

					myInitOpening.bCX4 = myInitOpening.px3c;
					myInitOpening.bCY4 = myInitOpening.py3c;
				} else {
					myInitOpening.bot1Part.endXC = myInitOpening.px1;
					myInitOpening.bot1Part.endYC = myInitOpening.py1;
					myInitOpening.bot1Part.endXBA = myInitOpening.px1;
					myInitOpening.bot1Part.endYBA = myInitOpening.py1;
					myInitOpening.bot1Part.endXA = myInitOpening.px1A;
					myInitOpening.bot1Part.endYA = myInitOpening.py1A;

					myInitOpening.bX3 = myInitOpening.px2;
					myInitOpening.bY3 = myInitOpening.py2;
					myInitOpening.bCX3 = myInitOpening.px2c;
					myInitOpening.bCY3 = myInitOpening.py2c;
					myInitOpening.bX4 = myInitOpening.px1;
					myInitOpening.bY4 = myInitOpening.py1;

					myInitOpening.bX3A = myInitOpening.px2A;
					myInitOpening.bY3A = myInitOpening.py2A;

					myInitOpening.bX4A = myInitOpening.px1A;
					myInitOpening.bY4A = myInitOpening.py1A;

					myInitOpening.bCX4 = myInitOpening.px1c;
					myInitOpening.bCY4 = myInitOpening.py1c;
				}

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidth = myInitOpening.leftPart.bkgrdHeight = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartX = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartY = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXC = myInitOpening.px3;
					myInitOpening.leftPart.startYC = myInitOpening.py3;
					myInitOpening.leftPart.endXC = myInitOpening.px1;
					myInitOpening.leftPart.endYC = myInitOpening.py1;

					myInitOpening.leftPart.bkgrdWidthBA = myInitOpening.leftPart.bkgrdHeightBA = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartXBA = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartYBA = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1BA
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2BA
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXBA = myInitOpening.px3;
					myInitOpening.leftPart.startYBA = myInitOpening.py3;
					myInitOpening.leftPart.endXBA = myInitOpening.px1;
					myInitOpening.leftPart.endYBA = myInitOpening.py1;

					myInitOpening.leftPart.bkgrdWidthA = myInitOpening.leftPart.bkgrdHeightA = myInitOpening.radius1A * 2;
					myInitOpening.leftPart.bkgrdStartXA = myInitOpening.bkgrdStartXA;
					myInitOpening.leftPart.bkgrdStartYA = myInitOpening.bkgrdStartYA;
					// myInitOpening.leftPart.radius1A
					// =
					// myInitOpening.radius1A;
					// myInitOpening.leftPart.radius2A
					// =
					// myInitOpening.radius2A;
					myInitOpening.leftPart.startXA = myInitOpening.px3A;
					myInitOpening.leftPart.startYA = myInitOpening.py3A;
					myInitOpening.leftPart.endXA = myInitOpening.px1A;
					myInitOpening.leftPart.endYA = myInitOpening.py1A;

				}
			}
			if (myInitOpening.noSidesTop == 2
					&& myInitOpening.noSidesRight == 1) {
				myInitOpening.bot1Part.bkgrdWidth = myInitOpening.bot1Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXC = myInitOpening.px4;
				myInitOpening.bot1Part.startYC = myInitOpening.py4;
				myInitOpening.bot1Part.endXC = myInitOpening.px5;
				myInitOpening.bot1Part.endYC = myInitOpening.py5;
				myInitOpening.bX3 = myInitOpening.px4;
				myInitOpening.bY3 = myInitOpening.py4;

				myInitOpening.bot1Part.bkgrdWidthBA = myInitOpening.bot1Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXBA = myInitOpening.px4;
				myInitOpening.bot1Part.startYBA = myInitOpening.py4;
				myInitOpening.bot1Part.endXBA = myInitOpening.px5;
				myInitOpening.bot1Part.endYBA = myInitOpening.py5;

				myInitOpening.bot1Part.bkgrdWidthA = myInitOpening.bot1Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot1Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot1Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot1Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot1Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot1Part.startXA = myInitOpening.px4A;
				myInitOpening.bot1Part.startYA = myInitOpening.py4A;
				myInitOpening.bot1Part.endXA = myInitOpening.px5A;
				myInitOpening.bot1Part.endYA = myInitOpening.py5A;
				myInitOpening.bX3A = myInitOpening.px4A;
				myInitOpening.bY3A = myInitOpening.py4A;

				myInitOpening.bCX3 = myInitOpening.px4c;
				myInitOpening.bCY3 = myInitOpening.py4c;
				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidth = myInitOpening.leftPart.bkgrdHeight = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartX = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartY = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXC = myInitOpening.px5;
					myInitOpening.leftPart.startYC = myInitOpening.py5;
					myInitOpening.leftPart.endXC = myInitOpening.px1;
					myInitOpening.leftPart.endYC = myInitOpening.py1;
					myInitOpening.bX4 = myInitOpening.px5;
					myInitOpening.bY4 = myInitOpening.py5;

					myInitOpening.leftPart.bkgrdWidthBA = myInitOpening.leftPart.bkgrdHeightBA = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartXBA = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartYBA = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1BA
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2BA
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXBA = myInitOpening.px5;
					myInitOpening.leftPart.startYBA = myInitOpening.py5;
					myInitOpening.leftPart.endXBA = myInitOpening.px1;
					myInitOpening.leftPart.endYBA = myInitOpening.py1;

					myInitOpening.leftPart.bkgrdWidthA = myInitOpening.leftPart.bkgrdHeightA = myInitOpening.radius1A * 2;
					myInitOpening.leftPart.bkgrdStartXA = myInitOpening.bkgrdStartXA;
					myInitOpening.leftPart.bkgrdStartYA = myInitOpening.bkgrdStartYA;
					// myInitOpening.leftPart.radius1A
					// =
					// myInitOpening.radius1A;
					// myInitOpening.leftPart.radius2A
					// =
					// myInitOpening.radius2A;
					myInitOpening.leftPart.startXA = myInitOpening.px5A;
					myInitOpening.leftPart.startYA = myInitOpening.py5A;
					myInitOpening.leftPart.endXA = myInitOpening.px1A;
					myInitOpening.leftPart.endYA = myInitOpening.py1A;
					myInitOpening.bX4A = myInitOpening.px5A;
					myInitOpening.bY4A = myInitOpening.py5A;

					myInitOpening.bCX4 = myInitOpening.px5c;
					myInitOpening.bCY4 = myInitOpening.py5c;
				}
			} else if (myInitOpening.noSidesTop == 2
					&& myInitOpening.noSidesRight == 0) {
				myInitOpening.bot1Part.bkgrdWidth = myInitOpening.bot1Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXC = myInitOpening.px3;
				myInitOpening.bot1Part.startYC = myInitOpening.py3;
				myInitOpening.bot1Part.endXC = myInitOpening.px4;
				myInitOpening.bot1Part.endYC = myInitOpening.py4;
				myInitOpening.bX3 = myInitOpening.px3;
				myInitOpening.bY3 = myInitOpening.py3;
				myInitOpening.bCX3 = myInitOpening.px3c;
				myInitOpening.bCY3 = myInitOpening.py3c;
				myInitOpening.bX4 = myInitOpening.px4;
				myInitOpening.bY4 = myInitOpening.py4;

				myInitOpening.bot1Part.bkgrdWidthBA = myInitOpening.bot1Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXBA = myInitOpening.px3;
				myInitOpening.bot1Part.startYBA = myInitOpening.py3;
				myInitOpening.bot1Part.endXBA = myInitOpening.px4;
				myInitOpening.bot1Part.endYBA = myInitOpening.py4;

				myInitOpening.bot1Part.bkgrdWidthA = myInitOpening.bot1Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot1Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot1Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot1Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot1Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot1Part.startXA = myInitOpening.px3A;
				myInitOpening.bot1Part.startYA = myInitOpening.py3A;
				myInitOpening.bot1Part.endXA = myInitOpening.px4A;
				myInitOpening.bot1Part.endYA = myInitOpening.py4A;
				myInitOpening.bX3A = myInitOpening.px3A;
				myInitOpening.bY3A = myInitOpening.py3A;

				myInitOpening.bX4A = myInitOpening.px4A;
				myInitOpening.bY4A = myInitOpening.py4A;

				myInitOpening.bCX4 = myInitOpening.px4c;
				myInitOpening.bCY4 = myInitOpening.py4c;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidth = myInitOpening.leftPart.bkgrdHeight = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartX = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartY = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXC = myInitOpening.px4;
					myInitOpening.leftPart.startYC = myInitOpening.py4;
					myInitOpening.leftPart.endXC = myInitOpening.px1;
					myInitOpening.leftPart.endYC = myInitOpening.py1;

					myInitOpening.leftPart.bkgrdWidthBA = myInitOpening.leftPart.bkgrdHeightBA = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartXBA = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartYBA = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1BA
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2BA
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXBA = myInitOpening.px4;
					myInitOpening.leftPart.startYBA = myInitOpening.py4;
					myInitOpening.leftPart.endXBA = myInitOpening.px1;
					myInitOpening.leftPart.endYBA = myInitOpening.py1;

					myInitOpening.leftPart.bkgrdWidthA = myInitOpening.leftPart.bkgrdHeightA = myInitOpening.radius1A * 2;
					myInitOpening.leftPart.bkgrdStartXA = myInitOpening.bkgrdStartXA;
					myInitOpening.leftPart.bkgrdStartYA = myInitOpening.bkgrdStartYA;
					// myInitOpening.leftPart.radius1A
					// =
					// myInitOpening.radius1A;
					// myInitOpening.leftPart.radius2A
					// =
					// myInitOpening.radius2A;
					myInitOpening.leftPart.startXA = myInitOpening.px4A;
					myInitOpening.leftPart.startYA = myInitOpening.py4A;
					myInitOpening.leftPart.endXA = myInitOpening.px1A;
					myInitOpening.leftPart.endYA = myInitOpening.py1A;
				}
			}
			if (myInitOpening.noSidesTop == 3
					&& myInitOpening.noSidesRight == 1) {
				myInitOpening.bot1Part.bkgrdWidth = myInitOpening.bot1Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXC = myInitOpening.px5;
				myInitOpening.bot1Part.startYC = myInitOpening.py5;
				myInitOpening.bot1Part.endXC = myInitOpening.px6;
				myInitOpening.bot1Part.endYC = myInitOpening.py6;
				myInitOpening.bX3 = myInitOpening.px5;
				myInitOpening.bY3 = myInitOpening.py5;
				myInitOpening.bCX3 = myInitOpening.px5c;
				myInitOpening.bCY3 = myInitOpening.py5c;
				myInitOpening.bX4 = myInitOpening.px6;
				myInitOpening.bY4 = myInitOpening.py6;
				myInitOpening.bCX4 = myInitOpening.px6c;
				myInitOpening.bCY4 = myInitOpening.py6c;

				myInitOpening.bot1Part.bkgrdWidthBA = myInitOpening.bot1Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXBA = myInitOpening.px5;
				myInitOpening.bot1Part.startYBA = myInitOpening.py5;
				myInitOpening.bot1Part.endXBA = myInitOpening.px6;
				myInitOpening.bot1Part.endYBA = myInitOpening.py6;

				myInitOpening.bot1Part.bkgrdWidthA = myInitOpening.bot1Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot1Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot1Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot1Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot1Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot1Part.startXA = myInitOpening.px5A;
				myInitOpening.bot1Part.startYA = myInitOpening.py5A;
				myInitOpening.bot1Part.endXA = myInitOpening.px6A;
				myInitOpening.bot1Part.endYA = myInitOpening.py6A;
				myInitOpening.bX3A = myInitOpening.px5A;
				myInitOpening.bY3A = myInitOpening.py5A;

				myInitOpening.bX4A = myInitOpening.px6A;
				myInitOpening.bY4A = myInitOpening.py6A;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidth = myInitOpening.leftPart.bkgrdHeight = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartX = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartY = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXC = myInitOpening.px6;
					myInitOpening.leftPart.startYC = myInitOpening.py6;
					myInitOpening.leftPart.endXC = myInitOpening.px1;
					myInitOpening.leftPart.endYC = myInitOpening.py1;

					myInitOpening.leftPart.bkgrdWidthBA = myInitOpening.leftPart.bkgrdHeightBA = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartXBA = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartYBA = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1BA
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2BA
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXBA = myInitOpening.px6;
					myInitOpening.leftPart.startYBA = myInitOpening.py6;
					myInitOpening.leftPart.endXBA = myInitOpening.px1;
					myInitOpening.leftPart.endYBA = myInitOpening.py1;

					myInitOpening.leftPart.bkgrdWidthA = myInitOpening.leftPart.bkgrdHeightA = myInitOpening.radius1A * 2;
					myInitOpening.leftPart.bkgrdStartXA = myInitOpening.bkgrdStartXA;
					myInitOpening.leftPart.bkgrdStartYA = myInitOpening.bkgrdStartYA;
					// myInitOpening.leftPart.radius1A
					// =
					// myInitOpening.radius1A;
					// myInitOpening.leftPart.radius2A
					// =
					// myInitOpening.radius2A;
					myInitOpening.leftPart.startXA = myInitOpening.px6A;
					myInitOpening.leftPart.startYA = myInitOpening.py6A;
					myInitOpening.leftPart.endXA = myInitOpening.px1A;
					myInitOpening.leftPart.endYA = myInitOpening.py1A;
				}
			} else if (myInitOpening.noSidesTop == 3
					&& myInitOpening.noSidesRight == 0) {
				myInitOpening.bot1Part.bkgrdWidth = myInitOpening.bot1Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXC = myInitOpening.px4;
				myInitOpening.bot1Part.startYC = myInitOpening.py4;
				myInitOpening.bot1Part.endXC = myInitOpening.px5;
				myInitOpening.bot1Part.endYC = myInitOpening.py5;
				myInitOpening.bX3 = myInitOpening.px4;
				myInitOpening.bY3 = myInitOpening.py4;
				myInitOpening.bCX3 = myInitOpening.px4c;
				myInitOpening.bCY3 = myInitOpening.py4c;
				myInitOpening.bX4 = myInitOpening.px5;
				myInitOpening.bY4 = myInitOpening.py5;
				myInitOpening.bCX4 = myInitOpening.px5c;
				myInitOpening.bCY4 = myInitOpening.py5c;

				myInitOpening.bot1Part.bkgrdWidthBA = myInitOpening.bot1Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXBA = myInitOpening.px4;
				myInitOpening.bot1Part.startYBA = myInitOpening.py4;
				myInitOpening.bot1Part.endXBA = myInitOpening.px5;
				myInitOpening.bot1Part.endYBA = myInitOpening.py5;

				myInitOpening.bot1Part.bkgrdWidthA = myInitOpening.bot1Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot1Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot1Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot1Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot1Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot1Part.startXA = myInitOpening.px4A;
				myInitOpening.bot1Part.startYA = myInitOpening.py4A;
				myInitOpening.bot1Part.endXA = myInitOpening.px5A;
				myInitOpening.bot1Part.endYA = myInitOpening.py5A;
				myInitOpening.bX3A = myInitOpening.px4A;
				myInitOpening.bY3A = myInitOpening.py4A;

				myInitOpening.bX4A = myInitOpening.px5A;
				myInitOpening.bY4A = myInitOpening.py5A;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidth = myInitOpening.leftPart.bkgrdHeight = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartX = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartY = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXC = myInitOpening.px5;
					myInitOpening.leftPart.startYC = myInitOpening.py5;
					myInitOpening.leftPart.endXC = myInitOpening.px1;
					myInitOpening.leftPart.endYC = myInitOpening.py1;

					myInitOpening.leftPart.bkgrdWidthBA = myInitOpening.leftPart.bkgrdHeightBA = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartXBA = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartYBA = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1BA
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2BA
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXBA = myInitOpening.px5;
					myInitOpening.leftPart.startYBA = myInitOpening.py5;
					myInitOpening.leftPart.endXBA = myInitOpening.px1;
					myInitOpening.leftPart.endYBA = myInitOpening.py1;

					myInitOpening.leftPart.bkgrdWidthA = myInitOpening.leftPart.bkgrdHeightA = myInitOpening.radius1A * 2;
					myInitOpening.leftPart.bkgrdStartXA = myInitOpening.bkgrdStartXA;
					myInitOpening.leftPart.bkgrdStartYA = myInitOpening.bkgrdStartYA;
					// myInitOpening.leftPart.radius1A
					// =
					// myInitOpening.radius1A;
					// myInitOpening.leftPart.radius2A
					// =
					// myInitOpening.radius2A;
					myInitOpening.leftPart.startXA = myInitOpening.px5A;
					myInitOpening.leftPart.startYA = myInitOpening.py5A;
					myInitOpening.leftPart.endXA = myInitOpening.px1A;
					myInitOpening.leftPart.endYA = myInitOpening.py1A;
				}
			}
		} else if (myInitOpening.noSidesBot == 2) {
			if (myInitOpening.noSidesTop == 1
					&& myInitOpening.noSidesRight == 1) {
				myInitOpening.bot1Part.bkgrdWidth = myInitOpening.bot1Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXC = myInitOpening.px3;
				myInitOpening.bot1Part.startYC = myInitOpening.py3;
				myInitOpening.bot1Part.endXC = myInitOpening.px4;
				myInitOpening.bot1Part.endYC = myInitOpening.py4;
				myInitOpening.bX3 = myInitOpening.px3;
				myInitOpening.bY3 = myInitOpening.py3;
				myInitOpening.bCX3 = myInitOpening.px3c;
				myInitOpening.bCY3 = myInitOpening.py3c;

				myInitOpening.bot2Part.bkgrdWidth = myInitOpening.bot2Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot2Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot2Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot2Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot2Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot2Part.startXC = myInitOpening.px4;
				myInitOpening.bot2Part.startYC = myInitOpening.py4;
				myInitOpening.bot2Part.endXC = myInitOpening.px5;
				myInitOpening.bot2Part.endYC = myInitOpening.py5;

				myInitOpening.bX4 = myInitOpening.px5;
				myInitOpening.bY4 = myInitOpening.py5;
				myInitOpening.bCX4 = myInitOpening.px5c;
				myInitOpening.bCY4 = myInitOpening.py5c;

				myInitOpening.bot1Part.bkgrdWidthBA = myInitOpening.bot1Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXBA = myInitOpening.px3;
				myInitOpening.bot1Part.startYBA = myInitOpening.py3;
				myInitOpening.bot1Part.endXBA = myInitOpening.px4;
				myInitOpening.bot1Part.endYBA = myInitOpening.py4;

				myInitOpening.bot2Part.bkgrdWidthBA = myInitOpening.bot2Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot2Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot2Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot2Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot2Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot2Part.startXBA = myInitOpening.px4;
				myInitOpening.bot2Part.startYBA = myInitOpening.py4;
				myInitOpening.bot2Part.endXBA = myInitOpening.px5;
				myInitOpening.bot2Part.endYBA = myInitOpening.py5;

				myInitOpening.bot1Part.bkgrdWidthA = myInitOpening.bot1Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot1Part.bkgrdStartX = myInitOpening.bkgrdStartXA;
				myInitOpening.bot1Part.bkgrdStartY = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot1Part.radius1
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot1Part.radius2
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot1Part.startXC = myInitOpening.px3A;
				myInitOpening.bot1Part.startYC = myInitOpening.py3A;
				myInitOpening.bot1Part.endXC = myInitOpening.px4A;
				myInitOpening.bot1Part.endYC = myInitOpening.py4A;
				myInitOpening.bX3 = myInitOpening.px3A;
				myInitOpening.bY3 = myInitOpening.py3A;

				myInitOpening.bot2Part.bkgrdWidthA = myInitOpening.bot2Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot2Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot2Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot2Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot2Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot2Part.startXA = myInitOpening.px4A;
				myInitOpening.bot2Part.startYA = myInitOpening.py4A;
				myInitOpening.bot2Part.endXA = myInitOpening.px5A;
				myInitOpening.bot2Part.endYA = myInitOpening.py5A;

				myInitOpening.bX4A = myInitOpening.px5A;
				myInitOpening.bY4A = myInitOpening.py5A;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidth = myInitOpening.leftPart.bkgrdHeight = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartX = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartY = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXC = myInitOpening.px5;
					myInitOpening.leftPart.startYC = myInitOpening.py5;
					myInitOpening.leftPart.endXC = myInitOpening.px1;
					myInitOpening.leftPart.endYC = myInitOpening.py1;

					myInitOpening.leftPart.bkgrdWidthBA = myInitOpening.leftPart.bkgrdHeightBA = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartXBA = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartYBA = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1BA
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2BA
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXBA = myInitOpening.px5;
					myInitOpening.leftPart.startYBA = myInitOpening.py5;
					myInitOpening.leftPart.endXBA = myInitOpening.px1;
					myInitOpening.leftPart.endYBA = myInitOpening.py1;

					myInitOpening.leftPart.bkgrdWidthA = myInitOpening.leftPart.bkgrdHeightA = myInitOpening.radius1A * 2;
					myInitOpening.leftPart.bkgrdStartXA = myInitOpening.bkgrdStartXA;
					myInitOpening.leftPart.bkgrdStartYA = myInitOpening.bkgrdStartYA;
					// myInitOpening.leftPart.radius1A
					// =
					// myInitOpening.radius1A;
					// myInitOpening.leftPart.radius2A
					// =
					// myInitOpening.radius2A;
					myInitOpening.leftPart.startXA = myInitOpening.px5A;
					myInitOpening.leftPart.startYA = myInitOpening.py5A;
					myInitOpening.leftPart.endXA = myInitOpening.px1A;
					myInitOpening.leftPart.endYA = myInitOpening.py1A;
				}

			} else if (myInitOpening.noSidesTop == 1
					&& myInitOpening.noSidesRight == 0) {
				myInitOpening.bot1Part.bkgrdWidth = myInitOpening.bot1Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXC = myInitOpening.px2;
				myInitOpening.bot1Part.startYC = myInitOpening.py2;
				myInitOpening.bot1Part.endXC = myInitOpening.px3;
				myInitOpening.bot1Part.endYC = myInitOpening.py3;
				myInitOpening.bX3 = myInitOpening.px2;
				myInitOpening.bY3 = myInitOpening.py2;
				myInitOpening.bCX3 = myInitOpening.px2c;
				myInitOpening.bCY3 = myInitOpening.py2c;

				myInitOpening.bot2Part.bkgrdWidth = myInitOpening.bot1Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot2Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot2Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot2Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot2Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot2Part.startXC = myInitOpening.px3;
				myInitOpening.bot2Part.startYC = myInitOpening.py3;
				myInitOpening.bot2Part.endXC = myInitOpening.px4;
				myInitOpening.bot2Part.endYC = myInitOpening.py4;
				myInitOpening.bX4 = myInitOpening.px4;
				myInitOpening.bY4 = myInitOpening.py4;
				myInitOpening.bCX4 = myInitOpening.px4c;
				myInitOpening.bCY4 = myInitOpening.py4c;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidth = myInitOpening.leftPart.bkgrdHeight = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartX = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartY = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXC = myInitOpening.px4;
					myInitOpening.leftPart.startYC = myInitOpening.py4;
					myInitOpening.leftPart.endXC = myInitOpening.px1;
					myInitOpening.leftPart.endYC = myInitOpening.py1;
				}

				myInitOpening.bot1Part.bkgrdWidthBA = myInitOpening.bot1Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXBA = myInitOpening.px2;
				myInitOpening.bot1Part.startYBA = myInitOpening.py2;
				myInitOpening.bot1Part.endXBA = myInitOpening.px3;
				myInitOpening.bot1Part.endYBA = myInitOpening.py3;

				myInitOpening.bot2Part.bkgrdWidthBA = myInitOpening.bot1Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot2Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot2Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot2Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot2Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot2Part.startXBA = myInitOpening.px3;
				myInitOpening.bot2Part.startYBA = myInitOpening.py3;
				myInitOpening.bot2Part.endXBA = myInitOpening.px4;
				myInitOpening.bot2Part.endYBA = myInitOpening.py4;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidthBA = myInitOpening.leftPart.bkgrdHeightBA = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartXBA = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartYBA = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1BA
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2BA
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXBA = myInitOpening.px4;
					myInitOpening.leftPart.startYBA = myInitOpening.py4;
					myInitOpening.leftPart.endXBA = myInitOpening.px1;
					myInitOpening.leftPart.endYBA = myInitOpening.py1;
				}

				myInitOpening.bot1Part.bkgrdWidthA = myInitOpening.bot1Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot1Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot1Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot1Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot1Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot1Part.startXA = myInitOpening.px2A;
				myInitOpening.bot1Part.startYA = myInitOpening.py2A;
				myInitOpening.bot1Part.endXA = myInitOpening.px3A;
				myInitOpening.bot1Part.endYA = myInitOpening.py3A;
				myInitOpening.bX3A = myInitOpening.px2A;
				myInitOpening.bY3A = myInitOpening.py2A;

				myInitOpening.bot2Part.bkgrdWidthA = myInitOpening.bot1Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot2Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot2Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot2Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot2Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot2Part.startXA = myInitOpening.px3A;
				myInitOpening.bot2Part.startYA = myInitOpening.py3A;
				myInitOpening.bot2Part.endXA = myInitOpening.px4A;
				myInitOpening.bot2Part.endYA = myInitOpening.py4A;
				myInitOpening.bX4A = myInitOpening.px4A;
				myInitOpening.bY4A = myInitOpening.py4A;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidthA = myInitOpening.leftPart.bkgrdHeightA = myInitOpening.radius1A * 2;
					myInitOpening.leftPart.bkgrdStartXA = myInitOpening.bkgrdStartXA;
					myInitOpening.leftPart.bkgrdStartYA = myInitOpening.bkgrdStartYA;
					// myInitOpening.leftPart.radius1A
					// =
					// myInitOpening.radius1A;
					// myInitOpening.leftPart.radius2A
					// =
					// myInitOpening.radius2A;
					myInitOpening.leftPart.startXA = myInitOpening.px4A;
					myInitOpening.leftPart.startYA = myInitOpening.py4A;
					myInitOpening.leftPart.endXA = myInitOpening.px1A;
					myInitOpening.leftPart.endYA = myInitOpening.py1A;
				}

			}
			if (myInitOpening.noSidesTop == 2
					&& myInitOpening.noSidesRight == 1) {
				myInitOpening.bot1Part.bkgrdWidth = myInitOpening.bot1Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXC = myInitOpening.px4;
				myInitOpening.bot1Part.startYC = myInitOpening.py4;
				myInitOpening.bot1Part.endXC = myInitOpening.px5;
				myInitOpening.bot1Part.endYC = myInitOpening.py5;
				myInitOpening.bX3 = myInitOpening.px4;
				myInitOpening.bY3 = myInitOpening.py4;
				myInitOpening.bCX3 = myInitOpening.px4c;
				myInitOpening.bCY3 = myInitOpening.py4c;

				myInitOpening.bot2Part.bkgrdWidth = myInitOpening.bot2Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot2Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot2Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot2Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot2Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot2Part.startXC = myInitOpening.px5;
				myInitOpening.bot2Part.startYC = myInitOpening.py5;
				myInitOpening.bot2Part.endXC = myInitOpening.px6;
				myInitOpening.bot2Part.endYC = myInitOpening.py6;
				myInitOpening.bX4 = myInitOpening.px6;
				myInitOpening.bY4 = myInitOpening.py6;
				myInitOpening.bCX4 = myInitOpening.px6c;
				myInitOpening.bCY4 = myInitOpening.py6c;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidth = myInitOpening.leftPart.bkgrdHeight = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartX = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartY = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXC = myInitOpening.px6;
					myInitOpening.leftPart.startYC = myInitOpening.py6;
					myInitOpening.leftPart.endXC = myInitOpening.px1;
					myInitOpening.leftPart.endYC = myInitOpening.py1;
				}

				myInitOpening.bot1Part.bkgrdWidthBA = myInitOpening.bot1Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXBA = myInitOpening.px4;
				myInitOpening.bot1Part.startYBA = myInitOpening.py4;
				myInitOpening.bot1Part.endXBA = myInitOpening.px5;
				myInitOpening.bot1Part.endYBA = myInitOpening.py5;

				myInitOpening.bot2Part.bkgrdWidthBA = myInitOpening.bot2Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot2Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot2Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot2Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot2Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot2Part.startXBA = myInitOpening.px5;
				myInitOpening.bot2Part.startYBA = myInitOpening.py5;
				myInitOpening.bot2Part.endXBA = myInitOpening.px6;
				myInitOpening.bot2Part.endYBA = myInitOpening.py6;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidthBA = myInitOpening.leftPart.bkgrdHeightBA = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartXBA = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartYBA = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1BA
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2BA
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXBA = myInitOpening.px6;
					myInitOpening.leftPart.startYBA = myInitOpening.py6;
					myInitOpening.leftPart.endXBA = myInitOpening.px1;
					myInitOpening.leftPart.endYBA = myInitOpening.py1;
				}

				myInitOpening.bot1Part.bkgrdWidthA = myInitOpening.bot1Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot1Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot1Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot1Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot1Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot1Part.startXA = myInitOpening.px4A;
				myInitOpening.bot1Part.startYA = myInitOpening.py4A;
				myInitOpening.bot1Part.endXA = myInitOpening.px5A;
				myInitOpening.bot1Part.endYA = myInitOpening.py5A;
				myInitOpening.bX3A = myInitOpening.px4A;
				myInitOpening.bY3A = myInitOpening.py4A;

				myInitOpening.bot2Part.bkgrdWidthA = myInitOpening.bot2Part.bkgrdHeightA = myInitOpening.radius1 * 2;
				myInitOpening.bot2Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot2Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot2Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot2Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot2Part.startXA = myInitOpening.px5A;
				myInitOpening.bot2Part.startYA = myInitOpening.py5A;
				myInitOpening.bot2Part.endXA = myInitOpening.px6A;
				myInitOpening.bot2Part.endYA = myInitOpening.py6A;
				myInitOpening.bX4A = myInitOpening.px6A;
				myInitOpening.bY4A = myInitOpening.py6A;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidthA = myInitOpening.leftPart.bkgrdHeightA = myInitOpening.radius1A * 2;
					myInitOpening.leftPart.bkgrdStartXA = myInitOpening.bkgrdStartXA;
					myInitOpening.leftPart.bkgrdStartYA = myInitOpening.bkgrdStartYA;
					// myInitOpening.leftPart.radius1A
					// =
					// myInitOpening.radius1A;
					// myInitOpening.leftPart.radius2A
					// =
					// myInitOpening.radius2A;
					myInitOpening.leftPart.startXA = myInitOpening.px6A;
					myInitOpening.leftPart.startYA = myInitOpening.py6A;
					myInitOpening.leftPart.endXA = myInitOpening.px1A;
					myInitOpening.leftPart.endYA = myInitOpening.py1A;
				}

			} else if (myInitOpening.noSidesTop == 2
					&& myInitOpening.noSidesRight == 0) {
				myInitOpening.bot1Part.bkgrdWidth = myInitOpening.bot1Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXC = myInitOpening.px2;
				myInitOpening.bot1Part.startYC = myInitOpening.py2;
				myInitOpening.bot1Part.endXC = myInitOpening.px3;
				myInitOpening.bot1Part.endYC = myInitOpening.py3;
				myInitOpening.bX3 = myInitOpening.px2;
				myInitOpening.bY3 = myInitOpening.py2;
				myInitOpening.bCX3 = myInitOpening.px2c;
				myInitOpening.bCY3 = myInitOpening.py2c;

				myInitOpening.bot2Part.bkgrdWidth = myInitOpening.bot2Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot2Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot2Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot2Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot2Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot2Part.startXC = myInitOpening.px3;
				myInitOpening.bot2Part.startYC = myInitOpening.py3;
				myInitOpening.bot2Part.endXC = myInitOpening.px4;
				myInitOpening.bot2Part.endYC = myInitOpening.py4;
				myInitOpening.bX4 = myInitOpening.px4;
				myInitOpening.bY4 = myInitOpening.py4;
				myInitOpening.bCX4 = myInitOpening.px4c;
				myInitOpening.bCY4 = myInitOpening.py4c;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidth = myInitOpening.leftPart.bkgrdHeight = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartX = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartY = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXC = myInitOpening.px4;
					myInitOpening.leftPart.startYC = myInitOpening.py4;
					myInitOpening.leftPart.endXC = myInitOpening.px1;
					myInitOpening.leftPart.endYC = myInitOpening.py1;
				}

				myInitOpening.bot1Part.bkgrdWidthA = myInitOpening.bot1Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot1Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot1Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot1Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot1Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot1Part.startXA = myInitOpening.px2A;
				myInitOpening.bot1Part.startYA = myInitOpening.py2A;
				myInitOpening.bot1Part.endXA = myInitOpening.px3A;
				myInitOpening.bot1Part.endYA = myInitOpening.py3A;
				myInitOpening.bX3A = myInitOpening.px2A;
				myInitOpening.bY3A = myInitOpening.py2A;

				myInitOpening.bot2Part.bkgrdWidthA = myInitOpening.bot2Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot2Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot2Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot2Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot2Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot2Part.startXA = myInitOpening.px3A;
				myInitOpening.bot2Part.startYA = myInitOpening.py3A;
				myInitOpening.bot2Part.endXA = myInitOpening.px4A;
				myInitOpening.bot2Part.endYA = myInitOpening.py4A;
				myInitOpening.bX4A = myInitOpening.px4A;
				myInitOpening.bY4A = myInitOpening.py4A;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidthA = myInitOpening.leftPart.bkgrdHeightA = myInitOpening.radius1A * 2;
					myInitOpening.leftPart.bkgrdStartXA = myInitOpening.bkgrdStartXA;
					myInitOpening.leftPart.bkgrdStartYA = myInitOpening.bkgrdStartYA;
					// myInitOpening.leftPart.radius1A
					// =
					// myInitOpening.radius1A;
					// myInitOpening.leftPart.radius2A
					// =
					// myInitOpening.radius2A;
					myInitOpening.leftPart.startXA = myInitOpening.px4A;
					myInitOpening.leftPart.startYA = myInitOpening.py4A;
					myInitOpening.leftPart.endXA = myInitOpening.px1A;
					myInitOpening.leftPart.endYA = myInitOpening.py1A;
				}

				myInitOpening.bot1Part.bkgrdWidthBA = myInitOpening.bot1Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXBA = myInitOpening.px2;
				myInitOpening.bot1Part.startYBA = myInitOpening.py2;
				myInitOpening.bot1Part.endXBA = myInitOpening.px3;
				myInitOpening.bot1Part.endYBA = myInitOpening.py3;

				myInitOpening.bot2Part.bkgrdWidthBA = myInitOpening.bot2Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot2Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot2Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot2Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot2Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot2Part.startXBA = myInitOpening.px3;
				myInitOpening.bot2Part.startYBA = myInitOpening.py3;
				myInitOpening.bot2Part.endXBA = myInitOpening.px4;
				myInitOpening.bot2Part.endYBA = myInitOpening.py4;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidthBA = myInitOpening.leftPart.bkgrdHeightBA = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartXBA = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartYBA = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1BA
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2BA
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXBA = myInitOpening.px4;
					myInitOpening.leftPart.startYBA = myInitOpening.py4;
					myInitOpening.leftPart.endXBA = myInitOpening.px1;
					myInitOpening.leftPart.endYBA = myInitOpening.py1;
				}

			}
			if (myInitOpening.noSidesTop == 3
					&& myInitOpening.noSidesRight == 1) {
				myInitOpening.bot3Part.bkgrdWidth = myInitOpening.bot3Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot3Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot3Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot3Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot3Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot3Part.startXC = myInitOpening.px5;
				myInitOpening.bot3Part.startYC = myInitOpening.py5;
				myInitOpening.bot3Part.endXC = myInitOpening.px6;
				myInitOpening.bot3Part.endYC = myInitOpening.py6;
				myInitOpening.bX3 = myInitOpening.px5;
				myInitOpening.bY3 = myInitOpening.py5;
				myInitOpening.bCX3 = myInitOpening.px5c;
				myInitOpening.bCY3 = myInitOpening.py5c;
				myInitOpening.bot1Part.bkgrdWidth = myInitOpening.bot1Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXC = myInitOpening.px6;
				myInitOpening.bot1Part.startYC = myInitOpening.py6;
				myInitOpening.bot1Part.endXC = myInitOpening.px7;
				myInitOpening.bot1Part.endYC = myInitOpening.py7;

				myInitOpening.bot2Part.bkgrdWidth = myInitOpening.bot2Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot2Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot2Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot2Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot2Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot2Part.startXC = myInitOpening.px7;
				myInitOpening.bot2Part.startYC = myInitOpening.py7;
				myInitOpening.bot2Part.endXC = myInitOpening.px8;
				myInitOpening.bot2Part.endYC = myInitOpening.py8;
				myInitOpening.bX4 = myInitOpening.px8;
				myInitOpening.bY4 = myInitOpening.py8;
				myInitOpening.bCX4 = myInitOpening.px8c;
				myInitOpening.bCY4 = myInitOpening.py8c;
				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidth = myInitOpening.leftPart.bkgrdHeight = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartX = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartY = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXC = myInitOpening.px8;
					myInitOpening.leftPart.startYC = myInitOpening.py8;
					myInitOpening.leftPart.endXC = myInitOpening.px1;
					myInitOpening.leftPart.endYC = myInitOpening.py1;
				}

				myInitOpening.bot3Part.bkgrdWidthBA = myInitOpening.bot3Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot3Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot3Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot3Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot3Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot3Part.startXBA = myInitOpening.px5;
				myInitOpening.bot3Part.startYBA = myInitOpening.py5;
				myInitOpening.bot3Part.endXBA = myInitOpening.px6;
				myInitOpening.bot3Part.endYBA = myInitOpening.py6;

				myInitOpening.bot1Part.bkgrdWidthBA = myInitOpening.bot1Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXBA = myInitOpening.px6;
				myInitOpening.bot1Part.startYBA = myInitOpening.py6;
				myInitOpening.bot1Part.endXBA = myInitOpening.px7;
				myInitOpening.bot1Part.endYBA = myInitOpening.py7;

				myInitOpening.bot2Part.bkgrdWidthBA = myInitOpening.bot2Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot2Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot2Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot2Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot2Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot2Part.startXBA = myInitOpening.px7;
				myInitOpening.bot2Part.startYBA = myInitOpening.py7;
				myInitOpening.bot2Part.endXBA = myInitOpening.px8;
				myInitOpening.bot2Part.endYBA = myInitOpening.py8;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidthBA = myInitOpening.leftPart.bkgrdHeightBA = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartXBA = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartYBA = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1BA
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2BA
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXBA = myInitOpening.px8;
					myInitOpening.leftPart.startYBA = myInitOpening.py8;
					myInitOpening.leftPart.endXBA = myInitOpening.px1;
					myInitOpening.leftPart.endYBA = myInitOpening.py1;
				}

				myInitOpening.bot3Part.bkgrdWidthA = myInitOpening.bot3Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot3Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot3Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot3Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot3Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot3Part.startXA = myInitOpening.px5A;
				myInitOpening.bot3Part.startYA = myInitOpening.py5A;
				myInitOpening.bot3Part.endXA = myInitOpening.px6A;
				myInitOpening.bot3Part.endYA = myInitOpening.py6A;
				myInitOpening.bX3A = myInitOpening.px5A;
				myInitOpening.bY3A = myInitOpening.py5A;

				myInitOpening.bot1Part.bkgrdWidthA = myInitOpening.bot1Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot1Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot1Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot1Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot1Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot1Part.startXA = myInitOpening.px6A;
				myInitOpening.bot1Part.startYA = myInitOpening.py6A;
				myInitOpening.bot1Part.endXA = myInitOpening.px7A;
				myInitOpening.bot1Part.endYA = myInitOpening.py7A;

				myInitOpening.bot2Part.bkgrdWidthA = myInitOpening.bot2Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot2Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot2Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot2Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot2Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot2Part.startXA = myInitOpening.px7A;
				myInitOpening.bot2Part.startYA = myInitOpening.py7A;
				myInitOpening.bot2Part.endXA = myInitOpening.px8A;
				myInitOpening.bot2Part.endYA = myInitOpening.py8A;
				myInitOpening.bX4A = myInitOpening.px8A;
				myInitOpening.bY4A = myInitOpening.py8A;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidthA = myInitOpening.leftPart.bkgrdHeightA = myInitOpening.radius1A * 2;
					myInitOpening.leftPart.bkgrdStartXA = myInitOpening.bkgrdStartXA;
					myInitOpening.leftPart.bkgrdStartYA = myInitOpening.bkgrdStartYA;
					// myInitOpening.leftPart.radius1A
					// =
					// myInitOpening.radius1A;
					// myInitOpening.leftPart.radius2A
					// =
					// myInitOpening.radius2A;
					myInitOpening.leftPart.startXA = myInitOpening.px8A;
					myInitOpening.leftPart.startYA = myInitOpening.py8A;
					myInitOpening.leftPart.endXA = myInitOpening.px1A;
					myInitOpening.leftPart.endYA = myInitOpening.py1A;
				}

			} else if (myInitOpening.noSidesTop == 3
					&& myInitOpening.noSidesRight == 0) {
				myInitOpening.bot3Part.bkgrdWidth = myInitOpening.bot3Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot3Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot3Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot3Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot3Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot3Part.startXC = myInitOpening.px4;
				myInitOpening.bot3Part.startYC = myInitOpening.py4;
				myInitOpening.bot3Part.endXC = myInitOpening.px5;
				myInitOpening.bot3Part.endYC = myInitOpening.py5;
				myInitOpening.bX3 = myInitOpening.px4;
				myInitOpening.bY3 = myInitOpening.py4;
				myInitOpening.bCX3 = myInitOpening.px4c;
				myInitOpening.bCY3 = myInitOpening.py4c;

				myInitOpening.bot1Part.bkgrdWidth = myInitOpening.bot1Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXC = myInitOpening.px5;
				myInitOpening.bot1Part.startYC = myInitOpening.py5;
				myInitOpening.bot1Part.endXC = myInitOpening.px6;
				myInitOpening.bot1Part.endYC = myInitOpening.py6;

				myInitOpening.bot2Part.bkgrdWidth = myInitOpening.bot2Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot2Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot2Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot2Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot2Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot2Part.startXC = myInitOpening.px6;
				myInitOpening.bot2Part.startYC = myInitOpening.py6;
				myInitOpening.bot2Part.endXC = myInitOpening.px7;
				myInitOpening.bot2Part.endYC = myInitOpening.py7;
				myInitOpening.bX4 = myInitOpening.px7;
				myInitOpening.bY4 = myInitOpening.py7;
				myInitOpening.bCX4 = myInitOpening.px7c;
				myInitOpening.bCY4 = myInitOpening.py7c;
				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidth = myInitOpening.leftPart.bkgrdHeight = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartX = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartY = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXC = myInitOpening.px7;
					myInitOpening.leftPart.startYC = myInitOpening.py7;
					myInitOpening.leftPart.endXC = myInitOpening.px1;
					myInitOpening.leftPart.endYC = myInitOpening.py1;
				}

				myInitOpening.bot3Part.bkgrdWidthBA = myInitOpening.bot3Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot3Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot3Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot3Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot3Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot3Part.startXBA = myInitOpening.px4;
				myInitOpening.bot3Part.startYBA = myInitOpening.py4;
				myInitOpening.bot3Part.endXBA = myInitOpening.px5;
				myInitOpening.bot3Part.endYBA = myInitOpening.py5;

				myInitOpening.bot1Part.bkgrdWidthBA = myInitOpening.bot1Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXBA = myInitOpening.px5;
				myInitOpening.bot1Part.startYBA = myInitOpening.py5;
				myInitOpening.bot1Part.endXBA = myInitOpening.px6;
				myInitOpening.bot1Part.endYBA = myInitOpening.py6;

				myInitOpening.bot2Part.bkgrdWidthBA = myInitOpening.bot2Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot2Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot2Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				myInitOpening.bot2Part.radius1BA = myInitOpening.radius1;
				myInitOpening.bot2Part.radius2BA = myInitOpening.radius2;
				myInitOpening.bot2Part.startXBA = myInitOpening.px6;
				myInitOpening.bot2Part.startYBA = myInitOpening.py6;
				myInitOpening.bot2Part.endXBA = myInitOpening.px7;
				myInitOpening.bot2Part.endYBA = myInitOpening.py7;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidthBA = myInitOpening.leftPart.bkgrdHeightBA = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartXBA = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartYBA = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1BA
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2BA
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXBA = myInitOpening.px7;
					myInitOpening.leftPart.startYBA = myInitOpening.py7;
					myInitOpening.leftPart.endXBA = myInitOpening.px1;
					myInitOpening.leftPart.endYBA = myInitOpening.py1;
				}

				myInitOpening.bot3Part.bkgrdWidthA = myInitOpening.bot3Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot3Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot3Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot3Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot3Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot3Part.startXA = myInitOpening.px4A;
				myInitOpening.bot3Part.startYA = myInitOpening.py4A;
				myInitOpening.bot3Part.endXA = myInitOpening.px5A;
				myInitOpening.bot3Part.endYA = myInitOpening.py5A;
				myInitOpening.bX3A = myInitOpening.px4A;
				myInitOpening.bY3A = myInitOpening.py4A;

				myInitOpening.bot1Part.bkgrdWidthA = myInitOpening.bot1Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot1Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot1Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot1Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot1Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot1Part.startXA = myInitOpening.px5A;
				myInitOpening.bot1Part.startYA = myInitOpening.py5A;
				myInitOpening.bot1Part.endXA = myInitOpening.px6A;
				myInitOpening.bot1Part.endYA = myInitOpening.py6A;

				myInitOpening.bot2Part.bkgrdWidthA = myInitOpening.bot2Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot2Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot2Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot2Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot2Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot2Part.startXA = myInitOpening.px6A;
				myInitOpening.bot2Part.startYA = myInitOpening.py6A;
				myInitOpening.bot2Part.endXA = myInitOpening.px7A;
				myInitOpening.bot2Part.endYA = myInitOpening.py7A;
				myInitOpening.bX4A = myInitOpening.px7A;
				myInitOpening.bY4A = myInitOpening.py7A;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidthA = myInitOpening.leftPart.bkgrdHeightA = myInitOpening.radius1A * 2;
					myInitOpening.leftPart.bkgrdStartXA = myInitOpening.bkgrdStartXA;
					myInitOpening.leftPart.bkgrdStartYA = myInitOpening.bkgrdStartYA;
					// myInitOpening.leftPart.radius1A
					// =
					// myInitOpening.radius1A;
					// myInitOpening.leftPart.radius2A
					// =
					// myInitOpening.radius2A;
					myInitOpening.leftPart.startXA = myInitOpening.px7A;
					myInitOpening.leftPart.startYA = myInitOpening.py7A;
					myInitOpening.leftPart.endXA = myInitOpening.px1A;
					myInitOpening.leftPart.endYA = myInitOpening.py1A;
				}

			}
		}

		// ////
		else if (myInitOpening.noSidesBot == 3) {
			if (myInitOpening.noSidesTop == 1
					&& myInitOpening.noSidesRight == 1) {
				myInitOpening.bot3Part.bkgrdWidth = myInitOpening.bot3Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot3Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot3Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot3Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot3Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot3Part.startXC = myInitOpening.px3;
				myInitOpening.bot3Part.startYC = myInitOpening.py3;
				myInitOpening.bot3Part.endXC = myInitOpening.px4;
				myInitOpening.bot3Part.endYC = myInitOpening.py4;
				myInitOpening.bX3 = myInitOpening.px3;
				myInitOpening.bY3 = myInitOpening.py3;
				myInitOpening.bCX3 = myInitOpening.px3c;
				myInitOpening.bCY3 = myInitOpening.py3c;

				myInitOpening.bot1Part.bkgrdWidth = myInitOpening.bot1Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXC = myInitOpening.px5;
				myInitOpening.bot1Part.startYC = myInitOpening.py5;
				myInitOpening.bot1Part.endXC = myInitOpening.px6;
				myInitOpening.bot1Part.endYC = myInitOpening.py6;

				myInitOpening.bot2Part.bkgrdWidth = myInitOpening.bot2Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot2Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot2Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot2Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot2Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot2Part.startXC = myInitOpening.px6;
				myInitOpening.bot2Part.startYC = myInitOpening.py6;
				myInitOpening.bot2Part.endXC = myInitOpening.px7;
				myInitOpening.bot2Part.endYC = myInitOpening.py7;
				myInitOpening.bX4 = myInitOpening.px7;
				myInitOpening.bY4 = myInitOpening.py7;
				myInitOpening.bCX4 = myInitOpening.px7c;
				myInitOpening.bCY4 = myInitOpening.py7c;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidth = myInitOpening.leftPart.bkgrdHeight = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartX = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartY = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXC = myInitOpening.px7;
					myInitOpening.leftPart.startYC = myInitOpening.py7;
					myInitOpening.leftPart.endXC = myInitOpening.px1;
					myInitOpening.leftPart.endYC = myInitOpening.py1;
				}

				myInitOpening.bot3Part.bkgrdWidthBA = myInitOpening.bot3Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot3Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot3Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot3Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot3Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot3Part.startXBA = myInitOpening.px3;
				myInitOpening.bot3Part.startYBA = myInitOpening.py3;
				myInitOpening.bot3Part.endXBA = myInitOpening.px4;
				myInitOpening.bot3Part.endYBA = myInitOpening.py4;

				myInitOpening.bot1Part.bkgrdWidthBA = myInitOpening.bot1Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXBA = myInitOpening.px5;
				myInitOpening.bot1Part.startYBA = myInitOpening.py5;
				myInitOpening.bot1Part.endXBA = myInitOpening.px6;
				myInitOpening.bot1Part.endYBA = myInitOpening.py6;

				myInitOpening.bot2Part.bkgrdWidthBA = myInitOpening.bot2Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot2Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot2Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot2Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot2Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot2Part.startXBA = myInitOpening.px6;
				myInitOpening.bot2Part.startYBA = myInitOpening.py6;
				myInitOpening.bot2Part.endXBA = myInitOpening.px7;
				myInitOpening.bot2Part.endYBA = myInitOpening.py7;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidthBA = myInitOpening.leftPart.bkgrdHeightBA = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartXBA = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartYBA = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1BA
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2BA
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXBA = myInitOpening.px7;
					myInitOpening.leftPart.startYBA = myInitOpening.py7;
					myInitOpening.leftPart.endXBA = myInitOpening.px1;
					myInitOpening.leftPart.endYBA = myInitOpening.py1;
				}

				myInitOpening.bot3Part.bkgrdWidthA = myInitOpening.bot3Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot3Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot3Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot3Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot3Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot3Part.startXA = myInitOpening.px3A;
				myInitOpening.bot3Part.startYA = myInitOpening.py3A;
				myInitOpening.bot3Part.endXA = myInitOpening.px4A;
				myInitOpening.bot3Part.endYA = myInitOpening.py4A;
				myInitOpening.bX3A = myInitOpening.px3A;
				myInitOpening.bY3A = myInitOpening.py3A;

				myInitOpening.bot1Part.bkgrdWidthA = myInitOpening.bot1Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot1Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot1Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot1Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot1Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot1Part.startXA = myInitOpening.px5A;
				myInitOpening.bot1Part.startYA = myInitOpening.py5A;
				myInitOpening.bot1Part.endXA = myInitOpening.px6A;
				myInitOpening.bot1Part.endYA = myInitOpening.py6A;

				myInitOpening.bot2Part.bkgrdWidthA = myInitOpening.bot2Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot2Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot2Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot2Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot2Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot2Part.startXA = myInitOpening.px6A;
				myInitOpening.bot2Part.startYA = myInitOpening.py6A;
				myInitOpening.bot2Part.endXA = myInitOpening.px7A;
				myInitOpening.bot2Part.endYA = myInitOpening.py7A;
				myInitOpening.bX4A = myInitOpening.px7A;
				myInitOpening.bY4A = myInitOpening.py7A;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidthA = myInitOpening.leftPart.bkgrdHeightA = myInitOpening.radius1A * 2;
					myInitOpening.leftPart.bkgrdStartXA = myInitOpening.bkgrdStartXA;
					myInitOpening.leftPart.bkgrdStartYA = myInitOpening.bkgrdStartYA;
					// myInitOpening.leftPart.radius1A
					// =
					// myInitOpening.radius1A;
					// myInitOpening.leftPart.radius2A
					// =
					// myInitOpening.radius2A;
					myInitOpening.leftPart.startXA = myInitOpening.px7A;
					myInitOpening.leftPart.startYA = myInitOpening.py7A;
					myInitOpening.leftPart.endXA = myInitOpening.px1A;
					myInitOpening.leftPart.endYA = myInitOpening.py1A;
				}

			} else if (myInitOpening.noSidesTop == 1
					&& myInitOpening.noSidesRight == 0) {
				myInitOpening.bot3Part.bkgrdWidth = myInitOpening.bot3Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot3Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot3Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot3Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot3Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot3Part.startXC = myInitOpening.px2;
				myInitOpening.bot3Part.startYC = myInitOpening.py2;
				myInitOpening.bot3Part.endXC = myInitOpening.px3;
				myInitOpening.bot3Part.endYC = myInitOpening.py3;

				myInitOpening.bX3 = myInitOpening.px2;
				myInitOpening.bY3 = myInitOpening.py2;
				myInitOpening.bCX3 = myInitOpening.px2c;
				myInitOpening.bCY3 = myInitOpening.py2c;

				myInitOpening.bot1Part.bkgrdWidth = myInitOpening.bot1Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXC = myInitOpening.px3;
				myInitOpening.bot1Part.startYC = myInitOpening.py3;
				myInitOpening.bot1Part.endXC = myInitOpening.px4;
				myInitOpening.bot1Part.endYC = myInitOpening.py4;

				myInitOpening.bot2Part.bkgrdWidth = myInitOpening.bot2Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot2Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot2Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot2Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot2Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot2Part.startXC = myInitOpening.px3;
				myInitOpening.bot2Part.startYC = myInitOpening.py3;
				myInitOpening.bot2Part.endXC = myInitOpening.px4;
				myInitOpening.bot2Part.endYC = myInitOpening.py4;

				myInitOpening.bX4 = myInitOpening.px4;
				myInitOpening.bY4 = myInitOpening.py4;
				myInitOpening.bCX4 = myInitOpening.px4c;
				myInitOpening.bCY4 = myInitOpening.py4c;
				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidth = myInitOpening.leftPart.bkgrdHeight = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartX = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartY = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXC = myInitOpening.px4;
					myInitOpening.leftPart.startYC = myInitOpening.py4;
					myInitOpening.leftPart.endXC = myInitOpening.px1;
					myInitOpening.leftPart.endYC = myInitOpening.py1;
				}

				myInitOpening.bot3Part.bkgrdWidthBA = myInitOpening.bot3Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot3Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot3Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot3Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot3Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot3Part.startXBA = myInitOpening.px2;
				myInitOpening.bot3Part.startYBA = myInitOpening.py2;
				myInitOpening.bot3Part.endXBA = myInitOpening.px3;
				myInitOpening.bot3Part.endYBA = myInitOpening.py3;

				myInitOpening.bot1Part.bkgrdWidthBA = myInitOpening.bot1Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXBA = myInitOpening.px3;
				myInitOpening.bot1Part.startYBA = myInitOpening.py3;
				myInitOpening.bot1Part.endXBA = myInitOpening.px4;
				myInitOpening.bot1Part.endYBA = myInitOpening.py4;

				myInitOpening.bot2Part.bkgrdWidthBA = myInitOpening.bot2Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot2Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot2Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot2Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot2Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot2Part.startXBA = myInitOpening.px3;
				myInitOpening.bot2Part.startYBA = myInitOpening.py3;
				myInitOpening.bot2Part.endXBA = myInitOpening.px4;
				myInitOpening.bot2Part.endYBA = myInitOpening.py4;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidthBA = myInitOpening.leftPart.bkgrdHeightBA = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartXBA = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartYBA = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1BA
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2BA
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXBA = myInitOpening.px4;
					myInitOpening.leftPart.startYBA = myInitOpening.py4;
					myInitOpening.leftPart.endXBA = myInitOpening.px1;
					myInitOpening.leftPart.endYBA = myInitOpening.py1;
				}

				myInitOpening.bot3Part.bkgrdWidthA = myInitOpening.bot3Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot3Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot3Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot3Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot3Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot3Part.startXA = myInitOpening.px2A;
				myInitOpening.bot3Part.startYA = myInitOpening.py2A;
				myInitOpening.bot3Part.endXA = myInitOpening.px3A;
				myInitOpening.bot3Part.endYA = myInitOpening.py3A;

				myInitOpening.bX3A = myInitOpening.px2A;
				myInitOpening.bY3A = myInitOpening.py2A;

				myInitOpening.bot1Part.bkgrdWidthA = myInitOpening.bot1Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot1Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot1Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot1Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot1Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot1Part.startXA = myInitOpening.px3A;
				myInitOpening.bot1Part.startYA = myInitOpening.py3A;
				myInitOpening.bot1Part.endXA = myInitOpening.px4A;
				myInitOpening.bot1Part.endYA = myInitOpening.py4A;

				myInitOpening.bot2Part.bkgrdWidthA = myInitOpening.bot2Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot2Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot2Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot2Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot2Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot2Part.startXA = myInitOpening.px3A;
				myInitOpening.bot2Part.startYA = myInitOpening.py3A;
				myInitOpening.bot2Part.endXA = myInitOpening.px4A;
				myInitOpening.bot2Part.endYA = myInitOpening.py4A;

				myInitOpening.bX4A = myInitOpening.px4A;
				myInitOpening.bY4A = myInitOpening.py4A;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidthA = myInitOpening.leftPart.bkgrdHeightA = myInitOpening.radius1A * 2;
					myInitOpening.leftPart.bkgrdStartXA = myInitOpening.bkgrdStartXA;
					myInitOpening.leftPart.bkgrdStartYA = myInitOpening.bkgrdStartYA;
					// myInitOpening.leftPart.radius1A
					// =
					// myInitOpening.radius1A;
					// myInitOpening.leftPart.radius2A
					// =
					// myInitOpening.radius2A;
					myInitOpening.leftPart.startXA = myInitOpening.px4A;
					myInitOpening.leftPart.startYA = myInitOpening.py4A;
					myInitOpening.leftPart.endXA = myInitOpening.px1A;
					myInitOpening.leftPart.endYA = myInitOpening.py1A;

				}
			}
			if (myInitOpening.noSidesTop == 2
					&& myInitOpening.noSidesRight == 1) {
				myInitOpening.bot3Part.bkgrdWidth = myInitOpening.bot3Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot3Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot3Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot3Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot3Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot3Part.startXC = myInitOpening.px4;
				myInitOpening.bot3Part.startYC = myInitOpening.py4;
				myInitOpening.bot3Part.endXC = myInitOpening.px5;
				myInitOpening.bot3Part.endYC = myInitOpening.py5;

				myInitOpening.bX3 = myInitOpening.px4;
				myInitOpening.bY3 = myInitOpening.py4;
				myInitOpening.bCX3 = myInitOpening.px4c;
				myInitOpening.bCY3 = myInitOpening.py4c;

				myInitOpening.bot1Part.bkgrdWidth = myInitOpening.bot1Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXC = myInitOpening.px5;
				myInitOpening.bot1Part.startYC = myInitOpening.py5;
				myInitOpening.bot1Part.endXC = myInitOpening.px6;
				myInitOpening.bot1Part.endYC = myInitOpening.py6;

				myInitOpening.bot2Part.bkgrdWidth = myInitOpening.bot2Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot2Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot2Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot2Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot2Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot2Part.startXC = myInitOpening.px6;
				myInitOpening.bot2Part.startYC = myInitOpening.py6;
				myInitOpening.bot2Part.endXC = myInitOpening.px7;
				myInitOpening.bot2Part.endYC = myInitOpening.py7;
				myInitOpening.bX4 = myInitOpening.px7;
				myInitOpening.bY4 = myInitOpening.py7;
				myInitOpening.bCX4 = myInitOpening.px7c;
				myInitOpening.bCY4 = myInitOpening.py7c;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidth = myInitOpening.leftPart.bkgrdHeight = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartX = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartY = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXC = myInitOpening.px7;
					myInitOpening.leftPart.startYC = myInitOpening.py7;
					myInitOpening.leftPart.endXC = myInitOpening.px1;
					myInitOpening.leftPart.endYC = myInitOpening.py1;
				}
				// //
				myInitOpening.bot3Part.bkgrdWidthBA = myInitOpening.bot3Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot3Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot3Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot3Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot3Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot3Part.startXBA = myInitOpening.px4;
				myInitOpening.bot3Part.startYBA = myInitOpening.py4;
				myInitOpening.bot3Part.endXBA = myInitOpening.px5;
				myInitOpening.bot3Part.endYBA = myInitOpening.py5;

				myInitOpening.bot1Part.bkgrdWidthBA = myInitOpening.bot1Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXBA = myInitOpening.px5;
				myInitOpening.bot1Part.startYBA = myInitOpening.py5;
				myInitOpening.bot1Part.endXBA = myInitOpening.px6;
				myInitOpening.bot1Part.endYBA = myInitOpening.py6;

				myInitOpening.bot2Part.bkgrdWidthBA = myInitOpening.bot2Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot2Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot2Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot2Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot2Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot2Part.startXBA = myInitOpening.px6;
				myInitOpening.bot2Part.startYBA = myInitOpening.py6;
				myInitOpening.bot2Part.endXBA = myInitOpening.px7;
				myInitOpening.bot2Part.endYBA = myInitOpening.py7;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidthBA = myInitOpening.leftPart.bkgrdHeightBA = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartXBA = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartYBA = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1BA
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2BA
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXBA = myInitOpening.px7;
					myInitOpening.leftPart.startYBA = myInitOpening.py7;
					myInitOpening.leftPart.endXBA = myInitOpening.px1;
					myInitOpening.leftPart.endYBA = myInitOpening.py1;
				}
				// /
				myInitOpening.bot3Part.bkgrdWidthA = myInitOpening.bot3Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot3Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot3Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot3Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot3Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot3Part.startXA = myInitOpening.px4A;
				myInitOpening.bot3Part.startYA = myInitOpening.py4A;
				myInitOpening.bot3Part.endXA = myInitOpening.px5A;
				myInitOpening.bot3Part.endYA = myInitOpening.py5A;

				myInitOpening.bX3A = myInitOpening.px4A;
				myInitOpening.bY3A = myInitOpening.py4A;

				myInitOpening.bot1Part.bkgrdWidthA = myInitOpening.bot1Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot1Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot1Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot1Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot1Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot1Part.startXA = myInitOpening.px5A;
				myInitOpening.bot1Part.startYA = myInitOpening.py5A;
				myInitOpening.bot1Part.endXA = myInitOpening.px6A;
				myInitOpening.bot1Part.endYA = myInitOpening.py6A;

				myInitOpening.bot2Part.bkgrdWidthA = myInitOpening.bot2Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot2Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot2Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot2Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot2Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot2Part.startXA = myInitOpening.px6A;
				myInitOpening.bot2Part.startYA = myInitOpening.py6A;
				myInitOpening.bot2Part.endXA = myInitOpening.px7A;
				myInitOpening.bot2Part.endYA = myInitOpening.py7A;
				myInitOpening.bX4A = myInitOpening.px7A;
				myInitOpening.bY4A = myInitOpening.py7A;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidthA = myInitOpening.leftPart.bkgrdHeightA = myInitOpening.radius1A * 2;
					myInitOpening.leftPart.bkgrdStartXA = myInitOpening.bkgrdStartXA;
					myInitOpening.leftPart.bkgrdStartYA = myInitOpening.bkgrdStartYA;
					// myInitOpening.leftPart.radius1A
					// =
					// myInitOpening.radius1A;
					// myInitOpening.leftPart.radius2A
					// =
					// myInitOpening.radius2A;
					myInitOpening.leftPart.startXA = myInitOpening.px7A;
					myInitOpening.leftPart.startYA = myInitOpening.py7A;
					myInitOpening.leftPart.endXA = myInitOpening.px1A;
					myInitOpening.leftPart.endYA = myInitOpening.py1A;
				}
				// /

			} else if (myInitOpening.noSidesTop == 2
					&& myInitOpening.noSidesRight == 0) {
				myInitOpening.bot3Part.bkgrdWidth = myInitOpening.bot3Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot3Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot3Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot3Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot3Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot3Part.startXC = myInitOpening.px3;
				myInitOpening.bot3Part.startYC = myInitOpening.py3;
				myInitOpening.bot3Part.endXC = myInitOpening.px4;
				myInitOpening.bot3Part.endYC = myInitOpening.py4;
				myInitOpening.bX3 = myInitOpening.px3;
				myInitOpening.bY3 = myInitOpening.py3;
				myInitOpening.bCX3 = myInitOpening.px3c;
				myInitOpening.bCY3 = myInitOpening.py3c;

				myInitOpening.bot1Part.bkgrdWidth = myInitOpening.bot1Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXC = myInitOpening.px4;
				myInitOpening.bot1Part.startYC = myInitOpening.py4;
				myInitOpening.bot1Part.endXC = myInitOpening.px5;
				myInitOpening.bot1Part.endYC = myInitOpening.py5;

				myInitOpening.bot2Part.bkgrdWidth = myInitOpening.bot2Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot2Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot2Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot2Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot2Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot2Part.startXC = myInitOpening.px5;
				myInitOpening.bot2Part.startYC = myInitOpening.py5;
				myInitOpening.bot2Part.endXC = myInitOpening.px6;
				myInitOpening.bot2Part.endYC = myInitOpening.py6;

				myInitOpening.bX4 = myInitOpening.px6;
				myInitOpening.bY4 = myInitOpening.py6;
				myInitOpening.bCX4 = myInitOpening.px6c;
				myInitOpening.bCY4 = myInitOpening.py6c;
				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidth = myInitOpening.leftPart.bkgrdHeight = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartX = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartY = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXC = myInitOpening.px6;
					myInitOpening.leftPart.startYC = myInitOpening.py6;
					myInitOpening.leftPart.endXC = myInitOpening.px1;
					myInitOpening.leftPart.endYC = myInitOpening.py1;
				}

				myInitOpening.bot3Part.bkgrdWidthBA = myInitOpening.bot3Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot3Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot3Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot3Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot3Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot3Part.startXBA = myInitOpening.px3;
				myInitOpening.bot3Part.startYBA = myInitOpening.py3;
				myInitOpening.bot3Part.endXBA = myInitOpening.px4;
				myInitOpening.bot3Part.endYBA = myInitOpening.py4;

				myInitOpening.bot1Part.bkgrdWidthBA = myInitOpening.bot1Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXBA = myInitOpening.px4;
				myInitOpening.bot1Part.startYBA = myInitOpening.py4;
				myInitOpening.bot1Part.endXBA = myInitOpening.px5;
				myInitOpening.bot1Part.endYBA = myInitOpening.py5;

				myInitOpening.bot2Part.bkgrdWidthBA = myInitOpening.bot2Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot2Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot2Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot2Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot2Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot2Part.startXBA = myInitOpening.px5;
				myInitOpening.bot2Part.startYBA = myInitOpening.py5;
				myInitOpening.bot2Part.endXBA = myInitOpening.px6;
				myInitOpening.bot2Part.endYBA = myInitOpening.py6;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidthBA = myInitOpening.leftPart.bkgrdHeightBA = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartXBA = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartYBA = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1BA
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2BA
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXBA = myInitOpening.px6;
					myInitOpening.leftPart.startYBA = myInitOpening.py6;
					myInitOpening.leftPart.endXBA = myInitOpening.px1;
					myInitOpening.leftPart.endYBA = myInitOpening.py1;
				}

				myInitOpening.bot3Part.bkgrdWidthA = myInitOpening.bot3Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot3Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot3Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot3Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot3Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot3Part.startXA = myInitOpening.px3A;
				myInitOpening.bot3Part.startYA = myInitOpening.py3A;
				myInitOpening.bot3Part.endXA = myInitOpening.px4A;
				myInitOpening.bot3Part.endYA = myInitOpening.py4A;
				myInitOpening.bX3A = myInitOpening.px3A;
				myInitOpening.bY3A = myInitOpening.py3A;

				myInitOpening.bot1Part.bkgrdWidthA = myInitOpening.bot1Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot1Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot1Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot1Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot1Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot1Part.startXA = myInitOpening.px4A;
				myInitOpening.bot1Part.startYA = myInitOpening.py4A;
				myInitOpening.bot1Part.endXA = myInitOpening.px5A;
				myInitOpening.bot1Part.endYA = myInitOpening.py5A;

				myInitOpening.bot2Part.bkgrdWidthA = myInitOpening.bot2Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot2Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot2Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot2Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot2Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot2Part.startXA = myInitOpening.px5A;
				myInitOpening.bot2Part.startYA = myInitOpening.py5A;
				myInitOpening.bot2Part.endXA = myInitOpening.px6A;
				myInitOpening.bot2Part.endYA = myInitOpening.py6A;

				myInitOpening.bX4A = myInitOpening.px6A;
				myInitOpening.bY4A = myInitOpening.py6A;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidthA = myInitOpening.leftPart.bkgrdHeightA = myInitOpening.radius1A * 2;
					myInitOpening.leftPart.bkgrdStartXA = myInitOpening.bkgrdStartXA;
					myInitOpening.leftPart.bkgrdStartYA = myInitOpening.bkgrdStartYA;
					// myInitOpening.leftPart.radius1A
					// =
					// myInitOpening.radius1A;
					// myInitOpening.leftPart.radius2A
					// =
					// myInitOpening.radius2A;
					myInitOpening.leftPart.startXA = myInitOpening.px6A;
					myInitOpening.leftPart.startYA = myInitOpening.py6A;
					myInitOpening.leftPart.endXA = myInitOpening.px1A;
					myInitOpening.leftPart.endYA = myInitOpening.py1A;
				}

			}
			if (myInitOpening.noSidesTop == 3
					&& myInitOpening.noSidesRight == 1) {
				myInitOpening.bot3Part.bkgrdWidth = myInitOpening.bot3Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot3Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot3Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot3Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot3Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot3Part.startXC = myInitOpening.px5;
				myInitOpening.bot3Part.startYC = myInitOpening.py5;
				myInitOpening.bot3Part.endXC = myInitOpening.px6;
				myInitOpening.bot3Part.endYC = myInitOpening.py6;
				myInitOpening.bX3 = myInitOpening.px5;
				myInitOpening.bY3 = myInitOpening.py5;
				myInitOpening.bCX3 = myInitOpening.px5c;
				myInitOpening.bCY3 = myInitOpening.py5c;

				myInitOpening.bot1Part.bkgrdWidth = myInitOpening.bot1Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXC = myInitOpening.px6;
				myInitOpening.bot1Part.startYC = myInitOpening.py6;
				myInitOpening.bot1Part.endXC = myInitOpening.px7;
				myInitOpening.bot1Part.endYC = myInitOpening.py7;

				myInitOpening.bot2Part.bkgrdWidth = myInitOpening.bot2Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot2Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot2Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot2Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot2Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot2Part.startXC = myInitOpening.px7;
				myInitOpening.bot2Part.startYC = myInitOpening.py7;
				myInitOpening.bot2Part.endXC = myInitOpening.px8;
				myInitOpening.bot2Part.endYC = myInitOpening.py8;
				myInitOpening.bX4 = myInitOpening.px8;
				myInitOpening.bY4 = myInitOpening.py8;
				myInitOpening.bCX4 = myInitOpening.px8c;
				myInitOpening.bCY4 = myInitOpening.py8c;
				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidth = myInitOpening.leftPart.bkgrdHeight = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartX = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartY = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXC = myInitOpening.px8;
					myInitOpening.leftPart.startYC = myInitOpening.py8;
					myInitOpening.leftPart.endXC = myInitOpening.px1;
					myInitOpening.leftPart.endYC = myInitOpening.py1;
				}

				// ////

				myInitOpening.bot3Part.bkgrdWidthBA = myInitOpening.bot3Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot3Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot3Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot3Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot3Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot3Part.startXBA = myInitOpening.px5;
				myInitOpening.bot3Part.startYBA = myInitOpening.py5;
				myInitOpening.bot3Part.endXBA = myInitOpening.px6;
				myInitOpening.bot3Part.endYBA = myInitOpening.py6;

				myInitOpening.bot1Part.bkgrdWidthBA = myInitOpening.bot1Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXBA = myInitOpening.px6;
				myInitOpening.bot1Part.startYBA = myInitOpening.py6;
				myInitOpening.bot1Part.endXBA = myInitOpening.px7;
				myInitOpening.bot1Part.endYBA = myInitOpening.py7;

				myInitOpening.bot2Part.bkgrdWidthBA = myInitOpening.bot2Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot2Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot2Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot2Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot2Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot2Part.startXBA = myInitOpening.px7;
				myInitOpening.bot2Part.startYBA = myInitOpening.py7;
				myInitOpening.bot2Part.endXBA = myInitOpening.px8;
				myInitOpening.bot2Part.endYBA = myInitOpening.py8;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidthBA = myInitOpening.leftPart.bkgrdHeightBA = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartXBA = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartYBA = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1BA
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2BA
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXBA = myInitOpening.px8;
					myInitOpening.leftPart.startYBA = myInitOpening.py8;
					myInitOpening.leftPart.endXBA = myInitOpening.px1;
					myInitOpening.leftPart.endYBA = myInitOpening.py1;
				}

				// //

				myInitOpening.bot3Part.bkgrdWidthA = myInitOpening.bot3Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot3Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot3Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot3Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot3Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot3Part.startXA = myInitOpening.px5A;
				myInitOpening.bot3Part.startYA = myInitOpening.py5A;
				myInitOpening.bot3Part.endXA = myInitOpening.px6A;
				myInitOpening.bot3Part.endYA = myInitOpening.py6A;
				myInitOpening.bX3A = myInitOpening.px5A;
				myInitOpening.bY3A = myInitOpening.py5A;

				myInitOpening.bot1Part.bkgrdWidthA = myInitOpening.bot1Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot1Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot1Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot1Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot1Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot1Part.startXA = myInitOpening.px6A;
				myInitOpening.bot1Part.startYA = myInitOpening.py6A;
				myInitOpening.bot1Part.endXA = myInitOpening.px7A;
				myInitOpening.bot1Part.endYA = myInitOpening.py7A;

				myInitOpening.bot2Part.bkgrdWidthA = myInitOpening.bot2Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot2Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot2Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot2Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot2Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot2Part.startXA = myInitOpening.px7A;
				myInitOpening.bot2Part.startYA = myInitOpening.py7A;
				myInitOpening.bot2Part.endXA = myInitOpening.px8A;
				myInitOpening.bot2Part.endYA = myInitOpening.py8A;
				myInitOpening.bX4A = myInitOpening.px8A;
				myInitOpening.bY4A = myInitOpening.py8A;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidthA = myInitOpening.leftPart.bkgrdHeightA = myInitOpening.radius1A * 2;
					myInitOpening.leftPart.bkgrdStartXA = myInitOpening.bkgrdStartXA;
					myInitOpening.leftPart.bkgrdStartYA = myInitOpening.bkgrdStartYA;
					// myInitOpening.leftPart.radius1A
					// =
					// myInitOpening.radius1A;
					// myInitOpening.leftPart.radius2A
					// =
					// myInitOpening.radius2A;
					myInitOpening.leftPart.startXA = myInitOpening.px8A;
					myInitOpening.leftPart.startYA = myInitOpening.py8A;
					myInitOpening.leftPart.endXA = myInitOpening.px1A;
					myInitOpening.leftPart.endYA = myInitOpening.py1A;
				}

			} else if (myInitOpening.noSidesTop == 3
					&& myInitOpening.noSidesRight == 0) {
				myInitOpening.bot3Part.bkgrdWidth = myInitOpening.bot3Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot3Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot3Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot3Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot3Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot3Part.startXC = myInitOpening.px4;
				myInitOpening.bot3Part.startYC = myInitOpening.py4;
				myInitOpening.bot3Part.endXC = myInitOpening.px5;
				myInitOpening.bot3Part.endYC = myInitOpening.py5;
				myInitOpening.bX3 = myInitOpening.px4;
				myInitOpening.bY3 = myInitOpening.py4;
				myInitOpening.bCX3 = myInitOpening.px4c;
				myInitOpening.bCY3 = myInitOpening.py4c;

				myInitOpening.bot1Part.bkgrdWidth = myInitOpening.bot1Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXC = myInitOpening.px5;
				myInitOpening.bot1Part.startYC = myInitOpening.py5;
				myInitOpening.bot1Part.endXC = myInitOpening.px6;
				myInitOpening.bot1Part.endYC = myInitOpening.py6;

				myInitOpening.bot2Part.bkgrdWidth = myInitOpening.bot2Part.bkgrdHeight = myInitOpening.radius1 * 2;
				myInitOpening.bot2Part.bkgrdStartX = myInitOpening.bkgrdStartX;
				myInitOpening.bot2Part.bkgrdStartY = myInitOpening.bkgrdStartY;
				// myInitOpening.bot2Part.radius1
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot2Part.radius2
				// =
				// myInitOpening.radius2;
				myInitOpening.bot2Part.startXC = myInitOpening.px6;
				myInitOpening.bot2Part.startYC = myInitOpening.py6;
				myInitOpening.bot2Part.endXC = myInitOpening.px7;
				myInitOpening.bot2Part.endYC = myInitOpening.py7;
				myInitOpening.bX4 = myInitOpening.px7;
				myInitOpening.bY4 = myInitOpening.py7;
				myInitOpening.bCX4 = myInitOpening.px7c;
				myInitOpening.bCY4 = myInitOpening.py7c;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidth = myInitOpening.leftPart.bkgrdHeight = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartX = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartY = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXC = myInitOpening.px7;
					myInitOpening.leftPart.startYC = myInitOpening.py7;
					myInitOpening.leftPart.endXC = myInitOpening.px1;
					myInitOpening.leftPart.endYC = myInitOpening.py1;
				}
				// /////////
				myInitOpening.bot3Part.bkgrdWidthBA = myInitOpening.bot3Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot3Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot3Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot3Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot3Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot3Part.startXBA = myInitOpening.px4;
				myInitOpening.bot3Part.startYBA = myInitOpening.py4;
				myInitOpening.bot3Part.endXBA = myInitOpening.px5;
				myInitOpening.bot3Part.endYBA = myInitOpening.py5;

				myInitOpening.bot1Part.bkgrdWidthBA = myInitOpening.bot1Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot1Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot1Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot1Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot1Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot1Part.startXBA = myInitOpening.px5;
				myInitOpening.bot1Part.startYBA = myInitOpening.py5;
				myInitOpening.bot1Part.endXBA = myInitOpening.px6;
				myInitOpening.bot1Part.endYBA = myInitOpening.py6;

				myInitOpening.bot2Part.bkgrdWidthBA = myInitOpening.bot2Part.bkgrdHeightBA = myInitOpening.radius1 * 2;
				myInitOpening.bot2Part.bkgrdStartXBA = myInitOpening.bkgrdStartX;
				myInitOpening.bot2Part.bkgrdStartYBA = myInitOpening.bkgrdStartY;
				// myInitOpening.bot2Part.radius1BA
				// =
				// myInitOpening.radius1;
				// myInitOpening.bot2Part.radius2BA
				// =
				// myInitOpening.radius2;
				myInitOpening.bot2Part.startXBA = myInitOpening.px6;
				myInitOpening.bot2Part.startYBA = myInitOpening.py6;
				myInitOpening.bot2Part.endXBA = myInitOpening.px7;
				myInitOpening.bot2Part.endYBA = myInitOpening.py7;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidthBA = myInitOpening.leftPart.bkgrdHeightBA = myInitOpening.radius1 * 2;
					myInitOpening.leftPart.bkgrdStartXBA = myInitOpening.bkgrdStartX;
					myInitOpening.leftPart.bkgrdStartYBA = myInitOpening.bkgrdStartY;
					// myInitOpening.leftPart.radius1BA
					// =
					// myInitOpening.radius1;
					// myInitOpening.leftPart.radius2BA
					// =
					// myInitOpening.radius2;
					myInitOpening.leftPart.startXBA = myInitOpening.px7;
					myInitOpening.leftPart.startYBA = myInitOpening.py7;
					myInitOpening.leftPart.endXBA = myInitOpening.px1;
					myInitOpening.leftPart.endYBA = myInitOpening.py1;
				}
				// ////////////////
				myInitOpening.bot3Part.bkgrdWidthA = myInitOpening.bot3Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot3Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot3Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot3Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot3Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot3Part.startXA = myInitOpening.px4A;
				myInitOpening.bot3Part.startYA = myInitOpening.py4A;
				myInitOpening.bot3Part.endXA = myInitOpening.px5A;
				myInitOpening.bot3Part.endYA = myInitOpening.py5A;
				myInitOpening.bX3A = myInitOpening.px4A;
				myInitOpening.bY3A = myInitOpening.py4A;

				myInitOpening.bot1Part.bkgrdWidthA = myInitOpening.bot1Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot1Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot1Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot1Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot1Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot1Part.startXA = myInitOpening.px5A;
				myInitOpening.bot1Part.startYA = myInitOpening.py5A;
				myInitOpening.bot1Part.endXA = myInitOpening.px6A;
				myInitOpening.bot1Part.endYA = myInitOpening.py6A;

				myInitOpening.bot2Part.bkgrdWidthA = myInitOpening.bot2Part.bkgrdHeightA = myInitOpening.radius1A * 2;
				myInitOpening.bot2Part.bkgrdStartXA = myInitOpening.bkgrdStartXA;
				myInitOpening.bot2Part.bkgrdStartYA = myInitOpening.bkgrdStartYA;
				// myInitOpening.bot2Part.radius1A
				// =
				// myInitOpening.radius1A;
				// myInitOpening.bot2Part.radius2A
				// =
				// myInitOpening.radius2A;
				myInitOpening.bot2Part.startXA = myInitOpening.px6A;
				myInitOpening.bot2Part.startYA = myInitOpening.py6A;
				myInitOpening.bot2Part.endXA = myInitOpening.px7A;
				myInitOpening.bot2Part.endYA = myInitOpening.py7A;
				myInitOpening.bX4A = myInitOpening.px7A;
				myInitOpening.bY4A = myInitOpening.py7A;

				if (myInitOpening.noSidesLeft == 1) {
					myInitOpening.leftPart.bkgrdWidthA = myInitOpening.leftPart.bkgrdHeightA = myInitOpening.radius1A * 2;
					myInitOpening.leftPart.bkgrdStartXA = myInitOpening.bkgrdStartXA;
					myInitOpening.leftPart.bkgrdStartYA = myInitOpening.bkgrdStartYA;
					// myInitOpening.leftPart.radius1A
					// =
					// myInitOpening.radius1A;
					// myInitOpening.leftPart.radius2A
					// =
					// myInitOpening.radius2A;
					myInitOpening.leftPart.startXA = myInitOpening.px7A;
					myInitOpening.leftPart.startYA = myInitOpening.py7A;
					myInitOpening.leftPart.endXA = myInitOpening.px1A;
					myInitOpening.leftPart.endYA = myInitOpening.py1A;
				}

			}
		}

		// //////

	}

	public void getArchesTop(final OpeningObject myInitOpening) {

		double mycenter1 = myInitOpening.myParent.top1.x1;
		double mycenter2 = myInitOpening.myParent.top1.x1;

		if (myInitOpening.myParent.shapeID >= 450
				&& myInitOpening.myParent.shapeID <= 461) {
			mycenter1 = myInitOpening.myParent.top1.x1;

			mycenter2 = myInitOpening.myParent.top2.x1;

		}

		if (myInitOpening.top1Part.partForm == 2
				&& myInitOpening.top1Part.endXC <= myInitOpening.myParent.top1.endX) {

			double baseR = mycenter1 - myInitOpening.top1Part.endXC;
			double baseL = mycenter1 - myInitOpening.top1Part.startXC;
			double baseRA = mycenter1 - myInitOpening.top1Part.endXA;
			double baseLA = mycenter1 - myInitOpening.top1Part.startXA;

			final double heightR = myInitOpening.myParent.top1.y1
					- myInitOpening.top1Part.endYC;

			final double heightL = myInitOpening.myParent.top1.y1
					- myInitOpening.top1Part.startYC;

			final double heightRA = myInitOpening.myParent.top1.y1
					- myInitOpening.top1Part.endYA;

			final double heightLA = myInitOpening.myParent.top1.y1
					- myInitOpening.top1Part.startYA;

			double startAngle = 0;
			double endAngle = 0;
			double extentAngle = 0;

			double startAngleA = 0;
			double endAngleA = 0;
			double extentAngleA = 0;

			if (baseR > 0) {
				if (heightR > 0) {
					startAngle = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightR / baseR)));
					startAngleA = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightRA / baseRA)));
				}
				if (heightL > 0) {
					endAngle = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightL / baseL)));
					endAngleA = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightLA / baseLA)));
				} else {
					endAngle = 180;
					endAngleA = 180;
				}

				extentAngle = endAngle - startAngle;
				extentAngleA = endAngleA - startAngleA;
				// if
				// (myInitOpening.myParent.shapeID
				// >= 450
				// &&
				// myInitOpening.myParent.shapeID
				// <= 461)
				// {
				// extentAngle =
				// extentAngleA;
				// startAngle = startAngleA;
				// }

			}
			if (baseR < 0 && baseL < 0) {
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);
				baseRA = Math.abs(baseRA);
				baseLA = Math.abs(baseLA);

				startAngle = Math
						.abs(Math.toDegrees(Math.atan(heightR / baseR)));

				startAngleA = Math.abs(Math.toDegrees(Math.atan(heightRA
						/ baseRA)));
				if (heightL > 0) {
					endAngle = Math.abs(Math.toDegrees(Math.atan(heightL
							/ baseL)));
					endAngleA = Math.abs(Math.toDegrees(Math.atan(heightLA
							/ baseLA)));
				} else {
					endAngle = 180;
					endAngleA = 180;
				}

				extentAngle = endAngle - startAngle;
				extentAngleA = endAngleA - startAngleA;

			}
			if (baseR < 0 && baseL > 0) {
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);
				baseRA = Math.abs(baseRA);
				baseLA = Math.abs(baseLA);

				startAngle = Math
						.abs(Math.toDegrees(Math.atan(heightR / baseR)));

				startAngleA = Math.abs(Math.toDegrees(Math.atan(heightRA
						/ baseRA)));
				if (heightL > 0) {
					endAngle = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightL / baseL)));
					endAngleA = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightLA / baseLA)));
				} else {
					endAngle = 180;
					endAngleA = 180;
				}

				extentAngle = endAngle - startAngle;
				extentAngleA = endAngleA - startAngleA;
			}
			if (baseR < 0 && baseL == 0) {
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);

				startAngle = Math
						.abs(Math.toDegrees(Math.atan(heightR / baseR)));

				endAngle = 90;

				extentAngle = endAngle - startAngle;

				baseRA = Math.abs(baseRA);
				baseLA = Math.abs(baseLA);

				startAngleA = Math.abs(Math.toDegrees(Math.atan(heightRA
						/ baseRA)));

				endAngleA = 90;

				extentAngleA = endAngleA - startAngleA;
			}
			if (baseR == 0 && baseL < 0) {
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);

				startAngle = 90;

				endAngle = Math.abs(Math.toDegrees(Math.toRadians(180)
						- Math.atan(heightL / baseL)));

				extentAngle = endAngle - startAngle;

				baseRA = Math.abs(baseRA);
				baseLA = Math.abs(baseLA);

				startAngleA = 90;

				endAngleA = Math.abs(Math.toDegrees(Math.toRadians(180)
						- Math.atan(heightLA / baseLA)));

				extentAngle = endAngle - startAngle;
			}

			myInitOpening.top1Part.startAngle = myInitOpening.top1Part.startAngleBA = startAngle;
			myInitOpening.top1Part.endAngle = myInitOpening.top1Part.endAngleBA = extentAngle;
			myInitOpening.top1Part.startAngleA = startAngleA;
			myInitOpening.top1Part.endAngleA = extentAngleA;
		} else if (myInitOpening.top1Part.partForm == 2
				&& myInitOpening.top1Part.startXC >= myInitOpening.myParent.top1.endX) {

			double baseR = mycenter2 - myInitOpening.top1Part.endXC;
			double baseL = mycenter2 - myInitOpening.top1Part.startXC;

			final double heightR = myInitOpening.myParent.top1.y1
					- myInitOpening.top1Part.endYC;

			final double heightL = myInitOpening.myParent.top1.y1
					- myInitOpening.top1Part.startYC;

			double startAngle = 0;
			double endAngle = 0;
			double extentAngle = 0;

			double baseRA = mycenter2 - myInitOpening.top1Part.endXA;
			double baseLA = mycenter2 - myInitOpening.top1Part.startXA;

			final double heightRA = myInitOpening.myParent.top1.y1
					- myInitOpening.top1Part.endYA;

			final double heightLA = myInitOpening.myParent.top1.y1
					- myInitOpening.top1Part.startYA;

			double startAngleA = 0;
			double endAngleA = 0;
			double extentAngleA = 0;

			if (baseR > 0) {
				if (heightR > 0) {
					startAngle = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightR / baseR)));
				}
				if (heightL > 0) {
					endAngle = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightL / baseL)));
				} else {
					endAngle = 180;
				}

				extentAngle = endAngle - startAngle;

			}
			if (baseR < 0 && baseL < 0) {
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);

				startAngle = Math
						.abs(Math.toDegrees(Math.atan(heightR / baseR)));
				if (heightL > 0) {
					endAngle = Math.abs(Math.toDegrees(Math.atan(heightL
							/ baseL)));
				} else {
					endAngle = 180;
				}

				extentAngle = endAngle - startAngle;
			}
			if (baseR < 0 && baseL > 0) {
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);

				startAngle = Math
						.abs(Math.toDegrees(Math.atan(heightR / baseR)));
				if (heightL > 0) {
					endAngle = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightL / baseL)));
				} else {
					endAngle = 180;
				}

				extentAngle = endAngle - startAngle;
			}
			if (baseR < 0 && baseL == 0) {
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);

				startAngle = Math
						.abs(Math.toDegrees(Math.atan(heightR / baseR)));

				endAngle = 90;

				extentAngle = endAngle - startAngle;
			}
			if (baseR == 0 && baseL < 0) {
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);

				startAngle = 90;

				endAngle = Math.abs(Math.toDegrees(Math.toRadians(180)
						- Math.atan(heightL / baseL)));

				extentAngle = endAngle - startAngle;
			}

			myInitOpening.top1Part.startAngle = myInitOpening.top1Part.startAngleBA = startAngle;
			myInitOpening.top1Part.endAngle = myInitOpening.top1Part.endAngleBA = extentAngle;

			// ////A//////

			if (baseRA > 0) {
				if (heightRA > 0) {
					startAngleA = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightRA / baseRA)));
				}
				if (heightLA > 0) {
					endAngleA = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightLA / baseLA)));
				} else {
					endAngleA = 180;
				}

				extentAngleA = endAngleA - startAngleA;

			}
			if (baseRA < 0 && baseLA < 0) {
				baseRA = Math.abs(baseRA);
				baseLA = Math.abs(baseLA);

				startAngleA = Math.abs(Math.toDegrees(Math.atan(heightRA
						/ baseRA)));
				if (heightLA > 0) {
					endAngleA = Math.abs(Math.toDegrees(Math.atan(heightLA
							/ baseLA)));
				} else {
					endAngleA = 180;
				}

				extentAngleA = endAngleA - startAngleA;
			}
			if (baseRA < 0 && baseLA > 0) {
				baseRA = Math.abs(baseRA);
				baseLA = Math.abs(baseLA);

				startAngleA = Math.abs(Math.toDegrees(Math.atan(heightRA
						/ baseRA)));
				if (heightLA > 0) {
					endAngleA = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightLA / baseLA)));
				} else {
					endAngleA = 180;
				}

				extentAngleA = endAngleA - startAngleA;
			}
			if (baseRA < 0 && baseLA == 0) {
				baseRA = Math.abs(baseRA);
				baseLA = Math.abs(baseLA);

				startAngleA = Math.abs(Math.toDegrees(Math.atan(heightRA
						/ baseRA)));

				endAngleA = 90;

				extentAngleA = endAngleA - startAngleA;
			}
			if (baseRA == 0 && baseLA < 0) {
				baseRA = Math.abs(baseRA);
				baseLA = Math.abs(baseLA);

				startAngleA = 90;

				endAngleA = Math.abs(Math.toDegrees(Math.toRadians(180)
						- Math.atan(heightLA / baseLA)));

				extentAngleA = endAngleA - startAngleA;
			}

			myInitOpening.top1Part.startAngleA = startAngleA;
			myInitOpening.top1Part.endAngleA = extentAngleA;

		}
		// ///////////////////

		if (myInitOpening.top2Part.partForm == 2
				&& myInitOpening.noSidesTop > 1) {

			double baseR = mycenter2 - myInitOpening.top2Part.endXC;
			double baseL = mycenter2 - myInitOpening.top2Part.startXC;

			final double heightR = myInitOpening.myParent.top1.y1
					- myInitOpening.top2Part.endYC;

			final double heightL = myInitOpening.myParent.top1.y1
					- myInitOpening.top2Part.startYC;

			double startAngle = 0;
			double endAngle = 0;
			double extentAngle = 0;
			if (baseR > 0) {
				if (heightR > 0) {
					startAngle = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightR / baseR)));
				}
				if (heightL > 0) {
					endAngle = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightL / baseL)));
				} else {
					endAngle = 180;
				}

				extentAngle = endAngle - startAngle;

			}
			if (baseR < 0 && baseL < 0) {
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);

				startAngle = Math
						.abs(Math.toDegrees(Math.atan(heightR / baseR)));
				if (heightL > 0) {
					endAngle = Math.abs(Math.toDegrees(Math.atan(heightL
							/ baseL)));
				} else {
					endAngle = 180;
				}

				extentAngle = endAngle - startAngle;
			}
			if (baseR < 0 && baseL > 0) {
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);

				startAngle = Math
						.abs(Math.toDegrees(Math.atan(heightR / baseR)));
				if (heightL > 0) {
					endAngle = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightL / baseL)));
				} else {
					endAngle = 180;
				}

				extentAngle = endAngle - startAngle;
			}
			if (baseR < 0 && baseL == 0) {
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);

				startAngle = Math
						.abs(Math.toDegrees(Math.atan(heightR / baseR)));

				endAngle = 90;

				extentAngle = endAngle - startAngle;
			}
			if (baseR == 0 && baseL < 0) {
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);

				startAngle = 90;

				endAngle = Math.abs(Math.toDegrees(Math.toRadians(180)
						- Math.atan(heightL / baseL)));

				extentAngle = endAngle - startAngle;
			}

			myInitOpening.top2Part.startAngle = myInitOpening.top2Part.startAngleBA = startAngle;

			if (myInitOpening.topIn) {
				myInitOpening.top2Part.endAngle = myInitOpening.top2Part.endAngleBA = extentAngle;
			} else {
				myInitOpening.top2Part.endAngle = myInitOpening.top2Part.endAngleBA = myInitOpening.top1Part.endAngle;

			}
			// ////////////////
			double baseRA = mycenter2 - myInitOpening.top2Part.endXA;
			double baseLA = mycenter2 - myInitOpening.top2Part.startXA;

			final double heightRA = myInitOpening.myParent.top1.y1
					- myInitOpening.top2Part.endYA;

			final double heightLA = myInitOpening.myParent.top1.y1
					- myInitOpening.top2Part.startYA;

			double startAngleA = 0;
			double endAngleA = 0;
			double extentAngleA = 0;
			if (baseRA > 0) {
				if (heightRA > 0) {
					startAngle = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightRA / baseRA)));
				}
				if (heightLA > 0) {
					endAngleA = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightLA / baseLA)));
				} else {
					endAngleA = 180;
				}

				extentAngleA = endAngleA - startAngleA;

			}
			if (baseRA < 0 && baseLA < 0) {
				baseRA = Math.abs(baseRA);
				baseLA = Math.abs(baseLA);

				startAngleA = Math.abs(Math.toDegrees(Math.atan(heightRA
						/ baseRA)));
				if (heightLA > 0) {
					endAngleA = Math.abs(Math.toDegrees(Math.atan(heightLA
							/ baseLA)));
				} else {
					endAngleA = 180;
				}

				extentAngleA = endAngleA - startAngleA;
			}
			if (baseRA < 0 && baseLA > 0) {
				baseRA = Math.abs(baseRA);
				baseLA = Math.abs(baseLA);

				startAngleA = Math.abs(Math.toDegrees(Math.atan(heightRA
						/ baseRA)));
				if (heightLA > 0) {
					endAngleA = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightLA / baseLA)));
				} else {
					endAngleA = 180;
				}

				extentAngleA = endAngleA - startAngleA;
			}
			if (baseRA < 0 && baseLA == 0) {
				baseRA = Math.abs(baseRA);
				baseLA = Math.abs(baseLA);

				startAngleA = Math.abs(Math.toDegrees(Math.atan(heightRA
						/ baseRA)));

				endAngleA = 90;

				extentAngleA = endAngleA - startAngleA;
			}
			if (baseRA == 0 && baseLA < 0) {
				baseRA = Math.abs(baseRA);
				baseLA = Math.abs(baseLA);

				startAngleA = 90;

				endAngleA = Math.abs(Math.toDegrees(Math.toRadians(180)
						- Math.atan(heightLA / baseLA)));

				extentAngleA = endAngleA - startAngleA;
			}

			myInitOpening.top2Part.startAngleA = startAngleA;

			if (myInitOpening.topIn) {
				myInitOpening.top2Part.endAngleA = extentAngleA;
			} else {
				myInitOpening.top2Part.endAngleA = myInitOpening.top1Part.endAngleA;

			}

		}
		// /////////////////////////////////////////////////
		if (myInitOpening.leftIn && myInitOpening.rightIn
				&& myInitOpening.noSidesTop == 2) {
			double baseR = mycenter1 - myInitOpening.top1Part.endXC;
			double baseL = mycenter1 - myInitOpening.top1Part.startXC;

			double heightR = myInitOpening.myParent.top1.y1
					- myInitOpening.top1Part.endYC;

			double heightL = myInitOpening.myParent.top1.y1
					- myInitOpening.top1Part.startYC;

			double startAngle = 0;
			double endAngle = 0;
			double extentAngle = 0;

			if (baseR > 0) {
				if (heightR > 0) {
					startAngle = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightR / baseR)));
				}
				if (heightL > 0) {
					endAngle = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightL / baseL)));
				} else {
					endAngle = 180;
				}

				extentAngle = endAngle - startAngle;

			}
			if (baseR < 0 && baseL < 0) {
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);

				startAngle = Math
						.abs(Math.toDegrees(Math.atan(heightR / baseR)));
				if (heightL > 0) {
					endAngle = Math.abs(Math.toDegrees(Math.atan(heightL
							/ baseL)));
				} else {
					endAngle = 180;
				}

				extentAngle = endAngle - startAngle;
			}
			if (baseR < 0 && baseL > 0) {
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);

				startAngle = Math
						.abs(Math.toDegrees(Math.atan(heightR / baseR)));
				if (heightL > 0) {
					endAngle = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightL / baseL)));
				} else {
					endAngle = 180;
				}

				extentAngle = endAngle - startAngle;
			}
			if (baseR < 0 && baseL == 0) {
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);

				startAngle = Math
						.abs(Math.toDegrees(Math.atan(heightR / baseR)));

				endAngle = 90;

				extentAngle = endAngle - startAngle;
			}
			if (baseR == 0 && baseL < 0) {
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);

				startAngle = 90;

				endAngle = Math.abs(Math.toDegrees(Math.toRadians(180)
						- Math.atan(heightL / baseL)));

				extentAngle = endAngle - startAngle;
			}

			myInitOpening.top1Part.startAngle = myInitOpening.top1Part.startAngleBA = startAngle;
			myInitOpening.top1Part.endAngle = myInitOpening.top1Part.endAngleBA = extentAngle;

			baseR = mycenter2 - myInitOpening.top2Part.endXC;
			baseL = mycenter2 - myInitOpening.top2Part.startXC;

			heightR = myInitOpening.myParent.top1.y1
					- myInitOpening.top2Part.endYC;

			heightL = myInitOpening.myParent.top1.y1
					- myInitOpening.top2Part.startYC;

			startAngle = 0;
			endAngle = 0;
			extentAngle = 0;
			if (baseR > 0) {
				if (heightR > 0) {
					startAngle = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightR / baseR)));
				}
				if (heightL > 0) {
					endAngle = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightL / baseL)));
				} else {
					endAngle = 180;
				}

				extentAngle = endAngle - startAngle;

			}
			if (baseR < 0 && baseL < 0) {
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);

				startAngle = Math
						.abs(Math.toDegrees(Math.atan(heightR / baseR)));
				if (heightL > 0) {
					endAngle = Math.abs(Math.toDegrees(Math.atan(heightL
							/ baseL)));
				} else {
					endAngle = 180;
				}

				extentAngle = endAngle - startAngle;
			}
			if (baseR < 0 && baseL > 0) {
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);

				startAngle = Math
						.abs(Math.toDegrees(Math.atan(heightR / baseR)));
				if (heightL > 0) {
					endAngle = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightL / baseL)));
				} else {
					endAngle = 180;
				}

				extentAngle = endAngle - startAngle;
			}
			if (baseR < 0 && baseL == 0) {
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);

				startAngle = Math
						.abs(Math.toDegrees(Math.atan(heightR / baseR)));

				endAngle = 90;

				extentAngle = endAngle - startAngle;
			}
			if (baseR == 0 && baseL < 0) {
				baseR = Math.abs(baseR);
				baseL = Math.abs(baseL);

				startAngle = 90;

				endAngle = Math.abs(Math.toDegrees(Math.toRadians(180)
						- Math.atan(heightL / baseL)));

				extentAngle = endAngle - startAngle;
			}

			myInitOpening.top2Part.startAngle = myInitOpening.top2Part.startAngleBA = startAngle;

			myInitOpening.top2Part.endAngle = myInitOpening.top2Part.endAngleBA = extentAngle;

			// /////A////////

			double baseRA = mycenter1 - myInitOpening.top1Part.endXA;
			double baseLA = mycenter1 - myInitOpening.top1Part.startXA;

			double heightRA = myInitOpening.myParent.top1.y1
					- myInitOpening.top1Part.endYA;

			double heightLA = myInitOpening.myParent.top1.y1
					- myInitOpening.top1Part.startYA;

			double startAngleA = 0;
			double endAngleA = 0;
			double extentAngleA = 0;

			if (baseRA > 0) {
				if (heightRA > 0) {
					startAngleA = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightRA / baseRA)));
				}
				if (heightLA > 0) {
					endAngleA = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightLA / baseLA)));
				} else {
					endAngleA = 180;
				}

				extentAngleA = endAngleA - startAngleA;

			}
			if (baseRA < 0 && baseLA < 0) {
				baseRA = Math.abs(baseRA);
				baseLA = Math.abs(baseLA);

				startAngleA = Math.abs(Math.toDegrees(Math.atan(heightRA
						/ baseRA)));
				if (heightLA > 0) {
					endAngleA = Math.abs(Math.toDegrees(Math.atan(heightLA
							/ baseLA)));
				} else {
					endAngleA = 180;
				}

				extentAngleA = endAngleA - startAngleA;
			}
			if (baseR < 0 && baseLA > 0) {
				baseRA = Math.abs(baseRA);
				baseLA = Math.abs(baseLA);

				startAngleA = Math.abs(Math.toDegrees(Math.atan(heightRA
						/ baseRA)));
				if (heightLA > 0) {
					endAngleA = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightLA / baseLA)));
				} else {
					endAngleA = 180;
				}

				extentAngleA = endAngleA - startAngleA;
			}
			if (baseRA < 0 && baseLA == 0) {
				baseRA = Math.abs(baseRA);
				baseLA = Math.abs(baseLA);

				startAngleA = Math.abs(Math.toDegrees(Math.atan(heightRA
						/ baseRA)));

				endAngleA = 90;

				extentAngleA = endAngleA - startAngleA;
			}
			if (baseRA == 0 && baseLA < 0) {
				baseRA = Math.abs(baseRA);
				baseLA = Math.abs(baseLA);

				startAngleA = 90;

				endAngleA = Math.abs(Math.toDegrees(Math.toRadians(180)
						- Math.atan(heightLA / baseLA)));

				extentAngleA = endAngleA - startAngleA;
			}

			myInitOpening.top1Part.startAngleA = startAngleA;
			myInitOpening.top1Part.endAngleA = extentAngleA;

			baseRA = mycenter2 - myInitOpening.top2Part.endXA;
			baseLA = mycenter2 - myInitOpening.top2Part.startXA;

			heightRA = myInitOpening.myParent.top1.y1
					- myInitOpening.top2Part.endYA;

			heightLA = myInitOpening.myParent.top1.y1
					- myInitOpening.top2Part.startYA;

			startAngleA = 0;
			endAngleA = 0;
			extentAngleA = 0;
			if (baseRA > 0) {
				if (heightRA > 0) {
					startAngleA = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightRA / baseRA)));
				}
				if (heightLA > 0) {
					endAngleA = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightLA / baseLA)));
				} else {
					endAngleA = 180;
				}

				extentAngleA = endAngleA - startAngleA;

			}
			if (baseRA < 0 && baseLA < 0) {
				baseRA = Math.abs(baseRA);
				baseLA = Math.abs(baseLA);

				startAngleA = Math.abs(Math.toDegrees(Math.atan(heightRA
						/ baseRA)));
				if (heightLA > 0) {
					endAngleA = Math.abs(Math.toDegrees(Math.atan(heightLA
							/ baseLA)));
				} else {
					endAngleA = 180;
				}

				extentAngleA = endAngleA - startAngleA;
			}
			if (baseRA < 0 && baseLA > 0) {
				baseRA = Math.abs(baseRA);
				baseLA = Math.abs(baseLA);

				startAngle = Math.abs(Math.toDegrees(Math.atan(heightRA
						/ baseRA)));
				if (heightLA > 0) {
					endAngleA = Math.abs(Math.toDegrees(Math.toRadians(180)
							- Math.atan(heightLA / baseLA)));
				} else {
					endAngleA = 180;
				}

				extentAngleA = endAngleA - startAngleA;
			}
			if (baseRA < 0 && baseLA == 0) {
				baseRA = Math.abs(baseRA);
				baseLA = Math.abs(baseLA);

				startAngleA = Math.abs(Math.toDegrees(Math.atan(heightRA
						/ baseRA)));

				endAngleA = 90;

				extentAngleA = endAngleA - startAngleA;
			}
			if (baseRA == 0 && baseLA < 0) {
				baseRA = Math.abs(baseRA);
				baseLA = Math.abs(baseLA);

				startAngleA = 90;

				endAngleA = Math.abs(Math.toDegrees(Math.toRadians(180)
						- Math.atan(heightLA / baseLA)));

				extentAngleA = endAngleA - startAngleA;
			}

			myInitOpening.top2Part.startAngleA = startAngleA;

			myInitOpening.top2Part.endAngleA = extentAngleA;

		}
		// return myAngles;

		// top2
	}

	public OpeningObject setOpeningMullions(final OpeningObject opening) {

		if (myBOpening == null) {
			myBOpening.mullionObjectsH = null;
			myBOpening.mullionObjectsH = myBOpening.mullionsH.toArray();
			myBOpening.mullionObjectsV = null;
			myBOpening.mullionObjectsV = myBOpening.mullions.toArray();
		} else {
			myBOpening.mullionObjectsH = null;
			myBOpening.mullionObjectsH = myBOpening.mullionsH.toArray();
			myBOpening.mullionObjectsV = null;
			myBOpening.mullionObjectsV = myBOpening.mullions.toArray();
		}

		Profiles myMullionBot = opening.myMullionBot;
		Profiles myMullionTop = opening.myMullionTop;
		Profiles myMullionLeft = opening.myMullionLeft;
		Profiles myMullionRight = opening.myMullionRight;
		// int posCondRight = 0;
		// int posCondLeft = 0;
		if (opening.startCol == 2) {
			myMullionRight = opening.myMullionRight;
		}

		for (final Object element : myBOpening.mullionObjectsH) {
			if (((Profiles) element).rowCol == opening.endRow
					&& ((Profiles) element).startPos <= opening.startCol
					&& ((Profiles) element).endPos >= opening.endCol) {
				myMullionBot = (Profiles) element;
				opening.myMullionBot = myMullionBot;
			}
			if (((Profiles) element).rowCol + 1 == opening.startRow
					&& ((Profiles) element).startPos <= opening.startCol
					&& ((Profiles) element).endPos >= opening.endCol) {
				myMullionTop = (Profiles) element;
				opening.myMullionTop = myMullionTop;
			}
		}
		for (final Object element : myBOpening.mullionObjectsV) {
			if (((Profiles) element).rowCol == opening.endCol
					&& ((Profiles) element).startPos <= opening.startRow
					&& ((Profiles) element).endPos >= opening.endRow) {
				myMullionRight = (Profiles) element;
				// posCondRight =
				// ((Profiles)
				// this.myBOpening.mullionObjectsV[vc]).posCondition;
				opening.myMullionRight = myMullionRight;
			}
			// if (opening.endCol <
			// myBOpening.xCols) {
			if (((Profiles) element).rowCol + 1 == opening.startCol
					&& ((Profiles) element).startPos <= opening.startRow
					&& ((Profiles) element).endPos >= opening.endRow) {
				myMullionLeft = (Profiles) element;
				// posCondLeft =
				// ((Profiles)
				// this.myBOpening.mullionObjectsV[vc]).posCondition;
				opening.myMullionLeft = myMullionLeft;
			}

		}

		return opening;
	}

	public void setTBLR(final OpeningObject opening) {

		tx1 = tx1A = tx1c = opening.top1.startX;
		ty1 = ty1A = ty1c = opening.top1.startY;
		tx2 = tx2A = tx2c = opening.top1.endX;
		ty2 = ty2A = ty2c = opening.top1.endY;

		t2x1 = t2x1A = t2x1c = opening.top2.startX;
		t2y1 = t2y1A = t2y1c = opening.top2.startY;
		t2x2 = t2x2A = t2x2c = opening.top2.endX;
		t2y2 = t2y2A = t2y2c = opening.top2.endY;

		t3x1 = t3x1A = t3x1c = opening.top3.startX;
		t3y1 = t3y1A = t3y1c = opening.top3.startY;
		t3x2 = t3x2A = t3x2c = opening.top3.endX;
		t3y2 = t3y2A = t3y2c = opening.top3.endY;

		bx1 = bx1A = bx1c = opening.bot1.startX;
		by1 = by1A = by1c = opening.bot1.startY;
		bx2 = bx2A = bx2c = opening.bot1.endX;
		by2 = by2A = by2c = opening.bot1.endY;

		b2x1 = b2x1A = b2x1c = opening.bot2.startX;
		b2y1 = b2y1A = b2y1c = opening.bot2.startY;
		b2x2 = b2x2A = b2x2c = opening.bot2.endX;
		b2y2 = b2y2A = b2y2c = opening.bot2.endY;

		b3x1 = b3x1A = b3x1c = opening.bot3.startX;
		b3y1 = b3y1A = b3y1c = opening.bot3.startY;
		b3x2 = b3x2A = b3x2c = opening.bot3.endX;
		b3y2 = b3y2A = b3y2c = opening.bot3.endY;

		t1s = opening.top1.partForm;
		t2s = opening.top2.partForm;
		t3s = opening.top3.partForm;
		b1s = opening.bot1.partForm;
		b2s = opening.bot2.partForm;
		b3s = opening.bot3.partForm;

		lx1 = lx1A = lx1c = opening.left.startX;
		ly1 = ly1A = ly1c = opening.left.startY;
		lx2 = lx2A = lx2c = opening.left.endX;
		ly2 = ly2A = ly2c = opening.left.endY;

		rx1 = rx1A = rx1c = opening.right.startX;
		ry1 = ry1A = ry1c = opening.right.startY;
		rx2 = rx2A = rx2c = opening.right.endX;
		ry2 = ry2A = ry2c = opening.right.endY;

		if (opening.topIn && opening.noSidesTop == 1) {
			ty1c = ty1c - opening.myMullionTop.partDimB / 2;
			ty2c = ty1c - opening.myMullionTop.partDimB / 2;

			ty1c = this.intersectY(lx1, ly1, lx2, ly2,
					opening.myMullionTop.centerXs,
					opening.myMullionTop.centerYs,
					opening.myMullionTop.centerXe,
					opening.myMullionTop.centerYe);

			ty2c = this.intersectY(rx1, ry1, rx2, ry2,
					opening.myMullionTop.centerXs,
					opening.myMullionTop.centerYs,
					opening.myMullionTop.centerXe,
					opening.myMullionTop.centerYe);
		}
		if (opening.topIn && opening.noSidesTop == 2
				&& opening.top1.startY > opening.top2.startY) {
			t2y1c = t2y1c - opening.myMullionTop.partDimB / 2;
			t2y2c = t2y1c - opening.myMullionTop.partDimB / 2;

		}
		if (opening.topIn && opening.noSidesTop == 2
				&& opening.top1.endY < opening.top2.endY) {
			ty1c = ty1c - opening.myMullionTop.partDimB / 2;
			ty2c = ty1c - opening.myMullionTop.partDimB / 2;
		}
		if (opening.topIn && opening.noSidesTop == 3) {
			t3y1c = t3y1c - opening.myMullionTop.partDimB / 2;
			t3y2c = t3y1c - opening.myMullionTop.partDimB / 2;
		}

		if (opening.leftIn) {
			tx1c = tx1c - opening.myMullionLeft.partDimB / 2;
			lx1c = lx1c - opening.myMullionLeft.partDimB / 2;
			lx2c = lx2c - opening.myMullionLeft.partDimB / 2;

			tx1c = this.intersectX(tx1, ty1, tx2, ty2,
					opening.myMullionLeft.centerXs,
					opening.myMullionLeft.centerYs,
					opening.myMullionLeft.centerXe,
					opening.myMullionLeft.centerYe);

			lx1c = this.intersectX(bx1, by1, bx2, by2,
					opening.myMullionLeft.centerXs,
					opening.myMullionLeft.centerYs,
					opening.myMullionLeft.centerXe,
					opening.myMullionLeft.centerYe);

			lx2c = this.intersectX(tx1, ty1, tx2, ty2,
					opening.myMullionLeft.centerXs,
					opening.myMullionLeft.centerYs,
					opening.myMullionLeft.centerXe,
					opening.myMullionLeft.centerYe);

			if (opening.topIn && opening.noSidesTop == 1) {

				ly2c = ly2c - opening.myMullionTop.partDimB / 2;

				ly2c = this.intersectY(opening.myMullionTop.centerXs,
						opening.myMullionTop.centerYs,
						opening.myMullionTop.centerXe,
						opening.myMullionTop.centerYe,
						opening.myMullionLeft.centerXs,
						opening.myMullionLeft.centerYs,
						opening.myMullionLeft.centerXe,
						opening.myMullionLeft.centerYe);

			}
			if (opening.topIn && opening.noSidesTop == 2
					&& opening.top1.endY < opening.top2.endY) {
				ly2c = ly2c - opening.myMullionTop.partDimB / 2;

			}
			if (opening.botIn) {

				ly1c = ly1c + opening.myMullionBot.partDimB / 2;

				ly1c = this.intersectY(opening.myMullionBot.centerXs,
						opening.myMullionBot.centerYs,
						opening.myMullionBot.centerXe,
						opening.myMullionBot.centerYe,
						opening.myMullionLeft.centerXs,
						opening.myMullionLeft.centerYs,
						opening.myMullionLeft.centerXe,
						opening.myMullionLeft.centerYe);
			}

		}

		if (opening.rightIn) {
			tx2c = tx2c + opening.myMullionRight.partDimB / 2;
			rx1c = rx1c + opening.myMullionRight.partDimB / 2;
			rx2c = rx2c + opening.myMullionRight.partDimB / 2;

			tx2c = this.intersectX(tx1, ty1, tx2, ty2,
					opening.myMullionRight.centerXs,
					opening.myMullionRight.centerYs,
					opening.myMullionRight.centerXe,
					opening.myMullionRight.centerYe);

			rx2c = this.intersectX(bx1, by1, bx2, by2,
					opening.myMullionRight.centerXs,
					opening.myMullionRight.centerYs,
					opening.myMullionRight.centerXe,
					opening.myMullionRight.centerYe);

			rx1c = this.intersectX(tx1, ty1, tx2, ty2,
					opening.myMullionRight.centerXs,
					opening.myMullionRight.centerYs,
					opening.myMullionRight.centerXe,
					opening.myMullionRight.centerYe);

			if (opening.topIn && opening.noSidesTop == 1) {

				ry1c = ry1c - opening.myMullionTop.partDimB / 2;

				ry1c = this.intersectY(opening.myMullionTop.centerXs,
						opening.myMullionTop.centerYs,
						opening.myMullionTop.centerXe,
						opening.myMullionTop.centerYe,
						opening.myMullionRight.centerXs,
						opening.myMullionRight.centerYs,
						opening.myMullionRight.centerXe,
						opening.myMullionRight.centerYe);

			}
			if (opening.topIn && opening.noSidesTop == 2
					&& opening.top1.startY > opening.top2.startY) {
				ry1c = ry1c - opening.myMullionTop.partDimB / 2;
			}
			if (opening.botIn) {

				ry2c = ry2c + opening.myMullionBot.partDimB / 2;

				ry2c = this.intersectY(opening.myMullionBot.centerXs,
						opening.myMullionBot.centerYs,
						opening.myMullionBot.centerXe,
						opening.myMullionBot.centerYe,
						opening.myMullionRight.centerXs,
						opening.myMullionRight.centerYs,
						opening.myMullionRight.centerXe,
						opening.myMullionRight.centerYe);

			}

		}

		if (opening.botIn) {

			by2c = by2c + opening.myMullionBot.partDimB / 2;
			by1c = by1c + opening.myMullionBot.partDimB / 2;

			by2c = this.intersectY(lx1, ly1, lx2, ly2,
					opening.myMullionBot.centerXs,
					opening.myMullionBot.centerYs,
					opening.myMullionBot.centerXe,
					opening.myMullionBot.centerYe);

			by1c = this.intersectY(rx1, ry1, rx2, ry2,
					opening.myMullionBot.centerXs,
					opening.myMullionBot.centerYs,
					opening.myMullionBot.centerXe,
					opening.myMullionBot.centerYe);

			if (opening.leftIn) {

				bx2c = bx2c - opening.myMullionLeft.partDimB / 2;

				bx2c = this.intersectX(opening.myMullionLeft.startX,
						opening.myMullionLeft.startY,
						opening.myMullionLeft.endX, opening.myMullionLeft.endY,
						opening.myMullionBot.centerXs,
						opening.myMullionBot.centerYs,
						opening.myMullionBot.centerXe,
						opening.myMullionBot.centerYe);

			}
			if (opening.rightIn) {

				bx1c = bx1c - opening.myMullionRight.partDimB / 2;
				bx2c = this.intersectX(opening.myMullionRight.startX,
						opening.myMullionRight.startY,
						opening.myMullionRight.endX,
						opening.myMullionRight.endY,
						opening.myMullionBot.centerXs,
						opening.myMullionBot.centerYs,
						opening.myMullionBot.centerXe,
						opening.myMullionBot.centerYe);

			}
			if (opening.noSidesLeft == 0) {
				ty1c = ty1c + opening.myMullionBot.partDimB / 2;

				by2c = by2c + opening.myMullionBot.partDimB / 2;

				by2c = this.intersectY(tx1c, ty1c, tx2c, ty2c,
						opening.myMullionBot.centerXs,
						opening.myMullionBot.centerYs,
						opening.myMullionBot.centerXe,
						opening.myMullionBot.centerYe);

				ty1c = this.intersectY(tx1c, ty1c, tx2c, ty2c,
						opening.myMullionBot.centerXs,
						opening.myMullionBot.centerYs,
						opening.myMullionBot.centerXe,
						opening.myMullionBot.centerYe);

				bx2c = this.intersectX(tx1c, ty1c, tx2c, ty2c,
						opening.myMullionBot.centerXs,
						opening.myMullionBot.centerYs,
						opening.myMullionBot.centerXe,
						opening.myMullionBot.centerYe);

			}

			if (opening.noSidesRight == 0) {
				ty2c = ty2c + opening.myMullionBot.partDimB / 2;
				by1c = by1c + opening.myMullionBot.partDimB / 2;

				ty2c = this.intersectY(tx1c, ty1c, tx2c, ty2c,
						opening.myMullionBot.centerXs,
						opening.myMullionBot.centerYs,
						opening.myMullionBot.centerXe,
						opening.myMullionBot.centerYe);

				by1c = this.intersectY(tx1c, ty1c, tx2c, ty2c,
						opening.myMullionBot.centerXs,
						opening.myMullionBot.centerYs,
						opening.myMullionBot.centerXe,
						opening.myMullionBot.centerYe);

				bx1c = this.intersectX(tx1c, ty1c, tx2c, ty2c,
						opening.myMullionBot.centerXs,
						opening.myMullionBot.centerYs,
						opening.myMullionBot.centerXe,
						opening.myMullionBot.centerYe);

			}

		}

	}

	public void setPxyCenters(final OpeningObject opening) {

		px1c = opening.px1c;
		px2c = opening.px2c;
		px3c = opening.px3c;
		px4c = opening.px4c;
		px5c = opening.px5c;
		px6c = opening.px6c;
		px7c = opening.px7c;
		px8c = opening.px8c;
		py1c = opening.py1c;
		py2c = opening.py2c;
		py3c = opening.py3c;
		py4c = opening.py4c;
		py5c = opening.py5c;
		py6c = opening.py6c;
		py7c = opening.py7c;
		py8c = opening.py8c;

	}

	public OpeningObject createOpeningShape(OpeningObject myInitOpening) {

		CreateShapeMethods createShape = null;

		createShape = new CreateShapeMethods(myParent, 2, myFrame2);

		final Object[] returns = this.makeOpening(myInitOpening, createShape);

		myInitOpening = (OpeningObject) returns[0];

		// Cloning top1Parto to top1
		myInitOpening.top1 = (Top1Object) myInitOpening.top1
				.cloneProfile(myInitOpening.top1Part);

		// Cloning top2Part to top2
		if (myParent.top2Part.posInUse) {
			myInitOpening.top2 = (Top2Object) myInitOpening.top2
					.cloneProfile(myInitOpening.top2Part);

		} else if (!myParent.top2Part.posInUse) {
			myInitOpening.top2 = (Top2Object) myInitOpening.top2
					.cloneProfile(myInitOpening.top1Part);

			myInitOpening.top2Part = (Profiles) myInitOpening.top2Part
					.cloneProfile(myInitOpening.top1Part);

			myInitOpening.top2Part.posInUse = false;
			myInitOpening.top2.posInUse = false;
		}

		// Cloning top3Parto to top3
		myInitOpening.top3 = (Top3Object) myInitOpening.top3
				.cloneProfile(myInitOpening.top3Part);

		// Cloning Bot1Part to bot1
		myInitOpening.bot1 = (Bot1Object) myInitOpening.bot1
				.cloneProfile(myInitOpening.bot1Part);
		// Cloning Bot2Part to bot2
		myInitOpening.bot2 = (Bot2Object) myInitOpening.bot2
				.cloneProfile(myInitOpening.bot2Part);
		// Cloning Bot3Part to bot3
		myInitOpening.bot3 = (Bot3Object) myInitOpening.bot3
				.cloneProfile(myInitOpening.bot3Part);
		// Cloning LeftPart to left
		myInitOpening.left = (LeftObject) myInitOpening.left
				.cloneProfile(myInitOpening.leftPart);
		// Cloning RightPart to right
		myInitOpening.right = (RightObject) myInitOpening.right
				.cloneProfile(myInitOpening.rightPart);

		myInitOpening.options.clear();
		if (myFrame2.doOptions) {
			myInitOpening
					.executeOptionRules("createOpening.creatopeningShape.10191");
		}
		myInitOpening.bom.clear();
		myInitOpening.clearBomForShape();

		myInitOpening.executePartRules(true, true,
				"createOpening.creatopeningShape.10195");

		returns[1] = null;
		returns[0] = null;
		createShape = null;
		return myInitOpening;
	}

	public OpeningObject verifyCenterPoints(final OpeningObject myInitOpening) {

		if (startingCX == 0) {
			myInitOpening.startingCX = startingCX = myInitOpening.px1c;
			myInitOpening.startingCY = startingCY = myInitOpening.py1c;
			myInitOpening.bCX2 = myParent.bCX2 = myInitOpening.px2c;
			myInitOpening.bCY2 = myParent.bCY2 = myInitOpening.py2c;
			myInitOpening.bCX3 = myParent.bCX3 = myInitOpening.px3c;
			myInitOpening.bCY3 = myParent.bCY3 = myInitOpening.py3c;
			myInitOpening.bCX4 = myParent.bCX4 = myInitOpening.px4c;
			myInitOpening.bCY4 = myParent.bCY4 = myInitOpening.py4c;
		}
		return myInitOpening;
	}

	public OpeningObject setPartObjectForms(final OpeningObject myInitOpening) {

		myInitOpening.top1Part.partForm = myInitOpening.top1.partForm = t1s;
		myInitOpening.top2Part.partForm = myInitOpening.top2.partForm = t2s;
		myInitOpening.top3Part.partForm = myInitOpening.top3.partForm = t3s;
		myInitOpening.bot1Part.partForm = myInitOpening.bot1.partForm = b1s;
		myInitOpening.bot2Part.partForm = myInitOpening.bot2.partForm = b2s;
		myInitOpening.bot3Part.partForm = myInitOpening.bot3.partForm = b3s;

		myInitOpening.leftPart.partForm = myInitOpening.left.partForm = 1;
		myInitOpening.rightPart.partForm = myInitOpening.right.partForm = 1;
		return myInitOpening;
	}

	public OpeningObject getPxyALL(OpeningObject myInitOpening) {

		myInitOpening = this.getPxPY(tx1, ty1, tx2, ty2, t2x1, t2y1, t2x2,
				t2y2, t3x1, t3y1, t3x2, t3y2, bx1, by1, bx2, by2, b2x1, b2y1,
				b2x2, b2y2, b3x1, b3y1, b3x2, b3y2, lx1, ly1, lx2, ly2, rx1,
				ry1, rx2, ry2, myInitOpening);
		myInitOpening = this.getPxPYCenters(tx1c, ty1c, tx2c, ty2c, t2x1c,
				t2y1c, t2x2c, t2y2c, t3x1c, t3y1c, t3x2c, t3y2c, bx1c, by1c,
				bx2c, by2c, b2x1c, b2y1c, b2x2c, b2y2c, b3x1c, b3y1c, b3x2c,
				b3y2c, lx1c, ly1c, lx2c, ly2c, rx1c, ry1c, rx2c, ry2c,
				myInitOpening);
		myInitOpening = this.getPxPYA(tx1A, ty1A, tx2A, ty2A, t2x1A, t2y1A,
				t2x2A, t2y2A, t3x1A, t3y1A, t3x2A, t3y2A, bx1A, by1A, bx2A,
				by2A, b2x1A, b2y1A, b2x2A, b2y2A, b3x1A, b3y1A, b3x2A, b3y2A,
				lx1A, ly1A, lx2A, ly2A, rx1A, ry1A, rx2A, ry2A, myInitOpening);
		return myInitOpening;
	}

	public Object[] makeOpening(OpeningObject myInitOpening,
			CreateShapeMethods createShape) {

		final Object[] mainReturns = new Object[2];

		final Object[] returns = this.setPartDims(myInitOpening, createShape);

		myInitOpening = (OpeningObject) returns[0];

		createShape = (CreateShapeMethods) returns[1];

		createShape.getClearance(myInitOpening);

		createShape.setpXpY(myInitOpening.px1, myInitOpening.py1,
				myInitOpening.px2, myInitOpening.py2, myInitOpening.px3,
				myInitOpening.py3, myInitOpening.px4, myInitOpening.py4,
				myInitOpening.px5, myInitOpening.py5, myInitOpening.px6,
				myInitOpening.py6, myInitOpening.px7, myInitOpening.py7,
				myInitOpening.px8, myInitOpening.py8,

				myInitOpening.px1c, myInitOpening.py1c, myInitOpening.px2c,
				myInitOpening.py2c, myInitOpening.px3c, myInitOpening.py3c,
				myInitOpening.px4c, myInitOpening.py4c, myInitOpening.px5c,
				myInitOpening.py5c, myInitOpening.px6c, myInitOpening.py6c,
				myInitOpening.px7c, myInitOpening.py7c, myInitOpening.px8c,
				myInitOpening.py8c,

				myInitOpening.px1, myInitOpening.py1, myInitOpening.px2,
				myInitOpening.py2, myInitOpening.px3, myInitOpening.py3,
				myInitOpening.px4, myInitOpening.py4, myInitOpening.px5,
				myInitOpening.py5, myInitOpening.px6, myInitOpening.py6,
				myInitOpening.px7, myInitOpening.py7, myInitOpening.px8,
				myInitOpening.py8,

				myInitOpening.px1A, myInitOpening.py1A, myInitOpening.px2A,
				myInitOpening.py2A, myInitOpening.px3A, myInitOpening.py3A,
				myInitOpening.px4A, myInitOpening.py4A, myInitOpening.px5A,
				myInitOpening.py5A, myInitOpening.px6A, myInitOpening.py6A,
				myInitOpening.px7A, myInitOpening.py7A, myInitOpening.px8A,
				myInitOpening.py8A,

				myInitOpening.px1, myInitOpening.py1, myInitOpening.px2,
				myInitOpening.py2, myInitOpening.px3, myInitOpening.py3,
				myInitOpening.px4, myInitOpening.py4, myInitOpening.px5,
				myInitOpening.py5, myInitOpening.px6, myInitOpening.py6,
				myInitOpening.px7, myInitOpening.py7, myInitOpening.px8,
				myInitOpening.py8);

		if (myInitOpening.leftIn && myInitOpening.botIn && !myInitOpening.topIn) {
			myInitOpening.top1Part.myParent = myParent;
		}
		if (!myInitOpening.leftIn && !myInitOpening.rightIn
				&& myInitOpening.topIn && myInitOpening.botIn) {
			myInitOpening.top1Part.myParent = myParent;
		}

		myInitOpening = (OpeningObject) createShape.makeSides(myInitOpening);

		// myInitOpening = (OpeningObject) createShape.doParts(myInitOpening,
		// true);

		// Setting base info

		myInitOpening = (OpeningObject) createShape.setBaseInfo(myInitOpening,
				2, false);

		myInitOpening = (OpeningObject) createShape
				.setOpeningDims(myInitOpening);

		myInitOpening.top1Part.myParent = myParent;
		myInitOpening.top2Part.myParent = myParent;
		myInitOpening.top3Part.myParent = myParent;
		myInitOpening.bot1Part.myParent = myParent;
		myInitOpening.bot2Part.myParent = myParent;
		myInitOpening.bot3Part.myParent = myParent;
		myInitOpening.leftPart.myParent = myParent;
		myInitOpening.rightPart.myParent = myParent;

		myInitOpening.partObjects = createShape
				.setPartObjectsAndCollection(myInitOpening);

		this.clonePartsFromProfile(myInitOpening, createShape);

		myInitOpening.partObjects = createShape.doGPParts(
				myInitOpening.partObjects, myInitOpening, false);

		mainReturns[0] = myInitOpening;

		mainReturns[1] = createShape;

		return mainReturns;
	}

	public void checkLeanTo(final OpeningObject myShape) {

		final int l1 = myShape.lean;
		final int l2 = myShape.lean2;
		final int l3 = myShape.lean3;
		final int l4 = myShape.lean4;

		if (myShape.bY2 > myShape.highestY && myShape.lean2 == 0) {
			myShape.lean2 = 2;
		}
		if (myShape.startingY > myShape.highestY && myShape.lean4 == 0) {
			myShape.lean4 = 1;
		}
		if (myShape.bY3 < myShape.lowestY && myShape.bY2 > myShape.highestY
				&& myShape.lean2 == 0) {
			myShape.lean2 = 3;
		}
		if (myShape.bY3 < myShape.lowestY && myShape.bY2 == myShape.highestY
				&& myShape.lean2 == 0) {
			myShape.lean2 = 1;
		}
		if (myShape.bY4 < myShape.lowestY
				&& myShape.startingY > myShape.highestY && myShape.lean4 == 0) {
			myShape.lean4 = 3;
		}
		if (myShape.bY4 < myShape.lowestY
				&& myShape.startingY == myShape.highestY && myShape.lean4 == 0) {
			myShape.lean4 = 2;
		}
		if (myShape.noSidesTop == 1 && myShape.lean == 0) {
			if (myShape.startingX > myShape.bX4 && myShape.bX2 >= myShape.bX3) {
				myShape.lean = 2;
			}
			if (myShape.bX2 < myShape.bX3 && myShape.startingX <= myShape.bX4) {
				myShape.lean = 1;
			}
			if (myShape.startingX > myShape.bX4 && myShape.bX2 < myShape.bX3) {
				myShape.lean = 3;
			}

		}
		if (myShape.noSidesTop == 2 && myShape.lean == 0) {
			if (myShape.py1 > myShape.py2) {
				myShape.lean4 = 1;
				myShape.lean = 2;
			}
			if (myShape.py2 < myShape.py3) {
				myShape.lean2 = 2;
				myShape.lean = 1;
			}

		}
		if (myShape.noSidesTop == 3 && myShape.lean == 0) {
			if (myShape.py1 > myShape.py2) {
				myShape.lean4 = 1;
			}
			if (myShape.py3 < myShape.py4) {
				myShape.lean2 = 2;
			}
			myShape.lean = 0;
		}
		if (myShape.noSidesBot == 1 && myShape.lean3 == 0) {
			if (myShape.bX4 > myShape.startingX && myShape.bX2 >= myShape.bX3) {
				myShape.lean3 = 1;
			}
			if (myShape.bX2 > myShape.bX3 && myShape.startingX <= myShape.bX4) {
				myShape.lean3 = 2;
			}
			if (myShape.bX4 > myShape.startingX && myShape.bX2 > myShape.bX3) {
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

		if (l1 != myShape.lean || l2 != myShape.lean2 || l3 != myShape.lean3
				|| l4 != myShape.lean4) {
			leanChanged = true;
		}
	}

	public OpeningObject geMultiSideIntersections(final OpeningObject myShape) {

		if (myShape.noSidesTop == 2) {

			t1t2X = this.intersectX(myShape.top1Part.startXC,
					myShape.top1Part.startYC, myShape.top1Part.endXC,
					myShape.top1Part.endYC, myShape.top2Part.startXC,
					myShape.top2Part.startYC, myShape.top2Part.endXC,
					myShape.top2Part.endYC);

			t1t2Y = this.intersectY(myShape.top1Part.startXC,
					myShape.top1Part.startYC, myShape.top1Part.endXC,
					myShape.top1Part.endYC, myShape.top2Part.startXC,
					myShape.top2Part.startYC, myShape.top2Part.endXC,
					myShape.top2Part.endYC);

		} else if (myShape.noSidesTop == 3) {

			t1t3X = this.intersectX(myShape.top1Part.startXC,
					myShape.top1Part.startYC, myShape.top1Part.endXC,
					myShape.top1Part.endYC, myShape.top3Part.startXC,
					myShape.top3Part.startYC, myShape.top3Part.endXC,
					myShape.top3Part.endYC);

			t1t3Y = this.intersectY(myShape.top1Part.startXC,
					myShape.top1Part.startYC, myShape.top1Part.endXC,
					myShape.top1Part.endYC, myShape.top3Part.startXC,
					myShape.top3Part.startYC, myShape.top3Part.endXC,
					myShape.top3Part.endYC);

			t3t2X = this.intersectX(myShape.top2Part.startXC,
					myShape.top2Part.startYC, myShape.top2Part.endXC,
					myShape.top2Part.endYC, myShape.top3Part.startXC,
					myShape.top3Part.startYC, myShape.top3Part.endXC,
					myShape.top3Part.endYC);

			t3t2Y = this.intersectY(myShape.top2Part.startXC,
					myShape.top2Part.startYC, myShape.top2Part.endXC,
					myShape.top2Part.endYC, myShape.top3Part.startXC,
					myShape.top3Part.startYC, myShape.top3Part.endXC,
					myShape.top3Part.endYC);

		}

		if (myShape.noSidesBot >= 2) {

			b1b2X = this.intersectX(myShape.bot1Part.startXC,
					myShape.bot1Part.startYC, myShape.bot1Part.endXC,
					myShape.bot1Part.endYC, myShape.bot2Part.startXC,
					myShape.bot2Part.startYC, myShape.bot2Part.endXC,
					myShape.bot2Part.endYC);

			b1b2Y = this.intersectY(myShape.bot1Part.startXC,
					myShape.bot1Part.startYC, myShape.bot1Part.endXC,
					myShape.bot1Part.endYC, myShape.bot2Part.startXC,
					myShape.bot2Part.startYC, myShape.bot2Part.endXC,
					myShape.bot2Part.endYC);

		} else if (myShape.noSidesBot == 3) {

			b1b3X = this.intersectX(myShape.bot1Part.startXC,
					myShape.bot1Part.startYC, myShape.bot1Part.endXC,
					myShape.bot1Part.endYC, myShape.bot3Part.startXC,
					myShape.bot3Part.startYC, myShape.bot3Part.endXC,
					myShape.bot3Part.endYC);

			b1b3Y = this.intersectY(myShape.bot1Part.startXC,
					myShape.bot1Part.startYC, myShape.bot1Part.endXC,
					myShape.bot1Part.endYC, myShape.bot3Part.startXC,
					myShape.bot3Part.startYC, myShape.bot3Part.endXC,
					myShape.bot3Part.endYC);

		}
		return myShape;
	}

	public void clonePartsFromProfile(final OpeningObject myInitOpening,
			final CreateShapeMethods createShape) {

		// myInitOpening.top1 =
		// createShape.myTop1Clone(
		// myInitOpening.top1,
		// myInitOpening.top1Part);
		// myInitOpening.top2 =
		// createShape.myTop2Clone(
		// myInitOpening.top2,
		// myInitOpening.top2Part);
		// myInitOpening.top3 =
		// createShape.myTop3Clone(
		// myInitOpening.top3,
		// myInitOpening.top3Part);
		// myInitOpening.bot1 =
		// createShape.myBot1Clone(
		// myInitOpening.bot1,
		// myInitOpening.bot1Part);
		// myInitOpening.bot2 =
		// createShape.myBot2Clone(
		// myInitOpening.bot2,
		// myInitOpening.bot2Part);
		// myInitOpening.bot3 =
		// createShape.myBot3Clone(
		// myInitOpening.bot3,
		// myInitOpening.bot3Part);
		//
		// myInitOpening.left =
		// createShape.myLeftClone(
		// myInitOpening.left,
		// myInitOpening.leftPart);
		// myInitOpening.right =
		// createShape.myRightClone(
		// myInitOpening.right,
		// myInitOpening.rightPart);

		myInitOpening.top1 = (Top1Object) myInitOpening.top1
				.cloneProfile(myInitOpening.top1Part);

		myInitOpening.top2 = (Top2Object) myInitOpening.top2
				.cloneProfile(myInitOpening.top2Part);

		// Cloning top3Parto to top3
		myInitOpening.top3 = (Top3Object) myInitOpening.top3
				.cloneProfile(myInitOpening.top3Part);

		// Cloning Bot1Part to bot1
		myInitOpening.bot1 = (Bot1Object) myInitOpening.bot1
				.cloneProfile(myInitOpening.bot1Part);
		// Cloning Bot2Part to bot2
		myInitOpening.bot2 = (Bot2Object) myInitOpening.bot2
				.cloneProfile(myInitOpening.bot2Part);
		// Cloning Bot3Part to bot3
		myInitOpening.bot3 = (Bot3Object) myInitOpening.bot3
				.cloneProfile(myInitOpening.bot3Part);
		// Cloning LeftPart to left
		myInitOpening.left = (LeftObject) myInitOpening.left
				.cloneProfile(myInitOpening.leftPart);
		// Cloning RightPart to right
		myInitOpening.right = (RightObject) myInitOpening.right
				.cloneProfile(myInitOpening.rightPart);

	}

	public void setSideDims(final OpeningObject myInitOpening) {

		if (myParent.top1 != null
				&& myInitOpening.top1Part.endXC <= myBOpening.top1.endX) {
			myInitOpening.bkgrdStartX = myBOpening.top1.bkgrdStartX;
			myInitOpening.top1Part.bkgrdStartY = myBOpening.top1.bkgrdStartY;
			myInitOpening.top1Part.bkgrdWidth = myInitOpening.top1Part.bkgrdHeightBA = myBOpening.top1.bkgrdHeight;
			myInitOpening.top1Part.radius1 = myBOpening.top1.radius1;
			myInitOpening.top1Part.radius2 = myBOpening.top1.radius2;
		} else if (myParent.top1 != null
				&& myInitOpening.top1Part.startXC >= myBOpening.top2.startX) {
			myInitOpening.top1Part.bkgrdStartX = myBOpening.top2.bkgrdStartX;
			myInitOpening.top1Part.bkgrdStartY = myBOpening.top2.bkgrdStartY;
			myInitOpening.top1Part.bkgrdWidth = myInitOpening.top2Part.bkgrdHeightBA = myBOpening.top2.bkgrdHeight;
			myInitOpening.top1Part.radius1 = myBOpening.top2.radius1;
			myInitOpening.top1Part.radius2 = myBOpening.top2.radius2;
		}

		if (myBOpening.top2 != null && myInitOpening.noSidesTop > 1) {

			myInitOpening.top2Part.bkgrdStartX = myBOpening.top2.bkgrdStartX;
			myInitOpening.top2Part.bkgrdStartY = myBOpening.top2.bkgrdStartY;
			myInitOpening.top2Part.bkgrdWidth = myInitOpening.top2Part.bkgrdHeightBA = myBOpening.top2.bkgrdHeight;
			myInitOpening.top2Part.radius1 = myBOpening.top2.radius1;
			myInitOpening.top2Part.radius2 = myBOpening.top2.radius2;
		}
		if (myInitOpening.leftIn && myInitOpening.rightIn
				&& myInitOpening.noSidesTop == 2) {

			myInitOpening.bkgrdStartX = myBOpening.top1.bkgrdStartX;
			myInitOpening.top1Part.bkgrdStartY = myBOpening.top1.bkgrdStartY;
			myInitOpening.top1Part.bkgrdWidth = myInitOpening.top1Part.bkgrdHeightBA = myBOpening.top1.bkgrdHeight;
			myInitOpening.top1Part.radius1 = myBOpening.top1.radius1;
			myInitOpening.top1Part.radius2 = myBOpening.top1.radius2;

			myInitOpening.top2Part.bkgrdStartX = myBOpening.top2.bkgrdStartX;
			myInitOpening.top2Part.bkgrdStartY = myBOpening.top2.bkgrdStartY;
			myInitOpening.top2Part.bkgrdWidth = myInitOpening.top2Part.bkgrdHeightBA = myBOpening.top2.bkgrdHeight;
			myInitOpening.top2Part.radius1 = myBOpening.top2.radius1;
			myInitOpening.top2Part.radius2 = myBOpening.top2.radius2;
		}

	}

	public OpeningObject getPointsXY(final OpeningObject myInit) {

		myInit.px1 = myInit.startingX;
		myInit.py1 = myInit.startingY;
		myInit.px2 = myInit.bX2;
		myInit.py2 = myInit.bY2;
		myInit.px3 = myInit.bX3;
		myInit.py3 = myInit.bY3;
		myInit.px4 = myInit.bX4;
		myInit.py4 = myInit.bY4;

		if (myInit.startRow == 1 && myBOpening.noSidesTop > 1) {
			if (myBOpening.noSidesTop == 2) {
				if (myInit.startingX < myBOpening.px2 && //
						myInit.bX2 > myBOpening.px2) {
					myInit.px1 = myInit.startingX;
					myInit.py1 = myInit.startingY;
					myInit.px2 = myBOpening.px2;
					myInit.py2 = myBOpening.py2;
					myInit.px3 = myInit.bX2;
					myInit.py3 = myInit.bY2;
					myInit.px4 = myInit.bX3;
					myInit.py4 = myInit.bY3;
					myInit.px5 = myInit.bX4;
					myInit.py5 = myInit.bY4;

				} else {
					myInit.px2 = myInit.bX2;
					myInit.py2 = myInit.bY2;
					myInit.px3 = myInit.bX3;
					myInit.py3 = myInit.bY3;
					myInit.px4 = myInit.bX4;
					myInit.py4 = myInit.bY4;

				}

			}
			if (myBOpening.noSidesTop == 3) {

				if (myInit.startingX < myBOpening.px2 && //
						myInit.bX2 > myBOpening.px2) {
					myInit.px2 = myBOpening.px2;
					myInit.py2 = myBOpening.py2;
					myInit.px3 = myInit.bX2;
					myInit.py3 = myInit.bY2;

					if (myInit.startingX < myBOpening.px3 && //
							myInit.bX2 > myBOpening.px3) {

						myInit.px3 = myBOpening.px3;
						myInit.py3 = myBOpening.py3;
						myInit.px4 = myInit.bX2;
						myInit.py4 = myInit.bY2;

					} else {
						myInit.px3 = myInit.bX2;
						myInit.py3 = myInit.bY2;

						myInit.px4 = myInit.bX3;
						myInit.py4 = myInit.bY3;
						myInit.px5 = myInit.bX4;
						myInit.py5 = myInit.bY4;

					}

				} else {
					myInit.px2 = myInit.bX2;
					myInit.py2 = myInit.bY2;

				}
			}

		}

		return myInit;
	}

	public void twoSidesTopXYPoints(final OpeningObject myInit) {

		myInit.px4 = myInit.bX3;
		myInit.py4 = myInit.bY3;
		myInit.px5 = myInit.bX4;
		myInit.py5 = myInit.bY4;

		myInit.noSidesBot = 1;

		if (myBOpening.noSidesBot > 1 && myInit.endRow == myBOpening.yRows) {
			if (myInit.px4 > myBOpening.px6
					&& //
					myInit.px5 < myBOpening.px6
					&& !(myInit.px4 > myBOpening.px7 && //
					myInit.px5 < myBOpening.px7)) {

				myInit.px5 = myBOpening.px6;
				myInit.py5 = myBOpening.py6;
				myInit.px6 = myInit.bX4;
				myInit.py6 = myInit.bY4;
				myInit.noSidesBot = 2;

			} else if (myInit.px4 > myBOpening.px7
					&& //
					myInit.px5 < myBOpening.px7
					&& !(myInit.px4 > myBOpening.px6 && //
					myInit.px5 < myBOpening.px6)) {

				myInit.px5 = myBOpening.px7;
				myInit.py5 = myBOpening.py7;
				myInit.px6 = myInit.bX4;
				myInit.py6 = myInit.bY4;
				myInit.noSidesBot = 2;

			} else if (myInit.px4 > myBOpening.px7
					&& //
					myInit.px5 < myBOpening.px7 && myInit.px4 > myBOpening.px6
					&& //
					myInit.px5 < myBOpening.px6) {

				myInit.px5 = myBOpening.px6;
				myInit.py5 = myBOpening.py6;
				myInit.px6 = myBOpening.px6;
				myInit.py6 = myBOpening.py6;
				myInit.px7 = myInit.bX4;
				myInit.py7 = myInit.bY4;
				myInit.noSidesBot = 3;

			}

		}//
	}

	public OpeningObject noSidesLeftRight(final OpeningObject myInit) {

		if (myInit.noSides == 3) {
			if (myInit.py1 == myInit.py4) {
				myInit.noSidesLeft = 0;
				myInit.noSidesRight = 1;

			} else if (myInit.py2 == myInit.py3) {
				myInit.noSidesLeft = 1;
				myInit.noSidesRight = 0;
			}
		} else if (myInit.noSides >= 4) {
			myInit.noSidesLeft = 1;
			myInit.noSidesRight = 1;
			if (myInit.py1 == myInit.py4) {
				myInit.noSidesLeft = 0;
				myInit.noSidesRight = 1;
				myInit.noSides = myInit.noSides - 1;
			} else if (myInit.py2 == myInit.py3) {
				myInit.noSidesLeft = 1;
				myInit.noSidesRight = 0;
				myInit.noSides = myInit.noSides - 1;
			}
		}

		return myInit;
	}

	public double intersectX(final double x1, final double y1, final double x2,
			final double y2, final double bx1, final double by1,
			final double bx2, final double by2) {

		BigDecimal x = new BigDecimal(0);
		final BigDecimal px = new BigDecimal(x1), py = new BigDecimal(y1), rx = new BigDecimal(
				x2).subtract(px), ry = new BigDecimal(y2).subtract(py);
		final BigDecimal qx = new BigDecimal(bx1), qy = new BigDecimal(by1), sx = new BigDecimal(
				bx2).subtract(qx), sy = new BigDecimal(by2).subtract(qy);

		final BigDecimal det = sx.multiply(ry).subtract(sy.multiply(rx));

		if (det.doubleValue() == 0) {
			return x.doubleValue();
		} else {
			BigDecimal pA = sx.multiply((qy.subtract(py)));
			BigDecimal pB = sy.multiply((px.subtract(qx)));
			final BigDecimal z = (pA.add(pB)).divide(det, 20,
					BigDecimal.ROUND_HALF_EVEN);
			// if (z == 0 || z == 1) {
			// return x; // intersection at end
			// point!
			// }
			// x = px + z * rx;// ,
			x = px.add((z.multiply(rx)));

			// (double)(py+z*ry));
		}
		return x.doubleValue();// , (double)(py+z*ry));

	} // end intersection line-line

	public double intersectY(final double x1, final double y1, final double x2,
			final double y2, final double bx1, final double by1,
			final double bx2, final double by2) {

		BigDecimal y = new BigDecimal(0);
		final BigDecimal px = new BigDecimal(x1), py = new BigDecimal(y1), rx = new BigDecimal(
				x2).subtract(px), ry = new BigDecimal(y2).subtract(py);
		final BigDecimal qx = new BigDecimal(bx1), qy = new BigDecimal(by1), sx = new BigDecimal(
				bx2).subtract(qx), sy = new BigDecimal(by2).subtract(qy);

		// final double det = sx * ry - sy * rx;
		final BigDecimal det = sx.multiply(ry).subtract(sy.multiply(rx));
		if (det.doubleValue() == 0) {
			return y.doubleValue();
		} else {
			// final double z = (sx * (qy - py) + sy * (px - qx)) / det;
			BigDecimal pA = sx.multiply((qy.subtract(py)));
			BigDecimal pB = sy.multiply((px.subtract(qx)));
			final BigDecimal z = (pA.add(pB)).divide(det, 20,
					BigDecimal.ROUND_HALF_EVEN);
			// if (z == 0 || z == 1) {
			// return y; // intersection at end
			// point!
			// }
			// y = py + z * ry;
			y = py.add(z.multiply(ry));
		}
		return y.doubleValue();
	} // end intersection l

	public double getDistance(final double x1, final double y1,
			final double x2, final double y2, final double clearance,
			final boolean isV) {

		double distance = clearance;
		double slopeofBLimit = 0;
		if (isV) {
			slopeofBLimit = (Math.max(y1, y2) - Math.min(y1, y2))
					/ (Math.max(x1, x2) - Math.min(x1, x2));
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

		return distance;
	}

	/**
	 * Do generalPath from OpeningObject
	 * 
	 * @param opening
	 *            , OpeningObject
	 * @return GeneralPath
	 */
	public GeneralPath doGeneralPathOpening(OpeningObject opening) {

		GeneralPath myOpen = new GeneralPath();

		myOpen.moveTo((int) opening.top1Part.startXC,
				(int) opening.top1Part.startYC);

		if (opening.top1Part.partForm == 2) {

			Arc2D mytop = new Arc2D.Double(opening.top1Part.bkgrdStartX,
					opening.top1Part.bkgrdStartY, opening.top1Part.bkgrdWidth,
					opening.top1Part.bkgrdHeight, opening.top1Part.startAngle,
					opening.top1Part.endAngle, Arc2D.OPEN);
			myOpen.append(mytop, false);
			myOpen.moveTo((int) opening.top1Part.endXC,
					(int) opening.top1Part.endYC);

		} else {
			myOpen.lineTo((int) opening.top1Part.endXC,
					(int) opening.top1Part.endYC);
		}

		if (opening.noSidesTop == 2) {

			if (opening.top2Part.partForm == 2) {

				Arc2D mytop = new Arc2D.Double(opening.top2Part.bkgrdStartX,
						opening.top2Part.bkgrdStartY,
						opening.top2Part.bkgrdWidth,
						opening.top2Part.bkgrdHeight,
						opening.top2Part.startAngle, opening.top2Part.endAngle,
						Arc2D.OPEN);
				myOpen.append(mytop, false);
				myOpen.moveTo((int) opening.top2Part.endXC,
						(int) opening.top2Part.endYC);

			} else {
				myOpen.lineTo((int) opening.top2Part.endXC,
						(int) opening.top2Part.endYC);
			}

		} else if (opening.noSidesTop == 3) {

			myOpen.lineTo((int) opening.top3Part.endXC,
					(int) opening.top3Part.endYC);

			if (opening.top2Part.partForm == 2) {

				Arc2D mytop = new Arc2D.Double(opening.top2Part.bkgrdStartX,
						opening.top2Part.bkgrdStartY,
						opening.top2Part.bkgrdWidth,
						opening.top2Part.bkgrdHeight,
						opening.top2Part.startAngle, opening.top2Part.endAngle,
						Arc2D.OPEN);
				myOpen.append(mytop, false);
				myOpen.moveTo((int) opening.top2Part.endXC,
						(int) opening.top2Part.endYC);
			} else {
				myOpen.lineTo((int) opening.top2Part.endXC,
						(int) opening.top2Part.endYC);
			}
		}

		if (opening.noSidesRight == 1) {

			myOpen.lineTo((int) opening.rightPart.endXC,
					(int) opening.rightPart.endYC);

		}

		if (opening.noSidesBot == 1 || opening.noSidesBot == 2) {

			if (opening.bot1Part.partForm == 2) {
				Arc2D mytop = new Arc2D.Double(opening.bot1Part.bkgrdStartX,
						opening.bot1Part.bkgrdStartY,
						opening.bot1Part.bkgrdWidth,
						opening.bot1Part.bkgrdHeight,
						opening.bot1Part.startAngle, opening.bot1Part.endAngle,
						Arc2D.OPEN);
				myOpen.append(mytop, false);

			} else {

				myOpen.lineTo((int) opening.bot1Part.endXC,
						(int) opening.bot1Part.endYC);
			}

			if (opening.bot2Part.partForm == 2 && opening.noSidesBot == 2) {

				Arc2D mytop = new Arc2D.Double(opening.bot2Part.bkgrdStartX,
						opening.bot2Part.bkgrdStartY,
						opening.bot2Part.bkgrdWidth,
						opening.bot2Part.bkgrdHeight,
						opening.bot2Part.startAngle, opening.bot2Part.endAngle,
						Arc2D.OPEN);
				myOpen.append(mytop, false);

			} else if (opening.bot2Part.partForm == 1
					&& opening.noSidesBot == 2) {
				myOpen.lineTo((int) opening.bot2Part.endXC,
						(int) opening.bot2Part.endYC);
			}

		} else if (opening.noSidesBot == 3) {

			if (opening.bot3Part.partForm == 2) {
				Arc2D mytop = new Arc2D.Double(opening.bot3Part.bkgrdStartX,
						opening.bot3Part.bkgrdStartY,
						opening.bot3Part.bkgrdWidth,
						opening.bot3Part.bkgrdHeight,
						opening.bot3Part.startAngle, opening.bot3Part.endAngle,
						Arc2D.OPEN);
				myOpen.append(mytop, false);

			} else {

				myOpen.lineTo((int) opening.bot3Part.endXC,
						(int) opening.bot3Part.endYC);
			}
			if (opening.bot1Part.partForm == 2) {

				Arc2D mytop = new Arc2D.Double(opening.bot1Part.bkgrdStartX,
						opening.bot1Part.bkgrdStartY,
						opening.bot1Part.bkgrdWidth,
						opening.bot1Part.bkgrdHeight,
						opening.bot1Part.startAngle, opening.bot1Part.endAngle,
						Arc2D.OPEN);
				myOpen.append(mytop, false);
			} else {

				myOpen.lineTo((int) opening.bot1Part.endXC,
						(int) opening.bot1Part.endYC);
			}
			if (opening.bot2Part.partForm == 2) {

				Arc2D mytop = new Arc2D.Double(opening.bot2Part.bkgrdStartX,
						opening.bot2Part.bkgrdStartY,
						opening.bot2Part.bkgrdWidth,
						opening.bot2Part.bkgrdHeight,
						opening.bot2Part.startAngle, opening.bot2Part.endAngle,
						Arc2D.OPEN);
				myOpen.append(mytop, false);

			} else {

				myOpen.lineTo((int) opening.bot2Part.endXC,
						(int) opening.bot2Part.endYC);
			}

		}

		if (opening.noSidesLeft == 1) {

			myOpen.lineTo((int) opening.leftPart.endXC,
					(int) opening.leftPart.endYC);

		}

		return myOpen;

	}

	public OpeningObject setPartforms(OpeningObject myInitOpening) {

		myInitOpening.top1Part.partForm = myParent.top1Part.partForm;

		myInitOpening.top2Part.partForm = myParent.top2Part.partForm;

		myInitOpening.top3Part.partForm = myParent.top3Part.partForm;

		myInitOpening.bot1Part.partForm = myParent.bot1Part.partForm;

		myInitOpening.bot2Part.partForm = myParent.bot2Part.partForm;

		myInitOpening.bot3Part.partForm = myParent.bot3Part.partForm;

		myInitOpening.leftPart.partForm = myParent.leftPart.partForm;

		myInitOpening.rightPart.partForm = myParent.rightPart.partForm;
		if (myParent.a_levelID == 3) {
			myInitOpening.rightPart.partForm = myParent.rightPart.partForm;
		}

		myInitOpening = this.doPartPos(myInitOpening);
		return myInitOpening;
	}

	public OpeningObject doPartPos(OpeningObject myInitOpening) {

		myInitOpening.top1Part.posInUse = true;
		myInitOpening.bot1Part.posInUse = true;
		myInitOpening.leftPart.posInUse = true;
		myInitOpening.rightPart.posInUse = true;

		myInitOpening.top2Part.posInUse = true;
		myInitOpening.top3Part.posInUse = true;
		myInitOpening.bot2Part.posInUse = true;
		myInitOpening.bot3Part.posInUse = true;

		if (!myParent.top1.posInUse) {
			myInitOpening.top1Part = new Profiles();
			myInitOpening.top1Part.posInUse = false;
		}
		if (!myParent.top2.posInUse || myInitOpening.noSidesTop < 2) {
			myInitOpening.top2Part = new Profiles();
			myInitOpening.top2Part.posInUse = false;
		}
		if (!myParent.top3.posInUse || myInitOpening.noSidesTop < 3) {
			myInitOpening.top3Part = new Profiles();
			myInitOpening.top3Part.posInUse = false;
		}
		if (!myParent.bot1.posInUse) {
			myInitOpening.bot1Part = new Profiles();
			myInitOpening.bot1Part.posInUse = false;
		}
		if (!myParent.bot2.posInUse || myInitOpening.noSidesBot < 2) {
			myInitOpening.bot2Part = new Profiles();
			myInitOpening.bot2Part.posInUse = false;
		}
		if (!myParent.bot3.posInUse || myInitOpening.noSidesBot < 3) {
			myInitOpening.bot3Part = new Profiles();
			myInitOpening.bot3Part.posInUse = false;
		}
		if (!myParent.left.posInUse || myInitOpening.noSidesLeft == 0) {
			myInitOpening.leftPart = new Profiles();
			myInitOpening.leftPart.posInUse = false;
		}
		if (!myParent.right.posInUse || myInitOpening.noSidesRight == 0) {
			myInitOpening.rightPart = new Profiles();
			myInitOpening.rightPart.posInUse = false;
		}

		return myInitOpening;
	}

	public BkgrdOpeningObject doBkgrdPartPos(BkgrdOpeningObject myInitOpening) {

		myInitOpening.top1Part.posInUse = true;
		myInitOpening.bot1Part.posInUse = true;
		myInitOpening.leftPart.posInUse = true;
		myInitOpening.rightPart.posInUse = true;

		myInitOpening.top2Part.posInUse = true;
		myInitOpening.top3Part.posInUse = true;
		myInitOpening.bot2Part.posInUse = true;
		myInitOpening.bot3Part.posInUse = true;

		if (!myParent.top1.posInUse) {
			myInitOpening.top1Part = new Profiles();
			myInitOpening.top1Part.posInUse = false;
		}
		if (!myParent.top2.posInUse || myInitOpening.noSidesTop < 2) {
			myInitOpening.top2Part = new Profiles();
			myInitOpening.top2Part.posInUse = false;
		}
		if (!myParent.top3.posInUse || myInitOpening.noSidesTop < 3) {
			myInitOpening.top3Part = new Profiles();
			myInitOpening.top3Part.posInUse = false;
		}
		if (!myParent.bot1.posInUse) {
			myInitOpening.bot1Part = new Profiles();
			myInitOpening.bot1Part.posInUse = false;
		}
		if (!myParent.bot2.posInUse || myInitOpening.noSidesBot < 2) {
			myInitOpening.bot2Part = new Profiles();
			myInitOpening.bot2Part.posInUse = false;
		}
		if (!myParent.bot3.posInUse || myInitOpening.noSidesBot < 3) {
			myInitOpening.bot3Part = new Profiles();
			myInitOpening.bot3Part.posInUse = false;
		}
		if (!myParent.left.posInUse || myInitOpening.noSidesLeft == 0) {
			myInitOpening.leftPart = new Profiles();
			myInitOpening.leftPart.posInUse = false;
		}
		if (!myParent.right.posInUse || myInitOpening.noSidesRight == 0) {
			myInitOpening.rightPart = new Profiles();
			myInitOpening.rightPart.posInUse = false;
		}

		return myInitOpening;
	}

	public Object[] setPartDims(OpeningObject myInitOpening,
			CreateShapeMethods createShape) {

		final Object[] myreturns = new Object[2];

		myInitOpening.options.clear();
		if (myFrame2.doOptions) {
			myInitOpening.executeOptionRules("createOpening.addmullionV.11406");
		}
		myInitOpening.bom.clear();
		myInitOpening.clearBomForShape();

		myInitOpening.executePartRules(false, false,
				"createOpening.addmullionV.11410");

		myInitOpening.top1Part.lengthMN = (int) (myInitOpening.top1Part.length / myFrame2.metricscale
				.doubleValue());
		myInitOpening.top1Part.lengthIN = (int) (myInitOpening.top1Part.length / myFrame2.imperialscale
				.doubleValue());

		myInitOpening.top2Part.lengthMN = (int) (myInitOpening.top2Part.length / myFrame2.metricscale
				.doubleValue());
		myInitOpening.top2Part.lengthIN = (int) (myInitOpening.top2Part.length / myFrame2.imperialscale
				.doubleValue());

		myInitOpening.top3Part.lengthMN = (int) (myInitOpening.top3Part.length / myFrame2.metricscale
				.doubleValue());
		myInitOpening.top3Part.lengthIN = (int) (myInitOpening.top3Part.length / myFrame2.imperialscale
				.doubleValue());

		myInitOpening.bot1Part.lengthMN = (int) (myInitOpening.bot1Part.length / myFrame2.metricscale
				.doubleValue());
		myInitOpening.bot1Part.lengthIN = (int) (myInitOpening.bot1Part.length / myFrame2.imperialscale
				.doubleValue());

		myInitOpening.bot2Part.lengthMN = (int) (myInitOpening.bot2Part.length / myFrame2.metricscale
				.doubleValue());
		myInitOpening.bot2Part.lengthIN = (int) (myInitOpening.bot2Part.length / myFrame2.imperialscale
				.doubleValue());

		myInitOpening.bot3Part.lengthMN = (int) (myInitOpening.bot3Part.length / myFrame2.metricscale
				.doubleValue());
		myInitOpening.bot3Part.lengthIN = (int) (myInitOpening.bot3Part.length / myFrame2.imperialscale
				.doubleValue());

		myInitOpening.leftPart.lengthMN = (int) (myInitOpening.leftPart.length / myFrame2.metricscale
				.doubleValue());
		myInitOpening.leftPart.lengthIN = (int) (myInitOpening.leftPart.length / myFrame2.imperialscale
				.doubleValue());

		myInitOpening.rightPart.lengthMN = (int) (myInitOpening.rightPart.length / myFrame2.metricscale
				.doubleValue());
		myInitOpening.rightPart.lengthIN = (int) (myInitOpening.rightPart.length / myFrame2.imperialscale
				.doubleValue());

		myInitOpening = (OpeningObject) this.myFrame2.shapeColor
				.setShapeObjectPartColors(myInitOpening);

		if (myFrame2.mySeries.getSeriesUom() == 1) {
			createShape.top1DimBo = createShape.top1DimB = myInitOpening.top1Part.partDimB;
			createShape.top1DimAo = createShape.top1DimA = myInitOpening.top1Part.partDimA;
			createShape.top1DimCo = createShape.top1DimC = myInitOpening.top1Part.partDimC;
			createShape.top1DimMo = createShape.top1DimM = myInitOpening.top1Part.partDimM;
			createShape.top2DimBo = createShape.top2DimB = myInitOpening.top2Part.partDimB;
			createShape.top2DimAo = createShape.top2DimA = myInitOpening.top2Part.partDimA;
			createShape.top2DimCo = createShape.top2DimC = myInitOpening.top2Part.partDimC;
			createShape.top2DimMo = createShape.top2DimM = myInitOpening.top2Part.partDimM;
			createShape.top3DimBo = createShape.top3DimB = myInitOpening.top3Part.partDimB;
			createShape.top3DimAo = createShape.top3DimA = myInitOpening.top3Part.partDimA;
			createShape.top3DimCo = createShape.top3DimC = myInitOpening.top3Part.partDimC;
			createShape.top3DimMo = createShape.top3DimM = myInitOpening.top3Part.partDimM;

			createShape.bot1DimBo = createShape.bot1DimB = myInitOpening.bot1Part.partDimB;
			createShape.bot1DimAo = createShape.bot1DimA = myInitOpening.bot1Part.partDimA;
			createShape.bot1DimCo = createShape.bot1DimC = myInitOpening.bot1Part.partDimC;
			createShape.bot1DimMo = createShape.bot1DimM = myInitOpening.bot1Part.partDimM;
			createShape.bot2DimBo = createShape.bot2DimB = myInitOpening.bot2Part.partDimB;
			createShape.bot2DimAo = createShape.bot2DimA = myInitOpening.bot2Part.partDimA;
			createShape.bot2DimCo = createShape.bot2DimC = myInitOpening.bot2Part.partDimC;
			createShape.bot2DimMo = createShape.bot2DimM = myInitOpening.bot2Part.partDimM;
			createShape.bot3DimBo = createShape.bot3DimB = myInitOpening.bot3Part.partDimB;
			createShape.bot3DimAo = createShape.bot3DimA = myInitOpening.bot3Part.partDimA;
			createShape.bot3DimCo = createShape.bot3DimC = myInitOpening.bot3Part.partDimC;
			createShape.bot3DimMo = createShape.bot3DimM = myInitOpening.bot3Part.partDimM;

			createShape.leftDimBo = createShape.leftDimB = myInitOpening.leftPart.partDimB;
			createShape.leftDimAo = createShape.leftDimA = myInitOpening.leftPart.partDimA;
			createShape.leftDimCo = createShape.leftDimC = myInitOpening.leftPart.partDimC;
			createShape.leftDimMo = createShape.leftDimM = myInitOpening.leftPart.partDimM;
			createShape.rightDimBo = createShape.rightDimB = myInitOpening.rightPart.partDimB;
			createShape.rightDimAo = createShape.rightDimA = myInitOpening.rightPart.partDimA;
			createShape.rightDimCo = createShape.rightDimC = myInitOpening.rightPart.partDimC;
			createShape.rightDimMo = createShape.rightDimM = myInitOpening.rightPart.partDimM;
		} else {
			createShape.top1DimBo = createShape.top1DimB = myInitOpening.top1Part.partDimBi;
			createShape.top1DimAo = createShape.top1DimA = myInitOpening.top1Part.partDimAi;
			createShape.top1DimCo = createShape.top1DimC = myInitOpening.top1Part.partDimCi;
			createShape.top1DimMo = createShape.top1DimM = myInitOpening.top1Part.partDimMi;
			createShape.top2DimBo = createShape.top2DimB = myInitOpening.top2Part.partDimBi;
			createShape.top2DimAo = createShape.top2DimA = myInitOpening.top2Part.partDimAi;
			createShape.top2DimCo = createShape.top2DimC = myInitOpening.top2Part.partDimCi;
			createShape.top2DimMo = createShape.top2DimM = myInitOpening.top2Part.partDimMi;
			createShape.top3DimBo = createShape.top3DimB = myInitOpening.top3Part.partDimBi;
			createShape.top3DimAo = createShape.top3DimA = myInitOpening.top3Part.partDimAi;
			createShape.top3DimCo = createShape.top3DimC = myInitOpening.top3Part.partDimCi;
			createShape.top3DimMo = createShape.top3DimM = myInitOpening.top3Part.partDimMi;

			createShape.bot1DimBo = createShape.bot1DimB = myInitOpening.bot1Part.partDimBi;
			createShape.bot1DimAo = createShape.bot1DimA = myInitOpening.bot1Part.partDimAi;
			createShape.bot1DimCo = createShape.bot1DimC = myInitOpening.bot1Part.partDimCi;
			createShape.bot1DimMo = createShape.bot1DimM = myInitOpening.bot1Part.partDimMi;
			createShape.bot2DimBo = createShape.bot2DimB = myInitOpening.bot2Part.partDimBi;
			createShape.bot2DimAo = createShape.bot2DimA = myInitOpening.bot2Part.partDimAi;
			createShape.bot2DimCo = createShape.bot2DimC = myInitOpening.bot2Part.partDimCi;
			createShape.bot2DimMo = createShape.bot2DimM = myInitOpening.bot2Part.partDimMi;
			createShape.bot3DimBo = createShape.bot3DimB = myInitOpening.bot3Part.partDimBi;
			createShape.bot3DimAo = createShape.bot3DimA = myInitOpening.bot3Part.partDimAi;
			createShape.bot3DimCo = createShape.bot3DimC = myInitOpening.bot3Part.partDimCi;
			createShape.bot3DimMo = createShape.bot3DimM = myInitOpening.bot3Part.partDimMi;

			createShape.leftDimBo = createShape.leftDimB = myInitOpening.leftPart.partDimBi;
			createShape.leftDimAo = createShape.leftDimA = myInitOpening.leftPart.partDimAi;
			createShape.leftDimCo = createShape.leftDimC = myInitOpening.leftPart.partDimCi;
			createShape.leftDimMo = createShape.leftDimM = myInitOpening.leftPart.partDimMi;
			createShape.rightDimBo = createShape.rightDimB = myInitOpening.rightPart.partDimBi;
			createShape.rightDimAo = createShape.rightDimA = myInitOpening.rightPart.partDimAi;
			createShape.rightDimCo = createShape.rightDimC = myInitOpening.rightPart.partDimCi;
			createShape.rightDimMo = createShape.rightDimM = myInitOpening.rightPart.partDimMi;
		}

		myreturns[0] = myInitOpening;
		myreturns[1] = createShape;
		return myreturns;
	}

	/**
	 * Do GeneralPath Main Opening
	 * 
	 * @param opening
	 *            , OpeningObject
	 * @return GeneralPath
	 */
	public GeneralPath doGeneralPathMainOpening(OpeningObject opening) {

		// this.myParent.myOpenings.reset();

		// GeneralPath
		GeneralPath myOpen = new GeneralPath();

		myOpen.moveTo((int) opening.top1Part.startXC,
				(int) opening.top1Part.startYC);

		if (opening.top1Part.partForm == 2) {

			Arc2D mytop = new Arc2D.Double(opening.top1Part.bkgrdStartX,
					opening.top1Part.bkgrdStartY, opening.top1Part.bkgrdWidth,
					opening.top1Part.bkgrdHeight, opening.top1Part.startAngle,
					opening.top1Part.endAngle, Arc2D.OPEN);
			myOpen.append(mytop, false);
			myOpen.moveTo((int) opening.top1Part.endXC,
					(int) opening.top1Part.endYC);

		} else {
			myOpen.lineTo((int) opening.top1Part.endXC,
					(int) opening.top1Part.endYC);
		}

		if (opening.noSidesTop == 2) {

			if (opening.top2Part.partForm == 2) {

				Arc2D mytop = new Arc2D.Double(opening.top2Part.bkgrdStartX,
						opening.top2Part.bkgrdStartY,
						opening.top2Part.bkgrdWidth,
						opening.top2Part.bkgrdHeight,
						opening.top2Part.startAngle, opening.top2Part.endAngle,
						Arc2D.OPEN);
				myOpen.append(mytop, false);
				myOpen.moveTo((int) opening.top2Part.endXC,
						(int) opening.top2Part.endYC);

			} else {
				myOpen.lineTo((int) opening.top2Part.endXC,
						(int) opening.top2Part.endYC);
			}

		} else if (opening.noSidesTop == 3) {

			myOpen.lineTo((int) opening.top3Part.endXC,
					(int) opening.top3Part.endYC);

			if (opening.top2Part.partForm == 2) {

				Arc2D mytop = new Arc2D.Double(opening.top2Part.bkgrdStartX,
						opening.top2Part.bkgrdStartY,
						opening.top2Part.bkgrdWidth,
						opening.top2Part.bkgrdHeight,
						opening.top2Part.startAngle, opening.top2Part.endAngle,
						Arc2D.OPEN);
				myOpen.append(mytop, false);
				myOpen.moveTo((int) opening.top2Part.endXC,
						(int) opening.top2Part.endYC);

			} else {
				myOpen.lineTo((int) opening.top2Part.endXC,
						(int) opening.top2Part.endYC);
			}
		}

		if (opening.noSidesRight == 1) {
			myOpen.lineTo((int) opening.rightPart.endXC,
					(int) opening.rightPart.endYC);
		}

		if (opening.noSidesBot == 1 || opening.noSidesBot == 2) {

			if (opening.bot1Part.partForm == 2) {

				Arc2D mytop = new Arc2D.Double(opening.bot1Part.bkgrdStartX,
						opening.bot1Part.bkgrdStartY,
						opening.bot1Part.bkgrdWidth,
						opening.bot1Part.bkgrdHeight,
						opening.bot1Part.startAngle, opening.bot1Part.endAngle,
						Arc2D.OPEN);
				myOpen.append(mytop, false);

			} else {
				myOpen.lineTo((int) opening.bot1Part.endXC,
						(int) opening.bot1Part.endYC);
			}
			if (opening.bot2Part.partForm == 2 && opening.noSidesBot == 2) {

				Arc2D mytop = new Arc2D.Double(opening.bot2Part.bkgrdStartX,
						opening.bot2Part.bkgrdStartY,
						opening.bot2Part.bkgrdWidth,
						opening.bot2Part.bkgrdHeight,
						opening.bot2Part.startAngle, opening.bot2Part.endAngle,
						Arc2D.OPEN);
				myOpen.append(mytop, false);
			} else if (opening.bot2Part.partForm == 1
					&& opening.noSidesBot == 2) {
				myOpen.lineTo((int) opening.bot2Part.endXC,
						(int) opening.bot2Part.endYC);
			}

		} else if (opening.noSidesBot == 3) {

			if (opening.bot1Part.partForm == 2) {
				Arc2D mytop = new Arc2D.Double(opening.bot1Part.bkgrdStartX,
						opening.bot1Part.bkgrdStartY,
						opening.bot1Part.bkgrdWidth,
						opening.bot1Part.bkgrdHeight,
						opening.bot1Part.startAngle, opening.bot3Part.endAngle,
						Arc2D.OPEN);
				myOpen.append(mytop, false);
			} else {
				myOpen.lineTo((int) opening.bot1Part.endXC,
						(int) opening.bot1Part.endYC);
			}

			if (opening.bot3Part.partForm == 2) {
				Arc2D mytop = new Arc2D.Double(opening.bot3Part.bkgrdStartX,
						opening.bot3Part.bkgrdStartY,
						opening.bot3Part.bkgrdWidth,
						opening.bot3Part.bkgrdHeight,
						opening.bot3Part.startAngle, opening.bot3Part.endAngle,
						Arc2D.OPEN);
				myOpen.append(mytop, false);
			} else {
				myOpen.lineTo((int) opening.bot3Part.endXC,
						(int) opening.bot3Part.endYC);
			}

			if (opening.bot2Part.partForm == 2) {

				Arc2D mytop = new Arc2D.Double(opening.bot2Part.bkgrdStartX,
						opening.bot2Part.bkgrdStartY,
						opening.bot2Part.bkgrdWidth,
						opening.bot2Part.bkgrdHeight,
						opening.bot2Part.startAngle, opening.bot2Part.endAngle,
						Arc2D.OPEN);
				myOpen.append(mytop, false);
			} else {
				myOpen.lineTo((int) opening.bot2Part.endXC,
						(int) opening.bot2Part.endYC);
			}

		}

		if (opening.noSidesLeft == 1) {
			myOpen.lineTo((int) opening.leftPart.endXC,
					(int) opening.leftPart.endYC);
		}

		// this.myParent.myOpenings.append(myOpen, false);
		return myOpen;
	}

	/**
	 * Do General Path BkgrdOpening object
	 * 
	 * @param opening
	 *            , BkgrdOpeningObject
	 * @return GeneralPath
	 */
	public GeneralPath doGeneralPathBkgrdOpening(BkgrdOpeningObject opening) {

		// this.myParent.myOpenings.reset();
		GeneralPath myOpen = new GeneralPath();

		myOpen.moveTo((int) opening.top1Part.startXC,
				(int) opening.top1Part.startYC);

		if (opening.top1Part.partForm == 2) {
			Arc2D mytop = new Arc2D.Double(opening.top1Part.bkgrdStartX,
					opening.top1Part.bkgrdStartY, opening.top1Part.bkgrdWidth,
					opening.top1Part.bkgrdHeight, opening.top1Part.startAngle,
					opening.top1Part.endAngle, Arc2D.OPEN);
			myOpen.append(mytop, false);
			myOpen.moveTo((int) opening.top1Part.endXC,
					(int) opening.top1Part.endYC);
		} else {
			myOpen.lineTo((int) opening.top1Part.endXC,
					(int) opening.top1Part.endYC);
		}

		if (opening.noSidesTop == 2) {

			if (opening.top2Part.partForm == 2) {

				Arc2D mytop = new Arc2D.Double(opening.top2Part.bkgrdStartX,
						opening.top2Part.bkgrdStartY,
						opening.top2Part.bkgrdWidth,
						opening.top2Part.bkgrdHeight,
						opening.top2Part.startAngle, opening.top2Part.endAngle,
						Arc2D.OPEN);
				myOpen.append(mytop, false);
				myOpen.moveTo((int) opening.top2Part.endXC,
						(int) opening.top2Part.endYC);

			} else {
				myOpen.lineTo((int) opening.top2Part.endXC,
						(int) opening.top2Part.endYC);
			}

		} else if (opening.noSidesTop == 3) {

			myOpen.lineTo((int) opening.top3Part.endXC,
					(int) opening.top3Part.endYC);

			if (opening.top2Part.partForm == 2) {

				Arc2D mytop = new Arc2D.Double(opening.top2Part.bkgrdStartX,
						opening.top2Part.bkgrdStartY,
						opening.top2Part.bkgrdWidth,
						opening.top2Part.bkgrdHeight,
						opening.top2Part.startAngle, opening.top2Part.endAngle,
						Arc2D.OPEN);
				myOpen.append(mytop, false);
				myOpen.moveTo((int) opening.top2Part.endXC,
						(int) opening.top2Part.endYC);
			} else {
				myOpen.lineTo((int) opening.top2Part.endXC,
						(int) opening.top2Part.endYC);
			}
		}

		if (opening.noSidesRight == 1) {

			myOpen.lineTo((int) opening.rightPart.endXC,
					(int) opening.rightPart.endYC);

		}

		if (opening.noSidesBot == 1 || opening.noSidesBot == 2) {

			if (opening.bot1Part.partForm == 2) {

				Arc2D mytop = new Arc2D.Double(opening.bot1Part.bkgrdStartX,
						opening.bot1Part.bkgrdStartY,
						opening.bot1Part.bkgrdWidth,
						opening.bot1Part.bkgrdHeight,
						opening.bot1Part.startAngle, opening.bot1Part.endAngle,
						Arc2D.OPEN);
				myOpen.append(mytop, false);

			} else {
				myOpen.lineTo((int) opening.bot1Part.endXC,
						(int) opening.bot1Part.endYC);
			}

			if (opening.bot2Part.partForm == 2 && opening.noSidesBot == 2) {
				Arc2D mytop = new Arc2D.Double(opening.bot2Part.bkgrdStartX,
						opening.bot2Part.bkgrdStartY,
						opening.bot2Part.bkgrdWidth,
						opening.bot2Part.bkgrdHeight,
						opening.bot2Part.startAngle, opening.bot2Part.endAngle,
						Arc2D.OPEN);
				myOpen.append(mytop, false);
			} else if (opening.bot2Part.partForm == 1
					&& opening.noSidesBot == 2) {
				myOpen.lineTo((int) opening.bot2Part.endXC,
						(int) opening.bot2Part.endYC);
			}
		} else if (opening.noSidesBot == 3) {

			if (opening.bot1Part.partForm == 2) {
				Arc2D mytop = new Arc2D.Double(opening.bot1Part.bkgrdStartX,
						opening.bot1Part.bkgrdStartY,
						opening.bot1Part.bkgrdWidth,
						opening.bot1Part.bkgrdHeight,
						opening.bot1Part.startAngle, opening.bot3Part.endAngle,
						Arc2D.OPEN);
				myOpen.append(mytop, false);
			} else {
				myOpen.lineTo((int) opening.bot1Part.endXC,
						(int) opening.bot1Part.endYC);
			}
			if (opening.bot3Part.partForm == 2) {
				Arc2D mytop = new Arc2D.Double(opening.bot3Part.bkgrdStartX,
						opening.bot3Part.bkgrdStartY,
						opening.bot3Part.bkgrdWidth,
						opening.bot3Part.bkgrdHeight,
						opening.bot3Part.startAngle, opening.bot3Part.endAngle,
						Arc2D.OPEN);
				myOpen.append(mytop, false);
			} else {
				myOpen.lineTo((int) opening.bot3Part.endXC,
						(int) opening.bot3Part.endYC);
			}
			if (opening.bot2Part.partForm == 2) {
				Arc2D mytop = new Arc2D.Double(opening.bot2Part.bkgrdStartX,
						opening.bot2Part.bkgrdStartY,
						opening.bot2Part.bkgrdWidth,
						opening.bot2Part.bkgrdHeight,
						opening.bot2Part.startAngle, opening.bot2Part.endAngle,
						Arc2D.OPEN);
				myOpen.append(mytop, false);
			} else {
				myOpen.lineTo((int) opening.bot2Part.endXC,
						(int) opening.bot2Part.endYC);
			}

		}

		if (opening.noSidesLeft == 1) {

			myOpen.lineTo((int) opening.leftPart.endXC,
					(int) opening.leftPart.endYC);

		}

		return myOpen;
	}

	public void checkAutoPolygons() {

		if (myParent.shapeID >= 90 && myParent.shapeID <= 100) {
			wt = myParent.widthPix;
			wb = wt;
			hl = myParent.heightPix;
			hr = hl;
			wtc = myParent.widthPix;
			wbc = myParent.widthPix;
		}
	}

	/**
	 * Do Frame OpeningObject
	 * 
	 * @param myBkgrdOpen
	 *            , BkgrdOpeningObject
	 * @param newopening
	 *            , OpeningObject
	 * @return OpeningObject
	 */
	public OpeningObject doFrameOpening(BkgrdOpeningObject myBkgrdOpen,
			OpeningObject newopening) throws Exception {

		// Creating opening object
		OpeningObject newOpening = new OpeningObject(myFrame2);

		// Cloning BkgrdOpeningObject to OpeningObject
		newOpening = newOpening.cloneOpeningFromBkgrdO(newOpening, myBkgrdOpen);

		if (myBkgrdOpen.myParent.controlOpeningClassType > 1) {

			newOpening.contentMid = myBkgrdOpen.myParent.controlOpeningClassType;

		}

		// Instantiate create shape methods
		CreateShapeMethods createShape = new CreateShapeMethods(newOpening, 2,
				myFrame2);

		// newOpening = (OpeningObject) createShape.doShapeBkgrd(newOpening);

		// Setting px and py points
		createShape.setpXpY(newOpening.px1, newOpening.py1, newOpening.px2,
				newOpening.py2, newOpening.px3, newOpening.py3, newOpening.px4,
				newOpening.py4, newOpening.px5, newOpening.py5, newOpening.px6,
				newOpening.py6, newOpening.px7, newOpening.py7, newOpening.px8,
				newOpening.py8, newOpening.px1c, newOpening.py1c,
				newOpening.px2c, newOpening.py2c, newOpening.px3c,
				newOpening.py3c, newOpening.px4c, newOpening.py4c,
				newOpening.px5c, newOpening.py5c, newOpening.px6c,
				newOpening.py6c, newOpening.px7c, newOpening.py7c,
				newOpening.px8c, newOpening.py8c, newOpening.px1,
				newOpening.py1, newOpening.px2, newOpening.py2, newOpening.px3,
				newOpening.py3, newOpening.px4, newOpening.py4, newOpening.px5,
				newOpening.py5, newOpening.px6, newOpening.py6, newOpening.px7,
				newOpening.py7, newOpening.px8, newOpening.py8,
				newOpening.px1A, newOpening.py1A, newOpening.px2A,
				newOpening.py2A, newOpening.px3A, newOpening.py3A,
				newOpening.px4A, newOpening.py4A, newOpening.px5A,
				newOpening.py5A, newOpening.px6A, newOpening.py6A,
				newOpening.px7A, newOpening.py7A, newOpening.px8A,
				newOpening.py8A, newOpening.px1, newOpening.py1,
				newOpening.px2, newOpening.py2, newOpening.px3, newOpening.py3,
				newOpening.px4, newOpening.py4, newOpening.px5, newOpening.py5,
				newOpening.px6, newOpening.py6, newOpening.px7, newOpening.py7,
				newOpening.px8, newOpening.py8);

		// Make parts for OpeningObject

		newOpening = (OpeningObject) createShape.setOpeningDims(newOpening);

		newOpening = (OpeningObject) createShape.makeSides(newOpening);

		newOpening = (OpeningObject) setProfileLength(newOpening);

		// newOpening = (OpeningObject)
		// createShape.makeSidesStraight(newOpening);

		newOpening.top1Part.endTypeLT = 1;
		newOpening.top1Part.endTypeRB = 1;
		newOpening.top2Part.endTypeLT = 1;
		newOpening.top2Part.endTypeRB = 1;
		newOpening.top3Part.endTypeLT = 1;
		newOpening.top3Part.endTypeRB = 1;
		newOpening.bot1Part.endTypeLT = 1;
		newOpening.bot1Part.endTypeRB = 1;
		newOpening.bot2Part.endTypeLT = 1;
		newOpening.bot2Part.endTypeRB = 1;
		newOpening.bot2Part.endTypeLT = 1;
		newOpening.bot2Part.endTypeRB = 1;
		newOpening.leftPart.endTypeLT = 1;
		newOpening.leftPart.endTypeRB = 1;
		newOpening.rightPart.endTypeLT = 1;
		newOpening.rightPart.endTypeRB = 1;

		// newOpening = (OpeningObject) createShape.doParts(newOpening, true);

		// Setting base info
		newOpening = (OpeningObject) createShape.setBaseInfo(newOpening, 2,
				false);

		newOpening.partObjects = createShape
				.setPartObjectsAndCollection(newOpening);

		createShape = null;

		// Creating general path Opening
		newOpening.gp = this.doGeneralPathMainOpening(newOpening);

		// Do main opening glazing
		if (myParent.a_levelID == 3 && newopening == null
				|| myParent.a_levelID == 12) {

			this.doMainOpeningGlazing(myBkgrdOpen, newOpening);

		}

		newOpening.options.clear();
		if (myFrame2.doOptions) {
			newOpening
					.executeOptionRules("createOpening.doFrameOpening.11839 - OK  opening to parent Shape");
		}

		newOpening.bom.clear();
		newOpening.clearBomForShape();
		newOpening
				.executePartRules(true, true,
						"createOpening.doFrameOpening.11843 - OK  opening to parent Shape");

		return newOpening;
	}

	public OpeningObject doMainOpeningGlazing(BkgrdOpeningObject myNewOpening,
			OpeningObject newOpening) throws Exception {

		if (myNewOpening.xCols <= 1 && myNewOpening.yRows <= 1) {

			CreateGlass createGlass = new CreateGlass(newOpening, myFrame2);
			CreateGlazingStops createStops = new CreateGlazingStops(newOpening,
					myFrame2);
			OpeningObject dloOp = new OpeningObject();
			CreateDLO createDLO = new CreateDLO(dloOp, myFrame2);

			CreateSash createSash;

			GlazingBeads glazingBeads = new GlazingBeads(newOpening, myFrame2);

			if (newOpening.contentIn == 1) {

				SUType suType = null;

				if (newOpening.myGlassIn != null
						&& newOpening.myGlassIn.suID > 0) {
					suType = ItemFrame.getApplicationBaseRules().getSUType(
							newOpening.myGlassIn.suID);
				} else {
					suType = myFrame2.mySelectedSUIn;
				}

				glazingBeads = createStops.doBeads(suType);

				newOpening.glazingBeadsIn = glazingBeads.partObjects;
				newOpening.glazingBeadIn = glazingBeads;

				if (!newOpening.unGlazed) {
					newOpening.myGlassIn = createGlass.doGlass(suType);

					createDLO = new CreateDLO(
							createDLO.myParentFO.cloneOpeningFromBkgrdO(
									createDLO.myParentFO,
									glazingBeads.bOpeningObject), myFrame2);

					newOpening.dloIn = createDLO.doDLO();

					newOpening.dloIn.myParentGlass = newOpening.myGlassIn;
					newOpening.dloIn.myParentO = newOpening.myGlassIn.myParentO;
					newOpening.dloIn.myParent = newOpening.myGlassIn.myParentO.myParent;
					newOpening.dloIn.myFacet = newOpening.myParent.myFacet;
				}

			} else if (newOpening.sashObjectIn != null
					&& newOpening.contentIn == 2) {

				Collection mySashLeafs = newOpening.sashObjectIn.frames;

				createSash = this.doSashInOpening(newOpening, mySashLeafs);
				newOpening = createSash.doNewSash(newOpening.sashObjectIn,
						false, mySashLeafs);

			}

			if (newOpening.contentMid == 1) {

				SUType suType = null;

				if (newOpening.myGlassMid != null
						&& newOpening.myGlassMid.suID > 0) {
					suType = ItemFrame.getApplicationBaseRules().getSUType(
							newOpening.myGlassMid.suID);
				} else {
					suType = myFrame2.mySelectedSUMid;
				}

				glazingBeads = createStops.doBeads(suType);

				newOpening.glazingBeadsMid = glazingBeads.partObjects;
				newOpening.glazingBeadMid = glazingBeads;

				if (!newOpening.unGlazed) {

					newOpening.myGlassMid = createGlass.doGlass(suType);

					// Correct parent Openign for DLO
					// Apply to all positions
					createDLO = new CreateDLO(
							createDLO.myParentFO.cloneOpeningFromBkgrdO(
									createDLO.myParentFO,
									glazingBeads.bOpeningObject), myFrame2);

					newOpening.dloMid = createDLO.doDLO();
					newOpening.dloMid.bOpeningObject.myFrame2 = myFrame2;

					newOpening.dloMid.myParentGlass = newOpening.myGlassMid;
					newOpening.dloMid.myParentO = newOpening.myGlassMid.myParentO;
					newOpening.dloMid.myParent = newOpening.myGlassMid.myParentO.myParent;
					newOpening.dloMid.myFacet = newOpening.myParent.myFacet;
				}

			} else if (newOpening.sashObjectMid != null
					&& newOpening.contentMid == 2) {

				Collection mySashLeafs = newOpening.sashObjectMid.frames;

				createSash = this.doSashInOpening(newOpening, mySashLeafs);
				newOpening = createSash.doNewSash(newOpening.sashObjectMid,
						false, mySashLeafs);
			}

			if (newOpening.contentOut == 1) {

				SUType suType = null;

				if (newOpening.myGlassOut != null
						&& newOpening.myGlassOut.suID > 0) {
					suType = ItemFrame.getApplicationBaseRules().getSUType(
							newOpening.myGlassOut.suID);
				} else {
					suType = myFrame2.mySelectedSUOut;
				}

				glazingBeads = createStops.doBeads(suType);

				newOpening.glazingBeadsOut = glazingBeads.partObjects;
				newOpening.glazingBeadOut = glazingBeads;

				if (!newOpening.unGlazed) {
					newOpening.myGlassOut = createGlass.doGlass(suType);

					createDLO = new CreateDLO(
							createDLO.myParentFO.cloneOpeningFromBkgrdO(
									createDLO.myParentFO,
									glazingBeads.bOpeningObject), myFrame2);

					newOpening.dloOut = createDLO.doDLO();

					newOpening.dloOut.myParentGlass = newOpening.myGlassOut;
					newOpening.dloOut.myParentO = newOpening.myGlassOut.myParentO;
					newOpening.dloOut.myParent = newOpening.myGlassOut.myParentO.myParent;
					newOpening.dloOut.myFacet = newOpening.myParent.myFacet;
				}

			} else if (newOpening.sashObjectOut != null
					&& newOpening.contentOut == 2) {

				Collection mySashLeafs = newOpening.sashObjectOut.frames;

				createSash = this.doSashInOpening(newOpening, mySashLeafs);
				newOpening = createSash.doNewSash(newOpening.sashObjectOut,
						false, mySashLeafs);
			}
		}

		return newOpening;
	}

	public ShapeObject setProfileLength(ShapeObject myShape) {

		if (myShape.top1Part.partForm == 1) {
			myShape.top1Part.length = Math
					.sqrt(Math.pow((Math.max(myShape.top1Part.endX,
							myShape.top1Part.startX) - Math.min(
							myShape.top1Part.endX, myShape.top1Part.startX)), 2)
							+ Math.pow((Math.max(myShape.top1Part.endY,
									myShape.top1Part.startY) - Math.min(
									myShape.top1Part.endY,
									myShape.top1Part.startY)), 2));

			myShape.top1Part.lengthM = (int) (new BigDecimal(
					myShape.top1Part.length).divide(myFrame2.metricscale, 20,
					BigDecimal.ROUND_UP)).doubleValue();

			myShape.top1Part.lengthI = (int) (new BigDecimal(
					myShape.top1Part.length).divide(myFrame2.imperialscale, 20,
					BigDecimal.ROUND_UP)).doubleValue();

		} else if (myShape.top1Part.partForm == 2) {
			myShape.top1Part.length = 2 * Math.PI * myShape.top1Part.radius1
					* myShape.top1Part.centralAngle / 360;

		} else if (myShape.top1Part.partForm == 3) {
			double w = myShape.widthPix;
			final double h1 = Math.pow((myShape.dimB1 - w / 2), 2)
					/ Math.pow((myShape.dimB1 + w / 2), 2);
			final double factorial = 1
					+ 0.25f
					* h1
					+ 1
					/ 64
					* (Math.pow(h1, 2) + 1 / 256 * Math.pow(h1, 3) + 25 / 16384 * Math
							.pow(h1, 4));

			myShape.top1Part.length = Math.PI * (w / 2 + myShape.dimB1)
					* factorial;

		}

		if (myShape.top2Part.partForm == 1) {
			myShape.top2Part.length = Math
					.sqrt(Math.pow((Math.max(myShape.top2Part.endX,
							myShape.top2Part.startX) - Math.min(
							myShape.top2Part.endX, myShape.top2Part.startX)), 2)
							+ Math.pow((Math.max(myShape.top2Part.endY,
									myShape.top2Part.startY) - Math.min(
									myShape.top2Part.endY,
									myShape.top2Part.startY)), 2));

		} else if (myShape.top2Part.partForm == 2) {
			myShape.top2Part.length = 2 * Math.PI * myShape.top2Part.radius1
					* myShape.top2Part.centralAngle / 360;

		} else if (myShape.top2Part.partForm == 3) {
			double w = myShape.widthPix;
			final double h1 = Math.pow((myShape.dimB1 - w / 2), 2)
					/ Math.pow((myShape.dimB1 + w / 2), 2);
			final double factorial = 1
					+ 0.25f
					* h1
					+ 1
					/ 64
					* (Math.pow(h1, 2) + 1 / 256 * Math.pow(h1, 3) + 25 / 16384 * Math
							.pow(h1, 4));
			myShape.top2Part.length = Math.PI * (w / 2 + myShape.dimB1)
					* factorial;

		}

		if (myShape.top3Part.partForm == 1) {
			myShape.top3Part.length = Math
					.sqrt(Math.pow((Math.max(myShape.top3Part.endX,
							myShape.top3Part.startX) - Math.min(
							myShape.top3Part.endX, myShape.top3Part.startX)), 2)
							+ Math.pow((Math.max(myShape.top3Part.endY,
									myShape.top3Part.startY) - Math.min(
									myShape.top3Part.endY,
									myShape.top3Part.startY)), 2));

		} else if (myShape.top3Part.partForm == 2) {
			myShape.top3Part.length = 2 * Math.PI * myShape.top3Part.radius1
					* myShape.top3Part.centralAngle / 360;

		}

		if (myShape.bot1Part.partForm == 1) {
			myShape.bot1Part.length = Math
					.sqrt(Math.pow((Math.max(myShape.bot1Part.endX,
							myShape.bot1Part.startX) - Math.min(
							myShape.bot1Part.endX, myShape.bot1Part.startX)), 2)
							+ Math.pow((Math.max(myShape.bot1Part.endY,
									myShape.bot1Part.startY) - Math.min(
									myShape.bot1Part.endY,
									myShape.bot1Part.startY)), 2));

		} else if (myShape.bot1Part.partForm == 2) {
			myShape.bot1Part.length = 2 * Math.PI * myShape.bot1Part.radius1
					* myShape.bot1Part.centralAngle / 360;

		}

		if (myShape.bot2Part.partForm == 1) {
			myShape.bot2Part.length = Math
					.sqrt(Math.pow((Math.max(myShape.bot2Part.endX,
							myShape.bot2Part.startX) - Math.min(
							myShape.bot2Part.endX, myShape.bot2Part.startX)), 2)
							+ Math.pow((Math.max(myShape.bot2Part.endY,
									myShape.bot2Part.startY) - Math.min(
									myShape.bot2Part.endY,
									myShape.bot2Part.startY)), 2));

		} else if (myShape.bot2Part.partForm == 2) {
			myShape.bot2Part.length = 2 * Math.PI * myShape.bot2Part.radius1
					* myShape.bot2Part.centralAngle / 360;

		}

		if (myShape.bot3Part.partForm == 1) {
			myShape.bot3Part.length = Math
					.sqrt(Math.pow((Math.max(myShape.bot3Part.endX,
							myShape.bot3Part.startX) - Math.min(
							myShape.bot3Part.endX, myShape.bot3Part.startX)), 2)
							+ Math.pow((Math.max(myShape.bot3Part.endY,
									myShape.bot3Part.startY) - Math.min(
									myShape.bot3Part.endY,
									myShape.bot3Part.startY)), 2));

		} else if (myShape.bot3Part.partForm == 2) {
			myShape.bot3Part.length = 2 * Math.PI * myShape.bot3Part.radius1
					* myShape.bot3Part.centralAngle / 360;

		}

		if (myShape.leftPart.partForm == 1) {
			myShape.leftPart.length = Math
					.sqrt(Math.pow((Math.max(myShape.leftPart.endX,
							myShape.leftPart.startX) - Math.min(
							myShape.leftPart.endX, myShape.leftPart.startX)), 2)
							+ Math.pow((Math.max(myShape.leftPart.endY,
									myShape.leftPart.startY) - Math.min(
									myShape.leftPart.endY,
									myShape.leftPart.startY)), 2));

		}

		if (myShape.rightPart.partForm == 1) {
			myShape.rightPart.length = Math
					.sqrt(Math.pow((Math.max(myShape.rightPart.endX,
							myShape.rightPart.startX) - Math.min(
							myShape.rightPart.endX, myShape.rightPart.startX)),
							2)
							+ Math.pow((Math.max(myShape.rightPart.endY,
									myShape.rightPart.startY) - Math.min(
									myShape.rightPart.endY,
									myShape.rightPart.startY)), 2));

		}

		myShape.top1Part.lengthM = (int) (new BigDecimal(
				myShape.top1Part.length).divide(myFrame2.metricscale, 20,
				BigDecimal.ROUND_UP)).doubleValue();

		myShape.top1Part.lengthI = (int) (new BigDecimal(
				myShape.top1Part.length).divide(myFrame2.imperialscale, 20,
				BigDecimal.ROUND_UP)).doubleValue();

		myShape.top2Part.lengthM = (int) (new BigDecimal(
				myShape.top2Part.length).divide(myFrame2.metricscale, 20,
				BigDecimal.ROUND_UP)).doubleValue();

		myShape.top2Part.lengthI = (int) (new BigDecimal(
				myShape.top2Part.length).divide(myFrame2.imperialscale, 20,
				BigDecimal.ROUND_UP)).doubleValue();

		myShape.top3Part.lengthM = (int) (new BigDecimal(
				myShape.top3Part.length).divide(myFrame2.metricscale, 20,
				BigDecimal.ROUND_UP)).doubleValue();

		myShape.top3Part.lengthI = (int) (new BigDecimal(
				myShape.top3Part.length).divide(myFrame2.imperialscale, 20,
				BigDecimal.ROUND_UP)).doubleValue();

		myShape.bot1Part.lengthM = (int) (new BigDecimal(
				myShape.bot1Part.length).divide(myFrame2.metricscale, 20,
				BigDecimal.ROUND_UP)).doubleValue();

		myShape.bot1Part.lengthI = (int) (new BigDecimal(
				myShape.bot1Part.length).divide(myFrame2.imperialscale, 20,
				BigDecimal.ROUND_UP)).doubleValue();

		myShape.bot2Part.lengthM = (int) (new BigDecimal(
				myShape.bot2Part.length).divide(myFrame2.metricscale, 20,
				BigDecimal.ROUND_UP)).doubleValue();

		myShape.bot2Part.lengthI = (int) (new BigDecimal(
				myShape.bot2Part.length).divide(myFrame2.imperialscale, 20,
				BigDecimal.ROUND_UP)).doubleValue();

		myShape.bot3Part.lengthM = (int) (new BigDecimal(
				myShape.bot3Part.length).divide(myFrame2.metricscale, 20,
				BigDecimal.ROUND_UP)).doubleValue();

		myShape.bot3Part.lengthI = (int) (new BigDecimal(
				myShape.bot3Part.length).divide(myFrame2.imperialscale, 20,
				BigDecimal.ROUND_UP)).doubleValue();

		myShape.leftPart.lengthM = (int) (new BigDecimal(
				myShape.leftPart.length).divide(myFrame2.metricscale, 20,
				BigDecimal.ROUND_UP)).doubleValue();

		myShape.leftPart.lengthI = (int) (new BigDecimal(
				myShape.leftPart.length).divide(myFrame2.imperialscale, 20,
				BigDecimal.ROUND_UP)).doubleValue();

		myShape.rightPart.lengthM = (int) (new BigDecimal(
				myShape.rightPart.length).divide(myFrame2.metricscale, 20,
				BigDecimal.ROUND_UP)).doubleValue();

		myShape.rightPart.lengthI = (int) (new BigDecimal(
				myShape.rightPart.length).divide(myFrame2.imperialscale, 20,
				BigDecimal.ROUND_UP)).doubleValue();

		return myShape;
	}

	public int totalSides(final OpeningObject myInit) {

		int count = 1;
		myInit.top1Part.posInUse = true;
		if (myInit.noSidesTop == 2) {
			myInit.top2Part.posInUse = true;
			count = count + 1;
		}
		if (myInit.noSidesTop == 3) {
			myInit.top2Part.posInUse = true;
			myInit.top3Part.posInUse = true;
			count = count + 2;
		}
		if (myInit.noSidesRight == 1) {
			count = count + 1;
		}
		if (myInit.noSidesBot == 1) {
			count = count + 1;
		}
		if (myInit.noSidesBot == 2) {
			count = count + 2;
		}
		if (myInit.noSidesBot == 3) {
			count = count + 3;
		}
		if (myInit.noSidesLeft == 1) {
			count = count + 1;
		}
		// if (myInit.shapeID == 10)
		// {
		// count = 0;
		// }

		return count;
	}

	public OpeningObject posInUse(final OpeningObject myInit) {

		myInit.top1Part.posInUse = true;
		myInit.top2Part.posInUse = false;
		myInit.top3Part.posInUse = false;
		myInit.rightPart.posInUse = false;
		myInit.bot1Part.posInUse = true;
		myInit.bot2Part.posInUse = false;
		myInit.bot3Part.posInUse = false;
		myInit.leftPart.posInUse = false;
		if (myInit.noSidesTop == 2) {
			myInit.top2Part.posInUse = true;

		}
		if (myInit.noSidesTop == 3) {
			myInit.top2Part.posInUse = true;
			myInit.top3Part.posInUse = true;

		}
		if (myInit.noSidesRight == 1) {
			myInit.rightPart.posInUse = true;
		}
		if (myInit.noSidesBot == 1) {
			myInit.bot1Part.posInUse = true;
		}
		if (myInit.noSidesBot == 2) {
			myInit.bot1Part.posInUse = true;
			myInit.bot2Part.posInUse = true;

		}
		if (myInit.noSidesBot == 3) {
			myInit.bot1Part.posInUse = true;
			myInit.bot2Part.posInUse = true;
			myInit.bot3Part.posInUse = true;
		}
		if (myInit.noSidesLeft == 1) {
			myInit.leftPart.posInUse = true;
		}
		if (myInit.shapeID == 10) {
			myInit.top1Part.posInUse = false;
			myInit.top2Part.posInUse = false;
			myInit.top3Part.posInUse = false;
			myInit.rightPart.posInUse = false;
			myInit.bot1Part.posInUse = false;
			myInit.bot2Part.posInUse = false;
			myInit.bot3Part.posInUse = false;
			myInit.leftPart.posInUse = false;

			myInit.top1.posInUse = false;
			myInit.top2.posInUse = false;
			myInit.top3.posInUse = false;
			myInit.right.posInUse = false;
			myInit.bot1.posInUse = false;
			myInit.bot2.posInUse = false;
			myInit.bot3.posInUse = false;
			myInit.left.posInUse = false;
		}

		return myInit;
	}

	public OpeningObject setOpeningBackgroundI(OpeningObject opening) {

		if (myBOpening.myParent.a_levelID == 1) {
			b2s = myBOpening.myParent.bot1.partForm;
		}

		OpeningObject myInitOpening = new OpeningObject(myFrame2);

		myInitOpening = opening;

		myInitOpening.myFacet = myParent.myFacet;

		t1s = myInitOpening.top1Part.partForm;
		t2s = myInitOpening.top2Part.partForm;
		t3s = myInitOpening.top3Part.partForm;
		b1s = myInitOpening.bot1Part.partForm;
		b2s = myInitOpening.bot2Part.partForm;
		b3s = myInitOpening.bot3Part.partForm;

		myInitOpening.a_1Level = myParent.a_assemblyLevel;
		myInitOpening.a_1Sequence = myParent.a_sequenceID;
		myInitOpening.a_2Level = myParent.a_1Level;
		myInitOpening.a_2Sequence = myParent.a_1Sequence;
		myInitOpening.a_3Level = myParent.a_2Level;
		myInitOpening.a_3Sequence = myParent.a_2Sequence;
		myInitOpening.a_4Level = myParent.a_3Level;
		myInitOpening.a_4Sequence = myParent.a_3Sequence;

		myInitOpening.a_5Level = myParent.a_4Level;
		myInitOpening.a_5Sequence = myParent.a_4Sequence;
		myInitOpening.a_6Level = myParent.a_5Level;
		myInitOpening.a_6Sequence = myParent.a_5Sequence;
		myInitOpening.a_7Level = myParent.a_6Level;
		myInitOpening.a_7Sequence = myParent.a_6Sequence;
		myInitOpening.a_8Level = myParent.a_7Level;
		myInitOpening.a_8Sequence = myParent.a_7Sequence;
		myInitOpening.a_9Level = myParent.a_8Level;
		myInitOpening.a_9Sequence = myParent.a_8Sequence;
		myInitOpening.a_10Level = myParent.a_9Level;
		myInitOpening.a_10Sequence = myParent.a_9Sequence;

		myInitOpening.a_11Level = myParent.a_10Level;
		myInitOpening.a_11Sequence = myParent.a_10Sequence;
		myInitOpening.a_12Level = myParent.a_11Level;
		myInitOpening.a_12Sequence = myParent.a_11Sequence;
		myInitOpening.a_13Level = myParent.a_12Level;
		myInitOpening.a_13Sequence = myParent.a_12Sequence;
		myInitOpening.a_14Level = myParent.a_13Level;
		myInitOpening.a_15Sequence = myParent.a_13Sequence;
		myInitOpening.a_15Level = myParent.a_14Level;
		myInitOpening.a_15Sequence = myParent.a_14Sequence;
		myInitOpening.a_16Level = myParent.a_15Level;
		myInitOpening.a_16Sequence = myParent.a_15Sequence;
		myInitOpening.a_17Level = myParent.a_16Level;
		myInitOpening.a_17Sequence = myParent.a_16Sequence;
		myInitOpening.a_18Level = myParent.a_17Level;
		myInitOpening.a_18Sequence = myParent.a_17Sequence;
		myInitOpening.a_19Level = myParent.a_18Level;
		myInitOpening.a_19Sequence = myParent.a_18Sequence;
		myInitOpening.a_20Level = myParent.a_19Level;
		myInitOpening.a_20Sequence = myParent.a_19Sequence;
		myInitOpening.a_21Level = myParent.a_20Level;
		myInitOpening.a_21Sequence = myParent.a_20Sequence;
		myInitOpening.a_22Level = myParent.a_21Level;
		myInitOpening.a_22Sequence = myParent.a_21Sequence;

		myInitOpening.trackNo = myParent.trackNo;
		myInitOpening.leafNo = myParent.leafNo;

		myInitOpening = this.setOpeningMullions(myInitOpening);

		myInitOpening.glazingBeadsIn = null;
		myInitOpening.glazingBeadsMid = null;
		myInitOpening.glazingBeadsOut = null;

		myInitOpening.glazingBeadIn = null;
		myInitOpening.glazingBeadMid = null;
		myInitOpening.glazingBeadOut = null;

		Profiles myMullionBot = myInitOpening.myMullionBot;
		final Profiles myMullionTop = myInitOpening.myMullionTop;
		final Profiles myMullionLeft = myInitOpening.myMullionLeft;
		final Profiles myMullionRight = myInitOpening.myMullionRight;

		myInitOpening.leftIn = false;
		myInitOpening.rightIn = false;
		myInitOpening.topIn = false;
		myInitOpening.botIn = false;

		if (myMullionTop != null) {
			myInitOpening.topIn = true;
			myInitOpening.dimTA = myMullionTop.partDimA;
		}
		if (myMullionBot != null) {
			myInitOpening.botIn = true;
			myInitOpening.dimBA = myMullionBot.partDimC;
		}

		if (myMullionLeft != null) {
			myInitOpening.leftIn = true;
			myInitOpening.dimLA = myMullionLeft.partDimC;
		}

		if (myMullionRight != null) {
			myInitOpening.rightIn = true;
			myInitOpening.dimRA = myMullionRight.partDimA;
		}

		if (!myInitOpening.topIn) {
			if (myInitOpening.startCol == 1
					&& myInitOpening.endCol == myBOpening.xCols) {

				opening_OnlyOne(myInitOpening);

			}// row 1 colstart 1 colend last

			else if (myInitOpening.startCol == 1
					&& myInitOpening.endCol < myBOpening.xCols) {

				opening_Top_StartAtBegining_EndInMiddle(myInitOpening,
						myMullionRight);

			} // col 1 row 1 endcol < xcols

			else if (myInitOpening.startCol > 1
					&& myInitOpening.endCol == myBOpening.xCols) {

				this.opening_Top_StartMiddle_EndAtEndCol(myInitOpening,
						myMullionLeft);

			} else if (myInitOpening.startCol > 1
					&& myInitOpening.endCol < myBOpening.xCols) {

				this.opening_Top_InTheMiddle(myInitOpening, myMullionLeft,
						myMullionRight);

			}

		}
		// ///////////////////// BOTTOM
		// /////////////////////////////////////
		b1s = myBOpening.myParent.bot1.partForm;
		b2s = myBOpening.myParent.bot1.partForm;
		b2s = myBOpening.myParent.bot1.partForm;

		if (!myInitOpening.botIn) {
			if (myInitOpening.startCol == 1
					&& myInitOpening.endRow == myBOpening.yRows
					&& myInitOpening.endCol == myBOpening.xCols) {

				myInitOpening = opening_Bottom_OnlyOne(myInitOpening);

			}// row 1 colstart 1 colend last

			else if (myInitOpening.startCol == 1
					&& myInitOpening.endRow == myBOpening.yRows
					&& myInitOpening.endCol <= myBOpening.xCols) {

				myInitOpening = opening_Bottom_StartBegining_EndMiddle(
						myInitOpening, myMullionRight);

			} // col 1 row 1 endcol < xcols

			else if (myInitOpening.startCol > 1
					&& myInitOpening.endRow == myBOpening.yRows
					&& myInitOpening.endCol == myBOpening.xCols) {

				myInitOpening = opening_Bottom_StartMiddle_EndAtEndCol(
						myInitOpening, myMullionLeft);

			} else if (myInitOpening.startCol > 1
					&& myInitOpening.endRow == myBOpening.yRows
					&& myInitOpening.endCol < myBOpening.xCols) {

				myInitOpening = opening_Bottom_InTheMiddle(myInitOpening,
						myMullionLeft, myMullionRight);

			}
		}

		// /////////////////////////////////Other

		if (!myInitOpening.leftIn && myBOpening.leftPart.posInUse) {

			lx1 = myBOpening.left.startX;
			ly1 = myBOpening.left.startY;
			lx1A = myBOpening.myParent.left.startXA;
			ly1A = myBOpening.myParent.left.startYA;
			lx1c = myBOpening.myParent.left.startX;
			ly1c = myBOpening.myParent.left.startY;

			lx2 = myBOpening.left.endX;
			ly2 = myBOpening.left.endY;
			lx2A = myBOpening.myParent.left.endXA;
			ly2A = myBOpening.myParent.left.endYA;
			lx2c = myBOpening.myParent.left.endX;
			ly2c = myBOpening.myParent.left.endY;
			myInitOpening.noSidesLeft = 1;

		} else if (myInitOpening.leftIn && myMullionLeft != null) {
			lx1 = myMullionLeft.x2;
			ly1 = myMullionLeft.y2;
			lx1A = myMullionLeft.x2cl;
			ly1A = myMullionLeft.y2cl;
			lx1c = myMullionLeft.centerXs;
			ly1c = myMullionLeft.centerYs;
			lx2 = myMullionLeft.x3;
			ly2 = myMullionLeft.y3;
			lx2A = myMullionLeft.x3cl;
			ly2A = myMullionLeft.y3cl;
			lx2c = myMullionLeft.centerXe;
			ly2c = myMullionLeft.centerYe;
			myInitOpening.noSidesLeft = 1;

		}
		if (myInitOpening.rightIn && !myInitOpening.leftIn) {
			if (myMullionRight.x3cl < myBOpening.myParent.left.startX
					&& myMullionRight.x4al > myBOpening.myParent.left.endX) {
				myInitOpening.noSidesLeft = 0;
				myInitOpening.leftPart.posInUse = false;
			}
			if (myMullionRight.x1al > myBOpening.myParent.left.startX
					&& myMullionRight.x2cl < myBOpening.myParent.left.endX) {
				myInitOpening.noSidesLeft = 0;
				myInitOpening.leftPart.posInUse = false;
			}
			if (!myBOpening.myParent.left.posInUse) {
				myInitOpening.noSidesLeft = 0;
				myInitOpening.leftPart.posInUse = false;
			}
		}

		if (!myInitOpening.rightIn && myBOpening.rightPart.posInUse) {

			rx1 = myBOpening.right.startX;
			ry1 = myBOpening.right.startY;
			rx1A = myBOpening.myParent.right.startXA;
			ry1A = myBOpening.myParent.right.startYA;
			rx1c = myBOpening.myParent.right.startX;
			ry1c = myBOpening.myParent.right.startY;

			rx2 = myBOpening.right.endX;
			ry2 = myBOpening.right.endY;
			rx2A = myBOpening.myParent.right.endXA;
			ry2A = myBOpening.myParent.right.endYA;
			rx2c = myBOpening.myParent.right.endX;
			ry2c = myBOpening.myParent.right.endY;
			myInitOpening.noSidesRight = 1;
		} else if (myInitOpening.rightIn && myMullionRight != null) {
			rx1 = myMullionRight.x1;
			ry1 = myMullionRight.y1;
			rx1A = myMullionRight.x1al;
			ry1A = myMullionRight.y1al;
			rx1c = myMullionRight.centerXs;
			ry1c = myMullionRight.centerYs;
			rx2 = myMullionRight.x4;
			ry2 = myMullionRight.y4;
			rx2A = myMullionRight.x4al;
			ry2A = myMullionRight.y4al;
			rx2c = myMullionRight.centerXe;
			ry2c = myMullionRight.centerYe;
			myInitOpening.noSidesRight = 1;

		}

		if (!myInitOpening.rightIn && myInitOpening.leftIn) {
			if (myMullionLeft.x3cl < myBOpening.myParent.right.startX
					&& myMullionLeft.x4al > myBOpening.myParent.right.endX) {
				myInitOpening.noSidesRight = 0;

				myInitOpening.rightPart.posInUse = false;
			}
			if (myMullionLeft.x1al > myBOpening.myParent.right.startX
					&& myMullionLeft.x2cl < myBOpening.myParent.right.endX) {
				myInitOpening.noSidesRight = 0;

				myInitOpening.rightPart.posInUse = false;
			}
			if (!myBOpening.myParent.right.posInUse) {
				myInitOpening.noSidesRight = 0;

				myInitOpening.rightPart.posInUse = false;
			}
		}

		if (myInitOpening.topIn) {

			tx1 = myMullionTop.x1;
			ty1 = myMullionTop.y1;
			tx1A = myMullionTop.x1al;
			ty1A = myMullionTop.y1al;
			tx1c = myMullionTop.centerXs;
			ty1c = myMullionTop.centerYs;
			tx2 = myMullionTop.x4;
			ty2 = myMullionTop.y4;
			tx2A = myMullionTop.x4al;
			ty2A = myMullionTop.y4al;
			tx2c = myMullionTop.centerXe;
			ty2c = myMullionTop.centerYe;
			t1s = myMullionTop.partForm;

		}

		if (myInitOpening.botIn) {
			bx2 = myMullionBot.x2;
			by2 = myMullionBot.y2;
			bx2A = myMullionBot.x2cl;
			by2A = myMullionBot.y2cl;
			bx2c = myMullionBot.centerXs;
			by2c = myMullionBot.centerYs;
			bx1 = myMullionBot.x3;
			by1 = myMullionBot.y3;
			bx1A = myMullionBot.x3cl;
			by1A = myMullionBot.y3cl;
			bx1c = myMullionBot.centerXe;
			by1c = myMullionBot.centerYe;
			b1s = myMullionBot.partForm;
			myInitOpening.noSidesBot = 1;

			if (by2 != ty1 && myInitOpening.noSidesLeft == 0) {

				// lx1 = myBOpening.bot1.startX;
				// ly1 = myBOpening.bot1.startY;
				// lx1A = myBOpening.bot1.startXA;
				// ly1A = myBOpening.bot1.startYA;
				// lx1c = myBOpening.myParent.bot1.startX;
				// ly1c = myBOpening.myParent.bot1.startY;
				//
				// lx2 = myBOpening.bot1.endX;
				// ly2 = myBOpening.bot1.endY;
				// lx2A = myBOpening.bot1.endXA;
				// ly2A = myBOpening.bot1.endYA;
				// lx2c = myBOpening.myParent.bot1.endX;
				// ly2c = myBOpening.myParent.bot1.endY;
				//
				// myInitOpening.noSidesLeft = 1;

			}
			if ((by1 != ty2 || by1 != t2y2) && myInitOpening.noSidesRight == 0) {

				// rx1 = myBOpening.bot1.startX;
				// ry1 = myBOpening.bot1.startY;
				// rx1A = myBOpening.bot1.startXA;
				// ry1A = myBOpening.bot1.startYA;
				// rx1c = myBOpening.myParent.bot1.startX;
				// ry1c = myBOpening.myParent.bot1.startY;
				//
				// rx2 = myBOpening.bot1.endX;
				// ry2 = myBOpening.bot1.endY;
				// rx2A = myBOpening.bot1.endXA;
				// ry2A = myBOpening.bot1.endYA;
				// rx2c = myBOpening.myParent.bot1.endX;
				// ry2c = myBOpening.myParent.bot1.endY;
				//
				// myInitOpening.noSidesRight = 1;

			}
		}

		if (myInitOpening.noSidesLeft == 0) {
			if (myInitOpening.rightIn && myInitOpening.botIn) {
				tx2 = rx1;
				ty2 = ry1;
				tx1 = bx2;
				ty1 = by2;

				tx2c = this.intersectX(tx1, ty1, tx2, ty2, rx1c, ry1c, rx2c,
						ry2c);

				ty2c = this.intersectY(tx1, ty1, tx2, ty2, rx1c, ry1c, rx2c,
						ry2c);

				tx1c = this.intersectX(tx1, ty1, tx2, ty2, bx1c, by1c, bx2c,
						by2c);

				ty1c = this.intersectY(tx1, ty1, tx2, ty2, bx1c, by1c, bx2c,
						by2c);

			}

		}
		if (myInitOpening.noSidesRight == 0) {
			if (myInitOpening.leftIn && myInitOpening.botIn) {
				tx1 = lx1;
				ty1 = ly1;
				tx2 = bx1;
				ty2 = by1;

				tx1c = this.intersectX(tx1, ty1, tx2, ty2, lx1c, ly1c, lx2c,
						ly2c);

				ty1c = this.intersectY(tx1, ty1, tx2, ty2, lx1c, ly1c, lx2c,
						ly2c);

				tx2c = this.intersectX(tx1, ty1, tx2, ty2, bx1c, by1c, bx2c,
						by2c);

				ty2c = this.intersectY(tx1, ty1, tx2, ty2, bx1c, by1c, bx2c,
						by2c);

			}

		}

		// if (!myInitOpening.leftIn)
		// {
		// if (myBOpening.noSidesLeft == 0)
		// {
		// myInitOpening.noSidesLeft =
		// 0;
		//
		// myInitOpening.leftPart.posInUse=false;
		// }
		// }
		// if (!myInitOpening.rightIn)
		// {
		// if (myBOpening.noSidesRight == 0)
		// {
		// myInitOpening.noSidesRight =
		// 0;
		// myInitOpening.rightPart.posInUse=false;
		// }
		// }
		//

		boolean moreTop = false;
		boolean moreTop1 = false;
		boolean moreTop2 = false;
		boolean moreTop3 = false;
		if (myInitOpening.topIn) {
			myInitOpening.noSidesTop = 1;
		}
		if (!myInitOpening.topIn && myInitOpening.botIn && myInitOpening.leftIn
				&& myBOpening.noSidesTop == 2) {
			myInitOpening.left.partForm = 1;
		}

		if (myInitOpening.botIn) {
			if (!myInitOpening.leftIn) {
				if (myMullionBot.y2 <= myBOpening.top1Part.startYC) {
					myInitOpening.noSidesLeft = 0;
					myInitOpening.leftPart.posInUse = false;
				}
			} else {
				if (myMullionBot.y2 <= myMullionLeft.y2) {
					myInitOpening.noSidesLeft = 0;
					myInitOpening.leftPart.posInUse = false;
				}
			}
			if (!myInitOpening.rightIn) {
				if (myBOpening.noSidesTop == 1) {
					if (myMullionBot.y3 <= myBOpening.top1Part.endYC) {

						myInitOpening.noSidesRight = 0;
						myInitOpening.rightPart.posInUse = false;
					}
				}
				if (myBOpening.noSidesTop > 1) {
					if (myMullionBot.y3 <= myBOpening.top2Part.endYC) {

						myInitOpening.noSidesRight = 0;
						myInitOpening.rightPart.posInUse = false;
					}
				}
			} else {
				if (myMullionBot.y2 <= myMullionRight.y1) {
					myInitOpening.noSidesRight = 0;
					myInitOpening.rightPart.posInUse = false;
				}
			}

		}

		if (myInitOpening.topIn) {
			if (myBOpening.noSidesBot == 1) {
				if (myMullionTop.y1 >= myBOpening.bot1Part.endYC) {
					myInitOpening.noSidesLeft = 0;
					myInitOpening.leftPart.posInUse = false;
				}
				if (myMullionTop.y4 >= myBOpening.bot1Part.startYC) {
					myInitOpening.noSidesRight = 0;
					myInitOpening.leftPart.posInUse = false;
				}
			}

			if (myBOpening.noSidesBot == 2) {
				if (myMullionTop.y1 >= myBOpening.bot2Part.endYC) {
					myInitOpening.noSidesLeft = 0;
					myInitOpening.leftPart.posInUse = false;
				}
				if (myMullionTop.y4 >= myBOpening.bot1Part.startYC) {
					myInitOpening.noSidesRight = 0;
					myInitOpening.rightPart.posInUse = false;
				}
			}

			if (myBOpening.noSidesBot == 3) {
				if (myMullionTop.y1 >= myBOpening.bot2Part.endYC) {
					myInitOpening.noSidesLeft = 0;
					myInitOpening.leftPart.posInUse = false;
				}
				if (myMullionTop.y4 >= myBOpening.bot3Part.startYC) {
					myInitOpening.noSidesRight = 0;
					myInitOpening.rightPart.posInUse = false;
				}
			}

		}

		if (myInitOpening.topIn && myBOpening.noSidesTop == 1) {

			if (myMullionTop.y1 < myBOpening.top1Part.startYC
					&& !myInitOpening.leftIn) {

				moreTop = true;
				moreTop1 = true;

			}

			if (myMullionTop.y4 < myBOpening.top1Part.endYC
					&& !myInitOpening.rightIn) {
				if (myBOpening.top1Part.startYC != myBOpening.top1Part.endYC) {
					moreTop = true;
					moreTop2 = true;
				}
			}
		}
		if (myInitOpening.topIn && myBOpening.noSidesTop > 1
				&& !myInitOpening.leftIn) {
			if (myMullionTop.y1 < myBOpening.top1Part.startYC) {
				moreTop = true;
				moreTop1 = true;
			}
			if (myMullionTop.y4 < myBOpening.top2Part.endYC
					&& !myInitOpening.rightIn) {
				moreTop = true;
				// moreTop2 = true;
				moreTop2 = true;
			}
		}
		if (myInitOpening.topIn && myBOpening.noSidesTop > 1
				&& !myInitOpening.rightIn) {

			if (myMullionTop.y4 < myBOpening.top2Part.endYC
					&& !myInitOpening.rightIn) {
				moreTop = true;
				// moreTop2 = true;
				moreTop2 = true;
			}
		}
		if (myInitOpening.topIn && moreTop1 && moreTop2
				&& !myInitOpening.leftIn && !myInitOpening.rightIn) {
			// if (myMullionTop.y1 <=
			// myBOpening.top1Part.startY)
			// {
			moreTop = true;
			moreTop3 = true;
			myInitOpening.top3Part.posInUse = true;
			// }
			// if (myMullionTop.y4 <=
			// myBOpening.top2Part.endY)
			// {
			// moreTop = true;
			//
			// moreTop3 = true;
			// }
		}
		if (!myInitOpening.botIn) {
			myMullionBot = null;
		}

		if (moreTop || moreTop2 || moreTop3) {

			// /////////////////////////////////////////////
			if (myInitOpening.leftIn && myInitOpening.rightIn
					&& myBOpening.noSidesTop == 1
					&& myInitOpening.startRow == 1) {
				if (myMullionLeft.x2 <= myBOpening.px1
						&& myMullionRight.x1 >= myBOpening.px1) {
					myInitOpening.noSidesTop = 2;
					tx1 = myBOpening.left.startX;
					ty1 = myBOpening.left.startY;
					tx1A = myBOpening.left.startXA;
					ty1A = myBOpening.left.startYA;
					tx1c = myBOpening.myParent.left.startX;
					ty1c = myBOpening.myParent.left.startY;

					tx2 = myBOpening.left.endX;
					ty2 = myBOpening.left.endY;
					tx2A = myBOpening.left.endXA;
					ty2A = myBOpening.left.endYA;
					tx2c = myBOpening.myParent.left.endX;
					ty2c = myBOpening.myParent.left.endY;
					t1s = myBOpening.left.partForm;

					t2x1 = myBOpening.top1.startX;
					t2y1 = myBOpening.top1.startY;
					t2x1A = myBOpening.top1.startXA;
					t2y1A = myBOpening.top1.startYA;
					t2x1c = myBOpening.myParent.top1.startX;
					t2y1c = myBOpening.myParent.top1.startY;

					t2x2 = myBOpening.top1.endX;
					t2y2 = myBOpening.top1.endY;
					t2x2A = myBOpening.top1.endXA;
					t2y2A = myBOpening.top1.endYA;
					t2x2c = myBOpening.myParent.top1.endX;
					t2y2c = myBOpening.myParent.top1.endY;
					t2s = myBOpening.top1.partForm;

				}
				if (myMullionLeft.x2 <= myBOpening.px2
						&& myMullionRight.x1 >= myBOpening.px2) {
					myInitOpening.noSidesTop = 2;
					tx1 = myBOpening.top1.startX;
					ty1 = myBOpening.top1.startY;
					tx1A = myBOpening.top1.startXA;
					ty1A = myBOpening.top1.startYA;
					tx1c = myBOpening.myParent.top1.startX;
					ty1c = myBOpening.myParent.top1.startY;

					tx2 = myBOpening.top1.endX;
					ty2 = myBOpening.top1.endY;
					tx2A = myBOpening.top1.endXA;
					ty2A = myBOpening.top1.endYA;
					tx2c = myBOpening.myParent.top1.endX;
					ty2c = myBOpening.myParent.top1.endY;
					t1s = myBOpening.top1.partForm;

					t2x1 = myBOpening.right.startX;
					t2y1 = myBOpening.right.startY;
					t2x1A = myBOpening.right.startXA;
					t2y1A = myBOpening.right.startYA;
					t2x1c = myBOpening.myParent.right.startX;
					t2y1c = myBOpening.myParent.right.startY;

					t2x2 = myBOpening.right.endX;
					t2y2 = myBOpening.right.endY;
					t2x2A = myBOpening.right.endXA;
					t2y2A = myBOpening.right.endYA;
					t2x2c = myBOpening.myParent.right.endX;
					t2y2c = myBOpening.myParent.right.endY;
					t2s = myBOpening.right.partForm;

				}
			}

			if (myInitOpening.leftIn && myInitOpening.rightIn
					&& myBOpening.noSidesTop == 2
					&& myInitOpening.startRow == 1) {
				if (myMullionLeft.x2 <= myBOpening.px1
						&& myMullionRight.x1 >= myBOpening.px1) {
					myInitOpening.noSidesTop = 2;
					tx1 = myBOpening.top1.startX;
					ty1 = myBOpening.top1.startY;
					tx1A = myBOpening.top1.startXA;
					ty1A = myBOpening.top1.startYA;
					tx1c = myBOpening.myParent.top1.startX;
					ty1c = myBOpening.myParent.top1.startY;

					tx2 = myBOpening.top1.endX;
					ty2 = myBOpening.top1.endY;
					tx2A = myBOpening.top1.endXA;
					ty2A = myBOpening.top1.endYA;
					tx2c = myBOpening.myParent.top1.endX;
					ty2c = myBOpening.myParent.top1.endY;
					t1s = myBOpening.top1.partForm;

					t2x1 = myBOpening.top2.startX;
					t2y1 = myBOpening.top2.startY;
					t2x1A = myBOpening.top2.startXA;
					t2y1A = myBOpening.top2.startYA;
					t2x1c = myBOpening.myParent.top2.startX;
					t2y1c = myBOpening.myParent.top2.startY;

					t2x2 = myBOpening.top2.endX;
					t2y2 = myBOpening.top2.endY;
					t2x2A = myBOpening.top2.endXA;
					t2y2A = myBOpening.top2.endYA;
					t2x2c = myBOpening.myParent.top2.endX;
					t2y2c = myBOpening.myParent.top2.endY;
					t2s = myBOpening.top2.partForm;

				}
				if (myMullionLeft.x2 <= myBOpening.px2
						&& myMullionRight.x1 >= myBOpening.px2) {
					myInitOpening.noSidesTop = 2;
					tx1 = myBOpening.top1.startX;
					ty1 = myBOpening.top1.startY;
					tx1A = myBOpening.top1.startXA;
					ty1A = myBOpening.top1.startYA;
					tx1c = myBOpening.myParent.top1.startX;
					ty1c = myBOpening.myParent.top1.startY;

					tx2 = myBOpening.top1.endX;
					ty2 = myBOpening.top1.endY;
					tx2A = myBOpening.top1.endXA;
					ty2A = myBOpening.top1.endYA;
					tx2c = myBOpening.myParent.top1.endX;
					ty2c = myBOpening.myParent.top1.endY;
					t1s = myBOpening.top1.partForm;

					t2x1 = myBOpening.top2.startX;
					t2y1 = myBOpening.top2.startY;
					t2x1A = myBOpening.top2.startXA;
					t2y1A = myBOpening.top2.startYA;
					t2x1c = myBOpening.myParent.top2.startX;
					t2y1c = myBOpening.myParent.top2.startY;

					t2x2 = myBOpening.top2.endX;
					t2y2 = myBOpening.top2.endY;
					t2x2A = myBOpening.top2.endXA;
					t2y2A = myBOpening.top2.endYA;
					t2x2c = myBOpening.myParent.top2.endX;
					t2y2c = myBOpening.myParent.top2.endY;
					t2s = myBOpening.top2.partForm;

				}
			}

			if (myInitOpening.leftIn && myInitOpening.rightIn
					&& myBOpening.noSidesTop == 3
					&& myInitOpening.startRow == 1) {
				if (myMullionLeft.x2 <= myBOpening.px2
						&& myMullionRight.x1 >= myBOpening.px2
						&& myMullionRight.x2 < myBOpening.px3) {
					myInitOpening.noSidesTop = 2;
					tx1 = myBOpening.top1.startX;
					ty1 = myBOpening.top1.startY;
					tx1A = myBOpening.top1.startXA;
					ty1A = myBOpening.top1.startYA;
					tx1c = myBOpening.myParent.top1.startX;
					ty1c = myBOpening.myParent.top1.startY;

					tx2 = myBOpening.top1.endX;
					ty2 = myBOpening.top1.endY;
					tx2A = myBOpening.top1.endXA;
					ty2A = myBOpening.top1.endYA;
					tx2c = myBOpening.myParent.top1.endX;
					ty2c = myBOpening.myParent.top1.endY;
					t1s = myBOpening.top1.partForm;

					t2x1 = myBOpening.top3.startX;
					t2y1 = myBOpening.top3.startY;
					t2x1A = myBOpening.top3.startXA;
					t2y1A = myBOpening.top3.startYA;
					t2x1c = myBOpening.myParent.top3.startX;
					t2y1c = myBOpening.myParent.top3.startY;

					t2x2 = myBOpening.top3.endX;
					t2y2 = myBOpening.top3.endY;
					t2x2A = myBOpening.top3.endXA;
					t2y2A = myBOpening.top3.endYA;
					t2x2c = myBOpening.myParent.top3.endX;
					t2y2c = myBOpening.myParent.top3.endY;
					t2s = myBOpening.top3.partForm;

				}
				if (myMullionLeft.x2 <= myBOpening.px3
						&& myMullionRight.x1 >= myBOpening.px3
						&& myMullionLeft.x2 > myBOpening.px2) {
					myInitOpening.noSidesTop = 2;
					tx1 = myBOpening.top3.startX;
					ty1 = myBOpening.top3.startY;
					tx1A = myBOpening.top3.startXA;
					ty1A = myBOpening.top3.startYA;
					tx1c = myBOpening.myParent.top3.startX;
					ty1c = myBOpening.myParent.top3.startY;

					tx2 = myBOpening.top3.endX;
					ty2 = myBOpening.top3.endY;
					tx2A = myBOpening.top3.endXA;
					ty2A = myBOpening.top3.endYA;
					tx2c = myBOpening.myParent.top3.endX;
					ty2c = myBOpening.myParent.top3.endY;
					t1s = myBOpening.top3.partForm;

					t2x1 = myBOpening.top2.startX;
					t2y1 = myBOpening.top2.startY;
					t2x1A = myBOpening.top2.startXA;
					t2y1A = myBOpening.top2.startYA;
					t2x1c = myBOpening.myParent.top2.startX;
					t2y1c = myBOpening.myParent.top2.startY;

					t2x2 = myBOpening.top2.endX;
					t2y2 = myBOpening.top2.endY;
					t2x2A = myBOpening.top2.endXA;
					t2y2A = myBOpening.top2.endYA;
					t2x2c = myBOpening.myParent.top2.endX;
					t2y2c = myBOpening.myParent.top2.endY;
					t2s = myBOpening.top2.partForm;

				}
			}

			if (!myInitOpening.leftIn && myInitOpening.rightIn
					&& !myInitOpening.topIn) {
				if (myBOpening.noSidesTop == 1
						&& myMullionRight.x2 < myBOpening.px1) {
					myInitOpening.noSidesLeft = 0;
					myInitOpening.noSidesTop = 1;
					tx1 = myBOpening.left.startX;
					ty1 = myBOpening.left.startY;
					tx1A = myBOpening.left.startXA;
					ty1A = myBOpening.left.startYA;
					tx1c = myBOpening.myParent.left.startX;
					ty1c = myBOpening.myParent.left.startY;

					tx2 = myBOpening.left.endX;
					ty2 = myBOpening.left.endY;
					tx2A = myBOpening.left.endXA;
					ty2A = myBOpening.left.endYA;
					tx2c = myBOpening.myParent.left.endX;
					ty2c = myBOpening.myParent.left.endY;
					t1s = myBOpening.left.partForm;

				}
			}
			if (!myInitOpening.rightIn && myInitOpening.leftIn
					&& !myInitOpening.topIn) {
				if (myBOpening.noSidesTop == 1
						&& myMullionLeft.x1 > myBOpening.px2) {
					myInitOpening.noSidesRight = 0;
					myInitOpening.noSidesTop = 1;
					tx1 = myBOpening.right.startX;
					ty1 = myBOpening.right.startY;
					tx1A = myBOpening.right.startXA;
					ty1A = myBOpening.right.startYA;
					tx1c = myBOpening.myParent.right.startX;
					ty1c = myBOpening.myParent.right.startY;

					tx2 = myBOpening.right.endX;
					ty2 = myBOpening.right.endY;
					tx2A = myBOpening.right.endXA;
					ty2A = myBOpening.right.endYA;
					tx2c = myBOpening.myParent.right.endX;
					ty2c = myBOpening.myParent.right.endY;
					t1s = myBOpening.right.partForm;

				}
			}
			// //////////////////////////

			if (myInitOpening.leftIn && myInitOpening.rightIn
					&& myBOpening.noSidesBot == 1
					&& myInitOpening.endRow == myBOpening.yRows) {
				if (myMullionLeft.x3 <= myBOpening.startingX + myBOpening.dimC2
						&& (myBOpening.lean3 == 1 || myBOpening.lean3 == 3)
						&& myMullionRight.x4 >= myBOpening.startingX
								+ myBOpening.dimC2
						&& (myBOpening.lean3 == 1 || myBOpening.lean3 == 3)) {
					myInitOpening.noSidesBot = 2;
					bx1 = myBOpening.bot1.startX;
					by1 = myBOpening.bot1.startY;
					bx1A = myBOpening.bot1.startXA;
					by1A = myBOpening.bot1.startYA;
					bx1c = myBOpening.myParent.bot1.startX;
					by1c = myBOpening.myParent.bot1.startY;

					bx2 = myBOpening.bot1.endX;
					by2 = myBOpening.bot1.endY;
					bx2A = myBOpening.bot1.endXA;
					by2A = myBOpening.bot1.endYA;
					bx2c = myBOpening.myParent.bot1.endX;
					by2c = myBOpening.myParent.bot1.endY;
					b1s = myBOpening.bot1.partForm;

					b2x1 = myBOpening.left.startX;
					b2y1 = myBOpening.left.startY;
					b2x1A = myBOpening.left.startXA;
					b2y1A = myBOpening.left.startYA;
					b2x1c = myBOpening.myParent.left.startX;
					b2y1c = myBOpening.myParent.left.startY;

					b2x2 = myBOpening.left.endX;
					b2y2 = myBOpening.left.endY;
					b2x2A = myBOpening.left.endXA;
					b2y2A = myBOpening.left.endYA;
					b2x2c = myBOpening.myParent.left.endX;
					b2y2c = myBOpening.myParent.left.endY;
					b2s = myBOpening.left.partForm;

				}
				if (myMullionLeft.x3 <= myBOpening.startingX + myBOpening.dimC2
						+ myBOpening.dimC1
						&& myBOpening.lean3 == 3
						&& myMullionRight.x4 >= myBOpening.startingX
								+ myBOpening.dimC2 + myBOpening.dimC1
						&& myBOpening.lean3 == 3
						||

						myMullionLeft.x3 <= myBOpening.startingX
								+ myBOpening.dimC2

						&& myBOpening.lean3 == 2
						&& myMullionRight.x4 >= myBOpening.startingX
								+ myBOpening.dimC2 && myBOpening.lean3 == 2) {
					myInitOpening.noSidesBot = 2;
					bx1 = myBOpening.right.startX;
					by1 = myBOpening.right.startY;
					bx1A = myBOpening.right.startXA;
					by1A = myBOpening.right.startYA;
					bx1c = myBOpening.myParent.right.startX;
					by1c = myBOpening.myParent.right.startY;

					bx2 = myBOpening.right.endX;
					by2 = myBOpening.right.endY;
					bx2A = myBOpening.right.endXA;
					by2A = myBOpening.right.endYA;
					bx2c = myBOpening.myParent.right.endX;
					by2c = myBOpening.myParent.right.endY;
					b1s = myBOpening.right.partForm;

					b2x1 = myBOpening.bot1.startX;
					b2y1 = myBOpening.bot1.startY;
					b2x1A = myBOpening.bot1.startXA;
					b2y1A = myBOpening.bot1.startYA;
					b2x1c = myBOpening.myParent.bot1.startX;
					b2y1c = myBOpening.myParent.bot1.startY;

					b2x2 = myBOpening.bot1.endX;
					b2y2 = myBOpening.bot1.endY;
					b2x2A = myBOpening.bot1.endXA;
					b2y2A = myBOpening.bot1.endYA;
					b2x2c = myBOpening.myParent.bot1.endX;
					b2y2c = myBOpening.myParent.bot1.endY;
					b2s = myBOpening.bot1.partForm;

				}
			}

			if (myInitOpening.leftIn && myInitOpening.rightIn
					&& myBOpening.noSidesBot == 2
					&& myInitOpening.endRow == myBOpening.yRows) {
				if (myMullionLeft.x3 <= myBOpening.startingX + myBOpening.dimC2
						&& myBOpening.lean3 == 1
						&& myMullionRight.x4 >= myBOpening.startingX
								+ myBOpening.dimC2 && myBOpening.lean3 == 1) {
					myInitOpening.noSidesBot = 2;
					bx1 = myBOpening.bot1.startX;
					by1 = myBOpening.bot1.startY;
					bx1A = myBOpening.bot1.startXA;
					by1A = myBOpening.bot1.startYA;
					bx1c = myBOpening.myParent.bot1.startX;
					by1c = myBOpening.myParent.bot1.startY;

					bx2 = myBOpening.bot1.endX;
					by2 = myBOpening.bot1.endY;
					bx2A = myBOpening.bot1.endXA;
					by2A = myBOpening.bot1.endYA;
					bx2c = myBOpening.myParent.bot1.endX;
					by2c = myBOpening.myParent.bot1.endY;
					b1s = myBOpening.bot1.partForm;

					b2x1 = myBOpening.bot2.startX;
					b2y1 = myBOpening.bot2.startY;
					b2x1A = myBOpening.bot2.startXA;
					b2y1A = myBOpening.bot2.startYA;
					b2x1c = myBOpening.myParent.bot2.startX;
					b2y1c = myBOpening.myParent.bot2.startY;

					b2x2 = myBOpening.bot2.endX;
					b2y2 = myBOpening.bot2.endY;
					b2x2A = myBOpening.bot2.endXA;
					b2y2A = myBOpening.bot2.endYA;
					b2x2c = myBOpening.myParent.bot2.endX;
					b2y2c = myBOpening.myParent.bot2.endY;
					b2s = myBOpening.bot2.partForm;

				}

			}

			if (myInitOpening.leftIn && myInitOpening.rightIn
					&& myBOpening.noSidesBot == 3
					&& myInitOpening.endRow == myBOpening.yRows) {
				if (myMullionLeft.x3 <= myBOpening.startingX + myBOpening.dimC2

						&& myMullionRight.x4 >= myBOpening.startingX
								+ myBOpening.dimC2
						&& myMullionRight.x4 <= myBOpening.startingX
								+ myBOpening.dimC2 + myBOpening.dimC1) {
					myInitOpening.noSidesBot = 2;
					bx1 = myBOpening.bot1.startX;
					by1 = myBOpening.bot1.startY;
					bx1A = myBOpening.bot1.startXA;
					by1A = myBOpening.bot1.startYA;
					bx1c = myBOpening.myParent.bot1.startX;
					by1c = myBOpening.myParent.bot1.startY;

					bx2 = myBOpening.bot1.endX;
					by2 = myBOpening.bot1.endY;
					bx2A = myBOpening.bot1.endXA;
					by2A = myBOpening.bot1.endYA;
					bx2c = myBOpening.myParent.bot1.endX;
					by2c = myBOpening.myParent.bot1.endY;
					b1s = myBOpening.bot1.partForm;

					b2x1 = myBOpening.bot2.startX;
					b2y1 = myBOpening.bot2.startY;
					b2x1A = myBOpening.bot2.startXA;
					b2y1A = myBOpening.bot2.startYA;
					b2x1c = myBOpening.myParent.bot2.startX;
					b2y1c = myBOpening.myParent.bot2.startY;

					b2x2 = myBOpening.bot2.endX;
					b2y2 = myBOpening.bot2.endY;
					b2x2A = myBOpening.bot2.endXA;
					b2y2A = myBOpening.bot2.endYA;
					b2x2c = myBOpening.myParent.bot2.endX;
					b2y2c = myBOpening.myParent.bot2.endY;
					b2s = myBOpening.bot2.partForm;

				}
				if (myMullionLeft.x3 <= myBOpening.startingX + myBOpening.dimC2
						+ myBOpening.dimC1
						&& myMullionLeft.x3 >= myBOpening.startingX
								+ myBOpening.dimC2
						&& myMullionRight.x4 >= myBOpening.startingX
								+ myBOpening.dimC2 + myBOpening.dimC1) {
					myInitOpening.noSidesBot = 2;
					bx1 = myBOpening.bot3.startX;
					by1 = myBOpening.bot3.startY;
					bx1A = myBOpening.bot3.startXA;
					by1A = myBOpening.bot3.startYA;
					bx1c = myBOpening.myParent.bot3.startX;
					by1c = myBOpening.myParent.bot3.startY;

					bx2 = myBOpening.bot3.endX;
					by2 = myBOpening.bot3.endY;
					bx2A = myBOpening.bot3.endXA;
					by2A = myBOpening.bot3.endYA;
					bx2c = myBOpening.myParent.bot3.endX;
					by2c = myBOpening.myParent.bot3.endY;
					b1s = myBOpening.bot3.partForm;

					b2x1 = myBOpening.bot1.startX;
					b2y1 = myBOpening.bot1.startY;
					b2x1A = myBOpening.bot1.startXA;
					b2y1A = myBOpening.bot1.startYA;
					b2x1c = myBOpening.myParent.bot1.startX;
					b2y1c = myBOpening.myParent.bot1.startY;

					b2x2 = myBOpening.bot1.endX;
					b2y2 = myBOpening.bot1.endY;
					b2x2A = myBOpening.bot1.endXA;
					b2y2A = myBOpening.bot1.endYA;
					b2x2c = myBOpening.myParent.bot1.endX;
					b2y2c = myBOpening.myParent.bot1.endY;
					b2s = myBOpening.bot1.partForm;

				}
			}

			if (!myInitOpening.leftIn && myInitOpening.rightIn
					&& myInitOpening.noSidesLeft == 1) {
				if (myBOpening.noSidesBot == 1
						&& myMullionRight.x3 <= myBOpening.leftPart.startXC
						&& !myInitOpening.botIn) {
					myInitOpening.noSidesLeft = 0;
					myInitOpening.noSidesBot = 1;
					bx1 = myBOpening.left.startX;
					by1 = myBOpening.left.startY;
					bx1A = myBOpening.left.startXA;
					by1A = myBOpening.left.startYA;
					bx1c = myBOpening.myParent.left.startX;
					by1c = myBOpening.myParent.left.startY;

					bx2 = myBOpening.left.endX;
					by2 = myBOpening.left.endY;
					bx2A = myBOpening.left.endXA;
					by2A = myBOpening.left.endYA;
					bx2c = myBOpening.myParent.left.endX;
					by2c = myBOpening.myParent.left.endY;
					b1s = myBOpening.left.partForm;

				}

				if (myBOpening.noSidesBot > 1
						&& myMullionRight.x3 < myBOpening.startingX
								+ myBOpening.dimC2 && !myInitOpening.botIn) {
					myInitOpening.noSidesLeft = 0;
					myInitOpening.noSidesBot = 1;
					bx1 = myBOpening.left.startX;
					by1 = myBOpening.left.startY;
					bx1A = myBOpening.left.startXA;
					by1A = myBOpening.left.startYA;
					bx1c = myBOpening.myParent.left.startX;
					by1c = myBOpening.myParent.left.startY;

					bx2 = myBOpening.left.endX;
					by2 = myBOpening.left.endY;
					bx2A = myBOpening.left.endXA;
					by2A = myBOpening.left.endYA;
					bx2c = myBOpening.myParent.left.endX;
					by2c = myBOpening.myParent.left.endY;
					b1s = myBOpening.left.partForm;

				}
			}
			if (myInitOpening.leftIn && !myInitOpening.rightIn
					&& myInitOpening.noSidesRight == 1) {
				if (myBOpening.noSidesBot == 1
						&& myMullionLeft.x4 >= myBOpening.right.endX
						&& !myInitOpening.botIn) {
					myInitOpening.noSidesRight = 0;
					myInitOpening.noSidesBot = 1;
					bx1 = myBOpening.right.startX;
					by1 = myBOpening.right.startY;
					bx1A = myBOpening.right.startXA;
					by1A = myBOpening.right.startYA;
					bx1c = myBOpening.myParent.right.startX;
					by1c = myBOpening.myParent.right.startY;

					bx2 = myBOpening.right.endX;
					by2 = myBOpening.right.endY;
					bx2A = myBOpening.right.endXA;
					by2A = myBOpening.right.endYA;
					bx2c = myBOpening.myParent.right.endX;
					by2c = myBOpening.myParent.right.endY;
					b1s = myBOpening.right.partForm;

				}

				if (myBOpening.noSidesBot == 3
						&& myMullionLeft.x4 < myBOpening.rightPart.startXC
						&& myMullionLeft.x4 > myBOpening.rightPart.endXC
						&& !myInitOpening.botIn) {
					myInitOpening.noSidesRight = 0;
					myInitOpening.noSidesBot = 1;
					bx1 = myBOpening.right.startX;
					by1 = myBOpening.right.startY;
					bx1A = myBOpening.right.startXA;
					by1A = myBOpening.right.startYA;
					bx1c = myBOpening.myParent.right.startX;
					by1c = myBOpening.myParent.right.startY;

					bx2 = myBOpening.right.endX;
					by2 = myBOpening.right.endY;
					bx2A = myBOpening.right.endXA;
					by2A = myBOpening.right.endYA;
					bx2c = myBOpening.myParent.right.endX;
					by2c = myBOpening.myParent.right.endY;
					b1s = myBOpening.right.partForm;

				}
			}
			// //////////////////////////

			// ///////////////////////////////////////////////////

			if (myInitOpening.startRow > 1) {

				if (myParent.lean4 == 3
						&& myMullionBot != null
						&& myMullionBot.y2 > myBOpening.highestY
								+ myBOpening.dimD2 + myBOpening.dimD1
						|| //
						myParent.lean2 == 3
						&& myMullionBot != null
						&& myMullionBot.y4 > myBOpening.highestY
								+ myBOpening.dimB1 + myBOpening.dimB0
						|| //
						myParent.lean4 == 2
						&& myMullionBot != null
						&& myMullionBot.y2 > myBOpening.highestY
								+ myBOpening.dimD2
						|| //
						myParent.lean2 == 1
						&& myMullionBot != null
						&& myMullionBot.y4 > myBOpening.highestY
								+ myBOpening.dimB1

				) {

					if (myInitOpening.endRow < myBOpening.yRows) {
						if (myMullionBot != null && myBOpening.noSidesBot == 1) {
							if (myParent.lean2 == 0
									&& (myParent.lean4 == 2
											&& myMullionTop.y1 < myBOpening.highestY
													+ myBOpening.dimD2
											&& myMullionBot.y2 > myBOpening.highestY
													+ myBOpening.dimD2 || //

									myParent.lean4 == 3
											&& myMullionTop.y1 < myBOpening.highestY
													+ myBOpening.dimD2
													+ myBOpening.dimD1
											&& myMullionBot.y2 > myBOpening.highestY
													+ myBOpening.dimD2
													+ myBOpening.dimD1)) {
								if (!myInitOpening.leftIn
										&& myInitOpening.noSidesLeft == 1) {

									b2x2 = myBOpening.bot1.endX;
									b2y2 = myBOpening.bot1.endY;
									b2x2A = myBOpening.bot1.endXA;
									b2y2A = myBOpening.bot1.endYA;
									b2x2c = myBOpening.myParent.bot1.endX;
									b2y2c = myBOpening.myParent.bot1.endY;
									t2s = myBOpening.bot1.partForm;
									t1s = 1;
									if (myInitOpening.rightIn) {
										if (myMullionRight.x4 < myMullionBot.x2) {
											b2x1 = myMullionRight.x4;
											b2y1 = myMullionRight.y4;
											b2x1A = myMullionRight.x4al;
											b2y1A = myMullionRight.y4al;
											b2x1c = myMullionRight.centerXe;
											b2y1c = myMullionRight.centerYe;

										} else if (myMullionRight.x4 > myMullionBot.x2) {
											b2x1 = myMullionBot.x2;
											b2y1 = myMullionBot.y2;
											b2x1A = myMullionBot.x2cl;
											b2y1A = myMullionBot.y2cl;
											b2x1c = myMullionBot.centerXs;
											b2y1c = myMullionBot.centerYs;
										}

									} else {
										b2x1 = myMullionBot.x2;
										b2y1 = myMullionBot.y2;
										b2x1A = myMullionBot.x2cl;
										b2y1A = myMullionBot.y2cl;
										b2x1c = myMullionBot.centerXs;
										b2y1c = myMullionBot.centerYs;
									}
								} else {
									b2x2 = myMullionLeft.x3;
									b2y2 = myMullionLeft.y3;
									b2x2A = myMullionLeft.x3cl;
									b2y2A = myMullionLeft.y3cl;
									b2x2c = myMullionLeft.centerXe;
									b2y2c = myMullionLeft.centerYe;
								}

								myInitOpening.noSidesBot = 2;
							} // lean
								// test

							if (myParent.lean4 == 0
									&& (myParent.lean2 == 1
											&& myMullionTop.y4 < myBOpening.highestY
													+ myBOpening.dimB1
											&& myMullionBot.y3 > myBOpening.highestY
													+ myBOpening.dimB1 || myParent.lean2 == 3
											&& myMullionTop.y4 < myBOpening.highestY
													+ myBOpening.dimB1
													+ myBOpening.dimB0
											&& myMullionBot.y3 > myBOpening.highestY
													+ myBOpening.dimB1
													+ myBOpening.dimB0)) {
								if (!myInitOpening.rightIn
										&& myInitOpening.noSidesRight == 1) {

									bx1 = myBOpening.bot1.startX;
									by1 = myBOpening.bot1.startY;
									bx1A = myBOpening.bot1.startXA;
									by1A = myBOpening.bot1.startYA;
									bx1c = myBOpening.myParent.bot1.startX;
									by1c = myBOpening.myParent.bot1.startY;
									t1s = myBOpening.bot1.partForm;
									if (myInitOpening.leftIn) {
										if (myMullionLeft.x3 < myMullionBot.x3) {
											bx2 = myMullionBot.x3;
											by2 = myMullionBot.y3;
											bx2A = myMullionBot.x3cl;
											by2A = myMullionBot.y3cl;
											bx2c = myMullionBot.centerXe;
											by2c = myMullionBot.centerYe;

										} else if (myMullionLeft.x4 > myMullionBot.x3) {
											bx2 = myMullionLeft.x3;
											by2 = myMullionLeft.y3;
											bx2A = myMullionBot.x3cl;
											by2A = myMullionBot.y3cl;
											bx2c = myMullionLeft.centerXe;
											by2c = myMullionLeft.centerYe;
										}

									} else {
										bx2 = myMullionBot.x3;
										by2 = myMullionBot.y3;
										bx2A = myMullionBot.x3cl;
										by2A = myMullionBot.y3cl;
										bx2c = myMullionBot.centerXe;
										by2c = myMullionBot.centerYe;
									}
									b2x2 = myMullionBot.x2;
									b2y2 = myMullionBot.y2;
									b2x2A = myMullionBot.x2cl;
									b2y2A = myMullionBot.y2cl;
									b2x2c = myMullionBot.centerXs;
									b2y2c = myMullionBot.centerYs;
									b2x1 = myMullionBot.x3;
									b2y1 = myMullionBot.y3;
									b2x1A = myMullionBot.x3cl;
									b2y1A = myMullionBot.y3cl;
									b2x1c = myMullionBot.centerXe;
									b2y1c = myMullionBot.centerYe;
									myInitOpening.noSidesBot = 2;
								} else {
									bx1 = myMullionBot.x3;
									by1 = myMullionBot.y3;
									bx1A = myMullionBot.x3cl;
									by1A = myMullionBot.y3cl;
									bx1c = myMullionBot.centerXe;
									by1c = myMullionBot.centerYe;
									// if
									// (!opening.leftIn)
									// {
									bx2 = myMullionBot.x2;
									by2 = myMullionBot.y2;
									bx2A = myMullionBot.x2cl;
									by2A = myMullionBot.y2cl;
									bx2c = myMullionBot.centerXs;
									by2c = myMullionBot.centerYs;

								}

							} // lean
								// test

						}// Not Null
							// Test &&
							// NosidesBot
							// ==1

						if (myMullionTop != null && myMullionBot != null
								&& myBOpening.noSidesBot == 3) {

							if (!myInitOpening.leftIn) {

								b2x2 = myBOpening.bot2.endX;
								b2y2 = myBOpening.bot2.endY;
								b2x2A = myBOpening.bot2.endXA;
								b2y2A = myBOpening.bot2.endYA;
								b2x2c = myBOpening.myParent.bot2.endX;
								b2y2c = myBOpening.myParent.bot2.endY;
								t2s = myBOpening.bot2.partForm;
								t1s = 1;
								if (myInitOpening.rightIn) {
									if (myMullionRight.x4 < myMullionBot.x2) {
										b2x1 = myMullionRight.x4;
										b2y1 = myMullionRight.y4;
										b2x1A = myMullionRight.x4al;
										b2y1A = myMullionRight.y4al;
										b2x1c = myMullionRight.centerXe;
										b2y1c = myMullionRight.centerYe;

									} else if (myMullionRight.x4 > myMullionBot.x2) {
										b2x1 = myMullionBot.x2;
										b2y1 = myMullionBot.y2;
										b2x1A = myMullionBot.x2cl;
										b2y1A = myMullionBot.y2cl;
										b2x1c = myMullionBot.centerXs;
										b2y1c = myMullionBot.centerYs;
									}

								} else {
									b2x1 = myMullionBot.x2;
									b2y1 = myMullionBot.y2;
									b2x1A = myMullionBot.x2cl;
									b2y1A = myMullionBot.y2cl;
									b2x1c = myMullionBot.centerXs;
									b2y1c = myMullionBot.centerYs;
								}
							} else {

							}

							myInitOpening.noSidesBot = 2;

						}// Not Null
							// Test &&
							// NosidesBot
							// ==3

					} // main test

				}

				if (moreTop) {

					if (!myInitOpening.leftIn) {
						if (moreTop1) {
							tx1 = myBOpening.top1.startX;
							ty1 = myBOpening.top1.startY;
							tx1A = myBOpening.top1.startXA;
							ty1A = myBOpening.top1.startYA;
							tx1c = myBOpening.myParent.top1.startX;
							ty1c = myBOpening.myParent.top1.startY;

							tx2 = myBOpening.top1.endX;
							ty2 = myBOpening.top1.endY;
							tx2A = myBOpening.top1.endXA;
							ty2A = myBOpening.top1.endYA;
							tx2c = myBOpening.myParent.top1.endX;
							ty2c = myBOpening.myParent.top1.endY;
							t1s = myBOpening.top1.partForm;

							if (t1s > 1) {
								tx2 = myMullionTop.x1;
								ty2 = myMullionTop.y1;
								tx2A = myMullionTop.x1al;
								ty2A = myMullionTop.y1al;
								tx2c = myMullionTop.centerXs;
								ty2c = myMullionTop.centerYs;
								if (myInitOpening.botIn
										&& ty1 > myMullionBot.y2) {

									tx1 = myMullionBot.x2;
									ty1 = myMullionBot.y2;
									tx1A = myMullionBot.x2cl;
									ty1A = myMullionBot.y2cl;
									tx1c = myMullionBot.centerXs;
									ty1c = myMullionBot.centerYs;

								}
							}

							if (!myInitOpening.rightIn) {
								if (moreTop3) {
									t3x1 = myMullionTop.x1;
									t3y1 = myMullionTop.y1;
									t3x1A = myMullionTop.x1al;
									t3y1A = myMullionTop.y1al;
									t3x1c = myMullionTop.centerXs;
									t3y1c = myMullionTop.centerYs;
									t3x2 = myMullionTop.x4;
									t3y2 = myMullionTop.y4;
									t3x2A = myMullionTop.x4al;
									t3y2A = myMullionTop.y4al;
									t3x2c = myMullionTop.centerXe;
									t3y2c = myMullionTop.centerYe;
									t3s = myMullionTop.partForm;
									if (myBOpening.noSidesTop > 1) {

										t2x1 = myBOpening.top2.startX;
										t2y1 = myBOpening.top2.startY;
										t2x1A = myBOpening.top2.startXA;
										t2y1A = myBOpening.top2.startYA;
										t2x1c = myBOpening.myParent.top2.startX;
										t2y1c = myBOpening.myParent.top2.startY;

										t2x2 = myBOpening.top2.endX;
										t2y2 = myBOpening.top2.endY;
										t2x2A = myBOpening.top2.endXA;
										t2y2A = myBOpening.top2.endYA;
										t2x2c = myBOpening.myParent.top2.endX;
										t2y2c = myBOpening.myParent.top2.endY;
										t2s = myBOpening.top2.partForm;

										if (t2s > 1) {
											t2x1 = myMullionTop.x4;
											t2y1 = myMullionTop.y4;
											t2x1A = myMullionTop.x4al;
											t2y1A = myMullionTop.y4al;
											t2x1c = myMullionTop.centerXe;
											t2y1c = myMullionTop.centerYe;
											if (myInitOpening.botIn
													&& ty1 > myMullionBot.y2) {

												t2x2 = myMullionBot.x3;
												t2y2 = myMullionBot.y3;
												t2x2A = myMullionBot.x3cl;
												t2y2A = myMullionBot.y3cl;
												t2x2c = myMullionBot.centerXe;
												t2y2c = myMullionBot.centerYe;

											}
										}

									} else {

										t2x1 = myBOpening.top1.startX;
										t2y1 = myBOpening.top1.startY;
										t2x1A = myBOpening.top1.startXA;
										t2y1A = myBOpening.top1.startYA;
										t2x1c = myBOpening.myParent.top1.startX;
										t2y1c = myBOpening.myParent.top1.startY;

										t2x2 = myBOpening.top1.endX;
										t2y2 = myBOpening.top1.endY;
										t2x2A = myBOpening.top1.endXA;
										t2y2A = myBOpening.top1.endYA;
										t2x2c = myBOpening.myParent.top1.endX;
										t2y2c = myBOpening.myParent.top1.endY;
										t2s = myBOpening.top1.partForm;

										if (myInitOpening.topIn) {

											t2x1 = myMullionTop.x4;
											t2y1 = myMullionTop.y4;
											t2x1A = myMullionTop.x4al;
											t2y1A = myMullionTop.y4al;
											t2x1c = myMullionTop.centerXe;
											t2y1c = myMullionTop.centerYe;
											if (myInitOpening.botIn
													&& t2y2 > myMullionBot.y2) {

												t2x2 = myMullionBot.x3;
												t2y2 = myMullionBot.y3;
												t2x2A = myMullionBot.x3cl;
												t2y2A = myMullionBot.y3cl;
												t2x2c = myMullionBot.centerXe;
												t2y2c = myMullionBot.centerYe;

											}
										}

									}

									// t2x1
									// =
									// myMullionTop.x4;
									// t2y1
									// =
									// myMullionTop.y4;
									// t2x1A
									// =
									// myMullionTop.x4al;
									// t2y1A
									// =
									// myMullionTop.y4al;
									// t2x1c
									// =
									// myMullionTop.centerXe;
									// t2y1c
									// =
									// myMullionTop.centerYe;
									myInitOpening.noSidesTop = 3;
								} else {
									t2x1 = myMullionTop.x1;
									t2y1 = myMullionTop.y1;
									t2x1A = myMullionTop.x1al;
									t2y1A = myMullionTop.y1al;
									t2x1c = myMullionTop.centerXs;
									t2y1c = myMullionTop.centerYs;
									t2x2 = myMullionTop.x4;
									t2y2 = myMullionTop.y4;
									t2x2A = myMullionTop.x4al;
									t2y2A = myMullionTop.y4al;
									t2x2c = myMullionTop.centerXe;
									t2y2c = myMullionTop.centerYe;
									t2s = myMullionTop.partForm;
									myInitOpening.noSidesTop = 2;
								}

							} else {
								t2x1 = myMullionTop.x1;
								t2y1 = myMullionTop.y1;
								t2x1A = myMullionTop.x1al;
								t2y1A = myMullionTop.y1al;
								t2x1c = myMullionTop.centerXs;
								t2y1c = myMullionTop.centerYs;
								t2x2 = myMullionTop.x4;
								t2y2 = myMullionTop.y4;
								t2x2A = myMullionTop.x4al;
								t2y2A = myMullionTop.y4al;
								t2x2c = myMullionTop.centerXe;
								t2y2c = myMullionTop.centerYe;
								t2s = myMullionTop.partForm;
								myInitOpening.noSidesTop = 2;
							}
						}
						if (moreTop2) {
							if (!myInitOpening.rightIn && !moreTop3) {
								tx1 = myMullionTop.x1;
								ty1 = myMullionTop.y1;
								tx1A = myMullionTop.x1al;
								ty1A = myMullionTop.y1al;
								tx1c = myMullionTop.centerXs;
								ty1c = myMullionTop.centerYs;
								tx2 = myMullionTop.x4;
								ty2 = myMullionTop.y4;
								tx2A = myMullionTop.x4al;
								ty2A = myMullionTop.y4al;
								tx2c = myMullionTop.centerXe;
								ty2c = myMullionTop.centerYe;
								t1s = myMullionTop.partForm;

								if (myBOpening.noSidesTop > 1) {

									t2x1 = myBOpening.top2.startX;
									t2y1 = myBOpening.top2.startY;
									t2x1A = myBOpening.top2.startXA;
									t2y1A = myBOpening.top2.startYA;
									t2x1c = myBOpening.myParent.top2.startX;
									t2y1c = myBOpening.myParent.top2.startY;

									t2x2 = myBOpening.top2.endX;
									t2y2 = myBOpening.top2.endY;
									t2x2A = myBOpening.top2.endXA;
									t2y2A = myBOpening.top2.endYA;
									t2x2c = myBOpening.myParent.top2.endX;
									t2y2c = myBOpening.myParent.top2.endY;
									t2s = myBOpening.top2.partForm;
									t2x1 = myMullionTop.x4;
									t2y1 = myMullionTop.y4;
									t2x1A = myMullionTop.x4al;
									t2y1A = myMullionTop.y4al;
									t2x1c = myMullionTop.centerXe;
									t2y1c = myMullionTop.centerYe;
								} else {

									t2x2 = myBOpening.top1.endX;
									t2y2 = myBOpening.top1.endY;
									t2x2A = myBOpening.top1.endXA;
									t2y2A = myBOpening.top1.endYA;
									t2x2c = myBOpening.myParent.top1.endX;
									t2y2c = myBOpening.myParent.top1.endY;
									t2s = myBOpening.top1.partForm;
									t2x1 = myMullionTop.x4;
									t2y1 = myMullionTop.y4;
									t2x1A = myMullionTop.x4al;
									t2y1A = myMullionTop.y4al;
									t2x1c = myMullionTop.centerXe;
									t2y1c = myMullionTop.centerYe;
								}

								myInitOpening.noSidesTop = 2;
							}
						}

					} else if (myInitOpening.leftIn) {
						if (!myInitOpening.rightIn) {
							tx1 = myMullionTop.x1;
							ty1 = myMullionTop.y1;
							tx1A = myMullionTop.x1al;
							ty1A = myMullionTop.y1al;
							tx1c = myMullionTop.centerXs;
							ty1c = myMullionTop.centerYs;
							tx2 = myMullionTop.x4;
							ty2 = myMullionTop.y4;
							tx2A = myMullionTop.x4al;
							ty2A = myMullionTop.y4al;
							tx2c = myMullionTop.centerXe;
							ty2c = myMullionTop.centerYe;

							t1s = myMullionTop.partForm;

							if (myBOpening.noSidesTop > 1) {

								t2x1 = myBOpening.top2.startX;
								t2y1 = myBOpening.top2.startY;
								t2x1A = myBOpening.top2.startXA;
								t2y1A = myBOpening.top2.startYA;
								t2x1c = myBOpening.myParent.top2.startX;
								t2y1c = myBOpening.myParent.top2.startY;

								t2x2 = myBOpening.top2.endX;
								t2y2 = myBOpening.top2.endY;
								t2x2A = myBOpening.top2.endXA;
								t2y2A = myBOpening.top2.endYA;
								t2x2c = myBOpening.myParent.top2.endX;
								t2y2c = myBOpening.myParent.top2.endY;
								t2s = myBOpening.top2.partForm;
								t2x1 = myMullionTop.x4;
								t2y1 = myMullionTop.y4;
								t2x1A = myMullionTop.x4al;
								t2y1A = myMullionTop.y4al;
								t2x1c = myMullionTop.centerXe;
								t2y1c = myMullionTop.centerYe;
							} else {

								t2x2 = myBOpening.top1.endX;
								t2y2 = myBOpening.top1.endY;
								t2x2A = myBOpening.top1.endXA;
								t2y2A = myBOpening.top1.endYA;
								t2x2c = myBOpening.myParent.top1.endX;
								t2y2c = myBOpening.myParent.top1.endY;
								t2s = myBOpening.top1.partForm;
								t2x1 = myMullionTop.x4;
								t2y1 = myMullionTop.y4;
								t2x1A = myMullionTop.x4al;
								t2y1A = myMullionTop.y4al;
								t2x1c = myMullionTop.centerXe;
								t2y1c = myMullionTop.centerYe;
							}

							myInitOpening.noSidesTop = 2;
						} else {

						}

					}

				}

			}
			// //////////////////////////////////////

			if (myInitOpening.botIn && !myInitOpening.topIn) {
				if (ty1 > myMullionBot.y2) {
					tx1 = myMullionBot.x2;
					ty1 = myMullionBot.y2;
					tx1A = myMullionBot.x2cl;
					ty1A = myMullionBot.y2cl;
					tx1c = myMullionBot.centerXs;
					ty1c = myMullionBot.centerYs;
				}
				if (ty2 > myMullionBot.y3) {
					tx2 = myMullionBot.x3;
					ty2 = myMullionBot.y3;
					tx2A = myMullionBot.x3cl;
					ty2A = myMullionBot.y3cl;
					tx2c = myMullionBot.centerXe;
					ty2c = myMullionBot.centerYe;
				}
				if (t2y2 > myMullionBot.y3) {
					t2x2 = myMullionBot.x3;
					t2y2 = myMullionBot.y3;
					t2x2A = myMullionBot.x3cl;
					t2y2A = myMullionBot.y3cl;
					t2x2c = myMullionBot.centerXe;
					t2y2c = myMullionBot.centerYe;
				}

				if (myInitOpening.topIn) {

					t2x1 = myMullionTop.x4;
					t2y1 = myMullionTop.y4;
					t2x1A = myMullionTop.x4al;
					t2y1A = myMullionTop.y4al;
					t2x1c = myMullionTop.centerXe;
					t2y1c = myMullionTop.centerYe;
				}

			}

			if (ty1 > by2 && myInitOpening.noSidesBot == 1
					&& !myInitOpening.leftIn) {
				myInitOpening.noSidesLeft = 0;
			}
			if (ty1 > by2 && myInitOpening.noSidesBot > 1
					&& !myInitOpening.leftIn) {
				myInitOpening.noSidesLeft = 0;
			}
			if (ty2 > by1 && myInitOpening.noSidesBot < 3
					&& !myInitOpening.rightIn) {
				myInitOpening.noSidesRight = 0;
			}
			if (ty2 > by1 && myInitOpening.noSidesBot == 3
					&& !myInitOpening.rightIn) {
				myInitOpening.noSidesRight = 0;
			}

			if (!myInitOpening.leftIn) {
				if (myBOpening.noSidesLeft == 0) {
					myInitOpening.noSidesLeft = 0;
				}
			}
			if (!myInitOpening.rightIn) {
				if (myBOpening.noSidesRight == 0) {
					myInitOpening.noSidesRight = 0;
				}
			}

			// //////////////////////////////////////////
			// }
			if (myInitOpening.leftIn) {
				if (myMullionLeft.x1al > myBOpening.myParent.leftPart.startXBA
						&& myMullionLeft.x2cl < myBOpening.myParent.leftPart.endXBA) {

					final double newt1x1 = this.intersectX(
							myBOpening.leftPart.startXC,
							myBOpening.leftPart.startYC,
							myBOpening.leftPart.endXC,
							myBOpening.leftPart.endYC, myMullionLeft.x2,
							myMullionLeft.y2, myMullionLeft.x3,
							myMullionLeft.y3);
					final double newt1y1 = this.intersectY(
							myBOpening.leftPart.startXC,
							myBOpening.leftPart.startYC,
							myBOpening.leftPart.endXC,
							myBOpening.leftPart.endYC, myMullionLeft.x2,
							myMullionLeft.y2, myMullionLeft.x3,
							myMullionLeft.y3);

					final double newt1x1A = this.intersectX(
							myBOpening.leftPart.startXC,
							myBOpening.leftPart.startYC,
							myBOpening.leftPart.endXC,
							myBOpening.leftPart.endYC, myMullionLeft.x2cl,
							myMullionLeft.y2cl, myMullionLeft.x3cl,
							myMullionLeft.y3cl);
					final double newt1y1A = this.intersectY(
							myBOpening.leftPart.startXC,
							myBOpening.leftPart.startYC,
							myBOpening.leftPart.endXC,
							myBOpening.leftPart.endYC, myMullionLeft.x2cl,
							myMullionLeft.y2cl, myMullionLeft.x3cl,
							myMullionLeft.y3cl);

					final double newt1x1c = this.intersectX(
							myBOpening.leftPart.startXC,
							myBOpening.leftPart.startYC,
							myBOpening.leftPart.endXC,
							myBOpening.leftPart.endYC, myMullionLeft.centerXs,
							myMullionLeft.centerYs, myMullionLeft.centerXe,
							myMullionLeft.centerYe);
					final double newt1y1c = this.intersectY(
							myBOpening.leftPart.startXC,
							myBOpening.leftPart.startYC,
							myBOpening.leftPart.endXC,
							myBOpening.leftPart.endYC, myMullionLeft.centerXs,
							myMullionLeft.centerYs, myMullionLeft.centerXe,
							myMullionLeft.centerYe);

					tx1 = newt1x1;
					tx1A = newt1x1A;
					tx1c = newt1x1c;
					ty1 = newt1y1;
					ty1A = newt1y1A;
					ty1c = newt1y1c;

					if (myInitOpening.rightIn
							&& myMullionRight.x1al > myBOpening.top1Part.startXC
							&& myMullionRight.x2cl < myBOpening.top1Part.endXC) {
						myInitOpening.noSidesTop = 2;

						t2x2 = tx2;
						t2y2 = ty2;
						t2x2A = tx2A;
						t2y2A = ty2A;
						t2x2c = tx2c;
						t2y2c = ty2c;

						tx2 = t2x1 = this.intersectX(
								myBOpening.leftPart.startXC,
								myBOpening.leftPart.startYC,
								myBOpening.leftPart.endXC,
								myBOpening.leftPart.endYC,
								myBOpening.top1Part.startXC,
								myBOpening.top1Part.startYC,
								myBOpening.top1Part.endXC,
								myBOpening.top1Part.endYC);
						ty2 = t2y1 = this.intersectY(
								myBOpening.leftPart.startXC,
								myBOpening.leftPart.startYC,
								myBOpening.leftPart.endXC,
								myBOpening.leftPart.endYC,
								myBOpening.top1Part.startXC,
								myBOpening.top1Part.startYC,
								myBOpening.top1Part.endXC,
								myBOpening.top1Part.endYC);

						tx2A = t2x1A = this.intersectX(
								myBOpening.leftPart.startXA,
								myBOpening.leftPart.startYA,
								myBOpening.leftPart.endXA,
								myBOpening.leftPart.endYA,
								myBOpening.top1Part.startXA,
								myBOpening.top1Part.startYA,
								myBOpening.top1Part.endXA,
								myBOpening.top1Part.endYA);
						ty2A = t2y1A = this.intersectY(
								myBOpening.leftPart.startXA,
								myBOpening.leftPart.startYA,
								myBOpening.leftPart.endXA,
								myBOpening.leftPart.endYA,
								myBOpening.top1Part.startXA,
								myBOpening.top1Part.startYA,
								myBOpening.top1Part.endXA,
								myBOpening.top1Part.endYA);

						tx2c = t2x1c = this.intersectX(
								myBOpening.myParent.leftPart.startXC,
								myBOpening.myParent.leftPart.startYC,
								myBOpening.myParent.leftPart.endXC,
								myBOpening.myParent.leftPart.endYC,
								myBOpening.myParent.top1Part.startXC,
								myBOpening.myParent.top1Part.startYC,
								myBOpening.myParent.top1Part.endXC,
								myBOpening.myParent.top1Part.endYC);
						ty2c = t2y1c = this.intersectY(
								myBOpening.myParent.leftPart.startXC,
								myBOpening.myParent.leftPart.startYC,
								myBOpening.myParent.leftPart.endXC,
								myBOpening.myParent.leftPart.endYC,
								myBOpening.myParent.top1Part.startXC,
								myBOpening.myParent.top1Part.startYC,
								myBOpening.myParent.top1Part.endXC,
								myBOpening.myParent.top1Part.endYC);

					}
					if (!myInitOpening.rightIn) {
						myInitOpening.noSidesTop = 2;

						t2x2 = tx2;
						t2y2 = ty2;
						t2x2A = tx2A;
						t2y2A = ty2A;
						t2x2c = tx2c;
						t2y2c = ty2c;

						tx2 = t2x1 = this.intersectX(
								myBOpening.leftPart.startXC,
								myBOpening.leftPart.startYC,
								myBOpening.leftPart.endXC,
								myBOpening.leftPart.endYC,
								myBOpening.top1Part.startXC,
								myBOpening.top1Part.startYC,
								myBOpening.top1Part.endXC,
								myBOpening.top1Part.endYC);
						ty2 = t2y1 = this.intersectY(
								myBOpening.leftPart.startXC,
								myBOpening.leftPart.startYC,
								myBOpening.leftPart.endXC,
								myBOpening.leftPart.endYC,
								myBOpening.top1Part.startXC,
								myBOpening.top1Part.startYC,
								myBOpening.top1Part.endXC,
								myBOpening.top1Part.endYC);

						tx2A = t2x1A = this.intersectX(
								myBOpening.leftPart.startXA,
								myBOpening.leftPart.startYA,
								myBOpening.leftPart.endXA,
								myBOpening.leftPart.endYA,
								myBOpening.top1Part.startXA,
								myBOpening.top1Part.startYA,
								myBOpening.top1Part.endXA,
								myBOpening.top1Part.endYA);
						ty2A = t2y1A = this.intersectY(
								myBOpening.leftPart.startXA,
								myBOpening.leftPart.startYA,
								myBOpening.leftPart.endXA,
								myBOpening.leftPart.endYA,
								myBOpening.top1Part.startXA,
								myBOpening.top1Part.startYA,
								myBOpening.top1Part.endXA,
								myBOpening.top1Part.endYA);

						tx2c = t2x1c = this.intersectX(
								myBOpening.myParent.leftPart.startXC,
								myBOpening.myParent.leftPart.startYC,
								myBOpening.myParent.leftPart.endXC,
								myBOpening.myParent.leftPart.endYC,
								myBOpening.myParent.top1Part.startXC,
								myBOpening.myParent.top1Part.startYC,
								myBOpening.myParent.top1Part.endXC,
								myBOpening.myParent.top1Part.endYC);
						ty2c = t2y1c = this.intersectY(
								myBOpening.myParent.leftPart.startXC,
								myBOpening.myParent.leftPart.startYC,
								myBOpening.myParent.leftPart.endXC,
								myBOpening.myParent.leftPart.endYC,
								myBOpening.myParent.top1Part.startXC,
								myBOpening.myParent.top1Part.startYC,
								myBOpening.myParent.top1Part.endXC,
								myBOpening.myParent.top1Part.endYC);

					}

				}
			}

			if (myInitOpening.rightIn) {
				if (myMullionRight.x1al > myBOpening.myParent.leftPart.startXBA
						&& myMullionRight.x2cl < myBOpening.myParent.leftPart.endXBA) {

					final double newt1x2 = this.intersectX(
							myBOpening.leftPart.startXC,
							myBOpening.leftPart.startYC,
							myBOpening.leftPart.endXC,
							myBOpening.leftPart.endYC, myMullionRight.x1,
							myMullionRight.y1, myMullionRight.x4,
							myMullionRight.y4);
					final double newt1y2 = this.intersectY(
							myBOpening.leftPart.startXC,
							myBOpening.leftPart.startYC,
							myBOpening.leftPart.endXC,
							myBOpening.leftPart.endYC, myMullionRight.x1,
							myMullionRight.y1, myMullionRight.x4,
							myMullionRight.y4);

					final double newt1x2A = this.intersectX(
							myBOpening.leftPart.startXC,
							myBOpening.leftPart.startYC,
							myBOpening.leftPart.endXC,
							myBOpening.leftPart.endYC, myMullionRight.x1al,
							myMullionRight.y1al, myMullionRight.x4al,
							myMullionRight.y4al);
					final double newt1y2A = this.intersectY(
							myBOpening.leftPart.startXC,
							myBOpening.leftPart.startYC,
							myBOpening.leftPart.endXC,
							myBOpening.leftPart.endYC, myMullionRight.x1al,
							myMullionRight.y1al, myMullionRight.x4al,
							myMullionRight.y4al);

					final double newt1x2c = this.intersectX(
							myBOpening.leftPart.startXC,
							myBOpening.leftPart.startYC,
							myBOpening.leftPart.endXC,
							myBOpening.leftPart.endYC, myMullionRight.centerXs,
							myMullionRight.centerYs, myMullionRight.centerXe,
							myMullionRight.centerYe);
					final double newt1y2c = this.intersectY(
							myBOpening.leftPart.startXC,
							myBOpening.leftPart.startYC,
							myBOpening.leftPart.endXC,
							myBOpening.leftPart.endYC, myMullionRight.centerXs,
							myMullionRight.centerYs, myMullionRight.centerXe,
							myMullionRight.centerYe);

					tx2 = newt1x2;
					tx2A = newt1x2A;
					tx2c = newt1x2c;
					ty2 = newt1y2;
					ty2A = newt1y2A;
					ty2c = newt1y2c;

				}
			}

			if (myInitOpening.leftIn) {
				if (myMullionLeft.x1al > myBOpening.myParent.rightPart.startXBA
						&& myMullionLeft.x2cl < myBOpening.myParent.rightPart.endXBA) {

					final double newt1x1 = this.intersectX(
							myBOpening.rightPart.startXC,
							myBOpening.rightPart.startYC,
							myBOpening.rightPart.endXC,
							myBOpening.rightPart.endYC, myMullionLeft.x2,
							myMullionLeft.y2, myMullionLeft.x3,
							myMullionLeft.y3);
					final double newt1y1 = this.intersectY(
							myBOpening.rightPart.startXC,
							myBOpening.rightPart.startYC,
							myBOpening.rightPart.endXC,
							myBOpening.rightPart.endYC, myMullionLeft.x2,
							myMullionLeft.y2, myMullionLeft.x3,
							myMullionLeft.y3);

					final double newt1x1A = this.intersectX(
							myBOpening.rightPart.startXC,
							myBOpening.rightPart.startYC,
							myBOpening.rightPart.endXC,
							myBOpening.rightPart.endYC, myMullionLeft.x2cl,
							myMullionLeft.y2cl, myMullionLeft.x3cl,
							myMullionLeft.y3cl);
					final double newt1y1A = this.intersectY(
							myBOpening.rightPart.startXC,
							myBOpening.rightPart.startYC,
							myBOpening.rightPart.endXC,
							myBOpening.rightPart.endYC, myMullionLeft.x2cl,
							myMullionLeft.y2cl, myMullionLeft.x3cl,
							myMullionLeft.y3cl);

					final double newt1x1c = this.intersectX(
							myBOpening.rightPart.startXC,
							myBOpening.rightPart.startYC,
							myBOpening.rightPart.endXC,
							myBOpening.rightPart.endYC, myMullionLeft.centerXs,
							myMullionLeft.centerYs, myMullionLeft.centerXe,
							myMullionLeft.centerYe);
					final double newt1y1c = this.intersectY(
							myBOpening.rightPart.startXC,
							myBOpening.rightPart.startYC,
							myBOpening.rightPart.endXC,
							myBOpening.rightPart.endYC, myMullionLeft.centerXs,
							myMullionLeft.centerYs, myMullionLeft.centerXe,
							myMullionLeft.centerYe);

					tx1 = newt1x1;
					tx1A = newt1x1A;
					tx1c = newt1x1c;
					ty1 = newt1y1;
					ty1A = newt1y1A;
					ty1c = newt1y1c;

				}
			}

			if (myInitOpening.rightIn) {
				if (myMullionRight.x1al > myBOpening.right.startXBA
						&& myMullionRight.x2cl < myBOpening.myParent.rightPart.endXBA) {

					final double newt1x2 = this.intersectX(
							myBOpening.rightPart.startXC,
							myBOpening.rightPart.startYC,
							myBOpening.rightPart.endXC,
							myBOpening.rightPart.endYC, myMullionRight.x1,
							myMullionRight.y1, myMullionRight.x4,
							myMullionRight.y4);
					final double newt1y2 = this.intersectY(
							myBOpening.rightPart.startXC,
							myBOpening.rightPart.startYC,
							myBOpening.rightPart.endXC,
							myBOpening.rightPart.endYC, myMullionRight.x1,
							myMullionRight.y1, myMullionRight.x4,
							myMullionRight.y4);

					final double newt1x2A = this.intersectX(
							myBOpening.rightPart.startXC,
							myBOpening.rightPart.startYC,
							myBOpening.rightPart.endXC,
							myBOpening.rightPart.endYC, myMullionRight.x1al,
							myMullionRight.y1al, myMullionRight.x4al,
							myMullionRight.y4al);
					final double newt1y2A = this.intersectY(
							myBOpening.rightPart.startXC,
							myBOpening.rightPart.startYC,
							myBOpening.rightPart.endXC,
							myBOpening.rightPart.endYC, myMullionRight.x1al,
							myMullionRight.y1al, myMullionRight.x4al,
							myMullionRight.y4al);

					final double newt1x2c = this.intersectX(
							myBOpening.rightPart.startXC,
							myBOpening.rightPart.startYC,
							myBOpening.rightPart.endXC,
							myBOpening.rightPart.endYC,
							myMullionRight.centerXs, myMullionRight.centerYs,
							myMullionRight.centerXe, myMullionRight.centerYe);
					final double newt1y2c = this.intersectY(
							myBOpening.rightPart.startXC,
							myBOpening.rightPart.startYC,
							myBOpening.rightPart.endXC,
							myBOpening.rightPart.endYC,
							myMullionRight.centerXs, myMullionRight.centerYs,
							myMullionRight.centerXe, myMullionRight.centerYe);
					if (!myInitOpening.leftIn) {
						myInitOpening.noSidesTop = 2;
						t2x1 = tx2 = this.intersectX(
								myBOpening.rightPart.startXC,
								myBOpening.rightPart.startYC,
								myBOpening.rightPart.endXC,
								myBOpening.rightPart.endYC,
								myBOpening.top1Part.startXC,
								myBOpening.top1Part.startYC,
								myBOpening.top1Part.endXC,
								myBOpening.top1Part.endYC);
						t2x1A = tx2A = this.intersectX(
								myBOpening.rightPart.startXA,
								myBOpening.rightPart.startYA,
								myBOpening.rightPart.endXA,
								myBOpening.rightPart.endYA,
								myBOpening.top1Part.startXA,
								myBOpening.top1Part.startYA,
								myBOpening.top1Part.endXA,
								myBOpening.top1Part.endYA);
						t2x1c = tx2c = this.intersectX(
								myBOpening.myParent.rightPart.startXC,
								myBOpening.myParent.rightPart.startYC,
								myBOpening.myParent.rightPart.endXC,
								myBOpening.myParent.rightPart.endYC,
								myBOpening.myParent.top1Part.startXC,
								myBOpening.myParent.top1Part.startYC,
								myBOpening.myParent.top1Part.endXC,
								myBOpening.myParent.top1Part.endYC);

						t2y1 = ty2 = this.intersectY(
								myBOpening.rightPart.startXC,
								myBOpening.rightPart.startYC,
								myBOpening.rightPart.endXC,
								myBOpening.rightPart.endYC,
								myBOpening.top1Part.startXC,
								myBOpening.top1Part.startYC,
								myBOpening.top1Part.endXC,
								myBOpening.top1Part.endYC);
						t2y1A = ty2A = this.intersectY(
								myBOpening.rightPart.startXA,
								myBOpening.rightPart.startYA,
								myBOpening.rightPart.endXA,
								myBOpening.rightPart.endYA,
								myBOpening.top1Part.startXA,
								myBOpening.top1Part.startYA,
								myBOpening.top1Part.endXA,
								myBOpening.top1Part.endYA);
						t2y1c = ty2c = this.intersectY(
								myBOpening.myParent.rightPart.startXC,
								myBOpening.myParent.rightPart.startYC,
								myBOpening.myParent.rightPart.endXC,
								myBOpening.myParent.rightPart.endYC,
								myBOpening.myParent.top1Part.startXC,
								myBOpening.myParent.top1Part.startYC,
								myBOpening.myParent.top1Part.endXC,
								myBOpening.myParent.top1Part.endYC);

						t2x2 = newt1x2;
						t2x2A = newt1x2A;
						t2x2c = newt1x2c;
						t2y2 = newt1y2;
						t2y2A = newt1y2A;
						t2y2c = newt1y2c;
					} else if (myInitOpening.leftIn
							&& myMullionLeft.x1al > myBOpening.top1Part.startXC
							&& myMullionLeft.x2cl < myBOpening.top1Part.endXC
							|| myMullionLeft.x1al > myBOpening.top3Part.startXC
							&& myMullionLeft.x2cl < myBOpening.top3Part.endXC) {
						myInitOpening.noSidesTop = 2;
						t2x1 = tx2 = this.intersectX(
								myBOpening.rightPart.startXC,
								myBOpening.rightPart.startYC,
								myBOpening.rightPart.endXC,
								myBOpening.rightPart.endYC,
								myBOpening.top1Part.startXC,
								myBOpening.top1Part.startYC,
								myBOpening.top1Part.endXC,
								myBOpening.top1Part.endYC);
						t2x1A = tx2A = this.intersectX(
								myBOpening.rightPart.startXA,
								myBOpening.rightPart.startYA,
								myBOpening.rightPart.endXA,
								myBOpening.rightPart.endYA,
								myBOpening.top1Part.startXA,
								myBOpening.top1Part.startYA,
								myBOpening.top1Part.endXA,
								myBOpening.top1Part.endYA);
						t2x1c = tx2c = this.intersectX(
								myBOpening.myParent.rightPart.startXC,
								myBOpening.myParent.rightPart.startYC,
								myBOpening.myParent.rightPart.endXC,
								myBOpening.myParent.rightPart.endYC,
								myBOpening.myParent.top1Part.startXC,
								myBOpening.myParent.top1Part.startYC,
								myBOpening.myParent.top1Part.endXC,
								myBOpening.myParent.top1Part.endYC);

						t2y1 = ty2 = this.intersectY(
								myBOpening.rightPart.startXC,
								myBOpening.rightPart.startYC,
								myBOpening.rightPart.endXC,
								myBOpening.rightPart.endYC,
								myBOpening.top1Part.startXC,
								myBOpening.top1Part.startYC,
								myBOpening.top1Part.endXC,
								myBOpening.top1Part.endYC);
						t2y1A = ty2A = this.intersectY(
								myBOpening.rightPart.startXA,
								myBOpening.rightPart.startYA,
								myBOpening.rightPart.endXA,
								myBOpening.rightPart.endYA,
								myBOpening.top1Part.startXA,
								myBOpening.top1Part.startYA,
								myBOpening.top1Part.endXA,
								myBOpening.top1Part.endYA);
						t2y1c = ty2c = this.intersectY(
								myBOpening.myParent.rightPart.startXC,
								myBOpening.myParent.rightPart.startYC,
								myBOpening.myParent.rightPart.endXC,
								myBOpening.myParent.rightPart.endYC,
								myBOpening.myParent.top1Part.startXC,
								myBOpening.myParent.top1Part.startYC,
								myBOpening.myParent.top1Part.endXC,
								myBOpening.myParent.top1Part.endYC);
						t2x2 = newt1x2;
						t2x2A = newt1x2A;
						t2x2c = newt1x2c;
						t2y2 = newt1y2;
						t2y2A = newt1y2A;
						t2y2c = newt1y2c;

					} else {
						tx2 = newt1x2;
						tx2A = newt1x2A;
						tx2c = newt1x2c;
						ty2 = newt1y2;
						ty2A = newt1y2A;
						ty2c = newt1y2c;
					}

				}
			}
		}

		// //////////////////////////////////////////////////

		myInitOpening = setActiveSides(myInitOpening);
		myInitOpening.noSides = totalSides(myInitOpening);

		myInitOpening = getPxyALL(myInitOpening);

		myInitOpening = setPartObjectForms(myInitOpening);

		myInitOpening = verifyCenterPoints(myInitOpening);

		myInitOpening = posInUse(myInitOpening);

		myInitOpening = createOpeningShape(myInitOpening);

		return myInitOpening;

	}

	public OpeningObject setActiveSides(final OpeningObject myOpening) {

		myOpening.top1Part.posInUse = true;
		myOpening.top2Part.posInUse = false;
		myOpening.top3Part.posInUse = false;
		myOpening.leftPart.posInUse = false;
		myOpening.rightPart.posInUse = false;
		myOpening.bot1Part.posInUse = true;
		myOpening.bot2Part.posInUse = false;
		myOpening.bot3Part.posInUse = false;

		if (myOpening.noSidesTop == 2) {
			myOpening.top2Part.posInUse = true;
		}
		if (myOpening.noSidesTop == 3) {
			myOpening.top2Part.posInUse = true;
			myOpening.top3Part.posInUse = true;
		}
		if (myOpening.noSidesLeft == 1) {
			myOpening.leftPart.posInUse = true;
		}
		if (myOpening.noSidesRight == 1) {
			myOpening.rightPart.posInUse = true;
		}
		if (myOpening.noSidesBot == 2) {
			myOpening.bot2Part.posInUse = true;
		}
		if (myOpening.noSidesBot == 3) {
			myOpening.bot2Part.posInUse = true;
			myOpening.bot3Part.posInUse = true;
		}

		return myOpening;
	}

	public void doTopLimitsOLD(final OpeningObject myOpening,
			final Profiles myMullionLeft, final Profiles myMullionRight) {

		if (myOpening.startCol == 1 && myOpening.startRow == 1
				&& myOpening.endCol == myBOpening.xCols) {

			opening_OnlyOne(myOpening);

		}// row 1 colstart 1 colend last

		else if (myOpening.startCol == 1 && myOpening.startRow == 1
				&& myOpening.endCol < myBOpening.xCols) {

			opening_StartAtBegining_EndInMiddle(myOpening, myMullionRight);

		} // col 1 row 1 endcol < xcols

		else if (myOpening.startCol > 1 && myOpening.startRow == 1
				&& myOpening.endCol == myBOpening.xCols) {

			opening_StartInMiddle_EndAtEndCol(myOpening, myMullionLeft);

		} else if (myOpening.startCol > 1 && myOpening.startRow == 1
				&& myOpening.endCol < myBOpening.xCols) {

			opening_IntheMiddle(myOpening, myMullionLeft, myMullionRight);

		}
	}

	public void opening_Bottom_InTheMiddleOLD(
			final OpeningObject myInitOpening, final Profiles myMullionLeft,
			final Profiles myMullionRight) {

		myInitOpening.noSidesBot = 1;

		bx1 = myBOpening.bot1.startX;
		by1 = myBOpening.bot1.startY;
		bx1A = myBOpening.bot1.startXA;
		by1A = myBOpening.bot1.startYA;
		bx1c = myBOpening.myParent.bot1.startX;
		by1c = myBOpening.myParent.bot1.startY;

		bx2 = myBOpening.bot1.endX;
		by2 = myBOpening.bot1.endY;
		bx2A = myBOpening.bot1.endXA;
		by2A = myBOpening.bot1.endYA;
		bx2c = myBOpening.myParent.bot1.endX;
		by2c = myBOpening.myParent.bot1.endY;

		if (myBOpening.noSidesBot == 2
				&& myMullionLeft.x3 < myBOpening.myParent.bot2.endX
				&& myMullionRight.x4 < myBOpening.myParent.bot2.endX) {

			myInitOpening.noSidesBot = 1;

			bx1 = myBOpening.bot2.startX;
			by1 = myBOpening.bot2.startY;
			bx1A = myBOpening.bot2.startXA;
			by1A = myBOpening.bot2.startYA;
			bx1c = myBOpening.myParent.bot2.startX;
			by1c = myBOpening.myParent.bot2.startY;

			bx2 = myBOpening.bot2.endX;
			by2 = myBOpening.bot2.endY;
			bx2A = myBOpening.bot2.endXA;
			by2A = myBOpening.bot2.endYA;
			bx2c = myBOpening.myParent.bot2.endX;
			by2c = myBOpening.myParent.bot2.endY;

		} else if (myBOpening.noSidesBot == 2
				&& myMullionLeft.x3 < myBOpening.myParent.bot2.endX
				&& myMullionRight.x4 > myBOpening.myParent.bot1.startX
				&& myMullionRight.x4 < myBOpening.myParent.bot3.endX) {

			bx1 = myBOpening.bot1.startX;
			by1 = myBOpening.bot1.startY;
			bx1A = myBOpening.bot1.startXA;
			by1A = myBOpening.bot1.startYA;
			bx1c = myBOpening.myParent.bot1.startX;
			by1c = myBOpening.myParent.bot1.startY;

			bx2 = myBOpening.bot1.endX;
			by2 = myBOpening.bot1.endY;
			bx2A = myBOpening.bot1.endXA;
			by2A = myBOpening.bot1.endYA;
			bx2c = myBOpening.myParent.bot1.endX;
			by2c = myBOpening.myParent.bot1.endY;

			b2x1 = myBOpening.bot2.startX;
			b2y1 = myBOpening.bot2.startY;
			b2x1A = myBOpening.bot2.startXA;
			b2y1A = myBOpening.bot2.startYA;
			b2x1c = myBOpening.myParent.bot2.startX;
			b2y1c = myBOpening.myParent.bot2.startY;

			b2x2 = myBOpening.bot2.endX;
			b2y2 = myBOpening.bot2.endY;
			b2x2A = myBOpening.bot2.endXA;
			b2y2A = myBOpening.bot2.endYA;
			b2x2c = myBOpening.myParent.bot2.endX;
			b2y2c = myBOpening.myParent.bot2.endY;

			myInitOpening.noSidesBot = 2;
		} else if (myBOpening.noSidesBot == 3
				&& myMullionLeft.x3 < myBOpening.myParent.bot2.startX
				&& myMullionRight.x4 > myBOpening.myParent.bot1.endX
				&& myMullionRight.x4 < myBOpening.myParent.bot3.endX) {

			bx1 = myBOpening.bot1.startX;
			by1 = myBOpening.bot1.startY;
			bx1A = myBOpening.bot1.startXA;
			by1A = myBOpening.bot1.startYA;
			bx1c = myBOpening.myParent.bot1.startX;
			by1c = myBOpening.myParent.bot1.startY;

			bx2 = myBOpening.bot1.endX;
			by2 = myBOpening.bot1.endY;
			bx2A = myBOpening.bot1.endXA;
			by2A = myBOpening.bot1.endYA;
			bx2c = myBOpening.myParent.bot1.endX;
			by2c = myBOpening.myParent.bot1.endY;

			b2x1 = myBOpening.bot2.startX;
			b2y1 = myBOpening.bot2.startY;
			b2x1A = myBOpening.bot2.startXA;
			b2y1A = myBOpening.bot2.startYA;
			b2x1c = myBOpening.myParent.bot2.startX;
			b2y1c = myBOpening.myParent.bot2.startY;

			b2x2 = myBOpening.bot2.endX;
			b2y2 = myBOpening.bot2.endY;
			b2x2A = myBOpening.bot2.endXA;
			b2y2A = myBOpening.bot2.endYA;
			b2x2c = myBOpening.myParent.bot2.endX;
			b2y2c = myBOpening.myParent.bot2.endY;

			myInitOpening.noSidesBot = 2;

		} else if (myBOpening.noSidesBot == 3
				&& myMullionLeft.x3 > myBOpening.myParent.bot2.startX
				&& myMullionRight.x4 > myBOpening.myParent.bot3.endX) {

			bx1 = myBOpening.bot3.startX;
			by1 = myBOpening.bot3.startY;
			bx1A = myBOpening.bot3.startXA;
			by1A = myBOpening.bot3.startYA;

			bx1c = myBOpening.myParent.bot3.startX;
			by1c = myBOpening.myParent.bot3.startY;

			bx2 = myBOpening.bot3.endX;
			by2 = myBOpening.bot3.endY;
			bx2A = myBOpening.bot3.endXA;
			by2A = myBOpening.bot3.endYA;
			bx2c = myBOpening.myParent.bot3.endX;
			by2c = myBOpening.myParent.bot3.endY;

			b2x1 = myBOpening.bot1.startX;
			b2y1 = myBOpening.bot1.startY;
			b2x1A = myBOpening.bot1.startXA;
			b2y1A = myBOpening.bot1.startYA;
			b2x1c = myBOpening.myParent.bot1.startX;
			b2y1c = myBOpening.myParent.bot1.startY;

			b2x2 = myBOpening.bot1.endX;
			b2y2 = myBOpening.bot1.endY;
			b2x2A = myBOpening.bot1.endXA;
			b2y2A = myBOpening.bot1.endYA;
			b2x2c = myBOpening.myParent.bot1.endX;
			b2y2c = myBOpening.myParent.bot1.endY;

			b3x1 = myBOpening.bot2.startX;
			b3y1 = myBOpening.bot2.startY;
			b3x1A = myBOpening.bot2.startXA;
			b3y1A = myBOpening.bot2.startYA;
			b3x1c = myBOpening.myParent.bot2.startX;
			b3y1c = myBOpening.myParent.bot2.startY;

			b2x2 = myBOpening.bot3.endX;
			b2y2 = myBOpening.bot3.endY;
			b2x2A = myBOpening.bot3.endXA;
			b2y2A = myBOpening.bot3.endYA;
			b2x2c = myBOpening.myParent.bot3.endX;
			b2y2c = myBOpening.myParent.bot3.endY;

			myInitOpening.noSidesTop = 3;

		} else if (myBOpening.noSidesBot == 3
				&& myMullionLeft.x3 > myBOpening.myParent.bot1.endX
				&& myMullionLeft.x3 < myBOpening.myParent.bot1.startX
				&& myMullionRight.x4 > myBOpening.myParent.bot3.endX) {

			bx1 = myBOpening.bot3.startX;
			by1 = myBOpening.bot3.startY;
			bx1A = myBOpening.bot3.startXA;
			by1A = myBOpening.bot3.startYA;
			bx1c = myBOpening.myParent.bot3.startX;
			by1c = myBOpening.myParent.bot3.startY;

			bx2 = myBOpening.bot3.endX;
			by2 = myBOpening.bot3.endY;
			bx2A = myBOpening.bot3.endXA;
			by2A = myBOpening.bot3.endYA;
			bx2c = myBOpening.myParent.bot3.endX;
			by2c = myBOpening.myParent.bot3.endY;

			b2x1 = myBOpening.bot1.startX;
			b2y1 = myBOpening.bot1.startY;
			b2x1A = myBOpening.bot1.startXA;
			b2y1A = myBOpening.bot1.startYA;
			b2x1c = myBOpening.myParent.bot1.startX;
			t2y1c = myBOpening.myParent.bot1.startY;

			b2x2 = myBOpening.bot1.endX;
			b2y2 = myBOpening.bot1.endY;
			b2x2A = myBOpening.bot1.endXA;
			b2y2A = myBOpening.bot1.endYA;
			b2x2c = myBOpening.myParent.bot1.endX;
			b2y2c = myBOpening.myParent.bot1.endY;

			myInitOpening.noSidesBot = 2;

		}
	}

	public OpeningObject opening_Bottom_InTheMiddle(
			final OpeningObject myOpening, final Profiles myMullionLeft,
			final Profiles myMullionRight) {

		Profiles myProfile = new Profiles();
		Profiles myProfileC = new Profiles();

		Profiles myProfile2 = new Profiles();
		Profiles myProfile2C = new Profiles();

		Profiles myProfile3 = new Profiles();
		Profiles myProfile3C = new Profiles();

		new Profiles();
		new Profiles();

		new Profiles();
		new Profiles();

		new Profiles();
		new Profiles();

		if (myMullionRight.x3cl < myBOpening.myParent.right.startX
				&& myMullionRight.x4al > myBOpening.myParent.right.endX) {

			myProfile = myBOpening.rightPart;
			myProfileC = myBOpening.myParent.rightPart;

			if (myMullionLeft.x3cl < myBOpening.myParent.left.startX
					&& myMullionLeft.x4al > myBOpening.myParent.left.endX) {
				myProfile2 = myBOpening.leftPart;
				myProfile2C = myBOpening.myParent.leftPart;

				myProfile3 = myBOpening.bot1Part;
				myProfile3C = myBOpening.myParent.bot1Part;

				myOpening.noSidesBot = 3;
			}// ca only happen if sidesbot =1

			else if (myMullionLeft.x3cl < myBOpening.myParent.bot1.startX
					&& myMullionLeft.x4al > myBOpening.myParent.bot1.endX) {
				myProfile2 = myBOpening.bot1Part;
				myProfile2C = myBOpening.myParent.bot1Part;

				myOpening.noSidesBot = 2;

			} else if (myMullionLeft.x3cl < myBOpening.myParent.left.startX
					&& myMullionLeft.x4al > myBOpening.myParent.left.endX) {
				myProfile3 = myBOpening.bot1Part;
				myProfile3C = myBOpening.myParent.bot1Part;

				myProfile2 = myBOpening.leftPart;
				myProfile2C = myBOpening.myParent.leftPart;

				myOpening.noSidesBot = 3;
			}
			// cannot have bottom 2 or bottom 3 No Such
			// Shapes

		} else if (myMullionRight.x3cl < myBOpening.myParent.bot1.startX
				&& myMullionRight.x4al > myBOpening.myParent.bot1.endX) {
			myProfile = myBOpening.bot1Part;
			myProfileC = myBOpening.myParent.bot1Part;
			myOpening.noSidesBot = 1;
			if (myMullionLeft.x3cl < myBOpening.myParent.bot1.startX
					&& myMullionLeft.x4al > myBOpening.myParent.bot1.endX) {
				myProfile = myBOpening.bot1Part;
				myProfileC = myBOpening.myParent.bot1Part;
				myOpening.noSidesBot = 1;
			} else if (myMullionLeft.x3cl < myBOpening.myParent.left.startX
					&& myMullionLeft.x4al > myBOpening.myParent.left.endX) {
				myProfile2 = myBOpening.leftPart;
				myProfile2C = myBOpening.myParent.leftPart;
				myOpening.noSidesBot = 2;
			}// ca only happen if sidesbot =1

			else if (myBOpening.noSidesBot == 2
					&& myMullionLeft.x3cl < myBOpening.myParent.bot2.startX
					&& myMullionLeft.x4al > myBOpening.myParent.bot2.endX) {
				myProfile2 = myBOpening.bot2Part;
				myProfile2C = myBOpening.myParent.bot2Part;
				myOpening.noSidesBot = 2;
			} else if (myBOpening.noSidesBot == 3
					&& myMullionLeft.x3cl < myBOpening.myParent.bot2.startX
					&& myMullionLeft.x4al > myBOpening.myParent.bot2.endX) {
				myProfile2 = myBOpening.bot2Part;
				myProfile2C = myBOpening.myParent.bot2Part;

				myProfile3 = myBOpening.bot3Part;
				myProfile3C = myBOpening.myParent.bot3Part;

				myOpening.noSidesBot = 3;
			}
		} else if (myMullionRight.x3cl < myBOpening.myParent.bot3.startX
				&& myMullionRight.x4al > myBOpening.myParent.bot3.endX) {
			myProfile = myBOpening.bot3Part;
			myProfileC = myBOpening.myParent.bot3Part;
			myOpening.noSidesBot = 1;

			if (myMullionLeft.x3cl < myBOpening.myParent.bot3.startX
					&& myMullionLeft.x4al > myBOpening.myParent.bot3.endX) {
				myOpening.noSidesBot = 1;
			} else if (myMullionLeft.x3cl < myBOpening.myParent.bot2.startX
					&& myMullionLeft.x4al > myBOpening.myParent.bot2.endX) {
				myProfile2 = myBOpening.bot2Part;
				myProfile2C = myBOpening.myParent.bot2Part;
				myOpening.noSidesBot = 2;
			}
		} else if (myMullionRight.x3cl < myBOpening.myParent.bot2.startX
				&& myMullionRight.x4al > myBOpening.myParent.bot2.endX) {
			myProfile = myBOpening.bot2Part;
			myProfileC = myBOpening.myParent.bot2Part;

			myOpening.noSidesBot = 1;

		} else if (myMullionRight.x3cl < myBOpening.myParent.left.startX
				&& myMullionRight.x4al > myBOpening.myParent.left.endX) {
			myProfile = myBOpening.leftPart;
			myProfileC = myBOpening.myParent.leftPart;

			myOpening.noSidesBot = 1;

		}

		getb1xy(myProfile, myProfileC);

		if (myOpening.noSidesBot == 2) {
			getb2xy(myProfile2, myProfile2C);
		}
		if (myOpening.noSidesBot == 3) {
			getb2xy(myProfile2, myProfile2C);
			getb3xy(myProfile3, myProfile3C);
		}
		if (myOpening.botRemoved) {
			myOpening.noSidesBot = 1;
			bx1 = bx1A = bx1c = myProfileC.startXC;
			by1 = by1A = by1c = myProfileC.startYC;
			bx2 = bx2A = bx2c = myProfileC.endXC;
			by2 = by2A = by2c = myProfileC.endYC;
			b1s = myProfileC.partForm;

		}
		return myOpening;
	}

	public void checkLeft(final OpeningObject myOpening,
			final Profiles myMullionLeft) {

		new Profiles();
		new Profiles();

		new Profiles();
		new Profiles();

		new Profiles();
		new Profiles();

		if (myMullionLeft.x3cl < myBOpening.myParent.right.startX
				&& myMullionLeft.x4al > myBOpening.myParent.right.endX) {

			myOpening.noSidesBot = 1;

			// cannot have bottom 2 or bottom 3 No Such
			// Shapes

		} else if (myMullionLeft.x3cl < myBOpening.myParent.bot1.startX
				&& myMullionLeft.x4al > myBOpening.myParent.bot1.endX) {
			myOpening.noSidesBot = 1;

		} else if (myMullionLeft.x3cl < myBOpening.myParent.bot3.startX
				&& myMullionLeft.x4al > myBOpening.myParent.bot3.endX) {

			myOpening.noSidesBot = 2;
		} else if (myMullionLeft.x3cl < myBOpening.myParent.bot2.startX
				&& myMullionLeft.x4al > myBOpening.myParent.bot2.endX) {

			if (myBOpening.noSidesBot == 2) {
				myOpening.noSidesBot = 2;
			} else if (myBOpening.noSidesBot == 3) {
				myOpening.noSidesBot = 3;
			}

		} else if (myMullionLeft.x3cl < myBOpening.myParent.left.startX
				&& myMullionLeft.x4al > myBOpening.myParent.left.endX) {
			myOpening.noSidesBot = 2;
		}
	}

	public void opening_Bottom_StartMiddle_EndAtEndColOLD(
			final OpeningObject myInitOpening, final Profiles myMullionLeft) {

		myInitOpening.noSidesBot = 1;

		bx1 = myBOpening.bot1.startX;
		by1 = myBOpening.bot1.startY;
		bx1A = myBOpening.bot1.startXA;
		by1A = myBOpening.bot1.startYA;
		bx1c = myBOpening.myParent.bot1.startX;
		by1c = myBOpening.myParent.bot1.startY;

		bx2 = myBOpening.bot1.endX;
		by2 = myBOpening.bot1.endY;
		bx2A = myBOpening.bot1.endXA;
		by2A = myBOpening.bot1.endYA;
		bx2c = myBOpening.myParent.bot1.endX;
		by2c = myBOpening.myParent.bot1.endY;
		b1s = myBOpening.bot1.partForm;

		if (myBOpening.noSidesBot == 2
				&& myMullionLeft.x3 < myBOpening.bot2.startX) {

			b2x1 = myBOpening.bot2.startX;
			b2y1 = myBOpening.bot2.startY;
			b2x1A = myBOpening.bot2.startXA;
			b2y1A = myBOpening.bot2.startYA;
			b2x1c = myBOpening.myParent.bot2.startX;
			b2y1c = myBOpening.myParent.bot2.startY;

			b2x2 = myBOpening.bot2.endX;
			b2y2 = myBOpening.bot2.endY;
			b2x2A = myBOpening.bot2.endXA;
			b2y2A = myBOpening.bot2.endYA;
			b2x2c = myBOpening.myParent.bot2.endX;
			b2y2c = myBOpening.myParent.bot2.endY;

			myInitOpening.noSidesBot = 2;

		} else if (myBOpening.noSidesBot == 3
				&& myMullionLeft.x3 > myBOpening.bot3.endX) {

			bx1 = myBOpening.bot3.startX;
			by1 = myBOpening.bot3.startY;
			bx1A = myBOpening.bot3.startXA;
			by1A = myBOpening.bot3.startYA;
			bx1c = myBOpening.myParent.bot3.startX;
			by1c = myBOpening.myParent.bot3.startY;

			bx2 = myBOpening.bot3.endX;
			by2 = myBOpening.bot3.endY;
			bx2A = myBOpening.bot3.endXA;
			by2A = myBOpening.bot3.endYA;
			bx2c = myBOpening.myParent.bot3.endX;
			by2c = myBOpening.myParent.bot3.endY;

			myInitOpening.noSidesBot = 1;

		} else if (myBOpening.noSidesBot == 3
				&& myMullionLeft.x3 > myBOpening.bot1.endX
				&& myMullionLeft.x3 < myBOpening.bot1.startX) {

			bx1 = myBOpening.bot3.startX;
			by1 = myBOpening.bot3.startY;
			bx1A = myBOpening.bot3.startXA;
			by1A = myBOpening.bot3.startYA;
			bx1c = myBOpening.myParent.bot3.startX;
			by1c = myBOpening.myParent.bot3.startY;
			bx2 = myBOpening.bot3.endX;
			by2 = myBOpening.bot3.endY;
			bx2A = myBOpening.bot3.endXA;
			by2A = myBOpening.bot3.endYA;
			bx2c = myBOpening.myParent.bot3.endX;
			by2c = myBOpening.myParent.bot3.endY;

			b2x1 = myBOpening.bot1.startX;
			b2y1 = myBOpening.bot1.startY;
			b2x1A = myBOpening.bot1.startXA;
			b2y1A = myBOpening.bot1.startYA;
			b2x1c = myBOpening.myParent.bot1.startX;
			b2y1c = myBOpening.myParent.bot1.startY;

			b2x2 = myBOpening.bot1.endX;
			b2y2 = myBOpening.bot1.endY;
			b2x2A = myBOpening.bot1.endXA;
			b2y2A = myBOpening.bot1.endYA;
			b2x2c = myBOpening.myParent.bot1.endX;
			b2y2c = myBOpening.myParent.bot1.endY;

			myInitOpening.noSidesBot = 2;

		} else if (myBOpening.noSidesBot == 3
				&& myMullionLeft.x3 < myBOpening.bot2.startX) {
			bx1 = myBOpening.bot3.startX;
			by1 = myBOpening.bot3.startY;
			bx1A = myBOpening.bot3.startXA;
			by1A = myBOpening.bot3.startYA;
			bx1c = myBOpening.myParent.bot3.startX;
			by1c = myBOpening.myParent.bot3.startY;
			bx2 = myBOpening.bot3.endX;
			by2 = myBOpening.bot3.endY;
			bx2A = myBOpening.bot3.endXA;
			by2A = myBOpening.bot3.endYA;
			bx2c = myBOpening.myParent.bot3.endX;
			by2c = myBOpening.myParent.bot3.endY;

			b2x1 = myBOpening.bot1.startX;
			b2y1 = myBOpening.bot1.startY;
			b2x1A = myBOpening.bot1.startXA;
			b2y1A = myBOpening.bot1.startYA;
			b2x1c = myBOpening.myParent.bot1.startX;
			b2y1c = myBOpening.myParent.bot1.startY;
			b2x2 = myBOpening.bot1.endX;
			b2y2 = myBOpening.bot1.endY;
			b2x2A = myBOpening.bot1.endXA;
			b2y2A = myBOpening.bot1.endYA;
			b2x1c = myBOpening.myParent.bot1.endX;
			b2y1c = myBOpening.myParent.bot1.endY;

			b3x1 = myBOpening.bot2.startX;
			b3y1 = myBOpening.bot2.startY;
			b3x1A = myBOpening.bot2.startXA;
			b3y1A = myBOpening.bot2.startYA;
			b3x1c = myBOpening.myParent.bot2.startX;
			b3y1c = myBOpening.myParent.bot2.startY;

			b3x2 = myBOpening.bot2.endX;
			b3y2 = myBOpening.bot2.endY;
			b3x2A = myBOpening.bot2.endXA;
			b3y2A = myBOpening.bot2.endYA;
			b3x2c = myBOpening.myParent.bot2.endX;
			b3y2c = myBOpening.myParent.bot2.endY;

			myInitOpening.noSidesBot = 3;

		}
	}

	public OpeningObject opening_Bottom_StartMiddle_EndAtEndCol(
			final OpeningObject myOpening, final Profiles myMullionLeft) {

		Profiles myProfile = new Profiles();
		Profiles myProfileC = new Profiles();

		Profiles myProfile2 = new Profiles();
		Profiles myProfile2C = new Profiles();

		Profiles myProfile3 = new Profiles();
		Profiles myProfile3C = new Profiles();

		if (myMullionLeft.x3cl < myBOpening.right.startX
				&& myMullionLeft.x4al > myBOpening.right.endX) {

			myProfile = myBOpening.rightPart;
			myProfileC = myBOpening.myParent.rightPart;

			myOpening.noSidesBot = 1;

			// cannot have bottom 2 or bottom 3 No Such
			// Shapes

		} else if (myMullionLeft.x3cl < myBOpening.bot1.startX
				&& myMullionLeft.x4al > myBOpening.bot1.endX) {
			//
			myProfile = myBOpening.bot1Part;
			myProfileC = myBOpening.myParent.bot1Part;

			myOpening.noSidesBot = 1;

		} else if (myMullionLeft.x3cl < myBOpening.bot3.startX
				&& myMullionLeft.x4al > myBOpening.bot3.endX) {

			myProfile = myBOpening.bot1Part;
			myProfileC = myBOpening.myParent.bot1Part;

			myProfile2 = myBOpening.bot3Part;
			myProfile2C = myBOpening.myParent.bot3Part;

			myOpening.noSidesBot = 2;
		} else if (myMullionLeft.x3cl < myBOpening.bot2.startX
				&& myMullionLeft.x4al > myBOpening.bot2.endX) {

			if (myBOpening.noSidesBot == 2) {
				myProfile = myBOpening.bot1Part;
				myProfileC = myBOpening.myParent.bot1Part;

				myProfile2 = myBOpening.bot2Part;
				myProfile2C = myBOpening.myParent.bot2Part;

				myOpening.noSidesBot = 2;
			} else if (myBOpening.noSidesBot == 3) {
				myProfile = myBOpening.bot1Part;
				myProfileC = myBOpening.myParent.bot1Part;

				myProfile2 = myBOpening.bot2Part;
				myProfile2C = myBOpening.myParent.bot2Part;

				myProfile3 = myBOpening.bot3Part;
				myProfile3C = myBOpening.myParent.bot3Part;

				myOpening.noSidesBot = 3;
			}

		} else if (myMullionLeft.x3cl < myBOpening.left.startX
				&& myMullionLeft.x4al > myBOpening.left.endX) {
			myProfile = myBOpening.bot1Part;
			myProfileC = myBOpening.myParent.bot1Part;

			myProfile2 = myBOpening.leftPart;
			myProfile2C = myBOpening.myParent.leftPart;

			myOpening.noSidesBot = 2;
		}

		getb1xy(myProfile, myProfileC);

		if (myOpening.noSidesBot == 2) {
			getb2xy(myProfile2, myProfile2C);
		}
		if (myOpening.noSidesBot == 3) {
			getb2xy(myProfile2, myProfile2C);
			getb3xy(myProfile3, myProfile3C);
		}

		if (myOpening.botRemoved) {
			myOpening.noSidesBot = 1;
			bx1 = bx1A = bx1c = myProfileC.startXC;
			by1 = by1A = by1c = myProfileC.startYC;
			bx2 = bx2A = bx2c = myProfileC.endXC;
			by2 = by2A = by2c = myProfileC.endYC;
			b1s = myProfileC.partForm;

		}

		return myOpening;
	}

	public OpeningObject opening_Bottom_StartBegining_EndMiddle(
			final OpeningObject myOpening, final Profiles myMullionRight) {

		Profiles myProfile = new Profiles();
		Profiles myProfileC = new Profiles();

		Profiles myProfile2 = new Profiles();
		Profiles myProfile2C = new Profiles();

		Profiles myProfile3 = new Profiles();
		Profiles myProfile3C = new Profiles();

		if (myMullionRight.x3cl < myBOpening.right.startX
				&& myMullionRight.x4al > myBOpening.right.endX) {

			if (myBOpening.noSidesBot == 1) {
				myProfile = myBOpening.rightPart;
				myProfileC = myBOpening.myParent.rightPart;

				myProfile2 = myBOpening.bot1Part;
				myProfile2C = myBOpening.myParent.bot1Part;

				myOpening.noSidesBot = 2;
			}

			// cannot have bottom 2 or bottom 3 No Such
			// Shapes

		} else if (myMullionRight.x3cl < myBOpening.bot1.startX
				&& myMullionRight.x4al > myBOpening.bot1.endX) {
			if (myBOpening.noSidesBot == 1) {
				myProfile = myBOpening.bot1Part;
				myProfileC = myBOpening.myParent.bot1Part;

				myOpening.noSidesBot = 1;
			} else if (myBOpening.noSidesBot == 2) {
				myProfile = myBOpening.bot1Part;
				myProfileC = myBOpening.myParent.bot1Part;

				myProfile2 = myBOpening.bot2Part;
				myProfile2C = myBOpening.myParent.bot2Part;

				myOpening.noSidesBot = 2;
			} else if (myBOpening.noSidesBot == 3) {
				myProfile = myBOpening.bot1Part;
				myProfileC = myBOpening.myParent.bot1Part;

				myProfile2 = myBOpening.bot2Part;
				myProfile2C = myBOpening.myParent.bot2Part;

				myProfile3 = myBOpening.bot3Part;
				myProfile3C = myBOpening.myParent.bot3Part;

				myOpening.noSidesBot = 3;
			}
		} else if (myMullionRight.x3cl < myBOpening.bot3.startX
				&& myMullionRight.x4al > myBOpening.bot3.endX) {

			myProfile = myBOpening.bot3Part;
			myProfileC = myBOpening.myParent.bot3Part;

			myProfile2 = myBOpening.bot2Part;
			myProfile2C = myBOpening.myParent.bot2Part;

			myOpening.noSidesBot = 2;
		} else if (myMullionRight.x3cl < myBOpening.bot2.startX
				&& myMullionRight.x4al > myBOpening.bot2.endX) {

			myProfile = myBOpening.bot2Part;
			myProfileC = myBOpening.myParent.bot2Part;

			myProfile2 = myBOpening.bot2Part;
			myProfile2C = myBOpening.myParent.bot2Part;

			myOpening.noSidesBot = 2;

		} else if (myMullionRight.x3cl < myBOpening.left.startX
				&& myMullionRight.x4al > myBOpening.left.endX) {
			myProfile = myBOpening.leftPart;
			myProfileC = myBOpening.myParent.leftPart;
			myOpening.noSidesBot = 1;
		}

		getb1xy(myProfile, myProfileC);

		if (myOpening.noSidesBot == 2) {
			getb2xy(myProfile2, myProfile2C);
		}
		if (myOpening.noSidesBot == 3) {
			getb2xy(myProfile2, myProfile2C);
			getb3xy(myProfile3, myProfile3C);
		}
		if (myOpening.botRemoved) {
			myOpening.noSidesBot = 1;
			bx1 = bx1A = bx1c = myProfileC.startXC;
			by1 = by1A = by1c = myProfileC.startYC;
			bx2 = bx2A = bx2c = myProfileC.endXC;
			by2 = by2A = by2c = myProfileC.endYC;
			b1s = myProfileC.partForm;

		}
		return myOpening;
	}

	public OpeningObject opening_Bottom_OnlyOne(
			final OpeningObject myInitOpening) {

		bx1 = myBOpening.bot1.startX;
		by1 = myBOpening.bot1.startY;
		bx1A = myBOpening.bot1.startXA;
		by1A = myBOpening.bot1.startYA;
		bx1c = myBOpening.myParent.bot1.startX;
		by1c = myBOpening.myParent.bot1.startY;
		bx2 = myBOpening.bot1.endX;
		by2 = myBOpening.bot1.endY;
		bx2A = myBOpening.bot1.endXA;
		by2A = myBOpening.bot1.endYA;
		bx2c = myBOpening.myParent.bot1.endX;
		by2c = myBOpening.myParent.bot1.endY;
		b1s = myBOpening.bot1.partForm;

		myInitOpening.noSidesBot = 1;

		if (myBOpening.noSidesBot == 2) {
			b2x1 = myBOpening.bot2.startX;
			b2y1 = myBOpening.bot2.startY;
			b2x1A = myBOpening.bot2.startXA;
			b2y1A = myBOpening.bot2.startYA;
			b2x1c = myBOpening.myParent.bot2.startX;
			b2y1c = myBOpening.myParent.bot2.startY;
			b2x2 = myBOpening.bot2.endX;
			b2y2 = myBOpening.bot2.endY;
			b2x2A = myBOpening.bot2.endXA;
			b2y2A = myBOpening.bot2.endYA;
			b2x1c = myBOpening.myParent.bot2.endX;
			b2y1c = myBOpening.myParent.bot2.endY;
			b2s = myBOpening.bot2.partForm;

			myInitOpening.noSidesBot = 2;
		}

		if (myBOpening.noSidesBot == 3) {
			b3x1 = myBOpening.bot3.startX;
			b3y1 = myBOpening.bot3.startY;
			b3x1A = myBOpening.bot3.startXA;
			b3y1A = myBOpening.bot3.startYA;
			b3x1c = myBOpening.myParent.bot3.startX;
			b3y1c = myBOpening.myParent.bot3.startY;
			b3x2 = myBOpening.bot3.endX;
			b3y2 = myBOpening.bot3.endY;
			b3x2A = myBOpening.bot3.endXA;
			b3y2A = myBOpening.bot3.endYA;
			b3x2c = myBOpening.myParent.bot3.endX;
			b3y2c = myBOpening.myParent.bot3.endY;
			b3s = myBOpening.bot3.partForm;

			bx1 = myBOpening.bot1.startX;
			by1 = myBOpening.bot1.startY;
			bx1A = myBOpening.bot1.startXA;
			by1A = myBOpening.bot1.startYA;
			bx1c = myBOpening.myParent.bot1.startX;
			by1c = myBOpening.myParent.bot1.startY;
			bx2 = myBOpening.bot1.endX;
			by2 = myBOpening.bot1.endY;
			bx2A = myBOpening.bot1.endXA;
			by2A = myBOpening.bot1.endYA;
			bx1c = myBOpening.myParent.bot1.endX;
			by1c = myBOpening.myParent.bot1.endY;
			b1s = myBOpening.bot1.partForm;

			b2x1 = myBOpening.bot2.startX;
			b2y1 = myBOpening.bot2.startY;
			b2x1A = myBOpening.bot2.startXA;
			b2y1A = myBOpening.bot2.startYA;
			b2x1c = myBOpening.myParent.bot2.startX;
			b2y1c = myBOpening.myParent.bot2.startY;
			b2x2 = myBOpening.bot2.endX;
			b2y2 = myBOpening.bot2.endY;
			b2x2A = myBOpening.bot2.endXA;
			b2y2A = myBOpening.bot2.endYA;
			b2x1c = myBOpening.myParent.bot2.endX;
			b2y1c = myBOpening.myParent.bot2.endY;
			b2s = myBOpening.bot2.partForm;
			myInitOpening.noSidesBot = 3;
		}
		if (myInitOpening.botRemoved) {
			myInitOpening.noSidesBot = 1;
			bx1 = bx1A = bx1c = myBOpening.bot1.startX;
			by1 = by1A = by1c = myBOpening.bot1.startY;
			bx2 = bx2A = bx2c = myBOpening.bot1.endX;
			by2 = by2A = by2c = myBOpening.bot1.endY;
			b1s = myBOpening.bot1.partForm;

		}
		return myInitOpening;
	}

	public void getb1xy(final Profiles profile, final Profiles profileC) {

		bx1 = profile.startX;
		by1 = profile.startY;
		bx1A = profile.startXA;
		by1A = profile.startYA;
		bx1c = profileC.startXC;
		by1c = profileC.startYC;

		bx2 = profile.endX;
		by2 = profile.endY;
		bx2A = profile.endXA;
		by2A = profile.endYA;
		bx2c = profileC.endXC;
		by2c = profileC.endYC;
		b1s = profile.partForm;

	}

	public void getb2xy(final Profiles profile, final Profiles profileC) {

		b2x1 = profile.startX;
		b2y1 = profile.startY;
		b2x1A = profile.startXA;
		b2y1A = profile.startYA;
		b2x1c = profileC.startXC;
		b2y1c = profileC.startYC;

		b2x2 = profile.endX;
		b2y2 = profile.endY;
		b2x2A = profile.endXA;
		b2y2A = profile.endYA;
		b2x2c = profileC.endXC;
		b2y2c = profileC.endYC;
		b2s = profile.partForm;
	}

	public void getb3xy(final Profiles profile, final Profiles profileC) {

		b3x1 = profile.startX;
		b3y1 = profile.startY;
		b3x1A = profile.startXA;
		b3y1A = profile.startYA;
		b3x1c = profileC.startXC;
		b3y1c = profileC.startYC;

		b3x2 = profile.endX;
		b3y2 = profile.endY;
		b3x2A = profile.endXA;
		b3y2A = profile.endYA;
		b3x2c = profileC.endXC;
		b3y2c = profileC.endYC;
		b3s = profile.partForm;
	}

	public void doTopLimits(final OpeningObject myOpening,
			final Profiles myMullionLeft, final Profiles myMullionRight) {

		if (myOpening.startCol == 1 && myOpening.startRow == 1
				&& myOpening.endCol == myBOpening.xCols) {

			opening_OnlyOne(myOpening);

		}// row 1 colstart 1 colend last

		else if (myOpening.startCol == 1 && myOpening.startRow == 1
				&& myOpening.endCol < myBOpening.xCols) {

			opening_Top_StartAtBegining_EndInMiddle(myOpening, myMullionRight);

		} // col 1 row 1 endcol < xcols

		else if (myOpening.startCol > 1 && myOpening.startRow == 1
				&& myOpening.endCol == myBOpening.xCols) {

			this.opening_Top_StartMiddle_EndAtEndCol(myOpening, myMullionLeft);

		} else if (myOpening.startCol > 1 && myOpening.startRow == 1
				&& myOpening.endCol < myBOpening.xCols) {

			this.opening_Top_InTheMiddle(myOpening, myMullionLeft,
					myMullionRight);

		}
	}

	public OpeningObject opening_Top_InTheMiddle(final OpeningObject myOpening,
			final Profiles myMullionLeft, final Profiles myMullionRight) {

		Profiles myProfile = new Profiles();
		Profiles myProfileC = new Profiles();

		Profiles myProfile2 = new Profiles();
		Profiles myProfile2C = new Profiles();

		Profiles myProfile3 = new Profiles();
		Profiles myProfile3C = new Profiles();

		if (myMullionRight.x1al > myBOpening.right.startX
				&& myMullionRight.x2cl < myBOpening.right.endX) {

			if (myMullionLeft.x1al > myBOpening.left.startX
					&& myMullionLeft.x2cl < myBOpening.left.endX) {

				myProfile2 = myBOpening.rightPart;
				myProfile2C = myBOpening.myParent.rightPart;

				myProfile = myBOpening.leftPart;
				myProfileC = myBOpening.myParent.leftPart;

				myProfile3 = myBOpening.top1Part;
				myProfile3C = myBOpening.myParent.top1Part;

				myOpening.noSidesTop = 3;
			}// ca only happen if sidesbot =1

			else if (myMullionLeft.x1al > myBOpening.top1.startX
					&& myMullionLeft.x2cl < myBOpening.top1.endX) {
				myProfile = myBOpening.top1Part;
				myProfileC = myBOpening.myParent.top1Part;

				myProfile2 = myBOpening.rightPart;
				myProfile2C = myBOpening.myParent.rightPart;

				myOpening.noSidesTop = 2;

			}

			if (myMullionLeft.x1al > myBOpening.right.startX
					&& myMullionLeft.x2cl < myBOpening.right.endX) {

				myProfile = myBOpening.rightPart;
				myProfileC = myBOpening.myParent.rightPart;

				myOpening.noSidesBot = 1;
			}
			// cannot have bottom 2 or bottom 3 No Such
			// Shapes

		} else if (myMullionRight.x1al > myBOpening.top2.startX
				&& myMullionRight.x2cl < myBOpening.top2.endX
				&& myBOpening.myParent.top2.posInUse) {

			if (myMullionLeft.x1al > myBOpening.top1.startX
					&& myMullionLeft.x2cl < myBOpening.top1.endX) {

				if (myBOpening.noSidesTop == 3) {
					myProfile = myBOpening.top1Part;
					myProfileC = myBOpening.myParent.top1Part;

					myProfile2 = myBOpening.top2Part;
					myProfile2C = myBOpening.myParent.top2Part;

					myProfile3 = myBOpening.top3Part;
					myProfile3C = myBOpening.myParent.top3Part;

					myOpening.noSidesTop = 3;
				} else {
					myProfile = myBOpening.top1Part;
					myProfileC = myBOpening.myParent.top1Part;

					myProfile2 = myBOpening.top2Part;
					myProfile2C = myBOpening.myParent.top2Part;

					myOpening.noSidesTop = 2;
				}

			} else if (myMullionLeft.x1al > myBOpening.top3.startX
					&& myMullionLeft.x2cl < myBOpening.top3.endX
					&& myBOpening.myParent.top3.posInUse) {

				myProfile = myBOpening.top3Part;
				myProfileC = myBOpening.myParent.top3Part;

				myProfile2 = myBOpening.top2Part;
				myProfile2C = myBOpening.myParent.top2Part;

				myOpening.noSidesTop = 2;

			} else if (myMullionLeft.x1al > myBOpening.top2.startX
					&& myMullionLeft.x2cl < myBOpening.top2.endX
					&& myBOpening.myParent.top2.posInUse) {

				myProfile = myBOpening.top2Part;
				myProfileC = myBOpening.myParent.top2Part;

				myOpening.noSidesTop = 1;

			}

		} else if (myMullionRight.x1al > myBOpening.top3.startX
				&& myMullionRight.x2cl < myBOpening.top3.endX) {

			if (myMullionLeft.x1al > myBOpening.top1.startX
					&& myMullionLeft.x2cl < myBOpening.top1.endX) {
				myProfile = myBOpening.top1Part;
				myProfileC = myBOpening.myParent.top1Part;

				myProfile2 = myBOpening.top3Part;
				myProfile2C = myBOpening.myParent.top3Part;

				myOpening.noSidesTop = 2;

			} else if (myMullionLeft.x1al > myBOpening.top3.startX
					&& myMullionLeft.x2cl < myBOpening.top3.endX) {
				myProfile = myBOpening.top3Part;
				myProfileC = myBOpening.myParent.top3Part;

				myOpening.noSidesTop = 1;
			}// ca only happen if sidesbot =1

		} else if (myMullionRight.x1al > myBOpening.top1.startX
				&& myMullionRight.x2cl < myBOpening.top1.endX) {

			if (myMullionLeft.x1al > myBOpening.top1.startX
					&& myMullionLeft.x2cl < myBOpening.top1.endX) {
				myProfile = myBOpening.top1Part;
				myProfileC = myBOpening.myParent.top1Part;
				myOpening.noSidesTop = 1;
			} else if (myMullionLeft.x1al > myBOpening.left.startX
					&& myMullionLeft.x2cl < myBOpening.left.endX) {
				myProfile = myBOpening.leftPart;
				myProfileC = myBOpening.myParent.leftPart;
				myProfile2 = myBOpening.top1Part;
				myProfile2C = myBOpening.myParent.top1Part;
				myOpening.noSidesTop = 2;
			}
		} else if (myMullionRight.x1al > myBOpening.left.startX
				&& myMullionRight.x2cl < myBOpening.left.endX) {

			myProfile = myBOpening.leftPart;
			myProfileC = myBOpening.myParent.leftPart;
			myOpening.noSidesTop = 1;

		}

		if (myMullionRight.x1al < myBOpening.top1.endX
				&& myMullionRight.x2cl > myBOpening.top2.startX
				&& myMullionLeft.x2cl < myBOpening.top1.endX
				&& myMullionLeft.x1al > myBOpening.top1.startX) {

			myProfile = myBOpening.top1Part;
			myProfileC = myBOpening.myParent.top1Part;
			myOpening.noSidesTop = 1;

		} else if (myMullionLeft.x1al < myBOpening.top1.endX
				&& myMullionLeft.x2cl > myBOpening.top2.startX
				&& myMullionRight.x2cl < myBOpening.top2.endX
				&& myMullionRight.x1al > myBOpening.top2.startX) {

			myProfile = myBOpening.top2Part;
			myProfileC = myBOpening.myParent.top2Part;
			myOpening.noSidesTop = 1;

		} else if (myMullionRight.x1al < myBOpening.top1.endX
				&& myMullionRight.x2cl > myBOpening.top3.startX
				&& myMullionLeft.x2cl < myBOpening.top1.endX
				&& myMullionLeft.x1a > myBOpening.top1.startX) {

			myProfile = myBOpening.top1Part;
			myProfileC = myBOpening.myParent.top1Part;
			myOpening.noSidesTop = 1;

		} else if (myMullionLeft.x1al < myBOpening.top1.endX
				&& myMullionLeft.x2cl > myBOpening.top3.startX
				&& myMullionRight.x2cl < myBOpening.top3.endX
				&& myMullionRight.x1al > myBOpening.top3.startX) {
			myProfile = myBOpening.top3Part;
			myProfileC = myBOpening.myParent.top3Part;
			myOpening.noSidesTop = 1;

		} else if (myMullionRight.x1al < myBOpening.top3.endX
				&& myMullionRight.x2cl > myBOpening.top2.startX
				&& myMullionLeft.x2cl < myBOpening.top3.endX
				&& myMullionLeft.x1al > myBOpening.top3.startX) {
			myProfile = myBOpening.top3Part;
			myProfileC = myBOpening.myParent.top3Part;
			myOpening.noSidesTop = 1;

		} else if (myMullionLeft.x1al < myBOpening.top3.endX
				&& myMullionLeft.x2cl > myBOpening.top2.startX
				&& myMullionRight.x2cl < myBOpening.top2.endX
				&& myMullionRight.x1al > myBOpening.top2.startX) {
			myProfile = myBOpening.top2Part;
			myProfileC = myBOpening.myParent.top2Part;
			myOpening.noSidesTop = 1;

		}

		getT1xy(myProfile, myProfileC);

		if (myOpening.noSidesTop == 2) {
			getT2xy(myProfile2, myProfile2C);
		}
		if (myOpening.noSidesTop == 3) {
			getT2xy(myProfile2, myProfile2C);
			getT3xy(myProfile3, myProfile3C);
		}

		return myOpening;
	}

	public void opening_IntheMiddle(final OpeningObject myInitOpening,
			final Profiles myMullionLeft, final Profiles myMullionRight) {

		myInitOpening.noSidesTop = 1;

		tx1 = myBOpening.top1.startX;
		ty1 = myBOpening.top1.startY;
		tx1A = myBOpening.top1.startXA;
		ty1A = myBOpening.top1.startYA;
		tx1c = myBOpening.myParent.top1.startX;
		ty1c = myBOpening.myParent.top1.startY;
		tx2 = myBOpening.top1.endX;
		ty2 = myBOpening.top1.endY;
		tx2A = myBOpening.top1.endXA;
		ty2A = myBOpening.top1.endYA;
		tx2c = myBOpening.myParent.top1.endX;
		ty2c = myBOpening.myParent.top1.endY;
		t1s = myBOpening.myParent.top1.partForm;
		if (t1s > 1) {
			final double newtx1 = this.intersectX(tx1, ty1, tx2, ty2,
					myMullionLeft.x2, myMullionLeft.y2, myMullionLeft.x3,
					myMullionLeft.y3);
			final double newtx1A = this.intersectX(tx1A, ty1A, tx2A, ty2A,
					myMullionLeft.x2cl, myMullionLeft.y2cl, myMullionLeft.x3cl,
					myMullionLeft.y3cl);

			final double newtx1c = this.intersectX(tx1, ty1, tx2, ty2,
					myMullionLeft.centerXs, myMullionLeft.centerYs,
					myMullionLeft.centerXe, myMullionLeft.centerYe);
			final double newty1 = this.intersectY(tx1, ty1, tx2, ty2,
					myMullionLeft.x2, myMullionLeft.y2, myMullionLeft.x3,
					myMullionLeft.y3);
			final double newty1A = this.intersectY(tx1A, ty1A, tx2A, ty2A,
					myMullionLeft.x2cl, myMullionLeft.y2cl, myMullionLeft.x3cl,
					myMullionLeft.y3cl);

			final double newty1c = this.intersectY(tx1, ty1, tx2, ty2,
					myMullionLeft.centerXs, myMullionLeft.centerYs,
					myMullionLeft.centerXe, myMullionLeft.centerYe);

			tx1 = newtx1;
			tx1A = newtx1A;
			tx1c = newtx1c;
			ty1 = newty1;
			ty1A = newty1A;
			ty1c = newty1c;

			if (myBOpening.noSidesTop == 1) {
				final double newtx2 = this.intersectX(tx1, ty1, tx2, ty2,
						myMullionRight.x1, myMullionRight.y1,
						myMullionRight.x4, myMullionRight.y4);
				final double newtx2A = this.intersectX(tx1A, ty1A, tx2A, ty2A,
						myMullionRight.x1al, myMullionRight.y1al,
						myMullionRight.x4al, myMullionRight.y4al);

				final double newtx2c = this.intersectX(tx1, ty1, tx2, ty2,
						myMullionRight.centerXs, myMullionRight.centerYs,
						myMullionRight.centerXe, myMullionRight.centerYe);
				final double newty2 = this.intersectY(tx1, ty1, tx2, ty2,
						myMullionRight.x1, myMullionRight.y1,
						myMullionRight.x4, myMullionRight.y4);
				final double newty2A = this.intersectY(tx1A, ty1A, tx2A, ty2A,
						myMullionRight.x1al, myMullionRight.y1al,
						myMullionRight.x4al, myMullionRight.y4al);

				final double newty2c = this.intersectY(tx1, ty1, tx2, ty2,
						myMullionRight.centerXs, myMullionRight.centerYs,
						myMullionRight.centerXe, myMullionRight.centerYe);

				tx2 = newtx2;
				tx2A = newtx2A;
				tx2c = newtx2c;
				ty2 = newty2;
				ty2A = newty2A;
				ty2c = newty2c;

			}
		}

		if (myInitOpening.leftIn) {
			final double newtx1 = this.intersectX(tx1, ty1, tx2, ty2,
					myMullionLeft.x2, myMullionLeft.y2, myMullionLeft.x3,
					myMullionLeft.y3);
			final double newtx1A = this.intersectX(tx1A, ty1A, tx2A, ty2A,
					myMullionLeft.x2cl, myMullionLeft.y2cl, myMullionLeft.x3cl,
					myMullionLeft.y3cl);

			final double newtx1c = this.intersectX(tx1, ty1, tx2, ty2,
					myMullionLeft.centerXs, myMullionLeft.centerYs,
					myMullionLeft.centerXe, myMullionLeft.centerYe);
			final double newty1 = this.intersectY(tx1, ty1, tx2, ty2,
					myMullionLeft.x2, myMullionLeft.y2, myMullionLeft.x3,
					myMullionLeft.y3);
			final double newty1A = this.intersectY(tx1A, ty1A, tx2A, ty2A,
					myMullionLeft.x2cl, myMullionLeft.y2cl, myMullionLeft.x3cl,
					myMullionLeft.y3cl);

			final double newty1c = this.intersectY(tx1, ty1, tx2, ty2,
					myMullionLeft.centerXs, myMullionLeft.centerYs,
					myMullionLeft.centerXe, myMullionLeft.centerYe);

			tx1 = newtx1;
			tx1A = newtx1A;
			tx1c = newtx1c;
			ty1 = newty1;
			ty1A = newty1A;
			ty1c = newty1c;
		}

		if (myInitOpening.rightIn) {
			final double newtx2 = this.intersectX(tx1, ty1, tx2, ty2,
					myMullionRight.x1, myMullionRight.y1, myMullionRight.x4,
					myMullionRight.y4);
			final double newtx2A = this.intersectX(tx1A, ty1A, tx2A, ty2A,
					myMullionRight.x1al, myMullionRight.y1al,
					myMullionRight.x4al, myMullionRight.y4al);

			final double newtx2c = this.intersectX(tx1, ty1, tx2, ty2,
					myMullionRight.centerXs, myMullionRight.centerYs,
					myMullionRight.centerXe, myMullionRight.centerYe);
			final double newty2 = this.intersectY(tx1, ty1, tx2, ty2,
					myMullionRight.x1, myMullionRight.y1, myMullionRight.x4,
					myMullionRight.y4);
			final double newty2A = this.intersectY(tx1A, ty1A, tx2A, ty2A,
					myMullionRight.x1al, myMullionRight.y1al,
					myMullionRight.x4al, myMullionRight.y4al);

			final double newty2c = this.intersectY(tx1, ty1, tx2, ty2,
					myMullionRight.centerXs, myMullionRight.centerYs,
					myMullionRight.centerXe, myMullionRight.centerYe);

			tx2 = newtx2;
			tx2A = newtx2A;
			tx2c = newtx2c;
			ty2 = newty2;
			ty2A = newty2A;
			ty2c = newty2c;
		}

		if (myBOpening.noSidesTop == 2
				&& myMullionLeft.x2 < myBOpening.myParent.top1.endX
				&& myMullionRight.x1 < myBOpening.myParent.top2.endX
				&& myMullionRight.x1 > myBOpening.myParent.top2.startX) {
			if (t1s > 1) {
				final double newtx1 = this.intersectX(tx1, ty1, tx2, ty2,
						myMullionLeft.x2, myMullionLeft.y2, myMullionLeft.x3,
						myMullionLeft.y3);
				final double newtx1A = this.intersectX(tx1A, ty1A, tx2A, ty2A,
						myMullionLeft.x2cl, myMullionLeft.y2cl,
						myMullionLeft.x3cl, myMullionLeft.y3cl);

				final double newtx1c = this.intersectX(tx1, ty1, tx2, ty2,
						myMullionLeft.centerXs, myMullionLeft.centerYs,
						myMullionLeft.centerXe, myMullionLeft.centerYe);
				final double newty1 = this.intersectY(tx1, ty1, tx2, ty2,
						myMullionLeft.x2, myMullionLeft.y2, myMullionLeft.x3,
						myMullionLeft.y3);
				final double newty1A = this.intersectY(tx1A, ty1A, tx2A, ty2A,
						myMullionLeft.x2cl, myMullionLeft.y2cl,
						myMullionLeft.x3cl, myMullionLeft.y3cl);

				final double newty1c = this.intersectY(tx1, ty1, tx2, ty2,
						myMullionLeft.centerXs, myMullionLeft.centerYs,
						myMullionLeft.centerXe, myMullionLeft.centerYe);
				tx1 = newtx1;
				tx1A = newtx1A;
				tx1c = newtx1c;
				ty1 = newty1;
				ty1A = newty1A;
				ty1c = newty1c;

				// tx2 = newtx2;
				// tx2A = newtx2A;
				// tx2c = newtx2c;
				// ty2 = newty2;
				// ty2A = newty2A;
				// ty2c = newty2c;

			}

			t2x1 = myBOpening.top2.startX;
			t2y1 = myBOpening.top2.startY;
			t2x1A = myBOpening.top2.startXA;
			t2y1A = myBOpening.top2.startYA;
			t2x1c = myBOpening.myParent.top2.startX;
			t2y1c = myBOpening.myParent.top2.startY;
			t2s = myBOpening.myParent.top2.partForm;

			t2x2 = myBOpening.top2.endX;
			t2y2 = myBOpening.top2.endY;
			t2x2A = myBOpening.top2.endXA;
			t2y2A = myBOpening.top2.endYA;
			t2x2c = myBOpening.myParent.top2.endX;
			t2y2c = myBOpening.myParent.top2.endY;
			if (t2s > 1 || myInitOpening.rightIn) {
				final double newt2x2 = this.intersectX(t2x1, t2y1, t2x2, t2y2,
						myMullionRight.x1, myMullionRight.y1,
						myMullionRight.x4, myMullionRight.y4);
				final double newt2x2A = this.intersectX(t2x1A, t2y1A, t2x2A,
						t2y2A, myMullionRight.x1al, myMullionRight.y1al,
						myMullionRight.x4al, myMullionRight.y4al);

				final double newt2x2c = this.intersectX(t2x1, t2y1, t2x2, t2y2,
						myMullionRight.centerXs, myMullionRight.centerYs,
						myMullionRight.centerXe, myMullionRight.centerYe);

				final double newt2y2 = this.intersectY(t2x1, t2y1, t2x2, t2y2,
						myMullionRight.x1, myMullionRight.y1,
						myMullionRight.x4, myMullionRight.y4);
				final double newt2y2A = this.intersectY(t2x1A, t2y1A, t2x2A,
						t2y2A, myMullionRight.x1al, myMullionRight.y1al,
						myMullionRight.x4al, myMullionRight.y4al);

				final double newt2y2c = this.intersectY(t2x1, t2y1, t2x2, t2y2,
						myMullionRight.centerXs, myMullionRight.centerYs,
						myMullionRight.centerXe, myMullionRight.centerYe);

				t2x2 = newt2x2;
				t2x2A = newt2x2A;
				t2x2c = newt2x2c;
				t2y2 = newt2y2;
				t2y2A = newt2y2A;
				t2y2c = newt2y2c;

			}

			myInitOpening.noSidesTop = 2;
		}
		// ///////////
		else if (myBOpening.noSidesTop == 2
				&& myMullionLeft.x2 == myBOpening.myParent.top1.endX
				&& myMullionRight.x1 < myBOpening.myParent.top2.endX
				&& myMullionRight.x1 > myBOpening.myParent.top2.startX) {
			if (t1s > 1) {
				final double newtx1 = this.intersectX(tx1, ty1, tx2, ty2,
						myMullionLeft.x2, myMullionLeft.y2, myMullionLeft.x3,
						myMullionLeft.y3);
				final double newtx1A = this.intersectX(tx1A, ty1A, tx2A, ty2A,
						myMullionLeft.x2cl, myMullionLeft.y2cl,
						myMullionLeft.x3cl, myMullionLeft.y3cl);

				final double newtx1c = this.intersectX(tx1, ty1, tx2, ty2,
						myMullionLeft.centerXs, myMullionLeft.centerYs,
						myMullionLeft.centerXe, myMullionLeft.centerYe);
				final double newty1 = this.intersectY(tx1, ty1, tx2, ty2,
						myMullionLeft.x2, myMullionLeft.y2, myMullionLeft.x3,
						myMullionLeft.y3);
				final double newty1A = this.intersectY(tx1A, ty1A, tx2A, ty2A,
						myMullionLeft.x2cl, myMullionLeft.y2cl,
						myMullionLeft.x3cl, myMullionLeft.y3cl);

				final double newty1c = this.intersectY(tx1, ty1, tx2, ty2,
						myMullionLeft.centerXs, myMullionLeft.centerYs,
						myMullionLeft.centerXe, myMullionLeft.centerYe);
				tx1 = newtx1;
				tx1A = newtx1A;
				tx1c = newtx1c;
				ty1 = newty1;
				ty1A = newty1A;
				ty1c = newty1c;

				// tx2 = newtx2;
				// tx2A = newtx2A;
				// tx2c = newtx2c;
				// ty2 = newty2;
				// ty2A = newty2A;
				// ty2c = newty2c;

			}

			t2x1 = myBOpening.top2.startX;
			t2y1 = myBOpening.top2.startY;
			t2x1A = myBOpening.top2.startXA;
			t2y1A = myBOpening.top2.startYA;
			t2x1c = myBOpening.myParent.top2.startX;
			t2y1c = myBOpening.myParent.top2.startY;
			t2s = myBOpening.myParent.top2.partForm;

			t2x2 = myBOpening.top2.endX;
			t2y2 = myBOpening.top2.endY;
			t2x2A = myBOpening.top2.endXA;
			t2y2A = myBOpening.top2.endYA;
			t2x2c = myBOpening.myParent.top2.endX;
			t2y2c = myBOpening.myParent.top2.endY;
			if (t2s > 1 || myInitOpening.rightIn) {
				final double newtx2 = this.intersectX(t2x1, t2y1, t2x2, t2y2,
						myMullionRight.x1, myMullionRight.y1,
						myMullionRight.x4, myMullionRight.y4);
				final double newtx2A = this.intersectX(t2x1A, t2y1A, t2x2A,
						t2y2A, myMullionRight.x1al, myMullionRight.y1al,
						myMullionRight.x4al, myMullionRight.y4al);

				final double newtx2c = this.intersectX(t2x1, t2y1, t2x2, t2y2,
						myMullionRight.centerXs, myMullionRight.centerYs,
						myMullionRight.centerXe, myMullionRight.centerYe);

				final double newty2 = this.intersectY(t2x1, t2y1, t2x2, t2y2,
						myMullionRight.x1, myMullionRight.y1,
						myMullionRight.x4, myMullionRight.y4);
				final double newty2A = this.intersectY(t2x1A, t2y1A, t2x2A,
						t2y2A, myMullionRight.x1al, myMullionRight.y1al,
						myMullionRight.x4al, myMullionRight.y4al);

				final double newty2c = this.intersectY(t2x1, t2y1, t2x2, t2y2,
						myMullionRight.centerXs, myMullionRight.centerYs,
						myMullionRight.centerXe, myMullionRight.centerYe);

				tx2 = newtx2;
				tx2A = newtx2A;
				tx2c = newtx2c;
				ty2 = newty2;
				ty2A = newty2A;
				ty2c = newty2c;

			}

			myInitOpening.noSidesTop = 1;
		}

		// /////////////
		else if (myBOpening.noSidesTop == 2
				&& myMullionLeft.x2 >= myBOpening.myParent.top2.startX
				&& myMullionRight.x1 < myBOpening.myParent.top2.endX
				&& myMullionRight.x1 > myBOpening.myParent.top2.startX) {

			tx1 = myBOpening.top2.startX;
			ty1 = myBOpening.top2.startY;
			tx1A = myBOpening.top2.startXA;
			ty1A = myBOpening.top2.startYA;
			tx1c = myBOpening.myParent.top2.startX;
			ty1c = myBOpening.myParent.top2.startY;
			t1s = myBOpening.myParent.top2.partForm;

			tx2 = myBOpening.top2.endX;
			ty2 = myBOpening.top2.endY;
			tx2A = myBOpening.top2.endXA;
			ty2A = myBOpening.top2.endYA;
			tx2c = myBOpening.myParent.top2.endX;
			ty2c = myBOpening.myParent.top2.endY;
			if (t1s > 1 || myInitOpening.leftIn && myInitOpening.rightIn) {
				final double newtx1 = this.intersectX(tx1, ty1, tx2, ty2,
						myMullionLeft.x2, myMullionLeft.y2, myMullionLeft.x3,
						myMullionLeft.y3);
				final double newtx1A = this.intersectX(tx1A, ty1A, tx2A, ty2A,
						myMullionLeft.x2cl, myMullionLeft.y2cl,
						myMullionLeft.x3cl, myMullionLeft.y3cl);

				final double newtx1c = this.intersectX(tx1, ty1, tx2, ty2,
						myMullionLeft.centerXs, myMullionLeft.centerYs,
						myMullionLeft.centerXe, myMullionLeft.centerYe);
				final double newty1 = this.intersectY(tx1, ty1, tx2, ty2,
						myMullionLeft.x2, myMullionLeft.y2, myMullionLeft.x3,
						myMullionLeft.y3);
				final double newty1A = this.intersectY(tx1A, ty1A, tx2A, ty2A,
						myMullionLeft.x2cl, myMullionLeft.y2cl,
						myMullionLeft.x3cl, myMullionLeft.y3cl);

				final double newty1c = this.intersectY(tx1, ty1, tx2, ty2,
						myMullionLeft.centerXs, myMullionLeft.centerYs,
						myMullionLeft.centerXe, myMullionLeft.centerYe);

				final double newtx2 = this.intersectX(tx1, ty1, tx2, ty2,
						myMullionRight.x1, myMullionRight.y1,
						myMullionRight.x4, myMullionRight.y4);
				final double newtx2A = this.intersectX(tx1A, ty1A, tx2A, ty2A,
						myMullionRight.x1al, myMullionRight.y1al,
						myMullionRight.x4al, myMullionRight.y4al);

				final double newtx2c = this.intersectX(tx1, ty1, tx2, ty2,
						myMullionRight.centerXs, myMullionRight.centerYs,
						myMullionRight.centerXe, myMullionRight.centerYe);
				final double newty2 = this.intersectY(tx1, ty1, tx2, ty2,
						myMullionRight.x1, myMullionRight.y1,
						myMullionRight.x4, myMullionRight.y4);
				final double newty2A = this.intersectY(tx1A, ty1A, tx2A, ty2A,
						myMullionRight.x1al, myMullionRight.y1al,
						myMullionRight.x4al, myMullionRight.y4al);

				final double newty2c = this.intersectY(tx1, ty1, tx2, ty2,
						myMullionRight.centerXs, myMullionRight.centerYs,
						myMullionRight.centerXe, myMullionRight.centerYe);
				tx1 = newtx1;
				tx1A = newtx1A;
				tx1c = newtx1c;
				ty1 = newty1;
				ty1A = newty1A;
				ty1c = newty1c;

				tx2 = newtx2;
				tx2A = newtx2A;
				tx2c = newtx2c;
				ty2 = newty2;
				ty2A = newty2A;
				ty2c = newty2c;
			}

			myInitOpening.noSidesTop = 1;
		} else if (myBOpening.noSidesTop == 3
				&& myMullionLeft.x2 <= myBOpening.myParent.top1.endX
				&& myMullionRight.x1 > myBOpening.myParent.top3.startX
				&& myMullionRight.x1 < myBOpening.myParent.top3.endX) {

			tx1 = myBOpening.top1.startX;
			ty1 = myBOpening.top1.startY;
			tx1A = myBOpening.top1.startXA;
			ty1A = myBOpening.top1.startYA;
			tx1c = myBOpening.myParent.top1.startX;
			ty1c = myBOpening.myParent.top1.startY;

			tx2 = myBOpening.top1.endX;
			ty2 = myBOpening.top1.endY;
			tx2A = myBOpening.top1.endXA;
			ty2A = myBOpening.top1.endYA;
			tx2c = myBOpening.myParent.top1.endX;
			ty2c = myBOpening.myParent.top1.endY;
			t1s = myBOpening.myParent.top1.partForm;
			if (t1s > 1 || myInitOpening.leftIn) {
				final double newtx1 = this.intersectX(tx1, ty1, tx2, ty2,
						myMullionLeft.x2, myMullionLeft.y2, myMullionLeft.x3,
						myMullionLeft.y3);
				final double newtx1A = this.intersectX(tx1A, ty1A, tx2A, ty2A,
						myMullionLeft.x2cl, myMullionLeft.y2cl,
						myMullionLeft.x3cl, myMullionLeft.y3cl);

				final double newtx1c = this.intersectX(tx1, ty1, tx2, ty2,
						myMullionLeft.centerXs, myMullionLeft.centerYs,
						myMullionLeft.centerXe, myMullionLeft.centerYe);
				final double newty1 = this.intersectY(tx1, ty1, tx2, ty2,
						myMullionLeft.x2, myMullionLeft.y2, myMullionLeft.x3,
						myMullionLeft.y3);
				final double newty1A = this.intersectY(tx1A, ty1A, tx2A, ty2A,
						myMullionLeft.x2cl, myMullionLeft.y2cl,
						myMullionLeft.x3cl, myMullionLeft.y3cl);

				final double newty1c = this.intersectY(tx1, ty1, tx2, ty2,
						myMullionLeft.centerXs, myMullionLeft.centerYs,
						myMullionLeft.centerXe, myMullionLeft.centerYe);
				tx1 = newtx1;
				tx1A = newtx1A;
				tx1c = newtx1c;
				ty1 = newty1;
				ty1A = newty1A;
				ty1c = newty1c;

				// tx2 = newtx2;
				// tx2A = newtx2A;
				// tx2c = newtx2c;
				// ty2 = newty2;
				// ty2A = newty2A;
				// ty2c = newty2c;

			}

			t2x1 = myBOpening.top3.startX;
			t2y1 = myBOpening.top3.startY;
			t2x1A = myBOpening.top3.startXA;
			t2y1A = myBOpening.top3.startYA;
			t2x1c = myBOpening.myParent.top3.startX;
			t2y1c = myBOpening.myParent.top3.startY;

			t2x2 = myBOpening.top3.endX;
			t2y2 = myBOpening.top3.endY;
			t2x2A = myBOpening.top3.endXA;
			t2y2A = myBOpening.top3.endYA;
			t2x2c = myBOpening.myParent.top3.endX;
			t2y2c = myBOpening.myParent.top3.endY;

			t2s = myBOpening.myParent.top3.partForm;
			myInitOpening.noSidesTop = 2;

		} else if (myBOpening.noSidesTop == 3
				&& myMullionLeft.x2 >= myBOpening.myParent.top3.startX
				&& myMullionLeft.x2 < myBOpening.myParent.top3.endX
				&& myMullionRight.x1 > myBOpening.myParent.top2.startX) {

			tx1 = myBOpening.top3.startX;
			ty1 = myBOpening.top3.startY;
			tx1A = myBOpening.top3.startXA;
			ty1A = myBOpening.top3.startYA;
			tx1c = myBOpening.myParent.top3.startX;
			ty1c = myBOpening.myParent.top3.startY;

			tx2 = myBOpening.top3.endX;
			ty2 = myBOpening.top3.endY;
			tx2A = myBOpening.top3.endXA;
			ty2A = myBOpening.top3.endYA;
			tx2c = myBOpening.myParent.top3.endX;
			ty2c = myBOpening.myParent.top3.endY;
			t1s = myBOpening.myParent.top3.partForm;

			t2x1 = myBOpening.top2.startX;
			t2y1 = myBOpening.top2.startY;
			t2x1A = myBOpening.top2.startXA;
			t2y1A = myBOpening.top2.startYA;
			t2x1c = myBOpening.myParent.top2.startX;
			t2y1c = myBOpening.myParent.top2.startY;

			t2x2 = myBOpening.top2.endX;
			t2y2 = myBOpening.top2.endY;
			t2x2A = myBOpening.top2.endXA;
			t2y2A = myBOpening.top2.endYA;
			t2x2c = myBOpening.myParent.top2.endX;
			t2y2c = myBOpening.myParent.top2.endY;

			t2s = myBOpening.myParent.top2.partForm;

			if (t2s > 1 || myInitOpening.rightIn) {
				final double newt2x2 = this.intersectX(t2x1, t2y1, t2x2, t2y2,
						myMullionRight.x1, myMullionRight.y1,
						myMullionRight.x4, myMullionRight.y4);
				final double newt2x2A = this.intersectX(t2x1A, t2y1A, t2x2A,
						t2y2A, myMullionRight.x1al, myMullionRight.y1al,
						myMullionRight.x4al, myMullionRight.y4al);

				final double newt2x2c = this.intersectX(t2x1, t2y1, t2x2, t2y2,
						myMullionRight.centerXs, myMullionRight.centerYs,
						myMullionRight.centerXe, myMullionRight.centerYe);
				final double newt2y2 = this.intersectY(t2x1, t2y1, t2x2, t2y2,
						myMullionRight.x1, myMullionRight.y1,
						myMullionRight.x4, myMullionRight.y4);
				final double newt2y2A = this.intersectY(t2x1A, t2y1A, t2x2A,
						t2y2A, myMullionRight.x1al, myMullionRight.y1al,
						myMullionRight.x4al, myMullionRight.y4al);

				final double newt2y2c = this.intersectY(t2x1, t2y1, t2x2, t2y2,
						myMullionRight.centerXs, myMullionRight.centerYs,
						myMullionRight.centerXe, myMullionRight.centerYe);

				t2x2 = newt2x2;
				t2x2A = newt2x2A;
				t2x2c = newt2x2c;
				t2y2 = newt2y2;
				t2y2A = newt2y2A;
				t2y2c = newt2y2c;
			}

			myInitOpening.noSidesTop = 2;

		} else if (myBOpening.noSidesTop == 3
				&& myMullionLeft.x2 > myBOpening.myParent.top3.startX
				&& myMullionLeft.x2 < myBOpening.myParent.top3.endX
				&& myMullionRight.x1 > myBOpening.myParent.top3.startX
				&& myMullionRight.x1 < myBOpening.myParent.top3.endX) {

			tx1 = myBOpening.top3.startX;
			ty1 = myBOpening.top3.startY;
			tx1A = myBOpening.top3.startXA;
			ty1A = myBOpening.top3.startYA;
			tx1c = myBOpening.myParent.top3.startX;
			ty1c = myBOpening.myParent.top3.startY;

			tx2 = myBOpening.top3.endX;
			ty2 = myBOpening.top3.endY;
			tx2A = myBOpening.top3.endXA;
			ty2A = myBOpening.top3.endYA;
			tx2c = myBOpening.myParent.top3.endX;
			ty2c = myBOpening.myParent.top3.endY;
			t1s = myBOpening.myParent.top3.partForm;
			if (t1s > 1 || myInitOpening.leftIn && myInitOpening.rightIn) {
				final double newtx1 = this.intersectX(tx1, ty1, tx2, ty2,
						myMullionLeft.x2, myMullionLeft.y2, myMullionLeft.x3,
						myMullionLeft.y3);
				final double newtx1A = this.intersectX(tx1A, ty1A, tx2A, ty2A,
						myMullionLeft.x2cl, myMullionLeft.y2cl,
						myMullionLeft.x3cl, myMullionLeft.y3cl);

				final double newtx1c = this.intersectX(tx1, ty1, tx2, ty2,
						myMullionLeft.centerXs, myMullionLeft.centerYs,
						myMullionLeft.centerXe, myMullionLeft.centerYe);
				final double newty1 = this.intersectY(tx1, ty1, tx2, ty2,
						myMullionLeft.x2, myMullionLeft.y2, myMullionLeft.x3,
						myMullionLeft.y3);
				final double newty1A = this.intersectY(tx1A, ty1A, tx2A, ty2A,
						myMullionLeft.x2cl, myMullionLeft.y2cl,
						myMullionLeft.x3cl, myMullionLeft.y3cl);

				final double newty1c = this.intersectY(tx1, ty1, tx2, ty2,
						myMullionLeft.centerXs, myMullionLeft.centerYs,
						myMullionLeft.centerXe, myMullionLeft.centerYe);

				final double newtx2 = this.intersectX(tx1, ty1, tx2, ty2,
						myMullionRight.x1, myMullionRight.y1,
						myMullionRight.x4, myMullionRight.y4);
				final double newtx2A = this.intersectX(tx1A, ty1A, tx2A, ty2A,
						myMullionRight.x1al, myMullionRight.y1al,
						myMullionRight.x4al, myMullionRight.y4al);

				final double newtx2c = this.intersectX(tx1, ty1, tx2, ty2,
						myMullionRight.centerXs, myMullionRight.centerYs,
						myMullionRight.centerXe, myMullionRight.centerYe);
				final double newty2 = this.intersectY(tx1, ty1, tx2, ty2,
						myMullionRight.x1, myMullionRight.y1,
						myMullionRight.x4, myMullionRight.y4);
				final double newty2A = this.intersectY(tx1A, ty1A, tx2A, ty2A,
						myMullionRight.x1al, myMullionRight.y1al,
						myMullionRight.x4al, myMullionRight.y4al);

				final double newty2c = this.intersectY(tx1, ty1, tx2, ty2,
						myMullionRight.centerXs, myMullionRight.centerYs,
						myMullionRight.centerXe, myMullionRight.centerYe);

				tx1 = newtx1;
				tx1A = newtx1A;
				tx1c = newtx1c;
				ty1 = newty1;
				ty1A = newty1A;
				ty1c = newty1c;

				tx2 = newtx2;
				tx2A = newtx2A;
				tx2c = newtx2c;
				ty2 = newty2;
				ty2A = newty2A;
				ty2c = newty2c;
			}
			myInitOpening.noSidesTop = 1;

		} else if (myBOpening.noSidesTop == 3
				&& myMullionLeft.x2 <= myBOpening.myParent.top1.endX
				&& myMullionRight.x1 >= myBOpening.myParent.top2.startX) {

			tx1 = myBOpening.top1.startX;
			ty1 = myBOpening.top1.startY;
			tx1A = myBOpening.top1.startXA;
			ty1A = myBOpening.top1.startYA;
			tx1c = myBOpening.myParent.top1.startX;
			ty1c = myBOpening.myParent.top1.startY;
			tx2 = myBOpening.top1.endX;
			ty2 = myBOpening.top1.endY;
			tx2A = myBOpening.top1.endXA;
			ty2A = myBOpening.top1.endYA;
			tx2c = myBOpening.myParent.top1.endX;
			ty2c = myBOpening.myParent.top1.endY;
			t1s = myBOpening.myParent.top1.partForm;
			if (t1s > 1 || myInitOpening.leftIn) {
				final double newtx1 = this.intersectX(tx1, ty1, tx2, ty2,
						myMullionLeft.x2, myMullionLeft.y2, myMullionLeft.x3,
						myMullionLeft.y3);
				final double newtx1A = this.intersectX(tx1A, ty1A, tx2A, ty2A,
						myMullionLeft.x2cl, myMullionLeft.y2cl,
						myMullionLeft.x3cl, myMullionLeft.y3cl);

				final double newtx1c = this.intersectX(tx1, ty1, tx2, ty2,
						myMullionLeft.centerXs, myMullionLeft.centerYs,
						myMullionLeft.centerXe, myMullionLeft.centerYe);
				final double newty1 = this.intersectY(tx1, ty1, tx2, ty2,
						myMullionLeft.x2, myMullionLeft.y2, myMullionLeft.x3,
						myMullionLeft.y3);
				final double newty1A = this.intersectY(tx1A, ty1A, tx2A, ty2A,
						myMullionLeft.x2cl, myMullionLeft.y2cl,
						myMullionLeft.x3cl, myMullionLeft.y3cl);

				final double newty1c = this.intersectY(tx1, ty1, tx2, ty2,
						myMullionLeft.centerXs, myMullionLeft.centerYs,
						myMullionLeft.centerXe, myMullionLeft.centerYe);

				tx1 = newtx1;
				tx1A = newtx1A;
				tx1c = newtx1c;
				ty1 = newty1;
				ty1A = newty1A;
				ty1c = newty1c;

				// tx2 = newtx2;
				// tx2A = newtx2A;
				// tx2c = newtx2c;
				// ty2 = newty2;
				// ty2A = newty2A;
				// ty2c = newty2c;

			}
			t3x2 = myBOpening.top3.startX;
			t3y2 = myBOpening.top3.startY;
			t3x2A = myBOpening.top3.startXA;
			t3y2A = myBOpening.top3.startYA;
			t3x2c = myBOpening.myParent.top3.startX;
			t3y2c = myBOpening.myParent.top3.startY;

			t3x1 = myBOpening.top3.endX;
			t3y1 = myBOpening.top3.endY;
			t3x1A = myBOpening.top3.endXA;
			t3y1A = myBOpening.top3.endYA;
			t3x1c = myBOpening.myParent.top3.endX;
			t3y1c = myBOpening.myParent.top3.endY;

			t3s = myBOpening.myParent.top3.partForm;

			t2x1 = myBOpening.top2.startX;
			t2y1 = myBOpening.top2.startY;
			t2x1A = myBOpening.top2.startXA;
			t2y1A = myBOpening.top2.startYA;
			t2x1c = myBOpening.myParent.top2.startX;
			t2y1c = myBOpening.myParent.top2.startY;

			t2x2 = myBOpening.top2.endX;
			t2y2 = myBOpening.top2.endY;
			t2x2A = myBOpening.top2.endXA;
			t2y2A = myBOpening.top2.endYA;
			t2x2c = myBOpening.myParent.top2.endX;
			t2y2c = myBOpening.myParent.top2.endY;

			t2s = myBOpening.myParent.top2.partForm;

			if (t2s > 1 || myInitOpening.rightIn) {
				final double newt2x2 = this.intersectX(t2x1, t2y1, t2x2, t2y2,
						myMullionRight.x1, myMullionRight.y1,
						myMullionRight.x4, myMullionRight.y4);
				final double newt2x2A = this.intersectX(t2x1A, t2y1A, t2x2A,
						t2y2A, myMullionRight.x1al, myMullionRight.y1al,
						myMullionRight.x4al, myMullionRight.y4al);

				final double newt2x2c = this.intersectX(t2x1, t2y1, t2x2, t2y2,
						myMullionRight.centerXs, myMullionRight.centerYs,
						myMullionRight.centerXe, myMullionRight.centerYe);
				final double newt2y2 = this.intersectY(t2x1, t2y1, t2x2, t2y2,
						myMullionRight.x1, myMullionRight.y1,
						myMullionRight.x4, myMullionRight.y4);
				final double newt2y2A = this.intersectY(t2x1A, t2y1A, t2x2A,
						t2y2A, myMullionRight.x1al, myMullionRight.y1al,
						myMullionRight.x4al, myMullionRight.y4al);

				final double newt2y2c = this.intersectY(t2x1, t2y1, t2x2, t2y2,
						myMullionRight.centerXs, myMullionRight.centerYs,
						myMullionRight.centerXe, myMullionRight.centerYe);

				t2x2 = newt2x2;
				t2x2A = newt2x2A;
				t2x2c = newt2x2c;
				t2y2 = newt2y2;
				t2y2A = newt2y2A;
				t2y2c = newt2y2c;
			}
			myInitOpening.noSidesTop = 3;

		}

		if (myInitOpening.shapeID == 100 && myInitOpening.noSidesTop == 2
				&& ty1 > ty2 && t2y1 == t2y2) {
			myInitOpening.shapeID = 154;

			myInitOpening.noSides = 5;
		} else if (myInitOpening.shapeID == 100
				&& myInitOpening.noSidesTop == 2 && ty1 > ty2 && t2y1 < t2y2) {
			myInitOpening.shapeID = 150;
			myInitOpening.noSides = 5;
		} else if (myInitOpening.shapeID == 100
				&& myInitOpening.noSidesTop == 2 && ty1 == ty2 && t2y1 < t2y2) {
			myInitOpening.shapeID = 155;
			myInitOpening.noSides = 5;
		}

	}

	public OpeningObject opening_Top_StartMiddle_EndAtEndCol(
			final OpeningObject myOpening, final Profiles myMullionLeft) {

		Profiles myProfile = new Profiles();
		Profiles myProfileC = new Profiles();

		Profiles myProfile2 = new Profiles();
		Profiles myProfile2C = new Profiles();

		Profiles myProfile3 = new Profiles();
		Profiles myProfile3C = new Profiles();

		if (myMullionLeft.x1al > myBOpening.right.startX
				&& myMullionLeft.x2cl < myBOpening.right.endX) {

			myProfile = myBOpening.rightPart;
			myProfileC = myBOpening.myParent.rightPart;

			myOpening.noSidesTop = 1;

			// cannot have bottom 2 or bottom 3 No Such
			// Shapes

		} else if (myMullionLeft.centerXs + 1 >= myBOpening.top2.startX
				&& myMullionLeft.x2cl < myBOpening.top2.endX
				&& myBOpening.myParent.top2.posInUse) {
			//
			myProfile = myBOpening.top2Part;
			myProfileC = myBOpening.myParent.top2Part;

			myOpening.noSidesTop = 1;

		} else if (myMullionLeft.centerXs + 1 >= myBOpening.top3.startX
				&& myMullionLeft.x2cl < myBOpening.top3.endX
				&& myBOpening.myParent.top3.posInUse) {

			myProfile = myBOpening.top3Part;
			myProfileC = myBOpening.myParent.top3Part;

			myProfile2 = myBOpening.top2Part;
			myProfile2C = myBOpening.myParent.top2Part;

			myOpening.noSidesTop = 2;

		} else if (myMullionLeft.x1al > myBOpening.top1.startX
				&& myMullionLeft.x2cl < myBOpening.top1.endX) {
			if (myBOpening.noSidesTop == 1) {
				myProfile = myBOpening.top1Part;
				myProfileC = myBOpening.myParent.top1Part;

				myOpening.noSidesTop = 1;
			}
			if (myBOpening.noSidesTop == 2) {
				myProfile = myBOpening.top1Part;
				myProfileC = myBOpening.myParent.top1Part;

				myProfile2 = myBOpening.top2Part;
				myProfile2C = myBOpening.myParent.top2Part;

				myOpening.noSidesTop = 2;
			} else if (myBOpening.noSidesBot == 3) {
				myProfile = myBOpening.top1Part;
				myProfileC = myBOpening.myParent.top1Part;

				myProfile2 = myBOpening.top2Part;
				myProfile2C = myBOpening.myParent.top2Part;

				myProfile3 = myBOpening.top3Part;
				myProfile3C = myBOpening.myParent.top3Part;

				myOpening.noSidesTop = 3;

			}

		} else if (myMullionLeft.x1al > myBOpening.left.startX
				&& myMullionLeft.x2cl < myBOpening.left.endX) {

			myProfile = myBOpening.leftPart;
			myProfileC = myBOpening.myParent.leftPart;

			myProfile2 = myBOpening.top1Part;
			myProfile2C = myBOpening.myParent.top1Part;

			myOpening.noSidesBot = 2;
		}

		getT1xy(myProfile, myProfileC);

		if (myOpening.noSidesTop == 2) {
			getT2xy(myProfile2, myProfile2C);
		}
		if (myOpening.noSidesTop == 3) {
			getT2xy(myProfile2, myProfile2C);
			getT3xy(myProfile3, myProfile3C);
		}

		return myOpening;
	}

	public void opening_StartInMiddle_EndAtEndCol(
			final OpeningObject myInitOpening, final Profiles myMullionLeft) {

		myInitOpening.noSidesTop = 1;

		tx1 = myBOpening.top1.startX;
		ty1 = myBOpening.top1.startY;
		tx1A = myBOpening.top1.startX;
		ty1A = myBOpening.top1.startYA;
		tx1c = myBOpening.myParent.top1.startX;
		ty1c = myBOpening.myParent.top1.startY;

		tx2 = myBOpening.top1.endX;
		ty2 = myBOpening.top1.endY;
		tx2A = myBOpening.top1.endXA;
		ty2A = myBOpening.top1.endYA;
		tx2c = myBOpening.myParent.top1.endX;
		ty2c = myBOpening.myParent.top1.endY;
		t1s = myBOpening.myParent.top1.partForm;

		if (t1s > 1 || myInitOpening.leftIn) {
			final double newtx1 = this.intersectX(tx1, ty1, tx2, ty2,
					myMullionLeft.x2, myMullionLeft.y2, myMullionLeft.x3,
					myMullionLeft.y3);
			final double newtx1A = this.intersectX(tx1A, ty1A, tx2A, ty2A,
					myMullionLeft.x2cl, myMullionLeft.y2cl, myMullionLeft.x3cl,
					myMullionLeft.y3cl);
			final double newtx1c = this.intersectX(tx1, ty1, tx2, ty2,
					myMullionLeft.centerXs, myMullionLeft.centerYs,
					myMullionLeft.centerXe, myMullionLeft.centerYe);
			final double newty1 = this.intersectY(tx1, ty1, tx2, ty2,
					myMullionLeft.x2, myMullionLeft.y2, myMullionLeft.x3,
					myMullionLeft.y3);
			final double newty1A = this.intersectY(tx1A, ty1A, tx2A, ty2A,
					myMullionLeft.x2cl, myMullionLeft.y2cl, myMullionLeft.x3cl,
					myMullionLeft.y3cl);

			final double newty1c = this.intersectY(tx1, ty1, tx2, ty2,
					myMullionLeft.centerXs, myMullionLeft.centerYs,
					myMullionLeft.centerXe, myMullionLeft.centerYe);

			tx1 = newtx1;
			tx1A = newtx1A;
			tx1c = newtx1c;
			ty1 = newty1;
			ty1A = newty1A;
			ty1c = newty1c;
		}

		if (myBOpening.noSidesTop == 2
				&& myMullionLeft.x2 < myBOpening.myParent.top1.endX) {

			t2x1 = myBOpening.top2.startX;
			t2y1 = myBOpening.top2.startY;
			t2x1A = myBOpening.top2.startXA;
			t2y1A = myBOpening.top2.startYA;
			t2x1c = myBOpening.myParent.top2.startX;
			t2y1c = myBOpening.myParent.top2.startY;
			t2s = myBOpening.myParent.top2.partForm;

			t2x2 = myBOpening.top2.endX;
			t2y2 = myBOpening.top2.endY;
			t2x2A = myBOpening.top2.endXA;
			t2y2A = myBOpening.top2.endYA;
			t2x1c = myBOpening.myParent.top2.endX;
			t2y1c = myBOpening.myParent.top2.endY;
			myInitOpening.noSidesTop = 2;

		} else if (myBOpening.noSidesTop == 2
				&& myMullionLeft.x2 >= myBOpening.myParent.top1.endX
				&& myMullionLeft.x2 <= myBOpening.myParent.top2.endX) {

			tx1 = myBOpening.top2.startX;
			ty1 = myBOpening.top2.startY;
			tx1A = myBOpening.top2.startXA;
			ty1A = myBOpening.top2.startYA;
			tx1c = myBOpening.myParent.top2.startX;
			ty1c = myBOpening.myParent.top2.startY;

			tx2 = myBOpening.top2.endX;
			ty2 = myBOpening.top2.endY;
			tx2A = myBOpening.top2.endXA;
			ty2A = myBOpening.top2.endYA;
			tx2c = myBOpening.myParent.top2.endX;
			ty2c = myBOpening.myParent.top2.endY;
			t1s = myBOpening.myParent.top1.partForm;
			if (t1s > 1 || myInitOpening.leftIn) {
				final double newtx1 = this.intersectX(tx1, ty1, tx2, ty2,
						myMullionLeft.x2, myMullionLeft.y2, myMullionLeft.x3,
						myMullionLeft.y3);
				final double newtx1A = this.intersectX(tx1A, ty1A, tx2A, ty2A,
						myMullionLeft.x2cl, myMullionLeft.y2cl,
						myMullionLeft.x3cl, myMullionLeft.y3cl);
				final double newtx1c = this.intersectX(tx1, ty1, tx2, ty2,
						myMullionLeft.centerXs, myMullionLeft.centerYs,
						myMullionLeft.centerXe, myMullionLeft.centerYe);
				final double newty1 = this.intersectY(tx1, ty1, tx2, ty2,
						myMullionLeft.x2, myMullionLeft.y2, myMullionLeft.x3,
						myMullionLeft.y3);
				final double newty1A = this.intersectY(tx1A, ty1A, tx2A, ty2A,
						myMullionLeft.x2cl, myMullionLeft.y2cl,
						myMullionLeft.x3cl, myMullionLeft.y3cl);

				final double newty1c = this.intersectY(tx1, ty1, tx2, ty2,
						myMullionLeft.centerXs, myMullionLeft.centerYs,
						myMullionLeft.centerXe, myMullionLeft.centerYe);

				tx1 = newtx1;
				tx1A = newtx1A;
				tx1c = newtx1c;
				ty1 = newty1;
				ty1A = newty1A;
				ty1c = newty1c;

			}
			myInitOpening.noSidesTop = 1;

		} else if (myBOpening.noSidesTop == 3
				&& myMullionLeft.x2 < myBOpening.myParent.top1.endX) {

			t3x1 = myBOpening.top3.startX;
			t3y1 = myBOpening.top3.startY;
			t3x1A = myBOpening.top3.startXA;
			t3y1A = myBOpening.top3.startYA;
			t3x1c = myBOpening.myParent.top3.startX;
			t3y1c = myBOpening.myParent.top3.startY;
			t3x2 = myBOpening.top3.endX;
			t3y2 = myBOpening.top3.endY;
			t3x2A = myBOpening.top3.endXA;
			t3y2A = myBOpening.top3.endYA;
			t3x1c = myBOpening.myParent.top3.endX;
			t3y1c = myBOpening.myParent.top3.endY;

			t3s = myBOpening.myParent.top3.partForm;

			t2x1 = myBOpening.top2.startX;
			t2y1 = myBOpening.top2.startY;
			t2x1A = myBOpening.top2.startXA;
			t2y1A = myBOpening.top2.startYA;
			t2x1c = myBOpening.myParent.top2.startX;
			t2y1c = myBOpening.myParent.top2.startY;

			t2x2 = myBOpening.top2.endX;
			t2y2 = myBOpening.top2.endY;
			t2x2A = myBOpening.top2.endXA;
			t2y2A = myBOpening.top2.endYA;
			t2x1c = myBOpening.myParent.top2.endX;
			t2y1c = myBOpening.myParent.top2.endY;

			t2s = myBOpening.myParent.top2.partForm;

			myInitOpening.noSidesTop = 3;

		} else if (myBOpening.noSidesTop == 3
				&& myMullionLeft.x2 > myBOpening.myParent.top1.endX
				&& myMullionLeft.x2 < myBOpening.myParent.top3.endX) {

			tx1 = myBOpening.top3.startX;
			ty1 = myBOpening.top3.startY;
			tx1A = myBOpening.top3.startXA;
			ty1A = myBOpening.top3.startYA;
			tx1c = myBOpening.myParent.top3.startX;
			ty1c = myBOpening.myParent.top3.startY;
			t1s = myBOpening.myParent.top3.partForm;

			tx2 = myBOpening.top3.endX;
			ty2 = myBOpening.top3.endY;
			tx2A = myBOpening.top3.endXA;
			ty2A = myBOpening.top3.endYA;
			tx2c = myBOpening.myParent.top3.endX;
			ty2c = myBOpening.myParent.top3.endY;

			t1s = myBOpening.myParent.top3.partForm;
			t2x1 = myBOpening.top2.startX;
			t2y1 = myBOpening.top2.startY;
			t2x1A = myBOpening.top2.startXA;
			t2y1A = myBOpening.top2.startYA;
			t2x1c = myBOpening.myParent.top2.startX;
			t2y1c = myBOpening.myParent.top2.startY;

			t2x2 = myBOpening.top2.endX;
			t2y2 = myBOpening.top2.endY;
			t2x2A = myBOpening.top2.endXA;
			t2y2A = myBOpening.top2.endYA;
			t2x1c = myBOpening.myParent.top2.endX;
			t2y1c = myBOpening.myParent.top2.endY;

			t2s = myBOpening.myParent.top2.partForm;

			myInitOpening.noSidesTop = 2;

		} else if (myBOpening.noSidesTop == 3
				&& myMullionLeft.x2 > myBOpening.myParent.top3.endX
				&& myMullionLeft.x2 < myBOpening.myParent.top2.endX) {
			tx1 = myBOpening.top2.startX;
			ty1 = myBOpening.top2.startY;
			tx1A = myBOpening.top2.startXA;
			ty1A = myBOpening.top2.startYA;
			tx1c = myBOpening.myParent.top2.startX;
			ty1c = myBOpening.myParent.top2.startY;

			tx2 = myBOpening.top2.endX;
			ty2 = myBOpening.top2.endY;
			tx2A = myBOpening.top2.endXA;
			ty2A = myBOpening.top2.endYA;
			tx2c = myBOpening.myParent.top2.endX;
			ty2c = myBOpening.myParent.top2.endY;
			t1s = myBOpening.myParent.top2.partForm;
			if (t1s > 1 || myInitOpening.leftIn) {
				final double newtx1 = this.intersectX(tx1, ty1, tx2, ty2,
						myMullionLeft.x2, myMullionLeft.y2, myMullionLeft.x3,
						myMullionLeft.y3);
				final double newtx1A = this.intersectX(tx1A, ty1A, tx2A, ty2A,
						myMullionLeft.x2cl, myMullionLeft.y2cl,
						myMullionLeft.x3cl, myMullionLeft.y3cl);
				final double newtx1c = this.intersectX(tx1, ty1, tx2, ty2,
						myMullionLeft.centerXs, myMullionLeft.centerYs,
						myMullionLeft.centerXe, myMullionLeft.centerYe);
				final double newty1 = this.intersectY(tx1, ty1, tx2, ty2,
						myMullionLeft.x2, myMullionLeft.y2, myMullionLeft.x3,
						myMullionLeft.y3);
				final double newty1A = this.intersectY(tx1A, ty1A, tx2A, ty2A,
						myMullionLeft.x2cl, myMullionLeft.y2cl,
						myMullionLeft.x3cl, myMullionLeft.y3cl);

				final double newty1c = this.intersectY(tx1, ty1, tx2, ty2,
						myMullionLeft.centerXs, myMullionLeft.centerYs,
						myMullionLeft.centerXe, myMullionLeft.centerYe);

				tx1 = newtx1;
				tx1A = newtx1A;
				tx1c = newtx1c;
				ty1 = newty1;
				ty1A = newty1A;
				ty1c = newty1c;
			}
			myInitOpening.noSidesTop = 1;

		}
	}

	public void opening_OnlyOne(final OpeningObject myInitOpening) {

		tx1 = myBOpening.top1.startX;
		ty1 = myBOpening.top1.startY;
		tx1A = myBOpening.myParent.top1.startXA;
		ty1A = myBOpening.myParent.top1.startYA;
		tx1c = myBOpening.myParent.top1.startX;
		ty1c = myBOpening.myParent.top1.startY;
		tx2 = myBOpening.top1.endX;
		ty2 = myBOpening.top1.endY;
		tx2A = myBOpening.myParent.top1.endXA;
		ty2A = myBOpening.myParent.top1.endYA;
		tx2c = myBOpening.myParent.top1.endX;
		ty2c = myBOpening.myParent.top1.endY;
		t1s = myBOpening.myParent.top1.partForm;
		myInitOpening.noSidesTop = 1;

		if (myBOpening.noSidesTop == 2) {
			t2x1 = myBOpening.top2.startX;
			t2y1 = myBOpening.myParent.top2.startY;
			t2x1A = myBOpening.myParent.top2.startXA;
			t2y1A = myBOpening.top2.startYA;
			t2x1c = myBOpening.myParent.top2.startX;
			t2y1c = myBOpening.myParent.top2.startY;
			t2x2 = myBOpening.top2.endX;
			t2y2 = myBOpening.top2.endY;
			t2x2A = myBOpening.myParent.top2.endXA;
			t2y2A = myBOpening.myParent.top2.endYA;
			t2x1c = myBOpening.myParent.top2.endX;
			t2y1c = myBOpening.myParent.top2.endY;
			t2s = myBOpening.myParent.top2.partForm;
			myInitOpening.noSidesTop = 2;
		}

		if (myBOpening.noSidesTop == 3) {
			t3x1 = myBOpening.top3.startX;
			t3y1 = myBOpening.top3.startY;
			t3x1A = myBOpening.myParent.top3.startXA;
			t3y1A = myBOpening.myParent.top3.startYA;
			t3x1c = myBOpening.myParent.top3.startX;
			t3y1c = myBOpening.myParent.top3.startY;
			t3x2 = myBOpening.top3.endX;
			t3y2 = myBOpening.top3.endY;
			t3x2A = myBOpening.myParent.top3.endXA;
			t3y2A = myBOpening.myParent.top3.endYA;
			t3x2c = myBOpening.myParent.top3.endX;
			t3y2c = myBOpening.myParent.top3.endY;
			t3s = myBOpening.myParent.top3.partForm;

			t2x1 = myBOpening.top2.startX;
			t2y1 = myBOpening.top2.startY;
			t2x1A = myBOpening.top2.startXA;
			t2y1A = myBOpening.top2.startYA;
			t2x1c = myBOpening.myParent.top2.startX;
			t2y1c = myBOpening.myParent.top2.startY;
			t2x2 = myBOpening.top2.endX;
			t2y2 = myBOpening.top2.endY;
			t2x2A = myBOpening.top2.endXA;
			t2y2A = myBOpening.top2.endYA;
			t2x1c = myBOpening.myParent.top2.endX;
			t2y1c = myBOpening.myParent.top2.endY;
			t2s = myBOpening.myParent.top2.partForm;
			myInitOpening.noSidesTop = 3;
		}
	}

	public OpeningObject opening_Top_StartAtBegining_EndInMiddle(
			final OpeningObject myOpening, final Profiles myMullionRight) {

		Profiles myProfile = new Profiles();
		Profiles myProfileC = new Profiles();

		Profiles myProfile2 = new Profiles();
		Profiles myProfile2C = new Profiles();

		Profiles myProfile3 = new Profiles();
		Profiles myProfile3C = new Profiles();

		if (myMullionRight.x1al > myBOpening.myParent.right.startX
				&& myMullionRight.x2cl < myBOpening.myParent.right.endX) {

			myProfile = myBOpening.top1Part;
			myProfileC = myBOpening.myParent.top1Part;

			myProfile2 = myBOpening.rightPart;
			myProfile2C = myBOpening.myParent.rightPart;

			myOpening.noSidesTop = 2;

		} else if (myMullionRight.x1al > myBOpening.myParent.top1.startX
				&& myMullionRight.centerXs - 1 <= myBOpening.myParent.top1.endX) {

			myProfile = myBOpening.top1Part;
			myProfileC = myBOpening.myParent.top1Part;

			myOpening.noSidesTop = 1;

		} else if (myMullionRight.x1al > myBOpening.myParent.top3.startX
				&& myMullionRight.centerXs - 1 <= myBOpening.myParent.top3.endX) {

			myProfile = myBOpening.top1Part;
			myProfileC = myBOpening.myParent.top1Part;

			myProfile2 = myBOpening.top3Part;
			myProfile2C = myBOpening.myParent.top3Part;

			myOpening.noSidesTop = 2;

		} else if (myMullionRight.x1al > myBOpening.myParent.top2.startX
				&& myMullionRight.x2cl < myBOpening.myParent.top2.endX
				&& myBOpening.myParent.top2.posInUse) {

			if (myBOpening.noSidesTop == 2) {
				myProfile = myBOpening.top1Part;
				myProfileC = myBOpening.myParent.top1Part;

				myProfile2 = myBOpening.top2Part;
				myProfile2C = myBOpening.myParent.top2Part;

				myOpening.noSidesTop = 2;
			} else if (myBOpening.noSidesBot == 3) {
				myProfile = myBOpening.top1Part;
				myProfileC = myBOpening.myParent.top1Part;

				myProfile2 = myBOpening.top2Part;
				myProfile2C = myBOpening.myParent.top2Part;

				myProfile3 = myBOpening.top3Part;
				myProfile3C = myBOpening.myParent.top3Part;

				myOpening.noSidesTop = 3;

			}

		} else if (myMullionRight.x1al > myBOpening.myParent.left.startX
				&& myMullionRight.x2cl < myBOpening.myParent.left.endX) {

			myProfile = myBOpening.leftPart;
			myProfileC = myBOpening.myParent.leftPart;

			myOpening.noSidesBot = 1;
		}

		getT1xy(myProfile, myProfileC);

		if (myOpening.noSidesTop == 2) {
			getT2xy(myProfile2, myProfile2C);
		}
		if (myOpening.noSidesTop == 3) {
			getT2xy(myProfile2, myProfile2C);
			getT3xy(myProfile3, myProfile3C);
		}

		return myOpening;
	}

	public void opening_StartAtBegining_EndInMiddle(
			final OpeningObject myInitOpening, final Profiles myMullionRight) {

		tx1 = myBOpening.top1.startX;
		ty1 = myBOpening.top1.startY;
		tx1A = myBOpening.top1.startXA;
		ty1A = myBOpening.top1.startYA;
		tx1c = myBOpening.myParent.top1.startX;
		ty1c = myBOpening.myParent.top1.startY;
		t1s = myBOpening.myParent.top1.partForm;

		tx2 = myBOpening.top1.endX;
		ty2 = myBOpening.top1.endY;
		tx2A = myBOpening.top1.endXA;
		ty2A = myBOpening.top1.endYA;
		tx2c = myBOpening.myParent.top1.endX;
		ty2c = myBOpening.myParent.top1.endY;

		if (t1s > 1 || myInitOpening.rightIn) {
			final double newtx2 = this.intersectX(tx1, ty1, tx2, ty2,
					myMullionRight.x1, myMullionRight.y1, myMullionRight.x4,
					myMullionRight.y4);
			final double newtx2A = this.intersectX(tx1A, ty1A, tx2A, ty2A,
					myMullionRight.x1al, myMullionRight.y1al,
					myMullionRight.x4al, myMullionRight.y4al);

			final double newtx2c = this.intersectX(tx1, ty1, tx2, ty2,
					myMullionRight.centerXs, myMullionRight.centerYs,
					myMullionRight.centerXe, myMullionRight.centerYe);
			final double newty2 = this.intersectY(tx1, ty1, tx2, ty2,
					myMullionRight.x1, myMullionRight.y1, myMullionRight.x4,
					myMullionRight.y4);
			final double newty2A = this.intersectY(tx1A, ty1A, tx2A, ty2A,
					myMullionRight.x1al, myMullionRight.y1al,
					myMullionRight.x4al, myMullionRight.y4al);

			final double newty2c = this.intersectY(tx1, ty1, tx2, ty2,
					myMullionRight.centerXs, myMullionRight.centerYs,
					myMullionRight.centerXe, myMullionRight.centerYe);

			tx2 = newtx2;
			tx2A = newtx2A;
			tx2c = newtx2c;
			ty2 = newty2;
			ty2A = newty2A;
			ty2c = newty2c;

		}

		myInitOpening.noSidesTop = 1;

		if (myBOpening.noSidesTop == 2
				&& myMullionRight.x1 < myBOpening.myParent.top2.endX
				&& myMullionRight.x1 > myBOpening.myParent.top1.endX) {

			tx1 = myBOpening.top1.startX;
			ty1 = myBOpening.top1.startY;
			tx1A = myBOpening.top1.startXA;
			ty1A = myBOpening.top1.startYA;
			tx1c = myBOpening.myParent.top1.startX;
			ty1c = myBOpening.myParent.top1.startY;

			tx2 = myBOpening.top1.endX;
			ty2 = myBOpening.top1.endY;
			tx2A = myBOpening.top1.endXA;
			ty2A = myBOpening.top1.endYA;
			tx2c = myBOpening.myParent.top1.endX;
			ty2c = myBOpening.myParent.top1.endY;
			t1s = myBOpening.myParent.top1.partForm;

			t2x1 = myBOpening.top2.startX;
			t2y1 = myBOpening.top2.startY;
			t2x1A = myBOpening.top2.startXA;
			t2y1A = myBOpening.top2.startYA;
			t2x1c = myBOpening.myParent.top2.startX;
			t2y1c = myBOpening.myParent.top2.startY;
			t2x2 = myBOpening.top2.endX;
			t2y2 = myBOpening.top2.endY;
			t2x2A = myBOpening.top2.endXA;
			t2y2A = myBOpening.top2.endYA;
			t2x2c = myBOpening.myParent.top2.endX;
			t2y2c = myBOpening.myParent.top2.endY;
			t2s = myBOpening.myParent.top2.partForm;

			myInitOpening.noSidesTop = 2;

		} else if (myBOpening.noSidesTop == 3
				&& myMullionRight.x1 < myBOpening.myParent.top3.endX
				&& myMullionRight.x1 > myBOpening.myParent.top1.endX) {

			tx1 = myBOpening.top1.startX;
			ty1 = myBOpening.top1.startY;
			tx1A = myBOpening.top1.startXA;
			ty1A = myBOpening.top1.startYA;
			tx1c = myBOpening.myParent.top1.startX;
			ty1c = myBOpening.myParent.top1.startY;
			t1s = myBOpening.myParent.top1.partForm;

			tx2 = myBOpening.top1.endX;
			ty2 = myBOpening.top1.endY;
			tx2A = myBOpening.top1.endXA;
			ty2A = myBOpening.top1.endYA;
			tx2c = myBOpening.myParent.top1.endX;
			ty2c = myBOpening.myParent.top1.endY;
			t1s = myBOpening.myParent.top1.partForm;

			t2x1 = myBOpening.top3.startX;
			t2y1 = myBOpening.top3.startY;
			t2x1A = myBOpening.top3.startXA;
			t2y1A = myBOpening.top3.startYA;
			t2x1c = myBOpening.myParent.top3.startX;
			t2y1c = myBOpening.myParent.top3.startY;
			t2s = myBOpening.myParent.top3.partForm;

			t2x2 = myBOpening.top3.endX;
			t2y2 = myBOpening.top3.endY;
			t2x2A = myBOpening.top3.endXA;
			t2y2A = myBOpening.top3.endYA;
			t2x2c = myBOpening.myParent.top3.endX;
			t2y2c = myBOpening.myParent.top3.endY;

			myInitOpening.noSidesTop = 2;

		} else if (myBOpening.noSidesTop == 3
				&& myMullionRight.x1 < myBOpening.myParent.top2.endX
				&& myMullionRight.x1 > myBOpening.myParent.top3.endX) {

			tx1 = myBOpening.top1.startX;
			ty1 = myBOpening.top1.startY;
			tx1A = myBOpening.top1.startXA;
			ty1A = myBOpening.top1.startYA;
			tx1c = myBOpening.myParent.top1.startX;
			ty1c = myBOpening.myParent.top1.startY;
			t1s = myBOpening.myParent.top1.partForm;

			tx2 = myBOpening.top1.endX;
			ty2 = myBOpening.top1.endY;
			tx2A = myBOpening.top1.endXA;
			ty2A = myBOpening.top1.endYA;
			tx2c = myBOpening.myParent.top1.endX;
			ty2c = myBOpening.myParent.top1.endY;
			t1s = myBOpening.myParent.top1.partForm;

			t3x1 = myBOpening.top3.startX;
			t3y1 = myBOpening.top3.startY;
			t3x1A = myBOpening.top3.startXA;
			t3y1A = myBOpening.top3.startYA;
			t3x1c = myBOpening.myParent.top3.startX;
			t3y1c = myBOpening.myParent.top3.startY;
			t3x2 = myBOpening.top3.endX;
			t3y2 = myBOpening.top3.endY;
			t3x2A = myBOpening.top3.endXA;
			t3y2A = myBOpening.top3.endYA;
			t3x1c = myBOpening.myParent.top3.endX;
			t3y1c = myBOpening.myParent.top3.endY;
			t3s = myBOpening.myParent.top3.partForm;

			t2x1 = myBOpening.top2.startX;
			t2y1 = myBOpening.top2.startY;
			t2x1A = myBOpening.top2.startXA;
			t2y1A = myBOpening.top2.startYA;
			t2x1c = myBOpening.myParent.top2.startX;
			t2y1c = myBOpening.myParent.top2.startY;

			t2s = myBOpening.myParent.top2.partForm;

			t2x2 = myBOpening.top2.endX;
			t2y2 = myBOpening.top2.endY;
			t2x2A = myBOpening.top2.endXA;
			t2y2A = myBOpening.top2.endYA;
			t2x2c = myBOpening.myParent.top2.endX;
			t2y2c = myBOpening.myParent.top2.endY;

			myInitOpening.noSidesTop = 3;

		}
	}

	public void getT1xy(final Profiles profile, final Profiles profileC) {

		tx1 = profile.startX;
		ty1 = profile.startY;
		tx1A = profile.startXA;
		ty1A = profile.startYA;
		tx1c = profileC.startXC;
		ty1c = profileC.startYC;

		tx2 = profile.endX;
		ty2 = profile.endY;
		tx2A = profile.endXA;
		ty2A = profile.endYA;
		tx2c = profileC.endXC;
		ty2c = profileC.endYC;
		t1s = profile.partForm;

	}

	public void getT2xy(final Profiles profile, final Profiles profileC) {

		t2x1 = profile.startX;
		t2y1 = profile.startY;
		t2x1A = profile.startXA;
		t2y1A = profile.startYA;
		t2x1c = profileC.startXC;
		t2y1c = profileC.startYC;

		t2x2 = profile.endX;
		t2y2 = profile.endY;
		t2x2A = profile.endXA;
		t2y2A = profile.endYA;
		t2x2c = profileC.endXC;
		t2y2c = profileC.endYC;
		t2s = profile.partForm;
	}

	public void getT3xy(final Profiles profile, final Profiles profileC) {

		t3x1 = profile.startX;
		t3y1 = profile.startY;
		t3x1A = profile.startXA;
		t3y1A = profile.startYA;
		t3x1c = profileC.startXC;
		t3y1c = profileC.startYC;

		t3x2 = profile.endX;
		t3y2 = profile.endY;
		t3x2A = profile.endXA;
		t3y2A = profile.endYA;
		t3x2c = profileC.endXC;
		t3y2c = profileC.endYC;
		t3s = profile.partForm;
	}

	public OpeningObject getPxPYA(final double tx1, final double ty1,
			final double tx2, final double ty2, final double t2x1,
			final double t2y1, final double t2x2, final double t2y2,
			final double t3x1, final double t3y1, final double t3x2,
			final double t3y2, final double bx1, final double by1,
			final double bx2, final double by2, final double b2x1,
			final double b2y1, final double b2x2, final double b2y2,
			final double b3x1, final double b3y1, final double b3x2,
			final double b3y2, final double lx1, final double ly1,
			final double lx2, final double ly2, final double rx1,
			final double ry1, final double rx2, final double ry2,
			final OpeningObject myInitOpening) {

		if (myInitOpening.noSidesLeft == 0) {
			if (myInitOpening.noSidesBot == 1) {
				myInitOpening.px1A = this.intersectX(tx1, //
						ty1, //
						tx2, //
						ty2, //
						bx1, //
						by1, //
						bx2, //
						by2); //
				myInitOpening.py1A = this.intersectY(tx1, //
						ty1, //
						tx2, //
						ty2, //
						bx1, //
						by1, //
						bx2, //
						by2); //
				if (myInitOpening.px1A == 0) {
					myInitOpening.px1A = bx2;
					myInitOpening.py1A = by2;
				}

			} else if (myInitOpening.noSidesBot > 1) {
				myInitOpening.px1A = this.intersectX(tx1, //
						ty1, //
						tx2, //
						ty2, //
						b2x1, //
						b2y1, //
						b2x2, //
						b2y2); //
				myInitOpening.py1A = this.intersectX(tx1, //
						ty1, //
						tx2, //
						ty2, //
						b2x1, //
						b2y1, //
						b2x2, //
						b2y2); //
				if (myInitOpening.px1A == 0) {
					myInitOpening.px1A = b2x2;
					myInitOpening.py1A = b2y2;
				}

			}
		} else if (myInitOpening.noSidesLeft == 1) {
			myInitOpening.px1A = this.intersectX(tx1, //
					ty1, //
					tx2, //
					ty2, //
					lx1, //
					ly1, //
					lx2, //
					ly2); //
			myInitOpening.py1A = this.intersectY(tx1, //
					ty1, //
					tx2, //
					ty2, //
					lx1, //
					ly1, //
					lx2, //
					ly2); //

		}

		// / End general Px1 Py1 Start

		switch (myInitOpening.noSidesTop) {
		case 1: // top 1
			switch (myInitOpening.noSidesRight) {

			case 1: // R1
				myInitOpening.px2A = this.intersectX(tx1, //
						ty1, //
						tx2, //
						ty2, //
						rx1, //
						ry1, //
						rx2, //
						ry2); //
				myInitOpening.py2A = this.intersectY(tx1, //
						ty1, //
						tx2, //
						ty2, //
						rx1, //
						ry1, //
						rx2, //
						ry2); //

				switch (myInitOpening.noSidesBot) {

				case 1: // bot
					// 1
					myInitOpening.px3A = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py3A = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px4A = this.intersectX(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py4A = this.intersectY(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px4A = myInitOpening.px1A; //
						myInitOpening.py4A = myInitOpening.py1A; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot1

				case 2: // bot
					// 2
					myInitOpening.px3A = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py3A = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px4A = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					myInitOpening.py4A = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					switch (myInitOpening.noSidesLeft) {
					case 1: // left
						// 1
						myInitOpening.px5A = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py5A = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px5A = myInitOpening.px1A;
						myInitOpening.py5A = myInitOpening.py1A; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 2

				case 3: // bot
					// 3
					myInitOpening.px3A = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					myInitOpening.py3A = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					myInitOpening.px4A = this.intersectX(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.py4A = this.intersectY(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px5A = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					myInitOpening.py5A = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px6A = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py6A = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px6A = myInitOpening.px1A; //
						myInitOpening.py6A = myInitOpening.py1A; //
						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 3

				} // Case Bot

				break;// R1

			case 0: // R0

				switch (myInitOpening.noSidesBot) {

				case 1: // bot
					// 1
					myInitOpening.px2A = this.intersectX(tx1, //
							ty1, //
							tx2, //
							ty2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py2A = this.intersectY(tx1, //
							ty1, //
							tx2, //
							ty2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					if (myInitOpening.px2A == 0) {
						myInitOpening.px2A = bx1;
						myInitOpening.py2A = by1;
					}
					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px3A = this.intersectX(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py3A = this.intersectY(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px3A = myInitOpening.px1A; //
						myInitOpening.py3A = myInitOpening.py1A; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot1

				case 2: // bot
					// 2
					myInitOpening.px2A = this.intersectX(tx1, //
							ty1, //
							tx2, //
							ty2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py2A = this.intersectY(tx1, //
							ty1, //
							tx2, //
							ty2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					if (myInitOpening.px2 == 0) {
						myInitOpening.px2 = bx1;
						myInitOpening.py2 = by1;
					}
					myInitOpening.px3A = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					myInitOpening.py3A = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					switch (myInitOpening.noSidesLeft) {
					case 1: // left
						// 1
						myInitOpening.px4A = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py4A = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px4A = myInitOpening.px1A;
						myInitOpening.py4A = myInitOpening.py1A; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 2

				case 3: // bot
					// 3
					myInitOpening.px2A = this.intersectX(tx1, //
							ty1, //
							tx2, //
							ty2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					myInitOpening.py2A = this.intersectY(tx1, //
							ty1, //
							tx2, //
							ty2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //
					if (myInitOpening.px2 == 0) {
						myInitOpening.px2 = b3x1;
						myInitOpening.py2 = b3y1;
					}

					myInitOpening.px3A = this.intersectX(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.py3A = this.intersectY(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px4A = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					myInitOpening.py4A = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px5A = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py5A = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px5A = myInitOpening.px1A; //
						myInitOpening.py5A = myInitOpening.py1A; //
						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 3

				} // Case Bot

				break;// R0

			}// Case Right

			break; // Top 1
		// ////////////////////////////////////////////////////
		case 2: // Top 2

			myInitOpening.px2A = this.intersectX(tx1, //
					ty1, //
					tx2, //
					ty2, //
					t2x1, //
					t2y1, //
					t2x2, //
					t2y2); //
			myInitOpening.py2A = this.intersectY(tx1, //
					ty1, //
					tx2, //
					ty2, //
					t2x1, //
					t2y1, //
					t2x2, //
					t2y2); //
			if (myInitOpening.px2A == 0) {
				myInitOpening.px2A = t2x1;
				myInitOpening.py2A = t2y1;
			}

			switch (myInitOpening.noSidesRight) {

			case 1: // R1
				myInitOpening.px3A = this.intersectX(t2x1, //
						t2y1, //
						t2x2, //
						t2y2, //
						rx1, //
						ry1, //
						rx2, //
						ry2); //
				myInitOpening.py3A = this.intersectY(t2x1, //
						t2y1, //
						t2x2, //
						t2y2, //
						rx1, //
						ry1, //
						rx2, //
						ry2); //

				switch (myInitOpening.noSidesBot) {

				case 1: // bot
					// 1
					myInitOpening.px4A = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py4A = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px5A = this.intersectX(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py5A = this.intersectY(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px5A = myInitOpening.px1A; //
						myInitOpening.py5A = myInitOpening.py1A; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot1

				case 2: // bot
					// 2
					myInitOpening.px4A = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py4A = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px5A = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					myInitOpening.py5A = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					switch (myInitOpening.noSidesLeft) {
					case 1: // left
						// 1
						myInitOpening.px6A = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py6A = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px6A = myInitOpening.px1A;
						myInitOpening.py6A = myInitOpening.py1A; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 2

				case 3: // bot
					// 3
					myInitOpening.px4A = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					myInitOpening.py4A = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					myInitOpening.px5A = this.intersectX(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.py5A = this.intersectY(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px6A = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					myInitOpening.py6A = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px7A = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py7A = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px7A = myInitOpening.px1A; //
						myInitOpening.py7A = myInitOpening.py1A; //
						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 3

				} // Case Bot

				break;// R1

			case 0: // R0

				switch (myInitOpening.noSidesBot) {

				case 1: // bot
					// 1
					myInitOpening.px3A = this.intersectX(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py3A = this.intersectY(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					if (myInitOpening.px3A == 0) {
						myInitOpening.px3A = bx1;
						myInitOpening.py3A = by1;
					}

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px4A = this.intersectX(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py4A = this.intersectY(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px4A = myInitOpening.px1A; //
						myInitOpening.py4A = myInitOpening.py1A; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot1

				case 2: // bot
					// 2
					myInitOpening.px3A = this.intersectX(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py3A = this.intersectY(tx1, //
							ty1, //
							tx2, //
							ty2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					if (myInitOpening.px3A == 0) {
						myInitOpening.px3A = bx1;
						myInitOpening.py3A = by1;
					}
					myInitOpening.px4A = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					myInitOpening.py4A = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					switch (myInitOpening.noSidesLeft) {
					case 1: // left
						// 1
						myInitOpening.px5A = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py5A = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px5A = myInitOpening.px1A;
						myInitOpening.py5A = myInitOpening.py1A; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 2

				case 3: // bot
					// 3
					myInitOpening.px3A = this.intersectX(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					myInitOpening.py3A = this.intersectY(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					if (myInitOpening.px3A == 0) {
						myInitOpening.px3A = b3x1;
						myInitOpening.py3A = b3y1;
					}

					myInitOpening.px4A = this.intersectX(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.py4A = this.intersectY(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px5A = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					myInitOpening.py5A = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px6A = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py6A = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px6A = myInitOpening.px1A; //
						myInitOpening.py6A = myInitOpening.py1A; //
						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 3

				} // Case Bot

				break;// R0

			}// Case Right

			break; // Top 2
		// /////////////////////////////////////////////////////////////////
		case 3: // Top 3

			myInitOpening.px2A = this.intersectX(tx1, //
					ty1, //
					tx2, //
					ty2, //
					t3x1, //
					t3y1, //
					t3x2, //
					t3y2); //
			myInitOpening.py2A = this.intersectY(tx1, //
					ty1, //
					tx2, //
					ty2, //
					t3x1, //
					t3y1, //
					t3x2, //
					t3y2); //

			if (myInitOpening.px2A == 0) {
				myInitOpening.px2A = t3x1;
				myInitOpening.py2A = t3y1;
			}

			myInitOpening.px3A = this.intersectX(t3x1, //
					t3y1, //
					t3x2, //
					t3y2, //
					t2x1, //
					t2y1, //
					t2x2, //
					t2y2); //
			myInitOpening.py3A = this.intersectY(t3x1, //
					t3y1, //
					t3x2, //
					t3y2, //
					t2x1, //
					t2y1, //
					t2x2, //
					t2y2); //

			if (myInitOpening.px3A == 0) {
				myInitOpening.px3A = t3x2;
				myInitOpening.py3A = t3y2;
			}

			switch (myInitOpening.noSidesRight) {

			case 1: // R1

				myInitOpening.px4A = this.intersectX(t2x1, //
						t2y1, //
						t2x2, //
						t2y2, //
						rx1, //
						ry1, //
						rx2, //
						ry2); //
				myInitOpening.py4A = this.intersectY(t2x1, //
						t2y1, //
						t2x2, //
						t2y2, //
						rx1, //
						ry1, //
						rx2, //
						ry2); //

				switch (myInitOpening.noSidesBot) {

				case 1: // bot
					// 1
					myInitOpening.px5A = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py5A = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px6A = this.intersectX(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py6A = this.intersectY(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px6A = myInitOpening.px1A; //
						myInitOpening.py6A = myInitOpening.py1A; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot1

				case 2: // bot
					// 2
					myInitOpening.px5A = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py5A = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px6A = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					myInitOpening.py6A = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					switch (myInitOpening.noSidesLeft) {
					case 1: // left
						// 1
						myInitOpening.px7A = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py7A = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px7A = myInitOpening.px1A;
						myInitOpening.py7A = myInitOpening.py1A; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 2

				case 3: // bot
					// 3
					myInitOpening.px5A = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					myInitOpening.py5A = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					myInitOpening.px6A = this.intersectX(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.py6A = this.intersectY(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px7A = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					myInitOpening.py7A = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px8A = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py8A = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px8A = myInitOpening.px1A; //
						myInitOpening.py8A = myInitOpening.py1A; //
						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 3

				} // Case Bot

				break;// R1

			case 0: // R0

				switch (myInitOpening.noSidesBot) {

				case 1: // bot
					// 1
					myInitOpening.px4A = this.intersectX(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py4A = this.intersectY(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					if (myInitOpening.px4A == 0) {
						myInitOpening.px4A = bx1;
						myInitOpening.py4A = by1;
					}

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px5A = this.intersectX(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py5A = this.intersectY(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px5A = myInitOpening.px1A; //
						myInitOpening.py5A = myInitOpening.py1A; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot1

				case 2: // bot
					// 2
					myInitOpening.px4A = this.intersectX(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py4A = this.intersectY(tx1, //
							ty1, //
							tx2, //
							ty2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					if (myInitOpening.px4A == 0) {
						myInitOpening.px4A = bx1;
						myInitOpening.py4A = by1;
					}

					myInitOpening.px5A = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					myInitOpening.py5A = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					switch (myInitOpening.noSidesLeft) {
					case 1: // left
						// 1
						myInitOpening.px6A = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py6A = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px6A = myInitOpening.px1A;
						myInitOpening.py6A = myInitOpening.py1A; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 2

				case 3: // bot
					// 3
					myInitOpening.px4A = this.intersectX(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					myInitOpening.py4A = this.intersectY(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //
					if (myInitOpening.px4A == 0) {
						myInitOpening.px4A = b3x1;
						myInitOpening.py4A = b3y1;
					}

					myInitOpening.px5A = this.intersectX(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.py5A = this.intersectY(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px6A = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					myInitOpening.py6A = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px6A = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py6A = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px6A = myInitOpening.px1A; //
						myInitOpening.py6A = myInitOpening.py1A; //
						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 3

				} // Case Bot

				break;// R0

			}// Case Right

			break; // Top 3

		}
		return myInitOpening;
	}

	public OpeningObject getPxPY(final double tx1, final double ty1,
			final double tx2, final double ty2, final double t2x1,
			final double t2y1, final double t2x2, final double t2y2,
			final double t3x1, final double t3y1, final double t3x2,
			final double t3y2, final double bx1, final double by1,
			final double bx2, final double by2, final double b2x1,
			final double b2y1, final double b2x2, final double b2y2,
			final double b3x1, final double b3y1, final double b3x2,
			final double b3y2, final double lx1, final double ly1,
			final double lx2, final double ly2, final double rx1,
			final double ry1, final double rx2, final double ry2,
			final OpeningObject myInitOpening) {

		if (myInitOpening.noSidesLeft == 0) {
			if (myInitOpening.noSidesBot == 1) {
				myInitOpening.px1 = this.intersectX(tx2, //
						ty2, //
						tx1, //
						ty1, //
						bx2, //
						by2, //
						bx1, //
						by1); //
				myInitOpening.py1 = this.intersectY(tx1, //
						ty1, //
						tx2, //
						ty2, //
						bx1, //
						by1, //
						bx2, //
						by2); //
				if (myInitOpening.px1 == 0) {
					myInitOpening.px1 = bx2;
					myInitOpening.py1 = by2;
				}

			} else if (myInitOpening.noSidesBot > 1) {
				myInitOpening.px1 = this.intersectX(tx1, //
						ty1, //
						tx2, //
						ty2, //
						b2x1, //
						b2y1, //
						b2x2, //
						b2y2); //
				myInitOpening.py1 = this.intersectX(tx1, //
						ty1, //
						tx2, //
						ty2, //
						b2x1, //
						b2y1, //
						b2x2, //
						b2y2); //
				if (myInitOpening.px1 == 0) {
					myInitOpening.px1 = b2x2;
					myInitOpening.py1 = b2y2;
				}

			}
		} else if (myInitOpening.noSidesLeft == 1) {
			myInitOpening.px1 = this.intersectX(tx1, //
					ty1, //
					tx2, //
					ty2, //
					lx1, //
					ly1, //
					lx2, //
					ly2); //
			myInitOpening.py1 = this.intersectY(tx1, //
					ty1, //
					tx2, //
					ty2, //
					lx1, //
					ly1, //
					lx2, //
					ly2); //

		}

		// / End general Px1 Py1 Start

		switch (myInitOpening.noSidesTop) {
		case 1: // top 1
			switch (myInitOpening.noSidesRight) {

			case 1: // R1
				myInitOpening.px2 = this.intersectX(tx1, //
						ty1, //
						tx2, //
						ty2, //
						rx1, //
						ry1, //
						rx2, //
						ry2); //
				myInitOpening.py2 = this.intersectY(tx1, //
						ty1, //
						tx2, //
						ty2, //
						rx1, //
						ry1, //
						rx2, //
						ry2); //

				switch (myInitOpening.noSidesBot) {

				case 1: // bot
					// 1
					myInitOpening.px3 = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py3 = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px4 = this.intersectX(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py4 = this.intersectY(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px4 = myInitOpening.px1; //
						myInitOpening.py4 = myInitOpening.py1; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot1

				case 2: // bot
					// 2
					myInitOpening.px3 = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py3 = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px4 = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					myInitOpening.py4 = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					switch (myInitOpening.noSidesLeft) {
					case 1: // left
						// 1
						myInitOpening.px5 = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py5 = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px5 = myInitOpening.px1;
						myInitOpening.py5 = myInitOpening.py1; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 2

				case 3: // bot
					// 3
					myInitOpening.px3 = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.py3 = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px4 = this.intersectX(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.py4 = this.intersectY(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px5 = this.intersectX(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					myInitOpening.py5 = this.intersectY(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px6 = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py6 = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px6 = myInitOpening.px1; //
						myInitOpening.py6 = myInitOpening.py1; //
						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 3

				} // Case Bot

				break;// R1

			case 0: // R0

				switch (myInitOpening.noSidesBot) {

				case 1: // bot
					// 1
					myInitOpening.px2 = this.intersectX(tx1, //
							ty1, //
							tx2, //
							ty2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py2 = this.intersectY(tx1, //
							ty1, //
							tx2, //
							ty2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					if (myInitOpening.px2 == 0) {
						myInitOpening.px2 = bx1;
						myInitOpening.py2 = by1;
					}
					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px3 = this.intersectX(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py3 = this.intersectY(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px3 = myInitOpening.px1; //
						myInitOpening.py3 = myInitOpening.py1; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot1

				case 2: // bot
					// 2
					myInitOpening.px2 = this.intersectX(tx1, //
							ty1, //
							tx2, //
							ty2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py2 = this.intersectY(tx1, //
							ty1, //
							tx2, //
							ty2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					if (myInitOpening.px2 == 0) {
						myInitOpening.px2 = bx1;
						myInitOpening.py2 = by1;
					}
					myInitOpening.px3 = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					myInitOpening.py3 = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					switch (myInitOpening.noSidesLeft) {
					case 1: // left
						// 1
						myInitOpening.px4 = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py4 = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px4 = myInitOpening.px1;
						myInitOpening.py4 = myInitOpening.py1; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 2

				case 3: // bot
					// 3
					myInitOpening.px2 = this.intersectX(tx1, //
							ty1, //
							tx2, //
							ty2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					myInitOpening.py2 = this.intersectY(tx1, //
							ty1, //
							tx2, //
							ty2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //
					if (myInitOpening.px2 == 0) {
						myInitOpening.px2 = b3x1;
						myInitOpening.py2 = b3y1;
					}

					myInitOpening.px3 = this.intersectX(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.py3 = this.intersectY(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px4 = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					myInitOpening.py4 = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px5 = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py5 = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px5 = myInitOpening.px1; //
						myInitOpening.py5 = myInitOpening.py1; //
						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 3

				} // Case Bot

				break;// R0

			}// Case Right

			break; // Top 1
		// ////////////////////////////////////////////////////
		case 2: // Top 2

			myInitOpening.px2 = this.intersectX(tx1, //
					ty1, //
					tx2, //
					ty2, //
					t2x1, //
					t2y1, //
					t2x2, //
					t2y2); //
			myInitOpening.py2 = this.intersectY(tx1, //
					ty1, //
					tx2, //
					ty2, //
					t2x1, //
					t2y1, //
					t2x2, //
					t2y2); //
			if (myInitOpening.px2 == 0) {
				myInitOpening.px2 = t2x1;
				myInitOpening.py2 = t2y1;
			}

			switch (myInitOpening.noSidesRight) {

			case 1: // R1
				myInitOpening.px3 = this.intersectX(t2x1, //
						t2y1, //
						t2x2, //
						t2y2, //
						rx1, //
						ry1, //
						rx2, //
						ry2); //
				myInitOpening.py3 = this.intersectY(t2x1, //
						t2y1, //
						t2x2, //
						t2y2, //
						rx1, //
						ry1, //
						rx2, //
						ry2); //

				switch (myInitOpening.noSidesBot) {

				case 1: // bot
					// 1
					myInitOpening.px4 = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py4 = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px5 = this.intersectX(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py5 = this.intersectY(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px5 = myInitOpening.px1; //
						myInitOpening.py5 = myInitOpening.py1; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot1

				case 2: // bot
					// 2
					myInitOpening.px4 = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py4 = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px5 = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					myInitOpening.py5 = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					switch (myInitOpening.noSidesLeft) {
					case 1: // left
						// 1
						myInitOpening.px6 = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py6 = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px6 = myInitOpening.px1;
						myInitOpening.py6 = myInitOpening.py1; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 2

				case 3: // bot
					// 3
					myInitOpening.px4 = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					myInitOpening.py4 = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					myInitOpening.px5 = this.intersectX(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.py5 = this.intersectY(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px6 = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					myInitOpening.py6 = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px7 = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py7 = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px7 = myInitOpening.px1; //
						myInitOpening.py7 = myInitOpening.py1; //
						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 3

				} // Case Bot

				break;// R1

			case 0: // R0

				switch (myInitOpening.noSidesBot) {

				case 1: // bot
					// 1
					myInitOpening.px3 = this.intersectX(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py3 = this.intersectY(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					if (myInitOpening.px3 == 0) {
						myInitOpening.px3 = bx1;
						myInitOpening.py3 = by1;
					}

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px4 = this.intersectX(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py4 = this.intersectY(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px4 = myInitOpening.px1; //
						myInitOpening.py4 = myInitOpening.py1; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot1

				case 2: // bot
					// 2
					myInitOpening.px3 = this.intersectX(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py3 = this.intersectY(tx1, //
							ty1, //
							tx2, //
							ty2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					if (myInitOpening.px3 == 0) {
						myInitOpening.px3 = bx1;
						myInitOpening.py3 = by1;
					}
					myInitOpening.px4 = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					myInitOpening.py4 = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					switch (myInitOpening.noSidesLeft) {
					case 1: // left
						// 1
						myInitOpening.px5 = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py5 = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px5 = myInitOpening.px1;
						myInitOpening.py5 = myInitOpening.py1; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 2

				case 3: // bot
					// 3
					myInitOpening.px3 = this.intersectX(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					myInitOpening.py3 = this.intersectY(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					if (myInitOpening.px3 == 0) {
						myInitOpening.px3 = b3x1;
						myInitOpening.py3 = b3y1;
					}

					myInitOpening.px4 = this.intersectX(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.py4 = this.intersectY(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px5 = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					myInitOpening.py5 = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px6 = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py6 = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px6 = myInitOpening.px1; //
						myInitOpening.py6 = myInitOpening.py1; //
						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 3

				} // Case Bot

				break;// R0

			}// Case Right

			break; // Top 2
		// /////////////////////////////////////////////////////////////////
		case 3: // Top 3

			myInitOpening.px2 = this.intersectX(tx1, //
					ty1, //
					tx2, //
					ty2, //
					t3x1, //
					t3y1, //
					t3x2, //
					t3y2); //
			myInitOpening.py2 = this.intersectY(tx1, //
					ty1, //
					tx2, //
					ty2, //
					t3x1, //
					t3y1, //
					t3x2, //
					t3y2); //

			if (myInitOpening.px2 == 0) {
				myInitOpening.px2 = t3x1;
				myInitOpening.py2 = t3y1;
			}

			myInitOpening.px3 = this.intersectX(t3x1, //
					t3y1, //
					t3x2, //
					t3y2, //
					t2x1, //
					t2y1, //
					t2x2, //
					t2y2); //
			myInitOpening.py3 = this.intersectY(t3x1, //
					t3y1, //
					t3x2, //
					t3y2, //
					t2x1, //
					t2y1, //
					t2x2, //
					t2y2); //

			if (myInitOpening.px3 == 0) {
				myInitOpening.px3 = t3x2;
				myInitOpening.py3 = t3y2;
			}

			switch (myInitOpening.noSidesRight) {

			case 1: // R1

				myInitOpening.px4 = this.intersectX(t2x1, //
						t2y1, //
						t2x2, //
						t2y2, //
						rx1, //
						ry1, //
						rx2, //
						ry2); //
				myInitOpening.py4 = this.intersectY(t2x1, //
						t2y1, //
						t2x2, //
						t2y2, //
						rx1, //
						ry1, //
						rx2, //
						ry2); //

				switch (myInitOpening.noSidesBot) {

				case 1: // bot
					// 1
					myInitOpening.px5 = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py5 = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px6 = this.intersectX(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py6 = this.intersectY(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px6 = myInitOpening.px1; //
						myInitOpening.py6 = myInitOpening.py1; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot1

				case 2: // bot
					// 2
					myInitOpening.px5 = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py5 = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px6 = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					myInitOpening.py6 = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					switch (myInitOpening.noSidesLeft) {
					case 1: // left
						// 1
						myInitOpening.px7 = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py7 = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px7 = myInitOpening.px1;
						myInitOpening.py7 = myInitOpening.py1; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 2

				case 3: // bot
					// 3
					myInitOpening.px5 = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.py5 = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px6 = this.intersectX(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.py6 = this.intersectY(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px7 = this.intersectX(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					myInitOpening.py7 = this.intersectY(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px8 = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py8 = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px8 = myInitOpening.px1; //
						myInitOpening.py8 = myInitOpening.py1; //
						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 3

				} // Case Bot

				break;// R1

			case 0: // R0

				switch (myInitOpening.noSidesBot) {

				case 1: // bot
					// 1
					myInitOpening.px4 = this.intersectX(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py4 = this.intersectY(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					if (myInitOpening.px4 == 0) {
						myInitOpening.px4 = bx1;
						myInitOpening.py4 = by1;
					}

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px5 = this.intersectX(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py5 = this.intersectY(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px5 = myInitOpening.px1; //
						myInitOpening.py5 = myInitOpening.py1; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot1

				case 2: // bot
					// 2
					myInitOpening.px4 = this.intersectX(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py4 = this.intersectY(tx1, //
							ty1, //
							tx2, //
							ty2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					if (myInitOpening.px4 == 0) {
						myInitOpening.px4 = bx1;
						myInitOpening.py4 = by1;
					}

					myInitOpening.px5 = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					myInitOpening.py5 = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					switch (myInitOpening.noSidesLeft) {
					case 1: // left
						// 1
						myInitOpening.px6 = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py6 = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px6 = myInitOpening.px1;
						myInitOpening.py6 = myInitOpening.py1; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 2

				case 3: // bot
					// 3
					myInitOpening.px4 = this.intersectX(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					myInitOpening.py4 = this.intersectY(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //
					if (myInitOpening.px4 == 0) {
						myInitOpening.px4 = b3x1;
						myInitOpening.py4 = b3y1;
					}

					myInitOpening.px5 = this.intersectX(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.py5 = this.intersectY(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px6 = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					myInitOpening.py6 = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px6 = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py6 = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px6 = myInitOpening.px1; //
						myInitOpening.py6 = myInitOpening.py1; //
						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 3

				} // Case Bot

				break;// R0

			}// Case Right

			break; // Top 3

		}
		return myInitOpening;
	}

	public OpeningObject getPxPYCenters(final double tx1, final double ty1,
			final double tx2, final double ty2, final double t2x1,
			final double t2y1, final double t2x2, final double t2y2,
			final double t3x1, final double t3y1, final double t3x2,
			final double t3y2, final double bx1, final double by1,
			final double bx2, final double by2, final double b2x1,
			final double b2y1, final double b2x2, final double b2y2,
			final double b3x1, final double b3y1, final double b3x2,
			final double b3y2, final double lx1, final double ly1,
			final double lx2, final double ly2, final double rx1,
			final double ry1, final double rx2, final double ry2,
			final OpeningObject myInitOpening) {

		if (myInitOpening.noSidesLeft == 0) {
			if (myInitOpening.noSidesBot == 1) {
				myInitOpening.px1c = this.intersectX(tx1, //
						ty1, //
						tx2, //
						ty2, //
						bx1, //
						by1, //
						bx2, //
						by2); //
				myInitOpening.py1c = this.intersectY(tx1, //
						ty1, //
						tx2, //
						ty2, //
						bx1, //
						by1, //
						bx2, //
						by2); //
				if (myInitOpening.px1c == 0) {
					myInitOpening.px1c = bx2;
					myInitOpening.py1c = by2;
				}

			} else if (myInitOpening.noSidesBot > 1) {
				myInitOpening.px1c = this.intersectX(tx1, //
						ty1, //
						tx2, //
						ty2, //
						b2x1, //
						b2y1, //
						b2x2, //
						b2y2); //
				myInitOpening.py1c = this.intersectX(tx1, //
						ty1, //
						tx2, //
						ty2, //
						b2x1, //
						b2y1, //
						b2x2, //
						b2y2); //
				if (myInitOpening.px1c == 0) {
					myInitOpening.px1c = b2x2;
					myInitOpening.py1c = b2y2;
				}

			}
		} else if (myInitOpening.noSidesLeft == 1) {
			myInitOpening.px1c = this.intersectX(tx1, //
					ty1, //
					tx2, //
					ty2, //
					lx1, //
					ly1, //
					lx2, //
					ly2); //
			myInitOpening.py1c = this.intersectY(tx1, //
					ty1, //
					tx2, //
					ty2, //
					lx1, //
					ly1, //
					lx2, //
					ly2); //

		}

		// / End general Px1 Py1 Start

		switch (myInitOpening.noSidesTop) {
		case 1: // top 1
			switch (myInitOpening.noSidesRight) {

			case 1: // R1
				myInitOpening.px2c = this.intersectX(tx1, //
						ty1, //
						tx2, //
						ty2, //
						rx1, //
						ry1, //
						rx2, //
						ry2); //
				myInitOpening.py2c = this.intersectY(tx1, //
						ty1, //
						tx2, //
						ty2, //
						rx1, //
						ry1, //
						rx2, //
						ry2); //

				switch (myInitOpening.noSidesBot) {

				case 1: // bot
					// 1
					myInitOpening.px3c = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py3c = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px4c = this.intersectX(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py4c = this.intersectY(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px4c = myInitOpening.px1c; //
						myInitOpening.py4c = myInitOpening.py1c; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot1

				case 2: // bot
					// 2
					myInitOpening.px3c = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py3c = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px4c = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					myInitOpening.py4c = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					switch (myInitOpening.noSidesLeft) {
					case 1: // left
						// 1
						myInitOpening.px5c = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py5c = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px5c = myInitOpening.px1c;
						myInitOpening.py5c = myInitOpening.py1c; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 2

				case 3: // bot
					// 3
					myInitOpening.px3c = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					myInitOpening.py3c = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					myInitOpening.px4c = this.intersectX(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.py4c = this.intersectY(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px5c = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					myInitOpening.py5c = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px6c = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py6c = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px6c = myInitOpening.px1c; //
						myInitOpening.py6c = myInitOpening.py1c; //
						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 3

				} // Case Bot

				break;// R1

			case 0: // R0

				switch (myInitOpening.noSidesBot) {

				case 1: // bot
					// 1
					myInitOpening.px2c = this.intersectX(tx1, //
							ty1, //
							tx2, //
							ty2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py2c = this.intersectY(tx1, //
							ty1, //
							tx2, //
							ty2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					if (myInitOpening.px2c == 0) {
						myInitOpening.px2c = bx1;
						myInitOpening.py2c = by1;
					}
					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px3c = this.intersectX(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py3c = this.intersectY(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px3c = myInitOpening.px1c; //
						myInitOpening.py3c = myInitOpening.py1c; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot1

				case 2: // bot
					// 2
					myInitOpening.px2c = this.intersectX(tx1, //
							ty1, //
							tx2, //
							ty2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py2c = this.intersectY(tx1, //
							ty1, //
							tx2, //
							ty2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					if (myInitOpening.px2 == 0) {
						myInitOpening.px2 = bx1;
						myInitOpening.py2 = by1;
					}
					myInitOpening.px3c = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					myInitOpening.py3c = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					switch (myInitOpening.noSidesLeft) {
					case 1: // left
						// 1
						myInitOpening.px4c = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py4c = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px4c = myInitOpening.px1c;
						myInitOpening.py4c = myInitOpening.py1c; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 2

				case 3: // bot
					// 3
					myInitOpening.px2c = this.intersectX(tx1, //
							ty1, //
							tx2, //
							ty2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					myInitOpening.py2c = this.intersectY(tx1, //
							ty1, //
							tx2, //
							ty2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //
					if (myInitOpening.px2 == 0) {
						myInitOpening.px2 = b3x1;
						myInitOpening.py2 = b3y1;
					}

					myInitOpening.px3c = this.intersectX(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.py3c = this.intersectY(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px4c = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					myInitOpening.py4c = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px5c = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py5c = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px5c = myInitOpening.px1c; //
						myInitOpening.py5c = myInitOpening.py1c; //
						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 3

				} // Case Bot

				break;// R0

			}// Case Right

			break; // Top 1
		// ////////////////////////////////////////////////////
		case 2: // Top 2

			myInitOpening.px2c = this.intersectX(tx1, //
					ty1, //
					tx2, //
					ty2, //
					t2x1, //
					t2y1, //
					t2x2, //
					t2y2); //
			myInitOpening.py2c = this.intersectY(tx1, //
					ty1, //
					tx2, //
					ty2, //
					t2x1, //
					t2y1, //
					t2x2, //
					t2y2); //
			if (myInitOpening.px2c == 0) {
				myInitOpening.px2c = t2x1;
				myInitOpening.py2c = t2y1;
			}

			switch (myInitOpening.noSidesRight) {

			case 1: // R1
				myInitOpening.px3c = this.intersectX(t2x1, //
						t2y1, //
						t2x2, //
						t2y2, //
						rx1, //
						ry1, //
						rx2, //
						ry2); //
				myInitOpening.py3c = this.intersectY(t2x1, //
						t2y1, //
						t2x2, //
						t2y2, //
						rx1, //
						ry1, //
						rx2, //
						ry2); //

				switch (myInitOpening.noSidesBot) {

				case 1: // bot
					// 1
					myInitOpening.px4c = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py4c = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px5c = this.intersectX(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py5c = this.intersectY(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px5c = myInitOpening.px1; //
						myInitOpening.py5c = myInitOpening.py1; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot1

				case 2: // bot
					// 2
					myInitOpening.px4c = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py4c = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px5c = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					myInitOpening.py5c = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					switch (myInitOpening.noSidesLeft) {
					case 1: // left
						// 1
						myInitOpening.px6c = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py6c = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px6c = myInitOpening.px1c;
						myInitOpening.py6c = myInitOpening.py1c; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 2

				case 3: // bot
					// 3
					myInitOpening.px4c = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					myInitOpening.py4c = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					myInitOpening.px5c = this.intersectX(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.py5c = this.intersectY(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px6c = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					myInitOpening.py6c = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px7c = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py7c = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px7c = myInitOpening.px1c; //
						myInitOpening.py7c = myInitOpening.py1c; //
						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 3

				} // Case Bot

				break;// R1

			case 0: // R0

				switch (myInitOpening.noSidesBot) {

				case 1: // bot
					// 1
					myInitOpening.px3c = this.intersectX(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py3c = this.intersectY(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					if (myInitOpening.px3c == 0) {
						myInitOpening.px3c = bx1;
						myInitOpening.py3c = by1;
					}

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px4c = this.intersectX(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py4c = this.intersectY(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px4c = myInitOpening.px1c; //
						myInitOpening.py4c = myInitOpening.py1c; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot1

				case 2: // bot
					// 2
					myInitOpening.px3c = this.intersectX(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py3c = this.intersectY(tx1, //
							ty1, //
							tx2, //
							ty2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					if (myInitOpening.px3c == 0) {
						myInitOpening.px3c = bx1;
						myInitOpening.py3c = by1;
					}
					myInitOpening.px4c = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					myInitOpening.py4c = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					switch (myInitOpening.noSidesLeft) {
					case 1: // left
						// 1
						myInitOpening.px5c = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py5c = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px5c = myInitOpening.px1c;
						myInitOpening.py5c = myInitOpening.py1c; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 2

				case 3: // bot
					// 3
					myInitOpening.px3c = this.intersectX(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					myInitOpening.py3c = this.intersectY(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					if (myInitOpening.px3c == 0) {
						myInitOpening.px3c = b3x1;
						myInitOpening.py3c = b3y1;
					}

					myInitOpening.px4c = this.intersectX(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.py4c = this.intersectY(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px5c = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					myInitOpening.py5c = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px6c = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py6c = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px6c = myInitOpening.px1c; //
						myInitOpening.py6c = myInitOpening.py1c; //
						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 3

				} // Case Bot

				break;// R0

			}// Case Right

			break; // Top 2
		// /////////////////////////////////////////////////////////////////
		case 3: // Top 3

			myInitOpening.px2c = this.intersectX(tx1, //
					ty1, //
					tx2, //
					ty2, //
					t3x1, //
					t3y1, //
					t3x2, //
					t3y2); //
			myInitOpening.py2c = this.intersectY(tx1, //
					ty1, //
					tx2, //
					ty2, //
					t3x1, //
					t3y1, //
					t3x2, //
					t3y2); //

			if (myInitOpening.px2c == 0) {
				myInitOpening.px2c = t3x1;
				myInitOpening.py2c = t3y1;
			}

			myInitOpening.px3c = this.intersectX(t3x1, //
					t3y1, //
					t3x2, //
					t3y2, //
					t2x1, //
					t2y1, //
					t2x2, //
					t2y2); //
			myInitOpening.py3c = this.intersectY(t3x1, //
					t3y1, //
					t3x2, //
					t3y2, //
					t2x1, //
					t2y1, //
					t2x2, //
					t2y2); //

			if (myInitOpening.px3c == 0) {
				myInitOpening.px3c = t3x2;
				myInitOpening.py3c = t3y2;
			}

			switch (myInitOpening.noSidesRight) {

			case 1: // R1

				myInitOpening.px4c = this.intersectX(t2x1, //
						t2y1, //
						t2x2, //
						t2y2, //
						rx1, //
						ry1, //
						rx2, //
						ry2); //
				myInitOpening.py4c = this.intersectY(t2x1, //
						t2y1, //
						t2x2, //
						t2y2, //
						rx1, //
						ry1, //
						rx2, //
						ry2); //

				switch (myInitOpening.noSidesBot) {

				case 1: // bot
					// 1
					myInitOpening.px5c = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py5c = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px6c = this.intersectX(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py6c = this.intersectY(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px6c = myInitOpening.px1c; //
						myInitOpening.py6c = myInitOpening.py1c; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot1

				case 2: // bot
					// 2
					myInitOpening.px5c = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py5c = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px6c = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					myInitOpening.py6c = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					switch (myInitOpening.noSidesLeft) {
					case 1: // left
						// 1
						myInitOpening.px7c = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py7c = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px7c = myInitOpening.px1c;
						myInitOpening.py7c = myInitOpening.py1c; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 2

				case 3: // bot
					// 3
					myInitOpening.px5c = this.intersectX(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.py5c = this.intersectY(rx1, //
							ry1, //
							rx2, //
							ry2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px6c = this.intersectX(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.py6c = this.intersectY(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px7c = this.intersectX(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					myInitOpening.py7c = this.intersectY(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px8c = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py8c = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px8c = myInitOpening.px1c; //
						myInitOpening.py8c = myInitOpening.py1c; //
						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 3

				} // Case Bot

				break;// R1

			case 0: // R0

				switch (myInitOpening.noSidesBot) {

				case 1: // bot
					// 1
					myInitOpening.px4c = this.intersectX(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py4c = this.intersectY(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					if (myInitOpening.px4c == 0) {
						myInitOpening.px4c = bx1;
						myInitOpening.py4c = by1;
					}

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px5c = this.intersectX(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py5c = this.intersectY(bx1, //
								by1, //
								bx2, //
								by2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px5c = myInitOpening.px1c; //
						myInitOpening.py5c = myInitOpening.py1c; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot1

				case 2: // bot
					// 2
					myInitOpening.px4c = this.intersectX(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //
					myInitOpening.py4c = this.intersectY(tx1, //
							ty1, //
							tx2, //
							ty2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					if (myInitOpening.px4c == 0) {
						myInitOpening.px4c = bx1;
						myInitOpening.py4c = by1;
					}

					myInitOpening.px5c = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					myInitOpening.py5c = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //
					switch (myInitOpening.noSidesLeft) {
					case 1: // left
						// 1
						myInitOpening.px6c = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py6c = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //

						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px6c = myInitOpening.px1c;
						myInitOpening.py6c = myInitOpening.py1c; //

						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 2

				case 3: // bot
					// 3
					myInitOpening.px4c = this.intersectX(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //

					myInitOpening.py4c = this.intersectY(t2x1, //
							t2y1, //
							t2x2, //
							t2y2, //
							b3x1, //
							b3y1, //
							b3x2, //
							b3y2); //
					if (myInitOpening.px4c == 0) {
						myInitOpening.px4c = b3x1;
						myInitOpening.py4c = b3y1;
					}

					myInitOpening.px5c = this.intersectX(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.py5c = this.intersectY(b3x1, //
							b3y1, //
							b3x2, //
							b3y2, //
							bx1, //
							by1, //
							bx2, //
							by2); //

					myInitOpening.px6c = this.intersectX(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					myInitOpening.py6c = this.intersectY(bx1, //
							by1, //
							bx2, //
							by2, //
							b2x1, //
							b2y1, //
							b2x2, //
							b2y2); //

					switch (myInitOpening.noSidesLeft) {

					case 1: // left
						// 1
						myInitOpening.px6c = this.intersectX(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						myInitOpening.py6c = this.intersectY(b2x1, //
								b2y1, //
								b2x2, //
								b2y2, //
								lx1, //
								ly1, //
								lx2, //
								ly2); //
						break;// left
					// 1

					case 0:// left
							// 0
						myInitOpening.px6c = myInitOpening.px1c; //
						myInitOpening.py6c = myInitOpening.py1c; //
						break;// left
					// 0

					}// left
						// Switch

					break;// bot
				// 3

				} // Case Bot

				break;// R0

			}// Case Right

			break; // Top 3

		}
		return myInitOpening;
	}

	public Object[] checkOpenings(OpeningObject opening) {

		Object[] returns = new Object[2];

		SeriesValidOpeningShape myOp = new SeriesValidOpeningShape();
		SeriesValidOpeningShapeEAO myOpEAO = new SeriesValidOpeningShapePersistenceEAO();

		if (opening.contentMid == 2 && opening.sashObjectMid != null) {
			myOp = ItemFrame.getApplicationBaseRules()
					.getSeriesValidOpeningById(
							opening.sashObjectMid.userDefinedOpeningID);
		} else {
			myOp = ItemFrame.getApplicationBaseRules()
					.getSeriesValidOpeningById(opening.userDefinedOpeningID);
		}

		returns = opening.checkOpeningLimit(opening, myOp);

		if (Integer.valueOf(returns[0].toString()) == 0) {

			returns[1] = returns[1].toString() + " : "
					+ opening.myParent.a_sequenceID + " : "
					+ opening.a_sequenceID + " Opening Name:"
					+ myOp.getSeriesValidOpeningPK().getAbbreviation();
		}

		return returns;

	}

}

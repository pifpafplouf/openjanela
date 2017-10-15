/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Model.ProfileParts;


import java.awt.geom.Arc2D;
import java.awt.geom.PathIterator;

import Model.ShapeObject;
import Operations.SetLeanTo;
import org.apache.log4j.Logger;


public class Top1Object extends ProfileParts implements Cloneable {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(Top1Object.class);

    //Number stock code
	public String stockCode = "";
	
	/**
	 * Create Top1Object
	 */
	public Top1Object() {
		//Init property values
		color = 1;
	}
	
	/**
	 * Create a Top1Object ProfileParts
	 *
	 * @param levelShape
	 * @param newPart
	 */
	public Top1Object(ShapeObject levelShape, boolean newPart) {
		
		//Call former constructor
		this();
		
		position = 1;
		myLevelShape = levelShape;
		startingX = myLevelShape.startingX;
		startingY = myLevelShape.startingY;
		bkgrdStartX = myLevelShape.startingX;
		bkgrdStartY = myLevelShape.startingY;
		wire = myLevelShape.wire;
		radius1 = myLevelShape.radius1;
		radius2 = myLevelShape.radius2;
		partForm = 2;
		shapeID = myLevelShape.shapeID;
		
		if (newPart) {
			this.setTopObjectInitData();
		} else {
			partID = myLevelShape.top1.partID;
			partDimB = myLevelShape.top1.partDimB;
			partDimA = myLevelShape.top1.partDimA;
			partDimC = myLevelShape.top1.partDimC;
			partDimM = myLevelShape.top1.partDimM;
			endTypeLT = myLevelShape.top1.endTypeLT;
			endTypeRB = myLevelShape.top1.endTypeRB;
			
		}
		this.setLeanTo();
		this.setEndTypes();
		
		
	}
	
	private void setEndTypes() {
		
		if (myLevelShape.shapeID == 200 || myLevelShape.shapeID == 300 && myLevelShape.dimB1 == myLevelShape.widthPix / 2) {
			endTypeRB = 3;
			endTypeLT = 3;
			
		}
		if (myLevelShape.shapeID == 201 && myLevelShape.dimD2 == myLevelShape.widthPix || myLevelShape.shapeID == 301
					&& myLevelShape.dimD2 == myLevelShape.widthPix) {
			endTypeRB = 3;
			
		}
		if (myLevelShape.shapeID == 202 && myLevelShape.dimB1 == myLevelShape.widthPix || myLevelShape.shapeID == 302
					&& myLevelShape.dimB1 == myLevelShape.widthPix) {
			endTypeLT = 3;
			
		}
		if (myLevelShape.shapeID == 800) {
			endTypeLT = 3;
			endTypeRB = 3;
			
		}
	}
	
	public void setLeanTo() {// Locally
		
		final SetLeanTo setLeanTo = new SetLeanTo(myLevelShape);
		myLean = setLeanTo.lean;
		myLean2 = setLeanTo.lean2;
		myLean3 = setLeanTo.lean3;
		myLean4 = setLeanTo.lean4;
	}
	
	/**
	 * Need to work on
	 */
	public void arc1B() { // int =1 Arc normal, 2 start at
		
		// 90, 3 end at 90
		
		partForm = 2;
		startX = startingX;
		startY = startingY + myLevelShape.dimD2;//
		endX = startX + myLevelShape.widthPix;
		endY = startingY + myLevelShape.dimB1;
		if (!myLevelShape.wire) {
			
			radius1 =
						myLevelShape.dimB1
						/ 2
						+ Math.pow(myLevelShape.widthPix, 2)
						/ (8 * myLevelShape.dimB1); //
			
		} else {
			radius1 = myLevelShape.radius1;
		}
		
		radianCentralAngle =
					2 * Math.atan(myLevelShape.widthPix
								/ 2
								/ (radius1 - myLevelShape.dimB1));
		centralAngle = Math.toDegrees(radianCentralAngle); // in
		x1 = startingX + myLevelShape.widthPix / 2;// ext1;
		y1 = startingY + radius1;
		x2 = endX;
		y2 = startY;
		if (endTypeRB == 3 && myLevelShape.shapeID != 200
					|| myLevelShape.shapeID == 800) {
			
			Math.atan((x1 - startingX) / myLevelShape.dimD2);
			final double thetaL =
						Math.atan((endX - x1) / myLevelShape.dimB1);
			final double delta =
						Math
						.sqrt(Math.pow(radius1, 2)
									- Math
									.pow(
												(x1 - (startX + myLevelShape.right.partDimB)),
												2))
												- (y1 - startY);
			startX = startingX + myLevelShape.left.partDimB;
			if (myLevelShape.noSidesRight > 1) {
				startY = startY - delta;
			}
			endX = endX - myLevelShape.right.partDimB;
			;
			if (myLevelShape.noSidesRight > 1) {
				endY =
							endY
							- myLevelShape.right.partDimB
							/ Math.tan(thetaL);
			} else {
				
			}
			
			radianCentralAngle =
						2 * Math
						.atan((endX - startX)
									/ 2
									/ (radius1 - (myLevelShape.dimB1 - myLevelShape.right.partDimB
												/ Math.tan(thetaL))));
			centralAngle = Math.toDegrees(radianCentralAngle); // in
		}
		rrSlope = (x2 - x1) / (y2 - y1);
		rrAngle = Math.abs(Math.atan(1 / rrSlope));
		rlSlope =
					(startingX - x1)
					/ (startingY + myLevelShape.dimD2 - y1);// /
		rlAngle = Math.abs(Math.atan(1 / rlSlope));
		double radiansStart =
					Math.abs(Math.atan((x2 - x1) / (y2 - y1)));
		radiansStart = Math.abs(Math.toDegrees(radianCentralAngle));
		startAngle = Math.abs((180 - radiansStart)) / 2;
		endAngle = Math.abs(centralAngle);
		bkgrdWidth = 2 * radius1;
		bkgrdHeight = 2 * radius1;
		if (endTypeRB != 3) {
			focal1X = startX + myLevelShape.widthPix / 2;
			focal1Y =
						startY
						+ Math
						.sqrt(Math.pow(radius1, 2)
									- Math
									.pow(
												myLevelShape.widthPix / 2,
												2));
			focal2X = focal1X;
			focal2Y = focal1Y;
			
			bkgrdStartX = x1 - radius1;
			bkgrdStartY = y1 - radius1;
		} else {
			focal1X = startX + (endX - startX) / 2;
			focal1Y =
						startY
						+ Math
						.sqrt(Math.pow(radius1, 2)
									- Math
									.pow(
												(endX - startX) / 2,
												2));
			focal2X = focal1X;
			focal2Y = focal1Y;
			
			bkgrdStartX = x1 - radius1;
			bkgrdStartY = y1 - radius1;
		}
		
		if (this.myLevelShape.noSides == 2) {
			if (myLevelShape.widthPix > myLevelShape.heightPix) {
				
			} else if (myLevelShape.widthPix < myLevelShape.heightPix) {
				
				partForm = 2;
				startX = startingX;
				startY = startingY + myLevelShape.dimD2;//
				endX = startX + myLevelShape.widthPix;
				endY = startingY + myLevelShape.dimB1;
				
			}
			
		}
		
		length = 2 * Math.PI * radius1 * centralAngle / 360;
		// 2PIr*CentralAngle/360
		
		radius2 = 0;
		
	}
	
	public void arc2BA() { // int =1 Arc normal, 2 start at
		
		// 90, 3 end at
		// ninety
		partForm = 2;
		// First line for All levels
		// this.startingXA = this.startingXBA +
		// this.partDimA;
		// this.startingYA = this.startingYBA +
		// this.partDimA;
		final double theta = 180 - startAngle - endAngle;
		if (endTypeRB == 1 || endTypeRB == 0) {
			startingXBA = startingX + partDimB;
			startingYBA = startingY + partDimB;
		} else if (endTypeRB == 2) {
			startingXBA = startX;
			startingYBA = startY + partDimB / Math.sin(theta);
		} else {
			startingXBA =
						startX
						+ (myLevelShape.left.partDimB + myLevelShape.right.partDimB)
						/ Math.tan(theta);
			startingYBA = startY + partDimB / Math.sin(theta);
		}
		myWidthBA =
					myLevelShape.widthPix
					- (myLevelShape.left.partDimB + myLevelShape.right.partDimB);
		
		radius1BA = radius1 - partDimB;
		double radiansStart =
					Math.abs(Math.acos(myWidthBA / 2 / radius1BA));
		
		startXBA = startingXBA;// ingXA;
		endXBA = startXBA + myWidthBA;
		
		final double YfromBottom =
					Math.abs(myWidthBA / 2 * Math.tan(radiansStart));
		
		startYBA = startingYBA + radius1BA - YfromBottom;// ((double)
		// Math.tan(radiansStart)*
		
		endYBA = startYBA;
		if (myLevelShape.shapeID == 303) {
			radiansStart =
						Math
						.asin((myLevelShape.bot1.partDimB
									+ radius1 - myLevelShape.heightPix)
									/ radius1BA);
			final double base =
						Math
						.sqrt(Math.pow(radius1BA, 2)
									- Math
									.pow(
												(myLevelShape.bot1.partDimB
															+ radius1 - myLevelShape.heightPix),
															2));
			startXBA = x1 - base;
			startYBA =
						startingY
						+ radius1
						- (myLevelShape.bot1.partDimB + radius1 - myLevelShape.heightPix);
			endXBA = x1 + base;
			endYBA = startYBA;
		}
		
		radiansStart = Math.abs(Math.toDegrees(radiansStart));
		dimB1B = radius1BA - YfromBottom;
		radianCentralAngle = Math.atan(myWidthBA / 2 / dimB1B);
		centralAngleBA = Math.abs(Math.toDegrees(radianCentralAngle));
		startAngleBA = Math.abs(radiansStart);
		endAngleBA = Math.abs(180 - 2 * radiansStart);
		if (myLevelShape.shapeID == 200) {
			startAngleBA = 0;
			endAngleBA = 180;
			
			startXBA = startingX + partDimB;
			startYBA = startingY + myLevelShape.dimD2;
			endXBA = myLevelShape.bX2 - partDimB;
			endYBA = startYBA;
		}
		
		bkgrdStartXBA = bkgrdStartX + partDimB;
		bkgrdStartYBA = bkgrdStartY + partDimB;
		bkgrdWidthBA = 2 * radius1BA;
		bkgrdHeightBA = 2 * radius1BA;
		
		lengthBA = 2 * Math.PI * radius1BA * centralAngleBA / 360;// 2PIr*CentralAngle/360
		radius2BA = 0;
	}
	
	public void arc3A() { // int =1 Arc normal, 2 start at
		
		// 90, 3 end at
		// ninety
		
		partForm = 2;
		final double theta = 180 - startAngle - endAngle;
		if (endTypeRB == 1 || endTypeRB == 0) {
			startingXA = startingXBA + partDimA;
			startingYA = startingYBA + partDimA;
		} else if (endTypeRB == 2) {
			startingXA = startX;
			startingYA = startY + partDimB / Math.sin(theta);
		} else {
			startingXA =
						startX
						+ (myLevelShape.left.partDimB
									+ myLevelShape.right.partDimB
									+ myLevelShape.left.partDimA + myLevelShape.right.partDimA)
									/ Math.tan(theta);
			startingYA =
						startY + (partDimB + partDimA) / Math.sin(theta);
		}
		myWidthA = myWidthBA - 2 * partDimA;
		
		radius1A = radius1BA - partDimA;
		double radiansStart = Math.acos(myWidthA / 2 / radius1A);
		startXA = startingXA;
		endXA = startXA + myWidthA;
		
		final double YfromBottom =
					Math.abs(myWidthA / 2 * Math.tan(radiansStart));
		
		startYA = startingYA + radius1A - YfromBottom;
		endYA = startYA;
		if (myLevelShape.shapeID == 200) {
			startXA = startX;
			startYA = startY;
			endXA = endX;
			endYA = endY;
		}
		if (myLevelShape.shapeID == 303) {
			radiansStart =
						Math.asin((myLevelShape.bot1.partDimB
									+ myLevelShape.bot1.partDimA
									+ radius1 - myLevelShape.heightPix)
									/ radius1A);
			final double base =
						Math
						.sqrt(Math.pow(radius1A, 2)
									- Math
									.pow(
												(myLevelShape.bot1.partDimB
															+ myLevelShape.bot1.partDimA
															+ radius1 - myLevelShape.heightPix),
															2));
			startXA = x1 - base;
			startYA =
						startingY
						+ radius1
						- (myLevelShape.bot1.partDimB
									+ myLevelShape.bot1.partDimA
									+ radius1 - myLevelShape.heightPix);
			endXA = x1 + base;
			endYA = startYA;
		}
		radiansStart = Math.abs(Math.toDegrees(radiansStart));
		dimB1A = radius1A - YfromBottom;
		
		radianCentralAngle = Math.atan(myWidthA / 2 / dimB1A);
		centralAngleA = Math.abs(Math.toDegrees(radianCentralAngle));
		
		startAngleA = Math.abs(radiansStart);
		endAngleA = Math.abs(180 - 2 * radiansStart);// centralAngleA;
		if (myLevelShape.shapeID == 200) {
			startAngleA = 0;
			endAngleA = 180;
			
			startXA = startingX + partDimB + partDimA;
			startYA = startingY + myLevelShape.dimD2;
			endXA = myLevelShape.bX2 - (partDimB + partDimA);
			endYA = startYBA;
		}
		bkgrdStartXA = bkgrdStartXBA + partDimA;
		bkgrdStartYA = bkgrdStartYBA + partDimA;
		bkgrdWidthA = 2 * radius1A;
		bkgrdHeightA = 2 * radius1A;
		
		lengthA = 2 * Math.PI * radius1A * centralAngleA / 360;
		
		radius2A = 0;
		ltAngle = Math.atan((endX - endXA) / (endY - endYA));
		rbAngle = Math.atan((startX - startXA) / (startY - startYA));
	}
	
	public void arcHR2BA() { // int =1 Arc normal, 2 start
		
		// at 90, 3 end at
		// ninety
		partForm = 2;
		// First line for All levels
		final double theta = 180 - startAngle - endAngle;
		if (endTypeRB == 1 || endTypeRB == 0) {
			startingXBA = startingX + partDimB;
			startingYBA = startingY + partDimB;
		} else if (endTypeRB == 2) {
			startingXBA = startX;
			startingYBA = startY + partDimB / Math.sin(theta);
		} else {
			startingXBA =
						startX
						+ (myLevelShape.left.partDimB + myLevelShape.right.partDimB)
						/ Math.tan(theta);
			startingYBA = startY + partDimB / Math.sin(theta);
		}
		
		myWidthBA = myLevelShape.widthPix - 2 * partDimB;
		radius1BA = radius1 - partDimB;
		double radiansStart =
					Math
					.asin((myLevelShape.bot1.partDimB + radius1 - myLevelShape.heightPix)
								/ radius1BA);
		startXBA = startingXBA;
		endXBA = startXBA + myWidthBA;
		
		final double YfromBottom =
					myLevelShape.bot1.partDimB
					+ radius1
					- myLevelShape.heightPix;
		startYBA = startingYBA + radius1BA - YfromBottom;
		endYBA = startYBA;
		
		radiansStart = Math.toDegrees(radiansStart);
		radianCentralAngle = Math.atan(myWidthBA / 2 / dimB1B);
		centralAngleBA = Math.toDegrees(radianCentralAngle);
		startAngleBA = radiansStart;
		endAngleBA = 180 - 2 * radiansStart;
		bkgrdStartXBA = bkgrdStartX + partDimB;
		
		bkgrdStartYBA = bkgrdStartY + partDimB;// startingYBA;
		bkgrdWidthBA = 2 * radius1BA;
		bkgrdHeightBA = 2 * radius1BA;
		
		lengthBA = 2 * Math.PI * radius1BA * centralAngleBA / 360;// 2PIr*CentralAngle/360
		radius2BA = 0;
	}
	
	public void arcHR3A() { // int =1 Arc normal, 2 start at
		
		// 90, 3 end at
		
		partForm = 2;
		
		final double theta = 180 - startAngle - endAngle;
		if (endTypeRB == 1 || endTypeRB == 0) {
			startingXA = startingXBA + partDimA;
			startingYA = startingYBA + partDimA;
		} else if (endTypeRB == 2) {
			startingXA = startX;
			startingYA = startY + partDimB / Math.sin(theta);
		} else {
			startingXA =
						startX
						+ (myLevelShape.left.partDimB
									+ myLevelShape.right.partDimB
									+ myLevelShape.left.partDimA + myLevelShape.right.partDimA)
									/ Math.tan(theta);
			startingYA =
						startY + (partDimB + partDimA) / Math.sin(theta);
		}
		myWidthA = myWidthBA - 2 * partDimA;
		
		radius1A = radius1BA - partDimA;
		double radiansStart =
					Math.asin((myLevelShape.bot1.partDimB
								+ myLevelShape.bot1.partDimA
								+ radius1 - myLevelShape.heightPix)
								/ radius1A);// (x2A
		startXA = startingXA;// ingXA;
		endXA = startXA + myWidthA;
		final double YfromBottom =
					myLevelShape.bot1.partDimB
					+ myLevelShape.bot1.partDimA
					+ radius1
					- myLevelShape.heightPix;
		startYA = startingYA + radius1A - YfromBottom;
		endYA = startYA;
		radiansStart = Math.toDegrees(radiansStart);
		dimB1A = radius1A - YfromBottom;
		radianCentralAngle = Math.atan(myWidthA / 2 / dimB1A);
		centralAngleA = Math.toDegrees(radianCentralAngle);
		startAngleA = radiansStart;
		endAngleA = 180 - 2 * radiansStart;// centralAngleA;
		bkgrdStartXA = bkgrdStartXBA + partDimA;
		bkgrdStartYA = bkgrdStartYBA + partDimA;
		bkgrdWidthA = 2 * radius1A;
		bkgrdHeightA = 2 * radius1A;
		lengthA = 2 * Math.PI * radius1A * centralAngleA / 360;
		radius2A = 0;
		ltAngle = Math.atan((endX - endXA) / (endY - endYA));
		rbAngle = Math.atan((startX - startXA) / (startY - startYA));
	}
	
	public void archB() { // int =1 Arc normal, 2
		
		// start at 90, 3 end at 90
		partForm = 2;
		startX = startingX;
		startY = startingY + myLevelShape.dimD2;//
		endX = startX + myLevelShape.widthPix;
		endY = startingY + myLevelShape.dimB1;
		if (myLevelShape.widthPix > myLevelShape.heightPix) {
			radius1 = myLevelShape.widthPix / 2;
			radius2 = myLevelShape.heightPix / 2;
		} else {
			radius2 = myLevelShape.widthPix / 2;
			radius1 = myLevelShape.heightPix / 2;
		}
		
		rrAngle = Math.toRadians(90);
		rlAngle = Math.toRadians(90);
		startAngle = 0;
		endAngle = 180;
		bkgrdWidth = myLevelShape.widthPix;
		bkgrdHeight = myLevelShape.heightPix;
		bkgrdStartX = startingX;
		bkgrdStartY = startingY;
		length = 2 * Math.PI * radius1 * 180 / 360;
		
	}
	
	public void arcCircle1B() { // int =1 Arc normal, 2
		
		// start at 90, 3 end at 90
		partForm = 2;
		startX = startingX;
		startY = startingY + myLevelShape.dimD2;//
		endX = startX + myLevelShape.widthPix;
		endY = startingY + myLevelShape.dimB1;
		radius1 = myLevelShape.widthPix / 2;
		rrAngle = Math.toRadians(90);
		rlAngle = Math.toRadians(90);
		startAngle = 0;
		endAngle = 180;
		bkgrdWidth = 2 * radius1;
		bkgrdHeight = 2 * radius1;
		bkgrdStartX = startingX;
		bkgrdStartY = startingY;
		x1 = focal1X = startingX + radius1;// ext1;
		y1 = focal1Y = startingY + radius1;
		x2 = endX;
		y2 = startY;
		
		length = 2 * Math.PI * radius1 * 180 / 360;
		radius2 = 0;
		
	}
	
	public void arcCircle2BA() { // int =1 Arc normal, 2
		
		// start at 90, 3 end at
		// ninety
		partForm = 2;
		startXBA = startX + partDimB;
		startYBA = startY;//
		endXBA = endX - partDimB;
		endYBA = endY;
		radius1BA = radius1 - partDimB;
		rrAngleBA = Math.toRadians(90);
		rlAngleBA = Math.toRadians(90);
		startAngleBA = 0;
		endAngleBA = 180;
		bkgrdWidthBA = 2 * radius1BA;
		bkgrdHeightBA = 2 * radius1BA;
		bkgrdStartXBA = startingX + partDimB;
		bkgrdStartYBA = startingY + partDimB;
		lengthBA = 2 * Math.PI * radius1BA * 180 / 360;
		radius2BA = 0;
	}
	
	public void archBA() { // int =1 Arc normal, 2
		
		// start at 90, 3 end at
		// ninety
		partForm = 2;
		startXBA = startX + partDimB;
		startYBA = startY;//
		endXBA = endX - partDimB;
		endYBA = endY;
		radius1BA = radius1 - partDimB;
		rrAngleBA = Math.toRadians(90);
		rlAngleBA = Math.toRadians(90);
		startAngleBA = 0;
		endAngleBA = 180;
		bkgrdWidthBA = myLevelShape.widthPix - 2 * partDimB;
		bkgrdHeightBA = myLevelShape.heightPix - 2 * partDimB;
		bkgrdStartXBA = startingX + partDimB;
		bkgrdStartYBA = startingY + partDimB;
		lengthBA = 2 * Math.PI * radius1BA * 180 / 360;
		
	}
	
	public void arcCircle3A() { // int =1 Arc normal, 2
		
		// start at 90, 3 end at
		partForm = 2;
		startXA = startXBA + partDimA;
		startYA = startY;
		endXA = endX - partDimB - partDimA;
		endYA = endY;
		radius1A = radius1BA - partDimA;
		rrAngleA = Math.toRadians(90);
		rlAngleA = Math.toRadians(90);
		startAngleA = 0;
		endAngleA = 180;
		bkgrdWidthA = 2 * radius1A;
		bkgrdHeightA = 2 * radius1A;
		bkgrdStartXA = startingX + partDimB + partDimA;
		bkgrdStartYA = startingY + partDimB + partDimA;
		lengthA = 2 * Math.PI * radius1A * 180 / 360;
		radius2A = 0;
	}
	
	public void archA() { // int =1 Arc normal, 2
		
		// start at 90, 3 end at
		partForm = 2;
		startXA = startXBA + partDimA;
		startYA = startY;
		endXA = endX - partDimB - partDimA;
		endYA = endY;
		radius1A = radius1BA - partDimA;
		rrAngleA = Math.toRadians(90);
		rlAngleA = Math.toRadians(90);
		startAngleA = 0;
		endAngleA = 180;
		bkgrdWidthA =
					myLevelShape.widthPix - 2 * (partDimB + partDimA);
		;
		bkgrdHeightA = myLevelShape.widthPix - 2 * partDimB;
		;
		bkgrdStartXA = startingX + partDimB + partDimA;
		bkgrdStartYA = startingY + partDimB + partDimA;
		lengthA = 2 * Math.PI * radius1A * 180 / 360;
		
	}
	
	public void arcBegin901B() {
		
		partForm = 2;
		startX = startingX;
		startY = startingY;// +
		// myLevelShape.dimD2;
		endX = startX + myLevelShape.widthPix;
		endY = startY + myLevelShape.dimB1;
		if (!wire || myLevelShape.shapeChanged) {
			
			radius1 =
						myLevelShape.dimB1
						/ 2
						+ Math.pow(myLevelShape.widthPix * 2, 2)
						/ (8 * myLevelShape.dimB1); //
			
			x1 = startingX;// +
			// this.myLevelShape.wT / 2;//
			// ext1;
			y1 = startingY + radius1;// -
			x2 = endX;
			y2 = endY;
			radianCentralAngle =
						Math.abs(2 * Math.atan(myLevelShape.widthPix
									* 2
									/ 2
									/ (radius1 - myLevelShape.dimB1)));
			
			centralAngle =
						Math.abs(Math.toDegrees(radianCentralAngle)); // in
			
		} else {
			radius1 = myLevelShape.radius1;
			x1 = myLevelShape.centerPointX;
			y1 = myLevelShape.centerPointY;
			
			x2 = myLevelShape.centerPointX2;
			y2 = myLevelShape.centerPointY2;
			centralAngle = myLevelShape.centralAngle; // in
			// degrees
		}
		rrSlope = (x2 - x1) / (y2 - y1);
		rrAngle = Math.abs(Math.atan(1 / rrSlope));
		rlSlope =
					(startingX - x1)
					/ (startingY + myLevelShape.dimD2 - y1);// /
		rlAngle = Math.abs(Math.atan(1 / rlSlope));
		rbAngle = rlAngle;
		
		if (!wire || myLevelShape.shapeChanged) {
			double radiansStart = Math.atan((x2 - x1) / (y2 - y1));
			radiansStart = Math.toDegrees(radianCentralAngle);
			// if (this.centralAngle < 0
			// && (this.myLevelShape.shapeID ==
			// 205 ||
			// this.myLevelShape.shapeID
			// == 305
			// &&
			// this.myLevelShape.shapeChanged)) {
			// this.startAngle = 0;
			// } else {
			startAngle = (180 - radiansStart) / 2;// centralAnglet1;//radiansStart;//radiansStart;
			// }
			endAngle = Math.abs(centralAngle / 2);
		} else {
			startAngle = myLevelShape.startAngle;// (180
			// -
			endAngle = myLevelShape.endAngle;
		}
		bkgrdWidth = 2 * radius1;
		bkgrdHeight = 2 * radius1;
		if (!wire || myLevelShape.shapeChanged) {
			focal1X = startX;// +
			// this.myLevelShape.wT / 2;
			focal1Y = startY;
			focal2X = focal1X;
			focal2Y = focal1Y;
			bkgrdStartX = focal1X - radius1;
			bkgrdStartY = focal1Y;// -
			// radius1;
		} else {
			focal1X = x1;
			focal1Y = y1;
			focal2X = x2;
			focal2Y = y2;
			bkgrdStartX = myLevelShape.bkgrdStartX;
			bkgrdStartY = myLevelShape.bkgrdStartY;
		}
		length = 2 * Math.PI * radius1 * centralAngle / 360;// 2PIr*CentralAngle/360
		radius2 = 0;
	}
	
	public void arcBegin902BA() {
		
		partForm = 2;
		if (!wire || myLevelShape.shapeChanged) {
			startingXBA = startingX + partDimB;
			startingYBA = startingY + partDimB;
			myWidthBA = myLevelShape.widthPix * 2 - 2 * partDimB;
			radius1BA = radius1 - partDimB;
			double radiansStart = 0;
			double YfromBottom = 0;
			if (myLevelShape.shapeID == 205
						|| myLevelShape.shapeID == 305) {
				radiansStart =
							Math.asin((myLevelShape.bot1.partDimB
										+ radius1 - myLevelShape.heightPix)
										/ radius1BA);// (x2BA
				// -
				// x1BA) /
				// (y2BA -
				// y1BA));
				YfromBottom =
							myLevelShape.bot1.partDimB
							+ radius1
							- myLevelShape.heightPix;
				// this.endYBA =
				// this.startingYBA +
				// (this.radius1BA -
				// YfromBottom);//
				// this.startYBA;
				
				final double base =
							Math
							.sqrt(Math.pow(radius1BA, 2)
										- Math
										.pow(
													(myLevelShape.bot1.partDimB
																+ radius1 - myLevelShape.heightPix),
																2));
				endXBA = x1 + base;
				endYBA =
							startingY
							+ radius1
							- (myLevelShape.bot1.partDimB
										+ radius1 - myLevelShape.heightPix);
				
			} else {
				radiansStart = Math.acos(myWidthBA / 2 / radius1BA);// (x2BA
				// - x1BA) /
				// (y2BA - y1BA));
				YfromBottom =
							Math.abs((myLevelShape.widthPix - partDimB)
										* Math.tan(radiansStart));
				endYBA = startingYBA + radius1BA - YfromBottom;// this.startYBA;
				endXBA =
							startingXBA
							+ myLevelShape.widthPix
							- 2
							* partDimB;
			}
			radsStartBA = radiansStart;
			final double radiansStart2 =
						Math.acos(partDimB / radius1BA);
			radsStart2BA = radiansStart2;
			radianCentralAngle = radiansStart2 - radiansStart;
			startXBA = startingXBA;// ingXBA;
			
			YfromBottom =
						Math.abs((myLevelShape.widthPix - partDimB)
									* Math.tan(radiansStart));
			final double YfromBottom2 =
						Math.abs(partDimB * Math.tan(radiansStart2));
			startXBA = startingXBA;// startingXBA
			// ;//ingXBA;
			
			startYBA = startingYBA + radius1BA - YfromBottom2;// ((double)
			// Math.tan(radiansStart)*
			
			radiansStart = Math.toDegrees(radiansStart);
			centralAngleBA = Math.toDegrees(radianCentralAngle); // in
			// degrees
			startAngleBA = radiansStart;// (180
			// -
			// radiansStart) /
			// 2;//
			// centralAnglet1;//radiansStart;//radiansStart;
			endAngleBA = centralAngleBA;// /2;//180
			// -
			// (2*radiansStart);//centralAngleBA;
			bkgrdStartXBA = bkgrdStartX + partDimB;// startingXBA+
			
			bkgrdStartYBA = bkgrdStartY + partDimB;// startingYBA;
			bkgrdWidthBA = 2 * radius1BA;
			bkgrdHeightBA = 2 * radius1BA;
			lengthBA = 2 * Math.PI * radius1BA * centralAngleBA / 360;
			radius2BA = 0;
		} else {
			startingXBA = startingX + myLevelShape.left.partDimB;
			myWidthBA =
						myLevelShape.widthPix
						- myLevelShape.right.partDimB
						- myLevelShape.left.partDimB;
			startXBA = startingX + myLevelShape.left.partDimB;
			endXBA = endX - myLevelShape.right.partDimB;
			
			radius1BA = radius1 - partDimB;
			// double radiansStart = (double)
			// Math.acos(((this.myLevelShape.wT+
			// (startingX-this.myLevelShape.centerPointX)
			// -this.myLevelShape.right.partDimB
			// )/radius1BA));//(x2BA - x1BA) /
			// (y2BA - y1BA));
			double radiansStart = 0;
			double YfromBottom = 0;
			if (myLevelShape.shapeID == 205
						|| myLevelShape.shapeID == 305) {
				final double deltaStartY =
							myLevelShape.startingY
							- myLevelShape.parentStartY;
				radiansStart =
							Math
							.asin((myLevelShape.bot1.partDimB
										+ radius1 - (myLevelShape.heightPix + deltaStartY))
										/ radius1BA);// (x2BA
				// -
				// x1BA) /
				// (y2BA -
				// y1BA));
				YfromBottom =
							myLevelShape.bot1.partDimB
							+ radius1
							- (myLevelShape.heightPix + deltaStartY);
				// this.endYBA =
				// this.startingYBA +
				// (this.radius1BA -
				// YfromBottom);//
				// this.startYBA;
				
				final double base =
							Math
							.sqrt(Math.pow(radius1BA, 2)
										- Math
										.pow(
													(myLevelShape.bot1.partDimB
																+ radius1 - (myLevelShape.heightPix + deltaStartY)),
																2));
				endXBA = x1 + base;
				endYBA =
							startingY
							+ radius1
							- (myLevelShape.bot1.partDimB
										+ radius1 - (myLevelShape.heightPix + deltaStartY));
				
			} else {
				radiansStart =
							Math
							.acos((startingX
										+ myLevelShape.widthPix
										- myLevelShape.centerPointX - myLevelShape.right.partDimB)
										/ radius1BA);
				YfromBottom =
							Math.abs((myLevelShape.widthPix - partDimB)
										* Math.tan(radiansStart));
				endYBA = startingYBA + radius1BA - YfromBottom;// this.startYBA;
			}
			
			radsStartBA = radiansStart;
			
			// double radiansStart2 =
			// (double)
			// Math.acos(((startingX-this.myLevelShape.centerPointX)+
			// this.myLevelShape.left.partDimB)/radius1BA);//(x2A
			// - x1A) / (y2A
			// - y1A));
			//
			final double radiansStart2 =
						Math
						.acos((startingX
									- myLevelShape.centerPointX + myLevelShape.left.partDimB)
									/ radius1BA);// (x2A
			// - x1A) /
			// (y2A - y1A));
			
			radsStart2BA = radiansStart2;
			radianCentralAngle = radiansStart2 - radiansStart;
			
			// double YfromBottom =
			// (double)
			// Math.abs((((startingX-this.myLevelShape.centerPointX)+this.myLevelShape.wT
			// -
			// this.myLevelShape.right.partDimB))*(double)
			// Math.tan(radiansStart));
			//
			// double YfromBottom2 =
			// (double)
			// Math.abs((((startingX-this.myLevelShape.centerPointX)+
			// this.myLevelShape.left.partDimB))*(double)
			// Math.tan(radiansStart2));
			//
			// this.startYBA =
			// this.startingYBA+this.radius1BA -
			// YfromBottom2;//((double)
			// Math.tan(radiansStart)*
			// this.startX)+
			// interceptofRL;
			// this.endYBA =
			// this.startingYBA+(this.radius1BA
			// -
			// YfromBottom);//this.startYBA;
			
			radiansStart = Math.toDegrees(radiansStart);
			// this.dimB1B = this.radius1BA -
			// YfromBottom;
			
			centralAngleBA = Math.toDegrees(radianCentralAngle); // in
			// degrees
			
			startAngleBA = radiansStart;// (180
			// -
			// radiansStart) /
			// 2;//
			// centralAnglet1;//radiansStart;//radiansStart;
			endAngleBA = centralAngleBA;// /2;//180
			// -
			// (2*radiansStart);//centralAngleBA;
			
			final double yFullRadiusLeft =
						myLevelShape.centerPointY - startingY;
			
			final double baseForYLeft =
						myLevelShape.startingX
						- myLevelShape.centerPointX
						+ myLevelShape.left.partDimB;
			
			final double radiansYLeft =
						Math.toRadians(startAngleBA + endAngleBA);// (double)
			// Math.acos(baseForYRight/(this.radius1-this.partDimB));
			
			final double yLeftBA =
						Math.abs(baseForYLeft * Math.tan(radiansYLeft));
			
			startingYBA = startingY + yFullRadiusLeft - yLeftBA;
			
			final double yFullRadiusRight =
						myLevelShape.centerPointY - startingYBA;
			
			final double baseForYRight =
						myLevelShape.bX2
						- myLevelShape.centerPointX
						- myLevelShape.right.partDimB;
			
			final double radiansYRight = Math.toRadians(startAngleBA);// (double)
			// Math.acos(baseForYRight/(this.radius1-this.partDimB));
			
			final double yRightBA =
						Math.abs(baseForYRight * Math.tan(radiansYRight));
			
			startYBA = startingYBA;// +
			// (yFullRadiusRight-yRightBA);
			
			if (myLevelShape.shapeID != 205
						&& myLevelShape.shapeID != 305) {
				endYBA = startingYBA + yFullRadiusRight - yRightBA;
			}
			
			bkgrdStartXBA = bkgrdStartX + partDimB;// startingXBA+
			// this.myWidthBA/2
			// -
			// radius1BA;
			bkgrdStartYBA = bkgrdStartY + partDimB;// startingYBA;
			bkgrdWidthBA = 2 * radius1BA;
			bkgrdHeightBA = 2 * radius1BA;
			
			lengthBA = 2 * Math.PI * radius1BA * centralAngleBA / 360;// 2PIr*CentralAngle/360
			
			radius2BA = 0;
		}
		
	}
	
	public void arcBegin903A() { // int =1 Arc normal, 2
		
		// start at 90, 3 end
		// at ninety
		double radiansStart = 0;
		double YfromBottom = 0;
		partForm = 2;
		// First line for All levels
		if (!wire || myLevelShape.shapeChanged) {
			startingXA = startingX + partDimA + partDimB;
			startingYA = startingY + partDimA + partDimB;
			
			myWidthA = myWidthBA - 2 * partDimA;
			
			radius1A = radius1BA - partDimA;
			
			if (myLevelShape.shapeID == 205
						|| myLevelShape.shapeID == 305) {
				radiansStart =
							Math.asin((myLevelShape.bot1.partDimA
										+ myLevelShape.bot1.partDimB
										+ radius1 - myLevelShape.heightPix)
										/ radius1A);// (x2BA
				// - x1BA)
				// / (y2BA -
				// y1BA));
				// YfromBottom =
				// (this.myLevelShape.bot1.partDimA
				// +
				// this.myLevelShape.bot1.partDimB)+(this.radius1-this.myLevelShape.hL);
				// this.endYA =
				// this.startingYA +
				// (this.radius1A -
				// YfromBottom);//
				// this.startYBA;
				final double base =
							Math
							.sqrt(Math.pow(radius1A, 2)
										- Math
										.pow(
													(myLevelShape.bot1.partDimA
																+ myLevelShape.bot1.partDimB
																+ radius1 - myLevelShape.heightPix),
																2));
				endXA = x1 + base;
				endYA =
							startingY
							+ radius1
							- (myLevelShape.bot1.partDimA
										+ myLevelShape.bot1.partDimB
										+ radius1 - myLevelShape.heightPix);
			} else {
				radiansStart = Math.acos(myWidthA / 2 / radius1A);// (x2BA
				// -
				// x1BA)
				// /
				// (y2BA
				// -
				// y1BA));
				YfromBottom =
							Math
							.abs((myLevelShape.widthPix - (partDimA + partDimB))
										* Math.tan(radiansStart));
				endYA = startingYA + radius1A - YfromBottom;// this.startYBA;
				endXA =
							startingXA
							+ myLevelShape.widthPix
							- 2
							* (partDimA + partDimB);
			}
			final double radiansStart2 =
						Math.acos((partDimA + partDimB) / radius1A);// (x2A
			// -
			// x1A)
			// /
			// (y2A
			// -
			// y1A));
			
			radianCentralAngle = radiansStart2 - radiansStart;
			
			startXA = startingXA;// ingXA;
			
			final double YfromBottom2 =
						Math.abs((partDimA + partDimB)
									* Math.tan(radiansStart2));
			
			startYA = startingYA + radius1A - YfromBottom2;
			
			radiansStart = Math.toDegrees(radiansStart);
			
			centralAngleA = Math.toDegrees(radianCentralAngle);
			
			startAngleA = radiansStart;
			endAngleA = centralAngleA;
			
			bkgrdStartXA = bkgrdStartXBA + partDimA;
			bkgrdStartYA = bkgrdStartYBA + partDimA;
			bkgrdWidthA = 2 * radius1A;
			bkgrdHeightA = 2 * radius1A;
			
			lengthA = 2 * Math.PI * radius1A * centralAngleA / 360;
			
			radius2A = 0;
			// this.ltAngle = (double)
			// Math.atan((endX -
			// endXA) / (endY -
			// endYA));
			// this.rbAngle = (double)
			// Math.toRadians(90)-(double)
			// Math.atan((startX - startXA) /
			// (startY - startYA));
			ltAngle = Math.atan((endXA - endX) / (endYA - endY));
			rbAngle =
						Math
						.atan((startX - startXA)
									/ (startY - startYA));
			
		} else {
			startingXA = startingX + partDimA + partDimB;
			// this.startingYA = startingY +
			// this.partDimA+
			// this.partDimB;
			
			myWidthA =
						myLevelShape.widthPix
						- myLevelShape.right.partDimA
						- myLevelShape.left.partDimA
						- myLevelShape.right.partDimB
						- myLevelShape.left.partDimB;
			
			radius1A = radius1 - partDimA - partDimB;
			radiansStart = 0;
			if (myLevelShape.shapeID == 205
						|| myLevelShape.shapeID == 305) {
				final double deltaStartY =
							myLevelShape.startingY
							- myLevelShape.parentStartY;
				radiansStart =
							Math
							.asin((myLevelShape.bot1.partDimA
										+ myLevelShape.bot1.partDimB
										+ radius1 - (myLevelShape.heightPix + deltaStartY))
										/ radius1A);// (x2BA
				// - x1BA)
				// / (y2BA -
				
				final double base =
							Math
							.sqrt(Math.pow(radius1A, 2)
										- Math
										.pow(
													(myLevelShape.bot1.partDimA
																+ myLevelShape.bot1.partDimB
																+ radius1 - (myLevelShape.heightPix + deltaStartY)),
																2));
				endXA = x1 + base;
				endYA =
							startingY
							+ radius1
							- (myLevelShape.bot1.partDimA
										+ myLevelShape.bot1.partDimB
										+ radius1 - (myLevelShape.heightPix + deltaStartY));
			} else {
				radiansStart =
							Math
							.acos((startingX
										+ myLevelShape.widthPix
										- myLevelShape.centerPointX
										- myLevelShape.right.partDimB - myLevelShape.right.partDimA)
										/ radius1A);// (x2A
				// - x1A) /
				// (y2A - y1A));
				// (double) Math
				// .abs(((this.myLevelShape.levelW
				// -
				// (this.partDimA +
				// this.partDimB)))
				// * (double)
				// Math.tan(radiansStart));
			}
			
			final double radiansStart2 =
						Math
						.acos((startingX
									- myLevelShape.centerPointX
									+ myLevelShape.left.partDimA + myLevelShape.left.partDimB)
									/ radius1A);// (x2A
			// - x1A) /
			// (y2A - y1A));
			
			radianCentralAngle = radiansStart2 - radiansStart;
			startXA = startingXA;// ingXA;
			if (myLevelShape.shapeID != 205
						&& myLevelShape.shapeID != 305) {
				endXA = startXA + myWidthA;
			}
			
			// double YfromBottom =
			// (this.startingX -
			// this.myLevelShape.centerPointX +
			// this.myLevelShape.wT -
			// this.myLevelShape.right.partDimB
			// -
			// this.myLevelShape.right.partDimA)
			// *(double) Math.tan(radiansStart);
			//
			// double YfromBottom2 =
			// (startingX-this.myLevelShape.centerPointX+this.myLevelShape.left.partDimA+
			// this.myLevelShape.left.partDimB)*(double)
			// Math.tan(radiansStart2);
			//
			// this.startYA = startingYA+
			// this.radius1A-YfromBottom2;
			//
			// this.endYA =
			// this.startingYA+this.radius1A -
			// YfromBottom;
			
			radiansStart = Math.toDegrees(radiansStart);
			// this.dimB1A = this.radius1A -
			// YfromBottom;
			
			centralAngleA = Math.toDegrees(radianCentralAngle);
			
			startAngleA = radiansStart;
			endAngleA = centralAngleA;// /2;//(180
			// -
			// (2*radiansStart))/2;//centralAngleA;
			
			final double yFullRadiusLeft =
						myLevelShape.centerPointY - startingY;
			
			final double baseForYLeft =
						myLevelShape.startingX
						- myLevelShape.centerPointX
						+ myLevelShape.left.partDimB
						+ myLevelShape.left.partDimA;
			
			final double radiansYLeft =
						Math.toRadians(startAngleA + endAngleA);
			
			final double yLeftA =
						Math.abs(baseForYLeft * Math.tan(radiansYLeft));
			
			startingYA = startingY + yFullRadiusLeft - yLeftA;
			startYA = startingYA;// +
			// (yFullRadiusRight-yRightBA);
			
			final double yFullRadiusRight =
						myLevelShape.centerPointY - startingYA;
			
			final double baseForYRight =
						myLevelShape.bX2
						- myLevelShape.centerPointX
						- myLevelShape.right.partDimB
						- myLevelShape.right.partDimA;
			
			final double radiansYRight = Math.toRadians(startAngleA);// (double)
			// Math.acos(baseForYRight/(this.radius1-this.partDimB));
			
			final double yRightA =
						Math.abs(baseForYRight * Math.tan(radiansYRight));
			if (myLevelShape.shapeID != 205
						&& myLevelShape.shapeID != 305) {
				endYA = startYA + yFullRadiusRight - yRightA;
			}
			
			bkgrdStartXA = bkgrdStartXBA + partDimA;
			bkgrdStartYA = bkgrdStartYBA + partDimA;
			bkgrdWidthA = 2 * radius1A;
			bkgrdHeightA = 2 * radius1A;
			
			lengthA = 2 * Math.PI * radius1A * centralAngleA / 360;
			
			radius2A = 0;
			
			ltAngle =
						Math.atan(Math.abs((endXA - endX))
									/ Math.abs((endYA - endY)));
			rbAngle =
						Math.atan(Math.abs((startX - startXA))
									/ Math.abs((startY - startYA)));
			
			// System.out.print("my top LT Angle is: "+(double)
			// Math.toDegrees(this.ltAngle)+" \n    "
			// );
			// System.out.print("my top RB Angle is: "+(double)
			// Math.toDegrees(this.rbAngle)+" \n    "
			// );
		}
	}
	
	public void arcEnd901B() {
		
		partForm = 2;
		
		if (!wire || myLevelShape.shapeChanged) {
			startX = startingX;
			
			startY = startingY + myLevelShape.dimD2; // or
			// dimD2
			
			endX = startX + myLevelShape.widthPix;
			endY = startingY + myLevelShape.dimB1;
			
			radius1 =
						myLevelShape.dimD2
						/ 2
						+ Math.pow(myLevelShape.widthPix * 2, 2)
						/ (8 * myLevelShape.dimD2); //
			
			radius2 = 0;
			//
			x1 = endX;
			y1 = startingY + radius1;
			
			x2 = endX;
			y2 = endY;
			
			radianCentralAngle =
						2 * Math.atan(myLevelShape.widthPix
									* 2
									/ 2
									/ (radius1 - myLevelShape.dimD2));
			
			centralAngle = Math.toDegrees(radianCentralAngle);
			
			double radiansStart = Math.atan((x2 - x1) / (y2 - y1));
			radiansStart = Math.toDegrees(radiansStart);
			if (myLevelShape.shapeID == 204
						|| myLevelShape.shapeID == 304 && myLevelShape.shapeChanged) {
				startAngle = 90;//
				
			} else {
				startAngle = (180 - radiansStart) / 2;//
			}
			// if (this.centralAngle < 0
			// && (this.myLevelShape.shapeID ==
			// 204 ||
			// this.myLevelShape.shapeID
			// == 304
			// &&
			// this.myLevelShape.shapeChanged)) {
			// this.endAngle = 90;
			// } else {
			endAngle = Math.abs(centralAngle / 2);
			// }
			
			bkgrdWidth = 2 * radius1;
			bkgrdHeight = 2 * radius1;
			
			focal1X = endX;// +
			// this.myLevelShape.wT / 2;
			focal1Y = endY + radius1;
			// + (double) Math.sqrt((double)
			// Math.pow(radius1,
			// 2) -
			// (double)
			// Math.pow((this.myLevelShape.wT*2) /
			// 2, 2));
			focal2X = focal1X;
			focal2Y = focal1Y;
			
			bkgrdStartX = endX - radius1;// focal1X
			// -
			// radius1;
			bkgrdStartY = startingY;// focal1Y
			// ;//- radius1;
			
		} else {
			startX = myLevelShape.startingX;
			startY = myLevelShape.startingY + myLevelShape.dimD2;
			// or
			// dimD2
			endX = startX + myLevelShape.widthPix;
			endY = myLevelShape.startingY + myLevelShape.dimB1;
			radius1 = myLevelShape.radius1;
			radius2 = myLevelShape.radius2;
			x1 = myLevelShape.centerPointX;
			y1 = myLevelShape.centerPointY;
			
			x2 = myLevelShape.centerPointX2;
			y2 = myLevelShape.centerPointY2;
			// radianCentralAngle =
			// this.myLevelShape.centralAngle;
			centralAngle = myLevelShape.centralAngle; // in
			// degrees
			
			startAngle = myLevelShape.startAngle;// (180
			// -
			
			endAngle = myLevelShape.endAngle;
			
			bkgrdWidth = 2 * radius1;
			bkgrdHeight = 2 * radius1;
			focal1X = x1;
			focal1Y = y1;
			focal2X = x2;
			focal2Y = y2;
			
			bkgrdStartX = myLevelShape.bkgrdStartX;
			bkgrdStartY = myLevelShape.bkgrdStartY;
		}
		
		rrSlope = (x2 - x1) / (y2 - y1);
		
		rrAngle = Math.abs(Math.atan(1 / rrSlope));
		
		rlSlope =
					(startingX - x1)
					/ (startingY + myLevelShape.dimD2 - y1);
		
		rlAngle = Math.abs(Math.atan(1 / rlSlope));
		
		length = 2 * Math.PI * radius1 * centralAngle / 360;
		
		radius2 = 0;
		
	}
	
	public void arcEnd902BA() { // int =1 Arc normal, 2
		
		// start at 90, 3 end
		// at ninety
		partForm = 2;
		// First line for All levels
		if (!wire || myLevelShape.shapeChanged) {
			startingXBA = startingX + partDimB;
			startingYBA = startingY + partDimB;
			
			myWidthBA = myLevelShape.widthPix * 2 - 2 * partDimB;
			radius1BA = radius1 - partDimB;
			
			startXBA = startingXBA;// ingXBA;
			endXBA = startXBA + myLevelShape.widthPix - 2 * partDimB;
			double radiansStart = 0;
			double radianEnd = 0;
			double YfromBottom2 = 0;
			double YfromBottom = 0;
			radiansStart = Math.acos(partDimB / radius1BA);
			
			if (myLevelShape.shapeID == 204
						|| myLevelShape.shapeID == 304) {
				radianEnd =
							Math.asin((myLevelShape.bot1.partDimB
										+ radius1 - myLevelShape.heightPix)
										/ radius1BA);
				
				final double base =
							Math
							.sqrt(Math.pow(radius1BA, 2)
										- Math
										.pow(
													(myLevelShape.bot1.partDimB
																+ radius1 - myLevelShape.heightPix),
																2));
				startXBA = x1 - base;
				startYBA =
							startingY
							+ radius1
							- (myLevelShape.bot1.partDimB
										+ radius1 - myLevelShape.heightPix);
				// this.endXBA =
				// this.x1+base;
				
			} else {
				radianEnd =
							Math.acos((myLevelShape.widthPix - partDimB)
										/ radius1BA);
				YfromBottom2 =
							Math.abs((myLevelShape.widthPix - partDimB)
										* Math.tan(radianEnd));
				startYBA = startingYBA + radius1BA - YfromBottom2;
			}
			centralAngleBA =
						Math
						.abs(Math.toDegrees(radianEnd
									- radiansStart));
			
			YfromBottom = Math.abs(partDimB * Math.tan(radiansStart));
			
			endYBA = startingYBA + radius1BA - YfromBottom;
			
			startAngleBA = 180 - Math.toDegrees(radiansStart);// (180
			// -
			
			endAngleBA = centralAngleBA;
			
			dimB1B = radius1BA - YfromBottom;
			
			bkgrdStartXBA = bkgrdStartX + partDimB;// startingXBA+
			
			bkgrdStartYBA = bkgrdStartY + partDimB;// startingYBA;
			bkgrdWidthBA = 2 * radius1BA;
			bkgrdHeightBA = 2 * radius1BA;
			
			lengthBA = 2 * Math.PI * radius1BA * centralAngleBA / 360;// 2PIr*CentralAngle/360
			radius2BA = 0;
		} else {
			startingXBA = startingX + partDimB;
			// this.startingYBA = startingY +
			// this.myLevelShape.right.partDimB;
			
			myWidthBA =
						myLevelShape.widthPix
						- myLevelShape.right.partDimB
						- myLevelShape.left.partDimB;
			radius1BA = radius1 - partDimB;
			
			startXBA = startingXBA;// ingXBA;
			endXBA = endX - myLevelShape.right.partDimB;// this.startXBA
			// +
			// this.myWidthBA;
			double radiansStart = 0;
			double radianEnd = 0;
			if (myLevelShape.shapeID == 204
						|| myLevelShape.shapeID == 304) {
				final double deltaStartY =
							myLevelShape.bY2 - myLevelShape.parentStartY;
				radianEnd =
							Math
							.asin((myLevelShape.bot1.partDimB
										+ radius1 - (myLevelShape.heightPix + deltaStartY))
										/ radius1BA);
				
				final double base =
							Math
							.sqrt(Math.pow(radius1BA, 2)
										- Math
										.pow(
													(myLevelShape.bot1.partDimB
																+ radius1 - (myLevelShape.heightPix + deltaStartY)),
																2));
				startXBA = x1 - base;
				startYBA =
							startingY
							+ radius1
							- (myLevelShape.bot1.partDimB
										+ radius1 - (myLevelShape.heightPix + deltaStartY));
			} else {
				
				radianEnd =
							Math.acos((myLevelShape.widthPix
										+ myLevelShape.centerPointX
										- startingX
										- myLevelShape.widthPix - partDimB)
										/ radius1BA);
				
				if (Double.isNaN(radianEnd)) {
					radianEnd = 0;
				}
				
			}
			
			radiansStart =
						Math.acos((partDimB
									+ myLevelShape.centerPointX
									- startingX - myLevelShape.widthPix)
									/ radius1BA);
			
			centralAngleBA =
						Math.abs(Math.toDegrees(Math.abs(radianEnd
									- radiansStart)));
			
			startAngleBA = 180 - Math.toDegrees(radiansStart);// (180
			
			endAngleBA = centralAngleBA;
			
			final double yFullRadiusRight =
						myLevelShape.centerPointY - startingY;
			
			final double baseForYRight =
						myLevelShape.centerPointX
						- myLevelShape.bX2
						+ partDimB;// this.myLevelShape.right.partDimB;
			final double radiansYRight = Math.toRadians(startAngleBA);// (double)
			// Math.acos(baseForYRight/(this.radius1-this.partDimB));
			final double yRightBA =
						Math.abs(baseForYRight * Math.tan(radiansYRight));
			
			startingYBA = startingY + yFullRadiusRight - yRightBA;
			
			final double yFullRadiusLeft =
						myLevelShape.centerPointY - startingYBA;
			
			final double baseForYLeft =
						myLevelShape.centerPointX - startingX - partDimB;// this.myLevelShape.right.partDimB;
			final double radiansYLeft =
						Math.toRadians(startAngleBA + endAngleBA);// (double)
			// Math.acos(baseForYRight/(this.radius1-this.partDimB));
			final double yLeftBA =
						Math.abs(baseForYLeft * Math.tan(radiansYLeft));
			//
			if (myLevelShape.shapeID != 204
						&& myLevelShape.shapeID != 304) {
				startYBA = startingYBA + yFullRadiusLeft - yLeftBA;
			}
			endYBA = startingYBA;
			
			endYBA = startingYBA;// +
			// this.myLevelShape.dimB1;
			
			bkgrdStartXBA = bkgrdStartX + partDimB;// startingXBA+
			// this.myWidthBA/2
			// -
			// radius1BA;
			bkgrdStartYBA = bkgrdStartY + partDimB;// startingYBA;
			bkgrdWidthBA = 2 * radius1BA;
			bkgrdHeightBA = 2 * radius1BA;
			
			lengthBA = 2 * Math.PI * radius1BA * centralAngleBA / 360;// 2PIr*CentralAngle/360
			radius2BA = 0;
		}
		
	}
	
	public void arcEnd903A() { // int =1 Arc normal, 2 start
		
		// at 90, 3 end at
		// ninety
		
		partForm = 2;
		// First line for All levels
		if (!wire || myLevelShape.shapeChanged) {
			startingXA = startingXBA + partDimA;
			startingYA = startingYBA + partDimA;
			
			myWidthA =
						myLevelShape.widthPix
						* 2
						- 2
						* (partDimB + partDimA);
			radius1A = radius1BA - partDimA;
			
			startXA = startingXA;// ingXBA;
			endXA =
						startXA
						+ myLevelShape.widthPix
						- 2
						* (partDimA + partDimB);
			
			double radiansStart = 0;
			double radianEnd = 0;
			double YfromBottom2 = 0;
			double YfromBottom = 0;
			
			radiansStart =
						Math.acos((partDimA + partDimB) / radius1A);
			if (myLevelShape.shapeID == 204
						|| myLevelShape.shapeID == 304) {
				radianEnd =
							Math.asin((myLevelShape.bot1.partDimB
										+ myLevelShape.bot1.partDimA
										+ radius1 - myLevelShape.heightPix)
										/ radius1A);
				startYA =
							// this.myLevelShape.bY4
							// -
							// this.myLevelShape.bot1.partDimB;
							startingY
							+ radius1
							- (myLevelShape.bot1.partDimB
										+ myLevelShape.bot1.partDimA
										+ radius1 - myLevelShape.heightPix);
				final double base =
							Math
							.sqrt(Math.pow(radius1A, 2)
										- Math
										.pow(
													(myLevelShape.bot1.partDimB
																+ myLevelShape.bot1.partDimA
																+ radius1 - myLevelShape.heightPix),
																2));
				startXA = x1 - base;
				
			} else {
				radianEnd =
							Math
							.acos((myLevelShape.widthPix
										- partDimB - partDimA)
										/ radius1A);
				YfromBottom2 =
							Math
							.abs((myLevelShape.widthPix - (partDimA + partDimB))
										* Math.tan(radianEnd));
				startYA = startingYA + radius1A - YfromBottom2;
			}
			if (Double.isNaN(radianEnd)) {
				radianEnd = 0;
			}
			centralAngleA =
						Math
						.abs(Math.toDegrees(radianEnd
									- radiansStart));
			
			YfromBottom =
						Math.abs((partDimA + partDimB)
									* Math.tan(radiansStart));
			
			endYA = startingYA + radius1A - YfromBottom;
			
			dimB1B = radius1A - YfromBottom;
			// radianCentralAngle = (double)
			// Math.atan((this.myWidthBA / 2) /
			// (this.dimB1B));
			// centralAngleBA = (double)
			// Math.toDegrees(radianCentralAngle);
			// //
			// in
			// degrees
			
			startAngleA = 180 - Math.toDegrees(radiansStart);// (180
			// -
			// radiansStart)
			// / 2;//
			// centralAnglet1;//radiansStart;//radiansStart;
			endAngleA = centralAngleA;
			
			bkgrdStartXA = bkgrdStartXBA + partDimA;// startingXBA+
			// this.myWidthBA/2
			// -
			// radius1BA;
			bkgrdStartYA = bkgrdStartYBA + partDimA;// startingYBA;
			bkgrdWidthA = 2 * radius1A;
			bkgrdHeightA = 2 * radius1A;
			
			lengthA = 2 * Math.PI * radius1A * centralAngleA / 360;// 2PIr*CentralAngle/360
			
			radius2A = 0;
			
			ltAngle = Math.atan((endX - endXA) / (endY - endYA));
			rbAngle =
						Math
						.atan((startX - startXA)
									/ (startY - startYA));
		} else {
			startingXA = startingXBA + partDimA;
			// this.startingYA = startingYBA +
			// this.myLevelShape.left.partDimA;
			
			myWidthA =
						myWidthBA
						- myLevelShape.right.partDimA
						- myLevelShape.left.partDimA;
			radius1A = radius1BA - partDimA;
			
			startXA = startingXA;// ingXBA;
			endXA = startXA + myWidthA;
			double radiansStart = 0;
			double radianEnd = 0;
			radiansStart =
						Math.acos((myLevelShape.right.partDimB
									+ myLevelShape.right.partDimA
									+ myLevelShape.centerPointX
									- startingX - myLevelShape.widthPix)
									/ radius1A);
			if (myLevelShape.shapeID == 204
						|| myLevelShape.shapeID == 304) {
				
				final double deltaStartY =
							myLevelShape.bY2 - myLevelShape.parentStartY;
				radianEnd =
							Math
							.asin((myLevelShape.bot1.partDimB
										+ myLevelShape.bot1.partDimA
										+ radius1 - (myLevelShape.heightPix + deltaStartY))
										/ radius1A);
				
				final double base =
							Math
							.sqrt(Math.pow(radius1A, 2)
										- Math
										.pow(
													(myLevelShape.bot1.partDimB
																+ myLevelShape.bot1.partDimA
																+ radius1 - (myLevelShape.heightPix + deltaStartY)),
																2));
				startXA = x1 - base;
				startYA =
							startingY
							+ radius1
							- (myLevelShape.bot1.partDimB
										+ myLevelShape.bot1.partDimA
										+ radius1 - (myLevelShape.heightPix + deltaStartY));
				
			} else {
				radianEnd =
							Math
							.acos((myLevelShape.widthPix
										+ myLevelShape.centerPointX
										- startingX
										- myLevelShape.widthPix
										- myLevelShape.left.partDimB - myLevelShape.left.partDimA)
										/ radius1A);
				if (Double.isNaN(radianEnd)) {
					radianEnd = 0;
				}
				
			}
			
			centralAngleA =
						Math
						.abs(Math.toDegrees(radianEnd
									- radiansStart));
			
			startAngleA = 180 - Math.toDegrees(radiansStart);// (180
			// -
			// radiansStart)
			// / 2;//
			// centralAnglet1;//radiansStart;//radiansStart;
			endAngleA = centralAngleA;
			
			final double yFullRadius =
						myLevelShape.centerPointY - startingY;
			final double baseForYRight =
						myLevelShape.centerPointX
						- myLevelShape.bX2
						+ partDimB
						+ partDimA;// this.myLevelShape.right.partDimB
			// +
			// this.myLevelShape.right.partDimA;
			final double radiansYRight = Math.toRadians(startAngleA);// (double)
			// Math.acos(baseForYRight/(this.radius1-this.partDimB));
			final double yRightA =
						Math.abs(baseForYRight * Math.tan(radiansYRight));
			
			startingYA = startingY + yFullRadius - yRightA;
			
			final double yFullRadiusLeft =
						myLevelShape.centerPointY - startingYA;
			final double baseForYLeft =
						myLevelShape.centerPointX
						- startingX
						- myLevelShape.right.partDimB
						- myLevelShape.right.partDimA;
			final double radiansYLeft =
						Math.toRadians(startAngleA + endAngleA);// (double)
			// Math.acos(baseForYRight/(this.radius1-this.partDimB));
			final double yLeftA =
						Math.abs(baseForYLeft * Math.tan(radiansYLeft));
			if (myLevelShape.shapeID != 204
						&& myLevelShape.shapeID != 304) {
				startYA = startingYA + yFullRadiusLeft - yLeftA;
			}
			endYA = startingYA;
			
			// startYA = startingYA
			// +this.myLevelShape.dimD2; // or
			// dimD2
			//
			// endYA = startingYA;//+
			// this.myLevelShape.dimB1;
			
			bkgrdStartXA = bkgrdStartXBA + partDimA;// startingXBA+
			// this.myWidthBA/2
			// -
			// radius1BA;
			bkgrdStartYA = bkgrdStartYBA + partDimA;// startingYBA;
			bkgrdWidthA = 2 * radius1A;
			bkgrdHeightA = 2 * radius1A;
			
			lengthA = 2 * Math.PI * radius1A * centralAngleA / 360;// 2PIr*CentralAngle/360
			
			radius2A = 0;
			
			ltAngle =
						Math.atan(Math.abs(endX - endXA)
									/ Math.abs(endY - endYA));
			rbAngle =
						Math.atan(Math.abs(startX - startXA)
									/ Math.abs(startY - startYA));
		}
		
	}
	
	public void arcEnd901B_450() {
		
		partForm = 2;
		
		if (!wire || myLevelShape.shapeChanged) {
			startX = startingX;
			
			startY = startingY + myLevelShape.dimD2;
			
			endX = startX + myLevelShape.dimA1;
			
			endY = startingY;
			// (double) Math.sqrt((double)
			// Math.pow(this.myLevelShape.dimD2,
			// 2)
			// + (double)
			// Math.pow(this.myLevelShape.dimA1,
			// 2));
			if (myLevelShape.shapeID == 450
						|| myLevelShape.shapeID == 453) {
				radius1 = myLevelShape.widthPix;
			}
			if (myLevelShape.shapeID == 454
						|| myLevelShape.shapeID == 455) {
				radius1 = 4 * myLevelShape.widthPix / 5;
			}
			if (myLevelShape.shapeID == 456
						|| myLevelShape.shapeID == 457) {
				radius1 = 3.25f * myLevelShape.widthPix / 5;
			}
			if (myLevelShape.shapeID == 458
						|| myLevelShape.shapeID == 459) {
				radius1 = 5 * myLevelShape.widthPix / 4;
			}
			if (myLevelShape.shapeID == 460
						|| myLevelShape.shapeID == 461) {
				radius1 = 2 * myLevelShape.widthPix;
			}
			// h/ 2+ (((double)
			// Math.pow(widthofArc * 2, 2))
			// / (8 * h));
			radius2 = 0;
			
			x1 = startingX + radius1;
			y1 = startingY + myLevelShape.dimD2;// -
			// this.myLevelShape.dimB1;//
			// (t1R1-dimB1);//eyt1;//startingY+(t1R1-dimB1);
			// if(this.radius1 >
			// this.myLevelShape.wT){
			// double delta = this.radius1 -
			// this.myLevelShape.wT;
			// this.startY = this.startY +
			// delta;
			// y1 = y1 + delta;
			//
			// }
			x2 = endX;// startingX+w/2;
			y2 = endY;// startY;//
			// -(t1R1-dimB1);
			final double theta = Math.acos((x1 - endX) / radius1);
			// (double) Math.acos((this.endX -
			// this.x1) /
			// this.radius1);
			radianCentralAngle = theta;// -theta2;
			
			// this.radianCentralAngle = 2 *
			// (double) Math
			// .atan(((this.myLevelShape.dimD2 *
			// 2) / 2)
			// / (this.radius1 -
			// this.myLevelShape.dimA1));
			centralAngle = Math.toDegrees(radianCentralAngle); // in
			
			double radiansStart = Math.atan((x2 - x1) / (y2 - y1));
			radiansStart = Math.toDegrees(radiansStart);
			
			startAngle = 180 - centralAngle;// /
			// 2;//
			// centralAnglet1;//radiansStart;//radiansStart;
			endAngle = centralAngle;
			
			bkgrdWidth = 2 * radius1;
			bkgrdHeight = 2 * radius1;// this.myLevelShape.dimD2;
			
			focal1X = endX;// +
			// this.myLevelShape.wT / 2;
			focal1Y = endY + radius1;
			// + (double) Math.sqrt((double)
			// Math.pow(radius1,
			// 2) -
			// (double)
			// Math.pow((this.myLevelShape.wT*2) /
			// 2, 2));
			focal2X = focal1X;
			focal2Y = focal1Y;
			
			bkgrdStartX = x1 - radius1;// focal1X
			// - radius1;
			bkgrdStartY = y1 - radius1;
			
			// degrees
			// degrees
		} else {
			
		}
		rrSlope = (x2 - x1) / (y2 - y1);
		rrAngle = Math.abs(Math.atan(1 / rrSlope));
		
		rlSlope =
					(startingX - x1)
					/ (startingY + myLevelShape.dimD2 - y1);
		
		rlAngle = Math.abs(Math.atan(1 / rlSlope));
		// this.rbAngle=rlAngle;
		length = 2 * Math.PI * radius1 * centralAngle / 360;// 2PIr*CentralAngle/360
		
		radius2 = 0;
		
	}
	
	public void arcEnd902BA_450() { // int =1 Arc normal, 2
		
		// start at 90, 3 end
		// at ninety
		
		startXBA = startingX + partDimB;
		
		startYBA = startY;
		
		endXBA = endX;
		
		radius1BA = radius1 - partDimB;
		
		// h/ 2+ (((double) Math.pow(widthofArc * 2,
		// 2)) / (8
		// * h));
		radius2 = 0;
		
		x1BA = x1;// this.startXBA +
		// radius1BA;
		y1BA = y1;// this.startingY +
		// this.myLevelShape.dimD2;// -
		
		x2BA = endXBA;// startingX+w/2;
		
		final double theta = Math.acos((x1BA - endXBA) / radius1BA);
		// (double) Math.acos((this.endXBA -
		// this.x1BA) /
		// this.radius1BA);
		
		centralAngleBA = Math.toDegrees(theta); // in
		
		final double yfromBottom = (x1BA - endXBA) * Math.tan(theta);
		
		endYBA = startingY + myLevelShape.dimD2 - yfromBottom;
		y2BA = endYBA;// startY;//
		// -(t1R1-dimB1);
		startAngleBA = 180 - centralAngleBA;// / 2;//
		// centralAnglet1;//radiansStart;//radiansStart;
		endAngleBA = centralAngleBA;
		
		bkgrdWidthBA = 2 * radius1BA;
		bkgrdHeightBA = 2 * radius1BA;// this.myLevelShape.dimD2;
		
		bkgrdStartXBA = x1BA - radius1BA;// focal1X
		// -
		// radius1;
		bkgrdStartYBA = y1BA - radius1BA;
		lengthBA = 2 * Math.PI * radius1BA * centralAngleBA / 360;// 2PIr*CentralAngle/360
	}
	
	public void arcEnd903A_450() { // int =1 Arc normal, 2
		
		// start at 90, 3 end at
		
		startXA = startingX + partDimA + partDimB;
		
		startYA = startY;
		
		endXA = endX;
		
		radius1A = radius1BA - partDimA;
		// h/ 2+ (((double) Math.pow(widthofArc * 2,
		// 2)) / (8
		// * h));
		radius2 = 0;
		
		x1A = x1;// this.startXBA +
		// radius1BA;
		y1A = y1;// this.startingY +
		// this.myLevelShape.dimD2;// -
		
		x2A = endXA;// startingX+w/2;
		
		final double theta = Math.acos((x1A - endXA) / radius1A);
		// (double) Math.acos((this.endXA - this.x1A)
		// /
		// this.radius1A);
		
		centralAngleA = Math.toDegrees(theta); // in
		
		final double yfromBottom = (x1A - endXA) * Math.tan(theta);
		
		endYA = startingY + myLevelShape.dimD2 - yfromBottom;
		y2A = endYA;// startY;//
		// -(t1R1-dimB1);
		startAngleA = 180 - centralAngleA;// /
		// 2;//
		// centralAnglet1;//radiansStart;//radiansStart;
		endAngleA = centralAngleA;
		
		bkgrdWidthA = 2 * radius1A;
		bkgrdHeightA = 2 * radius1A;// this.myLevelShape.dimD2;
		
		bkgrdStartXA = x1A - radius1A;// focal1X
		// - radius1;
		bkgrdStartYA = y1A - radius1A;
		lengthA = 2 * Math.PI * radius1A * centralAngleA / 360;// 2PIr*CentralAngle/360
		
		radius2A = 0;
		
		ltAngle =
					Math.atan(Math.abs(endX - endXA)
								/ Math.abs(endY - endYA));
		rbAngle =
					Math.atan(Math.abs(startX - startXA)
								/ Math.abs(startY - startYA));
	}
	
	public void arcShape333_1B() { // int =1 Arc normal, 2
		
		// start at 90, 3 end at
		partForm = 2;
		startX = myLevelShape.startingX;
		startY = myLevelShape.startingY + myLevelShape.dimD2; // or
		endX = startX + myLevelShape.widthPix;
		endY = myLevelShape.startingY + myLevelShape.dimB1;
		radius1 = myLevelShape.radius1;
		radius2 = myLevelShape.radius2;
		x1 = myLevelShape.centerPointX;
		y1 = myLevelShape.centerPointY;
		x2 = myLevelShape.centerPointX2;
		y2 = myLevelShape.centerPointY2;
		centralAngle = myLevelShape.centralAngle;// (double)
		// Math.toDegrees(radianCentralAngle);
		rrSlope = (x2 - x1) / (y2 - y1);
		rrAngle = Math.abs(Math.atan(1 / rrSlope));
		rlSlope =
					(startingX - x1)
					/ (startingY + myLevelShape.dimD2 - y1);// /
		rlAngle = Math.abs(Math.atan(1 / rlSlope));
		startAngle = myLevelShape.startAngle;// (180
		// -
		// radiansStart)
		// /
		endAngle = centralAngle;
		bkgrdWidth = 2 * radius1;
		bkgrdHeight = 2 * radius1;
		focal1X = x1;// startX +
		// this.myLevelShape.wT / 2;
		focal1Y = y1;// startY
		focal2X = x2;// focal1X;
		focal2Y = y2;// focal1Y;
		bkgrdStartX = myLevelShape.bkgrdStartX;// focal1X
		// -
		// radius1;
		bkgrdStartY = myLevelShape.bkgrdStartY;// focal1Y
		// -
		// radius1;
		length = 2 * Math.PI * radius1 * centralAngle / 360;// 2PIr*CentralAngle/360
		radius2 = 0;
	}
	
	public void arcShape333_2BA() { // int =1 Arc normal, 2
		
		// start at 90, 3 end
		// at
		// ninety
		partForm = 2;
		// First line for All levels
		startingXBA = startingX + myLevelShape.left.partDimB;
		
		myWidthBA =
					myLevelShape.widthPix
					- myLevelShape.right.partDimB
					- myLevelShape.left.partDimB;
		
		startXBA = startingX + myLevelShape.left.partDimB;
		endXBA = endX - myLevelShape.right.partDimB;
		
		radius1BA = radius1 - partDimB;
		
		double radiansStart =
					Math
					.acos((startingX
								+ myLevelShape.widthPix
								- myLevelShape.centerPointX - myLevelShape.right.partDimB)
								/ radius1BA);
		
		radiansStart = Math.toDegrees(radiansStart);
		
		double radianEnd =
					Math
					.acos((myLevelShape.centerPointX - startingX - partDimB)
								/ radius1BA);
		
		radianEnd = Math.toDegrees(radianEnd);
		
		centralAngleBA = 180 - (radianEnd + radiansStart);
		
		startAngleBA = radiansStart;// (180 -
		// radiansStart)
		// / 2;//
		// centralAnglet1;//radiansStart;//radiansStart;
		endAngleBA = centralAngleBA;// /2;//180
		// -
		// (2*radiansStart);//centralAngleBA;
		
		final double yFullRadiusLeft =
					myLevelShape.centerPointY - startingYBA;
		
		final double baseForYLeft =
					myLevelShape.centerPointX
					- startingX
					- myLevelShape.right.partDimB;
		final double radiansYLeft =
					Math.toRadians(startAngleBA + endAngleBA);// (double)
		// Math.acos(baseForYRight/(this.radius1-this.partDimB));
		final double yLeftBA =
					Math.abs(baseForYLeft * Math.tan(radiansYLeft));
		
		startYBA = startingYBA + yFullRadiusLeft - yLeftBA;
		
		// this.startingYBA = startingY +
		// (yFullRadiusLeft-yLeftBA);
		
		final double yFullRadiusRight =
					myLevelShape.centerPointY - startingYBA;
		
		final double baseForYRight =
					myLevelShape.bX2
					- myLevelShape.centerPointX
					- myLevelShape.right.partDimB;
		
		final double radiansYRight = Math.toRadians(startAngleBA);// (double)
		// Math.acos(baseForYRight/(this.radius1-this.partDimB));
		
		final double yRightBA =
					Math.abs(baseForYRight * Math.tan(radiansYRight));
		
		// startYBA = startingYBA ;//+
		// (yFullRadiusRight-yRightBA);
		
		endYBA = startingYBA + yFullRadiusRight - yRightBA;
		
		bkgrdStartXBA = bkgrdStartX + partDimB;// startingXBA+
		// this.myWidthBA/2
		// - radius1BA;
		bkgrdStartYBA = bkgrdStartY + partDimB;// startingYBA;
		bkgrdWidthBA = 2 * radius1BA;
		bkgrdHeightBA = 2 * radius1BA;
		
		lengthBA = 2 * Math.PI * radius1BA * centralAngleBA / 360;// 2PIr*CentralAngle/360
		
		radius2BA = 0;
	}
	
	public void arcShape333_3A() { // int =1 Arc normal, 2
		
		// start at 90, 3 end at
		// ninety
		
		partForm = 2;
		startingXA =
					startingX
					+ myLevelShape.left.partDimB
					+ myLevelShape.left.partDimA;
		
		myWidthA =
					myLevelShape.widthPix
					- myLevelShape.right.partDimB
					- myLevelShape.left.partDimB
					- myLevelShape.right.partDimA
					- myLevelShape.left.partDimA;
		
		startXA =
					startingX
					+ myLevelShape.left.partDimB
					+ myLevelShape.left.partDimA;
		endXA =
					endX
					- myLevelShape.right.partDimB
					- myLevelShape.left.partDimA;
		
		radius1A = radius1 - partDimB - partDimA;
		
		double radiansStart =
					Math
					.acos((startingX
								+ myLevelShape.widthPix
								- myLevelShape.centerPointX
								- myLevelShape.right.partDimB - myLevelShape.right.partDimA)
								/ radius1A);
		
		radiansStart = Math.toDegrees(radiansStart);
		
		double radianEnd =
					Math.acos((myLevelShape.centerPointX
								- startingX
								- partDimB - partDimA)
								/ radius1A);
		
		radianEnd = Math.toDegrees(radianEnd);
		
		centralAngleA = 180 - (radianEnd + radiansStart);
		
		startAngleA = radiansStart;
		endAngleA = centralAngleA;// /2;//180
		// -
		final double yFullRadiusLeft =
					myLevelShape.centerPointY - startingYA;
		
		final double baseForYLeft =
					myLevelShape.centerPointX
					- startingX
					- myLevelShape.right.partDimB
					- myLevelShape.right.partDimA;
		final double radiansYLeft =
					Math.toRadians(startAngleA + endAngleA);// (double)
		// Math.acos(baseForYRight/(this.radius1-this.partDimB));
		final double yLeftA =
					Math.abs(baseForYLeft * Math.tan(radiansYLeft));
		
		startYA = startingYA + yFullRadiusLeft - yLeftA;
		final double yFullRadiusRight =
					myLevelShape.centerPointY - startingYA;
		
		final double baseForYRight =
					myLevelShape.bX2
					- myLevelShape.centerPointX
					- myLevelShape.right.partDimB
					- myLevelShape.right.partDimA;
		
		final double radiansYRight = Math.toRadians(startAngleA);// (double)
		// Math.acos(baseForYRight/(this.radius1-this.partDimB));
		final double yRightA =
					Math.abs(baseForYRight * Math.tan(radiansYRight));
		endYA = startingYA + yFullRadiusRight - yRightA;
		bkgrdStartXA = bkgrdStartX + partDimB + partDimA;// startingXBA+
		bkgrdStartYA = bkgrdStartY + partDimB + partDimA;// startingYBA;
		bkgrdWidthA = 2 * radius1A;
		bkgrdHeightA = 2 * radius1A;
		
		lengthBA = 2 * Math.PI * radius1A * centralAngleA / 360;// 2PIr*CentralAngle/360
		radius2A = 0;
		lengthA = 2 * Math.PI * radius1A * centralAngleA / 360;
		ltAngle = Math.atan((endX - endXA) / (endY - endYA));
		rbAngle = Math.atan((startX - startXA) / (startY - startYA));
	}
	
	public void arcShape3333_1B() { // int =1 Arc normal, 2
		
		// start at 90, 3 end
		// at
		// ninety
		partForm = 2;
		startX = myLevelShape.startingX;
		startY = myLevelShape.startingY + myLevelShape.dimD2; // or
		endX = startX + myLevelShape.widthPix;
		endY = myLevelShape.startingY + myLevelShape.dimB1;
		radius1 = myLevelShape.radius1;
		radius2 = myLevelShape.radius2;
		x1 = myLevelShape.centerPointX;
		y1 = myLevelShape.centerPointY;
		x2 = myLevelShape.centerPointX2;
		y2 = myLevelShape.centerPointY2;
		centralAngle = myLevelShape.centralAngle;// (double)
		// Math.toDegrees(radianCentralAngle);
		rrSlope = (x2 - x1) / (y2 - y1);
		rrAngle = Math.abs(Math.atan(1 / rrSlope));
		rlSlope =
					(startingX - x1)
					/ (startingY + myLevelShape.dimD2 - y1);// /
		rlAngle = Math.abs(Math.atan(1 / rlSlope));
		startAngle = myLevelShape.startAngle;// (180
		// -
		// radiansStart)
		// /
		endAngle = centralAngle;
		bkgrdWidth = 2 * radius1;
		bkgrdHeight = 2 * radius1;
		focal1X = x1;// startX +
		// this.myLevelShape.wT / 2;
		focal1Y = y1;// startY
		focal2X = x2;// focal1X;
		focal2Y = y2;// focal1Y;
		bkgrdStartX = myLevelShape.bkgrdStartX;// focal1X
		// -
		// radius1;
		bkgrdStartY = myLevelShape.bkgrdStartY;// focal1Y
		// -
		// radius1;
		length = 2 * Math.PI * radius1 * centralAngle / 360;// 2PIr*CentralAngle/360
		radius2 = 0;
	}
	
	public void arcShape3333_2BA() { // int =1 Arc normal, 2
		
		// start at 90, 3 end
		// at
		// ninety
		partForm = 2;
		// First line for All levels
		startingXBA = startingX + myLevelShape.left.partDimB;
		startingYBA = myLevelShape.startingY + partDimB;
		myWidthBA =
					myLevelShape.widthPix
					- myLevelShape.right.partDimB
					- myLevelShape.left.partDimB;
		
		startXBA = startingX + myLevelShape.left.partDimB;
		endXBA = endX - myLevelShape.right.partDimB;
		
		radius1BA = radius1 - partDimB;
		
		double radiansStart =
					Math
					.acos((myLevelShape.bX2
								- myLevelShape.centerPointX - myLevelShape.right.partDimB)
								/ radius1BA);
		
		radiansStart = Math.toDegrees(radiansStart);
		
		double radianEnd =
					Math
					.acos((myLevelShape.centerPointX - startingX - partDimB)
								/ radius1BA);
		
		radianEnd = Math.toDegrees(radianEnd);
		
		centralAngleBA = 180 - (radianEnd + radiansStart);
		
		startAngleBA = radiansStart;// (180 -
		// radiansStart)
		// / 2;//
		// centralAnglet1;//radiansStart;//radiansStart;
		endAngleBA = centralAngleBA;// /2;//180
		// -
		// (2*radiansStart);//centralAngleBA;
		
		final double yFullRadiusLeft =
					myLevelShape.centerPointY - startingYBA;
		
		final double baseForYLeft =
					myLevelShape.centerPointX
					- startingX
					- myLevelShape.right.partDimB;
		final double radiansYLeft =
					Math.toRadians(startAngleBA + endAngleBA);// (double)
		// Math.acos(baseForYRight/(this.radius1-this.partDimB));
		final double yLeftBA =
					Math.abs(baseForYLeft * Math.tan(radiansYLeft));
		
		startYBA = startingYBA + yFullRadiusLeft - yLeftBA;
		
		// this.startingYBA = startingY +
		// (yFullRadiusLeft-yLeftBA);
		
		final double yFullRadiusRight =
					myLevelShape.centerPointY - startingYBA;
		
		final double baseForYRight =
					myLevelShape.bX2
					- myLevelShape.centerPointX
					- myLevelShape.right.partDimB;
		
		final double radiansYRight = Math.toRadians(startAngleBA);// (double)
		// Math.acos(baseForYRight/(this.radius1-this.partDimB));
		
		final double yRightBA =
					Math.abs(baseForYRight * Math.tan(radiansYRight));
		
		// startYBA = startingYBA ;//+
		// (yFullRadiusRight-yRightBA);
		
		endYBA = startingYBA + yFullRadiusRight - yRightBA;
		
		bkgrdStartXBA = bkgrdStartX + partDimB;// startingXBA+
		// this.myWidthBA/2
		// - radius1BA;
		bkgrdStartYBA = bkgrdStartY + partDimB;// startingYBA;
		bkgrdWidthBA = 2 * radius1BA;
		bkgrdHeightBA = 2 * radius1BA;
		
		lengthBA = 2 * Math.PI * radius1BA * centralAngleBA / 360;// 2PIr*CentralAngle/360
		
		radius2BA = 0;
	}
	
	public void arcShape3333_3A() { // int =1 Arc normal, 2
		
		// start at 90, 3 end
		// at
		// ninety
		
		partForm = 2;
		startingXA =
					startingX
					+ myLevelShape.left.partDimB
					+ myLevelShape.left.partDimA;
		startingYA = startingYBA + partDimA;
		myWidthA =
					myLevelShape.widthPix
					- myLevelShape.right.partDimB
					- myLevelShape.left.partDimB
					- myLevelShape.right.partDimA
					- myLevelShape.left.partDimA;
		
		startXA =
					startingX
					+ myLevelShape.left.partDimB
					+ myLevelShape.left.partDimA;
		endXA =
					endX
					- myLevelShape.right.partDimB
					- myLevelShape.left.partDimA;
		
		radius1A = radius1 - partDimB - partDimA;
		
		double radiansStart =
					Math
					.acos((startingX
								+ myLevelShape.widthPix
								- myLevelShape.centerPointX
								- myLevelShape.right.partDimB - myLevelShape.right.partDimA)
								/ radius1A);
		
		radiansStart = Math.toDegrees(radiansStart);
		
		double radianEnd =
					Math.acos((myLevelShape.centerPointX
								- startingX
								- partDimB - partDimA)
								/ radius1A);
		
		radianEnd = Math.toDegrees(radianEnd);
		
		centralAngleA = 180 - (radianEnd + radiansStart);
		
		startAngleA = radiansStart;// (180 -
		// radiansStart) /
		// 2;//
		// centralAnglet1;//radiansStart;//radiansStart;
		endAngleA = centralAngleA;// /2;//180
		// -
		// (2*radiansStart);//centralAngleBA;
		
		final double yFullRadiusLeft =
					myLevelShape.centerPointY - startingYA;
		
		final double baseForYLeft =
					myLevelShape.centerPointX
					- startingX
					- myLevelShape.right.partDimB
					- myLevelShape.right.partDimA;
		final double radiansYLeft =
					Math.toRadians(startAngleA + endAngleA);// (double)
		// Math.acos(baseForYRight/(this.radius1-this.partDimB));
		final double yLeftA =
					Math.abs(baseForYLeft * Math.tan(radiansYLeft));
		
		startYA = startingYA + yFullRadiusLeft - yLeftA;
		
		// this.startingYBA = startingY +
		// (yFullRadiusLeft-yLeftBA);
		
		final double yFullRadiusRight =
					myLevelShape.centerPointY - startingYA;
		
		final double baseForYRight =
					myLevelShape.bX2
					- myLevelShape.centerPointX
					- myLevelShape.right.partDimB
					- myLevelShape.right.partDimA;
		
		final double radiansYRight = Math.toRadians(startAngleA);// (double)
		// Math.acos(baseForYRight/(this.radius1-this.partDimB));
		
		final double yRightA =
					Math.abs(baseForYRight * Math.tan(radiansYRight));
		
		// startYBA = startingYBA ;//+
		// (yFullRadiusRight-yRightBA);
		
		endYA = startingYA + yFullRadiusRight - yRightA;
		
		bkgrdStartXA = bkgrdStartX + partDimB + partDimA;// startingXBA+
		// this.myWidthBA/2
		// -
		// radius1BA;
		bkgrdStartYA = bkgrdStartY + partDimB + partDimA;// startingYBA;
		bkgrdWidthA = 2 * radius1A;
		bkgrdHeightA = 2 * radius1A;
		radius2A = 0;
		lengthA = 2 * Math.PI * radius1A * centralAngleA / 360;
		ltAngle = Math.atan((endX - endXA) / (endY - endYA));
		rbAngle = Math.atan((startX - startXA) / (startY - startYA));
		
	}
	
	public void ellipse1B() {
		
		partForm = 3;
		parentW = myLevelShape.parentW;
		startX = startingX;
		startY = startingY + myLevelShape.dimB1;
		endX = startX + myLevelShape.widthPix;
		endY = startY;
		
		if (myLevelShape.widthPix / 2 > myLevelShape.dimB1) {
			
			radius1 = myLevelShape.dimB1;
			
			focal1X =
						startX
						+ myLevelShape.widthPix
						/ 2
						- Math
						.sqrt(Math
									.pow(
												myLevelShape.widthPix / 2,
												2)
												- Math
												.pow(
															myLevelShape.dimB1,
															2));
			focal1Y = startY;
			focal2X =
						focal1X
						+ 2
						* Math
						.sqrt(Math
									.pow(
												myLevelShape.widthPix / 2,
												2)
												- Math
												.pow(
															myLevelShape.dimB1,
															2));
			focal2Y = startY;
			bkgrdStartX = startingX;
			bkgrdStartY = focal1Y - radius1;
			radius2 =
						myLevelShape.widthPix
						/ 2
						- Math
						.sqrt(Math
									.pow(
												myLevelShape.widthPix / 2,
												2)
												- Math
												.pow(
															myLevelShape.dimB1,
															2));
			final double sinCentralAngle =
						myLevelShape.dimB1 / radius1; // opposite/Hypotenus
			centralAngle = Math.asin(sinCentralAngle) * 2;
			
			startAngle = 0;
			endAngle = 180;
			
			bkgrdWidth = myLevelShape.widthPix;
			bkgrdHeight = 2 * myLevelShape.dimB1;
			final double a = myLevelShape.widthPix / 2;
			final double b = myLevelShape.dimB1;
			length = // (double) Math.PI*
						// (3a + 3b -
						// sqrt[(a+3b)(b+3a)])
						Math.PI
						* (3 * a + 3 * b - Math.sqrt((a + 3 * b)
									* (b + 3 * a)));
			
		} else if (myLevelShape.dimB1 > myLevelShape.widthPix / 2) {
			radius1 = myLevelShape.widthPix / 2; //
			
			focal1X = startX + myLevelShape.widthPix / 2;
			focal1Y =
						startY
						- Math
						.sqrt(Math.pow(
									myLevelShape.dimB1,
									2)
									- Math
									.pow(
												myLevelShape.widthPix / 2,
												2));
			focal2X = focal1X;
			focal2Y =
						startY
						+ Math
						.sqrt(Math.pow(
									myLevelShape.dimB1,
									2)
									- Math
									.pow(
												myLevelShape.widthPix / 2,
												2));
			bkgrdStartX = startingX;
			bkgrdStartY = startingY;
			final double sinCentralAngle =
						myLevelShape.dimB1 / radius1; // opposite/Hypotenus
			centralAngle = Math.asin(sinCentralAngle) * 2;
			
			startAngle = 0;
			endAngle = 180;
			
			bkgrdWidth = myLevelShape.widthPix;
			bkgrdHeight = 2 * myLevelShape.dimB1;
			radius2 =
						myLevelShape.dimB1
						- Math
						.sqrt(Math
									.pow(
												myLevelShape.widthPix / 2,
												2)
												- Math
												.pow(
															myLevelShape.dimB1,
															2));
			
			// length=PI*(a+b)*(1+1/4h+1/64h^2+1/256h3+25/16384h^4)
			
			final double h1 =
						Math
						.pow(
									(myLevelShape.dimB1 - myLevelShape.widthPix / 2),
									2)
									/ Math
									.pow(
												(myLevelShape.dimB1 + myLevelShape.widthPix / 2),
												2);
			final double factorial =
						1
						+ 0.25f
						* h1
						+ 1
						/ 64
						* (Math.pow(h1, 2)
									+ 1
									/ 256
									* Math.pow(h1, 3) + 25 / 16384 * Math
									.pow(h1, 4));
			length =
						Math.PI
						* (myLevelShape.widthPix / 2 + myLevelShape.dimB1)
						* factorial;
		}
		
		x1 = startX + myLevelShape.widthPix / 2;
		y1 = startY;
		//
	}
	
	public void ellipse2BA() {
		
		partForm = 3;
		myWidthBA =
					myLevelShape.widthPix
					- (myLevelShape.left.partDimB + myLevelShape.right.partDimB);
		startXBA = startingX + myLevelShape.left.partDimB;
		startYBA = startY;
		// this.startYBA = this.startingY +
		// this.myLevelShape.dimD2;
		// + this.myLevelShape.left.partDimB;
		// this.dimB1B = this.myLevelShape.dimB1 -
		// this.partDimB;
		endXBA = endX - myLevelShape.right.partDimB;
		endYBA = endY;
		
		//
		// if (this.myWidthBA / 2 > this.dimB1B) {
		//
		// this.radius1BA = this.dimB1B;
		//
		// // this.focal1XBA = focal1X;
		// // this.focal1YBA = focal1Y+
		// this.partDimB;
		// // this.focal2XBA = focal2X;
		// // this.focal2YBA = focal2Y+
		// this.partDimB;
		//
		//
		// this.focal1XBA = this.startXBA
		// + ((this.myWidthBA/2) - (double)
		// Math.sqrt((double)
		// Math.pow(
		// this.myWidthBA / 2, 2)
		// - (double) Math.pow(this.dimB1B, 2)));
		// this.focal1YBA = this.startYBA;
		// this.focal2XBA = this.focal1XBA
		// + (2 * ((double) Math.sqrt((double)
		// Math.pow(this.myWidthBA / 2, 2)
		// - (double) Math.pow(this.dimB1B, 2))));
		// this.focal2YBA = this.startYBA;
		//
		// // /* R semi major r semi minor
		// // * x any point on ellipse (Working
		// Point)
		// // * equation of ellipse = x2 / R2 + y2 /
		// r2 = 1
		// // * x(oval) = R cos (Eccentric Angle) +
		// d cos
		// (arctan (R tan
		// (Eccentric Angle)/r))
		// // * y(oval) = r sin (Eccentric Angle) +
		// d sin
		// (arctan (R tan
		// (Eccentric Angle)/r))
		// // * where:
		// // * Eccentric Angle = arccos (x/R) =
		// arccos
		// (22/30) = 42.83343
		// // * Eccentric Angle = arcsin (y/r) =
		// arcsin
		// (13.597385/20) =
		// 42.83343
		// // * 20�sqrt(30^2 � 22^2)/30
		// // */
		// double myWorkingX = this.myWidthBA / 2;
		// // double myWorkingY = radius1 * ((double)
		// Math.sqrt(
		// // (((double)
		// Math.pow(this.myLevelShape.wT/2, 2)
		// -
		// // (double) Math.pow(myWorkingX,2))))) /
		// (this.myLevelShape.wT/2);
		// // double eccentricAngle =
		// (double)
		// Math.asin(myWorkingX/(this.myLevelShape.wT/2));
		// //
		// // double xp = ((this.myLevelShape.wT/2) *
		// // (double) Math.cos(eccentricAngle)) +
		// // ( this.partDimB *
		// // (double) Math.cos((double) Math.atan(
		// // (((this.myLevelShape.wT/2) *
		// // (double)
		// Math.tan(eccentricAngle))/this.radius1))));
		// //
		// // double yp = ((radius1) *
		// // (double) Math.sin(eccentricAngle)) +
		// // ( this.partDimB *
		// // (double) Math.sin((double) Math.atan(
		// // (((this.myLevelShape.wT/2) *
		// // (double)
		// Math.tan(eccentricAngle))/this.radius1))));
		//
		//
		// this.bkgrdStartXBA = bkgrdStartX +
		// this.partDimB;//this.startXBA;
		// this.bkgrdStartYBA = bkgrdStartY
		// +this.partDimB;//this.focal1YBA -
		// this.radius1BA;
		//
		// this.radius2BA = radius2 - this.partDimB;
		//
		// double sinCentralAngle = this.dimB1B /
		// this.radius1BA; //
		// opposite/Hypotenus
		// this.centralAngleBA = ((double)
		// Math.asin(sinCentralAngle)) * 2;
		// this.startAngleBA = 0;
		// this.endAngleBA = 180;
		//
		// this.bkgrdWidthBA = this.myWidthBA;
		// this.bkgrdHeightBA = 2 * this.dimB1B ;
		//
		// // this.bkgrdWidthBA =
		// this.myLevelShape.wT;
		// // this.bkgrdHeightBA = 2 *
		// this.myLevelShape.dimB1;
		//
		//
		// //
		// p=PI*(a+b)*(1+1/4h+1/64h^2+1/256h3+25/16384h^4)
		// double h1 = (double)
		// Math.pow((this.myWidthBA / 2 -
		// this.dimB1B), 2)
		// / (double) Math.pow((this.myWidthBA / 2 +
		// this.dimB1B), 2);
		// double factorial = 1+ ((0.25 * h1)+ 1/64)
		// *
		// (((double) Math.pow(h1, 2) + 1 / 256) *
		// (((double)
		// Math.pow(h1, 3)) +
		// 25 / 16384) *
		// ((double) Math.pow(h1, 4)));
		// this.lengthBA = (double) Math.PI *
		// (this.myWidthBA
		// / 2 + this.dimB1B)*
		// factorial;
		// }
		//
		// else if (this.dimB1B > this.myWidthBA /
		// 2) {
		// this.radius1BA = this.myWidthBA / 2; //
		//
		// this.focal1XBA = this.startXBA +
		// (this.myWidthBA
		// / 2);
		// this.focal1YBA = this.startYBA
		// - (double) Math.sqrt((double)
		// Math.pow(this.dimB1B,
		// 2)
		// - (double) Math.pow(this.myWidthBA / 2,
		// 2));
		// this.focal2XBA = this.focal1XBA;
		// this.focal2YBA = this.startYBA
		// + (double) Math.sqrt((double)
		// Math.pow(this.dimB1B,
		// 2)
		// - (double) Math.pow(this.myWidthBA / 2,
		// 2));
		// this.bkgrdStartXBA = this.startingXBA;
		// this.bkgrdStartYBA = this.focal1YBA -
		// this.radius1BA;
		// double sinCentralAngle = this.dimB1B /
		// this.radius1BA; //
		// opposite/Hypotenus
		// this.centralAngleBA = ((double)
		// Math.asin(sinCentralAngle)) * 2;
		// this.startAngleBA = 0;
		// this.endAngleBA = 180;
		// this.bkgrdWidthBA = this.myWidthBA;
		// this.bkgrdHeightBA = 2 * this.dimB1B;
		// this.radius2BA = this.dimB1B
		// - (double) Math.sqrt((double)
		// Math.pow(this.myWidthBA / 2, 2)
		// - (double) Math.pow(this.dimB1B, 2));
		//
		// //
		// p=PI*(a+b)*(1+1/4h+1/64h^2+1/256h3+25/16384h^4)
		// double h1 = (double) Math.pow(
		// (this.myLevelShape.dimB1 - this.myWidthBA
		// / 2),
		// 2)
		// / (double) Math.pow((this.dimB1B +
		// this.myWidthBA
		// / 2), 2);
		// double factorial = 1
		// + (0.25 * h1)
		// + 1
		// / 64
		// * ((double) Math.pow(h1, 2) + 1 / 256 *
		// ((double)
		// Math.pow(h1, 3)) + 25
		// / 16384 * ((double) Math
		// .pow(h1, 4)));
		// this.lengthBA = (double) Math.PI *
		// (this.myWidthBA
		// / 2 + this.dimB1B)
		// * factorial;
		// }
	}
	
	public void ellipse3A() {
		
		// this.partForm = 3;
		// this.myWidthA = this.myLevelShape.wT -
		// (this.myLevelShape.left.partDimB+
		// this.myLevelShape.right.partDimB)-
		// (this.myLevelShape.left.partDimA+
		// this.myLevelShape.right.partDimA);
		startXA =
					startingX
					+ myLevelShape.left.partDimB
					+ myLevelShape.left.partDimA;
		startYA = startY;
		// + this.myLevelShape.left.partDimB;
		// this.dimB1A = this.myLevelShape.dimB1 -
		// this.partDimB-this.partDimA;
		endXA = endXBA - myLevelShape.right.partDimA;
		endYA = endY;
		
		//
		// if (this.myWidthA / 2 > this.dimB1A) {
		//
		// this.radius1A = this.dimB1A;
		//
		// this.focal1XA = this.startXA
		// + ((this.myWidthA/2) - (double)
		// Math.sqrt((double)
		// Math.pow(
		// this.myWidthA / 2, 2)
		// - (double) Math.pow(this.dimB1A, 2)));
		// this.focal1YA = this.startYA;
		// this.focal2XA = this.focal1XA
		// + (2 * ((double) Math.sqrt((double)
		// Math.pow(this.myWidthA / 2, 2)
		// - (double) Math.pow(this.dimB1A, 2))));
		// this.focal2YA = this.startYA;
		//
		// // this.focal1X = this.startX
		// // + ((this.myLevelShape.wT / 2) -
		// (double)
		// Math.sqrt((double)
		// Math.pow(
		// // this.myLevelShape.wT / 2, 2)
		// // - (double)
		// Math.pow(this.myLevelShape.dimB1,
		// 2)));
		// // this.focal1Y = this.startY;
		// // this.focal2X = this.focal1X
		// // + (2 * (double) Math.sqrt((double)
		// Math.pow(this.myLevelShape.wT /
		// 2, 2)
		// // - (double)
		// Math.pow(this.myLevelShape.dimB1,
		// 2)));
		// // this.focal2Y = this.startY;
		//
		//
		// this.bkgrdStartXA = this.startXA;
		// this.bkgrdStartYA = this.focal1YA -
		// this.radius1A;
		// this.radius2A = this.myWidthA
		// / 2
		// - (double) Math.sqrt((double)
		// Math.pow(this.myWidthA / 2, 2)
		// - (double) Math.pow(this.dimB1A, 2));
		// double sinCentralAngle = this.dimB1A /
		// this.radius1A; //
		// opposite/Hypotenus
		// this.centralAngleA = ((double)
		// Math.asin(sinCentralAngle)) * 2;
		// this.startAngleA = 0;
		// this.endAngleA = 180;
		// this.bkgrdWidthA = this.myWidthA;
		// this.bkgrdHeightA = 2 * this.dimB1A;
		// //
		// p=PI*(a+b)*(1+1/4h+1/64h^2+1/256h3+25/16384h^4)
		// double h1 = (double)
		// Math.pow((this.myWidthA / 2 -
		// this.dimB1A), 2)
		// / (double) Math.pow((this.myWidthA / 2 +
		// this.dimB1A), 2);
		// double factorial = 1
		// + (0.25 * h1)
		// + 1
		// / 64
		// * ((double) Math.pow(h1, 2) + 1 / 256 *
		// ((double)
		// Math.pow(h1, 3)) + 25
		// / 16384 * ((double) Math
		// .pow(h1, 4)));
		// this.lengthA = (double) Math.PI *
		// (this.myWidthA /
		// 2 + this.dimB1A)
		// * factorial;
		// }
		//
		// else if (this.dimB1A > this.myWidthA / 2)
		// {
		// this.radius1A = this.myWidthA / 2; //
		//
		// this.focal1XA = this.startXA +
		// (this.myWidthA /
		// 2);
		// this.focal1YA = this.startYA
		// - (double) Math.sqrt((double)
		// Math.pow(this.dimB1A,
		// 2)
		// - (double) Math.pow(this.myWidthA / 2,
		// 2));
		// this.focal2XA = this.focal1XA;
		// this.focal2YA = this.startYA
		// + (double) Math.sqrt((double)
		// Math.pow(this.dimB1A,
		// 2)
		// - (double) Math.pow(this.myWidthA / 2,
		// 2));
		// this.bkgrdStartXA = this.startingXA;
		// this.bkgrdStartYA = this.focal1YA -
		// this.radius1A;
		// double sinCentralAngle = this.dimB1A /
		// this.radius1A; //
		// opposite/Hypotenus
		// this.centralAngleA = ((double)
		// Math.asin(sinCentralAngle)) * 2;
		// this.startAngleA = 0;
		// this.endAngleA = 180;
		// this.bkgrdWidthA = this.myWidthA;
		// this.bkgrdHeightA = 2 * this.dimB1A;
		// this.radius2A = this.dimB1A
		// - (double) Math.sqrt((double)
		// Math.pow(this.myWidthA / 2, 2)
		// - (double) Math.pow(this.dimB1A, 2));
		//
		// //
		// p=PI*(a+b)*(1+1/4h+1/64h^2+1/256h3+25/16384h^4)
		// double h1 = (double) Math.pow(
		// (this.myLevelShape.dimB1 - this.myWidthA
		// / 2), 2)
		// / (double) Math.pow((this.dimB1A +
		// this.myWidthA /
		// 2), 2);
		// double factorial = 1
		// + (0.25 * h1)
		// + 1
		// / 64
		// * ((double) Math.pow(h1, 2) + 1 / 256 *
		// ((double)
		// Math.pow(h1, 3)) + 25
		// / 16384 * ((double) Math
		// .pow(h1, 4)));
		// this.lengthA = (double) Math.PI *
		// (this.myWidthA /
		// 2 + this.dimB1A)
		// * factorial;
		// }
	}
	
	public void ellipse1B_401() {
		
		partForm = 3;
		parentW = myLevelShape.parentW;
		startX = myLevelShape.startingX;
		startY = myLevelShape.startingY + myLevelShape.dimD2;
		endX = startX + myLevelShape.widthPix;
		endY = myLevelShape.startingY;// +
		// this.myLevelShape.dimB1;
		myWidth = myLevelShape.widthPix;
		if (!myLevelShape.wire) {
			parentW = myLevelShape.widthPix * 2;
			myWidth = myLevelShape.widthPix * 2;
		}
		if (parentW / 2 >= myLevelShape.dimD2) {
			
			radius1 = myLevelShape.parentRadius1;// this.myLevelShape.startingY
			// - this.endY;
			if (!myLevelShape.wire) {
				radius1 = myLevelShape.dimD2;
			}
			// this.focal1X = this.startX
			// + ((myWidth / 2) - (double)
			// Math.sqrt((double)
			// Math.pow(
			// myWidth / 2, 2)
			// - (double)
			// Math.pow(this.myLevelShape.dimD2,
			// 2)));
			// this.focal1Y = this.startY;
			// this.focal2X = this.focal1X
			// + (2 * (double) Math.sqrt((double)
			// Math.pow(myWidth / 2, 2)
			// - (double)
			// Math.pow(this.myLevelShape.dimD2,
			// 2)));
			// this.focal2Y = this.startY;
			bkgrdStartX = myLevelShape.parentStartX;
			bkgrdStartY = myLevelShape.parentStartY;
			radius2 =
						parentW
						/ 2
						- Math.sqrt(Math.pow(parentW / 2, 2)
									- Math.pow(radius1, 2));
			
			// this.radius2 = myWidth
			// / 2
			// - (double) Math.sqrt((double)
			// Math.pow(myWidth
			// / 2, 2)
			// - (double)
			// Math.pow(this.myLevelShape.dimD2,
			// 2));
			// double sinCentralAngle =
			// this.myLevelShape.dimD2 /
			// this.radius1;
			// // opposite/Hypotenus
			// this.centralAngle = ((double)
			// Math.asin(sinCentralAngle)) * 2;
			//
			// double myBase = (this.startingX +
			// this.myLevelShape.centerPointX)
			// - (this.startingX + myWidth);
			
			startAngle = myLevelShape.startAngle;// thetaOnCircle;//this.myLevelShape.startAngle;
			endAngle = 180 - startAngle;// this.myLevelShape.endAngle;
			
			bkgrdWidth = myLevelShape.parentW;
			bkgrdHeight = myLevelShape.radius1 * 2;
			
			if (!myLevelShape.wire) {
				startX = myLevelShape.startingX;
				startY = myLevelShape.startingY + myLevelShape.dimD2;
				endX = startX + myLevelShape.widthPix;
				endY = myLevelShape.startingY;// +
				// this.myLevelShape.dimB1;
				bkgrdStartX = myLevelShape.startingX;
				bkgrdStartY = myLevelShape.startingY;
				startAngle = 0;// thetaOnCircle;//this.myLevelShape.startAngle;
				endAngle = 180;// this.myLevelShape.endAngle;
				
				bkgrdWidth = myWidth;
				bkgrdHeight = radius1 * 2;
			}
			
			// p=PI*(a+b)*(1+1/4h+1/64h^2+1/256h3+25/16384h^4)
			final double h1 =
						Math.pow((myWidth / 2 - myLevelShape.dimD2), 2)
						/ Math
						.pow(
									(myWidth / 2 + myLevelShape.dimD2),
									2);
			final double factorial =
						1
						+ 0.25f
						* h1
						+ 1
						/ 64
						* (Math.pow(h1, 2)
									+ 1
									/ 256
									* Math.pow(h1, 3) + 25 / 16384 * Math
									.pow(h1, 4));
			length =
						Math.PI
						* (myWidth / 2 + myLevelShape.dimD2)
						* factorial;
		} else if (myLevelShape.dimD2 > myLevelShape.widthPix / 2) {
			radius1 = myLevelShape.widthPix / 2; //
			
			focal1X = startX + myLevelShape.widthPix / 2;
			focal1Y =
						startY
						- Math
						.sqrt(Math.pow(
									myLevelShape.dimB1,
									2)
									- Math
									.pow(
												myLevelShape.widthPix / 2,
												2));
			focal2X = focal1X;
			focal2Y =
						startY
						+ Math
						.sqrt(Math.pow(
									myLevelShape.dimB1,
									2)
									- Math
									.pow(
												myLevelShape.widthPix / 2,
												2));
			bkgrdStartX = startingX;
			bkgrdStartY = startingY;
			final double sinCentralAngle =
						myLevelShape.dimB1 / radius1; // opposite/Hypotenus
			centralAngle = Math.asin(sinCentralAngle) * 2;
			startAngle = 0;
			endAngle = 180;
			bkgrdWidth = myLevelShape.parentW;
			bkgrdHeight = 2 * radius1;
			radius2 =
						myLevelShape.dimB1
						- Math
						.sqrt(Math
									.pow(
												myLevelShape.widthPix / 2,
												2)
												- Math
												.pow(
															myLevelShape.dimB1,
															2));
			
			// length=PI*(a+b)*(1+1/4h+1/64h^2+1/256h3+25/16384h^4)
			
			final double h1 =
						Math
						.pow(
									(myLevelShape.dimB1 - myLevelShape.widthPix / 2),
									2)
									/ Math
									.pow(
												(myLevelShape.dimB1 + myLevelShape.widthPix / 2),
												2);
			final double factorial =
						1
						+ 0.25f
						* h1
						+ 1
						/ 64
						* (Math.pow(h1, 2)
									+ 1
									/ 256
									* Math.pow(h1, 3) + 25 / 16384 * Math
									.pow(h1, 4));
			length =
						Math.PI
						* (myLevelShape.widthPix / 2 + myLevelShape.dimB1)
						* factorial;
		}
		
		x1 = startX + myLevelShape.parentW / 2;
		y1 = startY;
		//
		
	}
	
	public void ellipse2BA_401() {
		
		partForm = 3;
		// this.myWidthBA =
		// this.myLevelShape.parentW -
		// (this.myLevelShape.left.partDimB+
		// this.myLevelShape.right.partDimB);
		startXBA = startingX + myLevelShape.left.partDimB;
		startYBA = startY;// +
		// this.partDimB;
		
		endXBA = endX - myLevelShape.right.partDimB;
		endYBA = endY + partDimB;
		
		if (myLevelShape.leftIn && myLevelShape.wire) {
			
			final double theta =
						Math.acos(startXBA / (myWidthBA / 2));
			startYBA =
						Math
						.abs((myLevelShape.parentRadius1 / 2 - partDimB)
									* Math.sin(theta));
			// this.myLevelShape.dimD2;
			
		}
		this.topFormElliptical(2);
	}
	
	public void ellipse3A_401() {
		
		partForm = 3;
		// this.myWidthBA =
		// this.myLevelShape.parentW -
		// (this.myLevelShape.left.partDimB+
		// this.myLevelShape.right.partDimB);
		
		startXA = startXBA + myLevelShape.left.partDimA;
		startYA = startYBA;// +
		// this.partDimA;
		
		endXA = endXBA - myLevelShape.right.partDimA;
		endYA = endYBA + partDimA;
		// if(this.myLevelShape.leftIn){
		// this.startYA = endYA +
		// (this.myLevelShape.dimD2);
		// }
		if (myLevelShape.leftIn && myLevelShape.wire) {
			final double theta = Math.acos(startXA / (myWidthA / 2));
			startYA =
						Math.abs((myLevelShape.parentRadius1
									/ 2
									- partDimA - partDimB)
									* Math.sin(theta));// +
		}
		// if (this.myLevelShape.leftIn &&
		// this.myLevelShape.wire) {
		// double theta = (double)
		// Math.acos(this.endXA
		// / (this.myLevelShape.parentW / 2));
		// this.endYA =
		// Math.abs((this.myLevelShape.parentRadius1
		// / 2)
		// * (double) Math.sin(theta))
		// + this.myLevelShape.dimD2;
		// }
		this.topFormElliptical(3);
	}
	
	public void ellipse1B_402() {
		
		partForm = 3;
		startX = myLevelShape.startingX;
		startY = myLevelShape.startingY;
		endX = startX + myLevelShape.widthPix;
		endY = myLevelShape.startingY + myLevelShape.dimB1;
		myWidth = parentW = myLevelShape.parentW;
		if (!myLevelShape.wire) {
			parentW = myLevelShape.widthPix * 2;
			myWidth = myLevelShape.widthPix * 2;
		}
		
		if (myWidth / 2 > myLevelShape.dimB1) {
			if (myLevelShape.wire) {
				radius1 = myLevelShape.parentRadius1;
			} else {
				radius1 = myLevelShape.dimB1;
			}
			focal1X =
						startX
						+ myWidth
						/ 2
						- Math
						.sqrt(Math.pow(myWidth / 2, 2)
									- Math
									.pow(
												myLevelShape.dimB1,
												2));
			focal1Y = startY;
			focal2X =
						focal1X
						+ 2
						* Math
						.sqrt(Math.pow(myWidth / 2, 2)
									- Math
									.pow(
												myLevelShape.dimB1,
												2));
			focal2Y = startY;
			bkgrdStartX = myLevelShape.bkgrdStartX;
			bkgrdStartY = myLevelShape.bkgrdStartY;
			radius2 =
						myWidth
						/ 2
						- Math
						.sqrt(Math.pow(myWidth / 2, 2)
									- Math
									.pow(
												myLevelShape.dimB1,
												2));
			final double sinCentralAngle =
						myLevelShape.dimD2 / radius1; // opposite/Hypotenus
			centralAngle = Math.asin(sinCentralAngle) * 2;
			
			startAngle = myLevelShape.startAngle;
			if (Double.isNaN(startAngle)) {
				startAngle = 0;
			}
			endAngle = myLevelShape.endAngle;
			
			bkgrdWidth = myLevelShape.parentW;
			bkgrdHeight = myLevelShape.radius1 * 2;
			// p=PI*(a+b)*(1+1/4h+1/64h^2+1/256h3+25/16384h^4)
			if (!myLevelShape.wire) {
				
				bkgrdStartX =
							myLevelShape.startingX
							- myLevelShape.widthPix;
				bkgrdStartY = myLevelShape.startingY;
				startAngle = 0;// thetaOnCircle;//this.myLevelShape.startAngle;
				endAngle = 180;// this.myLevelShape.endAngle;
				
				bkgrdWidth = myWidth;
				bkgrdHeight = radius1 * 2;
			}
			
			final double h1 =
						Math.pow((myWidth / 2 - myLevelShape.dimD2), 2)
						/ Math
						.pow(
									(myWidth / 2 + myLevelShape.dimD2),
									2);
			final double factorial =
						1
						+ 0.25f
						* h1
						+ 1
						/ 64
						* (Math.pow(h1, 2)
									+ 1
									/ 256
									* Math.pow(h1, 3) + 25 / 16384 * Math
									.pow(h1, 4));
			length =
						Math.PI
						* (myWidth / 2 + myLevelShape.dimD2)
						* factorial;
		} else if (myLevelShape.dimB1 > myLevelShape.widthPix / 2) {
			radius1 = myLevelShape.widthPix / 2; //
			
			focal1X = startX + myLevelShape.widthPix / 2;
			focal1Y =
						startY
						- Math
						.sqrt(Math.pow(
									myLevelShape.dimB1,
									2)
									- Math
									.pow(
												myLevelShape.widthPix / 2,
												2));
			focal2X = focal1X;
			focal2Y =
						startY
						+ Math
						.sqrt(Math.pow(
									myLevelShape.dimB1,
									2)
									- Math
									.pow(
												myLevelShape.widthPix / 2,
												2));
			bkgrdStartX = startingX;
			bkgrdStartY = startingY;
			final double sinCentralAngle =
						myLevelShape.dimB1 / radius1; // opposite/Hypotenus
			centralAngle = Math.asin(sinCentralAngle) * 2;
			startAngle = 0;
			endAngle = 180;
			bkgrdWidth = myLevelShape.parentW;
			bkgrdHeight = 2 * radius1;
			radius2 =
						myLevelShape.dimB1
						- Math
						.sqrt(Math
									.pow(
												myLevelShape.widthPix / 2,
												2)
												- Math
												.pow(
															myLevelShape.dimB1,
															2));
			
			// length=PI*(a+b)*(1+1/4h+1/64h^2+1/256h3+25/16384h^4)
			
			final double h1 =
						Math
						.pow(
									(myLevelShape.dimB1 - myLevelShape.widthPix / 2),
									2)
									/ Math
									.pow(
												(myLevelShape.dimB1 + myLevelShape.widthPix / 2),
												2);
			final double factorial =
						1
						+ 0.25f
						* h1
						+ 1
						/ 64
						* (Math.pow(h1, 2)
									+ 1
									/ 256
									* Math.pow(h1, 3) + 25 / 16384 * Math
									.pow(h1, 4));
			length =
						Math.PI
						* (myLevelShape.widthPix / 2 + myLevelShape.dimB1)
						* factorial;
		}
		
		x1 = startX + myLevelShape.widthPix / 2;
		y1 = startY;
		
	}
	
	public void ellipse2BA_402() {
		
		partForm = 3;
		myWidthBA =
					myLevelShape.parentW
					- (myLevelShape.left.partDimB + myLevelShape.right.partDimB);
		startXBA = startX + myLevelShape.right.partDimB;
		startYBA = startY + partDimB;
		double theta = Math.acos(startXBA / (myWidthBA / 2));
		// this.startYBA = Math
		// .abs(((this.myLevelShape.parentRadius1 /
		// 2) -
		// (this.partDimB))
		// * (double) Math.sin(theta))
		// + this.partDimB;
		endXBA = endX - myLevelShape.right.partDimB;
		if (!myLevelShape.rightIn) {
			endYBA = endY;// +(
			// this.partDimB +
			// this.partDimA);
		} else {
			theta = Math.acos(myLevelShape.parentW / 2 / endXBA);
			endYBA =
						Math.abs(myLevelShape.parentRadius1
									/ 2
									* Math.sin(theta))
									+ myLevelShape.dimB1;
		}
		this.topFormElliptical(2);
	}
	
	public void ellipse3A_402() {
		
		partForm = 3;
		myWidthA =
					myWidthBA
					- (myLevelShape.left.partDimA + myLevelShape.right.partDimA);
		startXA =
					startX
					+ myLevelShape.right.partDimB
					+ myLevelShape.right.partDimA;
		startYA = startY + partDimB + partDimA;
		double theta = Math.acos(startXA / (myWidthA / 2));
		startYA =
					Math
					.abs((myLevelShape.parentRadius1 / 2 - (partDimB + partDimA))
								* Math.sin(theta))
								+ partDimB
								+ partDimA;
		
		endXA =
					endX
					- myLevelShape.right.partDimB
					- myLevelShape.right.partDimA;
		if (!myLevelShape.rightIn) {
			endYA = endY;// +(
			// this.partDimB +
			// this.partDimA);
		} else {
			theta = Math.acos(myLevelShape.parentW / 2 / endXA);
			endYA =
						Math.abs(myLevelShape.parentRadius1
									/ 2
									* Math.sin(theta))
									+ myLevelShape.dimB1;
		}
		this.topFormElliptical(3);
	}
	
	public void ellipse1B_403() {
		
		partForm = 3;
		parentW = myLevelShape.parentW;
		startX = myLevelShape.startingX;
		startY = myLevelShape.startingY + myLevelShape.dimD2;
		endX = startX + myLevelShape.widthPix;
		endY = myLevelShape.startingY + myLevelShape.dimB1;
		if (!wire) {
			if (myLevelShape.widthPix / 2 > myLevelShape.dimB1) {
				
				radius1 =
							myLevelShape.centerPointY
							- myLevelShape.startingY;
				
				focal1X =
							startX
							+ myLevelShape.widthPix
							/ 2
							- Math.sqrt(Math.pow(
										myLevelShape.widthPix / 2,
										2)
										- Math.pow(
													myLevelShape.dimD2,
													2));
				focal1Y = startY;
				focal2X =
							focal1X
							+ 2
							* Math.sqrt(Math.pow(
										myLevelShape.widthPix / 2,
										2)
										- Math.pow(
													myLevelShape.dimD2,
													2));
				focal2Y = startY;
				bkgrdStartX = myLevelShape.parentStartX;
				bkgrdStartY = myLevelShape.parentStartY;
				radius2 =
							myLevelShape.widthPix
							/ 2
							- Math.sqrt(Math.pow(
										myLevelShape.widthPix / 2,
										2)
										- Math.pow(
													myLevelShape.dimD2,
													2));
				final double sinCentralAngle =
							myLevelShape.dimD2 / radius1; // opposite/Hypotenus
				centralAngle = Math.asin(sinCentralAngle) * 2;
				
				startAngle = myLevelShape.startAngle;// thetaOnCircle;//this.myLevelShape.startAngle;
				if (Double.isNaN(startAngle)) {
					startAngle = 0;
				}
				endAngle = 180 - startAngle;// this.myLevelShape.endAngle;
				bkgrdWidth = myLevelShape.parentW;
				bkgrdHeight = radius1 * 2;
				// p=PI*(a+b)*(1+1/4h+1/64h^2+1/256h3+25/16384h^4)
				final double h1 =
							Math
							.pow(
										(myLevelShape.widthPix / 2 - myLevelShape.dimD2),
										2)
										/ Math
										.pow(
													(myLevelShape.widthPix / 2 + myLevelShape.dimD2),
													2);
				final double factorial =
							1
							+ 0.25f
							* h1
							+ 1
							/ 64
							* (Math.pow(h1, 2)
										+ 1
										/ 256
										* Math.pow(h1, 3) + 25 / 16384 * Math
										.pow(h1, 4));
				length =
							Math.PI
							* (myLevelShape.widthPix / 2 + myLevelShape.dimD2)
							* factorial;
			} else if (myLevelShape.dimB1 > myLevelShape.widthPix / 2) {
				radius1 = myLevelShape.widthPix / 2; //
				
				focal1X = startX + myLevelShape.widthPix / 2;
				focal1Y =
							startY
							- Math
							.sqrt(Math.pow(
										myLevelShape.dimB1,
										2)
										- Math
										.pow(
													myLevelShape.widthPix / 2,
													2));
				focal2X = focal1X;
				focal2Y =
							startY
							+ Math
							.sqrt(Math.pow(
										myLevelShape.dimB1,
										2)
										- Math
										.pow(
													myLevelShape.widthPix / 2,
													2));
				bkgrdStartX = startingX;
				bkgrdStartY = startingY;
				final double sinCentralAngle =
							myLevelShape.dimB1 / radius1; // opposite/Hypotenus
				centralAngle = Math.asin(sinCentralAngle) * 2;
				startAngle = 0;
				endAngle = 180;
				bkgrdWidth = myLevelShape.widthPix;
				bkgrdHeight = 2 * myLevelShape.dimB1;
				radius2 =
							myLevelShape.dimB1
							- Math.sqrt(Math.pow(
										myLevelShape.widthPix / 2,
										2)
										- Math.pow(
													myLevelShape.dimB1,
													2));
				
				// length=PI*(a+b)*(1+1/4h+1/64h^2+1/256h3+25/16384h^4)
				
				final double h1 =
							Math
							.pow(
										(myLevelShape.dimB1 - myLevelShape.widthPix / 2),
										2)
										/ Math
										.pow(
													(myLevelShape.dimB1 + myLevelShape.widthPix / 2),
													2);
				final double factorial =
							1
							+ 0.25f
							* h1
							+ 1
							/ 64
							* (Math.pow(h1, 2)
										+ 1
										/ 256
										* Math.pow(h1, 3) + 25 / 16384 * Math
										.pow(h1, 4));
				length =
							Math.PI
							* (myLevelShape.widthPix / 2 + myLevelShape.dimB1)
							* factorial;
			}
			
			x1 = startX + myLevelShape.widthPix / 2;
			y1 = startY;
			
			// ///////////////////////////////////////
		} else {
			parentW = myLevelShape.parentW;
			focal1X = myLevelShape.centerPointX;
			focal1Y = myLevelShape.centerPointY;
			focal2X = myLevelShape.centerPointX2;
			focal2Y = myLevelShape.centerPointY2;
			;
			bkgrdStartX = myLevelShape.parentStartX;
			bkgrdStartY = myLevelShape.parentStartY;
			if (parentW / 2 > myLevelShape.dimB1) {
				
				radius1 = myLevelShape.parentRadius1;
				
				radius2 =
							parentW
							/ 2
							- Math.sqrt(Math.pow(parentW / 2, 2)
										- Math.pow(
													myLevelShape.dimD2,
													2));
				
				startAngle = myLevelShape.startAngle;// thetaOnCircle;//this.myLevelShape.startAngle;
				if (Double.isNaN(startAngle)) {
					startAngle = 0;
				}
				endAngle = 180 - startAngle;// this.myLevelShape.endAngle;
				bkgrdWidth = myLevelShape.parentW;
				bkgrdHeight = radius1 * 2;
				// p=PI*(a+b)*(1+1/4h+1/64h^2+1/256h3+25/16384h^4)
				final double h1 =
							Math
							.pow(
										(myLevelShape.widthPix / 2 - myLevelShape.dimD2),
										2)
										/ Math
										.pow(
													(myLevelShape.widthPix / 2 + myLevelShape.dimD2),
													2);
				final double factorial =
							1
							+ 0.25f
							* h1
							+ 1
							/ 64
							* (Math.pow(h1, 2)
										+ 1
										/ 256
										* Math.pow(h1, 3) + 25 / 16384 * Math
										.pow(h1, 4));
				length =
							Math.PI
							* (myLevelShape.widthPix / 2 + myLevelShape.dimD2)
							* factorial;
			} else if (myLevelShape.dimB1 > parentW / 2) {
				radius1 = myLevelShape.parentRadius1;
				; //
				startAngle = 0;
				endAngle = 180;
				bkgrdWidth = myLevelShape.widthPix;
				bkgrdHeight = 2 * radius1;
				radius2 =
							myLevelShape.dimB1
							- Math.sqrt(Math.pow(parentW / 2, 2)
										- Math.pow(
													myLevelShape.dimB1,
													2));
				
				// length=PI*(a+b)*(1+1/4h+1/64h^2+1/256h3+25/16384h^4)
				
				final double h1 =
							Math
							.pow(
										Math
										.abs((myLevelShape.dimB1 - parentW / 2)),
										2)
										/ Math
										.pow(
													Math
													.abs((myLevelShape.dimB1 + parentW / 2)),
													2);
				final double factorial =
							1
							+ 0.25f
							* h1
							+ 1
							/ 64
							* (Math.pow(h1, 2)
										+ 1
										/ 256
										* Math.pow(h1, 3) + 25 / 16384 * Math
										.pow(h1, 4));
				length =
							Math.PI
							* (parentW / 2 + myLevelShape.dimB1)
							* factorial;
			}
			
			x1 = startX + parentW / 2;
			y1 = startY;
		}
		
	}
	
	public void ellipse2BA_403() {
		
		partForm = 3;
		
		startXBA = startX + myLevelShape.right.partDimB;
		startYBA = startY + partDimB;
		endXBA = endX - myLevelShape.right.partDimB;
		endYBA = endY + partDimB;
		double theta = Math.acos(startXA / (myWidthA / 2));
		startYBA =
					Math.abs((myLevelShape.parentRadius1 / 2 - partDimB)
								* Math.sin(theta));
		theta = Math.acos(myLevelShape.parentW / 2 / endXBA);
		endYBA =
					Math.abs(myLevelShape.parentRadius1
								/ 2
								* Math.sin(theta))
								+ myLevelShape.dimB1;
		this.topFormElliptical(2);
		
	}
	
	public void ellipse3A_403() {
		
		startXA =
					startX
					+ myLevelShape.right.partDimB
					+ myLevelShape.right.partDimA;
		startYA = startY + partDimB + partDimA;
		endXA =
					endX
					- myLevelShape.right.partDimB
					- myLevelShape.right.partDimA;
		
		endYA = endY + partDimB + partDimA;
		double theta = Math.acos(startXA / (myWidthA / 2));
		startYA =
					Math
					.abs((myLevelShape.parentRadius1
								/ 2
								- partDimA - partDimB)
								* Math.sin(theta));
		theta = Math.acos(myLevelShape.parentW / 2 / endXA);
		endYA =
					Math.abs(myLevelShape.parentRadius1
								/ 2
								* Math.sin(theta))
								+ myLevelShape.dimB1;
		
		this.topFormElliptical(3);
	}
	
	public void lineStraight1B() {
		
		partForm = 1;
		if (myLevelShape.leftShape == 0 && myLean4 == 3) {
			endTypeRB = 1;
		}
		if (myLevelShape.rightShape == 0 && myLean2 == 3) {
			endTypeLT = 1;
		}
		startY = myLevelShape.startingY;
		endY = startY;
		
		if (myLean == 2) {// Lean right
			
			double theta =  Math.atan(myLevelShape.heightPix / myLevelShape.dimA1);
			double hypotenus = myLevelShape.left.partDimB / Math.sin(theta);
			
			if (endTypeRB == 1 || endTypeRB == 0) { // Mitered
				startX = myLevelShape.startingX + myLevelShape.dimA1;
			} else if (endTypeRB == 2) {// Straight Cut
				startX = myLevelShape.startingX + myLevelShape.dimA1;
			} else if (endTypeRB == 3) {
				startX = myLevelShape.startingX + myLevelShape.dimA1 + hypotenus;
			}
			
			if (myLean3 == 1 || myLean3 == 0) {
				if (endTypeLT == 1 || endTypeLT == 0) {
					endX = myLevelShape.bX2;
				} else if (endTypeLT == 2) {
					endX = myLevelShape.bX2;
				} else if (endTypeLT == 3) {
					endX = myLevelShape.bX2 - myLevelShape.right.partDimB;
				}
			}
			
			if (myLean3 == 2 || myLean3 == 3) {
				theta = Math.atan(myLevelShape.heightPix / myLevelShape.dimC1);
				if (myLean3 == 3) {
					theta = Math.atan(myLevelShape.heightPix / myLevelShape.dimC0);
				}
				if (endTypeLT == 1 || endTypeLT == 0) {
					endX = myLevelShape.bX2;
				} else if (endTypeLT == 2) {
					endX = myLevelShape.bX2;
				} else if (endTypeLT == 3) {
					endX = myLevelShape.bX2 - myLevelShape.right.partDimB / Math.sin(theta);
				}
			}
			myLevelShape.dimA0 = 0;
		}
		
		if (myLean == 1) { // Lean left
			
			double theta = Math.atan(myLevelShape.heightPix / myLevelShape.dimA2);
			double hypotenus = myLevelShape.right.partDimB / Math.sin(theta);
			
			if (myLean3 == 1 || myLean3 == 0) {
				if (endTypeRB == 1 || endTypeRB == 0) { // Mitered
					startX = myLevelShape.startingX;
				} else if (endTypeRB == 2) {// Straight Cut
					startX = myLevelShape.startingX;
				} else if (endTypeRB == 3) {
					startX = myLevelShape.startingX + myLevelShape.left.partDimB;
				}
			}
			
			if (myLean3 == 1 || myLean3 == 3) {
				theta = Math.atan(myLevelShape.heightPix / myLevelShape.dimC2);
				if (endTypeRB == 1 || endTypeRB == 0) { // Mitered
					startX = myLevelShape.startingX;
				} else if (endTypeRB == 2) {// Straight Cut
					startX = myLevelShape.startingX;
				} else if (endTypeRB == 3) {
					startX = myLevelShape.startingX + myLevelShape.left.partDimB / Math.sin(theta);
				}
			}
			
			if (endTypeLT == 1 || endTypeLT == 0) {
				endX = myLevelShape.startingX + myLevelShape.dimA1;
			} else if (endTypeLT == 2) {
				endX = myLevelShape.startingX + myLevelShape.dimA1;
			} else if (endTypeLT == 3) {
				endX = myLevelShape.startingX + myLevelShape.dimA1 - hypotenus;
			}
			
			myLevelShape.dimA0 = 0;
			
		}
		if (myLean == 3) { // Centered
			double theta = Math.atan(myLevelShape.heightPix / myLevelShape.dimA0);
			double hypotenus = myLevelShape.left.partDimB / Math.sin(theta);
			
			if (endTypeRB == 1 || endTypeRB == 0) { // Mitered
				startX = myLevelShape.startingX + myLevelShape.dimA0;
			} else if (endTypeRB == 2) {// Straight Cut
				
				startX = myLevelShape.startingX + myLevelShape.dimA0;
				
			} else if (endTypeRB == 3) {
				
				startX = myLevelShape.startingX + myLevelShape.dimA0 + hypotenus;
				
			}
			
			if (endTypeLT == 1 || endTypeLT == 0) {
				endX = myLevelShape.bX2 - myLevelShape.dimA2;
			} else if (endTypeLT == 2) {
				
				theta = Math.atan(myLevelShape.heightPix / myLevelShape.dimA2);
				hypotenus = myLevelShape.right.partDimB / Math.sin(theta);
				
				endX = myLevelShape.bX2 - myLevelShape.dimA2;
				
			} else if (endTypeLT == 3) {
				
				endX = myLevelShape.bX2 - myLevelShape.dimA2 - hypotenus;
				
			}
			
		}
		
		if (myLean == 0) {
			
			if (myLean3 == 1 || myLean3 == 0) {
				if (endTypeRB == 1 || endTypeRB == 0) { // Mitered
					startX = myLevelShape.startingX;
				} else if (endTypeRB == 2) {// Straight Cut
					startX = myLevelShape.startingX;
				} else if (endTypeRB == 3) {
					startX =
								myLevelShape.startingX
								+ myLevelShape.left.partDimB;
				}
			}
			
			if (myLean3 == 2 || myLean3 == 3) {
				final double theta =
							Math.atan(myLevelShape.heightPix
										/ myLevelShape.dimC2);
				if (endTypeRB == 1 || endTypeRB == 0) { // Mitered
					startX = myLevelShape.startingX;
				} else if (endTypeRB == 2) {// Straight Cut
					startX = myLevelShape.startingX;
				} else if (endTypeRB == 3) {
					startX =
								myLevelShape.startingX
								+ myLevelShape.left.partDimB
								/ Math.sin(theta);
				}
			}
			if (myLean3 == 1 || myLean3 == 0) {
				if (endTypeLT == 1 || endTypeLT == 0) {
					endX = myLevelShape.bX2;
				} else if (endTypeLT == 2) {
					endX = myLevelShape.bX2;
				} else if (endTypeLT == 3) {
					endX =
								myLevelShape.bX2
								- myLevelShape.right.partDimB;
				}
			}
			
			if (myLean3 == 2 || myLean3 == 3) {
				double theta =
							Math.atan(myLevelShape.heightPix
										/ myLevelShape.dimC1);
				if (myLean3 == 3) {
					theta =
								Math.atan(myLevelShape.heightPix
											/ myLevelShape.dimC0);
				}
				if (endTypeLT == 1 || endTypeLT == 0) {
					endX = myLevelShape.bX2;
				} else if (endTypeLT == 2) {
					endX = myLevelShape.bX2;
				} else if (endTypeLT == 3) {
					endX =
								myLevelShape.bX2
								- myLevelShape.right.partDimB
								/ Math.sin(theta);
				}
			}
			
			if (myLean4 == 1 || myLean4 == 3) {
				if (endTypeRB == 1
							|| endTypeRB == 2
							|| endTypeRB == 0) {
					startY =
								myLevelShape.startingY
								+ myLevelShape.dimD2;
				} else {
					final double theta =
								Math.atan(myLevelShape.widthPix
											/ myLevelShape.dimD2);
					startY =
								myLevelShape.startingY
								+ myLevelShape.dimD2
								- myLevelShape.left.partDimB
								/ Math.tan(theta);
				}
				if (endTypeLT == 1
							|| endTypeLT == 2
							|| endTypeLT == 0) {
					endY = myLevelShape.bY2;
				} else {
					final double theta =
								Math.atan(myLevelShape.widthPix
											/ myLevelShape.dimD2);
					endY =
								myLevelShape.bY2
								+ myLevelShape.right.partDimB
								/ Math.tan(theta);
				}
				
			}
			
			if (myLean2 == 2 || myLean2 == 3) {
				double theta =
							Math.atan(myLevelShape.widthPix
										/ myLevelShape.dimB1);
				if (myLean2 == 3) {
					theta =
								Math.atan(myLevelShape.widthPix
											/ myLevelShape.dimB0);
				}
				if (endTypeRB == 1
							|| endTypeRB == 2
							|| endTypeRB == 0) {
					startY = myLevelShape.startingY;
				} else {
					startY =
								myLevelShape.startingY
								+ myLevelShape.left.partDimB
								/ Math.tan(theta);
				}
				if (myLean2 == 2) {
					endY =
								myLevelShape.startingY
								+ myLevelShape.dimB1;
					if (endTypeLT == 3) {
						theta =
									Math.atan(myLevelShape.widthPix
												/ myLevelShape.dimB1);
						endY =
									myLevelShape.bY2
									+ myLevelShape.dimB1
									- myLevelShape.right.partDimB
									/ Math.tan(theta);
					}
				} else if (myLean2 == 3) {
					endY =
								myLevelShape.startingY
								+ myLevelShape.dimB0;
					if (endTypeLT == 3) {
						theta =
									Math.atan(myLevelShape.widthPix
												/ myLevelShape.dimB0);
						endY =
									myLevelShape.bY2
									+ myLevelShape.dimB0
									- myLevelShape.right.partDimB
									/ Math.tan(theta);
					}
				}
				
			}
			
			if (myLevelShape.leftShape == 0 && myLean4 == 1) {
				if (endTypeRB == 1 || endTypeRB == 0) {
					startY =
								myLevelShape.startingY
								+ myLevelShape.heightPix;
					startX = myLevelShape.startingX;
				} else if (endTypeRB == 2) {
					Math.atan(myLevelShape.heightPix
								/ myLevelShape.widthPix);
					startY =
								myLevelShape.startingY
								+ myLevelShape.heightPix;
					startX = myLevelShape.startingX;
				} else if (endTypeRB == 3) {
					final double theta =
								Math.atan(myLevelShape.heightPix
											/ myLevelShape.widthPix);
					startY =
								myLevelShape.startingY
								+ myLevelShape.heightPix
								- myLevelShape.bot1.partDimB;
					startX =
								myLevelShape.startingX
								+ myLevelShape.bot1.partDimB
								/ Math.tan(theta);
				}
				
			}
			if (myLevelShape.leftShape == 0 && myLean4 == 2) {
				if (endTypeRB == 1 || endTypeRB == 0) {
					startY = myLevelShape.startingY;
					startX = myLevelShape.startingX;
				} else if (endTypeRB == 2) {
					Math.atan(myLevelShape.heightPix
								/ myLevelShape.widthPix);
					startY = myLevelShape.startingY;
					startX = myLevelShape.startingX;
				} else if (endTypeRB == 3) {
					final double theta =
								Math.atan(myLevelShape.heightPix
											/ myLevelShape.widthPix);
					startY = myLevelShape.startingY;
					startX =
								myLevelShape.startingX
								+ myLevelShape.bot1.partDimB
								/ Math.sin(theta);
				}
				
			}
			
			if (myLevelShape.leftShape == 0 && myLean4 == 3) {
				Math.atan(myLevelShape.dimD2 / myLevelShape.widthPix);
				if (endTypeRB == 1 || endTypeRB == 0) {
					startX = myLevelShape.startingX;
					startY =
								myLevelShape.startingY
								+ myLevelShape.dimD2;
				} else if (endTypeRB == 2) {
					startX = myLevelShape.startingX;
					startY =
								myLevelShape.startingY
								+ myLevelShape.dimD2;
				} else if (endTypeRB == 3) {
					startX = myLevelShape.startingX;
					startY =
								myLevelShape.startingY
								+ myLevelShape.dimD2;
				}
				
			}
			if (myLevelShape.rightShape == 0 && myLean2 == 2) {
				if (endTypeLT == 1 || endTypeLT == 0) {
					endY =
								myLevelShape.startingY
								+ myLevelShape.heightPix;
					endX =
								myLevelShape.startingX
								+ myLevelShape.widthPix;
				} else if (endTypeLT == 2) {
					Math.atan(myLevelShape.heightPix
								/ myLevelShape.widthPix);
					endY =
								myLevelShape.startingY
								+ myLevelShape.heightPix;
					endX =
								myLevelShape.startingX
								+ myLevelShape.widthPix;
				} else if (endTypeLT == 3) {
					final double theta =
								Math.atan(myLevelShape.heightPix
											/ myLevelShape.widthPix);
					endY =
								myLevelShape.startingY
								+ myLevelShape.heightPix
								- myLevelShape.bot1.partDimB;
					endX =
								myLevelShape.startingX
								+ myLevelShape.widthPix
								- myLevelShape.bot1.partDimB
								/ Math.tan(theta);
				}
				
			}
			if (myLevelShape.rightShape == 0 && myLean2 == 1) {
				if (endTypeLT == 1 || endTypeLT == 0) {
					endY = myLevelShape.startingY;
					endX =
								myLevelShape.startingX
								+ myLevelShape.widthPix;
				} else if (endTypeLT == 2) {
					Math.atan(myLevelShape.heightPix
								/ myLevelShape.widthPix);
					endY = myLevelShape.startingY;
					endX =
								myLevelShape.startingX
								+ myLevelShape.widthPix;
				} else if (endTypeLT == 3) {
					final double theta =
								Math.atan(myLevelShape.heightPix
											/ myLevelShape.widthPix);
					endY = myLevelShape.startingY;
					endX =
								myLevelShape.startingX
								+ myLevelShape.widthPix
								- myLevelShape.bot1.partDimB
								/ Math.sin(theta);
				}
				
			}
			if (myLevelShape.rightShape == 0 && myLean2 == 3) {
				Math.atan(myLevelShape.dimD2 / myLevelShape.widthPix);
				if (endTypeRB == 1 || endTypeRB == 0) {
					endX =
								myLevelShape.startingX
								+ myLevelShape.widthPix;
					endY =
								myLevelShape.startingY
								+ myLevelShape.dimB0;
				} else if (endTypeRB == 2) {
					endX =
								myLevelShape.startingX
								+ myLevelShape.widthPix;
					endY =
								myLevelShape.startingY
								+ myLevelShape.dimB0;
				} else if (endTypeRB == 3) {
					endX =
								myLevelShape.startingX
								+ myLevelShape.widthPix;
					endY =
								myLevelShape.startingY
								+ myLevelShape.dimB0;
				}
				
			}
			
		}
		
		slope = (startY - endY) / (startX - endX);
		length =
					Math.sqrt(Math.pow((Math.max(endX, startX) - Math
								.min(endX, startX)), 2)
								+ Math.pow((Math.max(endY, startY) - Math
											.min(endY, startY)), 2));
		
		
		
		if (ltAngle == 0)
		{
			ltAngle = 90;
		}
		
		radius1 = 0;
		radius2 = 0;
		bkgrdWidth = myLevelShape.widthPix;
		bkgrdHeight = myLevelShape.heightPix;
		
	}
	
	public void lineStraight2BA() {
		
		partForm = 1;
		
		startYBA = startY + partDimB;
		endYBA = startYBA;
		
		if (myLean == 2) { // LEan Right
			double theta =
						Math.atan(myLevelShape.heightPix
									/ myLevelShape.dimA1);
			if (endTypeRB == 1 || endTypeRB == 0) { // Mitered
				
				startXBA =
							startX
							+ myLevelShape.left.partDimB
							/ Math.sin(theta)
							- partDimB
							/ Math.tan(theta);
				
			} else if (endTypeRB == 2) {// Straight Cut
				
				startXBA = startX - partDimB / Math.tan(theta);
			} else if (endTypeRB == 3) {
				startXBA = startX - // (this.myLevelShape.left.partDimB/(double)
							partDimB
							/ Math.tan(theta);
			}
			if (myLean3 == 0 || myLean3 == 1) {
				if (endTypeLT == 1 || endTypeLT == 0) {
					endXBA = endX - myLevelShape.right.partDimB;
				} else {
					endXBA = endX;
				}
			} else {
				theta =
							Math.atan(myLevelShape.heightPix
										/ myLevelShape.dimC1);
				if (myLean3 == 3) {
					theta =
								Math.atan(myLevelShape.heightPix
											/ myLevelShape.dimC0);
				}
				if (endTypeLT == 1 || endTypeLT == 0) {
					endXBA =
								endX
								- partDimB
								/ Math.tan(theta)
								- myLevelShape.left.partDimB
								/ Math.sin(theta);
				} else if (endTypeLT == 2) {
					endXBA = endX - partDimB / Math.tan(theta);
				} else {
					endXBA = endX - partDimB / Math.tan(theta);
				}
				
			}
			
		}
		if (myLean == 1) { // Lean Left
			
			double theta =
						Math.atan(myLevelShape.heightPix
									/ myLevelShape.dimA2);
			if (myLean3 == 0 || myLean3 == 2) {
				if (endTypeRB == 1 || endTypeRB == 0) { // Mitered
					startXBA = startX + myLevelShape.left.partDimB;
				} else {// Straight Cut
					
					startXBA = startX;
				}
			} else {
				theta =
							Math.atan(myLevelShape.heightPix
										/ myLevelShape.dimC2);
				if (endTypeRB == 1 || endTypeRB == 0) {
					startXBA =
								startX
								+ partDimB
								/ Math.tan(theta)
								+ myLevelShape.right.partDimB
								/ Math.sin(theta);
				} else if (endTypeRB == 1) {
					startXBA = startX + partDimB / Math.tan(theta);
				} else {
					startXBA = startX + partDimB / Math.tan(theta);
				}
				
			}
			// if(myLean3==0|| myLean3==1){
			final double myTheta =
						Math.atan(myLevelShape.heightPix
									/ myLevelShape.dimA2);
			if (endTypeLT == 1 || endTypeLT == 0) {
				endXBA =
							endX
							- myLevelShape.right.partDimB
							/ Math.sin(myTheta)
							+ partDimB
							/ Math.tan(myTheta);
			} else if (endTypeLT == 2) {
				endXBA = endX + partDimB / Math.tan(myTheta);
			} else {
				endXBA = endX + partDimB / Math.tan(myTheta);
			}
			// }
			// else{
			// if()
			// }
			
		}
		if (myLean == 3) { // Centered
			final double theta =
						Math.atan(myLevelShape.heightPix
									/ myLevelShape.dimA0);
			if (endTypeRB == 1 || endTypeRB == 0) { // Mitered
				
				startXBA =
							startX
							+ myLevelShape.left.partDimB
							/ Math.sin(theta)
							- partDimB
							/ Math.tan(theta);
				
			} else if (endTypeRB == 2) {// Straight Cut
				
				startXBA = startX - partDimB / Math.tan(theta);
			} else if (endTypeRB == 3) {
				startXBA = startX - // (this.myLevelShape.left.partDimB/(double)
							partDimB
							/ Math.tan(theta);
			}
			
			final double myTheta =
						Math.atan(myLevelShape.heightPix
									/ myLevelShape.dimA2);
			if (endTypeLT == 1 || endTypeLT == 0) {
				endXBA =
							endX
							- myLevelShape.right.partDimB
							/ Math.sin(myTheta)
							+ partDimB
							/ Math.tan(myTheta);
			} else if (endTypeLT == 2) {
				endXBA = endX + partDimB / Math.tan(myTheta);
			} else {
				endXBA = endX + partDimB / Math.tan(myTheta);
			}
		}
		
		if (myLean == 0) {
			startYBA = myLevelShape.startingY + partDimB;
			endYBA = myLevelShape.startingY + partDimB;
			
			if (myLean4 == 1 || myLean4 == 3) {
				
				final double theta =
							Math.atan(myLevelShape.widthPix
										/ myLevelShape.dimD2);
				final double hypotenus = partDimB / Math.sin(theta);
				final double yExtensionLeft =
							myLevelShape.left.partDimB / Math.tan(theta);
				final double yExtensionRight =
							myLevelShape.left.partDimB / Math.tan(theta);
				if (endTypeRB == 1
							|| endTypeRB == 0
							|| endTypeRB == 3) {
					startYBA =
								myLevelShape.startingY
								+ myLevelShape.dimD2
								+ hypotenus
								- yExtensionLeft;
				} else {
					startYBA =
								myLevelShape.startingY
								+ myLevelShape.dimD2
								+ hypotenus;
				}
				
				if (endTypeLT == 1
							|| endTypeLT == 0
							|| endTypeLT == 3) {
					endYBA = endY + hypotenus + yExtensionRight;
				} else {
					endYBA = endY + hypotenus;
				}
			}
			
			if (myLean2 == 2 || myLean2 == 3) {
				
				double theta =
							Math.atan(myLevelShape.widthPix
										/ myLevelShape.dimB1);
				if (myLean2 == 3) {
					theta =
								Math.atan(myLevelShape.widthPix
											/ myLevelShape.dimB0);
				}
				if (endTypeRB == 1
							|| endTypeRB == 0
							|| endTypeRB == 3) {
					startYBA =
								myLevelShape.startingY
								+ myLevelShape.left.partDimB
								/ Math.sin(theta)
								+ partDimB
								/ Math.tan(theta);
				} else {
					startYBA =
								myLevelShape.startingY
								+ myLevelShape.left.partDimB
								/ Math.sin(theta);
				}
				
				if (endTypeLT == 1
							|| endTypeLT == 0
							|| endTypeLT == 3) {
					
					endYBA =
								myLevelShape.startingY
								+ myLevelShape.dimB1
								+ myLevelShape.left.partDimB
								/ Math.sin(theta)
								- partDimB
								/ Math.tan(theta);
					
					if (myLean2 == 3) {
						endYBA =
									myLevelShape.startingY
									+ myLevelShape.dimB0
									+ myLevelShape.left.partDimB
									/ Math.sin(theta)
									- partDimB
									/ Math.tan(theta);
					}
				} else {
					endYBA =
								myLevelShape.startingY
								+ myLevelShape.dimB1
								+ myLevelShape.left.partDimB
								/ Math.sin(theta);
					if (myLean2 == 3) {
						endYBA =
									myLevelShape.startingY
									+ myLevelShape.dimB0
									+ myLevelShape.left.partDimB
									/ Math.sin(theta);
					}
				}
				
			}
			
			if (myLean3 == 0 || myLean3 == 2) {
				if (endTypeRB == 1 || endTypeRB == 0) {
					startXBA = startX + myLevelShape.left.partDimB;
				} else {
					startXBA = startX;
				}
			} else {
				final double theta =
							Math.atan(myLevelShape.heightPix
										/ myLevelShape.dimC2);
				if (endTypeRB == 1 || endTypeRB == 0) {
					startXBA =
								startX
								+ myLevelShape.left.partDimB
								/ Math.sin(theta)
								+ partDimB
								/ Math.tan(theta);
				} else if (endTypeRB == 2) {
					startXBA = startX + partDimB / Math.tan(theta);
				} else {
					startXBA = startX + partDimB / Math.tan(theta);
				}
			}
			
			if (myLean3 == 0 || myLean3 == 1) {
				if (endTypeLT == 1 || endTypeLT == 0) {
					endXBA = endX - myLevelShape.right.partDimB;
					
				} else {
					endXBA = endX;
				}
			} else {
				double theta =
							Math.atan(myLevelShape.heightPix
										/ myLevelShape.dimC1);
				if (myLean3 == 3) {
					theta =
								Math.atan(myLevelShape.heightPix
											/ myLevelShape.dimC0);
				}
				if (endTypeLT == 1 || endTypeLT == 0) {
					endXBA =
								endX
								- partDimB
								/ Math.tan(theta)
								- myLevelShape.top1.partDimB
								/ Math.sin(theta);
					
				} else if (endTypeLT == 2) {
					endXBA = endX - partDimB / Math.tan(theta);
				} else {
					endXBA = endX - partDimB / Math.tan(theta);
				}
				
			}
			
		}
		
		if (myLevelShape.leftShape == 0 && myLean4 == 1) {
			if (endTypeRB == 1 || endTypeRB == 0) {
				startYBA = myLevelShape.bot1.endYBA;
				startXBA = myLevelShape.bot1.endXBA;
			} else if (endTypeRB == 2) {
				final double theta =
							Math.atan(myLevelShape.heightPix
										/ myLevelShape.widthPix);
				startYBA = startY;
				startXBA = startX + partDimB / Math.sin(theta);
			} else if (endTypeRB == 3) {
				final double theta =
							Math.atan(myLevelShape.heightPix
										/ myLevelShape.widthPix);
				startYBA = startY;
				startXBA = startX + partDimB / Math.sin(theta);
			}
			
		}
		if (myLevelShape.leftShape == 0 && myLean4 == 2) {
			if (endTypeRB == 1 || endTypeRB == 0) {
				startYBA = myLevelShape.bot1.endYBA;
				startXBA = myLevelShape.bot1.endXBA;
			} else if (endTypeRB == 2) {
				final double theta =
							Math.atan(myLevelShape.heightPix
										/ myLevelShape.widthPix);
				startYBA = startY + partDimB;
				startXBA = startX + partDimB / Math.tan(theta);
			} else if (endTypeRB == 3) {
				final double theta =
							Math.atan(myLevelShape.heightPix
										/ myLevelShape.widthPix);
				startYBA = startY + partDimB;
				startXBA = startX + partDimB / Math.tan(theta);
			}
			
		}
		if (myLevelShape.leftShape == 0 && myLean4 == 3) {
			final double myTheta =
						Math.atan(myLevelShape.dimD2
									/ myLevelShape.widthPix);
			if (endTypeRB == 1 || endTypeRB == 0) {
				startXBA = startX + +partDimB / Math.sin(myTheta);
				startYBA = startY;
			} else if (endTypeRB == 2) {
				startXBA = startX + +partDimB / Math.sin(myTheta);
				startYBA = startY;
			} else if (endTypeRB == 3) {
				startXBA = startX + +partDimB / Math.sin(myTheta);
				startYBA = startY;
			}
			
		}
		if (myLevelShape.rightShape == 0 && myLean2 == 2) {
			final double theta =
						Math.atan(myLevelShape.heightPix
									/ myLevelShape.widthPix);
			if (endTypeLT == 1 || endTypeLT == 0) {
				endYBA = myLevelShape.bot1.startYBA;
				endXBA = myLevelShape.bot1.startXBA;
			} else if (endTypeLT == 2) {
				endYBA = endY;
				endXBA = endX - partDimB / Math.sin(theta);
			} else if (endTypeLT == 3) {
				endYBA = endY;
				endXBA = endX - partDimB / Math.sin(theta);
			}
		}
		if (myLevelShape.rightShape == 0 && myLean2 == 1) {
			final double theta =
						Math.atan(myLevelShape.heightPix
									/ myLevelShape.widthPix);
			if (endTypeLT == 1 || endTypeLT == 0) {
				endYBA = endY + partDimB;
				endXBA =
							endX
							- partDimB
							/ Math.tan(theta)
							- myLevelShape.bot1.partDimB
							/ Math.sin(theta);
			} else if (endTypeLT == 2) {
				
				endYBA = endY + partDimB;
				endXBA = endX - partDimB / Math.tan(theta);
			} else if (endTypeLT == 3) {
				
				endYBA = endY + partDimB;
				endXBA = endX - partDimB / Math.tan(theta);
			}
			
		}
		if (myLevelShape.rightShape == 0 && myLean2 == 3) {
			final double myTheta =
						Math.atan(myLevelShape.dimB0
									/ myLevelShape.widthPix);
			if (endTypeLT == 1 || endTypeLT == 0) {
				endXBA = endX - partDimB / Math.sin(myTheta);
				endYBA = endY;
			} else if (endTypeLT == 2) {
				endXBA = endX - partDimB / Math.sin(myTheta);
				endYBA = endY;
			} else if (endTypeLT == 3) {
				endXBA = endX - partDimB / Math.sin(myTheta);
				endYBA = endY;
			}
			
		}
		
		slopeBA = (startYBA - endYBA) / (startXBA - endXBA);
		lengthBA =
					Math.sqrt(Math.pow((Math.max(endXBA, startXBA) - Math
								.min(endXBA, startXBA)), 2)
								+ Math.pow((Math.max(endYBA, startYBA) - Math
											.min(endYBA, startYBA)), 2));
		radius1BA = 0;
		radius2BA = 0;
		bkgrdWidthBA = myLevelShape.widthPix;
		bkgrdHeightBA = myLevelShape.heightPix;
		
	}
	
	public void lineStraight3A() {
		
		partForm = 1;
		
		startYA = startY + partDimB + partDimA;
		stopAsY = startYBA;
		endYA = startYA;
		stopAeY = endYBA;
		
		if (myLean == 2) { // LEan Right
			double theta =
						Math.atan(myLevelShape.heightPix
									/ myLevelShape.dimA1);
			if (endTypeRB == 1 || endTypeRB == 0) { // Mitered
				
				startXA =
							startX
							+ (myLevelShape.left.partDimB + myLevelShape.left.partDimA)
							/ Math.sin(theta)
							- (partDimB + partDimA)
							/ Math.tan(theta);
				
			} else if (endTypeRB == 2) {// Straight Cut
				startXA =
							startXBA
							+ (myLevelShape.left.partDimB + myLevelShape.left.partDimA)
							/ Math.sin(theta)
							- partDimA
							/ Math.tan(theta);
				stopAsX = startXA + partDimA / Math.tan(theta);
				
			} else if (endTypeRB == 3) {
				startXA = startX - // ((this.myLevelShape.left.partDimB+this.myLevelShape.left.partDimA)/(double)
							(partDimB + partDimA)
							/ Math.tan(theta);
			}
			if (myLean3 == 0 || myLean3 == 1) {
				if (endTypeLT == 1 || endTypeLT == 0) {
					endXA =
								endX
								- myLevelShape.right.partDimB
								- myLevelShape.right.partDimA;
				} else if (endTypeLT == 2) {
					endXA =
								endX
								- myLevelShape.right.partDimB
								- myLevelShape.right.partDimA;
				} else {
					endXA = endX;
				}
			} else {
				theta =
							Math.atan(myLevelShape.heightPix
										/ myLevelShape.dimC1);
				if (myLean3 == 3) {
					theta =
								Math.atan(myLevelShape.heightPix
											/ myLevelShape.dimC0);
				}
				if (endTypeLT == 1 || endTypeLT == 0) {
					endXA =
								endX
								- (partDimB + partDimA)
								/ Math.tan(theta)
								- (myLevelShape.left.partDimB + myLevelShape.left.partDimA)
								/ Math.sin(theta);
				} else if (endTypeLT == 2) {
					endXA =
								endX
								- (partDimB + partDimA)
								/ Math.tan(theta)
								- (myLevelShape.left.partDimB + myLevelShape.left.partDimA)
								/ Math.sin(theta);
					stopAeX = endXA + partDimA / Math.tan(theta);
				} else {
					endXA =
								endX
								- (partDimB + partDimA)
								/ Math.tan(theta);
				}
				
			}
			
		}
		if (myLean == 1) { // Lean Left
			
			double theta =
						Math.atan(myLevelShape.heightPix
									/ myLevelShape.dimA2);
			if (myLean3 == 1 || myLean3 == 3) {
				if (endTypeRB == 1 || endTypeRB == 0) { // Mitered
					startXA =
								myLevelShape.startingX
								+ (partDimB + partDimA)
								/ Math.tan(theta)
								+ (myLevelShape.left.partDimB + myLevelShape.left.partDimA)
								/ Math.sin(theta);
				} else if (endTypeRB == 2) {// Straight Cut
					startXA =
								myLevelShape.startingX
								+ (partDimB + partDimA)
								/ Math.tan(theta)
								+ (myLevelShape.left.partDimB + myLevelShape.left.partDimA)
								/ Math.sin(theta);
					stopAsX = startXA - partDimA / Math.tan(theta);
				} else if (endTypeRB == 3) {
					startXA =
								myLevelShape.startingX
								+ (partDimB + partDimA)
								/ Math.tan(theta)
								+ myLevelShape.left.partDimB
								/ Math.sin(theta);
				}
			}
			if (myLean3 == 3) {
				myLean3 = 0;
				myLevelShape.dimC1 =
							myLevelShape.dimC0
							+ myLevelShape.dimC1
							+ myLevelShape.dimC2;
			}
			if (myLean3 == 2 || myLean3 == 0) {
				theta =
							Math.atan(myLevelShape.heightPix
										/ myLevelShape.dimC2);
				if (endTypeRB == 1 || endTypeRB == 0) { // Mitered
					startXA =
								startX
								+ myLevelShape.left.partDimB
								+ myLevelShape.left.partDimA;
				} else if (endTypeRB == 2) {// Straight Cut
					startXA =
								startX
								+ myLevelShape.left.partDimB
								+ myLevelShape.left.partDimA;
				} else if (endTypeRB == 3) {
					startXA = startX;
				}
			}
			
			theta =
						Math.atan(myLevelShape.heightPix
									/ myLevelShape.dimA2);
			if (endTypeLT == 1 || endTypeLT == 0) {
				endXA =
							endX
							+ (partDimB + partDimA)
							/ Math.tan(theta)
							- (myLevelShape.left.partDimB + myLevelShape.left.partDimA)
							/ Math.sin(theta);
			} else if (endTypeLT == 2) {
				endXA =
							myLevelShape.startingX
							+ myLevelShape.dimA1
							+ (partDimB + partDimA)
							/ Math.tan(theta)
							- (myLevelShape.left.partDimB + myLevelShape.left.partDimA)
							/ Math.sin(theta);
				stopAeX =
							myLevelShape.startingX
							+ myLevelShape.dimA1
							+ (partDimB + partDimA)
							/ Math.tan(theta)
							- (myLevelShape.left.partDimB + myLevelShape.left.partDimA)
							/ Math.sin(theta)
							- partDimA
							/ Math.tan(theta);
			} else if (endTypeLT == 3) {
				endXA =
							myLevelShape.startingX
							+ myLevelShape.dimA1
							+ (partDimB + partDimA)
							/ Math.tan(theta)
							- myLevelShape.left.partDimB
							/ Math.sin(theta);
			}
			
		}
		
		if (myLean == 3) { // Centered
			double theta =
						Math.atan(myLevelShape.heightPix
									/ myLevelShape.dimA0);
			if (endTypeRB == 1 || endTypeRB == 0) { // Mitered
				
				startXA =
							startX
							+ (myLevelShape.left.partDimB + myLevelShape.left.partDimA)
							/ Math.sin(theta)
							- (partDimB + partDimA)
							/ Math.tan(theta);
				
			} else if (endTypeRB == 2) {// Straight Cut
				startXA =
							startXBA
							+ (myLevelShape.left.partDimB + myLevelShape.left.partDimA)
							/ Math.sin(theta)
							- partDimA
							/ Math.tan(theta);
				stopAsX =
							startXBA
							+ (myLevelShape.left.partDimB + myLevelShape.left.partDimA)
							/ Math.sin(theta);
				
			} else if (endTypeRB == 3) {
				startXA = startX - // ((this.myLevelShape.left.partDimB+this.myLevelShape.left.partDimA)/(double)
							(partDimB + partDimA)
							/ Math.tan(theta);
			}
			
			theta =
						Math.atan(myLevelShape.heightPix
									/ myLevelShape.dimA2);
			if (endTypeLT == 1 || endTypeLT == 0) {
				endXA =
							endX
							+ (partDimB + partDimA)
							/ Math.tan(theta)
							- (myLevelShape.left.partDimB + myLevelShape.left.partDimA)
							/ Math.sin(theta);
			} else if (endTypeLT == 2) {
				endXA =
							endX
							+ (partDimB + partDimA)
							/ Math.tan(theta)
							- (myLevelShape.left.partDimB + myLevelShape.left.partDimA)
							/ Math.sin(theta);
				stopAeX = endXA - partDimA / Math.tan(theta);
			} else if (endTypeLT == 3) {
				endXA =
							endX
							+ (partDimB + partDimA)
							/ Math.tan(theta);
			}
			
		}
		
		if (myLean == 0) {
			
			startYA = startY + partDimB + partDimA;
			
			endYA = endY + partDimB + partDimA;
			
			if (myLean4 == 1 || myLean4 == 3) {
				
				final double theta =
							Math.atan(myLevelShape.widthPix
										/ myLevelShape.dimD2);
				final double hypotenus =
							(partDimB + partDimA) / Math.sin(theta);
				final double yExtensionLeft =
							(myLevelShape.left.partDimB + myLevelShape.left.partDimA)
							/ Math.tan(theta);
				final double yExtensionRight =
							(myLevelShape.left.partDimB + myLevelShape.left.partDimA)
							/ Math.tan(theta);
				
				if (endTypeRB == 1 || endTypeRB == 0) {
					startYA =
								myLevelShape.startingY
								+ myLevelShape.dimD2
								+ hypotenus
								- yExtensionLeft;
					
				} else if (endTypeRB == 2) {
					startYA =
								myLevelShape.startingY
								+ myLevelShape.dimD2
								+ hypotenus
								- yExtensionLeft;
					
					stopAsY = startYA - partDimA / Math.sin(theta);
				} else {
					startYA = startY + hypotenus;
				}
				if (endTypeLT == 1
							|| endTypeLT == 0
							|| endTypeLT == 2) {
					endYA = endY + hypotenus + yExtensionRight;
					stopAeY = endYA - partDimA / Math.sin(theta);
				} else {
					endYA = endY + hypotenus;
				}
			}
			if ((myLean2 == 0 || myLean2 == 1)
						&& (myLean4 == 2 || myLean4 == 0)) {
				
				if (endTypeRB == 1 || endTypeRB == 1) {
					startYA =
								startY
								+ myLevelShape.top1.partDimB
								+ myLevelShape.top1.partDimA;
				} else if (endTypeRB == 2) {
					startYA =
								startY
								+ myLevelShape.top1.partDimB
								+ myLevelShape.top1.partDimA;
					stopAsY = startYA - partDimA;
				} else {
					startYA =
								startY
								+ myLevelShape.top1.partDimB
								+ myLevelShape.top1.partDimA;
				}
			}
			if (myLean2 == 2 || myLean2 == 3) {
				
				double theta =
							Math.atan(myLevelShape.widthPix
										/ myLevelShape.dimB1);
				if (myLean2 == 3) {
					theta =
								Math.atan(myLevelShape.widthPix
											/ myLevelShape.dimB0);
				}
				if (endTypeRB == 1 || endTypeRB == 0) {
					startYA =
								startY
								+ (partDimB + partDimA)
								/ Math.tan(theta)
								+ (myLevelShape.left.partDimB + myLevelShape.left.partDimA)
								/ Math.sin(theta);
				} else if (endTypeRB == 2) {
					startYA =
								startY
								+ (partDimB + partDimA)
								/ Math.tan(theta)
								+ (myLevelShape.left.partDimB + myLevelShape.left.partDimA)
								/ Math.sin(theta);
					stopAsY = startYA - partDimA / Math.sin(theta);
				} else {
					startYA =
								myLevelShape.startingY
								+ myLevelShape.left.partDimB
								/ Math.tan(theta)
								+ (partDimB + partDimA)
								/ Math.sin(theta);
				}
				if (endTypeLT == 1 || endTypeLT == 0) {
					endYA =
								endY
								+ (myLevelShape.left.partDimB + myLevelShape.left.partDimA)
								/ Math.sin(theta)
								- (partDimB + partDimA)
								/ Math.tan(theta);
				} else if (endTypeLT == 2) {
					endYA =
								endY
								+ (partDimB + partDimA)
								/ Math.sin(theta)
								- (myLevelShape.left.partDimB + myLevelShape.left.partDimA)
								/ Math.tan(theta);
					stopAeY = endYA - partDimA / Math.sin(theta);
				} else {
					endYA =
								endY
								+ (partDimB + partDimA)
								/ Math.sin(theta);
				}
				
			}
			
			if (myLean3 == 0 || myLean3 == 2) {
				if (endTypeRB == 1 || endTypeRB == 0) {
					startXA =
								startX
								+ myLevelShape.right.partDimB
								+ myLevelShape.right.partDimA;
				} else if (endTypeRB == 2) {
					startXA =
								startX
								+ myLevelShape.right.partDimB
								+ myLevelShape.right.partDimA;
					
				} else {
					startXA = startX;
				}
			} else {
				final double theta =
							Math.atan(myLevelShape.heightPix
										/ myLevelShape.dimC2);
				if (endTypeRB == 1 || endTypeRB == 0) {
					startXA =
								startX
								+ (myLevelShape.right.partDimB + myLevelShape.right.partDimA)
								/ Math.sin(theta)
								+ (partDimB + partDimA)
								/ Math.tan(theta);
				} else if (endTypeRB == 2) {
					startXA =
								startX
								+ (partDimB + partDimA)
								/ Math.tan(theta)
								+ (myLevelShape.right.partDimB + myLevelShape.right.partDimA)
								/ Math.sin(theta);
					stopAsX =
								startX
								+ (partDimB + partDimA)
								/ Math.tan(theta)
								+ (myLevelShape.right.partDimB + myLevelShape.right.partDimA)
								/ Math.sin(theta)
								- partDimA
								/ Math.tan(theta);
				} else {
					startXA =
								startX
								+ (partDimB + partDimA)
								/ Math.tan(theta);
				}
			}
			
			if (myLean3 == 0 || myLean3 == 1) {
				if (endTypeLT == 1 || endTypeLT == 0) {
					endXA =
								endX
								- (myLevelShape.left.partDimB + myLevelShape.left.partDimA);
				} else if (endTypeLT == 2) {
					endXA =
								endX
								- (myLevelShape.left.partDimB + myLevelShape.left.partDimA);
				} else {
					endXA = endX;
				}
			} else {
				double theta =
							Math.atan(myLevelShape.heightPix
										/ myLevelShape.dimC1);
				if (myLean3 == 3) {
					theta =
								Math.atan(myLevelShape.heightPix
											/ myLevelShape.dimC0);
				}
				if (endTypeLT == 1 || endTypeLT == 0) {
					endXA =
								endX
								- (partDimB + partDimA)
								/ Math.tan(theta)
								- (myLevelShape.left.partDimB + myLevelShape.left.partDimA)
								/ Math.sin(theta);
					
				} else if (endTypeLT == 2) {
					endXA =
								endX
								- (partDimB + partDimA)
								/ Math.tan(theta)
								- (myLevelShape.left.partDimB + myLevelShape.left.partDimA)
								/ Math.sin(theta);
					stopAeX = endXA + partDimA / Math.tan(theta);
				} else {
					endXA = endXBA - partDimA / Math.tan(theta);
				}
				
			}
		}
		if (stopAeX == 0) {
			stopAeX = endXA;
		}
		if (stopAsX == 0) {
			stopAsX = startXA;
		}
		if (stopAeY == 0) {
			stopAeY = endYBA;
		}
		if (stopAsY == 0) {
			stopAsY = startYBA;
		}
		if (myLevelShape.leftShape == 0 && myLean4 == 1) {
			if (endTypeRB == 1 || endTypeRB == 0) {
				startYA = myLevelShape.bot1.endYA;
				startXA = myLevelShape.bot1.endXA;
			} else if (endTypeRB == 2) {
				final double theta =
							Math.atan(myLevelShape.heightPix
										/ myLevelShape.widthPix);
				startYA =
							startY
							- myLevelShape.bot1.partDimB
							- myLevelShape.bot1.partDimA;
				startXA =
							startX
							+ (partDimB + partDimA)
							/ Math.sin(theta)
							+ (myLevelShape.bot1.partDimB + myLevelShape.bot1.partDimA)
							/ Math.tan(theta);
				stopAsX = startXA - partDimA / Math.sin(theta);
				stopAsY = startYA;
			} else if (endTypeRB == 3) {
				final double theta =
							Math.atan(myLevelShape.heightPix
										/ myLevelShape.widthPix);
				startYA = startY;
				startXA =
							startX
							+ (partDimB + partDimA)
							/ Math.sin(theta);
				;
				
			}
			
		}
		if (myLevelShape.leftShape == 0 && myLean4 == 2) {
			if (endTypeRB == 1 || endTypeRB == 0) {
				startYA = myLevelShape.bot1.endYA;
				startXA = myLevelShape.bot1.endXA;
			} else if (endTypeRB == 2) {
				final double theta =
							Math.atan(myLevelShape.heightPix
										/ myLevelShape.widthPix);
				startYA = startY + partDimB + partDimA;
				startXA =
							startX
							+ (partDimB + partDimA)
							/ Math.tan(theta)
							+ (myLevelShape.bot1.partDimB + myLevelShape.bot1.partDimA)
							/ Math.sin(theta);
				stopAsX = startXA - partDimA / Math.tan(theta);
				stopAsY = startYA - partDimA;
			} else if (endTypeRB == 3) {
				final double theta =
							Math.atan(myLevelShape.heightPix
										/ myLevelShape.widthPix);
				startYA = startY + partDimB + partDimA;
				startXA =
							startX
							+ (partDimB + partDimA)
							/ Math.tan(theta);
			}
			
		}
		if (myLevelShape.leftShape == 0 && myLean4 == 3) {
			final double myTheta =
						Math.atan(myLevelShape.dimD2
									/ myLevelShape.widthPix);
			if (endTypeLT == 1 || endTypeLT == 0) {
				startXA =
							startX
							+ (partDimB + partDimA)
							/ Math.sin(myTheta);
				startYA = startY;
			} else if (endTypeLT == 2) {
				startXA =
							startX
							+ (partDimB + partDimA)
							/ Math.sin(myTheta);
				startYA = startY;
			} else if (endTypeLT == 3) {
				startXA =
							startX
							+ (partDimB + partDimA)
							/ Math.sin(myTheta);
				startYA = startY;
			}
			
		}
		if (myLevelShape.rightShape == 0 && myLean2 == 2) {
			final double theta =
						Math.atan(myLevelShape.heightPix
									/ myLevelShape.widthPix);
			if (endTypeLT == 1 || endTypeLT == 0) {
				endYA = myLevelShape.bot1.startYA;
				endXA = myLevelShape.bot1.startXA;
			} else if (endTypeLT == 2) {
				endYA =
							endY
							- myLevelShape.bot1.partDimB
							- myLevelShape.bot1.partDimA;
				endXA =
							endX
							- (partDimB + partDimA)
							/ Math.sin(theta)
							- (myLevelShape.bot1.partDimB + myLevelShape.bot1.partDimA)
							/ Math.tan(theta);
				stopAeX = endXA + partDimA / Math.sin(theta);
				stopAeY = endYA;
			} else if (endTypeLT == 3) {
				endYA = endY;
				endXA =
							endX
							- (partDimB + partDimA)
							/ Math.sin(theta);
				;
			}
		}
		if (myLevelShape.rightShape == 0 && myLean2 == 1) {
			final double theta =
						Math.atan(myLevelShape.heightPix
									/ myLevelShape.widthPix);
			if (endTypeLT == 1 || endTypeLT == 0) {
				endYA = endY + partDimB + partDimA;
				endXA =
							endX
							- (partDimB + partDimA)
							/ Math.tan(theta)
							- (myLevelShape.bot1.partDimB + myLevelShape.bot1.partDimA)
							/ Math.sin(theta);
			} else if (endTypeLT == 2) {
				
				endYA = endY + partDimB + partDimA;
				endXA =
							endX
							- (partDimB + partDimA)
							/ Math.tan(theta)
							- (myLevelShape.bot1.partDimB + myLevelShape.bot1.partDimA)
							/ Math.sin(theta);
				stopAeX = endXA + partDimA / Math.tan(theta);
				stopAeY = endYA - partDimA;
			} else if (endTypeLT == 3) {
				
				endYA = endY + partDimB + partDimA;
				endXA =
							endX
							- (partDimB + partDimA)
							/ Math.tan(theta);
			}
			
		}
		if (myLevelShape.rightShape == 0 && myLean2 == 3) {
			final double myTheta =
						Math.atan(myLevelShape.dimB0
									/ myLevelShape.widthPix);
			if (endTypeLT == 1 || endTypeLT == 0) {
				endXA =
							endX
							- (partDimB + partDimA)
							/ Math.sin(myTheta);
				endYA = endY;
			} else if (endTypeLT == 2) {
				endXA =
							endX
							- (partDimB + partDimA)
							/ Math.sin(myTheta);
				endYA = endY;
			} else if (endTypeLT == 3) {
				endXA =
							endX
							- (partDimB + partDimA)
							/ Math.sin(myTheta);
				endYA = endY;
			}
			
		}
		
		slopeA = (startYA - endYA) / (startXA - endXA);
		ltAngle = Math.atan((endX - endXA) / (endY - endYA));
		rbAngle = Math.atan((startX - startXA) / (startY - startYA));
		lengthA =
					Math.sqrt(Math.pow((Math.max(endXA, startXA) - Math
								.min(endXA, startXA)), 2)
								+ Math.pow((Math.max(endYA, startYA) - Math
											.min(endYA, startYA)), 2));
		radius1A = 0;
		radius2A = 0;
		bkgrdWidthA = myLevelShape.widthPix;
		bkgrdHeightA = myLevelShape.heightPix;
	}
	
	public void lineStraight1B_2() {
		
		partForm = 1;
		if (!myLevelShape.top3.posInUse
					&& (myLevelShape.lean4 == 1 || myLevelShape.lean4 == 3)
					&& (myLevelShape.lean2 == 2 || myLevelShape.lean2 == 3)) {
			endTypeLT = 1;
		}
		startY = myLevelShape.startingY + myLevelShape.dimD2;
		
		startX = myLevelShape.startingX;
		endY = myLevelShape.startingY;
		endX = myLevelShape.startingX + myLevelShape.dimA1;
		if (myLevelShape.shapeID == 150) {
		} else if (myLevelShape.shapeID == 154) {
			
		} else if (myLevelShape.shapeID == 155) {
			startY = myLevelShape.startingY;
			startX = myLevelShape.startingX;
		}
		
		if (myLean3 == 2 || myLean3 == 0) {
			if (endTypeRB == 1 || endTypeRB == 0) { // Mitered
				startX = myLevelShape.startingX;
			} else if (endTypeRB == 2) {// Straight Cut
				startX = myLevelShape.startingX;
			} else if (endTypeRB == 3) {
				startX =
							myLevelShape.startingX
							+ myLevelShape.left.partDimB;
			}
		}
		
		if (myLean3 == 1 || myLean3 == 3) {
			final double theta =
						Math.atan(myLevelShape.heightPix
									/ myLevelShape.dimC2);
			if (endTypeRB == 1 || endTypeRB == 0) { // Mitered
				startX = myLevelShape.startingX;
			} else if (endTypeRB == 2) {// Straight Cut
				startX = myLevelShape.startingX;
			} else if (endTypeRB == 3) {
				startX =
							myLevelShape.startingX
							+ myLevelShape.left.partDimB
							/ Math.sin(theta);
			}
		}
		
		if (myLean4 == 1 || myLean4 == 3) {
			if (endTypeRB == 1
						|| endTypeRB == 2
						|| endTypeRB == 0) {
				startY = myLevelShape.startingY + myLevelShape.dimD2;
			} else {
				final double theta =
							Math
							.atan((myLevelShape.widthPix - myLevelShape.dimA2)
										/ myLevelShape.dimD2);
				startY =
							myLevelShape.startingY
							+ myLevelShape.dimD2
							- myLevelShape.left.partDimB
							/ Math.tan(theta);
			}
			if (endTypeLT == 1 || endTypeLT == 0) {
				endY = myLevelShape.startingY;
				endX = myLevelShape.startingX + myLevelShape.dimA1;
			} else if (endTypeLT == 2) {
				endY = myLevelShape.startingY;
				endX = myLevelShape.startingX + myLevelShape.dimA1;
			} else if (endTypeLT == 3) {
				final double theta =
							Math.atan(myLevelShape.dimD2
										/ myLevelShape.dimA1);
				endY =
							myLevelShape.startingY
							+ myLevelShape.top2.partDimB;
				endX =
							myLevelShape.startingX
							+ myLevelShape.dimA1
							- myLevelShape.top2.partDimB
							/ Math.tan(theta);
				if (myLevelShape.top3.posInUse) {
					endY =
								myLevelShape.startingY
								+ myLevelShape.top3.partDimB;
					endX =
								myLevelShape.startingX
								+ myLevelShape.dimA1
								- myLevelShape.top3.partDimB
								/ Math.tan(theta);
				}
			}
		}
		// ///
		if (!myLevelShape.top3.posInUse
					&& myLevelShape.lean4 != 1
					&& myLevelShape.lean4 != 3
					&& (myLevelShape.lean2 == 2 || myLevelShape.lean2 == 3)) {
			double theta =
						Math
						.atan(myLevelShape.dimA2
									/ myLevelShape.dimB1);
			final double hypotenus =
						myLevelShape.right.partDimB / Math.sin(theta);
			
			if (myLean3 == 1 || myLean3 == 0) {
				if (endTypeRB == 1 || endTypeRB == 0) { // Mitered
					startX = myLevelShape.startingX;
				} else if (endTypeRB == 2) {// Straight Cut
					startX = myLevelShape.startingX;
				} else if (endTypeRB == 3) {
					startX =
								myLevelShape.startingX
								+ myLevelShape.left.partDimB;
				}
			}
			
			if (myLean3 == 1 || myLean3 == 3) {
				theta =
							Math.atan(myLevelShape.heightPix
										/ myLevelShape.dimC2);
				if (endTypeRB == 1 || endTypeRB == 0) { // Mitered
					startX = myLevelShape.startingX;
				} else if (endTypeRB == 2) {// Straight Cut
					startX = myLevelShape.startingX;
				} else if (endTypeRB == 3) {
					startX =
								myLevelShape.startingX
								+ myLevelShape.left.partDimB
								/ Math.sin(theta);
				}
			}
			
			if (endTypeLT == 1 || endTypeLT == 0) {
				endX = myLevelShape.startingX + myLevelShape.dimA1;
			} else if (endTypeLT == 2) {
				endX = myLevelShape.startingX + myLevelShape.dimA1;
			} else if (endTypeLT == 3) {
				endX =
							myLevelShape.startingX
							+ myLevelShape.dimA1
							- hypotenus;
			}
			
		}
		
		// ///
		if (myLevelShape.shapeID == 704) {
			final double myTheta =
						Math.atan(myLevelShape.heightPix
									/ myLevelShape.dimA1);
			if (endTypeRB == 1 || endTypeRB == 0) {
				startX = myLevelShape.startingX;
				startY =
							myLevelShape.startingY
							+ myLevelShape.heightPix;
			} else if (endTypeRB == 2) {
				startX = myLevelShape.startingX;
				startY =
							myLevelShape.startingY
							+ myLevelShape.heightPix;
			} else if (endTypeRB == 3) {
				startX =
							myLevelShape.startingX
							+ myLevelShape.bot1.partDimB
							/ Math.tan(myTheta);
				startY =
							myLevelShape.startingY
							+ myLevelShape.heightPix
							- myLevelShape.bot1.partDimB;
			}
			
			if (endTypeLT == 1 || endTypeLT == 0) {
				endX = myLevelShape.startingX + myLevelShape.dimA1;
				endY = myLevelShape.startingY;
			} else if (endTypeLT == 2) {
				endX = myLevelShape.startingX + myLevelShape.dimA1;
				endY = myLevelShape.startingY;
			} else if (endTypeLT == 3) {
				endX = myLevelShape.startingX + myLevelShape.dimA1;
				endY = myLevelShape.startingY;
			}
		}
		
		slope = (startY - endY) / (startX - endX);
		length =
					Math.sqrt(Math.pow((Math.max(endX, startX) - Math
								.min(endX, startX)), 2)
								+ Math.pow((Math.max(endY, startY) - Math
											.min(endY, startY)), 2));
		radius1 = 0;
		radius2 = 0;
		bkgrdWidth = myLevelShape.widthPix - myLevelShape.dimA2;
		bkgrdHeight = myLevelShape.heightPix;
		
	}
	
	public void lineStraight2BA_2() {
		
		partForm = 1;
		double theta = 0;
		
		startYBA = startY + partDimB;
		// if (this.myLevelShape.shapeID == 704) {
		// theta = (double)
		// Math.atan((this.myLevelShape.dimA0)
		// / this.myLevelShape.dimD2);
		// } else {
		theta = Math.atan(myLevelShape.dimA1 / myLevelShape.dimD2);
		// }
		
		double hypotenus = partDimB / Math.sin(theta);
		
		endXBA = endX;
		endYBA = endY + hypotenus;
		
		if (myLevelShape.shapeID == 150
					|| myLevelShape.shapeID == 704) {
			
			endYBA = endY + hypotenus;
			endXBA = endX;
		} else if (myLevelShape.shapeID == 154
					|| myLevelShape.shapeID == 160
					|| myLevelShape.shapeID == 165
					|| myLevelShape.shapeID >= 91 && myLevelShape.shapeID <= 93) {
			if (endTypeLT == 1 || endTypeLT == 0) {
				final double mytheta =
							Math.atan(myLevelShape.dimD2
										/ myLevelShape.dimA1);
				endXBA =
							endX
							+ partDimB
							/ Math.sin(mytheta)
							- partDimB
							/ Math.tan(mytheta);
				
				endYBA = endY + partDimB;
			} else if (endTypeLT == 2) {
				final double mytheta =
							Math.atan(myLevelShape.dimA1
										/ myLevelShape.dimD2);
				endXBA = endX + partDimB / Math.sin(mytheta);
				
				endYBA = endY;
			} else if (endTypeLT == 3) {
				final double mytheta =
							Math.atan(myLevelShape.dimD2
										/ myLevelShape.dimA1);
				endXBA = endX + partDimB / Math.sin(mytheta);
				
				endYBA = endY;
				
			}
		} else if (myLevelShape.shapeID == 155) {
			final double mytheta =
						Math
						.atan(myLevelShape.dimB1
									/ myLevelShape.dimA2);
			endXBA =
						endX
						- partDimB
						/ Math.sin(mytheta)
						+ partDimB
						/ Math.tan(mytheta);
			
			endYBA = endY + partDimB;
		}
		
		if (myLean4 == 1 || myLean4 == 3) {
			
			theta =
						Math
						.atan(myLevelShape.dimA1
									/ myLevelShape.dimD2);
			hypotenus = partDimB / Math.sin(theta);
			final double yExtensionLeft =
						myLevelShape.left.partDimB / Math.tan(theta);
			if (endTypeRB == 1
						|| endTypeRB == 0
						|| endTypeRB == 3) {
				startYBA =
							myLevelShape.startingY
							+ myLevelShape.dimD2
							+ hypotenus
							- yExtensionLeft;
			} else {
				startYBA =
							myLevelShape.startingY
							+ myLevelShape.dimD2
							+ hypotenus;
			}
			
		}
		
		if (myLean2 == 2 || myLean2 == 3) {
			
		}
		
		if (myLean3 == 0 || myLean3 == 2) {
			if (endTypeRB == 1 || endTypeRB == 0) {
				startXBA = startX + myLevelShape.left.partDimB;
			} else {
				startXBA = startX;
			}
		} else {
			theta =
						Math.atan(myLevelShape.heightPix
									/ myLevelShape.dimC2);
			if (endTypeRB == 1 || endTypeRB == 0) {
				startXBA =
							startX
							+ myLevelShape.left.partDimB
							/ Math.sin(theta)
							+ partDimB
							/ Math.tan(theta);
			} else if (endTypeRB == 2) {
				startXBA = startX + partDimB / Math.tan(theta);
			} else {
				startXBA = startX + partDimB / Math.tan(theta);
			}
		}
		
		if (myLean3 == 0 || myLean3 == 1) {
			
		} else {
			
		}
		if (myLevelShape.leftShape == 0) {
			startYBA = myLevelShape.bot1.endYBA;
			startXBA = myLevelShape.bot1.endXBA;
			
		}
		if (myLean3 == 3 || myLean3 == 1) {
			final double theta1 =
						Math
						.atan(myLevelShape.dimC2
									/ myLevelShape.dimD1);
			final double theta2 =
						Math
						.atan(myLevelShape.dimA1
									/ myLevelShape.dimD2);
			final double myTheta =
						Math.toRadians(180) - theta1 - theta2;
			hypotenus = partDimB / Math.sin(myTheta / 2);
			final double baseY =
						hypotenus * Math.cos(myTheta / 2 + theta1);
			final double baseX =
						hypotenus * Math.sin(myTheta / 2 + theta1);
			startXBA = startX + baseX;// base;
			
			startYBA = startY + baseY;
		}
		if (myLevelShape.top3.posInUse
					&& myLevelShape.noSidesLeft == 1
					&& myLean4 == 3) {
			if (endTypeRB == 1 || endTypeRB == 0) { // Mitered
				startXBA = startX + myLevelShape.left.partDimB;
			} else {// Straight Cut
				
				startXBA = startX;
			}
			theta =
						Math
						.atan(myLevelShape.dimA1
									/ myLevelShape.dimD2);
			hypotenus = partDimB / Math.sin(theta);
			final double yExtensionLeft =
						myLevelShape.left.partDimB / Math.tan(theta);
			if (endTypeRB == 1
						|| endTypeRB == 0
						|| endTypeRB == 3) {
				startYBA =
							myLevelShape.startingY
							+ myLevelShape.dimD2
							+ hypotenus
							- yExtensionLeft;
			} else {
				startYBA =
							myLevelShape.startingY
							+ myLevelShape.dimD2
							+ hypotenus;
			}
		}
		// ///
		if (!myLevelShape.top3.posInUse
					&& myLevelShape.lean4 != 1
					&& myLevelShape.lean4 != 3
					&& (myLevelShape.lean2 == 2 || myLevelShape.lean2 == 3)) {
			
			theta =
						Math
						.atan(myLevelShape.dimB1
									/ myLevelShape.dimA2);
			
			if (myLean3 == 0 || myLean3 == 2) {
				if (endTypeRB == 1 || endTypeRB == 0) { // Mitered
					startXBA = startX + myLevelShape.left.partDimB;
				} else {// Straight Cut
					
					startXBA = startX;
				}
			} else {
				theta =
							Math.atan(myLevelShape.heightPix
										/ myLevelShape.dimC2);
				if (endTypeRB == 1 || endTypeRB == 0) {
					startXBA =
								startX
								+ partDimB
								/ Math.tan(theta)
								+ myLevelShape.right.partDimB
								/ Math.sin(theta);
				} else if (endTypeRB == 1) {
					startXBA = startX + partDimB / Math.tan(theta);
				} else {
					startXBA = startX + partDimB / Math.tan(theta);
				}
				
			}
			// if(myLean3==0|| myLean3==1){
			final double myTheta =
						Math
						.atan(myLevelShape.dimB1
									/ myLevelShape.dimA2);
			if (endTypeLT == 1 || endTypeLT == 0) {
				endXBA =
							endX
							- myLevelShape.right.partDimB
							/ Math.sin(myTheta)
							+ partDimB
							/ Math.tan(myTheta);
			} else if (endTypeLT == 2) {
				endXBA = endX + partDimB / Math.tan(myTheta);
			} else {
				endXBA = endX + partDimB / Math.tan(myTheta);
			}
		}
		// ///
		if (myLevelShape.shapeID == 704) {
			final double myTheta =
						Math.atan(myLevelShape.heightPix
									/ myLevelShape.dimA1);
			if (endTypeRB == 1 || endTypeRB == 0) {
				startXBA =
							startX
							+ partDimB
							/ Math.sin(myTheta)
							+ myLevelShape.bot1.partDimB
							/ Math.tan(myTheta);
				startYBA = startY - myLevelShape.bot1.partDimB;
			} else if (endTypeRB == 2) {
				startXBA = startX + partDimB / Math.sin(myTheta);
				startYBA = startY;
			} else if (endTypeRB == 3) {
				startXBA = startX + partDimB / Math.sin(myTheta);
				startYBA = startY;
			}
			
			// if (this.endTypeLT==1 ||
			// this.endTypeLT==0){
			// myTheta = (double)
			// Math.atan(this.myLevelShape.dimA0/this.myLevelShape.hL)
			// ;
			// this. endXBA = this.endX ;
			// this.endYBA =
			// this.myLevelShape.startingY +
			// this.partDimB/(double)
			// Math.sin(myTheta);
			// }else if (this.endTypeLT==2){
			// this. endXBA = this.endX ;
			// this.endYBA =
			// this.myLevelShape.startingY +
			// this.partDimB/(double)
			// Math.sin(myTheta);
			// } else if(this.endTypeLT==3){
			// this. endXBA = this.endX ;
			// this.endYBA =
			// this.myLevelShape.startingY +
			// this.partDimB/(double)
			// Math.sin(myTheta);
			// }
		}
		slopeBA = (startYBA - endYBA) / (startXBA - endXBA);
		lengthBA =
					Math.sqrt(Math.pow((Math.max(endXBA, startXBA) - Math
								.min(endXBA, startXBA)), 2)
								+ Math.pow((Math.max(endYBA, startYBA) - Math
											.min(endYBA, startYBA)), 2));
		radius1BA = 0;
		radius2BA = 0;
		bkgrdWidthBA = myLevelShape.widthPix - myLevelShape.dimA2;
		bkgrdHeightBA = myLevelShape.heightPix;
		
	}
	
	public void lineStraight3A_2() {
		
		partForm = 1;
		
		startYA = startY + partDimB + partDimA;
		endXA = endX;
		double theta = 0;
		// if (this.myLevelShape.shapeID == 704) {
		// theta = (double)
		// Math.atan((this.myLevelShape.dimA0)
		// / this.myLevelShape.dimD2);
		// } else {
		theta = Math.atan(myLevelShape.dimA1 / myLevelShape.dimD2);
		// }
		
		double hypotenus = (partDimB + partDimA) / Math.sin(theta);
		
		endXA = endX;
		endYA = endY + hypotenus;
		
		if ((myLean4 == 1 || myLean4 == 3)
					&& (myLean2 == 1 || myLean2 == 0)) {
			double mytheta =
						Math
						.atan(myLevelShape.dimD2
									/ (myLevelShape.widthPix - myLevelShape.dimA2));
			endXA =
						endX
						+ (partDimB + partDimA)
						/ Math.sin(mytheta)
						- (partDimB + partDimA)
						/ Math.tan(mytheta);
			endYA = myLevelShape.startingY + partDimB + partDimA;
			if (endTypeLT == 2) {
				mytheta =
							Math.atan(myLevelShape.dimA1
										/ myLevelShape.dimD2);
				endXA =
							endX
							+ (partDimB + partDimA)
							/ Math.sin(mytheta)
							- (partDimB + partDimA)
							/ Math.tan(mytheta);
				stopAeX = endXA - partDimA / Math.sin(mytheta);
				endYA =
							endY
							+ myLevelShape.top2.partDimB
							+ myLevelShape.top2.partDimA;
				if (myLevelShape.top3.posInUse) {
					endYA =
								endY
								+ myLevelShape.top3.partDimB
								+ myLevelShape.top3.partDimA;
				}
				stopAeY = endYA;
			} else if (endTypeLT == 3) {
				mytheta =
							Math.atan(myLevelShape.dimD2
										/ myLevelShape.dimA1);
				endYA = myLevelShape.startingY + partDimB;
				endXA =
							endX
							+ (partDimB + partDimA)
							/ Math.sin(mytheta);
				
			}
		}
		if ((myLean4 == 0 || myLean4 == 2)
					&& (myLean2 == 2 || myLean2 == 3)) {
			final double mytheta =
						Math
						.atan(myLevelShape.dimB1
									/ myLevelShape.dimA2);
			endXA =
						endX
						- (partDimB + partDimA)
						/ Math.sin(mytheta)
						+ (partDimB + partDimA)
						/ Math.tan(mytheta);
			
			endYA = endY + partDimB + partDimA;
		} else if (myLevelShape.shapeID == 160
					|| myLevelShape.shapeID == 165
					|| myLevelShape.shapeID >= 91 && myLevelShape.shapeID <= 93) {
			double mytheta =
						Math
						.atan(myLevelShape.dimD2
									/ myLevelShape.dimA1);
			// this.endXA = this.endX
			// + ((this.partDimB +
			// this.partDimA) / (double)
			// Math.sin(mytheta))
			// - ((this.partDimB +
			// this.partDimA) / (double)
			// Math.tan(mytheta));
			// if(this.endTypeLT==1 ||
			// this.endTypeLT==2 ||
			// this.endTypeLT==0){
			// this.endYA = this.endY +
			// (this.partDimB +
			// this.partDimA);
			// }else{
			// this.endXA=
			// this.endYA = this.endY ;
			// }
			
			if (endTypeLT == 1 || endTypeLT == 0) {
				mytheta =
							Math.atan(myLevelShape.dimD2
										/ myLevelShape.dimA1);
				
				endXA =
							endX
							+ (partDimB + partDimA)
							/ Math.sin(mytheta)
							- (myLevelShape.top3.partDimB + myLevelShape.top3.partDimA)
							/ Math.tan(mytheta);
				
				endYA =
							endY
							+ myLevelShape.top3.partDimB
							+ myLevelShape.top3.partDimA;
			} else if (endTypeLT == 2) {
				mytheta =
							Math.atan(myLevelShape.dimA1
										/ myLevelShape.dimD2);
				endXA =
							endX
							+ (partDimB + partDimA)
							/ Math.sin(mytheta)
							- (myLevelShape.top3.partDimB + myLevelShape.top3.partDimA)
							/ Math.tan(mytheta);
				stopAeX = endXA - partDimA / Math.sin(mytheta);
				
				endYA =
							myLevelShape.startingY
							+ myLevelShape.top3.partDimB
							+ myLevelShape.top3.partDimA;
				stopAeY = endYA;
			} else if (endTypeLT == 3) {
				mytheta =
							Math.atan(myLevelShape.dimD2
										/ myLevelShape.dimA1);
				endXA =
							endX
							+ (partDimB + partDimA)
							/ Math.sin(mytheta);
				
				endYA = endY;
				
			}
		}
		
		if (myLean4 == 1 || myLean4 == 3) {
			
			theta =
						Math
						.atan(myLevelShape.dimA1
									/ myLevelShape.dimD2);
			hypotenus = (partDimB + partDimA) / Math.sin(theta);
			double yExtensionLeft =
						(myLevelShape.left.partDimB + myLevelShape.left.partDimA)
						/ Math.tan(theta);
			if (endTypeRB == 1 || endTypeRB == 0) {
				startYA = startY + hypotenus - yExtensionLeft;
				
			} else if (endTypeRB == 2) {
				yExtensionLeft =
							(myLevelShape.left.partDimB + myLevelShape.left.partDimA)
							/ Math.tan(theta);
				startYA = startY + hypotenus - yExtensionLeft;
				
				stopAsY = startYA - partDimA / Math.sin(theta);
			} else {
				startYA = startY + hypotenus;
			}
			
		}
		
		// /
		
		if (myLean2 == 2 || myLean2 == 3) {
			
		}
		
		if (myLean3 == 0 || myLean3 == 2) {
			if (endTypeRB == 1 || endTypeRB == 0) {
				startXA =
							startX
							+ myLevelShape.left.partDimB
							+ myLevelShape.left.partDimA;
			} else {
				
				startXA =
							startX
							+ myLevelShape.left.partDimB
							+ myLevelShape.left.partDimA;
				;
				stopAsX = startXA;
			}
		} else {
			theta =
						Math.atan(myLevelShape.heightPix
									/ myLevelShape.dimC2);
			if (endTypeRB == 1 || endTypeRB == 0) {
				startXA =
							startX
							+ (myLevelShape.left.partDimB + myLevelShape.left.partDimA)
							/ Math.sin(theta)
							+ (partDimB + partDimA)
							/ Math.tan(theta);
			} else if (endTypeRB == 2) {
				startXA =
							startX
							+ (partDimB + partDimA)
							/ Math.tan(theta);
			} else {
				startXA =
							startX
							+ (partDimB + partDimA)
							/ Math.tan(theta);
			}
			
		}
		
		if (myLean3 == 0 || myLean3 == 1) {
			
		} else {
			
		}
		
		if (myLevelShape.leftShape == 0) {
			startYA = myLevelShape.bot1.endYA;
			startXA = myLevelShape.bot1.endXA;
			
		}
		if (myLean3 == 3 || myLean3 == 1) {
			final double theta1 =
						Math
						.atan(myLevelShape.dimC2
									/ myLevelShape.dimD1);
			final double theta2 =
						Math
						.atan(myLevelShape.dimA1
									/ myLevelShape.dimD2);
			final double myTheta =
						Math.toRadians(180) - theta1 - theta2;
			hypotenus = (partDimB + partDimA) / Math.sin(myTheta / 2);
			final double baseY =
						hypotenus * Math.cos(myTheta / 2 + theta1);
			final double baseX =
						hypotenus * Math.sin(myTheta / 2 + theta1);
			startXA = startX + baseX;// base;
			
			startYA = startY + baseY;
		}
		if (myLevelShape.top3.posInUse
					&& myLevelShape.noSidesLeft == 1
					&& myLean4 == 3) {
			if (endTypeRB == 1 || endTypeRB == 0) { // Mitered
				startXA =
							startX
							+ myLevelShape.left.partDimB
							+ myLevelShape.left.partDimA;
			} else {// Straight Cut
				
				startXA = startX;
			}
			theta =
						Math
						.atan(myLevelShape.dimA1
									/ myLevelShape.dimD2);
			hypotenus = (partDimB + partDimA) / Math.sin(theta);
			final double yExtensionLeft =
						(myLevelShape.left.partDimB + myLevelShape.left.partDimA)
						/ Math.tan(theta);
			if (endTypeRB == 1
						|| endTypeRB == 0
						|| endTypeRB == 3) {
				startYA =
							myLevelShape.startingY
							+ myLevelShape.dimD2
							+ hypotenus
							- yExtensionLeft;
			} else {
				startYA =
							myLevelShape.startingY
							+ myLevelShape.dimD2
							+ hypotenus;
			}
		}
		if (stopAeX == 0) {
			stopAeX = endXA;
		}
		if (stopAsX == 0) {
			stopAsX = startXA;
		}
		if (stopAeY == 0) {
			stopAeY = endYBA;
		}
		if (stopAsY == 0) {
			stopAsY = startYBA;
		}
		// ////////
		if (!myLevelShape.top3.posInUse
					&& myLevelShape.lean4 != 1
					&& myLevelShape.lean4 != 3
					&& (myLevelShape.lean2 == 2 || myLevelShape.lean2 == 3)) {
			theta =
						Math
						.atan(myLevelShape.dimB1
									/ myLevelShape.dimA2);
			if (myLean3 == 1 || myLean3 == 3) {
				if (endTypeRB == 1 || endTypeRB == 0) { // Mitered
					startXA =
								myLevelShape.startingX
								+ (partDimB + partDimA)
								/ Math.tan(theta)
								+ (myLevelShape.left.partDimB + myLevelShape.left.partDimA)
								/ Math.sin(theta);
				} else if (endTypeRB == 2) {// Straight Cut
					startXA =
								myLevelShape.startingX
								+ (partDimB + partDimA)
								/ Math.tan(theta)
								+ (myLevelShape.left.partDimB + myLevelShape.left.partDimA)
								/ Math.sin(theta);
					stopAsX = startXA - partDimA / Math.tan(theta);
				} else if (endTypeRB == 3) {
					startXA =
								myLevelShape.startingX
								+ (partDimB + partDimA)
								/ Math.tan(theta)
								+ myLevelShape.left.partDimB
								/ Math.sin(theta);
				}
			}
			if (myLean3 == 3) {
				myLean3 = 0;
				myLevelShape.dimC1 =
							myLevelShape.dimC0
							+ myLevelShape.dimC1
							+ myLevelShape.dimC2;
			}
			if (myLean3 == 2 || myLean3 == 0) {
				theta =
							Math.atan(myLevelShape.heightPix
										/ myLevelShape.dimC2);
				if (endTypeRB == 1 || endTypeRB == 0) { // Mitered
					startXA =
								startX
								+ myLevelShape.left.partDimB
								+ myLevelShape.left.partDimA;
				} else if (endTypeRB == 2) {// Straight Cut
					startXA =
								startX
								+ myLevelShape.left.partDimB
								+ myLevelShape.left.partDimA;
				} else if (endTypeRB == 3) {
					startXA = startX;
				}
			}
			
			theta =
						Math
						.atan(myLevelShape.dimB1
									/ myLevelShape.dimA2);
			if (endTypeLT == 1 || endTypeLT == 0) {
				endXA =
							endX
							+ (partDimB + partDimA)
							/ Math.tan(theta)
							- (myLevelShape.left.partDimB + myLevelShape.left.partDimA)
							/ Math.sin(theta);
			} else if (endTypeLT == 2) {
				endXA =
							myLevelShape.startingX
							+ myLevelShape.dimA1
							+ (partDimB + partDimA)
							/ Math.tan(theta)
							- (myLevelShape.left.partDimB + myLevelShape.left.partDimA)
							/ Math.sin(theta);
				stopAeX =
							myLevelShape.startingX
							+ myLevelShape.dimA1
							+ (partDimB + partDimA)
							/ Math.tan(theta)
							- (myLevelShape.left.partDimB + myLevelShape.left.partDimA)
							/ Math.sin(theta)
							- partDimA
							/ Math.tan(theta);
			} else if (endTypeLT == 3) {
				endXA =
							myLevelShape.startingX
							+ myLevelShape.dimA1
							+ (partDimB + partDimA)
							/ Math.tan(theta)
							- myLevelShape.left.partDimB
							/ Math.sin(theta);
			}
			
		}
		// /////////
		if (myLevelShape.shapeID == 704) {
			final double myTheta =
						Math.atan(myLevelShape.heightPix
									/ myLevelShape.dimA1);
			if (endTypeRB == 1 || endTypeRB == 0) {
				startXA =
							startX
							+ (partDimB + partDimA)
							/ Math.sin(myTheta)
							+ (myLevelShape.bot1.partDimB + myLevelShape.bot1.partDimA)
							/ Math.tan(myTheta);
				startYA =
							startY
							- myLevelShape.bot1.partDimB
							- myLevelShape.bot1.partDimA;
			} else if (endTypeRB == 2) {
				startXA =
							startX
							+ (partDimB + partDimA)
							/ Math.sin(myTheta)
							+ (myLevelShape.bot1.partDimB + myLevelShape.bot1.partDimA)
							/ Math.tan(myTheta);
				startYA =
							startY
							- myLevelShape.bot1.partDimB
							- myLevelShape.bot1.partDimA;
				stopAsX = startXA - partDimA / Math.sin(myTheta);
				stopAsY = startYA;
			} else if (endTypeRB == 3) {
				startXA =
							startX
							+ (partDimB + partDimA)
							/ Math.sin(myTheta);
				startYA = startY;
			}
			
			// if (this.endTypeLT==1 ||
			// this.endTypeLT==0){
			// myTheta = (double)
			// Math.atan(this.myLevelShape.dimA0/this.myLevelShape.hL)
			// ;
			// this. endXA = this.endX ;
			// this.endYA =
			// this.myLevelShape.startingY +
			// (this.partDimB +
			// this.partDimA)/(double)
			// Math.sin(myTheta);
			// }else if (this.endTypeLT==2){
			// this. endXA = this.endX ;
			// this.endYA =
			// this.myLevelShape.startingY +
			// (this.partDimB +
			// this.partDimA)/(double)
			// Math.sin(myTheta);
			// } else if(this.endTypeLT==3){
			// this. endXA = this.endX ;
			// this.endYA =
			// this.myLevelShape.startingY +
			// (this.partDimB +
			// this.partDimA)/(double)
			// Math.sin(myTheta);
			// }
		}
		
		slopeA = (startYA - endYA) / (startXA - endXA);
		lengthA =
					Math.sqrt(Math.pow((Math.max(endXA, startXA) - Math
								.min(endXA, startXA)), 2)
								+ Math.pow((Math.max(endYA, startYA) - Math
											.min(endYA, startYA)), 2));
		radius1A = 0;
		radius2A = 0;
		bkgrdWidthA = myLevelShape.widthPix - myLevelShape.dimA2;
		bkgrdHeightA = myLevelShape.heightPix;
		ltAngle = Math.atan((endX - endXA) / (endY - endYA));
		rbAngle = Math.atan((startX - startXA) / (startY - startYA));
	}
	
	public void setTopObjectInitData() {// Inititalize from
		
		// Rules Execute
		// Rules
		// should pass the entire part object to
		// this Side
		// object
		
		partShape = 0; // L, T, Z, I, H,
		ABClines = 0; // if reflects lines for
		// ABC dims of
		// parts, by T
		// partDimA = 0f / scale;
		// partDimB = 0 / scale;
		// partDimC = 0 / scale;
		// partDimM = 0f / scale;
		partID = 999;
		stockCode = "Profile";
	}
	
	private void topFormElliptical(final int line) {
		
		final Arc2D.Double arc1 =
					new Arc2D.Double(
								bkgrdStartX,
								bkgrdStartY,
								bkgrdWidth,
								bkgrdHeight,
								0,
								180,
								Arc2D.OPEN);
		
		this.getPoints(arc1, 1);
		xCoordBo = xCoordB.toArray();
		yCoordBo = yCoordB.toArray();
		
		// this.ellipse2BAalt(0, this.startX,
		// this.startY,
		// this.endX, this.endY,
		// 1, 1);
		if (line == 2) {
			this.ellipse2BAalt(
						partDimB,
						startXBA,
						startYBA,
						endXBA,
						endYBA,
						line,
						1);
		} else if (line == 3) {
			this.ellipse2BAalt(
						(partDimB + partDimA),
						startXA,
						startYA,
						endXA,
						endYA,
						line,
						1);
		}
		
	}
	
	public void ellipse2BAalt(
				final double distance,
				final double movetoX,
				final double movetoY,
				final double endX,
				final double endY,
				final int lineNo,
				final int topBot) {// 1=top
		
		// 2
		// =
		// bot
		double xs = 0;
		double ys = 0;
		double myNewY = 0;
		double myNewX = 0;
		
		double lastX = 100000000;
		final double t = 0;
		final int startXCompare = (int) movetoX;
		final int endXCompare = (int) endX;
		int xCompare = (int) movetoX;
		
		for (int i = 0; i < xCoordBo.length; i++) {
			xs = (Double) xCoordBo[i];
			xCompare = (int) xs;
			ys = (Double) yCoordBo[i];// p+
			// this.startingX
			
			if (shapeID == 401 && !leftIn) {
				if ((Double) xCoordBo[i] <= endX) {
					if ((Double) xCoordBo[i] >= 0) {
						
						if (xs == parentW + startingX) {
							myNewY = ys;
							myNewX = xs - distance;
						} else if (xs == startX) {
							myNewY = ys;
							myNewX = xs + distance;
						} else if (xs == (parentW + startingX) / 2) {
							myNewY = ys + distance;
							myNewX = xs;
						} else if (xs < startingX + parentW / 2
									&& xs > startX) {
							if (i > 0) {
								final double slopeLine =
											((Double) xCoordBo[i - 1] - (Double) xCoordBo[i])
											/ ((Double) yCoordBo[i - 1] - (Double) yCoordBo[i]);
								final double slopePerp =
											-1 / slopeLine;
								final double thetaSlopeLine =
											Math.atan(slopePerp);
								final double deltaYS =
											distance
											* Math
											.cos(thetaSlopeLine);
								final double deltaXS =
											distance
											* Math
											.sin(thetaSlopeLine);
								myNewY = ys + deltaYS;
								myNewX = xs + deltaXS;
								if (myNewX > this.endX) {
									myNewX = this.endX;
								}
								if (myNewX == startX) {
									myNewY = startY;
									
								}
								
							}
						}
						if (myNewX > 0) {
							if (myNewX != lastX) {
								
								lastX = myNewX;
								
								if (Math.abs(xCompare - endXCompare) <= t
											&& lineNo == 2) {
									endYBA = myNewY;
									// System.out.printf("\n 401 L out BA myX ="
									// +
									// myNewX + " myY =" +
									// myNewY);
								} else if (Math.abs(xCompare
											- endXCompare) <= t
											&& lineNo == 3) {
									endYA = myNewY;
								}
							}
							
						}
						
					}
					
				}
			}
			if (shapeID == 401 && leftIn) {
				if ((Double) xCoordBo[i] <= endX
							&& (Double) xCoordBo[i] >= movetoX) {
					if ((Double) xCoordBo[i] >= 0) {
						
						if (i > 0) {
							final double slopeLine =
										((Double) xCoordBo[i - 1] - (Double) xCoordBo[i])
										/ ((Double) yCoordBo[i - 1] - (Double) yCoordBo[i]);
							final double slopePerp = -1 / slopeLine;
							final double thetaSlopeLine =
										Math.atan(slopePerp);
							final double deltaYS =
										distance
										* Math
										.cos(thetaSlopeLine);
							final double deltaXS =
										distance
										* Math
										.sin(thetaSlopeLine);
							myNewY = ys + deltaYS;
							myNewX = xs + deltaXS;
							if (myNewX > this.endX) {
								myNewX = this.endX;
							}
							if (myNewX == startX) {
							}
						}
						
						if (myNewX > 0) {
							if (myNewX != lastX) {
								
								lastX = myNewX;
								if (Math.abs(xCompare
											- startXCompare) <= t
											&& lineNo == 2) {
									startYBA = myNewY;
									// System.out
									// .printf("\n  401 Left in  BA myX ="
									// +
									// myNewX + " myY ="
									// +
									// myNewY);
								} else if (Math.abs(xCompare
											- startXCompare) <= t
											&& lineNo == 3) {
									startYA = myNewY;
								}
								if (Math.abs(xCompare - endXCompare) <= t
											&& lineNo == 2) {
									endYBA = myNewY;
									// System.out.printf("\n END 401 in BA myX ="
									// +
									// myNewX + " myY =" +
									// myNewY);
								} else if (Math.abs(xCompare
											- endXCompare) <= t
											&& lineNo == 3) {
									endYA = myNewY;
								}
							}
							
						}
					}
					
				}
			} else if (shapeID == 402 && !rightIn) {
				if ((Double) xCoordBo[i] >= movetoX) {
					if ((Double) xCoordBo[i] >= 0) {
						
						if (xs == parentW + startingX) {
							myNewY = ys;
							myNewX = xs - distance;
						} else if (xs == startX) {
							myNewY = ys;
							myNewX = xs + distance;
						} else if (xs == (parentW + startingX) / 2) {
							myNewY = ys + distance;
							myNewX = xs;
						} else if (xs > startingX + parentW / 2) {// &&
							// xs
							// <=
							// this.parentW+this.startingX){
							if (i > 0) {
								// m=
								// y2-y1/x2-x1
								final double slopeLine =
											((Double) xCoordBo[i] - (Double) xCoordBo[i - 1])
											/ ((Double) yCoordBo[i] - (Double) yCoordBo[i - 1]);
								final double thetaSlopeLine =
											Math.atan(slopeLine);
								final double alphaSlopeLine =
											Math.toRadians(90)
											- thetaSlopeLine;
								final double deltaYS =
											distance
											* Math
											.cos(alphaSlopeLine);
								final double deltaXS =
											distance
											* Math
											.sin(alphaSlopeLine);
								
								myNewY = ys + deltaYS;
								myNewX = xs - deltaXS;
								
								if (myNewX < movetoX) {
									myNewX = movetoX;
								}
								
							}
							
						} else if (xs < startingX + parentW / 2
									&& xs > startX) {
							if (i > 0) {
								final double slopeLine =
											((Double) xCoordBo[i - 1] - (Double) xCoordBo[i])
											/ ((Double) yCoordBo[i - 1] - (Double) yCoordBo[i]);
								final double slopePerp =
											-1 / slopeLine;
								final double thetaSlopeLine =
											Math.atan(slopePerp);
								final double deltaYS =
											distance
											* Math
											.cos(thetaSlopeLine);
								final double deltaXS =
											distance
											* Math
											.sin(thetaSlopeLine);
								myNewY = ys + deltaYS;
								myNewX = xs + deltaXS;
								if (myNewX > this.endX) {
									myNewX = this.endX;
								}
								if (myNewX == startX) {
									myNewY = startY;
								}
								
							}
						}
						if (myNewX > 0) {
							if (myNewX != lastX) {
								
								lastX = myNewX;
								if (Math.abs(xCompare
											- startXCompare) <= t
											&& lineNo == 2) {
									startYBA = myNewY;
								} else if (Math.abs(xCompare
											- startXCompare) <= t
											&& lineNo == 3) {
									startYA = myNewY;
								}
								
							}
							
						}
					}
					
				}
			} else if (shapeID == 402 && rightIn) {
				if ((Double) xCoordBo[i] <= endX) {
					if ((Double) xCoordBo[i] >= 0) {
						
						if (xs == parentW + startingX) {
							myNewY = ys;
							myNewX = xs - distance;
						} else if (xs == startX) {
							myNewY = ys;
							myNewX = xs + distance;
						} else if (xs == (parentW + startingX) / 2) {
							myNewY = ys + distance;
							myNewX = xs;
						} else if (xs > startingX + parentW / 2) {// &&
							// xs
							// <=
							// this.parentW+this.startingX){
							if (i > 0) {
								// m=
								// y2-y1/x2-x1
								final double slopeLine =
											((Double) xCoordBo[i] - (Double) xCoordBo[i - 1])
											/ ((Double) yCoordBo[i] - (Double) yCoordBo[i - 1]);
								final double thetaSlopeLine =
											Math.atan(slopeLine);
								final double alphaSlopeLine =
											Math.toRadians(90)
											- thetaSlopeLine;
								final double deltaYS =
											distance
											* Math
											.cos(alphaSlopeLine);
								final double deltaXS =
											distance
											* Math
											.sin(alphaSlopeLine);
								
								myNewY = ys + deltaYS;
								myNewX = xs - deltaXS;
								
								if (myNewX < movetoX) {
									myNewX = movetoX;
								}
								
							}
							
						} else if (xs < startingX + parentW / 2
									&& xs > startX) {
							if (i > 0) {
								final double slopeLine =
											((Double) xCoordBo[i - 1] - (Double) xCoordBo[i])
											/ ((Double) yCoordBo[i - 1] - (Double) yCoordBo[i]);
								final double slopePerp =
											-1 / slopeLine;
								final double thetaSlopeLine =
											Math.atan(slopePerp);
								final double deltaYS =
											distance
											* Math
											.cos(thetaSlopeLine);
								final double deltaXS =
											distance
											* Math
											.sin(thetaSlopeLine);
								myNewY = ys + deltaYS;
								myNewX = xs + deltaXS;
								if (myNewX > this.endX) {
									myNewX = this.endX;
								}
								if (myNewX == startX) {
									myNewY = startY;
								}
								
							}
						}
						if (myNewX > 0) {
							if (myNewX != lastX) {
								
								lastX = myNewX;
								if (Math.abs(xCompare
											- startXCompare) <= t
											&& lineNo == 2) {
									startYBA = myNewY;
								} else if (Math.abs(xCompare
											- startXCompare) <= t
											&& lineNo == 3) {
									startYA = myNewY;
								}
								if (Math.abs(xCompare - endXCompare) <= t
											&& lineNo == 2) {
									endYBA = myNewY;
								} else if (Math.abs(xCompare
											- endXCompare) <= t
											&& lineNo == 3) {
									endYA = myNewY;
								}
							}
							
						}
					}
					
				}
			} else if (shapeID == 403) {
				if ((Double) xCoordBo[i] <= endX
							&& (Double) xCoordBo[i] >= movetoX) {
					if ((Double) xCoordBo[i] >= 0) {
						
						if (xs == parentW + startingX) {
							myNewY = ys;
							myNewX = xs - distance;
						} else if (xs == startX) {
							myNewY = ys;
							myNewX = xs + distance;
						} else if (xs == (parentW + startingX) / 2) {
							myNewY = ys + distance;
							myNewX = xs;
						} else if (xs > startingX + parentW / 2) {// &&
							// xs
							// <=
							// this.parentW+this.startingX){
							if (i > 0) {
								// m=
								// y2-y1/x2-x1
								final double slopeLine =
											((Double) xCoordBo[i] - (Double) xCoordBo[i - 1])
											/ ((Double) yCoordBo[i] - (Double) yCoordBo[i - 1]);
								final double thetaSlopeLine =
											Math.atan(slopeLine);
								final double alphaSlopeLine =
											Math.toRadians(90)
											- thetaSlopeLine;
								final double deltaYS =
											distance
											* Math
											.cos(alphaSlopeLine);
								final double deltaXS =
											distance
											* Math
											.sin(alphaSlopeLine);
								
								myNewY = ys + deltaYS;
								myNewX = xs - deltaXS;
								
								if (myNewX < movetoX) {
									myNewX = movetoX;
								}
								
							}
							
						} else if (xs < startingX + parentW / 2
									&& xs > startX) {
							if (i > 0) {
								final double slopeLine =
											((Double) xCoordBo[i - 1] - (Double) xCoordBo[i])
											/ ((Double) yCoordBo[i - 1] - (Double) yCoordBo[i]);
								final double slopePerp =
											-1 / slopeLine;
								final double thetaSlopeLine =
											Math.atan(slopePerp);
								final double deltaYS =
											distance
											* Math
											.cos(thetaSlopeLine);
								final double deltaXS =
											distance
											* Math
											.sin(thetaSlopeLine);
								myNewY = ys + deltaYS;
								myNewX = xs + deltaXS;
								if (myNewX > this.endX) {
									myNewX = this.endX;
								}
								if (myNewX == startX) {
									myNewY = startY;
								}
								
							}
						}
						if (myNewX > 0) {
							if (myNewX != lastX) {
								
								lastX = myNewX;
								if (Math.abs(xCompare
											- startXCompare) <= t
											&& lineNo == 2) {
									startYBA = myNewY;
								} else if (Math.abs(xCompare
											- startXCompare) <= t
											&& lineNo == 3) {
									startYA = myNewY;
								}
								if (Math.abs(xCompare - endXCompare) <= t
											&& lineNo == 2) {
									endYBA = myNewY;
								} else if (Math.abs(xCompare
											- endXCompare) <= t
											&& lineNo == 3) {
									endYA = myNewY;
								}
							}
							
						}
					}
					
				}
			}
			
		}
		
	}
	
	public void getPoints(final Arc2D.Double arc, final int topBot) {
		
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
	
	public double intersectX(
				final double x1,
				final double y1,
				final double x2,
				final double y2,
				final double bx1,
				final double by1,
				final double bx2,
				final double by2) {
		
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
	
	public double intersectY(
				final double x1,
				final double y1,
				final double x2,
				final double y2,
				final double bx1,
				final double by1,
				final double bx2,
				final double by2) {
		
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
	
	
    public Top1Object clone() {
        try {

            Top1Object newObject = (Top1Object)super.clone();

            return newObject;

        } catch (CloneNotSupportedException e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }
	
}

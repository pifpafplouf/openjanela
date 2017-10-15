/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Model.ProfileParts;

import Model.ShapeObject;
import org.apache.log4j.Logger;

public class Bot3Object extends ProfileParts implements Cloneable {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(Bot3Object.class);
	
	//MyScale property
	public double myScale = 0;
	
	/**
	 * Create Bot3Object
	 */
	public Bot3Object() {
		posInUse = false;
		position = 5; // 1
	}
	
	/**
	 * Create Bot3Object for ProfileParts
	 *
	 * @param levelShape, ShapeObject
	 * @param newPart,    boolean
	 */
	public Bot3Object(ShapeObject levelShape, boolean newPart) {
		
		//Call former constructor
		this();
		
		this.myParent = levelShape;
		// myScale = myParent.myMainPanel.scale;
		this.startingX = this.myParent.startingX;
		this.startingY = this.myParent.startingY;
		this.bkgrdStartX = this.myParent.startingX;
		this.bkgrdStartY = this.myParent.startingY;
		this.setLeanTo();
		if (newPart) {
			this.setBotObjectInitData();
		} else {
			this.partID = this.myParent.bot3.partID;
			this.partDimB = this.myParent.bot3.partDimB;
			this.partDimA = this.myParent.bot3.partDimA;
			this.partDimC = this.myParent.bot3.partDimC;
			this.partDimM = this.myParent.bot3.partDimM;
			this.endTypeLT = this.myParent.bot3.endTypeLT;
			this.endTypeRB = this.myParent.bot3.endTypeRB;
			
		}
	}
	
	public void setLeanTo() {
		
		this.myLean = this.myParent.lean;
		this.myLean2 = this.myParent.lean2;
		this.myLean3 = this.myParent.lean3;
		this.myLean4 = this.myParent.lean4;
		
	}
	
	public void setBotObjectInitData() {// Inititalize from
		
		// Rules Execute
		// Rules
		// should pass the entire part object to
		// this Side
		// object
		
		this.partShape = 0; // L, T, Z, I, H,
		this.ABClines = 0; // if reflects lines for
		// ABC dims of
		// parts, by T
		this.partDimA = 0 / this.myScale;
		this.partDimB = 0 / this.myScale;
		this.partDimC = 0 / this.myScale;
		this.partDimM = 0f / this.myScale;
		this.partID = 999;
		this.stockCode = "FramePart";
	}
	
	public void bot1StraightLineB() {
		
		this.partForm = 1;
		
		this.startY = this.myParent.bY3;
		this.endY = this.startY;
		this.startX = this.myParent.bX3 - this.myParent.dimC0;
		this.endX = this.myParent.bX4 + this.myParent.dimC2;
		
		this.slope =
					(this.startY - this.endY) / (this.startX - this.endX);
		this.length =
					Math
					.sqrt(Math.pow((Math.max(
								this.endX,
								this.startX) - Math.min(
											this.endX,
											this.startX)), 2)
											+ Math.pow((Math.max(
														this.endY,
														this.startY) - Math.min(
																	this.endY,
																	this.startY)), 2));
		this.radius1 = 0;
		this.radius2 = 0;
		this.bkgrdWidth = this.myParent.widthPix;
		this.bkgrdHeight = this.myParent.heightPix;
		
	}
	
	public void bot1StraightLineBA() {
		
		this.partForm = 1;
		
		this.startYBA = this.startY - this.partDimB;
		this.endYBA = this.startY - this.partDimB;
		;
		
		double myTheta =
					Math.atan(this.myParent.dimB2 / this.myParent.dimC0);
		double hypotenus = this.partDimB / Math.sin(myTheta);
		if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
			
			this.startXBA =
						this.startX - hypotenus + this.partDimB
						/ Math.tan(myTheta);
			
		} else if (this.endTypeRB == 2) {// Straight Cut
			
			this.startXBA =
						this.startX + this.partDimB / Math.tan(myTheta);
			
		} else if (this.endTypeRB == 3) {
			
			this.startXBA =
						this.startX - hypotenus + this.partDimB
						/ Math.tan(myTheta);
			
		}
		
		myTheta =
					Math.atan(this.myParent.dimD1 / this.myParent.dimC2);
		hypotenus = this.partDimB / Math.sin(myTheta);
		
		if (this.endTypeLT == 1 || this.endTypeLT == 0) {
			this.endXBA =
						this.myParent.bX4
						+ this.myParent.dimC2
						+ hypotenus - this.partDimB
						/ Math.tan(myTheta);
		} else if (this.endTypeLT == 2) {
			this.endXBA =
						this.myParent.bX4 + this.myParent.dimC2 - this.partDimB
						/ Math.tan(myTheta);
			
		} else if (this.endTypeLT == 3) {
			this.endXBA =
						this.myParent.bX4
						+ this.myParent.dimC2
						+ hypotenus - this.partDimB
						/ Math.tan(myTheta);
		}
		
	}
	
	public void bot1StraightLineA() {
		
		this.partForm = 1;
		if (this.myParent.a_levelID == 3) {
			// System.out.print("hello");
		}
		
		this.startYA =
					this.myParent.bY3 - (this.partDimB + this.partDimA);
		this.stopAsY = this.startYBA;
		this.endYA =
					this.myParent.bY4 - (this.partDimB + this.partDimA);
		this.stopAeY = this.endYBA;
		
		final double theta =
					Math.atan(this.myParent.dimB2 / this.myParent.dimC0);
		double hypotenus =
					(this.myParent.right.partDimB + this.myParent.right.partDimA) / Math
					.sin(theta);
		if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
			this.startXA =
						this.startX - hypotenus + (this.partDimB + this.partDimA)
						/ Math.tan(theta);
		} else if (this.endTypeRB == 2) {// Straight Cut
			this.startXA =
						this.startX
						- (this.myParent.right.partDimB + this.myParent.right.partDimA)
						/ Math.sin(theta) + (this.partDimB + this.partDimA)
						/ Math.tan(theta);
			this.stopAsX =
						this.startXA - this.partDimA / Math.tan(theta);
		} else if (this.endTypeRB == 3) {
			this.startXA =
						this.startX + (this.myParent.right.partDimB + this.myParent.right.partDimA)
						/ Math.tan(theta);
		}
		final double myTheta =
					Math.atan(this.myParent.dimD1 / this.myParent.dimC2);
		hypotenus =
					(this.partDimB + this.partDimA) / Math.sin(myTheta);
		if (this.endTypeLT == 1 || this.endTypeLT == 0) {
			this.endXA =
						this.myParent.bX4
						+ this.myParent.dimC2
						+ hypotenus - (this.partDimB + this.partDimA)
						/ Math.tan(myTheta);
		} else if (this.endTypeLT == 2) {
			this.endXA =
						this.endX
						- (this.partDimB + this.partDimA)
						/ Math.tan(theta) + (this.myParent.right.partDimB + this.myParent.right.partDimA)
						/ Math.sin(theta);
			
			this.stopAeX =
						this.endXA + this.partDimA / Math.tan(theta);
			
		} else if (this.endTypeLT == 3) {
			this.endXA =
						this.endX - (this.partDimB + this.partDimA)
						/ Math.tan(theta);
		}
		
		if (this.stopAeX == 0) {
			this.stopAeX = this.endXA;
		}
		if (this.stopAsX == 0) {
			this.stopAsX = this.startXA;
		}
		
		if (this.stopAeY == 0) {
			this.stopAeY = this.endYA;
		}
		if (this.stopAsY == 0) {
			this.stopAsY = this.startYA;
		}
		
		this.ltAngle =
					Math.atan((this.endX - this.endXA)
								/ (this.endY - this.endYA));
		this.rbAngle =
					Math.atan((this.startXA - this.startX)
								/ (this.startYA - this.startY));
		
	}

    public Bot3Object clone() {
        try {

            Bot3Object newObject = (Bot3Object)super.clone();

            return newObject;

        } catch (CloneNotSupportedException e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }
}

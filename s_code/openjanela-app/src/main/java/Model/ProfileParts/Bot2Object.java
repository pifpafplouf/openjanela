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


public class Bot2Object extends ProfileParts implements Cloneable {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(Bot2Object.class);
	
	//MyScale property
	public double myScale = 0;
	
	/**
	 * Create Bot2Object
	 */
	public Bot2Object() {
		//Initialize values
		posInUse = false;
		position = 7; // 1
	}
	
	/**
	 * Create Bot2Object for ProfileParts
	 *
	 * @param levelShape, ShapeObject
	 * @param newPart,    boolean
	 */
	public Bot2Object(ShapeObject levelShape, boolean newPart) {
		
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
			this.partID = this.myParent.bot2.partID;
			this.partDimB = this.myParent.bot2.partDimB;
			this.partDimA = this.myParent.bot2.partDimA;
			this.partDimC = this.myParent.bot2.partDimC;
			this.partDimM = this.myParent.bot2.partDimM;
			this.endTypeLT = this.myParent.bot2.endTypeLT;
			this.endTypeRB = this.myParent.bot2.endTypeRB;
			
		}
	}
	
	public void setLeanTo() {
		
		this.myLean = this.myParent.lean;
		this.myLean2 = this.myParent.lean2;
		this.myLean3 = this.myParent.lean3;
		this.myLean4 = this.myParent.lean4;
		
	}
	
	public void setBotObjectInitData() {// Inititalize from Rules Execute Rules
		
		// should pass the entire part object to
		// this Side object
		
		this.partShape = 0; // L, T, Z, I, H,
		this.ABClines = 0; // if reflects lines for
		// ABC dims of parts, by T
		this.partDimA = 0 / this.myScale;
		this.partDimB = 0 / this.myScale;
		this.partDimC = 0 / this.myScale;
		this.partDimM = 0f / this.myScale;
		this.partID = 999;
		this.stockCode = "FramePart";
	}
	
	public void lineStraight1B_2() {
		
		this.partForm = 1;
		
		if (this.myParent.a_levelID == 3) {
			// System.out.print("hello");
		}
		this.startY = this.myParent.bY4;
		this.endY = this.myParent.bY4 - this.myParent.dimD0;
		this.startX = this.myParent.startingX + this.myParent.dimC2;
		
		this.endX = this.myParent.startingX;
		
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
		this.bkgrdWidth = this.myParent.widthPix - this.myParent.dimA2;
		this.bkgrdHeight = this.myParent.heightPix;
		
	}
	
	public void lineStraight2BA_2() {
		
		this.partForm = 1;
		if (this.myLean3 == 3 || this.myLean3 == 2) {
			
			double theta1 = Math.atan(this.myParent.dimC2 / this.myParent.dimD1);
			final double theta2 = Math.atan(this.myParent.dimA1 / this.myParent.dimD2);
			final double myTheta = Math.toRadians(180) - theta1 - theta2;
			final double hypotenus = this.partDimB / Math.sin(myTheta / 2);
			final double baseY = hypotenus * Math.cos(myTheta / 2 + theta1);
			final double baseX = hypotenus * Math.sin(myTheta / 2 + theta1);
			
			this.endXBA = this.endX + baseX;// base;
			this.endYBA = this.endY + baseY;
			
			theta1 = Math.atan(this.myParent.dimD1 / this.myParent.dimC2);
			
			if (this.endTypeLT == 1 || this.endTypeLT == 0) { // Mitered
				this.startXBA = this.startX + this.partDimB / Math.sin(theta1) - this.partDimB / Math.tan(theta1);
			} else if (this.endTypeLT == 2) {// Straight Cut
				this.startXBA = this.startX + this.partDimB / Math.sin(theta1);
			} else if (this.endTypeLT == 3) {
				this.startXBA = this.startX + this.partDimB/ Math.sin(theta1);
			}
			this.startYBA = this.startY - this.myParent.bot1.partDimB;
		}
		
		if (this.myParent.bot3.posInUse && this.myParent.noSidesLeft == 1) {
			if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
				this.endXBA = this.endX + this.myParent.left.partDimB;
			} else {// Straight Cut
				this.endXBA = this.endX;
			}
			final double theta = Math.atan(this.myParent.dimC2/ this.myParent.dimD0);
			final double hypotenus = this.partDimB / Math.sin(theta);
			final double yExtensionLeft = this.myParent.left.partDimB / Math.tan(theta);
			if (this.endTypeRB == 1 || this.endTypeRB == 0 || this.endTypeRB == 3) {
				this.endYBA = this.myParent.bY4 - this.myParent.dimD0 - hypotenus + yExtensionLeft;
			} else {
				this.endYBA =
							this.myParent.bY4
							- this.myParent.dimD0
							- hypotenus;
			}
		}
		this.slopeBA =
					(this.startYBA - this.endYBA)
					/ (this.startXBA - this.endXBA);
		this.lengthBA =
					Math.sqrt(Math.pow((Math.max(
								this.endXBA,
								this.startXBA) - Math.min(
											this.endXBA,
											this.startXBA)), 2)
											+ Math.pow((Math.max(
														this.endYBA,
														this.startYBA) - Math.min(
																	this.endYBA,
																	this.startYBA)), 2));
		this.radius1BA = 0;
		this.radius2BA = 0;
		this.bkgrdWidthBA =
					this.myParent.widthPix - this.myParent.dimA2;
		this.bkgrdHeightBA = this.myParent.heightPix;
		
	}
	
	public void lineStraight3A_2() {
		
		this.partForm = 1;
		if (this.myLean3 == 3 || this.myLean3 == 2) {
			
			double theta1 =
						Math.atan(this.myParent.dimC2
									/ this.myParent.dimD1);
			final double theta2 =
						Math.atan(this.myParent.dimA1
									/ this.myParent.dimD2);
			final double myTheta =
						Math.toRadians(180) - theta1 - theta2;
			final double hypotenus =
						(this.partDimB + this.partDimA) / Math
						.sin(myTheta / 2);
			final double baseY =
						hypotenus * Math.cos(myTheta / 2 + theta1);
			final double baseX =
						hypotenus * Math.sin(myTheta / 2 + theta1);
			this.endXA = this.endX + baseX;// base;
			
			this.endYA = this.endY + baseY;
			theta1 =
						Math.atan(this.myParent.dimD1
									/ this.myParent.dimC2);
			if (this.endTypeLT == 1 || this.endTypeLT == 0) { // Mitered
				this.startXA =
							this.startX
							+ (this.partDimB + this.partDimA)
							/ Math.sin(theta1) - (this.partDimB + this.partDimA)
							/ Math.tan(theta1);
			} else if (this.endTypeLT == 2) {// Straight Cut
				this.startXA =
							this.startX + (this.partDimB + this.partDimA)
							/ Math.sin(theta1);
			} else if (this.endTypeLT == 3) {
				this.startXA =
							this.startX + (this.partDimB + this.partDimA)
							/ Math.sin(theta1);
			}
			this.startYA =
						this.startY
						- this.myParent.bot1.partDimB
						- this.myParent.bot1.partDimA;
		}
		if (this.myParent.bot3.posInUse
					&& this.myParent.noSidesLeft == 1) {
			if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
				this.endXA =
							this.endX
							+ this.myParent.left.partDimB
							+ this.myParent.left.partDimA;
			} else {// Straight Cut
				
				this.endXA = this.endX;
			}
			final double theta =
						Math.atan(this.myParent.dimC2
									/ this.myParent.dimD0);
			final double hypotenus =
						(this.partDimB + this.partDimA) / Math
						.sin(theta);
			final double yExtensionLeft =
						(this.myParent.left.partDimB + this.myParent.left.partDimA) / Math
						.tan(theta);
			
			if (this.endTypeRB == 1
						|| this.endTypeRB == 0
						|| this.endTypeRB == 3) {
				this.endYA =
							this.myParent.bY4
							- this.myParent.dimD0
							- hypotenus
							+ yExtensionLeft;
			} else {
				this.endYA =
							this.myParent.bY4
							- this.myParent.dimD0
							- hypotenus;
			}
		}
		this.slopeA =
					(this.startYA - this.endYA)
					/ (this.startXA - this.endXA);
		this.lengthA =
					Math.sqrt(Math.pow((Math
								.max(this.endXA, this.startXA) - Math.min(
											this.endXA,
											this.startXA)), 2)
											+ Math.pow((Math
														.max(this.endYA, this.startYA) - Math
														.min(this.endYA, this.startYA)), 2));
		this.radius1A = 0;
		this.radius2A = 0;
		this.bkgrdWidthA = this.myParent.widthPix - this.myParent.dimA2;
		this.bkgrdHeightA = this.myParent.heightPix;
		this.ltAngle = Math.atan((this.endX - this.endXA) / (this.endY - this.endYA));
		this.rbAngle = Math.atan((this.startX - this.startXA) / (this.startY - this.startYA));
	}

    public Bot2Object clone() {
        try {

            Bot2Object newObject = (Bot2Object)super.clone();

            return newObject;

        } catch (CloneNotSupportedException e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }
	
}

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


public class Top3Object extends ProfileParts implements Cloneable {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(Top3Object.class);
	
	/**
	 * Create Top3Object
	 */
	public Top3Object() {
		//Initializing values
		posInUse = false;
		position = 3;
		color = 1;
	}
	
	/**
	 * Create Top3Object
	 *
	 * @param levelShape, ShapeObject
	 * @param newPart,    boolean
	 */
	public Top3Object(final ShapeObject levelShape, final boolean newPart) {
		
		//Call former constructor
		this();
		
		// super();
		this.myLevelShape = levelShape;
		this.startingX = this.myLevelShape.startingX;
		this.startingY = this.myLevelShape.startingY;
		this.bkgrdStartX = this.myLevelShape.startingX;
		this.bkgrdStartY = this.myLevelShape.startingY;
		this.wire = this.myLevelShape.wire;
		this.radius1 = this.myLevelShape.radius1;
		this.radius2 = this.myLevelShape.radius2;
		this.position = 1;
		if (newPart) {
			this.setTopObjectInitData();
		} else {
			this.partID = this.myLevelShape.top3.partID;
			this.partDimB = this.myLevelShape.top3.partDimB;
			this.partDimA = this.myLevelShape.top3.partDimA;
			this.partDimC = this.myLevelShape.top3.partDimC;
			this.partDimM = this.myLevelShape.top3.partDimM;
			this.endTypeLT = this.myLevelShape.top3.endTypeLT;
			this.endTypeRB = this.myLevelShape.top3.endTypeRB;
			
		}
	}
	
	public void lineStraight1B_2() {
		
		this.startY = this.myLevelShape.startingY;
		this.endY = this.startY;
		this.partForm = 1;
		double theta =
					Math.atan(this.myLevelShape.dimD2
								/ this.myLevelShape.dimA1);
		double hypotenus =
					this.myLevelShape.left.partDimB
					/ Math.sin(theta);
		
		if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
			this.startX =
			this.myLevelShape.startingX
			+ this.myLevelShape.dimA1;
		} else if (this.endTypeRB == 2) {// Straight Cut
			
			this.startX =
						this.myLevelShape.startingX
						+ this.myLevelShape.dimA1;
			
		} else if (this.endTypeRB == 3) {
			
			this.startX =
						this.myLevelShape.startingX
						+ this.myLevelShape.dimA1
						+ hypotenus;
			
		}
		
		if (this.endTypeLT == 1 || this.endTypeLT == 0) {
			this.endX =
						this.myLevelShape.bX2 - this.myLevelShape.dimA2;
		} else if (this.endTypeLT == 2) {
			
			theta =
						Math.atan(this.myLevelShape.heightPix
									/ this.myLevelShape.dimA2);
			hypotenus =
						this.myLevelShape.right.partDimB
						/ Math.sin(theta);
			
			this.endX =
						this.myLevelShape.bX2 - this.myLevelShape.dimA2;
			
		} else if (this.endTypeLT == 3) {
			
			this.endX =
						this.myLevelShape.bX2
						- this.myLevelShape.dimA2
						- hypotenus;
			
		}
		
	}
	
	public void lineStraight2BA_2() {
		
		this.startYBA = this.startY + this.partDimB;
		this.endYBA = this.startYBA;
		
		this.partForm = 1;
		
		final double theta =
					Math.atan(this.myLevelShape.dimD2
								/ this.myLevelShape.dimA1);
		if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
			
			this.startXBA =
						this.startX
						+ this.myLevelShape.left.partDimB
						/ Math.sin(theta)
						- this.partDimB
						/ Math.tan(theta);
			
		} else if (this.endTypeRB == 2) {// Straight Cut
			
			this.startXBA =
						this.startX
						- this.partDimB
						/ Math.tan(theta);
		} else if (this.endTypeRB == 3) {
			this.startXBA = this.startX - // (this.myLevelShape.left.partDimB/(double)
						this.partDimB
						/ Math.tan(theta);
		}
		
		final double myTheta =
					Math.atan(this.myLevelShape.dimB1
								/ this.myLevelShape.dimA2);
		if (this.endTypeLT == 1 || this.endTypeLT == 0) {
			this.endXBA =
						this.endX
						- this.myLevelShape.right.partDimB
						/ Math.sin(myTheta)
						+ this.partDimB
						/ Math.tan(myTheta);
		} else if (this.endTypeLT == 2) {
			this.endXBA =
						this.endX
						+ this.partDimB
						/ Math.tan(myTheta);
		} else {
			this.endXBA =
						this.endX
						+ this.partDimB
						/ Math.tan(myTheta);
		}
	}
	
	public void lineStraight3A_2() {
		
		this.partForm = 1;
		this.partForm = 1;
		
		this.startYA = this.startY + this.partDimB + this.partDimA;
		this.stopAsY = this.startYBA;
		this.endYA = this.startYA;
		this.stopAeY = this.endYBA;
		
		double theta =
					Math.atan(this.myLevelShape.dimD2
								/ this.myLevelShape.dimA1);
		if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
			
			this.startXA =
			this.startX
			+ (this.myLevelShape.left.partDimB + this.myLevelShape.left.partDimA)
			/ Math.sin(theta)
			- (this.partDimB + this.partDimA)
			/ Math.tan(theta);
			
		} else if (this.endTypeRB == 2) {// Straight Cut
			this.startXA =
						this.startXBA
						+ (this.myLevelShape.left.partDimB + this.myLevelShape.left.partDimA)
						/ Math.sin(theta)
						- this.partDimA
						/ Math.tan(theta);
			this.stopAsX =
						this.startXBA
						+ (this.myLevelShape.left.partDimB + this.myLevelShape.left.partDimA)
						/ Math.sin(theta);
			
		} else if (this.endTypeRB == 3) {
			this.startXA = this.startX - // ((this.myLevelShape.left.partDimB+this.myLevelShape.left.partDimA)/(double)
						(this.partDimB + this.partDimA)
						/ Math.tan(theta);
		}
		
		theta =
					Math.atan(this.myLevelShape.dimB1
								/ this.myLevelShape.dimA2);
		if (this.endTypeLT == 1 || this.endTypeLT == 0) {
			this.endXA =
						this.endX
						+ (this.partDimB + this.partDimA)
						/ Math.tan(theta)
						- (this.myLevelShape.left.partDimB + this.myLevelShape.left.partDimA)
						/ Math.sin(theta);
		} else if (this.endTypeLT == 2) {
			this.endXA =
						this.endX
						+ (this.partDimB + this.partDimA)
						/ Math.tan(theta)
						- (this.myLevelShape.left.partDimB + this.myLevelShape.left.partDimA)
						/ Math.sin(theta);
			this.stopAeX =
						this.endXA
						- this.partDimA
						/ Math.tan(theta);
		} else if (this.endTypeLT == 3) {
			this.endXA =
						this.endX
						+ (this.partDimB + this.partDimA)
						/ Math.tan(theta);
		}
		
		if (this.stopAeX == 0) {
			this.stopAeX = this.endXA;
		}
		if (this.stopAsX == 0) {
			this.stopAsX = this.startXA;
		}
		if (this.stopAeY == 0) {
			this.stopAeY = this.endYBA;
		}
		if (this.stopAsY == 0) {
			this.stopAsY = this.startYBA;
		}
		
		this.slopeA =
					(this.startYA - this.endYA)
					/ (this.startXA - this.endXA);
		this.lengthA =
					Math.sqrt(Math.pow((Math.max(
								this.endXA,
								this.startXA) - Math.min(
											this.endXA,
											this.startXA)), 2)
											+ Math.pow((Math.max(
														this.endYA,
														this.startYA) - Math.min(
																	this.endYA,
																	this.startYA)), 2));
		this.radius1A = 0;
		this.radius2A = 0;
		this.bkgrdWidthA =
					this.myLevelShape.widthPix - this.myLevelShape.dimA1;
		this.bkgrdHeightA = this.myLevelShape.heightPix;
		this.ltAngle =
					Math.atan((this.endX - this.endXA)
								/ (this.endY - this.endYA));
		this.rbAngle =
					Math.atan((this.startX - this.startXA)
								/ (this.startY - this.startYA));
	}
	
	public void setTopObjectInitData() {// Inititalize from
		
		// Rules Execute
		// Rules
		// should pass the entire part object to
		// this Side
		// object
		
		this.partShape = 0; // L, T, Z, I, H,
		this.ABClines = 0; // if reflects lines for
		// ABC dims of
		// parts, by T
		// partDimA = 0f / myLevelShape.myMainPanel.scale;
		// partDimB = 0 / myLevelShape.myMainPanel.scale;
		// partDimC = 0 / myLevelShape.myMainPanel.scale;
		// partDimM = 0f / myLevelShape.myMainPanel.scale;
		this.partID = 999;
		this.stockCode = "Profile";
	}

    public Top3Object clone() {
        try {

            Top3Object newObject = (Top3Object)super.clone();

            return newObject;

        } catch (CloneNotSupportedException e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }
	
}

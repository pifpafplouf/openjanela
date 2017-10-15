/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Model.ProfileParts;

import java.math.BigDecimal;

import Model.ShapeObject;

import org.apache.log4j.Logger;


public class Bot1Object extends ProfileParts implements Cloneable {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(Bot1Object.class);
	
	//MyScale property
	public double myScale = 0;
	
	/**
	 * Create Bot1Object
	 */
	public Bot1Object() {
		//Initialize values
		position = 6; // 1
	}
	
	/**
	 * Create Bo1Object for ProfileParts
	 *
	 * @param levelShape, ShapeObject
	 * @param newPart,    boolean
	 */
	public Bot1Object(ShapeObject levelShape, boolean newPart) {
		
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
			this.partID = this.myParent.bot1.partID;
			this.partDimB = this.myParent.bot1.partDimB;
			this.partDimA = this.myParent.bot1.partDimA;
			this.partDimC = this.myParent.bot1.partDimC;
			this.partDimM = this.myParent.bot1.partDimM;
			this.endTypeLT = this.myParent.bot1.endTypeLT;
			this.endTypeRB = this.myParent.bot1.endTypeRB;
		}
	}
	
	public void setBotObjectInitData() {// Inititalize from Rules Execute Rules
		
		// should pass the entire part object to
		// this Side object
		
		this.partShape = 0; // L, T, Z, I, H,
		this.ABClines = 0; // if reflects lines for
		// ABC dims of parts, by T
		this.partDimA = 0f / this.myScale;
		this.partDimB = 0 / this.myScale;
		this.partDimC = 0 / this.myScale;
		this.partDimM = 0f / this.myScale;
		
		this.partID = 999;
		this.stockCode = "FramePart";
	}
	
	public void setLeanTo() {
		
		this.myLean = this.myParent.lean;
		this.myLean2 = this.myParent.lean2;
		this.myLean3 = this.myParent.lean3;
		this.myLean4 = this.myParent.lean4;
		if (this.myParent.shapeID == 700) {
			
			this.myLean = 2;
			
		} else if (this.myParent.shapeID == 701) {
			
			this.myLean = 1;
			
		} else if (this.myParent.shapeID == 702) {
			
			this.myLean4 = 3;
			
		} else if (this.myParent.shapeID == 704) {
			this.myLean = 3;
			
		} else if (this.myParent.shapeID == 705) {
			this.myLean4 = 2;
			
		}
	}
	
	public void bot1StraightLineB() {
		
		this.partForm = 1;
		
		if (this.myParent.leftShape == 0 && this.myLean4 == 3) {
			this.endTypeLT = 1;
		}
		if (this.myParent.rightShape == 0 && this.myLean2 == 3) {
			this.endTypeRB = 1;
		}
		this.startY = this.myParent.bY3;
		this.endY = this.startY;
		
		this.ltAngle = this.myParent.right.rbAngle;
		
		if (this.myLean3 == 2) {// Lean Left
			
			double myTheta =
			Math.atan(this.myParent.heightPix
						/ this.myParent.dimC1);
			
			final double hypotenus =
						this.myParent.right.partDimB / Math.sin(myTheta);
			
			if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
				this.startX =
							this.myParent.startingX + this.myParent.dimC2;
			} else if (this.endTypeRB == 2) {// Straight Cut
				this.startX =
							this.myParent.startingX + this.myParent.dimC2;
				
			} else if (this.endTypeRB == 3) {
				this.startX =
							this.myParent.startingX
							+ this.myParent.dimC2
							- hypotenus;
				
			}
			if (this.myLean == 0 || this.myLean == 1) {
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endX = this.myParent.bX4;
				} else if (this.endTypeLT == 2) {
					this.endX = this.myParent.bX4;
				} else if (this.endTypeLT == 3) {
					this.endX =
								this.myParent.bX4
								+ this.myParent.left.partDimB;
					
				}
			} else {
				myTheta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.dimA1);
				if (this.myLean == 3) {
					myTheta =
								Math.atan(this.myParent.heightPix
											/ this.myParent.dimA0);
				}
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endX = this.myParent.bX4;
				} else if (this.endTypeLT == 2) {
					this.endX = this.myParent.bX4;
				} else if (this.endTypeLT == 3) {
					this.endX =
								this.myParent.bX4 + this.myParent.left.partDimB
								/ Math.sin(myTheta);
					
				}
				
			}
			
			this.myParent.dimC0 = 0;
			
		}
		if (this.myLean3 == 1) { // Lean Right
			
			final double myTheta =
						Math.atan(this.myParent.heightPix
									/ this.myParent.dimC2);
			final double hypotenus =
						this.myParent.left.partDimB / Math.sin(myTheta);
			
			if (this.myLean == 0 || this.myLean == 2) {
				if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
					this.startX = this.myParent.bX2;
				} else if (this.endTypeRB == 2) {// Straight Cut
					this.startX = this.myParent.bX2;
				} else if (this.endTypeRB == 3) {
					
					this.startX =
								this.myParent.bX2
								- this.myParent.right.partDimB;
					
				}
			} else {
				final double theta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.dimA2);
				if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
					this.startX = this.myParent.bX3;
				} else if (this.endTypeRB == 2) {// Straight Cut
					this.startX = this.myParent.bX3;
				} else if (this.endTypeRB == 3) {
					this.startX =
								this.myParent.bX3 - this.myParent.right.partDimB
								/ Math.sin(theta);
					
				}
				
			}
			if (this.endTypeLT == 1 || this.endTypeLT == 0) {
				this.endX = this.myParent.bX4 + this.myParent.dimC2;
			} else if (this.endTypeLT == 2) {
				this.endX = this.myParent.bX4 + this.myParent.dimC2;
				
			} else if (this.endTypeLT == 3) {
				
				this.endX =
							this.myParent.bX4
							+ this.myParent.dimC2
							+ hypotenus;
				
			}
			
			this.myParent.dimC0 = 0;
			
		}
		if (this.myLean3 == 3) { // Centered
			double myTheta =
						Math.atan(this.myParent.heightPix
									/ this.myParent.dimC0);
			double hypotenus =
						this.myParent.right.partDimB / Math.sin(myTheta);
			
			if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
				this.startX = this.myParent.bX3 - this.myParent.dimC0;
			} else if (this.endTypeRB == 2) {// Straight Cut
				
				this.startX = this.myParent.bX3 - this.myParent.dimC0;
				
			} else if (this.endTypeRB == 3) {
				
				this.startX =
							this.myParent.bX3
							- this.myParent.dimC0
							- hypotenus;
				
			}
			
			myTheta =
						Math.atan(this.myParent.heightPix
									/ this.myParent.dimC2);
			hypotenus =
						this.myParent.left.partDimB / Math.sin(myTheta);
			
			if (this.endTypeLT == 1 || this.endTypeLT == 0) {
				this.endX = this.myParent.bX4 + this.myParent.dimC2;
			} else if (this.endTypeLT == 2) {
				
				this.endX = this.myParent.bX4 + this.myParent.dimC2;
				
			} else if (this.endTypeLT == 3) {
				
				this.endX =
							this.myParent.bX4
							+ this.myParent.dimC2
							+ hypotenus;
				
			}
			
		}
		
		if (this.myLean3 == 0) {
			this.startX = this.myParent.bX2;
			this.endX = this.myParent.bX2;
			
			if (this.endTypeRB == 1
						|| this.endTypeRB == 2
						|| this.endTypeRB == 0) {
				this.startX = this.myParent.bX2;
			} else {
				if (this.myLean == 0 || this.myLean == 2) {
					this.startX =
								this.myParent.bX2
								- this.myParent.right.partDimB;
				} else {
					final double theta =
								Math.atan(this.myParent.heightPix
											/ this.myParent.dimA2);
					this.startX =
								this.myParent.bX3 - this.myParent.right.partDimB
								/ Math.sin(theta);
				}
			}
			if (this.endTypeLT == 1
						|| this.endTypeLT == 2
						|| this.endTypeLT == 0) {
				this.endX = this.myParent.startingX;
			} else {
				if (this.myLean == 0 || this.myLean4 == 1) {
					this.endX =
								this.myParent.startingX
								+ this.myParent.left.partDimB;
				} else {
					double theta =
								Math.atan(this.myParent.heightPix
											/ this.myParent.dimA1);
					if (this.myLean == 3) {
						theta =
									Math.atan(this.myParent.heightPix
												/ this.myParent.dimA0);
					}
					this.endX =
								this.myParent.startingX + this.myParent.left.partDimB
								/ Math.sin(theta);
				}
			}
			
			if (this.myLean2 == 0 || this.myLean2 == 2) {
				this.startY = this.myParent.bY3;
				
			}
			
			if (this.myLean2 == 1 || this.myLean2 == 3) {
				final double theta =
							Math.atan(this.myParent.widthPix
										/ this.myParent.dimB2);
				if (this.endTypeRB == 1 || this.endTypeRB == 0) {
					this.startY =
								this.myParent.bY3 - this.myParent.dimB2;
				} else if (this.endTypeRB == 2) {
					this.startY =
								this.myParent.bY3 - this.myParent.dimB2;
				} else {
					this.startY =
								this.myParent.bY3 - this.myParent.dimB2 + this.myParent.right.partDimB
								/ Math.tan(theta);
				}
				
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endY = this.myParent.bY4;
				} else if (this.endTypeLT == 2) {
					this.endY = this.myParent.bY4;
				} else {
					this.endY =
								this.myParent.bY4 - this.myParent.left.partDimB
								/ Math.tan(theta);
				}
				
			}
			
			if (this.myLean4 == 2) {
				
				this.endY =
							this.myParent.startingY + this.myParent.dimD2;
				if (this.endTypeRB == 1 || this.endTypeRB == 0) {
					this.endY =
								this.myParent.startingY
								+ this.myParent.dimD2;
				} else if (this.endTypeRB == 2) {
					this.endY =
								this.myParent.startingY
								+ this.myParent.dimD2;
				} else {
					final double theta =
								Math.atan(this.myParent.widthPix
											/ this.myParent.dimD1);
					this.endY =
								this.endY =
								this.myParent.startingY
								+ this.myParent.dimD2 + this.myParent.left.partDimB
								/ Math.tan(theta);
				}
				final double theta =
							Math.atan(this.myParent.widthPix
										/ this.myParent.dimD1);
				if (this.endTypeRB == 1 || this.endTypeRB == 0) {
					this.startY = this.myParent.bY3;
				} else if (this.endTypeRB == 2) {
					this.startY = this.myParent.bY3;
				} else {
					this.startY =
								this.myParent.bY3 - this.myParent.right.partDimB
								/ Math.tan(theta);
				}
			} else if (this.myLean4 == 3) {
				
				double theta =
							Math.atan(this.myParent.widthPix
										/ this.myParent.dimD0);
				if (this.endTypeRB == 1 || this.endTypeRB == 0) {
					this.startY = this.myParent.bY3;
				} else if (this.endTypeRB == 2) {
					this.startY = this.myParent.bY3;
				} else {
					this.startY =
								this.myParent.bY3 - this.myParent.right.partDimB
								/ Math.tan(theta);
				}
				
				this.endY =
							this.myParent.startingY
							+ this.myParent.dimD2
							+ this.myParent.dimD1;
				if (this.endTypeRB == 1 || this.endTypeRB == 0) {
					this.endY =
								this.myParent.bY4 - this.myParent.dimD0;
				} else if (this.endTypeRB == 2) {
					this.endY =
								this.myParent.bY4 - this.myParent.dimD0;
				} else {
					theta =
								Math.atan(this.myParent.widthPix
											/ this.myParent.dimD0);
					this.endY =
								this.endY =
								this.myParent.bY4
								- this.myParent.dimD0 + this.myParent.left.partDimB
								/ Math.tan(theta);
				}
			}
			
			if (this.myParent.shapeID >= 700
						&& this.myParent.shapeID <= 706) {
				if (this.myParent.leftShape == 0
							&& this.myLean4 == 1
							&& this.myParent.noSidesTop == 1) {
					final double myTheta =
								Math.atan(this.myParent.heightPix
											/ this.myParent.widthPix);
					if (this.endTypeLT == 1
								|| this.endTypeLT == 0) {
						this.endX = this.myParent.startingX;
						this.endY =
									this.myParent.startingY
									+ this.myParent.heightPix;
					} else if (this.endTypeLT == 2) {
						this.endX = this.myParent.startingX;
						this.endY =
									this.myParent.startingY
									+ this.myParent.heightPix;
					} else if (this.endTypeLT == 3) {
						this.endX =
									this.myParent.startingX + this.myParent.top1.partDimB
									/ Math.sin(myTheta);
						this.endY =
									this.myParent.startingY
									+ this.myParent.heightPix;
					}
				}
				if (this.myParent.leftShape == 0
							&& this.myLean4 == 2
							&& this.myParent.noSidesTop == 1) {
					final double myTheta =
								Math.atan(this.myParent.heightPix
											/ this.myParent.widthPix);
					if (this.endTypeLT == 1
								|| this.endTypeLT == 0) {
						this.endX = this.myParent.startingX;
						this.endY = this.myParent.startingY;
					} else if (this.endTypeLT == 2) {
						this.endX = this.myParent.startingX;
						this.endY = this.myParent.startingY;
					} else if (this.endTypeLT == 3) {
						this.endX =
									this.myParent.startingX + this.myParent.top1.partDimB
									/ Math.tan(myTheta);
						this.endY =
									this.myParent.startingY
									+ this.myParent.top1.partDimB;
					}
					
				}
				if (this.myParent.leftShape == 0
							&& this.myLean4 == 3
							&& this.myParent.noSidesTop == 1) {
					Math.atan(this.myParent.dimD2
								/ this.myParent.widthPix);
					if (this.endTypeLT == 1
								|| this.endTypeLT == 0) {
						this.endX = this.myParent.startingX;
						this.endY =
									this.myParent.startingY
									+ this.myParent.dimD2;
					} else if (this.endTypeLT == 2) {
						this.endX = this.myParent.startingX;
						this.endY =
									this.myParent.startingY
									+ this.myParent.dimD2;
					} else if (this.endTypeLT == 3) {
						this.endX = this.myParent.startingX;
						this.endY =
									this.myParent.startingY
									+ this.myParent.dimD2;
					}
					
				}
				if (this.myParent.rightShape == 0
							&& this.myLean2 == 1
							&& this.myParent.noSidesTop == 1) {
					final double myTheta =
								Math.atan(this.myParent.heightPix
											/ this.myParent.widthPix);
					if (this.endTypeRB == 1
								|| this.endTypeRB == 0) {
						this.startX =
									this.myParent.startingX
									+ this.myParent.widthPix;
						this.startY = this.myParent.startingY;
					} else if (this.endTypeRB == 2) {
						this.startX =
									this.myParent.startingX
									+ this.myParent.widthPix;
						this.startY = this.myParent.startingY;
					} else if (this.endTypeRB == 3) {
						this.startX =
									this.myParent.startingX
									+ this.myParent.widthPix - this.myParent.top1.partDimB
									/ Math.tan(myTheta);
						this.startY =
									this.myParent.startingY
									+ this.myParent.top1.partDimB;
					}
					if (this.endTypeLT == 1
								|| this.endTypeLT == 0) {
						this.endX = this.myParent.startingX;
						this.endY =
									this.myParent.startingY
									+ this.myParent.heightPix;
					} else if (this.endTypeLT == 2) {
						this.endX = this.myParent.startingX;
						this.endY =
									this.myParent.startingY
									+ this.myParent.heightPix;
					} else if (this.endTypeLT == 3) {
						this.endX =
									this.myParent.startingX + this.myParent.left.partDimB
									/ Math.tan(myTheta);
						this.endY =
									this.myParent.startingY
									+ this.myParent.heightPix - this.myParent.left.partDimB
									* Math.tan(myTheta);
					}
					
				}
				
				if (this.myParent.rightShape == 0
							&& this.myLean2 == 2
							&& this.myParent.noSidesTop == 1) {
					final double myTheta =
								Math.atan(this.myParent.heightPix
											/ this.myParent.widthPix);
					if (this.endTypeRB == 1
								|| this.endTypeRB == 0) {
						this.startX =
									this.myParent.startingX
									+ this.myParent.widthPix;
						this.startY =
									this.myParent.startingY
									+ this.myParent.heightPix;
					} else if (this.endTypeRB == 2) {
						this.startX =
									this.myParent.startingX
									+ this.myParent.widthPix;
						this.startY =
									this.myParent.startingY
									+ this.myParent.heightPix;
					} else if (this.endTypeRB == 3) {
						this.startX =
									this.myParent.startingX
									+ this.myParent.widthPix - this.myParent.top1.partDimB
									/ Math.sin(myTheta);
						this.startY =
									this.myParent.startingY
									+ this.myParent.heightPix;
					}
				}
				if (this.myParent.rightShape == 0
							&& this.myLean2 == 3
							&& this.myParent.noSidesTop == 1) {
					Math.atan(this.myParent.dimB0
								/ this.myParent.widthPix);
					if (this.endTypeRB == 1
								|| this.endTypeRB == 0) {
						this.startX =
									this.myParent.startingX
									+ this.myParent.widthPix;
						this.startY =
									this.myParent.startingY
									+ this.myParent.dimB0;
					} else if (this.endTypeRB == 2) {
						this.startX =
									this.myParent.startingX
									+ this.myParent.widthPix;
						this.startY =
									this.myParent.startingY
									+ this.myParent.dimB0;
					} else if (this.endTypeRB == 3) {
						this.startX =
									this.myParent.startingX
									+ this.myParent.widthPix;
						this.startY =
									this.myParent.startingY
									+ this.myParent.dimB0;
					}
					
				}
				
			}
		}
		if (this.myParent.shapeID == 704) {
			double myTheta =
						Math.atan(this.myParent.heightPix
									/ this.myParent.dimA2);
			if (this.endTypeLT == 1 || this.endTypeLT == 0) {
				this.endX = this.myParent.startingX;
				this.endY =
							this.myParent.startingY
							+ this.myParent.heightPix;
			} else if (this.endTypeLT == 2) {
				this.endX = this.myParent.startingX;
				this.endY =
							this.myParent.startingY
							+ this.myParent.heightPix;
			} else if (this.endTypeLT == 3) {
				this.endX =
							this.myParent.startingX + this.myParent.top1.partDimB
							/ Math.sin(myTheta);
				this.endY =
							this.myParent.startingY
							+ this.myParent.heightPix;
			}
			myTheta =
						Math.atan(this.myParent.dimA1
									/ this.myParent.heightPix);
			if (this.endTypeRB == 1 || this.endTypeRB == 0) {
				this.startX =
							this.myParent.startingX
							+ this.myParent.widthPix;
				this.startY =
							this.myParent.startingY
							+ this.myParent.heightPix;
			} else if (this.endTypeRB == 2) {
				this.startX =
							this.myParent.startingX
							+ this.myParent.widthPix;
				this.startY =
							this.myParent.startingY
							+ this.myParent.heightPix;
			} else if (this.endTypeRB == 3) {
				this.startX =
							this.myParent.startingX
							+ this.myParent.widthPix - this.myParent.top2.partDimB
							/ Math.sin(myTheta);
				this.startY =
							this.myParent.startingY
							+ this.myParent.heightPix;
			}
		}
		
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
		// this.myLevelShape.verify.checkEndTypes();
	}
	
	public void bot1StraightLineBA() {
		
		this.partForm = 1;
		
		this.startYBA = this.myParent.bY3 - this.partDimB;
		this.endYBA = this.myParent.bY4 - this.partDimB;
		
		if (this.myLean3 == 2) {// Lean Left
			double myTheta =
						Math.atan(this.myParent.heightPix
									/ this.myParent.dimC1);
			final double hypotenus =
						this.myParent.right.partDimB / Math.sin(myTheta);
			if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
				this.startXBA =
							this.myParent.startingX
							+ this.myParent.dimC2
							- hypotenus + this.partDimB
							/ Math.tan(myTheta);
			} else if (this.endTypeRB == 2) {// Straight Cut
				this.startXBA =
							this.myParent.startingX
							+ this.myParent.dimC2 + this.partDimB
							/ Math.tan(myTheta);
			} else if (this.endTypeRB == 3) {
				this.startXBA =
							this.myParent.startingX
							+ this.myParent.dimC2
							- hypotenus + this.partDimB
							/ Math.tan(myTheta);
			}
			
			if (this.myLean == 0 || this.myLean == 1) {
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endXBA =
								this.myParent.startingX
								+ this.myParent.left.partDimB;
				} else if (this.endTypeLT == 2) {
					this.endXBA = this.myParent.startingX;
				} else if (this.endTypeLT == 3) {
					this.endXBA =
								this.myParent.startingX
								+ this.myParent.left.partDimB;
				}
			} else {
				myTheta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.dimA1);
				if (this.myLean == 3) {
					myTheta =
								Math.atan(this.myParent.heightPix
											/ this.myParent.dimA0);
				}
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endXBA =
								this.endX
								+ this.partDimB
								/ Math.tan(myTheta) + this.myParent.left.partDimB
								/ Math.sin(myTheta);
				} else if (this.endTypeLT == 2) {
					this.endXBA =
								this.endX + this.partDimB
								/ Math.tan(myTheta);
				} else if (this.endTypeLT == 3) {
					this.endXBA =
								this.endX + this.partDimB
								/ Math.tan(myTheta);
				}
			}
			
			this.myParent.dimC0 = 0;
			
		}
		
		if (this.myLean3 == 1) { // Lean Right
			final double myTheta =
						Math.atan(this.myParent.heightPix
									/ this.myParent.dimC2);
			final double hypotenus =
						this.myParent.left.partDimB / Math.sin(myTheta);
			if (this.myLean == 0 || this.myLean == 2) {
				if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
					this.startXBA =
								this.myParent.bX3
								- this.myParent.right.partDimB;
				} else if (this.endTypeRB == 2) {// Straight Cut
					this.startXBA = this.myParent.bX3;
				} else if (this.endTypeRB == 3) {
					this.startXBA =
								this.myParent.bX3
								- this.myParent.right.partDimB;
				}
			} else {
				final double xtheta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.dimA2);
				
				if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
					this.startXBA =
								this.startX
								- this.myParent.right.partDimB
								/ Math.sin(myTheta) - this.partDimB
								/ Math.tan(xtheta);
				} else if (this.endTypeRB == 2) {// Straight Cut
					this.startXBA =
								this.startX
								- this.myParent.right.partDimB
								/ Math.sin(myTheta) - this.partDimB
								/ Math.tan(xtheta);
					
				} else if (this.endTypeRB == 3) {
					this.startXBA =
								this.startX - this.partDimB
								/ Math.tan(xtheta);
				}
			}
			
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
			
			this.myParent.dimC0 = 0;
			
		}
		
		if (this.myLean3 == 3) { // Centered
			
			double myTheta =
						Math.atan(this.myParent.heightPix
									/ this.myParent.dimC0);
			double hypotenus =
						this.myParent.right.partDimB / Math.sin(myTheta);
			if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
				
				this.startXBA =
							this.myParent.bX3
							- this.myParent.dimC0
							- hypotenus + this.partDimB
							/ Math.tan(myTheta);
				
			} else if (this.endTypeRB == 2) {// Straight Cut
				
				this.startXBA =
							this.myParent.bX3 - this.myParent.dimC0 + this.partDimB
							/ Math.tan(myTheta);
				
			} else if (this.endTypeRB == 3) {
				
				this.startXBA =
							this.myParent.bX3
							- this.myParent.dimC0
							- hypotenus + this.partDimB
							/ Math.tan(myTheta);
				
			}
			
			myTheta =
						Math.atan(this.myParent.heightPix
									/ this.myParent.dimC2);
			hypotenus =
						this.myParent.left.partDimB / Math.sin(myTheta);
			
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
			
			if (this.myLean2 == 2 || this.myLean2 == 3) {
				myTheta =
							Math.atan(this.myParent.dimB2
										/ this.myParent.dimC0);
				hypotenus =
							this.myParent.right.partDimB / Math
							.sin(myTheta);
				if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
					
					this.startXBA =
					this.myParent.bX3
					- this.myParent.dimC0
					- hypotenus + this.partDimB
					/ Math.tan(myTheta);
				
				} else if (this.endTypeRB == 2) {// Straight Cut
					
					this.startXBA =
					this.myParent.bX3 - this.myParent.dimC0 + this.partDimB
					/ Math.tan(myTheta);
				
				} else if (this.endTypeRB == 3) {
					
					this.startXBA =
								this.myParent.bX3
								- this.myParent.dimC0
								- hypotenus + this.partDimB
								/ Math.tan(myTheta);
					
				}
			}
			if (this.myLean4 == 1 || this.myLean4 == 3) {
				myTheta =
							Math.atan(this.myParent.dimD1
										/ this.myParent.dimC2);
				
				if (this.myLean4 == 3) {
					myTheta =
								Math.atan(this.myParent.dimD0
											/ this.myParent.dimC2);
				}
				
				hypotenus =
							this.myParent.left.partDimB / Math
							.sin(myTheta);
				
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
			
		}
		
		if (this.myLean3 == 0) { // Not leaning
			
			if (this.myLean == 0 || this.myLean == 2) {
				if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
					this.startXBA =
								this.myParent.bX3
								- this.myParent.right.partDimB;
				} else if (this.endTypeRB == 2) {// Straight Cut
					this.startXBA = this.myParent.bX3;
				} else if (this.endTypeRB == 3) {
					this.startXBA =
								this.myParent.bX3
								- this.myParent.right.partDimB;
				}
			} else {
				final double myTheta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.dimA2);
				if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
					this.startXBA =
								this.myParent.bX3
								- this.myParent.right.partDimB
								/ Math.sin(myTheta) - this.partDimB
								/ Math.tan(myTheta);
				} else if (this.endTypeRB == 2) {// Straight Cut
					this.startXBA =
								this.myParent.bX3 - this.partDimB
								/ Math.tan(myTheta);
				} else if (this.endTypeRB == 3) {
					this.startXBA =
								this.myParent.bX3
								- this.myParent.right.partDimB
								/ Math.sin(myTheta) - this.partDimB
								/ Math.tan(myTheta);
				}
				
			}
			
			if (this.myLean == 0 || this.myLean == 1) {
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endXBA =
								this.myParent.startingX
								+ this.myParent.left.partDimB;
				} else if (this.endTypeLT == 2) {
					this.endXBA = this.myParent.startingX;
				} else if (this.endTypeLT == 3) {
					this.endXBA =
								this.myParent.startingX
								+ this.myParent.left.partDimB;
				}
			} else {
				double myTheta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.dimA1);
				if (this.myLean == 3) {
					myTheta =
								Math.atan(this.myParent.heightPix
											/ this.myParent.dimA0);
				}
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endXBA =
								this.myParent.startingX
								+ this.myParent.left.partDimB
								/ Math.sin(myTheta) + this.partDimB
								/ Math.tan(myTheta);
				} else if (this.endTypeLT == 2) {
					this.endXBA =
								this.myParent.startingX + this.partDimB
								/ Math.tan(myTheta);
					
				} else if (this.endTypeLT == 3) {
					this.endXBA =
								this.myParent.startingX
								+ this.myParent.left.partDimB
								/ Math.sin(myTheta) + this.partDimB
								/ Math.tan(myTheta);
				}
			}
			
			if (this.myLean4 == 1 || this.myLean4 == 0) {
				if (this.myLean2 == 0 || this.myLean2 == 2) {
					if (this.endTypeLT == 1
								|| this.endTypeLT == 0) {
						this.endYBA =
									this.myParent.bY4 - this.partDimB;
					} else if (this.endTypeLT == 2) {
						this.endYBA =
									this.myParent.bY4 - this.partDimB;
					} else if (this.endTypeLT == 3) {
						this.endYBA =
									this.myParent.bY4 - this.partDimB;
					}
				} else if (this.myLean2 == 1 || this.myLean2 == 3) {
					
					final double theta =
								Math.atan(this.myParent.widthPix
											/ this.myParent.dimB2);
					if (this.endTypeLT == 1
								|| this.endTypeLT == 0) {
						this.endYBA =
									this.myParent.bY4
									- this.myParent.left.partDimB
									/ Math.tan(theta) - this.partDimB
									/ Math.sin(theta);
					} else if (this.endTypeLT == 2) {
						this.endYBA =
									this.myParent.bY4 - this.partDimB
									/ Math.sin(theta);
					} else if (this.endTypeLT == 3) {
						this.endYBA =
									this.myParent.bY4
									- this.myParent.left.partDimB
									/ Math.tan(theta) - this.partDimB
									/ Math.sin(theta);
					}
					
				}
			} else if (this.myLean4 == 2) {
				final double theta =
							Math.atan(this.myParent.widthPix
										/ this.myParent.dimD1);
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endYBA =
								this.myParent.bY4
								- this.myParent.dimD1
								+ this.myParent.left.partDimB
								/ Math.tan(theta) - this.partDimB
								/ Math.sin(theta);
				} else if (this.endTypeLT == 2) {
					this.endYBA =
								this.myParent.bY4 - this.myParent.dimD1 - this.partDimB
								/ Math.sin(theta);
				} else if (this.endTypeLT == 3) {
					this.endYBA =
								this.myParent.bY4
								- this.myParent.dimD1
								+ this.myParent.left.partDimB
								/ Math.tan(theta) - this.partDimB
								/ Math.sin(theta);
				}
				
			} else if (this.myLean4 == 3) {
				final double theta =
							Math.atan(this.myParent.widthPix
										/ this.myParent.dimD0);
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endYBA =
								this.myParent.bY4
								- this.myParent.dimD0
								+ this.myParent.left.partDimB
								/ Math.tan(theta) - this.partDimB
								/ Math.sin(theta);
				} else if (this.endTypeLT == 2) {
					this.endYBA =
								this.myParent.bY4 - this.myParent.dimD0 - this.partDimB
								/ Math.sin(theta);
				} else if (this.endTypeLT == 3) {
					this.endYBA =
								this.myParent.bY4
								- this.myParent.dimD0
								+ this.myParent.left.partDimB
								/ Math.tan(theta) - this.partDimB
								/ Math.sin(theta);
				}
				
			}
			
			if (this.myLean2 == 0 || this.myLean2 == 2) {
				this.startYBA = this.myParent.bY3 - this.partDimB;
				if (this.myLean4 == 2 || this.myLean4 == 3) {
					double myTheta =
								Math.atan(this.myParent.widthPix
											/ this.myParent.dimD1);
					if (this.myLean4 == 3) {
						myTheta =
									Math.atan(this.myParent.widthPix
												/ this.myParent.dimD0);
					}
					if (this.endTypeRB == 1
								|| this.endTypeRB == 0) { // Mitered
						this.startYBA =
						this.startY
						- this.partDimB
						/ Math.tan(myTheta) - this.myParent.right.partDimB
						/ Math.sin(myTheta);
					} else if (this.endTypeRB == 2) {
						this.startYBA =
									this.startY - this.myParent.right.partDimB
									/ Math.sin(myTheta);
					} else {
						this.startYBA =
									this.startY -
									
									this.myParent.right.partDimB
									/ Math.sin(myTheta);
					}
					
				}
			} else {
				final double myTheta =
							Math.atan(this.myParent.widthPix
										/ this.myParent.dimB2);
				if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
					this.startYBA =
					this.myParent.bY3
					- this.myParent.dimB2
					+ this.partDimB
					/ Math.tan(myTheta) - this.myParent.right.partDimB
					/ Math.sin(myTheta);
				} else if (this.endTypeRB == 2) {
					this.startYBA =
								this.myParent.bY3 - this.myParent.dimB2 - this.myParent.left.partDimB
								/ Math.sin(myTheta);
				} else {
					this.startYBA =
								this.myParent.bY3
								- this.myParent.dimB2
								+ this.partDimB
								/ Math.tan(myTheta) - this.myParent.right.partDimB
								/ Math.sin(myTheta);
				}
				if (this.myParent.rightShape == 0
							&& this.myLean2 == 3) {
					this.startYBA = this.startY;
					final double theta =
								Math.atan(this.myParent.dimB2
											/ this.myParent.widthPix);
					final double hypotenus =
								this.partDimB / Math.sin(theta);
					this.startXBA = this.startX - hypotenus;
				}
				
			}
			
			if (this.myParent.shapeID == 702) {
				this.endYBA = this.endY;
				final double theta =
							Math.atan(this.myParent.dimD0
										/ this.myParent.widthPix);
				final double hypotenus =
							this.partDimB / Math.sin(theta);
				this.endXBA = this.endX + hypotenus;
			}
			if (this.myParent.noSidesLeft == 0
						&& this.myParent.top1.partForm == 2) {
				// this. startXBA =
							// this.myLevelShape.top1.endXBA;
				this.endXBA = this.myParent.top1.startXBA;
			}
			if (this.myParent.noSidesRight == 0
						&& this.myParent.top1.partForm == 2) {
				this.startXBA = this.myParent.top1.endXBA;
				// this. endXBA =
							// this.myLevelShape.top1.startXBA;
			}
			if (this.myParent.top2.posInUse
						&& this.myParent.noSidesRight == 0) {
				this.startXBA = this.myParent.top2.endXBA;
			}
			
		}
		if (this.myParent.shapeID >= 700
					&& this.myParent.shapeID <= 706) {
			if (this.myParent.leftShape == 0 && this.myLean4 == 1) {
				final double myTheta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.widthPix);
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endXBA =
								this.myParent.startingX
								+ this.myParent.top1.partDimB
								/ Math.sin(myTheta) + this.partDimB
								/ Math.tan(myTheta);
					this.endYBA = this.endY - this.partDimB;
				} else if (this.endTypeLT == 2) {
					this.endXBA =
								this.endX + this.partDimB
								/ Math.tan(myTheta);
					this.endYBA = this.endY - this.partDimB;
				} else if (this.endTypeLT == 3) {
					this.endXBA =
								this.endX + this.partDimB
								/ Math.tan(myTheta);
					this.endYBA = this.endY - this.partDimB;
				}
				
			}
			if (this.myParent.leftShape == 0 && this.myLean4 == 2) {
				final double myTheta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.widthPix);
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endXBA =
								this.endX
								+ this.partDimB
								/ Math.sin(myTheta) + this.myParent.top1.partDimB
								/ Math.tan(myTheta);
					this.endYBA =
								this.endY + this.myParent.top1.partDimB;
				} else if (this.endTypeLT == 2) {
					this.endXBA =
								this.endX + this.partDimB
								/ Math.sin(myTheta);
					this.endYBA = this.endY;
					
				} else if (this.endTypeLT == 3) {
					this.endXBA =
								this.endX + this.myParent.top1.partDimB
								/ Math.tan(myTheta);
					this.endYBA =
								this.endY + this.myParent.top1.partDimB;
				}
				
			}
			
			// if (this.myLevelShape.leftShape
						// == 0 && myLean4==3) {
				// double myTheta =
							// Math.atan(this.myLevelShape.hL/this.myLevelShape.wB)
							// ;
				// if (this.endTypeLT==1 ||
							// this.endTypeLT==0){
					// this. endXBA = this.endX +
								// ((this.partDimB)/Math.tan(myTheta))+
								// ((this.myLevelShape.top1.partDimB)/Math.sin(myTheta))
								// ;
					// this.endYBA =
								// this.endY+this.myLevelShape.top1.partDimB;
					// }else if (this.endTypeLT==2){
						// this. endXBA = this.endX +
									// ((this.partDimB)/Math.sin(myTheta)) ;
						// this.endYBA = this.endY;
						//
						// } else if(this.endTypeLT==3){
							// this. endXBA = this.endX +
										// ((this.myLevelShape.top1.partDimB)/Math.tan(myTheta))
										// ;
							// this.endYBA =
										// this.endY+this.myLevelShape.top1.partDimB;
			// }
			//
			// }
			if (this.myParent.rightShape == 0
						&& this.myLean2 == 2) {
				final double myTheta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.widthPix);
				if (this.endTypeRB == 1 || this.endTypeRB == 0) {
					this.startXBA =
								this.startX
								- this.myParent.top1.partDimB
								/ Math.sin(myTheta) - this.partDimB
								/ Math.tan(myTheta);
					this.startYBA = this.startY - this.partDimB;
				} else if (this.endTypeRB == 2) {
					this.startXBA =
								this.startX - this.partDimB
								/ Math.tan(myTheta);
					this.startYBA = this.startY - this.partDimB;
				} else if (this.endTypeRB == 3) {
					this.startXBA =
								this.startX - this.partDimB
								/ Math.tan(myTheta);
					this.startYBA = this.startY - this.partDimB;
				}
			}
			
			if (this.myParent.rightShape == 0
						&& this.myLean2 == 1) {
				final double myTheta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.widthPix);
				if (this.endTypeRB == 1 || this.endTypeRB == 0) {
					this.startXBA =
								this.startX
								- this.myParent.top1.partDimB
								/ Math.tan(myTheta) - this.partDimB
								/ Math.sin(myTheta);
					this.startYBA =
								this.startY + this.myParent.top1.partDimB;
				} else if (this.endTypeRB == 2) {
					this.startXBA =
								this.startX - this.partDimB
								/ Math.sin(myTheta);
					this.startYBA = this.startY;
				} else if (this.endTypeRB == 3) {
					this.startXBA =
								this.startX - this.partDimB
								/ Math.sin(myTheta);
					this.startYBA = this.startY;
				}
			}
			if (this.myParent.rightShape == 0
						&& this.myLean4 == 3) {
				final double myTheta =
							Math.atan(this.myParent.dimD2
										/ this.myParent.widthPix);
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endXBA =
								this.myParent.startingX + this.partDimB
								/ Math.sin(myTheta);
					this.endYBA = this.endY;
				} else if (this.endTypeLT == 2) {
					this.endXBA =
								this.myParent.startingX + this.partDimB
								/ Math.sin(myTheta);
					this.endYBA = this.endY;
				} else if (this.endTypeLT == 3) {
					this.endXBA =
								this.myParent.startingX + this.partDimB
								/ Math.sin(myTheta);
					this.endYBA = this.endY;
				}
				
			}
			if (this.myParent.shapeID == 704) {
				double myTheta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.dimA2);
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endXBA =
								this.myParent.startingX
								+ this.myParent.top1.partDimB
								/ Math.tan(myTheta) + this.partDimB
								/ Math.sin(myTheta);
					this.endYBA =
								this.endY - this.myParent.top1.partDimB;
				} else if (this.endTypeLT == 2) {
					this.endXBA =
								this.endX + this.partDimB
								/ Math.tan(myTheta);
					this.endYBA = this.endY - this.partDimB;
				} else if (this.endTypeLT == 3) {
					this.endXBA =
								this.endX + this.partDimB
								/ Math.tan(myTheta);
					this.endYBA = this.endY - this.partDimB;
				}
				myTheta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.dimA1);
				if (this.endTypeRB == 1 || this.endTypeRB == 0) {
					this.startXBA =
								this.startX
								- this.myParent.top2.partDimB
								/ Math.sin(myTheta) - this.partDimB
								/ Math.tan(myTheta);
					;
					this.startYBA =
								this.startY - this.myParent.top2.partDimB;
				} else if (this.endTypeRB == 2) {
					this.startXBA =
								this.startX - this.partDimB
								/ Math.tan(myTheta);
					this.startYBA = this.startY - this.partDimB;
				} else if (this.endTypeRB == 3) {
					this.startXBA =
								this.startX - this.partDimB
								/ Math.tan(myTheta);
					this.startYBA = this.startY - this.partDimB;
				}
			}
		}
		if (this.myParent.top1.partForm == 2
					&& this.myParent.noSidesLeft == 0) {
			this.myParent.top1.startYBA = this.endYBA;
			this.endXBA = this.myParent.top1.startXBA;
			
		}
		if (this.myParent.top1.partForm == 2
					&& this.myParent.noSidesRight == 0) {
			this.myParent.top1.endYBA = this.startYBA;
			this.startXBA = this.myParent.top1.endXBA;
			
		}
		if (this.myParent.top2.partForm == 2
					&& this.myParent.top1.partForm == 2
					&& this.myParent.noSidesTop == 2
					&& this.myParent.noSidesLeft == 0) {
			this.myParent.top1.startYBA = this.endYBA;
			this.endXBA = this.myParent.top1.startXBA;
			
		}
		if (this.myParent.top2.partForm == 2
					&& this.myParent.top1.partForm == 2
					&& this.myParent.noSidesTop == 2
					&& this.myParent.noSidesRight == 0) {
			this.myParent.top2.endYBA = this.startYBA;
			this.startXBA = this.myParent.top2.endXBA;
			
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
		
		if (this.myLean3 == 2) {// Lean Left
			final double theta =
						Math.atan(this.myParent.heightPix
									/ this.myParent.dimC1);
			final double hypotenus =
						(this.myParent.right.partDimB + this.myParent.right.partDimA) / Math
						.sin(theta);
			if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
				this.startXA =
							this.myParent.startingX
							+ this.myParent.dimC2
							- hypotenus + (this.partDimB + this.partDimA)
							/ Math.tan(theta);
			} else if (this.endTypeRB == 2) {// Straight Cut
				this.startXA =
							this.startX
							- (this.myParent.right.partDimB + this.myParent.right.partDimA)
							/ Math.sin(theta) + (this.partDimB + this.partDimA)
							/ Math.tan(theta);
				this.stopAsX =
							this.startXA - this.partDimA
							/ Math.tan(theta);
			} else if (this.endTypeRB == 3) {
				this.startXA =
							this.startX + (this.myParent.right.partDimB + this.myParent.right.partDimA)
							/ Math.tan(theta);
			}
			
			if (this.myLean == 0 || this.myLean == 1) {
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endXA =
								this.myParent.startingX
								+ this.myParent.left.partDimB
								+ this.myParent.left.partDimA;
				} else if (this.endTypeLT == 2) {
					this.endXA =
								this.myParent.startingX
								+ this.myParent.left.partDimB
								+ this.myParent.left.partDimA;
				} else if (this.endTypeLT == 3) {
					this.endXA =
								this.myParent.startingX
								+ this.myParent.left.partDimB;
				}
			} else {
				double myTheta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.dimA1);
				if (this.myLean == 3) {
					myTheta =
								Math.atan(this.myParent.heightPix
											/ this.myParent.dimA0);
				}
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endXA =
								this.endX
								+ (this.partDimB + this.partDimA)
								/ Math.tan(myTheta) + (this.myParent.right.partDimB + this.myParent.right.partDimA)
								/ Math.sin(myTheta);
				} else if (this.endTypeLT == 2) {
					this.endXA =
								this.endX
								+ (this.partDimB + this.partDimA)
								/ Math.tan(myTheta) + (this.myParent.right.partDimB + this.myParent.right.partDimA)
								/ Math.sin(myTheta);
					this.stopAeX =
								this.endXA - this.partDimA
								/ Math.tan(myTheta);
				} else if (this.endTypeLT == 3) {
					this.endXA =
								this.endX + (this.partDimB + this.partDimA)
								/ Math.tan(myTheta);
				}
			}
			
			this.myParent.dimC0 = 0;
			
		}
		if (this.myLean3 == 1) { // Lean Right
			final double theta =
						Math.atan(this.myParent.heightPix
									/ this.myParent.dimC2);
			final double hypotenus =
						(this.myParent.left.partDimB + this.myParent.left.partDimA) / Math
						.sin(theta);
			if (this.myLean == 0 || this.myLean == 2) {
				if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
					this.startXA =
								this.myParent.bX3
								- (this.myParent.right.partDimB + this.myParent.right.partDimA);
				} else if (this.endTypeRB == 2) {// Straight Cut
					this.startXA =
								this.myParent.bX3
								- (this.myParent.right.partDimB + this.myParent.right.partDimA);
					this.stopAsX = this.startXA;
				} else if (this.endTypeRB == 3) {
					this.startXA =
								this.myParent.bX3
								- this.myParent.right.partDimB;
				}
			} else {
				final double xtheta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.dimA2);
				
				if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
					this.startXA =
								this.startX
								- (this.myParent.right.partDimB + this.myParent.right.partDimA)
								/ Math.sin(theta) - (this.partDimB + this.partDimA)
								/ Math.tan(xtheta);
				} else if (this.endTypeRB == 2) {// Straight Cut
					this.startXA =
								this.startX
								- (this.myParent.right.partDimB + this.myParent.right.partDimA)
								/ Math.sin(theta) - (this.partDimB + this.partDimA)
								/ Math.tan(xtheta);
					this.stopAsX =
								this.startXA + this.partDimA
								/ Math.tan(xtheta);
				} else if (this.endTypeRB == 3) {
					this.startXA =
								this.startX - (this.partDimB + this.partDimA)
								/ Math.tan(xtheta);
				}
			}
			
			if (this.endTypeLT == 1 || this.endTypeLT == 0) {
				this.endXA =
							this.myParent.bX4
							+ this.myParent.dimC2
							+ hypotenus - (this.partDimB + this.partDimA)
							/ Math.tan(theta);
			} else if (this.endTypeLT == 2) {
				this.endXA =
							this.myParent.bX4
							+ this.myParent.dimC2
							- (this.partDimB + this.partDimA)
							/ Math.tan(theta) + (this.myParent.right.partDimB + this.myParent.right.partDimA)
							/ Math.sin(theta);
				
				this.stopAeX =
							this.myParent.bX4
							+ this.myParent.dimC2
							- (this.partDimB + this.partDimA)
							/ Math.tan(theta)
							+ (this.myParent.right.partDimB + this.myParent.right.partDimA)
							/ Math.sin(theta) + this.partDimA
							/ Math.tan(theta);
				
			} else if (this.endTypeLT == 3) {
				this.endXA =
							this.endX - (this.partDimB + this.partDimA)
							/ Math.tan(theta);
			}
			
			this.myParent.dimC0 = 0;
			
		}
		
		if (this.myLean3 == 3) { // Centered
			
			final double theta =
						Math.atan(this.myParent.heightPix
									/ this.myParent.dimC0);
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
							this.startXA - this.partDimA
							/ Math.tan(theta);
			} else if (this.endTypeRB == 3) {
				this.startXA =
							this.startX + (this.myParent.right.partDimB + this.myParent.right.partDimA)
							/ Math.tan(theta);
			}
			
			if (this.endTypeLT == 1 || this.endTypeLT == 0) {
				this.endXA =
							this.endX + hypotenus - (this.partDimB + this.partDimA)
							/ Math.tan(theta);
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
			
			if (this.myLean2 == 2 || this.myLean2 == 3) {
				final double myTheta =
							Math.atan(this.myParent.dimB2
										/ this.myParent.dimC0);
				hypotenus =
							(this.myParent.right.partDimB + this.myParent.right.partDimA) / Math
							.sin(myTheta);
				if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
					
					this.startXA =
					this.myParent.bX3
					- this.myParent.dimC0
					- hypotenus + (this.partDimB + this.partDimA)
					/ Math.tan(myTheta);
				
				} else if (this.endTypeRB == 2) {// Straight Cut
					
					this.startXA =
					this.myParent.bX3 - this.myParent.dimC0 + (this.partDimB + this.partDimA)
					/ Math.tan(myTheta);
				
				} else if (this.endTypeRB == 3) {
					
					this.startXA =
								this.myParent.bX3
								- this.myParent.dimC0
								- hypotenus + (this.partDimB + this.partDimA)
								/ Math.tan(myTheta);
					
				}
			}
			if (this.myLean4 == 1 || this.myLean4 == 3) {
				double myTheta =
							Math.atan(this.myParent.dimD1
										/ this.myParent.dimC2);
				
				if (this.myLean4 == 3) {
					myTheta =
								Math.atan(this.myParent.dimD0
											/ this.myParent.dimC2);
				}
				
				hypotenus =
							(this.myParent.left.partDimB + this.myParent.left.partDimA) / Math
							.sin(myTheta);
				
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endXA =
								this.endX + hypotenus - (this.partDimB + this.partDimA)
								/ Math.tan(myTheta);
				} else if (this.endTypeLT == 2) {
					this.endXA =
								this.endX
								- (this.partDimB + this.partDimA)
								/ Math.tan(theta) + (this.myParent.right.partDimB + this.myParent.right.partDimA)
								/ Math.sin(myTheta);
					
					this.stopAeX =
								this.endXA + this.partDimA
								/ Math.tan(myTheta);
					
				} else if (this.endTypeLT == 3) {
					this.endXA =
								this.endX - (this.partDimB + this.partDimA)
								/ Math.tan(myTheta);
				}
			}
			
		}
		
		if (this.myLean3 == 0) { // Not leaning
			
			if (this.myLean == 0 || this.myLean == 2) {
				if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
					this.startXA =
								this.myParent.bX3
								- (this.myParent.right.partDimB + this.myParent.right.partDimA);
				} else if (this.endTypeRB == 2) {// Straight Cut
					this.startXA =
								this.myParent.bX3
								- (this.myParent.right.partDimB + this.myParent.right.partDimA);
				} else if (this.endTypeRB == 3) {
					this.startXA =
								this.myParent.bX3
								- this.myParent.right.partDimB;
				}
			} else {
				final double myTheta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.dimA2);
				if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
					this.startXA =
								this.myParent.bX3
								- (this.myParent.right.partDimB + this.myParent.right.partDimA)
								/ Math.sin(myTheta) - (this.partDimB + this.partDimA)
								/ Math.tan(myTheta);
				} else if (this.endTypeRB == 2) {// Straight Cut
					this.startXA =
								this.myParent.bX3
								- (this.myParent.right.partDimB + this.myParent.right.partDimA)
								/ Math.sin(myTheta) - (this.partDimB + this.partDimA)
								/ Math.tan(myTheta);
					this.stopAsX =
								(this.startXA + this.partDimA
											/ Math.tan(myTheta));
				} else if (this.endTypeRB == 3) {
					this.startXA =
								(this.startX - (this.partDimB + this.partDimA)
											/ Math.tan(myTheta));
				}
				
			}
			
			if (this.myLean == 0 || this.myLean == 1) {
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endXA =
								this.myParent.startingX
								+ this.myParent.left.partDimB
								+ this.myParent.left.partDimA;
				} else if (this.endTypeLT == 2) {
					this.endXA =
								this.myParent.startingX
								+ this.myParent.left.partDimB
								+ this.myParent.left.partDimA;
					
				} else if (this.endTypeLT == 3) {
					this.endXA =
								this.myParent.startingX
								+ this.myParent.left.partDimB;
				}
			} else {
				double myTheta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.dimA1);
				if (this.myLean == 3) {
					myTheta =
								Math
								.atan(this.myParent.heightPix
											/ this.myParent.dimA0);
				}
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endXA =
								(this.myParent.startingX
											+ (this.myParent.left.partDimB + this.myParent.left.partDimA)
											/ Math.sin(myTheta) + (this.partDimB + this.partDimA)
											/ Math.tan(myTheta));
					
				} else if (this.endTypeLT == 2) {
					this.endXA =
								(this.myParent.startingX
											+ (this.myParent.left.partDimB + this.myParent.left.partDimA)
											/ Math.sin(myTheta) + (this.partDimB + this.partDimA)
											/ Math.tan(myTheta));
					this.stopAeX =
								(this.myParent.startingX
											+ (this.myParent.left.partDimB + this.myParent.left.partDimA)
											/ Math.sin(myTheta) + this.partDimB
											/ Math.tan(myTheta));
				} else if (this.endTypeLT == 3) {
					this.endXA =
								(this.endX + (this.partDimB + this.partDimA)
											/ Math.tan(myTheta));
				}
				
			}
			
			if (this.myLean4 == 1 || this.myLean4 == 0) {
				if (this.myLean2 == 0 || this.myLean2 == 2) {
					if (this.endTypeLT == 1
								|| this.endTypeLT == 0) {
						this.endYA =
									this.myParent.bY4
									- (this.partDimB + this.partDimA);
					} else if (this.endTypeLT == 2) {
						this.endYA =
									this.myParent.bY4
									- (this.partDimB + this.partDimA);
						this.stopAeY = this.endYA + this.partDimA;
					} else if (this.endTypeLT == 3) {
						this.endYA =
									this.myParent.bY4
									- (this.partDimB + this.partDimA);
					}
				} else if (this.myLean2 == 1 || this.myLean2 == 3) {
					
					final double theta =
								Math.atan(this.myParent.widthPix
											/ this.myParent.dimB2);
					if (this.endTypeLT == 1
								|| this.endTypeLT == 0) {
						this.endYA =
									(this.endY
												- (this.myParent.left.partDimB + this.myParent.left.partDimA)
												/ Math.tan(theta) - (this.partDimB + this.partDimA)
												/ Math.sin(theta));
					} else if (this.endTypeLT == 2) {
						this.endYA =
									(this.endY
												- (this.myParent.left.partDimB + this.myParent.left.partDimA)
												/ Math.tan(theta) - (this.partDimB + this.partDimA)
												/ Math.sin(theta));
						this.stopAeY =
									(this.endYA + this.partDimA
												/ Math.sin(theta));
					} else if (this.endTypeLT == 3) {
						this.endYA =
									(this.endYBA - this.myParent.left.partDimA
												/ Math.sin(theta));
					}
					
				}
			}
			
			if (this.myLean4 == 2) {
				double theta =
							Math.atan(this.myParent.widthPix
										/ this.myParent.dimD1);
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endYA =
								(this.myParent.startingY
											+ this.myParent.dimD2
											+ (this.myParent.left.partDimB + this.myParent.left.partDimA)
											/ Math.tan(theta) - (this.partDimB + this.partDimA)
											/ Math.sin(theta));
				} else if (this.endTypeLT == 2) {
					this.endYA =
								(this.myParent.startingY
											+ this.myParent.dimD2
											+ (this.myParent.left.partDimB + this.myParent.left.partDimA)
											/ Math.tan(theta) - (this.partDimB + this.partDimA)
											/ Math.sin(theta));
					this.stopAeY =
								(this.endYA + this.partDimA
											/ Math.sin(theta));
				} else if (this.endTypeLT == 3) {
					
					this.endYA =
								(this.endY - (this.partDimB + this.partDimA)
											/ Math.sin(theta));
				}
				if (this.myParent.leftShape == 0) {
					this.endYA =
								this.endY
								+ this.myParent.top1.partDimB
								+ this.myParent.top1.partDimA;
					theta =
								Math
								.atan(this.myParent.heightPix
											/ this.myParent.widthPix);
					final double hypotenus =
								(this.partDimB / Math.sin(theta));
					this.endXA = this.endX + hypotenus;
				}
			} else if (this.myLean4 == 3) {
				double theta =
							Math.atan(this.myParent.widthPix
										/ this.myParent.dimD0);
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endYA =
								(this.myParent.startingY
											+ this.myParent.dimD2
											+ this.myParent.dimD1
											+ (this.myParent.left.partDimB + this.myParent.left.partDimA)
											/ Math.tan(theta) - (this.partDimB + this.partDimA)
											/ Math.sin(theta));
				} else if (this.endTypeLT == 2) {
					this.endYA =
								(this.myParent.startingY
											+ this.myParent.dimD2
											+ this.myParent.dimD1
											+ (this.myParent.left.partDimB + this.myParent.left.partDimA)
											/ Math.tan(theta) - (this.partDimB + this.partDimA)
											/ Math.sin(theta));
					this.stopAeY =
								(this.endYA + this.partDimA
											/ Math.sin(theta));
				} else if (this.endTypeLT == 3) {
					this.endYA =
								(this.endY - (this.partDimB + this.partDimA)
											/ Math.sin(theta));
				}
				if (this.myParent.leftShape == 0) {
					this.endYA = this.endY;
					
					theta =
								Math.atan(this.myParent.dimD0
											/ this.myParent.widthPix);
					final double hypotenus =
								((this.partDimB + this.partDimA) / Math
											.sin(theta));
					this.endXA = this.endX + hypotenus;
				}
			}
			
			if (this.myLean2 == 0 || this.myLean2 == 2) {
				this.startYA =
							this.myParent.bY3
							- (this.partDimB + this.partDimA);
				if (this.myLean4 == 2 || this.myLean4 == 3) {
					double myTheta =
								Math.atan(this.myParent.widthPix
											/ this.myParent.dimD1);
					if (this.myLean4 == 3) {
						myTheta =
									Math
									.atan(this.myParent.widthPix
												/ this.myParent.dimD0);
					}
					if (this.endTypeRB == 1
								|| this.endTypeRB == 0) { // Mitered
						this.startYA =
						(this.startY
									- (this.myParent.right.partDimB + this.myParent.right.partDimA)
									/ Math.tan(myTheta) - (this.partDimB + this.partDimA)
									/ Math.sin(myTheta));
					} else if (this.endTypeRB == 2) {
						this.startYA =
									(this.startY
												- (this.myParent.right.partDimB + this.myParent.right.partDimA)
												/ Math.tan(myTheta) - (this.partDimB + this.partDimA)
												/ Math.sin(myTheta));
						this.stopAsY =
									(this.startYA + this.partDimA
												/ Math.sin(myTheta));
					} else {
						this.startYA =
									(this.startY - (this.partDimB + this.partDimA)
												/ Math.sin(myTheta));
					}
					
				}
				
			} else {
				final double myTheta =
							Math.atan(this.myParent.widthPix
										/ this.myParent.dimB2);
				if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
					this.startYA =
					(this.myParent.bY3
								- this.myParent.dimB2
								+ (this.partDimB + this.partDimA)
								/ Math.tan(myTheta) - (this.myParent.right.partDimB + this.myParent.right.partDimA)
								/ Math.sin(myTheta));
				} else if (this.endTypeRB == 2) {
					this.startYA =
								(this.startY
											+ (this.myParent.left.partDimB + this.myParent.left.partDimA)
											/ Math.tan(myTheta) - (this.partDimB + this.partDimA)
											/ Math.sin(myTheta));
					this.stopAsY =
								(this.startYA + this.partDimA
											/ Math.sin(myTheta));
				} else {
					this.startYA =
								(this.startYBA - this.partDimA
											/ Math.sin(myTheta));
				}
				if (this.myParent.rightShape == 0
							&& this.myParent.shapeID != 706
							&& this.myParent.shapeID != 705) {
					this.startYA = this.startY;
					final double theta =
								Math.atan(this.myParent.dimB2
											/ this.myParent.widthPix);
					final double hypotenus =
								((this.partDimB + this.partDimA) / Math
											.sin(theta));
					this.startXA = this.startX - hypotenus;
				}
				
			}
			if (this.myParent.rightShape == 0
						&& this.myParent.shapeID == 706) {
				this.startYA =
							this.startY
							+ this.myParent.top1.partDimB
							+ this.myParent.top1.partDimA;
				
				final double theta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.widthPix);
				final double hypotenus =
							((this.partDimB + this.partDimA) / Math
										.sin(theta));
				final double base =
							((this.myParent.top1.partDimB + this.myParent.top1.partDimA) * Math
										.tan(theta));
				this.startXA = this.startX - hypotenus - base;
				if (this.endTypeRB == 3) {
					this.startYA = this.startY;
					this.startXA = this.startX - hypotenus;// -
					// base;
				}
				this.stopAsX =
							(this.startXA + this.partDimA
										/ Math.sin(theta));
				this.stopAsY = this.startYA;
			} else if (this.myParent.leftShape == 0
						&& this.myParent.shapeID == 705) {
				this.endYA =
							this.endY
							+ this.myParent.top1.partDimB
							+ this.myParent.top1.partDimA;
				final double theta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.widthPix);
				final double hypotenus =
							((this.partDimB + this.partDimA) / Math
										.sin(theta));
				final double base =
							((this.myParent.top1.partDimB + this.myParent.top1.partDimA) * Math
										.tan(theta));
				this.endXA = this.endX + hypotenus + base;
				this.stopAeX =
							(this.endXA - this.partDimA
										/ Math.sin(theta));
				this.stopAeY = this.endYA;
			}
			if (this.myParent.noSidesLeft == 0
						&& this.myParent.top1.partForm == 2) {
				// this. startXBA =
							// this.myLevelShape.top1.endXBA;
				this.endXA = this.myParent.top1.startXA;
			}
			if (this.myParent.noSidesRight == 0
						&& this.myParent.top1.partForm == 2) {
				this.startXA = this.myParent.top1.endXA;
				// this. endXBA =
							// this.myLevelShape.top1.startXBA;
			}
			if (this.myParent.top2.posInUse
						&& this.myParent.noSidesRight == 0) {
				this.startXA = this.myParent.top2.endXA;
			}
			
		}
		if (this.myParent.shapeID >= 700
					&& this.myParent.shapeID <= 706) {
			if (this.myParent.leftShape == 0 && this.myLean4 == 2) {
				final double myTheta =
							Math.atan(this.myParent.dimD1
										/ this.myParent.widthPix);
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endXA =
								(this.endX
											+ (this.myParent.top1.partDimB + this.myParent.top1.partDimA)
											/ Math.tan(myTheta) + (this.partDimB + this.partDimA)
											/ Math.sin(myTheta));
					this.endYA =
								this.endY
								+ this.myParent.top1.partDimB
								+ this.myParent.top1.partDimA;
				} else if (this.endTypeLT == 2) {
					this.endXA =
								(this.endX
											+ (this.myParent.top1.partDimB + this.myParent.top1.partDimA)
											/ Math.tan(myTheta) + (this.partDimB + this.partDimA)
											/ Math.sin(myTheta));
					this.endYA =
								this.endY
								+ this.myParent.top1.partDimB
								+ this.myParent.top1.partDimA;
					this.stopAeX =
								(this.endXA - this.partDimA
											/ Math.sin(myTheta));
					this.stopAeY = this.endYA;
				} else if (this.endTypeLT == 3) {
					this.endXA =
								(this.endX + (this.partDimB + this.partDimA)
											/ Math.sin(myTheta));
					this.endYA = this.endY;
				}
				
			}
			if (this.myParent.leftShape == 0 && this.myLean4 == 1) {
				final double myTheta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.widthPix);
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endXA =
								(this.endX
											+ (this.myParent.top1.partDimB + this.myParent.top1.partDimA)
											/ Math.sin(myTheta) + (this.partDimB + this.partDimA)
											/ Math.tan(myTheta));
					this.endYA =
								this.endY - this.partDimB - this.partDimA;
				} else if (this.endTypeLT == 2) {
					this.endXA =
								(this.endX
											+ (this.myParent.top1.partDimB + this.myParent.top1.partDimA)
											/ Math.sin(myTheta) + (this.partDimB + this.partDimA)
											/ Math.tan(myTheta));
					this.endYA =
								this.endY - this.partDimB - this.partDimA;
					this.stopAeX =
								(this.endXA - this.partDimA
											/ Math.sin(myTheta));
					this.stopAeY = this.endYA;
				} else if (this.endTypeLT == 3) {
					this.endXA =
								(this.endX + (this.partDimB + this.partDimA)
											/ Math.tan(myTheta));
					this.endYA =
								this.endY - this.partDimB - this.partDimA;
				}
				
			}
			if (this.myParent.rightShape == 0
						&& this.myLean2 == 1) {
				final double myTheta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.widthPix);
				if (this.endTypeRB == 1 || this.endTypeRB == 0) {
					this.startXA =
								(this.startX
											- (this.myParent.top1.partDimB + this.myParent.top1.partDimA)
											/ Math.tan(myTheta) - (this.partDimB + this.partDimA)
											/ Math.sin(myTheta));
					this.startYA =
								this.startY
								+ this.myParent.top1.partDimB
								+ this.myParent.top1.partDimA;
				} else if (this.endTypeRB == 2) {
					this.startXA =
								(this.startX
											- (this.myParent.top1.partDimB + this.myParent.top1.partDimA)
											/ Math.tan(myTheta) - (this.partDimB + this.partDimA)
											/ Math.sin(myTheta));
					this.startYA =
								this.startY
								+ this.myParent.top1.partDimB
								+ this.myParent.top1.partDimA;
					this.stopAsX =
								(this.endXA + this.partDimA
											/ Math.sin(myTheta));
					this.stopAsY = this.endYA;
				} else if (this.endTypeRB == 3) {
					this.startXA =
								(this.startX - (this.partDimB + this.partDimA)
											/ Math.sin(myTheta));
					this.startYA = this.startY;
				}
			}
			if (this.myParent.rightShape == 0
						&& this.myLean2 == 2) {
				final double myTheta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.widthPix);
				if (this.endTypeRB == 1 || this.endTypeRB == 0) {
					this.startXA =
								(this.startX
											- (this.myParent.top1.partDimB + this.myParent.top1.partDimA)
											/ Math.tan(myTheta) - (this.partDimB + this.partDimA)
											/ Math.sin(myTheta));
					this.startYA =
								this.startY
								- this.myParent.top1.partDimB
								- this.myParent.top1.partDimA;
				} else if (this.endTypeRB == 2) {
					this.startXA =
								(this.startX
											- (this.myParent.top1.partDimB + this.myParent.top1.partDimA)
											/ Math.tan(myTheta) - (this.partDimB + this.partDimA)
											/ Math.sin(myTheta));
					this.startYA =
								this.startY
								- this.myParent.top1.partDimB
								- this.myParent.top1.partDimA;
					this.stopAsX =
								(this.endXA + this.partDimA
											/ Math.sin(myTheta));
					this.stopAsY = this.endYA;
				} else if (this.endTypeRB == 3) {
					this.startXA =
								(this.startX - this.partDimB
											/ Math.sin(myTheta));
					this.startYA =
								this.startY
								- this.myParent.top1.partDimB
								- this.myParent.top1.partDimA;
				}
			}
			if (this.myParent.shapeID == 704) {
				double myTheta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.dimA2);
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endXA =
								(this.myParent.startingX
											+ (this.myParent.top1.partDimB + this.myParent.top1.partDimA)
											/ Math.tan(myTheta) + (this.partDimB + this.partDimA)
											/ Math.sin(myTheta));
					this.endYA =
								this.endY
								- (this.myParent.top1.partDimB + this.myParent.top1.partDimA);
				} else if (this.endTypeLT == 2) {
					this.endXA =
								(this.endX
											+ (this.partDimB + this.partDimA)
											/ Math.sin(myTheta) + (this.myParent.top1.partDimB + this.myParent.top1.partDimA)
											/ Math.tan(myTheta));
					this.endYA =
								this.endY
								- (this.partDimB + this.partDimA);
					this.stopAeX =
								(this.endXA - this.partDimA
											/ Math.tan(myTheta));
					this.stopAeY = this.endYA + this.partDimA;
				} else if (this.endTypeLT == 3) {
					this.endXA =
								(this.endX + (this.partDimB + this.partDimA)
											/ Math.tan(myTheta));
					this.endYA =
								this.endY
								- (this.partDimB + this.partDimA);
				}
				myTheta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.dimA1);
				if (this.endTypeRB == 1 || this.endTypeRB == 0) {
					this.startXA =
								(this.startX
											- (this.myParent.top2.partDimB + this.myParent.top2.partDimA)
											/ Math.sin(myTheta) - (this.partDimB + this.partDimA)
											/ Math.tan(myTheta));
					;
					this.startYA =
								this.startY
								- this.myParent.top2.partDimB
								- this.myParent.top2.partDimA;
				} else if (this.endTypeRB == 2) {
					this.startXA =
								(this.startX - ((this.partDimB + this.partDimA)
											/ Math.sin(myTheta) + (this.myParent.top1.partDimB + this.myParent.top1.partDimA)
											/ Math.tan(myTheta)));
					this.startYA =
								this.startY
								- (this.partDimB + this.partDimA);
					this.stopAsX =
								(this.startXA + this.partDimA
											/ Math.tan(myTheta));
					this.stopAsY = this.startYA + this.partDimA;
				} else if (this.endTypeRB == 3) {
					this.startXA =
								(this.startX - (this.partDimB + this.partDimA)
											/ Math.tan(myTheta));
					this.startYA =
								this.startY
								- (this.partDimB + this.partDimA);
				}
			}
		}
		
		// if (this.myLevelShape.top1.partForm == 2
		// && this.myLevelShape.noSidesLeft == 0) {
		//
		// this.endXA =
		// this.myLevelShape.top1.startXA;
		// this.endYA =
		// this.myLevelShape.top1.startYA;
		// }
		// if (this.myLevelShape.top1.partForm == 2
		// && this.myLevelShape.noSidesRight == 0) {
		// this.startXA =
		// this.myLevelShape.top1.endXA;
		// this.startYA =
		// this.myLevelShape.top1.endYA;
		//
		// }
		// if (this.myLevelShape.top2.partForm == 2
		// && this.myLevelShape.top1.partForm == 2
		// && this.myLevelShape.noSidesTop == 2
		// && this.myLevelShape.noSidesLeft == 0) {
		// this.endXA =
		// this.myLevelShape.top1.startXA;
		// this.endYA =
		// this.myLevelShape.top1.startYA;
		// }
		// if (this.myLevelShape.top2.partForm == 2
		// && this.myLevelShape.top1.partForm == 2
		// && this.myLevelShape.noSidesTop == 2
		// && this.myLevelShape.noSidesRight == 0) {
		// this.startXA =
		// this.myLevelShape.top2.endXA;
		// this.startYA =
		// this.myLevelShape.top2.endYA;
		// }
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
	
	public void lineStraight1B_2() {
		
		this.partForm = 1;
		
		if (this.myParent.a_levelID == 3) {
			// System.out.print("hello");
		}
		this.startY = this.myParent.bY3 - this.myParent.dimB2;
		this.endY = this.myParent.bY3;
		this.startX = this.myParent.bX3;
		if (this.myLean3 == 3) {
			this.endX = this.myParent.bX3 - this.myParent.dimC0;
		}
		if (this.myLean3 == 2) {
			this.endX = this.myParent.bX3 - this.myParent.dimC1;
		}
		if (this.myLean3 == 1 || this.myLean3 == 0) {
			this.endX = this.myParent.bX3;
		}
		
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
		this.bkgrdWidth =
					this.myParent.widthPix - this.myParent.dimA2;
		this.bkgrdHeight = this.myParent.heightPix;
		
	}
	
	public void lineStraight2BA_2() {
		
		this.partForm = 1;
		if (this.myLean3 == 3
					|| this.myLean3 == 2 && this.myLean3 != 3) {
			
			double theta1 =
						Math.atan(this.myParent.dimC1
									/ this.myParent.dimB2);
			if (this.myLean3 == 3) {
				theta1 =
							Math.atan(this.myParent.dimC0
										/ this.myParent.dimB2);
			}
			final double theta2 =
						Math.atan(this.myParent.dimA2
									/ this.myParent.dimB1);
			final double myTheta =
						(Math.toRadians(180) - theta1 - theta2);
			final double hypotenus =
						(this.partDimB / Math.sin(myTheta / 2));
			final double baseY =
						(hypotenus * Math.cos(myTheta
									/ 2
									+ theta1));
			final double baseX =
						(hypotenus * Math.sin(myTheta
									/ 2
									+ theta1));
			this.startXBA = this.startX - baseX;// base;
			
			this.startYBA = this.startY + baseY;
			
			theta1 =
						Math.atan(this.myParent.dimB2
									/ this.myParent.dimC0);
			if (this.myLean3 == 2) {
				theta1 =
							Math.atan(this.myParent.dimB2
										/ this.myParent.dimC1);
			}
			
			if (this.endTypeLT == 1 || this.endTypeLT == 0) { // Mitered
				this.endXBA =
							(this.endX
										- this.partDimB
										/ Math.sin(theta1) + this.partDimB
										/ Math.tan(theta1));
			} else if (this.endTypeLT == 2) {// Straight Cut
				this.endXBA =
							(this.endX - this.partDimB
										/ Math.sin(theta1));
			} else if (this.endTypeLT == 3) {
				this.endXBA =
							(this.endX - this.partDimB
										/ Math.sin(theta1));
			}
			this.endYBA = this.endY - this.myParent.bot1.partDimB;
		}
		if (this.myParent.bot3.posInUse
					&& this.myParent.noSidesLeft == 1) {
			if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
				this.startXBA =
							this.startX - this.myParent.left.partDimB;
			} else {// Straight Cut
				this.startXBA = this.startX;
			}
			final double theta =
						Math.atan(this.myParent.dimC0
									/ this.myParent.dimB2);
			final double hypotenus =
						(this.partDimB / Math.sin(theta));
			final double yExtensionLeft =
						(this.myParent.left.partDimB / Math
									.tan(theta));
			
			if (this.endTypeRB == 1
						|| this.endTypeRB == 0
						|| this.endTypeRB == 3) {
				this.startYBA =
							this.myParent.bY3
							- this.myParent.dimB2
							- hypotenus
							+ yExtensionLeft;
			} else {
				this.startYBA =
							this.myParent.bY3
							- this.myParent.dimB2
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
		
		if (this.myLean3 == 3
					|| this.myLean3 == 2 && this.myLean4 != 3) {
			
			double theta1 =
						Math.atan(this.myParent.dimC1
									/ this.myParent.dimB2);
			if (this.myLean3 == 3) {
				theta1 =
							Math.atan(this.myParent.dimC0
										/ this.myParent.dimB2);
			}
			final double theta2 =
						Math.atan(this.myParent.dimA2
									/ this.myParent.dimB1);
			final double myTheta =
						(Math.toRadians(180) - theta1 - theta2);
			final double hypotenus =
						((this.partDimB + this.partDimA) / Math
									.sin(myTheta / 2));
			final double baseY =
						(hypotenus * Math.cos(myTheta
									/ 2
									+ theta1));
			final double baseX =
						(hypotenus * Math.sin(myTheta
									/ 2
									+ theta1));
			this.startXA = this.startX - baseX;// base;
			
			this.startYA = this.startY + baseY;
			
			theta1 =
						Math.atan(this.myParent.dimB2
									/ this.myParent.dimC0);
			if (this.myLean3 == 2) {
				theta1 =
							Math.atan(this.myParent.dimB2
										/ this.myParent.dimC1);
			}
			
			if (this.endTypeLT == 1 || this.endTypeLT == 0) { // Mitered
				this.endXA =
							(this.endX
										- (this.partDimB + this.partDimA)
										/ Math.sin(theta1) + (this.partDimB + this.partDimA)
										/ Math.tan(theta1));
			} else if (this.endTypeLT == 2) {// Straight Cut
				this.endXA =
							(this.endX - (this.partDimB + this.partDimA)
										/ Math.sin(theta1));
			} else if (this.endTypeLT == 3) {
				this.endXA =
							(this.endX - (this.partDimB + this.partDimA)
										/ Math.sin(theta1));
			}
			this.endYA =
						this.endY
						- this.myParent.bot1.partDimB
						- this.myParent.top1.partDimA;
		}
		if (this.myParent.bot3.posInUse
					&& this.myParent.noSidesLeft == 1) {
			if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
				this.startXA =
							this.startX
							- this.myParent.left.partDimB
							- this.myParent.left.partDimA;
			} else {// Straight Cut
				this.startXA = this.startX;
			}
			final double theta =
						Math.atan(this.myParent.dimC0
									/ this.myParent.dimB2);
			final double hypotenus =
						((this.partDimB + this.partDimA) / Math
									.sin(theta));
			final double yExtensionLeft =
						((this.myParent.left.partDimB + this.myParent.left.partDimA) / Math
									.tan(theta));
			
			if (this.endTypeRB == 1
						|| this.endTypeRB == 0
						|| this.endTypeRB == 3) {
				this.startYA =
							this.myParent.bY3
							- this.myParent.dimB2
							- hypotenus
							+ yExtensionLeft;
			} else {
				this.startYA =
							this.myParent.bY3
							- this.myParent.dimB2
							- hypotenus;
			}
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
											+ Math.pow((Math
														.max(this.endYA, this.startYA) - Math
														.min(this.endYA, this.startYA)), 2));
		this.radius1A = 0;
		this.radius2A = 0;
		this.bkgrdWidthA =
					this.myParent.widthPix - this.myParent.dimA2;
		this.bkgrdHeightA = this.myParent.heightPix;
		this.ltAngle =
					Math.atan((this.endX - this.endXA)
								/ (this.endY - this.endYA));
		this.rbAngle =
					Math.atan((this.startX - this.startXA)
								/ (this.startY - this.startYA));
	}
	
	public void arcCircle1B() { // int =1 Arc normal, 2 start at 90, 3 end at
		// 90
		
		this.partForm = 2;
		this.endX = this.startingX;
		this.endY = this.startingY + this.myParent.dimD2;//
		this.startX = this.startingX + this.myParent.widthPix;
		this.startY = this.startingY + this.myParent.dimB1;
		this.radius1 = this.myParent.widthPix / 2;
		this.rrAngle = Math.toRadians(90);
		this.rlAngle = Math.toRadians(90);
		this.startAngle = 180;
		this.endAngle = 180;
		this.bkgrdWidth = 2 * this.radius1;
		this.bkgrdHeight = 2 * this.radius1;
		
		this.bkgrdStartX = this.startingX;
		this.bkgrdStartY = this.startingY;
		
		this.length =
					(2 * Math.PI * Math.pow(this.radius1, 2) / 2);
		// 2PIr*CentralAngle/360
		
		this.radius2 = 0;
		
	}
	
	public void archB() { // int =1 Arc normal, 2 start at 90, 3 end at
		// 90
		
		this.partForm = 2;
		this.endX = this.startingX;
		this.endY = this.startingY + this.myParent.dimD2;//
		this.startX = this.startingX + this.myParent.widthPix;
		this.startY = this.startingY + this.myParent.dimB1;
		this.radius1 =
					this.myParent.dimB1
					/ 2
					+ Math
					.pow(this.myParent.widthPix, 2)
					/ (8 * this.myParent.dimB1); //
					this.rrAngle = Math.toRadians(90);
					this.rlAngle = Math.toRadians(90);
					this.startAngle = 180;
					this.endAngle = 180;
					this.bkgrdWidth = 2 * this.radius1;
					this.bkgrdHeight = 2 * this.radius1;
					
					this.bkgrdStartX = this.startingX;
					this.bkgrdStartY = this.startingY;
					
					this.length =
								(2 * Math.PI * Math.pow(this.radius1, 2) / 2);
					// 2PIr*CentralAngle/360
					
	}
	
	public void arcCircle2BA() { // int =1 Arc normal, 2 start at 90, 3 end at
		
		// ninety
		this.partForm = 2;
		this.endXBA = this.endX + this.partDimB;
		this.endYBA = this.endY;//
		this.startXBA = this.startX - this.partDimB;
		this.startYBA = this.startY;
		this.radius1BA = this.radius1 - this.partDimB;
		this.rrAngleBA = Math.toRadians(90);
		this.rlAngleBA = Math.toRadians(90);
		this.startAngleBA = 180;
		this.endAngleBA = 180;
		this.bkgrdWidthBA = 2 * this.radius1BA;
		this.bkgrdHeightBA = 2 * this.radius1BA;
		
		this.bkgrdStartXBA = this.startingX + this.partDimB;
		this.bkgrdStartYBA = this.startingY + this.partDimB;
		
		this.lengthBA =
					(2 * Math.PI * Math.pow(this.radius1BA, 2) / 2);
		// 2PIr*CentralAngle/360
		
		this.radius2BA = 0;
	}
	
	public void arcCircle3A() { // int =1 Arc normal, 2 start at 90, 3 end at
		
		// ninety
		
		this.partForm = 2;
		this.endXA = this.endX + this.partDimB + this.partDimA;
		this.endYA = this.endY;//
		this.startXA = this.startX - this.partDimB - this.partDimA;
		this.startYA = this.startY;
		this.radius1A = this.radius1BA - this.partDimA;
		this.rrAngleA = Math.toRadians(90);
		this.rlAngleA = Math.toRadians(90);
		this.startAngleA = 180;
		this.endAngleA = 180;
		this.bkgrdWidthA = 2 * this.radius1A;
		this.bkgrdHeightA = 2 * this.radius1A;
		
		this.bkgrdStartXA =
					this.startingX + this.partDimB + this.partDimA;
		this.bkgrdStartYA =
					this.startingY + this.partDimB + this.partDimA;
		
		this.lengthA =
					(2 * Math.PI * Math.pow(this.radius1A, 2) / 2);
		// 2PIr*CentralAngle/360
		
		this.radius2A = 0;
	}
	
	public void ellipse1B() {
		
		this.partForm = 3;
		this.endX = this.startingX;
		this.endY = this.startingY + this.myParent.dimD2;//
		this.startX = this.startingX + this.myParent.widthPix;
		this.startY = this.startingY + this.myParent.dimB1;
		
		if (this.myParent.widthPix / 2 > this.myParent.dimB1) {
			
			this.radius1 = this.myParent.dimB1;
			
			this.focal1X =
						(this.startX + this.myParent.widthPix / 2 - Math
									.sqrt(Math.pow(
												this.myParent.widthPix / 2,
												2)
												- Math
												.pow(
															this.myParent.dimB1,
															2)));
			this.focal1Y = this.startY;
			this.focal2X =
						(this.focal1X + 2 * Math.sqrt(Math.pow(
									this.myParent.widthPix / 2,
									2)
									- Math.pow(this.myParent.dimB1, 2)));
			this.focal2Y = this.startY;
			this.bkgrdStartX = this.startingX;
			this.bkgrdStartY = this.startingY;// this.focal1Y
			// - this.radius1;
			this.radius2 =
						(this.myParent.widthPix / 2 - Math
									.sqrt(Math.pow(
												this.myParent.widthPix / 2,
												2)
												- Math
												.pow(
															this.myParent.dimB1,
															2)));
			final double sinCentralAngle =
						this.myParent.dimB1 / this.radius1; // opposite/Hypotenus
			this.centralAngle =
						(Math.asin(sinCentralAngle) * 2);
			this.startAngle = 180;
			this.endAngle = 180;
			this.bkgrdWidth = this.myParent.widthPix;
			this.bkgrdHeight = this.myParent.heightPix;
			final double a = this.myParent.widthPix / 2;
			final double b = this.myParent.dimB1;
			this.length = // Math.PI* (3a + 3b -
						(Math.PI * (3 * a + 3 * b - Math
									.sqrt((a + 3 * b) * (b + 3 * a))));
			
		} else if (this.myParent.dimB1 > this.myParent.widthPix / 2) {
			this.radius1 = this.myParent.widthPix / 2; //
			
			this.focal1X = this.startX + this.myParent.widthPix / 2;
			this.focal1Y =
						(this.startY - Math
									.sqrt(Math.pow(this.myParent.dimB1, 2)
												- Math
												.pow(
															this.myParent.widthPix / 2,
															2)));
			this.focal2X = this.focal1X;
			this.focal2Y =
						(this.startY + Math
									.sqrt(Math.pow(this.myParent.dimB1, 2)
												- Math
												.pow(
															this.myParent.widthPix / 2,
															2)));
			this.bkgrdStartX = this.startingX;
			this.bkgrdStartY = this.startingY;
			final double sinCentralAngle =
						this.myParent.dimB1 / this.radius1; // opposite/Hypotenus
			this.centralAngle =
						(Math.asin(sinCentralAngle) * 2);
			this.startAngle = 180;
			this.endAngle = 180;
			this.bkgrdWidth = this.myParent.widthPix;
			this.bkgrdHeight = 2 * this.myParent.dimB1;
			this.radius2 =
						(this.myParent.dimB1 - Math.sqrt(Math
									.pow(this.myParent.widthPix / 2, 2)
									- Math.pow(this.myParent.dimB1, 2)));
			
			// length=PI*(a+b)*(1+1/4h+1/64h^2+1/256h3+25/16384h^4)
			
			final double h1 =
						(Math
									.pow(
												(this.myParent.dimB1 - this.myParent.widthPix / 2),
												2) / Math
												.pow(
															(this.myParent.dimB1 + this.myParent.widthPix / 2),
															2));
			final double factorial =
						(1 + 0.25 * h1 + 1 / 64 * (Math.pow(
									h1,
									2)
									+ 1
									/ 256
									* Math.pow(h1, 3) + 25 / 16384 * Math
									.pow(h1, 4)));
			this.length =
						(Math.PI
									* (this.myParent.widthPix / 2 + this.myParent.dimB1) * factorial);
		}
		
		this.x1 = this.myParent.widthPix / 2;
		this.y1 = this.startY;
		//
	}
	
	public void ellipse2BA() {
		
		this.partForm = 3;
		this.myWidthBA =
					this.myParent.widthPix
					- (this.myParent.left.partDimB + this.myParent.right.partDimB);
		this.endXBA = this.endX + this.partDimB;
		this.endYBA = this.endY;//
		this.startXBA = this.startX - this.partDimB;
		this.startYBA = this.startY;
		
		final double h1 =
					(Math.pow(
								(this.myParent.dimB1 - this.myWidthBA / 2),
								2) / Math.pow(
											(this.dimB1B + this.myWidthBA / 2),
											2));
		final double factorial =
					(1 + 0.25 * h1 + 1 / 64 * (Math.pow(h1, 2)
								+ 1
								/ 256
								* Math.pow(h1, 3) + 25 / 16384 * Math.pow(
											h1,
											4)));
		this.lengthBA =
					(Math.PI
								* (this.myWidthBA / 2 + this.dimB1B) * factorial);
	}
	
	public void ellipse3A() {
		
		this.endXA = this.endX + this.partDimB + this.partDimA;
		this.endYA = this.endY;//
		this.startXA = this.startX - this.partDimB - this.partDimA;
		this.startYA = this.startY;
		
		final double h1 =
					(Math.pow(
								(this.myParent.dimB1 - this.myWidthA / 2),
								2) / Math.pow(
											(this.dimB1A + this.myWidthA / 2),
											2));
		final double factorial =
					(1 + 0.25 * h1 + 1 / 64 * (Math.pow(h1, 2)
								+ 1
								/ 256
								* Math.pow(h1, 3) + 25 / 16384 * Math.pow(
											h1,
											4)));
		this.lengthA =
					(Math.PI * (this.myWidthA / 2 + this.dimB1A) * factorial);
	}

    public Bot1Object clone() {
        try {

            Bot1Object newObject = (Bot1Object)super.clone();

            return newObject;

        } catch (CloneNotSupportedException e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }

	
	
}

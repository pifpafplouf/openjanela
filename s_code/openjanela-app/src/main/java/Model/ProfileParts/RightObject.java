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


public class RightObject extends ProfileParts implements Cloneable {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(RightObject.class);
	
	/**
	 * Create RightObject
	 */
	public RightObject() {
		position = 4;
	}
	
	/**
	 * Create RightObject for ProfileParts
	 *
	 * @param levelShape, ShapeObject
	 * @param newPart,    boolean
	 */
	public RightObject(ShapeObject levelShape, boolean newPart) {
		
		//Call former constructor
		this();
		
		this.myParent = levelShape;
		this.startingX = this.myParent.startingX;
		this.startingY = this.myParent.startingY;
		this.bkgrdStartX = this.myParent.startingX;
		this.bkgrdStartY = this.myParent.startingY;
		if (newPart) {
			this.setRightObjectInitData();
		} else {
			this.partID = this.myParent.right.partID;
			this.partDimB = this.myParent.right.partDimB;
			this.partDimA = this.myParent.right.partDimA;
			this.partDimC = this.myParent.right.partDimC;
			this.partDimM = this.myParent.right.partDimM;
			this.endTypeLT = this.myParent.right.endTypeLT;
			this.endTypeRB = this.myParent.right.endTypeRB;
			
		}
		this.setLeanTo();
		this.myTopWidth = this.myParent.widthPix;
		
		if (this.myParent.shapeID == 1
					|| this.myParent.shapeID <= 115
					|| this.myParent.shapeID >= 200 && this.myParent.shapeID <= 699) {
			this.myTopWidth = this.myParent.widthPix;
		} else if (this.myParent.shapeID == 150) {
			this.myTopWidth = this.myParent.dimA2;
		} else if (this.myParent.shapeID == 155) {
			this.myTopWidth = this.myParent.dimA2;
		} else if (this.myParent.shapeID == 154) {
			this.myTopWidth = this.myParent.dimA1;
		} else if (this.myParent.shapeID == 160
					|| this.myParent.shapeID == 165) {
			this.myTopWidth = this.myParent.dimA2;
		}
	}
	
	public void setLeanTo() {
		
		this.myLean = this.myParent.lean;
		this.myLean2 = this.myParent.lean2;
		this.myLean3 = this.myParent.lean3;
		this.myLean4 = this.myParent.lean4;
		if (this.myParent.shapeID == 150) {
			
			this.myLean4 = 0;
			
		} else if (this.myParent.shapeID == 154) {
			
			this.myLean4 = 0;
			
		} else if (this.myParent.shapeID == 155) {
			
			this.myLean4 = 0;
			
		} else if (this.myParent.shapeID == 160
					|| this.myParent.shapeID == 165) {
			
			this.myLean4 = 0;
			
		}
	}
	
	public void setRightObjectInitData() {// Inititalize
		
		// from Rules
		// Execute
		// Rules
		// should pass the entire part object to
		// this Side
		// object
		
		this.partShape = 0; // L, T, Z, I, H,
		this.ABClines = 0; // if reflects lines for
		// ABC dims of
		// parts, by T
		// partDimA = 0f / myParent.myMainPanel.scale;
		// partDimB = 0 / myParent.myMainPanel.scale;
		// partDimC = 0 / myParent.myMainPanel.scale;
		this.endTypeLT = 1;
		this.endTypeRB = 1;
		// partDimM = 0f / myParent.myMainPanel.scale;
		this.partID = 999;
		this.stockCode = "FramePart";
		if (this.myParent.shapeID == 400) {
			this.endTypeRB = 3;
		}
	}
	
	public void rightStraightLine() {
		
		if (this.myParent.a_levelID == 3) {
			// System.out.print("hello");
		}
		if (this.myParent.shapeID == 403) {
			this.endTypeRB = 1;
		}
		if (this.myParent.shapeID == 400) {
			this.endTypeRB = 3;
		}
		if (this.myParent.shapeID == 401) {
			this.endTypeRB = 1;
			// myLean2 = 0;
		}
		if (this.myParent.shapeID == 402 && !this.myParent.rightIn) {
			this.endTypeRB = 3;
		} else if (this.myParent.shapeID == 402
					&& this.myParent.rightIn) {
			this.endTypeRB = 1;
		}
		if (this.myParent.shapeID == 200
					|| this.myParent.shapeID == 202) {
			this.endTypeRB = 3;
		}
		
		this.startX = this.myParent.bX2;
		this.endX = this.myParent.bX3;
		double startPointY = this.myParent.startingY;
		if (this.myParent.top1.partForm == 1) {
			startPointY = this.myParent.startingY;
			
		} else if (this.myParent.top1.partForm == 2) {
			startPointY =
						this.myParent.startingY + this.myParent.dimB1;
			
		} else if (this.myParent.shapeID == 90) {
			startPointY =
						this.myParent.startingY + this.myParent.dimB1;
			
		}
		if (this.myParent.shapeID == 401) {
			
			startPointY = this.myParent.startingY;
		}
		if (this.myParent.shapeID == 400
					|| this.myParent.shapeID == 402) {
			
			startPointY =
						this.myParent.startingY + this.myParent.dimB1;
		}
		if (this.myParent.shapeID == 402 && this.myParent.rightIn) {
			
			startPointY = this.myParent.startingY;
		}
		
		if (this.myLean2 == 2) {// Lean Bot
			if (this.myLean3 == 2) {
				this.endX = this.myParent.bX3 - this.myParent.dimC1;
			} else if (this.myLean3 == 3) {
				this.endX = this.myParent.bX3 - this.myParent.dimC0;
			}
			double myTheta =
						Math.atan(this.myTopWidth / this.myParent.dimB1);
			
			if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
				this.startY = startPointY + this.myParent.dimB1;
			} else if (this.endTypeRB == 2) {// Straight Cut
				this.startY = startPointY + this.myParent.dimB1;
			} else if (this.endTypeRB == 3) {
				this.startY =
							startPointY
							+ this.myParent.dimB1
							+ this.myParent.top1.partDimB
							/ Math.sin(myTheta);
				if (this.myParent.shapeID == 400
							|| this.myParent.shapeID == 402
							|| this.myParent.shapeID == 200
							|| this.myParent.shapeID == 202) {
					this.startY = startPointY;
				}
			}
			if (this.endTypeLT == 1 || this.endTypeLT == 0) {
				this.endY = this.myParent.bY3;
			} else if (this.endTypeLT == 2) {
				this.endY = this.myParent.bY3;
			} else if (this.endTypeLT == 3) {
				if (this.myLean4 == 0 || this.myLean4 == 1) {
					this.endY =
								this.myParent.bY3
								- this.myParent.bot1.partDimB;
				} else {
					myTheta =
								Math.atan(this.myParent.widthPix
											/ this.myParent.dimD1);
					if (this.myLean4 == 3) {
						myTheta =
									Math.atan(this.myParent.widthPix
												/ this.myParent.dimD0);
					}
					this.endY =
								this.myParent.bY3
								- this.myParent.bot1.partDimB
								/ Math.sin(myTheta);
				}
			}
			
			this.myParent.dimB0 = 0;
			
		}
		
		if (this.myLean2 == 1) { // LeanTop
			
			final double myTheta =
						Math.atan(this.myParent.widthPix
									/ this.myParent.dimB2);
			if (this.myLean4 == 0 || this.myLean4 == 2) {
				if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
					this.startY = startPointY;
					;
				} else if (this.endTypeRB == 2) {// Straight Cut
					this.startY = startPointY;
					;
				} else if (this.endTypeRB == 3) {
					
					this.startY =
								startPointY + this.myParent.top1.partDimB;
					
					// Must do this at
					// the end after Get
					// Left PartDims
				}
			} else {
				final double xtheta =
							Math.atan(this.myTopWidth
										/ this.myParent.dimD2);
				
				if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
					this.startY = startPointY;
					;
				} else if (this.endTypeRB == 2) {// Straight Cut
					this.startY = startPointY;
					;
				} else if (this.endTypeRB == 3) {
					this.startY =
								startPointY
								+ this.myParent.top1.partDimB
								/ Math.sin(xtheta);
				}
				
			}
			if (this.endTypeLT == 1 || this.endTypeLT == 0) {
				this.endY = this.myParent.bY3 - this.myParent.dimB2;
			} else if (this.endTypeLT == 2) {
				this.endY = this.myParent.bY3 - this.myParent.dimB2;
			} else if (this.endTypeLT == 3) {
				
				this.endY =
							this.myParent.bY3
							- this.myParent.dimB2
							- this.myParent.bot1.partDimB
							/ Math.sin(myTheta);
				
			}
			this.myParent.dimB0 = 0;
			
		}
		if (this.myLean2 == 3) { // Centered
			final double myTheta =
						Math.atan(this.myTopWidth / this.myParent.dimB0);
			
			if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
				this.startY = startPointY + this.myParent.dimB0;
			} else if (this.endTypeRB == 2) {// Straight Cut
				this.startY = startPointY + this.myParent.dimB0;
			} else if (this.endTypeRB == 3) {
				
				this.startY =
							startPointY
							+ this.myParent.dimB0
							+ this.myParent.top1.partDimB
							/ Math.sin(myTheta);
				
				// Must do this at the end
				// after Get
				// Left PartDims
			}
			if (this.endTypeLT == 1 || this.endTypeLT == 0) {
				this.endY = this.myParent.bY3 - this.myParent.dimB2;
			} else if (this.endTypeLT == 2) {
				this.endY = this.myParent.bY3 - this.myParent.dimB2;
			} else if (this.endTypeLT == 3) {
				
				this.endY =
							this.myParent.bY3
							- this.myParent.dimB2
							- this.myParent.bot1.partDimB
							/ Math.sin(myTheta);
				
			}
			
		}
		
		if (this.myLean2 == 0) {
			
			if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
				this.startY = startPointY;
			} else if (this.endTypeRB == 2) {// Straight Cut
				this.startY = startPointY;
			} else if (this.endTypeRB == 3) {
				this.startY =
							startPointY + this.myParent.top1.partDimB;
				if (this.myLean4 == 1 || this.myLean4 == 3) {
					final double myTheta =
								Math.atan(this.myTopWidth
											/ this.myParent.dimD2);
					this.startY =
								startPointY
								+ this.myParent.top1.partDimB
								/ Math.sin(myTheta);
				}
			}
			
			if (this.myLean == 1 || this.myLean == 3) {
				if (this.endTypeRB == 1 || this.endTypeRB == 0) {
					this.startX =
								this.myParent.bX2 - this.myParent.dimA2;
				} else if (this.endTypeRB == 2) {
					this.startX =
								this.myParent.bX2 - this.myParent.dimA2;
				} else {
					final double theta =
								Math.atan(this.myParent.heightPix
											/ this.myParent.dimA2);
					this.startX =
								this.myParent.bX2
								- this.myParent.dimA2
								+ this.myParent.top1.partDimB
								/ Math.tan(theta);
				}
			} else {// lean 2 or 0
				
				this.startX = this.myParent.bX2;
			if (this.myLean3 == 1 || this.myLean3 == 0) {
				if (this.endTypeRB == 1
							|| this.endTypeRB == 0) {
					this.startX = this.myParent.bX2;
				} else if (this.endTypeRB == 2) {
					this.startX = this.myParent.bX2;
				} else {
					
					this.startX = this.myParent.bX2;
				}
			} else {
				double theta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.dimC1);
				if (this.myLean3 == 3) {
					theta =
								Math.atan(this.myParent.heightPix
											/ this.myParent.dimC0);
				}
				if (this.endTypeRB == 1
							|| this.endTypeRB == 0) {
					this.startX = this.myParent.bX2;
				} else if (this.endTypeRB == 2) {
					this.startX = this.myParent.bX2;
				} else {
					
					this.startX =
								this.myParent.bX2
								- this.myParent.top1.partDimB
								/ Math.tan(theta);
				}
				
			}
			}
			
			if (this.myLean3 == 0 || this.myLean3 == 1) {
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endX = this.myParent.bX3;
				} else if (this.endTypeLT == 2) {
					this.endX = this.myParent.bX3;
				} else {
					if (this.myLean == 0 || this.myLean == 2) {
						this.endX = this.myParent.bX3;
					} else {
						final double theta =
									Math.atan(this.myParent.heightPix
												/ this.myParent.dimA2);
						this.endX =
									this.myParent.bX3
									- this.myParent.bot1.partDimB
									/ Math.tan(theta);
					}
					
				}
			} else if (this.myLean3 == 2) {
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endX =
								this.myParent.bX3 - this.myParent.dimC1;
				} else if (this.endTypeLT == 2) {
					this.endX =
								this.myParent.bX3 - this.myParent.dimC1;
				} else {
					final double theta =
								Math.atan(this.myParent.heightPix
											/ this.myParent.dimC1);
					this.endX =
								this.myParent.bX3
								- this.myParent.dimC1
								+ this.myParent.bot1.partDimB
								/ Math.tan(theta);
				}
				
			} else {
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endX =
								this.myParent.bX3 - this.myParent.dimC0;
				} else if (this.endTypeLT == 2) {
					this.endX =
								this.myParent.bX3 - this.myParent.dimC0;
				} else {
					final double theta =
								Math.atan(this.myParent.heightPix
											/ this.myParent.dimC0);
					this.endX =
								this.myParent.bX3
								- this.myParent.dimC0
								+ this.myParent.bot1.partDimB
								/ Math.tan(theta);
				}
			}
			
			if (this.endTypeLT == 1 || this.endTypeLT == 0) {
				this.endY = this.myParent.bY3;
			} else if (this.endTypeLT == 2) {
				this.endY = this.myParent.bY3;
			} else if (this.endTypeLT == 3) {
				if (this.myLean4 == 0 || this.myLean4 == 1) {
					this.endY =
								this.myParent.bY3
								- this.myParent.bot1.partDimB;
				} else {
					double myTheta =
								Math.atan(this.myParent.widthPix
											/ this.myParent.dimD1);
					if (this.myLean4 == 3) {
						myTheta =
									Math.atan(this.myParent.widthPix
												/ this.myParent.dimD0);
					}
					this.endY =
								this.myParent.bY3
								- this.myParent.bot1.partDimB
								/ Math.sin(myTheta);
				}
				
			}
			
		}
		if (this.myParent.top1.partForm == 2
					|| this.myParent.top1.partForm == 3) {
			if (this.myParent.shapeID != 304) {
				this.startY = this.myParent.top1.endY;
			}
			if (this.myParent.top2.posInUse) {
				this.startY = this.myParent.top2.endY;
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
		this.bkgrdWidth = this.myTopWidth;
		this.bkgrdHeight = this.myParent.heightPix;
		
	}
	
	public void rightStraightLineBA() {
		
		if (this.myParent.a_levelID == 3) {
			// System.out.print("hello");
		}
		if (this.myParent.shapeID == 400) {
			this.endTypeRB = 3;
		}
		if (this.myParent.shapeID == 401) {
			this.endTypeRB = 1;
			// myLean2 = 0;
		}
		if (this.myParent.shapeID == 200
					|| this.myParent.shapeID == 202) {
			this.endTypeRB = 3;
		}
		if (this.myParent.shapeID == 402 && !this.myParent.rightIn) {
			this.endTypeRB = 3;
		} else if (this.myParent.shapeID == 402
					&& this.myParent.rightIn) {
			this.endTypeRB = 1;
		}
		double startPointY = this.myParent.startingY;
		if (this.myParent.top1.partForm == 1) {
			startPointY = this.myParent.startingY;
			
		} else if (this.myParent.top1.partForm == 2
					|| this.myParent.top1.partForm == 3 && this.myParent.shapeID != 401) {
			startPointY =
						this.myParent.startingY + this.myParent.dimB1;
			
		}
		if (this.myParent.shapeID == 401) {
			
			startPointY = this.myParent.startingY;
		}
		if (this.myParent.shapeID == 402
					&& this.myParent.rightIn
					&& this.myParent.wire) {
			
			startPointY = this.myParent.startingY;
		}
		if (this.myParent.shapeID == 402 && !this.myParent.wire) {
			
			startPointY =
						this.myParent.startingY + this.myParent.dimB1;
		}
		
		if (this.myParent.shapeID == 403) {
			
			startPointY = this.myParent.startingY;
		}
		
		if (this.myLean2 == 2) {// Lean Bot
			double theta = 0;
		this.startXBA = this.startX - this.partDimB;
		this.endXBA = this.startXBA;
		
		theta = Math.atan(this.myTopWidth / this.myParent.dimB1);
		
		if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
			this.startYBA =
						this.startY
						- this.partDimB
						/ Math.tan(theta)
						+ this.myParent.top1.partDimB
						/ Math.sin(theta);
		} else if (this.endTypeRB == 2) {// Straight Cut
			this.startYBA =
						this.startY - this.partDimB / Math.tan(theta);
			
		} else if (this.endTypeRB == 3) {
			this.startYBA =
						this.startY - this.partDimB / Math.tan(theta);
			if (this.myParent.shapeID == 400
						|| this.myParent.shapeID == 402
						|| this.myParent.shapeID == 200
						|| this.myParent.shapeID == 202) {
				this.startYBA = this.startY;
			}
		}
		if (this.myLean4 == 0 || this.myLean4 == 1) {
			if (this.endTypeLT == 1 || this.endTypeLT == 0) {
				this.endYBA =
							this.myParent.bY3
							- this.myParent.bot1.partDimB;
			} else if (this.endTypeLT == 2) {
				this.endYBA = this.myParent.bY3;
			} else if (this.endTypeLT == 3) {
				
				if (this.myParent.bot1.partDimB != 0) {
					this.endYBA =
								this.myParent.bY3
								- this.myParent.bot1.partDimB;
				}
			}
			
		} else {
			theta =
						Math.atan(this.myParent.widthPix
									/ this.myParent.dimD1);
			if (this.myLean4 == 3) {
				theta =
							Math.atan(this.myParent.widthPix
										/ this.myParent.dimD0);
			}
			if (this.endTypeLT == 1 || this.endTypeLT == 0) {
				this.endYBA =
							this.endY
							- this.myParent.bot1.partDimB
							/ Math.sin(theta)
							- this.partDimB
							/ Math.tan(theta);
			} else if (this.endTypeLT == 2) {
				this.endYBA =
							this.endY
							- this.partDimB
							/ Math.tan(theta);
				
			} else if (this.endTypeLT == 3) {
				this.endYBA =
							this.endY
							- this.partDimB
							/ Math.tan(theta);
			}
		}
		
		if (this.myLean3 == 3 || this.myLean3 == 2) {
			
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
						Math.toRadians(180) - theta1 - theta2;
			final double hypotenus =
						this.partDimB / Math.sin(myTheta / 2);
			final double baseY =
						hypotenus * Math.cos(myTheta / 2 + theta1);
			final double baseX =
						hypotenus * Math.sin(myTheta / 2 + theta1);
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
				this.endX
				- this.partDimB
				/ Math.sin(theta1)
				+ this.partDimB
				/ Math.tan(theta1);
			} else if (this.endTypeLT == 2) {// Straight Cut
				this.endXBA =
				this.endX
				- this.partDimB
				/ Math.sin(theta1);
			} else if (this.endTypeLT == 3) {
				this.endXBA =
							this.endX
							- this.partDimB
							/ Math.sin(theta1);
			}
			this.endYBA = this.endY - this.myParent.bot1.partDimB;
		}
		this.myParent.dimB0 = 0;
		
		}
		
		if (this.myLean2 == 1) { // LeanTop
			this.startXBA = this.startX - this.partDimB;
			this.endXBA = this.startXBA;
			
			final double theta =
						Math.atan(this.myTopWidth / this.myParent.dimB2);
			
			if (this.myLean4 == 0 || this.myLean4 == 2) {
				if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
					
					this.startYBA =
								startPointY + this.myParent.top1.partDimB;
					// (this.partDimB*(double)
					// Math.tan(theta));
				} else if (this.endTypeRB == 2) {// Straight Cut
					this.startYBA = startPointY;
				} else if (this.endTypeRB == 3) {
					this.startYBA =
								startPointY + this.myParent.top1.partDimB;
				}
			} else {
				final double xtheta =
							Math.atan(this.myTopWidth
										/ this.myParent.dimD2);
				if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
					this.startYBA =
								this.startY
								+ this.partDimB
								/ Math.tan(xtheta)
								+ this.myParent.top1.partDimB
								/ Math.sin(xtheta);
					// (this.partDimB*(double)
					// Math.tan(theta));
				} else if (this.endTypeRB == 2) {// Straight Cut
					this.startYBA =
								this.startY
								+ this.partDimB
								/ Math.tan(xtheta);
				} else if (this.endTypeRB == 3) {
					this.startYBA =
								this.startY
								+ this.partDimB
								/ Math.tan(xtheta);
				}
				
			}
			
			if (this.endTypeLT == 1 || this.endTypeLT == 0) {
				this.endYBA =
							this.myParent.bY3
							- this.myParent.dimB2
							+ this.partDimB
							/ Math.tan(theta)
							- this.myParent.bot1.partDimB
							/ Math.sin(theta);
			} else if (this.endTypeLT == 2) {
				this.endYBA =
							this.myParent.bY3
							- this.myParent.dimB2
							+ this.partDimB
							/ Math.tan(theta);
			} else if (this.endTypeLT == 3) {
				this.endYBA =
							this.myParent.bY3
							- this.myParent.dimB2
							+ this.partDimB
							/ Math.tan(theta)
							- this.myParent.bot1.partDimB
							/ Math.sin(theta);
				
			}
			this.myParent.dimB0 = 0;
			
		}
		if (this.myLean2 == 3) { // Centered
			this.startXBA = this.startX - this.partDimB;
			this.endXBA = this.startXBA;
			double theta =
						Math.atan(this.myTopWidth / this.myParent.dimB0);
			if (this.myParent.bot3.posInUse) {
				theta =
							Math.atan(this.myParent.dimA2
										/ this.myParent.dimB0);
			}
			if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
				this.startYBA =
				startPointY
				+ this.myParent.dimB0
				- this.partDimB
				/ Math.tan(theta)
				+ this.myParent.top1.partDimB
				/ Math.sin(theta);
				
			} else if (this.endTypeRB == 2) {// Straight Cut
				this.startYBA =
							startPointY
							+ this.myParent.dimB0
							- this.partDimB
							/ Math.tan(theta);
			} else if (this.endTypeRB == 3) {
				this.startYBA =
							startPointY
							+ this.myParent.dimB0
							- this.partDimB
							/ Math.tan(theta)
							+ this.myParent.top1.partDimB
							/ Math.sin(theta);
			}
			theta = Math.atan(this.myTopWidth / this.myParent.dimB2);
			if (this.myParent.bot3.posInUse) {
				theta =
							Math.atan(this.myParent.dimC0
										/ this.myParent.dimB2);
			}
			if (this.endTypeLT == 1 || this.endTypeLT == 0) {
				this.endYBA =
							this.myParent.bY3
							- this.myParent.dimB2
							+ this.partDimB
							/ Math.tan(theta)
							- this.myParent.bot1.partDimB
							/ Math.sin(theta);
			} else if (this.endTypeLT == 2) {
				this.endYBA =
							this.myParent.bY3
							- this.myParent.dimB2
							+ this.partDimB
							/ Math.tan(theta);
			} else if (this.endTypeLT == 3) {
				this.endYBA =
							this.myParent.bY3
							- this.myParent.dimB2
							+ this.partDimB
							/ Math.tan(theta)
							- this.myParent.bot1.partDimB
							/ Math.sin(theta);
				
			}
			
		}
		if (this.myLean2 == 0) {
			
			this.startXBA = this.startX - this.partDimB;
			
			if (this.myLean == 0 || this.myLean == 2) {
				this.startXBA = this.startX - this.partDimB;
			} else {
				final double theta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.dimA2);
				
				if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
					this.startXBA =
					this.startX
					+ this.myParent.top1.partDimB
					/ Math.tan(theta)
					- this.partDimB
					/ Math.sin(theta);
				} else if (this.endTypeRB == 2) {// Straight Cut
					this.startXBA =
								this.startX
								- this.partDimB
								/ Math.sin(theta);
				} else if (this.endTypeRB == 3) {
					this.startXBA =
								this.startX
								- this.partDimB
								/ Math.sin(theta);
				}
				
			}
			if (this.myLean3 == 2 || this.myLean3 == 3) {
				double theta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.dimC1);
				if (this.myLean3 == 3) {
					theta =
								Math.atan(this.myParent.heightPix
											/ this.myParent.dimC0);
				}
				if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
					this.startXBA =
					this.startX
					- this.myParent.top1.partDimB
					/ Math.tan(theta)
					- this.partDimB
					/ Math.sin(theta);
				} else if (this.endTypeRB == 2) {// Straight Cut
					this.startXBA =
								this.startX
								- this.partDimB
								/ Math.sin(theta);
				} else if (this.endTypeRB == 3) {
					this.startXBA =
								this.startX
								- this.partDimB
								/ Math.sin(theta);
				}
				
			}
			
			if (this.myLean == 0 || this.myLean == 2) {
				this.endXBA = this.endX - this.partDimB;
			} else {
				final double theta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.dimA2);
				
				if (this.endTypeLT == 1 || this.endTypeLT == 0) { // Mitered
					this.endXBA =
					this.endX
					- this.partDimB
					/ Math.sin(theta)
					- this.myParent.bot1.partDimB
					/ Math.tan(theta);
				} else if (this.endTypeLT == 2) {// Straight Cut
					this.endXBA =
								this.endX
								- this.partDimB
								/ Math.sin(theta);
				} else if (this.endTypeLT == 3) {
					this.endXBA =
								this.endX
								- this.partDimB
								/ Math.sin(theta);
				}
				
			}
			
			if (this.myLean3 == 2 || this.myLean3 == 3) {
				double theta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.dimC1);
				if (this.myLean3 == 3) {
					theta =
								Math.atan(this.myParent.heightPix
											/ this.myParent.dimC0);
				}
				
				if (this.endTypeLT == 1 || this.endTypeLT == 0) { // Mitered
					this.endXBA =
					this.endX
					- this.partDimB
					/ Math.sin(theta)
					+ this.myParent.bot1.partDimB
					/ Math.tan(theta);
				} else if (this.endTypeLT == 2) {// Straight Cut
					this.endXBA =
								this.endX
								- this.partDimB
								/ Math.sin(theta);
				} else if (this.endTypeLT == 3) {
					this.endXBA =
								this.endX
								- this.partDimB
								/ Math.sin(theta);
				}
				
			}
			
			if (this.myLean4 == 0 || this.myLean4 == 2) {
				if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
					this.startYBA =
								startPointY + this.myParent.top1.partDimB;
				} else if (this.endTypeRB == 2) {// Straight Cut
					this.startYBA = startPointY;
				} else if (this.endTypeRB == 3) {
					this.startYBA =
								startPointY + this.myParent.top1.partDimB;
				}
			} else {
				final double myTheta =
							Math.atan(this.myTopWidth
										/ this.myParent.dimD2);
				if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
					this.startYBA =
								startPointY
								+ this.partDimB
								/ Math.tan(myTheta)
								+ this.myParent.top1.partDimB
								/ Math.sin(myTheta);
				} else if (this.endTypeRB == 2) {// Straight Cut
					this.startYBA =
								startPointY
								+ this.partDimB
								/ Math.tan(myTheta);
				} else if (this.endTypeRB == 3) {
					this.startYBA =
								startPointY
								+ this.partDimB
								/ Math.tan(myTheta)
								+ this.myParent.top1.partDimB
								/ Math.sin(myTheta);
				}
			}
			if (this.myLean4 == 0 || this.myLean4 == 1) {
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endYBA =
								this.myParent.bY3
								- this.myParent.bot1.partDimB;
				} else if (this.endTypeLT == 2) {
					this.endYBA = this.myParent.bY3;
				} else {
					this.endYBA =
								this.myParent.bY3
								- this.myParent.bot1.partDimB;
				}
			} else {
				double myTheta =
							Math.atan(this.myParent.widthPix
										/ this.myParent.dimD1);
				if (this.myLean4 == 3) {
					myTheta =
								Math.atan(this.myTopWidth
											/ this.myParent.dimD0);
				}
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endYBA =
								this.myParent.bY3
								- this.partDimB
								/ Math.tan(myTheta)
								- this.myParent.bot1.partDimB
								/ Math.sin(myTheta);
				}
				if (this.endTypeLT == 2) {
					this.endYBA =
								this.myParent.bY3
								- this.partDimB
								/ Math.tan(myTheta);
				} else {
					this.endYBA =
								this.myParent.bY3
								- this.partDimB
								/ Math.tan(myTheta)
								- this.myParent.bot1.partDimB
								/ Math.sin(myTheta);
				}
				
			}
			
		}
		if (this.myParent.top1.partForm == 2
					|| this.myParent.top1.partForm == 3) {
			this.startYBA = this.myParent.top1.endYBA;
			// this.startXBA =
			// this.myLevelShape.top2.endXBA;
		}
		if (this.myParent.top2.posInUse) {
			this.startYBA = this.myParent.top2.endYBA;
			this.startXBA = this.myParent.top2.endXBA;
		}
	}
	
	public void rightStraightLineA() {
		
		double startPointY = this.myParent.startingY;
		if (this.myParent.top1.partForm == 1) {
			startPointY = this.myParent.startingY;
			
		} else if (this.myParent.top1.partForm == 2
					|| this.myParent.top1.partForm == 3 && this.myParent.shapeID != 401) {
			startPointY =
						this.myParent.startingY + this.myParent.dimB1;
			
		}
		if (this.myParent.shapeID == 401) {
			
			startPointY = this.myParent.startingY;
		}
		
		if (this.myParent.shapeID == 402 && this.myParent.rightIn) {
			
			startPointY = this.myParent.startingY;
		}
		if (this.myParent.shapeID == 403) {
			
			startPointY = this.myParent.startingY;
		}
		
		if (this.myParent.shapeID == 400) {
			this.endTypeRB = 3;
		}
		if (this.myParent.shapeID == 401) {
			this.endTypeRB = 1;
			// myLean2 = 0;
		}
		if (this.myParent.shapeID == 402 && !this.myParent.rightIn) {
			this.endTypeRB = 3;
		} else if (this.myParent.shapeID == 402
					&& this.myParent.rightIn) {
			this.endTypeRB = 1;
		}
		if (this.myParent.shapeID == 200
					|| this.myParent.shapeID == 202) {
			this.endTypeRB = 3;
		}
		if (this.myLean2 == 2) {// Lean Bot
			
			this.startXA =
						this.startX - (this.partDimB + this.partDimA);
			this.endXA = this.endX - (this.partDimB + this.partDimA);
			this.stopAeX = this.endXBA;
			this.stopAsX = this.startXBA;
			
			double theta =
						Math.atan(this.myTopWidth
									/ this.myParent.dimB1);
			
			if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
				this.startYA =
							this.startY
							- (this.partDimB + this.partDimA)
							/ Math.tan(theta)
							+ (this.myParent.top1.partDimB + this.myParent.top1.partDimA)
							/ Math.sin(theta);
				
			} else if (this.endTypeRB == 2) {// Straight Cut
				this.startYA =
							this.startY
							+ (this.myParent.top1.partDimB + this.myParent.top1.partDimA)
							/ Math.sin(theta)
							- (this.partDimB + this.partDimA)
							/ Math.tan(theta);
				this.stopAsY =
							this.startYA
							+ this.partDimA
							/ Math.tan(theta);
			} else if (this.endTypeRB == 3) {
				this.startYA =
							this.startY
							- (this.partDimB + this.partDimA)
							/ Math.tan(theta);
				if (this.myParent.shapeID == 400
							|| this.myParent.shapeID == 402
							|| this.myParent.shapeID == 200
							|| this.myParent.shapeID == 202) {
					this.startYA = this.startY;
				}
			}
			if (this.myLean4 == 0 || this.myLean4 == 1) {
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endYA =
								this.myParent.bY3
								- (this.myParent.bot1.partDimB + this.myParent.bot1.partDimA);
				} else if (this.endTypeLT == 2) {
					this.endYA =
								this.myParent.bY3
								- (this.myParent.bot1.partDimB + this.myParent.bot1.partDimA);
					this.stopAeY = this.endYA;
				} else if (this.endTypeLT == 3) {
					this.endYA =
								this.myParent.bY3
								- this.myParent.bot1.partDimB;
					
				}
			} else {
				theta =
							Math.atan(this.myParent.widthPix
										/ this.myParent.dimD1);
				if (this.myLean4 == 3) {
					theta =
								Math.atan(this.myParent.widthPix
											/ this.myParent.dimD0);
				}
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endYA =
								this.endY
								- (this.myParent.bot1.partDimB + this.myParent.bot1.partDimA)
								/ Math.sin(theta)
								- (this.partDimB + this.partDimA)
								/ Math.tan(theta);
					
				} else if (this.endTypeLT == 2) {
					this.endYA =
								this.endY
								- (this.myParent.bot1.partDimB + this.myParent.bot1.partDimA)
								/ Math.sin(theta)
								- (this.partDimB + this.partDimA)
								/ Math.tan(theta);
					this.stopAeY =
								this.endYA
								+ this.partDimA
								/ Math.tan(theta);
				} else if (this.endTypeLT == 3) {
					this.endYA =
								this.endY
								- (this.partDimB + this.partDimA)
								/ Math.tan(theta);
					
				}
				
			}
			
			if (this.myLean3 == 3 || this.myLean3 == 2) {
				
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
							Math.toRadians(180)
							- theta1
							- theta2;
				final double hypotenus =
							(this.partDimB + this.partDimA)
							/ Math.sin(myTheta / 2);
				final double baseY =
							hypotenus
							* Math.cos(myTheta
										/ 2
										+ theta1);
				final double baseX =
							hypotenus
							* Math.sin(myTheta
										/ 2
										+ theta1);
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
					this.endX
					- (this.partDimB + this.partDimA)
					/ Math.sin(theta1)
					+ (this.partDimB + this.partDimA)
					/ Math.tan(theta1);
				} else if (this.endTypeLT == 2) {// Straight Cut
					this.endXA =
					this.endX
					- (this.partDimB + this.partDimA)
					/ Math.sin(theta1);
				} else if (this.endTypeLT == 3) {
					this.endXA =
								this.endX
								- (this.partDimB + this.partDimA)
								/ Math.sin(theta1);
				}
				this.endYA =
							this.endY
							- this.myParent.bot1.partDimB
							- this.myParent.top1.partDimA;
			}
			this.myParent.dimB0 = 0;
			
		}
		
		if (this.myLean2 == 1) { // LeanTop
			this.startXA =
						this.startX - (this.partDimB + this.partDimA);
			this.endXA = this.startXA;
			
			final double theta =
						Math.atan(this.myTopWidth
									/ this.myParent.dimB2);
			
			if (this.myLean4 == 0 || this.myLean4 == 2) {
				if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
					
					this.startYA =
								startPointY
								+ this.myParent.top1.partDimB
								+ this.myParent.top1.partDimA;
					// ((this.partDimB+this.partDimA)*(double)
					// Math.tan(theta));
				} else if (this.endTypeRB == 2) {// Straight Cut
					this.startYA =
								startPointY
								+ this.myParent.top1.partDimB
								+ this.myParent.top1.partDimA;
				} else if (this.endTypeRB == 3) {
					this.startYA =
								startPointY + this.myParent.top1.partDimB;
				}
			} else {
				final double xtheta =
							Math.atan(this.myTopWidth
										/ this.myParent.dimD2);
				if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
					this.startYA =
								this.startY
								+ (this.partDimB + this.partDimA)
								/ Math.tan(xtheta)
								+ (this.myParent.top1.partDimB + this.myParent.top1.partDimA)
								/ Math.sin(xtheta);
					// (this.partDimB*(double)
					// Math.tan(theta));
				} else if (this.endTypeRB == 2) {// Straight Cut
					this.startYA =
								this.startY
								+ (this.partDimB + this.partDimA)
								/ Math.tan(xtheta)
								+ (this.myParent.top1.partDimB + this.myParent.top1.partDimA)
								/ Math.sin(xtheta);
				} else if (this.endTypeRB == 3) {
					this.startYA =
								this.startY
								+ (this.partDimB + this.partDimA)
								/ Math.tan(xtheta);
				}
				
			}
			
			if (this.endTypeLT == 1 || this.endTypeLT == 0) {
				this.endYA =
							this.myParent.bY3
							- this.myParent.dimB2
							+ (this.partDimB + this.partDimA)
							/ Math.tan(theta)
							- (this.myParent.bot1.partDimB + this.myParent.bot1.partDimA)
							/ Math.sin(theta);
			} else if (this.endTypeLT == 2) {
				this.endYA =
							this.endY
							+ (this.partDimB + this.partDimA)
							/ Math.tan(theta)
							- (this.myParent.bot1.partDimB + this.myParent.bot1.partDimA)
							/ Math.sin(theta);
				this.stopAeY =
							this.endYA
							- this.partDimA
							/ Math.tan(theta);
			} else if (this.endTypeLT == 3) {
				this.endYA =
							this.endY
							+ (this.partDimB + this.partDimA)
							/ Math.tan(theta);
				
			}
			this.myParent.dimB0 = 0;
			
		}
		if (this.myLean2 == 3) { // Centered
			this.startXA =
						this.startX - (this.partDimB + this.partDimA);
			this.endXA = this.startXA;
			double theta =
						Math.atan(this.myTopWidth
									/ this.myParent.dimB0);
			if (this.myParent.bot3.posInUse) {
				theta =
							Math.atan(this.myParent.dimA2
										/ this.myParent.dimB0);
			}
			if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
				this.startYA =
				startPointY
				+ this.myParent.dimB0
				- (this.partDimB + this.partDimA)
				/ Math.tan(theta)
				+ (this.myParent.top1.partDimB + this.myParent.top1.partDimA)
				/ Math.sin(theta);
				
			} else if (this.endTypeRB == 2) {// Straight Cut
				this.startYA =
							startPointY
							+ this.myParent.dimB0
							- (this.partDimB + this.partDimA)
							/ Math.tan(theta)
							+ (this.myParent.top1.partDimB + this.myParent.top1.partDimA)
							/ Math.sin(theta);
				
			} else if (this.endTypeRB == 3) {
				this.startYA =
							startPointY
							+ this.myParent.dimB0
							- (this.partDimB + this.partDimA)
							/ Math.tan(theta)
							+ this.myParent.top1.partDimB
							/ Math.sin(theta);
			}
			
			theta =
						Math.atan(this.myTopWidth
									/ this.myParent.dimB2);
			if (this.myParent.bot3.posInUse) {
				theta =
							Math.atan(this.myParent.dimC0
										/ this.myParent.dimB2);
			}
			if (this.endTypeLT == 1 || this.endTypeLT == 0) {
				this.endYA =
							this.myParent.bY3
							- this.myParent.dimB2
							+ (this.partDimB + this.partDimA)
							/ Math.tan(theta)
							- (this.myParent.bot1.partDimB + this.myParent.bot1.partDimA)
							/ Math.sin(theta);
			} else if (this.endTypeLT == 2) {
				this.endYA =
							this.endY
							+ (this.partDimB + this.partDimA)
							/ Math.tan(theta)
							- (this.myParent.bot1.partDimB + this.myParent.bot1.partDimA)
							/ Math.sin(theta);
			} else if (this.endTypeLT == 3) {
				this.endYA =
							this.endY
							+ (this.partDimB + this.partDimA)
							/ Math.tan(theta);
				
			}
			
		}
		if (this.myLean2 == 0) {
			
			this.startXA =
						this.startX - (this.partDimB + this.partDimA);
			this.stopAeX = this.endXBA;
			if (this.myLean == 0 || this.myLean == 2) {
				if (this.endTypeRB == 1 || this.endTypeRB == 0) {
					this.startXA =
								this.startX
								- (this.partDimB + this.partDimA);
				} else if (this.endTypeRB == 2) {
					this.startXA =
								this.startX
								- (this.partDimB + this.partDimA);
					this.stopAsX = this.startXBA;
				} else {
					this.startXA =
								this.startX
								- (this.partDimB + this.partDimA);
				}
			} else {
				final double theta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.dimA2);
				
				if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
					this.startXA =
					this.startX
					+ (this.myParent.top1.partDimB + this.myParent.top1.partDimA)
					/ Math.tan(theta)
					- (this.partDimB + this.partDimA)
					/ Math.sin(theta);
				} else if (this.endTypeRB == 2) {// Straight Cut
					this.startXA =
					this.startX
					+ (this.myParent.top1.partDimB + this.myParent.top1.partDimA)
					/ Math.tan(theta)
					- (this.partDimB + this.partDimA)
					/ Math.sin(theta);
					this.stopAsX =
								this.startXA
								+ this.partDimA
								/ Math.sin(theta);
				} else if (this.endTypeRB == 3) {
					this.startXA =
								this.startX
								- (this.partDimB + this.partDimA)
								/ Math.sin(theta);
				}
				
			}
			if (this.myLean3 == 2 || this.myLean3 == 3) {
				double theta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.dimC1);
				if (this.myLean3 == 3) {
					theta =
								Math
								.atan(this.myParent.heightPix
											/ this.myParent.dimC0);
				}
				if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
					this.startXA =
					this.startX
					- (this.myParent.top1.partDimB + this.myParent.top1.partDimA)
					/ Math.tan(theta)
					- (this.partDimB + this.partDimA)
					/ Math.sin(theta);
				} else if (this.endTypeRB == 2) {// Straight Cut
					this.startXA =
								this.startX
								- (this.myParent.top1.partDimB + this.myParent.top1.partDimA)
								/ Math.tan(theta)
								- (this.partDimB + this.partDimA)
								/ Math.sin(theta);
					this.stopAsX =
								this.startXA
								- this.partDimA
								/ Math.sin(theta);
					;
				} else if (this.endTypeRB == 3) {
					this.startXA =
								this.startX
								- (this.partDimB + this.partDimA)
								/ Math.sin(theta);
				}
				
			}
			
			if (this.myLean == 0 || this.myLean == 2) {
				this.endXA =
							this.endX - (this.partDimB + this.partDimA);
			} else {
				final double theta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.dimA2);
				
				if (this.endTypeLT == 1 || this.endTypeRB == 0) { // Mitered
					this.endXA =
					this.endX
					- (this.partDimB + this.partDimA)
					/ Math.sin(theta)
					- (this.myParent.bot1.partDimB + this.myParent.bot1.partDimA)
					/ Math.tan(theta);
				} else if (this.endTypeLT == 2) {// Straight Cut
					this.endXA =
								this.endX
								- (this.partDimB + this.partDimA)
								/ Math.sin(theta)
								- (this.myParent.bot1.partDimB + this.myParent.bot1.partDimA)
								/ Math.tan(theta);
					
					this.stopAeX =
								this.endXA
								+ this.partDimA
								/ Math.sin(theta);
					
				} else if (this.endTypeLT == 3) {
					this.endXA =
								this.endX
								- (this.partDimB + this.partDimA)
								/ Math.sin(theta);
				}
				
			}
			
			if (this.myLean3 == 2 || this.myLean3 == 3) {
				double theta =
							Math.atan(this.myParent.heightPix
										/ this.myParent.dimC1);
				if (this.myLean3 == 3) {
					theta =
								Math
								.atan(this.myParent.heightPix
											/ this.myParent.dimC0);
				}
				
				if (this.endTypeLT == 1 || this.endTypeLT == 0) { // Mitered
					this.endXA =
					this.endX
					- (this.partDimB + this.partDimA)
					/ Math.sin(theta)
					+ (this.myParent.bot1.partDimB + this.myParent.bot1.partDimA)
					/ Math.tan(theta);
				} else if (this.endTypeLT == 2) {// Straight Cut
					this.endXA =
								this.endX
								- (this.partDimB + this.partDimA)
								/ Math.sin(theta)
								+ (this.myParent.bot1.partDimB + this.myParent.bot1.partDimA)
								/ Math.tan(theta);
					this.stopAeX =
								this.endXA
								+ this.partDimA
								/ Math.sin(theta);
				} else if (this.endTypeLT == 3) {
					this.endXA =
								this.endX
								- (this.partDimB + this.partDimA)
								/ Math.sin(theta);
				}
				
			}
			
			if (this.myLean4 == 0 || this.myLean4 == 2) {
				if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
					this.startYA =
								startPointY
								+ this.myParent.top1.partDimB
								+ this.myParent.top1.partDimA;
				} else if (this.endTypeRB == 2) {// Straight Cut
					this.startYA =
								startPointY
								+ this.myParent.top1.partDimB
								+ this.myParent.top1.partDimA;
					this.stopAsY = this.startYA;
				} else if (this.endTypeRB == 3) {
					this.startYA =
								startPointY + this.myParent.top1.partDimB;
				}
			} else {
				final double myTheta =
							Math.atan(this.myTopWidth
										/ this.myParent.dimD2);
				if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
					this.startYA =
								startPointY
								+ (this.partDimB + this.partDimA)
								/ Math.tan(myTheta)
								+ (this.myParent.top1.partDimB + this.myParent.top1.partDimA)
								/ Math.sin(myTheta);
				} else if (this.endTypeRB == 2) {// Straight Cut
					this.startYA =
								startPointY
								+ (this.partDimB + this.partDimA)
								/ Math.tan(myTheta)
								+ (this.myParent.top1.partDimB + this.myParent.top1.partDimA)
								/ Math.sin(myTheta);
					this.stopAsY =
								this.startYA
								- this.partDimA
								/ Math.tan(myTheta);
				} else if (this.endTypeRB == 3) {
					this.startYA =
								this.startY
								+ (this.partDimB + this.partDimA)
								/ Math.tan(myTheta);
				}
			}
			if (this.myLean4 == 0 || this.myLean4 == 1) {
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endYA =
								this.myParent.bY3
								- (this.myParent.bot1.partDimB + this.myParent.bot1.partDimA);
				} else if (this.endTypeLT == 2) {
					this.endYA =
								this.myParent.bY3
								- (this.myParent.bot1.partDimB + this.myParent.bot1.partDimA);
					this.stopAeY = this.endYA;
				} else {
					this.endYA =
								this.myParent.bY3
								- this.myParent.bot1.partDimB;
				}
			} else {
				double myTheta =
							Math.atan(this.myParent.widthPix
										/ this.myParent.dimD1);
				if (this.myLean4 == 3) {
					myTheta =
								Math.atan(this.myParent.widthPix
											/ this.myParent.dimD0);
				}
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endYA =
								this.myParent.bY3
								- (this.partDimB + this.partDimA)
								/ Math.tan(myTheta)
								- (this.myParent.bot1.partDimB + this.myParent.bot1.partDimA)
								/ Math.sin(myTheta);
				} else if (this.endTypeLT == 2) {
					this.endYA =
								this.myParent.bY3
								- (this.partDimB + this.partDimA)
								/ Math.tan(myTheta)
								- (this.myParent.bot1.partDimB + this.myParent.bot1.partDimA)
								/ Math.sin(myTheta);
					this.stopAeY =
								this.endYA
								+ this.partDimA
								/ Math.tan(myTheta);
				} else {
					this.endYA =
								this.endY
								- (this.partDimB + this.partDimA)
								/ Math.tan(myTheta);
				}
				
			}
		}
		
		if (this.myParent.top1.partForm == 2
					|| this.myParent.top1.partForm == 3) {
			this.startYA = this.myParent.top1.endYA;
			if (this.myParent.top2.posInUse) {
				this.startYA = this.myParent.top2.endYA;
			}
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
					Math.atan((this.startX - this.startXA)
								/ (this.startY - this.startYA));
	}

    public RightObject clone() {
        try {

            RightObject newObject = (RightObject)super.clone();

            return newObject;

        } catch (CloneNotSupportedException e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }
	
}

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


public class Top2Object extends ProfileParts implements Cloneable {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(Top2Object.class);
	
	/**
	 * Creating Top2Object
	 */
	public Top2Object() {
		//Initializing values
		posInUse = false;
		position = 2; //1
		color = 1;
	}
	
	/**
	 * Creating Top2Object
	 *
	 * @param levelShape, ShapeObject
	 * @param newPart,    boolean
	 */
	public Top2Object(ShapeObject levelShape, boolean newPart) {
		
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
			this.partID = this.myLevelShape.top2.partID;
			this.partDimB = this.myLevelShape.top2.partDimB;
			this.partDimA = this.myLevelShape.top2.partDimA;
			this.partDimC = this.myLevelShape.top2.partDimC;
			this.partDimM = this.myLevelShape.top2.partDimM;
			this.endTypeLT = this.myLevelShape.top2.endTypeLT;
			this.endTypeRB = this.myLevelShape.top2.endTypeRB;
			
		}
	}
	
	public void lineStraight1B_2() {
		
		if (!this.myLevelShape.top3.posInUse
					&& (this.myLevelShape.lean4 == 1 || this.myLevelShape.lean4 == 3)
					&& (this.myLevelShape.lean2 == 2 || this.myLevelShape.lean2 == 3)) {
			this.endTypeRB = 1;
		}
		this.partForm = 1;
		this.startY = this.myLevelShape.startingY;
		this.endY = this.startY;
		this.startX =
					this.myLevelShape.startingX + this.myLevelShape.dimA1;
		this.endX = this.myLevelShape.bX2;
		
		if (this.myLevelShape.noSidesTop == 3) {
			this.startX =
						this.myLevelShape.startingX
						+ this.myLevelShape.widthPix
						- this.myLevelShape.dimA2;
			this.startY = this.myLevelShape.startingY;
		}
		
		if (this.myLevelShape.lean2 == 0
					|| this.myLevelShape.lean2 == 1) {
			
			if (this.endTypeRB == 1 || this.endTypeRB == 0) {
				this.startX =
							this.myLevelShape.startingX
							+ this.myLevelShape.dimA1;
				this.startY = this.myLevelShape.startingY;
			} else if (this.endTypeRB == 2) {
				this.startX =
							this.myLevelShape.startingX
							+ this.myLevelShape.dimA1;
				this.startY = this.myLevelShape.startingY;
			} else if (this.endTypeRB == 3) {
				final double theta =
							Math.atan(this.myLevelShape.dimD2
										/ this.myLevelShape.dimA1);
				this.startX =
							this.myLevelShape.startingX
							+ this.myLevelShape.dimA1
							+ this.myLevelShape.top1.partDimB
							/ Math.sin(theta);
				this.startY = this.myLevelShape.startingY;
			}
			if (this.myLevelShape.lean3 == 0
						|| this.myLevelShape.lean3 == 1) {
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endX = this.myLevelShape.bX2;
					this.endY = this.myLevelShape.bY2;
				} else if (this.endTypeLT == 2) {
					this.endX = this.myLevelShape.bX2;
					this.endY = this.myLevelShape.startingY;
				} else if (this.endTypeLT == 3) {
					this.endX =
								this.myLevelShape.bX2
								- this.myLevelShape.right.partDimB;
					this.endY = this.myLevelShape.startingY;
				}
			} else if (this.myLevelShape.lean3 == 2
						|| this.myLevelShape.lean3 == 3) {
				double theta =
							Math
							.atan(this.myLevelShape.heightPix
										/ this.myLevelShape.dimC1);
				if (this.myLevelShape.lean3 == 3) {
					theta =
								Math
								.atan(this.myLevelShape.heightPix
											/ this.myLevelShape.dimC0);
				}
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endX = this.myLevelShape.bX2;
					this.endY = this.myLevelShape.bY2;
				} else if (this.endTypeLT == 2) {
					this.endX = this.myLevelShape.bX2;
					this.endY = this.myLevelShape.bY2;
				} else if (this.endTypeLT == 3) {
					this.endX =
								this.myLevelShape.bX2
								- this.myLevelShape.right.partDimB
								/ Math.sin(theta);
					this.endY = this.myLevelShape.bY2;
				}
			}
		} else if (this.myLevelShape.lean2 == 2
					|| this.myLevelShape.lean2 == 3) {
			double theta = 0;
			
			if (this.endTypeRB == 1 || this.endTypeRB == 0) {
				this.startX = this.myLevelShape.top1.endX;
				this.startY = this.myLevelShape.top1.endY;
			} else if (this.endTypeRB == 2) {
				this.startX =
							this.myLevelShape.startingX
							+ this.myLevelShape.widthPix
							- this.myLevelShape.dimA2;
				this.startY = this.myLevelShape.startingY;
			} else if (this.endTypeRB == 3) {
				if (this.myLevelShape.lean2 == 2) {
					theta =
								Math
								.atan(this.myLevelShape.dimB1
											/ this.myLevelShape.dimA2);
				} else {
					theta =
								Math
								.atan(this.myLevelShape.dimB0
											/ this.myLevelShape.dimA2);
				}
				if (this.myLevelShape.noSidesTop == 3) {
					this.startX =
								this.myLevelShape.startingX
								+ this.myLevelShape.widthPix
								- this.myLevelShape.dimA2
								+ this.myLevelShape.top3.partDimB
								/ Math.tan(theta);
					this.startY =
								this.myLevelShape.startingY
								+ this.myLevelShape.top3.partDimB;
				} else if (this.myLevelShape.noSidesTop == 2) {
					this.startX =
								this.myLevelShape.startingX
								+ this.myLevelShape.widthPix
								- this.myLevelShape.dimA2
								+ this.myLevelShape.top1.partDimB
								/ Math.tan(theta);
					this.startY =
								this.myLevelShape.startingY
								+ this.myLevelShape.top1.partDimB;
				}
			}
			
			theta =
						Math.atan(this.myLevelShape.dimA2
									/ this.myLevelShape.dimB1);
			if (this.myLevelShape.lean2 == 3) {
				theta =
							Math.atan(this.myLevelShape.dimA2
										/ this.myLevelShape.dimB0);
			}
			this.endX = this.myLevelShape.bX2;
			if (this.myLevelShape.lean2 == 2) {
				this.endY =
							this.myLevelShape.startingY
							+ this.myLevelShape.dimB1;
				if (this.endTypeLT == 3) {
					theta =
								Math
								.atan(this.myLevelShape.dimA2
											/ this.myLevelShape.dimB1);
					this.endY =
								this.myLevelShape.bY2
								+ this.myLevelShape.dimB1
								- this.myLevelShape.right.partDimB
								/ Math.tan(theta);
					this.endX =
								this.myLevelShape.bX2
								- this.myLevelShape.right.partDimB;
				}
			} else if (this.myLevelShape.lean2 == 3) {
				this.endY =
							this.myLevelShape.startingY
							+ this.myLevelShape.dimB0;
				if (this.endTypeLT == 3) {
					theta =
								Math
								.atan((this.myLevelShape.widthPix - this.myLevelShape.dimA1)
											/ this.myLevelShape.dimB0);
					this.endY =
								this.myLevelShape.bY2
								+ this.myLevelShape.dimB0
								- this.myLevelShape.right.partDimB
								/ Math.tan(theta);
					this.endX =
								this.myLevelShape.bX2
								- this.myLevelShape.right.partDimB;
				}
			}
			
		}
		
		if (this.myLevelShape.noSidesTop == 2) {
			this.startX =
						this.myLevelShape.startingX
						+ this.myLevelShape.dimA1;
			this.startY = this.myLevelShape.startingY;
		}
		if (this.myLevelShape.noSidesTop == 3) {
			this.startY = this.myLevelShape.top3.endY;
			this.startX = this.myLevelShape.top3.endX;
		}
		if (this.myLevelShape.shapeID == 704) {
			final double myTheta =
						Math.atan(this.myLevelShape.heightPix
									/ this.myLevelShape.dimA2);
			if (this.endTypeLT == 1 || this.endTypeLT == 0) {
				this.endX =
							this.myLevelShape.startingX
							+ this.myLevelShape.widthPix;
				this.endY =
							this.myLevelShape.startingY
							+ this.myLevelShape.heightPix;
			} else if (this.endTypeLT == 2) {
				this.endX =
							this.myLevelShape.startingX
							+ this.myLevelShape.widthPix;
				this.endY =
							this.myLevelShape.startingY
							+ this.myLevelShape.heightPix;
			} else if (this.endTypeLT == 3) {
				this.endX =
							this.myLevelShape.startingX
							+ this.myLevelShape.widthPix
							- this.myLevelShape.bot1.partDimB
							/ Math.tan(myTheta);
				this.endY =
							this.myLevelShape.startingY
							+ this.myLevelShape.heightPix
							- this.myLevelShape.bot1.partDimB;
			}
			if (this.endTypeLT == 1 || this.endTypeLT == 0) {
				this.startX =
							this.myLevelShape.startingX
							+ this.myLevelShape.dimA1;
				this.startY = this.myLevelShape.startingY;
			} else if (this.endTypeLT == 2) {
				this.startX =
							this.myLevelShape.startingX
							+ this.myLevelShape.dimA1;
				this.startY = this.myLevelShape.startingY;
			} else if (this.endTypeLT == 3) {
				this.startX =
							this.myLevelShape.startingX
							+ this.myLevelShape.dimA1;
				this.startY = this.myLevelShape.startingY;
			}
		}
		
		this.slope =
					(this.startY - this.endY) / (this.startX - this.endX);
		this.length =
					Math.sqrt(Math.pow((Math.max(
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
					this.myLevelShape.widthPix - this.myLevelShape.dimA1;
		this.bkgrdHeight = this.myLevelShape.heightPix;
		
	}
	
	public void lineStraight2BA_2() {
		
		this.partForm = 1;
		double theta = 0;
		// if (this.myLevelShape.shapeID == 704) {
		// theta = (double) Math
		// .atan(((this.myLevelShape.levelW -
		// this.myLevelShape.dimA0))
		// / this.myLevelShape.dimB1);
		// } else {
		theta =
					Math.atan(this.myLevelShape.dimA2
								/ this.myLevelShape.dimB1);
		// }
		double hypotenus = this.partDimB / Math.sin(theta);
		if (this.myLevelShape.noSidesTop == 2) {
			this.startYBA = this.myLevelShape.top1.endYBA;
			this.startXBA = this.myLevelShape.top1.endXBA;
		}
		
		if (this.myLevelShape.lean2 == 0
					|| this.myLevelShape.lean2 == 1) {
			
			if (this.endTypeRB == 1 || this.endTypeRB == 0) {
				// this.startXBA =
							// this.myLevelShape.startingX
				// + this.myLevelShape.dimA1
				// + this.partDimB
				// / (double)
				// Math.tan(theta);
				// this.startYBA =
				// this.myLevelShape.startingY
				// +
				// this.partDimB;
				this.startYBA = this.myLevelShape.top1.endYBA;
				this.startXBA = this.myLevelShape.top1.endXBA;
			} else if (this.endTypeRB == 2) {
				theta =
							Math
							.atan((this.myLevelShape.widthPix - this.myLevelShape.dimD2)
										/ this.myLevelShape.dimA1);
				
				this.startXBA = this.myLevelShape.top1.endX;// this.startX
				// -
				// this.partDimB/(double)
				// Math.tan(theta)
				// ;
				this.startYBA =
							this.myLevelShape.startingY + this.partDimB;
			} else if (this.endTypeRB == 3) {
				theta =
							Math.atan(this.myLevelShape.dimD2
										/ this.myLevelShape.dimA1);
				this.startXBA =
							this.startX
							- this.partDimB
							/ Math.tan(theta);
				this.startYBA =
							this.myLevelShape.startingY + this.partDimB;
			}
		} else if (this.myLevelShape.lean2 == 2
					|| this.myLevelShape.lean2 == 3) {
			theta = 0;
			if (this.myLevelShape.lean2 == 2) {
				theta =
							Math.atan(this.myLevelShape.dimB1
										/ this.myLevelShape.dimA2);
			} else {
				theta =
							Math.atan(this.myLevelShape.dimB0
										/ this.myLevelShape.dimA2);
			}
			if (this.endTypeRB == 1 || this.endTypeRB == 0) {
				if (this.myLevelShape.noSidesTop == 2) {
					this.startYBA = this.myLevelShape.top1.endYBA;
					this.startXBA = this.myLevelShape.top1.endXBA;
				} else if (this.myLevelShape.noSidesTop == 3) {
					this.startYBA = this.myLevelShape.top3.endYBA;
					this.startXBA = this.myLevelShape.top3.endXBA;
				}
			} else if (this.endTypeRB == 2) {
				this.startXBA =
							this.startX
							- this.partDimB
							/ Math.sin(theta);
				this.startYBA = this.myLevelShape.startingY;
			} else if (this.endTypeRB == 3) {
				if (this.myLevelShape.noSidesTop == 3) {
					this.startXBA =
								this.startX
								- this.partDimB
								/ Math.sin(theta);
					this.startYBA =
								this.myLevelShape.startingY
								+ this.myLevelShape.top3.partDimB;
				} else if (this.myLevelShape.noSidesTop == 2) {
					this.startXBA =
								this.startX
								- this.partDimB
								/ Math.sin(theta);
					this.startYBA =
								this.myLevelShape.startingY
								+ this.myLevelShape.top1.partDimB;
				}
			}
		}
		
		this.endYBA = this.startYBA;
		this.endXBA = this.endX - this.myLevelShape.right.partDimB;
		
		if (this.myLevelShape.lean2 == 2
					|| this.myLevelShape.lean2 == 3) {
			
			theta =
						Math.atan(this.myLevelShape.dimA2
									/ this.myLevelShape.dimB1);
			if (this.myLevelShape.lean2 == 3) {
				theta =
							Math.atan(this.myLevelShape.dimA2
										/ this.myLevelShape.dimB0);
			}
			if (this.endTypeLT == 1
						|| this.endTypeLT == 0
						|| this.endTypeLT == 3) {
				
				this.endYBA =
							this.endY
							- this.partDimB
							/ Math.tan(theta)
							+ this.myLevelShape.left.partDimB
							/ Math.sin(theta);
				
				if (this.myLevelShape.lean2 == 3) {
					this.endYBA =
								this.endY
								+ this.myLevelShape.left.partDimB
								/ Math.sin(theta)
								- this.partDimB
								/ Math.tan(theta);
				}
			} else {
				this.endYBA =
							this.myLevelShape.startingY
							+ this.myLevelShape.dimB1
							+ this.myLevelShape.left.partDimB
							/ Math.sin(theta);
				if (this.myLevelShape.lean2 == 3) {
					this.endYBA =
								this.myLevelShape.startingY
								+ this.myLevelShape.dimB0
								+ this.myLevelShape.left.partDimB
								/ Math.sin(theta);
				}
			}
		}
		
		if (this.myLevelShape.lean3 == 0
					|| this.myLevelShape.lean3 == 1) {
			if (this.endTypeLT == 1 || this.endTypeLT == 0) {
				this.endXBA =
							this.endX - this.myLevelShape.right.partDimB;
				
			} else {
				this.endXBA = this.endX;
			}
		} else {
			theta =
						Math.atan(this.myLevelShape.heightPix
									/ this.myLevelShape.dimC1);
			if (this.myLevelShape.lean3 == 3) {
				theta =
							Math
							.atan(this.myLevelShape.heightPix
										/ this.myLevelShape.dimC0);
			}
			if (this.endTypeLT == 1 || this.endTypeLT == 0) {
				this.endXBA =
							this.endX
							- this.partDimB
							/ Math.tan(theta)
							- this.myLevelShape.top1.partDimB
							/ Math.sin(theta);
				
			} else if (this.endTypeLT == 2) {
				this.endXBA =
							this.endX
							- this.partDimB
							/ Math.tan(theta);
			} else {
				this.endXBA =
							this.endX
							- this.partDimB
							/ Math.tan(theta);
			}
			
		}
		if (this.myLevelShape.rightShape == 0) {
			this.endYBA = this.myLevelShape.bot1.startYBA;
			this.endXBA = this.myLevelShape.bot1.startXBA;
		}
		
		if (this.myLevelShape.lean3 == 3
					|| this.myLevelShape.lean3 == 1 && this.myLevelShape.lean2 != 3) {
			double theta1 =
						Math.atan(this.myLevelShape.dimC1
									/ this.myLevelShape.dimB2);
			if (this.myLevelShape.lean3 == 3) {
				theta1 =
							Math.atan(this.myLevelShape.dimC0
										/ this.myLevelShape.dimB2);
			}
			final double theta2 =
						Math.atan(this.myLevelShape.dimA2
									/ this.myLevelShape.dimB1);
			final double myTheta =
						Math.toRadians(180) - theta1 - theta2;
			hypotenus =
						this.partDimB / Math.sin(myTheta / 2);
			final double baseY =
						hypotenus
						* Math.cos(myTheta / 2 + theta1);
			final double baseX =
						hypotenus
						* Math.sin(myTheta / 2 + theta1);
			this.endXBA = this.endX - baseX;// base;
			
			this.endYBA = this.endY + baseY;
		}
		if (this.myLevelShape.top3.posInUse
					&& this.myLevelShape.noSidesRight == 1
					&& this.myLevelShape.lean2 == 3) {
			
			if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
				this.endXBA =
				this.endX - this.myLevelShape.left.partDimB;
			} else {// Straight Cut
				
				this.endXBA = this.endX;
			}
			
			theta =
						Math.atan(this.myLevelShape.dimA2
									/ this.myLevelShape.dimB0);
			hypotenus = this.partDimB / Math.sin(theta);
			final double yExtensionLeft =
						this.myLevelShape.right.partDimB
						/ Math.tan(theta);
			if (this.endTypeRB == 1
						|| this.endTypeRB == 0
						|| this.endTypeRB == 3) {
				this.endYBA = this.endY + hypotenus - yExtensionLeft;
			} else {
				this.endYBA = this.endY + hypotenus;
			}
		} else if (this.myLevelShape.noSidesTop == 3) {
			this.startYBA = this.myLevelShape.top3.endYBA;
			this.startXBA = this.myLevelShape.top3.endXBA;
		}
		if (this.myLevelShape.shapeID == 704) {
			final double myTheta =
						Math.atan(this.myLevelShape.heightPix
									/ this.myLevelShape.dimA2);
			if (this.endTypeRB == 1 || this.endTypeRB == 0) {
				this.startXBA = this.myLevelShape.top1.endXBA;
				this.startYBA = this.myLevelShape.top1.endYBA;
			} else if (this.endTypeRB == 2) {
				this.startXBA = this.myLevelShape.top1.endXBA;
				this.startYBA = this.myLevelShape.top1.endYBA;
			} else if (this.endTypeRB == 3) {
				this.startXBA = this.myLevelShape.top1.endXBA;
				this.startYBA = this.myLevelShape.top1.endYBA;
			}
			
			if (this.endTypeLT == 1 || this.endTypeLT == 0) {
				this.endXBA =
							this.endX
							- this.myLevelShape.bot1.partDimB
							/ Math.sin(myTheta)
							- this.partDimB
							/ Math.tan(myTheta);
				this.endYBA =
							this.endY - this.myLevelShape.bot1.partDimB;
			} else if (this.endTypeLT == 2) {
				this.endXBA =
							this.endX
							- this.partDimB
							/ Math.sin(myTheta);
				this.endYBA = this.endY;
			} else if (this.endTypeLT == 3) {
				this.endXBA =
							this.endX
							- this.partDimB
							/ Math.sin(myTheta);
				this.endYBA = this.endY;
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
					this.myLevelShape.widthPix - this.myLevelShape.dimA1;
		this.bkgrdHeightBA = this.myLevelShape.heightPix;
		
	}
	
	public void lineStraight3A_2() {
		
		this.partForm = 1;
		double theta = 0;
		
		theta =
					Math
					.atan((this.myLevelShape.widthPix - this.myLevelShape.dimA2)
								/ this.myLevelShape.dimB1);
		
		double hypotenus =
					(this.partDimB + this.partDimA)
					/ Math.sin(theta);
		
		this.startYA = this.myLevelShape.top1.endYA;
		this.startXA = this.myLevelShape.top1.endXA;
		this.endYA = this.startYA;
		this.endXA =
					this.endX
					- this.myLevelShape.right.partDimB
					- this.myLevelShape.right.partDimA;
		if (this.myLevelShape.noSidesTop == 2) {
			this.startYA = this.myLevelShape.top1.endYA;
			this.startXA = this.myLevelShape.top1.endXA;
		} else if (this.myLevelShape.noSidesTop == 3) {
			this.startYA = this.myLevelShape.top3.endYA;
			this.startXA = this.myLevelShape.top3.endXA;
		}
		if (this.myLevelShape.lean2 == 0
					|| this.myLevelShape.lean2 == 1) {
			
			if (this.endTypeRB == 1 || this.endTypeRB == 0) {
				this.startYA = this.myLevelShape.top1.endYA;
				this.startXA = this.myLevelShape.top1.endXA;
			} else if (this.endTypeRB == 2) {
				theta =
							Math.atan(this.myLevelShape.dimD2
										/ this.myLevelShape.dimA1);
				this.stopAsX = this.myLevelShape.top1.endXA;
				this.stopAsY = this.myLevelShape.top1.endYA;
				this.startXA =
							this.stopAsX
							- this.partDimA
							/ Math.tan(theta);
				this.startYA =
							this.myLevelShape.startingY
							+ this.partDimB
							+ this.partDimA;
				
			} else if (this.endTypeRB == 3) {
				theta =
							Math.atan(this.myLevelShape.dimD2
										/ this.myLevelShape.dimA1);
				this.startXA =
							this.startX
							- (this.partDimB + this.partDimA)
							/ Math.tan(theta);
				this.startYA =
							this.myLevelShape.startingY
							+ this.partDimB
							+ this.partDimA;
			}
		} else if (this.myLevelShape.lean2 == 2
					|| this.myLevelShape.lean2 == 3) {
			theta = 0;
			if (this.myLevelShape.lean2 == 2) {
				theta =
							Math.atan(this.myLevelShape.dimB1
										/ this.myLevelShape.dimA2);
			} else {
				theta =
							Math.atan(this.myLevelShape.dimB0
										/ this.myLevelShape.dimA2);
			}
			if (this.endTypeRB == 1 || this.endTypeRB == 0) {
				if (this.myLevelShape.noSidesTop == 2) {
					this.startYA = this.myLevelShape.top1.endYA;
					this.startXA = this.myLevelShape.top1.endXA;
				} else if (this.myLevelShape.noSidesTop == 3) {
					this.startYA = this.myLevelShape.top3.endYA;
					this.startXA = this.myLevelShape.top3.endXA;
				}
			} else if (this.endTypeRB == 2) {
				this.startXA =
							this.startX
							- (this.partDimB + this.partDimA)
							/ Math.sin(theta)
							+ (this.myLevelShape.top1.partDimB + this.myLevelShape.top1.partDimA)
							/ Math.tan(theta);
				this.startYA =
							this.myLevelShape.startingY
							+ this.myLevelShape.top1.partDimB
							+ this.myLevelShape.top1.partDimA;
				this.stopAsY = this.startYA;
				this.stopAsX =
							this.startXA
							+ this.partDimA
							/ Math.sin(theta);
			} else if (this.endTypeRB == 3) {
				if (this.myLevelShape.noSidesTop == 3) {
					this.startXA =
								this.startXBA
								- this.partDimA
								/ Math.sin(theta);
					this.startYA =
								this.myLevelShape.startingY
								+ this.myLevelShape.top3.partDimB;
				} else if (this.myLevelShape.noSidesTop == 2) {
					this.startXA =
								this.startXBA
								- this.partDimA
								/ Math.sin(theta);
					this.startYA =
								this.myLevelShape.startingY
								+ this.myLevelShape.top1.partDimB;
				}
			}
		}
		if (this.myLevelShape.lean2 == 2
					|| this.myLevelShape.lean2 == 3) {
			
			theta =
						Math.atan(this.myLevelShape.dimA2
									/ this.myLevelShape.dimB1);
			if (this.myLevelShape.lean2 == 3) {
				theta =
							Math.atan(this.myLevelShape.dimA2
										/ this.myLevelShape.dimB0);
			}
			if (this.endTypeLT == 1 || this.endTypeLT == 0) {
				
				this.endYA =
							this.endY
							+ (this.myLevelShape.right.partDimB + this.myLevelShape.right.partDimA)
							/ Math.sin(theta)
							- (this.partDimB + this.partDimA)
							/ Math.tan(theta);
				
				if (this.myLevelShape.lean2 == 3) {
					this.endYA =
								this.endY
								+ (this.myLevelShape.right.partDimB + this.myLevelShape.right.partDimA)
								/ Math.sin(theta)
								- (this.partDimB + this.partDimA)
								/ Math.tan(theta);
					
				}
			} else {
				this.endXA = this.endX;
				this.endYA =
							this.endY
							+ (this.partDimB + this.partDimA)
							/ Math.sin(theta);
				
				this.stopAeY =
							this.endYA
							- this.partDimA
							/ Math.sin(theta);
				
			}
			
		} else {
			if (this.myLevelShape.lean3 == 0
						|| this.myLevelShape.lean3 == 1) {
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endYA = this.startYA;
					this.endXA =
								this.endX
								- this.myLevelShape.right.partDimB
								- this.myLevelShape.right.partDimA;
				} else if (this.endTypeLT == 2) {
					this.endYA = this.startYA;
					this.endXA =
								this.endX
								- this.myLevelShape.right.partDimB
								- this.myLevelShape.right.partDimA;
					this.stopAeX = this.endXA;
					this.stopAeY = this.endY - this.partDimA;
				} else if (this.endTypeLT == 3) {
					this.endYA = this.startYA;
					this.endXA = this.endX;
				}
			} else if (this.myLevelShape.lean3 == 2
						|| this.myLevelShape.lean3 == 3 && this.myLevelShape.noSidesTop != 3) {
				theta =
							Math
							.atan(this.myLevelShape.heightPix
										/ this.myLevelShape.dimC1);
				if (this.myLevelShape.lean3 == 3) {
					theta =
								Math
								.atan(this.myLevelShape.heightPix
											/ this.myLevelShape.dimC0);
				}
				if (this.endTypeLT == 1 || this.endTypeLT == 0) {
					this.endXA =
								this.endX
								- (this.partDimB + this.partDimA)
								/ Math.tan(theta)
								- (this.myLevelShape.top1.partDimB + this.myLevelShape.right.partDimA)
								/ Math.sin(theta);
					
				} else if (this.endTypeLT == 2) {
					this.endXA =
								this.endX
								- (this.partDimB + this.partDimA)
								/ Math.tan(theta);
				} else {
					this.endXA =
								this.endX
								- (this.partDimB + this.partDimA)
								/ Math.tan(theta);
				}
			}
		}
		
		if (this.myLevelShape.rightShape == 0) {
			this.endYA = this.myLevelShape.bot1.startYA;
			this.endXA = this.myLevelShape.bot1.startXA;
		}
		if (this.myLevelShape.lean3 == 3
					|| this.myLevelShape.lean3 == 1 && this.myLevelShape.lean2 == 2) {
			double theta1 =
						Math.atan(this.myLevelShape.dimC1
									/ this.myLevelShape.dimB2);
			if (this.myLevelShape.lean3 == 3) {
				theta1 =
							Math.atan(this.myLevelShape.dimC0
										/ this.myLevelShape.dimB2);
			}
			final double theta2 =
						Math.atan(this.myLevelShape.dimA2
									/ this.myLevelShape.dimB1);
			final double myTheta =
						Math.toRadians(180) - theta1 - theta2;
			hypotenus =
						(this.partDimB + this.partDimA)
						/ Math.sin(myTheta / 2);
			final double baseY =
						hypotenus
						* Math.cos(myTheta / 2 + theta1);
			final double baseX =
						hypotenus
						* Math.sin(myTheta / 2 + theta1);
			this.endXA = this.endX - baseX;// base;
			
			this.endYA = this.endY + baseY;
		}
		if (this.myLevelShape.top3.posInUse
					&& this.myLevelShape.noSidesRight == 1
					&& this.myLevelShape.lean2 == 3) {
			if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
				this.endXA =
				this.endX
				- this.myLevelShape.right.partDimB
				- this.myLevelShape.right.partDimA;
			} else {// Straight Cut
				
				this.endXA = this.endX;
			}
			theta =
						Math.atan(this.myLevelShape.dimA2
									/ this.myLevelShape.dimB0);
			hypotenus =
						(this.partDimB + this.partDimA)
						/ Math.sin(theta);
			final double yExtensionLeft =
						(this.myLevelShape.top1.partDimB + this.myLevelShape.right.partDimA)
						/ Math.tan(theta);
			if (this.endTypeRB == 1
						|| this.endTypeRB == 0
						|| this.endTypeRB == 3) {
				this.endYA = this.endY + hypotenus - yExtensionLeft;
			} else {
				this.endYA = this.endY + hypotenus;
			}
		} else if (this.myLevelShape.noSidesTop == 3) {
			this.startYA = this.myLevelShape.top3.endYA;
			this.startXA = this.myLevelShape.top3.endXA;
		}
		if (this.myLevelShape.shapeID == 704) {
			final double myTheta =
						Math.atan(this.myLevelShape.heightPix
									/ this.myLevelShape.dimA2);
			if (this.endTypeRB == 1 || this.endTypeRB == 0) {
				this.startXA = this.myLevelShape.top1.endXA;
				this.startYA = this.myLevelShape.top1.endYA;
			} else if (this.endTypeRB == 2) {
				this.startXA = this.myLevelShape.top1.endXA;
				this.startYA = this.myLevelShape.top1.endYA;
			} else if (this.endTypeRB == 3) {
				this.startXA = this.myLevelShape.top1.endXA;
				this.startYA = this.myLevelShape.top1.endYA;
			}
			
			if (this.endTypeLT == 1 || this.endTypeLT == 0) {
				this.endXA =
							this.endX
							- (this.myLevelShape.top1.partDimB + this.myLevelShape.right.partDimA)
							/ Math.tan(myTheta)
							- (this.partDimB + this.partDimA)
							/ Math.sin(myTheta);
				;
				this.endYA =
							this.endY
							- (this.myLevelShape.top1.partDimB + this.myLevelShape.right.partDimA);
			} else if (this.endTypeLT == 2) {
				this.endXA =
							this.endX
							- (this.myLevelShape.top1.partDimB + this.myLevelShape.right.partDimA)
							/ Math.tan(myTheta)
							- (this.partDimB + this.partDimA)
							/ Math.sin(myTheta);
				;
				this.endYA =
							this.endY - (this.partDimB + this.partDimA);
				this.stopAeX =
							this.endXA
							+ this.partDimA
							/ Math.sin(myTheta);
				this.stopAeY = this.endYA;
			} else if (this.endTypeLT == 3) {
				this.endXA =
							this.endX
							- (this.partDimB + this.partDimA)
							/ Math.sin(myTheta);
				this.endYA = this.endY;
			}
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
	
	public void arcBegin901B() {
		
		this.partForm = 2;
		
		if (!this.wire) {
			this.startX = this.startingX + this.myLevelShape.dimA1;
			
			this.startY = this.startingY; // or
			// dimD2
			
			this.endX = this.startX + this.myLevelShape.dimA2;
			
			this.endY = this.startY + this.myLevelShape.dimB1;
			Math.sqrt(Math.pow(this.myLevelShape.dimB1, 2)
						+ Math.pow(this.myLevelShape.dimA2, 2));
			this.radius1 = this.myLevelShape.widthPix;
			if (this.myLevelShape.shapeID == 450
						|| this.myLevelShape.shapeID == 453) {
				this.radius1 = this.myLevelShape.widthPix;
			}
			if (this.myLevelShape.shapeID == 454
						|| this.myLevelShape.shapeID == 455) {
				this.radius1 = 4 * this.myLevelShape.widthPix / 5;
			}
			if (this.myLevelShape.shapeID == 456
						|| this.myLevelShape.shapeID == 457) {
				this.radius1 = 3.25f * this.myLevelShape.widthPix / 5;
			}
			if (this.myLevelShape.shapeID == 458
						|| this.myLevelShape.shapeID == 459) {
				this.radius1 = 5 * this.myLevelShape.widthPix / 4;
			}
			if (this.myLevelShape.shapeID == 460
						|| this.myLevelShape.shapeID == 461) {
				this.radius1 = 2 * this.myLevelShape.widthPix;
			}
			
			this.radius2 = 0;
			
			this.x1 = this.endX - this.radius1;
			this.y1 =
						this.y1 =
						this.startingY + this.myLevelShape.dimD2;
			
			this.x2 = this.endX;// startingX+w/2;
			this.y2 = this.endY;// startY;//
			// -(t1R1-dimB1);
			final double theta =
						Math.acos((this.startX - this.x1)
									/ this.radius1);
			final double theta2 =
						Math.acos((this.endX - this.x1)
									/ this.radius1);
			this.radianCentralAngle = theta - theta2;
			
			this.centralAngle =
						Math.toDegrees(this.radianCentralAngle); // in
						
			double radiansStart =
						Math.atan((this.x2 - this.x1)
									/ (this.y2 - this.y1));
			radiansStart = Math.toDegrees(radiansStart);
			
			this.startAngle = theta2;// / 2;//
			// centralAnglet1;//radiansStart;//radiansStart;
			this.endAngle = this.centralAngle;
			
			this.bkgrdWidth = 2 * this.radius1;
			this.bkgrdHeight = 2 * this.radius1;// this.myLevelShape.dimD2;
			
			this.focal1X = this.endX;// +
			// this.myLevelShape.wT / 2;
			this.focal1Y = this.endY + this.radius1;
			
			this.focal2X = this.focal1X;
			this.focal2Y = this.focal1Y;
			
			this.bkgrdStartX = this.x1 - this.radius1;// focal1X
			// - radius1;
			this.bkgrdStartY = this.y1 - this.radius1;
		} else {
			this.startX = this.myLevelShape.startingX;
			this.startY =
						this.myLevelShape.startingY
						+ this.myLevelShape.dimD2; // or
						this.endX = this.startX + this.myLevelShape.widthPix;
						this.endY = this.myLevelShape.startingY;// +
						this.radius1 = this.myLevelShape.radius1;
						this.radius2 = this.myLevelShape.radius2;
						this.x1 = this.myLevelShape.centerPointX;
						this.y1 = this.myLevelShape.centerPointY;
						this.x2 = this.myLevelShape.centerPointX2;
						this.y2 = this.myLevelShape.centerPointY2;
						this.centralAngle = this.myLevelShape.centralAngle; // in
						// degrees
						this.startAngle = this.myLevelShape.startAngle;// (180
						// -
						this.endAngle = this.myLevelShape.endAngle;
						this.bkgrdWidth = 2 * this.radius1;
						this.bkgrdHeight = 2 * this.radius1;
						this.focal1X = this.x1;
						this.focal1Y = this.y1;
						this.focal2X = this.x2;
						this.focal2Y = this.y2;
						this.bkgrdStartX = this.myLevelShape.bkgrdStartX;
						this.bkgrdStartY = this.myLevelShape.bkgrdStartY;
		}
		this.rrSlope = (this.x2 - this.x1) / (this.y2 - this.y1);
		this.rrAngle =
					Math.abs(Math.atan(1 / this.rrSlope));
		this.rlSlope =
					(this.startingX - this.x1)
					/ (this.startingY + this.myLevelShape.dimD2 - this.y1);
		this.rlAngle = Math.abs(Math.atan(1 / this.rlSlope));
		this.length =
					2
					* Math.PI
					* this.radius1
					* this.centralAngle
					/ 360;// 2PIr*CentralAngle/360
					this.radius2 = 0;
	}
	
	public void arcBegin902BA() { // int =1 Arc normal, 2
		
		// start at 90, 3 end
		// at ninety
		this.startXBA = this.startX;
		this.startYBA = this.myLevelShape.top1.endYBA;
		this.endXBA = this.endX - this.partDimB;
		this.endYBA = this.endY;
		this.radius1BA = this.myLevelShape.top1.radius1BA;
		// h/ 2+ (((double) Math.pow(widthofArc * 2,
		// 2)) / (8
		// * h));
		this.radius2 = 0;
		this.x1BA = this.x1;
		this.y1BA = this.y1;
		this.x2BA = this.endXBA;
		this.y2BA = this.endYBA;
		Math.acos((this.startX - this.x1) / this.radius1BA);
		Math.acos((this.endXBA - this.x1BA) / this.radius1BA);
		this.centralAngleBA = this.myLevelShape.top1.centralAngleBA;
		
		this.startAngleBA = 0;
		this.endAngleBA = this.centralAngleBA;
		
		this.bkgrdWidthBA = 2 * this.radius1BA;
		this.bkgrdHeightBA = 2 * this.radius1BA;
		
		this.bkgrdStartXBA = this.x1BA - this.radius1BA;
		this.bkgrdStartYBA = this.y1BA - this.radius1BA;
	}
	
	public void arcBegin903A() { // int =1 Arc normal, 2
		
		// start at 90, 3 end
		// at ninety
		this.startXA = this.startX;
		this.startYA = this.myLevelShape.top1.endYA;
		this.endXA = this.endX - this.partDimB - this.partDimA;
		this.endYA = this.endY;
		this.radius1A = this.myLevelShape.top1.radius1A;
		// h/ 2+ (((double) Math.pow(widthofArc * 2,
		// 2)) / (8
		// * h));
		this.radius2 = 0;
		this.x1A = this.x1;// this.startXBA +
		// radius1BA;
		this.y1A = this.y1;// this.startingY +
		// this.myLevelShape.dimD2;// -
		this.x2A = this.endXA;// startingX+w/2;
		this.y2A = this.endYA;
		Math.acos((this.startX - this.x1) / this.radius1A);
		Math.acos((this.endXA - this.x1A) / this.radius1A);
		this.centralAngleA = this.myLevelShape.top1.centralAngleA;// .toDegrees(theta);
		// // in
		this.startAngleA = 0;// 180-centralAngleBA;//
		// / 2;//
		// centralAnglet1;//radiansStart;//radiansStart;
		this.endAngleA = this.centralAngleA;
		this.bkgrdWidthA = 2 * this.radius1A;
		this.bkgrdHeightA = 2 * this.radius1A;// this.myLevelShape.dimD2;
		this.bkgrdStartXA = this.x1A - this.radius1A;// focal1X
		// - radius1;
		this.bkgrdStartYA = this.y1A - this.radius1A;
		this.lengthA =
					2
					* Math.PI
					* this.radius1A
					* this.centralAngleA
					/ 360;
		this.radius2A = 0;
		this.ltAngle =
					Math.atan(Math.abs((this.endXA - this.endX))
								/ Math.abs((this.endYA - this.endY)));
		this.rbAngle =
					Math.atan(Math
								.abs((this.startX - this.startXA))
								/ Math.abs((this.startY - this.startYA)));
		
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

    public Top2Object clone() {
        try {

            Top2Object newObject = (Top2Object)super.clone();

            return newObject;

        } catch (CloneNotSupportedException e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }
	
}

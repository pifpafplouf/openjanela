/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Operations;


import java.awt.geom.Arc2D;

import Model.ProfileParts.Profiles;


public class CalculateMullionV {
	
	AddMullionV addMullionV;
	
	double myThetaBot = 0;
	
	double myThetaBot2 = 0;
	
	double myThetaBot3 = 0;
	
	double myThetaBotA = 0;
	
	double myThetaBotC = 0;
	
	double baseRTBot = 0;
	
	double baseLBBot = 0;
	
	double baseRTBotc = 0;
	
	double baseLBBota = 0;
	
	double baseCenterBot = 0;
	
	double newYBotRT = 0;
	
	double newYBotLB = 0;
	
	double newYBotRTc = 0;
	
	double newYBotLBa = 0;
	
	double newYBotCenter = 0;
	
	double botXRT = 0;
	
	double botXRTc = 0;
	
	double botXLB = 0;
	
	double botXLBa = 0;
	
	double botXCenter = 0;
	
	boolean setYs = false;
	
	boolean setYe = false;
	
	EllipseLineIntersections arcX = new EllipseLineIntersections();
	
	public CalculateMullionV(AddMullionV parent) {
		addMullionV = parent;
	}
	
	public void setInitValues(final Profiles myMullion) {
		
		botXRT = myMullion.x3;
		botXRTc = myMullion.x3cl;
		botXLB = myMullion.x4;
		botXLBa = myMullion.x4al;
		botXCenter = myMullion.centerXe;
		
		newYBotRT = addMullionV.vcEndY;
		newYBotLB = addMullionV.vcEndY;
		newYBotRTc = addMullionV.vcEndY;
		newYBotLBa = addMullionV.vcEndY;
		newYBotCenter = addMullionV.vcEndY;
		
		setYs = false;
		setYe = false;
	}
	
	public Profiles calculateCoord(final Profiles myMullion) {
		
		this.setInitValues(myMullion);
		
		if (myMullion.startPos == 1 || myMullion.startPos > 1) {
			
			double hypCenter = addMullionV.dimTM;
			
			hypCenter = getHypCenterStart(hypCenter);
			
			if (myMullion.endTypeLT == 3 || myMullion.cOrM == 1)
			{
				
				doStartEndType3(myMullion);
				
			} else if (myMullion.endTypeLT == 2) {
				
				doStartEndType2(myMullion);
				
			} else {
				
				doStartEndType1(myMullion, hypCenter);
				
			}
			
		}
		
		// }
		// if ((addMullionV.limitStart.partForm == 2)
		// && (myMullion.startPos == 1))
		// {
		//
		// this
		// .calculateCoordinArchIIT(myMullion);
		// setYs = true;
		// }// top =1 & Radius > 0 && partform == 2
		
		// if ((addMullionV.myParentBO.noSidesTop == 1)
		// && (myMullion.startPos == 1)
		// && (addMullionV.limitStart.partForm == 3))
		// {
		//
		// this
		// .getCCoordinatesForEllipse(myMullion);
		// setYs = false;
		// }
		
		this.botCoordsii(myMullion);
		
		// //////////////////////////////////////////////////////
		
		if (myMullion.cOrM == 2) {
			myMullion.glazedInOut();
		} else if (myMullion.cOrM == 1) {
			myMullion.x1a = addMullionV.newStartingXLBa;
			myMullion.x2a = addMullionV.newStartingXRTc;
			myMullion.x1b = addMullionV.newStartingXLB;
			myMullion.x2b = addMullionV.newStartingXRT;
			myMullion.xcs = addMullionV.newStartingXCenter;
			myMullion.x4a = this.botXLBa;
			myMullion.x3a = this.botXRTc;
			myMullion.x4b = this.botXLB;
			myMullion.x3b = this.botXRT;
			myMullion.xce = this.botXCenter;
		}
		
		return myMullion;
	}
	
	public double getHypCenterStart(double hypCenter) {
		
		if (addMullionV.newAlpha > 0) {
			hypCenter =
						addMullionV.dimTM / Math
						.sin(addMullionV.newAlpha);
		} else if (addMullionV.thetaOffset > 0) {
			hypCenter =
						addMullionV.dimTM / Math
						.sin(addMullionV.thetaOffset);
		}
		return hypCenter;
	}
	
	public void doStartEndType1(
				final Profiles myMullion,
				final double hypCenter) {
		
		if (myMullion.limitStartY1a.cOrM == 0) {
			doStartEndType1P(myMullion, hypCenter);
		} else {
			doStartEndType1MC(myMullion, hypCenter);
		}
		
	}
	
	public void doStartEndType2(final Profiles myMullion) {
		
		if (myMullion.limitStartY1a.cOrM == 0) {
			doStartEndType2P(myMullion);
		} else {
			doStartEndType2MC(myMullion);
		}
		
	}
	
	public void doStartEndType3(final Profiles myMullion) {
		
		if (myMullion.limitStartY1a.cOrM == 0) {
			doStartEndType3P(myMullion);
		} else {
			doStartEndType3MC(myMullion);
		}
	}
	
	public void doStartEndType1P(
				final Profiles myMullion,
				final double hypCenter) {
		
		if (myMullion.limitStartY2c.partForm == 1) {
			addMullionV.newStartingYRTc =
						myMullion.y2a =
						myMullion.y2a3 =
						myMullion.y2cl =
						addMullionV
						.intersectY(
									//
									myMullion.x2cl, //
									addMullionV.newStartingYRTc, //
									myMullion.x2cl, //
									newYBotRTc, //
									
									myMullion.limitStartY2c.startXA, //
									myMullion.limitStartY2c.startYA, //
									myMullion.limitStartY2c.endXA, //
									myMullion.limitStartY2c.endYA//
									);
		} else if (myMullion.limitStartY2c.partForm == 2) {
			
			myMullion.y2cl =
						myMullion.y2a3 =
						myMullion.y2a =
						myMullion.y2cl =
						arcX
						.getYusingX(
									myMullion.x2cl,
									myMullion.y2cl,
									myMullion.x3cl,
									myMullion.y3cl,
									myMullion.limitStartY2c.radius1A,
									myMullion.limitStartY2c.x1,
									myMullion.limitStartY2c.y1,
									false);
			
		} else if (myMullion.limitStartY2c.partForm == 3) {
			
		}
		if (myMullion.limitStartY1a.partForm == 1) {
			addMullionV.newStartingYLBa =
						myMullion.y1a =
						myMullion.y1a3 =
						myMullion.y1al =
						addMullionV
						.intersectY(
									//
									myMullion.x1al, //
									addMullionV.newStartingYLBa, //
									myMullion.x1al, //
									newYBotLBa, //
									myMullion.limitStartY1a.startXA, //
									myMullion.limitStartY1a.startYA, //
									myMullion.limitStartY1a.endXA, //
									myMullion.limitStartY1a.endYA//
									);
		}
		if (myMullion.limitStartY1a.partForm == 2) {
			myMullion.y1al =
						myMullion.y1a3 =
						myMullion.y1a =
						myMullion.y1al =
						arcX
						.getYusingX(
									myMullion.x1al,
									myMullion.y1al,
									myMullion.x1al,
									myMullion.y1al,
									myMullion.limitStartY1a.radius1A,
									myMullion.limitStartY1a.x1,
									myMullion.limitStartY1a.y1,
									false);
		}
		if (myMullion.limitStartY1a.partForm == 3) {
			
		}
		if (myMullion.limitStartYC.partForm == 1) {
			addMullionV.newStartingYCenter =
						myMullion.ycs =
						myMullion.centerYs =
						addMullionV
						.intersectY(
									//
									myMullion.centerXs, //
									addMullionV.newStartingYCenter, //
									myMullion.centerXs, //
									newYBotCenter, //
									myMullion.limitStartYC.startXBA, //
									myMullion.limitStartYC.startYBA
									- hypCenter, //
									myMullion.limitStartYC.endXBA, //
									myMullion.limitStartYC.endYBA
									- hypCenter//
									);
		}
		if (myMullion.limitStartYC.partForm == 2) {
			addMullionV.newStartingYCenter =
						myMullion.ycs =
						myMullion.centerYs =
						arcX
						.getYusingX(
									myMullion.centerXs,
									addMullionV.newStartingYCenter,
									myMullion.centerXs,
									newYBotCenter,
									myMullion.limitStartYC.radius1BA
									- -hypCenter,
									myMullion.limitStartYC.x1,
									myMullion.limitStartYC.y1,
									false);
		}
		if (myMullion.limitStartYC.partForm == 3) {
			
		}
		
		addMullionV.newStartingYRT =
					myMullion.y2 =
					myMullion.y2b = addMullionV.intersectY(
								//
								myMullion.x2, //
								addMullionV.newStartingYRT, //
								myMullion.x3, //
								addMullionV.vcEndY, //
								myMullion.centerXs, //
								myMullion.ycs, //
								myMullion.x2a, //
								myMullion.y2a//
								);
		
		addMullionV.newStartingYLB =
					myMullion.y1 =
					myMullion.y1b =
					addMullionV.intersectY(myMullion.x1, //
								addMullionV.newStartingXLB, //
								myMullion.x4, //
								this.newYBotLB, //
								myMullion.centerXs, //
								myMullion.ycs, //
								myMullion.x1a, //
								myMullion.y1a//
								);
	}
	
	public void doStartEndType2P(final Profiles myMullion) {
		
		if (myMullion.limitStartY2c.partForm == 1) {
			addMullionV.newStartingYRTc =
						myMullion.y2a3 =
						myMullion.y2a =
						myMullion.y2cl =
						addMullionV
						.intersectY(
									myMullion.x2cl, //
									addMullionV.newStartingYRTc, //
									myMullion.x2cl, //
									newYBotRTc, //
									myMullion.limitStartY2c.startXC, //
									myMullion.limitStartY2c.startYC, //
									myMullion.limitStartY2c.endXC, //
									myMullion.limitStartY2c.endYC//
									);
		}
		if (myMullion.limitStartY2c.partForm == 2) {
			addMullionV.newStartingYRTc =
						myMullion.y2cl =
						myMullion.y2a3 =
						myMullion.y2a =
						arcX
						.getYusingX(
									myMullion.x2cl,
									myMullion.y2cl,
									myMullion.x3cl,
									myMullion.y3cl,
									myMullion.limitStartY2c.radius1,
									myMullion.limitStartY2c.x1,
									myMullion.limitStartY2c.y1,
									false);
			
		}
		if (myMullion.limitStartY2c.partForm == 3) {
			
		}
		if (myMullion.limitStartY1a.partForm == 1) {
			addMullionV.newStartingYLBa =
						myMullion.y1a =
						myMullion.y1a3 =
						myMullion.y1al =
						addMullionV
						.intersectY(
									//
									myMullion.x1al, //
									addMullionV.newStartingYLBa, //
									myMullion.x1al, //
									newYBotLBa, //
									myMullion.limitStartY1a.startXC, //
									myMullion.limitStartY1a.startYC, //
									myMullion.limitStartY1a.endXC, //
									myMullion.limitStartY1a.endYC//
									);
		} else if (myMullion.limitStartY1a.partForm == 2) {
			addMullionV.newStartingYLBa =
						myMullion.y1a =
						myMullion.y1a3 =
						myMullion.y1al =
						arcX
						.getYusingX(
									myMullion.x1al,
									myMullion.y1al,
									myMullion.x1al,
									myMullion.y1al,
									myMullion.limitStartY1a.radius1,
									myMullion.limitStartY1a.x1,
									myMullion.limitStartY1a.y1,
									false);
		} else if (myMullion.limitStartY1a.partForm == 3) {
			
		}
		
		if (myMullion.limitStartY2.partForm == 1) {
			addMullionV.newStartingYRT =
						myMullion.y2 =
						myMullion.y2b = addMullionV.intersectY(
									//
									myMullion.x2, //
									addMullionV.newStartingYRT, //
									myMullion.x2, //
									newYBotRT, //
									myMullion.limitStartY2.startXC, //
									myMullion.limitStartY2.startYC, //
									myMullion.limitStartY2.endXC, //
									myMullion.limitStartY2.endYC//
									);
		} else if (myMullion.limitStartY2.partForm == 2) {
			addMullionV.newStartingYRT =
						myMullion.y2 =
						myMullion.y2b =
						arcX
						.getYusingX(myMullion.x2, //
									addMullionV.newStartingYRT, //
									myMullion.x2, //
									newYBotRT, //
									myMullion.limitStartY2.radius1,
									myMullion.limitStartY2.x1,
									myMullion.limitStartY2.y1,
									false);
		} else if (myMullion.limitStartY2.partForm == 3) {
			
		}
		
		if (myMullion.limitStartY1.partForm == 1) {
			
			addMullionV.newStartingYLB =
						myMullion.y1 =
						myMullion.y1b = addMullionV.intersectY(
									//
									myMullion.x1, //
									addMullionV.newStartingYLB, //
									myMullion.x1, //
									newYBotLB, //
									myMullion.limitStartY1.startXC, //
									myMullion.limitStartY1.startYC, //
									myMullion.limitStartY1.endXC, //
									myMullion.limitStartY1.endYC//
									);
		} else if (myMullion.limitStartY1.partForm == 2) {
			addMullionV.newStartingYLB =
						myMullion.y1 =
						myMullion.y1b =
						arcX
						.getYusingX(myMullion.x1, //
									addMullionV.newStartingYLB, //
									myMullion.x1, //
									newYBotLB, //
									myMullion.limitStartY1.radius1,
									myMullion.limitStartY1.x1,
									myMullion.limitStartY1.y1,
									false);
		} else if (myMullion.limitStartY1.partForm == 3) {
			
		}
		
		if (myMullion.limitStartYC.partForm == 1) {
			addMullionV.newStartingYCenter =
						myMullion.ycs =
						myMullion.centerYs =
						addMullionV
						.intersectY(
									//
									myMullion.centerXs, //
									addMullionV.newStartingYCenter, //
									myMullion.centerXs, //
									newYBotCenter, //
									myMullion.limitStartYC.startXC, //
									myMullion.limitStartYC.startYC, //
									myMullion.limitStartYC.endXC, //
									myMullion.limitStartYC.endYC//
									);
		} else if (myMullion.limitStartYC.partForm == 2) {
			addMullionV.newStartingYCenter =
						myMullion.ycs =
						myMullion.centerYs =
						arcX
						.getYusingX(
									myMullion.centerXs, //
									addMullionV.newStartingYCenter, //
									myMullion.centerXs, //
									newYBotCenter, //
									myMullion.limitStartYC.radius1,
									myMullion.limitStartYC.x1,
									myMullion.limitStartYC.y1,
									false);
		} else if (myMullion.limitStartYC.partForm == 3) {
			
		}
		
	}
	
	public void doStartEndType3P(final Profiles myMullion) {
		
		if (myMullion.limitStartY2c.partForm == 1) {
			
			addMullionV.newStartingYRTc = myMullion.y2cl = addMullionV.intersectY(myMullion.x2cl, //
						addMullionV.newStartingYRTc, //
						myMullion.x2cl, //
						newYBotRTc, //
						myMullion.limitStartY2c.startXBA, //
						myMullion.limitStartY2c.startYBA, //
						myMullion.limitStartY2c.endXBA, //
						myMullion.limitStartY2c.endYBA//
						);
			
			myMullion.y2a3 = myMullion.y2a = addMullionV.intersectY(
						// myMullion.x2cl, //
						// addMullionV.newStartingYLBa, //
						// myMullion.x2cl, //
						// newYBotLBa, //
						
						myMullion.x2cl, //
						addMullionV.newStartingYRTc, //
						myMullion.x2cl, //
						newYBotRTc, //
						
						myMullion.limitStartY2c.startXA, //
						myMullion.limitStartY2c.startYA, //
						myMullion.limitStartY2c.endXA, //
						myMullion.limitStartY2c.endYA//
						);
		} else if (myMullion.limitStartY2c.partForm == 2) {
			addMullionV.newStartingYRTc =
						myMullion.y2cl = arcX.getYusingX(myMullion.x2cl, //
									addMullionV.newStartingYRTc, //
									myMullion.x2cl, //
									newYBotRTc, //
									myMullion.limitStartY2c.radius1BA,
									myMullion.limitStartY2c.x1,
									myMullion.limitStartY2c.y1,
									false);
			
			myMullion.y2a3 =
						myMullion.y2a = arcX.getYusingX(myMullion.x2cl, //
									addMullionV.newStartingYRTc, //
									myMullion.x2cl, //
									newYBotRTc, //
									myMullion.limitStartY2c.radius1A,
									myMullion.limitStartY2c.x1,
									myMullion.limitStartY2c.y1,
									false);
			
		} else if (myMullion.limitStartY2c.partForm == 3) {
			
		}
		
		if (myMullion.limitStartY1a.partForm == 1) {
			addMullionV.newStartingYLBa =
						myMullion.y1al = addMullionV.intersectY(
									//
									myMullion.x1al, //
									addMullionV.newStartingYLBa, //
									myMullion.x1al, //
									newYBotLBa, //
									myMullion.limitStartY1a.startXBA, //
									myMullion.limitStartY1a.startYBA, //
									myMullion.limitStartY1a.endXBA, //
									myMullion.limitStartY1a.endYBA//
									);
			
			myMullion.y1a3 = myMullion.y1a = addMullionV.intersectY(
						//
						myMullion.x1al, //
						addMullionV.newStartingYLBa, //
						myMullion.x1al, //
						newYBotLBa, //
						myMullion.limitStartY1a.startXA, //
						myMullion.limitStartY1a.startYA, //
						myMullion.limitStartY1a.endXA, //
						myMullion.limitStartY1a.endYA//
						);
			
		} else if (myMullion.limitStartY1a.partForm == 2) {
			
			addMullionV.newStartingYLBa =
						myMullion.y1al = arcX.getYusingX(myMullion.x1al, //
									addMullionV.newStartingYLBa, //
									myMullion.x1al, //
									newYBotLBa, //
									myMullion.limitStartY1a.radius1BA,
									myMullion.limitStartY1a.x1,
									myMullion.limitStartY1a.y1,
									false);
			
			myMullion.y1a3 =
						myMullion.y1a = arcX.getYusingX(myMullion.x1al, //
									addMullionV.newStartingYLBa, //
									myMullion.x1al, //
									newYBotLBa, //
									myMullion.limitStartY1a.radius1A,
									myMullion.limitStartY1a.x1,
									myMullion.limitStartY1a.y1,
									false);
			
		} else if (myMullion.limitStartY1a.partForm == 1) {
			
		}
		
		if (myMullion.limitStartY2.partForm == 1) {
			addMullionV.newStartingYRT =
						myMullion.y2 =
						addMullionV.intersectY(
									myMullion.x2,
									addMullionV.newStartingYRT,
									myMullion.x2,
									newYBotRT,
									myMullion.limitStartY2.startXBA, //
									myMullion.limitStartY2.startYBA, //
									myMullion.limitStartY2.endXBA, //
									myMullion.limitStartY2.endYBA//
									);
			
			myMullion.y2b = addMullionV.intersectY(
						//
						myMullion.x2, //
						addMullionV.newStartingYRT, //
						myMullion.x2, //
						newYBotRT, //
						myMullion.limitStartY2.startXA, //
						myMullion.limitStartY2.startYA, //
						myMullion.limitStartY2.endXA, //
						myMullion.limitStartY2.endYA//
						);
		} else if (myMullion.limitStartY2.partForm == 2) {
			addMullionV.newStartingYRT =
						myMullion.y2 =
						arcX.getYusingX(
									myMullion.x2,
									addMullionV.newStartingYRT,
									myMullion.x2,
									newYBotRT,
									myMullion.limitStartY2.radius1BA,
									myMullion.limitStartY2.x1,
									myMullion.limitStartY2.y1,
									false);
			
			myMullion.y2b =
						arcX.getYusingX(
									myMullion.x2,
									addMullionV.newStartingYRT,
									myMullion.x2,
									newYBotRT,
									myMullion.limitStartY2.radius1A,
									myMullion.limitStartY2.x1,
									myMullion.limitStartY2.y1,
									false);
			
		} else if (myMullion.limitStartY2.partForm == 3) {
			
		}
		
		if (myMullion.limitStartY1.partForm == 1) {
			addMullionV.newStartingYLB =
						myMullion.y1 = addMullionV.intersectY(
									//
									myMullion.x1, //
									addMullionV.newStartingYLB, //
									myMullion.x1, //
									newYBotLB, //
									myMullion.limitStartY1.startXBA, //
									myMullion.limitStartY1.startYBA, //
									myMullion.limitStartY1.endXBA, //
									myMullion.limitStartY1.endYBA//
									);
			myMullion.y1b = addMullionV.intersectY(
						//
						myMullion.x1, //
						addMullionV.newStartingYLB, //
						myMullion.x1, //
						newYBotLB, //
						myMullion.limitStartY1.startXA, //
						myMullion.limitStartY1.startYA, //
						myMullion.limitStartY1.endXA, //
						myMullion.limitStartY1.endYA//
						);
		} else if (myMullion.limitStartY1.partForm == 2) {
			addMullionV.newStartingYLB =
						myMullion.y1 = arcX.getYusingX(myMullion.x1, //
									addMullionV.newStartingYLB, //
									myMullion.x1, //
									newYBotLB, //
									myMullion.limitStartY1.radius1BA,
									myMullion.limitStartY1.x1,
									myMullion.limitStartY1.y1,
									false);
			
			myMullion.y1b = arcX.getYusingX(myMullion.x1, //
						addMullionV.newStartingYLB, //
						myMullion.x1, //
						newYBotLB, //
						myMullion.limitStartY1.radius1A,
						myMullion.limitStartY1.x1,
						myMullion.limitStartY1.y1,
						false);
		} else if (myMullion.limitStartY1.partForm == 3) {
			
		}
		
		if (myMullion.limitStartYC.partForm == 1) {
			addMullionV.newStartingYCenter =
						myMullion.centerYs = addMullionV.intersectY(
									//
									myMullion.centerXs, //
									addMullionV.newStartingYCenter, //
									myMullion.centerXs, //
									newYBotCenter, //
									myMullion.limitStartYC.startXBA, //
									myMullion.limitStartYC.startYBA, //
									myMullion.limitStartYC.endXBA, //
									myMullion.limitStartYC.endYBA//
									);
			
			myMullion.ycs = addMullionV.intersectY(
						//
						myMullion.centerXs, //
						addMullionV.newStartingYCenter, //
						myMullion.centerXs, //
						newYBotCenter, //
						myMullion.limitStartYC.startXA, //
						myMullion.limitStartYC.startYA, //
						myMullion.limitStartYC.endXA, //
						myMullion.limitStartYC.endYA//
						);
		} else if (myMullion.limitStartYC.partForm == 2) {
			addMullionV.newStartingYCenter =
						myMullion.centerYs =
						arcX.getYusingX(myMullion.centerXs, //
									addMullionV.newStartingYCenter, //
									myMullion.centerXs, //
									newYBotCenter, // /
									myMullion.limitStartYC.radius1BA,
									myMullion.limitStartYC.x1,
									myMullion.limitStartYC.y1,
									false);
			
			myMullion.ycs = arcX.getYusingX(myMullion.centerXs, //
						addMullionV.newStartingYCenter, //
						myMullion.centerXs, //
						newYBotCenter, //
						myMullion.limitStartYC.radius1A,
						myMullion.limitStartYC.x1,
						myMullion.limitStartYC.y1,
						false);
		} else if (myMullion.limitStartYC.partForm == 3) {
			
		}
	}
	
	public void doStartEndType1MC(
				final Profiles myMullion,
				final double hypCenter) {
		
		if (myMullion.limitStartY2c.partForm == 1) {
			addMullionV.newStartingYRTc =
						myMullion.y2a =
						myMullion.y2a3 =
						myMullion.y2cl =
						addMullionV
						.intersectY(
									//
									myMullion.x2cl, //
									addMullionV.newStartingYRTc, //
									myMullion.x2cl, //
									newYBotRTc, //
									
									myMullion.limitStartY2c.x1al, //
									myMullion.limitStartY2c.y1al, //
									myMullion.limitStartY2c.x4al, //
									myMullion.limitStartY2c.y4al//
									);
		} else if (myMullion.limitStartY2c.partForm == 2) {
			
			myMullion.y2cl =
						myMullion.y2a3 =
						myMullion.y2a =
						arcX
						.getYusingX(
									myMullion.x2cl,
									myMullion.y2cl,
									myMullion.x3cl,
									myMullion.y3cl,
									myMullion.limitStartY2c.radiusXY1al,
									myMullion.limitStartY2c.x1,
									myMullion.limitStartY2c.y1,
									false);
			
		} else if (myMullion.limitStartY2c.partForm == 3) {
			
		}
		if (myMullion.limitStartY1a.partForm == 1) {
			addMullionV.newStartingYLBa =
						myMullion.y1a =
						myMullion.y1a3 =
						myMullion.y1al =
						addMullionV
						.intersectY(
									//
									myMullion.x1al, //
									addMullionV.newStartingYLBa, //
									myMullion.x1al, //
									newYBotLBa, //
									myMullion.limitStartY2c.x1al, //
									myMullion.limitStartY2c.y1al, //
									myMullion.limitStartY2c.x4al, //
									myMullion.limitStartY2c.y4al//
									);
		}
		if (myMullion.limitStartY1a.partForm == 2) {
			myMullion.y1al =
						myMullion.y1a3 =
						myMullion.y1a =
						arcX
						.getYusingX(
									myMullion.x1al,
									myMullion.y1al,
									myMullion.x1al,
									myMullion.y1al,
									myMullion.limitStartY1a.radiusXY1al,
									myMullion.limitStartY1a.x1,
									myMullion.limitStartY1a.y1,
									false);
		}
		if (myMullion.limitStartY1a.partForm == 3) {
			
		}
		if (myMullion.limitStartYC.partForm == 1) {
			addMullionV.newStartingYCenter =
						myMullion.ycs =
						myMullion.centerYs =
						addMullionV
						.intersectY(
									//
									myMullion.centerXs, //
									addMullionV.newStartingYCenter, //
									myMullion.centerXs, //
									newYBotCenter, //
									myMullion.limitStartYC.x1, //
									myMullion.limitStartYC.y1
									- hypCenter, //
									myMullion.limitStartYC.x4, //
									myMullion.limitStartYC.y4
									- hypCenter//
									);
		}
		if (myMullion.limitStartYC.partForm == 2) {
			addMullionV.newStartingYCenter =
						myMullion.ycs =
						myMullion.centerYs =
						
						arcX
						.getYusingX(
									myMullion.centerXs,
									addMullionV.newStartingYCenter,
									myMullion.centerXs,
									newYBotCenter,
									myMullion.limitStartYC.radiusXY1
									- hypCenter,
									myMullion.limitStartYC.x1,
									myMullion.limitStartYC.y1,
									false);
		}
		if (myMullion.limitStartYC.partForm == 3) {
			
		}
		
		addMullionV.newStartingYRT =
					myMullion.y2 =
					myMullion.y2b = addMullionV.intersectY(
								//
								myMullion.x2, //
								addMullionV.newStartingYRT, //
								myMullion.x3, //
								addMullionV.vcEndY, //
								myMullion.centerXs, //
								myMullion.ycs, //
								myMullion.x2a, //
								myMullion.y2a//
								);
		
		addMullionV.newStartingYLB =
					myMullion.y1 =
					myMullion.y1b =
					addMullionV.intersectY(myMullion.x1, //
								addMullionV.newStartingXLB, //
								myMullion.x4, //
								this.newYBotLB, //
								myMullion.centerXs, //
								myMullion.ycs, //
								myMullion.x1a, //
								myMullion.y1a//
								);
	}
	
	public void doStartEndType2MC(final Profiles myMullion) {
		
		// if(myMullion.limitStartY2c.partForm==1) {
		// addMullionV.newStartingYRTc = myMullion.y2a3 =
		// myMullion.y2a =
		// addMullionV
		// .intersectY(
		// myMullion.x2cl, //
		// addMullionV.newStartingYRTc, //
		// myMullion.x2cl, //
		// newYBotRTc, //
		// myMullion.limitStartY2c.startXC, //
		// myMullion.limitStartY2c.startYC, //
		// myMullion.limitStartY2c.endXC, //
		// myMullion.limitStartY2c.endYC//
		// );
		// }if(myMullion.limitStartY2c.partForm==2) {
		// addMullionV.newStartingYRTc = myMullion.y2cl =
		// myMullion.y2a3 = myMullion.y2a =
		// arcX
		// .getYusingX(
		// myMullion.x2cl,
		// myMullion.y2cl,
		// myMullion.x3cl,
		// myMullion.y3cl,
		// myMullion.limitStartY2c.radius1,
		// myMullion.limitStartY2c.x1,
		// myMullion.limitStartY2c.y1,
		// false);
		//
		// }if(myMullion.limitStartY2c.partForm==3) {
		//
		// }
		// if(myMullion.limitStartY1a.partForm==1) {
		// addMullionV.newStartingYLBa = myMullion.y1a =
		// myMullion.y1a3 =
		// addMullionV
		// .intersectY(
		// //
		// myMullion.x1al, //
		// addMullionV.newStartingYLBa, //
		// myMullion.x1al, //
		// newYBotLBa, //
		// myMullion.limitStartY1a.startXC, //
		// myMullion.limitStartY1a.startYC, //
		// myMullion.limitStartY1a.endXC, //
		// myMullion.limitStartY1a.endYC//
		// );
		// }else if(myMullion.limitStartY1a.partForm==2) {
		// addMullionV.newStartingYLBa = myMullion.y1a =
		// myMullion.y1a3 =
		// arcX
		// .getYusingX(
		// myMullion.x1al,
		// myMullion.y1al,
		// myMullion.x1al,
		// myMullion.y1al,
		// myMullion.limitStartY1a.radius1,
		// myMullion.limitStartY1a.x1,
		// myMullion.limitStartY1a.y1,
		// false);
		// }else if(myMullion.limitStartY1a.partForm==3) {
		//
		// }
		//
		//
		// if(myMullion.limitStartY2.partForm==1) {
		// addMullionV.newStartingYRT = myMullion.y2 = myMullion.y2b
		// =
		// addMullionV
		// .intersectY(
		// //
		// myMullion.x2, //
		// addMullionV.newStartingYRT, //
		// myMullion.x2, //
		// newYBotRT, //
		// myMullion.limitStartY2.startXC, //
		// myMullion.limitStartY2.startYC, //
		// myMullion.limitStartY2.endXC, //
		// myMullion.limitStartY2.endYC//
		// );
		// }else if(myMullion.limitStartY2.partForm==2) {
		// addMullionV.newStartingYRT = myMullion.y2 = myMullion.y2b
		// =
		// arcX
		// .getYusingX(
		// myMullion.x2, //
		// addMullionV.newStartingYRT, //
		// myMullion.x2, //
		// newYBotRT, //
		// myMullion.limitStartY2.radius1,
		// myMullion.limitStartY2.x1,
		// myMullion.limitStartY2.y1,
		// false);
		// }else if(myMullion.limitStartY2.partForm==3) {
		//
		// }
		//
		// if(myMullion.limitStartY1.partForm==1) {
		//
		// addMullionV.newStartingYLB = myMullion.y1 = myMullion.y1b
		// =
		// addMullionV
		// .intersectY(
		// //
		// myMullion.x1, //
		// addMullionV.newStartingYLB, //
		// myMullion.x1, //
		// newYBotLB, //
		// myMullion.limitStartY1.startXC, //
		// myMullion.limitStartY1.startYC, //
		// myMullion.limitStartY1.endXC, //
		// myMullion.limitStartY1.endYC//
		// );
		// }else if(myMullion.limitStartY1.partForm==2) {
		// addMullionV.newStartingYLB = myMullion.y1 = myMullion.y1b
		// =
		// arcX
		// .getYusingX(
		// myMullion.x1, //
		// addMullionV.newStartingYLB, //
		// myMullion.x1, //
		// newYBotLB, //
		// myMullion.limitStartY1.radius1,
		// myMullion.limitStartY1.x1,
		// myMullion.limitStartY1.y1,
		// false);
		// }else if(myMullion.limitStartY1.partForm==3) {
		//
		// }
		//
		// if(myMullion.limitStartYC.partForm==1) {
		// addMullionV.newStartingYCenter = myMullion.ycs =
		// addMullionV
		// .intersectY(
		// //
		// myMullion.centerXs, //
		// addMullionV.newStartingYCenter, //
		// myMullion.centerXs, //
		// newYBotCenter, //
		// myMullion.limitStartYC.startXC, //
		// myMullion.limitStartYC.startYC, //
		// myMullion.limitStartYC.endXC, //
		// myMullion.limitStartYC.endYC//
		// );
		// }else if(myMullion.limitStartYC.partForm==2) {
		// addMullionV.newStartingYCenter = myMullion.ycs =
		// arcX
		// .getYusingX(
		// myMullion.centerXs, //
		// addMullionV.newStartingYCenter, //
		// myMullion.centerXs, //
		// newYBotCenter, //
		// myMullion.limitStartYC.radius1,
		// myMullion.limitStartYC.x1,
		// myMullion.limitStartYC.y1,
		// false);
		// }else if(myMullion.limitStartYC.partForm==3) {
		//
		// }
		
		doStartEndType3MC(myMullion);
		
	}
	
	public void doStartEndType3MC(final Profiles myMullion) {
		
		if (myMullion.limitStartY2c.partForm == 1) {
			addMullionV.newStartingYRTc =
						myMullion.y2cl =
						addMullionV.intersectY(myMullion.x2cl, //
									addMullionV.newStartingYRTc, //
									myMullion.x2cl, //
									newYBotRTc, //
									myMullion.limitStartY2c.x1, //
									myMullion.limitStartY2c.y1, //
									myMullion.limitStartY2c.x4, //
									myMullion.limitStartY2c.y4//
									);
			
			myMullion.y2a3 = myMullion.y2a = addMullionV.intersectY(
						//
						myMullion.x2cl, //
						addMullionV.newStartingYLBa, //
						myMullion.x2cl, //
						newYBotLBa, //
						myMullion.limitStartY2c.x1al, //
						myMullion.limitStartY2c.y1al, //
						myMullion.limitStartY2c.x4al, //
						myMullion.limitStartY2c.y4al//
						);
		} else if (myMullion.limitStartY2c.partForm == 2) {
			addMullionV.newStartingYRTc =
						myMullion.y2cl = arcX.getYusingX(myMullion.x2cl, //
									addMullionV.newStartingYRTc, //
									myMullion.x2cl, //
									newYBotRTc, //
									myMullion.limitStartY2c.radiusXY1,
									myMullion.limitStartY2c.x1,
									myMullion.limitStartY2c.y1,
									false);
			
			myMullion.y2a3 =
						myMullion.y2a = arcX.getYusingX(myMullion.x2cl, //
									addMullionV.newStartingYRTc, //
									myMullion.x2cl, //
									newYBotRTc, //
									myMullion.limitStartY2c.radiusXY1al,
									myMullion.limitStartY2c.x1,
									myMullion.limitStartY2c.y1,
									false);
			
		} else if (myMullion.limitStartY2c.partForm == 3) {
			
		}
		
		if (myMullion.limitStartY1a.partForm == 1) {
			addMullionV.newStartingYLBa =
						myMullion.y1al = addMullionV.intersectY(
									//
									myMullion.x1al, //
									addMullionV.newStartingYLBa, //
									myMullion.x1al, //
									newYBotLBa, //
									myMullion.limitStartY2c.x1, //
									myMullion.limitStartY2c.y1, //
									myMullion.limitStartY2c.x4, //
									myMullion.limitStartY2c.y4//
									);
			
			myMullion.y1a3 = myMullion.y1a = addMullionV.intersectY(
						//
						myMullion.x1al, //
						addMullionV.newStartingYLBa, //
						myMullion.x1al, //
						newYBotLBa, //
						myMullion.limitStartY2c.x1al, //
						myMullion.limitStartY2c.y1al, //
						myMullion.limitStartY2c.x4al, //
						myMullion.limitStartY2c.y4al//
						);
			
		} else if (myMullion.limitStartY1a.partForm == 2) {
			
			addMullionV.newStartingYLBa =
						myMullion.y1al = arcX.getYusingX(myMullion.x1al, //
									addMullionV.newStartingYLBa, //
									myMullion.x1al, //
									newYBotLBa, //
									myMullion.limitStartY1a.radiusXY1,
									myMullion.limitStartY1a.x1,
									myMullion.limitStartY1a.y1,
									false);
			
			myMullion.y1a3 =
						myMullion.y1a = arcX.getYusingX(myMullion.x1al, //
									addMullionV.newStartingYLBa, //
									myMullion.x1al, //
									newYBotLBa, //
									myMullion.limitStartY1a.radiusXY1al,
									myMullion.limitStartY1a.x1,
									myMullion.limitStartY1a.y1,
									false);
			
		} else if (myMullion.limitStartY1a.partForm == 1) {
			
		}
		
		if (myMullion.limitStartY2.partForm == 1) {
			addMullionV.newStartingYRT =
						myMullion.y2 =
						addMullionV.intersectY(
									myMullion.x2,
									addMullionV.newStartingYRT,
									myMullion.x2,
									newYBotRT,
									myMullion.limitStartY2c.x1, //
									myMullion.limitStartY2c.y1, //
									myMullion.limitStartY2c.x4, //
									myMullion.limitStartY2c.y4//
									);
			
			myMullion.y2b = addMullionV.intersectY(
						//
						myMullion.x2, //
						addMullionV.newStartingYRT, //
						myMullion.x2, //
						newYBotRT, //
						myMullion.limitStartY2c.x1al, //
						myMullion.limitStartY2c.y1al, //
						myMullion.limitStartY2c.x4al, //
						myMullion.limitStartY2c.y4al//
						);
		} else if (myMullion.limitStartY2.partForm == 2) {
			addMullionV.newStartingYRT =
						myMullion.y2 =
						arcX.getYusingX(
									myMullion.x2,
									addMullionV.newStartingYRT,
									myMullion.x2,
									newYBotRT,
									myMullion.limitStartY2.radiusXY1,
									myMullion.limitStartY2.x1,
									myMullion.limitStartY2.y1,
									false);
			
			myMullion.y2b =
						arcX.getYusingX(
									myMullion.x2,
									addMullionV.newStartingYRT,
									myMullion.x2,
									newYBotRT,
									myMullion.limitStartY2.radiusXY1al,
									myMullion.limitStartY2.x1,
									myMullion.limitStartY2.y1,
									false);
			
		} else if (myMullion.limitStartY2.partForm == 3) {
			
		}
		
		if (myMullion.limitStartY1.partForm == 1) {
			addMullionV.newStartingYLB =
						myMullion.y1 = addMullionV.intersectY(
									//
									myMullion.x1, //
									addMullionV.newStartingYLB, //
									myMullion.x1, //
									newYBotLB, //
									myMullion.limitStartY2c.x1, //
									myMullion.limitStartY2c.y1, //
									myMullion.limitStartY2c.x4, //
									myMullion.limitStartY2c.y4//
									);
			myMullion.y1b = addMullionV.intersectY(
						//
						myMullion.x1, //
						addMullionV.newStartingYLB, //
						myMullion.x1, //
						newYBotLB, //
						myMullion.limitStartY2c.x1al, //
						myMullion.limitStartY2c.y1al, //
						myMullion.limitStartY2c.x4al, //
						myMullion.limitStartY2c.y4al//
						);
		} else if (myMullion.limitStartY1.partForm == 2) {
			addMullionV.newStartingYLB =
						myMullion.y1 = arcX.getYusingX(myMullion.x1, //
									addMullionV.newStartingYLB, //
									myMullion.x1, //
									newYBotLB, //
									myMullion.limitStartY1.radiusXY1,
									myMullion.limitStartY1.x1,
									myMullion.limitStartY1.y1,
									false);
			
			myMullion.y1b = arcX.getYusingX(myMullion.x1, //
						addMullionV.newStartingYLB, //
						myMullion.x1, //
						newYBotLB, //
						myMullion.limitStartY1.radiusXY1al,
						myMullion.limitStartY1.x1,
						myMullion.limitStartY1.y1,
						false);
		} else if (myMullion.limitStartY1.partForm == 3) {
			
		}
		
		if (myMullion.limitStartYC.partForm == 1) {
			addMullionV.newStartingYCenter =
						myMullion.centerYs = addMullionV.intersectY(
									//
									myMullion.centerXs, //
									addMullionV.newStartingYCenter, //
									myMullion.centerXs, //
									newYBotCenter, //
									myMullion.limitStartY2c.x1, //
									myMullion.limitStartY2c.y1, //
									myMullion.limitStartY2c.x4, //
									myMullion.limitStartY2c.y4//
									);
			
			myMullion.ycs = addMullionV.intersectY(
						//
						myMullion.centerXs, //
						addMullionV.newStartingYCenter, //
						myMullion.centerXs, //
						newYBotCenter, //
						myMullion.limitStartY2c.x1al, //
						myMullion.limitStartY2c.y1al, //
						myMullion.limitStartY2c.x4al, //
						myMullion.limitStartY2c.y4al//
						);
		} else if (myMullion.limitStartYC.partForm == 2) {
			addMullionV.newStartingYCenter =
						myMullion.centerYs =
						arcX.getYusingX(myMullion.centerXs, //
									addMullionV.newStartingYCenter, //
									myMullion.centerXs, //
									newYBotCenter, // /
									myMullion.limitStartYC.radiusXY1,
									myMullion.limitStartYC.x1,
									myMullion.limitStartYC.y1,
									false);
			
			myMullion.ycs = arcX.getYusingX(myMullion.centerXs, //
						addMullionV.newStartingYCenter, //
						myMullion.centerXs, //
						newYBotCenter, //
						myMullion.limitStartYC.radiusXY1al,
						myMullion.limitStartYC.x1,
						myMullion.limitStartYC.y1,
						false);
		} else if (myMullion.limitStartYC.partForm == 3) {
			
		}
	}
	
	public Profiles calculateCoordinArchIIT(final Profiles myMullion) {
		
		setYs = true;
		
		if (myMullion.endTypeLT == 3) {
			
			myMullion.centerYs =
						arcX.getYusingX(
									myMullion.centerXs,
									myMullion.centerYs,
									myMullion.centerXe,
									myMullion.centerYe,
									addMullionV.limitStart.radius1BA,
									addMullionV.limitStart.x1,
									addMullionV.limitStart.y1,
									false);
			
			myMullion.ycs =
						arcX.getYusingX(
									myMullion.centerXs,
									myMullion.centerYs,
									myMullion.centerXe,
									myMullion.centerYe,
									addMullionV.limitStart.radius1A,
									addMullionV.limitStart.x1,
									addMullionV.limitStart.y1,
									false);
			
			myMullion.y1 =
						arcX.getYusingX(
									myMullion.x1,
									myMullion.y1,
									myMullion.x4,
									myMullion.y4,
									addMullionV.limitStart.radius1BA,
									addMullionV.limitStart.x1,
									addMullionV.limitStart.y1,
									false);
			
			myMullion.y1b =
						arcX.getYusingX(
									myMullion.x1,
									myMullion.y1,
									myMullion.x4,
									myMullion.y4,
									addMullionV.limitStart.radius1A,
									addMullionV.limitStart.x1,
									addMullionV.limitStart.y1,
									false);
			
			myMullion.y1al =
						myMullion.y1a =
						arcX.getYusingX(
									myMullion.x1al,
									myMullion.y1al,
									myMullion.x4al,
									myMullion.y4al,
									addMullionV.limitStart.radius1BA,
									addMullionV.limitStart.x1,
									addMullionV.limitStart.y1,
									false);
			
			myMullion.y1a3 =
						arcX.getYusingX(
									myMullion.x1al,
									myMullion.y1al,
									myMullion.x4al,
									myMullion.y4al,
									addMullionV.limitStart.radius1A,
									addMullionV.limitStart.x1,
									addMullionV.limitStart.y1,
									false);
			
			if (!addMullionV.inMiddleS) {
				myMullion.y2 =
							arcX.getYusingX(
										myMullion.x2,
										myMullion.y2,
										myMullion.x3,
										myMullion.y3,
										addMullionV.limitStart.radius1BA,
										addMullionV.limitStart.x1,
										addMullionV.limitStart.y1,
										false);
				
				myMullion.y2b =
							arcX.getYusingX(
										myMullion.x2,
										myMullion.y2,
										myMullion.x3,
										myMullion.y3,
										addMullionV.limitStart.radius1A,
										addMullionV.limitStart.x1,
										addMullionV.limitStart.y1,
										false);
				
				myMullion.y2a3 =
							arcX.getYusingX(
										myMullion.x2cl,
										myMullion.y2cl,
										myMullion.x3cl,
										myMullion.y3cl,
										addMullionV.limitStart.radius1A,
										addMullionV.limitStart.x1,
										addMullionV.limitStart.y1,
										false);
				
				myMullion.y2cl =
							myMullion.y2a =
							arcX
							.getYusingX(
										myMullion.x2cl,
										myMullion.y2cl,
										myMullion.x3cl,
										myMullion.y3cl,
										addMullionV.limitStart.radius1BA,
										addMullionV.limitStart.x1,
										addMullionV.limitStart.y1,
										false);
			} else {
				myMullion.y2 =
							arcX.getYusingX(
										myMullion.x2,
										myMullion.y2,
										myMullion.x3,
										myMullion.y3,
										addMullionV.limitStart2.radius1BA,
										addMullionV.limitStart2.x1,
										addMullionV.limitStart2.y1,
										false);
				
				myMullion.y2b =
							arcX.getYusingX(
										myMullion.x2,
										myMullion.y2,
										myMullion.x3,
										myMullion.y3,
										addMullionV.limitStart2.radius1A,
										addMullionV.limitStart2.x1,
										addMullionV.limitStart2.y1,
										false);
				
				myMullion.y2a3 =
							arcX.getYusingX(
										myMullion.x2cl,
										myMullion.y2cl,
										myMullion.x3cl,
										myMullion.y3cl,
										addMullionV.limitStart2.radius1A,
										addMullionV.limitStart2.x1,
										addMullionV.limitStart2.y1,
										false);
				
				myMullion.y2cl =
							myMullion.y2a =
							arcX
							.getYusingX(
										myMullion.x2cl,
										myMullion.y2cl,
										myMullion.x3cl,
										myMullion.y3cl,
										addMullionV.limitStart2.radius1,
										addMullionV.limitStart2.x1,
										addMullionV.limitStart2.y1,
										false);
			}
		}
		if (myMullion.endTypeLT == 2) {
			
			myMullion.centerYs =
						arcX.getYusingX(
									myMullion.centerXs,
									myMullion.centerYs,
									myMullion.centerXe,
									myMullion.centerYe,
									addMullionV.limitStart.radius1BA,
									addMullionV.limitStart.x1,
									addMullionV.limitStart.y1,
									false);
			
			myMullion.ycs =
						arcX.getYusingX(
									myMullion.centerXs,
									myMullion.centerYs,
									myMullion.centerXe,
									myMullion.centerYe,
									addMullionV.limitStart.radius1A,
									addMullionV.limitStart.x1,
									addMullionV.limitStart.y1,
									false);
			
			myMullion.y1 =
						arcX.getYusingX(
									myMullion.x1,
									myMullion.y1,
									myMullion.x4,
									myMullion.y4,
									addMullionV.limitStart.radius1BA,
									addMullionV.limitStart.x1,
									addMullionV.limitStart.y1,
									false);
			
			myMullion.y1b =
						arcX.getYusingX(
									myMullion.x1,
									myMullion.y1,
									myMullion.x4,
									myMullion.y4,
									addMullionV.limitStart.radius1A,
									addMullionV.limitStart.x1,
									addMullionV.limitStart.y1,
									false);
			
			myMullion.y1al =
						myMullion.y1a =
						arcX.getYusingX(
									myMullion.x1al,
									myMullion.y1al,
									myMullion.x4al,
									myMullion.y4al,
									addMullionV.limitStart.radius1BA,
									addMullionV.limitStart.x1,
									addMullionV.limitStart.y1,
									false);
			
			myMullion.y1a3 =
						arcX.getYusingX(
									myMullion.x1al,
									myMullion.y1al,
									myMullion.x4al,
									myMullion.y4al,
									addMullionV.limitStart.radius1A,
									addMullionV.limitStart.x1,
									addMullionV.limitStart.y1,
									false);
			
			if (!addMullionV.inMiddleS) {
				
				myMullion.y2 =
							arcX.getYusingX(
										myMullion.x2,
										myMullion.y2,
										myMullion.x3,
										myMullion.y3,
										addMullionV.limitStart.radius1BA,
										addMullionV.limitStart.x1,
										addMullionV.limitStart.y1,
										false);
				
				myMullion.y2b =
							arcX.getYusingX(
										myMullion.x2,
										myMullion.y2,
										myMullion.x3,
										myMullion.y3,
										addMullionV.limitStart.radius1A,
										addMullionV.limitStart.x1,
										addMullionV.limitStart.y1,
										false);
				
				myMullion.y2cl =
							arcX.getYusingX(
										myMullion.x2cl,
										myMullion.y2cl,
										myMullion.x3cl,
										myMullion.y3cl,
										addMullionV.limitStart.radius1BA,
										addMullionV.limitStart.x1,
										addMullionV.limitStart.y1,
										false);
				myMullion.y2a3 =
							arcX.getYusingX(
										myMullion.x2cl,
										myMullion.y2cl,
										myMullion.x3cl,
										myMullion.y3cl,
										addMullionV.limitStart.radius1A,
										addMullionV.limitStart.x1,
										addMullionV.limitStart.y1,
										false);
			} else {
				myMullion.y2 =
							arcX.getYusingX(
										myMullion.x2,
										myMullion.y2,
										myMullion.x3,
										myMullion.y3,
										addMullionV.limitStart2.radius1BA,
										addMullionV.limitStart2.x1,
										addMullionV.limitStart2.y1,
										false);
				
				myMullion.y2b =
							arcX.getYusingX(
										myMullion.x2,
										myMullion.y2,
										myMullion.x3,
										myMullion.y3,
										addMullionV.limitStart2.radius1A,
										addMullionV.limitStart2.x1,
										addMullionV.limitStart2.y1,
										false);
				
				myMullion.y2cl =
							myMullion.y2a =
							arcX
							.getYusingX(
										myMullion.x2cl,
										myMullion.y2cl,
										myMullion.x3cl,
										myMullion.y3cl,
										addMullionV.limitStart2.radius1BA,
										addMullionV.limitStart2.x1,
										addMullionV.limitStart2.y1,
										false);
				
				myMullion.y2a3 =
							arcX.getYusingX(
										myMullion.x2cl,
										myMullion.y2cl,
										myMullion.x3cl,
										myMullion.y3cl,
										addMullionV.limitStart2.radius1A,
										addMullionV.limitStart2.x1,
										addMullionV.limitStart2.y1,
										false);
				
			}
			
		}
		if (myMullion.endTypeLT == 1) {
			
			myMullion.centerYs =
						myMullion.ycs =
						arcX
						.getYusingX(
									myMullion.centerXs,
									myMullion.centerYs,
									myMullion.centerXe,
									myMullion.centerYe,
									addMullionV.limitStart.radius1
									- addMullionV.limitStart.partDimC
									- addMullionV.dimTM,
									addMullionV.limitStart.x1,
									addMullionV.limitStart.y1,
									false);
			
			myMullion.y1 =
						myMullion.y1b =
						arcX.getYusingX(
									myMullion.x1,
									myMullion.y1,
									myMullion.x4,
									myMullion.y4,
									addMullionV.limitStart.radius1BA,
									addMullionV.limitStart.x1,
									addMullionV.limitStart.y1,
									false);
			
			myMullion.y1al =
						myMullion.y1a =
						myMullion.y1a3 =
						arcX
						.getYusingX(
									myMullion.x1al,
									myMullion.y1al,
									myMullion.x4al,
									myMullion.y4al,
									addMullionV.limitStart.radius1A,
									addMullionV.limitStart.x1,
									addMullionV.limitStart.y1,
									false);
			
			if (!addMullionV.inMiddleS) {
				
				myMullion.y2 =
							myMullion.y2b =
							arcX
							.getYusingX(
										myMullion.x2,
										myMullion.y2,
										myMullion.x3,
										myMullion.y3,
										addMullionV.limitStart.radius1BA,
										addMullionV.limitStart.x1,
										addMullionV.limitStart.y1,
										false);
				
				myMullion.y2cl =
							myMullion.y2a3 =
							myMullion.y2a =
							arcX
							.getYusingX(
										myMullion.x2cl,
										myMullion.y2cl,
										myMullion.x3cl,
										myMullion.y3cl,
										addMullionV.limitStart.radius1A,
										addMullionV.limitStart.x1,
										addMullionV.limitStart.y1,
										false);
			} else {
				
				myMullion.y2 =
							myMullion.y2b =
							arcX
							.getYusingX(
										myMullion.x2,
										myMullion.y2,
										myMullion.x3,
										myMullion.y3,
										addMullionV.limitStart2.radius1BA,
										addMullionV.limitStart2.x1,
										addMullionV.limitStart2.y1,
										false);
				
				myMullion.y2cl =
							myMullion.y2a3 =
							myMullion.y2a =
							arcX
							.getYusingX(
										myMullion.x2cl,
										myMullion.y2cl,
										myMullion.x3cl,
										myMullion.y3cl,
										addMullionV.limitStart2.radius1A,
										addMullionV.limitStart2.x1,
										addMullionV.limitStart2.y1,
										false);
			}
		}
		// }
		return myMullion;
	}
	
	public Profiles calculateCoordinArchIIB(final Profiles myMullion) {
		
		setYs = true;
		
		if (myMullion.endTypeLT == 3) {
			
			myMullion.centerYe =
						arcX.getYusingX(
									myMullion.centerXs,
									myMullion.centerYs,
									myMullion.centerXe,
									myMullion.centerYe,
									addMullionV.limitEnd.radius1,
									addMullionV.limitEnd.x1,
									addMullionV.limitEnd.y1,
									true);
			
			myMullion.y4 =
						arcX.getYusingX(
									myMullion.x1,
									myMullion.y1,
									myMullion.x4,
									myMullion.y4,
									addMullionV.limitEnd.radius1,
									addMullionV.limitEnd.x1,
									addMullionV.limitEnd.y1,
									true);
			
			myMullion.y4al =
						arcX.getYusingX(
									myMullion.x1al,
									myMullion.y1al,
									myMullion.x4al,
									myMullion.y4al,
									addMullionV.limitEnd.radius1,
									addMullionV.limitEnd.x1,
									addMullionV.limitEnd.y1,
									true);
			
			myMullion.y3 =
						arcX.getYusingX(
									myMullion.x2,
									myMullion.y2,
									myMullion.x3,
									myMullion.y3,
									addMullionV.limitEnd.radius1,
									addMullionV.limitEnd.x1,
									addMullionV.limitEnd.y1,
									true);
			
			myMullion.y3cl =
						arcX.getYusingX(
									myMullion.x2cl,
									myMullion.y2cl,
									myMullion.x3cl,
									myMullion.y3cl,
									addMullionV.limitEnd.radius1,
									addMullionV.limitEnd.x1,
									addMullionV.limitEnd.y1,
									true);
			
			myMullion.yce =
						arcX.getYusingX(
									myMullion.centerXs,
									myMullion.centerYs,
									myMullion.centerXe,
									myMullion.centerYe,
									addMullionV.limitEnd.radius1A,
									addMullionV.limitEnd.x1,
									addMullionV.limitEnd.y1,
									true);
			
			myMullion.y4b =
						arcX.getYusingX(
									myMullion.x1,
									myMullion.y1,
									myMullion.x4,
									myMullion.y4,
									addMullionV.limitEnd.radius1A,
									addMullionV.limitEnd.x1,
									addMullionV.limitEnd.y1,
									true);
			
			myMullion.y4a3 =
						myMullion.y4a =
						arcX.getYusingX(
									myMullion.x1al,
									myMullion.y1al,
									myMullion.x4al,
									myMullion.y4al,
									addMullionV.limitEnd.radius1A,
									addMullionV.limitEnd.x1,
									addMullionV.limitEnd.y1,
									true);
			
			myMullion.y3b =
						arcX.getYusingX(
									myMullion.x2,
									myMullion.y2,
									myMullion.x3,
									myMullion.y3,
									addMullionV.limitEnd.radius1A,
									addMullionV.limitEnd.x1,
									addMullionV.limitEnd.y1,
									true);
			
			myMullion.y3a =
						myMullion.y3a3 =
						arcX.getYusingX(
									myMullion.x2cl,
									myMullion.y2cl,
									myMullion.x3cl,
									myMullion.y3cl,
									addMullionV.limitEnd.radius1A,
									addMullionV.limitEnd.x1,
									addMullionV.limitEnd.y1,
									true);
			
		}
		if (myMullion.endTypeLT == 2) {
			
			myMullion.centerYe =
						myMullion.yce =
						arcX.getYusingX(
									myMullion.centerXs,
									myMullion.centerYs,
									myMullion.centerXe,
									myMullion.centerYe,
									addMullionV.limitEnd.radius1BA,
									addMullionV.limitEnd.x1,
									addMullionV.limitEnd.y1,
									true);
			
			myMullion.y4 =
						myMullion.y4b =
						arcX.getYusingX(
									myMullion.x1,
									myMullion.y1,
									myMullion.x4,
									myMullion.y4,
									addMullionV.limitEnd.radius1BA,
									addMullionV.limitEnd.x1,
									addMullionV.limitEnd.y1,
									true);
			
			myMullion.y4al =
						myMullion.y4a3 =
						myMullion.y4a =
						arcX
						.getYusingX(
									myMullion.x1al,
									myMullion.y1al,
									myMullion.x4al,
									myMullion.y4al,
									addMullionV.limitEnd.radius1BA,
									addMullionV.limitEnd.x1,
									addMullionV.limitEnd.y1,
									true);
			
			myMullion.y3 =
						myMullion.y3b =
						arcX.getYusingX(
									myMullion.x2,
									myMullion.y2,
									myMullion.x3,
									myMullion.y3,
									addMullionV.limitEnd.radius1BA,
									addMullionV.limitEnd.x1,
									addMullionV.limitEnd.y1,
									true);
			
			myMullion.y3cl =
						myMullion.y3a3 =
						myMullion.y3a =
						arcX
						.getYusingX(
									myMullion.x2cl,
									myMullion.y2cl,
									myMullion.x3cl,
									myMullion.y3cl,
									addMullionV.limitEnd.radius1BA,
									addMullionV.limitEnd.x1,
									addMullionV.limitEnd.y1,
									true);
		}
		if (myMullion.endTypeLT == 1) {
			
			myMullion.centerYe =
						myMullion.yce =
						arcX.getYusingX(
									myMullion.centerXs,
									myMullion.centerYs,
									myMullion.centerXe,
									myMullion.centerYe,
									addMullionV.limitEnd.radius1
									- addMullionV.dimTM,
									addMullionV.limitEnd.x1,
									addMullionV.limitEnd.y1,
									true);
			
			myMullion.y4 =
						myMullion.y4b =
						arcX.getYusingX(
									myMullion.x1,
									myMullion.y1,
									myMullion.x4,
									myMullion.y4,
									addMullionV.limitEnd.radius1BA,
									addMullionV.limitEnd.x1,
									addMullionV.limitEnd.y1,
									true);
			
			myMullion.y3 =
						myMullion.y3b =
						arcX.getYusingX(
									myMullion.x2,
									myMullion.y2,
									myMullion.x3,
									myMullion.y3,
									addMullionV.limitEnd.radius1BA,
									addMullionV.limitEnd.x1,
									addMullionV.limitEnd.y1,
									true);
			
			myMullion.y4al =
						myMullion.y4a3 =
						myMullion.y4a =
						arcX
						.getYusingX(
									myMullion.x1al,
									myMullion.y1al,
									myMullion.x4al,
									myMullion.y4al,
									addMullionV.limitEnd.radius1A,
									addMullionV.limitEnd.x1,
									addMullionV.limitEnd.y1,
									true);
			
			myMullion.y3cl =
						myMullion.y3a3 =
						myMullion.y3a =
						arcX
						.getYusingX(
									myMullion.x2cl,
									myMullion.y2cl,
									myMullion.x3cl,
									myMullion.y3cl,
									addMullionV.limitEnd.radius1A,
									addMullionV.limitEnd.x1,
									addMullionV.limitEnd.y1,
									true);
		}
		return myMullion;
	}
	
	public Profiles
	getCCoordinatesForEllipse(final Profiles myMullion) {
		
		final double myX1 =
					addMullionV.myParentBO.startingX
					+ addMullionV.newColW
					* addMullionV.iNo
					+ addMullionV.sumOfPrevMullions;
		final double myX2 = myX1 + myMullion.thickness;
		final double myXC = myX1 + myMullion.thickness / 2;
		
		Object[] xCoordBoc;
		Object[] yCoordBoc;
		final Arc2D.Double arc1c =
					new Arc2D.Double(
								addMullionV.myParentBO.bkgrdStartX,
								addMullionV.myParentBO.bkgrdStartY,
								addMullionV.myParentBO.top1.bkgrdWidthBA,
								addMullionV.myParentBO.top1.bkgrdHeightBA,
								addMullionV.myParentBO.startAngle,
								addMullionV.myParentBO.endAngle,
								Arc2D.OPEN);
		addMullionV.getPoints(arc1c);
		xCoordBoc = addMullionV.xCoordBc.toArray();
		yCoordBoc = addMullionV.yCoordBc.toArray();
		double myY1 = 0;
		double myY2 = 0;
		double myYC = 0;
		
		for (int i = xCoordBoc.length; i >= 1; i--) {
			if ((Double) xCoordBoc[i - 1] >= 0) {
				if (myX1 <= (Double) xCoordBoc[i - 1]
							&& myX1 >= (Double) xCoordBoc[i + 1]) {
					myY1 = (Double) yCoordBoc[i - 1];
					
				}
				if (myX2 <= (Double) xCoordBoc[i - 1]
							&& myX2 >= (Double) xCoordBoc[i + 1]) {
					myY2 = (Double) yCoordBoc[i - 1];
				}
				if (myXC <= (Double) xCoordBoc[i - 1]
							&& myXC >= (Double) xCoordBoc[i + 1]) {
					myYC = (Double) yCoordBoc[i - 1];
				}
				
			}
		}
		;
		
		addMullionV.newStartingYRT =
					addMullionV.myParentBO.centerPointY - myY2;
		
		addMullionV.newStartingYLB =
					addMullionV.myParentBO.centerPointY - myY1;
		
		addMullionV.newStartingYRTc =
					addMullionV.myParentBO.centerPointY - myY2;
		
		addMullionV.newStartingYLBa =
					addMullionV.myParentBO.centerPointY - myY1;
		
		addMullionV.newStartingYCenter =
					addMullionV.myParentBO.centerPointY - myYC;
		
		if (addMullionV.myParentBO.startingX
					+ addMullionV.newColW
					* addMullionV.iNo
					+ addMullionV.sumOfPrevMullions
					+ myMullion.thickness > addMullionV.myParentBO.centerPointX) {
			
			addMullionV.baseRT =
						addMullionV.newColW
						* addMullionV.iNo
						+ addMullionV.sumOfPrevMullions
						+ myMullion.thickness
						- addMullionV.myParentBO.centerPointX;
			
			addMullionV.baseLB =
						Math
						.abs(addMullionV.baseRT
									- myMullion.thickness);
			
			addMullionV.baseRTc =
						addMullionV.baseRT - myMullion.partDimC;
			addMullionV.baseLBa =
						addMullionV.baseLB + myMullion.partDimA;
			
			addMullionV.baseCenter =
						addMullionV.baseRT - myMullion.thickness / 2;
			
		} else {
			addMullionV.baseRT =
						addMullionV.myParentBO.centerPointX
						- (addMullionV.newColW
									* addMullionV.iNo
									+ addMullionV.sumOfPrevMullions + myMullion.thickness);
			
			addMullionV.baseLB =
						addMullionV.baseRT + myMullion.thickness;
			
			addMullionV.baseRTc =
						addMullionV.baseRT - myMullion.partDimC;
			addMullionV.baseLBa =
						addMullionV.baseLB + myMullion.partDimA;
			
			addMullionV.baseCenter =
						addMullionV.baseLB - myMullion.thickness / 2;
		}
		
		myMullion.centerYs =
					addMullionV.myParentBO.centerPointY
					- addMullionV.newStartingYCenter;
		
		myMullion.y1 = myY1;
		
		myMullion.y2 = myY2;
		
		myMullion.y1al = myY1;
		
		myMullion.y2cl = myY2;
		
		myMullion.length = myMullion.centerYe - myMullion.centerYs;
		myMullion.newStartingYLB = addMullionV.newStartingYLB;
		myMullion.newStartingYRT = addMullionV.newStartingYRT;
		myMullion.baseLB = addMullionV.baseLB;
		myMullion.baseRT = addMullionV.baseRT;
		
		myMullion.newStartingYLBa = addMullionV.newStartingYLBa;
		myMullion.newStartingYRTc = addMullionV.newStartingYRTc;
		myMullion.baseLBa = addMullionV.baseLBa;
		myMullion.baseRTc = addMullionV.baseRTc;
		
		addMullionV.xCoordBc = null;
		addMullionV.yCoordBc = null;
		return myMullion;
	}
	
	private Profiles botCoordsii(final Profiles myMullion) {
		
		// if (addMullionV.limitEnd.partForm == 1)
		// {
		
		double hypCenter = addMullionV.dimBM;
		hypCenter = getHypCenterEnd(hypCenter);
		
		if (myMullion.endTypeRB == 3) {
			
			doEndEndType3(myMullion);
		} else if (myMullion.endTypeRB == 2) {
			
			doEndEndType2(myMullion);
		} else {
			
			doEndEndType1(myMullion, hypCenter);
		}
		
		// }// / top > 1 && Radius =0
		
		// if (addMullionV.limitEnd.partForm == 2)
		// {
		//
		// this
		// .calculateCoordinArchIIB(myMullion);
		// setYe = true;
		// }
		return myMullion;
		
	}
	
	public void doEndEndType1(
				final Profiles myMullion,
				final double hypCenter) {

            if (myMullion.limitEndY3c != null && myMullion.limitEndY3c.cOrM == 0) {
                doEndEndType1P(myMullion, hypCenter);
            } else {
                doEndEndType1MC(myMullion, hypCenter);
            }
	}
	
	public void doEndEndType2(final Profiles myMullion) {

        if (myMullion.limitEndY3c != null && myMullion.limitEndY3c.cOrM == 0) {
            doEndEndType2P(myMullion);
        } else {
            doEndEndType2MC(myMullion);
        }
    }
	
	public void doEndEndType3(final Profiles myMullion) {

        if (myMullion.limitEndY3c != null && myMullion.limitEndY3c.cOrM == 0) {
            doEndEndType3P(myMullion);
        } else {
            doEndEndType3MC(myMullion);
        }
    }
	
	public void doEndEndType1P(
				final Profiles myMullion,
				final double hypCenter) {
		
		if (myMullion.limitEndY3c != null && myMullion.limitEndY3c.partForm == 1) {
			newYBotRTc =
						myMullion.y3a3 =
						myMullion.y3a =
						myMullion.y3cl =
						addMullionV
						.intersectY(
									addMullionV.newStartingXRTc,
									addMullionV.newStartingYRTc,
									myMullion.x3cl,
									newYBotRTc,
									myMullion.limitEndY3c.startXA,
									myMullion.limitEndY3c.startYA,
									myMullion.limitEndY3c.endXA,
									myMullion.limitEndY3c.endYA);
		}
		if (myMullion.limitEndY3c != null && myMullion.limitEndY3c.partForm >= 2) {
			newYBotRTc =
						myMullion.y3a3 =
						myMullion.y3a =
						myMullion.y3cl =
						arcX
						.getYusingX(
									addMullionV.newStartingXRTc,
									addMullionV.newStartingYRTc,
									myMullion.x3cl,
									newYBotRTc,
									myMullion.limitEndY3c.radius1A,
									myMullion.limitEndY3c.x1,
									myMullion.limitEndY3c.y1,
									true);
		}
		if (myMullion.limitEndY4a != null && myMullion.limitEndY4a.partForm == 1) {
			newYBotLBa =
						myMullion.y4a3 =
						myMullion.y4a =
						myMullion.y4al =
						addMullionV
						.intersectY(
									addMullionV.newStartingXLBa,
									addMullionV.newStartingYLBa, //
									myMullion.x4al, //
									newYBotLBa, //
									myMullion.limitEndY4a.startXA,
									myMullion.limitEndY4a.startYA,
									myMullion.limitEndY4a.endXA,
									myMullion.limitEndY4a.endYA);
		}
		if (myMullion.limitEndY4a != null && myMullion.limitEndY4a.partForm >= 2) {
			newYBotLBa =
						myMullion.y4a3 =
						myMullion.y4a =
						myMullion.y4al =
						arcX
						.getYusingX(
									addMullionV.newStartingXLBa,
									addMullionV.newStartingYLBa, //
									myMullion.x4al, //
									newYBotLBa, //
									myMullion.limitEndY4a.radius1A,
									myMullion.limitEndY4a.x1,
									myMullion.limitEndY4a.y1,
									true);
		}
		
		if (myMullion.limitEndY4a != null && myMullion.limitEndYC.partForm == 1) {
			newYBotCenter =
						myMullion.yce =
						myMullion.centerYe =
						addMullionV
						.intersectY(
									addMullionV.newStartingXCenter, //
									addMullionV.newStartingYCenter, //
									myMullion.centerXe, //
									newYBotCenter, //
									myMullion.limitEndYC.startXBA,
									myMullion.limitEndYC.startYBA
									+ hypCenter,
									myMullion.limitEndYC.endXBA,
									myMullion.limitEndYC.endYBA
									+ hypCenter);
		}
		if (myMullion.limitEndYC != null && myMullion.limitEndYC.partForm >= 2) {
			newYBotCenter =
						myMullion.yce =
						myMullion.centerYe =
						arcX
						.getYusingX(
									addMullionV.newStartingXCenter,
									addMullionV.newStartingYCenter,
									myMullion.centerXe,
									newYBotCenter,
									myMullion.limitEndYC.radius1BA
									+ hypCenter,
									myMullion.limitEndYC.x1,
									myMullion.limitEndYC.y1,
									true);
		}
		
		// newYBotRT =
		// myMullion.y3b =
		// myMullion.y3 =
		// addMullionV.intersectY(
		// myMullion.x3cl,
		// myMullion.y3cl,
		// myMullion.centerXe,
		// myMullion.centerYe,
		// addMullionV.newStartingXRT, addMullionV.newStartingYRT,
		// myMullion.x3,
		// newYBotRT);
		//
		// newYBotLB =
		// myMullion.y4b =
		// myMullion.y4 =
		// addMullionV.intersectY(
		// myMullion.x4al,
		// myMullion.y4al,
		// myMullion.centerXe,
		// myMullion.centerYe,
		// addMullionV.newStartingXLB,
		// addMullionV.newStartingYLB,
		// myMullion.x4,
		// newYBotLB);
		
		newYBotRT =
					myMullion.y3b = myMullion.y3 = addMullionV.intersectY(addMullionV.newStartingXRT,
								addMullionV.newStartingYRT, botXRT, newYBotRT, myMullion.limitEndY3c.startXBA,
								myMullion.limitEndY3c.startYBA, myMullion.limitEndY3c.endXBA, myMullion.limitEndY3c.endYBA);
		newYBotLB = myMullion.y4b = myMullion.y4 = addMullionV.intersectY(
					addMullionV.newStartingXLB,
					addMullionV.newStartingYLB, //
					botXLB, //
					newYBotLB, //
					myMullion.limitEndY4a.startXBA, myMullion.limitEndY4a.startYBA, myMullion.limitEndY4a.endXBA,
					myMullion.limitEndY4a.endYBA);
		
	}
	
	public void doEndEndType2P(final Profiles myMullion) {

		if (myMullion.limitEndY3c != null && myMullion.limitEndY3c.partForm == 1) {
			newYBotRTc =
						myMullion.y3a =
						myMullion.y3a3 =
						myMullion.y3cl =
						addMullionV
						.intersectY(
									myMullion.x3cl,
									addMullionV.newStartingYRTc,
									myMullion.x3cl,
									newYBotRTc,
									myMullion.limitEndY3c.startXC,
									myMullion.limitEndY3c.startYC,
									myMullion.limitEndY3c.endXC,
									myMullion.limitEndY3c.endYC);
		}
		if (myMullion.limitEndY3c != null && myMullion.limitEndY3c.partForm >= 2) {
			newYBotRTc =
						myMullion.y3a =
						myMullion.y3a3 =
						myMullion.y3cl =
						arcX
						.getYusingX(
									myMullion.x3cl,
									addMullionV.newStartingYRTc,
									myMullion.x3cl,
									newYBotRTc,
									myMullion.limitEndY3c.radius1,
									myMullion.limitEndY3c.x1,
									myMullion.limitEndY3c.y1,
									true);
		}
		
		if (myMullion.limitEndY3 != null && myMullion.limitEndY3.partForm == 1) {
			newYBotRT =
						myMullion.y3 =
						myMullion.y3b =
						addMullionV
						.intersectY(
									myMullion.x3,
									addMullionV.newStartingYRT,
									myMullion.x3,
									newYBotRT,
									myMullion.limitEndY3.startXC,
									myMullion.limitEndY3.startYC,
									myMullion.limitEndY3.endXC,
									myMullion.limitEndY3.endYC);
		}
		if (myMullion.limitEndY3c != null && myMullion.limitEndY3c.partForm >= 2) {
			newYBotRT =
						myMullion.y3 =
						myMullion.y3b =
						arcX
						.getYusingX(
									myMullion.x3,
									addMullionV.newStartingYRT,
									myMullion.x3,
									newYBotRT,
									myMullion.limitEndY3.radius1,
									myMullion.limitEndY3.x1,
									myMullion.limitEndY3.y1,
									true);
		}
		
		if (myMullion.limitEndY4a != null && myMullion.limitEndY4a.partForm == 1) {
			newYBotLBa =
						myMullion.y4a3 =
						myMullion.y4a =
						myMullion.y4al =
						addMullionV
						.intersectY(
									addMullionV.newStartingXLBa,
									addMullionV.newStartingYLBa, //
									myMullion.x4al, //
									newYBotLBa, //
									myMullion.limitEndY4a.startXC,
									myMullion.limitEndY4a.startYC,
									myMullion.limitEndY4a.endXC,
									myMullion.limitEndY4a.endYC);
		}
		if (myMullion.limitEndY4a != null && myMullion.limitEndY4a.partForm >= 2) {
			newYBotLBa =
						myMullion.y4a3 =
						myMullion.y4a =
						myMullion.y4al =
						arcX
						.getYusingX(
									addMullionV.newStartingXLBa,
									addMullionV.newStartingYLBa, //
									myMullion.x4al, //
									newYBotLBa, //
									myMullion.limitEndY4a.radius1,
									myMullion.limitEndY4a.x1,
									myMullion.limitEndY4a.y1,
									true);
		}
		
		if (myMullion.limitEndY4 != null && myMullion.limitEndY4.partForm == 1) {
			newYBotLB =
						myMullion.y4b =
						myMullion.y4 =
						addMullionV
						.intersectY(
									addMullionV.newStartingXLB,
									addMullionV.newStartingYLB, //
									myMullion.x4, //
									newYBotLB, //
									myMullion.limitEndY4.startXC,
									myMullion.limitEndY4.startYC,
									myMullion.limitEndY4.endXC,
									myMullion.limitEndY4.endYC);
		}
		if (myMullion.limitEndY4 != null && myMullion.limitEndY4.partForm >= 2) {
			newYBotLBa =
						myMullion.y4 =
						myMullion.y4b =
						arcX
						.getYusingX(
									addMullionV.newStartingXLB,
									addMullionV.newStartingYLB, //
									myMullion.x4, //
									newYBotLB, //
									myMullion.limitEndY4.radius1,
									myMullion.limitEndY4.x1,
									myMullion.limitEndY4.y1,
									true);
		}
		
		if (myMullion.limitEndYC != null && myMullion.limitEndYC.partForm == 1) {
			newYBotCenter =
						myMullion.yce =
						myMullion.centerYe =
						addMullionV
						.intersectY(
									addMullionV.newStartingXCenter, //
									addMullionV.newStartingYCenter, //
									myMullion.centerXe, //
									newYBotCenter, //
									myMullion.limitEndYC.startXC,
									myMullion.limitEndYC.startYC,
									myMullion.limitEndYC.endXC,
									myMullion.limitEndYC.endYC);
		}
		if (myMullion.limitEndYC != null && myMullion.limitEndYC.partForm >= 2) {
			newYBotCenter =
						myMullion.yce =
						myMullion.centerYe =
						arcX
						.getYusingX(
									addMullionV.newStartingXCenter,
									addMullionV.newStartingYCenter,
									myMullion.centerXe,
									newYBotCenter,
									myMullion.limitEndYC.radius1,
									myMullion.limitEndYC.x1,
									myMullion.limitEndYC.y1,
									true);
		}
		
	}
	
	public void doEndEndType3P(final Profiles myMullion) {
		
		if (myMullion.limitEndY3c != null && myMullion.limitEndY3c.partForm == 1) {
			newYBotRTc =
						myMullion.y3cl =
						addMullionV.intersectY(
                                myMullion.x3cl,
                                addMullionV.newStartingYRTc,
                                myMullion.x3cl,
                                newYBotRTc,
                                myMullion.limitEndY3c.startXBA, //
                                myMullion.limitEndY3c.startYBA, //
                                myMullion.limitEndY3c.endXBA, //
                                myMullion.limitEndY3c.endYBA //
                        );
			
			myMullion.y3a3 = myMullion.y3a = addMullionV.intersectY(
                    //
                    myMullion.x3cl, //
                    addMullionV.newStartingYRTc, //
                    myMullion.x3cl, //
                    newYBotRTc, //

                    myMullion.limitEndY3c.startXA, //
                    myMullion.limitEndY3c.startYA, //
                    myMullion.limitEndY3c.endXA, //
                    myMullion.limitEndY3c.endYA //
            );
		} else if (myMullion.limitEndY3c != null && myMullion.limitEndY3c.partForm >= 2) {
			newYBotRTc =
						myMullion.y3cl =
						arcX.getYusingX(
									myMullion.x3cl,
									addMullionV.newStartingYRTc,
									myMullion.x3cl,
									newYBotRTc,
									myMullion.limitEndY3c.radius1BA,
									myMullion.limitEndY3c.x1,
									myMullion.limitEndY3c.y1,
									true);
			
			myMullion.y3a3 =
						myMullion.y3a =
						arcX.getYusingX(
									myMullion.x3cl,
									addMullionV.newStartingYRTc,
									myMullion.x3cl,
									newYBotRTc,
									myMullion.limitEndY3c.radius1A,
									myMullion.limitEndY3c.x1,
									myMullion.limitEndY3c.y1,
									true);
			
		}
		
		if (myMullion.limitEndY3.partForm == 1) {
			newYBotRT =
						myMullion.y3 =
						addMullionV.intersectY(
									myMullion.x3,
									addMullionV.newStartingYRT,
									myMullion.x3,
									newYBotRT,
									myMullion.limitEndY3.startXBA, //
									myMullion.limitEndY3.startYBA, //
									myMullion.limitEndY3.endXBA, //
									myMullion.limitEndY3.endYBA //
									);


            myMullion.y3b = addMullionV.intersectY(
						//
						myMullion.x3, //
						addMullionV.newStartingYRT, //
						myMullion.x3, //
						newYBotRT, //
						
						myMullion.limitEndY3.startXA, //
						myMullion.limitEndY3.startYA, //
						myMullion.limitEndY3.endXA, //
						myMullion.limitEndY3.endYA //
						);
            
		} else if (myMullion.limitEndY3 != null && myMullion.limitEndY3.partForm >= 2) {
			newYBotRT =
						myMullion.y3 =
						arcX.getYusingX(
									myMullion.x3,
									addMullionV.newStartingYRT,
									myMullion.x3,
									newYBotRT,
									myMullion.limitEndY3.radius1BA,
									myMullion.limitEndY3.x1,
									myMullion.limitEndY3.y1,
									true);
			
			myMullion.y3b =
						arcX.getYusingX(
									myMullion.x3,
									addMullionV.newStartingYRT,
									myMullion.x3,
									newYBotRT,
									myMullion.limitEndY3.radius1A,
									myMullion.limitEndY3.x1,
									myMullion.limitEndY3.y1,
									true);
			
		}
		
		if (myMullion.limitEndY4a != null && myMullion.limitEndY4a.partForm == 1) {

			newYBotLBa = myMullion.y4al = addMullionV.intersectY(
                    //
                    myMullion.x4al, //
                    addMullionV.newStartingYLBa, //
                    myMullion.x4al, //
                    newYBotLBa,
                    myMullion.limitEndY4a.startXBA, //
                    myMullion.limitEndY4a.startYBA, //
                    myMullion.limitEndY4a.endXBA, //
                    myMullion.limitEndY4a.endYBA //
            );
			
			myMullion.y4a3 = myMullion.y4a = addMullionV.intersectY(
                    //
                    myMullion.x4al, //
                    addMullionV.newStartingYLBa, //
                    myMullion.x4al, //
                    newYBotLBa,
                    myMullion.limitEndY4a.startXA, //
                    myMullion.limitEndY4a.startYA, //
                    myMullion.limitEndY4a.endXA, //
                    myMullion.limitEndY4a.endYA //
            );
			
		} else if (myMullion.limitEndY4a != null && myMullion.limitEndY4a.partForm >= 2) {
			newYBotLBa =
						myMullion.y4al = arcX.getYusingX(myMullion.x4al, //
									addMullionV.newStartingYLBa, //
									myMullion.x4al, //
									newYBotLBa,
									myMullion.limitEndY4a.radius1BA,
									myMullion.limitEndY4a.x1,
									myMullion.limitEndY4a.y1,
									true);
			
			myMullion.y4a3 =
						myMullion.y4a = arcX.getYusingX(myMullion.x4al, //
									addMullionV.newStartingYLBa, //
									myMullion.x4al, //
									newYBotLBa,
									myMullion.limitEndY4a.radius1A,
									myMullion.limitEndY4a.x1,
									myMullion.limitEndY4a.y1,
									true);
			
		}
		
		if (myMullion.limitEndY4 != null && myMullion.limitEndY4.partForm == 1) {

			newYBotLBa = myMullion.y4 = addMullionV.intersectY(
                    //
                    myMullion.x4, //
                    addMullionV.newStartingYLB, //
                    myMullion.x4, //
                    newYBotLB,
                    myMullion.limitEndY4.startXBA, //
                    myMullion.limitEndY4.startYBA, //
                    myMullion.limitEndY4.endXBA, //
                    myMullion.limitEndY4.endYBA //
            );
			
			myMullion.y4b = addMullionV.intersectY(myMullion.x4, //
                    addMullionV.newStartingYLB, //
                    myMullion.x4, //
                    newYBotLB,
                    myMullion.limitEndY4.startXA, //
                    myMullion.limitEndY4.startYA, //
                    myMullion.limitEndY4.endXA, //
                    myMullion.limitEndY4.endYA //
            );
			
		} else if (myMullion.limitEndY4 != null && myMullion.limitEndY4.partForm >= 2) {

			newYBotLB = myMullion.y4 = arcX.getYusingX(myMullion.x4, //
						addMullionV.newStartingYLB, //
						myMullion.x4, //
						newYBotLB,
						myMullion.limitEndY4.radius1BA,
						myMullion.limitEndY4.x1,
						myMullion.limitEndY4.y1,
						true);
			
			myMullion.y4b = arcX.getYusingX(myMullion.x4, //
						addMullionV.newStartingYLB, //
						myMullion.x4, //
						newYBotLB,
						myMullion.limitEndY4.radius1A,
						myMullion.limitEndY4.x1,
						myMullion.limitEndY4.y1,
						true);
			
		}
		
		if (myMullion.limitEndYC != null && myMullion.limitEndYC.partForm == 1) {
			newYBotCenter =
						myMullion.centerYe =
						addMullionV.intersectY(
                                myMullion.centerXe,
                                addMullionV.newStartingYCenter,
                                myMullion.centerXe,
                                newYBotCenter,
                                myMullion.limitEndYC.startXBA,
                                myMullion.limitEndYC.startYBA,
                                myMullion.limitEndYC.endXBA,
                                myMullion.limitEndYC.endYBA);
			
			myMullion.yce =
						addMullionV.intersectY(
                                myMullion.centerXe,
                                addMullionV.newStartingYCenter,
                                myMullion.centerXe,
                                newYBotCenter,
                                myMullion.limitEndYC.startXA,
                                myMullion.limitEndYC.startYA,
                                myMullion.limitEndYC.endXA,
                                myMullion.limitEndYC.endYA);
			
		} else if (myMullion.limitEndY4 != null && myMullion.limitEndY4.partForm >= 2) {
			newYBotCenter =
						myMullion.centerYe =
						arcX.getYusingX(
									myMullion.centerXe,
									addMullionV.newStartingYCenter,
									myMullion.centerXe,
									newYBotCenter,
									myMullion.limitEndYC.radius1BA,
									myMullion.limitEndYC.x1,
									myMullion.limitEndYC.y1,
									true);
			
			myMullion.yce =
						arcX.getYusingX(
									myMullion.centerXe,
									addMullionV.newStartingYCenter,
									myMullion.centerXe,
									newYBotCenter,
									myMullion.limitEndYC.radius1A,
									myMullion.limitEndYC.x1,
									myMullion.limitEndYC.y1,
									true);
			
		}
		
	}
	
	public void doEndEndType1MC(
				final Profiles myMullion,
				final double hypCenter) {
		
		if (myMullion.limitEndY3c != null && myMullion.limitEndY3c.partForm == 1) {
			newYBotRTc =
						myMullion.y3a3 =
						myMullion.y3a =
						myMullion.y3cl =
						addMullionV
						.intersectY(
									addMullionV.newStartingXRTc,
									addMullionV.newStartingYRTc,
									myMullion.x3cl,
									newYBotRTc,
									myMullion.limitEndY3c.x2cl,
									myMullion.limitEndY3c.y2cl,
									myMullion.limitEndY3c.x3cl,
									myMullion.limitEndY3c.y3cl);
		}
		if (myMullion.limitEndY3c != null && myMullion.limitEndY3c.partForm >= 2) {
			newYBotRTc =
						myMullion.y3a3 =
						myMullion.y3a =
						myMullion.y3cl =
						arcX
						.getYusingX(
									addMullionV.newStartingXRTc,
									addMullionV.newStartingYRTc,
									myMullion.x3cl,
									newYBotRTc,
									myMullion.limitEndY3c.radiusXY2cl,
									myMullion.limitEndY3c.x1,
									myMullion.limitEndY3c.y1,
									true);
		}
		if (myMullion.limitEndY4a != null && myMullion.limitEndY4a.partForm == 1) {
			newYBotLBa =
						myMullion.y4a3 =
                        myMullion.y4a =
						myMullion.y4al =
						addMullionV
						.intersectY(
									addMullionV.newStartingXLBa,
									addMullionV.newStartingYLBa, //
									myMullion.x4al, //
									newYBotLBa, //
									myMullion.limitEndY4a.x2cl,
									myMullion.limitEndY4a.y2cl,
									myMullion.limitEndY4a.x3cl,
									myMullion.limitEndY4a.y2cl);
		}
        
		if (myMullion.limitEndY4a != null && myMullion.limitEndY4a.partForm >= 2) {
			newYBotLBa =
						myMullion.y4a3 =
						myMullion.y4a =
						myMullion.y4al =
						arcX
						.getYusingX(
									addMullionV.newStartingXLBa,
									addMullionV.newStartingYLBa, //
									myMullion.x4al, //
									newYBotLBa, //
									myMullion.limitEndY4a.radiusXY2cl,
									myMullion.limitEndY4a.x1,
									myMullion.limitEndY4a.y1,
									true);
		}
		
		if (myMullion.limitEndYC != null && myMullion.limitEndYC.partForm == 1) {
			newYBotCenter =
						myMullion.yce =
						myMullion.centerYe =
						addMullionV
						.intersectY(
									addMullionV.newStartingXCenter, //
									addMullionV.newStartingYCenter, //
									myMullion.centerXe, //
									newYBotCenter, //
									myMullion.limitEndYC.x2,
									myMullion.limitEndYC.y2
									+ hypCenter,
									myMullion.limitEndYC.x3,
									myMullion.limitEndYC.y3
									+ hypCenter);
		}
		if (myMullion.limitEndYC != null && myMullion.limitEndYC.partForm >= 2) {
			newYBotCenter =
						myMullion.yce =
						myMullion.centerYe =
						arcX
						.getYusingX(
									addMullionV.newStartingXCenter,
									addMullionV.newStartingYCenter,
									myMullion.centerXe,
									newYBotCenter,
									myMullion.limitEndYC.radiusXY2
									+ hypCenter,
									myMullion.limitEndYC.x1,
									myMullion.limitEndYC.y1,
									true);
		}
		
		newYBotRT =
					myMullion.y3b =
					myMullion.y3 =
					addMullionV.intersectY(
//								myMullion.x3cl,
//								myMullion.y3cl,
//								myMullion.centerXe,
//								myMullion.centerYe,
							
							addMullionV.newStartingXRT,
							addMullionV.newStartingYRT,
							myMullion.x3,
							newYBotRTc,
							
							
//								addMullionV.newStartingXRT, addMullionV.newStartingYRT,
//								myMullion.x3,
//								newYBotRT
								myMullion.limitEndY3c.x2,
								myMullion.limitEndY3c.y2,
								myMullion.limitEndY3c.x3,
								myMullion.limitEndY3c.y3);

		
		newYBotLB =
					myMullion.y4b =
					myMullion.y4 =
					addMullionV.intersectY(
//								myMullion.x4al,
//								myMullion.y4al,
//								myMullion.centerXe,
//								myMullion.centerYe,
							
							addMullionV.newStartingXLB,
							addMullionV.newStartingYLB, //
							myMullion.x4, //
							newYBotLB, //
							
								myMullion.limitEndY3c.x2,
								myMullion.limitEndY3c.y2,
								myMullion.limitEndY3c.x3,
								myMullion.limitEndY3c.y3);
		
//								addMullionV.newStartingXLB,
//								addMullionV.newStartingYLB,
//								myMullion.x4,
//								newYBotLB);
	}
	
	public void doEndEndType2MC(final Profiles myMullion) {
		
		// if(myMullion.limitEndY3c.partForm==1) {
		// newYBotRTc = myMullion.y3a = myMullion.y3a3 =
		// myMullion.y3cl =
		// addMullionV
		// .intersectY(
		// myMullion.x3cl,
		// addMullionV.newStartingYRTc,
		// myMullion.x3cl,
		// newYBotRTc,
		// myMullion.limitEndY3c.startXC,
		// myMullion.limitEndY3c.startYC,
		// myMullion.limitEndY3c.endXC,
		// myMullion.limitEndY3c.endYC );
		//
		// }if(myMullion.limitEndY3c.partForm>=2) {
		// newYBotRTc = myMullion.y3a = myMullion.y3a3 =
		// myMullion.y3cl =
		// arcX.getYusingX(
		// myMullion.x3cl,
		// addMullionV.newStartingYRTc,
		// myMullion.x3cl,
		// newYBotRTc,
		// myMullion.limitEndY3c.radius1,
		// myMullion.limitEndY3c.x1,
		// myMullion.limitEndY3c.y1,
		// true);
		// }
		//
		// if(myMullion.limitEndY3.partForm==1) {
		// newYBotRT = myMullion.y3 = myMullion.y3b =
		// addMullionV
		// .intersectY(
		// myMullion.x3,
		// addMullionV.newStartingYRT,
		// myMullion.x3,
		// newYBotRT,
		// myMullion.limitEndY3.startXC,
		// myMullion.limitEndY3.startYC,
		// myMullion.limitEndY3.endXC,
		// myMullion.limitEndY3.endYC );
		// }if(myMullion.limitEndY3c.partForm>=2) {
		// newYBotRT = myMullion.y3 = myMullion.y3b =
		// arcX.getYusingX(
		// myMullion.x3,
		// addMullionV.newStartingYRT,
		// myMullion.x3,
		// newYBotRT,
		// myMullion.limitEndY3.radius1,
		// myMullion.limitEndY3.x1,
		// myMullion.limitEndY3.y1,
		// true);
		// }
		//
		// if(myMullion.limitEndY4a.partForm==1) {
		// newYBotLBa = myMullion.y4a3 = myMullion.y4a =
		// myMullion.y4al=
		// addMullionV.intersectY(
		// addMullionV.newStartingXLBa,
		// addMullionV.newStartingYLBa, //
		// myMullion.x4al, //
		// newYBotLBa, //
		// myMullion.limitEndY4a.startXC,
		// myMullion.limitEndY4a.startYC,
		// myMullion.limitEndY4a.endXC,
		// myMullion.limitEndY4a.endYC );
		// }
		// if(myMullion.limitEndY4a.partForm>=2) {
		// newYBotLBa = myMullion.y4a3 = myMullion.y4a =
		// myMullion.y4al=
		// arcX.getYusingX(
		// addMullionV.newStartingXLBa,
		// addMullionV.newStartingYLBa, //
		// myMullion.x4al, //
		// newYBotLBa, //
		// myMullion.limitEndY4a.radius1,
		// myMullion.limitEndY4a.x1,
		// myMullion.limitEndY4a.y1,
		// true);
		// }
		//
		//
		// if(myMullion.limitEndY4.partForm==1) {
		// newYBotLB = myMullion.y4b = myMullion.y4=
		// addMullionV.intersectY(
		// addMullionV.newStartingXLB,
		// addMullionV.newStartingYLB, //
		// myMullion.x4, //
		// newYBotLB, //
		// myMullion.limitEndY4.startXC,
		// myMullion.limitEndY4.startYC,
		// myMullion.limitEndY4.endXC,
		// myMullion.limitEndY4.endYC );
		// }
		// if(myMullion.limitEndY4.partForm>=2) {
		// newYBotLBa = myMullion.y4 = myMullion.y4b =
		// arcX.getYusingX(
		// addMullionV.newStartingXLB,
		// addMullionV.newStartingYLB, //
		// myMullion.x4, //
		// newYBotLB, //
		// myMullion.limitEndY4.radius1,
		// myMullion.limitEndY4.x1,
		// myMullion.limitEndY4.y1,
		// true);
		// }
		//
		//
		//
		// if(myMullion.limitEndYC.partForm==1) {
		// newYBotCenter = myMullion.yce= myMullion.centerYe=
		// addMullionV.intersectY(
		// addMullionV.newStartingXCenter, //
		// addMullionV.newStartingYCenter, //
		// myMullion.centerXe, //
		// newYBotCenter, //
		// myMullion.limitEndYC.startXC,
		// myMullion.limitEndYC.startYC,
		// myMullion.limitEndYC.endXC,
		// myMullion.limitEndYC.endYC );
		// }
		// if(myMullion.limitEndYC.partForm>=2) {
		// newYBotCenter = myMullion.yce= myMullion.centerYe=
		// arcX.getYusingX(
		// addMullionV.newStartingXCenter,
		// addMullionV.newStartingYCenter,
		// myMullion.centerXe,
		// newYBotCenter,
		// myMullion.limitEndYC.radius1,
		// myMullion.limitEndYC.x1,
		// myMullion.limitEndYC.y1,
		// true);
		// }
		//
		
		doEndEndType3MC(myMullion);
		
	}
	
	public void doEndEndType3MC(final Profiles myMullion) {
		
		if (myMullion.limitEndY3c != null && myMullion.limitEndY3c.partForm == 1) {
			newYBotRTc =
						myMullion.y3cl =
						addMullionV.intersectY(
                                myMullion.x3cl,
                                addMullionV.newStartingYRTc,
                                myMullion.x3cl,
                                newYBotRTc,
                                myMullion.limitEndY3c.x2, //
                                myMullion.limitEndY3c.y2, //
                                myMullion.limitEndY3c.x3, //
                                myMullion.limitEndY3c.y3 //
                        );
			
			myMullion.y3a3 = myMullion.y3a = addMullionV.intersectY(
                    //
                    myMullion.x3cl, //
                    addMullionV.newStartingYRTc, //
                    myMullion.x3cl, //
                    newYBotRTc, //

                    myMullion.limitEndY3c.x2cl, //
                    myMullion.limitEndY3c.y2cl, //
                    myMullion.limitEndY3c.x3cl, //
                    myMullion.limitEndY3c.y3cl //
            );
		} else if (myMullion.limitEndY3c != null && myMullion.limitEndY3c.partForm >= 2) {
			newYBotRTc =
						myMullion.y3cl =
						arcX.getYusingX(
									myMullion.x3cl,
									addMullionV.newStartingYRTc,
									myMullion.x3cl,
									newYBotRTc,
									myMullion.limitEndY3c.radiusXY2,
									myMullion.limitEndY3c.x1,
									myMullion.limitEndY3c.y1,
									true);
			
			myMullion.y3a3 =
						myMullion.y3a =
						arcX
						.getYusingX(
									myMullion.x3cl,
									addMullionV.newStartingYRTc,
									myMullion.x3cl,
									newYBotRTc,
									myMullion.limitEndY3c.radiusXY2cl,
									myMullion.limitEndY3c.x1,
									myMullion.limitEndY3c.y1,
									true);
			
		}
		
		if (myMullion.limitEndY3 != null && myMullion.limitEndY3.partForm == 1) {
			newYBotRT =
						myMullion.y3 =
						addMullionV.intersectY(
									myMullion.x3,
									addMullionV.newStartingYRT,
									myMullion.x3,
									newYBotRT,
									myMullion.limitEndY3.x2, //
									myMullion.limitEndY3.y2, //
									myMullion.limitEndY3.x3, //
									myMullion.limitEndY3.y3 //
									);
			
			myMullion.y3b = addMullionV.intersectY(
						//
						myMullion.x3, //
						addMullionV.newStartingYRT, //
						myMullion.x3, //
						newYBotRT, //
						
						myMullion.limitEndY3.x2cl, //
						myMullion.limitEndY3.y2cl, //
						myMullion.limitEndY3.x3cl, //
						myMullion.limitEndY3.y3cl //
						);
		} else if (myMullion.limitEndY3 != null && myMullion.limitEndY3.partForm >= 2) {
			newYBotRT =
						myMullion.y3 =
						arcX.getYusingX(
									myMullion.x3,
									addMullionV.newStartingYRT,
									myMullion.x3,
									newYBotRT,
									myMullion.limitEndY3.radiusXY2,
									myMullion.limitEndY3.x1,
									myMullion.limitEndY3.y1,
									true);
			
			myMullion.y3b =
						arcX.getYusingX(
									myMullion.x3,
									addMullionV.newStartingYRT,
									myMullion.x3,
									newYBotRT,
									myMullion.limitEndY3.radiusXY2cl,
									myMullion.limitEndY3.x1,
									myMullion.limitEndY3.y1,
									true);
			
		}
		
		if (myMullion.limitEndY4a != null && myMullion.limitEndY4a.partForm == 1) {

			newYBotLBa = myMullion.y4al = addMullionV.intersectY(
						//
						myMullion.x4al, //
						addMullionV.newStartingYLBa, //
						myMullion.x4al, //
						newYBotLBa,
						myMullion.limitEndY3c.x2, //
						myMullion.limitEndY3c.y2, //
						myMullion.limitEndY3c.x3, //
						myMullion.limitEndY3c.y3 //
						);
			
			myMullion.y4a3 = myMullion.y4a = addMullionV.intersectY(
						//
						myMullion.x4al, //
						addMullionV.newStartingYLBa, //
						myMullion.x4al, //
						newYBotLBa,
						myMullion.limitEndY3c.x2cl, //
						myMullion.limitEndY3c.y2cl, //
						myMullion.limitEndY3c.x3cl, //
						myMullion.limitEndY3c.y3cl //
						);
			
		} else if (myMullion.limitEndY4a != null && myMullion.limitEndY4a.partForm >= 2) {
			newYBotLBa =
						myMullion.y4al = arcX.getYusingX(myMullion.x4al, //
									addMullionV.newStartingYLBa, //
									myMullion.x4al, //
									newYBotLBa,
									myMullion.limitEndY4a.radiusXY2,
									myMullion.limitEndY4a.x1,
									myMullion.limitEndY4a.y1,
									true);
			
			myMullion.y4a3 =
						myMullion.y4a = arcX.getYusingX(myMullion.x4al, //
									addMullionV.newStartingYLBa, //
									myMullion.x4al, //
									newYBotLBa,
									myMullion.limitEndY4a.radiusXY2cl,
									myMullion.limitEndY4a.x1,
									myMullion.limitEndY4a.y1,
									true);
			
		}
		
		if (myMullion.limitEndY4 != null && myMullion.limitEndY4.partForm == 1) {
			newYBotLBa = myMullion.y4 = addMullionV.intersectY(
						//
						myMullion.x4, //
						addMullionV.newStartingYLB, //
						myMullion.x4, //
						newYBotLB,
						myMullion.limitEndY3c.x2, //
						myMullion.limitEndY3c.y2, //
						myMullion.limitEndY3c.x3, //
						myMullion.limitEndY3c.y3 //
						);
			
			myMullion.y4b = addMullionV.intersectY(myMullion.x4, //
						addMullionV.newStartingYLB, //
						myMullion.x4, //
						newYBotLB,
						myMullion.limitEndY3c.x2cl, //
						myMullion.limitEndY3c.y2cl, //
						myMullion.limitEndY3c.x3cl, //
						myMullion.limitEndY3c.y3cl //
						);
			
		} else if (myMullion.limitEndY4 != null && myMullion.limitEndY4.partForm >= 2) {
			newYBotLB = myMullion.y4 = arcX.getYusingX(myMullion.x4, //
						addMullionV.newStartingYLB, //
						myMullion.x4, //
						newYBotLB,
						myMullion.limitEndY4.radiusXY2,
						myMullion.limitEndY4.x1,
						myMullion.limitEndY4.y1,
						true);
			
			myMullion.y4b = arcX.getYusingX(myMullion.x4, //
						addMullionV.newStartingYLB, //
						myMullion.x4, //
						newYBotLB,
						myMullion.limitEndY4.radiusXY2cl,
						myMullion.limitEndY4.x1,
						myMullion.limitEndY4.y1,
						true);
			
		}
		
		if (myMullion.limitEndYC != null && myMullion.limitEndYC.partForm == 1) {
			newYBotCenter =
						myMullion.centerYe =
						addMullionV.intersectY(
                                myMullion.centerXe,
                                addMullionV.newStartingYCenter,
                                myMullion.centerXe,
                                newYBotCenter,
                                myMullion.limitEndY3c.x2, //
                                myMullion.limitEndY3c.y2, //
                                myMullion.limitEndY3c.x3, //
                                myMullion.limitEndY3c.y3 //
                        );
			
			myMullion.yce =
						addMullionV.intersectY(
                                myMullion.centerXe,
                                addMullionV.newStartingYCenter,
                                myMullion.centerXe,
                                newYBotCenter,
                                myMullion.limitEndY3c.x2cl, //
                                myMullion.limitEndY3c.y2cl, //
                                myMullion.limitEndY3c.x3cl, //
                                myMullion.limitEndY3c.y3cl //
                        );
			
		} else if (myMullion.limitEndY4 != null && myMullion.limitEndY4.partForm >= 2) {
			newYBotCenter =
						myMullion.centerYe =
						arcX.getYusingX(
									myMullion.centerXe,
									addMullionV.newStartingYCenter,
									myMullion.centerXe,
									newYBotCenter,
									myMullion.limitEndYC.radiusXY2,
									myMullion.limitEndYC.x1,
									myMullion.limitEndYC.y1,
									true);
			
			myMullion.yce =
						arcX.getYusingX(
									myMullion.centerXe,
									addMullionV.newStartingYCenter,
									myMullion.centerXe,
									newYBotCenter,
									myMullion.limitEndYC.radiusXY2cl,
									myMullion.limitEndYC.x1,
									myMullion.limitEndYC.y1,
									true);
			
		}
		
	}
	
	public double getHypCenterEnd(double hypCenter) {
		
		if (addMullionV.myThetaBot > 0) {
			hypCenter =
						addMullionV.dimBM / Math
						.sin(addMullionV.myThetaBot);
		} else if (addMullionV.thetaOffset > 0) {
			hypCenter =
						addMullionV.dimTM / Math
						.sin(addMullionV.thetaOffset);
		}
		return hypCenter;
	}
	
}

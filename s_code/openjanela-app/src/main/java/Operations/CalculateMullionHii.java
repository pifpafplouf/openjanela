/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 * 
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Operations;


import java.awt.geom.Point2D;

import Model.ProfileParts.Profiles;


public class CalculateMullionHii
{
	
	AddMullionH addMullionH;
	
	// double myThetaRight = 0;
	// double myThetaRight2 = 0;
	// double myThetaRight3 = 0;
	// double myThetaRightA = 0;
	// double myThetaRightC = 0;
	double baseRTRight = 0;
	
	double baseLBRight = 0;
	
	double baseRTRightc = 0;
	
	double baseLBRighta = 0;
	
	double baseCenterRight = 0;
	
	double newXRightRT = 0;
	
	double newXRightLB = 0;
	
	double newXRightRTc = 0;
	
	double newXRightLBa = 0;
	
	double newXRightCenter = 0;
	
	double rightXRT = 0;
	
	double rightXRTc = 0;
	
	double rightXLB = 0;
	
	double rightXLBa = 0;
	
	double rightXCenter = 0;
	
	boolean setXs = false;
	
	boolean setXe = false;
	
	double x1a3 = 0;
	
	double y1a3 = 0;
	
	double x2a3 = 0;
	
	double y2a3 = 0;
	
	double x3a3 = 0;
	
	double y3a3 = 0;
	
	double x4a3 = 0;
	
	double y4a3 = 0;
	
	public CalculateMullionHii(final AddMullionH parent)
	{
		
		addMullionH = parent;
		// TODO Auto-generated constructor stub
	}
	
	public void setInitValues(final Profiles myMullion)
	{
		
		addMullionH.newStartingXRT =
					addMullionH.myParentBO.myParent.startingX;
		
		addMullionH.newStartingXLB =
					addMullionH.myParentBO.myParent.startingX;
		
		addMullionH.newStartingXRTc =
					addMullionH.myParentBO.myParent.startingX;
		
		addMullionH.newStartingXLBa =
					addMullionH.myParentBO.myParent.startingX;
		
		addMullionH.newStartingXCenter =
					addMullionH.myParentBO.myParent.startingX;
		
		rightXRT = addMullionH.myParentBO.myParent.bX2;
		rightXRTc = addMullionH.myParentBO.myParent.bX2;
		rightXLB = addMullionH.myParentBO.myParent.bX2;
		rightXLBa = addMullionH.myParentBO.myParent.bX2;
		rightXCenter = addMullionH.myParentBO.myParent.bX2;
		
		newXRightRT = addMullionH.myParentBO.myParent.bX2;
		newXRightLB = addMullionH.myParentBO.myParent.bX2;
		newXRightRTc = addMullionH.myParentBO.myParent.bX2;
		newXRightLBa = addMullionH.myParentBO.myParent.bX2;
		newXRightCenter = addMullionH.myParentBO.myParent.bX2;
		setXs = false;
		setXe = false;
		x1a3 = 0;
		y1a3 = 0;
		x2a3 = 0;
		y2a3 = 0;
		x3a3 = 0;
		y3a3 = 0;
		x4a3 = 0;
		y4a3 = 0;
		
	}
	
	public Profiles calculateCoord(final Profiles myMullion)
	{
		
		this.setInitValues(myMullion);
		// // Top Ys
		
		if (addMullionH.inArchL == 0)
		{
			double hypCenter = addMullionH.dimLM;
			if (addMullionH.newAlpha > 0)
			{
				hypCenter =
							addMullionH.dimLM
							/ Math.sin(Math.toRadians(90)
										- addMullionH.newAlpha);
			}
			
			if (myMullion.endTypeLT == 3 || myMullion.cOrM == 1)
			{
				
				doStartEndType3(myMullion);
				
			}
			else if (myMullion.endTypeLT == 2)
			{
				
				doStartEndType2(myMullion, hypCenter);
				
			}
			else
			{
				doStartEndType1(myMullion, hypCenter);
			}
			
			// /////
			
		}
		
		// / top == 1 && Radius >0 && topform ==2
		
		if (addMullionH.inArchL == 1)
		{
			
			this.calculateCoordinArchIIL(myMullion);
			
		}
		if (addMullionH.inArchL == 3)
		{
			
			this.getCCoordinatesForEllipse(myMullion);
			
		}
		// //////////// TOP Finished
		
		// ////////////BOT Start
		this.rightCoords(myMullion);
		
		// ////////////////////
		if (!setXs)
		{
			
			myMullion.centerXs = addMullionH.newStartingXCenter;
			myMullion.x1 = myMullion.x1a = addMullionH.newStartingXLB;
			
			myMullion.x2 = myMullion.x2a = addMullionH.newStartingXRT;
			
			myMullion.x1al = addMullionH.newStartingXLBa;
			
			myMullion.x2cl = addMullionH.newStartingXRTc;
		}
		
		if (!setXe)
		{
			if (myMullion.rowCol == addMullionH.newHCRow
						&& myMullion.startPos == addMullionH.newHCCol
						&& myMullion.endPos == addMullionH.hcEnd)
			{
				
				myMullion.centerXe = newXRightCenter;
				myMullion.x4 = newXRightLB;
				myMullion.x3 = newXRightRT;
				myMullion.x4a = newXRightLB;
				myMullion.x3a = newXRightRT;
				
				myMullion.x4al = newXRightLBa;
				
				myMullion.x3cl = newXRightRTc;
				
			}
			else
			{
				myMullion.centerXe = newXRightCenter;
				myMullion.x4 = newXRightLB;
				myMullion.x3 = newXRightRT;
				myMullion.x4a = newXRightLB;
				myMullion.x3a = newXRightRT;
				myMullion.x4al = newXRightLBa;
				myMullion.x3cl = newXRightRTc;
			}
		}
		
		if (x1a3 > 0)
		{
			myMullion.x1a3 = x1a3;
			myMullion.x2a3 = x2a3;
			
		}
		if (x3a3 > 0)
		{
			myMullion.x3a3 = x3a3;
			myMullion.x4a3 = x4a3;
		}
		if (myMullion.cOrM == 2)
		{
			myMullion.glazedInOut();
		}
		if (myMullion.cOrM == 1)
		{
			myMullion.couplerDraw();
		}
		
		return myMullion;
	}
	
	public void doStartEndType1(
				final Profiles myMullion,
				final double hypCenter)
	{
		
		addMullionH.newStartingXRTc = addMullionH.intersectX(
					//
					addMullionH.newStartingXRTc, //
					myMullion.y2cl, //
					rightXRTc, //
					myMullion.y2cl, //
					
					addMullionH.limitStartXsA, //
					addMullionH.limitStartYsA, //
					addMullionH.limitStartXeA, //
					addMullionH.limitStartYeA//
					);
		
		addMullionH.newStartingXRT = addMullionH.intersectX(
					//
					addMullionH.newStartingXRT, //
					myMullion.y2, //
					rightXRTc, //
					myMullion.y2, //
					
					addMullionH.limitStartXsBA, //
					addMullionH.limitStartYsBA, //
					addMullionH.limitStartXeBA, //
					addMullionH.limitStartYeBA//
					);
		
		addMullionH.newStartingXLBa = addMullionH.intersectX(
					//
					addMullionH.newStartingXLBa, //
					myMullion.y1al, //
					rightXLBa, //
					myMullion.y1al, //
					//
					addMullionH.limitStartXsA, //
					addMullionH.limitStartYsA, //
					addMullionH.limitStartXeA, //
					addMullionH.limitStartYeA//
					);
		
		addMullionH.newStartingXLB = addMullionH.intersectX(
					//
					addMullionH.newStartingXLBa, //
					myMullion.y1, //
					rightXLBa, //
					myMullion.y1, //
					//
					addMullionH.limitStartXsBA, //
					addMullionH.limitStartYsBA, //
					addMullionH.limitStartXeBA, //
					addMullionH.limitStartYeBA//
					);
		
		addMullionH.newStartingXCenter = addMullionH.intersectX(
					//
					addMullionH.newStartingXCenter, //
					myMullion.centerYs, //
					rightXCenter, //
					myMullion.centerYs, //
					//
					addMullionH.limitStartXsBA - hypCenter, //
					addMullionH.limitStartYsBA, //
					addMullionH.limitStartXeBA - hypCenter, //
					addMullionH.limitStartYeBA
					//
					);
		
		// addMullionH.newStartingXRT = addMullionH.intersectX(
		// //
		// addMullionH.newStartingXRTc, //
		// addMullionH.newStartingYRTc, //
		// addMullionH.newStartingXCenter,
		// myMullion.centerYs, //
		//
		// addMullionH.newStartingXRT, //
		// myMullion.y2, //
		// rightXRT, //
		// myMullion.y2 // y3
		//
		// //
		// );
		//
		// addMullionH.newStartingXLB = addMullionH.intersectX(
		// //
		// //
		// addMullionH.newStartingXLBa, //
		// addMullionH.newStartingYLBa, //
		// addMullionH.newStartingXCenter,
		// myMullion.centerYs, //
		// //
		// addMullionH.newStartingXLB, //
		// myMullion.y1, //
		// rightXLB, //
		// myMullion.y1 // y4
		//
		// );
	}
	
	public void doStartEndType2(final Profiles myMullion, final double hypCenter)
	{
		
		addMullionH.newStartingXRTc = addMullionH.intersectX(
					//
					addMullionH.newStartingXRTc, //
					myMullion.y2cl, //
					rightXRTc, //
					myMullion.y2cl, //
					
					addMullionH.limitStartXsBA, //
					addMullionH.limitStartYsBA, //
					addMullionH.limitStartXeBA, //
					addMullionH.limitStartYeBA//
					);
		
		addMullionH.newStartingXRT = addMullionH.intersectX(
					//
					addMullionH.newStartingXRT, //
					myMullion.y2, //
					rightXRTc, //
					myMullion.y2, //
					
					addMullionH.limitStartXsBA, //
					addMullionH.limitStartYsBA, //
					addMullionH.limitStartXeBA, //
					addMullionH.limitStartYeBA//
					);
		
		addMullionH.newStartingXLBa = addMullionH.intersectX(
					//
					addMullionH.newStartingXLBa, //
					myMullion.y1al, //
					rightXLBa, //
					myMullion.y1al, //
					//
					addMullionH.limitStartXsBA, //
					addMullionH.limitStartYsBA, //
					addMullionH.limitStartXeBA, //
					addMullionH.limitStartYeBA//
					);
		
		addMullionH.newStartingXLB = addMullionH.intersectX(
					//
					addMullionH.newStartingXLBa, //
					myMullion.y1, //
					rightXLBa, //
					myMullion.y1, //
					//
					addMullionH.limitStartXsBA, //
					addMullionH.limitStartYsBA, //
					addMullionH.limitStartXeBA, //
					addMullionH.limitStartYeBA//
					);
		
		addMullionH.newStartingXCenter = addMullionH.intersectX(
					//
					addMullionH.newStartingXCenter, //
					myMullion.centerYs, //
					rightXCenter, //
					myMullion.centerYs, //
					//
					addMullionH.limitStartXsBA, //
					addMullionH.limitStartYsBA, //
					addMullionH.limitStartXeBA, //
					addMullionH.limitStartYeBA
					//
					);
		
		// addMullionH.newStartingXRT = addMullionH.intersectX(
		// //
		// addMullionH.newStartingXRTc, //
		// addMullionH.newStartingYRTc, //
		// addMullionH.newStartingXCenter,
		// myMullion.centerYs, //
		//
		// addMullionH.newStartingXRT, //
		// myMullion.y2, //
		// rightXRT, //
		// myMullion.y2 // y3
		//
		// //
		// );
		//
		// addMullionH.newStartingXLB = addMullionH.intersectX(
		// //
		// //
		// addMullionH.newStartingXLBa, //
		// addMullionH.newStartingYLBa, //
		// addMullionH.newStartingXCenter,
		// myMullion.centerYs, //
		// //
		// addMullionH.newStartingXLB, //
		// myMullion.y1, //
		// rightXLB, //
		// myMullion.y1 // y4
		//
		// );
	}
	
	public void doStartEndType3(final Profiles myMullion)
	{
		
		addMullionH.newStartingXRTc = addMullionH.intersectX(
					//
					addMullionH.newStartingXRTc, //
					myMullion.y2cl, //
					rightXRTc, //
					myMullion.y2cl, //
					
					addMullionH.limitStartXsBA, //
					addMullionH.limitStartYsBA, //
					addMullionH.limitStartXeBA, //
					addMullionH.limitStartYeBA//
					);
		
		x2a3 = addMullionH.intersectX(
					//
					addMullionH.newStartingXRTc, //
					myMullion.y2cl, //
					rightXRTc, //
					myMullion.y2cl, //
					
					addMullionH.limitStartXsA, //
					addMullionH.limitStartYsA, //
					addMullionH.limitStartXeA, //
					addMullionH.limitStartYeA//
					);
		
		addMullionH.newStartingXLBa = addMullionH.intersectX(
					//
					addMullionH.newStartingXLBa, //
					myMullion.y1al, //
					rightXLBa, //
					myMullion.y1al, //
					//
					addMullionH.limitStartXsBA, //
					addMullionH.limitStartYsBA, //
					addMullionH.limitStartXeBA, //
					addMullionH.limitStartYeBA//
					);
		
		x1a3 = addMullionH.intersectX(
					//
					addMullionH.newStartingXLBa, //
					myMullion.y1al, //
					rightXLBa, //
					myMullion.y1al, //
					//
					addMullionH.limitStartXsA, //
					addMullionH.limitStartYsA, //
					addMullionH.limitStartXeA, //
					addMullionH.limitStartYeA//
					);
		
		addMullionH.newStartingXRT = addMullionH.intersectX(
					//
					addMullionH.newStartingXRT, //
					myMullion.y2, //
					rightXRT, //
					myMullion.y2, //
					
					addMullionH.limitStartXsBA, //
					addMullionH.limitStartYsBA, //
					addMullionH.limitStartXeBA, //
					addMullionH.limitStartYeBA//
					);
		
		addMullionH.newStartingXLB = addMullionH.intersectX(
					//
					addMullionH.newStartingXLB, //
					myMullion.y1, //
					rightXLB, //
					myMullion.y1, //
					
					addMullionH.limitStartXsBA, //
					addMullionH.limitStartYsBA, //
					addMullionH.limitStartXeBA, //
					addMullionH.limitStartYeBA//
					);
		
		addMullionH.newStartingXCenter = addMullionH.intersectX(
					//
					addMullionH.newStartingXCenter, //
					myMullion.centerYs, //
					rightXCenter, //
					myMullion.centerYs, //
					
					addMullionH.limitStartXsBA, //
					addMullionH.limitStartYsBA, //
					addMullionH.limitStartXeBA, //
					addMullionH.limitStartYeBA//
					);
		
		addMullionH.newStartingXCenter = addMullionH.intersectX(
					//
					addMullionH.newStartingXCenter, //
					myMullion.centerYs, //
					rightXCenter, //
					myMullion.centerYs, //
					
					addMullionH.limitStartXsBA, //
					addMullionH.limitStartYsBA, //
					addMullionH.limitStartXeBA, //
					addMullionH.limitStartYeBA//
					);
	}
	
	// ////////////////////////////////////
	
	public Profiles calculateCoordinArchIIL(final Profiles myMullion)
	{
		
		setXs = true;
		final EllipseLineIntersections arcX =
					new EllipseLineIntersections();
		
		// if (myMullion.endTypeLT == 2)
		// {
		//
		// myMullion.centerXs =
		// arcX
		// .getXusingY(
		// myMullion.centerXs,
		// myMullion.centerYs,
		// myMullion.centerXe,
		// myMullion.centerYe,
		// addMullionH.limitStart.radius1,
		// addMullionH.limitStart.x1,
		// addMullionH.limitStart.y1,
		// false);
		//
		// myMullion.x1 =
		// arcX
		// .getXusingY(
		// myMullion.x1,
		// myMullion.y1,
		// myMullion.x4,
		// myMullion.y4,
		// addMullionH.limitStart.radius1,
		// addMullionH.limitStart.x1,
		// addMullionH.limitStart.y1,
		// false);
		//
		// myMullion.x1al = myMullion.x1a =
		// arcX
		// .getXusingY(
		// myMullion.x1al,
		// myMullion.y1al,
		// myMullion.x4al,
		// myMullion.y4al,
		// addMullionH.limitStart.radius1,
		// addMullionH.limitStart.x1,
		// addMullionH.limitStart.y1,
		// false);
		//
		// myMullion.x2 =
		// arcX
		// .getXusingY(
		// myMullion.x2,
		// myMullion.y2,
		// myMullion.x3,
		// myMullion.y3,
		// addMullionH.limitStart.radius1,
		// addMullionH.limitStart.x1,
		// addMullionH.limitStart.y1,
		// false);
		//
		// myMullion.x2cl = myMullion.x2a =
		// arcX
		// .getXusingY(
		// myMullion.x2cl,
		// myMullion.y2cl,
		// myMullion.x3cl,
		// myMullion.y3cl,
		// addMullionH.limitStart.radius1,
		// addMullionH.limitStart.x1,
		// addMullionH.limitStart.y1,
		// false);
		// }
		if (myMullion.endTypeLT >= 2)
		{
			
			myMullion.centerXs =
						arcX.getXusingY(
									myMullion.centerXs,
									myMullion.centerYs,
									myMullion.centerXe,
									myMullion.centerYe,
									addMullionH.limitStart.radius1BA,
									addMullionH.limitStart.x1,
									addMullionH.limitStart.y1,
									false);
			
			myMullion.xcs =
						arcX.getXusingY(
									myMullion.centerXs,
									myMullion.centerYs,
									myMullion.centerXe,
									myMullion.centerYe,
									addMullionH.limitStart.radius1A,
									addMullionH.limitStart.x1,
									addMullionH.limitStart.y1,
									false);
			
			myMullion.x1 =
						arcX.getXusingY(
									myMullion.x1al,
									myMullion.y1al,
									myMullion.x4al,
									myMullion.y4al,
									addMullionH.limitStart.radius1BA,
									addMullionH.limitStart.x1,
									addMullionH.limitStart.y1,
									false);
			
			myMullion.x1b =
						x1a3 =
						arcX.getXusingY(
									myMullion.x1al,
									myMullion.y1al,
									myMullion.x4al,
									myMullion.y4al,
									addMullionH.limitStart.radius1A,
									addMullionH.limitStart.x1,
									addMullionH.limitStart.y1,
									false);
			
			myMullion.x1al =
						myMullion.x1a =
						arcX.getXusingY(
									myMullion.x1al,
									myMullion.y1al,
									myMullion.x4al,
									myMullion.y4al,
									addMullionH.limitStart.radius1BA,
									addMullionH.limitStart.x1,
									addMullionH.limitStart.y1,
									false);
			
			myMullion.x2 =
						arcX.getXusingY(
									myMullion.x2,
									myMullion.y2,
									myMullion.x3,
									myMullion.y3,
									addMullionH.limitStart.radius1BA,
									addMullionH.limitStart.x1,
									addMullionH.limitStart.y1,
									false);
			
			myMullion.x2b =
						x2a3 =
						arcX.getXusingY(
									myMullion.x2cl,
									myMullion.y2cl,
									myMullion.x3cl,
									myMullion.y3cl,
									addMullionH.limitStart.radius1A,
									addMullionH.limitStart.x1,
									addMullionH.limitStart.y1,
									false);
			
			myMullion.x2cl =
						myMullion.x2a =
						arcX.getXusingY(
									myMullion.x2cl,
									myMullion.y2cl,
									myMullion.x3cl,
									myMullion.y3cl,
									addMullionH.limitStart.radius1BA,
									addMullionH.limitStart.x1,
									addMullionH.limitStart.y1,
									false);
		}
		if (myMullion.endTypeLT == 1)
		{
			
			myMullion.centerXs =
						arcX.getXusingY(
									myMullion.centerXs,
									myMullion.centerYs,
									myMullion.centerXe,
									myMullion.centerYe,
									addMullionH.limitStart.radius1
									- addMullionH.limitStart.partDimC
									- addMullionH.dimLM,
									addMullionH.limitStart.x1,
									addMullionH.limitStart.y1,
									false);
			
			myMullion.x1 =
						arcX.getXusingY(
									myMullion.x1,
									myMullion.y1,
									myMullion.x4,
									myMullion.y4,
									addMullionH.limitStart.radius1BA,
									addMullionH.limitStart.x1,
									addMullionH.limitStart.y1,
									false);
			
			myMullion.x2 =
						arcX.getXusingY(
									myMullion.x2,
									myMullion.y2,
									myMullion.x3,
									myMullion.y3,
									addMullionH.limitStart.radius1BA,
									addMullionH.limitStart.x1,
									addMullionH.limitStart.y1,
									false);
			
			myMullion.x1al =
						myMullion.x1a =
						arcX.getXusingY(
									myMullion.x1al,
									myMullion.y1al,
									myMullion.x4al,
									myMullion.y4al,
									addMullionH.limitStart.radius1A,
									addMullionH.limitStart.x1,
									addMullionH.limitStart.y1,
									false);
			
			myMullion.x2cl =
						myMullion.x2a =
						arcX.getXusingY(
									myMullion.x2cl,
									myMullion.y2cl,
									myMullion.x3cl,
									myMullion.y3cl,
									addMullionH.limitStart.radius1A,
									addMullionH.limitStart.x1,
									addMullionH.limitStart.y1,
									false);
		}
		// }
		return myMullion;
	}
	
	public
	Profiles
	getCCoordinatesForEllipse(final Profiles myMullion)
	{
		
		myMullion.isValid = false;
		return myMullion;
	}
	
	private Profiles rightCoords(final Profiles myMullion)
	{
		
		if (addMullionH.inArchR == 0)
		{
			
			double hypCenter = addMullionH.dimRM;
			
			if (addMullionH.myThetaRight > 0)
			{
				hypCenter =
							addMullionH.dimRM
							/ Math.sin(Math.toRadians(90)
										- addMullionH.myThetaRight);
			}
			
			if (myMullion.endTypeRB == 3)
			{
				
				doEndEndType3(myMullion);
				
			}
			else
			{
				
				doEndEndType2or1(myMullion, hypCenter);
				
			}
			
		}
		
		// /////
		
		// / top == 1 && Radius >0 && topform ==2
		
		if (addMullionH.inArchR == 1)
		{
			
			// getCCoordinatedForMyMullionBot(myMullion);
			this.calculateCoordinArchIIR(myMullion);
			
		}
		else if (addMullionH.inArchR == 3)
		{
			myMullion.isValid = false;
		}
		//
		return myMullion;
	}
	
	public void doEndEndType2or1(
				final Profiles myMullion,
				final double hypCenter)
	{
		
		newXRightRTc = x3a3 = addMullionH.intersectX(
					//
					addMullionH.newStartingXRTc, //
					myMullion.y3cl, //
					rightXRTc, //
					myMullion.y3cl, //
					
					addMullionH.limitEndXsA, //
					addMullionH.limitEndYsA, //
					addMullionH.limitEndXeA, //
					addMullionH.limitEndYeA);
		
		newXRightLBa = x4a3 = addMullionH.intersectX(
					//
					addMullionH.newStartingXLBa, //
					myMullion.y4al, //
					rightXLBa, //
					myMullion.y4al, //
					
					addMullionH.limitEndXsA, //
					addMullionH.limitEndYsA, //
					addMullionH.limitEndXeA, //
					addMullionH.limitEndYeA);
		
		newXRightCenter = addMullionH.intersectX(
					//
					addMullionH.newStartingXCenter, //
					myMullion.centerYe, //
					rightXCenter, //
					myMullion.centerYe, //
					
					addMullionH.limitEndXsBA + hypCenter, //
					addMullionH.limitEndYsBA, //
					addMullionH.limitEndXeBA + hypCenter, //
					addMullionH.limitEndYeBA);
		
		
		newXRightRT = addMullionH.intersectX(
					//
					addMullionH.newStartingXRTc, //
					myMullion.y3, //
					rightXRTc, //
					myMullion.y3, //
					
					addMullionH.limitEndXsBA, //
					addMullionH.limitEndYsBA, //
					addMullionH.limitEndXeBA, //
					addMullionH.limitEndYeBA);
		
		newXRightLB = addMullionH.intersectX(
					//
					addMullionH.newStartingXLBa, //
					myMullion.y4, //
					rightXLBa, //
					myMullion.y4, //
					
					addMullionH.limitEndXsBA, //
					addMullionH.limitEndYsBA, //
					addMullionH.limitEndXeBA, //
					addMullionH.limitEndYeBA);
		
		
	}
	
	public void doEndEndType3(final Profiles myMullion)
	{
		
		if (myMullion.offsetRB != 0)
		{
			
		}
		
		newXRightRTc = addMullionH.intersectX(
					//
					addMullionH.newStartingXRTc, //
					myMullion.y3cl, //
					rightXRTc, //
					myMullion.y3cl, //
					addMullionH.limitEndXsBA, //
					addMullionH.limitEndYsBA, //
					addMullionH.limitEndXeBA, //
					addMullionH.limitEndYeBA);
		
		x3a3 = addMullionH.intersectX(
					//
					addMullionH.newStartingXRTc, //
					myMullion.y3cl, //
					rightXRTc, //
					myMullion.y3cl, //
					addMullionH.limitEndXsA, //
					addMullionH.limitEndYsA, //
					addMullionH.limitEndXeA, //
					addMullionH.limitEndYeA);
		
		newXRightLBa = addMullionH.intersectX(
					//
					addMullionH.newStartingXLBa, //
					myMullion.y4al, //
					rightXLBa, //
					myMullion.y4al, //
					
					addMullionH.limitEndXsBA, //
					addMullionH.limitEndYsBA, //
					addMullionH.limitEndXeBA, //
					addMullionH.limitEndYeBA);
		
		x4a3 = addMullionH.intersectX(
					//
					addMullionH.newStartingXLBa, //
					myMullion.y4al, //
					rightXLBa, //
					myMullion.y4al, //
					
					addMullionH.limitEndXsA, //
					addMullionH.limitEndYsA, //
					addMullionH.limitEndXeA, //
					addMullionH.limitEndYeA);
		
		newXRightRT = addMullionH.intersectX(
					//
					addMullionH.newStartingXRT, //
					myMullion.y3, //
					rightXRT, //
					myMullion.y3, //
					
					addMullionH.limitEndXsBA, //
					addMullionH.limitEndYsBA, //
					addMullionH.limitEndXeBA, //
					addMullionH.limitEndYeBA);
		
		newXRightLB = addMullionH.intersectX(
					//
					addMullionH.newStartingXLB, //
					myMullion.y4, //
					rightXLB, //
					myMullion.y4, //
					
					addMullionH.limitEndXsBA, //
					addMullionH.limitEndYsBA, //
					addMullionH.limitEndXeBA, //
					addMullionH.limitEndYeBA);
		
		newXRightCenter = addMullionH.intersectX(
					//
					addMullionH.newStartingXCenter, //
					myMullion.centerYe, //
					rightXCenter, //
					myMullion.centerYe, //
					
					addMullionH.limitEndXsBA, //
					addMullionH.limitEndYsBA, //
					addMullionH.limitEndXeBA, //
					addMullionH.limitEndYeBA);
	}
	
	public Profiles getCCoordinatedForMyMullionBot(
				final Profiles myMullion)
	{
		
		if (
					// myMullion.y4al <
					// addMullionH.myParentBO.myParent.startingY
					// + addMullionH.myParentBO.myParent.dimB1
					// &&
					addMullionH.myParentBO.radius1 > 0
					&& addMullionH.myParentBO.noSidesTop == 1)
		{
			
			baseRTRight =
						myMullion.y3 - addMullionH.myParentBO.bkgrdStartY;
			baseLBRight = Math.abs(baseRTRight + myMullion.thickness);
			
			baseCenterRight = baseRTRight + myMullion.partDimBtoC;
			
			baseRTRightc = baseRTRight - myMullion.partDimC;
			
			baseLBRighta = baseLBRight + myMullion.partDimA;
			
			if (myMullion.endTypeRB == 3)
			{
				
				addMullionH.myThetaRight =
							Math
							.asin((addMullionH.myParentBO.radius1 - baseRTRight)
										/ addMullionH.myParentBO.radius1);
				
				addMullionH.myThetaRight2 =
							Math
							.asin((addMullionH.myParentBO.radius1 - baseLBRight)
										/ addMullionH.myParentBO.radius1);
				
				addMullionH.myThetaRight3 =
							Math
							.asin((addMullionH.myParentBO.radius1 - baseCenterRight)
										/ addMullionH.myParentBO.radius1);
				
				addMullionH.myThetaRightA =
							Math
							.asin((addMullionH.myParentBO.radius1 - baseLBRighta)
										/ addMullionH.myParentBO.radius1);
				
				addMullionH.myThetaRightC =
							Math
							.asin((addMullionH.myParentBO.radius1 - baseRTRightc)
										/ addMullionH.myParentBO.radius1);
				
				newXRightRT =
							addMullionH.limitEndBArchCenterX
							- addMullionH.myParentBO.startingX
							+ addMullionH.myParentBO.radius1
							* Math.cos(addMullionH.myThetaRight);
				
				newXRightLB =
							addMullionH.limitEndBArchCenterX
							- addMullionH.myParentBO.startingX
							+ addMullionH.myParentBO.radius1
							* Math.cos(addMullionH.myThetaRight2);
				
				newXRightRTc =
							addMullionH.limitEndBArchCenterX
							- addMullionH.myParentBO.startingX
							+ addMullionH.myParentBO.radius1
							* Math.cos(addMullionH.myThetaRightC);
				
				newXRightLBa =
							addMullionH.limitEndBArchCenterX
							- addMullionH.myParentBO.startingX
							+ addMullionH.myParentBO.radius1
							* Math.cos(addMullionH.myThetaRightA);
				
				newXRightCenter =
							addMullionH.limitEndBArchCenterX
							- addMullionH.myParentBO.startingX
							+ addMullionH.myParentBO.radius1
							* Math.cos(addMullionH.myThetaRight3);
				
			}
			else if (myMullion.endTypeRB == 1)
			{
				addMullionH.myThetaRight =
							Math
							.asin((addMullionH.myParentBO.radius1 - baseRTRight)
										/ addMullionH.myParentBO.radius1);
				
				addMullionH.myThetaRight2 =
							Math
							.asin((addMullionH.myParentBO.radius1 - baseLBRight)
										/ addMullionH.myParentBO.radius1);
				
				addMullionH.myThetaRight3 =
							Math
							.asin((addMullionH.myParentBO.radius1 - baseCenterRight)
										/ (addMullionH.myParentBO.radius1 + addMullionH.dimRM));
				
				addMullionH.myThetaRightA =
							Math
							.asin((addMullionH.myParentBO.radius1 - baseLBRighta)
										/ (addMullionH.myParentBO.radius1 - addMullionH.dimRA));
				
				addMullionH.myThetaRightC =
							Math
							.asin((addMullionH.myParentBO.radius1 - baseRTRightc)
										/ (addMullionH.myParentBO.radius1 - addMullionH.dimRA));
				
				newXRightRT =
							addMullionH.limitEndBArchCenterX
							- addMullionH.myParentBO.startingX
							+ addMullionH.myParentBO.radius1
							* Math.cos(addMullionH.myThetaRight);
				
				newXRightLB =
							addMullionH.limitEndBArchCenterX
							- addMullionH.myParentBO.startingX
							+ addMullionH.myParentBO.radius1
							* Math.cos(addMullionH.myThetaRight2);
				
				newXRightRTc =
							addMullionH.limitEndBArchCenterX
							- addMullionH.myParentBO.startingX
							+ (addMullionH.myParentBO.radius1 - addMullionH.dimRA)
							* Math.cos(addMullionH.myThetaRightC);
				
				newXRightLBa =
							addMullionH.limitEndBArchCenterX
							- addMullionH.myParentBO.startingX
							+ (addMullionH.myParentBO.radius1 - addMullionH.dimRA)
							* Math.cos(addMullionH.myThetaRightA);
				
				newXRightCenter =
							addMullionH.limitEndBArchCenterX
							- addMullionH.myParentBO.startingX
							+ (addMullionH.myParentBO.radius1 + addMullionH.dimRM)
							* Math.cos(addMullionH.myThetaRight3);
			}
		}
		else
		{
			if (
						// myMullion.y4al < addMullionH.myParentBO.bkgrdStartY
						// + addMullionH.myParentBO.dimB1
						// && addMullionH.myParentBO.dimB1 > 0
						// && addMullionH.myParentBO.dimA2 > 0
						// &&
						addMullionH.myParentBO.radius1 > 0
						&& addMullionH.myParentBO.noSidesTop > 1 && addMullionH.myParentBO.shapeID < 450
						|| addMullionH.myParentBO.shapeID > 461)
			{
				baseRTRight =
							addMullionH.newRowH
							* addMullionH.iNo
							+ addMullionH.sumOfPrevMullions;
				
				baseLBRight =
							Math.abs(baseRTRight + myMullion.thickness);
				
				baseCenterRight = baseRTRight + myMullion.partDimBtoC;
				
				baseRTRightc = baseRTRight - myMullion.partDimC;
				
				baseLBRighta = baseLBRight + myMullion.partDimA;
				
				if (myMullion.endTypeRB == 3)
				{
					
					addMullionH.myThetaRight =
								Math
								.asin((addMullionH.limitEndBArchCenterY
											- addMullionH.myParentBO.bkgrdStartY - baseRTRight)
											/ addMullionH.myParentBO.radius1);
					
					addMullionH.myThetaRight2 =
								Math
								.asin((addMullionH.limitEndBArchCenterY
											- addMullionH.myParentBO.bkgrdStartY - baseLBRight)
											/ addMullionH.myParentBO.radius1);
					
					addMullionH.myThetaRight3 =
								Math
								.asin((addMullionH.limitEndBArchCenterY
											- addMullionH.myParentBO.bkgrdStartY - baseCenterRight)
											/ addMullionH.myParentBO.radius1);
					
					addMullionH.myThetaRightA =
								Math
								.asin((addMullionH.limitEndBArchCenterY
											- addMullionH.myParentBO.bkgrdStartY - baseLBRighta)
											/ addMullionH.myParentBO.radius1);
					
					addMullionH.myThetaRightC =
								Math
								.asin((addMullionH.limitEndBArchCenterY
											- addMullionH.myParentBO.bkgrdStartY - baseRTRightc)
											/ addMullionH.myParentBO.radius1);
					
					newXRightRT =
								addMullionH.myParentBO.widthPix
								- addMullionH.myParentBO.radius1
								+ addMullionH.myParentBO.radius1
								* Math
								.cos(addMullionH.myThetaRight);
					
					newXRightLB =
								addMullionH.myParentBO.widthPix
								- addMullionH.myParentBO.radius1
								+ addMullionH.myParentBO.radius1
								* Math
								.cos(addMullionH.myThetaRight2);
					
					newXRightRTc =
								addMullionH.myParentBO.widthPix
								- addMullionH.myParentBO.radius1
								+ addMullionH.myParentBO.radius1
								* Math
								.cos(addMullionH.myThetaRightC);
					
					newXRightLBa =
								addMullionH.myParentBO.widthPix
								- addMullionH.myParentBO.radius1
								+ addMullionH.myParentBO.radius1
								* Math
								.cos(addMullionH.myThetaRightA);
					
					newXRightCenter =
								addMullionH.myParentBO.widthPix
								- addMullionH.myParentBO.radius1
								+ addMullionH.myParentBO.radius1
								* Math
								.cos(addMullionH.myThetaRight3);
					
				}
				else if (myMullion.endTypeRB == 1)
				{
					addMullionH.myThetaRight =
								Math
								.asin((addMullionH.limitEndBArchCenterY
											- addMullionH.myParentBO.bkgrdStartY - baseRTRight)
											/ addMullionH.myParentBO.radius1);
					
					addMullionH.myThetaRight2 =
								Math
								.asin((addMullionH.limitEndBArchCenterY
											- addMullionH.myParentBO.bkgrdStartY - baseLBRight)
											/ addMullionH.myParentBO.radius1);
					
					addMullionH.myThetaRight3 =
								Math
								.asin((addMullionH.limitEndBArchCenterY
											- addMullionH.myParentBO.bkgrdStartY - baseCenterRight)
											/ (addMullionH.myParentBO.radius1 + addMullionH.dimRM));
					
					addMullionH.myThetaRightA =
								Math
								.asin((addMullionH.limitEndBArchCenterY
											- addMullionH.myParentBO.bkgrdStartY - baseLBRighta)
											/ (addMullionH.myParentBO.radius1 - addMullionH.dimRA));
					
					addMullionH.myThetaRightC =
								Math
								.asin((addMullionH.limitEndBArchCenterY
											- addMullionH.myParentBO.bkgrdStartY - baseRTRightc)
											/ (addMullionH.myParentBO.radius1 - addMullionH.dimRA));
					
					newXRightRT =
								addMullionH.myParentBO.widthPix
								- addMullionH.myParentBO.radius1
								+ addMullionH.myParentBO.radius1
								* Math
								.cos(addMullionH.myThetaRight);
					
					newXRightLB =
								addMullionH.myParentBO.widthPix
								- addMullionH.myParentBO.radius1
								+ addMullionH.myParentBO.radius1
								* Math
								.cos(addMullionH.myThetaRight2);
					
					newXRightRTc =
								addMullionH.myParentBO.widthPix
								- addMullionH.myParentBO.radius1
								+ (addMullionH.myParentBO.radius1 - addMullionH.dimRA)
								* Math
								.cos(addMullionH.myThetaRightC);
					
					newXRightLBa =
								addMullionH.myParentBO.widthPix
								- addMullionH.myParentBO.radius1
								+ (addMullionH.myParentBO.radius1 - addMullionH.dimRA)
								* Math
								.cos(addMullionH.myThetaRightA);
					
					newXRightCenter =
								addMullionH.myParentBO.widthPix
								- addMullionH.myParentBO.radius1
								+ (addMullionH.myParentBO.radius1 + addMullionH.dimRM)
								* Math
								.cos(addMullionH.myThetaRight3);
				}
			}
			else if (myMullion.y4al < addMullionH.myParentBO.bkgrdStartY
						+ addMullionH.myParentBO.dimB1
						&& addMullionH.myParentBO.dimB1 > 0
						&& addMullionH.myParentBO.dimA2 > 0
						&& addMullionH.myParentBO.radius1 > 0
						&& addMullionH.myParentBO.noSidesTop > 1
						&& addMullionH.myParentBO.shapeID >= 450
						&& addMullionH.myParentBO.shapeID <= 461)
			{
				baseRTRight =
							addMullionH.newRowH
							* addMullionH.iNo
							+ addMullionH.sumOfPrevMullions;
				
				baseLBRight =
							Math.abs(baseRTRight + myMullion.thickness);
				
				baseCenterRight = baseRTRight + myMullion.partDimBtoC;
				
				baseRTRightc = baseRTRight - myMullion.partDimC;
				
				baseLBRighta = baseLBRight + myMullion.partDimA;
				
				if (myMullion.endTypeRB == 3)
				{
					
					addMullionH.myThetaRight =
								Math
								.asin((addMullionH.limitEndBArchCenterY
											- addMullionH.myParentBO.bkgrdStartY - baseRTRight)
											/ addMullionH.myParentBO.radius1);
					
					addMullionH.myThetaRight2 =
								Math
								.asin((addMullionH.limitEndBArchCenterY
											- addMullionH.myParentBO.bkgrdStartY - baseLBRight)
											/ addMullionH.myParentBO.radius1);
					
					addMullionH.myThetaRight3 =
								Math
								.asin((addMullionH.limitEndBArchCenterY
											- addMullionH.myParentBO.bkgrdStartY - baseCenterRight)
											/ addMullionH.myParentBO.radius1);
					
					addMullionH.myThetaRightA =
								Math
								.asin((addMullionH.limitEndBArchCenterY
											- addMullionH.myParentBO.bkgrdStartY - baseLBRighta)
											/ addMullionH.myParentBO.radius1);
					
					addMullionH.myThetaRightC =
								Math
								.asin((addMullionH.limitEndBArchCenterY
											- addMullionH.myParentBO.bkgrdStartY - baseRTRightc)
											/ addMullionH.myParentBO.radius1);
					
					newXRightRT =
								addMullionH.myParentBO.bX2
								- addMullionH.limitEndBArchCenterX
								+ addMullionH.myParentBO.radius1
								* Math
								.cos(addMullionH.myThetaRight);
					
					newXRightLB =
								addMullionH.myParentBO.bX2
								- addMullionH.limitEndBArchCenterX
								+ addMullionH.myParentBO.radius1
								* Math
								.cos(addMullionH.myThetaRight2);
					
					newXRightRTc =
								addMullionH.myParentBO.bX2
								- addMullionH.limitEndBArchCenterX
								+ addMullionH.myParentBO.radius1
								* Math
								.cos(addMullionH.myThetaRightC);
					
					newXRightLBa =
								addMullionH.myParentBO.bX2
								- addMullionH.limitEndBArchCenterX
								+ addMullionH.myParentBO.radius1
								* Math
								.cos(addMullionH.myThetaRightA);
					
					newXRightCenter =
								addMullionH.myParentBO.bX2
								- addMullionH.limitEndBArchCenterX
								+ addMullionH.myParentBO.radius1
								* Math
								.cos(addMullionH.myThetaRight3);
					
				}
				else if (myMullion.endTypeRB == 1)
				{
					addMullionH.myThetaRight =
								Math
								.asin((addMullionH.limitEndBArchCenterY
											- addMullionH.myParentBO.bkgrdStartY - baseRTRight)
											/ addMullionH.myParentBO.radius1);
					
					addMullionH.myThetaRight2 =
								Math
								.asin((addMullionH.limitEndBArchCenterY
											- addMullionH.myParentBO.bkgrdStartY - baseLBRight)
											/ addMullionH.myParentBO.radius1);
					
					addMullionH.myThetaRight3 =
								Math
								.asin((addMullionH.limitEndBArchCenterY
											- addMullionH.myParentBO.bkgrdStartY - baseCenterRight)
											/ (addMullionH.myParentBO.radius1 + addMullionH.dimRM));
					
					addMullionH.myThetaRightA =
								Math
								.asin((addMullionH.limitEndBArchCenterY
											- addMullionH.myParentBO.bkgrdStartY - baseLBRighta)
											/ (addMullionH.myParentBO.radius1 - addMullionH.dimRA));
					
					addMullionH.myThetaRightC =
								Math
								.asin((addMullionH.limitEndBArchCenterY
											- addMullionH.myParentBO.bkgrdStartY - baseRTRightc)
											/ (addMullionH.myParentBO.radius1 - addMullionH.dimRA));
					
					newXRightRT =
								addMullionH.myParentBO.bX2
								- addMullionH.limitEndBArchCenterX
								+ addMullionH.myParentBO.radius1
								* Math
								.cos(addMullionH.myThetaRight);
					
					newXRightLB =
								addMullionH.myParentBO.bX2
								- addMullionH.limitEndBArchCenterX
								+ addMullionH.myParentBO.radius1
								* Math
								.cos(addMullionH.myThetaRight2);
					
					newXRightRTc =
								addMullionH.myParentBO.bX2
								- addMullionH.limitEndBArchCenterX
								+ (addMullionH.myParentBO.radius1 - addMullionH.dimRA)
								* Math
								.cos(addMullionH.myThetaRightC);
					
					newXRightLBa =
								addMullionH.myParentBO.bX2
								- addMullionH.limitEndBArchCenterX
								+ (addMullionH.myParentBO.radius1 - addMullionH.dimRA)
								* Math
								.cos(addMullionH.myThetaRightA);
					
					newXRightCenter =
								addMullionH.myParentBO.bX2
								- addMullionH.limitEndBArchCenterX
								+ (addMullionH.myParentBO.radius1 + addMullionH.dimRM)
								* Math
								.cos(addMullionH.myThetaRight3);
				}
			}
			
		}
		if (addMullionH.myParentBO.shapeID < 450
					|| addMullionH.myParentBO.shapeID > 461)
		{
			myMullion.centerXe =
						addMullionH.myParentBO.startingX
						+ newXRightCenter;
			myMullion.x4 =
						addMullionH.myParentBO.startingX + newXRightLB;
			myMullion.x3 =
						addMullionH.myParentBO.startingX + newXRightRT;
			
			myMullion.x4al =
						addMullionH.myParentBO.startingX + newXRightLBa;
			
			myMullion.x3cl =
						addMullionH.myParentBO.startingX + newXRightRTc;
		}
		else
		{
			myMullion.centerXe =
						addMullionH.myParentBO.top2.bkgrdStartX
						+ newXRightCenter;
			myMullion.x4 =
						addMullionH.myParentBO.top2.bkgrdStartX
						+ newXRightLB;
			myMullion.x3 =
						addMullionH.myParentBO.top2.bkgrdStartX
						+ newXRightRT;
			
			myMullion.x4al =
						addMullionH.myParentBO.top2.bkgrdStartX
						+ newXRightLBa;
			
			myMullion.x3cl =
						addMullionH.myParentBO.top2.bkgrdStartX
						+ newXRightRTc;
		}
		
		setXe = true;
		return myMullion;
	}
	
	public Profiles calculateCoordinArchIIR(final Profiles myMullion)
	{
		
		setXe = true;
		final EllipseLineIntersections arcX =
					new EllipseLineIntersections();
		
		// if (myMullion.endTypeRB == 2)
		// {
		//
		// myMullion.centerXe =
		// arcX
		// .getXusingY(
		// myMullion.centerXs,
		// myMullion.centerYs,
		// myMullion.centerXe,
		// myMullion.centerYe,
		// addMullionH.limitEnd.radius1,
		// addMullionH.limitEnd.x1,
		// addMullionH.limitEnd.y1,
		// true);
		//
		// myMullion.x4 =
		// arcX
		// .getXusingY(
		// myMullion.x1,
		// myMullion.y1,
		// myMullion.x4,
		// myMullion.y4,
		// addMullionH.limitEnd.radius1,
		// addMullionH.limitEnd.x1,
		// addMullionH.limitEnd.y1,
		// true);
		//
		// myMullion.x4al = myMullion.x4a = myMullion.x4a3 =
		// arcX
		// .getXusingY(
		// myMullion.x1al,
		// myMullion.y1al,
		// myMullion.x4al,
		// myMullion.y4al,
		// addMullionH.limitEnd.radius1,
		// addMullionH.limitEnd.x1,
		// addMullionH.limitEnd.y1,
		// true);
		//
		// myMullion.x3 =
		// arcX
		// .getXusingY(
		// myMullion.x2,
		// myMullion.y2,
		// myMullion.x3,
		// myMullion.y3,
		// addMullionH.limitEnd.radius1,
		// addMullionH.limitEnd.x1,
		// addMullionH.limitEnd.y1,
		// true);
		//
		// myMullion.x3cl = myMullion.x3a = myMullion.x3a3 =
		// arcX
		// .getXusingY(
		// myMullion.x2cl,
		// myMullion.y2cl,
		// myMullion.x3cl,
		// myMullion.y3cl,
		// addMullionH.limitEnd.radius1,
		// addMullionH.limitEnd.x1,
		// addMullionH.limitEnd.y1,
		// true);
		// }
		if (myMullion.endTypeRB >= 2)
		{
			
			myMullion.centerXe =
						arcX.getXusingY(
									myMullion.centerXs,
									myMullion.centerYs,
									myMullion.centerXe,
									myMullion.centerYe,
									addMullionH.limitEnd.radius1BA,
									addMullionH.limitEnd.x1,
									addMullionH.limitEnd.y1,
									true);
			
			myMullion.xce =
						arcX.getXusingY(
									myMullion.centerXs,
									myMullion.centerYs,
									myMullion.centerXe,
									myMullion.centerYe,
									addMullionH.limitEnd.radius1A,
									addMullionH.limitEnd.x1,
									addMullionH.limitEnd.y1,
									true);
			
			myMullion.x4 =
						arcX.getXusingY(
									myMullion.x1,
									myMullion.y1,
									myMullion.x4,
									myMullion.y4,
									addMullionH.limitEnd.radius1BA,
									addMullionH.limitEnd.x1,
									addMullionH.limitEnd.y1,
									true);
			
			myMullion.x4b =
						x4a3 =
						arcX.getXusingY(
									myMullion.x1al,
									myMullion.y1al,
									myMullion.x4al,
									myMullion.y4al,
									addMullionH.limitEnd.radius1A,
									addMullionH.limitEnd.x1,
									addMullionH.limitEnd.y1,
									true);
			
			myMullion.x4al =
						myMullion.x4a =
						arcX.getXusingY(
									myMullion.x1al,
									myMullion.y1al,
									myMullion.x4al,
									myMullion.y4al,
									addMullionH.limitEnd.radius1BA,
									addMullionH.limitEnd.x1,
									addMullionH.limitEnd.y1,
									true);
			
			myMullion.x3 =
						arcX.getXusingY(
									myMullion.x2,
									myMullion.y2,
									myMullion.x3,
									myMullion.y3,
									addMullionH.limitEnd.radius1BA,
									addMullionH.limitEnd.x1,
									addMullionH.limitEnd.y1,
									true);
			
			myMullion.x3b =
						x3a3 =
						arcX.getXusingY(
									myMullion.x2cl,
									myMullion.y2cl,
									myMullion.x3cl,
									myMullion.y3cl,
									addMullionH.limitEnd.radius1A,
									addMullionH.limitEnd.x1,
									addMullionH.limitEnd.y1,
									true);
			
			myMullion.x3cl =
						myMullion.x3a =
						arcX.getXusingY(
									myMullion.x2cl,
									myMullion.y2cl,
									myMullion.x3cl,
									myMullion.y3cl,
									addMullionH.limitEnd.radius1BA,
									addMullionH.limitEnd.x1,
									addMullionH.limitEnd.y1,
									true);
		}
		if (myMullion.endTypeRB == 1)
		{
			
			myMullion.centerXe =
						arcX.getXusingY(
									myMullion.centerXs,
									myMullion.centerYs,
									myMullion.centerXe,
									myMullion.centerYe,
									addMullionH.limitEnd.radius1
									- addMullionH.dimLM,
									addMullionH.limitEnd.x1,
									addMullionH.limitEnd.y1,
									true);
			
			myMullion.x4 =
						arcX.getXusingY(
									myMullion.x1,
									myMullion.y1,
									myMullion.x4,
									myMullion.y4,
									addMullionH.limitEnd.radius1BA,
									addMullionH.limitEnd.x1,
									addMullionH.limitEnd.y1,
									true);
			
			myMullion.x3 =
						arcX.getXusingY(
									myMullion.x2,
									myMullion.y2,
									myMullion.x3,
									myMullion.y3,
									addMullionH.limitEnd.radius1BA,
									addMullionH.limitEnd.x1,
									addMullionH.limitEnd.y1,
									true);
			
			myMullion.x4al =
						myMullion.x4a =
						myMullion.x4a3 =
						arcX
						.getXusingY(
									myMullion.x1al,
									myMullion.y1al,
									myMullion.x4al,
									myMullion.y4al,
									addMullionH.limitEnd.radius1A,
									addMullionH.limitEnd.x1,
									addMullionH.limitEnd.y1,
									true);
			
			myMullion.x3cl =
						myMullion.x3a =
						myMullion.x3a3 =
						arcX
						.getXusingY(
									myMullion.x2cl,
									myMullion.y2cl,
									myMullion.x3cl,
									myMullion.y3cl,
									addMullionH.limitEnd.radius1A,
									addMullionH.limitEnd.x1,
									addMullionH.limitEnd.y1,
									true);
		}
		// }
		return myMullion;
	}
	
	public Point2D getIntersectionLineArc(
				//
				final double bsX,
				final double bsY, //
				final double w,
				final double h, //
				final double sA,
				final double eA, //
				final double cX,
				final double cY,
				final double sX,
				final double sY,
				final double eX,
				final double eY,
				final int pos,
				final boolean isP)
	{
		
		Point2D myP = new Point2D.Double();
		
		if (pos == 1)
		{// Top Part
			
			final Point2D myPs = new Point2D.Double(sX, sY);
			final Point2D myPe = new Point2D.Double(eX, eY);
			
			myP =
						this.getLineCircleIntersection(
									bsX,
									bsY,
									w,
									h,
									cX,
									cY,
									myPs,
									myPe,
									isP);
		}
		
		return myP;
		
	}
	
	public Point2D getLineCircleIntersection(
				final double bsX,
				final double bsY,
				final double wW,
				final double hH,
				final double centerX,
				final double centerY,
				final Point2D source,
				final Point2D p,
				final boolean isP)
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
			return new Point2D.Double(
						x0,
						(y0 + b * dy / Math.abs(dy)));
		}
		
		final double d = dy / dx;
		final double h = y0 - d * x0;
		
		// Calculates intersection
		final double e = a * a * d * d + b * b;
		final double f = -2 * x0 * e;
		final double g =
					a
					* a
					* d
					* d
					* x0
					* x0
					+ b
					* b
					* x0
					* x0
					- a
					* a
					* b
					* b;
		
		final double det = Math.sqrt(f * f - 4 * e * g);
		
		// Two solutions (perimeter points)
		final double xout1 = (-f + det) / (2 * e);
		final double xout2 = (-f - det) / (2 * e);
		final double yout1 = d * xout1 + h;
		final double yout2 = d * xout2 + h;
		
		final double dist1 =
					Math.sqrt(Math.pow((xout1 - x1), 2)
								+ Math.pow((yout1 - y1), 2));
		final double dist2 =
					Math.sqrt(Math.pow((xout2 - x1), 2)
								+ Math.pow((yout2 - y1), 2));
		
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
	
}

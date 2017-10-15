/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 * 
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/

package Operations;

import java.awt.Polygon;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.swing.JOptionPane;

import util.UOMConvert;
import Model.BkgrdOpeningObject;
import Model.Frame;
import Model.JobItemModel;
import Model.OpeningObject;
import Model.SashLeaf;
import Model.ProfileParts.PartsNotching;
import Model.ProfileParts.Profiles;
import Presentation.ItemFrame;

public class AddMullionH
{

	public int					order				= 0;

	public int					alreadyExist		= 1;

	double						couplerThickTotal	= 0;

	public int					hcEnd				= 1;		// col

	public double				hcEndX				= 0;

	public int					hcStart				= 1;		// col

	public double				hcStartX			= 0;

	double						hcY1				= 0;

	double						hcY2				= 0;

	double						hcY3				= 0;

	double						hcY4				= 0;

	int							i					= 0;

	double						myNetH				= 0;

	public BkgrdOpeningObject	myParentBO;

	double						myStartingY			= 0;

	double						myEndingY			= 0;

	public int					newHCCol			= 1;

	public int					newHCRow			= 1;

	public double				newRowH				= 0;

	boolean						recalcPos			= false;

	double						sumOfPrevMullions	= 0;

	int							aboveJoin			= 0;

	public boolean				goodToGo			= true;

	public boolean				goodToDivide		= true;

	Object						selectedFrame		= null;

	double						constant			= 10;

	int							myClickedShape		= 0;

	int							myOpeningShape		= 0;

	int							countHCouplers		= 0;

	public double				baseCenter			= 0;

	public double				baseLB				= 0;

	public double				baseRT				= 0;

	public double				baseLBa				= 0;

	public double				baseRTc				= 0;

	public boolean				isValid				= true;

	public double				newStartingXCenter	= 0;

	public double				newStartingXLB		= 0;		// Right

	// Bottom
	public double				newStartingXRT		= 0;

	public double				newStartingXLBa		= 0;		// Right

	// Bottom
	public double				newStartingXRTc		= 0;

	public double				newStartingYCenter	= 0;

	public double				newStartingYLB		= 0;		// Right

	// Bottom
	public double				newStartingYRT		= 0;		// Left

	// top
	public double				newStartingYLBa		= 0;		// Right

	// Bottom
	public double				newStartingYRTc		= 0;

	public int					iNo					= 0;

	public double				myThick;

	public CalculateMullionHii	calcMullion;

	private double				mullionThickTotal;

	public double				x1p					= 0;

	public double				y1p					= 0;

	public double				x2p					= 0;

	public double				y2p					= 0;

	public double				x3p					= 0;

	public double				y3p					= 0;

	public double				x4p					= 0;

	public double				y4p					= 0;

	public int					posCondition		= 1;		// 1=

	// |--|
	// 2=
	// *--|
	// 3=
	// |--*
	// 4=
	// *--*

	public int					mType				= 0;

	public double				offsetTL			= 30;		// offset

	// from
	// center
	// (-
	// or
	// +)
	public double				offsetRB			= -30;

	public int					partForm			= 1;

	public double				deltaTL				= 60;

	public double				deltaRB				= 60;

	public double				curveCenterTL		= 95;

	public double				curveCenterRB		= 95;

	public double				dimLM				= 0;

	public double				dimRM				= 0;

	public double				dimLA				= 0;

	public double				dimRA				= 0;

	public boolean				endIn				= false;

	public boolean				startIn				= false;

	public int					partID				= 0;

	int							setVcontinuity		= 0;		// do

	// not
	// set,
	// 1
	// =
	// set
	// to
	// 1
	// 3
	// set
	// to
	// not
	// continuous
	public int					continuity			= 0;

	public double				thickness			= 0;

	public double				newAlpha			= 0;

	public double				newAlpha2			= 0;

	public double				newAlpha3			= 0;

	public double				newAlphaA			= 0;

	public double				newAlphaC			= 0;

	public double				limitStartXsA		= 0;

	public double				limitStartYsA		= 0;

	public double				limitStartXeA		= 0;

	public double				limitStartYeA		= 0;

	public double				limitStartXsBA		= 0;

	public double				limitStartYsBA		= 0;

	public double				limitStartXeBA		= 0;

	public double				limitStartYeBA		= 0;

	public double				limitEndXsA			= 0;

	public double				limitEndYsA			= 0;

	public double				limitEndXeA			= 0;

	public double				limitEndYeA			= 0;

	public double				limitEndXsBA		= 0;

	public double				limitEndYsBA		= 0;

	public double				limitEndXeBA		= 0;

	public double				limitEndYeBA		= 0;

	public double				limitLTArchCenterX;

	public double				limitEndBArchCenterX;

	public double				limitLTArchCenterY;

	public double				limitEndBArchCenterY;

	public double				myThetaRight		= 0;

	double						myThetaRight2		= 0;

	double						myThetaRight3		= 0;

	double						myThetaRightA		= 0;

	double						myThetaRightC		= 0;

	public int					inArchL				= 0;		// 1

	// if
	// 1
	// arch,
	// (gothic)
	// 3
	// ellipse
	public int					inArchR				= 0;		// 1

	// if
	// 1
	// arch,
	// (gothic)
	// 3
	// ellipse
	int							prevShape			= 1;

	int							newShape			= 1;

	int							frameEndRow			= 0;

	boolean						done				= false;

	int							newEndCol			= 0;

	int							shape				= 0;

	int							startcol			= 0;

	int							startrow			= 0;

	int							endcol				= 0;

	int							endrow				= 0;

	public boolean				newMullion			= false;

	public double				partDimA			= 0;

	public double				partDimB			= 0;

	public double				partDimBtoC			= 0;

	// Where the Center of Mullion
	// (screw Ports is)

	public double				partDimC			= 0;

	public double				partDimD			= 0;

	public double				partDimM			= 0;

	public JobItemModel			myJobItem;

	public ItemFrame			myFrame2;

	public int					whichPos			= 0;

	public int					cOrM				= 1;		// 1=coupler

	// public
	// boolean
	// cOrMremoved
	// =
	// false;
	boolean						moreAtRow			= false;

	public Profiles				limitStart			= null;

	public Profiles				limitEnd			= null;

	public boolean				posChanged			= false;

	public int					posChangedAt		= 0;

	public double				newPosYAfterChange	= 0;

	public boolean				doVerifyCouplerPos	= true;

	public boolean				fixedAngle			= true;

	public double				angle				= 180;

	public boolean				phantom				= false;

	public int					typeID				= 0;

	public AddMullionH(BkgrdOpeningObject mybo, JobItemModel jobItem, ItemFrame mainPanel, int type)
	{

		// getSelectedOpening(x, y);
		myParentBO = mybo;
		myJobItem = jobItem;
		myFrame2 = mainPanel;
		calcMullion = new CalculateMullionHii(this);

		myClickedShape = myParentBO.shapeID;
		cOrM = type;
		order = myParentBO.myParent.bOpeningObject.order;

	}

	public Object[] doAddMullionsH(
			final int x,
			final int y,
			final boolean isNew,
			final int type,
			final int mullionPartForm,
			final double offsetTL, // offset from center
			// (-
			// or +)
			final double offsetRB, final double deltaTL, final double deltaRB,
			final double curveCenterTL, final double curveCenterRB, final int partID,
			final int continuity, final double thick, final int pos, final boolean doOp,
			final double rowH, final int assemblyL, int typeid) throws Exception
	{

		final Object[] returns = new Object[2];
		// wire = false;
		// if(doCheck) {
		mType = type;
		typeID = typeid;
		this.partID = partID;
		partForm = mullionPartForm;
		this.continuity = continuity;
		this.offsetTL = offsetTL;
		this.offsetRB = offsetRB;
		this.deltaTL = deltaTL;
		this.deltaRB = deltaRB;
		this.curveCenterTL = curveCenterTL;
		this.curveCenterRB = curveCenterRB;
		if (thick > 0)
		{
			thickness = thick;
		}

		newMullion = isNew;
		whichPos = pos;

		if (cOrM <= 2 && myFrame2.alignHPerformed)
		{
			myJobItem.myCanvas.equalizeH = true;
			myJobItem.myCanvas.equalizeHeights();
			myFrame2.alignHPerformed = false;
		}
		if (goodToGo)
		{
			if (cOrM <= 2)
			{

				this.alreadyExistii(x, y);//

				this.cleanHMullions();
				// goodToGo = checkH();
			}
			else if (cOrM != 7)
			{
				alreadyExist = 1;
			}

			if (goodToGo)
			{

				myFrame2.ellipses.clear();
				if (alreadyExist != 0)
				{
					if (alreadyExist != 3)
					{

						if (alreadyExist == 1)
						{
							if (cOrM == 1)
							{
								myFrame2.roundH = false;// true
							}
							if (isNew)
							{

								myParentBO.yRows++;
								myParentBO.myParent.yRows++;

								if (cOrM <= 2 && myParentBO.mullionObjectsH.length > 0)
								{
									this.reOrderMullionsH(y);//
								}
							}
						}

						this.addMullionHAtPos(x, y, assemblyL);
						if (cOrM <= 2)
						{

							if (rowH == 0)
							{
								this.getDimsForMullion(x, y);
							}
							else
							{
								myStartingY = myParentBO.highestY;
								this.newRowH = rowH;
							}
						}
						// Added July 19, 2012
						if ((this.posCondition == 1 || posCondition == 2) && cOrM == 1)
						{
							if (this.myParentBO.shapeID != 1)
							{
								if (this.myParentBO.dimD2 > 0 || this.myParentBO.dimD0 > 0)
								{
									if (newRowH == this.myParentBO.dimD2
											|| newRowH == this.myParentBO.dimD0)
									{
										goodToGo = false;

										JOptionPane.showMessageDialog(null,
												"Invalid Horiz. Divider Position!\n"
														+ " Position is at Join of 2 profiles.\n"
														+ " Contact Help for further information!",
												"Warning!", JOptionPane.WARNING_MESSAGE);
									}
								}
							}

						}
						// ---> End Add
						myParentBO.mullionObjectsH = null;
						myParentBO.mullionObjectsH = myParentBO.mullionsH.toArray();

						if (goodToGo && goodToDivide)
						{

							myParentBO.mullionsH.clear();
							posChanged = false;
							doVerifyCouplerPos = true;
							for (int vc = 0; vc < myParentBO.mullionObjectsH.length; vc++)
							{
								this.doMullionCalculations(vc,
										((Profiles) myParentBO.mullionObjectsH[vc]).isNew, false);

							} // Big
								// FOR
								// Loop
						}
					}
					if (goodToGo && goodToDivide)
					{
						if (cOrM <= 2 && myParentBO.mullionObjectsV.length > 0 && alreadyExist == 1)
						{
							this.reOrderVMullions();
						}
						if ((cOrM <= 2 || cOrM == 7) && alreadyExist == 3)
						{
							myParentBO.mullionsH.clear();
							for (Object vc : myParentBO.mullionObjectsH)
							{
								if (!((Profiles) vc).remove)
								{
									newStartingYCenter = ((Profiles) vc).centerYs;

									newStartingYRTc = ((Profiles) vc).y2cl;

									newStartingYRT = ((Profiles) vc).y2;

									newStartingYLB = ((Profiles) vc).y1;

									newStartingYLBa = ((Profiles) vc).y1al;
									this.getSumPrevMullions(((Profiles) vc).rowCol,
											((Profiles) vc).endPos);
									this.getDimsForMullion(x, y);

									iNo = ((Profiles) vc).rowCol;
									myThick = ((Profiles) vc).thickness;
									this.verifyLimitLR(((Profiles) vc));

									calcMullion.calculateCoord(((Profiles) vc));

									// Reset and Recalc BOM

									vc = resetRecalcMullionBom(((Profiles) vc));

									myParentBO.mullionsH.add(vc);
								}

							} //

							myParentBO.mullionObjectsH = null;
							myParentBO.mullionObjectsH = myParentBO.mullionsH.toArray();

							this.getMyMullionH();

							myParentBO.mullionObjectsH = myParentBO.mullionsH.toArray();
							myParentBO.mullionObjectsV = myParentBO.mullions.toArray();

							myParentBO.mullions.clear();
							//

							for (int c = 0; c < myParentBO.mullionObjectsV.length; c++)
							{

								if (((Profiles) myParentBO.mullionObjectsV[c]).endPos > newHCRow
										&& ((Profiles) myParentBO.mullionObjectsV[c]).startPos <= newHCRow
										&& myParentBO.myProfilesH.x2cl < ((Profiles) myParentBO.mullionObjectsV[c]).x1
										&& myParentBO.myProfilesH.x4al > ((Profiles) myParentBO.mullionObjectsV[c]).x3)
								{
									this.addMullionVSplit(
											((Profiles) myParentBO.mullionObjectsV[c]),
											myParentBO.myProfilesH, c);
								}
								else
								{
									myParentBO.mullions.add(myParentBO.mullionObjectsV[c]);
								}

							}// for
								// Loop V mullion

						}// if
							// extend already exist ==3

						if (cOrM <= 2)
						{
							this.recalcVCCoords();

							this.reOrderHMNotches();
						}
					}
				}

			}
		}
		if (alreadyExist == 0)
		{
			JOptionPane.showMessageDialog(null, "Duplicate Mullion Location!", "Error",
					JOptionPane.ERROR_MESSAGE);

		}
		else if (goodToGo && goodToDivide)
		{

			this.recalcInitOpenings();

		}
		else if (!goodToGo)
		{

		}
		this.cleanHMullions();

		// if ((myParentBO.a_levelID != 12 || myParentBO.a_levelID != 5) &&
		// goodToGo && goodToDivide && cOrM <= 2) {
		// myParentBO.myParent.doOpenings();
		//
		// }
		//
		// if (myParentBO.myParent.a_levelID == 12 && goodToGo && goodToDivide
		// && cOrM <= 2) {
		// // myParent.myParent
		// // .doMullions(myParent);
		//
		// }
		// if (cOrM >= 3 && cOrM <= 7 && doOp) {
		// if (doOp) {
		myParentBO.myParent.doOpenings();
		// }
		//
		// if (cOrM != 5) {
		// // myParent.myParent
		// // .doMullions(myParent);
		// }
		// }
		myParentBO = myParentBO.myParent.doMullions(myParentBO);
		// myParentBO.mullionsH
		returns[0] = goodToGo;
		returns[1] = myParentBO;

		return returns;

	}

	public Profiles resetRecalcMullionBom(Profiles mullion)
	{

		mullion.length = Math.sqrt(Math.pow((Math.max(mullion.centerXe, mullion.centerXs) - Math
				.min(mullion.centerXe, mullion.centerXs)), 2)
				+ Math.pow((Math.max(mullion.centerYe, mullion.centerYs) - Math.min(
						mullion.centerYe, mullion.centerYs)), 2));

		mullion.lengthM = mullion.lengthMN = (int) (new BigDecimal(mullion.length).divide(myFrame2.metricscale, 10,
				BigDecimal.ROUND_UP)).doubleValue();

		mullion.lengthI = mullion.lengthIN = (int) (new BigDecimal(mullion.length).divide(myFrame2.imperialscale, 10,
				BigDecimal.ROUND_UP)).doubleValue();

		mullion.bom.clear();
		mullion.clearBomForProfile();

//		mullion = (Profiles) myFrame2.executePartRules.executePartRules(null, null, mullion,
//				mullion.a_assemblyLevel, true, true, "AddMullionH.resetRecalcMullionBom", true);

		return mullion;
	}

	public void alreadyExistii(final int x, final int y)
	{

		myParentBO.mullionObjectsH = null;
		myParentBO.mullionObjectsH = myParentBO.mullionsH.toArray();

		myParentBO.mullionObjectsV = null;
		myParentBO.mullionObjectsV = myParentBO.mullions.toArray();

		boolean duplicate = false;

		for (final Object M : myParentBO.mullionObjectsV)
		{
			final Polygon m = new Polygon();
			m.addPoint((int) ((Profiles) M).x1al - 5, (int) ((Profiles) M).y1al);
			m.addPoint((int) ((Profiles) M).centerXs, (int) ((Profiles) M).centerYs);
			m.addPoint((int) ((Profiles) M).x2cl + 5, (int) ((Profiles) M).y2cl);
			m.addPoint((int) ((Profiles) M).x3cl + 5, (int) ((Profiles) M).y3cl);
			m.addPoint((int) ((Profiles) M).centerXe, (int) ((Profiles) M).centerYe);
			m.addPoint((int) ((Profiles) M).x4al - 5, (int) ((Profiles) M).y4al);

			if (m.contains(x, y))
			{
				goodToGo = false;
				duplicate = true;
				break;
			}

		}

		for (final Object M : myParentBO.mullionObjectsH)
		{
			final Polygon m = new Polygon();
			m.addPoint((int) ((Profiles) M).x1al, (int) ((Profiles) M).y1al + 5);
			m.addPoint((int) ((Profiles) M).centerXs, (int) ((Profiles) M).centerYs);
			m.addPoint((int) ((Profiles) M).x2cl, (int) ((Profiles) M).y2cl - 5);
			m.addPoint((int) ((Profiles) M).x3cl, (int) ((Profiles) M).y3cl - 5);
			m.addPoint((int) ((Profiles) M).centerXe, (int) ((Profiles) M).centerYe);
			m.addPoint((int) ((Profiles) M).x4al, (int) ((Profiles) M).y4al + 5);

			if (m.contains(x, y))
			{
				goodToGo = false;
				duplicate = true;
				break;
			}

		}

		if (goodToGo)
		{
			/*
			 * should also test for mullion type and then PartID to be the same.
			 */
			this.newHCRow(x, y);
			this.getStartStopCol(x, y);
			if (myParentBO.yRows > 1 && goodToGo)
			{
				// this.newHCRow(x, y);
				// this.getStartStopCol(x, y);

				for (final Object element : myParentBO.mullionObjectsH)
				{

					if (Math.max((int) ((Profiles) element).y1al, (int) ((Profiles) element).y4al) >= y
							&& //
							Math.min(
									//
									(int) ((Profiles) element).y2cl,
									(int) ((Profiles) element).y3cl) <= y
							&& (int) ((Profiles) element).centerXs <= x
							&& (int) ((Profiles) element).centerXe >= x)
					{
						duplicate = true;
						alreadyExist = 0;
						goodToGo = false;
						break;
					}
				}

				if (!duplicate)
				{
					alreadyExist = 1;
					if (posCondition == 2)
					{

						for (int vc = 0; vc < myParentBO.mullionObjectsH.length; vc++)
						{

							if (Math.max(
									(int) ((Profiles) myParentBO.mullionObjectsH[vc]).y1al + 5,
									(int) ((Profiles) myParentBO.mullionObjectsH[vc]).y4al + 5) >= y
									&& Math.min(
											(int) ((Profiles) myParentBO.mullionObjectsH[vc]).y2cl - 5,
											(int) ((Profiles) myParentBO.mullionObjectsH[vc]).y3cl - 5) <= y)
							{

								newHCRow = ((Profiles) myParentBO.mullionObjectsH[vc]).rowCol;
								alreadyExist = 2;

								if (((Profiles) myParentBO.mullionObjectsH[vc]).centerXs > x
										&& hcEnd + 1 == ((Profiles) myParentBO.mullionObjectsH[vc]).startPos)
								{
									if (((Profiles) myParentBO.mullionObjectsH[vc]).continuity == 2
											&& mType == ((Profiles) myParentBO.mullionObjectsH[vc]).mType)
									{

										this.extendLeftOfMulliontoLeft(vc);
										setVcontinuity = 3;
										alreadyExist = 3;
										newHCRow = ((Profiles) myParentBO.mullionObjectsH[vc]).rowCol;
										break;
									}
									else
									{

										alreadyExist = 2;
										newHCRow = ((Profiles) myParentBO.mullionObjectsH[vc]).rowCol;

										break;
									}
								}

							}
						}
					}
					else if (posCondition == 3)
					{

						for (int vc = 0; vc < myParentBO.mullionObjectsH.length; vc++)
						{

							if (Math.max(
									(int) ((Profiles) myParentBO.mullionObjectsH[vc]).y1al + 5,
									(int) ((Profiles) myParentBO.mullionObjectsH[vc]).y4al + 5) >= y
									&& Math.min(
											(int) ((Profiles) myParentBO.mullionObjectsH[vc]).y2cl - 5,
											(int) ((Profiles) myParentBO.mullionObjectsH[vc]).y3cl - 5) <= y)
							{

								newHCRow = ((Profiles) myParentBO.mullionObjectsH[vc]).rowCol;
								alreadyExist = 2;
								if (((Profiles) myParentBO.mullionObjectsH[vc]).centerXe < x
										&& ((Profiles) myParentBO.mullionObjectsH[vc]).endPos + 1 == hcStart)
								{
									if (((Profiles) myParentBO.mullionObjectsH[vc]).continuity == 2
											&& mType == ((Profiles) myParentBO.mullionObjectsH[vc]).mType)
									{

										this.extendRightOfMulliontoRight(vc);
										setVcontinuity = 3;
										alreadyExist = 3;
										newHCRow = ((Profiles) myParentBO.mullionObjectsH[vc]).rowCol;
										break;
									}
									else
									{

										alreadyExist = 2;
										newHCRow = ((Profiles) myParentBO.mullionObjectsH[vc]).rowCol;
										break;
									}

								}

							}
						}
					}
					else if (posCondition == 4)
					{

						boolean leftFound = false;
						boolean rightFound = false;
						boolean found = false;

						for (final Object element : myParentBO.mullionObjectsH)
						{
							if (Math.max((int) ((Profiles) element).y1al + 5,
									(int) ((Profiles) element).y4al + 5) >= y
									&& Math.min((int) ((Profiles) element).y2cl - 5,
											(int) ((Profiles) element).y3cl - 5) <= y)
							{

								if (((Profiles) element).centerXs > x && hcEnd + 1//
										== ((Profiles) element).startPos)
								{
									rightFound = true;

								}

								if (((Profiles) element).centerXe < x
										&& ((Profiles) element).endPos + 1 == hcStart)
								{
									leftFound = true;

								}
							}

						}

						for (int vc = 0; vc < myParentBO.mullionObjectsH.length; vc++)
						{

							if (found)
							{
								break;
							}
							if (Math.max(
									(int) ((Profiles) myParentBO.mullionObjectsH[vc]).y1al + 5,
									(int) ((Profiles) myParentBO.mullionObjectsH[vc]).y4al + 5) >= y
									&& Math.min(
											(int) ((Profiles) myParentBO.mullionObjectsH[vc]).y2cl - 5,
											(int) ((Profiles) myParentBO.mullionObjectsH[vc]).y3cl - 5) <= y)
							{

								newHCRow = ((Profiles) myParentBO.mullionObjectsH[vc]).rowCol;
								alreadyExist = 2;

								if (leftFound && !rightFound)
								{
									if (((Profiles) myParentBO.mullionObjectsH[vc]).continuity == 2
											&& mType == ((Profiles) myParentBO.mullionObjectsH[vc]).mType)
									{
										if (((Profiles) myParentBO.mullionObjectsH[vc]).centerXe < x
												&& ((Profiles) myParentBO.mullionObjectsH[vc]).endPos + 1 == hcStart)
										{
											this.extendRightOfMulliontoRight(vc);
											setVcontinuity = 3;
											alreadyExist = 3;
											newHCRow = ((Profiles) myParentBO.mullionObjectsH[vc]).rowCol;
											break;
										}
									}
									else
									{

										alreadyExist = 2;
										newHCRow = ((Profiles) myParentBO.mullionObjectsH[vc]).rowCol;

										break;
									}

								}
								else if (!leftFound && rightFound)
								{
									if (((Profiles) myParentBO.mullionObjectsH[vc]).continuity == 2
											&& mType == ((Profiles) myParentBO.mullionObjectsH[vc]).mType)
									{
										if (((Profiles) myParentBO.mullionObjectsH[vc]).centerXs > x
												&& hcEnd + 1//
												== ((Profiles) myParentBO.mullionObjectsH[vc]).startPos)
										{
											this.extendLeftOfMulliontoLeft(vc);
											setVcontinuity = 3;
											alreadyExist = 3;
											newHCRow = ((Profiles) myParentBO.mullionObjectsH[vc]).rowCol;
											break;
										}
									}
									else
									{

										alreadyExist = 2;
										newHCRow = ((Profiles) myParentBO.mullionObjectsH[vc]).rowCol;

										break;
									}
								}
								else if (leftFound && rightFound)
								{
									int b = 0;
									if (((Profiles) myParentBO.mullionObjectsH[vc]).continuity == 2
											&& mType == ((Profiles) myParentBO.mullionObjectsH[vc]).mType)
									{
										for (b = 0; b < myParentBO.mullionObjectsH.length; b++)
										{
											if (((Profiles) myParentBO.mullionObjectsH[b]).centerXe < x
													&& ((Profiles) myParentBO.mullionObjectsH[b]).endPos + 1 == hcStart)
											{

												setVcontinuity = 3;
												this.extendRightOfMulliontoRight(b);

												alreadyExist = 3;
												newHCRow = ((Profiles) myParentBO.mullionObjectsH[b]).rowCol;
												break;
											}
										}
									}

									for (int vc2 = 0; vc2 < myParentBO.mullionObjectsH.length; vc2++)
									{

										if (Math.max(
												(int) ((Profiles) myParentBO.mullionObjectsH[vc2]).y1al + 5,
												(int) ((Profiles) myParentBO.mullionObjectsH[vc2]).y4al + 5) >= y
												&& Math.min(
														(int) ((Profiles) myParentBO.mullionObjectsH[vc2]).y2cl - 5,
														(int) ((Profiles) myParentBO.mullionObjectsH[vc2]).y3cl - 5) <= y)
										{

											if (((Profiles) myParentBO.mullionObjectsH[vc2]).centerXs > x
													&& hcEnd + 1//
													== ((Profiles) myParentBO.mullionObjectsH[vc2]).startPos)
											{
												if (((Profiles) myParentBO.mullionObjectsH[vc2]).continuity == 2
														&& mType == ((Profiles) myParentBO.mullionObjectsH[vc2]).mType)
												{

													this.extendRightOfMulliontoRight(b, vc2); //
													setVcontinuity = 3;
													((Profiles) myParentBO.mullionObjectsH[vc2]).remove = true;
													found = true;
													alreadyExist = 3;
													newHCRow = ((Profiles) myParentBO.mullionObjectsH[vc]).rowCol;
													break;

												}

											}
										}
									}

								}
							}
						}

					}

				}// if poscond ==4

			}
		}else{
			JOptionPane.showMessageDialog(null,
					"Mouse clicked with a 5 pixel range of an existing Coupler/Mullion.", "ERROR!",
					JOptionPane.ERROR_MESSAGE);
			alreadyExist=-1;
		}
	}

	private void extendRightOfMulliontoRight(final int vc)
	{

		// getProfileDims(((Profiles) myParentBO.mullionObjectsH[vc]));
		double deltaX3cl = 0;
		double deltaX3 = 0;
		double deltaX4 = 0;
		double deltaX4al = 0;
		if (((Profiles) myParentBO.mullionObjectsH[vc]).endTypeRB == 1)
		{

			final double thetaC = Math
					.atan(((((Profiles) myParentBO.mullionObjectsH[vc]).partDimC + ((Profiles) myParentBO.mullionObjectsH[vc]).partDimB / 2) / (dimRA + dimRM)));

			final double thetaA = Math
					.atan(((((Profiles) myParentBO.mullionObjectsH[vc]).partDimA + ((Profiles) myParentBO.mullionObjectsH[vc]).partDimB / 2) / (dimRA + dimRM)));

			deltaX3cl = hcEndX - dimRA;

			deltaX3 = hcEndX + dimRM - ((Profiles) myParentBO.mullionObjectsH[vc]).partDimB / 2
					/ Math.tan(thetaA);

			deltaX4 = hcEndX + dimRM - ((Profiles) myParentBO.mullionObjectsH[vc]).partDimB / 2
					/ Math.tan(thetaC);

			deltaX4al = hcEndX - dimRA;

			((Profiles) myParentBO.mullionObjectsH[vc]).x3 = deltaX3;
			((Profiles) myParentBO.mullionObjectsH[vc]).x4 = deltaX4;
			((Profiles) myParentBO.mullionObjectsH[vc]).x3cl = deltaX3cl;
			((Profiles) myParentBO.mullionObjectsH[vc]).x4al = deltaX4al;

			((Profiles) myParentBO.mullionObjectsH[vc]).centerXe = ((Profiles) myParentBO.mullionObjectsH[vc]).centerXe
					+ hcEndX - ((Profiles) myParentBO.mullionObjectsH[vc]).centerXe + dimRM;

		}
		else
		{

			final double delta = hcEndX - ((Profiles) myParentBO.mullionObjectsH[vc]).x3;
			((Profiles) myParentBO.mullionObjectsH[vc]).x3 = ((Profiles) myParentBO.mullionObjectsH[vc]).x3
					+ delta;
			((Profiles) myParentBO.mullionObjectsH[vc]).x4 = ((Profiles) myParentBO.mullionObjectsH[vc]).x4
					+ delta;
			((Profiles) myParentBO.mullionObjectsH[vc]).x3cl = ((Profiles) myParentBO.mullionObjectsH[vc]).x3cl
					+ delta;
			((Profiles) myParentBO.mullionObjectsH[vc]).x4al = ((Profiles) myParentBO.mullionObjectsH[vc]).x4al
					+ delta;

			((Profiles) myParentBO.mullionObjectsH[vc]).centerXe = ((Profiles) myParentBO.mullionObjectsH[vc]).centerXe
					+ delta;

		}

		((Profiles) myParentBO.mullionObjectsH[vc]).endPos = hcEnd;
		((Profiles) myParentBO.mullionObjectsH[vc]).length = ((Profiles) myParentBO.mullionObjectsH[vc]).centerXe
				- ((Profiles) myParentBO.mullionObjectsH[vc]).centerXs;

		alreadyExist = 3;
	}

	private void extendRightOfMulliontoRight(final int vc, final int vc2)
	{

		// getProfileDims(((Profiles) myParentBO.mullionObjectsH[vc]));
		((Profiles) myParentBO.mullionObjectsH[vc]).x3 = ((Profiles) myParentBO.mullionObjectsH[vc2]).x3;
		((Profiles) myParentBO.mullionObjectsH[vc]).x4 = ((Profiles) myParentBO.mullionObjectsH[vc2]).x4;
		((Profiles) myParentBO.mullionObjectsH[vc]).x3cl = ((Profiles) myParentBO.mullionObjectsH[vc2]).x3cl;
		((Profiles) myParentBO.mullionObjectsH[vc]).x4al = ((Profiles) myParentBO.mullionObjectsH[vc2]).x4al;

		((Profiles) myParentBO.mullionObjectsH[vc]).centerXe = ((Profiles) myParentBO.mullionObjectsH[vc2]).centerXe;

		((Profiles) myParentBO.mullionObjectsH[vc]).endPos = ((Profiles) myParentBO.mullionObjectsH[vc2]).endPos;
		((Profiles) myParentBO.mullionObjectsH[vc]).endTypeRB = ((Profiles) myParentBO.mullionObjectsH[vc2]).endTypeRB;

		((Profiles) myParentBO.mullionObjectsH[vc]).length = ((Profiles) myParentBO.mullionObjectsH[vc]).centerXe
				- ((Profiles) myParentBO.mullionObjectsH[vc]).centerXs;

		alreadyExist = 3;

	}

	private void extendLeftOfMulliontoLeft(final int vc)
	{

		// getProfileDims(((Profiles) myParentBO.mullionObjectsH[vc]));
		double deltaX2cl = 0;
		double deltaX2 = 0;
		double deltaX1 = 0;
		double deltaX1al = 0;

		if (((Profiles) myParentBO.mullionObjectsH[vc]).endTypeRB == 1)
		{

			final double thetaC = Math.atan(((((Profiles) myParentBO.mullionObjectsH[vc]).partDimC + //
					((Profiles) myParentBO.mullionObjectsH[vc]).partDimB / //
					2) / (dimLA + dimLM)));

			final double thetaA = Math.atan(((((Profiles) myParentBO.mullionObjectsH[vc]).partDimA + //
					((Profiles) myParentBO.mullionObjectsH[vc]).partDimB / 2) / //
					(dimLA + dimLM)));

			deltaX2cl = hcStartX + dimLA;

			deltaX2 = hcStartX - dimLM + ((Profiles) myParentBO.mullionObjectsH[vc]).partDimB / 2
					/ Math.tan(thetaA);

			deltaX1 = hcStartX - dimLM + ((Profiles) myParentBO.mullionObjectsH[vc]).partDimB / 2
					/ Math.tan(thetaC);

			deltaX1al = hcStartX + dimLA;

			((Profiles) myParentBO.mullionObjectsH[vc]).x2 = deltaX2;
			((Profiles) myParentBO.mullionObjectsH[vc]).x1 = deltaX1;
			((Profiles) myParentBO.mullionObjectsH[vc]).x2cl = deltaX2cl;
			((Profiles) myParentBO.mullionObjectsH[vc]).x1al = deltaX1al;

			((Profiles) myParentBO.mullionObjectsH[vc]).centerXs = ((Profiles) myParentBO.mullionObjectsH[vc]).centerXs
					- (((Profiles) myParentBO.mullionObjectsH[vc]).centerXs - hcStartX) - dimLM;

		}
		else
		{

			final double delta = ((Profiles) myParentBO.mullionObjectsH[vc]).x2 - hcStartX;
			((Profiles) myParentBO.mullionObjectsH[vc]).x2 = ((Profiles) myParentBO.mullionObjectsH[vc]).x2
					- delta;
			((Profiles) myParentBO.mullionObjectsH[vc]).x1 = ((Profiles) myParentBO.mullionObjectsH[vc]).x1
					- delta;
			((Profiles) myParentBO.mullionObjectsH[vc]).x2cl = ((Profiles) myParentBO.mullionObjectsH[vc]).x2cl
					- delta;
			((Profiles) myParentBO.mullionObjectsH[vc]).x1al = ((Profiles) myParentBO.mullionObjectsH[vc]).x1al
					- delta;

			((Profiles) myParentBO.mullionObjectsH[vc]).centerXs = ((Profiles) myParentBO.mullionObjectsH[vc]).centerXs
					- delta;
		}

		((Profiles) myParentBO.mullionObjectsH[vc]).startPos = hcStart;
		((Profiles) myParentBO.mullionObjectsH[vc]).length = ((Profiles) myParentBO.mullionObjectsH[vc]).centerXe
				- ((Profiles) myParentBO.mullionObjectsH[vc]).centerXs;
		// getLimitingObjects(
		// ((Profiles)
		// this.myParent.mullionObjectsH[vc]).startPos,//
		// ((Profiles)
		// this.myParent.mullionObjectsH[vc]).endPos,
		// //
		// (Math.min(
		// ((Profiles)
		// this.myParent.mullionObjectsH[vc]).y2cl,
		// ((Profiles)
		// this.myParent.mullionObjectsH[vc]).y3cl)
		// +
		// Math
		// .max(((Profiles)
		// this.myParent.mullionObjectsH[vc]).y1al,
		// ((Profiles)
		// this.myParent.mullionObjectsH[vc]).y4al))
		// /
		// 2);
		// ((Profiles)
		// this.myParent.mullionObjectsH[vc]).posCondition
		// =
		// this.posCondition;

		alreadyExist = 3;

	}

	public void newHCRow(final int x, final int y)
	{

		newHCRow = 1;
		int row = 0;
		double minDelta = 10000;

		int isBefore = 0; // 0=equal 1= true 2=false
		myParentBO.mullionObjectsH = null;
		myParentBO.mullionObjectsH = myParentBO.mullionsH.toArray();
		for (int c = 0; c < myParentBO.mullionObjectsH.length; c++)
		{

			if (y < Math.min((int) ((Profiles) myParentBO.mullionObjectsH[c]).y2cl,
					(int) ((Profiles) myParentBO.mullionObjectsH[c]).y3cl))
			{
				((Profiles) myParentBO.mullionObjectsH[c]).isBefore = 1;
				((Profiles) myParentBO.mullionObjectsH[c]).tempDelta = Math.max(
						(int) ((Profiles) myParentBO.mullionObjectsH[c]).y1al,
						(int) ((Profiles) myParentBO.mullionObjectsH[c]).y4al)
						- y;
			}
			else if (y > Math.max((int) ((Profiles) myParentBO.mullionObjectsH[c]).y1al,
					(int) ((Profiles) myParentBO.mullionObjectsH[c]).y4al))
			{
				((Profiles) myParentBO.mullionObjectsH[c]).isBefore = 2;
				((Profiles) myParentBO.mullionObjectsH[c]).tempDelta = y
						- Math.max((int) ((Profiles) myParentBO.mullionObjectsH[c]).y1al,
								(int) ((Profiles) myParentBO.mullionObjectsH[c]).y4al);
			}
			else
			{
				((Profiles) myParentBO.mullionObjectsH[c]).isBefore = 0;
				((Profiles) myParentBO.mullionObjectsH[c]).tempDelta = 0;
			}

		}

		for (final Object element : myParentBO.mullionObjectsH)
		{

			if (((Profiles) element).tempDelta <= minDelta)
			{
				minDelta = ((Profiles) element).tempDelta;
				row = ((Profiles) element).rowCol;
				isBefore = ((Profiles) element).isBefore;
			}

		}

		if (myParentBO.mullionObjectsH.length == 0)
		{
			newHCRow = 1;
		}
		else
		{

			if (isBefore == 0)
			{
				newHCRow = row;

			}
			else if (isBefore == 1)
			{
				newHCRow = row;
			}
			else
			{
				newHCRow = row + 1;
			}

		}

	}

	public void getStartStopCol(final int x, final int y)
	{

		newHCCol = 1;
		hcStart = 1;
		hcEnd = myParentBO.xCols;
		hcStartX = myParentBO.startingX;
		hcEndX = myParentBO.bX2;
		dimLM = myParentBO.dimLM;
		dimLA = myParentBO.dimLA;
		dimRM = myParentBO.dimRM;
		dimRA = myParentBO.dimRA;
		endIn = false;
		startIn = false;
		myParentBO.mullionObjectsV = myParentBO.mullions.toArray();

		//

		if (myParentBO.mullionObjectsV.length == 0)
		{
			newHCCol = 1;
			hcStart = 1;
			hcEnd = 1;
			hcStartX = myParentBO.startingX;
			hcEndX = myParentBO.bX2;
			posCondition = 1;

		}
		else
		{
			this.getStartPosition(x, y);

			this.getEndPosition(x, y);

		}

		if (!startIn && !endIn)
		{
			posCondition = 1;
		}
		else if (!startIn && endIn)
		{
			posCondition = 2;
		}
		else if (startIn && !endIn)
		{
			posCondition = 3;
		}
		else
		{
			posCondition = 4;
		}

	}

	public void getLimitingObjects(final int start, final int end, final double cY)
	{

		if (myParentBO.mullionsH.size() > 0 && myParentBO.mullionObjectsH == null)
		{
			myParentBO.mullionObjectsH = myParentBO.mullionsH.toArray();
		}
		if (myParentBO.mullions.size() > 0 && myParentBO.mullionObjectsV == null)
		{
			myParentBO.mullionObjectsV = myParentBO.mullions.toArray();
		}
		if (start == 1)
		{

			limitStartXsA = myParentBO.myParent.left.startXA;
			limitStartYsA = myParentBO.myParent.left.startYA;
			limitStartXeA = myParentBO.myParent.left.endXA;
			limitStartYeA = myParentBO.myParent.left.endYA;
			limitStartXsBA = myParentBO.myParent.left.startXBA;
			limitStartYsBA = myParentBO.myParent.left.startYBA;
			limitStartXeBA = myParentBO.myParent.left.endXBA;
			limitStartYeBA = myParentBO.myParent.left.endYBA;
			dimLM = myParentBO.myParent.left.partDimM;
			dimLA = myParentBO.myParent.left.partDimA;

			startIn = false;
		}
		else if (start > 1)
		{
			boolean found = false;
			for (final Object element : myParentBO.mullionObjectsV)
			{
				// getProfileDims(((Profiles) element));
				if (((Profiles) element).rowCol + 1 == start && ((Profiles) element).y3cl > cY
						&& ((Profiles) element).y2cl < cY)
				{

					dimLM = ((Profiles) element).partDimM;
					dimLA = ((Profiles) element).partDimC;
					limitStartXsA = ((Profiles) element).x2cl;
					limitStartYsA = ((Profiles) element).y2cl;
					limitStartXeA = ((Profiles) element).x3cl;
					limitStartYeA = ((Profiles) element).y3cl;
					limitStartXsBA = ((Profiles) element).x2;
					limitStartYsBA = ((Profiles) element).y2;
					limitStartXeBA = ((Profiles) element).x3;
					limitStartYeBA = ((Profiles) element).y3;
					startIn = true;
					found = true;
					break;
				}

			}
			if (!found)
			{
				if (myParentBO.noSidesTop > 1
						&& myParentBO.top1Part.startYC < myParentBO.top1Part.endYC)
				{
					limitStartXsA = myParentBO.myParent.top1Part.startXA;
					limitStartYsA = myParentBO.myParent.top1Part.startYA;
					limitStartXeA = myParentBO.myParent.top1Part.endXA;
					limitStartYeA = myParentBO.myParent.top1Part.endYA;
					limitStartXsBA = myParentBO.myParent.top1Part.startXBA;
					limitStartYsBA = myParentBO.myParent.top1Part.startYBA;
					limitStartXeBA = myParentBO.myParent.top1Part.endXBA;
					limitStartYeBA = myParentBO.myParent.top1Part.endYBA;
					dimLM = myParentBO.myParent.top1Part.partDimM;
					dimLA = myParentBO.myParent.top1Part.partDimA;
					startIn = true;
				}

			}

		}

		if (end == myParentBO.xCols)
		{

			limitEndXsA = myParentBO.myParent.right.startXA;
			limitEndYsA = myParentBO.myParent.right.startYA;
			limitEndXeA = myParentBO.myParent.right.endXA;
			limitEndYeA = myParentBO.myParent.right.endYA;
			limitEndXsBA = myParentBO.myParent.right.startXBA;
			limitEndYsBA = myParentBO.myParent.right.startYBA;
			limitEndXeBA = myParentBO.myParent.right.endXBA;
			limitEndYeBA = myParentBO.myParent.right.endYBA;
			dimRM = myParentBO.myParent.right.partDimM;
			dimRA = myParentBO.myParent.right.partDimA;
			endIn = false;
		}
		else if (end < myParentBO.xCols)
		{
			boolean found = false;
			for (final Object element : myParentBO.mullionObjectsV)
			{
				// getProfileDims(((Profiles) element));
				if (((Profiles) element).rowCol == end && ((Profiles) element).y4al > cY
						&& ((Profiles) element).y1al < cY)
				{

					dimRM = ((Profiles) element).partDimM;
					dimRA = ((Profiles) element).partDimA;
					limitEndXsA = ((Profiles) element).x1al;
					limitEndYsA = ((Profiles) element).y1al;
					limitEndXeA = ((Profiles) element).x4al;
					limitEndYeA = ((Profiles) element).y4al;
					limitEndXsBA = ((Profiles) element).x1;
					limitEndYsBA = ((Profiles) element).y1;
					limitEndXeBA = ((Profiles) element).x4;
					limitEndYeBA = ((Profiles) element).y4;
					endIn = true;
					found = true;
					break;
				}
				// else if ((((Profiles) element).rowCol == end)
				// && (((Profiles) element).y4al > cY)
				// && (((Profiles) element).y1al < cY) && (((Profiles)
				// element).thickness<=0))
				// {
				// //??????
				// }

			}
			if (!found)
			{
				if (myParentBO.noSidesTop > 1
						&& myParentBO.top2Part.startYC < myParentBO.top2Part.endYC)
				{
					limitStartXsA = myParentBO.myParent.top2Part.startXA;
					limitStartYsA = myParentBO.myParent.top2Part.startYA;
					limitStartXeA = myParentBO.myParent.top2Part.endXA;
					limitStartYeA = myParentBO.myParent.top2Part.endYA;
					limitStartXsBA = myParentBO.myParent.top2Part.startXBA;
					limitStartYsBA = myParentBO.myParent.top2Part.startYBA;
					limitStartXeBA = myParentBO.myParent.top2Part.endXBA;
					limitStartYeBA = myParentBO.myParent.top2Part.endYBA;
					dimLM = myParentBO.myParent.top2Part.partDimM;
					dimLA = myParentBO.myParent.top2Part.partDimA;
					endIn = true;
				}
				else if (myParentBO.noSidesTop == 1
						&& myParentBO.top1Part.startYC < myParentBO.top1Part.endYC)
				{
					limitStartXsA = myParentBO.myParent.top1Part.startXA;
					limitStartYsA = myParentBO.myParent.top1Part.startYA;
					limitStartXeA = myParentBO.myParent.top1Part.endXA;
					limitStartYeA = myParentBO.myParent.top1Part.endYA;
					limitStartXsBA = myParentBO.myParent.top1Part.startXBA;
					limitStartYsBA = myParentBO.myParent.top1Part.startYBA;
					limitStartXeBA = myParentBO.myParent.top1Part.endXBA;
					limitStartYeBA = myParentBO.myParent.top1Part.endYBA;
					dimLM = myParentBO.myParent.top1Part.partDimM;
					dimLA = myParentBO.myParent.top1Part.partDimA;
					endIn = true;
				}
			}
		}

		if (!startIn && !endIn)
		{
			posCondition = 1;
		}
		else if (!startIn && endIn)
		{
			posCondition = 2;
		}
		else if (startIn && !endIn)
		{
			posCondition = 3;
		}
		else
		{
			posCondition = 4;
		}

	}

	private void getEndPosition(final int x, final int y)
	{

		double delta;
		double minDeltab = 100000000;
		int closestb = 0;

		final Object[] mVs = myParentBO.mullions.toArray();

		for (final Object mV : mVs)
		{
			delta = 0;

			if (((Profiles) mV).x1al > x && ((Profiles) mV).y1al < y && ((Profiles) mV).y4al > y)
			{

				delta = ((Profiles) mV).x1al - x;
				if (delta <= minDeltab)
				{
					minDeltab = delta;
					closestb = ((Profiles) mV).rowCol;
					hcEndX = ((Profiles) mV).x1;
					hcEnd = closestb;
					dimRM = ((Profiles) mV).partDimM;
					dimRA = ((Profiles) mV).partDimA;
					limitEndXsA = ((Profiles) mV).x1al;
					limitEndYsA = ((Profiles) mV).y1al;
					limitEndXeA = ((Profiles) mV).x4al;
					limitEndYeA = ((Profiles) mV).y4al;
					limitEndXsBA = ((Profiles) mV).x1;
					limitEndYsBA = ((Profiles) mV).y1;
					limitEndXeBA = ((Profiles) mV).x4;
					limitEndYeBA = ((Profiles) mV).y4;
					if (closestb == 1)
					{
						newHCCol = 1;
						// this.hcStart
						// = 1;
						hcEnd = 1;
						// this.hcStartX
						// =
						// this.myParentBO.startingY;
						hcEndX = ((Profiles) mV).x1;
						dimRM = ((Profiles) mV).partDimM;
						dimRA = ((Profiles) mV).partDimA;
						limitEndXsA = ((Profiles) mV).x1al;
						limitEndYsA = ((Profiles) mV).y1al;
						limitEndXeA = ((Profiles) mV).x4al;
						limitEndYeA = ((Profiles) mV).y4al;
						limitEndXsBA = ((Profiles) mV).x1;
						limitEndYsBA = ((Profiles) mV).y1;
						limitEndXeBA = ((Profiles) mV).x4;
						limitEndYeBA = ((Profiles) mV).y4;
					}
					endIn = true;
				}
				// }

			}
		}
		// if (this.hcEnd == 1 && this.hcStart > 1
		// && this.myParent.mullionObjectsV.length >
		// 0) {
		// this.hcEndX = this.myParentBO.bX2;
		// this.hcEnd = this.myParent.xCols;
		// this.dimRM = ((Profiles)
		// this.myParent.mullionObjectsV[c]).partDimM;
		// this.dimRA = ((Profiles)
		// this.myParent.mullionObjectsV[c]).partDimA;
		//
		// }
	}

	private void getStartPosition(final int x, final int y)
	{

		double delta;
		double minDeltaa = 100000000;
		int closesta = 0;

		final Object[] mVs = myParentBO.mullions.toArray();

		for (final Object mV : mVs)
		{
			delta = 0;

			if (((Profiles) mV).x2cl <= x && ((Profiles) mV).y2cl < y && ((Profiles) mV).y3cl > y)
			{

				delta = x - ((Profiles) mV).x2cl;
				if (delta <= minDeltaa)
				{
					minDeltaa = delta;
					closesta = ((Profiles) mV).rowCol;
					hcStartX = ((Profiles) mV).x2;
					hcStart = closesta + 1;
					newHCCol = closesta + 1;

					dimLM = ((Profiles) mV).partDimM;
					dimLA = ((Profiles) mV).partDimC;
					limitStartXsA = ((Profiles) mV).x2cl;
					limitStartYsA = ((Profiles) mV).y2cl;
					limitStartXeA = ((Profiles) mV).x3cl;
					limitStartYeA = ((Profiles) mV).y3cl;
					limitStartXsBA = ((Profiles) mV).x2;
					limitStartYsBA = ((Profiles) mV).y2;
					limitStartXeBA = ((Profiles) mV).x3;
					limitStartYeBA = ((Profiles) mV).y3;

					startIn = true;
					// break;
				}
				else
				{
					break;
				}

			}
			else
			{
				// this.newHCCol = 1;
				// this.hcStart = 1;
				// // this.hcEnd = 1;
				// this.hcStartX =
				// this.myParentBO.startingX;
				// // this.hcEndX =
				// this.myParentBO.bX2;
				// this.startIn = false;
				// this.dimLM =
				// this.myParentBO.dimLM;
				// this.dimLA =
				// this.myParentBO.dimLA;
			}

		}

	}

	public void getMyMullionH()
	{

		for (int vc = 0; vc < myParentBO.mullionObjectsH.length; vc++)
		{

			if (((Profiles) myParentBO.mullionObjectsH[vc]).rowCol == newHCRow

			&& ((Profiles) myParentBO.mullionObjectsH[vc]).endPos >= hcEnd
					&& ((Profiles) myParentBO.mullionObjectsH[vc]).startPos <= hcStart

					&& !((Profiles) myParentBO.mullionObjectsH[vc]).remove)
			{

				myParentBO.myProfilesH = (Profiles) myParentBO.mullionObjectsH[vc];
				myParentBO.mullionH = myParentBO.myProfilesH;
			}

		}
	}

	public void recalcInitOpenings()
	{

		int prevShape = 1;
		int newShape = 1;
		// if (this.myParent.wire) {

		final Object[] initOpeningObjects = myParentBO.myParent.openings.toArray();
		myParentBO.myParent.openings.clear();

		int frameEndCol = 0;
		int frameEndRow = 0;

		boolean done = false;
		int shape = 0;
		int startcol = 0;
		int startrow = 0;
		int endcol = 0;
		int endrow = 0;

		for (final Object initOpeningObject : initOpeningObjects)
		{
			done = false;
			if (((OpeningObject) initOpeningObject).startCol == newHCCol)
			{
				if (((OpeningObject) initOpeningObject).endRow >= newHCRow
						&& ((OpeningObject) initOpeningObject).startRow <= newHCRow)
				{

					frameEndCol = ((OpeningObject) initOpeningObject).endCol;
					if (alreadyExist == 1)
					{
						frameEndRow = ((OpeningObject) initOpeningObject).endRow + 1;
					}
					else
					{
						frameEndRow = ((OpeningObject) initOpeningObject).endRow;
					}
					final ShapeDivision shapeDiv = new ShapeDivision(
							((OpeningObject) initOpeningObject).shapeID, 2, cOrM);
					
					if(this.myParentBO.top1Part.partForm>1 && myParentBO.yRows==1){
						
						if(shapeDiv.resultLT==200){
							shapeDiv.resultLT=303;
						}
						
					}

					if (shapeDiv.hcPossible)
					{
						if (cOrM <= 2)
						{
							if (((OpeningObject) initOpeningObject).contentMid == 2)
							{
								myParentBO.mullionH.openingIDRT = ((OpeningObject) initOpeningObject).sashObjectMid.userDefinedOpeningID;
								myParentBO.mullionH.openingTypeRT = ((OpeningObject) initOpeningObject).sashObjectMid.openingClass;
							}
							else if (((OpeningObject) initOpeningObject).contentMid == 3)
							{
								myParentBO.mullionH.openingIDRT = ((OpeningObject) initOpeningObject).userDefinedOpeningID;
								myParentBO.mullionH.openingTypeRT = ((OpeningObject) initOpeningObject).openingClass;
							}
							else
							{
								myParentBO.mullionH.openingIDRT = 1;
								myParentBO.mullionH.openingTypeRT = 0;
							}

							myParentBO.mullionH.openingIDLB = 1;
							myParentBO.mullionH.openingTypeLB = 0;
						}

						prevShape = shapeDiv.resultLT;
						newShape = shapeDiv.resultRB;
						
						if(this.myParentBO.top1Part.partForm>1 && myParentBO.yRows==1){
							
							if(shapeDiv.resultLT==200){
								shapeDiv.resultLT=303;
							}
							
						}
						
						
						shape = prevShape;
						startcol = ((OpeningObject) initOpeningObject).startCol;
						startrow = ((OpeningObject) initOpeningObject).startRow;
						endcol = ((OpeningObject) initOpeningObject).endCol;
						endrow = newHCRow;

						myParentBO.myParent.openings.add(this.setOpening(shape, startcol, startrow,
								endcol, endrow, initOpeningObject, false,
								((OpeningObject) initOpeningObject).topIn, true,
								myParentBO.mullionH));

						shape = newShape;
						startcol = newHCCol;
						startrow = newHCRow + 1;
						endcol = frameEndCol;
						endrow = frameEndRow;
						myParentBO.myParent.openings.add(this.setOpening(shape, startcol, startrow,
								endcol, endrow, initOpeningObject, true, true,
								((OpeningObject) initOpeningObject).botIn, myParentBO.mullionH));

						done = true;
					}
					else
					{
						goodToDivide = false;
					}
				}
				else if (((OpeningObject) initOpeningObject).startRow > newHCRow
						&& alreadyExist == 1)
				{

					shape = ((OpeningObject) initOpeningObject).shapeID;
					startcol = ((OpeningObject) initOpeningObject).startCol;
					startrow = ((OpeningObject) initOpeningObject).startRow + 1;
					endcol = ((OpeningObject) initOpeningObject).endCol;
					endrow = ((OpeningObject) initOpeningObject).endRow + 1;
					myParentBO.myParent.openings.add(this.setOpening(shape, startcol, startrow,
							endcol, endrow, initOpeningObject, false,
							((OpeningObject) initOpeningObject).topIn,
							((OpeningObject) initOpeningObject).botIn, myParentBO.mullionH));
					done = true;
				}
				else if (((OpeningObject) initOpeningObject).startRow > newHCRow
						&& alreadyExist != 1)
				{

					shape = ((OpeningObject) initOpeningObject).shapeID;
					startcol = ((OpeningObject) initOpeningObject).startCol;
					startrow = ((OpeningObject) initOpeningObject).startRow;
					endcol = ((OpeningObject) initOpeningObject).endCol;
					endrow = ((OpeningObject) initOpeningObject).endRow;
					myParentBO.myParent.openings.add(this.setOpening(shape, startcol, startrow,
							endcol, endrow, initOpeningObject, false,
							((OpeningObject) initOpeningObject).topIn,
							((OpeningObject) initOpeningObject).botIn, myParentBO.mullionH));
					done = true;
				}
				else if (((OpeningObject) initOpeningObject).endRow < newHCRow)
				{

					shape = ((OpeningObject) initOpeningObject).shapeID;
					startcol = ((OpeningObject) initOpeningObject).startCol;
					startrow = ((OpeningObject) initOpeningObject).startRow;
					endcol = ((OpeningObject) initOpeningObject).endCol;
					endrow = ((OpeningObject) initOpeningObject).endRow;
					myParentBO.myParent.openings.add(this.setOpening(shape, startcol, startrow,
							endcol, endrow, initOpeningObject, false,
							((OpeningObject) initOpeningObject).topIn,
							((OpeningObject) initOpeningObject).botIn, myParentBO.mullionH));
					done = true;
				}

			}
			// Other Columns
			else
			{
				if (((OpeningObject) initOpeningObject).startRow > newHCRow && alreadyExist == 1)
				{

					shape = ((OpeningObject) initOpeningObject).shapeID;
					startcol = ((OpeningObject) initOpeningObject).startCol;
					startrow = ((OpeningObject) initOpeningObject).startRow + 1;
					endcol = ((OpeningObject) initOpeningObject).endCol;
					endrow = ((OpeningObject) initOpeningObject).endRow + 1;
					myParentBO.myParent.openings.add(this.setOpening(shape, startcol, startrow,
							endcol, endrow, initOpeningObject, false,
							((OpeningObject) initOpeningObject).topIn,
							((OpeningObject) initOpeningObject).botIn, myParentBO.mullionH));
					done = true;
				}
				else if (((OpeningObject) initOpeningObject).endRow < newHCRow)
				{

					shape = ((OpeningObject) initOpeningObject).shapeID;
					startcol = ((OpeningObject) initOpeningObject).startCol;
					startrow = ((OpeningObject) initOpeningObject).startRow;
					endcol = ((OpeningObject) initOpeningObject).endCol;
					endrow = ((OpeningObject) initOpeningObject).endRow;
					myParentBO.myParent.openings.add(this.setOpening(shape, startcol, startrow,
							endcol, endrow, initOpeningObject, false,
							((OpeningObject) initOpeningObject).topIn,
							((OpeningObject) initOpeningObject).botIn, myParentBO.mullionH));
					done = true;
				}
				else if (((OpeningObject) initOpeningObject).endRow >= newHCRow
						&& alreadyExist == 1)
				{

					shape = ((OpeningObject) initOpeningObject).shapeID;
					startcol = ((OpeningObject) initOpeningObject).startCol;
					startrow = ((OpeningObject) initOpeningObject).startRow;
					endcol = ((OpeningObject) initOpeningObject).endCol;
					endrow = ((OpeningObject) initOpeningObject).endRow + 1;
					myParentBO.myParent.openings.add(this.setOpening(shape, startcol, startrow,
							endcol, endrow, initOpeningObject, false,
							((OpeningObject) initOpeningObject).topIn,
							((OpeningObject) initOpeningObject).botIn, myParentBO.mullionH));
					done = true;
				}
				else if (((OpeningObject) initOpeningObject).endRow >= newHCRow
						&& alreadyExist != 1)
				{

					shape = ((OpeningObject) initOpeningObject).shapeID;
					startcol = ((OpeningObject) initOpeningObject).startCol;
					startrow = ((OpeningObject) initOpeningObject).startRow;
					endcol = ((OpeningObject) initOpeningObject).endCol;
					endrow = ((OpeningObject) initOpeningObject).endRow;
					myParentBO.myParent.openings.add(this.setOpening(shape, startcol, startrow,
							endcol, endrow, initOpeningObject, false,
							((OpeningObject) initOpeningObject).topIn,
							((OpeningObject) initOpeningObject).botIn, myParentBO.mullionH));
					done = true;
				}

			}
			if (!done)
			{
				shape = ((OpeningObject) initOpeningObject).shapeID;
				startcol = ((OpeningObject) initOpeningObject).startCol;
				startrow = ((OpeningObject) initOpeningObject).startRow;
				endcol = ((OpeningObject) initOpeningObject).endCol;
				endrow = ((OpeningObject) initOpeningObject).endRow;
				myParentBO.myParent.openings.add(this.setOpening(shape, startcol, startrow, endcol,
						endrow, initOpeningObject, false,
						((OpeningObject) initOpeningObject).topIn,
						((OpeningObject) initOpeningObject).botIn, myParentBO.mullionH));

			}

		}

	}

	public OpeningObject setOpening(final int shape, final int startCol, final int startRow,
			final int endCol, final int endRow, final Object opening, final boolean isNew,
			final boolean topIn, final boolean botIn, final Profiles myMullion)
	{

		OpeningObject myInitOpening = new OpeningObject(myFrame2);
		myInitOpening = ((OpeningObject) opening).cloneOpening((OpeningObject) opening);

		myInitOpening.shapeID = shape;

		if (!isNew)
		{
			myInitOpening.lastSeq = Integer.valueOf(String.valueOf(myInitOpening.startRow)
					+ String.valueOf(myInitOpening.startCol));
			if (myInitOpening.endRow >= this.newHCRow && myInitOpening.startRow <= this.newHCRow
					&& myInitOpening.endCol <= this.hcEnd && myInitOpening.startCol >= this.hcStart)
			{
				myInitOpening.myMullionBot = myMullion;
			}
		}
		else
		{
			myInitOpening.myMullionTop = myMullion;
		}
		myInitOpening.a_sequenceID = Integer.valueOf(String.valueOf(startRow)
				+ String.valueOf(startCol));

		myInitOpening.startCol = startCol;

		myInitOpening.endCol = endCol;
		myInitOpening.startRow = startRow;
		myInitOpening.topIn = topIn;
		myInitOpening.botIn = botIn;
		myInitOpening.endRow = endRow;

		return myInitOpening;
	}

	public OpeningObject myClone(final OpeningObject init, final OpeningObject original)
	{

		init.myParent = original.myParent;
		// init.scale = original.scale;

		init.shapeID = original.shapeID;

		init.contentIn = original.contentIn;
		init.contentOut = original.contentOut;
		init.contentMid = original.contentMid;
		init.sashObjectIn = original.sashObjectIn;
		init.sashObjectOut = original.sashObjectOut;
		init.sashObjectMid = original.sashObjectMid;

		init.startingX = original.startingX;
		init.startingY = original.startingY;
		init.startCol = original.startCol;
		init.endCol = original.endCol;
		init.startRow = original.startRow;
		init.endRow = original.endRow;
		init.rID = original.rID;
		init.a_levelID = original.a_levelID;
		// init.widthPix = original.widthPix;
		init.heightPix = original.heightPix;

		init.shapeID = original.shapeID;
		init.startingX = original.startingX;
		init.startingY = original.startingY;

		init.radius1 = original.radius1;
		init.radius2 = original.radius2;

		init.bkgrdStartX = original.bkgrdStartX;
		init.bkgrdStartY = original.bkgrdStartY;

		init.noSides = original.noSides;
		init.noSidesTop = original.noSidesTop;
		init.noSidesBot = original.noSidesBot;
		init.noSidesLeft = original.noSidesLeft;
		init.noSidesRight = original.noSidesRight;

		init.centerPointX = original.centerPointX;
		init.centerPointX2 = original.centerPointX2;
		init.centerPointY = original.centerPointY;
		init.centerPointY2 = original.centerPointY2;

		init.bX2 = original.bX2;
		init.bY2 = original.bY2;
		init.bX3 = original.bX3;
		init.bY3 = original.bY3;
		init.bX4 = original.bX4;
		init.bY4 = original.bY4;
		init.startingCX = original.startingCX;
		init.startingCY = original.startingCY;

		init.bCX2 = original.bCX2;
		init.bCY2 = original.bCY2;
		init.bCX3 = original.bCX3;
		init.bCY3 = original.bCY3;
		init.bCX4 = original.bCX4;
		init.bCY4 = original.bCY4;
		init.dimA1 = original.dimA1;
		init.dimA2 = original.dimA2;
		init.dimA3 = original.dimA3;
		init.dimA4 = original.dimA4;
		init.dimA5 = original.dimA5;
		init.dimA0 = original.dimA0;
		init.dimB1 = original.dimB1;
		init.dimB2 = original.dimB2;
		init.dimB3 = original.dimB3;
		init.dimB4 = original.dimB4;
		init.dimB5 = original.dimB5;
		init.dimB0 = original.dimB0;
		init.dimC1 = original.dimC1;
		init.dimC2 = original.dimC2;
		init.dimC3 = original.dimC3;
		init.dimC4 = original.dimC4;
		init.dimC5 = original.dimC5;
		init.dimC0 = original.dimC0;
		init.dimD1 = original.dimD1;
		init.dimD2 = original.dimD2;
		init.dimD3 = original.dimD3;
		init.dimD4 = original.dimD4;
		init.dimD5 = original.dimD5;
		init.dimD0 = original.dimD0;

		init.dimTM = original.dimTM;
		init.dimBM = original.dimBM;
		init.dimLM = original.dimLM;
		init.dimRM = original.dimRM;
		init.dimTA = original.dimTA;
		init.dimBA = original.dimBA;
		init.dimLA = original.dimLA;
		init.dimRA = original.dimRA;
		;

		init.topIn = original.topIn;
		init.botIn = original.botIn;
		init.leftIn = original.leftIn;
		init.rightIn = original.rightIn;

		init.lean = 0;
		init.lean2 = 0;
		init.lean3 = 0;
		init.lean4 = 0;

		init.parentH = original.parentH;
		init.parentW = original.parentW;
		init.parentStartY = original.parentStartY;
		init.parentStartX = original.parentStartX;
		init.parentRadius1 = original.parentRadius1;// *
		// 2;

		init.parentCX = original.parentCX;
		init.parentCY = original.parentCY;
		init.parentCX2 = original.parentCX2;
		init.parentCY2 = original.parentCY2;
		init.parentShape = original.parentShape;
		init.px1 = original.px1;
		init.py1 = original.py1;
		init.px2 = original.px2;
		init.py2 = original.py2;
		init.px3 = original.px3;
		init.py3 = original.py3;
		init.px4 = original.px4;
		init.py4 = original.py4;
		init.px5 = original.px5;
		init.py5 = original.py5;
		init.px6 = original.px6;
		init.py6 = original.py6;
		init.px7 = original.px7;
		init.py7 = original.py7;
		init.px8 = original.px8;
		init.py8 = original.py8;

		return init;
	}

	public void doChangeMullionsH(final boolean doOpenings, final boolean keepDims)
			throws Exception
	{

		myParentBO.mullionObjectsH = null;
		myParentBO.mullionObjectsH = myParentBO.mullionsH.toArray();
		if (myParentBO.mullionObjectsH.length > 0)
		{
			myParentBO.mullionsH.clear();

			this.getDimsForMullion(0, 0);
			posChanged = false;
			doVerifyCouplerPos = true;

			for (int vc = 0; vc < myParentBO.mullionObjectsH.length; vc++)
			{
				if (((Profiles) myParentBO.mullionObjectsH[vc]).cOrM == 2)
				{
					this.getProfileDims(((Profiles) myParentBO.mullionObjectsH[vc]));
				}
				if (((Profiles) myParentBO.mullionObjectsH[vc]).cOrM == 1)
				{
					this.getProfileDims(((Profiles) myParentBO.mullionObjectsH[vc]));
				}
				if (((Profiles) myParentBO.mullionObjectsH[vc]).cOrM == 6)
				{
					this.getProfileDims(((Profiles) myParentBO.mullionObjectsH[vc]));
				}

				((Profiles) myParentBO.mullionObjectsH[vc]).partDimA = (int) partDimA;
				((Profiles) myParentBO.mullionObjectsH[vc]).partDimB = (int) partDimB;
				((Profiles) myParentBO.mullionObjectsH[vc]).partDimBtoC = (int) partDimBtoC;

				((Profiles) myParentBO.mullionObjectsH[vc]).partDimC = (int) partDimC;
				((Profiles) myParentBO.mullionObjectsH[vc]).partDimM = (int) partDimM;
				((Profiles) myParentBO.mullionObjectsH[vc]).thickness = (int) partDimB;

				this.doMullionCalculations(vc, ((Profiles) myParentBO.mullionObjectsH[vc]).isNew,
						keepDims);
			} // Big FOR Loop
			myParentBO.mullionObjectsH = myParentBO.mullionsH.toArray();
			this.recalcVCCoords();
			this.reOrderHMNotches();

			if (doOpenings)
			{

				myParentBO.myParent.doOpenings();

			}

		}
	}

	private void cleanHMullions()
	{

		myParentBO.mullionObjectsH = null;
		myParentBO.mullionObjectsH = myParentBO.mullionsH.toArray();
		myParentBO.mullionsH.clear();

		for (int vc = 0; vc < myParentBO.mullionObjectsH.length; vc++)
		{
			if (!((Profiles) myParentBO.mullionObjectsH[vc]).remove)
			{
				myParentBO.mullionsH.add(myParentBO.mullionObjectsH[vc]);
			}
		}
		myParentBO.mullionObjectsH = null;
		myParentBO.mullionObjectsH = myParentBO.mullionsH.toArray();
	}

	public double intersectX1(final double x1, final double y1, final double x2, final double y2,
			final double bx1, final double by1, final double bx2, final double by2)
	{

		double x = 0;
		double u1 = 0;
		u1 = ((x2 - x1) * (by2 - by1) - (y2 - y1) * (bx2 - x1))
				/ ((y2 - y1) * (bx1 - bx2) - (x2 - x1) * (by1 - by2));
		if (Double.isNaN(u1))
		{
			u1 = 0;
		}
		x = bx2 + u1 * (bx1 - bx2);
		return x;// , (double)(py+z*ry));

	} // end intersection line-line

	public double intersectY1(final double x1, final double y1, final double x2, final double y2,
			final double bx1, final double by1, final double bx2, final double by2)
	{

		double y = 0;
		double u1 = 0;
		u1 = ((x2 - x1) * (by2 - by1) - (y2 - y1) * (bx2 - x1))
				/ ((y2 - y1) * (bx1 - bx2) - (x2 - x1) * (by1 - by2));

		if (Double.isNaN(u1))
		{
			u1 = 0;
		}
		// y = y3 + ua (y4 - y3)
		y = y1 + u1 * (y2 - y1);
		return y;
	} // end intersection line-line

	public double intersectX(final double x1, final double y1, final double x2, final double y2,
			final double bx1, final double by1, final double bx2, final double by2)
	{

		double x = 0;
		final double px = x1, py = y1, rx = x2 - px, ry = y2 - py;
		final double qx = bx1, qy = by1, sx = bx2 - qx, sy = by2 - qy;

		final double det = sx * ry - sy * rx;
		if (det == 0)
		{
			return x;
		}
		else
		{
			final double z = (sx * (qy - py) + sy * (px - qx)) / det;

			x = px + z * rx;// ,

		}
		return x;

	} // end intersection line-line

	public double intersectY(final double x1, final double y1, final double x2, final double y2,
			final double bx1, final double by1, final double bx2, final double by2)
	{

		double y = 0;
		final double px = x1, py = y1, rx = x2 - px, ry = y2 - py;
		final double qx = bx1, qy = by1, sx = bx2 - qx, sy = by2 - qy;

		final double det = sx * ry - sy * rx;
		if (det == 0)
		{
			return y;
		}
		else
		{
			final double z = (sx * (qy - py) + sy * (px - qx)) / det;
			// if (z == 0 || z == 1) {
			// return y; // intersection at end
			// point!
			// }
			y = py + z * ry;
		}
		return y;
	} // end intersection l

	public void addMullionVSplit(final Profiles mullionV, final Profiles mullionH, final int c)
	{

		int end = 0;
		int start = 0;
		double x1 = 0;
		double x2 = 0;
		double x1al = 0;
		double x2cl = 0;
		double y1 = 0;
		double y2 = 0;
		double y1al = 0;
		double y2cl = 0;
		double y1a3 = 0;
		double y2a3 = 0;
		double ycs = 0;
		double centerXs = 0;
		double centerYs = 0;
		// ///////////////////////
		x1 = this.intersectX(mullionH.x1, mullionH.y1, mullionH.x4, mullionH.y4, mullionV.x1,
				mullionV.y1, mullionV.x4, mullionV.y4);

		centerXs = this.intersectX(mullionH.x1, mullionH.y1, mullionH.x4, mullionH.y4,
				mullionV.centerXs, mullionV.centerYs, mullionV.centerXe, mullionV.centerYe);

		x2 = this.intersectX(mullionH.x1, mullionH.y1, mullionH.x4, mullionH.y4, mullionV.x2,
				mullionV.y2, mullionV.x3, mullionV.y3);

		// ///////////////////////

		x1al = this.intersectX(mullionH.x1, mullionH.y1, mullionH.x4, mullionH.y4, mullionV.x1al,
				mullionV.y1al, mullionV.x4al, mullionV.y4al);

		x2cl = this.intersectX(mullionH.x1, mullionH.y1, mullionH.x4, mullionH.y4, mullionV.x2cl,
				mullionV.y2cl, mullionV.x3cl, mullionV.y3cl);

		// ///////////////////////

		y1 = this.intersectY(mullionH.x1, mullionH.y1, mullionH.x4, mullionH.y4, mullionV.x1,
				mullionV.y1, mullionV.x4, mullionV.y4);
		y1a3 = this.intersectY(mullionH.x1al, mullionH.y1al, mullionH.x4al, mullionH.y4al,
				mullionV.x1, mullionV.y1, mullionV.x4, mullionV.y4);

		centerYs = this.intersectY(mullionH.x1, mullionH.y1, mullionH.x4, mullionH.y4,
				mullionV.centerXs, mullionV.centerYs, mullionV.centerXe, mullionV.centerYe);
		ycs = this.intersectY(mullionH.x1al, mullionH.y1al, mullionH.x4al, mullionH.y4al,
				mullionV.centerXs, mullionV.centerYs, mullionV.centerXe, mullionV.centerYe);

		y2 = this.intersectY(mullionH.x1, mullionH.y1, mullionH.x4, mullionH.y4, mullionV.x2,
				mullionV.y2, mullionV.x3, mullionV.y3);

		y2a3 = this.intersectY(mullionH.x1al, mullionH.y1al, mullionH.x4al, mullionH.y4al,
				mullionV.x2, mullionV.y2, mullionV.x3, mullionV.y3);

		y1al = this.intersectY(mullionH.x1, mullionH.y1, mullionH.x4, mullionH.y4, mullionV.x1al,
				mullionV.y1al, mullionV.x4al, mullionV.y4al);

		y2cl = this.intersectY(mullionH.x1, mullionH.y1, mullionH.x4, mullionH.y4, mullionV.x2cl,
				mullionV.y2cl, mullionV.x3cl, mullionV.y3cl);

		start = mullionH.rowCol + 1;
		end = mullionV.endPos;

		myParentBO.mullion = new Profiles(myParentBO, start, end, 1, x1, x2, y1, y2, x2 - x1,
				myFrame2);

		myParentBO.mullion.startIn = true;

		// Position Condition Calculation Missing.
		myParentBO.mullion.cOrM = mullionV.cOrM;

		myParentBO.mullion.rID = mullionV.rID; // record
		// ID

		myParentBO.mullion.parentid = mullionV.parentid;

		myParentBO.mullion.partShape = mullionV.partShape; // L,
		// T,
		// Z,
		// I,
		// H,

		myParentBO.mullion.ABClines = mullionV.ABClines; // if
		// reflects
		// lines
		// for ABC dims of
		// parts, by T

		myParentBO.mullion.orientation = mullionV.orientation; // Vertical
		// =
		// 1,
		// Horizontal
		// = 2

		myParentBO.mullion.partDimA = mullionV.partDimA;
		myParentBO.mullion.partDimB = mullionV.partDimB;
		myParentBO.mullion.partDimBtoC = mullionV.partDimBtoC;
		myParentBO.mullion.partDimC = mullionV.partDimC;
		myParentBO.mullion.partDimM = mullionV.partDimM;

		myParentBO.mullion.partDimAi = mullionV.partDimAi;
		myParentBO.mullion.partDimBi = mullionV.partDimBi;
		myParentBO.mullion.partDimBtoCi = mullionV.partDimBtoCi;
		myParentBO.mullion.partDimCi = mullionV.partDimCi;
		myParentBO.mullion.partDimMi = mullionV.partDimMi;

		myParentBO.mullion.myParent = mullionV.myParent;

		myParentBO.mullion.isValid = mullionV.isValid;

		myParentBO.mullion.endTypeRB = mullionV.endTypeRB; // 1=mitered,
		// 2=
		// || 3=[]
		myParentBO.mullion.endTypeLT = mullionV.endTypeLT;

		myParentBO.mullion.rowCol = mullionV.rowCol;
		myParentBO.mullion.startPos = start;
		myParentBO.mullion.endPos = end;
		myParentBO.mullion.x1 = x1;
		myParentBO.mullion.x2 = x2;
		myParentBO.mullion.x3 = mullionV.x3;
		myParentBO.mullion.x4 = mullionV.x4;

		myParentBO.mullion.x1al = myParentBO.mullion.x1a = x1al;
		myParentBO.mullion.x2cl = myParentBO.mullion.x2a = x2cl;
		myParentBO.mullion.centerXs = centerXs;
		myParentBO.mullion.centerXe = mullionV.centerXe;
		myParentBO.mullion.x3cl = myParentBO.mullion.x3a = mullionV.x3cl;
		myParentBO.mullion.x4al = myParentBO.mullion.x4a = mullionV.x4al;

		myParentBO.mullion.y1 = y1;
		myParentBO.mullion.y2 = y2;

		myParentBO.mullion.y1a = y1;
		myParentBO.mullion.y2a = y2;

		myParentBO.mullion.y1a3 = myParentBO.mullion.y1b = y1a3;
		myParentBO.mullion.y2a3 = myParentBO.mullion.y2b = y2a3;

		myParentBO.mullion.y1al = y1al;
		myParentBO.mullion.y2cl = y2cl;

		myParentBO.mullion.centerYs = centerYs;
		myParentBO.mullion.ycs = ycs;
		myParentBO.mullion.centerYe = mullionV.centerYe;

		myParentBO.mullion.y3 = mullionV.y3;
		myParentBO.mullion.y4 = mullionV.y4;

		myParentBO.mullion.y3a = mullionV.y3;
		myParentBO.mullion.y4a = mullionV.y4;

		myParentBO.mullion.y3cl = mullionV.y3cl;
		myParentBO.mullion.y4al = mullionV.y4al;

		myParentBO.mullion.offsetRB = mullionV.offsetRB;
		myParentBO.mullion.offsetTL = mullionV.offsetTL;
		myParentBO.mullion.partForm = mullionV.partForm;
		myParentBO.mullion.thickness = mullionV.thickness;
		myParentBO.mullion.exists = 2;

		myParentBO.mullion.length = myParentBO.mullion.centerYe - myParentBO.mullion.centerYs;

		this.modifyVMullion(c);

		myParentBO.mullion = recalcMullion(myParentBO.mullion);

		myParentBO.mullion = this.resetRecalcMullionBom(myParentBO.mullion);

		myParentBO.mullions.add(myParentBO.mullion);

	}

	private void modifyVMullion(final int c)
	{

		((Profiles) myParentBO.mullionObjectsV[c]).endPos = myParentBO.myProfilesH.rowCol;
		if (((Profiles) myParentBO.mullionObjectsV[c]).endTypeRB > 1)
		{

			((Profiles) myParentBO.mullionObjectsV[c]).x4 = this.intersectX(
					myParentBO.myProfilesH.x1, myParentBO.myProfilesH.y1,
					myParentBO.myProfilesH.x4, myParentBO.myProfilesH.y4,
					((Profiles) myParentBO.mullionObjectsV[c]).x1,
					((Profiles) myParentBO.mullionObjectsV[c]).y1,
					((Profiles) myParentBO.mullionObjectsV[c]).x4,
					((Profiles) myParentBO.mullionObjectsV[c]).y4);

			((Profiles) myParentBO.mullionObjectsV[c]).x4al = this.intersectX(
					myParentBO.myProfilesH.x1, myParentBO.myProfilesH.y1,
					myParentBO.myProfilesH.x4, myParentBO.myProfilesH.y4,
					((Profiles) myParentBO.mullionObjectsV[c]).x1al,
					((Profiles) myParentBO.mullionObjectsV[c]).y1al,
					((Profiles) myParentBO.mullionObjectsV[c]).x4al,
					((Profiles) myParentBO.mullionObjectsV[c]).y4al);

			((Profiles) myParentBO.mullionObjectsV[c]).centerXe = this.intersectX(
					myParentBO.myProfilesH.x1, myParentBO.myProfilesH.y1,
					myParentBO.myProfilesH.x4, myParentBO.myProfilesH.y4,
					((Profiles) myParentBO.mullionObjectsV[c]).centerXs,
					((Profiles) myParentBO.mullionObjectsV[c]).centerYs,
					((Profiles) myParentBO.mullionObjectsV[c]).centerXe,
					((Profiles) myParentBO.mullionObjectsV[c]).centerYe);

			((Profiles) myParentBO.mullionObjectsV[c]).x3 = this.intersectX(
					myParentBO.myProfilesH.x1, myParentBO.myProfilesH.y1,
					myParentBO.myProfilesH.x4, myParentBO.myProfilesH.y4,
					((Profiles) myParentBO.mullionObjectsV[c]).x2,
					((Profiles) myParentBO.mullionObjectsV[c]).y2,
					((Profiles) myParentBO.mullionObjectsV[c]).x3,
					((Profiles) myParentBO.mullionObjectsV[c]).y3);

			((Profiles) myParentBO.mullionObjectsV[c]).x3cl = this.intersectX(
					myParentBO.myProfilesH.x1, myParentBO.myProfilesH.y1,
					myParentBO.myProfilesH.x4, myParentBO.myProfilesH.y4,
					((Profiles) myParentBO.mullionObjectsV[c]).x2cl,
					((Profiles) myParentBO.mullionObjectsV[c]).y2cl,
					((Profiles) myParentBO.mullionObjectsV[c]).x3cl,
					((Profiles) myParentBO.mullionObjectsV[c]).y3cl);

			// /////////////////////

			((Profiles) myParentBO.mullionObjectsV[c]).y4 = this.intersectY(
					myParentBO.myProfilesH.x1, myParentBO.myProfilesH.y1,
					myParentBO.myProfilesH.x4, myParentBO.myProfilesH.y4,
					((Profiles) myParentBO.mullionObjectsV[c]).x1,
					((Profiles) myParentBO.mullionObjectsV[c]).y1,
					((Profiles) myParentBO.mullionObjectsV[c]).x4,
					((Profiles) myParentBO.mullionObjectsV[c]).y4);

			((Profiles) myParentBO.mullionObjectsV[c]).y4al = this.intersectY(
					myParentBO.myProfilesH.x1, myParentBO.myProfilesH.y1,
					myParentBO.myProfilesH.x4, myParentBO.myProfilesH.y4,
					((Profiles) myParentBO.mullionObjectsV[c]).x1al,
					((Profiles) myParentBO.mullionObjectsV[c]).y1al,
					((Profiles) myParentBO.mullionObjectsV[c]).x4al,
					((Profiles) myParentBO.mullionObjectsV[c]).y4al);

			((Profiles) myParentBO.mullionObjectsV[c]).y4a3 = ((Profiles) myParentBO.mullionObjectsV[c]).y4b = this
					.intersectY(myParentBO.myProfilesH.x2cl, myParentBO.myProfilesH.y2cl,
							myParentBO.myProfilesH.x3cl, myParentBO.myProfilesH.y3cl,
							((Profiles) myParentBO.mullionObjectsV[c]).x1al,
							((Profiles) myParentBO.mullionObjectsV[c]).y1al,
							((Profiles) myParentBO.mullionObjectsV[c]).x4al,
							((Profiles) myParentBO.mullionObjectsV[c]).y4al);

			((Profiles) myParentBO.mullionObjectsV[c]).y3a3 = ((Profiles) myParentBO.mullionObjectsV[c]).y3b = this
					.intersectY(myParentBO.myProfilesH.x2cl, myParentBO.myProfilesH.y2cl,
							myParentBO.myProfilesH.x3cl, myParentBO.myProfilesH.y3cl,
							((Profiles) myParentBO.mullionObjectsV[c]).x2cl,
							((Profiles) myParentBO.mullionObjectsV[c]).y2cl,
							((Profiles) myParentBO.mullionObjectsV[c]).x3cl,
							((Profiles) myParentBO.mullionObjectsV[c]).y3cl);

			((Profiles) myParentBO.mullionObjectsV[c]).centerYe = this.intersectY(
					myParentBO.myProfilesH.x1, myParentBO.myProfilesH.y1,
					myParentBO.myProfilesH.x4, myParentBO.myProfilesH.y4,
					((Profiles) myParentBO.mullionObjectsV[c]).centerXs,
					((Profiles) myParentBO.mullionObjectsV[c]).centerYs,
					((Profiles) myParentBO.mullionObjectsV[c]).centerXe,
					((Profiles) myParentBO.mullionObjectsV[c]).centerYe);

			((Profiles) myParentBO.mullionObjectsV[c]).yce = this.intersectY(
					myParentBO.myProfilesH.x2cl, myParentBO.myProfilesH.y2cl,
					myParentBO.myProfilesH.x3cl, myParentBO.myProfilesH.y3cl,
					((Profiles) myParentBO.mullionObjectsV[c]).centerXs,
					((Profiles) myParentBO.mullionObjectsV[c]).centerYs,
					((Profiles) myParentBO.mullionObjectsV[c]).centerXe,
					((Profiles) myParentBO.mullionObjectsV[c]).centerYe);

			((Profiles) myParentBO.mullionObjectsV[c]).y3 = this.intersectY(
					myParentBO.myProfilesH.x1, myParentBO.myProfilesH.y1,
					myParentBO.myProfilesH.x4, myParentBO.myProfilesH.y4,
					((Profiles) myParentBO.mullionObjectsV[c]).x2,
					((Profiles) myParentBO.mullionObjectsV[c]).y2,
					((Profiles) myParentBO.mullionObjectsV[c]).x3,
					((Profiles) myParentBO.mullionObjectsV[c]).y3);

			((Profiles) myParentBO.mullionObjectsV[c]).y3cl = this.intersectY(
					myParentBO.myProfilesH.x1, myParentBO.myProfilesH.y1,
					myParentBO.myProfilesH.x4, myParentBO.myProfilesH.y4,
					((Profiles) myParentBO.mullionObjectsV[c]).x2cl,
					((Profiles) myParentBO.mullionObjectsV[c]).y2cl,
					((Profiles) myParentBO.mullionObjectsV[c]).x3cl,
					((Profiles) myParentBO.mullionObjectsV[c]).y3cl);

			// /////////////////////////
			// ////////////////////////
			// ////////////////////////

		}
		else if (((Profiles) myParentBO.mullionObjectsV[c]).endTypeRB == 1)
		{

			((Profiles) myParentBO.mullionObjectsV[c]).x4 = this.intersectX(
					myParentBO.myProfilesH.x1, myParentBO.myProfilesH.y1,
					myParentBO.myProfilesH.x4, myParentBO.myProfilesH.y4,
					((Profiles) myParentBO.mullionObjectsV[c]).x1,
					((Profiles) myParentBO.mullionObjectsV[c]).y1,
					((Profiles) myParentBO.mullionObjectsV[c]).x4,
					((Profiles) myParentBO.mullionObjectsV[c]).y4);

			((Profiles) myParentBO.mullionObjectsV[c]).x4al = this.intersectX(
					myParentBO.myProfilesH.x1, myParentBO.myProfilesH.y1,
					myParentBO.myProfilesH.x4, myParentBO.myProfilesH.y4,
					((Profiles) myParentBO.mullionObjectsV[c]).x1al,
					((Profiles) myParentBO.mullionObjectsV[c]).y1al,
					((Profiles) myParentBO.mullionObjectsV[c]).x4al,
					((Profiles) myParentBO.mullionObjectsV[c]).y4al);

			((Profiles) myParentBO.mullionObjectsV[c]).centerXe = this.intersectX(
					myParentBO.myProfilesH.x1, myParentBO.myProfilesH.y1,
					myParentBO.myProfilesH.x4, myParentBO.myProfilesH.y4,
					((Profiles) myParentBO.mullionObjectsV[c]).centerXs,
					((Profiles) myParentBO.mullionObjectsV[c]).centerYs,
					((Profiles) myParentBO.mullionObjectsV[c]).centerXe,
					((Profiles) myParentBO.mullionObjectsV[c]).centerYe);

			((Profiles) myParentBO.mullionObjectsV[c]).x3 = this.intersectX(
					myParentBO.myProfilesH.x1, myParentBO.myProfilesH.y1,
					myParentBO.myProfilesH.x4, myParentBO.myProfilesH.y4,
					((Profiles) myParentBO.mullionObjectsV[c]).x2,
					((Profiles) myParentBO.mullionObjectsV[c]).y2,
					((Profiles) myParentBO.mullionObjectsV[c]).x3,
					((Profiles) myParentBO.mullionObjectsV[c]).y3);

			((Profiles) myParentBO.mullionObjectsV[c]).x3cl = this.intersectX(
					myParentBO.myProfilesH.x1, myParentBO.myProfilesH.y1,
					myParentBO.myProfilesH.x4, myParentBO.myProfilesH.y4,
					((Profiles) myParentBO.mullionObjectsV[c]).x2cl,
					((Profiles) myParentBO.mullionObjectsV[c]).y2cl,
					((Profiles) myParentBO.mullionObjectsV[c]).x3cl,
					((Profiles) myParentBO.mullionObjectsV[c]).y3cl);

			// /////////////////////

			((Profiles) myParentBO.mullionObjectsV[c]).y4 = this.intersectY(
					myParentBO.myProfilesH.x1, myParentBO.myProfilesH.y1,
					myParentBO.myProfilesH.x4, myParentBO.myProfilesH.y4,
					((Profiles) myParentBO.mullionObjectsV[c]).x1,
					((Profiles) myParentBO.mullionObjectsV[c]).y1,
					((Profiles) myParentBO.mullionObjectsV[c]).x4,
					((Profiles) myParentBO.mullionObjectsV[c]).y4);

			((Profiles) myParentBO.mullionObjectsV[c]).y4al = this.intersectY(
					myParentBO.myProfilesH.x1, myParentBO.myProfilesH.y1,
					myParentBO.myProfilesH.x4, myParentBO.myProfilesH.y4,
					((Profiles) myParentBO.mullionObjectsV[c]).x1al,
					((Profiles) myParentBO.mullionObjectsV[c]).y1al,
					((Profiles) myParentBO.mullionObjectsV[c]).x4al,
					((Profiles) myParentBO.mullionObjectsV[c]).y4al);

			((Profiles) myParentBO.mullionObjectsV[c]).centerYe = this.intersectY(
					myParentBO.myProfilesH.x1, myParentBO.myProfilesH.y1,
					myParentBO.myProfilesH.x4, myParentBO.myProfilesH.y4,
					((Profiles) myParentBO.mullionObjectsV[c]).centerXs,
					((Profiles) myParentBO.mullionObjectsV[c]).centerYs,
					((Profiles) myParentBO.mullionObjectsV[c]).centerXe,
					((Profiles) myParentBO.mullionObjectsV[c]).centerYe);

			((Profiles) myParentBO.mullionObjectsV[c]).y3 = this.intersectY(
					myParentBO.myProfilesH.x1, myParentBO.myProfilesH.y1,
					myParentBO.myProfilesH.x4, myParentBO.myProfilesH.y4,
					((Profiles) myParentBO.mullionObjectsV[c]).x2,
					((Profiles) myParentBO.mullionObjectsV[c]).y2,
					((Profiles) myParentBO.mullionObjectsV[c]).x3,
					((Profiles) myParentBO.mullionObjectsV[c]).y3);

			((Profiles) myParentBO.mullionObjectsV[c]).y3cl = this.intersectY(
					myParentBO.myProfilesH.x1, myParentBO.myProfilesH.y1,
					myParentBO.myProfilesH.x4, myParentBO.myProfilesH.y4,
					((Profiles) myParentBO.mullionObjectsV[c]).x2cl,
					((Profiles) myParentBO.mullionObjectsV[c]).y2cl,
					((Profiles) myParentBO.mullionObjectsV[c]).x3cl,
					((Profiles) myParentBO.mullionObjectsV[c]).y3cl);

		}

		((Profiles) myParentBO.mullionObjectsV[c]).length = ((Profiles) myParentBO.mullionObjectsV[c]).centerYe
				- ((Profiles) myParentBO.mullionObjectsV[c]).centerYs;

		((Profiles) myParentBO.mullionObjectsV[c]).notches.clear();

		myParentBO.mullionObjectsV[c] = recalcMullion(((Profiles) myParentBO.mullionObjectsV[c]));

		((Profiles) myParentBO.mullionObjectsV[c]).endIn = true;

		myParentBO.mullions.add(myParentBO.mullionObjectsV[c]);
	}

	public Profiles recalcMullion(Profiles myMullion)
	{

		final AddMullionV addMullion = new AddMullionV(myParentBO, myFrame2.jobItem, myFrame2, 2);

		addMullion.vcEndY = myMullion.centerYe;
		addMullion.vcEnd = myMullion.endPos;
		addMullion.isNew = false;
		addMullion.newStartingYCenter = myMullion.centerYs;

		addMullion.newStartingXCenter = myMullion.centerXs;

		addMullion.verifyLimitLR(myMullion);

		addMullion.calcMullion = new CalculateMullionV(addMullion);

		addMullion.calcMullion.calculateCoord(myMullion);

		// Reset and Recalc BOM

		myMullion = this.resetRecalcMullionBom(myMullion);

		return myMullion;
	}

	public int getLastInputOrder()
	{

		int order = 0;
		final Object[] hs = myParentBO.mullionObjectsH;
		final Object[] vs = myParentBO.mullionObjectsV;
		for (final Object h : hs)
		{
			if (((Profiles) h).order > order)
			{
				order = ((Profiles) h).order;
			}
		}
		for (final Object v : vs)
		{
			if (((Profiles) v).order > order)
			{
				order = ((Profiles) v).order;
			}
		}

		return order + 1;
	}

	private PartsNotching addNotching(

	final int level, //

			final boolean top1,//
			final boolean top2,//
			final boolean top3,//
			final boolean left,//
			final boolean right,//
			final boolean bot1,//
			final boolean bot2,//
			final boolean bot3,//

			final int orientation, // 1 V 2 H
			final int rowCol, //
			final int pos, // // 1 =top, 2 bot, 3 L 4 R
			final int notchType, // 2 = Straight 1 = V

			final double x1, //
			final double y1, //
			final double x2,//
			final double y2, //
			final double x3, final double y3, //
			final double centerX, //
			final double centerY,//
			final double x5, //
			final double y5,//
			final double x6, //
			final double y6,//
			final double x7,//
			final double y7)
	{

		PartsNotching myNotch = null;

		myNotch = new PartsNotching(level, //
				top1,//
				top2,//
				top3,//
				left,//
				right,//
				bot1,//
				bot2,//
				bot3,//
				orientation, // 1 V 2 H
				rowCol,//
				pos, // // 1 =top, 2 bot, 3 Left 4 Right
				notchType, // 1 = V 3 = Straight
				x1, //
				y1, //
				x2,//
				y2, //
				x3, y3, //
				centerX, //
				centerY,//
				x5, //
				y5,//
				x6, //
				y6,//
				x7,//
				y7//
		);

		return myNotch;
	}

	private void reOrderMullionsH(final int y)
	{

		for (int vc = 0; vc < myParentBO.mullionObjectsH.length; vc++)
		{

			if (((Profiles) myParentBO.mullionObjectsH[vc]).rowCol >= newHCRow
					&& Math.min(
							//
							(int) ((Profiles) myParentBO.mullionObjectsH[vc]).y2cl,
							(int) ((Profiles) myParentBO.mullionObjectsH[vc]).y3cl) > y)
			{

				((Profiles) myParentBO.mullionObjectsH[vc]).rowCol = ((Profiles) myParentBO.mullionObjectsH[vc]).rowCol + 1;

			}

		}

	}

	void reOrderVMullions()
	{

		for (int c = 0; c < myParentBO.mullionObjectsV.length; c++)
		{

			if (((Profiles) myParentBO.mullionObjectsV[c]).endPos >= newHCRow
					&& ((Profiles) myParentBO.mullionObjectsV[c]).endPos < myParentBO.yRows)
			{
				((Profiles) myParentBO.mullionObjectsV[c]).endPos = ((Profiles) myParentBO.mullionObjectsV[c]).endPos + 1;

			}

			if (((Profiles) myParentBO.mullionObjectsV[c]).startPos > newHCRow
					&& ((Profiles) myParentBO.mullionObjectsV[c]).startPos != 1)
			{

				((Profiles) myParentBO.mullionObjectsV[c]).startPos = ((Profiles) myParentBO.mullionObjectsV[c]).startPos + 1;
			}
			else if (((Profiles) myParentBO.mullionObjectsV[c]).startPos <= newHCRow
					&& ((Profiles) myParentBO.mullionObjectsV[c]).startPos != 1)
			{

			}

		}
	}

	public void doMullionCalculations(final int vc, final boolean isNew, final boolean keepDims)
	{

		// this.getProfileDims((Profiles) myParentBO.mullionObjectsH[vc]);

		if (cOrM <= 2)
		{
			this.getPointsXY(((Profiles) myParentBO.mullionObjectsH[vc]), true, keepDims);
		}
		else if (cOrM <= 6 && isNew)
		{

			double centerP = partDimB - partDimBtoC;

			((Profiles) myParentBO.mullionObjectsH[vc]).centerYs = ((Profiles) myParentBO.mullionObjectsH[vc]).centerYe = newStartingYCenter
					- partDimB/2 + centerP;

			((Profiles) myParentBO.mullionObjectsH[vc]).y2 = ((Profiles) myParentBO.mullionObjectsH[vc]).y3 = ((Profiles) myParentBO.mullionObjectsH[vc]).centerYs
					- partDimBtoC;

			((Profiles) myParentBO.mullionObjectsH[vc]).y2cl = ((Profiles) myParentBO.mullionObjectsH[vc]).y3cl = ((Profiles) myParentBO.mullionObjectsH[vc]).y2
					- partDimC;

			((Profiles) myParentBO.mullionObjectsH[vc]).y1 = ((Profiles) myParentBO.mullionObjectsH[vc]).y4 = ((Profiles) myParentBO.mullionObjectsH[vc]).centerYs
					+ partDimB
					- partDimBtoC;

			((Profiles) myParentBO.mullionObjectsH[vc]).y1al = ((Profiles) myParentBO.mullionObjectsH[vc]).y4al = ((Profiles) myParentBO.mullionObjectsH[vc]).y1
					+ partDimA;

		}
		else if (cOrM == 7 && isNew)
		{

			double centerP = ((Profiles) myParentBO.mullionObjectsH[vc]).partDimB
					- partDimBtoC;

//			((Profiles) myParentBO.mullionObjectsH[vc]).centerYs = ((Profiles) myParentBO.mullionObjectsH[vc]).centerYe = newStartingYCenter
//					- ((Profiles) myParentBO.mullionObjectsH[vc]).partDimB/2 + centerP;
//			
			((Profiles) myParentBO.mullionObjectsH[vc]).centerYs = ((Profiles) myParentBO.mullionObjectsH[vc]).centerYe = newStartingYCenter
					- partDimB + partDimBtoC;

			((Profiles) myParentBO.mullionObjectsH[vc]).y2 = ((Profiles) myParentBO.mullionObjectsH[vc]).y3 = ((Profiles) myParentBO.mullionObjectsH[vc]).centerYs
					-partDimB / 2;

			((Profiles) myParentBO.mullionObjectsH[vc]).y2cl = ((Profiles) myParentBO.mullionObjectsH[vc]).y3cl = ((Profiles) myParentBO.mullionObjectsH[vc]).y2
					- ((Profiles) myParentBO.mullionObjectsH[vc]).partDimC;

			((Profiles) myParentBO.mullionObjectsH[vc]).y1 = ((Profiles) myParentBO.mullionObjectsH[vc]).y4 = ((Profiles) myParentBO.mullionObjectsH[vc]).centerYs
					+ ((Profiles) myParentBO.mullionObjectsH[vc]).partDimB / 2;

			((Profiles) myParentBO.mullionObjectsH[vc]).y1al = ((Profiles) myParentBO.mullionObjectsH[vc]).y4al = ((Profiles) myParentBO.mullionObjectsH[vc]).y1
					+ partDimA;

		}

		if (((Profiles) myParentBO.mullionObjectsH[vc]).isValid)
		{
			this.verifyLimitLR(((Profiles) myParentBO.mullionObjectsH[vc]));

			calcMullion.calculateCoord(((Profiles) myParentBO.mullionObjectsH[vc]));

			((Profiles) myParentBO.mullionObjectsH[vc]).isNew = false;

		}

		if (!((Profiles) myParentBO.mullionObjectsH[vc]).isValid)
		{
			((Profiles) myParentBO.mullionObjectsH[vc]).length = 0;

			myParentBO.mullionsH.add(myParentBO.mullionObjectsH[vc]);

			JOptionPane.showMessageDialog(null, "Mullion is outside of  permitted positions!\n"
					+ "Mullion will be set to Invalid status.", "Warning!",
					JOptionPane.WARNING_MESSAGE);
			// this.myParent.myParent.myJobItem.myCanvas.setSelectedView();

		}
		else
		{
			if (((Profiles) myParentBO.mullionObjectsH[vc]).rowCol == newHCRow
					&& ((Profiles) myParentBO.mullionObjectsH[vc]).startPos == newHCCol
					&& ((Profiles) myParentBO.mullionObjectsH[vc]).endPos == hcEnd && newMullion)
			{
				((Profiles) myParentBO.mullionObjectsH[vc]).exists = alreadyExist;

				((Profiles) myParentBO.mullionObjectsH[vc]).potentialS = false;
			}
			((Profiles) myParentBO.mullionObjectsH[vc]).potentialS = false;
			((Profiles) myParentBO.mullionObjectsH[vc]).profileSelected = 0;

			myParentBO.mullionObjectsH[vc] = resetRecalcMullionBom((Profiles) myParentBO.mullionObjectsH[vc]);

			myParentBO.mullionsH.add(myParentBO.mullionObjectsH[vc]);

			if (myFrame2.jobItem.myCanvas != null)
			{
				myFrame2.jobItem.myCanvas.mySelectedFrame = myParentBO.myParent;
			}
			if (newMullion)
			{
				if (((Profiles) myParentBO.mullionObjectsH[vc]).rowCol == myParentBO.mullionH.rowCol
						&& ((Profiles) myParentBO.mullionObjectsH[vc]).startPos == myParentBO.mullionH.startPos
						&& ((Profiles) myParentBO.mullionObjectsH[vc]).endPos == myParentBO.mullionH.endPos)
				{
					myParentBO.mullionH = (Profiles) myParentBO.mullionObjectsH[vc];
				}
			}
		}

	}

	public Profiles getPointsXY(Profiles myMullion, final boolean isNew, final boolean keepDims)
	{

		// myMullion = this.getProfileDims(myMullion);

		this.getSumPrevMullions(myMullion.rowCol, myMullion.endPos);

		iNo = myMullion.rowCol;
		myThick = thickness;

		isValid = myMullion.isValid;

		double posY = 0;

		posY = myStartingY + newRowH * iNo + sumOfPrevMullions;

		if (keepDims)
		{
			posY = myMullion.centerYs;
			doVerifyCouplerPos = false;
		}

		if (cOrM == 1)
		{
			if (posChanged)
			{
				if (myMullion.rowCol >= posChangedAt)
				{
					this.getDimsForMullionAfterChange();

					posChanged = false;
					doVerifyCouplerPos = false;
				}

			}

			if (myMullion.rowCol > posChangedAt && posChangedAt > 0)
			{
				this.getSumPrevMullionsAfterChange(myMullion);
				posY = myStartingY + newRowH * (iNo - posChangedAt) + sumOfPrevMullions;

			}

			if (myMullion.rowCol == posChangedAt && posChangedAt > 0)
			{
				this.getSumPrevMullionsAfterChange(myMullion);
				posY = myStartingY - myThick + newRowH * (iNo - posChangedAt) + sumOfPrevMullions;

			}

			if (cOrM == 1 && doVerifyCouplerPos && isNew
					&& posY != myMullion.centerYs - partDimBtoC - myMullion.offsetTL)
			{
				posY = this.getPosYverified(posY, myMullion);
			}
			else if (cOrM == 1 && doVerifyCouplerPos)
			{
				posY = this.getPosYverified(posY, myMullion);
			}

		}

		if (myMullion.offsetRB != 0 || myMullion.offsetTL != 0 && myMullion.partForm != 3)
		{
			myMullion.endTypeLT = myMullion.endTypeRB = 3;
		}

		double centerP = partDimB - partDimBtoC;

		if (myMullion.offsetTL != 0)
		{

			if (isNew)
			{
				newStartingYCenter = posY + centerP + myMullion.offsetTL;
			}

			newStartingYRTc = newStartingYCenter - partDimBtoC - partDimC;

			newStartingYRT = newStartingYCenter - partDimBtoC;

			newStartingYLB = newStartingYCenter - partDimBtoC + partDimB;

			newStartingYLBa = newStartingYLB + partDimA;

		}
		else if (myMullion.offsetTL == 0)
		{
			if (isNew)
			{
				newStartingYCenter = posY + centerP + myMullion.offsetTL;

			}
			newStartingYRTc = newStartingYCenter - partDimBtoC - partDimC;

			newStartingYRT = newStartingYCenter - partDimBtoC;

			newStartingYLB = newStartingYCenter - partDimBtoC + partDimB;

			newStartingYLBa = newStartingYCenter - partDimBtoC + partDimB + partDimA;
		}

		myMullion.y1 = newStartingYLB;

		myMullion.y2 = newStartingYRT;

		myMullion.y1al = newStartingYLBa;

		myMullion.y2cl = newStartingYRTc;

		myMullion.centerYs = newStartingYCenter;

		if (myMullion.offsetRB != 0)
		{
			if (isNew)
			{
				myMullion.centerYe = posY + centerP + myMullion.offsetRB;
			}
			myMullion.y3 = myMullion.centerYe - partDimBtoC;
			myMullion.y3cl = myMullion.centerYe - partDimBtoC - partDimC;

			myMullion.y4 = myMullion.centerYe - partDimBtoC + partDimB;

			myMullion.y4al = myMullion.y4 + partDimA;

		}
		else if (myMullion.offsetRB == 0)
		{
			if (isNew)
			{
				myMullion.centerYe = posY + centerP + myMullion.offsetRB;
			}
			myMullion.y3 = myMullion.centerYe - partDimBtoC;

			myMullion.y3cl = myMullion.centerYe - partDimBtoC - partDimC;

			myMullion.y4 = myMullion.centerYe - partDimBtoC + partDimB;

			myMullion.y4al = myMullion.centerYe - partDimBtoC + partDimB + partDimA;
		}

		if (myMullion.rowCol == newHCRow && myMullion.startPos == newHCCol
				&& myMullion.endPos == hcEnd && newMullion)
		{

			newStartingXRT = newStartingXRTc = myMullion.x2 = myMullion.x2a = myMullion.x2cl = hcStartX;
			newStartingXLB = newStartingXLBa = myMullion.x1 = myMullion.x1a = myMullion.x1al = hcStartX;

			newStartingXCenter = myMullion.centerXs = hcStartX;
		}
		else
		{
			newStartingXRT = myMullion.x2;
			newStartingXLB = myMullion.x1;
			newStartingXRTc = myMullion.x2cl;
			newStartingXLBa = myMullion.x1al;
			newStartingXCenter = myMullion.centerXs;

		}

		return myMullion;

	}

	public double getPosYverified(double posY, final Profiles myMullion)
	{

		// this.getProfileDims(myMullion);

		if (posY == myParentBO.myParent.bOpeningObject.py1
				&& (posCondition == 1 || posCondition == 3))
		{
			posY = myParentBO.myParent.bOpeningObject.py1
					+ new BigDecimal(myParentBO.myParent.bOpeningObject.minLeg).multiply(
							myFrame2.scale).doubleValue();
			posChanged = true;

		}

		if (posY < myParentBO.myParent.bOpeningObject.py1
				+ myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
				&& posY + myThick > myParentBO.myParent.bOpeningObject.py1
				&& (posCondition == 1 || posCondition == 3))
		{
			posY = myParentBO.myParent.bOpeningObject.py1
					+ myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue();
			posChanged = true;

		}
		if (myParentBO.myParent.bOpeningObject.noSidesTop == 1
				&& posY < myParentBO.myParent.bOpeningObject.py2
						+ myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
				&& posY + myThick > myParentBO.myParent.bOpeningObject.py2
				&& (posCondition == 1 || posCondition == 2))
		{
			posY = myParentBO.myParent.bOpeningObject.py2
					+ myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue();
			posChanged = true;

		}

		if (myParentBO.myParent.bOpeningObject.noSidesTop == 2
				&& posY < myParentBO.myParent.bOpeningObject.py3
						+ myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
				&& posY + myThick > myParentBO.myParent.bOpeningObject.py3
				&& (posCondition == 1 || posCondition == 2))
		{
			posY = myParentBO.myParent.bOpeningObject.py3
					+ myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue();
			posChanged = true;
		}

		if (myParentBO.myParent.bOpeningObject.noSidesTop == 3
				&& posY < myParentBO.myParent.bOpeningObject.py4
						+ myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
				&& posY + myThick > myParentBO.myParent.bOpeningObject.py4
				&& (posCondition == 1 || posCondition == 3))
		{
			posY = myParentBO.myParent.bOpeningObject.py4
					+ myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue();
			posChanged = true;
		}

		if (myParentBO.myParent.bOpeningObject.noSidesTop == 1
				&& myParentBO.myParent.bOpeningObject.noSidesBot == 1
				&& posY > myParentBO.myParent.bOpeningObject.py3
						- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
				&& posY + myThick < myParentBO.myParent.bOpeningObject.py3
				&& (posCondition == 1 || posCondition == 2))
		{
			posY = myParentBO.myParent.bOpeningObject.py3
					- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
					- myThick;
			posChanged = true;
		}
		if (myParentBO.myParent.bOpeningObject.noSidesTop == 1
				&& myParentBO.myParent.bOpeningObject.noSidesBot == 1
				&& posY > myParentBO.myParent.bOpeningObject.py4
						- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
				&& posY + myThick < myParentBO.myParent.bOpeningObject.py4
				&& (posCondition == 1 || posCondition == 3))
		{
			posY = myParentBO.myParent.bOpeningObject.py4
					- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
					- myThick;
			posChanged = true;
		}

		if (myParentBO.myParent.bOpeningObject.noSidesTop == 1
				&& myParentBO.myParent.bOpeningObject.noSidesBot == 2
				&& posY > myParentBO.myParent.bOpeningObject.py3
						- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
				&& posY + myThick < myParentBO.myParent.bOpeningObject.py3
				&& (posCondition == 1 || posCondition == 2))
		{
			posY = myParentBO.myParent.bOpeningObject.py3
					- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
					- myThick;
			posChanged = true;
		}
		if (myParentBO.myParent.bOpeningObject.noSidesTop == 1
				&& myParentBO.myParent.bOpeningObject.noSidesBot == 2
				&& posY > myParentBO.myParent.bOpeningObject.py5
						- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
				&& posY + myThick < myParentBO.myParent.bOpeningObject.py5
				&& (posCondition == 1 || posCondition == 3))
		{
			posY = myParentBO.myParent.bOpeningObject.py5
					- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
					- myThick;
			posChanged = true;
		}

		if (myParentBO.myParent.bOpeningObject.noSidesTop == 1
				&& myParentBO.myParent.bOpeningObject.noSidesBot == 3
				&& posY > myParentBO.myParent.bOpeningObject.py3
						- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
				&& posY + myThick < myParentBO.myParent.bOpeningObject.py3
				&& (posCondition == 1 || posCondition == 2))
		{
			posY = myParentBO.myParent.bOpeningObject.py3
					- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
					- myThick;
			posChanged = true;
		}
		if (myParentBO.myParent.bOpeningObject.noSidesTop == 1
				&& myParentBO.myParent.bOpeningObject.noSidesBot == 3
				&& posY > myParentBO.myParent.bOpeningObject.py6
						- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
				&& posY + myThick < myParentBO.myParent.bOpeningObject.py6
				&& (posCondition == 1 || posCondition == 3))
		{
			posY = myParentBO.myParent.bOpeningObject.py6
					- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
					- myThick;
			posChanged = true;
		}

		if (myParentBO.myParent.bOpeningObject.noSidesTop == 2
				&& myParentBO.myParent.bOpeningObject.noSidesBot == 2
				&& posY > myParentBO.myParent.bOpeningObject.py4
						- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
				&& posY + myThick < myParentBO.myParent.bOpeningObject.py4
				&& (posCondition == 1 || posCondition == 2))
		{
			posY = myParentBO.myParent.bOpeningObject.py4
					- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
					- myThick;
			posChanged = true;
		}
		if (myParentBO.myParent.bOpeningObject.noSidesTop == 2
				&& myParentBO.myParent.bOpeningObject.noSidesBot == 2
				&& posY > myParentBO.myParent.bOpeningObject.py6
						- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
				&& posY + myThick < myParentBO.myParent.bOpeningObject.py6
				&& (posCondition == 1 || posCondition == 3))
		{
			posY = myParentBO.myParent.bOpeningObject.py6
					- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
					- myThick;
			posChanged = true;

		}

		if (myParentBO.myParent.bOpeningObject.noSidesTop == 2
				&& myParentBO.myParent.bOpeningObject.noSidesBot == 3
				&& posY > myParentBO.myParent.bOpeningObject.py4
						- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
				&& posY + myThick < myParentBO.myParent.bOpeningObject.py4
				&& (posCondition == 1 || posCondition == 2))
		{
			posY = myParentBO.myParent.bOpeningObject.py4
					- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
					- myThick;
			posChanged = true;
		}
		if (myParentBO.myParent.bOpeningObject.noSidesTop == 2
				&& myParentBO.myParent.bOpeningObject.noSidesBot == 3
				&& posY > myParentBO.myParent.bOpeningObject.py7
						- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
				&& posY + myThick < myParentBO.myParent.bOpeningObject.py7
				&& (posCondition == 1 || posCondition == 3))
		{
			posY = myParentBO.myParent.bOpeningObject.py7
					- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
					- myThick;
			posChanged = true;
		}

		if (myParentBO.myParent.bOpeningObject.noSidesTop == 3
				&& myParentBO.myParent.bOpeningObject.noSidesBot == 2
				&& posY > myParentBO.myParent.bOpeningObject.py5
						- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
				&& posY + myThick < myParentBO.myParent.bOpeningObject.py5
				&& (posCondition == 1 || posCondition == 2))
		{
			posY = myParentBO.myParent.bOpeningObject.py5
					- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
					- myThick;
			posChanged = true;
		}
		if (myParentBO.myParent.bOpeningObject.noSidesTop == 3
				&& myParentBO.myParent.bOpeningObject.noSidesBot == 2
				&& posY > myParentBO.myParent.bOpeningObject.py7
						- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
				&& posY + myThick < myParentBO.myParent.bOpeningObject.py7
				&& (posCondition == 1 || posCondition == 3))
		{
			posY = myParentBO.myParent.bOpeningObject.py7
					- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
					- myThick;
			posChanged = true;
		}
		if (myParentBO.myParent.bOpeningObject.noSidesTop == 3
				&& myParentBO.myParent.bOpeningObject.noSidesBot == 3
				&& posY > myParentBO.myParent.bOpeningObject.py5
						- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
				&& posY + myThick < myParentBO.myParent.bOpeningObject.py5
				&& (posCondition == 1 || posCondition == 2))
		{
			posY = myParentBO.myParent.bOpeningObject.py5
					- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
					- myThick;
			posChanged = true;
		}
		if (myParentBO.myParent.bOpeningObject.noSidesTop == 3
				&& myParentBO.myParent.bOpeningObject.noSidesBot == 3
				&& posY > myParentBO.myParent.bOpeningObject.py8
						- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
				&& posY + myThick < myParentBO.myParent.bOpeningObject.py8
				&& (posCondition == 1 || posCondition == 3))
		{
			posY = myParentBO.myParent.bOpeningObject.py8
					- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
					- myThick;
			posChanged = true;
		}

		if (posChanged)
		{
			newPosYAfterChange = posY + myThick;
			posChangedAt = myMullion.rowCol;
		}
		return posY;
	}

	public double getPosYverifiedOpening() throws Exception
	{

		final Object[] openings = myParentBO.myParent.openings.toArray();
		boolean change = false;
		final Collection HM = new ArrayList();
		double posY = 0;
		for (final Object H : myParentBO.mullionObjectsH)
		{
			HM.add(H);
		}
		final Object[] hM = HM.toArray();

		for (final Object O : openings)
		{

			if (((OpeningObject) O).startRow == 1
					&& ((OpeningObject) O).botIn
					&& ((OpeningObject) O).noSidesLeft == 1
					&& ((OpeningObject) O).myMullionBot.y2 - ((OpeningObject) O).leftPart.endYC < ((OpeningObject) O).minLeg
							* myFrame2.scale.doubleValue())
			{
				posY = ((OpeningObject) O).leftPart.endYC
						+ myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue();
				change = true;

				myParentBO.mullionsH.clear();

				for (final Object MH : hM)
				{
					if (((Profiles) MH).equals(((OpeningObject) O).myMullionBot))
					{
						((Profiles) MH).y2 = posY;
						((Profiles) MH).y1 = posY + ((Profiles) MH).thickness;
						((Profiles) MH).centerYs = posY + ((Profiles) MH).thickness / 2;
						((Profiles) MH).y3 = posY;
						((Profiles) MH).y4 = posY + ((Profiles) MH).thickness;
						((Profiles) MH).y2cl = posY;
						((Profiles) MH).y1al = posY + ((Profiles) MH).thickness;

						((Profiles) MH).y3cl = posY;
						((Profiles) MH).y4al = posY + ((Profiles) MH).thickness;
						((Profiles) MH).centerYe = posY + ((Profiles) MH).thickness / 2;
					}
					myParentBO.mullionsH.add(MH);

				} // Big FOR

			}
			if (((OpeningObject) O).startRow == 1
					&& ((OpeningObject) O).botIn
					&& ((OpeningObject) O).noSidesRight == 1
					&& ((OpeningObject) O).myMullionBot.y3 - ((OpeningObject) O).rightPart.startYC < ((OpeningObject) O).minLeg
							* myFrame2.scale.doubleValue())
			{
				posY = ((OpeningObject) O).rightPart.startYC
						+ myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue();
				change = true;

				myParentBO.mullionsH.clear();

				for (final Object MH : hM)
				{
					if (((Profiles) MH).equals(((OpeningObject) O).myMullionBot))
					{
						((Profiles) MH).y2 = posY;
						((Profiles) MH).y1 = posY + ((Profiles) MH).thickness;
						((Profiles) MH).centerYs = posY + ((Profiles) MH).thickness / 2;
						((Profiles) MH).y3 = posY;
						((Profiles) MH).y4 = posY + ((Profiles) MH).thickness;
						((Profiles) MH).centerYe = posY + ((Profiles) MH).thickness / 2;
						((Profiles) MH).y2cl = posY;
						((Profiles) MH).y1al = posY + ((Profiles) MH).thickness;

						((Profiles) MH).y3cl = posY;
						((Profiles) MH).y4al = posY + ((Profiles) MH).thickness;
					}
					myParentBO.mullionsH.add(MH);

				} // Big FOR

			}
			if (((OpeningObject) O).endRow == myParentBO.yRows
					&& ((OpeningObject) O).topIn
					&&

					((OpeningObject) O).noSidesLeft != 0
					&& ((OpeningObject) O).leftPart.startYC - ((OpeningObject) O).myMullionTop.y1 < ((OpeningObject) O).minLeg
							* myFrame2.scale.doubleValue())
			{
				posY = ((OpeningObject) O).leftPart.startYC
						- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
						- myThick;
				change = true;

				myParentBO.mullionsH.clear();

				for (final Object MH : hM)
				{
					if (((Profiles) MH).equals(((OpeningObject) O).myMullionBot))
					{
						((Profiles) MH).y2 = posY;
						((Profiles) MH).y1 = posY + ((Profiles) MH).thickness;
						((Profiles) MH).centerYs = posY + ((Profiles) MH).thickness / 2;
						((Profiles) MH).y3 = posY;
						((Profiles) MH).y4 = posY + ((Profiles) MH).thickness;
						((Profiles) MH).centerYe = posY + ((Profiles) MH).thickness / 2;
						((Profiles) MH).y2cl = posY;
						((Profiles) MH).y1al = posY + ((Profiles) MH).thickness;

						((Profiles) MH).y3cl = posY;
						((Profiles) MH).y4al = posY + ((Profiles) MH).thickness;
					}
					myParentBO.mullionsH.add(MH);

				} // Big FOR
			}
			if (((OpeningObject) O).endRow == myParentBO.yRows
					&& ((OpeningObject) O).topIn
					&& ((OpeningObject) O).noSidesRight != 0
					&& ((OpeningObject) O).rightPart.endYC - ((OpeningObject) O).myMullionTop.y4 < ((OpeningObject) O).minLeg
							* myFrame2.scale.doubleValue())
			{
				posY = ((OpeningObject) O).rightPart.endYC
						- myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue()
						- myThick;
				change = true;

				myParentBO.mullionsH.clear();

				for (final Object MH : hM)
				{
					if (((Profiles) MH).equals(((OpeningObject) O).myMullionBot))
					{
						((Profiles) MH).y2 = posY;
						((Profiles) MH).y1 = posY + ((Profiles) MH).thickness;
						((Profiles) MH).centerYs = posY + ((Profiles) MH).thickness / 2;
						((Profiles) MH).y3 = posY;
						((Profiles) MH).y4 = posY + ((Profiles) MH).thickness;
						((Profiles) MH).centerYe = posY + ((Profiles) MH).thickness / 2;
						((Profiles) MH).y2cl = posY;
						((Profiles) MH).y1al = posY + ((Profiles) MH).thickness;

						((Profiles) MH).y3cl = posY;
						((Profiles) MH).y4al = posY + ((Profiles) MH).thickness;
					}
					myParentBO.mullionsH.add(MH);

				} // Big FOR
			}
			if (((OpeningObject) O).botIn
					&& ((OpeningObject) O).topIn
					&& ((OpeningObject) O).myMullionBot.y2 - ((OpeningObject) O).myMullionTop.y1 < ((OpeningObject) O).minLeg
							* myFrame2.scale.doubleValue())
			{

				posY = ((OpeningObject) O).myMullionTop.y1
						+ myParentBO.myParent.bOpeningObject.minLeg * myFrame2.scale.doubleValue();
				change = true;

				myParentBO.mullionsH.clear();

				for (final Object MH : hM)
				{
					if (((Profiles) MH).equals(((OpeningObject) O).myMullionBot))
					{
						((Profiles) MH).y2 = posY;
						((Profiles) MH).y1 = posY + ((Profiles) MH).thickness;
						((Profiles) MH).centerYs = posY + ((Profiles) MH).thickness / 2;
						((Profiles) MH).y3 = posY;
						((Profiles) MH).y4 = posY + ((Profiles) MH).thickness;
						((Profiles) MH).centerYe = posY + ((Profiles) MH).thickness / 2;
						((Profiles) MH).y2cl = posY;
						((Profiles) MH).y1al = posY + ((Profiles) MH).thickness;

						((Profiles) MH).y3cl = posY;
						((Profiles) MH).y4al = posY + ((Profiles) MH).thickness;
					}
					myParentBO.mullionsH.add(MH);

				} // Big FOR
			}

		}
		if (change)
		{
			myParentBO.mullionObjectsH = null;
			myParentBO.mullionObjectsH = myParentBO.mullionsH.toArray();
			myParentBO.mullionsH.clear();
			for (int vc = 0; vc < myParentBO.mullionObjectsH.length; vc++)
			{

				this.verifyLimitLR(((Profiles) myParentBO.mullionObjectsH[vc]));
				calcMullion.calculateCoord(((Profiles) myParentBO.mullionObjectsH[vc]));
				((Profiles) myParentBO.mullionObjectsH[vc]).isNew = false;
				((Profiles) myParentBO.mullionObjectsH[vc]).y3 = ((Profiles) myParentBO.mullionObjectsH[vc]).y3;
				((Profiles) myParentBO.mullionObjectsH[vc]).y4 = ((Profiles) myParentBO.mullionObjectsH[vc]).y4;
				((Profiles) myParentBO.mullionObjectsH[vc]).exists = alreadyExist;

				((Profiles) myParentBO.mullionObjectsH[vc]).potentialS = false;

				myParentBO.mullionsH.add(myParentBO.mullionObjectsH[vc]);

			} // Big FOR Loop

			this.recalcVCCoords();
			this.reOrderHMNotches();
			myParentBO.myParent.doOpenings();

		}

		return posY;
	}

	public boolean verifyNeedToRemove(final double posY, final Profiles myMullion)
	{

		// this.getProfileDims(myMullion);
		boolean remove = myMullion.remove;
		if (myMullion.isNew)
		{
			final Object[] openings = myParentBO.myParent.frames.toArray();
			for (final Object O : openings)
			{
				if (((Frame) O).endCol >= myMullion.endPos
						&& ((Frame) O).startCol <= myMullion.startPos
						&& ((Frame) O).startRow <= myMullion.rowCol
						&& ((Frame) O).endRow >= myMullion.rowCol
						&& (((Frame) O).noSidesLeft == 0 || ((Frame) O).noSidesRight == 0))
				{

					if (((Frame) O).highestY < posY
							&& (((Frame) O).bOpeningObject.highestY > posY || posY
									- ((Frame) O).bOpeningObject.highestY < myParentBO.myParent.bOpeningObject.minLeg
									* myFrame2.scale.doubleValue()))
					{
						remove = true;

						break;

					}
				}

				if (((Frame) O).endCol >= myMullion.endPos
						&& ((Frame) O).startCol <= myMullion.startPos
						&& ((Frame) O).startRow == myMullion.rowCol + 1
						&& (((Frame) O).noSidesLeft == 0 || ((Frame) O).noSidesRight == 0))
				{
					if (((Frame) O).lowestY > posY + myThick
							&& ((Frame) O).bOpeningObject.lowestY < posY + myThick
							|| ((Frame) O).bOpeningObject.lowestY - posY + myThick < myParentBO.myParent.bOpeningObject.minLeg
									* myFrame2.scale.doubleValue())
					{
						remove = true;

						break;

					}

				}
			}
		}
		else
		{
			final Object[] openings = myParentBO.myParent.frames.toArray();
			for (final Object O : openings)
			{
				if (((Frame) O).endCol >= myMullion.endPos
						&& ((Frame) O).startCol <= myMullion.startPos
						&& ((Frame) O).endRow == myMullion.rowCol
						&& (((Frame) O).noSidesLeft == 0 || ((Frame) O).noSidesRight == 0))
				{

					if (((Frame) O).highestY < posY
							&& (((Frame) O).bOpeningObject.highestY > posY || posY
									- ((Frame) O).bOpeningObject.highestY < myParentBO.myParent.bOpeningObject.minLeg))
					{
						remove = true;

						break;
					}

				}

				if (((Frame) O).endCol >= myMullion.endPos
						&& ((Frame) O).startCol <= myMullion.startPos
						&& ((Frame) O).startRow == myMullion.rowCol + 1
						&& (((Frame) O).noSidesLeft == 0 || ((Frame) O).noSidesRight == 0))
				{

					if (((Frame) O).lowestY > posY + myThick
							&& ((Frame) O).bOpeningObject.lowestY < posY + myThick
							|| ((Frame) O).bOpeningObject.lowestY - posY + myThick < myParentBO.myParent.bOpeningObject.minLeg
									* myFrame2.scale.doubleValue())
					{
						remove = true;

						break;
					}

				}
			}

		}
		return remove;
	}

	public void removeOpening(final Profiles myMullion)
	{

		Object[] openings = myParentBO.myParent.openings.toArray();

		myParentBO.myParent.openings.clear();
		OpeningObject myremoved = new OpeningObject(myFrame2);

		for (final Object O : openings)
		{
			if (((OpeningObject) O).endCol == myMullion.endPos
					&& ((OpeningObject) O).startCol == myMullion.startPos
					&& ((OpeningObject) O).startRow == myMullion.rowCol + 1)
			{

				myremoved = (OpeningObject) O;
				if (myremoved.myMullionBot != null)
				{

				}
				else
				{
					// myremoved.endRow
					// =
					// myParent.yRows;
				}
			}
			else
			{
				myParentBO.myParent.openings.add(O);
			}
		}

		openings = myParentBO.myParent.openings.toArray();

		myParentBO.myParent.openings.clear();
		for (final Object O : openings)
		{
			if (((OpeningObject) O).endCol == myMullion.endPos
					&& ((OpeningObject) O).startCol == myMullion.startPos
					&& ((OpeningObject) O).endRow == myMullion.rowCol)
			{
				((OpeningObject) O).endRow = myremoved.endRow;
				((OpeningObject) O).myMullionBot = myremoved.myMullionBot;
				((OpeningObject) O).bX4 = myremoved.bX4;
				((OpeningObject) O).bY4 = myremoved.bY4;
				((OpeningObject) O).bX3 = myremoved.bX3;
				((OpeningObject) O).bY3 = myremoved.bY3;

			}
			myParentBO.myParent.openings.add(O);
		}
		openings = myParentBO.myParent.openings.toArray();

		myParentBO.myParent.openings.clear();
		for (final Object O : openings)
		{
			if (!moreAtRow)
			{
				((OpeningObject) O).endRow = myParentBO.myParent.yRows;
				((OpeningObject) O).startRow = 1;

				if (((OpeningObject) O).startRow > myremoved.startRow)
				{
					((OpeningObject) O).startRow = ((OpeningObject) O).startRow - 1;

				}
				if (((OpeningObject) O).endRow >= myremoved.endRow)
				{
					((OpeningObject) O).endRow = ((OpeningObject) O).endRow - 1;

				}

				if (((OpeningObject) O).myMullionBot != null
						&& ((OpeningObject) O).endRow != myParentBO.myParent.yRows
						&& ((OpeningObject) O).endRow > ((OpeningObject) O).myMullionBot.rowCol)
				{
					((OpeningObject) O).endRow = ((OpeningObject) O).myMullionBot.rowCol;

				}
				if (((OpeningObject) O).myMullionTop != null && ((OpeningObject) O).startRow != 1
						&& ((OpeningObject) O).startRow < ((OpeningObject) O).myMullionTop.rowCol)
				{
					((OpeningObject) O).startRow = ((OpeningObject) O).myMullionTop.rowCol + 1;

				}
			}

			myParentBO.myParent.openings.add(O);

		}

	}

	public void verifyLimitsSpecialShapes(final Profiles myMullion)
	{

		if (myParentBO.shapeID == 700)
		{
			limitStartXsA = myParentBO.myParent.top1.startXA;
			limitStartYsA = myParentBO.myParent.top1.startYA;
			limitStartXeA = myParentBO.myParent.top1.endXA;
			limitStartYeA = myParentBO.myParent.top1.endYA;
			limitStartXsBA = myParentBO.myParent.top1.startXBA;
			limitStartYsBA = myParentBO.myParent.top1.startYBA;
			limitStartXeBA = myParentBO.myParent.top1.endXBA;
			limitStartYeBA = myParentBO.myParent.top1.endYBA;
			dimLM = myParentBO.myParent.top1.partDimM;
			dimLA = myParentBO.myParent.top1.partDimA;
			myThetaRight = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
					/ myParentBO.myParent.bOpeningObject.dimD2);

		}
		else if (myParentBO.shapeID == 701)
		{
			limitEndXsA = myParentBO.myParent.top1.startXA;
			limitEndYsA = myParentBO.myParent.top1.startYA;
			limitEndXeA = myParentBO.myParent.top1.endXA;
			limitEndYeA = myParentBO.myParent.top1.endYA;
			limitEndXsBA = myParentBO.myParent.top1.startXBA;
			limitEndYsBA = myParentBO.myParent.top1.startYBA;
			limitEndXeBA = myParentBO.myParent.top1.endXBA;
			limitEndYeBA = myParentBO.myParent.top1.endYBA;
			dimRM = myParentBO.myParent.top1.partDimM;
			dimRA = myParentBO.myParent.top1.partDimA;
			newAlpha = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
					/ myParentBO.myParent.bOpeningObject.dimB1);

		}
		else if (myParentBO.shapeID == 702)
		{
			if (newStartingYLBa < myParentBO.startingY + myParentBO.myParent.bOpeningObject.dimD2)
			{
				limitStartXsA = myParentBO.myParent.top1.startXA;
				limitStartYsA = myParentBO.myParent.top1.startYA;
				limitStartXeA = myParentBO.myParent.top1.endXA;
				limitStartYeA = myParentBO.myParent.top1.endYA;
				limitStartXsBA = myParentBO.myParent.top1.startXBA;
				limitStartYsBA = myParentBO.myParent.top1.startYBA;
				limitStartXeBA = myParentBO.myParent.top1.endXBA;
				limitStartYeBA = myParentBO.myParent.top1.endYBA;
				dimLM = myParentBO.myParent.top1.partDimM;
				dimLA = myParentBO.myParent.top1.partDimA;
				newAlpha = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
						/ myParentBO.myParent.bOpeningObject.dimD2);

			}
			if (myMullion.y2cl > myParentBO.startingY + myParentBO.myParent.bOpeningObject.dimD2)
			{
				limitStartXsA = myParentBO.myParent.bot1.startXA;
				limitStartYsA = myParentBO.myParent.bot1.startYA;
				limitStartXeA = myParentBO.myParent.bot1.endXA;
				limitStartYeA = myParentBO.myParent.bot1.endYA;
				limitStartXsBA = myParentBO.myParent.bot1.startXBA;
				limitStartYsBA = myParentBO.myParent.bot1.startYBA;
				limitStartXeBA = myParentBO.myParent.bot1.endXBA;
				limitStartYeBA = myParentBO.myParent.bot1.endYBA;
				dimLM = myParentBO.myParent.bot1.partDimM;
				dimLA = myParentBO.myParent.bot1.partDimA;
				newAlpha = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
						/ myParentBO.myParent.bOpeningObject.dimD0);

			}

		}
		else if (myParentBO.shapeID == 703)
		{
			if (myMullion.y4al < myParentBO.startingY + myParentBO.myParent.bOpeningObject.dimB0)
			{
				limitEndXsA = myParentBO.myParent.top1.startXA;
				limitEndYsA = myParentBO.myParent.top1.startYA;
				limitEndXeA = myParentBO.myParent.top1.endXA;
				limitEndYeA = myParentBO.myParent.top1.endYA;
				limitEndXsBA = myParentBO.myParent.top1.startXBA;
				limitEndYsBA = myParentBO.myParent.top1.startYBA;
				limitEndXeBA = myParentBO.myParent.top1.endXBA;
				limitEndYeBA = myParentBO.myParent.top1.endYBA;
				dimLM = myParentBO.myParent.top1.partDimM;
				dimLA = myParentBO.myParent.top1.partDimA;
				myThetaRight = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
						/ myParentBO.myParent.bOpeningObject.dimB0);

			}
			if (myMullion.y3cl > myParentBO.startingY + myParentBO.myParent.bOpeningObject.dimB0)
			{
				limitEndXsA = myParentBO.myParent.bot1.startXA;
				limitEndYsA = myParentBO.myParent.bot1.startYA;
				limitEndXeA = myParentBO.myParent.bot1.endXA;
				limitEndYeA = myParentBO.myParent.bot1.endYA;
				limitEndXsBA = myParentBO.myParent.bot1.startXBA;
				limitEndYsBA = myParentBO.myParent.bot1.startYBA;
				limitEndXeBA = myParentBO.myParent.bot1.endXBA;
				limitEndYeBA = myParentBO.myParent.bot1.endYBA;
				dimLM = myParentBO.myParent.bot1.partDimM;
				dimLA = myParentBO.myParent.bot1.partDimA;
				myThetaRight = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
						/ myParentBO.myParent.bOpeningObject.dimB2);

			}

		}
		else if (myParentBO.shapeID == 704)
		{

		}
		else if (myParentBO.shapeID == 705)
		{
			limitStartXsA = myParentBO.myParent.bot1.startXA;
			limitStartYsA = myParentBO.myParent.bot1.startYA;
			limitStartXeA = myParentBO.myParent.bot1.endXA;
			limitStartYeA = myParentBO.myParent.bot1.endYA;
			limitStartXsBA = myParentBO.myParent.bot1.startXBA;
			limitStartYsBA = myParentBO.myParent.bot1.startYBA;
			limitStartXeBA = myParentBO.myParent.bot1.endXBA;
			limitStartYeBA = myParentBO.myParent.bot1.endYBA;
			dimLM = myParentBO.myParent.bot1.partDimM;
			dimLA = myParentBO.myParent.bot1.partDimA;
			newAlpha = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
					/ myParentBO.myParent.bOpeningObject.dimD2);

		}
		else if (myParentBO.shapeID == 706)
		{
			limitEndXsA = myParentBO.myParent.bot1.startXA;
			limitEndYsA = myParentBO.myParent.bot1.startYA;
			limitEndXeA = myParentBO.myParent.bot1.endXA;
			limitEndYeA = myParentBO.myParent.bot1.endYA;
			limitEndXsBA = myParentBO.myParent.bot1.startXBA;
			limitEndYsBA = myParentBO.myParent.bot1.startYBA;
			limitEndXeBA = myParentBO.myParent.bot1.endXBA;
			limitEndYeBA = myParentBO.myParent.bot1.endYBA;
			dimRM = myParentBO.myParent.bot1.partDimM;
			dimRA = myParentBO.myParent.bot1.partDimA;
			myThetaRight = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
					/ myParentBO.myParent.bOpeningObject.dimB2);

		}
	}

	public void verifyLimitsSpecialShapesR(final Profiles myMullion)
	{

		if (myParentBO.shapeID == 700)
		{
			limitStartXsA = myParentBO.myParent.top1.startXA;
			limitStartYsA = myParentBO.myParent.top1.startYA;
			limitStartXeA = myParentBO.myParent.top1.endXA;
			limitStartYeA = myParentBO.myParent.top1.endYA;
			limitStartXsBA = myParentBO.myParent.top1.startXBA;
			limitStartYsBA = myParentBO.myParent.top1.startYBA;
			limitStartXeBA = myParentBO.myParent.top1.endXBA;
			limitStartYeBA = myParentBO.myParent.top1.endYBA;
			dimLM = myParentBO.myParent.top1.partDimM;
			dimLA = myParentBO.myParent.top1.partDimA;
			myThetaRight = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
					/ myParentBO.myParent.bOpeningObject.dimD2);

		}
		else if (myParentBO.shapeID == 701)
		{
			limitEndXsA = myParentBO.myParent.top1.startXA;
			limitEndYsA = myParentBO.myParent.top1.startYA;
			limitEndXeA = myParentBO.myParent.top1.endXA;
			limitEndYeA = myParentBO.myParent.top1.endYA;
			limitEndXsBA = myParentBO.myParent.top1.startXBA;
			limitEndYsBA = myParentBO.myParent.top1.startYBA;
			limitEndXeBA = myParentBO.myParent.top1.endXBA;
			limitEndYeBA = myParentBO.myParent.top1.endYBA;
			dimRM = myParentBO.myParent.top1.partDimM;
			dimRA = myParentBO.myParent.top1.partDimA;
			newAlpha = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
					/ myParentBO.myParent.bOpeningObject.dimB1);

		}
		else if (myParentBO.shapeID == 702)
		{
			if (newStartingYLBa < myParentBO.startingY + myParentBO.myParent.bOpeningObject.dimD2)
			{
				limitStartXsA = myParentBO.myParent.top1.startXA;
				limitStartYsA = myParentBO.myParent.top1.startYA;
				limitStartXeA = myParentBO.myParent.top1.endXA;
				limitStartYeA = myParentBO.myParent.top1.endYA;
				limitStartXsBA = myParentBO.myParent.top1.startXBA;
				limitStartYsBA = myParentBO.myParent.top1.startYBA;
				limitStartXeBA = myParentBO.myParent.top1.endXBA;
				limitStartYeBA = myParentBO.myParent.top1.endYBA;
				dimLM = myParentBO.myParent.top1.partDimM;
				dimLA = myParentBO.myParent.top1.partDimA;
				newAlpha = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
						/ myParentBO.myParent.bOpeningObject.dimD2);

			}
			if (myMullion.y2cl > myParentBO.startingY + myParentBO.myParent.bOpeningObject.dimD2)
			{
				limitStartXsA = myParentBO.myParent.bot1.startXA;
				limitStartYsA = myParentBO.myParent.bot1.startYA;
				limitStartXeA = myParentBO.myParent.bot1.endXA;
				limitStartYeA = myParentBO.myParent.bot1.endYA;
				limitStartXsBA = myParentBO.myParent.bot1.startXBA;
				limitStartYsBA = myParentBO.myParent.bot1.startYBA;
				limitStartXeBA = myParentBO.myParent.bot1.endXBA;
				limitStartYeBA = myParentBO.myParent.bot1.endYBA;
				dimLM = myParentBO.myParent.bot1.partDimM;
				dimLA = myParentBO.myParent.bot1.partDimA;
				newAlpha = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
						/ myParentBO.myParent.bOpeningObject.dimD0);

			}

		}
		else if (myParentBO.shapeID == 703)
		{
			if (myMullion.y4al < myParentBO.startingY + myParentBO.myParent.bOpeningObject.dimB0)
			{
				limitEndXsA = myParentBO.myParent.top1.startXA;
				limitEndYsA = myParentBO.myParent.top1.startYA;
				limitEndXeA = myParentBO.myParent.top1.endXA;
				limitEndYeA = myParentBO.myParent.top1.endYA;
				limitEndXsBA = myParentBO.myParent.top1.startXBA;
				limitEndYsBA = myParentBO.myParent.top1.startYBA;
				limitEndXeBA = myParentBO.myParent.top1.endXBA;
				limitEndYeBA = myParentBO.myParent.top1.endYBA;
				dimLM = myParentBO.myParent.top1.partDimM;
				dimLA = myParentBO.myParent.top1.partDimA;
				myThetaRight = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
						/ myParentBO.myParent.bOpeningObject.dimB0);

			}
			if (myMullion.y3cl > myParentBO.startingY + myParentBO.myParent.bOpeningObject.dimB0)
			{
				limitEndXsA = myParentBO.myParent.bot1.startXA;
				limitEndYsA = myParentBO.myParent.bot1.startYA;
				limitEndXeA = myParentBO.myParent.bot1.endXA;
				limitEndYeA = myParentBO.myParent.bot1.endYA;
				limitEndXsBA = myParentBO.myParent.bot1.startXBA;
				limitEndYsBA = myParentBO.myParent.bot1.startYBA;
				limitEndXeBA = myParentBO.myParent.bot1.endXBA;
				limitEndYeBA = myParentBO.myParent.bot1.endYBA;
				dimLM = myParentBO.myParent.bot1.partDimM;
				dimLA = myParentBO.myParent.bot1.partDimA;
				myThetaRight = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
						/ myParentBO.myParent.bOpeningObject.dimB2);

			}

		}
		else if (myParentBO.shapeID == 704)
		{

		}
		else if (myParentBO.shapeID == 705)
		{
			limitStartXsA = myParentBO.myParent.bot1.startXA;
			limitStartYsA = myParentBO.myParent.bot1.startYA;
			limitStartXeA = myParentBO.myParent.bot1.endXA;
			limitStartYeA = myParentBO.myParent.bot1.endYA;
			limitStartXsBA = myParentBO.myParent.bot1.startXBA;
			limitStartYsBA = myParentBO.myParent.bot1.startYBA;
			limitStartXeBA = myParentBO.myParent.bot1.endXBA;
			limitStartYeBA = myParentBO.myParent.bot1.endYBA;
			dimLM = myParentBO.myParent.bot1.partDimM;
			dimLA = myParentBO.myParent.bot1.partDimA;
			newAlpha = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
					/ myParentBO.myParent.bOpeningObject.dimD2);

		}
		else if (myParentBO.shapeID == 706)
		{
			limitEndXsA = myParentBO.myParent.bot1.startXA;
			limitEndYsA = myParentBO.myParent.bot1.startYA;
			limitEndXeA = myParentBO.myParent.bot1.endXA;
			limitEndYeA = myParentBO.myParent.bot1.endYA;
			limitEndXsBA = myParentBO.myParent.bot1.startXBA;
			limitEndYsBA = myParentBO.myParent.bot1.startYBA;
			limitEndXeBA = myParentBO.myParent.bot1.endXBA;
			limitEndYeBA = myParentBO.myParent.bot1.endYBA;
			dimRM = myParentBO.myParent.bot1.partDimM;
			dimRA = myParentBO.myParent.bot1.partDimA;
			myThetaRight = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
					/ myParentBO.myParent.bOpeningObject.dimB2);

		}
	}

	/*
	 * public void verifyLlimitsLeftOLD( final Profiles myMullion) { if
	 * ((myMullion.y1al <= myParentBO.highestY + myParentBO.dimD2) &&
	 * (myParentBO.noSidesTop == 1) && (myParentBO.dimD1 > 0) && !startIn &&
	 * ((myParentBO.lean4 == 1) || (myParentBO.lean4 == 3))) { limitStartXsA =
	 * myParentBO.myParent.top1.startXA; limitStartYsA =
	 * myParentBO.myParent.top1.startYA; limitStartXeA =
	 * myParentBO.myParent.top1.endXA; limitStartYeA =
	 * myParentBO.myParent.top1.endYA; limitStartXsBA =
	 * myParentBO.myParent.top1.startXBA; limitStartYsBA =
	 * myParentBO.myParent.top1.startYBA; limitStartXeBA =
	 * myParentBO.myParent.top1.endXBA; limitStartYeBA =
	 * myParentBO.myParent.top1.endYBA; dimLM =
	 * myParentBO.myParent.top1.partDimM; dimLA =
	 * myParentBO.myParent.top1.partDimA; limitLTArchCenterX =
	 * myParentBO.myParent.top1.x1; limitLTArchCenterY =
	 * myParentBO.myParent.top1.y1; newAlpha = Math
	 * .atan(myParentBO.myParent.bOpeningObject.widthPixT /
	 * myParentBO.myParent.bOpeningObject.dimD2); if
	 * (myParentBO.myParent.top1.partForm == 2) { inArchL = 1; limitStart =
	 * myParentBO.myParent.top1Part; } else if
	 * (myParentBO.myParent.top1.partForm == 3) { inArchL = 3; limitStart =
	 * myParentBO.myParent.top1Part; } } else if ((myMullion.y1al <=
	 * myParentBO.myParent.top1.startYA) && (myParentBO.noSidesTop == 1) &&
	 * (myParentBO.myParent.top1.partForm > 1) && !startIn) { limitStart =
	 * myParentBO.myParent.top1Part; limitStartXsA =
	 * myParentBO.myParent.top1.startXA; limitStartYsA =
	 * myParentBO.myParent.top1.startYA; limitStartXeA =
	 * myParentBO.myParent.top1.endXA; limitStartYeA =
	 * myParentBO.myParent.top1.endYA; limitStartXsBA =
	 * myParentBO.myParent.top1.startXBA; limitStartYsBA =
	 * myParentBO.myParent.top1.startYBA; limitStartXeBA =
	 * myParentBO.myParent.top1.endXBA; limitStartYeBA =
	 * myParentBO.myParent.top1.endYBA; dimLM =
	 * myParentBO.myParent.top1.partDimM; dimLA =
	 * myParentBO.myParent.top1.partDimA; limitLTArchCenterX =
	 * myParentBO.myParent.top1.x1; limitLTArchCenterY =
	 * myParentBO.myParent.top1.y1; newAlpha = Math
	 * .atan(myParentBO.myParent.bOpeningObject.widthPixT /
	 * myParentBO.myParent.bOpeningObject.dimD2); if
	 * (myParentBO.myParent.top1.partForm == 2) { inArchL = 1; limitStart =
	 * myParentBO.myParent.top1Part; } else if
	 * (myParentBO.myParent.top1.partForm == 3) { inArchL = 3; limitStart =
	 * myParentBO.myParent.top1Part; } } else if ((myMullion.y1al <=
	 * myParentBO.highestY + myParentBO.myParent.bOpeningObject.dimD2) &&
	 * (myParentBO.noSidesTop > 1) && (myParentBO.myParent.bOpeningObject.dimD1
	 * > 0) && !startIn && ((myParentBO.lean4 == 1) || (myParentBO.lean4 ==
	 * 3))) { limitStartXsA = myParentBO.myParent.top1.startXA; limitStartYsA =
	 * myParentBO.myParent.top1.startYA; limitStartXeA =
	 * myParentBO.myParent.top1.endXA; limitStartYeA =
	 * myParentBO.myParent.top1.endYA; limitStartXsBA =
	 * myParentBO.myParent.top1.startXBA; limitStartYsBA =
	 * myParentBO.myParent.top1.startYBA; limitStartXeBA =
	 * myParentBO.myParent.top1.endXBA; limitStartYeBA =
	 * myParentBO.myParent.top1.endYBA; dimLM =
	 * myParentBO.myParent.top1.partDimM; dimLA =
	 * myParentBO.myParent.top1.partDimA; limitLTArchCenterX =
	 * myParentBO.myParent.top1.x1; limitLTArchCenterY =
	 * myParentBO.myParent.top1.y1; newAlpha = Math
	 * .atan(myParentBO.myParent.bOpeningObject.dimA1 /
	 * myParentBO.myParent.bOpeningObject.dimD2); if
	 * (myParentBO.myParent.top1.partForm == 2) { inArchL = 1; limitStart =
	 * myParentBO.myParent.top1Part; } } else if ((myMullion.y2cl >=
	 * myParentBO.highestY + myParentBO.myParent.bOpeningObject.dimD2 +
	 * myParentBO.myParent.bOpeningObject.dimD1) && (myParentBO.noSidesBot ==
	 * 1) && (myParentBO.myParent.bOpeningObject.dimD0 > 0) && !startIn) {
	 * limitStartXsA = myParentBO.myParent.bot1.startXA; limitStartYsA =
	 * myParentBO.myParent.bot1.startYA; limitStartXeA =
	 * myParentBO.myParent.bot1.endXA; limitStartYeA =
	 * myParentBO.myParent.bot1.endYA; limitStartXsBA =
	 * myParentBO.myParent.bot1.startXBA; limitStartYsBA =
	 * myParentBO.myParent.bot1.startYBA; limitStartXeBA =
	 * myParentBO.myParent.bot1.endXBA; limitStartYeBA =
	 * myParentBO.myParent.bot1.endYBA; dimLM =
	 * myParentBO.myParent.bot1.partDimM; dimLA =
	 * myParentBO.myParent.bot1.partDimA; newAlpha = Math
	 * .atan(myParentBO.myParent.bOpeningObject.widthPixT /
	 * myParentBO.myParent.bOpeningObject.dimD0); } else if ((myMullion.y2cl >
	 * myParentBO.highestY + myParentBO.myParent.bOpeningObject.dimD2 +
	 * myParentBO.myParent.bOpeningObject.dimD1) && (myParentBO.noSidesBot > 1)
	 * && (myParentBO.myParent.bOpeningObject.dimD0 > 0) && !startIn) {
	 * limitStartXsA = myParentBO.myParent.bot2.startXA; limitStartYsA =
	 * myParentBO.myParent.bot2.startYA; limitStartXeA =
	 * myParentBO.myParent.bot2.endXA; limitStartYeA =
	 * myParentBO.myParent.bot2.endYA; limitStartXsBA =
	 * myParentBO.myParent.bot2.startXBA; limitStartYsBA =
	 * myParentBO.myParent.bot2.startYBA; limitStartXeBA =
	 * myParentBO.myParent.bot2.endXBA; limitStartYeBA =
	 * myParentBO.myParent.bot2.endYBA; dimLM =
	 * myParentBO.myParent.bot2.partDimM; dimLA =
	 * myParentBO.myParent.bot2.partDimA; newAlpha = Math
	 * .atan(myParentBO.myParent.bOpeningObject.dimC2 /
	 * myParentBO.myParent.bOpeningObject.dimD0); } else if ((myMullion.y2cl >=
	 * myParentBO.highestY + myParentBO.myParent.bOpeningObject.dimD2) &&
	 * (myParentBO.noSidesBot == 1) &&
	 * (myParentBO.myParent.bOpeningObject.dimD0 == 0) &&
	 * (myParentBO.myParent.bOpeningObject.dimD2 > 0) && (myParentBO.lean4 ==
	 * 2) && (myParentBO.myParent.bOpeningObject.dimD1 > 0) && !startIn) {
	 * limitStartXsA = myParentBO.myParent.bot1.startXA; limitStartYsA =
	 * myParentBO.myParent.bot1.startYA; limitStartXeA =
	 * myParentBO.myParent.bot1.endXA; limitStartYeA =
	 * myParentBO.myParent.bot1.endYA; limitStartXsBA =
	 * myParentBO.myParent.bot1.startXBA; limitStartYsBA =
	 * myParentBO.myParent.bot1.startYBA; limitStartXeBA =
	 * myParentBO.myParent.bot1.endXBA; limitStartYeBA =
	 * myParentBO.myParent.bot1.endYBA; dimLM =
	 * myParentBO.myParent.bot1.partDimM; dimLA =
	 * myParentBO.myParent.bot1.partDimA; limitLTArchCenterX =
	 * myParentBO.myParent.bot1.x1; limitLTArchCenterY =
	 * myParentBO.myParent.bot1.y1; newAlpha = Math
	 * .atan(myParentBO.myParent.bOpeningObject.widthB /
	 * myParentBO.myParent.bOpeningObject.dimD1); if
	 * (myParentBO.myParent.bot1.partForm == 2) { inArchL = 1; limitStart =
	 * myParentBO.myParent.bot1Part; } if (myParentBO.myParent.bot1.partForm ==
	 * 3) { inArchL = 3; limitStart = myParentBO.myParent.bot1Part; } } }
	 */
	public void verifyLlimitsLeft(final Profiles myMullion)
	{

		if (myParentBO.top1Part.posInUse && myParentBO.top1Part.startYC >= myMullion.y1al
				&& myParentBO.top1Part.endYC <= myMullion.y2cl)
		{

			limitStartXsA = myParentBO.myParent.top1.startXA;
			limitStartYsA = myParentBO.myParent.top1.startYA;
			limitStartXeA = myParentBO.myParent.top1.endXA;
			limitStartYeA = myParentBO.myParent.top1.endYA;
			limitStartXsBA = myParentBO.myParent.top1.startXBA;
			limitStartYsBA = myParentBO.myParent.top1.startYBA;
			limitStartXeBA = myParentBO.myParent.top1.endXBA;
			limitStartYeBA = myParentBO.myParent.top1.endYBA;
			dimLM = myParentBO.myParent.top1.partDimM;
			dimLA = myParentBO.myParent.top1.partDimA;

			limitLTArchCenterX = myParentBO.myParent.top1.x1;
			limitLTArchCenterY = myParentBO.myParent.top1.y1;
			newAlpha = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
					/ myParentBO.myParent.bOpeningObject.dimD2);
			if (myParentBO.myParent.top1.partForm == 2)
			{
				inArchL = 1;
				limitStart = myParentBO.myParent.top1Part;
			}
			else if (myParentBO.myParent.top1.partForm == 3)
			{
				inArchL = 3;
				limitStart = myParentBO.myParent.top1Part;
			}

		}
		if (myParentBO.top1Part.posInUse && myParentBO.top1Part.partForm > 1
				&& myParentBO.noSidesTop == 1 && myParentBO.top1Part.startYC >= myMullion.y2cl)
		{

			limitStartXsA = myParentBO.myParent.top1.startXA;
			limitStartYsA = myParentBO.myParent.top1.startYA;
			limitStartXeA = myParentBO.myParent.top1.endXA;
			limitStartYeA = myParentBO.myParent.top1.endYA;
			limitStartXsBA = myParentBO.myParent.top1.startXBA;
			limitStartYsBA = myParentBO.myParent.top1.startYBA;
			limitStartXeBA = myParentBO.myParent.top1.endXBA;
			limitStartYeBA = myParentBO.myParent.top1.endYBA;
			dimLM = myParentBO.myParent.top1.partDimM;
			dimLA = myParentBO.myParent.top1.partDimA;

			limitLTArchCenterX = myParentBO.myParent.top1.x1;
			limitLTArchCenterY = myParentBO.myParent.top1.y1;
			newAlpha = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
					/ myParentBO.myParent.bOpeningObject.dimD2);
			if (myParentBO.myParent.top1.partForm == 2)
			{
				inArchL = 1;
				limitStart = myParentBO.myParent.top1Part;
			}
			else if (myParentBO.myParent.top1.partForm == 3)
			{
				inArchL = 3;
				limitStart = myParentBO.myParent.top1Part;
			}

		}
		else if (myParentBO.leftPart.posInUse && myParentBO.leftPart.startYC >= myMullion.y1al
				&& myParentBO.leftPart.endYC <= myMullion.y2cl)
		{
			limitStartXsA = myParentBO.myParent.left.startXA;
			limitStartYsA = myParentBO.myParent.left.startYA;
			limitStartXeA = myParentBO.myParent.left.endXA;
			limitStartYeA = myParentBO.myParent.left.endYA;
			limitStartXsBA = myParentBO.myParent.left.startXBA;
			limitStartYsBA = myParentBO.myParent.left.startYBA;
			limitStartXeBA = myParentBO.myParent.left.endXBA;
			limitStartYeBA = myParentBO.myParent.left.endYBA;
			dimLM = myParentBO.myParent.left.partDimM;
			dimLA = myParentBO.myParent.left.partDimA;

			startIn = false;

		}
		else if (myParentBO.bot1Part.posInUse && myParentBO.bot1Part.startYC >= myMullion.y1al
				&& myParentBO.bot1Part.endYC <= myMullion.y2cl)
		{
			limitStartXsA = myParentBO.myParent.bot1.startXA;
			limitStartYsA = myParentBO.myParent.bot1.startYA;
			limitStartXeA = myParentBO.myParent.bot1.endXA;
			limitStartYeA = myParentBO.myParent.bot1.endYA;
			limitStartXsBA = myParentBO.myParent.bot1.startXBA;
			limitStartYsBA = myParentBO.myParent.bot1.startYBA;
			limitStartXeBA = myParentBO.myParent.bot1.endXBA;
			limitStartYeBA = myParentBO.myParent.bot1.endYBA;
			dimLM = myParentBO.myParent.bot1.partDimM;
			dimLA = myParentBO.myParent.bot1.partDimA;

			newAlpha = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
					/ myParentBO.myParent.bOpeningObject.dimD0);

		}
		else if (myParentBO.bot1Part.partForm > 1 && myParentBO.noSidesBot == 1
				&& myParentBO.bot1Part.posInUse && myParentBO.bot1Part.startYC >= myMullion.y1al
				&& myParentBO.bot1Part.endYC <= myMullion.y2cl)
		{
			limitStartXsA = myParentBO.myParent.bot1.startXA;
			limitStartYsA = myParentBO.myParent.bot1.startYA;
			limitStartXeA = myParentBO.myParent.bot1.endXA;
			limitStartYeA = myParentBO.myParent.bot1.endYA;
			limitStartXsBA = myParentBO.myParent.bot1.startXBA;
			limitStartYsBA = myParentBO.myParent.bot1.startYBA;
			limitStartXeBA = myParentBO.myParent.bot1.endXBA;
			limitStartYeBA = myParentBO.myParent.bot1.endYBA;
			dimLM = myParentBO.myParent.bot1.partDimM;
			dimLA = myParentBO.myParent.bot1.partDimA;

			newAlpha = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
					/ myParentBO.myParent.bOpeningObject.dimD0);

			if (myParentBO.myParent.bot1.partForm == 2)
			{
				inArchL = 1;
				limitStart = myParentBO.myParent.bot1Part;
			}

			if (myParentBO.myParent.bot1.partForm == 3)
			{
				inArchL = 3;
				limitStart = myParentBO.myParent.bot1Part;
			}
		}
		else if (myParentBO.bot2Part.posInUse && myParentBO.bot2Part.startYC >= myMullion.y1al
				&& myParentBO.bot2Part.endYC <= myMullion.y2cl)
		{
			limitStartXsA = myParentBO.myParent.bot2.startXA;
			limitStartYsA = myParentBO.myParent.bot2.startYA;
			limitStartXeA = myParentBO.myParent.bot2.endXA;
			limitStartYeA = myParentBO.myParent.bot2.endYA;
			limitStartXsBA = myParentBO.myParent.bot2.startXBA;
			limitStartYsBA = myParentBO.myParent.bot2.startYBA;
			limitStartXeBA = myParentBO.myParent.bot2.endXBA;
			limitStartYeBA = myParentBO.myParent.bot2.endYBA;
			dimLM = myParentBO.myParent.bot2.partDimM;
			dimLA = myParentBO.myParent.bot2.partDimA;
			newAlpha = Math.atan(myParentBO.myParent.bOpeningObject.dimC2
					/ myParentBO.myParent.bOpeningObject.dimD0);

		}

	}

	public void verifyLimitsRightOLD(final Profiles myMullion)
	{

		if (myMullion.y4al <= myParentBO.highestY + myParentBO.myParent.bOpeningObject.dimB1
				&& myParentBO.noSidesTop == 1 && myParentBO.myParent.bOpeningObject.dimB0 == 0
				&& myParentBO.myParent.bOpeningObject.dimB2 > 0 && !endIn && myParentBO.lean2 == 2)
		{
			limitEndXsA = myParentBO.myParent.top1.startXA;
			limitEndYsA = myParentBO.myParent.top1.startYA;
			limitEndXeA = myParentBO.myParent.top1.endXA;
			limitEndYeA = myParentBO.myParent.top1.endYA;
			limitEndXsBA = myParentBO.myParent.top1.startXBA;
			limitEndYsBA = myParentBO.myParent.top1.startYBA;
			limitEndXeBA = myParentBO.myParent.top1.endXBA;
			limitEndYeBA = myParentBO.myParent.top1.endYBA;
			dimRM = myParentBO.myParent.top1.partDimM;
			dimRA = myParentBO.myParent.top1.partDimA;
			limitEndBArchCenterX = myParentBO.myParent.top1.x1;
			limitEndBArchCenterY = myParentBO.myParent.top1.y1;
			myThetaRight = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
					/ myParentBO.myParent.bOpeningObject.dimB1);
			if (myParentBO.myParent.top1.partForm == 2)
			{
				inArchR = 1;
				limitEnd = myParentBO.myParent.top1Part;
			}
			else if (myParentBO.myParent.top1.partForm == 3)
			{
				inArchR = 3;
				limitEnd = myParentBO.myParent.top1Part;
			}

		}
		else if (myMullion.y4al <= myParentBO.myParent.top1.endYA

		&& myParentBO.noSidesTop == 1 && myParentBO.myParent.top1.partForm > 1 && !endIn)
		{
			limitEndXsA = myParentBO.myParent.top1.startXA;
			limitEndYsA = myParentBO.myParent.top1.startYA;
			limitEndXeA = myParentBO.myParent.top1.endXA;
			limitEndYeA = myParentBO.myParent.top1.endYA;
			limitEndXsBA = myParentBO.myParent.top1.startXBA;
			limitEndYsBA = myParentBO.myParent.top1.startYBA;
			limitEndXeBA = myParentBO.myParent.top1.endXBA;
			limitEndYeBA = myParentBO.myParent.top1.endYBA;
			dimRM = myParentBO.myParent.top1.partDimM;
			dimRA = myParentBO.myParent.top1.partDimA;
			limitEndBArchCenterX = myParentBO.myParent.top1.x1;
			limitEndBArchCenterY = myParentBO.myParent.top1.y1;
			myThetaRight = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
					/ myParentBO.myParent.bOpeningObject.dimB1);
			if (myParentBO.myParent.top1.partForm == 2)
			{
				inArchR = 1;
				limitEnd = myParentBO.myParent.top1Part;
			}
			else if (myParentBO.myParent.top1.partForm == 3)
			{
				inArchR = 3;
				limitEnd = myParentBO.myParent.top1Part;
			}

		}
		else if (myMullion.y4al <= myParentBO.highestY + myParentBO.myParent.bOpeningObject.dimB0
				&& myParentBO.noSidesTop == 1 && myParentBO.myParent.bOpeningObject.dimB0 > 0
				&& !endIn && myParentBO.lean2 == 3)
		{
			limitEndXsA = myParentBO.myParent.top1.startXA;
			limitEndYsA = myParentBO.myParent.top1.startYA;
			limitEndXeA = myParentBO.myParent.top1.endXA;
			limitEndYeA = myParentBO.myParent.top1.endYA;
			limitEndXsBA = myParentBO.myParent.top1.startXBA;
			limitEndYsBA = myParentBO.myParent.top1.startYBA;
			limitEndXeBA = myParentBO.myParent.top1.endXBA;
			limitEndYeBA = myParentBO.myParent.top1.endYBA;
			dimRM = myParentBO.myParent.top1.partDimM;
			dimRA = myParentBO.myParent.top1.partDimA;

			myThetaRight = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
					/ myParentBO.myParent.bOpeningObject.dimB0);

		}
		else if (myMullion.y4al <= myParentBO.highestY + myParentBO.myParent.bOpeningObject.dimB1
				&& myParentBO.noSidesTop > 1 && myParentBO.myParent.bOpeningObject.dimB0 == 0
				&& myParentBO.myParent.bOpeningObject.dimB2 > 0 && !endIn && myParentBO.lean2 == 2)
		{
			limitEndXsA = myParentBO.myParent.top2.startXA;
			limitEndYsA = myParentBO.myParent.top2.startYA;
			limitEndXeA = myParentBO.myParent.top2.endXA;
			limitEndYeA = myParentBO.myParent.top2.endYA;
			limitEndXsBA = myParentBO.myParent.top2.startXBA;
			limitEndYsBA = myParentBO.myParent.top2.startYBA;
			limitEndXeBA = myParentBO.myParent.top2.endXBA;
			limitEndYeBA = myParentBO.myParent.top2.endYBA;
			dimRM = myParentBO.myParent.top2.partDimM;
			dimRA = myParentBO.myParent.top2.partDimA;
			limitEndBArchCenterX = myParentBO.myParent.top2.x1;
			limitEndBArchCenterY = myParentBO.myParent.top2.y1;
			myThetaRight = Math.atan(myParentBO.myParent.bOpeningObject.dimA2
					/ myParentBO.myParent.bOpeningObject.dimB1);
			if (myParentBO.myParent.top2.partForm == 2)
			{
				inArchR = 1;
				limitEnd = myParentBO.myParent.top2Part;
			}

		}
		else if (myMullion.y4al <= myParentBO.highestY + myParentBO.myParent.bOpeningObject.dimB0
				&& myParentBO.noSidesTop > 1 && myParentBO.myParent.bOpeningObject.dimB0 > 0
				&& !endIn && myParentBO.lean2 == 3)
		{
			limitEndXsA = myParentBO.myParent.top2.startXA;
			limitEndYsA = myParentBO.myParent.top2.startYA;
			limitEndXeA = myParentBO.myParent.top2.endXA;
			limitEndYeA = myParentBO.myParent.top2.endYA;
			limitEndXsBA = myParentBO.myParent.top2.startXBA;
			limitEndYsBA = myParentBO.myParent.top2.startYBA;
			limitEndXeBA = myParentBO.myParent.top2.endXBA;
			limitEndYeBA = myParentBO.myParent.top2.endYBA;
			dimRM = myParentBO.myParent.top2.partDimM;
			dimRA = myParentBO.myParent.top2.partDimA;

			myThetaRight = Math.atan(myParentBO.myParent.bOpeningObject.dimA2
					/ myParentBO.myParent.bOpeningObject.dimB0);

		}
		// ////////////////////////

		else if (myMullion.y3cl >= myParentBO.highestY + myParentBO.myParent.bOpeningObject.dimB1
				&& myParentBO.noSidesBot == 1 && myParentBO.myParent.bOpeningObject.dimB0 == 0
				&& myParentBO.myParent.bOpeningObject.dimB1 > 0 && myParentBO.lean2 == 1
				&& myParentBO.myParent.bOpeningObject.dimB2 > 0 && !endIn)
		{
			limitEndXsA = myParentBO.myParent.bot1.startXA;
			limitEndYsA = myParentBO.myParent.bot1.startYA;
			limitEndXeA = myParentBO.myParent.bot1.endXA;
			limitEndYeA = myParentBO.myParent.bot1.endYA;
			limitEndXsBA = myParentBO.myParent.bot1.startXBA;
			limitEndYsBA = myParentBO.myParent.bot1.startYBA;
			limitEndXeBA = myParentBO.myParent.bot1.endXBA;
			limitEndYeBA = myParentBO.myParent.bot1.endYBA;
			dimRM = myParentBO.myParent.bot1.partDimM;
			dimRA = myParentBO.myParent.bot1.partDimA;
			limitEndBArchCenterX = myParentBO.myParent.bot1.x1;
			limitEndBArchCenterY = myParentBO.myParent.bot1.y1;
			myThetaRight = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
					/ myParentBO.myParent.bOpeningObject.dimB2);
			if (myParentBO.myParent.bot1.partForm == 2)
			{
				inArchR = 1;
				limitEnd = myParentBO.myParent.bot1Part;
			}
			if (myParentBO.myParent.bot1.partForm == 3)
			{
				inArchR = 3;
				limitEnd = myParentBO.myParent.bot1Part;
			}
		}
		else if (myMullion.y3cl >= myParentBO.highestY + myParentBO.myParent.bOpeningObject.dimB0
				+ myParentBO.myParent.bOpeningObject.dimB1
				&& myParentBO.noSidesBot == 1
				&& myParentBO.myParent.bOpeningObject.dimB0 > 0
				&& myParentBO.myParent.bOpeningObject.dimB2 > 0 && !endIn)
		{
			limitEndXsA = myParentBO.myParent.bot1.startXA;
			limitEndYsA = myParentBO.myParent.bot1.startYA;
			limitEndXeA = myParentBO.myParent.bot1.endXA;
			limitEndYeA = myParentBO.myParent.bot1.endYA;
			limitEndXsBA = myParentBO.myParent.bot1.startXBA;
			limitEndYsBA = myParentBO.myParent.bot1.startYBA;
			limitEndXeBA = myParentBO.myParent.bot1.endXBA;
			limitEndYeBA = myParentBO.myParent.bot1.endYBA;
			dimRM = myParentBO.myParent.bot1.partDimM;
			dimRA = myParentBO.myParent.bot1.partDimA;

			myThetaRight = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
					/ myParentBO.myParent.bOpeningObject.dimB2);

		}
		else if (myMullion.y3cl > myParentBO.highestY + myParentBO.myParent.bOpeningObject.dimB0
				+ myParentBO.myParent.bOpeningObject.dimB1
				&& myParentBO.noSidesBot > 1
				&& myParentBO.myParent.bOpeningObject.dimB0 > 0
				&& !endIn)
		{
			limitEndXsA = myParentBO.myParent.bot3.startXA;
			limitEndYsA = myParentBO.myParent.bot3.startYA;
			limitEndXeA = myParentBO.myParent.bot3.endXA;
			limitEndYeA = myParentBO.myParent.bot3.endYA;
			limitEndXsBA = myParentBO.myParent.bot3.startXBA;
			limitEndYsBA = myParentBO.myParent.bot3.startYBA;
			limitEndXeBA = myParentBO.myParent.bot3.endXBA;
			limitEndYeBA = myParentBO.myParent.bot3.endYBA;
			dimRM = myParentBO.myParent.bot3.partDimM;
			dimRA = myParentBO.myParent.bot3.partDimA;
			myThetaRight = Math.atan(myParentBO.myParent.bOpeningObject.dimC1
					/ myParentBO.myParent.bOpeningObject.dimB2);
		}
	}

	public void verifyLimitsRight(final Profiles myMullion)
	{

		if (myParentBO.top1Part.posInUse && myParentBO.top1Part.endYC >= myMullion.y1al
				&& myParentBO.top1Part.startYC <= myMullion.y2cl)
		{
			limitEndXsA = myParentBO.myParent.top1.startXA;
			limitEndYsA = myParentBO.myParent.top1.startYA;
			limitEndXeA = myParentBO.myParent.top1.endXA;
			limitEndYeA = myParentBO.myParent.top1.endYA;
			limitEndXsBA = myParentBO.myParent.top1.startXBA;
			limitEndYsBA = myParentBO.myParent.top1.startYBA;
			limitEndXeBA = myParentBO.myParent.top1.endXBA;
			limitEndYeBA = myParentBO.myParent.top1.endYBA;
			dimRM = myParentBO.myParent.top1.partDimM;
			dimRA = myParentBO.myParent.top1.partDimA;
			limitEndBArchCenterX = myParentBO.myParent.top1.x1;
			limitEndBArchCenterY = myParentBO.myParent.top1.y1;
			myThetaRight = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
					/ myParentBO.myParent.bOpeningObject.dimB1);

			if (myParentBO.myParent.top1.partForm == 2)
			{
				inArchR = 1;
				limitEnd = myParentBO.myParent.top1Part;
			}
			else if (myParentBO.myParent.top1.partForm == 3)
			{
				inArchR = 3;
				limitEnd = myParentBO.myParent.top1Part;
			}

		}

		if (myParentBO.top1Part.partForm > 1 && myParentBO.noSidesTop == 1
				&& myParentBO.top1Part.posInUse && myParentBO.top1Part.endYC >= myMullion.y2cl)
		{
			limitEndXsA = myParentBO.myParent.top1.startXA;
			limitEndYsA = myParentBO.myParent.top1.startYA;
			limitEndXeA = myParentBO.myParent.top1.endXA;
			limitEndYeA = myParentBO.myParent.top1.endYA;
			limitEndXsBA = myParentBO.myParent.top1.startXBA;
			limitEndYsBA = myParentBO.myParent.top1.startYBA;
			limitEndXeBA = myParentBO.myParent.top1.endXBA;
			limitEndYeBA = myParentBO.myParent.top1.endYBA;
			dimRM = myParentBO.myParent.top1.partDimM;
			dimRA = myParentBO.myParent.top1.partDimA;
			limitEndBArchCenterX = myParentBO.myParent.top1.x1;
			limitEndBArchCenterY = myParentBO.myParent.top1.y1;
			myThetaRight = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
					/ myParentBO.myParent.bOpeningObject.dimB1);
			if (myParentBO.myParent.top1.partForm == 2)
			{
				inArchR = 1;
				limitEnd = myParentBO.myParent.top1Part;
			}
			else if (myParentBO.myParent.top1.partForm == 3)
			{
				inArchR = 3;
				limitEnd = myParentBO.myParent.top1Part;
			}

		}
		else if (myParentBO.top2Part.posInUse && myParentBO.top2Part.startYC <= myMullion.y1al
				&& myParentBO.top2Part.endYC >= myMullion.y2cl)
		{
			limitEndXsA = myParentBO.myParent.top2.startXA;
			limitEndYsA = myParentBO.myParent.top2.startYA;
			limitEndXeA = myParentBO.myParent.top2.endXA;
			limitEndYeA = myParentBO.myParent.top2.endYA;
			limitEndXsBA = myParentBO.myParent.top2.startXBA;
			limitEndYsBA = myParentBO.myParent.top2.startYBA;
			limitEndXeBA = myParentBO.myParent.top2.endXBA;
			limitEndYeBA = myParentBO.myParent.top2.endYBA;
			dimRM = myParentBO.myParent.top2.partDimM;
			dimRA = myParentBO.myParent.top2.partDimA;
			limitEndBArchCenterX = myParentBO.myParent.top2.x1;
			limitEndBArchCenterY = myParentBO.myParent.top2.y1;
			myThetaRight = Math.atan(myParentBO.myParent.bOpeningObject.dimA2
					/ myParentBO.myParent.bOpeningObject.dimB1);
			if (myParentBO.myParent.top2.partForm == 2)
			{
				inArchR = 1;
				limitEnd = myParentBO.myParent.top2Part;
			}

		}

		// ////////////////////////

		else if (myParentBO.bot1Part.posInUse && myParentBO.bot1Part.startYC <= myMullion.y1al
				&& myParentBO.bot1Part.endYC >= myMullion.y2cl)
		{
			limitEndXsA = myParentBO.myParent.bot1.startXA;
			limitEndYsA = myParentBO.myParent.bot1.startYA;
			limitEndXeA = myParentBO.myParent.bot1.endXA;
			limitEndYeA = myParentBO.myParent.bot1.endYA;
			limitEndXsBA = myParentBO.myParent.bot1.startXBA;
			limitEndYsBA = myParentBO.myParent.bot1.startYBA;
			limitEndXeBA = myParentBO.myParent.bot1.endXBA;
			limitEndYeBA = myParentBO.myParent.bot1.endYBA;
			dimRM = myParentBO.myParent.bot1.partDimM;
			dimRA = myParentBO.myParent.bot1.partDimA;
			limitEndBArchCenterX = myParentBO.myParent.bot1.x1;
			limitEndBArchCenterY = myParentBO.myParent.bot1.y1;
			myThetaRight = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
					/ myParentBO.myParent.bOpeningObject.dimB2);
			if (myParentBO.myParent.bot1.partForm == 2)
			{
				inArchR = 1;
				limitEnd = myParentBO.myParent.bot1Part;
			}
			if (myParentBO.myParent.bot1.partForm == 3)
			{
				inArchR = 3;
				limitEnd = myParentBO.myParent.bot1Part;
			}
		}
		else if (myParentBO.bot1Part.partForm > 1 && myParentBO.noSidesBot == 1
				&& myParentBO.bot1Part.posInUse && myParentBO.bot1Part.startYC <= myMullion.y2cl)
		{
			limitEndXsA = myParentBO.myParent.bot1.startXA;
			limitEndYsA = myParentBO.myParent.bot1.startYA;
			limitEndXeA = myParentBO.myParent.bot1.endXA;
			limitEndYeA = myParentBO.myParent.bot1.endYA;
			limitEndXsBA = myParentBO.myParent.bot1.startXBA;
			limitEndYsBA = myParentBO.myParent.bot1.startYBA;
			limitEndXeBA = myParentBO.myParent.bot1.endXBA;
			limitEndYeBA = myParentBO.myParent.bot1.endYBA;
			dimRM = myParentBO.myParent.bot1.partDimM;
			dimRA = myParentBO.myParent.bot1.partDimA;
			limitEndBArchCenterX = myParentBO.myParent.bot1.x1;
			limitEndBArchCenterY = myParentBO.myParent.bot1.y1;
			myThetaRight = Math.atan(myParentBO.myParent.bOpeningObject.widthPix
					/ myParentBO.myParent.bOpeningObject.dimB2);
			if (myParentBO.myParent.bot1.partForm == 2)
			{
				inArchR = 1;
				limitEnd = myParentBO.myParent.bot1Part;
			}
			if (myParentBO.myParent.bot1.partForm == 3)
			{
				inArchR = 3;
				limitEnd = myParentBO.myParent.bot1Part;
			}
		}

	}

	public void verifyLimitLR(final Profiles myMullion)
	{

		this.getLimitingObjects(myMullion.startPos, myMullion.endPos, (Math.max(myMullion.y1al,
				myMullion.y4al) + Math.min(myMullion.y2cl, myMullion.y3cl)) / 2);

		myMullion.posCondition = posCondition;
		myMullion.leftIn = startIn;
		myMullion.rightIn = endIn;
		newAlpha = 0;//
		newAlpha2 = 0;
		newAlpha3 = 0;
		newAlphaA = 0;
		newAlphaC = 0;
		myThetaRight = 0;

		inArchL = 0;
		inArchR = 0;

		if (myParentBO.shapeID > 10)
		{

			if (!startIn)
			{
				verifyLlimitsLeft(myMullion);
			}

			// /////////////////////
			if (!endIn)
			{
				verifyLimitsRight(myMullion);
			}

			// //////////////////////////////////////////////////////////

			if (myParentBO.shapeID >= 700 && myParentBO.shapeID < 800)
			{
				verifyLimitsSpecialShapes(myMullion);
			}
		}
	}

	public void recalcVCCoords()
	{

		double x1 = 0;
		double x2 = 0;
		double x1al = 0;
		double x2cl = 0;
		double y1 = 0;
		double y2 = 0;
		double y1a3 = 0;
		double y2a3 = 0;
		double y1b = 0;
		double y2b = 0;
		double y1a = 0;
		double y2a = 0;
		double y1al = 0;
		double y2cl = 0;
		double centerXs = 0;
		double centerYs = 0;
		double ycs = 0;

		double x4 = 0;
		double x3 = 0;
		double x4al = 0;
		double x3cl = 0;
		double y4 = 0;
		double y3 = 0;
		double y4a3 = 0;
		double y3a3 = 0;
		double y4b = 0;
		double y3b = 0;
		double y4a = 0;
		double y3a = 0;
		double y4al = 0;
		double y3cl = 0;
		double centerXe = 0;
		double centerYe = 0;
		double yce = 0;
		myParentBO.mullionObjectsV = null;
		myParentBO.mullionObjectsV = myParentBO.mullions.toArray();
		myParentBO.mullions.clear();

		myParentBO.mullionObjectsH = null;
		myParentBO.mullionObjectsH = myParentBO.mullionsH.toArray();

		for (Object element : myParentBO.mullionObjectsV)
		{
			// this.getProfileDims((Profiles) element);
			x1al = ((Profiles) element).x1al;
			y1al = ((Profiles) element).y1al;
			x1 = ((Profiles) element).x1;
			y1 = ((Profiles) element).y1;
			centerXs = ((Profiles) element).centerXs;
			centerYs = ((Profiles) element).centerYs;
			x2 = ((Profiles) element).x2;
			y2 = ((Profiles) element).y2;

			y1a3 = ((Profiles) element).y1a3;
			y2a3 = ((Profiles) element).y2a3;
			y1b = ((Profiles) element).y1a3;
			y2b = ((Profiles) element).y2a3;
			y1a = ((Profiles) element).y1a;
			y2a = ((Profiles) element).y2a;
			ycs = ((Profiles) element).ycs;

			x2cl = ((Profiles) element).x2cl;
			y2cl = ((Profiles) element).y2cl;
			x4al = ((Profiles) element).x4al;
			y4al = ((Profiles) element).y4al;
			x4 = ((Profiles) element).x4;
			y4 = ((Profiles) element).y4;
			centerXe = ((Profiles) element).centerXe;
			centerYe = ((Profiles) element).centerYe;
			x3 = ((Profiles) element).x3;
			y3 = ((Profiles) element).y3;
			x3cl = ((Profiles) element).x3cl;
			y3cl = ((Profiles) element).y3cl;

			y4a3 = ((Profiles) element).y4a3;
			y3a3 = ((Profiles) element).y3a3;
			y4b = ((Profiles) element).y4a3;
			y3b = ((Profiles) element).y3a3;
			y4a = ((Profiles) element).y4a;
			y3a = ((Profiles) element).y3a;
			yce = ((Profiles) element).yce;

			for (final Object elementH : myParentBO.mullionObjectsH)
			{
				if (((Profiles) element).startPos > 1)
				{

					if (((Profiles) elementH).rowCol == ((Profiles) element).startPos - 1
							&& ((Profiles) elementH).startPos <= ((Profiles) element).rowCol
							&& ((Profiles) elementH).endPos > ((Profiles) element).rowCol)
					{
						if (setVcontinuity > 0)
						{
							((Profiles) element).continuity = 3;
						}

						y1b = y1a = this.intersectY(((Profiles) elementH).x1al,
								((Profiles) elementH).y1al, ((Profiles) elementH).x4al,
								((Profiles) elementH).y4al, ((Profiles) element).x1,
								((Profiles) element).y1, ((Profiles) element).x4,
								((Profiles) element).y4);
						y2a3 = this.intersectY(((Profiles) elementH).x1al,
								((Profiles) elementH).y1al, ((Profiles) elementH).x4al,
								((Profiles) elementH).y4al, ((Profiles) element).x2cl,
								((Profiles) element).y2cl, ((Profiles) element).x3cl,
								((Profiles) element).y3cl);

						y2b = y2a = this.intersectY(((Profiles) elementH).x1al,
								((Profiles) elementH).y1al, ((Profiles) elementH).x4al,
								((Profiles) elementH).y4al, ((Profiles) element).x2,
								((Profiles) element).y2, ((Profiles) element).x3,
								((Profiles) element).y3);
						ycs = this.intersectY(((Profiles) elementH).x1al,
								((Profiles) elementH).y1al, ((Profiles) elementH).x4al,
								((Profiles) elementH).y4al, ((Profiles) element).centerXs,
								((Profiles) element).centerYs, ((Profiles) element).centerXe,
								((Profiles) element).centerYe);

						if (((Profiles) element).endTypeLT == 3)
						{
							x1al = this.intersectX(((Profiles) elementH).x1,
									((Profiles) elementH).y1, ((Profiles) elementH).x4,
									((Profiles) elementH).y4, ((Profiles) element).x1al,
									((Profiles) element).y1al, ((Profiles) element).x4al,
									((Profiles) element).y4al);
							y1al = this.intersectY(((Profiles) elementH).x1,
									((Profiles) elementH).y1, ((Profiles) elementH).x4,
									((Profiles) elementH).y4, ((Profiles) element).x1al,
									((Profiles) element).y1al, ((Profiles) element).x4al,
									((Profiles) element).y4al);

							x1 = this.intersectX(((Profiles) elementH).x1,
									((Profiles) elementH).y1, ((Profiles) elementH).x4,
									((Profiles) elementH).y4, ((Profiles) element).x1,
									((Profiles) element).y1, ((Profiles) element).x4,
									((Profiles) element).y4);
							y1 = this.intersectY(((Profiles) elementH).x1,
									((Profiles) elementH).y1, ((Profiles) elementH).x4,
									((Profiles) elementH).y4, ((Profiles) element).x1,
									((Profiles) element).y1, ((Profiles) element).x4,
									((Profiles) element).y4);

							centerXs = this.intersectX(((Profiles) elementH).x1,
									((Profiles) elementH).y1, ((Profiles) elementH).x4,
									((Profiles) elementH).y4, ((Profiles) element).centerXs,
									((Profiles) element).centerYs, ((Profiles) element).centerXe,
									((Profiles) element).centerYe);
							centerYs = this.intersectY(((Profiles) elementH).x1,
									((Profiles) elementH).y1, ((Profiles) elementH).x4,
									((Profiles) elementH).y4, ((Profiles) element).centerXs,
									((Profiles) element).centerYs, ((Profiles) element).centerXe,
									((Profiles) element).centerYe);

							x2 = this.intersectX(((Profiles) elementH).x1,
									((Profiles) elementH).y1, ((Profiles) elementH).x4,
									((Profiles) elementH).y4, ((Profiles) element).x2,
									((Profiles) element).y2, ((Profiles) element).x3,
									((Profiles) element).y3);
							y2 = this.intersectY(((Profiles) elementH).x1,
									((Profiles) elementH).y1, ((Profiles) elementH).x4,
									((Profiles) elementH).y4, ((Profiles) element).x2,
									((Profiles) element).y2, ((Profiles) element).x3,
									((Profiles) element).y3);
							x2cl = this.intersectX(((Profiles) elementH).x1,
									((Profiles) elementH).y1, ((Profiles) elementH).x4,
									((Profiles) elementH).y4, ((Profiles) element).x2cl,
									((Profiles) element).y2cl, ((Profiles) element).x3cl,
									((Profiles) element).y3cl);
							y2cl = this.intersectY(((Profiles) elementH).x1,
									((Profiles) elementH).y1, ((Profiles) elementH).x4,
									((Profiles) elementH).y4, ((Profiles) element).x2cl,
									((Profiles) element).y2cl, ((Profiles) element).x3cl,
									((Profiles) element).y3cl);

						}
						else
						{

							x1al = this.intersectX(((Profiles) elementH).x1al,
									((Profiles) elementH).y1al, ((Profiles) elementH).x4al,
									((Profiles) elementH).y4al, ((Profiles) element).x1al,
									((Profiles) element).y1al, ((Profiles) element).x4al,
									((Profiles) element).y4al);
							y1al = this.intersectY(((Profiles) elementH).x1al,
									((Profiles) elementH).y1al, ((Profiles) elementH).x4al,
									((Profiles) elementH).y4al, ((Profiles) element).x1al,
									((Profiles) element).y1al, ((Profiles) element).x4al,
									((Profiles) element).y4al);

							centerXs = this.intersectX(((Profiles) elementH).x1,
									((Profiles) elementH).y1 - ((Profiles) elementH).partDimM,
									((Profiles) elementH).x4, ((Profiles) elementH).y4
											- ((Profiles) elementH).partDimM,
									((Profiles) element).centerXs, ((Profiles) element).centerYs,
									((Profiles) element).centerXe, ((Profiles) element).centerYe);
							centerYs = this.intersectY(((Profiles) elementH).x1,
									((Profiles) elementH).y1 - ((Profiles) elementH).partDimM,
									((Profiles) elementH).x4, ((Profiles) elementH).y4
											- ((Profiles) elementH).partDimM,
									((Profiles) element).centerXs, ((Profiles) element).centerYs,
									((Profiles) element).centerXe, ((Profiles) element).centerYe);

							x2cl = this.intersectX(((Profiles) elementH).x1al,
									((Profiles) elementH).y1al, ((Profiles) elementH).x4al,
									((Profiles) elementH).y4al, ((Profiles) element).x2cl,
									((Profiles) element).y2cl, ((Profiles) element).x3cl,
									((Profiles) element).y3cl);
							y2cl = this.intersectY(((Profiles) elementH).x1al,
									((Profiles) elementH).y1al, ((Profiles) elementH).x4al,
									((Profiles) elementH).y4al, ((Profiles) element).x2cl,
									((Profiles) element).y2cl, ((Profiles) element).x3cl,
									((Profiles) element).y3cl);

							x1 = this.intersectX(((Profiles) elementH).x1al,
									((Profiles) elementH).y1al, ((Profiles) elementH).x4al,
									((Profiles) elementH).y4al,
									((Profiles) element).x1, ((Profiles) element).y1,
									((Profiles) element).x4, ((Profiles) element).y4);
							y1 = this.intersectY(((Profiles) elementH).x1al,
									((Profiles) elementH).y1al, ((Profiles) elementH).x4al,
									((Profiles) elementH).y4al,
									((Profiles) element).x1, ((Profiles) element).y1,
									((Profiles) element).x4, ((Profiles) element).y4);

							x2 = this.intersectX(((Profiles) elementH).x1al,
									((Profiles) elementH).y1al, ((Profiles) elementH).x4al,
									((Profiles) elementH).y4al,
									((Profiles) element).x2, ((Profiles) element).y2,
									((Profiles) element).x3, ((Profiles) element).y3);
							y2 = this.intersectY(((Profiles) elementH).x1al,
									((Profiles) elementH).y1al, ((Profiles) elementH).x4al,
									((Profiles) elementH).y4al,
									((Profiles) element).x2, ((Profiles) element).y2,
									((Profiles) element).x3, ((Profiles) element).y3);

						}
						// break;
					}

				}
				if (((Profiles) element).endPos != myParentBO.yRows)
				{
					if (((Profiles) elementH).rowCol == ((Profiles) element).endPos
							&& ((Profiles) elementH).startPos <= ((Profiles) element).rowCol
							&& ((Profiles) elementH).endPos > ((Profiles) element).rowCol)
					{
						if (setVcontinuity > 0)
						{
							((Profiles) element).continuity = 3;
						}
						y4a3 = this.intersectY(((Profiles) elementH).x2cl,
								((Profiles) elementH).y2cl, ((Profiles) elementH).x3cl,
								((Profiles) elementH).y3cl, ((Profiles) element).x1al,
								((Profiles) element).y1al, ((Profiles) element).x4al,
								((Profiles) element).y4al);
						y4b = y4a = this.intersectY(((Profiles) elementH).x2cl,
								((Profiles) elementH).y2cl, ((Profiles) elementH).x3cl,
								((Profiles) elementH).y3cl, ((Profiles) element).x1,
								((Profiles) element).y1, ((Profiles) element).x4,
								((Profiles) element).y4);
						y3a3 = this.intersectY(((Profiles) elementH).x2cl,
								((Profiles) elementH).y2cl, ((Profiles) elementH).x3cl,
								((Profiles) elementH).y3cl, ((Profiles) element).x2cl,
								((Profiles) element).y2cl, ((Profiles) element).x3cl,
								((Profiles) element).y3cl);

						y3b = y3a = this.intersectY(((Profiles) elementH).x2cl,
								((Profiles) elementH).y2cl, ((Profiles) elementH).x3cl,
								((Profiles) elementH).y3cl, ((Profiles) element).x2,
								((Profiles) element).y2, ((Profiles) element).x3,
								((Profiles) element).y3);
						yce = this.intersectY(((Profiles) elementH).x2cl,
								((Profiles) elementH).y2cl, ((Profiles) elementH).x3cl,
								((Profiles) elementH).y3cl, ((Profiles) element).centerXs,
								((Profiles) element).centerYs, ((Profiles) element).centerXe,
								((Profiles) element).centerYe);

						if (((Profiles) element).endTypeRB == 3)
						{
							x4al = this.intersectX(((Profiles) elementH).x2,
									((Profiles) elementH).y2, ((Profiles) elementH).x3,
									((Profiles) elementH).y3, ((Profiles) element).x1al,
									((Profiles) element).y1al, ((Profiles) element).x4al,
									((Profiles) element).y4al);
							y4al = this.intersectY(((Profiles) elementH).x2,
									((Profiles) elementH).y2, ((Profiles) elementH).x3,
									((Profiles) elementH).y3, ((Profiles) element).x1al,
									((Profiles) element).y1al, ((Profiles) element).x4al,
									((Profiles) element).y4al);
							x4 = this.intersectX(((Profiles) elementH).x2,
									((Profiles) elementH).y2, ((Profiles) elementH).x3,
									((Profiles) elementH).y3, ((Profiles) element).x1,
									((Profiles) element).y1, ((Profiles) element).x4,
									((Profiles) element).y4);
							y4 = this.intersectY(((Profiles) elementH).x2,
									((Profiles) elementH).y2, ((Profiles) elementH).x3,
									((Profiles) elementH).y3, ((Profiles) element).x1,
									((Profiles) element).y1, ((Profiles) element).x4,
									((Profiles) element).y4);
							centerXe = this.intersectX(((Profiles) elementH).x2,
									((Profiles) elementH).y2, ((Profiles) elementH).x3,
									((Profiles) elementH).y3, ((Profiles) element).centerXs,
									((Profiles) element).centerYs, ((Profiles) element).centerXe,
									((Profiles) element).centerYe);
							centerYe = this.intersectY(((Profiles) elementH).x2,
									((Profiles) elementH).y2, ((Profiles) elementH).x3,
									((Profiles) elementH).y3, ((Profiles) element).centerXs,
									((Profiles) element).centerYs, ((Profiles) element).centerXe,
									((Profiles) element).centerYe);

							x3 = this.intersectX(((Profiles) elementH).x2,
									((Profiles) elementH).y2, ((Profiles) elementH).x3,
									((Profiles) elementH).y3, ((Profiles) element).x2,
									((Profiles) element).y2, ((Profiles) element).x3,
									((Profiles) element).y3);
							y3 = this.intersectY(((Profiles) elementH).x2,
									((Profiles) elementH).y2, ((Profiles) elementH).x3,
									((Profiles) elementH).y3, ((Profiles) element).x2,
									((Profiles) element).y2, ((Profiles) element).x3,
									((Profiles) element).y3);
							x3cl = this.intersectX(((Profiles) elementH).x2,
									((Profiles) elementH).y2, ((Profiles) elementH).x3,
									((Profiles) elementH).y3, ((Profiles) element).x2cl,
									((Profiles) element).y2cl, ((Profiles) element).x3cl,
									((Profiles) element).y3cl);
							y3cl = this.intersectY(((Profiles) elementH).x2,
									((Profiles) elementH).y2, ((Profiles) elementH).x3,
									((Profiles) elementH).y3, ((Profiles) element).x2cl,
									((Profiles) element).y2cl, ((Profiles) element).x3cl,
									((Profiles) element).y3cl);

						}
						else
						{
							x4al = this.intersectX(((Profiles) elementH).x2cl,
									((Profiles) elementH).y2cl, ((Profiles) elementH).x3cl,
									((Profiles) elementH).y3cl, ((Profiles) element).x1al,
									((Profiles) element).y1al, ((Profiles) element).x4al,
									((Profiles) element).y4al);
							y4al = this.intersectY(((Profiles) elementH).x2cl,
									((Profiles) elementH).y2cl, ((Profiles) elementH).x3cl,
									((Profiles) elementH).y3cl, ((Profiles) element).x1al,
									((Profiles) element).y1al, ((Profiles) element).x4al,
									((Profiles) element).y4al);

							centerXe = this.intersectX(((Profiles) elementH).x2,
									((Profiles) elementH).y2 + ((Profiles) elementH).partDimM,
									((Profiles) elementH).x3, ((Profiles) elementH).y3
											+ ((Profiles) elementH).partDimM,
									((Profiles) element).centerXs, ((Profiles) element).centerYs,
									((Profiles) element).centerXe, ((Profiles) element).centerYe);
							centerYe = this.intersectY(((Profiles) elementH).x2,
									((Profiles) elementH).y2 + ((Profiles) elementH).partDimM,
									((Profiles) elementH).x3, ((Profiles) elementH).y3
											+ ((Profiles) elementH).partDimM,
									((Profiles) element).centerXs, ((Profiles) element).centerYs,
									((Profiles) element).centerXe, ((Profiles) element).centerYe);

							x3cl = this.intersectX(((Profiles) elementH).x2cl,
									((Profiles) elementH).y2cl, ((Profiles) elementH).x3cl,
									((Profiles) elementH).y3cl, ((Profiles) element).x2cl,
									((Profiles) element).y2cl, ((Profiles) element).x3cl,
									((Profiles) element).y3cl);
							y3cl = this.intersectY(((Profiles) elementH).x2cl,
									((Profiles) elementH).y2cl, ((Profiles) elementH).x3cl,
									((Profiles) elementH).y3cl, ((Profiles) element).x2cl,
									((Profiles) element).y2cl, ((Profiles) element).x3cl,
									((Profiles) element).y3cl);

							x4 = this.intersectX(((Profiles) elementH).x2cl,
									((Profiles) elementH).y2cl, ((Profiles) elementH).x3cl,
									((Profiles) elementH).y3cl,
									((Profiles) element).x1, ((Profiles) element).y1,
									((Profiles) element).x4, ((Profiles) element).y4);
							y4 = this.intersectY(((Profiles) elementH).x2cl,
									((Profiles) elementH).y2cl, ((Profiles) elementH).x3cl,
									((Profiles) elementH).y3cl,
									((Profiles) element).x1, ((Profiles) element).y1,
									((Profiles) element).x4, ((Profiles) element).y4);

							x3 = this.intersectX(((Profiles) elementH).x2cl,
									((Profiles) elementH).y2cl, ((Profiles) elementH).x3cl,
									((Profiles) elementH).y3cl,
									((Profiles) element).x2, ((Profiles) element).y2,
									((Profiles) element).x3, ((Profiles) element).y3);
							y3 = this.intersectY(((Profiles) elementH).x2cl,
									((Profiles) elementH).y2cl, ((Profiles) elementH).x3cl,
									((Profiles) elementH).y3cl,
									((Profiles) element).x2, ((Profiles) element).y2,
									((Profiles) element).x3, ((Profiles) element).y3);

						}
						// break;
					}

				}
				((Profiles) element).notches.clear();

				element = this.reOrderVMNotches(((Profiles) element), ((Profiles) elementH));

			}

			((Profiles) element).x1al = x1al;
			((Profiles) element).y1al = y1al;
			((Profiles) element).x1 = x1;
			((Profiles) element).y1 = y1;
			((Profiles) element).centerXs = centerXs;
			((Profiles) element).centerYs = centerYs;
			((Profiles) element).x2 = x2;
			((Profiles) element).y2 = y2;
			((Profiles) element).x2cl = x2cl;
			((Profiles) element).y2cl = y2cl;

			((Profiles) element).x4al = x4al;
			((Profiles) element).y4al = y4al;
			((Profiles) element).x4 = x4;
			((Profiles) element).y4 = y4;
			((Profiles) element).centerXe = centerXe;
			((Profiles) element).centerYe = centerYe;
			((Profiles) element).x3 = x3;
			((Profiles) element).y3 = y3;
			((Profiles) element).x3cl = x3cl;
			((Profiles) element).y3cl = y3cl;

			((Profiles) element).finalVerify = false;

			((Profiles) element).y1a = y1al;
			((Profiles) element).y2a = y2cl;
			((Profiles) element).y3a = y3cl;
			((Profiles) element).y4a = y4al;

			((Profiles) element).y1a = y1a;
			((Profiles) element).y2a = y2a;
			((Profiles) element).y3a = y3a;
			((Profiles) element).y4a = y4a;

			((Profiles) element).y1a3 = y1a3;
			((Profiles) element).y2a3 = y2a3;
			((Profiles) element).y3a3 = y3a3;
			((Profiles) element).y4a3 = y4a3;
			((Profiles) element).y1b = y1b;
			((Profiles) element).y2b = y2b;
			((Profiles) element).y3b = y3b;
			((Profiles) element).y4b = y4b;

			((Profiles) element).ycs = ycs;
			((Profiles) element).yce = yce;

			((Profiles) element).length = ((Profiles) element).centerYe
					- ((Profiles) element).centerYs;
			((Profiles) element).myParent = myParentBO;

			element = recalcMullion(((Profiles) element));
			// myParentBO.mullionsH

			myParentBO.mullions.add(element);
		}// for Loop for V

	}

	@SuppressWarnings("unchecked")
	public Profiles reOrderVMNotches(final Profiles element, final Profiles elementH)
	{

		if (elementH.isValid)
		{
			if (element.rowCol == elementH.endPos && element.startPos <= elementH.rowCol
					&& element.endPos > elementH.rowCol)
			{
				if (elementH.endTypeRB >= 2)
				{
					if (myFrame2.jobItem.viewOut && !myParentBO.myParent.glazedOut
							|| !myFrame2.jobItem.viewOut && myParentBO.myParent.glazedOut)
					{
						notchVRB3VOGI(element, elementH);
					}
					else if (!myFrame2.jobItem.viewOut && myParentBO.myParent.glazedOut
							|| myFrame2.jobItem.viewOut && !myParentBO.myParent.glazedOut)
					{
						notchVRB3VIGI(element, elementH);
					}

				}
				else
				{
					final double notchx3 = this.intersectX(elementH.x3cl, elementH.y3cl,
							elementH.centerXe, elementH.centerYe, element.x1, element.y1,
							element.x4, element.y4);
					final double notchy3 = this.intersectY(elementH.x3cl, elementH.y3cl,
							elementH.centerXe, elementH.centerYe,

							element.x1, element.y1, element.x4, element.y4);
					final double notchx5 = this.intersectX(elementH.x4al, elementH.y4al,
							elementH.centerXe, elementH.centerYe, element.x1, element.y1,
							element.x4, element.y4);
					final double notchy5 = this.intersectY(elementH.x4al, elementH.y4al,
							elementH.centerXe, elementH.centerYe,

							element.x1, element.y1, element.x4, element.y4);

					element.notches.add(this.addNotching(4,

					false, false, false, false, false, false, false,
							false,

							1, // orientation
							elementH.rowCol,
							3, // left
							elementH.endTypeRB,

							elementH.x3cl, elementH.y3cl, elementH.x3, elementH.y3, notchx3,
							notchy3, elementH.centerXe, elementH.centerYe, notchx5, notchy5,
							elementH.x4, elementH.y4, elementH.x4al, elementH.y4al));

				}
			}
			else if (element.rowCol + 1 == elementH.startPos && element.startPos <= elementH.rowCol
					&& element.endPos > elementH.rowCol)
			{

				if (elementH.endTypeLT == 3)
				{
					if (myFrame2.jobItem.viewOut && !myParentBO.myParent.glazedOut
							|| !myFrame2.jobItem.viewOut && myParentBO.myParent.glazedOut)
					{
						notchVLT3VOGI(element, elementH);
					}
					else if (!myFrame2.jobItem.viewOut && myParentBO.myParent.glazedOut
							|| myFrame2.jobItem.viewOut && !myParentBO.myParent.glazedOut)
					{
						notchVLT3VIGI(element, elementH);
					}

				}
				else
				{
					final double notchx3 = this.intersectX(elementH.x2cl, elementH.y2cl,
							elementH.centerXs, elementH.centerYs, element.x2, element.y2,
							element.x3, element.y3);
					final double notchy3 = this.intersectY(elementH.x2cl, elementH.y2cl,
							elementH.centerXs, elementH.centerYs, element.x2, element.y2,
							element.x3, element.y3);
					final double notchx5 = this.intersectX(elementH.x1al, elementH.y1al,
							elementH.centerXs, elementH.centerYs, element.x2, element.y2,
							element.x3, element.y3);
					final double notchy5 = this.intersectY(elementH.x1al, elementH.y1al,
							elementH.centerXs, elementH.centerYs, element.x2, element.y2,
							element.x3, element.y3);

					element.notches.add(this.addNotching(4,

					false, false, false, false, false, false, false,
							false,

							1, // orientation
							elementH.rowCol,
							4, // R
							elementH.endTypeLT,

							elementH.x2cl, elementH.y2cl, elementH.x2, elementH.y2, notchx3,
							notchy3, elementH.centerXs, elementH.centerYs, notchx5, notchy5,
							elementH.x1, elementH.y1, elementH.x1al, elementH.y1al));

				}
			}
		}
		// myParent.doMullions(this.myParent);
		return element;
	}

	public void notchVLT3VIGI(final Profiles element, final Profiles elementH)
	{

		element.notches.add(this.addNotching(4,

		false, false, false, false, false, false, false, false,

		1, // Orientation
				elementH.rowCol, 4, // right
				elementH.endTypeLT,

				this.intersectX(element.x2cl, element.y2cl, element.x3cl, element.y3cl,
						elementH.x2cl, elementH.y2cl, elementH.x3cl, elementH.y3cl), this
						.intersectY(element.x2cl, element.y2cl, element.x3cl, element.y3cl,
								elementH.x2cl, elementH.y2cl, elementH.x3cl, elementH.y3cl),

				this.intersectX(element.x2, element.y2, element.x3, element.y3, elementH.x2cl,
						elementH.y2cl, elementH.x3cl, elementH.y3cl), this.intersectY(element.x2,
						element.y2, element.x3, element.y3, elementH.x2, elementH.y2, elementH.x3,
						elementH.y3),

				this.intersectX(element.x2, element.y2, element.x3, element.y3, elementH.x2cl,
						elementH.y2cl, elementH.x3cl, elementH.y3cl), this.intersectY(element.x2,
						element.y2, element.x3, element.y3, elementH.x2, elementH.y2, elementH.x3,
						elementH.y3),

				this.intersectX(element.x2, element.y2, element.x3, element.y3, elementH.centerXs,
						elementH.centerYs, elementH.centerXe, elementH.centerYe), this.intersectY(
						element.x2, element.y2, element.x3, element.y3, elementH.centerXs,
						elementH.centerYs, elementH.centerXe, elementH.centerYe),

				this.intersectX(element.x2, element.y2, element.x3, element.y3, elementH.x1,
						elementH.y1, elementH.x4, elementH.y4), this.intersectY(element.x2,
						element.y2, element.x3, element.y3, elementH.x1, elementH.y1, elementH.x4,
						elementH.y4),

				this.intersectX(element.x2, element.y2, element.x3, element.y3, elementH.x1al,
						elementH.y1al, elementH.x4al, elementH.y4al), this.intersectY(element.x2,
						element.y2, element.x3, element.y3, elementH.x1al, elementH.y1al,
						elementH.x4al, elementH.y4al),

				this.intersectX(element.x2cl, element.y2cl, element.x3cl, element.y3cl,
						elementH.x1al, elementH.y1al, elementH.x4al, elementH.y4al), this
						.intersectY(element.x2cl, element.y2cl, element.x3cl, element.y3cl,
								elementH.x1al, elementH.y1al, elementH.x4al, elementH.y4al)));
	}

	public void notchVLT3VOGI(final Profiles element, final Profiles elementH)
	{

		element.notches
				.add(this.addNotching(4,

				false, false, false, false, false, false, false,
						false,

						1, // Orientation
						elementH.rowCol,
						4, // right
						elementH.endTypeLT,

						this.intersectX(element.x2cl, element.y2cl, element.x3cl, element.y3cl,
								elementH.x2cl, elementH.y2cl, elementH.x3cl, elementH.y3cl),
						this.intersectY(element.x2cl, element.y2cl, element.x3cl, element.y3cl,
								elementH.x2cl, elementH.y2cl, elementH.x3cl, elementH.y3cl),

						this.intersectX(element.x2cl, element.y2cl, element.x3cl, element.y3cl,
								elementH.x2cl, elementH.y2cl, elementH.x3cl, elementH.y3cl), this
								.intersectY(element.x2cl, element.y2cl, element.x3cl, element.y3cl,
										elementH.x2, elementH.y2, elementH.x3, elementH.y3),

						this.intersectX(element.x2cl, element.y2cl, element.x3cl, element.y3cl,
								elementH.x2cl, elementH.y2cl, elementH.x3cl, elementH.y3cl), this
								.intersectY(element.x2cl, element.y2cl, element.x3cl, element.y3cl,
										elementH.x2, elementH.y2, elementH.x3, elementH.y3),

						this.intersectX(element.x2cl, element.y2cl, element.x3cl, element.y3cl,
								elementH.centerXs, elementH.centerYs, elementH.centerXe,
								elementH.centerYe), this.intersectY(element.x2cl, element.y2cl,
								element.x3cl, element.y3cl, elementH.centerXs, elementH.centerYs,
								elementH.centerXe, elementH.centerYe),

						this.intersectX(element.x2cl, element.y2cl, element.x3cl, element.y3cl,
								elementH.x1, elementH.y1, elementH.x4, elementH.y4), this
								.intersectY(element.x2cl, element.y2cl, element.x3cl, element.y3cl,
										elementH.x1, elementH.y1, elementH.x4, elementH.y4),

						this.intersectX(element.x2cl, element.y2cl, element.x3cl, element.y3cl,
								elementH.x1al, elementH.y1al, elementH.x4al, elementH.y4al),
						this.intersectY(element.x2cl, element.y2cl, element.x3cl, element.y3cl,
								elementH.x1al, elementH.y1al, elementH.x4al, elementH.y4al),

						this.intersectX(element.x2cl, element.y2cl, element.x3cl, element.y3cl,
								elementH.x1al, elementH.y1al, elementH.x4al, elementH.y4al), this
								.intersectY(element.x2cl, element.y2cl, element.x3cl, element.y3cl,
										elementH.x1al, elementH.y1al, elementH.x4al, elementH.y4al)));
	}

	public void notchVRB3VIGI(final Profiles element, final Profiles elementH)
	{

		element.notches.add(this.addNotching(4,

		false, false, false, false, false, false, false, false,

		1, // orientation
				elementH.rowCol, 3, // left
				elementH.endTypeRB,

				this.intersectX(element.x1al, element.y1al, element.x4al, element.y4al,
						elementH.x2cl, elementH.y2cl, elementH.x3cl, elementH.y3cl), this
						.intersectY(element.x1al, element.y1al, element.x4al, element.y4al,
								elementH.x2cl, elementH.y2cl, elementH.x3cl, elementH.y3cl),

				this.intersectX(element.x1, element.y1, element.x4, element.y4, elementH.x2cl,
						elementH.y2cl, elementH.x3cl, elementH.y3cl), this.intersectY(element.x1,
						element.y1, element.x4, element.y4, elementH.x2cl, elementH.y2cl,
						elementH.x3cl, elementH.y3cl),

				this.intersectX(element.x1, element.y1, element.x4, element.y4, elementH.x2,
						elementH.y2, elementH.x3, elementH.y3), this.intersectY(element.x1,
						element.y1, element.x4, element.y4, elementH.x2, elementH.y2, elementH.x3,
						elementH.y3),

				this.intersectX(element.x1, element.y1, element.x4, element.y4, elementH.centerXs,
						elementH.centerYs, elementH.centerXe, elementH.centerYe), this.intersectY(
						element.x1, element.y1, element.x4, element.y4, elementH.centerXs,
						elementH.centerYs, elementH.centerXe, elementH.centerYe),

				this.intersectX(element.x1, element.y1, element.x4, element.y4, elementH.x1,
						elementH.y1, elementH.x4, elementH.y4), this.intersectY(element.x1,
						element.y1, element.x4, element.y4, elementH.x1, elementH.y1, elementH.x4,
						elementH.y4),

				this.intersectX(element.x1, element.y1, element.x4, element.y4, elementH.x1al,
						elementH.y1al, elementH.x4al, elementH.y4al), this.intersectY(element.x1,
						element.y1, element.x4, element.y4, elementH.x1al, elementH.y1al,
						elementH.x4al, elementH.y4al),

				this.intersectX(element.x1al, element.y1al, element.x4al, element.y4al,
						elementH.x1al, elementH.y1al, elementH.x4al, elementH.y4al), this
						.intersectY(element.x1al, element.y1al, element.x4al, element.y4al,
								elementH.x1al, elementH.y1al, elementH.x4al, elementH.y4al)

		));
	}

	public void notchVRB3VOGI(final Profiles element, final Profiles elementH)
	{

		element.notches
				.add(this.addNotching(4,

				false, false, false,
						false,
						false,
						false,
						false,
						false,

						1, // orientation
						elementH.rowCol,
						3, // left
						elementH.endTypeRB,

						this.intersectX(element.x1al, element.y1al, element.x4al, element.y4al,
								elementH.x2cl, elementH.y2cl, elementH.x3cl, elementH.y3cl),
						this.intersectY(element.x1al, element.y1al, element.x4al, element.y4al,
								elementH.x2cl, elementH.y2cl, elementH.x3cl, elementH.y3cl),

						this.intersectX(element.x1al, element.y1al, element.x4al, element.y4al,
								elementH.x2cl, elementH.y2cl, elementH.x3cl, elementH.y3cl),
						this.intersectY(element.x1al, element.y1al, element.x4al, element.y4al,
								elementH.x2cl, elementH.y2cl, elementH.x3cl, elementH.y3cl),

						this.intersectX(element.x1al, element.y1al, element.x4al, element.y4al,
								elementH.x2, elementH.y2, elementH.x3, elementH.y3), this
								.intersectY(element.x1al, element.y1al, element.x4al, element.y4al,
										elementH.x2, elementH.y2, elementH.x3, elementH.y3),

						this.intersectX(element.x1al, element.y1al, element.x4al, element.y4al,
								elementH.centerXs, elementH.centerYs, elementH.centerXe,
								elementH.centerYe), this.intersectY(element.x1al, element.y1al,
								element.x4al, element.y4al, elementH.centerXs, elementH.centerYs,
								elementH.centerXe, elementH.centerYe),

						this.intersectX(element.x1al, element.y1al, element.x4al, element.y4al,
								elementH.x1, elementH.y1, elementH.x4, elementH.y4), this
								.intersectY(element.x1al, element.y1al, element.x4al, element.y4al,
										elementH.x1, elementH.y1, elementH.x4, elementH.y4),

						this.intersectX(element.x1al, element.y1al, element.x4al, element.y4al,
								elementH.x1al, elementH.y1al, elementH.x4al, elementH.y4al),
						this.intersectY(element.x1al, element.y1al, element.x4al, element.y4al,
								elementH.x1al, elementH.y1al, elementH.x4al, elementH.y4al),

						this.intersectX(element.x1al, element.y1al, element.x4al, element.y4al,
								elementH.x1al, elementH.y1al, elementH.x4al, elementH.y4al), this
								.intersectY(element.x1al, element.y1al, element.x4al, element.y4al,
										elementH.x1al, elementH.y1al, elementH.x4al, elementH.y4al)

				));
	}

	@SuppressWarnings("unchecked")
	public void reOrderHMNotches()
	{

		// if (this.myParent.mullionsH.size() > 0) {
		myParentBO.mullionObjectsH = null;
		myParentBO.mullionObjectsH = myParentBO.mullionsH.toArray();
		myParentBO.mullionsH.clear();
		// }

		myParentBO.mullionObjectsV = myParentBO.mullions.toArray();

		for (final Object element : myParentBO.mullionObjectsH)
		{
			// this.getProfileDims((Profiles) element);
			((Profiles) element).notches.clear();
			((Profiles) element).myParent = myParentBO;
			for (final Object element2 : myParentBO.mullionObjectsV)
			{
				if (((Profiles) element2).isValid)
				{
					if (((Profiles) element).rowCol == ((Profiles) element2).endPos
							&& ((Profiles) element).startPos <= ((Profiles) element2).rowCol
							&& ((Profiles) element).endPos > ((Profiles) element2).rowCol)
					{
						if (((Profiles) element2).endTypeRB >= 2)
						{
							if (myFrame2.jobItem.viewOut && !myParentBO.myParent.glazedOut
									|| !myFrame2.jobItem.viewOut && myParentBO.myParent.glazedOut)
							{
								this.notchHRB3ViewOut(element, element2);
							}
							else if (!myFrame2.jobItem.viewOut && myParentBO.myParent.glazedOut
									|| myFrame2.jobItem.viewOut && !myParentBO.myParent.glazedOut)
							{
								this.notchHRB3ViewIn(element, element2);
							}

						}
						else
						{
							final double notchx3 = this.intersectX(((Profiles) element2).x4al,
									((Profiles) element2).y4al, ((Profiles) element2).centerXe,
									((Profiles) element2).centerYe, ((Profiles) element).x2,
									((Profiles) element).y2, ((Profiles) element).x3,
									((Profiles) element).y3);
							final double notchy3 = this.intersectY(((Profiles) element2).x4al,
									((Profiles) element2).y4al, ((Profiles) element2).centerXe,
									((Profiles) element2).centerYe, ((Profiles) element).x2,
									((Profiles) element).y2, ((Profiles) element).x3,
									((Profiles) element).y3);
							final double notchx5 = this.intersectX(((Profiles) element2).x3cl,
									((Profiles) element2).y3cl, ((Profiles) element2).centerXe,
									((Profiles) element2).centerYe, ((Profiles) element).x2,
									((Profiles) element).y2, ((Profiles) element).x3,
									((Profiles) element).y3);
							final double notchy5 = this.intersectY(((Profiles) element2).x3cl,
									((Profiles) element2).y3cl, ((Profiles) element2).centerXe,
									((Profiles) element2).centerYe, ((Profiles) element).x2,
									((Profiles) element).y2, ((Profiles) element).x3,
									((Profiles) element).y3);

							((Profiles) element).notches.add(this.addNotching(4,

							false,
									false,
									false,
									false,
									false,
									false,
									false,
									false,

									2, // orientation
									((Profiles) element2).rowCol,
									1, // left
									((Profiles) element2).endTypeRB,

									((Profiles) element2).x4al, ((Profiles) element2).y4al,
									((Profiles) element2).x4, ((Profiles) element2).y4, notchx3,
									notchy3, ((Profiles) element2).centerXe,
									((Profiles) element2).centerYe, notchx5, notchy5,
									((Profiles) element2).x3, ((Profiles) element2).y3,
									((Profiles) element2).x3cl, ((Profiles) element2).y3cl));

						}
					}
					else if (((Profiles) element).rowCol + 1 == ((Profiles) element2).startPos
							&& ((Profiles) element).startPos <= ((Profiles) element2).rowCol
							&& ((Profiles) element).endPos > ((Profiles) element2).rowCol)
					{

						if (((Profiles) element2).endTypeLT >= 2)
						{

							if (myFrame2.jobItem.viewOut && !myParentBO.myParent.glazedOut
									|| !myFrame2.jobItem.viewOut && myParentBO.myParent.glazedOut)
							{
								notchHLT3ViewOut(element, element2);
							}
							else if (!myFrame2.jobItem.viewOut && myParentBO.myParent.glazedOut
									|| myFrame2.jobItem.viewOut && !myParentBO.myParent.glazedOut)
							{
								notchHLT3ViewIn(element, element2);
							}

						}
						else
						{
							final double notchx3 = this.intersectX(((Profiles) element2).x1al,
									((Profiles) element2).y1al, ((Profiles) element2).centerXs,
									((Profiles) element2).centerYs, ((Profiles) element).x1,
									((Profiles) element).y1, ((Profiles) element).x4,
									((Profiles) element).y4);
							final double notchy3 = this.intersectY(((Profiles) element2).x1al,
									((Profiles) element2).y1al, ((Profiles) element2).centerXs,
									((Profiles) element2).centerYs, ((Profiles) element).x1,
									((Profiles) element).y1, ((Profiles) element).x4,
									((Profiles) element).y4);
							final double notchx5 = this.intersectX(((Profiles) element2).x2cl,
									((Profiles) element2).y2cl, ((Profiles) element2).centerXs,
									((Profiles) element2).centerYs, ((Profiles) element).x1,
									((Profiles) element).y1, ((Profiles) element).x4,
									((Profiles) element).y4);
							final double notchy5 = this.intersectY(((Profiles) element2).x2cl,
									((Profiles) element2).y2cl, ((Profiles) element2).centerXs,
									((Profiles) element2).centerYs, ((Profiles) element).x1,
									((Profiles) element).y1, ((Profiles) element).x4,
									((Profiles) element).y4);

							((Profiles) element).notches.add(this.addNotching(4,

							false,
									false,
									false,
									false,
									false,
									false,
									false,
									false,

									2, // orientation
									((Profiles) element2).rowCol,
									2, // bot
									((Profiles) element2).endTypeLT,

									((Profiles) element2).x1al, ((Profiles) element2).y1al,
									((Profiles) element2).x1, ((Profiles) element2).y1, notchx3,
									notchy3, ((Profiles) element2).centerXs,
									((Profiles) element2).centerYs, notchx5, notchy5,
									((Profiles) element2).x2, ((Profiles) element2).y2,
									((Profiles) element2).x2cl, ((Profiles) element2).y2cl));

						}
					}
				}
			}
			((Profiles) element).myParent = myParentBO;
			myParentBO.mullionsH.add(element);
		}
		myParentBO = myParentBO.doMullions(this.myParentBO);
	}

	public void notchHLT3ViewIn(final Object element, final Object element2)
	{

		((Profiles) element).notches.add(this.addNotching(4,

		false, false, false, false, false,
				false,
				false,
				false,

				2, // orientation
				((Profiles) element2).rowCol,
				2, // Bot
				((Profiles) element2).endTypeLT,

				this.intersectX(((Profiles) element2).x1al, ((Profiles) element2).y1al,
						((Profiles) element2).x4al, ((Profiles) element2).y4al,
						((Profiles) element).x1al, ((Profiles) element).y1al,
						((Profiles) element).x4al, ((Profiles) element).y4al),
				//
				this.intersectY(((Profiles) element2).x1al, ((Profiles) element2).y1al,
						((Profiles) element2).x4al, ((Profiles) element2).y4al,
						((Profiles) element).x1al, ((Profiles) element).y1al,
						((Profiles) element).x4al, ((Profiles) element).y4al),
				//
				this.intersectX(((Profiles) element2).x1al, ((Profiles) element2).y1al,
						((Profiles) element2).x4al, ((Profiles) element2).y4al,
						((Profiles) element).x1, ((Profiles) element).y1, ((Profiles) element).x4,
						((Profiles) element).y4),
				//
				this.intersectY(((Profiles) element2).x1al, ((Profiles) element2).y1al,
						((Profiles) element2).x4al, ((Profiles) element2).y4al,
						((Profiles) element).x1, ((Profiles) element).y1, ((Profiles) element).x4,
						((Profiles) element).y4),
				//
				this.intersectX(((Profiles) element2).x1, ((Profiles) element2).y1,
						((Profiles) element2).x4, ((Profiles) element2).y4,
						((Profiles) element).x1, ((Profiles) element).y1, ((Profiles) element).x4,
						((Profiles) element).y4), this.intersectY(((Profiles) element2).x1,
						((Profiles) element2).y1, ((Profiles) element2).x4,
						((Profiles) element2).y4, ((Profiles) element).x1, ((Profiles) element).y1,
						((Profiles) element).x4, ((Profiles) element).y4),

				this.intersectX(((Profiles) element2).centerXs, ((Profiles) element2).centerYs,
						((Profiles) element2).centerXe, ((Profiles) element2).centerXe,
						((Profiles) element).x1, ((Profiles) element).y1, ((Profiles) element).x4,
						((Profiles) element).y4), this.intersectY(((Profiles) element2).centerXs,
						((Profiles) element2).centerYs, ((Profiles) element2).centerXe,
						((Profiles) element2).centerXe, ((Profiles) element).x1,
						((Profiles) element).y1, ((Profiles) element).x4, ((Profiles) element).y4),
				this.intersectX(((Profiles) element2).x2, ((Profiles) element2).y2,
						((Profiles) element2).x3, ((Profiles) element2).y3,
						((Profiles) element).x1, ((Profiles) element).y1, ((Profiles) element).x4,
						((Profiles) element).y4), this.intersectY(((Profiles) element2).x2,
						((Profiles) element2).y2, ((Profiles) element2).x3,
						((Profiles) element2).y3, ((Profiles) element).x1, ((Profiles) element).y1,
						((Profiles) element).x4, ((Profiles) element).y4), this.intersectX(
						((Profiles) element2).x2cl, ((Profiles) element2).y2cl,
						((Profiles) element2).x3cl, ((Profiles) element2).y3cl,
						((Profiles) element).x1, ((Profiles) element).y1, ((Profiles) element).x4,
						((Profiles) element).y4), this.intersectY(((Profiles) element2).x2cl,
						((Profiles) element2).y2cl, ((Profiles) element2).x3cl,
						((Profiles) element2).y3cl, ((Profiles) element).x1,
						((Profiles) element).y1, ((Profiles) element).x4, ((Profiles) element).y4),
				this.intersectX(((Profiles) element2).x2cl, ((Profiles) element2).y2cl,
						((Profiles) element2).x3cl, ((Profiles) element2).y3cl,
						((Profiles) element).x1al, ((Profiles) element).y1al,
						((Profiles) element).x4al, ((Profiles) element).y4al), this.intersectY(
						((Profiles) element2).x2cl, ((Profiles) element2).y2cl,
						((Profiles) element2).x3cl, ((Profiles) element2).y3cl,
						((Profiles) element).x1al, ((Profiles) element).y1al,
						((Profiles) element).x4al, ((Profiles) element).y4al)));
	}

	public void notchHLT3ViewOut(final Object element, final Object element2)
	{

		((Profiles) element).notches.add(this.addNotching(4,

		false, false, false, false, false, false, false, false,

		2, // orientation
				((Profiles) element2).rowCol, 2, // Bot
				((Profiles) element2).endTypeLT,

				this.intersectX(((Profiles) element2).x1al, ((Profiles) element2).y1al,
						((Profiles) element2).x4al, ((Profiles) element2).y4al,
						((Profiles) element).x1al, ((Profiles) element).y1al,
						((Profiles) element).x4al, ((Profiles) element).y4al),
				//
				this.intersectY(((Profiles) element2).x1al, ((Profiles) element2).y1al,
						((Profiles) element2).x4al, ((Profiles) element2).y4al,
						((Profiles) element).x1al, ((Profiles) element).y1al,
						((Profiles) element).x4al, ((Profiles) element).y4al),
				//
				this.intersectX(((Profiles) element2).x1al, ((Profiles) element2).y1al,
						((Profiles) element2).x4al, ((Profiles) element2).y4al,
						((Profiles) element).x1al, ((Profiles) element).y1al,
						((Profiles) element).x4al, ((Profiles) element).y4al),
				//
				this.intersectY(((Profiles) element2).x1al, ((Profiles) element2).y1al,
						((Profiles) element2).x4al, ((Profiles) element2).y4al,
						((Profiles) element).x1al, ((Profiles) element).y1al,
						((Profiles) element).x4al, ((Profiles) element).y4al),
				//
				this.intersectX(((Profiles) element2).x1, ((Profiles) element2).y1,
						((Profiles) element2).x4, ((Profiles) element2).y4,
						((Profiles) element).x1al, ((Profiles) element).y1al,
						((Profiles) element).x4al, ((Profiles) element).y4al), this.intersectY(
						((Profiles) element2).x1, ((Profiles) element2).y1,
						((Profiles) element2).x4, ((Profiles) element2).y4,
						((Profiles) element).x1al, ((Profiles) element).y1al,
						((Profiles) element).x4al, ((Profiles) element).y4al),

				this.intersectX(((Profiles) element2).centerXs, ((Profiles) element2).centerYs,
						((Profiles) element2).centerXe, ((Profiles) element2).centerXe,
						((Profiles) element).x1al, ((Profiles) element).y1al,
						((Profiles) element).x4al, ((Profiles) element).y4al), this.intersectY(
						((Profiles) element2).centerXs, ((Profiles) element2).centerYs,
						((Profiles) element2).centerXe, ((Profiles) element2).centerXe,
						((Profiles) element).x1al, ((Profiles) element).y1al,
						((Profiles) element).x4al, ((Profiles) element).y4al), this.intersectX(
						((Profiles) element2).x2, ((Profiles) element2).y2,
						((Profiles) element2).x3, ((Profiles) element2).y3,
						((Profiles) element).x1al, ((Profiles) element).y1al,
						((Profiles) element).x4al, ((Profiles) element).y4al), this.intersectY(
						((Profiles) element2).x2, ((Profiles) element2).y2,
						((Profiles) element2).x3, ((Profiles) element2).y3,
						((Profiles) element).x1al, ((Profiles) element).y1al,
						((Profiles) element).x4al, ((Profiles) element).y4al), this.intersectX(
						((Profiles) element2).x2cl, ((Profiles) element2).y2cl,
						((Profiles) element2).x3cl, ((Profiles) element2).y3cl,
						((Profiles) element).x1al, ((Profiles) element).y1al,
						((Profiles) element).x4al, ((Profiles) element).y4al), this.intersectY(
						((Profiles) element2).x2cl, ((Profiles) element2).y2cl,
						((Profiles) element2).x3cl, ((Profiles) element2).y3cl,
						((Profiles) element).x1al, ((Profiles) element).y1al,
						((Profiles) element).x4al, ((Profiles) element).y4al), this.intersectX(
						((Profiles) element2).x2cl, ((Profiles) element2).y2cl,
						((Profiles) element2).x3cl, ((Profiles) element2).y3cl,
						((Profiles) element).x1al, ((Profiles) element).y1al,
						((Profiles) element).x4al, ((Profiles) element).y4al), this.intersectY(
						((Profiles) element2).x2cl, ((Profiles) element2).y2cl,
						((Profiles) element2).x3cl, ((Profiles) element2).y3cl,
						((Profiles) element).x1al, ((Profiles) element).y1al,
						((Profiles) element).x4al, ((Profiles) element).y4al)));
	}

	public void notchHRB3ViewIn(final Object element, final Object element2)
	{

		((Profiles) element).notches.add(this.addNotching(4,

		false, false, false, false, false,
				false,
				false,
				false,

				2, // orientation
				((Profiles) element2).rowCol,
				1, // left
				((Profiles) element2).endTypeRB,

				this.intersectX(((Profiles) element2).x1al, ((Profiles) element2).y1al,
						((Profiles) element2).x4al, ((Profiles) element2).y4al,
						((Profiles) element).x2cl, ((Profiles) element).y2cl,
						((Profiles) element).x3cl, ((Profiles) element).y3cl),
				//
				this.intersectY(((Profiles) element2).x1al, ((Profiles) element2).y1al,
						((Profiles) element2).x4al, ((Profiles) element2).y4al,
						((Profiles) element).x2cl, ((Profiles) element).y2cl,
						((Profiles) element).x3cl, ((Profiles) element).y3cl),
				//
				this.intersectX(((Profiles) element2).x1al, ((Profiles) element2).y1al,
						((Profiles) element2).x4al, ((Profiles) element2).y4al,
						((Profiles) element).x2, ((Profiles) element).y2, ((Profiles) element).x3,
						((Profiles) element).y3),
				//
				this.intersectY(((Profiles) element2).x1al, ((Profiles) element2).y1al,
						((Profiles) element2).x4al, ((Profiles) element2).y4al,
						((Profiles) element).x2, ((Profiles) element).y2, ((Profiles) element).x3,
						((Profiles) element).y3),
				//
				this.intersectX(((Profiles) element2).x1, ((Profiles) element2).y1,
						((Profiles) element2).x4, ((Profiles) element2).y4,
						((Profiles) element).x2, ((Profiles) element).y2, ((Profiles) element).x3,
						((Profiles) element).y3), this.intersectY(((Profiles) element2).x1,
						((Profiles) element2).y1, ((Profiles) element2).x4,
						((Profiles) element2).y4, ((Profiles) element).x2, ((Profiles) element).y2,
						((Profiles) element).x3, ((Profiles) element).y3),

				this.intersectX(((Profiles) element2).centerXs, ((Profiles) element2).centerYs,
						((Profiles) element2).centerXe, ((Profiles) element2).centerXe,
						((Profiles) element).x2, ((Profiles) element).y2, ((Profiles) element).x3,
						((Profiles) element).y3), this.intersectY(((Profiles) element2).centerXs,
						((Profiles) element2).centerYs, ((Profiles) element2).centerXe,
						((Profiles) element2).centerXe, ((Profiles) element).x2,
						((Profiles) element).y2, ((Profiles) element).x3, ((Profiles) element).y3),
				this.intersectX(((Profiles) element2).x2, ((Profiles) element2).y2,
						((Profiles) element2).x3, ((Profiles) element2).y3,
						((Profiles) element).x2, ((Profiles) element).y2, ((Profiles) element).x3,
						((Profiles) element).y3), this.intersectY(((Profiles) element2).x2,
						((Profiles) element2).y2, ((Profiles) element2).x3,
						((Profiles) element2).y3, ((Profiles) element).x2, ((Profiles) element).y2,
						((Profiles) element).x3, ((Profiles) element).y3), this.intersectX(
						((Profiles) element2).x2cl, ((Profiles) element2).y2cl,
						((Profiles) element2).x3cl, ((Profiles) element2).y3cl,
						((Profiles) element).x2, ((Profiles) element).y2, ((Profiles) element).x3,
						((Profiles) element).y3), this.intersectY(((Profiles) element2).x2cl,
						((Profiles) element2).y2cl, ((Profiles) element2).x3cl,
						((Profiles) element2).y3cl, ((Profiles) element).x2,
						((Profiles) element).y2, ((Profiles) element).x3, ((Profiles) element).y3),
				this.intersectX(((Profiles) element2).x2cl, ((Profiles) element2).y2cl,
						((Profiles) element2).x3cl, ((Profiles) element2).y3cl,
						((Profiles) element).x2cl, ((Profiles) element).y2cl,
						((Profiles) element).x3cl, ((Profiles) element).y3cl), this.intersectY(
						((Profiles) element2).x2cl, ((Profiles) element2).y2cl,
						((Profiles) element2).x3cl, ((Profiles) element2).y3cl,
						((Profiles) element).x2cl, ((Profiles) element).y2cl,
						((Profiles) element).x3cl, ((Profiles) element).y3cl)));
	}

	public void notchHRB3ViewOut(

	final Object element, final Object element2)
	{

		((Profiles) element).notches.add(this.addNotching(4,

		false, false, false, false, false, false, false, false,

		2, // orientation
				((Profiles) element2).rowCol, 1, // left
				((Profiles) element2).endTypeRB,

				this.intersectX(((Profiles) element2).x1al, ((Profiles) element2).y1al,
						((Profiles) element2).x4al, ((Profiles) element2).y4al,
						((Profiles) element).x2cl, ((Profiles) element).y2cl,
						((Profiles) element).x3cl, ((Profiles) element).y3cl),
				//
				this.intersectY(((Profiles) element2).x1al, ((Profiles) element2).y1al,
						((Profiles) element2).x4al, ((Profiles) element2).y4al,
						((Profiles) element).x2cl, ((Profiles) element).y2cl,
						((Profiles) element).x3cl, ((Profiles) element).y3cl),
				//
				this.intersectX(((Profiles) element2).x1al, ((Profiles) element2).y1al,
						((Profiles) element2).x4al, ((Profiles) element2).y4al,
						((Profiles) element).x2cl, ((Profiles) element).y2cl,
						((Profiles) element).x3cl, ((Profiles) element).y3cl),
				//
				this.intersectY(((Profiles) element2).x1al, ((Profiles) element2).y1al,
						((Profiles) element2).x4al, ((Profiles) element2).y4al,
						((Profiles) element).x2cl, ((Profiles) element).y2cl,
						((Profiles) element).x3cl, ((Profiles) element).y3cl),
				//
				this.intersectX(((Profiles) element2).x1, ((Profiles) element2).y1,
						((Profiles) element2).x4, ((Profiles) element2).y4,
						((Profiles) element).x2cl, ((Profiles) element).y2cl,
						((Profiles) element).x3cl, ((Profiles) element).y3cl), this.intersectY(
						((Profiles) element2).x1, ((Profiles) element2).y1,
						((Profiles) element2).x4, ((Profiles) element2).y4,
						((Profiles) element).x2cl, ((Profiles) element).y2cl,
						((Profiles) element).x3cl, ((Profiles) element).y3cl),

				this.intersectX(((Profiles) element2).centerXs, ((Profiles) element2).centerYs,
						((Profiles) element2).centerXe, ((Profiles) element2).centerXe,
						((Profiles) element).x2cl, ((Profiles) element).y2cl,
						((Profiles) element).x3cl, ((Profiles) element).y3cl), this.intersectY(
						((Profiles) element2).centerXs, ((Profiles) element2).centerYs,
						((Profiles) element2).centerXe, ((Profiles) element2).centerXe,
						((Profiles) element).x2cl, ((Profiles) element).y2cl,
						((Profiles) element).x3cl, ((Profiles) element).y3cl), this.intersectX(
						((Profiles) element2).x2, ((Profiles) element2).y2,
						((Profiles) element2).x3, ((Profiles) element2).y3,
						((Profiles) element).x2cl, ((Profiles) element).y2cl,
						((Profiles) element).x3cl, ((Profiles) element).y3cl), this.intersectY(
						((Profiles) element2).x2, ((Profiles) element2).y2,
						((Profiles) element2).x3, ((Profiles) element2).y3,
						((Profiles) element).x2cl, ((Profiles) element).y2cl,
						((Profiles) element).x3cl, ((Profiles) element).y3cl), this.intersectX(
						((Profiles) element2).x2cl, ((Profiles) element2).y2cl,
						((Profiles) element2).x3cl, ((Profiles) element2).y3cl,
						((Profiles) element).x2cl, ((Profiles) element).y2cl,
						((Profiles) element).x3cl, ((Profiles) element).y3cl), this.intersectY(
						((Profiles) element2).x2cl, ((Profiles) element2).y2cl,
						((Profiles) element2).x3cl, ((Profiles) element2).y3cl,
						((Profiles) element).x2cl, ((Profiles) element).y2cl,
						((Profiles) element).x3cl, ((Profiles) element).y3cl), this.intersectX(
						((Profiles) element2).x2cl, ((Profiles) element2).y2cl,
						((Profiles) element2).x3cl, ((Profiles) element2).y3cl,
						((Profiles) element).x2cl, ((Profiles) element).y2cl,
						((Profiles) element).x3cl, ((Profiles) element).y3cl), this.intersectY(
						((Profiles) element2).x2cl, ((Profiles) element2).y2cl,
						((Profiles) element2).x3cl, ((Profiles) element2).y3cl,
						((Profiles) element).x2cl, ((Profiles) element).y2cl,
						((Profiles) element).x3cl, ((Profiles) element).y3cl)));
	}

	private void addMullionHAtPos(final int x, final int y, final int assemblyL)
	{

		// Get thickness from Rules
		myParentBO.mullionObjectsH = null;
		myParentBO.mullionObjectsH = myParentBO.mullionsH.toArray();
		myParentBO.mullionsH.clear();

		for (final Object element : myParentBO.mullionObjectsH)
		{
			if (((Profiles) element).rowCol < newHCRow)
			{
				((Profiles) element).isNew = false;
				myParentBO.mullionsH.add(element);
			}
			if (((Profiles) element).rowCol == newHCRow && ((Profiles) element).endPos < hcStart)
			{
				((Profiles) element).isNew = false;
				myParentBO.mullionsH.add(element);
			}

		}

		myParentBO.mullionH = new Profiles(myParentBO, hcStart, hcEnd, 2, hcStartX, hcEndX, 0, 0, 0, myFrame2);
				
		myParentBO.mullionH = this.getProfileDims(myParentBO.mullionH);

		myParentBO.mullionH.a_assemblyLevel = assemblyL;

		myParentBO.mullionH.partID = this.partID;
		myParentBO.mullionH.a_levelID = 4;
		myParentBO.mullionH.a_1Level = myParentBO.a_assemblyLevel;
		myParentBO.mullionH.a_1Sequence = myParentBO.a_sequenceID;
		myParentBO.mullionH.a_2Level = myParentBO.a_1Level;
		myParentBO.mullionH.a_2Sequence = myParentBO.a_1Sequence;
		myParentBO.mullionH.a_3Level = myParentBO.a_2Level;
		myParentBO.mullionH.a_3Sequence = myParentBO.a_2Sequence;
		myParentBO.mullionH.a_4Level = myParentBO.a_3Level;
		myParentBO.mullionH.a_4Sequence = myParentBO.a_3Sequence;

		myParentBO.mullionH.a_5Level = myParentBO.a_4Level;
		myParentBO.mullionH.a_5Sequence = myParentBO.a_4Sequence;
		myParentBO.mullionH.a_6Level = myParentBO.a_5Level;
		myParentBO.mullionH.a_6Sequence = myParentBO.a_5Sequence;
		myParentBO.mullionH.a_7Level = myParentBO.a_6Level;
		myParentBO.mullionH.a_7Sequence = myParentBO.a_6Sequence;
		myParentBO.mullionH.a_8Level = myParentBO.a_7Level;
		myParentBO.mullionH.a_8Sequence = myParentBO.a_7Sequence;
		myParentBO.mullionH.a_9Level = myParentBO.a_8Level;
		myParentBO.mullionH.a_9Sequence = myParentBO.a_8Sequence;
		myParentBO.mullionH.a_10Level = myParentBO.a_9Level;
		myParentBO.mullionH.a_10Sequence = myParentBO.a_9Sequence;

		myParentBO.mullionH.a_11Level = myParentBO.a_10Level;
		myParentBO.mullionH.a_11Sequence = myParentBO.a_10Sequence;
		myParentBO.mullionH.a_12Level = myParentBO.a_11Level;
		myParentBO.mullionH.a_12Sequence = myParentBO.a_11Sequence;
		myParentBO.mullionH.a_13Level = myParentBO.a_12Level;
		myParentBO.mullionH.a_13Sequence = myParentBO.a_12Sequence;
		myParentBO.mullionH.a_14Level = myParentBO.a_13Level;
		myParentBO.mullionH.a_14Sequence = myParentBO.a_13Sequence;

		myParentBO.mullionH.a_15Level = myParentBO.a_14Level;
		myParentBO.mullionH.a_15Sequence = myParentBO.a_14Sequence;
		myParentBO.mullionH.a_16Level = myParentBO.a_15Level;
		myParentBO.mullionH.a_16Sequence = myParentBO.a_15Sequence;
		myParentBO.mullionH.a_17Level = myParentBO.a_16Level;
		myParentBO.mullionH.a_17Sequence = myParentBO.a_16Sequence;
		myParentBO.mullionH.a_18Level = myParentBO.a_17Level;
		myParentBO.mullionH.a_18Sequence = myParentBO.a_17Sequence;
		myParentBO.mullionH.a_19Level = myParentBO.a_18Level;
		myParentBO.mullionH.a_19Sequence = myParentBO.a_18Sequence;
		myParentBO.mullionH.a_20Level = myParentBO.a_19Level;
		myParentBO.mullionH.a_20Sequence = myParentBO.a_19Sequence;
		myParentBO.mullionH.a_21Level = myParentBO.a_20Level;
		myParentBO.mullionH.a_21Sequence = myParentBO.a_20Sequence;
		myParentBO.mullionH.a_22Level = myParentBO.a_21Level;
		myParentBO.mullionH.a_22Sequence = myParentBO.a_21Sequence;
		
		myParentBO.mullionH.exists = alreadyExist;
		myParentBO.mullionH.fixedAngle = fixedAngle;
		myParentBO.mullionH.angle = angle;
		myParentBO.mullionH.phantom = phantom;
		myParentBO.mullionH.divideFacet = myFrame2.mullionsPanel.divideFacet;
		myParentBO.mullionH.order = 1;// this.getLastInputOrder();
		myParentBO.mullionH.cOrM = cOrM;
		myParentBO.mullionH.rowCol = newHCRow;
		myParentBO.mullionH.a_sequenceID = newHCRow;
		myParentBO.mullionH.startPos = hcStart;
		myParentBO.mullionH.endPos = hcEnd;
		myParentBO.mullionH.x1 = x;
		myParentBO.mullionH.x2 = x;
		myParentBO.mullionH.x3 = x;
		myParentBO.mullionH.x4 = x;
		myParentBO.mullionH.x1al = x;
		myParentBO.mullionH.x2cl = x;
		myParentBO.mullionH.x3cl = x;
		myParentBO.mullionH.x4al = x;
		myParentBO.mullionH.centerXs = x;
		myParentBO.mullionH.centerXe = x;

		myParentBO.mullionH.posCondition = posCondition;
		myParentBO.mullionH.continuity = continuity;
		myParentBO.mullionH.mType = mType;

		myParentBO.mullionH.typeID = typeID;

		myParentBO.mullionH.whichPos = whichPos;

		myParentBO.mullionH.partForm = 1;
		myParentBO.mullionH.offsetTL = 0;
		myParentBO.mullionH.offsetRB = 0;
		myParentBO.mullionH.deltaTL = 0;// this.myParentBO.openingW

		myParentBO.mullionH.deltaRB = 0;// this.myParentBO.openingW
		// / 3;
		myParentBO.mullionH.curveCenterTL = 0;// this.myParentBO.openingW
		// / 2;
		myParentBO.mullionH.curveCenterRB = 0;// this.myParentBO.openingW
		// / 2;
		myParentBO.mullionH.isNew = true;
		
		myParentBO.mullionH.udControlOpeningID = myParentBO.myOpeningID;
		
		myParentBO.mullionH.openingClass = myParentBO.openingClass;
		

		if (alreadyExist == 2)
		{

			myParentBO.mullionH.y1 = this.hcY1;

			myParentBO.mullionH.y2 = hcY2;

			myParentBO.mullionH.y3 = hcY3;

			myParentBO.mullionH.y4 = hcY4;

			myParentBO.mullionH.centerYs = this.hcY1;

			myParentBO.mullionH.centerYe = hcY4;

		}

		myParentBO.mullionH.executeRulesMethod("AddMullionH.addMullionHAtPos line 5310");
		
		myParentBO.mullionH.setMullionColor();

		myParentBO.mullionH.bom.clear();
		myParentBO.mullionH.clearBomForProfile();
		
		myParentBO.mullionH  = ((Profiles) myParentBO.mullionH ).executePartRules(false);
		
		if (cOrM > 2)
		{

			myParentBO.mullionH.endTypeLT = 3;
			myParentBO.mullionH.endTypeRB = 3;

		}

		if (myFrame2.mySeries.getSeriesUom() == 1)
		{
			thickness = myParentBO.mullionH.partDimB;
			partDimC = myParentBO.mullionH.partDimC;
			partDimA = myParentBO.mullionH.partDimA;
			partDimB = myParentBO.mullionH.partDimB;
			partDimD = myParentBO.mullionH.partDimD;
			partDimBtoC = myParentBO.mullionH.partDimBtoC;
			partDimM = myParentBO.mullionH.partDimM;
		}
		else
		{
			thickness = myParentBO.mullionH.partDimBi;
			partDimC = myParentBO.mullionH.partDimCi;
			partDimA = myParentBO.mullionH.partDimAi;
			partDimB = myParentBO.mullionH.partDimBi;
			partDimD = myParentBO.mullionH.partDimDi;
			partDimBtoC = myParentBO.mullionH.partDimBtoCi;
			partDimM = myParentBO.mullionH.partDimMi;
		}

		myParentBO.mullionsH.add(myParentBO.mullionH);

		for (final Object element : myParentBO.mullionObjectsH)
		{

			if (((Profiles) element).rowCol == newHCRow && ((Profiles) element).startPos > hcEnd)
			{
				((Profiles) element).isNew = false;
				myParentBO.mullionsH.add(element);
			}
			if (((Profiles) element).rowCol > newHCRow)
			{
				((Profiles) element).isNew = false;
				myParentBO.mullionsH.add(element);
			}

		}

		if (alreadyExist == 2)
		{
			// this.myParent.doMullions();
			// this.myParent.doFrames();
		}

	}

	public void getDimsForMullion(final int x, final int y) {

		myParentBO.mullionObjectsV = myParentBO.mullions.toArray();
		myParentBO.mullionObjectsH = myParentBO.mullionsH.toArray();

		mullionThickTotal = 0;
				
		double myThickness = thickness;
		
		this.getTotalMullionThickness();

		myStartingY = myParentBO.highestY;

		newRowH = (myParentBO.lowestY - myParentBO.highestY - mullionThickTotal) / myParentBO.yRows;
		newRowH = UOMConvert.getBigDecimalConversion(newRowH, myFrame2.scale, 2);
		newRowH = Math.round(newRowH);
		newRowH = UOMConvert.getBigDecimalConversion(newRowH, myFrame2.scale, 1);

		if (newRowH < myParentBO.minLeg * myFrame2.scale.doubleValue())
		{
			goodToGo = false;
		}

		if (goodToGo)
		{

			final Object[] openings = myParentBO.myParent.openings.toArray();
			for (final Object O : openings)
			{
				if (!goodToGo)
				{
					break;
				}

				if (((OpeningObject) O).minH * myFrame2.scale.doubleValue() > newRowH
						|| ((OpeningObject) O).minH * myFrame2.scale.doubleValue() > newRowH
						|| ((OpeningObject) O).minH * myFrame2.scale.doubleValue() > newRowH)
				{
					goodToGo = false;
					break;
				}

				if (((OpeningObject) O).contentMid == 1 || ((OpeningObject) O).contentIn == 1
						|| ((OpeningObject) O).contentOut == 1)
				{
					if (((OpeningObject) O).dloMid != null
							&& ((OpeningObject) O).dloMid.minH * myFrame2.scale.doubleValue() > newRowH
							|| ((OpeningObject) O).dloIn != null
							&& ((OpeningObject) O).dloIn.minH * myFrame2.scale.doubleValue() > newRowH
							|| ((OpeningObject) O).dloOut != null
							&& ((OpeningObject) O).dloOut.minH * myFrame2.scale.doubleValue() > newRowH)
					{
						goodToGo = false;
						break;
					}

				}
				else if (((OpeningObject) O).contentMid == 2)
				{

					final Object[] sashes = ((OpeningObject) O).sashObjectMid.frames.toArray();

					for (final Object s : sashes)
					{
						if (((SashLeaf) s).minH * myFrame2.scale.doubleValue() > newRowH)
						{
							goodToGo = false;
							break;
						}
						final Object[] sopenings = ((SashLeaf) s).openings.toArray();
						final double mySashRowH = (((SashLeaf) s).heightPix - (((SashLeaf) s).yRows - 1)
								* myThickness)
								/ ((SashLeaf) s).yRows;
						for (final Object sO : sopenings)
						{
							if (((OpeningObject) sO).minH * myFrame2.scale.doubleValue() > mySashRowH
									|| ((OpeningObject) sO).minH * myFrame2.scale.doubleValue() > mySashRowH
									|| ((OpeningObject) sO).minH * myFrame2.scale.doubleValue() > mySashRowH)
							{
								goodToGo = false;
								break;
							}
						}

					}
				}
				else if (((OpeningObject) O).contentMid == 3)
				{

				}

			}

		}

		if (!goodToGo || !goodToDivide)

		{
			goodToGo = false;
			Collection tempHs = new ArrayList();

			for (final Object element2 : myParentBO.mullionObjectsH)
			{
				tempHs.add(element2);
			}
			if (!goodToGo)
			{
				JOptionPane.showMessageDialog(null, "Mininum Height reached!\n"
						+ "No additional Horizontals are possible!", "Error!",
						JOptionPane.ERROR_MESSAGE);
			}
			// myFrame2.undoAction();
			myParentBO.mullionObjectsH = tempHs.toArray();
			tempHs.clear();
			tempHs = null;
			int myRC = 0;
			for (final Object element : myParentBO.mullionObjectsH)
			{
				if (!((Profiles) element).isNew)
				{
					myParentBO.mullionsH.add(element);
				}
				else
				{
					myRC = ((Profiles) element).rowCol;
				}
			}
			if (alreadyExist == 1)
			{
				myParentBO.yRows = myParentBO.yRows - 1;
				myParentBO.myParent.yRows = myParentBO.myParent.yRows - 1;
			}

			myParentBO.mullionObjectsH = myParentBO.mullionsH.toArray();
			myParentBO.mullionsH.clear();
			for (final Object element : myParentBO.mullionObjectsH)
			{

				if (((Profiles) element).rowCol >= myRC)
				{

					((Profiles) element).rowCol = ((Profiles) element).rowCol - 1;

				}

				myParentBO.mullionsH.add(element);
			}

		}

	}

	public double getTotalMullionThickness()
	{

		final Collection doneRows = new Vector();
		doneRows.add(0);
		int myRow = 1;
		double maxThickForRow = 0;

		double myThickness = 0;
		mullionThickTotal = 0;
		final Object[] mHs = myParentBO.mullionsH.toArray();

		for (Object element : mHs)
		{
			// this.getProfileDims((Profiles) element);

			myThickness = thickness;
			((Profiles) element).recalcProfileDims();
			if (thickness == 0)
			{
				myThickness = thickness = ((Profiles) element).partDimB;
				
				if (myFrame2.mySeries.getSeriesUom() == 1)
				{
					myThickness = thickness = ((Profiles) element).partDimB;
				}
				else
				{
					myThickness = thickness = ((Profiles) element).partDimBi;
				}
				
			}
			myRow = ((Profiles) element).rowCol;
			if (!doneRows.contains(myRow))
			{
				for (Object element2 : mHs)
				{
					if (((Profiles) element2).rowCol == myRow && ((Profiles) element2).exists == 1)
					{
						myRow = ((Profiles) element2).rowCol;
						doneRows.add(myRow);
						if (myThickness > maxThickForRow)
						{
							maxThickForRow = myThickness;
						}
					}

				}
				mullionThickTotal = mullionThickTotal + maxThickForRow;
			}

		}
		return mullionThickTotal;
	}

	public void getDimsForMullionAfterChange()
	{

		final Collection doneRows = new Vector();
		doneRows.add(0);
		int myRow = 1;
		double maxThickForRow = 0;
		mullionThickTotal = 0;
		double myThickness = 0;

		for (final Object element : myParentBO.mullionObjectsH)
		{
			if (((Profiles) element).rowCol > posChangedAt)
			{
				myRow = ((Profiles) element).rowCol;
				if (!doneRows.contains(myRow))
				{
					for (final Object element2 : myParentBO.mullionObjectsH)
					{
						// this.getProfileDims((Profiles) element2);
						if (((Profiles) element2).rowCol == myRow
								&& ((Profiles) element2).exists == 1)
						{
							myThickness = ((Profiles) element2).thickness;

							myRow = ((Profiles) element2).rowCol;
							doneRows.add(myRow);
							if (myThickness > maxThickForRow)
							{
								maxThickForRow = myThickness;
							}
						}
					}
					mullionThickTotal = mullionThickTotal + maxThickForRow;
				}
			}
		}
		int noRows = 1;
		for (final Object element : myParentBO.mullionObjectsH)
		{
			if (((Profiles) element).rowCol > posChangedAt)
			{
				noRows++;
			}
		}

		myStartingY = newPosYAfterChange;

		newRowH = (Math.max(myParentBO.lowestY - newPosYAfterChange, myParentBO.lowestY
				- newPosYAfterChange) - mullionThickTotal)
				/ noRows;

		myParentBO.newRowH = newRowH;

	}

	private void getSumPrevMullions(final int row, final int column)
	{

		sumOfPrevMullions = 0;
		final Collection doneRows = new Vector();
		doneRows.add(0);
		int myRow = 1;
		double maxThickForRow = 0;
		double myThickness = 0;
		if (row > 1)
		{
			for (final Object element : myParentBO.mullionObjectsH)
			{

				myRow = ((Profiles) element).rowCol;

				if (!doneRows.contains(myRow) && row > myRow)
				{
					for (final Object element2 : myParentBO.mullionObjectsH)
					{
						// this.getProfileDims((Profiles) element2);
						if (((Profiles) element2).rowCol == myRow)
						{
							myThickness = ((Profiles) element2).thickness;

							myRow = ((Profiles) element2).rowCol;
							doneRows.add(myRow);
							if (myThickness > maxThickForRow)
							{
								maxThickForRow = myThickness;
							}
						}
					}
					sumOfPrevMullions = sumOfPrevMullions + maxThickForRow;

				}

			}
		}

	}

	private void getSumPrevMullionsAfterChange(final Profiles myMullion)
	{

		sumOfPrevMullions = 0;
		final Collection doneRows = new Vector();
		doneRows.add(0);
		int myRow = 1;
		double maxThickForRow = 0;
		double myThickness = 0;

		for (final Object element : myParentBO.mullionObjectsH)
		{

			if (((Profiles) element).rowCol < myMullion.rowCol
					&& ((Profiles) element).rowCol > posChangedAt)
			{

				myRow = ((Profiles) element).rowCol;

				// if
				// (!doneRows.contains(myRow)
				// && row > myRow)
				// {
				for (final Object element2 : myParentBO.mullionObjectsH)
				{
					// this.getProfileDims((Profiles) element2);
					if (((Profiles) element2).rowCol == myRow)
					{
						myThickness = ((Profiles) element2).thickness;

						myRow = ((Profiles) element2).rowCol;
						doneRows.add(myRow);
						if (myThickness > maxThickForRow)
						{
							maxThickForRow = myThickness;
						}
					}
				}
				sumOfPrevMullions = sumOfPrevMullions + maxThickForRow;

				// }

			}

		}//
	}

	public void zeroOutExisiting(final int existing)
	{

		((Profiles) myParentBO.mullionObjectsH[existing]).y1 = 0;
		((Profiles) myParentBO.mullionObjectsH[existing]).y2 = 0;
		((Profiles) myParentBO.mullionObjectsH[existing]).centerYs = 0;
		((Profiles) myParentBO.mullionObjectsH[existing]).startPos = 0;
		((Profiles) myParentBO.mullionObjectsH[existing]).length = 0;
		((Profiles) myParentBO.mullionObjectsH[existing]).y4 = 0;
		((Profiles) myParentBO.mullionObjectsH[existing]).y3 = 0;
		((Profiles) myParentBO.mullionObjectsH[existing]).centerYe = 0;
		((Profiles) myParentBO.mullionObjectsH[existing]).endPos = 0;
		((Profiles) myParentBO.mullionObjectsH[existing]).x1 = 0;
		((Profiles) myParentBO.mullionObjectsH[existing]).x2 = 0;
		((Profiles) myParentBO.mullionObjectsH[existing]).x3 = 0;
		((Profiles) myParentBO.mullionObjectsH[existing]).x4 = 0;
		((Profiles) myParentBO.mullionObjectsH[existing]).centerXs = 0;
		((Profiles) myParentBO.mullionObjectsH[existing]).centerXe = 0;
		((Profiles) myParentBO.mullionObjectsH[existing]).rowCol = 0;
	}

	public Profiles getProfileDims(Profiles m)
	{

		if (myFrame2.mullionsPanel.getCouplerMullionController().getPartsSelected() != null)
		{
			
			partID = myFrame2.mullionsPanel.getCouplerMullionController().getPartsSelected().getId();
			
			
			if (myFrame2.mySeries.getSeriesUom() == 1)
			{

				partDimC = UOMConvert.getBigDecimalConversion(myFrame2.mullionsPanel
						.getCouplerMullionController().getPartsSelected().getDimc(),
						myFrame2.metricscale, 1);
				partDimB = UOMConvert.getBigDecimalConversion(myFrame2.mullionsPanel
						.getCouplerMullionController().getPartsSelected().getDimb(),
						myFrame2.metricscale, 1);
				partDimA = UOMConvert.getBigDecimalConversion(myFrame2.mullionsPanel
						.getCouplerMullionController().getPartsSelected().getDima(),
						myFrame2.metricscale, 1);
				partDimD = UOMConvert.getBigDecimalConversion(myFrame2.mullionsPanel
						.getCouplerMullionController().getPartsSelected().getDimd(),
						myFrame2.metricscale, 1);
				partDimBtoC = UOMConvert.getBigDecimalConversion(myFrame2.mullionsPanel
						.getCouplerMullionController().getPartsSelected().getDimbtoc(),
						myFrame2.metricscale, 1);
				partDimM = UOMConvert.getBigDecimalConversion(myFrame2.mullionsPanel
						.getCouplerMullionController().getPartsSelected().getDimm(),
						myFrame2.metricscale, 1);

			}
			else
			{

				partDimC = UOMConvert.getBigDecimalConversion(myFrame2.mullionsPanel
						.getCouplerMullionController().getPartsSelected().getDimci(),
						myFrame2.imperialscale, 1);

				partDimB = UOMConvert.getBigDecimalConversion(myFrame2.mullionsPanel
						.getCouplerMullionController().getPartsSelected().getDimbi(),
						myFrame2.imperialscale, 1);

				partDimA = UOMConvert.getBigDecimalConversion(myFrame2.mullionsPanel
						.getCouplerMullionController().getPartsSelected().getDimai(),
						myFrame2.imperialscale, 1);

				partDimD = UOMConvert.getBigDecimalConversion(myFrame2.mullionsPanel
						.getCouplerMullionController().getPartsSelected().getDimdi(),
						myFrame2.imperialscale, 1);

				partDimBtoC = UOMConvert.getBigDecimalConversion(myFrame2.mullionsPanel
						.getCouplerMullionController().getPartsSelected().getDimbtoc_imp(),
						myFrame2.imperialscale, 1);

				partDimM = UOMConvert.getBigDecimalConversion(myFrame2.mullionsPanel
						.getCouplerMullionController().getPartsSelected().getDimm_imp(),
						myFrame2.imperialscale, 1);

			}

			this.thickness = partDimB;

		}

		continuity = myFrame2.mySeries.getContinuity();

		if (m != null)
		{
//			m = (Profiles) myFrame2.executePartRules.executePartRules(null, null, m,
//					m.a_assemblyLevel, false, false, "AddMullionV.getProfileDims 7202");
			
			
			m =  ((Profiles) m).executePartRules(false);
			
			this.thickness = m.partDimB;
			partDimC = m.partDimC;
			partDimA = m.partDimA;
			partDimB = m.partDimB;
			partDimD = m.partDimD;
			partDimBtoC = m.partDimBtoC;
			partDimM = m.partDimM;

		}

		return m;
	}

}

/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 * 
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/

package Operations;

import java.awt.Polygon;
import java.awt.geom.Arc2D.Double;
import java.awt.geom.PathIterator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.swing.JOptionPane;

import openjanela.model.entities.parts.Parts;
import util.UOMConvert;
import Model.BkgrdOpeningObject;
import Model.Facet;
import Model.JobItemModel;
import Model.OpeningObject;
import Model.SashLeaf;
import Model.ProfileParts.PartsNotching;
import Model.ProfileParts.Profiles;
import Presentation.ItemFrame;

public class AddMullionV {

	public double baseCenter = 0;

	public double baseLB = 0;

	public double baseRT = 0;

	public double baseLBa = 0;

	public double baseRTc = 0;

	public double newAlpha = 0;

	public double newAlpha2 = 0;

	public double newAlpha3 = 0;

	public double newAlphaA = 0;

	public double newAlphaC = 0;

	public double myThetaBot = 0;

	public double myThetaBot2 = 0;

	public double myThetaBot3 = 0;

	public double myThetaBotA = 0;

	public double myThetaBotC = 0;

	public boolean isValid = true;

	public double newStartingXCenter = 0;

	public double newStartingXLB = 0; // Right

	// Bottom
	public double newStartingXRT = 0;

	public double newStartingXLBa = 0; // Right

	// Bottom
	public double newStartingXRTc = 0;

	public double newStartingYCenter = 0;

	public double newStartingYLB = 0; // Right

	// Bottom
	public double newStartingYRT = 0; // Left

	// top
	public double newStartingYLBa = 0; // Right

	// Bottom
	public double newStartingYRTc = 0;

	public int alreadyExist = 1;

	public int closesta = 0;

	public int closestb = 0;

	public double mullionThickTotal = 0;

	public double delta = 100000000;

	public int iNo = 0;

	public double minDeltaa = 100000000;

	public double minDeltab = 100000000;

	public BkgrdOpeningObject myParentBO;

	public double myStartingX = 0;

	public double myEndingX = 0;

	public double myThick = 0;

	public double newColW = 0;

	public int newVCCol = 1;

	public int newVCRow = 1;

	public boolean startStopDone = false;

	public double sumOfPrevMullions = 0;

	public double vcCXe = 0;

	public double vcCXs = 0;

	public double vcCYe = 0;

	public double vcCYs = 0;

	public int vcEnd = 1;

	public double vcEndX = 0;

	public double vcEndY = 0;

	public int vcStart = 1;

	public double vcStartX = 0;

	public double vcStartY = 0;

	public boolean goodToGo = true;

	public boolean goodToDivide = true;

	public Collection xCoordBc = new ArrayList();

	public Collection yCoordBc = new ArrayList();

	// newW

	// ShapeObject myParentBO =
	// null;
	// rgb_R
	// OpeningObject myOpening = null;
	boolean wire = false;

	public CalculateMullionV calcMullion;

	int prevShape = 1;

	int newShape = 1;

	int frameEndRow = 0;

	boolean done = false;

	int newEndCol = 0;

	int shape = 0;

	int startcol = 0;

	int startrow = 0;

	int endcol = 0;

	int endrow = 0;

	int myClickedShape = 0;

	int myOpeningShape = 0;

	public int posCondition = 1;

	// 1= |--|
	// 2= *--|
	// 3= |--*
	// 4= *--*

	public int mType = 0;

	public double offsetTL = 0; // offset

	// from
	// center
	// (-
	// or
	// +)
	public double offsetRB = 0;

	public int partForm = 1;

	public double deltaTL = 60;

	public double deltaRB = 60;

	public double curveCenterTL = 95;

	public double curveCenterRB = 95;

	public double dimTM = 0; // partDimM
								// How
								// Far
								// the
								// Mullion
								// goes.

	public double dimBM = 0;

	public double dimTA = 0;

	public double dimBA = 0;

	public boolean endIn = false;

	public boolean startIn = false;

	public int partID = 0;

	int setHcontinuity = 0; // do

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
	public int continuity = 0;

	public boolean fixedAngle = true;

	public double angle = 180;

	public boolean phantom = false; // 0
									// any
									// 1
									// flat
									// 2
									// bays

	// only 2 bows only 4 custom

	public double thickness = 0;

	public Profiles limitStart = null;

	public int limitStartPF = 0;

	public Profiles limitEnd = null;

	public Profiles limitStart2 = null;

	public Profiles limitEnd2 = null;

	public double limitStartXsA = 0;

	public double limitStartYsA = 0;

	public double limitStartXeA = 0;

	public double limitStartYeA = 0;

	public double limitStartXsBA = 0;

	public double limitStartYsBA = 0;

	public double limitStartXeBA = 0;

	public double limitStartYeBA = 0;

	public double limitStartXsB = 0;

	public double limitStartYsB = 0;

	public double limitStartXeB = 0;

	public double limitStartYeB = 0;

	public double limitEndXsA = 0;

	public double limitEndYsA = 0;

	public double limitEndXeA = 0;

	public double limitEndYeA = 0;

	public double limitEndXsBA = 0;

	public double limitEndYsBA = 0;

	public double limitEndXeBA = 0;

	public double limitEndYeBA = 0;

	public double limitEndXsB = 0;

	public double limitEndYsB = 0;

	public double limitEndXeB = 0;

	public double limitEndYeB = 0;

	public double limitStartXsAm = 0;

	public double limitStartYsAm = 0;

	public double limitStartXeAm = 0;

	public double limitStartYeAm = 0;

	public double limitStartXsBAm = 0;

	public double limitStartYsBAm = 0;

	public double limitStartXeBAm = 0;

	public double limitStartYeBAm = 0;

	public double limitStartXsBm = 0;

	public double limitStartYsBm = 0;

	public double limitStartXeBm = 0;

	public double limitStartYeBm = 0;

	public int inArchStart = 0; // 1

	// if
	// 1
	// arch,
	// (gothic)
	// 3
	// ellipse
	public int inArchEnd = 0; // 1

	// if
	// 1
	// arch,
	// (gothic)
	// 3
	// ellipse
	public boolean inMiddleS = false;

	public boolean inMiddleE = false;

	public double thetaOffset = 0;

	public Profiles myMullion;

	public boolean isNew = false;

	public int direction = 0;

	public double partDimA = 0;

	public double partDimB = 0;

	public double partDimBtoC = 0;

	// Where the Center of Mullion (screw Ports is)

	public double partDimC = 0;

	public double partDimD = 0;

	public double partDimM = 0;

	// Middle Point - Where the Other Mullion Point reaches.

	public Profiles top1Part;

	public Profiles bot1Part;

	// public Bot2Object bot2Part;
	// public Bot3Object bot3Part;

	/*
	 * should add an array of mullion Bits Collection of verticals with: Col,
	 * StartRow, endRow, x1,x2,x3,x4,y1,,,, Then compile into actual mullions.
	 * This helps with in Continuity
	 */
	public JobItemModel myJobItem;

	public ItemFrame myFrame2;

	public int whichPos = 0;

	public int cOrM = 1; // 1=coupler

	public int order = 0;

	public boolean inMiddle = false;

	public boolean limitsFound = false;

	BigDecimal myScale = new BigDecimal(0);

	public int typeID = 0; // D,C,M
							// Type
							// ID
							// (Type_coupler_Mullion.id)

	/**
	 * Create Add Mullion Vertical
	 * 
	 * @param mybo
	 *            , BkgrdOpeningObject
	 * @param jobItemappli
	 *            , JobItemModel
	 * @param mainPanel
	 *            , ItemFrame
	 * @param type
	 *            , type of profiles (Coupler or Mullion)
	 */
	public AddMullionV(BkgrdOpeningObject mybo, JobItemModel jobItem,
			ItemFrame mainPanel, int type) {

		myParentBO = mybo;
		myJobItem = jobItem;
		myFrame2 = mainPanel;
		calcMullion = new CalculateMullionV(this);
		myClickedShape = myParentBO.shapeID;
		cOrM = type;
		order = myParentBO.order;
	}

	/**
	 * Doing vertical mullion
	 * 
	 * @param x
	 *            , Axis x position
	 * @param y
	 *            , Axis y position
	 * @param isNew
	 *            , New polygon
	 * @param type
	 *            , Type
	 * @param mullionPartForm
	 *            , Mullion part form
	 * @param offsetTL
	 *            , Offset TL
	 * @param offsetRB
	 *            , Offset RB
	 * @param deltaTL
	 *            , Delta TL
	 * @param deltaRB
	 *            , Delta RB
	 * @param curveCenterTL
	 *            , Curve center TL
	 * @param curveCenterRB
	 *            , Curve center RB
	 * @param partID
	 *            , part ID
	 * @param continuity
	 *            , Continuity
	 * @param thick
	 *            , Thick
	 * @param pos
	 *            , Position
	 * @param doOp
	 *            , Do Op
	 * @param colW
	 *            , Col W
	 * @param assemblyL
	 *            , Assembly L
	 * @return Object[]
	 */
	public Object[] doAddMullionsV(int x, int y, boolean isNew, int type,
			int mullionPartForm, double offsetTL, double offsetRB,
			double deltaTL, double deltaRB, double curveCenterTL,
			double curveCenterRB, int partID, int continuity, int thick,
			int pos, boolean doOp, double colW, int assemblyL, int typeid,
			int direction) throws Exception {

		//
		// Declaring arraylist return
		Object[] returns = new Object[2];

		// Get new value
		this.isNew = isNew;
		this.direction = direction;

		if (cOrM <= 2 && myFrame2.alignPerformed) {
			myFrame2.jobItem.myCanvas.equalize = true;
			myFrame2.jobItem.myCanvas.equalizeWidths();
			myFrame2.alignPerformed = false;
		}

		if (isNew) {

			mType = type;
			this.partID = partID;

			typeID = typeid;

			partForm = mullionPartForm;
			this.continuity = continuity;
			this.offsetTL = offsetTL;
			this.offsetRB = offsetRB;
			this.deltaTL = deltaTL;
			this.deltaRB = deltaRB;
			this.curveCenterTL = curveCenterTL;
			this.curveCenterRB = curveCenterRB;
			thickness = 0;

			if (thick > 0) {
				thickness = thick;
			} else if (this.partDimB > 0) {
				thickness = this.partDimB;
			}

			whichPos = pos;

			if (goodToGo) {

				if (cOrM <= 2 && myParentBO.myParent.a_levelID != 12) {
					myParentBO.myParent.partObjects.clear();
					myParentBO.myParent.resetParts();
				}

				if (cOrM <= 2) {
					this.alreadyExistii(x, y);
				} else {
					alreadyExist = 1;
				}

				myParentBO.myFrame2.posCond = posCondition;

				if (goodToGo) {

					myFrame2.ellipses.clear();

					if (alreadyExist != 0) {

						if (alreadyExist != 3) {

							if (alreadyExist == 1) {

								if (cOrM == 1) {
									myFrame2.roundW = true;
								}

								if (isNew) {
									myParentBO.xCols++;
									myParentBO.myParent.xCols++;

									if (cOrM <= 2
											&& myParentBO.mullionObjectsV.length > 0
											&& myParentBO.mullionObjectsV != null) {
										this.reOrderVMullions(alreadyExist);
									}
								}
							}

							this.addMullionVAtPos(x, y, assemblyL);

							if (cOrM <= 2) {

								if (colW <= 0) {
									this.getDimsForMullion(myParentBO.xCols, 1);
								} else {
									myStartingX = Math.min(
											myParentBO.startingX,
											myParentBO.bX4);
									this.newColW = colW;
								}

							}

							myParentBO.mullionObjectsV = null;
							myParentBO.mullionObjectsV = myParentBO.mullions
									.toArray();
							myParentBO.mullions.clear();

							if (goodToGo && goodToDivide) {

								for (Object element : myParentBO.mullionObjectsV) {
									this.doMullionCalculations(
											((Profiles) element),
											((Profiles) element).isNew, false);
								}

								if (cOrM <= 2
										&& myParentBO.mullionObjectsH.length > 0
										&& alreadyExist != 2) {
									this.reOrderHMullions();
								}
							}
						}

						if (goodToGo && goodToDivide) {

							if (alreadyExist == 3) {

								myParentBO.mullions.clear();

								for (Object vc : myParentBO.mullionObjectsV) {

									if (!((Profiles) vc).remove) {
										newStartingXCenter = ((Profiles) vc).centerXs;
										newStartingXRTc = ((Profiles) vc).x2cl;
										newStartingXRT = ((Profiles) vc).x2;
										newStartingXLB = ((Profiles) vc).x1;
										newStartingXLBa = ((Profiles) vc).x1al;

										this.verifyLimitLR(((Profiles) vc));
										calcMullion
												.calculateCoord(((Profiles) vc));

										// Reset and Recalc Mullion

										vc = this
												.resetRecalcMullionBom((Profiles) vc);

										myParentBO.mullions.add(vc);
									}
								}

								myParentBO.mullionObjectsV = null;
								myParentBO.mullionObjectsV = myParentBO.mullions
										.toArray();

								for (Object element : myParentBO.mullionObjectsV) {

									if (((Profiles) element).rowCol == newVCCol
											&& ((Profiles) element).endPos >= vcEnd
											&& ((Profiles) element).startPos <= vcStart) {

										myParentBO.myProfilesV = (Profiles) element;
										myParentBO.mullion = myParentBO.myProfilesV;

									}

								}
								myParentBO.mullionObjectsH = null;
								myParentBO.mullionObjectsH = myParentBO.mullionsH
										.toArray();
								myParentBO.mullionsH.clear();

								for (int c = 0; c < myParentBO.mullionObjectsH.length; c++) {

									if (((Profiles) myParentBO.mullionObjectsH[c]).endPos > newVCCol
											&& ((Profiles) myParentBO.mullionObjectsH[c]).startPos <= newVCCol
											&& myParentBO.myProfilesV.y2cl < ((Profiles) myParentBO.mullionObjectsH[c]).y2
											&& myParentBO.myProfilesV.y4al > ((Profiles) myParentBO.mullionObjectsH[c]).y1) {
										this.addMullionHSplit(
												((Profiles) myParentBO.mullionObjectsH[c]),
												myParentBO.myProfilesV, c);
									} else {
										myParentBO.mullionsH
												.add(myParentBO.mullionObjectsH[c]);
									}

								}

							}

							if (cOrM <= 2 && alreadyExist == 1) {

								this.recalcHCCoords();
							}
						}
					}

					if (goodToGo && goodToDivide) {

						if (cOrM <= 2 && myParentBO.a_levelID == 3) {
							AddMullionH addMullionH = new AddMullionH(
									myParentBO, myJobItem, myFrame2, cOrM);
							addMullionH.reOrderHMNotches();

						} else if (cOrM <= 2 && myParentBO.a_levelID != 3) {
							AddMullionH addMullionH = new AddMullionH(
									myParentBO, myJobItem, myFrame2, cOrM);
							addMullionH.reOrderHMNotches();
						}

						if (cOrM <= 2) {
							this.reOrderVNotches();
						}
					}
				}
			}

			if (alreadyExist == 0) {
				JOptionPane.showMessageDialog(null,
						"Duplicate Mullion Location!", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		if (alreadyExist != 0 && goodToGo && goodToDivide) {
			this.recalcInitOpenings();
		}

		if (!goodToGo && goodToDivide) {
			JOptionPane.showMessageDialog(null, "Invalid Mullion!", "Error!",
					JOptionPane.ERROR_MESSAGE);
		}

		if (cOrM <= 2 && myParentBO.myParent.a_levelID != 12 && goodToDivide
				&& goodToGo) {
			this.splitParts(null, false, false);
		}

		myParentBO.myParent.doOpenings();

		myParentBO = myParentBO.myParent.doMullions(myParentBO);
		returns[0] = goodToGo;
		returns[1] = myParentBO;

		return returns;
	}

	public BkgrdOpeningObject doAddDividerV(int x, int y, boolean isNew,
			int type, int mullionPartForm, double offsetTL, double offsetRB,
			double deltaTL, double deltaRB, double curveCenterTL,
			double curveCenterRB, int partID, int continuity, int thick,
			int pos, boolean doOp) throws Exception {

		this.isNew = isNew;

		if (cOrM <= 2 && myFrame2.alignPerformed) {
			myFrame2.jobItem.myCanvas.equalize = true;
			myFrame2.jobItem.myCanvas.equalizeWidths();
			myFrame2.alignPerformed = false;
		}
		if (isNew) {
			mType = type;
			this.partID = partID;
			partForm = mullionPartForm;
			this.continuity = continuity;
			this.offsetTL = offsetTL;
			this.offsetRB = offsetRB;
			this.deltaTL = deltaTL;
			this.deltaRB = deltaRB;
			this.curveCenterTL = curveCenterTL;
			this.curveCenterRB = curveCenterRB;
			if (thick > 0) {
				thickness = thick;
			}
			whichPos = pos;

			if (goodToGo) {
				if (cOrM <= 2 && myParentBO.myParent.a_levelID != 12) {
					myParentBO.myParent.partObjects.clear();

					myParentBO.myParent.resetParts();
				}
				if (cOrM <= 2) {
					this.alreadyExistii(x, y);
				} else {
					alreadyExist = 1;
				}
				myParentBO.myFrame2.posCond = posCondition;
				if (goodToGo) {

					myJobItem.resetGraphics();

					myFrame2.ellipses.clear();

					if (alreadyExist != 0) {
						if (alreadyExist != 3) {

							if (alreadyExist == 1) {
								if (cOrM == 1) {
									myFrame2.roundW = true;
								}
								if (isNew) {

									myParentBO.xCols++;
									myParentBO.myParent.xCols++;

									if (cOrM <= 2
											&& myParentBO.mullionObjectsV.length > 0
											&& myParentBO.mullionObjectsV != null) {
										this.reOrderVMullions(alreadyExist);//
									}
								}
							}

							this.addMullionVAtPos(x, y, 30);

							if (cOrM <= 2) {
								this.getDimsForMullion(myParentBO.xCols, 1);
							}

							myParentBO.mullionObjectsV = null;
							myParentBO.mullionObjectsV = myParentBO.mullions
									.toArray();
							myParentBO.mullions.clear();

							if (goodToGo && goodToDivide) {
								for (final Object element : myParentBO.mullionObjectsV) {

									this.doMullionCalculations(
											((Profiles) element),
											((Profiles) element).isNew, false);
								}

								if (cOrM <= 2
										&& myParentBO.mullionObjectsH.length > 0
										&& alreadyExist != 2) {
									this.reOrderHMullions();
								}
							}

						}
						if (goodToGo && goodToDivide) {
							if (alreadyExist == 3) {

								myParentBO.mullions.clear();

								for (Object vc : myParentBO.mullionObjectsV) {
									if (!((Profiles) vc).remove) {
										newStartingXCenter = ((Profiles) vc).centerXs;
										newStartingXRTc = ((Profiles) vc).x2cl;
										newStartingXRT = ((Profiles) vc).x2;
										newStartingXLB = ((Profiles) vc).x1;
										newStartingXLBa = ((Profiles) vc).x1al;

										this.verifyLimitLR(((Profiles) vc));
										calcMullion
												.calculateCoord(((Profiles) vc));

										// Reset and Recalc Mullion

										vc = this
												.resetRecalcMullionBom((Profiles) vc);

										myParentBO.mullions.add(vc);
									}
								}

								myParentBO.mullionObjectsV = null;
								myParentBO.mullionObjectsV = myParentBO.mullions
										.toArray();

								for (Object element : myParentBO.mullionObjectsV) {

									if (((Profiles) element).rowCol == newVCCol
											&& ((Profiles) element).endPos >= vcEnd
											&& ((Profiles) element).startPos <= vcStart) {

										myParentBO.myProfilesV = (Profiles) element;
										myParentBO.mullion = myParentBO.myProfilesV;

									}

								}
								myParentBO.mullionObjectsH = null;
								myParentBO.mullionObjectsH = myParentBO.mullionsH
										.toArray();
								myParentBO.mullionsH.clear();

								for (int c = 0; c < myParentBO.mullionObjectsH.length; c++) {

									if (((Profiles) myParentBO.mullionObjectsH[c]).endPos > newVCCol
											&& ((Profiles) myParentBO.mullionObjectsH[c]).startPos <= newVCCol
											&& myParentBO.myProfilesV.y2 < ((Profiles) myParentBO.mullionObjectsH[c]).y2
											&& myParentBO.myProfilesV.y4 > ((Profiles) myParentBO.mullionObjectsH[c]).y1)
									// added to prevent Split if V M is
									// 0 thick
									{
										this.addMullionHSplit(
												((Profiles) myParentBO.mullionObjectsH[c]),
												myParentBO.myProfilesV, c);
										// modifyVMullion(c);

									} else {
										myParentBO.mullionsH
												.add(myParentBO.mullionObjectsH[c]);
									}

								}// for Loop V mullion

							}// if extend already exist ==3

							if (cOrM <= 2 && alreadyExist == 1) {
								this.recalcHCCoords();
							}
						}
					}

					if (goodToGo && goodToDivide) {
						if (cOrM <= 2 && myParentBO.a_levelID == 3) {
							AddMullionH addMullionH = new AddMullionH(
									myParentBO, myJobItem, myFrame2, cOrM);
							addMullionH.reOrderHMNotches();
						} else if (cOrM <= 2 && myParentBO.a_levelID != 3) {
							AddMullionH addMullionH = new AddMullionH(
									myParentBO, myJobItem, myFrame2, cOrM);
							addMullionH.reOrderHMNotches();
						}
						if (cOrM <= 2) {
							this.reOrderVNotches();
						}
					}

				}
			}
			if (alreadyExist == 0) {
				JOptionPane.showMessageDialog(null,
						"Duplicate Mullion Location!", "Error",
						JOptionPane.ERROR_MESSAGE);
				// myJobItem.myCanvas
				// .setSelectedView();
			}
		}

		if (alreadyExist != 0 && goodToGo && goodToDivide) {
			this.recalcInitOpenings();
			// this.myParent.doOpenings();
		}

		if (!goodToGo) {
			JOptionPane.showMessageDialog(null, "Invalid Mullion!", "Warning!",
					JOptionPane.WARNING_MESSAGE);
		}
		//
		// myParentBO.myParent.OverallWidthChangeAddDivider(newColW);

		myParentBO.myParent.createSideShapes(false, true, myFrame2.scale);
		myParentBO.myParent.setBAandA();
		myParentBO.myParent.doMainOpening();
		myParentBO.myParent.modifyVDividerPosEqualize();
		myParentBO.myParent.bOpeningObject = myParentBO.myParent
				.doMullions(myParentBO);
		myParentBO.myParent.doFacets(false, false, true, false);
		myParentBO.myParent.drawFacets();

		myParentBO.myParent.executeOptionRules("AddMullionV.877");

		myParentBO.myParent.bom.clear();
		myParentBO.myParent.clearBomForShape();
		myParentBO.myParent.executePartRules(true, true, "AddMullionV.877");

		myFrame2.jobItem.resetGraphics();

		myParentBO = myParentBO.myParent.doMullions(myParentBO);

		return myParentBO;
	}

	public void alreadyExistii(int x, int y) {

		myParentBO.mullionObjectsH = null;
		myParentBO.mullionObjectsH = myParentBO.mullionsH.toArray();

		myParentBO.mullionObjectsV = null;
		myParentBO.mullionObjectsV = myParentBO.mullions.toArray();

		boolean duplicate = false;

		for (final Object M : myParentBO.mullionObjectsV) {
			final Polygon m = new Polygon();
			m.addPoint((int) ((Profiles) M).x1al - 5, (int) ((Profiles) M).y1al);
			m.addPoint((int) ((Profiles) M).centerXs,
					(int) ((Profiles) M).centerYs);
			m.addPoint((int) ((Profiles) M).x2cl + 5, (int) ((Profiles) M).y2cl);
			m.addPoint((int) ((Profiles) M).x3cl + 5, (int) ((Profiles) M).y3cl);
			m.addPoint((int) ((Profiles) M).centerXe,
					(int) ((Profiles) M).centerYe);
			m.addPoint((int) ((Profiles) M).x4al - 5, (int) ((Profiles) M).y4al);

			if (m.contains(x, y)) {
				goodToGo = false;
				duplicate = true;
				break;
			}

		}

		for (final Object M : myParentBO.mullionObjectsH) {
			final Polygon m = new Polygon();
			m.addPoint((int) ((Profiles) M).x1al, (int) ((Profiles) M).y1al + 5);
			m.addPoint((int) ((Profiles) M).centerXs,
					(int) ((Profiles) M).centerYs);
			m.addPoint((int) ((Profiles) M).x2cl, (int) ((Profiles) M).y2cl - 5);
			m.addPoint((int) ((Profiles) M).x3cl, (int) ((Profiles) M).y3cl - 5);
			m.addPoint((int) ((Profiles) M).centerXe,
					(int) ((Profiles) M).centerYe);
			m.addPoint((int) ((Profiles) M).x4al, (int) ((Profiles) M).y4al + 5);

			if (m.contains(x, y)) {
				goodToGo = false;
				duplicate = true;
				break;
			}

		}

		if (goodToGo) {

			/*
			 * should also test for mullion type and then PartID to be the same.
			 */
			this.getNewVMullionCol(x, y);
			this.getStartStopRow(x, y);

			if (cOrM == 1 && posCondition != 1) {

				if (angle != 180 || !fixedAngle) {
					goodToGo = false;
				}

			}

			if (myParentBO.yRows > 1 && goodToGo) {
				// this.newVCRow(x, y);
				// this.getStartStopCol(x, y);

				for (Object element : myParentBO.mullionObjectsV) {

					if (Math.min((int) ((Profiles) element).x1al - 5,
							(int) ((Profiles) element).x4al - 5) <= x
							&& Math.max((int) ((Profiles) element).x2cl + 5,
									(int) ((Profiles) element).x3cl + 5) >= x
							&& (int) ((Profiles) element).y1al <= y
							&& (int) ((Profiles) element).y4al >= y) {
						duplicate = true;
						alreadyExist = 0;
						goodToGo = false;
						break;
					}
				}

				if (!duplicate) {
					alreadyExist = 1;
					if (posCondition == 2) {

						for (int vc = 0; vc < myParentBO.mullionObjectsV.length; vc++) {

							if (Math.min(
									(int) ((Profiles) myParentBO.mullionObjectsV[vc]).x1al,
									(int) ((Profiles) myParentBO.mullionObjectsV[vc]).x4al) - 5 <= x
									&& Math.max(
											(int) ((Profiles) myParentBO.mullionObjectsV[vc]).x2cl,
											(int) ((Profiles) myParentBO.mullionObjectsV[vc]).x3cl) + 5 >= x) {

								newVCCol = ((Profiles) myParentBO.mullionObjectsV[vc]).rowCol;
								alreadyExist = 2;

								if (((Profiles) myParentBO.mullionObjectsV[vc]).centerYs > y
										&& vcEnd + 1 == ((Profiles) myParentBO.mullionObjectsV[vc]).startPos) {
									if (((Profiles) myParentBO.mullionObjectsV[vc]).continuity == 1
											&& mType == ((Profiles) myParentBO.mullionObjectsV[vc]).mType) {

										this.extendTopOfMulliontoTop(vc);// Here
										setHcontinuity = 3;
										alreadyExist = 3;
										newVCCol = ((Profiles) myParentBO.mullionObjectsV[vc]).rowCol;
										break;

									} else {

										alreadyExist = 2;
										newVCCol = ((Profiles) myParentBO.mullionObjectsV[vc]).rowCol;
										break;
									}
								}
							}
						}
					} else if (posCondition == 3) {

						for (int vc = 0; vc < myParentBO.mullionObjectsV.length; vc++) {

							if (Math.min(
									(int) ((Profiles) myParentBO.mullionObjectsV[vc]).x1al,
									(int) ((Profiles) myParentBO.mullionObjectsV[vc]).x4al) - 5 <= x
									&& Math.max(
											(int) ((Profiles) myParentBO.mullionObjectsV[vc]).x2cl,
											(int) ((Profiles) myParentBO.mullionObjectsV[vc]).x3cl) + 5 >= x) {

								newVCCol = ((Profiles) myParentBO.mullionObjectsV[vc]).rowCol;
								alreadyExist = 2;
								if (((Profiles) myParentBO.mullionObjectsV[vc]).centerYe < y
										&& ((Profiles) myParentBO.mullionObjectsV[vc]).endPos + 1 == vcStart) {

									if (((Profiles) myParentBO.mullionObjectsV[vc]).continuity == 1
											&& mType == ((Profiles) myParentBO.mullionObjectsV[vc]).mType) {

										this.extendBotOfMulliontoBot(vc);
										setHcontinuity = 3;
										alreadyExist = 3;
										newVCCol = ((Profiles) myParentBO.mullionObjectsV[vc]).rowCol;
										break;

									} else {

										alreadyExist = 2;
										newVCCol = ((Profiles) myParentBO.mullionObjectsV[vc]).rowCol;
										break;
									}

								}
							}
						}
					} else if (posCondition == 4) {

						this.aboveBelow(x, y);

					}
				}
			}

		} else {

			JOptionPane
					.showMessageDialog(
							null,
							"Mouse clicked with a 5 pixel range of an existing Coupler/Mullion.",
							"ERROR!", JOptionPane.ERROR_MESSAGE);

			alreadyExist = -1;
		}
	}

	public void aboveBelow(final int x, final int y) {

		boolean mAbove = false;
		boolean mBelow = false;
		boolean found = false;

		for (Object element : myParentBO.mullionObjectsV) {
			if (Math.min((int) ((Profiles) element).x1al - 10,
					(int) ((Profiles) element).x4al - 5) <= x
					&& Math.max((int) ((Profiles) element).x2cl + 10,
							(int) ((Profiles) element).x3cl + 5) >= x) {

				if (((Profiles) element).centerYe < y
						&& vcStart - 1 == ((Profiles) element).endPos) {
					mAbove = true;
				}

				if (((Profiles) element).centerYs > y
						&& ((Profiles) element).startPos - 1 == vcEnd) {
					mBelow = true;
				}
			}

		}

		if (mAbove && !mBelow) {

			for (int vc = 0; vc < myParentBO.mullionObjectsV.length; vc++) {

				newVCCol = ((Profiles) myParentBO.mullionObjectsV[vc]).rowCol;
				alreadyExist = 2;

				if (Math.min(
						(int) ((Profiles) myParentBO.mullionObjectsV[vc]).x1al,
						(int) ((Profiles) myParentBO.mullionObjectsV[vc]).x4al) - 5 <= x
						&& Math.max(
								(int) ((Profiles) myParentBO.mullionObjectsV[vc]).x2cl,
								(int) ((Profiles) myParentBO.mullionObjectsV[vc]).x3cl) + 5 >= x) {

					if (((Profiles) myParentBO.mullionObjectsV[vc]).continuity == 1
							&& mType == ((Profiles) myParentBO.mullionObjectsV[vc]).mType) {
						if (((Profiles) myParentBO.mullionObjectsV[vc]).centerYe < y
								&& vcStart - 1 == ((Profiles) myParentBO.mullionObjectsV[vc]).endPos) {

							this.extendBotOfMulliontoBot(vc);
							setHcontinuity = 3;
							alreadyExist = 3;
							newVCCol = ((Profiles) myParentBO.mullionObjectsV[vc]).rowCol;
							found = true;
							break;
						}
					}
				}
			}

		} else if (!mAbove && mBelow) {

			for (int vc = 0; vc < myParentBO.mullionObjectsV.length; vc++) {
				newVCCol = ((Profiles) myParentBO.mullionObjectsV[vc]).rowCol;
				alreadyExist = 2;
				if (Math.min(
						(int) ((Profiles) myParentBO.mullionObjectsV[vc]).x1al,
						(int) ((Profiles) myParentBO.mullionObjectsV[vc]).x4al) - 5 <= x
						&& Math.max(
								(int) ((Profiles) myParentBO.mullionObjectsV[vc]).x2cl,
								(int) ((Profiles) myParentBO.mullionObjectsV[vc]).x3cl) + 5 >= x) {

					if (((Profiles) myParentBO.mullionObjectsV[vc]).continuity == 1
							&& mType == ((Profiles) myParentBO.mullionObjectsV[vc]).mType) {
						if (((Profiles) myParentBO.mullionObjectsV[vc]).centerYs > y
								&& ((Profiles) myParentBO.mullionObjectsV[vc]).startPos - 1 == vcEnd) {

							this.extendTopOfMulliontoTop(vc);
							setHcontinuity = 3;
							alreadyExist = 3;
							newVCCol = ((Profiles) myParentBO.mullionObjectsV[vc]).rowCol;
							found = true;
							break;
						}
					}

				}

			}

		} else if (mAbove && mBelow) {

			for (int vc = 0; vc < myParentBO.mullionObjectsV.length; vc++) {
				newVCCol = ((Profiles) myParentBO.mullionObjectsV[vc]).rowCol;
				alreadyExist = 2;
				if (Math.min(
						(int) ((Profiles) myParentBO.mullionObjectsV[vc]).x1al,
						(int) ((Profiles) myParentBO.mullionObjectsV[vc]).x4al) - 5 <= x
						&& Math.max(
								(int) ((Profiles) myParentBO.mullionObjectsV[vc]).x2cl,
								(int) ((Profiles) myParentBO.mullionObjectsV[vc]).x3cl) + 5 >= x) {

					if (((Profiles) myParentBO.mullionObjectsV[vc]).continuity == 1
							&& mType == ((Profiles) myParentBO.mullionObjectsV[vc]).mType) {
						if (((Profiles) myParentBO.mullionObjectsV[vc]).centerYe < y
								&& vcStart - 1 == ((Profiles) myParentBO.mullionObjectsV[vc]).endPos) {

							setHcontinuity = 3;
							alreadyExist = 3;
							((Profiles) myParentBO.mullionObjectsV[vc]).remove = true;
							found = true;

						}
					}

					for (int vc2 = 0; vc2 < myParentBO.mullionObjectsV.length; vc2++) {
						newVCCol = ((Profiles) myParentBO.mullionObjectsV[vc2]).rowCol;
						alreadyExist = 2;

						if (Math.min(
								(int) ((Profiles) myParentBO.mullionObjectsV[vc2]).x1al,
								(int) ((Profiles) myParentBO.mullionObjectsV[vc2]).x4al) - 5 <= x
								&& Math.max(
										(int) ((Profiles) myParentBO.mullionObjectsV[vc2]).x2cl,
										(int) ((Profiles) myParentBO.mullionObjectsV[vc2]).x3cl) + 5 >= x) {

							if (((Profiles) myParentBO.mullionObjectsV[vc2]).continuity == 1
									&& mType == ((Profiles) myParentBO.mullionObjectsV[vc2]).mType) {
								if (((Profiles) myParentBO.mullionObjectsV[vc2]).centerYs > y
										&& ((Profiles) myParentBO.mullionObjectsV[vc2]).startPos - 1 == vcEnd) {

									this.extendTopOfMulliontoTop(vc2, vc);
									setHcontinuity = 3;
									alreadyExist = 3;
									newVCCol = ((Profiles) myParentBO.mullionObjectsV[vc]).rowCol;

									found = true;
									break;
								}
							}
						}
					}

					if (found) {
						break;
					}
				}
			}
		}

		if (!found) {

			for (Object element : myParentBO.mullionObjectsV) {

				if (Math.min((int) ((Profiles) element).x1al,
						(int) ((Profiles) element).x4al) - 10 <= x
						&& Math.max((int) ((Profiles) element).x2cl,
								(int) ((Profiles) element).x3cl) + 10 >= x) {
					alreadyExist = 2;
					newVCCol = ((Profiles) element).rowCol;
					break;
				}
			}
		}

	}

	private void extendTopOfMulliontoTop(int vc) {

		double deltaY2cl = 0;
		double deltaY2 = 0;
		double deltaY1 = 0;
		double deltaY1al = 0;

		if (((Profiles) myParentBO.mullionObjectsV[vc]).endTypeLT == 1) {

			double thetaC = Math
					.atan(((partDimC + partDimB / 2) / (dimTA + dimTM)));
			double thetaA = Math
					.atan(((partDimA + partDimB / 2) / (dimTA + dimTM)));

			deltaY2cl = vcStartY - dimTA;

			deltaY2 = vcStartY + dimTM - partDimB / 2 / Math.tan(thetaA);
			deltaY1 = vcStartY + dimTM - partDimB / 2 / Math.tan(thetaC);
			deltaY1al = vcStartY - dimTA;

			((Profiles) myParentBO.mullionObjectsV[vc]).y2 = deltaY2;
			((Profiles) myParentBO.mullionObjectsV[vc]).y1 = deltaY1;
			((Profiles) myParentBO.mullionObjectsV[vc]).y2cl = deltaY2cl;
			((Profiles) myParentBO.mullionObjectsV[vc]).y1al = deltaY1al;

			((Profiles) myParentBO.mullionObjectsV[vc]).centerYs = ((Profiles) myParentBO.mullionObjectsV[vc]).centerYs
					+ vcStartY
					- ((Profiles) myParentBO.mullionObjectsV[vc]).centerYs
					+ dimTM;

		} else {

			double delta = vcStartY
					- ((Profiles) myParentBO.mullionObjectsV[vc]).y2;
			((Profiles) myParentBO.mullionObjectsV[vc]).y2 = ((Profiles) myParentBO.mullionObjectsV[vc]).y1
					+ delta;
			((Profiles) myParentBO.mullionObjectsV[vc]).y1 = ((Profiles) myParentBO.mullionObjectsV[vc]).y1
					+ delta;
			((Profiles) myParentBO.mullionObjectsV[vc]).y2cl = ((Profiles) myParentBO.mullionObjectsV[vc]).y2cl
					+ delta;
			((Profiles) myParentBO.mullionObjectsV[vc]).y1al = ((Profiles) myParentBO.mullionObjectsV[vc]).y1al
					+ delta;
			((Profiles) myParentBO.mullionObjectsV[vc]).centerYs = ((Profiles) myParentBO.mullionObjectsV[vc]).centerYs
					+ delta;

		}

		((Profiles) myParentBO.mullionObjectsV[vc]).startPos = vcStart;

		((Profiles) myParentBO.mullionObjectsV[vc]).length = ((Profiles) myParentBO.mullionObjectsV[vc]).centerYe
				- ((Profiles) myParentBO.mullionObjectsV[vc]).centerYs;

		((Profiles) myParentBO.mullionObjectsV[vc]).startIn = startIn;

		if (!((Profiles) myParentBO.mullionObjectsV[vc]).startIn
				&& !((Profiles) myParentBO.mullionObjectsV[vc]).endIn) {
			posCondition = 1;
		} else if (!((Profiles) myParentBO.mullionObjectsV[vc]).startIn
				&& ((Profiles) myParentBO.mullionObjectsV[vc]).endIn) {
			posCondition = 2;
		} else if (((Profiles) myParentBO.mullionObjectsV[vc]).startIn
				&& !((Profiles) myParentBO.mullionObjectsV[vc]).endIn) {
			posCondition = 3;
		} else {
			posCondition = 4;
		}
		((Profiles) myParentBO.mullionObjectsV[vc]).posCondition = posCondition;
		myParentBO.mullionObjectsV[vc] = verifyLimitLR(((Profiles) myParentBO.mullionObjectsV[vc]));
		alreadyExist = 3;
	}

	private void extendTopOfMulliontoTop(int vc, int vc2) {

		((Profiles) myParentBO.mullionObjectsV[vc]).y2 = ((Profiles) myParentBO.mullionObjectsV[vc2]).y2;
		((Profiles) myParentBO.mullionObjectsV[vc]).y1 = ((Profiles) myParentBO.mullionObjectsV[vc2]).y1;
		((Profiles) myParentBO.mullionObjectsV[vc]).y2cl = ((Profiles) myParentBO.mullionObjectsV[vc2]).y2cl;
		((Profiles) myParentBO.mullionObjectsV[vc]).y1al = ((Profiles) myParentBO.mullionObjectsV[vc2]).y1al;

		((Profiles) myParentBO.mullionObjectsV[vc]).centerYs = ((Profiles) myParentBO.mullionObjectsV[vc2]).centerYs;

		((Profiles) myParentBO.mullionObjectsV[vc]).startPos = ((Profiles) myParentBO.mullionObjectsV[vc2]).startPos;
		((Profiles) myParentBO.mullionObjectsV[vc]).endTypeLT = ((Profiles) myParentBO.mullionObjectsV[vc2]).endTypeLT;

		((Profiles) myParentBO.mullionObjectsV[vc]).length = ((Profiles) myParentBO.mullionObjectsV[vc]).centerYe
				- ((Profiles) myParentBO.mullionObjectsV[vc]).centerYs;

		((Profiles) myParentBO.mullionObjectsV[vc]).startIn = startIn;

		if (!((Profiles) myParentBO.mullionObjectsV[vc]).startIn
				&& !((Profiles) myParentBO.mullionObjectsV[vc]).endIn) {
			posCondition = 1;
		} else if (!((Profiles) myParentBO.mullionObjectsV[vc]).startIn
				&& ((Profiles) myParentBO.mullionObjectsV[vc]).endIn) {
			posCondition = 2;
		} else if (((Profiles) myParentBO.mullionObjectsV[vc]).startIn
				&& !((Profiles) myParentBO.mullionObjectsV[vc]).endIn) {
			posCondition = 3;
		} else {
			posCondition = 4;
		}

		((Profiles) myParentBO.mullionObjectsV[vc]).posCondition = posCondition;
		myParentBO.mullionObjectsV[vc] = verifyLimitLR(((Profiles) myParentBO.mullionObjectsV[vc]));

		alreadyExist = 3;

	}

	private void extendBotOfMulliontoBot(int vc) {

		double deltaY3cl = 0;
		double deltaY3 = 0;
		double deltaY4 = 0;
		double deltaY4al = 0;

		if (((Profiles) myParentBO.mullionObjectsV[vc]).endTypeRB == 1) {

			double thetaC = Math
					.atan(((partDimC + partDimB / 2) / (dimBA + dimBM)));
			double thetaA = Math
					.atan(((partDimA + partDimB / 2) / (dimBA + dimBM)));

			deltaY3cl = vcEndY + dimBA;
			deltaY3 = vcEndY - dimBM + partDimB / 2 / Math.tan(thetaA);
			deltaY4 = vcEndY - dimBM + partDimB / 2 / Math.tan(thetaC);

			deltaY4al = vcEndY + dimBA;

			((Profiles) myParentBO.mullionObjectsV[vc]).y3 = deltaY3;
			((Profiles) myParentBO.mullionObjectsV[vc]).y4 = deltaY4;
			((Profiles) myParentBO.mullionObjectsV[vc]).y3cl = deltaY3cl;
			((Profiles) myParentBO.mullionObjectsV[vc]).y4al = deltaY4al;

			((Profiles) myParentBO.mullionObjectsV[vc]).centerYe = ((Profiles) myParentBO.mullionObjectsV[vc]).centerYe
					- (((Profiles) myParentBO.mullionObjectsV[vc]).centerYe - vcEndY)
					- dimBM;

		} else {

			double delta = vcEndY
					- ((Profiles) myParentBO.mullionObjectsV[vc]).y3;
			((Profiles) myParentBO.mullionObjectsV[vc]).y3 = ((Profiles) myParentBO.mullionObjectsV[vc]).y3
					+ delta;
			((Profiles) myParentBO.mullionObjectsV[vc]).y4 = ((Profiles) myParentBO.mullionObjectsV[vc]).y4
					+ delta;
			((Profiles) myParentBO.mullionObjectsV[vc]).y3cl = ((Profiles) myParentBO.mullionObjectsV[vc]).y3cl
					+ delta;
			((Profiles) myParentBO.mullionObjectsV[vc]).y4al = ((Profiles) myParentBO.mullionObjectsV[vc]).y4al
					+ delta;
			((Profiles) myParentBO.mullionObjectsV[vc]).centerYe = ((Profiles) myParentBO.mullionObjectsV[vc]).centerYe
					+ delta;
		}

		((Profiles) myParentBO.mullionObjectsV[vc]).endPos = vcEnd;
		((Profiles) myParentBO.mullionObjectsV[vc]).length = ((Profiles) myParentBO.mullionObjectsV[vc]).centerYe
				- ((Profiles) myParentBO.mullionObjectsV[vc]).centerYs;

		((Profiles) myParentBO.mullionObjectsV[vc]).endIn = endIn;

		if (!((Profiles) myParentBO.mullionObjectsV[vc]).startIn
				&& !((Profiles) myParentBO.mullionObjectsV[vc]).endIn) {
			posCondition = 1;
		} else if (!((Profiles) myParentBO.mullionObjectsV[vc]).startIn
				&& ((Profiles) myParentBO.mullionObjectsV[vc]).endIn) {
			posCondition = 2;
		} else if (((Profiles) myParentBO.mullionObjectsV[vc]).startIn
				&& !((Profiles) myParentBO.mullionObjectsV[vc]).endIn) {
			posCondition = 3;
		} else {
			posCondition = 4;
		}
		((Profiles) myParentBO.mullionObjectsV[vc]).posCondition = posCondition;
		myParentBO.mullionObjectsV[vc] = verifyLimitLR(((Profiles) myParentBO.mullionObjectsV[vc]));

		alreadyExist = 3;

	}

	public Profiles getLimitingObjects(int start, int end, double cX,
			Profiles myMullion) {

		if (myParentBO.mullionsH.size() > 0
				&& myParentBO.mullionObjectsH == null) {
			myParentBO.mullionObjectsH = myParentBO.mullionsH.toArray();
		}
		if (myParentBO.mullions.size() > 0
				&& myParentBO.mullionObjectsV == null) {
			myParentBO.mullionObjectsV = myParentBO.mullions.toArray();
		}

		if (start > 1) {

			for (Object element : myParentBO.mullionObjectsH) {
				if (((Profiles) element).rowCol + 1 == start
						&& ((Profiles) element).x1al < cX
						&& ((Profiles) element).x4al > cX) {

					dimTM = partDimM;
					dimTA = partDimC;

					myMullion.limitStartY1 = (Profiles) element;
					myMullion.limitStartY1a = (Profiles) element;
					myMullion.limitStartY2 = (Profiles) element;
					myMullion.limitStartY2c = (Profiles) element;
					myMullion.limitStartYC = (Profiles) element;

					break;
				}

			}

		}

		if (end < myParentBO.yRows) {
			for (Object element : myParentBO.mullionObjectsH) {
				if (((Profiles) element).rowCol == end
						&& ((Profiles) element).x1al < cX
						&& ((Profiles) element).x4al > cX) {

					dimBM = partDimM;
					dimBA = partDimA;

					myMullion.limitEndY4 = (Profiles) element;
					myMullion.limitEndY4a = (Profiles) element;
					myMullion.limitEndY3 = (Profiles) element;
					myMullion.limitEndY3c = (Profiles) element;
					myMullion.limitEndYC = (Profiles) element;

					break;
				}

			}
		}

		return myMullion;

	}

	public void getPosCondition(int start, int end) {

		if (start == 1) {
			startIn = false;
		} else if (start > 1) {

			startIn = true;
		}

		if (end == myParentBO.yRows || end == 1) {
			endIn = false;
		}
		if (end < myParentBO.yRows) {
			endIn = true;
		}

		if (!startIn && !endIn) {
			posCondition = 1;
		} else if (!startIn && endIn) {
			posCondition = 2;
		} else if (startIn && !endIn) {
			posCondition = 3;
		} else {
			posCondition = 4;
		}

	}

	public void doChangeMullionsV(boolean doOpenings, boolean keepDims)
			throws Exception {

		myParentBO.mullionObjectsV = null;
		myParentBO.mullionObjectsV = myParentBO.mullions.toArray();

		if (myParentBO.mullionObjectsV.length > 0) {

			this.getDimsForMullion(myParentBO.xCols, 2);

			myParentBO.mullions.clear();

			myParentBO.myParent.partObjects.clear();
			myParentBO.myParent.resetParts();

			for (int vc = 0; vc < myParentBO.mullionObjectsV.length; vc++) {
				if (((Profiles) myParentBO.mullionObjectsV[vc]).cOrM == 2) {
					getProfileDims(((Profiles) myParentBO.mullionObjectsV[vc]));
				}
				if (((Profiles) myParentBO.mullionObjectsV[vc]).cOrM == 1) {
					getProfileDims(((Profiles) myParentBO.mullionObjectsV[vc]));
				}
				if (((Profiles) myParentBO.mullionObjectsV[vc]).cOrM == 6) {
					getProfileDims(((Profiles) myParentBO.mullionObjectsV[vc]));
				}

				if (!((Profiles) myParentBO.mullionObjectsV[vc]).startIn
						&& ((Profiles) myParentBO.mullionObjectsV[vc]).myParent.top1.partForm != 1
						|| ((Profiles) myParentBO.mullionObjectsV[vc]).myParent.noSidesTop > 1) {
					if (((Profiles) myParentBO.mullionObjectsV[vc]).endTypeLT == 2) {
						if (((Profiles) myParentBO.mullionObjectsV[vc]).endTypeRB != 2) {
							((Profiles) myParentBO.mullionObjectsV[vc]).endTypeLT = ((Profiles) myParentBO.mullionObjectsV[vc]).endTypeRB;
						} else {
							((Profiles) myParentBO.mullionObjectsV[vc]).endTypeLT = 3;
						}

					}
				}
				if (!((Profiles) myParentBO.mullionObjectsV[vc]).endIn
						&& ((Profiles) myParentBO.mullionObjectsV[vc]).myParent.bot1.partForm != 1
						|| ((Profiles) myParentBO.mullionObjectsV[vc]).myParent.noSidesBot > 1) {
					if (((Profiles) myParentBO.mullionObjectsV[vc]).endTypeRB == 2) {
						if (((Profiles) myParentBO.mullionObjectsV[vc]).endTypeLT != 2) {
							((Profiles) myParentBO.mullionObjectsV[vc]).endTypeRB = ((Profiles) myParentBO.mullionObjectsV[vc]).endTypeLT;
						} else {
							((Profiles) myParentBO.mullionObjectsV[vc]).endTypeRB = 3;

						}

					}
				}

				this.doMullionCalculations(
						((Profiles) myParentBO.mullionObjectsV[vc]), false,
						keepDims);

			}
			myParentBO.mullionObjectsV = myParentBO.mullions.toArray();
			this.recalcHCCoords();
			this.splitParts(null, false, false);

			this.reOrderVNotches();

			if (doOpenings) {
				myParentBO.myParent.doOpenings();
			}
		}
	}

	public void doChangeMullionsVPos() throws Exception {

		// wire = false;

		myParentBO.mullionObjectsV = null;
		myParentBO.mullionObjectsV = myParentBO.mullions.toArray();

		myParentBO.mullions.clear();
		myParentBO.myParent.partObjects.clear();
		myParentBO.myParent.resetParts();
		// this.getDimsForMullion();

		for (Object element : myParentBO.mullionObjectsV) {
			this.doMullionCalculations(((Profiles) element), false, false);
		}
		this.recalcHCCoords();
		this.splitParts(null, false, false);

		myParentBO.myParent.doOpenings();
	}

	public void doMullionCalculations(Profiles myMullion, boolean isNew,
			boolean keepDims) {

		thetaOffset = 0;
		myParentBO.mullionObjectsH = myParentBO.mullionsH.toArray();

		if (cOrM <= 2) {
			this.getNewPositionsXY(myMullion, true, keepDims);
		} else if (cOrM <= 6 && myMullion.isNew) {

			double centerP = partDimB - partDimBtoC;

			if (direction <= 0) {
				myMullion.centerXs = myMullion.centerXe = newStartingXCenter;
				myMullion.x2 = myMullion.x3 = myMullion.centerXs + partDimBtoC;
				myMullion.x2cl = myMullion.x2a = myMullion.x3cl = myMullion.x3a = myMullion.x2
						+ partDimC;
				myMullion.x1 = myMullion.x4 = myMullion.centerXs - (centerP);
				myMullion.x1al = myMullion.x1a = myMullion.x4al = myMullion.x4a = myMullion.x1
						- partDimA;
			}
			if (direction == 1) {
				myMullion.centerXs = myMullion.centerXe = newStartingXCenter
						- partDimB / 2 + partDimBtoC;
				myMullion.x2 = myMullion.x3 = myMullion.centerXs + partDimBtoC;
				myMullion.x2cl = myMullion.x2a = myMullion.x3cl = myMullion.x3a = myMullion.x2
						+ partDimC;
				myMullion.x1 = myMullion.x4 = myMullion.centerXs - (centerP);
				myMullion.x1al = myMullion.x1a = myMullion.x4al = myMullion.x4a = myMullion.x1
						- partDimA;
			} else if (direction == 2) {
				myMullion.centerXs = myMullion.centerXe = newStartingXCenter
						+ partDimB / 2 - partDimBtoC;
				myMullion.x2 = myMullion.x3 = myMullion.centerXs + centerP;
				myMullion.x2cl = myMullion.x2a = myMullion.x3cl = myMullion.x3a = myMullion.x2
						+ partDimA;
				myMullion.x1 = myMullion.x4 = myMullion.centerXs - partDimBtoC;
				myMullion.x1al = myMullion.x1a = myMullion.x4al = myMullion.x4a = myMullion.x1
						- partDimC;
			}

		} else if (cOrM == 7 && myMullion.isNew) {
			myMullion.centerXs = myMullion.centerXe = newStartingXCenter
					+ partDimBtoC;
			myMullion.x2 = myMullion.x3 = myMullion.centerXs + partDimB / 2;
			myMullion.x2cl = myMullion.x3cl = myMullion.x2 + partDimC;
			myMullion.x1 = myMullion.x4 = myMullion.centerXs - partDimB / 2;
			myMullion.x1al = myMullion.x4al = myMullion.x1 - partDimA;
		}

		if (myMullion.posCondition == 2 || myMullion.posCondition == 3
				|| myMullion.posCondition == 4) {
			for (Object element : myParentBO.mullionObjectsH) {
				if (((Profiles) element).rowCol == vcEnd + 1) {

					if (myMullion.x4al <= Math.max(((Profiles) element).x2cl,
							((Profiles) element).x1al)
							|| myMullion.x3cl >= Math.min(
									((Profiles) element).x3cl,
									((Profiles) element).x4al)) {
					}
				}
			}
		}
		if (myMullion.posCondition == 2 || myMullion.posCondition == 3
				|| myMullion.posCondition == 4) {
			for (Object element : myParentBO.mullionObjectsH) {
				if (((Profiles) element).rowCol == newVCRow - 1) {
					if (myMullion.x1al <= Math.max(((Profiles) element).x2cl,
							((Profiles) element).x1al)
							|| myMullion.x2cl >= Math.min(
									((Profiles) element).x3cl,
									((Profiles) element).x4al)) {
					}
				}
			}
		}

		this.verifyLimitLR(myMullion);

		if (myMullion.isValid) {
			calcMullion.calculateCoord(myMullion);
			myMullion.length = Math
					.abs(myMullion.centerYe - myMullion.centerYs);
			myMullion.isNew = false;
		}

		if (!myMullion.isValid) {
			myMullion.length = 0;
			myParentBO.mullions.add(myMullion);
			JOptionPane.showMessageDialog(null,
					"Invalid Mullion Position Encountered!", "Warning!",
					JOptionPane.WARNING_MESSAGE);

		} else {
			if (myMullion.rowCol == newVCCol && myMullion.startPos == newVCRow
					&& myMullion.endPos == vcEnd && isNew) {
				myMullion.exists = alreadyExist;
				myMullion.potentialS = false;
			}
			myMullion.potentialS = false;
			myMullion.profileSelected = 0;
			myParentBO.contentIn = 0;
			myParentBO.contentMid = 0;
			myParentBO.contentOut = 0;
			myParentBO.myGlassIn = null;
			myParentBO.myGlassMid = null;
			myParentBO.myGlassOut = null;

			if (myFrame2.jobItem.myCanvas != null) {
				myFrame2.jobItem.myCanvas.mySelectedFrame = myParentBO.myParent;
			}
			if (isNew) {

				myParentBO.mullion = myMullion;

			}

			myMullion.length = Math
					.sqrt(Math.pow((Math.max(myMullion.centerXe,
							myMullion.centerXs) - Math.min(myMullion.centerXe,
							myMullion.centerXs)), 2)
							+ Math.pow((Math.max(myMullion.centerYe,
									myMullion.centerYs) - Math.min(
									myMullion.centerYe, myMullion.centerYs)), 2));

			myMullion.lengthM = (int) (new BigDecimal(myMullion.length).divide(
					myFrame2.metricscale, 10, BigDecimal.ROUND_UP))
					.doubleValue();

			myMullion.lengthI = (int) (new BigDecimal(myMullion.length).divide(
					myFrame2.imperialscale, 10, BigDecimal.ROUND_UP))
					.doubleValue();

			// Reset and Recalc BOM
			myMullion.bom.clear();
			myMullion.clearBomForProfile();
			myMullion = this.resetRecalcMullionBom(myMullion);

			myParentBO.mullions.add(myMullion);

		}

	}

	public void splitParts(final Profiles myMullion, final boolean joinTop,
			final boolean joinBot) throws Exception {

		if (joinTop || joinBot && myMullion != null) {
			myParentBO.myParent.resetParts();
		}
		boolean splitT = false;
		boolean splitB = false;
		splitT = this.topPartSplit();
		splitB = this.botPartSplit();

		if (myParentBO.myParent.glazedOut) {
			myParentBO.myParent.doGPParts(true);
		} else {
			myParentBO.myParent.doGPParts(false);
		}

		if (splitT || splitB) {
			myParentBO.myParent.bom.clear();
			myParentBO.myParent.clearBomForShape();
			myParentBO.myParent.executePartRules(true, true,
					"addMullionV.splitParts.1633");
		}

	}

	public void joinPartsTop(final Profiles myMullion) {

		myParentBO.mullionObjectsV = myParentBO.mullions.toArray();

		for (final Object MV : myParentBO.mullionObjectsV) {

			final Object[] myParts = myParentBO.myParent.partObjects.toArray();
			if (myMullion.endTypeLT != 2 && !myMullion.startIn
					&& ((Profiles) MV).equals(myMullion)) {

				myParentBO.myParent.partObjects.clear();
				for (final Object tp : myParts) {

					if (((Profiles) tp).position == 1) {
						if (((Profiles) tp).mullionRight.rowCol == myMullion.rowCol) {
							for (final Object tp2 : myParts) {
								if (((Profiles) tp2).mullionLeft.rowCol == myMullion.rowCol) {
									((Profiles) tp2).remove = true;
									((Profiles) tp).endXC = ((Profiles) tp2).endXC;
									((Profiles) tp).endTypeLT = ((Profiles) tp2).endTypeLT;

									((Profiles) tp).endXBA = ((Profiles) tp2).endXBA;

									((Profiles) tp).endXA = ((Profiles) tp2).endXA;

									((Profiles) tp).rightIn = ((Profiles) tp2).rightIn;
									((Profiles) tp).mullionRight = ((Profiles) tp2).mullionRight;

									this.myProfileLength(tp);

								}
							}

						}

					}
					myParentBO.myParent.partObjects.add(tp);
				}
			}
		}

		final Object[] myParts = myParentBO.myParent.partObjects.toArray();
		myParentBO.myParent.partObjects.clear();
		for (final Object tp : myParts) {
			if (((Profiles) tp).position == 1
					&& ((Profiles) tp).mullionLeft.rowCol != myMullion.rowCol) {
				if (!((Profiles) tp).leftIn) {
					((Profiles) tp).seq = 1;
					myParentBO.myParent.partObjects.add(tp);
					// System.out
					// .print("Pos:"
					// + ((Profiles)
					// tp).position
					// + " Seq:"
					// + ((Profiles)
					// tp).seq
					// + " eX:"
					// + ((Profiles)
					// tp).endX
					// + " sX:"
					// + ((Profiles)
					// tp).startX
					// + "\n");
				} else if (((Profiles) tp).leftIn && !((Profiles) tp).rightIn) {
					int i = 0;
					for (final Object tp2 : myParts) {
						if (((Profiles) tp2).position == 1) {
							i++;
						}
					}
					((Profiles) tp).seq = i;
					// System.out
					// .print("Pos:"
					// + ((Profiles)
					// tp).position
					// + " Seq:"
					// + ((Profiles)
					// tp).seq
					// + " eX:"
					// + ((Profiles)
					// tp).endX
					// + " sX:"
					// + ((Profiles)
					// tp).startX
					// + "\n");
					myParentBO.myParent.partObjects.add(tp);
				} else if (((Profiles) tp).leftIn && ((Profiles) tp).rightIn) {
					((Profiles) tp).seq = ((Profiles) tp).mullionRight.rowCol;
					myParentBO.myParent.partObjects.add(tp);
					// System.out
					// .print("Pos:"
					// + ((Profiles)
					// tp).position
					// + " Seq:"
					// + ((Profiles)
					// tp).seq
					// + " eX:"
					// + ((Profiles)
					// tp).endX
					// + " sX:"
					// + ((Profiles)
					// tp).startX
					// + "\n");
				} else {
					((Profiles) tp).seq = 1;
					myParentBO.myParent.partObjects.add(tp);
					// System.out
					// .print("Pos:"
					// + ((Profiles)
					// tp).position
					// + " Seq:"
					// + ((Profiles)
					// tp).seq
					// + " eX:"
					// + ((Profiles)
					// tp).endX
					// + " sX:"
					// + ((Profiles)
					// tp).startX
					// + "\n");
				}

			} else if (((Profiles) tp).mullionLeft.rowCol != myMullion.rowCol) {
				// System.out.print("Pos:"
				// + ((Profiles)
				// tp).position
				// + " Seq:"
				// + ((Profiles) tp).seq
				// + " eX:"
				// + ((Profiles) tp).endX
				// + " sX:"
				// + ((Profiles) tp).startX
				// + "\n");
				myParentBO.myParent.partObjects.add(tp);

			}

		}

		myParentBO.myParent.setnoParts();
		if (myParentBO.myParent.glazedOut) {
			myParentBO.myParent.doGPParts(true);
		} else {
			myParentBO.myParent.doGPParts(false);
		}

	}

	public void joinPartsBot(final Profiles myMullion) {

		for (final Object MV : myParentBO.mullionObjectsV) {

			final Object[] myParts = myParentBO.myParent.partObjects.toArray();
			if (myMullion.endTypeRB != 2 && !myMullion.endIn
					&& ((Profiles) MV).equals(myMullion)) {

				myParentBO.myParent.partObjects.clear();
				for (final Object tp : myParts) {

					if (((Profiles) tp).position == 6) {
						if (((Profiles) tp).mullionLeft == myMullion) {
							for (final Object tp2 : myParts) {
								if (((Profiles) tp2).mullionRight == myMullion) {
									((Profiles) tp2).remove = true;
									((Profiles) tp).endXC = ((Profiles) tp2).endXC;
									((Profiles) tp).endTypeLT = ((Profiles) tp2).endTypeLT;

									((Profiles) tp).endXBA = ((Profiles) tp2).endXBA;

									((Profiles) tp).endXA = ((Profiles) tp2).endXA;

									((Profiles) tp).leftIn = ((Profiles) tp2).leftIn;
									((Profiles) tp).mullionLeft = ((Profiles) tp2).mullionLeft;

									this.myProfileLength(tp);

								}
							}

						}

					}
					myParentBO.myParent.partObjects.add(tp);
				}
			}
		}

		final Object[] myParts = myParentBO.myParent.partObjects.toArray();
		myParentBO.myParent.partObjects.clear();
		for (final Object tp : myParts) {

			if (((Profiles) tp).position == 6
					&& ((Profiles) tp).mullionRight != myMullion) {
				if (!((Profiles) tp).rightIn) {
					((Profiles) tp).seq = 1;
					myParentBO.myParent.partObjects.add(tp);

				} else if (((Profiles) tp).rightIn && !((Profiles) tp).leftIn) {
					int i = 0;
					for (final Object tp2 : myParts) {
						if (((Profiles) tp2).position == 3) {
							i++;
						}
					}
					((Profiles) tp).seq = i;

					myParentBO.myParent.partObjects.add(tp);
				} else if (((Profiles) tp).rightIn && ((Profiles) tp).leftIn) {

					myParentBO.myParent.partObjects.add(tp);

				} else {
					((Profiles) tp).seq = 1;
					myParentBO.myParent.partObjects.add(tp);

				}

			} else if (((Profiles) tp).mullionRight != myMullion) {

				myParentBO.myParent.partObjects.add(tp);
			}

		}

		myParentBO.myParent.setnoParts();
		if (myParentBO.myParent.glazedOut) {
			myParentBO.myParent.doGPParts(true);
		} else {
			myParentBO.myParent.doGPParts(false);
		}

	}

	public boolean topPartSplit() {

		Profiles myMullion;
		myParentBO.mullionObjectsV = myParentBO.mullions.toArray();

		boolean split = false;

		for (final Object MV : myParentBO.mullionObjectsV) {
			myMullion = (Profiles) MV;
			final Object[] myParts = myParentBO.myParent.partObjects.toArray();
			if (myMullion.endTypeLT == 2 && !myMullion.startIn) {

				myParentBO.myParent.partObjects.clear();
				for (final Object tp : myParts) {

					if (((Profiles) tp).position == 1) {
						if (((Profiles) tp).startXC < myMullion.x1al
								&& ((Profiles) tp).endXC > myMullion.x2cl) {
							if (((Profiles) tp).partForm == 1) {
								Profiles newTop = new Profiles();
								newTop = (Profiles) newTop
										.cloneProfile(((Profiles) tp));

								final Profiles myTop = (Profiles) newTop
										.cloneProfile(((Profiles) tp));

								if (!((Profiles) tp).leftIn
										&& !((Profiles) tp).rightIn) {

									doExistingTopLROut(myMullion, tp);

									doNewTopLROut(myMullion, newTop, myTop);

								} else if (!((Profiles) tp).leftIn
										&& ((Profiles) tp).rightIn) {

									doExistingTopLOutRightIn(myMullion, tp);

									doNewTopLOutRIn(myMullion, newTop, myTop);

								} else if (((Profiles) tp).leftIn
										&& ((Profiles) tp).rightIn) {

									doExistingTopLRIn(myMullion, tp);

									doNewTopLRIn(myMullion, newTop, myTop);

								} else if (((Profiles) tp).leftIn
										&& !((Profiles) tp).rightIn) {
									doExistingTopLInROut(myMullion, tp);

									doNewTopLInROut(myMullion, newTop, myTop);

								}

							}
							split = true;
						} else {
							myParentBO.myParent.partObjects.add(tp);
						}
					}// top1
					else {
						myParentBO.myParent.partObjects.add(tp);
					}
				}
			}

		}

		final Object[] myParts = myParentBO.myParent.partObjects.toArray();
		myParentBO.myParent.partObjects.clear();

		double minDeltab = 100000000;
		double startX = 0;
		int noParts = 0;
		for (final Object tp : myParts) {
			if (((Profiles) tp).position == 1) {
				noParts++;
			}
		}

		for (final Object tp : myParts) {
			if (((Profiles) tp).position != 1) {
				myParentBO.myParent.partObjects.add(tp);
			} else {
				if (!((Profiles) tp).leftIn) {
					startX = ((Profiles) tp).endXC;
					((Profiles) tp).seq = 1;
					((Profiles) tp).deltaX = 0;
				} else {
					((Profiles) tp).seq = 0;
					((Profiles) tp).deltaX = ((Profiles) tp).endXC - startX;
					if (((Profiles) tp).deltaX < minDeltab) {
						minDeltab = ((Profiles) tp).deltaX;
						for (final Object tp2 : myParts) {
							if (((Profiles) tp).deltaX == minDeltab) {
								((Profiles) tp).seq = noParts - 1;

								if (!((Profiles) tp).rightIn) {
									((Profiles) tp).seq = noParts;
								}
								noParts = noParts - 1;
								break;
							}
						}
					}
				}
				myParentBO.myParent.partObjects.add(tp);
			}

		}

		myParentBO.myParent.setnoParts();
		if (myParentBO.myParent.glazedOut) {
			myParentBO.myParent.doGPParts(true);
		} else {
			myParentBO.myParent.doGPParts(false);
		}

		return split;
	}

	public void doExistingTopLInROut(final Profiles myMullion, Object tp) {

		((Profiles) tp).endTypeLT = 3;

		final double[] myRes = this.myProfileEndIn(myMullion, tp);
		((Profiles) tp).endXC = ((Profiles) tp).endX = myRes[0];
		((Profiles) tp).endYC = ((Profiles) tp).endY = myRes[1];
		((Profiles) tp).endXBA = myRes[2];
		((Profiles) tp).endYBA = myRes[3];
		((Profiles) tp).endXA = myRes[4];
		((Profiles) tp).endYA = myRes[5];

		((Profiles) tp).rightIn = true;
		((Profiles) tp).mullionRight = myMullion;
		tp = this.newTopLength(((Profiles) tp));
		myParentBO.myParent.partObjects.add(tp);
	}

	public void doNewTopLInROut(final Profiles myMullion, Profiles newTop,
			final Object tp) {

		newTop.mullionLeft = myMullion;
		newTop.mullionRight = null;
		newTop.endTypeRB = 3;

		final double[] myResl = this.newTopLeftIn(myMullion, newTop);
		newTop.startXC = newTop.startX = newTop.startingX = myResl[0];
		newTop.startYC = newTop.startY = newTop.startingY = myResl[1];
		newTop.startXBA = newTop.startingXBA = myResl[2];
		newTop.startYBA = newTop.startingYBA = myResl[3];
		newTop.startXA = newTop.startingXA = myResl[4];
		newTop.startYA = newTop.startingYA = myResl[5];
		newTop.leftIn = true;
		newTop.rightIn = false;
		newTop = this.newTopLength(newTop);
		myParentBO.myParent.partObjects.add(newTop);
	}

	public void doExistingTopLRIn(final Profiles myMullion, Object tp) {

		double[] myRes;
		((Profiles) tp).endTypeLT = 3;

		myRes = this.myProfileEndIn(myMullion, tp);
		((Profiles) tp).endXC = ((Profiles) tp).endX = myRes[0];
		((Profiles) tp).endYC = ((Profiles) tp).endY = myRes[1];
		((Profiles) tp).endXBA = myRes[2];
		((Profiles) tp).endYBA = myRes[3];
		((Profiles) tp).endXA = myRes[4];
		((Profiles) tp).endYA = myRes[5];

		((Profiles) tp).rightIn = true;

		((Profiles) tp).mullionRight = myMullion;

		tp = this.newTopLength(((Profiles) tp));

		myParentBO.myParent.partObjects.add(tp);
	}

	public void doNewTopLRIn(final Profiles myMullion, Profiles newTop,
			Object tp) {

		final Profiles myRM = ((Profiles) tp).mullionRight;

		newTop.mullionLeft = myMullion;
		newTop.mullionRight = myRM;
		newTop.endTypeRB = 3;

		final double[] myRes = this.newTopLeftIn(myMullion, newTop);
		newTop.startXC = newTop.startX = newTop.startingX = myRes[0];
		newTop.startYC = newTop.startY = newTop.startingY = myRes[1];
		newTop.startXBA = newTop.startingXBA = myRes[2];
		newTop.startYBA = newTop.startingYBA = myRes[3];
		newTop.startXA = newTop.startingXA = myRes[4];
		newTop.startYA = newTop.startingYA = myRes[5];
		newTop.leftIn = true;

		newTop.endTypeLT = 3;

		final double[] myResE = this.newTopRightIn(myRM, newTop);

		((Profiles) tp).endXC = ((Profiles) tp).endX = myRes[0];
		((Profiles) tp).endYC = ((Profiles) tp).endY = myRes[1];
		newTop.endXBA = myResE[2];
		newTop.endYBA = myResE[3];
		newTop.endXA = myResE[4];
		newTop.endYA = myResE[5];

		newTop.rightIn = true;
		newTop.seq = 0;

		newTop = this.newTopLength(newTop);

		myParentBO.myParent.partObjects.add(newTop);
	}

	public void doExistingTopLOutRightIn(final Profiles myMullion, Object tp) {

		double[] myRes;

		((Profiles) tp).endTypeLT = 3;

		myRes = myProfileEndIn(myMullion, tp);
		((Profiles) tp).endXC = ((Profiles) tp).endX = myRes[0];
		((Profiles) tp).endYC = ((Profiles) tp).endY = myRes[1];
		((Profiles) tp).endXBA = myRes[2];
		((Profiles) tp).endYBA = myRes[3];
		((Profiles) tp).endXA = myRes[4];
		((Profiles) tp).endYA = myRes[5];

		((Profiles) tp).rightIn = true;
		((Profiles) tp).mullionRight = myMullion;
		((Profiles) tp).seq = 1;
		tp = this.newTopLength(((Profiles) tp));
		myParentBO.myParent.partObjects.add(tp);
	}

	public Profiles doNewTopLOutRIn(final Profiles myMullion, Profiles newTop,
			Object tp) {

		final Profiles myRM = ((Profiles) tp).mullionRight;

		newTop.mullionLeft = myMullion;
		newTop.mullionRight = myRM;
		newTop.endTypeRB = 3;
		newTop.endTypeLT = 3;

		final double[] myResS = this.newTopLeftIn(myMullion, newTop);

		newTop.startXC = newTop.startX = newTop.startingX = myResS[0];
		newTop.startYC = newTop.startY = newTop.startingY = myResS[1];
		newTop.startXBA = newTop.startingXBA = myResS[2];
		newTop.startYBA = newTop.startingYBA = myResS[3];
		newTop.startXA = newTop.startingXA = myResS[4];
		newTop.startYA = newTop.startingYA = myResS[5];

		newTop.leftIn = true;

		final double[] myResE = this.newTopRightIn(myRM, newTop);

		newTop.endXC = myResE[0];
		newTop.endYC = myResE[1];
		newTop.endXBA = myResE[2];
		newTop.endYBA = myResE[3];
		newTop.endXA = myResE[4];
		newTop.endYA = myResE[5];

		newTop.rightIn = true;
		newTop.seq = 0;

		newTop = this.newTopLength(newTop);
		myParentBO.myParent.partObjects.add(newTop);
		return newTop;
	}

	public void doExistingTopLROut(final Profiles myMullion, final Object tp) {

		final double[] myRes;
		((Profiles) tp).endTypeLT = 3;
		myRes = this.myProfileEndIn(myMullion, tp);

		((Profiles) tp).endXC = ((Profiles) tp).endX = myRes[0];
		((Profiles) tp).endYC = ((Profiles) tp).endY = myRes[1];
		((Profiles) tp).endXBA = myRes[2];
		((Profiles) tp).endYBA = myRes[3];
		((Profiles) tp).endXA = myRes[4];
		((Profiles) tp).endYA = myRes[5];

		((Profiles) tp).rightIn = true;
		((Profiles) tp).mullionRight = myMullion;
		((Profiles) tp).seq = 1;

		((Profiles) tp).length = this.myProfileLength(tp);
		myParentBO.myParent.partObjects.add(tp);
	}

	public void doNewTopLROut(final Profiles myMullion, Profiles newTop,
			final Object tp) {

		newTop.mullionLeft = myMullion;
		newTop.endTypeRB = 3;
		final double[] myRes = this.newTopLeftIn(myMullion, newTop);

		newTop.startXC = newTop.startX = newTop.startingX = myRes[0];
		newTop.startYC = newTop.startY = newTop.startingY = myRes[1];
		newTop.startXBA = newTop.startingXBA = myRes[2];
		newTop.startYBA = newTop.startingYBA = myRes[3];
		newTop.startXA = newTop.startingXA = myRes[4];
		newTop.startYA = newTop.startingYA = myRes[5];

		newTop.leftIn = true;
		newTop.seq = 0;

		newTop = this.newTopLength(newTop);
		myParentBO.myParent.partObjects.add(newTop);
	}

	public boolean botPartSplit() {

		Profiles myMullion;
		myParentBO.mullionObjectsV = myParentBO.mullions.toArray();

		boolean split = false;

		for (final Object MV : myParentBO.mullionObjectsV) {
			myMullion = (Profiles) MV;
			final Object[] myParts = myParentBO.myParent.partObjects.toArray();
			if (myMullion.endTypeRB == 2 && !myMullion.endIn) {

				myParentBO.myParent.partObjects.clear();
				for (Object tp : myParts) {
					if (((Profiles) tp).position == 5) {
						if (((Profiles) tp).endXC < myMullion.x4al
								&& ((Profiles) tp).startXC > myMullion.x3cl) {
							if (((Profiles) tp).partForm == 1) {
								if (!((Profiles) tp).leftIn
										&& !((Profiles) tp).rightIn) {
									// ///// Create and modify+Calc new
									// Bot Profile ////////
									Profiles newBot = new Profiles();

									newBot = (Profiles) newBot
											.cloneProfile(((Profiles) tp));

									newBot.mullionRight = myMullion;
									newBot.endTypeRB = 3;

									final double[] myRes = this.newBotRightIn(
											myMullion, newBot);
									newBot.startXC = newBot.startX = newBot.startingX = myRes[0];
									newBot.startYC = newBot.startY = newBot.startingY = myRes[1];
									newBot.startXBA = newBot.startingXBA = myRes[2];
									newBot.startYBA = newBot.startingYBA = myRes[3];
									newBot.startXA = newBot.startingXA = myRes[4];
									newBot.startYA = newBot.startingYA = myRes[5];

									newBot.rightIn = true;
									newBot.seq = 0;

									newBot = this.newTopLength(newBot);

									myParentBO.myParent.partObjects.add(newBot);
									// ////// Modify Existing Bot
									// Profile///////
									((Profiles) tp).endTypeLT = 3;
									final double[] myResbl = this.myBotLeftIn(
											myMullion, ((Profiles) tp));

									((Profiles) tp).endXC = ((Profiles) tp).endX = myResbl[0];

									((Profiles) tp).endYC = ((Profiles) tp).endY = myResbl[1];

									((Profiles) tp).endXBA = myResbl[2];

									((Profiles) tp).endYBA = myResbl[3];

									((Profiles) tp).endXA = myResbl[4];

									((Profiles) tp).endYA = myResbl[5];

									((Profiles) tp).leftIn = true;
									((Profiles) tp).mullionLeft = myMullion;
									((Profiles) tp).seq = 1;

									tp = this.newTopLength(((Profiles) tp));

									this.myProfileLength(tp);
									myParentBO.myParent.partObjects.add(tp);

								} else if (((Profiles) tp).leftIn
										&& !((Profiles) tp).rightIn) {
									// ///// Create and modify+Calc new
									// Bot Profile ////////
									final Profiles myLM = ((Profiles) tp).mullionLeft;

									Profiles newBot = new Profiles();

									newBot = (Profiles) newBot
											.cloneProfile(((Profiles) tp));

									newBot.mullionRight = myMullion;
									newBot.mullionLeft = myLM;
									newBot.endTypeRB = 3;

									final double[] myRes = this.newBotRightIn(
											myMullion, newBot);
									newBot.startXC = newBot.startX = newBot.startingX = myRes[0];
									newBot.startYC = newBot.startY = newBot.startingY = myRes[1];
									newBot.startXBA = newBot.startingXBA = myRes[2];
									newBot.startYBA = newBot.startingYBA = myRes[3];
									newBot.startXA = newBot.startingXA = myRes[4];
									newBot.startYA = newBot.startingYA = myRes[5];
									newBot.seq = 0;
									newBot.rightIn = true;

									newBot.leftIn = true;

									newBot.endTypeLT = 3;

									newBot = this.newTopLength(newBot);

									myParentBO.myParent.partObjects.add(newBot);

									// ////// Modify Existing Bot
									// Profile///////
									double[] myResbl = this.myBotLeftIn(myLM,
											newBot);

									((Profiles) tp).endXC = ((Profiles) tp).endX = myResbl[0];

									((Profiles) tp).endYC = ((Profiles) tp).endY = myResbl[1];

									((Profiles) tp).endXBA = myResbl[2];

									((Profiles) tp).endYBA = myResbl[3];

									((Profiles) tp).endXA = myResbl[4];

									((Profiles) tp).endYA = myResbl[5];

									((Profiles) tp).endTypeLT = 3;

									myResbl = this.myBotLeftIn(myMullion,
											((Profiles) tp));

									((Profiles) tp).endXC = ((Profiles) tp).endX = myResbl[0];

									((Profiles) tp).endYC = ((Profiles) tp).endY = myResbl[1];

									((Profiles) tp).endXBA = myResbl[2];

									((Profiles) tp).endYBA = myResbl[3];

									((Profiles) tp).endXA = myResbl[4];

									((Profiles) tp).endYA = myResbl[5];

									((Profiles) tp).leftIn = true;
									((Profiles) tp).mullionLeft = myMullion;
									((Profiles) tp).seq = 1;

									tp = this.newTopLength(((Profiles) tp));

									this.myProfileLength(tp);
									myParentBO.myParent.partObjects.add(tp);

								} else if (((Profiles) tp).leftIn
										&& ((Profiles) tp).rightIn) {

									// ///// Create and modify+Calc new
									// Bot Profile ////////

									final Profiles myLM = ((Profiles) tp).mullionLeft;
									Profiles newBot = new Profiles();

									newBot = (Profiles) newBot
											.cloneProfile(((Profiles) tp));

									newBot.mullionRight = myMullion;
									newBot.mullionLeft = myLM;
									newBot.endTypeRB = 3;
									final double[] myRes = this.newBotRightIn(
											myMullion, newBot);

									newBot.startXC = newBot.startX = newBot.startingX = myRes[0];
									newBot.startYC = newBot.startY = newBot.startingY = myRes[1];
									newBot.startXBA = newBot.startingXBA = myRes[2];
									newBot.startYBA = newBot.startingYBA = myRes[3];
									newBot.startXA = newBot.startingXA = myRes[4];
									newBot.startYA = newBot.startingYA = myRes[5];

									newBot.rightIn = true;

									newBot.endTypeLT = 3;

									newBot.leftIn = true;
									newBot.seq = 0;

									newBot = this.newTopLength(newBot);
									myParentBO.myParent.partObjects.add(newBot);

									// ////// Modify Existing Bot
									// Profile///////

									double[] myResbl = this.myBotLeftIn(myLM,
											newBot);

									((Profiles) tp).endXC = ((Profiles) tp).endX = myResbl[0];

									((Profiles) tp).endYC = ((Profiles) tp).endY = myResbl[1];

									((Profiles) tp).endXBA = myResbl[2];

									((Profiles) tp).endYBA = myResbl[3];

									((Profiles) tp).endXA = myResbl[4];

									((Profiles) tp).endYA = myResbl[5];

									((Profiles) tp).endTypeLT = 3;

									myResbl = this.myBotLeftIn(myMullion,
											((Profiles) tp));

									((Profiles) tp).endXC = ((Profiles) tp).endX = myResbl[0];

									((Profiles) tp).endYC = ((Profiles) tp).endY = myResbl[1];

									((Profiles) tp).endXBA = myResbl[2];

									((Profiles) tp).endYBA = myResbl[3];

									((Profiles) tp).endXA = myResbl[4];

									((Profiles) tp).endYA = myResbl[5];

									((Profiles) tp).leftIn = true;
									((Profiles) tp).mullionLeft = myMullion;
									tp = this.newTopLength(((Profiles) tp));
									myParentBO.myParent.partObjects.add(tp);

								} else if (!((Profiles) tp).leftIn
										&& ((Profiles) tp).rightIn) {
									// ///// Create and modify+Calc new
									// Bot Profile ////////
									Profiles newBot = new Profiles();

									newBot = (Profiles) newBot
											.cloneProfile(((Profiles) tp));

									newBot.mullionRight = myMullion;
									newBot.mullionLeft = null;
									newBot.endTypeRB = 3;

									final double[] myRes = this.newBotRightIn(
											myMullion, newBot);

									newBot.startXC = newBot.startX = newBot.startingX = myRes[0];
									newBot.startYC = newBot.startY = newBot.startingY = myRes[1];
									newBot.startXBA = newBot.startingXBA = myRes[2];
									newBot.startYBA = newBot.startingYBA = myRes[3];
									newBot.startXA = newBot.startingXA = myRes[4];
									newBot.startYA = newBot.startingYA = myRes[5];

									newBot.rightIn = true;
									newBot = this.newTopLength(newBot);
									myParentBO.myParent.partObjects.add(newBot);

									((Profiles) tp).endTypeLT = 3;
									final double[] myResbl = this.myBotLeftIn(
											myMullion, ((Profiles) tp));

									((Profiles) tp).endXC = ((Profiles) tp).endX = myResbl[0];

									((Profiles) tp).endYC = ((Profiles) tp).endY = myResbl[1];

									((Profiles) tp).endXBA = myResbl[2];

									((Profiles) tp).endYBA = myResbl[3];

									((Profiles) tp).endXA = myResbl[4];

									((Profiles) tp).endYA = myResbl[5];

									((Profiles) tp).leftIn = true;
									((Profiles) tp).mullionLeft = myMullion;
									tp = this.newTopLength(((Profiles) tp));
									myParentBO.myParent.partObjects.add(tp);

								}

							}

							split = true;
						} else {
							myParentBO.myParent.partObjects.add(tp);
						}
					}// top1
					else {
						myParentBO.myParent.partObjects.add(tp);
					}
				}
			}

		}

		final Object[] myParts = myParentBO.myParent.partObjects.toArray();
		myParentBO.myParent.partObjects.clear();

		double minDeltab = 100000000;
		double startX = 0;
		int noParts = 0;
		for (final Object tp : myParts) {
			if (((Profiles) tp).position == 5) {
				noParts++;
			}
		}
		// need to verify Loop
		for (final Object tp : myParts) {
			if (((Profiles) tp).position != 5) {
				myParentBO.myParent.partObjects.add(tp);
			} else {
				if (!((Profiles) tp).leftIn) {
					startX = ((Profiles) tp).endXC;
					((Profiles) tp).seq = 1;
					((Profiles) tp).deltaX = 0;
				} else {
					((Profiles) tp).seq = 0;
					((Profiles) tp).deltaX = ((Profiles) tp).endXC - startX;
					if (((Profiles) tp).deltaX < minDeltab) {
						minDeltab = ((Profiles) tp).deltaX;
						for (final Object tp2 : myParts) {
							if (((Profiles) tp).deltaX == minDeltab) {
								((Profiles) tp).seq = noParts;
								if (!((Profiles) tp).rightIn) {
									((Profiles) tp).seq = noParts;
								}
								noParts = noParts - 1;
								break;
							}
						}
					}
				}
				myParentBO.myParent.partObjects.add(tp);
			}

		}

		myParentBO.myParent.setnoParts();

		return split;
	}

	public Profiles newTopLength(final Profiles newTop) {

		newTop.length = Math.sqrt(Math.pow((Math.max(newTop.endXC,
				newTop.startXC) - Math.min(newTop.endXC, newTop.startXC)), 2)
				+ Math.pow((Math.max(newTop.endYC, newTop.startYC) - Math.min(
						newTop.endYC, newTop.startYC)), 2));

		newTop.lengthM = (int) (new BigDecimal(newTop.length).divide(
				myFrame2.metricscale, 10, BigDecimal.ROUND_UP)).doubleValue();

		newTop.lengthI = (int) (new BigDecimal(newTop.length).divide(
				myFrame2.imperialscale, 10, BigDecimal.ROUND_UP)).doubleValue();

		return newTop;
	}

	public double myProfileLength(final Object tp) {

		final double l = Math
				.sqrt(Math.pow((Math.max(((Profiles) tp).endXC,
						((Profiles) tp).startXC) - Math.min(
						((Profiles) tp).endXC, ((Profiles) tp).startXC)), 2)
						+ Math.pow(
								(Math.max(((Profiles) tp).endYC,
										((Profiles) tp).startYC) - Math.min(
										((Profiles) tp).endYC,
										((Profiles) tp).startYC)), 2));

		return l;
	}

	public double[] myProfileEndIn(final Profiles myMullion, final Object tp) {

		final double[] myRes = new double[6];

		final double newendX = this.intersectX(((Profiles) tp).startXC,
				((Profiles) tp).startYC, ((Profiles) tp).endXC,
				((Profiles) tp).endYC, myMullion.x1, myMullion.y1,
				myMullion.x4, myMullion.y4);

		final double newendY = this.intersectY(((Profiles) tp).startXC,
				((Profiles) tp).startYC, ((Profiles) tp).endXC,
				((Profiles) tp).endYC, myMullion.x1, myMullion.y1,
				myMullion.x4, myMullion.y4);

		final double newendXBA = this.intersectX(((Profiles) tp).startXBA,
				((Profiles) tp).startYBA, ((Profiles) tp).endXBA,
				((Profiles) tp).endYBA, myMullion.x1, myMullion.y1,
				myMullion.x4, myMullion.y4);

		final double newendYBA = this.intersectY(((Profiles) tp).startXBA,
				((Profiles) tp).startYBA, ((Profiles) tp).endXBA,
				((Profiles) tp).endYBA, myMullion.x1, myMullion.y1,
				myMullion.x4, myMullion.y4);

		final double newendXA = this.intersectX(((Profiles) tp).startXA,
				((Profiles) tp).startYA, ((Profiles) tp).endXA,
				((Profiles) tp).endYA, myMullion.x1, myMullion.y1,
				myMullion.x4, myMullion.y4);

		final double newendYA = this.intersectY(((Profiles) tp).startXA,
				((Profiles) tp).startYA, ((Profiles) tp).endXA,
				((Profiles) tp).endYA, myMullion.x1, myMullion.y1,
				myMullion.x4, myMullion.y4);

		myRes[0] = newendX;

		myRes[1] = newendY;

		myRes[2] = newendXBA;

		myRes[3] = newendYBA;

		myRes[4] = newendXA;

		myRes[5] = newendYA;

		return myRes;

	}

	public double[] newTopRightIn(final Profiles myRM, final Profiles newTop) {

		final double[] myRes = new double[6];
		final double newendX = this.intersectX(newTop.startXC, newTop.startYC,
				newTop.endXC, newTop.endYC, myRM.x1, myRM.y1, myRM.x4, myRM.y4);

		final double newendY = this.intersectY(newTop.startXC, newTop.startYC,
				newTop.endXC, newTop.endYC, myRM.x1, myRM.y1, myRM.x4, myRM.y4);

		final double newendXBA = this.intersectX(newTop.startXBA,
				newTop.startYBA, newTop.endXBA, newTop.endYBA, myRM.x1,
				myRM.y1, myRM.x4, myRM.y4);

		final double newendYBA = this.intersectY(newTop.startXBA,
				newTop.startYBA, newTop.endXBA, newTop.endYBA, myRM.x1,
				myRM.y1, myRM.x4, myRM.y4);

		final double newendXA = this.intersectX(newTop.startXA, newTop.startYA,
				newTop.endXA, newTop.endYA, myRM.x1, myRM.y1, myRM.x4, myRM.y4);

		final double newendYA = this.intersectY(newTop.startXA, newTop.startYA,
				newTop.endXA, newTop.endYA, myRM.x1, myRM.y1, myRM.x4, myRM.y4);

		myRes[0] = newendX;

		myRes[1] = newendY;

		myRes[2] = newendXBA;

		myRes[3] = newendYBA;

		myRes[4] = newendXA;

		myRes[5] = newendYA;

		return myRes;
	}

	public double[] newTopLeftIn(final Profiles myMullion, final Profiles newTop) {

		final double[] myRes = new double[6];
		final double newstartX = this.intersectX(newTop.startXC,
				newTop.startYC, newTop.endXC, newTop.endYC, myMullion.x2,
				myMullion.y2, myMullion.x3, myMullion.y3);

		final double newstartY = this.intersectY(newTop.startXC,
				newTop.startYC, newTop.endXC, newTop.endYC, myMullion.x2,
				myMullion.y2, myMullion.x3, myMullion.y3);

		final double newstartXBA = this.intersectX(newTop.startXBA,
				newTop.startYBA, newTop.endXBA, newTop.endYBA, myMullion.x2,
				myMullion.y2, myMullion.x3, myMullion.y3);

		final double newstartYBA = this.intersectY(newTop.startXBA,
				newTop.startYBA, newTop.endXBA, newTop.endYBA, myMullion.x2,
				myMullion.y2, myMullion.x3, myMullion.y3);

		final double newstartXA = this.intersectX(newTop.startXA,
				newTop.startYA, newTop.endXA, newTop.endYA, myMullion.x2,
				myMullion.y2, myMullion.x3, myMullion.y3);

		final double newstartYA = this.intersectY(newTop.startXA,
				newTop.startYA, newTop.endXA, newTop.endYA, myMullion.x2,
				myMullion.y2, myMullion.x3, myMullion.y3);

		myRes[0] = newstartX;

		myRes[1] = newstartY;

		myRes[2] = newstartXBA;

		myRes[3] = newstartYBA;

		myRes[4] = newstartXA;

		myRes[5] = newstartYA;

		return myRes;
	}

	public double[] newBotRightIn(final Profiles myMullion,
			final Profiles newBot) {

		final double[] myRes = new double[6];
		final double newstartX = this.intersectX(newBot.startXC,
				newBot.startYC, newBot.endXC, newBot.endYC, myMullion.x1,
				myMullion.y1, myMullion.x4, myMullion.y4);

		final double newstartY = this.intersectY(newBot.startXC,
				newBot.startYC, newBot.endXC, newBot.endYC, myMullion.x1,
				myMullion.y1, myMullion.x4, myMullion.y4);

		final double newstartXBA = this.intersectX(newBot.startXBA,
				newBot.startYBA, newBot.endXBA, newBot.endYBA, myMullion.x1,
				myMullion.y1, myMullion.x4, myMullion.y4);

		final double newstartYBA = this.intersectY(newBot.startXBA,
				newBot.startYBA, newBot.endXBA, newBot.endYBA, myMullion.x1,
				myMullion.y1, myMullion.x4, myMullion.y4);

		final double newstartXA = this.intersectX(newBot.startXA,
				newBot.startYA, newBot.endXA, newBot.endYA, myMullion.x1,
				myMullion.y1, myMullion.x4, myMullion.y4);

		final double newstartYA = this.intersectY(newBot.startXA,
				newBot.startYA, newBot.endXA, newBot.endYA, myMullion.x1,
				myMullion.y1, myMullion.x4, myMullion.y4);

		newBot.startXC = newBot.startX = newstartX;

		newBot.startYC = newBot.startY = newstartY;

		newBot.startXBA = newstartXBA;

		newBot.startYBA = newstartYBA;

		newBot.startXA = newstartXA;

		newBot.startYA = newstartYA;

		myRes[0] = newstartX;

		myRes[1] = newstartY;

		myRes[2] = newstartXBA;

		myRes[3] = newstartYBA;

		myRes[4] = newstartXA;

		myRes[5] = newstartYA;

		return myRes;
	}

	public double[] myBotLeftIn(final Profiles myMullion, final Profiles myBot) {

		final double[] myRes = new double[6];
		final double newendX = this.intersectX(myBot.startXC, myBot.startYC,
				myBot.endXC, myBot.endYC, myMullion.x2, myMullion.y2,
				myMullion.x3, myMullion.y3);

		final double newendY = this.intersectY(myBot.startXC, myBot.startYC,
				myBot.endXC, myBot.endYC, myMullion.x2, myMullion.y2,
				myMullion.x3, myMullion.y3);

		final double newendXBA = this.intersectX(myBot.startXBA,
				myBot.startYBA, myBot.endXBA, myBot.endYBA, myMullion.x2,
				myMullion.y2, myMullion.x3, myMullion.y3);

		final double newendYBA = this.intersectY(myBot.startXBA,
				myBot.startYBA, myBot.endXBA, myBot.endYBA, myMullion.x2,
				myMullion.y2, myMullion.x3, myMullion.y3);

		final double newendXA = this.intersectX(myBot.startXA, myBot.startYA,
				myBot.endXA, myBot.endYA, myMullion.x2, myMullion.y2,
				myMullion.x3, myMullion.y3);

		final double newendYA = this.intersectY(myBot.startXA, myBot.startYA,
				myBot.endXA, myBot.endYA, myMullion.x2, myMullion.y2,
				myMullion.x3, myMullion.y3);

		myRes[0] = newendX;

		myRes[1] = newendY;

		myRes[2] = newendXBA;

		myRes[3] = newendYBA;

		myRes[4] = newendXA;

		myRes[5] = newendYA;

		return myRes;
	}

	public static int getMinValue(final int[] numbers) {

		int maxValue = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] > maxValue) {
				maxValue = numbers[i];
			}
		}
		return maxValue;
	}

	public Profiles getNewPositionsXY(final Profiles myMullion,
			final boolean isNew, final boolean keepDims) {

		// this.setLocalCMPartDims(myMullion);

		this.getSumPrevMullions(myMullion.rowCol, myMullion.endPos);

		iNo = myMullion.rowCol;
		myThick = thickness;
		isValid = myMullion.isValid;

		if (!myMullion.isValid) {
			JOptionPane
					.showMessageDialog(
							null,
							"An Invalid mullion Found!\n"
									+ "The system will Re-test its validity \n accouting for current changes.",
							"Warning!", JOptionPane.WARNING_MESSAGE);

		}

		myMullion.isValid = true;

		double posX = myStartingX + newColW * iNo + sumOfPrevMullions;

		if (keepDims) {
			posX = myMullion.centerXs;

		}
		if (cOrM > 2) {
			posX = newStartingXCenter;
		}

		if (cOrM == 1) {
			// posX = this.getPosXverified(posX);

		}
		if (myMullion.offsetTL != 0 && myMullion.partForm != 3
				&& myMullion.endTypeLT != 3) {
			myMullion.endTypeLT = 3;

		}
		if (myMullion.offsetRB != 0 && myMullion.partForm != 3
				&& myMullion.endTypeRB != 3) {

			myMullion.endTypeRB = 3;
		}
		if (myMullion.endTypeRB == 2) {
			if (myMullion.posCondition == 2

			|| myMullion.posCondition == 4) {

				myMullion.endTypeRB = 3;
			}
		}
		if (myMullion.endTypeLT == 2) {
			if (myMullion.posCondition == 3

			|| myMullion.posCondition == 4) {

				myMullion.endTypeLT = 3;
			}
		}

		final double myD = Math

		.max(myMullion.offsetTL, myMullion.offsetRB)
				- Math.min(myMullion.offsetTL, myMullion.offsetRB);

		if (myMullion.offsetTL != 0) {

			this.getDeltaAndTheta(myMullion, myD);

			final double hypBtoC = partDimBtoC;
			final double hypC = partDimC;
			final double hypB = partDimB;
			final double hypA = partDimA;
			final double offsetXc = 0;
			if (isNew) {
				newStartingXCenter = posX + partDimB - partDimBtoC
						+ myMullion.offsetTL + offsetXc;
			}
			newStartingXRTc = newStartingXCenter + hypBtoC + hypC;

			newStartingXRT = newStartingXCenter + hypBtoC;

			newStartingXLB = newStartingXCenter + hypBtoC - hypB;

			newStartingXLBa = newStartingXLB - hypA;

		} else if (myMullion.offsetTL == 0) {
			if (isNew) {
				newStartingXCenter = posX + partDimB - partDimBtoC
						+ myMullion.offsetTL;
			}

			newStartingXRTc = newStartingXCenter + partDimBtoC + partDimC;

			newStartingXRT = newStartingXCenter + partDimBtoC;

			newStartingXLB = newStartingXCenter + partDimBtoC - partDimB;

			newStartingXLBa = newStartingXLB - partDimA;
		}

		myMullion.x1 = newStartingXLB;

		myMullion.x2 = newStartingXRT;

		myMullion.x1al = newStartingXLBa;

		myMullion.x2cl = newStartingXRTc;

		myMullion.centerXs = newStartingXCenter;

		if (myMullion.offsetRB != 0) {
			this.getDeltaAndTheta(myMullion, myD);

			final double hypBtoC = partDimBtoC;
			final double hypC = partDimC;
			final double hypB = partDimB;
			final double hypA = partDimA;
			final double offsetXc = 0;

			if (isNew) {
				myMullion.centerXe = posX + partDimB - partDimBtoC
						+ myMullion.offsetRB + offsetXc;
			}
			myMullion.x3 = myMullion.centerXe + hypBtoC;

			myMullion.x3cl = myMullion.x3 + hypC;

			myMullion.x4 = myMullion.x3 - hypB;

			myMullion.x4al = myMullion.x4 - hypA;

		} else if (myMullion.offsetRB == 0) {
			if (isNew) {
				myMullion.centerXe = posX + partDimB - partDimBtoC

				- myMullion.offsetRB;
			}

			myMullion.x3 = myMullion.centerXe + partDimBtoC;

			myMullion.x3cl = myMullion.x3 + partDimC;

			myMullion.x4 = myMullion.x3 - partDimB;

			myMullion.x4al = myMullion.x4 - partDimA;
		}

		if (myMullion.rowCol == newVCCol && myMullion.startPos == newVCRow
				&& myMullion.endPos == vcEnd && this.isNew) {

			newStartingYRT = vcStartY;
			newStartingYRTc = vcStartY;
			newStartingYLB = vcStartY;
			newStartingYLBa = vcStartY;

			newStartingYCenter = vcStartY;

		} else {

			newStartingYRT = myMullion.y2;
			newStartingYRTc = myMullion.y2cl;
			newStartingYLB = myMullion.y1;
			newStartingYLBa = myMullion.y1al;

			newStartingYCenter = myMullion.centerYs;

		}

		myMullion.scale = new BigDecimal(posX - this.myParentBO.startingX)
				.divide(new BigDecimal(myParentBO.widthPix), 10,
						BigDecimal.ROUND_UP);

		return myMullion;
	}

	public double getPosXverified(double posX) {

		if (myParentBO.noSidesTop == 1
				&& posX < myParentBO.px1 + myParentBO.minLeg
						* myScale.doubleValue()
				&& posX + myThick > myParentBO.px1
				&& (posCondition == 1 || posCondition == 3)) {
			posX = myParentBO.px1 + myParentBO.minLeg * myScale.doubleValue();

		}
		if (myParentBO.noSidesTop == 1
				&& posX > myParentBO.px2 - myParentBO.minLeg
						* myScale.doubleValue()
				&& posX + myThick < myParentBO.px2
				&& (posCondition == 1 || posCondition == 3)) {
			posX = myParentBO.px2 - myParentBO.minLeg * myScale.doubleValue()
					- myThick;

		}
		if (myParentBO.noSidesTop == 2
				&& myParentBO.py1 < myParentBO.py2
				&& posX < myParentBO.px1 + myParentBO.minLeg
						* myScale.doubleValue()
				&& posX + myThick > myParentBO.px1
				&& (posCondition == 1 || posCondition == 3)) {
			posX = myParentBO.px1 + myParentBO.minLeg * myScale.doubleValue();

		}

		if (myParentBO.noSidesTop == 2
				&& myParentBO.py1 > myParentBO.py2
				&& posX > myParentBO.px1 - myParentBO.minLeg
						* myScale.doubleValue()
				&& posX + myThick < myParentBO.px1
				&& (posCondition == 1 || posCondition == 3)) {
			posX = myParentBO.px1 - myParentBO.minLeg * myScale.doubleValue()
					- myThick;

		}

		if (myParentBO.noSidesTop == 3
				&& posX < myParentBO.px2 + myParentBO.minLeg
						* myScale.doubleValue()
				&& posX + myThick > myParentBO.px2
				&& (posCondition == 1 || posCondition == 3)) {
			posX = myParentBO.px2 + myParentBO.minLeg * myScale.doubleValue();

		}

		if (myParentBO.noSidesTop == 3
				&& posX > myParentBO.px3 - myParentBO.minLeg
						* myScale.doubleValue()
				&& posX + myThick < myParentBO.px3
				&& (posCondition == 1 || posCondition == 3)) {
			posX = myParentBO.px3 - myParentBO.minLeg * myScale.doubleValue()
					- myThick;

		}

		if (myParentBO.noSidesTop == 1
				&& myParentBO.noSidesBot == 1
				&& posX > myParentBO.px3 - myParentBO.minLeg
						* myScale.doubleValue()
				&& posX + myThick < myParentBO.px3
				&& (posCondition == 1 || posCondition == 2)) {
			posX = myParentBO.px3 - myParentBO.minLeg * myScale.doubleValue()
					- myThick;
		}

		if (myParentBO.noSidesTop == 1
				&& myParentBO.noSidesBot == 1
				&& posX < myParentBO.px4 + myParentBO.minLeg
						* myScale.doubleValue()
				&& posX + myThick > myParentBO.px4
				&& (posCondition == 1 || posCondition == 2)) {
			posX = myParentBO.px4 + myParentBO.minLeg * myScale.doubleValue();
		}

		if (myParentBO.noSidesTop == 1
				&& myParentBO.noSidesBot == 3
				&& posX > myParentBO.px4 - myParentBO.minLeg
						* myScale.doubleValue()
				&& posX + myThick < myParentBO.px4
				&& (posCondition == 1 || posCondition == 2)) {
			posX = myParentBO.px4 - myParentBO.minLeg * myScale.doubleValue()
					- myThick;
		}

		if (myParentBO.noSidesTop == 1
				&& myParentBO.noSidesBot == 3
				&& posX < myParentBO.px5 + myParentBO.minLeg
						* myScale.doubleValue()
				&& posX + myThick > myParentBO.px5
				&& (posCondition == 1 || posCondition == 2)) {
			posX = myParentBO.px5 + myParentBO.minLeg * myScale.doubleValue();
		}

		if (myParentBO.noSidesTop == 2
				&& myParentBO.noSidesBot == 3
				&& posX > myParentBO.px5 - myParentBO.minLeg
						* myScale.doubleValue()
				&& posX + myThick < myParentBO.px5
				&& (posCondition == 1 || posCondition == 2)) {
			posX = myParentBO.px5 - myParentBO.minLeg * myScale.doubleValue()
					- myThick;
		}

		if (myParentBO.noSidesTop == 2
				&& myParentBO.noSidesBot == 3
				&& posX < myParentBO.px6 + myParentBO.minLeg
						* myScale.doubleValue()
				&& posX + myThick > myParentBO.px6
				&& (posCondition == 1 || posCondition == 2)) {
			posX = myParentBO.px6 + myParentBO.minLeg * myScale.doubleValue();
		}

		if (myParentBO.noSidesTop == 3
				&& myParentBO.noSidesBot == 3
				&& posX > myParentBO.px6 - myParentBO.minLeg
						* myScale.doubleValue()
				&& posX + myThick < myParentBO.px6
				&& (posCondition == 1 || posCondition == 2)) {
			posX = myParentBO.px6 - myParentBO.minLeg * myScale.doubleValue()
					- myThick;
		}

		if (myParentBO.noSidesTop == 3
				&& myParentBO.noSidesBot == 3
				&& posX < myParentBO.px7 + myParentBO.minLeg
						* myScale.doubleValue()
				&& posX + myThick > myParentBO.px7
				&& (posCondition == 1 || posCondition == 2)) {
			posX = myParentBO.px7 + myParentBO.minLeg * myScale.doubleValue();
		}

		return posX;
	}

	public double getDeltaAndTheta(final Profiles myMullion, final double myD) {

		double theta = 0;
		this.verifyLimitLR(myMullion);
		final double slopeofBLimit = (limitEndYeBA - limitEndYsBA)
				/ (limitEndXeBA - limitEndXsBA);
		double deltaYatXCenterR = 0;
		double thetaofBLimit = 0;
		if (!java.lang.Double.isInfinite(slopeofBLimit)
				&& !java.lang.Double.isNaN(slopeofBLimit)) {
			thetaofBLimit = Math.atan(slopeofBLimit);
			if (Math.toDegrees(thetaofBLimit) > 90) {
				thetaofBLimit = Math.toRadians(180) - thetaofBLimit;
			}
			deltaYatXCenterR = (myStartingX + newColW * iNo + sumOfPrevMullions + partDimBtoC)
					/ Math.tan(thetaofBLimit);
		}

		final double slopeofTLimit = (limitStartYeBA - limitStartYsBA)
				/ (limitStartXeBA - limitStartXsBA);
		double deltaYatXCenterL = 0;
		double thetaofTLimit = 0;
		if (!java.lang.Double.isInfinite(slopeofTLimit)
				&& !java.lang.Double.isNaN(slopeofTLimit)) {
			thetaofTLimit = Math.atan(slopeofTLimit);
			if (Math.toDegrees(thetaofTLimit) > 90) {
				thetaofTLimit = Math.toRadians(180) - thetaofTLimit;
			}
			deltaYatXCenterL = (myStartingX + newColW * iNo + sumOfPrevMullions + partDimBtoC)
					/ Math.tan(thetaofTLimit);
		}

		final double myWidthAtCenter = limitEndXsBA - limitStartXsBA
				+ deltaYatXCenterL + deltaYatXCenterR;

		theta = Math.atan((myWidthAtCenter / myD));
		return theta;
	}

	/**
	 * Verify Limits Left and Right for Mullion
	 * 
	 * @param myMullion
	 *            , Profiles mullion object
	 * @return Profiles
	 */
	public Profiles verifyLimitLR(Profiles myMullion) {

		calcMullion = new CalculateMullionV(this);

		if (myMullion.startIn) {

			if (myParentBO.mullionsH.size() > 0
					&& myParentBO.mullionObjectsH == null) {
				myParentBO.mullionObjectsH = myParentBO.mullionsH.toArray();
				myParentBO.mullionsH.clear();
			}

			// if (myParentBO.mullions.size() > 0 && myParentBO.mullionObjectsV
			// == null) {
			// myParentBO.mullionObjectsV = myParentBO.mullions.toArray();
			// myParentBO.mullions.clear();
			// }

			myParentBO.mullionsH.clear();
			for (final Object element : myParentBO.mullionObjectsH) {

				if (((Profiles) element).rowCol + 1 == myMullion.startPos
						&& ((Profiles) element).x1al < myMullion.x1al
						&& ((Profiles) element).x4al > myMullion.x2cl) {

					dimTM = ((Profiles) element).partDimM;
					dimTA = ((Profiles) element).partDimC;

					myMullion.limitStartY1 = (Profiles) element;
					myMullion.limitStartY1a = (Profiles) element;
					myMullion.limitStartY2 = (Profiles) element;
					myMullion.limitStartY2c = (Profiles) element;
					myMullion.limitStartYC = (Profiles) element;

					double intX = intersectX(myMullion.centerXe,
							myMullion.centerYe, myMullion.centerXs,
							myMullion.centerYs, ((Profiles) element).x1,
							((Profiles) element).y1, ((Profiles) element).x4,
							((Profiles) element).y4);

					double distance = Math.sqrt(Math.pow((Math.max(intX,
							((Profiles) element).x1) - Math.min(intX,
							((Profiles) element).x1)), 2)
							+ Math.pow((Math.max(myMullion.centerYs,
									((Profiles) element).y1) - Math
									.min(myMullion.centerYs,
											((Profiles) element).y1)), 2));

					if (((Profiles) element).notchRB.trim().length() > 0) {
						((Profiles) element).notchRB = ((Profiles) element).notchRB
								+ ","
								+ (int) (distance / (myFrame2.metricscale
										.doubleValue() * 100));
						((Profiles) element).notchRBi = ((Profiles) element).notchRBi
								+ ","
								+ distance
								/ myFrame2.imperialscale.doubleValue();
					} else {
						((Profiles) element).notchRB = ""
								+ (int) (distance / (myFrame2.metricscale
										.doubleValue() * 100));
						((Profiles) element).notchRBi = "" + distance
								/ myFrame2.imperialscale.doubleValue();
					}

				}

				myParentBO.mullionsH.add(element);

			}

		}

		if (myMullion.endIn) {

			if (myParentBO.mullionsH.size() > 0
					&& myParentBO.mullionObjectsH == null) {
				myParentBO.mullionObjectsH = myParentBO.mullionsH.toArray();
				myParentBO.mullionsH.clear();
			}

			if (myParentBO.mullions.size() > 0
					&& myParentBO.mullionObjectsV == null) {
				myParentBO.mullionObjectsV = myParentBO.mullions.toArray();
				// myParentBO.mullions.clear();
			}

			myParentBO.mullionsH.clear();

			for (final Object element : myParentBO.mullionObjectsH) {
				if (((Profiles) element).rowCol == myMullion.endPos
						&& ((Profiles) element).x1al < myMullion.x4al
						&& ((Profiles) element).x4al > myMullion.x3cl) {

					dimBM = ((Profiles) element).partDimM;
					dimBA = ((Profiles) element).partDimA;

					myMullion.limitEndY4 = (Profiles) element;
					myMullion.limitEndY4a = (Profiles) element;
					myMullion.limitEndY3 = (Profiles) element;
					myMullion.limitEndY3c = (Profiles) element;
					myMullion.limitEndYC = (Profiles) element;

					double intX = intersectX(myMullion.centerXe,
							myMullion.centerYe, myMullion.centerXs,
							myMullion.centerYs, ((Profiles) element).x2,
							((Profiles) element).y2, ((Profiles) element).x3,
							((Profiles) element).y3);

					double distance = Math.sqrt(Math.pow((Math.max(intX,
							((Profiles) element).x2) - Math.min(intX,
							((Profiles) element).x2)), 2)
							+ Math.pow((Math.max(myMullion.centerYs,
									((Profiles) element).y2) - Math
									.min(myMullion.centerYs,
											((Profiles) element).y2)), 2));

					if (((Profiles) element).notchLT.trim().length() > 0) {
						((Profiles) element).notchLT = ((Profiles) element).notchLT
								+ ","
								+ (int) (distance / (myFrame2.metricscale
										.doubleValue() * 100));
						((Profiles) element).notchLTi = ((Profiles) element).notchLTi
								+ ","
								+ distance
								/ myFrame2.imperialscale.doubleValue();
					} else {
						((Profiles) element).notchLT = ""
								+ (int) (distance / (myFrame2.metricscale
										.doubleValue() * 100));
						((Profiles) element).notchLTi = "" + distance
								/ myFrame2.imperialscale.doubleValue();
					}

				}
				myParentBO.mullionsH.add(element);
			}
		}

		if (!myMullion.startIn && myMullion.cOrM == 1) {// couplers
			myMullion = getLimitStartOut(myMullion);
			dimTM = myMullion.limitStartYC.partDimM;
			dimTA = myMullion.limitStartYC.partDimA;

		}
		if (!myMullion.endIn && myMullion.cOrM == 1) {// couplers
			myMullion = getLimitEndOut(myMullion);
			dimBM = myMullion.limitEndYC.partDimM;
			dimBA = myMullion.limitEndYC.partDimA;

		}

		if (!myMullion.startIn && myMullion.cOrM != 1) {// mullions
			myMullion = getLimitStartOutM(myMullion);
			dimTM = myMullion.limitStartYC.partDimM;
			dimTA = myMullion.limitStartYC.partDimA;
		}
		if (!myMullion.endIn && myMullion.cOrM != 1) {// mullions
			myMullion = getLimitEndOutM(myMullion);
			dimBM = myMullion.limitEndYC.partDimM;
			dimBA = myMullion.limitEndYC.partDimA;

		}

		return myMullion;
	}

	public Profiles getLimitStartOut(final Profiles myMullion) {

		if (myParentBO.leftPart.posInUse
				&& myParentBO.leftPart.startXC <= myMullion.x1al
				&& myParentBO.leftPart.endXC >= myMullion.x1al) {

			myMullion.limitStartY1a = myParentBO.leftPart;

		}
		if (myParentBO.leftPart.posInUse
				&& myParentBO.leftPart.startXC <= myMullion.x1
				&& myParentBO.leftPart.endXC >= myMullion.x1) {

			myMullion.limitStartY1 = myParentBO.leftPart;

		}
		if (myParentBO.leftPart.posInUse
				&& myParentBO.leftPart.startXC <= myMullion.centerXs
				&& myParentBO.leftPart.endXC >= myMullion.centerXs) {

			myMullion.limitStartYC = myParentBO.leftPart;

			double intY = intersectY(myMullion.centerXe, vcEndY,
					myMullion.centerXs, vcStartY,
					myParentBO.myParent.leftPart.startXBA,
					myParentBO.myParent.leftPart.startYBA,
					myParentBO.myParent.leftPart.endXBA,
					myParentBO.myParent.leftPart.startYBA);

			double H = intY - myParentBO.myParent.leftPart.startYBA;
			double B = myMullion.centerXs
					- myParentBO.myParent.leftPart.startXBA;

			double distance = Math.sqrt((Math.pow(H, 2)) + Math.pow(B, 2));

			distance = // Math.sqrt((Math.pow(H,2)) + Math.pow(B, 2));
			Math.sqrt(Math.pow((Math.max(myParentBO.myParent.leftPart.endXBA,
					myParentBO.myParent.leftPart.startXBA) - Math.min(
					myParentBO.myParent.leftPart.endXBA,
					myParentBO.myParent.leftPart.startXBA)), 2)
					+ Math.pow((Math.max(intY,
							myParentBO.myParent.leftPart.startYBA) - Math.min(
							intY, myParentBO.myParent.leftPart.startYBA)), 2));

			if (myParentBO.myParent.leftPart.notchLT.trim().length() > 0) {
				myParentBO.myParent.leftPart.notchLT = myParentBO.myParent.leftPart.notchLT
						+ ","
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.leftPart.notchLTi = myParentBO.myParent.leftPart.notchLT
						+ "," + distance / myFrame2.imperialscale.doubleValue();
			} else {
				myParentBO.myParent.leftPart.notchLT = ""
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.leftPart.notchLTi = "" + distance
						/ myFrame2.imperialscale.doubleValue();
			}

		}
		if (myParentBO.leftPart.posInUse
				&& myParentBO.leftPart.startXC <= myMullion.x2
				&& myParentBO.leftPart.endXC >= myMullion.x2) {

			myMullion.limitStartY2 = myParentBO.leftPart;

		}
		if (myParentBO.leftPart.posInUse
				&& myParentBO.leftPart.startXC <= myMullion.x2cl
				&& myParentBO.leftPart.endXC >= myMullion.x2cl) {

			myMullion.limitStartY2c = myParentBO.leftPart;

		}

		if (myParentBO.top1Part.posInUse
				&& myParentBO.top1Part.startXC <= myMullion.x1al
				&& myParentBO.top1Part.endXC >= myMullion.x1al) {

			myMullion.limitStartY1a = myParentBO.top1Part;

		}
		if (myParentBO.top1Part.posInUse
				&& myParentBO.top1Part.startXC <= myMullion.x1
				&& myParentBO.top1Part.endXC >= myMullion.x1) {

			myMullion.limitStartY1 = myParentBO.top1Part;

		}
		if (myParentBO.top1Part.posInUse
				&& myParentBO.top1Part.startXC <= myMullion.centerXs
				&& myParentBO.top1Part.endXC >= myMullion.centerXs) {
			double intY = 0;

			myMullion.limitStartYC = myParentBO.top1Part;

			if (myMullion.limitStartYC.partForm == 1) {
				intY = intersectY(myMullion.centerXe, vcEndY,
						myMullion.centerXs, vcStartY,
						myParentBO.myParent.top1Part.startXBA,
						myParentBO.myParent.top1Part.startYBA,
						myParentBO.myParent.top1Part.endXBA,
						myParentBO.myParent.top1Part.startYBA);
			} else {

				intY = calcMullion.arcX.getYusingX(myMullion.centerXs,
						myMullion.centerYs, myMullion.centerXe,
						myMullion.centerYe, myMullion.limitStartYC.radius1BA,
						myMullion.limitStartYC.x1, myMullion.limitStartYC.y1,
						false);
			}

			double H = intY - myParentBO.myParent.top1Part.startYBA;
			double B = myMullion.centerXs
					- myParentBO.myParent.top1Part.startXBA;

			double distance = Math.sqrt((Math.pow(H, 2)) + Math.pow(B, 2));

			if (myParentBO.myParent.top1Part.partForm == 1) {
				distance = Math
						.sqrt(Math.pow(
								(Math.max(myParentBO.myParent.top1Part.endXBA,
										myParentBO.myParent.top1Part.startXBA) - Math
										.min(myParentBO.myParent.top1Part.endXBA,
												myParentBO.myParent.top1Part.startXBA)),
								2)
								+ Math.pow(
										(Math.max(
												intY,
												myParentBO.myParent.top1Part.startYBA) - Math
												.min(intY,
														myParentBO.myParent.top1Part.startYBA)),
										2));
			} else if (myParentBO.myParent.top1Part.partForm == 2) {
				distance = 2 * Math.PI * myParentBO.myParent.top1Part.radius1BA
						* myParentBO.myParent.top1Part.centralAngle / 360;
			} else {
				final double a = myParentBO.widthPix / 2;
				final double b = myParentBO.dimB1;
				distance = Math.PI
						* (3 * a + 3 * b - Math.sqrt((a + 3 * b) * (b + 3 * a)));
			}

			if (myParentBO.myParent.top1Part.notchLT.trim().length() > 0) {
				myParentBO.myParent.top1Part.notchLT = myParentBO.myParent.top1Part.notchLT
						+ ","
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.top1Part.notchLTi = myParentBO.myParent.top1Part.notchLT
						+ "," + distance / myFrame2.imperialscale.doubleValue();
			} else {
				myParentBO.myParent.top1Part.notchLT = ""
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.top1Part.notchLTi = "" + distance
						/ myFrame2.imperialscale.doubleValue();
			}

		}
		if (myParentBO.top1Part.posInUse
				&& myParentBO.top1Part.startXC <= myMullion.x2
				&& myParentBO.top1Part.endXC >= myMullion.x2) {

			myMullion.limitStartY2 = myParentBO.top1Part;

		}
		if (myParentBO.top1Part.posInUse
				&& myParentBO.top1Part.startXC <= myMullion.x2cl
				&& myParentBO.top1Part.endXC >= myMullion.x2cl) {

			myMullion.limitStartY2c = myParentBO.top1Part;

		}

		// ////////////////////////////////////////

		if (myParentBO.top2Part.posInUse
				&& myParentBO.top2Part.startXC <= myMullion.x1al
				&& myParentBO.top2Part.endXC >= myMullion.x1al) {

			myMullion.limitStartY1a = myParentBO.top2Part;

		}
		if (myParentBO.top2Part.posInUse
				&& myParentBO.top2Part.startXC <= myMullion.x1
				&& myParentBO.top2Part.endXC >= myMullion.x1) {

			myMullion.limitStartY1 = myParentBO.top2Part;

		}
		if (myParentBO.top2Part.posInUse
				&& myParentBO.top2Part.startXC <= myMullion.centerXs
				&& myParentBO.top2Part.endXC >= myMullion.centerXs) {

			myMullion.limitStartYC = myParentBO.top2Part;

			double intY = 0;

			if (myMullion.limitStartYC.partForm == 1) {
				intY = intersectY(myMullion.centerXe, vcEndY,
						myMullion.centerXs, vcStartY,
						myParentBO.myParent.top2Part.startXBA,
						myParentBO.myParent.top2Part.startYBA,
						myParentBO.myParent.top2Part.endXBA,
						myParentBO.myParent.top2Part.startYBA);
			} else {

				intY = calcMullion.arcX.getYusingX(myMullion.centerXs,
						myMullion.centerYs, myMullion.centerXe,
						myMullion.centerYe, myMullion.limitStartYC.radius1BA,
						myMullion.limitStartYC.x1, myMullion.limitStartYC.y1,
						false);
			}

			double H = intY - myParentBO.myParent.top2Part.startYBA;
			double B = myMullion.centerXs
					- myParentBO.myParent.top2Part.startXBA;

			double distance = Math.sqrt((Math.pow(H, 2)) + Math.pow(B, 2));

			distance = // Math.sqrt((Math.pow(H,2)) + Math.pow(B, 2));
			Math.sqrt(Math.pow((Math.max(myParentBO.myParent.top2Part.endXBA,
					myParentBO.myParent.top2Part.startXBA) - Math.min(
					myParentBO.myParent.top2Part.endXBA,
					myParentBO.myParent.top2Part.startXBA)), 2)
					+ Math.pow((Math.max(intY,
							myParentBO.myParent.top2Part.startYBA) - Math.min(
							intY, myParentBO.myParent.top2Part.startYBA)), 2));

			if (myParentBO.myParent.top2Part.notchLT.trim().length() > 0) {
				myParentBO.myParent.top2Part.notchLT = myParentBO.myParent.top2Part.notchLT
						+ ","
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.top2Part.notchLTi = myParentBO.myParent.top2Part.notchLT
						+ "," + distance / myFrame2.imperialscale.doubleValue();
			} else {
				myParentBO.myParent.top2Part.notchLT = ""
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.top2Part.notchLTi = "" + distance
						/ myFrame2.imperialscale.doubleValue();
			}

		}
		if (myParentBO.top2Part.posInUse
				&& myParentBO.top2Part.startXC <= myMullion.x2
				&& myParentBO.top2Part.endXC >= myMullion.x2) {

			myMullion.limitStartY2 = myParentBO.top2Part;

		}
		if (myParentBO.top2Part.posInUse
				&& myParentBO.top2Part.startXC <= myMullion.x2cl
				&& myParentBO.top2Part.endXC >= myMullion.x2cl) {

			myMullion.limitStartY2c = myParentBO.top2Part;

		}
		// ///////////////
		// ////////////////////////////////////////

		if (myParentBO.top3Part.posInUse
				&& myParentBO.top3Part.startXC <= myMullion.x1al
				&& myParentBO.top3Part.endXC >= myMullion.x1al) {

			myMullion.limitStartY1a = myParentBO.top3Part;

		}
		if (myParentBO.top3Part.posInUse
				&& myParentBO.top3Part.startXC <= myMullion.x1
				&& myParentBO.top3Part.endXC >= myMullion.x1) {

			myMullion.limitStartY1 = myParentBO.top3Part;

		}
		if (myParentBO.top3Part.posInUse
				&& myParentBO.top3Part.startXC <= myMullion.centerXs
				&& myParentBO.top3Part.endXC >= myMullion.centerXs) {

			myMullion.limitStartYC = myParentBO.top3Part;

			double intY = intersectY(myMullion.centerXe, vcEndY,
					myMullion.centerXs, vcStartY,
					myParentBO.myParent.top3Part.startXBA,
					myParentBO.myParent.top3Part.startYBA,
					myParentBO.myParent.top3Part.endXBA,
					myParentBO.myParent.top3Part.startYBA);

			double H = intY - myParentBO.myParent.top3Part.startYBA;
			double B = myMullion.centerXs
					- myParentBO.myParent.top3Part.startXBA;

			double distance = Math.sqrt((Math.pow(H, 2)) + Math.pow(B, 2));

			distance = // Math.sqrt((Math.pow(H,2)) + Math.pow(B, 2));
			Math.sqrt(Math.pow((Math.max(myParentBO.myParent.top3Part.endXBA,
					myParentBO.myParent.top3Part.startXBA) - Math.min(
					myParentBO.myParent.top3Part.endXBA,
					myParentBO.myParent.top3Part.startXBA)), 2)
					+ Math.pow((Math.max(intY,
							myParentBO.myParent.top3Part.startYBA) - Math.min(
							intY, myParentBO.myParent.top3Part.startYBA)), 2));

			if (myParentBO.myParent.top3Part.notchLT.trim().length() > 0) {
				myParentBO.myParent.top3Part.notchLT = myParentBO.myParent.top3Part.notchLT
						+ ","
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.top3Part.notchLTi = myParentBO.myParent.top3Part.notchLT
						+ "," + distance / myFrame2.imperialscale.doubleValue();
			} else {
				myParentBO.myParent.top3Part.notchLT = ""
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.top3Part.notchLTi = "" + distance
						/ myFrame2.imperialscale.doubleValue();
			}

		}
		if (myParentBO.top3Part.posInUse
				&& myParentBO.top3Part.startXC <= myMullion.x2
				&& myParentBO.top3Part.endXC >= myMullion.x2) {

			myMullion.limitStartY2 = myParentBO.top3Part;

		}
		if (myParentBO.top3Part.posInUse
				&& myParentBO.top3Part.startXC <= myMullion.x2cl
				&& myParentBO.top3Part.endXC >= myMullion.x2cl) {

			myMullion.limitStartY2c = myParentBO.top3Part;

		}
		// /////////////////////

		if (myParentBO.rightPart.posInUse
				&& myParentBO.rightPart.startXC <= myMullion.x1al
				&& myParentBO.rightPart.endXC >= myMullion.x1al) {

			myMullion.limitStartY1a = myParentBO.rightPart;

		}
		if (myParentBO.rightPart.posInUse
				&& myParentBO.rightPart.startXC <= myMullion.x1
				&& myParentBO.rightPart.endXC >= myMullion.x1) {

			myMullion.limitStartY1 = myParentBO.rightPart;

		}
		if (myParentBO.rightPart.posInUse
				&& myParentBO.rightPart.startXC <= myMullion.centerXs
				&& myParentBO.rightPart.endXC >= myMullion.centerXs) {

			myMullion.limitStartYC = myParentBO.rightPart;
			double intY = intersectY(myMullion.centerXe, vcEndY,
					myMullion.centerXs, vcStartY,
					myParentBO.myParent.rightPart.startXBA,
					myParentBO.myParent.rightPart.startYBA,
					myParentBO.myParent.rightPart.endXBA,
					myParentBO.myParent.rightPart.startYBA);

			double H = intY - myParentBO.myParent.rightPart.startYBA;
			double B = myMullion.centerXs
					- myParentBO.myParent.rightPart.startXBA;

			double distance = Math.sqrt((Math.pow(H, 2)) + Math.pow(B, 2));

			distance = // Math.sqrt((Math.pow(H,2)) + Math.pow(B, 2));
			Math.sqrt(Math.pow((Math.max(myParentBO.myParent.rightPart.endXBA,
					myParentBO.myParent.rightPart.startXBA) - Math.min(
					myParentBO.myParent.rightPart.endXBA,
					myParentBO.myParent.rightPart.startXBA)), 2)
					+ Math.pow((Math.max(intY,
							myParentBO.myParent.rightPart.startYBA) - Math.min(
							intY, myParentBO.myParent.rightPart.startYBA)), 2));

			if (myParentBO.myParent.rightPart.notchLT.trim().length() > 0) {
				myParentBO.myParent.rightPart.notchLT = myParentBO.myParent.rightPart.notchLT
						+ ","
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.rightPart.notchLTi = myParentBO.myParent.rightPart.notchLT
						+ "," + distance / myFrame2.imperialscale.doubleValue();
			} else {
				myParentBO.myParent.rightPart.notchLT = ""
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.rightPart.notchLTi = "" + distance
						/ myFrame2.imperialscale.doubleValue();
			}

		}
		if (myParentBO.rightPart.posInUse
				&& myParentBO.rightPart.startXC <= myMullion.x2
				&& myParentBO.rightPart.endXC >= myMullion.x2) {

			myMullion.limitStartY2 = myParentBO.rightPart;

		}
		if (myParentBO.rightPart.posInUse
				&& myParentBO.rightPart.startXC <= myMullion.x2cl
				&& myParentBO.rightPart.endXC >= myMullion.x2cl) {

			myMullion.limitStartY2c = myParentBO.rightPart;

		}
		// /////////////////////
		return myMullion;
	}

	public Profiles getLimitStartOutM(final Profiles myMullion) {

		if (myParentBO.leftPart.posInUse
				&& myParentBO.leftPart.startXC <= myMullion.x1al
				&& myParentBO.leftPart.endXC >= myMullion.x1al) {

			myMullion.limitStartY1a = myParentBO.myParent.leftPart;

		}
		if (myParentBO.leftPart.posInUse
				&& myParentBO.leftPart.startXC <= myMullion.x1
				&& myParentBO.leftPart.endXC >= myMullion.x1) {

			myMullion.limitStartY1 = myParentBO.myParent.leftPart;

		}
		if (myParentBO.leftPart.posInUse
				&& myParentBO.leftPart.startXC <= myMullion.centerXs
				&& myParentBO.leftPart.endXC >= myMullion.centerXs) {

			myMullion.limitStartYC = myParentBO.myParent.leftPart;

			double intY = intersectY(myMullion.centerXe, vcEndY,
					myMullion.centerXs, vcStartY,
					myParentBO.myParent.leftPart.startXBA,
					myParentBO.myParent.leftPart.startYBA,
					myParentBO.myParent.leftPart.endXBA,
					myParentBO.myParent.leftPart.startYBA);

			double H = intY - myParentBO.myParent.leftPart.startYBA;
			double B = myMullion.centerXs
					- myParentBO.myParent.leftPart.startXBA;

			double distance = Math.sqrt((Math.pow(H, 2)) + Math.pow(B, 2));

			distance = // Math.sqrt((Math.pow(H,2)) + Math.pow(B, 2));
			Math.sqrt(Math.pow((Math.max(myParentBO.myParent.leftPart.endXBA,
					myParentBO.myParent.leftPart.startXBA) - Math.min(
					myParentBO.myParent.leftPart.endXBA,
					myParentBO.myParent.leftPart.startXBA)), 2)
					+ Math.pow((Math.max(intY,
							myParentBO.myParent.leftPart.startYBA) - Math.min(
							intY, myParentBO.myParent.leftPart.startYBA)), 2));

			if (myParentBO.myParent.leftPart.notchLT.trim().length() > 0) {
				myParentBO.myParent.leftPart.notchLT = myParentBO.myParent.leftPart.notchLT
						+ ","
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.leftPart.notchLTi = myParentBO.myParent.leftPart.notchLT
						+ "," + distance / myFrame2.imperialscale.doubleValue();
			} else {
				myParentBO.myParent.leftPart.notchLT = ""
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.leftPart.notchLTi = "" + distance
						/ myFrame2.imperialscale.doubleValue();
			}

		}
		if (myParentBO.leftPart.posInUse
				&& myParentBO.leftPart.startXC <= myMullion.x2
				&& myParentBO.leftPart.endXC >= myMullion.x2) {

			myMullion.limitStartY2 = myParentBO.myParent.leftPart;

		}
		if (myParentBO.leftPart.posInUse
				&& myParentBO.leftPart.startXC <= myMullion.x2cl
				&& myParentBO.leftPart.endXC >= myMullion.x2cl) {

			myMullion.limitStartY2c = myParentBO.myParent.leftPart;

		}

		if (myParentBO.top1Part.posInUse
				&& myParentBO.top1Part.startXC <= myMullion.x1al
				&& myParentBO.top1Part.endXC >= myMullion.x1al) {

			myMullion.limitStartY1a = myParentBO.myParent.top1Part;

		}
		if (myParentBO.top1Part.posInUse
				&& myParentBO.top1Part.startXC <= myMullion.x1
				&& myParentBO.top1Part.endXC >= myMullion.x1) {

			myMullion.limitStartY1 = myParentBO.myParent.top1Part;

		}
		if (myParentBO.top1Part.posInUse
				&& myParentBO.top1Part.startXC <= myMullion.centerXs
				&& myParentBO.top1Part.endXC >= myMullion.centerXs) {

			myMullion.limitStartYC = myParentBO.myParent.top1Part;

			double intY = intersectY(myMullion.centerXe, vcEndY,
					myMullion.centerXs, vcStartY,
					myParentBO.myParent.top1Part.startXA,
					myParentBO.myParent.top1Part.startYA,
					myParentBO.myParent.top1Part.endXA,
					myParentBO.myParent.top1Part.startYA);

			double H = intY - myParentBO.myParent.leftPart.startYBA;
			double B = myMullion.centerXs
					- myParentBO.myParent.leftPart.startXBA;

			double distance = Math.sqrt((Math.pow(H, 2)) + Math.pow(B, 2));

			distance = Math.sqrt(Math.pow((Math.max(myMullion.centerXs,
					myParentBO.myParent.top1Part.startXA) - Math.min(
					myMullion.centerXs, myParentBO.myParent.top1Part.startXA)),
					2)
					+ Math.pow((Math.max(intY,
							myParentBO.myParent.top1Part.startYA) - Math.min(
							intY, myParentBO.myParent.top1Part.startYA)), 2));

			if (myParentBO.top1Part.notchRB.trim().length() > 0) {
				myParentBO.myParent.top1Part.notchRB = myParentBO.myParent.top1Part.notchRB
						+ ","
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.top1Part.notchRBi = myParentBO.myParent.top1Part.notchRBi
						+ ","
						+ (int) (distance / myFrame2.imperialscale
								.doubleValue());
			} else {
				myParentBO.myParent.top1Part.notchRB = ""
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.top1Part.notchRBi = "" + distance
						/ myFrame2.imperialscale.doubleValue();
			}

		}
		if (myParentBO.top1Part.posInUse
				&& myParentBO.top1Part.startXC <= myMullion.x2
				&& myParentBO.top1Part.endXC >= myMullion.x2) {

			myMullion.limitStartY2 = myParentBO.myParent.top1Part;

		}
		if (myParentBO.top1Part.posInUse
				&& myParentBO.top1Part.startXC <= myMullion.x2cl
				&& myParentBO.top1Part.endXC >= myMullion.x2cl) {

			myMullion.limitStartY2c = myParentBO.myParent.top1Part;

		}

		// ////////////////////////////////////////

		if (myParentBO.top2Part.posInUse
				&& myParentBO.top2Part.startXC <= myMullion.x1al
				&& myParentBO.top2Part.endXC >= myMullion.x1al) {

			myMullion.limitStartY1a = myParentBO.myParent.top2Part;

		}
		if (myParentBO.top2Part.posInUse
				&& myParentBO.top2Part.startXC <= myMullion.x1
				&& myParentBO.top2Part.endXC >= myMullion.x1) {

			myMullion.limitStartY1 = myParentBO.myParent.top2Part;

		}
		if (myParentBO.top2Part.posInUse
				&& myParentBO.top2Part.startXC <= myMullion.centerXs
				&& myParentBO.top2Part.endXC >= myMullion.centerXs) {

			myMullion.limitStartYC = myParentBO.myParent.top2Part;
			double intY = intersectY(myMullion.centerXe, vcEndY,
					myMullion.centerXs, vcStartY,
					myParentBO.myParent.top2Part.startXA,
					myParentBO.myParent.top2Part.startYA,
					myParentBO.myParent.top2Part.endXA,
					myParentBO.myParent.top2Part.startYA);

			double H = intY - myParentBO.myParent.top2Part.startYA;
			double B = myMullion.centerXs
					- myParentBO.myParent.top2Part.startXA;

			double distance = Math.sqrt((Math.pow(H, 2)) + Math.pow(B, 2));

			distance = // Math.sqrt((Math.pow(H,2)) + Math.pow(B, 2));
			Math.sqrt(Math.pow((Math.max(myMullion.centerXs,
					myParentBO.myParent.top2Part.startXA) - Math.min(
					myMullion.centerXs, myParentBO.myParent.top2Part.startXA)),
					2)
					+ Math.pow((Math.max(intY,
							myParentBO.myParent.top2Part.startYA) - Math.min(
							intY, myParentBO.myParent.top2Part.startYA)), 2));

			if (myParentBO.top2Part.notchRB.trim().length() > 0) {
				myParentBO.myParent.top2Part.notchRB = myParentBO.myParent.top2Part.notchRB
						+ ","
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.top2Part.notchRBi = myParentBO.myParent.top2Part.notchRBi
						+ "," + distance / myFrame2.imperialscale.doubleValue();
			} else {
				myParentBO.myParent.top2Part.notchRB = ""
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.top2Part.notchRBi = "" + distance
						/ myFrame2.imperialscale.doubleValue();
			}
		}
		if (myParentBO.top2Part.posInUse
				&& myParentBO.top2Part.startXC <= myMullion.x2
				&& myParentBO.top2Part.endXC >= myMullion.x2) {

			myMullion.limitStartY2 = myParentBO.myParent.top2Part;

		}
		if (myParentBO.top2Part.posInUse
				&& myParentBO.top2Part.startXC <= myMullion.x2cl
				&& myParentBO.top2Part.endXC >= myMullion.x2cl) {

			myMullion.limitStartY2c = myParentBO.myParent.top2Part;

		}
		// ///////////////
		// ////////////////////////////////////////

		if (myParentBO.top3Part.posInUse
				&& myParentBO.top3Part.startXC <= myMullion.x1al
				&& myParentBO.top3Part.endXC >= myMullion.x1al) {

			myMullion.limitStartY1a = myParentBO.myParent.top3Part;

		}
		if (myParentBO.top3Part.posInUse
				&& myParentBO.top3Part.startXC <= myMullion.x1
				&& myParentBO.top3Part.endXC >= myMullion.x1) {

			myMullion.limitStartY1 = myParentBO.myParent.top3Part;

		}
		if (myParentBO.top3Part.posInUse
				&& myParentBO.top3Part.startXC <= myMullion.centerXs
				&& myParentBO.top3Part.endXC >= myMullion.centerXs) {

			myMullion.limitStartYC = myParentBO.myParent.top3Part;

			double intY = intersectY(myMullion.centerXe, vcEndY,
					myMullion.centerXs, vcStartY,
					myParentBO.myParent.top3Part.startXA,
					myParentBO.myParent.top3Part.startYA,
					myParentBO.myParent.top3Part.endXA,
					myParentBO.myParent.top3Part.startYA);

			double H = intY - myParentBO.myParent.top3Part.startYA;
			double B = myMullion.centerXs
					- myParentBO.myParent.top3Part.startXA;

			double distance = Math.sqrt((Math.pow(H, 2)) + Math.pow(B, 2));

			distance = // Math.sqrt((Math.pow(H,2)) + Math.pow(B, 2));
			Math.sqrt(Math.pow((Math.max(myMullion.centerXs,
					myParentBO.myParent.top3Part.startXA) - Math.min(
					myMullion.centerXs, myParentBO.myParent.top3Part.startXA)),
					2)
					+ Math.pow((Math.max(intY,
							myParentBO.myParent.top3Part.startYA) - Math.min(
							intY, myParentBO.myParent.top3Part.startYA)), 2));

			if (myParentBO.myParent.top3Part.notchRB.trim().length() > 0) {
				myParentBO.myParent.top3Part.notchRB = myParentBO.myParent.top3Part.notchRB
						+ ","
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.top3Part.notchRBi = myParentBO.myParent.top3Part.notchRBi
						+ "," + distance / myFrame2.imperialscale.doubleValue();
			} else {
				myParentBO.myParent.top3Part.notchRB = ""
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.top3Part.notchRBi = "" + distance
						/ myFrame2.imperialscale.doubleValue();
			}

		}
		if (myParentBO.top3Part.posInUse
				&& myParentBO.top3Part.startXC <= myMullion.x2
				&& myParentBO.top3Part.endXC >= myMullion.x2) {

			myMullion.limitStartY2 = myParentBO.myParent.top3Part;

		}
		if (myParentBO.top3Part.posInUse
				&& myParentBO.top3Part.startXC <= myMullion.x2cl
				&& myParentBO.top3Part.endXC >= myMullion.x2cl) {

			myMullion.limitStartY2c = myParentBO.myParent.top3Part;

		}
		// /////////////////////

		if (myParentBO.rightPart.posInUse
				&& myParentBO.rightPart.startXC <= myMullion.x1al
				&& myParentBO.rightPart.endXC >= myMullion.x1al) {

			myMullion.limitStartY1a = myParentBO.myParent.rightPart;

		}
		if (myParentBO.rightPart.posInUse
				&& myParentBO.rightPart.startXC <= myMullion.x1
				&& myParentBO.rightPart.endXC >= myMullion.x1) {

			myMullion.limitStartY1 = myParentBO.myParent.rightPart;

		}
		if (myParentBO.rightPart.posInUse
				&& myParentBO.rightPart.startXC <= myMullion.centerXs
				&& myParentBO.rightPart.endXC >= myMullion.centerXs) {

			myMullion.limitStartYC = myParentBO.myParent.rightPart;
			double intY = intersectY(myMullion.centerXe, vcEndY,
					myMullion.centerXs, vcStartY,
					myParentBO.myParent.rightPart.startXA,
					myParentBO.myParent.rightPart.startYA,
					myParentBO.myParent.rightPart.endXA,
					myParentBO.myParent.rightPart.startYA);

			double H = intY - myParentBO.myParent.rightPart.startYA;
			double B = myMullion.centerXs
					- myParentBO.myParent.rightPart.startXA;

			double distance = Math.sqrt((Math.pow(H, 2)) + Math.pow(B, 2));

			distance = // Math.sqrt((Math.pow(H,2)) + Math.pow(B, 2));
			Math.sqrt(Math.pow(
					(Math.max(myMullion.centerXs,
							myParentBO.myParent.rightPart.startXA) - Math.min(
							myMullion.centerXs,
							myParentBO.myParent.rightPart.startXA)), 2)
					+ Math.pow((Math.max(intY,
							myParentBO.myParent.rightPart.startYA) - Math.min(
							intY, myParentBO.myParent.rightPart.startYA)), 2));

			if (myParentBO.myParent.rightPart.notchRB.trim().length() > 0) {
				myParentBO.myParent.rightPart.notchRB = myParentBO.myParent.rightPart.notchRB
						+ ","
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.rightPart.notchRBi = myParentBO.myParent.rightPart.notchRBi
						+ "," + distance / myFrame2.imperialscale.doubleValue();
			} else {
				myParentBO.myParent.rightPart.notchRB = ""
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.rightPart.notchRBi = "" + distance
						/ myFrame2.imperialscale.doubleValue();
			}
		}
		if (myParentBO.rightPart.posInUse
				&& myParentBO.rightPart.startXC <= myMullion.x2
				&& myParentBO.rightPart.endXC >= myMullion.x2) {

			myMullion.limitStartY2 = myParentBO.myParent.rightPart;

		}
		if (myParentBO.rightPart.posInUse
				&& myParentBO.rightPart.startXC <= myMullion.x2cl
				&& myParentBO.rightPart.endXC >= myMullion.x2cl) {

			myMullion.limitStartY2c = myParentBO.myParent.rightPart;

		}
		// /////////////////////
		return myMullion;
	}

	public Profiles getLimitEndOut(final Profiles myMullion) {

		if (myParentBO.leftPart.posInUse
				&& myParentBO.leftPart.startXC >= myMullion.x3cl
				&& myParentBO.leftPart.endXC <= myMullion.x3cl) {
			myMullion.limitEndY3c = myParentBO.leftPart;

		}
		if (myParentBO.bot2Part.posInUse
				&& myParentBO.bot2Part.startXC >= myMullion.x3cl
				&& myParentBO.bot2Part.endXC <= myMullion.x3cl) {
			myMullion.limitEndY3c = myParentBO.bot2Part;

		}
		if (myParentBO.bot3Part.posInUse
				&& myParentBO.bot3Part.startXC >= myMullion.x3cl
				&& myParentBO.bot3Part.endXC <= myMullion.x3cl) {
			myMullion.limitEndY3c = myParentBO.bot3Part;

		}
		if (myParentBO.bot1Part.posInUse
				&& myParentBO.bot1Part.startXC >= myMullion.x3cl
				&& myParentBO.bot1Part.endXC <= myMullion.x3cl) {
			myMullion.limitEndY3c = myParentBO.bot1Part;

		}
		if (myParentBO.rightPart.posInUse
				&& myParentBO.rightPart.startXC >= myMullion.x3cl
				&& myParentBO.rightPart.endXC <= myMullion.x3cl) {
			myMullion.limitEndY3c = myParentBO.rightPart;

		}
		// //////
		if (myParentBO.leftPart.posInUse
				&& myParentBO.leftPart.startXC >= myMullion.x3
				&& myParentBO.leftPart.endXC <= myMullion.x3) {
			myMullion.limitEndY3 = myParentBO.leftPart;

		}
		if (myParentBO.bot2Part.posInUse
				&& myParentBO.bot2Part.startXC >= myMullion.x3
				&& myParentBO.bot2Part.endXC <= myMullion.x3) {
			myMullion.limitEndY3 = myParentBO.bot2Part;

		}
		if (myParentBO.bot3Part.posInUse
				&& myParentBO.bot3Part.startXC >= myMullion.x3
				&& myParentBO.bot3Part.endXC <= myMullion.x3) {
			myMullion.limitEndY3 = myParentBO.bot3Part;

		}
		if (myParentBO.bot1Part.posInUse
				&& myParentBO.bot1Part.startXC >= myMullion.x3
				&& myParentBO.bot1Part.endXC <= myMullion.x3) {
			myMullion.limitEndY3 = myParentBO.bot1Part;

		}
		if (myParentBO.rightPart.posInUse
				&& myParentBO.rightPart.startXC >= myMullion.x3
				&& myParentBO.rightPart.endXC <= myMullion.x3) {
			myMullion.limitEndY3 = myParentBO.rightPart;

		}
		// //////
		if (myParentBO.leftPart.posInUse
				&& myParentBO.leftPart.startXC >= myMullion.centerXe
				&& myParentBO.leftPart.endXC <= myMullion.centerXe) {
			myMullion.limitEndYC = myParentBO.leftPart;

			double intY = intersectY(myMullion.centerXe, vcEndY,
					myMullion.centerXs, vcStartY,
					myParentBO.myParent.leftPart.startXA,
					myParentBO.myParent.leftPart.startYA,
					myParentBO.myParent.leftPart.endXA,
					myParentBO.myParent.leftPart.startYA);

			double H = intY - myParentBO.myParent.leftPart.startYA;
			double B = myMullion.centerXs
					- myParentBO.myParent.leftPart.startXA;

			double distance = Math.sqrt((Math.pow(H, 2)) + Math.pow(B, 2));

			distance = // Math.sqrt((Math.pow(H,2)) + Math.pow(B, 2));
			Math.sqrt(Math.pow((Math.max(myMullion.centerXe,
					myParentBO.myParent.leftPart.startXA) - Math.min(
					myMullion.centerXe, myParentBO.myParent.leftPart.startXA)),
					2)
					+ Math.pow((Math.max(intY,
							myParentBO.myParent.leftPart.startYA) - Math.min(
							intY, myParentBO.myParent.leftPart.startYA)), 2));

			if (myParentBO.myParent.leftPart.notchLT.trim().length() > 0) {
				myParentBO.myParent.leftPart.notchLT = myParentBO.myParent.leftPart.notchLT
						+ ","
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.leftPart.notchLTi = myParentBO.myParent.leftPart.notchLT
						+ "," + distance / myFrame2.imperialscale.doubleValue();
			} else {
				myParentBO.myParent.leftPart.notchLT = ""
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.leftPart.notchLTi = "" + distance
						/ myFrame2.imperialscale.doubleValue();
			}

		}
		if (myParentBO.bot2Part.posInUse
				&& myParentBO.bot2Part.startXC >= myMullion.centerXe
				&& myParentBO.bot2Part.endXC <= myMullion.centerXe) {
			myMullion.limitEndYC = myParentBO.bot2Part;

			double intY = intersectY(myMullion.centerXe, vcEndY,
					myMullion.centerXs, vcStartY,
					myParentBO.myParent.bot2Part.startXA,
					myParentBO.myParent.bot2Part.startYA,
					myParentBO.myParent.bot2Part.endXA,
					myParentBO.myParent.bot2Part.startYA);

			double H = intY - myParentBO.myParent.bot2Part.startYA;
			double B = myMullion.centerXs
					- myParentBO.myParent.bot2Part.startXA;

			double distance = Math.sqrt((Math.pow(H, 2)) + Math.pow(B, 2));

			distance = // Math.sqrt((Math.pow(H,2)) + Math.pow(B, 2));
			Math.sqrt(Math.pow((Math.max(myMullion.centerXe,
					myParentBO.myParent.bot2Part.startXA) - Math.min(
					myMullion.centerXe, myParentBO.myParent.bot2Part.startXA)),
					2)
					+ Math.pow((Math.max(intY,
							myParentBO.myParent.bot2Part.startYA) - Math.min(
							intY, myParentBO.myParent.bot2Part.startYA)), 2));

			if (myParentBO.myParent.bot2Part.notchLT.trim().length() > 0) {
				myParentBO.myParent.bot2Part.notchLT = myParentBO.myParent.bot2Part.notchLT
						+ ","
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.bot2Part.notchLTi = myParentBO.myParent.bot2Part.notchLT
						+ "," + distance / myFrame2.imperialscale.doubleValue();
			} else {
				myParentBO.myParent.bot2Part.notchLT = ""
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.bot2Part.notchLTi = "" + distance
						/ myFrame2.imperialscale.doubleValue();
			}

		}
		if (myParentBO.bot3Part.posInUse
				&& myParentBO.bot3Part.startXC >= myMullion.centerXe
				&& myParentBO.bot3Part.endXC <= myMullion.centerXe) {
			myMullion.limitEndYC = myParentBO.bot3Part;

			double intY = intersectY(myMullion.centerXe, vcEndY,
					myMullion.centerXs, vcStartY,
					myParentBO.myParent.bot3Part.startXA,
					myParentBO.myParent.bot3Part.startYA,
					myParentBO.myParent.bot3Part.endXA,
					myParentBO.myParent.bot3Part.startYA);

			double H = intY - myParentBO.myParent.bot3Part.startYA;
			double B = myMullion.centerXs
					- myParentBO.myParent.bot3Part.startXA;

			double distance = Math.sqrt((Math.pow(H, 2)) + Math.pow(B, 2));

			distance = // Math.sqrt((Math.pow(H,2)) + Math.pow(B, 2));
			Math.sqrt(Math.pow((Math.max(myMullion.centerXe,
					myParentBO.myParent.bot3Part.startXA) - Math.min(
					myMullion.centerXe, myParentBO.myParent.bot3Part.startXA)),
					2)
					+ Math.pow((Math.max(intY,
							myParentBO.myParent.bot3Part.startYA) - Math.min(
							intY, myParentBO.myParent.bot3Part.startYA)), 2));

			if (myParentBO.myParent.bot3Part.notchLT.trim().length() > 0) {
				myParentBO.myParent.bot3Part.notchLT = myParentBO.myParent.bot3Part.notchLT
						+ ","
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.bot3Part.notchLTi = myParentBO.myParent.bot3Part.notchLT
						+ "," + distance / myFrame2.imperialscale.doubleValue();
			} else {
				myParentBO.myParent.bot3Part.notchLT = ""
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.bot3Part.notchLTi = "" + distance
						/ myFrame2.imperialscale.doubleValue();
			}

		}
		if (myParentBO.bot1Part.posInUse
				&& myParentBO.bot1Part.startXC >= myMullion.centerXe
				&& myParentBO.bot1Part.endXC <= myMullion.centerXe) {
			myMullion.limitEndYC = myParentBO.bot1Part;

			double intY = intersectY(myMullion.centerXe, vcEndY,
					myMullion.centerXs, vcStartY,
					myParentBO.myParent.bot1Part.startXA,
					myParentBO.myParent.bot1Part.startYA,
					myParentBO.myParent.bot1Part.endXA,
					myParentBO.myParent.bot1Part.startYA);

			double H = intY - myParentBO.myParent.bot1Part.startYA;
			double B = myMullion.centerXs
					- myParentBO.myParent.bot1Part.startXA;

			double distance = Math.sqrt((Math.pow(H, 2)) + Math.pow(B, 2));

			distance = // Math.sqrt((Math.pow(H,2)) + Math.pow(B, 2));
			Math.sqrt(Math.pow((Math.max(myMullion.centerXe,
					myParentBO.myParent.bot1Part.startXA) - Math.min(
					myMullion.centerXe, myParentBO.myParent.bot1Part.startXA)),
					2)
					+ Math.pow((Math.max(intY,
							myParentBO.myParent.bot1Part.startYA) - Math.min(
							intY, myParentBO.myParent.bot1Part.startYA)), 2));

			if (myParentBO.myParent.bot1Part.notchLT.trim().length() > 0) {
				myParentBO.myParent.bot1Part.notchLT = myParentBO.myParent.bot1Part.notchLT
						+ ","
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.bot1Part.notchLTi = myParentBO.myParent.bot1Part.notchLT
						+ "," + distance / myFrame2.imperialscale.doubleValue();
			} else {
				myParentBO.myParent.bot1Part.notchLT = ""
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.bot1Part.notchLTi = "" + distance
						/ myFrame2.imperialscale.doubleValue();
			}

		}
		if (myParentBO.rightPart.posInUse
				&& myParentBO.rightPart.startXC >= myMullion.x3
				&& myParentBO.rightPart.endXC <= myMullion.x3) {
			myMullion.limitEndYC = myParentBO.rightPart;
			double intY = intersectY(myMullion.centerXe, vcEndY,
					myMullion.centerXs, vcStartY,
					myParentBO.myParent.rightPart.startXA,
					myParentBO.myParent.rightPart.startYA,
					myParentBO.myParent.rightPart.endXA,
					myParentBO.myParent.rightPart.startYA);

			double H = intY - myParentBO.myParent.rightPart.startYA;
			double B = myMullion.centerXs
					- myParentBO.myParent.rightPart.startXA;

			double distance = Math.sqrt((Math.pow(H, 2)) + Math.pow(B, 2));

			distance = // Math.sqrt((Math.pow(H,2)) + Math.pow(B, 2));
			Math.sqrt(Math.pow(
					(Math.max(myMullion.centerXe,
							myParentBO.myParent.rightPart.startXA) - Math.min(
							myMullion.centerXe,
							myParentBO.myParent.rightPart.startXA)), 2)
					+ Math.pow((Math.max(intY,
							myParentBO.myParent.rightPart.startYA) - Math.min(
							intY, myParentBO.myParent.rightPart.startYA)), 2));

			if (myParentBO.myParent.rightPart.notchLT.trim().length() > 0) {
				myParentBO.myParent.rightPart.notchLT = myParentBO.myParent.rightPart.notchLT
						+ ","
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.rightPart.notchLTi = myParentBO.myParent.rightPart.notchLT
						+ "," + distance / myFrame2.imperialscale.doubleValue();
			} else {
				myParentBO.myParent.rightPart.notchLT = ""
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.rightPart.notchLTi = "" + distance
						/ myFrame2.imperialscale.doubleValue();
			}
		}

		// //////
		if (myParentBO.leftPart.posInUse
				&& myParentBO.leftPart.startXC >= myMullion.x4
				&& myParentBO.leftPart.endXC <= myMullion.x4) {
			myMullion.limitEndY4 = myParentBO.leftPart;

		}
		if (myParentBO.bot2Part.posInUse
				&& myParentBO.bot2Part.startXC >= myMullion.x4
				&& myParentBO.bot2Part.endXC <= myMullion.x4) {
			myMullion.limitEndY4 = myParentBO.bot2Part;

		}
		if (myParentBO.bot3Part.posInUse
				&& myParentBO.bot3Part.startXC >= myMullion.x4
				&& myParentBO.bot3Part.endXC <= myMullion.x4) {
			myMullion.limitEndY4 = myParentBO.bot3Part;

		}
		if (myParentBO.bot1Part.posInUse
				&& myParentBO.bot1Part.startXC >= myMullion.x4
				&& myParentBO.bot1Part.endXC <= myMullion.x4) {
			myMullion.limitEndY4 = myParentBO.bot1Part;

		}
		if (myParentBO.rightPart.posInUse
				&& myParentBO.rightPart.startXC >= myMullion.x4
				&& myParentBO.rightPart.endXC <= myMullion.x4) {
			myMullion.limitEndY4 = myParentBO.rightPart;

		}

		// //////
		if (myParentBO.leftPart.posInUse
				&& myParentBO.leftPart.startXC >= myMullion.x4al
				&& myParentBO.leftPart.endXC <= myMullion.x4al) {
			myMullion.limitEndY4a = myParentBO.leftPart;

		}
		if (myParentBO.bot2Part.posInUse
				&& myParentBO.bot2Part.startXC >= myMullion.x4al
				&& myParentBO.bot2Part.endXC <= myMullion.x4al) {
			myMullion.limitEndY4a = myParentBO.bot2Part;

		}
		if (myParentBO.bot3Part.posInUse
				&& myParentBO.bot3Part.startXC >= myMullion.x4al
				&& myParentBO.bot3Part.endXC <= myMullion.x4al) {
			myMullion.limitEndY4a = myParentBO.bot3Part;

		}
		if (myParentBO.bot1Part.posInUse
				&& myParentBO.bot1Part.startXC >= myMullion.x4al
				&& myParentBO.bot1Part.endXC <= myMullion.x4al) {
			myMullion.limitEndY4a = myParentBO.bot1Part;

		}
		if (myParentBO.rightPart.posInUse
				&& myParentBO.rightPart.startXC >= myMullion.x4al
				&& myParentBO.rightPart.endXC <= myMullion.x4al) {
			myMullion.limitEndY4a = myParentBO.rightPart;

		}
		return myMullion;
	}

	public Profiles getLimitEndOutM(final Profiles myMullion) {

		if (myParentBO.leftPart.posInUse
				&& myParentBO.leftPart.startXC >= myMullion.x3cl
				&& myParentBO.leftPart.endXC <= myMullion.x3cl) {
			myMullion.limitEndY3c = myParentBO.myParent.leftPart;

		}
		if (myParentBO.bot2Part.posInUse
				&& myParentBO.bot2Part.startXC >= myMullion.x3cl
				&& myParentBO.bot2Part.endXC <= myMullion.x3cl) {
			myMullion.limitEndY3c = myParentBO.myParent.bot2Part;

		}
		if (myParentBO.bot3Part.posInUse
				&& myParentBO.bot3Part.startXC >= myMullion.x3cl
				&& myParentBO.bot3Part.endXC <= myMullion.x3cl) {
			myMullion.limitEndY3c = myParentBO.myParent.bot3Part;

		}
		if (myParentBO.bot1Part.posInUse
				&& myParentBO.bot1Part.startXC >= myMullion.x3cl
				&& myParentBO.bot1Part.endXC <= myMullion.x3cl) {
			myMullion.limitEndY3c = myParentBO.myParent.bot1Part;

		}
		if (myParentBO.rightPart.posInUse
				&& myParentBO.rightPart.startXC >= myMullion.x3cl
				&& myParentBO.rightPart.endXC <= myMullion.x3cl) {
			myMullion.limitEndY3c = myParentBO.myParent.rightPart;

		}
		// //////
		if (myParentBO.leftPart.posInUse
				&& myParentBO.leftPart.startXC >= myMullion.x3
				&& myParentBO.leftPart.endXC <= myMullion.x3) {
			myMullion.limitEndY3 = myParentBO.myParent.leftPart;

		}
		if (myParentBO.bot2Part.posInUse
				&& myParentBO.bot2Part.startXC >= myMullion.x3
				&& myParentBO.bot2Part.endXC <= myMullion.x3) {
			myMullion.limitEndY3 = myParentBO.myParent.bot2Part;

		}
		if (myParentBO.bot3Part.posInUse
				&& myParentBO.bot3Part.startXC >= myMullion.x3
				&& myParentBO.bot3Part.endXC <= myMullion.x3) {
			myMullion.limitEndY3 = myParentBO.myParent.bot3Part;

		}
		if (myParentBO.bot1Part.posInUse
				&& myParentBO.bot1Part.startXC >= myMullion.x3
				&& myParentBO.bot1Part.endXC <= myMullion.x3) {
			myMullion.limitEndY3 = myParentBO.myParent.bot1Part;

		}
		if (myParentBO.rightPart.posInUse
				&& myParentBO.rightPart.startXC >= myMullion.x3
				&& myParentBO.rightPart.endXC <= myMullion.x3) {
			myMullion.limitEndY3 = myParentBO.myParent.rightPart;

		}
		// //////
		if (myParentBO.leftPart.posInUse
				&& myParentBO.leftPart.startXC >= myMullion.centerXe
				&& myParentBO.leftPart.endXC <= myMullion.centerXe) {
			myMullion.limitEndYC = myParentBO.myParent.leftPart;

			double intY = intersectY(myMullion.centerXe, vcEndY,
					myMullion.centerXs, vcStartY,
					myParentBO.myParent.leftPart.startXA,
					myParentBO.myParent.leftPart.startYA,
					myParentBO.myParent.leftPart.endXA,
					myParentBO.myParent.leftPart.startYA);

			double H = intY - myParentBO.myParent.leftPart.startYA;
			double B = myMullion.centerXs
					- myParentBO.myParent.leftPart.startXA;

			double distance = Math.sqrt((Math.pow(H, 2)) + Math.pow(B, 2));

			distance = // Math.sqrt((Math.pow(H,2)) + Math.pow(B, 2));
			Math.sqrt(Math.pow((Math.max(myMullion.centerXe,
					myParentBO.myParent.leftPart.startXA) - Math.min(
					myMullion.centerXe, myParentBO.myParent.leftPart.startXA)),
					2)
					+ Math.pow((Math.max(intY,
							myParentBO.myParent.leftPart.startYA) - Math.min(
							intY, myParentBO.myParent.leftPart.startYA)), 2));

			if (myParentBO.myParent.leftPart.notchLT.trim().length() > 0) {
				myParentBO.myParent.leftPart.notchLT = myParentBO.myParent.leftPart.notchLT
						+ ","
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.leftPart.notchLTi = myParentBO.myParent.leftPart.notchLT
						+ "," + distance / myFrame2.imperialscale.doubleValue();
			} else {
				myParentBO.myParent.leftPart.notchLT = ""
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.leftPart.notchLTi = "" + distance
						/ myFrame2.imperialscale.doubleValue();
			}

		}
		if (myParentBO.bot2Part.posInUse
				&& myParentBO.bot2Part.startXC >= myMullion.centerXe
				&& myParentBO.bot2Part.endXC <= myMullion.centerXe) {
			myMullion.limitEndYC = myParentBO.myParent.bot2Part;
			double intY = intersectY(myMullion.centerXe, vcEndY,
					myMullion.centerXs, vcStartY,
					myParentBO.myParent.bot2Part.startXA,
					myParentBO.myParent.bot2Part.startYA,
					myParentBO.myParent.bot2Part.endXA,
					myParentBO.myParent.bot2Part.startYA);

			double H = intY - myParentBO.myParent.bot2Part.startYA;
			double B = myMullion.centerXs
					- myParentBO.myParent.bot2Part.startXA;

			double distance = Math.sqrt((Math.pow(H, 2)) + Math.pow(B, 2));

			distance = // Math.sqrt((Math.pow(H,2)) + Math.pow(B, 2));
			Math.sqrt(Math.pow((Math.max(myMullion.centerXe,
					myParentBO.myParent.bot2Part.startXA) - Math.min(
					myMullion.centerXe, myParentBO.myParent.bot2Part.startXA)),
					2)
					+ Math.pow((Math.max(intY,
							myParentBO.myParent.bot2Part.startYA) - Math.min(
							intY, myParentBO.myParent.bot2Part.startYA)), 2));

			if (myParentBO.myParent.bot2Part.notchLT.trim().length() > 0) {
				myParentBO.myParent.bot2Part.notchLT = myParentBO.myParent.bot2Part.notchLT
						+ ","
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.bot2Part.notchLTi = myParentBO.myParent.bot2Part.notchLT
						+ "," + distance / myFrame2.imperialscale.doubleValue();
			} else {
				myParentBO.myParent.bot2Part.notchLT = ""
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.bot2Part.notchLTi = "" + distance
						/ myFrame2.imperialscale.doubleValue();
			}
		}
		if (myParentBO.bot3Part.posInUse
				&& myParentBO.bot3Part.startXC >= myMullion.centerXe
				&& myParentBO.bot3Part.endXC <= myMullion.centerXe) {
			myMullion.limitEndYC = myParentBO.myParent.bot3Part;
			double intY = intersectY(myMullion.centerXe, vcEndY,
					myMullion.centerXs, vcStartY,
					myParentBO.myParent.bot3Part.startXA,
					myParentBO.myParent.bot3Part.startYA,
					myParentBO.myParent.bot3Part.endXA,
					myParentBO.myParent.bot3Part.startYA);

			double H = intY - myParentBO.myParent.bot3Part.startYA;
			double B = myMullion.centerXs
					- myParentBO.myParent.bot3Part.startXA;

			double distance = Math.sqrt((Math.pow(H, 2)) + Math.pow(B, 2));

			distance = // Math.sqrt((Math.pow(H,2)) + Math.pow(B, 2));
			Math.sqrt(Math.pow((Math.max(myMullion.centerXe,
					myParentBO.myParent.bot3Part.startXA) - Math.min(
					myMullion.centerXe, myParentBO.myParent.bot3Part.startXA)),
					2)
					+ Math.pow((Math.max(intY,
							myParentBO.myParent.bot3Part.startYA) - Math.min(
							intY, myParentBO.myParent.bot3Part.startYA)), 2));

			if (myParentBO.myParent.bot3Part.notchLT.trim().length() > 0) {
				myParentBO.myParent.bot3Part.notchLT = myParentBO.myParent.bot3Part.notchLT
						+ ","
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.bot3Part.notchLTi = myParentBO.myParent.bot3Part.notchLT
						+ "," + distance / myFrame2.imperialscale.doubleValue();
			} else {
				myParentBO.myParent.bot3Part.notchLT = ""
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.bot3Part.notchLTi = "" + distance
						/ myFrame2.imperialscale.doubleValue();
			}

		}
		if (myParentBO.bot1Part.posInUse
				&& myParentBO.bot1Part.startXC >= myMullion.centerXe
				&& myParentBO.bot1Part.endXC <= myMullion.centerXe) {
			myMullion.limitEndYC = myParentBO.myParent.bot1Part;
			double intY = intersectY(myMullion.centerXe, vcEndY,
					myMullion.centerXs, vcStartY,
					myParentBO.myParent.bot1Part.startXA,
					myParentBO.myParent.bot1Part.startYA,
					myParentBO.myParent.bot1Part.endXA,
					myParentBO.myParent.bot1Part.startYA);

			double H = intY - myParentBO.myParent.bot1Part.startYA;
			double B = myMullion.centerXs
					- myParentBO.myParent.bot1Part.startXA;

			double distance = Math.sqrt((Math.pow(H, 2)) + Math.pow(B, 2));

			distance = // Math.sqrt((Math.pow(H,2)) + Math.pow(B, 2));
			Math.sqrt(Math.pow((Math.max(myMullion.centerXe,
					myParentBO.myParent.bot1Part.startXA) - Math.min(
					myMullion.centerXe, myParentBO.myParent.bot1Part.startXA)),
					2)
					+ Math.pow((Math.max(intY,
							myParentBO.myParent.bot1Part.startYA) - Math.min(
							intY, myParentBO.myParent.bot1Part.startYA)), 2));

			if (myParentBO.myParent.bot1Part.notchLT.trim().length() > 0) {
				myParentBO.myParent.bot1Part.notchLT = myParentBO.myParent.bot1Part.notchLT
						+ ","
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.bot1Part.notchLTi = myParentBO.myParent.bot1Part.notchLT
						+ "," + distance / myFrame2.imperialscale.doubleValue();
			} else {
				myParentBO.myParent.bot1Part.notchLT = ""
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.bot1Part.notchLTi = "" + distance
						/ myFrame2.imperialscale.doubleValue();
			}

		}
		if (myParentBO.rightPart.posInUse
				&& myParentBO.rightPart.startXC >= myMullion.x3
				&& myParentBO.rightPart.endXC <= myMullion.x3) {
			myMullion.limitEndYC = myParentBO.myParent.rightPart;
			double intY = intersectY(myMullion.centerXe, vcEndY,
					myMullion.centerXs, vcStartY,
					myParentBO.myParent.rightPart.startXA,
					myParentBO.myParent.rightPart.startYA,
					myParentBO.myParent.rightPart.endXA,
					myParentBO.myParent.rightPart.startYA);

			double H = intY - myParentBO.myParent.rightPart.startYA;
			double B = myMullion.centerXs
					- myParentBO.myParent.rightPart.startXA;

			double distance = Math.sqrt((Math.pow(H, 2)) + Math.pow(B, 2));

			distance = // Math.sqrt((Math.pow(H,2)) + Math.pow(B, 2));
			Math.sqrt(Math.pow(
					(Math.max(myMullion.centerXe,
							myParentBO.myParent.rightPart.startXA) - Math.min(
							myMullion.centerXe,
							myParentBO.myParent.rightPart.startXA)), 2)
					+ Math.pow((Math.max(intY,
							myParentBO.myParent.rightPart.startYA) - Math.min(
							intY, myParentBO.myParent.rightPart.startYA)), 2));

			if (myParentBO.myParent.rightPart.notchLT.trim().length() > 0) {
				myParentBO.myParent.rightPart.notchLT = myParentBO.myParent.rightPart.notchLT
						+ ","
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.rightPart.notchLTi = myParentBO.myParent.rightPart.notchLT
						+ "," + distance / myFrame2.imperialscale.doubleValue();
			} else {
				myParentBO.myParent.rightPart.notchLT = ""
						+ (int) (distance / (myFrame2.metricscale.doubleValue() * 100));
				myParentBO.myParent.rightPart.notchLTi = "" + distance
						/ myFrame2.imperialscale.doubleValue();
			}

		}

		// //////
		if (myParentBO.leftPart.posInUse
				&& myParentBO.leftPart.startXC >= myMullion.x4
				&& myParentBO.leftPart.endXC <= myMullion.x4) {
			myMullion.limitEndY4 = myParentBO.myParent.leftPart;

		}
		if (myParentBO.bot2Part.posInUse
				&& myParentBO.bot2Part.startXC >= myMullion.x4
				&& myParentBO.bot2Part.endXC <= myMullion.x4) {
			myMullion.limitEndY4 = myParentBO.myParent.bot2Part;

		}
		if (myParentBO.bot3Part.posInUse
				&& myParentBO.bot3Part.startXC >= myMullion.x4
				&& myParentBO.bot3Part.endXC <= myMullion.x4) {
			myMullion.limitEndY4 = myParentBO.myParent.bot3Part;

		}
		if (myParentBO.bot1Part.posInUse
				&& myParentBO.bot1Part.startXC >= myMullion.x4
				&& myParentBO.bot1Part.endXC <= myMullion.x4) {
			myMullion.limitEndY4 = myParentBO.myParent.bot1Part;

		}
		if (myParentBO.rightPart.posInUse
				&& myParentBO.rightPart.startXC >= myMullion.x4
				&& myParentBO.rightPart.endXC <= myMullion.x4) {
			myMullion.limitEndY4 = myParentBO.myParent.rightPart;

		}

		// //////
		if (myParentBO.leftPart.posInUse
				&& myParentBO.leftPart.startXC >= myMullion.x4al
				&& myParentBO.leftPart.endXC <= myMullion.x4al) {
			myMullion.limitEndY4a = myParentBO.myParent.leftPart;

		}
		if (myParentBO.bot2Part.posInUse
				&& myParentBO.bot2Part.startXC >= myMullion.x4al
				&& myParentBO.bot2Part.endXC <= myMullion.x4al) {
			myMullion.limitEndY4a = myParentBO.myParent.bot2Part;

		}
		if (myParentBO.bot3Part.posInUse
				&& myParentBO.bot3Part.startXC >= myMullion.x4al
				&& myParentBO.bot3Part.endXC <= myMullion.x4al) {
			myMullion.limitEndY4a = myParentBO.myParent.bot3Part;

		}
		if (myParentBO.bot1Part.posInUse
				&& myParentBO.bot1Part.startXC >= myMullion.x4al
				&& myParentBO.bot1Part.endXC <= myMullion.x4al) {
			myMullion.limitEndY4a = myParentBO.myParent.bot1Part;

		}
		if (myParentBO.rightPart.posInUse
				&& myParentBO.rightPart.startXC >= myMullion.x4al
				&& myParentBO.rightPart.endXC <= myMullion.x4al) {
			myMullion.limitEndY4a = myParentBO.myParent.rightPart;

		}
		return myMullion;
	}

	public void getAlphaTheta(final Profiles myMullion) {

		myMullion.posCondition = posCondition;
		newAlpha = 0;//
		newAlpha2 = 0;
		newAlpha3 = 0;
		newAlphaA = 0;
		newAlphaC = 0;

		// newAlphaF = 0;
		// newAlpha2F = 0;
		// newAlpha3F = 0;
		// newAlphaAF = 0;
		// newAlphaCF = 0;

		myThetaBot = 0;//
		myThetaBot2 = 0;
		myThetaBot3 = 0;
		myThetaBotA = 0;
		myThetaBotC = 0;

		inArchStart = 0;
		inArchEnd = 0;
		inMiddleS = false;

		final double myMinX = Math.min(myParentBO.myParent.startingX,
				myParentBO.myParent.bX4);

		Math.min(myParentBO.myParent.bX2, myParentBO.myParent.bX3);

		if (myParentBO.shapeID > 10 || myParentBO.radius1 > 0
				|| myParentBO.noSidesTop > 1) {

			if (myMullion.x2cl <= myMinX + myParentBO.myParent.dimA1
					&& myParentBO.noSidesTop == 1 && myParentBO.lean == 2
					&& !startIn) {

				newAlpha = Math.atan(myParentBO.heightPix / myParentBO.dimA1);
				// newAlphaF =
				// Math
				// .atan(myParentBO.myParent.heightPix
				// / myParentBO.myParent.dimA1);

			}

			if (myMullion.x1al < myMinX + myParentBO.myParent.dimA0
					&& myParentBO.noSidesTop == 1 && myParentBO.lean == 3
					&& !startIn) {

				newAlpha = Math.atan(myParentBO.heightPix / myParentBO.dimA0);
				// newAlphaF =
				// Math
				// .atan(myParentBO.myParent.heightPix
				// / myParentBO.myParent.dimA0);

			}
			if (myMullion.x1al > myMinX + myParentBO.myParent.dimA1
					+ myParentBO.myParent.dimA0
					&& myParentBO.noSidesTop == 1
					&& myParentBO.lean == 3
					&& !startIn) {

				newAlpha = Math.atan(myParentBO.heightPix / myParentBO.dimA2);
				// newAlphaF =
				// Math
				// .atan(myParentBO.myParent.heightPix
				// / myParentBO.myParent.dimA2);
				//

			}
			if (myMullion.x1al > myMinX + myParentBO.myParent.dimA1
					&& myParentBO.noSidesTop == 1 && myParentBO.lean == 1
					&& !startIn) {

				newAlpha = Math.atan(myParentBO.heightPix / myParentBO.dimA2);
				// newAlphaF =
				// Math
				// .atan(myParentBO.myParent.heightPix
				// / myParentBO.myParent.dimA2);

			}

			// ////////
			if (myMullion.x3cl < myMinX + myParentBO.myParent.dimC2
					&& myParentBO.noSidesBot == 1
					&& (myParentBO.lean3 == 1 || myParentBO.lean3 == 3)
					&& !startIn) {

				myThetaBot = Math.atan(myParentBO.heightPix / myParentBO.dimC2);
				// myThetaBotF =
				// Math
				// .atan(myParentBO.myParent.heightPix
				// / myParentBO.myParent.dimC2);

			}
			if (myMullion.x4al > myParentBO.myParent.right.endX
					&& myParentBO.noSidesBot == 1 && myParentBO.lean3 == 1
					&& !endIn) {

				myThetaBot = Math.atan(myParentBO.heightPix / myParentBO.dimC1);
				// myThetaBotF =
				// Math
				// .atan(myParentBO.myParent.heightPix
				// / myParentBO.myParent.dimC1);

			}

			if (myMullion.x2cl < myMinX + myParentBO.myParent.dimA1
					&& myParentBO.noSidesTop > 1 && !startIn) {

				newAlpha = Math.atan(myParentBO.dimA1 / myParentBO.dimD2);
				// newAlphaF =
				// Math
				// .atan(myParentBO.myParent.dimA1
				// / myParentBO.myParent.dimD2);

			}
			if (myMullion.x1al > myParentBO.myParent.top2.startX
					&& myParentBO.myParent.top2.posInUse
					&& myParentBO.noSidesTop > 1 && !startIn) {

				newAlpha = Math.atan(myParentBO.dimA2 / myParentBO.dimB1);
				// newAlphaF =
				// Math
				// .atan(myParentBO.myParent.dimA2
				// / myParentBO.myParent.dimB1);
				//

			}
			// /////
			if (myMullion.x3cl < myMinX + myParentBO.myParent.dimC2
					&& myParentBO.noSidesBot > 1 && !endIn) {
				myThetaBot = Math.atan(myParentBO.dimC2 / myParentBO.dimD0);
				// myThetaBotF =
				// Math
				// .atan(myParentBO.myParent.dimC2
				// / myParentBO.myParent.dimD0);

			}
			if (myMullion.x4al > myMinX + myParentBO.myParent.dimC2
					+ myParentBO.myParent.dimC1
					&& myParentBO.noSidesBot > 1 && !endIn) {

				myThetaBot = Math.atan(myParentBO.dimC0 / myParentBO.dimB2);
				// myThetaBotF =
				// Math
				// .atan(myParentBO.myParent.dimC0
				// / myParentBO.myParent.dimB2);

			}
			if (myMullion.centerXs == myMinX + myParentBO.myParent.dimA1
					&& myParentBO.noSidesTop > 1 && !startIn) {

				newAlpha = Math.atan(myParentBO.dimA1 / myParentBO.dimD2);
				// newAlphaF =
				// Math
				// .atan(myParentBO.myParent.dimA1
				// / myParentBO.myParent.dimD2);

				limitStartXsAm = myParentBO.myParent.top2.startXA;
				limitStartYsAm = myParentBO.myParent.top2.startYA;
				limitStartXeAm = myParentBO.myParent.top2.endXA;
				limitStartYeAm = myParentBO.myParent.top2.endYA;
				limitStartXsBAm = myParentBO.myParent.top2.startXBA;
				limitStartYsBAm = myParentBO.myParent.top2.startYBA;
				limitStartXeBAm = myParentBO.myParent.top2.endXBA;
				limitStartYeBAm = myParentBO.myParent.top2.endYBA;

				limitStartXsBm = myParentBO.myParent.top2.startX;
				limitStartYsBm = myParentBO.myParent.top2.startY;
				limitStartXeBm = myParentBO.myParent.top2.endX;
				limitStartYeBm = myParentBO.myParent.top2.endY;

				dimTM = myParentBO.myParent.top2.partDimM;
				dimTA = myParentBO.myParent.top2.partDimA;
				newAlpha2 = Math.atan(myParentBO.dimA2 / myParentBO.dimB1);
				// newAlpha2F =
				// Math
				// .atan(myParentBO.myParent.dimA2
				// / myParentBO.myParent.dimB1);
				inMiddleS = true;
				limitStart = myParentBO.myParent.top1Part;
				limitStart2 = myParentBO.myParent.top2Part;

			}

			if (myMullion.x2cl < myMinX + myParentBO.myParent.dimA1
					+ myParentBO.myParent.dimA3
					&& newStartingXLBa > myMinX + myParentBO.myParent.dimA1
					&& myParentBO.noSidesTop == 3 && !startIn) {

				newAlpha = 0;
				// newAlphaF = 0;

			}
			if (myMullion.x3cl < myMinX + myParentBO.myParent.dimC2
					+ myParentBO.myParent.dimC1
					&& myMullion.x4al > myMinX + myParentBO.myParent.dimC2
					&& myParentBO.noSidesBot == 3 && !endIn) {

				newAlpha = 0;
				// newAlphaF = 0;

			}

			// ///
			if (myParentBO.shapeID == 700) {

				newAlpha = Math.atan(myParentBO.widthPix / myParentBO.dimD2);
				// newAlphaF =
				// Math
				// .atan(myParentBO.myParent.widthPix
				// / myParentBO.myParent.dimD2);

			} else if (myParentBO.shapeID == 701) {

				newAlpha = Math.atan(myParentBO.widthPix / myParentBO.dimB1);
				// newAlphaF =
				// Math
				// .atan(myParentBO.myParent.widthPix
				// / myParentBO.myParent.dimB1);

			} else if (myParentBO.shapeID == 702) {
				if (myMullion.x1al < myMinX + myParentBO.myParent.dimD2) {

					newAlpha = Math
							.atan(myParentBO.widthPix / myParentBO.dimD2);
					// newAlphaF =
					// Math
					// .atan(myParentBO.myParent.widthPix
					// / myParentBO.myParent.dimD2);

				}
				if (myMullion.x2cl > myMinX + myParentBO.myParent.dimD2) {

					newAlpha = Math
							.atan(myParentBO.widthPix / myParentBO.dimD0);
					// newAlphaF =
					// Math
					// .atan(myParentBO.myParent.widthPix
					// / myParentBO.myParent.dimD0);

				}

			} else if (myParentBO.shapeID == 703) {
				if (myMullion.x1al < myMinX + myParentBO.myParent.dimB0) {

					myThetaBot = Math.atan(myParentBO.widthPix
							/ myParentBO.dimB0);
					// myThetaBotF =
					// Math
					// .atan(myParentBO.myParent.widthPix
					// / myParentBO.myParent.dimB0);

				}
				if (myMullion.x2cl > myMinX + myParentBO.myParent.dimB0) {

					myThetaBot = Math.atan(myParentBO.widthPix
							/ myParentBO.dimB2);
					// myThetaBotF =
					// Math
					// .atan(myParentBO.myParent.widthPix
					// / myParentBO.myParent.dimB2);
					//

				}

			} else if (myParentBO.shapeID == 704) {

			} else if (myParentBO.shapeID == 705) {

				newAlpha = Math.atan(myParentBO.widthPix / myParentBO.dimD2);
				// newAlphaF =
				// Math
				// .atan(myParentBO.myParent.widthPix
				// / myParentBO.myParent.dimD2);

			} else if (myParentBO.shapeID == 706) {

				myThetaBot = Math.atan(myParentBO.widthPix / myParentBO.dimB2);
				// myThetaBotF =
				// Math
				// .atan(myParentBO.myParent.widthPix
				// / myParentBO.myParent.dimB2);
				//

			}
		}
	}

	public void recalcInitOpenings() {

		final Object[] initOpeningObjects = myParentBO.myParent.openings
				.toArray();

		myParentBO.myParent.openings.clear();

		for (final Object initOpeningObject : initOpeningObjects) {

			done = false;
			if (alreadyExist != 1) {
				if (((OpeningObject) initOpeningObject).endCol <= myParentBO.mullion.rowCol
						|| ((OpeningObject) initOpeningObject).startCol > myParentBO.mullion.rowCol) {
					shape = ((OpeningObject) initOpeningObject).shapeID;
					startcol = ((OpeningObject) initOpeningObject).startCol;
					startrow = ((OpeningObject) initOpeningObject).startRow;
					endcol = ((OpeningObject) initOpeningObject).endCol;
					endrow = ((OpeningObject) initOpeningObject).endRow;
					myParentBO.myParent.openings.add(this.setOpening(shape,
							startcol, startrow, endcol, endrow,
							initOpeningObject, false,
							((OpeningObject) initOpeningObject).leftIn,
							((OpeningObject) initOpeningObject).rightIn,
							myParentBO.mullion));
					done = true;
				} else if (((OpeningObject) initOpeningObject).endCol >= myParentBO.mullion.rowCol
						&& ((OpeningObject) initOpeningObject).startCol <= myParentBO.mullion.rowCol
						&& ((OpeningObject) initOpeningObject).startRow >= myParentBO.mullion.startPos
						&& ((OpeningObject) initOpeningObject).endRow <= myParentBO.mullion.endPos) {

					final ShapeDivision shapeDiv = new ShapeDivision(
							((OpeningObject) initOpeningObject).shapeID, 1,
							cOrM);

					if (shapeDiv.vcPossible) {
						if (cOrM <= 2) {
							if (((OpeningObject) initOpeningObject).contentMid >= 2) {
								myParentBO.mullion.openingIDLB = ((OpeningObject) initOpeningObject).sashObjectMid.userDefinedOpeningID;
								myParentBO.mullion.openingTypeLB = ((OpeningObject) initOpeningObject).sashObjectMid.openingClass;
							} else {
								myParentBO.mullion.openingIDLB = 1;
								myParentBO.mullion.openingTypeLB = 0;
							}
							myParentBO.mullion.openingIDRT = 1;
							myParentBO.mullion.openingTypeRT = 0;
						}

						prevShape = shapeDiv.resultLT;
						newShape = shapeDiv.resultRB;

						shape = prevShape;// shapeDiv.resultLT;
						startcol = ((OpeningObject) initOpeningObject).startCol;
						startrow = ((OpeningObject) initOpeningObject).startRow;
						endcol = myParentBO.mullion.rowCol;
						endrow = ((OpeningObject) initOpeningObject).endRow;
						myParentBO.myParent.openings.add(this.setOpening(shape,
								startcol, startrow, endcol, endrow,
								initOpeningObject, false,
								((OpeningObject) initOpeningObject).leftIn,
								true, myParentBO.mullion));
						done = true;

						shape = newShape;// shapeDiv.resultRB;
						startcol = myParentBO.mullion.rowCol + 1;
						startrow = ((OpeningObject) initOpeningObject).startRow;
						if (((OpeningObject) initOpeningObject).endCol < myParentBO.xCols) {
							endcol = ((OpeningObject) initOpeningObject).endCol;
						} else {
							endcol = myParentBO.xCols;
						}
						endrow = ((OpeningObject) initOpeningObject).endRow;
						myParentBO.myParent.openings.add(this.setOpening(shape,
								startcol, startrow, endcol, endrow,
								initOpeningObject, true, true,
								((OpeningObject) initOpeningObject).rightIn,
								myParentBO.mullion));

						done = true;
					} else {
						goodToDivide = false;
					}
				} else if (((OpeningObject) initOpeningObject).endCol >= myParentBO.mullion.rowCol
						&& ((OpeningObject) initOpeningObject).startCol <= myParentBO.mullion.rowCol
						&& ((OpeningObject) initOpeningObject).startRow > myParentBO.mullion.endPos
						|| ((OpeningObject) initOpeningObject).endRow < myParentBO.mullion.startPos) {
					shape = ((OpeningObject) initOpeningObject).shapeID;
					startcol = ((OpeningObject) initOpeningObject).startCol;
					startrow = ((OpeningObject) initOpeningObject).startRow;
					endcol = ((OpeningObject) initOpeningObject).endCol;
					endrow = ((OpeningObject) initOpeningObject).endRow;
					myParentBO.myParent.openings.add(this.setOpening(shape,
							startcol, startrow, endcol, endrow,
							initOpeningObject, false,
							((OpeningObject) initOpeningObject).leftIn,
							((OpeningObject) initOpeningObject).rightIn,
							myParentBO.mullion));
					done = true;
				}

			} else {

				if (((OpeningObject) initOpeningObject).endCol < myParentBO.mullion.rowCol) {
					shape = ((OpeningObject) initOpeningObject).shapeID;
					startcol = ((OpeningObject) initOpeningObject).startCol;
					startrow = ((OpeningObject) initOpeningObject).startRow;
					endcol = ((OpeningObject) initOpeningObject).endCol;
					endrow = ((OpeningObject) initOpeningObject).endRow;
					myParentBO.myParent.openings.add(this.setOpening(shape,
							startcol, startrow, endcol, endrow,
							initOpeningObject, false,
							((OpeningObject) initOpeningObject).leftIn,
							((OpeningObject) initOpeningObject).rightIn,
							myParentBO.mullion));
					done = true;
				} else if (((OpeningObject) initOpeningObject).startCol > myParentBO.mullion.rowCol) {
					shape = ((OpeningObject) initOpeningObject).shapeID;
					startcol = ((OpeningObject) initOpeningObject).startCol + 1;
					startrow = ((OpeningObject) initOpeningObject).startRow;

					endcol = ((OpeningObject) initOpeningObject).endCol + 1;
					endrow = ((OpeningObject) initOpeningObject).endRow;

					if (endcol > myParentBO.xCols) {
						endcol = myParentBO.xCols;
					}
					myParentBO.myParent.openings.add(this.setOpening(shape,
							startcol, startrow, endcol, endrow,
							initOpeningObject, false,
							((OpeningObject) initOpeningObject).leftIn,
							((OpeningObject) initOpeningObject).rightIn,
							myParentBO.mullion));
					done = true;

				} else if (((OpeningObject) initOpeningObject).startCol <= myParentBO.mullion.rowCol
						&& ((OpeningObject) initOpeningObject).endCol >= myParentBO.mullion.rowCol
						&& ((OpeningObject) initOpeningObject).startRow == myParentBO.mullion.startPos) {

					final ShapeDivision shapeDiv = new ShapeDivision(
							((OpeningObject) initOpeningObject).shapeID, 1,
							cOrM);

					if (shapeDiv.vcPossible) {
						if (cOrM <= 2) {
							if (((OpeningObject) initOpeningObject).contentMid == 2) {
								myParentBO.mullion.openingIDLB = ((OpeningObject) initOpeningObject).sashObjectMid.userDefinedOpeningID;
								myParentBO.mullion.openingTypeLB = ((OpeningObject) initOpeningObject).sashObjectMid.openingClass;
							}
							if (((OpeningObject) initOpeningObject).contentMid == 3) {
								myParentBO.mullion.openingIDLB = ((OpeningObject) initOpeningObject).userDefinedOpeningID;
								myParentBO.mullion.openingTypeLB = ((OpeningObject) initOpeningObject).openingClass;
							} else {
								myParentBO.mullion.openingIDLB = 1;
								myParentBO.mullion.openingTypeLB = 1;
							}
							myParentBO.mullion.openingIDRT = 1;
							myParentBO.mullion.openingTypeRT = 0;
						}

						prevShape = shape = shapeDiv.resultLT;
						newShape = shapeDiv.resultRB;

						startcol = ((OpeningObject) initOpeningObject).startCol;
						startrow = ((OpeningObject) initOpeningObject).startRow;
						endcol = myParentBO.mullion.rowCol;
						endrow = ((OpeningObject) initOpeningObject).endRow;
						myParentBO.myParent.openings.add(this.setOpening(shape,
								startcol, startrow, endcol, endrow,
								initOpeningObject, false,
								((OpeningObject) initOpeningObject).leftIn,
								true, myParentBO.mullion));
						done = true;

						shape = newShape;// shapeDiv.resultRB;
						startcol = myParentBO.mullion.rowCol + 1;
						startrow = ((OpeningObject) initOpeningObject).startRow;
						endcol = ((OpeningObject) initOpeningObject).endCol + 1;
						if (endcol > myParentBO.xCols) {
							endcol = myParentBO.xCols;
						}
						endrow = ((OpeningObject) initOpeningObject).endRow;
						myParentBO.myParent.openings.add(this.setOpening(shape,
								startcol, startrow, endcol, endrow,
								initOpeningObject, true, true,
								((OpeningObject) initOpeningObject).rightIn,
								myParentBO.mullion));
						done = true;
					} else {
						goodToDivide = false;
					}
				} else if (((OpeningObject) initOpeningObject).startCol <= myParentBO.mullion.rowCol
						&& ((OpeningObject) initOpeningObject).endCol >= myParentBO.mullion.rowCol
						&& ((OpeningObject) initOpeningObject).startRow != myParentBO.mullion.startPos) {

					shape = ((OpeningObject) initOpeningObject).shapeID;
					startcol = ((OpeningObject) initOpeningObject).startCol;
					startrow = ((OpeningObject) initOpeningObject).startRow;
					endcol = ((OpeningObject) initOpeningObject).endCol + 1;
					if (endcol > myParentBO.xCols) {
						endcol = myParentBO.xCols;
					}
					endrow = ((OpeningObject) initOpeningObject).endRow;
					myParentBO.myParent.openings.add(this.setOpening(shape,
							startcol, startrow, endcol, endrow,
							initOpeningObject, false,
							((OpeningObject) initOpeningObject).leftIn,
							((OpeningObject) initOpeningObject).rightIn,
							myParentBO.mullion));
					done = true;

				}

			}

		}

	}

	public void recalInitOpeningsSash() {

		final Object[] initOpeningObjects = myParentBO.openings.toArray();

		myParentBO.openings.clear();

		for (final Object initOpeningObject : initOpeningObjects) {
			done = false;
			if (alreadyExist != 1) {
				if (((OpeningObject) initOpeningObject).endCol <= myParentBO.mullion.rowCol
						|| ((OpeningObject) initOpeningObject).startCol > myParentBO.mullion.rowCol) {
					shape = ((OpeningObject) initOpeningObject).shapeID;
					startcol = ((OpeningObject) initOpeningObject).startCol;
					startrow = ((OpeningObject) initOpeningObject).startRow;
					endcol = ((OpeningObject) initOpeningObject).endCol;
					endrow = ((OpeningObject) initOpeningObject).endRow;
					myParentBO.openings.add(this.setOpening(shape, startcol,
							startrow, endcol, endrow, initOpeningObject, false,
							((OpeningObject) initOpeningObject).leftIn,
							((OpeningObject) initOpeningObject).rightIn,
							myParentBO.mullion));
					done = true;
				} else if (((OpeningObject) initOpeningObject).endCol >= myParentBO.mullion.rowCol
						&& ((OpeningObject) initOpeningObject).startCol <= myParentBO.mullion.rowCol
						&& ((OpeningObject) initOpeningObject).startRow >= myParentBO.mullion.startPos
						&& ((OpeningObject) initOpeningObject).endRow <= myParentBO.mullion.endPos) {

					final ShapeDivision shapeDiv = new ShapeDivision(
							((OpeningObject) initOpeningObject).shapeID, 1,
							cOrM);

					if (shapeDiv.vcPossible) {
						prevShape = shapeDiv.resultLT;
						newShape = shapeDiv.resultRB;

						shape = prevShape;// shapeDiv.resultLT;
						startcol = ((OpeningObject) initOpeningObject).startCol;
						startrow = ((OpeningObject) initOpeningObject).startRow;
						endcol = myParentBO.mullion.rowCol;
						endrow = ((OpeningObject) initOpeningObject).endRow;
						myParentBO.openings.add(this.setOpening(shape,
								startcol, startrow, endcol, endrow,
								initOpeningObject, false,
								((OpeningObject) initOpeningObject).leftIn,
								true, myParentBO.mullion));
						done = true;

						shape = newShape;// shapeDiv.resultRB;
						startcol = myParentBO.mullion.rowCol + 1;
						startrow = ((OpeningObject) initOpeningObject).startRow;
						if (((OpeningObject) initOpeningObject).endCol < myParentBO.xCols) {
							endcol = ((OpeningObject) initOpeningObject).endCol;
						} else {
							endcol = myParentBO.xCols;
						}
						endrow = ((OpeningObject) initOpeningObject).endRow;
						myParentBO.openings.add(this.setOpening(shape,
								startcol, startrow, endcol, endrow,
								initOpeningObject, true, true,
								((OpeningObject) initOpeningObject).rightIn,
								myParentBO.mullion));
						done = true;
					} else {
						goodToDivide = false;
					}
				} else if (((OpeningObject) initOpeningObject).endCol >= myParentBO.mullion.rowCol
						&& ((OpeningObject) initOpeningObject).startCol <= myParentBO.mullion.rowCol
						&& ((OpeningObject) initOpeningObject).startRow > myParentBO.mullion.endPos
						|| ((OpeningObject) initOpeningObject).endRow < myParentBO.mullion.startPos) {
					shape = ((OpeningObject) initOpeningObject).shapeID;
					startcol = ((OpeningObject) initOpeningObject).startCol;
					startrow = ((OpeningObject) initOpeningObject).startRow;
					endcol = ((OpeningObject) initOpeningObject).endCol;
					endrow = ((OpeningObject) initOpeningObject).endRow;
					myParentBO.openings.add(this.setOpening(shape, startcol,
							startrow, endcol, endrow, initOpeningObject, false,
							((OpeningObject) initOpeningObject).leftIn,
							((OpeningObject) initOpeningObject).rightIn,
							myParentBO.mullion));
					done = true;
				}

			} else {

				if (((OpeningObject) initOpeningObject).endCol < myParentBO.mullion.rowCol) {
					shape = ((OpeningObject) initOpeningObject).shapeID;
					startcol = ((OpeningObject) initOpeningObject).startCol;
					startrow = ((OpeningObject) initOpeningObject).startRow;
					endcol = ((OpeningObject) initOpeningObject).endCol;
					endrow = ((OpeningObject) initOpeningObject).endRow;
					myParentBO.openings.add(this.setOpening(shape, startcol,
							startrow, endcol, endrow, initOpeningObject, false,
							((OpeningObject) initOpeningObject).leftIn,
							((OpeningObject) initOpeningObject).rightIn,
							myParentBO.mullion));
					done = true;
				} else if (((OpeningObject) initOpeningObject).startCol > myParentBO.mullion.rowCol) {
					shape = ((OpeningObject) initOpeningObject).shapeID;
					startcol = ((OpeningObject) initOpeningObject).startCol + 1;
					startrow = ((OpeningObject) initOpeningObject).startRow;

					endcol = ((OpeningObject) initOpeningObject).endCol + 1;
					endrow = ((OpeningObject) initOpeningObject).endRow;
					if (endcol > myParentBO.xCols) {
						endcol = myParentBO.xCols;
					}
					myParentBO.openings.add(this.setOpening(shape, startcol,
							startrow, endcol, endrow, initOpeningObject, false,
							((OpeningObject) initOpeningObject).leftIn,
							((OpeningObject) initOpeningObject).rightIn,
							myParentBO.mullion));
					done = true;

				} else if (((OpeningObject) initOpeningObject).startCol <= myParentBO.mullion.rowCol
						&& ((OpeningObject) initOpeningObject).endCol >= myParentBO.mullion.rowCol
						&& ((OpeningObject) initOpeningObject).startRow == myParentBO.mullion.startPos) {

					final ShapeDivision shapeDiv = new ShapeDivision(
							((OpeningObject) initOpeningObject).shapeID, 1,
							cOrM);

					if (shapeDiv.vcPossible) {
						prevShape = shapeDiv.resultLT;
						newShape = shapeDiv.resultRB;

						shape = prevShape;// shapeDiv.resultLT;
						startcol = ((OpeningObject) initOpeningObject).startCol;
						startrow = ((OpeningObject) initOpeningObject).startRow;
						endcol = myParentBO.mullion.rowCol;
						endrow = ((OpeningObject) initOpeningObject).endRow;
						myParentBO.openings.add(this.setOpening(shape,
								startcol, startrow, endcol, endrow,
								initOpeningObject, false,
								((OpeningObject) initOpeningObject).leftIn,
								true, myParentBO.mullion));
						done = true;

						shape = newShape;// shapeDiv.resultRB;
						startcol = myParentBO.mullion.rowCol + 1;
						startrow = ((OpeningObject) initOpeningObject).startRow;
						endcol = ((OpeningObject) initOpeningObject).endCol + 1;
						if (endcol > myParentBO.xCols) {
							endcol = myParentBO.xCols;
						}
						endrow = ((OpeningObject) initOpeningObject).endRow;
						myParentBO.openings.add(this.setOpening(shape,
								startcol, startrow, endcol, endrow,
								initOpeningObject, true, true,
								((OpeningObject) initOpeningObject).rightIn,
								myParentBO.mullion));
						done = true;
					} else {
						goodToDivide = false;
					}
				} else if (((OpeningObject) initOpeningObject).startCol <= myParentBO.mullion.rowCol
						&& ((OpeningObject) initOpeningObject).endCol >= myParentBO.mullion.rowCol
						&& ((OpeningObject) initOpeningObject).startRow != myParentBO.mullion.startPos) {

					shape = ((OpeningObject) initOpeningObject).shapeID;
					startcol = ((OpeningObject) initOpeningObject).startCol;
					startrow = ((OpeningObject) initOpeningObject).startRow;
					endcol = ((OpeningObject) initOpeningObject).endCol + 1;
					if (endcol > myParentBO.xCols) {
						endcol = myParentBO.xCols;
					}
					endrow = ((OpeningObject) initOpeningObject).endRow;
					myParentBO.openings.add(this.setOpening(shape, startcol,
							startrow, endcol, endrow, initOpeningObject, false,
							((OpeningObject) initOpeningObject).leftIn,
							((OpeningObject) initOpeningObject).rightIn,
							myParentBO.mullion));
					done = true;

				}

			}

		}

	}

	public OpeningObject setOpening(final int shape, final int startCol,
			final int startRow, final int endCol, final int endRow,
			final Object opening, final boolean isNew, final boolean leftIn,
			final boolean rightIn, final Profiles myM) {

		OpeningObject myInitOpening = new OpeningObject(myFrame2);

		myInitOpening = ((OpeningObject) opening)
				.cloneOpening((OpeningObject) opening);

		myInitOpening.shapeID = shape;

		if (!isNew) {
			myInitOpening.lastSeq = Integer.valueOf(String
					.valueOf(myInitOpening.startRow)
					+ String.valueOf(myInitOpening.startCol));

			if (myInitOpening.endCol >= this.newVCCol
					&& myInitOpening.startCol <= this.newVCCol
					&& myInitOpening.endRow <= this.vcEnd
					&& myInitOpening.startRow >= this.vcStart) {
				myInitOpening.myMullionRight = myM;
			}

		} else {
			myInitOpening.myMullionLeft = myM;
			myInitOpening.myFrame2 = myFrame2;
			myInitOpening.myFrame2.jobItem = myFrame2.jobItem;
		}

		myInitOpening.a_sequenceID = Integer.valueOf(String.valueOf(startRow)
				+ String.valueOf(startCol));
		myInitOpening.startCol = startCol;

		myInitOpening.endCol = endCol;
		myInitOpening.startRow = startRow;
		myInitOpening.leftIn = leftIn;
		myInitOpening.rightIn = rightIn;
		myInitOpening.endRow = endRow;

		return myInitOpening;
	}

	public OpeningObject myClone(final OpeningObject init,
			final OpeningObject original) {

		init.myParent = original.myParent;

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
		init.widthPix = original.widthPix;
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

	public void getStartStopRow(final int x, final int y) {

		newVCRow = 1;
		vcStart = 1;
		vcEnd = myParentBO.yRows;
		vcStartY = myParentBO.highestY;
		vcEndY = myParentBO.lowestY;
		dimTM = myParentBO.dimTM;
		dimTA = myParentBO.dimTA;
		dimBM = myParentBO.dimBM;
		dimBA = myParentBO.dimBA;
		endIn = false;
		startIn = false;
		myParentBO.mullionObjectsH = myParentBO.mullionsH.toArray();

		if (myParentBO.mullionObjectsH.length == 0) {
			newVCRow = 1;
			vcStart = 1;
			vcEnd = 1;
			vcStartY = myParentBO.highestY;// myParentBO.startingY;
			vcEndY = vcEndY;
			startIn = false;
			endIn = false;
			posCondition = 1;

		} else {

			this.getStartPosition(x, y);

			this.getEndPosition(x, y);

		}

		if (!startIn && !endIn) {
			posCondition = 1;
		} else if (!startIn && endIn) {
			posCondition = 2;
		} else if (startIn && !endIn) {
			posCondition = 3;
		} else {
			posCondition = 4;
		}

		if (posCondition == 1 || posCondition == 2
				&& myParentBO.top1.partForm == 1) {
			for (final Object element : myParentBO.mullionObjectsH) {
				if (((Profiles) element).y1al < vcStartY) {
					goodToGo = false;

				}
			}
		}
		// checkMullionEnds(posCondition, x, y);
	}

	private void getEndPosition(final int x, final int y) {

		int c;
		double delta;
		double minDeltab = 100000000;
		int closestb = 0;
		for (c = 0; c < myParentBO.mullionObjectsH.length; c++) {

			delta = 0;

			if (Math.max(((Profiles) myParentBO.mullionObjectsH[c]).y4al,
					((Profiles) myParentBO.mullionObjectsH[c]).y1al) > y
					&& ((Profiles) myParentBO.mullionObjectsH[c]).x3cl > x
					&& ((Profiles) myParentBO.mullionObjectsH[c]).x2cl < x) {

				delta = ((Profiles) myParentBO.mullionObjectsH[c]).y2cl - y;
				if (delta <= minDeltab) {
					minDeltab = delta;
					closestb = ((Profiles) myParentBO.mullionObjectsH[c]).rowCol;
					vcEndY = ((Profiles) myParentBO.mullionObjectsH[c]).y2;
					vcEnd = closestb;
					dimBM = partDimM;
					dimBA = partDimC;

					if (closestb == 1) {
						newVCRow = 1;

						vcEnd = 1;

						vcEndY = ((Profiles) myParentBO.mullionObjectsH[c]).y2;
						dimBM = partDimM;
						dimBA = partDimC;

					}
					endIn = true;
				}
				// }

			}
		}
		if (vcEnd == 1 && vcStart > 1 && myParentBO.mullionObjectsH.length > 0) {
			vcEndY = vcEndY = myParentBO.startingY + myParentBO.heightPix;
			vcEnd = myParentBO.yRows;
			dimBM = myParentBO.dimBM;
			dimBA = myParentBO.dimBA;

		}
	}

	public void getNewVMullionCol(final int x, final int y) {

		newVCCol = 1;
		int col = 0;
		double minDelta = 10000;

		int isBefore = 0; // 0=equal 1= true 2=false
		// myParent.mullionObjectsV = null;
		// myParent.mullionObjectsV =
		// myParent.mullions.toArray();
		for (int c = 0; c < myParentBO.mullionObjectsV.length; c++) {
			// Should be Max or Min for Offset
			// Mullions
			if (x < ((Profiles) myParentBO.mullionObjectsV[c]).x1) {
				((Profiles) myParentBO.mullionObjectsV[c]).isBefore = 1;
				((Profiles) myParentBO.mullionObjectsV[c]).tempDelta = ((Profiles) myParentBO.mullionObjectsV[c]).x1
						- x;
			} else if (x > ((Profiles) myParentBO.mullionObjectsV[c]).x2) {
				((Profiles) myParentBO.mullionObjectsV[c]).isBefore = 2;
				((Profiles) myParentBO.mullionObjectsV[c]).tempDelta = x
						- ((Profiles) myParentBO.mullionObjectsV[c]).x2;
				((Profiles) myParentBO.mullionObjectsV[c]).tempDelta = x
						- ((Profiles) myParentBO.mullionObjectsV[c]).x2;
			} else {
				((Profiles) myParentBO.mullionObjectsV[c]).isBefore = 0;
				((Profiles) myParentBO.mullionObjectsV[c]).tempDelta = 0;
			}

		}

		for (final Object element : myParentBO.mullionObjectsV) {

			if (((Profiles) element).tempDelta <= minDelta) {
				minDelta = ((Profiles) element).tempDelta;
				col = ((Profiles) element).rowCol;
				isBefore = ((Profiles) element).isBefore;
			}

		}

		if (myParentBO.mullionObjectsV.length == 0) {
			newVCCol = 1;
		} else {

			if (isBefore == 0) {
				newVCCol = col;
				alreadyExist = 2;
			} else if (isBefore == 1) {
				newVCCol = col;
			} else {
				newVCCol = col + 1;
			}

		}

	}

	private void getStartPosition(final int x, final int y) {

		int c;
		double delta;
		double minDeltaa = 100000000;
		int closesta = 0;

		for (c = 0; c < myParentBO.mullionObjectsH.length; c++) {
			delta = 0;

			if (((Profiles) myParentBO.mullionObjectsH[c]).y1al < y
					&& ((Profiles) myParentBO.mullionObjectsH[c]).x4al > x
					&& ((Profiles) myParentBO.mullionObjectsH[c]).x1al < x) {

				delta = y - ((Profiles) myParentBO.mullionObjectsH[c]).y1al;
				if (delta <= minDeltaa) {
					minDeltaa = delta;
					closesta = ((Profiles) myParentBO.mullionObjectsH[c]).rowCol;
					vcStartY = ((Profiles) myParentBO.mullionObjectsH[c]).y1;
					vcStart = closesta + 1;
					newVCRow = closesta + 1;

					dimTM = partDimM;
					dimTA = partDimA;
					startIn = true;
					// break;
				} else {
					break;
				}

			} else {

			}

		}

	}

	public void recalcHCCoords() {

		// Should be getting Intersections not just delta

		double x1 = 0;
		double x2 = 0;
		double x1al = 0;
		double x2cl = 0;
		double y1 = 0;
		double y2 = 0;
		double y1al = 0;
		double y2cl = 0;
		double centerXs = 0;
		double centerYs = 0;

		double x4 = 0;
		double x3 = 0;
		double x4al = 0;
		double x3cl = 0;
		double y4 = 0;
		double y3 = 0;
		double y4al = 0;
		double y3cl = 0;
		double centerXe = 0;
		double centerYe = 0;

		double x1a3 = 0;
		double x2a3 = 0;
		double x1b = 0;
		double x2b = 0;

		double xcs = 0;
		double xce = 0;

		double x4a3 = 0;
		double x3a3 = 0;
		double x4b = 0;
		double x3b = 0;

		myParentBO.mullionObjectsH = null;
		myParentBO.mullionObjectsH = myParentBO.mullionsH.toArray();
		myParentBO.mullionsH.clear();

		myParentBO.mullionObjectsV = null;
		myParentBO.mullionObjectsV = myParentBO.mullions.toArray();

		for (Object element : myParentBO.mullionObjectsH) {

			x1al = ((Profiles) element).x1al;
			y1al = ((Profiles) element).y1al;
			x1 = ((Profiles) element).x1;
			y1 = ((Profiles) element).y1;
			centerXs = xcs = ((Profiles) element).centerXs;
			centerYs = ((Profiles) element).centerYs;

			x2 = ((Profiles) element).x2;
			y2 = ((Profiles) element).y2;
			x2cl = ((Profiles) element).x2cl;
			y2cl = ((Profiles) element).y2cl;
			x4al = ((Profiles) element).x4al;
			y4al = ((Profiles) element).y4al;
			x4 = ((Profiles) element).x4;
			y4 = ((Profiles) element).y4;
			centerXe = xce = ((Profiles) element).centerXe;
			centerYe = ((Profiles) element).centerYe;
			x3 = ((Profiles) element).x3;
			y3 = ((Profiles) element).y3;
			x3cl = ((Profiles) element).x3cl;
			y3cl = ((Profiles) element).y3cl;
			xcs = ((Profiles) element).xcs;
			xce = ((Profiles) element).xce;

			if (((Profiles) element).x3a3 > 0) {
				x1a3 = x1b = xcs = ((Profiles) element).x1a3;
				x4a3 = x4b = xce = ((Profiles) element).x4a3;

				x3a3 = ((Profiles) element).x3a3;
				x4a3 = ((Profiles) element).x4a3;
				x3b = ((Profiles) element).x3b;
				x4b = ((Profiles) element).x4b;
			} else {
				x3a3 = x3b = ((Profiles) element).x3cl;
				x4a3 = x4b = xce = ((Profiles) element).x4al;

				x2a3 = x2b = ((Profiles) element).x2cl;
				x1a3 = x1b = xcs = ((Profiles) element).x1al;
				x4a3 = x4b = ((Profiles) element).x4al;

			}

			for (final Object elementV : myParentBO.mullionObjectsV) {

				if (((Profiles) element).startPos > 1) {

					if (((Profiles) elementV).rowCol == ((Profiles) element).startPos - 1
							&& ((Profiles) elementV).startPos <= ((Profiles) element).rowCol
							&& ((Profiles) elementV).endPos > ((Profiles) element).rowCol) {
						if (setHcontinuity > 0) {
							((Profiles) element).continuity = 3;
						}
						if (((Profiles) element).endTypeLT > 1) {
							x1al = this.intersectX(((Profiles) elementV).x2,
									((Profiles) elementV).y2,
									((Profiles) elementV).x3,
									((Profiles) elementV).y3,
									((Profiles) element).x1al,
									((Profiles) element).y1al,
									((Profiles) element).x4al,
									((Profiles) element).y4al);

							x1a3 = this.intersectX(((Profiles) elementV).x2cl,
									((Profiles) elementV).y2cl,
									((Profiles) elementV).x3cl,
									((Profiles) elementV).y3cl,
									((Profiles) element).x1al,
									((Profiles) element).y1al,
									((Profiles) element).x4al,
									((Profiles) element).y4al);

							y1al = this.intersectY(((Profiles) elementV).x2,
									((Profiles) elementV).y2,
									((Profiles) elementV).x3,
									((Profiles) elementV).y3,
									((Profiles) element).x1al,
									((Profiles) element).y1al,
									((Profiles) element).x4al,
									((Profiles) element).y4al);

							x1 = this.intersectX(((Profiles) elementV).x2,
									((Profiles) elementV).y2,
									((Profiles) elementV).x3,
									((Profiles) elementV).y3,
									((Profiles) element).x1,
									((Profiles) element).y1,
									((Profiles) element).x4,
									((Profiles) element).y4);
							y1 = this.intersectY(((Profiles) elementV).x2,
									((Profiles) elementV).y2,
									((Profiles) elementV).x3,
									((Profiles) elementV).y3,
									((Profiles) element).x1,
									((Profiles) element).y1,
									((Profiles) element).x4,
									((Profiles) element).y4);
							centerXs = this.intersectX(
									((Profiles) elementV).x2,
									((Profiles) elementV).y2,
									((Profiles) elementV).x3,
									((Profiles) elementV).y3,
									((Profiles) element).centerXs,
									((Profiles) element).centerYs,
									((Profiles) element).centerXe,
									((Profiles) element).centerYe);
							centerYs = this.intersectY(
									((Profiles) elementV).x2,
									((Profiles) elementV).y2,
									((Profiles) elementV).x3,
									((Profiles) elementV).y3,
									((Profiles) element).centerXs,
									((Profiles) element).centerYs,
									((Profiles) element).centerXe,
									((Profiles) element).centerYe);

							x2 = this.intersectX(((Profiles) elementV).x2,
									((Profiles) elementV).y2,
									((Profiles) elementV).x3,
									((Profiles) elementV).y3,
									((Profiles) element).x2,
									((Profiles) element).y2,
									((Profiles) element).x3,
									((Profiles) element).y3);
							y2 = this.intersectY(((Profiles) elementV).x2,
									((Profiles) elementV).y2,
									((Profiles) elementV).x3,
									((Profiles) elementV).y3,
									((Profiles) element).x2,
									((Profiles) element).y2,
									((Profiles) element).x3,
									((Profiles) element).y3);
							x2cl = this.intersectX(((Profiles) elementV).x2,
									((Profiles) elementV).y2,
									((Profiles) elementV).x3,
									((Profiles) elementV).y3,
									((Profiles) element).x2cl,
									((Profiles) element).y2cl,
									((Profiles) element).x3cl,
									((Profiles) element).y3cl);

							x2a3 = this.intersectX(((Profiles) elementV).x2cl,
									((Profiles) elementV).y2cl,
									((Profiles) elementV).x3cl,
									((Profiles) elementV).y3cl,
									((Profiles) element).x2cl,
									((Profiles) element).y2cl,
									((Profiles) element).x3cl,
									((Profiles) element).y3cl);

							y2cl = this.intersectY(((Profiles) elementV).x2,
									((Profiles) elementV).y2,
									((Profiles) elementV).x3,
									((Profiles) elementV).y3,
									((Profiles) element).x2cl,
									((Profiles) element).y2cl,
									((Profiles) element).x3cl,
									((Profiles) element).y3cl);
						} else {

							x1al = this.intersectX(((Profiles) elementV).x2cl,
									((Profiles) elementV).y2cl,
									((Profiles) elementV).x3cl,
									((Profiles) elementV).y3cl,
									((Profiles) element).x1al,
									((Profiles) element).y1al,
									((Profiles) element).x4al,
									((Profiles) element).y4al);
							y1al = this.intersectY(((Profiles) elementV).x2cl,
									((Profiles) elementV).y2cl,
									((Profiles) elementV).x3cl,
									((Profiles) elementV).y3cl,
									((Profiles) element).x1al,
									((Profiles) element).y1al,
									((Profiles) element).x4al,
									((Profiles) element).y4al);

							centerXs = this.intersectX(((Profiles) elementV).x2
									- partDimM, ((Profiles) elementV).y2,
									((Profiles) elementV).x3 - partDimM,
									((Profiles) elementV).y3,
									((Profiles) element).centerXs,
									((Profiles) element).centerYs,
									((Profiles) element).centerXe,
									((Profiles) element).centerYe);
							centerYs = this.intersectY(((Profiles) elementV).x2
									- partDimM, ((Profiles) elementV).y2,
									((Profiles) elementV).x3 - partDimM,
									((Profiles) elementV).y3,
									((Profiles) element).centerXs,
									((Profiles) element).centerYs,
									((Profiles) element).centerXe,
									((Profiles) element).centerYe);

							x2cl = this.intersectX(((Profiles) elementV).x2cl,
									((Profiles) elementV).y2cl,
									((Profiles) elementV).x3cl,
									((Profiles) elementV).y3cl,
									((Profiles) element).x2cl,
									((Profiles) element).y2cl,
									((Profiles) element).x3cl,
									((Profiles) element).y3cl);
							y2cl = this.intersectY(((Profiles) elementV).x2cl,
									((Profiles) elementV).y2cl,
									((Profiles) elementV).x3cl,
									((Profiles) elementV).y3cl,
									((Profiles) element).x2cl,
									((Profiles) element).y2cl,
									((Profiles) element).x3cl,
									((Profiles) element).y3cl);

							x1 = this.intersectX(((Profiles) elementV).x2,
									((Profiles) elementV).y2,
									((Profiles) elementV).x3,
									((Profiles) elementV).y3, 
									((Profiles) element).x1,
									((Profiles) element).y1,
									((Profiles) element).x4,
									((Profiles) element).y4);
							y1 = this.intersectY(((Profiles) elementV).x2,
									((Profiles) elementV).y2,
									((Profiles) elementV).x3,
									((Profiles) elementV).y3, 
									((Profiles) element).x1,
									((Profiles) element).y1,
									((Profiles) element).x4,
									((Profiles) element).y4);

							x2 = this.intersectX(((Profiles) elementV).x2,
									((Profiles) elementV).y2,
									((Profiles) elementV).x3,
									((Profiles) elementV).y3, 
									((Profiles) element).x2,
									((Profiles) element).y2,
									((Profiles) element).x3,
									((Profiles) element).y3);
							y2 = this.intersectY(((Profiles) elementV).x2,
									((Profiles) elementV).y2,
									((Profiles) elementV).x3,
									((Profiles) elementV).y3, 
									((Profiles) element).x2,
									((Profiles) element).y2,
									((Profiles) element).x3,
									((Profiles) element).y3);

						}
						// break;
					}

				}
				if (((Profiles) element).endPos != myParentBO.xCols) {
					if (((Profiles) elementV).rowCol == ((Profiles) element).endPos
							&& ((Profiles) elementV).startPos <= ((Profiles) element).rowCol
							&& ((Profiles) elementV).endPos > ((Profiles) element).rowCol) {
						if (setHcontinuity > 0) {
							((Profiles) element).continuity = 3;
						}
						if (((Profiles) element).endTypeRB > 1) {
							x4al = this.intersectX(((Profiles) elementV).x1,
									((Profiles) elementV).y1,
									((Profiles) elementV).x4,
									((Profiles) elementV).y4,
									((Profiles) element).x1al,
									((Profiles) element).y1al,
									((Profiles) element).x4al,
									((Profiles) element).y4al);

							x4a3 = this.intersectX(((Profiles) elementV).x1al,
									((Profiles) elementV).y1al,
									((Profiles) elementV).x4al,
									((Profiles) elementV).y4al,
									((Profiles) element).x1al,
									((Profiles) element).y1al,
									((Profiles) element).x4al,
									((Profiles) element).y4al);
							y4al = this.intersectY(((Profiles) elementV).x1,
									((Profiles) elementV).y1,
									((Profiles) elementV).x4,
									((Profiles) elementV).y4,
									((Profiles) element).x1al,
									((Profiles) element).y1al,
									((Profiles) element).x4al,
									((Profiles) element).y4al);
							x4 = this.intersectX(((Profiles) elementV).x1,
									((Profiles) elementV).y1,
									((Profiles) elementV).x4,
									((Profiles) elementV).y4,
									((Profiles) element).x1,
									((Profiles) element).y1,
									((Profiles) element).x4,
									((Profiles) element).y4);
							y4 = this.intersectY(((Profiles) elementV).x1,
									((Profiles) elementV).y1,
									((Profiles) elementV).x4,
									((Profiles) elementV).y4,
									((Profiles) element).x1,
									((Profiles) element).y1,
									((Profiles) element).x4,
									((Profiles) element).y4);
							centerXe = this.intersectX(
									((Profiles) elementV).x1,
									((Profiles) elementV).y1,
									((Profiles) elementV).x4,
									((Profiles) elementV).y4,
									((Profiles) element).centerXs,
									((Profiles) element).centerYs,
									((Profiles) element).centerXe,
									((Profiles) element).centerYe);
							centerYe = this.intersectY(
									((Profiles) elementV).x1,
									((Profiles) elementV).y1,
									((Profiles) elementV).x4,
									((Profiles) elementV).y4,
									((Profiles) element).centerXs,
									((Profiles) element).centerYs,
									((Profiles) element).centerXe,
									((Profiles) element).centerYe);

							x3 = this.intersectX(((Profiles) elementV).x1,
									((Profiles) elementV).y1,
									((Profiles) elementV).x4,
									((Profiles) elementV).y4,
									((Profiles) element).x2,
									((Profiles) element).y2,
									((Profiles) element).x3,
									((Profiles) element).y3);
							y3 = this.intersectY(((Profiles) elementV).x1,
									((Profiles) elementV).y1,
									((Profiles) elementV).x4,
									((Profiles) elementV).y4,
									((Profiles) element).x2,
									((Profiles) element).y2,
									((Profiles) element).x3,
									((Profiles) element).y3);
							x3cl = this.intersectX(((Profiles) elementV).x1,
									((Profiles) elementV).y1,
									((Profiles) elementV).x4,
									((Profiles) elementV).y4,
									((Profiles) element).x2cl,
									((Profiles) element).y2cl,
									((Profiles) element).x3cl,
									((Profiles) element).y3cl);

							x3a3 = this.intersectX(((Profiles) elementV).x1al,
									((Profiles) elementV).y1al,
									((Profiles) elementV).x4al,
									((Profiles) elementV).y4al,
									((Profiles) element).x2cl,
									((Profiles) element).y2cl,
									((Profiles) element).x3cl,
									((Profiles) element).y3cl);

							y3cl = this.intersectY(((Profiles) elementV).x1,
									((Profiles) elementV).y1,
									((Profiles) elementV).x4,
									((Profiles) elementV).y4,
									((Profiles) element).x2cl,
									((Profiles) element).y2cl,
									((Profiles) element).x3cl,
									((Profiles) element).y3cl);
						} else {
							x4al = this.intersectX(((Profiles) elementV).x1al,
									((Profiles) elementV).y1al,
									((Profiles) elementV).x4al,
									((Profiles) elementV).y4al,
									((Profiles) element).x1al,
									((Profiles) element).y1al,
									((Profiles) element).x4al,
									((Profiles) element).y4al);
							y4al = this.intersectY(((Profiles) elementV).x1al,
									((Profiles) elementV).y1al,
									((Profiles) elementV).x4al,
									((Profiles) elementV).y4al,
									((Profiles) element).x1al,
									((Profiles) element).y1al,
									((Profiles) element).x4al,
									((Profiles) element).y4al);

							centerXe = this.intersectX(((Profiles) elementV).x1
									+ partDimM, ((Profiles) elementV).y1,
									((Profiles) elementV).x4 + partDimM,
									((Profiles) elementV).y4,
									((Profiles) element).centerXs,
									((Profiles) element).centerYs,
									((Profiles) element).centerXe,
									((Profiles) element).centerYe);
							centerYe = this.intersectY(((Profiles) elementV).x1
									+ partDimM, ((Profiles) elementV).y1,
									((Profiles) elementV).x4 + partDimM,
									((Profiles) elementV).y4,
									((Profiles) element).centerXs,
									((Profiles) element).centerYs,
									((Profiles) element).centerXe,
									((Profiles) element).centerYe);

							x3cl = this.intersectX(((Profiles) elementV).x1al,
									((Profiles) elementV).y1al,
									((Profiles) elementV).x4al,
									((Profiles) elementV).y4al,
									((Profiles) element).x2cl,
									((Profiles) element).y2cl,
									((Profiles) element).x3cl,
									((Profiles) element).y3cl);
							y3cl = this.intersectY(((Profiles) elementV).x1al,
									((Profiles) elementV).y1al,
									((Profiles) elementV).x4al,
									((Profiles) elementV).y4al,
									((Profiles) element).x2cl,
									((Profiles) element).y2cl,
									((Profiles) element).x3cl,
									((Profiles) element).y3cl);

							x4 = this.intersectX(((Profiles) elementV).x1,
									((Profiles) elementV).y1,
									((Profiles) elementV).x4,
									((Profiles) elementV).y4,
									((Profiles) element).x1,
									((Profiles) element).y1,
									((Profiles) element).x4,
									((Profiles) element).y4);
						
							
							y4 = this.intersectY(((Profiles) elementV).x1,
									((Profiles) elementV).y1,
									((Profiles) elementV).x4,
									((Profiles) elementV).y4,
									((Profiles) element).x1,
									((Profiles) element).y1,
									((Profiles) element).x4,
									((Profiles) element).y4);

							x3 = this.intersectX(((Profiles) elementV).x1,
									((Profiles) elementV).y1,
									((Profiles) elementV).x4,
									((Profiles) elementV).y4,
									((Profiles) element).x2,
									((Profiles) element).y2,
									((Profiles) element).x3,
									((Profiles) element).y3);
							y3 = this.intersectY(((Profiles) elementV).x1,
									((Profiles) elementV).y1,
									((Profiles) elementV).x4,
									((Profiles) elementV).y4,
									((Profiles) element).x2,
									((Profiles) element).y2,
									((Profiles) element).x3,
									((Profiles) element).y3);

						}
						// break;
					}

				}

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
			((Profiles) element).myParent = myParentBO;

			((Profiles) element).x1a = x1al;
			((Profiles) element).x2a = x2cl;
			((Profiles) element).x3a = x3cl;
			((Profiles) element).x4a = x4al;

			((Profiles) element).x1a3 = x1a3;
			((Profiles) element).x2a3 = x2a3;
			((Profiles) element).x3a3 = x3a3;
			((Profiles) element).x4a3 = x4a3;
			((Profiles) element).x1b = x1b;
			((Profiles) element).x2b = x2b;
			((Profiles) element).x3b = x3b;
			((Profiles) element).x4b = x4b;

			((Profiles) element).xcs = xcs;
			((Profiles) element).xce = xce;

			((Profiles) element).length = ((Profiles) element).centerYe
					- ((Profiles) element).centerYs;

			element = recalcMullion(((Profiles) element));

			myParentBO.mullionsH.add(element);
		}// for Loop for V

	}

	public Profiles recalcMullion( Profiles myMullion) {

		final AddMullionH addMullionH = new AddMullionH(myParentBO,
				myFrame2.jobItem, myFrame2, 2);

		addMullionH.hcStartX = myMullion.centerXs;

		addMullionH.hcEnd = myMullion.myParent.myParent.endCol;

		addMullionH.newStartingYLB = myMullion.y1;

		addMullionH.newStartingYRT = myMullion.y2;

		addMullionH.newStartingYLBa = myMullion.y1al;

		addMullionH.newStartingYRTc = myMullion.y2cl;

		addMullionH.newStartingYCenter = myMullion.centerYs;

		// addMullionH.getDimsForMullion(0, 0);
		//
		// addMullionH.getPointsXY(myMullion, false, true);
		//
		addMullionH.verifyLimitLR(myMullion);

		addMullionH.calcMullion = new CalculateMullionHii(addMullionH);

		myMullion = addMullionH.calcMullion.calculateCoord(myMullion);

		return myMullion;
	}

	public void zeroOutExisiting(final int existing) {

		((Profiles) myParentBO.mullionObjectsV[existing]).y1 = 0;
		((Profiles) myParentBO.mullionObjectsV[existing]).y2 = 0;
		((Profiles) myParentBO.mullionObjectsV[existing]).centerYs = 0;
		((Profiles) myParentBO.mullionObjectsV[existing]).startPos = 0;
		((Profiles) myParentBO.mullionObjectsV[existing]).length = 0;
		((Profiles) myParentBO.mullionObjectsV[existing]).y4 = 0;
		((Profiles) myParentBO.mullionObjectsV[existing]).y3 = 0;
		((Profiles) myParentBO.mullionObjectsV[existing]).centerYe = 0;
		((Profiles) myParentBO.mullionObjectsV[existing]).endPos = 0;
		((Profiles) myParentBO.mullionObjectsV[existing]).x1 = 0;
		((Profiles) myParentBO.mullionObjectsV[existing]).x2 = 0;
		((Profiles) myParentBO.mullionObjectsV[existing]).x3 = 0;
		((Profiles) myParentBO.mullionObjectsV[existing]).x4 = 0;
		((Profiles) myParentBO.mullionObjectsV[existing]).centerXs = 0;
		((Profiles) myParentBO.mullionObjectsV[existing]).centerXe = 0;
		((Profiles) myParentBO.mullionObjectsV[existing]).rowCol = 0;
	}

	public void addMullionHSplit(final Profiles mullionH,
			final Profiles mullionV, final int c) {

		int end = 0;
		int start = 0;

		start = mullionV.rowCol + 1;
		end = mullionH.endPos;

		Profiles newH = new Profiles(myParentBO, start, end, 1, 0, 0, 0, 0, 0,
				myFrame2);

		// ///////////////////////
		newH.x1 = this
				.intersectX(mullionV.x2, mullionV.y2, mullionV.x3, mullionV.y3,
						mullionH.x1, mullionH.y1, mullionH.x4, mullionH.y4);

		newH.x2 = this
				.intersectX(mullionV.x2, mullionV.y2, mullionV.x3, mullionV.y3,
						mullionH.x2, mullionH.y2, mullionH.x3, mullionH.y4);

		newH.x1al = this.intersectX(mullionV.x2, mullionV.y2, mullionV.x3,
				mullionV.y3, mullionH.x1al, mullionH.y1al, mullionH.x4al,
				mullionH.y4al);

		newH.x2cl = this.intersectX(mullionV.x2, mullionV.y2, mullionV.x3,
				mullionV.y3, mullionH.x2cl, mullionH.y2cl, mullionH.x3cl,
				mullionH.y3cl);

		newH.centerXs = this.intersectX(mullionV.x2, mullionV.y2, mullionV.x3,
				mullionV.y3, mullionH.centerXs, mullionH.centerYs,
				mullionH.centerXe, mullionH.centerYe);

		newH.y1 = this
				.intersectY(mullionV.x2, mullionV.y2, mullionV.x3, mullionV.y3,
						mullionH.x1, mullionH.y1, mullionH.x4, mullionH.y4);

		newH.y2 = this
				.intersectY(mullionV.x2, mullionV.y2, mullionV.x3, mullionV.y3,
						mullionH.x2, mullionH.y2, mullionH.x3, mullionH.y3);

		newH.y1al = this.intersectY(mullionV.x2, mullionV.y2, mullionV.x3,
				mullionV.y3, mullionH.x1al, mullionH.y1al, mullionH.x4al,
				mullionH.y4al);

		newH.y2cl = this.intersectY(mullionV.x2, mullionV.y2, mullionV.x3,
				mullionV.y3, mullionH.x2cl, mullionH.y2cl, mullionH.x3cl,
				mullionH.y3cl);

		newH.centerYs = this.intersectY(mullionV.x2, mullionV.y2, mullionV.x3,
				mullionV.y3, mullionH.centerXs, mullionH.centerYs,
				mullionH.centerXe, mullionH.centerYe);

		// ///////////////////////

		newH.y1a3 = newH.y1b = this.intersectY(mullionV.x2cl, mullionV.y2cl,
				mullionV.x3cl, mullionV.y3cl, mullionH.x1al, mullionH.y1al,
				mullionH.x4al, mullionH.y4al);

		newH.ycs = this.intersectY(mullionV.x2cl, mullionV.y2cl, mullionV.x3cl,
				mullionV.y3cl, mullionH.centerXs, mullionH.centerYs,
				mullionH.centerXe, mullionH.centerYe);

		newH.y2a3 = newH.y2b = this.intersectY(mullionV.x2cl, mullionV.y2cl,
				mullionV.x3cl, mullionV.y3cl, mullionH.x2cl, mullionH.y2cl,
				mullionH.x3cl, mullionH.y3cl);

		newH.x3 = mullionH.x3;
		newH.x4 = mullionH.x4;

		newH.centerXe = mullionH.centerXe;

		newH.x3cl = newH.x3a = mullionH.x3cl;
		newH.x4al = newH.x4a = mullionH.x4al;

		newH.centerYe = mullionH.centerYe;

		newH.y3 = newH.y3a = mullionH.y3;

		newH.y4 = newH.y4a = mullionH.y4;

		newH.y3cl = mullionH.y3cl;
		newH.y4al = mullionH.y4al;

		newH.x3a3 = mullionH.x3a3;
		newH.x4a3 = mullionH.x4a3;
		newH.y3a3 = mullionH.y3a3;
		newH.y4a3 = mullionH.y4a3;

		newH.cOrM = mullionH.cOrM;
		newH.rID = mullionH.rID;
		newH.parentid = mullionH.parentid;

		newH.partShape = mullionH.partShape;
		newH.ABClines = mullionH.ABClines;
		newH.orientation = mullionH.orientation;

		newH.partDimA = mullionH.partDimA;
		newH.partDimB = mullionH.partDimB;
		newH.partDimBtoC = mullionH.partDimBtoC;
		newH.partDimC = mullionH.partDimC;
		newH.partDimM = mullionH.partDimM;

		newH.partDimAi = mullionH.partDimAi;
		newH.partDimBi = mullionH.partDimBi;
		newH.partDimBtoCi = mullionH.partDimBtoCi;
		newH.partDimCi = mullionH.partDimCi;
		newH.partDimMi = mullionH.partDimMi;

		newH.myParent = mullionH.myParent;

		newH.isValid = mullionH.isValid;

		newH.endTypeRB = mullionH.endTypeRB;
		newH.endTypeLT = mullionH.endTypeLT;

		newH.rowCol = mullionH.rowCol;

		newH.startPos = start;
		newH.endPos = end;

		newH.offsetRB = mullionH.offsetRB;
		newH.offsetTL = mullionH.offsetTL;
		newH.partForm = mullionH.partForm;
		newH.thickness = mullionH.thickness;
		newH.exists = 2;

		newH.length = newH.centerYe - newH.centerYs;

		this.modifyHMullion(c);

		newH = recalcMullion(newH);

		// Reset and Recalc Mullion
		newH.bom.clear();
		newH.clearBomForProfile();
		// newH = (Profiles) myFrame2.executePartRules.executePartRules(null,
		// null, newH,
		// newH.a_assemblyLevel, true, true, "AddMullionV.assMullinHSplit 5785",
		// true);
		newH.y3 = newH.y3a = mullionH.y3;

		newH.y4 = newH.y4a = mullionH.y4;
		myParentBO.mullionsH.add(newH);

	}

	public void addMullionHSplitOLD(final Profiles mullionH,
			final Profiles mullionV, final int c) {

		int end = 0;
		int start = 0;
		double x1 = 0;
		double x2 = 0;
		double x1al = 0;
		double x2cl = 0;

		double x1a3 = 0;
		double x2a3 = 0;
		final double x3a3 = 0;
		final double x4a3 = 0;

		double y1 = 0;
		double y2 = 0;
		double y1al = 0;
		double y2cl = 0;
		double y1a3 = 0;
		double y2a3 = 0;
		double y3a3 = 0;
		double y4a3 = 0;

		double centerXs = 0;
		double centerYs = 0;
		// ///////////////////////
		x1 = this
				.intersectX(mullionV.x2, mullionV.y2, mullionV.x3, mullionV.y3,
						mullionH.x1, mullionH.y1, mullionH.x4, mullionH.y4);

		centerXs = this.intersectX(mullionV.x2, mullionV.y2, mullionV.x3,
				mullionV.y3, mullionH.centerXs, mullionH.centerYs,
				mullionH.centerXe, mullionH.centerYe);

		x2 = this
				.intersectX(mullionV.x2, mullionV.y2, mullionV.x3, mullionV.y3,
						mullionH.x2, mullionH.y2, mullionH.x3, mullionH.y3);

		// ///////////////////////

		x1al = this.intersectX(mullionV.x2, mullionV.y2, mullionV.x3,
				mullionV.y3, mullionH.x1al, mullionH.y1al, mullionH.x4al,
				mullionH.y4al);

		x1a3 = this.intersectX(mullionV.x2cl, mullionV.y2cl, mullionV.x3cl,
				mullionV.y3cl, mullionH.x1al, mullionH.y1al, mullionH.x4al,
				mullionH.y4al);

		x2cl = this.intersectX(mullionV.x2, mullionV.y2, mullionV.x3,
				mullionV.y3, mullionH.x2cl, mullionH.y2cl, mullionH.x3cl,
				mullionH.y3cl);

		x2a3 = this.intersectX(mullionV.x2cl, mullionV.y2cl, mullionV.x3cl,
				mullionV.y3cl, mullionH.x2cl, mullionH.y2cl, mullionH.x3cl,
				mullionH.y3cl);

		// ///////////////////////

		y1 = this
				.intersectY(mullionV.x2, mullionV.y2, mullionV.x3, mullionV.y3,
						mullionH.x1, mullionH.y1, mullionH.x4, mullionH.y4);

		centerYs = this.intersectY(mullionV.x2, mullionV.y2, mullionV.x3,
				mullionV.y3, mullionH.centerXs, mullionH.centerYs,
				mullionH.centerXe, mullionH.centerYe);

		y2 = this
				.intersectY(mullionV.x2, mullionV.y2, mullionV.x3, mullionV.y3,
						mullionH.x2, mullionH.y2, mullionH.x3, mullionH.y3);

		y1al = this.intersectY(mullionV.x2, mullionV.y2, mullionV.x3,
				mullionV.y3, mullionH.x1al, mullionH.y1al, mullionH.x4al,
				mullionH.y4al);

		y2cl = this.intersectY(mullionV.x2, mullionV.y2, mullionV.x3,
				mullionV.y3, mullionH.x2cl, mullionH.y2cl, mullionH.x3cl,
				mullionH.y3cl);

		y1a3 = this.intersectX(mullionV.x2cl, mullionV.y2cl, mullionV.x3cl,
				mullionV.y3cl, mullionH.x1al, mullionH.y1a3, mullionH.x4al,
				mullionH.y4a3);

		y2a3 = this.intersectX(mullionV.x2cl, mullionV.y2cl, mullionV.x3cl,
				mullionV.y3cl, mullionH.x2cl, mullionH.y2a3, mullionH.x3cl,
				mullionH.y3a3);

		y4a3 = this.intersectX(mullionV.x2cl, mullionV.y2cl, mullionV.x3cl,
				mullionV.y3cl, mullionH.x1al, mullionH.y1a3, mullionH.x4al,
				mullionH.y4a3);

		y3a3 = this.intersectX(mullionV.x2cl, mullionV.y2cl, mullionV.x3cl,
				mullionV.y3cl, mullionH.x2cl, mullionH.y2a3, mullionH.x3cl,
				mullionH.y3a3);

		start = mullionV.rowCol + 1;
		end = mullionH.endPos;

		myParentBO.mullionH = new Profiles(myParentBO, start, end, 2, x1, x2,
				y1, y2, x2 - x1, myFrame2);

		// Position Condition Calculation Missing.
		myParentBO.mullionH.cOrM = mullionH.cOrM;
		myParentBO.mullionH.rID = mullionH.rID; // record
		// ID

		myParentBO.mullionH.parentid = mullionH.parentid;

		myParentBO.mullionH.partShape = mullionH.partShape; // L,
		// T,
		// Z,
		// I,
		// H,

		myParentBO.mullionH.ABClines = mullionH.ABClines; // if
		// reflects
		// lines
		// for ABC dims of
		// parts, by T

		myParentBO.mullionH.orientation = mullionH.orientation; // Vertical
		// =
		// 1,
		// Horizontal
		// = 2

		myParentBO.mullionH.partDimA = mullionH.partDimA;
		myParentBO.mullionH.partDimB = mullionH.partDimB;
		myParentBO.mullionH.partDimBtoC = mullionH.partDimBtoC;
		myParentBO.mullionH.partDimC = mullionH.partDimC;
		myParentBO.mullionH.partDimM = mullionH.partDimM;

		myParentBO.mullionH.myParent = mullionH.myParent;

		myParentBO.mullionH.isValid = mullionH.isValid;

		myParentBO.mullionH.endTypeRB = mullionH.endTypeRB; // 1=mitered,
		// 2=
		// || 3=[]
		myParentBO.mullionH.endTypeLT = mullionH.endTypeLT;

		myParentBO.mullionH.rowCol = mullionH.rowCol;
		myParentBO.mullionH.startPos = start;
		myParentBO.mullionH.endPos = end;
		myParentBO.mullionH.x1 = x1;
		myParentBO.mullionH.x2 = x2;
		myParentBO.mullionH.x3 = mullionH.x3;
		myParentBO.mullionH.x4 = mullionH.x4;

		myParentBO.mullionH.x1al = myParentBO.mullionH.x1a = x1al;
		myParentBO.mullionH.x2cl = myParentBO.mullionH.x2a = x2cl;
		myParentBO.mullionH.centerXs = centerXs;
		myParentBO.mullionH.centerXe = mullionH.centerXe;
		myParentBO.mullionH.x3cl = myParentBO.mullionH.x3a = mullionH.x3cl;
		myParentBO.mullionH.x4al = myParentBO.mullionH.x4a = mullionH.x4al;

		myParentBO.mullionH.y1 = myParentBO.mullionH.y1a = y1;
		myParentBO.mullionH.y2 = myParentBO.mullionH.y2a = y2;
		myParentBO.mullionH.y1al = y1al;
		myParentBO.mullionH.y2cl = y2cl;
		myParentBO.mullionH.centerYs = centerYs;
		myParentBO.mullionH.centerYe = mullionH.centerYe;
		myParentBO.mullionH.y3 = myParentBO.mullionH.y3a = mullionH.y3;
		myParentBO.mullionH.y4 = myParentBO.mullionH.y4a = mullionH.y4;
		myParentBO.mullionH.y3cl = mullionH.y3cl;
		myParentBO.mullionH.y4al = mullionH.y4al;

		myParentBO.mullionH.offsetRB = mullionH.offsetRB;
		myParentBO.mullionH.offsetTL = mullionH.offsetTL;
		myParentBO.mullionH.partForm = mullionH.partForm;
		myParentBO.mullionH.thickness = mullionH.thickness;
		myParentBO.mullionH.exists = 2;

		myParentBO.mullionH.length = myParentBO.mullionH.centerYe
				- myParentBO.mullionH.centerYs;

		myParentBO.mullionH.x1a3 = x1a3;
		myParentBO.mullionH.x2a3 = x2a3;
		myParentBO.mullionH.x3a3 = x3a3;
		myParentBO.mullionH.x4a3 = x4a3;

		myParentBO.mullionH.y1a3 = y1a3;
		myParentBO.mullionH.y2a3 = y2a3;
		myParentBO.mullionH.y3a3 = y3a3;
		myParentBO.mullionH.y4a3 = y4a3;

		this.modifyHMullion(c);

		myParentBO.mullionH = recalcMullion(myParentBO.mullionH);

		myParentBO.mullionsH.add(myParentBO.mullionH);

	}

	private void modifyHMullion(final int c) {

		((Profiles) myParentBO.mullionObjectsH[c]).endPos = myParentBO.myProfilesV.rowCol;
		if (((Profiles) myParentBO.mullionObjectsH[c]).endTypeRB > 1) {

			((Profiles) myParentBO.mullionObjectsH[c]).x4 = this.intersectX(
					myParentBO.myProfilesV.x1, myParentBO.myProfilesV.y1,
					myParentBO.myProfilesV.x4, myParentBO.myProfilesV.y4,
					((Profiles) myParentBO.mullionObjectsH[c]).x1,
					((Profiles) myParentBO.mullionObjectsH[c]).y1,
					((Profiles) myParentBO.mullionObjectsH[c]).x4,
					((Profiles) myParentBO.mullionObjectsH[c]).y4);

			((Profiles) myParentBO.mullionObjectsH[c]).x4al = this.intersectX(
					myParentBO.myProfilesV.x1, myParentBO.myProfilesV.y1,
					myParentBO.myProfilesV.x4, myParentBO.myProfilesV.y4,
					((Profiles) myParentBO.mullionObjectsH[c]).x1al,
					((Profiles) myParentBO.mullionObjectsH[c]).y1al,
					((Profiles) myParentBO.mullionObjectsH[c]).x4al,
					((Profiles) myParentBO.mullionObjectsH[c]).y4al);

			((Profiles) myParentBO.mullionObjectsH[c]).x4a3 = this.intersectX(
					myParentBO.myProfilesV.x1al, myParentBO.myProfilesV.y1al,
					myParentBO.myProfilesV.x4al, myParentBO.myProfilesV.y4al,
					((Profiles) myParentBO.mullionObjectsH[c]).x1al,
					((Profiles) myParentBO.mullionObjectsH[c]).y1al,
					((Profiles) myParentBO.mullionObjectsH[c]).x4al,
					((Profiles) myParentBO.mullionObjectsH[c]).y4al);

			((Profiles) myParentBO.mullionObjectsH[c]).centerXe = this
					.intersectX(
							myParentBO.myProfilesV.x1,
							myParentBO.myProfilesV.y1,
							myParentBO.myProfilesV.x4,
							myParentBO.myProfilesV.y4,
							((Profiles) myParentBO.mullionObjectsH[c]).centerXs,
							((Profiles) myParentBO.mullionObjectsH[c]).centerYs,
							((Profiles) myParentBO.mullionObjectsH[c]).centerXe,
							((Profiles) myParentBO.mullionObjectsH[c]).centerYe);

			((Profiles) myParentBO.mullionObjectsH[c]).x3 = this.intersectX(
					myParentBO.myProfilesV.x1, myParentBO.myProfilesV.y1,
					myParentBO.myProfilesV.x4, myParentBO.myProfilesV.y4,
					((Profiles) myParentBO.mullionObjectsH[c]).x2,
					((Profiles) myParentBO.mullionObjectsH[c]).y2,
					((Profiles) myParentBO.mullionObjectsH[c]).x3,
					((Profiles) myParentBO.mullionObjectsH[c]).y3);

			((Profiles) myParentBO.mullionObjectsH[c]).x3cl = this.intersectX(
					myParentBO.myProfilesV.x1, myParentBO.myProfilesV.y1,
					myParentBO.myProfilesV.x4, myParentBO.myProfilesV.y4,
					((Profiles) myParentBO.mullionObjectsH[c]).x2cl,
					((Profiles) myParentBO.mullionObjectsH[c]).y2cl,
					((Profiles) myParentBO.mullionObjectsH[c]).x3cl,
					((Profiles) myParentBO.mullionObjectsH[c]).y3cl);

			((Profiles) myParentBO.mullionObjectsH[c]).x3a3 = this.intersectX(
					myParentBO.myProfilesV.x1al, myParentBO.myProfilesV.y1al,
					myParentBO.myProfilesV.x4al, myParentBO.myProfilesV.y4al,
					((Profiles) myParentBO.mullionObjectsH[c]).x2cl,
					((Profiles) myParentBO.mullionObjectsH[c]).y2cl,
					((Profiles) myParentBO.mullionObjectsH[c]).x3cl,
					((Profiles) myParentBO.mullionObjectsH[c]).y3cl);

			// /////////////////////

			((Profiles) myParentBO.mullionObjectsH[c]).y4 = this.intersectY(
					myParentBO.myProfilesV.x1, myParentBO.myProfilesV.y1,
					myParentBO.myProfilesV.x4, myParentBO.myProfilesV.y4,
					((Profiles) myParentBO.mullionObjectsH[c]).x1,
					((Profiles) myParentBO.mullionObjectsH[c]).y1,
					((Profiles) myParentBO.mullionObjectsH[c]).x4,
					((Profiles) myParentBO.mullionObjectsH[c]).y4);

			((Profiles) myParentBO.mullionObjectsH[c]).y4al = this.intersectY(
					myParentBO.myProfilesV.x1, myParentBO.myProfilesV.y1,
					myParentBO.myProfilesV.x4, myParentBO.myProfilesV.y4,
					((Profiles) myParentBO.mullionObjectsH[c]).x1al,
					((Profiles) myParentBO.mullionObjectsH[c]).y1al,
					((Profiles) myParentBO.mullionObjectsH[c]).x4al,
					((Profiles) myParentBO.mullionObjectsH[c]).y4al);

			((Profiles) myParentBO.mullionObjectsH[c]).centerYe = this
					.intersectY(
							myParentBO.myProfilesV.x1,
							myParentBO.myProfilesV.y1,
							myParentBO.myProfilesV.x4,
							myParentBO.myProfilesV.y4,
							((Profiles) myParentBO.mullionObjectsH[c]).centerXs,
							((Profiles) myParentBO.mullionObjectsH[c]).centerYs,
							((Profiles) myParentBO.mullionObjectsH[c]).centerXe,
							((Profiles) myParentBO.mullionObjectsH[c]).centerYe);

			((Profiles) myParentBO.mullionObjectsH[c]).y3 = this.intersectY(
					myParentBO.myProfilesV.x1, myParentBO.myProfilesV.y1,
					myParentBO.myProfilesV.x4, myParentBO.myProfilesV.y4,
					((Profiles) myParentBO.mullionObjectsH[c]).x2,
					((Profiles) myParentBO.mullionObjectsH[c]).y2,
					((Profiles) myParentBO.mullionObjectsH[c]).x3,
					((Profiles) myParentBO.mullionObjectsH[c]).y3);

			((Profiles) myParentBO.mullionObjectsH[c]).y3cl = this.intersectY(
					myParentBO.myProfilesV.x1, myParentBO.myProfilesV.y1,
					myParentBO.myProfilesV.x4, myParentBO.myProfilesV.y4,
					((Profiles) myParentBO.mullionObjectsH[c]).x2cl,
					((Profiles) myParentBO.mullionObjectsH[c]).y2cl,
					((Profiles) myParentBO.mullionObjectsH[c]).x3cl,
					((Profiles) myParentBO.mullionObjectsH[c]).y3cl);

			// /////////////////////////

		} else if (((Profiles) myParentBO.mullionObjectsH[c]).endTypeRB == 1) {

			((Profiles) myParentBO.mullionObjectsH[c]).x4 = this.intersectX(
					myParentBO.myProfilesV.x1, myParentBO.myProfilesV.y1,
					myParentBO.myProfilesV.x4, myParentBO.myProfilesV.y4,
					((Profiles) myParentBO.mullionObjectsH[c]).x1,
					((Profiles) myParentBO.mullionObjectsH[c]).y1,
					((Profiles) myParentBO.mullionObjectsH[c]).x4,
					((Profiles) myParentBO.mullionObjectsH[c]).y4);

			((Profiles) myParentBO.mullionObjectsH[c]).x4al = this.intersectX(
					myParentBO.myProfilesV.x1, myParentBO.myProfilesV.y1,
					myParentBO.myProfilesV.x4, myParentBO.myProfilesV.y4,
					((Profiles) myParentBO.mullionObjectsH[c]).x1al,
					((Profiles) myParentBO.mullionObjectsH[c]).y1al,
					((Profiles) myParentBO.mullionObjectsH[c]).x4al,
					((Profiles) myParentBO.mullionObjectsH[c]).y4al);

			((Profiles) myParentBO.mullionObjectsH[c]).centerXe = this
					.intersectX(
							myParentBO.myProfilesV.x1,
							myParentBO.myProfilesV.y1,
							myParentBO.myProfilesV.x4,
							myParentBO.myProfilesV.y4,
							((Profiles) myParentBO.mullionObjectsH[c]).centerXs,
							((Profiles) myParentBO.mullionObjectsH[c]).centerYs,
							((Profiles) myParentBO.mullionObjectsH[c]).centerXe,
							((Profiles) myParentBO.mullionObjectsH[c]).centerYe);

			((Profiles) myParentBO.mullionObjectsH[c]).x3 = this.intersectX(
					myParentBO.myProfilesV.x1, myParentBO.myProfilesV.y1,
					myParentBO.myProfilesV.x4, myParentBO.myProfilesV.y4,
					((Profiles) myParentBO.mullionObjectsH[c]).x2,
					((Profiles) myParentBO.mullionObjectsH[c]).y2,
					((Profiles) myParentBO.mullionObjectsH[c]).x3,
					((Profiles) myParentBO.mullionObjectsH[c]).y3);

			((Profiles) myParentBO.mullionObjectsH[c]).x3cl = this.intersectX(
					myParentBO.myProfilesV.x1, myParentBO.myProfilesV.y1,
					myParentBO.myProfilesV.x4, myParentBO.myProfilesV.y4,
					((Profiles) myParentBO.mullionObjectsH[c]).x2cl,
					((Profiles) myParentBO.mullionObjectsH[c]).y2cl,
					((Profiles) myParentBO.mullionObjectsH[c]).x3cl,
					((Profiles) myParentBO.mullionObjectsH[c]).y3cl);

			// /////////////////////

			((Profiles) myParentBO.mullionObjectsH[c]).y4 = this.intersectY(
					myParentBO.myProfilesV.x1, myParentBO.myProfilesV.y1,
					myParentBO.myProfilesV.x4, myParentBO.myProfilesV.y4,
					((Profiles) myParentBO.mullionObjectsH[c]).x1,
					((Profiles) myParentBO.mullionObjectsH[c]).y1,
					((Profiles) myParentBO.mullionObjectsH[c]).x4,
					((Profiles) myParentBO.mullionObjectsH[c]).y4);

			((Profiles) myParentBO.mullionObjectsH[c]).y4al = this.intersectY(
					myParentBO.myProfilesV.x1, myParentBO.myProfilesV.y1,
					myParentBO.myProfilesV.x4, myParentBO.myProfilesV.y4,
					((Profiles) myParentBO.mullionObjectsH[c]).x1al,
					((Profiles) myParentBO.mullionObjectsH[c]).y1al,
					((Profiles) myParentBO.mullionObjectsH[c]).x4al,
					((Profiles) myParentBO.mullionObjectsH[c]).y4al);

			((Profiles) myParentBO.mullionObjectsH[c]).centerYe = this
					.intersectY(
							myParentBO.myProfilesV.x1,
							myParentBO.myProfilesV.y1,
							myParentBO.myProfilesV.x4,
							myParentBO.myProfilesV.y4,
							((Profiles) myParentBO.mullionObjectsH[c]).centerXs,
							((Profiles) myParentBO.mullionObjectsH[c]).centerYs,
							((Profiles) myParentBO.mullionObjectsH[c]).centerXe,
							((Profiles) myParentBO.mullionObjectsH[c]).centerYe);

			((Profiles) myParentBO.mullionObjectsH[c]).y3 = this.intersectY(
					myParentBO.myProfilesV.x1, myParentBO.myProfilesV.y1,
					myParentBO.myProfilesV.x4, myParentBO.myProfilesV.y4,
					((Profiles) myParentBO.mullionObjectsH[c]).x2,
					((Profiles) myParentBO.mullionObjectsH[c]).y2,
					((Profiles) myParentBO.mullionObjectsH[c]).x3,
					((Profiles) myParentBO.mullionObjectsH[c]).y3);

			((Profiles) myParentBO.mullionObjectsH[c]).y3cl = this.intersectY(
					myParentBO.myProfilesV.x1, myParentBO.myProfilesV.y1,
					myParentBO.myProfilesV.x4, myParentBO.myProfilesV.y4,
					((Profiles) myParentBO.mullionObjectsH[c]).x2cl,
					((Profiles) myParentBO.mullionObjectsH[c]).y2cl,
					((Profiles) myParentBO.mullionObjectsH[c]).x3cl,
					((Profiles) myParentBO.mullionObjectsH[c]).y3cl);

		}

		((Profiles) myParentBO.mullionObjectsH[c]).length = ((Profiles) myParentBO.mullionObjectsH[c]).centerYe
				- ((Profiles) myParentBO.mullionObjectsH[c]).centerYs;

		((Profiles) myParentBO.mullionObjectsH[c]).notches.clear();

		myParentBO.mullionObjectsH[c] = recalcMullion((Profiles) myParentBO.mullionObjectsH[c]);

		((Profiles) myParentBO.mullionObjectsH[c]).endIn = true;

		myParentBO.mullionsH.add(myParentBO.mullionObjectsH[c]);
	}

	/**
	 * Add Mullion vertical at position
	 * 
	 * @param x
	 *            , Axis xx position
	 * @param y
	 *            , Axis yy position
	 * @param assemblyL
	 *            , Assambly
	 */
	private void addMullionVAtPos(int x, int y, int assemblyL) {

		myParentBO.mullionObjectsV = null;
		myParentBO.mullionObjectsV = myParentBO.mullions.toArray();
		myParentBO.mullions.clear();

		for (Object element : myParentBO.mullionObjectsV) {
			if (((Profiles) element).rowCol < newVCCol) {
				((Profiles) element).isNew = false;
				myParentBO.mullions.add(element);
			} else if (((Profiles) element).rowCol == newVCCol
					&& ((Profiles) element).endPos < vcStart) {
				((Profiles) element).isNew = false;
				myParentBO.mullions.add(element);
			}

		}

		myParentBO.mullion = new Profiles(myParentBO, vcStart, vcEnd, 1,
				vcStartY, vcEndY, 0, 0, 0, myFrame2);

		myParentBO.mullion.a_assemblyLevel = assemblyL;

		myParentBO.mullion = this.getProfileDims(myParentBO.mullion);

		if (cOrM > 2) {

			myParentBO.mullion.endTypeLT = 3;
			myParentBO.mullion.endTypeRB = 3;

		}

		myParentBO.mullion.a_levelID = 4;
		myParentBO.mullion.a_1Level = myParentBO.a_assemblyLevel;
		myParentBO.mullion.a_1Sequence = myParentBO.a_sequenceID;
		myParentBO.mullion.a_2Level = myParentBO.a_1Level;
		myParentBO.mullion.a_2Sequence = myParentBO.a_1Sequence;
		myParentBO.mullion.a_3Level = myParentBO.a_2Level;
		myParentBO.mullion.a_3Sequence = myParentBO.a_2Sequence;
		myParentBO.mullion.a_4Level = myParentBO.a_3Level;
		myParentBO.mullion.a_4Sequence = myParentBO.a_3Sequence;

		myParentBO.mullion.a_5Level = myParentBO.a_4Level;
		myParentBO.mullion.a_5Sequence = myParentBO.a_4Sequence;
		myParentBO.mullion.a_6Level = myParentBO.a_5Level;
		myParentBO.mullion.a_6Sequence = myParentBO.a_5Sequence;
		myParentBO.mullion.a_7Level = myParentBO.a_6Level;
		myParentBO.mullion.a_7Sequence = myParentBO.a_6Sequence;
		myParentBO.mullion.a_8Level = myParentBO.a_7Level;
		myParentBO.mullion.a_8Sequence = myParentBO.a_7Sequence;
		myParentBO.mullion.a_9Level = myParentBO.a_8Level;
		myParentBO.mullion.a_9Sequence = myParentBO.a_8Sequence;
		myParentBO.mullion.a_10Level = myParentBO.a_9Level;
		myParentBO.mullion.a_10Sequence = myParentBO.a_9Sequence;

		myParentBO.mullion.a_11Level = myParentBO.a_10Level;
		myParentBO.mullion.a_11Sequence = myParentBO.a_10Sequence;
		myParentBO.mullion.a_12Level = myParentBO.a_11Level;
		myParentBO.mullion.a_12Sequence = myParentBO.a_11Sequence;
		myParentBO.mullion.a_13Level = myParentBO.a_12Level;
		myParentBO.mullion.a_13Sequence = myParentBO.a_12Sequence;
		myParentBO.mullion.a_14Level = myParentBO.a_13Level;
		myParentBO.mullion.a_14Sequence = myParentBO.a_13Sequence;

		myParentBO.mullion.a_15Level = myParentBO.a_14Level;
		myParentBO.mullion.a_15Sequence = myParentBO.a_14Sequence;
		myParentBO.mullion.a_16Level = myParentBO.a_15Level;
		myParentBO.mullion.a_16Sequence = myParentBO.a_15Sequence;
		myParentBO.mullion.a_17Level = myParentBO.a_16Level;
		myParentBO.mullion.a_17Sequence = myParentBO.a_16Sequence;
		myParentBO.mullion.a_18Level = myParentBO.a_17Level;
		myParentBO.mullion.a_18Sequence = myParentBO.a_17Sequence;
		myParentBO.mullion.a_19Level = myParentBO.a_18Level;
		myParentBO.mullion.a_19Sequence = myParentBO.a_18Sequence;
		myParentBO.mullion.a_20Level = myParentBO.a_19Level;
		myParentBO.mullion.a_20Sequence = myParentBO.a_19Sequence;
		myParentBO.mullion.a_21Level = myParentBO.a_20Level;
		myParentBO.mullion.a_21Sequence = myParentBO.a_20Sequence;
		myParentBO.mullion.a_22Level = myParentBO.a_21Level;
		myParentBO.mullion.a_22Sequence = myParentBO.a_21Sequence;

		myParentBO.mullion.exists = alreadyExist;
		myParentBO.mullion.fixedAngle = fixedAngle;
		myParentBO.mullion.angle = angle;
		myParentBO.mullion.phantom = phantom;
		myParentBO.mullion.divideFacet = myFrame2.mullionsPanel.divideFacet;
		myParentBO.mullion.order = 1;// this.getLastInputOrder();
		myParentBO.mullion.cOrM = cOrM;

		myParentBO.mullion.udControlOpeningID = myParentBO.myOpeningID;

		myParentBO.mullion.openingClass = myParentBO.openingClass;

		myParentBO.mullion.rowCol = newVCCol;
		myParentBO.mullion.a_sequenceID = newVCCol;
		myParentBO.mullion.startPos = vcStart;
		myParentBO.mullion.endPos = vcEnd;
		myParentBO.mullion.x1 = x;
		myParentBO.mullion.x2 = x;
		myParentBO.mullion.x3 = x;
		myParentBO.mullion.x4 = x;
		myParentBO.mullion.x1al = x;
		myParentBO.mullion.x2cl = x;
		myParentBO.mullion.x3cl = x;
		myParentBO.mullion.x4al = x;
		myParentBO.mullion.centerXs = x;
		myParentBO.mullion.centerXe = x;

		myParentBO.mullion.posCondition = posCondition;
		myParentBO.mullion.startIn = startIn;
		myParentBO.mullion.endIn = endIn;
		myParentBO.mullion.continuity = continuity;
		myParentBO.mullion.mType = mType;

		myParentBO.mullion.typeID = typeID;

		myParentBO.mullion.whichPos = whichPos;

		myParentBO.mullion.partID = partID;
		myParentBO.mullion.partForm = 1;
		myParentBO.mullion.offsetTL = 0;
		myParentBO.mullion.offsetRB = 0;
		myParentBO.mullion.deltaTL = 0;// this.myParentBO.openingW

		myParentBO.mullion.deltaRB = 0;// this.myParentBO.openingW 3;
		myParentBO.mullion.curveCenterTL = 0;// this.myParentBO.openingW 2;
		myParentBO.mullion.curveCenterRB = 0;// this.myParentBO.openingW 2;
		myParentBO.mullion.isNew = true;

		if (alreadyExist == 2 ||
				myParentBO.mullion.centerYs ==0 ||
				myParentBO.mullion.centerYe ==0) {
		
				myParentBO.mullion.y1 = vcStartY;
				myParentBO.mullion.y2 = vcStartY;
				myParentBO.mullion.y3 = vcEndY;
				myParentBO.mullion.y4 = vcEndY;
				myParentBO.mullion.centerYs = vcStartY;
				myParentBO.mullion.centerYe = vcEndY;
			
		}

		myParentBO.mullion
				.executeRulesMethod("addMullionV.addMullinVAtPos.6254");
		myParentBO.mullion.setMullionColor();

		myParentBO.mullion.bom.clear();
		myParentBO.mullion.clearBomForProfile();

		// myParentBO.mullion = (Profiles)
		// myFrame2.executePartRules.executePartRules(null, null,
		// myParentBO.mullion, myParentBO.mullion.a_assemblyLevel, false, false,
		// "AddMullionV.addMullinVAtPos 6262");

		myParentBO.mullion = ((Profiles) myParentBO.mullion)
				.executePartRules(false);

		if (myFrame2.mySeries.getSeriesUom() == 1) {

			thickness = myParentBO.mullion.partDimB;
			partDimC = myParentBO.mullion.partDimC;
			partDimA = myParentBO.mullion.partDimA;
			partDimB = myParentBO.mullion.partDimB;
			partDimD = myParentBO.mullion.partDimD;
			partDimBtoC = myParentBO.mullion.partDimBtoC;
			partDimM = myParentBO.mullion.partDimM;

		} else {

			thickness = myParentBO.mullion.partDimBi;
			partDimC = myParentBO.mullion.partDimCi;
			partDimA = myParentBO.mullion.partDimAi;
			partDimB = myParentBO.mullion.partDimBi;
			partDimD = myParentBO.mullion.partDimDi;
			partDimBtoC = myParentBO.mullion.partDimBtoCi;
			partDimM = myParentBO.mullion.partDimMi;
		}

		myParentBO.mullions.add(myParentBO.mullion);

		for (Object element : myParentBO.mullionObjectsV) {

			if (((Profiles) element).rowCol == newVCCol
					&& ((Profiles) element).startPos > vcEnd) {
				((Profiles) element).isNew = false;
				myParentBO.mullions.add(element);
			}
			if (((Profiles) element).rowCol > newVCCol) {
				((Profiles) element).isNew = false;
				myParentBO.mullions.add(element);
			}

		}// /Mullion

	}

	/**
	 * This method return dimension for coupler or mullion into BkgrdOpening
	 * object.
	 * 
	 * @param xCols
	 *            , Number of columns
	 * @param from
	 *            , From value to process
	 */
	public void getDimsForMullion(int xCols, int from) {

		// *******************************************************
		// Preparing scale metric
		// *******************************************************
		if (myFrame2.myTopPanel.metric.isSelected()) {
			myScale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myFrame2.scale;
		}

		// Setting valid Mullion validation key for Level 3 & Level 12
		if (myParentBO.myParent.a_levelID == 3
				|| myParentBO.myParent.a_levelID == 12) {
			cOrM = 2;
		}

		// Init thickness value
		double myThickness = thickness;

		// Get total mullion & coupler thickness
		getTotalMCThick();

		/**
		 * Init starting x position from minimum value into BkgrdOpening
		 * startingX and bX4. This value is implemented then for add new width
		 * column and then obtain the position X where this type of divider
		 * should be place.
		 */
		myStartingX = Math.min(myParentBO.startingX, myParentBO.bX4);

		/**
		 * Init calculation when dimension for coupler is not a new position
		 * from action into DrawCanvas panel to make a division for ShapeObject.
		 */
		if (!myParentBO.myFrame2.mullionsPanel.divideFacet && cOrM == 1) {

			// Calculate for metric unit of measure
			if (myFrame2.currentUOM == 1) {

				if (myStartingX == Math.min(myParentBO.myParent.startingX,
						myParentBO.myParent.bX4)) {

					newColW = ((new BigDecimal(myParentBO.myParent.widthMO)
							.multiply(myFrame2.scale)).subtract(new BigDecimal(
							mullionThickTotal))).divide(new BigDecimal(xCols),
							10, BigDecimal.ROUND_UP).doubleValue();

					final double mydim = UOMConvert.getBigDecimalConversion(
							newColW, myScale, 2);

					newColW = myFrame2.roundDim(mydim, 2, myFrame2.metricRound,
							1) * myScale.doubleValue();
				} else {
					myFrame2.dim.frame.doClick();

					// newColW = (myParentBO.widthMO * myFrame2.scale -
					// mullionThickTotal) / xCols;

					newColW = ((new BigDecimal(myParentBO.myParent.widthMO)
							.multiply(myFrame2.scale)).subtract(new BigDecimal(
							mullionThickTotal))).divide(new BigDecimal(xCols),
							10, BigDecimal.ROUND_UP).doubleValue();

					// newColW = myFrame2.roundDim(newColW, 2,
					// myFrame2.impRound, 1)
					// * myScale.doubleValue();

				}

			} else {

				if (myStartingX == Math.min(myParentBO.myParent.startingX,
						myParentBO.myParent.bX4)) {
					// newColW = (myParentBO.myParent.widthIO * myFrame2.scale -
					// mullionThickTotal) / xCols;

					newColW = ((new BigDecimal(myParentBO.myParent.widthIO)
							.multiply(myFrame2.scale)).subtract(new BigDecimal(
							mullionThickTotal))).divide(new BigDecimal(xCols),
							20, BigDecimal.ROUND_UP).doubleValue();

				} else {
					// newColW = (myParentBO.widthIO * myFrame2.scale -
					// mullionThickTotal) / xCols;
					//
					newColW = ((new BigDecimal(myParentBO.myParent.widthIO)
							.multiply(myFrame2.scale)).subtract(new BigDecimal(
							mullionThickTotal))).divide(new BigDecimal(xCols),
							10, BigDecimal.ROUND_UP).doubleValue();

				}
				final double mydim = UOMConvert.getBigDecimalConversion(
						newColW, myScale, 2);
				newColW = myFrame2.roundDim(mydim, 2, myFrame2.impRound, 2)
						* myFrame2.scale.doubleValue();
			}

			if (myStartingX == Math.min(myParentBO.myParent.startingX,
					myParentBO.myParent.bX4)) {

				if (xCols * newColW + mullionThickTotal != myParentBO.myParent.widthPix // &&
																						// from
																						// ==
																						// 1
						&& myFrame2.jobItem.design.frames.size() == 1) {

					myParentBO.myParent.widthPix = xCols * newColW
							+ mullionThickTotal;

					Object[] myTextOriginal = new Object[2];
					try {
						myTextOriginal = myFrame2
								.readConvertText(myFrame2.myTopPanel.fW);
					} catch (final Exception e) {
						e.printStackTrace();
					}
					final Object[] dVs = myFrame2.jobItem.design.bOpeningObject.mullions
							.toArray();
					double totalThicks = 0;
					int countFacets = 1;
					for (final Object d : dVs) {
						if (!((Profiles) d).divideFacet) {
							totalThicks = totalThicks
									+ ((Profiles) d).thickness
									* myFrame2.scale.doubleValue();
							countFacets++;
						}
					}
					java.lang.Double.parseDouble(myTextOriginal[0].toString());

					Object[] fs = myFrame2.jobItem.design.frames.toArray();
					double newW = 0;
					myFrame2.jobItem.design.frames.clear();
					for (int j = 0; j < fs.length; j++) {
						if (myFrame2.facetUsed.equals(fs[j])) {

							((Facet) fs[j]).widthPix = myParentBO.myParent.widthPix;
							((Facet) fs[j]).setDimsChange(
									myParentBO.myParent.widthPix,
									((Facet) fs[j]).heightPix);
							myFrame2.jobItem.design.frames.add(fs[j]);
						} else {
							myFrame2.jobItem.design.frames.add(fs[j]);
						}

					}

					fs = myFrame2.jobItem.design.frames.toArray();
					for (int j = 0; j < fs.length; j++) {
						newW = newW + ((Facet) fs[j]).widthPix;
					}

					newW = newW / myFrame2.scale.doubleValue() + totalThicks
							/ myFrame2.scale.doubleValue();

					myFrame2.jobItem.setWHDimChange(
							newW,
							myFrame2.jobItem._HEIGHTpix
									/ myFrame2.scale.doubleValue(), true);
					myFrame2.changeFacetW = true;

				}
			} else {
				if (xCols * newColW + mullionThickTotal != myParentBO.widthPix
						&& from == 1
						&& myFrame2.jobItem.design.frames.size() == 1) {

				}

			}

		} else if (!myParentBO.myFrame2.mullionsPanel.divideFacet && cOrM > 1) {
			newColW = (myParentBO.widthPix - mullionThickTotal) / xCols;

		} else {
			if (myParentBO.myFrame2.currentUOM == 1) {

				newColW = (myParentBO.myFrame2.jobItem._WIDTH_Metric_O
						* myFrame2.scale.doubleValue() - mullionThickTotal)
						/ xCols;

				final double mydim = newColW / myFrame2.scale.doubleValue();

				newColW = myFrame2.roundDim(mydim, 2, myFrame2.metricRound, 1)
						* myFrame2.scale.doubleValue();

			} else {
				newColW = (myParentBO.myFrame2.jobItem._WIDTH_Imp_O
						* myFrame2.scale.doubleValue() - mullionThickTotal)
						/ xCols;
				final double mydim = newColW / myFrame2.scale.doubleValue();

				newColW = myFrame2.roundDim(mydim, 2, myFrame2.impRound, 2)
						* myFrame2.scale.doubleValue();
			}
		}

		if (newColW < myParentBO.minLeg * myFrame2.scale.doubleValue()) {
			goodToGo = false;
		}
		if (goodToGo) {

			final Object[] openings = myParentBO.myParent.openings.toArray();
			for (final Object O : openings) {
				if (!goodToGo) {
					break;
				}

				if (((OpeningObject) O).minW * myFrame2.scale.doubleValue() > newColW
						|| ((OpeningObject) O).minW
								* myFrame2.scale.doubleValue() > newColW
						|| ((OpeningObject) O).minW
								* myFrame2.scale.doubleValue() > newColW) {
					goodToGo = false;
					break;
				}

				if (((OpeningObject) O).contentMid == 1
						|| ((OpeningObject) O).contentIn == 1
						|| ((OpeningObject) O).contentOut == 1) {
					if (((OpeningObject) O).dloMid != null
							&& ((OpeningObject) O).dloMid.minW
									* myFrame2.scale.doubleValue() > newColW
							|| ((OpeningObject) O).dloIn != null
							&& ((OpeningObject) O).dloIn.minW
									* myFrame2.scale.doubleValue() > newColW
							|| ((OpeningObject) O).dloOut != null
							&& ((OpeningObject) O).dloOut.minW
									* myFrame2.scale.doubleValue() > newColW) {
						goodToGo = false;
						break;
					}

				} else if (((OpeningObject) O).contentMid == 2
						&& ((OpeningObject) O).sashObjectMid != null) {

					final Object[] sashes = ((OpeningObject) O).sashObjectMid.frames
							.toArray();

					for (final Object s : sashes) {
						if (((SashLeaf) s).minW * myFrame2.scale.doubleValue() > newColW) {
							goodToGo = false;
							break;
						}
						final Object[] sopenings = ((SashLeaf) s).openings
								.toArray();
						final double mySashColW = (((SashLeaf) s).widthPix - (((SashLeaf) s).xCols - 1)
								* myThickness)
								/ ((SashLeaf) s).xCols;
						for (final Object sO : sopenings) {
							if (((OpeningObject) sO).minW
									* myFrame2.scale.doubleValue() > mySashColW
									|| ((OpeningObject) sO).minW
											* myFrame2.scale.doubleValue() > mySashColW
									|| ((OpeningObject) sO).minW
											* myFrame2.scale.doubleValue() > mySashColW) {
								goodToGo = false;
								break;
							}
						}

					}
				} else if (((OpeningObject) O).contentMid == 3) {

				}

			}

		}

		if (!goodToGo || !goodToDivide) {

			final Object[] myVs = myParentBO.mullions.toArray();
			Collection tempVs = new ArrayList();
			for (final Object element2 : myVs) {
				tempVs.add(element2);
			}
			if (!goodToGo) {
				JOptionPane.showMessageDialog(null, "Mininum Width reached!\n"
						+ "No additional Verticals are possible!", "Error!",
						JOptionPane.ERROR_MESSAGE);
			}
			// myFrame2.undoAction();
			myParentBO.mullionObjectsV = tempVs.toArray();
			tempVs.clear();
			tempVs = null;
			int myRC = 0;
			for (final Object element : myParentBO.mullionObjectsV) {
				if (!((Profiles) element).isNew) {
					myParentBO.mullions.add(element);
				} else {
					myRC = ((Profiles) element).rowCol;
				}
			}
			if (alreadyExist == 1) {
				myParentBO.xCols = myParentBO.xCols - 1;
				myParentBO.myParent.xCols = myParentBO.myParent.xCols - 1;
			}
			myParentBO.mullionObjectsV = myParentBO.mullions.toArray();
			myParentBO.mullions.clear();
			for (final Object element : myParentBO.mullionObjectsV) {

				if (((Profiles) element).rowCol >= myRC) {

					((Profiles) element).rowCol = ((Profiles) element).rowCol - 1;

				}

				myParentBO.mullions.add(element);
			}

		}

	}

	/**
	 * Return total Mullion & Coupler thickness
	 * 
	 * @return double
	 */
	public double getTotalMCThick() {

		// Init collection or rows
		Collection doneRows = new Vector();
		doneRows.add(0);

		int myCol = 1;
		double maxThickForRow = 0;
		double myThickness = 0;
		mullionThickTotal = 0;

		// Init collections of mullions
		Object[] mVs = myParentBO.mullions.toArray();

		for (Object element : mVs) {

			myThickness = thickness;

			((Profiles) element).recalcProfileDims();

			if (thickness == 0) {
				if (myFrame2.mySeries.getSeriesUom() == 1) {
					myThickness = thickness = ((Profiles) element).partDimB;
				} else {
					myThickness = thickness = ((Profiles) element).partDimBi;
				}
			}

			myCol = ((Profiles) element).rowCol;

			if (!doneRows.contains(myCol)) {
				for (final Object element2 : mVs) {
					if (((Profiles) element2).rowCol == myCol
							&& ((Profiles) element2).exists == 1) {
						if (myFrame2.mySeries.getSeriesUom() == 1) {
							myThickness = ((Profiles) element2).partDimB;
						} else {
							myThickness = ((Profiles) element2).partDimBi;
						}

						myCol = ((Profiles) element2).rowCol;
						doneRows.add(myCol);
						if (myThickness > maxThickForRow) {
							maxThickForRow = thickness;
						}
					}
				}
				mullionThickTotal = mullionThickTotal + maxThickForRow;
			}
		}
		return mullionThickTotal;
	}

	public int getLastInputOrder() {

		int order = 0;
		final Object[] hs = myParentBO.mullionObjectsH;
		final Object[] vs = myParentBO.mullionObjectsV;
		for (final Object h : hs) {
			if (((Profiles) h).order > order) {
				order = ((Profiles) h).order;
			}
		}
		for (final Object v : vs) {
			if (((Profiles) v).order > order) {
				order = ((Profiles) v).order;
			}
		}

		return order + 1;
	}

	public void getSumPrevMullions(final int col, final int row) {

		sumOfPrevMullions = 0;
		final Collection doneRows = new Vector();
		doneRows.add(0);
		int myCol = 1;
		double maxThickForRow = 0;
		if (col > 1) {// && !this.myParent.wireFrame) {
			for (final Object element : myParentBO.mullionObjectsV) {

				myCol = ((Profiles) element).rowCol;

				if (!doneRows.contains(myCol) && col > myCol) {
					for (final Object element2 : myParentBO.mullionObjectsV) {
						if (((Profiles) element2).rowCol == myCol) {
							myCol = ((Profiles) element2).rowCol;
							doneRows.add(myCol);
							if (((Profiles) element2).thickness
									* myFrame2.scale.doubleValue() > maxThickForRow) {
								maxThickForRow = ((Profiles) element2).thickness;
							}
						}
					}
					sumOfPrevMullions = sumOfPrevMullions + maxThickForRow;
				}
			}// for
		}

	}

	public void reOrderHMullions() {

		for (int c = 0; c < myParentBO.mullionObjectsH.length; c++) {

			if (((Profiles) myParentBO.mullionObjectsH[c]).endPos >= newVCCol
					&& ((Profiles) myParentBO.mullionObjectsH[c]).endPos < myParentBO.xCols) {

				((Profiles) myParentBO.mullionObjectsH[c]).endPos = ((Profiles) myParentBO.mullionObjectsH[c]).endPos + 1;

			}

			if (((Profiles) myParentBO.mullionObjectsH[c]).startPos > newVCCol
					&& ((Profiles) myParentBO.mullionObjectsH[c]).startPos != 1) {

				((Profiles) myParentBO.mullionObjectsH[c]).startPos = ((Profiles) myParentBO.mullionObjectsH[c]).startPos + 1;

			} else if (((Profiles) myParentBO.mullionObjectsH[c]).startPos <= newVCCol
					&& ((Profiles) myParentBO.mullionObjectsH[c]).startPos != 1) {

			}

		}
	}

	private void reOrderVMullions(final int alreadyExist) {

		if (alreadyExist == 1) {
			for (int vc = 0; vc < myParentBO.mullionObjectsV.length; vc++) {

				if (((Profiles) myParentBO.mullionObjectsV[vc]).rowCol >= newVCCol) {

					((Profiles) myParentBO.mullionObjectsV[vc]).rowCol = ((Profiles) myParentBO.mullionObjectsV[vc]).rowCol + 1;
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void reOrderVNotches() {

		myParentBO.mullionObjectsV = myParentBO.mullions.toArray();
		myParentBO.mullions.clear();

		myParentBO.mullionObjectsH = myParentBO.mullionsH.toArray();

		for (final Object mV : myParentBO.mullionObjectsV) {
			((Profiles) mV).notches.clear();
			for (final Object mH : myParentBO.mullionObjectsH) {
				if (((Profiles) mH).isValid) {
					if (((Profiles) mV).rowCol == ((Profiles) mH).endPos
							&& ((Profiles) mV).startPos <= ((Profiles) mH).rowCol
							&& ((Profiles) mV).endPos > ((Profiles) mH).rowCol) {
						if (((Profiles) mH).endTypeRB == 3) {
							if (myFrame2.jobItem.viewOut
									&& !myParentBO.myParent.glazedOut
									|| !myFrame2.jobItem.viewOut
									&& myParentBO.myParent.glazedOut) {
								notchVRB3VOGI((Profiles) mV, (Profiles) mH);
							} else if (!myFrame2.jobItem.viewOut
									&& myParentBO.myParent.glazedOut
									|| myFrame2.jobItem.viewOut
									&& !myParentBO.myParent.glazedOut) {
								notchVRB3VIGI((Profiles) mV, (Profiles) mH);
							}
						} else {
							final double notchx5 = this.intersectX(
									((Profiles) mH).x4al, ((Profiles) mH).y4al,
									((Profiles) mH).centerXe,
									((Profiles) mH).centerYe,
									((Profiles) mV).x1, ((Profiles) mV).y1,
									((Profiles) mV).x4, ((Profiles) mV).y4);
							final double notchy5 = this.intersectY(
									((Profiles) mH).x4al, ((Profiles) mH).y4al,
									((Profiles) mH).centerXe,
									((Profiles) mH).centerYe,
									((Profiles) mV).x1, ((Profiles) mV).y1,
									((Profiles) mV).x4, ((Profiles) mV).y4);
							final double notchx3 = this.intersectX(
									((Profiles) mH).x3cl, ((Profiles) mH).y3cl,
									((Profiles) mH).centerXe,
									((Profiles) mH).centerYe,
									((Profiles) mV).x1, ((Profiles) mV).y1,
									((Profiles) mV).x4, ((Profiles) mV).y4);
							final double notchy3 = this.intersectY(
									((Profiles) mH).x3cl, ((Profiles) mH).y3cl,
									((Profiles) mH).centerXe,
									((Profiles) mH).centerYe,
									((Profiles) mV).x1, ((Profiles) mV).y1,
									((Profiles) mV).x4, ((Profiles) mV).y4);

							((Profiles) mV).notches
									.add(this.addNotching(
											4,

											false,
											false,
											false,
											false,
											false,
											false,
											false,
											false,

											1, // orientation
											((Profiles) mH).rowCol,
											3, // left
											((Profiles) mH).endTypeRB,

											((Profiles) mH).x3cl,
											((Profiles) mH).y3cl,
											((Profiles) mH).x3,
											((Profiles) mH).y3, notchx3,
											notchy3, ((Profiles) mH).centerXe,
											((Profiles) mH).centerYe, notchx5,
											notchy5, ((Profiles) mH).x4,
											((Profiles) mH).y4,
											((Profiles) mH).x4al,
											((Profiles) mH).y4al));

						}
					} else if (((Profiles) mV).rowCol + 1 == ((Profiles) mH).startPos
							&& ((Profiles) mV).startPos <= ((Profiles) mH).rowCol
							&& ((Profiles) mV).endPos > ((Profiles) mH).rowCol) {

						if (((Profiles) mH).endTypeLT == 3) {
							if (myFrame2.jobItem.viewOut
									&& !myParentBO.myParent.glazedOut
									|| !myFrame2.jobItem.viewOut
									&& myParentBO.myParent.glazedOut) {
								notchVLT3VOGI((Profiles) mV, (Profiles) mH);
							} else if (!myFrame2.jobItem.viewOut
									&& myParentBO.myParent.glazedOut
									|| myFrame2.jobItem.viewOut
									&& !myParentBO.myParent.glazedOut) {
								notchVLT3VIGI((Profiles) mV, (Profiles) mH);
							}
						} else {
							final double notchx5 = this.intersectX(
									((Profiles) mH).x1al, ((Profiles) mH).y1al,
									((Profiles) mH).centerXs,
									((Profiles) mH).centerYs,
									((Profiles) mV).x2, ((Profiles) mV).y2,
									((Profiles) mV).x3, ((Profiles) mV).y3);
							final double notchy5 = this.intersectY(
									((Profiles) mH).x1al, ((Profiles) mH).y1al,
									((Profiles) mH).centerXs,
									((Profiles) mH).centerYs,
									((Profiles) mV).x2, ((Profiles) mV).y2,
									((Profiles) mV).x3, ((Profiles) mV).y3);
							final double notchx3 = this.intersectX(
									((Profiles) mH).x2cl, ((Profiles) mH).y2cl,
									((Profiles) mH).centerXs,
									((Profiles) mH).centerYs,
									((Profiles) mV).x2, ((Profiles) mV).y2,
									((Profiles) mV).x3, ((Profiles) mV).y3);
							final double notchy3 = this.intersectY(
									((Profiles) mH).x2cl, ((Profiles) mH).y2cl,
									((Profiles) mH).centerXs,
									((Profiles) mH).centerYs,
									((Profiles) mV).x2, ((Profiles) mV).y2,
									((Profiles) mV).x3, ((Profiles) mV).y3);

							((Profiles) mV).notches
									.add(this.addNotching(
											4,

											false,
											false,
											false,
											false,
											false,
											false,
											false,
											false,

											2, // orientation
											((Profiles) mH).rowCol,
											4, // bot
											((Profiles) mH).endTypeLT,

											((Profiles) mH).x1al,
											((Profiles) mH).y1al,
											((Profiles) mH).x1,
											((Profiles) mH).y1, notchx3,
											notchy3, ((Profiles) mH).centerXs,
											((Profiles) mH).centerYs, notchx5,
											notchy5, ((Profiles) mH).x2,
											((Profiles) mH).y2,
											((Profiles) mH).x2cl,
											((Profiles) mH).y2cl));

						}
					}
				}
			}
			myParentBO.mullions.add(mV);
		}
	}

	public void notchVLT3VIGI(final Profiles element, final Profiles elementH) {

		element.notches.add(this.addNotching(4,

		false, false, false, false, false, false, false, false,

				1, // Orientation
				elementH.rowCol,
				4, // right
				elementH.endTypeLT,

				this.intersectX(element.x2cl, element.y2cl, element.x3cl,
						element.y3cl, elementH.x2cl, elementH.y2cl,
						elementH.x3cl, elementH.y3cl), this.intersectY(
						element.x2cl, element.y2cl, element.x3cl, element.y3cl,
						elementH.x2cl, elementH.y2cl, elementH.x3cl,
						elementH.y3cl),

				this.intersectX(element.x2, element.y2, element.x3, element.y3,
						elementH.x2cl, elementH.y2cl, elementH.x3cl,
						elementH.y3cl), this.intersectY(element.x2, element.y2,
						element.x3, element.y3, elementH.x2, elementH.y2,
						elementH.x3, elementH.y3),

				this.intersectX(element.x2, element.y2, element.x3, element.y3,
						elementH.x2cl, elementH.y2cl, elementH.x3cl,
						elementH.y3cl), this.intersectY(element.x2, element.y2,
						element.x3, element.y3, elementH.x2, elementH.y2,
						elementH.x3, elementH.y3),

				this.intersectX(element.x2, element.y2, element.x3, element.y3,
						elementH.centerXs, elementH.centerYs,
						elementH.centerXe, elementH.centerYe), this.intersectY(
						element.x2, element.y2, element.x3, element.y3,
						elementH.centerXs, elementH.centerYs,
						elementH.centerXe, elementH.centerYe),

				this.intersectX(element.x2, element.y2, element.x3, element.y3,
						elementH.x1, elementH.y1, elementH.x4, elementH.y4),
				this.intersectY(element.x2, element.y2, element.x3, element.y3,
						elementH.x1, elementH.y1, elementH.x4, elementH.y4),

				this.intersectX(element.x2, element.y2, element.x3, element.y3,
						elementH.x1al, elementH.y1al, elementH.x4al,
						elementH.y4al), this.intersectY(element.x2, element.y2,
						element.x3, element.y3, elementH.x1al, elementH.y1al,
						elementH.x4al, elementH.y4al),

				this.intersectX(element.x2cl, element.y2cl, element.x3cl,
						element.y3cl, elementH.x1al, elementH.y1al,
						elementH.x4al, elementH.y4al), this.intersectY(
						element.x2cl, element.y2cl, element.x3cl, element.y3cl,
						elementH.x1al, elementH.y1al, elementH.x4al,
						elementH.y4al)));
	}

	public void notchVLT3VOGI(final Profiles element, final Profiles elementH) {

		element.notches.add(this.addNotching(4,

		false, false, false, false, false, false, false, false,

		1, // Orientation
				elementH.rowCol, 4, // right
				elementH.endTypeLT,

				this.intersectX(element.x2cl, element.y2cl, element.x3cl,
						element.y3cl, elementH.x2cl, elementH.y2cl,
						elementH.x3cl, elementH.y3cl), this.intersectY(
						element.x2cl, element.y2cl, element.x3cl, element.y3cl,
						elementH.x2cl, elementH.y2cl, elementH.x3cl,
						elementH.y3cl),

				this.intersectX(element.x2cl, element.y2cl, element.x3cl,
						element.y3cl, elementH.x2cl, elementH.y2cl,
						elementH.x3cl, elementH.y3cl), this.intersectY(
						element.x2cl, element.y2cl, element.x3cl, element.y3cl,
						elementH.x2, elementH.y2, elementH.x3, elementH.y3),

				this.intersectX(element.x2cl, element.y2cl, element.x3cl,
						element.y3cl, elementH.x2cl, elementH.y2cl,
						elementH.x3cl, elementH.y3cl), this.intersectY(
						element.x2cl, element.y2cl, element.x3cl, element.y3cl,
						elementH.x2, elementH.y2, elementH.x3, elementH.y3),

				this.intersectX(element.x2cl, element.y2cl, element.x3cl,
						element.y3cl, elementH.centerXs, elementH.centerYs,
						elementH.centerXe, elementH.centerYe), this.intersectY(
						element.x2cl, element.y2cl, element.x3cl, element.y3cl,
						elementH.centerXs, elementH.centerYs,
						elementH.centerXe, elementH.centerYe),

				this.intersectX(element.x2cl, element.y2cl, element.x3cl,
						element.y3cl, elementH.x1, elementH.y1, elementH.x4,
						elementH.y4), this.intersectY(element.x2cl,
						element.y2cl, element.x3cl, element.y3cl, elementH.x1,
						elementH.y1, elementH.x4, elementH.y4),

				this.intersectX(element.x2cl, element.y2cl, element.x3cl,
						element.y3cl, elementH.x1al, elementH.y1al,
						elementH.x4al, elementH.y4al), this.intersectY(
						element.x2cl, element.y2cl, element.x3cl, element.y3cl,
						elementH.x1al, elementH.y1al, elementH.x4al,
						elementH.y4al),

				this.intersectX(element.x2cl, element.y2cl, element.x3cl,
						element.y3cl, elementH.x1al, elementH.y1al,
						elementH.x4al, elementH.y4al), this.intersectY(
						element.x2cl, element.y2cl, element.x3cl, element.y3cl,
						elementH.x1al, elementH.y1al, elementH.x4al,
						elementH.y4al)));
	}

	public void notchVRB3VIGI(final Profiles element, final Profiles elementH) {

		element.notches.add(this.addNotching(4,

		false, false, false, false, false, false, false,
				false,

				1, // orientation
				elementH.rowCol,
				3, // left
				elementH.endTypeRB,

				this.intersectX(element.x1al, element.y1al, element.x4al,
						element.y4al, elementH.x2cl, elementH.y2cl,
						elementH.x3cl, elementH.y3cl), this.intersectY(
						element.x1al, element.y1al, element.x4al, element.y4al,
						elementH.x2cl, elementH.y2cl, elementH.x3cl,
						elementH.y3cl),

				this.intersectX(element.x1, element.y1, element.x4, element.y4,
						elementH.x2cl, elementH.y2cl, elementH.x3cl,
						elementH.y3cl), this.intersectY(element.x1, element.y1,
						element.x4, element.y4, elementH.x2cl, elementH.y2cl,
						elementH.x3cl, elementH.y3cl),

				this.intersectX(element.x1, element.y1, element.x4, element.y4,
						elementH.x2, elementH.y2, elementH.x3, elementH.y3),
				this.intersectY(element.x1, element.y1, element.x4, element.y4,
						elementH.x2, elementH.y2, elementH.x3, elementH.y3),

				this.intersectX(element.x1, element.y1, element.x4, element.y4,
						elementH.centerXs, elementH.centerYs,
						elementH.centerXe, elementH.centerYe), this.intersectY(
						element.x1, element.y1, element.x4, element.y4,
						elementH.centerXs, elementH.centerYs,
						elementH.centerXe, elementH.centerYe),

				this.intersectX(element.x1, element.y1, element.x4, element.y4,
						elementH.x1, elementH.y1, elementH.x4, elementH.y4),
				this.intersectY(element.x1, element.y1, element.x4, element.y4,
						elementH.x1, elementH.y1, elementH.x4, elementH.y4),

				this.intersectX(element.x1, element.y1, element.x4, element.y4,
						elementH.x1al, elementH.y1al, elementH.x4al,
						elementH.y4al), this.intersectY(element.x1, element.y1,
						element.x4, element.y4, elementH.x1al, elementH.y1al,
						elementH.x4al, elementH.y4al),

				this.intersectX(element.x1al, element.y1al, element.x4al,
						element.y4al, elementH.x1al, elementH.y1al,
						elementH.x4al, elementH.y4al), this.intersectY(
						element.x1al, element.y1al, element.x4al, element.y4al,
						elementH.x1al, elementH.y1al, elementH.x4al,
						elementH.y4al)

		));
	}

	public void notchVRB3VOGI(final Profiles element, final Profiles elementH) {

		element.notches.add(this.addNotching(4,

		false, false, false, false, false, false, false, false,

		1, // orientation
				elementH.rowCol, 3, // left
				elementH.endTypeRB,

				this.intersectX(element.x1al, element.y1al, element.x4al,
						element.y4al, elementH.x2cl, elementH.y2cl,
						elementH.x3cl, elementH.y3cl), this.intersectY(
						element.x1al, element.y1al, element.x4al, element.y4al,
						elementH.x2cl, elementH.y2cl, elementH.x3cl,
						elementH.y3cl),

				this.intersectX(element.x1al, element.y1al, element.x4al,
						element.y4al, elementH.x2cl, elementH.y2cl,
						elementH.x3cl, elementH.y3cl), this.intersectY(
						element.x1al, element.y1al, element.x4al, element.y4al,
						elementH.x2cl, elementH.y2cl, elementH.x3cl,
						elementH.y3cl),

				this.intersectX(element.x1al, element.y1al, element.x4al,
						element.y4al, elementH.x2, elementH.y2, elementH.x3,
						elementH.y3), this.intersectY(element.x1al,
						element.y1al, element.x4al, element.y4al, elementH.x2,
						elementH.y2, elementH.x3, elementH.y3),

				this.intersectX(element.x1al, element.y1al, element.x4al,
						element.y4al, elementH.centerXs, elementH.centerYs,
						elementH.centerXe, elementH.centerYe), this.intersectY(
						element.x1al, element.y1al, element.x4al, element.y4al,
						elementH.centerXs, elementH.centerYs,
						elementH.centerXe, elementH.centerYe),

				this.intersectX(element.x1al, element.y1al, element.x4al,
						element.y4al, elementH.x1, elementH.y1, elementH.x4,
						elementH.y4), this.intersectY(element.x1al,
						element.y1al, element.x4al, element.y4al, elementH.x1,
						elementH.y1, elementH.x4, elementH.y4),

				this.intersectX(element.x1al, element.y1al, element.x4al,
						element.y4al, elementH.x1al, elementH.y1al,
						elementH.x4al, elementH.y4al), this.intersectY(
						element.x1al, element.y1al, element.x4al, element.y4al,
						elementH.x1al, elementH.y1al, elementH.x4al,
						elementH.y4al),

				this.intersectX(element.x1al, element.y1al, element.x4al,
						element.y4al, elementH.x1al, elementH.y1al,
						elementH.x4al, elementH.y4al), this.intersectY(
						element.x1al, element.y1al, element.x4al, element.y4al,
						elementH.x1al, elementH.y1al, elementH.x4al,
						elementH.y4al)

		));
	}

	// Profiles
	public PartsNotching addNotching(

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
			final double y7) {

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
				pos, // // 1 =top, 2 bot, 3 L 4 R
				notchType, // 2 = Straight 1 = V
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

	public void getPoints(final Double arc1c) {

		final double flatness = 0.000000001f;
		final PathIterator pit = arc1c.getPathIterator(null, flatness);
		final double[] coords = new double[6];
		double myX = 0;
		double myY = 0;
		int count = 0;
		xCoordBc = new ArrayList();
		yCoordBc = new ArrayList();
		while (!pit.isDone()) {
			final int type = pit.currentSegment(coords);
			switch (type) {

			case PathIterator.SEG_MOVETO:
				myX = coords[0];
				myY = coords[1];
				xCoordBc.add(myX);
				yCoordBc.add(myY);
				count++;
				break;

			case PathIterator.SEG_LINETO:

				if (coords[0] > 0) {
					myX = coords[0];
					myY = coords[1];
					xCoordBc.add(myX);
					yCoordBc.add(myY);
				}
				count++;
				break;
			default:
				System.out.println("unexpected type: " + type);
			}

			pit.next();
		}

	}

	public double intersectX(final double x1, final double y1, final double x2,
			final double y2, final double bx1, final double by1,
			final double bx2, final double by2) {

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

	public double intersectY(final double x1, final double y1, final double x2,
			final double y2, final double bx1, final double by1,
			final double bx2, final double by2) {

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

	public Profiles getProfileDims(Profiles m) {

		if (myFrame2.mullionsPanel.getCouplerMullionController()
				.getPartsSelected() != null) {
			partID = myFrame2.mullionsPanel.getCouplerMullionController()
					.getPartsSelected().getId();

			if (myFrame2.mySeries.getSeriesUom() == 1) {

				partDimC = UOMConvert.getBigDecimalConversion(
						myFrame2.mullionsPanel.getCouplerMullionController()
								.getPartsSelected().getDimc(),
						myFrame2.metricscale, 1);

				partDimB = UOMConvert.getBigDecimalConversion(
						myFrame2.mullionsPanel.getCouplerMullionController()
								.getPartsSelected().getDimb(),
						myFrame2.metricscale, 1);

				partDimA = UOMConvert.getBigDecimalConversion(
						myFrame2.mullionsPanel.getCouplerMullionController()
								.getPartsSelected().getDima(),
						myFrame2.metricscale, 1);

				partDimD = UOMConvert.getBigDecimalConversion(
						myFrame2.mullionsPanel.getCouplerMullionController()
								.getPartsSelected().getDimd(),
						myFrame2.metricscale, 1);

				partDimBtoC = UOMConvert.getBigDecimalConversion(
						myFrame2.mullionsPanel.getCouplerMullionController()
								.getPartsSelected().getDimbtoc(),
						myFrame2.metricscale, 1);

				partDimM = UOMConvert.getBigDecimalConversion(
						myFrame2.mullionsPanel.getCouplerMullionController()
								.getPartsSelected().getDimm(),
						myFrame2.metricscale, 1);

			} else {

				partDimC = UOMConvert.getBigDecimalConversion(
						myFrame2.mullionsPanel.getCouplerMullionController()
								.getPartsSelected().getDimci(),
						myFrame2.imperialscale, 1);

				partDimB = UOMConvert.getBigDecimalConversion(
						myFrame2.mullionsPanel.getCouplerMullionController()
								.getPartsSelected().getDimbi(),
						myFrame2.imperialscale, 1);

				partDimA = UOMConvert.getBigDecimalConversion(
						myFrame2.mullionsPanel.getCouplerMullionController()
								.getPartsSelected().getDimai(),
						myFrame2.imperialscale, 1);

				partDimD = UOMConvert.getBigDecimalConversion(
						myFrame2.mullionsPanel.getCouplerMullionController()
								.getPartsSelected().getDimdi(),
						myFrame2.imperialscale, 1);

				partDimBtoC = UOMConvert.getBigDecimalConversion(
						myFrame2.mullionsPanel.getCouplerMullionController()
								.getPartsSelected().getDimbtoc_imp(),
						myFrame2.imperialscale, 1);

				partDimM = UOMConvert.getBigDecimalConversion(
						myFrame2.mullionsPanel.getCouplerMullionController()
								.getPartsSelected().getDimm_imp(),
						myFrame2.imperialscale, 1);

			}

			this.thickness = partDimB;

			if (m != null) {
				m = m.executePartRules(false);
				if (m.partID > 0) {
					this.thickness = m.partDimB;
					this.partDimC = m.partDimC;
					this.partDimA = m.partDimA;
					this.partDimB = m.partDimB;
					this.partDimD = m.partDimD;
					this.partDimBtoC = m.partDimBtoC;
					this.partDimM = m.partDimM;
				}
			}
		}

		this.continuity = this.myFrame2.mySeries.getContinuity();

		if (m != null) {

			if (m.a_assemblyLevel == 32 || m.a_assemblyLevel == 33
					|| m.a_assemblyLevel == 34 || m.a_assemblyLevel == 35
					|| m.a_assemblyLevel == 36 || m.a_assemblyLevel == 38
					|| m.a_assemblyLevel == 39) {

				Parts part = ItemFrame.getApplicationBase().getPart(partID);

				if (part != null && myFrame2.mySeries.getSeriesUom() == 1) {

					m.partDimC = this.partDimC = UOMConvert
							.getBigDecimalConversion(part.getDimc(),
									myFrame2.metricscale, 1);
					m.partDimB = this.partDimB = UOMConvert
							.getBigDecimalConversion(part.getDimb(),
									myFrame2.metricscale, 1);
					m.partDimA = this.partDimA = UOMConvert
							.getBigDecimalConversion(part.getDima(),
									myFrame2.metricscale, 1);
					m.partDimD = this.partDimD = UOMConvert
							.getBigDecimalConversion(part.getDimd(),
									myFrame2.metricscale, 1);
					m.partDimBtoC = this.partDimBtoC = UOMConvert
							.getBigDecimalConversion(part.getDimbtoc(),
									myFrame2.metricscale, 1);
					m.partDimM = this.partDimM = UOMConvert
							.getBigDecimalConversion(part.getDimm(),
									myFrame2.metricscale, 1);

				} else if (part != null) {

					m.partDimC = this.partDimC = UOMConvert
							.getBigDecimalConversion(part.getDimci(),
									myFrame2.imperialscale, 1);
					m.partDimB = this.partDimB = UOMConvert
							.getBigDecimalConversion(part.getDimbi(),
									myFrame2.imperialscale, 1);
					m.partDimA = this.partDimA = UOMConvert
							.getBigDecimalConversion(part.getDimai(),
									myFrame2.imperialscale, 1);
					m.partDimD = this.partDimD = UOMConvert
							.getBigDecimalConversion(part.getDimdi(),
									myFrame2.imperialscale, 1);
					m.partDimBtoC = this.partDimBtoC = UOMConvert
							.getBigDecimalConversion(part.getDimbtoc_imp(),
									myFrame2.imperialscale, 1);
					m.partDimM = this.partDimM = UOMConvert
							.getBigDecimalConversion(part.getDimm_imp(),
									myFrame2.imperialscale, 1);
				} else {
					m.partDimC = this.partDimC = 0;
					m.partDimB = this.partDimB = 0;
					m.partDimA = this.partDimA = 0;
					m.partDimD = this.partDimD = 0;
					m.partDimBtoC = this.partDimBtoC = 0;
					m.partDimM = this.partDimM = 0;
				}

				this.thickness = this.partDimB;
			}

		}

		return m;
	}

	public Profiles resetRecalcMullionBom(Profiles mullion) {

		mullion.length = Math.sqrt(Math.pow((Math.max(mullion.centerXe,
				mullion.centerXs) - Math
				.min(mullion.centerXe, mullion.centerXs)), 2)
				+ Math.pow((Math.max(mullion.centerYe, mullion.centerYs) - Math
						.min(mullion.centerYe, mullion.centerYs)), 2));

		mullion.lengthM = mullion.lengthMN = (int) (new BigDecimal(
				mullion.length).divide(myFrame2.metricscale, 10,
				BigDecimal.ROUND_UP)).doubleValue();

		mullion.lengthI = mullion.lengthIN = (int) (new BigDecimal(
				mullion.length).divide(myFrame2.imperialscale, 10,
				BigDecimal.ROUND_UP)).doubleValue();

		Parts myM = this.myFrame2.getApplicationBase().getPart(mullion.partID);

		if (myM != null) {

			mullion.partDimA = new BigDecimal(myM.getDima()).multiply(
					myFrame2.metricscale).doubleValue();
			mullion.partDimAi = new BigDecimal(myM.getDimai()).multiply(
					myFrame2.imperialscale).doubleValue();
			mullion.partDimB = new BigDecimal(myM.getDimb()).multiply(
					myFrame2.metricscale).doubleValue();
			mullion.partDimBi = new BigDecimal(myM.getDimbi()).multiply(
					myFrame2.metricscale).doubleValue();
			mullion.partDimC = new BigDecimal(myM.getDimc()).multiply(
					myFrame2.metricscale).doubleValue();
			mullion.partDimCi = new BigDecimal(myM.getDimci()).multiply(
					myFrame2.metricscale).doubleValue();
			mullion.partDimBtoC = new BigDecimal(myM.getDimbtoc()).multiply(
					myFrame2.metricscale).doubleValue();
			mullion.partDimBtoCi = new BigDecimal(myM.getDimbtoc_imp())
					.multiply(myFrame2.metricscale).doubleValue();
			mullion.partDimM = new BigDecimal(myM.getDimm()).multiply(
					myFrame2.metricscale).doubleValue();
			mullion.partDimMi = new BigDecimal(myM.getDimm_imp()).multiply(
					myFrame2.metricscale).doubleValue();
			mullion.partDimD = new BigDecimal(myM.getDimd()).multiply(
					myFrame2.metricscale).doubleValue();
			mullion.partDimDi = new BigDecimal(myM.getDimdi()).multiply(
					myFrame2.metricscale).doubleValue();
		}

		mullion.bom.clear();
		mullion.clearBomForProfile();

		// mullion.executePartRules(true);

		return mullion;
	}

}

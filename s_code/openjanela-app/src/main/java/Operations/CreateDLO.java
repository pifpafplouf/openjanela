/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Operations;


import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.util.ArrayList;
import java.util.Collection;

import Model.DLO;
import Model.OpeningObject;
import Model.ProfileParts.Bot1Object;
import Model.ProfileParts.Bot2Object;
import Model.ProfileParts.Bot3Object;
import Model.ProfileParts.LeftObject;
import Model.ProfileParts.Profiles;
import Model.ProfileParts.RightObject;
import Model.ProfileParts.Top1Object;
import Model.ProfileParts.Top2Object;
import Model.ProfileParts.Top3Object;
import Presentation.ItemFrame;


public class CreateDLO {
	
	public OpeningObject myParentFO;
	
	Collection xCoordB = new ArrayList();
	
	Collection yCoordB = new ArrayList();
	
	Object[] xCoordBo = null;
	
	Object[] yCoordBo = null;
	
	double myX = 0;
	
	double myY = 0;
	
	ItemFrame myFrame2;
	
	public CreateDLO(final OpeningObject frame, final ItemFrame myframe) {
		myParentFO = frame;
		myFrame2 = myframe;
	}
	
	public DLO doDLO() throws Exception {
		
		DLO myDLO = this.initSashLeaf(myParentFO.topIn, myParentFO.botIn, myParentFO.leftIn, myParentFO.rightIn);
		
		
		myDLO.top1Part.endTypeLTByUser = false;
		myDLO.top2Part.endTypeLTByUser = false;
		myDLO.top3Part.endTypeLTByUser = false;
		myDLO.bot1Part.endTypeLTByUser = false;
		myDLO.bot2Part.endTypeLTByUser = false;
		myDLO.bot3Part.endTypeLTByUser = false;
		myDLO.leftPart.endTypeLTByUser = false;
		myDLO.rightPart.endTypeLTByUser = false;
		
		myDLO.top1Part.endTypeRBByUser = false;
		myDLO.top2Part.endTypeRBByUser = false;
		myDLO.top3Part.endTypeRBByUser = false;
		myDLO.bot1Part.endTypeRBByUser = false;
		myDLO.bot2Part.endTypeRBByUser = false;
		myDLO.bot3Part.endTypeRBByUser = false;
		myDLO.leftPart.endTypeRBByUser = false;
		myDLO.rightPart.endTypeRBByUser = false;

        setPartBA_A(myDLO);
		
		myDLO.widthPix = Math.max(myDLO.bX2, myDLO.bX3) - Math.min(myDLO.startingX, myDLO.bX4);
		
		myDLO.widthMN = myParentFO.widthMN;
		myDLO.widthIN = myParentFO.widthIN;
		
		myDLO.heightMN = myParentFO.heightMN;
		myDLO.heightIN = myParentFO.heightIN;
		
		myDLO.bOpeningObject = myDLO.doMainOpening();
		
		
//		myDLO.options.clear();
//		myDLO.executeOptionRules("createDLO.doDLO.91");
		
		myDLO.bom.clear();
		myDLO.clearBomForShape();
		myDLO.executePartRules(true, true, "createDLO.doDLO.95");
		myDLO.shapeChanged = false;
		return myDLO;
		
	}
	
	public void setPartBA_A(DLO myDLO) {
		
		myDLO.top1Part.startingXBA = myDLO.top1Part.startingXA;
		myDLO.top1Part.startXBA = myDLO.top1Part.startXA;
		myDLO.top1Part.endXBA = myDLO.top1Part.endXA;
		
		myDLO.top1Part.startingYBA = myDLO.top1Part.startingYA;
		myDLO.top1Part.startYBA = myDLO.top1Part.startYA;
		myDLO.top1Part.endYBA = myDLO.top1Part.endYA;
		
		
		myDLO.top2Part.startingXBA = myDLO.top2Part.startingXA;
		myDLO.top2Part.startXBA = myDLO.top2Part.startXA;
		myDLO.top2Part.endXBA = myDLO.top2Part.endXA;
		
		myDLO.top2Part.startingYBA = myDLO.top2Part.startingYA;
		myDLO.top2Part.startYBA = myDLO.top2Part.startYA;
		myDLO.top2Part.endYBA = myDLO.top2Part.endYA;
		
		myDLO.top3Part.startingXBA = myDLO.top3Part.startingXA;
		myDLO.top3Part.startXBA = myDLO.top3Part.startXA;
		myDLO.top3Part.endXBA = myDLO.top3Part.endXA;
		
		myDLO.top3Part.startingYBA = myDLO.top3Part.startingYA;
		myDLO.top3Part.startYBA = myDLO.top3Part.startYA;
		myDLO.top3Part.endYBA = myDLO.top3Part.endYA;
		
		myDLO.bot1Part.startingXBA = myDLO.bot1Part.startingXA;
		myDLO.bot1Part.startXBA = myDLO.bot1Part.startXA;
		myDLO.bot1Part.endXBA = myDLO.bot1Part.endXA;
		
		myDLO.bot1Part.startingYBA = myDLO.bot1Part.startingYA;
		myDLO.bot1Part.startYBA = myDLO.bot1Part.startYA;
		myDLO.bot1Part.endYBA = myDLO.bot1Part.endYA;
		
		myDLO.bot2Part.startingXBA = myDLO.bot2Part.startingXA;
		myDLO.bot2Part.startXBA = myDLO.bot2Part.startXA;
		myDLO.bot2Part.endXBA = myDLO.bot2Part.endXA;
		
		myDLO.bot2Part.startingYBA = myDLO.bot2Part.startingYA;
		myDLO.bot2Part.startYBA = myDLO.bot2Part.startYA;
		myDLO.bot2Part.endYBA = myDLO.bot2Part.endYA;
		
		
		
		myDLO.bot3Part.startingXBA = myDLO.bot3Part.startingXA;
		myDLO.bot3Part.startXBA = myDLO.bot3Part.startXA;
		myDLO.bot3Part.endXBA = myDLO.bot3Part.endXA;
		
		myDLO.bot3Part.startingYBA = myDLO.bot3Part.startingYA;
		myDLO.bot3Part.startYBA = myDLO.bot3Part.startYA;
		myDLO.bot3Part.endYBA = myDLO.bot3Part.endYA;
		
		
		myDLO.leftPart.startingXBA = myDLO.leftPart.startingXA;
		myDLO.leftPart.startXBA = myDLO.leftPart.startXA;
		myDLO.leftPart.endXBA = myDLO.leftPart.endXA;
		
		myDLO.leftPart.startingYBA = myDLO.leftPart.startingYA;
		myDLO.leftPart.startYBA = myDLO.leftPart.startYA;
		myDLO.leftPart.endYBA = myDLO.leftPart.endYA;
		
		
		myDLO.rightPart.startingXBA = myDLO.rightPart.startingXA;
		myDLO.rightPart.startXBA = myDLO.rightPart.startXA;
		myDLO.rightPart.endXBA = myDLO.rightPart.endXA;
		
		myDLO.rightPart.startingYBA = myDLO.rightPart.startingYA;
		myDLO.rightPart.startYBA = myDLO.rightPart.startYA;
		myDLO.rightPart.endYBA = myDLO.rightPart.endYA;
	}
	
	public GeneralPath doGeneralPathGlass(final Profiles part) {
		
		final GeneralPath myOpen = new GeneralPath();
		
		myOpen.moveTo((int) part.startXC, (int) part.startYC);
		
		if (part.partForm == 2) {
			final Arc2D mytopb =
						new Arc2D.Double(
									part.bkgrdStartXBA,
									part.bkgrdStartYBA,
									part.bkgrdWidthBA,
									part.bkgrdHeightBA,
									part.startAngleBA,
									part.endAngleBA,
									Arc2D.OPEN);
			
			xCoordB = new ArrayList();
			yCoordB = new ArrayList();
			this.getPoints(mytopb, 1, part.startXC);
			
			xCoordBo = xCoordB.toArray();
			yCoordBo = yCoordB.toArray();
			
			myOpen.moveTo((int) part.startXC, (int) part.startYC);
			
			for (int i = xCoordBo.length; i >= 1; i--) {
				if ((Double) xCoordBo[i - 1] >= 0) {
					myOpen.lineTo(
								((Double) xCoordBo[i - 1]),
								((Double) yCoordBo[i - 1]));
				}
			}
			
		} else {
			myOpen.lineTo((int) part.endXC, (int) part.endYC);
			
		}
		myOpen.lineTo((int) part.endXA, (int) part.endYA);
		
		if (part.partForm == 2) {
			
			final Arc2D mytopa =
						new Arc2D.Double(
									part.bkgrdStartXA,
									part.bkgrdStartYA,
									part.bkgrdWidthA,
									part.bkgrdHeightA,
									part.startAngleA,
									part.endAngleA,
									Arc2D.OPEN);
			xCoordB = new ArrayList();
			yCoordB = new ArrayList();
			this.getPoints(mytopa, 1, part.startXA);
			
			xCoordBo = xCoordB.toArray();
			yCoordBo = yCoordB.toArray();
			
			// myOpen.moveTo((int) part.startXA,
			// (int)
			// part.startYA);
			
			for (int i = 0; i < xCoordBo.length; i++) {
				// if ((Double) xCoordBo[i +
				// 1] >= 0)
				// {
				myOpen.lineTo(
							((Double) xCoordBo[i]),
							((Double) yCoordBo[i]));
				// }
			}
			
			// myOpen.moveTo((int) part.startXA,
			// (int)
			// part.startYA);
		} else {
			myOpen.lineTo((int) part.startXA, (int) part.startYA);
		}
		
		myOpen.lineTo((int) part.startXC, (int) part.startYC);
		
		return myOpen;
		
	}
	
	public void getPoints(final Arc2D arc, final int topBot, final double startX) {
		
		final double flatness = 0.0000001f;
		final PathIterator pit = arc.getPathIterator(null, flatness);
		final double[] coords = new double[6];
		int count = 0;
		
		while (!pit.isDone()) {
			final int type = pit.currentSegment(coords);
			switch (type) {
			
			case PathIterator.SEG_MOVETO:
				myX = coords[0];
				myY = coords[1];
				xCoordB.add(myX);
				yCoordB.add(myY);
				count++;
				break;
				
			case PathIterator.SEG_LINETO:
				if (coords[0] > 0) {
					myX = coords[0];
					myY = coords[1];
					if (topBot == 1) {
						if (myX >= startX) {
							
							xCoordB.add(myX);
							yCoordB.add(myY);
						}
					} else {
						if (myX <= startX) {
							
							xCoordB.add(myX);
							yCoordB.add(myY);
						}
					}
				}
				count++;
				break;
			default:
				System.out.println("unexpected type: " + type);
			}
			pit.next();
		}
	}
	
	public DLO initSashLeaf(boolean topIn, boolean botIn, boolean leftIn, boolean rightIn) {
		
		DLO myDLO = new DLO(myFrame2);
		
		myDLO = (DLO) myDLO.cloneShapeFromParentOpening(this.myParentFO);
		
		myDLO.options.clear();
		myDLO.executeOptionRules("createDLO.initSashLeaf.315");

		Object[] clearances = this.myFrame2.executePartRules.executeClearanceRules(myDLO, null, null);
		
		if (myFrame2.mySeries.getSeriesUom() == 1)
		{
			myDLO.clearanceTop = ((Integer) clearances[0] / 100) * myFrame2.scale.doubleValue();
			myDLO.clearanceBot = ((Integer) clearances[2] / 100) * myFrame2.scale.doubleValue();
			myDLO.clearanceLeft = ((Integer) clearances[4] / 100) * myFrame2.scale.doubleValue();
			myDLO.clearanceRight = ((Integer) clearances[6] / 100) * myFrame2.scale.doubleValue();
			
		}
		else
		{
			myDLO.clearanceTop = ((Integer) clearances[1] / 64) * myFrame2.scale.doubleValue();
			myDLO.clearanceBot = ((Integer) clearances[3] / 64) * myFrame2.scale.doubleValue();
			myDLO.clearanceLeft = ((Integer) clearances[5] / 64) * myFrame2.scale.doubleValue();
			myDLO.clearanceRight = ((Integer) clearances[7] / 64) * myFrame2.scale.doubleValue();
		}
		
		
		return myDLO;
	}
	
	public DLO initSashParts(DLO mySashLeaf) {
		
		// Get Sash Clearance and Dims
		
		mySashLeaf.top1Part = new Profiles();
		mySashLeaf.top2Part = new Profiles();
		mySashLeaf.top3Part = new Profiles();
		mySashLeaf.rightPart = new Profiles();
		mySashLeaf.leftPart = new Profiles();
		mySashLeaf.bot1Part = new Profiles();
		mySashLeaf.bot2Part = new Profiles();
		mySashLeaf.bot3Part = new Profiles();
		
		mySashLeaf.top1 = new Top1Object();
		mySashLeaf.top2 = new Top2Object();
		mySashLeaf.top3 = new Top3Object();
		mySashLeaf.right = new RightObject();
		mySashLeaf.left = new LeftObject();
		mySashLeaf.bot1 = new Bot1Object();
		mySashLeaf.bot2 = new Bot2Object();
		mySashLeaf.bot3 = new Bot3Object();
		
		mySashLeaf = this.setPartforms(mySashLeaf);
		
		return mySashLeaf;
		
	}
	
	public DLO setPartforms(DLO mySashLeaf) {
		
		mySashLeaf.top1Part.partForm = myParentFO.top1Part.partForm;
		mySashLeaf.top1Part.partForm = myParentFO.top1Part.partForm;
		mySashLeaf.top2Part.partForm = myParentFO.top2Part.partForm;
		mySashLeaf.top2Part.partForm = myParentFO.top2Part.partForm;
		mySashLeaf.top3Part.partForm = myParentFO.top3Part.partForm;
		mySashLeaf.top3Part.partForm = myParentFO.top3Part.partForm;
		mySashLeaf.bot1Part.partForm = myParentFO.bot1Part.partForm;
		mySashLeaf.bot1Part.partForm = myParentFO.bot1Part.partForm;
		mySashLeaf.bot2Part.partForm = myParentFO.bot2Part.partForm;
		mySashLeaf.bot2Part.partForm = myParentFO.bot2Part.partForm;
		mySashLeaf.bot3Part.partForm = myParentFO.bot3Part.partForm;
		mySashLeaf.bot3Part.partForm = myParentFO.bot3Part.partForm;
		mySashLeaf.leftPart.partForm = myParentFO.leftPart.partForm;
		mySashLeaf.leftPart.partForm = myParentFO.leftPart.partForm;
		mySashLeaf.rightPart.partForm = myParentFO.rightPart.partForm;
		mySashLeaf.rightPart.partForm = myParentFO.rightPart.partForm;
		
		mySashLeaf = this.doPartPos(mySashLeaf);
		return mySashLeaf;
	}
	
	public DLO doPartPos(final DLO mySashLeaf) {
		
		mySashLeaf.top1Part.posInUse = true;
		mySashLeaf.bot1Part.posInUse = true;
		mySashLeaf.leftPart.posInUse = true;
		mySashLeaf.rightPart.posInUse = true;
		
		mySashLeaf.top2Part.posInUse = true;
		mySashLeaf.top3Part.posInUse = true;
		mySashLeaf.bot2Part.posInUse = true;
		mySashLeaf.bot3Part.posInUse = true;
		if (!myParentFO.top1Part.posInUse) {
			mySashLeaf.top1Part = new Profiles();
			mySashLeaf.top1Part.posInUse = false;
		}
		if (!myParentFO.top2Part.posInUse) {
			mySashLeaf.top2Part = new Profiles();
			mySashLeaf.top2Part.posInUse = false;
		}
		if (!myParentFO.top3Part.posInUse) {
			mySashLeaf.top3Part = new Profiles();
			mySashLeaf.top3Part.posInUse = false;
		}
		if (!myParentFO.bot1Part.posInUse) {
			mySashLeaf.bot1Part = new Profiles();
			mySashLeaf.bot1Part.posInUse = false;
		}
		if (!myParentFO.bot2Part.posInUse) {
			mySashLeaf.bot2Part = new Profiles();
			mySashLeaf.bot2Part.posInUse = false;
		}
		if (!myParentFO.bot3Part.posInUse) {
			mySashLeaf.bot3Part = new Profiles();
			mySashLeaf.bot3Part.posInUse = false;
		}
		if (!myParentFO.leftPart.posInUse) {
			mySashLeaf.leftPart = new Profiles();
			mySashLeaf.leftPart.posInUse = false;
		}
		if (!myParentFO.rightPart.posInUse) {
			mySashLeaf.rightPart = new Profiles();
			mySashLeaf.rightPart.posInUse = false;
		}
		
		return mySashLeaf;
	}
	
	public Object[] setPartDims(DLO mySashLeaf, CreateShapeMethods createShape) {
		
		
		Object[] myreturns = new Object[2];
		mySashLeaf.top1Part.profileSelected = 0;
		mySashLeaf.top2Part.profileSelected = 0;
		mySashLeaf.top3Part.profileSelected = 0;
		mySashLeaf.bot1Part.profileSelected = 0;
		mySashLeaf.bot2Part.profileSelected = 0;
		mySashLeaf.bot3Part.profileSelected = 0;
		mySashLeaf.leftPart.profileSelected = 0;
		mySashLeaf.rightPart.profileSelected = 0;
		
//		mySashLeaf.executePartRules(false, false, "createDLO.setpartDims.450");
		mySashLeaf.executePartRules(false);
		
		if (myFrame2.mySeries.getSeriesUom() == 1)
		{
			createShape.top1DimBo = createShape.top1DimB = mySashLeaf.top1Part.partDimBi = mySashLeaf.top1Part.partDimB;
			createShape.top1DimAo = createShape.top1DimA = mySashLeaf.top1Part.partDimAi = mySashLeaf.top1Part.partDimA;
			createShape.top1DimCo = createShape.top1DimC = mySashLeaf.top1Part.partDimCi = mySashLeaf.top1Part.partDimC;
			createShape.top1DimMo = createShape.top1DimM = mySashLeaf.top1Part.partDimMi = mySashLeaf.top1Part.partDimM;
			createShape.top2DimBo = createShape.top2DimB = mySashLeaf.top2Part.partDimBi = mySashLeaf.top2Part.partDimB;
			createShape.top2DimAo = createShape.top2DimA = mySashLeaf.top2Part.partDimAi = mySashLeaf.top2Part.partDimA;
			createShape.top2DimCo = createShape.top2DimC = mySashLeaf.top3Part.partDimCi = mySashLeaf.top2Part.partDimC;
			createShape.top2DimMo = createShape.top2DimM = mySashLeaf.top3Part.partDimMi = mySashLeaf.top2Part.partDimM;
			createShape.top3DimBo = createShape.top3DimB = mySashLeaf.top3Part.partDimBi = mySashLeaf.top3Part.partDimB;
			createShape.top3DimAo = createShape.top3DimA = mySashLeaf.top3Part.partDimAi = mySashLeaf.top3Part.partDimA;
			createShape.top3DimCo = createShape.top3DimC = mySashLeaf.top3Part.partDimCi = mySashLeaf.top3Part.partDimC;
			createShape.top3DimMo = createShape.top3DimM = mySashLeaf.top3Part.partDimMi = mySashLeaf.top3Part.partDimM;
			
			createShape.bot1DimBo = createShape.bot1DimB = mySashLeaf.bot1Part.partDimBi = mySashLeaf.bot1Part.partDimB;
			createShape.bot1DimAo = createShape.bot1DimA = mySashLeaf.bot1Part.partDimAi = mySashLeaf.bot1Part.partDimA;
			createShape.bot1DimCo = createShape.bot1DimC = mySashLeaf.bot1Part.partDimCi = mySashLeaf.bot1Part.partDimC;
			createShape.bot1DimMo = createShape.bot1DimM = mySashLeaf.bot1Part.partDimMi = mySashLeaf.bot1Part.partDimM;
			createShape.bot2DimBo = createShape.bot2DimB = mySashLeaf.bot2Part.partDimBi = mySashLeaf.bot2Part.partDimB;
			createShape.bot2DimAo = createShape.bot2DimA = mySashLeaf.bot2Part.partDimAi = mySashLeaf.bot2Part.partDimA;
			createShape.bot2DimCo = createShape.bot2DimC = mySashLeaf.bot2Part.partDimCi = mySashLeaf.bot2Part.partDimC;
			createShape.bot2DimMo = createShape.bot2DimM = mySashLeaf.bot2Part.partDimMi = mySashLeaf.bot2Part.partDimM;
			createShape.bot3DimBo = createShape.bot3DimB = mySashLeaf.bot3Part.partDimBi = mySashLeaf.bot3Part.partDimB;
			createShape.bot3DimAo = createShape.bot3DimA = mySashLeaf.bot3Part.partDimAi = mySashLeaf.bot3Part.partDimA;
			createShape.bot3DimCo = createShape.bot3DimC = mySashLeaf.bot3Part.partDimCi = mySashLeaf.bot3Part.partDimC;
			createShape.bot3DimMo = createShape.bot3DimM = mySashLeaf.bot3Part.partDimMi = mySashLeaf.bot3Part.partDimM;
			
			createShape.leftDimBo = createShape.leftDimB = mySashLeaf.leftPart.partDimBi = mySashLeaf.leftPart.partDimB;
			createShape.leftDimAo = createShape.leftDimA = mySashLeaf.leftPart.partDimAi = mySashLeaf.leftPart.partDimA;
			createShape.leftDimCo = createShape.leftDimC = mySashLeaf.leftPart.partDimCi = mySashLeaf.leftPart.partDimC;
			createShape.leftDimMo = createShape.leftDimM = mySashLeaf.leftPart.partDimMi = mySashLeaf.leftPart.partDimM;
			createShape.rightDimBo = createShape.rightDimB = mySashLeaf.rightPart.partDimBi = mySashLeaf.rightPart.partDimB;
			createShape.rightDimAo = createShape.rightDimA = mySashLeaf.rightPart.partDimAi = mySashLeaf.rightPart.partDimA;
			createShape.rightDimCo = createShape.rightDimC = mySashLeaf.rightPart.partDimCi = mySashLeaf.rightPart.partDimC;
			createShape.rightDimMo = createShape.rightDimM = mySashLeaf.rightPart.partDimMi = mySashLeaf.rightPart.partDimM;
		}
		else
		{
			createShape.top1DimBo = createShape.top1DimB = mySashLeaf.top1Part.partDimB = mySashLeaf.top1Part.partDimBi;
			createShape.top1DimAo = createShape.top1DimA = mySashLeaf.top1Part.partDimA = mySashLeaf.top1Part.partDimAi;
			createShape.top1DimCo = createShape.top1DimC = mySashLeaf.top1Part.partDimC = mySashLeaf.top1Part.partDimCi;
			createShape.top1DimMo = createShape.top1DimM = mySashLeaf.top1Part.partDimM = mySashLeaf.top1Part.partDimMi;
			createShape.top2DimBo = createShape.top2DimB = mySashLeaf.top2Part.partDimB = mySashLeaf.top2Part.partDimBi;
			createShape.top2DimAo = createShape.top2DimA = mySashLeaf.top2Part.partDimA = mySashLeaf.top2Part.partDimAi;
			createShape.top2DimCo = createShape.top2DimC = mySashLeaf.top3Part.partDimC = mySashLeaf.top2Part.partDimCi;
			createShape.top2DimMo = createShape.top2DimM = mySashLeaf.top3Part.partDimM = mySashLeaf.top2Part.partDimMi;
			createShape.top3DimBo = createShape.top3DimB = mySashLeaf.top3Part.partDimB = mySashLeaf.top3Part.partDimBi;
			createShape.top3DimAo = createShape.top3DimA = mySashLeaf.top3Part.partDimA = mySashLeaf.top3Part.partDimAi;
			createShape.top3DimCo = createShape.top3DimC = mySashLeaf.top3Part.partDimC = mySashLeaf.top3Part.partDimCi;
			createShape.top3DimMo = createShape.top3DimM = mySashLeaf.top3Part.partDimM = mySashLeaf.top3Part.partDimMi;
			
			createShape.bot1DimBo = createShape.bot1DimB = mySashLeaf.bot1Part.partDimB = mySashLeaf.bot1Part.partDimBi;
			createShape.bot1DimAo = createShape.bot1DimA = mySashLeaf.bot1Part.partDimA = mySashLeaf.bot1Part.partDimAi;
			createShape.bot1DimCo = createShape.bot1DimC = mySashLeaf.bot1Part.partDimC = mySashLeaf.bot1Part.partDimCi;
			createShape.bot1DimMo = createShape.bot1DimM = mySashLeaf.bot1Part.partDimM = mySashLeaf.bot1Part.partDimMi;
			createShape.bot2DimBo = createShape.bot2DimB = mySashLeaf.bot2Part.partDimB = mySashLeaf.bot2Part.partDimBi;
			createShape.bot2DimAo = createShape.bot2DimA = mySashLeaf.bot2Part.partDimA = mySashLeaf.bot2Part.partDimAi;
			createShape.bot2DimCo = createShape.bot2DimC = mySashLeaf.bot2Part.partDimC = mySashLeaf.bot2Part.partDimCi;
			createShape.bot2DimMo = createShape.bot2DimM = mySashLeaf.bot2Part.partDimM = mySashLeaf.bot2Part.partDimMi;
			createShape.bot3DimBo = createShape.bot3DimB = mySashLeaf.bot3Part.partDimB = mySashLeaf.bot3Part.partDimBi;
			createShape.bot3DimAo = createShape.bot3DimA = mySashLeaf.bot3Part.partDimA = mySashLeaf.bot3Part.partDimAi;
			createShape.bot3DimCo = createShape.bot3DimC = mySashLeaf.bot3Part.partDimC = mySashLeaf.bot3Part.partDimCi;
			createShape.bot3DimMo = createShape.bot3DimM = mySashLeaf.bot3Part.partDimM = mySashLeaf.bot3Part.partDimMi;
			
			createShape.leftDimBo = createShape.leftDimB = mySashLeaf.leftPart.partDimB = mySashLeaf.leftPart.partDimBi;
			createShape.leftDimAo = createShape.leftDimA = mySashLeaf.leftPart.partDimA = mySashLeaf.leftPart.partDimAi;
			createShape.leftDimCo = createShape.leftDimC = mySashLeaf.leftPart.partDimC = mySashLeaf.leftPart.partDimCi;
			createShape.leftDimMo = createShape.leftDimM = mySashLeaf.leftPart.partDimM = mySashLeaf.leftPart.partDimMi;
			createShape.rightDimBo = createShape.rightDimB = mySashLeaf.rightPart.partDimB = mySashLeaf.rightPart.partDimBi;
			createShape.rightDimAo = createShape.rightDimA = mySashLeaf.rightPart.partDimA = mySashLeaf.rightPart.partDimAi;
			createShape.rightDimCo = createShape.rightDimC = mySashLeaf.rightPart.partDimC = mySashLeaf.rightPart.partDimCi;
			createShape.rightDimMo = createShape.rightDimM = mySashLeaf.rightPart.partDimM = mySashLeaf.rightPart.partDimMi;
		}
		myreturns[0] = mySashLeaf;
		myreturns[1] = createShape;

		return myreturns;
	}

}

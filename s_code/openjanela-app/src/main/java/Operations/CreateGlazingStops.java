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

import openjanela.model.entities.partner.SUType;
import Model.GlazingBeads;
import Model.OpeningObject;
import Model.ShapeObject;
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


public class CreateGlazingStops {
	
	public OpeningObject myParentFO;
	
	// public double spacerThick = 0;
	
	Collection xCoordB = new ArrayList();
	
	Collection yCoordB = new ArrayList();
	
	Object[] xCoordBo = null;
	
	Object[] yCoordBo = null;
	
	double myX = 0;
	
	double myY = 0;
	
	double scale = 0;
	
	ItemFrame myFrame2 = null;
	
	/**
	 * Constructor Glazing Stops
	 * @param op, OpeningObject
	 * @param frame, ItemFrame
	 */
	public CreateGlazingStops(OpeningObject op, ItemFrame frame) {
		
		myParentFO = op;
		myFrame2 = frame;
		scale = myFrame2.scale.doubleValue();
		
	}
	
	/**
	 * Do Beads
	 * @return GlazingBeads
	 */
	public GlazingBeads doBeads(SUType suType) throws Exception {
		
		GlazingBeads myBeads = new GlazingBeads();
		
		setInitValues(suType, myBeads);
		
		myBeads = this.initSashLeaf(myBeads, myParentFO.topIn, myParentFO.botIn, myParentFO.leftIn, myParentFO.rightIn);
		
		/*
		 * Reset Values again in case changed due to Clone Parent Opening
		 */
		
		 setInitValues(suType, myBeads);
		

        if (myParentFO.contentMid == 1) {

         
            CreateShapeMethods createShape = new CreateShapeMethods(myParentFO, 2, myFrame2);

            Object[] returns = this.setPartDims(myBeads, createShape);

            myBeads = (GlazingBeads) returns[0];

            createShape = (CreateShapeMethods) returns[1];

            if (!myParentFO.top2Part.posInUse) {
                myBeads.top2Part = (Profiles) myBeads.top2Part.cloneProfile(myBeads.top1Part);
                myBeads.top2Part.posInUse = false;
                myBeads.top2Part.lengthM = 0;
                myBeads.top2Part.lengthI = 0;
                myBeads.top2 = (Top2Object) myBeads.top2.cloneProfile(myBeads.top2Part);

                myBeads.top2.posInUse = false;
            }

            changeGBEndType(myBeads);

            createShape.getClearance(myBeads);

            myBeads = (GlazingBeads) createShape.doShapeBkgrd(myBeads);
            myBeads = (GlazingBeads) createShape.makeSides(myBeads);
            myBeads = (GlazingBeads) createShape.makeSidesStraight(myBeads);
            myBeads = (GlazingBeads) createShape.doParts(myBeads, true);

            if (myBeads.noSides == 2) {
                myBeads.top1Part.endTypeLT = 1;
                myBeads.top1Part.endTypeRB = 1;
                myBeads.bot1Part.endTypeLT = 1;
                myBeads.bot1Part.endTypeRB = 1;
            }

            myBeads = (GlazingBeads) createShape.setBaseInfo(myBeads, 1, true);

            myBeads.top1Part.myParent = myParentFO.myParent;
            myBeads.top2Part.myParent = myParentFO.myParent;
            myBeads.top3Part.myParent = myParentFO.myParent;
            myBeads.bot1Part.myParent = myParentFO.myParent;
            myBeads.bot2Part.myParent = myParentFO.myParent;
            myBeads.bot3Part.myParent = myParentFO.myParent;
            myBeads.leftPart.myParent = myParentFO.myParent;
            myBeads.rightPart.myParent = myParentFO.myParent;

            myBeads.top1 = (Top1Object) myBeads.top1.cloneProfile(myBeads.top1Part);
            myBeads.top2 = (Top2Object) myBeads.top2.cloneProfile(myBeads.top2Part);
            myBeads.top3 = (Top3Object) myBeads.top3.cloneProfile(myBeads.top3Part);

            myBeads.bot1 = (Bot1Object) myBeads.bot1.cloneProfile(myBeads.bot1Part);
            myBeads.bot2 = (Bot2Object) myBeads.bot2.cloneProfile(myBeads.bot2Part);
            myBeads.bot3 = (Bot3Object) myBeads.bot3.cloneProfile(myBeads.bot3Part);

            myBeads.left = (LeftObject) myBeads.left.cloneProfile(myBeads.leftPart);
            myBeads.right = (RightObject) myBeads.right.cloneProfile(myBeads.rightPart);

            myBeads.glazedOut = myParentFO.glazedOut;

            myBeads.partObjects = createShape.setPartObjectsAndCollection(myBeads);

            myBeads.partObjects = createShape.doGPParts(myBeads.partObjects, myBeads, myBeads.glazedOut);

            myBeads.highestY = myParentFO.highestY;
            myBeads.lowestY = myParentFO.lowestY;

            myBeads.widthMN = myParentFO.widthMN;
            myBeads.widthIN = myParentFO.widthIN;

            myBeads.heightMN = myParentFO.heightMN;
            myBeads.heightIN = myParentFO.heightIN;

            myBeads.options.clear();
            myBeads.executeOptionRules("createBeads.doBeads.188");

            myBeads.bom.clear();
            myBeads.clearBomForShape();

            myBeads.executePartRules(true, true, "createBeads.dobreads.192");

            myBeads.doMainOpening();

            myBeads.openings.clear();
            Object[] myopens = myBeads.openings.toArray();

            for (final Object o : myopens) {
                myBeads.myDLO = (OpeningObject) o;
            }

            createShape = null;

        } else {
            myBeads.bom.clear();
            myBeads.clearBomForShape();
        }

        myBeads.shapeChanged = false;
       
        return myBeads;

    }

	private void setInitValues(SUType suType, GlazingBeads myBeads) {
		myBeads.myFrame2 = myFrame2;
		 ((ShapeObject) myBeads).myFrame2 = myFrame2;
		 
		myBeads.trackNo = myParentFO.trackNo;
		myBeads.leafNo = myParentFO.leafNo;
		myBeads.suFamily = suType.getFamilyId();
        myBeads.suTypeID = suType.getId();
        myBeads.suThick_i = suType.getThicknessImp();
        myBeads.suThick_m = suType.getThickness();
		
		myBeads.top1Part.endTypeLTByUser = false;
		myBeads.top2Part.endTypeLTByUser = false;
		myBeads.top3Part.endTypeLTByUser = false;
		myBeads.bot1Part.endTypeLTByUser = false;
		myBeads.bot2Part.endTypeLTByUser = false;
		myBeads.bot3Part.endTypeLTByUser = false;
		myBeads.leftPart.endTypeLTByUser = false;
		myBeads.rightPart.endTypeLTByUser = false;
		
		myBeads.top1Part.endTypeRBByUser = false;
		myBeads.top2Part.endTypeRBByUser = false;
		myBeads.top3Part.endTypeRBByUser = false;
		myBeads.bot1Part.endTypeRBByUser = false;
		myBeads.bot2Part.endTypeRBByUser = false;
		myBeads.bot3Part.endTypeRBByUser = false;
		myBeads.leftPart.endTypeRBByUser = false;
		myBeads.rightPart.endTypeRBByUser = false;
		
		myBeads.openingClass = myParentFO.openingClass;
		myBeads.userDefinedOpeningID = myParentFO.userDefinedOpeningID;
		myBeads.unGlazed = true;
	}
	public GlazingBeads changeGBEndType(GlazingBeads myBeads) {
		
		if (myBeads.top1Part.partForm > 1)
		{
			if (myBeads.myParentO.dimD2 > 0)
			{
				myBeads.top1Part.endTypeLT = 1;
				myBeads.rightPart.endTypeLT = 1;
			}
			if (myBeads.myParentO.dimB1 > 0)
			{
				myBeads.top1Part.endTypeRB = 1;
				
				myBeads.leftPart.endTypeLT = 1;
			}
		}
		if (myBeads.noSidesTop > 1)
		{
			
			if (myBeads.noSidesTop == 2)
			{
				myBeads.top1Part.endTypeLT = 1;
				myBeads.top2Part.endTypeRB = 1;
				
				if (myBeads.myParentO.myParent.dimD2 > 0)
				{
					myBeads.top1Part.endTypeRB = 1;
					myBeads.top1Part.endTypeLT = 1;
					myBeads.top2Part.endTypeRB = 1;
					myBeads.leftPart.endTypeLT = 1;
				}
				if (myBeads.myParentO.myParent.dimB1 > 0)
				{
					myBeads.top1Part.endTypeLT = 1;
					myBeads.top2Part.endTypeRB = 1;
					myBeads.top2Part.endTypeLT = 1;
					myBeads.rightPart.endTypeLT = 1;
				}
				
			}
			
			
			if (myBeads.noSidesTop == 3)
			{
				myBeads.top1Part.endTypeLT = 1;
				myBeads.top1Part.endTypeRB = 1;
				myBeads.top2Part.endTypeLT = 1;
				myBeads.leftPart.endTypeLT = 1;
				
				myBeads.top1Part.endTypeRB = 1;
				myBeads.top2Part.endTypeLT = 1;
				myBeads.top2Part.endTypeRB = 1;
				myBeads.rightPart.endTypeLT = 1;
				
				myBeads.top3Part.endTypeLT = 1;
				myBeads.top3Part.endTypeRB = 1;
				
			}
			
			
		}
		
		if (myBeads.noSidesBot > 1)
		{
			
			if (myBeads.noSidesBot == 2)
			{
				
				if (myBeads.myParentO.myParent.dimB2 > 0)
				{
					
					myBeads.bot1Part.endTypeRB = 1;
					myBeads.bot1Part.endTypeLT = 1;
					myBeads.rightPart.endTypeRB = 1;
				}
				
				if (myBeads.myParentO.myParent.dimD1 > 0)
				{
					myBeads.bot2Part.endTypeRB = 1;
					myBeads.bot2Part.endTypeLT = 1;
					myBeads.leftPart.endTypeRB = 1;
				}
			}
			
			
			if (myBeads.noSidesBot == 3)
			{
				myBeads.bot1Part.endTypeRB = 1;
				myBeads.bot1Part.endTypeLT = 1;
				myBeads.rightPart.endTypeRB = 1;
				
				myBeads.bot2Part.endTypeRB = 1;
				myBeads.bot2Part.endTypeLT = 1;
				myBeads.leftPart.endTypeRB = 1;
				
				myBeads.bot3Part.endTypeLT = 1;
				myBeads.bot3Part.endTypeRB = 1;
				
			}
			
			
			
			
		}
		
		if (myBeads.noSidesLeft == 0 && myBeads.top1Part.startY > myBeads.top1Part.endY)
		{
			myBeads.top1Part.endTypeLT = 1;
			myBeads.top1Part.endTypeRB = 1;
			
			myBeads.top2Part.endTypeRB = 1;
			myBeads.rightPart.endTypeRB = 1;
			myBeads.bot1Part.endTypeLT = 1;
			
		}
		
		if (myBeads.noSidesLeft == 0 && myBeads.top1Part.startY == myBeads.top1Part.endY)
		{
			myBeads.top1Part.endTypeLT = 1;
			
			myBeads.rightPart.endTypeRB = 1;
			myBeads.bot1Part.endTypeLT = 1;
			
		}
		
		if (myBeads.noSidesRight == 0 && myBeads.top1Part.startY < myBeads.top1Part.endY)
		{
			myBeads.leftPart.endTypeLT = 1;
			myBeads.top1Part.endTypeLT = 1;
			myBeads.top1Part.endTypeRB = 1;
			myBeads.top2Part.endTypeRB = 1;
			myBeads.top2Part.endTypeLT = 1;
			myBeads.bot1Part.endTypeRB = 1;
			
		}
		
		if (myBeads.noSidesRight == 0 && myBeads.top1Part.startY == myBeads.top1Part.endY)
		{
			myBeads.leftPart.endTypeRB = 1;
			
			myBeads.top1Part.endTypeLT = 1;
			myBeads.bot1Part.endTypeRB = 1;
			
		}
		
		return myBeads;
	}
	
	
	public GeneralPath doGeneralPathGlass(final Profiles part) {
		
		final GeneralPath myOpen = new GeneralPath();
		
		myOpen.moveTo(part.startXC, part.startYC);
		
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
			
			myOpen.moveTo(part.startXC, part.startYC);
			
			for (int i = xCoordBo.length; i >= 1; i--) {
				if ((Double) xCoordBo[i - 1] >= 0) {
					myOpen.lineTo(
								((Double) xCoordBo[i - 1]),
								((Double) yCoordBo[i - 1]));
				}
			}
			
		} else {
			myOpen.lineTo(part.endXC, part.endYC);
			
		}
		
		myOpen.lineTo(part.endXA, part.endYA);
		
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
				// 1] >= 0) {
				myOpen.lineTo(
							((Double) xCoordBo[i]),
							((Double) yCoordBo[i]));
				// }
			}
			
			// myOpen.moveTo((int) part.startXA,
			// (int)
			// part.startYA);
		} else {
			myOpen.lineTo(part.startXA, part.startYA);
		}
		
		myOpen.lineTo(part.startXC, part.startYC);
		
		return myOpen;
		
	}
	
	//
	public void getPoints(
				final Arc2D arc,
				final int topBot,
				final double startX) {
		
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
	
	public GlazingBeads initSashLeaf(
			GlazingBeads myBeads,
				final boolean topIn,
				final boolean botIn,
				final boolean leftIn,
				final boolean rightIn) {
		
		
		myBeads.myParentO = myParentFO;
		myBeads.myFrame2 = myFrame2;
		myBeads = (GlazingBeads) myBeads.cloneShapeFromParentOpening(myParentFO);
		myBeads.options.clear();
		myBeads.executeOptionRules("creatGlazingstops.initSashLeaf.517");
		myBeads.clearanceTop = 0f / scale;
		myBeads.clearanceBot = 0f / scale;
		myBeads.clearanceLeft = 0f / scale;
		myBeads.clearanceRight = 0f / scale;
		
		//
		
		return myBeads;
	}
	
	public GlazingBeads initSashParts(GlazingBeads mySashLeaf) {
		
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
	
	public GlazingBeads setPartforms(GlazingBeads mySashLeaf) {
		
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
	
	public GlazingBeads doPartPos(final GlazingBeads mySashLeaf) {
		
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
		
	public Object[] setPartDims(
			GlazingBeads beads,
				final CreateShapeMethods createShape) {
		
		final Object[] myreturns = new Object[2];
		
		beads.bom.clear();
		beads.clearBomForShape();
//		beads.executePartRules(false, false, "createBeads.setparetrdims.649");
		beads.executePartRules(false);
		beads.top1Part.lengthMN = (int) (beads.top1Part.length / myFrame2.metricscale.doubleValue());
		beads.top1Part.lengthIN = (int) (beads.top1Part.length / myFrame2.imperialscale.doubleValue());
		
		beads.top2Part.lengthMN = (int) (beads.top2Part.length / myFrame2.metricscale.doubleValue());
		beads.top2Part.lengthIN = (int) (beads.top2Part.length / myFrame2.imperialscale.doubleValue());
		
		beads.top3Part.lengthMN = (int) (beads.top3Part.length / myFrame2.metricscale.doubleValue());
		beads.top3Part.lengthIN = (int) (beads.top3Part.length / myFrame2.imperialscale.doubleValue());
		
		beads.bot1Part.lengthMN = (int) (beads.bot1Part.length / myFrame2.metricscale.doubleValue());
		beads.bot1Part.lengthIN = (int) (beads.bot1Part.length / myFrame2.imperialscale.doubleValue());
		
		beads.bot2Part.lengthMN = (int) (beads.bot2Part.length / myFrame2.metricscale.doubleValue());
		beads.bot2Part.lengthIN = (int) (beads.bot2Part.length / myFrame2.imperialscale.doubleValue());
		
		beads.bot3Part.lengthMN = (int) (beads.bot3Part.length / myFrame2.metricscale.doubleValue());
		beads.bot3Part.lengthIN = (int) (beads.bot3Part.length / myFrame2.imperialscale.doubleValue());
		
		beads.leftPart.lengthMN = (int) (beads.leftPart.length / myFrame2.metricscale.doubleValue());
		beads.leftPart.lengthIN = (int) (beads.leftPart.length / myFrame2.imperialscale.doubleValue());
		
		beads.rightPart.lengthMN = (int) (beads.rightPart.length / myFrame2.metricscale.doubleValue());
		beads.rightPart.lengthIN = (int) (beads.rightPart.length / myFrame2.imperialscale.doubleValue());
		
		beads = (GlazingBeads) this.myFrame2.shapeColor.setShapeObjectPartColors(beads);

		if (myFrame2.mySeries.getSeriesUom() == 1)
		{
			createShape.top1DimBo = createShape.top1DimB = beads.top1Part.partDimBi = beads.top1Part.partDimB;
			createShape.top1DimAo = createShape.top1DimA = beads.top1Part.partDimAi = beads.top1Part.partDimA;
			createShape.top1DimCo = createShape.top1DimC = beads.top1Part.partDimCi = beads.top1Part.partDimC;
			createShape.top1DimMo = createShape.top1DimM = beads.top1Part.partDimMi = beads.top1Part.partDimM;
			createShape.top2DimBo = createShape.top2DimB = beads.top2Part.partDimBi = beads.top2Part.partDimB;
			createShape.top2DimAo = createShape.top2DimA = beads.top2Part.partDimAi = beads.top2Part.partDimA;
			createShape.top2DimCo = createShape.top2DimC = beads.top3Part.partDimCi = beads.top2Part.partDimC;
			createShape.top2DimMo = createShape.top2DimM = beads.top3Part.partDimMi = beads.top2Part.partDimM;
			createShape.top3DimBo = createShape.top3DimB = beads.top3Part.partDimBi = beads.top3Part.partDimB;
			createShape.top3DimAo = createShape.top3DimA = beads.top3Part.partDimAi = beads.top3Part.partDimA;
			createShape.top3DimCo = createShape.top3DimC = beads.top3Part.partDimCi = beads.top3Part.partDimC;
			createShape.top3DimMo = createShape.top3DimM = beads.top3Part.partDimMi = beads.top3Part.partDimM;
			
			createShape.bot1DimBo = createShape.bot1DimB = beads.bot1Part.partDimBi = beads.bot1Part.partDimB;
			createShape.bot1DimAo = createShape.bot1DimA = beads.bot1Part.partDimAi = beads.bot1Part.partDimA;
			createShape.bot1DimCo = createShape.bot1DimC = beads.bot1Part.partDimCi = beads.bot1Part.partDimC;
			createShape.bot1DimMo = createShape.bot1DimM = beads.bot1Part.partDimMi = beads.bot1Part.partDimM;
			createShape.bot2DimBo = createShape.bot2DimB = beads.bot2Part.partDimBi = beads.bot2Part.partDimB;
			createShape.bot2DimAo = createShape.bot2DimA = beads.bot2Part.partDimAi = beads.bot2Part.partDimA;
			createShape.bot2DimCo = createShape.bot2DimC = beads.bot2Part.partDimCi = beads.bot2Part.partDimC;
			createShape.bot2DimMo = createShape.bot2DimM = beads.bot2Part.partDimMi = beads.bot2Part.partDimM;
			createShape.bot3DimBo = createShape.bot3DimB = beads.bot3Part.partDimBi = beads.bot3Part.partDimB;
			createShape.bot3DimAo = createShape.bot3DimA = beads.bot3Part.partDimAi = beads.bot3Part.partDimA;
			createShape.bot3DimCo = createShape.bot3DimC = beads.bot3Part.partDimCi = beads.bot3Part.partDimC;
			createShape.bot3DimMo = createShape.bot3DimM = beads.bot3Part.partDimMi = beads.bot3Part.partDimM;
			
			createShape.leftDimBo = createShape.leftDimB = beads.leftPart.partDimBi = beads.leftPart.partDimB;
			createShape.leftDimAo = createShape.leftDimA = beads.leftPart.partDimAi = beads.leftPart.partDimA;
			createShape.leftDimCo = createShape.leftDimC = beads.leftPart.partDimCi = beads.leftPart.partDimC;
			createShape.leftDimMo = createShape.leftDimM = beads.leftPart.partDimMi = beads.leftPart.partDimM;
			createShape.rightDimBo = createShape.rightDimB = beads.rightPart.partDimBi = beads.rightPart.partDimB;
			createShape.rightDimAo = createShape.rightDimA = beads.rightPart.partDimAi = beads.rightPart.partDimA;
			createShape.rightDimCo = createShape.rightDimC = beads.rightPart.partDimCi = beads.rightPart.partDimC;
			createShape.rightDimMo = createShape.rightDimM = beads.rightPart.partDimMi = beads.rightPart.partDimM;
		}
		else
		{
			createShape.top1DimBo = createShape.top1DimB = beads.top1Part.partDimB = beads.top1Part.partDimBi;
			createShape.top1DimAo = createShape.top1DimA = beads.top1Part.partDimA = beads.top1Part.partDimAi;
			createShape.top1DimCo = createShape.top1DimC = beads.top1Part.partDimC = beads.top1Part.partDimCi;
			createShape.top1DimMo = createShape.top1DimM = beads.top1Part.partDimM = beads.top1Part.partDimMi;
			createShape.top2DimBo = createShape.top2DimB = beads.top2Part.partDimB = beads.top2Part.partDimBi;
			createShape.top2DimAo = createShape.top2DimA = beads.top2Part.partDimA = beads.top2Part.partDimAi;
			createShape.top2DimCo = createShape.top2DimC = beads.top3Part.partDimC = beads.top2Part.partDimCi;
			createShape.top2DimMo = createShape.top2DimM = beads.top3Part.partDimM = beads.top2Part.partDimMi;
			createShape.top3DimBo = createShape.top3DimB = beads.top3Part.partDimB = beads.top3Part.partDimBi;
			createShape.top3DimAo = createShape.top3DimA = beads.top3Part.partDimA = beads.top3Part.partDimAi;
			createShape.top3DimCo = createShape.top3DimC = beads.top3Part.partDimC = beads.top3Part.partDimCi;
			createShape.top3DimMo = createShape.top3DimM = beads.top3Part.partDimM = beads.top3Part.partDimMi;
			
			createShape.bot1DimBo = createShape.bot1DimB = beads.bot1Part.partDimB = beads.bot1Part.partDimBi;
			createShape.bot1DimAo = createShape.bot1DimA = beads.bot1Part.partDimA = beads.bot1Part.partDimAi;
			createShape.bot1DimCo = createShape.bot1DimC = beads.bot1Part.partDimC = beads.bot1Part.partDimCi;
			createShape.bot1DimMo = createShape.bot1DimM = beads.bot1Part.partDimM = beads.bot1Part.partDimMi;
			createShape.bot2DimBo = createShape.bot2DimB = beads.bot2Part.partDimB = beads.bot2Part.partDimBi;
			createShape.bot2DimAo = createShape.bot2DimA = beads.bot2Part.partDimA = beads.bot2Part.partDimAi;
			createShape.bot2DimCo = createShape.bot2DimC = beads.bot2Part.partDimC = beads.bot2Part.partDimCi;
			createShape.bot2DimMo = createShape.bot2DimM = beads.bot2Part.partDimM = beads.bot2Part.partDimMi;
			createShape.bot3DimBo = createShape.bot3DimB = beads.bot3Part.partDimB = beads.bot3Part.partDimBi;
			createShape.bot3DimAo = createShape.bot3DimA = beads.bot3Part.partDimA = beads.bot3Part.partDimAi;
			createShape.bot3DimCo = createShape.bot3DimC = beads.bot3Part.partDimC = beads.bot3Part.partDimCi;
			createShape.bot3DimMo = createShape.bot3DimM = beads.bot3Part.partDimM = beads.bot3Part.partDimMi;
			
			createShape.leftDimBo = createShape.leftDimB = beads.leftPart.partDimB = beads.leftPart.partDimBi;
			createShape.leftDimAo = createShape.leftDimA = beads.leftPart.partDimA = beads.leftPart.partDimAi;
			createShape.leftDimCo = createShape.leftDimC = beads.leftPart.partDimC = beads.leftPart.partDimCi;
			createShape.leftDimMo = createShape.leftDimM = beads.leftPart.partDimM = beads.leftPart.partDimMi;
			createShape.rightDimBo = createShape.rightDimB = beads.rightPart.partDimB = beads.rightPart.partDimBi;
			createShape.rightDimAo = createShape.rightDimA = beads.rightPart.partDimA = beads.rightPart.partDimAi;
			createShape.rightDimCo = createShape.rightDimC = beads.rightPart.partDimC = beads.rightPart.partDimCi;
			createShape.rightDimMo = createShape.rightDimM = beads.rightPart.partDimM = beads.rightPart.partDimMi;
		}
		
		myreturns[0] = beads;
		myreturns[1] = createShape;
		return myreturns;
	}
	
	public void setEndTypes(final GlazingBeads mySashLeaf) {
		
		// mySashLeaf.top1Part.endTypeRB = 2;
		// mySashLeaf.top1Part.endTypeLT = 2;
		// mySashLeaf.top2Part.endTypeRB = 2;
		// mySashLeaf.top2Part.endTypeLT = 2;
		// mySashLeaf.top3Part.endTypeRB = 3;
		// mySashLeaf.top3Part.endTypeLT = 3;
		//
		// if (myParentFO.top1Part.partForm > 1)
		// {
		// mySashLeaf.top1Part.endTypeRB = 1;
		// mySashLeaf.top1Part.endTypeLT = 1;
		// }
		// if (myParentFO.top2Part.partForm > 1)
		// {
		// mySashLeaf.top2Part.endTypeRB = 1;
		// mySashLeaf.top2Part.endTypeLT = 1;
		// }
		//
		// mySashLeaf.bot1Part.endTypeRB = 2;
		// mySashLeaf.bot1Part.endTypeLT = 2;
		// // mySashLeaf.bot2Part.endTypeRB = 2;
		// // mySashLeaf.bot2Part.endTypeLT = 2;
		// // mySashLeaf.bot3Part.endTypeRB = 2;
		// // mySashLeaf.bot3Part.endTypeLT = 2;
		//
		// if (myParentFO.bot1Part.partForm > 1)
		// {
		// mySashLeaf.bot1Part.endTypeRB = 1;
		// mySashLeaf.bot1Part.endTypeLT = 1;
		// }
		// if (myParentFO.bot2Part.partForm > 1)
		// {
		// mySashLeaf.bot2Part.endTypeRB = 1;
		// mySashLeaf.bot2Part.endTypeLT = 1;
		// }
		// if (myParentFO.bot3Part.partForm > 1)
		// {
		// mySashLeaf.bot3Part.endTypeRB = 1;
		// mySashLeaf.bot3Part.endTypeLT = 1;
		// }
		//
		// if (mySashLeaf.noSidesTop == 2 && myParentFO.top1Part.startYC >
		// myParentFO.top2Part.endYC
		// && myParentFO.top2Part.endYC <= myParentFO.top1Part.endYC)
		// {
		// mySashLeaf.top1Part.endTypeRB = 1;
		// mySashLeaf.top1Part.endTypeLT = 3;
		// mySashLeaf.top2Part.endTypeRB = 2;
		// mySashLeaf.top2Part.endTypeLT = 2;
		// if (myParentFO.top1Part.partForm > 1)
		// {
		// mySashLeaf.top1Part.endTypeRB = 1;
		// }
		//
		// }
		// if (mySashLeaf.noSidesTop == 2 && myParentFO.top1Part.startYC <=
		// myParentFO.top2Part.endYC)
		// {
		// mySashLeaf.top1Part.endTypeRB = 2;
		// mySashLeaf.top1Part.endTypeLT = 2;
		// mySashLeaf.top2Part.endTypeRB = 3;
		// mySashLeaf.top2Part.endTypeLT = 2;
		// if (myParentFO.top2Part.partForm > 1)
		// {
		// mySashLeaf.top2Part.endTypeLT = 1;
		// }
		// }
		// if (mySashLeaf.noSidesTop == 2 && myParentFO.top1Part.startYC >
		// myParentFO.top2Part.startYC
		// && myParentFO.top2Part.endYC >= myParentFO.top1Part.endYC)
		// {
		// mySashLeaf.top1Part.endTypeRB = 2;
		// mySashLeaf.top1Part.endTypeLT = 1;
		// mySashLeaf.top2Part.endTypeRB = 1;
		// mySashLeaf.top2Part.endTypeLT = 2;
		//
		// if (myParentFO.top1Part.partForm > 1)
		// {
		// mySashLeaf.top1Part.endTypeRB = 1;
		// }
		//
		// }
		// if (mySashLeaf.noSidesTop == 3)
		// {
		//
		// // mySashLeaf.top1Part.endTypeLT = 3;
		// // mySashLeaf.top2Part.endTypeRB = 3;
		// // mySashLeaf.top3Part.endTypeLT = 2;
		// // mySashLeaf.top3Part.endTypeRB = 2;
		//
		// mySashLeaf.top1Part.endTypeLT = 1;
		// mySashLeaf.top2Part.endTypeRB = 1;
		// mySashLeaf.top3Part.endTypeLT = 1;
		// mySashLeaf.top3Part.endTypeRB = 1;
		//
		// }
		// if (mySashLeaf.noSidesTop > 1)
		// {
		//
		// // mySashLeaf.top1Part.endTypeLT = 3;
		// // mySashLeaf.top2Part.endTypeRB = 3;
		// // mySashLeaf.top3Part.endTypeLT = 2;
		// // mySashLeaf.top3Part.endTypeRB = 2;
		//
		// mySashLeaf.top1Part.endTypeRB = 1;
		// mySashLeaf.top1Part.endTypeLT = 1;
		// mySashLeaf.top2Part.endTypeRB = 1;
		// mySashLeaf.top2Part.endTypeLT = 1;
		// mySashLeaf.top3Part.endTypeLT = 1;
		// mySashLeaf.top3Part.endTypeRB = 1;
		//
		// }
		//
		// if (mySashLeaf.noSidesBot > 1 || myParentFO.shapeID >= 90 &&
		// myParentFO.shapeID < 100)
		// {
		//
		// // mySashLeaf.top1Part.endTypeLT = 3;
		// // mySashLeaf.top2Part.endTypeRB = 3;
		// // mySashLeaf.top3Part.endTypeLT = 2;
		// // mySashLeaf.top3Part.endTypeRB = 2;
		//
		// mySashLeaf.bot1Part.endTypeRB = 1;
		// mySashLeaf.bot1Part.endTypeLT = 1;
		// mySashLeaf.bot2Part.endTypeRB = 1;
		// mySashLeaf.bot2Part.endTypeLT = 1;
		// mySashLeaf.bot3Part.endTypeLT = 1;
		// mySashLeaf.bot3Part.endTypeRB = 1;
		//
		// }
	}
	
	public GlazingBeads cloneGBFromParentOpening(
				final GlazingBeads beads)
	{
		
		beads.myFrame2 = myFrame2;
		beads.myParentO = myParentFO;
		
		beads.a_1Level = myParentFO.a_assemblyLevel;
		beads.a_1Sequence = myParentFO.a_sequenceID;
		beads.a_2Level = myParentFO.a_1Level;
		beads.a_2Sequence = myParentFO.a_1Sequence;
		beads.a_3Level = myParentFO.a_2Level;
		beads.a_3Sequence = myParentFO.a_2Sequence;
		beads.a_4Level = myParentFO.a_3Level;
		beads.a_4Sequence = myParentFO.a_3Sequence;
		
		beads.a_5Level = myParentFO.a_4Level;
		beads.a_5Sequence = myParentFO.a_4Sequence;
		beads.a_6Level = myParentFO.a_5Level;
		beads.a_6Sequence = myParentFO.a_5Sequence;
		beads.a_7Level = myParentFO.a_6Level;
		beads.a_7Sequence = myParentFO.a_6Sequence;
		beads.a_8Level = myParentFO.a_7Level;
		beads.a_8Sequence = myParentFO.a_7Sequence;
		beads.a_9Level = myParentFO.a_8Level;
		beads.a_9Sequence = myParentFO.a_8Sequence;
		beads.a_10Level = myParentFO.a_9Level;
		beads.a_10Sequence = myParentFO.a_9Sequence;
		
		
		beads.shapeID = myParentFO.shapeID;
		
		beads.highestY = myParentFO.highestY;
		beads.highestYC = myParentFO.highestYC;
		
		beads.lowestY = myParentFO.lowestY;
		beads.lowestYC = myParentFO.lowestYC;
		
		beads.startingX = myParentFO.startingX;
		beads.startingY = myParentFO.startingY;
		
		beads.startCol = myParentFO.startCol;
		beads.endCol = myParentFO.endCol;
		beads.startRow = myParentFO.startRow;
		beads.endRow = myParentFO.endRow;
		
		beads.rID = myParentFO.rID;
		
		beads.widthPix = myParentFO.widthPix;
		beads.heightPix = myParentFO.heightPix;
		
		beads.shapeID = myParentFO.shapeID;
		
		beads.startingX = myParentFO.startingX;
		beads.startingY = myParentFO.startingY;
		
		beads.a_sequenceID = myParentFO.a_sequenceID;
		
		beads.radius1 = myParentFO.radius1;
		beads.radius2 = myParentFO.radius2;
		
		beads.myParent = beads.myOverall = beads.myFacet = myParentFO.myParent;
		
		beads.shapeChanged = myParentFO.shapeChanged;
		
		beads.bkgrdStartX = myParentFO.bkgrdStartX;
		beads.bkgrdStartY = myParentFO.bkgrdStartY;
		
		beads.noSides = myParentFO.noSides;
		beads.noSidesTop = myParentFO.noSidesTop;
		beads.noSidesBot = myParentFO.noSidesBot;
		beads.noSidesLeft = myParentFO.noSidesLeft;
		beads.noSidesRight = myParentFO.noSidesRight;
		
		beads.centerPointX = myParentFO.centerPointX;
		beads.centerPointX2 = myParentFO.centerPointX2;
		beads.centerPointY = myParentFO.centerPointY;
		beads.centerPointY2 = myParentFO.centerPointY2;
		
		beads.bX2 = myParentFO.bX2;
		beads.bY2 = myParentFO.bY2;
		beads.bX3 = myParentFO.bX3;
		beads.bY3 = myParentFO.bY3;
		beads.bX4 = myParentFO.bX4;
		beads.bY4 = myParentFO.bY4;
		
		beads.startingCX = myParentFO.startingCX;
		beads.startingCY = myParentFO.startingCY;
		
		beads.bCX2 = myParentFO.bCX2;
		beads.bCY2 = myParentFO.bCY2;
		beads.bCX3 = myParentFO.bCX3;
		beads.bCY3 = myParentFO.bCY3;
		beads.bCX4 = myParentFO.bCX4;
		beads.bCY4 = myParentFO.bCY4;
		beads.dimA1 = myParentFO.dimA1;
		beads.dimA2 = myParentFO.dimA2;
		beads.dimA3 = myParentFO.dimA3;
		beads.dimA4 = myParentFO.dimA4;
		beads.dimA5 = myParentFO.dimA5;
		beads.dimA0 = myParentFO.dimA0;
		beads.dimB1 = myParentFO.dimB1;
		beads.dimB2 = myParentFO.dimB2;
		beads.dimB3 = myParentFO.dimB3;
		beads.dimB4 = myParentFO.dimB4;
		beads.dimB5 = myParentFO.dimB5;
		beads.dimB0 = myParentFO.dimB0;
		beads.dimC1 = myParentFO.dimC1;
		beads.dimC2 = myParentFO.dimC2;
		beads.dimC3 = myParentFO.dimC3;
		beads.dimC4 = myParentFO.dimC4;
		beads.dimC5 = myParentFO.dimC5;
		beads.dimC0 = myParentFO.dimC0;
		beads.dimD1 = myParentFO.dimD1;
		beads.dimD2 = myParentFO.dimD2;
		beads.dimD3 = myParentFO.dimD3;
		beads.dimD4 = myParentFO.dimD4;
		beads.dimD5 = myParentFO.dimD5;
		beads.dimD0 = myParentFO.dimD0;
		
		beads.dimTM = myParentFO.dimTM;
		beads.dimBM = myParentFO.dimBM;
		beads.dimLM = myParentFO.dimLM;
		beads.dimRM = myParentFO.dimRM;
		beads.dimTA = myParentFO.dimTA;
		beads.dimBA = myParentFO.dimBA;
		beads.dimLA = myParentFO.dimLA;
		beads.dimRA = myParentFO.dimRA;
		
		beads.topIn = myParentFO.topIn;
		beads.botIn = myParentFO.botIn;
		beads.leftIn = myParentFO.leftIn;
		beads.rightIn = myParentFO.rightIn;
		
		beads.lean = myParentFO.lean;
		beads.lean2 = myParentFO.lean2;
		beads.lean3 = myParentFO.lean3;
		beads.lean4 = myParentFO.lean4;
		
		beads.parentH = myParentFO.parentH;
		beads.parentW = myParentFO.parentW;
		
		beads.parentStartY = myParentFO.parentStartY;
		beads.parentStartX = myParentFO.parentStartX;
		beads.parentRadius1 = myParentFO.parentRadius1;// *
		// 2;
		
		beads.parentCX = myParentFO.parentCX;
		beads.parentCY = myParentFO.parentCY;
		beads.parentCX2 = myParentFO.parentCX2;
		beads.parentCY2 = myParentFO.parentCY2;
		beads.parentShape = myParentFO.parentShape;
		
		beads.px1 = myParentFO.px1;
		beads.py1 = myParentFO.py1;
		beads.px2 = myParentFO.px2;
		beads.py2 = myParentFO.py2;
		beads.px3 = myParentFO.px3;
		beads.py3 = myParentFO.py3;
		beads.px4 = myParentFO.px4;
		beads.py4 = myParentFO.py4;
		beads.px5 = myParentFO.px5;
		beads.py5 = myParentFO.py5;
		beads.px6 = myParentFO.px6;
		beads.py6 = myParentFO.py6;
		beads.px7 = myParentFO.px7;
		beads.py7 = myParentFO.py7;
		beads.px8 = myParentFO.px8;
		beads.py8 = myParentFO.py8;
		
		beads.startingCX = myParentFO.startingCX;
		beads.startingCY = myParentFO.startingCY;
		
		beads.px1c = myParentFO.px1c;
		beads.py1c = myParentFO.py1c;
		beads.px2c = myParentFO.px2c;
		beads.py2c = myParentFO.py2c;
		beads.px3c = myParentFO.px3c;
		beads.py3c = myParentFO.py3c;
		beads.px4c = myParentFO.px4c;
		beads.py4c = myParentFO.py4c;
		beads.px5c = myParentFO.px5c;
		beads.py5c = myParentFO.py5c;
		beads.px6c = myParentFO.px6c;
		beads.py6c = myParentFO.py6c;
		beads.px7c = myParentFO.px7c;
		beads.py7c = myParentFO.py7c;
		beads.px8c = myParentFO.px8c;
		beads.py8c = myParentFO.py8c;
		
		beads.bCX2 = myParentFO.bCX2;
		beads.bCY2 = myParentFO.bCY2;
		beads.bCX3 = myParentFO.bCX3;
		beads.bCY3 = myParentFO.bCY3;
		beads.bCX4 = myParentFO.bCX4;
		beads.bCY4 = myParentFO.bCY4;
		
		// beads.top1Part =
		// beads.top1Part.cloneProfile(myParentFO.top1Part);
		// beads.top2Part =
		// beads.top2Part.cloneProfile(myParentFO.top2Part);
		// beads.top3Part =
		// beads.top3Part.cloneProfile(myParentFO.top3Part);
		// beads.bot1Part =
		// beads.bot1Part.cloneProfile(myParentFO.bot1Part);
		// beads.bot2Part =
		// beads.bot2Part.cloneProfile(myParentFO.bot2Part);
		// beads.bot3Part =
		// beads.bot3Part.cloneProfile(myParentFO.bot3Part);
		// beads.leftPart =
		// beads.leftPart.cloneProfile(myParentFO.leftPart);
		// beads.rightPart =
		// beads.rightPart.cloneProfile(myParentFO.rightPart);
		
		beads.top1Part = (Profiles) beads.top1Part.cloneProfile(myParentFO.top1Part);
		beads.top2Part = (Profiles) beads.top2Part.cloneProfile(myParentFO.top2Part);
		beads.top3Part = (Profiles) beads.top3Part.cloneProfile(myParentFO.top3Part);
		beads.rightPart = (Profiles) beads.rightPart.cloneProfile(myParentFO.rightPart);
		beads.leftPart = (Profiles) beads.leftPart.cloneProfile(myParentFO.leftPart);
		beads.bot1Part = (Profiles) beads.bot1Part.cloneProfile(myParentFO.bot1Part);
		beads.bot2Part = (Profiles) beads.bot2Part.cloneProfile(myParentFO.bot2Part);
		beads.bot3Part = (Profiles) beads.bot3Part.cloneProfile(myParentFO.bot3Part);
		
		return beads;
	}
	
}

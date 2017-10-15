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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import Model.Frame;
import Model.OpeningObject;
import Model.SashLeaf;
import Model.SashTypeObject;
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

// import Model.SubFrameObject;

public class CreateFrames
{
	
	public OpeningObject myParentO;
	
	Collection xCoordB = new ArrayList();
	
	Collection yCoordB = new ArrayList();
	
	Object[] xCoordBo = null;
	
	Object[] yCoordBo = null;
	
	double myX = 0;
	
	double myY = 0;
	
	boolean openingChanged = false;
	
	BigDecimal scale = new BigDecimal(0);
	
	ItemFrame myFrame2;
	
	int rgb_r = 255;
	
	int rgb_g = 255;
	
	int rgb_b = 255;
	
	public Collection myExistingFrames = new ArrayList();
	
	public CreateFrames(final OpeningObject frame, final Collection existingFrames, final ItemFrame myframe) {
	
		myParentO = frame;
		myFrame2 = myframe;
		scale = myFrame2.scale;
		myExistingFrames = existingFrames;
	}
	
	public Frame doFrame(int sashtype, int sashid, int controlType, SashTypeObject newSashIn, SashTypeObject newSashMid,
				SashTypeObject newSashOut, boolean glazedout, boolean sameParts, boolean isReCalc, boolean equalize)
				throws Exception
	{
	
		Frame myFrame = new Frame();
		
		setInitValues(sashtype, sashid, controlType, glazedout, myFrame);
		
		myFrame = this.initSashLeaf(isReCalc, myFrame);
		
		/*
		 * Reset in case values changed due to Cloning of Parent Opening
		 */
		setInitValues(sashtype, sashid, controlType, glazedout, myFrame);
		
		if(myFrame.shapeChanged){
			sameParts = false;
		}
		
		if (!sameParts)
		{
			openingChanged = true;
			myFrame.isNewFrame = true;
		}
		else
		{
			myFrame.isNewFrame = false;
		}
		
		if (myFrame.topIn && myFrame.botIn && myFrame.leftIn)
		{
			myFrame.topIn = myFrame.topIn;
		}
		if (myFrame.topIn && !myFrame.botIn && myFrame.leftIn)
		{
			myFrame.topIn = myFrame.topIn;
		}
		
		CreateShapeMethods createShape = new CreateShapeMethods(myParentO, 2, myFrame2);
		
		Object[] returns = this.setPartDims(myFrame, createShape, isReCalc);
		
		myFrame = (Frame) returns[0];
		
		createShape = (CreateShapeMethods) returns[1];
		
		if (!myParentO.top2Part.posInUse)
		{
			
			myFrame.top2Part = (Profiles) myFrame.top2Part.cloneProfile(myFrame.top1Part);
			myFrame.top2Part.posInUse = false;
			myFrame.top2Part.lengthM = 0;
			myFrame.top2Part.lengthI = 0;
			myFrame.top2 = (Top2Object) myFrame.top2.cloneProfile(myFrame.top2Part);
			
			myFrame.top2.posInUse = false;
			
		}
		
		createShape.getClearance(myFrame);
		
		myFrame = (Frame) createShape.doShapeBkgrd(myFrame);
		
		myFrame = (Frame) createShape.makeSides(myFrame);
		
		myFrame = (Frame) createShape.makeSidesStraight(myFrame);
		
		myFrame = (Frame) createShape.doParts(myFrame, true);
		
		myFrame = (Frame) createShape.setBaseInfo(myFrame, 1, true);
		
		myFrame.partObjects = createShape.setPartObjectsAndCollection(myFrame);
		
		myFrame.top1 = (Top1Object) myFrame.top1.cloneProfile(myFrame.top1Part);
		myFrame.top2 = (Top2Object) myFrame.top2.cloneProfile(myFrame.top2Part);
		myFrame.top3 = (Top3Object) myFrame.top3.cloneProfile(myFrame.top3Part);
		
		myFrame.bot1 = (Bot1Object) myFrame.bot1.cloneProfile(myFrame.bot1Part);
		myFrame.bot2 = (Bot2Object) myFrame.bot2.cloneProfile(myFrame.bot2Part);
		myFrame.bot3 = (Bot3Object) myFrame.bot3.cloneProfile(myFrame.bot3Part);
		
		myFrame.left = (LeftObject) myFrame.left.cloneProfile(myFrame.leftPart);
		myFrame.right = (RightObject) myFrame.right.cloneProfile(myFrame.rightPart);
		
		
		myFrame.bom.clear();
		myFrame.clearBomForShape();
		myFrame.executePartRules(true, true, "createFrames.doFrames.215");
		
		myFrame.bOpeningObject = myFrame.doMainOpening();
		
		// Object[] ops = myFrame.openings.toArray();
		// myFrame.openings.clear();
		// for(Object op : ops){
		// ((OpeningObject)op).myParentF = myFrame;
		// myFrame.openings.add(op);
		// }
		myFrame.bOpeningObject.unGlazed = true;
		
		/*
		 * if Undo no need to change anything
		 * 
		 * if add sash no need to change X position just recalc Y Only needed
		 * if adding new Mullion.
		 */
		
		if (myFrame2.getActionTypeEvent() == 1 || myFrame2.getActionTypeEvent() == 0 ||  myFrame2.wEntered ||  myFrame2.hEntered)
		{
			// if(!equalize){
			myFrame.bOpeningObject = myFrame.bOpeningObject.modifyVMCEqualize(myFrame.bOpeningObject);
			
			myFrame.bOpeningObject = myFrame.bOpeningObject.modifyHMCEqualize(myFrame.bOpeningObject);
			
			if( myFrame2.wEntered ||  myFrame2.hEntered){
				myFrame.bOpeningObject = myFrame.modifyVMHeight(myFrame.bOpeningObject);
				myFrame.bOpeningObject = myFrame.bOpeningObject.modifyHMWidth(myFrame.bOpeningObject);
				
			}
		}
		
		else 
			if (myFrame2.isUndo || myFrame2.getActionTypeEvent() == 2 || myFrame2.getActionTypeEvent() == 3 || myFrame2.getActionTypeEvent() >= 6)
		{
			myFrame.bOpeningObject = myFrame.modifyVMHeight(myFrame.bOpeningObject);
			myFrame.bOpeningObject = myFrame.bOpeningObject.modifyHMWidth(myFrame.bOpeningObject);
			
		}
		
		if (myFrame.bOpeningObject.mullions.size() > 0 || myFrame.bOpeningObject.mullionsH.size() > 0)
		{
			myFrame.doOpenings();
		}
		// // Check
		Object[] oPenings = myFrame.openings.toArray();
		
		myFrame.openings.clear();
		
		for (Object O : oPenings)
		{
			((OpeningObject) O).myParent = myFrame;
			
			myFrame.openings.add(O);
		}
		
		myFrame.bOpeningObject = myFrame.doMullions(myFrame.bOpeningObject);
		
		this.doExtensions(myFrame, createShape);
		
		myFrame.partObjects = createShape.doGPParts(myFrame.partObjects, myFrame, myFrame.glazedOut);
		
//		myFrame.options.clear();
//		myFrame.executeOptionRules("createFrames.doFrames.211");
		
//		myFrame.bom.clear();
//		myFrame.clearBomForShape();
//		myFrame.executePartRules(true, true, "createFrames.doFrames.215");
//		
//		myFrame.partObjects = createShape.doGPParts(myFrame.partObjects, myFrame, myFrame.glazedOut);
		
		
		createShape = null;
		myFrame.shapeChanged = false;
		return myFrame;
		
	}

	private void setInitValues(int sashtype, int sashid, int controlType,
			boolean glazedout, Frame myFrame) {
		myFrame.glazedOut = glazedout;
		myFrame.controlUserDefinedOpeningID = sashid;
		myFrame.controlOpeningClass = sashtype;
		myFrame.controlOpeningClassType = controlType;
		myFrame.openingClass = sashtype;
		myFrame.userDefinedOpeningID = sashid;
	}
	
	public void doExtensions(Frame myFrame, CreateShapeMethods createShape)
	{
	
		Object[] fo = myFrame.openings.toArray();
		
		for (Object o : fo)
		{
			
			if (((OpeningObject) o).sashObjectMid != null)
			{
				if (((OpeningObject) o).a_sequenceID == 11)
				{
					myFrame.glazedOut = ((OpeningObject) o).glazedOut;
				}
				if (((OpeningObject) o).a_sequenceID == 11 && ((OpeningObject) o).contentMid == 2
							&& ((OpeningObject) o).sashObjectMid.sashClassType == 311)
				{
					Object[] ls = ((OpeningObject) o).sashObjectMid.frames.toArray();
					double extension = 0;
					
					for (final Object s : ls)
					{
						extension = ((SashLeaf) s).widthPix + ((OpeningObject) o).sashObjectMid.extraExtend;
						break;
					}
					
					myFrame.top1Part.endXC = myFrame.top1Part.endXBA = myFrame.top1Part.endXA = myFrame.top1Part.endXC
								+ extension;
					
					myFrame.bot1Part.startXC = myFrame.bot1Part.startXBA = myFrame.bot1Part.startXA = myFrame.bot1Part.startXC
								+ extension;
					
					myFrame.top1Part.length = myFrame.top1Part.endXC - myFrame.top1Part.startXC;
					
					myFrame.bot1Part.length = myFrame.bot1Part.endXC - myFrame.bot1Part.startXC;
					
					myFrame.rightPart.startXBA = myFrame.rightPart.startXA = myFrame.rightPart.endXBA = myFrame.rightPart.endXC = myFrame.rightPart.endXA = myFrame.rightPart.startXC;
					myFrame.rightPart.length = 0;
					
					myFrame.partObjects.clear();
					
					myFrame.partObjects = createShape.setPartObjectsAndCollection(myFrame);
					
				}
				if (((OpeningObject) o).a_sequenceID == 11 && ((OpeningObject) o).contentMid == 2
							&& ((OpeningObject) o).sashObjectMid.sashClassType == 312)
				{
					final Object[] ls = ((OpeningObject) o).sashObjectMid.frames.toArray();
					double extension = 0;
					for (final Object s : ls)
					{
						extension = ((SashLeaf) s).widthPix + ((OpeningObject) o).sashObjectMid.extraExtend;
						break;
					}
					
					myFrame.top1Part.startXC = myFrame.top1Part.startXBA = myFrame.top1Part.startXA = myFrame.top1Part.startXC
								- extension;
					
					myFrame.bot1Part.endXC = myFrame.bot1Part.endXBA = myFrame.bot1Part.endXA = myFrame.bot1Part.endXC
								- extension;
					
					myFrame.top1Part.length = myFrame.top1Part.endXC - myFrame.top1Part.startXC;
					
					myFrame.bot1Part.length = myFrame.bot1Part.endXC - myFrame.bot1Part.startXC;
					
					myFrame.leftPart.startXBA = myFrame.leftPart.startXA = myFrame.leftPart.endXBA = myFrame.leftPart.endXC = myFrame.leftPart.endXA = myFrame.leftPart.startXC;
					myFrame.leftPart.length = 0;
					myFrame.partObjects.clear();
					
					myFrame.partObjects = createShape.setPartObjectsAndCollection(myFrame);
				}
				
				if (((OpeningObject) o).a_sequenceID == 11 && ((OpeningObject) o).contentMid == 2
							&& ((OpeningObject) o).sashObjectMid.sashClassType == 313)
				{
					final Object[] ls = ((OpeningObject) o).sashObjectMid.frames.toArray();
					double extension = 0;
					for (final Object s : ls)
					{
						extension = ((SashLeaf) s).widthPix + ((OpeningObject) o).sashObjectMid.extraExtend;
						break;
					}
					
					myFrame.top1Part.endXC = myFrame.top1Part.endXBA = myFrame.top1Part.endXA = myFrame.top1Part.endXC
								+ extension;
					
					myFrame.bot1Part.startXC = myFrame.bot1Part.startXBA = myFrame.bot1Part.startXA = myFrame.bot1Part.startXC
								+ extension;
					
					myFrame.top1Part.startXC = myFrame.top1Part.startXBA = myFrame.top1Part.startXA = myFrame.top1Part.startXC
								- extension;
					
					myFrame.bot1Part.endXC = myFrame.bot1Part.endXBA = myFrame.bot1Part.endXA = myFrame.bot1Part.endXC
								- extension;
					
					myFrame.top1Part.length = myFrame.top1Part.endXC - myFrame.top1Part.startXC;
					
					myFrame.bot1Part.length = myFrame.bot1Part.endXC - myFrame.bot1Part.startXC;
					
					myFrame.rightPart.startXBA = myFrame.rightPart.startXA = myFrame.rightPart.endXBA = myFrame.rightPart.endXC = myFrame.rightPart.endXA = myFrame.rightPart.startXC;
					myFrame.rightPart.length = 0;
					
					myFrame.leftPart.startXBA = myFrame.leftPart.startXA = myFrame.leftPart.endXBA = myFrame.leftPart.endXC = myFrame.leftPart.endXA = myFrame.leftPart.startXC;
					myFrame.leftPart.length = 0;
					
					myFrame.partObjects.clear();
					
					myFrame.partObjects = createShape.setPartObjectsAndCollection(myFrame);
				}
			}
		}
	}
	
	// public Collection setPartObjectsAndCollection(
	// final Frame myFrame,
	// final CreateShapeMethods createShape) {
	//
	// myFrame.top1 = createShape.myTop1Clone(myFrame.top1, myFrame.top1Part);
	// myFrame.top2 = createShape.myTop2Clone(myFrame.top2, myFrame.top2Part);
	// myFrame.top3 = createShape.myTop3Clone(myFrame.top3, myFrame.top3Part);
	// myFrame.bot1 = createShape.myBot1Clone(myFrame.bot1, myFrame.bot1Part);
	// myFrame.bot2 = createShape.myBot2Clone(myFrame.bot2, myFrame.bot2Part);
	// myFrame.bot3 = createShape.myBot3Clone(myFrame.bot3, myFrame.bot3Part);
	//
	// myFrame.left = createShape.myLeftClone(myFrame.left, myFrame.leftPart);
	// myFrame.right = createShape.myRightClone(myFrame.right,
	// myFrame.rightPart);
	//
	// myFrame.partObjects.clear();
	//
	// if (myFrame.noSidesTop == 1) {
	// myFrame.partObjects.add(myFrame.top1Part);
	// } else if (myFrame.noSidesTop == 2) {
	// myFrame.partObjects.add(myFrame.top1Part);
	// myFrame.partObjects.add(myFrame.top2Part);
	// } else if (myFrame.noSidesTop == 3) {
	// myFrame.partObjects.add(myFrame.top1Part);
	// myFrame.partObjects.add(myFrame.top2Part);
	// myFrame.partObjects.add(myFrame.top3Part);
	// }
	// if (myFrame.noSidesBot == 1) {
	// myFrame.partObjects.add(myFrame.bot1Part);
	// } else if (myFrame.noSidesBot == 2) {
	// myFrame.partObjects.add(myFrame.bot1Part);
	// myFrame.partObjects.add(myFrame.bot2Part);
	// } else if (myFrame.noSidesBot == 3) {
	// myFrame.partObjects.add(myFrame.bot1Part);
	// myFrame.partObjects.add(myFrame.bot2Part);
	// myFrame.partObjects.add(myFrame.bot3Part);
	// }
	// if (myFrame.noSidesLeft == 1) {
	// myFrame.partObjects.add(myFrame.leftPart);
	// }
	// if (myFrame.noSidesRight == 1) {
	// myFrame.partObjects.add(myFrame.rightPart);
	// }
	//
	// return myFrame.partObjects;
	// }
	
	public GeneralPath doGeneralPathGlass(final Profiles part)
	{
	
		final GeneralPath myOpen = new GeneralPath();
		
		myOpen.moveTo((int) part.startXC, (int) part.startYC);
		
		if (part.partForm == 2)
		{
			final Arc2D mytopb = new Arc2D.Double(part.bkgrdStartXBA, part.bkgrdStartYBA, part.bkgrdWidthBA,
						part.bkgrdHeightBA, part.startAngleBA, part.endAngleBA, Arc2D.OPEN);
			
			xCoordB = new ArrayList();
			yCoordB = new ArrayList();
			this.getPoints(mytopb, 1, part.startXC);
			
			xCoordBo = xCoordB.toArray();
			yCoordBo = yCoordB.toArray();
			
			myOpen.moveTo((int) part.startXC, (int) part.startYC);
			
			for (int i = xCoordBo.length; i >= 1; i--)
			{
				if ((Double) xCoordBo[i - 1] >= 0)
				{
					myOpen.lineTo(((Double) xCoordBo[i - 1]), ((Double) yCoordBo[i - 1]));
				}
			}
			
			// myOpen.append(mytop, false);
			
			// myOpen.moveTo((int) opening.endX,
			// (int)
			// opening.endY);
			
		}
		else
		{
			myOpen.lineTo((int) part.endXC, (int) part.endYC);
			
		}
		myOpen.lineTo((int) part.endXA, (int) part.endYA);
		
		if (part.partForm == 2)
		{
			
			final Arc2D mytopa = new Arc2D.Double(part.bkgrdStartXA, part.bkgrdStartYA, part.bkgrdWidthA, part.bkgrdHeightA,
						part.startAngleA, part.endAngleA, Arc2D.OPEN);
			xCoordB = new ArrayList();
			yCoordB = new ArrayList();
			this.getPoints(mytopa, 1, part.startXA);
			
			xCoordBo = xCoordB.toArray();
			yCoordBo = yCoordB.toArray();
			
			// myOpen.moveTo((int) part.startXA,
			// (int)
			// part.startYA);
			
			for (int i = 0; i < xCoordBo.length; i++)
			{
				// if ((Double) xCoordBo[i +
				// 1] >= 0)
				// {
				myOpen.lineTo(((Double) xCoordBo[i]), ((Double) yCoordBo[i]));
				// }
			}
			
			// myOpen.moveTo((int) part.startXA,
			// (int)
			// part.startYA);
		}
		else
		{
			myOpen.lineTo((int) part.startXA, (int) part.startYA);
		}
		
		myOpen.lineTo((int) part.startXC, (int) part.startYC);
		
		return myOpen;
		
	}
	
	//
	public void getPoints(final Arc2D arc, final int topBot, final double startX)
	{
	
		final double flatness = 0.0000001f;
		final PathIterator pit = arc.getPathIterator(null, flatness);
		final double[] coords = new double[6];
		int count = 0;
		
		while (!pit.isDone())
		{
			final int type = pit.currentSegment(coords);
			switch (type)
			{
			
			case PathIterator.SEG_MOVETO:
				myX = coords[0];
				myY = coords[1];
				xCoordB.add(myX);
				yCoordB.add(myY);
				count++;
				break;
			
			case PathIterator.SEG_LINETO:
				if (coords[0] > 0)
				{
					myX = coords[0];
					myY = coords[1];
					if (topBot == 1)
					{
						if (myX >= startX)
						{
							
							xCoordB.add(myX);
							yCoordB.add(myY);
						}
					}
					else
					{
						if (myX <= startX)
						{
							
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
	
	public Frame initSashLeaf(final boolean isReCalc, Frame myFrame)
	{
	
		myFrame = (Frame) myFrame.cloneShapeFromParentOpening(myParentO);
		
		myFrame.a_levelID = 3;
		
		myFrame.myFrame2 = myFrame2;
		
		myFrame.myFacet = myParentO.myParent;
		myFrame.shapeChanged = myParentO.shapeChanged;
		
		myFrame.options.clear();
		myFrame.executeOptionRules("createFrames.initSAshLeaf.540");
		
		if (myExistingFrames.size() > 0)
		{
			
			for (final Object S : myExistingFrames.toArray())
			{
				if (((Frame) S).a_sequenceID == myFrame.a_sequenceID)
				{
					
					myFrame.isStdW = ((Frame) S).isStdW;
					myFrame.isStdH = ((Frame) S).isStdH;
					myFrame.stdWM = ((Frame) S).stdWM;
					myFrame.stdWI = ((Frame) S).stdWI;
					myFrame.stdHM = ((Frame) S).stdHM;
					myFrame.stdHI = ((Frame) S).stdHI;
					
					if (myFrame.shapeID != ((Frame) S).shapeID)
					{
						myFrame.shapeChanged = true;
					}
					if (myFrame.controlOpeningClass != ((Frame) S).controlOpeningClass)
					{
						myFrame.shapeChanged = true;
					}
					
					
					myFrame.glazedOut = ((Frame) S).glazedOut;
					
					myFrame.bOpeningObject = ((Frame) S).bOpeningObject.cloneBkgrdOpening(((Frame) S).bOpeningObject);
					
					myFrame.openings.addAll(((Frame) S).openings);
					
					if (!isReCalc)
					{
						
						myFrame.top1Part = (Profiles) myFrame.top1Part.cloneProfile(((Frame) S).top1Part);
						
						myFrame.top2Part = (Profiles) myFrame.top2Part.cloneProfile(((Frame) S).top2Part);
						myFrame.top3Part = (Profiles) myFrame.top3Part.cloneProfile(((Frame) S).top3Part);
						
						myFrame.rightPart = (Profiles) myFrame.rightPart.cloneProfile(((Frame) S).rightPart);
						myFrame.leftPart = (Profiles) myFrame.leftPart.cloneProfile(((Frame) S).leftPart);
						
						myFrame.bot1Part = (Profiles) myFrame.bot1Part.cloneProfile(((Frame) S).bot1Part);
						
						myFrame.bot2Part = (Profiles) myFrame.bot2Part.cloneProfile(((Frame) S).bot2Part);
						myFrame.bot3Part = (Profiles) myFrame.bot3Part.cloneProfile(((Frame) S).bot3Part);
						
						myFrame.partObjects.addAll(((Frame) S).partObjects);
						
						myFrame.top1Part.posInUse = myParentO.top1Part.posInUse;
						myFrame.top2Part.posInUse = myParentO.top2Part.posInUse;
						myFrame.top3Part.posInUse = myParentO.top3Part.posInUse;
						myFrame.bot1Part.posInUse = myParentO.bot1Part.posInUse;
						myFrame.bot2Part.posInUse = myParentO.bot2Part.posInUse;
						myFrame.bot3Part.posInUse = myParentO.bot3Part.posInUse;
						myFrame.leftPart.posInUse = myParentO.leftPart.posInUse;
						myFrame.rightPart.posInUse = myParentO.rightPart.posInUse;
					}
					
					break;
					
				}
			}
		}
		
		return myFrame;
	}
	
	public Frame setPartforms(final Frame myFrame)
	{
	
		// myFrame.top1Part.partForm = myParentO.top1Part.partForm;
		//
		// myFrame.top2Part.partForm = myParentO.top2Part.partForm;
		//
		// myFrame.top3Part.partForm = myParentO.top3Part.partForm;
		//
		// myFrame.bot1Part.partForm = myParentO.bot1Part.partForm;
		//
		// myFrame.bot2Part.partForm = myParentO.bot2Part.partForm;
		//
		// myFrame.bot3Part.partForm = myParentO.bot3Part.partForm;
		//
		// myFrame.leftPart.partForm = myParentO.leftPart.partForm;
		//
		// myFrame.rightPart.partForm =
		// myParentO.rightPart.partForm;
		//
		// myFrame = this.doPartPos(myFrame);
		return myFrame;
	}
	
	public Frame doPartPos(final Frame myFrame)
	{
	
		// if (!myParentO.top1Part.posInUse) {
		// myFrame.top1Part = new Profiles();
		// myFrame.top1Part.posInUse = false;
		// }
		// if (!myParentO.top2Part.posInUse) {
		// myFrame.top2Part = new Profiles();
		// myFrame.top2Part.posInUse = false;
		// }
		// if (!myParentO.top3Part.posInUse) {
		// myFrame.top3Part = new Profiles();
		// myFrame.top3Part.posInUse = false;
		// }
		// if (!myParentO.bot1Part.posInUse) {
		// myFrame.bot1Part = new Profiles();
		// myFrame.bot1Part.posInUse = false;
		// }
		// if (!myParentO.bot2Part.posInUse) {
		// myFrame.bot2Part = new Profiles();
		// myFrame.bot2Part.posInUse = false;
		// }
		// if (!myParentO.bot3Part.posInUse) {
		// myFrame.bot3Part = new Profiles();
		// myFrame.bot3Part.posInUse = false;
		// }
		// if (!myParentO.leftPart.posInUse) {
		// myFrame.leftPart = new Profiles();
		// myFrame.leftPart.posInUse = false;
		// }
		// if (!myParentO.rightPart.posInUse) {
		// myFrame.rightPart = new Profiles();
		// myFrame.rightPart.posInUse = false;
		// }
		
		return myFrame;
	}
	
	public Object[] setPartDims(Frame myFrame, final CreateShapeMethods createShape, final boolean recalcFrame)
	{
	
		final Object[] myreturns = new Object[2];

        if (recalcFrame) {
//            myFrame.executePartRules(false, false, "createFrames.setpartDims.450");
            myFrame.executePartRules(false);
        }

        myFrame.top1Part.lengthMN = (int) (myFrame.top1Part.length / myFrame2.metricscale.doubleValue());
		myFrame.top1Part.lengthIN = (int) (myFrame.top1Part.length / myFrame2.imperialscale.doubleValue());
		
		myFrame.top2Part.lengthMN = (int) (myFrame.top2Part.length / myFrame2.metricscale.doubleValue());
		myFrame.top2Part.lengthIN = (int) (myFrame.top2Part.length / myFrame2.imperialscale.doubleValue());
		
		myFrame.top3Part.lengthMN = (int) (myFrame.top3Part.length / myFrame2.metricscale.doubleValue());
		myFrame.top3Part.lengthIN = (int) (myFrame.top3Part.length / myFrame2.imperialscale.doubleValue());
		
		myFrame.bot1Part.lengthMN = (int) (myFrame.bot1Part.length / myFrame2.metricscale.doubleValue());
		myFrame.bot1Part.lengthIN = (int) (myFrame.bot1Part.length / myFrame2.imperialscale.doubleValue());
		
		myFrame.bot2Part.lengthMN = (int) (myFrame.bot2Part.length / myFrame2.metricscale.doubleValue());
		myFrame.bot2Part.lengthIN = (int) (myFrame.bot2Part.length / myFrame2.imperialscale.doubleValue());
		
		myFrame.bot3Part.lengthMN = (int) (myFrame.bot3Part.length / myFrame2.metricscale.doubleValue());
		myFrame.bot3Part.lengthIN = (int) (myFrame.bot3Part.length / myFrame2.imperialscale.doubleValue());
		
		myFrame.leftPart.lengthMN = (int) (myFrame.leftPart.length / myFrame2.metricscale.doubleValue());
		myFrame.leftPart.lengthIN = (int) (myFrame.leftPart.length / myFrame2.imperialscale.doubleValue());
		
		myFrame.rightPart.lengthMN = (int) (myFrame.rightPart.length / myFrame2.metricscale.doubleValue());
		myFrame.rightPart.lengthIN = (int) (myFrame.rightPart.length / myFrame2.imperialscale.doubleValue());
		
		myFrame = (Frame) this.myFrame2.shapeColor.setShapeObjectPartColors(myFrame);
		
		if (myFrame2.mySeries.getSeriesUom() == 1)
		{
			createShape.top1DimBo = createShape.top1DimB = myFrame.top1Part.partDimBi = myFrame.top1Part.partDimB;
			createShape.top1DimAo = createShape.top1DimA = myFrame.top1Part.partDimAi = myFrame.top1Part.partDimA;
			createShape.top1DimCo = createShape.top1DimC = myFrame.top1Part.partDimCi = myFrame.top1Part.partDimC;
			createShape.top1DimMo = createShape.top1DimM = myFrame.top1Part.partDimMi = myFrame.top1Part.partDimM;
			createShape.top2DimBo = createShape.top2DimB = myFrame.top2Part.partDimBi = myFrame.top2Part.partDimB;
			createShape.top2DimAo = createShape.top2DimA = myFrame.top2Part.partDimAi = myFrame.top2Part.partDimA;
			createShape.top2DimCo = createShape.top2DimC = myFrame.top3Part.partDimCi = myFrame.top2Part.partDimC;
			createShape.top2DimMo = createShape.top2DimM = myFrame.top3Part.partDimMi = myFrame.top2Part.partDimM;
			createShape.top3DimBo = createShape.top3DimB = myFrame.top3Part.partDimBi = myFrame.top3Part.partDimB;
			createShape.top3DimAo = createShape.top3DimA = myFrame.top3Part.partDimAi = myFrame.top3Part.partDimA;
			createShape.top3DimCo = createShape.top3DimC = myFrame.top3Part.partDimCi = myFrame.top3Part.partDimC;
			createShape.top3DimMo = createShape.top3DimM = myFrame.top3Part.partDimMi = myFrame.top3Part.partDimM;
			
			createShape.bot1DimBo = createShape.bot1DimB = myFrame.bot1Part.partDimBi = myFrame.bot1Part.partDimB;
			createShape.bot1DimAo = createShape.bot1DimA = myFrame.bot1Part.partDimAi = myFrame.bot1Part.partDimA;
			createShape.bot1DimCo = createShape.bot1DimC = myFrame.bot1Part.partDimCi = myFrame.bot1Part.partDimC;
			createShape.bot1DimMo = createShape.bot1DimM = myFrame.bot1Part.partDimMi = myFrame.bot1Part.partDimM;
			createShape.bot2DimBo = createShape.bot2DimB = myFrame.bot2Part.partDimBi = myFrame.bot2Part.partDimB;
			createShape.bot2DimAo = createShape.bot2DimA = myFrame.bot2Part.partDimAi = myFrame.bot2Part.partDimA;
			createShape.bot2DimCo = createShape.bot2DimC = myFrame.bot2Part.partDimCi = myFrame.bot2Part.partDimC;
			createShape.bot2DimMo = createShape.bot2DimM = myFrame.bot2Part.partDimMi = myFrame.bot2Part.partDimM;
			createShape.bot3DimBo = createShape.bot3DimB = myFrame.bot3Part.partDimBi = myFrame.bot3Part.partDimB;
			createShape.bot3DimAo = createShape.bot3DimA = myFrame.bot3Part.partDimAi = myFrame.bot3Part.partDimA;
			createShape.bot3DimCo = createShape.bot3DimC = myFrame.bot3Part.partDimCi = myFrame.bot3Part.partDimC;
			createShape.bot3DimMo = createShape.bot3DimM = myFrame.bot3Part.partDimMi = myFrame.bot3Part.partDimM;
			
			createShape.leftDimBo = createShape.leftDimB = myFrame.leftPart.partDimBi = myFrame.leftPart.partDimB;
			createShape.leftDimAo = createShape.leftDimA = myFrame.leftPart.partDimAi = myFrame.leftPart.partDimA;
			createShape.leftDimCo = createShape.leftDimC = myFrame.leftPart.partDimCi = myFrame.leftPart.partDimC;
			createShape.leftDimMo = createShape.leftDimM = myFrame.leftPart.partDimMi = myFrame.leftPart.partDimM;
			createShape.rightDimBo = createShape.rightDimB = myFrame.rightPart.partDimBi = myFrame.rightPart.partDimB;
			createShape.rightDimAo = createShape.rightDimA = myFrame.rightPart.partDimAi = myFrame.rightPart.partDimA;
			createShape.rightDimCo = createShape.rightDimC = myFrame.rightPart.partDimCi = myFrame.rightPart.partDimC;
			createShape.rightDimMo = createShape.rightDimM = myFrame.rightPart.partDimMi = myFrame.rightPart.partDimM;
		}
		else
		{
			createShape.top1DimBo = createShape.top1DimB = myFrame.top1Part.partDimB = myFrame.top1Part.partDimBi;
			createShape.top1DimAo = createShape.top1DimA = myFrame.top1Part.partDimA = myFrame.top1Part.partDimAi;
			createShape.top1DimCo = createShape.top1DimC = myFrame.top1Part.partDimC = myFrame.top1Part.partDimCi;
			createShape.top1DimMo = createShape.top1DimM = myFrame.top1Part.partDimM = myFrame.top1Part.partDimMi;
			createShape.top2DimBo = createShape.top2DimB = myFrame.top2Part.partDimB = myFrame.top2Part.partDimBi;
			createShape.top2DimAo = createShape.top2DimA = myFrame.top2Part.partDimA = myFrame.top2Part.partDimAi;
			createShape.top2DimCo = createShape.top2DimC = myFrame.top3Part.partDimC = myFrame.top2Part.partDimCi;
			createShape.top2DimMo = createShape.top2DimM = myFrame.top3Part.partDimM = myFrame.top2Part.partDimMi;
			createShape.top3DimBo = createShape.top3DimB = myFrame.top3Part.partDimB = myFrame.top3Part.partDimBi;
			createShape.top3DimAo = createShape.top3DimA = myFrame.top3Part.partDimA = myFrame.top3Part.partDimAi;
			createShape.top3DimCo = createShape.top3DimC = myFrame.top3Part.partDimC = myFrame.top3Part.partDimCi;
			createShape.top3DimMo = createShape.top3DimM = myFrame.top3Part.partDimM = myFrame.top3Part.partDimMi;
			
			createShape.bot1DimBo = createShape.bot1DimB = myFrame.bot1Part.partDimB = myFrame.bot1Part.partDimBi;
			createShape.bot1DimAo = createShape.bot1DimA = myFrame.bot1Part.partDimA = myFrame.bot1Part.partDimAi;
			createShape.bot1DimCo = createShape.bot1DimC = myFrame.bot1Part.partDimC = myFrame.bot1Part.partDimCi;
			createShape.bot1DimMo = createShape.bot1DimM = myFrame.bot1Part.partDimM = myFrame.bot1Part.partDimMi;
			createShape.bot2DimBo = createShape.bot2DimB = myFrame.bot2Part.partDimB = myFrame.bot2Part.partDimBi;
			createShape.bot2DimAo = createShape.bot2DimA = myFrame.bot2Part.partDimA = myFrame.bot2Part.partDimAi;
			createShape.bot2DimCo = createShape.bot2DimC = myFrame.bot2Part.partDimC = myFrame.bot2Part.partDimCi;
			createShape.bot2DimMo = createShape.bot2DimM = myFrame.bot2Part.partDimM = myFrame.bot2Part.partDimMi;
			createShape.bot3DimBo = createShape.bot3DimB = myFrame.bot3Part.partDimB = myFrame.bot3Part.partDimBi;
			createShape.bot3DimAo = createShape.bot3DimA = myFrame.bot3Part.partDimA = myFrame.bot3Part.partDimAi;
			createShape.bot3DimCo = createShape.bot3DimC = myFrame.bot3Part.partDimC = myFrame.bot3Part.partDimCi;
			createShape.bot3DimMo = createShape.bot3DimM = myFrame.bot3Part.partDimM = myFrame.bot3Part.partDimMi;
			
			createShape.leftDimBo = createShape.leftDimB = myFrame.leftPart.partDimB = myFrame.leftPart.partDimBi;
			createShape.leftDimAo = createShape.leftDimA = myFrame.leftPart.partDimA = myFrame.leftPart.partDimAi;
			createShape.leftDimCo = createShape.leftDimC = myFrame.leftPart.partDimC = myFrame.leftPart.partDimCi;
			createShape.leftDimMo = createShape.leftDimM = myFrame.leftPart.partDimM = myFrame.leftPart.partDimMi;
			createShape.rightDimBo = createShape.rightDimB = myFrame.rightPart.partDimB = myFrame.rightPart.partDimBi;
			createShape.rightDimAo = createShape.rightDimA = myFrame.rightPart.partDimA = myFrame.rightPart.partDimAi;
			createShape.rightDimCo = createShape.rightDimC = myFrame.rightPart.partDimC = myFrame.rightPart.partDimCi;
			createShape.rightDimMo = createShape.rightDimM = myFrame.rightPart.partDimM = myFrame.rightPart.partDimMi;
		}
		
		myreturns[0] = myFrame;
		myreturns[1] = createShape;
		
		return myreturns;
	}
	
	// public Frame cloneFrameFromParentOpening(final Frame myframe) {
	//
	// myframe.myFrame2 = myFrame2;
	// myframe.myParentO = myParentO;
	// myframe.a_sequenceID = myParentO.a_sequenceID;
	//
	// myframe.a_1Level = myParentO.a_assemblyLevel;
	// myframe.a_1Sequence = myParentO.a_sequenceID;
	// myframe.a_2Level = myParentO.a_1Level;
	// myframe.a_2Sequence = myParentO.a_1Sequence;
	// myframe.a_3Level = myParentO.a_2Level;
	// myframe.a_3Sequence = myParentO.a_2Sequence;
	// myframe.a_4Level = myParentO.a_3Level;
	// myframe.a_4Sequence = myParentO.a_3Sequence;
	//
	// myframe.a_5Level = myParentO.a_4Level;
	// myframe.a_5Sequence = myParentO.a_4Sequence;
	// myframe.a_6Level = myParentO.a_5Level;
	// myframe.a_6Sequence = myParentO.a_5Sequence;
	// myframe.a_7Level = myParentO.a_6Level;
	// myframe.a_7Sequence = myParentO.a_6Sequence;
	// myframe.a_8Level = myParentO.a_7Level;
	// myframe.a_8Sequence = myParentO.a_7Sequence;
	// myframe.a_9Level = myParentO.a_8Level;
	// myframe.a_9Sequence = myParentO.a_8Sequence;
	// myframe.a_10Level = myParentO.a_9Level;
	// myframe.a_10Sequence = myParentO.a_9Sequence;
	//
	//
	// myframe.shapeID = myParentO.shapeID;
	//
	// myframe.highestY = myParentO.highestY;
	// myframe.highestYC = myParentO.highestYC;
	//
	// myframe.lowestY = myParentO.lowestY;
	// myframe.lowestYC = myParentO.lowestYC;
	//
	// myframe.startingX = myParentO.startingX;
	// myframe.startingY = myParentO.startingY;
	//
	// myframe.startCol = myParentO.startCol;
	// myframe.endCol = myParentO.endCol;
	// myframe.startRow = myParentO.startRow;
	// myframe.endRow = myParentO.endRow;
	//
	// myframe.rID = myParentO.rID;
	//
	// myframe.widthPix = myParentO.widthPix;
	// myframe.heightPix = myParentO.heightPix;
	//
	// myframe.widthM = myParentO.widthM;
	// myframe.widthMN = myParentO.widthMN;
	// myframe.heightM = myParentO.heightM;
	// myframe.heightMN = myParentO.heightMN;
	//
	// myframe.widthI = myParentO.widthI;
	// myframe.widthIN = myParentO.widthIN;
	// myframe.heightI = myParentO.heightI;
	// myframe.heightIN = myParentO.heightIN;
	//
	// myframe.shapeID = myParentO.shapeID;
	//
	// myframe.startingX = myParentO.startingX;
	// myframe.startingY = myParentO.startingY;
	//
	// myframe.a_sequenceID = myParentO.a_sequenceID;
	//
	// myframe.radius1 = myParentO.radius1;
	// myframe.radius2 = myParentO.radius2;
	//
	// myframe.myParent = myframe.myOverall = myframe.myFacet =
	// myParentO.myParent;
	//
	// myframe.shapeChanged = myParentO.shapeChanged;
	//
	// myframe.bkgrdStartX = myParentO.bkgrdStartX;
	// myframe.bkgrdStartY = myParentO.bkgrdStartY;
	//
	// myframe.noSides = myParentO.noSides;
	// myframe.noSidesTop = myParentO.noSidesTop;
	// myframe.noSidesBot = myParentO.noSidesBot;
	// myframe.noSidesLeft = myParentO.noSidesLeft;
	// myframe.noSidesRight = myParentO.noSidesRight;
	//
	// myframe.centerPointX = myParentO.centerPointX;
	// myframe.centerPointX2 = myParentO.centerPointX2;
	// myframe.centerPointY = myParentO.centerPointY;
	// myframe.centerPointY2 = myParentO.centerPointY2;
	//
	// myframe.bX2 = myParentO.bX2;
	// myframe.bY2 = myParentO.bY2;
	// myframe.bX3 = myParentO.bX3;
	// myframe.bY3 = myParentO.bY3;
	// myframe.bX4 = myParentO.bX4;
	// myframe.bY4 = myParentO.bY4;
	//
	// myframe.startingCX = myParentO.startingCX;
	// myframe.startingCY = myParentO.startingCY;
	//
	// myframe.bCX2 = myParentO.bCX2;
	// myframe.bCY2 = myParentO.bCY2;
	// myframe.bCX3 = myParentO.bCX3;
	// myframe.bCY3 = myParentO.bCY3;
	// myframe.bCX4 = myParentO.bCX4;
	// myframe.bCY4 = myParentO.bCY4;
	//
	// myframe.dimA1 = myParentO.dimA1;
	// myframe.dimA2 = myParentO.dimA2;
	// myframe.dimA3 = myParentO.dimA3;
	// myframe.dimA4 = myParentO.dimA4;
	// myframe.dimA5 = myParentO.dimA5;
	// myframe.dimA0 = myParentO.dimA0;
	// myframe.dimB1 = myParentO.dimB1;
	// myframe.dimB2 = myParentO.dimB2;
	// myframe.dimB3 = myParentO.dimB3;
	// myframe.dimB4 = myParentO.dimB4;
	// myframe.dimB5 = myParentO.dimB5;
	// myframe.dimB0 = myParentO.dimB0;
	// myframe.dimC1 = myParentO.dimC1;
	// myframe.dimC2 = myParentO.dimC2;
	// myframe.dimC3 = myParentO.dimC3;
	// myframe.dimC4 = myParentO.dimC4;
	// myframe.dimC5 = myParentO.dimC5;
	// myframe.dimC0 = myParentO.dimC0;
	// myframe.dimD1 = myParentO.dimD1;
	// myframe.dimD2 = myParentO.dimD2;
	// myframe.dimD3 = myParentO.dimD3;
	// myframe.dimD4 = myParentO.dimD4;
	// myframe.dimD5 = myParentO.dimD5;
	// myframe.dimD0 = myParentO.dimD0;
	//
	// myframe.dimTM = myParentO.dimTM;
	// myframe.dimBM = myParentO.dimBM;
	// myframe.dimLM = myParentO.dimLM;
	// myframe.dimRM = myParentO.dimRM;
	// myframe.dimTA = myParentO.dimTA;
	// myframe.dimBA = myParentO.dimBA;
	// myframe.dimLA = myParentO.dimLA;
	// myframe.dimRA = myParentO.dimRA;
	//
	// myframe.topIn = myParentO.topIn;
	// myframe.botIn = myParentO.botIn;
	// myframe.leftIn = myParentO.leftIn;
	// myframe.rightIn = myParentO.rightIn;
	//
	// myframe.lean = myParentO.lean;
	// myframe.lean2 = myParentO.lean2;
	// myframe.lean3 = myParentO.lean3;
	// myframe.lean4 = myParentO.lean4;
	//
	// myframe.parentH = myParentO.parentH;
	// myframe.parentW = myParentO.parentW;
	//
	// myframe.parentStartY = myParentO.parentStartY;
	// myframe.parentStartX = myParentO.parentStartX;
	// myframe.parentRadius1 = myParentO.parentRadius1;// *
	// // 2;
	//
	// myframe.parentCX = myParentO.parentCX;
	// myframe.parentCY = myParentO.parentCY;
	// myframe.parentCX2 = myParentO.parentCX2;
	// myframe.parentCY2 = myParentO.parentCY2;
	// myframe.parentShape = myParentO.parentShape;
	//
	// myframe.px1 = myParentO.px1;
	// myframe.py1 = myParentO.py1;
	// myframe.px2 = myParentO.px2;
	// myframe.py2 = myParentO.py2;
	// myframe.px3 = myParentO.px3;
	// myframe.py3 = myParentO.py3;
	// myframe.px4 = myParentO.px4;
	// myframe.py4 = myParentO.py4;
	// myframe.px5 = myParentO.px5;
	// myframe.py5 = myParentO.py5;
	// myframe.px6 = myParentO.px6;
	// myframe.py6 = myParentO.py6;
	// myframe.px7 = myParentO.px7;
	// myframe.py7 = myParentO.py7;
	// myframe.px8 = myParentO.px8;
	// myframe.py8 = myParentO.py8;
	//
	// myframe.startingCX = myParentO.startingCX;
	// myframe.startingCY = myParentO.startingCY;
	//
	// myframe.px1c = myParentO.px1c;
	// myframe.py1c = myParentO.py1c;
	// myframe.px2c = myParentO.px2c;
	// myframe.py2c = myParentO.py2c;
	// myframe.px3c = myParentO.px3c;
	// myframe.py3c = myParentO.py3c;
	// myframe.px4c = myParentO.px4c;
	// myframe.py4c = myParentO.py4c;
	// myframe.px5c = myParentO.px5c;
	// myframe.py5c = myParentO.py5c;
	// myframe.px6c = myParentO.px6c;
	// myframe.py6c = myParentO.py6c;
	// myframe.px7c = myParentO.px7c;
	// myframe.py7c = myParentO.py7c;
	// myframe.px8c = myParentO.px8c;
	// myframe.py8c = myParentO.py8c;
	//
	// myframe.bCX2 = myParentO.bCX2;
	// myframe.bCY2 = myParentO.bCY2;
	// myframe.bCX3 = myParentO.bCX3;
	// myframe.bCY3 = myParentO.bCY3;
	// myframe.bCX4 = myParentO.bCX4;
	// myframe.bCY4 = myParentO.bCY4;
	//
	// // myframe.top1Part =
	// // myframe.top1Part.cloneProfile(myParentO.top1Part);
	// // myframe.top2Part =
	// // myframe.top2Part.cloneProfile(myParentO.top2Part);
	// // myframe.top3Part =
	// // myframe.top3Part.cloneProfile(myParentO.top3Part);
	// // myframe.bot1Part =
	// // myframe.bot1Part.cloneProfile(myParentO.bot1Part);
	// // myframe.bot2Part =
	// // myframe.bot2Part.cloneProfile(myParentO.bot2Part);
	// // myframe.bot3Part =
	// // myframe.bot3Part.cloneProfile(myParentO.bot3Part);
	// // myframe.leftPart =
	// // myframe.leftPart.cloneProfile(myParentO.leftPart);
	// // myframe.rightPart =
	// // myframe.rightPart.cloneProfile(myParentO.rightPart);
	//
	// myframe.top1Part = (Profiles)
	// myframe.top1Part.cloneProfile(myParentO.top1Part);
	// myframe.top2Part = (Profiles)
	// myframe.top2Part.cloneProfile(myParentO.top2Part);
	// myframe.top3Part = (Profiles)
	// myframe.top3Part.cloneProfile(myParentO.top3Part);
	// myframe.rightPart = (Profiles)
	// myframe.rightPart.cloneProfile(myParentO.rightPart);
	// myframe.leftPart = (Profiles)
	// myframe.leftPart.cloneProfile(myParentO.leftPart);
	// myframe.bot1Part = (Profiles)
	// myframe.bot1Part.cloneProfile(myParentO.bot1Part);
	// myframe.bot2Part = (Profiles)
	// myframe.bot2Part.cloneProfile(myParentO.bot2Part);
	// myframe.bot3Part = (Profiles)
	// myframe.bot3Part.cloneProfile(myParentO.bot3Part);
	//
	// return myframe;
	// }
	
}

/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Operations;


import Model.Facet;
import Model.OpeningObject;
import Model.ProfileParts.Profiles;
import Model.ProfileParts.Top2Object;
import Model.ShapeObject;
import Presentation.ItemFrame;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

// import Model.ProfileParts.Top1Object;
// import Model.ProfileParts.Top2Object;
// import Model.ProfileParts.Top3Object;
// import Model.ProfileParts.Bot1Object;
// import Model.ProfileParts.Bot2Object;
// import Model.ProfileParts.Bot3Object;
// import Model.ProfileParts.LeftObject;
// import Model.ProfileParts.RightObject;


public class CreateFacets {
	
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
	
	Facet myFacetUsed;
	
	boolean recalcFacet = false;
	
	public Collection myExistingFacets = new ArrayList();
	
	public CreateFacets(OpeningObject facet, Collection existingfacets, ItemFrame myFacet) {
		myParentO = facet;
		myFrame2 = myFacet;
		scale = myFrame2.scale;
		myExistingFacets = existingfacets;
	}
	
	/**
	 * Do Facet
	 *
	 * @param sameParts,   boolean
	 * @param recalcFrame, boolean
	 * @param isSub,       boolean
	 * @return
	 */
	public Facet doFacet(boolean sameParts, boolean recalcFrame, boolean isSub, boolean equalize) throws Exception {
		
		this.recalcFacet = recalcFrame;
		
		Facet myFacet = new Facet();
		if (!sameParts) {
			openingChanged = true;
			myFacet.shapeChanged = true;
		} else {
			myFacet.isNewFrame = false;
		}
		
		this.myFrame2.topRowShapes.clear();
		
		myFacet = this.initSashLeaf(myParentO.topIn, myParentO.botIn, myParentO.leftIn, myParentO.rightIn);
		
		CreateShapeMethods createShape = new CreateShapeMethods(myParentO, 2, myFrame2);
		
		if (myFrame2.jobItem.myCanvas != null && myFacet.startCol == myFrame2.jobItem.myCanvas.selectedfBot) {
			myFacet.inUse = true;
		} else {
			myFacet.inUse = false;
		}
		
		if (myFrame2.facetUsed != null && myFacet.inUse && !isSub) {
			myFrame2.facetUsed.widthPix = myFacet.widthPix;
			myFrame2.facetUsed.heightPix = myFacet.heightPix;
			myFrame2.facetUsed.widthM = myFrame2.facetUsed.widthMO = myFacet.widthMO;
			myFrame2.facetUsed.heightM = myFrame2.facetUsed.heightMO = myFacet.heightMO;
			myFrame2.facetUsed.widthI = myFrame2.facetUsed.widthIO = myFacet.widthIO;
			myFrame2.facetUsed.heightI = myFrame2.facetUsed.heightIO = myFacet.heightIO;
		}
		
		if (myFacet != null && myExistingFacets.size() > 0) {
			
			for (final Object S : myExistingFacets.toArray()) {
				if (((Facet) S).a_sequenceID == myFacet.a_sequenceID) {
					
				
					
					
					if (myParentO.shapeID == ((Facet) S).shapeID && !((Facet) S).shapeChanged
								&& myParentO.noSides == ((Facet) S).noSides
								&& myParentO.noSidesTop == ((Facet) S).noSidesTop
								&& myParentO.noSidesBot == ((Facet) S).noSidesBot
								&& myParentO.noSidesLeft == ((Facet) S).noSidesLeft
								&& myParentO.noSidesRight == ((Facet) S).noSidesRight) {
						
						if (myFacet.autoW && !myFrame2.mullionsPanel.divideFacet) {
							myFacet.widthIO = ((Facet) S).widthIO;
							myFacet.heightIO = ((Facet) S).heightIO;
							myFacet.originalScaleI = ((Facet) S).originalScaleI;
							myFacet.widthMO = ((Facet) S).widthMO;
							myFacet.heightMO = ((Facet) S).heightMO;
							myFacet.originalScaleM = ((Facet) S).originalScaleM;
						}
					}
					break;
				}
			}
		}
		
		Object[] returns = this.setPartDims(myFacet, createShape);
		
		myFacet = (Facet) returns[0];
		createShape = (CreateShapeMethods) returns[1];
		
		if (!myParentO.top2Part.posInUse) {
			myFacet.top2Part = (Profiles) myFacet.top2Part.cloneProfile(myFacet.top1Part);
			myFacet.top2Part.lengthM = 0;
			myFacet.top2Part.lengthI = 0;
			myFacet.top2Part.posInUse = false;
			
			myFacet.top2 = (Top2Object) myFacet.top2.cloneProfile(myFacet.top2Part);
			
			myFacet.top2.posInUse = false;
		}
		
		createShape.getClearance(myFacet);
		
		myFacet = (Facet) createShape.doShapeBkgrd(myFacet);
		myFacet = (Facet) createShape.makeSides(myFacet);
		myFacet = (Facet) createShape.makeSidesStraight(myFacet);
		myFacet = (Facet) createShape.doParts(myFacet, true);
		myFacet = (Facet) createShape.setBaseInfo(myFacet, 1, true);
		
		
		
		((ShapeObject) myFacet).setPartObjectsFromProfiles();
		
//		myFacet.bom.clear();
//		myFacet.clearBomForShape();
//		myFacet.executePartRules(true, true, "createFacets.doFacet.211");
		
		myFacet.bOpeningObject = myFacet.doMainOpening();
		
		myFacet.bOpeningObject.unGlazed = true;
		
		if (!myFrame2.isUndo && myFacet.bOpeningObject.mullions.size() > 0){
			myFacet.bOpeningObject = myFacet.bOpeningObject.modifyVMCEqualize(myFacet.bOpeningObject);
			
		}
		
		if(myFacet.bOpeningObject.mullionsH.size() > 0) {
			myFacet.bOpeningObject = myFacet.bOpeningObject.modifyHMCEqualize(myFacet.bOpeningObject);
		}
		
		if (myFacet.bOpeningObject.mullions.size() > 0 || myFacet.bOpeningObject.mullionsH.size() > 0) {
			myFacet.doOpenings();
		}
		
		Object[] oPenings = myFacet.openings.toArray();
		
		myFacet.openings.clear();
		
		for (Object O : oPenings) {
			((OpeningObject) O).myParent = myFacet;
			myFacet.openings.add(O);
		}
		
		myFacet.doMullions(myFacet.bOpeningObject);
		
		myFacet.partObjects = createShape.doGPParts(myFacet.partObjects, myFacet, myFacet.glazedOut);
		
		double minY = 0;
		if (myFacet.shapeID < 800) {
			
			for (Object p : myFacet.partObjects) {
				if (Math.max(((Profiles) p).startYC,((Profiles) p).endYC) > minY) {
					minY =Math.max(((Profiles) p).startYC, ((Profiles) p).endYC);
				}
			}
			
			// myFacet.lowestYC = myFacet.lowestY = minY;
			
			if (myFacet.topIn && myFacet.myMullionTop != null) {
				myFacet.highestYC = myFacet.myMullionTop.centerYs;
				
			}
			if (myFacet.botIn && myFacet.myMullionBot != null) {
				myFacet.lowestYC = myFacet.myMullionBot.centerYs;
				
			}
		}
		
		
//		myFacet.options.clear();
//		myFacet.executeOptionRules("createFacets.doFacet.211");
//		
//		myFacet.bom.clear();
//		myFacet.clearBomForShape();
//		myFacet.executePartRules(true, true, "createFacets.doFacet.211");
		
		createShape = null;
		
		myFacet.glazedOut = false;
		myFacet.shapeChanged = false;
		return myFacet;
		
	}
	
	public Facet initSashLeaf(boolean topIn, boolean botIn, boolean leftIn, boolean rightIn) {
		
		Facet myFacet = new Facet();
		
		myFacet = (Facet) myFacet.cloneShapeFromParentOpening(myParentO);
		
		myFacet.a_levelID = 1;
		
		myFacet.options.clear();
		myFacet.executeOptionRules("createFacets.initSashLeaf.234");
		
		if (myExistingFacets.size() > 0)
		{
			
			for (final Object S : myExistingFacets.toArray()) {
				if (((Facet) S).a_sequenceID == myFacet.a_sequenceID)
				{
					myFacet.autoW = ((Facet) S).autoW;
					myFacet.newPart = ((Facet) S).newPart;
					myFacet.xCols = ((Facet) S).xCols;
					myFacet.yRows = ((Facet) S).yRows;
					myFacet.bOpeningObject = ((Facet) S).bOpeningObject.cloneBkgrdOpening(((Facet) S).bOpeningObject);
					myFacet.openings.addAll(((Facet) S).openings);
					
					myFacet.frames.addAll(((Facet) S).frames);
				
					
					myFacet.shapeChanged = ((Facet) S).shapeChanged;
					
					if (((Facet) S).shapeID != 1 && !recalcFacet) {
						myFacet.shapeID = ((Facet) S).shapeID;
						myFacet.bOpeningObject.shapeID = ((Facet) S).shapeID;
						myFacet.setShapeDims(((Facet) S));
						myFacet.shapeChanged = true;
						if (myParentO.shapeID == 1) {
							myFacet.shapeID = ((Facet) S).shapeID;
						}
					}
					
					break;
				}
			}
		}
		
		if (myFrame2.facetUsed != null && myFacet.a_sequenceID != myFrame2.facetUsed.a_sequenceID) {
			
			myFacet.widthPix = myParentO.widthPix;
			myFacet.heightPix = myParentO.heightPix;
			
			myFacet.widthM = myFacet.widthMO = (int) (myParentO.widthPix / myFrame2.metricscale.doubleValue());
			myFacet.widthI = myFacet.widthIO = (int) (myParentO.widthPix / myFrame2.imperialscale.doubleValue());
			
			myFacet.heightM = myFacet.heightMO = (int) (myParentO.heightPix / myFrame2.metricscale.doubleValue());
			myFacet.heightI = myFacet.heightIO = (int) (myParentO.heightPix / myFrame2.imperialscale.doubleValue());
			
		} else if (myFrame2.facetUsed != null && myFacet.a_sequenceID == myFrame2.facetUsed.a_sequenceID) {
			
			myFacet.widthPix = myParentO.widthPix;
			myFacet.heightPix = myParentO.heightPix;
			
			myFacet.widthM = myFacet.widthMO = myParentO.widthMO;
			myFacet.widthI = myFacet.widthIO = myParentO.widthIO;
			
			myFacet.heightM = myFacet.heightMO = myParentO.heightMO;
			myFacet.heightI = myFacet.heightIO = myParentO.heightIO;
		}
		
		if (myParentO.shapeID != 1) {
			
		}
		
		// myFacet.executeClearanceRules();
		//		myFacet.executePartRules();
		
		return myFacet;
	}
	
	
	public Object[] setPartDims(Facet myFacet, CreateShapeMethods createShape) {
		
		final Object[] myreturns = new Object[2];
		
//		myFacet.executePartRules(false, false, "createFacet.setpartDims.310");
		myFacet.executePartRules(false);
		myFacet.top1Part.lengthMN = (int) (myFacet.top1Part.length / myFrame2.metricscale.doubleValue());
		myFacet.top1Part.lengthIN = (int) (myFacet.top1Part.length / myFrame2.imperialscale.doubleValue());
		
		myFacet.top2Part.lengthMN = (int) (myFacet.top2Part.length / myFrame2.metricscale.doubleValue());
		myFacet.top2Part.lengthIN = (int) (myFacet.top2Part.length / myFrame2.imperialscale.doubleValue());
		
		myFacet.top3Part.lengthMN = (int) (myFacet.top3Part.length / myFrame2.metricscale.doubleValue());
		myFacet.top3Part.lengthIN = (int) (myFacet.top3Part.length / myFrame2.imperialscale.doubleValue());
		
		myFacet.bot1Part.lengthMN = (int) (myFacet.bot1Part.length / myFrame2.metricscale.doubleValue());
		myFacet.bot1Part.lengthIN = (int) (myFacet.bot1Part.length / myFrame2.imperialscale.doubleValue());
		
		myFacet.bot2Part.lengthMN = (int) (myFacet.bot2Part.length / myFrame2.metricscale.doubleValue());
		myFacet.bot2Part.lengthIN = (int) (myFacet.bot2Part.length / myFrame2.imperialscale.doubleValue());
		
		myFacet.bot3Part.lengthMN = (int) (myFacet.bot3Part.length / myFrame2.metricscale.doubleValue());
		myFacet.bot3Part.lengthIN = (int) (myFacet.bot3Part.length / myFrame2.imperialscale.doubleValue());
		
		myFacet.leftPart.lengthMN = (int) (myFacet.leftPart.length / myFrame2.metricscale.doubleValue());
		myFacet.leftPart.lengthIN = (int) (myFacet.leftPart.length / myFrame2.imperialscale.doubleValue());
		
		myFacet.rightPart.lengthMN = (int) (myFacet.rightPart.length / myFrame2.metricscale.doubleValue());
		myFacet.rightPart.lengthIN = (int) (myFacet.rightPart.length / myFrame2.imperialscale.doubleValue());
		
		myFacet = (Facet) this.myFrame2.shapeColor.setShapeObjectPartColors(myFacet);

		if (myFrame2.mySeries.getSeriesUom() == 1)
		{
			createShape.top1DimBo = createShape.top1DimB = myFacet.top1Part.partDimBi = myFacet.top1Part.partDimB;
			createShape.top1DimAo = createShape.top1DimA = myFacet.top1Part.partDimAi = myFacet.top1Part.partDimA;
			createShape.top1DimCo = createShape.top1DimC = myFacet.top1Part.partDimCi = myFacet.top1Part.partDimC;
			createShape.top1DimMo = createShape.top1DimM = myFacet.top1Part.partDimMi = myFacet.top1Part.partDimM;
			createShape.top2DimBo = createShape.top2DimB = myFacet.top2Part.partDimBi = myFacet.top2Part.partDimB;
			createShape.top2DimAo = createShape.top2DimA = myFacet.top2Part.partDimAi = myFacet.top2Part.partDimA;
			createShape.top2DimCo = createShape.top2DimC = myFacet.top3Part.partDimCi = myFacet.top2Part.partDimC;
			createShape.top2DimMo = createShape.top2DimM = myFacet.top3Part.partDimMi = myFacet.top2Part.partDimM;
			createShape.top3DimBo = createShape.top3DimB = myFacet.top3Part.partDimBi = myFacet.top3Part.partDimB;
			createShape.top3DimAo = createShape.top3DimA = myFacet.top3Part.partDimAi = myFacet.top3Part.partDimA;
			createShape.top3DimCo = createShape.top3DimC = myFacet.top3Part.partDimCi = myFacet.top3Part.partDimC;
			createShape.top3DimMo = createShape.top3DimM = myFacet.top3Part.partDimMi = myFacet.top3Part.partDimM;
			
			createShape.bot1DimBo = createShape.bot1DimB = myFacet.bot1Part.partDimBi = myFacet.bot1Part.partDimB;
			createShape.bot1DimAo = createShape.bot1DimA = myFacet.bot1Part.partDimAi = myFacet.bot1Part.partDimA;
			createShape.bot1DimCo = createShape.bot1DimC = myFacet.bot1Part.partDimCi = myFacet.bot1Part.partDimC;
			createShape.bot1DimMo = createShape.bot1DimM = myFacet.bot1Part.partDimMi = myFacet.bot1Part.partDimM;
			createShape.bot2DimBo = createShape.bot2DimB = myFacet.bot2Part.partDimBi = myFacet.bot2Part.partDimB;
			createShape.bot2DimAo = createShape.bot2DimA = myFacet.bot2Part.partDimAi = myFacet.bot2Part.partDimA;
			createShape.bot2DimCo = createShape.bot2DimC = myFacet.bot2Part.partDimCi = myFacet.bot2Part.partDimC;
			createShape.bot2DimMo = createShape.bot2DimM = myFacet.bot2Part.partDimMi = myFacet.bot2Part.partDimM;
			createShape.bot3DimBo = createShape.bot3DimB = myFacet.bot3Part.partDimBi = myFacet.bot3Part.partDimB;
			createShape.bot3DimAo = createShape.bot3DimA = myFacet.bot3Part.partDimAi = myFacet.bot3Part.partDimA;
			createShape.bot3DimCo = createShape.bot3DimC = myFacet.bot3Part.partDimCi = myFacet.bot3Part.partDimC;
			createShape.bot3DimMo = createShape.bot3DimM = myFacet.bot3Part.partDimMi = myFacet.bot3Part.partDimM;
			
			createShape.leftDimBo = createShape.leftDimB = myFacet.leftPart.partDimBi = myFacet.leftPart.partDimB;
			createShape.leftDimAo = createShape.leftDimA = myFacet.leftPart.partDimAi = myFacet.leftPart.partDimA;
			createShape.leftDimCo = createShape.leftDimC = myFacet.leftPart.partDimCi = myFacet.leftPart.partDimC;
			createShape.leftDimMo = createShape.leftDimM = myFacet.leftPart.partDimMi = myFacet.leftPart.partDimM;
			createShape.rightDimBo = createShape.rightDimB = myFacet.rightPart.partDimBi = myFacet.rightPart.partDimB;
			createShape.rightDimAo = createShape.rightDimA = myFacet.rightPart.partDimAi = myFacet.rightPart.partDimA;
			createShape.rightDimCo = createShape.rightDimC = myFacet.rightPart.partDimCi = myFacet.rightPart.partDimC;
			createShape.rightDimMo = createShape.rightDimM = myFacet.rightPart.partDimMi = myFacet.rightPart.partDimM;
		}
		else
		{
			createShape.top1DimBo = createShape.top1DimB = myFacet.top1Part.partDimB = myFacet.top1Part.partDimBi;
			createShape.top1DimAo = createShape.top1DimA = myFacet.top1Part.partDimA = myFacet.top1Part.partDimAi;
			createShape.top1DimCo = createShape.top1DimC = myFacet.top1Part.partDimC = myFacet.top1Part.partDimCi;
			createShape.top1DimMo = createShape.top1DimM = myFacet.top1Part.partDimM = myFacet.top1Part.partDimMi;
			createShape.top2DimBo = createShape.top2DimB = myFacet.top2Part.partDimB = myFacet.top2Part.partDimBi;
			createShape.top2DimAo = createShape.top2DimA = myFacet.top2Part.partDimA = myFacet.top2Part.partDimAi;
			createShape.top2DimCo = createShape.top2DimC = myFacet.top3Part.partDimC = myFacet.top2Part.partDimCi;
			createShape.top2DimMo = createShape.top2DimM = myFacet.top3Part.partDimM = myFacet.top2Part.partDimMi;
			createShape.top3DimBo = createShape.top3DimB = myFacet.top3Part.partDimB = myFacet.top3Part.partDimBi;
			createShape.top3DimAo = createShape.top3DimA = myFacet.top3Part.partDimA = myFacet.top3Part.partDimAi;
			createShape.top3DimCo = createShape.top3DimC = myFacet.top3Part.partDimC = myFacet.top3Part.partDimCi;
			createShape.top3DimMo = createShape.top3DimM = myFacet.top3Part.partDimM = myFacet.top3Part.partDimMi;
			
			createShape.bot1DimBo = createShape.bot1DimB = myFacet.bot1Part.partDimB = myFacet.bot1Part.partDimBi;
			createShape.bot1DimAo = createShape.bot1DimA = myFacet.bot1Part.partDimA = myFacet.bot1Part.partDimAi;
			createShape.bot1DimCo = createShape.bot1DimC = myFacet.bot1Part.partDimC = myFacet.bot1Part.partDimCi;
			createShape.bot1DimMo = createShape.bot1DimM = myFacet.bot1Part.partDimM = myFacet.bot1Part.partDimMi;
			createShape.bot2DimBo = createShape.bot2DimB = myFacet.bot2Part.partDimB = myFacet.bot2Part.partDimBi;
			createShape.bot2DimAo = createShape.bot2DimA = myFacet.bot2Part.partDimA = myFacet.bot2Part.partDimAi;
			createShape.bot2DimCo = createShape.bot2DimC = myFacet.bot2Part.partDimC = myFacet.bot2Part.partDimCi;
			createShape.bot2DimMo = createShape.bot2DimM = myFacet.bot2Part.partDimM = myFacet.bot2Part.partDimMi;
			createShape.bot3DimBo = createShape.bot3DimB = myFacet.bot3Part.partDimB = myFacet.bot3Part.partDimBi;
			createShape.bot3DimAo = createShape.bot3DimA = myFacet.bot3Part.partDimA = myFacet.bot3Part.partDimAi;
			createShape.bot3DimCo = createShape.bot3DimC = myFacet.bot3Part.partDimC = myFacet.bot3Part.partDimCi;
			createShape.bot3DimMo = createShape.bot3DimM = myFacet.bot3Part.partDimM = myFacet.bot3Part.partDimMi;
			
			createShape.leftDimBo = createShape.leftDimB = myFacet.leftPart.partDimB = myFacet.leftPart.partDimBi;
			createShape.leftDimAo = createShape.leftDimA = myFacet.leftPart.partDimA = myFacet.leftPart.partDimAi;
			createShape.leftDimCo = createShape.leftDimC = myFacet.leftPart.partDimC = myFacet.leftPart.partDimCi;
			createShape.leftDimMo = createShape.leftDimM = myFacet.leftPart.partDimM = myFacet.leftPart.partDimMi;
			createShape.rightDimBo = createShape.rightDimB = myFacet.rightPart.partDimB = myFacet.rightPart.partDimBi;
			createShape.rightDimAo = createShape.rightDimA = myFacet.rightPart.partDimA = myFacet.rightPart.partDimAi;
			createShape.rightDimCo = createShape.rightDimC = myFacet.rightPart.partDimC = myFacet.rightPart.partDimCi;
			createShape.rightDimMo = createShape.rightDimM = myFacet.rightPart.partDimM = myFacet.rightPart.partDimMi;
		}
		
		myreturns[0] = myFacet;
		myreturns[1] = createShape;
		
		return myreturns;
	}
	
	
}

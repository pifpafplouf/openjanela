/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/

package Operations;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import openjanela.model.entities.partner.Rules;
import openjanela.model.entities.partner.SeriesValidOpeningShape;
import Model.BillOfMat;
import Model.OpeningObject;
import Model.SashLeaf;
import Model.SashTypeObject;
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

public class CreateSash {

	// public OpeningObject myOpening;
	public int sashClassType = 0;

	public int sashUDID = 0;

	public int noOfLeafs = 0;

	public int notracks = 1;

	public int[] sashOnInsideTrack;

	public int whichPos = 0;

	// 0=fixed 1=out 2=in 3= slide
	public int opens = 0;

	public double split = 100f;

	public double frameStartAngle = 0;

	public double frameEndAngle = 0;

	public double frameCentralAngle = 0;

	public int myfirstRowinColumnBelow = 1000;

	public int myfirstRowinColumnAbove = 0;

	public double myFrameWidth = 0;

	public double myFrameHeight = 0;

	public int orientation = 0;

	public int cNo = 0;

	public int myshape = 0;

	public double wt = 0; // actual

	public double hl = 0;

	public double wtc = 0; // Center

	public double hlc = 0;

	public double wb = 0; // actual

	public double hr = 0;

	public double wbc = 0; // Center

	public double hrc = 0;

	public int shape = 0;

	public int sequence = 0;

	public double startingX = 0;

	public double startingY = 0;

	public double startingXB = 0;

	public double startingYB = 0;

	public double startingXA = 0;

	public double startingYA = 0;

	public double startingXC = 0;

	public double startingYC = 0;

	public int startCol = 0;

	public int endCol = 0;

	public int startRow = 0;

	public int endRow = 0;

	public double bX1 = 0;

	public double bY1 = 0;

	public double bX2 = 0;

	public double bY2 = 0;

	public double bX3 = 0;

	public double bY3 = 0;

	public double bX4 = 0;

	public double bY4 = 0;

	public double t1t2X = 0;

	public double t1t2Y = 0;

	public double t1t3X = 0;

	public double t1t3Y = 0;

	public double t3t2X = 0;

	public double t3t2Y = 0;

	public double b1b2X = 0;

	public double b1b2Y = 0;

	public double b1b3X = 0;

	public double b1b3Y = 0;

	public double bX1B = 0;

	public double bY1B = 0;

	public double bX2B = 0;

	public double bY2B = 0;

	public double bX3B = 0;

	public double bY3B = 0;

	public double bX4B = 0;

	public double bY4B = 0;

	public double t1t2XB = 0;

	public double t1t2YB = 0;

	public double t1t3XB = 0;

	public double t1t3YB = 0;

	public double t3t2XB = 0;

	public double t3t2YB = 0;

	public double b1b2XB = 0;

	public double b1b2YB = 0;

	public double b1b3XB = 0;

	public double b1b3YB = 0;

	public double bX1A = 0;

	public double bY1A = 0;

	public double bX2A = 0;

	public double bY2A = 0;

	public double bX3A = 0;

	public double bY3A = 0;

	public double bX4A = 0;

	public double bY4A = 0;

	public double t1t2XA = 0;

	public double t1t2YA = 0;

	public double t1t3XA = 0;

	public double t1t3YA = 0;

	public double t3t2XA = 0;

	public double t3t2YA = 0;

	public double b1b2XA = 0;

	public double b1b2YA = 0;

	public double b1b3XA = 0;

	public double b1b3YA = 0;

	// public double bX1C = 0;
	// public double bY1C = 0;
	// public double bX2C = 0;
	// public double bY2C = 0;
	// public double bX3C = 0;
	// public double bY3C = 0;
	// public double bX4C = 0;
	// public double bY4C = 0;

	public double t1t2XC = 0;

	public double t1t2YC = 0;

	public double t1t3XC = 0;

	public double t1t3YC = 0;

	public double t3t2XC = 0;

	public double t3t2YC = 0;

	public double b1b2XC = 0;

	public double b1b2YC = 0;

	public double b1b3XC = 0;

	public double b1b3YC = 0;

	public double centerPointX = 0;

	public double centerPointY = 0;

	public double centerPointX2 = 0;

	public double centerPointY2 = 0;

	public double radius1 = 0;

	public double radius2 = 0;

	public double startAngle = 0;

	public double endAngle = 0;

	public double bkgrdStartX = 0;

	public double bkgrdStartY = 0;

	public double centralAngle = 0;

	public double centerPointXs = 0;

	public double centerPointYs = 0;

	public double centerPointX2B = 0;

	public double centerPointY2B = 0;

	public double radius1s = 0;

	public double radius2s = 0;

	public double startAngles = 0;

	public double endAngles = 0;

	public double bkgrdStartXs = 0;

	public double bkgrdStartYs = 0;

	public double centralAngles = 0;

	public double startingCX = 0;

	public double startingCY = 0;

	public double bCX2 = 0;

	public double bCY2 = 0;

	public double bCX3 = 0;

	public double bCY3 = 0;

	public double bCX4 = 0;

	public double bCY4 = 0;

	public boolean topIn = false;

	public boolean botIn = false;

	public boolean rightIn = false;

	public boolean leftIn = false;

	// public double myStartingX = 0;
	// public double myStartingY = 0;
	// public double myEndingX = 0;
	// public double myEndingY = 0;

	public double px1 = 0;

	public double py1 = 0;

	public double px2 = 0;

	public double py2 = 0;

	public double px3 = 0;

	public double py3 = 0;

	public double px4 = 0;

	public double py4 = 0;

	public double px5 = 0;

	public double py5 = 0;

	public double px6 = 0;

	public double py6 = 0;

	public double px7 = 0;

	public double py7 = 0;

	public double px8 = 0;

	public double py8 = 0;

	public double px1c = 0;

	public double py1c = 0;

	public double px2c = 0;

	public double py2c = 0;

	public double px3c = 0;

	public double py3c = 0;

	public double px4c = 0;

	public double py4c = 0;

	public double px5c = 0;

	public double py5c = 0;

	public double px6c = 0;

	public double py6c = 0;

	public double px7c = 0;

	public double py7c = 0;

	public double px8c = 0;

	public double py8c = 0;

	public double px1B = 0;

	public double py1B = 0;

	public double px2B = 0;

	public double py2B = 0;

	public double px3B = 0;

	public double py3B = 0;

	public double px4B = 0;

	public double py4B = 0;

	public double px5B = 0;

	public double py5B = 0;

	public double px6B = 0;

	public double py6B = 0;

	public double px7B = 0;

	public double py7B = 0;

	public double px8B = 0;

	public double py8B = 0;

	public double px1A = 0;

	public double py1A = 0;

	public double px2A = 0;

	public double py2A = 0;

	public double px3A = 0;

	public double py3A = 0;

	public double px4A = 0;

	public double py4A = 0;

	public double px5A = 0;

	public double py5A = 0;

	public double px6A = 0;

	public double py6A = 0;

	public double px7A = 0;

	public double py7A = 0;

	public double px8A = 0;

	public double py8A = 0;

	public double px1C = 0;

	public double py1C = 0;

	public double px2C = 0;

	public double py2C = 0;

	public double px3C = 0;

	public double py3C = 0;

	public double px4C = 0;

	public double py4C = 0;

	public double px5C = 0;

	public double py5C = 0;

	public double px6C = 0;

	public double py6C = 0;

	public double px7C = 0;

	public double py7C = 0;

	public double px8C = 0;

	public double py8C = 0;

	public double myStartingXB = 0;

	public double myStartingYB = 0;

	public double myEndingXB = 0;

	public double myEndingYB = 0;

	public double myStartingXA = 0;

	public double myStartingYA = 0;

	public double myEndingXA = 0;

	public double myEndingYA = 0;

	public double myStartingXC = 0;

	public double myStartingYC = 0;

	public double myEndingXC = 0;

	public double myEndingYC = 0;

	public OpeningObject myParentO;

	public double clearanceTop = 0;

	public double clearanceBot = 0;

	public double clearanceLeft = 0;

	public double clearanceRight = 0;

	public double top1DimBo = 0;

	public double top1DimAo = 0;

	public double top1DimCo = 0;

	public double top1DimMo = 0;

	public double top2DimBo = 0;

	public double top2DimAo = 0;

	public double top2DimCo = 0;

	public double top2DimMo = 0;

	public double top3DimBo = 0;

	public double top3DimAo = 0;

	public double top3DimCo = 0;

	public double top3DimMo = 0;

	public double leftDimBo = 0;

	public double leftDimAo = 0;

	public double leftDimCo = 0;

	public double leftDimMo = 0;

	public double rightDimBo = 0;

	public double rightDimAo = 0;

	public double rightDimCo = 0;

	public double rightDimMo = 0;

	public double bot1DimBo = 0;

	public double bot1DimAo = 0;

	public double bot1DimCo = 0;

	public double bot1DimMo = 0;

	public double bot2DimBo = 0;

	public double bot2DimAo = 0;

	public double bot2DimCo = 0;

	public double bot2DimMo = 0;

	public double bot3DimBo = 0;

	public double bot3DimAo = 0;

	public double bot3DimCo = 0;

	public double bot3DimMo = 0;

	public double top1DimB = 0;

	public double top1DimA = 0;

	public double top1DimC = 0;

	public double top1DimM = 0;

	public double top2DimB = 0;

	public double top2DimA = 0;

	public double top2DimC = 0;

	public double top2DimM = 0;

	public double top3DimB = 0;

	public double top3DimA = 0;

	public double top3DimC = 0;

	public double top3DimM = 0;

	public double leftDimB = 0;

	public double leftDimA = 0;

	public double leftDimC = 0;

	public double leftDimM = 0;

	public double rightDimB = 0;

	public double rightDimA = 0;

	public double rightDimC = 0;

	public double rightDimM = 0;

	public double bot1DimB = 0;

	public double bot1DimA = 0;

	public double bot1DimC = 0;

	public double bot1DimM = 0;

	public double bot2DimB = 0;

	public double bot2DimA = 0;

	public double bot2DimC = 0;

	public double bot2DimM = 0;

	public double bot3DimB = 0;

	public double bot3DimA = 0;

	public double bot3DimC = 0;

	public double bot3DimM = 0;

	//

	Collection xCoordB = new ArrayList();

	Collection yCoordB = new ArrayList();

	Collection pCoordArc = new ArrayList();

	Collection pCoordLine = new ArrayList();

	Object[] xCoordBo = null;

	Object[] yCoordBo = null;

	Collection xCoordBL = new ArrayList();

	Collection yCoordBL = new ArrayList();

	Object[] xCoordBoL = null;

	Object[] yCoordBoL = null;

	double myX = 0;

	double myY = 0;

	double myXL = 0;

	double myYL = 0;

	boolean doStops = true;

	double top1Dist = 0;

	double top2Dist = 0;

	double top3Dist = 0;

	double bot1Dist = 0;

	double bot2Dist = 0;

	double bot3Dist = 0;

	double leftDist = 0;

	double rightDist = 0;

	double top1DistB = 0;

	double top2DistB = 0;

	double top3DistB = 0;

	double bot1DistB = 0;

	double bot2DistB = 0;

	double bot3DistB = 0;

	double leftDistB = 0;

	double rightDistB = 0;

	double top1DistA = 0;

	double top2DistA = 0;

	double top3DistA = 0;

	double bot1DistA = 0;

	double bot2DistA = 0;

	double bot3DistA = 0;

	double leftDistA = 0;

	double rightDistA = 0;

	boolean isNew = false;

	boolean isNewPart = true;

	boolean glazedOut = false;

	boolean[] sashGlazedOut;

	boolean openingChanged = false;

	// public SashTypeObject sashtype;

	public Collection myExistingSashes = new ArrayList();

	public int[] paneType;

	public int[] interLocks;

	public boolean sameParts = false;

	public boolean isOriel = false;

	public double extendExtra = 0;

	public BigDecimal scale = new BigDecimal(0);

	ItemFrame myFrame2 = null;

	int productT = 0;

	double partialLouvreSize = 0;

	public boolean fixedSashOuttrack = false;

	public int ntracks = 0;
	

	// Sash Types

	public CreateSash(OpeningObject opening, int type, int id, int leafs,
			int noTracks, int[] sashonintrack, int whichpos, double mysplit,
			int open, Collection existingSashes, boolean outglazed,
			boolean[] sashOutglazed, int[] panetype, boolean isoriel,
			int[] interlocks, double extend, ItemFrame myframe, int producttype) {

		productT = producttype;
		sashGlazedOut = new boolean[leafs];
		paneType = new int[leafs];
		sashGlazedOut = sashOutglazed;
		paneType = panetype;
		myParentO = opening;
		myFrame2 = myframe;

		if (myFrame2.myTopPanel.metric.isSelected()) {
			scale = myFrame2.scale.multiply(new BigDecimal(100));
		} else {
			scale = myFrame2.scale;
		}

		sashClassType = type;
		sashUDID = id;
		noOfLeafs = leafs;
		notracks = noTracks;
		interLocks = interlocks;
		sashOnInsideTrack = sashonintrack;
		whichPos = whichpos;
		split = mysplit;
		opens = open;

		glazedOut = outglazed;

		isOriel = isoriel;
		extendExtra = extend;

		myExistingSashes = existingSashes;
	}

	public CreateSash(SashLeaf myLeaf) {

		myParentO = myLeaf.myParentO;
		isNewPart = false;
		// doNewSash();

	}

	public void resetParentContents() {

		if (whichPos == 1) {

			// myParentO.sashObjectIn.frames
			// .clear();
			myParentO.sashObjectIn = null;

		} else if (whichPos == 2) {

			// myParentO.sashObjectMid.frames
			// .clear();
			myParentO.sashObjectMid = null;

		} else if (whichPos == 3) {

			// myParentO.sashObjectOut.frames
			// .clear();
			myParentO.sashObjectOut = null;
		}
	}

	/**
	 * Do new sash into opening
	 * 
	 * @param sashtype
	 *            , SashType
	 * @param sameparts
	 *            , boolean
	 * @param existingSashes
	 *            , Collection of existing sashes
	 * @return OpeningObject
	 */
	public OpeningObject doNewSash(SashTypeObject sashtype, boolean sameparts,
			Collection existingSashes) throws Exception {

		// *********************************************************
		// Reset values for sashType - Consistence creation
		// *********************************************************
		sashtype.xCols = 1;
		sashtype.yRows = 1;
		sashtype.bOpeningObject.xCols = 1;
		sashtype.bOpeningObject.yRows = 1;
		sashtype.openings.clear();

		sameParts = sameparts;

		if (myParentO.widthPix != sashtype.widthPix
				|| myParentO.heightPix != sashtype.heightPix) {
			sashtype = this.createSashType();
		} else {
			sashtype.options.clear();
			sashtype.executeOptionRules("createSash.doNewSAsh.879");
		}

		if (sashtype.openings.size() == 0) {
			sashtype = this.createSashType();
		} else {
			sashtype.options.clear();
			sashtype.executeOptionRules("createSash.doNewSAsh.879");
		}

		if (myFrame2.wEntered || myFrame2.hEntered) {
			sashtype = this.createSashType();
		} else {
			sashtype.options.clear();
			sashtype.executeOptionRules("createSash.doNewSAsh.879");
		}

		this.resetParentContents();

		fixedSashOuttrack = ItemFrame.getApplicationBaseRules()
				.getSeriesValidOpeningById(sashtype.userDefinedOpeningID)
				.isOutTrackFixed();
		ntracks = sashtype.noTracks;

		// Get array of openings from sashType
		Object[] oo = sashtype.openings.toArray();

		partialLouvreSize = 0;

		switch (sashClassType) {

		case 1:
			this.doPictureWindow();
			break;
		case 2: // casement L
			opens = 2;
			if (myParentO.noSides == 3 && myParentO.top1.partForm > 1
					&& myParentO.noSidesRight == 1) {
				sashClassType = 3;
			}
			do1LProjected(oo, sashtype, existingSashes);
			break;
		case 3: // casement R
			opens = 2;
			if (myParentO.noSides == 3 && myParentO.top1.partForm > 1
					&& myParentO.noSidesLeft == 1) {
				sashClassType = 2;
			}
			do1LProjected(oo, sashtype, existingSashes);
			break;
		case 4: // awning
			opens = 2;
			do1LProjected(oo, sashtype, existingSashes);
			break;
		case 5: // FS
			opens = 2;
			do1LProjected(oo, sashtype, existingSashes);
			break;
		case 6: // in CL
			opens = 1;
			if (myParentO.noSides == 3 && myParentO.top1.partForm > 1
					&& myParentO.noSidesRight == 1) {
				sashClassType = 3;
			}
			do1LProjected(oo, sashtype, existingSashes);
			break;
		case 7: // in CR
			opens = 1;
			if (myParentO.noSides == 3 && myParentO.top1.partForm > 1
					&& myParentO.noSidesRight == 1) {
				sashClassType = 3;
			}
			do1LProjected(oo, sashtype, existingSashes);
			break;
		case 8: // in Awn
			opens = 1;
			do1LProjected(oo, sashtype, existingSashes);
			break;
		case 9: // in FS
			opens = 1;
			do1LProjected(oo, sashtype, existingSashes);
			break;
		case 10: // hopper
			opens = 1;
			do1LProjected(oo, sashtype, existingSashes);
			break;
		case 11: // SSL
			this.doSSL(sashtype);
			break;
		case 12: // SSR
			this.doSSR(sashtype);
			break;
		case 13: // 3lS
			this.doSL_3LS(sashtype);
			break;
		case 14:// 4ls
			this.doSL_4LS(sashtype);
			break;
		case 15:// CSL
			this.doCenterFixedSliderSashType(sashtype);
			break;
		case 16:// CSR
			this.doCenterFixedSliderSashType(sashtype);
			break;
		case 17:// CSBiDirectional
			this.doPictureWindow();
			break;
		case 18:// Custom
			this.doPictureWindow();
			break;
		case 21:// DSL
			this.doDS_L(sashtype);
			break;
		case 22:// DSR
			this.doDS_L(sashtype);
			break;
		case 23:// D-3LS
			this.doDS_3L(sashtype);
			break;
		case 24:// D-4LS
			this.doDS_4LS(sashtype);
			break;
		case 31:// SH
			this.doSH(sashtype);
			break;
		case 32:// DH
			this.doDH(sashtype);
			break;
		case 41:// TTL
			this.do1SashOutSwing(myParentO, 1, 1, sashGlazedOut[0], sameParts,
					paneType[0], 0, sashtype, existingSashes, true);
			break;
		case 42:// TTR
			this.do1SashOutSwing(myParentO, 1, 1, sashGlazedOut[0], sameParts,
					paneType[0], 0, sashtype, existingSashes, true);
			break;
		case 43:// TTL-sR
			this.do2L_Projected(1, sashtype, existingSashes);
			break;
		case 44:// TTR-sL
			this.do2L_Projected(1, sashtype, existingSashes);
			break;
		case 51:// Pivot H
			this.do1SashOutSwing(myParentO, 1, 1, sashGlazedOut[0], sameParts,
					paneType[0], 0, sashtype, existingSashes, true);
			break;
		case 52:// Pivot V
			this.do1SashOutSwing(myParentO, 1, 1, sashGlazedOut[0], sameParts,
					paneType[0], 0, sashtype, existingSashes, true);
			break;
		case 61:// Louver
			this.doLouver(sashtype, existingSashes);
			break;
		case 71:// TTL-sR
			this.do2L_Projected(2, sashtype, existingSashes);
			break;
		case 72:// TTR-sL
			this.do2L_Projected(2, sashtype, existingSashes);
			break;
		case 73:// TTR-sL
			this.do2L_Projected(2, sashtype, existingSashes);
			break;
		case 76:// TTL-sR
			this.do2L_Projected(1, sashtype, existingSashes);
			break;
		case 77:// TTR-sL
			this.do2L_Projected(1, sashtype, existingSashes);
			break;
		case 78:// TTR-sL
			this.do2L_Projected(1, sashtype, existingSashes);
			break;
		case 211: // SSL
			this.doSSL(sashtype);
			break;
		case 212: // SSR
			this.doSSR(sashtype);
			break;
		case 213: // 3lS
			this.doSL_3LS(sashtype);
			break;
		case 214:// 4ls
			this.doSL_4LS(sashtype);
			break;
		case 215:// CSL
			this.doCenterFixedSliderSashType(sashtype);
			break;
		case 216:// CSR
			this.doCenterFixedSliderSashType(sashtype);
			break;
		case 217:// CSBiDirectional
			this.doCenterFixedSliderSashType(sashtype);
			break;
		case 221:// DSL
			this.doDS_L(sashtype);
			break;
		case 222:// DSR
			this.doDS_L(sashtype);
			break;
		case 223:// D-3LS
			this.doDS_3L(sashtype);
			break;
		case 224:// D-4LS
			this.doDS_4LS(sashtype);
			break;
		case 231:// SH
			this.doSH(sashtype);
			break;
		case 232:// DH
			this.doDH(sashtype);
			break;

		case 243:// TTL-sR
			this.do2L_Projected(1, sashtype, existingSashes);
			break;
		case 244:// TTR-sL
			this.do2L_Projected(1, sashtype, existingSashes);
			break;

		case 271:// TTL-sR
			this.do2L_Projected(2, sashtype, existingSashes);
			break;
		case 272:// TTR-sL
			this.do2L_Projected(2, sashtype, existingSashes);
			break;
		case 273:// TTR-sL
			this.do2L_Projected(2, sashtype, existingSashes);
			break;
		case 276:// TTL-sR
			this.do2L_Projected(1, sashtype, existingSashes);
			break;
		case 277:// TTR-sL
			this.do2L_Projected(1, sashtype, existingSashes);
			break;
		case 278:// TTR-sL
			this.do2L_Projected(1, sashtype, existingSashes);
			break;

		case 291:// Custom SliderL
			 doPocket(sashtype, existingSashes);
			// extendExtra = 3;
			break;

		case 292:// Custom SliderR
			 doPocket(sashtype, existingSashes);
			// extendExtra = 3;
			break;

		case 293:// Custom SliderC
			 doPocket(sashtype, existingSashes);
			// extendExtra = 3;
			break;

		case 301:// foldingL
			doFolding(sashtype, existingSashes);
			extendExtra = 3;
			break;

		case 302:// foldingR
			doFolding(sashtype, existingSashes);
			extendExtra = 3;
			break;
		case 303:// foldingM
			doFolding(sashtype, existingSashes);
			extendExtra = 3;
			break;
		case 311:// PL
			this.doPocket(sashtype, existingSashes);
			extendExtra = 3;
			break;

		case 312:// PR
			this.doPocket(sashtype, existingSashes);
			extendExtra = 3;
			break;

		case 313:// PM
			this.doPocket(sashtype, existingSashes);
			extendExtra = 3;
			break;

		}

		if (whichPos == 1) {
			myParentO.sashObjectIn = sashtype;
		} else if (whichPos == 2) {
			myParentO.sashObjectMid = sashtype;
		} else if (whichPos == 3) {
			myParentO.sashObjectOut = sashtype;
		}

		if (sashClassType != 61 && myParentO.contentMid != 3) {
			Object[] m6 = null;
			Object[] leafs = null;
			boolean redrawMullions = false;
			double sY = 0;
			double eY = 0;
			if (whichPos == 1) {
				m6 = sashtype.bOpeningObject.mullions.toArray();
				sashtype.bOpeningObject.mullions.clear();
				for (Object v : m6) {
					if (((Profiles) v).cOrM == 6) {
						leafs = sashtype.frames.toArray();
						if (leafs.length > 0) {
							for (Object s : leafs) {
								if (((SashLeaf) s).startCol == ((Profiles) v).rowCol + 1) {
									sY = ((SashLeaf) s).top1Part.startYC;
									eY = ((SashLeaf) s).bot1Part.endYC;
									redrawMullions = true;
									break;
								}
							}
						}
						((Profiles) v).y1 = ((Profiles) v).y2 = ((Profiles) v).y1al = ((Profiles) v).y2cl = ((Profiles) v).centerYs = sY;
						((Profiles) v).y4 = ((Profiles) v).y3 = ((Profiles) v).y4al = ((Profiles) v).y3cl = ((Profiles) v).centerYe = eY;
						((Profiles) v).length = eY - sY;
					}
					sashtype.bOpeningObject.mullions.add(v);
				}

				if (redrawMullions) {
					sashtype.bOpeningObject = sashtype
							.doMullions(sashtype.bOpeningObject);

				}

			} else if (whichPos == 2) {
				m6 = sashtype.bOpeningObject.mullions.toArray();

				sashtype.bOpeningObject.mullions.clear();
				for (Object v : m6) {
					if (((Profiles) v).cOrM == 6) {
						leafs = sashtype.frames.toArray();
						if (leafs.length > 0) {
							for (Object s : leafs) {
								if (((SashLeaf) s).startCol == ((Profiles) v).rowCol + 1) {
									sY = ((SashLeaf) s).top1Part.startYC;
									eY = ((SashLeaf) s).bot1Part.endYC;
									redrawMullions = true;
									break;
								}
							}
						}
						((Profiles) v).y1 = ((Profiles) v).y2 = ((Profiles) v).y1al = ((Profiles) v).y2cl = ((Profiles) v).centerYs = sY;
						((Profiles) v).y4 = ((Profiles) v).y3 = ((Profiles) v).y4al = ((Profiles) v).y3cl = ((Profiles) v).centerYe = eY;
						((Profiles) v).length = eY - sY;
					}
					sashtype.bOpeningObject.mullions.add(v);

				}
				if (redrawMullions) {

					sashtype.bOpeningObject = sashtype
							.doMullions(sashtype.bOpeningObject);

				}
				myParentO.sashObjectMid = sashtype;
			} else if (whichPos == 3) {
				m6 = sashtype.bOpeningObject.mullions.toArray();
				sashtype.bOpeningObject.mullions.clear();
				for (Object v : m6) {
					if (((Profiles) v).cOrM == 6) {
						leafs = sashtype.frames.toArray();
						if (leafs.length > 0) {
							for (Object s : leafs) {
								if (((SashLeaf) s).startCol == ((Profiles) v).rowCol + 1) {
									sY = ((SashLeaf) s).top1Part.startYC;
									eY = ((SashLeaf) s).bot1Part.endYC;
									redrawMullions = true;
									break;
								}
							}
						}
						((Profiles) v).y1 = ((Profiles) v).y2 = ((Profiles) v).y1al = ((Profiles) v).y2cl = ((Profiles) v).centerYs = sY;
						((Profiles) v).y4 = ((Profiles) v).y3 = ((Profiles) v).y4al = ((Profiles) v).y3cl = ((Profiles) v).centerYe = eY;
						((Profiles) v).length = eY - sY;

					}

					sashtype.bOpeningObject.mullions.add(v);

				}
				if (redrawMullions) {
					sashtype.bOpeningObject = sashtype
							.doMullions(sashtype.bOpeningObject);

				}
				myParentO.sashObjectOut = sashtype;
			}
		}

		return myParentO;
	}

	public SashTypeObject do1LProjected(Object[] oo, SashTypeObject sashtype,
			Collection existingS) throws Exception {

		sashtype.openings.clear();

		for (int i = 0; i < oo.length; i++) {
			setOpeningToSash(oo, i);
			this.do1SashOutSwing(myParentO, sashClassType,
					sashOnInsideTrack[0], sashGlazedOut[0], sameParts,
					paneType[0], 0, sashtype, existingS, true);
			sashtype.openings.add(oo[i]);
		}

		return sashtype;
	}

	public void doPictureWindow() throws Exception {

		if (whichPos == 1) {
			myParentO.contentIn = 1;
			myParentO.sashObjectIn = null;
		} else if (whichPos == 2) {
			myParentO.contentMid = 1;
			myParentO.sashObjectMid = null;
		} else if (whichPos == 3) {
			myParentO.contentOut = 1;
			myParentO.sashObjectOut = null;
		}
		myParentO.unGlazed = false;
		CreateOpenings createOpening = new CreateOpenings(myParentO.myParent,
				myFrame2);
		myParentO = createOpening.doOpenings(myParentO);
	}

	public SashTypeObject doDS_L(SashTypeObject sashtype) throws Exception {

		boolean goodToGo;
		goodToGo = this.checkHSliderShape();
		if (goodToGo) {

			opens = 3;

			AddMullionV addMullionV = new AddMullionV(sashtype.bOpeningObject,
					myFrame2.jobItem, myFrame2, interLocks[0]);

			// double posX = sashtype.bOpeningObject.startingX
			// + (sashtype.bOpeningObject.bX2 -
			// sashtype.bOpeningObject.startingX) * split / 100;

			double posX = sashtype.myParentO.startingCX
					+ (sashtype.myParentO.bCX2 - sashtype.myParentO.startingCX)
					* split / 100;

			addMullionV.newStartingXCenter = posX;

			addMullionV.vcStartY = sashtype.bOpeningObject.highestY;
			addMullionV.vcEnd = 1;
			addMullionV.vcStart = 1;
			addMullionV.vcEndY = 500;// sashtype.bOpeningObject.bY4,
			// ;
			addMullionV.newVCCol = 1;
			addMullionV.newVCRow = 1;

			addMullionV.doAddMullionsV(
					(int) (myParentO.startingX + myParentO.widthPix / 2),
					(int) (myParentO.highestY + (Math.max(myParentO.bY4,
							myParentO.bY3) - myParentO.highestY) / 2), true, 2,
					1, 0, 0, 0, 0, 0, 0, 0, 0, 0, whichPos, true, 0, 33, 0, 0); // DS
																				// or
																				// DH
			// Interlock

			Object[] oo = sashtype.openings.toArray();
			sashtype.openings.clear();
			sashtype.frames.clear();
			for (int i = 0; i < oo.length; i++) {
				setOpeningToSash(oo, i);
				this.do1SashSlider(((OpeningObject) oo[i]), sashClassType,
						sashOnInsideTrack[i], sashGlazedOut[i], sameParts,
						paneType[i], i, sashtype, true);
				sashtype.openings.add(oo[i]);
			}

			goodToGo = true;
			addMullionV = null;
		}
		sashtype.xCols = sashtype.bOpeningObject.xCols = 2;
		sashtype.yRows = sashtype.bOpeningObject.yRows = 1;

		return sashtype;
	}

	/**
	 * Create 2L_Projected sash
	 * 
	 * @param open
	 *            , int
	 * @param sashtype
	 *            , SashTypeObject
	 * @param existingSashes
	 *            , Collection
	 * @return SashTypeObject
	 */
	public SashTypeObject do2L_Projected(int open, SashTypeObject sashtype,
			Collection existingSashes) throws Exception {

		boolean goodToGo = true;

		if (goodToGo) {
			opens = open;
			AddMullionV addMullionV = new AddMullionV(sashtype.bOpeningObject,
					myFrame2.jobItem, myFrame2, interLocks[0]);

			// double posX = sashtype.bOpeningObject.startingX
			// + (sashtype.bOpeningObject.bX2 -
			// sashtype.bOpeningObject.startingX) * split / 100;

			double posX = sashtype.myParentO.startingCX
					+ (sashtype.myParentO.bCX2 - sashtype.myParentO.startingCX)
					* split / 100;

			addMullionV.newStartingXCenter = posX;
			addMullionV.vcStartY = sashtype.bOpeningObject.highestY;
			addMullionV.vcEnd = 1;
			addMullionV.vcStart = 1;
			addMullionV.vcEndY = 500;

			addMullionV.newVCCol = 1;
			addMullionV.newVCRow = 1;

			// get astragal partid ???
			Profiles astragal = new Profiles();

			astragal.myFrame2 = this.myFrame2;
			astragal.a_levelID = 39;
			astragal.orientation = 1;
			astragal.myParent = sashtype;
			astragal.myParent = sashtype;

			astragal.executePartRules(true);
			int partid = 0;
			for (Object bom : astragal.bom.toArray()) {
				partid = ((BillOfMat) bom).partid;
			}

			addMullionV.doAddMullionsV(
					(int) (myParentO.startingX + myParentO.widthPix / 2),
					(int) (myParentO.highestY + (Math.max(myParentO.bY4,
							myParentO.bY3) - myParentO.highestY) / 2), true, 2,
					1, 0, 0, 0, 0, 0, 0, partid, 0, 0, whichPos, true, 0, 39,
					0, 0);// Astragal

			Object[] oo = sashtype.openings.toArray();
			sashtype.openings.clear();
			sashtype.frames.clear();

			for (int i = 0; i < oo.length; i++) {
				setOpeningToSash(oo, i);
				this.do1SashSlider(((OpeningObject) oo[i]), sashClassType,
						sashOnInsideTrack[i], sashGlazedOut[i], sameParts,
						paneType[i], i, sashtype, true);

				sashtype.openings.add(oo[i]);
			}

		}

		sashtype.xCols = sashtype.bOpeningObject.xCols = 2;
		sashtype.yRows = sashtype.bOpeningObject.yRows = 1;

		return sashtype;
	}

	public SashTypeObject doDS_3L(SashTypeObject sashtype) throws Exception {

		boolean goodToGo;
		goodToGo = this.checkHSliderShape();
		if (goodToGo) {

			opens = 3;

			AddMullionV addMullionV = new AddMullionV(sashtype.bOpeningObject,
					myFrame2.jobItem, myFrame2, interLocks[0]);

			// double posX = sashtype.bOpeningObject.startingX
			// + (sashtype.bOpeningObject.bX2 -
			// sashtype.bOpeningObject.startingX) * split / 100;

			double posX = sashtype.myParentO.startingCX
					+ (sashtype.myParentO.bCX2 - sashtype.myParentO.startingCX)
					* split / 100;

			addMullionV.newStartingXCenter = posX;

			addMullionV.vcStartY = sashtype.bOpeningObject.highestY;
			addMullionV.vcEnd = 1;
			addMullionV.vcStart = 1;
			addMullionV.vcEndY = 500;// sashtype.bOpeningObject.bY4,
			// ;
			addMullionV.newVCCol = 1;
			addMullionV.newVCRow = 1;

			addMullionV.doAddMullionsV(
					(int) (myParentO.startingX + myParentO.widthPix / 2),
					(int) (myParentO.highestY + (Math.max(myParentO.bY4,
							myParentO.bY3) - myParentO.highestY) / 2), true, 2,
					1, 0, 0, 0, 0, 0, 0, 0, 0, 0, whichPos, true, 0, 33, 0, 0);

			// posX = sashtype.bOpeningObject.startingX +
			// sashtype.bOpeningObject.bX2 - sashtype.bOpeningObject.startingX
			// - (sashtype.bOpeningObject.bX2 -
			// sashtype.bOpeningObject.startingX) * split / 100;
			posX = sashtype.myParentO.startingCX + sashtype.myParentO.bCX2
					- sashtype.myParentO.startingCX
					- (sashtype.myParentO.bCX2 - sashtype.myParentO.startingCX)
					* split / 100;

			addMullionV.newStartingXCenter = posX;

			// addMullionV.cOrM = 3;

			addMullionV.newVCCol = 2;
			addMullionV.cOrM = interLocks[1];
			addMullionV.doAddMullionsV(
					(int) (myParentO.startingX + myParentO.widthPix / 2),
					(int) (myParentO.highestY + (Math.max(myParentO.bY4,
							myParentO.bY3) - myParentO.highestY) / 2), true, 2,
					1, 0, 0, 0, 0, 0, 0, 0, 0, 0, whichPos, true, 0, 33, 0, 0);

			Object[] oo = sashtype.openings.toArray();
			sashtype.openings.clear();
			sashtype.frames.clear();
			for (int i = 0; i < oo.length; i++) {
				setOpeningToSash(oo, i);

				this.do1SashSlider(((OpeningObject) oo[i]), sashClassType,
						sashOnInsideTrack[i], sashGlazedOut[i], sameParts,
						paneType[i], i, sashtype, true);

				sashtype.openings.add(oo[i]);
			}

		}
		sashtype.xCols = sashtype.bOpeningObject.xCols = 3;
		sashtype.yRows = sashtype.bOpeningObject.yRows = 1;

		return sashtype;
	}

	public SashTypeObject doSL_4LS(SashTypeObject sashtype) throws Exception {

		boolean goodToGo;
		goodToGo = this.checkHSliderShape();
		if (goodToGo) {

			opens = 3;

			AddMullionV addMullionV = new AddMullionV(sashtype.bOpeningObject,
					myFrame2.jobItem, myFrame2, interLocks[0]);

			// double posX = sashtype.bOpeningObject.startingX
			// + (sashtype.bOpeningObject.bX2 -
			// sashtype.bOpeningObject.startingX) * split / 100;
			double posX = sashtype.myParentO.startingCX
					+ (sashtype.myParentO.bCX2 - sashtype.myParentO.startingCX)
					* split / 100;

			addMullionV.newStartingXCenter = posX;

			addMullionV.vcStartY = sashtype.bOpeningObject.highestY;
			addMullionV.vcEnd = 1;
			addMullionV.vcStart = 1;
			addMullionV.vcEndY = 500;// sashtype.bOpeningObject.bY4,
			// ;
			addMullionV.newVCCol = 1;
			addMullionV.newVCRow = 1;

			addMullionV.doAddMullionsV(
					(int) (myParentO.startingX + myParentO.widthPix / 2),
					(int) (myParentO.highestY + (Math.max(myParentO.bY4,
							myParentO.bY3) - myParentO.highestY) / 2), true, 2,
					1, 0, 0, 0, 0, 0, 0, 0, 0, 0, whichPos, true, 0, 34, 0, 1);

			// posX = sashtype.bOpeningObject.startingX +
			// (sashtype.bOpeningObject.bX2 - sashtype.bOpeningObject.startingX)
			// * 2
			// * split / 100;

			posX = sashtype.myParentO.startingCX
					+ (sashtype.myParentO.bCX2 - sashtype.myParentO.startingCX)
					* 2 * split / 100;

			addMullionV.newStartingXCenter = posX;

			addMullionV.cOrM = interLocks[1];

			addMullionV.newVCCol = 2;

			addMullionV.doAddMullionsV(
					(int) (myParentO.startingX + myParentO.widthPix / 2),
					(int) (myParentO.highestY + (Math.max(myParentO.bY4,
							myParentO.bY3) - myParentO.highestY) / 2), true, 2,
					1, 0, 0, 0, 0, 0, 0, 0, 0, 0, whichPos, true, 0, 35, 0, 0);

			// posX = sashtype.bOpeningObject.startingX +
			// (sashtype.bOpeningObject.bX2 - sashtype.bOpeningObject.startingX)
			// * 3
			// * split / 100;

			posX = sashtype.myParentO.startingCX
					+ (sashtype.myParentO.bCX2 - sashtype.myParentO.startingCX)
					* 3 * split / 100;

			addMullionV.newStartingXCenter = posX;

			addMullionV.cOrM = interLocks[2];

			addMullionV.newVCCol = 3;

			addMullionV.doAddMullionsV(
					(int) (myParentO.startingX + myParentO.widthPix / 2),
					(int) (myParentO.highestY + (Math.max(myParentO.bY4,
							myParentO.bY3) - myParentO.highestY) / 2), true, 2,
					1, 0, 0, 0, 0, 0, 0, 0, 0, 0, whichPos, true, 0, 34, 0, 2);

			Object[] oo = sashtype.openings.toArray();
			sashtype.openings.clear();
			sashtype.frames.clear();
			for (int i = 0; i < oo.length; i++) {
				if (i == 1 || i == 2) {
					setOpeningToSash(oo, i);

					this.do1SashSlider(((OpeningObject) oo[i]), sashClassType,
							sashOnInsideTrack[i], sashGlazedOut[i], sameParts,
							paneType[i], i, sashtype, true);

				} else {
					setOPeningFixed(oo, i);

				}
				sashtype.openings.add(oo[i]);
			}

		}
		sashtype.xCols = sashtype.bOpeningObject.xCols = 4;
		sashtype.yRows = sashtype.bOpeningObject.yRows = 1;

		return sashtype;
	}

	public SashTypeObject doDS_4LS(SashTypeObject sashtype) throws Exception {

		boolean goodToGo;
		goodToGo = this.checkHSliderShape();
		if (goodToGo) {

			opens = 3;

			AddMullionV addMullionV = new AddMullionV(sashtype.bOpeningObject,
					myFrame2.jobItem, myFrame2, interLocks[0]);

			// double posX = sashtype.bOpeningObject.startingX
			// + (sashtype.bOpeningObject.bX2 -
			// sashtype.bOpeningObject.startingX) * split / 100;

			double posX = sashtype.myParentO.startingCX
					+ (sashtype.myParentO.bCX2 - sashtype.myParentO.startingCX)
					* split / 100;

			addMullionV.newStartingXCenter = posX;

			addMullionV.vcStartY = sashtype.bOpeningObject.highestY;
			addMullionV.vcEnd = 1;
			addMullionV.vcStart = 1;
			addMullionV.vcEndY = 500;// sashtype.bOpeningObject.bY4,
			// ;
			addMullionV.newVCCol = 1;
			addMullionV.newVCRow = 1;

			addMullionV.doAddMullionsV(
					(int) (myParentO.startingX + myParentO.widthPix / 2),
					(int) (myParentO.highestY + (Math.max(myParentO.bY4,
							myParentO.bY3) - myParentO.highestY) / 2), true, 2,
					1, 0, 0, 0, 0, 0, 0, 0, 0, 0, whichPos, true, 0, 33, 0, 0);

			// posX = sashtype.bOpeningObject.startingX +
			// (sashtype.bOpeningObject.bX2 - sashtype.bOpeningObject.startingX)
			// * 2
			// * split / 100;

			posX = sashtype.myParentO.startingCX
					+ (sashtype.myParentO.bCX2 - sashtype.myParentO.startingCX)
					* 2 * split / 100;

			addMullionV.newStartingXCenter = posX;

			addMullionV.cOrM = interLocks[1];

			addMullionV.newVCCol = 2;

			addMullionV.doAddMullionsV(
					(int) (myParentO.startingX + myParentO.widthPix / 2),
					(int) (myParentO.highestY + (Math.max(myParentO.bY4,
							myParentO.bY3) - myParentO.highestY) / 2), true, 2,
					1, 0, 0, 0, 0, 0, 0, 0, 0, 0, whichPos, true, 0, 35, 0, 0);

			// posX = sashtype.bOpeningObject.startingX +
			// (sashtype.bOpeningObject.bX2 - sashtype.bOpeningObject.startingX)
			// * 3
			// * split / 100;

			posX = sashtype.myParentO.startingCX
					+ (sashtype.myParentO.bCX2 - sashtype.myParentO.startingCX)
					* 3 * split / 100;

			addMullionV.newStartingXCenter = posX;

			addMullionV.cOrM = interLocks[2];

			addMullionV.newVCCol = 3;

			addMullionV.doAddMullionsV(
					(int) (myParentO.startingX + myParentO.widthPix / 2),
					(int) (myParentO.highestY + (Math.max(myParentO.bY4,
							myParentO.bY3) - myParentO.highestY) / 2), true, 2,
					1, 0, 0, 0, 0, 0, 0, 0, 0, 0, whichPos, true, 0, 33, 0, 0);

			Object[] oo = sashtype.openings.toArray();
			sashtype.openings.clear();
			sashtype.frames.clear();
			for (int i = 0; i < oo.length; i++) {
				setOpeningToSash(oo, i);
				this.do1SashSlider(((OpeningObject) oo[i]), sashClassType,
						sashOnInsideTrack[i], sashGlazedOut[i], sameParts,
						paneType[i], i, sashtype, true);

				sashtype.openings.add(oo[i]);
			}

		}
		sashtype.xCols = sashtype.bOpeningObject.xCols = 4;
		sashtype.yRows = sashtype.bOpeningObject.yRows = 1;

		return sashtype;
	}

	public SashTypeObject doSL_3LS(SashTypeObject sashtype) throws Exception {

		boolean goodToGo;
		goodToGo = this.checkHSliderShape();
		if (goodToGo) {

			opens = 3;

			AddMullionV addMullionV = new AddMullionV(sashtype.bOpeningObject,
					myFrame2.jobItem, myFrame2, interLocks[0]);

			// double posX = sashtype.bOpeningObject.startingX
			// + (sashtype.bOpeningObject.bX2 -
			// sashtype.bOpeningObject.startingX) * split / 100;

			double posX = sashtype.myParentO.startingCX
					+ (sashtype.myParentO.bCX2 - sashtype.myParentO.startingCX)
					* split / 100;

			addMullionV.newStartingXCenter = posX;

			addMullionV.vcStartY = sashtype.bOpeningObject.highestY;
			addMullionV.vcEnd = 1;
			addMullionV.vcStart = 1;
			addMullionV.vcEndY = 500;// sashtype.bOpeningObject.bY4,
			// ;
			addMullionV.newVCCol = 1;
			addMullionV.newVCRow = 1;

			addMullionV.doAddMullionsV(
					(int) (myParentO.startingX + myParentO.widthPix / 2),
					(int) (myParentO.highestY + (Math.max(myParentO.bY4,
							myParentO.bY3) - myParentO.highestY) / 2), true, 2,
					1, 0, 0, 0, 0, 0, 0, 0, 0, 0, whichPos, true, 0, 34, 0, 1);

			// posX = sashtype.bOpeningObject.startingX +
			// sashtype.bOpeningObject.bX2 - sashtype.bOpeningObject.startingX
			// - (sashtype.bOpeningObject.bX2 -
			// sashtype.bOpeningObject.startingX) * split / 100;
			//
			posX = sashtype.myParentO.startingCX + sashtype.myParentO.bCX2
					- sashtype.myParentO.startingCX
					- (sashtype.myParentO.bCX2 - sashtype.myParentO.startingCX)
					* split / 100;

			addMullionV.newStartingXCenter = posX;

			addMullionV.cOrM = interLocks[1];

			addMullionV.newVCCol = 2;

			addMullionV.doAddMullionsV(
					(int) (myParentO.startingX + myParentO.widthPix / 2),
					(int) (myParentO.highestY + (Math.max(myParentO.bY4,
							myParentO.bY3) - myParentO.highestY) / 2), true, 2,
					1, 0, 0, 0, 0, 0, 0, 0, 0, 0, whichPos, true, 0, 34, 0, 2);

			Object[] oo = sashtype.openings.toArray();

			sashtype.openings.clear();
			sashtype.frames.clear();

			for (int i = 0; i < oo.length; i++) {
				if (i == 0 || i == 2) {
					setOpeningToSash(oo, i);

					this.do1SashSlider(((OpeningObject) oo[i]), sashClassType,
							sashOnInsideTrack[i], sashGlazedOut[i], sameParts,
							paneType[i], i, sashtype, true);

				} else {
					setOPeningFixed(oo, i);

				}
				sashtype.openings.add(oo[i]);
			}

		}
		sashtype.xCols = sashtype.bOpeningObject.xCols = 3;
		sashtype.yRows = sashtype.bOpeningObject.yRows = 1;
		return sashtype;
	}

	public SashTypeObject doSSR(SashTypeObject sashtype) throws Exception {

		boolean goodToGo;
		goodToGo = this.checkHSliderShape();
		if (goodToGo) {

			opens = 3;

			AddMullionV addMullionV = new AddMullionV(sashtype.bOpeningObject,
					myFrame2.jobItem, myFrame2, interLocks[0]);

			// double posX = sashtype.bOpeningObject.startingX
			// + (sashtype.bOpeningObject.bX2 -
			// sashtype.bOpeningObject.startingX) * split / 100;

			double posX = sashtype.myParentO.startingCX
					+ (sashtype.myParentO.bCX2 - sashtype.myParentO.startingCX)
					* split / 100;

			addMullionV.newStartingXCenter = posX;

			addMullionV.vcStartY = sashtype.bOpeningObject.highestY;
			addMullionV.vcEnd = 1;
			addMullionV.vcStart = 1;
			addMullionV.vcEndY = 500;// sashtype.bOpeningObject.bY4,
			// ;
			addMullionV.newVCCol = 1;
			addMullionV.newVCRow = 1;

			addMullionV.doAddMullionsV(
					(int) (myParentO.startingX + myParentO.widthPix / 2),
					(int) (myParentO.highestY + (Math.max(myParentO.bY4,
							myParentO.bY3) - myParentO.highestY) / 2), true, 2,
					1, 0, 0, 0, 0, 0, 0, 0, 0, 0, whichPos, true, 0, 34, 0, 1);

			Object[] oo = sashtype.openings.toArray();
			sashtype.openings.clear();
			sashtype.frames.clear();
			for (int i = 0; i < oo.length; i++) {
				if (i == 0) {
					setOpeningToSash(oo, i);

					this.do1SashSlider(((OpeningObject) oo[i]), sashClassType,
							sashOnInsideTrack[i], sashGlazedOut[i], sameParts,
							paneType[i], i, sashtype, true);

				} else {
					setOPeningFixed(oo, i);

				}
				sashtype.openings.add(oo[i]);
			}

		}
		sashtype.xCols = sashtype.bOpeningObject.xCols = 2;
		sashtype.yRows = sashtype.bOpeningObject.yRows = 1;

		return sashtype;
	}

	public SashTypeObject doSSL(SashTypeObject sashtype) throws Exception {

		boolean goodToGo;
		goodToGo = this.checkHSliderShape();
		if (goodToGo) {

			opens = 3;

			AddMullionV addMullionV = new AddMullionV(sashtype.bOpeningObject,
					myFrame2.jobItem, myFrame2, interLocks[0]);

			// double posX = sashtype.bOpeningObject.startingX
			// + (sashtype.bOpeningObject.bX2 -
			// sashtype.bOpeningObject.startingX) * split / 100;

			double posX = sashtype.myParentO.startingCX
					+ (sashtype.myParentO.bCX2 - sashtype.myParentO.startingCX)
					* split / 100;

			addMullionV.newStartingXCenter = posX;

			addMullionV.vcStartY = sashtype.bOpeningObject.highestY;
			addMullionV.vcEnd = 1;
			addMullionV.vcStart = 1;
			addMullionV.vcEndY = 500;// sashtype.bOpeningObject.bY4,
			// ;
			addMullionV.newVCCol = 1;
			addMullionV.newVCRow = 1;

			addMullionV.doAddMullionsV(
					(int) (myParentO.startingX + myParentO.widthPix / 2),
					(int) (myParentO.highestY + (Math.max(myParentO.bY4,
							myParentO.bY3) - myParentO.highestY) / 2), true, 2,
					1, 0, 0, 0, 0, 0, 0, 0, 0, 0, whichPos, true, 0, 34, 0, 2);

			Object[] oo = sashtype.openings.toArray();

			sashtype.openings.clear();
			sashtype.frames.clear();
			for (int i = 0; i < oo.length; i++) {
				if (i == 0) {
					setOPeningFixed(oo, i);

				} else {
					setOpeningToSash(oo, i);
					this.do1SashSlider(((OpeningObject) oo[i]), sashClassType,
							sashOnInsideTrack[i], sashGlazedOut[i], sameParts,
							paneType[i], i, sashtype, true);
				}

				sashtype.openings.add(oo[i]);
			}

		}
		sashtype.xCols = sashtype.bOpeningObject.xCols = 2;
		sashtype.yRows = sashtype.bOpeningObject.yRows = 1;

		return sashtype;

	}

	public SashTypeObject doSH(SashTypeObject sashtype) throws Exception {

		boolean goodToGo;
		goodToGo = this.checkVSliderShape();
		if (goodToGo) {

			opens = 3;

			AddMullionH addMullionH = new AddMullionH(sashtype.bOpeningObject,
					myFrame2.jobItem, myParentO.myParent.myFrame2,
					interLocks[0]);

			// double posY = sashtype.bOpeningObject.highestY +
			// (sashtype.bOpeningObject.bY4 - sashtype.bOpeningObject.highestY)
			// * split / 100;

			double posY = sashtype.myParentO.startingCY //sashtype.myParentO.myParent.startingCY
					+ (sashtype.myParentO.bCY4 - sashtype.myParentO.startingCY)
					* split / 100;

			addMullionH.newStartingYCenter = posY;

			addMullionH.hcStartX = sashtype.bOpeningObject.startingX;
			addMullionH.hcEnd = 1;
			addMullionH.hcStart = 1;
			addMullionH.hcEndX = sashtype.bOpeningObject.bX2;
			;// sashtype.bOpeningObject.bY4, ;
			addMullionH.newHCCol = 1;
			addMullionH.newHCRow = 1;

			addMullionH.doAddMullionsH(
					(int) (myParentO.startingX + myParentO.widthPix / 2),
					(int) (myParentO.highestY + (Math.max(myParentO.bY4,
							myParentO.bY3) - myParentO.highestY) / 2), true, 2,
					1, 0, 0, 0, 0, 0, 0, 0, 0, 0, whichPos, true, 0, 34, 0);

			Object[] oo = sashtype.openings.toArray();
			sashtype.openings.clear();
			sashtype.frames.clear();
			for (int i = 0; i < oo.length; i++) {
				((OpeningObject) oo[i]).clearGlassBomForShape();

				if (i == 0) {
					setOPeningFixed(oo, i);

				} else {

					setOpeningToSash(oo, i);

					this.do1SashSlider(((OpeningObject) oo[i]), sashClassType,
							sashOnInsideTrack[i], sashGlazedOut[i], sameParts,
							paneType[i], i, sashtype, true);

				}

				sashtype.openings.add(oo[i]);
			}

			addMullionH.goodToGo = true;
			addMullionH = null;
		}

		sashtype.xCols = sashtype.bOpeningObject.xCols = 1;
		sashtype.yRows = sashtype.bOpeningObject.yRows = 2;

		return sashtype;
	}

	public SashTypeObject doDH(SashTypeObject sashtype) throws Exception {

		boolean goodToGo;
		goodToGo = this.checkVSliderShape();
		if (goodToGo) {

			opens = 3;

			AddMullionH addMullionH = new AddMullionH(sashtype.bOpeningObject,
					myFrame2.jobItem, myParentO.myParent.myFrame2,
					interLocks[0]);

			// double posY = sashtype.bOpeningObject.highestY +
			// (sashtype.bOpeningObject.bY4 - sashtype.bOpeningObject.highestY)
			// * split / 100;

			double posY = sashtype.myParentO.startingCY
					+ (sashtype.myParentO.bCY4 - sashtype.myParentO.startingCY)
					* split / 100;

			addMullionH.newStartingYCenter = posY;

			addMullionH.hcStartX = sashtype.bOpeningObject.startingX;
			addMullionH.hcEnd = 1;
			addMullionH.hcStart = 1;
			addMullionH.hcEndX = sashtype.bOpeningObject.bX2;
			;// sashtype.bOpeningObject.bY4, ;
			addMullionH.newHCCol = 1;
			addMullionH.newHCRow = 1;

			addMullionH.doAddMullionsH(
					(int) (myParentO.startingX + myParentO.widthPix / 2),
					(int) (myParentO.highestY + (Math.max(myParentO.bY4,
							myParentO.bY3) - myParentO.highestY) / 2), true, 2,
					1, 0, 0, 0, 0, 0, 0, 0, 0, 0, whichPos, true, 0, 33, 0);

			Object[] oo = sashtype.openings.toArray();
			sashtype.openings.clear();
			sashtype.frames.clear();
			for (int i = 0; i < oo.length; i++) {

				setOpeningToSash(oo, i);

				this.do1SashSlider(((OpeningObject) oo[i]), sashClassType,
						sashOnInsideTrack[i], sashGlazedOut[i], sameParts,
						paneType[i], i, sashtype, true);

				sashtype.openings.add(oo[i]);
			}

			addMullionH.goodToGo = true;
			addMullionH = null;
		}
		sashtype.xCols = sashtype.bOpeningObject.xCols = 1;
		sashtype.yRows = sashtype.bOpeningObject.yRows = 2;

		return sashtype;
	}

	public SashTypeObject doLouver(SashTypeObject sashtype,
			Collection existingSashes) throws Exception {

		double stdSize = 0;
		double overlap = 0;

		if (myFrame2.mySeries.getSeriesUom() == 1) {
			stdSize = new BigDecimal(sashtype.louvreStdSizeM).multiply(
					myFrame2.metricscale).doubleValue();
			overlap = new BigDecimal(sashtype.louvreOverlapM).multiply(
					myFrame2.metricscale).doubleValue();

		} else {

			stdSize = new BigDecimal(sashtype.louvreStdSizeI).multiply(
					myFrame2.imperialscale).doubleValue();
			overlap = new BigDecimal(sashtype.louvreOverlapI).multiply(
					myFrame2.imperialscale).doubleValue();

		}

		boolean goodToGo;
		if (myParentO.shapeID != 1) {
			goodToGo = this.checkVSliderShape();
		} else {
			goodToGo = true;
		}
		if (goodToGo) {

			opens = 2;
			sashtype.opens = 2;

			AddMullionH addMullionH = new AddMullionH(sashtype.bOpeningObject,
					myFrame2.jobItem, myParentO.myParent.myFrame2, 5);

			double litesD = (sashtype.bOpeningObject.heightPix - stdSize)
					/ (stdSize - overlap);

			int litesInt = (int) ((sashtype.bOpeningObject.heightPix - stdSize) / (stdSize - overlap));

			int noLites = 0;

			partialLouvreSize = litesD - litesInt;

			if (sashtype.louvrePartial && partialLouvreSize > 0) {
				noLites = litesInt + 1;
			} else if (!sashtype.louvrePartial && litesD - litesInt > 0) {
				JOptionPane
						.showMessageDialog(null,
								"Louvre window height will result \n"
										+ "in Partial Blades being used",
								"Louvre Window - Warning!",
								JOptionPane.WARNING_MESSAGE);

				noLites = litesInt + 1;

			}

			noLites = noLites + 1;

			double myH = sashtype.bOpeningObject.heightPix / noLites;

			double posY = sashtype.bOpeningObject.highestY;

			sashtype.paneType = null;
			sashOnInsideTrack = null;
			sashGlazedOut = null;
			sashtype.paneType = new int[noLites];
			sashOnInsideTrack = new int[noLites];
			sashGlazedOut = new boolean[noLites];
			sashtype.noTracks = noLites;
			((ShapeObject) sashtype).noTracks = noLites;

			for (int ii = 0; ii < noLites; ii++) {
				sashtype.paneType[ii] = 1;
				sashOnInsideTrack[ii] = noLites - ii;
				sashGlazedOut[ii] = false;
			}

			paneType = sashtype.paneType;
			Object[] oo = null;

			for (int i = 0; i < noLites - 1; i++) {
				if (i == 0 && partialLouvreSize > 0) {
					addMullionH.newStartingYCenter = posY
							+ (partialLouvreSize * (stdSize - overlap));
				} else {
					addMullionH.newStartingYCenter = posY
							+ (1 * (stdSize - overlap));
				}

				posY = addMullionH.newStartingYCenter;
				addMullionH.hcStartX = sashtype.bOpeningObject.startingX;
				addMullionH.hcEnd = 1;
				addMullionH.hcStart = 1;
				addMullionH.hcEndX = sashtype.bOpeningObject.bX2;
				;// sashtype.bOpeningObject.bY4,
					// ;
				addMullionH.newHCCol = 1;
				addMullionH.newHCRow = i + 1;

				addMullionH.doAddMullionsH(
						(int) (myParentO.startingX + myParentO.widthPix / 2),
						(int) (myParentO.highestY + (Math.max(myParentO.bY4,
								myParentO.bY3) - myParentO.highestY) / 2),
						true, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, whichPos, true,
						0, 0, 0);

			}

			oo = sashtype.openings.toArray();
			sashtype.openings.clear();
			sashtype.frames.clear();

			for (int i = 0; i < oo.length; i++) {
				setOpeningToSash(oo, i);

				this.do1SashSlider(((OpeningObject) oo[i]), sashClassType,
						sashOnInsideTrack[i], sashGlazedOut[i], sameParts,
						paneType[i], i, sashtype, true);

				sashtype.openings.add(oo[i]);

			}

			sashtype.glazedOut = true;
			sashtype.myParentO.glazedOut = true;
			sashtype.bOpeningObject.glazedOut = true;
			sashtype.myParent.bOpeningObject.glazedOut = true;
			sashtype.myParent.glazedOut = true;
			myParentO.sashObjectMid.opens = sashtype.opens;
		}

		return sashtype;
	}

	public SashTypeObject doFolding(SashTypeObject sashtype,
			Collection existingSashes) throws Exception {

		boolean goodToGo;
		if (myParentO.shapeID != 1) {
			goodToGo = this.checkVSliderShape();
		} else {
			goodToGo = true;
		}
		if (goodToGo) {

			opens = 3;
			sashtype.opens = 3;

			AddMullionV addMullionV = new AddMullionV(sashtype.bOpeningObject,
					myFrame2.jobItem, myParentO.myParent.myFrame2,
					interLocks[0]);

			int noLites = sashtype.noOfLeafs;

			double myW = sashtype.bOpeningObject.widthPix / noLites;
			double posX = sashtype.bOpeningObject.startingX;

			paneType = sashtype.paneType;
			Object[] oo = null;

			for (int i = 0; i < noLites - 1; i++) {
				addMullionV.cOrM = interLocks[i];
				addMullionV.newStartingXCenter = posX + myW;
				posX = addMullionV.newStartingXCenter;
				addMullionV.vcStartY = sashtype.bOpeningObject.highestY;
				addMullionV.vcEnd = 1;
				addMullionV.vcStart = 1;
				addMullionV.vcEndY = 500;// sashtype.bOpeningObject.bY4,
				// ;
				addMullionV.newVCCol = i + 1;
				addMullionV.newVCRow = 1;

				addMullionV.doAddMullionsV(
						(int) (myParentO.startingX + myParentO.widthPix / 2),
						(int) (myParentO.highestY + (Math.max(myParentO.bY4,
								myParentO.bY3) - myParentO.highestY) / 2),
						true, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, whichPos, true,
						0, 36, 0, 0);

			}

			oo = sashtype.openings.toArray();
			sashtype.openings.clear();
			sashtype.frames.clear();

			for (int i = 0; i < oo.length; i++) {

				setOpeningToSash(oo, i);
	
				
				this.do1SashSlider(((OpeningObject) oo[i]), sashClassType,
						sashOnInsideTrack[i], sashGlazedOut[i], sameParts,
						paneType[i], i, sashtype, true);
				

				sashtype.openings.add(oo[i]);
			}

			sashtype.glazedOut = false;
			sashtype.myParentO.glazedOut = false;
			sashtype.bOpeningObject.glazedOut = false;
			sashtype.myParent.bOpeningObject.glazedOut = false;
			sashtype.myParent.glazedOut = false;
			myParentO.sashObjectMid.opens = sashtype.opens;
		}
		sashtype.xCols = sashtype.bOpeningObject.xCols = sashtype.noOfLeafs;
		sashtype.yRows = sashtype.bOpeningObject.yRows = 1;

		return sashtype;
	}

	public SashTypeObject doPocket(SashTypeObject sashtype,
			Collection existingSashes) throws Exception {

		boolean goodToGo;

		if (myParentO.shapeID != 1) {
			goodToGo = this.checkVSliderShape();
		} else {
			goodToGo = true;
		}

		if (goodToGo) {

			opens = 3;
			sashtype.opens = 3;

			AddMullionV addMullionV = new AddMullionV(sashtype.bOpeningObject,
					myFrame2.jobItem, myParentO.myParent.myFrame2,
					interLocks[0]);

			int noLites = sashtype.noOfLeafs;

			double myW = sashtype.bOpeningObject.widthPix / noLites;
			double posX = sashtype.bOpeningObject.startingX;

			paneType = sashtype.paneType;
			Object[] oo = null;

			for (int i = 0; i < noLites - 1; i++) {
				addMullionV.cOrM = interLocks[i];
				addMullionV.newStartingXCenter = posX + myW;
				posX = addMullionV.newStartingXCenter;
				addMullionV.vcStartY = sashtype.bOpeningObject.highestY;
				addMullionV.vcEnd = 1;
				addMullionV.vcStart = 1;
				addMullionV.vcEndY = 500;// sashtype.bOpeningObject.bY4,

				addMullionV.newVCCol = i + 1;
				addMullionV.newVCRow = 1;

				addMullionV.doAddMullionsV(
						(int) (myParentO.startingX + myParentO.widthPix / 2),
						(int) (myParentO.highestY + (Math.max(myParentO.bY4,
								myParentO.bY3) - myParentO.highestY) / 2),
						true, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, whichPos, true,
						0, 33, 0, 0);
			}

			oo = sashtype.openings.toArray();
			sashtype.openings.clear();
			sashtype.frames.clear();

			for (int i = 0; i < oo.length; i++) {
				setOpeningToSash(oo, i);
				this.do1SashSlider(((OpeningObject) oo[i]), sashClassType,
						sashOnInsideTrack[i], sashGlazedOut[i], sameParts,
						paneType[i], i, sashtype, true);

				sashtype.openings.add(oo[i]);
			}

			sashtype.glazedOut = false;
			sashtype.myParentO.glazedOut = false;
			sashtype.bOpeningObject.glazedOut = false;
			sashtype.myParent.bOpeningObject.glazedOut = false;
			sashtype.myParent.glazedOut = false;
			myParentO.sashObjectMid.opens = sashtype.opens;
		}
		sashtype.xCols = sashtype.bOpeningObject.xCols = sashtype.noOfLeafs;
		sashtype.yRows = sashtype.bOpeningObject.yRows = 1;

		return sashtype;
	}

	public SashTypeObject doCenterFixedSliderSashType(SashTypeObject sashtype)
			throws Exception {

		boolean goodToGo;
		goodToGo = this.checkHSliderShape();

		if (goodToGo) {

			opens = 3;

			AddMullionV addMullionV = new AddMullionV(sashtype.bOpeningObject,
					myFrame2.jobItem, myParentO.myParent.myFrame2,
					interLocks[0]);

			// double posX = sashtype.bOpeningObject.startingX
			// + (sashtype.bOpeningObject.bX2 -
			// sashtype.bOpeningObject.startingX) * split / 100;

			double posX = sashtype.myParentO.startingCX
					+ (sashtype.myParentO.bCX2 - sashtype.myParentO.startingCX)
					* split / 100;

			addMullionV.newStartingXCenter = posX;
			addMullionV.vcStartY = sashtype.bOpeningObject.highestY;
			addMullionV.vcEnd = 1;
			addMullionV.vcStart = 1;
			addMullionV.vcEndY = 500;// sashtype.bOpeningObject.bY4,

			addMullionV.newVCCol = 1;
			addMullionV.newVCRow = 1;

			addMullionV.doAddMullionsV(
					(int) (myParentO.startingX + myParentO.widthPix / 2),
					(int) (myParentO.highestY + (Math.max(myParentO.bY4,
							myParentO.bY3) - myParentO.highestY) / 2), true, 2,
					1, 0, 0, 0, 0, 0, 0, 0, 0, 0, whichPos, true, 0, 34, 0, 1);

			// posX = sashtype.bOpeningObject.startingX +
			// sashtype.bOpeningObject.bX2 - sashtype.bOpeningObject.startingX
			// - (sashtype.bOpeningObject.bX2 -
			// sashtype.bOpeningObject.startingX) * split / 100;

			posX = sashtype.myParentO.startingCX + sashtype.myParentO.bCX2
					- sashtype.myParentO.startingCX
					- (sashtype.myParentO.bCX2 - sashtype.myParentO.startingCX)
					* split / 100;

			addMullionV.newStartingXCenter = posX;
			addMullionV.cOrM = interLocks[1];
			addMullionV.newVCCol = 2;

			addMullionV.doAddMullionsV(
					(int) (myParentO.startingX + myParentO.widthPix / 2),
					(int) (myParentO.highestY + (Math.max(myParentO.bY4,
							myParentO.bY3) - myParentO.highestY) / 2), true, 2,
					1, 0, 0, 0, 0, 0, 0, 0, 0, 0, whichPos, true, 0, 34, 0, 2);

			Object[] oo = sashtype.openings.toArray();
			sashtype.openings.clear();
			sashtype.frames.clear();

			for (int i = 0; i < oo.length; i++) {
				if (i == 1) {
					setOpeningToSash(oo, i);
					this.do1SashSlider(((OpeningObject) oo[i]), sashClassType,
							sashOnInsideTrack[i], sashGlazedOut[i], sameParts,
							paneType[i], i, sashtype, true);
				} else {
					setOPeningFixed(oo, i);
				}
				sashtype.openings.add(oo[i]);
			}

		}
		sashtype.xCols = sashtype.bOpeningObject.xCols = sashtype.noOfLeafs;
		sashtype.yRows = sashtype.bOpeningObject.yRows = 1;

		return sashtype;
	}

	public SashTypeObject createSashType() throws Exception {

		SashTypeObject sashtype = new SashTypeObject(myFrame2);

		sashtype.myFrame2 = myFrame2;
		((ShapeObject) sashtype).myFrame2 = myFrame2;

		sashtype = (SashTypeObject) sashtype
				.cloneShapeFromParentOpening(myParentO);

		CreateShapeMethods createShape = new CreateShapeMethods(myParentO, 2,
				myFrame2);

		SeriesValidOpeningShape myOp = ItemFrame.getApplicationBaseRules()
				.getSeriesValidOpeningById(sashUDID);

		sashtype.louvreOverlapI = myOp.getLouvreoverlapi();
		sashtype.louvreOverlapM = myOp.getLouvreoverlap();
		sashtype.louvreStdSizeI = myOp.getLouvresizei();
		sashtype.louvreStdSizeM = myOp.getLouvresize();
		sashtype.louvrePartial = myOp.isLouvrepartial();
		sashtype.isglazed = myOp.isGlazed();

		if (!myOp.isGlazed()) {
			sashtype.unGlazed = true;
		}

		sashtype.myParent = myParentO.myParent;
		sashtype.myFacet = myParentO.myParent.myFacet;

		sashtype.openingTypeClass = productT;
		sashtype.sashClassType = sashClassType;
		sashtype.userDefinedOpeningID = sashUDID;
		sashtype.noOfLeafs = noOfLeafs;
		sashtype.sashOnTrack = sashOnInsideTrack;
		sashtype.noTracks = notracks;
		sashtype.whichPos = whichPos;
		sashtype.opens = opens;
		sashtype.isOriel = isOriel;
		sashtype.interLocks = interLocks; // out
		sashtype.paneType = paneType;
		sashtype.split = split;
		sashtype.glazedOut = glazedOut;
		sashtype.sashGlazedOut = sashGlazedOut;

		Object[] returns = this.setPartDimsSashType(sashtype, createShape);

		sashtype = (SashTypeObject) returns[0];

		createShape = (CreateShapeMethods) returns[1];

		if (!myParentO.top2Part.posInUse) {

			sashtype.top2Part = (Profiles) sashtype.top2Part
					.cloneProfile(sashtype.top1Part);
			sashtype.top2Part.posInUse = false;
			sashtype.top2Part.lengthM = 0;
			sashtype.top2Part.lengthI = 0;
			sashtype.top2 = (Top2Object) sashtype.top2
					.cloneProfile(sashtype.top2Part);

			sashtype.top2.posInUse = false;

		}

		createShape.getClearance(sashtype);

		sashtype = (SashTypeObject) createShape.doShapeBkgrd(sashtype);

		sashtype = (SashTypeObject) createShape.makeSides(sashtype);

		sashtype = (SashTypeObject) createShape.makeSidesStraight(sashtype);

		sashtype = (SashTypeObject) createShape.doParts(sashtype, true);

		sashtype = (SashTypeObject) createShape.setBaseInfo(sashtype, 1, true);

		// myFrame.bom.clear();
		// myFrame.executePartRules();
		//
		sashtype.partObjects = createShape
				.setPartObjectsAndCollection(sashtype);

		sashtype.top1 = (Top1Object) sashtype.top1
				.cloneProfile(sashtype.top1Part);
		sashtype.top2 = (Top2Object) sashtype.top2
				.cloneProfile(sashtype.top2Part);
		sashtype.top3 = (Top3Object) sashtype.top3
				.cloneProfile(sashtype.top3Part);

		sashtype.bot1 = (Bot1Object) sashtype.bot1
				.cloneProfile(sashtype.bot1Part);
		sashtype.bot2 = (Bot2Object) sashtype.bot2
				.cloneProfile(sashtype.bot2Part);
		sashtype.bot3 = (Bot3Object) sashtype.bot3
				.cloneProfile(sashtype.bot3Part);

		sashtype.left = (LeftObject) sashtype.left
				.cloneProfile(sashtype.leftPart);
		sashtype.right = (RightObject) sashtype.right
				.cloneProfile(sashtype.rightPart);

		sashtype.myParentFrame = myParentO.myParent;
		sashtype.extraExtend = extendExtra;

		sashtype.sequenceID = myParentO.a_sequenceID;

		sashtype.myFrame2 = myParentO.myParent.myFrame2;

		sashtype.bom.clear();
		sashtype.clearBomForShape();
		sashtype.executePartRules(true, true, "createSash.d01SashSlider.3144");

		sashtype.bOpeningObject = sashtype.doMainOpening();

		sashtype.bOpeningObject.startRow = 1;
		sashtype.bOpeningObject.startCol = 1;
		sashtype.bOpeningObject.endRow = 1;
		sashtype.bOpeningObject.endCol = 1;
		sashtype.bOpeningObject.myParent = sashtype;

		sashtype.xCols = 1;
		sashtype.yRows = 1;
		sashtype.bOpeningObject.xCols = 1;
		sashtype.bOpeningObject.yRows = 1;

		sashtype.a_levelID = 121;
		// sashtype.options.clear();
		// sashtype.executeOptionRules("createSash.createSAshtype.2332");

		Object[] oo = sashtype.openings.toArray();
		sashtype.openings.clear();

		for (Object o : oo) {
			((OpeningObject) o).unGlazed = true;
			((OpeningObject) o).glazingBeadsIn.clear();
			((OpeningObject) o).glazingBeadsMid.clear();
			((OpeningObject) o).glazingBeadsOut.clear();

			((OpeningObject) o).myGlassIn = null;
			((OpeningObject) o).myGlassMid = null;
			((OpeningObject) o).myGlassOut = null;

			sashtype.openings.add(o);

		}

		return sashtype;
	}

	public boolean checkHSliderShape() throws Exception {

		boolean goodToGo = true;
		if (myParentO.shapeID != 1) {
			JOptionPane.showMessageDialog(null,
					"Invalid Shape for Horizontal Slider.",
					"Invalid Sash Shape - Error!", JOptionPane.ERROR_MESSAGE);
			this.doPictureWindow();
			goodToGo = false;
		}
		return goodToGo;

	}

	public boolean checkVSliderShape() throws Exception {

		boolean goodToGo = true;
		if (myParentO.noSidesLeft == 0 || myParentO.noSidesRight == 0
				|| !Double.isInfinite(myParentO.left.slope)
				|| !Double.isInfinite(myParentO.right.slope)) {
			JOptionPane.showMessageDialog(null,
					"Invalid Shape for Vertical Slider.",
					"Invalid Sash Shape - Error!", JOptionPane.ERROR_MESSAGE);
			this.doPictureWindow();
			goodToGo = false;
		}
		return goodToGo;

	}

	public void setOpeningToSash(Object[] oo, int i) {

		((OpeningObject) oo[i]).glazedOut = sashGlazedOut[i];
		((OpeningObject) oo[i]).myFrame2 = myParentO.myFrame2;
		((OpeningObject) oo[i]).unGlazed = true;
		((OpeningObject) oo[i]).myGlassIn = null;
		((OpeningObject) oo[i]).myGlassMid = null;
		((OpeningObject) oo[i]).myGlassOut = null;
		((OpeningObject) oo[i]).leafNo = i + 1;
		if (((OpeningObject) oo[i]).glazingBeadsIn != null) {
			((OpeningObject) oo[i]).glazingBeadsIn.clear();
		}
		if (((OpeningObject) oo[i]).glazingBeadsMid != null) {
			((OpeningObject) oo[i]).glazingBeadsMid.clear();
		}
		if (((OpeningObject) oo[i]).glazingBeadsOut != null) {
			((OpeningObject) oo[i]).glazingBeadsOut.clear();
		}
		((OpeningObject) oo[i]).contentMid = 2;
	}

	public void setOPeningFixed(Object[] oo, int i) throws Exception {

		((OpeningObject) oo[i]).contentMid = 1;
		((OpeningObject) oo[i]).glazedOut = sashGlazedOut[i];

		((OpeningObject) oo[i]).sashObjectMid = null;
		((OpeningObject) oo[i]).sashObjectIn = null;
		((OpeningObject) oo[i]).sashObjectOut = null;

		((OpeningObject) oo[i]).unGlazed = false;
		((OpeningObject) oo[i]).leafNo = i + 1;
		CreateOpenings createOp = new CreateOpenings(((OpeningObject) oo[i]),
				this.myFrame2);
		createOp.doOpeningOperations(((OpeningObject) oo[i]));
		// ((OpeningObject) oo[i]).doMainOpening();
		// ((OpeningObject) oo[i]).doOpenings();

	}

	@SuppressWarnings("unchecked")
	public SashLeaf doLouvre(OpeningObject myOpening, int type, int track,
			boolean gOut, boolean sameParts, int panetype, int count,
			SashTypeObject sashtype, Collection existingSashes)
			throws Exception {

		myParentO.unGlazed = true;

		myOpening.unGlazed = true;
		myOpening.contentMid = 2;
		SashLeaf mySashLeaf = new SashLeaf();

		mySashLeaf = this.initSashLeaf(myOpening.topIn, myOpening.botIn,
				myOpening.leftIn, myOpening.rightIn, type, myOpening, sashtype,
				mySashLeaf);

		mySashLeaf.shapeID = myOpening.shapeID;

		mySashLeaf.myFrame2 = myOpening.myParent.myFrame2;
		mySashLeaf.paneType = panetype;
		mySashLeaf.openingClass = sashClassType;
		mySashLeaf.userDefinedOpeningID = sashUDID;

		mySashLeaf.myParent = sashtype;
		mySashLeaf.trackNo = track;
		mySashLeaf.a_sequenceID = count + 1;
		mySashLeaf.options.clear();
		mySashLeaf.executeOptionRules("createSash.doLouvre.2451");

		mySashLeaf.executeClearanceRules();

		CreateShapeMethods createShape = new CreateShapeMethods(myOpening, 2,
				myFrame2);

		if (!sameParts) {
			openingChanged = true;
			mySashLeaf.isNewFrame = true;
			mySashLeaf.newPart = true;
		}

		this.initSashParts(mySashLeaf, myOpening);

		if (existingSashes != null && existingSashes.size() > 0) {

			for (Object S : existingSashes.toArray()) {
				if (((SashLeaf) S).leafNo == mySashLeaf.leafNo) {

					mySashLeaf.bOpeningObject = ((SashLeaf) S).bOpeningObject
							.cloneBkgrdOpening(((SashLeaf) S).bOpeningObject);

					mySashLeaf.openings.addAll(((SashLeaf) S).openings);

					mySashLeaf.frames.addAll(((SashLeaf) S).frames);

					if (myOpening.shapeID == ((SashLeaf) S).shapeID
							&& !((SashLeaf) S).myParent.myParent.shapeChanged
							&& myOpening.noSides == ((SashLeaf) S).noSides
							&& myOpening.noSidesTop == ((SashLeaf) S).noSidesTop
							&& myOpening.noSidesBot == ((SashLeaf) S).noSidesBot
							&& myOpening.noSidesLeft == ((SashLeaf) S).noSidesLeft
							&& myOpening.noSidesRight == ((SashLeaf) S).noSidesRight) {

						mySashLeaf.partObjects
								.addAll(((SashLeaf) S).partObjects);
						this.initSashParts(mySashLeaf, myOpening);
						mySashLeaf.glazedOut = ((SashLeaf) S).glazedOut;

						mySashLeaf = this.copyParts(mySashLeaf, ((SashLeaf) S));

						mySashLeaf.xCols = ((SashLeaf) S).xCols;
						mySashLeaf.yRows = ((SashLeaf) S).yRows;

						mySashLeaf.shapeChanged = ((SashLeaf) S).shapeChanged;
						if (((SashLeaf) S).shapeID != 1) {
							mySashLeaf.shapeChanged = true;
						}

						mySashLeaf.top1Part = (Profiles) mySashLeaf.top1Part
								.cloneProfile(((SashLeaf) S).top1Part);
						mySashLeaf.top2Part = (Profiles) mySashLeaf.top2Part
								.cloneProfile(((SashLeaf) S).top2Part);
						mySashLeaf.top3Part = (Profiles) mySashLeaf.top3Part
								.cloneProfile(((SashLeaf) S).top3Part);
						mySashLeaf.bot1Part = (Profiles) mySashLeaf.bot1Part
								.cloneProfile(((SashLeaf) S).bot1Part);
						mySashLeaf.bot2Part = (Profiles) mySashLeaf.bot2Part
								.cloneProfile(((SashLeaf) S).bot2Part);
						mySashLeaf.bot3Part = (Profiles) mySashLeaf.bot3Part
								.cloneProfile(((SashLeaf) S).bot3Part);
						mySashLeaf.leftPart = (Profiles) mySashLeaf.leftPart
								.cloneProfile(((SashLeaf) S).leftPart);
						mySashLeaf.rightPart = (Profiles) mySashLeaf.rightPart
								.cloneProfile(((SashLeaf) S).rightPart);

						mySashLeaf.newPart = false;
					}
				}
			}
		}

		if (!myOpening.top2Part.posInUse) {
			// mySashLeaf.top2Part =
			// mySashLeaf.myTop1Clone(mySashLeaf.top2Part,
			// mySashLeaf.top1Part);
			// mySashLeaf.top2Part.posInUse = false;
			//
			// mySashLeaf.top2 = createShape.myTop2Clone(mySashLeaf.top2,
			// mySashLeaf.top2Part);
			// mySashLeaf.top2.posInUse = false;

			mySashLeaf.top2Part = (Profiles) mySashLeaf.top2Part
					.cloneProfile(mySashLeaf.top1Part);
			mySashLeaf.top2Part.posInUse = false;

			mySashLeaf.top2 = (Top2Object) mySashLeaf.top2
					.cloneProfile(mySashLeaf.top2Part);

			mySashLeaf.top2.posInUse = false;

		}

		Object[] returns = this.setPartDims(mySashLeaf, createShape);
		mySashLeaf = (SashLeaf) returns[0];
		createShape = (CreateShapeMethods) returns[1];
		createShape.getClearance(mySashLeaf);

		mySashLeaf = (SashLeaf) createShape.doShapeBkgrd(mySashLeaf);

		mySashLeaf = (SashLeaf) createShape.makeSides(mySashLeaf);
		mySashLeaf = (SashLeaf) createShape.makeSidesStraight(mySashLeaf);
		mySashLeaf = (SashLeaf) createShape.doParts(mySashLeaf, true);
		mySashLeaf = (SashLeaf) createShape.setBaseInfo(mySashLeaf, 1, true);

		mySashLeaf.top1Part.myParent = mySashLeaf;
		mySashLeaf.top2Part.myParent = mySashLeaf;
		mySashLeaf.top3Part.myParent = mySashLeaf;
		mySashLeaf.bot1Part.myParent = mySashLeaf;
		mySashLeaf.bot2Part.myParent = mySashLeaf;
		mySashLeaf.bot3Part.myParent = mySashLeaf;
		mySashLeaf.leftPart.myParent = mySashLeaf;
		mySashLeaf.rightPart.myParent = mySashLeaf;

		mySashLeaf.partObjects.clear();
		mySashLeaf.partObjects = createShape
				.setPartObjectsAndCollection(mySashLeaf);
		mySashLeaf.partObjects = createShape.doGPParts(mySashLeaf.partObjects,
				mySashLeaf, mySashLeaf.glazedOut);

		// mySashLeaf.top1 = createShape.myTop1Clone(mySashLeaf.top1,
		// mySashLeaf.top1Part);
		// mySashLeaf.top2 = createShape.myTop2Clone(mySashLeaf.top2,
		// mySashLeaf.top2Part);
		// mySashLeaf.top3 = createShape.myTop3Clone(mySashLeaf.top3,
		// mySashLeaf.top3Part);
		// mySashLeaf.bot1 = createShape.myBot1Clone(mySashLeaf.bot1,
		// mySashLeaf.bot1Part);
		// mySashLeaf.bot2 = createShape.myBot2Clone(mySashLeaf.bot2,
		// mySashLeaf.bot2Part);
		// mySashLeaf.bot3 = createShape.myBot3Clone(mySashLeaf.bot3,
		// mySashLeaf.bot3Part);
		// mySashLeaf.left = createShape.myLeftClone(mySashLeaf.left,
		// mySashLeaf.leftPart);
		// mySashLeaf.right = createShape.myRightClone(mySashLeaf.right,
		// mySashLeaf.rightPart);

		mySashLeaf.top1 = (Top1Object) mySashLeaf.top1
				.cloneProfile(mySashLeaf.top1Part);
		mySashLeaf.top2 = (Top2Object) mySashLeaf.top2
				.cloneProfile(mySashLeaf.top2Part);
		mySashLeaf.top3 = (Top3Object) mySashLeaf.top3
				.cloneProfile(mySashLeaf.top3Part);

		mySashLeaf.bot1 = (Bot1Object) mySashLeaf.bot1
				.cloneProfile(mySashLeaf.bot1Part);
		mySashLeaf.bot2 = (Bot2Object) mySashLeaf.bot2
				.cloneProfile(mySashLeaf.bot2Part);
		mySashLeaf.bot3 = (Bot3Object) mySashLeaf.bot3
				.cloneProfile(mySashLeaf.bot3Part);

		mySashLeaf.left = (LeftObject) mySashLeaf.left
				.cloneProfile(mySashLeaf.leftPart);
		mySashLeaf.right = (RightObject) mySashLeaf.right
				.cloneProfile(mySashLeaf.rightPart);

		mySashLeaf.symbol = this.doSashSymbol(mySashLeaf);

		mySashLeaf.bom.clear();
		mySashLeaf.clearBomForShape();
		mySashLeaf.executePartRules(true, true, "createSash.Louvre.3144");

		mySashLeaf.doMainOpening();

		mySashLeaf.bOpeningObject.unGlazed = true;

		if (!myFrame2.isUndo) {
			mySashLeaf.bOpeningObject = mySashLeaf.bOpeningObject
					.modifyVMCEqualize(mySashLeaf.bOpeningObject);

			mySashLeaf.bOpeningObject = mySashLeaf.bOpeningObject
					.modifyHMCEqualize(mySashLeaf.bOpeningObject);
		}

		mySashLeaf.doOpenings();

		Object[] oPenings = mySashLeaf.openings.toArray();

		mySashLeaf.openings.clear();

		for (Object O : oPenings) {
			((OpeningObject) O).myParent = mySashLeaf;
			mySashLeaf.openings.add(O);
		}

		mySashLeaf.bOpeningObject = mySashLeaf
				.doMullions(mySashLeaf.bOpeningObject);

		Object[] openingObjects = mySashLeaf.openings.toArray();
		mySashLeaf.openings.clear();
		mySashLeaf.bOpeningObject.glazedOut = gOut;
		mySashLeaf.glazedOut = gOut;
		for (Object O : openingObjects) {
			((OpeningObject) O).glazedOut = gOut;
			((OpeningObject) O).openingClass = sashClassType;
			((OpeningObject) O).userDefinedOpeningID = sashUDID;
			((OpeningObject) O).myParent = mySashLeaf;
			((OpeningObject) O).contentMid = 1;
			mySashLeaf.openings.add(O);
		}

		mySashLeaf.startCol = count + 1;
		mySashLeaf.startRow = 1;
		mySashLeaf.endCol = count + 1;
		mySashLeaf.endRow = 1;

		if (whichPos == 1) {
			myParentO.contentIn = 2;
			myParentO.sashObjectIn = sashtype;
			myParentO.sashObjectIn.opens = sashtype.opens;
			myParentO.sashObjectIn.sashClassType = sashClassType;
			myParentO.sashObjectIn.frames.add(mySashLeaf);
		} else if (whichPos == 2) {
			myParentO.contentMid = 2;
			myParentO.sashObjectMid = sashtype;
			myParentO.sashObjectMid.opens = sashtype.opens;
			myParentO.sashObjectMid.sashClassType = sashClassType;
			myParentO.sashObjectMid.frames.add(mySashLeaf);
		} else if (whichPos == 3) {
			myParentO.contentOut = 2;
			myParentO.sashObjectOut = sashtype;
			myParentO.sashObjectOut.opens = sashtype.opens;
			myParentO.sashObjectOut.sashClassType = sashClassType;
			myParentO.sashObjectOut.frames.add(mySashLeaf);
		}

		createShape = null;
		mySashLeaf.shapeChanged = false;
		return mySashLeaf;
	}

	@SuppressWarnings("unchecked")
	public void do1SashOutSwing(OpeningObject myOpening, int type, int track,
			boolean gOut, boolean sameParts, int panetype, int count,
			SashTypeObject sashtype, Collection existingSashes, boolean equalize)
			throws Exception {

		SashLeaf mySashLeaf = new SashLeaf();

		myParentO.unGlazed = true;

		myOpening.unGlazed = true;
		myOpening.contentMid = 2;

		mySashLeaf.glazedOut = sashtype.glazedOut;

		mySashLeaf.paneType = panetype;

		mySashLeaf.openingClass = sashClassType;

		mySashLeaf.userDefinedOpeningID = sashUDID;

		mySashLeaf.myParent = sashtype;

		mySashLeaf.trackNo = track;

		mySashLeaf.a_sequenceID = count + 1;
		mySashLeaf.leafNo = count + 1;

		mySashLeaf = this.initSashLeaf(myOpening.topIn, myOpening.botIn,
				myOpening.leftIn, myOpening.rightIn, type, myOpening, sashtype,
				mySashLeaf);

		/*
		 * Reset Values Again in case of change due to cloning of Opening
		 */
		myParentO.unGlazed = true;

		myOpening.unGlazed = true;
		myOpening.contentMid = 2;

		mySashLeaf.glazedOut = sashtype.glazedOut;

		mySashLeaf.paneType = panetype;

		mySashLeaf.openingClass = sashClassType;

		mySashLeaf.userDefinedOpeningID = sashUDID;

		mySashLeaf.myParent = sashtype;

		mySashLeaf.trackNo = track;

		mySashLeaf.a_sequenceID = count + 1;
		mySashLeaf.leafNo = count + 1;

		mySashLeaf.options.clear();

		mySashLeaf.executeOptionRules("createSash.do1SashSwingOut.2699");

		mySashLeaf.executeClearanceRules();

		CreateShapeMethods createShape = new CreateShapeMethods(myOpening, 2,
				myFrame2);

		if (!sameParts) {
			openingChanged = true;
			mySashLeaf.isNewFrame = true;
			mySashLeaf.newPart = true;
		}

		this.initSashParts(mySashLeaf, myOpening);
		if (existingSashes != null && existingSashes.size() > 0) {

			for (Object S : existingSashes.toArray()) {
				if (((SashLeaf) S).a_sequenceID == mySashLeaf.a_sequenceID) {

					mySashLeaf.bOpeningObject = ((SashLeaf) S).bOpeningObject
							.cloneBkgrdOpening(((SashLeaf) S).bOpeningObject);

					mySashLeaf.openings.addAll(((SashLeaf) S).openings);

					mySashLeaf.frames.addAll(((SashLeaf) S).frames);

					if (myOpening.shapeID == ((SashLeaf) S).shapeID
							&& !((SashLeaf) S).myParent.myParent.shapeChanged
							&& myOpening.noSides == ((SashLeaf) S).noSides
							&& myOpening.noSidesTop == ((SashLeaf) S).noSidesTop
							&& myOpening.noSidesBot == ((SashLeaf) S).noSidesBot
							&& myOpening.noSidesLeft == ((SashLeaf) S).noSidesLeft
							&& myOpening.noSidesRight == ((SashLeaf) S).noSidesRight) {

						this.initSashParts(mySashLeaf, myOpening);
						mySashLeaf.glazedOut = ((SashLeaf) S).glazedOut;

						mySashLeaf = this.copyParts(mySashLeaf, ((SashLeaf) S));

						mySashLeaf.xCols = ((SashLeaf) S).xCols;
						mySashLeaf.yRows = ((SashLeaf) S).yRows;

						mySashLeaf.shapeChanged = ((SashLeaf) S).shapeChanged;
						if (((SashLeaf) S).shapeID != 1) {
							mySashLeaf.shapeChanged = true;
						}

						mySashLeaf.top1Part = (Profiles) mySashLeaf.top1Part
								.cloneProfile(((SashLeaf) S).top1Part);
						mySashLeaf.top2Part = (Profiles) mySashLeaf.top2Part
								.cloneProfile(((SashLeaf) S).top2Part);
						mySashLeaf.top3Part = (Profiles) mySashLeaf.top3Part
								.cloneProfile(((SashLeaf) S).top3Part);
						mySashLeaf.bot1Part = (Profiles) mySashLeaf.bot1Part
								.cloneProfile(((SashLeaf) S).bot1Part);
						mySashLeaf.bot2Part = (Profiles) mySashLeaf.bot2Part
								.cloneProfile(((SashLeaf) S).bot2Part);
						mySashLeaf.bot3Part = (Profiles) mySashLeaf.bot3Part
								.cloneProfile(((SashLeaf) S).bot3Part);
						mySashLeaf.leftPart = (Profiles) mySashLeaf.leftPart
								.cloneProfile(((SashLeaf) S).leftPart);
						mySashLeaf.rightPart = (Profiles) mySashLeaf.rightPart
								.cloneProfile(((SashLeaf) S).rightPart);

						mySashLeaf.newPart = false;

					}

				}

			}

		}

		if (!myOpening.top2Part.posInUse) {

			mySashLeaf.top2Part = (Profiles) mySashLeaf.top2Part
					.cloneProfile(mySashLeaf.top1Part);
			mySashLeaf.top2Part.posInUse = false;
			mySashLeaf.top2Part.lengthM = 0;
			mySashLeaf.top2Part.lengthI = 0;
			mySashLeaf.top2 = (Top2Object) mySashLeaf.top2
					.cloneProfile(mySashLeaf.top2Part);

			mySashLeaf.top2.posInUse = false;

		}

		Object[] returns = this.setPartDims(mySashLeaf, createShape);
		mySashLeaf = (SashLeaf) returns[0];
		createShape = (CreateShapeMethods) returns[1];

		createShape.getClearance(mySashLeaf);

		mySashLeaf = (SashLeaf) createShape.doShapeBkgrd(mySashLeaf);

		mySashLeaf = (SashLeaf) createShape.makeSides(mySashLeaf);

		mySashLeaf = (SashLeaf) createShape.makeSidesStraight(mySashLeaf);

		mySashLeaf = (SashLeaf) createShape.doParts(mySashLeaf, true);

		mySashLeaf = (SashLeaf) createShape.setBaseInfo(mySashLeaf, 1, true);

		mySashLeaf.top1Part.myParent = mySashLeaf;
		mySashLeaf.top2Part.myParent = mySashLeaf;
		mySashLeaf.top3Part.myParent = mySashLeaf;
		mySashLeaf.bot1Part.myParent = mySashLeaf;
		mySashLeaf.bot2Part.myParent = mySashLeaf;
		mySashLeaf.bot3Part.myParent = mySashLeaf;
		mySashLeaf.leftPart.myParent = mySashLeaf;
		mySashLeaf.rightPart.myParent = mySashLeaf;

		mySashLeaf.partObjects.clear();
		mySashLeaf.partObjects = createShape
				.setPartObjectsAndCollection(mySashLeaf);

		mySashLeaf.partObjects = createShape.doGPParts(mySashLeaf.partObjects,
				mySashLeaf, mySashLeaf.glazedOut);

		mySashLeaf.top1 = (Top1Object) mySashLeaf.top1
				.cloneProfile(mySashLeaf.top1Part);
		mySashLeaf.top2 = (Top2Object) mySashLeaf.top2
				.cloneProfile(mySashLeaf.top2Part);
		mySashLeaf.top3 = (Top3Object) mySashLeaf.top3
				.cloneProfile(mySashLeaf.top3Part);

		mySashLeaf.bot1 = (Bot1Object) mySashLeaf.bot1
				.cloneProfile(mySashLeaf.bot1Part);
		mySashLeaf.bot2 = (Bot2Object) mySashLeaf.bot2
				.cloneProfile(mySashLeaf.bot2Part);
		mySashLeaf.bot3 = (Bot3Object) mySashLeaf.bot3
				.cloneProfile(mySashLeaf.bot3Part);

		mySashLeaf.left = (LeftObject) mySashLeaf.left
				.cloneProfile(mySashLeaf.leftPart);
		mySashLeaf.right = (RightObject) mySashLeaf.right
				.cloneProfile(mySashLeaf.rightPart);

		mySashLeaf.symbol = this.doSashSymbol(mySashLeaf);

		mySashLeaf.bom.clear();
		mySashLeaf.clearBomForShape();
		mySashLeaf.executePartRules(true, true,
				"createSash.do1SashSwingOut.2905");

		mySashLeaf.doMainOpening();

		mySashLeaf.bOpeningObject.unGlazed = true;

		if (!myFrame2.isUndo) {
			mySashLeaf.bOpeningObject = mySashLeaf.bOpeningObject
					.modifyVMCEqualize(mySashLeaf.bOpeningObject);

			mySashLeaf.bOpeningObject = mySashLeaf.bOpeningObject
					.modifyHMCEqualize(mySashLeaf.bOpeningObject);
		}

		if (mySashLeaf.bOpeningObject.mullions.size() > 0
				|| mySashLeaf.bOpeningObject.mullionsH.size() > 0) {
			mySashLeaf.doOpenings();
		}

		Object[] oPenings = mySashLeaf.openings.toArray();

		mySashLeaf.openings.clear();

		for (Object O : oPenings) {
			((OpeningObject) O).myParent = mySashLeaf;
			mySashLeaf.openings.add(O);
		}

		mySashLeaf.bOpeningObject = mySashLeaf
				.doMullions(mySashLeaf.bOpeningObject);

		Object[] openingObjects = mySashLeaf.openings.toArray();
		mySashLeaf.openings.clear();

		for (Object O : openingObjects) {

			((OpeningObject) O).openingClass = sashClassType;
			((OpeningObject) O).userDefinedOpeningID = sashUDID;
			((OpeningObject) O).myParent = mySashLeaf;
			((OpeningObject) O).contentMid = 1;
			mySashLeaf.openings.add(O);
		}

		mySashLeaf.startCol = count + 1;
		mySashLeaf.startRow = 1;
		mySashLeaf.endCol = count + 1;
		mySashLeaf.endRow = 1;

		if (whichPos == 1) {
			myParentO.contentIn = 2;
			myParentO.sashObjectIn = sashtype;
			myParentO.sashObjectIn.opens = sashtype.opens;
			myParentO.sashObjectIn.sashClassType = sashClassType;
			myParentO.sashObjectIn.frames.add(mySashLeaf);
		} else if (whichPos == 2) {
			myParentO.contentMid = 2;
			myParentO.sashObjectMid = sashtype;
			myParentO.sashObjectMid.opens = sashtype.opens;
			myParentO.sashObjectMid.sashClassType = sashClassType;
			myParentO.sashObjectMid.frames.add(mySashLeaf);
		} else if (whichPos == 3) {
			myParentO.contentOut = 2;
			myParentO.sashObjectOut = sashtype;
			myParentO.sashObjectOut.opens = sashtype.opens;
			myParentO.sashObjectOut.sashClassType = sashClassType;
			myParentO.sashObjectOut.frames.add(mySashLeaf);
		}
		// mySashLeaf.options.clear();
		// mySashLeaf.executeOptionRules("createSash.do1SashSwingOut.2902");
		// mySashLeaf.bom.clear();
		// mySashLeaf.clearBomForShape();
		// mySashLeaf.executePartRules(true, true,
		// "createSash.do1SashSwingOut.2905");
		mySashLeaf.shapeChanged = false;
		createShape = null;

	}

	public void do1SashSlider(OpeningObject myOpening, int type, int track,
			boolean gOut, boolean sameParts, int panetype, int count,
			SashTypeObject sashtype, boolean equalize) throws Exception {

		myOpening.unGlazed = true;
		SashLeaf mySashLeaf = new SashLeaf();

		mySashLeaf = this.initSashLeaf(myOpening.topIn, myOpening.botIn,
				myOpening.leftIn, myOpening.rightIn, type, myOpening, sashtype,
				mySashLeaf);

		mySashLeaf.myParent = sashtype;

		if (sashtype.isglazed) {
			mySashLeaf.unGlazed = false;
		} else {
			mySashLeaf.unGlazed = true;
		}

		mySashLeaf.trackNo = track;
		mySashLeaf.leafNo = count + 1;
		mySashLeaf.paneType = panetype;

		mySashLeaf.glazedOut = sashtype.glazedOut;
		mySashLeaf.myFrame2 = myOpening.myParent.myFrame2;

		mySashLeaf.openingClass = sashClassType;
		mySashLeaf.userDefinedOpeningID = sashUDID;
		mySashLeaf.options.clear();

		mySashLeaf.executeOptionRules("createSash.di1SashSlider.2933");

		mySashLeaf.executeClearanceRules();

		if (!sameParts) {
			openingChanged = true;
			mySashLeaf.isNewFrame = true;
			mySashLeaf.newPart = true;
		}

		CreateShapeMethods createShape = new CreateShapeMethods(myOpening, 2,
				myFrame2);

		this.initSashParts(mySashLeaf, myOpening);

		if (myExistingSashes != null && myExistingSashes.size() > 0) {
			for (Object S : myExistingSashes.toArray()) {
				if (((SashLeaf) S).a_sequenceID == mySashLeaf.a_sequenceID) {

					mySashLeaf.bOpeningObject = ((SashLeaf) S).bOpeningObject
							.cloneBkgrdOpening(((SashLeaf) S).bOpeningObject);
					mySashLeaf.openings.addAll(((SashLeaf) S).openings);
					mySashLeaf.frames.addAll(((SashLeaf) S).frames);

					if (myOpening.shapeID == ((SashLeaf) S).shapeID
							&& sameParts) {

						mySashLeaf.partObjects
								.addAll(((SashLeaf) S).partObjects);
						this.initSashParts(mySashLeaf, myOpening);
						mySashLeaf = this.copyParts(mySashLeaf, ((SashLeaf) S));

						mySashLeaf.shapeChanged = ((SashLeaf) S).shapeChanged;
						if (((SashLeaf) S).shapeID != 1) {
							mySashLeaf.shapeChanged = true;
						}

						mySashLeaf.top1Part = (Profiles) mySashLeaf.top1Part
								.cloneProfile(((SashLeaf) S).top1Part);
						mySashLeaf.top2Part = (Profiles) mySashLeaf.top2Part
								.cloneProfile(((SashLeaf) S).top2Part);
						mySashLeaf.top3Part = (Profiles) mySashLeaf.top3Part
								.cloneProfile(((SashLeaf) S).top3Part);
						mySashLeaf.bot1Part = (Profiles) mySashLeaf.bot1Part
								.cloneProfile(((SashLeaf) S).bot1Part);
						mySashLeaf.bot2Part = (Profiles) mySashLeaf.bot2Part
								.cloneProfile(((SashLeaf) S).bot2Part);
						mySashLeaf.bot3Part = (Profiles) mySashLeaf.bot3Part
								.cloneProfile(((SashLeaf) S).bot3Part);
						mySashLeaf.leftPart = (Profiles) mySashLeaf.leftPart
								.cloneProfile(((SashLeaf) S).leftPart);
						mySashLeaf.rightPart = (Profiles) mySashLeaf.rightPart
								.cloneProfile(((SashLeaf) S).rightPart);

						mySashLeaf.newPart = false;

					} else {
						this.initSashParts(mySashLeaf, myOpening);
						break;
					}
					break;
				}
			}
		} else {
			this.initSashParts(mySashLeaf, myOpening);
		}

		if (!myOpening.top2Part.posInUse) {
			// mySashLeaf.top2Part =
			// mySashLeaf.myTop1Clone(mySashLeaf.top2Part,
			// mySashLeaf.top1Part);
			// mySashLeaf.top2Part.posInUse = false;
			//
			// mySashLeaf.top2 = createShape.myTop2Clone(mySashLeaf.top2,
			// mySashLeaf.top2Part);
			// mySashLeaf.top2.posInUse = false;

			mySashLeaf.top2Part = (Profiles) mySashLeaf.top2Part
					.cloneProfile(mySashLeaf.top1Part);
			mySashLeaf.top2Part.posInUse = false;

			mySashLeaf.top2 = (Top2Object) mySashLeaf.top2
					.cloneProfile(mySashLeaf.top2Part);

			mySashLeaf.top2.posInUse = false;

		}

		Object[] returns = this.setPartDims(mySashLeaf, createShape);

		mySashLeaf.glazedOut = gOut;

		mySashLeaf = (SashLeaf) returns[0];
		createShape = (CreateShapeMethods) returns[1];

		createShape.getClearance(mySashLeaf);

		mySashLeaf = (SashLeaf) createShape.doShapeBkgrd(mySashLeaf);

		mySashLeaf = (SashLeaf) createShape.makeSides(mySashLeaf);

		mySashLeaf = (SashLeaf) createShape.makeSidesStraight(mySashLeaf);

		mySashLeaf = (SashLeaf) createShape.doParts(mySashLeaf, true);

		mySashLeaf = (SashLeaf) createShape.setBaseInfo(mySashLeaf, 1, true);

		mySashLeaf.top1Part.myParent = mySashLeaf;
		mySashLeaf.top2Part.myParent = mySashLeaf;
		mySashLeaf.top3Part.myParent = mySashLeaf;
		mySashLeaf.bot1Part.myParent = mySashLeaf;
		mySashLeaf.bot2Part.myParent = mySashLeaf;
		mySashLeaf.bot3Part.myParent = mySashLeaf;
		mySashLeaf.leftPart.myParent = mySashLeaf;
		mySashLeaf.rightPart.myParent = mySashLeaf;

		mySashLeaf.partObjects.clear();
		mySashLeaf.partObjects = createShape
				.setPartObjectsAndCollection(mySashLeaf);

		mySashLeaf.partObjects = createShape.doGPParts(mySashLeaf.partObjects,
				mySashLeaf, mySashLeaf.glazedOut);

		mySashLeaf.top1 = (Top1Object) mySashLeaf.top1
				.cloneProfile(mySashLeaf.top1Part);
		mySashLeaf.top2 = (Top2Object) mySashLeaf.top2
				.cloneProfile(mySashLeaf.top2Part);
		mySashLeaf.top3 = (Top3Object) mySashLeaf.top3
				.cloneProfile(mySashLeaf.top3Part);

		mySashLeaf.bot1 = (Bot1Object) mySashLeaf.bot1
				.cloneProfile(mySashLeaf.bot1Part);
		mySashLeaf.bot2 = (Bot2Object) mySashLeaf.bot2
				.cloneProfile(mySashLeaf.bot2Part);
		mySashLeaf.bot3 = (Bot3Object) mySashLeaf.bot3
				.cloneProfile(mySashLeaf.bot3Part);

		mySashLeaf.left = (LeftObject) mySashLeaf.left
				.cloneProfile(mySashLeaf.leftPart);
		mySashLeaf.right = (RightObject) mySashLeaf.right
				.cloneProfile(mySashLeaf.rightPart);

		mySashLeaf.symbol = this.doSashSymbol(mySashLeaf);

		mySashLeaf.bom.clear();
		mySashLeaf.clearBomForShape();
		mySashLeaf
				.executePartRules(true, true, "createSash.d01SashSlider.3144");

		mySashLeaf.doMainOpening();

		mySashLeaf.bOpeningObject.unGlazed = true;

		if (!myFrame2.isUndo) {
			mySashLeaf.bOpeningObject = mySashLeaf.bOpeningObject
					.modifyVMCEqualize(mySashLeaf.bOpeningObject);

			mySashLeaf.bOpeningObject = mySashLeaf.bOpeningObject
					.modifyHMCEqualize(mySashLeaf.bOpeningObject);
		}

		if (mySashLeaf.bOpeningObject.mullions.size() > 0
				|| mySashLeaf.bOpeningObject.mullionsH.size() > 0) {
			mySashLeaf.doOpenings();
		}

		Object[] oPenings = mySashLeaf.openings.toArray();

		mySashLeaf.openings.clear();

		for (Object O : oPenings) {
			((OpeningObject) O).myParent = mySashLeaf;
			mySashLeaf.openings.add(O);
		}

		mySashLeaf.bOpeningObject = mySashLeaf
				.doMullions(mySashLeaf.bOpeningObject);

		Object[] openingObjects = mySashLeaf.openings.toArray();
		mySashLeaf.openings.clear();
		mySashLeaf.bOpeningObject.glazedOut = gOut;
		mySashLeaf.glazedOut = gOut;

		for (Object O : openingObjects) {
			((OpeningObject) O).glazedOut = gOut;
			((OpeningObject) O).openingClass = sashClassType;
			((OpeningObject) O).userDefinedOpeningID = sashUDID;
			((OpeningObject) O).myParent = mySashLeaf;
			mySashLeaf.openings.add(O);
		}

		if (panetype != 31 && panetype != 32) {
			mySashLeaf.startCol = count + 1;
			mySashLeaf.startRow = 1;
			mySashLeaf.endCol = count + 1;
			mySashLeaf.endRow = 1;
		} else {
			mySashLeaf.startCol = 1;
			mySashLeaf.startRow = count + 1;
			mySashLeaf.endCol = 1;
			mySashLeaf.endRow = count + 1;
		}

		if (whichPos == 1) {
			myParentO.contentIn = 2;
			myParentO.sashObjectIn = sashtype;
			myParentO.sashObjectIn.frames.add(mySashLeaf);
		} else if (whichPos == 2) {
			myParentO.contentMid = 2;
			myParentO.sashObjectMid = sashtype;
			myParentO.sashObjectMid.frames.add(mySashLeaf);
		} else if (whichPos == 3) {
			myParentO.contentOut = 2;
			myParentO.sashObjectOut = sashtype;
			myParentO.sashObjectOut.frames.add(mySashLeaf);
		}
		// mySashLeaf.options.clear();
		// mySashLeaf.executeOptionRules("createSash.d01SashSlider.3144");
		// mySashLeaf.bom.clear();
		// mySashLeaf.clearBomForShape();
		// mySashLeaf.executePartRules(true, true,
		// "createSash.d01SashSlider.3144");
		mySashLeaf.shapeChanged = false;

		// i
		if (mySashLeaf.openingClass == 61 || mySashLeaf.openingClass == 62
				|| mySashLeaf.openingClass == 63) {

			mySashLeaf.gp = createShape.doGeneralPathLouvre(mySashLeaf);

		}

		createShape = null;
	}

	public SashLeaf initSashLeaf(boolean topIn, boolean botIn, boolean leftIn,
			boolean rightIn, int type, OpeningObject myOpening,
			SashTypeObject sashtype, SashLeaf mySashLeaf) {

		mySashLeaf = (SashLeaf) this.cloneShapeFromParentOpening(mySashLeaf,
				myOpening);

		mySashLeaf.myParentO = myOpening;
		mySashLeaf.myParent = sashtype;
		mySashLeaf.myFacet = sashtype.myFacet;

		mySashLeaf.topIn = topIn;
		mySashLeaf.botIn = botIn;
		mySashLeaf.leftIn = leftIn;
		mySashLeaf.rightIn = rightIn;

		mySashLeaf.startCol = 1;
		mySashLeaf.startRow = 1;
		mySashLeaf.endCol = 1;
		mySashLeaf.endRow = 1;

		return mySashLeaf;
	}

	public SashLeaf doPartPosOLD(SashLeaf mySashLeaf) {

		mySashLeaf.top1Part.posInUse = true;
		mySashLeaf.bot1Part.posInUse = true;
		mySashLeaf.leftPart.posInUse = true;
		mySashLeaf.rightPart.posInUse = true;

		mySashLeaf.top2Part.posInUse = true;
		mySashLeaf.top3Part.posInUse = true;
		mySashLeaf.bot2Part.posInUse = true;
		mySashLeaf.bot3Part.posInUse = true;
		if (!myParentO.top1.posInUse) {
			mySashLeaf.top1Part = new Profiles();
			mySashLeaf.top1Part.posInUse = false;
		}
		if (!myParentO.top2.posInUse) {
			mySashLeaf.top2Part = new Profiles();
			mySashLeaf.top2Part.posInUse = false;
		}
		if (!myParentO.top3.posInUse) {
			mySashLeaf.top3Part = new Profiles();
			mySashLeaf.top3Part.posInUse = false;
		}
		if (!myParentO.bot1.posInUse) {
			mySashLeaf.bot1Part = new Profiles();
			mySashLeaf.bot1Part.posInUse = false;
		}
		if (!myParentO.bot2.posInUse) {
			mySashLeaf.bot2Part = new Profiles();
			mySashLeaf.bot2Part.posInUse = false;
		}
		if (!myParentO.bot3.posInUse) {
			mySashLeaf.bot3Part = new Profiles();
			mySashLeaf.bot3Part.posInUse = false;
		}
		if (!myParentO.left.posInUse) {
			mySashLeaf.leftPart = new Profiles();
			mySashLeaf.leftPart.posInUse = false;
		}
		if (!myParentO.right.posInUse) {
			mySashLeaf.rightPart = new Profiles();
			mySashLeaf.rightPart.posInUse = false;
		}

		return mySashLeaf;
	}

	public SashLeaf doPartPos(SashLeaf mySashLeaf, OpeningObject myOpening) {

		mySashLeaf.top1Part.posInUse = true;
		mySashLeaf.bot1Part.posInUse = true;
		mySashLeaf.leftPart.posInUse = true;
		mySashLeaf.rightPart.posInUse = true;

		mySashLeaf.top2Part.posInUse = true;
		mySashLeaf.top3Part.posInUse = true;
		mySashLeaf.bot2Part.posInUse = true;
		mySashLeaf.bot3Part.posInUse = true;
		if (!myOpening.top1.posInUse) {
			mySashLeaf.top1Part = new Profiles();
			mySashLeaf.top1Part.posInUse = false;
		}
		if (!myOpening.top2.posInUse) {
			mySashLeaf.top2Part = new Profiles();
			mySashLeaf.top2Part.posInUse = false;
		}
		if (!myOpening.top3.posInUse) {
			mySashLeaf.top3Part = new Profiles();
			mySashLeaf.top3Part.posInUse = false;
		}
		if (!myOpening.bot1.posInUse) {
			mySashLeaf.bot1Part = new Profiles();
			mySashLeaf.bot1Part.posInUse = false;
		}
		if (!myOpening.bot2.posInUse) {
			mySashLeaf.bot2Part = new Profiles();
			mySashLeaf.bot2Part.posInUse = false;
		}
		if (!myOpening.bot3.posInUse) {
			mySashLeaf.bot3Part = new Profiles();
			mySashLeaf.bot3Part.posInUse = false;
		}
		if (!myOpening.left.posInUse) {
			mySashLeaf.leftPart = new Profiles();
			mySashLeaf.leftPart.posInUse = false;
		}
		if (!myOpening.right.posInUse) {
			mySashLeaf.rightPart = new Profiles();
			mySashLeaf.rightPart.posInUse = false;
		}

		return mySashLeaf;
	}

	public SashTypeObject doPartPosSashType(SashTypeObject mySashLeaf,
			OpeningObject myOpening) {

		mySashLeaf.top1Part.posInUse = true;
		mySashLeaf.bot1Part.posInUse = true;
		mySashLeaf.leftPart.posInUse = true;
		mySashLeaf.rightPart.posInUse = true;

		mySashLeaf.top2Part.posInUse = true;
		mySashLeaf.top3Part.posInUse = true;
		mySashLeaf.bot2Part.posInUse = true;
		mySashLeaf.bot3Part.posInUse = true;
		if (!myOpening.top1.posInUse) {
			mySashLeaf.top1Part = new Profiles();
			mySashLeaf.top1Part.posInUse = false;
		}
		if (!myOpening.top2.posInUse) {
			mySashLeaf.top2Part = new Profiles();
			mySashLeaf.top2Part.posInUse = false;
		}
		if (!myOpening.top3.posInUse) {
			mySashLeaf.top3Part = new Profiles();
			mySashLeaf.top3Part.posInUse = false;
		}
		if (!myOpening.bot1.posInUse) {
			mySashLeaf.bot1Part = new Profiles();
			mySashLeaf.bot1Part.posInUse = false;
		}
		if (!myOpening.bot2.posInUse) {
			mySashLeaf.bot2Part = new Profiles();
			mySashLeaf.bot2Part.posInUse = false;
		}
		if (!myOpening.bot3.posInUse) {
			mySashLeaf.bot3Part = new Profiles();
			mySashLeaf.bot3Part.posInUse = false;
		}
		if (!myOpening.left.posInUse) {
			mySashLeaf.leftPart = new Profiles();
			mySashLeaf.leftPart.posInUse = false;
		}
		if (!myOpening.right.posInUse) {
			mySashLeaf.rightPart = new Profiles();
			mySashLeaf.rightPart.posInUse = false;
		}

		return mySashLeaf;
	}

	/*
	 * Pane Types Symbols: 1= Fixed/Direct Glazed 2 = LH // 3 = RH // 4 = Awning
	 * // 5 = Fixed Sash // 6 = Hopper // 7 = LSlide // 8 = RSlide // 9 = Bi
	 * Slide // 10 = Fixed Slider Sash // 11 = slide Down // 12 = slide Up // 13
	 * = TTL // 14 = TTR // 15 = pivot V // 16 = pivot H // 17 = folding // 18 =
	 * JalousieG // 19 = JalousieS // 20 = JalousieL //
	 */
	public Collection doSashSymbol(SashLeaf mySashLeaf) {

		// Clear sash leaf symbol
		mySashLeaf.symbol.clear();

		double myStartYY = mySashLeaf.highestY;// mySashLeaf.bY4-

		switch (mySashLeaf.paneType) {
		case 1:
			break;
		case 2: // casement L
			this.doCasementLSymbolViewOut(mySashLeaf);
			break;
		case 3: // casement R
			this.doCasementRSymbolViewOut(mySashLeaf);
			break;
		case 4: // awning
			this.doAwningSymbolViewOut(mySashLeaf);
			break;
		case 5: // fS
			break;
		case 6: // hopper
			this.doHopperSymbolViewOut(mySashLeaf);
			break;
		case 7: // LS
			this.doLeftSlideSymbolViewOut(mySashLeaf);
			break;
		case 8: // RS
			this.doRightSlideSymbolViewOut(mySashLeaf);
			break;
		case 9: // Bi Slide
			this.doCenterSlideSymbol(mySashLeaf);
			break;
		case 10:// FS Sash
			break;
		case 11:// Down Arrow
			this.doTopSlideSymbolViewOut(mySashLeaf);
			break;
		case 12:// Up Arrow
			this.doBottomSlideSymbolViewOut(mySashLeaf);
			break;
		case 13:// TTL
			this.doCasementLSymbolViewOut(mySashLeaf);
			this.doHopperSymbolViewOut(mySashLeaf);
			break;
		case 14:// TTR
			this.doCasementRSymbolViewOut(mySashLeaf);
			this.doHopperSymbolViewOut(mySashLeaf);
			break;
		case 15:// pivot V
			this.doVPivot(mySashLeaf, myStartYY);
			break;
		case 16:// pivot H
			this.doHPivot(mySashLeaf, myStartYY);
			break;
		case 17:// folding
			break;
		case 18:// jGlass
			break;
		case 19:// jSash
			break;
		case 20:// louvres
			break;
		case 50:// Slave L
			this.doCasementLSymbolViewOut(mySashLeaf);
			break;
		case 51:// Slave R
			this.doCasementRSymbolViewOut(mySashLeaf);

			break;
		}

		return mySashLeaf.symbol;
	}

	public void doHopperSymbolViewOut(SashLeaf mySashLeaf) {

		double myStartYY = mySashLeaf.bY2;

		double midX = this.intersectX(mySashLeaf.bX4, mySashLeaf.bY4,
				mySashLeaf.bX3, mySashLeaf.bY3, mySashLeaf.bX4
						+ (mySashLeaf.bX3 - mySashLeaf.bX4) / 2, 0,
				mySashLeaf.bX4 + (mySashLeaf.bX3 - mySashLeaf.bX4) / 2, 500);
		double midY = this.intersectY(mySashLeaf.bX4, mySashLeaf.bY4,
				mySashLeaf.bX3, mySashLeaf.bY3, mySashLeaf.bX4
						+ (mySashLeaf.bX3 - mySashLeaf.bX4) / 2, 0,
				mySashLeaf.bX4 + (mySashLeaf.bX3 - mySashLeaf.bX4) / 2, 500);

		mySashLeaf.mySymbolLine = new Line2D.Double(midX, midY,
				mySashLeaf.startingX, mySashLeaf.startingY);

		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);

		if (myStartYY > mySashLeaf.highestY) {
			mySashLeaf.mySymbolLine = new Line2D.Double(midX, midY,
					mySashLeaf.bX2, myStartYY);
		} else {
			mySashLeaf.mySymbolLine = new Line2D.Double(midX, midY,
					mySashLeaf.bX2, mySashLeaf.highestY);
		}
		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);
	}

	public void doAwningSymbolViewOut(SashLeaf mySashLeaf) {

		double myStartYY = mySashLeaf.highestY;
		double midX;
		double midY;
		midX = this.intersectX(mySashLeaf.startingX, myStartYY, mySashLeaf.bX2,
				myStartYY, mySashLeaf.startingX
						+ (mySashLeaf.bX2 - mySashLeaf.startingX) / 2, 0,
				mySashLeaf.startingX + (mySashLeaf.bX2 - mySashLeaf.startingX)
						/ 2, 500);
		midY = this.intersectY(mySashLeaf.startingX, myStartYY, mySashLeaf.bX2,
				myStartYY, mySashLeaf.startingX
						+ (mySashLeaf.bX2 - mySashLeaf.startingX) / 2, 0,
				mySashLeaf.startingX + (mySashLeaf.bX2 - mySashLeaf.startingX)
						/ 2, 500);

		mySashLeaf.mySymbolLine = new Line2D.Double(midX, midY, mySashLeaf.bX4,
				mySashLeaf.bY4);
		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);
		mySashLeaf.mySymbolLine = new Line2D.Double(midX, midY, mySashLeaf.bX3,
				mySashLeaf.bY3);
		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);
	}

	public void doCasementRSymbolViewOut(SashLeaf mySashLeaf) {

		double myStartYY = mySashLeaf.startingY;

		double midX;
		double midY;
		midX = this.intersectX(mySashLeaf.bX2, mySashLeaf.bY2, mySashLeaf.bX3,
				mySashLeaf.bY3, 0,
				myStartYY + (mySashLeaf.bY3 - myStartYY) / 2, mySashLeaf.bX2,
				myStartYY + (mySashLeaf.bY3 - myStartYY) / 2);

		midY = this.intersectY(mySashLeaf.bX2, mySashLeaf.bY2, mySashLeaf.bX3,
				mySashLeaf.bY3, 0,
				myStartYY + (mySashLeaf.bY3 - myStartYY) / 2, mySashLeaf.bX2,
				myStartYY + (mySashLeaf.bY3 - myStartYY) / 2);

		mySashLeaf.mySymbolLine = new Line2D.Double(mySashLeaf.startingX,
				myStartYY, midX, midY);

		if (myParentO.noSides == 3 && myParentO.top1.partForm > 1
				&& myParentO.noSidesRight == 1) {
			Point2D p = this.getIntersectionLineArc(
					mySashLeaf.top1Part.bkgrdStartX,
					mySashLeaf.top1Part.bkgrdStartY, //
					mySashLeaf.top1Part.bkgrdWidth,
					mySashLeaf.top1Part.bkgrdHeight,
					mySashLeaf.top1Part.startAngle,
					mySashLeaf.top1Part.endAngle, mySashLeaf.top1Part.x1,
					mySashLeaf.top1Part.y1, mySashLeaf.startingX, myStartYY,
					midX, mySashLeaf.bY2 + (mySashLeaf.bY3 - mySashLeaf.bY2)
							/ 2, 1, false);

			mySashLeaf.mySymbolLine = new Line2D.Double(p.getX(), p.getY(),
					midX, midY);
		}
		if (myParentO.noSides == 4 && myParentO.top1.partForm > 1
				&& myParentO.noSidesLeft == 1 && myParentO.noSidesRight == 1) {

			myStartYY = mySashLeaf.bY3 - mySashLeaf.heightPix / 2;
			Point2D p = this.getIntersectionLineArc(
					mySashLeaf.top1Part.bkgrdStartX,
					mySashLeaf.top1Part.bkgrdStartY, //
					mySashLeaf.top1Part.bkgrdWidth,
					mySashLeaf.top1Part.bkgrdHeight,
					mySashLeaf.top1Part.startAngle,
					mySashLeaf.top1Part.endAngle, mySashLeaf.top1Part.x1,
					mySashLeaf.top1Part.y1, mySashLeaf.startingX,
					mySashLeaf.bY4 - mySashLeaf.heightPix, midX, myStartYY, 1,
					false);

			if (p.getY() > mySashLeaf.startingY) {
				p.setLocation(mySashLeaf.startingX, mySashLeaf.startingY);
			}

			mySashLeaf.mySymbolLine = new Line2D.Double(p.getX(), p.getY(),
					midX, myStartYY);
		}

		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);
		mySashLeaf.mySymbolLine = new Line2D.Double(midX, midY, mySashLeaf.bX4,
				mySashLeaf.bY4);
		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);
	}

	/**
	 * Creating sash leaf symbol view out
	 * 
	 * @param mySashLeaf
	 *            , SashLeaf
	 */
	public void doCasementLSymbolViewOut(SashLeaf mySashLeaf) {

		double myStartYY = mySashLeaf.bY2;
		if (mySashLeaf.top2Part.posInUse) {
			myStartYY = mySashLeaf.top2Part.endY;
		}
		double midX = this.intersectX(mySashLeaf.startingX, myStartYY
				+ (mySashLeaf.bY4 - myStartYY) / 2, 0, myStartYY
				+ (mySashLeaf.bY4 - myStartYY) / 2, mySashLeaf.startingX,
				myStartYY, mySashLeaf.bX4, mySashLeaf.bY4);
		double midY = this.intersectY(mySashLeaf.startingX, myStartYY
				+ (mySashLeaf.bY4 - myStartYY) / 2, 0, myStartYY
				+ (mySashLeaf.bY4 - myStartYY) / 2, mySashLeaf.startingX,
				myStartYY, mySashLeaf.bX4, mySashLeaf.bY4);

		mySashLeaf.mySymbolLine = new Line2D.Double(mySashLeaf.bX2,
				mySashLeaf.bY2, midX, midY);

		if (myParentO.noSides == 3 && myParentO.top1.partForm > 1
				&& myParentO.noSidesLeft == 1) {
			Point2D p = this.getIntersectionLineArc(
					mySashLeaf.top1Part.bkgrdStartX,
					mySashLeaf.top1Part.bkgrdStartY, //
					mySashLeaf.top1Part.bkgrdWidth,
					mySashLeaf.top1Part.bkgrdHeight,
					mySashLeaf.top1Part.startAngle,
					mySashLeaf.top1Part.endAngle, mySashLeaf.top1Part.x1,
					mySashLeaf.top1Part.y1, mySashLeaf.bX2, myStartYY, midX,
					myStartYY + (mySashLeaf.bY4 - myStartYY) / 2, 1, false);

			mySashLeaf.mySymbolLine = new Line2D.Double(p.getX(), p.getY(),
					midX, myStartYY + (mySashLeaf.bY4 - myStartYY) / 2);
		}

		if (myParentO.noSides == 4 && myParentO.top1.partForm > 1
				&& myParentO.noSidesLeft == 1 && myParentO.noSidesRight == 1) {

			midX = this.intersectX(mySashLeaf.startingX, myStartYY, 0,
					myStartYY + (mySashLeaf.bY4 - myStartYY) / 2,
					mySashLeaf.startingX, myStartYY, mySashLeaf.bX4,
					mySashLeaf.bY4);

			myStartYY = mySashLeaf.bY4 - mySashLeaf.heightPix / 2;
			Point2D p = this.getIntersectionLineArc(
					mySashLeaf.top1Part.bkgrdStartX,
					mySashLeaf.top1Part.bkgrdStartY,
					mySashLeaf.top1Part.bkgrdWidth,
					mySashLeaf.top1Part.bkgrdHeight,
					mySashLeaf.top1Part.startAngle,
					mySashLeaf.top1Part.endAngle, mySashLeaf.top1Part.x1,
					mySashLeaf.top1Part.y1, mySashLeaf.bX2, mySashLeaf.bY4
							- mySashLeaf.heightPix, midX, myStartYY, 1, false);

			if (p.getY() > mySashLeaf.bY2) {
				p.setLocation(mySashLeaf.bX2, mySashLeaf.bY2);
			}

			mySashLeaf.mySymbolLine = new Line2D.Double(p.getX(), p.getY(),
					midX, myStartYY);
		}

		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);
		mySashLeaf.mySymbolLine = new Line2D.Double(midX, midY, mySashLeaf.bX3,
				mySashLeaf.bY3);
		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);
	}

	public void doHPivot(SashLeaf mySashLeaf, double myStartYY) {

		double midX = 0;
		double midY = 0;

		midX = mySashLeaf.startingX + (mySashLeaf.bX2 - mySashLeaf.startingX)
				/ 2;
		midY = mySashLeaf.startingY + (mySashLeaf.bY4 - mySashLeaf.startingY)
				/ 2;

		mySashLeaf.mySymbolLine = new Line2D.Double(mySashLeaf.startingX, midY,
				midX, mySashLeaf.startingY);

		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);

		mySashLeaf.mySymbolLine = new Line2D.Double(midX, mySashLeaf.startingY,
				mySashLeaf.bX2, midY);

		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);

		mySashLeaf.mySymbolLine = new Line2D.Double(midX, mySashLeaf.bY4,
				mySashLeaf.bX2, midY);

		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);

		mySashLeaf.mySymbolLine = new Line2D.Double(midX, mySashLeaf.bY4,
				mySashLeaf.startingX, midY);

		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);

		mySashLeaf.mySymbolLine = new Line2D.Double(mySashLeaf.startingX, midY,
				mySashLeaf.startingX + mySashLeaf.widthPix / 12, midY);

		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);

		mySashLeaf.mySymbolLine = new Line2D.Double(mySashLeaf.bX2, midY,
				mySashLeaf.bX2 - mySashLeaf.widthPix / 12, midY);

		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);
	}

	public void doVPivot(SashLeaf mySashLeaf, double myStartYY) {

		double midX = 0;
		double midY = 0;

		midX = mySashLeaf.startingX + (mySashLeaf.bX2 - mySashLeaf.startingX)
				/ 2;
		midY = mySashLeaf.startingY + (mySashLeaf.bY4 - mySashLeaf.startingY)
				/ 2;

		mySashLeaf.mySymbolLine = new Line2D.Double(mySashLeaf.startingX, midY,
				midX, mySashLeaf.startingY);

		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);

		mySashLeaf.mySymbolLine = new Line2D.Double(midX, mySashLeaf.startingY,
				mySashLeaf.bX2, midY);

		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);

		mySashLeaf.mySymbolLine = new Line2D.Double(midX, mySashLeaf.bY4,
				mySashLeaf.bX2, midY);

		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);

		mySashLeaf.mySymbolLine = new Line2D.Double(midX, mySashLeaf.bY4,
				mySashLeaf.startingX, midY);

		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);

		mySashLeaf.mySymbolLine = new Line2D.Double(midX, mySashLeaf.startingY,
				midX, mySashLeaf.startingY + mySashLeaf.heightPix / 12);

		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);

		mySashLeaf.mySymbolLine = new Line2D.Double(midX, mySashLeaf.bY4, midX,
				mySashLeaf.bY4 - mySashLeaf.heightPix / 12);

		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);

	}

	public void doFolding(SashLeaf mySashLeaf, double myStartYY, int a) {

		double midX = 0;
		double midY = 0;

		midX = mySashLeaf.startingX + (mySashLeaf.bX2 - mySashLeaf.startingX)
				/ 2;
		midY = mySashLeaf.startingY + (mySashLeaf.bY4 - mySashLeaf.startingY)
				/ 2;

		mySashLeaf.mySymbolLine = new Line2D.Double(mySashLeaf.startingX, midY,
				midX, mySashLeaf.startingY);

		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);

		mySashLeaf.mySymbolLine = new Line2D.Double(midX, mySashLeaf.startingY,
				mySashLeaf.bX2, midY);

		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);

		mySashLeaf.mySymbolLine = new Line2D.Double(midX, mySashLeaf.bY4,
				mySashLeaf.bX2, midY);

		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);

		mySashLeaf.mySymbolLine = new Line2D.Double(midX, mySashLeaf.bY4,
				mySashLeaf.startingX, midY);

		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);

		mySashLeaf.mySymbolLine = new Line2D.Double(mySashLeaf.startingX, midY,
				mySashLeaf.startingX + mySashLeaf.widthPix / 12, midY);

		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);

		mySashLeaf.mySymbolLine = new Line2D.Double(mySashLeaf.bX2, midY,
				mySashLeaf.bX2 - mySashLeaf.widthPix / 12, midY);

		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);
	}

	public void doRightSlideSymbolViewOut(SashLeaf mySashLeaf) {

		double sx;
		double ex;
		double ly;
		double sxAT;
		double syAT;
		double syAB;
		if (mySashLeaf.trackNo == ntracks && fixedSashOuttrack) {

		} else {
			sx = mySashLeaf.startingX + mySashLeaf.widthPix / 4;
			ex = mySashLeaf.startingX + mySashLeaf.widthPix
					- mySashLeaf.widthPix / 4;
			ly = mySashLeaf.startingY + mySashLeaf.heightPix / 2;

			sxAT = ex - mySashLeaf.widthPix / 8;
			syAT = ly - mySashLeaf.heightPix / 8;
			syAB = ly + mySashLeaf.heightPix / 8;

			mySashLeaf.mySymbolLine = new Line2D.Double(sx, ly, ex, ly);
			mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);
			mySashLeaf.mySymbolLine = new Line2D.Double(ex, ly, sxAT, syAT);
			mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);
			mySashLeaf.mySymbolLine = new Line2D.Double(ex, ly, sxAT, syAB);
			mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);
		}
	}

	public void doLeftSlideSymbolViewOut(SashLeaf mySashLeaf) {

		double sx;
		double ex;
		double ly;
		double sxAT;
		double syAT;
		double syAB;
		
		if (mySashLeaf.trackNo == ntracks && fixedSashOuttrack) {

		} else {
			sx = mySashLeaf.startingX + mySashLeaf.widthPix / 4;
			ex = mySashLeaf.startingX + mySashLeaf.widthPix
					- mySashLeaf.widthPix / 4;
			ly = mySashLeaf.startingY + mySashLeaf.heightPix / 2;

			sxAT = mySashLeaf.startingX + mySashLeaf.widthPix / 4
					+ mySashLeaf.widthPix / 8;
			syAT = ly - mySashLeaf.heightPix / 8;
			syAB = ly + mySashLeaf.heightPix / 8;

			mySashLeaf.mySymbolLine = new Line2D.Double(sx, ly, ex, ly);
			mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);
			mySashLeaf.mySymbolLine = new Line2D.Double(sx, ly, sxAT, syAT);
			mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);
			mySashLeaf.mySymbolLine = new Line2D.Double(sx, ly, sxAT, syAB);
			mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);
		}
	}

	public void doCenterSlideSymbol(SashLeaf mySashLeaf) {

		double sx;
		double ex;
		double ly;
		double sxAT;
		double syAT;
		double syAB;
		sx = mySashLeaf.startingX + mySashLeaf.widthPix / 4;
		ex = mySashLeaf.startingX + mySashLeaf.widthPix - mySashLeaf.widthPix
				/ 4;
		ly = mySashLeaf.startingY + mySashLeaf.heightPix / 2;

		sxAT = mySashLeaf.startingX + mySashLeaf.widthPix / 4
				+ mySashLeaf.widthPix / 8;
		syAT = ly - mySashLeaf.heightPix / 8;
		syAB = ly + mySashLeaf.heightPix / 8;

		mySashLeaf.mySymbolLine = new Line2D.Double(sx, ly, ex, ly);
		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);
		mySashLeaf.mySymbolLine = new Line2D.Double(sx, ly, sxAT, syAT);
		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);
		mySashLeaf.mySymbolLine = new Line2D.Double(sx, ly, sxAT, syAB);
		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);

		sx = mySashLeaf.startingX + mySashLeaf.widthPix / 4;
		ex = mySashLeaf.startingX + mySashLeaf.widthPix - mySashLeaf.widthPix
				/ 4;
		ly = mySashLeaf.startingY + mySashLeaf.heightPix / 2;

		sxAT = ex - mySashLeaf.widthPix / 8;
		syAT = ly - mySashLeaf.heightPix / 8;
		syAB = ly + mySashLeaf.heightPix / 8;

		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);
		mySashLeaf.mySymbolLine = new Line2D.Double(ex, ly, sxAT, syAT);
		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);
		mySashLeaf.mySymbolLine = new Line2D.Double(ex, ly, sxAT, syAB);
		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);
	}

	public void doBottomSlideSymbolViewOut(SashLeaf mySashLeaf) {

		double sx;
		double ex;
		double sy;
		double ey;
		double sxAL;
		double sxAR;
		double syAL;

		sx = ex = mySashLeaf.startingX + mySashLeaf.widthPix / 2;

		double netH = mySashLeaf.bY4
				- mySashLeaf.top1Part.partDimB
				- mySashLeaf.top1Part.partDimA
				- (mySashLeaf.bY2 + mySashLeaf.top1Part.partDimB + mySashLeaf.top1Part.partDimA);

		double netStartY = mySashLeaf.highestY + mySashLeaf.top1Part.partDimB
				+ mySashLeaf.top1Part.partDimA;

		sy = netStartY + netH / 4;
		ey = netStartY + netH - netH / 4;

		sxAL = sx - mySashLeaf.widthPix / 8;
		sxAR = sx + mySashLeaf.widthPix / 8;
		syAL = sy + netH / 4;
		mySashLeaf.mySymbolLine = new Line2D.Double(sx, sy, ex, ey);
		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);
		mySashLeaf.mySymbolLine = new Line2D.Double(sx, sy, sxAL, syAL);
		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);
		mySashLeaf.mySymbolLine = new Line2D.Double(sx, sy, sxAR, syAL);
		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);
	}

	public void doTopSlideSymbolViewOut(SashLeaf mySashLeaf) {

		double sx;
		double ex;
		double sy;
		double ey;
		double sxAL;
		double sxAR;
		double syAL;
		sx = ex = mySashLeaf.startingX + mySashLeaf.widthPix / 2;

		double netH = mySashLeaf.bY4
				- mySashLeaf.top1Part.partDimB
				- mySashLeaf.top1Part.partDimA
				- (mySashLeaf.highestY + mySashLeaf.top1Part.partDimB + mySashLeaf.top1Part.partDimA);
		double netStartY = mySashLeaf.highestY + mySashLeaf.top1Part.partDimB
				+ mySashLeaf.top1Part.partDimA;

		sy = netStartY + netH / 4;
		ey = netStartY + netH - netH / 4;

		sxAL = sx - mySashLeaf.widthPix / 8;
		sxAR = sx + mySashLeaf.widthPix / 8;
		syAL = ey - netH / 4;
		mySashLeaf.mySymbolLine = new Line2D.Double(sx, sy, ex, ey);
		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);
		mySashLeaf.mySymbolLine = new Line2D.Double(ex, ey, sxAL, syAL);
		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);
		mySashLeaf.mySymbolLine = new Line2D.Double(ex, ey, sxAR, syAL);
		mySashLeaf.symbol.add(mySashLeaf.mySymbolLine);
	}

	public SashLeaf initSashPartsOLD(SashLeaf mySashLeaf) {

		// Get Sash Clearance and Dims

		mySashLeaf.top1Part = new Profiles();
		mySashLeaf.top2Part = new Profiles();
		mySashLeaf.top3Part = new Profiles();
		mySashLeaf.rightPart = new Profiles();
		mySashLeaf.leftPart = new Profiles();
		mySashLeaf.bot1Part = new Profiles();
		mySashLeaf.bot2Part = new Profiles();
		mySashLeaf.bot3Part = new Profiles();

		mySashLeaf = this.setPartformsOLD(mySashLeaf);

		return mySashLeaf;

	}

	public SashLeaf initSashParts(SashLeaf mySashLeaf, OpeningObject myOpening) {

		// Get Sash Clearance and Dims

		mySashLeaf.top1Part = new Profiles();
		mySashLeaf.top2Part = new Profiles();
		mySashLeaf.top3Part = new Profiles();
		mySashLeaf.rightPart = new Profiles();
		mySashLeaf.leftPart = new Profiles();
		mySashLeaf.bot1Part = new Profiles();
		mySashLeaf.bot2Part = new Profiles();
		mySashLeaf.bot3Part = new Profiles();

		mySashLeaf = this.setPartforms(mySashLeaf, myOpening);

		return mySashLeaf;

	}

	public SashLeaf setPartformsOLD(SashLeaf mySashLeaf) {

		mySashLeaf.top1Part.partForm = myParentO.top1.partForm;

		mySashLeaf.top2Part.partForm = myParentO.top2.partForm;

		mySashLeaf.top3Part.partForm = myParentO.top3.partForm;

		mySashLeaf.bot1Part.partForm = myParentO.bot1.partForm;

		mySashLeaf.bot2Part.partForm = myParentO.bot2.partForm;

		mySashLeaf.bot3Part.partForm = myParentO.bot3.partForm;

		mySashLeaf.leftPart.partForm = myParentO.left.partForm;

		mySashLeaf.rightPart.partForm = myParentO.right.partForm;

		mySashLeaf.top1Part.glazedOut = myParentO.glazedOut;
		mySashLeaf.top2Part.glazedOut = myParentO.glazedOut;
		mySashLeaf.top3Part.glazedOut = myParentO.glazedOut;

		mySashLeaf.bot1Part.glazedOut = myParentO.glazedOut;

		mySashLeaf.bot2Part.glazedOut = myParentO.glazedOut;

		mySashLeaf.bot3Part.glazedOut = myParentO.glazedOut;

		mySashLeaf.leftPart.glazedOut = myParentO.glazedOut;

		mySashLeaf.rightPart.glazedOut = myParentO.glazedOut;

		mySashLeaf = this.doPartPosOLD(mySashLeaf);

		return mySashLeaf;
	}

	public SashLeaf setPartforms(SashLeaf mySashLeaf, OpeningObject myOpening) {

		mySashLeaf.top1Part.partForm = myOpening.top1Part.partForm;

		mySashLeaf.top2Part.partForm = myOpening.top2Part.partForm;

		mySashLeaf.top3Part.partForm = myOpening.top3Part.partForm;

		mySashLeaf.bot1Part.partForm = myOpening.bot1Part.partForm;

		mySashLeaf.bot2Part.partForm = myOpening.bot2Part.partForm;

		mySashLeaf.bot3Part.partForm = myOpening.bot3Part.partForm;

		mySashLeaf.leftPart.partForm = myOpening.leftPart.partForm;

		mySashLeaf.rightPart.partForm = myOpening.rightPart.partForm;

		mySashLeaf.top1Part.glazedOut = myOpening.glazedOut;
		mySashLeaf.top2Part.glazedOut = myOpening.glazedOut;
		mySashLeaf.top3Part.glazedOut = myOpening.glazedOut;

		mySashLeaf.bot1Part.glazedOut = myOpening.glazedOut;

		mySashLeaf.bot2Part.glazedOut = myOpening.glazedOut;

		mySashLeaf.bot3Part.glazedOut = myOpening.glazedOut;

		mySashLeaf.leftPart.glazedOut = myOpening.glazedOut;

		mySashLeaf.rightPart.glazedOut = myOpening.glazedOut;

		mySashLeaf = this.doPartPos(mySashLeaf, myOpening);

		return mySashLeaf;
	}

	public Object[] setPartDims(SashLeaf mySashLeaf,
			CreateShapeMethods createShape) {

		Object[] myreturns = new Object[2];
		mySashLeaf.top1Part.profileSelected = 0;
		mySashLeaf.top2Part.profileSelected = 0;
		mySashLeaf.top3Part.profileSelected = 0;
		mySashLeaf.bot1Part.profileSelected = 0;
		mySashLeaf.bot2Part.profileSelected = 0;
		mySashLeaf.bot3Part.profileSelected = 0;
		mySashLeaf.leftPart.profileSelected = 0;
		mySashLeaf.rightPart.profileSelected = 0;

		// mySashLeaf.executePartRules(false, false,
		// "createsash.setpartdims.3979");
		mySashLeaf.executePartRules(false);
		mySashLeaf.top1Part.lengthMN = (int) (mySashLeaf.top1Part.length / myFrame2.metricscale
				.doubleValue());
		mySashLeaf.top1Part.lengthIN = (int) (mySashLeaf.top1Part.length / myFrame2.imperialscale
				.doubleValue());

		mySashLeaf.top2Part.lengthMN = (int) (mySashLeaf.top2Part.length / myFrame2.metricscale
				.doubleValue());
		mySashLeaf.top2Part.lengthIN = (int) (mySashLeaf.top2Part.length / myFrame2.imperialscale
				.doubleValue());

		mySashLeaf.top3Part.lengthMN = (int) (mySashLeaf.top3Part.length / myFrame2.metricscale
				.doubleValue());
		mySashLeaf.top3Part.lengthIN = (int) (mySashLeaf.top3Part.length / myFrame2.imperialscale
				.doubleValue());

		mySashLeaf.bot1Part.lengthMN = (int) (mySashLeaf.bot1Part.length / myFrame2.metricscale
				.doubleValue());
		mySashLeaf.bot1Part.lengthIN = (int) (mySashLeaf.bot1Part.length / myFrame2.imperialscale
				.doubleValue());

		mySashLeaf.bot2Part.lengthMN = (int) (mySashLeaf.bot2Part.length / myFrame2.metricscale
				.doubleValue());
		mySashLeaf.bot2Part.lengthIN = (int) (mySashLeaf.bot2Part.length / myFrame2.imperialscale
				.doubleValue());

		mySashLeaf.bot3Part.lengthMN = (int) (mySashLeaf.bot3Part.length / myFrame2.metricscale
				.doubleValue());
		mySashLeaf.bot3Part.lengthIN = (int) (mySashLeaf.bot3Part.length / myFrame2.imperialscale
				.doubleValue());

		mySashLeaf.leftPart.lengthMN = (int) (mySashLeaf.leftPart.length / myFrame2.metricscale
				.doubleValue());
		mySashLeaf.leftPart.lengthIN = (int) (mySashLeaf.leftPart.length / myFrame2.imperialscale
				.doubleValue());

		mySashLeaf.rightPart.lengthMN = (int) (mySashLeaf.rightPart.length / myFrame2.metricscale
				.doubleValue());
		mySashLeaf.rightPart.lengthIN = (int) (mySashLeaf.rightPart.length / myFrame2.imperialscale
				.doubleValue());

		mySashLeaf = (SashLeaf) this.myFrame2.shapeColor
				.setShapeObjectPartColors(mySashLeaf);

		if (myFrame2.mySeries.getSeriesUom() == 1) {
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
			// Set first blade size if partial louvre encountered

			if (partialLouvreSize > 0 && mySashLeaf.trackNo == 1) {
				mySashLeaf.bot1Part.partDimB = mySashLeaf.bot1Part.partDimB
						* partialLouvreSize;
				createShape.bot1DimBo = createShape.bot1DimB = mySashLeaf.bot1Part.partDimBi = mySashLeaf.bot1Part.partDimB;

			}

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
		} else {
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

	public Object[] setPartDimsSashType(SashTypeObject mySashLeaf,
			CreateShapeMethods createShape) {

		Object[] myreturns = new Object[2];
		mySashLeaf.top1Part.profileSelected = 0;
		mySashLeaf.top2Part.profileSelected = 0;
		mySashLeaf.top3Part.profileSelected = 0;
		mySashLeaf.bot1Part.profileSelected = 0;
		mySashLeaf.bot2Part.profileSelected = 0;
		mySashLeaf.bot3Part.profileSelected = 0;
		mySashLeaf.leftPart.profileSelected = 0;
		mySashLeaf.rightPart.profileSelected = 0;
		mySashLeaf.options.clear();
		mySashLeaf.executeOptionRules("createSash.setPartDimsSashType.4093");
		// mySashLeaf.executePartRules(false, false,
		// "createSash.setPartDimsSashType.4094");
		mySashLeaf.executePartRules(false);
		mySashLeaf.top1Part.lengthMN = (int) (mySashLeaf.top1Part.length / myFrame2.metricscale
				.doubleValue());
		mySashLeaf.top1Part.lengthIN = (int) (mySashLeaf.top1Part.length / myFrame2.imperialscale
				.doubleValue());

		mySashLeaf.top2Part.lengthMN = (int) (mySashLeaf.top2Part.length / myFrame2.metricscale
				.doubleValue());
		mySashLeaf.top2Part.lengthIN = (int) (mySashLeaf.top2Part.length / myFrame2.imperialscale
				.doubleValue());

		mySashLeaf.top3Part.lengthMN = (int) (mySashLeaf.top3Part.length / myFrame2.metricscale
				.doubleValue());
		mySashLeaf.top3Part.lengthIN = (int) (mySashLeaf.top3Part.length / myFrame2.imperialscale
				.doubleValue());

		mySashLeaf.bot1Part.lengthMN = (int) (mySashLeaf.bot1Part.length / myFrame2.metricscale
				.doubleValue());
		mySashLeaf.bot1Part.lengthIN = (int) (mySashLeaf.bot1Part.length / myFrame2.imperialscale
				.doubleValue());

		mySashLeaf.bot2Part.lengthMN = (int) (mySashLeaf.bot2Part.length / myFrame2.metricscale
				.doubleValue());
		mySashLeaf.bot2Part.lengthIN = (int) (mySashLeaf.bot2Part.length / myFrame2.imperialscale
				.doubleValue());

		mySashLeaf.bot3Part.lengthMN = (int) (mySashLeaf.bot3Part.length / myFrame2.metricscale
				.doubleValue());
		mySashLeaf.bot3Part.lengthIN = (int) (mySashLeaf.bot3Part.length / myFrame2.imperialscale
				.doubleValue());

		mySashLeaf.leftPart.lengthMN = (int) (mySashLeaf.leftPart.length / myFrame2.metricscale
				.doubleValue());
		mySashLeaf.leftPart.lengthIN = (int) (mySashLeaf.leftPart.length / myFrame2.imperialscale
				.doubleValue());

		mySashLeaf.rightPart.lengthMN = (int) (mySashLeaf.rightPart.length / myFrame2.metricscale
				.doubleValue());
		mySashLeaf.rightPart.lengthIN = (int) (mySashLeaf.rightPart.length / myFrame2.imperialscale
				.doubleValue());

		mySashLeaf = (SashTypeObject) this.myFrame2.shapeColor
				.setShapeObjectPartColors(mySashLeaf);

		if (myFrame2.mySeries.getSeriesUom() == 1) {
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
		} else {
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

	/**
	 * Intersec Axis x
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param bx1
	 * @param by1
	 * @param bx2
	 * @param by2
	 * @return double
	 */
	public double intersectX(double x1, double y1, double x2, double y2,
			double bx1, double by1, double bx2, double by2) {

		double x = 0;
		double px = x1, py = y1, rx = x2 - px, ry = y2 - py;
		double qx = bx1, qy = by1, sx = bx2 - qx, sy = by2 - qy;

		double det = sx * ry - sy * rx;

		if (det == 0) {
			return x;
		} else {
			double z = (sx * (qy - py) + sy * (px - qx)) / det;
			x = px + z * rx;
		}

		return x;

	} // end intersection line-line

	/**
	 * Intersec Axis Y
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param bx1
	 * @param by1
	 * @param bx2
	 * @param by2
	 * @return double
	 */
	public double intersectY(double x1, double y1, double x2, double y2,
			double bx1, double by1, double bx2, double by2) {

		double y = 0;
		double px = x1, py = y1, rx = x2 - px, ry = y2 - py;
		double qx = bx1, qy = by1, sx = bx2 - qx, sy = by2 - qy;
		double det = sx * ry - sy * rx;

		if (det == 0) {
			return y;
		} else {
			double z = (sx * (qy - py) + sy * (px - qx)) / det;
			y = py + z * ry;
		}

		return y;
	} // end intersection l

	public Point2D getIntersectionLineArc(double bsX, double bsY, double w,
			double h, double sA, double eA, double cX, double cY, double sX,
			double sY, double eX, double eY, int pos, boolean isP) {

		Point2D myP = new Point2D.Double();

		if (pos == 1) {// Top Part

			Point2D myPs = new Point2D.Double(sX, sY);
			Point2D myPe = new Point2D.Double(eX, eY);

			myP = this.getLineCircleIntersection(bsX, bsY, w, h, cX, cY, myPs,
					myPe, isP);
		}

		return myP;

	}

	public Point2D getLineCircleIntersection(double bsX, double bsY, double wW,
			double hH, double centerX, double centerY, Point2D source,
			Point2D p, boolean isP) {

		double a = wW / 2;// r.getWidth() +
		double b = hH / 2;// r.getHeight() +
		// x0,y0 - center of ellipse
		double x0 = centerX;// view.getCenterX();//x
		// a;
		double y0 = centerY;// view.getCenterY();//y
		double x1 = 0; // was p
		double y1 = 0;
		if (!isP) {
			x1 = source.getX(); // was p
			y1 = source.getY();
		} else {
			x1 = p.getX();
			y1 = p.getY();
		}

		// Calculates straight line equation through point
		// and ellipse center
		// y = d * x + h
		double dx = x1 - x0;
		double dy = y1 - y0;

		if (dx == 0) {
			return new Point2D.Double(x0, (y0 + b * dy / Math.abs(dy)));
		}

		double d = dy / dx;
		double h = y0 - d * x0;

		// Calculates intersection
		double e = a * a * d * d + b * b;
		double f = -2 * x0 * e;
		double g = a * a * d * d * x0 * x0 + b * b * x0 * x0 - a * a * b * b;

		double det = Math.sqrt(f * f - 4 * e * g);

		// Two solutions (perimeter points)
		double xout1 = (-f + det) / (2 * e);
		double xout2 = (-f - det) / (2 * e);
		double yout1 = d * xout1 + h;
		double yout2 = d * xout2 + h;

		double dist1 = Math.sqrt(Math.pow((xout1 - x1), 2)
				+ Math.pow((yout1 - y1), 2));
		double dist2 = Math.sqrt(Math.pow((xout2 - x1), 2)
				+ Math.pow((yout2 - y1), 2));

		// Correct solution
		double xout, yout;

		if (dist1 < dist2) {
			xout = xout1;
			yout = yout1;
		} else {
			xout = xout2;
			yout = yout2;
		}

		return new Point2D.Double(xout, yout);
	}

	public SashLeaf copyParts(SashLeaf myFrame, SashLeaf original) {

		// Get Sash Clearance and Dims
		myFrame.top1Part.partDimC = original.top1Part.partDimC;
		myFrame.top1Part.partDimB = original.top1Part.partDimB;
		myFrame.top1Part.partDimA = original.top1Part.partDimA;
		myFrame.top1Part.partDimM = original.top1Part.partDimM;
		myFrame.top1Part.partID = original.top1Part.partID;
		myFrame.top1Part.partForm = original.top1Part.partForm;
		myFrame.top1Part.endTypeLT = original.top1Part.endTypeLT;
		myFrame.top1Part.endTypeRB = original.top1Part.endTypeRB;

		myFrame.top2Part.partDimC = original.top2Part.partDimC;
		myFrame.top2Part.partDimB = original.top2Part.partDimB;
		myFrame.top2Part.partDimA = original.top2Part.partDimA;
		myFrame.top2Part.partDimM = original.top2Part.partDimM;
		myFrame.top2Part.partID = original.top2Part.partID;
		myFrame.top2Part.partForm = original.top2Part.partForm;
		myFrame.top2Part.endTypeLT = original.top2Part.endTypeLT;
		myFrame.top2Part.endTypeRB = original.top2Part.endTypeRB;

		myFrame.top3Part.partDimC = original.top3Part.partDimC;
		myFrame.top3Part.partDimB = original.top3Part.partDimB;
		myFrame.top3Part.partDimA = original.top3Part.partDimA;
		myFrame.top3Part.partDimM = original.top3Part.partDimM;
		myFrame.top3Part.partID = original.top3Part.partID;
		myFrame.top3Part.partForm = original.top3Part.partForm;
		myFrame.top3Part.endTypeLT = original.top3Part.endTypeLT;
		myFrame.top3Part.endTypeRB = original.top3Part.endTypeRB;

		myFrame.bot1Part.partDimC = original.bot1Part.partDimC;
		myFrame.bot1Part.partDimB = original.bot1Part.partDimB;
		myFrame.bot1Part.partDimA = original.bot1Part.partDimA;
		myFrame.bot1Part.partDimM = original.bot1Part.partDimM;
		myFrame.bot1Part.partID = original.bot1Part.partID;
		myFrame.bot1Part.partForm = original.bot1Part.partForm;
		myFrame.bot1Part.endTypeLT = original.bot1Part.endTypeLT;
		myFrame.bot1Part.endTypeRB = original.bot1Part.endTypeRB;

		myFrame.bot2Part.partDimC = original.bot2Part.partDimC;
		myFrame.bot2Part.partDimB = original.bot2Part.partDimB;
		myFrame.bot2Part.partDimA = original.bot2Part.partDimA;
		myFrame.bot2Part.partDimM = original.bot2Part.partDimM;
		myFrame.bot2Part.partID = original.bot2Part.partID;
		myFrame.bot2Part.partForm = original.bot2Part.partForm;
		myFrame.bot2Part.endTypeLT = original.bot2Part.endTypeLT;
		myFrame.bot2Part.endTypeRB = original.bot2Part.endTypeRB;

		myFrame.bot3Part.partDimC = original.bot3Part.partDimC;
		myFrame.bot3Part.partDimB = original.bot3Part.partDimB;
		myFrame.bot3Part.partDimA = original.bot3Part.partDimA;
		myFrame.bot3Part.partDimM = original.bot3Part.partDimM;
		myFrame.bot3Part.partID = original.bot3Part.partID;
		myFrame.bot3Part.partForm = original.bot3Part.partForm;
		myFrame.bot3Part.endTypeLT = original.bot3Part.endTypeLT;
		myFrame.bot3Part.endTypeRB = original.bot3Part.endTypeRB;

		myFrame.leftPart.partDimC = original.leftPart.partDimC;
		myFrame.leftPart.partDimB = original.leftPart.partDimB;
		myFrame.leftPart.partDimA = original.leftPart.partDimA;
		myFrame.leftPart.partDimM = original.leftPart.partDimM;
		myFrame.leftPart.partID = original.leftPart.partID;
		myFrame.leftPart.partForm = original.leftPart.partForm;
		myFrame.leftPart.endTypeLT = original.leftPart.endTypeLT;
		myFrame.leftPart.endTypeRB = original.leftPart.endTypeRB;

		myFrame.rightPart.partDimC = original.rightPart.partDimC;
		myFrame.rightPart.partDimB = original.rightPart.partDimB;
		myFrame.rightPart.partDimA = original.rightPart.partDimA;
		myFrame.rightPart.partDimM = original.rightPart.partDimM;
		myFrame.rightPart.partID = original.rightPart.partID;
		myFrame.rightPart.partForm = original.rightPart.partForm;
		myFrame.rightPart.endTypeLT = original.rightPart.endTypeLT;
		myFrame.rightPart.endTypeRB = original.rightPart.endTypeRB;

		// //////
		myFrame.top1.partDimC = original.top1.partDimC;
		myFrame.top1.partDimB = original.top1.partDimB;
		myFrame.top1.partDimA = original.top1.partDimA;
		myFrame.top1.partDimM = original.top1.partDimM;
		myFrame.top1.partID = original.top1.partID;
		myFrame.top1.partForm = original.top1.partForm;

		myFrame.top2.partDimC = original.top2.partDimC;
		myFrame.top2.partDimB = original.top2.partDimB;
		myFrame.top2.partDimA = original.top2.partDimA;
		myFrame.top2.partDimM = original.top2.partDimM;
		myFrame.top2.partID = original.top2.partID;
		myFrame.top2.partForm = original.top2.partForm;

		myFrame.top3.partDimC = original.top3.partDimC;
		myFrame.top3.partDimB = original.top3.partDimB;
		myFrame.top3.partDimA = original.top3.partDimA;
		myFrame.top3.partDimM = original.top3.partDimM;
		myFrame.top3.partID = original.top3.partID;
		myFrame.top3.partForm = original.top3.partForm;

		myFrame.bot1.partDimC = original.bot1.partDimC;
		myFrame.bot1.partDimB = original.bot1.partDimB;
		myFrame.bot1.partDimA = original.bot1.partDimA;
		myFrame.bot1.partDimM = original.bot1.partDimM;
		myFrame.bot1.partID = original.bot1.partID;
		myFrame.bot1.partForm = original.bot1.partForm;

		myFrame.bot2.partDimC = original.bot2.partDimC;
		myFrame.bot2.partDimB = original.bot2.partDimB;
		myFrame.bot2.partDimA = original.bot2.partDimA;
		myFrame.bot2.partDimM = original.bot2.partDimM;
		myFrame.bot2.partID = original.bot2.partID;
		myFrame.bot2.partForm = original.bot2.partForm;

		myFrame.bot3.partDimC = original.bot3.partDimC;
		myFrame.bot3.partDimB = original.bot3.partDimB;
		myFrame.bot3.partDimA = original.bot3.partDimA;
		myFrame.bot3.partDimM = original.bot3.partDimM;
		myFrame.bot3.partID = original.bot3.partID;
		myFrame.bot3.partForm = original.bot3.partForm;

		myFrame.left.partDimC = original.left.partDimC;
		myFrame.left.partDimB = original.left.partDimB;
		myFrame.left.partDimA = original.left.partDimA;
		myFrame.left.partDimM = original.left.partDimM;
		myFrame.left.partID = original.left.partID;
		myFrame.left.partForm = original.left.partForm;

		myFrame.right.partDimC = original.right.partDimC;
		myFrame.right.partDimB = original.right.partDimB;
		myFrame.right.partDimA = original.right.partDimA;
		myFrame.right.partDimM = original.right.partDimM;
		myFrame.right.partID = original.right.partID;
		myFrame.right.partForm = original.right.partForm;

		return myFrame;

	}

	public ShapeObject cloneShapeFromParentOpening(ShapeObject object,
			OpeningObject opening) {

		object.myFrame2 = myFrame2;
		object.myParentO = opening;

		object.a_1Level = opening.a_assemblyLevel;
		object.a_1Sequence = opening.a_sequenceID;
		object.a_2Level = opening.a_1Level;
		object.a_2Sequence = opening.a_1Sequence;
		object.a_3Level = opening.a_2Level;
		object.a_3Sequence = opening.a_2Sequence;
		object.a_4Level = opening.a_3Level;
		object.a_4Sequence = opening.a_3Sequence;

		object.a_5Level = opening.a_4Level;
		object.a_5Sequence = opening.a_4Sequence;
		object.a_6Level = opening.a_5Level;
		object.a_6Sequence = opening.a_5Sequence;
		object.a_7Level = opening.a_6Level;
		object.a_7Sequence = opening.a_6Sequence;
		object.a_8Level = opening.a_7Level;
		object.a_8Sequence = opening.a_7Sequence;
		object.a_9Level = opening.a_8Level;
		object.a_9Sequence = opening.a_8Sequence;
		object.a_10Level = opening.a_9Level;
		object.a_10Sequence = opening.a_9Sequence;

		object.leafNo = opening.leafNo;

		object.shapeID = opening.shapeID;

		object.highestY = opening.highestY;
		object.highestYC = opening.highestYC;

		object.lowestY = opening.lowestY;
		object.lowestYC = opening.lowestYC;

		object.startingX = opening.startingX;
		object.startingY = opening.startingY;

		object.startCol = opening.startCol;
		object.endCol = opening.endCol;
		object.startRow = opening.startRow;
		object.endRow = opening.endRow;

		object.rID = opening.rID;

		object.widthPix = opening.widthPix;
		object.heightPix = opening.heightPix;

		object.widthM = opening.widthM;
		object.widthMN = opening.widthMN;
		object.heightM = opening.heightM;
		object.heightMN = opening.heightMN;

		object.widthI = opening.widthI;
		object.widthIN = opening.widthIN;
		object.heightI = opening.heightI;
		object.heightIN = opening.heightIN;

		object.shapeID = opening.shapeID;

		object.startingX = opening.startingX;
		object.startingY = opening.startingY;

		object.a_sequenceID = opening.a_sequenceID;

		object.radius1 = opening.radius1;
		object.radius2 = opening.radius2;

		object.myParent = object.myOverall = object.myFacet = opening.myParent;

		object.shapeChanged = opening.shapeChanged;

		object.bkgrdStartX = opening.bkgrdStartX;
		object.bkgrdStartY = opening.bkgrdStartY;

		object.noSides = opening.noSides;
		object.noSidesTop = opening.noSidesTop;
		object.noSidesBot = opening.noSidesBot;
		object.noSidesLeft = opening.noSidesLeft;
		object.noSidesRight = opening.noSidesRight;

		object.centerPointX = opening.centerPointX;
		object.centerPointX2 = opening.centerPointX2;
		object.centerPointY = opening.centerPointY;
		object.centerPointY2 = opening.centerPointY2;

		object.bX2 = opening.bX2;
		object.bY2 = opening.bY2;
		object.bX3 = opening.bX3;
		object.bY3 = opening.bY3;
		object.bX4 = opening.bX4;
		object.bY4 = opening.bY4;

		object.startingCX = opening.startingCX;
		object.startingCY = opening.startingCY;

		object.bCX2 = opening.bCX2;
		object.bCY2 = opening.bCY2;
		object.bCX3 = opening.bCX3;
		object.bCY3 = opening.bCY3;
		object.bCX4 = opening.bCX4;
		object.bCY4 = opening.bCY4;

		object.dimA1 = opening.dimA1;
		object.dimA2 = opening.dimA2;
		object.dimA3 = opening.dimA3;
		object.dimA4 = opening.dimA4;
		object.dimA5 = opening.dimA5;
		object.dimA0 = opening.dimA0;
		object.dimB1 = opening.dimB1;
		object.dimB2 = opening.dimB2;
		object.dimB3 = opening.dimB3;
		object.dimB4 = opening.dimB4;
		object.dimB5 = opening.dimB5;
		object.dimB0 = opening.dimB0;
		object.dimC1 = opening.dimC1;
		object.dimC2 = opening.dimC2;
		object.dimC3 = opening.dimC3;
		object.dimC4 = opening.dimC4;
		object.dimC5 = opening.dimC5;
		object.dimC0 = opening.dimC0;
		object.dimD1 = opening.dimD1;
		object.dimD2 = opening.dimD2;
		object.dimD3 = opening.dimD3;
		object.dimD4 = opening.dimD4;
		object.dimD5 = opening.dimD5;
		object.dimD0 = opening.dimD0;

		object.dimTM = opening.dimTM;
		object.dimBM = opening.dimBM;
		object.dimLM = opening.dimLM;
		object.dimRM = opening.dimRM;
		object.dimTA = opening.dimTA;
		object.dimBA = opening.dimBA;
		object.dimLA = opening.dimLA;
		object.dimRA = opening.dimRA;

		object.topIn = opening.topIn;
		object.botIn = opening.botIn;
		object.leftIn = opening.leftIn;
		object.rightIn = opening.rightIn;

		object.lean = opening.lean;
		object.lean2 = opening.lean2;
		object.lean3 = opening.lean3;
		object.lean4 = opening.lean4;

		object.parentH = opening.parentH;
		object.parentW = opening.parentW;

		object.parentStartY = opening.parentStartY;
		object.parentStartX = opening.parentStartX;
		object.parentRadius1 = opening.parentRadius1;// *
		// 2;

		object.parentCX = opening.parentCX;
		object.parentCY = opening.parentCY;
		object.parentCX2 = opening.parentCX2;
		object.parentCY2 = opening.parentCY2;
		object.parentShape = opening.parentShape;

		object.px1 = opening.px1;
		object.py1 = opening.py1;
		object.px2 = opening.px2;
		object.py2 = opening.py2;
		object.px3 = opening.px3;
		object.py3 = opening.py3;
		object.px4 = opening.px4;
		object.py4 = opening.py4;
		object.px5 = opening.px5;
		object.py5 = opening.py5;
		object.px6 = opening.px6;
		object.py6 = opening.py6;
		object.px7 = opening.px7;
		object.py7 = opening.py7;
		object.px8 = opening.px8;
		object.py8 = opening.py8;

		object.startingCX = opening.startingCX;
		object.startingCY = opening.startingCY;

		object.px1c = opening.px1c;
		object.py1c = opening.py1c;
		object.px2c = opening.px2c;
		object.py2c = opening.py2c;
		object.px3c = opening.px3c;
		object.py3c = opening.py3c;
		object.px4c = opening.px4c;
		object.py4c = opening.py4c;
		object.px5c = opening.px5c;
		object.py5c = opening.py5c;
		object.px6c = opening.px6c;
		object.py6c = opening.py6c;
		object.px7c = opening.px7c;
		object.py7c = opening.py7c;
		object.px8c = opening.px8c;
		object.py8c = opening.py8c;

		object.bCX2 = opening.bCX2;
		object.bCY2 = opening.bCY2;
		object.bCX3 = opening.bCX3;
		object.bCY3 = opening.bCY3;
		object.bCX4 = opening.bCX4;
		object.bCY4 = opening.bCY4;

		// myframe.top1Part =
		// myframe.top1Part.cloneProfile(opening.top1Part);
		// myframe.top2Part =
		// myframe.top2Part.cloneProfile(opening.top2Part);
		// myframe.top3Part =
		// myframe.top3Part.cloneProfile(opening.top3Part);
		// myframe.bot1Part =
		// myframe.bot1Part.cloneProfile(opening.bot1Part);
		// myframe.bot2Part =
		// myframe.bot2Part.cloneProfile(opening.bot2Part);
		// myframe.bot3Part =
		// myframe.bot3Part.cloneProfile(opening.bot3Part);
		// myframe.leftPart =
		// myframe.leftPart.cloneProfile(opening.leftPart);
		// myframe.rightPart =
		// myframe.rightPart.cloneProfile(opening.rightPart);

		object.top1Part = (Profiles) object.top1Part
				.cloneProfile(opening.top1Part);
		object.top2Part = (Profiles) object.top2Part
				.cloneProfile(opening.top2Part);
		object.top3Part = (Profiles) object.top3Part
				.cloneProfile(opening.top3Part);
		object.rightPart = (Profiles) object.rightPart
				.cloneProfile(opening.rightPart);
		object.leftPart = (Profiles) object.leftPart
				.cloneProfile(opening.leftPart);
		object.bot1Part = (Profiles) object.bot1Part
				.cloneProfile(opening.bot1Part);
		object.bot2Part = (Profiles) object.bot2Part
				.cloneProfile(opening.bot2Part);
		object.bot3Part = (Profiles) object.bot3Part
				.cloneProfile(opening.bot3Part);

		return object;
	}

}

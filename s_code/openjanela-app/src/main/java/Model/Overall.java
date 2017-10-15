/**
 * Copyright (c) 2009, OpenJanela. All rights reserved.
 * User: Sherif El Dibani
 */
package Model;

import java.awt.geom.GeneralPath;
import java.util.*;

import Presentation.ForcedOptionAnswer;
import dto.DTOTransformationError;
import dto.DesignOptionDTO;
import dto.ShapeObjectBeanUtils;
import openjanela.model.entities.design.*;
import openjanela.model.entities.partner.Rules;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;

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
import dto.ShapeObjectDTO;

/**
 * This class represent an overall design object for doors and windows design
 */
public class Overall extends ShapeObject implements Cloneable {

	// Apache log4j
	private static final Logger logger = Logger.getLogger(Overall.class);

	public Collection facets = new ArrayList();

	/**
	 * Overall Constructor
	 */
	public Overall() {

		// *******************************************
		// Initialize basic variables
		// *******************************************
		this.a_levelID = 0;
		this.shapeID = 1;
		this.a_assemblyLevel = 1;
	}

	/**
	 * Overall Constructor
	 * 
	 * @param myframe
	 *            , ItemFrame
	 * @param jobItem
	 *            , JobItemModel
	 * @param shapeID
	 *            , Shape Identification
	 * @param recordID
	 *            , Record Identification
	 * @param parentItem
	 *            , int
	 */
	public Overall(ItemFrame myframe, JobItemModel jobItem, int shapeID,
			int recordID, int parentItem) {

		// Call former constructor
		this();

		// Setting ItemFrame and JobItem model
		myFrame2 = myframe;
		myFrame2.jobItem = jobItem;

		// Setting starting point for X & Y
		this.shapeID = shapeID;
		this.rID = recordID;
		this.startingX = myFrame2.jobItem.startingX;
		this.startingY = myFrame2.jobItem.startingY;

		// Setting scale metric
		this.scaleM = myFrame2.scale;
	}

	/**
	 * Overall constructor opening OverallEntityObject model
	 * 
	 * @param frame
	 *            , ItemFrame
	 * @param jobItem
	 *            , JobItemModel
	 * @param overallEntityObject
	 *            , OverallEntityObject
	 * @param shapeId
	 *            , int
	 * @param recordId
	 *            , int
	 * @param parentItem
	 *            , int
	 */
	public Overall(ItemFrame frame, JobItemModel jobItem,
			OverallEntityObject overallEntityObject, int shapeId, int recordId,
			int parentItem) {

		// Call main constructor
		this();

		// Setting ItemFrame and JobItem model
		this.myFrame2 = frame;
		this.myFrame2.jobItem = jobItem;

		// Setting starting point for X & Y
		this.shapeID = shapeId;
		this.rID = recordId;
		this.startingX = myFrame2.jobItem.startingX;
		this.startingY = myFrame2.jobItem.startingY;

		// *******************************************
		// Open object model
		// *******************************************
		openObjectModel(overallEntityObject);
	}

	public void verifyStartData() {

		if (shapeID == 300
				&& dimB1 == myFrame2.jobItem.design_flat_WIDTHpix / 2) {
			shapeID = 200;
		} else if (shapeID == 301
				&& dimD2 == myFrame2.jobItem.design_flat_WIDTHpix) {
			shapeID = 201;
		} else if (shapeID == 302
				&& dimB1 == myFrame2.jobItem.design_flat_WIDTHpix) {
			shapeID = 202;
		} else if (shapeID == 450) {
			dimD2 = Math.sqrt(Math
					.pow(myFrame2.jobItem.design_flat_WIDTHpix, 2)
					- Math.pow((myFrame2.jobItem.design_flat_WIDTHpix / 2), 2));
			dimA1 = myFrame2.jobItem.design_flat_WIDTHpix / 2;
			dimA2 = dimA1;
			dimB1 = dimD2;
		} else if (shapeID == 453) {
			dimD2 = Math.sqrt(Math
					.pow(myFrame2.jobItem.design_flat_WIDTHpix, 2)
					- Math.pow((myFrame2.jobItem.design_flat_WIDTHpix / 2), 2));
			myFrame2.jobItem.design_flat_WIDTHpix = myFrame2.jobItem._HEIGHTpix;
			dimA1 = myFrame2.jobItem.design_flat_WIDTHpix / 2;
			dimA2 = dimA1;
		} else if (shapeID == 700) {
			dimA1 = myFrame2.jobItem.design_flat_WIDTHpix;
			dimD2 = myFrame2.jobItem._HEIGHTpix;
			lean4 = 1;
		} else if (shapeID == 701) {
			dimA2 = myFrame2.jobItem.design_flat_WIDTHpix;
			dimB1 = myFrame2.jobItem._HEIGHTpix;
			lean2 = 2;
		} else if (shapeID == 702) {
			lean4 = 3;
		} else if (shapeID == 703) {
			lean2 = 3;
		} else if (shapeID == 704) {
			dimD2 = myFrame2.jobItem._HEIGHTpix;
			dimB1 = myFrame2.jobItem._HEIGHTpix;
			lean = 3;
			lean2 = 2;
			lean3 = 0;
			lean4 = 1;
		} else if (shapeID == 705) {
			lean4 = 2;
			dimD1 = myFrame2.jobItem._HEIGHTpix;
		} else if (shapeID == 706) {
			lean2 = 1;
			dimB2 = myFrame2.jobItem._HEIGHTpix;
		}
	}

	@Override
	public void setMargins() {
		startingX = myFrame2.jobItem.startingX;
		startingY = myFrame2.jobItem.startingY;
	}

	@Override
	public void setInitDimABCD(final double a1, final double a2,
			final double a3, final double a4, final double a5, final double a0,
			final double b1, final double b2, final double b3, final double b4,
			final double b5, final double b0, final double c1, final double c2,
			final double c3, final double c4, final double c5, final double c0,
			final double d1, final double d2, final double d3, final double d4,
			final double d5, final double d0) {

		dimA1 = a1;
		dimA2 = a2;
		dimA3 = a3;
		dimA4 = a4;
		dimA5 = a5;
		dimA0 = a0;
		dimB1 = b1;
		dimB2 = b2;
		dimB3 = b3;
		dimB4 = b4;
		dimB5 = b5;
		dimB0 = b0;
		dimC1 = c1;
		dimC2 = c2;
		dimC3 = c3;
		dimC4 = c4;
		dimC5 = c5;
		dimC0 = c0;
		dimD1 = d1;
		dimD2 = d2;
		dimD3 = d3;
		dimD4 = d4;
		dimD5 = d5;
		dimD0 = d0;
	}

	@Override
	public void setDimABCDFromShapeChange(final double a1, final double a2,
			final double a3, final double a4, final double a5, final double a0,
			final double b1, final double b2, final double b3, final double b4,
			final double b5, final double b0, final double c1, final double c2,
			final double c3, final double c4, final double c5, final double c0,
			final double d1, final double d2, final double d3, final double d4,
			final double d5, final double d0) {

		dimA1 = a1;
		dimA2 = a2;
		dimA3 = a3;
		dimA4 = a4;
		dimA5 = a5;
		dimA0 = a0;
		dimB1 = b1;
		dimB2 = b2;
		dimB3 = b3;
		dimB4 = b4;
		dimB5 = b5;
		dimB0 = b0;
		dimC1 = c1;
		dimC2 = c2;
		dimC3 = c3;
		dimC4 = c4;
		dimC5 = c5;
		dimC0 = c0;
		dimD1 = d1;
		dimD2 = d2;
		dimD3 = d3;
		dimD4 = d4;
		dimD5 = d5;
		dimD0 = d0;

		bOpeningObject.dimA1 = a1;
		bOpeningObject.dimA2 = a2;
		bOpeningObject.dimA3 = a3;
		bOpeningObject.dimA4 = a4;
		bOpeningObject.dimA5 = a5;
		bOpeningObject.dimA0 = a0;
		bOpeningObject.dimB1 = b1;
		bOpeningObject.dimB2 = b2;
		bOpeningObject.dimB3 = b3;
		bOpeningObject.dimB4 = b4;
		bOpeningObject.dimB5 = b5;
		bOpeningObject.dimB0 = b0;
		bOpeningObject.dimC1 = c1;
		bOpeningObject.dimC2 = c2;
		bOpeningObject.dimC3 = c3;
		bOpeningObject.dimC4 = c4;
		bOpeningObject.dimC5 = c5;
		bOpeningObject.dimC0 = c0;
		bOpeningObject.dimD1 = d1;
		bOpeningObject.dimD2 = d2;
		bOpeningObject.dimD3 = d3;
		bOpeningObject.dimD4 = d4;
		bOpeningObject.dimD5 = d5;
		bOpeningObject.dimD0 = d0;
	}

	public void setShape(final int shape) {
		shapeID = shape;
	}

	public Overall cloneOA(final Overall original) {

		final Overall newOV = cloneOAShape(original);

		// Extend Specific Attributes Here

		newOV.scaleM = original.scaleM;
		newOV.frameShapeChanged = original.frameShapeChanged;

		return newOV;

	}

	//
	public Overall cloneOAShape(final Overall original) {

		Overall newOV = new Overall();

		// Setting level ID Compound

		newOV.myFrame2 = original.myFrame2;
		newOV.myParent = original.myParent;
		newOV.myParentO = original.myParentO;
		newOV.shapeID = original.shapeID;
		newOV.rID = original.rID;
		newOV.parentid = original.parentid;

		newOV.startCol = original.startCol;
		newOV.startRow = original.startRow;

		newOV.endCol = original.endCol;
		newOV.endRow = original.endRow;

		newOV.a_levelID = original.a_levelID;
		newOV.a_sequenceID = original.a_sequenceID;

		// Setting starting point for X & Y

		newOV.a_1Level = original.a_1Level;
		newOV.a_1Sequence = original.a_1Sequence;
		newOV.a_2Level = original.a_2Level;
		newOV.a_2Sequence = original.a_2Sequence;
		newOV.a_3Level = original.a_3Level;
		newOV.a_3Sequence = original.a_3Sequence;
		newOV.a_4Level = original.a_4Level;
		newOV.a_4Sequence = original.a_4Sequence;
		newOV.a_5Level = original.a_5Level;
		newOV.a_5Sequence = original.a_5Sequence;
		newOV.a_6Level = original.a_6Level;
		newOV.a_6Sequence = original.a_6Sequence;
		newOV.a_7Level = original.a_7Level;
		newOV.a_7Sequence = original.a_7Sequence;
		newOV.a_8Level = original.a_8Level;
		newOV.a_8Sequence = original.a_8Sequence;
		newOV.a_9Level = original.a_9Level;
		newOV.a_9Sequence = original.a_9Sequence;
		newOV.a_10Level = original.a_10Level;
		newOV.a_10Sequence = original.a_10Sequence;

		newOV.a_11Level = original.a_11Level;
		newOV.a_11Sequence = original.a_11Sequence;
		newOV.a_12Level = original.a_12Level;
		newOV.a_12Sequence = original.a_12Sequence;
		newOV.a_13Level = original.a_13Level;
		newOV.a_13Sequence = original.a_13Sequence;
		newOV.a_14Level = original.a_14Level;
		newOV.a_14Sequence = original.a_14Sequence;
		newOV.a_15Level = original.a_15Level;
		newOV.a_15Sequence = original.a_15Sequence;
		newOV.a_16Level = original.a_16Level;
		newOV.a_16Sequence = original.a_16Sequence;
		newOV.a_17Level = original.a_17Level;
		newOV.a_17Sequence = original.a_17Sequence;
		newOV.a_18Level = original.a_18Level;
		newOV.a_18Sequence = original.a_18Sequence;
		newOV.a_19Level = original.a_19Level;
		newOV.a_19Sequence = original.a_19Sequence;
		newOV.a_20Level = original.a_20Level;
		newOV.a_20Sequence = original.a_20Sequence;
		newOV.a_21Level = original.a_21Level;
		newOV.a_21Sequence = original.a_21Sequence;
		newOV.a_22Level = original.a_22Level;
		newOV.a_22Sequence = original.a_22Sequence;

		// Setting frame execution parent

		// Setting values coordinates
		newOV.widthPix = original.widthPix;
		newOV.heightPix = original.heightPix;
		newOV.highestX = original.highestX;
		newOV.lowestX = original.lowestX;
		newOV.highestY = original.highestY;
		newOV.lowestY = original.lowestY;
		newOV.highestYC = original.highestYC;
		newOV.lowestYC = original.lowestYC;
		newOV.isStdW = original.isStdW;
		newOV.isStdH = original.isStdH;
		newOV.stdWM = original.stdWM;
		newOV.stdWI = original.stdWI;
		newOV.stdHM = original.stdHM;
		newOV.stdHI = original.stdHI;

		// Cloning removed parts
		newOV.removedParts = this.cloneCollections(original.removedParts);

		// Number parts object
		newOV.noPartsTop1 = original.noPartsTop1;
		newOV.noPartsTop2 = original.noPartsTop2;
		newOV.noPartsTop3 = original.noPartsTop3;
		newOV.noPartsBot1 = original.noPartsBot1;
		newOV.noPartsBot2 = original.noPartsBot2;
		newOV.noPartsBot3 = original.noPartsBot3;
		newOV.noPartsLeft = original.noPartsLeft;
		newOV.noPartsRight = original.noPartsRight;

		newOV.isNewFrame = original.isNewFrame;

		// Cloning openings objects

		// Cloning openings
		if (original.openings != null) {
			Collection newc = new ArrayList();
			Object[] rmp = original.openings.toArray();
			for (Object v : rmp) {
				newc.add(((OpeningObject) v).cloneOpening((OpeningObject) v));
			}
			newOV.openings = newc;
		}

		// Clone background openings
		if (original.bOpeningObjectIn != null) {
			newOV.bOpeningObjectIn = original.bOpeningObjectIn
					.cloneBkgrdOpening(original.bOpeningObjectIn);
		}
		if (original.bOpeningObject != null) {
			newOV.bOpeningObject = original.bOpeningObject
					.cloneBkgrdOpening(original.bOpeningObject);
		}
		if (original.bOpeningObjectOut != null) {
			newOV.bOpeningObjectOut = original.bOpeningObjectOut
					.cloneBkgrdOpening(original.bOpeningObjectOut);
		}

		newOV.newRowH = original.newRowH;

		// Cloning frames
		if (original.frames != null) {
			Collection newc = new ArrayList();
			Object[] rmp = original.frames.toArray();
			for (final Object v : rmp) {
				newc.add(((Facet) v).cloneFacet(((Facet) v)));
			}
			newOV.frames = newc;
		}

		newOV.newDesign = original.newDesign;

		newOV.frameStartCol = original.frameStartCol;
		newOV.frameStartRow = original.frameStartRow;
		newOV.frameEndCol = original.frameEndCol;
		newOV.frameEndRow = original.frameEndRow;
		newOV.myRow = original.myRow;
		newOV.myCol = original.myCol;
		newOV.myShapeID = original.myShapeID;
		newOV.myPrevShape = original.myPrevShape;
		newOV.myNewShape = original.myNewShape;
		newOV.myOpeningID = original.myOpeningID;
		newOV.mynewOpeningID = original.mynewOpeningID;
		newOV.mynewOpenindType = original.mynewOpenindType;
		newOV.newWidthTop = original.newWidthTop;
		newOV.newWidthBot = original.newWidthBot;
		newOV.newStartingY = original.newStartingY;
		newOV.newStartingX = original.newStartingX;
		newOV.newHL = original.newHL;
		newOV.newHR = original.newHR;
		newOV.newstartX = original.newstartX;
		newOV.newendX = original.newendX;
		newOV.newstartY = original.newstartY;
		newOV.newendY = original.newendY;

		newOV.newDimD2 = original.newDimD2;
		newOV.newDimB1 = original.newDimB1;

		newOV.rowColToAdd = original.rowColToAdd;
		newOV.addRow = original.addRow;

		newOV.dividedCentral = original.dividedCentral;
		newOV.myCouplerThickness = original.myCouplerThickness;

		// newOV.ellipses = original.ellipses;
		newOV.setLeanTo = original.setLeanTo;

		newOV.minLeg = original.minLeg;
		newOV.wireFrame = original.wireFrame;

		newOV.parentStartRow = original.parentStartRow;
		newOV.parentStartCol = newOV.parentStartCol;

		newOV.startingXBA = original.startingXBA;
		newOV.startingYBA = original.startingYBA;

		newOV.startingXA = original.startingXA;
		newOV.startingYA = original.startingYA;
		newOV.bX2A = original.bX2A;
		newOV.bY2A = original.bY2A;
		newOV.bX3A = original.bX3A;
		newOV.bY3A = original.bX3A;

		newOV.bX4A = original.bX4A;
		newOV.bY4A = original.bY4A;
		newOV.bX2B = original.bX2B;
		newOV.bY2B = original.bY2B;
		newOV.bX3B = original.bX3B;
		newOV.bY3B = original.bY3B;
		newOV.bX4B = original.bX4B;
		newOV.bY4B = original.bY4B;
		newOV.openingW = original.openingW;
		newOV.openingH = original.openingH;
		newOV.openingWc = original.openingWc;
		newOV.openingHc = original.openingHc;
		newOV.openingWB = original.openingWB;
		newOV.openingHR = original.openingHR;
		newOV.openingWcB = original.openingWcB;
		newOV.openingHcR = original.openingHcR;
		newOV.openingWA = original.openingWA;
		newOV.openingHA = original.openingHA;
		newOV.openingWBA = original.openingWBA;
		newOV.openingHRA = original.openingHRA;
		newOV.dimTM = original.dimTM;
		newOV.dimBM = original.dimBM;
		newOV.dimLM = original.dimLM;
		newOV.dimRM = original.dimRM;
		newOV.dimTA = original.dimTA;
		newOV.dimBA = original.dimBA;
		newOV.dimLA = original.dimLA;
		newOV.dimRA = original.dimRA;
		newOV.a_sequenceID = original.a_sequenceID;
		newOV.lastSeq = original.lastSeq;
		newOV.xCols = original.xCols;
		newOV.yRows = original.yRows;
		newOV.noTracks = original.noTracks;
		newOV.openOut = original.openOut;
		newOV.glazedOut = original.glazedOut;
		newOV.radius1A = original.radius1A;
		newOV.radius2A = original.radius2A;
		newOV.startAngleA = original.startAngleA;
		newOV.endAngleA = original.endAngleA;
		newOV.bkgrdStartXA = original.bkgrdStartXA;
		newOV.bkgrdStartYA = original.bkgrdStartYA;
		newOV.centralAngleA = original.centralAngleA;
		newOV.px1 = original.px1;
		newOV.py1 = original.py1;
		newOV.px2 = original.px2;
		newOV.py2 = original.py2;
		newOV.px3 = original.px3;
		newOV.py3 = original.py3;
		newOV.px4 = original.px4;
		newOV.py4 = original.py4;
		newOV.px5 = original.px5;
		newOV.py5 = original.py5;
		newOV.px6 = original.px6;
		newOV.py6 = original.py6;
		newOV.px7 = original.px7;
		newOV.py7 = original.py7;
		newOV.px8 = original.px8;
		newOV.py8 = original.py8;
		newOV.px1A = original.px1A;
		newOV.py1A = original.py1A;
		newOV.px2A = original.px2A;
		newOV.py2A = original.py2A;
		newOV.px3A = original.px3A;
		newOV.py3A = original.py3A;
		newOV.px4A = original.px4A;
		newOV.py4A = original.py4A;
		newOV.px5A = original.px5A;
		newOV.py5A = original.py5A;
		newOV.px6A = original.px6A;
		newOV.py6A = original.py6A;
		newOV.px7A = original.px7A;
		newOV.py7A = original.py7A;
		newOV.px8A = original.px8A;
		newOV.py8A = original.py8A;
		newOV.px1c = original.px1c;
		newOV.py1c = original.py1c;
		newOV.px2c = original.px2c;
		newOV.py2c = original.py2c;
		newOV.px3c = original.px3c;
		newOV.py3c = original.py3c;
		newOV.px4c = original.px4c;
		newOV.py4c = original.py4c;
		newOV.px5c = original.px5c;
		newOV.py5c = original.py5c;
		newOV.px6c = original.px6c;
		newOV.py6c = original.py6c;
		newOV.px7c = original.px7c;
		newOV.py7c = original.py7c;
		newOV.px8c = original.px8c;
		newOV.py8c = original.py8c;

		newOV.hasSash = original.hasSash;
		newOV.unGlazed = original.unGlazed;
		newOV.openingClass = original.openingClass;
		newOV.userDefinedOpeningID = original.userDefinedOpeningID;
		newOV.outSash = original.outSash;
		newOV.inSash = original.inSash;
		newOV.midSash = original.midSash;
		newOV.myGlass = original.myGlass;
		newOV.outSashTracks = original.outSashTracks;
		newOV.inSashTracks = original.inSashTracks;
		newOV.midSashTracks = original.midSashTracks;

		newOV.id = original.id;

		newOV.a_levelID = original.a_levelID;

		newOV.openIn = original.openIn;
		newOV.lean = original.lean;
		newOV.lean2 = original.lean2;
		newOV.lean3 = original.lean3;
		newOV.lean4 = original.lean4;
		newOV.noSides = original.noSides;
		newOV.noSidesTop = original.noSidesTop;
		newOV.noSidesBot = original.noSidesBot;
		newOV.noSidesLeft = original.noSidesLeft;
		newOV.noSidesRight = original.noSidesRight;
		newOV.startingX = original.startingX;
		newOV.startingY = original.startingY;
		newOV.bX2 = original.bX2;
		newOV.bY2 = original.bY2;
		newOV.bX3 = original.bX3;
		newOV.bY3 = original.bY3;
		newOV.bX4 = original.bX4;
		newOV.bY4 = original.bY4;
		newOV.startingCX = original.startingCX;
		newOV.startingCY = original.startingCY;
		newOV.bCX2 = original.bCX2;
		newOV.bCY2 = original.bCY2;
		newOV.bCX3 = original.bCX3;
		newOV.bCY3 = original.bCY3;
		newOV.bCX4 = original.bCX4;
		newOV.bCY4 = original.bCY4;
		newOV.topShape = original.topShape;
		newOV.rightShape = original.rightShape;
		newOV.botShape = original.botShape;
		newOV.leftShape = original.leftShape;
		newOV.levelW = original.levelW;
		newOV.levelH = original.levelH;
		newOV.dimA1 = original.dimA1;
		newOV.dimA2 = original.dimA2;
		newOV.dimA3 = original.dimA3;
		newOV.dimA4 = original.dimA4;
		newOV.dimA5 = original.dimA5;
		newOV.dimA0 = original.dimA0;
		newOV.dimB1 = original.dimB1;
		newOV.dimB2 = original.dimB2;
		newOV.dimB3 = original.dimB3;
		newOV.dimB4 = original.dimB4;
		newOV.dimB5 = original.dimB5;
		newOV.dimB0 = original.dimB0;
		newOV.dimC1 = original.dimC1;
		newOV.dimC2 = original.dimC2;
		newOV.dimC3 = original.dimC3;
		newOV.dimC4 = original.dimC4;
		newOV.dimC5 = original.dimC5;
		newOV.dimC0 = original.dimC0;
		newOV.dimD1 = original.dimD1;
		newOV.dimD2 = original.dimD2;
		newOV.dimD3 = original.dimD3;
		newOV.dimD4 = original.dimD4;
		newOV.dimD5 = original.dimD5;
		newOV.dimD0 = original.dimD0;
		newOV.pA1 = original.pA1;
		newOV.pA2 = original.pA2;
		newOV.pA3 = original.pA3;
		newOV.pA4 = original.pA4;
		newOV.pA5 = original.pA5;
		newOV.pA0 = original.pA0;
		newOV.pB1 = original.pB1;
		newOV.pB2 = original.pB2;
		newOV.pB3 = original.pB3;
		newOV.pB4 = original.pB4;
		newOV.pB5 = original.pB5;
		newOV.pB0 = original.pB0;
		newOV.pC1 = original.pC1;
		newOV.pC2 = original.pC2;
		newOV.pC3 = original.pC3;
		newOV.pC4 = original.pC4;
		newOV.pC5 = original.pC5;
		newOV.pC0 = original.pC0;
		newOV.pD1 = original.pD1;
		newOV.pD2 = original.pD2;
		newOV.pD3 = original.pD3;
		newOV.pD4 = original.pD4;
		newOV.pD5 = original.pD5;
		newOV.pD0 = original.pD0;

		newOV.wire = original.wire;

		newOV.centerPointX = original.centerPointX;
		newOV.centerPointY = original.centerPointY;
		newOV.centerPointX2 = original.centerPointX2;
		newOV.centerPointY2 = original.centerPointY2;

		newOV.radius1 = original.radius1;
		newOV.radius2 = original.radius2;

		newOV.startAngle = original.startAngle;
		newOV.endAngle = original.endAngle;

		newOV.bkgrdStartX = original.bkgrdStartX;
		newOV.bkgrdStartY = original.bkgrdStartY;

		newOV.centralAngle = original.centralAngle;

		newOV.startCol = original.startCol;
		newOV.endCol = original.endCol;
		newOV.startRow = original.startRow;
		newOV.endRow = original.endRow;

		newOV.parentW = original.parentW;
		newOV.parentH = original.parentH;
		newOV.parentStartY = original.parentStartY;
		newOV.parentStartX = original.parentStartX;
		newOV.parentRadius1 = original.parentRadius1;

		newOV.myX = original.myX;
		newOV.myY = original.myY;
		newOV.topIn = original.topIn;
		newOV.rightIn = original.rightIn;
		newOV.botIn = original.botIn;
		newOV.leftIn = original.leftIn;

		newOV.deltaA1 = original.deltaA1;
		newOV.deltaC2 = original.deltaC2;
		newOV.deltaD1 = original.deltaD1;

		newOV.shapeChanged = original.shapeChanged;
		newOV.arcType = original.arcType;

		newOV.parentCY = original.parentCY;
		newOV.parentCX2 = original.parentCX2;
		newOV.parentCY2 = original.parentCY2;
		newOV.parentShape = original.parentShape;
		newOV.newPart = original.newPart;

		newOV.clearanceTop = original.clearanceTop;
		newOV.clearanceBot = original.clearanceBot;
		newOV.clearanceLeft = original.clearanceLeft;
		newOV.clearanceRight = original.clearanceRight;

		newOV.topObjectPath = (GeneralPath) original.topObjectPath.clone();

		newOV.top1 = (Top1Object) newOV.top1.cloneProfile(original.top1);
		newOV.top2 = (Top2Object) newOV.top2.cloneProfile(original.top2);
		newOV.top3 = (Top3Object) newOV.top3.cloneProfile(original.top3);
		newOV.right = (RightObject) newOV.right.cloneProfile(original.right);
		newOV.left = (LeftObject) newOV.left.cloneProfile(original.left);
		newOV.bot1 = (Bot1Object) newOV.bot1.cloneProfile(original.bot1);
		newOV.bot2 = (Bot2Object) newOV.bot2.cloneProfile(original.bot2);
		newOV.bot3 = (Bot3Object) newOV.bot3.cloneProfile(original.bot3);

		newOV.top1Part = (Profiles) newOV.top1Part
				.cloneProfile(original.top1Part);
		newOV.top2Part = (Profiles) newOV.top2Part
				.cloneProfile(original.top2Part);
		newOV.top3Part = (Profiles) newOV.top3Part
				.cloneProfile(original.top3Part);
		newOV.rightPart = (Profiles) newOV.rightPart
				.cloneProfile(original.rightPart);
		newOV.leftPart = (Profiles) newOV.leftPart
				.cloneProfile(original.leftPart);
		newOV.bot1Part = (Profiles) newOV.bot1Part
				.cloneProfile(original.bot1Part);
		newOV.bot2Part = (Profiles) newOV.bot2Part
				.cloneProfile(original.bot2Part);
		newOV.bot3Part = (Profiles) newOV.bot3Part
				.cloneProfile(original.bot3Part);

		newOV.partObjects = this.cloneCollections(original.partObjects);

		newOV.gp = (GeneralPath) original.gp.clone();

		if (original.options != null) {
			Collection newc = new ArrayList();
			Object[] rmp = original.options.toArray();
			for (final Object v : rmp) {
				newc.add(((ShapeOption) v).clone(((ShapeOption) v)));
			}
			this.options = newc;
		}

		return newOV;
	}

	/**
	 * Open object model from DB
	 * 
	 * @param overallEntity
	 *            , OverallEntityObject
	 */
	private void openObjectModel(OverallEntityObject overallEntity) {

		// shapeObject Model transformation from OverallEntityObject to
		// ShapeObject
		ShapeObjectDTO.getShapeObjectModel(overallEntity, this, Overall.class);

		// *****************************************************
		// 1. Creating background opening
		// *****************************************************
		if (overallEntity.getBkgrdOpeningEntityObject() != null) {
			this.bOpeningObject = new BkgrdOpeningObject(this, myFrame2,
					overallEntity.getBkgrdOpeningEntityObject());

			// Do mullions object
			this.doMullions(this.bOpeningObject);
		}

		// ****************************************************
		// 2. Creating openings entity objects
		// ****************************************************
		if (overallEntity.getOpenings() != null
				&& !overallEntity.getOpenings().isEmpty()) {
			this.openings = new ArrayList();
			for (OpeningEntityObject opening : overallEntity.getOpenings()) {
				openings.add(new OpeningObject(this, this.myFrame2, opening));
			}
		}

		// ************************************************
		// 3. Creating facets entity objects
		// ************************************************
		if (overallEntity.getFacets() != null
				&& !overallEntity.getFacets().isEmpty()) {
			this.frames = new ArrayList();
			for (FacetEntityObject facet : overallEntity.getFacets()) {
				this.frames.add(new Facet(this.myFrame2, this.myFrame2.jobItem,
						facet, this));
			}
		}

		// ************************************************
		// 4. Creating Forced options answers
		// ************************************************
		if (overallEntity.getOptionsAnswers() != null
				&& !overallEntity.getOptionsAnswers().isEmpty()) {
			this.myFrame2.alreadyAnsweredOptions = new ArrayList();
			for (ForcedOptionAnswerEntityObject optionAnswer : overallEntity
					.getOptionsAnswers()) {
				ForcedOptionAnswer forcedOptionAnswer = new ForcedOptionAnswer();
				forcedOptionAnswer.optionID = optionAnswer.getOptionId();
				forcedOptionAnswer.answerID = optionAnswer.getAnswerId();

				this.myFrame2.alreadyAnsweredOptions.add(forcedOptionAnswer);
			}
		}
	}

	/**
	 * Create object model design
	 * 
	 * @return OverallEntityObject
	 */
	public OverallEntityObject createObjectModel() {

		// Creating Overall object to save
		OverallEntityObject overallEntity = (OverallEntityObject) ShapeObjectDTO
				.getShapeAbstractObject(this, OverallEntityObject.class);

		// ************************************************
		// 1. Creating background opening
		// ************************************************
		overallEntity.setBkgrdOpeningEntityObject(this.bOpeningObject
				.createBkgrdEntityObject());

		// ************************************************
		// 2. Creating openings entity objects
		// ************************************************
		if (this.openings != null) {
			Set<OpeningEntityObject> openings = new HashSet<OpeningEntityObject>();
			Object[] rmp = this.openings.toArray();
			for (Object v : rmp) {
				openings.add(((OpeningObject) v).createOpeningEntityObject(
						null, null, null, null));
			}
			overallEntity.setOpenings(openings);
		}

		// ************************************************
		// 3. Creating facets entity objects
		// ************************************************
		if (!this.frames.isEmpty()) {
			Set<FacetEntityObject> facets = new HashSet<FacetEntityObject>();
			Object[] rmp = this.frames.toArray();
			for (Object v : rmp) {
				Facet facet = (Facet) v;
				facets.add(facet.createFacetEntityObject(overallEntity));
			}
			overallEntity.setFacets(facets);
		}

		// ************************************************
		// 4. Creating Forced options answers
		// ************************************************
		if (!this.myFrame2.alreadyAnsweredOptions.isEmpty()) {
			Set<ForcedOptionAnswerEntityObject> forcedAnswers = new HashSet<ForcedOptionAnswerEntityObject>();
			Object[] rmp = this.myFrame2.alreadyAnsweredOptions.toArray();
			for (Object v : rmp) {
				ForcedOptionAnswer forced = (ForcedOptionAnswer) v;
				ForcedOptionAnswerEntityObject optionAnswer = new ForcedOptionAnswerEntityObject();
				optionAnswer.setOptionId(forced.optionID);
				optionAnswer.setAnswerId(forced.answerID);

				forcedAnswers.add(optionAnswer);
			}
			overallEntity.setOptionsAnswers(forcedAnswers);
		}

		return overallEntity;
	}

	/**
	 * Reset Glass Bom Collection for Design
	 * 
	 * @throws Exception
	 *             , Exception
	 */
	public void resetGlassBom() throws Exception {

		// ********************************************************************
		// Clear summarized glass boms
		// ********************************************************************
		this.myFrame2.jobItem.glassBOM.clear();

		// ********************************************************************
		// Reset Glass Bom for Openings
		// ********************************************************************
		if (!this.openings.isEmpty()) {
			for (Object v : this.openings) {
				((OpeningObject) v).resetGlassBom();
			}
		}

		// ********************************************************************
		// Reset Glass Bom for Frames
		// ********************************************************************
		if (!this.frames.isEmpty()) {
			for (Object v : this.frames) {
				((Facet) v).resetGlassBom();
			}
		}
	}

	/**
	 * Reset Grids Bom Collection for Design
	 * 
	 * @throws Exception
	 *             , Exception
	 */
	public void resetGridsBom() throws Exception {

		// ********************************************************************
		// Clear summarized grids boms
		// ********************************************************************
		this.myFrame2.jobItem.gridsBOM.clear();

		// ********************************************************************
		// Reset Grids Bom for Openings
		// ********************************************************************
		if (!this.openings.isEmpty()) {
			for (Object v : this.openings) {
				((OpeningObject) v).resetGridsBom();
			}
		}

		// ********************************************************************
		// Reset Grids Bom for Frames
		// ********************************************************************
		if (!this.frames.isEmpty()) {
			for (Object v : this.frames) {
				((Facet) v).resetGridsBom();
			}
		}
	}

	/**
	 * This method return a Glass SU from his child Design Glass BOM
	 * 
	 * @param designGlass
	 *            , DesignGlass
	 * @return ShapeObject
	 * @throws Exception
	 *             , Exception
	 */
	public GlassSU getGlassSU(DesignGlass designGlass) throws Exception {

		GlassSU glassSU = null;

		// ********************************************************************
		// Reset Glass Bom for Openings
		// ********************************************************************
		if (!this.openings.isEmpty()) {
			for (Object v : this.openings) {
				GlassSU glass = ((OpeningObject) v).getGlassSU(designGlass);
				if (glass != null) {
					glassSU = glass;
				}
			}
		}

		// ********************************************************************
		// Reset Glass Bom for Frames
		// ********************************************************************
		if (!this.frames.isEmpty()) {
			for (Object v : this.frames) {
				GlassSU glass = ((Facet) v).getGlassSU(designGlass);
				if (glass != null) {
					glassSU = glass;
				}
			}
		}

		return glassSU;
	}

	/**
	 * Reset Shape Notes Collection for Design
	 * 
	 * @throws Exception
	 *             , Exception
	 */
	public void resetShapeNotes() throws Exception {

		// Clear summarized shape notes
		this.myFrame2.jobItem.shapeNotes.clear();

		// Add ShapeObject notes to collection
		this.myFrame2.jobItem.shapeNotes.addAll(this.notes);

		// Reset Shape Notes Bkgrd Opening
		this.bOpeningObject.resetShapeNotes();

		// Reset Shape Notes for Openings
		if (!this.openings.isEmpty()) {
			for (Object v : this.openings) {
				((OpeningObject) v).resetShapeNotes();
			}
		}

		// Reset Shape Notes for facets
		if (!this.frames.isEmpty()) {
			for (Object v : this.frames) {
				((Facet) v).resetShapeNotes();
			}
		}
	}

	/**
	 * Reset Design Options All
	 * 
	 * @throws Exception
	 */
	public void resetOptionsAll() throws Exception {

	}

	@Override
	public Overall clone() {

		try {

			Overall newOverall = (Overall) super.clone();

			// Clone bkgrdOpening object
			if (newOverall.bOpeningObject != null) {
				BkgrdOpeningObject bkgrdOpening = bOpeningObject.clone();
				newOverall.bOpeningObject = bkgrdOpening;
			}

			// Clone openings object collection
			List _openings = new ArrayList();
			for (Object opening : newOverall.openings.toArray()) {
				OpeningObject op = ((OpeningObject) opening).clone();
				_openings.add(op);
			}

			Collections.sort(_openings, ShapeObjectComparator._SEQUENCE_ID);
			newOverall.openings = _openings;

			// Clone facets object collection
			List _facets = new ArrayList();
			for (Object facet : newOverall.frames.toArray()) {
				Facet f = ((Facet) facet).clone();
				f.myParent = newOverall;
				f.myOverall = newOverall;
				f.myParentO.myOverall = newOverall;

				_facets.add(f);
			}

			Collections.sort(_facets, ShapeObjectComparator._SEQUENCE_ID);
			newOverall.frames = _facets;

			return newOverall;

		} catch (DTOTransformationError e) {
			logger.error(e.getMessage(), e);
		} catch (CloneNotSupportedException e) {
			logger.error(e.getMessage(), e);
		}

		return null;
	}

	@Override
	public void isMatchingBOMRule(Rules rule, boolean doBOM) {

		// Execute Rule for Overall
		if (this.isMatchingRule(rule)) {
			executePartRules(rule, doBOM);
		}

		// ************************************************
		// 1. Creating background opening
		// ************************************************
		this.bOpeningObject.isMatchingBOMRule(rule, doBOM);

		// ************************************************
		// 2. Creating openings entity objects
		// ************************************************
		if (this.openings != null) {
			Object[] rmp = this.openings.toArray();
			for (Object v : rmp) {
				((OpeningObject) v).isMatchingBOMRule(rule, doBOM);
			}
		}

		// ************************************************
		// 3. Creating facets entity objects
		// ************************************************
		if (!this.frames.isEmpty()) {
			Object[] rmp = this.frames.toArray();
			for (Object v : rmp) {
				((Facet) v).isMatchingBOMRule(rule, doBOM);
			}
		}
	}

	@Override
	public void loadBOMParts() {

		// Load BOM Parts
		if (this.bom != null && this.bom.size() > 0) {
			this.myFrame2.jobItem.bom.addAll(this.bom);
		}

		// ************************************************
		// 1. Load BOM background opening
		// ************************************************
		this.bOpeningObject.loadBOMParts();

		// ************************************************
		// 2. Load BOM openings entity objects
		// ************************************************
		if (this.openings != null) {
			Object[] rmp = this.openings.toArray();
			for (Object v : rmp) {
				((OpeningObject) v).loadBOMParts();
			}
		}

		// ************************************************
		// 3. Load BOM facets entity objects
		// ************************************************
		if (!this.frames.isEmpty()) {
			Object[] rmp = this.frames.toArray();
			for (Object v : rmp) {
				((Facet) v).loadBOMParts();
			}
		}
	}

	@Override
	public void clearBOMParts() {

		// Clear BOM Parts
		if (this.bom != null && this.bom.size() > 0) {
			this.bom.clear();
            this.notes.clear();
		}

		// ************************************************
		// 1. Clear BOM background opening
		// ************************************************
		this.bOpeningObject.clearBOMParts();

		// ************************************************
		// 2. Clear BOM openings entity objects
		// ************************************************
		if (this.openings != null) {
			Object[] rmp = this.openings.toArray();
			for (Object v : rmp) {
				((OpeningObject) v).clearBOMParts();
			}
		}

		// ************************************************
		// 3. Load BOM facets entity objects
		// ************************************************
		if (!this.frames.isEmpty()) {
			Object[] rmp = this.frames.toArray();
			for (Object v : rmp) {
				((Facet) v).clearBOMParts();
			}
		}
	}

	@Override
	public void loadOptionsAll() {

		// Clear Design Options All
		this.myFrame2.designOptionsAll.clear();

		// Clear BOM Parts
		if (this.options != null && this.options.size() > 0) {
			for (ShapeOption shapeOption : this.options) {
				if (!shapeOption.global) {

					DesignOption designOption = new DesignOption();
					designOption = designOption.setDesignOptions(designOption,
							shapeOption);

					// Adding to Design Options All
					this.myFrame2.designOptionsAll.add(designOption);
				}
			}
		}

		// ************************************************
		// 1. Clear BOM background opening
		// ************************************************
		if (bOpeningObject != null) {
			this.bOpeningObject.loadOptionsAll();
		}
		// ************************************************
		// 2. Clear BOM openings entity objects
		// ************************************************
		if (this.openings != null) {
			Object[] rmp = this.openings.toArray();
			for (Object v : rmp) {
				((OpeningObject) v).loadOptionsAll();
			}
		}

		// ************************************************
		// 3. Load BOM facets entity objects
		// ************************************************
		if (!this.frames.isEmpty()) {
			Object[] rmp = this.frames.toArray();
			for (Object v : rmp) {
				((Facet) v).loadOptionsAll();
			}
		}

	}
}

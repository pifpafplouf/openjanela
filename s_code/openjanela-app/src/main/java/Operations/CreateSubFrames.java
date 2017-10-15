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

import Model.Frame;
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

public class CreateSubFrames {

	public OpeningObject myParentO;

	Collection xCoordB = new ArrayList();

	Collection yCoordB = new ArrayList();

	Object[] xCoordBo = null;

	Object[] yCoordBo = null;

	double myX = 0;

	double myY = 0;

	boolean openingChanged = false;

	double scale = 0;

	ItemFrame myFrame2;

	public Collection myExistingFrames = new ArrayList();

	public CreateSubFrames(final OpeningObject frame,
			final Collection existingFrames, final ItemFrame myframe) {

		myParentO = frame;
		myFrame2 = myframe;
		scale = myFrame2.scale.doubleValue();
		myExistingFrames = existingFrames;

	}

	public Frame doFrame(final int sashtype, final int sashid,
			final SashTypeObject newSashIn, final SashTypeObject newSashMid,
			final SashTypeObject newSashOut,
			// final SubFrameObject subFrame,
			final boolean glazedout, final boolean sameParts,
			final boolean recalcFrame) throws Exception {


		Frame myFrame= new Frame();
		
		setInitValues(sashtype, sashid, glazedout, myFrame);
		
		myFrame = this.initSashLeaf(myParentO.topIn, myParentO.botIn,
				myParentO.leftIn, myParentO.rightIn);
		/*
		 * Reset in case values changed due to Cloning of Parent Opening
		 */
		setInitValues(sashtype, sashid, glazedout, myFrame);

		if (!sameParts) {
			openingChanged = true;

		} else {
			myFrame.isNewFrame = false;
		}

		if (myFrame.topIn && myFrame.botIn && myFrame.leftIn) {
			myFrame.topIn = myFrame.topIn;
		}
		if (myFrame.topIn && !myFrame.botIn && myFrame.leftIn) {
			myFrame.topIn = myFrame.topIn;
		}

		CreateShapeMethods createShape = new CreateShapeMethods(myParentO, 2,
				myFrame2);

		this.initSashParts(myFrame);

		if (myExistingFrames != null && myExistingFrames.size() > 0) {

			for (final Object S : myExistingFrames.toArray()) {
				if (((Frame) S).a_sequenceID == myFrame.a_sequenceID) {

					if (myFrame.shapeID == ((Frame) S).shapeID
							&& !((Frame) S).shapeChanged
							&& !openingChanged
							&& myParentO.noSides == ((Frame) S).noSides
							&& myParentO.noSidesTop == ((Frame) S).noSidesTop
							&& myParentO.noSidesBot == ((Frame) S).noSidesBot
							&& myParentO.noSidesLeft == ((Frame) S).noSidesLeft
							&& myParentO.noSidesRight == ((Frame) S).noSidesRight) {

						myFrame.partObjects.addAll(((Frame) S).partObjects);

						this.initSashParts(myFrame);

						myFrame = this.copyParts(myFrame, ((Frame) S));

						myFrame.bOpeningObject = ((Frame) S).bOpeningObject
								.cloneBkgrdOpening(((Frame) S).bOpeningObject);

						myFrame.openings.addAll(((Frame) S).openings);

						myFrame.shapeChanged = ((Frame) S).shapeChanged;

						myFrame.xCols = ((Frame) S).xCols;
						myFrame.yRows = ((Frame) S).yRows;

						if (((Frame) S).shapeID != 1) {
							myFrame.shapeChanged = true;
						}

						myFrame.newPart = false;

					}
				} else {
					// initSashParts(myFrame);

				}
			}

		}

		final Object[] returns = this.setPartDims(myFrame, createShape);
		myFrame = (Frame) returns[0];
		createShape = (CreateShapeMethods) returns[1];

		if (!myParentO.top2Part.posInUse) {

			myFrame.top2Part = (Profiles) myFrame.top2Part
					.cloneProfile(myFrame.top1Part);
			myFrame.top2Part.posInUse = false;
			myFrame.top2Part.lengthM = 0;
			myFrame.top2Part.lengthI = 0;
			myFrame.top2 = (Top2Object) myFrame.top2
					.cloneProfile(myFrame.top2Part);

			myFrame.top2.posInUse = false;

		}

		createShape.getClearance(myFrame);

		myFrame = (Frame) createShape.doShapeBkgrd(myFrame);

		myFrame = (Frame) createShape.makeSides(myFrame);
		myFrame = (Frame) createShape.makeSidesStraight(myFrame);

		myFrame = (Frame) createShape.doParts(myFrame, true);

		myFrame = (Frame) createShape.setBaseInfo(myFrame, 1, true);

		myFrame.top1Part.myParent = myParentO.myParent;
		myFrame.top2Part.myParent = myParentO.myParent;
		myFrame.top3Part.myParent = myParentO.myParent;
		myFrame.bot1Part.myParent = myParentO.myParent;
		myFrame.bot2Part.myParent = myParentO.myParent;
		myFrame.bot3Part.myParent = myParentO.myParent;
		myFrame.leftPart.myParent = myParentO.myParent;
		myFrame.rightPart.myParent = myParentO.myParent;

		((ShapeObject) myFrame).setPartObjectsFromProfiles();

		myFrame.leftIn = myParentO.leftIn;
		myFrame.rightIn = myParentO.rightIn;
		myFrame.topIn = myParentO.topIn;
		myFrame.botIn = myParentO.botIn;

		myFrame.myParent = myParentO.myParent;
		myFrame.a_sequenceID = myParentO.a_sequenceID;

		myFrame.highestY = myParentO.highestY;
		myFrame.highestYC = myParentO.highestYC;

		myFrame.lowestY = myParentO.lowestY;
		myFrame.lowestYC = myParentO.lowestYC;

		myFrame.doMainOpening();

		myFrame.bOpeningObject.unGlazed = true;

		myFrame.bOpeningObject = myFrame.bOpeningObject
				.modifyVMCEqualize(myFrame.bOpeningObject);

		myFrame.bOpeningObject = myFrame.bOpeningObject
				.modifyHMCEqualize(myFrame.bOpeningObject);

		myFrame.doOpenings();

		// if (myFrame.bOpeningObject.mullions.size() > 0 ||
		// myFrame.bOpeningObject.mullionsH.size() > 0) {
		// myFrame.doOpenings();
		// }

		final Object[] oPenings = myFrame.openings.toArray();

		myFrame.openings.clear();

		for (final Object O : oPenings) {
			((OpeningObject) O).myParent = myFrame;
			myFrame.openings.add(O);
		}

		myFrame.bOpeningObject = myFrame.doMullions(myFrame.bOpeningObject);

		this.doExtensions(myFrame, createShape);

		myFrame.partObjects = createShape.doGPParts(myFrame.partObjects,
				myFrame, myFrame.glazedOut);
		double minY = 0;
		if (myFrame.shapeID < 800) {
			for (final Object p : myFrame.partObjects) {

				if (Math.max(((Profiles) p).startYC, ((Profiles) p).endYC) > minY) {
					minY = Math.max(((Profiles) p).startYC,
							((Profiles) p).endYC);
				}
			}
			// myFrame.lowestYC = myFrame.lowestY = minY;

			if (myFrame.topIn && myFrame.myMullionTop != null) {
				myFrame.highestYC = myFrame.myMullionTop.centerYs;

			}
			if (myFrame.botIn && myFrame.myMullionBot != null) {
				myFrame.lowestYC = myFrame.myMullionBot.centerYs;

			}
		}

		if (myFrame.a_levelID == 3) {
			if (!myFrame.topIn) {
				myFrame.startingCY = myFrame.startingY;
				myFrame.bCY2 = myFrame.bY2;
			}
			if (!myFrame.rightIn) {
				myFrame.bCX2 = myFrame.bX2;
				myFrame.bCX3 = myFrame.bX3;
			}
			if (!myFrame.botIn) {
				myFrame.bCY3 = myFrame.bCY3;
				myFrame.bCY4 = myFrame.bCY4;
			}
			if (!myFrame.leftIn) {
				myFrame.startingCX = myFrame.startingX;
				myFrame.bCX4 = myFrame.bX4;
			}
		}

		// myFrame.options.clear();
		// myFrame.executeOptionRules("createSubFrame.doframe.346");

		myFrame.bom.clear();
		myFrame.clearBomForShape();
		myFrame.executePartRules(true, true, "createSubFrame.doframe.346");

		createShape = null;
		myFrame.shapeChanged = false;
		return myFrame;

	}

	private void setInitValues(final int sashtype, final int sashid,
			final boolean glazedout, Frame myFrame) {
		myFrame.myFrame2 = myFrame2;
		((ShapeObject) myFrame).myFrame2 = myFrame2;

		myFrame.openingClass = sashtype;
		myFrame.userDefinedOpeningID = sashid;
		myFrame.glazedOut = glazedout;
		myFrame.shapeChanged = myParentO.shapeChanged;
	}

	/*
	 * public BkgrdOpeningObject modifyVMEqualize( final BkgrdOpeningObject
	 * bOpeningObject) {// Need to if (bOpeningObject.mullions.size() > 0) {
	 * AddMullionV addMullion = new AddMullionV( bOpeningObject,
	 * myFrame2.jobItem, myFrame2, 2); final Object[] mVs =
	 * bOpeningObject.mullions .toArray(); bOpeningObject.mullions.clear();
	 * addMullion.getDimsForMullion(bOpeningObject.xCols, 2); final double newW
	 * = addMullion.newColW; double deltaX = 0; int count = 0; for (final Object
	 * vc : mVs) { count++; Profiles newMullion = new Profiles(); newMullion =
	 * newMullion.cloneMullion(((Profiles) vc), bOpeningObject); newMullion =
	 * addMullion.setLocalCMPartDims(newMullion); deltaX =
	 * bOpeningObject.startingX + newW * count - (newMullion.centerXs +
	 * newMullion.centerXe) / 2; newMullion.centerXs = newMullion.centerXs +
	 * deltaX; newMullion.centerXe = newMullion.centerXe + deltaX; newMullion.x1
	 * = newMullion.centerXs - newMullion.thickness / 2; newMullion.x2 =
	 * newMullion.centerXs + newMullion.thickness / 2; newMullion.x4 =
	 * newMullion.centerXe - newMullion.thickness / 2; newMullion.x3 =
	 * newMullion.centerXe + newMullion.thickness / 2; newMullion.x1al =
	 * newMullion.x1 - newMullion.partDimA; newMullion.x2cl = newMullion.x2 +
	 * newMullion.partDimC; newMullion.x4al = newMullion.x4 -
	 * newMullion.partDimA; newMullion.x3cl = newMullion.x3 +
	 * newMullion.partDimC; addMullion.verifyLimitLR(newMullion);
	 * addMullion.calcMullion = new CalculateMullion(addMullion);
	 * addMullion.newStartingXCenter = newMullion.centerXs;
	 * addMullion.newStartingXRTc = newMullion.x2cl; addMullion.newStartingXRT =
	 * newMullion.x2; addMullion.newStartingXLB = newMullion.x1;
	 * addMullion.newStartingXLBa = newMullion.x1al; addMullion.vcEndY =
	 * Math.max(bOpeningObject.bY3, bOpeningObject.bY4);
	 * addMullion.calcMullion.calculateCoord(newMullion);
	 * bOpeningObject.mullions.add(newMullion); } bOpeningObject.mullionObjectsV
	 * = bOpeningObject.mullions .toArray(); bOpeningObject.mullionObjectsH =
	 * bOpeningObject.mullionsH .toArray(); addMullion.recalcHCCoords();
	 * addMullion.reOrderVNotches(); bOpeningObject.partObjects.clear();
	 * bOpeningObject.resetParts(); addMullion.splitParts(null, false, false);
	 * // bOpeningObject.myParent.doOpenings(); addMullion = null; } return
	 * bOpeningObject; }
	 */

	public void doExtensions(final Frame myFrame,
			final CreateShapeMethods createShape) {

		final Object[] fo = myFrame.openings.toArray();

		for (final Object o : fo) {
			if (((OpeningObject) o).a_sequenceID == 11) {
				myFrame.glazedOut = ((OpeningObject) o).glazedOut;
			}
			if (((OpeningObject) o).a_sequenceID == 11
					&& ((OpeningObject) o).contentMid == 2
					&& ((OpeningObject) o).sashObjectMid.sashClassType == 111) {
				final Object[] ls = ((OpeningObject) o).sashObjectMid.frames
						.toArray();
				double extension = 0;
				for (final Object s : ls) {
					extension = ((SashLeaf) s).widthPix
							+ ((OpeningObject) o).sashObjectMid.extraExtend;
					break;
				}

				myFrame.top1Part.endXC = myFrame.top1Part.endXBA = myFrame.top1Part.endXA = myFrame.top1Part.endXC
						+ extension;

				myFrame.bot1Part.startXC = myFrame.bot1Part.startXBA = myFrame.bot1Part.startXA = myFrame.bot1Part.startXC
						+ extension;

				myFrame.top1Part.length = myFrame.top1Part.endXC
						- myFrame.top1Part.startXC;

				myFrame.bot1Part.length = myFrame.bot1Part.endXC
						- myFrame.bot1Part.startXC;

				myFrame.rightPart.startXBA = myFrame.rightPart.startXA = myFrame.rightPart.endXBA = myFrame.rightPart.endXC = myFrame.rightPart.endXA = myFrame.rightPart.startXC;
				myFrame.rightPart.length = 0;

				myFrame.partObjects.clear();

				myFrame.partObjects = createShape
						.setPartObjectsAndCollection(myFrame);

			}
			if (((OpeningObject) o).a_sequenceID == 11
					&& ((OpeningObject) o).contentMid == 2
					&& ((OpeningObject) o).sashObjectMid.sashClassType == 112) {
				final Object[] ls = ((OpeningObject) o).sashObjectMid.frames
						.toArray();
				double extension = 0;
				for (final Object s : ls) {
					extension = ((SashLeaf) s).widthPix
							+ ((OpeningObject) o).sashObjectMid.extraExtend;
					break;
				}

				myFrame.top1Part.startXC = myFrame.top1Part.startXBA = myFrame.top1Part.startXA = myFrame.top1Part.startXC
						- extension;

				myFrame.bot1Part.endXC = myFrame.bot1Part.endXBA = myFrame.bot1Part.endXA = myFrame.bot1Part.endXC
						- extension;

				myFrame.top1Part.length = myFrame.top1Part.endXC
						- myFrame.top1Part.startXC;

				myFrame.bot1Part.length = myFrame.bot1Part.endXC
						- myFrame.bot1Part.startXC;

				myFrame.leftPart.startXBA = myFrame.leftPart.startXA = myFrame.leftPart.endXBA = myFrame.leftPart.endXC = myFrame.leftPart.endXA = myFrame.leftPart.startXC;
				myFrame.leftPart.length = 0;
				myFrame.partObjects.clear();

				myFrame.partObjects = createShape
						.setPartObjectsAndCollection(myFrame);
			}

			if (((OpeningObject) o).a_sequenceID == 11
					&& ((OpeningObject) o).contentMid == 2
					&& ((OpeningObject) o).sashObjectMid.sashClassType == 113) {
				final Object[] ls = ((OpeningObject) o).sashObjectMid.frames
						.toArray();
				double extension = 0;
				for (final Object s : ls) {
					extension = ((SashLeaf) s).widthPix
							+ ((OpeningObject) o).sashObjectMid.extraExtend;
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

				myFrame.top1Part.length = myFrame.top1Part.endXC
						- myFrame.top1Part.startXC;

				myFrame.bot1Part.length = myFrame.bot1Part.endXC
						- myFrame.bot1Part.startXC;

				myFrame.rightPart.startXBA = myFrame.rightPart.startXA = myFrame.rightPart.endXBA = myFrame.rightPart.endXC = myFrame.rightPart.endXA = myFrame.rightPart.startXC;
				myFrame.rightPart.length = 0;

				myFrame.leftPart.startXBA = myFrame.leftPart.startXA = myFrame.leftPart.endXBA = myFrame.leftPart.endXC = myFrame.leftPart.endXA = myFrame.leftPart.startXC;
				myFrame.leftPart.length = 0;

				myFrame.partObjects.clear();

				myFrame.partObjects = createShape
						.setPartObjectsAndCollection(myFrame);
			}
		}
	}

	public Collection setPartObjectsAndCollection(final Frame myFrame,
			final CreateShapeMethods createShape) {

		myFrame.top1 = (Top1Object) myFrame.top1.cloneProfile(myFrame.top1Part);
		myFrame.top2 = (Top2Object) myFrame.top2.cloneProfile(myFrame.top2Part);
		myFrame.top3 = (Top3Object) myFrame.top3.cloneProfile(myFrame.top3Part);

		myFrame.bot1 = (Bot1Object) myFrame.bot1.cloneProfile(myFrame.bot1Part);
		myFrame.bot2 = (Bot2Object) myFrame.bot2.cloneProfile(myFrame.bot2Part);
		myFrame.bot3 = (Bot3Object) myFrame.bot3.cloneProfile(myFrame.bot3Part);

		myFrame.left = (LeftObject) myFrame.left.cloneProfile(myFrame.leftPart);
		myFrame.right = (RightObject) myFrame.right
				.cloneProfile(myFrame.rightPart);

		myFrame.partObjects.clear();

		if (myFrame.noSidesTop == 1) {
			myFrame.partObjects.add(myFrame.top1Part);
		} else if (myFrame.noSidesTop == 2) {
			myFrame.partObjects.add(myFrame.top1Part);
			myFrame.partObjects.add(myFrame.top2Part);
		} else if (myFrame.noSidesTop == 3) {
			myFrame.partObjects.add(myFrame.top1Part);
			myFrame.partObjects.add(myFrame.top2Part);
			myFrame.partObjects.add(myFrame.top3Part);
		}
		if (myFrame.noSidesBot == 1) {
			myFrame.partObjects.add(myFrame.bot1Part);
		} else if (myFrame.noSidesBot == 2) {
			myFrame.partObjects.add(myFrame.bot1Part);
			myFrame.partObjects.add(myFrame.bot2Part);
		} else if (myFrame.noSidesBot == 3) {
			myFrame.partObjects.add(myFrame.bot1Part);
			myFrame.partObjects.add(myFrame.bot2Part);
			myFrame.partObjects.add(myFrame.bot3Part);
		}
		if (myFrame.noSidesLeft == 1) {
			myFrame.partObjects.add(myFrame.leftPart);
		}
		if (myFrame.noSidesRight == 1) {
			myFrame.partObjects.add(myFrame.rightPart);
		}

		return myFrame.partObjects;
	}

	public GeneralPath doGeneralPathGlass(final Profiles part) {

		final GeneralPath myOpen = new GeneralPath();

		myOpen.moveTo((int) part.startXC, (int) part.startYC);

		if (part.partForm == 2) {
			final Arc2D mytopb = new Arc2D.Double(part.bkgrdStartXBA,
					part.bkgrdStartYBA, part.bkgrdWidthBA, part.bkgrdHeightBA,
					part.startAngleBA, part.endAngleBA, Arc2D.OPEN);

			xCoordB = new ArrayList();
			yCoordB = new ArrayList();
			this.getPoints(mytopb, 1, part.startXC);

			xCoordBo = xCoordB.toArray();
			yCoordBo = yCoordB.toArray();

			myOpen.moveTo((int) part.startXC, (int) part.startYC);

			for (int i = xCoordBo.length; i >= 1; i--) {
				if ((Double) xCoordBo[i - 1] >= 0) {
					myOpen.lineTo(((Double) xCoordBo[i - 1]),
							((Double) yCoordBo[i - 1]));
				}
			}

			// myOpen.append(mytop, false);

			// myOpen.moveTo((int) opening.endX,
			// (int)
			// opening.endY);

		} else {
			myOpen.lineTo((int) part.endXC, (int) part.endYC);

		}
		myOpen.lineTo((int) part.endXA, (int) part.endYA);

		if (part.partForm == 2) {

			final Arc2D mytopa = new Arc2D.Double(part.bkgrdStartXA,
					part.bkgrdStartYA, part.bkgrdWidthA, part.bkgrdHeightA,
					part.startAngleA, part.endAngleA, Arc2D.OPEN);
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
				myOpen.lineTo(((Double) xCoordBo[i]), ((Double) yCoordBo[i]));
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

	//
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

	public Frame initSashLeaf(final boolean topIn, final boolean botIn,
			final boolean leftIn, final boolean rightIn) {

		final Frame myFrame = new Frame();

		myFrame.a_levelID = 3;

		myFrame.a_sequenceID = myParentO.a_sequenceID;

		myFrame.myParentO = myParentO;
		myFrame.shapeID = myParentO.shapeID;
		if (myParentO.shapeID == 0) {
			myFrame.shapeID = 1;
		}

		myFrame.myFrame2 = myFrame2;

		((ShapeObject) myFrame).myFrame2 = myFrame2;

		myFrame.myFacet = myFrame2.facetUsed;

		myFrame.myParent = myParentO.myParent;
		myFrame.options.clear();
		myFrame.executeOptionRules("createSubFrame.intSashLeaf.872");

		myFrame.topIn = topIn;
		myFrame.botIn = botIn;
		myFrame.leftIn = leftIn;
		myFrame.rightIn = rightIn;

		myFrame.noSides = myParentO.noSides;
		myFrame.noSidesTop = myParentO.noSidesTop;
		myFrame.noSidesBot = myParentO.noSidesBot;
		myFrame.noSidesLeft = myParentO.noSidesLeft;
		myFrame.noSidesRight = myParentO.noSidesRight;

		myFrame.startCol = myParentO.startCol;
		myFrame.startRow = myParentO.startRow;
		myFrame.endCol = myParentO.endCol;
		myFrame.endRow = myParentO.endRow;

		myFrame.shapeID = myParentO.shapeID;
		myFrame.shapeChanged = myParentO.shapeChanged;

		myFrame.startingCX = myParentO.startingCX;
		myFrame.startingCY = myParentO.startingCY;

		myFrame.px1c = myParentO.px1c;
		myFrame.py1c = myParentO.py1c;
		myFrame.px2c = myParentO.px2c;
		myFrame.py2c = myParentO.py2c;
		myFrame.px3c = myParentO.px3c;
		myFrame.py3c = myParentO.py3c;
		myFrame.px4c = myParentO.px4c;
		myFrame.py4c = myParentO.py4c;
		myFrame.px5c = myParentO.px5c;
		myFrame.py5c = myParentO.py5c;
		myFrame.px6c = myParentO.px6c;
		myFrame.py6c = myParentO.py6c;
		myFrame.px7c = myParentO.px7c;
		myFrame.py7c = myParentO.py7c;
		myFrame.px8c = myParentO.px8c;
		myFrame.py8c = myParentO.py8c;

		myFrame.bCX2 = myParentO.bCX2;
		myFrame.bCY2 = myParentO.bCY2;
		myFrame.bCX3 = myParentO.bCX3;
		myFrame.bCY3 = myParentO.bCY3;
		myFrame.bCX4 = myParentO.bCX4;
		myFrame.bCY4 = myParentO.bCY4;

		return myFrame;
	}

	public Frame initSashParts(Frame myFrame) {

		// Get Sash Clearance and Dims

		myFrame.top1Part = new Profiles();
		myFrame.top2Part = new Profiles();
		myFrame.top3Part = new Profiles();
		myFrame.rightPart = new Profiles();
		myFrame.leftPart = new Profiles();
		myFrame.bot1Part = new Profiles();
		myFrame.bot2Part = new Profiles();
		myFrame.bot3Part = new Profiles();

		myFrame.top1 = new Top1Object();
		myFrame.top2 = new Top2Object();
		myFrame.top3 = new Top3Object();
		myFrame.right = new RightObject();
		myFrame.left = new LeftObject();
		myFrame.bot1 = new Bot1Object();
		myFrame.bot2 = new Bot2Object();
		myFrame.bot3 = new Bot3Object();

		myFrame = this.setPartforms(myFrame);

		return myFrame;

	}

	public Frame copyParts(final Frame myFrame, final Frame original) {

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

	public Frame setPartforms(Frame myFrame) {

		myFrame.top1Part.partForm = myParentO.top1Part.partForm;

		myFrame.top2Part.partForm = myParentO.top2Part.partForm;

		myFrame.top3Part.partForm = myParentO.top3Part.partForm;

		myFrame.bot1Part.partForm = myParentO.bot1Part.partForm;

		myFrame.bot2Part.partForm = myParentO.bot2Part.partForm;

		myFrame.bot3Part.partForm = myParentO.bot3Part.partForm;

		myFrame.leftPart.partForm = myParentO.leftPart.partForm;

		myFrame.rightPart.partForm = myParentO.rightPart.partForm;

		myFrame = this.doPartPos(myFrame);
		return myFrame;
	}

	public Frame doPartPos(final Frame myFrame) {

		if (!myParentO.top1Part.posInUse) {
			myFrame.top1Part = new Profiles();
			myFrame.top1Part.posInUse = false;
		}
		if (!myParentO.top2Part.posInUse) {
			myFrame.top2Part = new Profiles();
			myFrame.top2Part.posInUse = false;
		}
		if (!myParentO.top3Part.posInUse) {
			myFrame.top3Part = new Profiles();
			myFrame.top3Part.posInUse = false;
		}
		if (!myParentO.bot1Part.posInUse) {
			myFrame.bot1Part = new Profiles();
			myFrame.bot1Part.posInUse = false;
		}
		if (!myParentO.bot2Part.posInUse) {
			myFrame.bot2Part = new Profiles();
			myFrame.bot2Part.posInUse = false;
		}
		if (!myParentO.bot3Part.posInUse) {
			myFrame.bot3Part = new Profiles();
			myFrame.bot3Part.posInUse = false;
		}
		if (!myParentO.leftPart.posInUse) {
			myFrame.leftPart = new Profiles();
			myFrame.leftPart.posInUse = false;
		}
		if (!myParentO.rightPart.posInUse) {
			myFrame.rightPart = new Profiles();
			myFrame.rightPart.posInUse = false;
		}

		return myFrame;
	}

	public Object[] setPartDims(Frame myFrame,
			final CreateShapeMethods createShape) {

		final Object[] myreturns = new Object[2];
		myFrame.top1Part.profileSelected = 0;
		myFrame.top2Part.profileSelected = 0;
		myFrame.top3Part.profileSelected = 0;
		myFrame.bot1Part.profileSelected = 0;
		myFrame.bot2Part.profileSelected = 0;
		myFrame.bot3Part.profileSelected = 0;
		myFrame.leftPart.profileSelected = 0;
		myFrame.rightPart.profileSelected = 0;

//		myFrame.executePartRules(false, false,
//				"createsubframe.setpartdims.1177");
		myFrame.executePartRules(false);
		
		myFrame.top1Part.lengthMN = (int) (myFrame.top1Part.length / myFrame2.metricscale
				.doubleValue());
		myFrame.top1Part.lengthIN = (int) (myFrame.top1Part.length / myFrame2.imperialscale
				.doubleValue());

		myFrame.top2Part.lengthMN = (int) (myFrame.top2Part.length / myFrame2.metricscale
				.doubleValue());
		myFrame.top2Part.lengthIN = (int) (myFrame.top2Part.length / myFrame2.imperialscale
				.doubleValue());

		myFrame.top3Part.lengthMN = (int) (myFrame.top3Part.length / myFrame2.metricscale
				.doubleValue());
		myFrame.top3Part.lengthIN = (int) (myFrame.top3Part.length / myFrame2.imperialscale
				.doubleValue());

		myFrame.bot1Part.lengthMN = (int) (myFrame.bot1Part.length / myFrame2.metricscale
				.doubleValue());
		myFrame.bot1Part.lengthIN = (int) (myFrame.bot1Part.length / myFrame2.imperialscale
				.doubleValue());

		myFrame.bot2Part.lengthMN = (int) (myFrame.bot2Part.length / myFrame2.metricscale
				.doubleValue());
		myFrame.bot2Part.lengthIN = (int) (myFrame.bot2Part.length / myFrame2.imperialscale
				.doubleValue());

		myFrame.bot3Part.lengthMN = (int) (myFrame.bot3Part.length / myFrame2.metricscale
				.doubleValue());
		myFrame.bot3Part.lengthIN = (int) (myFrame.bot3Part.length / myFrame2.imperialscale
				.doubleValue());

		myFrame.leftPart.lengthMN = (int) (myFrame.leftPart.length / myFrame2.metricscale
				.doubleValue());
		myFrame.leftPart.lengthIN = (int) (myFrame.leftPart.length / myFrame2.imperialscale
				.doubleValue());

		myFrame.rightPart.lengthMN = (int) (myFrame.rightPart.length / myFrame2.metricscale
				.doubleValue());
		myFrame.rightPart.lengthIN = (int) (myFrame.rightPart.length / myFrame2.imperialscale
				.doubleValue());

		myFrame = (Frame) this.myFrame2.shapeColor
				.setShapeObjectPartColors(myFrame);

		if (myFrame2.mySeries.getSeriesUom() == 1) {
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
		} else {
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

}

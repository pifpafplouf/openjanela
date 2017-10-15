/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Model.ProfileParts;

import java.awt.Polygon;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import openjanela.model.entities.design.BkgrdOpeningEntityObject;
import openjanela.model.entities.design.DLOEntityObject;
import openjanela.model.entities.design.ProfileEntityBOM;
import openjanela.model.entities.design.ProfileEntityObject;
import openjanela.model.entities.design.ProfileGridMaskObject;
import openjanela.model.entities.design.ProfileGridObject;
import openjanela.model.entities.design.ProfileGridSpokeObject;
import openjanela.model.entities.design.ProfileLimitObject;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;

import util.UOMConvert;
import Model.BillOfMat;
import Model.BkgrdOpeningObject;
import Model.Frame;
import Model.ShapeObject;
import Operations.EllipseLineIntersections;
import Presentation.ItemFrame;
import dto.ProfileDTO;

public class Profiles extends ProfileParts implements Cloneable {

	// Apache log4j
	private static final Logger logger = Logger.getLogger(Profiles.class);

	/**
	 * Default Constructor
	 */
	public Profiles() {
	}

	/**
	 * Create Profiles object
	 * 
	 * @param myFrame
	 *            , ItemFrame
	 */
	public Profiles(ItemFrame myFrame) {
		this.myFrame2 = myFrame;

	}

	/**
	 * Create a new Profiles object
	 * 
	 * @param parent
	 * @param posStart
	 * @param posEnd
	 * @param VH
	 * @param centerXs
	 * @param centerXe
	 * @param centerYs
	 * @param centerYe
	 * @param length
	 * @param myframe
	 */
	public Profiles(BkgrdOpeningObject parent, int posStart, int posEnd,
			int VH, double centerXs, double centerXe, final double centerYs,
			double centerYe, double length, ItemFrame myframe) {

		this.myParent = parent;
		this.myFrame2 = myframe;
		this.scale = myFrame2.scale;
		this.centerXs = centerXs;
		this.centerXe = centerXe;
		this.centerYs = centerYs;
		this.centerYe = centerYe;

		this.orientation = VH;
		this.startPos = posStart;
		this.endPos = posEnd;
		this.length = length;
		this.rID = myParent.rID;
		this.levelID = 4;

		/**
		 * this.verticalCouplerStraight(); this.limitStartX1a = new Profiles();
		 * this.limitStartX1 = new Profiles(); this.limitStartXC = new
		 * Profiles(); this.limitStartX2 = new Profiles(); this.limitStartX2c =
		 * new Profiles(); this.limitStartY1a = new Profiles();
		 * this.limitStartY1 = new Profiles(); this.limitStartYC = new
		 * Profiles(); this.limitStartY2 = new Profiles(); this.limitStartY2c =
		 * new Profiles(); this.limitEndX4a = new Profiles(); this.limitEndX4 =
		 * new Profiles(); this.limitEndXC = new Profiles(); this.limitEndX3 =
		 * new Profiles(); this.limitEndX3c = new Profiles(); this.limitEndY4a =
		 * new Profiles(); this.limitEndY4 = new Profiles(); this.limitEndYC =
		 * new Profiles(); this.limitEndY3 = new Profiles(); this.limitEndY3c =
		 * new Profiles();
		 **/

		// Vertical coupler straight
		this.verticalCouplerStraight();
	}

	/**
	 * Create Profiles from ProfileEntityObject
	 * 
	 * @param parent
	 *            , BkgrdOpeningObject
	 * @param profileEntity
	 *            , ProfileEntityObject
	 */
	public Profiles(ShapeObject parent, ProfileEntityObject profileEntity) {

		// Setting BkgrdOpeningObject
		this.myParent = parent.myParent;
		// Setting ItemFrame
		this.myFrame2 = parent.myFrame2;

		// Vertical coupler straight
		this.verticalCouplerStraight();

		// Initialized Profiles model object
		createProfileModelObject(profileEntity);
	}

	/**
	 * Create Profiles from ProfileGridObject
	 * 
	 * @param parent
	 * @param profileGridObject
	 */
	public Profiles(ShapeObject parent, ProfileGridObject profileGridObject) {

		// Setting parent object
		myParent = parent;
		// Setting ItemFrame
		myFrame2 = parent.myFrame2;

		// Vertical coupler straight
		this.verticalCouplerStraight();

		// Initialized Profiles model object
		createProfilePartsModelObject(profileGridObject);
	}

	/**
	 * Create Profiles form ProfileGridSpokeObject
	 * 
	 * @param parent
	 *            , ShapeObject
	 * @param profileGridSpokeObject
	 *            , ProfileGridSpokeObject
	 */
	public Profiles(ShapeObject parent,
			ProfileGridSpokeObject profileGridSpokeObject) {

		// Setting parent object
		myParent = parent;
		// Setting ItemFrame
		myFrame2 = parent.myFrame2;

		// Vertical coupler straight
		this.verticalCouplerStraight();

		// Initialized Profiles model object
		createProfilePartsModelObject(profileGridSpokeObject);
	}

	/**
	 * Create Profiles from ProfileGridMaskObject
	 * 
	 * @param parent
	 *            , ShapeObject
	 * @param profileGridMaskObject
	 *            , ProfileGridMaskObject
	 */
	public Profiles(ShapeObject parent,
			ProfileGridMaskObject profileGridMaskObject) {

		// Setting parent object
		myParent = parent;
		// Setting ItemFrame
		myFrame2 = parent.myFrame2;

		// Vertical coupler straight
		this.verticalCouplerStraight();

		// Initialized profiles model object
		createProfilePartsModelObject(profileGridMaskObject);
	}

	/**
	 * Create Profiles from ProfileEntityBOM
	 * 
	 * @param parent
	 *            , ShapeObject
	 * @param profileEntity
	 *            , ProfileEntityBOM
	 */
	public Profiles(ShapeObject parent, ProfileEntityBOM profileEntity) {

		// Setting ShapeObject
		this.myParent = parent;
		// Setting ItemFrame
		this.myFrame2 = parent.myFrame2;

		// Vertical coupler straight
		this.verticalCouplerStraight();

		// Initialized Profiles model object
		createProfilePartsModelObject(profileEntity);
	}

	public Profiles(Collection profiles) {

		final Object[] parts = profiles.toArray();

		for (final Object P : parts) {
			if (((Profiles) P).position == 1) {
				noPartsTop1 = noPartsTop1 + 1;

			}
			if (((Profiles) P).position == 2) {
				noPartsTop2 = 1;
			}
			if (((Profiles) P).position == 3) {
				noPartsTop3 = 1;
			}
			if (((Profiles) P).position == 6) {
				noPartsBot1 = noPartsBot1 + 1;

			}
			if (((Profiles) P).position == 7) {
				noPartsBot2 = 1;
			}
			if (((Profiles) P).position == 5) {
				noPartsBot3 = 1;
			}
			if (((Profiles) P).position == 8) {
				noPartsLeft = 1;
			}
			if (((Profiles) P).position == 4) {
				noPartsRight = 1;
			}
		}

		for (final Object P : parts) {
			if (((Profiles) P).position == 1) {
				top1Part = P;
			} else if (((Profiles) P).position == 2) {
				top2Part = P;
			} else if (((Profiles) P).position == 3) {
				top3Part = P;
			} else if (((Profiles) P).position == 4) {
				rightPart = P;
			} else if (((Profiles) P).position == 5) {
				bot3Part = P;
			} else if (((Profiles) P).position == 6) {
				bot1Part = P;
			} else if (((Profiles) P).position == 7) {
				bot2Part = P;
			} else if (((Profiles) P).position == 8) {
				leftPart = P;
			}
		}

	}

	public Profiles setColor(Profiles myM, int r, int g, int b, int ri, int gi,
			int bi, int ro, int go, int bo) {

		rgb_R = r;
		rgb_Rin = ri;
		rgb_Rout = ro;
		rgb_G = g;
		rgb_Gin = gi;
		rgb_Gout = go;
		rgb_B = b;
		rgb_Bin = bi;
		rgb_Bout = bo;
		return myM;
	}

	public void setColor(int r, int g, int b, int ri, int gi, int bi, int ro,
			int go, int bo) {

		// rgb_R = r;
		// rgb_Rin = ri;
		// rgb_Rout = ro;
		// rgb_G = g;
		// rgb_Gin = gi;
		// rgb_Gout = go;
		// rgb_B = b;
		// rgb_Bin = bi;
		// rgb_Bout = bo;

	}

	public GeneralPath doGPProfilesNEW(Profiles p, double W, double H,
			int shapeID, Profiles top, Profiles bot, int type, boolean leftIn,
			boolean rightIn, boolean doBA) {

		GeneralPath gp = new GeneralPath();
		top1 = top;
		bot1 = bot;
		levelW = W;
		levelH = H;
		leftInf = leftIn;
		rightInf = rightIn;

		if (p.partForm == 1) {
			gp = this.straightPart(p, doBA);
		}
		if (p.partForm == 2) {
			gp = this.curvePart(p, type, doBA);
		}
		if (p.partForm == 3) {
			gp = this.ellipsePart(p, W, H, shapeID, type, doBA);
		}

		return gp;
	}

	public GeneralPath doGPProfiles(Profiles p, double W, double H,
			int shapeID, Profiles top, Profiles bot, int type, boolean leftIn,
			boolean rightIn, boolean doBA) {

		GeneralPath gp = new GeneralPath();
		top1 = top;
		bot1 = bot;
		levelW = W;
		levelH = H;
		leftInf = leftIn;
		rightInf = rightIn;
		if (p.partForm == 1) {
			gp = this.straightPartOLD(p, doBA);
		}
		if (p.partForm == 2) {
			gp = this.curvePartOLD(p, type, doBA);
		}
		if (p.partForm == 3) {
			gp = this.ellipsePart(p, W, H, shapeID, type, doBA);
		}

		return gp;
	}

	public Polygon doGPProfilesPoly(Profiles p, double W, double H,
			int shapeID, Profiles top, Profiles bot, int type, boolean leftIn,
			boolean rightIn) {

		Polygon poly = new Polygon();
		top1 = top;
		bot1 = bot;
		levelW = W;
		levelH = H;
		leftInf = leftIn;
		rightInf = rightIn;
		if (p.partForm == 1) {
			poly = this.straightPartPoly(p);
		}

		return poly;
	}

	/**
	 * Create General Path Straigh part Old
	 * 
	 * @param p
	 *            , Object
	 * @param doBA
	 *            , boolean
	 * @return GeneralPath
	 */
	public GeneralPath straightPartOLD(Object p, boolean doBA) {

		GeneralPath gp = new GeneralPath();

		if (((Profiles) p).length != 0) {

			gp.moveTo((int) ((Profiles) p).startXC,
					(int) ((Profiles) p).startYC);
			gp.lineTo((int) ((Profiles) p).endXC, (int) ((Profiles) p).endYC);
			gp.lineTo((int) ((Profiles) p).endXBA, (int) ((Profiles) p).endYBA);

			if (((Profiles) p).position <= 3) {
				if (((Profiles) p).endTypeLT == 2
						&& ((Profiles) p).stopAeX != 0
						&& ((Profiles) p).stopAeY != 0) {
					gp.lineTo((int) ((Profiles) p).stopAeX,
							(int) ((Profiles) p).stopAeY);
				}
			} else if (((Profiles) p).position == 4) {
				if (((Profiles) p).endTypeLT == 2
						&& ((Profiles) p).stopAeX != 0
						&& ((Profiles) p).stopAeY != 0) {
					gp.lineTo((int) ((Profiles) p).stopAeX,
							(int) ((Profiles) p).stopAeY);
				}
			} else if (((Profiles) p).position >= 5
					&& ((Profiles) p).position <= 7) {
				if (((Profiles) p).endTypeLT == 2
						&& ((Profiles) p).stopAeX != 0
						&& ((Profiles) p).stopAeY != 0) {
					gp.lineTo((int) ((Profiles) p).stopAeX,
							(int) ((Profiles) p).stopAeY);
				}
			} else if (((Profiles) p).position == 8) {
				if (((Profiles) p).endTypeLT == 2
						&& ((Profiles) p).stopAeX != 0
						&& ((Profiles) p).stopAeY != 0) {
					gp.lineTo((int) ((Profiles) p).stopAeX,
							(int) ((Profiles) p).stopAeY);
				}
			}

			gp.lineTo((int) ((Profiles) p).endXA, (int) ((Profiles) p).endYA);
			gp.lineTo((int) ((Profiles) p).startXA,
					(int) ((Profiles) p).startYA);

			if (((Profiles) p).position <= 3) {
				if (((Profiles) p).endTypeRB == 2
						&& ((Profiles) p).stopAsX != 0
						&& ((Profiles) p).stopAsY != 0) {
					gp.lineTo((int) ((Profiles) p).stopAsX,
							(int) ((Profiles) p).stopAsY);
				}
			} else if (((Profiles) p).position == 4) {
				if (((Profiles) p).endTypeRB == 2
						&& ((Profiles) p).stopAsX != 0
						&& ((Profiles) p).stopAsY != 0) {
					gp.lineTo((int) ((Profiles) p).stopAsX,
							(int) ((Profiles) p).stopAsY);
				}
			} else if (((Profiles) p).position >= 5
					&& ((Profiles) p).position <= 7) {
				if (((Profiles) p).endTypeRB == 2
						&& ((Profiles) p).stopAsX != 0
						&& ((Profiles) p).stopAsY != 0) {
					gp.lineTo((int) ((Profiles) p).stopAsX,
							(int) ((Profiles) p).stopAsY);
				}
			} else if (((Profiles) p).position == 8) {
				if (((Profiles) p).endTypeRB == 2
						&& ((Profiles) p).stopAsX != 0
						&& ((Profiles) p).stopAsY != 0) {
					gp.lineTo((int) ((Profiles) p).stopAsX,
							(int) ((Profiles) p).stopAsY);
				}
			}

			gp.lineTo((int) ((Profiles) p).startXBA,
					(int) ((Profiles) p).startYBA);
			gp.lineTo((int) ((Profiles) p).startXC,
					(int) ((Profiles) p).startYC);

			if (doBA) {
				gp.moveTo((int) ((Profiles) p).startXBA,
						(int) ((Profiles) p).startYBA);
				gp.lineTo((int) ((Profiles) p).endXBA,
						(int) ((Profiles) p).endYBA);

			}
		}

		return gp;
	}

	public GeneralPath straightPart(final Object P, final boolean doBA) {

		final GeneralPath gp = new GeneralPath();
		if (((Profiles) P).length != 0) {
			gp.moveTo(((Profiles) P).startXC, ((Profiles) P).startYC);
			gp.lineTo(((Profiles) P).endXC, ((Profiles) P).endYC);
			gp.lineTo(((Profiles) P).endXBA, ((Profiles) P).endYBA);
			if (((Profiles) P).endTypeLT == 2 && ((Profiles) P).stopAeX != 0
					&& ((Profiles) P).stopAeY != 0) {
				gp.lineTo(((Profiles) P).stopAeX, ((Profiles) P).stopAeY);
			}
			gp.lineTo(((Profiles) P).endXA, ((Profiles) P).endYA);
			gp.lineTo(((Profiles) P).startXA, ((Profiles) P).startYA);
			if (((Profiles) P).endTypeRB == 2 && ((Profiles) P).stopAsX != 0
					&& ((Profiles) P).stopAsY != 0) {
				gp.lineTo(((Profiles) P).stopAsX, ((Profiles) P).stopAsY);
			}
			gp.lineTo(((Profiles) P).startXBA, ((Profiles) P).startYBA);
			gp.lineTo(((Profiles) P).startXC, ((Profiles) P).startYC);

			if (doBA) {
				gp.moveTo(((Profiles) P).startXBA, ((Profiles) P).startYBA);
				gp.lineTo(((Profiles) P).endXBA, ((Profiles) P).endYBA);

			}
		}

		return gp;

	}

	public Polygon straightPartPoly(final Object P) {

		// if((((Profiles) P).position==8) && (((Profiles)
		// P).myParent.noSides==8) &&
		// (((Profiles) P).myParent.levelID==3)) {
		// ((Profiles) P).startX=((Profiles) P).startX;
		// }

		final Polygon poly = new Polygon();
		poly.addPoint((int) ((Profiles) P).startXC,
				(int) ((Profiles) P).startYC);
		poly.addPoint((int) ((Profiles) P).endXC, (int) ((Profiles) P).endYC);
		poly.addPoint((int) ((Profiles) P).endXBA, (int) ((Profiles) P).endYBA);
		if (((Profiles) P).endTypeLT == 2) {
			poly.addPoint((int) ((Profiles) P).stopAeX,
					(int) ((Profiles) P).stopAeY);
		}
		poly.addPoint((int) ((Profiles) P).endXA, (int) ((Profiles) P).endYA);
		poly.addPoint((int) ((Profiles) P).startXA,
				(int) ((Profiles) P).startYA);

		if (((Profiles) P).endTypeRB == 2) {
			poly.addPoint((int) ((Profiles) P).stopAsX,
					(int) ((Profiles) P).stopAsY);
		}
		poly.addPoint((int) ((Profiles) P).startXBA,
				(int) ((Profiles) P).startYBA);
		poly.addPoint((int) ((Profiles) P).startXC,
				(int) ((Profiles) P).startYC);

		return poly;

	}

	public GeneralPath curvePart(final Object P, final int type,
			final boolean doBA) {

		final GeneralPath gp = new GeneralPath();
		final GeneralPath gpB = new GeneralPath();
		final GeneralPath gpBA = new GeneralPath();
		final GeneralPath gpA = new GeneralPath();
		if (type == 1) {
			arcB = new Arc2D.Double(((Profiles) P).bkgrdStartX,
					((Profiles) P).bkgrdStartY, ((Profiles) P).bkgrdWidth,
					((Profiles) P).bkgrdHeight, ((Profiles) P).startAngle,
					((Profiles) P).endAngle, Arc2D.OPEN);
			gpB.append(arcB, false);

		} else if (type == 3) {
			arcA = new Arc2D.Double(((Profiles) P).bkgrdStartXA,
					((Profiles) P).bkgrdStartYA, ((Profiles) P).bkgrdWidthA,
					((Profiles) P).bkgrdHeightA, ((Profiles) P).startAngleA,
					((Profiles) P).endAngleA, Arc2D.OPEN);

			gpA.append(arcA, false);
		} else if (type == 2 && doBA) {
			arcBA = new Arc2D.Double(((Profiles) P).bkgrdStartXBA,
					((Profiles) P).bkgrdStartYBA, ((Profiles) P).bkgrdWidthBA,
					((Profiles) P).bkgrdHeightBA, ((Profiles) P).startAngleBA,
					((Profiles) P).endAngleBA, Arc2D.OPEN);
			gpBA.append(arcBA, false);
		}
		if (type == 0) {
			double totalThick = 0;
			if (((Profiles) P).myParent.a_levelID == 12) {
				totalThick = ((Profiles) P).partDimC + ((Profiles) P).partDimB
						+ ((Profiles) P).partDimA;
			} else {
				totalThick = ((Profiles) P).partDimB + ((Profiles) P).partDimA;
			}

			gp.append(this.fillArc(P, totalThick), false);
		}

		if (((Profiles) P).endTypeRB == 2) {
			endL = new Line2D.Double(((Profiles) P).startXBA,
					((Profiles) P).startYBA, ((Profiles) P).startXC,
					((Profiles) P).startYC);
			gpA.append(endL, false);
			gp.append(endL, false);
			gpB.append(endL, false);
			gpBA.append(endL, false);
		}
		if (((Profiles) P).endTypeLT == 2) {
			endR = new Line2D.Double(((Profiles) P).endXC,
					((Profiles) P).endYC, ((Profiles) P).endXBA,
					((Profiles) P).endYBA);
			gp.append(endR, false);
			gpB.append(endR, false);
			gpBA.append(endR, false);
			gpA.append(endR, false);
		}
		if (((Profiles) P).myParent.shapeID >= 450
				&& ((Profiles) P).myParent.shapeID <= 461
				&& ((Profiles) P).position == 1) {
			final Point2D p = this.getIntersectionLineArc(
					((Profiles) P).bkgrdStartX,
					((Profiles) P).bkgrdStartY, //
					((Profiles) P).bkgrdWidth,
					((Profiles) P).bkgrdHeight, //
					((Profiles) P).startAngle,
					((Profiles) P).endAngle, //
					((Profiles) P).x1, ((Profiles) P).y1, ((Profiles) P).endXC,
					0, ((Profiles) P).endXC, 500, 1, false);

			endR = new Line2D.Double(((Profiles) P).endXC,
					((Profiles) P).endYC, ((Profiles) P).endXC, p.getY());

		}
		GeneralPath mygp = new GeneralPath();

		if (type == 0) {
			mygp = gp;
		}
		if (type == 1) {
			mygp = gpB;
		}
		if (type == 2) {
			mygp = gpBA;
		}
		if (type == 3) {
			mygp = gpA;
		}
		if (((Profiles) P).myParent.shapeID >= 450
				&& ((Profiles) P).myParent.shapeID <= 461
				&& ((Profiles) P).position == 1) {

			mygp.append(endR, false);

		}
		// mygp.append(fillArc(P, totalThick),
		// false);

		return mygp;
	}

	public GeneralPath curvePartOLD(final Object P, final int type,
			final boolean doBA) {

		final GeneralPath gp = new GeneralPath();
		final GeneralPath gpB = new GeneralPath();
		final GeneralPath gpBA = new GeneralPath();
		final GeneralPath gpA = new GeneralPath();
		if (type == 1) {
			arcB = new Arc2D.Double((int) ((Profiles) P).bkgrdStartX,
					(int) ((Profiles) P).bkgrdStartY,
					(int) ((Profiles) P).bkgrdWidth,
					(int) ((Profiles) P).bkgrdHeight,
					((Profiles) P).startAngle, ((Profiles) P).endAngle,
					Arc2D.OPEN);
			gpB.append(arcB, false);

		} else if (type == 3) {
			arcA = new Arc2D.Double((int) ((Profiles) P).bkgrdStartXA,
					(int) ((Profiles) P).bkgrdStartYA,
					(int) ((Profiles) P).bkgrdWidthA,
					(int) ((Profiles) P).bkgrdHeightA,
					((Profiles) P).startAngleA, ((Profiles) P).endAngleA,
					Arc2D.OPEN);

			gpA.append(arcA, false);
		} else if (type == 2 && doBA) {
			arcBA = new Arc2D.Double((int) ((Profiles) P).bkgrdStartXBA,
					(int) ((Profiles) P).bkgrdStartYBA,
					(int) ((Profiles) P).bkgrdWidthBA,
					(int) ((Profiles) P).bkgrdHeightBA,
					((Profiles) P).startAngleBA, ((Profiles) P).endAngleBA,
					Arc2D.OPEN);
			gpBA.append(arcBA, false);
		}
		if (type == 0) {

			double totalThick = 0;

			// if (((Profiles) P).myParent.a_levelID == 12) {
			totalThick = ((Profiles) P).partDimC + ((Profiles) P).partDimB
					+ ((Profiles) P).partDimA;
			// } else {
			// totalThick =
			// ((Profiles) P).partDimB
			// + ((Profiles) P).partDimA;
			// }

			gp.append(this.fillArc(P, totalThick), false);
		}

		if (((Profiles) P).endTypeRB == 2) {
			endL = new Line2D.Double((int) ((Profiles) P).startXBA,
					(int) ((Profiles) P).startYBA,
					(int) ((Profiles) P).startXC, (int) ((Profiles) P).startYC);
			gpA.append(endL, false);
			gp.append(endL, false);
			gpB.append(endL, false);
			gpBA.append(endL, false);
		}
		if (((Profiles) P).endTypeLT == 2) {
			endR = new Line2D.Double((int) ((Profiles) P).endXC,
					(int) ((Profiles) P).endYC, (int) ((Profiles) P).endXBA,
					(int) ((Profiles) P).endYBA);
			gp.append(endR, false);
			gpB.append(endR, false);
			gpBA.append(endR, false);
			gpA.append(endR, false);
		}
		if (((Profiles) P).myParent.shapeID >= 450
				&& ((Profiles) P).myParent.shapeID <= 461
				&& ((Profiles) P).position == 1 && type == 3
				&& ((Profiles) P).partDimB > 0 && ((Profiles) P).partDimA > 0) {
			final EllipseLineIntersections arcX = new EllipseLineIntersections();

			final double endYa = arcX.getYusingX(((Profiles) P).endXC,
					((Profiles) P).endYC, ((Profiles) P).endXC, 500,
					((Profiles) P).radius1 - ((Profiles) P).partDimB
							- ((Profiles) P).partDimA, ((Profiles) P).focal1X,
					((Profiles) P).focal1Y, false);

			// final double sa = ((Profiles) P).startAngleA;
			// final double base = ((Profiles) P).focal1X - ((Profiles)
			// P).myParent.startingX -
			// (((Profiles) P).myParent.widthPix/2);
			// final double theta = 180 - sa;
			//
			//
			// final double endYa = ((Profiles) P).focal1Y -
			// base*Math.tan(Math.toRadians(theta));
			// // endYa = Math.sqrt(Math.pow(((Profiles) P).radius1A, 2)
			// - Math.pow(base,2));
			endR = new Line2D.Double(((Profiles) P).endXC,
					((Profiles) P).endYC, ((Profiles) P).endXC, endYa);

		}
		GeneralPath mygp = new GeneralPath();

		if (type == 0) {
			mygp = gp;
		}
		if (type == 1) {
			mygp = gpB;
		}
		if (type == 2) {
			mygp = gpBA;
		}
		if (type == 3) {
			mygp = gpA;
		}
		if (endR != null) {

			// mygp.append(endR, false);

		}
		// mygp.append(fillArc(P, totalThick),
		// false);

		return mygp;
	}

	/**
	 * Create a GeneralPath for Arc from Profiles object. Calculate Start and
	 * End angle.
	 * 
	 * @param P
	 *            , Profiles parts object
	 * @param totalThick
	 *            , Total thick for arcs
	 * @return GeneralPath
	 */
	public GeneralPath fillArc(Object P, double totalThick) {

		final GeneralPath fill = new GeneralPath();

		for (double l = 0; l < totalThick; l += 0.1) {

			Arc2D.Double arcF = new Arc2D.Double(
					((Profiles) P).bkgrdStartX + l, ((Profiles) P).bkgrdStartY
							+ l, ((Profiles) P).bkgrdWidth - l - l,
					((Profiles) P).bkgrdHeight - l - l,
					((Profiles) P).startAngle, ((Profiles) P).endAngle,
					Arc2D.OPEN);

			if (((Profiles) P).x1 < ((Profiles) P).endXC
					&& ((Profiles) P).x1 > ((Profiles) P).startXC) {

				if (((Profiles) P).endTypeLT != 1
						&& ((Profiles) P).endTypeRB != 1) {

					double startAngle = ((Profiles) P).startAngle
							- (((Profiles) P).startAngle - Math
									.toDegrees(Math
											.acos((((Profiles) P).endXC - ((Profiles) P).x1)
													/ (((Profiles) P).radius1 - l))));

					double extent = ((Profiles) P).endAngle
							+ 180
							- (((Profiles) P).endAngle
									+ ((Profiles) P).startAngle - (((Profiles) P).startAngle - Math
									.toDegrees(Math
											.acos((((Profiles) P).endXC - ((Profiles) P).x1)
													/ (((Profiles) P).radius1 - l)))))
							- Math.toDegrees(Math
									.acos((((Profiles) P).x1 - ((Profiles) P).startXC)
											/ (((Profiles) P).radius1 - l)));

					if (Double.isNaN(startAngle)) {
						startAngle = ((Profiles) P).startAngle;
					}
					if (Double.isNaN(extent)) {
						extent = ((Profiles) P).endAngle;
					}

					arcF = new Arc2D.Double(((Profiles) P).bkgrdStartX + l,
							((Profiles) P).bkgrdStartY + l,
							((Profiles) P).bkgrdWidth - l - l,
							((Profiles) P).bkgrdHeight - l - l, startAngle,
							extent, Arc2D.OPEN);

				} else if (((Profiles) P).endTypeLT != 1
						&& ((Profiles) P).endTypeRB == 1) {

					double startAngle = ((Profiles) P).startAngle
							- (((Profiles) P).startAngle - Math
									.toDegrees(Math
											.acos((((Profiles) P).endXC - ((Profiles) P).x1)
													/ (((Profiles) P).radius1 - l))));
					double extent = ((Profiles) P).endAngle;

					if (Double.isNaN(startAngle)) {
						startAngle = ((Profiles) P).startAngle;
					}
					if (Double.isNaN(extent)) {
						extent = ((Profiles) P).endAngle;
					}
					arcF = new Arc2D.Double(((Profiles) P).bkgrdStartX + l,
							((Profiles) P).bkgrdStartY + l,
							((Profiles) P).bkgrdWidth - l - l,
							((Profiles) P).bkgrdHeight - l - l, startAngle,
							extent, Arc2D.OPEN);
				} else if (((Profiles) P).endTypeLT == 1
						&& ((Profiles) P).endTypeRB != 1) {

					double startAngle = ((Profiles) P).startAngle;
					double extent = ((Profiles) P).endAngle
							+ 180
							- (((Profiles) P).endAngle + ((Profiles) P).startAngle)
							- Math.toDegrees(Math
									.acos((((Profiles) P).x1 - ((Profiles) P).startXC)
											/ (((Profiles) P).radius1 - l)));

					if (Double.isNaN(startAngle)) {
						startAngle = ((Profiles) P).startAngle;
					}
					if (Double.isNaN(extent)) {
						extent = ((Profiles) P).endAngle;
					}
					arcF = new Arc2D.Double(((Profiles) P).bkgrdStartX + l,
							((Profiles) P).bkgrdStartY + l,
							((Profiles) P).bkgrdWidth - l - l,
							((Profiles) P).bkgrdHeight - l - l, startAngle,
							extent, Arc2D.OPEN);
				}
			}

			fill.append(arcF, false);
		}

		return fill;
	}

	public GeneralPath ellipsePart(final Object P, final double levelW,
			final double levelH, final int shapeID, final int type,
			final boolean doBA) {

		final boolean simple = false;
		final GeneralPath gp = new GeneralPath();
		final GeneralPath gpB = new GeneralPath();
		final GeneralPath gpBA = new GeneralPath();
		final GeneralPath gpA = new GeneralPath();
		// gp.moveTo(((Profiles) P).endXA,
		// ((Profiles)
		// P).endYA);
		if (!simple) {
			final Arc2D.Double arc1 = new Arc2D.Double(
					((Profiles) P).bkgrdStartX, ((Profiles) P).bkgrdStartY,
					((Profiles) P).bkgrdWidth, ((Profiles) P).bkgrdHeight, 0,
					180, Arc2D.OPEN);

			// gpB.append(arc1, false);

			xCoordB = new ArrayList();
			yCoordB = new ArrayList();
			this.getPoints(arc1, 1, ((Profiles) P));

			xCoordBo = xCoordB.toArray();
			yCoordBo = yCoordB.toArray();

			final GeneralPath polylineB = new GeneralPath(Path2D.WIND_EVEN_ODD,
					xCoordBo.length);
			new GeneralPath(Path2D.WIND_EVEN_ODD, xCoordBo.length);
			new GeneralPath(Path2D.WIND_EVEN_ODD, xCoordBo.length);

			for (int i = xCoordBo.length; i >= 1; i--) {

				polylineB
						.moveTo(((Double) xCoordBo[0]), ((Double) yCoordBo[0]));
				break;

			}

			for (int i = xCoordBo.length; i >= 1; i--) {
				if ((Double) xCoordBo[i - 1] >= 0) {
					polylineB.lineTo(((Double) xCoordBo[i - 1]),
							((Double) yCoordBo[i - 1]));
				}
			}
			;

			final GeneralPath fillPath = new GeneralPath();

			if (shapeID == 402 && !rightIn) {

				for (int l = 0; l < ((Profiles) P).partDimB
						+ ((Profiles) P).partDimA; l++) {
					gp.append(this.ellipse2BAalt(l, ((Profiles) P).startXC + l,
							((Profiles) P).startYC + l, ((Profiles) P).endXC,
							((Profiles) P).endYC, 0, 1, shapeID,
							((Profiles) P), leftInf, rightInf), false);
				}
			} else if (shapeID == 402 && rightIn) {

				for (int l = 0; l < ((Profiles) P).partDimB
						+ ((Profiles) P).partDimA; l++) {
					gp.append(this.ellipse2BAalt(l, ((Profiles) P).startXC + l,
							((Profiles) P).startYC + l, ((Profiles) P).endXC
									- l, ((Profiles) P).endYC, 0, 1, shapeID,
							((Profiles) P), leftInf, rightInf), false);
				}
			} else if (shapeID == 401) {
				for (int l = 0; l < ((Profiles) P).partDimB
						+ ((Profiles) P).partDimA; l++) {
					gp.append(this.ellipse2BAalt(l, ((Profiles) P).startXC + l,
							((Profiles) P).startYC, ((Profiles) P).endXC - l,
							((Profiles) P).endYC - l, 0, 1, shapeID,
							((Profiles) P), leftInf, rightInf), false);
				}
			} else if (shapeID == 403) {
				for (int l = 0; l < ((Profiles) P).partDimB
						+ ((Profiles) P).partDimA; l++) {
					gp.append(this.ellipse2BAalt(l, ((Profiles) P).startXC + l,
							((Profiles) P).startYC + l, ((Profiles) P).endXC
									- l, ((Profiles) P).endYC - l, 0, 1,
							shapeID, ((Profiles) P), leftInf, rightInf), false);
				}
			} else if (shapeID == 400 || shapeID >= 801) {
				for (int l = 0; l < ((Profiles) P).partDimB
						+ ((Profiles) P).partDimA; l++) {
					gp.append(this.ellipse2BAalt(l, ((Profiles) P).startXC + l,
							((Profiles) P).startYC, ((Profiles) P).endXC,
							((Profiles) P).endYC, 0, 1, shapeID,
							((Profiles) P), leftInf, rightInf), false);
				}
			}

			((Profiles) P).fillShape.append(fillPath, false);

			gpB.append(this.ellipse2BAalt(0, ((Profiles) P).startXC,
					((Profiles) P).startYC, ((Profiles) P).endXC,
					((Profiles) P).endYC, 1, 1, shapeID, ((Profiles) P),
					leftInf, rightInf), false);
			if (doBA) {
				gpBA.append(this.ellipse2BAalt(((Profiles) P).partDimB,
						((Profiles) P).startXBA, ((Profiles) P).startYBA,
						((Profiles) P).endXBA, ((Profiles) P).endYBA, 2, 1,
						shapeID, ((Profiles) P), leftInf, rightInf), false);
			}
			gpA.append(this.ellipse2BAalt(
					(((Profiles) P).partDimB + ((Profiles) P).partDimA),
					((Profiles) P).startXA, ((Profiles) P).startYA,
					((Profiles) P).endXA, ((Profiles) P).endYA, 3, 1, shapeID,
					((Profiles) P), leftInf, rightInf), false);

		} else {
			for (double l = 0; l < ((Profiles) P).partDimB
					+ ((Profiles) P).partDimA; l += 1) {
				final Arc2D.Double arcF = new Arc2D.Double(
						((Profiles) P).bkgrdStartX + l,
						((Profiles) P).bkgrdStartY + l,
						((Profiles) P).bkgrdWidth - l - l,
						((Profiles) P).bkgrdHeight - l - l,
						((Profiles) P).startAngle, ((Profiles) P).endAngle,
						Arc2D.OPEN);
				gp.append(arcF, false);
			}

			arcB = new Arc2D.Double(((Profiles) P).bkgrdStartX,
					((Profiles) P).bkgrdStartY, ((Profiles) P).bkgrdWidth,
					((Profiles) P).bkgrdHeight, ((Profiles) P).startAngle,
					((Profiles) P).endAngle, Arc2D.OPEN);
			gpB.append(arcB, false);
			// gp.append(arcB, false);
			Arc2D.Double arcF = new Arc2D.Double(
					((Profiles) P).bkgrdStartX + ((Profiles) P).partDimA
							+ ((Profiles) P).partDimB,
					((Profiles) P).bkgrdStartY + ((Profiles) P).partDimA
							+ ((Profiles) P).partDimB,
					((Profiles) P).bkgrdWidth
							- (((Profiles) P).partDimA + ((Profiles) P).partDimB)
							- (((Profiles) P).partDimA + ((Profiles) P).partDimB),
					((Profiles) P).bkgrdHeight
							- (((Profiles) P).partDimA + ((Profiles) P).partDimB)
							- (((Profiles) P).partDimA + ((Profiles) P).partDimB),
					((Profiles) P).startAngle, ((Profiles) P).endAngle,
					Arc2D.OPEN);

			gpA.append(arcF, false);
			arcF = new Arc2D.Double(((Profiles) P).bkgrdStartX
					+ ((Profiles) P).partDimB, ((Profiles) P).bkgrdStartY
					+ ((Profiles) P).partDimB, ((Profiles) P).bkgrdWidth
					- ((Profiles) P).partDimB - ((Profiles) P).partDimB,
					((Profiles) P).bkgrdHeight - ((Profiles) P).partDimB
							- ((Profiles) P).partDimB,
					((Profiles) P).startAngle, ((Profiles) P).endAngle,
					Arc2D.OPEN);
			gpBA.append(arcF, false);
		}
		if (shapeID != 802) {
			endL = new Line2D.Double(((Profiles) P).startXA,
					((Profiles) P).startYA, ((Profiles) P).startXC,
					((Profiles) P).startYC);

			endR = new Line2D.Double(((Profiles) P).endXC,
					((Profiles) P).endYC, ((Profiles) P).endXA,
					((Profiles) P).endYA);
		} else if (shapeID == 802) {
			endL = new Line2D.Double(
					((Profiles) P).startingX + levelW / 2,
					((Profiles) P).startingY + levelH,
					((Profiles) P).startingX + levelW / 2,
					((Profiles) P).startingY
							+ levelH
							- (((Profiles) P).partDimA + ((Profiles) P).partDimB));

			endR = new Line2D.Double(((Profiles) P).startingX + levelW / 2,
					((Profiles) P).startingY, ((Profiles) P).startingX + levelW
							/ 2, ((Profiles) P).startingY
							+ ((Profiles) P).partDimA + ((Profiles) P).partDimB);
		}
		gp.append(endL, false);
		gp.append(endR, false);

		GeneralPath mygp = new GeneralPath();
		if (type == 0) {
			mygp = gp;
		}
		if (type == 1) {
			mygp = gpB;
		}
		if (type == 2) {
			mygp = gpBA;
		}
		if (type == 3) {
			mygp = gpA;
		}
		return mygp;
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

	public GeneralPath ellipse2BAalt(final double distance,
			final double movetoX, final double movetoY, final double endX,
			final double endY, final int lineNo, final int topBot,
			final int shapeID, final Profiles P, final boolean leftIn,
			final boolean rightIn) {// 1=top

		// 2
		// =
		// bot
		double xs = 0;
		double ys = 0;
		double myNewY = 0;
		double myNewX = 0;
		xCoordBA = new ArrayList();
		yCoordBA = new ArrayList();
		double lastX = 100000000;
		final double t = 0;
		final int startXCompare = (int) movetoX;
		final int endXCompare = (int) endX;
		int xCompare = (int) movetoX;

		for (int i = 0; i < xCoordBo.length; i++) {
			xs = (Double) xCoordBo[i];
			xCompare = (int) xs;
			ys = (Double) yCoordBo[i];// p+
			// ((Profiles)
			// P).startingX

			if (shapeID == 401 && !leftInf) {
				if ((Double) xCoordBo[i] <= endX) {
					if ((Double) xCoordBo[i] >= 0) {

						if (xs == P.parentW + P.startingX) {
							myNewY = ys;
							myNewX = xs - distance;
						} else if (xs == P.startXC) {
							myNewY = ys;
							myNewX = xs + distance;
						} else if (xs == (P.parentW + P.startingX) / 2) {
							myNewY = ys + distance;
							myNewX = xs;
						} else if (xs < P.startingX + P.parentW / 2
								&& xs > P.startXC) {
							if (i > 0) {
								final double slopeLine = ((Double) xCoordBo[i - 1] - (Double) xCoordBo[i])
										/ ((Double) yCoordBo[i - 1] - (Double) yCoordBo[i]);
								final double slopePerp = -1 / slopeLine;
								final double thetaSlopeLine = Math
										.atan(slopePerp);
								final double deltaYS = distance
										* Math.cos(thetaSlopeLine);
								final double deltaXS = distance
										* Math.sin(thetaSlopeLine);
								myNewY = ys + deltaYS;
								myNewX = xs + deltaXS;
								if (myNewX > P.endXC) {
									myNewX = P.endXC;
								}
								if (myNewX == P.startXC) {
									myNewY = P.startYC;

								}

							}
						}
						if (myNewX > 0) {
							if (myNewX != lastX) {
								xCoordBA.add(myNewX);
								yCoordBA.add(myNewY);
								lastX = myNewX;

								if (Math.abs(xCompare - endXCompare) <= t
										&& lineNo == 2) {
									P.endYBA = myNewY;
									// System.out.printf("\n 401 L out BA myX ="
									// +
									// myNewX + " myY =" +
									// myNewY);
								} else if (Math.abs(xCompare - endXCompare) <= t
										&& lineNo == 3) {
									P.endYA = myNewY;
								}
							}

						}

					}

				}
			}
			if (shapeID == 401 && leftInf) {
				if ((Double) xCoordBo[i] <= endX
						&& (Double) xCoordBo[i] >= movetoX) {
					if ((Double) xCoordBo[i] >= 0) {

						if (i > 0) {
							final double slopeLine = ((Double) xCoordBo[i - 1] - (Double) xCoordBo[i])
									/ ((Double) yCoordBo[i - 1] - (Double) yCoordBo[i]);
							final double slopePerp = -1 / slopeLine;
							final double thetaSlopeLine = Math.atan(slopePerp);
							final double deltaYS = distance
									* Math.cos(thetaSlopeLine);
							final double deltaXS = distance
									* Math.sin(thetaSlopeLine);
							myNewY = ys + deltaYS;
							myNewX = xs + deltaXS;
							if (myNewX > P.endXC) {
								myNewX = P.endXC;
							}
							if (myNewX == P.startXC) {
							}
						}

						if (myNewX > 0) {
							if (myNewX != lastX) {
								xCoordBA.add(myNewX);
								yCoordBA.add(myNewY);
								lastX = myNewX;
								if (Math.abs(xCompare - startXCompare) <= t
										&& lineNo == 2) {
									P.startYBA = myNewY;
									// System.out
									// .printf("\n  401 Left in  BA myX ="
									// +
									// myNewX + " myY ="
									// +
									// myNewY);
								} else if (Math.abs(xCompare - startXCompare) <= t
										&& lineNo == 3) {
									P.startYA = myNewY;
								}
								if (Math.abs(xCompare - endXCompare) <= t
										&& lineNo == 2) {
									P.endYBA = myNewY;
									// System.out.printf("\n END 401 in BA myX ="
									// +
									// myNewX + " myY =" +
									// myNewY);
								} else if (Math.abs(xCompare - endXCompare) <= t
										&& lineNo == 3) {
									P.endYA = myNewY;
								}
							}

						}
					}

				}
			} else if (shapeID == 402 && !rightInf) {
				if ((Double) xCoordBo[i] >= movetoX) {
					if ((Double) xCoordBo[i] >= 0) {

						if (xs == P.parentW + P.startingX) {
							myNewY = ys;
							myNewX = xs - distance;
						} else if (xs == P.startXC) {
							myNewY = ys;
							myNewX = xs + distance;
						} else if (xs == (P.parentW + P.startingX) / 2) {
							myNewY = ys + distance;
							myNewX = xs;
						} else if (xs > P.startingX + P.parentW / 2) {// &&
							// xs
							// <=
							// ((Profiles)
							// P).parentW+((Profiles)
							// P).startingX){
							if (i > 0) {
								// m=
								// y2-y1/x2-x1
								final double slopeLine = ((Double) xCoordBo[i] - (Double) xCoordBo[i - 1])
										/ ((Double) yCoordBo[i] - (Double) yCoordBo[i - 1]);
								final double thetaSlopeLine = Math
										.atan(slopeLine);
								final double alphaSlopeLine = Math
										.toRadians(90) - thetaSlopeLine;
								final double deltaYS = distance
										* Math.cos(alphaSlopeLine);
								final double deltaXS = distance
										* Math.sin(alphaSlopeLine);

								myNewY = ys + deltaYS;
								myNewX = xs - deltaXS;

								if (myNewX < movetoX) {
									myNewX = movetoX;
								}

							}

						} else if (xs < P.startingX + P.parentW / 2
								&& xs > P.startXC) {
							if (i > 0) {
								final double slopeLine = ((Double) xCoordBo[i - 1] - (Double) xCoordBo[i])
										/ ((Double) yCoordBo[i - 1] - (Double) yCoordBo[i]);
								final double slopePerp = -1 / slopeLine;
								final double thetaSlopeLine = Math
										.atan(slopePerp);
								final double deltaYS = distance
										* Math.cos(thetaSlopeLine);
								final double deltaXS = distance
										* Math.sin(thetaSlopeLine);
								myNewY = ys + deltaYS;
								myNewX = xs + deltaXS;
								if (myNewX > P.endXC) {
									myNewX = P.endXC;
								}
								if (myNewX == P.startXC) {
									myNewY = P.startYC;
								}

							}
						}
						if (myNewX > 0) {
							if (myNewX != lastX) {
								xCoordBA.add(myNewX);
								yCoordBA.add(myNewY);
								lastX = myNewX;
								if (Math.abs(xCompare - startXCompare) <= t
										&& lineNo == 2) {
									P.startYBA = myNewY;
								} else if (Math.abs(xCompare - startXCompare) <= t
										&& lineNo == 3) {
									P.startYA = myNewY;
								}

							}

						}
					}

				}
			} else if (shapeID == 402 && rightInf) {
				if ((Double) xCoordBo[i] <= endX) {
					if ((Double) xCoordBo[i] >= 0) {

						if (xs == P.parentW + P.startingX) {
							myNewY = ys;
							myNewX = xs - distance;
						} else if (xs == P.startXC) {
							myNewY = ys;
							myNewX = xs + distance;
						} else if (xs == (P.parentW + P.startingX) / 2) {
							myNewY = ys + distance;
							myNewX = xs;
						} else if (xs > P.startingX + P.parentW / 2) {// &&
							// xs
							// <=
							// ((Profiles)
							// P).parentW+((Profiles)
							// P).startingX){
							if (i > 0) {
								// m=
								// y2-y1/x2-x1
								final double slopeLine = ((Double) xCoordBo[i] - (Double) xCoordBo[i - 1])
										/ ((Double) yCoordBo[i] - (Double) yCoordBo[i - 1]);
								final double thetaSlopeLine = Math
										.atan(slopeLine);
								final double alphaSlopeLine = Math
										.toRadians(90) - thetaSlopeLine;
								final double deltaYS = distance
										* Math.cos(alphaSlopeLine);
								final double deltaXS = distance
										* Math.sin(alphaSlopeLine);

								myNewY = ys + deltaYS;
								myNewX = xs - deltaXS;

								if (myNewX < movetoX) {
									myNewX = movetoX;
								}

							}

						} else if (xs < P.startingX + P.parentW / 2
								&& xs > P.startXC) {
							if (i > 0) {
								final double slopeLine = ((Double) xCoordBo[i - 1] - (Double) xCoordBo[i])
										/ ((Double) yCoordBo[i - 1] - (Double) yCoordBo[i]);
								final double slopePerp = -1 / slopeLine;
								final double thetaSlopeLine = Math
										.atan(slopePerp);
								final double deltaYS = distance
										* Math.cos(thetaSlopeLine);
								final double deltaXS = distance
										* Math.sin(thetaSlopeLine);
								myNewY = ys + deltaYS;
								myNewX = xs + deltaXS;
								if (myNewX > P.endXC) {
									myNewX = P.endXC;
								}
								if (myNewX == P.startXC) {
									myNewY = P.startYC;
								}

							}
						}
						if (myNewX > 0) {
							if (myNewX != lastX) {
								xCoordBA.add(myNewX);
								yCoordBA.add(myNewY);
								lastX = myNewX;
								if (Math.abs(xCompare - startXCompare) <= t
										&& lineNo == 2) {
									P.startYBA = myNewY;
								} else if (Math.abs(xCompare - startXCompare) <= t
										&& lineNo == 3) {
									P.startYA = myNewY;
								}
								if (Math.abs(xCompare - endXCompare) <= t
										&& lineNo == 2) {
									P.endYBA = myNewY;
								} else if (Math.abs(xCompare - endXCompare) <= t
										&& lineNo == 3) {
									P.endYA = myNewY;
								}
							}

						}
					}

				}
			} else if (shapeID == 403) {
				if ((Double) xCoordBo[i] <= endX
						&& (Double) xCoordBo[i] >= movetoX) {
					if ((Double) xCoordBo[i] >= 0) {

						if (xs == P.parentW + P.startingX) {
							myNewY = ys;
							myNewX = xs - distance;
						} else if (xs == P.startXC) {
							myNewY = ys;
							myNewX = xs + distance;
						} else if (xs == (P.parentW + P.startingX) / 2) {
							myNewY = ys + distance;
							myNewX = xs;
						} else if (xs > P.startingX + P.parentW / 2) {// &&
							// xs
							// <=
							// ((Profiles)
							// P).parentW+((Profiles)
							// P).startingX){
							if (i > 0) {
								// m=
								// y2-y1/x2-x1
								final double slopeLine = ((Double) xCoordBo[i] - (Double) xCoordBo[i - 1])
										/ ((Double) yCoordBo[i] - (Double) yCoordBo[i - 1]);
								final double thetaSlopeLine = Math
										.atan(slopeLine);
								final double alphaSlopeLine = Math
										.toRadians(90) - thetaSlopeLine;
								final double deltaYS = distance
										* Math.cos(alphaSlopeLine);
								final double deltaXS = distance
										* Math.sin(alphaSlopeLine);

								myNewY = ys + deltaYS;
								myNewX = xs - deltaXS;

								if (myNewX < movetoX) {
									myNewX = movetoX;
								}

							}

						} else if (xs < P.startingX + P.parentW / 2
								&& xs > P.startXC) {
							if (i > 0) {
								final double slopeLine = ((Double) xCoordBo[i - 1] - (Double) xCoordBo[i])
										/ ((Double) yCoordBo[i - 1] - (Double) yCoordBo[i]);
								final double slopePerp = -1 / slopeLine;
								final double thetaSlopeLine = Math
										.atan(slopePerp);
								final double deltaYS = distance
										* Math.cos(thetaSlopeLine);
								final double deltaXS = distance
										* Math.sin(thetaSlopeLine);
								myNewY = ys + deltaYS;
								myNewX = xs + deltaXS;
								if (myNewX > P.endXC) {
									myNewX = P.endXC;
								}
								if (myNewX == P.startXC) {
									myNewY = P.startYC;
								}

							}
						}
						if (myNewX > 0) {
							if (myNewX != lastX) {
								xCoordBA.add(myNewX);
								yCoordBA.add(myNewY);
								lastX = myNewX;
								if (Math.abs(xCompare - startXCompare) <= t
										&& lineNo == 2) {
									P.startYBA = myNewY;
								} else if (Math.abs(xCompare - startXCompare) <= t
										&& lineNo == 3) {
									P.startYA = myNewY;
								}
								if (Math.abs(xCompare - endXCompare) <= t
										&& lineNo == 2) {
									P.endYBA = myNewY;
								} else if (Math.abs(xCompare - endXCompare) <= t
										&& lineNo == 3) {
									P.endYA = myNewY;
								}
							}

						}
					}

				}
			} else if ((shapeID == 400 || shapeID >= 801) && topBot == 1) {
				if ((Double) xCoordBo[i] >= 0) {

					if (xs == P.parentW + P.startingX) {
						myNewY = ys;
						myNewX = xs - distance;
					} else if (xs == P.startXC) {
						myNewY = ys;
						myNewX = xs + distance;
					} else if (xs == (P.parentW + P.startingX) / 2) {
						myNewY = ys + distance;
						myNewX = xs;
					} else if (xs > P.startingX + P.parentW / 2) {// &&
						// xs
						// <=
						// ((Profiles)
						// P).parentW+((Profiles)
						// P).startingX){
						if (i > 0) {
							// m=
							// y2-y1/x2-x1
							final double slopeLine = ((Double) xCoordBo[i] - (Double) xCoordBo[i - 1])
									/ ((Double) yCoordBo[i] - (Double) yCoordBo[i - 1]);
							final double thetaSlopeLine = Math.atan(slopeLine);
							final double alphaSlopeLine = Math.toRadians(90)
									- thetaSlopeLine;
							final double deltaYS = distance
									* Math.cos(alphaSlopeLine);
							final double deltaXS = distance
									* Math.sin(alphaSlopeLine);

							myNewY = ys + deltaYS;
							myNewX = xs - deltaXS;

							if (myNewX < movetoX) {
								myNewX = movetoX;
							}

						}

					} else if (xs < P.startingX + P.parentW / 2
							&& xs > P.startXC) {
						if (i > 0) {
							final double slopeLine = ((Double) xCoordBo[i - 1] - (Double) xCoordBo[i])
									/ ((Double) yCoordBo[i - 1] - (Double) yCoordBo[i]);
							final double slopePerp = -1 / slopeLine;
							final double thetaSlopeLine = Math.atan(slopePerp);
							final double deltaYS = distance
									* Math.cos(thetaSlopeLine);
							final double deltaXS = distance
									* Math.sin(thetaSlopeLine);
							myNewY = ys + deltaYS;
							myNewX = xs + deltaXS;
							if (myNewX > P.endXC) {
								myNewX = P.endXC;
							}
							if (myNewX == P.startXC) {
								myNewY = P.startYC;
							}

						}
					}
					if (myNewX > 0) {
						if (myNewX != lastX) {
							xCoordBA.add(myNewX);
							yCoordBA.add(myNewY);
							lastX = myNewX;

						}

					}
				}
			}// /////
			else if (shapeID >= 801 && topBot == 2) {
				if ((Double) xCoordBo[i] >= 0) {
					if (xs < P.endXC + levelW / 2) {
						if (i > 0) {
							double slopeLine = ((Double) xCoordBo[i] - (Double) xCoordBo[i - 1])
									/ ((Double) yCoordBo[i] - (Double) yCoordBo[i - 1]);
							if (Double.isNaN(slopeLine)) {
								slopeLine = 0;
							}
							final double thetaSlopeLine = Math.atan(slopeLine);
							final double alphaSlopeLine = Math.toRadians(90)
									- thetaSlopeLine;
							final double deltaYS = distance
									* Math.cos(alphaSlopeLine);
							final double deltaXS = distance
									* Math.sin(alphaSlopeLine);
							myNewY = ys - deltaYS;
							myNewX = xs + deltaXS;
						}
					}
					if (xs > P.endXC + levelW / 2) {
						if (i > 0) {
							final double slopeLine = ((Double) xCoordBo[i] - (Double) xCoordBo[i - 1])
									/ ((Double) yCoordBo[i] - (Double) yCoordBo[i - 1]);
							final double thetaSlopeLine = Math.atan(slopeLine);
							final double alphaSlopeLine = Math.toRadians(90)
									- thetaSlopeLine;
							final double deltaYS = distance
									* Math.cos(alphaSlopeLine);
							final double deltaXS = distance
									* Math.sin(alphaSlopeLine);
							myNewY = ys + deltaYS;
							myNewX = xs - deltaXS;
						}
					}
					if (xs == P.parentW + P.startingX) {
						myNewY = ys;
						myNewX = xs - distance;
					} else if (xs == P.startXC) {
						myNewY = ys;
						myNewX = xs + distance;
					} else if (xs == (P.myParent.widthPix + P.startingX) / 2) {
						myNewY = ys - distance;
						myNewX = xs;
					}

					if (myNewX > 0) {
						if (myNewX != lastX) {
							xCoordBA.add(myNewX);
							yCoordBA.add(myNewY);
							lastX = myNewX;
							System.out.printf("\n 801 myX =" + myNewX
									+ " myY =" + myNewY);
						}

					}
					// /
				}
			}// 801 bot

		}

		xCoordBoBA = xCoordBA.toArray();
		yCoordBoBA = yCoordBA.toArray();
		final GeneralPath polylineBA = new GeneralPath(Path2D.WIND_EVEN_ODD,
				xCoordBoBA.length);
		for (int i = xCoordBoBA.length; i >= 1; i--) {
			polylineBA.moveTo((Double) xCoordBoBA[0], ((Double) yCoordBoBA[0]));
		}
		for (int i = xCoordBoBA.length; i >= 1; i--) {
			if ((Double) xCoordBo[i - 1] >= 0) {
				polylineBA.lineTo(((Double) xCoordBoBA[i - 1]),
						((Double) yCoordBoBA[i - 1]));

			}
		}
		;

		return polylineBA;

	}

	public void getPoints(final Arc2D.Double arc, final int topBot,
			final Profiles P) {

		final double flatness = 0.000001f;
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
						if (myX >= P.startXC) {

							xCoordB.add(myX);
							yCoordB.add(myY);
						}
					} else {
						if (myX <= P.startXC) {

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

	public Profiles topArc1B(final ShapeObject myShape) { // int

		// =1
		// Arc
		// normal,
		// 2
		// start at 90, 3 end at 90
		partForm = 2;
		myWidth = endXC - startXC;
		radianCentralAngle = 2 * Math.atan(myWidth / 2 / (y1 - endYC));
		centralAngle = Math.toDegrees(radianCentralAngle); // in

		x2 = endXC;
		y2 = endYC;

		rrSlope = (x2 - x1) / (y2 - y1);
		rrAngle = Math.abs(Math.atan(1 / rrSlope));
		rlSlope = (x1 - startXC) / (y1 - startYC);// /
		rlAngle = Math.abs(Math.atan(1 / rlSlope));
		double radiansStart = Math.abs(Math.atan((x2 - x1) / (y2 - y1)));
		radiansStart = Math.abs(Math.toDegrees(radianCentralAngle));
		startAngle = Math.abs((180 - radiansStart)) / 2;
		endAngle = Math.abs(centralAngle);

		if (endTypeRB != 3) {
			focal1X = startXC + myWidth / 2;
			focal1Y = startYC
					+ Math.sqrt(Math.pow(radius1, 2) - Math.pow(myWidth / 2, 2));
			focal2X = focal1X;
			focal2Y = focal1Y;

		} else {
			focal1X = startXC + (endXC - startXC) / 2;
			focal1Y = startYC
					+ Math.sqrt(Math.pow(radius1, 2)
							- Math.pow((endXC - startXC) / 2, 2));
			focal2X = focal1X;
			focal2Y = focal1Y;

		}
		length = 2 * Math.PI * radius1 * centralAngle / 360;

		this.toparc2BA(myShape);
		this.toparc3A(myShape);

		return this;
	}

	public void toparc2BA(final ShapeObject myShape) { // int

		// =1
		// Arc
		// normal,
		// 2
		// start
		// at
		// 90,
		// 3
		// end
		// at

		partForm = 2;
		myWidthBA = endXBA - startXBA;
		final double theta = 180 - startAngle - endAngle;
		if (endTypeRB == 1 || endTypeRB == 0) {
			startXBA = startXC + partDimB + partDimC;
			startYBA = startYC + partDimB + partDimC;
		} else if (endTypeRB == 2) {
			startXBA = startXC;
			startYBA = startYC + partDimB + partDimC / Math.sin(theta);
		} else {
			startXBA = startXC
					+ (myShape.left.partDimB + myShape.left.partDimC
							+ myShape.right.partDimB + myShape.right.partDimC)
					/ Math.tan(theta);
			startYBA = startYC + partDimB + partDimC / Math.sin(theta);
		}

		double radiansStart = Math.abs(Math.acos(myWidthBA / 2 / radius1BA));

		endXBA = startXBA + myWidthBA;

		final double YfromBottom = Math.abs(myWidthBA / 2
				* Math.tan(radiansStart));

		startYBA = y1BA - YfromBottom;// ((double)
		// Math.tan(radiansStart)*

		endYBA = startYBA;

		radiansStart = Math.abs(Math.toDegrees(radiansStart));
		dimB1B = radius1BA - YfromBottom;
		radianCentralAngle = Math.atan(myWidthBA / 2 / dimB1B);
		centralAngleBA = Math.abs(Math.toDegrees(radianCentralAngle));
		startAngleBA = Math.abs(radiansStart);
		endAngleBA = Math.abs(180 - 2 * radiansStart);

		lengthBA = 2 * Math.PI * radius1BA * centralAngleBA / 360;// 2PIr*CentralAngle/360

	}

	public void toparc3A(final ShapeObject myShape) { // int

		// =1
		// Arc
		// normal,
		// 2
		// start at 90, 3 end at
		// ninety
		myWidthA = endXA - startXA;
		partForm = 2;
		final double theta = 180 - startAngle - endAngle;
		if (endTypeRB == 1 || endTypeRB == 0) {
			startXA = startXBA + partDimA;
			startYA = startYBA + partDimA;
		} else if (endTypeRB == 2) {
			startXA = startXC;
			startYA = startYBA + partDimA / Math.sin(theta);
		} else {
			startXA = startXC
					+ (myShape.left.partDimB + myShape.right.partDimB
							+ myShape.left.partDimA + myShape.right.partDimA)
					/ Math.tan(theta);
			startYA = startYC + (partDimB + partDimA) / Math.sin(theta);
		}

		double radiansStart = Math.acos(myWidthA / 2 / radius1A);

		endXA = startXA + myWidthA;

		final double YfromBottom = Math.abs(myWidthA / 2
				* Math.tan(radiansStart));

		startYA = y1A - YfromBottom;
		endYA = startYA;

		radiansStart = Math.abs(Math.toDegrees(radiansStart));
		dimB1A = radius1A - YfromBottom;

		radianCentralAngle = Math.atan(myWidthA / 2 / dimB1A);
		centralAngleA = Math.abs(Math.toDegrees(radianCentralAngle));

		startAngleA = Math.abs(radiansStart);
		endAngleA = Math.abs(180 - 2 * radiansStart);// centralAngleA;

		lengthA = 2 * Math.PI * radius1A * centralAngleA / 360;

		radius2A = 0;
		ltAngle = Math.atan((endXC - endXA) / (endYC - endYA));
		rbAngle = Math.atan((startXC - startXA) / (startYC - startYA));

	}

	public void topArcBegin901B(final ShapeObject myShape) {

		partForm = 2;

		myWidth = endXC - startXC;

		x2 = endXC;
		y2 = endYC;
		radianCentralAngle = Math.abs(2 * Math.atan(myWidth * 2 / 2
				/ (y1 - endYC)));

		centralAngle = Math.abs(Math.toDegrees(radianCentralAngle)); // in

		rrSlope = (x2 - x1) / (y2 - y1);
		rrAngle = Math.abs(Math.atan(1 / rrSlope));
		rlSlope = (x1 - startXC) / (y1 - startYC);// /
		rlAngle = Math.abs(Math.atan(1 / rlSlope));

		rbAngle = rlAngle;

		double radiansStart = Math.atan((x2 - x1) / (y2 - y1));
		radiansStart = Math.toDegrees(radianCentralAngle);

		startAngle = (180 - radiansStart) / 2;// centralAnglet1;//radiansStart;//radiansStart;

		endAngle = Math.abs(centralAngle / 2);

		focal1X = startXC;// + myShape.wT /
		// 2;
		focal1Y = startYC;
		focal2X = focal1X;
		focal2Y = focal1Y;
		bkgrdStartX = focal1X - radius1;
		bkgrdStartY = focal1Y;// -
		// radius1;

		length = 2 * Math.PI * radius1 * centralAngle / 360;// 2PIr*CentralAngle/360
		radius2 = 0;
	}

	public void topArcBegin902BA(final ShapeObject myShape) {

		partForm = 2;

		myWidthBA = endXBA - startXBA;

		double radiansStart = 0;
		double YfromBottom = 0;
		if (myShape.shapeID == 205 || myShape.shapeID == 305) {
			radiansStart = Math
					.asin((myShape.bot1.partDimB + radius1 - myShape.heightPix)
							/ radius1BA);
			YfromBottom = myShape.bot1.partDimB + radius1 - myShape.heightPix;
			// this.endYBA = this.startingYBA +
			// (this.radius1BA -
			// YfromBottom);// this.startYBA;

			final double base = Math
					.sqrt(Math.pow(radius1BA, 2)
							- Math.pow(
									(myShape.bot1.partDimB + radius1 - myShape.heightPix),
									2));
			endXBA = x1 + base;
			endYBA = startingY + radius1
					- (myShape.bot1.partDimB + radius1 - myShape.heightPix);

			radsStartBA = radiansStart;
			final double radiansStart2 = Math.acos(partDimB / radius1BA);
			radsStart2BA = radiansStart2;
			radianCentralAngle = radiansStart2 - radiansStart;
			startXBA = startingXBA;// ingXBA;

			YfromBottom = Math.abs((myWidth - partDimB)
					* Math.tan(radiansStart));
			final double YfromBottom2 = Math.abs(partDimB
					* Math.tan(radiansStart2));
			startXBA = startingXBA;// startingXBA
			// ;//ingXBA;

			startYBA = startingYBA + radius1BA - YfromBottom2;// ((double)
			// Math.tan(radiansStart)*

			radiansStart = Math.toDegrees(radiansStart);
			centralAngleBA = Math.toDegrees(radianCentralAngle); // in
			// degrees
			startAngleBA = radiansStart;// (180
			// -
			// radiansStart) /
			// 2;//
			// centralAnglet1;//radiansStart;//radiansStart;
			endAngleBA = centralAngleBA;// /2;//180
			// -
			// (2*radiansStart);//centralAngleBA;

			lengthBA = 2 * Math.PI * radius1BA * centralAngleBA / 360;
			radius2BA = 0;
		} else {
			startingXBA = startingX + myShape.left.partDimB;
			myWidthBA = myWidth - myShape.right.partDimB
					- myShape.left.partDimB;
			startXBA = startingX + myShape.left.partDimB;
			endXBA = endXC - myShape.right.partDimB;

			radius1BA = radius1 - partDimB;

			radiansStart = 0;
			YfromBottom = 0;
			if (myShape.shapeID == 205 || myShape.shapeID == 305) {
				final double deltaStartY = myShape.startingY
						- myShape.parentStartY;
				radiansStart = Math
						.asin((myShape.bot1.partDimB + radius1 - (myShape.heightPix + deltaStartY))
								/ radius1BA);// (x2BA
				// -
				// x1BA) /
				// (y2BA -
				// y1BA));
				YfromBottom = myShape.bot1.partDimB + radius1
						- (myShape.heightPix + deltaStartY);
				// this.endYBA =
				// this.startingYBA +
				// (this.radius1BA -
				// YfromBottom);//
				// this.startYBA;

				final double base = Math
						.sqrt(Math.pow(radius1BA, 2)
								- Math.pow(
										(myShape.bot1.partDimB + radius1 - (myShape.heightPix + deltaStartY)),
										2));
				endXBA = x1 + base;
				endYBA = startingY
						+ radius1
						- (myShape.bot1.partDimB + radius1 - (myShape.heightPix + deltaStartY));

			} else {
				radiansStart = Math.acos((startingX + myWidth
						- myShape.centerPointX - myShape.right.partDimB)
						/ radius1BA);
				YfromBottom = Math.abs((myWidth - partDimB)
						* Math.tan(radiansStart));
				endYBA = startingYBA + radius1BA - YfromBottom;// this.startYBA;
			}

			radsStartBA = radiansStart;

			// double radiansStart2 =
			// (double)
			// Math.acos(((startingX-myShape.centerPointX)+
			// myShape.left.partDimB)/radius1BA);//(x2A
			// -
			// x1A) / (y2A
			// - y1A));
			//
			final double radiansStart2 = Math.acos((startingX
					- myShape.centerPointX + myShape.left.partDimB)
					/ radius1BA);// (x2A
			// - x1A) /
			// (y2A - y1A));

			radsStart2BA = radiansStart2;
			radianCentralAngle = radiansStart2 - radiansStart;

			// double YfromBottom =
			// (double)
			// Math.abs((((startingX-myShape.centerPointX)+myShape.wT
			// -
			// myShape.right.partDimB))*(double)
			// Math.tan(radiansStart));
			//
			// double YfromBottom2 =
			// (double)
			// Math.abs((((startingX-myShape.centerPointX)+
			// myShape.left.partDimB))*(double)
			// Math.tan(radiansStart2));
			//
			// this.startYBA =
			// this.startingYBA+this.radius1BA -
			// YfromBottom2;//((double)
			// Math.tan(radiansStart)*
			// this.startX)+
			// interceptofRL;
			// this.endYBA =
			// this.startingYBA+(this.radius1BA
			// -
			// YfromBottom);//this.startYBA;

			radiansStart = Math.toDegrees(radiansStart);
			// this.dimB1B = this.radius1BA -
			// YfromBottom;

			centralAngleBA = Math.toDegrees(radianCentralAngle); // in
			// degrees

			startAngleBA = radiansStart;// (180
			// -
			// radiansStart) /
			// 2;//
			// centralAnglet1;//radiansStart;//radiansStart;
			endAngleBA = centralAngleBA;// /2;//180
			// -
			// (2*radiansStart);//centralAngleBA;

			final double yFullRadiusLeft = myShape.centerPointY - startingY;

			final double baseForYLeft = myShape.startingX
					- myShape.centerPointX + myShape.left.partDimB;

			final double radiansYLeft = Math.toRadians(startAngleBA
					+ endAngleBA);// (double)
			// Math.acos(baseForYRight/(this.radius1-this.partDimB));

			final double yLeftBA = Math.abs(baseForYLeft
					* Math.tan(radiansYLeft));

			startingYBA = startingY + yFullRadiusLeft - yLeftBA;

			final double yFullRadiusRight = myShape.centerPointY - startingYBA;

			final double baseForYRight = myShape.bX2 - myShape.centerPointX
					- myShape.right.partDimB;

			final double radiansYRight = Math.toRadians(startAngleBA);// (double)
			// Math.acos(baseForYRight/(this.radius1-this.partDimB));

			final double yRightBA = Math.abs(baseForYRight
					* Math.tan(radiansYRight));

			startYBA = startingYBA;// +
			// (yFullRadiusRight-yRightBA);

			if (myShape.shapeID != 205 && myShape.shapeID != 305) {
				endYBA = startingYBA + yFullRadiusRight - yRightBA;
			}

			bkgrdStartXBA = bkgrdStartX + partDimB;// startingXBA+
			// this.myWidthBA/2
			// -
			// radius1BA;
			bkgrdStartYBA = bkgrdStartY + partDimB;// startingYBA;
			bkgrdWidthBA = 2 * radius1BA;
			bkgrdHeightBA = 2 * radius1BA;

			lengthBA = 2 * Math.PI * radius1BA * centralAngleBA / 360;// 2PIr*CentralAngle/360

			radius2BA = 0;
		}

	}

	public void topArcBegin903A(final ShapeObject myShape) { // int

		// =1
		// Arc
		// normal,
		// 2
		// start at 90, 3 end
		// at ninety
		double radiansStart = 0;
		double YfromBottom = 0;
		partForm = 2;
		// First line for All levels
		if (!wire || myShape.shapeChanged) {
			startingXA = startingX + partDimA + partDimB;
			startingYA = startingY + partDimA + partDimB;

			myWidthA = myWidthBA - 2 * partDimA;

			radius1A = radius1BA - partDimA;

			if (myShape.shapeID == 205 || myShape.shapeID == 305) {
				radiansStart = Math.asin((myShape.bot1.partDimA
						+ myShape.bot1.partDimB + radius1 - myShape.heightPix)
						/ radius1A);// (x2BA
				// - x1BA)
				// / (y2BA -
				// y1BA));
				// YfromBottom =
				// (myShape.bot1.partDimA +
				// myShape.bot1.partDimB)+(this.radius1-myShape.hL);
				// this.endYA =
				// this.startingYA +
				// (this.radius1A -
				// YfromBottom);//
				// this.startYBA;
				final double base = Math.sqrt(Math.pow(radius1A, 2)
						- Math.pow(
								(myShape.bot1.partDimA + myShape.bot1.partDimB
										+ radius1 - myShape.heightPix), 2));
				endXA = x1 + base;
				endYA = startingY
						+ radius1
						- (myShape.bot1.partDimA + myShape.bot1.partDimB
								+ radius1 - myShape.heightPix);
			} else {
				radiansStart = Math.acos(myWidthA / 2 / radius1A);// (x2BA
				// -
				// x1BA)
				// /
				// (y2BA
				// -
				// y1BA));
				YfromBottom = Math.abs((myWidth - (partDimA + partDimB))
						* Math.tan(radiansStart));
				endYA = startingYA + radius1A - YfromBottom;// this.startYBA;
				endXA = startingXA + myWidth - 2 * (partDimA + partDimB);
			}
			final double radiansStart2 = Math.acos((partDimA + partDimB)
					/ radius1A);// (x2A
			// -
			// x1A)
			// /
			// (y2A
			// -
			// y1A));

			radianCentralAngle = radiansStart2 - radiansStart;

			startXA = startingXA;// ingXA;

			final double YfromBottom2 = Math.abs((partDimA + partDimB)
					* Math.tan(radiansStart2));

			startYA = startingYA + radius1A - YfromBottom2;

			radiansStart = Math.toDegrees(radiansStart);

			centralAngleA = Math.toDegrees(radianCentralAngle);

			startAngleA = radiansStart;
			endAngleA = centralAngleA;

			bkgrdStartXA = bkgrdStartXBA + partDimA;
			bkgrdStartYA = bkgrdStartYBA + partDimA;
			bkgrdWidthA = 2 * radius1A;
			bkgrdHeightA = 2 * radius1A;

			lengthA = 2 * Math.PI * radius1A * centralAngleA / 360;

			radius2A = 0;
			// this.ltAngle = (double)
			// Math.atan((endX -
			// endXA) / (endY -
			// endYA));
			// this.rbAngle = (double)
			// Math.toRadians(90)-(double)
			// Math.atan((startX - startXA) /
			// (startY - startYA));
			ltAngle = Math.atan((endXA - endXC) / (endYA - endYC));
			rbAngle = Math.atan((startXC - startXA) / (startYC - startYA));

		} else {
			startingXA = startingX + partDimA + partDimB;
			// this.startingYA = startingY +
			// this.partDimA+
			// this.partDimB;

			myWidthA = myWidth - myShape.right.partDimA - myShape.left.partDimA
					- myShape.right.partDimB - myShape.left.partDimB;

			radius1A = radius1 - partDimA - partDimB;
			radiansStart = 0;
			if (myShape.shapeID == 205 || myShape.shapeID == 305) {
				final double deltaStartY = myShape.startingY
						- myShape.parentStartY;
				radiansStart = Math
						.asin((myShape.bot1.partDimA + myShape.bot1.partDimB
								+ radius1 - (myShape.heightPix + deltaStartY))
								/ radius1A);// (x2BA
				// - x1BA)
				// / (y2BA -

				final double base = Math
						.sqrt(Math.pow(radius1A, 2)
								- Math.pow(
										(myShape.bot1.partDimA
												+ myShape.bot1.partDimB
												+ radius1 - (myShape.heightPix + deltaStartY)),
										2));
				endXA = x1 + base;
				endYA = startingY
						+ radius1
						- (myShape.bot1.partDimA + myShape.bot1.partDimB
								+ radius1 - (myShape.heightPix + deltaStartY));
			} else {
				radiansStart = Math
						.acos((startingX + myWidth - myShape.centerPointX
								- myShape.right.partDimB - myShape.right.partDimA)
								/ radius1A);// (x2A
				// - x1A) /
				// (y2A - y1A));
				// (double) Math
				// .abs(((myShape.levelW -
				// (this.partDimA +
				// this.partDimB)))
				// * (double)
				// Math.tan(radiansStart));
			}

			final double radiansStart2 = Math
					.acos((startingX - myShape.centerPointX
							+ myShape.left.partDimA + myShape.left.partDimB)
							/ radius1A);// (x2A
			// - x1A) /
			// (y2A - y1A));

			radianCentralAngle = radiansStart2 - radiansStart;
			startXA = startingXA;// ingXA;
			if (myShape.shapeID != 205 && myShape.shapeID != 305) {
				endXA = startXA + myWidthA;
			}

			// double YfromBottom =
			// (this.startingX -
			// myShape.centerPointX +
			// myShape.wT -
			// myShape.right.partDimB -
			// myShape.right.partDimA)
			// *(double) Math.tan(radiansStart);
			//
			// double YfromBottom2 =
			// (startingX-myShape.centerPointX+myShape.left.partDimA+
			// myShape.left.partDimB)*(double)
			// Math.tan(radiansStart2);
			//
			// this.startYA = startingYA+
			// this.radius1A-YfromBottom2;
			//
			// this.endYA =
			// this.startingYA+this.radius1A -
			// YfromBottom;

			radiansStart = Math.toDegrees(radiansStart);
			// this.dimB1A = this.radius1A -
			// YfromBottom;

			centralAngleA = Math.toDegrees(radianCentralAngle);

			startAngleA = radiansStart;
			endAngleA = centralAngleA;// /2;//(180
			// -
			// (2*radiansStart))/2;//centralAngleA;

			final double yFullRadiusLeft = myShape.centerPointY - startingY;

			final double baseForYLeft = myShape.startingX
					- myShape.centerPointX + myShape.left.partDimB
					+ myShape.left.partDimA;

			final double radiansYLeft = Math.toRadians(startAngleA + endAngleA);

			final double yLeftA = Math.abs(baseForYLeft
					* Math.tan(radiansYLeft));

			startingYA = startingY + yFullRadiusLeft - yLeftA;
			startYA = startingYA;// +
			// (yFullRadiusRight-yRightBA);

			final double yFullRadiusRight = myShape.centerPointY - startingYA;

			final double baseForYRight = myShape.bX2 - myShape.centerPointX
					- myShape.right.partDimB - myShape.right.partDimA;

			final double radiansYRight = Math.toRadians(startAngleA);// (double)
			// Math.acos(baseForYRight/(this.radius1-this.partDimB));

			final double yRightA = Math.abs(baseForYRight
					* Math.tan(radiansYRight));
			if (myShape.shapeID != 205 && myShape.shapeID != 305) {
				endYA = startYA + yFullRadiusRight - yRightA;
			}

			bkgrdStartXA = bkgrdStartXBA + partDimA;
			bkgrdStartYA = bkgrdStartYBA + partDimA;
			bkgrdWidthA = 2 * radius1A;
			bkgrdHeightA = 2 * radius1A;

			lengthA = 2 * Math.PI * radius1A * centralAngleA / 360;

			radius2A = 0;

			ltAngle = Math.atan(Math.abs((endXA - endXC))
					/ Math.abs((endYA - endYC)));
			rbAngle = Math.atan(Math.abs((startXC - startXA))
					/ Math.abs((startYC - startYA)));

			// System.out.print("my top LT Angle is: "+(double)
			// Math.toDegrees(this.ltAngle)+" \n    "
			// );
			// System.out.print("my top RB Angle is: "+(double)
			// Math.toDegrees(this.rbAngle)+" \n    "
			// );
		}
	}

	public void arcEnd901B(final ShapeObject myShape) {

		partForm = 2;

		if (!wire || myShape.shapeChanged) {
			startXC = startingX;

			startYC = startingY + myShape.dimD2; // or
			// dimD2

			endXC = startXC + myWidth;
			endYC = startingY + myShape.dimB1;

			radius1 = myShape.dimD2 / 2 + Math.pow(myWidth * 2, 2)
					/ (8 * myShape.dimD2); //

			radius2 = 0;
			//
			x1 = endXC;
			y1 = startingY + radius1;

			x2 = endXC;
			y2 = endYC;

			radianCentralAngle = 2 * Math.atan(myWidth * 2 / 2
					/ (radius1 - myShape.dimD2));

			centralAngle = Math.toDegrees(radianCentralAngle);

			double radiansStart = Math.atan((x2 - x1) / (y2 - y1));
			radiansStart = Math.toDegrees(radiansStart);
			if (myShape.shapeID == 204 || myShape.shapeID == 304
					&& myShape.shapeChanged) {
				startAngle = 90;//

			} else {
				startAngle = (180 - radiansStart) / 2;//
			}
			// if (this.centralAngle < 0
			// && (myShape.shapeID == 204 ||
			// myShape.shapeID
			// == 304
			// && myShape.shapeChanged)) {
			// this.endAngle = 90;
			// } else {
			endAngle = Math.abs(centralAngle / 2);
			// }

			bkgrdWidth = 2 * radius1;
			bkgrdHeight = 2 * radius1;

			focal1X = endXC;// +
			// myShape.wT / 2;
			focal1Y = endYC + radius1;
			// + (double) Math.sqrt((double)
			// Math.pow(radius1,
			// 2) -
			// (double) Math.pow((myShape.wT*2) /
			// 2, 2));
			focal2X = focal1X;
			focal2Y = focal1Y;

			bkgrdStartX = endXC - radius1;// focal1X
			// -
			// radius1;
			bkgrdStartY = startingY;// focal1Y
			// ;//- radius1;

		} else {
			startXC = myShape.startingX;
			startYC = myShape.startingY + myShape.dimD2;
			// or
			// dimD2
			endXC = startXC + myWidth;
			endYC = myShape.startingY + myShape.dimB1;
			radius1 = myShape.radius1;
			radius2 = myShape.radius2;
			x1 = myShape.centerPointX;
			y1 = myShape.centerPointY;

			x2 = myShape.centerPointX2;
			y2 = myShape.centerPointY2;
			// radianCentralAngle =
			// myShape.centralAngle;
			centralAngle = myShape.centralAngle; // in
			// degrees

			startAngle = myShape.startAngle;// (180 -

			endAngle = myShape.endAngle;

			bkgrdWidth = 2 * radius1;
			bkgrdHeight = 2 * radius1;
			focal1X = x1;
			focal1Y = y1;
			focal2X = x2;
			focal2Y = y2;

			bkgrdStartX = myShape.bkgrdStartX;
			bkgrdStartY = myShape.bkgrdStartY;
		}

		rrSlope = (x2 - x1) / (y2 - y1);

		rrAngle = Math.abs(Math.atan(1 / rrSlope));

		rlSlope = (startingX - x1) / (startingY + myShape.dimD2 - y1);

		rlAngle = Math.abs(Math.atan(1 / rlSlope));

		length = 2 * Math.PI * radius1 * centralAngle / 360;

		radius2 = 0;

	}

	public void arcEnd902BA(final ShapeObject myShape) { // int

		// =1
		// Arc
		// normal,
		// 2
		// start
		// at 90, 3 end
		// at ninety
		partForm = 2;
		// First line for All levels
		if (!wire || myShape.shapeChanged) {
			startingXBA = startingX + partDimB;
			startingYBA = startingY + partDimB;

			myWidthBA = myWidth * 2 - 2 * partDimB;
			radius1BA = radius1 - partDimB;

			startXBA = startingXBA;// ingXBA;
			endXBA = startXBA + myWidth - 2 * partDimB;
			double radiansStart = 0;
			double radianEnd = 0;
			double YfromBottom2 = 0;
			double YfromBottom = 0;
			radiansStart = Math.acos(partDimB / radius1BA);

			if (myShape.shapeID == 204 || myShape.shapeID == 304) {
				radianEnd = Math
						.asin((myShape.bot1.partDimB + radius1 - myShape.heightPix)
								/ radius1BA);

				final double base = Math
						.sqrt(Math.pow(radius1BA, 2)
								- Math.pow(
										(myShape.bot1.partDimB + radius1 - myShape.heightPix),
										2));
				startXBA = x1 - base;
				startYBA = startingY + radius1
						- (myShape.bot1.partDimB + radius1 - myShape.heightPix);
				// this.endXBA =
				// this.x1+base;

			} else {
				radianEnd = Math.acos((myWidth - partDimB) / radius1BA);
				YfromBottom2 = Math.abs((myWidth - partDimB)
						* Math.tan(radianEnd));
				startYBA = startingYBA + radius1BA - YfromBottom2;
			}
			centralAngleBA = Math.abs(Math.toDegrees(radianEnd - radiansStart));

			YfromBottom = Math.abs(partDimB * Math.tan(radiansStart));

			endYBA = startingYBA + radius1BA - YfromBottom;

			startAngleBA = 180 - Math.toDegrees(radiansStart);// (180
			// -

			endAngleBA = centralAngleBA;

			dimB1B = radius1BA - YfromBottom;

			bkgrdStartXBA = bkgrdStartX + partDimB;// startingXBA+

			bkgrdStartYBA = bkgrdStartY + partDimB;// startingYBA;
			bkgrdWidthBA = 2 * radius1BA;
			bkgrdHeightBA = 2 * radius1BA;

			lengthBA = 2 * Math.PI * radius1BA * centralAngleBA / 360;// 2PIr*CentralAngle/360
			radius2BA = 0;
		} else {
			startingXBA = startingX + partDimB;
			// this.startingYBA = startingY +
			// myShape.right.partDimB;

			myWidthBA = myWidth - myShape.right.partDimB
					- myShape.left.partDimB;
			radius1BA = radius1 - partDimB;

			startXBA = startingXBA;// ingXBA;
			endXBA = endXC - myShape.right.partDimB;// this.startXBA
			// +
			// this.myWidthBA;
			double radiansStart = 0;
			double radianEnd = 0;
			if (myShape.shapeID == 204 || myShape.shapeID == 304) {
				final double deltaStartY = myShape.bY2 - myShape.parentStartY;
				radianEnd = Math
						.asin((myShape.bot1.partDimB + radius1 - (myShape.heightPix + deltaStartY))
								/ radius1BA);

				final double base = Math
						.sqrt(Math.pow(radius1BA, 2)
								- Math.pow(
										(myShape.bot1.partDimB + radius1 - (myShape.heightPix + deltaStartY)),
										2));
				startXBA = x1 - base;
				startYBA = startingY
						+ radius1
						- (myShape.bot1.partDimB + radius1 - (myShape.heightPix + deltaStartY));
			} else {

				radianEnd = Math.acos((myWidth + myShape.centerPointX
						- startingX - myWidth - partDimB)
						/ radius1BA);

				if (Double.isNaN(radianEnd)) {
					radianEnd = 0;
				}

			}

			radiansStart = Math.acos((partDimB + myShape.centerPointX
					- startingX - myWidth)
					/ radius1BA);

			centralAngleBA = Math.abs(Math.toDegrees(Math.abs(radianEnd
					- radiansStart)));

			startAngleBA = 180 - Math.toDegrees(radiansStart);// (180

			endAngleBA = centralAngleBA;

			final double yFullRadiusRight = myShape.centerPointY - startingY;

			final double baseForYRight = myShape.centerPointX - myShape.bX2
					+ partDimB;// myShape.right.partDimB;
			final double radiansYRight = Math.toRadians(startAngleBA);// (double)
			// Math.acos(baseForYRight/(this.radius1-this.partDimB));
			final double yRightBA = Math.abs(baseForYRight
					* Math.tan(radiansYRight));

			startingYBA = startingY + yFullRadiusRight - yRightBA;

			final double yFullRadiusLeft = myShape.centerPointY - startingYBA;

			final double baseForYLeft = myShape.centerPointX - startingX
					- partDimB;// myShape.right.partDimB;
			final double radiansYLeft = Math.toRadians(startAngleBA
					+ endAngleBA);// (double)
			// Math.acos(baseForYRight/(this.radius1-this.partDimB));
			final double yLeftBA = Math.abs(baseForYLeft
					* Math.tan(radiansYLeft));
			//
			if (myShape.shapeID != 204 && myShape.shapeID != 304) {
				startYBA = startingYBA + yFullRadiusLeft - yLeftBA;
			}
			endYBA = startingYBA;

			endYBA = startingYBA;// +
			// myShape.dimB1;

			bkgrdStartXBA = bkgrdStartX + partDimB;// startingXBA+
			// this.myWidthBA/2
			// -
			// radius1BA;
			bkgrdStartYBA = bkgrdStartY + partDimB;// startingYBA;
			bkgrdWidthBA = 2 * radius1BA;
			bkgrdHeightBA = 2 * radius1BA;

			lengthBA = 2 * Math.PI * radius1BA * centralAngleBA / 360;// 2PIr*CentralAngle/360
			radius2BA = 0;
		}

	}

	public void arcEnd903A(final ShapeObject myShape) { // int

		// =1
		// Arc
		// normal,
		// 2
		// start
		// at 90, 3 end at
		// ninety

		partForm = 2;
		// First line for All levels
		if (!wire || myShape.shapeChanged) {
			startingXA = startingXBA + partDimA;
			startingYA = startingYBA + partDimA;

			myWidthA = myWidth * 2 - 2 * (partDimB + partDimA);
			radius1A = radius1BA - partDimA;

			startXA = startingXA;// ingXBA;
			endXA = startXA + myWidth - 2 * (partDimA + partDimB);

			double radiansStart = 0;
			double radianEnd = 0;
			double YfromBottom2 = 0;
			double YfromBottom = 0;

			radiansStart = Math.acos((partDimA + partDimB) / radius1A);
			if (myShape.shapeID == 204 || myShape.shapeID == 304) {
				radianEnd = Math.asin((myShape.bot1.partDimB
						+ myShape.bot1.partDimA + radius1 - myShape.heightPix)
						/ radius1A);
				startYA =
				// myShape.bY4
				// -
				// myShape.bot1.partDimB;
				startingY
						+ radius1
						- (myShape.bot1.partDimB + myShape.bot1.partDimA
								+ radius1 - myShape.heightPix);
				final double base = Math.sqrt(Math.pow(radius1A, 2)
						- Math.pow(
								(myShape.bot1.partDimB + myShape.bot1.partDimA
										+ radius1 - myShape.heightPix), 2));
				startXA = x1 - base;

			} else {
				radianEnd = Math.acos((myWidth - partDimB - partDimA)
						/ radius1A);
				YfromBottom2 = Math.abs((myWidth - (partDimA + partDimB))
						* Math.tan(radianEnd));
				startYA = startingYA + radius1A - YfromBottom2;
			}
			if (Double.isNaN(radianEnd)) {
				radianEnd = 0;
			}
			centralAngleA = Math.abs(Math.toDegrees(radianEnd - radiansStart));

			YfromBottom = Math.abs((partDimA + partDimB)
					* Math.tan(radiansStart));

			endYA = startingYA + radius1A - YfromBottom;

			dimB1B = radius1A - YfromBottom;
			// radianCentralAngle = (double)
			// Math.atan((this.myWidthBA / 2) /
			// (this.dimB1B));
			// centralAngleBA = (double)
			// Math.toDegrees(radianCentralAngle);
			// //
			// in
			// degrees

			startAngleA = 180 - Math.toDegrees(radiansStart);// (180
			// -
			// radiansStart)
			// / 2;//
			// centralAnglet1;//radiansStart;//radiansStart;
			endAngleA = centralAngleA;

			bkgrdStartXA = bkgrdStartXBA + partDimA;// startingXBA+
			// this.myWidthBA/2
			// -
			// radius1BA;
			bkgrdStartYA = bkgrdStartYBA + partDimA;// startingYBA;
			bkgrdWidthA = 2 * radius1A;
			bkgrdHeightA = 2 * radius1A;

			lengthA = 2 * Math.PI * radius1A * centralAngleA / 360;// 2PIr*CentralAngle/360

			radius2A = 0;

			ltAngle = Math.atan((endXC - endXA) / (endYC - endYA));
			rbAngle = Math.atan((startXC - startXA) / (startYC - startYA));
		} else {
			startingXA = startingXBA + partDimA;
			// this.startingYA = startingYBA +
			// myShape.left.partDimA;

			myWidthA = myWidthBA - myShape.right.partDimA
					- myShape.left.partDimA;
			radius1A = radius1BA - partDimA;

			startXA = startingXA;// ingXBA;
			endXA = startXA + myWidthA;
			double radiansStart = 0;
			double radianEnd = 0;
			radiansStart = Math
					.acos((myShape.right.partDimB + myShape.right.partDimA
							+ myShape.centerPointX - startingX - myWidth)
							/ radius1A);
			if (myShape.shapeID == 204 || myShape.shapeID == 304) {

				final double deltaStartY = myShape.bY2 - myShape.parentStartY;
				radianEnd = Math
						.asin((myShape.bot1.partDimB + myShape.bot1.partDimA
								+ radius1 - (myShape.heightPix + deltaStartY))
								/ radius1A);

				final double base = Math
						.sqrt(Math.pow(radius1A, 2)
								- Math.pow(
										(myShape.bot1.partDimB
												+ myShape.bot1.partDimA
												+ radius1 - (myShape.heightPix + deltaStartY)),
										2));
				startXA = x1 - base;
				startYA = startingY
						+ radius1
						- (myShape.bot1.partDimB + myShape.bot1.partDimA
								+ radius1 - (myShape.heightPix + deltaStartY));

			} else {
				radianEnd = Math
						.acos((myWidth + myShape.centerPointX - startingX
								- myWidth - myShape.left.partDimB - myShape.left.partDimA)
								/ radius1A);
				if (Double.isNaN(radianEnd)) {
					radianEnd = 0;
				}

			}

			centralAngleA = Math.abs(Math.toDegrees(radianEnd - radiansStart));

			startAngleA = 180 - Math.toDegrees(radiansStart);// (180
			// -
			// radiansStart)
			// / 2;//
			// centralAnglet1;//radiansStart;//radiansStart;
			endAngleA = centralAngleA;

			final double yFullRadius = myShape.centerPointY - startingY;
			final double baseForYRight = myShape.centerPointX - myShape.bX2
					+ partDimB + partDimA;// myShape.right.partDimB
			// + myShape.right.partDimA;
			final double radiansYRight = Math.toRadians(startAngleA);// (double)
			// Math.acos(baseForYRight/(this.radius1-this.partDimB));
			final double yRightA = Math.abs(baseForYRight
					* Math.tan(radiansYRight));

			startingYA = startingY + yFullRadius - yRightA;

			final double yFullRadiusLeft = myShape.centerPointY - startingYA;
			final double baseForYLeft = myShape.centerPointX - startingX
					- myShape.right.partDimB - myShape.right.partDimA;
			final double radiansYLeft = Math.toRadians(startAngleA + endAngleA);// (double)
			// Math.acos(baseForYRight/(this.radius1-this.partDimB));
			final double yLeftA = Math.abs(baseForYLeft
					* Math.tan(radiansYLeft));
			if (myShape.shapeID != 204 && myShape.shapeID != 304) {
				startYA = startingYA + yFullRadiusLeft - yLeftA;
			}
			endYA = startingYA;

			// startYA = startingYA
			// +myShape.dimD2; // or
			// dimD2
			//
			// endYA = startingYA;//+
			// myShape.dimB1;

			bkgrdStartXA = bkgrdStartXBA + partDimA;// startingXBA+
			// this.myWidthBA/2
			// -
			// radius1BA;
			bkgrdStartYA = bkgrdStartYBA + partDimA;// startingYBA;
			bkgrdWidthA = 2 * radius1A;
			bkgrdHeightA = 2 * radius1A;

			lengthA = 2 * Math.PI * radius1A * centralAngleA / 360;// 2PIr*CentralAngle/360

			radius2A = 0;

			ltAngle = Math.atan(Math.abs(endXC - endXA)
					/ Math.abs(endYC - endYA));
			rbAngle = Math.atan(Math.abs(startXC - startXA)
					/ Math.abs(startYC - startYA));
		}

	}

	public void verticalCouplerStraight() {

		x1 = centerXs - thickness / 2;
		y1 = centerYs;
		x2 = x1 + thickness;
		y2 = y1;
		x3 = x2;
		y3 = y2 + length;
		x4 = x1;
		y4 = y3;

	}

	public void recalcVCPosition() {

		final Object[] frames = myParent.myParent.frames.toArray();

		double ePL = y3;
		double ePR = y4;
		double sPL = y1;
		double sPR = y2;

		for (final Object F : frames) {
			if (((Frame) F).endCol == rowCol
					&& ((Frame) F).startRow >= startPos
					&& ((Frame) F).shapeID != 10) {

				if (((Frame) F).bX2 == x1 && ((Frame) F).bY2 < sPL
						&& ((Frame) F).shapeID != 1) {
					sPL = ((Frame) F).bY2;
					break;
				} else if (((Frame) F).bX2 == x1 && ((Frame) F).shapeID == 1) {
					sPL = ((Frame) F).bY2;
					break;
				}

			}

		}

		for (final Object F : frames) {
			if (((Frame) F).startCol == rowCol + 1
					&& ((Frame) F).startRow >= startPos
					&& ((Frame) F).shapeID != 10) {

				if (((Frame) F).startingX == x2 && ((Frame) F).startingY < sPR
						&& ((Frame) F).shapeID != 1) {
					sPR = ((Frame) F).startingY;
					break;
				} else if (((Frame) F).startingX == x2
						&& ((Frame) F).shapeID == 1) {
					sPR = ((Frame) F).startingY;
					break;
				}
			}

		}

		y1a = y2a = Math.max(sPL, sPR);

		for (final Object F : frames) {
			if (((Frame) F).endCol == rowCol && ((Frame) F).endRow <= endPos
					&& ((Frame) F).shapeID != 10) {

				if (((Frame) F).bX3 == x4 && ((Frame) F).bY3 > ePL
						&& ((Frame) F).shapeID != 1) {
					ePL = ((Frame) F).bY3;

				} else if (((Frame) F).bX3 == x4 && ((Frame) F).shapeID == 1) {
					ePL = ((Frame) F).bY3;

				}

			}

		}

		for (final Object F : frames) {
			if (((Frame) F).endCol == rowCol + 1
					&& ((Frame) F).endRow <= endPos
					&& ((Frame) F).shapeID != 10) {

				if (((Frame) F).bX4 == x3 && ((Frame) F).bY4 > ePR
						&& ((Frame) F).shapeID != 1) {
					ePR = ((Frame) F).bY4;
					break;
				} else if (((Frame) F).bX4 == x3 && ((Frame) F).shapeID == 1) {
					ePR = ((Frame) F).bY4;
					break;
				}

			}

		}
		y4a = y3a = Math.max(ePL, ePR);

	}

	public Profiles cloneProfile(final Profiles original, final ShapeObject p) {

		final Profiles newMullion = (Profiles) cloneProfile(original);

		return newMullion;

	}

	/*
	 * public Profiles cloneProfile(final Profiles original) {
	 * 
	 * Profiles newProfile = new Profiles();
	 * 
	 * // if(original.posInUse) { myParent = original.myParent;
	 * 
	 * newProfile.a_1Level = original.a_1Level; newProfile.a_1Sequence =
	 * original.a_1Sequence; newProfile.a_2Level = original.a_2Level;
	 * newProfile.a_2Sequence = original.a_2Sequence; newProfile.a_3Level =
	 * original.a_3Level; newProfile.a_3Sequence = original.a_3Sequence;
	 * newProfile.a_4Level = original.a_4Level; newProfile.a_4Sequence =
	 * original.a_4Sequence;
	 * 
	 * newProfile.a_5Level = original.a_5Level; newProfile.a_5Sequence =
	 * original.a_5Sequence; newProfile.a_6Level = original.a_6Level;
	 * newProfile.a_6Sequence = original.a_6Sequence; newProfile.a_7Level =
	 * original.a_7Level; newProfile.a_7Sequence = original.a_7Sequence;
	 * newProfile.a_8Level = original.a_8Level; newProfile.a_8Sequence =
	 * original.a_8Sequence; newProfile.a_9Level = original.a_9Level;
	 * newProfile.a_9Sequence = original.a_9Sequence; newProfile.a_10Level =
	 * original.a_10Level; newProfile.a_10Sequence = original.a_10Sequence;
	 * 
	 * 
	 * newProfile.myFrame2 = myFrame2;
	 * 
	 * newProfile.bkgrdHeight = original.bkgrdHeight; newProfile.bkgrdHeightA =
	 * original.bkgrdHeightA; newProfile.bkgrdHeightBA = original.bkgrdHeightBA;
	 * newProfile.bkgrdHeightBC = original.bkgrdHeightBC; newProfile.bkgrdStartX
	 * = original.bkgrdStartX; newProfile.bkgrdStartXA = original.bkgrdStartXA;
	 * newProfile.bkgrdStartXBA = original.bkgrdStartXBA; newProfile.myParent =
	 * original.myParent; newProfile.bkgrdStartXBC = original.bkgrdStartXBC;
	 * newProfile.bkgrdStartY = original.bkgrdStartY; newProfile.x1 =
	 * original.x1; newProfile.x2 = original.x2; newProfile.y1 = original.y1;
	 * newProfile.y2 = original.y2; newProfile.bkgrdStartYA =
	 * original.bkgrdStartYA; newProfile.bkgrdStartYBA = original.bkgrdStartYBA;
	 * newProfile.bkgrdStartYBC = original.bkgrdStartYBC;
	 * 
	 * newProfile.bkgrdWidth = original.bkgrdWidth; newProfile.bkgrdWidthA =
	 * original.bkgrdWidthA;
	 * 
	 * newProfile.bkgrdWidthBA = original.bkgrdWidthBA; newProfile.bkgrdWidthBC
	 * = original.bkgrdWidthBC; newProfile.centralAngle = original.centralAngle;
	 * newProfile.centralAngleA = original.centralAngleA;
	 * 
	 * newProfile.centralAngleBA = original.centralAngleBA;
	 * 
	 * newProfile.centralAngleBC = original.centralAngleBC; newProfile.dimB1A =
	 * original.dimB1A;
	 * 
	 * newProfile.dimB1B = original.dimB1B; newProfile.endAngle =
	 * original.endAngle;
	 * 
	 * newProfile.endAngleA = original.endAngleA;
	 * 
	 * newProfile.endAngleBA = original.endAngleBA; newProfile.endAngleBC =
	 * original.endAngleBC;
	 * 
	 * newProfile.endXC = original.endXC; newProfile.endXA = original.endXA;
	 * 
	 * newProfile.endXBA = original.endXBA; newProfile.endXBC = original.endXBC;
	 * newProfile.endYC = original.endYC;
	 * 
	 * newProfile.endYA = original.endYA; newProfile.endYBA = original.endYBA;
	 * 
	 * newProfile.endYBC = original.endYBC; newProfile.focal1X =
	 * original.focal1X;
	 * 
	 * newProfile.focal1XA = original.focal1XA; newProfile.focal1XBA =
	 * original.focal1XBA; newProfile.focal1XBC = original.focal1XBC;
	 * newProfile.focal1Y = original.focal1Y;
	 * 
	 * newProfile.focal1YA = original.focal1YA; newProfile.focal1YBA =
	 * original.focal1YBA;
	 * 
	 * newProfile.focal1YBC = original.focal1YBC;
	 * 
	 * newProfile.focal2X = original.focal2X; newProfile.focal2XA =
	 * original.focal2XA;
	 * 
	 * newProfile.focal2XBA = original.focal2XBA; newProfile.focal2XBC =
	 * original.focal2XBC;
	 * 
	 * newProfile.focal2Y = original.focal2Y;
	 * 
	 * newProfile.focal2YA = original.focal2YA; newProfile.focal2YBA =
	 * original.focal2YBA;
	 * 
	 * newProfile.focal2YBC = original.focal2YBC; newProfile.glazingDepth =
	 * original.glazingDepth;
	 * 
	 * newProfile.inLaminateArea = original.inLaminateArea;
	 * newProfile.inPaintArea = original.inPaintArea;
	 * 
	 * newProfile.length = original.length; newProfile.lengthA =
	 * original.lengthA; newProfile.lengthBA = original.lengthBA;
	 * 
	 * newProfile.lengthBC = original.lengthBC; newProfile.ltAngle =
	 * original.ltAngle;
	 * 
	 * newProfile.ltAngleA = original.ltAngleA; newProfile.ltAngleBA =
	 * original.ltAngleBA;
	 * 
	 * newProfile.ltAngleBC = original.ltAngleBC; newProfile.mitreLengthLT =
	 * original.mitreLengthLT; newProfile.mitreLengthRB =
	 * original.mitreLengthRB;
	 * 
	 * newProfile.myWidth = original.myWidth; newProfile.myWidthA =
	 * original.myWidthA;
	 * 
	 * newProfile.myWidthBA = original.myWidthBA;
	 * 
	 * newProfile.outLaminateArea = original.outLaminateArea;
	 * newProfile.outPaintArea = original.outPaintArea;
	 * 
	 * newProfile.partDimA = original.partDimA; newProfile.partDimAi =
	 * original.partDimAi; newProfile.partDimB = original.partDimB;
	 * newProfile.partDimBi = original.partDimBi; newProfile.partDimC =
	 * original.partDimC; newProfile.partDimCi = original.partDimCi;
	 * newProfile.partDimM = original.partDimM; newProfile.partForm =
	 * original.partForm; // 1 // lines, 2 // arc, 3 // Ellipse
	 * 
	 * newProfile.partID = original.partID; newProfile.partShape =
	 * original.partShape; // L, // T, Z, // I, H,
	 * 
	 * newProfile.position = original.position; // 1 // top, 2 // right, 3 //
	 * bot, 4 left newProfile.seq = original.seq; newProfile.radianCentralAngle
	 * = original.radianCentralAngle;
	 * 
	 * newProfile.radius1 = original.radius1; newProfile.radius1A =
	 * original.radius1A; newProfile.radius1BA = original.radius1BA;
	 * newProfile.radius1BC = original.radius1BC;
	 * 
	 * newProfile.radius2 = original.radius2;
	 * 
	 * newProfile.radius2A = original.radius2A; newProfile.radius2BA =
	 * original.radius2BA;
	 * 
	 * newProfile.radius2BC = original.radius2BC;
	 * 
	 * newProfile.rbAngle = original.rbAngle; newProfile.rbAngleA =
	 * original.rbAngleA; newProfile.rbAngleBA = original.rbAngleBA;
	 * newProfile.rbAngleBC = original.rbAngleBC; // From Level Shape and
	 * Calculates newProfile.rID = original.rID; // Get next // record ID //
	 * from DB newProfile.rlAngle = original.rlAngle; // radius // to left //
	 * side angle newProfile.rlAngleA = original.rlAngleA; // radius // to //
	 * left side // angle newProfile.rlAngleBA = original.rlAngleBA; // radius
	 * // to // left side // angle newProfile.rlSlope = original.rlSlope; //
	 * left // radius // slope newProfile.rlSlopeA = original.rlSlopeA; // left
	 * // radius // slope newProfile.rlSlopeBA = original.rlSlopeBA; // left //
	 * radius // slope newProfile.rrAngle = original.rrAngle; // radius // to //
	 * right side // angle newProfile.rrAngleA = original.rrAngleA; // radius //
	 * to // right side // angle newProfile.rrAngleBA = original.rrAngleBA; //
	 * radius // to // right side // angle newProfile.rrSlope =
	 * original.rrSlope; // right // radius // slope newProfile.rrSlopeA =
	 * original.rrSlopeA; // right // radius // slope newProfile.rrSlopeBA =
	 * original.rrSlopeBA; // right // radius // slope newProfile.slope =
	 * original.slope; newProfile.slopeA = original.slopeA; newProfile.slopeBA =
	 * original.slopeBA; newProfile.slopeBC = original.slopeBC;
	 * newProfile.startAngle = original.startAngle; newProfile.startAngleA =
	 * original.startAngleA; newProfile.startAngleBA = original.startAngleBA;
	 * newProfile.startAngleBC = original.startAngleBC; newProfile.startingX =
	 * original.startingX; // called
	 * 
	 * newProfile.startingXA = original.startingXA; // called
	 * 
	 * newProfile.startingXBA = original.startingXBA; // called
	 * 
	 * newProfile.startingXBC = original.startingXBC; // called
	 * 
	 * newProfile.startingY = original.startingY; newProfile.startingYA =
	 * original.startingYA; newProfile.startingYBA = original.startingYBA;
	 * newProfile.startingYBC = original.startingYBC; newProfile.startXC =
	 * original.startXC; newProfile.startXA = original.startXA;
	 * newProfile.startXBA = original.startXBA; newProfile.startXBC =
	 * original.startXBC; newProfile.startYC = original.startYC;
	 * newProfile.startYA = original.startYA; newProfile.startYBA =
	 * original.startYBA; newProfile.startYBC = original.startYBC;
	 * newProfile.stockCode = original.stockCode; newProfile.color =
	 * original.color; // From Rules
	 * 
	 * newProfile.totalDepth = original.totalDepth; newProfile.totalSurfaceArea
	 * = original.totalSurfaceArea;
	 * 
	 * newProfile.endTypeLT = original.endTypeLT; newProfile.endTypeRB =
	 * original.endTypeRB; newProfile.parentW = original.parentW;
	 * 
	 * newProfile.rgb_R = original.rgb_R; newProfile.rgb_G = original.rgb_G;
	 * newProfile.rgb_B = original.rgb_B;
	 * 
	 * newProfile.rgb_Rt = original.rgb_Rt; newProfile.rgb_Gt = original.rgb_Gt;
	 * newProfile.rgb_Bt = original.rgb_Bt;
	 * 
	 * newProfile.profileSelected = 0;
	 * 
	 * newProfile.mullionLeft = original.mullionLeft; newProfile.mullionRight =
	 * original.mullionRight;
	 * 
	 * newProfile.posInUse = original.posInUse;
	 * 
	 * newProfile.stopAeX = original.stopAeX; newProfile.stopAeY =
	 * original.stopAeY; newProfile.stopAsX = original.stopAsX;
	 * newProfile.stopAsY = original.stopAsY;
	 * 
	 * newProfile.rowCol = original.rowCol;
	 * 
	 * newProfile.exists = original.exists;
	 * 
	 * newProfile.x1 = original.x1; newProfile.x1a = original.x1a; newProfile.x2
	 * = original.x2; newProfile.x2a = original.x2a; newProfile.x3 =
	 * original.x3; newProfile.x3a = original.x3a; newProfile.x4 = original.x4;
	 * newProfile.x4a = original.x4a;
	 * 
	 * newProfile.y1 = original.y1; newProfile.y1a = original.y1a; newProfile.y2
	 * = original.y2; newProfile.y2a = original.y2a; newProfile.y3 =
	 * original.y3; newProfile.y3a = original.y3a; newProfile.y4 = original.y4;
	 * newProfile.y4a = original.y4a;
	 * 
	 * newProfile.myParent = original.myParent;
	 * 
	 * newProfile.bkgrdHeight = original.bkgrdHeight; newProfile.bkgrdHeightA =
	 * original.bkgrdHeightA; newProfile.bkgrdHeightBA = original.bkgrdHeightBA;
	 * newProfile.bkgrdHeightBC = original.bkgrdHeightBC;
	 * 
	 * newProfile.bkgrdWidth = original.bkgrdWidth; newProfile.bkgrdWidthA =
	 * original.bkgrdWidthA; newProfile.bkgrdWidthBA = original.bkgrdWidthBA;
	 * newProfile.bkgrdWidthBC = original.bkgrdWidthBC;
	 * 
	 * newProfile.bkgrdStartX = original.bkgrdStartX; newProfile.bkgrdStartXA =
	 * original.bkgrdStartXA; newProfile.bkgrdStartXBA = original.bkgrdStartXBA;
	 * newProfile.bkgrdStartXBC = original.bkgrdStartXBC; newProfile.bkgrdStartY
	 * = original.bkgrdStartY; newProfile.bkgrdStartYA = original.bkgrdStartYA;
	 * newProfile.bkgrdStartYBA = original.bkgrdStartYBA;
	 * newProfile.bkgrdStartYBC = original.bkgrdStartYBC;
	 * 
	 * newProfile.x1 = original.x1; newProfile.x2 = original.x2; newProfile.y1 =
	 * original.y1; newProfile.y2 = original.y2;
	 * 
	 * newProfile.centralAngle = original.centralAngle; newProfile.centralAngleA
	 * = original.centralAngleA; newProfile.centralAngleBA =
	 * original.centralAngleBA; newProfile.centralAngleBC =
	 * original.centralAngleBC;
	 * 
	 * newProfile.endAngle = original.endAngle; newProfile.endAngleA =
	 * original.endAngleA; newProfile.endAngleBA = original.endAngleBA;
	 * newProfile.endAngleBC = original.endAngleBC;
	 * 
	 * newProfile.dimB1A = original.dimB1A; newProfile.dimB1B = original.dimB1B;
	 * 
	 * newProfile.endXC = original.endXC; newProfile.endXA = original.endXA;
	 * newProfile.endXBA = original.endXBA; newProfile.endXBC = original.endXBC;
	 * 
	 * newProfile.endYC = original.endYC; newProfile.endYA = original.endYA;
	 * newProfile.endYBA = original.endYBA; newProfile.endYBC = original.endYBC;
	 * 
	 * newProfile.focal1X = original.focal1X; newProfile.focal1XA =
	 * original.focal1XA; newProfile.focal1XBA = original.focal1XBA;
	 * newProfile.focal1XBC = original.focal1XBC; newProfile.focal1Y =
	 * original.focal1Y; newProfile.focal1YA = original.focal1YA;
	 * newProfile.focal1YBA = original.focal1YBA; newProfile.focal1YBC =
	 * original.focal1YBC; newProfile.focal2X = original.focal2X;
	 * newProfile.focal2XA = original.focal2XA; newProfile.focal2XBA =
	 * original.focal2XBA; newProfile.focal2XBC = original.focal2XBC;
	 * newProfile.focal2Y = original.focal2Y; newProfile.focal2YA =
	 * original.focal2YA; newProfile.focal2YBA = original.focal2YBA;
	 * newProfile.focal2YBC = original.focal2YBC;
	 * 
	 * newProfile.glazingDepth = original.glazingDepth;
	 * 
	 * newProfile.inLaminateArea = original.inLaminateArea;
	 * newProfile.inPaintArea = original.inPaintArea;
	 * 
	 * newProfile.length = original.length; newProfile.lengthA =
	 * original.lengthA; newProfile.lengthBA = original.lengthBA;
	 * newProfile.lengthBC = original.lengthBC;
	 * 
	 * newProfile.ltAngle = original.ltAngle; newProfile.ltAngleA =
	 * original.ltAngleA; newProfile.ltAngleBA = original.ltAngleBA;
	 * newProfile.ltAngleBC = original.ltAngleBC;
	 * 
	 * newProfile.mitreLengthLT = original.mitreLengthLT;
	 * newProfile.mitreLengthRB = original.mitreLengthRB;
	 * 
	 * newProfile.myWidth = original.myWidth; newProfile.myWidthA =
	 * original.myWidthA; newProfile.myWidthBA = original.myWidthBA;
	 * 
	 * newProfile.outLaminateArea = original.outLaminateArea;
	 * newProfile.outPaintArea = original.outPaintArea;
	 * 
	 * newProfile.partDimA = original.partDimA; newProfile.partDimAi =
	 * original.partDimAi; newProfile.partDimB = original.partDimB;
	 * newProfile.partDimBi = original.partDimBi; newProfile.partDimC =
	 * original.partDimC; newProfile.partDimCi = original.partDimCi;
	 * newProfile.partDimM = original.partDimM; newProfile.partForm =
	 * original.partForm;
	 * 
	 * newProfile.partID = original.partID; newProfile.partShape =
	 * original.partShape;
	 * 
	 * newProfile.position = original.position;
	 * 
	 * newProfile.seq = original.seq; newProfile.radianCentralAngle =
	 * original.radianCentralAngle;
	 * 
	 * newProfile.radius1 = original.radius1; newProfile.radius1A =
	 * original.radius1A; newProfile.radius1BA = original.radius1BA;
	 * newProfile.radius1BC = original.radius1BC;
	 * 
	 * newProfile.radius2 = original.radius2;
	 * 
	 * newProfile.radius2A = original.radius2A; newProfile.radius2BA =
	 * original.radius2BA;
	 * 
	 * newProfile.radius2BC = original.radius2BC;
	 * 
	 * newProfile.rbAngle = original.rbAngle; newProfile.rbAngleA =
	 * original.rbAngleA; newProfile.rbAngleBA = original.rbAngleBA;
	 * newProfile.rbAngleBC = original.rbAngleBC;
	 * 
	 * newProfile.rID = original.rID;
	 * 
	 * newProfile.rlAngle = original.rlAngle;
	 * 
	 * newProfile.rlAngleA = original.rlAngleA;
	 * 
	 * newProfile.rlAngleBA = original.rlAngleBA;
	 * 
	 * newProfile.rlSlope = original.rlSlope;
	 * 
	 * newProfile.rlSlopeA = original.rlSlopeA;
	 * 
	 * newProfile.rlSlopeBA = original.rlSlopeBA;
	 * 
	 * newProfile.rrAngle = original.rrAngle;
	 * 
	 * newProfile.rrAngleA = original.rrAngleA;
	 * 
	 * newProfile.rrAngleBA = original.rrAngleBA;
	 * 
	 * newProfile.rrSlope = original.rrSlope;
	 * 
	 * newProfile.rrSlopeA = original.rrSlopeA;
	 * 
	 * newProfile.rrSlopeBA = original.rrSlopeBA;
	 * 
	 * newProfile.slope = original.slope; newProfile.slopeA = original.slopeA;
	 * newProfile.slopeBA = original.slopeBA; newProfile.slopeBC =
	 * original.slopeBC; newProfile.startAngle = original.startAngle;
	 * newProfile.startAngleA = original.startAngleA; newProfile.startAngleBA =
	 * original.startAngleBA; newProfile.startAngleBC = original.startAngleBC;
	 * newProfile.startingX = original.startingX;
	 * 
	 * newProfile.startingXA = original.startingXA;
	 * 
	 * newProfile.startingXBA = original.startingXBA;
	 * 
	 * newProfile.startingXBC = original.startingXBC;
	 * 
	 * newProfile.startingY = original.startingY; newProfile.startingYA =
	 * original.startingYA; newProfile.startingYBA = original.startingYBA;
	 * newProfile.startingYBC = original.startingYBC; newProfile.startXC =
	 * original.startXC; newProfile.startXA = original.startXA;
	 * newProfile.startXBA = original.startXBA; newProfile.startXBC =
	 * original.startXBC; newProfile.startYC = original.startYC;
	 * newProfile.startYA = original.startYA; newProfile.startYBA =
	 * original.startYBA; newProfile.startYBC = original.startYBC;
	 * newProfile.stockCode = original.stockCode; newProfile.color =
	 * original.color;
	 * 
	 * newProfile.totalDepth = original.totalDepth; newProfile.totalSurfaceArea
	 * = original.totalSurfaceArea;
	 * 
	 * newProfile.endTypeLT = original.endTypeLT; newProfile.endTypeRB =
	 * original.endTypeRB; newProfile.parentW = original.parentW;
	 * 
	 * newProfile.rgb_R = original.rgb_R; newProfile.rgb_G = original.rgb_G;
	 * newProfile.rgb_B = original.rgb_B;
	 * 
	 * newProfile.rgb_Rt = original.rgb_Rt; newProfile.rgb_Gt = original.rgb_Gt;
	 * newProfile.rgb_Bt = original.rgb_Bt;
	 * 
	 * newProfile.profileSelected = 0;
	 * 
	 * newProfile.mullionLeft = original.mullionLeft; newProfile.mullionRight =
	 * original.mullionRight;
	 * 
	 * newProfile.posInUse = original.posInUse;
	 * 
	 * newProfile.stopAeX = original.stopAeX; newProfile.stopAeY =
	 * original.stopAeY; newProfile.stopAsX = original.stopAsX;
	 * newProfile.stopAsY = original.stopAsY;
	 * 
	 * // ////////////////////////////////////////////////////////////// //
	 * final Profiles newMullion = // this.cloneProfile(original); //
	 * //////////////////////////////////////////////////////////////
	 * 
	 * newProfile.levelID = 0; newProfile.parentid = 0; newProfile.rowCol = 0;
	 * 
	 * newProfile.continuity = original.continuity;
	 * 
	 * newProfile.rowCol = original.rowCol;
	 * 
	 * // if (original.partsNotching != null) { // newProfile.partsNotching = //
	 * original.partsNotching // .cloneNotches(original.partsNotching); //
	 * newProfile.myNotchLT = // original.partsNotching //
	 * .cloneNotches(original.myNotchLT); // newProfile.myNotchRB = //
	 * newProfile.partsNotching // .cloneNotches(original.myNotchRB); // //
	 * newProfile.myNothcesLT = // this.cloneCollections(original.myNothcesLT);
	 * // newProfile.myNothcesRB = //
	 * this.cloneCollections(original.myNothcesRB); // newProfile.notches = //
	 * this.cloneCollections(original.notches); // }
	 * 
	 * if (original.notches != null && original.notches.size() > 0) { Collection
	 * newNothches = new ArrayList(); Object[] notches =
	 * original.notches.toArray(); for (final Object n : notches) {
	 * newNothches.add(((PartsNotching) n).cloneNotches(((PartsNotching) n))); }
	 * newProfile.notches = newNothches; }
	 * 
	 * newProfile.myOpeningsLT = this.cloneCollections(original.myOpeningsLT);
	 * 
	 * newProfile.myOpeningsRB = this.cloneCollections(original.myOpeningsRB);
	 * 
	 * newProfile.partDimBtoC = original.partDimBtoC;
	 * 
	 * newProfile.startPos = original.startPos; newProfile.endPos =
	 * original.endPos;
	 * 
	 * newProfile.centerXsa = original.centerXsa; newProfile.centerYsa =
	 * original.centerYsa; newProfile.centerXea = original.centerXea;
	 * newProfile.centerYea = original.centerYea;
	 * 
	 * newProfile.xcs = original.xcs; newProfile.ycs = original.ycs;
	 * 
	 * newProfile.xce = original.xce; newProfile.yce = original.yce;
	 * 
	 * newProfile.x1al = original.x1al; newProfile.y1al = original.y1al;
	 * newProfile.x2cl = original.x2cl; newProfile.y2cl = original.y2cl;
	 * newProfile.x3cl = original.x3cl; newProfile.y3cl = original.y3cl;
	 * newProfile.x4al = original.x4al; newProfile.y4al = original.y4al;
	 * 
	 * newProfile.x1a = original.x1a; newProfile.y1a = original.y1a;
	 * newProfile.x2a = original.x2a; newProfile.y2a = original.y2a;
	 * newProfile.x3a = original.x3a; newProfile.y3a = original.y3a;
	 * newProfile.x4a = original.x4a; newProfile.y4a = original.y4a;
	 * 
	 * newProfile.x1a3 = original.x1a3; newProfile.y1a3 = original.y1a3;
	 * newProfile.x2a3 = original.x2a3; newProfile.y2a3 = original.y2a3;
	 * newProfile.x3a3 = original.x3a3; newProfile.y3a3 = original.y3a3;
	 * newProfile.x4a3 = original.x4a3; newProfile.y4a3 = original.y4a3;
	 * 
	 * newProfile.x1b = original.x1b; newProfile.y1b = original.y1b;
	 * newProfile.x2b = original.x2b; newProfile.y2b = original.y2b;
	 * newProfile.x3b = original.x3b; newProfile.y3b = original.y3b;
	 * newProfile.x4b = original.x4b; newProfile.y4b = original.y4b;
	 * 
	 * newProfile.centerXs = original.centerXs; newProfile.centerYs =
	 * original.centerYs; newProfile.centerXe = original.centerXe;
	 * newProfile.centerYe = original.centerYe;
	 * 
	 * newProfile.dx1 = original.dx1; newProfile.dy1 = original.dy1;
	 * newProfile.dx2 = original.dx2; newProfile.dy2 = original.dy2;
	 * newProfile.dx3 = original.dx3; newProfile.dy3 = original.dy3;
	 * newProfile.dx4 = original.dx4; newProfile.dy4 = original.dy4;
	 * newProfile.dx1al = original.dx1al; newProfile.dy1al = original.dy1al;
	 * newProfile.dx2cl = original.dx2cl; newProfile.dy2cl = original.dy3cl;
	 * newProfile.dx3cl = original.dx3cl; newProfile.dy3cl = original.dy3cl;
	 * newProfile.dx4al = original.dx4al; newProfile.dy4al = original.dy4al;
	 * newProfile.dcenterXs = original.dcenterXs; newProfile.dcenterYs =
	 * original.dcenterYs; newProfile.dcenterXe = original.dcenterXe;
	 * newProfile.dcenterYe = original.dcenterYe;
	 * 
	 * newProfile.scale = original.scale;
	 * 
	 * newProfile.thickness = original.thickness;
	 * 
	 * newProfile.CouplerShapeID = original.CouplerShapeID;
	 * 
	 * newProfile.orientation = original.orientation; newProfile.frameLTid =
	 * original.frameLTid; newProfile.frameRBid = original.frameRBid;
	 * newProfile.centralAnglec = original.centralAnglec;
	 * newProfile.centralAnglec1 = original.centralAnglec1;
	 * newProfile.centralAnglea = original.centralAnglea; newProfile.radius1c =
	 * original.radius1c; newProfile.radius1c1 = original.radius1c1;
	 * newProfile.radius1a1 = original.radius1a1; newProfile.radius1a =
	 * original.radius1a; newProfile.arcH = original.arcH;
	 * newProfile.startAnglec = original.startAnglec; newProfile.endAnglec =
	 * original.endAnglec; newProfile.startAnglec1 = original.startAnglec1;
	 * newProfile.endAnglec1 = original.endAnglec1; newProfile.startAnglea1 =
	 * original.startAnglea1; newProfile.endAnglea1 = original.endAnglea1;
	 * newProfile.startAnglea = original.startAnglea; newProfile.endAnglea =
	 * original.endAnglea; newProfile.couplerTypeID = original.couplerTypeID;
	 * newProfile.openingLT = original.openingLT; newProfile.openingRB =
	 * original.openingRB; newProfile.whichPos = original.whichPos;
	 * newProfile.baseRT = original.baseRT; newProfile.baseLB = original.baseLB;
	 * newProfile.baseCenter = original.baseCenter; newProfile.newAlpha =
	 * original.newAlpha; newProfile.newStartingYRT = original.newStartingYRT;
	 * newProfile.newStartingXRT = original.newStartingXRT; newProfile.newAlpha2
	 * = original.newAlpha2; newProfile.newStartingYLB =
	 * original.newStartingYLB; newProfile.newStartingXLB =
	 * original.newStartingXLB; newProfile.newAlpha3 = original.newAlpha3;
	 * newProfile.newStartingYCenter = original.newStartingYCenter;
	 * newProfile.newStartingXCenter = original.newStartingXCenter;
	 * newProfile.newAlphaA = original.newAlphaA; newProfile.newAlphaC =
	 * original.newAlphaC; newProfile.baseLBa = original.baseLBa;
	 * newProfile.baseRTc = original.baseRTc; newProfile.newStartingXLBa =
	 * original.newStartingXLBa; newProfile.newStartingXRTc =
	 * original.newStartingXRTc; newProfile.newStartingYLBa =
	 * original.newStartingYLBa; newProfile.newStartingYRTc =
	 * original.newStartingYRTc; newProfile.newBeta = original.newBeta;
	 * newProfile.theta = original.theta; newProfile.alpha = original.alpha;
	 * newProfile.newYLeft = original.newYLeft; newProfile.newYRight =
	 * original.newYRight; newProfile.newYCenter = original.newYCenter;
	 * newProfile.newXcenterStart = original.newXcenterStart;
	 * newProfile.tempDelta = original.tempDelta; newProfile.isBefore =
	 * original.isBefore; newProfile.endCID = original.endCID;
	 * newProfile.startCID = original.startCID; newProfile.isValid =
	 * original.isValid; newProfile.angleTLa = original.angleTLa;
	 * newProfile.angleBLa = original.angleBLa; newProfile.angleTRc =
	 * original.angleTRc; newProfile.angleBRc = original.angleBRc;
	 * newProfile.offsetTL = original.offsetTL; newProfile.offsetRB =
	 * original.offsetRB; newProfile.deltaTL = original.deltaTL;
	 * newProfile.deltaRB = original.deltaRB; newProfile.curveCenterTL =
	 * original.curveCenterTL; newProfile.curveCenterRB =
	 * original.curveCenterRB; newProfile.bcSP0x = original.bcSP0x;
	 * newProfile.bcSP1x = original.bcSP1x; newProfile.bcCP1x = original.bcCP1x;
	 * newProfile.bcCP2x = original.bcCP2x; newProfile.bcEP1x = original.bcEP1x;
	 * newProfile.bcEP0x = original.bcEP0x; newProfile.bcSP0y = original.bcSP0y;
	 * newProfile.bcSP1y = original.bcSP1y; newProfile.bcCP1y = original.bcCP1y;
	 * newProfile.bcCP2y = original.bcCP2y; newProfile.bcEP1y = original.bcEP1y;
	 * newProfile.bcEP0y = original.bcEP0y; newProfile.joinM = original.joinM;
	 * newProfile.posCondition = original.posCondition; newProfile.mType =
	 * original.mType; newProfile.remove = original.remove; newProfile.exists =
	 * original.exists; newProfile.potentialS = original.potentialS;
	 * newProfile.delta = original.delta; newProfile.startIn = original.startIn;
	 * newProfile.endIn = original.endIn; newProfile.partLeft =
	 * original.partLeft; newProfile.partRight = original.partRight; newProfile.
	 * = original.cOrM;
	 * 
	 * newProfile.x1a = original.x1a; newProfile.y1a = original.y1a;
	 * newProfile.x2a = original.x2a; newProfile.y2a = original.y2a;
	 * newProfile.x3a = original.x3a; newProfile.y3a = original.y3a;
	 * newProfile.x4a = original.x4a; newProfile.y4a = original.y4a;
	 * 
	 * newProfile.drawcoupler = original.drawcoupler; newProfile.joinC =
	 * original.joinC; newProfile.opDone = original.opDone;
	 * newProfile.finalVerify = original.finalVerify; newProfile.unique =
	 * original.unique; newProfile.followFrame = original.followFrame;
	 * newProfile.isExtra = original.isExtra; newProfile.isNew = original.isNew;
	 * newProfile.openingTypeLB = original.openingTypeLB; newProfile.openingIDLB
	 * = original.openingIDLB; newProfile.openingTypeRT =
	 * original.openingTypeRT; newProfile.openingIDRT = original.openingIDRT;
	 * newProfile.manualPos = original.manualPos; newProfile.angle =
	 * original.angle; newProfile.fixedAngle = original.fixedAngle;
	 * newProfile.phantom = original.phantom; newProfile.order = original.order;
	 * 
	 * newProfile.limitStartX1 = original.limitStartX1; newProfile.limitStartX1a
	 * = original.limitStartX1a; newProfile.limitEndX3 = original.limitEndX3;
	 * newProfile.limitEndX3c = original.limitEndX3c; newProfile.limitEndX4 =
	 * original.limitEndX4; newProfile.limitEndX4a = original.limitEndX4a;
	 * newProfile.limitEndXC = original.limitEndXC; newProfile.limitEndY3 =
	 * original.limitEndY3; newProfile.limitEndY3c = original.limitEndY3c;
	 * newProfile.limitEndY4 = original.limitEndY4; newProfile.limitEndY4a =
	 * original.limitEndY4a; newProfile.limitEndYC = original.limitEndYC;
	 * newProfile.limitStartX2 = original.limitStartX2; newProfile.limitStartX2c
	 * = original.limitStartX2c; newProfile.limitStartXC =
	 * original.limitStartXC; newProfile.limitStartY1 = original.limitStartY1;
	 * newProfile.limitStartY1a = original.limitStartY1a;
	 * newProfile.limitStartY2 = original.limitStartY2; newProfile.limitStartY2c
	 * = original.limitStartY2c; newProfile.limitStartYC =
	 * original.limitStartYC;
	 * 
	 * newProfile.partIDByUser = original.partIDByUser;
	 * newProfile.endTypeLTByUser = original.endTypeLTByUser;
	 * newProfile.endTypeRBByUser = original.endTypeRBByUser;
	 * 
	 * // }
	 * 
	 * return newProfile; }
	 */
	public Polygon doPoly() {

		poly.addPoint((int) x1a, (int) y1a);
		poly.addPoint((int) x2a, (int) y2a);
		poly.addPoint((int) x3a, (int) y3a);
		poly.addPoint((int) x4a, (int) y4a);
		poly.addPoint((int) x1a, (int) y1a);
		return poly;

	}

	public void glazedInOut() {

		// Need to Revise In Out
		if (x1a == 0) {
			x1a = x1al;
		}
		if (x2a == 0) {
			x2a = x2cl;
		}
		if (x1b == 0) {
			x1b = x1;
		}
		if (x2b == 0) {
			x2b = x2;
		}
		if (xcs == 0) {
			xcs = centerXs;
		}
		if (x4a == 0) {
			x4a = x4al;
		}
		if (x3a == 0) {
			x3a = x3cl;
		}
		if (x4b == 0) {
			x4b = x4;
		}
		if (x3b == 0) {
			x3b = x3;
		}
		if (xce == 0) {
			xce = centerXe;
		}

		if (y1a == 0) {
			y1a = y1al;
		}
		if (y2a == 0) {
			y2a = y2cl;
		}
		if (y1b == 0) {
			y1b = y1;
		}
		if (y2b == 0) {
			y2b = y2;
		}
		if (ycs == 0) {
			ycs = centerYs;
		}
		if (y4a == 0) {
			y4a = y4al;
		}
		if (y3a == 0) {
			y3a = y3cl;
		}
		if (y4b == 0) {
			y4b = y4;
		}
		if (y3b == 0) {
			y3b = y3;
		}
		if (yce == 0) {
			yce = centerYe;
		}

		if (myFrame2.jobItem.viewOut && !myParent.myParent.glazedOut
				|| !myFrame2.jobItem.viewOut && myParent.myParent.glazedOut) {
			if (endTypeLT == 3) {
				if (orientation == 1) {

					y1a = y1a3;
					y2a = y2a3;
					y1b = y1a3;
					y2b = y2a3;
					ycs = y1a3;

				} else {

					x1a = x1a3;
					x2a = x2a3;
					x1b = x1a3;
					x2b = x2a3;
					xcs = x1a3;
				}
			} else if (endTypeLT == 2) {
				if (orientation == 1) {

					y1a = y1a3;
					y2a = y2a3;
					y1b = y1a3;
					y2b = y2a3;
					ycs = y1a3;

				} else {

					x1a = x1a3;
					x2a = x2a3;
					x1b = x1a3;
					x2b = x2a3;
					xcs = x1a3;

				}
			}
			if (endTypeRB == 3) {
				if (orientation == 1) {
					y4a = y4a3;
					y3a = y3a3;
					y4b = y4a3;
					y3b = y3a3;
					yce = y3a3;
				} else {
					x4a = x4a3;
					x3a = x3a3;
					x4b = x4a3;
					x3b = x3a3;
					xce = x3a3;
				}

			} else if (endTypeRB == 2) {
				if (orientation == 1) {
					y4a = y4a3;
					y3a = y3a3;
					y4b = y4a3;
					y3b = y3a3;
					yce = y3a3;
				} else {

					x4a = x4a3;
					x3a = x3a3;
					x4b = x4a3;
					x3b = x3a3;
					xce = x3a3;
				}

			}

		}

		if (this.orientation == 1
				&& (myFrame2.jobItem.viewOut && myParent.myParent.glazedOut || !myFrame2.jobItem.viewOut
						&& !myParent.myParent.glazedOut)) {
			if (endTypeLT == 3) {
				
				y1a = y1al;
				y2a = y2cl;
				y1b = y1;
				y2b = y2;
				ycs = centerYs;
			}
			if (endTypeRB == 3) {
				y4a = y4al;
				y3a = y3cl;
				y4b = y4;
				y3b = y3;
				yce = centerYe;
			}
		}
	}

	public void couplerDraw() {

		x1a = x1al;
		x2a = x2cl;
		x1b = x1;
		x2b = x2;
		xcs = centerXs;
		x4a = x4al;
		x3a = x3cl;
		x4b = x4;
		x3b = x3;
		xce = centerXe;

		y1a = y1al;
		y2a = y2cl;
		y1b = y1;
		y2b = y2;
		ycs = centerYs;
		y4a = y4al;
		y3a = y3cl;
		y4b = y4;
		y3b = y3;
		yce = centerYe;
		
		if (y1a3 > 0) {
			y1a = y1b = y1a3;
			
		}
		if (y1a3 == 0) {
			y1a3 = y1b = ycs = y1a;
			
		}
		
		if (y2a3 > 0) {
			y2a = y2b = ycs = y2a3;
		}
		if (y2a3 == 0) {
			y2a3 = y2a = y2a;
		}
		
		
		if (y1a3 > 0) {
			y1a = y1a3;
		}
		if (y1a3 == 0) {
			y2a3 = y2a;
		}
		
		if (y4a3 > 0) {
			y4a = y4b = yce = y4a3;
		}
		if (y4a3 == 0) {
			y4a3 = y4b = yce = y4a;
		}	
		
		
		if (y3a3 > 0) {
			y3a = y3b = y3a3;
		}
		if (y3a3 == 0) {
			y3a3 = y3b = y3a;
		}	
		
		///////////////////////////
		
		
		if (x1a3 > 0) {
			x1a = x1b = x1a3;
			
		}
		if (x1a3 == 0) {
			x1a3 = x1b = xcs = x1a;
			
		}
		
		if (x2a3 > 0) {
			x2a = x2b = xcs = x2a3;
		}
		if (x2a3 == 0) {
			x2a3 = x2a = x2a;
		}
		
		
		if (x1a3 > 0) {
			x1a = x1a3;
		}
		if (x1a3 == 0) {
			x2a3 = x2a;
		}
		
		if (x4a3 > 0) {
			x4a = x4b = xce = x4a3;
		}
		if (x4a3 == 0) {
			x4a3 = x4b = xce = x4a;
		}	
		
		
		if (x3a3 > 0) {
			x3a = x3b = x3a3;
		}
		if (x3a3 == 0) {
			x3a3 = x3b = x3a;
		}
		
		
//			x1a = x1a3;
//			x2a = x2a3;
//			x1b = x1a3;
//			x2b = x2a3;
//			xcs = x1a3;
//
//			x4a = x4a3;
//			x3a = x3a3;
//			x4b = x4a3;
//			x3b = x3a3;
//			xce = x3a3;

		// }else if(endTypeLT==2) {
		// y1a = y1a3;
		// y2a = y2a3;
		// y1b = y1a3;
		// y2b = y2a3;
		// ycs = y1a3;
		// x1a = x1a3;
		// x2a = x2a3;
		// x1b = x1a3;
		// x2b = x2a3;
		// xcs = x1a3;
		// }
		// if(endTypeRB==3) {
		// y4a = y4a3;
		// y3a = y3a3;
		// y4b = y4a3;
		// y3b = y3a3;
		// yce = y3a3;
		//
		// x4a = x4a3;
		// x3a = x3a3;
		// x4b = x4a3;
		// x3b = x3a3;
		// xce = x3a3;
		//
		// }else if(endTypeRB==2) {
		// y4a = y4a3;
		// y3a = y3a3;
		// y4b = y4a3;
		// y3b = y3a3;
		// yce = y3a3;
		//
		// x4a = x4a3;
		// x3a = x3a3;
		// x4b = x4a3;
		// x3b = x3a3;
		// xce = x3a3;
		//
		//
		// }
		//
		// }
		//
		// if((myFrame2.jobItem.viewOut &&
		// myParent.myParent.glazedOut) ||
		// (!myFrame2.jobItem.viewOut &&
		// !myParent.myParent.glazedOut)) {
		// if(endTypeLT==3) {
		// y1a = y1al;
		// y2a = y2cl;
		// y1b = y1;
		// y2b = y2;
		// ycs = centerYs;
		// }if(endTypeRB==3) {
		// y4a = y4al;
		// y3a = y3cl;
		// y4b = y4;
		// y3b = y3;
		// yce = centerYe;
		// }
		// }
	}

	/*
	 * public Collection cloneCollections(final Collection original) {
	 * 
	 * final Collection newc = new ArrayList(); final Object[] rmp =
	 * original.toArray(); for (final Object v : rmp) { newc.add(v); } return
	 * newc; }
	 */

	public Point2D getIntersectionLineArc(
			//
			final double bsX,
			final double bsY, //
			final double w,
			final double h, //
			final double sA,
			final double eA, //
			final double cX, final double cY, final double sX, final double sY,
			final double eX, final double eY, final int pos, final boolean isP) {

		Point2D myP = new Point2D.Double();

		if (pos == 1) {// Top Part

			final Point2D myPs = new Point2D.Double(sX, sY);
			final Point2D myPe = new Point2D.Double(eX, eY);

			myP = this.getLineCircleIntersection(bsX, bsY, w, h, cX, cY, myPs,
					myPe, isP);
		}

		return myP;

	}

	public Point2D getLineCircleIntersection(final double bsX,
			final double bsY, final double wW, final double hH,
			final double centerX, final double centerY, final Point2D source,
			final Point2D p, final boolean isP) {

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
		if (!isP) {
			x1 = source.getX(); // was p
			y1 = source.getY();
		} else {
			x1 = p.getX();
			y1 = p.getY();
		}

		// Calculates straight line equation through
		// point
		// and ellipse center
		// y = d * x + h
		final double dx = x1 - x0;
		final double dy = y1 - y0;

		if (dx == 0) {
			return new Point2D.Double(x0, (y0 + b * dy / Math.abs(dy)));
		}

		final double d = dy / dx;
		final double h = y0 - d * x0;

		// Calculates intersection
		final double e = a * a * d * d + b * b;
		final double f = -2 * x0 * e;
		final double g = a * a * d * d * x0 * x0 + b * b * x0 * x0 - a * a * b
				* b;

		final double det = Math.sqrt(f * f - 4 * e * g);

		// Two solutions (perimeter points)
		final double xout1 = (-f + det) / (2 * e);
		final double xout2 = (-f - det) / (2 * e);
		final double yout1 = d * xout1 + h;
		final double yout2 = d * xout2 + h;

		final double dist1 = Math.sqrt(Math.pow((xout1 - x1), 2)
				+ Math.pow((yout1 - y1), 2));
		final double dist2 = Math.sqrt(Math.pow((xout2 - x1), 2)
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

	/**
	 * Create Profile model object
	 * 
	 * @param profile
	 *            , ProfileEntityObject
	 */
	private void createProfileModelObject(ProfileEntityObject profile) {

		// Profile transformation object
		ProfileDTO profileDTO = new ProfileDTO();
		// Creating Profiles
		profileDTO.createProfiles(this, profile);

		if (profile.getLimitStartX1a() != null) {
			Profiles limitStartX1a = new Profiles(this.myFrame2);
			profileDTO
					.createProfiles(limitStartX1a, profile.getLimitStartX1a());
			this.limitStartX1a = limitStartX1a;
		}

		if (profile.getLimitStartX1() != null) {
			Profiles limitStartX1 = new Profiles(this.myFrame2);
			profileDTO.createProfiles(limitStartX1, profile.getLimitStartX1());
			this.limitStartX1 = limitStartX1;
		}

		if (profile.getLimitStartXC() != null) {
			Profiles limitStartXC = new Profiles(this.myFrame2);
			profileDTO.createProfiles(limitStartXC, profile.getLimitStartXC());
			this.limitStartXC = limitStartXC;
		}

		if (profile.getLimitStartX2() != null) {
			Profiles limitStartX2 = new Profiles(this.myFrame2);
			profileDTO.createProfiles(limitStartX2, profile.getLimitStartX2());
			this.limitStartX2 = limitStartX2;
		}

		if (profile.getLimitStartXC() != null) {
			Profiles limitStartXC = new Profiles(this.myFrame2);
			profileDTO.createProfiles(limitStartXC, profile.getLimitStartXC());
			this.limitStartXC = limitStartXC;
		}

		if (profile.getLimitStartX2() != null) {
			Profiles limitStartX2 = new Profiles(this.myFrame2);
			profileDTO.createProfiles(limitStartX2, profile.getLimitStartX2());
			this.limitStartX2 = limitStartX2;
		}

		if (profile.getLimitStartX2c() != null) {
			Profiles limitStartX2c = new Profiles(this.myFrame2);
			profileDTO
					.createProfiles(limitStartX2c, profile.getLimitStartX2c());
			this.limitStartX2c = limitStartX2c;
		}

		if (profile.getLimitStartY1a() != null) {
			Profiles limitStartY1a = new Profiles(this.myFrame2);
			profileDTO
					.createProfiles(limitStartY1a, profile.getLimitStartY1a());
			this.limitStartY1a = limitStartY1a;
		}

		if (profile.getLimitStartY1() != null) {
			Profiles limitStartY1 = new Profiles(this.myFrame2);
			profileDTO.createProfiles(limitStartY1, profile.getLimitStartY1());
			this.limitStartY1 = limitStartY1;
		}

		if (profile.getLimitStartYC() != null) {
			Profiles limitStartYC = new Profiles(this.myFrame2);
			profileDTO.createProfiles(limitStartYC, profile.getLimitStartYC());
			this.limitStartYC = limitStartYC;
		}

		if (profile.getLimitStartY2() != null) {
			Profiles limitStartY2 = new Profiles(this.myFrame2);
			profileDTO.createProfiles(limitStartY2, profile.getLimitStartY2());
			this.limitStartY2 = limitStartY2;
		}

		if (profile.getLimitStartY2c() != null) {
			Profiles limitStartY2c = new Profiles(this.myFrame2);
			profileDTO
					.createProfiles(limitStartY2c, profile.getLimitStartY2c());
			this.limitStartY2c = limitStartY2c;
		}

		if (profile.getLimitEndX4a() != null) {
			Profiles limitEndX4a = new Profiles(this.myFrame2);
			profileDTO.createProfiles(limitEndX4a, profile.getLimitEndX4a());
			this.limitEndX4a = limitEndX4a;
		}

		if (profile.getLimitEndX4() != null) {
			Profiles limitEndX4 = new Profiles(this.myFrame2);
			profileDTO.createProfiles(limitEndX4, profile.getLimitEndX4());
			this.limitEndX4 = limitEndX4;
		}

		if (profile.getLimitEndXC() != null) {
			Profiles limitEndXC = new Profiles(this.myFrame2);
			profileDTO.createProfiles(limitEndXC, profile.getLimitEndXC());
			this.limitEndXC = limitEndXC;
		}

		if (profile.getLimitEndX3() != null) {
			Profiles limitEndX3 = new Profiles(this.myFrame2);
			profileDTO.createProfiles(limitEndX3, profile.getLimitEndX3());
			this.limitEndX3 = limitEndX3;
		}

		if (profile.getLimitEndX3c() != null) {
			Profiles limitEndX3c = new Profiles(this.myFrame2);
			profileDTO.createProfiles(limitEndX3c, profile.getLimitEndX3c());
			this.limitEndX3c = limitEndX3c;
		}

		if (profile.getLimitEndY4a() != null) {
			Profiles limitEndY4a = new Profiles(this.myFrame2);
			profileDTO.createProfiles(limitEndY4a, profile.getLimitEndY4a());
			this.limitEndY4a = limitEndY4a;
		}

		if (profile.getLimitEndY4() != null) {
			Profiles limitEndY4 = new Profiles(this.myFrame2);
			profileDTO.createProfiles(limitEndY4, profile.getLimitEndY4());
			this.limitEndY4 = limitEndY4;
		}

		if (profile.getLimitEndYC() != null) {
			Profiles limitEndYC = new Profiles(this.myFrame2);
			profileDTO.createProfiles(limitEndYC, profile.getLimitEndYC());
			this.limitEndYC = limitEndYC;
		}

		if (profile.getLimitEndY3() != null) {
			Profiles limitEndY3 = new Profiles(this.myFrame2);
			profileDTO.createProfiles(limitEndY3, profile.getLimitEndY3());
			this.limitEndY3 = limitEndY3;
		}

		if (profile.getLimitEndY3c() != null) {
			Profiles limitEndY3c = new Profiles(this.myFrame2);
			profileDTO.createProfiles(limitEndY3c, profile.getLimitEndY3c());
			this.limitEndY3c = limitEndY3c;
		}
	}

	/**
	 * Create Profile model object
	 * 
	 * @param profile
	 *            , ProfileEntityBOM
	 */
	private void createProfilePartsModelObject(ProfileEntityBOM profile) {

		// Profile transformation object
		ProfileDTO profileDTO = new ProfileDTO();
		// Creating profiles
		profileDTO.createProfiles(this, profile);
	}

	/**
	 * Create profile model object
	 * 
	 * @param profile
	 *            , ProfileGridObject
	 */
	private void createProfilePartsModelObject(ProfileGridObject profile) {

		// Profile transformation object
		ProfileDTO profileDTO = new ProfileDTO();
		// Creating profiles
		profileDTO.createProfiles(this, profile);
	}

	/**
	 * Create profile model object
	 * 
	 * @param profile
	 *            , ProfileGridSpokeObject
	 */
	private void createProfilePartsModelObject(ProfileGridSpokeObject profile) {

		// Profile transformation object
		ProfileDTO profileDTO = new ProfileDTO();
		// Creating profiles
		profileDTO.createProfiles(this, profile);
	}

	/**
	 * Create profile model object
	 * 
	 * @param profile
	 *            , ProfileGridMaskObject
	 */
	private void createProfilePartsModelObject(ProfileGridMaskObject profile) {

		// Profile transformation object
		ProfileDTO profileDTO = new ProfileDTO();
		// Creating profiles
		profileDTO.createProfiles(this, profile);
	}

	/**
	 * This method create OpeningEntityObject from model design
	 * 
	 * @param bkgrdOpening
	 *            , BkgrdOpeningEntityObject
	 * @return ProfileAbstractObject
	 */
	public ProfileEntityObject createProfileEntityObject(
			BkgrdOpeningEntityObject bkgrdOpening) {

		ProfileEntityObject profileEntity = (ProfileEntityObject) ProfileDTO
				.getProfileAbstractObject(this, ProfileEntityObject.class,
						ProfilesType._parts_object.getValue(), bkgrdOpening);

		if (this.limitStartX1a != null) {
			profileEntity.setLimitStartX1a((ProfileLimitObject) ProfileDTO
					.getProfileAbstractObject(this.limitStartX1a,
							ProfileLimitObject.class,
							ProfilesType._parts_object.getValue(), null));
		}

		if (this.limitStartX1 != null) {
			profileEntity.setLimitStartX1((ProfileLimitObject) ProfileDTO
					.getProfileAbstractObject(this.limitStartX1,
							ProfileLimitObject.class,
							ProfilesType._parts_object.getValue(), null));
		}

		if (this.limitStartXC != null) {
			profileEntity.setLimitStartXC((ProfileLimitObject) ProfileDTO
					.getProfileAbstractObject(this.limitStartXC,
							ProfileLimitObject.class,
							ProfilesType._parts_object.getValue(), null));
		}

		if (this.limitStartX2 != null) {
			profileEntity.setLimitStartX2((ProfileLimitObject) ProfileDTO
					.getProfileAbstractObject(this.limitStartX2,
							ProfileLimitObject.class,
							ProfilesType._parts_object.getValue(), null));
		}

		if (this.limitStartX2c != null) {
			profileEntity.setLimitStartX2c((ProfileLimitObject) ProfileDTO
					.getProfileAbstractObject(this.limitStartX2c,
							ProfileLimitObject.class,
							ProfilesType._parts_object.getValue(), null));
		}

		if (this.limitStartY1a != null) {
			profileEntity.setLimitStartY1a((ProfileLimitObject) ProfileDTO
					.getProfileAbstractObject(this.limitStartY1a,
							ProfileLimitObject.class,
							ProfilesType._parts_object.getValue(), null));
		}

		if (this.limitStartY1 != null) {
			profileEntity.setLimitStartY1((ProfileLimitObject) ProfileDTO
					.getProfileAbstractObject(this.limitStartY1,
							ProfileLimitObject.class,
							ProfilesType._parts_object.getValue(), null));
		}

		if (this.limitStartYC != null) {
			profileEntity.setLimitStartYC((ProfileLimitObject) ProfileDTO
					.getProfileAbstractObject(this.limitStartYC,
							ProfileLimitObject.class,
							ProfilesType._parts_object.getValue(), null));
		}

		if (this.limitStartY2 != null) {
			profileEntity.setLimitStartY2((ProfileLimitObject) ProfileDTO
					.getProfileAbstractObject(this.limitStartY2,
							ProfileLimitObject.class,
							ProfilesType._parts_object.getValue(), null));
		}

		if (this.limitStartY2c != null) {
			profileEntity.setLimitStartY2c((ProfileLimitObject) ProfileDTO
					.getProfileAbstractObject(this.limitStartY2c,
							ProfileLimitObject.class,
							ProfilesType._parts_object.getValue(), null));
		}

		if (this.limitEndX4a != null) {
			profileEntity.setLimitEndX4a((ProfileLimitObject) ProfileDTO
					.getProfileAbstractObject(this.limitEndX4a,
							ProfileLimitObject.class,
							ProfilesType._parts_object.getValue(), null));
		}

		if (this.limitEndX4 != null) {
			profileEntity.setLimitEndX4((ProfileLimitObject) ProfileDTO
					.getProfileAbstractObject(this.limitEndX4,
							ProfileLimitObject.class,
							ProfilesType._parts_object.getValue(), null));
		}

		if (this.limitEndXC != null) {
			profileEntity.setLimitStartX1a((ProfileLimitObject) ProfileDTO
					.getProfileAbstractObject(this.limitEndXC,
							ProfileLimitObject.class,
							ProfilesType._parts_object.getValue(), null));
		}

		if (this.limitEndX3 != null) {
			profileEntity.setLimitEndX3((ProfileLimitObject) ProfileDTO
					.getProfileAbstractObject(this.limitEndX3,
							ProfileLimitObject.class,
							ProfilesType._parts_object.getValue(), null));
		}

		if (this.limitEndX3c != null) {
			profileEntity.setLimitEndX3c((ProfileLimitObject) ProfileDTO
					.getProfileAbstractObject(this.limitEndX3c,
							ProfileLimitObject.class,
							ProfilesType._parts_object.getValue(), null));
		}

		if (this.limitEndY4a != null) {
			profileEntity.setLimitEndY4a((ProfileLimitObject) ProfileDTO
					.getProfileAbstractObject(this.limitEndY4a,
							ProfileLimitObject.class,
							ProfilesType._parts_object.getValue(), null));
		}

		if (this.limitEndY4 != null) {
			profileEntity.setLimitEndY4((ProfileLimitObject) ProfileDTO
					.getProfileAbstractObject(this.limitEndY4,
							ProfileLimitObject.class,
							ProfilesType._parts_object.getValue(), null));
		}

		if (this.limitEndYC != null) {
			profileEntity.setLimitEndYC((ProfileLimitObject) ProfileDTO
					.getProfileAbstractObject(this.limitEndYC,
							ProfileLimitObject.class,
							ProfilesType._parts_object.getValue(), null));
		}

		if (this.limitEndY3 != null) {
			profileEntity.setLimitEndY3((ProfileLimitObject) ProfileDTO
					.getProfileAbstractObject(this.limitEndY3,
							ProfileLimitObject.class,
							ProfilesType._parts_object.getValue(), null));
		}

		if (this.limitEndY3c != null) {
			profileEntity.setLimitEndY3c((ProfileLimitObject) ProfileDTO
					.getProfileAbstractObject(this.limitEndY3c,
							ProfileLimitObject.class,
							ProfilesType._parts_object.getValue(), null));
		}

		return profileEntity;
	}

	/**
	 * Create Profile GRID Object
	 * 
	 * @param dlo
	 *            , DLOEntityObject
	 * @return ProfileGridObject
	 */
	public ProfileGridObject createProfileGridObject(DLOEntityObject dlo) {

		// Profile transformation object
		ProfileDTO profileDTO = new ProfileDTO();

		ProfileGridObject profileGrid = (ProfileGridObject) profileDTO
				.getProfileAbstractObject(this, ProfileGridObject.class,
						ProfilesType._parts_object.getValue(), null);

		return profileGrid;
	}

	/**
	 * Create Profile GRID Spoke object
	 * 
	 * @return ProfileGridSpokeObject
	 */
	public ProfileGridSpokeObject createProfileGridSpokeObject() {

		// Profile transformation object
		ProfileDTO profileDTO = new ProfileDTO();

		ProfileGridSpokeObject profileGrid = (ProfileGridSpokeObject) profileDTO
				.getProfileAbstractObject(this, ProfileGridSpokeObject.class,
						ProfilesType._parts_object.getValue(), null);

		return profileGrid;
	}

	/**
	 * Create Profile GRID MASK Object
	 * 
	 * @param dlo
	 *            , DLOEntityObject
	 * @return ProfileGridObject
	 */
	public ProfileGridMaskObject createProfileGridMaskObject(DLOEntityObject dlo) {

		// Profile transformation object
		ProfileDTO profileDTO = new ProfileDTO();

		ProfileGridMaskObject profileGridMask = (ProfileGridMaskObject) profileDTO
				.getProfileAbstractObject(this, ProfileGridMaskObject.class,
						ProfilesType._parts_object.getValue(), null);

		return profileGridMask;
	}

	public void clearBomForProfile() {

		Object[] boms = this.myFrame2.jobItem.bom.toArray();
		this.myFrame2.jobItem.bom.clear();
		for (Object b : boms) {
			if (!((BillOfMat) b).isMatchingPart(this)) {
				this.myFrame2.jobItem.bom.add((BillOfMat) b);
			}
		}
	}

	public void resetPartDims() {

		this.partDimBtoC = 0;
		this.partDimBtoCi = 0;
		this.partDimA = 0;
		this.partDimAi = 0;
		this.partDimB = 0;
		this.partDimBi = 0;
		this.partDimC = 0;
		this.partDimCi = 0;
		this.partDimM = 0;
		this.partDimMi = 0;
	}

	public Profiles setProfileDimsMIScale(final Profiles P) {

		P.partDimB = UOMConvert.getBigDecimalConversion(myFrame2.partDimB,
				myFrame2.metricscale, 2);
		P.partDimM = UOMConvert.getBigDecimalConversion(myFrame2.partDimM,
				myFrame2.metricscale, 2);
		P.partDimA = UOMConvert.getBigDecimalConversion(myFrame2.partDimA,
				myFrame2.metricscale, 2);
		P.partDimC = UOMConvert.getBigDecimalConversion(myFrame2.partDimC,
				myFrame2.metricscale, 2);
		P.partDimD = UOMConvert.getBigDecimalConversion(myFrame2.partDimD,
				myFrame2.metricscale, 2);
		P.partDimBtoC = UOMConvert.getBigDecimalConversion(myFrame2.partDimD,
				myFrame2.metricscale, 2);

		P.partDimBi = UOMConvert.getBigDecimalConversion(myFrame2.partDimB,
				myFrame2.metricscale, 2);
		P.partDimMi = UOMConvert.getBigDecimalConversion(myFrame2.partDimM,
				myFrame2.metricscale, 2);
		P.partDimAi = UOMConvert.getBigDecimalConversion(myFrame2.partDimA,
				myFrame2.metricscale, 2);
		P.partDimCi = UOMConvert.getBigDecimalConversion(myFrame2.partDimC,
				myFrame2.metricscale, 2);
		P.partDimDi = UOMConvert.getBigDecimalConversion(myFrame2.partDimD,
				myFrame2.metricscale, 2);
		P.partDimBtoCi = UOMConvert.getBigDecimalConversion(myFrame2.partDimD,
				myFrame2.metricscale, 2);

		return P;
	}

	@Override
	public Profiles clone() {

		try {

			// Clone Profiles model object
			Profiles newProfiles = (Profiles) super.clone();

			newProfiles.yCoordA = new ArrayList();
			newProfiles.xCoordA = new ArrayList();
			newProfiles.xCoordB = new ArrayList();
			newProfiles.yCoordB = new ArrayList();
			newProfiles.xCoordBA = new ArrayList();
			newProfiles.yCoordBA = new ArrayList();

			newProfiles.gp = (GeneralPath) newProfiles.gp.clone();
			newProfiles.gpShapes = (GeneralPath) newProfiles.gpShapes.clone();
			newProfiles.fillShape = (GeneralPath) newProfiles.fillShape.clone();
			newProfiles.curveB = (GeneralPath) newProfiles.curveB.clone();
			newProfiles.curveBA = (GeneralPath) newProfiles.curveBA.clone();
			newProfiles.curveA = (GeneralPath) newProfiles.curveA.clone();
			newProfiles.topObjectPath = (GeneralPath) newProfiles.topObjectPath
					.clone();
			newProfiles.topFillShape = (GeneralPath) newProfiles.topFillShape
					.clone();

			if (newProfiles.limitStartX1a != null) {
				newProfiles.limitStartX1a = newProfiles.limitStartX1a.clone();
			}

			if (newProfiles.limitStartX1 != null) {
				newProfiles.limitStartX1 = newProfiles.limitStartX1.clone();
			}

			if (newProfiles.limitStartXC != null) {
				newProfiles.limitStartXC = newProfiles.limitStartXC.clone();
			}

			if (newProfiles.limitStartX2 != null) {
				newProfiles.limitStartX2 = newProfiles.limitStartX2.clone();
			}

			if (newProfiles.limitStartX2c != null) {
				newProfiles.limitStartX2c = newProfiles.limitStartX2c.clone();
			}

			if (newProfiles.limitStartY1a != null) {
				newProfiles.limitStartY1a = newProfiles.limitStartY1a.clone();
			}

			if (newProfiles.limitStartY1 != null) {
				newProfiles.limitStartY1 = newProfiles.limitStartY1.clone();
			}

			if (newProfiles.limitStartYC != null) {
				newProfiles.limitStartYC = newProfiles.limitStartYC.clone();
			}

			if (newProfiles.limitStartY2 != null) {
				newProfiles.limitStartY2 = newProfiles.limitStartY2.clone();
			}

			if (newProfiles.limitStartY2c != null) {
				newProfiles.limitStartY2c = newProfiles.limitStartY2c.clone();
			}

			if (newProfiles.limitEndX4a != null) {
				newProfiles.limitEndX4a = newProfiles.limitEndX4a.clone();
			}

			if (newProfiles.limitEndX4 != null) {
				newProfiles.limitEndX4 = newProfiles.limitEndX4.clone();
			}

			if (newProfiles.limitEndXC != null) {
				newProfiles.limitEndXC = newProfiles.limitEndXC.clone();
			}

			if (newProfiles.limitEndX3 != null) {
				newProfiles.limitEndX3 = newProfiles.limitEndX3.clone();
			}

			if (newProfiles.limitEndX3c != null) {
				newProfiles.limitEndX3c = newProfiles.limitEndX3c.clone();
			}

			if (newProfiles.limitEndY4a != null) {
				newProfiles.limitEndY4a = newProfiles.limitEndY4a.clone();
			}

			if (newProfiles.limitEndY4 != null) {
				newProfiles.limitEndY4 = newProfiles.limitEndY4.clone();
			}

			if (newProfiles.limitEndYC != null) {
				newProfiles.limitEndYC = newProfiles.limitEndYC.clone();
			}

			if (newProfiles.limitEndY3 != null) {
				newProfiles.limitEndY3 = newProfiles.limitEndY3.clone();
			}

			if (newProfiles.limitEndY3c != null) {
				newProfiles.limitEndY3c = newProfiles.limitEndY3c.clone();
			}

			return newProfiles;

		} catch (CloneNotSupportedException e) {
			logger.error(e.getMessage(), e);
		}

		return null;
	}
}

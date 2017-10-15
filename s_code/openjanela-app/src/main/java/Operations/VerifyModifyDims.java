/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/

package Operations;

import java.math.BigDecimal;

import javax.swing.JOptionPane;

import Model.OpeningObject;
import Model.ShapeObject;
import Model.Frame;

public class VerifyModifyDims {

	public ShapeObject shapeObjects;

	public int myShape = 0;

	public int lean = 0;

	public int lean2 = 0;

	public int lean3 = 0;

	public int lean4 = 0;

	public double dimA1 = 0;

	public double dimA2 = 0;

	public double dimA3 = 0;

	public double dimA4 = 0;

	public double dimA5 = 0;

	public double dimA0 = 0;

	public double dimB1 = 0;

	public double dimB2 = 0;

	public double dimB3 = 0;

	public double dimB4 = 0;

	public double dimB5 = 0;

	public double dimB0 = 0;

	public double dimC1 = 0;

	public double dimC2 = 0;

	public double dimC3 = 0;

	public double dimC4 = 0;

	public double dimC5 = 0;

	public double dimC0 = 0;

	public double dimD1 = 0;

	public double dimD2 = 0;

	public double dimD3 = 0;

	public double dimD4 = 0;

	public double dimD5 = 0;

	public double dimD0 = 0;

	public double pA1 = 0;

	public double pA2 = 0;

	public double pA3 = 0;

	public double pA4 = 0;

	public double pA5 = 0;

	public double pA0 = 0;

	public double pB1 = 0;

	public double pB2 = 0;

	public double pB3 = 0;

	public double pB4 = 0;

	public double pB5 = 0;

	public double pB0 = 0;

	public double pC1 = 0;

	public double pC2 = 0;

	public double pC3 = 0;

	public double pC4 = 0;

	public double pC5 = 0;

	public double pC0 = 0;

	public double pD1 = 0;

	public double pD2 = 0;

	public double pD3 = 0;

	public double pD4 = 0;

	public double pD5 = 0;

	public double pD0 = 0;

	public double myw = 0;

	public double myh = 0;

	public double ow = 0;

	public double oh = 0;

	public double deltaA1 = 0;

	public double deltaD1 = 0;

	public double deltaC2 = 0;

	Frame frame;

	OpeningObject opening;

	public boolean doShapeDialog = false;

	public int errorSize = -1; // A1=
	// 11, A0=10, A2=12 B1=21, B0=20, C0=30,D0=40

	public BigDecimal myScale = new BigDecimal(0);

	public boolean inPix = false;

	public ShapeObject parent;

	public double myMinLeg = 0;

	public double shapeRadius = 0;

	public int resetWorH = 0;

	// etc

	VerifyModifyDims(final int myShape, final int lean, final int lean2,
			final int lean3, final int lean4, final double dimA1,
			final double dimA2, final double dimA3, final double dimA0,
			final double dimB1, final double dimB2, final double dimB0,
			final double dimC1, final double dimC2, final double dimC0,
			final double dimD1, final double dimD2, final double dimD0,
			final double w, final double h, final Object frame,
			final BigDecimal scale, final boolean inpix) {

		if (frame.getClass().getName().equals("levels.Frame")) {
			this.frame = (Frame) frame;
		} else if (frame.getClass().getName().equals("levels.OpeningObject")) {
			opening = (OpeningObject) frame;
		}
		parent = parent;
		myMinLeg = parent.minLeg * scale.doubleValue();
		inPix = inpix;
		myScale = scale;
		errorSize = -1;
		this.myShape = myShape;
		this.lean = lean;
		this.lean2 = lean2;
		this.lean3 = lean3;
		this.lean4 = lean4;

		if (inPix) {

			this.dimA1 = dimA1;
			this.dimA2 = dimA2;
			this.dimA3 = dimA3;
			this.dimA0 = dimA0;
			this.dimB1 = dimB1;
			this.dimB2 = dimB2;
			this.dimB0 = dimB0;
			this.dimC1 = dimC1;
			this.dimC2 = dimC2;
			this.dimC0 = dimC0;
			this.dimD1 = dimD1;
			this.dimD2 = dimD2;
			this.dimD0 = dimD0;
			ow = myw = w;
			oh = myh = h;
		} else {
			this.dimA1 = dimA1 * myScale.doubleValue();
			this.dimA2 = dimA2 * myScale.doubleValue();

			this.dimA3 = dimA3 * myScale.doubleValue();

			this.dimA0 = dimA0 * myScale.doubleValue();

			this.dimB1 = dimB1 * myScale.doubleValue();

			this.dimB2 = dimB2 * myScale.doubleValue();

			this.dimB0 = dimB0 * myScale.doubleValue();

			this.dimC1 = dimC1 * myScale.doubleValue();

			this.dimC2 = dimC2 * myScale.doubleValue();

			this.dimC0 = dimC0 * myScale.doubleValue();

			this.dimD1 = dimD1 * myScale.doubleValue();

			this.dimD2 = dimD2 * myScale.doubleValue();

			this.dimD0 = dimD0 * myScale.doubleValue();

			ow = myw = w * myScale.doubleValue();

			oh = myh = h * myScale.doubleValue();

		}

	}

	public void setPercentages(final Frame frame) {

		this.frame = frame;
		if (this.frame.shapeID > 10) {
			pA1 = this.frame.pA1;
			pA2 = this.frame.pA2;
			pA3 = this.frame.pA3;
			pA4 = this.frame.pA4;
			pA5 = this.frame.pA5;
			pA0 = this.frame.pA0;
			pB1 = this.frame.pB1;
			pB2 = this.frame.pB2;
			pB3 = this.frame.pB3;
			pB4 = this.frame.pB4;
			pB5 = this.frame.pB5;
			pB0 = this.frame.pB0;
			pC1 = this.frame.pC1;
			pC2 = this.frame.pC2;
			pC3 = this.frame.pC3;
			pC4 = this.frame.pC4;
			pC5 = this.frame.pC5;
			pC0 = this.frame.pC0;
			pD1 = this.frame.pD1;
			pD2 = this.frame.pD2;
			pD3 = this.frame.pD3;
			pD4 = this.frame.pD4;
			pD5 = this.frame.pD5;
			pD0 = this.frame.pD0;
		}

	}

	public VerifyModifyDims(final int myShape, final int lean, final int lean2,
			final int lean3, final int lean4, final double dimA1,
			final double dimA2, final double dimA3, final double dimA0,
			final double dimB1, final double dimB2, final double dimB0,
			final double dimC1, final double dimC2, final double dimC0,
			final double dimD1, final double dimD2, final double dimD0,
			final double w, final double h, final BigDecimal scale,
			final boolean inpix, final double minleg) {

		myScale = scale;

		inPix = inpix;
		// frame = frame;
		myMinLeg = minleg * scale.doubleValue();
		this.myShape = myShape;
		this.lean = lean;
		this.lean2 = lean2;
		this.lean3 = lean3;
		this.lean4 = lean4;

		if (inPix) {

			this.dimA1 = dimA1;
			this.dimA2 = dimA2;
			this.dimA3 = dimA3;
			this.dimA0 = dimA0;
			this.dimB1 = dimB1;
			this.dimB2 = dimB2;
			this.dimB0 = dimB0;
			this.dimC1 = dimC1;
			this.dimC2 = dimC2;
			this.dimC0 = dimC0;
			this.dimD1 = dimD1;
			this.dimD2 = dimD2;
			this.dimD0 = dimD0;
			ow = myw = myw = w;
			oh = myh = h;
		} else {
			this.dimA1 = dimA1 * myScale.doubleValue();
			this.dimA2 = dimA2 * myScale.doubleValue();

			this.dimA3 = dimA3 * myScale.doubleValue();

			this.dimA0 = dimA0 * myScale.doubleValue();

			this.dimB1 = dimB1 * myScale.doubleValue();

			this.dimB2 = dimB2 * myScale.doubleValue();
			this.dimB0 = dimB0 * myScale.doubleValue();

			this.dimC1 = dimC1 * myScale.doubleValue();

			this.dimC2 = dimC2 * myScale.doubleValue();

			this.dimC0 = dimC0 * myScale.doubleValue();

			this.dimD1 = dimD1 * myScale.doubleValue();

			this.dimD2 = dimD2 * myScale.doubleValue();

			this.dimD0 = dimD0 * myScale.doubleValue();

			ow = myw = w * myScale.doubleValue();

			oh = myh = h * myScale.doubleValue();

		}
	}

	public void verify4SidedShapeInput() {

		if (myShape == 1 || myShape == 10) {
			lean = 0;
			lean2 = 0;
			lean3 = 0;
			lean4 = 0;
			dimA1 = 0;
			dimA2 = 0;
			dimA3 = 0;
			dimA0 = 0;
			dimB1 = 0;
			dimB2 = 0;
			dimB0 = 0;
			dimC1 = 0;
			dimC2 = 0;
			dimC0 = 0;
			dimD1 = 0;
			dimD2 = 0;
			dimD0 = 0;
			pA1 = 0;
			pA2 = 0;
			pA3 = 0;
			pA4 = 0;
			pA5 = 0;
			pA0 = 0;
			pB1 = 0;
			pB2 = 0;
			pB3 = 0;
			pB4 = 0;
			pB5 = 0;
			pB0 = 0;
			pC1 = 0;
			pC2 = 0;
			pC3 = 0;
			pC4 = 0;
			pC5 = 0;
			pC0 = 0;
			pD1 = 0;
			pD2 = 0;
			pD3 = 0;
			pD4 = 0;
			pD5 = 0;
			pD0 = 0;
		}

		if (myShape == 90) {

			double side = 0;
			myw = myh = Math.max(oh, ow);
			final double diagonal = myw;

			myh = diagonal * Math.sin(Math.toRadians(72));
			resetWorH = 2;
			final double base = myh / Math.tan(Math.toRadians(72));

			final double apothem = base * Math.tan(Math.toRadians(54));

			final double radius = myh - apothem;
			shapeRadius = radius;

			side = 2 * base;
			dimC1 = side;
			dimA1 = dimA2 = myw / 2;
			dimB1 = dimD2 = dimA1 * Math.tan(Math.toRadians(36));
			dimB2 = dimD1 = myh - dimB1;
			dimC0 = dimC2 = (myw - side) / 2;

		} else if (myShape == 91) { // Hexagon Full

			double side = 0;
			myw = myh = Math.max(oh, ow);

			final double cA = 360 / 6;

			side = myw / 2;

			dimA3 = dimC1 = side;
			dimA1 = dimC2 = dimA2 = dimC0 = (myw - dimA3) / 2;
			dimB1 = dimD2 = side * Math.sin(Math.toRadians(cA));

			myh = 2 * dimB1;// this.h
			resetWorH = 2;
			dimB2 = dimD1 = dimB1;// -

		} else if (myShape == 92) {// hexagon Acute
									// Side = a/sqrt2 + a + a/sqrt2
									// a = S/(1+sqrt2)
			dimA3 = ow / (1 + Math.sqrt(2));
			dimA1 = dimA3 / Math.sqrt(2);
			dimA2 = dimA3 / Math.sqrt(2);
			dimB1 = dimA3 / Math.sqrt(2);
			dimB2 = dimA3 / Math.sqrt(2);
			dimD2 = dimA3 / Math.sqrt(2);
			dimD1 = dimA3 / Math.sqrt(2);
			dimC1 = ow / (1 + Math.sqrt(2));
			dimC0 = dimA3 / Math.sqrt(2);
			dimC2 = dimA3 / Math.sqrt(2);
			myh = 2 * dimD2;
			resetWorH = 2;
		} else if (myShape == 93) { // OctagonFull
									//
			double side = 0;

			myw = myh = Math.max(oh, ow);
			resetWorH = 3;
			final double sideA = 67.5f;

			final double y = myh / 2;

			final double base = y / Math.tan(Math.toRadians(sideA));
			side = base * 2;

			shapeRadius = y / Math.sin(Math.toRadians(sideA));

			dimA3 = dimC1 = dimB1 = dimD1 = side;

			dimA1 = dimA2 = dimC2 = dimC0 = dimB2 = dimB0 = dimD0 = dimD2 = (myw - dimA3) / 2;

		} else if (myShape == 100) {
			if (dimD0 > 0) {
				dimD1 = dimD1 + dimD0;
				dimD0 = 0;
			}
			if (dimD1 + dimD2 != oh || dimD1 <= 0) {
				dimD1 = oh - dimD2;
			}
			if (dimD1 < myMinLeg) {
				dimD1 = myMinLeg;

				dimD2 = oh - dimD1;

				JOptionPane.showMessageDialog(null,
						"Minimum Leg Size on shape:\n"
								+ "Dimensions were corrected to avoid Erros!",
						"Warning", JOptionPane.WARNING_MESSAGE);
				// UNDO
				errorSize = 42;
			}

		} else if (myShape == 101) {
			if (dimB0 > 0) {
				dimB1 = dimB2 + dimB0;
				dimB0 = 0;
			}
			if (dimB1 + dimB2 > oh || dimB2 <= 0) {
				dimB2 = oh - dimB1;
			}

			if (dimB2 < myMinLeg) {
				dimB2 = myMinLeg;

				dimB1 = oh - dimB2;

				JOptionPane.showMessageDialog(null,
						"Minimum Leg Size on shape:\n"
								+ "Dimensions were corrected to avoid Erros!",
						"Warning", JOptionPane.WARNING_MESSAGE);
				// UNDO
				errorSize = 21;
			}

		} else if (myShape == 102) {
			if (dimA0 > 0) {
				dimA2 = dimA2 + dimA0;
				dimA0 = 0;
			}

			if (dimA1 + dimA2 != ow || dimA2 <= 0) {
				dimA2 = ow - dimA1;
			}
			if (dimA2 < myMinLeg) {
				dimA2 = myMinLeg;

				dimA1 = ow - dimA2;

				JOptionPane.showMessageDialog(null,
						"Minimum Leg Size on shape:\n"
								+ "Dimensions were corrected to avoid Erros!",
						"Warning", JOptionPane.WARNING_MESSAGE);
				// UNDO
				errorSize = 11;
			}

		} else if (myShape == 103) {
			if (dimA0 > 0) {
				dimA1 = dimA1 + dimA0;
				dimA0 = 0;
			}
			if (dimA1 + dimA2 != ow || dimA1 <= 0) {
				dimA1 = ow - dimA2;
			}

			if (dimA1 < myMinLeg) {
				dimA1 = myMinLeg;

				dimA2 = ow - dimA1;

				JOptionPane.showMessageDialog(null,
						"Minimum Leg Size on shape:\n"
								+ "Dimensions were corrected to avoid Erros!",
						"Warning", JOptionPane.WARNING_MESSAGE);
				// UNDO
				errorSize = 12;
			}

		} else if (myShape == 104) {
			if (dimB0 > 0) {
				dimB1 = dimB0;
				dimB0 = 0;
			}
			if (dimB1 + dimB2 != oh || dimB1 <= 0) {
				dimB1 = oh - dimB2;
			}
			// this.dimB2 = this.h - this.dimB1;
			if (dimB1 < myMinLeg) {
				dimB1 = myMinLeg;

				dimB2 = oh - dimB1;

				JOptionPane.showMessageDialog(null,
						"Minimum Leg Size on shape:\n"
								+ "Dimensions were corrected to avoid Erros!",
						"Warning", JOptionPane.WARNING_MESSAGE);
				// UNDO
				errorSize = 22;
			}

		} else if (myShape == 105) {
			if (dimD0 > 0) {
				dimD1 = dimD1 + dimD0;
				dimB0 = 0;
			}
			if (dimD1 + dimD2 != oh || dimD1 <= 0) {
				dimD1 = oh - dimD2;
			}

		} else if (myShape == 106) {
			if (dimC0 > 0) {
				dimC1 = dimC0;
				dimC0 = 0;
			}
			if (dimC1 + dimC2 != ow || dimC2 <= 0) {
				dimC2 = ow - dimC1;
			}

		} else if (myShape == 107) {
			if (dimC0 > 0) {
				dimC1 = dimC1 + dimC0;
				dimC0 = 0;
			}
			if (dimC1 + dimC2 != ow || dimC1 <= 0) {
				dimC1 = ow - dimC2;
			}

		} else if (myShape == 108 || myShape == 109) {
			if (dimC0 > 0) {
				dimC1 = dimC1 + dimC0;
				dimC0 = 0;
			}
			if (dimC1 + dimC2 != ow || dimC1 <= 0) {
				dimC1 = ow - dimC2;
			}

			if (dimA0 > 0) {
				dimA2 = dimA2 + dimA0;
				dimA0 = 0;
			}
			if (dimA1 + dimA2 != ow || dimA1 <= 0) {
				dimA1 = ow - dimA2;
			}

		} else if (myShape == 110 || myShape == 111) {
			if (dimB0 > 0) {
				dimB1 = dimB0;
				dimB0 = 0;
			}
			if (dimB1 + dimB2 != ow) {
				dimB2 = oh - dimB1;
			}

			if (dimD0 > 0) {
				dimD1 = dimD1 + dimD0;
				dimD0 = 0;
			}
			if (dimD1 + dimD2 != ow || dimD2 <= 0) {
				dimD2 = oh - dimD1;
			}

		} else if (myShape == 112) {
			dimD1 = oh;
			dimD2 = 0;
			dimD0 = 0;
			dimB1 = oh;
			dimB2 = 0;
			dimB0 = 0;
			dimC1 = ow;
			dimC2 = 0;
			dimC0 = 0;
			if (dimA0 == 0 || dimA1 == 0 || dimA2 == 0) {
				dimA0 = dimA1 = dimA2 = ow / 3;
			}

		} else if (myShape == 113) {
			dimD1 = oh;
			dimD2 = 0;
			dimD0 = 0;
			dimA1 = ow;
			dimA2 = 0;
			dimA0 = 0;
			dimC1 = ow;
			dimC2 = 0;
			dimC0 = 0;
			if (dimB0 == 0) {
				dimB0 = dimB1 = dimB2 = oh / 3;
			}
		} else if (myShape == 114) {
			dimB1 = oh;
			dimB2 = 0;
			dimB0 = 0;
			dimA1 = ow;
			dimA2 = 0;
			dimA0 = 0;
			dimD1 = oh;
			dimD2 = 0;
			dimD0 = 0;
			if (dimC0 == 0 || dimC1 == 0 || dimC2 == 0) {
				dimC0 = dimC1 = dimC2 = ow / 3;
			}
		} else if (myShape == 115) {
			dimB1 = oh;
			dimB2 = 0;
			dimB0 = 0;
			dimA1 = ow;
			dimA2 = 0;
			dimA0 = 0;
			dimC1 = ow;
			dimC2 = 0;
			dimC0 = 0;

		} else if (myShape == 150) {

			if (dimA0 > 0) {
				dimA2 = dimA1 = ow / 2;
				dimA0 = 0;
			}
			if (dimD0 > 0) {
				dimD1 = dimD1 + dimD0;
				dimD0 = 0;
			}
			// if (dimD1 + dimD2 != oh || dimB2 <= 0) {
			// dimD2 = oh - dimD1;
			// }
			// if (dimB1 + dimB2 != oh || dimB1 <= 0) {
			// dimB1 = oh - dimB2;
			// }

		} else if (myShape == 154) {
			dimA0 = 0;
			dimA2 = ow - dimA1;
			dimD0 = 0;
			dimD1 = oh - dimD2;
		} else if (myShape == 155) {

			dimA0 = 0;
			dimA1 = ow - dimA2;
			dimB0 = 0;
			dimB2 = oh - dimB1;

		} else if (myShape == 160) {
			dimA0 = 0;
			dimA3 = ow - dimA2 - dimA1;
			dimD0 = 0;
			dimD1 = oh - dimD2;
			dimB0 = 0;
			dimB2 = oh - dimB1;
		} else if (myShape == 165) {
			// Side = a/sqrt2 + a + a/sqrt2
			// a = S/(1+sqrt2)
			dimA3 = ow / (1 + Math.sqrt(2));
			dimA1 = dimA3 / Math.sqrt(2);
			dimA2 = dimA3 / Math.sqrt(2);
			dimB1 = dimA3 / Math.sqrt(2);
			dimD2 = dimA3 / Math.sqrt(2);

		} else if (myShape == 200) {
			myh = oh;
			myw = ow;

			if (myh < myw) {
				myShape = 300;
				dimD2 = dimB1 = myh - this.myMinLeg;
				dimD1 = dimB2 = this.myMinLeg;

			}

			if (dimD2 != ow / 2 || dimB1 != ow / 2) {
				myShape = 300;
				dimD1 = dimB2 = oh - dimD2;
			}

		} else if (myShape == 201) {
			if (ow != dimD2) {
				myShape = 301;
			}
			if (myh <= myw) {
				myh = myw + parent.minLeg;
				this.resetWorH = 3;
			}
			dimD2 = ow;
			dimD1 = oh - dimD2;
			dimB1 = dimB2 = 0;
			// }

		} else if (myShape == 202) {
			if (ow != dimB1) {
				myShape = 302;
			}
			if (myh <= myw) {
				myh = myw + parent.minLeg;
				this.resetWorH = 3;
			}
			dimB1 = ow;
			dimB2 = oh - dimB1;
			dimD1 = dimD2 = 0;

			// }

		} else if (myShape == 203) {
			if (oh != ow / 2) {
				myh = ow / 2;
				dimB1 = dimD2 = myh;
				myShape = 303;

				// resetWorH = 2;
			} else if (oh == ow / 2) {
				myw = ow;
				myh = oh;
				dimB1 = dimD2 = oh;
			}

		} else if (myShape == 204) {
			if (oh != ow) {
				myShape = 304;
				// oh = ow;
				dimD2 = oh;
				resetWorH = 0;
			} else {
				dimD2 = oh;
			}

		} else if (myShape == 205) {
			if (oh != ow) {
				myShape = 305;
				// oh = ow;
				dimB1 = oh;

				resetWorH = 0;
			} else {
				dimB1 = oh;

			}

		} else if (myShape == 300) {

			dimD1 = dimB2 = oh - dimD2;

		} else if (myShape == 301) {

			dimD1 = oh - dimD2;
			dimB1 = dimB2 = 0;

		} else if (myShape == 302) {

			dimB2 = oh - dimB1;
			dimD1 = dimD2 = 0;

		} else if (myShape == 303) {

			// resetWorH = 0;
			// myw = ow;
			// myh = oh;
			// dimB1 = dimD2 = oh;

			// if (oh != ow / 2)
			// {
//			myh = ow / 2;
//			dimB1 =  myh;
			// myShape = 303;

			// resetWorH = 2;
			// }
			// else
			if (oh == ow) {
				myShape = 203;
				myw = ow;
				myh = oh;
				dimB1 =  oh;
			}

		} else if (myShape == 304) {

			// dimB1 = dimD2 = myh = oh;
			// resetWorH = 0;

			// if (oh != ow)
			// {
//			myShape = 304;
//			// oh = ow;
//			dimD2 = oh;
//			resetWorH = 0;
			// }
			if (oh == ow) {
				myShape = 204;
				dimD2 = oh;
			}

		} else if (myShape == 305) {

//			dimB1 = dimD2 = myh = oh;
//			resetWorH = 0;

		} else if (myShape == 401) {// equilateral

			dimB1 = dimB2 = 0;

		} else if (myShape == 402) {// equilateral

			dimD2 = dimD1 = 0;

		} else if (myShape == 403 || myShape == 400) {// equilateral

			dimD2 = dimB1;

		} else if (myShape == 450) {// Ext Gothic
									// ow = oh = Math.max(ow,oh);
			dimD2 = Math.sqrt(Math.pow(ow, 2) - Math.pow((ow / 2), 2));
			dimA1 = ow / 2;
			dimA2 = dimA1;
			dimB1 = dimD2;
			dimD1 = oh - dimD2;
			dimB2 = oh - dimB1;

		} else if (myShape == 453) {// gothic
									// ow = oh = Math.max(ow,oh);
			dimD2 = oh = Math.sqrt(Math.pow(ow, 2) - Math.pow((ow / 2), 2));
			dimA1 = ow / 2;
			dimA2 = dimA1;
			dimB1 = dimD2;
			dimD1 = oh - dimD2;
			dimB2 = oh - dimB1;

		} else if (myShape == 454) {// Ext Quinto Acuto
			dimD2 = Math.sqrt(Math.pow(4 * ow / 5, 2)
					- Math.pow((4 * ow / 5 - ow / 2), 2));
			dimA1 = ow / 2;
			dimA2 = dimA1;
			dimB1 = dimD2;
			dimD1 = oh - dimD2;
			dimB2 = oh - dimB1;

		} else if (myShape == 455) {// Quinto Acuto
									// ow = oh = Math.max(ow,oh);
			dimD2 = oh = Math.sqrt(Math.pow(4 * ow / 5, 2)
					- Math.pow((4 * ow / 5 - ow / 2), 2));
			dimA1 = ow / 2;
			dimA2 = dimA1;
			dimB1 = dimD2;
			dimD1 = oh - dimD2;
			dimB2 = oh - dimB1;

		} else if (myShape == 456) {// Ext Mezzo Acuto
									// ow = oh = Math.max(ow,oh);
			dimD2 = Math.sqrt(Math.pow(3.25 * ow / 5, 2)
					- Math.pow(3.25 * ow / 5 - ow / 2, 2));
			dimA1 = ow / 2;
			dimA2 = dimA1;
			dimB1 = dimD2;
			dimD1 = oh - dimD2;
			dimB2 = oh - dimB1;

		} else if (myShape == 457) {// Mezzo Acuto
									// ow = oh = Math.max(ow,oh);
			dimD2 = oh = Math.sqrt(Math.pow(3.25 * ow / 5, 2)
					- Math.pow(3.25 * ow / 5 - ow / 2, 2));
			dimA1 = ow / 2;
			dimA2 = dimA1;
			dimB1 = dimD2;
			dimD1 = oh - dimD2;
			dimB2 = oh - dimB1;

		} else if (myShape == 458) {// Ext recto Acuto
									// ow = oh = Math.max(ow,oh);
			if (dimD1 < myMinLeg || dimD1 == 0) {
				dimD1 = myMinLeg;
			}
			if (ow >= oh) {
				myw = oh - dimD1;

			}
			dimD2 = Math.sqrt(Math.pow(5 * ow / 4, 2)
					- Math.pow((5 * ow / 4 - ow / 2), 2));
			dimA1 = ow / 2;
			dimA2 = dimA1;
			dimB1 = dimD2;
			dimD1 = oh - dimD2;
			dimB2 = oh - dimB1;

		} else if (myShape == 459) {// recto Acuto
									// ow = oh = Math.max(ow,oh);
									// if (dimD1 < myMinLeg || dimD1 == 0) {
									// dimD1 = myMinLeg;
									// }
									// if (ow >= oh) {
									// myw =oh- dimD1;
									//
									// }
			dimD2 = oh = Math.sqrt(Math.pow(5 * ow / 4, 2)
					- Math.pow((5 * ow / 4 - ow / 2), 2));
			dimA1 = ow / 2;
			dimA2 = dimA1;
			dimB1 = dimD2;
			dimD1 = oh - dimD2;
			dimB2 = oh - dimB1;

		} else if (myShape == 460) {// ext doble Acuto
									// ow = oh = Math.max(ow,oh);
			if (dimD1 < myMinLeg || dimD1 == 0) {
				dimD1 = myMinLeg;
			}
			if (ow >= oh) {
				myw = 8 * oh / 10 - dimD1;

			}
			dimD2 = Math.sqrt(Math.pow(2 * ow, 2)
					- Math.pow((2 * ow - ow / 2), 2));
			dimA1 = ow / 2;
			dimA2 = dimA1;
			dimB1 = dimD2;
			dimD1 = oh - dimD2;
			dimB2 = oh - dimB1;

		} else if (myShape == 461) {// doble Acuto
									// ow = oh = Math.max(ow,oh);
			if (dimD1 < myMinLeg || dimD1 == 0) {
				dimD1 = myMinLeg;
			}
			if (ow >= oh) {
				myw = 8 * oh / 10 - dimD1;

			}
			dimD2 = Math.sqrt(Math.pow(2 * ow, 2)
					- Math.pow((2 * ow - ow / 2), 2));
			dimA1 = ow / 2;
			dimA2 = dimA1;
			dimB1 = dimD2;
			dimD1 = oh - dimD2;
			dimB2 = oh - dimB1;

		} else if (myShape == 700) {
			dimD2 = oh;
			dimD1 = 0;
			dimD0 = 0;
		} else if (myShape == 701) {
			dimB1 = oh;
			dimB2 = 0;
			dimB0 = 0;
		} else if (myShape == 702) {
			if (dimD2 == 0 || dimD0 + dimD2 != oh) {
				dimD2 = oh / 2;
			}
			dimD0 = Math.abs(oh - dimD2);
			dimD1 = 0;
		} else if (myShape == 703) {
			if (dimB0 == 0 || dimB0 + dimB2 != oh) {
				dimB0 = oh / 2;
			}
			dimB2 = Math.abs(oh - dimB0);
			dimB1 = 0;

		} else if (myShape == 704) {
			if (dimA1 == 0) {
				dimA1 = ow / 2;
			}
			dimA2 = Math.abs(ow - dimA1);
			dimD2 = dimB1 = oh;
			dimA0 = 0;
		} else if (myShape == 705) {
			dimD1 = oh;
			dimD2 = 0;
			dimD0 = 0;
		} else if (myShape == 706) {
			dimB2 = oh;
			dimB1 = 0;
			dimB0 = 0;
		} else if (myShape == 800) {
			// myw = myh = Math.max(myw, myh);
			dimB1 = dimD2 = dimB2 = dimD1 = myh / 2;
			dimA1 = dimC2 = dimA2 = dimC1 = myw / 2;
			// this.resetWorH = 3;

		} else if (myShape == 801) {
			dimB1 = dimD2 = dimB2 = dimD1 = myh / 2;
			dimA1 = dimC2 = dimA2 = dimC1 = myw / 2;

		} else if (myShape == 802) {
			dimB1 = dimD2 = dimB2 = dimD1 = myh / 2;
			dimA1 = dimC2 = dimA2 = dimC1 = myw / 2;
		}

	}

}

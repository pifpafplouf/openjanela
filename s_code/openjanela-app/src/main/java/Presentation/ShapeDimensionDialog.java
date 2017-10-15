/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/

package Presentation;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.UOMConvert;
import util.XYConstraints;
import util.XYLayout;
import Model.Facet;
import Model.Frame;
import Model.MullionObject;
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
import Operations.CreateFacets;
import Operations.CreateOpenings;
import Operations.CreateShapeMethods;
import Operations.NumSidesShapes;
import Operations.ShapeLeanDisallow;

public class ShapeDimensionDialog {

	public JButton jButtonClose = new JButton();

	public JButton jButtonSet = new JButton();

	public JPanel changeShapePanel = new JPanel();

	// public JPanel northPanel = new JPanel();

	public JPanel centerPanel = new JPanel();

	public JPanel topPanel = new JPanel();

	public JPanel leftPanel = new JPanel();

	public JPanel botPanel = new JPanel();

	public JPanel rightPanel = new JPanel();

	public JPanel drawingPanel = new JPanel();

	public JPanel buttonPanel = new JPanel();

	public JPanel buttons = new JPanel();

	public JDialog ShapeDimDialog = new JDialog();

	public JButton save = new JButton("Set");

	public JButton cancel = new JButton("Cancel");

	public JTextField dimA0 = new JTextField("00.000000");

	public JTextField dimA1 = new JTextField("00.000000");

	public JTextField dimA2 = new JTextField("00.000000");

	public JTextField dimA3 = new JTextField("00.000000");

	public JTextField dimB0 = new JTextField("00.000000");

	public JTextField dimB1 = new JTextField("00.000000");

	public JTextField dimB2 = new JTextField("00.000000");

	public JTextField dimC0 = new JTextField("00.000000");

	public JTextField dimC1 = new JTextField("00.000000");

	public JTextField dimC2 = new JTextField("00.000000");

	public JTextField dimD0 = new JTextField("00.000000");

	public JTextField dimD1 = new JTextField("00.000000");

	public JTextField dimD2 = new JTextField("00.000000");

	NumSidesShapes noSides;

	int totalSides = 4;

	int noSidesTop = 1;

	int noSidesBot = 1;

	int noSidesLeft = 1;

	int noSidesRight = 1;

	public DrawCanvas myDrawCanvas = null;

	public DrawShapeDims drawShape;

	ShapeObject myOpening = null;

	ShapeLeanDisallow leanTo = null;

	Object[] myFrameObjects;

	int selectedShapeLevel = 1;

	int shapeID = 1;

	BigDecimal myScale = new BigDecimal(0);

	DecimalFormat sixDecimals = new DecimalFormat("0.000000");

	DecimalFormat twoDecimals = new DecimalFormat("0.00");

	/**
	 * Default Constructor
	 * 
	 * @param drawCanvas
	 *            , DrawCanvas
	 * @param mySelectedOpening
	 *            , OpeningObject
	 * @param xxx
	 *            , Axis x position
	 * @param yyy
	 *            , Axis y position
	 * @param shapeLevel
	 *            , ShapeLevel
	 * @param shapeid
	 *            , ShapeId
	 */
	public ShapeDimensionDialog(DrawCanvas drawCanvas,
			ShapeObject mySelectedOpening, int xxx, int yyy, int shapeLevel,
			int shapeid) {

		// Setting DrawCanvas
		myDrawCanvas = drawCanvas;

		// Config message
		String changeShapeLevelToOverall = "Selected Level for Shape Change\n"
				+ "will be set to Overall!";
		String CouplersInOddShape = "No Couplers are allowed for selected Shape.\n"
				+ "Please contact you supplier for further solutions.";

		if (myDrawCanvas.myParent.myTopPanel.metric.isSelected()) {
			myScale = myDrawCanvas.myParent.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myDrawCanvas.myParent.scale;
		}

		shapeID = shapeid;
		selectedShapeLevel = shapeLevel;
		boolean goodtoGo = true;

		if (selectedShapeLevel > 1) {

			if (shapeID > 10 && shapeID < 100 || shapeID >= 800) {

				if (myDrawCanvas.myParent.jobItem.design.bOpeningObject.xCols == 1
						&& myDrawCanvas.myParent.jobItem.design.bOpeningObject.yRows == 1) {
					selectedShapeLevel = 1;
					myDrawCanvas.myParent.shapesPanel.overallB
							.setSelected(true);
					myDrawCanvas.myParent.shapesPanel.frameB.setSelected(false);
					JOptionPane.showMessageDialog(null,
							changeShapeLevelToOverall, "Warning!",
							JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, CouplersInOddShape,
							"Error!", JOptionPane.ERROR_MESSAGE);
					goodtoGo = false;
				}
			}
		}

		if (selectedShapeLevel == 1) {
			if (shapeID == 705 || shapeID == 706 || shapeID == 702
					|| shapeID == 703) {
				if (myDrawCanvas.myParent.facetUsed.bOpeningObject.mullions
						.size() > 0
						|| myDrawCanvas.myParent.facetUsed.bOpeningObject.mullionsH
								.size() > 0) {
					JOptionPane.showMessageDialog(null, CouplersInOddShape,
							"Error!", JOptionPane.ERROR_MESSAGE);
					goodtoGo = false;
				}
			}
		}

		if (selectedShapeLevel == 1) {

			if (myDrawCanvas.myParent.facetUsed == null) {
				goodtoGo = false;
			}

			if (myDrawCanvas.myParent.facetUsed.bOpeningObject == null) {
				goodtoGo = false;
			}

			myOpening = myDrawCanvas.myParent.facetUsed.myParentO;

			goodtoGo = checkForSubFrames(goodtoGo);

		} else {
			myOpening = mySelectedOpening;
			goodtoGo = checkForSubFrames(goodtoGo);
		}

		if (goodtoGo) {
			this.initialize();
		}
	}

	public boolean checkForSubFrames(boolean goodtoGo) {

		final Object[] frames = myDrawCanvas.myParent.facetUsed.frames
				.toArray();
		for (final Object f : frames) {
			final Object[] ops = ((Frame) f).openings.toArray();
			if (goodtoGo) {
				for (final Object o : ops) {
					if (((OpeningObject) o).contentMid == 3) {
						JOptionPane
								.showMessageDialog(
										null,
										"Design contains Sub-Frames!\n"
												+ "Shape Changes are no longer allowed!\n"
												+ "Please remove Sub-Frame(s) to perform Shape Change.",
										"Invalid Opening Selected - Error!",
										JOptionPane.WARNING_MESSAGE);
						goodtoGo = false;
						break;
					}
				}
			} else {
				break;
			}
		}
		return goodtoGo;
	}

	public void initialize() {

		doInit();
	}

	public void doInit() {

		this.setTopLeanGroup(shapeID);

		if (leanTo.doShapeDialog) {

			ShapeDimDialog = new JDialog(myDrawCanvas.myParent.myParent,
					"Set/Edit Shape Dimensions");

			ShapeDimDialog.setModal(true);

			changeShapePanel.setLayout(new BorderLayout());
			String title = "";
			if (myDrawCanvas.myParent.currentUOM == 1) {

				title = "Shape: " + shapeID + " Width= " + myOpening.widthPix
						/ myScale.doubleValue() + " Height= "
						+ myOpening.heightPix / myScale.doubleValue();
			} else {

				title = "Shape: " + shapeID + " Width= " + myOpening.widthPix
						/ myScale.doubleValue() / 64 + " Height= "
						+ myOpening.heightPix / myScale.doubleValue() / 64;
			}

			changeShapePanel.setBorder(BorderFactory.createTitledBorder(title));
			changeShapePanel.setPreferredSize(new Dimension(450, 400));

			topPanel.setLayout(new XYLayout());
			topPanel.setPreferredSize(new Dimension(400, 30));
			leftPanel.setLayout(new XYLayout());
			leftPanel.setPreferredSize(new Dimension(80, 400));
			botPanel.setLayout(new XYLayout());
			botPanel.setPreferredSize(new Dimension(398, 30));
			buttonPanel.setPreferredSize(new Dimension(398, 24));
			buttonPanel.setBorder(BorderFactory.createEtchedBorder());
			buttons.setPreferredSize(new Dimension(123, 24));
			buttonPanel.setLayout(new BorderLayout());
			buttons.setLayout(new XYLayout());

			rightPanel.setLayout(new XYLayout());
			rightPanel.setPreferredSize(new Dimension(80, 400));
			centerPanel.setLayout(new BorderLayout());
			centerPanel.setPreferredSize(new Dimension(400, 300));
			// centerPanel.setBorder(BorderFactory.createEtchedBorder());

			this.setTexts();
			this.textActions();

			buttons.add(save, new XYConstraints(1, 1, 60, 18));
			buttons.add(cancel, new XYConstraints(62, 1, 60, 18));

			buttonPanel.add(buttons, BorderLayout.EAST);

			changeShapePanel.add(centerPanel, BorderLayout.CENTER);
			changeShapePanel.add(buttonPanel, BorderLayout.SOUTH);

			drawShape = new DrawShapeDims(this);
			centerPanel.add(topPanel, BorderLayout.NORTH);
			centerPanel.add(botPanel, BorderLayout.SOUTH);
			centerPanel.add(leftPanel, BorderLayout.WEST);
			centerPanel.add(rightPanel, BorderLayout.EAST);
			centerPanel.add(drawShape.drawPanel, BorderLayout.CENTER);

			ShapeDimDialog.getContentPane().add(changeShapePanel, null);
			ShapeDimDialog.setLocation(
					(myDrawCanvas.myParent.getWidth() - 500) / 2 - 70,
					(myDrawCanvas.myParent.getHeight() - 200) / 2 - 160);
			ShapeDimDialog.getContentPane().setSize(500, 500);
			ShapeDimDialog.setResizable(false);
			ShapeDimDialog.pack();
			ShapeDimDialog.setVisible(true);
			ShapeDimDialog.setAlwaysOnTop(true);
			ShapeDimDialog.setModal(true);
			ShapeDimDialog.setModalityType(Dialog.ModalityType.TOOLKIT_MODAL);

		} else {
			this.doShapeSize();
		}
	}

	public void textActions() {

		dimA0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				ShapeDimensionDialog.this.top_actionPerformed(e);
			}

		});
		dimA1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				ShapeDimensionDialog.this.top_actionPerformed(e);
			}

		});
		dimA2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				ShapeDimensionDialog.this.top_actionPerformed(e);
			}

		});
		dimA3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				ShapeDimensionDialog.this.top_actionPerformed(e);
			}

		});
		dimB0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				ShapeDimensionDialog.this.right_actionPerformed(e);
			}

		});
		dimB1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				ShapeDimensionDialog.this.right_actionPerformed(e);
			}

		});
		dimB2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				ShapeDimensionDialog.this.right_actionPerformed(e);
			}

		});
		dimC0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				ShapeDimensionDialog.this.bot_actionPerformed(e);
			}

		});
		dimC1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				ShapeDimensionDialog.this.bot_actionPerformed(e);
			}

		});
		dimC2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				ShapeDimensionDialog.this.bot_actionPerformed(e);
			}

		});
		dimD0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				ShapeDimensionDialog.this.left_actionPerformed(e);
			}

		});
		dimD1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				ShapeDimensionDialog.this.left_actionPerformed(e);
			}

		});
		dimD2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				ShapeDimensionDialog.this.left_actionPerformed(e);
			}

		});
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				ShapeDimensionDialog.this.jButtonSet_actionPerformed(e);
			}
		});

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				ShapeDimensionDialog.this.jButtonClose_actionPerformed(e);
			}
		});

	}

	public void setTopLeanGroup(int shapeid) {

		if (this.myDrawCanvas.myParent.currentUOM == 1) {
			leanTo = new ShapeLeanDisallow(shapeid, myOpening.widthM,
					myOpening.heightM, myOpening.minLeg,
					myDrawCanvas.myParent.currentUOM, myDrawCanvas.myParent);
		} else {
			leanTo = new ShapeLeanDisallow(shapeid, myOpening.widthI,
					myOpening.heightI, myOpening.minLeg,
					myDrawCanvas.myParent.currentUOM, myDrawCanvas.myParent);
		}

		myDrawCanvas.selectedShapeID = leanTo.myShape;

		noSides = new NumSidesShapes(myDrawCanvas.selectedShapeID);

		this.totalSides = noSides.noSides;
		this.noSidesTop = noSides.noSidesTop;
		this.noSidesBot = noSides.noSidesBot;
		this.noSidesLeft = noSides.noSidesLeft;
		this.noSidesRight = noSides.noSidesRight;

	}

	public void setTexts() {

		double a0 = leanTo.dimA0;
		double a1 = leanTo.dimA1;
		double a2 = leanTo.dimA2;
		double a3 = leanTo.dimA3;

		double b0 = leanTo.dimB0;
		double b1 = leanTo.dimB1;
		double b2 = leanTo.dimB2;

		double c0 = leanTo.dimC0;
		double c1 = leanTo.dimC1;
		double c2 = leanTo.dimC2;

		double d0 = leanTo.dimD0;
		double d1 = leanTo.dimD1;
		double d2 = leanTo.dimD2;

		if (this.myDrawCanvas.myParent.currentUOM == 1) {
			a0 = Double.parseDouble(twoDecimals
					.format(this.myDrawCanvas.myParent.roundDim(a0, 0,
							this.myDrawCanvas.myParent.metricRound, 0)));
			a1 = Double.parseDouble(twoDecimals
					.format(this.myDrawCanvas.myParent.roundDim(a1, 0,
							this.myDrawCanvas.myParent.metricRound, 0)));
			a2 = Double.parseDouble(twoDecimals
					.format(this.myDrawCanvas.myParent.roundDim(a2, 0,
							this.myDrawCanvas.myParent.metricRound, 0)));
			a3 = Double.parseDouble(twoDecimals
					.format(this.myDrawCanvas.myParent.roundDim(a3, 0,
							this.myDrawCanvas.myParent.metricRound, 0)));

			b0 = Double.parseDouble(twoDecimals
					.format(this.myDrawCanvas.myParent.roundDim(b0, 0,
							this.myDrawCanvas.myParent.metricRound, 0)));
			b1 = Double.parseDouble(twoDecimals
					.format(this.myDrawCanvas.myParent.roundDim(b1, 0,
							this.myDrawCanvas.myParent.metricRound, 0)));
			b2 = Double.parseDouble(twoDecimals
					.format(this.myDrawCanvas.myParent.roundDim(b2, 0,
							this.myDrawCanvas.myParent.metricRound, 0)));

			c0 = Double.parseDouble(twoDecimals
					.format(this.myDrawCanvas.myParent.roundDim(c0, 0,
							this.myDrawCanvas.myParent.metricRound, 0)));
			c1 = Double.parseDouble(twoDecimals
					.format(this.myDrawCanvas.myParent.roundDim(c1, 0,
							this.myDrawCanvas.myParent.metricRound, 0)));
			c2 = Double.parseDouble(twoDecimals
					.format(this.myDrawCanvas.myParent.roundDim(c2, 0,
							this.myDrawCanvas.myParent.metricRound, 0)));

			d0 = Double.parseDouble(twoDecimals
					.format(this.myDrawCanvas.myParent.roundDim(d0, 0,
							this.myDrawCanvas.myParent.metricRound, 0)));
			d1 = Double.parseDouble(twoDecimals
					.format(this.myDrawCanvas.myParent.roundDim(d1, 0,
							this.myDrawCanvas.myParent.metricRound, 0)));
			d2 = Double.parseDouble(twoDecimals
					.format(this.myDrawCanvas.myParent.roundDim(d2, 0,
							this.myDrawCanvas.myParent.metricRound, 0)));
		} else if (this.myDrawCanvas.myParent.currentUOM > 1) {
			a0 = Double.parseDouble(sixDecimals
					.format(this.myDrawCanvas.myParent.roundDim(a0, 0,
							this.myDrawCanvas.myParent.impRound, 0)));
			a1 = Double.parseDouble(sixDecimals
					.format(this.myDrawCanvas.myParent.roundDim(a1, 0,
							this.myDrawCanvas.myParent.impRound, 0)));
			a2 = Double.parseDouble(sixDecimals
					.format(this.myDrawCanvas.myParent.roundDim(a2, 0,
							this.myDrawCanvas.myParent.impRound, 0)));
			a3 = Double.parseDouble(sixDecimals
					.format(this.myDrawCanvas.myParent.roundDim(a3, 0,
							this.myDrawCanvas.myParent.impRound, 0)));

			b0 = Double.parseDouble(sixDecimals
					.format(this.myDrawCanvas.myParent.roundDim(b0, 0,
							this.myDrawCanvas.myParent.impRound, 0)));
			b1 = Double.parseDouble(sixDecimals
					.format(this.myDrawCanvas.myParent.roundDim(b1, 0,
							this.myDrawCanvas.myParent.impRound, 0)));
			b2 = Double.parseDouble(sixDecimals
					.format(this.myDrawCanvas.myParent.roundDim(b2, 0,
							this.myDrawCanvas.myParent.impRound, 0)));

			c0 = Double.parseDouble(sixDecimals
					.format(this.myDrawCanvas.myParent.roundDim(c0, 0,
							this.myDrawCanvas.myParent.impRound, 0)));
			c1 = Double.parseDouble(sixDecimals
					.format(this.myDrawCanvas.myParent.roundDim(c1, 0,
							this.myDrawCanvas.myParent.impRound, 0)));
			c2 = Double.parseDouble(sixDecimals
					.format(this.myDrawCanvas.myParent.roundDim(c2, 0,
							this.myDrawCanvas.myParent.impRound, 0)));

			d0 = Double.parseDouble(sixDecimals
					.format(this.myDrawCanvas.myParent.roundDim(d0, 0,
							this.myDrawCanvas.myParent.impRound, 0)));
			d1 = Double.parseDouble(sixDecimals
					.format(this.myDrawCanvas.myParent.roundDim(d1, 0,
							this.myDrawCanvas.myParent.impRound, 0)));
			d2 = Double.parseDouble(sixDecimals
					.format(this.myDrawCanvas.myParent.roundDim(d2, 0,
							this.myDrawCanvas.myParent.impRound, 0)));
		}

		if (myOpening.shapeID == this.shapeID
				&& (this.myOpening.dimA0 != 0 || this.myOpening.dimA1 != 0
						|| this.myOpening.dimA2 != 0
						|| this.myOpening.dimA3 != 0
						|| this.myOpening.dimB0 != 0
						|| this.myOpening.dimB1 != 0
						|| this.myOpening.dimB2 != 0
						|| this.myOpening.dimC0 != 0 ||

						this.myOpening.dimC1 != 0 ||

						this.myOpening.dimC2 != 0 || this.myOpening.dimD0 != 0
						|| this.myOpening.dimD1 != 0 || this.myOpening.dimD2 != 0)) {

			a0 = UOMConvert
					.getBigDecimalConversion(myOpening.dimA0, myScale, 2);
			a1 = UOMConvert
					.getBigDecimalConversion(myOpening.dimA1, myScale, 2);
			a2 = UOMConvert
					.getBigDecimalConversion(myOpening.dimA2, myScale, 2);
			a3 = UOMConvert
					.getBigDecimalConversion(myOpening.dimA3, myScale, 2);

			b0 = UOMConvert
					.getBigDecimalConversion(myOpening.dimB0, myScale, 2);
			b1 = UOMConvert
					.getBigDecimalConversion(myOpening.dimB1, myScale, 2);
			b2 = UOMConvert
					.getBigDecimalConversion(myOpening.dimB2, myScale, 2);

			c0 = UOMConvert
					.getBigDecimalConversion(myOpening.dimC0, myScale, 2);
			c1 = UOMConvert
					.getBigDecimalConversion(myOpening.dimC1, myScale, 2);
			c2 = UOMConvert
					.getBigDecimalConversion(myOpening.dimC2, myScale, 2);

			d0 = UOMConvert
					.getBigDecimalConversion(myOpening.dimD0, myScale, 2);
			d1 = UOMConvert
					.getBigDecimalConversion(myOpening.dimD1, myScale, 2);
			d2 = UOMConvert
					.getBigDecimalConversion(myOpening.dimD2, myScale, 2);
		}
		

		if (myDrawCanvas.myParent.currentUOM == 1) {
			dimA0.setText(Double.parseDouble(twoDecimals.format(a0)) + "");
			dimA1.setText(Double.parseDouble(twoDecimals.format(a1)) + "");
			dimA2.setText(Double.parseDouble(twoDecimals.format(a2)) + "");
			dimA3.setText(Double.parseDouble(twoDecimals.format(a3)) + "");
			dimB0.setText(Double.parseDouble(twoDecimals.format(b0)) + "");
			dimB1.setText(Double.parseDouble(twoDecimals.format(b1)) + "");
			dimB2.setText(Double.parseDouble(twoDecimals.format(b2)) + "");
			dimC1.setText(Double.parseDouble(twoDecimals.format(c0)) + "");
			dimC2.setText(Double.parseDouble(twoDecimals.format(c1)) + "");
			dimC0.setText(Double.parseDouble(twoDecimals.format(c2)) + "");
			dimD0.setText(Double.parseDouble(twoDecimals.format(d0)) + "");
			dimD1.setText(Double.parseDouble(twoDecimals.format(d1)) + "");
			dimD2.setText(Double.parseDouble(twoDecimals.format(d2)) + "");
		}
		if (myDrawCanvas.myParent.currentUOM == 2) {
			dimA0.setText(Double.parseDouble(sixDecimals.format(a0 / 64)) + "");
			dimA1.setText(Double.parseDouble(sixDecimals.format(a1 / 64)) + "");
			dimA2.setText(Double.parseDouble(sixDecimals.format(a2 / 64)) + "");
			dimA3.setText(Double.parseDouble(sixDecimals.format(a3 / 64)) + "");
			dimB0.setText(Double.parseDouble(sixDecimals.format(b0 / 64)) + "");
			dimB1.setText(Double.parseDouble(sixDecimals.format(b1 / 64)) + "");
			dimB2.setText(Double.parseDouble(sixDecimals.format(b2 / 64)) + "");
			dimC1.setText(Double.parseDouble(sixDecimals.format(c0 / 64)) + "");
			dimC2.setText(Double.parseDouble(sixDecimals.format(c1 / 64)) + "");
			dimC0.setText(Double.parseDouble(sixDecimals.format(c2 / 64)) + "");
			dimD0.setText(Double.parseDouble(sixDecimals.format(d0 / 64)) + "");
			dimD1.setText(Double.parseDouble(sixDecimals.format(d1 / 64)) + "");
			dimD2.setText(Double.parseDouble(sixDecimals.format(d2 / 64)) + "");
		} else if (myDrawCanvas.myParent.myTopPanel.impFrac.isSelected()) {
			try {
				dimA0.setText(UOMConvert.imperialToFraction(a0 / 64 + ""));
				dimA1.setText(UOMConvert.imperialToFraction(a1 / 64 + ""));
				dimA2.setText(UOMConvert.imperialToFraction(a2 / 64 + ""));
				dimA3.setText(UOMConvert.imperialToFraction(a3 / 64 + ""));
				dimB0.setText(UOMConvert.imperialToFraction(b0 / 64 + ""));
				dimB1.setText(UOMConvert.imperialToFraction(b1 / 64 + ""));
				dimB2.setText(UOMConvert.imperialToFraction(b2 / 64 + ""));
				dimC1.setText(UOMConvert.imperialToFraction(c1 / 64 + ""));
				dimC2.setText(UOMConvert.imperialToFraction(c2 / 64 + ""));
				dimC0.setText(UOMConvert.imperialToFraction(c0 / 64 + ""));
				dimD0.setText(UOMConvert.imperialToFraction(d0 / 64 + ""));
				dimD1.setText(UOMConvert.imperialToFraction(d1 / 64 + ""));
				dimD2.setText(UOMConvert.imperialToFraction(d2 / 64 + ""));
			} catch (final Exception e) {
				// TODO Auto-generated catch
				// block
				e.printStackTrace();
			}
		} else if (myDrawCanvas.myParent.myTopPanel.percent.isSelected()) {
			dimA0.setText(leanTo.dimA0 / leanTo.w + "");
			dimA1.setText(leanTo.dimA1 / leanTo.w + "");
			dimA2.setText(leanTo.dimA2 / leanTo.w + "");
			dimA3.setText(leanTo.dimA3 / leanTo.w + "");
			dimB0.setText(leanTo.dimB0 / leanTo.h + "");
			dimB1.setText(leanTo.dimB1 / leanTo.h + "");
			dimB2.setText(leanTo.dimB2 / leanTo.h + "");
			dimC1.setText(leanTo.dimC1 / leanTo.w + "");
			dimC2.setText(leanTo.dimC2 / leanTo.w + "");
			dimC0.setText(leanTo.dimC0 / leanTo.w + "");
			dimD0.setText(leanTo.dimD0 / leanTo.h + "");
			dimD1.setText(leanTo.dimD1 / leanTo.h + "");
			dimD2.setText(leanTo.dimD2 / leanTo.h + "");
		}

		if (myDrawCanvas.selectedShapeID >= 90
				&& myDrawCanvas.selectedShapeID < 100) {
			myOpening.widthPix = UOMConvert.getBigDecimalConversion(leanTo.w,
					myScale, 2);
			myOpening.heightPix = UOMConvert.getBigDecimalConversion(leanTo.h,
					myScale, 2);
		}

		if (leanTo.lean > 0) {
			if (leanTo.dimA0 <= 0 && leanTo.dimA3 <= 0) {
				topPanel.add(dimA1, new XYConstraints(95, 3, 80, 19));
				dimA2.setEnabled(false);
				dimA0.setEnabled(false);
				dimA1.setEnabled(true);
				dimA0.setEnabled(false);
			} else if (leanTo.dimA0 > 0 && leanTo.dimA3 <= 0) {
				topPanel.add(dimA0, new XYConstraints(95, 3, 80, 19));
				topPanel.add(dimA1, new XYConstraints(205, 3, 80, 19));
				dimA1.setEnabled(false);
				dimA2.setEnabled(true);
				dimA0.setEnabled(true);
			} else if (leanTo.dimA0 <= 0 && leanTo.dimA3 > 0) {
				topPanel.add(dimA1, new XYConstraints(95, 3, 80, 19));
				topPanel.add(dimA3, new XYConstraints(205, 3, 80, 19));
				dimA3.setEnabled(false);
				dimA0.setEnabled(false);
				dimA1.setEnabled(true);
				dimA2.setEnabled(true);
			}
			topPanel.add(dimA2, new XYConstraints(320, 3, 80, 19));
		}
		if (leanTo.lean3 > 0) {
			if (leanTo.dimC0 <= 0) {
				botPanel.add(dimC1, new XYConstraints(320, 3, 80, 19));
				dimC2.setEnabled(false);
				dimC0.setEnabled(false);
				dimC1.setEnabled(true);
			} else if (leanTo.dimC0 >= 0) {
				botPanel.add(dimC0, new XYConstraints(320, 3, 80, 19));
				botPanel.add(dimC1, new XYConstraints(205, 3, 80, 19));
				dimC1.setEnabled(false);
				dimC2.setEnabled(true);
				dimC0.setEnabled(true);
			}
			botPanel.add(dimC2, new XYConstraints(95, 3, 80, 19));
		}
		if (leanTo.lean2 > 0) {
			if (leanTo.dimB0 <= 0) {
				rightPanel.add(dimB1, new XYConstraints(3, 40, 80, 19));
				dimB2.setEnabled(false);
				dimB0.setEnabled(false);
				if (myDrawCanvas.selectedShapeID != 704) {
					dimB1.setEnabled(true);
				} else {
					dimB1.setEnabled(false);
				}

			} else if (leanTo.dimB0 > 0) {
				rightPanel.add(dimB0, new XYConstraints(3, 40, 80, 19));
				rightPanel.add(dimB1, new XYConstraints(3, 140, 80, 19));
				dimB2.setEnabled(true);
				dimB0.setEnabled(true);
				dimB1.setEnabled(false);
			}
			rightPanel.add(dimB2, new XYConstraints(3, 240, 80, 19));
		}
		if (leanTo.lean4 > 0) {
			if (leanTo.dimD0 <= 0) {
				leftPanel.add(dimD1, new XYConstraints(3, 240, 80, 19));
				dimD2.setEnabled(true);
				dimD0.setEnabled(false);
				dimD1.setEnabled(false);
				if (myDrawCanvas.selectedShapeID == 704) {
					dimD2.setEnabled(false);
				}
			} else if (leanTo.dimD0 > 0) {
				leftPanel.add(dimD0, new XYConstraints(3, 240, 80, 19));
				leftPanel.add(dimD1, new XYConstraints(3, 140, 80, 19));
				dimD2.setEnabled(true);
				dimD0.setEnabled(true);
				dimD1.setEnabled(false);
			}
			leftPanel.add(dimD2, new XYConstraints(3, 40, 80, 19));
		}

	}

	void top_actionPerformedOLD(final ActionEvent e) {

		int from = 0;
		if (e.getSource() == dimA0) {
			from = 0;
		}
		if (e.getSource() == dimA1) {
			from = 1;
		}
		if (e.getSource() == dimA2) {
			from = 2;
		}
		if (e.getSource() == dimA3) {
			from = 3;
		}

		if (leanTo.lean > 0) {
			if (leanTo.dimA0 == 0 && leanTo.dimA3 == 0) {

				double a = 0;
				if (myDrawCanvas.myParent.myTopPanel.metric.isSelected()) {

					a = UOMConvert.getBigDecimalConversion(myOpening.widthPix,
							myScale, 2)
							- Double.parseDouble(dimA1.getText().trim());
					// HERE
					dimA2.setText(twoDecimals.format(a));

				} else if (myDrawCanvas.myParent.myTopPanel.impDec.isSelected()) {

					a = UOMConvert.getBigDecimalConversion(myOpening.widthPix,
							myScale, 2)

					- Double.parseDouble(dimA1.getText().trim()) * 64;

					dimA2.setText(sixDecimals.format(a / 64) + "");
				} else if (myDrawCanvas.myParent.myTopPanel.impFrac
						.isSelected()) {

					try {
						a = UOMConvert.getBigDecimalConversion(
								myOpening.widthPix, myScale, 2)
								- Double.parseDouble(UOMConvert
										.fractionToImperial(dimA1.getText()
												.trim() + "")) * 64;
						dimA2.setText(UOMConvert
								.imperialToFraction(a / 64 + ""));
					} catch (final NumberFormatException e1) {
						// TODO
						// Auto-generated catch block
						e1.printStackTrace();
					} catch (final Exception e1) {
						// TODO
						// Auto-generated catch block
						e1.printStackTrace();
					}

				}

			} else if (leanTo.dimA0 != 0 && leanTo.dimA3 == 0) {
				if (from == 2) {
					// final double a1 =
					// myOpening.width
					// - (Double
					// .parseDouble(dimA2
					// .getText()
					// .trim()) + Double
					// .parseDouble(dimA0
					// .getText()
					// .trim()))
					// / myScale.doubleValue();
					// dimA1
					// .setText(a1
					// * myScale.doubleValue()
					// + "");

					double a = 0;
					if (myDrawCanvas.myParent.myTopPanel.metric.isSelected()) {

						a = UOMConvert.getBigDecimalConversion(
								myOpening.widthPix, myScale, 2)
								- (Double.parseDouble(dimA2.getText().trim()) + Double
										.parseDouble(dimA0.getText().trim()));

						dimA1.setText(twoDecimals.format(a) + "");
					} else if (myDrawCanvas.myParent.myTopPanel.impDec
							.isSelected()) {
						a = UOMConvert.getBigDecimalConversion(
								myOpening.widthPix, myScale, 2)
								- (Double.parseDouble(dimA2.getText().trim()) + Double
										.parseDouble(dimA0.getText().trim()))
								* 64;
						dimA1.setText(sixDecimals.format(a / 64) + "");
					} else if (myDrawCanvas.myParent.myTopPanel.impFrac
							.isSelected()) {

						try {
							a = UOMConvert.getBigDecimalConversion(
									myOpening.widthPix, myScale, 2)
									- Double.parseDouble(

									UOMConvert.fractionToImperial(Double
											.parseDouble(UOMConvert
													.fractionToImperial(dimA2
															.getText().trim()))
											* 64 + ""))
									+ Double.parseDouble(UOMConvert.fractionToImperial(Double
											.parseDouble(UOMConvert
													.fractionToImperial(dimA0
															.getText().trim()))
											* 64 + ""));
							dimA1.setText(UOMConvert.imperialToFraction(a / 64
									+ ""));
						} catch (final NumberFormatException e1) {
							// TODO
							// Auto-generated catch
							// block
							e1.printStackTrace();
						} catch (final Exception e1) {
							// TODO
							// Auto-generated catch
							// block
							e1.printStackTrace();
						}

					}

				}
				if (from == 0) {

					double a = 0;
					if (myDrawCanvas.myParent.myTopPanel.metric.isSelected()) {

						a = UOMConvert.getBigDecimalConversion(
								myOpening.widthPix, myScale, 2)
								- (Double.parseDouble(dimA2.getText().trim()) + Double
										.parseDouble(dimA0.getText().trim()));

						dimA1.setText(twoDecimals.format(a) + "");
					} else if (myDrawCanvas.myParent.myTopPanel.impDec
							.isSelected()) {
						a = UOMConvert.getBigDecimalConversion(
								myOpening.widthPix, myScale, 2)
								- (Double.parseDouble(dimA2.getText().trim()) + Double
										.parseDouble(dimA0.getText().trim()))
								* 64;
						dimA1.setText(sixDecimals.format(a / 64) + "");
					} else if (myDrawCanvas.myParent.myTopPanel.impFrac
							.isSelected()) {

						try {
							a = UOMConvert.getBigDecimalConversion(
									myOpening.widthPix, myScale, 2)
									- Double.parseDouble(

									UOMConvert.fractionToImperial(Double
											.parseDouble(UOMConvert
													.fractionToImperial(dimA2
															.getText().trim()))
											* 64 + ""))
									+ Double.parseDouble(UOMConvert.fractionToImperial(Double
											.parseDouble(UOMConvert
													.fractionToImperial(dimA0
															.getText().trim()))
											* 64 + ""));
							dimA1.setText(UOMConvert.imperialToFraction(a / 64
									+ ""));
						} catch (final NumberFormatException e1) {
							// TODO
							// Auto-generated catch
							// block
							e1.printStackTrace();
						} catch (final Exception e1) {
							// TODO
							// Auto-generated catch
							// block
							e1.printStackTrace();
						}

					}

				}
			} else if (leanTo.dimA0 == 0 && leanTo.dimA3 != 0) {
				if (from == 2 || from == 3) {
					// final double a1 =
					// myOpening.width
					// - (Double
					// .parseDouble(dimA2
					// .getText()
					// .trim()) + Double
					// .parseDouble(dimA3
					// .getText()
					// .trim()))
					// / myScale.doubleValue();
					// dimA1
					// .setText(a1
					// * myScale.doubleValue()
					// + "");

					double a = 0;
					if (myDrawCanvas.myParent.myTopPanel.metric.isSelected()) {

						a = UOMConvert.getBigDecimalConversion(
								myOpening.widthPix, myScale, 2)
								- (Double.parseDouble(dimA2.getText().trim()) + Double
										.parseDouble(dimA3.getText().trim()));

						dimA1.setText(twoDecimals.format(a) + "");
					} else if (myDrawCanvas.myParent.myTopPanel.impDec
							.isSelected()) {
						a = UOMConvert.getBigDecimalConversion(
								myOpening.widthPix, myScale, 2)
								- (Double.parseDouble(dimA2.getText().trim()) + Double
										.parseDouble(dimA3.getText().trim()))
								* 64;
						dimA1.setText(twoDecimals.format(a / 64) + "");
					} else if (myDrawCanvas.myParent.myTopPanel.impFrac
							.isSelected()) {

						try {
							a = UOMConvert.getBigDecimalConversion(
									myOpening.widthPix, myScale, 2)
									- Double.parseDouble(

									UOMConvert.fractionToImperial(Double
											.parseDouble(UOMConvert
													.fractionToImperial(dimA2
															.getText().trim()))
											* 64 + ""))
									+ Double.parseDouble(UOMConvert.fractionToImperial(Double
											.parseDouble(UOMConvert
													.fractionToImperial(dimA3
															.getText().trim()))
											* 64 + ""));
							dimA1.setText(UOMConvert.imperialToFraction(a / 64
									+ ""));
						} catch (final NumberFormatException e1) {
							// TODO
							// Auto-generated catch
							// block
							e1.printStackTrace();
						} catch (final Exception e1) {
							// TODO
							// Auto-generated catch
							// block
							e1.printStackTrace();
						}

					}
				}
				// if (from == 3)
				// {
				// final double a1 =
				// myOpening.width
				// - (Double
				// .parseDouble(dimA2
				// .getText()
				// .trim()) + Double
				// .parseDouble(dimA3
				// .getText()
				// .trim()))
				// / myScale.doubleValue();
				// dimA1
				// .setText(a1
				// * myScale.doubleValue()
				// + "");
				// }
			}

		}
		// doShapeSize();
	}

	void top_actionPerformed(final ActionEvent e) {

		double myDim = 0;
		double myDim2 = 0;
		double myW = 0;
		Object[] values = new Object[2];
		Object[] values2 = new Object[2];

		if (shapeID != 91 || shapeID != 92 || shapeID != 93 || shapeID != 160
				|| shapeID != 160) {
			try {
				if (e.getSource() == dimA0) {
					values = myDrawCanvas.myParent.readConvertText(dimA0);
					values2 = myDrawCanvas.myParent.readConvertText(dimA2);
				}
				if (e.getSource() == dimA1) {
					values = myDrawCanvas.myParent.readConvertText(dimA1);
					if (dimA3.isVisible()) {
						values2 = myDrawCanvas.myParent.readConvertText(dimA2);
					} else if (leanTo.lean == 3) {
						values = myDrawCanvas.myParent.readConvertText(dimA1);
						values2 = myDrawCanvas.myParent.readConvertText(dimA2);
					} else {
						values = myDrawCanvas.myParent.readConvertText(dimA2);
					}
				}
				if (e.getSource() == dimA2) {
					values2 = myDrawCanvas.myParent.readConvertText(dimA2);

					if (dimA3.isVisible()) {
						values = myDrawCanvas.myParent.readConvertText(dimA1);
					} else if (leanTo.lean == 3) {
						values = myDrawCanvas.myParent.readConvertText(dimA0);
						values2 = myDrawCanvas.myParent.readConvertText(dimA2);
					} else {
						values = myDrawCanvas.myParent.readConvertText(dimA2);
					}

				}
			} catch (final Exception e2) {
				// TODO Auto-generated catch
				// block
				e2.printStackTrace();
			}

			if (myDrawCanvas.myParent.currentUOM == 1) {
				myDim = (Double) values[0];
				if (leanTo.lean == 3) {
					myDim2 = (Double) values2[0];
				}
			} else {
				myDim = (Double) values[0] / 64;
				if (leanTo.lean == 3) {
					myDim2 = (Double) values2[0] / 64;
				}
			}
			myW = UOMConvert.getBigDecimalConversion(myOpening.widthPix,
					myScale, 2);

			if (leanTo.lean == 1) {

				dimA2.setText(myW - myDim + "");

			} else if (leanTo.lean == 2) {

				dimA2.setText(myW - myDim + "");

			} else if (leanTo.lean == 3) {

				dimA3.setText(myW - myDim - myDim2 + "");

			}
		}
		// // 165 160 91 92 93

		else {

			try {

				values = myDrawCanvas.myParent.readConvertText(dimA1);
				values2 = myDrawCanvas.myParent.readConvertText(dimA2);

			} catch (final Exception e2) {
				// TODO Auto-generated catch
				// block
				e2.printStackTrace();
			}

			if (myDrawCanvas.myParent.currentUOM == 1) {
				myDim = (Double) values[0];

				myDim2 = (Double) values2[0];

			} else {
				myDim = (Double) values[0] / 64;

				myDim2 = (Double) values2[0] / 64;

			}

			myW = UOMConvert.getBigDecimalConversion(myOpening.widthPix,
					myScale, 2);

			dimA3.setText(myW - myDim - myDim2 + "");

		}
	}

	void bot_actionPerformed(final ActionEvent e) {

		double myDim = 0;
		double myDim2 = 0;
		double myW = 0;
		Object[] values = new Object[2];
		Object[] values2 = new Object[2];

		try {
			if (e.getSource() == dimC0) {
				values = myDrawCanvas.myParent.readConvertText(dimC0);
				values2 = myDrawCanvas.myParent.readConvertText(dimC2);
			}
			if (e.getSource() == dimC1) {
				values = myDrawCanvas.myParent.readConvertText(dimC1);

			}
			if (e.getSource() == dimC2) {
				if (leanTo.lean3 == 3) {
					values = myDrawCanvas.myParent.readConvertText(dimC0);
					values2 = myDrawCanvas.myParent.readConvertText(dimC2);
				} else {
					values = myDrawCanvas.myParent.readConvertText(dimC2);
				}

			}
		} catch (final Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		if (myDrawCanvas.myParent.currentUOM == 1) {
			myDim = (Double) values[0];
			if (leanTo.lean3 == 3) {
				myDim2 = (Double) values2[0];
			}
		} else {
			myDim = (Double) values[0] / 64;
			if (leanTo.lean3 == 3) {
				myDim2 = (Double) values2[0] / 64;
			}
		}

		myW = UOMConvert
				.getBigDecimalConversion(myOpening.widthPix, myScale, 2);

		if (leanTo.lean3 == 1) {

			dimC2.setText(myW - myDim + "");

		} else if (leanTo.lean3 == 2) {

			dimC2.setText(myW - myDim + "");

		} else if (leanTo.lean3 == 3) {

			dimC1.setText(myW - myDim - myDim2 + "");

		}
	}

	void left_actionPerformed(final ActionEvent e) {

		double myDim = 0;
		double myDim2 = 0;
		double myH = 0;
		Object[] values = new Object[2];
		Object[] values2 = new Object[2];

		try {
			if (e.getSource() == dimD0) {
				values2 = myDrawCanvas.myParent.readConvertText(dimD0);
				values = myDrawCanvas.myParent.readConvertText(dimD2);
			}
			if (e.getSource() == dimD1) {
				values = myDrawCanvas.myParent.readConvertText(dimD1);

			}
			if (e.getSource() == dimD2) {
				if (leanTo.lean4 == 3) {
					values2 = myDrawCanvas.myParent.readConvertText(dimD0);
					values = myDrawCanvas.myParent.readConvertText(dimD2);
				} else {
					values = myDrawCanvas.myParent.readConvertText(dimD2);
				}

			}
		} catch (final Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		if (myDrawCanvas.myParent.currentUOM == 1) {
			myDim = (Double) values[0];
			if (leanTo.lean4 == 3) {
				myDim2 = (Double) values2[0];
			}
		} else {
			myDim = (Double) values[0] / 64;
			if (leanTo.lean4 == 3) {
				myDim2 = (Double) values2[0] / 64;
			}
		}

		myH = UOMConvert.getBigDecimalConversion(myOpening.heightPix, myScale,
				2);

		if (leanTo.lean4 == 1) {

			dimD1.setText(myH - myDim + "");

		} else if (leanTo.lean4 == 2) {

			dimD1.setText(myH - myDim + "");

		} else if (leanTo.lean4 == 3) {

			dimD1.setText(myH - myDim - myDim2 + "");

		}
	}

	void right_actionPerformed(final ActionEvent e) {

		double myDim = 0;
		double myDim2 = 0;
		double myH = 0;
		Object[] values = new Object[2];
		Object[] values2 = new Object[2];

		try {
			if (e.getSource() == dimB0) {
				values = myDrawCanvas.myParent.readConvertText(dimB0);
				values2 = myDrawCanvas.myParent.readConvertText(dimB2);
			}
			if (e.getSource() == dimB1) {
				values = myDrawCanvas.myParent.readConvertText(dimB1);

			}
			if (e.getSource() == dimB2) {
				if (leanTo.lean2 == 3) {
					values = myDrawCanvas.myParent.readConvertText(dimB0);
					values2 = myDrawCanvas.myParent.readConvertText(dimB2);
				} else {
					values = myDrawCanvas.myParent.readConvertText(dimB2);
				}

			}
		} catch (final Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		if (myDrawCanvas.myParent.currentUOM == 1) {
			myDim = (Double) values[0];
			if (leanTo.lean2 == 3) {
				myDim2 = (Double) values2[0];
			}
		} else {
			myDim = (Double) values[0] / 64;
			if (leanTo.lean2 == 3) {
				myDim2 = (Double) values2[0] / 64;
			}
		}

		myH = UOMConvert
				.getBigDecimalConversion(myOpening.widthPix, myScale, 2);

		if (leanTo.lean2 == 1) {

			dimB2.setText(myH - myDim + "");

		} else if (leanTo.lean2 == 2) {

			dimB2.setText(myH - myDim + "");

		} else if (leanTo.lean2 == 3) {

			dimB1.setText(myH - myDim - myDim2 + "");

		}

	}

	void jButtonClose_actionPerformed(final ActionEvent e) {

		ShapeDimDialog.dispose();
	}

	void jButtonSet_actionPerformed(final ActionEvent e) {

		this.doShapeSize();
		ShapeDimDialog.dispose();
		// myDrawCanvas.myParent.dimAction();
		this.myDrawCanvas.redrawTextForColRow(true);
	}

	public void doShapeSize() {
		boolean proceed = true;

		if (myDrawCanvas.myParent.facetUsed.bOpeningObject.mullionsH.size() > 0) {
			for (Object mh : myDrawCanvas.myParent.facetUsed.bOpeningObject.mullionsH
					.toArray()) {

				Profiles h = (Profiles) mh;

				if (myDrawCanvas.myParent.currentUOM == 1) {
					if (h.y2 < myDrawCanvas.myParent.facetUsed.bkgrdStartY
							+ (leanTo.dimB1 * (myDrawCanvas.myParent.metricscale
									.doubleValue()))
							|| h.y2 < myDrawCanvas.myParent.facetUsed.bkgrdStartY
									+ (leanTo.dimB0 * (myDrawCanvas.myParent.metricscale
											.doubleValue()))
							|| h.y2 < myDrawCanvas.myParent.facetUsed.bkgrdStartY
									+ (leanTo.dimD2 * (myDrawCanvas.myParent.metricscale
											.doubleValue()))) {
						proceed = false;
						break;
					}
				} else {
					if (h.y2 < myDrawCanvas.myParent.facetUsed.bkgrdStartY
							+ (leanTo.dimB1 * (myDrawCanvas.myParent.imperialscale
									.doubleValue()))
							|| h.y2 < myDrawCanvas.myParent.facetUsed.bkgrdStartY
									+ (leanTo.dimB0 * (myDrawCanvas.myParent.imperialscale
											.doubleValue()))
							|| h.y2 < myDrawCanvas.myParent.facetUsed.bkgrdStartY
									+ (leanTo.dimD2 * (myDrawCanvas.myParent.imperialscale
											.doubleValue())) ) {
						proceed = false;
						break;
					}
				}

			}

		}

		if (proceed) {
			try {

				if (selectedShapeLevel == 1
						&& leanTo.resetWorH != 0
						&& (myDrawCanvas.myParent.facetUsed.xCols > 1 || myDrawCanvas.myParent.facetUsed.yRows > 1)) {

					JOptionPane
							.showMessageDialog(
									null,
									"Overall Dimensions are Incorrect for the selected Shape!\n"
											+ "Please correct dimensions or remove all Couplers \n"
											+ "prior to implementing Shape Change",
									"Invalid Operation - Error!",
									JOptionPane.ERROR_MESSAGE);

				}

				NumSidesShapes numOfSides = new NumSidesShapes(shapeID);
				if (selectedShapeLevel == 1
						&& (numOfSides.noSides == 2 || numOfSides.noSides == 3)
						&& (myDrawCanvas.myParent.facetUsed.xCols > 1 || myDrawCanvas.myParent.facetUsed.yRows > 1)) {

					JOptionPane.showMessageDialog(null,
							"Try Changing an individual Frame instead!\n",
							"Invalid Operation - Error!",
							JOptionPane.ERROR_MESSAGE);

				} else if (selectedShapeLevel == 1 && shapeID != 10)
				// && (this.myDrawCanvas.myParent.jobItem.design.xCols > 1
				// || this.myDrawCanvas.myParent.jobItem.design.yRows > 1))
				{
					// myParent.myParent.resetModTexts=true;
					this.prepareFacetShapeChange();
				} else if (selectedShapeLevel == 1 && shapeID == 10) {
					JOptionPane.showMessageDialog(null,
							"Cannot Remove Single Frame!",
							"Invalid Operation - Error!",
							JOptionPane.ERROR_MESSAGE);
				} else if (selectedShapeLevel > 1)
				{
					// myParent.myParent.resetModTexts=true;
					this.prepareFrameShapeChange();
					myDrawCanvas.myParent.facetUsed.reDraw(true, true, null,
							false, true, true);
				}

				myDrawCanvas.myParent.jobItem.resetGraphics();

				if (myDrawCanvas.myParent.hasGrids) {

					myDrawCanvas.myParent.setgrids();
				}

				if (leanTo.resetWorH != 0) {
					myDrawCanvas.myParent.resetModTextsV = true;
					myDrawCanvas.myParent.resetModTextsH = true;
					myDrawCanvas.myParent.dimAction();
				}

			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(null,
					"Horizontal couplers found within Shoulder dimension!",
					"Invalid Horizontal Coupler Position - Error!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void prepareFrameShapeChange() {

		if (myDrawCanvas.myParent.facetUsed.xCols == 1
				&& myDrawCanvas.myParent.facetUsed.yRows == 1) {
			if (leanTo.myShape > 10 && leanTo.myShape < 100
					|| leanTo.myShape >= 800 || leanTo.resetWorH != 0
					|| leanTo.myShape >= 450 && leanTo.myShape <= 470) {
				this.resetFacetOpeningShape();
			}
		}

		if (myDrawCanvas.myParent.facetUsed.shapeID == 1) {
			this.setChangeDims();
			this.doFrameShapeChange(shapeID);
		} else {
			selectedShapeLevel = 2;
			this.prepareFacetShapeChange();
		}

	}

	public void prepareFacetShapeChange() {

		this.resetFacetOpeningShape();

		if (leanTo.myShape < 10 || leanTo.myShape > 99 && leanTo.myShape < 800) {
			this.setChangeDims();
			doFacetShapeChange(shapeID);
			// myDrawCanvas.myParent.facetUsed.reDraw(true, false, null,
			// false, false);
		}

	}

	public void setChangeDims() {

		myOpening.shapeID = leanTo.myShape;
		shapeID = leanTo.myShape;
		if (selectedShapeLevel > 1 && leanTo.resetWorH > 0) {

			myDrawCanvas.myParent.selectedDim = 2;
			final int xxx = (int) (myOpening.startingX + (myOpening.bX2 - myOpening.startingX) / 2);
			final int yyy = (int) (myOpening.highestY + (myOpening.bY4 - myOpening.highestY) / 2);

			myDrawCanvas.getSelectedColTop(xxx, yyy);
			myDrawCanvas.getSelectedRowLeft(xxx, yyy);

			if (leanTo.resetWorH == 3 || leanTo.resetWorH == 1) {
				myDrawCanvas.modColWidths(leanTo.w, true);

			}
			if (leanTo.resetWorH == 3 || leanTo.resetWorH == 2) {
				myDrawCanvas.modRowHeights(leanTo.h);

			}
		}

		if (leanTo.doShapeDialog) {
			if (myDrawCanvas.myParent.myTopPanel.metric.isSelected()) {
				myOpening.dimA0 = UOMConvert.getBigDecimalConversion(
						Double.parseDouble(dimA0.getText()), myScale, 1);
				myOpening.dimA1 = UOMConvert.getBigDecimalConversion(
						Double.parseDouble(dimA1.getText()), myScale, 1);
				myOpening.dimA2 = UOMConvert.getBigDecimalConversion(
						Double.parseDouble(dimA2.getText()), myScale, 1);
				myOpening.dimA3 = UOMConvert.getBigDecimalConversion(
						Double.parseDouble(dimA3.getText()), myScale, 1);
				myOpening.dimB0 = UOMConvert.getBigDecimalConversion(
						Double.parseDouble(dimB0.getText()), myScale, 1);
				myOpening.dimB1 = UOMConvert.getBigDecimalConversion(
						Double.parseDouble(dimB1.getText()), myScale, 1);
				myOpening.dimB2 = UOMConvert.getBigDecimalConversion(
						Double.parseDouble(dimB2.getText()), myScale, 1);
				myOpening.dimC0 = UOMConvert.getBigDecimalConversion(
						Double.parseDouble(dimC0.getText()), myScale, 1);
				myOpening.dimC1 = UOMConvert.getBigDecimalConversion(
						Double.parseDouble(dimC1.getText()), myScale, 1);
				myOpening.dimC2 = UOMConvert.getBigDecimalConversion(
						Double.parseDouble(dimC2.getText()), myScale, 1);
				myOpening.dimD0 = UOMConvert.getBigDecimalConversion(
						Double.parseDouble(dimD0.getText()), myScale, 1);
				myOpening.dimD1 = UOMConvert.getBigDecimalConversion(
						Double.parseDouble(dimD1.getText()), myScale, 1);
				myOpening.dimD2 = UOMConvert.getBigDecimalConversion(
						Double.parseDouble(dimD2.getText()), myScale, 1);

				myOpening.dimA0M = (int) (Double.parseDouble(dimA0.getText()) * 100);
				myOpening.dimA1M = (int) (Double.parseDouble(dimA1.getText()) * 100);
				myOpening.dimA2M = (int) (Double.parseDouble(dimA2.getText()) * 100);
				myOpening.dimA3M = (int) (Double.parseDouble(dimA3.getText()) * 100);
				myOpening.dimB0M = (int) (Double.parseDouble(dimB0.getText()) * 100);
				myOpening.dimB1M = (int) (Double.parseDouble(dimB1.getText()) * 100);
				myOpening.dimB2M = (int) (Double.parseDouble(dimB2.getText()) * 100);
				myOpening.dimC0M = (int) (Double.parseDouble(dimC0.getText()) * 100);
				myOpening.dimC1M = (int) (Double.parseDouble(dimC1.getText()) * 100);
				myOpening.dimC2M = (int) (Double.parseDouble(dimC2.getText()) * 100);
				myOpening.dimD0M = (int) (Double.parseDouble(dimD0.getText()) * 100);
				myOpening.dimD1M = (int) (Double.parseDouble(dimD1.getText()) * 100);
				myOpening.dimD2M = (int) (Double.parseDouble(dimD2.getText()) * 100);

				myOpening.dimA0I = (int) (Double.parseDouble(dimA0.getText()) / 25.4 * 64);
				myOpening.dimA1I = (int) (Double.parseDouble(dimA1.getText()) / 25.4 * 64);
				myOpening.dimA2I = (int) (Double.parseDouble(dimA2.getText()) / 25.4 * 64);
				myOpening.dimA3I = (int) (Double.parseDouble(dimA3.getText()) / 25.4 * 64);
				myOpening.dimB0I = (int) (Double.parseDouble(dimB0.getText()) / 25.4 * 64);
				myOpening.dimB1I = (int) (Double.parseDouble(dimB1.getText()) / 25.4 * 64);
				myOpening.dimB2I = (int) (Double.parseDouble(dimB2.getText()) / 25.4 * 64);
				myOpening.dimC0I = (int) (Double.parseDouble(dimC0.getText()) / 25.4 * 64);
				myOpening.dimC1I = (int) (Double.parseDouble(dimC1.getText()) / 25.4 * 64);
				myOpening.dimC2I = (int) (Double.parseDouble(dimC2.getText()) / 25.4 * 64);
				myOpening.dimD0I = (int) (Double.parseDouble(dimD0.getText()) / 25.4 * 64);
				myOpening.dimD1I = (int) (Double.parseDouble(dimD1.getText()) / 25.4 * 64);
				myOpening.dimD2I = (int) (Double.parseDouble(dimD2.getText()) / 25.4 * 64);

			} else if (myDrawCanvas.myParent.myTopPanel.impDec.isSelected()) {
				myOpening.dimA0 = UOMConvert.getBigDecimalConversion(
						Double.parseDouble(dimA0.getText()) * 64, myScale, 1);
				myOpening.dimA1 = UOMConvert.getBigDecimalConversion(
						Double.parseDouble(dimA1.getText()) * 64, myScale, 1);
				myOpening.dimA2 = UOMConvert.getBigDecimalConversion(
						Double.parseDouble(dimA2.getText()) * 64, myScale, 1);
				myOpening.dimA3 = UOMConvert.getBigDecimalConversion(
						Double.parseDouble(dimA3.getText()) * 64, myScale, 1);
				myOpening.dimB0 = UOMConvert.getBigDecimalConversion(
						Double.parseDouble(dimB0.getText()) * 64, myScale, 1);
				myOpening.dimB1 = UOMConvert.getBigDecimalConversion(
						Double.parseDouble(dimB1.getText()) * 64, myScale, 1);
				myOpening.dimB2 = UOMConvert.getBigDecimalConversion(
						Double.parseDouble(dimB2.getText()) * 64, myScale, 1);
				myOpening.dimC0 = UOMConvert.getBigDecimalConversion(
						Double.parseDouble(dimC0.getText()) * 64, myScale, 1);
				myOpening.dimC1 = UOMConvert.getBigDecimalConversion(
						Double.parseDouble(dimC1.getText()) * 64, myScale, 1);
				myOpening.dimC2 = UOMConvert.getBigDecimalConversion(
						Double.parseDouble(dimC2.getText()) * 64, myScale, 1);
				myOpening.dimD0 = UOMConvert.getBigDecimalConversion(
						Double.parseDouble(dimD0.getText()) * 64, myScale, 1);
				myOpening.dimD1 = UOMConvert.getBigDecimalConversion(
						Double.parseDouble(dimD1.getText()) * 64, myScale, 1);
				myOpening.dimD2 = UOMConvert.getBigDecimalConversion(
						Double.parseDouble(dimD2.getText()) * 64, myScale, 1);

				myOpening.dimA0M = (int) (Double.parseDouble(dimA0.getText()) * 25.4 * 100);
				myOpening.dimA1M = (int) (Double.parseDouble(dimA1.getText()) * 25.4 * 100);
				myOpening.dimA2M = (int) (Double.parseDouble(dimA2.getText()) * 25.4 * 100);
				myOpening.dimA3M = (int) (Double.parseDouble(dimA3.getText()) * 25.4 * 100);
				myOpening.dimB0M = (int) (Double.parseDouble(dimB0.getText()) * 25.4 * 100);
				myOpening.dimB1M = (int) (Double.parseDouble(dimB1.getText()) * 25.4 * 100);
				myOpening.dimB2M = (int) (Double.parseDouble(dimB2.getText()) * 25.4 * 100);
				myOpening.dimC0M = (int) (Double.parseDouble(dimC0.getText()) * 25.4 * 100);
				myOpening.dimC1M = (int) (Double.parseDouble(dimC1.getText()) * 25.4 * 100);
				myOpening.dimC2M = (int) (Double.parseDouble(dimC2.getText()) * 25.4 * 100);
				myOpening.dimD0M = (int) (Double.parseDouble(dimD0.getText()) * 25.4 * 100);
				myOpening.dimD1M = (int) (Double.parseDouble(dimD1.getText()) * 25.4 * 100);
				myOpening.dimD2M = (int) (Double.parseDouble(dimD2.getText()) * 25.4 * 100);

				myOpening.dimA0I = (int) (Double.parseDouble(dimA0.getText()) * 64);
				myOpening.dimA1I = (int) (Double.parseDouble(dimA1.getText()) * 64);
				myOpening.dimA2I = (int) (Double.parseDouble(dimA2.getText()) * 64);
				myOpening.dimA3I = (int) (Double.parseDouble(dimA3.getText()) * 64);
				myOpening.dimB0I = (int) (Double.parseDouble(dimB0.getText()) * 64);
				myOpening.dimB1I = (int) (Double.parseDouble(dimB1.getText()) * 64);
				myOpening.dimB2I = (int) (Double.parseDouble(dimB2.getText()) * 64);
				myOpening.dimC0I = (int) (Double.parseDouble(dimC0.getText()) * 64);
				myOpening.dimC1I = (int) (Double.parseDouble(dimC1.getText()) * 64);
				myOpening.dimC2I = (int) (Double.parseDouble(dimC2.getText()) * 64);
				myOpening.dimD0I = (int) (Double.parseDouble(dimD0.getText()) * 64);
				myOpening.dimD1I = (int) (Double.parseDouble(dimD1.getText()) * 64);
				myOpening.dimD2I = (int) (Double.parseDouble(dimD2.getText()) * 64);

			} else if (myDrawCanvas.myParent.myTopPanel.impFrac.isSelected()) {
				try {
					myOpening.dimA0 = Double.parseDouble(UOMConvert
							.fractionToImperial(dimA0.getText()))
							* 64
							* myScale.doubleValue();
					myOpening.dimA1 = Double.parseDouble(UOMConvert
							.fractionToImperial(dimA1.getText()))
							* 64
							* myScale.doubleValue();
					myOpening.dimA2 = Double.parseDouble(UOMConvert
							.fractionToImperial(dimA2.getText()))
							* 64
							* myScale.doubleValue();
					myOpening.dimA3 = Double.parseDouble(UOMConvert
							.fractionToImperial(dimA3.getText()))
							* 64
							* myScale.doubleValue();
					myOpening.dimB0 = Double.parseDouble(UOMConvert
							.fractionToImperial(dimB0.getText()))
							* 64
							* myScale.doubleValue();
					myOpening.dimB1 = Double.parseDouble(UOMConvert
							.fractionToImperial(dimB1.getText()))
							* 64
							* myScale.doubleValue();
					myOpening.dimB2 = Double.parseDouble(UOMConvert
							.fractionToImperial(dimB2.getText()))
							* 64
							* myScale.doubleValue();
					myOpening.dimC0 = Double.parseDouble(UOMConvert
							.fractionToImperial(dimC0.getText()))
							* 64
							* myScale.doubleValue();
					myOpening.dimC1 = Double.parseDouble(UOMConvert
							.fractionToImperial(dimC1.getText()))
							* 64
							* myScale.doubleValue();
					myOpening.dimC2 = Double.parseDouble(UOMConvert
							.fractionToImperial(dimC2.getText()))
							* 64
							* myScale.doubleValue();
					myOpening.dimD0 = Double.parseDouble(UOMConvert
							.fractionToImperial(dimD0.getText()))
							* 64
							* myScale.doubleValue();
					myOpening.dimD1 = Double.parseDouble(UOMConvert
							.fractionToImperial(dimD1.getText()))
							* 64
							* myScale.doubleValue();
					myOpening.dimD2 = Double.parseDouble(UOMConvert
							.fractionToImperial(dimD2.getText()))
							* 64
							* myScale.doubleValue();
					myOpening.dimA0I = (int) (Double.parseDouble(UOMConvert
							.fractionToImperial(dimA0.getText())) * 64);
					myOpening.dimA1I = (int) (Double.parseDouble(UOMConvert
							.fractionToImperial(dimA1.getText())) * 64);
					myOpening.dimA2I = (int) (Double.parseDouble(UOMConvert
							.fractionToImperial(dimA2.getText())) * 64);
					myOpening.dimA3I = (int) (Double.parseDouble(UOMConvert
							.fractionToImperial(dimA3.getText())) * 64);
					myOpening.dimB0I = (int) (Double.parseDouble(UOMConvert
							.fractionToImperial(dimB0.getText())) * 64);
					myOpening.dimB1I = (int) (Double.parseDouble(UOMConvert
							.fractionToImperial(dimB1.getText())) * 64);
					myOpening.dimB2I = (int) (Double.parseDouble(UOMConvert
							.fractionToImperial(dimB2.getText())) * 64);
					myOpening.dimC0I = (int) (Double.parseDouble(UOMConvert
							.fractionToImperial(dimC0.getText())) * 64);
					myOpening.dimC1I = (int) (Double.parseDouble(UOMConvert
							.fractionToImperial(dimC1.getText())) * 64);
					myOpening.dimC2I = (int) (Double.parseDouble(UOMConvert
							.fractionToImperial(dimC2.getText())) * 64);
					myOpening.dimD0I = (int) (Double.parseDouble(UOMConvert
							.fractionToImperial(dimD0.getText())) * 64);
					myOpening.dimD1I = (int) (Double.parseDouble(UOMConvert
							.fractionToImperial(dimD1.getText())) * 64);
					myOpening.dimD2I = (int) (Double.parseDouble(UOMConvert
							.fractionToImperial(dimD2.getText())) * 64);

					myOpening.dimA0M = (int) (Double.parseDouble(UOMConvert
							.fractionToImperial(dimA0.getText())) * 25.4 * 100);
					myOpening.dimA1M = (int) (Double.parseDouble(UOMConvert
							.fractionToImperial(dimA1.getText())) * 25.4 * 100);
					myOpening.dimA2M = (int) (Double.parseDouble(UOMConvert
							.fractionToImperial(dimA2.getText())) * 25.4 * 100);
					myOpening.dimA3M = (int) (Double.parseDouble(UOMConvert
							.fractionToImperial(dimA3.getText())) * 25.4 * 100);
					myOpening.dimB0M = (int) (Double.parseDouble(UOMConvert
							.fractionToImperial(dimB0.getText())) * 25.4 * 100);
					myOpening.dimB1M = (int) (Double.parseDouble(UOMConvert
							.fractionToImperial(dimB1.getText())) * 25.4 * 100);
					myOpening.dimB2M = (int) (Double.parseDouble(UOMConvert
							.fractionToImperial(dimB2.getText())) * 25.4 * 100);
					myOpening.dimC0M = (int) (Double.parseDouble(UOMConvert
							.fractionToImperial(dimC0.getText())) * 25.4 * 100);
					myOpening.dimC1M = (int) (Double.parseDouble(UOMConvert
							.fractionToImperial(dimC1.getText())) * 25.4 * 100);
					myOpening.dimC2M = (int) (Double.parseDouble(UOMConvert
							.fractionToImperial(dimC2.getText())) * 25.4 * 100);
					myOpening.dimD0M = (int) (Double.parseDouble(UOMConvert
							.fractionToImperial(dimD0.getText())) * 25.4 * 100);
					myOpening.dimD1M = (int) (Double.parseDouble(UOMConvert
							.fractionToImperial(dimD1.getText())) * 25.4 * 100);
					myOpening.dimD2M = (int) (Double.parseDouble(UOMConvert
							.fractionToImperial(dimD2.getText())) * 25.4 * 100);

				} catch (final NumberFormatException e) {
					// TODO
					// Auto-generated catch block
					e.printStackTrace();
				} catch (final Exception e) {
					// TODO
					// Auto-generated catch block
					e.printStackTrace();
				}
			}

		} else {

			myOpening.widthPix = UOMConvert.getBigDecimalConversion(leanTo.w,
					myScale, 1);
			myOpening.heightPix = UOMConvert.getBigDecimalConversion(leanTo.h,
					myScale, 1);

			myOpening.dimA1 = UOMConvert.getBigDecimalConversion(leanTo.dimA1,
					myScale, 1);
			myOpening.dimA2 = UOMConvert.getBigDecimalConversion(leanTo.dimA2,
					myScale, 1);
			myOpening.dimA3 = UOMConvert.getBigDecimalConversion(leanTo.dimA3,
					myScale, 1);
			myOpening.dimA0 = UOMConvert.getBigDecimalConversion(leanTo.dimA0,
					myScale, 1);
			myOpening.dimB1 = UOMConvert.getBigDecimalConversion(leanTo.dimB1,
					myScale, 1);
			myOpening.dimB2 = UOMConvert.getBigDecimalConversion(leanTo.dimB2,
					myScale, 1);
			myOpening.dimB0 = UOMConvert.getBigDecimalConversion(leanTo.dimB0,
					myScale, 1);
			myOpening.dimC1 = UOMConvert.getBigDecimalConversion(leanTo.dimC1,
					myScale, 1);
			myOpening.dimC2 = UOMConvert.getBigDecimalConversion(leanTo.dimC2,
					myScale, 1);
			myOpening.dimC0 = UOMConvert.getBigDecimalConversion(leanTo.dimC0,
					myScale, 1);
			myOpening.dimD1 = UOMConvert.getBigDecimalConversion(leanTo.dimD1,
					myScale, 1);
			myOpening.dimD2 = UOMConvert.getBigDecimalConversion(leanTo.dimD2,
					myScale, 1);
			myOpening.dimD0 = UOMConvert.getBigDecimalConversion(leanTo.dimD0,
					myScale, 1);

			if (myDrawCanvas.myParent.myTopPanel.metric.isSelected()) {
				myOpening.dimA1M = (int) (leanTo.dimA1 * 100);
				myOpening.dimA2M = (int) (leanTo.dimA2 * 100);
				myOpening.dimA3M = (int) (leanTo.dimA3 * 100);
				myOpening.dimA0M = (int) (leanTo.dimA0 * 100);
				myOpening.dimB1M = (int) (leanTo.dimB1 * 100);
				myOpening.dimB2M = (int) (leanTo.dimB2 * 100);
				myOpening.dimB0M = (int) (leanTo.dimB0 * 100);
				myOpening.dimC1M = (int) (leanTo.dimC1 * 100);
				myOpening.dimC2M = (int) (leanTo.dimC2 * 100);
				myOpening.dimC0M = (int) (leanTo.dimC0 * 100);
				myOpening.dimD1M = (int) (leanTo.dimD1 * 100);
				myOpening.dimD2M = (int) (leanTo.dimD2 * 100);
				myOpening.dimD0M = (int) (leanTo.dimD0 * 100);

				myOpening.dimA1I = (int) (leanTo.dimA1 / 25.4 * 64);
				myOpening.dimA2I = (int) (leanTo.dimA2 / 25.4 * 64);
				myOpening.dimA3I = (int) (leanTo.dimA3 / 25.4 * 64);
				myOpening.dimA0I = (int) (leanTo.dimA0 / 25.4 * 64);
				myOpening.dimB1I = (int) (leanTo.dimB1 / 25.4 * 64);
				myOpening.dimB2I = (int) (leanTo.dimB2 / 25.4 * 64);
				myOpening.dimB0I = (int) (leanTo.dimB0 / 25.4 * 64);
				myOpening.dimC1I = (int) (leanTo.dimC1 / 25.4 * 64);
				myOpening.dimC2I = (int) (leanTo.dimC2 / 25.4 * 64);
				myOpening.dimC0I = (int) (leanTo.dimC0 / 25.4 * 64);
				myOpening.dimD1I = (int) (leanTo.dimD1 / 25.4 * 64);
				myOpening.dimD2I = (int) (leanTo.dimD2 / 25.4 * 64);
				myOpening.dimD0I = (int) (leanTo.dimD0 / 25.4 * 64);

			} else {
				myOpening.dimA1I = (int) leanTo.dimA1;
				myOpening.dimA2I = (int) leanTo.dimA2;
				myOpening.dimA3I = (int) leanTo.dimA3;
				myOpening.dimA0I = (int) leanTo.dimA0;
				myOpening.dimB1I = (int) leanTo.dimB1;
				myOpening.dimB2I = (int) leanTo.dimB2;
				myOpening.dimB0I = (int) leanTo.dimB0;
				myOpening.dimC1I = (int) leanTo.dimC1;
				myOpening.dimC2I = (int) leanTo.dimC2;
				myOpening.dimC0I = (int) leanTo.dimC0;
				myOpening.dimD1I = (int) leanTo.dimD1;
				myOpening.dimD2I = (int) leanTo.dimD2;
				myOpening.dimD0I = (int) leanTo.dimD0;

				myOpening.dimA1M = (int) (leanTo.dimA1 * 25.4 * 100);
				myOpening.dimA2M = (int) (leanTo.dimA2 * 25.4 * 100);
				myOpening.dimA3M = (int) (leanTo.dimA3 * 25.4 * 100);
				myOpening.dimA0M = (int) (leanTo.dimA0 * 25.4 * 100);
				myOpening.dimB1M = (int) (leanTo.dimB1 * 25.4 * 100);
				myOpening.dimB2M = (int) (leanTo.dimB2 * 25.4 * 100);
				myOpening.dimB0M = (int) (leanTo.dimB0 * 25.4 * 100);
				myOpening.dimC1M = (int) (leanTo.dimC1 * 25.4 * 100);
				myOpening.dimC2M = (int) (leanTo.dimC2 * 25.4 * 100);
				myOpening.dimC0M = (int) (leanTo.dimC0 * 25.4 * 100);
				myOpening.dimD1M = (int) (leanTo.dimD1 * 25.4 * 100);
				myOpening.dimD2M = (int) (leanTo.dimD2 * 25.4 * 100);
				myOpening.dimD0M = (int) (leanTo.dimD0 * 25.4 * 100);
			}

			myOpening.pA0 = leanTo.dimA0 / myScale.doubleValue() / leanTo.w;
			myOpening.pA1 = leanTo.dimA1 / myScale.doubleValue() / leanTo.w;
			myOpening.pA2 = leanTo.dimA2 / myScale.doubleValue() / leanTo.w;
			myOpening.pA3 = leanTo.dimA3 / myScale.doubleValue() / leanTo.w;
			myOpening.pB0 = leanTo.dimB0 / myScale.doubleValue() / leanTo.h;
			myOpening.pB1 = leanTo.dimB1 / myScale.doubleValue() / leanTo.h;
			myOpening.pB2 = leanTo.dimB2 / myScale.doubleValue() / leanTo.h;
			myOpening.pC0 = leanTo.dimC0 / myScale.doubleValue() / leanTo.w;
			myOpening.pC1 = leanTo.dimC1 / myScale.doubleValue() / leanTo.w;
			myOpening.pC2 = leanTo.dimC2 / myScale.doubleValue() / leanTo.w;
			myOpening.pD0 = leanTo.dimD0 / myScale.doubleValue() / leanTo.h;
			myOpening.pD1 = leanTo.dimD1 / myScale.doubleValue() / leanTo.h;
			myOpening.pD2 = leanTo.dimD2 / myScale.doubleValue() / leanTo.h;

		}
		myOpening.lean = leanTo.lean;
		myOpening.lean2 = leanTo.lean2;
		myOpening.lean3 = leanTo.lean3;
		myOpening.lean4 = leanTo.lean4;

		myOpening.shapeChanged = true;
		myOpening.shapeID = shapeID;

		myDrawCanvas.mySelectedFrame = myOpening;

		myOpening.newDesign = false;

		// myParent.clearDrawObjects();// reset
		// myParent.myParent.overallUsed
		// .clearTexts();
		//
		// myParent.myParent.overallUsed.bOpeningObject.mullions
		// .toArray();
		// myParent.myParent.overallUsed.bOpeningObject.mullionsH
		// .toArray();

	}

	/**
	 * Reset Facet opening for shape
	 */
	public void resetFacetOpeningShape() {

		try {

			// Get opening from overall design
			Object[] dopenings = myDrawCanvas.myParent.jobItem.design.openings
					.toArray();
			// Clear array list from opening
			myDrawCanvas.myParent.jobItem.design.openings.clear();

			for (Object o : dopenings) {

				if (((OpeningObject) o).a_sequenceID == myOpening.a_sequenceID) {
					((OpeningObject) o).shapeID = 1;
					((OpeningObject) o).lean = 0;
					((OpeningObject) o).lean2 = 0;
					((OpeningObject) o).lean3 = 0;
					((OpeningObject) o).lean4 = 0;

					((OpeningObject) o).setDimABCDFromShapeChange(0, 0, 0, 0,
							0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
							0, 0, 0);

					((OpeningObject) o).noSides = 4;
					((OpeningObject) o).noSidesTop = 1;
					((OpeningObject) o).noSidesBot = 1;
					((OpeningObject) o).noSidesLeft = 1;
					((OpeningObject) o).noSidesRight = 1;

					((OpeningObject) o).leftShape = 1;
					((OpeningObject) o).rightShape = 1;
					((OpeningObject) o).topShape = 1;
					((OpeningObject) o).botShape = 1;
				}

				myDrawCanvas.myParent.jobItem.design.openings.add(o);
			}

			// Get arrays list of facets
			Object[] facets = myDrawCanvas.myParent.jobItem.design.frames
					.toArray();
			// Clear facets collection
			myDrawCanvas.myParent.jobItem.design.frames.clear();

			for (Object facet : facets) {

				if (((Facet) facet).a_sequenceID == myDrawCanvas.myParent.facetUsed.a_sequenceID) {
					((Facet) facet).shapeID = 1;

					// set Facet Values
					((Facet) facet).lean = 0;
					((Facet) facet).lean2 = 0;
					((Facet) facet).lean3 = 0;
					((Facet) facet).lean4 = 0;

					((Facet) facet).setDimABCDFromShapeChange(0, 0, 0, 0, 0, 0,
							0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
							0);

					((Facet) facet).noSides = 4;
					((Facet) facet).noSidesTop = 1;
					((Facet) facet).noSidesBot = 1;
					((Facet) facet).noSidesLeft = 1;
					((Facet) facet).noSidesRight = 1;
					((Facet) facet).leftShape = 1;
					((Facet) facet).rightShape = 1;
					((Facet) facet).topShape = 1;
					((Facet) facet).botShape = 1;

					((Facet) facet).bOpeningObject.shapeID = 1;
					((Facet) facet).bOpeningObject.lean = 0;
					((Facet) facet).bOpeningObject.lean2 = 0;
					((Facet) facet).bOpeningObject.lean3 = 0;
					((Facet) facet).bOpeningObject.lean4 = 0;
					// ((Facet) facet).bOpeningObject.widthPix =
					// ((Facet) facet).bOpeningObject.heightPix =
					// Math.max(((Facet) facet).widthPix, ((Facet)
					// facet).heightPix);

					((Facet) facet).bOpeningObject.setDimABCDFromShapeChange(0,
							0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
							0, 0, 0, 0, 0, 0);

					((Facet) facet).bOpeningObject.noSides = 4;
					((Facet) facet).bOpeningObject.noSidesTop = 1;
					((Facet) facet).bOpeningObject.noSidesBot = 1;
					((Facet) facet).bOpeningObject.noSidesLeft = 1;
					((Facet) facet).bOpeningObject.noSidesRight = 1;

					myDrawCanvas.myParent.facetUsed = (Facet) facet;
					// myOpening =
					// myDrawCanvas.myParent.facetUsed.myParentO;

					final Object[] fopenings = ((Facet) facet).openings
							.toArray();
					((Facet) facet).openings.clear();

					for (Object o : fopenings) {

						((OpeningObject) o).shapeID = 1;

						((OpeningObject) o).lean = 0;
						((OpeningObject) o).lean2 = 0;
						((OpeningObject) o).lean3 = 0;
						((OpeningObject) o).lean4 = 0;

						((OpeningObject) o).setDimABCDFromShapeChange(0, 0, 0,
								0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
								0, 0, 0, 0, 0);

						((OpeningObject) o).noSides = 4;
						((OpeningObject) o).noSidesTop = 1;
						((OpeningObject) o).noSidesBot = 1;
						((OpeningObject) o).noSidesLeft = 1;
						((OpeningObject) o).noSidesRight = 1;
						((OpeningObject) o).leftShape = 1;
						((OpeningObject) o).rightShape = 1;
						((OpeningObject) o).topShape = 1;
						((OpeningObject) o).botShape = 1;

						((Facet) facet).openings.add(o);
					}

					Object[] fframes = ((Facet) facet).frames.toArray();
					((Facet) facet).frames.clear();

					for (final Object f : fframes) {

						((Frame) f).shapeID = 1;
						((Frame) f).lean = 0;
						((Frame) f).lean2 = 0;
						((Frame) f).lean3 = 0;
						((Frame) f).lean4 = 0;

						((Frame) f).setDimABCDFromShapeChange(0, 0, 0, 0, 0, 0,
								0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
								0, 0);

						((Frame) f).noSides = 4;
						((Frame) f).noSidesTop = 1;
						((Frame) f).noSidesBot = 1;
						((Frame) f).noSidesLeft = 1;
						((Frame) f).noSidesRight = 1;
						((Frame) f).leftShape = 1;
						((Frame) f).rightShape = 1;
						((Frame) f).topShape = 1;
						((Frame) f).botShape = 1;

						((Facet) facet).frames.add(f);
					}
				}

				myDrawCanvas.myParent.jobItem.design.frames.add(facet);
			}

			Object[] openings = myDrawCanvas.myParent.jobItem.design.openings
					.toArray();
			myDrawCanvas.myParent.jobItem.design.openings.clear();

			for (final Object o : openings) {
				if (((OpeningObject) o).a_sequenceID == myDrawCanvas.myParent.facetUsed.a_sequenceID) {
					((OpeningObject) o).shapeID = 1;
					((OpeningObject) o).lean = 0;
					((OpeningObject) o).lean2 = 0;
					((OpeningObject) o).lean3 = 0;
					((OpeningObject) o).lean4 = 0;

					// ((OpeningObject) o).widthPix =
					// ((OpeningObject) o).heightPix =
					// Math.max(((OpeningObject) o).widthPix,
					// ((OpeningObject)
					// o).heightPix);

					((OpeningObject) o).setDimABCDFromShapeChange(0, 0, 0, 0,
							0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
							0, 0, 0);

					((OpeningObject) o).noSides = 4;

					((OpeningObject) o).noSidesTop = 1;

					((OpeningObject) o).noSidesBot = 1;

					((OpeningObject) o).noSidesLeft = 1;

				}
				myDrawCanvas.myParent.jobItem.design.openings.add(o);

			}
			// facets =
			// myParent.myParent.jobItem.design.frames.toArray();
			// myParent.myParent.jobItem.design.frames.clear();
			//
			// for(final Object facet : facets) {
			// if(((Facet)facet).sequenceID ==
			// myParent.myParent.facetUsed.sequenceID) {
			// final Object[] fos =
			// ((Facet)facet).openings.toArray();
			// ((Facet)facet).openings.clear();
			//
			//
			// for(final Object fo : fos) {
			//
			// ((OpeningObject) fo).shapeID=shapeID;
			//
			// final SetSides setSides = new SetSides(shapeID);
			//
			// ((OpeningObject) fo).noSides = setSides.noSides;
			// ((OpeningObject) fo).noSidesTop = setSides.noSidesTop;
			// ((OpeningObject) fo).noSidesBot = setSides.noSidesBot;
			// ((OpeningObject) fo).noSidesLeft= setSides.noSidesLeft;
			// ((OpeningObject) fo).noSidesRight =
			// setSides.noSidesRight;
			//
			// ((Facet)facet).openings.add(fo);
			// }
			//
			//
			// }
			//
			// myParent.myParent.jobItem.design.frames.add(facet);
			// }

			if (leanTo.myShape > 10
					&& leanTo.myShape < 100
					|| leanTo.myShape >= 800
					|| leanTo.resetWorH != 0
					|| leanTo.myShape >= 450
					&& leanTo.myShape <= 470
					&& myDrawCanvas.myParent.facetUsed.bOpeningObject.xCols == 1
					&& myDrawCanvas.myParent.facetUsed.bOpeningObject.yRows == 1) {
				boolean sizeChanged = false;

				if (leanTo.w != myDrawCanvas.myParent.jobItem.design.widthPix
						/ myScale.doubleValue()
						|| leanTo.h != myDrawCanvas.myParent.jobItem.design.heightPix
								/ myScale.doubleValue()) {
					sizeChanged = true;
				}

				if (sizeChanged) {

					myDrawCanvas.myParent.doResetOverallSize(leanTo.w,
							leanTo.h, myDrawCanvas.myParent.jobItem.design, 0,
							true, false);

					if (myDrawCanvas.myParent.myTopPanel.metric.isSelected()) {
						myScale = myDrawCanvas.myParent.scale
								.multiply(new BigDecimal(100));
					} else {
						myScale = myDrawCanvas.myParent.scale;
					}

				}

				openings = myDrawCanvas.myParent.jobItem.design.openings
						.toArray();
				myDrawCanvas.myParent.jobItem.design.openings.clear();

				for (Object O : openings) {

					if (((OpeningObject) O).a_sequenceID == myDrawCanvas.myParent.facetUsed.a_sequenceID) {

						O = doFacetOpeningChange(leanTo.myShape,
								(OpeningObject) O);
					}

					myDrawCanvas.myParent.jobItem.design.openings.add(O);

					// myDrawCanvas.myParent.facetUsed = this.myOpening =
					// (OpeningObject) O;

				}

				myDrawCanvas.myParent.jobItem.design.doFacets(false, false,
						true, false);

				myDrawCanvas.myParent.jobItem.design.drawFacets();

				if (myDrawCanvas.myParent.hasGrids) {

					myDrawCanvas.myParent.gridsPanel.bSetSelectedGrid.doClick();

				}

			}

			// final Collection existingFacets = new ArrayList();
			//
			// existingFacets.addAll(myParent.myParent.jobItem.design.frames);
			//
			// myParent.myParent.jobItem.design.frames.clear();
			//
			// final Object[] oo =
			// myParent.myParent.jobItem.design.openings.toArray();
			//
			// for (final Object O : oo)
			// {
			// if(((OpeningObject) O).sequenceID ==
			// myParent.myParent.facetUsed.sequenceID) {
			// if(((OpeningObject) O).shapeID==0) {
			// ((OpeningObject) O).shapeID=1;
			// }
			// Facet myFacet = new Facet();
			//
			// final CreateFacets createFacet =
			// new CreateFacets(
			// (OpeningObject) O,
			// existingFacets,
			// myParent.myParent);
			//
			//
			//
			// myFacet =
			// createFacet
			// .doFacet(false,true, false);
			//
			//
			// myFacet.doCouplers();
			//
			// myFacet.doFrames(true, true, true);
			// myFacet.drawFrames();
			//
			// myFacet.setOriginalDimsInit(myFacet.widthPix,
			// myFacet.heightPix);
			// myFacet.setDimsChange(myFacet.widthPix,
			// myFacet.heightPix);
			// myParent.myParent.jobItem.design.frames.add(myFacet);
			// }
			//
			//
			// }
			//
			//
			// facets =
			// myParent.myParent.jobItem.design.frames.toArray();
			//
			//
			// for(final Object facet : facets) {
			// if(((Facet)facet).sequenceID ==
			// myParent.myParent.facetUsed.sequenceID) {
			// myParent.myParent.facetUsed = ((Facet)facet);
			// myOpening = ((Facet)facet).bOpeningObject;
			// }
			// }

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void resetFacetOpeningShapeOLD() {

		try {

			final Object[] openings = myDrawCanvas.myParent.facetUsed.openings
					.toArray();
			myDrawCanvas.myParent.facetUsed.openings.clear();

			for (final Object O : openings) {
				((OpeningObject) O).shapeID = 1;
				// }
				((OpeningObject) O).lean = 0;
				((OpeningObject) O).lean2 = 0;
				((OpeningObject) O).lean3 = 0;
				((OpeningObject) O).lean4 = 0;
				((OpeningObject) O).setDimABCDFromShapeChange(0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

				((OpeningObject) O).noSides = myOpening.noSides = myOpening.noSides = noSides.noSides;
				((OpeningObject) O).noSidesTop = myOpening.noSidesTop = myOpening.noSidesTop = noSides.noSidesTop;
				((OpeningObject) O).noSidesBot = myOpening.noSidesBot = myOpening.noSidesBot = noSides.noSidesBot;
				((OpeningObject) O).noSidesLeft = myOpening.noSidesLeft = myOpening.noSidesLeft = noSides.noSidesLeft;
				((OpeningObject) O).noSidesRight = myOpening.noSidesRight = myOpening.noSidesRight = noSides.noSidesRight;

				myDrawCanvas.myParent.facetUsed.shapeID = 1;
				myDrawCanvas.myParent.facetUsed.lean = 0;
				myDrawCanvas.myParent.facetUsed.lean2 = 0;
				myDrawCanvas.myParent.facetUsed.lean3 = 0;
				myDrawCanvas.myParent.facetUsed.lean4 = 0;
				myDrawCanvas.myParent.facetUsed.setDimABCDFromShapeChange(0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0);

				myDrawCanvas.myParent.facetUsed.noSides =

				noSides.noSides;
				myDrawCanvas.myParent.facetUsed.noSidesTop =

				noSides.noSidesTop;
				myDrawCanvas.myParent.facetUsed.noSidesBot =

				noSides.noSidesBot;
				myDrawCanvas.myParent.facetUsed.noSidesLeft =

				noSides.noSidesLeft;
				myDrawCanvas.myParent.facetUsed.noSidesRight =

				noSides.noSidesRight;

				myDrawCanvas.myParent.facetUsed.openings.add(O);
			}

			if (leanTo.myShape < 10 || leanTo.myShape > 99
					&& leanTo.myShape < 800) {
				myDrawCanvas.myParent.facetUsed.doOpenings();
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void resetFacetOpeningShapeSingle() {

		try {

			final Object[] openings = myDrawCanvas.myParent.jobItem.design.openings
					.toArray();
			myDrawCanvas.myParent.jobItem.design.openings.clear();
			boolean redoSize = false;
			for (final Object O : openings) {
				if (((OpeningObject) O).a_sequenceID == myDrawCanvas.myParent.facetUsed.a_sequenceID) {

					((OpeningObject) O).shapeID = 1;

					((OpeningObject) O).lean = 0;
					((OpeningObject) O).lean2 = 0;
					((OpeningObject) O).lean3 = 0;
					((OpeningObject) O).lean4 = 0;
					((OpeningObject) O).setDimABCDFromShapeChange(0, 0, 0, 0,
							0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
							0, 0, 0);

					((OpeningObject) O).noSides = myOpening.noSides = myOpening.noSides = noSides.noSides;
					((OpeningObject) O).noSidesTop = myOpening.noSidesTop = myOpening.noSidesTop = noSides.noSidesTop;
					((OpeningObject) O).noSidesBot = myOpening.noSidesBot = myOpening.noSidesBot = noSides.noSidesBot;
					((OpeningObject) O).noSidesLeft = myOpening.noSidesLeft = myOpening.noSidesLeft = noSides.noSidesLeft;
					((OpeningObject) O).noSidesRight = myOpening.noSidesRight = myOpening.noSidesRight = noSides.noSidesRight;

					myDrawCanvas.myParent.facetUsed.shapeID = 1;
					myDrawCanvas.myParent.facetUsed.lean = 0;
					myDrawCanvas.myParent.facetUsed.lean2 = 0;
					myDrawCanvas.myParent.facetUsed.lean3 = 0;
					myDrawCanvas.myParent.facetUsed.lean4 = 0;
					myDrawCanvas.myParent.facetUsed.setDimABCDFromShapeChange(
							0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
							0, 0, 0, 0, 0, 0, 0);

					myDrawCanvas.myParent.facetUsed.noSides =

					noSides.noSides;
					myDrawCanvas.myParent.facetUsed.noSidesTop =

					noSides.noSidesTop;
					myDrawCanvas.myParent.facetUsed.noSidesBot =

					noSides.noSidesBot;
					myDrawCanvas.myParent.facetUsed.noSidesLeft =

					noSides.noSidesLeft;
					myDrawCanvas.myParent.facetUsed.noSidesRight =

					noSides.noSidesRight;

					if (leanTo.myShape > 10
							&& leanTo.myShape < 100
							|| leanTo.myShape >= 800
							|| leanTo.resetWorH != 0
							|| leanTo.myShape >= 450
							&& leanTo.myShape <= 470
							&& myDrawCanvas.myParent.facetUsed.bOpeningObject.xCols == 1
							&& myDrawCanvas.myParent.facetUsed.bOpeningObject.yRows == 1) {

						myDrawCanvas.myParent.jobItem.setWHDimChange(leanTo.w,
								leanTo.h, true);

						((OpeningObject) O).shapeID = myDrawCanvas.myParent.facetUsed.shapeID = leanTo.myShape;

						((OpeningObject) O).lean = myDrawCanvas.myParent.facetUsed.lean = leanTo.lean;
						((OpeningObject) O).lean2 = myDrawCanvas.myParent.facetUsed.lean2 = leanTo.lean2;
						((OpeningObject) O).lean3 = myDrawCanvas.myParent.facetUsed.lean3 = leanTo.lean3;
						((OpeningObject) O).lean4 = myDrawCanvas.myParent.facetUsed.lean4 = leanTo.lean4;
						((OpeningObject) O).dimA1 = myDrawCanvas.myParent.facetUsed.dimA1 = leanTo.dimA1
								* myScale.doubleValue();
						((OpeningObject) O).dimA2 = myDrawCanvas.myParent.facetUsed.dimA2 = leanTo.dimA2
								* myScale.doubleValue();
						((OpeningObject) O).dimA3 = myDrawCanvas.myParent.facetUsed.dimA3 = leanTo.dimA3
								* myScale.doubleValue();
						((OpeningObject) O).dimA0 = myDrawCanvas.myParent.facetUsed.dimA0 = leanTo.dimA0
								* myScale.doubleValue();
						((OpeningObject) O).dimB1 = myDrawCanvas.myParent.facetUsed.dimB1 = leanTo.dimB1
								* myScale.doubleValue();
						((OpeningObject) O).dimB2 = myDrawCanvas.myParent.facetUsed.dimB2 = leanTo.dimB2
								* myScale.doubleValue();
						((OpeningObject) O).dimB0 = myDrawCanvas.myParent.facetUsed.dimB0 = leanTo.dimB0
								* myScale.doubleValue();
						((OpeningObject) O).dimC1 = myDrawCanvas.myParent.facetUsed.dimC1 = leanTo.dimC1
								* myScale.doubleValue();
						((OpeningObject) O).dimC2 = myDrawCanvas.myParent.facetUsed.dimC2 = leanTo.dimC2
								* myScale.doubleValue();
						((OpeningObject) O).dimC0 = myDrawCanvas.myParent.facetUsed.dimC0 = leanTo.dimC0
								* myScale.doubleValue();
						((OpeningObject) O).dimD1 = myDrawCanvas.myParent.facetUsed.dimD1 = leanTo.dimD1
								* myScale.doubleValue();
						((OpeningObject) O).dimD2 = ((OpeningObject) O).dimD2 = leanTo.dimD2
								* myScale.doubleValue();
						((OpeningObject) O).dimD0 = ((OpeningObject) O).dimD0 = leanTo.dimD0
								* myScale.doubleValue();
						((OpeningObject) O).shapeID = myDrawCanvas.myParent.facetUsed.shapeID = leanTo.myShape;

						((OpeningObject) O).noSides = myOpening.noSides = myOpening.noSides = noSides.noSides;
						((OpeningObject) O).noSidesTop = myOpening.noSidesTop = myOpening.noSidesTop = noSides.noSidesTop;
						((OpeningObject) O).noSidesBot = myOpening.noSidesBot = myOpening.noSidesBot = noSides.noSidesBot;
						((OpeningObject) O).noSidesLeft = myOpening.noSidesLeft = myOpening.noSidesLeft = noSides.noSidesLeft;
						((OpeningObject) O).noSidesRight = myOpening.noSidesRight = myOpening.noSidesRight = noSides.noSidesRight;

						myDrawCanvas.myParent.jobItem.nominalW = myOpening.widthPix = ((OpeningObject) O).widthPix = myDrawCanvas.myParent.jobItem.design_flat_WIDTHpix;
						myDrawCanvas.myParent.jobItem.nominalH = myOpening.heightPix = ((OpeningObject) O).heightPix = myDrawCanvas.myParent.jobItem._HEIGHTpix;

						myOpening.bY3 = ((OpeningObject) O).bY3 = myOpening.startingY
								+ myOpening.heightPix;

						myOpening.bY4 = ((OpeningObject) O).bY4 = myOpening.startingY
								+ myOpening.heightPix;

						redoSize = true;

					}

				}
				myDrawCanvas.myParent.facetUsed.openings.add(O);
			}

			if (redoSize) {
				myDrawCanvas.myParent.doResetOverallSize(leanTo.w, leanTo.h,
						myDrawCanvas.myParent.jobItem.design, 2, true, false);
			}

			if (leanTo.myShape < 10 || leanTo.myShape > 99
					&& leanTo.myShape < 800) {
				myDrawCanvas.myParent.facetUsed.doOpenings();
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void doFrameShapeChange(final int myShape) {

		final Object[] openings = myDrawCanvas.myParent.facetUsed.openings
				.toArray();
		myDrawCanvas.myParent.facetUsed.shapeChanged = false;

		myDrawCanvas.myParent.facetUsed.frameShapeChanged = true;

		myDrawCanvas.myParent.facetUsed.openings.clear();
		for (Object O : openings) {
			
//			((OpeningObject) O).affected=false;
			
			if (myOpening.startCol == ((OpeningObject) O).startCol
					&& myOpening.endCol == ((OpeningObject) O).endCol
					&& myOpening.startRow == ((OpeningObject) O).startRow
					&& myOpening.endRow == ((OpeningObject) O).endRow) {

				((OpeningObject) O).shapeID = myShape;
				((OpeningObject) O).lean = myOpening.lean;
				((OpeningObject) O).lean2 = myOpening.lean2;
				((OpeningObject) O).lean3 = myOpening.lean3;
				((OpeningObject) O).lean4 = myOpening.lean4;
				((OpeningObject) O).dimA1 = myOpening.dimA1;
				((OpeningObject) O).dimA2 = myOpening.dimA2;
				((OpeningObject) O).dimA3 = myOpening.dimA3;
				((OpeningObject) O).dimA4 = myOpening.dimA4;
				((OpeningObject) O).dimA5 = myOpening.dimA5;
				((OpeningObject) O).dimA0 = myOpening.dimA0;

				((OpeningObject) O).dimB1 = myOpening.dimB1;
				((OpeningObject) O).dimB2 = myOpening.dimB2;
				((OpeningObject) O).dimB3 = myOpening.dimB3;
				((OpeningObject) O).dimB4 = myOpening.dimB4;
				((OpeningObject) O).dimB5 = myOpening.dimB5;
				((OpeningObject) O).dimB0 = myOpening.dimB0;

				((OpeningObject) O).dimC1 = myOpening.dimC1;
				((OpeningObject) O).dimC2 = myOpening.dimC2;
				((OpeningObject) O).dimC3 = myOpening.dimC3;
				((OpeningObject) O).dimC4 = myOpening.dimC4;
				((OpeningObject) O).dimC5 = myOpening.dimC5;
				((OpeningObject) O).dimC0 = myOpening.dimC0;

				((OpeningObject) O).dimD1 = myOpening.dimD1;
				((OpeningObject) O).dimD2 = myOpening.dimD2;
				((OpeningObject) O).dimD3 = myOpening.dimD3;
				((OpeningObject) O).dimD4 = myOpening.dimD4;
				((OpeningObject) O).dimD5 = myOpening.dimD5;
				((OpeningObject) O).dimD0 = myOpening.dimD0;

				((OpeningObject) O).noSides = myOpening.noSides = noSides.noSides;
				((OpeningObject) O).noSidesTop = myOpening.noSidesTop = noSides.noSidesTop;
				((OpeningObject) O).noSidesBot = myOpening.noSidesBot = noSides.noSidesBot;
				((OpeningObject) O).noSidesLeft = myOpening.noSidesLeft = noSides.noSidesLeft;
				((OpeningObject) O).noSidesRight = myOpening.noSidesRight = noSides.noSidesRight;
				
//				((OpeningObject) O).affected=true;
				
				final double b1X = Math.min(((OpeningObject) O).startingX,
						((OpeningObject) O).bX4);

				final double b2X = Math.max(((OpeningObject) O).bX2,
						((OpeningObject) O).bX3);

				final double b3X = Math.max(((OpeningObject) O).bX3,
						((OpeningObject) O).bX2);

				final double b4X = Math.min(((OpeningObject) O).startingX,
						((OpeningObject) O).bX4);

				final double b1XC = Math.min(((OpeningObject) O).startingCX,
						((OpeningObject) O).bCX4);

				final double b2XC = Math.max(((OpeningObject) O).bCX2,
						((OpeningObject) O).bCX3);

				final double b3XC = Math.max(((OpeningObject) O).bCX3,
						((OpeningObject) O).bCX2);

				final double b4XC = Math.min(((OpeningObject) O).startingCX,
						((OpeningObject) O).bCX4);

				final double b1Y = Math.min(
						Math.min(((OpeningObject) O).startingY,
								((OpeningObject) O).bY2),
						((OpeningObject) O).highestY);

				final double b2Y = Math.min(
						Math.min(((OpeningObject) O).startingY,
								((OpeningObject) O).bY2),
						((OpeningObject) O).highestY);

				final double b3Y = Math.max(Math.min(((OpeningObject) O).bY3,
						((OpeningObject) O).bY4), ((OpeningObject) O).lowestY);

				final double b4Y = Math.max(Math.min(((OpeningObject) O).bY3,
						((OpeningObject) O).bY4), ((OpeningObject) O).lowestY);

				final double b1YC = b1Y;

				final double b2YC = b2Y;

				final double b3YC = b3Y;

				final double b4YC = b4Y;

				((OpeningObject) O).startingX = b1X;
				((OpeningObject) O).bX2 = b2X;
				((OpeningObject) O).bX3 = b3X;
				((OpeningObject) O).bX4 = b4X;

				((OpeningObject) O).startingCX = b1XC;
				((OpeningObject) O).bCX2 = b2XC;
				((OpeningObject) O).bCX3 = b3XC;
				((OpeningObject) O).bCX4 = b4XC;

				((OpeningObject) O).startingY = b1Y;
				((OpeningObject) O).bY2 = b2Y;
				((OpeningObject) O).bY3 = b3Y;
				((OpeningObject) O).bY4 = b4Y;

				((OpeningObject) O).startingCY = b1YC;
				((OpeningObject) O).bCY2 = b2YC;
				((OpeningObject) O).bCY3 = b3YC;
				((OpeningObject) O).bCY4 = b4YC;

				((OpeningObject) O).createSideShapes(false, true, myScale);

				((OpeningObject) O).setBAandA();

				final CreateOpenings createOpening = new CreateOpenings(
						((OpeningObject) O), myDrawCanvas.myParent);

				((OpeningObject) O).radius1 = ((OpeningObject) O).top1Part.radius1;
				((OpeningObject) O).radius1A = ((OpeningObject) O).top1Part.radius1A;
				((OpeningObject) O).radius2 = ((OpeningObject) O).top1Part.radius2;
				((OpeningObject) O).radius2A = ((OpeningObject) O).top1Part.radius2A;
				((OpeningObject) O).centerPointX = ((OpeningObject) O).top1Part.x1;
				((OpeningObject) O).centerPointY = ((OpeningObject) O).top1Part.y1;
				((OpeningObject) O).centerPointX2 = ((OpeningObject) O).top1Part.x2;
				((OpeningObject) O).centerPointY2 = ((OpeningObject) O).top1Part.y2;
				((OpeningObject) O).top1Part.bkgrdStartX = ((OpeningObject) O).top1Part.x1
						- ((OpeningObject) O).radius1;

				((OpeningObject) O).top1Part.bkgrdStartY = ((OpeningObject) O).top1Part.y1
						- ((OpeningObject) O).radius1;

				((OpeningObject) O).top1Part.bkgrdStartXBA = ((OpeningObject) O).top1Part.x1
						- ((OpeningObject) O).top1Part.radius1BA;

				((OpeningObject) O).top1Part.bkgrdStartYBA = ((OpeningObject) O).top1Part.y1
						- ((OpeningObject) O).top1Part.radius1BA;

				((OpeningObject) O).top1Part.bkgrdStartXA = ((OpeningObject) O).top1Part.x1
						- ((OpeningObject) O).top1Part.radius1A;

				((OpeningObject) O).top1Part.bkgrdStartYA = ((OpeningObject) O).top1Part.y1
						- ((OpeningObject) O).top1Part.radius1A;

				((OpeningObject) O).bkgrdStartX = ((OpeningObject) O).top1Part.bkgrdStartX;
				((OpeningObject) O).bkgrdStartY = ((OpeningObject) O).top1Part.bkgrdStartY;

				((OpeningObject) O).bkgrdStartXA = ((OpeningObject) O).top1Part.bkgrdStartXA;
				((OpeningObject) O).bkgrdStartYA = ((OpeningObject) O).top1Part.bkgrdStartYA;

				((OpeningObject) O).widthPix = Math.max(
						((OpeningObject) O).bX2, ((OpeningObject) O).bX3)
						- Math.min(((OpeningObject) O).startingX,
								((OpeningObject) O).bX4);

				if (((OpeningObject) O).a_levelID > 3) {

					((OpeningObject) O).heightPix =

					((OpeningObject) O).lowestY - ((OpeningObject) O).highestY

					+ ((OpeningObject) O).top1Part.partDimC
							+ ((OpeningObject) O).bot1Part.partDimC;

				} else {

					((OpeningObject) O).heightPix =

					((OpeningObject) O).lowestY - ((OpeningObject) O).highestY;

				}

				createOpening.setTBLR(((OpeningObject) O));

				O = createOpening.getPxyALL(((OpeningObject) O));
				createOpening.setPxyCenters(((OpeningObject) O));

				O = createOpening.setPartObjectForms(((OpeningObject) O));

				((OpeningObject) O).noSides = createOpening
						.totalSides(((OpeningObject) O));

				O = createOpening.posInUse(((OpeningObject) O));

				CreateShapeMethods createShape = new CreateShapeMethods(
						((OpeningObject) O), 2, myDrawCanvas.myParent);
				O = createShape.makeSidesStraight(((OpeningObject) O));

				final Object[] returns = createOpening.makeOpening(
						((OpeningObject) O), createShape);
				O = returns[0];

				O = cloneMyProfiles(O);

				((OpeningObject) O).shapeChanged = true;

				if (shapeID == 10) {
					// ((OpeningObject)O).unGlazed = true;
					// ((OpeningObject)O).myGlassIn = null;
					// ((OpeningObject)O).myGlassMid = null;
					// ((OpeningObject)O).myGlassOut = null;
				}
				returns[1] = null;
				returns[0] = null;
				createShape = null;

				myDrawCanvas.myParent.facetUsed.openings.add(O);

			} else {
				myDrawCanvas.myParent.facetUsed.openings.add(O);
			}

		}
		myDrawCanvas.myParent.facetUsed
				.doMullions(myDrawCanvas.myParent.facetUsed.bOpeningObject);
	}

	/**
	 * Shape change facet
	 * 
	 * @param myShape
	 *            , ShapeForm
	 */
	public void doFacetShapeChange(int myShape) {

		try {

			final Object[] openings = myDrawCanvas.myParent.jobItem.design.openings
					.toArray();
			myDrawCanvas.myParent.jobItem.design.openings.clear();
			for (Object O : openings) {
				if (myOpening.a_sequenceID == ((OpeningObject) O).a_sequenceID) {

					((OpeningObject) O).shapeID = myShape;
					((OpeningObject) O).lean = myOpening.lean;
					((OpeningObject) O).lean2 = myOpening.lean2;
					((OpeningObject) O).lean3 = myOpening.lean3;
					((OpeningObject) O).lean4 = myOpening.lean4;
					((OpeningObject) O).dimA1 = myOpening.dimA1;
					((OpeningObject) O).dimA2 = myOpening.dimA2;
					((OpeningObject) O).dimA3 = myOpening.dimA3;
					((OpeningObject) O).dimA4 = myOpening.dimA4;
					((OpeningObject) O).dimA5 = myOpening.dimA5;
					((OpeningObject) O).dimA0 = myOpening.dimA0;

					((OpeningObject) O).dimB1 = myOpening.dimB1;
					((OpeningObject) O).dimB2 = myOpening.dimB2;
					((OpeningObject) O).dimB3 = myOpening.dimB3;
					((OpeningObject) O).dimB4 = myOpening.dimB4;
					((OpeningObject) O).dimB5 = myOpening.dimB5;
					((OpeningObject) O).dimB0 = myOpening.dimB0;

					((OpeningObject) O).dimC1 = myOpening.dimC1;
					((OpeningObject) O).dimC2 = myOpening.dimC2;
					((OpeningObject) O).dimC3 = myOpening.dimC3;
					((OpeningObject) O).dimC4 = myOpening.dimC4;
					((OpeningObject) O).dimC5 = myOpening.dimC5;
					((OpeningObject) O).dimC0 = myOpening.dimC0;

					((OpeningObject) O).dimD1 = myOpening.dimD1;
					((OpeningObject) O).dimD2 = myOpening.dimD2;
					((OpeningObject) O).dimD3 = myOpening.dimD3;
					((OpeningObject) O).dimD4 = myOpening.dimD4;
					((OpeningObject) O).dimD5 = myOpening.dimD5;
					((OpeningObject) O).dimD0 = myOpening.dimD0;

					((OpeningObject) O).widthPix = leanTo.w
							* myScale.doubleValue();
					((OpeningObject) O).heightPix = leanTo.h
							* myScale.doubleValue();

					((OpeningObject) O).noSides = myOpening.noSides = noSides.noSides;
					((OpeningObject) O).noSidesTop = myOpening.noSidesTop = noSides.noSidesTop;
					((OpeningObject) O).noSidesBot = myOpening.noSidesBot = noSides.noSidesBot;
					((OpeningObject) O).noSidesLeft = myOpening.noSidesLeft = noSides.noSidesLeft;
					((OpeningObject) O).noSidesRight = myOpening.noSidesRight = noSides.noSidesRight;

					final double b1X = Math.min(((OpeningObject) O).startingX,
							((OpeningObject) O).bX4);

					final double b2X = b1X + ((OpeningObject) O).widthPix;

					final double b3X = b1X + ((OpeningObject) O).widthPix;

					final double b4X = Math.min(((OpeningObject) O).startingX,
							((OpeningObject) O).bX4);

					final double b1XC = Math.min(
							((OpeningObject) O).startingCX,
							((OpeningObject) O).bCX4);

					final double b2XC = b2X;

					final double b3XC = b3X;

					final double b4XC = Math.min(
							((OpeningObject) O).startingCX,
							((OpeningObject) O).bCX4);

					final double b1Y = Math.min(Math.min(
							((OpeningObject) O).startingY,
							((OpeningObject) O).bY2),
							((OpeningObject) O).highestY);

					final double b2Y = Math.min(Math.min(
							((OpeningObject) O).startingY,
							((OpeningObject) O).bY2),
							((OpeningObject) O).highestY);

					double b4Y = 0;
					final double b3Y = b4Y = b1Y
							+ ((OpeningObject) O).heightPix;

					final double b1YC = b1Y;

					final double b2YC = b2Y;

					final double b3YC = b3Y;

					final double b4YC = b4Y;

					((OpeningObject) O).startingX = b1X;
					((OpeningObject) O).bX2 = b2X;
					((OpeningObject) O).bX3 = b3X;
					((OpeningObject) O).bX4 = b4X;

					((OpeningObject) O).startingCX = b1XC;
					((OpeningObject) O).bCX2 = b2XC;
					((OpeningObject) O).bCX3 = b3XC;
					((OpeningObject) O).bCX4 = b4XC;

					((OpeningObject) O).startingY = b1Y;
					((OpeningObject) O).bY2 = b2Y;
					((OpeningObject) O).bY3 = b3Y;
					((OpeningObject) O).bY4 = b4Y;

					((OpeningObject) O).startingCY = b1YC;
					((OpeningObject) O).bCY2 = b2YC;
					((OpeningObject) O).bCY3 = b3YC;
					((OpeningObject) O).bCY4 = b4YC;

					((OpeningObject) O).createSideShapes(false, true, myScale);

					((OpeningObject) O).setBAandA();

					O = cloneMyProfilesObjects(O);

					final CreateOpenings createOpening = new CreateOpenings(
							((OpeningObject) O), myDrawCanvas.myParent);

					((OpeningObject) O).radius1 = ((OpeningObject) O).top1Part.radius1;
					((OpeningObject) O).radius1A = ((OpeningObject) O).top1Part.radius1A;
					((OpeningObject) O).radius2 = ((OpeningObject) O).top1Part.radius2;
					((OpeningObject) O).radius2A = ((OpeningObject) O).top1Part.radius2A;
					((OpeningObject) O).centerPointX = ((OpeningObject) O).top1Part.x1;
					((OpeningObject) O).centerPointY = ((OpeningObject) O).top1Part.y1;
					((OpeningObject) O).centerPointX2 = ((OpeningObject) O).top1Part.x2;
					((OpeningObject) O).centerPointY2 = ((OpeningObject) O).top1Part.y2;
					((OpeningObject) O).top1Part.bkgrdStartX = ((OpeningObject) O).top1Part.x1
							- ((OpeningObject) O).radius1;

					((OpeningObject) O).top1Part.bkgrdStartY = ((OpeningObject) O).top1Part.y1
							- ((OpeningObject) O).radius1;

					((OpeningObject) O).top1Part.bkgrdStartXBA = ((OpeningObject) O).top1Part.x1
							- ((OpeningObject) O).top1Part.radius1BA;

					((OpeningObject) O).top1Part.bkgrdStartYBA = ((OpeningObject) O).top1Part.y1
							- ((OpeningObject) O).top1Part.radius1BA;

					((OpeningObject) O).top1Part.bkgrdStartXA = ((OpeningObject) O).top1Part.x1
							- ((OpeningObject) O).top1Part.radius1A;

					((OpeningObject) O).top1Part.bkgrdStartYA = ((OpeningObject) O).top1Part.y1
							- ((OpeningObject) O).top1Part.radius1A;

					((OpeningObject) O).bkgrdStartX = ((OpeningObject) O).top1Part.bkgrdStartX;
					((OpeningObject) O).bkgrdStartY = ((OpeningObject) O).top1Part.bkgrdStartY;

					((OpeningObject) O).bkgrdStartXA = ((OpeningObject) O).top1Part.bkgrdStartXA;
					((OpeningObject) O).bkgrdStartYA = ((OpeningObject) O).top1Part.bkgrdStartYA;

					((OpeningObject) O).widthPix = Math.max(
							((OpeningObject) O).bX2, ((OpeningObject) O).bX3)
							- Math.min(((OpeningObject) O).startingX,
									((OpeningObject) O).bX4);

					if (((OpeningObject) O).a_levelID > 3) {

						((OpeningObject) O).heightPix =

						((OpeningObject) O).lowestY
								- ((OpeningObject) O).highestY

								+ ((OpeningObject) O).top1Part.partDimC
								+ ((OpeningObject) O).bot1Part.partDimC;

					} else {
						((OpeningObject) O).heightPix =

						((OpeningObject) O).lowestY
								- ((OpeningObject) O).highestY;

					}

					createOpening.setTBLR(((OpeningObject) O));

					O = createOpening.getPxyALL(((OpeningObject) O));

					createOpening.setPxyCenters(((OpeningObject) O));

					O = createOpening.setPartObjectForms(((OpeningObject) O));

					((OpeningObject) O).noSides = createOpening
							.totalSides(((OpeningObject) O));

					O = createOpening.posInUse(((OpeningObject) O));

					CreateShapeMethods createShape = new CreateShapeMethods(
							((OpeningObject) O), 2, myDrawCanvas.myParent);

					O = createShape.makeSidesStraight(((OpeningObject) O));

					final Object[] returns = createOpening.makeOpening(
							((OpeningObject) O), createShape);

					O = returns[0];

					O = cloneMyProfiles(O);

					((OpeningObject) O).shapeChanged = true;

					if (shapeID == 10) {

					}
					returns[1] = null;
					returns[0] = null;
					createShape = null;

					final Collection existingFacets = new ArrayList();

					existingFacets
							.addAll(myDrawCanvas.myParent.jobItem.design.frames);

					final CreateFacets createFacet = new CreateFacets(
							(OpeningObject) O, existingFacets,
							myDrawCanvas.myParent);

					final Object[] facets = myDrawCanvas.myParent.jobItem.design.frames
							.toArray();

					myDrawCanvas.myParent.jobItem.design.frames.clear();

					for (final Object facet : facets) {
						if (((Facet) facet).a_sequenceID == ((OpeningObject) O).a_sequenceID) {

							Facet myFacet = new Facet();

							myFacet = createFacet.doFacet(false, true, false,
									false);

							myFacet.doCouplers();

							myFacet.shapeChanged = true;

							myFacet.frameShapeChanged = false;

							final Object[] myFrames = myFacet.frames.toArray();

							myFacet.frames.clear();

							for (final Object F : myFrames) {
								((Frame) F).shapeChanged = true;
								((Frame) F).isNewFrame = true;
								myFacet.frames.add(F);
							}

							myFacet.doFrames(true, true, true, true);
							myFacet.drawFrames();

							myFacet.setOriginalDimsInit(myFacet.widthPix,
									myFacet.heightPix);
							myFacet.setDimsChange(myFacet.widthPix,
									myFacet.heightPix);

							myDrawCanvas.myParent.facetUsed = myFacet;
							myDrawCanvas.myParent.jobItem.design.frames
									.add(myFacet);

						} else {
							myDrawCanvas.myParent.jobItem.design.frames
									.add(facet);
						}

					}

				}

				myDrawCanvas.myParent.jobItem.design.openings.add(O);
			}

			myDrawCanvas.myParent.jobItem.design.drawFacets();
			myDrawCanvas.myParent.jobItem.resetGraphics();

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public Object cloneMyProfiles(final Object O) {

		CreateShapeMethods createShape = new CreateShapeMethods(
				((OpeningObject) O), 2, myDrawCanvas.myParent);

		((OpeningObject) O).top1 = (Top1Object) ((OpeningObject) O).top1
				.cloneProfile(((OpeningObject) O).top1Part);
		if (((OpeningObject) O).top2Part.posInUse) {
			((OpeningObject) O).top2 = (Top2Object) ((OpeningObject) O).top2
					.cloneProfile(((OpeningObject) O).top2Part);
		} else {
			((OpeningObject) O).top2 = (Top2Object) ((OpeningObject) O).top2
					.cloneProfile(((OpeningObject) O).top1Part);

			((OpeningObject) O).top2Part = (Profiles) ((OpeningObject) O).top2Part
					.cloneProfile(((OpeningObject) O).top1Part);
			((OpeningObject) O).top2Part.lengthM = 0;
			((OpeningObject) O).top2Part.lengthI = 0;
			((OpeningObject) O).top2Part.posInUse = false;
			((OpeningObject) O).top2.posInUse = false;
		}
		((OpeningObject) O).top3 = (Top3Object) ((OpeningObject) O).top3
				.cloneProfile(((OpeningObject) O).top3Part);
		((OpeningObject) O).bot1 = (Bot1Object) ((OpeningObject) O).bot1
				.cloneProfile(((OpeningObject) O).bot1Part);
		((OpeningObject) O).bot2 = (Bot2Object) ((OpeningObject) O).bot2
				.cloneProfile(((OpeningObject) O).bot2Part);
		((OpeningObject) O).bot3 = (Bot3Object) ((OpeningObject) O).bot3
				.cloneProfile(((OpeningObject) O).bot3Part);

		((OpeningObject) O).left = (LeftObject) ((OpeningObject) O).left
				.cloneProfile(((OpeningObject) O).leftPart);
		((OpeningObject) O).right = (RightObject) ((OpeningObject) O).right
				.cloneProfile(((OpeningObject) O).rightPart);

		createShape = null;

		return O;
	}

	public Object cloneMyProfilesObjects(final Object O) {

		CreateShapeMethods createShape = new CreateShapeMethods(
				((OpeningObject) O), 2, myDrawCanvas.myParent);

		((OpeningObject) O).top1Part = (Profiles) ((OpeningObject) O).top1Part
				.cloneProfile(((OpeningObject) O).top1);

		if (((OpeningObject) O).top2Part.posInUse) {

			((OpeningObject) O).top2Part = (Profiles) ((OpeningObject) O).top2Part
					.cloneProfile(((OpeningObject) O).top2);

		} else {

			((OpeningObject) O).top2Part = (Profiles) ((OpeningObject) O).top2Part
					.cloneProfile(((OpeningObject) O).top1);
			((OpeningObject) O).top2Part.lengthM = 0;
			((OpeningObject) O).top2Part.lengthI = 0;
			((OpeningObject) O).top2Part.posInUse = false;
			((OpeningObject) O).top2.posInUse = false;
		}

		((OpeningObject) O).top3Part = (Profiles) ((OpeningObject) O).top3Part
				.cloneProfile(((OpeningObject) O).top3);
		((OpeningObject) O).bot1Part = (Profiles) ((OpeningObject) O).bot1Part
				.cloneProfile(((OpeningObject) O).bot1);
		((OpeningObject) O).bot2Part = (Profiles) ((OpeningObject) O).bot2Part
				.cloneProfile(((OpeningObject) O).bot2);
		((OpeningObject) O).bot3Part = (Profiles) ((OpeningObject) O).bot3Part
				.cloneProfile(((OpeningObject) O).bot3);
		((OpeningObject) O).leftPart = (Profiles) ((OpeningObject) O).leftPart
				.cloneProfile(((OpeningObject) O).left);
		((OpeningObject) O).rightPart = (Profiles) ((OpeningObject) O).rightPart
				.cloneProfile(((OpeningObject) O).right);

		createShape = null;

		return O;
	}

	public OpeningObject doFacetOpeningChange(final int myShape,
			OpeningObject myNewOpening) {

		myNewOpening.shapeID = myShape;
		myNewOpening.lean = leanTo.lean;
		myNewOpening.lean2 = leanTo.lean2;
		myNewOpening.lean3 = leanTo.lean3;
		myNewOpening.lean4 = leanTo.lean4;
		myNewOpening.dimA1 = leanTo.dimA1;
		myNewOpening.dimA2 = leanTo.dimA2;
		myNewOpening.dimA3 = leanTo.dimA3;
		myNewOpening.dimA4 = leanTo.dimA4;
		myNewOpening.dimA5 = leanTo.dimA5;
		myNewOpening.dimA0 = leanTo.dimA0;

		myNewOpening.dimB1 = leanTo.dimB1;
		myNewOpening.dimB2 = leanTo.dimB2;
		myNewOpening.dimB3 = leanTo.dimB3;
		myNewOpening.dimB4 = leanTo.dimB4;
		myNewOpening.dimB5 = leanTo.dimB5;
		myNewOpening.dimB0 = leanTo.dimB0;

		myNewOpening.dimC1 = leanTo.dimC1;
		myNewOpening.dimC2 = leanTo.dimC2;
		myNewOpening.dimC3 = leanTo.dimC3;
		myNewOpening.dimC4 = leanTo.dimC4;
		myNewOpening.dimC5 = leanTo.dimC5;
		myNewOpening.dimC0 = leanTo.dimC0;

		myNewOpening.dimD1 = leanTo.dimD1;
		myNewOpening.dimD2 = leanTo.dimD2;
		myNewOpening.dimD3 = leanTo.dimD3;
		myNewOpening.dimD4 = leanTo.dimD4;
		myNewOpening.dimD5 = leanTo.dimD5;
		myNewOpening.dimD0 = leanTo.dimD0;

		final double b1X = Math.min(myNewOpening.startingX, myNewOpening.bX4);

		final double b2X = Math.max(myNewOpening.bX2, myNewOpening.bX3);

		final double b3X = Math.max(myNewOpening.bX3, myNewOpening.bX2);

		final double b4X = Math.min(myNewOpening.startingX, myNewOpening.bX4);

		final double b1XC = Math
				.min(myNewOpening.startingCX, myNewOpening.bCX4);

		final double b2XC = Math.max(myNewOpening.bCX2, myNewOpening.bCX3);

		final double b3XC = Math.max(myNewOpening.bCX3, myNewOpening.bCX2);

		final double b4XC = Math
				.min(myNewOpening.startingCX, myNewOpening.bCX4);

		final double b1Y = Math.min(
				Math.min(myNewOpening.startingY, myNewOpening.bY2),
				myNewOpening.highestY);

		final double b2Y = Math.min(
				Math.min(myNewOpening.startingY, myNewOpening.bY2),
				myNewOpening.highestY);

		final double b3Y = Math.max(
				Math.min(myNewOpening.bY3, myNewOpening.bY4),
				myNewOpening.lowestY);

		final double b4Y = Math.max(
				Math.min(myNewOpening.bY3, myNewOpening.bY4),
				myNewOpening.lowestY);

		final double b1YC = b1Y;

		final double b2YC = b2Y;

		final double b3YC = b3Y;

		final double b4YC = b4Y;

		myNewOpening.startingX = b1X;
		myNewOpening.bX2 = b2X;
		myNewOpening.bX3 = b3X;
		myNewOpening.bX4 = b4X;

		myNewOpening.startingCX = b1XC;
		myNewOpening.bCX2 = b2XC;
		myNewOpening.bCX3 = b3XC;
		myNewOpening.bCX4 = b4XC;

		myNewOpening.startingY = b1Y;
		myNewOpening.bY2 = b2Y;
		myNewOpening.bY3 = b3Y;
		myNewOpening.bY4 = b4Y;

		myNewOpening.startingCY = b1YC;
		myNewOpening.bCY2 = b2YC;
		myNewOpening.bCY3 = b3YC;
		myNewOpening.bCY4 = b4YC;

		myNewOpening.createSideShapes(false, true, myScale);

		myNewOpening.setBAandA();

		myNewOpening = (OpeningObject) cloneMyProfilesObjects(myNewOpening);

		final CreateOpenings createOpening = new CreateOpenings(myNewOpening,
				myDrawCanvas.myParent);

		myNewOpening.radius1 = myNewOpening.top1Part.radius1;
		myNewOpening.radius1A = myNewOpening.top1Part.radius1A;
		myNewOpening.radius2 = myNewOpening.top1Part.radius2;
		myNewOpening.radius2A = myNewOpening.top1Part.radius2A;
		myNewOpening.centerPointX = myNewOpening.top1Part.x1;
		myNewOpening.centerPointY = myNewOpening.top1.y1;
		myNewOpening.centerPointX2 = myNewOpening.top1Part.x2;
		myNewOpening.centerPointY2 = myNewOpening.top1Part.y2;

		// myNewOpening.top1Part.bkgrdStartX =
		// myNewOpening.top1Part.x1
		// - myNewOpening.radius1;
		//
		// myNewOpening.top1Part.bkgrdStartY =
		// myNewOpening.top1Part.y1
		// - myNewOpening.radius1;
		//
		// myNewOpening.top1Part.bkgrdStartXBA =
		// myNewOpening.top1Part.x1
		// - myNewOpening.top1Part.radius1BA;
		//
		// myNewOpening.top1Part.bkgrdStartYBA =
		// myNewOpening.top1Part.y1
		// - myNewOpening.top1Part.radius1BA;
		//
		// myNewOpening.top1Part.bkgrdStartXA =
		// myNewOpening.top1Part.x1
		// - myNewOpening.top1Part.radius1A;
		//
		// myNewOpening.top1Part.bkgrdStartYA =
		// myNewOpening.top1Part.y1
		// - myNewOpening.top1Part.radius1A;

		myNewOpening.bkgrdStartX = myNewOpening.top1Part.bkgrdStartX;
		myNewOpening.bkgrdStartY = myNewOpening.top1Part.bkgrdStartY;

		myNewOpening.bkgrdStartXA = myNewOpening.top1Part.bkgrdStartXA;
		myNewOpening.bkgrdStartYA = myNewOpening.top1Part.bkgrdStartYA;

		myNewOpening.widthPix = Math.max(myNewOpening.bX2, myNewOpening.bX3)
				- Math.min(myNewOpening.startingX, myNewOpening.bX4);

		if (myNewOpening.a_levelID > 3) {

			myNewOpening.heightPix =

			myNewOpening.lowestY - myNewOpening.highestY

			+ myNewOpening.top1Part.partDimC + myNewOpening.bot1Part.partDimC;

		} else {

			myNewOpening.heightPix =

			myNewOpening.lowestY - myNewOpening.highestY;

		}

		createOpening.setTBLR(myNewOpening);

		myNewOpening = createOpening.getPxyALL(myNewOpening);

		createOpening.setPxyCenters(myNewOpening);

		myNewOpening = createOpening.setPartObjectForms(myNewOpening);

		myNewOpening.noSides = createOpening.totalSides(myNewOpening);

		myNewOpening = createOpening.posInUse(myNewOpening);

		CreateShapeMethods createShape = new CreateShapeMethods(myNewOpening,
				2, myDrawCanvas.myParent);
		myNewOpening = (OpeningObject) createShape
				.makeSidesStraight(myNewOpening);

		final Object[] returns = createOpening.makeOpening(myNewOpening,
				createShape);
		myNewOpening = (OpeningObject) returns[0];

		myNewOpening.top1Part = (Profiles) myNewOpening.top1Part
				.cloneProfile(myNewOpening.top1);

		if (myNewOpening.top2Part.posInUse) {
			myNewOpening.top2Part = (Profiles) myNewOpening.top2Part
					.cloneProfile(myNewOpening.top2);

		} else {
			myNewOpening.top2Part = (Profiles) myNewOpening.top2Part
					.cloneProfile(myNewOpening.top1);

			myNewOpening.top2Part.posInUse = false;
			myNewOpening.top2.posInUse = false;
		}

		myNewOpening.top3Part = (Profiles) myNewOpening.top3Part
				.cloneProfile(myNewOpening.top3);
		myNewOpening.bot1Part = (Profiles) myNewOpening.bot1Part
				.cloneProfile(myNewOpening.bot1);
		myNewOpening.bot2Part = (Profiles) myNewOpening.bot2Part
				.cloneProfile(myNewOpening.bot2);
		myNewOpening.bot3Part = (Profiles) myNewOpening.bot3Part
				.cloneProfile(myNewOpening.bot3);
		myNewOpening.leftPart = (Profiles) myNewOpening.leftPart
				.cloneProfile(myNewOpening.left);
		myNewOpening.rightPart = (Profiles) myNewOpening.rightPart
				.cloneProfile(myNewOpening.right);

		// myNewOpening.top1 =
		// ((CreateShapeMethods) returns[1]).myTop1Clone(myNewOpening.top1,
		// myNewOpening.top1Part);
		// if (myNewOpening.top2Part.posInUse) {
		// myNewOpening.top2 =
		// ((CreateShapeMethods) returns[1]).myTop2Clone(myNewOpening.top2,
		// myNewOpening.top2Part);
		// } else {
		// myNewOpening.top2 =
		// ((CreateShapeMethods) returns[1]).myTop2Clone(myNewOpening.top2,
		// myNewOpening.top1Part);
		// myNewOpening.top2Part =
		// myNewOpening.myTop1Clone(myNewOpening.top2Part,
		// myNewOpening.top1Part);
		// myNewOpening.top2Part.posInUse = false;
		// myNewOpening.top2.posInUse = false;
		// }
		// myNewOpening.top3 =
		// ((CreateShapeMethods) returns[1]).myTop3Clone(myNewOpening.top3,
		// myNewOpening.top3Part);
		// myNewOpening.bot1 =
		// ((CreateShapeMethods) returns[1]).myBot1Clone(myNewOpening.bot1,
		// myNewOpening.bot1Part);
		// myNewOpening.bot2 =
		// ((CreateShapeMethods) returns[1]).myBot2Clone(myNewOpening.bot2,
		// myNewOpening.bot2Part);
		// myNewOpening.bot3 =
		// ((CreateShapeMethods) returns[1]).myBot3Clone(myNewOpening.bot3,
		// myNewOpening.bot3Part);
		//
		// myNewOpening.left =
		// ((CreateShapeMethods) returns[1]).myLeftClone(myNewOpening.left,
		// myNewOpening.leftPart);
		// myNewOpening.right =
		// ((CreateShapeMethods) returns[1]).myRightClone(myNewOpening.right,
		// myNewOpening.rightPart);
		//
		//

		myNewOpening.shapeChanged = true;

		if (shapeID == 10) {

		}
		returns[1] = null;
		returns[0] = null;
		createShape = null;

		return myNewOpening;
	}

}

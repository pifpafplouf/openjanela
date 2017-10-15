/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Presentation;

import Model.OpeningObject;
import Model.ShapeObject;
import util.XYConstraints;
import util.XYLayout;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class SashOrielDialog { // implements Runnable {

	public JButton jButtonClose = new JButton();

	public JButton jButtonSet = new JButton();

	public JPanel changeShapePanel = new JPanel();

	public JPanel dimTypePanel = new JPanel();

	public JPanel westPanel = new JPanel();

	public JPanel centerPanel = new JPanel();

	public JPanel leftPanel = new JPanel();

	public JPanel drawingPanel = new JPanel();

	public JPanel buttonPanel = new JPanel();

	public JPanel buttons = new JPanel();

	public JDialog ShapeDimDialog = new JDialog();

	public JButton save = new JButton();

	public JButton cancel = new JButton();

	SashSelectorPanel sashPanel = null;

	public JCheckBox aDim = new JCheckBox("Dim A:");

	public JCheckBox bDim = new JCheckBox("Dim B:");

	public JCheckBox cDim = new JCheckBox("Dim C:");

	// public JCheckBox dDim =
	// new JCheckBox(
	// "Dim D");

	JLabel dima = new JLabel("%");

	JLabel dimb = new JLabel("%");

	JLabel dimc = new JLabel("%");

	ButtonGroup topLeanGroup = new ButtonGroup();

	public JTextField dimA = new JTextField("0.000000");

	public JTextField dimB = new JTextField("0.000000");

	public JTextField dimC = new JTextField("0.000000");

	public JTextField dimAp = new JTextField("0.00");

	public JTextField dimBp = new JTextField("0.00");

	public JTextField dimCp = new JTextField("0.00");

	public JLabel noL = new JLabel();

	public JTextField noLeafs = new JTextField();
	
	public JLabel noTL = new JLabel("No. of Tracks");

	public JTextField noTT = new JTextField();
	

	public JLabel noSL = new JLabel();

	public JTextField noSLText = new JTextField();

	public JRadioButton noSwing0 = new JRadioButton("No Projected Sashes");

	public JRadioButton noSwing1L = new JRadioButton("1 Left Swing Sash");

	public JRadioButton noSwing1R = new JRadioButton("1 Right Swing Sash");

	public JRadioButton noSwing1L1R = new JRadioButton("1 L + 1 R Swing Sashes");

	public JLabel posS = new JLabel("Position of Swinging Leafs:");

	public JRadioButton posSwingL = new JRadioButton("Left Most");

	public JRadioButton posSwingR = new JRadioButton("Right Most");

	public JRadioButton posSwingM = new JRadioButton("Specify:");

	public JTextField PosSwing = new JTextField("0");

	// public JTextField dimD = new JTextField("0.000000");

	public boolean aChanged = false;

	public boolean bChanged = false;

	public boolean cChanged = false;

	double split = 0;

	int noOfLeafs = 0;

	int notracks = 0;

	int[] sashOnTrack;

	int opens = 0;;

	boolean glazedOut = false;

	boolean[] sashGlazedOut;

	int[] paneType;

	int[] interLocks;

	boolean isOriel = false;

	public JRadioButton percent = new JRadioButton("%");

	public JRadioButton allDims = new JRadioButton("dim");

	ButtonGroup dimGroup = new ButtonGroup();

	ButtonGroup swingLeafGroup = new ButtonGroup();

	ButtonGroup swingPos = new ButtonGroup();

	public ImageIcon sashIcon;

	JLabel myImage = new JLabel();

	double dimUsed = 0;

	double dimAInput = 0;

	double dimBInput = 0;

	double dimCInput = 0;

	OpeningObject selectedOpening;

	ShapeObject mySelectedFrame;

	public double extendExtra = 0;
	double percentA = 0;
	double percentC = 0;
	double percentB = 0;

	ItemFrame itemFrame;

	public void run(final SashSelectorPanel sashpanel,
			final OpeningObject selectedopening,
			final ShapeObject myselectedframe, final int whichPos,
			final double percenta, final double percentb,
			final double percentc, ItemFrame itemF) {

		percentA = percenta;
		percentC = percentb;
		percentB = percentc;
		itemFrame = itemF;

		setValues(sashpanel, selectedopening, myselectedframe, whichPos);

		initialize();

	}

	public void setValues(final SashSelectorPanel sashpanel,
			final OpeningObject selectedopening,
			final ShapeObject myselectedframe, final int whichPos) {

		// TODO Auto-generated constructor stub

		sashPanel = sashpanel;
		mySelectedFrame = myselectedframe;
		selectedOpening = selectedopening;

		if (sashPanel.useW) {
			if (itemFrame.currentUOM == 1) {
				dimUsed = selectedOpening.widthMN / 100;
			} else {
				dimUsed = selectedOpening.widthIN / 64;
			}
		} else {
			if (itemFrame.currentUOM == 1) {
				dimUsed = selectedOpening.heightMN / 100;
			} else {
				dimUsed = selectedOpening.heightIN / 64;
			}
		}

		// if (sashPanel.openingClass >= 311 && sashPanel.openingClass <= 312) {
		// dimUsed = selectedOpening.widthPix
		// * sashPanel.myParent.scale.doubleValue();
		// }

		split = sashPanel.split;

		if (whichPos == 1 && selectedOpening.sashObjectIn != null) {
			if (selectedOpening.sashObjectIn.split != 0) {
				split = selectedOpening.sashObjectIn.split;
			}
		} else if (whichPos == 2 && selectedOpening.sashObjectMid != null) {
			if (selectedOpening.sashObjectMid.split != 0) {
				split = selectedOpening.sashObjectMid.split;
			}
		} else if (whichPos == 3 && selectedOpening.sashObjectMid != null) {
			if (selectedOpening.sashObjectOut.split != 0) {
				split = selectedOpening.sashObjectOut.split;

			}
		}

		noOfLeafs = sashPanel.noOfLeafs;
		notracks = sashPanel.notracks;
		sashOnTrack = sashPanel.sashOnTrack;
		opens = sashPanel.opens;
		glazedOut = sashPanel.glazedOut;
		sashGlazedOut = sashPanel.sashGlazedOut;
		paneType = sashPanel.paneType;
		interLocks = sashPanel.interlockTypes;
		isOriel = sashPanel.isOriel;

	}

	// public void run() {
	// this.getIcons();
	// initialize();
	// }

	public void initialize() {

		// this.getIcons();
		// initialize();
		topLeanGroup.add(aDim);
		topLeanGroup.add(bDim);
		topLeanGroup.add(cDim);

		dimGroup.add(percent);
		dimGroup.add(allDims);
		// allDims.setEnabled(false);
		percent.setSelected(true);
		ShapeDimDialog = new JDialog(sashPanel.myParent.myParent, "Dim : A B C");

		final Image myimage = ((ImageIcon) sashPanel.myParent.iconFiles
				.get("dimensioning")).getImage();

		ShapeDimDialog.setIconImage(myimage);

		ShapeDimDialog.setModal(true);
		changeShapePanel.setLayout(new BorderLayout());

		leftPanel.setPreferredSize(new Dimension(300, 22));

		leftPanel.setLayout(new BorderLayout());

		centerPanel.setLayout(new BorderLayout());
		centerPanel.setPreferredSize(new Dimension(250, 215));

		centerPanel.setBorder(BorderFactory.createEtchedBorder());

		leftPanel.setBorder(BorderFactory.createEtchedBorder());
		dimTypePanel.setBorder(BorderFactory.createEtchedBorder());

		dimTypePanel.setPreferredSize(new Dimension(100, 24));

		dimTypePanel.setLayout(new XYLayout());

		dimTypePanel.add(percent, new XYConstraints(72, 1, 50, 22));
		dimTypePanel.add(allDims, new XYConstraints(154, 1, 50, 22));

		percent.setSelected(true);

		westPanel.setLayout(new XYLayout());

		westPanel.add(aDim, new XYConstraints(1, 2, 70, 22));
		westPanel.add(bDim, new XYConstraints(1, 27, 70, 22));
		westPanel.add(cDim, new XYConstraints(1, 51, 70, 22));

		aDim.setSelected(true);

		dimA.setEnabled(true);
		dimB.setEnabled(false);
		dimC.setEnabled(false);
		dimAp.setEnabled(true);
		dimBp.setEnabled(false);
		dimCp.setEnabled(false);

		westPanel.add(dimAp, new XYConstraints(72, 2, 80, 22));

		westPanel.add(dimBp, new XYConstraints(72, 27, 80, 22));

		westPanel.add(dimCp, new XYConstraints(72, 51, 80, 22));

		westPanel.add(dimA, new XYConstraints(154, 2, 80, 22));

		westPanel.add(dimB, new XYConstraints(154, 27, 80, 22));

		westPanel.add(dimC, new XYConstraints(154, 51, 80, 22));

		dimA.setEnabled(false);

		dimB.setEnabled(false);

		dimC.setEnabled(false);

		dimAp.setEnabled(true);

		dimBp.setEnabled(true);

		dimCp.setEnabled(true);

		/**********************************
		 * 
		 * Build N track Slider Left or right
		 * Need to ask only for the number of tracks
		 * 
		 **********************************/
		if (sashPanel.openingClass == 291 || sashPanel.openingClass == 292
				|| sashPanel.openingClass == 791
				|| sashPanel.openingClass == 792) {

			dimTypePanel.removeAll();

			westPanel.removeAll();

			noLeafs.setText("4");

			noL.setIcon((ImageIcon) sashPanel.myParent.iconFiles.get("noLeafs"));

			noL.setToolTipText("No of Tracks");

			westPanel.add(noL, new XYConstraints(1, 1, 80, 40));

			westPanel.add(noLeafs, new XYConstraints(82, 10, 50, 22));

		} 
		
		/**********************************
		 * 
		 * Build N track Slider Center
		 * Need to ask only for total tracks
		 * AND  where the First center 
		 * (from left to right)  is!
		 * the number of tracks
		 * 
		 * Just like Folding doors
		 **********************************/
		else if (sashPanel.openingClass == 293
				|| sashPanel.openingClass == 793) {

			dimTypePanel.removeAll();

			westPanel.removeAll();

			noLeafs.setText("4");

			noL.setIcon((ImageIcon) sashPanel.myParent.iconFiles.get("noLeafs"));

			noL.setToolTipText("No of Leafs");
			noLeafs.setToolTipText("No of Leafs");
			
			noTL.setToolTipText("No of Tracks");
			noTT.setToolTipText("No of Tracks");
			
			noSLText.setText("2");
			noSL.setIcon((ImageIcon) sashPanel.myParent.iconFiles
					.get("noLeafsBefore"));

			noSL.setToolTipText("MeetRail after Sash #");
			noSLText.setToolTipText("MeetRail after Sash #");
			
			if (sashPanel.openingClass == 303) {
				noSL.setToolTipText("Opening Sash #:");
			}

			westPanel.add(noL, new XYConstraints(1, 1, 80, 40));

			westPanel.add(noLeafs, new XYConstraints(82, 10, 50, 22));

			westPanel.add(noTL, new XYConstraints(1, 45, 80, 22));

			westPanel.add(noTT, new XYConstraints(82, 45, 50, 22));
			
			westPanel.add(noSL, new XYConstraints(1, 69, 80, 40));

			westPanel.add(noSLText, new XYConstraints(82, 79, 50, 22));

		}
		/**********************************
		 * 
		 * Build 1 track Folding/Bi Fold
		 * Need to ask only for total of leafs
		 * AND  where the First center 
		 * (from left to right)  is!
		 * the number of tracks
		 * 
		 **********************************/
		else if (sashPanel.openingClass == 301 || sashPanel.openingClass == 302
				|| sashPanel.openingClass == 303
				|| sashPanel.openingClass == 801
				|| sashPanel.openingClass == 802
				|| sashPanel.openingClass == 803) {

			dimTypePanel.removeAll();

			westPanel.removeAll();

			noLeafs.setText("4");

			noL.setIcon((ImageIcon) sashPanel.myParent.iconFiles.get("noLeafs"));

			noL.setToolTipText("No of Openings");
			noLeafs.setToolTipText("No of Openings");
			
			noSLText.setText("2");
			noSL.setIcon((ImageIcon) sashPanel.myParent.iconFiles
					.get("noLeafsBefore"));

			noSL.setToolTipText("MeetRail after Sash #");
			noSLText.setToolTipText("MeetRail after Sash #");
			
			
			if (sashPanel.openingClass == 303) {
				noSL.setToolTipText("Opening Sash #:");
			}

			westPanel.add(noL, new XYConstraints(1, 1, 80, 40));

			westPanel.add(noLeafs, new XYConstraints(82, 10, 50, 22));

			westPanel.add(noSL, new XYConstraints(1, 45, 80, 40));

			westPanel.add(noSLText, new XYConstraints(82, 55, 50, 22));

		} else if (sashPanel.openingClass > 303
				&& sashPanel.openingClass <= 313) {

			dimTypePanel.removeAll();

			westPanel.removeAll();

			noL.setText("");

			noL.setIcon((ImageIcon) sashPanel.myParent.iconFiles.get("noLeafs"));
			noL.setToolTipText("No of Openings");

			westPanel.add(noL, new XYConstraints(1, 1, 80, 40));

			westPanel.add(noLeafs, new XYConstraints(82, 1, 50, 22));

		}
		save.setIcon((ImageIcon) sashPanel.myParent.iconFiles.get("set"));

		save.setPreferredSize(new Dimension(40, 22));
		buttonPanel.setLayout(new BorderLayout());
		buttonPanel.setPreferredSize(new Dimension(40, 22));
		buttonPanel.add(save, BorderLayout.EAST);

		if (sashPanel.openingClass < 303 || sashPanel.openingClass > 314) {
			myImage.setIcon((ImageIcon) sashPanel.myParent.iconFiles
					.get("abcDim"));

		}

		// SH
		if (sashPanel.openingClass == 231 || sashPanel.openingClass == 531
				|| sashPanel.openingClass == 232
				|| sashPanel.openingClass == 532) {
			myImage.setIcon((ImageIcon) sashPanel.myParent.iconFiles
					.get("abcSH"));
		}
		// DH
		if (sashPanel.openingClass == 232) {
			myImage.setIcon((ImageIcon) sashPanel.myParent.iconFiles
					.get("abcDH"));
		}
		// 3ls
		if (sashPanel.openingClass == 213 || sashPanel.openingClass == 223
				|| sashPanel.openingClass == 293) {
			myImage.setIcon((ImageIcon) sashPanel.myParent.iconFiles
					.get("abc3LS"));
		}
		// 4ls
		if (sashPanel.openingClass == 214 || sashPanel.openingClass == 224
				|| sashPanel.openingClass == 293) {
			myImage.setIcon((ImageIcon) sashPanel.myParent.iconFiles
					.get("abc4LS"));
		}
		// SSL
		if (sashPanel.openingClass == 212 || sashPanel.openingClass == 291) {
			myImage.setIcon((ImageIcon) sashPanel.myParent.iconFiles
					.get("abcSSL"));
		}
		// SSR
		if (sashPanel.openingClass == 211 || sashPanel.openingClass == 292) {
			myImage.setIcon((ImageIcon) sashPanel.myParent.iconFiles
					.get("abcSSR"));
		}
		// CLS
		if (sashPanel.openingClass == 215 || sashPanel.openingClass == 216
				|| sashPanel.openingClass == 217) {
			myImage.setIcon((ImageIcon) sashPanel.myParent.iconFiles
					.get("abcCLS"));
		}
		// DLS
		if (sashPanel.openingClass == 221 || sashPanel.openingClass == 222) {
			myImage.setIcon((ImageIcon) sashPanel.myParent.iconFiles
					.get("abcDLS"));
		}

		// 2LP
		if (sashPanel.openingClass == 243 || sashPanel.openingClass == 244
				|| sashPanel.openingClass == 271
				|| sashPanel.openingClass == 272
				|| sashPanel.openingClass == 273
				|| sashPanel.openingClass == 276
				|| sashPanel.openingClass == 277
				|| sashPanel.openingClass == 278) {
			myImage.setIcon((ImageIcon) sashPanel.myParent.iconFiles
					.get("abc2LP"));
		}

		drawingPanel.add(myImage);

		leftPanel.add(dimTypePanel, BorderLayout.NORTH);
		centerPanel.add(drawingPanel, BorderLayout.CENTER);

		leftPanel.add(westPanel, BorderLayout.CENTER);
		leftPanel.add(buttonPanel, BorderLayout.SOUTH);
		changeShapePanel.add(leftPanel, BorderLayout.WEST);

		textActions();
		percent.doClick();

		changeShapePanel.add(centerPanel, BorderLayout.CENTER);

		ShapeDimDialog.getContentPane().add(changeShapePanel, null);

		ShapeDimDialog.setLocation(
				(sashPanel.myParent.getWidth() - 500) / 2 - 50,
				(sashPanel.myParent.getHeight() - 200) / 2 - 100);

		ShapeDimDialog.getContentPane().setSize(500, 500);
		ShapeDimDialog.setResizable(false);
		ShapeDimDialog.pack();
		ShapeDimDialog.setVisible(true);
		ShapeDimDialog.setAlwaysOnTop(true);
		ShapeDimDialog.setModal(true);
		ShapeDimDialog.setModalityType(Dialog.ModalityType.TOOLKIT_MODAL);

	}

	public void textActions() {

		aDim.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				check_actionPerformed(e);
			}

		});
		bDim.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				check_actionPerformed(e);
			}

		});
		cDim.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				check_actionPerformed(e);
			}

		});

		dimA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				text_actionPerformed(e);
			}

		});

		dimB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				text_actionPerformed(e);
			}

		});

		dimC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				text_actionPerformed(e);
			}

		});

		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				jButtonSet_actionPerformed(e);
			}
		});

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				jButtonClose_actionPerformed(e);
			}
		});

		percent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				setTexts();
			}

		});

		allDims.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				setTexts();
			}

		});

		noSwing0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				posS.setVisible(false);
				posSwingL.setVisible(false);
				posSwingR.setVisible(false);
				posSwingM.setVisible(false);
				PosSwing.setVisible(false);
			}

		});

		noSwing1L.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				posS.setVisible(true);
				posSwingL.setVisible(true);
				posSwingR.setVisible(true);
				posSwingM.setVisible(true);
				// PosSwing.setVisible(true);
			}

		});
		noSwing1R.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				posS.setVisible(true);
				posSwingL.setVisible(true);
				posSwingR.setVisible(true);
				posSwingM.setVisible(true);
				// PosSwing.setVisible(true);
			}

		});
		noSwing1L1R.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				posS.setVisible(true);
				posSwingL.setVisible(true);
				posSwingR.setVisible(true);
				posSwingM.setVisible(true);
				// PosSwing.setVisible(true);
			}

		});

		posSwingM.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				PosSwing.setVisible(true);
			}

		});

	}

	public void setTopLeanGroup() {

	}

	public void setTexts() {

		if (percent.isSelected()) {

			dimA.setEnabled(false);

			dimB.setEnabled(false);

			dimC.setEnabled(false);

			dimA.setText(0.00 + "");
			dimB.setText(0.00 + "");
			dimC.setText(0.00 + "");

			if (aDim.isSelected()) {
				dimAp.setEnabled(true);
				dimBp.setEnabled(false);
				dimCp.setEnabled(false);
			} else if (bDim.isSelected()) {
				dimAp.setEnabled(false);
				dimBp.setEnabled(true);
				dimCp.setEnabled(false);
			} else {
				dimAp.setEnabled(false);
				dimBp.setEnabled(false);
				dimCp.setEnabled(true);
			}

			westPanel.validate();
			westPanel.repaint();

			dima.setText("%");
			dimb.setText("%");
			dimc.setText("%");
		} else {

			dimAp.setEnabled(false);

			dimBp.setEnabled(false);

			dimCp.setEnabled(false);

			dimAp.setText(0.00 + "");
			dimBp.setText(0.00 + "");
			dimCp.setText(0.00 + "");

			if (aDim.isSelected()) {
				dimA.setEnabled(true);
				dimB.setEnabled(false);
				dimC.setEnabled(false);
			} else if (bDim.isSelected()) {
				dimA.setEnabled(false);
				dimB.setEnabled(true);
				dimC.setEnabled(false);
			} else {
				dimA.setEnabled(false);
				dimB.setEnabled(false);
				dimC.setEnabled(true);
			}

			westPanel.validate();
			westPanel.repaint();

			if (itemFrame.currentUOM == 1) {
				dima.setText("mm");
				dimb.setText("mm");
				dimc.setText("mm");
			} else if (itemFrame.currentUOM >= 2) {
				dima.setText("Imp .xx");
				dimb.setText("Imp .xx");
				dimc.setText("Imp .xx");
			}

		}

		westPanel.validate();
		westPanel.repaint();

		cDim.setEnabled(false);
		cDim.setVisible(false);

		dimc.setVisible(false);

		dimC.setEnabled(false);
		dimCp.setEnabled(false);

		dimC.setVisible(false);
		dimCp.setVisible(false);

		if (sashPanel.openingClass == 11 || sashPanel.openingClass == 12
				|| sashPanel.openingClass == 21 || sashPanel.openingClass == 22
				|| sashPanel.openingClass == 43 || sashPanel.openingClass == 44
				|| sashPanel.openingClass == 71 || sashPanel.openingClass == 72
				|| sashPanel.openingClass == 73 || sashPanel.openingClass == 76
				|| sashPanel.openingClass == 77 || sashPanel.openingClass == 78
				|| sashPanel.openingClass == 211
				|| sashPanel.openingClass == 212
				|| sashPanel.openingClass == 221
				|| sashPanel.openingClass == 222
				|| sashPanel.openingClass == 231
				|| sashPanel.openingClass == 243
				|| sashPanel.openingClass == 244
				|| sashPanel.openingClass == 271
				|| sashPanel.openingClass == 272
				|| sashPanel.openingClass == 273
				|| sashPanel.openingClass == 276
				|| sashPanel.openingClass == 277
				|| sashPanel.openingClass == 278) {
			if (percent.isSelected()) {

				dimAp.setText(split + "");
				dimBp.setText(100 - split + "");

			} else {
				if (this.itemFrame.currentUOM == 1) {
					dimA.setText(new BigDecimal(dimUsed)
							.multiply(new BigDecimal(split / 100))
							.setScale(2, BigDecimal.ROUND_HALF_UP)
							.doubleValue()
							+ "");
					dimB.setText(new BigDecimal(dimUsed)
							.multiply(new BigDecimal((100 - split) / 100))
							.setScale(2, BigDecimal.ROUND_HALF_UP)
							.doubleValue()
							+ "");

				} else {
					dimA.setText(new BigDecimal(dimUsed)
							.multiply(new BigDecimal(split / 100))
							.setScale(6, BigDecimal.ROUND_HALF_UP)
							.doubleValue()
							+ "");
					dimB.setText(new BigDecimal(dimUsed)
							.multiply(new BigDecimal((100 - split) / 100))
							.setScale(6, BigDecimal.ROUND_HALF_UP)
							.doubleValue()
							+ "");

				}

			}

		} else if (sashPanel.openingClass == 13 || sashPanel.openingClass == 14
				|| sashPanel.openingClass == 15 || sashPanel.openingClass == 16
				|| sashPanel.openingClass == 17 || sashPanel.openingClass == 23
				|| sashPanel.openingClass == 24 || sashPanel.openingClass == 25
				|| sashPanel.openingClass == 26 || sashPanel.openingClass == 27
				|| sashPanel.openingClass == 213
				|| sashPanel.openingClass == 214
				|| sashPanel.openingClass == 215
				|| sashPanel.openingClass == 216
				|| sashPanel.openingClass == 217
				|| sashPanel.openingClass == 223
				|| sashPanel.openingClass == 224
				|| sashPanel.openingClass == 225
				|| sashPanel.openingClass == 226
				|| sashPanel.openingClass == 227

		) {

			cDim.setEnabled(true);

			cDim.setVisible(true);

			dimc.setVisible(true);

			if (percent.isSelected()) {
				dimCp.setEnabled(true);
				dimCp.setVisible(true);
				dimAp.setText(split + "");
				dimBp.setText(100 - 2 * split + "");
				dimCp.setText(split + "");

			} else {
				dimC.setEnabled(true);
				dimC.setVisible(true);
				if (this.itemFrame.currentUOM == 1) {
					dimA.setText(new BigDecimal(dimUsed)
							.multiply(new BigDecimal(split / 100))
							.setScale(2, BigDecimal.ROUND_HALF_UP)
							.doubleValue()
							+ "");
					dimB.setText(new BigDecimal(dimUsed)
							.multiply(new BigDecimal((100 - split) / 100))
							.setScale(2, BigDecimal.ROUND_HALF_UP)
							.doubleValue()
							+ "");
					dimC.setText(new BigDecimal(dimUsed)
							.multiply(new BigDecimal(split / 100))
							.setScale(2, BigDecimal.ROUND_HALF_UP)
							.doubleValue()
							+ "");

				} else {
					dimA.setText(new BigDecimal(dimUsed)
							.multiply(new BigDecimal(split / 100))
							.setScale(6, BigDecimal.ROUND_HALF_UP)
							.doubleValue()
							+ "");
					dimB.setText(new BigDecimal(dimUsed)
							.multiply(new BigDecimal((100 - split) / 100))
							.setScale(6, BigDecimal.ROUND_HALF_UP)
							.doubleValue()
							+ "");
					dimC.setText(new BigDecimal(dimUsed)
							.multiply(new BigDecimal(split / 100))
							.setScale(6, BigDecimal.ROUND_HALF_UP)
							.doubleValue()
							+ "");

				}

			}
		} else if (sashPanel.openingClass == 301
				|| sashPanel.openingClass == 302
				|| sashPanel.openingClass == 303) {

		}

		// if (this.sashPanel.percentA != 0) {
		// dimA.setText(sashPanel.percentA + "");
		// dimB.setText(sashPanel.percentB + "");
		// dimC.setText(sashPanel.percentC + "");
		// }

		westPanel.validate();
		westPanel.repaint();

		leftPanel.validate();
		leftPanel.repaint();

	}

	void check_actionPerformed(final ActionEvent e) {

		if (e.getSource() == aDim) {
			if (!percent.isSelected()) {
				dimA.setEnabled(true);
				dimB.setEnabled(false);
				dimC.setEnabled(false);
			} else {
				dimAp.setEnabled(true);
				dimBp.setEnabled(false);
				dimCp.setEnabled(false);
			}

		}
		if (e.getSource() == bDim) {
			if (!percent.isSelected()) {
				dimA.setEnabled(false);
				dimB.setEnabled(true);
				dimC.setEnabled(false);
			} else {
				dimAp.setEnabled(false);
				dimBp.setEnabled(true);
				dimCp.setEnabled(false);
			}
		}
		if (e.getSource() == cDim) {
			if (!percent.isSelected()) {
				dimA.setEnabled(false);
				dimB.setEnabled(false);
				dimC.setEnabled(true);
			} else {
				dimAp.setEnabled(false);
				dimBp.setEnabled(false);
				dimCp.setEnabled(true);
			}
		}

	}

	void text_actionPerformed(final ActionEvent e) {

		int from = 0;
		if (e.getSource() == dimA) {
			from = 0;
		} else if (e.getSource() == dimB) {
			from = 1;
		} else if (e.getSource() == dimC) {
			from = 2;
		} else if (e.getSource() == dimAp) {
			from = 3;
		} else if (e.getSource() == dimBp) {
			from = 4;
		} else if (e.getSource() == dimCp) {
			from = 5;
		}

		doTextAction(from);
	}

	public void doTextAction(final int from) {

		getInputText();

		double baseW = 100;

		if (allDims.isSelected()) {

			baseW = dimUsed;

		}

		if (from == 0 && (!dimC.isVisible())) {

			dimB.setText(baseW - dimAInput + "");
			aChanged = true;
			sashPanel.myParent.lastChangedLeaf = 0;

		} else if (from == 0 && (dimC.isVisible())) {

			if (sashPanel.myParent.lastChangedLeaf == 1) {
				dimC.setText(baseW - dimAInput - dimBInput + "");

			}
			if (sashPanel.myParent.lastChangedLeaf == 2) {
				dimB.setText(baseW - dimAInput - dimCInput + "");

			} else {
				dimC.setText(dimAInput + "");
				dimB.setText(baseW - dimAInput - dimAInput + "");
			}

			sashPanel.myParent.lastChangedLeaf = 0;
			aChanged = true;
		}
		if (from == 1 && (!dimC.isVisible())) {
			dimA.setText(baseW - dimBInput + "");
			sashPanel.myParent.lastChangedLeaf = 1;
			bChanged = true;
		} else if (from == 1 && (dimC.isVisible())) {
			if (sashPanel.myParent.lastChangedLeaf == 0) {
				dimC.setText(baseW - dimAInput - dimBInput + "");
			}
			if (sashPanel.myParent.lastChangedLeaf == 2) {
				dimA.setText(baseW - dimAInput - dimBInput + "");
			} else {

				dimC.setText((baseW - dimBInput) / 2 + "");
				dimA.setText((baseW - dimBInput) / 2 + "");

			}

			sashPanel.myParent.lastChangedLeaf = 1;
			bChanged = true;

		}
		if (from == 2) {
			if (sashPanel.myParent.lastChangedLeaf == 0) {
				dimB.setText(baseW - dimAInput - dimCInput + "");
			}
			if (sashPanel.myParent.lastChangedLeaf == 1) {
				dimA.setText(baseW - dimCInput - dimBInput + "");
			} else {
				dimA.setText(dimCInput + "");
				dimB.setText(baseW - dimCInput - dimCInput + "");

			}

			sashPanel.myParent.lastChangedLeaf = 2;
		}

		if (from == 3 && (!dimCp.isVisible())) {

			dimBp.setText(100 - dimAInput + "");
			aChanged = true;
			sashPanel.myParent.lastChangedLeaf = 0;

		} else if (from == 3 && (dimCp.isVisible())) {

			if (sashPanel.myParent.lastChangedLeaf == 1) {
				dimCp.setText(100 - dimAInput - dimBInput + "");

			}
			if (sashPanel.myParent.lastChangedLeaf == 2) {
				dimBp.setText(100 - dimAInput - dimCInput + "");

			} else {
				dimCp.setText(dimAInput + "");
				dimBp.setText(100 - dimAInput - dimAInput + "");
			}

			sashPanel.myParent.lastChangedLeaf = 0;
			aChanged = true;
		}
		if (from == 4 && (!dimCp.isVisible())) {
			dimAp.setText(100 - dimBInput + "");
			sashPanel.myParent.lastChangedLeaf = 1;
			bChanged = true;
		} else if (from == 4 && (dimCp.isVisible())) {
			if (sashPanel.myParent.lastChangedLeaf == 0) {
				dimCp.setText(100 - dimAInput - dimBInput + "");
			}
			if (sashPanel.myParent.lastChangedLeaf == 2) {
				dimAp.setText(100 - dimAInput - dimBInput + "");
			} else {

				dimCp.setText((100 - dimBInput) / 2 + "");
				dimAp.setText((100 - dimBInput) / 2 + "");

			}

			sashPanel.myParent.lastChangedLeaf = 1;
			bChanged = true;

		}
		if (from == 5) {
			if (sashPanel.myParent.lastChangedLeaf == 0) {
				dimBp.setText(100 - dimAInput - dimCInput + "");
			}
			if (sashPanel.myParent.lastChangedLeaf == 1) {
				dimAp.setText(100 - dimCInput - dimBInput + "");
			} else {
				dimAp.setText(dimCInput + "");
				dimBp.setText(100 - dimCInput - dimCInput + "");

			}

			sashPanel.myParent.lastChangedLeaf = 2;
		}

		getInputText();
	}

	private void getInputText() {
		if (percent.isSelected()) {
			dimAInput = Double.parseDouble(dimAp.getText());
			dimBInput = Double.parseDouble(dimBp.getText());
			dimCInput = Double.parseDouble(dimCp.getText());
		} else {
			dimAInput = Double.parseDouble(dimA.getText());
			dimBInput = Double.parseDouble(dimB.getText());
			dimCInput = Double.parseDouble(dimC.getText());
		}
	}

	void jButtonClose_actionPerformed(final ActionEvent e) {

		ShapeDimDialog.dispose();
	}

	void jButtonSet_actionPerformed(final ActionEvent e) {

		try {

			if (sashPanel.openingClass == 311) {

				dimAInput = dimUsed / Integer.parseInt(noLeafs.getText());
				sashPanel.split = 100 * dimAInput / dimUsed;
				sashPanel.noOfLeafs = Integer.parseInt(noLeafs.getText());
				sashPanel.notracks = Integer.parseInt(noLeafs.getText());
				sashOnTrack = new int[Integer.parseInt(noLeafs.getText())];
				sashGlazedOut = new boolean[Integer.parseInt(noLeafs.getText())];
				paneType = new int[Integer.parseInt(noLeafs.getText())];
				interLocks = new int[Integer.parseInt(noLeafs.getText()) - 1];

				for (int t = 0; t < Integer.parseInt(noLeafs.getText()); t++) {
					sashOnTrack[t] = t + 1;
					sashGlazedOut[t] = true;

					paneType[t] = 8;

				}
				for (int t = 0; t < Integer.parseInt(noLeafs.getText()) - 1; t++) {
					interLocks[t] = 5;

				}

				sashPanel.sashOnTrack = sashOnTrack;
				sashPanel.opens = opens;
				sashPanel.glazedOut = true;
				sashPanel.interlockTypes = interLocks;
				sashPanel.sashGlazedOut = sashGlazedOut;
				sashPanel.paneType = paneType;

			} else if (sashPanel.openingClass == 312) {

				dimAInput = dimUsed / Integer.parseInt(noLeafs.getText());
				sashPanel.split = 100 * dimAInput / dimUsed;
				sashPanel.noOfLeafs = Integer.parseInt(noLeafs.getText());
				sashPanel.notracks = Integer.parseInt(noLeafs.getText());
				sashOnTrack = new int[Integer.parseInt(noLeafs.getText())];
				sashGlazedOut = new boolean[Integer.parseInt(noLeafs.getText())];
				paneType = new int[Integer.parseInt(noLeafs.getText())];
				interLocks = new int[Integer.parseInt(noLeafs.getText()) - 1];
				for (int t = 0; t < Integer.parseInt(noLeafs.getText()); t++) {
					sashOnTrack[t] = t + 1;
					sashGlazedOut[t] = true;

					paneType[t] = 7;

				}
				for (int t = 0; t < Integer.parseInt(noLeafs.getText()) - 1; t++) {
					interLocks[t] = 5;

				}

				sashPanel.sashOnTrack = sashOnTrack;
				sashPanel.opens = opens;
				sashPanel.glazedOut = true;
				sashPanel.sashGlazedOut = sashGlazedOut;
				sashPanel.interlockTypes = interLocks;
				sashPanel.paneType = paneType;

			} else if (sashPanel.openingClass == 313) {

				dimAInput = dimUsed / Integer.parseInt(noLeafs.getText());
				sashPanel.split = 100 * dimAInput / dimUsed;
				sashPanel.noOfLeafs = Integer.parseInt(noLeafs.getText());
				sashPanel.notracks = Integer.parseInt(noLeafs.getText());
				sashOnTrack = new int[Integer.parseInt(noLeafs.getText())];
				sashGlazedOut = new boolean[Integer.parseInt(noLeafs.getText())];
				paneType = new int[Integer.parseInt(noLeafs.getText())];
				interLocks = new int[Integer.parseInt(noLeafs.getText()) - 1];

				final int noLL = Integer.parseInt(noSLText.getText());

				for (int t = 0; t < Integer.parseInt(noLeafs.getText()); t++) {
					sashOnTrack[t] = t + 1;
					sashGlazedOut[t] = true;
					if (t < noLL) {
						paneType[t] = 7;
					} else {
						paneType[t] = 8;
					}

				}

				for (int t = 0; t < Integer.parseInt(noLeafs.getText()) - 1; t++) {
					interLocks[t] = 5;

				}
				interLocks[noLL - 1] = 6;

				sashPanel.sashOnTrack = sashOnTrack;
				sashPanel.opens = opens;
				sashPanel.glazedOut = true;
				sashPanel.interlockTypes = interLocks;
				sashPanel.sashGlazedOut = sashGlazedOut;
				sashPanel.paneType = paneType;

			} else if (sashPanel.openingClass == 301
					|| sashPanel.openingClass == 302
					|| sashPanel.openingClass == 303
					|| sashPanel.openingClass == 801
					|| sashPanel.openingClass == 802
					|| sashPanel.openingClass == 803) {

				sashPanel.split = 100 / Integer.parseInt(noLeafs.getText());

				int leafs = sashPanel.noOfLeafs = Integer.parseInt(noLeafs
						.getText());

				sashPanel.notracks = 1;// Integer.parseInt(1);

				sashOnTrack = new int[Integer.parseInt(noLeafs.getText())];

				sashGlazedOut = new boolean[Integer.parseInt(noLeafs.getText())];

				paneType = new int[Integer.parseInt(noLeafs.getText())];

				interLocks = new int[Integer.parseInt(noLeafs.getText()) - 1];

				final int noLL = Integer.parseInt(noSLText.getText());

				for (int t = 0; t < leafs; t++) {
					sashOnTrack[t] = 1;// t+1;
					sashGlazedOut[t] = sashPanel.mySelected.isGlazedout();

					if (t < noLL) {
						paneType[t] = 2;
					} else {
						paneType[t] = 3;
					}

				}

				for (int t = 0; t < leafs - 1; t++) {

					if (t < noLL - 1) {
						interLocks[t] = 5;
					} else if (t > noLL - 1) {
						interLocks[t] = 5;
					}
				}

				interLocks[noLL - 1] = 6;

				sashPanel.sashOnTrack = sashOnTrack;
				sashPanel.opens = opens;
				sashPanel.glazedOut = true;
				sashPanel.interlockTypes = interLocks;
				sashPanel.sashGlazedOut = sashGlazedOut;
				sashPanel.paneType = paneType;

			} else if (sashPanel.openingClass == 291
					|| sashPanel.openingClass == 292
					|| sashPanel.openingClass == 791
					|| sashPanel.openingClass == 792) {

				sashPanel.split = 100 / Integer.parseInt(noLeafs.getText());

				int leafs = sashPanel.noOfLeafs = Integer.parseInt(noLeafs
						.getText());

				sashPanel.notracks = leafs;// Integer.parseInt(1);

				sashOnTrack = new int[leafs];

				sashGlazedOut = new boolean[leafs];

				paneType = new int[leafs];

				interLocks = new int[leafs - 1];

				for (int t = 0; t < leafs; t++) {
					sashOnTrack[t] = t + 1;// t+1;
					sashGlazedOut[t] = sashPanel.mySelected.isGlazedout();

					paneType[t] = 8;

					if (sashPanel.openingClass == 292) {
						paneType[t] = 7;
					}

				}

				for (int t = 0; t < leafs - 1; t++) {
					interLocks[t] = 5;
				}

				sashPanel.sashOnTrack = sashOnTrack;
				sashPanel.opens = opens;
				sashPanel.glazedOut = true;
				sashPanel.interlockTypes = interLocks;
				sashPanel.sashGlazedOut = sashGlazedOut;
				sashPanel.paneType = paneType;

			} else if (sashPanel.openingClass == 293
					|| sashPanel.openingClass == 793) {

				int leafs = sashPanel.noOfLeafs = Integer.parseInt(noLeafs
						.getText());
				
				int tracks = sashPanel.notracks = Integer.parseInt(this.noTT
						.getText());
				
				sashPanel.split = 100 / (leafs/2);
				sashPanel.notracks = tracks;

				sashOnTrack = new int[leafs];

				sashGlazedOut = new boolean[leafs];

				paneType = new int[leafs];

				interLocks = new int[leafs- 1];

				final int noLL = Integer.parseInt(noSLText.getText());

				
				
				int counter =0;
				for(int l = noLL; l > 0; l--){
					sashOnTrack[l-1] = 1+counter;
					sashGlazedOut[l-1] = sashPanel.mySelected.isGlazedout();
					paneType[l-1] = 7;
					counter++;
				}
				
				counter=0;
				for(int l = noLL+1; l <= leafs; l++){
					sashOnTrack[l-1] = 1+counter;
					sashGlazedOut[l-1] = sashPanel.mySelected.isGlazedout();
					paneType[l-1] = 8;
					counter++;
				}
				
				
			
				
				interLocks[noLL - 1] = 6;
				

				for (int t = 0; t < leafs - 1; t++) {

					if (t < noLL - 1) {
						interLocks[t] = 5;
					} else if (t > noLL - 1) {
						interLocks[t] = 5;
					}
				}

				
				sashPanel.sashOnTrack = sashOnTrack;
				sashPanel.opens = opens;
				sashPanel.glazedOut = true;
				sashPanel.interlockTypes = interLocks;
				sashPanel.sashGlazedOut = sashGlazedOut;
				sashPanel.paneType = paneType;

			} else {
				if (dimAInput == 0) {
					if (aDim.isSelected()) {
						doTextAction(0);
					} else if (bDim.isSelected()) {
						doTextAction(1);
					} else if (cDim.isSelected()) {
						doTextAction(2);
					}
				}

				if (allDims.isSelected()) {
					sashPanel.split = 100 * dimAInput / dimUsed;
				} else {
					sashPanel.split = dimAInput;
				}

				sashPanel.percentA = dimAInput;
				sashPanel.percentB = dimBInput;
				sashPanel.percentC = dimCInput;

				sashPanel.noOfLeafs = noOfLeafs;
				sashPanel.notracks = notracks;
				sashPanel.sashOnTrack = sashOnTrack;
				sashPanel.opens = opens;
				sashPanel.glazedOut = glazedOut;
				sashPanel.sashGlazedOut = sashGlazedOut;
				sashPanel.paneType = paneType;
			}

			sashPanel.myParent.jobItem.myCanvas.mySelectedOpening = selectedOpening;

			selectedOpening = sashPanel.myParent.jobItem.myCanvas.continueSash(
					false, selectedOpening, true);

			sashPanel.myParent.jobItem.myCanvas.validate();
			sashPanel.myParent.jobItem.myCanvas.repaint();

			ShapeDimDialog.dispose();

		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	private void getIcons() {

		final int sashNo = sashPanel.openingClass;
		final String imageName = "sash" + sashNo + "_AB";

		for (int i = 0; i < sashPanel.myParent.iconFiles.size() - 1; i++) {
			sashIcon = (ImageIcon) sashPanel.myParent.iconFiles.get(imageName);

		}
		myImage.setIcon(sashIcon);

	}

}

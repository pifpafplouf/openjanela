/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Presentation;

import Model.*;
import Model.ProfileParts.Profiles;
import org.openjanela.data.MenuActionEventDraw;
import util.XYConstraints;
import util.XYLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;

public class DimsPanel {

	ItemFrame myParent;

	public JPanel dims = new JPanel();

	public JPanel dimPanel = new JPanel();

	JPanel levelPanel = new JPanel();

	ButtonGroup level = new ButtonGroup();

	public JRadioButton center = new JRadioButton();

	public JLabel centerLabel = new JLabel();

	public JRadioButton frame = new JRadioButton();

	public JLabel actualLabel = new JLabel();

	public JRadioButton frameOpening = new JRadioButton();

	public JLabel frameOpeningLabel = new JLabel();

	public JRadioButton frameOpeningC = new JRadioButton();

	public JRadioButton fOpeningN = new JRadioButton();

	public JLabel fOpeningNLabel = new JLabel();

	public JRadioButton fOpeningA = new JRadioButton();

	public JLabel fOpeningALabel = new JLabel();

	public JRadioButton glass = new JRadioButton();

	public JLabel glassLabel = new JLabel();

	public JRadioButton dlo = new JRadioButton();

	public JLabel dloLabel = new JLabel();

	public JRadioButton grids = new JRadioButton();

	public JLabel gridsLabel = new JLabel();

	public JRadioButton topToFloor = new JRadioButton();

	public JLabel topToFloorLabel = new JLabel();

	public JRadioButton centerToFloor = new JRadioButton();

	public JLabel centerToFloorLabel = new JLabel();

	public JRadioButton bottomToFloor = new JRadioButton();

	public JLabel bottomToFloorLabel = new JLabel();

	public JCheckBox heightAF = new JCheckBox();

	public JCheckBox showGridMaster = new JCheckBox();

	public JCheckBox showGlass = new JCheckBox();

	public JCheckBox showName = new JCheckBox();

	JLabel heightAFL = new JLabel();

	JLabel showGlassL = new JLabel();

	JLabel showNameL = new JLabel();

	JLabel showGridMasterL = new JLabel();

	public JButton equalize = new JButton();

	public JButton equalizeH = new JButton();

	public JButton alignVert = new JButton();

	public JButton alignHorz = new JButton();

	public ButtonGroup checkGroupMeasure = new ButtonGroup();

	public JCheckBox overall = new JCheckBox();

	public JRadioButton fLevel = new JRadioButton();

	public JRadioButton sFLevel = new JRadioButton();

	public JCheckBox isSash = new JCheckBox();

	JLabel isSashLabel = new JLabel();

	JLabel frameLabel = new JLabel();

	JLabel subLabel = new JLabel();

	public JButton switchSash = new JButton();

	public JLabel sashTip = new JLabel("Which Sash?");

	public JButton doAlign = new JButton();

	public JButton cancelAlign = new JButton();

	public JButton changeAlign = new JButton();

	public JPanel viewPanel = new JPanel();

	public JPanel guidePanel = new JPanel();

	public JCheckBox masterSelected = new JCheckBox("Master Selected");

	public JCheckBox slaveSelected = new JCheckBox("Slave Selected");

	public JLabel masterSelectedL = new JLabel();

	public JLabel slaveSelectedL = new JLabel();

	public DimsPanel(final ItemFrame myparent) {

		myParent = myparent;

		dimPanel.setPreferredSize(new Dimension(175, 312));

		dimPanel.setLayout(new BorderLayout());

		dims.setLayout(new XYLayout());

		dims.setPreferredSize(new Dimension(198, 151));

		levelPanel.setLayout(new XYLayout());

		levelPanel.setPreferredSize(new Dimension(198, 22));

		guidePanel.setPreferredSize(new Dimension(198, 25));
		guidePanel.setLayout(new XYLayout());

		guidePanel.setBorder(BorderFactory.createEtchedBorder());

		equalize.setPreferredSize(new Dimension(60, 60));

		cancelAlign.setIcon(myParent.cancelImage);

		changeAlign.setIcon(myParent.changeImage);

		doAlign.setIcon(myParent.setImage);

		equalize.setIcon(myParent.balanceIcon);

		equalize.setToolTipText("=Vertical Dims");

		equalizeH.setIcon(myParent.balanceIconH);

		equalizeH.setToolTipText("=Horizontal Dims");

		alignVert.setPreferredSize(new Dimension(60, 60));

		ImageIcon alignVIcon = new ImageIcon();

		alignVIcon = (ImageIcon) myParent.iconFiles.get("alignV");

		alignVert.setIcon(alignVIcon);

		alignVert.setToolTipText("Align Verticals");

		alignHorz.setPreferredSize(new Dimension(60, 60));

		ImageIcon alignHIcon = new ImageIcon();

		alignHIcon = (ImageIcon) myParent.iconFiles.get("alignH");

		alignHorz.setIcon(alignHIcon);

		alignHorz.setToolTipText("Align Horizontals");

		checkGroupMeasure.add(center);

		checkGroupMeasure.add(frame);

		checkGroupMeasure.add(frameOpening);

		checkGroupMeasure.add(frameOpeningC);

		checkGroupMeasure.add(fOpeningN);

		checkGroupMeasure.add(fOpeningA);

		checkGroupMeasure.add(glass);

		checkGroupMeasure.add(dlo);

		checkGroupMeasure.add(grids);

		checkGroupMeasure.add(topToFloor);

		checkGroupMeasure.add(centerToFloor);

		checkGroupMeasure.add(bottomToFloor);

		centerLabel.setIcon((ImageIcon) myParent.iconFiles.get("nominalframe"));
		actualLabel.setIcon((ImageIcon) myParent.iconFiles.get("actualframe"));

		frameOpeningLabel.setIcon((ImageIcon) myParent.iconFiles.get("bkgrd"));

		fOpeningNLabel.setIcon((ImageIcon) myParent.iconFiles
				.get("nominalopening"));
		fOpeningALabel.setIcon((ImageIcon) myParent.iconFiles
				.get("actualopening"));
		glassLabel.setIcon((ImageIcon) myParent.iconFiles.get("glass"));
		dloLabel.setIcon((ImageIcon) myParent.iconFiles.get("dlo"));
		gridsLabel.setIcon((ImageIcon) myParent.iconFiles.get("grids"));
		topToFloorLabel.setIcon((ImageIcon) myParent.iconFiles
				.get("toptofloor"));

		centerToFloorLabel.setIcon((ImageIcon) myParent.iconFiles
				.get("midtofloor"));
		bottomToFloorLabel.setIcon((ImageIcon) myParent.iconFiles
				.get("bottofloor"));

		grids.setEnabled(false);

		fLevel.setText("");

		sFLevel.setText("");

		isSash.setText("");

		isSashLabel.setIcon((ImageIcon) myParent.iconFiles.get("sashdims"));
		frameLabel.setIcon((ImageIcon) myParent.iconFiles.get("framelevel"));
		subLabel.setIcon((ImageIcon) myParent.iconFiles.get("subFrame"));

		isSashLabel.setToolTipText("Sash Level Dimensions");
		frameLabel.setToolTipText("Frame Level Dimensions");
		subLabel.setToolTipText("Sub-Frame Level Dimensions");
		switchSash.setToolTipText("Select Different Sash");

		switchSash.setIcon((ImageIcon) myParent.iconFiles.get("switchsash"));

		switchSash.setVisible(false);

		switchSash.setEnabled(false);

		level.add(fLevel);

		level.add(sFLevel);

		levelPanel.add(fLevel, new XYConstraints(4, 0, 18, 19));
		levelPanel.add(frameLabel, new XYConstraints(24, 0, 18, 19));
		levelPanel.add(isSash, new XYConstraints(90, 0, 20, 18));
		levelPanel.add(isSashLabel, new XYConstraints(110, 0, 18, 19));
		levelPanel.add(sFLevel, new XYConstraints(46, 0, 18, 19));
		levelPanel.add(subLabel, new XYConstraints(68, 0, 18, 19));
		levelPanel.add(switchSash, new XYConstraints(150, 0, 18, 18));

		sashTip.setIcon((ImageIcon) myParent.iconFiles.get("tip"));
		sashTip.setToolTipText("Please Select Sash!");

		levelPanel.add(sashTip, new XYConstraints(175, 0, 18, 18));
		sashTip.setVisible(false);

		isSash.setToolTipText("Sash Level if Selected");

		fLevel.setSelected(true);

		dims.add(center, new XYConstraints(0, 0, 19, 19));

		dims.add(centerLabel, new XYConstraints(21, 0, 24, 24));
		dims.add(frame, new XYConstraints(48, 0, 19, 19));
		dims.add(actualLabel, new XYConstraints(68, 0, 24, 24));
		dims.add(frameOpening, new XYConstraints(100, 0, 19, 19));// 42
		dims.add(frameOpeningLabel, new XYConstraints(121, 0, 24, 24));// 42
		dims.add(fOpeningN, new XYConstraints(0, 30, 19, 19));// 122
		dims.add(fOpeningNLabel, new XYConstraints(21, 30, 24, 24));// 122
		dims.add(fOpeningA, new XYConstraints(48, 30, 19, 19));// 122
		dims.add(fOpeningALabel, new XYConstraints(68, 30, 24, 24));// 122
		dims.add(glass, new XYConstraints(0, 60, 19, 19));// 122
		dims.add(glassLabel, new XYConstraints(21, 60, 24, 24));// 122
		dims.add(dlo, new XYConstraints(48, 60, 19, 19));// 122
		dims.add(dloLabel, new XYConstraints(68, 60, 24, 24));// 122
		dims.add(grids, new XYConstraints(100, 60, 19, 19));// 122
		dims.add(gridsLabel, new XYConstraints(121, 60, 24, 24));// 122
		dims.add(topToFloor, new XYConstraints(0, 95, 19, 19));// 122
		dims.add(topToFloorLabel, new XYConstraints(21, 95, 24, 24));// 122
		dims.add(centerToFloor, new XYConstraints(48, 95, 19, 19));// 122
		dims.add(centerToFloorLabel, new XYConstraints(68, 95, 24, 24));// 122
		dims.add(bottomToFloor, new XYConstraints(100, 95, 19, 19));// 122
		dims.add(bottomToFloorLabel, new XYConstraints(121, 95, 24, 24));// 122

		topToFloor.setEnabled(false);

		centerToFloor.setEnabled(false);

		bottomToFloor.setEnabled(false);

		center.setSelected(true);

		center.setToolTipText("Nominal Size");

		frame.setToolTipText("Actual Size");

		frameOpening.setToolTipText("Background Opening Size");

		frameOpeningLabel.setToolTipText("Background Opening Size");

		fOpeningN.setToolTipText("Opening Nominal Size");

		fOpeningNLabel.setToolTipText("Opening Nominal Size");

		fOpeningA.setToolTipText("Opening Actual Size");

		fOpeningALabel.setToolTipText("Opening Actual Size");

		glass.setToolTipText("Glass Size");

		dlo.setToolTipText("dlo Size");

		grids.setToolTipText("grids Size");

		topToFloor.setToolTipText("Mullion Top to Floor");

		centerToFloor.setToolTipText("Mullion Center to Floor");

		bottomToFloor.setToolTipText("Mullion Bottom to Floor");

		glassLabel.setToolTipText("Glass Size");

		dloLabel.setToolTipText("dlo Size");

		gridsLabel.setToolTipText("grids Size");

		topToFloorLabel.setToolTipText("Mullion Top to Floor");

		centerToFloorLabel.setToolTipText("Mullion Center to Floor");

		bottomToFloorLabel.setToolTipText("Mullion Bottom to Floor");

		dims.add(equalize, new XYConstraints(7, 130, 25, 19));
		dims.add(equalizeH, new XYConstraints(33, 130, 25, 19));
		dims.add(alignVert, new XYConstraints(59, 130, 25, 19));
		dims.add(alignHorz, new XYConstraints(85, 130, 25, 19));

		dims.setBorder(BorderFactory.createEtchedBorder());

		dimPanel.add(levelPanel, BorderLayout.NORTH);

		dimPanel.add(dims, BorderLayout.CENTER);

		heightAFL.setIcon((ImageIcon) myParent.iconFiles.get("haf"));
		showGridMasterL.setIcon((ImageIcon) myParent.iconFiles.get("grids16"));
		showGlassL.setIcon((ImageIcon) myParent.iconFiles.get("glass16"));
		showNameL.setIcon((ImageIcon) myParent.iconFiles.get("sashdims"));

		heightAF.setToolTipText("Height Above Floor");
		showGridMaster.setToolTipText("Grid Master");
		showGlass.setToolTipText("Glass & S.U. Type");
		showName.setToolTipText("Opening Name - User Defined");
		heightAFL.setToolTipText("Height Above Floor");
		showGridMasterL.setToolTipText("Grid Master");
		showGlassL.setToolTipText("Glass & S.U. Type");
		showNameL.setToolTipText("Opening Name - User Defined");

		viewPanel.setPreferredSize(new Dimension(175, 312));

		viewPanel.setLayout(new XYLayout());
		viewPanel.add(heightAF, new XYConstraints(0, 2, 20, 19));
		viewPanel.add(heightAFL, new XYConstraints(24, 2, 20, 19));
		viewPanel.add(showGridMaster, new XYConstraints(0, 22, 20, 19));
		viewPanel.add(showGridMasterL, new XYConstraints(24, 22, 20, 19));
		viewPanel.add(showGlass, new XYConstraints(0, 42, 20, 19));
		viewPanel.add(showGlassL, new XYConstraints(24, 42, 20, 19));
		viewPanel.add(showName, new XYConstraints(0, 62, 20, 19));
		viewPanel.add(showNameL, new XYConstraints(24, 62, 20, 19));

		addactionToTasks();

		// isSash.setEnabled(false);

	}

	public int getSelectedDim() {

		if (center.isSelected()) {
			myParent.selectedDim = 1;
			myParent.setPercentActive(true);
		} else if (frame.isSelected()) {
			myParent.selectedDim = 2;
			myParent.setPercentActive(true);
		} else if (frameOpeningC.isSelected()) {
			myParent.selectedDim = 3;
			myParent.setPercentActive(false);
		} else if (frameOpening.isSelected()) {
			myParent.selectedDim = 4;
			myParent.setPercentActive(false);
		} else if (fOpeningN.isSelected()) {
			myParent.selectedDim = 5;
			myParent.setPercentActive(false);
		} else if (fOpeningA.isSelected()) {
			myParent.selectedDim = 6;
			myParent.setPercentActive(false);
		} else if (glass.isSelected()) {
			myParent.selectedDim = 7;
			myParent.setPercentActive(false);
		} else if (dlo.isSelected()) {
			myParent.selectedDim = 8;
			myParent.setPercentActive(false);
		} else if (grids.isSelected()) {
			myParent.selectedDim = 9;
			myParent.setPercentActive(false);
		}
		return myParent.selectedDim;
	}

	public void setDimsActive(final boolean active) {

		center.setEnabled(active);

		frame.setEnabled(active);

		frameOpening.setEnabled(active);

		frameOpeningC.setEnabled(active);

		fOpeningN.setEnabled(active);

		fOpeningA.setEnabled(active);

		glass.setEnabled(active);

		dlo.setEnabled(active);

		if (!isSash.isSelected()) {
			frameOpening.setEnabled(active);
			center.setEnabled(active);
		} else {
			frame.setSelected(true);
			frameOpening.setEnabled(false);
			center.setEnabled(false);
		}

		if (myParent.hasGrids) {
			grids.setEnabled(true);
		} else {
			grids.setEnabled(false);
		}

		topToFloor.setEnabled(false);

		centerToFloor.setEnabled(false);

		bottomToFloor.setEnabled(false);

		equalize.setEnabled(active);

		equalizeH.setEnabled(active);

		alignVert.setEnabled(active);

		alignHorz.setEnabled(active);

	}

	public void resetDim() {

		int mySD = myParent.selectedDim;

		this.myParent.jobItem.hasSubRC(myParent.selectedRadioForRow,
				myParent.selectedRadioForCol);

		if (mySD == 1) {
			center.doClick();
		} else if (mySD == 2) {
			frame.doClick();
		} else if (mySD == 3) {
			frameOpeningC.doClick();
		} else if (mySD == 4) {
			frameOpening.doClick();
		} else if (mySD == 5) {
			fOpeningN.doClick();
		} else if (mySD == 6) {
			fOpeningA.doClick();
		} else if (mySD == 7) {
			glass.doClick();
		} else if (mySD == 8) {
			dlo.doClick();
		} else if (mySD == 9) {
			grids.doClick();
		}

	}

	public void buildGuidePanel(final int orientation) {

		myParent.alignClicks = 0;
		myParent.alignSeq = 0;
		myParent.mullionsPanel.setButtonsFalse();
		myParent.mullionsPanel.selectedHV = 0;

		guidePanel.setVisible(true);

		guidePanel.remove(masterSelected);
		guidePanel.remove(slaveSelected);
		guidePanel.remove(doAlign);
		guidePanel.remove(changeAlign);
		guidePanel.remove(cancelAlign);

		if (orientation == 1) {
			masterSelected.setToolTipText("V. Master Selected");
			slaveSelected.setToolTipText("V. Slave Selected");
			masterSelected.setToolTipText("Select Vertical Master ");
			slaveSelected.setToolTipText("Select Vertical Slave ");
		} else {
			masterSelected.setToolTipText("H. Master Selected");
			slaveSelected.setToolTipText("H. Slave Selected");
			masterSelected.setToolTipText("Select Horizontal Master ");
			slaveSelected.setToolTipText("Select Horizontal Slave ");
		}

		myParent.alignSeq = 0;

		masterSelected.setEnabled(false);
		slaveSelected.setEnabled(false);

		masterSelected.setHorizontalTextPosition(SwingConstants.LEFT);
		slaveSelected.setHorizontalTextPosition(SwingConstants.LEFT);

		

		masterSelectedL.setIcon((ImageIcon) myParent.iconFiles.get("bkgrd"));
		slaveSelectedL.setIcon((ImageIcon) myParent.iconFiles.get("bkgrd"));
		
		
		guidePanel.add(masterSelected, new XYConstraints(2, 0, 20, 19));
		guidePanel.add(masterSelectedL, new XYConstraints(22, 0, 18, 19));
		guidePanel.add(slaveSelected, new XYConstraints(44, 0, 20, 19));
		guidePanel.add(slaveSelectedL, new XYConstraints(66, 0, 18, 19));

		// 84

		masterSelected.setVisible(true);
		slaveSelected.setVisible(true);

		doAlign.setVisible(true);
		changeAlign.setVisible(true);
		cancelAlign.setVisible(true);

		doAlign.setEnabled(false);
		changeAlign.setEnabled(false);

		guidePanel.add(doAlign, new XYConstraints(100, 0, 30, 19));
		guidePanel.add(changeAlign, new XYConstraints(131, 0, 30, 19));
		guidePanel.add(cancelAlign, new XYConstraints(162, 0, 30, 19));
	}

	private void addactionToTasks() {

		equalize.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {
				equalize_actionPerformed(e);
			}
		});

		equalizeH.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				equalizeH_actionPerformed(e);
			}

		});

		alignVert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				alignV_actionPerformed(e);
			}

		});

		alignHorz.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				alignH_actionPerformed(e);
			}
		});

		doAlign.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				align_actionPerformed(e);
			}
		});

		cancelAlign.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelAlign_actionPerformed(e);
			}
		});

		changeAlign.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeAlign_actionPerformed(e);
			}
		});

		heightAF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				heightAF_actionPerformed(e);
			}
		});

		showGlass.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				heightAF_actionPerformed(e);
			}
		});

		showName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				heightAF_actionPerformed(e);
			}
		});

		// showGridMaster.setEnabled(false);

		showGridMaster.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				heightAF_actionPerformed(e);
			}
		});

		fLevel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dimCheckBoxAction();
			}
		});

		sFLevel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				dimCheckBoxAction();
			}
		});

		isSash.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				myParent.mySelectedSash = null;

				if (isSash.isSelected()) {

					sashTip.setVisible(true);
					myParent.myCursor = new Cursor(Cursor.CROSSHAIR_CURSOR);

					myParent.jobItem.myCanvas.setCursor(myParent.myCursor);

					switchSash.setVisible(true);
					switchSash.setEnabled(true);

					setDimsActive(false);

					if (myParent.frameDim) {
						center.doClick();
					} else {
						frame.doClick();
					}

				} else {
					sashTip.setVisible(false);
					myParent.mySelectedSash = null;
					myParent.myCursor = new Cursor(Cursor.DEFAULT_CURSOR);

					myParent.jobItem.myCanvas.setCursor(myParent.myCursor);

					guidePanel.setVisible(false);
					switchSash.setVisible(false);
					switchSash.setEnabled(false);
					dims.setEnabled(true);

					myParent.mySelectedSash = null;
					setDimsActive(true);
					if (myParent.frameDim) {
						center.doClick();
					} else {
						frame.doClick();
					}
				}
			}
		});

		switchSash.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myParent.mySelectedSash = null;
				isSash.setSelected(false);
				isSash.doClick();

			}
		});

		overall.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				overall_actionPerformed(e);
			}
		});

		center.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				dimCheckBoxAction();
			}
		});

		frame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent e) {

				dimCheckBoxAction();
			}
		});

		frameOpening.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dimCheckBoxAction();
			}
		});

		frameOpeningC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dimCheckBoxAction();
			}
		});

		fOpeningN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dimCheckBoxAction();
			}
		});

		fOpeningA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dimCheckBoxAction();
			}
		});

		glass.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myParent.resetModTextsV = true;
				dimCheckBoxAction();
			}
		});

		dlo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myParent.resetModTextsV = true;
				dimCheckBoxAction();
			}
		});

		grids.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myParent.resetModTextsV = true;
				dimCheckBoxAction();
			}
		});

		heightAF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				heightAF_actionPerformed(e);
			}
		});

		showGlass.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				heightAF_actionPerformed(e);
			}
		});

		showName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				heightAF_actionPerformed(e);
			}
		});

	}

	public void alignV_actionPerformed(final ActionEvent e) {

		this.myParent.dim.buildGuidePanel(1);

		this.myParent.myCursor = new Cursor(Cursor.CROSSHAIR_CURSOR);

		this.myParent.jobItem.myCanvas.setCursor(this.myParent.myCursor);
		this.myParent.alignV = true;

		this.myParent.setActionTypeEvent(MenuActionEventDraw.ALIGN_VERTICAL
				.getValue());

		if (this.myParent.extendCM || this.myParent.editCM) {
			this.myParent.extendCM = false;
			this.myParent.editCM = false;
			this.myParent.mullionsPanel.hideExtend();
			this.myParent.mullionsPanel.editEnabled(true);
		}
	}

	public void alignH_actionPerformed(final ActionEvent e) {

		this.myParent.dim.buildGuidePanel(2);

		this.myParent.myCursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
		// this.myParent.setCursor(myCursor);
		this.myParent.jobItem.myCanvas.setCursor(this.myParent.myCursor);
		this.myParent.alignH = true;

		this.myParent.setActionTypeEvent(MenuActionEventDraw.ALIGN_HORIZONTAL
				.getValue());

		if (this.myParent.extendCM || this.myParent.editCM) {
			this.myParent.extendCM = false;
			this.myParent.editCM = false;
			this.myParent.mullionsPanel.hideExtend();
			this.myParent.mullionsPanel.editEnabled(true);
		}
	}

	public void overall_actionPerformed(final ActionEvent e) {

		if (this.myParent.dim.center.isSelected()) {
			this.myParent.jobItem.myCanvas.setSelectedDims(0);
			this.myParent.dim.overall.setSelected(true);
		} else {
			this.myParent.jobItem.myCanvas.setSelectedDims(1);
			this.myParent.dim.overall.setSelected(false);
		}
	}

	public void heightAF_actionPerformed(ActionEvent e) {
		this.myParent.jobItem.resetGraphics();
	}

	public void changeAlign_actionPerformed(final ActionEvent e) {

		this.myParent.mySlaveType = 0;
		this.myParent.dim.slaveSelected.setSelected(false);
		this.myParent.alignClicks = 1;

		this.myParent.setMullionUnselected();

		this.myParent.facetUsed.myLine = new GeneralPath();
		this.myParent.alignSeq = 1;

		this.myParent.jobItem.myCanvas.validate();
		this.myParent.jobItem.myCanvas.repaint();

		// this.myParent.jobItem.resetGraphics();
	}

	public void cancelAlign_actionPerformed(final ActionEvent e) {
		cancelEditAlignExtendAction();
	}

	public void cancelEditAlignExtendAction() {

		if (this.myParent.extendCM) {
			this.myParent.mullionsPanel.hideExtend();
			this.myParent.mullionsPanel.editEnabled(true);
		}

		this.myParent.resetAlign();

		this.myParent.hideAlign();

		this.myParent.clearCMAlignEdit();

		this.myParent.jobItem.myCanvas.validate();
		this.myParent.jobItem.myCanvas.repaint();

		// this.myParent.jobItem.resetGraphics();

		// validate();
		// repaint();
	}

	public void align_actionPerformed(final ActionEvent e) {

		this.myParent.alignPerformed = false;
		this.myParent.alignHPerformed = false;
		this.myParent.extendPerformed = false;
		boolean sameFrame = false;
		if (this.myParent.myMasterType == 2) {
			if (((Profiles) this.myParent.mySlave).myParent
					.equals(((Profiles) this.myParent.myMaster).myParent)) {
				sameFrame = true;
			}
		}
		final Object[] frameObjects = ((Facet) this.myParent.facetUsed).frames
				.toArray();

		final ShapeObject master = ((Profiles) this.myParent.myMaster).myParent.myParent;
		// ShapeObject slave= null;

		boolean slaveFound = false;

		if (this.myParent.slave != null) {
			slaveFound = true;
		}

		if (!slaveFound) {
			if (this.myParent.mySlaveType == 2) {
				for (final Object F : frameObjects) {

					if (((Profiles) this.myParent.mySlave).myParent.myParent.a_levelID == 3
							&& ((Profiles) this.myParent.mySlave).myParent.myParent.a_sequenceID == ((Model.Frame) F).bOpeningObject.myParent.a_sequenceID) {
						this.myParent.slave = (Model.Frame) F;
						slaveFound = true;
						break;
					}

				}
				if (!slaveFound) {
					Object[] leafs = null;
					for (final Object F : frameObjects) {

						if (slaveFound) {
							break;
						}
						final Object[] openings = ((ShapeObject) F).openings
								.toArray();

						for (final Object O : openings) {
							if (slaveFound) {
								break;
							}
							if (((OpeningObject) O).sashObjectIn != null) {
								leafs = ((OpeningObject) O).sashObjectIn.frames
										.toArray();
								for (final Object S : leafs) {
									if (((Profiles) this.myParent.mySlave).myParent.myParent.a_sequenceID == ((SashLeaf) S).a_sequenceID
											&& this.myParent.mySlaveFrame == ((SashLeaf) S).myParent.myParent.a_sequenceID) {
										this.myParent.slave = (SashLeaf) S;
										slaveFound = true;
										break;
									}

								}

							}// In
								// Sash

							if (((OpeningObject) O).sashObjectMid != null) {
								leafs = ((OpeningObject) O).sashObjectMid.frames
										.toArray();
								for (final Object S : leafs) {
									if (((Profiles) this.myParent.mySlave).myParent.myParent.a_sequenceID == ((SashLeaf) S).a_sequenceID
											&& this.myParent.mySlaveFrame == ((SashLeaf) S).myParent.myParent.a_sequenceID) {

										this.myParent.slave = (SashLeaf) S;
										slaveFound = true;
										break;
									}

								}

							}// Mid
								// Sash

							if (((OpeningObject) O).sashObjectOut != null) {
								leafs = ((OpeningObject) O).sashObjectOut.frames
										.toArray();
								for (final Object S : leafs) {
									if (((Profiles) this.myParent.mySlave).myParent.myParent.a_sequenceID == ((SashLeaf) S).a_sequenceID
											&& this.myParent.mySlaveFrame == ((SashLeaf) S).myParent.myParent.a_sequenceID) {
										this.myParent.slave = (SashLeaf) S;
										slaveFound = true;
										break;
									}
								}

							}// Out
								// Sash

						}

					}
				}
			} else if (this.myParent.mySlaveType >= 3
					&& this.myParent.mySlaveType <= 6) {
				for (final Object F : frameObjects) {

					if (slaveFound) {
						break;
					}
					final Object[] openings = ((ShapeObject) F).openings
							.toArray();

					for (final Object O : openings) {
						if (slaveFound) {
							break;
						}
						if (((OpeningObject) O).sashObjectIn.bOpeningObject != null) {
							final Object[] mVs = ((OpeningObject) O).sashObjectIn.bOpeningObject.mullions
									.toArray();
							for (final Object V : mVs) {
								if (((Profiles) V).centerXs == ((Profiles) this.myParent.mySlave).centerXs
										&& ((Profiles) V).centerXe == ((Profiles) this.myParent.mySlave).centerXe) {
									this.myParent.slave = ((OpeningObject) O).sashObjectIn;
									slaveFound = true;
									break;
								}

							}
							final Object[] mHs = ((OpeningObject) O).sashObjectIn.bOpeningObject.mullionsH
									.toArray();
							for (final Object H : mHs) {
								if (((Profiles) H).centerYs == ((Profiles) this.myParent.mySlave).centerYs
										&& ((Profiles) H).centerYe == ((Profiles) this.myParent.mySlave).centerYe) {
									this.myParent.slave = ((OpeningObject) O).sashObjectIn;
									slaveFound = true;
									break;
								}

							}

						}// In
							// Sash

						if (((OpeningObject) O).sashObjectMid.bOpeningObject != null) {
							final Object[] mVs = ((OpeningObject) O).sashObjectMid.bOpeningObject.mullions
									.toArray();
							for (final Object V : mVs) {
								if (((Profiles) V).centerXs == ((Profiles) this.myParent.mySlave).centerXs
										&& ((Profiles) V).centerXe == ((Profiles) this.myParent.mySlave).centerXe) {
									this.myParent.slave = ((OpeningObject) O).sashObjectMid;
									slaveFound = true;
									break;
								}

							}
							final Object[] mHs = ((OpeningObject) O).sashObjectMid.bOpeningObject.mullionsH
									.toArray();
							for (final Object H : mHs) {
								if (((Profiles) H).centerYs == ((Profiles) this.myParent.mySlave).centerYs
										&& ((Profiles) H).centerYe == ((Profiles) this.myParent.mySlave).centerYe) {
									this.myParent.slave = ((OpeningObject) O).sashObjectMid;
									slaveFound = true;
									break;
								}

							}

						}// Mid
							// Sash

						if (((OpeningObject) O).sashObjectOut.bOpeningObject != null) {
							final Object[] mVs = ((OpeningObject) O).sashObjectOut.bOpeningObject.mullions
									.toArray();
							for (final Object V : mVs) {
								if (((Profiles) V).centerXs == ((Profiles) this.myParent.mySlave).centerXs
										&& ((Profiles) V).centerXe == ((Profiles) this.myParent.mySlave).centerXe) {
									this.myParent.slave = ((OpeningObject) O).sashObjectOut;
									slaveFound = true;
									break;
								}

							}
							final Object[] mHs = ((OpeningObject) O).sashObjectOut.bOpeningObject.mullionsH
									.toArray();
							for (final Object H : mHs) {
								if (((Profiles) H).centerYs == ((Profiles) this.myParent.mySlave).centerYs
										&& ((Profiles) H).centerYe == ((Profiles) this.myParent.mySlave).centerYe) {
									this.myParent.slave = ((OpeningObject) O).sashObjectOut;
									slaveFound = true;
									break;
								}

							}

						}// Out
							// Sash

					}

				}
			}

		}
		if (this.myParent.slave == null && this.myParent.extendCM) {

			slaveFound = true;

		}

		this.myParent.doActions(sameFrame, this.myParent.slave, master);
		this.myParent.clearCMAlignEdit();
		this.myParent.dim.alignHorz.setEnabled(true);
		this.myParent.dim.alignVert.setEnabled(true);

		// this.validate();
		// this.repaint();
	}

	public void dimCheckBoxAction() {

		myParent.resetModTextsV = true;
		myParent.resetModTextsH = true;

		myParent.dimAction();
	}

	public void equalize_actionPerformed(final ActionEvent e) {

		this.myParent.modifyDims = false;
		this.myParent.dim.equalize.setSelected(true);

		this.myParent.jobItem.myCanvas.equalize = true;
		this.myParent.jobItem.myCanvas.equalizeWidths();

		this.myParent.doFacetRadioClick();

	}

	public void equalizeH_actionPerformed(final ActionEvent e) {

		this.myParent.modifyDims = false;
		this.myParent.dim.equalizeH.setSelected(true);

		this.myParent.jobItem.myCanvas.equalizeH = true;
		this.myParent.jobItem.myCanvas.equalizeHeights();

		this.myParent.doFacetRadioClick();
	}

}

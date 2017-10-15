/**
 * Copyright (c) 2009, OpenJanela. All rights reserved.
 * Contributors:
 * Sherif El Dibani
 **/
package Presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.*;

import openjanela.app.configuration.controller.CouplerMullionPanelController;
import openjanela.model.entities.partner.TypeCouplerMullion;
import openjanela.model.entities.partner.ValidCouplerMullions;
import openjanela.model.entities.partner.ValidOrientations;

import org.openjanela.data.MenuActionEventDraw;
import org.w3c.dom.events.MouseEvent;

import util.UOMConvert;
import util.XYConstraints;
import util.XYLayout;
import Model.Facet;
import Model.Frame;
import Model.OpeningObject;
import Model.ProfileParts.Profiles;


/**
 * This class represents the coupler and mullions panel menu options for draw
 */
public class CouplerAndMullionPanel {
	
	//ItemFrame parent object
	public ItemFrame myParent;
	
	//Coupler and Mullions panel design
	public JPanel couplerMullionPanel = new JPanel();
	
	//Vertical Coupler
	public JButton vC = new JButton();
	//Horizontal Coupler
	public JButton hC = new JButton();
	//Vertical Mullion
	public JButton vM = new JButton();
	//Horizontal Mullion
	public JButton hM = new JButton();
	
	public JButton setGo = new JButton();
	
	public JButton cancel = new JButton();

	private final String[] partStrings = {" Part Description 2", " Part Description 3", " Part Description 4", " Part Description 5"};
	private final String[] lCutText = {"Mitered x�", "Straight Cut |", "Machined/Profiled ["};
	private final String[] rCutText = {"Mitered x�", "Straight Cut |", "Machined/Profiled ]"};
	private final String[] pfStrings = {"Straight", "Diagonal", "Bezier", "Curve"};
	
	//ComboBox coupler type
	public JComboBox couplerTypeC = new JComboBox();
	
	//Panel for mullions and couplers options
	public JPanel whichFeature = new JPanel();
	
	JPanel editor = new JPanel();
	
	//Button to enable selection of mullion properties
	public JButton edit = new JButton();
	//Button to extend join of mullion properties
	public JButton extend = new JButton();
	
	public JCheckBox part = new JCheckBox();
	public JCheckBox endTypeLT = new JCheckBox();
	public JCheckBox endTypeRB = new JCheckBox();
	public JCheckBox pfFormL = new JCheckBox();
	
	public JLabel endTypeLTL = new JLabel();
	public JLabel endTypeRBL = new JLabel();
	public JLabel pfFormLL = new JLabel();
	public JLabel partL = new JLabel();
	
	//Button group for edition coupler & mullions
	public ButtonGroup editGroup = new ButtonGroup();
	
	public JComboBox parts = new JComboBox(partStrings);
	public JComboBox lCut = new JComboBox(lCutText);
	public JComboBox rCut = new JComboBox(rCutText);
	public JComboBox pfCombo = new JComboBox(pfStrings);
	
	public int whichPos = 2; // 1=in, // 2=Mid 3= out
	
	public JLabel offsetL = new JLabel("+/- L:");
	public JLabel offsetR = new JLabel("+/- R:");
	public JLabel bL = new JLabel("Delta L:");
	public JLabel bR = new JLabel("Delta R:");
	
	public JTextField offsetLT = new JTextField("0.0000");
	public JTextField offsetRB = new JTextField("0.0000");
	public JTextField deltaL = new JTextField("0.0000");
	public JTextField deltaR = new JTextField("0.0000");
	
	public int partID = 0;
	
	public int mType = 0; // Type = Divider, Coupler Mullion
	
	public int selectedLevel = 1;
	
	public int selectedHV = 0; // 1V 2H
	public int mullionPartForm = 1;
	public int endLT = 0;
	public int endRB = 0;
	
	public int typeID = 0; // type ID
	
	public double offsetTL = 0; // offset from center (- or +)
	public double offsetBR = 0;
	public double deltaTL = 0;
	public double deltaRB = 0;
	public double curveCenterTL = 0;
	public double curveCenterRB = 0;
	
	public double mullionThick = 0;
	public double mullionBtoC = 0;
	public double mullionC = 0;
	public double mullionA = 0;
	public double angle = 180;
	
	public boolean isSashMullion = false;
	public boolean divideFacet = false;
	public boolean isFixedAngle = true;
	public boolean isPhantom = false;
	public boolean okToUse = true;
	
	//*******************************************************************
	//Properties values & controller
	//*******************************************************************
	private CouplerMullionPanelController couplerMullionController;
	
	//*******************************************************************
	// Getters and Setters
	//*******************************************************************
	
	public CouplerMullionPanelController getCouplerMullionController() {
		return couplerMullionController;
	}
	
	public void setCouplerMullionController(CouplerMullionPanelController couplerMullionController) {
		this.couplerMullionController = couplerMullionController;
	}
	
	/**
	 * Create a Coupler & Mullions class configuration panel
	 *
	 * @param myParent, ItemFrame
	 */
	public CouplerAndMullionPanel(ItemFrame myParent) {
		
		//Setting ItemFrame parent
		this.myParent = myParent;
		
		//Init controller
		couplerMullionController = new CouplerMullionPanelController();
		
		//Init components Layout
		initComponentsLayout();
		
		//Init components values
		initComponentsValues();
		
		//Register listeners
		registerListeners();
		
		//Setting selected level
		selectedLevel = 1;
		
		enableDisableBySeries();
	}

	public void enableDisableBySeries()	{
	
		if(!this.myParent.mySeries.isManualMC()){
			this.extend.setEnabled(false);
		}
		
		if(!this.myParent.mySeries.isManualMET()){
			this.endTypeLT.setEnabled(false);
			this.endTypeRB.setEnabled(false);
		}
		
		if(!this.myParent.mySeries.isManualMP()){
			this.part.setEnabled(false);
		}
		
		if(!this.myParent.mySeries.isManualMET() && !this.myParent.mySeries.isManualMP() ){
			this.edit.setEnabled(false);
		}

		this.myParent.validate();
		this.myParent.repaint();
	}
	
	private void initComponentsLayout() {
		
		//***********************************************
		//Setting icons
		//***********************************************
		vC.setIcon(ItemFrame.iconFiles.get("vc"));
		hC.setIcon(ItemFrame.iconFiles.get("hc"));
		vM.setIcon(ItemFrame.iconFiles.get("vm"));
		hM.setIcon(ItemFrame.iconFiles.get("hm"));
		edit.setIcon(ItemFrame.iconFiles.get("edit"));
		extend.setIcon(ItemFrame.iconFiles.get("extend"));
		
		//************************************************
		//Setting tooltipText
		//************************************************
		vC.setToolTipText("Vertical Coupler");
		hC.setToolTipText("Horizontal Coupler");
		vM.setToolTipText("Vertical Mullion");
		hM.setToolTipText("Horizontal Mullion");
		edit.setToolTipText("Edit Mullion Properties");
		extend.setToolTipText("Extend/Join Mullions");
		
		//************************************************
		//Setting buttons options
		//************************************************
//		vC.setEnabled(false);
//		hC.setEnabled(false);
		parts.setEnabled(false);
		lCut.setEnabled(false);
		rCut.setEnabled(false);
		pfCombo.setEnabled(false);
		
		//Initialize edit button group
		editGroup.add(edit);
		editGroup.add(extend);
		
		
		//************************************************
		//Config panels
		//************************************************
		
		//Config editor basic settings
		editor.setBorder(BorderFactory.createEtchedBorder());
		editor.setPreferredSize(new Dimension(198, 195));
		editor.setLayout(new XYLayout());
		
		//Config which feature
		whichFeature.setBorder(BorderFactory.createEtchedBorder());
		whichFeature.setPreferredSize(new Dimension(198, 48));
		whichFeature.setLayout(new XYLayout());
		whichFeature.add(vC, new XYConstraints(2, 0, 24, 19));
		whichFeature.add(hC, new XYConstraints(27, 0, 24, 19));
		whichFeature.add(vM, new XYConstraints(55, 0, 24, 19));
		whichFeature.add(hM, new XYConstraints(81, 0, 24, 19));
		
		//Config basic setting coupler mullions menu panel
		couplerMullionPanel.setLayout(new BorderLayout());
		couplerMullionPanel.setPreferredSize(new Dimension(200, 312));
		couplerMullionPanel.add(whichFeature, BorderLayout.NORTH);
		couplerMullionPanel.add(editor, BorderLayout.CENTER);
		
		enableDisableBySeries();
	}
	
	private void initComponentsValues() {}
	
	/**
	 * Register Listeners events components
	 */
	private void registerListeners() {
		
		//Vertical coupler action listener
		vC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//divide facet option FALSE
				divideFacet = false;
				//Edit button not enabled for couplers
				edit.setEnabled(false);
				//Extend button not enabled for couplers
				extend.setEnabled(false);
				//Setting cursor icon configuration for vertical coupler
				buttonAction(ValidOrientations.VERTICAL.getValue());
				//MType for couplers equals 1
				mType = ValidCouplerMullions.COUPLER.getValue();
				//Semaphore vertical coupler option
				selectedHV = ValidOrientations.VERTICAL.getValue();
				//Semaphore level selected
				selectedLevel = ValidCouplerMullions.COUPLER.getValue();

                //Filter valid coupler verticals
                List<TypeCouplerMullion> validCouplers = couplerMullionController.filterCouplerMullion(ValidCouplerMullions.COUPLER.getValue(),
                        ValidOrientations.VERTICAL.getValue());

                List<TypeCouplerMullion> validDividers = couplerMullionController.filterCouplerMullion(ValidCouplerMullions.DIVIDER.getValue(),
                        ValidOrientations.VERTICAL.getValue());

                validCouplers.addAll(validDividers);

                //Init coupler types comboBox
				DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(validCouplers.toArray());
                couplerTypeC.setModel(comboBoxModel);
				couplerTypeC.setSelectedIndex(0);
				
				//Remove components options which feature
				whichFeature.remove(couplerTypeC);
				whichFeature.remove(edit);
				whichFeature.remove(extend);
				
				whichFeature.add(couplerTypeC, new XYConstraints(2, 22, 180, 19));
				
				whichFeature.validate();
				whichFeature.repaint();
			}
		});
		
		//Horizontal coupler action listener
		hC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Semaphore divide facet option FALSE
				divideFacet = false;
				//Edit button disabled for horizontal coupler
				edit.setEnabled(false);
				//Extend button disabled for horizontal coupler
				extend.setEnabled(false);
				//Semaphore level selected
				selectedLevel = ValidCouplerMullions.COUPLER.getValue();
				//Setting cursor icon configuration for horizontal coupler
				buttonAction(ValidOrientations.HORIZONTAL.getValue());
				//MType for couplers equals 1
				mType = ValidCouplerMullions.COUPLER.getValue();
				//Semaphore horizontal coupler option
				selectedHV = ValidOrientations.HORIZONTAL.getValue();
				
				//Filter valid coupler verticals
				List<TypeCouplerMullion> validCouplers = couplerMullionController.filterCouplerMullion(ValidCouplerMullions.COUPLER.getValue(),
							ValidOrientations.HORIZONTAL.getValue());
				
				//Init coupler types comboBox
				DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(validCouplers.toArray());
                couplerTypeC.setModel(comboBoxModel);
                couplerTypeC.setSelectedIndex(0);
				
				//Remove components options which feature
				whichFeature.remove(couplerTypeC);
				whichFeature.remove(edit);
				whichFeature.remove(extend);
				
				whichFeature.add(couplerTypeC, new XYConstraints(2, 22, 180, 19));
				
				whichFeature.validate();
				whichFeature.repaint();
			}
		});
		
		vM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//myParent.clearCMAlignEdit();
				divideFacet = false;
				//MType for mullions equals 2
				mType = ValidCouplerMullions.MULLION.getValue();
				//Vertical mullions position
				selectedHV = ValidOrientations.VERTICAL.getValue();
				//Level selected for mullions
				selectedLevel = ValidCouplerMullions.MULLION.getValue();
				//Edit button enabled for vertical mullions
				buttonAction(ValidOrientations.VERTICAL.getValue());
				//Extends button enabled for vertical mullions
				enableDisableBySeries();
				
				//Filter valid coupler verticals
				List<TypeCouplerMullion> validMullions = couplerMullionController.filterCouplerMullion(ValidCouplerMullions.MULLION.getValue(),
							ValidOrientations.VERTICAL.getValue());
				
				//Init mullion types comboBox
                DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(validMullions.toArray());
                couplerTypeC.setModel(comboBoxModel);
                couplerTypeC.setSelectedIndex(0);

                whichFeature.remove(couplerTypeC);

				whichFeature.add(edit, new XYConstraints(132, 0, 24, 19));
				whichFeature.add(extend, new XYConstraints(156, 0, 24, 19));
                whichFeature.add(couplerTypeC, new XYConstraints(2, 22, 180, 19));
				
				whichFeature.validate();
				whichFeature.repaint();
			}
		});
		
		hM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//myParent.clearCMAlignEdit();
				divideFacet = false;
				//MType for mullions equals 2
				mType = ValidCouplerMullions.MULLION.getValue();
				//Horizontal mullions position
				selectedHV = ValidOrientations.HORIZONTAL.getValue();
				//Selected level for mullions equals 2
				selectedLevel = ValidCouplerMullions.MULLION.getValue();
				//Edit panel enabled for mullions
				enableDisableBySeries();
				buttonAction(ValidOrientations.HORIZONTAL.getValue());
				//Filter valid coupler verticals
				List<TypeCouplerMullion> validMullions = couplerMullionController.filterCouplerMullion(ValidCouplerMullions.MULLION.getValue(),
							ValidOrientations.HORIZONTAL.getValue());

                //Init mullion types comboBox
                DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(validMullions.toArray());
                couplerTypeC.setModel(comboBoxModel);
                couplerTypeC.setSelectedIndex(0);

                whichFeature.remove(couplerTypeC);

				whichFeature.add(edit, new XYConstraints(132, 0, 24, 19));
				whichFeature.add(extend, new XYConstraints(156, 0, 24, 19));
                whichFeature.add(couplerTypeC, new XYConstraints(2, 22, 180, 19));
				
				whichFeature.validate();
				whichFeature.repaint();
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Setting edit visible
				setEditVisible(false, null);
				
				if (hM.isSelected() || vM.isSelected()) {
					enableDisableBySeries();
				} else if (hC.isSelected() || vC.isSelected()) {
					enableDisableBySeries();
				}
			}
		});
		
		//Edit mullions action listener
		edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				extend.setSelected(false);
				edit.setSelected(true);
				
				//Call edit action event
				edit_actionPerformed(e);
			}
		});
		
		pfCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboPF(true);
			}
		});
		
		//Coupler type comboBox listener
		this.couplerTypeC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				coupleTypeAction();
			}
		});
		
		this.part.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (part.isSelected()) {
					parts.setEnabled(true);
					setGo.setEnabled(true);
				} else {
					parts.setEnabled(false);
					if (!endTypeLT.isSelected() && !endTypeRB.isSelected() && !pfFormL.isSelected()) {
						setGo.setEnabled(false);
					}
				}
			}
		});
		
		this.extend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				extend.setSelected(true);
				edit.setSelected(false);
				cont_actionPerformed(e);
			}
		});
		
		endTypeLT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (endTypeLT.isSelected()) {
					lCut.setEnabled(true);
					setGo.setEnabled(true);
				} else {
					lCut.setEnabled(false);
					if (!part.isSelected() && !endTypeRB.isSelected() && !pfFormL.isSelected()) {
						setGo.setEnabled(false);
					}
				}
			}
		});
		
		endTypeRB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (endTypeRB.isSelected()) {
					rCut.setEnabled(true);
					setGo.setEnabled(true);
				} else {
					rCut.setEnabled(false);
					if (!endTypeLT.isSelected() && !part.isSelected() && !pfFormL.isSelected()) {
						setGo.setEnabled(false);
					}
				}
			}
		});
		
		pfFormL.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (pfFormL.isSelected()) {
					pfCombo.setEnabled(true);
					offsetLT.setEnabled(true);
					offsetRB.setEnabled(true);
					deltaL.setEnabled(true);
					deltaR.setEnabled(true);
					offsetL.setEnabled(true);
					offsetR.setEnabled(true);
					setGo.setEnabled(true);
				} else {
					pfCombo.setEnabled(false);
					offsetLT.setEnabled(false);
					offsetRB.setEnabled(false);
					deltaL.setEnabled(false);
					deltaR.setEnabled(false);
					offsetL.setEnabled(false);
					offsetR.setEnabled(false);
					if (!endTypeLT.isSelected() && !part.isSelected() && !part.isSelected()) {
						setGo.setEnabled(false);
					}
				}
			}
		});
		
		setGo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				set_actionPerformed(e);
			}
		});
	}
	
	/**
	 * Configuring and Adding editor panel to coupler mullions panel menu
	 */
	private void initEditorPanel() {
		
		//Remove all components from panel
		this.editor.removeAll();
		
		//Redraw which feature
		this.whichFeature.validate();
		this.whichFeature.repaint();
		
		//Setting icon values
		partL.setIcon(myParent.editor.profileImage);
		endTypeLTL.setIcon(myParent.editor.ltImage);
		endTypeRBL.setIcon(myParent.editor.rbImage);
		pfFormLL.setIcon(myParent.profileshapeImage);
		setGo.setIcon(myParent.setImage);
		cancel.setIcon(myParent.cancelImage);
		
		//Setting values visibility
		part.setVisible(false);
		partL.setVisible(false);
		parts.setVisible(false);
		
		endTypeLT.setVisible(false);
		endTypeLTL.setVisible(false);
		lCut.setVisible(false);
		endTypeRB.setVisible(false);
		endTypeRBL.setVisible(false);
		rCut.setVisible(false);
		pfFormL.setVisible(false);
		pfFormLL.setVisible(false);
		pfCombo.setVisible(false);
		
		offsetL.setVisible(false);
		offsetR.setVisible(false);
		offsetLT.setVisible(false);
		offsetRB.setVisible(false);
		
		bL.setVisible(false);
		bR.setVisible(false);
		deltaL.setVisible(false);
		deltaR.setVisible(false);
		
		setGo.setVisible(false);
		cancel.setVisible(false);
		
		myParent.dim.masterSelected.setEnabled(false);
		myParent.dim.slaveSelected.setEnabled(false);
		myParent.dim.masterSelected.setVisible(false);
		myParent.dim.slaveSelected.setVisible(false);
		myParent.dim.doAlign.setVisible(false);
		myParent.dim.changeAlign.setVisible(false);
		myParent.dim.cancelAlign.setVisible(false);
		myParent.dim.doAlign.setEnabled(false);
		myParent.dim.changeAlign.setEnabled(false);
		
		myParent.alignSeq = 0;
		
		//Adding components to editor panel
		editor.add(part, new XYConstraints(1, 1, 20, 19));
		editor.add(partL, new XYConstraints(22, 1, 20, 19));
		editor.add(parts, new XYConstraints(42, 1, 140, 19));
		
		editor.add(endTypeLT, new XYConstraints(1, 23, 20, 19));
		editor.add(endTypeLTL, new XYConstraints(22, 23, 20, 19));
		editor.add(lCut, new XYConstraints(81, 23, 100, 19));
		
		editor.add(endTypeRB, new XYConstraints(1, 44, 20, 19));
		editor.add(endTypeRBL, new XYConstraints(22, 44, 20, 19));
		editor.add(rCut, new XYConstraints(81, 44, 100, 19));
		
		editor.add(pfFormL, new XYConstraints(1, 65, 20, 19));
		editor.add(pfFormLL, new XYConstraints(22, 65, 20, 19));
		editor.add(pfCombo, new XYConstraints(81, 65, 100, 19));
		
		editor.add(offsetL, new XYConstraints(1, 86, 50, 19));
		editor.add(offsetR, new XYConstraints(1, 107, 50, 19));
		editor.add(bL, new XYConstraints(1, 128, 50, 19));
		editor.add(bR, new XYConstraints(1, 149, 50, 19));
		
		editor.add(offsetLT, new XYConstraints(60, 86, 118, 19));
		editor.add(offsetRB, new XYConstraints(60, 107, 118, 19));
		
		editor.add(deltaL, new XYConstraints(60, 127, 118, 19));
		editor.add(deltaR, new XYConstraints(60, 147, 118, 19));
		
		editor.add(setGo, new XYConstraints(56, 168, 60, 19));
		editor.add(cancel, new XYConstraints(118, 168, 60, 19));
		
		editor.add(myParent.dim.masterSelected, new XYConstraints(1, 3, 120, 19));
		editor.add(myParent.dim.slaveSelected, new XYConstraints(1, 24,120, 19));
		
		editor.add(myParent.dim.doAlign, new XYConstraints(1, 50, 59, 19));
		editor.add(myParent.dim.changeAlign, new XYConstraints(61, 50, 59, 19));
		editor.add(myParent.dim.cancelAlign, new XYConstraints(121, 50, 59, 19));
	}
	
	public void buildGuidePanel() {
		
		part.setVisible(false);
		partL.setVisible(false);
		parts.setVisible(false);
		
		endTypeLT.setVisible(false);
		endTypeLTL.setVisible(false);
		lCut.setVisible(false);
		endTypeRB.setVisible(false);
		endTypeRBL.setVisible(false);
		rCut.setVisible(false);
		pfFormL.setVisible(false);
		pfFormLL.setVisible(false);
		
		offsetL.setVisible(false);
		offsetR.setVisible(false);
		offsetLT.setVisible(false);
		offsetRB.setVisible(false);
		
		bL.setVisible(false);
		bR.setVisible(false);
		deltaL.setVisible(false);
		deltaR.setVisible(false);
		
		setGo.setVisible(false);
		cancel.setVisible(false);
		
		myParent.dim.masterSelected.setVisible(true);
		myParent.dim.slaveSelected.setVisible(true);
		myParent.dim.doAlign.setVisible(true);
		myParent.dim.changeAlign.setVisible(true);
		myParent.dim.cancelAlign.setVisible(true);
	}
	
	/**
	 * Adding cut Items
	 */
	public void addCutItems() {
		lCut.addItem("Mitered x�");
		lCut.addItem("Straight Cut |");
		lCut.addItem("Machined/Profiled [");
		rCut.addItem("Mitered x�");
		rCut.addItem("Straight Cut |");
		rCut.addItem("Machined/Profiled [");
	}
	
	/**
	 * Set Edit visible
	 * @param visible, boolean
	 * @param myMullion, Profiles
	 */
	public void setEditVisible(boolean visible, Profiles myMullion) {
		
		// whichFeature.remove(info);
		whichFeature.validate();
		whichFeature.repaint();
		lCut.removeAllItems();
		rCut.removeAllItems();
		addCutItems();
		
		if (myMullion != null && visible) {
			
			parts.setSelectedIndex(myMullion.parentid - 1);
			lCut.setSelectedIndex(myMullion.endTypeLT - 1);
			rCut.setSelectedIndex(myMullion.endTypeRB - 1);
			
			if (myMullion.partForm > 2) {
				pfCombo.setSelectedIndex(myMullion.partForm - 1);
			} else if (myMullion.partForm == 1 && myMullion.offsetRB == 0 && myMullion.offsetTL == 0) {
				pfCombo.setSelectedIndex(0);
			} else if (myMullion.partForm == 1 && myMullion.offsetRB != 0 && myMullion.offsetTL != 0) {
				pfCombo.setSelectedIndex(0);
			}
			
			offsetLT.setText(myMullion.offsetTL + "");
			offsetRB.setText(myMullion.offsetRB + "");
			deltaL.setText(myMullion.deltaTL + "");
			deltaR.setText(myMullion.deltaRB + "");
			
			part.setVisible(visible);
			partL.setVisible(visible);
			parts.setVisible(visible);
			
			endTypeLT.setVisible(visible);
			endTypeLTL.setVisible(visible);
			lCut.setVisible(visible);
			endTypeRB.setVisible(visible);
			endTypeRBL.setVisible(visible);
			rCut.setVisible(visible);
			pfFormL.setVisible(visible);
			pfFormLL.setVisible(visible);
			pfCombo.setVisible(visible);
			
			offsetL.setVisible(false);
			offsetR.setVisible(false);
			offsetLT.setVisible(false);
			offsetRB.setVisible(false);
			bL.setVisible(false);
			bR.setVisible(false);
			deltaL.setVisible(false);
			deltaR.setVisible(false);
			
			setGo.setVisible(visible);
			cancel.setVisible(visible);
			setGo.setEnabled(false);
			
		} else if (!visible) {
			
			part.setVisible(visible);
			partL.setVisible(visible);
			parts.setVisible(visible);
			
			endTypeLT.setVisible(visible);
			endTypeLTL.setVisible(visible);
			lCut.setVisible(visible);
			endTypeRB.setVisible(visible);
			endTypeRBL.setVisible(visible);
			rCut.setVisible(visible);
			pfFormL.setVisible(visible);
			pfFormLL.setVisible(visible);
			pfCombo.setVisible(visible);
			offsetLT.setVisible(visible);
			offsetRB.setVisible(visible);
			offsetL.setVisible(visible);
			offsetR.setVisible(visible);
			deltaL.setVisible(visible);
			deltaR.setVisible(visible);
			setGo.setVisible(visible);
			cancel.setVisible(visible);
			
		}
		
		hideExtend();
	}
	
	public void hideExtend() {
		
		edit.setSelected(false);
		extend.setSelected(false);
		edit.repaint();
		extend.repaint();
		
		myParent.dim.masterSelected.setVisible(false);
		myParent.dim.slaveSelected.setVisible(false);
		// myParent.dim.masterSelectedL.setVisible(false);
		// myParent.dim.slaveSelectedL.setVisible(false);
		myParent.dim.masterSelected.setSelected(false);
		myParent.dim.slaveSelected.setSelected(false);
		myParent.dim.doAlign.setVisible(false);
		myParent.dim.changeAlign.setVisible(false);
		myParent.dim.cancelAlign.setVisible(false);
		
		vC.setSelected(false);
		hC.setSelected(false);
		vC.setEnabled(true);
		hC.setEnabled(true);
		
		whichFeature.repaint();
		
	}
	
	public void setEditEnabled(int type) {
		
		whichFeature.validate();
		whichFeature.repaint();
		setGo.setEnabled(true);
		parts.setEnabled(false);
		
		lCut.setEnabled(false);
		rCut.setEnabled(false);
		pfCombo.setEnabled(false);
		
		if (type == 1) {
			
			parts.setEnabled(true);
			lCut.setEnabled(false);
			rCut.setEnabled(false);
			pfCombo.setEnabled(false);
			offsetLT.setEnabled(false);
			offsetRB.setEnabled(false);
			deltaL.setEnabled(false);
			deltaR.setEnabled(false);
			offsetLT.setVisible(false);
			offsetRB.setVisible(false);
			deltaL.setVisible(false);
			deltaR.setVisible(false);
			offsetL.setEnabled(false);
			offsetR.setEnabled(false);
			
		} else if (type == 2) {
			
			parts.setEnabled(false);
			lCut.setEnabled(false);
			rCut.setEnabled(false);
			pfCombo.setEnabled(false);
			offsetLT.setEnabled(false);
			offsetRB.setEnabled(false);
			deltaL.setEnabled(false);
			deltaR.setEnabled(false);
			offsetLT.setVisible(false);
			offsetRB.setVisible(false);
			deltaL.setVisible(false);
			deltaR.setVisible(false);
			offsetL.setEnabled(false);
			offsetR.setEnabled(false);
			
		} else if (type == 3) {
			lCut.setEnabled(true);
		} else if (type == 4) {
			rCut.setEnabled(true);
		} else if (type == 5) {
			
			pfCombo.setEnabled(true);
			offsetLT.setEnabled(true);
			offsetRB.setEnabled(true);
			deltaL.setEnabled(true);
			deltaR.setEnabled(true);
			offsetL.setEnabled(true);
			offsetR.setEnabled(true);
		}
	}
	
	private void comboPF(final boolean visible) {
		
		if (pfCombo.getSelectedIndex() == 1) {
			offsetL.setVisible(visible);
			offsetR.setVisible(visible);
			offsetLT.setVisible(visible);
			offsetRB.setVisible(visible);
			bL.setVisible(false);
			bR.setVisible(false);
			deltaL.setVisible(false);
			deltaR.setVisible(false);
		}
		
		if (pfCombo.getSelectedIndex() == 0) {
			offsetL.setVisible(false);
			offsetR.setVisible(false);
			offsetLT.setVisible(false);
			offsetRB.setVisible(false);
			bL.setVisible(false);
			bR.setVisible(false);
			deltaL.setVisible(false);
			deltaR.setVisible(false);
			
		}
		
		if (pfCombo.getSelectedIndex() >= 2) {
			JOptionPane.showMessageDialog(null, "Curved Mullions are not currently available:"
						+ "\n Please contact your supplier to request this features!", "Unavailable feature",
						JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Edit Action Performed button for mullions
	 *
	 * @param e, ActionEvent
	 */
	public void edit_actionPerformed(ActionEvent e) {
		
		if (edit.isSelected()) {
			
			editor.validate();
			editor.repaint();
			
			//Reset edit components values
			resetEdit();
			
			//Configure editor panel
			initEditorPanel();
			
			myParent.editCM = true;
			myParent.extendCM = false;
			myParent.mullionsPanel.selectedHV = 0;

            //Setting type action event
            myParent.setActionTypeEvent(MenuActionEventDraw.EDIT_COUPLER_MULLION.getValue());
			
			vC.setSelected(false);
			hC.setSelected(false);
			vC.setEnabled(false);
			hC.setEnabled(false);
			
			couplerTypeC.setEnabled(false);
			
			edit.setEnabled(false);
			cancel.setVisible(true);
			cancel.setEnabled(true);
			this.enableDisableBySeries();
			
			whichFeature.validate();
			whichFeature.repaint();
		}
	}
	
	/**
	 * Options selection for semaphores options
	 *
	 * @param e, ActionEvent
	 */
	public void cont_actionPerformed(ActionEvent e) {
		
		//Reset align to ItemFrame
		myParent.resetAlign();
		
		initEditorPanel();
		this.buildGuidePanel();
		myParent.editCM = false;
		myParent.alignH = false;
		myParent.alignV = false;
		myParent.extendCM = true;
		myParent.mullionsPanel.selectedHV = 0;

        myParent.setActionTypeEvent(MenuActionEventDraw.EXTEND_COUPLER_MULLION.getValue());

		vC.setSelected(false);
		hC.setSelected(false);
		vC.setEnabled(false);
		hC.setEnabled(false);
	}
	
	/**
	 * Reset values for Edit Panel components
	 */
	public void resetEdit() {
		
		extend.setSelected(false);
		part.setSelected(false);
		endTypeLT.setSelected(false);
		endTypeRB.setSelected(false);
		pfFormL.setSelected(false);
		
		parts.setSelectedIndex(0);
		
		lCut.setSelectedIndex(0);
		rCut.setSelectedIndex(0);
		pfCombo.setSelectedIndex(0);
		
		mullionPartForm = 1;
		
		endLT = 0;
		endRB = 0;
		offsetTL = 0; // offset from center (- or +)
		offsetBR = 0;
		deltaTL = 0;
		deltaRB = 0;
		curveCenterTL = 0;
		curveCenterRB = 0;
		
		partID = 0;
		mullionThick = 0;
		mullionBtoC = 0;
		mullionC = 0;
		mullionA = 0;
		
		
		enableDisableBySeries();
	}
	
	public void set_actionPerformed(final ActionEvent e) {
		
		BigDecimal myScale = new BigDecimal(0);
		
		if (myParent.myTopPanel.metric.isSelected()) {
			myScale = myParent.scale.multiply(new BigDecimal(100));
		} else {
			myScale = myParent.scale;
		}
		
		if (pfFormL.isSelected()) {
			if (pfCombo.getSelectedIndex() < 1) {
				mullionPartForm = 1;
			} else if (pfCombo.getSelectedIndex() == 2) {
				mullionPartForm = 3;
			} else if (pfCombo.getSelectedIndex() == 3) {
				mullionPartForm = 2;
			}
			
			if (myParent.myTopPanel.metric.isSelected()) {
				offsetTL = Double.valueOf(offsetLT.getText()) * myScale.doubleValue();
				offsetBR = Double.valueOf(offsetRB.getText()) * myScale.doubleValue();
				deltaTL = Double.valueOf(deltaL.getText()) * myScale.doubleValue();
				deltaRB = Double.valueOf(deltaR.getText()) * myScale.doubleValue() * 64;
			} else if (myParent.myTopPanel.impDec.isSelected()) {
				offsetTL = Double.valueOf(offsetLT.getText()) * myScale.doubleValue() * 64;
				offsetBR = Double.valueOf(offsetRB.getText()) * myScale.doubleValue() * 64;
				deltaTL = Double.valueOf(deltaL.getText()) * myScale.doubleValue() * 64;
				deltaRB = Double.valueOf(deltaR.getText()) * myScale.doubleValue() * 64;
			} else if (myParent.myTopPanel.impFrac.isSelected()) {
				try {
					offsetTL = Double.valueOf(UOMConvert.fractionToImperial(offsetLT.getText())) * myScale.doubleValue() * 64;
					offsetBR = Double.valueOf(UOMConvert.fractionToImperial(offsetRB.getText())) * myScale.doubleValue() * 64;
					deltaTL = Double.valueOf(UOMConvert.fractionToImperial(deltaL.getText())) * myScale.doubleValue() * 64;
					deltaRB = Double.valueOf(UOMConvert.fractionToImperial(deltaR.getText())) * myScale.doubleValue() * 64;
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		if (lCut.getSelectedIndex() >= 0 && endTypeLT.isSelected()) {
			endLT = lCut.getSelectedIndex() + 1;
			
			if (myParent.HorV == 2 && lCut.getSelectedIndex() + 1 == 2) {
				endLT = 3;
			}
			if (myParent.editingMullion.startIn && lCut.getSelectedIndex() == 1) {
				endLT = 3;
			}
			if (!myParent.editingMullion.startIn && myParent.editingMullion.myParent.top1.partForm != 1
						|| myParent.editingMullion.myParent.noSidesTop > 1 && endLT == 2) {
				endLT = 3;
			}
		}
		if (rCut.getSelectedIndex() >= 0 && endTypeRB.isSelected()) {
			endRB = rCut.getSelectedIndex() + 1;
			if (myParent.HorV == 2 && rCut.getSelectedIndex() + 1 == 2) {
				endRB = 3;
			}
			if (myParent.editingMullion.endIn && rCut.getSelectedIndex() == 1) {
				endRB = 3;
				
			}
			if (!myParent.editingMullion.endIn && myParent.editingMullion.myParent.bot1.partForm != 1
						|| myParent.editingMullion.myParent.noSidesBot > 1 && endRB == 2) {
				endRB = 3;
			}
		}
		
		if (isSashMullion) {
			if (endRB == 2) {
				endRB = 3;
			}
			if (endLT == 2) {
				endLT = 3;
			}
		}
		
		curveCenterTL = 0;
		curveCenterRB = 0;
		
		if (parts.getSelectedIndex() >= 0 && part.isSelected()) {
			partID = parts.getSelectedIndex() + 1;
			mullionThick = 3;
			mullionBtoC = 1.5f;
			mullionC = 12;
			mullionA = 12;
		}
		
		this.setEditVisible(false, null);
		myParent.setChangeMullion();
		edit.setSelected(false);
		vC.setEnabled(true);
		hC.setEnabled(true);
		
		resetEdit();
	}
	
	/**
	 * Defining type of action to execute for coupler selection
	 */
	public void coupleTypeAction() {
		
		//Get arrays of facets
		Object[] facets = myParent.jobItem.design.frames.toArray();
		
		for (Object f : facets) {
			
			//Facet has vertical and horizontal mullions
			if (((Facet) f).bOpeningObject.mullions.size() > 0 || ((Facet) f).bOpeningObject.mullionsH.size() > 0) {
				this.okToUse = false;
			}
			
			//Facet has background opening internal and vertical and horizontal mullions
			if (((Facet) f).bOpeningObjectIn != null && (((Facet) f).bOpeningObjectIn.mullions.size() > 0 ||
						((Facet) f).bOpeningObjectIn.mullionsH.size() > 0)) {
				this.okToUse = false;
			}
			
			//Facet has background opening output and vertical and horizontal mullions
			if (((Facet) f).bOpeningObjectOut != null && (((Facet) f).bOpeningObjectOut.mullions.size() > 0 ||
						((Facet) f).bOpeningObjectOut.mullionsH.size() > 0)) {
				this.okToUse = false;
			}
			
			//Get array of frames from facet
			Object[] frames = ((Facet) f).frames.toArray();
			
			for (Object ff : frames) {
				
				//Axis x columns or Axis y columns is more than one
				if (((Frame) ff).xCols > 1 || ((Frame) ff).yRows > 1) {
					this.okToUse = false;
				}
				
				//Get array of opening from frame
				Object[] os = ((Frame) ff).openings.toArray();
				
				for (Object o : os) {
					
					//Content mid from opening is more than 1
					if (((OpeningObject) o).contentMid > 1) {
						this.okToUse = false;
					}
					//Content in from opening is more than 1
					if (((OpeningObject) o).contentIn > 1) {
						this.okToUse = false;
					}
					//Content out from opening is more than 1
					if (((OpeningObject) o).contentOut > 1) {
						this.okToUse = false;
					}
				}
			}
		}
		
		//Setting default values configuration
		this.divideFacet = false;
		this.isFixedAngle = true;
		this.angle = 180;
		this.isPhantom = false;
		
		//Get selected coupler mullion selected
		TypeCouplerMullion typeCouplerMullion = (TypeCouplerMullion) couplerTypeC.getSelectedItem();
		
		this.typeID = typeCouplerMullion.getId().getId();
		
		// Clean parts selected from coupler mullion controller
		couplerMullionController.setPartsSelected(null);
		if(typeCouplerMullion.getType()==0){//Divider
			this.selectedLevel = 0; 
			this.divideFacet = true; 
		}else if(typeCouplerMullion.getType()==1){//Coupler
			this.selectedLevel = 1; 
		}else{
			this.selectedLevel = 2; 
		}
		
		if (typeCouplerMullion != null) {
			
			//Get angle from type coupler mullion
			this.angle = typeCouplerMullion.getAngle();
			//Find parts for coupler selected option
			couplerMullionController.findPartsForCouplerMullionSelected(typeCouplerMullion.getSupplierId(),
                    typeCouplerMullion.getPartId(), typeCouplerMullion.isRemote());
		}
		
		if (divideFacet && (myParent.layoutP.bow.isSelected() || myParent.layoutP.bay.isSelected())) {
			this.okToUse = false;
		}
	}
	
	/**
	 * Edit enabled panel
	 *
	 * @param enable, boolean
	 */
	public void editEnabled(boolean enable) {
		
		edit.setSelected(false);
		extend.setSelected(false);
		
		edit.setVisible(enable);
		extend.setVisible(enable);
		edit.setEnabled(enable);
		extend.setEnabled(enable);
	}

	/**
	 * Buttons actions feature selected
	 *
	 * @param selectedFeature, int
	 */
	public void buttonAction(int selectedFeature) {
		myParent.stopCustomCursor(this.couplerMullionPanel);
		
		this.myParent.setActionTypeEvent(1);
		
		if (selectedLevel == 1) {
			
			if (selectedFeature == 1) {
				myParent.myCursorImage = ItemFrame.iconFiles.get("vCouplerCursor");
				myParent.myCursor = myParent.toolkit.createCustomCursor(myParent.myCursorImage.getImage(), new Point(0, 0), "");
				myParent.startCustomCursor(myParent.main, myParent.myCursor);
			} else {
				myParent.myCursorImage = ItemFrame.iconFiles.get("hCouplerCursor");
				myParent.myCursor = myParent.toolkit.createCustomCursor(myParent.myCursorImage.getImage(), new Point(0, 0), "");
				myParent.startCustomCursor(myParent.main, myParent.myCursor);
			}
		} else {
			if (selectedFeature == 1) {
				myParent.myCursorImage = ItemFrame.iconFiles.get("vMullionCursor");
				myParent.myCursor = myParent.toolkit.createCustomCursor(myParent.myCursorImage.getImage(), new Point(0, 0), "");
				myParent.startCustomCursor(myParent.main, myParent.myCursor);
			} else {
				myParent.myCursorImage = ItemFrame.iconFiles.get("hMullionCursor");
				myParent.myCursor = myParent.toolkit.createCustomCursor(myParent.myCursorImage.getImage(), new Point(0, 0), "");
				myParent.startCustomCursor(myParent.main, myParent.myCursor);
			}
		}
		
		
	}

	public void rightMouseClick(final int id) {
		
		if (id == 3) {
			setButtonsFalse();
		}
	}
	
	public void setButtonsFalse() {
		vC.setSelected(false);
		hC.setSelected(false);
		
	}
	
}

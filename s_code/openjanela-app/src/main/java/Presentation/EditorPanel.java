/*******************************************************************************
 * Copyright (c) 2009, OpenJanela. All rights reserved.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Presentation;


import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import openjanela.model.entities.admin.TypeEndType;


import org.openjanela.data.MenuActionEventDraw;
import util.XYConstraints;
import util.XYLayout;
import Model.ProfileParts.Profiles;


public class EditorPanel {
	
	//ItemFrame parent
	public ItemFrame myParent;
	
	public JPanel editPanel = new JPanel();
	
	public String[] partStrings = {" Part Description 1", " Part Description 2", " Part Description 3", " Part Description 4",
	" Part Description 5"};
	public String[] lCutText = {"Mitered x°", "Straight Cut |", "Machined/Profiled ["};
	public String[] rCutText = {"Mitered x°", "Straight Cut |", "Machined/Profiled ]"};
	
	public JComboBox parts = new JComboBox(partStrings);
	public JComboBox lCut = new JComboBox(lCutText);
	public JComboBox rCut = new JComboBox(rCutText);
	
	public JCheckBox part = new JCheckBox();
	public JCheckBox endTypeLT = new JCheckBox();
	public JCheckBox endTypeRB = new JCheckBox();
	public JCheckBox sashLevel = new JCheckBox();
	public JCheckBox subSLevel = new JCheckBox();
	public JCheckBox isSash = new JCheckBox();
	
	public JButton setGo = new JButton();
	public JButton cancel = new JButton();
	public JButton edit = new JButton();
	public JButton removePart = new JButton();
	public JButton switchSash = new JButton();
	
	public ButtonGroup editLevel = new ButtonGroup();
	
	public JRadioButton frameLevel = new JRadioButton();
	public JRadioButton subFLevel = new JRadioButton();
	public JRadioButton fLevel = new JRadioButton();
	public JRadioButton sFLevel = new JRadioButton();
	
	public JLabel partL = new JLabel();
	public JLabel endTypeLTL = new JLabel();
	public JLabel endTypeRBL = new JLabel();
	public JLabel frameLevelLabel = new JLabel();
	public JLabel subFLevelLabel = new JLabel();
	public JLabel sashLevelLabel = new JLabel();
	public JLabel sashTip = new JLabel();
	public JLabel subSLevelLabel = new JLabel();
	public JLabel selectPart = new JLabel("Select Part");
	public JLabel isSashLabel = new JLabel();
	public JLabel frameLabel = new JLabel();
	public JLabel subLabel = new JLabel();
	
	public ImageIcon ltImage;
	public ImageIcon rbImage;
	public ImageIcon profileImage;
	public ImageIcon setImage;
	public ImageIcon cancelImage;
	
	public int selectedEditLevel = 1;
	
	public boolean editFrame = false;
	public boolean removeFrame = false;
	
	public EditorPanel(ItemFrame itemFrame) {
		
		this.myParent = itemFrame;
		
		ltImage = ItemFrame.iconFiles.get("lefttopend");
		rbImage = ItemFrame.iconFiles.get("rightbotend");
		
		profileImage = ItemFrame.iconFiles.get("part");
		
		setImage = ItemFrame.iconFiles.get("set");
		cancelImage = ItemFrame.iconFiles.get("cancel");
		
		editPanel.setBorder(BorderFactory.createEtchedBorder());
		editPanel.setLayout(new XYLayout());
		
		editPanel.setPreferredSize(new Dimension(199, 312));
		
		endTypeLT.setToolTipText("Left or Top End Type");
		endTypeRB.setToolTipText("Right or Bottom End Type");
		
		edit.setToolTipText("Edit Profile");
		
		removePart.setIcon(ItemFrame.iconFiles.get("removeM"));
		
		removePart.setToolTipText("Remove Profile");
		
		edit.setIcon(ItemFrame.iconFiles.get("edit"));
		selectPart.setVisible(false);
		
		editLevel.add(frameLevel);
		
		editLevel.add(subFLevel);
		
		subSLevel.setEnabled(false);
		
		frameLevelLabel.setIcon(ItemFrame.iconFiles.get("framelevel"));
		
		subFLevelLabel.setIcon(ItemFrame.iconFiles.get("sublevel"));
		
		sashLevelLabel.setIcon(ItemFrame.iconFiles.get("sashdims"));
		
		subSLevelLabel.setIcon(ItemFrame.iconFiles.get("subsash"));
		
		cancel.setIcon(cancelImage);
		
		setGo.setIcon(setImage);
		
		frameLevelLabel.setToolTipText("Frame");
		subFLevelLabel.setToolTipText("Sub Frame");
		sashLevelLabel.setToolTipText("Sash");
		subSLevelLabel.setToolTipText("Sub Sash");
		frameLevel.setToolTipText("Frame");
		subFLevel.setToolTipText("Sub Frame");
		sashLevel.setToolTipText("Sash");
		subSLevel.setToolTipText("Sub Sash");
		
		editPanel.add(frameLevel, new XYConstraints(2, 0, 20, 19));
		editPanel.add(frameLevelLabel, new XYConstraints(24, 0, 20, 19));
		
		editPanel.add(subFLevel, new XYConstraints(45, 0, 20, 19));
		editPanel.add(subFLevelLabel, new XYConstraints(67, 0, 20, 19));
		
		editPanel.add(sashLevel, new XYConstraints(88, 0, 20, 19));
		editPanel.add(sashLevelLabel, new XYConstraints(110, 0, 20, 19));
		editPanel.add(subSLevel, new XYConstraints(132, 0, 20, 19));
		editPanel.add(subSLevelLabel, new XYConstraints(154, 0, 20, 19));
		
		frameLevel.setSelected(true);
		editPanel.add(edit, new XYConstraints(2, 22, 40, 19));
		editPanel.add(removePart, new XYConstraints(44, 22, 40, 19));
		editPanel.add(selectPart, new XYConstraints(90, 22, 100, 19));
		partL.setIcon(profileImage);
		editPanel.add(part, new XYConstraints(1, 65, 20, 19));
		editPanel.add(partL, new XYConstraints(22, 65, 30, 19));
		editPanel.add(parts, new XYConstraints(1, 87, 180, 19));
		parts.setSelectedIndex(0);
		editPanel.add(endTypeLT, new XYConstraints(1, 116, 20, 19));
		endTypeLTL.setIcon(ltImage);
		editPanel.add(endTypeLTL, new XYConstraints(22, 116, 30, 19));
		editPanel.add(lCut, new XYConstraints(61, 116, 120, 19));
		editPanel.add(endTypeRB, new XYConstraints(1, 137, 20, 19));
		endTypeRBL.setIcon(rbImage);
		editPanel.add(endTypeRBL, new XYConstraints(22, 137, 30, 19));
		editPanel.add(rCut, new XYConstraints(61, 137, 120, 19));
		lCut.setSelectedIndex(0);
		rCut.setSelectedIndex(0);
		editPanel.add(setGo, new XYConstraints(56, 170, 60, 19));
		editPanel.add(cancel, new XYConstraints(118, 170, 60, 19));
		
		part.setEnabled(false);
		parts.setEnabled(false);
		endTypeLT.setEnabled(false);
		lCut.setEnabled(false);
		endTypeRB.setEnabled(false);
		rCut.setEnabled(false);
		setGo.setEnabled(false);
		cancel.setEnabled(false);
		
		setEnabledBySeries();
		
		edit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				myParent.myCursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
				
				selectPart.setVisible(true);
				myParent.jobItem.myCanvas.setCursor(myParent.myCursor);
				removeFrame = false;
				editFrame = true;

                myParent.setActionTypeEvent(MenuActionEventDraw.EDIT_FRAME.getValue());

				edit.setEnabled(false);
				removePart.setEnabled(false);
				cancel.setVisible(true);
				cancel.setEnabled(true);
			}
		});
		
		removePart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// setEditEnabled(true);
				// selectPart.setVisible(true);
				myParent.myCursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
				
				selectPart.setVisible(true);
				myParent.jobItem.myCanvas.setCursor(myParent.myCursor);
				editFrame = false;
				removeFrame = true;

                myParent.setActionTypeEvent(MenuActionEventDraw.REMOVE_FRAME.getValue());

				edit.setEnabled(false);
				removePart.setEnabled(false);
			}
		});
		
		setGo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				myParent.set_actionPerformed(e);
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				cancelAction();
			}
		});
		
		part.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (part.isSelected()) {
					setEditEnabled(true, 1);
				} else {
					setEditEnabled(false, 1);
				}
				
				if (endTypeLT.isSelected() || endTypeRB.isSelected() || part.isSelected()) {
					setGo.setVisible(true);
					setGo.setEnabled(true);
				} else {
					setGo.setEnabled(false);
				}
			}
		});
		
		endTypeLT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (endTypeLT.isSelected()) {
					
					setEditEnabled(true, 2);
				} else {
					setEditEnabled(false, 2);
				}
				if (endTypeLT.isSelected() || endTypeRB.isSelected() || part.isSelected()) {
					setGo.setVisible(true);
					setGo.setEnabled(true);
				} else {
					setGo.setEnabled(false);
				}
			}
		});
		
		endTypeRB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (endTypeRB.isSelected()) {
					
					setEditEnabled(true, 3);
				} else {
					setEditEnabled(false, 3);
				}
				if (endTypeLT.isSelected() || endTypeRB.isSelected() || part.isSelected()) {
					setGo.setVisible(true);
					setGo.setEnabled(true);
				} else {
					setGo.setEnabled(false);
				}
			}
		});
		
		frameLevel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setEnabledBySeries();
				sashLevel.setEnabled(true);
				sashLevel.setToolTipText("Edit Sash Profiles");
				
				selectedEditLevel = 1;
			}
			
		});
		
		subSLevel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(final ActionEvent e) {
				setEnabledBySeries();
				if (frameLevel.isSelected()) {
					
					selectedEditLevel = 3;
				} else if (subFLevel.isSelected()) {
					selectedEditLevel = 6;
				}
				
			}
			
		});
		
		subFLevel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				
				/*
				 * Check Why Sash Profile change not
				 * working
				 * Later paid customer
				 */
				
				setEnabledBySeries();
				
				 if (subFLevel.isSelected()) {
					 sashLevel.setEnabled(false);
					 sashLevel.setSelected(false);
					 sashLevel.setToolTipText("Not Available for Sub Frame, Contact Supplier");
				 } else {
					 sashLevel.setEnabled(true);
					 sashLevel.setToolTipText("edit Sash Profiles");
				 }
				 selectedEditLevel = 4;
				 
			}
			
		});
		
		sashLevel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(final ActionEvent e) {
				setEnabledBySeries();
				if (frameLevel.isSelected()) {
					selectedEditLevel = 2;
				} else if (subFLevel.isSelected()) {
					selectedEditLevel = 5;
				}
				
			}
			
		});
		
		
		setEnabledBySeries();


	}

	public void setEnabledBySeries()
	{
		if(!myParent.mySeries.isEditP()){
			this.edit.setEnabled(false);
		}
		if(!myParent.mySeries.isRemoveP()){
			this.removePart.setEnabled(false);
		}
	
		if(!myParent.mySeries.isSubSash()){
			this.subSLevel.setEnabled(false);
		}
		if(!myParent.mySeries.isSubFrame()){
			this.subFLevel.setEnabled(false);
		}
		if(!myParent.mySeries.isManualFET()){
			if(this.frameLevel.isSelected()){
				this.endTypeLT.setEnabled(false);
				this.endTypeRB.setEnabled(false);
			}
		}
		if(!myParent.mySeries.isManualSET()){
			if(this.sashLevel.isSelected()){
				this.endTypeLT.setEnabled(false);
				this.endTypeRB.setEnabled(false);
			}
		}
		if(!myParent.mySeries.isManualSFET()){
			if(this.subFLevel.isSelected()){
				this.endTypeLT.setEnabled(false);
				this.endTypeRB.setEnabled(false);
			}
		}
		if(!myParent.mySeries.isManualSSET()){
			if(this.subFLevel.isSelected() && this.sashLevel.isSelected()){
				this.endTypeLT.setEnabled(false);
				this.endTypeRB.setEnabled(false);
			}
		}

		
		if(!myParent.mySeries.isManualFPS()){
			if(this.frameLevel.isSelected()){
				this.part.setEnabled(false);
			}
		}
		if(!myParent.mySeries.isManualSPS()){
			if(this.sashLevel.isSelected()){
				this.part.setEnabled(false);
			}
		}
		if(!myParent.mySeries.isManualSFPS()){
			if(this.subFLevel.isSelected()){
				this.part.setEnabled(false);
			}
		}
		if(!myParent.mySeries.isManualSsPS()){
			if(this.subFLevel.isSelected() && this.sashLevel.isSelected()){
				this.part.setEnabled(false);
			}
		}
		
		this.myParent.validate();
		this.myParent.repaint();
	}
	
	public void setEditEnabled(final boolean enable, final int type) {
		
		if (type == 1) {
			parts.setEnabled(enable);
			
		}
		if (type == 2) {
			lCut.setEnabled(enable);
			
		}
		if (type == 3) {
			rCut.setEnabled(enable);
			
		}
		if (type == 4) {// cancel
			parts.setEnabled(false);
			lCut.setEnabled(false);
			rCut.setEnabled(false);
			setGo.setEnabled(false);
			part.setSelected(false);
			parts.setSelectedIndex(0);
			endTypeLT.setSelected(false);
			lCut.setSelectedIndex(0);
			endTypeRB.setSelected(false);
			rCut.setSelectedIndex(0);
			setGo.setSelected(false);
			cancel.setSelected(false);
			
			edit.setEnabled(true);
			
			removePart.setEnabled(true);
			
			selectPart.setVisible(false);
			part.setVisible(false);
			partL.setVisible(false);
			parts.setVisible(false);
			endTypeLT.setVisible(false);
			endTypeLTL.setVisible(false);
			lCut.setVisible(false);
			endTypeRB.setVisible(false);
			endTypeRBL.setVisible(false);
			rCut.setVisible(false);
			setGo.setVisible(false);
			cancel.setVisible(false);
			
		}
		
		setEnabledBySeries();
		
		if (endTypeLT.isSelected() || endTypeRB.isSelected() || part.isSelected()) {
			setGo.setVisible(true);
			setGo.setEnabled(true);
		}
		
	}
	
	public void setEditProfileVisible(boolean visible, Profiles p) {
		
		lCut.removeAllItems();
		rCut.removeAllItems();
		this.addCutItems();
		
		if (p != null && visible) {
			selectPart.setVisible(false);
			parts.setSelectedIndex(1);// (PartID)
			
			if (p.position <= 3) {
				lCut.setSelectedItem(ItemFrame.getApplicationBase().getEndType(p.endTypeRB));
				rCut.setSelectedItem(ItemFrame.getApplicationBase().getEndType(p.endTypeLT));
			} else if (p.position == 4) {
				lCut.setSelectedItem(ItemFrame.getApplicationBase().getEndType(p.endTypeRB));
				rCut.setSelectedItem(ItemFrame.getApplicationBase().getEndType(p.endTypeLT));
			} else if (p.position > 4 && p.position < 8) {
				lCut.setSelectedItem(ItemFrame.getApplicationBase().getEndType(p.endTypeLT));
				rCut.setSelectedItem(ItemFrame.getApplicationBase().getEndType(p.endTypeRB));
			} else {
				lCut.setSelectedItem(ItemFrame.getApplicationBase().getEndType(p.endTypeLT));
				rCut.setSelectedItem(ItemFrame.getApplicationBase().getEndType(p.endTypeRB));
			}
			
			part.setVisible(visible);
			part.setEnabled(visible);
			partL.setEnabled(visible);
			parts.setVisible(visible);
			endTypeLT.setVisible(visible);
			endTypeLTL.setVisible(visible);
			endTypeLT.setEnabled(visible);
			lCut.setVisible(visible);
			endTypeRB.setVisible(visible);
			endTypeRBL.setVisible(visible);
			rCut.setVisible(visible);
			
			endTypeRB.setEnabled(visible);
			
			setGo.setVisible(visible);
			cancel.setVisible(visible);
			
			cancel.setEnabled(visible);
			setGo.setEnabled(false);
			
			if (p != null && p.leftIn) {
				endTypeLT.setVisible(false);
				lCut.setVisible(false);
				endTypeLT.setEnabled(false);
				lCut.setEnabled(false);
			}
			
			if (p != null && p.rightIn) {
				endTypeRB.setVisible(false);
				rCut.setVisible(false);
				endTypeRB.setEnabled(false);
				rCut.setEnabled(false);
			}
			
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
			part.setEnabled(visible);
			parts.setEnabled(visible);
			endTypeLT.setEnabled(visible);
			lCut.setEnabled(visible);
			endTypeRB.setEnabled(visible);
			rCut.setEnabled(visible);
			
			setGo.setVisible(visible);
			cancel.setVisible(visible);
			setGo.setEnabled(visible);
			cancel.setEnabled(visible);
			
		}
		
	}
	
	public void addCutItems() {
		
		
		lCut.setModel(new DefaultComboBoxModel(ItemFrame.getApplicationBase().getTypeEndTypes().toArray()));
		rCut.setModel(new DefaultComboBoxModel(ItemFrame.getApplicationBase().getTypeEndTypes().toArray()));
		
		
//		lCut.addItem("Mitered x°");
//		lCut.addItem("Straight Cut |");
//		lCut.addItem("Machined/Profiled [");
//		
//		rCut.addItem("Mitered x°");
//		rCut.addItem("Straight Cut |");
//		rCut.addItem("Machined/Profiled [");
	}
	
	
	
	public void setRemoveVisible(final boolean visible) {
		
		setGo.setVisible(visible);
		cancel.setVisible(visible);
		setGo.setEnabled(visible);
		cancel.setEnabled(visible);
		
	}
	
	public void cancelAction()
	{
	
		edit.setSelected(false);
		setEditEnabled(false, 4);
		this.myParent.clearCMAlignEdit();
	}
	
	public int getSelectedEndTypeLT(){
		return ((TypeEndType) lCut.getSelectedItem()).getId();
	}
	
	public int getSelectedEndTypeRB(){
		return ((TypeEndType) rCut.getSelectedItem()).getId();
	}
	
}

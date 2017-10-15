/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani. All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/

package Presentation;

import Model.Facet;
import Model.Frame;
import Model.ProfileParts.Profiles;
import openjanela.app.configuration.controller.PredefineDesignController;
import openjanela.app.configuration.controller.TopPanelController;
import openjanela.model.entities.design.Metrics;
import openjanela.model.entities.partner.AdjustmentRo;
import openjanela.model.entities.parts.Parts;
import org.apache.log4j.Logger;
import org.openjanela.data.ApplicationBaseApp;
import util.UOMConvert;
import util.XYConstraints;
import util.XYLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;

public class TopPanel extends JPanel {

    // Apache log4j
    private static final Logger logger = Logger.getLogger(TopPanel.class);

    public ImageIcon widthImage;

    public ImageIcon oswidthImage;

    public ImageIcon locationImage;

    public ImageIcon heightImage;

    public ImageIcon ref1Image;

    public ImageIcon ref2Image;

    public ImageIcon uomImage;

    public ImageIcon osheightImage;

    public ImageIcon itemnoImage;

    public ImageIcon descriptionImage;

    public ImageIcon qtyImage;

    public ImageIcon selectDesignImage;

    public ImageIcon saveDesignImage;

    public ItemFrame myParent;

    public JLabel itemNoLabel = new JLabel();

    public JLabel descLabel = new JLabel();

    public JLabel qtyLabel = new JLabel();

    public JLabel labelUOM = new JLabel();

    public JLabel labelW = new JLabel();

    public JLabel labelH = new JLabel();

    public JLabel labelFlat = new JLabel();

    public JLabel labelWo = new JLabel();

    public JLabel labelHo = new JLabel();

    public JLabel byX = new JLabel("X");

    public JLabel byXos = new JLabel("X");

    public JLabel loc = new JLabel();

    public JLabel ref = new JLabel();

    public JLabel layoutLabel = new JLabel();

    public JTextField itemNo = new JTextField("N/A");

    public JTextField description = new JTextField("Custom Design");

    public JTextField qty = new JTextField("1");

    public JTextField fH = new JTextField("0.00");

    public JTextField fW = new JTextField("0.00");

    public JTextField oH = new JTextField("0.00");

    public JTextField oW = new JTextField("0.00");

    public JTextField flatW = new JTextField("0.00");

    public JTextField locationT = new JTextField();

    public JTextField location = new JTextField(" ");

    public JTextField reference = new JTextField(" ");

    public JRadioButton metric = new JRadioButton("mm");

    public JRadioButton impDec = new JRadioButton("i.00");

    public JRadioButton impFrac = new JRadioButton("i x/y");

    public JRadioButton feet = new JRadioButton("f/i");

    public JButton selectDesingButton = new JButton();

    public JButton saveDesignButton = new JButton();

    public JButton undoButton = new JButton();

    public JButton stdButton = new JButton();

    public JButton stdSetButton = new JButton();

    public ButtonGroup checkGroup = new ButtonGroup();

    public ButtonGroup whichM = new ButtonGroup();

    public JCheckBox percent = new JCheckBox("%");

    public JCheckBox cbAS = new JCheckBox();

    public JCheckBox cbRO = new JCheckBox();

    public String originalW = "";

    public String originalH = "";

    public JComboBox combRoadjust = new JComboBox();

    public boolean isWAction = false;

    public boolean isHAction = false;

    public AdjustmentRo myRO = new AdjustmentRo();

    public Object[] values = new Object[2];

    public Map<Integer, Double> topSizes = new HashMap<Integer, Double>();
    public Map<Integer, Double> leftSizes = new HashMap<Integer, Double>();

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Controller components
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public TopPanelController controller;

    public boolean isStdSelected = false;

    /**
     * Top Panel Default Constructor
     */
    public TopPanel() {

        // Layout config
        this.setLayout(new XYLayout());

        // Init controller component
        this.controller = new TopPanelController();
    }

    /**
     * Top Panel Constructor
     *
     * @param parent , ItemFrame
     */
    public TopPanel(ItemFrame parent) {

        // Call default constructor
        this();

        // Setting ItemFrame parent
        this.myParent = parent;

        this.widthImage = ItemFrame.iconFiles.get("width");
        this.oswidthImage = ItemFrame.iconFiles.get("oswidth");
        this.heightImage = ItemFrame.iconFiles.get("height");
        this.osheightImage = ItemFrame.iconFiles.get("osheight");
        this.itemnoImage = ItemFrame.iconFiles.get("itemno");
        this.descriptionImage = ItemFrame.iconFiles.get("description");
        this.qtyImage = ItemFrame.iconFiles.get("qty");
        this.locationImage = ItemFrame.iconFiles.get("location");
        this.ref1Image = ItemFrame.iconFiles.get("ref1");
        this.ref2Image = ItemFrame.iconFiles.get("ref2");
        this.uomImage = ItemFrame.iconFiles.get("uom");

        this.labelFlat.setIcon(ItemFrame.iconFiles.get("flatwidth"));

        this.stdButton.setIcon(ItemFrame.iconFiles.get("std"));
        // this.stdButton.setEnabled(false);

        this.stdSetButton.setIcon(ItemFrame.iconFiles.get("stdset"));
        this.stdSetButton.setEnabled(false);

        this.itemNoLabel.setIcon(this.itemnoImage);
        this.descLabel.setIcon(this.descriptionImage);
        this.labelW.setIcon(this.widthImage);
        this.labelH.setIcon(this.heightImage);
        this.labelWo.setIcon(this.oswidthImage);
        this.labelHo.setIcon(this.osheightImage);

        this.selectDesignImage = ItemFrame.iconFiles.get("designsearch");
        this.saveDesignImage = ItemFrame.iconFiles.get("designsave");

        this.oW.setToolTipText("Enter to set size");
        this.fW.setToolTipText("Enter to set size");
        this.oH.setToolTipText("Enter to set size");
        this.fH.setToolTipText("Enter to set size");
        this.labelFlat.setToolTipText("Flat Width");
        this.flatW.setToolTipText("Flat Width");

        this.selectDesingButton.setIcon(this.selectDesignImage);
        this.saveDesignButton.setIcon(this.saveDesignImage);

        this.selectDesingButton.setToolTipText("Select Predefined Design");
        this.saveDesignButton.setToolTipText("Save as Predefined Design");

        this.add(this.selectDesingButton, new XYConstraints(265, 25, 74, 20));
        this.add(this.saveDesignButton, new XYConstraints(341, 25, 74, 20));

        this.oW.setColumns(10);
        this.fW.setColumns(10);

        // Config check group unit of metric and metric default selected
        this.metric.setToolTipText("Metric Millimeters");
        this.impDec.setToolTipText("Imperial Decimal");
        this.impFrac.setToolTipText("Imperial Fractions");
        this.feet.setToolTipText("Feet and Inches");
        this.percent.setText("%");

        this.checkGroup.add(metric);
        this.checkGroup.add(impDec);
        this.checkGroup.add(impFrac);
        this.checkGroup.add(feet);
        this.checkGroup.add(percent);

        this.metric.setSelected(true);

        this.whichM.add(cbRO);
        this.whichM.add(cbAS);

        this.add(cbAS, new XYConstraints(0, 25, 20, 20));

        this.cbAS.setToolTipText("Actual Size");
        this.cbRO.setToolTipText("Opening Size");
        this.labelW.setToolTipText("Actual Width");
        this.labelH.setToolTipText("Actual Height");
        this.labelWo.setToolTipText("Opening Width");
        this.labelHo.setToolTipText("Opening Height");

        this.add(labelW, new XYConstraints(25, 25, 20, 20));
        this.add(fW, new XYConstraints(52, 25, 80, 21));
        this.add(byX, new XYConstraints(137, 25, 15, 20));
        this.add(labelH, new XYConstraints(152, 25, 20, 20));
        this.add(fH, new XYConstraints(177, 25, 80, 21));
        this.add(cbRO, new XYConstraints(0, 48, 20, 21));
        this.add(labelWo, new XYConstraints(25, 48, 20, 20));
        this.add(oW, new XYConstraints(52, 48, 80, 21));
        this.add(byXos, new XYConstraints(137, 48, 13, 20));

        // Text opening height value
        this.add(labelHo, new XYConstraints(152, 48, 20, 20));
        this.add(oH, new XYConstraints(177, 48, 80, 21));

        // Combo box adjustment ro
        this.add(combRoadjust, new XYConstraints(265, 48, 220, 21));
        
        checkType();

        // Label and Text item number value
        itemNo.setText(this.myParent.itemID + "");
        this.add(itemNo, new XYConstraints(50, 1, 40, 21));
        itemNo.setEnabled(false);
        this.itemNoLabel.setToolTipText("Item No");
        this.add(itemNoLabel, new XYConstraints(25, 1, 20, 20));

        // Label and Text description value
        this.descLabel.setToolTipText("Description");
        this.add(descLabel, new XYConstraints(100, 1, 20, 20));

        if (this.myParent.userPref.getDescription() != null) {
            description.setText(this.myParent.userPref.getDescription() + "");
        }
        
        this.add(description, new XYConstraints(125, 0, 250, 23));

        // Label and Text quantity value
        this.qtyLabel.setIcon(this.qtyImage);
        this.qtyLabel.setToolTipText("Quantity");
        this.add(qtyLabel, new XYConstraints(385, 1, 20, 20));
        this.add(qty, new XYConstraints(408, 1, 40, 21));

        // Label and Combo Location
        this.loc.setIcon(this.locationImage);
        this.loc.setToolTipText("Location");
        this.add(loc, new XYConstraints(489, 1, 20, 20));
        if (this.myParent.userPref.getLocation() != null) {
            locationT.setText(this.myParent.userPref.getLocation().trim() + " ");
        } else {
            locationT.setText("");
        }
        this.add(locationT, new XYConstraints(512, 0, 220, 23));

        // Label and Text Reference values
        this.ref.setIcon(ref1Image);

        this.ref.setToolTipText("Reference 1");

        this.add(ref, new XYConstraints(489, 25, 20, 20));

        if (this.myParent.userPref.getReference() != null) {
            reference.setText(this.myParent.userPref.getReference().trim() + " ");
        } else {
            reference.setText(" ");
        }

        this.add(reference, new XYConstraints(512, 25, 220, 23));

        // Label Unit of Metric and config UI Unit of Metrics
        this.labelUOM.setIcon(uomImage);
        this.labelUOM.setToolTipText("Unit of Measure");

        this.add(labelUOM, new XYConstraints(489, 48, 20, 20));
        this.add(metric, new XYConstraints(512, 48, 45, 20));
        this.add(impDec, new XYConstraints(556, 48, 50, 20));
        this.add(impFrac, new XYConstraints(607, 48, 50, 20));
        this.add(feet, new XYConstraints(656, 48, 45, 20));
        this.add(percent, new XYConstraints(696, 48, 45, 20));

        if (myParent.currentUOM == 1) {
            values[0] = 1000;
            values[1] = 1000;
        } else {
            values[0] = 39 * 64;
            values[1] = 39 * 64;
        }

        // ++++++++++++++
        addActions();
        // ++++++++++++++

        cbAS.doClick();
    }

	private void checkType() {

        if (this.myParent.itemType != 1) {

            fW.setEnabled(false);
            fH.setEnabled(false);
            oW.setEnabled(false);
            oH.setEnabled(false);
            cbRO.setEnabled(false);
            cbAS.setEnabled(false);
            combRoadjust.setEnabled(false);
            selectDesingButton.setEnabled(false);
            saveDesignButton.setEnabled(false);
            stdSetButton.setEnabled(false);
            stdButton.setEnabled(false);
        }
    }

    /**
     * Set Combo Values Base on Series
     */
    public void setComboBasedOnSeries() {

        //******************************************************************************************
        // Set Opening Size Dimensions
        //******************************************************************************************
        if (this.myParent.openingSize) {
            cbRO_actionPerformed();
        }

        //******************************************************************************************
        // Set Adjustment RO Combo Values
        //******************************************************************************************
        if (this.myParent.mySeries.getId() > 0) {
            List<AdjustmentRo> ros = this.controller.getROs(this.myParent.mySeries.getId(), false);

            if (ros.size() > 0) {
                this.combRoadjust.setModel(new DefaultComboBoxModel(ros.toArray()));

                //Set default Index
                this.combRoadjust.setSelectedIndex(0);
            }
        }
    }

    public void addActions() {

        this.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                myParent.stopCustomCursor(myParent.main);
                myParent.setActionTypeEvent(0);
            }
        });

        fW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TopPanel.this.fW_actionPerformed();
            }
        });

        fW.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                myParent.stopCustomCursor(myParent.main);
                myParent.setActionTypeEvent(0);

                fW.selectAll();
            }
        });


        fH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TopPanel.this.fH_actionPerformed();
            }
        });

        fH.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                myParent.stopCustomCursor(myParent.main);
                myParent.setActionTypeEvent(0);
                fH.selectAll();
            }
        });


        oW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TopPanel.this.oW_actionPerformed();
            }
        });

        oW.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                myParent.stopCustomCursor(myParent.main);
                myParent.setActionTypeEvent(0);
                oW.selectAll();
            }
        });


        oH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TopPanel.this.oH_actionPerformed();
            }
        });

        oH.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                myParent.stopCustomCursor(myParent.main);
                myParent.setActionTypeEvent(0);
                oH.selectAll();
            }
        });


        cbRO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TopPanel.this.cbRO_actionPerformed();
            }
        });

        cbRO.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                myParent.stopCustomCursor(myParent.main);
                myParent.setActionTypeEvent(0);
            }
        });


        cbAS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TopPanel.this.cbAS_actionPerformed();
            }
        });

        cbAS.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                myParent.stopCustomCursor(myParent.main);
                myParent.setActionTypeEvent(0);
            }
        });

        metric.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (metric.isSelected()) {
                    myParent.clearTexts();
                    myParent.dim.setDimsActive(true);
                    myParent.prevUOM = myParent.currentUOM;
                    myParent.currentUOM = 1;
                    myParent.uom_actionPerformed(1);
                    myParent.UOMRound = myParent.metricRound;
                }
            }
        });

        metric.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                myParent.stopCustomCursor(myParent.main);
                myParent.setActionTypeEvent(0);
            }
        });

        impDec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (impDec.isSelected()) {
                    myParent.clearTexts();
                    myParent.dim.setDimsActive(true);
                    myParent.prevUOM = myParent.currentUOM;
                    myParent.currentUOM = 2;
                    myParent.uom_actionPerformed(2);
                    myParent.currentUOM = 2;

                    myParent.UOMRound = myParent.impRound;
                }
            }
        });

        impDec.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                myParent.stopCustomCursor(myParent.main);
                myParent.setActionTypeEvent(0);
            }
        });


        impFrac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (impFrac.isSelected()) {
                    myParent.clearTexts();
                    myParent.dim.setDimsActive(true);
                    myParent.prevUOM = myParent.currentUOM;
                    myParent.currentUOM = 2;
                    myParent.uom_actionPerformed(2);
                    myParent.prevUOM = 2;
                    myParent.currentUOM = 3;
                    myParent.uom_actionPerformed(3);
                    myParent.UOMRound = myParent.impRound;
                }
            }
        });

        impFrac.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                myParent.stopCustomCursor(myParent.main);
                myParent.setActionTypeEvent(0);
            }
        });

        feet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (feet.isSelected()) {
                    myParent.clearTexts();
                    myParent.dim.setDimsActive(false);
                    myParent.prevUOM = myParent.currentUOM;
                    myParent.currentUOM = 2;
                    myParent.uom_actionPerformed(2);
                    myParent.prevUOM = 2;
                    myParent.currentUOM = 4;
                    myParent.uom_actionPerformed(4);
                    myParent.UOMRound = myParent.impRound;
                }
            }
        });

        feet.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                myParent.stopCustomCursor(myParent.main);
                myParent.setActionTypeEvent(0);
            }


        });


        percent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (percent.isSelected()) {
                    myParent.uom_actionPerformed(5);
                }
            }
        });

        percent.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                myParent.stopCustomCursor(myParent.main);
                myParent.setActionTypeEvent(0);
            }
        });

        oH.setColumns(10);
        fH.setColumns(10);


        this.combRoadjust.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doROAction(e);
            }
        });

        combRoadjust.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                myParent.stopCustomCursor(myParent.main);
                myParent.setActionTypeEvent(0);
            }
        });


        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
            	if(myParent.dim.cancelAlign!=null){
            		myParent.dim.cancelAlign.doClick();
            	}
            	myParent.jobItem.myCanvas.resetActionToNothing();
                myParent.stopCustomCursor(myParent.main);
                myParent.setActionTypeEvent(0);
                myParent.undoAction();
            }
        });

        stdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                myParent.stopCustomCursor(myParent.main);
                myParent.setActionTypeEvent(0);
                boolean okToGo = true;

                stdSetButton.setEnabled(true);
                stdButton.setEnabled(false);
                checkType();

                for (final Object dv : myParent.jobItem.design.bOpeningObject.mullions.toArray()) {

                    // Not valid if more than one facet V
                    okToGo = false;

                }

                for (final Object dv : myParent.jobItem.design.bOpeningObject.mullionsH.toArray()) {

                    // Not valid if more than one facet H
                    okToGo = false;

                }

                Object[] facets = myParent.jobItem.design.frames.toArray();
                for (final Object facet : facets) {
                    for (final Object dv : ((Facet) facet).bOpeningObject.mullions.toArray()) {
                        if ((((Profiles) dv).startIn || ((Profiles) dv).endIn)) {
                            okToGo = false;
                        }
                    }

                    for (final Object dv : ((Facet) facet).bOpeningObject.mullionsH.toArray()) {
                        if ((((Profiles) dv).startIn || ((Profiles) dv).endIn)) {
                            okToGo = false;
                        }
                    }

                }

                if (okToGo) {

                    isStdSelected = true;


                    myParent.jobItem.myCanvas.createTextFieldsTop();
                    myParent.jobItem.myCanvas.createTextFieldsLeft();

                    myParent.jobItem.myCanvas.validate();
                    myParent.jobItem.myCanvas.repaint();
                    // Use this too turn off action of text on design


                    TopPanel.this.cbAS.setSelected(true);
                    TopPanel.this.cbAS.setEnabled(false);
                    TopPanel.this.cbRO.setEnabled(false);

                   
                    
                    myParent.dim.frame.doClick();

                    myParent.dim.center.setEnabled(false);
                    myParent.dim.frame.setEnabled(false);
                    myParent.dim.frameOpeningC.setEnabled(false);
                    myParent.dim.frameOpening.setEnabled(false);
                    myParent.dim.fOpeningN.setEnabled(false);
                    myParent.dim.fOpeningA.setEnabled(false);
                    myParent.dim.glass.setEnabled(false);
                    myParent.dim.dlo.setEnabled(false);
                    myParent.dim.grids.setEnabled(false);

                    myParent.dim.equalize.setEnabled(false);
                    myParent.dim.equalizeH.setEnabled(false);
                    myParent.dim.alignHorz.setEnabled(false);
                    myParent.dim.alignVert.setEnabled(false);

                    originalW = fW.getText();
                    originalH = fH.getText();

                    TopPanel.this.fH.setEnabled(false);
                    TopPanel.this.fW.setEnabled(false);
                    TopPanel.this.fH.setEnabled(false);

                    stdSetButton.setEnabled(true);

                    checkType();
                    
                    validate();
                    repaint();
                } else {
                    JOptionPane.showMessageDialog(null, "Operation nor allowed due to Coupler configuration.",
                            "Set Design Size by Frame - Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        stdSetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {

                myParent.stopCustomCursor(myParent.main);
                myParent.setActionTypeEvent(0);
                getSumNet();

                stdSetButton.setEnabled(false);
                stdButton.setEnabled(true);

                TopPanel.this.cbAS.setSelected(true);
                TopPanel.this.cbAS.setEnabled(true);
                TopPanel.this.cbRO.setEnabled(true);

            
                
                TopPanel.this.fW.setEnabled(true);
                TopPanel.this.fH.setEnabled(true);

                myParent.dim.center.setEnabled(true);
                myParent.dim.frame.setEnabled(true);
                myParent.dim.frameOpeningC.setEnabled(true);
                myParent.dim.frameOpening.setEnabled(true);
                myParent.dim.fOpeningN.setEnabled(true);
                myParent.dim.fOpeningA.setEnabled(true);
                myParent.dim.glass.setEnabled(true);
                myParent.dim.dlo.setEnabled(true);
                myParent.dim.grids.setEnabled(true);

                myParent.dim.equalize.setEnabled(true);
                myParent.dim.equalizeH.setEnabled(true);
                myParent.dim.alignHorz.setEnabled(true);
                myParent.dim.alignVert.setEnabled(true);
                // myParent.editTask.setCollapsed(true);
                // myParent.editTask.setVisible(true);
                isStdSelected = false;

//				myParent.jobItem.myCanvas.createTextFieldsTop();
//				myParent.jobItem.myCanvas.createTextFieldsLeft();

                checkType();
                
                myParent.jobItem.resetGraphics();
            }
        });

        this.selectDesingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myParent.stopCustomCursor(myParent.main);
                myParent.setActionTypeEvent(0);
                selectDesignButton_actionPerformed();
            }
        });

        // *************************************************
        // Save design button listener
        // *************************************************
        saveDesignButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myParent.stopCustomCursor(myParent.main);
                myParent.setActionTypeEvent(0);
                saveDesignButton_actionPerformed();
            }
        });

    }

    public void addUndo() {

        ImageIcon myviewIcon;

        final JLabel viewLabel = new JLabel();

        new JLabel(" ");
        new JLabel(" ");

        if (this.myParent.userPref.isViewOut()) {
            myviewIcon = myParent.iconFiles.get("viewOut");
            viewLabel.setToolTipText("Viewed From Outside");

        } else {
            myviewIcon = myParent.iconFiles.get("viewIn");
            viewLabel.setToolTipText("Viewed From Inside");
        }

        viewLabel.setIcon(myviewIcon);
        undoButton.setIcon(myParent.undoImage);
        undoButton.setToolTipText("Undo");

        add(stdButton, new XYConstraints(465, 72, 45, 28));
        add(stdSetButton, new XYConstraints(512, 72, 45, 28));

        stdSetButton.setEnabled(false);
        stdButton.setEnabled(true);

        this.add(viewLabel, new XYConstraints(668, 72, 30, 28));
        this.add(undoButton, new XYConstraints(700, 72, 30, 28));

        stdButton.setToolTipText("Enter Individual Frame Sizes/Std. Sizes");
        stdSetButton.setToolTipText("Set Overall Size From Individual Frame Sizes/Std. Sizes");
        checkType();
    }

    public void getSumNet() {

        // make sure the first row and column are selected.

        // this.myParent.mainColCheck[0].doClick();
        // this.myParent.mainRowCheck[0].doClick();

        myParent.startWaitCursor(this);

        double thickV = 0d;
        for (Object cv : this.myParent.facetUsed.bOpeningObject.mullions.toArray()) {
            if (myParent.currentUOM == 1) {
                thickV = thickV + ((Profiles) cv).partDimB;
            } else {
                thickV = thickV + ((Profiles) cv).partDimBi;

            }
        }
        if (myParent.currentUOM == 1) {
            thickV = new BigDecimal(thickV).divide(myParent.metricscale, 20, BigDecimal.ROUND_HALF_UP).doubleValue();
        } else {
            thickV = new BigDecimal(thickV).divide(myParent.imperialscale, 20, BigDecimal.ROUND_HALF_UP).doubleValue();
        }


        double thickH = 0d;
        for (Object cv : this.myParent.facetUsed.bOpeningObject.mullionsH.toArray()) {
            if (myParent.currentUOM == 1) {
                thickH = thickH + ((Profiles) cv).partDimB;
            } else {
                thickH = thickH + ((Profiles) cv).partDimBi;

            }
        }
        if (myParent.currentUOM == 1) {
            thickH = new BigDecimal(thickH).divide(myParent.metricscale, 20, BigDecimal.ROUND_HALF_UP).doubleValue();
        } else {
            thickH = new BigDecimal(thickH).divide(myParent.imperialscale, 20, BigDecimal.ROUND_HALF_UP).doubleValue();
        }


        double totalws = 0;


        for (Object f : this.myParent.facetUsed.frames.toArray()) {
            if (((Frame) f).startRow == 1) {
                if (myParent.currentUOM == 1) {

                    totalws = totalws + ((Frame) f).widthM;
                    topSizes.put(((Frame) f).startCol, (double) ((Frame) f).widthM);
                    // in mm x 100

                } else {

                    totalws = totalws + ((Frame) f).widthI;
                    topSizes.put(((Frame) f).startCol, (double) ((Frame) f).widthI);
                    // in 64th
                }
            }
        }

        double totalFW = totalws + thickV;

        if (myParent.myTopPanel.metric.isSelected()) {

            this.myParent.myTopPanel.fW.setText((totalFW / 100) + "");

        } else if (myParent.myTopPanel.impDec.isSelected()) {

            this.myParent.myTopPanel.fW.setText((totalFW / 64) + "");

        } else if (myParent.myTopPanel.impFrac.isSelected()) {
            try {

                this.myParent.myTopPanel.fW.setText(UOMConvert.imperialToFraction((totalFW / 64) + ""));

            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }


        double totalhs = 0;


        for (Object f : this.myParent.facetUsed.frames.toArray()) {
            if (((Frame) f).startCol == 1) {
                if (myParent.currentUOM == 1) {

                    totalhs = totalhs + ((Frame) f).heightM;
                    leftSizes.put(((Frame) f).startRow, (double) ((Frame) f).heightM);
                    // in mm x 100

                } else {

                    totalhs = totalhs + ((Frame) f).heightI;
                    leftSizes.put(((Frame) f).startRow, (double) ((Frame) f).heightI);
                    // in 64th
                }
            }
        }

        double totalFH = totalhs + thickH;

        if (myParent.myTopPanel.metric.isSelected()) {

            this.myParent.myTopPanel.fH.setText((totalFH / 100) + "");

        } else if (myParent.myTopPanel.impDec.isSelected()) {

            this.myParent.myTopPanel.fH.setText((totalFH / 64) + "");

        } else if (myParent.myTopPanel.impFrac.isSelected()) {
            try {

                this.myParent.myTopPanel.fH.setText(UOMConvert.imperialToFraction((totalFH / 64) + ""));

            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }

        fTextAction();

        double myW = 0;

        for (Object f : this.myParent.facetUsed.frames.toArray()) {
            if (((Frame) f).startRow == 1) {
                if (myParent.myTopPanel.metric.isSelected()) {
                    myW = new BigDecimal(topSizes.get(((Frame) f).startCol)).multiply(myParent.metricscale).doubleValue();
                    myParent.jobItem.myCanvas.selectedCol = myParent.jobItem.myCanvas.selectedFrameNo = ((Frame) f).startCol;
                    myParent.jobItem.myCanvas.frameColumnsTextChange(myW, myParent.metricscale.doubleValue());
                } else if (myParent.myTopPanel.impDec.isSelected()) {
                    myW = new BigDecimal(topSizes.get(((Frame) f).startCol)).multiply(myParent.imperialscale)
                            .doubleValue();
                    myParent.jobItem.myCanvas.selectedCol = myParent.jobItem.myCanvas.selectedFrameNo = ((Frame) f).startCol;
                    myParent.jobItem.myCanvas.frameColumnsTextChange(myW, myParent.imperialscale.doubleValue());
                }
            }

        }

        double myH = 0;

        for (Object f : this.myParent.facetUsed.frames.toArray()) {
            if (((Frame) f).startCol == 1) {
                if (myParent.myTopPanel.metric.isSelected()) {
                    myH = new BigDecimal(leftSizes.get(((Frame) f).startRow)).multiply(myParent.metricscale).doubleValue();
                    myParent.jobItem.myCanvas.selectedRowLeft = myParent.jobItem.myCanvas.selectedFrameNo = ((Frame) f).startRow;
                    myParent.jobItem.myCanvas.frameRowsTextChange(myH, myParent.metricscale.doubleValue());
                } else if (myParent.myTopPanel.impDec.isSelected()) {
                    myH = new BigDecimal(leftSizes.get(((Frame) f).startRow)).multiply(myParent.imperialscale)
                            .doubleValue();
                    myParent.jobItem.myCanvas.selectedRowLeft = myParent.jobItem.myCanvas.selectedFrameNo = ((Frame) f).startRow;
                    myParent.jobItem.myCanvas.frameRowsTextChange(myH, myParent.imperialscale.doubleValue());
                }
            }

        }


        myParent.stopWaitCursor(this);
//        myParent.jobItem.resetGraphics();
    }

    /**
     * Select predefine design button action performed
     */
    public void selectDesignButton_actionPerformed() {
        new PredefineDesignDialog(this.myParent, new PredefineDesignController());
    }

    /**
     * Save predefine design button action performed
     */
    public void saveDesignButton_actionPerformed() {
        // Call save design panel
        new DesignPanel(this.myParent);
    }

    public void cbRO_actionPerformed() {
        fW.setEnabled(false);
        fH.setEnabled(false);
        oW.setEnabled(true);
        oH.setEnabled(true);

        cbRO.setSelected(true);
        cbAS.setSelected(false);

        combRoadjust.setEnabled(true);
        
        checkType();
    }

    public void cbAS_actionPerformed() {

        fW.setEnabled(true);
        fH.setEnabled(true);
        oW.setEnabled(false);
        oH.setEnabled(false);

        cbAS.setSelected(true);
        cbRO.setSelected(false);

        combRoadjust.setEnabled(false);
    }

    public void fW_actionPerformed() {
        this.fTextAction();
    }

    public void oW_actionPerformed() {
        this.oTextAction();
    }

    public void fH_actionPerformed() {
        this.fTextAction();
    }

    public void oH_actionPerformed() {
        this.oTextAction();
    }

    public void fTextAction() {

        isWAction = true;
        isHAction = true;
        myParent.isUndo = false;
        myParent.wEntered = true;
        myParent.hEntered = true;
        myParent.changeFacetW = false;
        myParent.changeFacetH = false;
        myParent.roundW = true;
        myParent.roundH = true;
        this.resetSize(true);
        myParent.isStd = false;
        if (myParent.jobItem != null) {
            this.myParent.jobItem.isStd = false;
        }

        myParent.layoutP = new LayoutPanel(myParent);

        myParent.layoutPanel.removeAll();
        myParent.layoutPanel.setLayout(new BorderLayout());
        myParent.layoutPanel.setBorder(BorderFactory.createEtchedBorder());

        myParent.layoutPanel.add(myParent.layoutP, BorderLayout.CENTER);
        myParent.layoutP.woText.setText(fW.getText());

        try {
            values = myParent.readTextCurrentUOM(fW);
        } catch (final Exception e1) {
            e1.printStackTrace();
        }

        double myOW = 0;
        if (myParent.currentUOM == 1) {
            myOW = myParent.doRoundDim(Double.parseDouble(values[0].toString())) + getOAW() / 100d;
        } else {
            myOW = (myParent.doRoundDim(Double.parseDouble(values[0].toString()))) / 64 + getOAW() / 64d;
        }

        oW.setText(myOW + "");

        try {
            values = myParent.readTextCurrentUOM(fH);
        } catch (final Exception e1) {
            e1.printStackTrace();
        }

        double myOH = 0;
        if (myParent.currentUOM == 1) {
            myOH = myParent.doRoundDim(Double.parseDouble(values[0].toString())) + getOAH() / 100d;
        } else {
            myOH = (myParent.doRoundDim(Double.parseDouble(values[0].toString()))) / 64 + getOAH() / 64d;
        }

        oH.setText(myOH + "");

        //Reset Options values
        this.myParent.options.initValues();

        this.myParent.layoutP.isInit = true;
        this.myParent.jobItem.layout = 1;
        this.myParent.layoutP.flat.setSelected(true);

        //Calculate Bill Of Material Components
        this.myParent.calcBom = true;
    }

    public void oTextAction() {

        myParent.isUndo = false;

        //***************************************************************************************
        //Set Parent Standard
        //***************************************************************************************
        if (myParent.jobItem != null) {

            this.myParent.isStd = false;
            this.myParent.jobItem.isStd = false;
        }

        //***************************************************************************************
        //Calculate Width Value
        //***************************************************************************************

        try {
            values = myParent.readTextCurrentUOM(oW);
        } catch (final Exception e1) {
            e1.printStackTrace();
        }

        double myOW;
        if (myParent.currentUOM == 1) {
            myOW = myParent.doRoundDim(Double.parseDouble(values[0].toString())) - getOAW() / 100d;
        } else {
            myOW = (myParent.doRoundDim(Double.parseDouble(values[0].toString()))) / 64 - getOAW() / 64d;
        }

        //***************************************************************************************
        //Calculate Height Value
        //***************************************************************************************

        try {
            values = myParent.readTextCurrentUOM(oH);
        } catch (final Exception e1) {
            e1.printStackTrace();
        }

        double myOH;
        if (myParent.currentUOM == 1) {
            myOH = myParent.doRoundDim(Double.parseDouble(values[1].toString())) - getOAH() / 100d;
        } else {
            myOH = (myParent.doRoundDim(Double.parseDouble(values[1].toString()))) / 64 - getOAH() / 64d;
        }

        fW.setText(myOW + "");
        fH.setText(myOH + "");

        this.fTextAction();
    }

    /**
     * This method reset size for Overall design
     *
     * @param width  , Overall Width
     * @param height , Overall Height
     * @param uom    , Unit of Metric
     */
    public void resetSize(double width, double height, int uom) {

        if (uom == Metrics.METRIC.getValue()) {
            this.metric.setSelected(true);

            // Setting UI new width & height values
            this.fW.setText(width + "");
            this.fH.setText(height + "");
            this.oW.setText(width + this.getOAW() / 100 + "");
            this.oH.setText(height + this.getOAH() / 100 + "");

        } else if (uom == Metrics.IMPERIAL_DECIMAL.getValue()) {
            this.impDec.setSelected(true);

            this.fW.setText(width + "");
            this.fH.setText(height + "");
            this.oW.setText(width + this.getOAW() / 64 + "");
            this.oH.setText(height + this.getOAH() / 64 + "");

        } else if (uom == Metrics.IMPERIAL_FRACTION.getValue()) {
            this.impFrac.setSelected(true);

            try {
                width = Double.parseDouble(UOMConvert.fractionToImperial(width + ""));
                height = Double.parseDouble(UOMConvert.fractionToImperial(height + ""));
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
            this.fW.setText(width + "");
            this.fH.setText(height + "");
            this.oW.setText(width + this.getOAW() / 64 + "");
            this.oH.setText(height + this.getOAH() / 64 + "");
        }

        // Adding to undo design
        this.myParent.addToUndo();

        // Reset overall design with new width & height
        this.myParent.doResetOverallSize(width, height, this.myParent.jobItem.design, 0, true, true);

        //Setting values
        this.isWAction = false;
        this.isHAction = false;
    }

    /**
     * This method reset size for Overall design
     *
     * @param round , Value to indicate reset size
     */
    public void resetSize(boolean round) {

        BigDecimal originalScaleM = new BigDecimal(0);
        BigDecimal originalScaleI = new BigDecimal(0);
        BigDecimal originalScale = new BigDecimal(0);
        // *****************************************************************
        // 1. Preparing scale to evaluate metric selection
        // *****************************************************************
        BigDecimal myScale = new BigDecimal(0);

        originalScaleM = myParent.metricscale;
        originalScaleI = myParent.imperialscale;

        if (myParent.myTopPanel.metric.isSelected()) {
            myScale = originalScale = myParent.scale.multiply(new BigDecimal(100));

        } else {
            myScale = originalScale = myParent.scale;
        }

        // *****************************************************************
        // 2. Obtain new width and height values from UI
        // *****************************************************************
        double initFW = 0;
        double initFH = 0;

        if (myParent.myTopPanel.metric.isSelected()) {
            initFW = Double.parseDouble(fW.getText());
            initFH = Double.parseDouble(fH.getText());
        } else if (myParent.myTopPanel.impDec.isSelected()) {
            initFW = Double.parseDouble(fW.getText()) * 64;
            initFH = Double.parseDouble(fH.getText()) * 64;
        } else if (myParent.myTopPanel.impFrac.isSelected()) {
            try {
                initFW = Double.parseDouble(UOMConvert.fractionToImperial(fW.getText())) * 64;
                initFH = Double.parseDouble(UOMConvert.fractionToImperial(fH.getText())) * 64;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // **************************************************************************
        // 3. Evaluate if width and height is not equal to the actual size for
        // design
        // **************************************************************************
        if ((new BigDecimal(initFW).multiply(myScale).doubleValue() != myParent.jobItem._WIDTHpix)
                || (new BigDecimal(initFH).multiply(myScale).doubleValue() != myParent.jobItem._HEIGHTpix)) {

            // Adding actual design to UNDO action array
            this.myParent.addToUndo();

            // **********************************************
            // Process for Metric UOM selected
            // **********************************************
            if (myParent.myTopPanel.metric.isSelected()) {

                double w = myParent.roundDim(Double.parseDouble(fW.getText()), 1, myParent.metricRound, 1);
                double h = myParent.roundDim(Double.parseDouble(fH.getText()), 1, myParent.metricRound, 1);

                // Preparing new overall width & height
                BigDecimal myScale2 = new BigDecimal(0);

                do {

                    myScale = myParent.jobItem.calcScale(w * 100, h * 100);

                    if (round) {
                        w = doWAction(myScale.multiply(new BigDecimal(100)), originalScale, w);
                        h = doHAction(myScale.multiply(new BigDecimal(100)), originalScale, h);
                    }

                    myScale2 = myParent.jobItem.calcScale(w * 100, h * 100);

                }
                while (!myScale.equals(myScale2));

                this.fW.setText(w + "");
                this.fH.setText(h + "");
                this.oW.setText(w + this.getOAW() / 100 + "");
                this.oH.setText(h + this.getOAH() / 100 + "");

                // Reset overall design with new width & height
                this.myParent.doResetOverallSize(w, h, myParent.jobItem.design, 0, false, false);

                // Setting change facet width & height to false
                this.myParent.changeFacetW = false;
                this.myParent.changeFacetH = false;

                // Setting facet used to myParent ItemFrame
                Object[] facets = myParent.jobItem.design.frames.toArray();
                this.myParent.jobItem.design.frames.clear();

                for (Object f : facets) {
                    if (((Facet) f).startCol == myParent.facetUsed.startCol) {
                        ((Facet) f).inUse = true;
                        this.myParent.facetUsed = (Facet) f;
                    }
                    this.myParent.jobItem.design.frames.add(f);
                }

            } else if (myParent.myTopPanel.impDec.isSelected()) {

                double w = myParent.roundDim(Double.parseDouble(fW.getText()) * 64, 2, myParent.impRound, 2);
                double h = myParent.roundDim(Double.parseDouble(fH.getText()) * 64, 2, myParent.impRound, 2);

                // Preparing new overall width & height
                BigDecimal myScale2 = new BigDecimal(0);

                do {

                    myScale = myParent.jobItem.calcScale(w, h);

                    if (round) {
                        w = doWAction(myScale.multiply(new BigDecimal(100)), originalScale, w);
                        h = doHAction(myScale.multiply(new BigDecimal(100)), originalScale, h);
                    }

                    myScale2 = myParent.jobItem.calcScale(w, h);

                } while (!myScale.equals(myScale2));

                this.fW.setText(w / 64 + "");
                this.fH.setText(h / 64 + "");
                this.oW.setText(w / 64 + this.getOAW() / 64 + "");
                this.oH.setText(h / 64 + this.getOAH() / 64 + "");

                // Reset overall design with new width & height
                this.myParent.doResetOverallSize(w / 64, h / 64, this.myParent.jobItem.design, 0, true, false);

                // Setting change facet width & height to false
                this.myParent.changeFacetW = false;
                this.myParent.changeFacetH = false;

                // Setting facet used to myParent ItemFrame
                Object[] facets = myParent.jobItem.design.frames.toArray();
                this.myParent.jobItem.design.frames.clear();

                for (Object f : facets) {
                    if (((Facet) f).startCol == myParent.facetUsed.startCol) {
                        ((Facet) f).inUse = true;
                        this.myParent.facetUsed = (Facet) f;
                    }
                    this.myParent.jobItem.design.frames.add(f);
                }

            } else if (this.myParent.myTopPanel.impFrac.isSelected()) {

                double w = 0;
                double h = 0;

                try {
                    w = this.myParent.roundDim(Double.parseDouble(UOMConvert.fractionToImperial(this.fW.getText())) * 64, 2,
                            this.myParent.impRound, 2);
                    h = this.myParent.roundDim(Double.parseDouble(UOMConvert.fractionToImperial(this.fH.getText())) * 64, 2,
                            this.myParent.impRound, 2);

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // Preparing new overall width & height
                BigDecimal myScale2 = new BigDecimal(0);

                do {

                    myScale = myParent.jobItem.calcScale(w, h);

                    if (round) {
                        w = doWAction(myScale.multiply(new BigDecimal(100)), originalScale, w);
                        h = doHAction(myScale.multiply(new BigDecimal(100)), originalScale, h);
                    }

                    myScale2 = myParent.jobItem.calcScale(w, h);

                }
                while (!myScale.equals(myScale2));

                this.fW.setText(w / 64 + "");
                this.fH.setText(h / 64 + "");
                this.oW.setText(w / 64 + this.getOAW() / 64 + "");
                this.oH.setText(h / 64 + this.getOAH() / 64 + "");

                // Reset overall design with new width & height
                this.myParent.doResetOverallSize(w / 64, h / 64, this.myParent.jobItem.design, 0, true, false);

                // Setting change facet width & height to false
                this.myParent.changeFacetW = false;
                this.myParent.changeFacetH = false;

                // Setting facet used to myParent ItemFrame
                Object[] facets = myParent.jobItem.design.frames.toArray();
                this.myParent.jobItem.design.frames.clear();

                for (Object f : facets) {
                    if (((Facet) f).startCol == myParent.facetUsed.startCol) {
                        ((Facet) f).inUse = true;
                        this.myParent.facetUsed = (Facet) f;
                    }
                    this.myParent.jobItem.design.frames.add(f);
                }

            }

            // takes Too Long for Dim Change
            // Need to fix scale to avoid split problems

            // myParent.dim.frame.doClick();
            // myParent.dim.equalize.doClick();
            // myParent.dim.frame.doClick();
            // myParent.dim.equalizeH.doClick();

            if (myParent.frameDim) {
                myParent.dim.center.doClick();
            } else {
                myParent.dim.frame.doClick();
            }

            // Setting rounding and entered values to false
            this.myParent.roundW = false;
            this.myParent.roundH = false;
            this.myParent.wEntered = false;
            this.myParent.hEntered = false;

            myParent.jobItem.resetGraphics();


            this.myParent.doFacetRadioClick();

            isWAction = false;
            isHAction = false;
        }

        // *******************************************
        // Init price category and financial category
        // *******************************************
//		myParent.setCostPrice();
    }

    public double doWAction(BigDecimal myScale, BigDecimal originalScale, double w) {

        Object[] Ms = myParent.jobItem.design.bOpeningObject.mullions.toArray();

        double dividerTotal = 0;

        for (final Object element : Ms) {
            if (((Profiles) element).exists == 1) {

                Parts parts = null;
                if (((Profiles) element).remote) {
                    parts = ItemFrame.getApplicationRemoteBaseRules().getPart(((Profiles) element).supplierId, ((Profiles) element).partID);
                } else {
                    parts = ApplicationBaseApp.getInstance().getPart(((Profiles) element).partID);
                }

                double dim = 0;
                if (((Profiles) element).exists == 1) {
                    if (myParent.currentUOM == 1) {
                        dim = parts.getDimb();
                    }else{
                        dim = parts.getDimbi();
                    }
                }

                dividerTotal = dividerTotal + dim;
            }
        }

        double overallNetW = w - dividerTotal;

        overallNetW = overallNetW / myParent.jobItem.design.xCols;

        Object[] facets = myParent.jobItem.design.frames.toArray();

        myParent.jobItem.design.frames.clear();

        double frameWR = 0;
        double facetW = 0;
        for (final Object f : facets) {

            final Object[] fms = ((Facet) f).bOpeningObject.mullions.toArray();

            double couplerTotal = 0;
            for (final Object element : fms) {

                Parts parts = null;
                if (((Profiles) element).remote) {
                    parts = ItemFrame.getApplicationRemoteBaseRules().getPart(((Profiles) element).supplierId, ((Profiles) element).partID);
                } else {
                    parts = ApplicationBaseApp.getInstance().getPart(((Profiles) element).partID);
                }

                double dim = 0;
                if (((Profiles) element).exists == 1) {
                    if (myParent.currentUOM == 1) {
                        dim = parts.getDimb();
                    }else{
                        dim = parts.getDimbi();
                    }
                }

                couplerTotal = couplerTotal + dim;

            }

            double facetNetW = overallNetW - couplerTotal;
            if (myParent.currentUOM == 1) {
                frameWR = myParent.roundDim(facetNetW / ((Facet) f).xCols, 1, myParent.metricRound, 1); // 493.5
            } else {
                frameWR = myParent.roundDim(facetNetW / ((Facet) f).xCols, 1, myParent.impRound, 1); // 493.5

            }
            facetW = (frameWR * ((Facet) f).xCols) + couplerTotal;

            ((Facet) f).widthPix = new BigDecimal(facetW).multiply(myScale).doubleValue();

            if (myParent.currentUOM == 1) {
                ((Facet) f).widthM = ((Facet) f).widthMO = (int) (myParent.roundDim(facetW, 1, myParent.metricRound, 1) * 100);
                ((Facet) f).widthI = ((Facet) f).widthIO = (int) myParent.roundDim(facetW / 25.4 * 64, 2, myParent.impRound,
                        2);
            } else if (myParent.currentUOM >= 2) {
                ((Facet) f).widthM = ((Facet) f).widthMO = (int) (myParent.roundDim(facetW / 64 * 25.4, 1,
                        myParent.metricRound, 1) * 100);
                ((Facet) f).widthI = ((Facet) f).widthIO = (int) myParent.roundDim(facetW, 2, myParent.impRound, 2);
            }

            myParent.jobItem.design.frames.add(f);
        }

        facets = myParent.jobItem.design.frames.toArray();

        double totalDW = 0;
        for (final Object f : facets) {

            totalDW = totalDW + facetW;

        }

        w = totalDW + (new BigDecimal(dividerTotal).multiply(myScale).doubleValue());

        return w;

    }

    public double doHAction(BigDecimal myScale, BigDecimal originalScale, double h) {

        Object[] Ms = myParent.jobItem.design.bOpeningObject.mullionsH.toArray();

        double dividerTotal = 0;

        for (final Object element : Ms) {
            if (((Profiles) element).exists == 1) {

                Parts parts = null;
                if (((Profiles) element).remote) {
                    parts = ItemFrame.getApplicationRemoteBaseRules().getPart(((Profiles) element).supplierId, ((Profiles) element).partID);
                } else {
                    parts = ApplicationBaseApp.getInstance().getPart(((Profiles) element).partID);
                }

                double dim = 0;
                if (((Profiles) element).exists == 1) {
                    if (myParent.currentUOM == 1) {
                        dim = parts.getDimb();
                    }else{
                        dim = parts.getDimbi();
                    }
                }

                dividerTotal = dividerTotal + dim;
            }
        }

        double overallNetH = h - (dividerTotal);

        overallNetH = overallNetH / myParent.jobItem.design.yRows;

        Object[] facets = myParent.jobItem.design.frames.toArray();

        myParent.jobItem.design.frames.clear();

        double frameHR = 0;
        double facetH = 0;
        for (final Object f : facets) {

            final Object[] fms = ((Facet) f).bOpeningObject.mullionsH.toArray();

            double couplerTotal = 0;
            for (final Object element : fms) {
                if (((Profiles) element).exists == 1) {

                    Parts parts = null;
                    if (((Profiles) element).remote) {
                        parts = ItemFrame.getApplicationRemoteBaseRules().getPart(((Profiles) element).supplierId, ((Profiles) element).partID);
                    } else {
                        parts = ApplicationBaseApp.getInstance().getPart(((Profiles) element).partID);
                    }

                    double dim = 0;
                    if (((Profiles) element).exists == 1) {
                        if (myParent.currentUOM == 1) {
                            dim = parts.getDimb();
                        }else{
                            dim = parts.getDimbi();
                        }
                    }

                    couplerTotal = couplerTotal + dim;
                }
            }

            double facetNetH = overallNetH - (couplerTotal);

            if (myParent.currentUOM == 1) {
                frameHR = myParent.roundDim(facetNetH / ((Facet) f).yRows, 1, myParent.metricRound, 1);
            } else {
                frameHR = myParent.roundDim(facetNetH / ((Facet) f).yRows, 1, myParent.impRound, 1);
            }

            facetH = (frameHR * ((Facet) f).yRows) + (couplerTotal);

            ((Facet) f).heightPix = new BigDecimal(facetH).multiply(myScale).doubleValue();

            if (myParent.currentUOM == 1) {
                ((Facet) f).heightM = ((Facet) f).heightMO = (int) (myParent.roundDim(facetH, 1, myParent.metricRound, 1) * 100);
                ((Facet) f).heightI = ((Facet) f).heightIO = (int) myParent.roundDim(facetH / 25.4 * 64, 2,
                        myParent.impRound, 2);
            } else if (myParent.currentUOM >= 2) {
                ((Facet) f).heightM = ((Facet) f).heightMO = (int) (myParent.roundDim(facetH / 64 * 25.4, 1,
                        myParent.metricRound, 1) * 100);
                ((Facet) f).heightI = ((Facet) f).heightIO = (int) myParent.roundDim(facetH, 2, myParent.impRound, 2);
            }

            myParent.jobItem.design.frames.add(f);
        }

        facets = myParent.jobItem.design.frames.toArray();

        double totalDH = 0;
        for (final Object f : facets) {

            totalDH = totalDH + facetH;

        }

        h = totalDH + (new BigDecimal(dividerTotal).multiply(myScale).doubleValue());

        return h;

    }

    public void doROAction(ActionEvent e) {

        myRO = ((AdjustmentRo) this.combRoadjust.getSelectedItem());

        myParent.isStd = false;

        if (myParent.jobItem != null) {

            this.myParent.jobItem.isStd = false;
            try {
                values = myParent.readTextCurrentUOM(oW);
            } catch (final Exception e1) {
                e1.printStackTrace();
            }
        }

        double myOW = 0;
        if (myParent.currentUOM == 1) {
            myOW = myParent.doRoundDim(Double.parseDouble(values[0].toString())) - getOAW() / 100d;
        } else {
            myOW = (myParent.doRoundDim(Double.parseDouble(values[0].toString()))) / 64 - getOAW() / 64d;
        }

        fW.setText(myOW + "");

        values = new Object[2];
        myParent.isStd = false;
        if (myParent.jobItem != null) {
            this.myParent.jobItem.isStd = false;
        }

        try {
            values = myParent.readTextCurrentUOM(oH);
        } catch (final Exception e1) {
            e1.printStackTrace();
        }

        double myOH = 0;
        if (myParent.currentUOM == 1) {
            myOH = myParent.doRoundDim(Double.parseDouble(values[0].toString())) - getOAH() / 100d;
        } else {
            myOH = (myParent.doRoundDim(Double.parseDouble(values[0].toString()))) / 64 - getOAH() / 64d;
        }

        fH.setText(myOH + "");

        fH_actionPerformed();
    }

    public Profiles resetRecalcMullionBom(Profiles mullion) {

        mullion.length = Math.sqrt(Math.pow((Math.max(mullion.centerXe, mullion.centerXs) - Math.min(mullion.centerXe,
                mullion.centerXs)), 2) + Math.pow((Math.max(mullion.centerYe, mullion.centerYs) -
                Math.min(mullion.centerYe, mullion.centerYs)), 2));

        mullion.lengthM = (int) (mullion.length / myParent.metricscale.doubleValue());

        mullion.lengthI = (int) (mullion.length / myParent.imperialscale.doubleValue());

        mullion.bom.clear();
        mullion.clearBomForProfile();

        return mullion;
    }

    // *************************************************************
    // Service configuration for Top Panel
    // *************************************************************

    /**
     * This method return width for Adjustment RO
     *
     * @return width int from Adjustment RO
     */
    public int getOAW() {

        // Get Adjustment RO
        AdjustmentRo ro = (AdjustmentRo) combRoadjust.getSelectedItem();

        if (myParent.currentUOM == Metrics.METRIC.getValue()) {
            return ro.getRow();
        } else {
            return ro.getRowi();
        }
    }

    /**
     * This method return height for Adjustment RO
     *
     * @return height int from Adjustment RO
     */
    public int getOAH() {

        // Get Adjustment RO
        AdjustmentRo ro = (AdjustmentRo) combRoadjust.getSelectedItem();

        if (myParent.currentUOM == Metrics.METRIC.getValue()) {
            return ro.getRoh();
        } else {
            return ro.getRohi();
        }
    }

    /**
     * This method update actual size checkbox to TopPanel configuration option
     *
     * @param value  , This value represents if the actual size should be active or not (true) active, (false)inactive
     * @param width  , Width actual size
     * @param height , Height actual size
     */
    public void setActualSizeUI(boolean value, int adjustmentRoId, int seriesId, double width, double height) {

        if (value) {
            this.cbAS.setSelected(true);
            this.cbRO.setSelected(false);
        } else {
            this.cbAS.setSelected(false);
            this.cbRO.setSelected(true);
        }

        try {
            // Setting adjustment RO selected
            AdjustmentRo ro = controller.findRoByIdentification(adjustmentRoId, seriesId);
            this.combRoadjust.setSelectedItem(ro);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        this.fW.setText(width + "");
        this.fH.setText(height + "");
    }

    /**
     * This method update opening size checkbox to TopPanel configuration
     * option
     *
     * @param value  , This value represents if the actual size should be active or not (true) active, (false) inactive
     * @param width  , Width actual size
     * @param height , Height actual size
     */
    public void setOpeningSizeUI(boolean value, int adjustmentRoId, int seriesId, double width, double height) {

        if (value) {

            this.cbRO.setSelected(true);
            this.cbAS.setSelected(false);

            this.oW.setEnabled(true);
            this.oH.setEnabled(true);
            this.fW.setEnabled(false);
            this.fH.setEnabled(false);

            this.combRoadjust.setEnabled(true);

            try {

                // Setting adjustment RO selected
                AdjustmentRo ro = controller.findRoByIdentification(adjustmentRoId, seriesId);
                this.combRoadjust.setSelectedItem(ro);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }

        } else {
            this.cbRO.setSelected(false);
            this.cbAS.setSelected(true);
            this.combRoadjust.setEnabled(false);
        }

        this.fW.setText(width + "");
        this.fH.setText(height + "");
        
        checkType();
    }

    /**
     * This method init unit of measure values to UI Top Panel visibility from
     * JobItem model
     */
    public void resetUnitOfMeasureFromJobItem() {

        // Update ItemFrame current UOM
        this.myParent.currentUOM = myParent.jobItem.design.baseUOM;

        // Setting base unit of metric
        if (myParent.jobItem.design.baseUOM == Metrics.METRIC.getValue()) {
            this.metric.setSelected(true);
            this.impDec.setSelected(false);
            this.impFrac.setSelected(false);
            this.feet.setSelected(false);

            this.myParent.jobItem.setWHDimChange(myParent.jobItem.design_WIDTH_Metric / 100,
                    myParent.jobItem.design_HEIGHT_Metric / 100, true);

        } else if (myParent.jobItem.design.baseUOM == Metrics.IMPERIAL_DECIMAL.getValue()) {
            this.metric.setSelected(false);
            this.impDec.setSelected(true);
            this.impFrac.setSelected(false);
            this.feet.setSelected(false);

            this.myParent.jobItem.setWHDimChange(myParent.jobItem.design_WIDTH_Imp / 64,
                    myParent.jobItem.design_HEIGHT_Imp / 64, true);

        } else if (myParent.jobItem.design.baseUOM == Metrics.IMPERIAL_FRACTION.getValue()) {
            this.metric.setSelected(false);
            this.impDec.setSelected(false);
            this.impFrac.setSelected(true);
            this.feet.setSelected(false);

            this.myParent.jobItem.setWHDimChange(myParent.jobItem.design_WIDTH_Imp / 64,
                    myParent.jobItem.design_HEIGHT_Imp / 64, true);

        } else if (myParent.jobItem.design.baseUOM == Metrics.FEET.getValue()) {
            this.metric.setSelected(false);
            this.impDec.setSelected(false);
            this.impFrac.setSelected(false);
            this.feet.setSelected(true);

            this.myParent.jobItem.setWHDimChange(myParent.jobItem.design_WIDTH_Imp / 64,
                    myParent.jobItem.design_HEIGHT_Imp / 64, true);
        }

//		myParent.setCostPrice();

    }

}

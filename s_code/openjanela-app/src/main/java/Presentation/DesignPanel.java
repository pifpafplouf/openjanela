package Presentation;

import openjanela.app.configuration.controller.JobItemModelController;
import openjanela.app.configuration.controller.PredefineDesignController;
import openjanela.model.entities.design.DesignFamily;
import org.apache.log4j.Logger;
import org.openjanela.component.JOpenJanelaComponent;
import util.XYConstraints;
import util.XYLayout;
import util.listeners.CursorController;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 03-18-13
 *          Time: 09:33 PM
 */
public class DesignPanel extends JDialog implements JOpenJanelaComponent {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(DesignPanel.class);

    private JPanel formPanel;
    private JPanel actionPanel;

    private JLabel lblDesignFamily;
    private JLabel lblDescription;

    private JTextField txtDescription;
    private JComboBox cboDesignFamily;

    private JButton btnSave;
    private JButton btnCancel;

    //Item frame main panel
    private ItemFrame myParent;

    //Controller components
    private PredefineDesignController predefineDesignController;
    private JobItemModelController jobItemModelController;

    /**
     * Design Panel Constructor
     */
    public DesignPanel() {

        // Call super constructor
        super();

        this.setTitle("Save default design");
        this.setModal(true);
    }

    /**
     * Design Panel Constructor
     *
     * @param myParent, ItemFrmae
     */
    public DesignPanel(ItemFrame myParent) {

        //Call main constructor
        this();

        //Setting Item Frame parent
        this.myParent = myParent;

        //Init controllers
        predefineDesignController = new PredefineDesignController();
        jobItemModelController = new JobItemModelController(this.myParent);

        //Init components UI
        initComponents();
        initValueComponents();
        initListenersComponents();

        //Setting configuration of UI
        this.setLocation((this.myParent.getWidth() - 600) / 2, (this.myParent.getHeight() - 600) / 2);
        this.setPreferredSize(new Dimension(300, 130));
        this.setIconImage(ItemFrame.iconFiles.get("openJanelaIcon").getImage());

        //Setting visible UI
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void initComponents() {

        this.setLayout(new BorderLayout());

        lblDesignFamily = new JLabel("Design Family");
        lblDescription = new JLabel("Description");

        txtDescription = new JTextField();
        cboDesignFamily = new JComboBox();

        btnSave = new JButton(ItemFrame.iconFiles.get("save"));
        btnSave.setToolTipText("Save");
        btnSave.setPreferredSize(new Dimension(60, 19));
        btnCancel = new JButton(ItemFrame.iconFiles.get("cancel"));
        btnCancel.setToolTipText("Cancel");
        btnCancel.setPreferredSize(new Dimension(60, 19));

        //Form panel configuration
        formPanel = new JPanel(new XYLayout());
        formPanel.setBorder(new EtchedBorder());
        formPanel.add(lblDescription, new XYConstraints(5, 5, 80, 23));
        formPanel.add(txtDescription, new XYConstraints(98, 5, 190, 23));
        formPanel.add(lblDesignFamily, new XYConstraints(5, 30, 80, 23));
        formPanel.add(cboDesignFamily, new XYConstraints(98, 30, 190, 23));

        this.add(formPanel, BorderLayout.CENTER);

        //Action panel configuration
        actionPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        actionPanel.setBorder(new EtchedBorder());
        actionPanel.add(btnSave);
        actionPanel.add(btnCancel);

        this.add(actionPanel, BorderLayout.SOUTH);
    }

    @Override
    public void initValueComponents() {

        //Init description value
        txtDescription.setText(this.myParent.myTopPanel.description.getText());

        //Init combo box design family
        cboDesignFamily.setModel(new DefaultComboBoxModel(predefineDesignController.
                searchDesignFamily(this.myParent.mySeries.getId()).toArray()));
    }

    @Override
    public void initListenersComponents() {

        btnSave.addActionListener(CursorController.createListener(this, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSave_actionPerformed(e);
            }
        }));

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    /**
     * Save button action performed
     *
     * @param event, ActionEvent
     */
    private void btnSave_actionPerformed(ActionEvent event) {

        try {

            if (txtDescription.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please type description to continue.", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
                txtDescription.requestFocusInWindow();

                return;
            }

            if (cboDesignFamily.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Please select a valid part family to continuing.", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
                cboDesignFamily.requestFocusInWindow();

                return;
            }

            //Save predefined design
   
            jobItemModelController.createJobItemPredefineDesign(this.myParent.jobItem, txtDescription.getText(),
                    ((DesignFamily)cboDesignFamily.getSelectedItem()).getId().getId(),
                    this.myParent.jobItem._WIDTH_Metric,
                    this.myParent.jobItem._HEIGHT_Metric,
                    this.myParent.jobItem._WIDTH_Imp,
                    this.myParent.jobItem._HEIGHT_Imp);

            //Show information message
            JOptionPane.showMessageDialog(this, "Design saved successfully.", "Information!", JOptionPane.INFORMATION_MESSAGE);

            //Close this UI
            this.dispose();

        } catch (Exception e) {
            logger.error(e.getMessage(), e);

            //Show error message
            JOptionPane.showMessageDialog(this, "Could not save the default design.", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
}

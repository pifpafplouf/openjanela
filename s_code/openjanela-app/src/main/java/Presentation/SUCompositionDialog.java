package Presentation;

import util.XYConstraints;
import util.XYLayout;

import javax.swing.*;
import java.awt.*;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 11-11-12
 * Time: 09:14 PM
 */
public class SUCompositionDialog extends JDialog {

    //Item Frame composition main parent
    private ItemFrame myParent;

    private JComboBox sealantCmb;
    private JComboBox glassCmb;
    private JComboBox glassCmb_2;
    private JComboBox glassFilmCmb;
    private JComboBox glassFilmCmb_2;
    private JComboBox glassProcessCmb_11;
    private JComboBox glassProcessCmb_12;
    private JComboBox glassProcessCmb_13;
    private JComboBox glassProcessCmb_21;
    private JComboBox glassProcessCmb_22;
    private JComboBox glassProcessCmb_23;
    private JComboBox glassSpacerCmb;
    private JComboBox glassGasCmb;
    private JComboBox processCmb;
    private JComboBox insert1idCmb;
    
    private JCheckBox hasInsert;

    private JLabel sealantLbl;
    private JLabel glassLbl;
    private JLabel glassFilmLbl;
    private JLabel glassProcess_11_Lbl;
    private JLabel glassProcess_12_Lbl;
    private JLabel glassProcess_13_Lbl;
    private JLabel glassSpacerLbl;
    private JLabel glassGasLbl;
    private JLabel processLbl;
    private JLabel insertIn_1_lbl;

    /**
     * SU Composition Dialog constructor
     *
     * @param myParent, ItemFrame composition
     * @param modal, Modal definition
     */
    public SUCompositionDialog(ItemFrame myParent, boolean modal) {

        //Constructor
        super(myParent.myParent, modal);

        //Setting parent object
        this.myParent = myParent;

        //Init components
        initComponents();

        //Set visible
        this.setTitle("Sealed Unit Composition");
        this.setLocation((this.myParent.getWidth() - 500) / 2 - 100, (this.myParent.getHeight() - 200) / 2 - 200);
        this.setPreferredSize(new Dimension(this.myParent.getWidth() - 450, this.myParent.getHeight() - 220));
        //this.setPreferredSize(new Dimension(400, 200));
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setAlwaysOnTop(true);
        this.setModal(true);
        this.setModalityType(Dialog.ModalityType.TOOLKIT_MODAL);
    }

    /**
     * Init form components values
     */
    private void initComponents() {

        //Setting Layout
        this.setLayout(new BorderLayout());

        //Init components
        sealantLbl = new JLabel("Sealant:");
        glassLbl = new JLabel("Glass:");
        glassFilmLbl = new JLabel("Film:");
        glassProcess_11_Lbl = new JLabel("Process:");
        glassProcess_12_Lbl = new JLabel("Process:");
        glassProcess_13_Lbl = new JLabel("Process:");
        glassSpacerLbl = new JLabel("Spacer:");
        glassGasLbl = new JLabel("Gas:");
        insertIn_1_lbl = new JLabel("Insert in 1:");
        processLbl = new JLabel("Process:");
        
        sealantCmb = new JComboBox();
        glassCmb = new JComboBox();
        glassCmb_2 = new JComboBox();
        glassFilmCmb = new JComboBox();
        glassFilmCmb_2 = new JComboBox();
        glassProcessCmb_11 = new JComboBox();
        glassProcessCmb_12 = new JComboBox();
        glassProcessCmb_13 = new JComboBox();
        glassProcessCmb_21 = new JComboBox();
        glassProcessCmb_22 = new JComboBox();
        glassProcessCmb_23 = new JComboBox();
        glassSpacerCmb = new JComboBox();
        glassGasCmb = new JComboBox();
        processCmb = new JComboBox();
        insert1idCmb = new JComboBox();

        hasInsert = new JCheckBox("Has Insert");
        
        //Glass pane configuration
        JPanel glassPane = new JPanel();
        glassPane.setLayout(new XYLayout());
        
        glassPane.add(sealantLbl, new XYConstraints(1, 1, 80, 22));
        glassPane.add(sealantCmb,  new XYConstraints(82, 1, 150, 22));
        
        glassPane.add(glassLbl, new XYConstraints(82, 25, 100, 22));
        glassPane.add(glassFilmLbl, new XYConstraints(234, 25, 150, 22));
        glassPane.add(glassProcess_11_Lbl, new XYConstraints(386, 25, 150, 22));
        glassPane.add(glassProcess_12_Lbl, new XYConstraints(538, 25, 150, 22));
        glassPane.add(glassProcess_13_Lbl, new XYConstraints(690, 25, 150, 22));
        glassPane.add(glassSpacerLbl, new XYConstraints(1, 73, 80, 22));
        glassPane.add(glassGasLbl, new XYConstraints(1, 97, 80, 22));
        glassPane.add(processLbl, new XYConstraints(1, 121, 80, 22));
        glassPane.add(insertIn_1_lbl, new XYConstraints(250, 97, 100, 22));
        
        glassPane.add(glassCmb, new XYConstraints(82, 49, 150, 22));
        glassPane.add(glassFilmCmb, new XYConstraints(234, 49, 150, 22));
        glassPane.add(glassProcessCmb_11, new XYConstraints(386, 49, 150, 22));
        glassPane.add(glassProcessCmb_12, new XYConstraints(538, 49, 150, 22));
        glassPane.add(glassProcessCmb_13, new XYConstraints(690, 49, 150, 22));
        glassPane.add(glassSpacerCmb, new XYConstraints(82, 73, 150, 22));
        glassPane.add(glassGasCmb, new XYConstraints(82, 97, 150, 22));
        glassPane.add(processCmb, new XYConstraints(82, 121, 150, 22));
        glassPane.add(insert1idCmb, new XYConstraints(352, 97, 150, 22));
        glassPane.add(hasInsert, new XYConstraints(250, 73, 100, 22));
        
        glassPane.add(glassCmb_2,  new XYConstraints(82, 145, 150, 22));
        glassPane.add(glassFilmCmb_2, new XYConstraints(234, 145, 150, 22));
        glassPane.add(glassProcessCmb_21, new XYConstraints(386, 145, 150, 22));
        glassPane.add(glassProcessCmb_22, new XYConstraints(538, 145, 150, 22));
        glassPane.add(glassProcessCmb_23, new XYConstraints(690, 145, 150, 22));
        
        this.add(glassPane, BorderLayout.CENTER);
    }
}

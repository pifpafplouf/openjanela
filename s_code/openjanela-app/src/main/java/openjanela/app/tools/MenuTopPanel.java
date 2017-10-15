package openjanela.app.tools;

import openjanela.commons.components.generic.GenericStyle;
import util.XYConstraints;
import util.XYLayout;

import javax.swing.*;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * <p/>
 * Tool panel menu draw canvas
 * User: emortiz
 * Date: 02-27-12
 * Time: 10:24 AM
 */
public class MenuTopPanel extends JPanel {

    //PROPERTY NAME: Generic Style
    private GenericStyle style;

    //PROPERTY NAME: Label Item Number
    private JLabel lblItemNo;
    //PROPERTY NAME: Label Item Description
    private JLabel lblDescription;
    //PROPERTY NAME: Label Qty Description
    private JLabel lblQty;
    //PROPERTY NAME: Label Unit of measure
    private JLabel lblUnitOfMeasure;
    //PROPERTY NAME: Label Series
    private JLabel lblSeries;
    //PROPERTY NAME:
    private JLabel lblW;
    //PROPERTY NAME:
    private JLabel lblH;
    //PROPERTY NAME:
    private JLabel lblFlat;
    //PROPERTY NAME:
    private JLabel lblWo;
    //PROPERTY NAME:
    private JLabel lblHo;
    //PROPERTY NAME:
    private JLabel lblByX;
    //PROPERTY NAME:
    private JLabel lblByXos;
    //PROPERTY NAME: Location
    private JLabel lblLocation;
    //PROPERTY NAME: Reference
    private JLabel lblReference;
    //PROPERTY NAME: Layout label
    private JLabel lblLayout;
    //PROPERTY NAME: View
    private JLabel lblView;


    //PROPERTY NAME: Item Number
    private JTextField txtItemNo;
    //PROPERTY NAME: Item descripcion
    private JTextField txtDescription;
    //PROPERTY NAME: Quantity
    private JTextField txtQty;
    //PROPERTY NAME:
    private JTextField txtFH;
    //PROPERTY NAME:
    private JTextField txtFW;
    //PROPERTY NAME:
    private JTextField txtOH;
    //PROPERTY NAME:
    private JTextField txtOW;
    //PROPERTY NAME:
    private JTextField txtFlatW;
    //PROPERTY NAME:
    private JTextField txtReference;
    //PROPERTY NAME: Percentage
    private JCheckBox chkPercent;
    //PROPERTY NAME: Actual Size
    private JCheckBox chkActualSize;
    //PROPERTY NAME: Opening Size
    private JCheckBox chkOpeningSize;

    //PROPERTY NAME: Metric unit
    private JRadioButton rdMetric;
    //PROPERTY NAME: Imperial Decimal unit
    private JRadioButton rdImperialDec;
    //PROPERTY NAME: Imperial Fraction unit
    private JRadioButton rdImperialFrac;
    //PROPERTY NAME: Feet unit
    private JRadioButton rdFeet;
    //PROPERTY NAME: Road just
    private JComboBox cmbRoadJust;
    //PROPERTY NAME: Location
    private JComboBox cmbLocation;

    //PROPERTY NAME: Undo Button
    private JButton btnUndo;
    //PROPERTY NAME: Select Standard Product
    private JButton btnStandardProduct;
    //PROPERTY NAME: Set Overall Size From Standard Products
    private JButton btnStdSetOverallProduct;
    //PROPERTY NAME:
    private JButton btnEditProjectLocation;

    //PROPERTY NAME:
    private boolean isWAction;
    //PROPERTY NAME:
    private boolean isHAction;

    //Init MenuTopPanel tools
    public MenuTopPanel(GenericStyle style) {

        //Setting generic style
        this.style = style;

        //Setting Layout
        setLayout(new XYLayout());

        //Init components
        initComponents();

        //Putting components location
        puttingComponents();

        //Adding listeners
        addingListeners();
    }

    /**
     * This method initialized all components into the LABEL class for main draw.
     */
    private void initComponents() {

        //************************************************************************
        //JLabel components init
        //************************************************************************

        //lblItemNo
        lblItemNo = new JLabel();
        lblItemNo.setIcon(style.getImageIcon("itemno"));
        lblItemNo.setToolTipText(style.getMessageResource("OPENJANELA.LABEL.ITEMNO"));

        //lblDescription
        lblDescription = new JLabel();
        lblDescription.setIcon(style.getImageIcon("description"));
        lblDescription.setToolTipText(style.getMessageResource("OPENJANELA.LABEL.DESCRIPTION"));

        //lblSeries
        lblSeries = new JLabel();
        lblSeries.setToolTipText(style.getMessageResource("OPENJANELA.LABEL.SERIES"));

        //lblQty
        lblQty = new JLabel();
        lblQty.setIcon(style.getImageIcon("qty"));
        lblQty.setToolTipText(style.getMessageResource("OPENJANELA.LABEL.QTY"));

        //lblW
        lblW = new JLabel();
        lblW.setIcon(style.getImageIcon("width"));

        //lblH
        lblH = new JLabel();
        lblH.setIcon(style.getImageIcon("height"));

        //lblWo
        lblWo = new JLabel();
        lblWo.setIcon(style.getImageIcon("oswidth"));

        //lblHo
        lblHo = new JLabel();
        lblHo.setIcon(style.getImageIcon("osheight"));

        //lblLocation
        lblLocation = new JLabel();
        lblLocation.setIcon(style.getImageIcon("location"));
        lblLocation.setToolTipText(style.getMessageResource("OPENJANELA.LABEL.LOCATION"));

        //lblRef
        lblReference = new JLabel();
        lblReference.setIcon(style.getImageIcon("ref1"));
        lblReference.setToolTipText(style.getMessageResource("OPENJANELA.TOOLTIPTEXT.REFERENCE"));

        //lblUnitOfMeasure
        lblUnitOfMeasure = new JLabel();
        lblUnitOfMeasure.setIcon(style.getImageIcon("uom"));
        lblUnitOfMeasure.setToolTipText(style.getMessageResource("OPENJANELA.TOOLTIPTEXT.UNITOFMEASURE"));

        //lblFlat
        lblFlat = new JLabel();
        lblFlat.setIcon(style.getImageIcon("flatwidth"));
        lblFlat.setToolTipText(style.getMessageResource("OPENJANELA.MESSAGE.FLATWIDTH"));

        //lblView
        lblView = new JLabel();
        lblView.setIcon(style.getImageIcon("viewOut"));
        lblView.setToolTipText(style.getMessageResource("OPENJANELA.TOOLTIPTEXT.VIEW.OUT"));

        //************************************************************************
        //JTextComponents components init
        //************************************************************************

        //txtItemNo
        txtItemNo = new JTextField(style.getMessageResource("OPENJANELA.TEXT.ITEMNO.NA"));
        //txtDescription
        txtDescription = new JTextField();

        //txtOW
        txtOW = new JTextField();
        txtOW.setColumns(10); //Setting 10 columns
        txtOW.setToolTipText(style.getMessageResource("OPENJANELA.MESSAGE.ENTERTOSETSIZE"));
        //txtFw
        txtFW = new JTextField();
        txtFW.setColumns(10);
        txtFW.setToolTipText(style.getMessageResource("OPENJANELA.MESSAGE.ENTERTOSETSIZE"));
        //txtOH
        txtOH = new JTextField();
        txtOH.setColumns(10); //Setting 10 columns
        txtOH.setToolTipText(style.getMessageResource("OPENJANELA.MESSAGE.ENTERTOSETSIZE"));
        //txtFH
        txtFH = new JTextField();
        txtFH.setColumns(10); //Setting 10 columns
        txtFH.setToolTipText(style.getMessageResource("OPENJANELA.MESSAGE.ENTERTOSETSIZE"));
        //txtFlatW
        txtFlatW = new JTextField();
        txtFlatW.setToolTipText(style.getMessageResource("OPENJANELA.MESSAGE.FLATWIDTH"));


        //************************************************************************
        //JButton components init
        //************************************************************************

        //rdMetric - Metric System
        rdMetric = new JRadioButton(style.getMessageResource("OPENJANELA.LABEL.METRIC"));
        rdMetric.setToolTipText(style.getMessageResource("OPENJANELA.TOOLTIPTEX.METRICMILLIMETERS"));
        //rdImperialDec - Imperial Decimal System
        rdImperialDec = new JRadioButton(style.getMessageResource("OPENJANELA.LABEL.IMPDEC"));
        rdImperialDec.setToolTipText(style.getMessageResource("OPENJANELA.TOOLTIPTEXT.IMPERIALDECIMAL"));
        //rdImperialFrac - Imperial Fractional System
        rdImperialFrac = new JRadioButton(style.getMessageResource("OPENJANELA.LABEL.IMPFRAC"));
        rdImperialFrac.setToolTipText(style.getMessageResource("OPENJANELA.TOOLTIPTEXT.IMPERIALFRACTIONS"));
        //rdFeet - Feet System
        rdFeet = new JRadioButton(style.getMessageResource("OPENJANELA.LABEL.FEET"));
        rdFeet.setToolTipText(style.getMessageResource("OPENJANELA.TOOLTIPTEXT.FEET"));
        rdFeet.setEnabled(false);
        //chkPercent - Percentage System
        chkPercent = new JCheckBox(style.getMessageResource("OPENJANELA.LABEL.PERCENTAGE"));
        chkPercent.setEnabled(false);
        //chkActualSize
        chkActualSize = new JCheckBox();
        chkActualSize.setToolTipText(style.getMessageResource("OPENJANELA.TOOLTIPTEXT.ACTUALSIZE"));
        //chkOpeningSize
        chkOpeningSize = new JCheckBox();
        chkOpeningSize.setToolTipText(style.getMessageResource("OPENJANELA.TOOLTIPTEXT.OPENINGSIZE"));

        //Button Group
        ButtonGroup metricGroup = new ButtonGroup();
        metricGroup.add(rdMetric);
        metricGroup.add(rdImperialDec);
        metricGroup.add(rdFeet);
        metricGroup.add(chkPercent);

        //Button Group
        ButtonGroup wichMetricGroup = new ButtonGroup();
        wichMetricGroup.add(chkActualSize);
        wichMetricGroup.add(chkOpeningSize);

        //CmbRoadJust
        cmbRoadJust = new JComboBox();

        //CmbLocation
        String[] locations = new String[]{"Room 1", "Room 2", "Kitchen"};
        cmbLocation = new JComboBox(locations);

        //btnStd
        btnStandardProduct = new JButton();
        btnStandardProduct.setIcon(style.getImageIcon("std"));
        btnStandardProduct.setToolTipText(style.getMessageResource("OPENJANELA.TOOLTIPTEXT.SELECTSTANDARDPRODUCTS"));

        //btnStdSet
        btnStdSetOverallProduct = new JButton();
        btnStdSetOverallProduct.setIcon(style.getImageIcon("stdset"));
        btnStdSetOverallProduct.setToolTipText(style.getMessageResource("OPENJANELA.TOOLTIPTEXT.SETSTANDARDOVERALLPRODUCTS"));

        //btnEditProjectLocation
        btnEditProjectLocation = new JButton();
        btnEditProjectLocation.setIcon(style.getImageIcon("edit"));
        btnEditProjectLocation.setToolTipText(style.getMessageResource("OPENJANELA.TOOLTIPTEXT.EDITPROJECTLOCATION"));

        //btnUndo
        btnUndo = new JButton();
        btnUndo.setIcon(style.getImageIcon("undo"));
        btnUndo.setToolTipText(style.getMessageResource("OPENJANELA.TOOLTIPTEXT.UNDO"));

    }

    /**
     * Putting components location
     */
    private void puttingComponents() {

        this.add(chkActualSize, new XYConstraints(0, 25, 20, 20));
        this.add(lblW, new XYConstraints(25, 25, 20, 20));
        this.add(txtFW, new XYConstraints(52, 25, 80, 20));
        this.add(lblByX, new XYConstraints(137, 25, 15, 20));
        this.add(lblH, new XYConstraints(152, 25, 20, 20));
        this.add(txtFH, new XYConstraints(177, 25, 80, 20));
        this.add(chkOpeningSize, new XYConstraints(0, 48, 20, 20));
        this.add(lblWo, new XYConstraints(25, 48, 20, 20));
        this.add(txtOW, new XYConstraints(52, 48, 80, 20));
        this.add(lblByXos, new XYConstraints(137, 48, 13, 20));
        this.add(lblHo, new XYConstraints(152, 48, 20, 20));
        this.add(txtOH, new XYConstraints(177, 48, 80, 19));
        this.add(cmbRoadJust, new XYConstraints(265, 48, 150, 20));
        this.add(txtItemNo, new XYConstraints(50, 1, 40, 20));
        this.add(lblItemNo, new XYConstraints(25, 1, 20, 20));
        this.add(lblDescription, new XYConstraints(100, 1, 20, 20));
        this.add(txtDescription, new XYConstraints(125, 1, 250, 19));
        this.add(lblQty, new XYConstraints(385, 1, 20, 20));
        this.add(txtQty, new XYConstraints(408, 1, 40, 20));
        this.add(lblLocation, new XYConstraints(489, 1, 20, 20));
        this.add(cmbLocation, new XYConstraints(512, 1, 186, 20));
        this.add(btnEditProjectLocation, new XYConstraints(700, 1, 30, 20));
        this.add(lblReference, new XYConstraints(489, 25, 20, 20));
        this.add(txtReference, new XYConstraints(512, 25, 220, 20));
        this.add(lblUnitOfMeasure, new XYConstraints(489, 48, 20, 20));
        this.add(rdMetric, new XYConstraints(512, 48, 45, 20));
        this.add(rdImperialDec, new XYConstraints(556, 48, 50, 20));
        this.add(rdImperialFrac, new XYConstraints(607, 48, 50, 20));
        this.add(rdFeet, new XYConstraints(656, 48, 45, 20));
        this.add(chkPercent, new XYConstraints(696, 48, 45, 20));
        this.add(btnStandardProduct, new XYConstraints(512, 68, 45, 28));
        this.add(lblView, new XYConstraints(668, 68, 30, 28));
        this.add(btnUndo, new XYConstraints(700, 68, 30, 28));
    }

    /**
     * Adding components listeners
     */
    private void addingListeners() {

    }

}

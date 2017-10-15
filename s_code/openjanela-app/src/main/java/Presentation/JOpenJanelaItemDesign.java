package Presentation;

import openjanela.app.configuration.controller.PredefineDesignController;
import openjanela.app.configuration.controller.StdDesignController;
import openjanela.app.configuration.controller.SupplierSelectorPanelController;
import openjanela.app.configuration.controller.TopPanelController;

import openjanela.model.entities.admin.CompanyPreferences;
import openjanela.model.entities.design.Design;
import openjanela.model.entities.design.DesignFamily;
import openjanela.model.entities.design.DesignStdSize;
import openjanela.model.entities.design.Metrics;
import openjanela.model.entities.orderEntry.CartDefault;
import openjanela.model.entities.partner.AdjustmentRo;
import openjanela.model.entities.partner.Partner;
import openjanela.model.entities.partner.PartnerDefault;
import openjanela.model.entities.partner.Series;

import org.apache.log4j.Logger;
import org.jdesktop.swingx.JXTable;
import org.openjanela.commons.util.zip.GZipFile;
import org.openjanela.component.JOpenJanelaComponent;
import org.openjanela.data.ApplicationBaseRulesApp;
import org.openjanela.data.ApplicationMainBaseApp;
import org.openjanela.data.UserPreferences;

import util.ProjectDetails;
import util.UOMConvert;
import util.XYConstraints;
import util.XYLayout;
import util.listeners.CursorController;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 * <p/>
 * This Item Design Panel show basic configuration option for OpenJanela
 * configurator init.
 *
 * @author Eddy Montenegro
 * @version 2.0.8 Date: 01-22-13 Time: 08:13 PM
 */
public class JOpenJanelaItemDesign extends JDialog implements JOpenJanelaComponent {

    // Apache log4j
    private static final Logger logger = Logger.getLogger(JOpenJanelaItemDesign.class);

    private static final double NOMINAL_METRIC_WIDTH = 1000.00;
    private static final double NOMINAL_METRIC_HEIGHT = 1000.00;
    private static final double NOMINAL_IMPERIAL_WIDTH = 40.000000;
    private static final double NOMINAL_IMPERIAL_HEIGHT = 40.000000;

    // Components GUI properties
    private JPanel pnlMain = new JPanel();
    private JPanel pnlLeft = new JPanel();
    private JPanel pnlRight = new JPanel();
    private JPanel pnlRadios = new JPanel();
    private JPanel pnlDimType = new JPanel();
    private JPanel pnlDimLayout = new JPanel();
    private JPanel pnlDesignCenter = new JPanel();
    private JPanel pnlDesignSizeCenter = new JPanel();
    private JPanel pnlSupplier;
    private JPanel pnlDimension;
    private JPanel pnlDesign;

    private JLabel lblSupplier;
    private JLabel lblSeries;
    private JLabel lblOpenSize;
    private JLabel lblWidth;
    private JLabel lblHeight;
    private JLabel lblWidthRo;
    private JLabel lblHeightRo;
    private JLabel lblDesignFamily;

    private JComboBox cboSupplier;
    private JComboBox cboSeries;
    private JComboBox cboAdjustmentRo;
    private JComboBox cboDesignFamily;

    private JTextField txtWidth;
    private JTextField txtHeight;
    private JTextField txtWidthRo;
    private JTextField txtHeightRo;

    private JRadioButton optViewOut;
    private JRadioButton optViewIn;
    private JRadioButton optMetric;
    private JRadioButton optImpDec;
    private JRadioButton optImpFrac;

    private ButtonGroup dimType = new ButtonGroup();

    private JRadioButton custom = new JRadioButton("Custom Design");
    private JRadioButton stdSize = new JRadioButton("Std. Size Design");
    private JRadioButton stdProduct = new JRadioButton("Standard Product");

    private JCheckBox chkOverallDim;
    private JCheckBox lblSize;

    private JXTable tblDesign;
    private JXTable sizesTable = new JXTable();

    private JButton btnCancel;
    private JButton btnNext;

    // User Preferences
    private UserPreferences userPref;

    //Company Preferences
    private CompanyPreferences companyPref;

    // Parent GUI
    private final JFrame myParent;

    // Controllers
    private final SupplierSelectorPanelController supplierController;
    private final PredefineDesignController predefineController;
    private final TopPanelController topPanelController;
    private final StdDesignController stdDesignController = new StdDesignController();

    int designID = 0;
    int currentMI = 0;
    int wi = 0;
    int hi = 0;
    int wm = 0;
    int hm = 0;

    public DecimalFormat noDecimal = new DecimalFormat("0");
    public DecimalFormat oneDecimal = new DecimalFormat("0.0");
    public DecimalFormat twoDecimal = new DecimalFormat("0.00");
    public DecimalFormat sixDecimal = new DecimalFormat("0.000000");

    public int selectedType = 1;

    public Design myDesign = new Design();
    public DesignStdSize mySize = new DesignStdSize();

    /**
     * OpenJanela Item Design Constructor
     */
    public JOpenJanelaItemDesign(JFrame frame, boolean modal) {

        // Call super constructor
        super(frame, ProjectDetails.PROJECT_NAME + " - " + ProjectDetails.PROJECT_VERSION, modal);

        // Init parent GUI component
        this.myParent = frame;

        // Setting Icon Image
        this.setIconImage(this.myParent.getIconImage());

        // Init controller components
        this.supplierController = new SupplierSelectorPanelController();
        this.predefineController = new PredefineDesignController();
        this.topPanelController = new TopPanelController();
    }

    /**
     * OpenJanela Item Design Constructor
     *
     * @param userPref, Using UserPreferences class for handling main configuration option
     */
    public JOpenJanelaItemDesign(JFrame frame, boolean modal, UserPreferences userPref) {

        // Call super constructor
        this(frame, modal);

        // Init user preferences
        this.userPref = userPref;

        this.designID = 0;

        try {

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {

                    // Init Busy cursor
                    JOpenJanelaItemDesign.this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

                    // Init components GUI design
                    initComponents();
                    initListenersComponents();
                    initValueComponents();

                    // Init Default Cursor
                    JOpenJanelaItemDesign.this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

                    int w = (int) (myParent.getWidth() * 0.80);
                    int h = (int) (myParent.getHeight() * 0.80);

                    JOpenJanelaItemDesign.this.setPreferredSize(new Dimension(w, h));
                    JOpenJanelaItemDesign.this.setLocation((myParent.getWidth() / 2) - (w / 2),
                            (myParent.getHeight() / 2) - (h / 2));

                    JOpenJanelaItemDesign.this.setResizable(false);
                    JOpenJanelaItemDesign.this.setModal(true);
                    JOpenJanelaItemDesign.this.pack();
                    JOpenJanelaItemDesign.this.setVisible(true);
                }
            });

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    public void initComponents() {

        // Init panel components

        this.pnlMain.setLayout(new BorderLayout());
        this.pnlLeft.setLayout(new BorderLayout());
        this.pnlRight.setLayout(new BorderLayout());
        this.pnlRadios.setLayout(new XYLayout());
        this.pnlDimType.setLayout(new XYLayout());
        this.pnlDimLayout.setLayout(new BorderLayout());
        this.setLayout(new BorderLayout());

        initPnlSupplierComponents();
        initPnlDimensionComponents();
        initPnlDesignComponents();

        pnlDimLayout.add(pnlDimension, BorderLayout.CENTER);
        pnlDimLayout.add(this.pnlDimType, BorderLayout.SOUTH);

        pnlLeft.add(pnlSupplier, BorderLayout.NORTH);
        pnlLeft.add(pnlDimLayout, BorderLayout.CENTER);

        pnlRight.add(pnlDesign, BorderLayout.CENTER);

        this.pnlMain.add(pnlLeft, BorderLayout.WEST);
        this.pnlMain.add(pnlRight, BorderLayout.CENTER);

        this.add(pnlMain, BorderLayout.CENTER);

        this.btnNext.setEnabled(true);
    }

    @Override
    public void initValueComponents() {

        // Setting default nominal metric width & height
        if (this.userPref.getUomID() == 1) {
            txtWidth.setText(NOMINAL_METRIC_WIDTH + "");
            txtHeight.setText(NOMINAL_METRIC_HEIGHT + "");
        } else {
            txtWidth.setText(NOMINAL_IMPERIAL_WIDTH + "");
            txtHeight.setText(NOMINAL_IMPERIAL_HEIGHT + "");
        }

        // Preparing values for suppliers combo box
        List<Partner> suppliers = supplierController.getPartners();

        cboSupplier.setModel(new DefaultComboBoxModel(suppliers.toArray()));
        cboSupplier.setSelectedIndex(0);

        for (Partner supplier : suppliers) {
            if (supplier.getId() == this.userPref.getSupplierID()) {
                cboSupplier.setSelectedItem(supplier);
            }
        }

        //Init Default Overall Dimensions
        if (this.userPref.isOpening_size()) {
            lblSize.setSelected(false);
            chkOverallDim.setSelected(true);
        }

        this.btnNext.setEnabled(true);
    }

    @Override
    public void initListenersComponents() {

        // Supplier selected combo box
        cboSupplier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cboSupplier_actionPerformed(e);
            }
        });

        // Series selected combo box
        cboSeries.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cboSeries_actionPerformed(e);
            }
        });

        // Design family selected combo box
        cboDesignFamily.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initTblDesignComponent();
            }
        });

        cboAdjustmentRo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (selectedType != 1) {
                    calculateOpeningSize();
                }

                if (chkOverallDim.isSelected()) {
                    // Calculate Actual Size

                    calculateActualSize();

                } else {
                    // Calculate Opening Size
                    calculateOpeningSize();
                }
            }
        });

        // Overall dimension check box
        chkOverallDim.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    txtWidth.setEnabled(false);
                    txtHeight.setEnabled(false);
                    if (selectedType == 1) {
                        txtWidthRo.setEnabled(true);
                        txtHeightRo.setEnabled(true);
                    }
                    cboAdjustmentRo.setEnabled(true);
                }

                if (e.getStateChange() == ItemEvent.DESELECTED) {
                    txtWidth.setEnabled(true);
                    txtHeight.setEnabled(true);

                    txtWidthRo.setEnabled(false);
                    txtHeightRo.setEnabled(false);
                    cboAdjustmentRo.setEnabled(false);
                }
            }
        });

        optMetric.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (optMetric.isSelected()) {
                    currentMI = 1;
                    if (!chkOverallDim.isSelected()) {
                        txtWidth.setText(twoDecimal.format(NOMINAL_METRIC_WIDTH));
                        txtHeight.setText(twoDecimal.format(NOMINAL_METRIC_HEIGHT));

                        calculateOpeningSize();
                    } else {
                        txtWidthRo.setText(twoDecimal.format(NOMINAL_METRIC_WIDTH));
                        txtHeightRo.setText(twoDecimal.format(NOMINAL_METRIC_HEIGHT));

                        calculateActualSize();
                    }
                }
            }
        });

        optImpDec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (optImpDec.isSelected()) {
                    currentMI = 2;
                    if (!chkOverallDim.isSelected()) {
                        txtWidth.setText(sixDecimal.format(NOMINAL_IMPERIAL_WIDTH));
                        txtHeight.setText(sixDecimal.format(NOMINAL_IMPERIAL_HEIGHT));

                        calculateOpeningSize();
                    } else {
                        txtWidthRo.setText(sixDecimal.format(NOMINAL_IMPERIAL_WIDTH));
                        txtHeightRo.setText(sixDecimal.format(NOMINAL_IMPERIAL_HEIGHT));

                        calculateActualSize();
                    }
                }
            }
        });

        optImpFrac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (optImpFrac.isSelected()) {
                    currentMI = 3;
                    if (!chkOverallDim.isSelected()) {
                        txtWidth.setText(sixDecimal.format(NOMINAL_IMPERIAL_WIDTH));
                        txtHeight.setText(sixDecimal.format(NOMINAL_IMPERIAL_HEIGHT));

                        calculateOpeningSize();
                    } else {
                        txtWidthRo.setText(sixDecimal.format(NOMINAL_IMPERIAL_WIDTH));
                        txtHeightRo.setText(sixDecimal.format(NOMINAL_IMPERIAL_HEIGHT));

                        calculateActualSize();
                    }
                }
            }
        });

        txtWidth.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                try {
                    // Calculate Opening Size
                    calculateOpeningSize();
                } catch (NumberFormatException ex) {
                    logger.error(ex.getMessage(), ex);
                    JOptionPane.showMessageDialog(null, "Value incorrect. Please retype.", "Error Message", JOptionPane.ERROR_MESSAGE);
                    txtWidth.requestFocusInWindow();
                }
            }
        });

        txtWidth.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                txtWidth.selectAll();
            }
        });

        txtWidth.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    // Calculate Opening Size
                    calculateOpeningSize();
                } catch (NumberFormatException ex) {
                    logger.error(ex.getMessage(), ex);
                    JOptionPane.showMessageDialog(null, "Value incorrect. Please retype.", "Error Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        txtHeight.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                try {
                    // Calculate Opening Size
                    calculateOpeningSize();
                } catch (NumberFormatException ex) {
                    logger.error(ex.getMessage(), ex);
                    JOptionPane.showMessageDialog(null, "Value incorrect. Please retype.", "Error Message", JOptionPane.ERROR_MESSAGE);
                    txtHeight.requestFocusInWindow();
                }
            }
        });

        txtHeight.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                txtHeight.selectAll();
            }
        });

        txtHeight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    calculateOpeningSize();
                } catch (NumberFormatException ex) {
                    logger.error(ex.getMessage(), ex);
                    JOptionPane.showMessageDialog(null, "Value incorrect. Please retype.", "Error Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        txtWidthRo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                try {
                    // Calculate Actual Size
                    calculateActualSize();
                } catch (NumberFormatException ex) {
                    logger.error(ex.getMessage(), ex);
                    JOptionPane.showMessageDialog(null, "Value incorrect. Please retype.", "Error Message", JOptionPane.ERROR_MESSAGE);
                    txtWidthRo.requestFocusInWindow();
                }
            }
        });

        txtWidthRo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                txtWidthRo.selectAll();
            }
        });

        txtWidthRo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    calculateActualSize();
                } catch (NumberFormatException ex) {
                    logger.error(ex.getMessage(), ex);
                    JOptionPane.showMessageDialog(null, "Value incorrect. Please retype.", "Error Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        txtHeightRo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                try {
                    // Calculate Actual size
                    calculateActualSize();
                } catch (NumberFormatException ex) {
                    logger.error(ex.getMessage(), ex);
                    JOptionPane.showMessageDialog(null, "Value incorrect. Please retype.", "Error Message", JOptionPane.ERROR_MESSAGE);
                    txtHeightRo.requestFocusInWindow();
                }
            }
        });

        txtHeightRo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                txtHeightRo.selectAll();
            }
        });

        txtHeightRo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    calculateActualSize();
                } catch (NumberFormatException ex) {
                    logger.error(ex.getMessage(), ex);
                    JOptionPane.showMessageDialog(null, "Value incorrect. Please retype.", "Error Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Design table mouse listener event
        tblDesign.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                designsTable_mousePressed(e);
            }
        });

        sizesTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                sizesTable_mousePressed(e);
            }
        });

        this.custom.addActionListener(CursorController.createListener(this, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doCustomDesign();
            }

        }));

        this.stdSize.addActionListener(CursorController.createListener(this, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doStdSize();
            }

        }));

        this.stdProduct.addActionListener(CursorController.createListener(this, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedType = 3;
                doStdProduct();
            }
        }));

        // Cancel button action event
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Next button action event
        btnNext.addActionListener(CursorController.createListener(this, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnNext_actionPerformed(e);
            }
        }));
    }

    // *****************************************************************************************************************
    // Design GUI Components values
    // *****************************************************************************************************************

    private void doCustomDesign() {
        selectedType = 1;
        pnlDesignCenter.remove(pnlDesignSizeCenter);
        this.setDimsEnabled(true);
        this.cboAdjustmentRo.setEnabled(false);
        if (this.optMetric.isSelected()) {
            this.txtWidth.setText(myDesign.getWidth() / 100d + "");
            this.txtHeight.setText(myDesign.getHeight() / 100d + "");
        } else {
            this.txtWidth.setText(myDesign.getWidthi() / 64d + "");
            this.txtHeight.setText(myDesign.getHeighti() / 64d + "");
        }
        this.calculateOpeningSize();

        validate();
        repaint();
    }

    private void doStdSize() {

        if (designID > 0) {
            selectedType = 2;
            this.initSizeTblDesignComponent();
            validate();
            repaint();

        } else {
            selectedType = 1;
        }
    }

    private void doStdProduct() {

        if (designID > 0) {
            selectedType = 3;
            this.initSizeTblDesignComponent();
            validate();
            repaint();

        } else {
            selectedType = 1;
        }
    }

    private void setDimsEnabled(boolean enable) {
        this.txtHeight.setEnabled(enable);
        this.txtWidth.setEnabled(enable);
        this.txtWidthRo.setEnabled(enable);
        this.txtHeightRo.setEnabled(enable);
        this.lblSize.setSelected(true);
        this.lblSize.setEnabled(enable);
        this.chkOverallDim.setEnabled(enable);
        this.sizesTable.setCellSelectionEnabled(true);
    }

    private void initPnlSupplierComponents() {

        lblSupplier = new JLabel("Supplier");
        lblSeries = new JLabel("Series");

        cboSupplier = new JComboBox();
        cboSeries = new JComboBox();

        optViewIn = new JRadioButton("Inside View");
        optViewOut = new JRadioButton("Outside View");

        // Set view out selected
        optViewOut.setSelected(true);

        ButtonGroup grpView = new ButtonGroup();
        grpView.add(optViewIn);
        grpView.add(optViewOut);

        JPanel pnlLeft = new JPanel();
        pnlLeft.setLayout(new XYLayout());

        pnlSupplier = new JPanel();
        pnlSupplier.setLayout(new XYLayout());
        pnlSupplier.setPreferredSize(new Dimension(this.getWidth(), 60));
        pnlSupplier.setBorder(new EtchedBorder());

        pnlSupplier.add(lblSupplier, new XYConstraints(5, 5, 60, 19));
        pnlSupplier.add(cboSupplier, new XYConstraints(62, 5, 170, 19));

        pnlSupplier.add(lblSeries, new XYConstraints(5, 30, 60, 19));
        pnlSupplier.add(cboSeries, new XYConstraints(62, 30, 170, 19));

        optViewIn.setEnabled(false);
    }

    private void initPnlDimensionComponents() {

        lblSize = new JCheckBox("Frame Size:");

        this.lblOpenSize = new JLabel("Opening Size:");
        lblWidth = new JLabel("W x");
        lblHeight = new JLabel("H");
        lblWidthRo = new JLabel("Wr");
        lblHeightRo = new JLabel("Hr");

        chkOverallDim = new JCheckBox("Opening Size");

        cboAdjustmentRo = new JComboBox();
        cboAdjustmentRo.setEnabled(false);

        txtWidth = new JTextField();
        txtWidth.setHorizontalAlignment(JLabel.RIGHT);
        txtHeight = new JTextField();
        txtHeight.setHorizontalAlignment(JLabel.RIGHT);

        txtWidthRo = new JTextField();
        txtWidthRo.setHorizontalAlignment(JLabel.RIGHT);
        txtWidthRo.setEnabled(false);
        txtHeightRo = new JTextField();
        txtHeightRo.setHorizontalAlignment(JLabel.RIGHT);
        txtHeightRo.setEnabled(false);

        optMetric = new JRadioButton("Metric   ");
        optImpDec = new JRadioButton("Imp. 0.00");
        optImpFrac = new JRadioButton("Imp. x/y ");

        optMetric.setPreferredSize(new Dimension(80, 20));
        optImpDec.setPreferredSize(new Dimension(80, 20));
        optImpFrac.setPreferredSize(new Dimension(80, 20));

        // Set metric option selected
        optMetric.setSelected(true);

        ButtonGroup grpMetric = new ButtonGroup();
        grpMetric.add(optMetric);
        grpMetric.add(optImpDec);
        grpMetric.add(optImpFrac);

        pnlDimension = new JPanel();
        pnlDimension.setLayout(new XYLayout());
        pnlDimension.setBorder(new EtchedBorder());
        pnlDimType.setBorder(new EtchedBorder());

        pnlDimension.add(lblSize, new XYConstraints(5, 5, 100, 19));
        pnlDimension.add(txtWidth, new XYConstraints(127, 5, 85, 19));
        pnlDimension.add(lblWidth, new XYConstraints(214, 5, 25, 19));
        pnlDimension.add(txtHeight, new XYConstraints(243, 5, 85, 19));
        pnlDimension.add(lblHeight, new XYConstraints(330, 5, 25, 19));

        pnlDimension.add(chkOverallDim, new XYConstraints(5, 30, 120, 19));
        pnlDimension.add(txtWidthRo, new XYConstraints(127, 30, 85, 19));
        pnlDimension.add(lblWidthRo, new XYConstraints(214, 30, 25, 19));
        pnlDimension.add(txtHeightRo, new XYConstraints(243, 30, 85, 19));
        pnlDimension.add(lblHeightRo, new XYConstraints(330, 30, 25, 19));

        this.dimType.add(lblSize);
        this.dimType.add(chkOverallDim);
        lblSize.setSelected(true);

        JLabel overallL = new JLabel("Measure Type:");

        pnlDimension.add(overallL, new XYConstraints(10, 52, 120, 19));
        pnlDimension.add(cboAdjustmentRo, new XYConstraints(127, 52, 201, 19));

        if (this.userPref.getUomID() == 1) {
            // Set metric option selected
            optMetric.setSelected(true);
            currentMI = 1;
            pnlDimType.add(optMetric, new XYConstraints(5, 2, 100, 19));
            pnlDimType.add(optImpDec, new XYConstraints(5, 24, 100, 19));
            pnlDimType.add(optImpFrac, new XYConstraints(5, 45, 100, 19));
        } else {
            // Set metric option selected
            optImpDec.setSelected(true);
            currentMI = 2;
            pnlDimType.add(optImpDec, new XYConstraints(5, 2, 100, 19));
            pnlDimType.add(optImpFrac, new XYConstraints(5, 24, 100, 19));
            pnlDimType.add(optMetric, new XYConstraints(5, 45, 100, 19));

        }

        pnlDimType.add(optViewOut, new XYConstraints(250, 2, 100, 19));
        pnlDimType.add(optViewIn, new XYConstraints(250, 24, 100, 19));

    }

    private void initPnlDesignComponents() {

        tblDesign = new JXTable(new DefaultTableModel());
        tblDesign.setPreferredSize(new Dimension(this.getWidth(), 400));
        tblDesign.setEditable(false);
        tblDesign.setCellSelectionEnabled(true);
        tblDesign.setTableHeader(null);

        sizesTable = new JXTable(new DefaultTableModel());
        sizesTable.setPreferredSize(new Dimension(this.getWidth(), 110));
        sizesTable.setEditable(false);
        sizesTable.setCellSelectionEnabled(true);
        sizesTable.setTableHeader(null);

        lblDesignFamily = new JLabel("Family");

        cboDesignFamily = new JComboBox();

        btnCancel = new JButton("Cancel");
        btnNext = new JButton("Next >");

        // Top panel design5
        JPanel pnlfamily = new JPanel();
        pnlfamily.setLayout(new XYLayout());
        pnlfamily.setBorder(new EtchedBorder());
        pnlfamily.setPreferredSize(new Dimension(this.getWidth(), 30));

        pnlfamily.add(lblDesignFamily, new XYConstraints(1, 5, 70, 19));
        pnlfamily.add(cboDesignFamily, new XYConstraints(75, 5, 150, 19));
        pnlfamily.add(this.custom, new XYConstraints(230, 5, 120, 19));
        pnlfamily.add(this.stdSize, new XYConstraints(352, 5, 120, 19));
        pnlfamily.add(this.stdProduct, new XYConstraints(474, 5, 150, 19));
        this.custom.setEnabled(false);
        this.stdSize.setEnabled(false);
        this.stdProduct.setEnabled(false);

        // Center panel design
        pnlDesignCenter.setLayout(new BorderLayout());
        pnlDesignCenter.add(new JScrollPane(tblDesign), BorderLayout.CENTER);
        if (this.selectedType > 1) {
            pnlDesignCenter.add(this.pnlDesignSizeCenter, BorderLayout.SOUTH);
        } else {
            pnlDesignCenter.remove(pnlDesignSizeCenter);
        }

        // Bottom panel design
        JPanel pnlBottom = new JPanel();
        JPanel pnlBottomLeft = new JPanel();
        JPanel pnlBottomCenter = new JPanel();
        JPanel pnlBottomRight = new JPanel();
        pnlBottom.setLayout(new BorderLayout());
        pnlBottomLeft.setLayout(new BorderLayout());
        pnlBottomCenter.setLayout(new BorderLayout());
        pnlBottomRight.setLayout(new BorderLayout());

        pnlBottom.setBorder(new EtchedBorder());
        pnlBottom.setPreferredSize(new Dimension(this.getWidth(), 40));

        btnCancel.setPreferredSize(new Dimension(80, 26));
        btnNext.setPreferredSize(new Dimension(80, 26));

        pnlBottomLeft.add(btnCancel, BorderLayout.CENTER);

        pnlBottomRight.add(btnNext, BorderLayout.CENTER);

        pnlBottom.add(pnlBottomLeft, BorderLayout.WEST);
        pnlBottom.add(pnlBottomCenter, BorderLayout.CENTER);
        pnlBottom.add(pnlBottomRight, BorderLayout.EAST);

        // Main design panel
        pnlDesign = new JPanel();
        pnlDesign.setLayout(new BorderLayout());

        custom.setSelected(true);
        ButtonGroup itemType = new ButtonGroup();
        itemType.add(custom);
        itemType.add(stdSize);
        itemType.add(stdProduct);

        pnlDesign.add(pnlfamily, BorderLayout.NORTH);
        pnlDesign.add(pnlDesignCenter, BorderLayout.CENTER);
        pnlDesign.add(pnlBottom, BorderLayout.SOUTH);
    }

    private void initTblDesignComponent() {

        tblDesign.setCellSelectionEnabled(true);

        // Get predefined design list
        DesignFamily designFamily = (DesignFamily) this.cboDesignFamily.getSelectedItem();
        List<Design> designList = predefineController.searchPredefineDesignModels(designFamily.getId().getId(),
                designFamily.getId().getSeriesId());

        // Calculate row value
        double column = 6.0;
        int row = designList.size() / (int) column;
        double rowValue = designList.size() / column;

        if ((rowValue - row) > 0) {
            row++;
        }

        // Init table model settings
        DefaultTableModel tableModel = (DefaultTableModel) tblDesign.getModel();
        tableModel.setRowCount(row);

        tableModel.setColumnCount((int) column);

        TableColumnModel columnModel = tblDesign.getColumnModel();

        int position = 0;

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < column; j++) {

                if (columnModel.getColumnCount() < column) {
                    TableColumn tableColumn = new TableColumn();
                    tableColumn.setCellRenderer(new ImageRenderer());

                    columnModel.addColumn(tableColumn);
                }

                // Evaluate positon is not grather than design list size to set
                // value into table model
                if (position <= (designList.size() - 1)) {
                    Design design = designList.get(position);
                    tblDesign.getModel().setValueAt(design, i, j);
                } else {
                    Design design = new Design();
                    design.setDescription("");
                    design.setScaledImage(new byte[0]);
                    tblDesign.getModel().setValueAt(design, i, j);
                }

                position++;
            }
        }

        // Setting renderer column model
        ImageRenderer imageRenderer = new ImageRenderer();

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            tblDesign.setRowHeight(i, 160);
        }

        for (int j = 0; j < columnModel.getColumnCount(); j++) {
            columnModel.getColumn(j).setWidth(130);
            columnModel.getColumn(j).setCellRenderer(imageRenderer);
        }

        tblDesign.repaint();
    }

    private void initSizeTblDesignComponent() {

        sizesTable.setCellSelectionEnabled(true);

        // Get predefined design list
        List<DesignStdSize> sizeList = stdDesignController.getStdSizes(designID, ((Series) cboSeries.getSelectedItem()).
                getId());

        if (sizeList.size() > 0) {

            // Calculate row value
            double column = 6.0;
            int row = sizeList.size() / (int) column;
            double rowValue = sizeList.size() / column;

            if ((rowValue - row) > 0) {
                row++;
            }

            // Init table model settings
            DefaultTableModel tableModel = (DefaultTableModel) this.sizesTable.getModel();
            tableModel.setRowCount(row);

            tableModel.setColumnCount((int) column);

            TableColumnModel columnModel = sizesTable.getColumnModel();

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            sizesTable.setDefaultRenderer(String.class, centerRenderer);

            // Represent the index position in the designList
            int position = 0;

            for (int i = 0; i < row; i++) {

                for (int j = 0; j < column; j++) {

                    if (columnModel.getColumnCount() < column) {
                        TableColumn tableColumn = new TableColumn();
                        columnModel.addColumn(tableColumn);
                    }

                    // Evaluate positon is not grather than design list size to set value into table model
                    if (position <= (sizeList.size() - 1)) {
                        DesignStdSize stdSize = sizeList.get(position);
                        sizesTable.getModel().setValueAt(stdSize, i, j);
                    } else {
                        DesignStdSize stdSize = new DesignStdSize();
                        stdSize.setDescription("");
                        sizesTable.getModel().setValueAt(stdSize, i, j);
                    }

                    position++;
                }
            }

            for (int i = 0; i < tableModel.getRowCount(); i++) {
                sizesTable.setRowHeight(i, 25);
            }

            for (int j = 0; j < columnModel.getColumnCount(); j++) {
                columnModel.getColumn(j).setWidth(130);
                columnModel.getColumn(j).setCellRenderer(centerRenderer);
            }

            sizesTable.repaint();

            this.pnlDesignSizeCenter.setLayout(new BorderLayout());
            this.pnlDesignSizeCenter.removeAll();
            this.pnlDesignSizeCenter.add(new JScrollPane(this.sizesTable), BorderLayout.CENTER);
            this.pnlDesignSizeCenter.setPreferredSize(new Dimension(this.getWidth(), 200));

            this.setDimsEnabled(false);
            this.pnlDesignCenter.add(pnlDesignSizeCenter, BorderLayout.SOUTH);
            this.cboAdjustmentRo.setEnabled(true);

        }
    }

    // *****************************************************************************************************************
    // Implements listeners events values
    // *****************************************************************************************************************

    /**
     * ComboBox supplier GUI action listener event
     *
     * @param e, ActionEvent
     */
    private void cboSupplier_actionPerformed(ActionEvent e) {

        Partner supplier = (Partner) cboSupplier.getSelectedItem();

        List<Series> series = ApplicationMainBaseApp.getInstance().getSeries(supplier.getId());
        if (series.size() <= 0) {
            series = supplierController.getSeries(0);
        }

        cboSeries.setModel(new DefaultComboBoxModel(series.toArray()));

        if (cboSeries.getModel().getSize() > 0) {
            cboSeries.setSelectedIndex(0);
        }

        // ************************************************************************************
        // Setting default series from user preferencies
        // ************************************************************************************
        Series defSeries = null;

        for (Object pd : userPref.getPartnerDefaults().toArray()) {
            if (((PartnerDefault) pd).getPartnerDefaultPK().getDefaulttype() == 3) {
                defSeries = ApplicationMainBaseApp.getInstance().getSeriesByID(
                        ((PartnerDefault) pd).getPartnerDefaultPK()
                                .getOptions());
            }
        }

        for (Object pd : userPref.getCartDefaults().toArray()) {
            if (((CartDefault) pd).getCartDefaultPK().getDefaultType() == 3) {
                defSeries = ApplicationMainBaseApp.getInstance().getSeriesByID(
                        ((CartDefault) pd).getCartDefaultPK().getOptions());
            }
        }

        if (defSeries != null) {
            cboSeries.setSelectedItem(defSeries);
        }

        // ************************************************************************************
        // Setting Last Series Selected from Applications
        // ************************************************************************************
        int _last_series_select = ApplicationBaseRulesApp.getInstance()
                .getSeriesID();
        if (_last_series_select > 0) {
            Series _last_selected_series = ApplicationMainBaseApp.getInstance()
                    .getSeriesByID(_last_series_select);

            cboSeries.setSelectedItem(_last_selected_series);
        }
    }

    /**
     * ComboBox series GUI action listener event
     *
     * @param e, ActionEvent
     */
    private void cboSeries_actionPerformed(ActionEvent e) {

        Series series = (Series) cboSeries.getSelectedItem();

        // Init comboBox adjustment RO
        List<AdjustmentRo> ros = topPanelController.getROs(series.getId(), false);
        cboAdjustmentRo.setModel(new DefaultComboBoxModel(ros.toArray()));
        if (cboAdjustmentRo.getModel().getSize() > 0) {
            cboAdjustmentRo.setSelectedIndex(0);
        }

        // Init comboBox design family
        List<DesignFamily> designFamilies = predefineController.searchDesignFamily(series.getId());
        cboDesignFamily.setModel(new DefaultComboBoxModel(designFamilies.toArray()));
        if (cboDesignFamily.getModel().getSize() > 0) {
            cboDesignFamily.setSelectedIndex(0);
        }
    }

    /**
     * Select a default design for configurator open
     *
     * @param e, MouseEvent
     */
    private void designsTable_mousePressed(MouseEvent e) {

        int row = tblDesign.getSelectedRow();
        int col = tblDesign.getSelectedColumn();

        // Get design from model
        myDesign = (Design) tblDesign.getModel().getValueAt(row, col);

        if (myDesign != null && myDesign.getId() != null) {

            designID = myDesign.getId().getId();

            List<DesignStdSize> sizeList = stdDesignController.getStdSizes(designID, ((Series) cboSeries.getSelectedItem()).getId());

            this.custom.setEnabled(false);
            this.stdSize.setEnabled(false);
            this.stdProduct.setEnabled(false);

            if (sizeList.size() > 0) {

                this.custom.setEnabled(true);
                this.stdSize.setEnabled(true);
                this.stdProduct.setEnabled(true);

                if (!this.custom.isSelected()) {
                    initSizeTblDesignComponent();
                }

                this.validate();
                this.repaint();

            } else {
                this.custom.setSelected(true);
                doCustomDesign();
            }

            this.chkOverallDim.setSelected(false);

            if (this.optMetric.isSelected()) {
                this.txtWidth.setText(myDesign.getWidth() / 100d + "");
                this.txtHeight.setText(myDesign.getHeight() / 100d + "");
            } else {
                this.txtWidth.setText(myDesign.getWidthi() / 64d + "");
                this.txtHeight.setText(myDesign.getHeighti() / 64d + "");
            }
        }
    }

    private void sizesTable_mousePressed(MouseEvent e) {

        int row = this.sizesTable.getSelectedRow();
        int col = sizesTable.getSelectedColumn();

        // Get design from model
        mySize = (DesignStdSize) sizesTable.getModel().getValueAt(row, col);

        if (mySize != null && mySize.getId() != null) {
            this.wi = mySize.getId().getWidthi();
            this.wm = mySize.getId().getWidthm();
            this.hi = mySize.getId().getHeighti();
            this.hm = mySize.getId().getHeightm();

            if (this.optMetric.isSelected()) {
                this.txtWidth.setText(wm / 100d + "");
                this.txtHeight.setText(hm / 100d + "");
            } else {
                this.txtWidth.setText(wi / 64d + "");
                this.txtHeight.setText(hi / 64d + "");
            }

            calculateOpeningSize();
        }

        validate();
        repaint();
    }

    /**
     * Next action performed call openjanela configurator design
     *
     * @param event, ActionEvent
     */
    private void btnNext_actionPerformed(ActionEvent event) {

        // Init application
        boolean isInitApp = true;

        this.btnNext.setEnabled(false);

        // 1. Setting supplier
        Partner supplier = (Partner) cboSupplier.getSelectedItem();
        this.userPref.setSupplierID(supplier.getId());
        this.userPref.setDescription(this.myDesign.getDescription());
        if (this.selectedType > 1) {
            this.userPref.setDescription(this.myDesign.getDescription() + " " + mySize.getDescription());
        }

        // 2. Setting series
        Series series = (Series) cboSeries.getSelectedItem();
        this.userPref.setSeriesID(series.getId());

        if (this.mySize != null && this.mySize.getId() != null && this.mySize.getId().getDesignid() > 0) {
            this.userPref.setItemType(this.selectedType);
            this.userPref.setPrice(this.mySize.getPrice());
        } else {
            this.userPref.setItemType(1);
        }

        // 3. Setting viewOut - viewIn
        if (optViewOut.isSelected()) {
            this.userPref.setViewOut(true);
        } else if (optViewIn.isSelected()) {
            this.userPref.setViewOut(false);
        }

        // 4. Setting design family
        DesignFamily designFamily = (DesignFamily) cboDesignFamily.getSelectedItem();
        if (designFamily != null) {
            this.userPref.setDesignFamilyID(designFamily.getId().getId());
        }

        // 5. Setting size width and height
        try {
            if (!this.optImpFrac.isSelected()) {
                this.userPref.setWidth(Double.parseDouble(txtWidth.getText()));
                this.userPref.setHeight(Double.parseDouble(txtHeight.getText()));
            } else {
                this.userPref.setWidth(Double.parseDouble(UOMConvert.fractionToImperial(txtWidth.getText())));
                this.userPref.setHeight(Double.parseDouble(UOMConvert.fractionToImperial(txtHeight.getText())));
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Width or Height value incorrect. Please retype value.",
                    "Error Message", JOptionPane.ERROR_MESSAGE);

            isInitApp = false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Width or Height value incorrect. Please retype value.",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            isInitApp = false;
        }

        // 6. Setting Unit of Metric selected
        if (optMetric.isSelected()) {
            this.userPref.setUomID(Metrics.METRIC.getValue());
        } else if (optImpDec.isSelected()) {
            this.userPref.setUomID(Metrics.IMPERIAL_DECIMAL.getValue());
        } else if (optImpFrac.isSelected()) {
            this.userPref.setUomID(Metrics.IMPERIAL_FRACTION.getValue());
        }

        // 7. Setting Adjustment Ro
        AdjustmentRo ro = (AdjustmentRo) cboAdjustmentRo.getSelectedItem();
        this.userPref.setAdjustmentRoID(ro.getAdjustmentRoPK().getId());

        if (chkOverallDim.isSelected()) {
            this.userPref.setOpening_size(true);
        }

        // 8. Setting Predefined Design Identification Id
        if (designID != 0) {
            this.userPref.setDesignID(designID);
        } else {
            this.userPref.setDesignID(0);
        }

        if (isInitApp) {

            // Setting JDialog parent to UserPref to use them later
            this.userPref.setParent(this);

            // Call OpenJanela ItemFrame
            new ItemFrame(this.myParent, true, this.userPref);

            // Close this GUI panel
            this.dispose();
        }
    }

    // *****************************************************************************************************************
    // Implementation Action Methods
    // *****************************************************************************************************************

    /**
     * Calculate Actual Size for Width & Height
     */
    public void calculateActualSize() {

        try {

            BigDecimal widthOA = new BigDecimal(Double.parseDouble(txtWidthRo.getText()));
            BigDecimal heightOA = new BigDecimal(Double.parseDouble(txtHeightRo.getText()));

            BigDecimal width = widthOA.subtract(new BigDecimal(getOAW())).setScale(20, BigDecimal.ROUND_UP);
            BigDecimal height = heightOA.subtract(new BigDecimal(getOAH())).setScale(20, BigDecimal.ROUND_UP);

            if (currentMI == 1) {
                txtWidth.setText(twoDecimal.format(width));
                txtHeight.setText(twoDecimal.format(height));
                txtWidthRo.setText(twoDecimal.format(widthOA));
                txtHeightRo.setText(twoDecimal.format(heightOA));
            } else if (currentMI == 2) {
                txtWidth.setText(sixDecimal.format(width));
                txtHeight.setText(sixDecimal.format(height));
                txtWidthRo.setText(sixDecimal.format(widthOA));
                txtHeightRo.setText(sixDecimal.format(heightOA));
            } else {
                txtWidth.setText(orderEntryUtility.UOMConvertData.imperialToFraction(width + ""));
                txtHeight.setText(orderEntryUtility.UOMConvertData.imperialToFraction(height + ""));
                txtWidthRo.setText(orderEntryUtility.UOMConvertData.imperialToFraction(widthOA + ""));
                txtHeightRo.setText(orderEntryUtility.UOMConvertData.imperialToFraction(heightOA + ""));
            }

        } catch (NumberFormatException e) {
            logger.error(e.getMessage(), e);
            JOptionPane.showMessageDialog(this, "Error trying to calculate dimensions", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            JOptionPane.showMessageDialog(this, "Error trying to calculate dimensions", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Calculate Opening Size Ro for Width & Height
     */
    public void calculateOpeningSize() {

        try {

            BigDecimal width = new BigDecimal(Double.parseDouble(txtWidth.getText()));
            BigDecimal height = new BigDecimal(Double.parseDouble(txtHeight.getText()));

            BigDecimal widthOA = new BigDecimal(Double.parseDouble(txtWidth.getText()) + "");
            widthOA = widthOA.add(new BigDecimal(getOAW())).setScale(20, BigDecimal.ROUND_UP);

            BigDecimal heightOA = new BigDecimal(Double.parseDouble(txtHeight.getText()) + "");
            heightOA = heightOA.add(new BigDecimal(getOAH())).setScale(20, BigDecimal.ROUND_UP);

            if (currentMI == 1) {
                txtWidth.setText(twoDecimal.format(width));
                txtHeight.setText(twoDecimal.format(height));
                txtWidthRo.setText(twoDecimal.format(widthOA));
                txtHeightRo.setText(twoDecimal.format(heightOA));
            } else if (currentMI == 2) {
                txtWidth.setText(sixDecimal.format(width));
                txtHeight.setText(sixDecimal.format(height));
                txtWidthRo.setText(sixDecimal.format(widthOA));
                txtHeightRo.setText(sixDecimal.format(heightOA));
            } else {
                txtWidth.setText(orderEntryUtility.UOMConvertData.imperialToFraction(width + ""));
                txtHeight.setText(orderEntryUtility.UOMConvertData.imperialToFraction(height + ""));
                txtWidthRo.setText(orderEntryUtility.UOMConvertData.imperialToFraction(widthOA + ""));
                txtHeightRo.setText(orderEntryUtility.UOMConvertData.imperialToFraction(heightOA + ""));
            }

        } catch (NumberFormatException e) {
            logger.error(e.getMessage(), e);
            JOptionPane.showMessageDialog(this, "Error trying to calculate dimensions", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            JOptionPane.showMessageDialog(this, "Error trying to calculate dimensions", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Return width adjustment RO
     *
     * @return double
     */
    public double getOAW() {

        AdjustmentRo ro = (AdjustmentRo) cboAdjustmentRo.getSelectedItem();

        if (ro != null) {
            if (optMetric.isSelected()) {
                return ro.getRow() / 100d;
            } else {
                return ro.getRowi() / 64d;
            }
        }

        return 0;
    }

    /**
     * Return Height adjustment RO
     *
     * @return double
     */
    public double getOAH() {

        AdjustmentRo ro = (AdjustmentRo) cboAdjustmentRo.getSelectedItem();

        if (ro != null) {
            if (optMetric.isSelected()) {
                return ro.getRoh() / 100d;
            } else {
                return ro.getRohi() / 64d;
            }
        }

        return 0;
    }

    /**
     * This Inner class represents a ImageRenderer
     */
    public class ImageRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                       int row, int column) {

            Design design = (Design) value;

            JLabel imageLbl = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            try {
                imageLbl.setIcon(new ImageIcon(GZipFile.gzipDecompress(design.getScaledImage())));
                imageLbl.setHorizontalAlignment(CENTER);
            } catch (IOException e) {
                imageLbl.setIcon(null);
            }

            if (design.getId() != null) {
                imageLbl.setText(design.getId().getId().toString().trim() + " - " + design.getDescription().trim());

            } else {
                imageLbl.setText("");
            }

            imageLbl.setSize(130, 160);
            imageLbl.setVerticalTextPosition(JLabel.BOTTOM);
            imageLbl.setHorizontalTextPosition(SwingConstants.CENTER);

            return imageLbl;
        }
    }
}

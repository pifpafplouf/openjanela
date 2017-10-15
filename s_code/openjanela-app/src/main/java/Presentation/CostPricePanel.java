package Presentation;

import Model.BillOfMat;
import Model.DesignGlass;
import openjanela.app.configuration.controller.FinancialSummaryController;
import openjanela.model.entities.admin.TypePriceCategory;
import openjanela.model.entities.orderEntry.OrderItemsCart;
import orderEntryUtility.OEUtility;

import org.apache.log4j.Logger;
import org.jdesktop.swingx.JXTable;
import org.openjanela.component.JOpenJanelaComponent;

import util.XYConstraints;
import util.XYLayout;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 03-21-13
 *          Time: 11:07 AM
 */
public class CostPricePanel extends JPanel implements JOpenJanelaComponent {

    // Apache log4j
    private static final Logger logger = Logger.getLogger(CostPricePanel.class);

    // Type price categories
    public static final int BASE = 1;
    public static final int OPTIONS = 2;
    public static final int GLASS = 3;
    public static final int GRID = 4;
    public static final int LABOR = 5;
    public static final int SHIPPING = 6;
    public static final int SERVICES = 7;
    public static final int OTHER = 100;

    // Type price values
    public static final int COST = 1;
    public static final int COST_USER = 2;
    public static final int PRICE = 3;
    public static final int PRICE_USER = 4;
    public static final int DISCOUNT = 5;
    public static final int NET_PRICE = 6;

    private ItemFrame myParent;

    private JPanel financialSummaryPanel;
    private JPanel summaryShowPanel;

    private JXTable financialSummaryTbl;
    private JScrollPane financialSummaryScrollPane;
    

    private JLabel lblCost;
    private JLabel lblCalculateCost;
    private JLabel lblPrice;
    private JLabel lblCalculatePrice;
    private JLabel lblDiscount;
    private JLabel lblNetPrice;

    private JTextField txtCost;
    private JTextField txtCalculateCost;
    private JTextField txtPrice;
    private JTextField txtCalculatePrice;
    private JTextField txtDiscount;
    private JTextField txtNetPrice;

    private BigDecimal calculatedCost = new BigDecimal("0");
    private BigDecimal cost = new BigDecimal("0");
    private BigDecimal calculatedPrice = new BigDecimal("0");
    private BigDecimal price = new BigDecimal("0");
    private BigDecimal discP = new BigDecimal("0");
    private BigDecimal netPrice = new BigDecimal("0");
    private BigDecimal totalCommission = new BigDecimal("0");
 
    private double netList =0;
   
    

    private JCheckBox chkCost;
    private JCheckBox chkDetailedCost;
    private JCheckBox chkPrice;
    private JCheckBox chkDetailedPrice;
    private JCheckBox chkDiscount;
    private JCheckBox chkDetailedDiscount;

    public List<SummaryDetailItem> priceItems = new ArrayList<SummaryDetailItem>();

    // Controller access
    private FinancialSummaryController financialSummaryController;

    /**
     * Cost Price Panel Constructor
     *
     * @param myParent, ItemFrame
     */
    public CostPricePanel(ItemFrame myParent) {

        // Init ItemFrame parent
        this.myParent = myParent;

        // Init Controller
        financialSummaryController = new FinancialSummaryController(myParent);

        initComponents();
        initValueComponents();
        initListenersComponents();

        if (!this.myParent.userPref.isChange_discount()) {

            financialSummaryTbl.setEnabled(false);
            chkCost.setSelected(false);
            chkDetailedCost.setSelected(false);
            chkPrice.setSelected(false);
            chkPrice.setEnabled(false);
            chkDetailedPrice.setSelected(false);
            chkDetailedPrice.setEnabled(false);
            chkDiscount.setSelected(false);
            chkDiscount.setEnabled(false);
            chkDetailedDiscount.setSelected(false);
            chkDetailedDiscount.setEnabled(false);
        }
    }

    @Override
    public void initComponents() {

        // Init panels
        doFinancialSummaryPanel();
        doSummaryShowPanel();

        // Setting default Layout
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(330, 430));

        this.add(summaryShowPanel, BorderLayout.NORTH);
        this.add(financialSummaryPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    @Override
    public void initValueComponents() {

        //***************************************************
        //Setting User Rights
        //***************************************************
        if (!this.myParent.userPref.isView_cost()) {

            this.lblCalculateCost.setVisible(false);
            this.lblCost.setVisible(false);
            this.txtCalculateCost.setVisible(false);
            this.txtCost.setVisible(false);

            this.chkCost.setEnabled(false);
            this.chkDetailedCost.setEnabled(false);
        }

        if (!this.myParent.userPref.isChange_discount()) {

            this.chkDiscount.setEnabled(false);
            this.chkDetailedDiscount.setEnabled(false);
        }
    }

    @Override
    public void initListenersComponents() {

        chkDetailedCost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chkDetailedCost.isSelected()) {

                    myParent.costManual = true;
                    myParent.priceManual = false;
                    myParent.discountManual = false;

                    txtCost.setText(OEUtility.displayCurrency(cost, myParent.locale));
                    txtCalculateCost.setText(OEUtility.displayCurrency(calculatedCost, myParent.locale));

                    financialSummaryPanel.setVisible(true);
                }
            }
        });

        chkDetailedPrice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chkDetailedPrice.isSelected()) {

                    myParent.priceManual = true;
                    myParent.costManual = false;
                    myParent.discountManual = false;

                    txtCost.setText(OEUtility.displayCurrency(cost, myParent.locale));
                    txtCalculateCost.setText(OEUtility.displayCurrency(calculatedCost, myParent.locale));

                    txtPrice.setText(OEUtility.displayCurrency(price, myParent.locale));
                    txtCalculatePrice.setText(OEUtility.displayCurrency(calculatedPrice, myParent.locale));
                    txtNetPrice.setText(OEUtility.displayCurrency(netPrice, myParent.locale));

                    txtDiscount.setText(OEUtility.displayPercent(discP.doubleValue(), myParent.locale));

                    financialSummaryPanel.setVisible(true);
//
//                    price = calculatedPrice;
//                    netPrice = calculatedPrice;
//                    discP = new BigDecimal(0);

                    for (SummaryDetailItem item : priceItems) {
                        item.setPrice(item.getPrice());
                        item.setCalculatePrice(item.getCalculatePrice());
                        item.setDiscount(item.getDiscount());
                        item.setNetPrice(item.getNetPrice());
                    }

                    txtPrice.setEditable(false);
                    txtDiscount.setEditable(false);
                }
            }
        });

        chkDetailedDiscount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chkDetailedDiscount.isSelected()) {

                    myParent.discountManual = true;
                    myParent.priceManual = false;
                    myParent.costManual = false;

                    txtCost.setText(OEUtility.displayCurrency(cost, myParent.locale));
                    txtCalculateCost.setText(OEUtility.displayCurrency(calculatedCost, myParent.locale));

                    txtPrice.setText(OEUtility.displayCurrency(calculatedPrice, myParent.locale));
                    txtDiscount.setText(OEUtility.displayPercent(0, myParent.locale));
                    txtNetPrice.setText(OEUtility.displayCurrency(calculatedPrice, myParent.locale));
                    financialSummaryPanel.setVisible(true);

                    price = calculatedPrice;
                    netPrice = calculatedPrice;
                    discP = new BigDecimal(0);

                    for (SummaryDetailItem item : priceItems) {
                        item.setPrice(item.getCalculatePrice());
                        item.setDiscount(new BigDecimal(0));
                        item.setNetPrice(item.getCalculatePrice());
                    }

                    txtPrice.setEditable(false);
                    txtDiscount.setEditable(false);
                }
            }
        });

        chkCost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chkCost.isSelected()) {

                    myParent.costManual = true;
                    myParent.priceManual = false;
                    myParent.discountManual = false;

                    financialSummaryPanel.setVisible(false);

                    txtCost.setText(OEUtility.displayCurrency(cost, myParent.locale));
                    txtCalculateCost.setText(OEUtility.displayCurrency(calculatedCost, myParent.locale));

                    txtCost.setEditable(true);
                    txtPrice.setEditable(false);
                    txtDiscount.setEditable(false);

                    txtCost.requestFocusInWindow();
                }
            }
        });

        chkPrice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chkPrice.isSelected()) {

                    myParent.priceManual = true;
                    myParent.costManual = false;
                    myParent.discountManual = false;

                    financialSummaryPanel.setVisible(false);

                    txtCalculateCost.setText(OEUtility.displayCurrency(calculatedCost, myParent.locale));
                    txtCost.setText(OEUtility.displayCurrency(cost, myParent.locale));
                    txtPrice.setText(OEUtility.displayCurrency(calculatedPrice, myParent.locale));
                    txtDiscount.setText(OEUtility.displayPercent(0, myParent.locale));
                    txtNetPrice.setText(OEUtility.displayCurrency(calculatedPrice, myParent.locale));

                    txtPrice.setEditable(true);
                    txtCost.setEditable(false);
                    txtDiscount.setEditable(false);

                    price = calculatedPrice;
                    netPrice = calculatedPrice;
                    discP = new BigDecimal(0);

                    txtPrice.requestFocusInWindow();
                }
            }
        });

        chkDiscount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chkDiscount.isSelected()) {

                    myParent.discountManual = true;
                    myParent.priceManual = false;
                    myParent.costManual = false;

                    financialSummaryPanel.setVisible(false);

                    txtCalculateCost.setText(OEUtility.displayCurrency(calculatedCost, myParent.locale));
                    txtCost.setText(OEUtility.displayCurrency(cost, myParent.locale));
                    txtPrice.setText(OEUtility.displayCurrency(calculatedPrice, myParent.locale));
                    txtDiscount.setText(OEUtility.displayPercent(0, myParent.locale));
                    txtNetPrice.setText(OEUtility.displayCurrency(calculatedPrice, myParent.locale));

                    txtDiscount.setEditable(true);
                    txtCost.setEditable(false);
                    txtPrice.setEditable(false);

                    price = calculatedPrice;
                    netPrice = calculatedPrice;
                    discP = new BigDecimal(0);
                    txtDiscount.requestFocusInWindow();
                }
            }
        });

        txtCost.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                txtCost.selectAll();
            }
        });

        txtCost.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                txtCost_actionPerformed();
            }
        });

        txtCost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCost_actionPerformed();
            }
        });

        txtPrice.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                txtPrice.selectAll();
            }
        });

        txtPrice.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                txtPrice_actionPerformed();
            }
        });

        txtPrice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPrice_actionPerformed();
            }
        });

        txtDiscount.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                txtDiscount.selectAll();
            }

            @Override
            public void focusLost(FocusEvent e) {
                txtDiscount_actionPerformed();
            }

        });

        txtDiscount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDiscount_actionPerformed();
            }
        });
    }

    /**
     * Calculate Global Cost Action Performed
     */
    private void txtCost_actionPerformed() {

        try {

            // Setting default variables values
            this.myParent.costManual = true;
            this.myParent.manualCostEntered = true;
            this.myParent.priceManual = false;
            this.myParent.manualPriceEntered = false;
            this.myParent.discountManual = false;

            // Get Manual Price
            BigDecimal manualCost = OEUtility.currencyToBigDecimal(txtCost.getText(), this.myParent.locale);

            // Calculate price variation
            for (SummaryDetailItem priceItem : this.priceItems) {

                // Calculate Percentage
                BigDecimal costPerc = priceItem.getCalculateCost().divide(this.calculatedCost, 4,
                        BigDecimal.ROUND_HALF_EVEN);

                // Calculate Price
                priceItem.setCost(manualCost.multiply(costPerc));
            }

            // Init Financial Summary Table Model
            ((FinancialSummaryTableModel) financialSummaryTbl.getModel()).fireTableDataChanged();

            // Update Global Variables
            this.cost = manualCost;

            // Update UI components
            txtCost.setText(OEUtility.displayCurrency(this.cost, myParent.locale));

        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Calculate Global Price Action Performed
     */
    private void txtPrice_actionPerformed() {

        try {

            // Setting default variable values
            this.myParent.priceManual = true;
            this.myParent.manualPriceEntered = true;
            this.myParent.discountManual = false;

            // Get Manual Price
            BigDecimal manualPrice = OEUtility.currencyToBigDecimal(txtPrice.getText(), this.myParent.locale);

            // Calculate price variation
            for (SummaryDetailItem priceItem : this.priceItems) {
                priceItem.setDiscount(new BigDecimal("0"));

                // Calculate Percentage
                BigDecimal pricePerc = priceItem.getCalculatePrice().divide(this.calculatedPrice, 4,
                        BigDecimal.ROUND_HALF_EVEN);

                // Calculate Price
                priceItem.setPrice(manualPrice.multiply(pricePerc));

                // Calculate Net Price
                priceItem.setNetPrice(priceItem.getPrice());
            }

            // Init Financial Summary Table Model
            ((FinancialSummaryTableModel) financialSummaryTbl.getModel()).fireTableDataChanged();

            // Update Global Variables
            this.price = manualPrice;
            this.netPrice = manualPrice;
            this.discP = new BigDecimal("0");

            this.myParent.netPrice = this.netPrice;
            this.myParent.calcPrice = this.calculatedPrice;

            // Update UI components
            txtPrice.setText(OEUtility.displayCurrency(this.price, myParent.locale));
            txtDiscount.setText(OEUtility.displayPercent(this.discP.doubleValue(), myParent.locale));
            txtNetPrice.setText(OEUtility.displayCurrency(this.netPrice, myParent.locale));

        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Calculate Global Discount Action Performed
     */
    public void txtDiscount_actionPerformed() {

        // Setting default variable values
        this.myParent.discountManual = true;
        this.myParent.priceManual = false;

        this.discP = new BigDecimal(txtDiscount.getText().replaceAll("%", ""));

        if (discP.doubleValue() > 100) {
            JOptionPane.showMessageDialog(this.myParent, "Discount > 100% !", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Calculate Global Discount Value
        for (SummaryDetailItem priceItem : priceItems) {

            // Setting Discount Value
            priceItem.setDiscount(new BigDecimal(discP + ""));
            priceItem.setPrice(priceItem.getCalculatePrice());
            priceItem.setNetPrice(priceItem.getCalculatePrice());

            // Discount amount
            BigDecimal discount = priceItem.getCalculatePrice().multiply(priceItem.getDiscount().
                    divide(new BigDecimal("100"), 4, BigDecimal.ROUND_HALF_EVEN));

            priceItem.setPrice(priceItem.getPrice().subtract(discount));
            priceItem.setNetPrice(priceItem.getPrice());
        }

        // Calculate discount amount and net price
        BigDecimal dv = this.price.multiply(discP.divide(new BigDecimal("100")));
        this.netPrice = this.price.subtract(dv);

        // Update UI Component
        this.txtNetPrice.setText(OEUtility.displayCurrency(this.netPrice, myParent.locale));
        this.txtDiscount.setText(OEUtility.displayPercent(this.discP.divide(new BigDecimal("100")).doubleValue(), myParent.locale));
        this.myParent.netPrice = this.netPrice;
        this.myParent.calcPrice = this.calculatedPrice;
    }

    /**
     * Init Financial Summary Information for View in JXTable
     */
    public void initFinancialSummaryData() throws Exception {

        try {

            // ********************************************************************
            // Reset Save Model
            // ********************************************************************
            this.myParent.saveModel = this.myParent.calcBom;

            // ********************************************************************
            // Reset Calculation for Bill of Materials - Changes done
            // ********************************************************************
            if (!this.myParent.calcBom) {
                return;
            }

            // Evaluate if Job Item is property for evaluate
            if (this.myParent.jobItem == null) {
                return;
            }

            // Array List of Summary Items
            this.priceItems.clear();

            // Build Design Bill of Materials
            this.myParent.bomView.buildDesignBOM(true);

            // Reset Glass Bill of Materials
            this.myParent.jobItem.design.resetGlassBom();

            //Init Tree Table BOM Values
            this.myParent.bomView.initTreeTableBomValues();

            // Reset bom job item calculation
            this.myParent.calcBom = false;

            Collection<BillOfMat> boms = this.myParent.jobItem.bom;
            Collection<DesignGlass> glassBoms = this.myParent.jobItem.glassBOM;

            // Get price categories
            List<TypePriceCategory> priceCategories = financialSummaryController.getTypesPriceCategories();

            for (TypePriceCategory typePrice : priceCategories) {

                // Create Item for Financial Summary
                SummaryDetailItem summaryItem = new SummaryDetailItem(typePrice.getId(), typePrice.getDescription());

                for (BillOfMat bom : boms) {

                    if ((typePrice.getId() == bom.priceCat) && !bom.remote) {

                        // Calculate cost
                        BigDecimal calculateCost = summaryItem.getCalculateCost();
                        calculateCost = calculateCost.add(bom.cost);
                        summaryItem.setCalculateCost(calculateCost);

                        // Summary cost
                        BigDecimal cost = summaryItem.getCost();
                        cost = cost.add(bom.cost);
                        summaryItem.setCost(cost);

                        // Calculate price
                        BigDecimal calculatePrice = summaryItem.getCalculatePrice();
                        calculatePrice = calculatePrice.add(bom.price);
                        summaryItem.setCalculatePrice(calculatePrice);

                        // Summary price
                        BigDecimal price = summaryItem.getPrice();
                        price = price.add(bom.price);
                        summaryItem.setPrice(price);

                        // Summary net price
                        summaryItem.setNetPrice(price);
                    }
                }

                for (DesignGlass glassBom : glassBoms) {

                    if ((typePrice.getId() == glassBom.priceCat) && !glassBom.remote) {

                        // Calculate cost
                        BigDecimal calculateCost = summaryItem.getCalculateCost();
                        calculateCost = calculateCost.add(glassBom.cost);
                        summaryItem.setCalculateCost(calculateCost);

                        // Summary cost
                        BigDecimal cost = summaryItem.getCost();
                        cost = cost.add(glassBom.cost);
                        summaryItem.setCost(cost);

                        // Calculate price
                        BigDecimal calculatePrice = summaryItem.getCalculatePrice();
                        calculatePrice = calculatePrice.add(glassBom.price);
                        summaryItem.setCalculatePrice(calculatePrice);

                        // Summary price
                        BigDecimal price = summaryItem.getPrice();
                        price = price.add(glassBom.price);
                        summaryItem.setPrice(price);

                        // Summary net price
                        summaryItem.setNetPrice(price);
                    }
                }

                priceItems.add(summaryItem);
            }

            // Init Table Model
            ((FinancialSummaryTableModel) financialSummaryTbl.getModel()).fireTableDataChanged();

            // Calculate total price
            calculateTotalPrice();

            if (this.myParent.userPref.isView_cost()) {
                txtCalculateCost.setText(OEUtility.displayCurrency(this.calculatedCost, this.myParent.locale));
                txtCost.setText(OEUtility.displayCurrency(cost, myParent.locale));
            } else {
                txtCalculateCost.setText("--");
                txtCost.setText("--");
            }

            if (this.myParent.userPref.isView_price()) {
                txtCalculatePrice.setText(OEUtility.displayCurrency(calculatedPrice, myParent.locale));
            } else {
                txtCalculatePrice.setText("--");
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new Exception("Please check rules configuration, some operation(s) did not complete.", e);
        }
    }

    /**
     * Init Financial Summary Information for View in JXTable
     *
     * @param orderItems, OrderItemsCart
     */
    public void initItemFinancialSummaryData(OrderItemsCart orderItems) {

        try {

            // Clear Array List of Summary Items
            this.priceItems.clear();

            // Get price categories
            List<TypePriceCategory> priceCategories = this.financialSummaryController.getTypesPriceCategories();

            for (TypePriceCategory typePrice : priceCategories) {

                // Create Item for Financial Summary
                SummaryDetailItem summaryItem = new SummaryDetailItem(typePrice.getId(), typePrice.getDescription());

                if (typePrice.getId() == CostPricePanel.BASE) {
                    summaryItem.setCalculateCost(orderItems.getCostBase());
                    summaryItem.setCost(orderItems.getCostBaseUser());
                    summaryItem.setCalculatePrice(orderItems.getPriceBase());
                    summaryItem.setPrice(orderItems.getPriceBaseUser());
                    summaryItem.setDiscount(orderItems.getDiscountBase());
                }

                if (typePrice.getId() == CostPricePanel.OPTIONS) {
                    summaryItem.setCalculateCost(orderItems.getCostOptions());
                    summaryItem.setCost(orderItems.getCostOptionsUser());
                    summaryItem.setCalculatePrice(orderItems.getPriceOptions());
                    summaryItem.setPrice(orderItems.getPriceOptionsUser());
                    summaryItem.setDiscount(orderItems.getDiscountOptions());
                }

                if (typePrice.getId() == CostPricePanel.GLASS) {
                    summaryItem.setCalculateCost(orderItems.getCostGlass());
                    summaryItem.setCost(orderItems.getCostGlassUser());
                    summaryItem.setCalculatePrice(orderItems.getPriceGlass());
                    summaryItem.setPrice(orderItems.getPriceGlassUser());
                    summaryItem.setDiscount(orderItems.getDiscountGlass());
                }

                if (typePrice.getId() == CostPricePanel.GRID) {
                    summaryItem.setCalculateCost(orderItems.getCostGrids());
                    summaryItem.setCost(orderItems.getCostGridsUser());
                    summaryItem.setCalculatePrice(orderItems.getPriceGrids());
                    summaryItem.setPrice(orderItems.getPriceGridsUser());
                    summaryItem.setDiscount(orderItems.getDiscountGrids());
                }

                if (typePrice.getId() == CostPricePanel.LABOR) {
                    summaryItem.setCalculateCost(orderItems.getCostLabor());
                    summaryItem.setCost(orderItems.getCostLaborUser());
                    summaryItem.setCalculatePrice(orderItems.getPriceLabor());
                    summaryItem.setPrice(orderItems.getPriceLaborUser());
                    summaryItem.setDiscount(orderItems.getDiscountLabor());
                }

                if (typePrice.getId() == CostPricePanel.SHIPPING) {
                    summaryItem.setCalculateCost(orderItems.getCostShip());
                    summaryItem.setCost(orderItems.getCostShipUser());
                    summaryItem.setCalculatePrice(orderItems.getPriceShip());
                    summaryItem.setPrice(orderItems.getPriceShipUser());
                    summaryItem.setDiscount(orderItems.getDiscountShip());
                }

                if (typePrice.getId() == CostPricePanel.SERVICES) {
                    summaryItem.setCalculateCost(orderItems.getCostInstall());
                    summaryItem.setCost(orderItems.getCostInstallUser());
                    summaryItem.setCalculatePrice(orderItems.getPriceInstall());
                    summaryItem.setPrice(orderItems.getPriceInstallUser());
                    summaryItem.setDiscount(orderItems.getDiscountInstall());
                }

                if (typePrice.getId() == CostPricePanel.OTHER) {
                    summaryItem.setCalculateCost(orderItems.getCostOther());
                    summaryItem.setCost(orderItems.getCostOtherUser());
                    summaryItem.setCalculatePrice(orderItems.getPriceOther());
                    summaryItem.setPrice(orderItems.getPriceOtherUser());
                    summaryItem.setDiscount(orderItems.getDiscountOther());
                }

                this.priceItems.add(summaryItem);
            }

            // Init Table Model
            ((FinancialSummaryTableModel) this.financialSummaryTbl.getModel()).fireTableDataChanged();

            // Calculate total price
            calculateInitTotalPrice(orderItems);

            if (this.myParent.userPref.isView_cost()) {
                this.txtCost.setText(OEUtility.displayCurrency(this.cost, this.myParent.locale));
            } else {
                this.txtCost.setText("--");
            }
            if (this.myParent.userPref.isView_price()) {
                this.txtCalculatePrice.setText(OEUtility.displayCurrency(this.calculatedPrice, this.myParent.locale));
            } else {
                this.txtCalculatePrice.setText("--");
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * Calculate Total Price for Items
     */
    public void calculateTotalPrice() {

        boolean priceCalc = false;

        if (!this.myParent.costManual && !this.myParent.priceManual && !this.myParent.discountManual) {

            //Init Calculated Cost
            this.calculatedCost = new BigDecimal("0");
            this.cost = new BigDecimal("0");

            //Init Calculated Price
            this.calculatedPrice = new BigDecimal("0");
            this.price = new BigDecimal("0");
            this.netPrice = new BigDecimal("0");
            this.netPrice = new BigDecimal("0");

            //Init Discount
            this.discP = new BigDecimal("0");

            for (SummaryDetailItem item : this.priceItems) {

                //Calculate Cost
                this.calculatedCost = this.calculatedCost.add(item.getCalculateCost());
                this.cost = this.cost.add(item.getCost());

                //Calculate Price
                this.calculatedPrice = this.calculatedPrice.add(item.getCalculatePrice());
                this.price = this.price.add(item.getPrice());

                //Calculate Discount & Net Price
                this.discP = this.discP.add(item.getDiscount());

                BigDecimal dv = (item.getPrice().multiply(this.discP.divide(new BigDecimal("100"), 4, BigDecimal.ROUND_HALF_EVEN)).
                        setScale(4, BigDecimal.ROUND_HALF_EVEN));

                this.netPrice = this.netPrice.add(item.getPrice().subtract(dv));
            }

            priceCalc = true;

        } else if (this.myParent.costManual && !this.myParent.priceManual && !this.myParent.discountManual) {

            //Init Calculated Cost
            this.calculatedCost = new BigDecimal("0");
            this.cost = new BigDecimal("0");

            for (SummaryDetailItem item : this.priceItems) {

                //Calculate Cost
                this.calculatedCost = this.calculatedCost.add(item.getCalculateCost());
                this.cost = this.cost.add(item.getCost());
            }

        } else if (this.myParent.priceManual && !this.myParent.costManual && !this.myParent.discountManual) {

            //Init Calculated Cost
            this.calculatedCost = new BigDecimal("0");
            this.cost = new BigDecimal("0");

            //Init Calculated Price
            this.calculatedPrice = new BigDecimal("0");
            this.price = new BigDecimal("0");
            this.netPrice = new BigDecimal("0");

            //Init Discount
            this.discP = new BigDecimal("0");

            for (SummaryDetailItem item : priceItems) {

                //Calculate Cost
                this.calculatedCost = this.calculatedCost.add(item.getCalculateCost());
                this.cost = this.cost.add(item.getCost());

                //Calculate Price
                this.calculatedPrice = this.calculatedPrice.add(item.getCalculatePrice());
                this.price = this.price.add(item.getPrice());

                //Calculate Discount & Net Price
                this.discP = this.discP.add(item.getDiscount());

                BigDecimal dv = (item.getPrice().multiply(discP.divide(new BigDecimal("100"), 4, BigDecimal.ROUND_HALF_EVEN)).
                        setScale(4, BigDecimal.ROUND_HALF_EVEN));

                this.netPrice = this.netPrice.add(item.getPrice().subtract(dv));
            }

            priceCalc = true;

        } else if (this.myParent.discountManual && !this.myParent.costManual && !this.myParent.priceManual) {

            //Init Calculated Cost
            this.calculatedCost = new BigDecimal("0");
            this.cost = new BigDecimal("0");

            //Init Calculated Price
            this.calculatedPrice = new BigDecimal("0");
            this.price = new BigDecimal("0");
            this.netPrice = new BigDecimal("0");

            //Init Discount
            this.discP = new BigDecimal("0");

            for (SummaryDetailItem item : priceItems) {

                //Calculate Cost
                this.calculatedCost = this.calculatedCost.add(item.getCalculateCost());
                this.cost = this.cost.add(item.getCost());

                //Calculate Price
                this.calculatedPrice = this.calculatedPrice.add(item.getCalculatePrice());
                this.price = this.price.add(item.getPrice());
                this.netPrice = this.netPrice.add(item.getNetPrice());
            }

            priceCalc = true;
        }

        // Update UI Components
        if (!priceCalc && discP.doubleValue() > 0 && calculatedPrice.doubleValue() > 0) {

            BigDecimal dv = (price.multiply(discP.divide(new BigDecimal("100"), 4, BigDecimal.ROUND_HALF_EVEN)).
                    setScale(4, BigDecimal.ROUND_HALF_EVEN));

            this.netPrice = price.subtract(dv);
        }

        // Evaluate Standard Sizes & Prices
        if (this.myParent.userPref.getPrice() != null && this.myParent.userPref.getPrice().doubleValue() > 0) {
            this.calculatedPrice = this.myParent.userPref.getPrice();
            this.price = this.myParent.userPref.getPrice();
            this.netPrice = this.myParent.userPref.getPrice();
        }

        this.myParent.netPrice = this.netPrice;
        this.myParent.calcPrice = this.calculatedPrice;

        this.txtCost.setText(OEUtility.displayCurrency(this.cost, this.myParent.locale));
        this.txtCalculateCost.setText(OEUtility.displayCurrency(this.calculatedCost, this.myParent.locale));
        this.txtPrice.setText(OEUtility.displayCurrency(this.price, this.myParent.locale));
        this.txtDiscount.setText(OEUtility.displayPercent(this.discP.doubleValue() / 100, this.myParent.locale));
        this.txtNetPrice.setText(OEUtility.displayCurrency(this.netPrice, this.myParent.locale));
    }

    /**
     * Calculate Init Total Price for Items
     */
    public void calculateInitTotalPrice(OrderItemsCart orderItems) {

        this.calculatedCost = new BigDecimal("0");
        this.cost = new BigDecimal("0");
        this.discP = new BigDecimal("0");
        this.calculatedPrice = new BigDecimal("0");
        this.netPrice = new BigDecimal("0");
        this.price = new BigDecimal("0");

        if (orderItems.getDiscount().compareTo(new BigDecimal("0")) == 1) {
            this.price = orderItems.getPrice();
        }

        if (orderItems.getDiscount().compareTo(new BigDecimal("0")) == 0) {
            this.price = orderItems.getPriceUser();
        }

        this.calculatedCost = orderItems.getCost();
        this.cost = orderItems.getCostUser();
        this.calculatedPrice = orderItems.getPrice();
        this.netPrice = orderItems.getPriceUser();
        this.discP = orderItems.getDiscount();
        this.myParent.netPrice = orderItems.getTotalPrice();
        this.myParent.calcPrice = this.calculatedPrice;

        this.txtCalculateCost.setText(OEUtility.displayCurrency(this.calculatedCost, this.myParent.locale));
        this.txtCost.setText(OEUtility.displayCurrency(this.cost, this.myParent.locale));
        this.txtCalculatePrice.setText(OEUtility.displayCurrency(this.calculatedPrice, this.myParent.locale));
        this.txtPrice.setText(OEUtility.displayCurrency(this.price, this.myParent.locale));
        this.txtDiscount.setText(OEUtility.displayPercent(this.discP.doubleValue() / 100, this.myParent.locale));
        this.txtNetPrice.setText(OEUtility.displayCurrency(this.netPrice, this.myParent.locale));
    }

    // ***************************************<PUBLIC GETTERS METHODS>**************************************************

    /**
     * Return Global Net Price Value
     *
     * @return BigDecimal
     */
    public BigDecimal getNetPrice() {
        return this.netPrice;
    }

    /**
     * Return Global Price
     *
     * @return BigDecimal
     */
    public BigDecimal getPrice() {
        return this.price;
    }

    /**
     * Return Global Calculated Price
     *
     * @return BigDecimal
     */
    public BigDecimal getCalcPrice() {
        return this.calculatedPrice;
    }

    /**
     * Return a total price from Item calculation
     *
     * @param price_value , Price Value Constants
     * @return BigDecimal
     */
    public BigDecimal getPrice(int price_value) {

        BigDecimal value = new BigDecimal("0");

        if (price_value == PRICE) {
            value = this.calculatedPrice;
        }

        if (price_value == PRICE_USER) {
            value = this.price;
        }

        if (price_value == COST) {
            value = this.calculatedCost;
        }

        if (price_value == COST_USER) {
            value = this.cost;
        }

        if (price_value == NET_PRICE) {
            value = this.netPrice;
        }

        if (price_value == DISCOUNT) {
            value = this.discP;
        }

        return value;
    }

    /**
     * Return a specific price from Item calculation
     *
     * @param price_category, Price Category Constants
     * @param price_value,    Price Value Constants
     * @return BigDecimal
     */
    public BigDecimal getPrice(int price_category, int price_value) {

        BigDecimal price = new BigDecimal("0");

        for (SummaryDetailItem item : priceItems) {

            if (item.getId() == price_category) {

                if (price_value == PRICE) {
                    price = item.getCalculatePrice();
                    break;
                }

                if (price_value == PRICE_USER) {
                    price = item.getPrice();
                    break;
                }

                if (price_value == COST) {
                    price = item.getCalculateCost();
                    break;
                }

                if (price_value == COST_USER) {
                    price = item.getCost();
                }

                if (price_value == NET_PRICE) {
                    price = item.getNetPrice();
                    break;
                }

                if (price_value == DISCOUNT) {
                    price = item.getDiscount();
                    break;
                }
            }
        }

        return price;
    }

    // **************************************<PRIVATE CONSTRUCTION METHODS>*********************************************

    /**
     * Construct a Financial Summary Panel Description
     */
    private void doFinancialSummaryPanel() {

        // Init Financial Summary Panel
        financialSummaryPanel = new JPanel(new BorderLayout());
        financialSummaryPanel.setBorder(new EtchedBorder());
        financialSummaryPanel.setVisible(false);

        // Init financial table
        financialSummaryTbl = new JXTable();
        financialSummaryTbl.setModel(new FinancialSummaryTableModel());
        financialSummaryTbl.getModel().addTableModelListener(new FinancialSummaryTableModelListener());
        financialSummaryTbl.setToolTipText("Double click edit price and discount.");

        financialSummaryScrollPane = new JScrollPane();
        financialSummaryScrollPane.setPreferredSize(new Dimension(310, 200));
        financialSummaryScrollPane.setViewportView(financialSummaryTbl);

        financialSummaryPanel.add(financialSummaryScrollPane, BorderLayout.CENTER);
    }

    /**
     * Construct a Summary Show Panel
     */
    private void doSummaryShowPanel() {

        lblCalculateCost = new JLabel("Calculate Cost");
        lblCost = new JLabel("Cost");
        lblCalculatePrice = new JLabel("Calculate Price");
        lblPrice = new JLabel("Price");
        lblNetPrice = new JLabel("Net Price");
        lblDiscount = new JLabel("Discount %");

        txtCalculateCost = new JTextField();
        txtCalculateCost.setToolTipText("Calculate Cost");
        txtCalculateCost.setEditable(false);
        txtCalculateCost.setHorizontalAlignment(JTextField.RIGHT);

        txtCost = new JTextField();
        txtCost.setToolTipText("Type a Cost");
        txtCost.setEditable(false);
        txtCost.setHorizontalAlignment(JTextField.RIGHT);

        txtPrice = new JTextField();
        txtPrice.setToolTipText("Type a Price");
        txtPrice.setHorizontalAlignment(JTextField.RIGHT);
        txtPrice.setEditable(false);

        txtCalculatePrice = new JTextField();
        txtCalculatePrice.setToolTipText("Calculate Price");
        txtCalculatePrice.setHorizontalAlignment(JTextField.RIGHT);
        txtCalculatePrice.setEditable(false);

        txtNetPrice = new JTextField();
        txtNetPrice.setBackground(Color.LIGHT_GRAY);
        txtNetPrice.setHorizontalAlignment(JTextField.RIGHT);
        txtNetPrice.setEditable(false);

        txtDiscount = new JTextField();
        txtDiscount.setToolTipText("Type a valid discount %");
        txtDiscount.setHorizontalAlignment(JTextField.RIGHT);
        txtDiscount.setEditable(false);

        chkCost = new JCheckBox("Cost $");
        chkCost.setToolTipText("Edit Cost");

        chkDetailedCost = new JCheckBox("Det. Cost");
        chkDetailedCost.setToolTipText("Edit Cost by Category");

        chkPrice = new JCheckBox("Price $");
        chkPrice.setToolTipText("Edit Price");

        chkDetailedPrice = new JCheckBox("Det. Price $");
        chkDetailedPrice.setToolTipText("Edit Price by Category");

        chkDiscount = new JCheckBox("Discount %");
        chkDiscount.setToolTipText("Edit Discount");

        chkDetailedDiscount = new JCheckBox("Det. Disc. %");
        chkDetailedDiscount.setToolTipText("Edit Discount by Category");

        ButtonGroup optionGroup = new ButtonGroup();
        optionGroup.add(chkCost);
        optionGroup.add(chkDetailedCost);
        optionGroup.add(chkPrice);
        optionGroup.add(chkDetailedPrice);
        optionGroup.add(chkDiscount);
        optionGroup.add(chkDetailedDiscount);

        // Init Summary Show Panel
        summaryShowPanel = new JPanel(new XYLayout());
        summaryShowPanel.setBorder(new EtchedBorder());
        summaryShowPanel.setPreferredSize(new Dimension(310, 230));

        summaryShowPanel.add(chkCost, new XYConstraints(5, 5, 100, 20));
        summaryShowPanel.add(chkPrice, new XYConstraints(110, 5, 100, 20));
        summaryShowPanel.add(chkDiscount, new XYConstraints(215, 5, 100, 20));
        summaryShowPanel.add(chkDetailedCost, new XYConstraints(5, 30, 100, 20));
        summaryShowPanel.add(chkDetailedPrice, new XYConstraints(110, 30, 100, 20));
        summaryShowPanel.add(chkDetailedDiscount, new XYConstraints(215, 30, 100, 20));
        summaryShowPanel.add(new JSeparator(SwingConstants.HORIZONTAL), new XYConstraints(5, 60, 300, 1));
        summaryShowPanel.add(lblCalculateCost, new XYConstraints(5, 70, 130, 20));
        summaryShowPanel.add(txtCalculateCost, new XYConstraints(160, 70, 130, 20));
        summaryShowPanel.add(lblCost, new XYConstraints(5, 95, 130, 20));
        summaryShowPanel.add(txtCost, new XYConstraints(160, 95, 130, 20));
        summaryShowPanel.add(lblCalculatePrice, new XYConstraints(5, 120, 130, 20));
        summaryShowPanel.add(txtCalculatePrice, new XYConstraints(160, 120, 130, 20));
        summaryShowPanel.add(lblPrice, new XYConstraints(5, 145, 130, 20));
        summaryShowPanel.add(txtPrice, new XYConstraints(160, 145, 130, 20));
        summaryShowPanel.add(lblDiscount, new XYConstraints(5, 170, 130, 20));
        summaryShowPanel.add(txtDiscount, new XYConstraints(160, 170, 130, 20));
        summaryShowPanel.add(lblNetPrice, new XYConstraints(5, 195, 130, 20));
        summaryShowPanel.add(txtNetPrice, new XYConstraints(160, 195, 130, 20));
    }

    /**
     * Default Table Model for Financial Summary Table
     */
    public class FinancialSummaryTableModel extends DefaultTableModel {

        private String[] columnNames = new String[]{"Description", "Cost USD", "Discount By %", "Price USD"};

        // Table Cell Renderer
        private DefaultTableCellRenderer rightAlignment;
        private DefaultTableCellRenderer cellHeaderRenderer;

        /**
         * Financial Summary Table Model
         */
        public FinancialSummaryTableModel() {
            rightAlignment = new DefaultTableCellRenderer();
            rightAlignment.setHorizontalAlignment(JLabel.RIGHT);

            cellHeaderRenderer = new DefaultTableCellRenderer();
            cellHeaderRenderer.setBackground(Color.LIGHT_GRAY);
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public int getRowCount() {
            return priceItems.size();
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        @Override
        public Class getColumnClass(int c) {
            Object object = getValueAt(0, c);

            return object.getClass();
        }

        @Override
        public boolean isCellEditable(int row, int column) {

            // Editable cost column if detailed cost is selected
            if (column == 1 && chkDetailedCost.isSelected()) {
                return true;
            }

            // Editable discount column if detailed discount is selected
            if (column == 2 && chkDetailedDiscount.isSelected()) {
                return true;
            }

            // Editable price column if detailed price is selected
            if (column == 3 && chkDetailedPrice.isSelected()) {
                return true;
            }

            return false;
        }

        @Override
        public Object getValueAt(int row, int column) {

            // Get Item from row value
            SummaryDetailItem item = new SummaryDetailItem(0, "");

            if (priceItems.size() > 0) {
                item = priceItems.get(row);
            }

            if (column == 0) {
                financialSummaryTbl.getColumnModel().getColumn(0).setCellRenderer(cellHeaderRenderer);
                return item.getDescription();
            }

            if (column == 1) {
                financialSummaryTbl.getColumnModel().getColumn(1).setCellRenderer(rightAlignment);
                return OEUtility.displayCurrency(item.getCost(), myParent.locale);
            }

            if (column == 2) {
                financialSummaryTbl.getColumnModel().getColumn(2).setCellRenderer(rightAlignment);
                return OEUtility.displayCurrency(item.getDiscount(), myParent.locale);
            }

            if (column == 3) {
                financialSummaryTbl.getColumnModel().getColumn(3).setCellRenderer(rightAlignment);
                return OEUtility.displayCurrency(item.getPrice(), myParent.locale);
            }

            return null;
        }

        @Override
        public void setValueAt(Object value, int row, int column) {

            SummaryDetailItem item = priceItems.get(row);

            if (column == 1) {

                myParent.costManual = true;
                myParent.priceManual = false;
                myParent.discountManual = false;

                // Get cost value
                BigDecimal cost = new BigDecimal((String) value);

                // Update Cost Item
                item.setCost(cost);
            }

            if (column == 2) {

                myParent.discountManual = true;
                myParent.costManual = false;
                myParent.priceManual = false;

                BigDecimal discount = new BigDecimal((String) value);
                if (discount.doubleValue() > 100) {
                    discount = new BigDecimal("0");
                }

                item.setDiscount(discount);

                // Update net price Item
                BigDecimal dv = (item.getCalculatePrice().multiply(discount.divide(new BigDecimal("100"), 4,
                        BigDecimal.ROUND_HALF_EVEN)).setScale(4, BigDecimal.ROUND_HALF_EVEN));

                // Calculated price Item
                BigDecimal price = item.getCalculatePrice().subtract(dv).setScale(4, BigDecimal.ROUND_HALF_EVEN);

                item.setPrice(price);
                item.setNetPrice(price);
            }

            if (column == 3) {

                myParent.priceManual = true;
                myParent.costManual = false;
                myParent.discountManual = false;

                BigDecimal price = new BigDecimal((String) value);

                item.setDiscount(new BigDecimal(0));

                // Update Price Item
                item.setPrice(price);

                // Update Net Price Item
                item.setNetPrice(item.getPrice().subtract(item.getDiscount()).setScale(4, BigDecimal.ROUND_HALF_EVEN));
            }

            // Calculate total price
            calculateTotalPrice();
        }
    }

    /**
     * Default Table Model for Financial Summary Table
     */
    public class FinancialSummaryTableModelListener implements TableModelListener {

        @Override
        public void tableChanged(TableModelEvent e) {

            // Get position for edit table
            int row = e.getFirstRow();
            int column = e.getColumn();

            // Get table model
            FinancialSummaryTableModel model = (FinancialSummaryTableModel) e.getSource();

            // Get the data value
            Object data = model.getValueAt(row, column);
            model.setValueAt(data, row, column);
        }
    }

    /**
     * Summary Detail Item for Editing Financial Summary Table
     */
    public class SummaryDetailItem implements Serializable {

        private int id = 0;
        private String description = "";

        private BigDecimal calculateCost = new BigDecimal("0.00");
        private BigDecimal cost = new BigDecimal("0.00");
        private BigDecimal calculatePrice = new BigDecimal("0.00"); // Price Calculated for System
        private BigDecimal price = new BigDecimal("0.00"); // Price Manually added by user
        private BigDecimal netPrice = new BigDecimal("0.00");
        private BigDecimal discount = new BigDecimal("0.00");
        private double commPercent = 0;
        private BigDecimal commValue = new BigDecimal("0.00");

        public SummaryDetailItem(int id, String description) {
            SummaryDetailItem.this.id = id;
            SummaryDetailItem.this.description = description;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            SummaryDetailItem.this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            SummaryDetailItem.this.description = description;
        }

        public BigDecimal getCalculateCost() {
            return calculateCost;
        }

        public void setCalculateCost(BigDecimal calculateCost) {
            this.calculateCost = calculateCost;
        }

        public BigDecimal getCost() {
            return cost;
        }

        public void setCost(BigDecimal cost) {
            SummaryDetailItem.this.cost = cost;
        }

        public BigDecimal getDiscount() {
            return discount;
        }

        public void setDiscount(BigDecimal discount) {
            SummaryDetailItem.this.discount = discount;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            SummaryDetailItem.this.price = price;
        }

        public BigDecimal getNetPrice() {
            return netPrice;
        }

        public void setNetPrice(BigDecimal netPrice) {
            SummaryDetailItem.this.netPrice = netPrice;
        }

        public BigDecimal getCalculatePrice() {
            return calculatePrice;
        }

        public void setCalculatePrice(BigDecimal calculatePrice) {
            SummaryDetailItem.this.calculatePrice = calculatePrice;
        }

		public double getCommPercent() {
			return commPercent;
		}

		public void setCommPercent(double commPercent) {
			this.commPercent = commPercent;
		}

		public BigDecimal getCommValue() {
			return commValue;
		}

		public void setCommValue(BigDecimal commValue) {
			this.commValue = commValue;
		}
    }
    
  
    
}

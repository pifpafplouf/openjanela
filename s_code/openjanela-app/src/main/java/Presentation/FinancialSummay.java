package Presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import openjanela.app.configuration.controller.BomViewController;
import openjanela.commons.components.generic.XYConstraints;
import openjanela.commons.components.generic.XYLayout;
import openjanela.model.entities.parts.PartFamilySeries;
import openjanela.model.entities.parts.PartsFamily;
import org.openjanela.component.JXTaskPaneOJ;
import orderEntryUtility.OEUtility;

import org.jdesktop.swingx.VerticalLayout;

import Model.BillOfMat;
import Model.DesignGlass;
import Model.JobItemCostPrice;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Sherif El Dibani
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 12-14-12
 *          Time: 01:25 AM
 */
public class FinancialSummay extends JPanel {

    JXTaskPaneOJ costTask = new JXTaskPaneOJ();

    JXTaskPaneOJ priceGroupTask = new JXTaskPaneOJ();

    JXTaskPaneOJ priceCatTask = new JXTaskPaneOJ();

    private List<JobItemCostPrice> partsFamilies = new ArrayList();

    Collection partG = new ArrayList();

    Collection partC = new ArrayList();

    public BigDecimal priceTotal = new BigDecimal("0.00");

    public BigDecimal costTotal = new BigDecimal("0.00");

    JPanel costPricePanel = new JPanel();

    JPanel panelDetails = new JPanel();

    JPanel botPanel = new JPanel();

    JLabel costL = new JLabel("Total Cost:");

    JLabel priceL = new JLabel("Total Price:");

    JLabel costT = new JLabel("", SwingConstants.RIGHT);

    JLabel priceT = new JLabel("", SwingConstants.RIGHT);

    ItemFrame myParent;

    FinancialViewCost pgSum;

    FinancialViewCost costSum;

    JPanel priceCatPanel = new JPanel();

    JLabel baseL = new JLabel("Base:");

    JLabel optionL = new JLabel("Options:");

    JLabel glassL = new JLabel("Glass:");

    JLabel gridL = new JLabel("Grid:");

    JLabel laborL = new JLabel("Labor:");

    JLabel shippingL = new JLabel("Shipping:");

    JLabel installL = new JLabel("Install:");

    JLabel otherL = new JLabel("Other:");

    JButton setPrice = new JButton();

    JLabel byPrice = new JLabel("by Price");

    JLabel byDiscount = new JLabel("by %");

    JTextField baseT = new JTextField("0.00");

    JTextField optionT = new JTextField("0.00");

    JTextField glassT = new JTextField("0.00");

    JTextField gridT = new JTextField("0.00");

    JTextField laborT = new JTextField("0.00");

    JTextField shippingT = new JTextField("0.00");

    JTextField installT = new JTextField("0.00");

    JTextField otherT = new JTextField("0.00");

    JTextField baseDT = new JTextField("0.00");

    JTextField optionDT = new JTextField("0.00");

    JTextField glassDT = new JTextField("0.00");

    JTextField gridDT = new JTextField("0.00");

    JTextField laborDT = new JTextField("0.00");

    JTextField shippingDT = new JTextField("0.00");

    JTextField installDT = new JTextField("0.00");

    JTextField otherDT = new JTextField("0.00");

    JTextField baseNT = new JTextField("0.00");

    JTextField optionNT = new JTextField("0.00");

    JTextField glassNT = new JTextField("0.00");

    JTextField gridNT = new JTextField("0.00");

    JTextField laborNT = new JTextField("0.00");

    JTextField shippingNT = new JTextField("0.00");

    JTextField installNT = new JTextField("0.00");

    JTextField otherNT = new JTextField("0.00");

    public FinancialSummay(ItemFrame frame) {

        this.myParent = frame;

        this.setLayout(new VerticalLayout());

        this.costTask.setIcon(ItemFrame.iconFiles.get("part"));
        this.costTask.setToolTipText("Cost/Price by Part Family");
        this.priceGroupTask.setIcon(myParent.priceImage);
        this.priceGroupTask.setToolTipText("Cost/Price by Price Group");
        this.priceCatTask.setIcon(myParent.costImage);
        this.priceCatTask.setToolTipText("Cost/Price by System Category");

        this.setPrice.setIcon(this.myParent.setImage);

        addActions();

        buildCostTask(myParent);

        initCostPricePanel();

        if (this.myParent.isNewItem) {
            this.initPriceCategories();
        }


        this.panelDetails.setPreferredSize(new Dimension(200, 100));

        this.botPanel.setLayout(new BorderLayout());
        this.botPanel.add(this.costPricePanel, BorderLayout.CENTER);

        //***********************************************************
        // Setting Main Configuration
        //***********************************************************
        this.setLayout(new BorderLayout());

        this.add(this.costTask, BorderLayout.NORTH);
        this.add(this.priceGroupTask, BorderLayout.CENTER);
        this.add(this.botPanel, BorderLayout.SOUTH);
    }

    public void buildPriceCatTask(ItemFrame frame) {

        this.myParent = frame;

        this.priceCatTask.removeAll();
        this.priceCatPanel.removeAll();

        this.priceCatPanel.setLayout(new XYLayout());

        this.priceCatPanel.add(baseL, new XYConstraints(1, 25, 65, 22));
        this.priceCatPanel.add(optionL, new XYConstraints(1, 49, 65, 22));
        this.priceCatPanel.add(glassL, new XYConstraints(1, 73, 65, 22));
        this.priceCatPanel.add(gridL, new XYConstraints(1, 97, 65, 22));
        this.priceCatPanel.add(laborL, new XYConstraints(1, 121, 65, 22));
        this.priceCatPanel.add(shippingL, new XYConstraints(1, 145, 65, 22));
        this.priceCatPanel.add(installL, new XYConstraints(1, 169, 65, 22));
        this.priceCatPanel.add(otherL, new XYConstraints(1, 193, 65, 22));

        byPrice = new JLabel("Price " + myParent.myCS);

        JLabel originalL = new JLabel("Base " + myParent.myCS);

        this.priceCatPanel.add(originalL, new XYConstraints(67, 1, 70, 22));

        this.priceCatPanel.add(baseT, new XYConstraints(67, 25, 70, 22));
        this.priceCatPanel.add(optionT, new XYConstraints(67, 49, 70, 22));
        this.priceCatPanel.add(glassT, new XYConstraints(67, 73, 70, 22));
        this.priceCatPanel.add(gridT, new XYConstraints(67, 97, 70, 22));
        this.priceCatPanel.add(laborT, new XYConstraints(67, 121, 70, 22));
        this.priceCatPanel.add(shippingT, new XYConstraints(67, 145, 70, 22));
        this.priceCatPanel.add(installT, new XYConstraints(67, 169, 70, 22));
        this.priceCatPanel.add(otherT, new XYConstraints(67, 193, 70, 22));

        this.priceCatPanel.add(this.byDiscount, new XYConstraints(139, 1, 70, 22));

        this.priceCatPanel.add(baseDT, new XYConstraints(139, 25, 70, 22));
        this.priceCatPanel.add(optionDT, new XYConstraints(139, 49, 70, 22));
        this.priceCatPanel.add(glassDT, new XYConstraints(139, 73, 70, 22));
        this.priceCatPanel.add(gridDT, new XYConstraints(139, 97, 70, 22));
        this.priceCatPanel.add(laborDT, new XYConstraints(139, 121, 70, 22));
        this.priceCatPanel.add(shippingDT, new XYConstraints(139, 145, 70, 22));
        this.priceCatPanel.add(installDT, new XYConstraints(139, 169, 70, 22));
        this.priceCatPanel.add(otherDT, new XYConstraints(139, 193, 70, 22));

        this.priceCatPanel.add(this.byPrice, new XYConstraints(211, 1, 75, 22));

        this.priceCatPanel.add(baseNT, new XYConstraints(211, 25, 70, 22));
        this.priceCatPanel.add(optionNT, new XYConstraints(211, 49, 70, 22));
        this.priceCatPanel.add(glassNT, new XYConstraints(211, 73, 70, 22));
        this.priceCatPanel.add(gridNT, new XYConstraints(211, 97, 70, 22));
        this.priceCatPanel.add(laborNT, new XYConstraints(211, 121, 70, 22));
        this.priceCatPanel.add(shippingNT, new XYConstraints(211, 145, 70, 22));
        this.priceCatPanel.add(installNT, new XYConstraints(211, 169, 70, 22));
        this.priceCatPanel.add(otherNT, new XYConstraints(211, 193, 70, 22));

        this.baseT.setEnabled(false);
        this.optionT.setEnabled(false);
        this.glassT.setEnabled(false);
        this.gridT.setEnabled(false);
        this.laborT.setEnabled(false);
        this.shippingT.setEnabled(false);
        this.installT.setEnabled(false);
        this.otherT.setEnabled(false);

        this.priceCatPanel.add(setPrice, new XYConstraints(211, 218, 70, 22));

        this.baseT.setHorizontalAlignment(4);
        this.optionT.setHorizontalAlignment(4);
        this.glassT.setHorizontalAlignment(4);
        this.gridT.setHorizontalAlignment(4);
        this.laborT.setHorizontalAlignment(4);
        this.shippingT.setHorizontalAlignment(4);
        this.installT.setHorizontalAlignment(4);
        this.otherT.setHorizontalAlignment(4);

        this.priceCatTask.setLayout(new BorderLayout());
        this.priceCatTask.add(priceCatPanel, BorderLayout.WEST);
    }

    public void addActions() {
        setPrice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                validate();
                repaint();
            }
        });

        baseT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                myParent.manualPriceEntered = true;
            }
        });

        baseT.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                myParent.manualPriceEntered = true;
                baseT.selectAll();
            }
        });

        baseT.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                myParent.manualPriceEntered = true;
            }
        });

        optionT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                myParent.manualPriceEntered = true;
            }
        });

        optionT.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                myParent.manualPriceEntered = true;
                baseT.selectAll();
            }
        });

        optionT.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                myParent.manualPriceEntered = true;
            }
        });

        glassT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                myParent.manualPriceEntered = true;
            }
        });

        glassT.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                myParent.manualPriceEntered = true;
                baseT.selectAll();
            }
        });

        glassT.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                myParent.manualPriceEntered = true;
            }
        });

        gridT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                myParent.manualPriceEntered = true;
            }
        });

        gridT.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                myParent.manualPriceEntered = true;
                baseT.selectAll();
            }
        });

        gridT.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                myParent.manualPriceEntered = true;
            }
        });

        laborT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                myParent.manualPriceEntered = true;
            }
        });

        laborT.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                myParent.manualPriceEntered = true;
                baseT.selectAll();
            }
        });

        laborT.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                myParent.manualPriceEntered = true;
            }
        });

        shippingT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                myParent.manualPriceEntered = true;
            }
        });

        shippingT.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                myParent.manualPriceEntered = true;
                baseT.selectAll();
            }
        });

        shippingT.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                myParent.manualPriceEntered = true;
            }
        });

        installT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                myParent.manualPriceEntered = true;
            }
        });

        installT.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                myParent.manualPriceEntered = true;
                baseT.selectAll();
            }
        });

        installT.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                myParent.manualPriceEntered = true;
            }
        });

        otherT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                myParent.manualPriceEntered = true;
            }
        });

        otherT.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {

                myParent.manualPriceEntered = true;
                baseT.selectAll();
            }
        });

        otherT.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                myParent.manualPriceEntered = true;
            }
        });

        costTask.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(final PropertyChangeEvent evt) {
                if (!costTask.isCollapsed()) {
                    buildCostTask(myParent);

                    priceGroupTask.setCollapsed(true);
                    priceCatTask.setCollapsed(true);
                }
            }
        });

        priceGroupTask.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(final PropertyChangeEvent evt) {
                if (!priceGroupTask.isCollapsed()) {
                    buildPriceGroupTask(myParent);
                    costTask.setCollapsed(true);
                    priceCatTask.setCollapsed(true);
                }
            }
        });

        priceCatTask.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(final PropertyChangeEvent evt) {

                if (!priceCatTask.isCollapsed()) {

                    buildPriceCatTask(myParent);
                    priceGroupTask.setCollapsed(true);
                    costTask.setCollapsed(true);
                }
            }
        });

    }

    public void buildPriceGroupTask(ItemFrame frame) {

        myParent = frame;
        priceGroupTask.removeAll();
        pgSum = new FinancialViewCost(myParent);// FinancialViewPriceGroup(frame);

        this.initPriceGroups();

        try {
            pgSum.jbInit(partG, false);
        } catch (Exception e) {
            e.printStackTrace();
        }

        priceGroupTask.setLayout(new BorderLayout());
        priceGroupTask.add(pgSum, BorderLayout.WEST);
    }

    public void buildCostTask(ItemFrame frame) {

        myParent = frame;
        costTask.removeAll();
        costSum = new FinancialViewCost(myParent);

        this.initPartFamilies();

        try {
            costSum.jbInit(partsFamilies, false);
        } catch (Exception e) {
            e.printStackTrace();
        }

        costTask.setLayout(new BorderLayout());
        costTask.add(costSum, BorderLayout.WEST);
    }

    /**
     * Init Part Families
     */
    public void initPartFamilies() {

        //Build Bill of Material Components
        BomViewController bomViewController = new BomViewController(this.myParent);
        bomViewController.initTreeTableNodeValues();

        //Init Parts Families
        this.partsFamilies = this.myParent.partFamilies;

        if (this.myParent.jobItem != null) {

            for (JobItemCostPrice partFamily : this.partsFamilies) {

                partFamily.cost = new BigDecimal("0");
                partFamily.price = new BigDecimal("0");

                for (BillOfMat bom : this.myParent.jobItem.bom) {
                    if ((bom.partFamily == partFamily.typeid) && !bom.remote) {
                        partFamily.cost = partFamily.cost.add(bom.cost);
                        partFamily.price = partFamily.price.add(bom.price);
                    }
                }
            }
        }
    }

    public void initPriceGroups() {

        this.partG = new ArrayList();

        Object[] jiCP = this.myParent.priceGroups.toArray();

        Object[] boms = this.myParent.jobItem.bom.toArray();

        for (Object cg : jiCP) {

            ((JobItemCostPrice) cg).cost = new BigDecimal("0.00");
            ((JobItemCostPrice) cg).price = new BigDecimal("0.00");

            for (Object b : boms) {
                if (((BillOfMat) b).priceGroup == ((JobItemCostPrice) cg).typeid && !((BillOfMat)b).remote) {
                    ((JobItemCostPrice) cg).cost = ((JobItemCostPrice) cg).cost.add(((BillOfMat) b).cost);
                    ((JobItemCostPrice) cg).price = ((JobItemCostPrice) cg).price.add(((BillOfMat) b).price);
                }
            }

            partG.add(cg);
        }

        jiCP = partG.toArray();
        partG.clear();

        Object[] bomsG = myParent.jobItem.glassBOM.toArray();

        for (Object cg : jiCP) {
            for (Object b : bomsG) {
                if (((DesignGlass) b).priceGroup == ((JobItemCostPrice) cg).typeid && !((DesignGlass) b).remote) {
                    ((JobItemCostPrice) cg).cost = ((JobItemCostPrice) cg).cost.add(((DesignGlass) b).cost);
                    ((JobItemCostPrice) cg).price = ((JobItemCostPrice) cg).price.add(((DesignGlass) b).price);
                }
            }

            partG.add(cg);
        }
    }

    public void initPriceCategories() {

        if (this.myParent.jobItem == null) {
            return;
        }

        if (myParent.manualPriceEntered) {
            JOptionPane.showMessageDialog(myParent, "All Manually entered prices will be lost!", "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }

        myParent.manualPriceEntered = false;
        partC = new ArrayList();
        Object[] jiCP = myParent.priceCategories.toArray();

        Object[] boms = myParent.jobItem.bom.toArray();

        for (Object cg : jiCP) {

            ((JobItemCostPrice) cg).cost = new BigDecimal("0.00");
            ((JobItemCostPrice) cg).price = new BigDecimal("0.00");

            for (Object b : boms) {

                BillOfMat bom = (BillOfMat) b;
                if (bom.remote) {
                    continue;
                }

                if (bom.priceCat == ((JobItemCostPrice) cg).typeid) {
                    bom.cost = ((JobItemCostPrice) cg).cost.add(bom.cost);
                    bom.price = ((JobItemCostPrice) cg).price.add(bom.price);
                }
            }

            partC.add(cg);
        }

        jiCP = partC.toArray();
        partC.clear();

        Object[] bomsG = myParent.jobItem.glassBOM.toArray();

        for (Object cg : jiCP) {

            if (((JobItemCostPrice) cg).typeid == 3) {
                for (Object b : bomsG) {

                    DesignGlass glass = (DesignGlass)b;

                    if (glass.remote) {
                        continue;
                    }

                    if (glass.priceCat == ((JobItemCostPrice) cg).typeid) {
                        ((JobItemCostPrice) cg).cost = ((JobItemCostPrice) cg).cost.add(glass.cost);
                        ((JobItemCostPrice) cg).price = ((JobItemCostPrice) cg).price.add(glass.price);
                    }
                }
            }

            partC.add(cg);
        }
    }

    public void initCostPricePanel() {

        this.costPricePanel.setLayout(new XYLayout());
        this.costPricePanel.add(this.costL, new XYConstraints(250, 1, 90, 22));
        this.costPricePanel.add(this.priceL, new XYConstraints(250, 25, 90, 22));

        this.costT.setAlignmentX(RIGHT_ALIGNMENT);
        this.costPricePanel.add(this.costT, new XYConstraints(342, 1, 70, 22));

        this.priceT.setAlignmentX(RIGHT_ALIGNMENT);
        this.costPricePanel.add(this.priceT, new XYConstraints(342, 25, 70, 22));

        this.costT.setText(myParent.myCS + OEUtility.displayCurrency(costSum.costTotal, myParent.locale));
        this.priceT.setText(myParent.myCS + OEUtility.displayCurrency(costSum.priceTotal, myParent.locale));
    }
}

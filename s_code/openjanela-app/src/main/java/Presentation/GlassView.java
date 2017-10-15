/*******************************************************************************
 * Author: Sherif El Dibani 
 * Copyright (C) OpenJanela LLC   2010 - Today  - All rights Reserved.
 ******************************************************************************/

package Presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import openjanela.app.configuration.controller.GlassViewController;
import openjanela.commons.components.generic.XYConstraints;
import openjanela.commons.components.generic.XYLayout;
import orderEntryUtility.OEUtility;
import orderEntryUtility.UOMConvertData;

import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.VerticalLayout;

import Model.DesignGlass;
import org.openjanela.component.JOpenJanelaComponent;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Sherif El Dibani
 * @author Eddy Montenegro
 *         Date: 03-06-12
 *         Time: 11:41 AM
 *         <p/>
 *         This class represents Bill of Material GUI representation for design
 */
public class GlassView extends JPanel implements JOpenJanelaComponent {

    private ItemFrame myParent;

    public DesignGlass selectedBOM;

    private JPanel panelDetails;
    private JPanel costPricePanel;
    private JPanel botPanel;

    private JXTable glassTable;
    private JScrollPane bomScroll;

    private JLabel costL;
    private JLabel priceL;

    private JLabel costT;
    private JLabel priceT;

    private JLabel plL;
    private JLabel stnL;
    private JLabel rptL;
    private JLabel delL;
    private JLabel stageL;

    public BigDecimal priceTotal = new BigDecimal(0);
    public BigDecimal costTotal = new BigDecimal(0);

    private Vector glassRecs = new Vector();

    private DecimalFormat twoDecimal = new DecimalFormat("0.00");
    private DecimalFormat sixDecimal = new DecimalFormat("0.000000");

    private GlassViewController glassViewController;

    /**
     * Glass View Constructor
     *
     * @param frame, ItemFrame
     */
    public GlassView(ItemFrame frame) {

        //Init ItemFrame parent
        this.myParent = frame;

        //Init Controller
        this.glassViewController = new GlassViewController();

        //Init Panel design
        initComponents();
        initValueComponents();
        initListenersComponents();
    }

    @Override
    public void initComponents() {

        this.setLayout(new VerticalLayout());
        this.setPreferredSize(new Dimension(400, 500));

        //Init Cost Price Panel
        initCostPricePanel();

        //Init Detail Panel
        initDetailPanel();

        //Init glass Table
        this.glassTable = new JXTable();
        this.glassTable.setSortable(false);
        this.glassTable.setCellSelectionEnabled(false);
        this.glassTable.setRowSelectionAllowed(true);
        this.glassTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.glassTable.getSelectionModel().addListSelectionListener(new ResultSelectionListener());
        this.glassTable.getSelectionModel().setSelectionInterval(0, 0);

        //Init Scroll Pane
        this.bomScroll = new JScrollPane();
        this.bomScroll.setPreferredSize(new Dimension(400, 400));
        this.bomScroll.getViewport().add(glassTable, null);

        //Init Bot Panel
        this.botPanel = new JPanel(new BorderLayout());
        this.botPanel.setPreferredSize(new Dimension(400, 100));
        this.botPanel.add(panelDetails, BorderLayout.CENTER);
        this.botPanel.add(costPricePanel, BorderLayout.EAST);

        //Init Main Panel
        this.setLayout(new BorderLayout());
        this.add(bomScroll, BorderLayout.CENTER);
        this.add(botPanel, BorderLayout.SOUTH);
    }

    @Override
    public void initValueComponents() {

        if (this.myParent.jobItem == null) {
            return;
        }

        //********************************
        //Reset GlassBOM Collection
        //********************************
        if (this.myParent.calcBom) {
            try {
                this.myParent.jobItem.design.resetGlassBom();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //Update GlassBOM Information
        glassViewController.updateGlassBomInformation(this.myParent.jobItem);

        //Init Glass records
        this.glassRecs = new Vector();
        this.glassRecs.addAll(this.myParent.jobItem.glassBOM);

        //Adding Result List Model to Glass Table
        this.glassTable.setModel(new ResultListModel(glassRecs));

        //Calculate Cost & Price Total
        this.costTotal = new BigDecimal(0);
        this.priceTotal = new BigDecimal(0);

        for (DesignGlass designGlass : this.myParent.jobItem.glassBOM) {
            if (!designGlass.remote) {
                this.costTotal = this.costTotal.add(designGlass.cost);
                this.priceTotal = this.priceTotal.add(designGlass.price);
            }
        }

        this.costT.setText(myParent.myCS + OEUtility.displayCurrency(costTotal, myParent.locale));
        this.priceT.setText(myParent.myCS + OEUtility.displayCurrency(priceTotal, myParent.locale));
    }

    @Override
    public void initListenersComponents() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Init Cost Price Panel
     */
    public void initCostPricePanel() {

        this.costL = new JLabel("Total Cost:");
        this.priceL = new JLabel("Total Price:");

        this.costT = new JLabel("", JTextField.RIGHT);
        this.priceT = new JLabel("", JTextField.RIGHT);

        this.costPricePanel = new JPanel(new XYLayout());
        this.costPricePanel.add(this.costL, new XYConstraints(1, 1, 90, 22));
        this.costPricePanel.add(this.priceL, new XYConstraints(1, 25, 90, 22));
        this.costPricePanel.add(this.costT, new XYConstraints(100, 1, 70, 22));
        this.costPricePanel.add(this.priceT, new XYConstraints(100, 25, 70, 22));
    }

    /**
     * Init Detail Panel
     */
    public void initDetailPanel() {

        this.plL = new JLabel("Prod. Line");
        this.stnL = new JLabel("Station");
        this.rptL = new JLabel("Report");
        this.delL = new JLabel("Phase");
        this.stageL = new JLabel("Stage");

        this.panelDetails = new JPanel(new XYLayout());

        this.panelDetails.add(plL, new XYConstraints(1, 1, 100, 22));
        this.panelDetails.add(stnL, new XYConstraints(1, 25, 100, 22));
        this.panelDetails.add(rptL, new XYConstraints(102, 1, 100, 22));
        this.panelDetails.add(delL, new XYConstraints(102, 25, 100, 22));
        this.panelDetails.add(stageL, new XYConstraints(220, 1, 110, 22));
    }

    /**
     * Setting Glass BOM values to show panel
     *
     * @throws Exception, Exception
     */
    public void setValues() throws Exception {

        if (selectedBOM != null) {
            plL.setText("Prod. Line: " + selectedBOM.prodline + "");
            stnL.setText("Station   : " + selectedBOM.station + "");
            rptL.setText("Report    : " + selectedBOM.report + "");
            delL.setText("Delivery  : " + selectedBOM.delivery + "");
            stageL.setText("Stage     : " + selectedBOM.reqforstage + "");
        }
    }

    /**
     * Glass Selection Listener
     */
    public class ResultSelectionListener implements ListSelectionListener {

        int lastIndex = -1;

        @Override
        public void valueChanged(ListSelectionEvent lse) {
            int index = -1;
            int countrows = glassTable.getRowCount();
            index = glassTable.getSelectedRow();

            if (index != -1 && index != lastIndex && countrows != 0 && !lse.getValueIsAdjusting()) {
                try {
                    ResultListModel model = (ResultListModel) glassTable.getModel();
                    selectedBOM = model.getGlassBom(index);

                    setValues();
                    GlassView.this.panelDetails.validate();
                    GlassView.this.panelDetails.repaint();


                } catch (Exception ex) {
                    Logger.getLogger(GlassView.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    /**
     * Result List Model Class
     */
    public class ResultListModel extends DefaultTableModel {

        private String[] columnNames = new String[]{"Stock Code", "Description", "Seq.", "Pane", "Shape", "Width",
                "Height", "Cost " + GlassView.this.myParent.myCS, "Price " + GlassView.this.myParent.myCS};

        /**
         * Result List Model Constructor
         *
         * @param v, Vector
         */
        ResultListModel(Vector v) {
            this.dataVector = v;
        }

        @Override
        public int getColumnCount() {
            if (columnNames == null) {
                columnNames = new String[]{"Stock Code", "Description", "Seq.", "Pane", "Shape", "Width",
                        "Height", "Cost " + GlassView.this.myParent.myCS, "Price " + GlassView.this.myParent.myCS};
            }

            return columnNames.length;
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        @Override
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            return false;
        }

        @Override
        public Object getValueAt(int row, int column) {

            DefaultTableCellRenderer rightAlignment = new DefaultTableCellRenderer();
            rightAlignment.setHorizontalAlignment(JLabel.RIGHT);

            if (row < dataVector.size() && dataVector.size() > 0) {

                DesignGlass ugr = (DesignGlass) dataVector.get(row);

                try {
                    if (column == 0) {
                        return ugr.stockCode;
                    } else if (column == 1) {
                        return ugr.description;
                    } else if (column == 2) {
                        return ugr.a_sequenceID;
                    } else if (column == 3) {
                        return ugr.sashAbbreviation;
                    } else if (column == 4) {
                        return ugr.shapeAbbreviation;
                    } else if (column == 5) {
                        glassTable.getColumnModel().getColumn(5).setCellRenderer(rightAlignment);

                        if (myParent.currentUOM == 1) {
                            BigDecimal width = new BigDecimal(ugr.widthM);
                            width = width.divide(new BigDecimal("100"), 20, BigDecimal.ROUND_UP);

                            return twoDecimal.format(width);
                        } else {
                            BigDecimal width = new BigDecimal(ugr.widthI);
                            width = width.divide(new BigDecimal("64"), 20, BigDecimal.ROUND_UP);

                            if (myParent.currentUOM == 2) {
                                return sixDecimal.format(width);
                            } else if (myParent.currentUOM == 3) {
                                return UOMConvertData.imperialToFraction(width + "");
                            }
                        }
                    } else if (column == 6) {
                        glassTable.getColumnModel().getColumn(6).setCellRenderer(rightAlignment);

                        if (myParent.currentUOM == 1) {
                            BigDecimal height = new BigDecimal(ugr.heightM + "");
                            height = height.divide(new BigDecimal("100"), 20, BigDecimal.ROUND_UP);

                            return twoDecimal.format(height);
                        } else {
                            BigDecimal height = new BigDecimal(ugr.heightI + "");
                            height = height.divide(new BigDecimal("64"), 20, BigDecimal.ROUND_UP);

                            if (myParent.currentUOM == 2) {
                                return sixDecimal.format(height);
                            } else if (myParent.currentUOM == 3) {
                                return UOMConvertData.imperialToFraction(height + "");
                            }
                        }
                    } else if (column == 7) {
                        glassTable.getColumnModel().getColumn(7).setCellRenderer(rightAlignment);

                        //--------------------------------------------------------------------------
                        //Not display cost & price from supplier
                        //--------------------------------------------------------------------------
                        if (ugr.remote) {
                            return OEUtility.displayCurrency(new BigDecimal("0"), myParent.locale);
                        }

                        return OEUtility.displayCurrency(ugr.cost, myParent.locale);
                    } else if (column == 8) {
                        glassTable.getColumnModel().getColumn(8).setCellRenderer(rightAlignment);

                        //--------------------------------------------------------------------------
                        //Not display cost & price from supplier
                        //--------------------------------------------------------------------------
                        if (ugr.remote) {
                            return OEUtility.displayCurrency(new BigDecimal("0"), myParent.locale);
                        }

                        return OEUtility.displayCurrency(ugr.priceUser, myParent.locale);
                    }
                    return null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            return "";
        }

        public void refresh() {
            fireTableRowsDeleted(dataVector.size(), dataVector.size());
        }

        public DesignGlass getGlassBom(int row) {
            if (row > dataVector.size()) {
                return null;
            }

            return (DesignGlass) dataVector.get(row);
        }

        @Override
        public void removeRow(int row) {
            dataVector.remove(row);
            fireTableRowsDeleted(dataVector.size(), dataVector.size());
        }
    }

}
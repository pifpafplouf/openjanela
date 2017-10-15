/*******************************************************************************
 * Author: Sherif El Dibani 
 * Copyright (C) OpenJanela LLC   2010 - Today  - All rights Reserved.
 ******************************************************************************/

package Presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import openjanela.commons.components.generic.XYConstraints;
import openjanela.commons.components.generic.XYLayout;
import openjanela.model.entities.partner.RuleTest;
import orderEntryUtility.OEUtility;

import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.VerticalLayout;

import Model.BillOfMat;
import Model.DesignGlass;
import Model.JobItemCostPrice;


// @EntitX
public class FinancialViewCost extends JPanel {

    JPanel panelDetails = new JPanel();

    public JXTable bomTable = new JXTable();

    JScrollPane bomScroll = new JScrollPane();

    public ItemFrame myParent;

    Vector bomRecs = new Vector();

    public BigDecimal priceTotal = new BigDecimal(0);

    public BigDecimal costTotal = new BigDecimal(0);

    JPanel costPricePanel = new JPanel();

    JPanel botPanel = new JPanel();

    JLabel costL = new JLabel("Total Cost:");

    JLabel priceL = new JLabel("Total Price:");

    JLabel costT = new JLabel("", SwingConstants.RIGHT);

    JLabel priceT = new JLabel("", SwingConstants.RIGHT);

    Collection partFam = new ArrayList();

    JobItemCostPrice myRecord = new JobItemCostPrice();

    boolean isCat = false;

    int index = -1;

    public FinancialViewCost(ItemFrame frame) {
        this.myParent = frame;
    }

    public void jbInit(Collection partf, boolean iscat) throws Exception {

        partFam = partf;

        isCat = iscat;

        this.setLayout(new BorderLayout());

        this.setPreferredSize(new Dimension(400, 500));
        bomScroll.setPreferredSize(new Dimension(400, 400));
        botPanel.setPreferredSize(new Dimension(400, 100));

        this.bomTable.setCellSelectionEnabled(false);

        bomTable.setRowSelectionAllowed(false);

        bomTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        bomScroll.getViewport().add(bomTable, null);

        initCostPricePanel();

        initValues();

        initTable();

        bomTable.getSelectionModel().addListSelectionListener(new ResultSelectionListener());
        bomTable.getSelectionModel().setSelectionInterval(0, 0);

        this.setLayout(new VerticalLayout());

        botPanel.setLayout(new BorderLayout());
        botPanel.add(panelDetails, BorderLayout.CENTER);
        botPanel.add(costPricePanel, BorderLayout.EAST);

        this.add(bomScroll);

        this.validate();
        this.repaint();


    }

    public void initCostPricePanel() {

        this.costPricePanel.setLayout(new XYLayout());
        this.costPricePanel.add(this.costL, new XYConstraints(1, 1, 90, 22));
        this.costPricePanel.add(this.priceL, new XYConstraints(1, 25, 90, 22));

        this.costT.setAlignmentX(RIGHT_ALIGNMENT);
        this.costPricePanel.add(this.costT, new XYConstraints(100, 1, 70, 22));
        this.priceT.setAlignmentX(RIGHT_ALIGNMENT);

        this.costPricePanel.add(this.priceT, new XYConstraints(100, 25, 70, 22));

    }

    public void initTable() {

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);

        DefaultCellEditor text = new DefaultCellEditor(new JTextField());

        TableColumnModel columnModel = bomTable.getColumnModel();

        columnModel.getColumn(2).setCellRenderer(renderer);
        columnModel.getColumn(3).setCellEditor(text);
        columnModel.getColumn(3).setCellRenderer(renderer);

        bomTable.packAll();


        bomTable.setColumnControlVisible(true);
    }

    public void initValues() {

        try {

            bomRecs = new Vector();

            bomRecs.addAll(partFam);

            bomTable.setModel(new ResultListModel(bomRecs));

            costTotal = new BigDecimal(0);
            priceTotal = new BigDecimal(0);

            Object[] glass = myParent.partFamilies.toArray();

            for (Object b : glass) {
                costTotal = costTotal.add(((JobItemCostPrice) b).cost);
                priceTotal = priceTotal.add(((JobItemCostPrice) b).price);
            }

            this.costT.setText(myParent.myCS + OEUtility.displayCurrency(costTotal, myParent.locale));
            this.priceT.setText(myParent.myCS + OEUtility.displayCurrency(priceTotal, myParent.locale));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public class ResultSelectionListener implements ListSelectionListener {

        int lastIndex = -1;

        @Override
        public void valueChanged(ListSelectionEvent lse) {
            index = -1;
            int countrows = bomTable.getRowCount();
            index = bomTable.getSelectedRow();

            RuleTest opts = new RuleTest();

            if (index != -1 && index != lastIndex && countrows != 0 && !lse.getValueIsAdjusting()) {
                try {
                    ResultListModel model = (ResultListModel) bomTable.getModel();
                    myRecord = model.getSeries(bomTable.convertRowIndexToModel(index));

                } catch (Exception ex) {
                    Logger.getLogger(FinancialViewCost.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

    }

    public class ResultListModel extends DefaultTableModel {

        Vector datax = null;

        private String[] columnNames = new String[]{
                "Type", "Description", "Cost " + myParent.myCS, "Price " + myParent.myCS
        };

        ResultListModel(Vector v) {
            datax = v;
        }

        public void setRecords(Vector newRecords) {
            this.datax = newRecords;

        }

        @Override
        public int getColumnCount() {
            if (columnNames == null) {
                columnNames = new String[]
                        {
                                "Type", "Description", "Cost " + myParent.myCS, "Price " + myParent.myCS
                        };
            }
            return columnNames.length;
        }

        @Override
        public int getRowCount() {

            return myParent.partFamilies.size();
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

            // if (col == 3 && FinancialViewCost.this.isCat)
            // {
            // return true;
            // }
            return false;
        }

        @Override
        public Object getValueAt(int row, int column) {

            JobItemCostPrice ugr = new JobItemCostPrice();

            if (row < datax.size()) {
                ugr = (JobItemCostPrice) datax.get(row);
                try {
                    if (column == 0) {

                        return ugr.typeid;

                    } else if (column == 1) {

                        return ugr.description;

                    } else if (column == 2) {

                        return OEUtility.displayCurrency(ugr.cost, myParent.locale);

                    } else if (column == 3) {

                        return OEUtility.displayCurrency(ugr.price, myParent.locale);

                    }

                    return null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            return null;
        }

        public void refresh() {

            fireTableRowsDeleted(datax.size(), datax.size());
        }

        public JobItemCostPrice getSeries(int row) {

            return (JobItemCostPrice) datax.get(row);
        }


        @Override
        public void removeRow(int row) {
            datax.remove(row);
            fireTableRowsDeleted(datax.size(), datax.size());
        }

        public void insertPart(JobItemCostPrice ugr) {
            datax.add(ugr);
            fireTableRowsInserted(datax.size(), datax.size());
        }
    }

}
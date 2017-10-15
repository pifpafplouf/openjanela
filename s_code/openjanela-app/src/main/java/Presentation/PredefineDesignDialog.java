package Presentation;

import openjanela.app.configuration.controller.JobItemModelController;
import openjanela.app.configuration.controller.PredefineDesignController;
import openjanela.model.entities.design.Design;
import openjanela.model.entities.design.DesignFamily;
import openjanela.model.entities.partner.Series;
import org.jdesktop.swingx.JXTable;
import org.openjanela.commons.util.zip.GZipFile;
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
import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 01-19-13
 *          Time: 05:55 PM
 */
public class PredefineDesignDialog extends JDialog {

    private final ItemFrame myParent;

    private JPanel optionPanel;
    private JPanel contentPanel;

    private JLabel designFamilyLbl;
    private JComboBox designFamilyCmb;
    private JXTable designsTable;

    //Controller
    private JobItemModelController jobModelController;
    private PredefineDesignController preDesignController;

    /**
     * Predefine Design Dialog Constructor
     */
    public PredefineDesignDialog(ItemFrame parent) {

        // Call super constructor
        super(parent, "Select Predefine Design", true);

        //Setting ItemFrame
        this.myParent = parent;

        //Config predefine design panel
        this.setLayout(new BorderLayout());
    }

    /**
     * Predefine Design Dialog Constructor
     *
     * @param parent, ItemFrame
     */
    public PredefineDesignDialog(ItemFrame parent, PredefineDesignController predefineDesignController) {

        //Call super constructor
        this(parent);

        //Init controller
        this.jobModelController = new JobItemModelController(this.myParent);
        this.preDesignController = predefineDesignController;

        //Init components GUI design
        initComponents();

        //Init values data information
        initValues();

        //Init Listeners
        initListeners();

        //Setting configuration of GUI
        this.setLocation((this.myParent.getWidth() - 700) / 2 - 100, (this.myParent.getHeight() - 300) / 2 - 200);
        this.setPreferredSize(new Dimension(myParent.getWidth() - 600, myParent.getHeight() - 300));
        this.setIconImage(ItemFrame.iconFiles.get("openJanelaIcon").getImage());

        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }

    /**
     * this method init components GUI design panel
     */
    private void initComponents() {

        //***********************************************
        //Config option panel
        //***********************************************
        this.optionPanel = new JPanel();
        this.optionPanel.setLayout(new XYLayout());
        this.optionPanel.setBorder(new EtchedBorder());

        this.designFamilyCmb = new JComboBox();
        this.designFamilyCmb.setModel(new DefaultComboBoxModel());
        this.designFamilyLbl = new JLabel("Design Family");

        this.optionPanel.add(this.designFamilyLbl, new XYConstraints(2, 0, 90, 23));
        this.optionPanel.add(this.designFamilyCmb, new XYConstraints(112, 0, 190, 23));

        //**********************************************
        //Config content panel
        //**********************************************
        this.contentPanel = new JPanel();
        this.contentPanel.setLayout(new BorderLayout());
        this.contentPanel.setBorder(new EtchedBorder());

        this.designsTable = new JXTable(new DefaultTableModel());
        this.designsTable.setSize(new Dimension(myParent.getWidth() - 900, myParent.getHeight() - 400));
        this.designsTable.setCellSelectionEnabled(true);
        this.designsTable.setEditable(false);
        this.designsTable.setTableHeader(null);

        JScrollPane tableScroll = new JScrollPane(designsTable);

        this.contentPanel.add(tableScroll);

        //Setting panels to dialog
        this.add(optionPanel, BorderLayout.NORTH);
        this.add(contentPanel, BorderLayout.CENTER);
    }

    /**
     * This method init values necessary to execute the GUI design
     */
    private void initValues() {

        //Get design family list by series identification
        List<DesignFamily> designFamilyList = preDesignController.searchDesignFamily(((Series) myParent.supplierPanel.
                seriesCmb.getSelectedItem()).getId());

        //Setting family combo box values
        this.designFamilyCmb.removeAllItems();
        this.designFamilyCmb.setModel(new DefaultComboBoxModel(designFamilyList.toArray()));
        if (this.designFamilyCmb.getModel().getSize() > 0) {
            this.designFamilyCmb.setSelectedIndex(0);
        }

        //Init design table model
        initDesignTable();
    }

    /**
     * This method init design table predefined model object
     */
    private void initDesignTable() {

        //Get predefined design list
        DesignFamily designFamily = (DesignFamily) this.designFamilyCmb.getSelectedItem();
        List<Design> designList = preDesignController.searchPredefineDesignModels(designFamily.getId().getId(),
                designFamily.getId().getSeriesId());

        //Calculate row value
        double column = 4.0;
        int row = designList.size() / (int) column;
        double rowValue = designList.size() / column;

        if ((rowValue - row) > 0) {
            row++;
        }

        //Init table model settings
        DefaultTableModel tableModel = (DefaultTableModel) designsTable.getModel();
        tableModel.setRowCount(row);
        tableModel.setColumnCount((int) column);

        TableColumnModel columnModel = designsTable.getColumnModel();

        //Represent the index position in the designList
        int position = 0;

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < column; j++) {

                if (columnModel.getColumnCount() < column) {
                    TableColumn tableColumn = new TableColumn();
                    tableColumn.setCellRenderer(new ImageRenderer());

                    columnModel.addColumn(tableColumn);
                }

                //Evaluate positon is not grather than design list size to set value into table model
                if (position <= (designList.size() - 1)) {
                    Design design = designList.get(position);
                    designsTable.getModel().setValueAt(design, i, j);
                } else {
                    Design design = new Design();
                    design.setDescription("");
                    design.setScaledImage(new byte[0]);
                    designsTable.getModel().setValueAt(design, i, j);
                }

                position++;
            }
        }

        //Setting renderer column model
        ImageRenderer imageRenderer = new ImageRenderer();

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            designsTable.setRowHeight(i, 160);
        }

        for (int j = 0; j < columnModel.getColumnCount(); j++) {
            columnModel.getColumn(j).setWidth(130);
            columnModel.getColumn(j).setCellRenderer(imageRenderer);
        }

        designsTable.repaint();
    }

    /**
     * This method init event listeners for GUI components
     */
    private void initListeners() {

        //DesignsTable mouse listeners
        MouseListener designsTable_mouseListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                designsTable_mousePressed(evt);
            }
        };
        designsTable.addMouseListener(CursorController.createListener(this, designsTable_mouseListener));

        //Design Family Combo Box
        designFamilyCmb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                initDesignTable(); //Init design table model
            }
        });
    }

    //***************************************************************************************
    // GUI Action events
    //***************************************************************************************
    private void designsTable_mousePressed(MouseEvent evt) {

        try {

            if (evt.getClickCount() == 2) {
                int row = designsTable.getSelectedRow();
                int col = designsTable.getSelectedColumn();

                //Get design from model
                Design design = (Design) designsTable.getModel().getValueAt(row, col);

                if (design.getId() != null) {

                    //Update design and design family ID for JobItemModel
                    this.myParent.jobItem.designID = design.getId().getId();
                    this.myParent.jobItem.designFamily = design.getDesignFamily();
                    this.myParent.designFamilyID = design.getDesignFamily();

                    //Open JobItemDefaultDesign
                    this.jobModelController.openJobItemDefaultDesign();

                    //Reset draw canvas
                    this.myParent.dim.resetDim();
                }

                //Close this GUI
                this.dispose();
            }

        } catch (Exception e) {
            // Show message error dialog
     	   e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

            //Close this GUI
            this.dispose();
        }
    }

    /**
     * This Inner class represents a ImageRenderer
     */
    class ImageRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                       int row, int column) {

            Design design = (Design) value;

            JLabel imageLbl = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            try {
                imageLbl.setIcon(new ImageIcon(GZipFile.gzipDecompress(design.getScaledImage())));
            } catch (IOException e) {
                imageLbl.setIcon(null);
            }

            if (design.getId() != null) {
                imageLbl.setText(design.getId().getId() + " - " + design.getDescription());
            } else {
                imageLbl.setText("");
            }

            imageLbl.setSize(130, 140);
            imageLbl.setVerticalTextPosition(JLabel.BOTTOM);
            imageLbl.setHorizontalTextPosition(JLabel.CENTER);

            return imageLbl;
        }
    }
}

package Presentation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.tree.TreePath;

import Model.Facet;
import Model.Frame;
import Model.OpeningObject;
import Model.ShapeObject;
import openjanela.app.configuration.controller.BomViewController;
import openjanela.app.configuration.controller.calculation.DealerCalculationController;
import openjanela.commons.components.generic.XYConstraints;
import openjanela.commons.components.generic.XYLayout;
import openjanela.model.entities.design.Metrics;

import openjanela.model.entities.partner.ValidOrientations;
import orderEntryUtility.OEUtility;
import orderEntryUtility.UOMConvertData;

import org.apache.log4j.Logger;
import org.jdesktop.swingx.JXTreeTable;
import org.jdesktop.swingx.VerticalLayout;

import Model.BillOfMat;
import Model.ProfileParts.Profiles;
import Operations.FindBiggestDLO;

import org.jdesktop.swingx.treetable.DefaultTreeTableModel;
import org.openjanela.commons.util.data.ProfilesPositions;
import org.openjanela.component.BomTreeTableNode;
import org.openjanela.component.JOpenJanelaComponent;
import org.pushingpixels.substance.api.renderers.SubstanceDefaultTableCellRenderer;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Sherif El Dibani
 * @author Eddy Montenegro Date: 03-06-12 Time: 11:41 AM
 *         <p/>
 *         This class represents Bill of Material GUI representation for design
 */
public class BomView extends JPanel implements JOpenJanelaComponent {

    // Apache log4j
    private static final Logger logger = Logger.getLogger(BomView.class);

    public ItemFrame myParent;

    private JXTreeTable bomTreeTable;

    private JScrollPane bomScroll = new JScrollPane();

    private JLabel lAL;

    private JLabel rAL;

    private JLabel r1L;

    private JLabel r2L;

    private JLabel plL;

    private JLabel stnL;

    private JLabel rptL;

    private JLabel delL;

    private JLabel stageL;

    private JLabel notchL;

    private JLabel costL;

    private JLabel priceL;

    private JLabel costT;

    private JLabel priceT;

    public JPanel panelDetails = new JPanel();

    private JPanel costPricePanel;

    private JPanel botPanel;

    public BigDecimal priceTotal;

    public BigDecimal costTotal;

    public JCheckBox viewTree;

    // Bom View Controller
    private BomViewController controller;

    /**
     * Default Bill of Material Constructor
     */
    public BomView() {

        // Setting default Layout
        this.setLayout(new VerticalLayout());
    }

    /**
     * Bill of Material Constructor
     *
     * @param parent , ItemFrame
     */
    public BomView(ItemFrame parent) {

        // Call main constructor
        this();

        // Init Parent ItemFrame
        this.myParent = parent;

        // Init controller
        this.controller = new BomViewController(this.myParent);

        // Init User Interface Design
        this.initComponents();
        this.initValueComponents();
        this.initListenersComponents();
    }

    /**
     * Init Item Frame Component
     *
     * @param parent, ItemFrame
     */
    public void initItemFrame(ItemFrame parent) {

        //Init Item Frame Panel
        this.myParent = parent;

        //Init BomView Controller
        this.controller = new BomViewController(this.myParent);
    }

    /**
     * Build Design Bill of Materials for Job Item
     *
     * @param doBOM, Execute all rules for Bill of Materials
     */
    public void buildDesignBOM(boolean doBOM) {

        //TODO: NOT DONE FOR contentIN and contentOUT

        //Clear Bill Of Material for Job Item
        this.myParent.jobItem.bom.clear();

        //Execute Bill Of Material Model Rules
        this.myParent.executeRules(doBOM);

        //Init Bill Of Material Collection
        this.myParent.jobItem.design.loadBOMParts();

//        if (this.myParent.jobItem != null && this.myParent.jobItem.design != null) {
//
//            shapeObjectBOM(this.myParent.jobItem.design);
//
//            Object[] fs = this.myParent.jobItem.design.frames.toArray();
//
//            for (Object facet : fs) {
//
//                shapeObjectBOM(((Facet) facet));
//
//                Object[] fframes = ((Facet) facet).frames.toArray();
//
//                for (final Object f : fframes) {
//                    if (((Frame) f).shapeID != 10) {
//                        shapeObjectBOM((Frame) f);
//                    }
//                }
//            }
//        }
    }

    /**
     * Build Design Bill of Materials for Glass
     *
     * @param o, Object
     */
    public void bomFromGlass(Object o) {

        if (((OpeningObject) o).myGlassMid != null && ((OpeningObject) o).myGlassMid.bom.size() > 0) {
            this.myParent.jobItem.bom.addAll(((OpeningObject) o).myGlassMid.bom);
            if (((OpeningObject) o).myGlassMid.bOpeningObject != null
                    && ((OpeningObject) o).myGlassMid.bom.size() > 0) {
                this.myParent.jobItem.bom.addAll(((OpeningObject) o).myGlassMid.bOpeningObject.bom);
            }
        }
    }

    /**
     * Build Design Bill of Materials for Shape Object
     *
     * @param f, ShapeObject
     */
    public void shapeObjectBOM(ShapeObject f) {

        // Add All BOM for Facet
        if (((ShapeObject) f).bOpeningObject != null && ((ShapeObject) f).bom.size() > 0) {
            this.myParent.jobItem.bom.addAll(((ShapeObject) f).bom);
        }

        // Add All BOM for BackGround Opening of Facet
        if (((ShapeObject) f).bOpeningObject != null && ((ShapeObject) f).bOpeningObject.bom.size() > 0) {
            this.myParent.jobItem.bom.addAll(((ShapeObject) f).bOpeningObject.bom);
        }

        // Add All BOM for Mullions V

        Object[] mullionsV = ((ShapeObject) f).bOpeningObject.mullions.toArray();

        for (Object mv : mullionsV) {
            if (((Profiles) mv).bom.size() > 0) {
                this.myParent.jobItem.bom.addAll(((Profiles) mv).bom);
            }
        }

        // Add All BOM for Couplers H
        Object[] mullionsH = ((ShapeObject) f).bOpeningObject.mullionsH.toArray();

        for (Object mh : mullionsH) {
            if (((Profiles) mh).bom.size() > 0) {
                this.myParent.jobItem.bom.addAll(((Profiles) mh).bom);
            }
        }

        // Add All BOM for Openings
        Object[] fos = ((ShapeObject) f).openings.toArray();

        for (Object fo : fos) {
            if (((OpeningObject) fo).bom.size() > 0) {
                this.myParent.jobItem.bom.addAll(((OpeningObject) fo).bom);
            }

            if (((OpeningObject) fo).contentMid == 1) {

                doBomForGlassContent(fo);

            } else if (((OpeningObject) fo).contentMid == 2) {

                if (((OpeningObject) fo).sashObjectMid != null) {

                    shapeObjectBOM(((OpeningObject) fo).sashObjectMid);

                    final Object[] sTypeO = ((OpeningObject) fo).sashObjectMid.openings.toArray();

                    for (final Object sTO : sTypeO) {

                        if (((OpeningObject) sTO).contentMid == 1) {
                            Object[] fixedOps = ((OpeningObject) sTO).openings.toArray();
                            for (final Object fop : fixedOps) {
                                doBomForGlassContent(fop);
                            }
                        }
                    }

                    final Object[] sL = ((OpeningObject) fo).sashObjectMid.frames.toArray();

                    for (final Object l : sL) {
                        if (((ShapeObject) l) != null) {
                            shapeObjectBOM(((ShapeObject) l));
                        }
                    }
                }
            } else if (((OpeningObject) fo).contentMid == 3) {
                shapeObjectBOM(((OpeningObject) fo).subFacet);

                Object[] fframes = ((OpeningObject) fo).subFacet.frames.toArray();

                for (Object sf : fframes) {
                    if (((Frame) f).shapeID != 10) {
                        shapeObjectBOM((Frame) sf);
                    }
                }
            }
        }
    }

    /**
     * Build Design Bill of Materials for Glass Content
     *
     * @param fo, Object
     */
    public void doBomForGlassContent(Object fo) {

        if (((OpeningObject) fo).glazingBeadsMid != null) {
            Object[] gbs = ((OpeningObject) fo).glazingBeadsMid.toArray();

            for (Object gb : gbs) {
                this.myParent.jobItem.bom.addAll(((Profiles) gb).bom);
            }
        }

        bomFromDLO((OpeningObject) fo);
        bomFromGlass((OpeningObject) fo);
    }

    /**
     * Build Design Bill of Materials for Opening Object
     *
     * @param o, OpeningObject
     */
    public void bomFromDLO(OpeningObject o) {

        // Add All BOM for DLO
        if (((OpeningObject) o).dloMid != null) {
            if (((OpeningObject) o).dloMid.bom.size() > 0) {
                this.myParent.jobItem.bom.addAll(((OpeningObject) o).dloMid.bom);
            }
            if (((OpeningObject) o).dloMid.bOpeningObject != null && ((OpeningObject) o).dloMid.bOpeningObject.bom.size() > 0) {
                this.myParent.jobItem.bom.addAll(((OpeningObject) o).dloMid.bOpeningObject.bom);
            }

            FindBiggestDLO findDLO = new FindBiggestDLO();

            findDLO.gridBOMFromDLO(((OpeningObject) o).dloMid);

            // Add All BOM for DLO Openings
            Object[] dloOs = ((OpeningObject) o).dloMid.openings.toArray();

            for (Object dloO : dloOs) {
                if (((OpeningObject) dloO).bom.size() > 0) {
                    this.myParent.jobItem.bom.addAll(((OpeningObject) dloO).bom);
                }
                if (((OpeningObject) dloO).bOpeningObject != null && ((OpeningObject) dloO).bOpeningObject.bom.size() > 0) {
                    this.myParent.jobItem.bom.addAll(((OpeningObject) dloO).bOpeningObject.bom);
                }

                if (((OpeningObject) dloO).bOpeningObject != null && ((OpeningObject) dloO).bOpeningObject.mullions != null
                        && ((OpeningObject) dloO).bOpeningObject.mullions.size() > 0) {
                    Object[] mullionsVdlo = ((OpeningObject) dloO).bOpeningObject.mullions.toArray();

                    for (Object mv : mullionsVdlo) {
                        if (((Profiles) mv).bom.size() > 0) {
                            this.myParent.jobItem.bom.addAll(((Profiles) mv).bom);
                        }
                    }
                }

                if (((OpeningObject) dloO).bOpeningObject != null && ((OpeningObject) dloO).bOpeningObject.mullionsH != null
                        && ((OpeningObject) dloO).bOpeningObject.mullionsH.size() > 0) {
                    // Add All BOM for Couplers H
                    Object[] mullionsHdlo = ((OpeningObject) dloO).bOpeningObject.mullionsH.toArray();

                    for (Object mh : mullionsHdlo) {
                        if (((Profiles) mh).bom.size() > 0) {
                            this.myParent.jobItem.bom.addAll(((Profiles) mh).bom);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void initComponents() {

        // Init bom scroll
        bomScroll.setPreferredSize(new Dimension(800, 600));
        bomScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        bomScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // *************************************************
        // Init Panel components
        // *************************************************
        this.initDetailPanel();
        this.initCostPricePanel();

        botPanel = new JPanel(new BorderLayout());
        botPanel.add(panelDetails, BorderLayout.CENTER);
        botPanel.add(costPricePanel, BorderLayout.EAST);

        // *************************************************
        // Init Bom View Panel Components
        // *************************************************
        this.setLayout(new BorderLayout());
        this.add(bomScroll, BorderLayout.CENTER);
        this.add(botPanel, BorderLayout.SOUTH);

        // Init TreeTable component
        initTreeTableComponent();
    }

    @Override
    public void initValueComponents() {

        // Calculate total cost and total price
        this.costTotal = new BigDecimal(0);
        this.priceTotal = new BigDecimal(0);

        for (BillOfMat b : this.myParent.jobItem.bom) {
            if (!b.remote) {
                costTotal = costTotal.add(b.cost);
                priceTotal = priceTotal.add(b.priceuser);
            }
        }

        this.costT.setText(myParent.myCS + OEUtility.displayCurrency(costTotal, myParent.locale));
        this.priceT.setText(myParent.myCS + OEUtility.displayCurrency(priceTotal, myParent.locale));

    }

    @Override
    public void initListenersComponents() {

        // Adding listener table productos
        bomTreeTable.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                int selectedRow = bomTreeTable.getSelectedRow();

                if (selectedRow >= 0) {
                    TreePath path = bomTreeTable.getPathForRow(selectedRow);
                    BomTreeTableNode object = (BomTreeTableNode) path.getLastPathComponent();

                    setValues(object.getBillOfMat());
                }
            }
        });


        viewTree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewTreeActionPerformed(e);
            }
        });
    }

    /**
     * Init Detail Panel components
     */
    public void initDetailPanel() {

        lAL = new JLabel("Left Angle");
        rAL = new JLabel("Left Angle");
        r1L = new JLabel("Radius 1");
        r2L = new JLabel("Radius 2");
        plL = new JLabel("Prod. Line");
        stnL = new JLabel("Station");
        rptL = new JLabel("Report");
        delL = new JLabel("Phase");
        stageL = new JLabel("Stage");
        notchL = new JLabel("Notch");

        viewTree = new JCheckBox("View BOM Hiearchy");
        viewTree.setSelected(true);

        panelDetails = new JPanel(new XYLayout());
        panelDetails.add(this.lAL, new XYConstraints(5, 1, 110, 22));
        panelDetails.add(this.rAL, new XYConstraints(5, 25, 110, 22));
        panelDetails.add(this.r1L, new XYConstraints(125, 1, 150, 22));
        panelDetails.add(this.r2L, new XYConstraints(125, 25, 150, 22));
        panelDetails.add(this.plL, new XYConstraints(277, 1, 110, 22));
        panelDetails.add(this.stnL, new XYConstraints(277, 25, 110, 22));
        panelDetails.add(this.rptL, new XYConstraints(390, 1, 110, 22));
        panelDetails.add(this.delL, new XYConstraints(390, 25, 110, 22));
        panelDetails.add(this.stageL, new XYConstraints(502, 1, 110, 22));
        panelDetails.add(this.notchL, new XYConstraints(502, 25, 300, 22));
        panelDetails.add(this.viewTree, new XYConstraints(614, 1, 160, 22));
    }

    /**
     * Init Cost Price Panel components
     */
    public void initCostPricePanel() {

        costL = new JLabel("Total Cost:");
        priceL = new JLabel("Total Price:");

        costT = new JLabel("", SwingConstants.RIGHT);
        priceT = new JLabel("", SwingConstants.RIGHT);

        costPricePanel = new JPanel(new XYLayout());
        costPricePanel.add(this.costL, new XYConstraints(1, 1, 90, 22));
        costPricePanel.add(this.priceL, new XYConstraints(1, 25, 90, 22));
        costPricePanel.add(this.costT, new XYConstraints(100, 1, 70, 22));
        costPricePanel.add(this.priceT, new XYConstraints(100, 25, 70, 22));
    }

    /**
     * Init Tree Table component
     */
    private void initTreeTableComponent() {

        //******************************************************************
        // Init TreeTable model
        //******************************************************************
        BomTreeTableNode rootNode;

        if (!this.myParent.isNewItem && !this.myParent.calcBom) {
            rootNode = controller.openTreeTableNodeValue();
        } else {
            rootNode = controller.initTreeTableNodeValues();
        }

        // Init & Config bomTreeTable
        bomTreeTable = new JXTreeTable(new BomViewTreeTableModel(rootNode));
        bomTreeTable.setEditable(false);
        bomTreeTable.setCellSelectionEnabled(false);
        bomTreeTable.setRowSelectionAllowed(true);
        bomTreeTable.setShowGrid(true);

        //Expand All nodes for Bom Tree Node
        bomTreeTable.expandAll();

        DefaultTableCellRenderer renderAlignRight = new DefaultTableCellRenderer();
        renderAlignRight.setHorizontalAlignment(SwingConstants.RIGHT);

        bomTreeTable.getColumnModel().getColumn(3).setCellRenderer(renderAlignRight);
        bomTreeTable.getColumnModel().getColumn(4).setCellRenderer(renderAlignRight);
        bomTreeTable.getColumnModel().getColumn(7).setCellRenderer(renderAlignRight);
        bomTreeTable.getColumnModel().getColumn(10).setCellRenderer(renderAlignRight);
        bomTreeTable.getColumnModel().getColumn(11).setCellRenderer(renderAlignRight);
        bomTreeTable.getColumnModel().getColumn(12).setCellRenderer(renderAlignRight);
        bomTreeTable.getColumnModel().getColumn(13).setCellRenderer(renderAlignRight);

        bomTreeTable.packAll();

        // Adding treeTable to scroll component
        bomScroll.getViewport().add(bomTreeTable, null);
    }

    /**
     * Init Tree Table Node Values
     */
    public void initTreeTableBomValues() {
        controller.initTreeTableNodeValues();
    }

    /**
     * This method set description values for Bill of Materials object
     *
     * @param billOfMat , BillOfMaterial
     */
    public void setValues(BillOfMat billOfMat) {

        try {

            lAL.setText("L/T Angle : " + billOfMat.leftangle + "");
            rAL.setText("R/B Angle: " + billOfMat.rightangle + "");

            if (myParent.currentUOM == 1) {
                r1L.setText("Radius 1: " + billOfMat.radius1 / 100d);
                r2L.setText("Radius 2: " + billOfMat.radius2 / 100d + "");

                notchL.setText("Notch: ");
                for (String notch : billOfMat.notchesM) {
                    notchL.setText(notchL.getText() + notch + "  ");
                }


            } else {

                if (myParent.currentUOM == 2) {
                    r1L.setText("Radius 1: " + billOfMat.radius1i / 64d + "");
                    r2L.setText("Radius 2: " + billOfMat.radius2i / 64d + "");

                    //Adding Notch Values
                    notchL.setText("Notch: ");
                    for (String notch : billOfMat.notchesI) {
                        notchL.setText(notchL.getText() + notch + "  ");
                    }

                } else if (myParent.currentUOM == 3) {
                    r1L.setText("Radius 1: " + UOMConvertData.imperialToFraction(billOfMat.radius1i / 64d + "") + "");
                    r2L.setText("Radius 2: " + UOMConvertData.imperialToFraction(billOfMat.radius2i / 64d + "") + "");

                    //Adding Notch Values
                    notchL.setText("Notch: ");
                    for (String notch : billOfMat.notchesIY) {
                        notchL.setText(notchL.getText() + notch + "  ");
                    }
                }
            }

            plL.setText("Prod. Line: " + billOfMat.prodline + "");
            stnL.setText("Station   : " + billOfMat.station + "");
            rptL.setText("Report    : " + billOfMat.report + "");
            delL.setText("Delivery  : " + billOfMat.delivery + "");
            stageL.setText("Stage     : " + billOfMat.reqforstage + "");

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    //******************************************************************************************************************
    //Action Events
    //******************************************************************************************************************
    private void viewTreeActionPerformed(ActionEvent event) {

        if (viewTree.isSelected()) {
            BomTreeTableNode rootNode = controller.initTreeTableNodeValues();
            bomTreeTable.setTreeTableModel(new BomViewTreeTableModel(rootNode));
        } else {
            BomTreeTableNode rootNode = controller.initTableValues();
            bomTreeTable.setTreeTableModel(new BomViewTreeTableModel(rootNode));
        }

        bomTreeTable.expandAll();
        bomTreeTable.packAll();
        bomTreeTable.repaint();
    }

    /**
     * Bill Of Materials Tree Table Model Design
     */
    public class BomViewTreeTableModel extends DefaultTreeTableModel {

        /**
         * Constructor BomViewTreeTableModel
         *
         * @param rootNode , DefaultMutableTreeTableNode
         */
        public BomViewTreeTableModel(BomTreeTableNode rootNode) {
            super(rootNode);
        }

        @Override
        public int getColumnCount() {
            return 14;
        }

        @Override
        public String getColumnName(int column) {

            switch (column) {
                case 0:
                    return "Series No / RN";
                case 1:
                    return "Stock Code";
                case 2:
                    return "Description";
                case 3:
                    return "Qty";
                case 4:
                    return "Length";
                case 5:
                    return "Pos";
                case 6:
                    return "Level";
                case 7:
                    return "Seq.";
                case 8:
                    return "Pane";
                case 9:
                    return "Shape";
                case 10:
                    return "Width";
                case 11:
                    return "Height";
                case 12:
                    return "Cost USD";
                case 13:
                    return "Price USD";
                default:
                    return "";
            }
        }

        @Override
        public Object getValueAt(Object o, int column) {

            BomTreeTableNode node = (BomTreeTableNode) o;
            BillOfMat billOfMat = node.getBillOfMat();

            try {

                switch (column) {
                    case 0:

                        //Setting Result List Cell Renderer
                        bomTreeTable.getColumnModel().getColumn(0).setCellRenderer(new ResultListCellRenderer());

                        if (billOfMat.ruleno <= 0 && billOfMat.ruleno >= -10) {
                            return "Grid";
                        }

                        return billOfMat.seriesid + " / " + billOfMat.ruleno;

                    case 1:

                        //Setting Result List Cell Renderer
                        bomTreeTable.getColumnModel().getColumn(1).setCellRenderer(new ResultListCellRenderer());

                        return billOfMat.stockcode;
                    case 2:

                        //Setting Result List Cell Renderer
                        bomTreeTable.getColumnModel().getColumn(2).setCellRenderer(new ResultListCellRenderer());

                        return billOfMat.description;
                    case 3:

                        //Setting Result List Cell Renderer
                        bomTreeTable.getColumnModel().getColumn(3).setCellRenderer(new ResultListCellRenderer());

                        return billOfMat.qty;
                    case 4:

                        //Setting Result List Cell Renderer
                        bomTreeTable.getColumnModel().getColumn(4).setCellRenderer(new ResultListCellRenderer());

                        if (billOfMat.cutlength > 0 || billOfMat.cutlengthi > 0) {
                            if (myParent.currentUOM == Metrics.METRIC.getValue()) {
                                return "" + billOfMat.cutlength / 100d;
                            } else {
                                if (myParent.currentUOM == Metrics.IMPERIAL_DECIMAL.getValue()) {
                                    return billOfMat.cutlengthi / 64d;
                                } else if (myParent.currentUOM == Metrics.IMPERIAL_FRACTION.getValue()) {
                                    return UOMConvertData.imperialToFraction(billOfMat.cutlengthi / 64d + "");
                                }
                            }

                        } else {
                            return "---";
                        }

                    case 5:

                        //Setting Result List Cell Renderer
                        bomTreeTable.getColumnModel().getColumn(5).setCellRenderer(new ResultListCellRenderer());

                        int position = billOfMat.position;

                        if (billOfMat.ruleno <= 0) {
                            if (position == 1) {
                                return "|--|";
                            } else if (position == 2) {
                                return "|-*";
                            } else if (position == 3) {
                                return "*-|";
                            } else if (position == 4) {
                                return "*-*";
                            }
                        }

                        if (billOfMat.cOrM > 0) {
                            if (billOfMat.orientation == ValidOrientations.VERTICAL.getValue()) {
                                return "Vert";
                            } else if (billOfMat.orientation == ValidOrientations.HORIZONTAL.getValue()) {
                                return "Horiz";
                            }
                        }

                        //Return profiles positions
                        return ProfilesPositions.getPosition(position);

                    case 6:

                        //Setting Result List Cell Renderer
                        bomTreeTable.getColumnModel().getColumn(6).setCellRenderer(new ResultListCellRenderer());

                        return billOfMat.descriptionLevel;
                    case 7:

                        //Setting Result List Cell Renderer
                        bomTreeTable.getColumnModel().getColumn(7).setCellRenderer(new ResultListCellRenderer());

                        return "" + billOfMat.a_sequenceID;
                    case 8:

                        //Setting Result List Cell Renderer
                        bomTreeTable.getColumnModel().getColumn(8).setCellRenderer(new ResultListCellRenderer());

                        return billOfMat.sashAbbreviation;
                    case 9:

                        //Setting Result List Cell Renderer
                        bomTreeTable.getColumnModel().getColumn(9).setCellRenderer(new ResultListCellRenderer());

                        return billOfMat.shapeAbbreviation;
                    case 10:

                        //Setting Result List Cell Renderer
                        bomTreeTable.getColumnModel().getColumn(10).setCellRenderer(new ResultListCellRenderer());

                        if (myParent.currentUOM == Metrics.METRIC.getValue()) {
                            return billOfMat.width / 100;
                        } else {
                            if (myParent.currentUOM == Metrics.IMPERIAL_DECIMAL.getValue()) {
                                return billOfMat.widthi / 64d;
                            } else if (myParent.currentUOM == Metrics.IMPERIAL_FRACTION.getValue()) {
                                return UOMConvertData.imperialToFraction(billOfMat.widthi / 64d + "");
                            }
                        }
                    case 11:

                        //Setting Result List Cell Renderer
                        bomTreeTable.getColumnModel().getColumn(11).setCellRenderer(new ResultListCellRenderer());

                        if (myParent.currentUOM == Metrics.METRIC.getValue()) {
                            return billOfMat.height / 100;
                        } else {
                            if (myParent.currentUOM == Metrics.IMPERIAL_DECIMAL.getValue()) {
                                return billOfMat.heighti / 64d;
                            } else if (myParent.currentUOM == Metrics.IMPERIAL_FRACTION.getValue()) {
                                return UOMConvertData.imperialToFraction(billOfMat.heighti / 64d + "");
                            }
                        }
                    case 12:

                        //Setting Result List Cell Renderer
                        bomTreeTable.getColumnModel().getColumn(12).setCellRenderer(new ResultListCellRenderer());

                        return OEUtility.displayCurrency(billOfMat.totalcost, myParent.locale);
                    case 13:

                        //Setting Result List Cell Renderer
                        bomTreeTable.getColumnModel().getColumn(13).setCellRenderer(new ResultListCellRenderer());

                        return OEUtility.displayCurrency(billOfMat.totalprice, myParent.locale);
                }

            } catch (Exception e) {
                return "";
            }

            return "";
        }

        @Override
        public Object getChild(Object parent, int index) {
            BomTreeTableNode treenode = (BomTreeTableNode) parent;
            return treenode.getChildAt(index);
        }

        @Override
        public int getChildCount(Object parent) {
            BomTreeTableNode treenode = (BomTreeTableNode) parent;
            return treenode.getChildCount();
        }

        @Override
        public int getIndexOfChild(Object parent, Object child) {

            BomTreeTableNode treenode = (BomTreeTableNode) parent;
            for (int i = 0; i > treenode.getChildCount(); i++) {
                if (treenode.getChildAt(i) == child) {
                    return i;
                }
            }

            return 0;
        }
    }

    /**
     * Result List Cell Renderer
     */
    public class ResultListCellRenderer extends SubstanceDefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {

            JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            TreePath path = bomTreeTable.getPathForRow(row);

            if (path != null) {

                BomTreeTableNode object = (BomTreeTableNode) path.getLastPathComponent();

                if (isSelected) {
                    label.setBackground(new Color(197, 126, 41, 128));
                }

                if (object != null) {

                    BillOfMat billOfMat = object.getBillOfMat();

                    if (billOfMat.isLostAssembly) {
                        label.setBackground(new Color(255, 0, 0, 128));
                    }
                }

                //Assembly Part if buy to supplier
                if (object.getBillOfMat().supplier_rule_no == -300) {
                    label.setBackground(new Color(0, 255, 0, 128));
                }
            }

            return label;
        }
    }

}

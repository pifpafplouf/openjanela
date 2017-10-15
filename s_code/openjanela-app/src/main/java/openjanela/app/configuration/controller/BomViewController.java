package openjanela.app.configuration.controller;

import Model.BillOfMat;
import Model.DesignGlass;
import Model.DesignGrid;
import Model.GlassSU;
import Presentation.BomView;
import Presentation.ItemFrame;
import openjanela.app.configuration.controller.calculation.DealerCalculationController;
import openjanela.app.configuration.controller.calculation.GlassCalculationController;
import openjanela.model.entities.admin.SystemUOM;
import openjanela.model.entities.design.Metrics;
import openjanela.model.entities.partner.Grids;
import openjanela.model.entities.partner.ProductionLine;
import openjanela.model.entities.partner.SUType;
import openjanela.model.entities.partner.ValidOrientations;
import openjanela.model.entities.parts.Parts;
import orderEntryUtility.BOMSorter;
import org.apache.log4j.Logger;
import org.openjanela.component.BomTreeTableNode;
import org.openjanela.data.ApplicationBaseApp;
import org.openjanela.data.ApplicationMainBaseApp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 *         Date: 02-26-13
 *         Time: 10:42 AM
 */
public class BomViewController extends BaseController {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(BomViewController.class);

    /**
     * Represents the temporal code ID for Bill of Material
     */
    private int bomID = 0;

    /**
     * Represents the temporal code ID for Glass Bill of Material
     */
    private int glassID = 0;

    /**
     * ItemFrame main administration design
     */
    private ItemFrame myFrame;

    /**
     * Bom View Component GUI
     */
    private BomView bomView;

    //Controllers access
    private GlassCalculationController glassCalculationController;

    /**
     * Bom View Controller Constructor
     */
    public BomViewController() {
        glassCalculationController = new GlassCalculationController();
    }

    /**
     * Bom View Controller Constructor
     *
     * @param myFrame, ItemFrame
     */
    public BomViewController(ItemFrame myFrame) {

        //Call main constructor
        this();

        //Setting main Frame
        this.myFrame = myFrame;
    }

    /**
     * This method init parent boms values for table representation
     *
     * @return BomTreeTableNode
     */
    public BomTreeTableNode initTableValues() {

        try {

            //Init root node
            BomTreeTableNode rootNode = new BomTreeTableNode(new BillOfMat());

            //Sort collection of bill of materials by rule number
            List<BillOfMat> boms = new ArrayList<BillOfMat>(this.myFrame.jobItem.bom);

            for (BillOfMat bom : boms) {

                //Not visualized remote supplier bill of material
                if (bom.remote) {
                    continue;
                }

                //Update level description
                if (bom.level > 0) {
                    bom.descriptionLevel = ItemFrame.getApplicationBase().getTypeLevel(bom.level).getDescription();
                }

                //Update Shape description
                if (bom.shapeID > 0) {
                    bom.shapeAbbreviation = ItemFrame.getApplicationBase().getTypeShape(bom.shapeID).getAbbrev();
                }

                //Update Sash description
                if (bom.sash > 0) {
                    bom.sashAbbreviation = ItemFrame.getApplicationBaseRules().getSeriesValidOpeningById(bom.sash).
                            getSeriesValidOpeningPK().getAbbreviation();
                }

                BomTreeTableNode bomNode = new BomTreeTableNode(bom);
                rootNode.add(bomNode);
            }

            return rootNode;

        } catch (Exception e) {
            logger.error(e.getMessage(), e);

            //Return a root node empty
            return new BomTreeTableNode(new BillOfMat());
        }
    }

    /**
     * This method init parent boms values for tree table representation
     *
     * @return BomTreeTableNode, Bom Tree Table Node
     */
    public BomTreeTableNode initTreeTableNodeValues() {

        try {

            //**********************************************************************
            //Execute Model Rules
            //**********************************************************************
            if (this.myFrame.calcBom) {

                //Build Design BOM
                this.myFrame.bomView.buildDesignBOM(true);
            }

            //**********************************************************************
            //Preparing Bill of Material for construct assembly parts
            //**********************************************************************
            this.bomID = 1;
            this.glassID = 1;

            for (Iterator it = this.myFrame.jobItem.bom.iterator(); it.hasNext(); ) {

                BillOfMat billOfMat = (BillOfMat) it.next();

                billOfMat.bomId = bomID;
                billOfMat.parentbomid = 0;
                billOfMat.isUsed = false;

                //**********************************************************************
                //Remove Bill of Material for GlassSU
                //**********************************************************************
                if (billOfMat.ruleno == -100) {
                    it.remove();
                }

                this.bomID++;
            }

            //**********************************************************************
            //Preparing Bill of Material for glass assembly parts
            //**********************************************************************

            //Reset Glass Bom design collection
            if (this.myFrame.calcBom) {
                this.myFrame.jobItem.design.resetGlassBom();
            }

            for (DesignGlass designGlass : this.myFrame.jobItem.glassBOM) {
                designGlass.glassBomID = 0;
                designGlass.isUsed = false;
            }

            //**********************************************************************
            //Search root assemblies
            //**********************************************************************
            List<BillOfMat> rootAssemblies = new ArrayList<BillOfMat>();
            for (BillOfMat billOfMat : this.myFrame.jobItem.bom) {
                if (billOfMat.parentAssembly <= 0) {

                    //Return part type
                    int partType = 0;
                    if (billOfMat.remote) {
                        Parts parts = ItemFrame.getApplicationRemoteBaseRules().getPart(billOfMat.supplierRemoteId, billOfMat.partid);
                        partType = parts.getParttype();
                    } else {
                        Parts parts = ItemFrame.getApplicationBaseRules().getPart(billOfMat.partid);
                        partType = parts.getParttype();
                    }

                    //Setting assembly
                    if (partType == 12 || partType == 13) {
                        billOfMat.assembly = true;
                        billOfMat.isUsed = true;

                        //Adding to collection of root assemblies
                        rootAssemblies.add(billOfMat);
                    }
                }
            }

            //***************************************************
            //Search assemblies parts
            //***************************************************
            List<BillOfMat> assemblies = new ArrayList<BillOfMat>();
            for (BillOfMat billOfMat : this.myFrame.jobItem.bom) {

                if (!billOfMat.isUsed) {

                    //Return part type
                    int partType = billOfMat.parttype;

                    if ((billOfMat.partid == billOfMat.assemblyid) && (partType == 12 || partType == 13)) {
                        billOfMat.assembly = true;
                        assemblies.add(billOfMat);
                    }
                }
            }

            //Sort Root Assemblies to execute remote assemblies first
            Collections.sort(rootAssemblies, BOMSorter.Remote);

            //Init root node
            BomTreeTableNode rootNode = new BomTreeTableNode(new BillOfMat());
            for (BillOfMat rootAssembly : rootAssemblies) {
                BomTreeTableNode rootAssemblyNode = new BomTreeTableNode(rootAssembly);

                //Init Assembly Node values
                initAssemblyNodes(rootAssemblyNode, assemblies);

                //Init Assembly Missed Node values
                initAssemblyPartMissed(rootAssemblyNode);

                //Adding Main Root Node Assembly : Visualize only Bom manufactured
                if (!rootAssembly.remote) {
                    rootNode.add(rootAssemblyNode);
                }
            }

            //------------------------------------------------------------------
            //Calculate Cost Price Dealer - BOM
            //------------------------------------------------------------------
            if (this.myFrame.calcBom) {
                DealerCalculationController dealerCalculationController = new DealerCalculationController(this.myFrame);
                dealerCalculationController.calculateCostPriceDealer();
            }

            return rootNode;

        } catch (Exception e) {
            logger.error(e.getMessage(), e);

            //Return a root node empty
            return new BomTreeTableNode(new BillOfMat());
        }
    }

    /**
     * This method open parent boms values for tree table representation
     *
     * @return BomTreeTableNode, Bom Tree Table Node
     */
    public BomTreeTableNode openTreeTableNodeValue() {

        //******************************************************************
        //1. Search Root Bill Of Material Component
        //******************************************************************
        //Init root node
        BomTreeTableNode rootNode = new BomTreeTableNode(new BillOfMat());

        //Root Bill Of Material Component Value
        List<BillOfMat> rootBillOfMats = new ArrayList<BillOfMat>();

        List<BillOfMat> boms = new ArrayList<BillOfMat>();
        boms.addAll(this.myFrame.jobItem.bom);

        Collections.sort(boms, BOMSorter.RuleNumber);

        //Setting BOM to Job Item
        this.myFrame.jobItem.bom = boms;

        for (BillOfMat billOfMat : this.myFrame.jobItem.bom) {

            //Not include bill of material from external supplier
            if (billOfMat.remote) {
                continue;
            }

            if (billOfMat.parentbomid == 0) {
                rootBillOfMats.add(billOfMat);
            }
        }

        //******************************************************************
        //2. Search Child Boms for bill of materials
        //******************************************************************
        for (BillOfMat rootBillOfMat : rootBillOfMats) {
            BomTreeTableNode assemblyNode = new BomTreeTableNode(rootBillOfMat);
            initChildBillOfMaterials(assemblyNode);

            rootNode.add(assemblyNode);
        }

        return rootNode;
    }

    //********************************Utility Methods*******************************************************************

    /**
     * Init Child Bill Of Materials Components by parent BOM Id
     *
     * @param parentNode, BomTreeTableNode
     */
    private void initChildBillOfMaterials(BomTreeTableNode parentNode) {

        //Return parent Bill of Material
        BillOfMat parentBom = parentNode.getBillOfMat();

        for (BillOfMat billOfMat : this.myFrame.jobItem.bom) {

            //Not Include Bill Of Material from external supplier
            if (billOfMat.remote) {
                continue;
            }

            if (billOfMat.parentbomid == parentBom.bomId) {

                //Update level description
                if (billOfMat.level > 0) {
                    billOfMat.descriptionLevel = ItemFrame.getApplicationBase().getTypeLevel(billOfMat.level).getDescription();
                }

                //Update Shape description
                if (billOfMat.shapeID > 0) {
                    billOfMat.shapeAbbreviation = ItemFrame.getApplicationBase().getTypeShape(billOfMat.shapeID).getAbbrev();
                }

                //Update Sash description
                if (billOfMat.sash > 0) {
                    if (billOfMat.remote) {
                        billOfMat.sashAbbreviation = ItemFrame.getApplicationRemoteBaseRules().getSeriesValidOpeningById(
                                billOfMat.sash).getSeriesValidOpeningPK().getAbbreviation();
                    } else {
                        billOfMat.sashAbbreviation = ItemFrame.getApplicationBaseRules().getSeriesValidOpeningById(
                                billOfMat.sash).getSeriesValidOpeningPK().getAbbreviation();
                    }
                }

                //Create Bom Tree Table Node
                BomTreeTableNode bomNode = new BomTreeTableNode(billOfMat);

                //Check if bill of material has childs
                if (hasChildBillOfMaterial(billOfMat)) {
                    initChildBillOfMaterials(bomNode);
                }

                parentNode.add(bomNode);
            }
        }
    }

    /**
     * Search if a Bill of Materials has a child
     *
     * @param billOfMat, BillOfMat
     * @return boolean
     */
    private boolean hasChildBillOfMaterial(BillOfMat billOfMat) {

        boolean hasChilds = false;

        for (BillOfMat bom : this.myFrame.jobItem.bom) {
            if (bom.parentbomid == billOfMat.bomId) {
                hasChilds = true;

                break;
            }
        }

        return hasChilds;
    }

    /**
     * Init Assemblies nodes for Bill of Materials
     *
     * @param rootNode,   BomTreeTableNode
     * @param assemblies, List<BillOfMat>
     */
    private BomTreeTableNode initAssemblyNodes(BomTreeTableNode rootNode, List<BillOfMat> assemblies) {

        try {

            //Get root assembly
            BillOfMat rootAssembly = rootNode.getBillOfMat();

            for (BillOfMat assembly : assemblies) {

                //--------------------------------------------------------------------------------------------
                //1. Evaluate if this assembly is a child assembly
                //--------------------------------------------------------------------------------------------
                boolean isChild = assembly.isChildAssembly(rootAssembly);

                if (assembly.isUsed) {
                    continue;
                }

                if (isChild) {

                    //---------------------------------------------------------------------------------------
                    //2. Update Assembly Valid Information
                    //---------------------------------------------------------------------------------------

                    //Update parent bomId
                    assembly.parentbomid = rootAssembly.bomId;

                    //Update assembly used
                    assembly.isUsed = true;

                    //Update level description
                    if (assembly.level > 0) {
                        assembly.descriptionLevel = ItemFrame.getApplicationBase().getTypeLevel(assembly.level).getDescription();
                    }

                    //Update Shape description
                    if (assembly.shapeID > 0) {
                        assembly.shapeAbbreviation = ItemFrame.getApplicationBase().getTypeShape(assembly.shapeID).getAbbrev();
                    }

                    //Update Sash description
                    if (assembly.sash > 0) {
                        if (assembly.remote) {
                            assembly.sashAbbreviation = ItemFrame.getApplicationRemoteBaseRules().
                                    getSeriesValidOpeningById(assembly.sash).getSeriesValidOpeningPK().getAbbreviation();
                        } else {
                            assembly.sashAbbreviation = ItemFrame.getApplicationBaseRules().getSeriesValidOpeningById(assembly.sash).
                                    getSeriesValidOpeningPK().getAbbreviation();
                        }
                    }

                    //-----------------------------------------------------------------
                    //4. Create assembly node
                    //-----------------------------------------------------------------
                    BomTreeTableNode assemblyNode = new BomTreeTableNode(assembly);

                    //-----------------------------------------------------------------
                    //5. Init child for assembly node
                    //-----------------------------------------------------------------
                    this.initchildNodes(assemblyNode);

                    //Search assembly parts for assembly node
                    List<BillOfMat> childAssemblies = new ArrayList<BillOfMat>();
                    for (BillOfMat childAssembly : assemblies) {

                        int partType = childAssembly.parttype;

                        if ((childAssembly.partid == childAssembly.assemblyid) && (partType == 12 || partType == 13)) {
                            childAssembly.assembly = true;

                            //Adding to collection of assemblies
                            childAssemblies.add(childAssembly);
                        }
                    }

                    //Recursive call with assembly parts
                    if (childAssemblies.size() > 0) {
                        assemblyNode = initAssemblyNodes(assemblyNode, childAssemblies);
                    }

                    rootNode.add(assemblyNode);
                }
            }

            //Adding Parts to Assembly root node
            rootNode.add(initAssemblyParts(rootNode));

            return rootNode;

        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(), e);
        }

        return rootNode;
    }

    /**
     * Init Assembly Parts for root node
     *
     * @param rootNode, BomTreeTableNode
     * @return BomTreeTableNode
     */
    private BomTreeTableNode initAssemblyParts(BomTreeTableNode rootNode) {

        //Get root assembly
        BillOfMat rootAssembly = rootNode.getBillOfMat();


//        for (BillOfMat billOfMat : this.myFrame.jobItem.bom) {
//
//            //Next one if bill of material was used
//            if (billOfMat.isUsed) {
//                continue;
//            }
//
//            //Getting part type
//            int partType = 0;
//
//            if (billOfMat.ruleno != -100) {
//                partType = billOfMat.parttype;
//            }
//
//            //Getting Production Line
//            ProductionLine prodLine = null;
//            if (billOfMat.remote) {
//                prodLine = ItemFrame.getApplicationRemoteBaseRules().getProductionLine(billOfMat.supplierRemoteId,
//                        billOfMat.prodline);
//            } else {
//                prodLine = ApplicationMainBaseApp.getInstance().getProductionLine(billOfMat.prodline);
//            }
//
//            if (prodLine == null) {
//                continue;
//            }
//
//            //Update level description
//            if (billOfMat.level > 0) {
//                billOfMat.descriptionLevel = ItemFrame.getApplicationBase().getTypeLevel(billOfMat.level).getDescription();
//            }
//
//            //Update Shape description
//            if (billOfMat.shapeID > 0) {
//                billOfMat.shapeAbbreviation = ItemFrame.getApplicationBase().getTypeShape(billOfMat.shapeID).getAbbrev();
//            }
//
//            //Update Sash description
//            if (billOfMat.sash > 0) {
//                if (billOfMat.remote) {
//                    billOfMat.sashAbbreviation = ItemFrame.getApplicationRemoteBaseRules().
//                            getSeriesValidOpeningById(billOfMat.sash).getSeriesValidOpeningPK().getAbbreviation();
//                } else {
//                    billOfMat.sashAbbreviation = ItemFrame.getApplicationBaseRules().getSeriesValidOpeningById(billOfMat.sash).
//                            getSeriesValidOpeningPK().getAbbreviation();
//                }
//            }
//
//            if ((billOfMat.parentAssembly > 0) && (partType != 12 && partType != 13) && !prodLine.getGlassLine()) {
//                if ((billOfMat.parentAssembly == rootAssembly.assemblyid) && !billOfMat.isUsed) {
//
//                    //Update parent bom Id
//                    billOfMat.parentbomid = rootAssembly.bomId;
//                    billOfMat.isUsed = true;
//
//                    BomTreeTableNode childNode = new BomTreeTableNode(billOfMat);
//                    rootNode.add(childNode);
//                }
//            }
//
//            if ((billOfMat.parentAssembly <= 0) && (partType != 12 && partType != 13) && !prodLine.getGlassLine()) {
//                if ((billOfMat.assemblyid == rootAssembly.assemblyid) && !billOfMat.isUsed) {
//
//                    //Update parent bom Id
//                    billOfMat.parentbomid = rootAssembly.bomId;
//                    billOfMat.isUsed = true;
//
//                    BomTreeTableNode childNode = new BomTreeTableNode(billOfMat);
//                    rootNode.add(childNode);
//                }
//            }
//        }

        //Init Glass Nodes
        initGlassNodes(rootNode);

        return rootNode;
    }

    /**
     * Init Assembly Parts missed for Assemblies
     *
     * @param rootNode, BomTreeTableNode
     * @return BomTreeTableNode
     */
    private BomTreeTableNode initAssemblyPartMissed(BomTreeTableNode rootNode) {

        //Get root assembly
        BillOfMat rootAssembly = rootNode.getBillOfMat();

        for (BillOfMat billOfMat : this.myFrame.jobItem.bom) {

            //Next one if bill of material was used
            if (billOfMat.isUsed) {
                continue;
            }

            //Next one if not belong to the same supplier rule
            if (rootAssembly.supplierRemoteId != billOfMat.supplierRemoteId) {
                continue;
            }

            //Update level description
            if (billOfMat.level > 0) {
                billOfMat.descriptionLevel = ItemFrame.getApplicationBase().getTypeLevel(billOfMat.level).getDescription();
            }

            //Update Shape description
            if (billOfMat.shapeID > 0) {
                billOfMat.shapeAbbreviation = ItemFrame.getApplicationBase().getTypeShape(billOfMat.shapeID).getAbbrev();
            }

            //Update Sash description
            if (billOfMat.sash > 0) {
                if (billOfMat.remote) {
                    billOfMat.sashAbbreviation = ItemFrame.getApplicationRemoteBaseRules().
                            getSeriesValidOpeningById(billOfMat.sash).getSeriesValidOpeningPK().getAbbreviation();
                } else {
                    billOfMat.sashAbbreviation = ItemFrame.getApplicationBaseRules().getSeriesValidOpeningById(billOfMat.sash).
                            getSeriesValidOpeningPK().getAbbreviation();
                }
            }

            //Update parent bom Id
            billOfMat.supplier_rule_no = rootAssembly.supplier_rule_no;
            billOfMat.parentbomid = rootAssembly.bomId;
            billOfMat.isUsed = true;
            billOfMat.isLostAssembly = true;

            BomTreeTableNode childNode = new BomTreeTableNode(billOfMat);
            rootNode.add(childNode);
        }

        return rootNode;
    }

    /**
     * This method init childs boms for Bill of Materials collections setting parent bom identification Id
     *
     * @param parentNode, BomTreeTableNode
     */
    private void initchildNodes(BomTreeTableNode parentNode) {

        try {

            BillOfMat parentAssembly = parentNode.getBillOfMat();

            List<BillOfMat> childs = new ArrayList<BillOfMat>();
            for (BillOfMat child : this.myFrame.jobItem.bom) {

                if (child.isUsed) {
                    continue;
                }

                /**
                 * Bill of Material should not be a part type assembly
                 */
                int partType = 0;
                if (child.ruleno != -100) {
                    partType = child.parttype;
                }

                //Setting assembly
                if (partType == 12 || partType == 13) {
                    continue;
                }

                /**
                 * Part should not be assembly
                 */
                if (child.assembly) {
                    continue;
                }

                /**
                 * AssemblyId & ParentAssembly should not to be equals
                 */
                if (child.assemblyid == child.partid) {
                    continue;
                }

                if (child.assemblyid == parentAssembly.assemblyid) {
                    childs.add(child);
                }
            }

            //Adding childs to parentNode
            Collections.sort(childs, BOMSorter.AssemblyID);
            for (BillOfMat child : childs) {

                //Get Production Line
                ProductionLine prodLine = null;
                if (child.remote) {
                    prodLine = ItemFrame.getApplicationRemoteBaseRules().getProductionLine(child.supplierRemoteId, child.prodline);
                } else {
                    prodLine = ApplicationMainBaseApp.getInstance().getProductionLine(child.prodline);
                }

                if (child.isChild(parentAssembly) && child.a_assemblyLevel != 6 && child.a_assemblyLevel != 8 &&
                        child.a_assemblyLevel != 29 && !child.isUsed && !prodLine.getGlassLine()) {

                    //Update Parent Bom Identification Id
                    child.parentbomid = parentAssembly.bomId;
                    child.isUsed = true;

                    //Update level description
                    if (child.level > 0) {
                        child.descriptionLevel = ItemFrame.getApplicationBase().getTypeLevel(child.level).getDescription();
                    }

                    //Update Shape description
                    if (child.shapeID > 0) {
                        child.shapeAbbreviation = ItemFrame.getApplicationBase().getTypeShape(child.shapeID).getAbbrev();
                    }

                    //Update Sash description
                    if (child.sash > 0) {
                        if (child.remote) {
                            child.sashAbbreviation = ItemFrame.getApplicationRemoteBaseRules().
                                    getSeriesValidOpeningById(child.sash).getSeriesValidOpeningPK().getAbbreviation();
                        } else {
                            child.sashAbbreviation = ItemFrame.getApplicationBaseRules().getSeriesValidOpeningById(child.sash).
                                    getSeriesValidOpeningPK().getAbbreviation();
                        }
                    }

                    BomTreeTableNode childNode = new BomTreeTableNode(child);
                    parentNode.add(childNode);
                }
            }

            //Init Glass Node
            initGlassNodes(parentNode);

        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * This method init Glass boms for Bill of Materials collections setting parent bom identification Id
     *
     * @param parentNode, BomTreeTableNode
     */
    private void initGlassNodes(BomTreeTableNode parentNode) {

        try {

            BillOfMat parentAssembly = parentNode.getBillOfMat();

            for (DesignGlass glass : this.myFrame.jobItem.glassBOM) {

                //********************************************
                //Creating Bill of Material for Glass Bom
                //********************************************
                BillOfMat billOfMat = new BillOfMat();

                billOfMat.a_levelID = glass.a_levelID;
                billOfMat.a_sequenceID = glass.a_sequenceID;
                billOfMat.a_assemblyLevel = glass.a_assemblyLevel;

                billOfMat.a_1Level = glass.a_1Level;
                billOfMat.a_2Level = glass.a_2Level;
                billOfMat.a_3Level = glass.a_3Level;
                billOfMat.a_4Level = glass.a_4Level;
                billOfMat.a_5Level = glass.a_5Level;
                billOfMat.a_6Level = glass.a_6Level;
                billOfMat.a_7Level = glass.a_7Level;
                billOfMat.a_8Level = glass.a_8Level;
                billOfMat.a_9Level = glass.a_9Level;
                billOfMat.a_10Level = glass.a_10Level;
                billOfMat.a_11Level = glass.a_11Level;
                billOfMat.a_12Level = glass.a_12Level;
                billOfMat.a_13Level = glass.a_13Level;
                billOfMat.a_14Level = glass.a_14Level;
                billOfMat.a_15Level = glass.a_15Level;
                billOfMat.a_16Level = glass.a_16Level;
                billOfMat.a_17Level = glass.a_17Level;
                billOfMat.a_18Level = glass.a_18Level;
                billOfMat.a_19Level = glass.a_19Level;
                billOfMat.a_20Level = glass.a_20Level;
                billOfMat.a_21Level = glass.a_21Level;
                billOfMat.a_22Level = glass.a_22Level;

                billOfMat.a_1Sequence = glass.a_1Sequence;
                billOfMat.a_2Sequence = glass.a_2Sequence;
                billOfMat.a_3Sequence = glass.a_3Sequence;
                billOfMat.a_4Sequence = glass.a_4Sequence;
                billOfMat.a_5Sequence = glass.a_5Sequence;
                billOfMat.a_6Sequence = glass.a_6Sequence;
                billOfMat.a_7Sequence = glass.a_7Sequence;
                billOfMat.a_8Sequence = glass.a_8Sequence;
                billOfMat.a_9Sequence = glass.a_9Sequence;
                billOfMat.a_10Sequence = glass.a_10Sequence;
                billOfMat.a_11Sequence = glass.a_11Sequence;
                billOfMat.a_12Sequence = glass.a_12Sequence;
                billOfMat.a_13Sequence = glass.a_13Sequence;
                billOfMat.a_14Sequence = glass.a_14Sequence;
                billOfMat.a_15Sequence = glass.a_15Sequence;
                billOfMat.a_16Sequence = glass.a_16Sequence;
                billOfMat.a_17Sequence = glass.a_17Sequence;
                billOfMat.a_18Sequence = glass.a_18Sequence;
                billOfMat.a_19Sequence = glass.a_19Sequence;
                billOfMat.a_20Sequence = glass.a_20Sequence;
                billOfMat.a_21Sequence = glass.a_21Sequence;
                billOfMat.a_22Sequence = glass.a_22Sequence;

                billOfMat.ruleno = -100; //This rule number means is a glass BOM.
                billOfMat.partid = glass.suID;
                billOfMat.level = glass.a_levelID;
                billOfMat.parentAssembly = -1;
                billOfMat.leafNo = glass.leafNo;
                billOfMat.stockcode = glass.stockCode;
                billOfMat.stockcodeUser = glass.stockCode;
                billOfMat.description = glass.description;
                billOfMat.descriptionuser = glass.description;
                billOfMat.buy = glass.madeIn;

                String _sequence = Integer.toString(glass.a_sequenceID);
                int _row = Integer.parseInt(String.valueOf(_sequence.charAt(0)));
                int _col = Integer.parseInt(String.valueOf(_sequence.charAt(1)));

                billOfMat.row = _row; //Return row value from sequence
                billOfMat.col = _col; //Return col value from sequence
                billOfMat.width = glass.widthM;
                billOfMat.widthi = glass.widthI;
                billOfMat.widthuser = glass.widthM;
                billOfMat.widthiuser = glass.widthI;
                billOfMat.height = glass.heightM;
                billOfMat.heighti = glass.heightI;
                billOfMat.heightuser = glass.heightM;
                billOfMat.heightiuser = glass.heightI;

                billOfMat.shapeObject = glass.shapeObject;

                //********************************************
                //Calculate Area for Glass
                //********************************************
                BigDecimal width = new BigDecimal(billOfMat.width + "").divide(new BigDecimal("64"), 6).
                        divide(new BigDecimal("12"), 6);
                BigDecimal height = new BigDecimal(billOfMat.height + "").divide(new BigDecimal("64"), 6).
                        divide(new BigDecimal("12"), 6);
                BigDecimal area = width.multiply(height).setScale(6);

                BigDecimal widthI = new BigDecimal(billOfMat.widthi + "").divide(new BigDecimal("64"), 6).
                        divide(new BigDecimal("12"), 6);
                BigDecimal heightI = new BigDecimal(billOfMat.heighti + "").divide(new BigDecimal("64"), 6).
                        divide(new BigDecimal("12"), 6);
                BigDecimal areaI = widthI.multiply(heightI).setScale(6);

                billOfMat.areauser = area.doubleValue();
                billOfMat.areaiuser = areaI.doubleValue();

                billOfMat.cost = glass.cost;
                billOfMat.totalcost = glass.cost;
                billOfMat.price = glass.price;
                billOfMat.priceuser = glass.priceUser;
                billOfMat.totalprice = glass.price;
                billOfMat.totalpriceuser = glass.priceUser;
                billOfMat.openingid = parentAssembly.openingid;
                billOfMat.sash = parentAssembly.sash;

                billOfMat.prodline = glass.prodline;
                billOfMat.station = 0;
                billOfMat.report = glass.report;
                billOfMat.delivery = glass.delivery;
                billOfMat.reqforstage = glass.reqforstage;
                billOfMat.shapeID = glass.shapeID;
                billOfMat.assemblyid = glass.assemblyID;
                billOfMat.leadtime = glass.leadTime;
                billOfMat.buy = glass.madeIn ? false : true;
                billOfMat.qty = 1;
                billOfMat.qtyuser = 1;
                billOfMat.partFamily = glass.partFamily;

                billOfMat.supplierRemoteId = glass.supplierRemoteId;
                billOfMat.supplierSeriesId = glass.seriesSupplierId;
                billOfMat.remote = glass.remote;

                //Update level description
                if (billOfMat.level > 0) {
                    billOfMat.descriptionLevel = ItemFrame.getApplicationBase().getTypeLevel(billOfMat.level).getDescription();
                }

                //Update Shape description
                if (billOfMat.shapeID > 0) {
                    billOfMat.shapeAbbreviation = ItemFrame.getApplicationBase().getTypeShape(billOfMat.shapeID).getAbbrev();
                }

                //Update Sash description
                if (billOfMat.sash > 0) {
                    if (billOfMat.remote) {
                        billOfMat.sashAbbreviation = ItemFrame.getApplicationRemoteBaseRules().
                                getSeriesValidOpeningById(billOfMat.sash).getSeriesValidOpeningPK().getAbbreviation();
                    } else {
                        billOfMat.sashAbbreviation = ItemFrame.getApplicationBaseRules().getSeriesValidOpeningById(billOfMat.sash).
                                getSeriesValidOpeningPK().getAbbreviation();
                    }
                }

                //Update If this is an Assembly
                if (billOfMat.assemblyid > 0) {
                    billOfMat.assembly = true;
                }

                if (billOfMat.isChildGlass(parentAssembly) && !glass.isUsed) {

                    //Update glass bomID
                    glass.glassBomID = this.glassID++;
                    glass.isUsed = true;

                    billOfMat.parentAssembly = parentAssembly.assemblyid;
                    billOfMat.bomId = this.bomID++;
                    billOfMat.parentbomid = parentAssembly.bomId;
                    billOfMat.glassBomid = glass.glassBomID;
                    billOfMat.isUsed = true;

                    //Evaluate series valid opening shape
                    if (parentAssembly.supplier_rule_no == -300) {
                        billOfMat.supplier_rule_no = -300; //Update Supplier Rule Number
                        billOfMat.supplier_part_id = parentAssembly.supplier_part_id;
                        billOfMat.buy = !parentAssembly.glass_made_in;
                        billOfMat.bought_glazed = parentAssembly.bought_glazed;
                    }

                    //Adding Glass SU Bom to collection of boms
                    this.myFrame.jobItem.bom.add(billOfMat);

                    //Create Tree Table Node for Glass
                    BomTreeTableNode glassNode = new BomTreeTableNode(billOfMat);

                    if (billOfMat.assembly) {

                        //Search parts for boms
                        initGlassBomNodes(glassNode);

                        //Update design glass production line & station
                        glass.prodline = glassNode.getBillOfMat().prodline;
                        glass.station = glassNode.getBillOfMat().station;

                        //Setting Production Station to default part family
                        int station = ApplicationBaseApp.getInstance().getPartFamilyStation(glass.partFamily);
                        if (station > 0) {
                            glass.station = station;
                        }

                        //Create Glass SU components parts
                        initGlassChildNodes(glassNode, glass);

                        //Create Grids components parts
                        initGridsBomNodes(glassNode);
                    }

                    //Adding Glass SU Node to parent
                    parentNode.add(glassNode);
                }
            }

        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * This method init Child Glass boms for Bill of Materials Collections
     *
     * @param parentNode,  BomTreeTableNode
     * @param designGlass, Design Glass for bill of materials
     */
    private void initGlassChildNodes(BomTreeTableNode parentNode, DesignGlass designGlass) {

        try {

            //Return Bill of Material
            BillOfMat parentBOM = parentNode.getBillOfMat();

            //Get Glass Seal Unit for this design
            GlassSU glassSU = this.myFrame.jobItem.design.getGlassSU(designGlass);

            if (designGlass.leaf1 > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.leaf1, true);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.leaf2 > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.leaf2, true);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.leaf3 > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.leaf3, true);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.leaf4 > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.leaf4, true);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.film1 > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.film1, false);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.film2 > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.film2, false);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.film3 > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.film3, false);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.film4 > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.film4, false);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.glass1 > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.glass1, false);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.glass1Process2 > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.glass1Process2, false);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.glass1Process3 > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.glass1Process3, false);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.glass2 > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.glass2, false);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.glass2Process2 > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.glass2Process2, false);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.glass2Process3 > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.glass2Process3, false);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.glass3 > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.glass3, false);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.glass3Process2 > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.glass3Process2, false);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.glass3Process3 > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.glass3Process3, false);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.glass4 > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.glass4, false);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.glass4Process2 > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.glass4Process2, false);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.glass4Process3 > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.glass4Process3, false);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.gas1 > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.gas1, false);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.gas2 > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.gas2, false);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.gas3 > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.gas3, false);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.process1 > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.process1, false);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.process2 > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.process2, false);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.process3 > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.process3, false);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.process4 > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.process4, false);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.insert1Id > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.insert1Id, false);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.insert2Id > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.insert2Id, false);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }

            if (designGlass.insert3Id > 0) {
                List<BillOfMat> boms = createGlassSUComponents(parentBOM, glassSU, designGlass, designGlass.insert3Id, false);
                this.myFrame.jobItem.bom.addAll(boms);

                for (BillOfMat glassBom : boms) {
                    BomTreeTableNode glassChildNode = new BomTreeTableNode(glassBom);
                    parentNode.add(glassChildNode);
                }
            }


        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * This method search Child Glass boms for Bill of Materials
     *
     * @param parentNode, BomTreeTableNode
     */
    private void initGlassBomNodes(BomTreeTableNode parentNode) {

        try {

            BillOfMat billOfMat = parentNode.getBillOfMat();

            for (BillOfMat bom : this.myFrame.jobItem.bom) {

                //Get Production Line
                ProductionLine prodLine = null;
                if (bom.remote) {
                    prodLine = ItemFrame.getApplicationRemoteBaseRules().getProductionLine(bom.supplierRemoteId, bom.prodline);
                } else {
                    prodLine = ApplicationMainBaseApp.getInstance().getProductionLine(bom.prodline);
                }

                if (prodLine != null && bom.a_assemblyLevel == 6) {

                    if (bom.isChildGlassBom(billOfMat) && !bom.isUsed) {

                        //Update Assembly parent glass for production line & station
                        billOfMat.prodline = bom.prodline;
                        billOfMat.station = bom.station;

                        //Update Parent Assembly for Child
                        bom.parentbomid = billOfMat.bomId;
                        bom.isUsed = true;

                        //Update level description
                        if (bom.level > 0) {
                            bom.descriptionLevel = this.myFrame.jobItem.myParent.getApplicationBase().
                                    getTypeLevel(bom.level).getDescription();
                        }

                        //Update Shape description
                        if (bom.shapeID > 0) {
                            bom.shapeAbbreviation = this.myFrame.jobItem.myParent.getApplicationBase().
                                    getTypeShape(bom.shapeID).getAbbrev();
                        }

                        //Update Sash description
                        if (bom.sash > 0) {
                            if (bom.remote) {
                                bom.sashAbbreviation = ItemFrame.getApplicationRemoteBaseRules().
                                        getSeriesValidOpeningById(bom.sash).getSeriesValidOpeningPK().getAbbreviation();
                            } else {
                                bom.sashAbbreviation = ItemFrame.getApplicationBaseRules().getSeriesValidOpeningById(bom.sash).
                                        getSeriesValidOpeningPK().getAbbreviation();
                            }
                        }

                        //Evaluate series valid opening shape
                        bom.supplier_rule_no = billOfMat.supplier_rule_no;
                        bom.supplier_part_id = billOfMat.supplier_part_id;
                        bom.buy = !billOfMat.glass_made_in;
                        bom.bought_glazed = billOfMat.bought_glazed;

                        //Adding child node to parent  Sealed Unit
                        BomTreeTableNode childNode = new BomTreeTableNode(bom);
                        parentNode.add(childNode);
                    }
                }
            }

        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * This method init Child Grids boms for Bill of Materials Collections
     *
     * @param parentGlassNode, BomTreeTableNode
     */
    private void initGridsBomNodes(BomTreeTableNode parentGlassNode) {

        try {

            //*****************************************************************************
            //Get Bill Of Material Parent Node
            //*****************************************************************************
            BillOfMat glassBom = parentGlassNode.getBillOfMat();

            //*****************************************************************************
            //Declare Grids Bom Assembly
            //*****************************************************************************

            //Grids Assembly
            BomTreeTableNode gridsAssemblyNode = null;

            //Grids Assembly Bill of Material
            BillOfMat gridsBomAssembly = null;

            for (BillOfMat bom : this.myFrame.jobItem.bom) {

                //-------------------------------------------
                //Evaluate only bom not used
                //-------------------------------------------
                if (bom.isUsed) {
                    continue;
                }

                //-------------------------------------------
                //Evaluate only bom for grids profiles
                //-------------------------------------------
                if ((bom.a_assemblyLevel != 29 && bom.a_assemblyLevel != 8) && (bom.a_levelID != 9 && bom.a_levelID != 22)) {
                    continue;
                }

                //-------------------------------------------
                //Init Grids Assembly
                //-------------------------------------------
                if (gridsBomAssembly == null) {

                    if (bom.isChildGlass(glassBom) && this.myFrame.jobItem.gridType > 0) {

                        //Create Grids Bom Assembly
                        gridsBomAssembly = createBomGridsAssembly(glassBom, bom);

                        //Create Grids Tree Node Assembly
                        gridsAssemblyNode = new BomTreeTableNode(gridsBomAssembly);

                        //Add Grids Assembly Node to parent
                        parentGlassNode.add(gridsAssemblyNode);
                    }
                }

                if (gridsBomAssembly != null && bom.isChildGlass(glassBom)) {

                    //Init Bom Identification Id
                    bom.bomId = this.bomID++;

                    //Update Assembly parent glass for production line & station
                    gridsBomAssembly.station = bom.station;

                    //Update Parent Assembly for Child
                    bom.prodline = gridsBomAssembly.prodline;
                    bom.parentbomid = gridsBomAssembly.bomId;
                    bom.isUsed = true;

                    //Update level description
                    if (bom.level > 0) {
                        bom.descriptionLevel = this.myFrame.jobItem.myParent.getApplicationBase().
                                getTypeLevel(bom.level).getDescription();
                    }

                    //Update Shape description
                    if (bom.shapeID > 0) {
                        bom.shapeAbbreviation = this.myFrame.jobItem.myParent.getApplicationBase().
                                getTypeShape(bom.shapeID).getAbbrev();
                    }

                    //Update Sash description
                    if (bom.sash > 0) {
                        if (bom.remote) {
                            bom.sashAbbreviation = ItemFrame.getApplicationRemoteBaseRules().
                                    getSeriesValidOpeningById(bom.sash).getSeriesValidOpeningPK().getAbbreviation();
                        } else {
                            bom.sashAbbreviation = ItemFrame.getApplicationBaseRules().getSeriesValidOpeningById(bom.sash).
                                    getSeriesValidOpeningPK().getAbbreviation();
                        }
                    }

                    //Evaluate series valid opening shape
                    bom.supplier_rule_no = gridsBomAssembly.supplier_rule_no;
                    bom.supplier_part_id = gridsBomAssembly.supplier_part_id;
                    bom.buy = !gridsBomAssembly.glass_made_in;
                    bom.bought_glazed = gridsBomAssembly.bought_glazed;

                    //Adding child node to parent  Sealed Unit
                    BomTreeTableNode childNode = new BomTreeTableNode(bom);
                    gridsAssemblyNode.add(childNode);
                }
            }

            //---------------------------------------------------------
            // Update Bill Of Material with Grids Assembly
            //---------------------------------------------------------
            if (gridsBomAssembly != null) {
                this.myFrame.jobItem.bom.add(gridsBomAssembly);
            }

        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(), e);
        }

        //Grids of Materials
//        List<BillOfMat> gridsBom = new ArrayList<BillOfMat>();
//
//        for (DesignGrid designGrid : this.myFrame.jobItem.gridsBOM) {
//
//            if (designGrid.isChildGlass(glassBom) && !designGrid.isUsed()) {
//
//                //Create Bom Grids Assembly
//                if (gridsBomAssembly == null) {
//                    gridsBomAssembly = createBomGridsAssembly(glassBom, designGrid);
//                }
//
//                //Setting Design Grid Used
//                designGrid.setUsed(true);
//
//                //Create Bill Of Material BOM
//                BillOfMat gridBom = createBomGrids(gridsBomAssembly, designGrid);
//
//                //Adding to collection of BOM
//                gridsBom.add(gridBom);
//            }
//        }

//        if (gridsBom.size() > 0) {
//
//            //Create Grid Bom Assembly
//            BomTreeTableNode gridsAssemblyNode = new BomTreeTableNode(gridsBomAssembly);
//
//            //Adding Assembly Grids Node to Bom Collection
//            this.myFrame.jobItem.bom.add(gridsBomAssembly);
//
//            //Create Grids Childs
//            for (BillOfMat gridBom : gridsBom) {
//
//                //Create Grid Bom Part
//                BomTreeTableNode gridBomPart = new BomTreeTableNode(gridBom);
//
//                //Add Grid Part Bom to collection
//                this.myFrame.jobItem.bom.add(gridBom);
//
//                //Add Grid Bom to assembly
//                gridsAssemblyNode.add(gridBomPart);
//            }
//
//            //Adding Grid Assembly Node to Parent Glass
//            parentGlassNode.add(gridsAssemblyNode);
//        }
    }

    /**
     * Construct a Bill of Material
     *
     * @param designGlass, DesignGlass
     * @param suID,        Integer
     * @param isSUtype,    Is a Seal Unit
     * @return BillOfMat
     */
    private List<BillOfMat> createGlassSUComponents(BillOfMat parentBOM, GlassSU glassSU, DesignGlass designGlass,
                                                    Integer suID, boolean isSUtype) {

        try {

            //Collection of Boms Glass components
            List<BillOfMat> glassSUComponents = new ArrayList<BillOfMat>();

            //Get Seal Unit Type
            SUType suType = null;
            Parts parts = null;

            if (isSUtype) {
                if (glassSU.remote) {
                    suType = ItemFrame.getApplicationRemoteBaseRules().getSUType(glassSU.supplierId, suID);
                } else {
                    suType = ItemFrame.getApplicationBaseRules().getSUType(suID);
                }
            } else {
                if (glassSU.remote) {
                    parts = ItemFrame.getApplicationRemoteBaseRules().getPart(glassSU.supplierId, suID);
                } else {
                    parts = ItemFrame.getApplicationBaseRules().getPart(suID);
                }
            }

            SystemUOM systemUOM = ApplicationBaseApp.getInstance().getSystemUOM(this.myFrame.currentUOM);

            //1, - unit - insert      unit cost from part.
            //2, 15 - perfil - spacer  ( 4 piezas)
            // 3, 16, 17 - area - process, glass, film
            // 4,,18 - roll - spacer, sealent    W+h+w+h  perimetro
            // 14, - volume - gas     area x airspace
            BigDecimal glassCost = new BigDecimal("0");

            if (parts != null) {

                if (parts.getParttype() == 1) {
                    glassCost = parts.getCost();

                    glassSUComponents.add(createBomGlassSU(parentBOM, designGlass, parts.getId(), parts.getStockcode(),
                            parts.getDescription(), glassCost, parts.isGenstock()));
                }

                if (parts.getParttype() == 2 || parts.getParttype() == 15) {
                    if (glassSU.top1Part.posInUse) {
                        if (systemUOM.getId() == Metrics.METRIC.getValue()) {
                            glassCost = new BigDecimal(glassSU.top1Part.length + "").
                                    divide(new BigDecimal("100"), 6).divide(new BigDecimal("1000"), 6).
                                    multiply(parts.getCost());
                            glassSUComponents.add(createBomGlassSU(parentBOM, designGlass, parts.getId(), parts.getStockcode(),
                                    parts.getDescription(), glassCost, parts.isGenstock()));
                        } else {
                            glassCost = new BigDecimal(glassSU.top1Part.lengthI + "").
                                    divide(new BigDecimal("64"), 6).divide(new BigDecimal("12"), 6).
                                    multiply(parts.getCost());
                            glassSUComponents.add(createBomGlassSU(parentBOM, designGlass, parts.getId(), parts.getStockcode(),
                                    parts.getDescription(), glassCost, parts.isGenstock()));
                        }
                    }

                    if (glassSU.top2Part.posInUse) {
                        if (systemUOM.getId() == Metrics.METRIC.getValue()) {
                            glassCost = new BigDecimal(glassSU.top2Part.length + "").
                                    divide(new BigDecimal("100"), 6).divide(new BigDecimal("1000"), 6).
                                    multiply(parts.getCost());
                            glassSUComponents.add(createBomGlassSU(parentBOM, designGlass, parts.getId(), parts.getStockcode(),
                                    parts.getDescription(), glassCost, parts.isGenstock()));
                        } else {
                            glassCost = new BigDecimal(glassSU.top2Part.lengthI + "").
                                    divide(new BigDecimal("64"), 6).divide(new BigDecimal("12"), 6).
                                    multiply(parts.getCost());
                            glassSUComponents.add(createBomGlassSU(parentBOM, designGlass, parts.getId(), parts.getStockcode(),
                                    parts.getDescription(), glassCost, parts.isGenstock()));
                        }
                    }

                    if (glassSU.top3Part.posInUse) {
                        if (systemUOM.getId() == Metrics.METRIC.getValue()) {
                            glassCost = new BigDecimal(glassSU.top3Part.length + "").
                                    divide(new BigDecimal("100"), 6).divide(new BigDecimal("1000"), 6).
                                    multiply(parts.getCost());
                            glassSUComponents.add(createBomGlassSU(parentBOM, designGlass, parts.getId(), parts.getStockcode(),
                                    parts.getDescription(), glassCost, parts.isGenstock()));
                        } else {
                            glassCost = new BigDecimal(glassSU.top3Part.lengthI + "").
                                    divide(new BigDecimal("64"), 6).divide(new BigDecimal("12"), 6).
                                    multiply(parts.getCost());
                            glassSUComponents.add(createBomGlassSU(parentBOM, designGlass, parts.getId(), parts.getStockcode(),
                                    parts.getDescription(), glassCost, parts.isGenstock()));
                        }
                    }

                    if (glassSU.bot1Part.posInUse) {
                        if (systemUOM.getId() == Metrics.METRIC.getValue()) {
                            glassCost = new BigDecimal(glassSU.bot1Part.length + "").
                                    divide(new BigDecimal("100"), 6).divide(new BigDecimal("1000"), 6).
                                    multiply(parts.getCost());
                            glassSUComponents.add(createBomGlassSU(parentBOM, designGlass, parts.getId(), parts.getStockcode(),
                                    parts.getDescription(), glassCost, parts.isGenstock()));
                        } else {
                            glassCost = new BigDecimal(glassSU.bot1Part.lengthI + "").
                                    divide(new BigDecimal("64"), 6).divide(new BigDecimal("12"), 6).
                                    multiply(parts.getCost());
                            glassSUComponents.add(createBomGlassSU(parentBOM, designGlass, parts.getId(), parts.getStockcode(),
                                    parts.getDescription(), glassCost, parts.isGenstock()));
                        }
                    }

                    if (glassSU.bot2Part.posInUse) {
                        if (systemUOM.getId() == Metrics.METRIC.getValue()) {
                            glassCost = new BigDecimal(glassSU.bot2Part.length + "").
                                    divide(new BigDecimal("100"), 6).divide(new BigDecimal("1000"), 6).
                                    multiply(parts.getCost());
                            glassSUComponents.add(createBomGlassSU(parentBOM, designGlass, parts.getId(), parts.getStockcode(),
                                    parts.getDescription(), glassCost, parts.isGenstock()));
                        } else {
                            glassCost = new BigDecimal(glassSU.bot2Part.lengthI + "").
                                    divide(new BigDecimal("64"), 6).divide(new BigDecimal("12"), 6).
                                    multiply(parts.getCost());
                            glassSUComponents.add(createBomGlassSU(parentBOM, designGlass, parts.getId(), parts.getStockcode(),
                                    parts.getDescription(), glassCost, parts.isGenstock()));
                        }
                    }

                    if (glassSU.bot3Part.posInUse) {
                        if (systemUOM.getId() == Metrics.METRIC.getValue()) {
                            glassCost = new BigDecimal(glassSU.bot3Part.length + "").
                                    divide(new BigDecimal("100"), 6).divide(new BigDecimal("1000"), 6).
                                    multiply(parts.getCost());
                            glassSUComponents.add(createBomGlassSU(parentBOM, designGlass, parts.getId(), parts.getStockcode(),
                                    parts.getDescription(), glassCost, parts.isGenstock()));
                        } else {
                            glassCost = new BigDecimal(glassSU.bot3Part.lengthI + "").
                                    divide(new BigDecimal("64"), 6).divide(new BigDecimal("12"), 6).
                                    multiply(parts.getCost());
                            glassSUComponents.add(createBomGlassSU(parentBOM, designGlass, parts.getId(), parts.getStockcode(),
                                    parts.getDescription(), glassCost, parts.isGenstock()));
                        }
                    }

                    if (glassSU.leftPart.posInUse) {
                        if (systemUOM.getId() == Metrics.METRIC.getValue()) {
                            glassCost = new BigDecimal(glassSU.leftPart.length + "").
                                    divide(new BigDecimal("100"), 6).divide(new BigDecimal("1000"), 6).
                                    multiply(parts.getCost());
                            glassSUComponents.add(createBomGlassSU(parentBOM, designGlass, parts.getId(), parts.getStockcode(),
                                    parts.getDescription(), glassCost, parts.isGenstock()));
                        } else {
                            glassCost = new BigDecimal(glassSU.leftPart.lengthI + "").
                                    divide(new BigDecimal("64"), 6).divide(new BigDecimal("12"), 6).
                                    multiply(parts.getCost());
                            glassSUComponents.add(createBomGlassSU(parentBOM, designGlass, parts.getId(), parts.getStockcode(),
                                    parts.getDescription(), glassCost, parts.isGenstock()));
                        }
                    }

                    if (glassSU.rightPart.posInUse) {
                        if (systemUOM.getId() == Metrics.METRIC.getValue()) {
                            glassCost = new BigDecimal(glassSU.rightPart.length + "").
                                    divide(new BigDecimal("100"), 6).divide(new BigDecimal("1000"), 6).
                                    multiply(parts.getCost());
                            glassSUComponents.add(createBomGlassSU(parentBOM, designGlass, parts.getId(), parts.getStockcode(),
                                    parts.getDescription(), glassCost, parts.isGenstock()));
                        } else {
                            glassCost = new BigDecimal(glassSU.rightPart.lengthI + "").
                                    divide(new BigDecimal("64"), 6).divide(new BigDecimal("12"), 6).
                                    multiply(parts.getCost());
                            glassSUComponents.add(createBomGlassSU(parentBOM, designGlass, parts.getId(), parts.getStockcode(),
                                    parts.getDescription(), glassCost, parts.isGenstock()));
                        }
                    }
                }

                if (parts.getParttype() == 3 || parts.getParttype() == 16 || parts.getParttype() == 17) {
                    if (systemUOM.getId() == Metrics.METRIC.getValue()) {
                        BigDecimal width = new BigDecimal(glassSU.widthM + "").
                                divide(new BigDecimal("100"), 6).divide(new BigDecimal("1000"), 6);
                        BigDecimal height = new BigDecimal(glassSU.heightM + "").
                                divide(new BigDecimal("100"), 6).divide(new BigDecimal("1000"), 6);
                        BigDecimal area = width.multiply(height).setScale(6);

                        glassCost = area.multiply(parts.getCost());
                        glassSUComponents.add(createBomGlassSU(parentBOM, designGlass, parts.getId(), parts.getStockcode(),
                                parts.getDescription(), glassCost, parts.isGenstock()));
                    } else {
                        BigDecimal width = new BigDecimal(glassSU.widthI + "").
                                divide(new BigDecimal("64"), 6).divide(new BigDecimal("12"), 6);
                        BigDecimal height = new BigDecimal(glassSU.heightI + "").
                                divide(new BigDecimal("64"), 6).divide(new BigDecimal("12"), 6);
                        BigDecimal area = width.multiply(height).setScale(6);

                        glassCost = area.multiply(parts.getCost());
                        glassSUComponents.add(createBomGlassSU(parentBOM, designGlass, parts.getId(), parts.getStockcode(),
                                parts.getDescription(), glassCost, parts.isGenstock()));
                    }
                }

                if (parts.getParttype() == 4 || parts.getParttype() == 18) {

                    if (systemUOM.getId() == Metrics.METRIC.getValue()) {
                        int perimeter = glassSU.top1Part.lengthM +
                                (glassSU.top2Part.posInUse ? glassSU.top2Part.lengthM : 0) +
                                (glassSU.top3Part.posInUse ? glassSU.top3Part.lengthM : 0) +
                                (glassSU.bot1Part.posInUse ? glassSU.bot1Part.lengthM : 0) +
                                (glassSU.bot2Part.posInUse ? glassSU.bot2Part.lengthM : 0) +
                                (glassSU.bot3Part.posInUse ? glassSU.bot3Part.lengthM : 0) +
                                (glassSU.leftPart.posInUse ? glassSU.leftPart.lengthM : 0) +
                                (glassSU.rightPart.posInUse ? glassSU.rightPart.lengthM : 0);

                        glassCost = new BigDecimal(perimeter + "").divide(new BigDecimal("100"), 6).
                                divide(new BigDecimal("1000"), 6).multiply(parts.getCost());

                        glassSUComponents.add(createBomGlassSU(parentBOM, designGlass, parts.getId(), parts.getStockcode(),
                                parts.getDescription(), glassCost, parts.isGenstock()));
                    } else {

                        int perimeter = glassSU.top1Part.lengthI +
                                (glassSU.top2Part.posInUse ? glassSU.top2Part.lengthI : 0) +
                                (glassSU.top3Part.posInUse ? glassSU.top3Part.lengthI : 0) +
                                (glassSU.bot1Part.posInUse ? glassSU.bot1Part.lengthI : 0) +
                                (glassSU.bot2Part.posInUse ? glassSU.bot2Part.lengthI : 0) +
                                (glassSU.bot3Part.posInUse ? glassSU.bot3Part.lengthI : 0) +
                                (glassSU.leftPart.posInUse ? glassSU.leftPart.lengthI : 0) +
                                (glassSU.rightPart.posInUse ? glassSU.rightPart.lengthI : 0);

                        glassCost = new BigDecimal(perimeter + "").divide(new BigDecimal("64"), 6).
                                divide(new BigDecimal("12"), 6).multiply(parts.getCost());

                        glassSUComponents.add(createBomGlassSU(parentBOM, designGlass, parts.getId(), parts.getStockcode(),
                                parts.getDescription(), glassCost, parts.isGenstock()));
                    }
                }

                if (parts.getParttype() == 14) {

                    if (systemUOM.getId() == Metrics.METRIC.getValue()) {
                        BigDecimal airspace = new BigDecimal(glassSU.airSpace1 + "").add(
                                new BigDecimal(glassSU.airSpace2 + "")).add(new BigDecimal(glassSU.airSpace3 + ""));
                        airspace = airspace.divide(new BigDecimal("100"), 6).divide(new BigDecimal("1000"), 6);

                        BigDecimal width = new BigDecimal(glassSU.widthM + "").
                                divide(new BigDecimal("100"), 6).divide(new BigDecimal("1000"), 6);
                        BigDecimal height = new BigDecimal(glassSU.heightM + "").divide(new BigDecimal("100"), 6).
                                divide(new BigDecimal("1000"), 6);
                        BigDecimal area = width.multiply(height).setScale(6);

                        BigDecimal volume = airspace.multiply(area);

                        glassCost = volume.multiply(parts.getCost());

                        glassSUComponents.add(createBomGlassSU(parentBOM, designGlass, parts.getId(), parts.getStockcode(),
                                parts.getDescription(), glassCost, parts.isGenstock()));
                    } else {
                        BigDecimal airspace = new BigDecimal(glassSU.airSpace1i + "").add(
                                new BigDecimal(glassSU.airSpace2i + "")).add(new BigDecimal(glassSU.airSpace3i + ""));
                        airspace = airspace.divide(new BigDecimal("64"), 6).divide(new BigDecimal("12"), 6);

                        BigDecimal width = new BigDecimal(glassSU.widthI + "").divide(new BigDecimal("64"), 6).
                                divide(new BigDecimal("12"), 6);
                        BigDecimal height = new BigDecimal(glassSU.heightI + "").divide(new BigDecimal("64"), 6).
                                divide(new BigDecimal("12"), 6);
                        BigDecimal area = width.multiply(height).setScale(6);

                        BigDecimal volume = airspace.multiply(area);

                        glassCost = volume.multiply(parts.getCost());

                        glassSUComponents.add(createBomGlassSU(parentBOM, designGlass, parts.getId(), parts.getStockcode(),
                                parts.getDescription(), glassCost, parts.isGenstock()));
                    }
                }

            } else {

                //*********************************************************************
                // Calculate Glass SU Cost
                //*********************************************************************
                GlassSU glassSUType = new GlassSU();
                glassSUType.cloneSUType(suType);

                glassCost = glassCalculationController.calculateCost(glassSUType, systemUOM, new BigDecimal("0"),
                        suType != null ? suType.getCost() : parts.getCost(), suType != null ? suType.getWaste() :
                        parts.getWaste());

                glassSUComponents.add(createBomGlassSU(parentBOM, designGlass, suType.getId(), suType.getStockCode(),
                        suType.getDescription(), glassCost, glassSUType.madeIn));
            }

            return glassSUComponents;

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }

    /**
     * Create BOM Glass SU
     *
     * @param parentBOM,   BillOfMat
     * @param designGlass, Design Glass BOM
     * @param partID,      Part Code Identification Id
     * @param stockCode,   Stock Code
     * @param description, Description
     * @param cost,        cost
     * @param madeIn,      madeIn
     * @return BillOfMat
     */
    private BillOfMat createBomGlassSU(BillOfMat parentBOM, DesignGlass designGlass, Integer partID, String stockCode,
                                       String description, BigDecimal cost, boolean madeIn) {

        //*********************************************************************
        // Create Bill of Material from SUType
        //*********************************************************************

        BillOfMat billOfMat = new BillOfMat();
        billOfMat.a_levelID = designGlass.a_levelID;
        billOfMat.a_sequenceID = designGlass.a_sequenceID;
        billOfMat.a_assemblyLevel = designGlass.a_assemblyLevel;
        billOfMat.a_1Level = designGlass.a_1Level;
        billOfMat.a_2Level = designGlass.a_2Level;
        billOfMat.a_3Level = designGlass.a_3Level;
        billOfMat.a_4Level = designGlass.a_4Level;
        billOfMat.a_5Level = designGlass.a_5Level;
        billOfMat.a_6Level = designGlass.a_6Level;
        billOfMat.a_7Level = designGlass.a_7Level;
        billOfMat.a_8Level = designGlass.a_8Level;
        billOfMat.a_9Level = designGlass.a_9Level;
        billOfMat.a_10Level = designGlass.a_10Level;
        billOfMat.a_11Level = designGlass.a_11Level;
        billOfMat.a_12Level = designGlass.a_12Level;
        billOfMat.a_13Level = designGlass.a_13Level;
        billOfMat.a_14Level = designGlass.a_14Level;
        billOfMat.a_15Level = designGlass.a_15Level;
        billOfMat.a_16Level = designGlass.a_16Level;
        billOfMat.a_17Level = designGlass.a_17Level;
        billOfMat.a_18Level = designGlass.a_18Level;
        billOfMat.a_19Level = designGlass.a_19Level;
        billOfMat.a_20Level = designGlass.a_20Level;
        billOfMat.a_21Level = designGlass.a_21Level;
        billOfMat.a_22Level = designGlass.a_22Level;

        billOfMat.a_1Sequence = designGlass.a_1Sequence;
        billOfMat.a_2Sequence = designGlass.a_2Sequence;
        billOfMat.a_3Sequence = designGlass.a_3Sequence;
        billOfMat.a_4Sequence = designGlass.a_4Sequence;
        billOfMat.a_5Sequence = designGlass.a_5Sequence;
        billOfMat.a_6Sequence = designGlass.a_6Sequence;
        billOfMat.a_7Sequence = designGlass.a_7Sequence;
        billOfMat.a_8Sequence = designGlass.a_8Sequence;
        billOfMat.a_9Sequence = designGlass.a_9Sequence;
        billOfMat.a_10Sequence = designGlass.a_10Sequence;
        billOfMat.a_11Sequence = designGlass.a_11Sequence;
        billOfMat.a_12Sequence = designGlass.a_12Sequence;
        billOfMat.a_13Sequence = designGlass.a_13Sequence;
        billOfMat.a_14Sequence = designGlass.a_14Sequence;
        billOfMat.a_15Sequence = designGlass.a_15Sequence;
        billOfMat.a_16Sequence = designGlass.a_16Sequence;
        billOfMat.a_17Sequence = designGlass.a_17Sequence;
        billOfMat.a_18Sequence = designGlass.a_18Sequence;
        billOfMat.a_19Sequence = designGlass.a_19Sequence;
        billOfMat.a_20Sequence = designGlass.a_20Sequence;
        billOfMat.a_21Sequence = designGlass.a_21Sequence;
        billOfMat.a_22Sequence = designGlass.a_22Sequence;

        billOfMat.bomId = bomID++;
        billOfMat.parentbomid = parentBOM.bomId;
        billOfMat.ruleno = -100; //This rule number means is a glass BOM.
        billOfMat.partid = partID;
        billOfMat.level = designGlass.a_levelID;
        billOfMat.parentAssembly = -1;
        billOfMat.stockcode = stockCode;
        billOfMat.description = description;
        billOfMat.descriptionuser = description;
        billOfMat.a_sequenceID = designGlass.a_sequenceID;
        billOfMat.buy = !designGlass.madeIn;
        billOfMat.leafNo = designGlass.leafNo;

        String _sequence = Integer.toString(designGlass.a_sequenceID);
        int _row = Integer.parseInt(String.valueOf(_sequence.charAt(0)));
        int _col = Integer.parseInt(String.valueOf(_sequence.charAt(1)));

        billOfMat.row = _row; //Return row value from sequence
        billOfMat.col = _col; //Return col value from sequence
        billOfMat.width = designGlass.widthM;
        billOfMat.widthi = designGlass.widthI;
        billOfMat.widthuser = designGlass.widthM;
        billOfMat.widthiuser = designGlass.widthI;
        billOfMat.height = designGlass.heightM;
        billOfMat.heighti = designGlass.heightI;
        billOfMat.heightuser = designGlass.heightM;
        billOfMat.heightiuser = designGlass.heightI;

        //********************************************
        //Calculate Area for Glass
        //********************************************
        BigDecimal width = new BigDecimal(billOfMat.width + "").
                divide(new BigDecimal("64"), 6).divide(new BigDecimal("12"), 6);
        BigDecimal height = new BigDecimal(billOfMat.height + "").divide(new BigDecimal("64"), 6).
                divide(new BigDecimal("12"), 6);
        BigDecimal area = width.multiply(height).setScale(6);

        BigDecimal widthI = new BigDecimal(billOfMat.widthi + "").
                divide(new BigDecimal("64"), 6).divide(new BigDecimal("12"), 6);
        BigDecimal heightI = new BigDecimal(billOfMat.heighti + "").
                divide(new BigDecimal("64"), 6).divide(new BigDecimal("12"), 6);
        BigDecimal areaI = widthI.multiply(heightI).setScale(6);

        billOfMat.areauser = area.doubleValue();
        billOfMat.areaiuser = areaI.doubleValue();

        billOfMat.cost = cost;
        billOfMat.totalcost = cost;
        billOfMat.price = new BigDecimal("0");
        billOfMat.priceuser = new BigDecimal("0");
        billOfMat.totalprice = new BigDecimal("0");
        billOfMat.totalpriceuser = new BigDecimal("0");
        billOfMat.sash = designGlass.udOpeningID;
        billOfMat.prodline = designGlass.prodline;
        billOfMat.station = designGlass.station;
        billOfMat.report = designGlass.report;
        billOfMat.delivery = designGlass.delivery;
        billOfMat.reqforstage = designGlass.reqforstage;
        billOfMat.shapeID = designGlass.shapeID;
        billOfMat.assemblyid = designGlass.assemblyID;
        billOfMat.leadtime = designGlass.leadTime;
        billOfMat.qty = 1;
        billOfMat.qtyuser = 1;
        billOfMat.buy = madeIn ? false : true;
        billOfMat.isUsed = true;

        billOfMat.supplierRemoteId = designGlass.supplierRemoteId;
        billOfMat.supplierSeriesId = designGlass.seriesSupplierId;
        billOfMat.remote = designGlass.remote;

        //Setting Shape Object Value
        billOfMat.shapeObject = designGlass.shapeObject;

        //Update level description
        if (billOfMat.level > 0) {
            billOfMat.descriptionLevel = ItemFrame.getApplicationBase().getTypeLevel(billOfMat.level).getDescription();
        }

        //Update Shape description
        if (billOfMat.shapeID > 0) {
            billOfMat.shapeAbbreviation = ItemFrame.getApplicationBase().getTypeShape(billOfMat.shapeID).getAbbrev();
        }

        //Update Sash description
        if (billOfMat.sash > 0) {
            if (billOfMat.remote) {
                billOfMat.sashAbbreviation = ItemFrame.getApplicationRemoteBaseRules().
                        getSeriesValidOpeningById(billOfMat.sash).getSeriesValidOpeningPK().getAbbreviation();
            } else {
                billOfMat.sashAbbreviation = ItemFrame.getApplicationBaseRules().getSeriesValidOpeningById(billOfMat.sash).
                        getSeriesValidOpeningPK().getAbbreviation();
            }
        }

        //Evaluate series valid opening shape
        billOfMat.supplier_rule_no = parentBOM.supplier_rule_no; //Update Supplier Rule Number
        billOfMat.supplier_part_id = parentBOM.supplier_part_id;
        billOfMat.buy = !parentBOM.glass_made_in;
        billOfMat.bought_glazed = parentBOM.bought_glazed;

        return billOfMat;
    }

    /**
     * Create Bom Grids Assembly
     *
     * @param parentBOM,  Glass Parent Bill Of Material
     * @param designGrid, Grids Bill Of Material
     * @return BillOfMat
     */
    private BillOfMat createBomGridsAssembly(BillOfMat parentBOM, DesignGrid designGrid) {

        //*****************************************************************************
        //Create a Bill of Material Assembly
        //*****************************************************************************
        BillOfMat gridsBomAssembly = new BillOfMat();
        gridsBomAssembly.a_levelID = parentBOM.a_levelID;
        gridsBomAssembly.a_sequenceID = parentBOM.a_sequenceID;
        gridsBomAssembly.a_assemblyLevel = parentBOM.a_assemblyLevel;

        gridsBomAssembly.a_1Level = parentBOM.a_1Level;
        gridsBomAssembly.a_2Level = parentBOM.a_2Level;
        gridsBomAssembly.a_3Level = parentBOM.a_3Level;
        gridsBomAssembly.a_4Level = parentBOM.a_4Level;
        gridsBomAssembly.a_5Level = parentBOM.a_5Level;
        gridsBomAssembly.a_6Level = parentBOM.a_6Level;
        gridsBomAssembly.a_7Level = parentBOM.a_7Level;
        gridsBomAssembly.a_8Level = parentBOM.a_8Level;
        gridsBomAssembly.a_9Level = parentBOM.a_9Level;
        gridsBomAssembly.a_10Level = parentBOM.a_10Level;
        gridsBomAssembly.a_11Level = parentBOM.a_11Level;
        gridsBomAssembly.a_12Level = parentBOM.a_12Level;
        gridsBomAssembly.a_13Level = parentBOM.a_13Level;
        gridsBomAssembly.a_14Level = parentBOM.a_14Level;
        gridsBomAssembly.a_15Level = parentBOM.a_15Level;
        gridsBomAssembly.a_16Level = parentBOM.a_16Level;
        gridsBomAssembly.a_17Level = parentBOM.a_17Level;
        gridsBomAssembly.a_18Level = parentBOM.a_18Level;
        gridsBomAssembly.a_19Level = parentBOM.a_19Level;
        gridsBomAssembly.a_20Level = parentBOM.a_20Level;
        gridsBomAssembly.a_21Level = parentBOM.a_21Level;
        gridsBomAssembly.a_22Level = parentBOM.a_22Level;

        gridsBomAssembly.a_1Sequence = parentBOM.a_1Sequence;
        gridsBomAssembly.a_2Sequence = parentBOM.a_2Sequence;
        gridsBomAssembly.a_3Sequence = parentBOM.a_3Sequence;
        gridsBomAssembly.a_4Sequence = parentBOM.a_4Sequence;
        gridsBomAssembly.a_5Sequence = parentBOM.a_5Sequence;
        gridsBomAssembly.a_6Sequence = parentBOM.a_6Sequence;
        gridsBomAssembly.a_7Sequence = parentBOM.a_7Sequence;
        gridsBomAssembly.a_8Sequence = parentBOM.a_8Sequence;
        gridsBomAssembly.a_9Sequence = parentBOM.a_9Sequence;
        gridsBomAssembly.a_10Sequence = parentBOM.a_10Sequence;
        gridsBomAssembly.a_11Sequence = parentBOM.a_11Sequence;
        gridsBomAssembly.a_12Sequence = parentBOM.a_12Sequence;
        gridsBomAssembly.a_13Sequence = parentBOM.a_13Sequence;
        gridsBomAssembly.a_14Sequence = parentBOM.a_14Sequence;
        gridsBomAssembly.a_15Sequence = parentBOM.a_15Sequence;
        gridsBomAssembly.a_16Sequence = parentBOM.a_16Sequence;
        gridsBomAssembly.a_17Sequence = parentBOM.a_17Sequence;
        gridsBomAssembly.a_18Sequence = parentBOM.a_18Sequence;
        gridsBomAssembly.a_19Sequence = parentBOM.a_19Sequence;
        gridsBomAssembly.a_20Sequence = parentBOM.a_20Sequence;
        gridsBomAssembly.a_21Sequence = parentBOM.a_21Sequence;
        gridsBomAssembly.a_22Sequence = parentBOM.a_22Sequence;

        gridsBomAssembly.bomId = bomID++;
        gridsBomAssembly.parentbomid = parentBOM.bomId;
        gridsBomAssembly.ruleno = -200; //This rule number means is a grids BOM.
        gridsBomAssembly.level = designGrid.getLevel();
        gridsBomAssembly.parentAssembly = parentBOM.assemblyid;
        gridsBomAssembly.assemblyid = designGrid.getGrids().getAssemblyId();

        gridsBomAssembly.partid = designGrid.getParts().getId();
        gridsBomAssembly.partFamily = designGrid.getParts().getPartfamily();
        gridsBomAssembly.stockcode = designGrid.getGrids().getAbbrev();
        gridsBomAssembly.stockcodeUser = designGrid.getGrids().getAbbrev();
        gridsBomAssembly.description = "-----" + designGrid.getGrids().getDescription() + " -----";
        gridsBomAssembly.descriptionuser = designGrid.getGrids().getDescription();
        gridsBomAssembly.buy = !designGrid.getGrids().isMadeIn();
        gridsBomAssembly.leafNo = parentBOM.leafNo;

        gridsBomAssembly.row = parentBOM.row;
        gridsBomAssembly.col = parentBOM.col;

        gridsBomAssembly.width = parentBOM.width;
        gridsBomAssembly.widthi = parentBOM.widthi;
        gridsBomAssembly.widthuser = parentBOM.widthuser;
        gridsBomAssembly.widthiuser = parentBOM.widthiuser;
        gridsBomAssembly.height = parentBOM.height;
        gridsBomAssembly.heighti = parentBOM.heighti;
        gridsBomAssembly.heightuser = parentBOM.heightuser;
        gridsBomAssembly.heightiuser = parentBOM.heightiuser;

        //********************************************
        //Calculate Area for Glass
        //********************************************
        gridsBomAssembly.areauser = designGrid.getAreauser();
        gridsBomAssembly.areaiuser = designGrid.getAreaiuser();

        gridsBomAssembly.cost = new BigDecimal("0");
        gridsBomAssembly.totalcost = new BigDecimal("0");
        gridsBomAssembly.price = new BigDecimal("0");
        gridsBomAssembly.priceuser = new BigDecimal("0");
        gridsBomAssembly.totalprice = new BigDecimal("0");
        gridsBomAssembly.totalpriceuser = new BigDecimal("0");

        gridsBomAssembly.prodline = parentBOM.prodline;
        gridsBomAssembly.station = parentBOM.station;
        gridsBomAssembly.report = parentBOM.report;
        gridsBomAssembly.delivery = parentBOM.delivery;
        gridsBomAssembly.reqforstage = parentBOM.reqforstage;
        gridsBomAssembly.shapeID = parentBOM.shapeID;
        gridsBomAssembly.openingid = parentBOM.openingid;
        gridsBomAssembly.sash = parentBOM.sash;

        gridsBomAssembly.supplierRemoteId = parentBOM.supplierRemoteId;
        gridsBomAssembly.supplierSeriesId = parentBOM.supplierSeriesId;
        gridsBomAssembly.remote = parentBOM.remote;

        gridsBomAssembly.isUsed = true;
        gridsBomAssembly.qty = designGrid.getQtyuser();
        gridsBomAssembly.qtyuser = designGrid.getQtyuser();

        gridsBomAssembly.shapeObject = designGrid.getOpening();


        //Update level description
        if (gridsBomAssembly.level > 0) {
            gridsBomAssembly.descriptionLevel = ItemFrame.getApplicationBase().getTypeLevel(gridsBomAssembly.level).getDescription();
        }

        //Update Shape description
        if (gridsBomAssembly.shapeID > 0) {
            gridsBomAssembly.shapeAbbreviation = ItemFrame.getApplicationBase().getTypeShape(gridsBomAssembly.shapeID).getAbbrev();
        }

        //Update Sash description
        if (gridsBomAssembly.sash > 0) {
            if (gridsBomAssembly.remote) {
                gridsBomAssembly.sashAbbreviation = ItemFrame.getApplicationRemoteBaseRules().
                        getSeriesValidOpeningById(gridsBomAssembly.sash).getSeriesValidOpeningPK().getAbbreviation();
            } else {
                gridsBomAssembly.sashAbbreviation = ItemFrame.getApplicationBaseRules().getSeriesValidOpeningById(gridsBomAssembly.sash).
                        getSeriesValidOpeningPK().getAbbreviation();
            }
        }

        //Update If this is an Assembly
        if (gridsBomAssembly.assemblyid > 0) {
            gridsBomAssembly.assembly = true;
        }

        //Evaluate series valid opening shape
        if (parentBOM.supplier_rule_no == -300) {
            gridsBomAssembly.supplier_rule_no = -300; //Update Supplier Rule Number

            gridsBomAssembly.buy = !parentBOM.glass_made_in;
            gridsBomAssembly.bought_glazed = parentBOM.bought_glazed;
        }

        return gridsBomAssembly;
    }

    /**
     * Create Bom Grids Assembly
     *
     * @param parentBOM,  Glass Parent Bill Of Material
     * @param grid, Bill of Material
     * @return BillOfMat
     */
    private BillOfMat createBomGridsAssembly(BillOfMat parentBOM, BillOfMat grid) {

        //*****************************************************************************
        //Create a Bill of Material Assembly
        //*****************************************************************************
        BillOfMat gridsBomAssembly = new BillOfMat();
        gridsBomAssembly.a_levelID = grid.a_levelID;
        gridsBomAssembly.a_sequenceID = grid.a_sequenceID;
        gridsBomAssembly.a_assemblyLevel = grid.a_assemblyLevel;

        gridsBomAssembly.a_1Level = grid.a_1Level;
        gridsBomAssembly.a_2Level = grid.a_2Level;
        gridsBomAssembly.a_3Level = grid.a_3Level;
        gridsBomAssembly.a_4Level = grid.a_4Level;
        gridsBomAssembly.a_5Level = grid.a_5Level;
        gridsBomAssembly.a_6Level = grid.a_6Level;
        gridsBomAssembly.a_7Level = grid.a_7Level;
        gridsBomAssembly.a_8Level = grid.a_8Level;
        gridsBomAssembly.a_9Level = grid.a_9Level;
        gridsBomAssembly.a_10Level = grid.a_10Level;
        gridsBomAssembly.a_11Level = grid.a_11Level;
        gridsBomAssembly.a_12Level = grid.a_12Level;
        gridsBomAssembly.a_13Level = grid.a_13Level;
        gridsBomAssembly.a_14Level = grid.a_14Level;
        gridsBomAssembly.a_15Level = grid.a_15Level;
        gridsBomAssembly.a_16Level = grid.a_16Level;
        gridsBomAssembly.a_17Level = grid.a_17Level;
        gridsBomAssembly.a_18Level = grid.a_18Level;
        gridsBomAssembly.a_19Level = grid.a_19Level;
        gridsBomAssembly.a_20Level = grid.a_20Level;
        gridsBomAssembly.a_21Level = grid.a_21Level;
        gridsBomAssembly.a_22Level = grid.a_22Level;

        gridsBomAssembly.a_1Sequence = grid.a_1Sequence;
        gridsBomAssembly.a_2Sequence = grid.a_2Sequence;
        gridsBomAssembly.a_3Sequence = grid.a_3Sequence;
        gridsBomAssembly.a_4Sequence = grid.a_4Sequence;
        gridsBomAssembly.a_5Sequence = grid.a_5Sequence;
        gridsBomAssembly.a_6Sequence = grid.a_6Sequence;
        gridsBomAssembly.a_7Sequence = grid.a_7Sequence;
        gridsBomAssembly.a_8Sequence = grid.a_8Sequence;
        gridsBomAssembly.a_9Sequence = grid.a_9Sequence;
        gridsBomAssembly.a_10Sequence = grid.a_10Sequence;
        gridsBomAssembly.a_11Sequence = grid.a_11Sequence;
        gridsBomAssembly.a_12Sequence = grid.a_12Sequence;
        gridsBomAssembly.a_13Sequence = grid.a_13Sequence;
        gridsBomAssembly.a_14Sequence = grid.a_14Sequence;
        gridsBomAssembly.a_15Sequence = grid.a_15Sequence;
        gridsBomAssembly.a_16Sequence = grid.a_16Sequence;
        gridsBomAssembly.a_17Sequence = grid.a_17Sequence;
        gridsBomAssembly.a_18Sequence = grid.a_18Sequence;
        gridsBomAssembly.a_19Sequence = grid.a_19Sequence;
        gridsBomAssembly.a_20Sequence = grid.a_20Sequence;
        gridsBomAssembly.a_21Sequence = grid.a_21Sequence;
        gridsBomAssembly.a_22Sequence = grid.a_22Sequence;

        gridsBomAssembly.bomId = bomID++;
        gridsBomAssembly.parentbomid = parentBOM.bomId;
        gridsBomAssembly.ruleno = -200; //This rule number means is a grids BOM.
        gridsBomAssembly.level = grid.a_assemblyLevel;
        gridsBomAssembly.parentAssembly = parentBOM.assemblyid;

        Grids grids = null;
        if (grid.remote) {
            grids = ItemFrame.getApplicationRemoteBaseRules().getGrids(grid.supplierRemoteId, grid.gridID);
        }else {
            grids = ItemFrame.getApplicationBaseRules().getGrids(grid.gridID);
        }

        gridsBomAssembly.assemblyid = grids.getAssemblyId();
        gridsBomAssembly.partid = grid.partid;
        gridsBomAssembly.partFamily = grid.partFamily;
        gridsBomAssembly.stockcode = grids.getAbbrev();
        gridsBomAssembly.stockcodeUser = grids.getAbbrev();
        gridsBomAssembly.description = "-----" + grids.getDescription() + " -----";
        gridsBomAssembly.descriptionuser = grids.getDescription();
        gridsBomAssembly.buy = !grids.isMadeIn();
        gridsBomAssembly.leafNo = parentBOM.leafNo;

        gridsBomAssembly.row = parentBOM.row;
        gridsBomAssembly.col = parentBOM.col;

        gridsBomAssembly.width = parentBOM.width;
        gridsBomAssembly.widthi = parentBOM.widthi;
        gridsBomAssembly.widthuser = parentBOM.widthuser;
        gridsBomAssembly.widthiuser = parentBOM.widthiuser;
        gridsBomAssembly.height = parentBOM.height;
        gridsBomAssembly.heighti = parentBOM.heighti;
        gridsBomAssembly.heightuser = parentBOM.heightuser;
        gridsBomAssembly.heightiuser = parentBOM.heightiuser;

        //********************************************
        //Calculate Area for Glass
        //********************************************
        gridsBomAssembly.areauser = grid.areauser;
        gridsBomAssembly.areaiuser = grid.areaiuser;

        gridsBomAssembly.cost = new BigDecimal("0");
        gridsBomAssembly.totalcost = new BigDecimal("0");
        gridsBomAssembly.price = new BigDecimal("0");
        gridsBomAssembly.priceuser = new BigDecimal("0");
        gridsBomAssembly.totalprice = new BigDecimal("0");
        gridsBomAssembly.totalpriceuser = new BigDecimal("0");

        gridsBomAssembly.prodline = parentBOM.prodline;
        gridsBomAssembly.station = parentBOM.station;
        gridsBomAssembly.report = parentBOM.report;
        gridsBomAssembly.delivery = parentBOM.delivery;
        gridsBomAssembly.reqforstage = parentBOM.reqforstage;
        gridsBomAssembly.shapeID = parentBOM.shapeID;
        gridsBomAssembly.openingid = parentBOM.openingid;
        gridsBomAssembly.sash = parentBOM.sash;

        gridsBomAssembly.supplierRemoteId = parentBOM.supplierRemoteId;
        gridsBomAssembly.supplierSeriesId = parentBOM.supplierSeriesId;
        gridsBomAssembly.remote = parentBOM.remote;

        gridsBomAssembly.isUsed = true;
        gridsBomAssembly.qty = 1;
        gridsBomAssembly.qtyuser = 1;

        gridsBomAssembly.shapeObject = grid.shapeObject;

        //Update level description
        if (gridsBomAssembly.level > 0) {
            gridsBomAssembly.descriptionLevel = ItemFrame.getApplicationBase().getTypeLevel(gridsBomAssembly.level).getDescription();
        }

        //Update Shape description
        if (gridsBomAssembly.shapeID > 0) {
            gridsBomAssembly.shapeAbbreviation = ItemFrame.getApplicationBase().getTypeShape(gridsBomAssembly.shapeID).getAbbrev();
        }

        //Update Sash description
        if (gridsBomAssembly.sash > 0) {
            if (gridsBomAssembly.remote) {
                gridsBomAssembly.sashAbbreviation = ItemFrame.getApplicationRemoteBaseRules().
                        getSeriesValidOpeningById(gridsBomAssembly.sash).getSeriesValidOpeningPK().getAbbreviation();
            } else {
                gridsBomAssembly.sashAbbreviation = ItemFrame.getApplicationBaseRules().getSeriesValidOpeningById(gridsBomAssembly.sash).
                        getSeriesValidOpeningPK().getAbbreviation();
            }
        }

        //Update If this is an Assembly
        if (gridsBomAssembly.assemblyid > 0) {
            gridsBomAssembly.assembly = true;
        }

        //Evaluate series valid opening shape
        if (parentBOM.supplier_rule_no == -300) {
            gridsBomAssembly.supplier_rule_no = -300; //Update Supplier Rule Number

            gridsBomAssembly.buy = !parentBOM.glass_made_in;
            gridsBomAssembly.bought_glazed = parentBOM.bought_glazed;
        }

        return gridsBomAssembly;
    }

    /**
     * Create BOM Grids
     *
     * @param parentBOM,  BillOfMat
     * @param designGrid, Design Grids BOM
     * @return BillOfMat
     */
    private BillOfMat createBomGrids(BillOfMat parentBOM, DesignGrid designGrid) {

        //*********************************************************************
        // Create Bill of Material from Grids
        //*********************************************************************
        BillOfMat billOfMat = new BillOfMat();
        billOfMat.a_levelID = designGrid.getA_levelID();
        billOfMat.a_sequenceID = designGrid.getA_sequenceID();
        billOfMat.a_assemblyLevel = designGrid.getA_assemblyLevel();

        billOfMat.a_1Level = designGrid.getA_1Level();
        billOfMat.a_2Level = designGrid.getA_2Level();
        billOfMat.a_3Level = designGrid.getA_3Level();
        billOfMat.a_4Level = designGrid.getA_4Level();
        billOfMat.a_5Level = designGrid.getA_5Level();
        billOfMat.a_6Level = designGrid.getA_6Level();
        billOfMat.a_7Level = designGrid.getA_7Level();
        billOfMat.a_8Level = designGrid.getA_8Level();
        billOfMat.a_9Level = designGrid.getA_9Level();
        billOfMat.a_10Level = designGrid.getA_10Level();
        billOfMat.a_11Level = designGrid.getA_11Level();
        billOfMat.a_12Level = designGrid.getA_12Level();
        billOfMat.a_13Level = designGrid.getA_13Level();
        billOfMat.a_14Level = designGrid.getA_14Level();
        billOfMat.a_15Level = designGrid.getA_15Level();
        billOfMat.a_16Level = designGrid.getA_16Level();
        billOfMat.a_17Level = designGrid.getA_17Level();
        billOfMat.a_18Level = designGrid.getA_18Level();
        billOfMat.a_19Level = designGrid.getA_19Level();
        billOfMat.a_20Level = designGrid.getA_20Level();
        billOfMat.a_21Level = designGrid.getA_21Level();
        billOfMat.a_22Level = designGrid.getA_22Level();

        billOfMat.a_1Sequence = designGrid.getA_1Sequence();
        billOfMat.a_2Sequence = designGrid.getA_2Sequence();
        billOfMat.a_3Sequence = designGrid.getA_3Sequence();
        billOfMat.a_4Sequence = designGrid.getA_4Sequence();
        billOfMat.a_5Sequence = designGrid.getA_5Sequence();
        billOfMat.a_6Sequence = designGrid.getA_6Sequence();
        billOfMat.a_7Sequence = designGrid.getA_7Sequence();
        billOfMat.a_8Sequence = designGrid.getA_8Sequence();
        billOfMat.a_9Sequence = designGrid.getA_9Sequence();
        billOfMat.a_10Sequence = designGrid.getA_10Sequence();
        billOfMat.a_11Sequence = designGrid.getA_11Sequence();
        billOfMat.a_12Sequence = designGrid.getA_12Sequence();
        billOfMat.a_13Sequence = designGrid.getA_13Sequence();
        billOfMat.a_14Sequence = designGrid.getA_14Sequence();
        billOfMat.a_15Sequence = designGrid.getA_15Sequence();
        billOfMat.a_16Sequence = designGrid.getA_16Sequence();
        billOfMat.a_17Sequence = designGrid.getA_17Sequence();
        billOfMat.a_18Sequence = designGrid.getA_18Sequence();
        billOfMat.a_19Sequence = designGrid.getA_19Sequence();
        billOfMat.a_20Sequence = designGrid.getA_20Sequence();
        billOfMat.a_21Sequence = designGrid.getA_21Sequence();
        billOfMat.a_22Sequence = designGrid.getA_22Sequence();

        billOfMat.bomId = bomID++;
        billOfMat.parentbomid = parentBOM.bomId;
        billOfMat.parentAssembly = parentBOM.assemblyid;
        billOfMat.assemblyid = -1;
        billOfMat.ruleno = -200; //This rule number means is a grids BOM.
        billOfMat.partid = designGrid.getParts().getId();
        billOfMat.partFamily = designGrid.getParts().getPartfamily();
        billOfMat.level = designGrid.getLevel();
        billOfMat.stockcode = designGrid.getParts().getStockcode();
        billOfMat.stockcodeUser = designGrid.getParts().getStockcode();
        billOfMat.description = designGrid.getParts().getDescription();
        billOfMat.descriptionuser = designGrid.getParts().getDescription();
        billOfMat.leafNo = designGrid.getLeafNo();
        billOfMat.orientation = designGrid.getOrientation();

        if (designGrid.getOrientation() == ValidOrientations.HORIZONTAL.getValue()) {
            billOfMat.row = designGrid.getRowcol();
        } else if (designGrid.getOrientation() == ValidOrientations.VERTICAL.getValue()) {
            billOfMat.col = designGrid.getRowcol();
        }

        billOfMat.startpos = designGrid.getStartpos();
        billOfMat.endpos = designGrid.getEndpos();

        billOfMat.cutlength = designGrid.getCutlength();
        billOfMat.cutlengthi = designGrid.getCutlengthi();
        billOfMat.width = designGrid.getWidth();
        billOfMat.widthi = designGrid.getWidthi();
        billOfMat.height = designGrid.getHeight();
        billOfMat.heighti = designGrid.getHeighti();
        billOfMat.cutlengthuser = designGrid.getCutlengthuser();
        billOfMat.cutlengthiuser = designGrid.getCutlengthiuser();
        billOfMat.widthuser = designGrid.getWidthuser();
        billOfMat.widthiuser = designGrid.getWidthiuser();
        billOfMat.heightuser = designGrid.getHeightuser();
        billOfMat.heightiuser = designGrid.getHeightiuser();
        billOfMat.depth = designGrid.getDepth();
        billOfMat.depthi = designGrid.getDepthi();
        billOfMat.depthuser = designGrid.getDepthuser();
        billOfMat.depthiuser = designGrid.getDepthiuser();
        billOfMat.weld = designGrid.getWeld();
        billOfMat.weldi = designGrid.getWeldi();
        billOfMat.weldR = designGrid.getWeldR();
        billOfMat.weldRi = designGrid.getWeldRi();
        billOfMat.leftcut = designGrid.getLeftcut();
        billOfMat.rightcut = designGrid.getRightcut();
        billOfMat.leftangle = designGrid.getLeftangle();
        billOfMat.rightangle = designGrid.getRightangle();
        billOfMat.area = designGrid.getArea();
        billOfMat.areai = designGrid.getAreai();
        billOfMat.areauser = designGrid.getAreauser();
        billOfMat.areaiuser = designGrid.getAreaiuser();
        billOfMat.volume = designGrid.getVolume();
        billOfMat.volumei = designGrid.getVolumei();
        billOfMat.volumeuser = designGrid.getVolumeuser();
        billOfMat.volumeiuser = designGrid.getVolumeiuser();

        billOfMat.radius1 = designGrid.getRadius1();
        billOfMat.radius1i = designGrid.getRadius1i();
        billOfMat.radius2 = designGrid.getRadius2();
        billOfMat.radius2i = designGrid.getRadius2i();

        billOfMat.cost = designGrid.getCost();
        billOfMat.totalcost = designGrid.getTotalcost();
        billOfMat.price = designGrid.getPrice();
        billOfMat.priceuser = designGrid.getPrice();
        billOfMat.totalprice = designGrid.getTotalprice();
        billOfMat.totalpriceuser = designGrid.getTotalpriceuser();

        billOfMat.sash = parentBOM.sash;

        billOfMat.prodline = parentBOM.prodline;
        billOfMat.station = parentBOM.station;

        billOfMat.report = designGrid.getParts().getReport();
        billOfMat.delivery = parentBOM.delivery;
        billOfMat.reqforstage = parentBOM.reqforstage;
        billOfMat.shapeID = parentBOM.shapeID;
        billOfMat.leadtime = parentBOM.leadtime;

        billOfMat.qty = designGrid.getQtyuser();
        billOfMat.qtyuser = designGrid.getQtyuser();

        billOfMat.lengthw2 = designGrid.getLengthw2();
        billOfMat.lengthh2 = designGrid.getLengthh2();
        billOfMat.lengthf12 = designGrid.getLengthf12();
        billOfMat.lengthf22 = designGrid.getLengthf22();

        billOfMat.buy = !designGrid.getGrids().isMadeIn();
        billOfMat.isUsed = true;

        billOfMat.notchesM = designGrid.getNotchesM();
        billOfMat.notchesI = designGrid.getNotchesI();
        billOfMat.notchesIY = designGrid.getNotchesIY();

        billOfMat.supplierRemoteId = parentBOM.supplierRemoteId;
        billOfMat.supplierSeriesId = parentBOM.supplierSeriesId;
        billOfMat.remote = parentBOM.remote;

        //Update level description
        if (billOfMat.level > 0) {
            billOfMat.descriptionLevel = ItemFrame.getApplicationBase().getTypeLevel(billOfMat.level).getDescription();
        }

        //Update Shape description
        if (billOfMat.shapeID > 0) {
            billOfMat.shapeAbbreviation = ItemFrame.getApplicationBase().getTypeShape(billOfMat.shapeID).getAbbrev();
        }

        //Update Sash description
        if (billOfMat.sash > 0) {
            if (billOfMat.remote) {
                billOfMat.sashAbbreviation = ItemFrame.getApplicationRemoteBaseRules().
                        getSeriesValidOpeningById(billOfMat.sash).getSeriesValidOpeningPK().getAbbreviation();
            } else {
                billOfMat.sashAbbreviation = ItemFrame.getApplicationBaseRules().getSeriesValidOpeningById(billOfMat.sash).
                        getSeriesValidOpeningPK().getAbbreviation();
            }
        }

        //Evaluate series valid opening shape
        if (parentBOM.supplier_rule_no == -300) {
            billOfMat.supplier_rule_no = -300; //Update Supplier Rule Number

            billOfMat.buy = !parentBOM.glass_made_in;
            billOfMat.bought_glazed = parentBOM.bought_glazed;
        }

        return billOfMat;

    }

}

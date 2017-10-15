package openjanela.app.configuration.controller;

import Model.*;
import Model.ProfileParts.Profiles;
import Presentation.DrawImage;
import Presentation.DrawImageRequest;
import Presentation.ItemFrame;
import dto.*;
import openjanela.model.PersistenceManagementServiceFactory;
import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.PersistenceManagementServicePartnerFactory;
import openjanela.model.eao.assemblyEAO.AssemblyEAO;
import openjanela.model.eao.assemblyEAO.AssemblyPersistenceEAO;
import openjanela.model.eao.designEAO.DesignEAO;
import openjanela.model.eao.designEAO.DesignPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.genericEAO.PersistenceClassNotFoundException;
import openjanela.model.eao.partner.jobItemEAO.JobItemEAO;
import openjanela.model.eao.partner.jobItemEAO.JobItemPersistenceEAO;
import openjanela.model.entities.design.*;
import openjanela.model.entities.partner.JobItem;
import openjanela.model.entities.parts.Parts;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.openjanela.commons.util.zip.GZipFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 * <p/>
 * This class manage all transaction necessary for execution into JobItemModel
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 01-24-13
 *          Time: 11:22 AM
 */
public class JobItemModelController extends BaseController {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(JobItemModelController.class);

    //Data Access Object
    private AssemblyEAO assemblyEAO;
    private DesignEAO designEAO;
    private JobItemEAO jobItemEAO;

    //Data Access main design administration
    private ItemFrame myFrame;

    //Controller components access
    private BomViewController bomViewController;

    /**
     * Call JobItemModel Controller
     */
    public JobItemModelController() {

        //Init Entity Access Object
        assemblyEAO = new AssemblyPersistenceEAO();
        designEAO = new DesignPersistenceEAO();
        jobItemEAO = new JobItemPersistenceEAO();
    }

    /**
     * Call JobItemModel Controller
     */
    public JobItemModelController(ItemFrame myFrame) {

        //Call main constructor
        this();

        //Init Main Design Frame
        this.myFrame = myFrame;

        //Init controller access
        this.bomViewController = new BomViewController(myFrame);
    }

    /**
     * This method create a JobItem model predefine design from scratch
     *
     * @param jobItemModel, JobItemModel
     * @throws Exception, Exception
     */
    public void createJobItemPredefineDesign(JobItemModel jobItemModel, String description, Integer designFamilyId,
                                             int w, int h,  int wi, int hi) throws Exception {

        if (logger.isDebugEnabled()) {
            logger.debug("Create Job Model predefined design: [DESIGNID]: " + jobItemModel.myParent.designID + ", [SERIESID]: " +
                    jobItemModel.myParent.seriesID + ", [DESIGNFAMILYID]: " + designFamilyId);
        }

        try {

            JobItem jobItem = new JobItem();
            jobItem.setOrderId(-1);
            jobItem.setItemId(-1);
            jobItem.setVersionId(-1);
            jobItem.setViewOut(jobItemModel.viewOut);
            jobItem.setGridId(jobItemModel.gridType);
            jobItem.setQuantity(1);
            jobItem.setPredefineDesignId(designEAO.getNextId());
            jobItem.setPredefineDesignSeriesId(jobItemModel.myParent.seriesID);

            //Creating Overall Object model
            OverallEntityObject overallEntityObject = jobItemModel.design.createObjectModel();
            jobItem.setDesign(GZipFile.gzipObjectToBytes(overallEntityObject));

            jobItemEAO.create(jobItem);

            //***********************************************************
            // Save Predefined design
            //***********************************************************

            //Get design entity from DTO
            Design customDesign = DesignDTO.getDesignEntity(jobItemModel);

            //Preparing PK for custom design
            DesignPK designPK = new DesignPK(jobItem.getPredefineDesignId(), jobItemModel.myParent.supplierPanel.
                    getSupplierController().getSeriesSelected().getId());

            customDesign.setId(designPK);
            customDesign.setDescription(description);
            customDesign.setDesignFamily(designFamilyId);
            customDesign.setWidth(w);
            customDesign.setHeight(h);
            customDesign.setWidthi(wi);
            customDesign.setHeighti(hi);

            designEAO.create(customDesign);

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        }
    }

    /**
     * This method create a JobItem model design from scratch
     *
     * @param jobItemModel, JobItemModel
     * @throws Exception, Exception
     */
    public void createJobItemDesign(JobItemModel jobItemModel) throws Exception {

        if (logger.isDebugEnabled()) {
            logger.debug("Create Job Model design: [ORDERID]: " + jobItemModel.myParent.jobID + ", [ITEMNO]: " +
                    jobItemModel.myParent.itemID + ", [VERSIONNO]:" + jobItemModel.myParent.versionID);
        }

        try {

            JobItem jobItem = new JobItem();
            jobItem.setOrderId(jobItemModel.myParent.jobID);
            jobItem.setItemId(jobItemModel.myParent.itemID);
            jobItem.setVersionId(jobItemModel.myParent.versionID);
            jobItem.setQuantity(Integer.parseInt(jobItemModel.myParent.myTopPanel.qty.getText()));
            jobItem.setViewOut(jobItemModel.viewOut);
            jobItem.setGridId(jobItemModel.gridType);
            jobItem.setSupplierId(ItemFrame.getApplicationRemoteBaseRules().getSupplierID());
            jobItem.setSeriesId(ItemFrame.getApplicationRemoteBaseRules().getSeriesID());
            jobItem.setPredefineDesignId(-1);
            jobItem.setPredefineDesignSeriesId(-1);

            //Creating Design Options
            Set<DesignOptionEntityObject> designOptions = new HashSet<DesignOptionEntityObject>();
            for (DesignOption designOption : jobItemModel.myParent.designOptionsNet) {
                designOptions.add(DesignOptionDTO.getDesignOptionEntity(designOption, true, false));
            }
            jobItem.setDesignOptions(designOptions);

            //Creating boms Object model
            Set<BillOfMaterialEntityObject> billOfMaterials = new HashSet<BillOfMaterialEntityObject>();
            for (BillOfMat billOfMat : jobItemModel.bom) {

                BillOfMaterialEntityObject entity = BillOfMaterialDTO.getBillOfMaterialEntity(billOfMat);
                entity.setShapeObject(billOfMat.shapeObject);
                entity.setProfiles(billOfMat.profiles);
                entity.setOrderId(jobItemModel.myParent.jobID);
                entity.setItemNo(jobItemModel.myParent.itemID);
                entity.setVersionId(jobItemModel.myParent.versionID);

                billOfMaterials.add(entity);
            }

            jobItem.setBoms(billOfMaterials);

            //Creating design glass object model
            Set<DesignGlassEntityObject> glassBoms = new HashSet<DesignGlassEntityObject>();
            for (DesignGlass glassBom : jobItemModel.glassBOM) {
                glassBoms.add(DesignGlassDTO.getDesignGlassEntity(this.myFrame, glassBom));
            }
            jobItem.setGlassBoms(glassBoms);

            //*********************************************************************
            // Init BillOfMaterial relationship
            //*********************************************************************
            initBillOfMaterialsRelationship(jobItemModel, jobItem);

            //*********************************************************************
            //Reset Shape Notes for Design and property save into database.
            //*********************************************************************
            this.myFrame.jobItem.design.resetShapeNotes();

            Set<ShapeNotesEntityObject> shapeNotes = new HashSet<ShapeNotesEntityObject>();
            for (ShapeNotes shapeNote : this.myFrame.jobItem.shapeNotes) {
                ShapeNotesEntityObject shapeNotesEntity = ShapeNotesDTO.getShapeNotesEntityObject(shapeNote);
                shapeNotesEntity.setOrderId(jobItem.getOrderId());
                shapeNotesEntity.setItemNo(jobItem.getItemId());
                shapeNotesEntity.setVersionId(jobItem.getVersionId());

                //Evaluate Bill Of Materials to assign parent Bom
                for (BillOfMaterialEntityObject billOfMatEntity : jobItem.getBoms()) {
                    if (ShapeNotesDTO.isParentBom(shapeNotesEntity, billOfMatEntity)) {
                        shapeNotesEntity.setParentBom(billOfMatEntity);
                        break;
                    }
                }

                shapeNotes.add(shapeNotesEntity);
            }

            jobItem.setShapeNotes(shapeNotes);

            //*********************************************************************
            //Creating Overall Object model
            //*********************************************************************
            OverallEntityObject overallEntityObject = jobItemModel.design.createObjectModel();
            jobItem.setDesign(GZipFile.gzipObjectToBytes(overallEntityObject));

            //*********************************************************************
            //Init Fenestration Glass Design Labels
            //*********************************************************************
            initFenestrationGlassNotes(overallEntityObject, jobItem);

            //*********************************************************************
            //Process JobItem Dealer System
            //*********************************************************************
            jobItem = processJobItemDealerSystem(jobItem);

            //Persist JobItem Model
            jobItemEAO.create(jobItem);

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        }
    }

    /**
     * Process JobItem Dealer System
     *
     * @param jobItem, JobItem Model Entity
     * @return JobItem
     * @throws Exception, Exception
     */
    public JobItem processJobItemDealerSystem(JobItem jobItem) throws Exception {

        try {

            //Generate jobItem byte object
            byte[] jobItemStream = GZipFile.gzipObjectToBytes(jobItem);

            //Remove All Bill Of Material from Remove Supplier
            for (Iterator it = jobItem.getBoms().iterator(); it.hasNext(); ) {
                BillOfMaterialEntityObject bom = (BillOfMaterialEntityObject) it.next();

                if (bom.isRemote()) {
                    bom.setStockCode("**");
                    bom.setDescription("**");
                    bom.setStockcodeUser("**");
                    bom.setDescriptionUser("**");
                    bom.setCost(new BigDecimal("0"));
                    bom.setPrice(new BigDecimal("0"));
                    bom.setTotalCost(new BigDecimal("0"));
                    bom.setTotalPrice(new BigDecimal("0"));
                    bom.setPriceUser(new BigDecimal("0"));
                    bom.setTotalPriceUser(new BigDecimal("0"));
                }

                if (!bom.isRemote()) {
                    Parts part = ItemFrame.getApplicationBaseRules().getPart(bom.getPartId()); //Return Configured Part
                    if (part != null && part.isConfigured() && part.getSeries() == this.myFrame.mySeries.getId()) {
                        bom.setJob_item_model(jobItemStream);
                    }
                 }
            }

            return jobItem;

        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        }
    }

    /**
     * This method update JobItem model design
     *
     * @param jobItemModel, JobItemModel
     * @throws Exception, Exception
     */
    public void updateJobItemDesign(JobItemModel jobItemModel) throws Exception {

        if (logger.isDebugEnabled()) {
            logger.debug("Create Job Model design: [ORDERID]: " + jobItemModel.myParent.jobID + ", [ITEMNO]: " +
                    jobItemModel.myParent.itemID + ", [VERSIONNO]:" + jobItemModel.myParent.versionID);
        }

        try {

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //1. Modify Job Item Design if has a BOM change
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if (!jobItemModel.myParent.saveModel) {

                //Update Item Quantity
                JobItem item = jobItemEAO.findByOrderItems(jobItemModel.myParent.jobID, jobItemModel.myParent.itemID,
                        jobItemModel.myParent.versionID);

                item.setOrderId(jobItemModel.myParent.jobID);
                item.setItemId(jobItemModel.myParent.itemID);
                item.setVersionId(jobItemModel.myParent.versionID);
                item.setQuantity(Integer.parseInt(jobItemModel.myParent.myTopPanel.qty.getText()));
                item.setViewOut(jobItemModel.viewOut);
                item.setGridId(jobItemModel.gridType);
                item.setSupplierId(ItemFrame.getApplicationRemoteBaseRules().getSupplierID());
                item.setSeriesId(ItemFrame.getApplicationRemoteBaseRules().getSeriesID());
                item.setPredefineDesignId(-1);
                item.setPredefineDesignSeriesId(-1);

                jobItemEAO.update(item);

                //Update Assembly Quantity
                assemblyEAO.updateQuantity(jobItemModel.myParent.jobID, jobItemModel.myParent.itemID,
                        jobItemModel.myParent.versionID, Integer.parseInt(jobItemModel.myParent.myTopPanel.qty.getText()));

                return;
            }

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //2. Find Job Item Model Design
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            JobItem jobItem = jobItemEAO.findByOrderItems(jobItemModel.myParent.jobID, jobItemModel.myParent.itemID,
                    jobItemModel.myParent.versionID);

            //Remove jobItem design
            jobItemEAO.remove(jobItem.getId());

            //Create new JobItem design
            JobItem updateItem = new JobItem();
            updateItem.setOrderId(jobItemModel.myParent.jobID);
            updateItem.setItemId(jobItemModel.myParent.itemID);
            updateItem.setVersionId(jobItemModel.myParent.versionID);
            updateItem.setQuantity(Integer.parseInt(jobItemModel.myParent.myTopPanel.qty.getText()));
            updateItem.setViewOut(jobItemModel.viewOut);
            updateItem.setGridId(jobItemModel.gridType);
            updateItem.setSupplierId(ItemFrame.getApplicationRemoteBaseRules().getSupplierID());
            updateItem.setSeriesId(ItemFrame.getApplicationRemoteBaseRules().getSeriesID());
            updateItem.setPredefineDesignId(-1);
            updateItem.setPredefineDesignSeriesId(-1);

            //Creating Design Options
            Set<DesignOptionEntityObject> designOptions = new HashSet<DesignOptionEntityObject>();
            for (DesignOption designOption : jobItemModel.myParent.designOptionsNet) {
                designOptions.add(DesignOptionDTO.getDesignOptionEntity(designOption, true, false));
            }

            updateItem.setDesignOptions(designOptions);

            //Creating boms Object model
            Set<BillOfMaterialEntityObject> billOfMaterials = new HashSet<BillOfMaterialEntityObject>();
            for (BillOfMat billOfMat : jobItemModel.bom) {
                BillOfMaterialEntityObject entity = BillOfMaterialDTO.getBillOfMaterialEntity(billOfMat);
                entity.setOrderId(jobItemModel.myParent.jobID);
                entity.setItemNo(jobItemModel.myParent.itemID);
                entity.setVersionId(jobItemModel.myParent.versionID);

                entity.setShapeObject(billOfMat.shapeObject);
                entity.setProfiles(billOfMat.profiles);

                billOfMaterials.add(entity);
            }

            updateItem.setBoms(billOfMaterials);

            //Creating design glass object model
            Set<DesignGlassEntityObject> glassBoms = new HashSet<DesignGlassEntityObject>();
            for (DesignGlass glassBom : jobItemModel.glassBOM) {
                glassBoms.add(DesignGlassDTO.getDesignGlassEntity(this.myFrame, glassBom));
            }

            updateItem.setGlassBoms(glassBoms);

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //5. Init BillOfMaterial relationship
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            initBillOfMaterialsRelationship(jobItemModel, updateItem);

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //6. Reset Shape Notes for Design and property save into database.
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            this.myFrame.jobItem.design.resetShapeNotes();

            Set<ShapeNotesEntityObject> shapeNotes = new HashSet<ShapeNotesEntityObject>();
            for (ShapeNotes shapeNote : this.myFrame.jobItem.shapeNotes) {
                ShapeNotesEntityObject shapeNotesEntity = ShapeNotesDTO.getShapeNotesEntityObject(shapeNote);
                shapeNotesEntity.setOrderId(jobItem.getOrderId());
                shapeNotesEntity.setItemNo(jobItem.getItemId());
                shapeNotesEntity.setVersionId(jobItem.getVersionId());

                shapeNotes.add(shapeNotesEntity);
            }

            updateItem.setShapeNotes(shapeNotes);

            //Create Overall Object Model
            OverallEntityObject overallEntityObject = jobItemModel.design.createObjectModel();
            updateItem.setDesign(GZipFile.gzipObjectToBytes(overallEntityObject));

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //7. Init Fenestration Glass Design Labels
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            initFenestrationGlassNotes(overallEntityObject, updateItem);

            //*********************************************************************
            //Process JobItem Dealer System
            //*********************************************************************
            updateItem = processJobItemDealerSystem(updateItem);

            //Persist JobItem Model
            jobItemEAO.create(updateItem);

        } catch (PersistenceClassNotFoundException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        }
    }

    /**
     * This method construct and obtain a JobItem model design
     *
     * @return JobItemModel
     * @throws Exception, Exception
     */
    public void openJobItemDefaultDesign() throws Exception {

        try {

            // Get jobItem entity predefined design
            JobItem jobItemEntity = jobItemEAO.findByPredefinedDesignId(this.myFrame.jobItem.designID,
                    this.myFrame.jobItem.seriesid);

            //Init Configuration Options
            this.initConfigurationOption(jobItemEntity);

            //Apply transformation for JobItem DTO
            this.myFrame.jobItem = JobItemDTO.getJobItemModel(this.myFrame.jobItem, jobItemEntity);

        } catch (PersistenceClassNotFoundException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        } finally {
            try {
                PersistenceManagementServiceFactory.close();
            } catch (PersistenceManagementServiceFactoryException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    /**
     * This method construct and obtain a JobItem model design from and order saved in database
     *
     * @throws Exception, Exception
     */
    public void openJobItemDesign() throws Exception {

        try {

            // Get jobItem entity design
            JobItem jobItemEntity = jobItemEAO.findByOrderItems(this.myFrame.jobItem.jobid, this.myFrame.jobItem.itemid,
                    this.myFrame.jobItem.versionid);

            //Init Configuration Options
            this.initConfigurationOption(jobItemEntity);

            //Apply transformation for JobItem DTO
            this.myFrame.jobItem = JobItemDTO.getJobItemModel(this.myFrame.jobItem, jobItemEntity);

            //Setting grid Type setting
            this.myFrame.jobItem.gridType = jobItemEntity.getGridId();

        } catch (PersistenceClassNotFoundException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        } finally {
            try {
                PersistenceManagementServicePartnerFactory.close();
            } catch (PersistenceManagementServiceFactoryException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    /**
     * This method creates a copy of JobItem Design model to other design object with different values detail in the
     * params details.
     *
     * @param fromOrderId,   Order identification values from make copy
     * @param fromItemNo,    Item identification values from make copy
     * @param fromVersionId, Version identification values from make copy
     * @param toOrderId,     Order identification values to make copy
     * @param toItemNo,      Item identification values to make copy
     * @param toVersionId,   Version identification values to make copy
     */
    public void copyJobItemDesign(int fromOrderId, int fromItemNo, int fromVersionId, int toOrderId, int toItemNo,
                                  int toVersionId) throws Exception {

        if (logger.isDebugEnabled()) {
            logger.debug("Copy JobItem design: [FROMORDERID]: " + fromOrderId + ", [FROMITEMNO]: " + fromItemNo + ", " +
                    "[FROMVERSIONID]: " + fromVersionId);
            logger.debug("To new JobItem design: [TOORDERID]: " + toOrderId + ", [TOITEMNO]: " + toItemNo + ", " +
                    "[TOVERSIONID]: " + toVersionId);
        }

        try {

            //Find JobItem to process
            JobItem jobItem = jobItemEAO.findByOrderItems(fromOrderId, fromItemNo, fromVersionId);

            //Create a new JobItem model for copy
            JobItem newJobItem = new JobItem(toOrderId, toItemNo, toVersionId);
            newJobItem.setSupplierId(ItemFrame.getApplicationRemoteBaseRules().getSupplierID());
            newJobItem.setSeriesId(jobItem.getSeriesId());
            newJobItem.setSupplierId(jobItem.getSupplierId());
            newJobItem.setPredefineDesignId(jobItem.getPredefineDesignId());
            newJobItem.setPredefineDesignSeriesId(jobItem.getPredefineDesignSeriesId());
            newJobItem.setGridId(jobItem.getGridId());
            newJobItem.setQuantity(jobItem.getQuantity());

            //Clone Overall design model
            newJobItem.setDesign(jobItem.getDesign());

            //***************************************************************************************
            /* This Iteration clone Glass Bom and save Primary Key as reference for foreign key with
             * Bill of Materials to process relationship. Adding collection to HashMap for search */
            //***************************************************************************************

            //Initialize collection of glass bom from JobItem
            Hibernate.initialize(jobItem.getGlassBoms());

            //Prepared HashMap collection for DesignGlass
            Map<Integer, DesignGlassEntityObject> designGlassMap = new HashMap<Integer, DesignGlassEntityObject>();

            if (jobItem.getGlassBoms() != null && !jobItem.getGlassBoms().isEmpty()) {

                //New clone collection for DesignGlass
                Set<DesignGlassEntityObject> designGlassBoms = new HashSet<DesignGlassEntityObject>();

                for (DesignGlassEntityObject designGlass : jobItem.getGlassBoms()) {

                    //Update temporal reference for Bill of Material with Primary Key value before clone this bean
                    designGlass.setGlassBomId(designGlass.getId());

                    //Clone Design Glass & adding to collection
                    DesignGlassEntityObject designGlassEntity = DesignGlassBeanUtils.cloneBean(designGlass);

                    //Adding to a clone collection
                    designGlassBoms.add(designGlassEntity);

                    //Adding to a HashMap collection with glass bom Identification reference as a key.
                    designGlassMap.put(designGlassEntity.getGlassBomId(), designGlassEntity);
                }

                newJobItem.setGlassBoms(designGlassBoms);
            }

            //***********************************************************************************************
            /* This Iteration clone Bill of Materials and save Primary Key as reference for foreign key with
            *  Parent Bill of Materials.  Adding collection to HashMap for search */
            //***********************************************************************************************

            //Initialize collection of bill of Materials from JobItem
            Hibernate.initialize(jobItem.getBoms());

            if (jobItem.getBoms() != null && !jobItem.getBoms().isEmpty()) {

                //Prepared HashMap collection for Bill of Materials
                Map<Integer, BillOfMaterialEntityObject> billOfMaterialsMap = new HashMap<Integer, BillOfMaterialEntityObject>();

                //New clone collection for Bill of Materials
                Set<BillOfMaterialEntityObject> billOfMaterials = new HashSet<BillOfMaterialEntityObject>();

                for (BillOfMaterialEntityObject billOfMat : jobItem.getBoms()) {

                    //Update Bom Identification Id
                    billOfMat.setBomId(billOfMat.getId());

                    //Init parent Bom & Design Glass
                    Hibernate.initialize(billOfMat.getParentBom());
                    Hibernate.initialize(billOfMat.getDesignGlass());
                    Hibernate.initialize(billOfMat.getAssembly());

                    if (billOfMat.getDesignGlass() != null) {
                        billOfMat.setGlassBomId(billOfMat.getDesignGlass().getId());
                    }

                    if (billOfMat.getParentBom() != null) {
                        billOfMat.setParentBomId(billOfMat.getParentBom().getId());
                    }

                    //Clone Bill of Material entity
                    BillOfMaterialEntityObject billOfMatEntity = BillOfMaterialBeanUtils.cloneBean(billOfMat);
                    billOfMatEntity.setOrderId(newJobItem.getOrderId());
                    billOfMatEntity.setItemNo(newJobItem.getItemId());
                    billOfMatEntity.setVersionId(newJobItem.getVersionId());

                    //Update order reference for Assembly Part from Bill of Material
                    if (billOfMatEntity.getAssembly() != null) {
                        billOfMatEntity.getAssembly().setOrderId(newJobItem.getOrderId());
                        billOfMatEntity.setItemNo(newJobItem.getItemId());
                        billOfMatEntity.setVersionId(newJobItem.getVersionId());
                    }

                    //Adding Bill of Materials to clone collection
                    billOfMaterials.add(billOfMatEntity);

                    //Adding Bill of Material to HashMap collection
                    billOfMaterialsMap.put(billOfMatEntity.getBomId(), billOfMatEntity);
                }

                /** Iterate clone bill of materials collection for setting parent Bom to Entity object **/
                for (BillOfMaterialEntityObject billOfMat : billOfMaterials) {
                    if (billOfMat.getParentBomId() > 0) {
                        BillOfMaterialEntityObject parentBom = billOfMaterialsMap.get(billOfMat.getParentBomId());
                        billOfMat.setParentBom(parentBom);
                    }

                    if (billOfMat.getGlassBomId() > 0) {
                        DesignGlassEntityObject designGlass = designGlassMap.get(billOfMat.getGlassBomId());
                        billOfMat.setDesignGlass(designGlass);
                    }
                }

                newJobItem.setBoms(billOfMaterials);
            }

			/* Clone Design Options */
            Hibernate.initialize(jobItem.getDesignOptions());
            if (jobItem.getDesignOptions() != null && !jobItem.getDesignOptions().isEmpty()) {
                Set<DesignOptionEntityObject> designOptions = new HashSet<DesignOptionEntityObject>();

                for (DesignOptionEntityObject designOption : jobItem.getDesignOptions()) {
                    DesignOptionEntityObject designOptionEntity = DesignOptionBeanUtils.cloneBean(designOption);
                    designOptions.add(designOptionEntity);
                }
                newJobItem.setDesignOptions(designOptions);
            }

            /* Clone Shape Notes */
            Hibernate.initialize(jobItem.getShapeNotes());
            if (jobItem.getShapeNotes() != null && !jobItem.getShapeNotes().isEmpty()) {
                Set<ShapeNotesEntityObject> shapeNotes = new HashSet<ShapeNotesEntityObject>();

                for (ShapeNotesEntityObject shapeNote : jobItem.getShapeNotes()) {
                    ShapeNotesEntityObject shapeNotesEntity = ShapeNotesBeanUtils.cloneBean(shapeNote);

                    //Init Bom for Shape Notes
                    Hibernate.initialize(shapeNote.getParentBom());

                    //Search and assign new relation for copy
                    for (BillOfMaterialEntityObject bom : newJobItem.getBoms()) {
                        if (shapeNote.getParentBom() != null &&
                                shapeNote.getParentBom().getId() == bom.getBomId()) {
                            shapeNotesEntity.setParentBom(bom);
                        }
                    }

                    //Adding to collection
                    shapeNotes.add(shapeNotesEntity);
                }

                //Adding to new Job Item
                newJobItem.setShapeNotes(shapeNotes);
            }

            /* Clone Design Glass Ratings */
            Hibernate.initialize(jobItem.getGlassRatingLabels());
            if (jobItem.getGlassRatingLabels() != null && !jobItem.getGlassRatingLabels().isEmpty()) {
                Set<DesignGlassRatingsEntityObject> glassRatings = new HashSet<DesignGlassRatingsEntityObject>();

                for (DesignGlassRatingsEntityObject glassRating : jobItem.getGlassRatingLabels()) {
                    DesignGlassRatingsEntityObject glassRatingEntity = DesignGlassRatingsBeanUtils.cloneBean(glassRating);

                    //Init Bom for Glass Ratings
                    Hibernate.initialize(glassRating.getBom());

                    //Search and assign new relation for copy
                    if (glassRating.getBom() != null) {
                        for (BillOfMaterialEntityObject bom : newJobItem.getBoms()) {
                            if (glassRating.getBom().getId() == bom.getBomId()) {
                                glassRatingEntity.setBom(bom);
                            }
                        }
                    }

                    //Adding to collection
                    glassRatings.add(glassRatingEntity);
                }

                //Adding to new Job Item
                newJobItem.setGlassRatingLabels(glassRatings);
            }

            jobItemEAO.create(newJobItem);

        } catch (PersistenceClassNotFoundException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        }
    }

    /**
     * This method remove JobItem model design
     *
     * @param orderId,   Order Identification value
     * @param itemNo,    Item number Identification value
     * @param versionId, Version Identification value
     * @throws Exception, Exception
     */
    public void removeJobItemDesign(int orderId, int itemNo, int versionId) throws Exception {

        if (logger.isDebugEnabled()) {
            logger.debug("Remove JobItem design: [ORDERID]: " + orderId + ", [ITEMNO]: " + itemNo + ", [VERSIONID]: " +
                    versionId);
        }

        try {

            //Find JobItem to process
            JobItem jobItem = jobItemEAO.findByOrderItems(orderId, itemNo, versionId);

            //Remove JobItem
            jobItemEAO.remove(jobItem.getId());

        } catch (PersistenceClassNotFoundException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        }
    }

    /**
     * This method remove JobItem model design
     *
     * @param orderId, Order Identification value
     * @throws Exception, Exception
     */
    public void removeJobItemDesign(int orderId) throws Exception {

        if (logger.isDebugEnabled()) {
            logger.debug("Remove JobItem design: [ORDERID]: " + orderId);
        }

        try {

            //Find JobItem to process
            List<JobItem> jobItems = jobItemEAO.findByOrderId(orderId);

            for (JobItem jobItem : jobItems) {
                jobItemEAO.remove(jobItem.getId());
            }

        } catch (PersistenceClassNotFoundException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        }
    }

    /**
     * This method update order identification from JobItem
     *
     * @param originalOrderId, Original Order Identification
     * @param originalItemId,  Original Item Identification
     * @param newOrderId,      New Order Identification
     * @throws Exception, Exception
     */
    public void updateJobItemOrderId(int originalOrderId, int originalItemId, int originalVersionId, int newOrderId)
            throws Exception {

        if (logger.isDebugEnabled()) {
            logger.debug("Update Order Identification: [ORIGINALORDERID]: " + originalOrderId + ", [ORIGINALITEMID]: " +
                    originalItemId + ", [NEWORDERID]: " + newOrderId);
        }

        try {

            //Find JobItem record and update order Identification Id
            JobItem jobItem = jobItemEAO.findByOrderParameters(originalOrderId, originalItemId, originalVersionId);
            jobItem.setOrderId(newOrderId);

            //Update order Identification Id for Bill of Materials
            Hibernate.initialize(jobItem.getBoms());
            for (BillOfMaterialEntityObject billOfMat : jobItem.getBoms()) {
                billOfMat.setOrderId(newOrderId);

                Hibernate.initialize(billOfMat.getAssembly());
                if (billOfMat.getAssembly() != null) {
                    billOfMat.getAssembly().setOrderId(newOrderId);
                }
            }

            //Update Shape Notes Order Identification
            Hibernate.initialize(jobItem.getShapeNotes());
            for (ShapeNotesEntityObject shapeNotes : jobItem.getShapeNotes()) {
                shapeNotes.setOrderId(newOrderId);
            }

            //Update Design Glass Ratings Identification
            Hibernate.initialize(jobItem.getGlassRatingLabels());
            for (DesignGlassRatingsEntityObject designGlassRating : jobItem.getGlassRatingLabels()) {
                designGlassRating.setOrderId(newOrderId);
            }

            jobItemEAO.update(jobItem);

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        } finally {
            PersistenceManagementServicePartnerFactory.close();
        }
    }

    /**
     * This method return design options for an item
     *
     * @param orderId,   Order Identification Id
     * @param itemId,    Item Identification Id
     * @param versionId, Version Identification Id
     * @return List
     * @throws Exception, Exception
     */
    public List<DesignOptionEntityObject> getDesignOptions(int orderId, int itemId, int versionId) throws Exception {

        try {

            return jobItemEAO.findDesignOptions(orderId, itemId, versionId);

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        }
    }

    /**
     * This method return design glass for an item
     *
     * @param orderId,   Order Identification Id
     * @param itemId,    Item Identification Id
     * @param versionId, Version Identification Id
     * @return List
     * @throws Exception, Exception
     */
    public List<DesignGlassEntityObject> getDesignGlass(int orderId, int itemId, int versionId) throws Exception {
        try {

            return jobItemEAO.findDesignGlass(orderId, itemId, versionId);

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        }
    }

    /**
     * This method init parent boms values
     *
     * @param jobItemModel, JobItemModel
     * @param jobItem,      JobItem
     */
    private void initBillOfMaterialsRelationship(JobItemModel jobItemModel, JobItem jobItem) {

        Set<BillOfMaterialEntityObject> billOfMaterials = jobItem.getBoms();
        Set<DesignGlassEntityObject> glassBoms = jobItem.getGlassBoms();

        for (BillOfMaterialEntityObject billOfMaterial : billOfMaterials) {

            //Search glass bom reference if this bill of material is a glass bom
            if (billOfMaterial.getGlassBomId() > 0 && billOfMaterial.getRuleNo() <= 0) {
                for (DesignGlassEntityObject glass : glassBoms) {
                    if (billOfMaterial.getGlassBomId() == glass.getGlassBomId()) {
                        billOfMaterial.setDesignGlass(glass);
                        break;
                    }
                }
            }

            //Search parent bill of material
            if (billOfMaterial.getParentBomId() > 0) {
                for (BillOfMaterialEntityObject parent : billOfMaterials) {
                    if (billOfMaterial.getParentBomId() == parent.getBomId()) {
                        billOfMaterial.setParentBom(parent);
                        break;
                    }
                }
            }

            //Create a Bill of Material Assembly Part
            if (billOfMaterial.isAssemblyBom()) {
                initAssemblyPart(jobItemModel, jobItem, billOfMaterial);
            }

            //Clear Shape Object reference & Profiles reference
            billOfMaterial.setShapeObject(null);
            billOfMaterial.setProfiles(null);
        }
    }

    /**
     * This method init an Assembly Part for BillOfMaterialEntity object
     *
     * @param jobItemModel,   JobItem Model
     * @param jobItem,        JobItem entity object
     * @param billOfMaterial, BillOfMaterialEntityObject
     */
    private void initAssemblyPart(JobItemModel jobItemModel, JobItem jobItem, BillOfMaterialEntityObject billOfMaterial) {

        AssemblyEntityObject assembly = new AssemblyEntityObject();
        assembly.setOrderId(billOfMaterial.getOrderId());
        assembly.setItemNo(billOfMaterial.getItemNo());
        assembly.setVersionId(billOfMaterial.getVersionId());
        assembly.setAssemblyId(billOfMaterial.getAssemblyId());
        assembly.setQty(jobItem.getQuantity());
        assembly.setRow(billOfMaterial.getRow());
        assembly.setCol(billOfMaterial.getCol());
        assembly.setStage(billOfMaterial.getReqForStage());
        assembly.setShift(0);

        assembly.setBom(billOfMaterial);

        //***************************************************************
        //Save Bill Of Material Shape Data
        //***************************************************************
        if (billOfMaterial.getShapeObject() != null) {
            BillOfMaterialShapeData billOfMatShape = new BillOfMaterialShapeData(billOfMaterial.getRadius_1_s(),
                    billOfMaterial.getRadius_1_i_s(), billOfMaterial.getRadius_2_s(), billOfMaterial.getRadius_2_i_s(),
                    billOfMaterial.getMinLeg(), billOfMaterial.getMinLeg_i(), billOfMaterial.getDimA_1(),
                    billOfMaterial.getDimA_2(), billOfMaterial.getDimA_3(), billOfMaterial.getDimA_4(),
                    billOfMaterial.getDimA_5(), billOfMaterial.getDimA_0(), billOfMaterial.getDimB_1(),
                    billOfMaterial.getDimB_2(), billOfMaterial.getDimB_3(), billOfMaterial.getDimB_4(),
                    billOfMaterial.getDimB_5(), billOfMaterial.getDimB_0(), billOfMaterial.getDimC_1(),
                    billOfMaterial.getDimC_2(), billOfMaterial.getDimC_3(), billOfMaterial.getDimC_4(),
                    billOfMaterial.getDimC_5(), billOfMaterial.getDimC_0(), billOfMaterial.getDimD_1(),
                    billOfMaterial.getDimD_2(), billOfMaterial.getDimD_3(), billOfMaterial.getDimD_4(),
                    billOfMaterial.getDimD_5(), billOfMaterial.getDimD_0(), billOfMaterial.getDimA_1_i(),
                    billOfMaterial.getDimA_2_i(), billOfMaterial.getDimA_3_i(), billOfMaterial.getDimA_4_i(),
                    billOfMaterial.getDimA_5_i(), billOfMaterial.getDimA_0_i(), billOfMaterial.getDimB_1_i(),
                    billOfMaterial.getDimB_2_i(), billOfMaterial.getDimB_3_i(), billOfMaterial.getDimB_4_i(),
                    billOfMaterial.getDimB_5_i(), billOfMaterial.getDimB_0_i(), billOfMaterial.getDimC_1_i(),
                    billOfMaterial.getDimC_2_i(), billOfMaterial.getDimC_3_i(), billOfMaterial.getDimC_4_i(),
                    billOfMaterial.getDimC_5_i(), billOfMaterial.getDimC_0_i(), billOfMaterial.getDimD_1_i(),
                    billOfMaterial.getDimD_2_i(), billOfMaterial.getDimD_3_i(), billOfMaterial.getDimD_4_i(),
                    billOfMaterial.getDimD_5_i(), billOfMaterial.getDimD_0_i());
            try {
                assembly.setShape(GZipFile.gzipObjectToBytes(billOfMatShape));
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }

        //***************************************************************
        //Save Options for Shape Assembly
        //***************************************************************

        //Creating Design Options
        if (billOfMaterial.getShapeObject() != null) {

            Set<ShapeOptionEntityObject> shapeOptions = new HashSet<ShapeOptionEntityObject>();
            ShapeObject shapeObject = (ShapeObject) billOfMaterial.getShapeObject();
            for (ShapeOption shapeOption : shapeObject.options) {
                shapeOptions.add(ShapeOptionDTO.getShapeOptionEntity(shapeOption));
            }

            ShapeOptionWrapEntity shapeOptionWrap = new ShapeOptionWrapEntity();
            shapeOptionWrap.setShapeOptions(shapeOptions);

            try {
                assembly.setOptions(GZipFile.gzipObjectToBytes(shapeOptionWrap));
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }

        //***************************************************************
        //Save Options for Profile Assembly
        //***************************************************************

        //Creating Design Options
        if (billOfMaterial.getProfiles() != null) {

            Set<ShapeOptionEntityObject> profileOptions = new HashSet<ShapeOptionEntityObject>();
            Profiles profiles = (Profiles) billOfMaterial.getProfiles();
            for (ShapeOption profileOption : profiles.options) {
                profileOptions.add(ShapeOptionDTO.getShapeOptionEntity(profileOption));
            }

            ShapeOptionWrapEntity shapeOptionWrap = new ShapeOptionWrapEntity();
            shapeOptionWrap.setShapeOptions(profileOptions);

            try {
                assembly.setOptions(GZipFile.gzipObjectToBytes(shapeOptionWrap));
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }

        //***************************************************************
        //Create an Image for Assembly Part
        //***************************************************************
        //Get Canvas original values to restore
        int c_width = jobItemModel.myCanvas.getWidth();
        int c_height = jobItemModel.myCanvas.getHeight();

        //Init Assembly Image Value
        byte[] image = null;

        if (billOfMaterial.getRuleNo() == -200) {
            DrawImageRequest drawImageRequest = new DrawImageRequest(this.myFrame);
            image = drawImageRequest.drawImageGlass(billOfMaterial.getShapeObject());

            try {
                assembly.setImage(GZipFile.gzipCompress(image));
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        } else {
            DrawImage drawImage = new DrawImage(this.myFrame);
            image = drawImage.drawImage(billOfMaterial.getConstructionMap());

            if (drawImage.drawImage) {
                try {
                    assembly.setImage(GZipFile.gzipCompress(image));
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }

        //refactor the canvas to the original dimension
        jobItemModel.myCanvas.setSize(c_width, c_height);

        //Setting assembly to bom relationship
        billOfMaterial.setAssembly(assembly);
    }

    /**
     * Init Fenestration Glass ratings notes values for frames
     *
     * @param overallEntity, Overall entity object
     * @param jobItem,       JobItem entity object
     * @throws Exception, Exception
     */
    private void initFenestrationGlassNotes(OverallEntityObject overallEntity, JobItem jobItem) {

        //Glass Design Rating Label Generation
        Set<DesignGlassRatingsEntityObject> designRatingValues = new HashSet<DesignGlassRatingsEntityObject>();

        for (FacetEntityObject facet : overallEntity.getFacets()) {

            for (FrameEntityObject frame : facet.getFrames()) {

                //***********************************************************
                //Evaluate Fenestration Values to Generate Labels
                //***********************************************************
                for (DesignGlassRatingsEntityObject designGlassRating : frame.getDesignGlassRatings()) {
                    designGlassRating.setOrderId(jobItem.getOrderId());
                    designGlassRating.setItemNo(jobItem.getItemId());
                    designGlassRating.setVersionId(jobItem.getVersionId());

                    for (BillOfMaterialEntityObject bom : jobItem.getBoms()) {
                        if (designGlassRating.getBomId() == bom.getBomId()) {
                            designGlassRating.setBom(bom);
                        }
                    }

                    designRatingValues.add(designGlassRating);
                }
            }
        }

        //Adding glass rating labels
        jobItem.setGlassRatingLabels(designRatingValues);
    }

    //******************************************************************************************************************
    // Utility methods design GUI
    //******************************************************************************************************************

    /**
     * This method init configuration option for JobItem
     *
     * @param jobItem, JobItem
     */
    private void initConfigurationOption(JobItem jobItem) throws IOException, ClassNotFoundException {

        OverallEntityObject overallEntity = (OverallEntityObject) GZipFile.gzipBytesToObject(jobItem.getDesign());

        /* Setting UOM scale */
        this.myFrame.jobItem.originalScaleM = overallEntity.getScaleM();
        this.myFrame.jobItem.originalScaleI = overallEntity.getScaleImp();

        /* Configuring unit of metric for design */
        if (overallEntity.getBaseUOM() == Metrics.METRIC.getValue()) {

			/* Prepared top panel to configure metric scale */
            this.myFrame.myTopPanel.metric.setSelected(true);

            this.myFrame.defaultentryUOM = Metrics.METRIC.getValue();
            this.myFrame.currentUOM = Metrics.METRIC.getValue();
            this.myFrame.prevUOM = Metrics.METRIC.getValue();

			/* Setting selected dimension for scale selected */
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            // TODO: getHeightM = 0 !!!!!   it is Saved as 0 - need to check Save
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

            this.myFrame.jobItem.setWHDimChangeInit(overallEntity.getWidthM() / 100d, overallEntity.getHeightPix().doubleValue() /
                    this.myFrame.jobItem.originalScaleM.doubleValue() / 100d, true);

			/* Setting selected scales */
            this.myFrame.jobItem.originalScaleS = this.myFrame.jobItem.originalScaleM;
            this.myFrame.jobItem.newScaleS = this.myFrame.metricscale;

        } else if (overallEntity.getBaseUOM() == Metrics.IMPERIAL_DECIMAL.getValue()) {

			/* Prepared top panel to configure imperial scale */
            this.myFrame.myTopPanel.impDec.setSelected(true);

            this.myFrame.defaultentryUOM = Metrics.IMPERIAL_DECIMAL.getValue();
            this.myFrame.currentUOM = Metrics.IMPERIAL_DECIMAL.getValue();
            this.myFrame.prevUOM = Metrics.IMPERIAL_DECIMAL.getValue();

			/* setting selected dimension for scale selected */
            this.myFrame.jobItem.setWHDimChangeInit(overallEntity.getWidthI() / 64d,
                    overallEntity.getHeightI() / 64d, true);

			/* Setting selected scales */
            this.myFrame.jobItem.originalScaleS = this.myFrame.jobItem.originalScaleI;
            this.myFrame.jobItem.newScaleS = this.myFrame.imperialscale;

        } else if (overallEntity.getBaseUOM() == Metrics.IMPERIAL_FRACTION.getValue()) {

			/* Prepared top panel to configure imperial fraction scale */
            this.myFrame.jobItem.myParent.myTopPanel.impFrac.setSelected(true);

            this.myFrame.defaultentryUOM = Metrics.IMPERIAL_FRACTION.getValue();
            this.myFrame.currentUOM = Metrics.IMPERIAL_FRACTION.getValue();
            this.myFrame.prevUOM = Metrics.IMPERIAL_FRACTION.getValue();

        } else if (overallEntity.getBaseUOM() == Metrics.FEET.getValue()) {

			/* Prepared top panel to configure feet fraction scale */
            this.myFrame.myTopPanel.feet.setSelected(true);

            this.myFrame.defaultentryUOM = Metrics.FEET.getValue();
            this.myFrame.currentUOM = Metrics.FEET.getValue();
            this.myFrame.prevUOM = Metrics.FEET.getValue();
        }

        /* Init Overall design object for drawing */
        this.myFrame.jobItem.design = new Overall(this.myFrame, this.myFrame.jobItem, overallEntity,
                overallEntity.getShapeID(), this.myFrame.jobItem.rID, 0);

		/* Setting width values for Imperial and metric */
        this.myFrame.jobItem.design_WIDTH_Imp = this.myFrame.jobItem.design.widthI;
        this.myFrame.jobItem.design_WIDTH_Metric = this.myFrame.jobItem.design.widthM;
        this.myFrame.jobItem.design_WIDTH_Imp_O = this.myFrame.jobItem.design.widthIO;
        this.myFrame.jobItem.design_WIDTH_Metric_O = this.myFrame.jobItem.design.widthMO;

		/* Setting height values for Imperial and metric */
        this.myFrame.jobItem.design_HEIGHT_Imp = this.myFrame.jobItem.design.heightI;
        this.myFrame.jobItem.design_HEIGHT_Metric = this.myFrame.jobItem.design.heightM;
        this.myFrame.jobItem.design_HEIGHT_Imp_O = this.myFrame.jobItem.design.heightIO;
        this.myFrame.jobItem.design_HEIGHT_Metric_O = this.myFrame.jobItem.design.heightMO;
    }
}

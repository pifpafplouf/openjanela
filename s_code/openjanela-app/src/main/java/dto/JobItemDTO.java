package dto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.genericEAO.PersistenceClassNotFoundException;
import openjanela.model.eao.partner.jobItemEAO.JobItemEAO;
import openjanela.model.eao.partner.jobItemEAO.JobItemPersistenceEAO;
import openjanela.model.eao.partner.optionsEAO.OptionsEAO;
import openjanela.model.eao.partner.optionsEAO.OptionsPersistenceEAO;
import openjanela.model.entities.design.*;
import openjanela.model.entities.partner.JobItem;
import openjanela.model.entities.partner.OptionDefinitions;

import orderEntryUtility.DesignOptionSorter;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;

import Model.DesignOption;
import Model.JobItemModel;
import Model.Overall;
import Presentation.ForcedOptionAnswer;

import org.openjanela.commons.util.zip.GZipFile;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: Eddy Montenegro
 * Date: 12-23-12
 * Time: 10:28 PM
 */
public class JobItemDTO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(JobItemDTO.class);

    /**
     * This method transform JobItem database entity into JobItemModel design
     *
     * @param jobItemModel,  JobItemModel
     * @param jobItemEntity, JobItem
     * @return JobItemModel
     * @throws DTOTransformationError, Error
     */
    public static JobItemModel getJobItemModel(JobItemModel jobItemModel, JobItem jobItemEntity) throws DTOTransformationError,
            IOException, ClassNotFoundException {

        OverallEntityObject overallEntity = (OverallEntityObject) GZipFile.gzipBytesToObject(jobItemEntity.getDesign());

        /* Init View Out Design */
        jobItemModel.viewOut = jobItemEntity.isViewOut();
        jobItemModel.gridType = jobItemEntity.getGridId();

        /* Init Overall design object for drawing */
        jobItemModel.design = new Overall(jobItemModel.myParent, jobItemModel, overallEntity, overallEntity.getShapeID(),
                jobItemModel.rID, 0);

        //Clear JobItem model collections
        jobItemModel.myParent.designOptionsNet.clear();
        jobItemModel.bom.clear();
        jobItemModel.glassBOM.clear();

        //Loading design options for ItemFrame
        Hibernate.initialize(jobItemEntity.getDesignOptions());
        for (DesignOptionEntityObject designOptionEntity : jobItemEntity.getDesignOptions()) {
            DesignOption designOption = DesignOptionDTO.getDesignOptionModel(designOptionEntity);
            jobItemModel.myParent.designOptionsNet.add(designOption);
        }

        //Init Design Options
        Collections.sort((ArrayList) jobItemModel.myParent.designOptionsNet, DesignOptionSorter.RuleNo);
        jobItemModel.myParent.options.initValues();

        //Loading JobItemModel bom
        Hibernate.initialize(jobItemEntity.getBoms());
        for (BillOfMaterialEntityObject billOfMaterialEntity : jobItemEntity.getBoms()) {
            jobItemModel.bom.add(BillOfMaterialDTO.getBuildOfMaterialModel(billOfMaterialEntity));
        }

        //Loading JobItemModel glassBom
        Hibernate.initialize(jobItemEntity.getGlassBoms());
        for (DesignGlassEntityObject designBomEntity : jobItemEntity.getGlassBoms()) {
            jobItemModel.glassBOM.add(DesignGlassDTO.getDesignGlassModel(designBomEntity));
        }

        //Loading JobItemModel Shape Notes
        Hibernate.initialize(jobItemEntity.getShapeNotes());
        for (ShapeNotesEntityObject shapeNotesEntity : jobItemEntity.getShapeNotes()) {
            jobItemModel.shapeNotes.add(ShapeNotesDTO.getShapeNotesModel(shapeNotesEntity));
        }

        return jobItemModel;
    }

    /**
     * Save Final ORDER database persistence object
     *
     * @param oldOrderId , Order ID design
     * @param newOrderId , Item No design
     * @throws DTOTransformationError , Error
     */
    public static void setOrderID(int oldOrderId, int newOrderId) throws DTOTransformationError {

        // Get JobItem Persistence EAO
        JobItemEAO jobItemEAO = new JobItemPersistenceEAO();

        try {

            //Find all jobItem with the orderId
            List<JobItem> jobItemList = jobItemEAO.findByOrderId(oldOrderId);

            for (JobItem jobItem : jobItemList) {
                jobItem.setOrderId(newOrderId);

                jobItemEAO.update(jobItem);
            }

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        }
    }

    /**
     * Return Bill of Material from JobItem model
     *
     * @param orderId
     * @param itemNo
     * @param versionId
     * @return
     * @throws DTOTransformationError
     */
    public static Set<BillOfMaterialEntityObject> getJobItemBom(int orderId, int itemNo, int versionId) throws DTOTransformationError {

        // Get JobItem Persistence EAO
        JobItemEAO jobItemEAO = new JobItemPersistenceEAO();

        try {

            JobItem jobItem = jobItemEAO.findByOrderItems(orderId, itemNo, versionId);

            return jobItem.getBoms();

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        }
    }

}

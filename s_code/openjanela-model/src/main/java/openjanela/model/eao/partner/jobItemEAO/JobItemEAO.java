package openjanela.model.eao.partner.jobItemEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.genericEAO.PersistenceClassNotFoundException;
import openjanela.model.entities.design.DesignGlassEntityObject;
import openjanela.model.entities.design.DesignOptionEntityObject;
import openjanela.model.entities.partner.JobItem;
import openjanela.model.entities.partner.JobItemPK;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 12-17-12
 *          Time: 11:50 PM
 */
public interface JobItemEAO extends GenericEAO<JobItem, Integer> {

    /**
     * Return a next Order ID from register
     *
     * @return int
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public int getNextOrderID() throws GenericPersistenceEAOException;

    /**
     * Find JobItem with parameters search
     *
     * @param orderId,   Order Identification
     * @param itemId,    Item Identification
     * @param versionId, Version Identification
     * @return JobItem
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public JobItem findByOrderItems(int orderId, int itemId, int versionId) throws GenericPersistenceEAOException;

    /**
     * Find JobItem with predefined design and series identification
     *
     * @param predefinedDesignId, Predefined Identification Id
     * @param seriesId,           Series Identification Id
     * @return JobItem
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Error
     */
    public JobItem findByPredefinedDesignId(int predefinedDesignId, int seriesId) throws PersistenceClassNotFoundException,
            GenericPersistenceEAOException;

    /**
     * Find JobItem object that corresponds to the order identification Id and Item Identification Id
     *
     * @param orderId,   Order Identification Id
     * @param itemId,    Item Identification Id
     * @param versionId, Version Identification Id
     * @return JobItem
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public JobItem findByOrderParameters(int orderId, int itemId, int versionId) throws GenericPersistenceEAOException;

    /**
     * Find all JobItems object that corresponds to the order identification Id
     *
     * @param orderId, Order Identification Id
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<JobItem> findByOrderId(int orderId) throws GenericPersistenceEAOException;

    /**
     * Find Design Option Entity Object
     *
     * @param orderId,   Order Identification Id
     * @param itemId,    Item Identification Id
     * @param versionId, Version Identification Id
     * @return List<DesignOptionEntityObject>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<DesignOptionEntityObject> findDesignOptions(int orderId, int itemId, int versionId)
            throws GenericPersistenceEAOException;

    /**
     * Find Design Glass Entity Object
     *
     * @param orderId,   Order Identification Id
     * @param itemId,    Item Identification Id
     * @param versionId, Version Identification Id
     * @return List<DesignGlassEntityObject>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<DesignGlassEntityObject> findDesignGlass(int orderId, int itemId, int versionId)
            throws GenericPersistenceEAOException;

    /**
     * Update Order Items Identification Id to a new value
     *
     * @param oldOrderId, Order Identification
     * @param newOrderId, New Order Identification
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public void updateOrderItems(int oldOrderId, int newOrderId) throws GenericPersistenceEAOException;

    /**
     * Remove JobItem with order items parameters
     *
     * @param orderId,   Order Identification
     * @param itemId,    Item Identification
     * @param versionId, Vesion Identification
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public void removeByOrderItems(int orderId, int itemId, int versionId) throws GenericPersistenceEAOException;

    /**
     * Create Remote Job Item Model
     *
     * @param supplierId, Supplier Identification Id
     * @param jobItem,    JobItem Model Object
     * @throws GenericPersistenceEAOException, Exception
     */
    public void createRemote(Integer supplierId, JobItem jobItem) throws GenericPersistenceEAOException;

}

package openjanela.model.eao.design.billOfMaterialEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.design.BillOfMaterialEntityObject;
import openjanela.model.entities.production.ProductionLineStation;

import java.util.Date;
import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-30-13
 *          Time: 08:11 PM
 */
public interface BillOfMaterialEAO extends GenericEAO<BillOfMaterialEntityObject, Integer> {

    /**
     * Find by Order Identification Id
     *
     * @param orderId, Order Identification Id
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<BillOfMaterialEntityObject> findByOrderId(Integer orderId) throws GenericPersistenceEAOException;

    /**
     * Find Bill of Materials for Batch & Production Line & Station
     *
     * @param batchId,    Batch Identification Id
     * @param prodLineId, Production Line Identification Id
     * @param stationId,  Station Identification Id
     * @param optimized,  Parts only for optimized
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<BillOfMaterialEntityObject> findByBatch(Integer batchId, Integer prodLineId, Integer stationId,
                                                        boolean optimized) throws GenericPersistenceEAOException;

    /**
     * Find by Order Identification Id for Native Query
     *
     * @param orderId, Order Identification Id
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<BillOfMaterialEntityObject> findNativeByOrderId(Integer orderId) throws GenericPersistenceEAOException;

    /**
     * @param orderId, Order Identification Id
     * @param itemNo,  Item Number Identification Id
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<BillOfMaterialEntityObject> findNativeByOrderId(Integer orderId, Integer itemNo) throws GenericPersistenceEAOException;


    /**
     * Find List of Bill of Materials by Job Item
     *
     * @param orderId,   Order Entry Code
     * @param itemId,    Item Code
     * @param versionId, Version Code
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<BillOfMaterialEntityObject> findNativeByOrderId(Integer orderId, Integer itemId, Integer versionId)
            throws GenericPersistenceEAOException;

    /**
     * Find List of Bill of Materials by Code Identification
     *
     * @param orderId,   Order Entry Code
     * @param itemId,    Item Code
     * @param versionId, Version Code
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<BillOfMaterialEntityObject> findByTypeParts(Integer orderId, Integer itemId, Integer versionId, Integer partType)
            throws GenericPersistenceEAOException;

    /**
     * Find by Order Identification Id for Native Query and part types
     *
     * @param orderId, Order Identification Id
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<BillOfMaterialEntityObject> findNativeShipment(Integer orderId) throws GenericPersistenceEAOException;

    /**
     * Find Bill of Materials Stock Codes
     *
     * @param orderId,     Order Identification Id
     * @param itemId,      Item Identification Id
     * @param parentBomId, parent Bom Identification Id
     * @param isGlassBom,  Return Bill of Materials for Glass BOM
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<BillOfMaterialEntityObject> findStockCodes(Integer orderId, Integer itemId, Integer parentBomId, boolean isGlassBom)
            throws GenericPersistenceEAOException;

    /**
     * Find Bill of Materials Aculite Machine
     *
     * @param batchId,   Batch Identification Id
     * @param prodLine,  Production Line
     * @param stationId, Station Id
     * @return List<BillOfMaterialEntityObject>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<BillOfMaterialEntityObject> findGlassAculiteMachine(Integer batchId, Integer prodLine, Integer stationId)
            throws GenericPersistenceEAOException;

    /**
     * Find Bill of Materials for Parts Identification and order status
     *
     * @param dateRequired, Date Required
     * @param partId,       Part Identification Id
     * @param orderStatus,  Order Status
     * @return List<BillOfMaterialEntityObject>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<BillOfMaterialEntityObject> findByPartIdentification(Date dateRequired, Integer partId, Integer orderStatus)
            throws GenericPersistenceEAOException;

    /**
     * Find Bill of Materials using parent assembly
     *
     * @param parentBomId, Parent BOM Identification Id
     * @param stationId,   Station Identification Id
     * @return List<BillOfMaterialEntityObject>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<BillOfMaterialEntityObject> findByParentAssembly(Integer parentBomId, Integer stationId)
            throws GenericPersistenceEAOException;

    /**
     * Find Bill of Materials using parent bom Id
     *
     * @param parentBomId, Parent BOM Identification Id
     * @return List<BillOfMaterialEntityObject>
     * @throws GenericPersistenceEAOException, Exception
     */
    public List<BillOfMaterialEntityObject> findAssemblyByParentBomId(Integer parentBomId) throws GenericPersistenceEAOException;

    /**
     * Find Grids Bill of Materials using parent bom Id
     *
     * @param parentBomId, Parent BOM Identification Id
     * @return List<BillOfMaterialEntityObject>
     * @throws GenericPersistenceEAOException, Exception
     */
    public List<BillOfMaterialEntityObject> findGridsBomByParentBomId(Integer parentBomId) throws GenericPersistenceEAOException;

    /**
     * Find Glass Bill of Materials using parent bom Id
     *
     * @param parentBomIds, Parent BOM Identification Id
     * @return List<BillOfMaterialEntityObject>
     * @throws GenericPersistenceEAOException, Exception
     */
    public List<BillOfMaterialEntityObject> findGlassBomByParentBomId(String parentBomIds) throws GenericPersistenceEAOException;

    /**
     * Return Bill Of Materials Stations By Batch Production Identification
     *
     * @param batchId, Batch Identification
     * @return List<Integer>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<ProductionLineStation> findBOMStationsByBatch(Integer batchId) throws GenericPersistenceEAOException;

    /**
     * Return Bill Of Materials Stations By Batch Production Identification
     *
     * @param batchId, Batch Identification
     * @return List<Integer
     * @throws GenericPersistenceEAOException, Exception
     */
    public List<ProductionLineStation> findBOMStationsFromPartFamily(Integer batchId) throws GenericPersistenceEAOException;

    //******************************************************************************************************************

    /**
     * Find Bill Of Material for Dealer
     *
     * @param orderId,   Order Identification Id
     * @param itemId,    Item Identification Id
     * @param versionId, Version Identification Id
     * @return List<BillOfMaterialEntityObject>
     * @throws GenericPersistenceEAOException, Exception
     */
    public List<BillOfMaterialEntityObject> findForDealer(Integer orderId, Integer itemId, Integer versionId)
            throws GenericPersistenceEAOException;

}

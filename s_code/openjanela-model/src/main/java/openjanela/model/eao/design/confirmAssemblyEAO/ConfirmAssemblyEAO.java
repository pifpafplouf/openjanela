package openjanela.model.eao.design.confirmAssemblyEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.design.ConfirmAssemblyEntityObject;

import java.util.Date;
import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-30-13
 *          Time: 08:12 PM
 */
public interface ConfirmAssemblyEAO extends GenericEAO<ConfirmAssemblyEntityObject, Integer> {

    /**
     * Create Confirm Assemblies
     *
     * @param confirmAssemblies, List<ConfirmAssemblyEntityObject>
     * @throws GenericPersistenceEAOException, Exception
     */
    public void createAssemblies(List<ConfirmAssemblyEntityObject> confirmAssemblies) throws GenericPersistenceEAOException;

    /**
     * Update Confirm Assembly for Batch Launch
     *
     * @param id,         Confirm Assembly Code Id
     * @param batched,    Confirm Assembly is batched
     * @param subBatchId, Sub-Batch Code
     * @param slotNumber, Slot Number
     * @param cartNumber, Cart Number
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public void update(Integer id, Integer batched, Integer subBatchId, Integer slotNumber, Integer cartNumber) throws
            GenericPersistenceEAOException;

    /**
     * Update Confirm Assembly for Batch Launch
     *
     * @param confirmAssemblies, Confirm Assembly Collection
     * @throws GenericPersistenceEAOException, Exception
     */
    public void update(List<ConfirmAssemblyEntityObject> confirmAssemblies) throws GenericPersistenceEAOException;

    /**
     * Update Confirmed Assembly for Shipped
     *
     * @param id,                Confirmed Assembly Identification Code
     * @param assemblyShippedId, Assembly Shipped Id
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public void update(Integer id, int assemblyShippedId) throws GenericPersistenceEAOException;

    /**
     * Update Confirm Assembly for Reject Inspection
     *
     * @param id,           Confirm Assembly Code Id
     * @param typeRejectId, Type Reject Identification
     * @param isRepair,     Indicate if this assembly make a repair
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public void update(Integer id, int typeRejectId, boolean isRepair) throws GenericPersistenceEAOException;

    /**
     * Update Confirm Assembly for Production Dates
     *
     * @param confirmAssemblies, List<ConfirmAssemblyEntityObject>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public void updateProdDates(List<ConfirmAssemblyEntityObject> confirmAssemblies) throws GenericPersistenceEAOException;

    /**
     * Revert Batch Information
     *
     * @param subBatchIds, SubBatch Information Ids
     * @throws GenericPersistenceEAOException, Exception
     */
    public void revertBatch(String subBatchIds) throws GenericPersistenceEAOException;

    /**
     * Find Confirm Assembly by barcode & Production Line & Station
     *
     * @param barcode,    Barcode
     * @param prodLineId, Production Line
     * @param stationId,  Station
     * @param useStation, Use specific station to find barcode
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<ConfirmAssemblyEntityObject> findByBarcode(String barcode, Integer prodLineId, Integer stationId,
                                                           boolean useStation) throws GenericPersistenceEAOException;

    /**
     * Find Confirm Assembly by Item barcode
     *
     * @param barcode, Item Barcode
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<ConfirmAssemblyEntityObject> findByItemBarcode(String barcode) throws GenericPersistenceEAOException;

    /**
     * Find Confirm Assembly Shipped by Item barcode
     *
     * @param barcode, Item Barcode
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<ConfirmAssemblyEntityObject> findByItemBarcodeShipped(String barcode) throws GenericPersistenceEAOException;

    /**
     * Find Confirm Assembly by Item barcode
     *
     * @param barcode, Item Barcode
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<ConfirmAssemblyEntityObject> findAssembliesByItemBarcode(String barcode) throws GenericPersistenceEAOException;

    /**
     * Find Child Assemblies for an Assembly using his BOM Identification
     *
     * @param bomId, Bill of Material Identification
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<ConfirmAssemblyEntityObject> findChildAssemblies(Integer orderId, Integer itemId, Integer versionId,
                                                                 Integer qtyNo, Integer ofQty, Integer bomId)
            throws GenericPersistenceEAOException;

    /**
     * Find Confirm Assemblies for Order Identification Id
     *
     * @param orderId, OrderId
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<ConfirmAssemblyEntityObject> findByOrderId(Integer orderId) throws GenericPersistenceEAOException;

    /**
     * Find Confirm Assemblies for Order Identification Id with a native query
     *
     * @param orderId, orderId
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<ConfirmAssemblyEntityObject> findNativeByOrderId(Integer orderId) throws GenericPersistenceEAOException;

    /**
     * Find Confirm Assemblies for Bill of Materials Id
     *
     * @param bomId, Bill of Materials Id
     * @return List<ConfirmAssemblyEntityObject>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<ConfirmAssemblyEntityObject> findNativeByBomId(Integer bomId) throws GenericPersistenceEAOException;

    /**
     * Find Confirm Assemblies for an specific order and Item No.
     *
     * @param orderId,    Order Identification Code
     * @param itemNo,     Item Number Identification
     * @param assemblyId, Assembly Identification
     * @param shiftId,    Shift Identification
     * @param leafNo,     Leaf Number Indentification
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<ConfirmAssemblyEntityObject> findByAssembly(Integer orderId, Integer itemNo, Integer assemblyId,
                                                            Integer shiftId, Integer leafNo) throws GenericPersistenceEAOException;

    /**
     * Find Confirm Assemblies for an specific order that has not been batch
     *
     * @param orderId, Order Identification Code
     * @param itemNo,  Item Number Identification
     * @param ofQty,   Quantity Number
     * @param shift,   Shift
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<ConfirmAssemblyEntityObject> findNotBatched(Integer orderId, Integer itemNo, Integer ofQty, Integer shift)
            throws GenericPersistenceEAOException;

    /**
     * Find Confirm Assemblies for an specific order that has not been batch
     *
     * @param orderId, Order Identification Code
     * @param itemNo,  Item Number Identification
     * @param qtyNo,   Quantity Number
     * @param ofQty,   Of Quantity Number
     * @param shift,   Shift
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<ConfirmAssemblyEntityObject> findNotBatched(Integer orderId, Integer itemNo, Integer qtyNo, Integer ofQty,
                                                            Integer shift) throws GenericPersistenceEAOException;

    /**
     * Find Confirm Assemblies batch for Order Identification Id
     *
     * @param orderId, Order Identification Id
     * @return List
     * @throws GenericPersistenceEAOException, Exception
     */
    public List<ConfirmAssemblyEntityObject> findBatched(Integer orderId) throws GenericPersistenceEAOException;

    /**
     * Find Confirm Assemblies batched for production
     *
     * @param subBatches, SubBatches Collection
     * @return List<ConfirmAssemblyEntityObject>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<ConfirmAssemblyEntityObject> findBatched(List<Integer> subBatches) throws GenericPersistenceEAOException;

    /**
     * Find Confirm Assemblies batched for production
     *
     * @param prodLineId, Production Line Identification Id
     * @param stationId,  Station Identification Id
     * @param shift,      Shift Identification Id
     * @param fromDate,   From Date released to production
     * @param toDate,     To Date released to production
     * @param groupQty,   Group quantity
     * @return List<ConfirmAssemblyEntityObject>
     */
    public List<ConfirmAssemblyEntityObject> findBatched(Integer prodLineId, Integer stationId, Integer shift, Date fromDate,
                                                         Date toDate, boolean groupQty) throws GenericPersistenceEAOException;

    /**
     * Retrieve Confirm Assemblies
     *
     * @param subBatches, SubBatches collection
     * @param groupQty,   Group quantity
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<ConfirmAssemblyEntityObject> retrieveConfirmAssemblies(List<Integer> subBatches, boolean groupQty)
            throws GenericPersistenceEAOException;

    /**
     * Retrieve Confirm Assemblies
     *
     * @param orderNumber,   Order Entry Number
     * @param prodLine,      Production Line
     * @param prodStartDate, Production Start Date
     * @param onOrBefore,    On or Before
     * @param shifts,        Collection of Shits
     * @param groupQty,      Group Quantities
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<ConfirmAssemblyEntityObject> retrieveConfirmAssemblies(Integer orderNumber, Integer prodLine, Date prodStartDate,
                                                                       boolean onOrBefore, List<String> shifts,
                                                                       boolean groupQty) throws GenericPersistenceEAOException;

    /**
     * Retrieve Confirm Assemblies
     *
     * @param subBatchId, Sub-Batch Identification Id
     * @return List<ConfirmAssemblyEntityObject>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<ConfirmAssemblyEntityObject> retrieveConfirmAssemblies(Integer subBatchId)
            throws GenericPersistenceEAOException;

    /**
     * Delete Confirm Assemblies for Order Entry Code
     *
     * @param orderId, Order Entry Code
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public void deleteForOrderEntry(Integer orderId) throws GenericPersistenceEAOException;

    /**
     * Remove Confirm Assembly Object
     *
     * @param orderId,   Order Identification Id
     * @param itemNo,    Item Identification Number
     * @param versionNo, Version Identification Number
     * @param qtyNo,     Quantity Number
     * @param ofQty,     Of Quantity Number
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public void removeConfirmAssembly(int orderId, int itemNo, int versionNo, int qtyNo, int ofQty) throws
            GenericPersistenceEAOException;

    /**
     * Delete Comfirm Assemblies for Order Identification
     *
     * @param orderId,   Order Identification Code
     * @param versionId, Version Identification Id
     * @throws GenericPersistenceEAOException, Exception
     */
    public void deleteForOrderEntry(Integer orderId, Integer versionId) throws GenericPersistenceEAOException;

}

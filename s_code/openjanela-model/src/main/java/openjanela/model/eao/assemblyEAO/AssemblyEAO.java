package openjanela.model.eao.assemblyEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.design.AssemblyEntityObject;

import java.util.List;

/**
 * Copyright (c) 2013, OpenJanela. All rights reserved.
 * User: Eddy Montenegro
 * Date: 02-26-13
 * Time: 08:48 PM
 */
public interface AssemblyEAO extends GenericEAO<AssemblyEntityObject, Integer> {

    /**
     * Update Quantity for Assemblies
     * @param orderId, Order Identification Id
     * @param itemId, Item Identification Id
     * @param versionId, Version Identification Id
     * @param qty, Quantity Number
     * @throws GenericPersistenceEAOException, Exception
     */
    public void updateQuantity(Integer orderId, Integer itemId, Integer versionId, Integer qty) throws GenericPersistenceEAOException;

    /**
     * Find Assembly Collection by Order Code
     *
     * @param orderID, Order Identification Id
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<AssemblyEntityObject> findByOrderId(Integer orderID) throws GenericPersistenceEAOException;

    /**
     * Find Supplier Item Assembly by Order Code
     *
     * @param orderID, Order Identification Id
     * @return List
     * @throws GenericPersistenceEAOException, Exception
     */
    public List<AssemblyEntityObject> findSupplierItemAssemblyByOrderId(Integer orderID) throws GenericPersistenceEAOException;
}

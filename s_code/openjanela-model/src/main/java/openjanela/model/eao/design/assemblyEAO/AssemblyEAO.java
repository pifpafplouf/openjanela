package openjanela.model.eao.design.assemblyEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.design.AssemblyEntityObject;
import openjanela.model.entities.design.ConfirmAssemblyEntityObject;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-30-13
 *          Time: 08:10 PM
 */
public interface AssemblyEAO extends GenericEAO<AssemblyEntityObject, Integer> {

    /**
     * Find Assembly Entity Object Collection
     *
     * @param orderId,   Order Identification Id
     * @param itemId,    Item Identification Id
     * @param versionId, Version Identification Id
     * @return List<AssemblyEntityObject>
     * @throws GenericPersistenceEAOException, Exception
     */
    public List<AssemblyEntityObject> findByOrderItem(int orderId, int itemId, int versionId) throws GenericPersistenceEAOException;

    /**
     * Find Child Assemblies for an Assembly using his BOM Identification
     *
     * @param bomId, Bill of Material Identification
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<AssemblyEntityObject> findChildAssemblies(Integer orderId, Integer itemId, Integer versionId, Integer bomId)
            throws GenericPersistenceEAOException;


}

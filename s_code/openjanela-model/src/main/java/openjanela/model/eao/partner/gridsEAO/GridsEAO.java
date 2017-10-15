
package openjanela.model.eao.partner.gridsEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.Grids;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-30-12
 *          Time: 10:28 PM
 */
public interface GridsEAO extends GenericEAO<Grids, Integer> {

    /**
     * Find All Remote Grids Matrix
     *
     * @return List<Grids>
     * @throws GenericPersistenceEAOException, Exception
     */
    public List<Integer> findAllMatrix() throws GenericPersistenceEAOException;

    /**
     * Find All Remote Grids Matrix
     *
     * @param supplierId, Supplier Identification Id
     * @return List<Grids>
     * @throws GenericPersistenceEAOException, Exception
     */
    public List<Integer> findAllRemoteMatrix(int supplierId) throws GenericPersistenceEAOException;

    /**
     * Find All Remote Grids
     *
     * @param supplierId, Supplier Identification Id
     * @return List<Grids>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<Grids> findAllRemote(int supplierId) throws GenericPersistenceEAOException;


}

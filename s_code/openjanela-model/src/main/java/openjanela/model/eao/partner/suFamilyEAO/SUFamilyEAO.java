package openjanela.model.eao.partner.suFamilyEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.SUFamily;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 09-18-12
 *          Time: 09:24 AM
 */
public interface SUFamilyEAO extends GenericEAO<SUFamily, Integer> {

    /**
     * Find SUFamily order by Identification
     *
     * @return List<SUFamily></SUFamily>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<SUFamily> findAllOrderById() throws GenericPersistenceEAOException;

    /**
     * Find Remote SUFamily order by Identification Id
     *
     * @param supplierId, Supplier Identification Id
     * @return List<SUFamily>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<SUFamily> findAllRemoteOrderById(int supplierId) throws GenericPersistenceEAOException;
}

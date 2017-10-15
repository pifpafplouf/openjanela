package openjanela.model.eao.partner.partsFamilyEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.parts.PartsFamily;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-30-12
 *          Time: 10:28 PM
 */
public interface PartsFamilyEAO extends GenericEAO<PartsFamily, Integer> {

    /**
     * Find All Parts Family Remote
     *
     * @param supplierId, Supplier Identification Id
     * @return List<Parts>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<PartsFamily> findAllRemote(int supplierId) throws GenericPersistenceEAOException;

}

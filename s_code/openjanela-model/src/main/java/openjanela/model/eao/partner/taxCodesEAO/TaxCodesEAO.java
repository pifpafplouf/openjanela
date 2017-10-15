package openjanela.model.eao.partner.taxCodesEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.TaxCodes;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 09-01-13
 *          Time: 09:57 PM
 */
public interface TaxCodesEAO extends GenericEAO<TaxCodes, Integer> {

    /**
     * Find Tax Code Remote by Identification Id
     *
     * @param supplierId, Supplier Identification Id
     * @param taxId,      Tax Identification Id
     * @return TaxCodes
     * @throws GenericPersistenceEAOException, Exception
     */
    public TaxCodes findRemoteById(Integer supplierId, Integer taxId) throws GenericPersistenceEAOException;
}

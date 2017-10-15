package openjanela.model.eao.admin.companyPreferencesEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.CompanyPreferences;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 07-30-12
 * Time: 10:28 PM
 */
public interface CompanyPreferencesEAO extends GenericEAO<CompanyPreferences, Integer> {

    /**
     * Return Company Preferences
     *
     * @return CompanyPreferences
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public CompanyPreferences getPref() throws GenericPersistenceEAOException;

    /**
     * Retrieve Next Order Number Remote
     *
     * @param supplierId, Supplier Identification Id
     * @param docType,    Document Type
     * @return int
     * @throws GenericPersistenceEAOException, Exception
     */
    public int getNextOrderNumberRemote(Integer supplierId, Integer docType) throws GenericPersistenceEAOException;
}

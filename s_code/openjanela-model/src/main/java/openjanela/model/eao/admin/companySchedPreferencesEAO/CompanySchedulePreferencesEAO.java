package openjanela.model.eao.admin.companySchedPreferencesEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.CompanySchedulePreferences;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.2
 *          Date: 3/16/14
 *          Time: 8:08 PM
 */
public interface CompanySchedulePreferencesEAO extends GenericEAO<CompanySchedulePreferences, Integer> {

    /**
     * Find Remote Company Schedule Preferences
     *
     * @param supplierId, Supplier Identification Id
     * @return CompanySchedulePreferences
     * @throws GenericPersistenceEAOException, Exception
     */
    public CompanySchedulePreferences findRemote(Integer supplierId) throws GenericPersistenceEAOException;
}

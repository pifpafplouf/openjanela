package openjanela.model.eao.partner.partnerSchedulingPreferencesEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.PartnerSchedulingPreferences;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 09-01-13
 *          Time: 09:31 PM
 */
public interface PartnerSchedulingPreferencesEAO extends GenericEAO<PartnerSchedulingPreferences, Integer> {

    /**
     * Find Remote Scheduling Preferences
     *
     * @param supplierId, Supplier Identification Id
     * @param customerId, Customer Identification Id
     * @param isSupplier, Supplier Identification Id
     * @return PartnerSchedulingPreferences
     * @throws GenericPersistenceEAOException, Exception
     */
    public PartnerSchedulingPreferences findRemoteSchedulePref(int supplierId, int customerId, boolean isSupplier)
            throws GenericPersistenceEAOException;
}

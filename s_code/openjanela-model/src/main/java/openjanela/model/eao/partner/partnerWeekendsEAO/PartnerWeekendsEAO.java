package openjanela.model.eao.partner.partnerWeekendsEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.PartnerWeekends;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 09-01-13
 *          Time: 09:57 PM
 */
public interface PartnerWeekendsEAO extends GenericEAO<PartnerWeekends, Integer> {

    /**
     * Find Remote Weekends
     *
     * @param supplierId, Supplier Identification Id
     * @param customerId, Customer Identification Id
     * @param isSupplier, Is Supplier
     * @return PartnerWeekends
     * @throws GenericPersistenceEAOException, Exception
     */
    public PartnerWeekends findRemoteWeekends(int supplierId, int customerId, boolean isSupplier) throws GenericPersistenceEAOException;
}

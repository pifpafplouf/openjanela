package openjanela.model.eao.partner.PartnerHolidaysEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.PartnerHolidays;
import openjanela.model.entities.partner.PartnerHolidaysPK;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 09-01-13
 *          Time: 09:57 PM
 */
public interface PartnerHolidaysEAO extends GenericEAO<PartnerHolidays, PartnerHolidaysPK> {

    /**
     * Find Remote Partner Holidays
     *
     * @param supplierId, Supplier Identification Id
     * @param customerId, Customer Identification Id
     * @param isSupplier, Supplier
     * @return List<PartnerHolidays>
     * @throws GenericPersistenceEAOException, Exception
     */
    public List<PartnerHolidays> findRemotePartnerHolidays(int supplierId, int customerId, boolean isSupplier)
            throws GenericPersistenceEAOException;
}

package openjanela.model.eao.partner.typePartnerEAO;

import java.util.List;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.TypePartner;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-25-12
 *          Time: 02:27 PM
 */
public interface TypePartnerEAO extends GenericEAO<TypePartner, Integer> {

    /**
     * Find Remote Allowed Cancellation Period
     *
     * @param supplierId, Supplier Identification Id
     * @param partnerId,  Partner Identification Id
     * @return int
     * @throws Exception, Exception
     */
    public int getRemoteAllowedCancellationPeriod(Integer supplierId, Integer partnerId) throws Exception;

	public List<TypePartner> findBySystemType(Integer type) throws GenericPersistenceEAOException;

	public List<TypePartner> findProspects() throws GenericPersistenceEAOException;
}

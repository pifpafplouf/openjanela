package openjanela.model.eao.partner.partnerAddressEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.PartnerAddress;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.1
 *          Date: 07-25-12
 *          Time: 09:35 AM
 */
public interface PartnerAddressEAO extends GenericEAO<PartnerAddress, Integer> {

    /**
     * Find Remote Ship To Address
     *
     * @param supplierId, Supplier Identification Id
     * @param partnerId,  Partner identification Id
     * @return PartnerAddress
     * @throws GenericPersistenceEAOException, Exception
     */
    public PartnerAddress findRemoteShipToAddress(Integer supplierId, Integer partnerId) throws GenericPersistenceEAOException;

    /**
     * Find Remote Bill To Address
     *
     * @param supplierId, Supplier Identification Id
     * @param partnerId,  Partner Identification Id
     * @return PartnerAddress
     * @throws GenericPersistenceEAOException, Exception
     */
    public PartnerAddress findRemoteBillToAddress(Integer supplierId, Integer partnerId) throws GenericPersistenceEAOException;
}

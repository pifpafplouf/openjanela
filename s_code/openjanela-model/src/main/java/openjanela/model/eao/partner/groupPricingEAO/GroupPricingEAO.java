package openjanela.model.eao.partner.groupPricingEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.GroupPricing;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 12-17-12
 *          Time: 11:50 PM
 */
public interface GroupPricingEAO extends GenericEAO<GroupPricing, Integer> {

    /**
     * Find Remote Group Pricing
     *
     * @param supplierId,     Supplier Identification Id
     * @param groupPricingId, Group Pricing Identification Id
     * @return GroupPricing
     * @throws GenericPersistenceEAOException, Exception
     */
    public GroupPricing findRemoteGroupPricing(Integer supplierId, Integer groupPricingId) throws GenericPersistenceEAOException;


}

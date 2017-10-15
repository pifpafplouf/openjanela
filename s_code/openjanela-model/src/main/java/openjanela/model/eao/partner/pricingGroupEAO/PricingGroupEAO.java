package openjanela.model.eao.partner.pricingGroupEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.orderEntry.PricingGroup;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 10-12-12
 *          Time: 09:59 AM
 */
public interface PricingGroupEAO extends GenericEAO<PricingGroup, Integer> {

    /**
     * Find All Remote Pricing Group
     *
     * @param supplierId, Supplier Identification Id
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<PricingGroup> findAllRemote(int supplierId) throws GenericPersistenceEAOException;
}

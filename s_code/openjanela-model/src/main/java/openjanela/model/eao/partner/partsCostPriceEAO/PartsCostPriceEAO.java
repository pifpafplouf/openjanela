package openjanela.model.eao.partner.partsCostPriceEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.parts.PartsCostPrice;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-30-12
 *          Time: 10:28 PM
 */
public interface PartsCostPriceEAO extends GenericEAO<PartsCostPrice, Integer> {

    /**
     * Find All Remote Parts Cost Price
     *
     * @param supplierId, Supplier Identification Id
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<PartsCostPrice> findAllRemote(int supplierId) throws GenericPersistenceEAOException;

}

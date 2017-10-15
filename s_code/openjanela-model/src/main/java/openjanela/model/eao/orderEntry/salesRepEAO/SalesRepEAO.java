package openjanela.model.eao.orderEntry.salesRepEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.orderEntry.SalesRep;

/**
 * Copyright(c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-17-13
 *          Time: 04:03 PM
 */
public interface SalesRepEAO extends GenericEAO<SalesRep, Integer> {

    /**
     * Find Remote Sales Rep
     *
     * @param supplierId, Supplier Identification Id
     * @param salesRepId, Sales Representation Id
     * @return SalesRep
     * @throws GenericPersistenceEAOException, Exception
     */
    public SalesRep findRemote(Integer supplierId, Integer salesRepId) throws GenericPersistenceEAOException;

}

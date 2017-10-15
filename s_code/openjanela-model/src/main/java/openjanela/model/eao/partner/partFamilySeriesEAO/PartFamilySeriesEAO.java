package openjanela.model.eao.partner.partFamilySeriesEAO;

import java.util.List;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.PartnerDefault;
import openjanela.model.entities.parts.PartFamilySeries;
import openjanela.model.entities.parts.PartsFamily;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-30-12
 *          Time: 10:28 PM
 */
public interface PartFamilySeriesEAO extends GenericEAO<PartFamilySeries, Integer> {

    /**
     * Return Part Families by Series
     *
     * @param sid, Series Identification Id
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<PartFamilySeries> findBySeries(int sid) throws GenericPersistenceEAOException;

    /**
     * Return All Remote Part Family Series
     *
     * @param supplierId, Supplier Identification Id
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<PartFamilySeries> findAllRemote(int supplierId) throws GenericPersistenceEAOException;
}

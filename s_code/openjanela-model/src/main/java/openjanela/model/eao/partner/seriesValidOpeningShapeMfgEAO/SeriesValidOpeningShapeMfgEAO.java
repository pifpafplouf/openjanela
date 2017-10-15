package openjanela.model.eao.partner.seriesValidOpeningShapeMfgEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.SeriesValidOpeningShapeMfg;
import openjanela.model.entities.partner.SeriesValidOpeningShapeMfgPK;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.2
 *          Date: 02-20-14
 *          Time: 10:27 AM
 */
public interface SeriesValidOpeningShapeMfgEAO extends GenericEAO<SeriesValidOpeningShapeMfg, SeriesValidOpeningShapeMfgPK> {

    /**
     * Return a List of Series Valid Opening Shapes Manufacturing
     *
     * @param seriesId, Series Identification Id
     * @return List
     * @throws GenericPersistenceEAOException, Exception
     */
    List<SeriesValidOpeningShapeMfg> findBySeriesId(int seriesId) throws GenericPersistenceEAOException;

    /**
     * Find Valid Openings by seriesId
     *
     * @param seriesId,   Series Identification Id
     * @param supplierId, Supplier Identification Id
     * @return List<SeriesValidOpeningShapeMfg>
     * @throws GenericPersistenceEAOException, Exception
     */
    public List<SeriesValidOpeningShapeMfg> findRemoteValidOpeningsBySeriesId(Integer seriesId, Integer supplierId)
            throws GenericPersistenceEAOException;

}

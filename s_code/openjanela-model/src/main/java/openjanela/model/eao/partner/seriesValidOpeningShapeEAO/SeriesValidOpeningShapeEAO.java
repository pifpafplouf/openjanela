package openjanela.model.eao.partner.seriesValidOpeningShapeEAO;

import java.util.List;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.genericEAO.PersistenceClassNotFoundException;
import openjanela.model.entities.partner.SeriesValidOpeningShape;
import openjanela.model.entities.partner.SeriesValidOpeningShapePK;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 10-04-12
 *          Time: 09:59 AM
 */
public interface SeriesValidOpeningShapeEAO extends GenericEAO<SeriesValidOpeningShape, SeriesValidOpeningShapePK> {

    /**
     * Find Valid Openings by seriesId
     *
     * @param seriesId, Integer
     * @return List<SeriesValidOpeningShape>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<SeriesValidOpeningShape> findValidOpeningsBySeriesId(Integer seriesId) throws GenericPersistenceEAOException;

    /**
     * Find User Defined Opening by Opening Identification and Series Identification
     *
     * @param openingId, Opening Identification Id
     * @param seriesId,  Series Identification Id
     * @return SeriesValidOpeningShape
     * @throws openjanela.model.eao.genericEAO.PersistenceClassNotFoundException,
     *          Exception
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public SeriesValidOpeningShape findUDOpening(int openingId, int seriesId) throws PersistenceClassNotFoundException,
            GenericPersistenceEAOException;

    /**
     * Find Valid Openings by seriesId
     *
     * @param seriesId,   Series Identification Id
     * @param supplierId, Supplier Identification Id
     * @return List<SeriesValidOpeningShape>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<SeriesValidOpeningShape> findRemoteValidOpeningsBySeriesId(Integer seriesId, Integer supplierId)
            throws GenericPersistenceEAOException;
}

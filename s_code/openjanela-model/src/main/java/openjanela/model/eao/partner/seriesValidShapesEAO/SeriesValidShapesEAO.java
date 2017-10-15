package openjanela.model.eao.partner.seriesValidShapesEAO;

import java.util.List;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.SeriesValidShapes;
import openjanela.model.entities.partner.SeriesValidShapesPK;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 08-28-12
 *          Time: 03:00 PM
 */
public interface SeriesValidShapesEAO extends GenericEAO<SeriesValidShapes, SeriesValidShapesPK> {

    /**
     * Find valid shapes by series Identification
     *
     * @param seriesId, Integer
     * @return List<SeriesValidShapes>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<SeriesValidShapes> findValidShapesBySeriesId(Integer seriesId) throws GenericPersistenceEAOException;

    /**
     * Find a valid Shape by his Identification Id
     *
     * @param id, shape Identification Id
     * @return SeriesValidShapes
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public SeriesValidShapes getShape(int id) throws GenericPersistenceEAOException;

    /**
     * Find valid shapes by series Identification
     *
     * @param seriesId,   Series Identification Id
     * @param supplierId, Supplier Identification Id
     * @return List<SeriesValidShapes>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<SeriesValidShapes> findRemoteValidShapesBySeriesId(Integer seriesId, Integer supplierId)
            throws GenericPersistenceEAOException;
}

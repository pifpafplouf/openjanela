package openjanela.model.eao.partner.seriesValidOpeningsEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.SeriesValidOpenings;
import openjanela.model.entities.partner.SeriesValidOpeningsPK;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 08-30-12
 *          Time: 09:29 AM
 */
public interface SeriesValidOpeningsEAO extends GenericEAO<SeriesValidOpenings, SeriesValidOpeningsPK> {

    /**
     * Find valid Shapes by series Identification
     *
     * @param seriesId, Integer
     * @return List<SeriesValidOpenings>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<SeriesValidOpenings> findValidOpeningsBySeriesId(Integer seriesId) throws GenericPersistenceEAOException;
}

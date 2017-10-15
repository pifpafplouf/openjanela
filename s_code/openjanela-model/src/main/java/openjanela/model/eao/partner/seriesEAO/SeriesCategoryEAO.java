package openjanela.model.eao.partner.seriesEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.SeriesCategory;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-30-12
 *          Time: 10:28 PM
 */
public interface SeriesCategoryEAO extends GenericEAO<SeriesCategory, Integer> {

    /**
     * Find Series Category by series identification
     *
     * @param seriesId, Series Identification Id
     * @return SeriesCategory
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public SeriesCategory findCategory(int seriesId) throws GenericPersistenceEAOException;


}

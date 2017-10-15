package openjanela.model.eao.partner.seriesAllowedSUThickEAO;

import java.util.List;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.genericEAO.PersistenceClassNotFoundException;
import openjanela.model.entities.partner.SeriesAllowedSUThick;
import openjanela.model.entities.partner.SeriesAllowedSUThickPK;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 09-13-12
 *          Time: 04:22 PM
 */
public interface SeriesAllowedSUThickEAO extends GenericEAO<SeriesAllowedSUThick, SeriesAllowedSUThickPK> {

    /**
     * Find Series Allowed SU Thick by series Identification
     *
     * @param seriesId, Series identification
     * @return SeriesAllowedSUThick
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<SeriesAllowedSUThick> findBySeries(Integer seriesId) throws GenericPersistenceEAOException;

    /**
     * Find Series Remote Allowed SU Thick by series Identification
     *
     * @param seriesId, Series Identification
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<SeriesAllowedSUThick> findRemoteBySeries(Integer seriesId, Integer supplierId) throws GenericPersistenceEAOException;
}

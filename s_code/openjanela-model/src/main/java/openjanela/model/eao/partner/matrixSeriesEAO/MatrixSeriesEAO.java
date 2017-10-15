package openjanela.model.eao.partner.matrixSeriesEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.Matrix;
import openjanela.model.entities.partner.MatrixSeries;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 10-22-12
 *          Time: 09:35 PM
 */
public interface MatrixSeriesEAO extends GenericEAO<MatrixSeries, Integer> {

    /**
     * Find All Matrix Identification
     *
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<Integer> findAllSeries() throws GenericPersistenceEAOException;

    /**
     * Return list of matrix by series
     *
     * @param seriesId, Series Identification Id
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<Integer> findBySeries(int seriesId) throws GenericPersistenceEAOException;

    /**
     * Return List of Matrix by Series
     *
     * @param seriesId,   Series Identification Id
     * @param supplierId, Supplier Identification Id
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<Integer> findByRemoteSeries(int seriesId, int supplierId) throws GenericPersistenceEAOException;

}

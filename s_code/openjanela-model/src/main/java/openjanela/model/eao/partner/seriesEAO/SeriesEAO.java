package openjanela.model.eao.partner.seriesEAO;

import java.util.List;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.Series;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-30-12
 *          Time: 10:28 PM
 */
public interface SeriesEAO extends GenericEAO<Series, Integer> {

    /**
     * Find all series for suppliers
     *
     * @param supplierId, Integer
     * @return List<Series>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<Series> findAllSeriesForSuppliers(Integer supplierId) throws GenericPersistenceEAOException;

    /**
     * Find All series sub-routines
     *
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<Series> findAllSeriesSubRoutines() throws GenericPersistenceEAOException;

    /**
     * Find All Series Sub-Routines
     *
     * @param inClause, In Clause Values
     * @return List<Series>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<Series> findAllSeriesSubRoutines(String inClause) throws GenericPersistenceEAOException;

    /**
     * Find Remote Series By Identification Id
     *
     * @param seriesId,   Series Identification Id
     * @param supplierId, Supplier Identification Id
     * @return Series
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public Series findRemoteById(Integer seriesId, Integer supplierId) throws GenericPersistenceEAOException;

    /**
     * Find All Remote Series Sub-Routines
     *
     * @param inClause,   In Clause Values
     * @param supplierId, Supplier Identification Id
     * @return List<Series>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<Series> findAllRemoteSeriesSubRoutines(String inClause, Integer supplierId) throws GenericPersistenceEAOException;

    /**
     * Find all suppliers for series
     *
     * @return List<Integer>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<Integer> findAllSuppliersForSeries() throws GenericPersistenceEAOException;

}


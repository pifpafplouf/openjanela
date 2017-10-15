package openjanela.model.eao.partner.rulesEAO;

import java.util.List;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.Rules;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-30-12
 *          Time: 10:28 PM
 */
public interface RulesEAO extends GenericEAO<Rules, Integer> {

    /**
     * Find all series for suppliers
     *
     * @param seriesId, Integer
     * @return List<Series>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<Rules> findAllOptionRulesbySeries(Integer seriesId) throws GenericPersistenceEAOException;

    /**
     * Find rules by series
     *
     * @param seriesId, Series Identification
     * @return List<Rules></Rules>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<Rules> findAllRulesbySeries(Integer seriesId) throws GenericPersistenceEAOException;

    /**
     * Find All Series Segments from Rules
     *
     * @param seriesId, Series Identification Id
     * @return List<Integer>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<Integer> findAllSeriesSegments(Integer seriesId) throws GenericPersistenceEAOException;

    /**
     * Find Matrix Ids by Series
     *
     * @param seriesId, Series Identification Id
     * @return List<Integer>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<Integer> findMatrixIdsBySeries(String seriesId) throws GenericPersistenceEAOException;

    /**
     * Find Parts Cost Price Matrix Ids by Series
     *
     * @param seriesId, Series Identification Id
     * @return List<Integer>
     * @throws GenericPersistenceEAOException, Exception
     */
    public List<Integer> findPartsCostPriceMatrixIdsBySeries(String seriesId) throws GenericPersistenceEAOException;

    /**
     * Find Remote Parts Cost Price Matrix by Series
     *
     * @param seriesId,   Series Identification Id
     * @param supplierId, Supplier Identification Id
     * @return List<Integer>
     * @throws GenericPersistenceEAOException, Exception
     */
    public List<Integer> findRemotePartsCostPriceMatrixIdsBySeries(String seriesId, Integer supplierId) throws GenericPersistenceEAOException;

    /**
     * Find Remote Matrix Ids by Series Identification
     *
     * @param seriesId,   Series Identification Id
     * @param supplierId, Supplier Identification Id
     * @return List<Integer>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<Integer> findRemoteMatrixIdsBySeries(String seriesId, Integer supplierId) throws GenericPersistenceEAOException;

    /**
     * Find All Remote Series Segments
     *
     * @param seriesId, Series Identification Id
     * @return
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException
     */
    public List<Integer> findAllRemoteSeriesSegments(Integer seriesId, Integer supplierId) throws GenericPersistenceEAOException;

    /**
     * Find All Remote Option Rules By Series
     *
     * @param seriesId,   Series Identification Id
     * @param supplierId, Supplier Identification Id
     * @return List<Rules>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<Rules> findAllRemoteOptionRulesBySeries(Integer seriesId, Integer supplierId) throws GenericPersistenceEAOException;

    /**
     * Find All Remote Rules from Series
     *
     * @param seriesId,   Series Identification Id
     * @param supplierId, Supplier Identification Id
     * @return List<Rules>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<Rules> findAllRemoteRulesBySeries(Integer seriesId, Integer supplierId) throws GenericPersistenceEAOException;
}

package openjanela.model.eao.partner.matrixHeaderEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.MatrixHeader;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 10-22-12
 *          Time: 09:35 PM
 */
public interface MatrixHeaderEAO extends GenericEAO<MatrixHeader, Integer> {

    /**
     * Find matrix header by series
     *
     * @param seriesId, Series Identification Id
     * @return List<MatrixHeader></MatrixHeader>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<MatrixHeader> findSubMatrixByTypeSeries(int seriesId) throws GenericPersistenceEAOException;

    /**
     * Return all matrix headers by series
     *
     * @param inClause, Clause collection
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<MatrixHeader> findAllBySeries(String inClause) throws GenericPersistenceEAOException;
    
    /**
     * Return all matrix headers by type
     *
     * @param type
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException
     */
    public List<MatrixHeader> findAllByType(Integer type) throws GenericPersistenceEAOException;

    /**
     * Return all commission matrix headers
     *
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<MatrixHeader> findAllCommission() throws GenericPersistenceEAOException;

    /**
     * Return All Matrix Remote by Series
     *
     * @param inClause,   Clause collection
     * @param supplierId, Supplier Identification Id
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<MatrixHeader> findAllRemoteBySeries(String inClause, int supplierId) throws GenericPersistenceEAOException;
}

package openjanela.model.eao.partner.matrixEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.Matrix;
import openjanela.model.entities.partner.MatrixPK;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 10-22-12
 *          Time: 09:35 PM
 */
public interface MatrixEAO extends GenericEAO<Matrix, MatrixPK> {

    /**
     * Find Matrix value by Identification Id
     *
     * @param matrixId, Matrix Identification Id
     * @return List<Matrix>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<Matrix> findMatrixCellsById(Integer matrixId) throws GenericPersistenceEAOException;

    /**
     * Return Matrix by series Identification Id
     *
     * @param inClause, Collection String of series
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<Matrix> findAllBySeries(String inClause) throws GenericPersistenceEAOException;

    /**
     * Return Matrix by series Identification Id
     *
     * @param inClause, Collection String of matrix Ids
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<Matrix> findAllByHeaders(String inClause) throws GenericPersistenceEAOException;

    /**
     * Return Matrix Remote by series Identification Id
     *
     * @param inClause,   Collection String of series
     * @param supplierId, Supplier Identification Id
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<Matrix> findAllRemoteBySeries(String inClause, int supplierId) throws GenericPersistenceEAOException;
}

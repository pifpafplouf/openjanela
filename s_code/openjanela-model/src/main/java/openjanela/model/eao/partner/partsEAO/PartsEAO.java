package openjanela.model.eao.partner.partsEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.parts.Parts;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 09-21-12
 *          Time: 10:10 AM
 */
public interface PartsEAO extends GenericEAO<Parts, Integer> {

    /**
     * Find All Native Query
     *
     * @return List<Parts>
     * @throws GenericPersistenceEAOException, Exception
     */
    public List<Parts> findAllReadOnly() throws GenericPersistenceEAOException;

    /**
     * Find by part type
     *
     * @param partType, Part type
     * @return List<Parts></Parts>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<Parts> findByPartType(int partType) throws GenericPersistenceEAOException;

    /**
     * Find All Parts Remote
     *
     * @param supplierId, Supplier Identification Id
     * @return List<Parts>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<Parts> findAllRemote(int supplierId) throws GenericPersistenceEAOException;

    /**
     * Find Remote Part by StockCode
     *
     * @param supplierId, Supplier Identification Id
     * @param stockCode,  Stock Code Identification Id
     * @return Parts
     * @throws GenericPersistenceEAOException, Exception
     */
    public Parts findRemoteByStockCode(Integer supplierId, String stockCode) throws GenericPersistenceEAOException;
}

package openjanela.model.eao.partner.productionLineEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.ProductionLine;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 11-13-12
 *          Time: 11:52 PM
 */
public interface ProductionLineEAO extends GenericEAO<ProductionLine, Integer> {

    /**
     * Find all production lines order by primary key
     *
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<ProductionLine> findAllOrderByPrimaryKey() throws GenericPersistenceEAOException;

    /**
     * Find by Virtual, Active and GlassLine true values order by identification Id.
     *
     * @return List<ProductionLine>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<ProductionLine> findAllOrderById() throws GenericPersistenceEAOException;

    /**
     * Find All Production Lines By Identification Id
     *
     * @param supplierId, Supplier Identification Id
     * @return List<ProductionLine>
     * @throws GenericPersistenceEAOException, Exception
     */
    public List<ProductionLine> findAllRemoteOrderById(int supplierId) throws GenericPersistenceEAOException;

}

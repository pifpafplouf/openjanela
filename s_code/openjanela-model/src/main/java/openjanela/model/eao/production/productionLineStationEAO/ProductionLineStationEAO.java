package openjanela.model.eao.production.productionLineStationEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.production.ProductionLineStation;
import openjanela.model.entities.production.ProductionLineStationPK;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 06-04-13
 *          Time: 09:20 PM
 */
public interface ProductionLineStationEAO extends GenericEAO<ProductionLineStation, ProductionLineStationPK> {

    /**
     * Find Production Line Stations
     *
     * @param productionLineId, Production Line Identification Id
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<ProductionLineStation> findByProductionLine(Integer productionLineId) throws GenericPersistenceEAOException;

    /**
     * Find Production Line Stations
     *
     * @param productionLineIds, Production Line Identification Id
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<ProductionLineStation> findByProductionLine(String productionLineIds) throws GenericPersistenceEAOException;

}

package openjanela.model.eao.production.productionStationsEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.production.ProductionStations;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 05-27-13
 *          Time: 06:50 PM
 */
public interface ProductionStationsEAO extends GenericEAO<ProductionStations, Integer> {

    /**
     * Find All order by Id
     *
     * @return List<ProductionStations>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<ProductionStations> findAllOrderById() throws GenericPersistenceEAOException;
}

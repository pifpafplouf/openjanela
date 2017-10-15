package openjanela.model.eao.partner.colorEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.Color;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.2
 *          Date: 1/28/14
 *          Time: 1:27 PM
 */
public interface ColorEAO extends GenericEAO<Color, Integer> {

    /**
     * Find All Remote Object
     *
     * @param supplierId, Supplier Identification Id
     * @return List<Color>
     * @throws GenericPersistenceEAOException, Exception
     */
    public List<Color> findAllRemote(int supplierId) throws GenericPersistenceEAOException;
}

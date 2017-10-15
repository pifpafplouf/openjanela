package openjanela.model.eao.partner.partsLabelPosEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.parts.PartsLabelPos;

import java.util.List;

/**
 * Copyright(c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.1
 *          Date: 10/10/13
 *          Time: 10:49 AM
 */
public interface PartsLabelPosEAO extends GenericEAO<PartsLabelPos, Integer> {

    /**
     * Find All Remote Parts Label Position
     *
     * @param supplierId, Supplier Identification Id
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<PartsLabelPos> findAllRemote(int supplierId) throws GenericPersistenceEAOException;
}

package openjanela.model.eao.designOptionsEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.design.DesignOptionEntityObject;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 06-05-13
 *          Time: 02:29 PM
 */
public interface DesignOptionsEAO extends GenericEAO<DesignOptionEntityObject, Integer> {

    /**
     * Find Options design for Job Item
     *
     * @param jobItemId, Job Item Identification Id
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<DesignOptionEntityObject> findByJobItem(Integer jobItemId) throws GenericPersistenceEAOException;
}

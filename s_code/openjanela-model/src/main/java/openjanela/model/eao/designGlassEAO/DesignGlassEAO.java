package openjanela.model.eao.designGlassEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.design.DesignGlassEntityObject;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 06-05-13
 *          Time: 02:29 PM
 */
public interface DesignGlassEAO extends GenericEAO<DesignGlassEntityObject, Integer> {

    /**
     * Find Design Glass by Identification Id
     *
     * @param designGlassId, Design Glass Identification Id
     * @return DesignGlassEntityObject
     * @throws GenericPersistenceEAOException, Exception
     */
    public DesignGlassEntityObject findGridsInfo(Integer designGlassId) throws GenericPersistenceEAOException;


    /**
     * Find Design Glass definitions for a Job Item
     *
     * @param jobItemId, Job Item Identification Id
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<DesignGlassEntityObject> findByJobItem(Integer jobItemId) throws GenericPersistenceEAOException;

}

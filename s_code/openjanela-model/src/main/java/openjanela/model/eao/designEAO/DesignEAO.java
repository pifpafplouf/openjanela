package openjanela.model.eao.designEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.design.Design;
import openjanela.model.entities.design.DesignPK;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 01-19-13
 *          Time: 02:08 PM
 */
public interface DesignEAO extends GenericEAO<Design, DesignPK> {

    /**
     * Return a new Identification ID for Design
     *
     * @return int
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public int getNextId() throws GenericPersistenceEAOException;

    /**
     * Return a List of predefined designs by family identification Id
     *
     * @param familyId, Family identification value
     * @param seriesId, Series Identification value
     * @return List<Design>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<Design> findByFamilyId(Integer familyId, Integer seriesId) throws GenericPersistenceEAOException;
}

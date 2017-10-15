package openjanela.model.eao.admin.typeLevelEAO;

import java.util.List;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.genericEAO.PersistenceClassNotFoundException;
import openjanela.model.entities.admin.TypeLevel;
import openjanela.model.entities.admin.TypeLevelPK;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 10-11-12
 *          Time: 03:01 PM
 */
public interface TypeLevelEAO extends GenericEAO<TypeLevel, TypeLevelPK> {

    /**
     * Return Type Level Entity from his Primary Key
     *
     * @param id, Identification Id for Primary Key
     * @return TypeLevel
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public TypeLevel getLevel(int id) throws PersistenceClassNotFoundException, GenericPersistenceEAOException;

    /**
     * Return All Type Levels Entities
     *
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<TypeLevel> getAllLevels() throws GenericPersistenceEAOException;
}

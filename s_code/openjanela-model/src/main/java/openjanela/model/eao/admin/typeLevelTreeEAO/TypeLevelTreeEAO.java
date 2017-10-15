package openjanela.model.eao.admin.typeLevelTreeEAO;

import java.util.List;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.TypeLevelTree;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 09-18-12
 *          Time: 09:32 AM
 */
public interface TypeLevelTreeEAO extends GenericEAO<TypeLevelTree, Integer> {

    /**
     * Find TypeLevelTree
     *
     * @return List<TypeLevelTree>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException
     *          , Exception
     */

    List<TypeLevelTree> findByLevelTypes(int pid) throws GenericPersistenceEAOException;
}

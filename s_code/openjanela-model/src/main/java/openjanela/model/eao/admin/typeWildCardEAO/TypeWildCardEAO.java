package openjanela.model.eao.admin.typeWildCardEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.TypeWildCard;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 09-18-12
 *          Time: 09:32 AM
 */
public interface TypeWildCardEAO extends GenericEAO<TypeWildCard, Integer> {

    /**
     * Find Glazing Types order by Identification Id
     *
     * @return List<TypeGlazing>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<TypeWildCard> findAll() throws GenericPersistenceEAOException;
}
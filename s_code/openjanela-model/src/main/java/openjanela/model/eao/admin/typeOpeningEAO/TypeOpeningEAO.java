package openjanela.model.eao.admin.typeOpeningEAO;

import java.util.List;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.TypeOpening;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-30-12
 *          Time: 10:28 PM
 */
public interface TypeOpeningEAO extends GenericEAO<TypeOpening, Integer> {

    /**
     * Find all type openings
     *
     * @return List<TypeOpening>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<TypeOpening> findAllOpenings() throws GenericPersistenceEAOException;
}

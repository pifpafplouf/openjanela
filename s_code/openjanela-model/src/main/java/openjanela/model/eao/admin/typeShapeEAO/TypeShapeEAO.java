package openjanela.model.eao.admin.typeShapeEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.genericEAO.PersistenceClassNotFoundException;
import openjanela.model.entities.admin.TypeShape;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-30-12
 *          Time: 10:28 PM
 */
public interface TypeShapeEAO extends GenericEAO<TypeShape, Integer> {

    /**
     * Return Shape by Identification Primary Key
     *
     * @param id, Identification Primary Key
     * @return TypeShape
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public TypeShape getShape(int id) throws PersistenceClassNotFoundException, GenericPersistenceEAOException;

    /**
     * Find Read Only Type Shapes
     *
     * @return List
     * @throws GenericPersistenceEAOException, Exception
     */
    public List<TypeShape> findReadOnly() throws GenericPersistenceEAOException;
}

package openjanela.model.eao.genericEAO;

import java.io.Serializable;
import java.util.List;

/**
 * This class implements CRUD functionality for ORM Hibernate background implementation for JPA
 * <p/>
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: Eddy Montenegro
 * Date: 09-04-2010
 * Time: 11:49:28 PM
 */
public interface GenericEAO<T, ID extends Serializable> {

    /**
     * This method persist an entity
     *
     * @param object, Generic object
     * @return T
     */
    T create(T object) throws GenericPersistenceEAOException;

    /**
     * This method update an entity
     *
     * @param object, Generic object
     * @return T
     */
    T update(T object) throws GenericPersistenceEAOException;

    /**
     * This method find an entity by his identifier
     *
     * @param id, identifier
     * @return T
     */
    T findById(ID id) throws PersistenceClassNotFoundException, GenericPersistenceEAOException;

    /**
     * This method find all entities persistence
     *
     * @return List<T>
     */
    List<T> findAll() throws GenericPersistenceEAOException;

    /**
     * This method Remove entity
     *
     * @param id, identifier
     */
    void remove(ID id) throws GenericPersistenceEAOException;

    /**
     * This method detach a object fom Entity Manager
     *
     * @param object, Generic Object
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    void detach(T object) throws GenericPersistenceEAOException;

}

package openjanela.model.eao.genericEAO;

import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.PersistenceManagementServicePartnerFactory;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

/**
 * This class implements CRUD functionality for ORM Hibernate background implementation for JPA
 * <p/>
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: Eddy Montenegro
 * Date: 09-04-2010
 * Time: 11:59:45 PM
 */
public abstract class GenericPersistenceEAO<T, ID extends Serializable> implements GenericEAO<T, ID> {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(GenericPersistenceEAO.class);

    /* Persistence class */
    private Class<T> persistenceClass;

    /* Entity Manager Persistence service */
    protected EntityManager em;

    /**
     * This constructor create a GenericPersistenceEAO
     */
    public GenericPersistenceEAO() {
        //Iparameterized type class
        this.persistenceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * This method init a persistence service
     *
     * @throws GenericPersistenceEAOException,
     *          Exception
     */
    protected void initService() throws GenericPersistenceEAOException {

        try {

            //Getting persistence service
            em = PersistenceManagementServicePartnerFactory.getEntityManager();

            //Added to prevent Flushing
//            em.setFlushMode(FlushModeType.AUTO);

            PersistenceManagementServicePartnerFactory.beginTransaction();

        } catch (PersistenceManagementServiceFactoryException e) {
            logger.error(e.getMessage(), e);
            throw new GenericPersistenceEAOException(e.getMessage(), e);
        }
    }

    /**
     * This method commit a transaction
     *
     * @throws GenericPersistenceEAOException,
     *          Exception
     */
    protected void commitService() throws GenericPersistenceEAOException {
        try {

            PersistenceManagementServicePartnerFactory.commit(true);

        } catch (PersistenceManagementServiceFactoryException e) {
            logger.error(e.getMessage(), e);
            throw new GenericPersistenceEAOException(e.getMessage(), e);
        }
    }

    /**
     * This method close session service from entity access objects
     *
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    protected void closeService() throws GenericPersistenceEAOException {
        try {
            PersistenceManagementServicePartnerFactory.close();
        } catch (PersistenceManagementServiceFactoryException e) {
            logger.error(e.getMessage(), e);
            throw new GenericPersistenceEAOException(e.getMessage(), e);
        }
    }

    @Override
    public T create(T object) throws GenericPersistenceEAOException {

        //Init service
        initService();

        try {

            em.persist(object);

            return object;

        } catch (Exception e) {
            System.out.println("Error trying to persist entity: " + e.getMessage());
            throw new GenericPersistenceEAOException("Error trying to persist entity: " + e.getMessage(), e);
        } finally {
            commitService();
        }
    }

    @Override
    public T update(T object) throws GenericPersistenceEAOException {

        //Init service
        initService();

        try {

            //Updating
            return em.merge(object);

        } catch (Exception e) {
            System.out.println("Error trying to update entity: " + e.getMessage());
            throw new GenericPersistenceEAOException(e.getMessage(), e);
        } finally {
            commitService();
        }
    }

    @Override
    public T findById(ID id) throws PersistenceClassNotFoundException, GenericPersistenceEAOException {

        //Init service
        initService();

        //Find entity
        T entity = em.find(persistenceClass, id);

        if (entity == null)
            throw new PersistenceClassNotFoundException("Sales Rep User ID does not exist" + String.valueOf(id));

        return entity;
    }

    @Override
    public List<T> findAll() throws GenericPersistenceEAOException {

        //Init service
        initService();

        //Find all
        String query = "Select t From " + persistenceClass.getName() + " t";

        // Added to prevent Flushing
//        em.setFlushMode(FlushModeType.COMMIT);

        List<T> entities = em.createQuery(query).getResultList();

        //Commit service
        closeService();

        return entities;
    }

    @Override
    public void remove(ID id) throws GenericPersistenceEAOException {

        //Init service
        initService();

        try {

            em.remove(findById(id));

        } catch (Exception e) {
            System.out.println("Error trying to drop entity: " + e.getMessage());
            throw new GenericPersistenceEAOException("Error trying to drop entity: " + e.getMessage(), e);
        } finally {
            commitService();
        }
    }

    @Override
    public void detach(T object) throws GenericPersistenceEAOException {

        if (em != null && em.isOpen()) {
            em.detach(object);
        }
    }

    /**
     * Find a List of entities with a query and criteria of searching
     *
     * @param namedQuery
     * @return List
     * @throws GenericPersistenceEAOException
     *
     */
    protected List<T> namedQuery(String namedQuery) throws GenericPersistenceEAOException {
        return namedQuery(namedQuery, null);
    }

    /**
     * Find a List of entities with a namedQuery
     *
     * @param namedQuery, parameters
     * @param parameters, list of filters
     * @return List
     * @throws GenericPersistenceEAOException
     *
     * @author hmurbina
     */

    protected List<T> namedQuery(String namedQuery, HashMap parameters) throws GenericPersistenceEAOException {

        //iniciar el servicio
        initService();

        em.getTransaction().begin();
        Query q = em.createNamedQuery(namedQuery);

        if (parameters != null) {
            Iterator entries = parameters.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry e = (Map.Entry) entries.next();
                q.setParameter(e.getKey().toString(), e.getValue());
            }
        }

        em.getTransaction().commit();

        return q.getResultList();
    }

    /**
     * Find a Collection<T> entities with a namedQuery
     *
     * @param query,      String
     * @param parameters, list of filters
     * @return Collection<T>
     * @throws GenericPersistenceEAOException,
     *          Exception
     */
    protected Collection<T> findByCriteria(String query, List parameters) throws GenericPersistenceEAOException {

        //iniciar el servicio
        initService();

        //Create query fragment
        Query queryFragment = em.createQuery(query);

        //Adding parameters
        int parameter = 0;

        for (Object object : parameters) {

            //count parameter
            parameter++;

            logger.debug("parameter: " + parameter);

            //Setting parameter
            queryFragment.setParameter(parameter, object);
        }

        Collection<T> entities = queryFragment.getResultList();

        return entities;
    }
}

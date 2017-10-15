package openjanela.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 07-26-12
 * Time: 11:29 AM
 */
public class PersistenceManagementServiceConfiguratorFactory {

    //Entity Manager Factory para servicio de persistencia
    private static EntityManagerFactory managerFactory;

    //Thread local service
    private static ThreadLocal<EntityManager> threadLocal;

    static {
        //Create manager service factory
        managerFactory = Persistence.createEntityManagerFactory("OPENJANELA_CONFIGURATOR_PERSISTENCE_UNIT");
        threadLocal = new ThreadLocal<EntityManager>();
    }

    /**
     * Return an active entity manager
     *
     * @return EntityManager
     * @throws openjanela.model.PersistenceManagementServiceFactoryException,
     *          Exception
     */
    public static EntityManager getEntityManager() throws PersistenceManagementServiceFactoryException {

        //Get entity manager
        EntityManager em = threadLocal.get();

        if (em == null || !em.isOpen()) {
            em = managerFactory.createEntityManager();
            threadLocal.set(em);
        }

        return em;
    }

    /**
     * Close entity manager persistence service
     *
     * @param value, boolean
     * @throws openjanela.model.PersistenceManagementServiceFactoryException,
     *          Exception
     */
    public static void closeEntityManager(boolean value) throws PersistenceManagementServiceFactoryException {

        EntityManager em = threadLocal.get();

        if (value) {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Init Transaction
     *
     * @return boolean
     * @throws openjanela.model.PersistenceManagementServiceFactoryException,
     *          Exception
     */
    public synchronized static boolean beginTransaction() throws PersistenceManagementServiceFactoryException {
        if (!getEntityManager().getTransaction().isActive()) {
            //Begin a new transaction
            getEntityManager().getTransaction().begin();

            return true;
        }

        return false;
    }

    /**
     * Commit persistence entity to db
     *
     * @param value, boolean
     * @throws openjanela.model.PersistenceManagementServiceFactoryException,
     *          Exception
     */
    public static void commit(boolean value) throws PersistenceManagementServiceFactoryException {

        if (value) {
            if (getEntityManager().getTransaction().isActive()) {
                getEntityManager().getTransaction().commit();

                //Closing entity manager
                closeEntityManager(true);
            }
        }
    }

    /**
     * This method close an open connection in pool connection from Entity Manager Factory
     *
     * @throws openjanela.model.PersistenceManagementServiceFactoryException,
     *          Exception
     */
    public synchronized static void close() throws PersistenceManagementServiceFactoryException {
        //Close connection
        closeEntityManager(true);
    }

    /**
     * Rollback transaction
     *
     * @throws openjanela.model.PersistenceManagementServiceFactoryException,
     *          Exception
     */
    public static void rollback() throws PersistenceManagementServiceFactoryException {

        //Rollback transaction
        getEntityManager().getTransaction().rollback();

        //Close entity manager factory
        closeEntityManager(true);
    }

    /**
     * Synchronized entity with db countpart
     *
     * @throws openjanela.model.PersistenceManagementServiceFactoryException,
     *          Exception
     */
    public static void flush() throws PersistenceManagementServiceFactoryException {
        getEntityManager().flush();
    }
}

package openjanela.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

/**
 * Copyright (c) 2011-2012 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 *         Date: 08-07-2010
 *         Time: 01:43:48 AM
 */
public class PersistenceManagementServiceFactory {

    //Entity Manager Factory para servicio de persistencia
    private static EntityManagerFactory managerFactory;

    //Thread local service
    private static ThreadLocal<EntityManager> threadLocal;

    static {

        Map<String, String> properties = new HashMap<String, String>();
        properties.put(HibernateProperties.HIBERNATE_PROPERTY_CONNECTION_DRIVER_CLASS.getValue(),
                PersistenceConfigProperties.HIBERNATE_CONNECTION_DRIVER);
        properties.put(HibernateProperties.HIBERNATE_PROPERTY_CONNECTION_URL.getValue(),
                PersistenceConfigProperties.getInstance().getURLConnectionTenant_1());
        properties.put(HibernateProperties.HIBERNATE_PROPERTY_CONNECTION_USERNAME.getValue(),
                PersistenceConfigProperties.getInstance().getTenant_1_login());
        properties.put(HibernateProperties.HIBERNATE_PROPERTY_CONNECTION_PASSWORD.getValue(),
                PersistenceConfigProperties.getInstance().getTenant_1_password());
        properties.put(HibernateProperties.HIBERNATE_PROPERTY_DIALECT.getValue(),
                PersistenceConfigProperties.HIBERNATE_DIALECT);

        properties.put("hibernate.temp.use_jdbc_metadata_defaults", "false");

        properties.put(HibernateProperties.HIBERNATE_PROPERTY_SHOW_SQL.getValue(), "true");
        properties.put(HibernateProperties.HIBERNATE_PROPERTY_FORMAT_SQL.getValue(), "true");
        properties.put(HibernateProperties.HIBERNATE_PROPERTY_JDBC_BATCH_SIZE.getValue(), "100");
        properties.put(HibernateProperties.HIBERNATE_PROPERTY_JDBC_FETCH_SIZE.getValue(), "100");
        properties.put(HibernateProperties.HIBERNATE_PROPERTY_CONNECTION_POOL_SIZE.getValue(), "6");
        properties.put(HibernateProperties.HIBERNATE_PROPERTY_HBM2DDL_AUTO.getValue(), "none");

//        properties.put(HibernateProperties.HIBERNATE_PROPERTY_CONNECTION_PROVIDER_CLASS.getValue(),
//                "org.hibernate.connection.C3P0ConnectionProvider");
//        properties.put(HibernateProperties.HIBERNATE_PROPERTY_C3P0_ACQUIRE_INCREMENT.getValue(), "5");
//        properties.put(HibernateProperties.HIBERNATE_PROPERTY_C3P0_MAX_IDLE_TIME.getValue(), "3600");
//        properties.put(HibernateProperties.HIBERNATE_PROPERTY_C3P0_MAX_IDLE_TIME_EXCESS_CONNECTION.getValue(), "300");
//        properties.put(HibernateProperties.HIBERNATE_PROPERTY_C3P0_MIN_SIZE.getValue(), "5");
//        properties.put(HibernateProperties.HIBERNATE_PROPERTY_C3P0_MAX_SIZE.getValue(), "10");
//        properties.put(HibernateProperties.HIBERNATE_PROPERTY_C3P0_TIMEOUT.getValue(), "20");
//        properties.put(HibernateProperties.HIBERNATE_PROPERTY_C3P0_NUM_HELPED_THEADS.getValue(), "6");
//        properties.put(HibernateProperties.HIBERNATE_PROPERTY_C3P0_ACQUIRE_RETRY_ATTEMPS.getValue(), "2");
//        properties.put(HibernateProperties.HIBERNATE_PROPERTY_C3P0_ACQUIRE_RETRY_DELAY.getValue(), "2");
//        properties.put(HibernateProperties.HIBERNATE_UNRETURNED_CONNECTION_TIMEOUT.getValue(), "3600");

        //Create manager service factory
        managerFactory = Persistence.createEntityManagerFactory("OPENJANELA_MODELO_PERSISTENCE_UNIT", properties);
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

        if (value) {
            if (getEntityManager().getTransaction().isActive()) {
                getEntityManager().getTransaction().commit();

                //Closing entity manager
                getEntityManager().close();
            }
        }
    }

    /**
     * This method init Transaction operation
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
     * This method commit (confirm) changes made into the database
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
     * This method rollback transaction operation into the database
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
     * This method synchronized entity with database countpart row for a table
     *
     * @throws openjanela.model.PersistenceManagementServiceFactoryException,
     *          Exception
     */
    public static void flush() throws PersistenceManagementServiceFactoryException {
        getEntityManager().flush();
    }

}

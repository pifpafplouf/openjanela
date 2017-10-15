package openjanela.model;

import com.sun.swing.internal.plaf.synth.resources.synth_zh_HK;
import openjanela.model.entities.admin.Partners;
import org.openjanela.commons.util.security.Security;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.2
 *          Date: 1/11/14
 *          Time: 9:51 PM
 */
public class PersistenceManagementServiceRemoteFactory {


    //Entity Manager Factory para servicio de persistencia
    private static EntityManagerFactory managerFactory;

    //Thread local service
    private static ThreadLocal<EntityManager> threadLocal;

    static {
        threadLocal = new ThreadLocal<EntityManager>();
    }

    /**
     * Return Entity Manager
     *
     * @return EntityManager
     * @throws openjanela.model.PersistenceManagementServiceFactoryException,
     *          Exception
     */
    public static EntityManager getEntityManager() throws PersistenceManagementServiceFactoryException {
        return threadLocal.get();
    }

    /**
     * Return an active entity manager
     *
     * @param supplier, Partners
     * @return EntityManager
     * @throws openjanela.model.PersistenceManagementServiceFactoryException,
     *          Exception
     */
    public static EntityManager getEntityManager(Partners supplier) throws PersistenceManagementServiceFactoryException {

        //Init Persistence Remote Values
        PersistenceConfigProperties.getInstance().setTenant_3_server(Security.decodeBase64(supplier.getPartner_db_hostname()));
        PersistenceConfigProperties.getInstance().setTenant_3_port(Integer.parseInt(Security.decodeBase64(supplier.getPartner_db_port())));
        PersistenceConfigProperties.getInstance().setTenant_3_schema(Security.decodeBase64(supplier.getPartner_db_name()));
        PersistenceConfigProperties.getInstance().setTenant_3_login(Security.decodeBase64(supplier.getPartner_db_user()));
        PersistenceConfigProperties.getInstance().setTenant_3_password(Security.decodeBase64(supplier.getPartner_db_password()));

        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //Check Entity Manager Factory
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        if (managerFactory != null) {

            Map<String, Object> props = managerFactory.getProperties();
            String _URLConn = (String) props.get(HibernateProperties.HIBERNATE_PROPERTY_CONNECTION_URL.getValue());

            if (!_URLConn.trim().equals(PersistenceConfigProperties.getInstance().getURLConnectionTenant_3().trim())) {

                //Create New Entity Manager Factory
                createEntityMangerFactory();

                //Create Entity Manager
                EntityManager em = threadLocal.get();
                em = managerFactory.createEntityManager();

                threadLocal.set(em);

                return em;
            }
        }

        if (managerFactory == null) {
            //Create New Entity Manager Factory
            createEntityMangerFactory();
        }

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

                try {
                    getEntityManager().getTransaction().commit();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }

                //Closing entity manager
                getEntityManager().close();
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

    //******************************************************************************************************************
    // Private Methods
    //******************************************************************************************************************

    /**
     * Create New Entity Manager Factory
     */
    private static void createEntityMangerFactory() throws PersistenceManagementServiceFactoryException {

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //Init Hibernate Properties
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        Map<String, String> properties = new HashMap<String, String>();
        properties.put(HibernateProperties.HIBERNATE_PROPERTY_CONNECTION_DRIVER_CLASS.getValue(),
                PersistenceConfigProperties.HIBERNATE_CONNECTION_DRIVER);

        properties.put(HibernateProperties.HIBERNATE_PROPERTY_CONNECTION_URL.getValue(),
                PersistenceConfigProperties.getInstance().getURLConnectionTenant_3());

        properties.put(HibernateProperties.HIBERNATE_PROPERTY_CONNECTION_USERNAME.getValue(),
                PersistenceConfigProperties.getInstance().getTenant_3_login());
        properties.put(HibernateProperties.HIBERNATE_PROPERTY_CONNECTION_PASSWORD.getValue(),
                PersistenceConfigProperties.getInstance().getTenant_3_password());

        properties.put(HibernateProperties.HIBERNATE_PROPERTY_DIALECT.getValue(),
                PersistenceConfigProperties.HIBERNATE_DIALECT);

        properties.put("hibernate.temp.use_jdbc_metadata_defaults", "false");

        properties.put(HibernateProperties.HIBERNATE_PROPERTY_SHOW_SQL.getValue(), "true");
        properties.put(HibernateProperties.HIBERNATE_PROPERTY_FORMAT_SQL.getValue(), "true");
        properties.put(HibernateProperties.HIBERNATE_PROPERTY_JDBC_BATCH_SIZE.getValue(), "40");
        properties.put(HibernateProperties.HIBERNATE_PROPERTY_JDBC_FETCH_SIZE.getValue(), "40");
        properties.put(HibernateProperties.HIBERNATE_PROPERTY_HBM2DDL_AUTO.getValue(), "none");

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

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //Create manager service factory
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        managerFactory = Persistence.createEntityManagerFactory("OPENJANELA_PARTNER_REMOTE_PERSISTENCE_UNIT", properties);
        threadLocal = new ThreadLocal<EntityManager>();
    }
}

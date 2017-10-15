package openjanela.model.eao.admin;

import java.util.ArrayList;
import java.util.List;

import openjanela.model.PersistenceManagementServiceFactory;
import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.SystemModuleAction;
import openjanela.model.entities.admin.SystemModuleActionPK;
import openjanela.model.entities.admin.UserAdmin;

import org.apache.log4j.Logger;

/**
 * Copyright (c) 2011- 2013 OpenJanela LLC. All rights reserved.
 *
 * @author Consultant
 * @version 2.0.8
 *          Date Initial: 03-26-14
 *          Time Initial: 06:39 PM
 */
public class SystemModuleActionPersistenceEAO extends GenericPersistenceEAO<SystemModuleAction, SystemModuleActionPK> implements SystemModuleActionEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(SystemModuleActionPersistenceEAO.class);

    /**
     * Init persistence service
     *
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException
     *          , Exception
     */
    @Override
    protected void initService() throws GenericPersistenceEAOException {

        try {

            // Getting persistence service
            em = PersistenceManagementServiceFactory.getEntityManager();
            PersistenceManagementServiceFactory.beginTransaction();

        } catch (PersistenceManagementServiceFactoryException e) {
            logger.error(e.getMessage(), e);
            throw new GenericPersistenceEAOException(e.getMessage(), e);
        }
    }

    /**
     * Commit service
     *
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException , Exception
     */
    @Override
    protected void commitService() throws GenericPersistenceEAOException {
        try {
            PersistenceManagementServiceFactory.commit(true);
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
            PersistenceManagementServiceFactory.close();
        } catch (PersistenceManagementServiceFactoryException e) {
            logger.error(e.getMessage(), e);
            throw new GenericPersistenceEAOException(e.getMessage(), e);
        }
    }
    
    @Override
    public List<SystemModuleAction> findAllByModule(Integer moduleId) throws GenericPersistenceEAOException {
    	List<SystemModuleAction> moduleActions = new ArrayList<SystemModuleAction>();
    	String query = "SELECT sma FROM SystemModuleAction sma WHERE sma.systemModuleActionPK.module = :moduleId";
    	
    	try {
            initService();
            
            moduleActions = em.createQuery(query).setParameter("moduleId", moduleId).getResultList();
        } finally {
            closeService();
        }
    	
        return moduleActions;
    }

}

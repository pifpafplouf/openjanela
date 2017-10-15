package openjanela.model.eao.admin.typeGridEAO;

import openjanela.model.PersistenceManagementServiceFactory;
import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.TypeGrid;
import org.apache.log4j.Logger;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.1
 *          Date: 12/3/13
 *          Time: 4:10 PM
 */
public class TypeGridPersistenceEAO extends GenericPersistenceEAO<TypeGrid, Integer> implements TypeGridEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(TypeGridPersistenceEAO.class);

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

}


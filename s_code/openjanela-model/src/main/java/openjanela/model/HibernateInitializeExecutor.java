package openjanela.model;

import org.apache.log4j.Logger;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-05-13
 *          Time: 11:36 PM
 */
public class HibernateInitializeExecutor {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(HibernateInitializeExecutor.class);

    /**
     * This method initialize hibernate service  asynchronously
     */
    public static void initializeHibernateService() {

        if (logger.isDebugEnabled()) {
            logger.debug("Initialize Hibernate Persistence Service: " + new Date());
        }

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    PersistenceManagementServiceFactory.getEntityManager();
                    PersistenceManagementServicePartnerFactory.getEntityManager();
                } catch (PersistenceManagementServiceFactoryException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        });

        executorService.shutdown();
    }
}

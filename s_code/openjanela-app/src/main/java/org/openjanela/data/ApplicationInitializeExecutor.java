package org.openjanela.data;

import org.apache.log4j.Logger;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-10-13
 *          Time: 01:15 AM
 */
public class ApplicationInitializeExecutor {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(ApplicationInitializeExecutor.class);

    /**
     * This Method Initialize Application Configuration for Executions
     */
    public static void initializeApplicationService() {

        if (logger.isDebugEnabled()) {
            logger.debug("Initialize Application Service: " + new Date());
        }

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {

                //Initialize Application Base
                ApplicationBaseApp.getInstance(-1, -1, -1);
                ApplicationBaseRulesApp.getInstance(-1);
            }
        });

        executorService.shutdown();
    }
}

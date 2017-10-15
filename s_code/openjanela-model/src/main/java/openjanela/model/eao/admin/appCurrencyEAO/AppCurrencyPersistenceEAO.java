package openjanela.model.eao.admin.appCurrencyEAO;

import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.AppCurrency;

import org.apache.log4j.Logger;

import java.rmi.server.UnicastRemoteObject;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 07-30-12
 * Time: 10:28 PM
 */
public class AppCurrencyPersistenceEAO extends GenericPersistenceEAO<AppCurrency, String> implements AppCurrencyEAO {

    // Apache log4j
    private static final Logger logger = Logger.getLogger(AppCurrencyPersistenceEAO.class);


    @Override
    public AppCurrency getCurrency(String id) throws GenericPersistenceEAOException {

        try {

            // Init service
            initService();

            //Create query
            AppCurrency currency = (AppCurrency) em.createQuery("select a from AppCurrency a where a.id = :id").
                    setParameter("id", id).getSingleResult();

            return currency;

        } finally {
            //Close service
            closeService();
        }
    }

}

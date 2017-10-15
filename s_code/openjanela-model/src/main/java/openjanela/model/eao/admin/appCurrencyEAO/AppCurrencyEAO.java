package openjanela.model.eao.admin.appCurrencyEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.AppCurrency;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 07-30-12
 * Time: 10:28 PM
 */
public interface AppCurrencyEAO extends GenericEAO<AppCurrency, String> {

    /**
     * Return currency for Identifier Id
     *
     * @param id, Identification Id
     * @return AppCurrency
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public AppCurrency getCurrency(String id) throws GenericPersistenceEAOException;
}

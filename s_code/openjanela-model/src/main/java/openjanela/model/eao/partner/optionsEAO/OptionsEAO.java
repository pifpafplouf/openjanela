package openjanela.model.eao.partner.optionsEAO;

import java.util.List;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.OptionDefinitions;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-30-12
 *          Time: 10:28 PM
 */
public interface OptionsEAO extends GenericEAO<OptionDefinitions, Integer> {

    /**
     * Find a List of Option Definitions
     *
     * @param id, Integer
     * @return List<OptionDefinitions>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<OptionDefinitions> findOption(int id) throws GenericPersistenceEAOException;

    /**
     * Return a Remote List of Options
     *
     * @param supplierId, Supplier Identification Id
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<OptionDefinitions> findAllRemote(int supplierId) throws GenericPersistenceEAOException;

}

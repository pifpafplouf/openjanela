package openjanela.model.eao.partner.optionsEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.OptionAnswers;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-30-12
 *          Time: 10:28 PM
 */
public interface OptionAnswersEAO extends GenericEAO<OptionAnswers, Integer> {

    /**
     * Find Options Answers by Option Definition
     *
     * @param optionId, Option Identification Id
     * @return List<OptionAnswers>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<OptionAnswers> findByOption(Integer optionId) throws GenericPersistenceEAOException;

    /**
     * Find Remote Options Answers by Option Definition
     *
     * @param optionId,   Option Identification Id
     * @param supplierId, Supplier Identification Id
     * @return List<OptionAnswers>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<OptionAnswers> findRemoteByOption(Integer optionId, Integer supplierId) throws GenericPersistenceEAOException;

}

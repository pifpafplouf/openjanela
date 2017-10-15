package openjanela.model.eao.partner.ruleAnswerEAO;

import java.util.List;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.RuleAnswers;
import openjanela.model.entities.partner.RuleAnswersPK;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-30-12
 *          Time: 10:28 PM
 */
public interface RuleAnswersEAO extends GenericEAO<RuleAnswers, RuleAnswersPK> {


    /**
     * Find optionanswwers for rule
     *
     * @param seriesId, Series Identification Id
     * @return List<RuleAnswers>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException
     *          , Exception
     */

    public List<RuleAnswers> findAllAnswers(int seriesId) throws GenericPersistenceEAOException;

    /**
     * Find All Remote Answers
     *
     * @param seriesId,   Series Identification Id
     * @param supplierId, Supplier Identification Id
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<RuleAnswers> findAllRemoteAnswers(int seriesId, int supplierId) throws GenericPersistenceEAOException;
}

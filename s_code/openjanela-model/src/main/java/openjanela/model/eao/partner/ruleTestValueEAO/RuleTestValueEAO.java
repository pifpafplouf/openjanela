package openjanela.model.eao.partner.ruleTestValueEAO;

import java.util.List;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.RuleTestValue;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-30-12
 *          Time: 10:28 PM
 */
public interface RuleTestValueEAO extends GenericEAO<RuleTestValue, Integer> {

    /**
     * Find all Test values for Test for rule for series
     *
     * @param ruleNo,   Rule number
     * @param seriesId, Series Identification Id
     * @param testId,   Test Identification Id
     * @return List<Series>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException
     *          , Exception
     */
    public List<RuleTestValue> findAllByRuleBySeries(int ruleNo, int seriesId, int testId) throws GenericPersistenceEAOException;

    /**
     * Find all by series
     *
     * @param seriesId, Series identification id
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<RuleTestValue> findAllBySeries(int seriesId) throws GenericPersistenceEAOException;

    /**
     * Find All Remote Rule Test by series
     *
     * @param seriesId,   Series Identification Id
     * @param supplierId, Supplier Identification Id
     * @return List<RuleTestValue>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<RuleTestValue> findAllRemoteBySeries(int seriesId, int supplierId) throws GenericPersistenceEAOException;

}

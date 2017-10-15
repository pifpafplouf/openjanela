package openjanela.model.eao.partner.ruleTestEAO;

import java.util.List;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.RuleTest;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-30-12
 *          Time: 10:28 PM
 */
public interface RuleTestEAO extends GenericEAO<RuleTest, Integer> {

    /**
     * Find all rule test by rule number and series
     *
     * @param ruleNo,   Rule number Identification Id
     * @param seriesId, Series Identification Id
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<RuleTest> findAllByRuleBySeries(int ruleNo, int seriesId) throws GenericPersistenceEAOException;

    /**
     * Find All rule test by series
     *
     * @param seriesId, Series Identification Id
     * @return List
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<RuleTest> findAllBySeries(int seriesId) throws GenericPersistenceEAOException;

    /**
     * Find All Remote Rule Test by Series
     *
     * @param seriesId,   Series Identification Id
     * @param supplierId, Supplier Identification Id
     * @return List<RuleTest>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<RuleTest> findAllRemoteBySeries(int seriesId, int supplierId) throws GenericPersistenceEAOException;

}

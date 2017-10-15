package openjanela.model.eao.partner.adjustmentRO_EAO;

import java.util.List;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.AdjustmentRo;
import openjanela.model.entities.partner.AdjustmentRoPK;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-25-12
 *          Time: 02:27 PM
 */
public interface AdjustmentRO_EAO extends GenericEAO<AdjustmentRo, AdjustmentRoPK> {

    /**
     * Find All Adjustment ROs
     *
     * @param seriesId, Series Identification Id
     * @return List<AdjustmentRo>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<AdjustmentRo> findROs(int seriesId) throws GenericPersistenceEAOException;

    /**
     * Find all Adjustment ROs
     *
     * @param seriesId, Series Identification Id
     * @param isHead,   Is Head value
     * @return List<Partner>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<AdjustmentRo> findROs(int seriesId, boolean isHead) throws GenericPersistenceEAOException;

    /**
     * Find All Ajustment ROs by Series Identification & Supplier Id
     *
     * @param seriesId,   Series Identification Id
     * @param supplierId, Supplier Identification Id
     * @return List<AdjustmentRos>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<AdjustmentRo> findRemoteROs(int seriesId, int supplierId) throws GenericPersistenceEAOException;

    /**
     * Find All Ajustment ROs by Series Identification & Supplier Id
     *
     * @param seriesId,   Series Identification Id
     * @param supplierId, Supplier Identification Id
     * @param isHead,     Is Head Value
     * @return List<Partner>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<AdjustmentRo> findRemoteROs(int seriesId, int supplierId, boolean isHead) throws GenericPersistenceEAOException;

}

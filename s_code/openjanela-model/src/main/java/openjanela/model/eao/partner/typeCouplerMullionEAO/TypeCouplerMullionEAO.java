package openjanela.model.eao.partner.typeCouplerMullionEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.TypeCouplerMullion;
import openjanela.model.entities.partner.TypeCouplerMullionPK;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 09-19-12
 *          Time: 03:42 PM
 */
public interface TypeCouplerMullionEAO extends GenericEAO<TypeCouplerMullion, TypeCouplerMullionPK> {

    /**
     * Find Type Coupler Mullion by series identification
     *
     * @param seriesId, Integer
     * @return List<TypeCouplerMullion>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<TypeCouplerMullion> findBySeriesId(Integer seriesId) throws GenericPersistenceEAOException;

    /**
     * Find Type Coupler Mullion by series identification
     *
     * @param seriesId,   Series Identification Id
     * @param supplierId, Supplier Identification Id
     * @return List<TypeCouplerMullion>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<TypeCouplerMullion> findRemoteBySeriesId(Integer seriesId, Integer supplierId) throws GenericPersistenceEAOException;
}

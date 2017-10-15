package openjanela.model.eao.partner.partnerGroupLineDiscountEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.PartnerGroupLineDiscount;
import openjanela.model.entities.partner.PartnerGroupLineDiscountPK;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 10-21-12
 *          Time: 11:46 AM
 */
public interface PartnerGroupLineDiscountEAO extends GenericEAO<PartnerGroupLineDiscount, PartnerGroupLineDiscountPK> {

    /**
     * Find partner line group discount
     *
     * @param groupId, Group Identification Id
     * @return List<PartnerGroupLineDiscount>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<PartnerGroupLineDiscount> findByGroupId(Integer groupId) throws GenericPersistenceEAOException;

    /**
     * Find partner line group discount
     *
     * @param groupId,  Group Identification Id
     * @param seriesId, Series Identification Id
     * @return List<PartnerGroupLineDiscount>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<PartnerGroupLineDiscount> findByGroupId(Integer groupId, Integer seriesId) throws GenericPersistenceEAOException;

    /**
     * Find partner line group discount
     *
     * @param groupId,         Group Identification Id
     * @param seriesId,        Series Identification Id
     * @param priceCategoryId, Price Category id
     * @return List<PartnerGroupLineDiscount>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<PartnerGroupLineDiscount> findByGroupId(Integer groupId, Integer seriesId, Integer priceCategoryId)
            throws GenericPersistenceEAOException;

    /**
     * Find partner line group discount
     *
     * @param supplierId, Supplier Identification Id
     * @param groupId,    Group Identification Id
     * @return List<PartnerGroupLineDiscount>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<PartnerGroupLineDiscount> findRemoteByGroupId(Integer supplierId, Integer groupId) throws GenericPersistenceEAOException;
}

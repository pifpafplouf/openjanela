package openjanela.model.eao.partner.partnerLineDiscountEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.PartnerLineDiscount;
import openjanela.model.entities.partner.PartnerLineDiscountPK;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 10-21-12
 *          Time: 10:08 AM
 */
public interface PartnerLineDiscountEAO extends GenericEAO<PartnerLineDiscount, PartnerLineDiscountPK> {

    /**
     * Search partner line discounts for PartnerId
     *
     * @param partnerId, Partner Identification Key
     * @return List<PartnerLineDiscount>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<PartnerLineDiscount> findByPartnerId(Integer partnerId) throws GenericPersistenceEAOException;

    /**
     * Search Partner line discounts for PartnerId and SeriesId
     *
     * @param partnerId, Partner Identification Key
     * @param seriesId,  Series Identification Key
     * @return List<PartnerLineDiscount>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<PartnerLineDiscount> findByPartnerId(Integer partnerId, Integer seriesId) throws GenericPersistenceEAOException;

    /**
     * Search Partner line discounts for partnerId and SeriesId and PriceCategoryId
     *
     * @param partnerId,       Partner Identification Key
     * @param seriesId,        Series Identification Key
     * @param priceCategoryId, Price Category Identification Key
     * @return List<PartnerLineDiscount>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<PartnerLineDiscount> findByPartnerId(Integer partnerId, Integer seriesId, Integer priceCategoryId)
            throws GenericPersistenceEAOException;

    /**
     * Search partner line discounts for PartnerId
     *
     * @param supplierId, Supplier Identification Id
     * @param partnerId,  Partner Identification Key
     * @return List<PartnerLineDiscount>
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException, Exception
     */
    public List<PartnerLineDiscount> findRemoteByPartnerId(Integer supplierId, Integer partnerId) throws GenericPersistenceEAOException;
}

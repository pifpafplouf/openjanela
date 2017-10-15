package openjanela.app.configuration.controller.calculation;

import Presentation.ItemFrame;
import openjanela.app.configuration.controller.BaseController;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.genericEAO.PersistenceClassNotFoundException;
import openjanela.model.eao.partner.partnerGroupLineDiscountEAO.PartnerGroupLineDiscountEAO;
import openjanela.model.eao.partner.partnerGroupLineDiscountEAO.PartnerGroupLineDiscountPersistenceEAO;
import openjanela.model.eao.partner.partnerLineDiscountEAO.PartnerLineDiscountEAO;
import openjanela.model.eao.partner.partnerLineDiscountEAO.PartnerLineDiscountPersistenceEAO;
import openjanela.model.eao.partner.pricingGroupEAO.PricingGroupEAO;
import openjanela.model.eao.partner.pricingGroupEAO.PricingGroupPersistenceEAO;
import openjanela.model.eao.admin.typePriceCategoryEAO.TypePriceCategoryEAO;
import openjanela.model.eao.admin.typePriceCategoryEAO.TypePriceCategoryPersistenceEAO;
import openjanela.model.entities.admin.TypePriceCategory;
import openjanela.model.entities.orderEntry.PricingGroup;
import openjanela.model.entities.partner.*;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 10-21-12
 * Time: 08:23 AM
 */
public class PartnerDiscountController extends BaseController {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(PartnerDiscountController.class);

    //************************************************
    //Entity Access Object
    //************************************************
    private PricingGroupEAO pricingGroupEAO;
    private TypePriceCategoryEAO typePriceCategoryEAO;
    private PartnerLineDiscountEAO partnerLineDiscountEAO;
    private PartnerGroupLineDiscountEAO partnerGroupLineDiscountEAO;

    /**
     * Constructor controller
     */
    public PartnerDiscountController() {
        pricingGroupEAO = new PricingGroupPersistenceEAO();
        typePriceCategoryEAO = new TypePriceCategoryPersistenceEAO();
        partnerLineDiscountEAO = new PartnerLineDiscountPersistenceEAO();
        partnerGroupLineDiscountEAO = new PartnerGroupLineDiscountPersistenceEAO();
    }

    /**
     * Search discount by pricing group
     *
     * @param partner,        Partner object selected
     * @param series,         Series object selected
     * @param pricingGroupId, Pricing Identification group
     * @return BigDecimal
     * @throws Exception, Exception
     */
    public BigDecimal searchDiscountByPricingGroup(Partner partner, Series series, Integer pricingGroupId) throws Exception {

        try {

            //Search for pricing group
            PricingGroup pricingGroup = ItemFrame.getApplicationBase().getPricingGroup(pricingGroupId);
            TypePriceCategory typePriceCategory = searchForTypePriceCategory(pricingGroup.getId());

            //Search for partner line discounts
            List<PartnerLineDiscount> lineDiscounts = searchForPartnerLineDiscounts(partner.getPartnerid(), series.getId(),
                    typePriceCategory.getId());

            if (lineDiscounts == null || lineDiscounts.size() == 0) {
                List<PartnerGroupLineDiscount> groupLineDiscounts = searchForPartnerGroupLineDiscounts(partner.getGroupId(),
                        series.getId(), typePriceCategory.getId());

                assert groupLineDiscounts != null : new BigDecimal(groupLineDiscounts.get(0).getDiscount());

            } else {
                return new BigDecimal(lineDiscounts.get(0).getDiscount());
            }

            return new BigDecimal("0");

        } catch (AssertionError e) {
            logger.error(e.getMessage(), e);
            throw new Exception("Error trying to get a valid discount.");
        } catch (NullPointerException e) {
            logger.error(e.getMessage(), e);
            throw new Exception("Error trying to get a valid discount.");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new Exception("Error trying to get a valid discount.");
        }

    }

    //*****************************************************************************************
    //PRIVATE METHODS
    //*****************************************************************************************


    /**
     * Search for Price Group category
     *
     * @param pricingGroupId, PricingGroup
     * @return TypePriceCategory
     * @throws Exception, Exception
     */
    private TypePriceCategory searchForTypePriceCategory(Integer pricingGroupId) throws Exception {

        //Search for pricing group
        PricingGroup pricingGroup = ItemFrame.getApplicationBase().getPricingGroup(pricingGroupId);
        //Search for type price category
        return ItemFrame.getApplicationBase().getTypePriceCategory(pricingGroup.getPriceCategory());
    }

    /**
     * Search for Price Line Categories
     *
     * @param partnerId,           Partner Identification Key
     * @param seriesId,            Series Identification Key
     * @param typePriceCategoryId, Type Price Category Identification Key
     * @return List<PartnerLineDiscount>
     * @throws Exception, Exception
     */
    private List<PartnerLineDiscount> searchForPartnerLineDiscounts(Integer partnerId, Integer seriesId, Integer typePriceCategoryId)
            throws Exception {

        try {

            //Search for partner line discounts
            return partnerLineDiscountEAO.findByPartnerId(partnerId, seriesId,
                    typePriceCategoryId);

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        }

    }

    /**
     * Search for Price Group Line Categories
     *
     * @param groupId,             Group Identification Key
     * @param seriesId,            Series Identification Key
     * @param typePriceCategoryId, Type Price Category Identification Key
     * @return List<PartnerGroupLineDiscount>
     * @throws Exception, Exception
     */
    private List<PartnerGroupLineDiscount> searchForPartnerGroupLineDiscounts(Integer groupId, Integer seriesId,
                                                                              Integer typePriceCategoryId) throws Exception {
        try {

            //Search for partner group line discounts
            return partnerGroupLineDiscountEAO.findByGroupId(groupId,
                    seriesId, typePriceCategoryId);

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        }

    }
}

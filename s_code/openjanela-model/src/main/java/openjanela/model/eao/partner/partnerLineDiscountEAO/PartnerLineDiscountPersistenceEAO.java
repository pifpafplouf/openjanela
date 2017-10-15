package openjanela.model.eao.partner.partnerLineDiscountEAO;

import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.PersistenceManagementServiceRemoteFactory;
import openjanela.model.eao.admin.partnersEAO.PartnersEAO;
import openjanela.model.eao.admin.partnersEAO.PartnersPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.genericEAO.PersistenceClassNotFoundException;
import openjanela.model.entities.admin.Partners;
import openjanela.model.entities.partner.PartnerLineDiscount;
import openjanela.model.entities.partner.PartnerLineDiscountPK;
import openjanela.model.entities.partner.SeriesAllowedSUThick;
import org.apache.log4j.Logger;

import javax.persistence.FlushModeType;
import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 10-21-12
 *          Time: 10:08 AM
 */
public class PartnerLineDiscountPersistenceEAO extends GenericPersistenceEAO<PartnerLineDiscount, PartnerLineDiscountPK>
        implements PartnerLineDiscountEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(PartnerLineDiscountPersistenceEAO.class);

    //Entity Access Object
    private PartnersEAO partnersEAO;

    /**
     * Rules Persistence Default Constructor
     */
    public PartnerLineDiscountPersistenceEAO () {
        partnersEAO = new PartnersPersistenceEAO();
    }

    /**
     * This method init a remote persistence service
     *
     * @param supplierId, Supplier Identification Id
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    protected void initRemoteService(Integer supplierId) throws GenericPersistenceEAOException {


        try {

            //Search supplier remote values
            Partners supplier = partnersEAO.findById(supplierId);

            //Getting persistence service
            em = PersistenceManagementServiceRemoteFactory.getEntityManager(supplier);

            //Added to prevent Flushing
            em.setFlushMode(FlushModeType.AUTO);

            PersistenceManagementServiceRemoteFactory.beginTransaction();

        } catch (PersistenceManagementServiceFactoryException e) {
            logger.error(e.getMessage(), e);
            throw new GenericPersistenceEAOException(e.getMessage(), e);
        }

    }

    /**
     * This method commit a remote persistence service
     *
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    protected void commitRemoteService() throws GenericPersistenceEAOException {
        try {
            PersistenceManagementServiceRemoteFactory.commit(true);
        } catch (PersistenceManagementServiceFactoryException e) {
            logger.error(e.getMessage(), e);
            throw new GenericPersistenceEAOException(e.getMessage(), e);
        }
    }

    /**
     * This method close a remote session service from entity access object
     *
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    protected void closeRemoteService() throws GenericPersistenceEAOException {
        try {
            PersistenceManagementServiceRemoteFactory.close();
        } catch (PersistenceManagementServiceFactoryException e) {
            logger.error(e.getMessage(), e);
            throw new GenericPersistenceEAOException(e.getMessage(), e);
        }
    }


    @Override
    public List<PartnerLineDiscount> findByPartnerId(Integer partnerId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            //String query builder
            String query = "select p from PartnerLineDiscount p where p.id.partnerId = :partnerId";

            //Executing query and retrieve collection
            List<PartnerLineDiscount> partnerLineDiscounts = em.createQuery(query).setParameter("partnerId", partnerId).getResultList();

            return partnerLineDiscounts;

        } finally {
            closeService();
        }
    }

    @Override
    public List<PartnerLineDiscount> findByPartnerId(Integer partnerId, Integer seriesId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            //String query builder
            String query = "select p from PartnerLineDiscount p where p.id.partnerId = :partnerId and p.id.seriesId = :seriesId";

            //Executing query and retrieve collection
            List<PartnerLineDiscount> partnerLineDiscounts = em.createQuery(query).setParameter("partnerId", partnerId).
                    setParameter("seriesId", seriesId).getResultList();

            return partnerLineDiscounts;

        } finally {
            closeService();
        }
    }

    @Override
    public List<PartnerLineDiscount> findByPartnerId(Integer partnerId, Integer seriesId, Integer priceCategoryId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            //String query builder
            String query = "select p from PartnerLineDiscount p where p.id.partnerId = :partnerId and p.id.seriesId = :seriesId " +
                    "and p.id.priceCategoryId = :priceCategoryId";

            //Executing query and retrieve collection
            List<PartnerLineDiscount> partnerLineDiscounts = em.createQuery(query).setParameter("partnerId", partnerId).
                    setParameter("seriesId", seriesId).setParameter("priceCategoryId", priceCategoryId).getResultList();

            return partnerLineDiscounts;

        } finally {
            closeService();
        }
    }

    @Override
    public List<PartnerLineDiscount> findRemoteByPartnerId(Integer supplierId, Integer partnerId) throws GenericPersistenceEAOException {
        try {

            //Init service
            initRemoteService(supplierId);

            //String query builder
            String query = "select p from PartnerLineDiscount p where p.id.partnerId = :partnerId";

            //Executing query and retrieve collection
            List<PartnerLineDiscount> partnerLineDiscounts = em.createQuery(query).setParameter("partnerId", partnerId).getResultList();

            return partnerLineDiscounts;

        } finally {
            closeRemoteService();
        }
    }
}

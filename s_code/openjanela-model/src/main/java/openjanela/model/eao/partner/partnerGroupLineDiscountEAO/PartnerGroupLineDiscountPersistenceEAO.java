package openjanela.model.eao.partner.partnerGroupLineDiscountEAO;

import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.PersistenceManagementServiceRemoteFactory;
import openjanela.model.eao.admin.partnersEAO.PartnersEAO;
import openjanela.model.eao.admin.partnersEAO.PartnersPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.Partners;
import openjanela.model.entities.partner.PartnerGroupLineDiscount;
import openjanela.model.entities.partner.PartnerGroupLineDiscountPK;
import org.apache.log4j.Logger;

import javax.persistence.FlushModeType;
import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 10-21-12
 *          Time: 11:47 AM
 */
public class PartnerGroupLineDiscountPersistenceEAO extends GenericPersistenceEAO<PartnerGroupLineDiscount, PartnerGroupLineDiscountPK>
        implements PartnerGroupLineDiscountEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(PartnerGroupLineDiscountPersistenceEAO.class);

    //Entity Access Object
    private PartnersEAO partnersEAO;

    /**
     * Rules Persistence Default Constructor
     */
    public PartnerGroupLineDiscountPersistenceEAO () {
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
    public List<PartnerGroupLineDiscount> findByGroupId(Integer groupId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            //String query builder
            String query = "select p from PartnerGroupLineDiscount p where p.id.groupId = :groupId";

            //Executing query and retrieve collection
            List<PartnerGroupLineDiscount> partnerGroupLineDiscounts = em.createQuery(query).setParameter("groupId", groupId).getResultList();

            return partnerGroupLineDiscounts;

        } finally {
            closeService();
        }
    }

    @Override
    public List<PartnerGroupLineDiscount> findByGroupId(Integer groupId, Integer seriesId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            //String query builder
            String query = "select p from PartnerGroupLineDiscount p where p.id.groupId = :groupId and p.id.seriesId = :seriesId";

            //Executing query and retrieve collection
            List<PartnerGroupLineDiscount> partnerGroupLineDiscounts = em.createQuery(query).setParameter("groupId", groupId)
                    .setParameter("seriesId", seriesId).getResultList();

            return partnerGroupLineDiscounts;

        } finally {
            closeService();
        }
    }

    @Override
    public List<PartnerGroupLineDiscount> findByGroupId(Integer groupId, Integer seriesId, Integer priceCategoryId) throws
            GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            //String query builder
            String query = "select p from PartnerGroupLineDiscount p where p.id.groupId = :groupId and p.id.seriesId = :seriesId" +
                    " and p.id.priceCategoryId = :priceCategoryId";

            //Executing query and retrieve collection
            List<PartnerGroupLineDiscount> partnerGroupLineDiscounts = em.createQuery(query).setParameter("groupId", groupId)
                    .setParameter("seriesId", seriesId).setParameter("priceCategoryId", priceCategoryId).getResultList();

            return partnerGroupLineDiscounts;

        } finally {
            closeService();
        }
    }

    @Override
    public List<PartnerGroupLineDiscount> findRemoteByGroupId(Integer supplierId, Integer groupId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initRemoteService(supplierId);

            //String query builder
            String query = "select p from PartnerGroupLineDiscount p where p.id.groupId = :groupId";

            //Executing query and retrieve collection
            List<PartnerGroupLineDiscount> partnerGroupLineDiscounts = em.createQuery(query).setParameter("groupId", groupId).getResultList();

            return partnerGroupLineDiscounts;

        } finally {
            closeRemoteService();
        }
    }
}

package openjanela.model.eao.partner.adjustmentRO_EAO;

import java.util.List;

import javax.persistence.FlushModeType;
import javax.persistence.Query;

import openjanela.model.PersistenceManagementServiceFactory;
import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.PersistenceManagementServicePartnerFactory;
import openjanela.model.PersistenceManagementServiceRemoteFactory;
import openjanela.model.eao.admin.partnersEAO.PartnersEAO;
import openjanela.model.eao.admin.partnersEAO.PartnersPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.Partners;
import openjanela.model.entities.partner.AdjustmentRo;
import openjanela.model.entities.partner.AdjustmentRoPK;

import org.apache.log4j.Logger;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-25-12
 *          Time: 02:27 PM
 */
public class AdjustmentRO_PersistenceEAO extends GenericPersistenceEAO<AdjustmentRo, AdjustmentRoPK> implements AdjustmentRO_EAO {

    // Apache log4j
    private static final Logger logger = Logger.getLogger(AdjustmentRO_PersistenceEAO.class);

    //Entity Access Object
    private PartnersEAO partnersEAO;

    /**
     * Adjustment RO Default Constructor
     */
    public AdjustmentRO_PersistenceEAO() {
        this.partnersEAO = new PartnersPersistenceEAO();
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
    public List<AdjustmentRo> findROs(int seriesId) throws GenericPersistenceEAOException {
        try {

            //Init service
            initService();

            StringBuffer query = new StringBuffer();
            query.append("select r from AdjustmentRo r where r.adjustmentRoPK.seriesId = :seriesId");

            List<AdjustmentRo> ros = em.createQuery(query.toString()).setParameter("seriesId", seriesId).getResultList();

            return ros;

        } finally {
            closeService();
        }
    }

    @Override
    public List<AdjustmentRo> findROs(int seriesId, boolean isHead) throws GenericPersistenceEAOException {

        try {

            initService();

            String hql = "select r from AdjustmentRo r where r.adjustmentRoPK.seriesId = :seriesId and r.isHead= :isHead";

            Query query = em.createQuery(hql);

            query.setParameter("seriesId", seriesId);
            query.setParameter("isHead", isHead);

            // Executing query and retrieve collection
            List<AdjustmentRo> ros = query.getResultList();

            return ros;

        } finally {
            closeService();
        }
    }

    @Override
    public List<AdjustmentRo> findRemoteROs(int seriesId, int supplierId) throws GenericPersistenceEAOException {
        try {

            //Init service
            initRemoteService(supplierId);

            StringBuffer query = new StringBuffer();
            query.append("select r from AdjustmentRo r where r.adjustmentRoPK.seriesId = :seriesId");

            List<AdjustmentRo> ros = em.createQuery(query.toString()).setParameter("seriesId", seriesId).getResultList();

            return ros;

        } finally {
            closeRemoteService();
        }
    }

    @Override
    public List<AdjustmentRo> findRemoteROs(int seriesId, int supplierId, boolean isHead) throws GenericPersistenceEAOException {
        try {

            //Init service
            initRemoteService(supplierId);

            StringBuffer query = new StringBuffer();
            query.append("select r from AdjustmentRo r where r.adjustmentRoPK.seriesId = :seriesId");

            List<AdjustmentRo> ros = em.createQuery(query.toString()).setParameter("seriesId", seriesId).getResultList();

            return ros;

        } finally {
            closeRemoteService();
        }
    }

}

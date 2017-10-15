package openjanela.model.eao.partner.jobItemEAO;

import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.PersistenceManagementServiceRemoteFactory;
import openjanela.model.eao.admin.partnersEAO.PartnersEAO;
import openjanela.model.eao.admin.partnersEAO.PartnersPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.genericEAO.PersistenceClassNotFoundException;
import openjanela.model.entities.admin.Partners;
import openjanela.model.entities.design.DesignGlassEntityObject;
import openjanela.model.entities.design.DesignOptionEntityObject;
import openjanela.model.entities.partner.JobItem;
import org.apache.log4j.Logger;

import javax.persistence.FlushModeType;
import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 12-17-12
 *          Time: 11:50 PM
 */
public class JobItemPersistenceEAO extends GenericPersistenceEAO<JobItem, Integer> implements JobItemEAO {

    // Apache log4j
    private static final Logger logger = Logger.getLogger(JobItemPersistenceEAO.class);

    //Entity Access Object
    private PartnersEAO partnersEAO;

    /**
     * Partner Persistence Default Constructor
     */
    public JobItemPersistenceEAO() {
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
    public int getNextOrderID() throws GenericPersistenceEAOException {

        //Init service
        initService();

        //String query
        String query = "select max(j.orderId) from JobItem j";

        //Getting max order ID
        Number orderID = (Number) em.createQuery(query).getSingleResult();

        //Return 1 if result is empty
        if (orderID == null)
            return 1;

        return orderID.intValue() + 1;
    }

    @Override
    public JobItem findByOrderItems(int orderId, int itemId, int versionId) throws GenericPersistenceEAOException {

        //Init service
        initService();

        JobItem entity = (JobItem) em.createQuery("select j from JobItem j where j.orderId = :orderId and " +
                "j.itemId = :itemId and j.versionId = :versionId").
                setParameter("orderId", orderId).
                setParameter("itemId", itemId).
                setParameter("versionId", versionId).getSingleResult();

        return entity;
    }

    @Override
    public JobItem findByPredefinedDesignId(int predefinedDesignId, int seriesId) throws PersistenceClassNotFoundException,
            GenericPersistenceEAOException {

        //Init service
        initService();

        JobItem entity = (JobItem) em.createQuery("select j from JobItem j where j.predefineDesignId = :predefineDesignId " +
                "and j.predefineDesignSeriesId = :predefineSeriesId").setParameter("predefineDesignId", predefinedDesignId).
                setParameter("predefineSeriesId", seriesId).getSingleResult();

        if (entity == null) {
            throw new PersistenceClassNotFoundException(predefinedDesignId);
        }

        return entity;
    }

    @Override
    public JobItem findByOrderParameters(int orderId, int itemId, int versionId) throws GenericPersistenceEAOException {

        //Init service
        initService();

        JobItem entity = (JobItem) em.createQuery("select j from JobItem j where j.orderId = :orderId " +
                "and j.itemId = :itemId and j.versionId = :versionId").setParameter("orderId", orderId).
                setParameter("itemId", itemId).setParameter("versionId", versionId).getSingleResult();

        if (entity == null) {
            throw new PersistenceClassNotFoundException(itemId);
        }

        return entity;
    }

    @Override
    public List<JobItem> findByOrderId(int orderId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            List<JobItem> jobItems = em.createQuery("select j from JobItem j where j.orderId = :orderId").
                    setParameter("orderId", orderId).getResultList();

            return jobItems;

        } finally {
            //Stop service
            closeService();

        }
    }

    @Override
    public List<DesignOptionEntityObject> findDesignOptions(int orderId, int itemId, int versionId) throws GenericPersistenceEAOException {
        try {

            //Init service
            initService();

            List<DesignOptionEntityObject> options = em.createQuery("select options from JobItem j " +
                    "inner join j.designOptions options where j.orderId = :orderId and j.itemId = :itemId and " +
                    "j.versionId = :versionId").
                    setParameter("orderId", orderId).
                    setParameter("itemId", itemId).
                    setParameter("versionId", versionId).getResultList();

            return options;

        } finally {
            closeService();
        }
    }

    @Override
    public List<DesignGlassEntityObject> findDesignGlass(int orderId, int itemId, int versionId) throws GenericPersistenceEAOException {
        try {

            //Init service
            initService();

            List<DesignGlassEntityObject> options = em.createQuery("select glass from JobItem j " +
                    "inner join j.glassBoms glass where j.orderId = :orderId and j.itemId = :itemId and " +
                    "j.versionId = :versionId").
                    setParameter("orderId", orderId).
                    setParameter("itemId", itemId).
                    setParameter("versionId", versionId).getResultList();

            return options;

        } finally {
            closeService();
        }
    }

    @Override
    public void updateOrderItems(int oldOrderId, int newOrderId) throws GenericPersistenceEAOException {

        try {
            //Init service
            initService();

            em.createQuery("update JobItem j set j.orderId = :newOrderId where j.orderId = :oldOrderId").executeUpdate();

        } finally {
            //Stop service
            closeService();

        }
    }

    @Override
    public void removeByOrderItems(int orderId, int itemId, int versionId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            em.createQuery("delete from JobItem j where j.orderId = :orderId and j.itemId = :itemId and " +
                    "j.versionId = :versionId").
                    setParameter("orderId", orderId).
                    setParameter("itemId", itemId).
                    setParameter("versionId", versionId).executeUpdate();

        } finally {
            //Stop service
            closeService();
        }
    }

    @Override
    public void createRemote(Integer supplierId, JobItem jobItem) throws GenericPersistenceEAOException {

        try {

            //Init service
            initRemoteService(supplierId);

            em.persist(jobItem);

        } finally {
            closeRemoteService();
        }
    }

}

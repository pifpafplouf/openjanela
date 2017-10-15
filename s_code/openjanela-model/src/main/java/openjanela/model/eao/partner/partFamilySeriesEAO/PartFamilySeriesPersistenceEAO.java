package openjanela.model.eao.partner.partFamilySeriesEAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.FlushModeType;
import javax.persistence.Query;

import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.PersistenceManagementServiceRemoteFactory;
import openjanela.model.eao.admin.partnersEAO.PartnersEAO;
import openjanela.model.eao.admin.partnersEAO.PartnersPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.Partners;
import openjanela.model.entities.partner.PartnerDefault;
import openjanela.model.entities.parts.PartFamilySeries;
import openjanela.model.entities.parts.PartsFamily;

import org.apache.log4j.Logger;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-30-12
 *          Time: 10:28 PM
 */
public class PartFamilySeriesPersistenceEAO extends GenericPersistenceEAO<PartFamilySeries, Integer> implements PartFamilySeriesEAO {

    // Apache log4j
    private static final Logger logger = Logger.getLogger(PartFamilySeriesPersistenceEAO.class);

    //Entity Access Object
    private PartnersEAO partnersEAO;

    /**
     * Part Family Series Persistence Default Constructor
     */
    public PartFamilySeriesPersistenceEAO() {
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
    public List<PartFamilySeries> findBySeries(int sid) throws GenericPersistenceEAOException {

        try {

            // Init service
            initService();

            List<PartFamilySeries> pfseries = new ArrayList();
            Query query = em.createQuery("select p from PartFamilySeries p PartFamilySeriesPK.seriesid= :sid");

            query.setParameter("sid", sid);

            return pfseries;

        } finally {
            closeService();
        }

    }

    @Override
    public List<PartFamilySeries> findAllRemote(int supplierId) throws GenericPersistenceEAOException {
        try {

            // Init service
            initRemoteService(supplierId);

            return em.createQuery("select p from PartFamilySeries p ").getResultList();

        } finally {
            closeRemoteService();
        }

    }

}

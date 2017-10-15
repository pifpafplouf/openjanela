package openjanela.model.eao.partner.seriesEAO;

import java.util.ArrayList;
import java.util.List;

import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.PersistenceManagementServiceRemoteFactory;
import openjanela.model.eao.admin.partnersEAO.PartnersEAO;
import openjanela.model.eao.admin.partnersEAO.PartnersPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.partner.partnerEAO.PartnerPersistenceEAO;
import openjanela.model.entities.admin.Partners;
import openjanela.model.entities.partner.Series;

import org.apache.log4j.Logger;

import javax.persistence.FlushModeType;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-30-12
 *          Time: 10:28 PM
 */
public class SeriesPersistenceEAO extends GenericPersistenceEAO<Series, Integer> implements SeriesEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(PartnerPersistenceEAO.class);

    //Entity Access Object
    private PartnersEAO partnersEAO;

    /**
     * Series Persistence Default Constructor
     */
    public SeriesPersistenceEAO () {
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
    public List<Series> findAllSeriesForSuppliers(Integer supplierId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            //String query builder
            StringBuffer query = new StringBuffer();

            List<Series> series;

            if (supplierId > 0) {
                query.append("select s from Series s, Partner p where s.supplierId = p.partnerid and s.supplierId = :supplierId and s.isseg = 0 order by s.displayOrder");
                series = em.createQuery(query.toString()).setParameter("supplierId", supplierId).getResultList();
            } else {
                query.append("select s from Series s where s.madeIn = true and s.isseg = 0  order by s.displayOrder");
                series = em.createQuery(query.toString()).getResultList();

            }

            if (series == null) {
                logger.error("Not valid series found for supplier");

                series = new ArrayList<Series>();
            }

            return series;

        } finally {
            closeService();
        }
    }

    @Override
    public List<Series> findAllSeriesSubRoutines() throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            return em.createQuery("select s from Series s where s.isseg > 0").getResultList();

        } finally {
            closeService();
        }
    }

    @Override
    public List<Series> findAllSeriesSubRoutines(String inClause) throws GenericPersistenceEAOException {

        try {
            //Init Service
            initService();

            return em.createQuery("select s from Series s where s.id in (" + inClause + ") order by s.id").getResultList();

        } finally {
            closeService();
        }
    }

    @Override
    public Series findRemoteById(Integer seriesId, Integer supplierId) throws GenericPersistenceEAOException {
        try {

            //Init Remote Service
            initRemoteService(supplierId);

            List<Series> series = em.createQuery("select s from Series s where s.id = :seriesId").
                    setParameter("seriesId", seriesId).getResultList();

            if (series.size() > 0) {
                return series.get(0);
            } else {
                return null;
            }

        } finally {
            closeRemoteService();
        }
    }

    @Override
    public List<Series> findAllRemoteSeriesSubRoutines(String inClause, Integer supplierId) throws GenericPersistenceEAOException {
        try {

            //Init Remote Service
            initRemoteService(supplierId);

            return em.createQuery("select s from Series s where s.id in (" + inClause + ") order by s.id").getResultList();

        } finally {
            closeRemoteService();
        }
    }

    @Override
    public List<Integer> findAllSuppliersForSeries() throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            List<Integer> suppliersId = em.createQuery("select distinct(s.supplierId) from Series s where s.supplierId > 0 and s.isseg = 0").
                    getResultList();

            return suppliersId;

        } finally {
            closeService();
        }
    }

}

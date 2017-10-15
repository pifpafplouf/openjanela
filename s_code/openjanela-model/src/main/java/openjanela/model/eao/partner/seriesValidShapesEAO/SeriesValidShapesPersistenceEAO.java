package openjanela.model.eao.partner.seriesValidShapesEAO;

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
import openjanela.model.entities.partner.SeriesValidShapes;
import openjanela.model.entities.partner.SeriesValidShapesPK;
import org.apache.log4j.Logger;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 08-28-12
 *          Time: 03:01 PM
 */
public class SeriesValidShapesPersistenceEAO extends GenericPersistenceEAO<SeriesValidShapes, SeriesValidShapesPK>
        implements SeriesValidShapesEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(SeriesValidShapesPersistenceEAO.class);

    //Entity Access Object
    private PartnersEAO partnersEAO;

    /**
     * Series Valid Opening Shape Constructor
     */
    public SeriesValidShapesPersistenceEAO() {
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
    public List<SeriesValidShapes> findValidShapesBySeriesId(Integer seriesId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            //String query builder
            String query = "select svs from SeriesValidShapes svs where svs.id.seriesId = :seriesId";

            //Executing query and retrieve collection
            List<SeriesValidShapes> validShapes = em.createQuery(query).setParameter("seriesId", seriesId).getResultList();

            return validShapes;

        } finally {
            closeService();
        }
    }

    @Override
    public SeriesValidShapes getShape(int id) throws GenericPersistenceEAOException {

        try {

            initService();

            // Query string
            String hql = "select svs from SeriesValidShapes svs where svs.id.shapeId = :sid";
            Query query = em.createQuery(hql);
            query.setParameter("sid", id);

            SeriesValidShapes level = (SeriesValidShapes) query.getSingleResult();

            return level;

        } finally {
            closeService();
        }
    }

    @Override
    public List<SeriesValidShapes> findRemoteValidShapesBySeriesId(Integer seriesId, Integer supplierId)
            throws GenericPersistenceEAOException {

        try {

            //Init service
            initRemoteService(supplierId);

            //String query builder
            String query = "select svs from SeriesValidShapes svs where svs.id.seriesId = :seriesId";

            //Executing query and retrieve collection
            List<SeriesValidShapes> validShapes = em.createQuery(query).setParameter("seriesId", seriesId).getResultList();

            return validShapes;

        } finally {
            closeRemoteService();
        }
    }
}

package openjanela.model.eao.partner.seriesValidOpeningShapeEAO;

import java.util.List;

import javax.persistence.FlushModeType;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.PersistenceManagementServiceRemoteFactory;
import openjanela.model.eao.admin.partnersEAO.PartnersEAO;
import openjanela.model.eao.admin.partnersEAO.PartnersPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.genericEAO.PersistenceClassNotFoundException;
import openjanela.model.entities.admin.Partners;
import openjanela.model.entities.partner.SeriesValidOpeningShape;
import openjanela.model.entities.partner.SeriesValidOpeningShapePK;
import org.apache.log4j.Logger;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 10-04-12
 *          Time: 09:59 AM
 */
public class SeriesValidOpeningShapePersistenceEAO extends GenericPersistenceEAO<SeriesValidOpeningShape, SeriesValidOpeningShapePK>
        implements SeriesValidOpeningShapeEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(SeriesValidOpeningShapePersistenceEAO.class);

    //Entity Access Object
    private PartnersEAO partnersEAO;

    /**
     * Series Valid Opening Shape Constructor
     */
    public SeriesValidOpeningShapePersistenceEAO() {
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
    public List<SeriesValidOpeningShape> findValidOpeningsBySeriesId(Integer seriesId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            //String query builder
            StringBuffer query = new StringBuffer();
            query.append("select svos from SeriesValidOpeningShape svos where svos.id.seriesId = :seriesId order by svos.id.id");

            //Execute query and retrieve collection
            List<SeriesValidOpeningShape> validOpeningShapes = em.createQuery(query.toString()).
                    setParameter("seriesId", seriesId).getResultList();

            return validOpeningShapes;

        } finally {
            //Stop service
            closeService();
        }
    }

    @Override
    public SeriesValidOpeningShape findUDOpening(int openingId, int seriesId) throws PersistenceClassNotFoundException,
            GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            StringBuffer query = new StringBuffer();
            query.append("select svos from SeriesValidOpeningShape svos where svos.seriesValidOpeningPK.id = :openingId ");
            query.append("and svos.seriesValidOpeningPK.seriesId = :seriesId");

            //Create Query String
            SeriesValidOpeningShape validOpening = (SeriesValidOpeningShape) em.createQuery(query.toString()).
                    setParameter("openingId", openingId).setParameter("seriesId", seriesId).getSingleResult();

            return validOpening;

        } catch (NoResultException e) {
            logger.error(e.getMessage(), e);
            throw new PersistenceClassNotFoundException(e.getMessage(), e);
        } finally {
            //Stop service
            closeService();
        }
    }

    @Override
    public List<SeriesValidOpeningShape> findRemoteValidOpeningsBySeriesId(Integer seriesId, Integer supplierId)
            throws GenericPersistenceEAOException {

        try {

            //Init service
            initRemoteService(supplierId);

            //String query builder
            StringBuffer query = new StringBuffer();
            query.append("select svos from SeriesValidOpeningShape svos where svos.id.seriesId = :seriesId order by svos.id.id");

            //Execute query and retrieve collection
            List<SeriesValidOpeningShape> validOpeningShapes = em.createQuery(query.toString()).
                    setParameter("seriesId", seriesId).getResultList();

            return validOpeningShapes;

        } finally {
            //Stop service
            closeRemoteService();
        }
    }

}

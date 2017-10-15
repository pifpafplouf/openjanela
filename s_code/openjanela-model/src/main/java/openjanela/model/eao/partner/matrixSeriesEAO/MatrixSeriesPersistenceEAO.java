package openjanela.model.eao.partner.matrixSeriesEAO;

import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.PersistenceManagementServiceRemoteFactory;
import openjanela.model.eao.admin.partnersEAO.PartnersEAO;
import openjanela.model.eao.admin.partnersEAO.PartnersPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.Partners;
import openjanela.model.entities.partner.MatrixSeries;
import org.apache.log4j.Logger;

import javax.persistence.FlushModeType;
import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 10-22-12
 *          Time: 09:36 PM
 */
public class MatrixSeriesPersistenceEAO extends GenericPersistenceEAO<MatrixSeries, Integer> implements MatrixSeriesEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(MatrixSeriesPersistenceEAO.class);

    //Entity Access Object
    private PartnersEAO partnersEAO;

    /**
     * Matrix Series Default Constructor
     */
    public MatrixSeriesPersistenceEAO() {
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
    public List<Integer> findAllSeries() throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            String query = "select ms.id.matrixid from MatrixSeries ms order by ms.id.matrixid";

            List<Integer> matrixSeries = em.createQuery(query).getResultList();

            return matrixSeries;

        } finally {
            closeService();
        }
    }

    @Override
    public List<Integer> findBySeries(int seriesId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            String query = "select ms.id.matrixid from MatrixSeries ms where ms.id.seriesid = :seriesId order by ms.id.matrixid";

        
            List<Integer> matrixHeaders = em.createQuery(query).setParameter("seriesId", seriesId).getResultList();
            
     
            return matrixHeaders;

        } finally {
            closeService();
        }
    }
    
   
    @Override
    public List<Integer> findByRemoteSeries(int seriesId, int supplierId) throws GenericPersistenceEAOException {
        try {

            //Init service
            initRemoteService(supplierId);

            String query = "select ms.id.matrixid from MatrixSeries ms where ms.id.seriesid = :seriesId order by ms.id.matrixid";

            List<Integer> matrixHeaders = em.createQuery(query).setParameter("seriesId", seriesId).getResultList();

            return matrixHeaders;

        } finally {
            closeRemoteService();
        }
    }
    
   
}

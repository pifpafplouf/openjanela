package openjanela.model.eao.partner.typeCouplerMullionEAO;

import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.PersistenceManagementServiceRemoteFactory;
import openjanela.model.eao.admin.partnersEAO.PartnersEAO;
import openjanela.model.eao.admin.partnersEAO.PartnersPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.Partners;
import openjanela.model.entities.partner.TypeCouplerMullion;
import openjanela.model.entities.partner.TypeCouplerMullionPK;
import org.apache.log4j.Logger;

import javax.persistence.FlushModeType;
import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8z
 *          Date: 09-19-12
 *          Time: 03:43 PM
 */
public class TypeCouplerMullionPersistenceEAO extends GenericPersistenceEAO<TypeCouplerMullion, TypeCouplerMullionPK>
        implements TypeCouplerMullionEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(TypeCouplerMullionPersistenceEAO.class);

    //Entity Access Object
    private PartnersEAO partnersEAO;

    /**
     * Matrix Persistence Default Constructor
     */
    public TypeCouplerMullionPersistenceEAO() {
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
    public List<TypeCouplerMullion> findBySeriesId(Integer seriesId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            //String query builder
            String query = "select tcm from TypeCouplerMullion tcm where tcm.id.seriesId = :seriesId";

            //Executing query and retrieve collection
            List<TypeCouplerMullion> typeCouplerMullions = em.createQuery(query).setParameter("seriesId", seriesId).getResultList();

            return typeCouplerMullions;

        } finally {
            closeService();
        }
    }

    @Override
    public List<TypeCouplerMullion> findRemoteBySeriesId(Integer seriesId, Integer supplierId) throws GenericPersistenceEAOException {
        try {

            //Init service
            initRemoteService(supplierId);

            //String query builder
            String query = "select tcm from TypeCouplerMullion tcm where tcm.id.seriesId = :seriesId";

            //Executing query and retrieve collection
            List<TypeCouplerMullion> typeCouplerMullions = em.createQuery(query).setParameter("seriesId", seriesId).getResultList();

            return typeCouplerMullions;

        } finally {
            closeRemoteService();
        }
    }
}

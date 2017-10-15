package openjanela.model.eao.partner.suTypeEAO;

import java.sql.Timestamp;
import java.util.List;

import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.PersistenceManagementServiceRemoteFactory;
import openjanela.model.eao.admin.partnersEAO.PartnersEAO;
import openjanela.model.eao.admin.partnersEAO.PartnersPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.Partners;
import openjanela.model.entities.design.Metrics;
import openjanela.model.entities.partner.SUType;

import org.apache.log4j.Logger;

import javax.persistence.FlushModeType;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 09-13-12
 *          Time: 04:29 PM
 */
public class SUTypePersistenceEAO extends GenericPersistenceEAO<SUType, Integer> implements SUTypeEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(SUTypePersistenceEAO.class);

    //Entity Access Object
    private PartnersEAO partnersEAO;

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

    /**
     * SUType Persistence Constructor
     */
    public SUTypePersistenceEAO() {
        this.partnersEAO = new PartnersPersistenceEAO();
    }

    @Override
    public List<SUType> findByGlazingType(Integer glazingType) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            //String query builder
            String query = "select s from SUType s where s.glazingType = :glazingType order by s.sortSeq";

            List<SUType> suTypes = em.createQuery(query).setParameter("glazingType", glazingType).getResultList();

            return suTypes;

        } finally {
            closeService();
        }
    }

    @Override
    public List<SUType> findByThickness(int unitOfMetric, Integer fromThickness, Integer toThickness, Timestamp actualDate)
            throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            //String query builder
            String query = "";

            if (Metrics.METRIC.getValue() == unitOfMetric) {

                query = "select sut from SUType sut where sut.thickness >= :fromThickness and sut.thickness <= :toThickness and" +
                        " :actualDate >= sut.startDate and :actualDate <= sut.endDate and sut.display = true  order by sut.sortSeq";

            } else if (Metrics.IMPERIAL_DECIMAL.getValue() == unitOfMetric) {

                query = "select sut from SUType sut where sut.thicknessImp >= :fromThickness and sut.thicknessImp <= :toThickness and" +
                        " :actualDate >= sut.startDate and :actualDate <= sut.endDate and sut.display = true  order by sut.sortSeq";
            }

            //Execution query and return collection
            List<SUType> suTypes = em.createQuery(query).setParameter("fromThickness", fromThickness).setParameter("toThickness",
                    toThickness).
                    setParameter("actualDate", actualDate).getResultList();

            return suTypes;

        } finally {
            closeService();
        }

    }

    @Override
    public List<SUType> findAllRemote(int supplierId) throws GenericPersistenceEAOException {

        try {

            //Init Remote service
            initRemoteService(supplierId);

            //String query builder
            String query = "select s from SUType s order by s.sortSeq";

            List<SUType> suTypes = em.createQuery(query).getResultList();

            return suTypes;

        } finally {
            closeRemoteService();
        }
    }

	@Override
	public SUType findByStockCode(String stockCode)
			throws GenericPersistenceEAOException {
		try {

            //Init service
            initService();

            //String query builder
            String query = "select s from SUType s where s.stockCode = :stockCode";

            SUType suTypes = (SUType) em.createQuery(query).setParameter("stockCode", stockCode).getSingleResult();

            return suTypes;

        } finally {
            closeService();
        }
		
	}
}


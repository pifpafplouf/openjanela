package openjanela.model.eao.partner.optionsEAO;

import java.util.List;

import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.PersistenceManagementServiceRemoteFactory;
import openjanela.model.eao.admin.partnersEAO.PartnersEAO;
import openjanela.model.eao.admin.partnersEAO.PartnersPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.admin.Partners;
import openjanela.model.entities.partner.OptionAnswers;

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
public class OptionAnswersPersistenceEAO extends GenericPersistenceEAO<OptionAnswers, Integer> implements OptionAnswersEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(OptionAnswersPersistenceEAO.class);

    //Entity Access Object
    private PartnersEAO partnersEAO;

    /**
     * Rules Persistence Default Constructor
     */
    public OptionAnswersPersistenceEAO () {
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
    public List<OptionAnswers> findByOption(Integer optionId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            List<OptionAnswers> optionAnswers = em.createQuery(
                    "select oa from OptionAnswers oa where oa.id.optionId = :optionId order by oa.id.id").
                    setParameter("optionId", optionId).getResultList();

            return optionAnswers;

        } finally {
            //Close service
            closeService();
        }
    }

    @Override
    public List<OptionAnswers> findAll() throws GenericPersistenceEAOException {

        try {

            // Init service
            initService();

            List<OptionAnswers> optionAnswers = em.createQuery("select oa from OptionAnswers oa  order by oa.id.id")
                    .getResultList();

            return optionAnswers;

        } finally {
            // Close service
            closeService();
        }
    }


    @Override
    public List<OptionAnswers> findRemoteByOption(Integer optionId, Integer supplierId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initRemoteService(supplierId);

            List<OptionAnswers> optionAnswers = em.createQuery(
                    "select oa from OptionAnswers oa where oa.id.optionId = :optionId order by oa.id.id").
                    setParameter("optionId", optionId).getResultList();

            return optionAnswers;

        } finally {
            //Close service
            closeRemoteService();
        }
    }


}

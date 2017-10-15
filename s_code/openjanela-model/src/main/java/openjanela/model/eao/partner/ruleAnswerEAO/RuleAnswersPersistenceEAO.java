package openjanela.model.eao.partner.ruleAnswerEAO;

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
import openjanela.model.entities.partner.RuleAnswers;
import openjanela.model.entities.partner.RuleAnswersPK;

import org.apache.log4j.Logger;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-30-12
 *          Time: 10:28 PM
 */
public class RuleAnswersPersistenceEAO extends GenericPersistenceEAO<RuleAnswers, RuleAnswersPK> implements RuleAnswersEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(RuleAnswersPersistenceEAO.class);

    //Entity Access Object
    private PartnersEAO partnersEAO;

    /**
     * Rule Answers Persistence Default Constructor
     */
    public RuleAnswersPersistenceEAO() {
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
    public List<RuleAnswers> findAllAnswers(int seriesId) throws GenericPersistenceEAOException {

        try {

            // Init service
            initService();

            Query query = em.createQuery("select r from RuleAnswers r where r.ruleAnswersPK.seriesid = :seriesId " +
                    "order by r.ruleAnswersPK.seriesid, r.ruleAnswersPK.ruleno");

            List<RuleAnswers> answers = query.setParameter("seriesId", seriesId).getResultList();

            return answers;

        } finally {
            closeService();
        }
    }

    @Override
    public List<RuleAnswers> findAllRemoteAnswers(int seriesId, int supplierId) throws GenericPersistenceEAOException {
        try {

            // Init Remote Service
            initRemoteService(supplierId);

            Query query = em.createQuery("select r from RuleAnswers r where r.ruleAnswersPK.seriesid = :seriesId  " +
                    "order by r.ruleAnswersPK.seriesid, r.ruleAnswersPK.ruleno");

            List<RuleAnswers> answers = query.setParameter("seriesId", seriesId).getResultList();

            return answers;

        } finally {
            closeRemoteService();
        }
    }

}

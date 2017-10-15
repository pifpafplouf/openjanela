package openjanela.model.eao.partner.seriesEAO;

import javax.persistence.Query;

import openjanela.model.PersistenceManagementServiceFactory;
import openjanela.model.PersistenceManagementServiceFactoryException;
import openjanela.model.PersistenceManagementServicePartnerFactory;
import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.SeriesCategory;

import org.apache.log4j.Logger;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 07-30-12
 *          Time: 10:28 PM
 */
public class SeriesCategoryPersistenceEAO extends GenericPersistenceEAO<SeriesCategory, Integer> implements SeriesCategoryEAO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(SeriesCategoryPersistenceEAO.class);

    @Override
    public SeriesCategory findCategory(int seriesid) throws GenericPersistenceEAOException {

        try {

            // Init service
            initService();

            // String query builder
            String hql = "select sc from SeriesCategory sc where sc.id = :seriesid order by sc.id";

            Query query = em.createQuery(hql);
            query.setParameter("seriesid", seriesid);

            return (SeriesCategory) query.getSingleResult();

        } finally {
            closeService();
        }
    }

}

package openjanela.model.eao.partner.seriesValidOpeningsEAO;

import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.partner.SeriesValidOpenings;
import openjanela.model.entities.partner.SeriesValidOpeningsPK;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 08-30-12
 *          Time: 09:29 AM
 */
public class SeriesValidOpeningsPersistenceEAO extends GenericPersistenceEAO<SeriesValidOpenings, SeriesValidOpeningsPK>
        implements SeriesValidOpeningsEAO {


    @Override
    public List<SeriesValidOpenings> findValidOpeningsBySeriesId(Integer seriesId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            //String query builder
            String query = "select svo from SeriesValidOpenings svo where svo.id.seriesId = :seriesId";

            //Executing query and retrieve collection
            List<SeriesValidOpenings> validOpenings = em.createQuery(query).setParameter("seriesId", seriesId).getResultList();

            return validOpenings;

        } finally {
            closeService();
        }
    }
}

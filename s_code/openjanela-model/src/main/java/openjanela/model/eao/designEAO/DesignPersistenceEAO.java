package openjanela.model.eao.designEAO;

import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.design.Design;
import openjanela.model.entities.design.DesignPK;

import java.util.List;

import javax.persistence.FlushModeType;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 01-19-13
 *          Time: 02:09 PM
 */
public class DesignPersistenceEAO extends GenericPersistenceEAO<Design, DesignPK> implements DesignEAO {

    @Override
    public int getNextId() throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            //String query
            String query = "select max(d.id.id) from Design d";

            //Getting max order ID
            Number id = (Number) em.createQuery(query).getSingleResult();

            //Return 1 if result is empty
            if (id == null)
                return 1;

            return id.intValue() + 1;

        } finally {
            closeService();
        }
    }

    @Override
    public List<Design> findByFamilyId(Integer familyId, Integer seriesId) throws GenericPersistenceEAOException {

        try {

            //init service
            initService();

            List<Design> designs = em.createQuery("select d from Design d where d.designFamily = :familyId and " +
                    "d.id.seriesId = :seriesId order by d.id.id").setParameter("familyId", familyId).
                    setParameter("seriesId", seriesId).getResultList();

            return designs;

        } finally {
            closeService();
        }
    }
}

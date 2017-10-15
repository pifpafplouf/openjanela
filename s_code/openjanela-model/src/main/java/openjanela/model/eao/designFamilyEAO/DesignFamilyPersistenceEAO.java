package openjanela.model.eao.designFamilyEAO;

import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.design.DesignFamily;
import openjanela.model.entities.design.DesignFamilyPK;

import java.util.List;

/**
 * Copyright (c) 2013, OpenJanela. All rights reserved.
 * User: Eddy Montenegro
 * Date: 01-19-13
 * Time: 10:37 PM
 */
public class DesignFamilyPersistenceEAO extends GenericPersistenceEAO<DesignFamily, DesignFamilyPK> implements DesignFamilyEAO {

    @Override
    public List<DesignFamily> findBySeries(Integer seriesId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            List<DesignFamily> designFamilyList = em.createQuery("Select d from DesignFamily d where d.id.seriesId = :seriesId").
                    setParameter("seriesId", seriesId).getResultList();

            return designFamilyList;

        } finally {
            //Stop service
            closeService();
        }
    }
}

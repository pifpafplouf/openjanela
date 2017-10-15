package openjanela.model.eao.designOptionsEAO;

import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.design.DesignOptionEntityObject;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 06-05-13
 *          Time: 02:29 PM
 */
public class DesignOptionsPersistenceEAO extends GenericPersistenceEAO<DesignOptionEntityObject, Integer> implements
        DesignOptionsEAO {

    @Override
    public List<DesignOptionEntityObject> findByJobItem(Integer jobItemId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            List<DesignOptionEntityObject> designOptions = em.createQuery("select options from JobItem job inner join " +
                    "job.designOptions options where job.id = :jobItemId  order by options.ruleno").
                    setParameter("jobItemId", jobItemId).getResultList();

            return designOptions;

        } finally {
            closeService();
        }
    }
}

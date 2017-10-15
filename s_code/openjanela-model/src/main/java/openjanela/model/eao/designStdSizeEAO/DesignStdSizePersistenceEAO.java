package openjanela.model.eao.designStdSizeEAO;

import openjanela.model.eao.genericEAO.GenericPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.design.DesignFamily;
import openjanela.model.entities.design.DesignFamilyPK;
import openjanela.model.entities.design.DesignStdSize;
import openjanela.model.entities.design.DesignStdSizePK;

import java.util.List;

/**
 * Copyright (c) 2013, OpenJanela. All rights reserved.
 * User: Eddy Montenegro
 * Date: 01-19-13
 * Time: 10:37 PM
 */
public class DesignStdSizePersistenceEAO extends GenericPersistenceEAO<DesignStdSize, DesignStdSizePK> implements DesignStdSizeEAO {

    @Override
    public List<DesignStdSize> findByDesignAndSeries(Integer designId, Integer seriesId) throws GenericPersistenceEAOException {

        try {

            //Init service
            initService();

            List<DesignStdSize> designStdSizeList = 
            		em.createQuery("Select d from DesignStdSize d where d.id.designid = :designId and d.id.seriesid = :seriesId").
            		setParameter("designId", designId).setParameter("seriesId", seriesId).getResultList();

            return designStdSizeList;

        } finally {
            //Stop service
            closeService();
        }
    }
}

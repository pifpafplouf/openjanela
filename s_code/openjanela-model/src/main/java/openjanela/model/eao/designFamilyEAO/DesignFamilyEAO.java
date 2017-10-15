package openjanela.model.eao.designFamilyEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.design.DesignFamily;
import openjanela.model.entities.design.DesignFamilyPK;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 01-19-13
 *          Time: 10:36 PM
 */
public interface DesignFamilyEAO extends GenericEAO<DesignFamily, DesignFamilyPK> {

    /**
     * Search design family values by series identification Id
     *
     * @param seriesId, Series Identification Id
     * @return List of DesignFamily values
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<DesignFamily> findBySeries(Integer seriesId) throws GenericPersistenceEAOException;
}

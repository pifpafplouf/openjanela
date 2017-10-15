package openjanela.model.eao.designStdSizeEAO;

import openjanela.model.eao.genericEAO.GenericEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.design.DesignStdSize;
import openjanela.model.entities.design.DesignStdSizePK;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 01-19-13
 *          Time: 10:36 PM
 */
public interface DesignStdSizeEAO extends GenericEAO<DesignStdSize, DesignStdSizePK> {

    /**
     * Search design family values by series identification Id
     *
     * @param seriesId, Series Identification Id
     * @return List of DesignFamily values
     * @throws openjanela.model.eao.genericEAO.GenericPersistenceEAOException,
     *          Exception
     */
    public List<DesignStdSize> findByDesignAndSeries(Integer designId, Integer seriesId) throws GenericPersistenceEAOException;
}

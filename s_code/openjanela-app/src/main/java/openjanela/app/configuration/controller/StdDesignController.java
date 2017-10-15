package openjanela.app.configuration.controller;

import openjanela.model.eao.designEAO.DesignEAO;
import openjanela.model.eao.designEAO.DesignPersistenceEAO;
import openjanela.model.eao.designFamilyEAO.DesignFamilyEAO;
import openjanela.model.eao.designFamilyEAO.DesignFamilyPersistenceEAO;
import openjanela.model.eao.designStdSizeEAO.DesignStdSizeEAO;
import openjanela.model.eao.designStdSizeEAO.DesignStdSizePersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.design.Design;
import openjanela.model.entities.design.DesignFamily;
import openjanela.model.entities.design.DesignStdSize;

import org.apache.log4j.Logger;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 01-19-13
 *          Time: 10:25 PM
 */
public class StdDesignController extends JobItemModelController {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(StdDesignController.class);

    //Entity Access Objects
    private DesignEAO designEAO;
    private DesignFamilyEAO designFamilyEAO;
    private DesignStdSizeEAO designStdSizeEAO;

    /**
     * Create Predefine td. Design Controller
     */
    public StdDesignController() {

        //Init design object
    	designStdSizeEAO = new DesignStdSizePersistenceEAO();
    }

    /**
     * This method load Standard Sizes for a given Design and series
     *
     * @param designId, seriesId
     * @return List of DesignStdSize
     */
    public List<DesignStdSize> getStdSizes(Integer designId, Integer seriesId) {

        try {
            return designStdSizeEAO.findByDesignAndSeries(designId, seriesId);
        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }

    

}

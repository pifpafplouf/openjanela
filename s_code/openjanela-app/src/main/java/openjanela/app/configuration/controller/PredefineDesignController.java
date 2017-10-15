package openjanela.app.configuration.controller;

import openjanela.model.eao.designEAO.DesignEAO;
import openjanela.model.eao.designEAO.DesignPersistenceEAO;
import openjanela.model.eao.designFamilyEAO.DesignFamilyEAO;
import openjanela.model.eao.designFamilyEAO.DesignFamilyPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.entities.design.Design;
import openjanela.model.entities.design.DesignFamily;

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
public class PredefineDesignController extends JobItemModelController {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(PredefineDesignController.class);

    //Entity Access Objects
    private DesignEAO designEAO;
    private DesignFamilyEAO designFamilyEAO;

    /**
     * Create Predefine Design Controller
     */
    public PredefineDesignController() {

        //Init design object
        designEAO = new DesignPersistenceEAO();
        designFamilyEAO = new DesignFamilyPersistenceEAO();
    }

    /**
     * This method load a design family values by series selection
     *
     * @param seriesId, Series selection value
     * @return List of DesignFamily
     */
    public List<DesignFamily> searchDesignFamily(Integer seriesId) {

        try {
            return designFamilyEAO.findBySeries(seriesId);
        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }

    /**
     * This method load a predefined design values by family id
     *
     * @param familyId, Family identification value
     * @return List of Design objects
     */
    public List<Design> searchPredefineDesignModels(Integer familyId, Integer seriesId) {

        try {
            return designEAO.findByFamilyId(familyId, seriesId);
        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }

}

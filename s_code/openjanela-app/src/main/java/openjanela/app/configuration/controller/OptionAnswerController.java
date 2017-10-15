package openjanela.app.configuration.controller;

import Presentation.ItemFrame;
import openjanela.model.eao.partner.optionsEAO.OptionAnswersEAO;
import openjanela.model.eao.partner.optionsEAO.OptionAnswersPersistenceEAO;
import openjanela.model.entities.partner.OptionAnswers;
import openjanela.model.entities.partner.OptionDefinitions;
import org.apache.log4j.Logger;
import org.openjanela.data.ApplicationBaseRulesApp;
import org.openjanela.data.ApplicationRemoteBaseRulesApp;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 03-25-13
 *          Time: 09:08 PM
 */
public class OptionAnswerController extends BaseController {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(OptionAnswerController.class);

    /**
     * Option Answer Controller Constructor
     */
    public OptionAnswerController() {
    }

    /**
     * Find All Options Answers By Option Definition
     *
     * @param optionDefinitions, Option Definition Object
     * @return List<OptionAnswers>
     */
    public List<OptionAnswers> findOptionAnswers(OptionDefinitions optionDefinitions) {

        if (optionDefinitions.isRemote()) {
            return ItemFrame.getApplicationRemoteBaseRules().getOptionAnswers(optionDefinitions.getSupplierID(),
                    optionDefinitions.getId());
        } else {
            return ApplicationBaseRulesApp.getInstance().getOptionAnswers(optionDefinitions.getId());
        }
    }

}

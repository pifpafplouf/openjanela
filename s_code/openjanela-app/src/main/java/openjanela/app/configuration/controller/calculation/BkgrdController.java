package openjanela.app.configuration.controller.calculation;

import Model.BkgrdOpeningObject;
import openjanela.app.configuration.controller.BaseController;
import openjanela.model.eao.partner.pricingGroupEAO.PricingGroupEAO;
import openjanela.model.entities.orderEntry.PricingGroup;
import org.apache.log4j.Logger;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 10-28-12
 * Time: 12:55 AM
 */
public class BkgrdController extends BaseController {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(GlassSUController.class);

    //******************************************************************************
    //Glass SU Object model
    //******************************************************************************
    private BkgrdOpeningObject openingObject;
    private PricingGroup pricingGroup;

    //******************************************************************************
    //Entity Access objects
    //******************************************************************************
    private PricingGroupEAO pricingGroupEAO;
}

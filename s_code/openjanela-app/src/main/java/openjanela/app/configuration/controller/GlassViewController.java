package openjanela.app.configuration.controller;

import Model.DesignGlass;
import Model.JobItemModel;
import Presentation.ItemFrame;
import openjanela.model.eao.admin.typeShapeEAO.TypeShapeEAO;
import openjanela.model.eao.admin.typeShapeEAO.TypeShapePersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.partner.seriesValidOpeningShapeEAO.SeriesValidOpeningShapeEAO;
import openjanela.model.eao.partner.seriesValidOpeningShapeEAO.SeriesValidOpeningShapePersistenceEAO;
import org.apache.log4j.Logger;

import java.util.Collection;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 03-22-13
 *          Time: 03:47 PM
 */
public class GlassViewController extends BaseController {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(GlassViewController.class);

    /**
     * Glass View Controller Constructor
     */
    public GlassViewController() {
    }

    /**
     * Update glass Bom Information
     */
    public void updateGlassBomInformation(JobItemModel jobItemModel) {

        if (logger.isDebugEnabled()) {
            logger.debug("Update Glass Bom Information");
        }

        for (DesignGlass designGlass : jobItemModel.glassBOM) {

            if (designGlass.remote) {
                designGlass.sashAbbreviation = ItemFrame.getApplicationRemoteBaseRules().
                        getSeriesValidOpeningById(designGlass.udOpeningID).getSeriesValidOpeningPK().getAbbreviation();

                designGlass.shapeAbbreviation = ItemFrame.getApplicationBase().getTypeShape(designGlass.shapeID).getAbbrev();
            } else {
                designGlass.sashAbbreviation = ItemFrame.getApplicationBaseRules().
                        getSeriesValidOpeningById(designGlass.udOpeningID).getSeriesValidOpeningPK().getAbbreviation();

                designGlass.shapeAbbreviation = ItemFrame.getApplicationBase().getTypeShape(designGlass.shapeID).getAbbrev();
            }

        }
    }
}

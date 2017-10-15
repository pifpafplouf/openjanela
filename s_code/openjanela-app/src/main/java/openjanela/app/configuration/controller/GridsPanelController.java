package openjanela.app.configuration.controller;

import Presentation.ItemFrame;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.partner.gridsEAO.GridsEAO;
import openjanela.model.eao.partner.gridsEAO.GridsPersistenceEAO;
import openjanela.model.entities.partner.Grids;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: Eddy Montenegro
 * Date: 02-11-13
 * Time: 11:45 AM
 */
public class GridsPanelController {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(GridsPanelController.class);

    //Entity Access Object
    private GridsEAO gridsEAO;

    public GridsPanelController() {

        //Init access objects
        gridsEAO = new GridsPersistenceEAO();
    }

    /**
     * Search all grids predefined loaded.
     *
     * @return List<Grids>
     * @throws Exception, Exception
     */
    public List<Grids> searchAllGrids() {

        if(logger.isDebugEnabled()) {
            logger.debug("Search all grids from options defined.");
        }

        List<Grids> grids = new ArrayList<Grids>();

        Grids noneGrids = new Grids();
        noneGrids.setId(-1);
        noneGrids.setDescription("None");

        grids.add(noneGrids);

        //Add Grids from Application Base Rules
        grids.addAll(ItemFrame.getApplicationBaseRules().getGrids());
        grids.addAll(ItemFrame.getApplicationRemoteBaseRules().getGrids());

        return grids;
    }

}

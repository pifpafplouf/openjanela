package openjanela.app.configuration.controller;

import java.util.ArrayList;
import java.util.List;

import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.partner.adjustmentRO_EAO.AdjustmentRO_EAO;
import openjanela.model.eao.partner.adjustmentRO_EAO.AdjustmentRO_PersistenceEAO;
import openjanela.model.entities.partner.AdjustmentRo;
import openjanela.model.entities.partner.AdjustmentRoPK;
import org.apache.log4j.Logger;
import org.openjanela.data.ApplicationBaseApp;
import org.openjanela.data.ApplicationBaseRulesApp;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: Eddy Montenegro
 * Date: 07-28-12
 * Time: 01:03 AM
 */
public class TopPanelController extends BaseController {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(TopPanelController.class);

    private List<AdjustmentRo> ros;

    protected AdjustmentRO_EAO adjustmentRO_EAO;

    /**
     * Main constructor
     */
    public TopPanelController() {

        this.ros = new ArrayList<AdjustmentRo>();

        adjustmentRO_EAO = new AdjustmentRO_PersistenceEAO();
    }

    /**
     * This method return a list of AdjustmentRO
     *
     * @param seriesId,  Series Identification Id
     * @param isHead,    is Head
     * @return List<Partner>
     */
    public List<AdjustmentRo> getROs(int seriesId, boolean isHead) {

        if (ros == null || ros.size() == 0) {
            //Adding partners
            ros = ApplicationBaseRulesApp.getInstance(seriesId).getAdjustmentRos(seriesId, isHead);
        }

        return ros;
    }

    /**
     * This method find Adjustment RO by his Primary Key
     *
     * @param roId,     Adjustment RO compound identification key
     * @param seriesId, Series identification key
     * @return AdjustmentRo
     * @throws Exception, Exception
     */
    public AdjustmentRo findRoByIdentification(int roId, int seriesId) throws Exception {

        List<AdjustmentRo> adjustmentRos = ApplicationBaseRulesApp.getInstance().getAdjustmentRos(seriesId, false);
        for (AdjustmentRo ro : adjustmentRos) {
            if (ro.getAdjustmentRoPK().getId() == roId) {
                return ro;
            }
        }

        return null;
    }
}

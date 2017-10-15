package openjanela.app.configuration.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.partner.partnerEAO.PartnerEAO;
import openjanela.model.eao.partner.partnerEAO.PartnerPersistenceEAO;
import openjanela.model.eao.partner.seriesEAO.SeriesEAO;
import openjanela.model.eao.partner.seriesEAO.SeriesPersistenceEAO;
import openjanela.model.entities.partner.Partner;
import openjanela.model.entities.partner.Series;

import org.apache.log4j.Logger;
import org.openjanela.data.ApplicationMainBaseApp;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: Eddy Montenegro
 * Date: 07-28-12
 * Time: 01:03 AM
 */
public class SupplierSelectorPanelController extends BaseController {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(SupplierSelectorPanelController.class);

    private List<Partner> partners;

    private Partner partnerSelected;
    private Series seriesSelected;

    //***********************************************
    //Getters and Setters
    //***********************************************

    public Partner getPartnerSelected() {
        return partnerSelected;
    }

    public void setPartnerSelected(Partner partnerSelected) {
        this.partnerSelected = partnerSelected;
    }

    public Series getSeriesSelected() {
        return seriesSelected;
    }

    public void setSeriesSelected(Series seriesSelected) {
        this.seriesSelected = seriesSelected;
    }

    //***********************************************
    //Entity access object
    //***********************************************
    protected PartnerEAO partnerEAO;
    protected SeriesEAO seriesEAO;

    /**
     * Supplier Selector panel controller constructor
     */
    public SupplierSelectorPanelController() {
        this.partners = new ArrayList<Partner>();

        partnerEAO = new PartnerPersistenceEAO();
        seriesEAO = new SeriesPersistenceEAO();
    }

    /**
     * Return List of partners
     *
     * @return List<Partner>
     */
    public List<Partner> getPartners() {

        if (partners == null || partners.isEmpty()) {

            //Adding partners pg_class
            partners = ApplicationMainBaseApp.getInstance().getSuppliers();
        }

        return partners;
    }

    /**
     * Return List of series
     *
     * @param supplierId, Supplier Identification
     * @return List<Series>
     */
    public List<Series> getSeries(Integer supplierId) {
        //Find all series for suppliers
        return ApplicationMainBaseApp.getInstance().getSeries(supplierId);
    }
}

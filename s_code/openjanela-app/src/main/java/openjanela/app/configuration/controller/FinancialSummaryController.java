package openjanela.app.configuration.controller;

import Presentation.ItemFrame;
import openjanela.model.entities.admin.TypePriceCategory;
import openjanela.model.entities.sales.SalesRepsCommission;

import org.apache.log4j.Logger;

import java.util.List;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 03-21-13
 *          Time: 03:14 PM
 */
public class FinancialSummaryController extends BaseController {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(FinancialSummaryController.class);

    //ItemFrame main container
    private ItemFrame myParent;

    /**
     * Financial Summary Controller Constructor
     *
     * @param myParent, ItemFrame
     */
    public FinancialSummaryController(ItemFrame myParent) {

        //Setting ItemFrame main container
        this.myParent = myParent;
    }

    /**
     * Return Type Price Categories
     *
     * @return List
     */
    public List<TypePriceCategory> getTypesPriceCategories() {
        return this.myParent.getApplicationBase().getTypePriceCategories();
    }
    
   public SalesRepsCommission getCommission(int repID){
	
	   return null;
   }
}

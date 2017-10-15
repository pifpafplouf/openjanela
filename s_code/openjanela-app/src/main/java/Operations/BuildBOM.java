/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Operations;

import java.util.List;

import Model.ShapeObject;
import Presentation.BomView;
import openjanela.model.entities.partner.Rules;
import Presentation.ItemFrame;
import Rules.ExecutePartRules;


public class BuildBOM {

    //Execute part Rules
    private ExecutePartRules execRules;

    //Item Frame Main Application
    private ItemFrame itemFrame;

    /**
     * Constructor Build BOM
     *
     * @param itemFrame, ItemFrame
     */
    public BuildBOM(ItemFrame itemFrame) {
        this.itemFrame = itemFrame;

        //Init Exec Rules
        execRules = new ExecutePartRules(this.itemFrame);
    }

    /**
     * Build Model Bill Of Material Components for Shape Object
     *
     * @param doBOM, Execute All Rules for All Job Item
     */
    public void buildModelBOM(boolean doBOM) {

        try {

            if (itemFrame.jobItem.design != null) {

                //Get all part rules
                List<Rules> rules = execRules.getAllpartRules(ItemFrame.getApplicationBaseRules().
                        getRules(itemFrame.seriesID));

                //Reset Job Item Model Bill Of Material
                this.itemFrame.jobItem.bom.clear();

                //Reset Job Item Bill Of Material
                this.itemFrame.jobItem.design.clearBOMParts();

                //Reset Job Item Glass BOM Parts
                this.itemFrame.jobItem.design.resetGlassBom();

                //Reset execution values before check rules
                this.itemFrame.executePartRules.resetExecutionValues();

                for (Rules rule : rules) {

                    if (rule.getRulesPK().getId() == 369) {
                        System.out.println("rule:" + rule.getRulesPK().getId());
                    }

                    itemFrame.jobItem.design.isMatchingBOMRule(rule, doBOM);
                }

                itemFrame.buildErrorList();
                itemFrame.initInfoList();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Build Model BOM with Shape Object
     *
     * @param shapeObject, Shape Object Model
     * @param doBOM,       Execute All Rules for All Job Item
     */
    public void buildModelBOM(ShapeObject shapeObject, boolean doBOM) {

        if (itemFrame.jobItem.design != null) {

            //Get all part rules
            List<Rules> rules = execRules.getAllpartRules(ItemFrame.getApplicationBaseRules().
                    getRulesShapeObject(this.itemFrame.seriesID, shapeObject));

            for (Rules rule : rules) {
                itemFrame.jobItem.design.isMatchingBOMRule(rule, doBOM);
            }

            itemFrame.buildErrorList();
            itemFrame.initInfoList();
        }
    }

}

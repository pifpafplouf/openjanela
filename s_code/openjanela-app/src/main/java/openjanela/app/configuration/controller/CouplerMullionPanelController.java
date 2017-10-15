package openjanela.app.configuration.controller;

import Presentation.ItemFrame;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.genericEAO.PersistenceClassNotFoundException;
import openjanela.model.eao.partner.partsEAO.PartsEAO;
import openjanela.model.eao.partner.partsEAO.PartsPersistenceEAO;
import openjanela.model.eao.partner.typeCouplerMullionEAO.TypeCouplerMullionEAO;
import openjanela.model.eao.partner.typeCouplerMullionEAO.TypeCouplerMullionPersistenceEAO;
import openjanela.model.entities.parts.Parts;
import openjanela.model.entities.partner.TypeCouplerMullion;
import org.openjanela.data.ApplicationBaseApp;
import org.openjanela.data.ApplicationBaseRulesApp;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 09-20-12
 * Time: 10:18 AM
 */
public class CouplerMullionPanelController {

    //Data Access object
    private TypeCouplerMullionEAO typeCouplerMullionEAO;
    private PartsEAO partsEAO;

    //List coupler mullions
    private List<TypeCouplerMullion> couplerMullions;
    //Parts Selected by coupler mullions option
    private Parts partsSelected;


    public List<TypeCouplerMullion> getCouplerMullions() {
        return couplerMullions;
    }

    public void setCouplerMullions(List<TypeCouplerMullion> couplerMullions) {
        this.couplerMullions = couplerMullions;
    }

    public Parts getPartsSelected() {
        return partsSelected;
    }

    public void setPartsSelected(Parts partsSelected) {
        this.partsSelected = partsSelected;
    }

    /**
     * Default constructor
     */
    public CouplerMullionPanelController() {
        this.typeCouplerMullionEAO = new TypeCouplerMullionPersistenceEAO();
        this.partsEAO = new PartsPersistenceEAO();
    }

    /**
     * Find valid coupler and mullions seriesId
     */
    public List<TypeCouplerMullion> findValidCouplerMullions(Integer seriesId)  {

        //Find coupler mullions list
        List<TypeCouplerMullion> couplerMullionList = new ArrayList<TypeCouplerMullion>();
        couplerMullionList.addAll(ItemFrame.getApplicationBaseRules().getTypeCouplerMullions());
        couplerMullionList.addAll(ItemFrame.getApplicationRemoteBaseRules().getTypeCouplerMullions());

        //Setting coupler mullions list
        setCouplerMullions(couplerMullionList);

        return couplerMullionList;
    }

    /**
     * Filter coupler mullions list
     *
     * @param type,        Type Coupler - Mullion - Divider
     * @param orientation, Vertical - Horizontal
     * @return List<TypeCouplerMullion>
     */
    public List<TypeCouplerMullion> filterCouplerMullion(Integer type, Integer orientation) {

        //List coupler mullions filter
        List<TypeCouplerMullion> couplerMullionsFilter = new ArrayList<TypeCouplerMullion>();
        if (couplerMullions != null) {
            for (TypeCouplerMullion typeCouplerMullion : this.couplerMullions) {

                //Filter by Type of coupler mullion
                if (typeCouplerMullion.getType().equals(type) && typeCouplerMullion.getOrientation().equals(orientation))
                    couplerMullionsFilter.add(typeCouplerMullion);
            }
        }

        return couplerMullionsFilter;
    }

    /**
     * Find part selected for coupler mullion selected
     *
     * @param supplierId, Supplier Identification Id
     * @param partId,     Part Identification Id
     * @param remote,     Part from Supplier
     */
    public void findPartsForCouplerMullionSelected(Integer supplierId, Integer partId, boolean remote) {

        //Find parts by primary key
        if (remote) {
            setPartsSelected(ItemFrame.getApplicationRemoteBaseRules().getPart(supplierId, partId));
        } else {
            setPartsSelected(ItemFrame.getApplicationBase().getPart(partId));
        }

    }
}

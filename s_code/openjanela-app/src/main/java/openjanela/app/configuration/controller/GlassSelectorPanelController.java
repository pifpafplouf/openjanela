package openjanela.app.configuration.controller;

import java.util.ArrayList;
import java.util.List;

import openjanela.model.eao.admin.systemUOMEAO.SystemUOMEAO;
import openjanela.model.eao.admin.systemUOMEAO.SystemUOMPersistenceEAO;
import openjanela.model.eao.admin.typeGlazingEAO.TypeGlazingEAO;
import openjanela.model.eao.admin.typeGlazingEAO.TypeGlazingPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.orderEntry.costingGroupEAO.CostingGroupEAO;
import openjanela.model.eao.orderEntry.costingGroupEAO.CostingGroupPersistenceEAO;
import openjanela.model.eao.partner.matrixHeaderEAO.MatrixHeaderEAO;
import openjanela.model.eao.partner.matrixHeaderEAO.MatrixHeaderPersistenceEAO;
import openjanela.model.eao.partner.partnerEAO.PartnerEAO;
import openjanela.model.eao.partner.partnerEAO.PartnerPersistenceEAO;
import openjanela.model.eao.partner.partsEAO.PartsEAO;
import openjanela.model.eao.partner.partsEAO.PartsPersistenceEAO;
import openjanela.model.eao.partner.pricingGroupEAO.PricingGroupEAO;
import openjanela.model.eao.partner.pricingGroupEAO.PricingGroupPersistenceEAO;
import openjanela.model.eao.partner.productionLineEAO.ProductionLineEAO;
import openjanela.model.eao.partner.productionLineEAO.ProductionLinePersistenceEAO;
import openjanela.model.eao.partner.suFamilyEAO.SUFamilyEAO;
import openjanela.model.eao.partner.suFamilyEAO.SUFamilyPersistenceEAO;
import openjanela.model.eao.partner.suTypeEAO.SUTypeEAO;
import openjanela.model.eao.partner.suTypeEAO.SUTypePersistenceEAO;
import openjanela.model.entities.admin.SystemUOM;
import openjanela.model.entities.admin.TypeGlazing;
import openjanela.model.entities.design.Metrics;
import openjanela.model.entities.orderEntry.CostingGroup;
import openjanela.model.entities.orderEntry.PricingGroup;
import openjanela.model.entities.partner.MatrixHeader;
import openjanela.model.entities.partner.Partner;
import openjanela.model.entities.partner.ProductionLine;
import openjanela.model.entities.partner.SUFamily;
import openjanela.model.entities.partner.SUType;
import openjanela.model.entities.parts.Parts;
import Model.GlassSU;
import Presentation.ItemFrame;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 09-16-12
 * Time: 10:35 AM
 */
public class GlassSelectorPanelController extends BaseController {
    // whratio
    //Static final properties Glass selector panel
    public static final int SEALANTS = 18;
    public static final int GASES = 14;
    public static final int FILMS = 16;
    public static final int SPACERS = 15;
    public static final int PROCESSES = 17;

    ItemFrame myFrame2;

    //Data Access objects

    protected SUTypeEAO suTypeEAO;
    protected SUFamilyEAO suFamilyEAO;
    protected TypeGlazingEAO typeGlazingEAO;
    protected ProductionLineEAO productionLineEAO;
    protected PartnerEAO partnerEAO;
    protected PartsEAO partsEAO;
    protected SystemUOMEAO systemUOMEAO;
    protected MatrixHeaderEAO matrixHeaderEAO;
    protected PricingGroupEAO pricingGroupEAO;
    protected CostingGroupEAO costingGroupEAO;

    private List<SUType> suTypes;
    private List<SUFamily> suFamilyList;
    private List<TypeGlazing> typeGlazings;

    private SUType suTypeSelected;
    private GlassSU glassSUSelected;

    public List<SUType> getSuTypes() {
        return suTypes;
    }

    public void setSuTypes(List<SUType> suTypes) {
        this.suTypes = suTypes;
    }

    public List<SUFamily> getSuFamilyList() {
        return suFamilyList;
    }

    public void setSuFamilyList(List<SUFamily> suFamilyList) {
        this.suFamilyList = suFamilyList;
    }

    public List<TypeGlazing> getTypeGlazings() {
        return typeGlazings;
    }

    public void setTypeGlazings(List<TypeGlazing> typeGlazings) {
        this.typeGlazings = typeGlazings;
    }

    public SUType getSuTypeSelected() {
        return suTypeSelected;
    }

    public void setSuTypeSelected(SUType suTypeSelected) {
        this.suTypeSelected = suTypeSelected;
    }

    public GlassSU getGlassSUSelected() {
        return glassSUSelected;
    }

    public void setGlassSUSelected(GlassSU glassSUSelected) {
        this.glassSUSelected = glassSUSelected;
    }

    public GlassSelectorPanelController() {

        suTypeEAO = new SUTypePersistenceEAO();
        suFamilyEAO = new SUFamilyPersistenceEAO();
        typeGlazingEAO = new TypeGlazingPersistenceEAO();
        productionLineEAO = new ProductionLinePersistenceEAO();
        partnerEAO = new PartnerPersistenceEAO();
        partsEAO = new PartsPersistenceEAO();
        systemUOMEAO = new SystemUOMPersistenceEAO();
        matrixHeaderEAO = new MatrixHeaderPersistenceEAO();
        pricingGroupEAO = new PricingGroupPersistenceEAO();
        costingGroupEAO = new CostingGroupPersistenceEAO();
    }

    /**
     * Find valid Seal Unit Types for Unit of Metric evaluation thickness
     *
     * @param uom, Unit of Metric
     */
    public void findValidSUTypes(int uom) {

        if (uom == Metrics.IMPERIAL_DECIMAL.getValue() || uom == Metrics.IMPERIAL_FRACTION.getValue()) {
            uom = Metrics.IMPERIAL_DECIMAL.getValue();
        }

        //Adding SU Types to list
        List<SUType> suTypes = new ArrayList<SUType>();
        suTypes.addAll(ItemFrame.getApplicationBaseRules().getSuTypes(uom));
        suTypes.addAll(ItemFrame.getApplicationRemoteBaseRules().getSuTypes(uom));

        setSuTypes(suTypes);
    }

    /**
     * Get valid SU Family List
     */
    public void findSUFamily() {

        //Find SUFamily values
        if (suFamilyList == null || suFamilyList.isEmpty()) {
            List<SUFamily> suFamilies = new ArrayList<SUFamily>();
            suFamilies.addAll(ItemFrame.getApplicationBaseRules().getSuFamilies());
            suFamilies.addAll(ItemFrame.getApplicationRemoteBaseRules().getSuFamilies());

            setSuFamilyList(suFamilies);
        }
    }

    /**
     * Find SUType by his identification Id
     *
     * @param supplierId, Supplier Identification Id
     * @param suTypeId,   SUType Identification Id
     * @param isRemote,   SUType from external supplier
     * @return SUType
     */
    public SUType findSUTypeById(Integer supplierId, Integer suTypeId, boolean isRemote) {

        SUType suType = null;

        if (isRemote) {
            suType = ItemFrame.getApplicationRemoteBaseRules().getSUType(supplierId, suTypeId);
        } else {
            suType = ItemFrame.getApplicationBaseRules().getSUType(suTypeId);
        }

        return suType;
    }

    /**
     * Get Valid Type Glazing
     */
    public void findTypeGlazing() {

        //Find Type Glazing
        if (this.typeGlazings == null || this.typeGlazings.isEmpty()) {
            List<TypeGlazing> typeGlazings = new ArrayList<TypeGlazing>();
            typeGlazings.addAll(ItemFrame.getApplicationBaseRules().getTypeGlazings());
            typeGlazings.addAll(ItemFrame.getApplicationRemoteBaseRules().getTypeGlazing());

            setTypeGlazings(typeGlazings);
        }
    }

    /**
     * Find type glazing order by identification Id
     *
     * @return List<TypeGlazing></TypeGlazing>
     */
    public List<TypeGlazing> findTypeGlazingOrderById() {
        List<TypeGlazing> typeGlazings = new ArrayList<TypeGlazing>();
        typeGlazings.addAll(ItemFrame.getApplicationBaseRules().getTypeGlazings());
        typeGlazings.addAll(ItemFrame.getApplicationRemoteBaseRules().getTypeGlazing());

        return typeGlazings;
    }

    /**
     * Find SU Family order by identification Id
     *
     * @return List<SUFamily></SUFamily>
     */
    public List<SUFamily> findSUFamilyOrderById() {
        List<SUFamily> suFamilies = new ArrayList<SUFamily>();
        suFamilies.addAll(ItemFrame.getApplicationBaseRules().getSuFamilies());
        suFamilies.addAll(ItemFrame.getApplicationRemoteBaseRules().getSuFamilies());

        return suFamilies;
    }

    /**
     * Find Production Line order by Identification Id
     *
     * @return List<ProductionLine></ProductionLine>
     */
    public List<ProductionLine> findProductionLineOrderById() {

        try {

            //Return Production Line order by Identification id
            return productionLineEAO.findAllOrderById();

        } catch (GenericPersistenceEAOException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    /**
     * Find all partners list
     *
     * @return List<Partner></Partner>
     */
    public List<Partner> findAllPartners() {

        try {

            //Return partner list
            return partnerEAO.findSuppliers();

        } catch (GenericPersistenceEAOException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    /**
     * Find parts by part type
     *
     * @param partType, int
     * @return List<Parts>
     */
    public List<Parts> findPartsByType(int partType) {

        try {

            //Return parts by type
            return partsEAO.findByPartType(partType);

        } catch (GenericPersistenceEAOException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    /**
     * Find SUType by glazing type
     *
     * @param glazingType, int
     * @return List<SUType>
     */
    public List<SUType> findSUTypesByGlazingType(int glazingType) {

        try {

            //Return SUType by glazing type
            return suTypeEAO.findByGlazingType(glazingType);

        } catch (GenericPersistenceEAOException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    /**
     * Find all System UOM
     *
     * @return List<SystemUOM>
     */
    public List<SystemUOM> findAllSystemUOM() {
        //Return all System UOM
        return ItemFrame.getApplicationBase().getSystemUOMs();
    }

    /**
     * Find all submatrix header by series Id
     *
     * @param seriesId, Series Identification Id
     * @return List<MatrixHeader>
     */
    public List<MatrixHeader> findSubMatrixHeadersBySeries(int seriesId) {

        try {

            //Return all matrix header by series
            return matrixHeaderEAO.findSubMatrixByTypeSeries(seriesId);

        } catch (GenericPersistenceEAOException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    /**
     * Find all pricing group list
     *
     * @return List<PricingGroup>
     */
    public List<PricingGroup> findAllPricingGroup() {
        //Return all pricing group list
        return ItemFrame.getApplicationBase().getPricingGroups();
    }

    /**
     * Find all costing group list
     *
     * @return List<CostingGroup>
     */
    public List<CostingGroup> findAllCostingGroup() {
        //Return all costing group list
        return ItemFrame.getApplicationBase().getCostingGroups();
    }

    /**
     * Find valid SUType for GlassSU selected
     *
     * @param id, Identification ID SUType
     */
    public void findValidSUType(Integer id) {
        //Setting SUType selected
        setSuTypeSelected(ItemFrame.getApplicationBaseRules().getSUType(id));

    }

    /**
     * Adding new SUType to the List
     *
     * @param suType, SUType
     */
    public void addingNewSUType(SUType suType) {
        //Adding su type to the list
        getSuTypes().add(suType);
    }

    /**
     * Filter list of SUTypes
     *
     * @param glazingTypeId, GlazingType Identification
     * @param isCustom,      Custom value
     * @param numOfLeaves,   Number of leaves
     * @param thickness,     Thickness
     * @param familyId,      Family Identification
     * @param description,   Description
     * @param stockCode,     Stock code
     * @return List<SUType>
     */
    public List<SUType> filterSUTypes(Integer glazingTypeId, boolean isCustom, Integer numOfLeaves, Integer thickness,
                                      Integer familyId, String description, String stockCode) {

        List<SUType> filterSUTypes = new ArrayList<SUType>();

        for (SUType suType : getSuTypes()) {

            //Filter by glazingTypeId
            if (glazingTypeId != null && suType.getGlazingType() != null)
                if (suType.getGlazingType().equals(glazingTypeId))
                    filterSUTypes.add(suType);

            //Filter by Custom value
            if (isCustom) {
                filterSUTypes.add(suType);
            }

            //Filter by number of leaves
            if (numOfLeaves != null && suType.getNumOfLeaves() != null)
                if (suType.getNumOfLeaves().equals(numOfLeaves))
                    filterSUTypes.add(suType);

            //Filter by thickness metric
            if (thickness != null && suType.getThickness() != null)
                if (suType.getThickness().equals(thickness))
                    filterSUTypes.add(suType);

            //Filter by thickness imperial
            if (thickness != null && suType.getThicknessImp() != null)
                if (suType.getThicknessImp().equals(thickness))
                    filterSUTypes.add(suType);

            //Filter by family Id
            if (familyId != null && suType.getFamilyId() != null)
                if (suType.getFamilyId().equals(familyId))
                    filterSUTypes.add(suType);

            //Description
            if (description != null && suType.getDescription() != null) {
                int index = suType.getDescription().toLowerCase().indexOf(description.toLowerCase());
                if (index != -1)
                    filterSUTypes.add(suType);
            }

            //Stock code
            if (stockCode != null && suType.getStockCode() != null) {
                int index = suType.getStockCode().toLowerCase().indexOf(stockCode.toLowerCase());
                if (index != -1)
                    filterSUTypes.add(suType);
            }
        }

        return filterSUTypes;
    }

}

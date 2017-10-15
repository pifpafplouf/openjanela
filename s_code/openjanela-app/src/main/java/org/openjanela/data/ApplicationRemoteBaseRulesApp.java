package org.openjanela.data;

import Model.ProfileParts.Profiles;
import Model.ShapeObject;

import openjanela.model.eao.admin.partnersEAO.PartnersEAO;
import openjanela.model.eao.admin.partnersEAO.PartnersPersistenceEAO;
import openjanela.model.eao.admin.typeGlazingEAO.TypeGlazingEAO;
import openjanela.model.eao.admin.typeGlazingEAO.TypeGlazingPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.partner.adjustmentRO_EAO.AdjustmentRO_EAO;
import openjanela.model.eao.partner.adjustmentRO_EAO.AdjustmentRO_PersistenceEAO;
import openjanela.model.eao.partner.attributeTypeEAO.AttributeTypeEAO;
import openjanela.model.eao.partner.attributeTypeEAO.AttributeTypePersistenceEAO;
import openjanela.model.eao.partner.colorEAO.ColorEAO;
import openjanela.model.eao.partner.colorEAO.ColorPersistenceEAO;
import openjanela.model.eao.partner.companyEAO.CompanyEAO;
import openjanela.model.eao.partner.companyEAO.CompanyPersistenceEAO;
import openjanela.model.eao.partner.gridsEAO.GridsEAO;
import openjanela.model.eao.partner.gridsEAO.GridsPersistenceEAO;
import openjanela.model.eao.partner.matrixEAO.MatrixEAO;
import openjanela.model.eao.partner.matrixEAO.MatrixPersistenceEAO;
import openjanela.model.eao.partner.matrixHeaderEAO.MatrixHeaderEAO;
import openjanela.model.eao.partner.matrixHeaderEAO.MatrixHeaderPersistenceEAO;
import openjanela.model.eao.partner.matrixSeriesEAO.MatrixSeriesEAO;
import openjanela.model.eao.partner.matrixSeriesEAO.MatrixSeriesPersistenceEAO;
import openjanela.model.eao.partner.optionsEAO.OptionAnswersEAO;
import openjanela.model.eao.partner.optionsEAO.OptionAnswersPersistenceEAO;
import openjanela.model.eao.partner.optionsEAO.OptionsEAO;
import openjanela.model.eao.partner.optionsEAO.OptionsPersistenceEAO;
import openjanela.model.eao.partner.partFamilySeriesEAO.PartFamilySeriesEAO;
import openjanela.model.eao.partner.partFamilySeriesEAO.PartFamilySeriesPersistenceEAO;
import openjanela.model.eao.partner.partnerEAO.PartnerEAO;
import openjanela.model.eao.partner.partnerEAO.PartnerPersistenceEAO;
import openjanela.model.eao.partner.partnerGroupLineDiscountEAO.PartnerGroupLineDiscountEAO;
import openjanela.model.eao.partner.partnerGroupLineDiscountEAO.PartnerGroupLineDiscountPersistenceEAO;
import openjanela.model.eao.partner.partnerLineDiscountEAO.PartnerLineDiscountEAO;
import openjanela.model.eao.partner.partnerLineDiscountEAO.PartnerLineDiscountPersistenceEAO;
import openjanela.model.eao.partner.partsCostPriceEAO.PartsCostPriceEAO;
import openjanela.model.eao.partner.partsCostPriceEAO.PartsCostPricePersistenceEAO;
import openjanela.model.eao.partner.partsEAO.PartsEAO;
import openjanela.model.eao.partner.partsEAO.PartsPersistenceEAO;
import openjanela.model.eao.partner.partsFamilyEAO.PartsFamilyEAO;
import openjanela.model.eao.partner.partsFamilyEAO.PartsFamilyPersistenceEAO;
import openjanela.model.eao.partner.partsFamilyStationEAO.PartsFamilyStationEAO;
import openjanela.model.eao.partner.partsFamilyStationEAO.PartsFamilyStationPersistenceEAO;
import openjanela.model.eao.partner.partsLabelPosEAO.PartsLabelPosEAO;
import openjanela.model.eao.partner.partsLabelPosEAO.PartsLabelPosPersistenceEAO;
import openjanela.model.eao.partner.pricingGroupEAO.PricingGroupEAO;
import openjanela.model.eao.partner.pricingGroupEAO.PricingGroupPersistenceEAO;
import openjanela.model.eao.partner.productionLineEAO.ProductionLineEAO;
import openjanela.model.eao.partner.productionLineEAO.ProductionLinePersistenceEAO;
import openjanela.model.eao.partner.ruleAnswerEAO.RuleAnswersEAO;
import openjanela.model.eao.partner.ruleAnswerEAO.RuleAnswersPersistenceEAO;
import openjanela.model.eao.partner.ruleTestEAO.RuleTestEAO;
import openjanela.model.eao.partner.ruleTestEAO.RuleTestPersistenceEAO;
import openjanela.model.eao.partner.ruleTestValueEAO.RuleTestValueEAO;
import openjanela.model.eao.partner.ruleTestValueEAO.RuleTestValuePersistenceEAO;
import openjanela.model.eao.partner.rulesEAO.RulesEAO;
import openjanela.model.eao.partner.rulesEAO.RulesPersistenceEAO;
import openjanela.model.eao.partner.seriesAllowedSUThickEAO.SeriesAllowedSUThickEAO;
import openjanela.model.eao.partner.seriesAllowedSUThickEAO.SeriesAllowedSUThickPersistenceEAO;
import openjanela.model.eao.partner.seriesEAO.SeriesCategoryEAO;
import openjanela.model.eao.partner.seriesEAO.SeriesCategoryPersistenceEAO;
import openjanela.model.eao.partner.seriesEAO.SeriesEAO;
import openjanela.model.eao.partner.seriesEAO.SeriesPersistenceEAO;
import openjanela.model.eao.partner.seriesValidOpeningShapeEAO.SeriesValidOpeningShapeEAO;
import openjanela.model.eao.partner.seriesValidOpeningShapeEAO.SeriesValidOpeningShapePersistenceEAO;
import openjanela.model.eao.partner.seriesValidShapesEAO.SeriesValidShapesEAO;
import openjanela.model.eao.partner.seriesValidShapesEAO.SeriesValidShapesPersistenceEAO;
import openjanela.model.eao.partner.suFamilyEAO.SUFamilyEAO;
import openjanela.model.eao.partner.suFamilyEAO.SUFamilyPersistenceEAO;
import openjanela.model.eao.partner.suTypeEAO.SUTypeEAO;
import openjanela.model.eao.partner.suTypeEAO.SUTypePersistenceEAO;
import openjanela.model.eao.partner.typeCouplerMullionEAO.TypeCouplerMullionEAO;
import openjanela.model.eao.partner.typeCouplerMullionEAO.TypeCouplerMullionPersistenceEAO;
import openjanela.model.eao.production.productionStationsEAO.ProductionStationsEAO;
import openjanela.model.eao.production.productionStationsEAO.ProductionStationsPersistenceEAO;
import openjanela.model.entities.admin.Partners;
import openjanela.model.entities.admin.TypeGlazing;
import openjanela.model.entities.design.Metrics;
import openjanela.model.entities.orderEntry.PricingGroup;
import openjanela.model.entities.partner.*;
import openjanela.model.entities.parts.*;
import openjanela.model.entities.production.ProductionStations;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 1/11/14
 *          Time: 7:44 PM
 */
public class ApplicationRemoteBaseRulesApp {

    //Apache Log4j
    private static final Logger logger = Logger.getLogger(ApplicationRemoteBaseRulesApp.class);

    //Application base rules
    private static ApplicationRemoteBaseRulesApp instance;

    //Series Identification from Application Local
    private int _series_local = -1;

    //Series Identification actual
    private int _series = -1;
    private int _supplier = -1;

    //Dealer Information
    private Map<Integer, Partner> supplierMap = new HashMap<Integer, Partner>();

    //Supplier List rules
    private Map<Integer, List<Rules>> supplierRules = new HashMap<Integer, List<Rules>>();

    //Supplier List Rule Test
    private Map<Integer, List<RuleTest>> supplierRuleTest = new HashMap<Integer, List<RuleTest>>();

    //Supplier List Rule Test Value
    private Map<Integer, List<RuleTestValue>> supplierRuleTestValues = new HashMap<Integer, List<RuleTestValue>>();

    //Supplier List Rules Answers
    private Map<Integer, List<RuleAnswers>> supplierRuleAnswers = new HashMap<Integer, List<RuleAnswers>>();

    //Supplier List Series SubRoutines
    private Map<Integer, List<Series>> supplierSeriesSubRoutines = new HashMap<Integer, List<Series>>();

    //Supplier List Series Valid Shapes
    private Map<Integer, List<SeriesValidShapes>> supplierSeriesValidShapes = new HashMap<Integer, List<SeriesValidShapes>>();

    //Supplier Series Valid Opening Shapes
    private Map<Integer, List<SeriesValidOpeningShape>> supplierSeriesValidOpeningShapes = new HashMap<Integer, List<SeriesValidOpeningShape>>();

    //Supplier Type Coupler Mullions
    private Map<Integer, List<TypeCouplerMullion>> supplierTypeCouplerMullions = new HashMap<Integer, List<TypeCouplerMullion>>();

    //Supplier Matrix Headers
    private Map<Integer, List<MatrixHeader>> supplierMatrixHeaders = new HashMap<Integer, List<MatrixHeader>>();

    //Supplier Matrices
    private Map<Integer, List<Matrix>> supplierMatrices = new HashMap<Integer, List<Matrix>>();

    //Supplier Matrix Series
    private Map<Integer, List<Integer>> supplierMatrixSeries = new HashMap<Integer, List<Integer>>();

    //Supplier Parts
    private Map<Integer, List<Parts>> supplierParts = new HashMap<Integer, List<Parts>>();

    //Supplier Parts Families
    private Map<Integer, List<PartsFamily>> supplierPartsFamilies = new HashMap<Integer, List<PartsFamily>>();

    //Supplier Parts Families Series
    private Map<Integer, List<PartFamilySeries>> supplierPartFamilySeries = new HashMap<Integer, List<PartFamilySeries>>();

    //Supplier Parts Family Station
    private Map<Integer, List<PartFamilyStation>> supplierPartFamilyStation = new HashMap<Integer, List<PartFamilyStation>>();

    //Supplier Parts Cost Price
    private Map<Integer, List<PartsCostPrice>> supplierPartsCostPrice = new HashMap<Integer, List<PartsCostPrice>>();

    //Supplier Pricing Groups
    private Map<Integer, List<PricingGroup>> supplierPricingGroups = new HashMap<Integer, List<PricingGroup>>();

    //Supplier Parts Label Position
    private Map<Integer, List<PartsLabelPos>> supplierPartLabelPos = new HashMap<Integer, List<PartsLabelPos>>();

    //Supplier Production Lines
    private Map<Integer, List<ProductionLine>> supplierProductionLines = new HashMap<Integer, List<ProductionLine>>();

    //Supplier Production Lines
    private Map<Integer, List<ProductionStations>> supplierProductionStations = new HashMap<Integer, List<ProductionStations>>();

    //Supplier Series Allowed SU Thicks
    private Map<Integer, List<SeriesAllowedSUThick>> supplierSeriesAllowedSUThicks = new HashMap<Integer, List<SeriesAllowedSUThick>>();

    //Supplier Type Glazing
    private Map<Integer, List<TypeGlazing>> supplierTypeGlazing = new HashMap<Integer, List<TypeGlazing>>();

    //Supplier Type Attributes
    private Map<Integer, List<TypeAttribute>> supplierTypeAttribute = new HashMap<Integer, List<TypeAttribute>>();

    //Supplier SU Types
    private Map<Integer, List<SUType>> supplierSUTypes = new HashMap<Integer, List<SUType>>();

    //Supplier Colors
    private Map<Integer, List<Color>> supplierColors = new HashMap<Integer, List<Color>>();

    //Supplier SU Families
    private Map<Integer, List<SUFamily>> supplierSUFamilies = new HashMap<Integer, List<SUFamily>>();

    //Supplier Grids
    private Map<Integer, List<Grids>> supplierGrids = new HashMap<Integer, List<Grids>>();

    //Supplier Options Definitions
    private Map<Integer, List<OptionDefinitions>> supplierOptionDefinitions = new HashMap<Integer, List<OptionDefinitions>>();

    //Supplier Partner Line Discounts
    private Map<Integer, List<PartnerLineDiscount>> supplierPartnerLineDiscounts = new HashMap<Integer, List<PartnerLineDiscount>>();

    //Supplier Partner Group Line Discounts
    private Map<Integer, List<PartnerGroupLineDiscount>> supplierPartnerGroupLineDiscounts = new HashMap<Integer, List<PartnerGroupLineDiscount>>();

    //Supplier Type Coupler Mullions Map
    private Map<Integer, Map<Integer, TypeCouplerMullion>> supplierTypeCouplerMullionMap = new HashMap<Integer, Map<Integer, TypeCouplerMullion>>();

    //Supplier Matrix Header Map
    private Map<Integer, Map<Integer, MatrixHeader>> supplierMatrixHeaderMap = new HashMap<Integer, Map<Integer, MatrixHeader>>();

    //Supplier Matrix Map
    private Map<Integer, Map<Integer, List<Matrix>>> supplierMatrixMap = new HashMap<Integer, Map<Integer, List<Matrix>>>();

    //Supplier Series Sub Routines Map
    private Map<Integer, Map<Integer, Series>> supplierSeriesSubRoutinesMap = new HashMap<Integer, Map<Integer, Series>>();

    //Supplier Rules Map
    private Map<Integer, Map<Integer, List<Rules>>> supplierRulesMap = new HashMap<Integer, Map<Integer, List<Rules>>>();

    //Supplier Option Rules Map
    private Map<Integer, Map<Integer, List<Rules>>> supplierOptionsRulesMap = new HashMap<Integer, Map<Integer, List<Rules>>>();

    //Supplier Rules Test Map
    private Map<Integer, Map<Integer, Map<RuleTestPK, RuleTest>>> supplierRulesTestMap = new HashMap<Integer, Map<Integer, Map<RuleTestPK, RuleTest>>>();

    //Supplier Rules Test Values Map
    private Map<Integer, Map<Integer, Map<Integer, Map<Integer, List<RuleTestValue>>>>> supplierRuleTestValuesMap = new HashMap<Integer, Map<Integer, Map<Integer, Map<Integer, List<RuleTestValue>>>>>();

    //Supplier Rules Answers Map
    private Map<Integer, Map<Integer, RuleAnswers>> supplierRuleAnswersMap = new HashMap<Integer, Map<Integer, RuleAnswers>>();

    //Supplier Series Valid Openings Map
    private Map<Integer, Map<Integer, SeriesValidOpeningShape>> supplierSeriesValidOpeningMap = new HashMap<Integer, Map<Integer, SeriesValidOpeningShape>>();

    //Supplier Series Valid Shapes Map
    private Map<Integer, Map<Integer, SeriesValidShapes>> supplierSeriesValidShapesMap = new HashMap<Integer, Map<Integer, SeriesValidShapes>>();

    //Supplier Option Answers Allowed Map
    private Map<Integer, Map<Integer, List<OptionAnswers>>> supplierOptionAnswersAllowedMap = new HashMap<Integer, Map<Integer, List<OptionAnswers>>>();

    //Supplier Option Definitions Map
    private Map<Integer, Map<Integer, OptionDefinitions>> supplierOptionDefinitionsMap = new HashMap<Integer, Map<Integer, OptionDefinitions>>();

    //Supplier Production Lines Map
    private Map<Integer, Map<Integer, ProductionLine>> supplierProductionLinesMap = new HashMap<Integer, Map<Integer, ProductionLine>>();

    //Supplier Production Station Map
    private Map<Integer, Map<Integer, ProductionStations>> supplierProductionStationsMap = new HashMap<Integer, Map<Integer, ProductionStations>>();

    //Supplier Parts Map
    private Map<Integer, Map<Integer, Parts>> supplierPartsMap = new HashMap<Integer, Map<Integer, Parts>>();

    //Supplier Parts Family Map
    private Map<Integer, Map<Integer, PartsFamily>> supplierPartsFamiliesMap = new HashMap<Integer, Map<Integer, PartsFamily>>();

    //Supplier Part Family Series Map
    private Map<Integer, Map<PartFamilySeriesPK, PartFamilySeries>> supplierPartFamilySeriesMap = new HashMap<Integer, Map<PartFamilySeriesPK, PartFamilySeries>>();

    //Supplier Part Family Station Map
    private Map<Integer, Map<Integer, PartFamilyStation>> supplierPartFamilyStationMap = new HashMap<Integer, Map<Integer, PartFamilyStation>>();

    //Supplier Parts Cost Price Map
    private Map<Integer, Map<Integer, PartsCostPrice>> supplierPartsCostPriceMap = new HashMap<Integer, Map<Integer, PartsCostPrice>>();

    //Supplier Parts Label Position Map
    private Map<Integer, Map<Integer, PartsLabelPos>> supplierPartsLabelPosMap = new HashMap<Integer, Map<Integer, PartsLabelPos>>();

    //Supplier Pricing Group Map
    private Map<Integer, Map<Integer, PricingGroup>> supplierPricingGroupMap = new HashMap<Integer, Map<Integer, PricingGroup>>();

    //Supplier Series Allowed SU Thick Map
    private Map<Integer, Map<SeriesAllowedSUThickPK, SeriesAllowedSUThick>> supplierSeriesAllowedSUThickMap = new HashMap<Integer, Map<SeriesAllowedSUThickPK, SeriesAllowedSUThick>>();

    //Supplier Type Glazing Map
    private Map<Integer, Map<Integer, TypeGlazing>> supplierTypeGlazingMap = new HashMap<Integer, Map<Integer, TypeGlazing>>();

    //Supplier SU Types Map
    private Map<Integer, Map<Integer, SUType>> supplierSuTypesMap = new HashMap<Integer, Map<Integer, SUType>>();

    //Supplier Color Map
    private Map<Integer, Map<Integer, Color>> supplierColorMap = new HashMap<Integer, Map<Integer, Color>>();

    //Supplier Type Atribute Map
    private Map<Integer, Map<Integer, TypeAttribute>> supplierTypeAttributeMap = new HashMap<Integer, Map<Integer, TypeAttribute>>();

    //Supplier SU Family Map
    private Map<Integer, Map<Integer, SUFamily>> supplierSUFamilyMap = new HashMap<Integer, Map<Integer, SUFamily>>();

    //Supplier Grids Map
    private Map<Integer, Map<Integer, Grids>> supplierGridsMap = new HashMap<Integer, Map<Integer, Grids>>();

    //Entity Access Objects
    protected AdjustmentRO_EAO adjustmentROEAO;
    protected CompanyEAO companyEAO;
    protected MatrixHeaderEAO matrixHeaderEAO;
    protected MatrixEAO matrixEAO;
    protected MatrixSeriesEAO matrixSeriesEAO;
    protected PartnerEAO partnerEAO;
    protected PartnersEAO partnersEAO;
    protected TypeCouplerMullionEAO typeCouplerMullionEAO;
    protected RulesEAO rulesEAO;
    protected RuleTestEAO ruleTestEAO;
    protected RuleTestValueEAO ruleTestValueEAO;
    protected RuleAnswersEAO ruleAnswersEAO;
    protected SeriesCategoryEAO seriesCategoryEAO;
    protected SeriesValidOpeningShapeEAO seriesValidOpeningEAO;
    protected SeriesValidShapesEAO seriesValidShapesEAO;
    protected SeriesEAO seriesEAO;

    protected OptionsEAO optionsEAO;
    protected OptionAnswersEAO optionAnswersEAO;
    protected PartsEAO partsEAO;
    protected PartsFamilyEAO partsFamilyEAO;
    protected PartFamilySeriesEAO partFamilySeriesEAO;
    protected PartsFamilyStationEAO partFamilyStationEAO;
    protected PartsCostPriceEAO partsCostPriceEAO;
    protected PartsLabelPosEAO partsLabelPosEAO;
    protected PricingGroupEAO pricingGroupEAO;
    protected ProductionLineEAO productionLineEAO;
    protected ProductionStationsEAO productionStationsEAO;
    protected PartnerLineDiscountEAO partnerLineDiscountEAO;
    protected PartnerGroupLineDiscountEAO partnerGroupLineDiscountEAO;

    protected SeriesAllowedSUThickEAO seriesAllowedSUThickEAO;
    protected TypeGlazingEAO typeGlazingEAO;
    protected AttributeTypeEAO attributeTypeEAO;
    protected SUTypeEAO suTypeEAO;
    protected SUFamilyEAO suFamilyEAO;
    protected GridsEAO gridsEAO;
    protected ColorEAO colorEAO;

    ExecutorService executorService = Executors.newFixedThreadPool(15);

    /**
     * Application Base Rules Constructor
     */
    public ApplicationRemoteBaseRulesApp() {

        //Init Entity Access Objects
        adjustmentROEAO = new AdjustmentRO_PersistenceEAO();
        companyEAO = new CompanyPersistenceEAO();
        matrixHeaderEAO = new MatrixHeaderPersistenceEAO();
        matrixEAO = new MatrixPersistenceEAO();
        matrixSeriesEAO = new MatrixSeriesPersistenceEAO();
        partnerEAO = new PartnerPersistenceEAO();
        partnersEAO = new PartnersPersistenceEAO();
        rulesEAO = new RulesPersistenceEAO();
        ruleTestEAO = new RuleTestPersistenceEAO();
        ruleTestValueEAO = new RuleTestValuePersistenceEAO();
        ruleAnswersEAO = new RuleAnswersPersistenceEAO();
        seriesCategoryEAO = new SeriesCategoryPersistenceEAO();
        seriesEAO = new SeriesPersistenceEAO();
        seriesValidOpeningEAO = new SeriesValidOpeningShapePersistenceEAO();
        seriesValidShapesEAO = new SeriesValidShapesPersistenceEAO();
        typeCouplerMullionEAO = new TypeCouplerMullionPersistenceEAO();

        optionsEAO = new OptionsPersistenceEAO();
        optionAnswersEAO = new OptionAnswersPersistenceEAO();
        partsEAO = new PartsPersistenceEAO();
        partsFamilyEAO = new PartsFamilyPersistenceEAO();
        partFamilySeriesEAO = new PartFamilySeriesPersistenceEAO();
        partFamilyStationEAO = new PartsFamilyStationPersistenceEAO();
        partsCostPriceEAO = new PartsCostPricePersistenceEAO();
        pricingGroupEAO = new PricingGroupPersistenceEAO();
        partsLabelPosEAO = new PartsLabelPosPersistenceEAO();
        productionLineEAO = new ProductionLinePersistenceEAO();
        productionStationsEAO = new ProductionStationsPersistenceEAO();
        partnerLineDiscountEAO = new PartnerLineDiscountPersistenceEAO();
        partnerGroupLineDiscountEAO = new PartnerGroupLineDiscountPersistenceEAO();

        seriesAllowedSUThickEAO = new SeriesAllowedSUThickPersistenceEAO();
        suTypeEAO = new SUTypePersistenceEAO();
        suFamilyEAO = new SUFamilyPersistenceEAO();
        typeGlazingEAO = new TypeGlazingPersistenceEAO();
        attributeTypeEAO = new AttributeTypePersistenceEAO();
        gridsEAO = new GridsPersistenceEAO();
        colorEAO = new ColorPersistenceEAO();
    }

    /**
     * Init Remote Series Segments
     *
     * @param seriesID, Series Identification Id
     */
    public void initRemoteSeriesSegments(int seriesID) {

        try {

            if (_series_local != seriesID) {

                //Update Series From Local Execution
                this._series_local = seriesID;

                //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                //1. Series Object Identification
                //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                Series series = seriesEAO.findById(seriesID);

                //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                //2. Init Supplier Information
                //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                Partners supplier = new Partners();
                if (series != null && !series.getMadeIn()) {
                    supplier = partnersEAO.findById(series.getSupplierId());

                    //Supplier Identification Id
                    _supplier = supplier.getId();

                    //Series Identification Id
                    _series = series.getSupplierSeriesId();
                }

                //Init Supplier Identification Object
                final int param_supplier = supplier.getId();

                //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                //3. Find All Series Segments by Series Identification
                //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                List<Integer> seriesSegments = rulesEAO.findAllRemoteSeriesSegments(series.getSupplierSeriesId(), supplier.getId());

                //Create In String Value
                String inString = "";
                for (Integer ms : seriesSegments) {
                    if (inString.length() == 0) {
                        inString = ms.toString();
                    } else {
                        inString = inString + "," + ms.toString();
                    }
                }

                //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                //4. Find All Series Sub-Routines
                //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                List<Series> seriesSubRoutines = seriesEAO.findAllRemoteSeriesSubRoutines(inString, supplier.getId());

                Map<Integer, Series> seriesSubRoutinesMap = new HashMap<Integer, Series>();
                for (Series subRoutine : seriesSubRoutines) {

                    //Update MadeIn to supplier information
                    subRoutine.setMadeIn(false);
                    subRoutine.setSupplierId(supplier.getId());

                    //Adding subroutine to map collection
                    seriesSubRoutinesMap.put(subRoutine.getId(), subRoutine);
                }

                //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                //5. Find Series Supplier
                //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                if (seriesSubRoutinesMap.get(series.getSupplierSeriesId()) == null && series.getSupplierSeriesId() > 0) {

                    //Search remote series selected
                    Series remoteSeries = seriesEAO.findRemoteById(series.getSupplierSeriesId(), supplier.getId());

                    //Update MadeIn to supplier information
                    remoteSeries.setMadeIn(false);
                    remoteSeries.setSupplierId(supplier.getId());

                    //Adding to series subroutines
                    seriesSubRoutines.add(remoteSeries);

                    //Adding to subroutines map collection
                    seriesSubRoutinesMap.put(remoteSeries.getId(), remoteSeries);
                }

                //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                //6. Update Supplier Series Sub-Routines
                //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                supplierSeriesSubRoutines.put(supplier.getId(), seriesSubRoutines);
                supplierSeriesSubRoutinesMap.put(supplier.getId(), seriesSubRoutinesMap);

                //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                //7. Init Remote Values For Supplier
                //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

                //Init Remote Rules
                initRemoteRules(param_supplier);
                initRemoteRulesTestValues(param_supplier);
                initRemoteValidShapes(param_supplier);
                initRemoteValidOpenings(param_supplier);
                initRemoteOptionDefinitions(param_supplier);
                initRemoteSeriesAllowedSUThick(param_supplier);
                initRemoteSUTypes(param_supplier);

                //Init Remote Matrix Values
                initRemoteMatrixValues(param_supplier);

                executorService.execute(new Runnable() {
                    public void run() {
                        initDealerInformation(param_supplier);
                    }
                });

                executorService.execute(new Runnable() {
                    public void run() {
                        initRemoteTypeCouplerMullion(param_supplier);
                    }
                });

                executorService.execute(new Runnable() {
                    public void run() {
                        initRemoteParts(param_supplier);
                    }
                });

                executorService.execute(new Runnable() {
                    public void run() {
                        initRemoteProductionLines(param_supplier);
                    }
                });

                executorService.execute(new Runnable() {
                    public void run() {
                        initRemotePartnerLineDiscounts(param_supplier);
                    }
                });

            }

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("Service application not start: " + e.getMessage(), e);
        }
    }

    /**
     * Init Dealer Information Values
     */
    public void initDealerInformation(int supplierID) {

        try {

            //Find Company Information
            Company company = companyEAO.findById(1);

            //Find dealer from Supplier Information
            Partner dealer = partnerEAO.findRemoteDealerById(Integer.parseInt(company.getPartnerId()), supplierID);

            //Put dealer into collection
            supplierMap.clear();
            supplierMap.put(supplierID, dealer);

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("Service application not start: " + e.getMessage(), e);
        }
    }

    /**
     * Init Remote Rules
     *
     * @param supplierID, Supplier Identification Id
     */
    public void initRemoteRules(int supplierID) {

        try {

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //Reset Components Values
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            this.supplierRules.clear();
            this.supplierRulesMap.clear();
            this.supplierOptionsRulesMap.clear();
            this.supplierRuleTest.clear();
            this.supplierRulesTestMap.clear();
            this.supplierRuleAnswers.clear();
            this.supplierRuleAnswersMap.clear();

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //1. Return Sub Routines for Supplier ID
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            List<Series> subroutines = this.supplierSeriesSubRoutines.get(supplierID);

            for (Series subroutine : subroutines) {

                //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                //2. Search Rules Values for Series & Supplier
                //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                List<Rules> rules = rulesEAO.findAllRemoteRulesBySeries(subroutine.getId(), supplierID);
                List<RuleTest> ruleTests = ruleTestEAO.findAllRemoteBySeries(subroutine.getId(), supplierID);
                List<RuleAnswers> ruleAnswers = ruleAnswersEAO.findAllRemoteAnswers(subroutine.getId(), supplierID);
                List<Rules> optionRules = rulesEAO.findAllRemoteOptionRulesBySeries(subroutine.getId(), supplierID);

                //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                //3. Init Load Rules Values
                //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                List<Rules> rulesList = new ArrayList<Rules>();
                rulesList.addAll(rules);

                Map<Integer, List<Rules>> rulesMap = new HashMap<Integer, List<Rules>>();
                rulesMap.put(subroutine.getId(), rulesList);

                if (this.supplierRules.get(supplierID) == null) {
                    this.supplierRules.put(supplierID, rules);
                    this.supplierRulesMap.put(supplierID, rulesMap);
                } else {

                    List<Rules> supplierRules = this.supplierRules.get(supplierID);
                    supplierRules.addAll(rules);

                    this.supplierRules.put(supplierID, supplierRules);

                    Map<Integer, List<Rules>> supplierRulesMap = this.supplierRulesMap.get(supplierID);
                    supplierRulesMap.putAll(rulesMap);

                    this.supplierRulesMap.put(supplierID, supplierRulesMap);
                }

                //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                //4. Init Option rules Values
                //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                List<Rules> optionRulesList = new ArrayList<Rules>();
                optionRulesList.addAll(optionRules);

                Map<Integer, List<Rules>> optionsRulesMap = new HashMap<Integer, List<Rules>>();
                optionsRulesMap.put(subroutine.getId(), optionRulesList);

                if (this.supplierOptionsRulesMap.get(supplierID) == null) {
                    this.supplierOptionsRulesMap.put(supplierID, optionsRulesMap);
                } else {
                    Map<Integer, List<Rules>> supplierOptionsRulesMap = this.supplierOptionsRulesMap.get(supplierID);
                    supplierOptionsRulesMap.putAll(optionsRulesMap);

                    this.supplierOptionsRulesMap.put(supplierID, supplierOptionsRulesMap);
                }

                //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                //5. Init Load Rules Test Values
                //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                Map<Integer, Map<RuleTestPK, RuleTest>> seriesRulesTestMap = new HashMap<Integer, Map<RuleTestPK, RuleTest>>();

                Map<RuleTestPK, RuleTest> ruleTestMap = new HashMap<RuleTestPK, RuleTest>();
                for (RuleTest ruleTest : ruleTests) {

                    ruleTest.setSupplierId(supplierID);
                    ruleTest.setRemote(true);

                    ruleTestMap.put(ruleTest.getRuleTestPK(), ruleTest);
                }

                seriesRulesTestMap.put(subroutine.getId(), ruleTestMap);

                if (this.supplierRuleTest.get(supplierID) == null) {
                    this.supplierRuleTest.put(supplierID, ruleTests);
                    this.supplierRulesTestMap.put(supplierID, seriesRulesTestMap);
                } else {
                    List<RuleTest> supplierRuleTest = this.supplierRuleTest.get(supplierID);
                    supplierRuleTest.addAll(ruleTests);

                    this.supplierRuleTest.put(supplierID, supplierRuleTest);

                    Map<Integer, Map<RuleTestPK, RuleTest>> supplierRuleTestMap = this.supplierRulesTestMap.get(supplierID);
                    supplierRuleTestMap.putAll(seriesRulesTestMap);

                    this.supplierRulesTestMap.put(supplierID, supplierRuleTestMap);
                }

                //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                //6. Init Load Rules Answers
                //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                Map<Integer, RuleAnswers> ruleAnswersMap = new HashMap<Integer, RuleAnswers>();

                for (RuleAnswers ruleAnswer : ruleAnswers) {
                    ruleAnswersMap.put(ruleAnswer.getRuleAnswersPK().getAnswerid(), ruleAnswer);
                }

                if (this.supplierRuleAnswers.get(supplierID) == null) {

                    this.supplierRuleAnswers.put(supplierID, ruleAnswers);
                    this.supplierRuleAnswersMap.put(supplierID, ruleAnswersMap);

                } else {
                    List<RuleAnswers> supplierRuleAnswers = this.supplierRuleAnswers.get(supplierID);
                    supplierRuleAnswers.addAll(ruleAnswers);

                    this.supplierRuleAnswers.put(supplierID, supplierRuleAnswers);

                    Map<Integer, RuleAnswers> supplierRuleAnswersMap = this.supplierRuleAnswersMap.get(supplierID);
                    supplierRuleAnswersMap.putAll(ruleAnswersMap);

                    this.supplierRuleAnswersMap.put(supplierID, supplierRuleAnswersMap);
                }
            }

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("Service application not start: " + e.getMessage(), e);
        }
    }

    /**
     * Init Remote Rules Test Values
     *
     * @param supplierID, Supplier Identification Id
     */
    public void initRemoteRulesTestValues(int supplierID) {

        try {

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //Reset Components Values
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            this.supplierRuleTestValues.clear();
            this.supplierRuleTestValuesMap.clear();

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //1. Return Sub Routines for Supplier ID
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            List<Series> subroutines = this.supplierSeriesSubRoutines.get(supplierID);

            for (Series subroutine : subroutines) {

                //Order Rule Test Value by series, rule no, test id
                Map<Integer, Map<Integer, Map<Integer, List<RuleTestValue>>>> ruleTestValuesMap = new
                        HashMap<Integer, Map<Integer, Map<Integer, List<RuleTestValue>>>>();

                //Find All Test Values by Series & Subroutines
                List<RuleTestValue> ruleTestsValues = ruleTestValueEAO.findAllRemoteBySeries(subroutine.getId(), supplierID);

                for (RuleTestValue ruleTestValue : ruleTestsValues) {

                    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    //Filter by Series
                    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

                    //Rule TestSeries Map
                    Map<Integer, Map<Integer, List<RuleTestValue>>> ruleTestSeriesMap;

                    if (ruleTestValuesMap.get(ruleTestValue.getRuleTestValuePK().getSeriesid()) == null) {
                        ruleTestSeriesMap = new HashMap<Integer, Map<Integer, List<RuleTestValue>>>();
                    } else {
                        ruleTestSeriesMap = ruleTestValuesMap.get(ruleTestValue.getRuleTestValuePK().getSeriesid());
                    }

                    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    //Filter by Rule No
                    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

                    //Rule TestRule Map
                    Map<Integer, List<RuleTestValue>> ruleTestRulesMap;

                    if (ruleTestSeriesMap.get(ruleTestValue.getRuleTestValuePK().getRuleno()) == null) {
                        ruleTestRulesMap = new HashMap<Integer, List<RuleTestValue>>();
                    } else {
                        ruleTestRulesMap = ruleTestSeriesMap.get(ruleTestValue.getRuleTestValuePK().getRuleno());
                    }

                    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    //Filter by Test Id
                    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    List<RuleTestValue> ruleTestValueList;

                    if (ruleTestRulesMap.get(ruleTestValue.getRuleTestValuePK().getTestid()) == null) {
                        ruleTestValueList = new ArrayList<RuleTestValue>();
                    } else {
                        ruleTestValueList = ruleTestRulesMap.get(ruleTestValue.getRuleTestValuePK().getTestid());
                    }

                    //Adding rule test value to filter collection
                    ruleTestValueList.add(ruleTestValue);

                    //Update Test Value Map
                    ruleTestRulesMap.put(ruleTestValue.getRuleTestValuePK().getTestid(), ruleTestValueList);

                    //Update Rule Test Rule Map
                    ruleTestSeriesMap.put(ruleTestValue.getRuleTestValuePK().getRuleno(), ruleTestRulesMap);

                    //Update Series Test Value map
                    ruleTestValuesMap.put(ruleTestValue.getRuleTestValuePK().getSeriesid(), ruleTestSeriesMap);
                }

                if (this.supplierRuleTestValues.get(supplierID) == null) {
                    this.supplierRuleTestValues.put(supplierID, ruleTestsValues);
                    this.supplierRuleTestValuesMap.put(supplierID, ruleTestValuesMap);
                } else {
                    List<RuleTestValue> supplierRuleTestsValues = this.supplierRuleTestValues.get(supplierID);
                    supplierRuleTestsValues.addAll(ruleTestsValues);

                    this.supplierRuleTestValues.put(supplierID, supplierRuleTestsValues);

                    Map<Integer, Map<Integer, Map<Integer, List<RuleTestValue>>>> supplierRuleTestValuesMap = this.supplierRuleTestValuesMap.get(supplierID);
                    supplierRuleTestValuesMap.putAll(ruleTestValuesMap);

                    this.supplierRuleTestValuesMap.put(supplierID, supplierRuleTestValuesMap);
                }
            }

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("Service application not start: " + e.getMessage(), e);
        }
    }

    /**
     * Init Remote Matrix Values
     *
     * @param supplierID, Supplier Identification Id
     */
    public void initRemoteMatrixValues(int supplierID) {

        try {

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //Reset Components Values
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            this.supplierMatrixSeries.clear();
            this.supplierMatrixHeaders.clear();
            this.supplierMatrices.clear();
            this.supplierMatrixMap.clear();

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //1. Return Sub Routines for Supplier ID
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            List<Series> subroutines = this.supplierSeriesSubRoutines.get(supplierID);

            for (Series subroutine : subroutines) {

                //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                //1. Init Matrix Series Values
                //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                List<Integer> matrixSeries = new ArrayList<Integer>();
                matrixSeries.addAll(rulesEAO.findRemoteMatrixIdsBySeries(subroutine.getId().toString(), supplierID));
                matrixSeries.addAll(rulesEAO.findRemotePartsCostPriceMatrixIdsBySeries(subroutine.getId().toString(), supplierID));
                matrixSeries.addAll(gridsEAO.findAllRemoteMatrix(supplierID));

                //------------------------------------------------------------
                //Filter Matrix not loaded in collection
                //------------------------------------------------------------
                Map<Integer, List<Matrix>> _supplier_matrix_map = this.supplierMatrixMap.get(supplierID);

                String inString = "";
                for (Iterator it = matrixSeries.iterator(); it.hasNext();) {

                    //Init Matrix ID
                    Integer _matrix_id = (Integer)it.next();

                    if (_supplier_matrix_map != null) {

                        if (_supplier_matrix_map.get(_matrix_id) == null) {

                            if (inString.length() == 0) {
                                inString = _matrix_id.toString();
                            } else {
                                inString = inString + "," + _matrix_id.toString();
                            }

                        } else {
                            it.remove();
                        }

                    } else {

                        if (inString.length() == 0) {
                            inString = _matrix_id.toString();
                        } else {
                            inString = inString + "," + _matrix_id.toString();
                        }
                    }
                }

                //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                //2. Init Matrix Header Values & Matrices
                //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

                if (inString.length() > 0) {

                    List<MatrixHeader> matrixHeaders = matrixHeaderEAO.findAllRemoteBySeries(inString, supplierID);// find by series
                    List<Matrix> matrices = matrixEAO.findAllRemoteBySeries(inString, supplierID); // find by series

                    Map<Integer, MatrixHeader> matrixHeaderMap = new HashMap<Integer, MatrixHeader>();
                    Map<Integer, List<Matrix>> matrixMap = new HashMap<Integer, List<Matrix>>();

                    for (MatrixHeader matrixHeader : matrixHeaders) {
                        matrixHeaderMap.put(matrixHeader.getId(), matrixHeader);
                    }

                    for (Integer ms : matrixSeries) {
                        List<Matrix> myML = new ArrayList<Matrix>();
                        for (Matrix matrix : matrices) {
                            if (matrix.getId().getId().intValue() == ms.intValue()) {
                                myML.add(matrix);
                            }
                        }
                        matrixMap.put(ms, myML);
                    }

                    if (this.supplierMatrixSeries.get(supplierID) == null) {
                        this.supplierMatrixSeries.put(supplierID, matrixSeries);
                        this.supplierMatrixHeaders.put(supplierID, matrixHeaders);
                        this.supplierMatrices.put(supplierID, matrices);

                        this.supplierMatrixHeaderMap.put(supplierID, matrixHeaderMap);
                        this.supplierMatrixMap.put(supplierID, matrixMap);

                    } else {

                        List<Integer> supplierMatrixSeries = this.supplierMatrixSeries.get(supplierID);
                        supplierMatrixSeries.addAll(matrixSeries);

                        this.supplierMatrixSeries.put(supplierID, supplierMatrixSeries);

                        List<MatrixHeader> supplierMatrixHeaders = this.supplierMatrixHeaders.get(supplierID);
                        supplierMatrixHeaders.addAll(matrixHeaders);

                        this.supplierMatrixHeaders.put(supplierID, supplierMatrixHeaders);

                        List<Matrix> supplierMatrices = this.supplierMatrices.get(supplierID);
                        supplierMatrices.addAll(matrices);

                        this.supplierMatrices.put(supplierID, supplierMatrices);

                        Map<Integer, MatrixHeader> supplierMatrixHeaderMap = this.supplierMatrixHeaderMap.get(supplierID);
                        supplierMatrixHeaderMap.putAll(matrixHeaderMap);

                        Map<Integer, List<Matrix>> supplierMatrixMap = this.supplierMatrixMap.get(supplierID);
                        supplierMatrixMap.putAll(matrixMap);

                        this.supplierMatrixMap.put(supplierID, supplierMatrixMap);
                    }
                }

            }

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("Service application not start: " + e.getMessage(), e);
        }
    }

    /**
     * Init Remote Valid Openings
     *
     * @param supplierID, Supplier Identification Id
     */
    public void initRemoteValidOpenings(int supplierID) {

        try {

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //1. Return Sub Routines for Supplier ID
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            this.supplierSeriesValidOpeningShapes.clear();
            this.supplierSeriesValidOpeningMap.clear();

            List<Series> subroutines = this.supplierSeriesSubRoutines.get(supplierID);

            for (Series subroutine : subroutines) {

                if (subroutine.getIsseg() > 0) {
                    continue;
                }

                List<SeriesValidOpeningShape> seriesValidOpeningShapes = seriesValidOpeningEAO.findRemoteValidOpeningsBySeriesId(subroutine.getId(), supplierID);

                Map<Integer, SeriesValidOpeningShape> seriesValidOpeningMap = new HashMap<Integer, SeriesValidOpeningShape>();
                for (SeriesValidOpeningShape validOpening : seriesValidOpeningShapes) {
                    validOpening.setSupplierId(supplierID);
                    validOpening.setRemote(true);

                    seriesValidOpeningMap.put(validOpening.getSeriesValidOpeningPK().getId(), validOpening);
                }

                if (this.supplierSeriesValidOpeningShapes.get(supplierID) == null) {
                    this.supplierSeriesValidOpeningShapes.put(supplierID, seriesValidOpeningShapes);
                    this.supplierSeriesValidOpeningMap.put(supplierID, seriesValidOpeningMap);
                } else {
                    List<SeriesValidOpeningShape> supplierSeriesValidOpeningShapes = this.supplierSeriesValidOpeningShapes.get(supplierID);
                    supplierSeriesValidOpeningShapes.addAll(seriesValidOpeningShapes);

                    this.supplierSeriesValidOpeningShapes.put(supplierID, supplierSeriesValidOpeningShapes);

                    Map<Integer, SeriesValidOpeningShape> supplierSeriesValidOpeningMap = this.supplierSeriesValidOpeningMap.get(supplierID);
                    supplierSeriesValidOpeningMap.putAll(seriesValidOpeningMap);

                    this.supplierSeriesValidOpeningMap.put(supplierID, supplierSeriesValidOpeningMap);
                }
            }

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("Service application not start: " + e.getMessage(), e);
        }
    }

    /**
     * Init Remote Valid Shapes
     *
     * @param supplierID, Supplier Identification Id
     */
    public void initRemoteValidShapes(int supplierID) {

        try {

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //Reset Components Values
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            this.supplierSeriesValidShapes.clear();
            this.supplierSeriesValidShapesMap.clear();

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //1. Return Sub Routines for Supplier ID
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            List<Series> subroutines = this.supplierSeriesSubRoutines.get(supplierID);

            for (Series subroutine : subroutines) {

                if (subroutine.getIsseg() > 0) {
                    continue;
                }

                List<SeriesValidShapes> seriesValidShapes = seriesValidShapesEAO.findRemoteValidShapesBySeriesId(subroutine.getId(), supplierID);

                Map<Integer, SeriesValidShapes> seriesValidShapesMap = new HashMap<Integer, SeriesValidShapes>();
                for (SeriesValidShapes validShapes : seriesValidShapes) {
                    validShapes.setSupplierId(supplierID);
                    validShapes.setRemote(true);

                    seriesValidShapesMap.put(validShapes.getId().getShapeId(), validShapes);
                }

                if (this.supplierSeriesValidShapes.get(supplierID) == null) {
                    this.supplierSeriesValidShapes.put(supplierID, seriesValidShapes);
                    this.supplierSeriesValidShapesMap.put(supplierID, seriesValidShapesMap);
                } else {
                    List<SeriesValidShapes> supplierSeriesValidShapes = this.supplierSeriesValidShapes.get(supplierID);
                    supplierSeriesValidShapes.addAll(seriesValidShapes);

                    this.supplierSeriesValidShapes.put(supplierID, supplierSeriesValidShapes);

                    Map<Integer, SeriesValidShapes> supplierSeriesValidShapesMap = this.supplierSeriesValidShapesMap.get(supplierID);
                    supplierSeriesValidShapesMap.putAll(seriesValidShapesMap);

                    this.supplierSeriesValidShapesMap.put(supplierID, supplierSeriesValidShapesMap);
                }

            }

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("Service application not start: " + e.getMessage(), e);
        }
    }

    /**
     * Init Remote Type Coupler Mullion
     *
     * @param supplierID, Supplier Identification Id
     */
    public void initRemoteTypeCouplerMullion(int supplierID) {

        try {

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //Reset Components Values
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            this.supplierTypeCouplerMullions.clear();
            this.supplierTypeCouplerMullionMap.clear();

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //1. Return Sub Routines for Supplier ID
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            List<Series> subroutines = this.supplierSeriesSubRoutines.get(supplierID);

            for (Series subroutine : subroutines) {

                if (subroutine.getIsseg() > 0) {
                    continue;
                }

                List<TypeCouplerMullion> typeCouplerMullions = typeCouplerMullionEAO.findRemoteBySeriesId(subroutine.getId(), supplierID);

                Map<Integer, TypeCouplerMullion> typeCouplerMullionMap = new HashMap<Integer, TypeCouplerMullion>();
                for (TypeCouplerMullion typeCouplerMullion : typeCouplerMullions) {
                    typeCouplerMullion.setSupplierId(supplierID);
                    typeCouplerMullion.setRemote(true);

                    typeCouplerMullionMap.put(typeCouplerMullion.getId().getId(), typeCouplerMullion);
                }

                if (this.supplierTypeCouplerMullions.get(supplierID) == null) {
                    this.supplierTypeCouplerMullions.put(supplierID, typeCouplerMullions);
                    this.supplierTypeCouplerMullionMap.put(supplierID, typeCouplerMullionMap);
                } else {
                    List<TypeCouplerMullion> supplierTypeCouplerMullions = this.supplierTypeCouplerMullions.get(supplierID);
                    supplierTypeCouplerMullions.addAll(typeCouplerMullions);

                    this.supplierTypeCouplerMullions.put(supplierID, supplierTypeCouplerMullions);

                    Map<Integer, TypeCouplerMullion> supplierTypeCouplerMullionMap = this.supplierTypeCouplerMullionMap.get(supplierID);
                    supplierTypeCouplerMullionMap.putAll(typeCouplerMullionMap);

                    this.supplierTypeCouplerMullionMap.put(supplierID, supplierTypeCouplerMullionMap);
                }
            }

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("Service application not start: " + e.getMessage(), e);
        }
    }

    /**
     * Init Production Lines
     *
     * @param supplierID, Supplier Identification ID
     */
    public void initRemoteProductionLines(int supplierID) {

        try {

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //Reset Components Values
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if (supplierProductionLines.size() <= 0 || supplierProductionLinesMap.size() <= 0) {

                List<ProductionLine> productionLines = productionLineEAO.findAllRemoteOrderById(supplierID);

                Map<Integer, ProductionLine> productionLineMap = new HashMap<Integer, ProductionLine>();
                for (ProductionLine prodLine : productionLines) {
                    prodLine.setSupplierId(supplierID);
                    prodLine.setRemote(true);

                    productionLineMap.put(prodLine.getId(), prodLine);
                }

                if (this.supplierProductionLinesMap.get(supplierID) == null) {
                    this.supplierProductionLines.put(supplierID, productionLines);
                    this.supplierProductionLinesMap.put(supplierID, productionLineMap);
                } else {
                    List<ProductionLine> supplierProdLines = this.supplierProductionLines.get(supplierID);
                    supplierProdLines.addAll(productionLines);

                    this.supplierProductionLines.put(supplierID, supplierProdLines);

                    Map<Integer, ProductionLine> supplierProductionLinesMap = this.supplierProductionLinesMap.get(supplierID);
                    supplierProductionLinesMap.putAll(supplierProductionLinesMap);

                    this.supplierProductionLinesMap.put(supplierID, supplierProductionLinesMap);
                }
            }

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("Service application not start: " + e.getMessage(), e);
        }
    }

    /**
     * Init Remote Parts Collection
     */
    public void initRemoteParts(int supplierID) {

        try {

            if (supplierParts.size() <= 0 || supplierPartsFamilies.size() <= 0 || supplierPartsCostPrice.size() <= 0 ||
                    supplierPricingGroups.size() <= 0 || supplierPartFamilySeries.size() <= 0) {

                List<Parts> parts = partsEAO.findAllRemote(supplierID);
                List<PartsFamily> partsFamilies = partsFamilyEAO.findAllRemote(supplierID);
                List<PartFamilySeries> partFamilySeries = partFamilySeriesEAO.findAllRemote(supplierID);
                List<PartFamilyStation> partFamilyStations = partFamilyStationEAO.findAllRemote(supplierID);
                List<PartsLabelPos> partsLabelPos = partsLabelPosEAO.findAllRemote(supplierID);

                List<PartsCostPrice> partsCostPrices = partsCostPriceEAO.findAllRemote(supplierID);
                List<PricingGroup> pricingGroups = pricingGroupEAO.findAllRemote(supplierID);

                Map<Integer, Parts> partsMap = new HashMap<Integer, Parts>();
                for (Parts partsValue : parts) {
                    partsMap.put(partsValue.getId(), partsValue);
                }

                Map<Integer, PartsFamily> partsFamiliesMap = new HashMap<Integer, PartsFamily>();
                for (PartsFamily partsFamily : partsFamilies) {
                    partsFamiliesMap.put(partsFamily.getId(), partsFamily);
                }

                Map<PartFamilySeriesPK, PartFamilySeries> partFamilySeriesMap = new HashMap<PartFamilySeriesPK, PartFamilySeries>();
                for (PartFamilySeries pFSeries : partFamilySeries) {
                    partFamilySeriesMap.put(pFSeries.getId(), pFSeries);
                }

                Map<Integer, PartsCostPrice> partsCostPriceMap = new HashMap<Integer, PartsCostPrice>();
                for (PartsCostPrice partsCostPrice : partsCostPrices) {
                    partsCostPriceMap.put(partsCostPrice.getId().getPartid(), partsCostPrice);
                }

                Map<Integer, PricingGroup> pricingGroupsMap = new HashMap<Integer, PricingGroup>();
                for (PricingGroup pricingGroup : pricingGroups) {
                    pricingGroup.setSupplierId(supplierID);
                    pricingGroup.setRemote(true);

                    pricingGroupsMap.put(pricingGroup.getId(), pricingGroup);
                }

                Map<Integer, PartFamilyStation> partFamilyStationMap = new HashMap<Integer, PartFamilyStation>();
                for (PartFamilyStation familyStation : partFamilyStations) {
                    partFamilyStationMap.put(familyStation.getPartFamilyStationPK().getPartFamilyId(), familyStation);
                }

                Map<Integer, PartsLabelPos> partsLabelPosMap = new HashMap<Integer, PartsLabelPos>();
                for (PartsLabelPos partlabelPos : partsLabelPos) {
                    partsLabelPosMap.put(partlabelPos.getId(), partlabelPos);
                }

                this.supplierParts.put(supplierID, parts);
                this.supplierPartsFamilies.put(supplierID, partsFamilies);
                this.supplierPartsCostPrice.put(supplierID, partsCostPrices);
                this.supplierPricingGroups.put(supplierID, pricingGroups);
                this.supplierPartFamilySeries.put(supplierID, partFamilySeries);
                this.supplierPartFamilyStation.put(supplierID, partFamilyStations);
                this.supplierPartLabelPos.put(supplierID, partsLabelPos);

                this.supplierPartsMap.put(supplierID, partsMap);
                this.supplierPartsFamiliesMap.put(supplierID, partsFamiliesMap);
                this.supplierPartFamilySeriesMap.put(supplierID, partFamilySeriesMap);
                this.supplierPartsCostPriceMap.put(supplierID, partsCostPriceMap);
                this.supplierPricingGroupMap.put(supplierID, pricingGroupsMap);
                this.supplierPartFamilyStationMap.put(supplierID, partFamilyStationMap);
                this.supplierPartsLabelPosMap.put(supplierID, partsLabelPosMap);

            }

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("Service application not start: " + e.getMessage(), e);
        }
    }

    /**
     * Init Remote Series Allowed SU Thick
     *
     * @param supplierID, Supplier Identification Id
     */
    public void initRemoteSeriesAllowedSUThick(int supplierID) {

        //*********************************************************************
        //Init Series Allowed SU Thick
        //*********************************************************************
        this.supplierSeriesAllowedSUThicks.clear();
        this.supplierSeriesAllowedSUThickMap.clear();

        try {

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //1. Search Series from Supplier
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            List<Series> subroutines = this.supplierSeriesSubRoutines.get(supplierID);

            for (Series s : subroutines) {

                if (s.getIsseg() > 0) {
                    continue;
                }

                List<SeriesAllowedSUThick> seriesAllowedSUThicks = seriesAllowedSUThickEAO.findRemoteBySeries(s.getId(), supplierID);

                Map<SeriesAllowedSUThickPK, SeriesAllowedSUThick> seriesAllowedSUThickMap = new HashMap<SeriesAllowedSUThickPK, SeriesAllowedSUThick>();
                for (SeriesAllowedSUThick seriesAllowedSUThick : seriesAllowedSUThicks) {
                    seriesAllowedSUThickMap.put(seriesAllowedSUThick.getId(), seriesAllowedSUThick);
                }

                //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                //2. Adding supplier series Allowed SU Thicks
                //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                if (this.supplierSeriesAllowedSUThicks.get(supplierID) == null) {
                    this.supplierSeriesAllowedSUThicks.put(supplierID, seriesAllowedSUThicks);
                    this.supplierSeriesAllowedSUThickMap.put(supplierID, seriesAllowedSUThickMap);
                } else {
                    List<SeriesAllowedSUThick> supplierSeriesAllowedSUThicks = this.supplierSeriesAllowedSUThicks.get(supplierID);
                    supplierSeriesAllowedSUThicks.addAll(seriesAllowedSUThicks);

                    Map<SeriesAllowedSUThickPK, SeriesAllowedSUThick> supplierSeriesAllowedSUThickMap = this.supplierSeriesAllowedSUThickMap.get(supplierID);
                    supplierSeriesAllowedSUThickMap.putAll(seriesAllowedSUThickMap);

                    this.supplierSeriesAllowedSUThicks.put(supplierID, supplierSeriesAllowedSUThicks);
                    this.supplierSeriesAllowedSUThickMap.put(supplierID, supplierSeriesAllowedSUThickMap);
                }
            }

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("Service application not start: " + e.getMessage(), e);
        }
    }

    /**
     * Init Remote SUTypes Collection
     *
     * @param supplierID, Supplier Identification Id
     */
    public void initRemoteSUTypes(int supplierID) {

        //*********************************************************************
        //Init Series Allowed SU Thick
        //*********************************************************************
        try {

            //Init Supplier SUFamily
            if (supplierSUFamilies.size() <= 0 || supplierSUFamilyMap.size() <= 0) {

                List<SUFamily> suFamilies = suFamilyEAO.findAllRemoteOrderById(supplierID);

                Map<Integer, SUFamily> suFamilyMap = new HashMap<Integer, SUFamily>();
                for (SUFamily suFamily : suFamilies) {
                    suFamilyMap.put(suFamily.getId(), suFamily);
                }

                this.supplierSUFamilies.put(supplierID, suFamilies);
                this.supplierSUFamilyMap.put(supplierID, suFamilyMap);

            }

            //Init Supplier SUTypes
            if (supplierSUTypes.size() <= 0 || supplierSuTypesMap.size() <= 0) {

                List<SUType> suTypes = suTypeEAO.findAllRemote(supplierID);

                Map<Integer, SUType> suTypesMap = new HashMap<Integer, SUType>();

                for (SUType suType : suTypes) {

                    suType.setSupplierRemoteId(supplierID);
                    suType.setRemote(true);

                    suTypesMap.put(suType.getId(), suType);
                }

                this.supplierSUTypes.put(supplierID, suTypes);
                this.supplierSuTypesMap.put(supplierID, suTypesMap);
            }

            //Init Supplier Grids
            if (supplierGrids.size() <= 0 || supplierGridsMap.size() <= 0) {

                List<Grids> grids = gridsEAO.findAllRemote(supplierID);

                Map<Integer, Grids> gridsMap = new HashMap<Integer, Grids>();
                for (Grids gridValue : grids) {
                    gridValue.setSupplierId(supplierID);
                    gridValue.setRemote(true);

                    gridsMap.put(gridValue.getId(), gridValue);
                }

                this.supplierGrids.put(supplierID, grids);
                this.supplierGridsMap.put(supplierID, gridsMap);
            }

            //Init Supplier Color
            if (supplierColors.size() <= 0 || supplierColorMap.size() <= 0) {

                List<Color> color = colorEAO.findAllRemote(supplierID);

                Map<Integer, Color> colorMap = new HashMap<Integer, Color>();
                for (Color colorValue : color) {

                    colorValue.setSupplierId(supplierID);
                    colorValue.setRemote(true);

                    colorMap.put(colorValue.getId(), colorValue);
                }

                this.supplierColors.put(supplierID, color);
                this.supplierColorMap.put(supplierID, colorMap);
            }

            //Init Supplier Type Glazing
            if (supplierTypeGlazing.size() <= 0 || supplierTypeGlazingMap.size() <= 0) {
                List<TypeGlazing> typeGlazings = typeGlazingEAO.findAllOrderById();

                Map<Integer, TypeGlazing> typeGlazingMap = new HashMap<Integer, TypeGlazing>();
                for (TypeGlazing typeGlazing : typeGlazings) {
                    typeGlazingMap.put(typeGlazing.getId(), typeGlazing);
                }

                this.supplierTypeGlazing.put(supplierID, typeGlazings);
                this.supplierTypeGlazingMap.put(supplierID, typeGlazingMap);
            }

            //Init Supplier Type Attribute
            if (supplierTypeAttribute.size() <= 0 || supplierTypeAttributeMap.size() <= 0) {
                List<TypeAttribute> typeAttributes = attributeTypeEAO.findAll();

                Map<Integer, TypeAttribute> typeAttributeMap = new HashMap<Integer, TypeAttribute>();
                for (TypeAttribute typeAttribute : typeAttributes) {
                    typeAttribute.setSupplierId(supplierID);
                    typeAttribute.setRemote(true);

                    typeAttributeMap.put(typeAttribute.getId(), typeAttribute);
                }

                this.supplierTypeAttribute.put(supplierID, typeAttributes);
                this.supplierTypeAttributeMap.put(supplierID, typeAttributeMap);
            }

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("Service application not start: " + e.getMessage(), e);
        }
    }

    /**
     * Init Remote Option Definitions Collection
     *
     * @param supplierID, Supplier Identification Id
     */
    public void initRemoteOptionDefinitions(int supplierID) {

        try {

            //*********************************************************************
            //Init Series Allowed SU Thick
            //*********************************************************************
            if (supplierOptionDefinitions.size() <= 0) {

                List<OptionDefinitions> optionDefinitions = optionsEAO.findAllRemote(supplierID);

                Map<Integer, OptionDefinitions> optionDefinitionsMap = new HashMap<Integer, OptionDefinitions>();
                Map<Integer, List<OptionAnswers>> optionAnswersAllowedMap = new HashMap<Integer, List<OptionAnswers>>();
                for (OptionDefinitions option : optionDefinitions) {
                    optionDefinitionsMap.put(option.getId(), option);

                    List<OptionAnswers> answers = optionAnswersEAO.findRemoteByOption(option.getId(), supplierID);
                    if (answers.size() > 0) {
                        optionAnswersAllowedMap.put(option.getId(), answers);
                    }
                }

                this.supplierOptionDefinitions.put(supplierID, optionDefinitions);
                this.supplierOptionDefinitionsMap.put(supplierID, optionDefinitionsMap);
                this.supplierOptionAnswersAllowedMap.put(supplierID, optionAnswersAllowedMap);

            }

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("Service application not start: " + e.getMessage(), e);
        }
    }

    /**
     * Init Remote Partner Line Discounts Collection
     *
     * @param supplierID, Supplier Identification Id
     */
    public void initRemotePartnerLineDiscounts(int supplierID) {

        try {

            if (supplierPartnerLineDiscounts.size() <= 0 || supplierPartnerGroupLineDiscounts.size() <= 0) {

                List<PartnerLineDiscount> partnerDiscounts = partnerLineDiscountEAO.findRemoteByPartnerId(supplierID,
                        ApplicationBaseApp.getInstance().get_company());
                List<PartnerGroupLineDiscount> partnerGroupDiscounts = partnerGroupLineDiscountEAO.findRemoteByGroupId(supplierID,
                        ApplicationBaseApp.getInstance().get_company());

                this.supplierPartnerLineDiscounts.put(supplierID, partnerDiscounts);
                this.supplierPartnerGroupLineDiscounts.put(supplierID, partnerGroupDiscounts);

            }

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("Service application not start: " + e.getMessage(), e);
        }
    }

    //******************************************<PUBLIC METHODS>********************************************************

    /**
     * Obtain an application base rules instance
     *
     * @return ApplicationBaseRulesApp
     */
    public static ApplicationRemoteBaseRulesApp getInstance() {

        if (instance == null) {
            //Instantiate new Application Base
            instance = new ApplicationRemoteBaseRulesApp();
        }

        return instance;
    }

    //**********************************************<GETTERS & SETTERS>*************************************************

    /**
     * Return Supplier Identification ID
     *
     * @return int
     */
    public int getSupplierID() {
        return this._supplier;
    }

    /**
     * Return Series Identification ID
     *
     * @return int
     */
    public int getSeriesID() {
        return this._series;
    }

    /**
     * Return Supplier Information
     *
     * @param supplierID, Supplier Identification Id
     * @return Partners
     */
    public Partner getSupplier(int supplierID) {
        return supplierMap.get(supplierID);
    }

    /**
     * Return a Series Valid Opening from Identification Id
     *
     * @param openingId, Series Valid Opening Identification Id
     * @return SeriesValidOpeningShape
     */
    public SeriesValidOpeningShape getSeriesValidOpeningById(int openingId) {

        Iterator it = supplierSeriesValidOpeningMap.entrySet().iterator();

        while (it.hasNext()) {

            Map.Entry pairs = (Map.Entry) it.next();

            //Getting Series Valid Opening Collection
            Map<Integer, SeriesValidOpeningShape> seriesValidOpening = (Map<Integer, SeriesValidOpeningShape>) pairs.getValue();

            if (seriesValidOpening.get(openingId) != null) {
                return seriesValidOpening.get(openingId);
            }
        }

        return null;
    }

    /**
     * Return a Series Valid Opening Shape from Identification Id
     *
     * @param shapeId, Shape Valid Identification Id
     * @return SeriesValidOpeningShape
     */
    public SeriesValidOpeningShape getSeriesValidOpeningShapeById(int shapeId) {

        Iterator it = supplierSeriesValidOpeningShapes.entrySet().iterator();

        while (it.hasNext()) {

            Map.Entry pairs = (Map.Entry) it.next();

            //Getting Series Valid Opening Collection
            Map<Integer, SeriesValidOpeningShape> seriesValidShapes = (Map<Integer, SeriesValidOpeningShape>) pairs.getValue();

            if (seriesValidShapes.get(shapeId) != null) {
                return seriesValidShapes.get(shapeId);
            }
        }

        return null;

    }

    /**
     * Return Rule Value by Supplier & Series and Rule number
     *
     * @param supplierID, Supplier Identification Id
     * @param seriesID,   Series Identification Id
     * @param rulesID,    Rules Number Identification Id
     * @return Rules
     */
    public Rules getRule(int supplierID, int seriesID, int rulesID) {

        Map<Integer, List<Rules>> rulesSeriesMap = this.supplierRulesMap.get(supplierID);
        List<Rules> rules = rulesSeriesMap.get(seriesID);

        for (Rules rr : rules) {
            if (rr.getRulesPK().getId() == rulesID) {
                return rr;
            }
        }

        return null;
    }

    /**
     * Return a List of Rules by Series
     *
     * @param supplierID, Supplier Identification Id
     * @param seriesID,   Series Identification Id
     * @return List
     */
    public List<Rules> getRules(int supplierID, int seriesID) {

        //+++++++++++++++++++++++++++++++++++++++++++++++++++++
        //1. Get Rules from Selected Supplier & Series
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++
        List<Rules> rules = new ArrayList<Rules>();

        Map<Integer, List<Rules>> seriesRules = this.supplierRulesMap.get(supplierID);

        if (seriesRules.get(seriesID) != null) {
            rules = seriesRules.get(seriesID);
        }

        for (Rules rule : rules) {
            rule.setSupplierId(supplierID);
            rule.setRemote(true);
        }

        return rules;
    }

    /**
     * Return a List of Rules by Series apply to Shape Object
     *
     * @param supplierID,  Supplier Identification Id
     * @param seriesID,    Series Identification Id
     * @param shapeObject, Shape Object Model
     * @return List
     */
    public List<Rules> getRulesShapeObject(int supplierID, int seriesID, ShapeObject shapeObject) {

        //+++++++++++++++++++++++++++++++++++++++++++++++++++++
        //1. Get Rules from Selected Supplier & Series
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++
        Map<Integer, List<Rules>> seriesRules = this.supplierRulesMap.get(supplierID);
        List<Rules> rules = seriesRules.get(seriesID);

        List<Rules> shapeRules = new ArrayList<Rules>();
        for (Rules rule : rules) {
            if (shapeObject.isMatchingRule(rule)) {

                //Setting Basic Information
                rule.setSupplierId(supplierID);
                rule.setRemote(true);

                shapeRules.add(rule);
            }
        }

        return shapeRules;
    }

    /**
     * Return a List of Profile by Series apply to Profiles Object
     *
     * @param supplierID, Supplier Identification Id
     * @param seriesID,   Series Identification Id
     * @param profile,    Profiles Object Model
     * @return List<Rules>
     */
    public List<Rules> getRulesProfileObject(int supplierID, int seriesID, Profiles profile) {

        //+++++++++++++++++++++++++++++++++++++++++++++++++++++
        //1. Get Rules from Selected Supplier & Series
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++
        Map<Integer, List<Rules>> seriesRules = this.supplierRulesMap.get(supplierID);
        List<Rules> rules = seriesRules.get(seriesID);

        List<Rules> profileRules = new ArrayList<Rules>();
        for (Rules rule : rules) {
            if (profile.isMatchingRule(rule)) {

                //Setting Basic Information
                rule.setSupplierId(supplierID);
                rule.setRemote(true);

                profileRules.add(rule);
            }
        }

        return profileRules;

    }

    /**
     * Return List of Rule Test by Rule Number
     *
     * @param rule, Rule Object for search
     * @return List<RuleTest>
     */
    public List<RuleTest> getRuleTestByRuleNo(Rules rule) {

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //Get Rule Test Series Map
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        Map<Integer, Map<RuleTestPK, RuleTest>> ruleTestSupplierMap = this.supplierRulesTestMap.get(rule.getSupplierId());
        Map<RuleTestPK, RuleTest> rulesTestSeriesMap = ruleTestSupplierMap.get(rule.getRulesPK().getSeriesId());

        List<RuleTest> ruleTestSeries = new ArrayList<RuleTest>();
        for (Map.Entry key : rulesTestSeriesMap.entrySet()) {
            RuleTest test = (RuleTest) key.getValue();
            if (test.getRuleTestPK().getRuleno() == rule.getRulesPK().getId()) {
                ruleTestSeries.add((RuleTest) key.getValue());
            }
        }

        return ruleTestSeries;
    }

    /**
     * Return a List of Rule Test By Supplier Identification
     *
     * @param supplierID, Supplier Identification Id
     * @param seriesID,   Series Identification Id
     * @return List
     */
    public List<RuleTest> getRuleTest(int supplierID, int seriesID) {

        Map<Integer, Map<RuleTestPK, RuleTest>> seriesRuleTestMap = this.supplierRulesTestMap.get(supplierID);
        Map<RuleTestPK, RuleTest> ruleTestMap = seriesRuleTestMap.get(seriesID);

        List<RuleTest> ruleTestSeries = new ArrayList<RuleTest>();
        for (Map.Entry key : ruleTestMap.entrySet()) {
            ruleTestSeries.add((RuleTest) key.getValue());
        }

        return ruleTestSeries;
    }

    /**
     * Return a List of Rule Test
     *
     * @param supplierID, Supplier Identification Id
     * @param seriesID,   Series Identification Id
     * @return List
     */
    public List<RuleTest> getRuleTestBySeries(int supplierID, int seriesID) {

        Map<Integer, Map<RuleTestPK, RuleTest>> seriesRuleTestMap = supplierRulesTestMap.get(supplierID);
        Map<RuleTestPK, RuleTest> rulesTestSeriesMap = seriesRuleTestMap.get(seriesID);

        List<RuleTest> ruleTestSeries = new ArrayList<RuleTest>();
        for (Map.Entry key : rulesTestSeriesMap.entrySet()) {
            ruleTestSeries.add((RuleTest) key.getValue());
        }

        return ruleTestSeries;
    }

    /**
     * Return a List of Rule Test Values
     *
     * @param supplierID, Supplier Identification Id
     * @param seriesID,   Series Identification Id
     * @param ruleID,     Rule Identification Id
     * @param testID,     Test Identification Id
     * @return List
     */
    public List<RuleTestValue> getRuleTestValues(int supplierID, int seriesID, int ruleID, int testID) {

        //Get Rule Test Values by Supplier ID
        Map<Integer, Map<Integer, Map<Integer, List<RuleTestValue>>>> seriesRuleTestValuesMap = this.supplierRuleTestValuesMap.get(supplierID);

        //Get Rule Test Values by Series ID
        Map<Integer, Map<Integer, List<RuleTestValue>>> ruleTestValuesRulesMap = new HashMap<Integer, Map<Integer, List<RuleTestValue>>>();
        if (seriesRuleTestValuesMap.get(seriesID) != null) {
            ruleTestValuesRulesMap = seriesRuleTestValuesMap.get(seriesID);
        }

        //Get Rule Test Values by Rule ID
        Map<Integer, List<RuleTestValue>> ruleTestValuesMap = new HashMap<Integer, List<RuleTestValue>>();
        if (ruleTestValuesRulesMap.get(ruleID) != null) {
            ruleTestValuesMap = ruleTestValuesRulesMap.get(ruleID);
        }

        //Get Rule Test Collection by test Id
        List<RuleTestValue> rulesTestValues = new ArrayList<RuleTestValue>();
        if (ruleTestValuesMap.get(testID) != null) {
            rulesTestValues = ruleTestValuesMap.get(testID);
        }

        return rulesTestValues;
    }

    /**
     * Return a List of Rules Answers
     *
     * @param supplierID, Supplier Identification Id
     * @return List<RuleAnswers>
     */
    public List<RuleAnswers> getRuleAnswers(int supplierID) {
        return this.supplierRuleAnswers.get(supplierID);
    }

    /**
     * Return a List of Part Cost Prices
     *
     * @param supplierID, Supplier Identification ID
     * @return List<PartsCostPrice>
     */
    public List<PartsCostPrice> getPartCostPrices(int supplierID) {
        return this.supplierPartsCostPrice.get(supplierID);
    }

    /**
     * Return Pricing Group
     *
     * @param supplierID,     Supplier Identification ID
     * @param pricingGroupId, Pricing Group ID
     * @return PricingGroup
     */
    public PricingGroup getPricingGroup(int supplierID, int pricingGroupId) {
        Map<Integer, PricingGroup> pricingGroupMap = this.supplierPricingGroupMap.get(supplierID);
        return pricingGroupMap.get(pricingGroupId);
    }

    /**
     * Return Part Family Object Value
     *
     * @param supplierID,   Supplier Identification ID
     * @param partFamilyID, Part Identification Id
     * @return PartsFamily
     */
    public PartsFamily getPartFamily(int supplierID, int partFamilyID) {

        Map<Integer, PartsFamily> partsFamilyMap = this.supplierPartsFamiliesMap.get(supplierID);

        PartsFamily partsFamily = partsFamilyMap.get(partFamilyID);
        return partsFamily;
    }

    /**
     * Return Part Object Value
     *
     * @param supplierID, Supplier Identification Id
     * @param partID,     Part Identification Id
     * @return Parts
     */
    public Parts getPart(int supplierID, int partID) {

        Map<Integer, Parts> partsMap = this.supplierPartsMap.get(supplierID);

        Parts parts = null;

        if (partsMap.get(partID) != null) {
            parts = partsMap.get(partID).clone();
            parts.setSupplierId(supplierID);
            parts.setRemote(true);
        }

        return parts;
    }

    /**
     * Return Part Label Position
     *
     * @param supplierID,  Supplier Identification ID
     * @param partLabelID, Part label Identification ID
     * @return PartsLabelPos
     */
    public PartsLabelPos getPartLabelPos(int supplierID, int partLabelID) {
        Map<Integer, PartsLabelPos> partsLabelPosMap = this.supplierPartsLabelPosMap.get(supplierID);
        return partsLabelPosMap.get(partLabelID);
    }

    /**
     * Return a Matrix Header Value
     *
     * @param supplierID, Supplier Identification Id
     * @param matrixID,   Matrix Identification Id
     * @return Matrix Header
     */
    public MatrixHeader getMatrixHeader(int supplierID, int matrixID) {
        Map<Integer, MatrixHeader> matrixHeaderMap = this.supplierMatrixHeaderMap.get(supplierID);
        return matrixHeaderMap.get(matrixID);
    }

    /**
     * Return Matrix Cell Collection
     *
     * @param supplierID, Supplier Identification ID
     * @return List<Matrix>
     */
    public List<Matrix> getMatrixCells(int supplierID, int matrixID) {
        Map<Integer, List<Matrix>> matrixMap = this.supplierMatrixMap.get(supplierID);

        List<Matrix> matrices = matrixMap.get(matrixID);
        for (Matrix matrix : matrices) {
            matrix.setSupplierId(supplierID);
            matrix.setRemote(true);
        }

        return matrices;
    }

    /**
     * Return Option Rules from remote suppliers
     *
     * @param supplierID, Supplier Identification ID
     * @param seriesID,   Series Identification ID
     * @return List<Rules>
     */
    public List<Rules> getOptionRules(int supplierID, int seriesID) {

        Map<Integer, List<Rules>> seriesOptionRulesMap = this.supplierOptionsRulesMap.get(supplierID);
        List<Rules> optionRules = seriesOptionRulesMap.get(seriesID);

        for (Rules rules : optionRules) {
            rules.setSupplierId(supplierID);
            rules.setRemote(true);
        }

        List<Rules> rules = new ArrayList<Rules>();
        rules.addAll(optionRules);

        return rules;
    }

    /**
     * Return Option Definition Object
     *
     * @param supplierID,         Supplier Identification Id
     * @param optionDefinitionID, Option Definition Identification Id
     * @return OptionDefinitions
     */
    public OptionDefinitions getOptionDefinitions(int supplierID, int optionDefinitionID) {
        Map<Integer, OptionDefinitions> optionDefinitionsMap = this.supplierOptionDefinitionsMap.get(supplierID);

        OptionDefinitions optionDefinition = optionDefinitionsMap.get(optionDefinitionID);
        optionDefinition.setSupplierID(supplierID);
        optionDefinition.setRemote(true);

        return optionDefinition;
    }

    /**
     * Return Option Answers List by Option Definitions
     *
     * @param supplierID,         Supplier Identification Id
     * @param optionDefinitionID, Option Definition Identification ID
     * @return List
     */
    public List<OptionAnswers> getOptionAnswers(int supplierID, int optionDefinitionID) {

        Map<Integer, List<OptionAnswers>> optionAnswersAllowedMap = this.supplierOptionAnswersAllowedMap.get(supplierID);
        return optionAnswersAllowedMap.get(optionDefinitionID);
    }

    /**
     * Return Option Answers Object
     *
     * @param supplierID,         Supplier Identification Id
     * @param optionDefinitionID, Option Definition Identification Id
     * @param optionAnswersID,    Option Answers Identification Id
     * @return OptionAnswers
     */
    public OptionAnswers getOptionAnswers(int supplierID, int optionDefinitionID, int optionAnswersID) {

        Map<Integer, List<OptionAnswers>> seriesOptionAnswersMap = this.supplierOptionAnswersAllowedMap.get(supplierID);
        List<OptionAnswers> answers = seriesOptionAnswersMap.get(optionDefinitionID);

        OptionAnswers optionAnswers = null;
        for (OptionAnswers optionAnswer : answers) {
            if (optionAnswer.getId().getId() == optionAnswersID) {
                optionAnswers = optionAnswer;
                break;
            }
        }

        if (optionAnswers != null) {
            optionAnswers.setSupplierId(supplierID);
            optionAnswers.setRemote(true);
        }

        return optionAnswers;
    }

    /**
     * Return Type Glazing List
     *
     * @return List
     */
    public List<TypeGlazing> getTypeGlazing() {
        List<TypeGlazing> typeGlazings = new ArrayList<TypeGlazing>();
        for (Map.Entry<Integer, List<TypeGlazing>> entry : this.supplierTypeGlazing.entrySet()) {
            typeGlazings.addAll(entry.getValue());
        }

        return typeGlazings;
    }

    /**
     * Return Grids List
     *
     * @return List
     */
    public List<Grids> getGrids() {

        List<Grids> grids = new ArrayList<Grids>();
        for (Map.Entry<Integer, List<Grids>> entry : this.supplierGrids.entrySet()) {
            grids.addAll(entry.getValue());
        }

        return grids;
    }

    /**
     * Return Grid Object
     *
     * @param supplierId, Supplier Identification Id
     * @param gridId,     Grid Identification Id
     * @return Grids
     */
    public Grids getGrids(int supplierId, int gridId) {

        Grids gridSelected = null;

        List<Grids> grids = this.supplierGrids.get(supplierId);
        for (Grids grid : grids) {
            if (grid.getId() == gridId) {
                gridSelected = grid;
            }
        }

        return gridSelected;
    }

    /**
     * Return Color Object
     * @param supplierId, Supplier Identification Id
     * @param colorId, Color Identification Id
     * @return Color
     */
    public Color getColor(int supplierId, int colorId) {

        Color colorSelected = null;

        List<Color> colors = this.supplierColors.get(supplierId);
        for (Color color : colors) {
            if (color.getId() == colorId) {
                colorSelected = color;
            }
        }

        return colorSelected;
    }

    /**
     * Return SU Families
     *
     * @return List<SUFamily>
     */
    public List<SUFamily> getSuFamilies() {

        List<SUFamily> suFamilies = new ArrayList<SUFamily>();
        for (Map.Entry<Integer, List<SUFamily>> entry : this.supplierSUFamilies.entrySet()) {
            suFamilies.addAll(entry.getValue());
        }

        return suFamilies;
    }

    /**
     * Return a List of SU Types
     *
     * @param uom, Unit of Metric
     * @return List
     */
    public List<SUType> getSuTypes(int uom) {

        List<SUType> selectSUTypes = new ArrayList<SUType>();

        for (Map.Entry<Integer, Map<SeriesAllowedSUThickPK, SeriesAllowedSUThick>> entry : supplierSeriesAllowedSUThickMap.entrySet()) {
            Map<SeriesAllowedSUThickPK, SeriesAllowedSUThick> seriesAllowedSUThickMap = entry.getValue();

            for (Map.Entry<SeriesAllowedSUThickPK, SeriesAllowedSUThick> entry_2 : seriesAllowedSUThickMap.entrySet()) {
                SeriesAllowedSUThick thickness = entry_2.getValue();

                for (SUType suType : supplierSUTypes.get(entry.getKey())) {

                    if (Metrics.METRIC.getValue() == uom) {
                        if ((suType.getThickness() >= thickness.getId().getFromThick()) &&
                                (suType.getThickness() <= thickness.getId().getToThick()) && suType.getDisplay()) {
                            selectSUTypes.add(suType);
                        }
                    }

                    if (Metrics.IMPERIAL_DECIMAL.getValue() == uom) {
                        if ((suType.getThicknessImp() >= thickness.getId().getFromThickImp()) &&
                                (suType.getThicknessImp() <= thickness.getId().getToThickImp()) && suType.getDisplay()) {
                            selectSUTypes.add(suType);
                        }
                    }
                }
            }
        }

        //Sort collection by sort sequence
        Collections.sort(selectSUTypes, SUTypeObjectOrder.SORT_SEQ);

        return selectSUTypes;
    }

    /**
     * Return a SUType Object
     *
     * @param supplierId, Supplier Identification Id
     * @param suTypeId,   SUType Identification Id
     * @return SUType
     */
    public SUType getSUType(int supplierId, int suTypeId) {
        SUType suTypeSelected = null;

        List<SUType> suTypes = supplierSUTypes.get(supplierId);
        for (SUType suType : suTypes) {
            if (suType.getId() == suTypeId) {
                suTypeSelected = suType;

                break;
            }
        }

        return suTypeSelected;
    }

    /**
     * Return TypeAttribute
     *
     * @param supplierId,      Supplier Identification Id
     * @param typeAttributeId, Type Attribute Identification Id
     * @return TypeAttribute
     */
    public TypeAttribute getAttribute(int supplierId, int typeAttributeId) {
        Map<Integer, TypeAttribute> typeAttributeMap = supplierTypeAttributeMap.get(supplierId);
        return typeAttributeMap.get(typeAttributeId);
    }

    /**
     * Return Production LIne Object
     *
     * @param supplierId, Supplier Identification Id
     * @param prodLineId, Production Line Identification Id
     * @return ProductionLine
     */
    public ProductionLine getProductionLine(int supplierId, int prodLineId) {
        Map<Integer, ProductionLine> prodLines = supplierProductionLinesMap.get(supplierId);
        return prodLines.get(prodLineId);
    }

    /**
     * Return a Series Valid Shapes List
     *
     * @return List
     */
    public List<SeriesValidShapes> getSeriesValidShapes() {

        Iterator it = supplierSeriesValidShapes.entrySet().iterator();

        List<SeriesValidShapes> validShapes = new ArrayList<SeriesValidShapes>();
        while (it.hasNext()) {

            Map.Entry pairs = (Map.Entry) it.next();

            List<SeriesValidShapes> seriesValidShapes = (List<SeriesValidShapes>) pairs.getValue();
            validShapes.addAll(seriesValidShapes);
        }

        return validShapes;
    }

    /**
     * Return a Series Valid Openings List
     *
     * @return List
     */
    public List<SeriesValidOpeningShape> getSeriesValidOpeningShapes() {

        Iterator it = supplierSeriesValidOpeningShapes.entrySet().iterator();

        List<SeriesValidOpeningShape> validOpenings = new ArrayList<SeriesValidOpeningShape>();
        while (it.hasNext()) {

            Map.Entry pairs = (Map.Entry) it.next();

            List<SeriesValidOpeningShape> seriesValidOpenings = (List<SeriesValidOpeningShape>) pairs.getValue();
            validOpenings.addAll(seriesValidOpenings);
        }

        return validOpenings;
    }

    /**
     * Return a List of Type Coupler Mullions
     *
     * @return List
     */
    public List<TypeCouplerMullion> getTypeCouplerMullions() {

        Iterator it = supplierTypeCouplerMullions.entrySet().iterator();

        List<TypeCouplerMullion> couplerMullions = new ArrayList<TypeCouplerMullion>();

        while (it.hasNext()) {

            Map.Entry pairs = (Map.Entry) it.next();

            List<TypeCouplerMullion> seriesCouplerMullions = (List<TypeCouplerMullion>) pairs.getValue();
            couplerMullions.addAll(seriesCouplerMullions);
        }

        return couplerMullions;
    }

    /**
     * Return Partner Line Discount
     *
     * @param supplierId, Supplier Identification Id
     * @return List
     */
    public List<PartnerLineDiscount> getPartnerLineDiscounts(int supplierId) {
        return supplierPartnerLineDiscounts.get(supplierId);
    }

    /**
     * Return Partner Group Line Discount
     *
     * @param supplierId, Supplier Identification Id
     * @return List
     */
    public List<PartnerGroupLineDiscount> getPartnerGroupLineDiscounts(int supplierId) {
        return supplierPartnerGroupLineDiscounts.get(supplierId);
    }

}

package org.openjanela.data;

import Model.SeriesSegmentExec;
import Model.ShapeObject;
import Model.ProfileParts.Profiles;
import Presentation.ItemFrame;
import openjanela.model.eao.admin.typeGlazingEAO.TypeGlazingEAO;
import openjanela.model.eao.admin.typeGlazingEAO.TypeGlazingPersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.partner.adjustmentRO_EAO.AdjustmentRO_EAO;
import openjanela.model.eao.partner.adjustmentRO_EAO.AdjustmentRO_PersistenceEAO;
import openjanela.model.eao.partner.colorEAO.ColorEAO;
import openjanela.model.eao.partner.colorEAO.ColorPersistenceEAO;
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
import openjanela.model.eao.partner.partsCostPriceEAO.PartsCostPriceEAO;
import openjanela.model.eao.partner.partsCostPriceEAO.PartsCostPricePersistenceEAO;
import openjanela.model.eao.partner.partsEAO.PartsEAO;
import openjanela.model.eao.partner.partsEAO.PartsPersistenceEAO;
import openjanela.model.eao.partner.partsFamilyEAO.PartsFamilyEAO;
import openjanela.model.eao.partner.partsFamilyEAO.PartsFamilyPersistenceEAO;
import openjanela.model.eao.partner.partsFamilyStationEAO.PartsFamilyStationEAO;
import openjanela.model.eao.partner.partsFamilyStationEAO.PartsFamilyStationPersistenceEAO;
import openjanela.model.eao.partner.pricingGroupEAO.PricingGroupEAO;
import openjanela.model.eao.partner.pricingGroupEAO.PricingGroupPersistenceEAO;
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
import openjanela.model.eao.partner.seriesValidOpeningShapeMfgEAO.SeriesValidOpeningShapeMfgEAO;
import openjanela.model.eao.partner.seriesValidOpeningShapeMfgEAO.SeriesValidOpeningShapeMfgPersistenceEAO;
import openjanela.model.eao.partner.seriesValidShapesEAO.SeriesValidShapesEAO;
import openjanela.model.eao.partner.seriesValidShapesEAO.SeriesValidShapesPersistenceEAO;
import openjanela.model.eao.partner.suFamilyEAO.SUFamilyEAO;
import openjanela.model.eao.partner.suFamilyEAO.SUFamilyPersistenceEAO;
import openjanela.model.eao.partner.suTypeEAO.SUTypeEAO;
import openjanela.model.eao.partner.suTypeEAO.SUTypePersistenceEAO;
import openjanela.model.eao.partner.typeCouplerMullionEAO.TypeCouplerMullionEAO;
import openjanela.model.eao.partner.typeCouplerMullionEAO.TypeCouplerMullionPersistenceEAO;
import openjanela.model.eao.partner.typeMatrixDictionaryEAO.TypeMatrixDictionaryEAO;
import openjanela.model.eao.partner.typeMatrixDictionaryEAO.TypeMatrixDictionaryPersistenceEAO;
import openjanela.model.entities.admin.TypeGlazing;
import openjanela.model.entities.design.Metrics;
import openjanela.model.entities.orderEntry.PricingGroup;
import openjanela.model.entities.partner.*;

import openjanela.model.entities.parts.*;
import org.apache.log4j.Logger;
import org.eclipse.core.internal.jobs.Worker;

import java.util.*;
import java.util.concurrent.*;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-01-13
 *          Time: 03:28 PM
 */
public class ApplicationBaseRulesApp {

    //Apache Log4j
    private static final Logger logger = Logger.getLogger(ApplicationBaseRulesApp.class);

    //Application base rules
    private static ApplicationBaseRulesApp instance;

    //Series Identification actual
    private int _series = -1;

    private List<AdjustmentRo> adjustmentRos = new ArrayList<AdjustmentRo>();
    private List<Rules> rules = new ArrayList<Rules>();
    private List<RuleTest> rulesTest = new ArrayList<RuleTest>();
    private List<RuleTestValue> ruleTestValues = new ArrayList<RuleTestValue>();
    private List<RuleAnswers> ruleAnswers = new ArrayList<RuleAnswers>();
    private List<Series> seriesSubRoutines = new ArrayList<Series>();
    private List<SeriesValidShapes> seriesValidShapes = new ArrayList<SeriesValidShapes>();
    private List<SeriesValidOpeningShape> seriesValidOpeningShapes = new ArrayList<SeriesValidOpeningShape>();
    private List<SeriesValidOpeningShapeMfg> seriesValidOpeningShapesMfg = new ArrayList<SeriesValidOpeningShapeMfg>();

    private List<Matrix> matrices = new ArrayList<Matrix>();
    private List<Integer> matrixSeries = new ArrayList<Integer>();
    private List<MatrixHeader> matrixHeaders = new ArrayList<MatrixHeader>();
    private List<MatrixHeader> commissionMatrixHeaders = new ArrayList<MatrixHeader>();
    private List<Matrix> commissionMatrices = new ArrayList<Matrix>();

    private List<Parts> parts = new ArrayList<Parts>();
    private List<PartsFamily> partsFamilies = new ArrayList<PartsFamily>();
    private List<PartFamilySeries> partFamilySeries = new ArrayList<PartFamilySeries>();
    private List<PartFamilyStation> partFamilyStations = new ArrayList<PartFamilyStation>();
    private List<PartsCostPrice> partsCostPrices = new ArrayList<PartsCostPrice>();
    private List<PricingGroup> pricingGroups = new ArrayList<PricingGroup>();

    private List<TypeMatrixDiccionary> typeMatrixDictionaries = new ArrayList<TypeMatrixDiccionary>();
    private List<TypeCouplerMullion> typeCouplerMullions = new ArrayList<TypeCouplerMullion>();

    private List<SeriesAllowedSUThick> seriesAllowedSUThicks = new ArrayList<SeriesAllowedSUThick>();
    private List<SUType> suTypes = new ArrayList<SUType>();
    private List<Color> color = new ArrayList<Color>();
    private List<SUFamily> suFamilies = new ArrayList<SUFamily>();
    private List<Grids> grids = new ArrayList<Grids>();
    private List<TypeGlazing> typeGlazings = new ArrayList<TypeGlazing>();
    private List<OptionDefinitions> optionDefinitions = new ArrayList<OptionDefinitions>();

    private Map<Integer, AdjustmentRo> adjustmentRoMap = new HashMap<Integer, AdjustmentRo>();
    private Map<Integer, Color> colorMap = new HashMap<Integer, Color>();
    private Map<Integer, MatrixHeader> matrixHeaderMap = new HashMap<Integer, MatrixHeader>();
    private Map<Integer, TypeMatrixDiccionary> typeMatrixDiccionaryMap = new HashMap<Integer, TypeMatrixDiccionary>();
    private Map<Integer, List<Matrix>> matrixMap = new HashMap<Integer, List<Matrix>>();
    private Map<Integer, MatrixHeader> commissionMatrixHeaderMap = new HashMap<Integer, MatrixHeader>();
    private Map<Integer, List<Matrix>> commissionMatrixMap = new HashMap<Integer, List<Matrix>>();
    private Map<Integer, Series> seriesSubRoutinesMap = new HashMap<Integer, Series>();
    private Map<Integer, List<Rules>> rulesMap = new HashMap<Integer, List<Rules>>();
    private Map<Integer, List<Rules>> optionsRulesMap = new HashMap<Integer, List<Rules>>();
    private Map<Integer, Map<RuleTestPK, RuleTest>> rulesTestMap = new HashMap<Integer, Map<RuleTestPK, RuleTest>>();
    private Map<Integer, Map<Integer, Map<Integer, List<RuleTestValue>>>> ruleTestValuesMap = new HashMap<Integer, Map<Integer, Map<Integer, List<RuleTestValue>>>>();
    private Map<Integer, RuleAnswers> ruleAnswersMap = new HashMap<Integer, RuleAnswers>();
    private Map<Integer, SeriesValidShapes> seriesValidShapesMap = new HashMap<Integer, SeriesValidShapes>();
    private Map<Integer, SeriesValidOpeningShape> seriesValidOpeningMap = new HashMap<Integer, SeriesValidOpeningShape>();
    private Map<Integer, SeriesValidOpeningShapeMfg> seriesValidOpeningShapeMfgMap = new HashMap<Integer, SeriesValidOpeningShapeMfg>();
    private Map<Integer, TypeCouplerMullion> typeCouplerMullionMap = new HashMap<Integer, TypeCouplerMullion>();

    private Map<Integer, Parts> partsMap = new HashMap<Integer, Parts>();
    private Map<Integer, PartsFamily> partsFamiliesMap = new HashMap<Integer, PartsFamily>();
    private Map<PartFamilySeriesPK, PartFamilySeries> partFamilySeriesMap = new HashMap<PartFamilySeriesPK, PartFamilySeries>();
    private Map<Integer, PartFamilyStation> partFamilyStationMap = new HashMap<Integer, PartFamilyStation>();
    private Map<Integer, PartsCostPrice> partsCostPriceMap = new HashMap<Integer, PartsCostPrice>();
    private Map<Integer, PricingGroup> pricingGroupsMap = new HashMap<Integer, PricingGroup>();
    private Map<Integer, OptionDefinitions> optionDefinitionsMap = new HashMap<Integer, OptionDefinitions>();
    private Map<Integer, List<OptionAnswers>> optionAnswersAllowedMap = new HashMap<Integer, List<OptionAnswers>>();

    private Map<SeriesAllowedSUThickPK, SeriesAllowedSUThick> seriesAllowedSUThickMap = new HashMap<SeriesAllowedSUThickPK, SeriesAllowedSUThick>();
    private Map<Integer, SUType> suTypesMap = new HashMap<Integer, SUType>();
    private Map<Integer, SUFamily> suFamilyMap = new HashMap<Integer, SUFamily>();
    private Map<Integer, Grids> gridsMap = new HashMap<Integer, Grids>();
    private Map<Integer, TypeGlazing> typeGlazingMap = new HashMap<Integer, TypeGlazing>();

    //Entity Access Objects
    protected AdjustmentRO_EAO adjustmentROEAO;
    protected ColorEAO colorEAO;
    protected MatrixHeaderEAO matrixHeaderEAO;
    protected MatrixEAO matrixEAO;
    protected MatrixSeriesEAO matrixSeriesEAO;
    protected TypeMatrixDictionaryEAO typeMatrixDictionaryEAO;
    protected RulesEAO rulesEAO;
    protected RuleTestEAO ruleTestEAO;
    protected RuleTestValueEAO ruleTestValueEAO;
    protected RuleAnswersEAO ruleAnswersEAO;
    protected SeriesCategoryEAO seriesCategoryEAO;
    protected SeriesEAO seriesEAO;
    protected SeriesValidOpeningShapeEAO seriesValidOpeningEAO;
    protected SeriesValidShapesEAO seriesValidShapesEAO;
    protected SeriesValidOpeningShapeMfgEAO seriesValidOpeningShapeMfgEAO;
    protected TypeCouplerMullionEAO typeCouplerMullionEAO;

    protected OptionsEAO optionsEAO;
    protected OptionAnswersEAO optionAnswersEAO;
    protected PartsEAO partsEAO;
    protected PartsFamilyEAO partsFamilyEAO;
    protected PartFamilySeriesEAO partFamilySeriesEAO;
    protected PartsFamilyStationEAO partFamilyStationEAO;
    protected PartsCostPriceEAO partsCostPriceEAO;
    protected PricingGroupEAO pricingGroupEAO;
    protected SeriesAllowedSUThickEAO seriesAllowedSUThickEAO;
    protected SUTypeEAO suTypeEAO;
    protected SUFamilyEAO suFamilyEAO;
    protected GridsEAO gridsEAO;
    protected TypeGlazingEAO typeGlazingEAO;

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    /**
     * Application Base Rules Constructor
     */
    public ApplicationBaseRulesApp() {

        //Init Entity Access Objects
        this.adjustmentROEAO = new AdjustmentRO_PersistenceEAO();
        this.colorEAO = new ColorPersistenceEAO();
        this.matrixHeaderEAO = new MatrixHeaderPersistenceEAO();
        this.matrixEAO = new MatrixPersistenceEAO();
        this.matrixSeriesEAO = new MatrixSeriesPersistenceEAO();
        this.rulesEAO = new RulesPersistenceEAO();
        this.ruleTestEAO = new RuleTestPersistenceEAO();
        this.ruleTestValueEAO = new RuleTestValuePersistenceEAO();
        this.ruleAnswersEAO = new RuleAnswersPersistenceEAO();
        this.seriesCategoryEAO = new SeriesCategoryPersistenceEAO();
        this.seriesValidOpeningEAO = new SeriesValidOpeningShapePersistenceEAO();
        this.seriesValidShapesEAO = new SeriesValidShapesPersistenceEAO();
        this.seriesValidOpeningShapeMfgEAO = new SeriesValidOpeningShapeMfgPersistenceEAO();
        this.seriesEAO = new SeriesPersistenceEAO();
        this.typeMatrixDictionaryEAO = new TypeMatrixDictionaryPersistenceEAO();
        this.typeCouplerMullionEAO = new TypeCouplerMullionPersistenceEAO();

        this.optionsEAO = new OptionsPersistenceEAO();
        this.optionAnswersEAO = new OptionAnswersPersistenceEAO();
        this.partsEAO = new PartsPersistenceEAO();
        this.partsFamilyEAO = new PartsFamilyPersistenceEAO();
        this.partFamilySeriesEAO = new PartFamilySeriesPersistenceEAO();
        this.partFamilyStationEAO = new PartsFamilyStationPersistenceEAO();
        this.partsCostPriceEAO = new PartsCostPricePersistenceEAO();
        this.pricingGroupEAO = new PricingGroupPersistenceEAO();
        this.seriesAllowedSUThickEAO = new SeriesAllowedSUThickPersistenceEAO();

        this.suTypeEAO = new SUTypePersistenceEAO();
        this.suFamilyEAO = new SUFamilyPersistenceEAO();
        this.gridsEAO = new GridsPersistenceEAO();
        this.typeGlazingEAO = new TypeGlazingPersistenceEAO();
    }

    /**
     * Init Application Base Datas for Rules
     *
     * @param seriesID, Series Identification Id
     */
    private void initApplicationBaseRules(int seriesID) {

        initSeriesSubRoutines(seriesID);

        //Init Execution Load Datas
        final int param_series_id = seriesID;

        //Init Adjustment Ros
        initAdjustmentRos(seriesID);
        initRulesSubRoutines(seriesID);
        initRulesTest(seriesID);
        initRuleTestValues(seriesID);
        initValidOpeningShapes(seriesID);
        initSeriesValidShapes(seriesID);
        initSUThickness(seriesID);
        initMatrixOptions(seriesID);
        initTypeCouplerMullions(seriesID);

        executorService.execute(new Runnable() {
            public void run() {
                initValidOpeningManufacturers(param_series_id);
            }
        });

        executorService.execute(new Runnable() {
            public void run() {
                initCommissionMatrix(param_series_id);
            }
        });

        executorService.execute(new Runnable() {
            public void run() {
                initTypeMatrixDictionary(param_series_id);
            }
        });

        executorService.execute(new Runnable() {
            public void run() {
                initTypeGlazing();
            }
        });

        executorService.execute(new Runnable() {
            public void run() {
                initSUType();
            }
        });

        executorService.execute(new Runnable() {
            public void run() {
                initOptionDefinitions();
            }
        });

        executorService.execute(new Runnable() {
            public void run() {
                initPartsObjects();
            }
        });

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //Update information series values
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        Timer timer = new Timer();

        TimerTask delayedThreadStartTask = new TimerTask() {
            @Override
            public void run() {

                //captureCDRProcess();
                //moved to TimerTask
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        updateSeriesValue(param_series_id);
                    }
                }).start();
            }
        };

        timer.schedule(delayedThreadStartTask, 1000);
    }

    /**
     * Update Series Value
     *
     * @param seriesID, Series Identification Id
     */
    private void updateSeriesValue(int seriesID) {
        this._series = seriesID;
    }

    /**
     * Init Adjustment ROs
     *
     * @param seriesID, Series Identification Id
     */
    private void initAdjustmentRos(int seriesID) {

        //*********************************************************************
        // Init Adjustment RO
        //*********************************************************************
        if (_series != seriesID) {

            try {

                adjustmentRos = adjustmentROEAO.findROs(seriesID);

                for (AdjustmentRo adjustmentRo : adjustmentRos) {
                    adjustmentRoMap.put(adjustmentRo.getAdjustmentRoPK().getId(), adjustmentRo);
                }

            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application not start: " + e.getMessage(), e);
            }
        }
    }

    /**
     * Init Series SubRoutines
     *
     * @param seriesID, Series Identification Id
     */
    private void initSeriesSubRoutines(int seriesID) {

        //Series Object Identification
        Series series = ApplicationMainBaseApp.getInstance().getSeriesByID(seriesID);

        //*********************************************************************
        // Init Series Subroutines
        //*********************************************************************
        if (_series != seriesID) {

            try {

                //Init Series Sub Routines
                this.seriesSubRoutines = new ArrayList<Series>();
                this.seriesSubRoutinesMap = new HashMap<Integer, Series>();

                //Find All Series Segments by Series Identification
                List<Integer> seriesSegments = rulesEAO.findAllSeriesSegments(seriesID);

                //Create In String Value
                String inString = "";
                for (Integer ms : seriesSegments) {
                    if (inString.length() == 0) {
                        inString = ms.toString();
                    } else {
                        inString = inString + "," + ms.toString();
                    }
                }

                //Find All Series Sub-Routines
                this.seriesSubRoutines = seriesEAO.findAllSeriesSubRoutines(inString);

                for (Series subRoutine : this.seriesSubRoutines) {
                    seriesSubRoutinesMap.put(subRoutine.getId(), subRoutine);
                }

                //Find Series Selected & added to collection
                if (seriesSubRoutinesMap.get(series) == null && seriesID > 0) {
                    Series seriesSelected = ApplicationMainBaseApp.getInstance().getSeriesByID(seriesID);

                    seriesSubRoutines.add(seriesSelected);
                    seriesSubRoutinesMap.put(seriesSelected.getId(), seriesSelected);
                }

                for (Series subRoutine : seriesSubRoutines) {
                    if (!subRoutine.getMadeIn() && subRoutine.getIsseg() == 2) {
                        ItemFrame.getApplicationRemoteBaseRules().initRemoteSeriesSegments(subRoutine.getId());
                    }
                }

            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application not start: " + e.getMessage(), e);
            }
        }
    }

    /**
     * Init Rules SubRoutines
     *
     * @param seriesID, Series Series Identification Id
     */
    private void initRulesSubRoutines(int seriesID) {

        //*********************************************************************
        //Init Execution Rules
        //*********************************************************************
        if (this._series != seriesID) {

            try {

                //Init Application Map Values
                this.ruleAnswers = new ArrayList<RuleAnswers>();

                this.rulesMap = new HashMap<Integer, List<Rules>>();
                this.ruleAnswersMap = new HashMap<Integer, RuleAnswers>();
                this.optionsRulesMap = new HashMap<Integer, List<Rules>>();

                for (Series subRoutine : this.seriesSubRoutines) {

                    //Search Rules for subroutines
                    List<Rules> rules = rulesEAO.findAllRulesbySeries(subRoutine.getId());
                    List<Rules> optionRules = rulesEAO.findAllOptionRulesbySeries(subRoutine.getId());
                    List<RuleTest> ruleTests = ruleTestEAO.findAllBySeries(subRoutine.getId());
                    List<RuleAnswers> ruleAnswers = ruleAnswersEAO.findAllAnswers(subRoutine.getId());

                    if (ruleAnswers != null || ruleAnswers.size() > 0) {
                        this.ruleAnswers.addAll(ruleAnswers);

                        //Process Rule Answers Values
                        for (RuleAnswers ruleAnswer : ruleAnswers) {
                            ruleAnswersMap.put(ruleAnswer.getRuleAnswersPK().getAnswerid(), ruleAnswer);
                        }
                    }

                    if (rules != null || rules.size() > 0) {
                        this.rulesMap.put(subRoutine.getId(), rules);
                    }

                    if (optionRules != null || optionRules.size() > 0) {
                        this.optionsRulesMap.put(subRoutine.getId(), optionRules);
                    }

                    //Process Rule Test Values
                    if (ruleTests != null || ruleTests.size() > 0) {

                        Map<RuleTestPK, RuleTest> ruleTestMap = new HashMap<RuleTestPK, RuleTest>();
                        for (RuleTest ruleTest : ruleTests) {
                            ruleTestMap.put(ruleTest.getRuleTestPK(), ruleTest);
                        }

                        this.rulesTestMap.put(subRoutine.getId(), ruleTestMap);
                    }
                }

            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application rules not start: " + e.getMessage(), e);
            }
        }
    }

    /**
     * Init Rules Test
     *
     * @param seriesID, Series Identification Id
     */
    private void initRulesTest(int seriesID) {

        //*********************************************************************
        //Init Execution Rules Test
        //*********************************************************************
        if (this._series != seriesID) {

            try {

                rulesTestMap = new HashMap<Integer, Map<RuleTestPK, RuleTest>>();

                for (Series subRoutine : this.seriesSubRoutines) {
                    List<RuleTest> ruleTests = ruleTestEAO.findAllBySeries(subRoutine.getId());

                    Map<RuleTestPK, RuleTest> ruleTestMap = new HashMap<RuleTestPK, RuleTest>();
                    for (RuleTest ruleTest : ruleTests) {
                        ruleTestMap.put(ruleTest.getRuleTestPK(), ruleTest);
                    }

                    this.rulesTestMap.put(subRoutine.getId(), ruleTestMap);
                }

            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application rules not start: " + e.getMessage(), e);
            }
        }

    }

    /**
     * Init Rules Test Values
     *
     * @param seriesID, Series Identification Id
     */
    private void initRuleTestValues(int seriesID) {

        //*********************************************************************
        //Init Execution Rules Test Value
        //*********************************************************************
        if (this._series != seriesID) {

            try {

                //Init Collections
                this.ruleTestValuesMap = new HashMap<Integer, Map<Integer, Map<Integer, List<RuleTestValue>>>>();

                for (Series subRoutine : seriesSubRoutines) {

                    //Search Rules for subroutines
                    if (subRoutine.getMadeIn()) {

                        //Find All Test Values by Series & Subroutines
                        List<RuleTestValue> ruleTestsValues = ruleTestValueEAO.findAllBySeries(subRoutine.getId());

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
                    }
                }

            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application rules not start: " + e.getMessage(), e);
            }
        }

    }

    /**
     * Init Type Matrix Dictionary
     *
     * @param seriesID, Series Identification Id
     */
    private void initTypeMatrixDictionary(int seriesID) {

        //*********************************************************************
        // Init Type Matrix Dictionary
        //*********************************************************************
        if (typeMatrixDictionaries.size() == 0 || typeMatrixDiccionaryMap.size() == 0) {

            try {

                //Search all matrix dictionaries
                this.typeMatrixDictionaries = typeMatrixDictionaryEAO.findAll();

                for (TypeMatrixDiccionary matrixDiccionary : typeMatrixDictionaries) {
                    this.typeMatrixDiccionaryMap.put(matrixDiccionary.getId(), matrixDiccionary);
                }

            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application not start: " + e.getMessage(), e);
            }
        }
    }

    /**
     * Init Matrix Options
     *
     * @param seriesID, Series Identification Id
     */
    private void initMatrixOptions(int seriesID) {

        //*********************************************************************
        //Init Matrix Options
        //*********************************************************************
        if (this._series != seriesID) {

            try {

                matrices = new ArrayList<Matrix>();
                matrixSeries = new ArrayList<Integer>();
                matrixHeaders = new ArrayList<MatrixHeader>();

                matrixMap = new HashMap<Integer, List<Matrix>>();
                matrixHeaderMap = new HashMap<Integer, MatrixHeader>();

                //Init Series Subroutines
                String seriesString = "";
                for (Series subRoutines : seriesSubRoutines) {
                    if (seriesString.length() == 0) {
                        seriesString = subRoutines.getId().toString();
                    } else {
                        seriesString = seriesString + "," + subRoutines.getId().toString();
                    }
                }

                if (seriesString.length() > 0) {

                    matrixSeries.addAll(rulesEAO.findMatrixIdsBySeries(seriesString));
                    matrixSeries.addAll(rulesEAO.findPartsCostPriceMatrixIdsBySeries(seriesString));
                    matrixSeries.addAll(gridsEAO.findAllMatrix());

                    String inString = "";
                    for (Integer ms : matrixSeries) {
                        if (inString.length() == 0) {
                            inString = ms.toString();
                        } else {
                            inString = inString + "," + ms.toString();
                        }
                    }

                    matrixHeaders = matrixHeaderEAO.findAllBySeries(inString);// find by series
                    matrices = matrixEAO.findAllBySeries(inString); // find by series

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
                }

            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application not start: " + e.getMessage(), e);
            }
        }

    }

    /**
     * Init Commission Matrix
     *
     * @param seriesID, Series Identification Id
     */
    private void initCommissionMatrix(int seriesID) {

        //*********************************************************************
        //Init Commission Matrix Options
        //*********************************************************************
        try {

            commissionMatrixHeaders = new ArrayList<MatrixHeader>();
            commissionMatrices = new ArrayList<Matrix>();

            commissionMatrixMap = new HashMap<Integer, List<Matrix>>();
            commissionMatrixHeaderMap = new HashMap<Integer, MatrixHeader>();

            commissionMatrixHeaders = matrixHeaderEAO.findAllCommission();// find by series

            String inString = "";
            for (MatrixHeader ms : commissionMatrixHeaders) {
                if (inString.length() == 0) {
                    inString = ms.getId().toString();
                } else {
                    inString = inString + "," + ms.getId().toString();
                }
            }

            if (inString.length() > 0) {

                commissionMatrices = matrixEAO.findAllByHeaders(inString); // find by series

                for (MatrixHeader matrixHeader : commissionMatrixHeaders) {
                    commissionMatrixHeaderMap.put(matrixHeader.getId(), matrixHeader);

                    List<Matrix> commMatrices = new ArrayList<Matrix>();
                    for (Matrix matrix : commissionMatrices) {
                        if (matrix.getId().getId().intValue() == matrixHeader.getId().intValue()) {
                            commMatrices.add(matrix);
                        }
                    }

                    commissionMatrixMap.put(matrixHeader.getId(), commMatrices);
                }
            }

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("Service application not start: " + e.getMessage(), e);
        }

    }

    /**
     * Init Valid Opening Shapes
     *
     * @param seriesID, Series Identification Id
     */
    private void initValidOpeningShapes(int seriesID) {

        //*********************************************************************
        //Init Series Valid Opening Shape
        //*********************************************************************
        if (this._series != seriesID) {

            try {

                this.seriesValidOpeningShapes = new ArrayList<SeriesValidOpeningShape>();
                this.seriesValidOpeningMap = new HashMap<Integer, SeriesValidOpeningShape>();

                for (Series subRoutines : seriesSubRoutines) {

                    //Search Series Subroutines
                    if (subRoutines.getMadeIn()) {

                        seriesValidOpeningShapes = seriesValidOpeningEAO.findValidOpeningsBySeriesId(subRoutines.getId());

                        for (SeriesValidOpeningShape validOpening : seriesValidOpeningShapes) {
                            seriesValidOpeningMap.put(validOpening.getSeriesValidOpeningPK().getId(), validOpening);
                        }
                    }
                }

            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application not start: " + e.getMessage(), e);
            }
        }

    }

    /**
     * Init Series Valid Shapes
     *
     * @param seriesID, Series Identification Id
     */
    private void initSeriesValidShapes(int seriesID) {

        //*********************************************************************
        //Init Series Valid Shapes
        //*********************************************************************
        if (this._series != seriesID) {

            try {

                this.seriesValidShapes = new ArrayList<SeriesValidShapes>();
                this.seriesValidShapesMap = new HashMap<Integer, SeriesValidShapes>();

                for (Series subRoutines : seriesSubRoutines) {

                    if (subRoutines.getMadeIn()) {

                        seriesValidShapes = seriesValidShapesEAO.findValidShapesBySeriesId(subRoutines.getId());

                        for (SeriesValidShapes validShapes : seriesValidShapes) {
                            seriesValidShapesMap.put(validShapes.getId().getShapeId(), validShapes);
                        }
                    }
                }

            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application not start: " + e.getMessage(), e);
            }
        }
    }

    /**
     * Init Valid Opening Manufacturers
     *
     * @param seriesID, Series Identification Id
     */
    private void initValidOpeningManufacturers(int seriesID) {

        //*********************************************************************
        //Init Series Valid Opening Shape Manufacture
        //*********************************************************************
        if (this._series != seriesID) {

            try {

                seriesValidOpeningShapesMfg = new ArrayList<SeriesValidOpeningShapeMfg>();
                seriesValidOpeningShapeMfgMap = new HashMap<Integer, SeriesValidOpeningShapeMfg>();

                for (Series subRoutines : seriesSubRoutines) {
                    seriesValidOpeningShapesMfg = seriesValidOpeningShapeMfgEAO.findBySeriesId(subRoutines.getId());

                    for (SeriesValidOpeningShapeMfg validShapesMfg : seriesValidOpeningShapesMfg) {
                        seriesValidOpeningShapeMfgMap.put(validShapesMfg.getId().getShapeId(), validShapesMfg);
                    }
                }

            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application not start: " + e.getMessage(), e);
            }
        }

    }

    /**
     * Init Type Coupler Mullions
     *
     * @param seriesID, Series Identification Id
     */
    private void initTypeCouplerMullions(int seriesID) {

        //*********************************************************************
        // Init Type Coupler Mullions
        //*********************************************************************
        if (this._series != seriesID) {

            try {

                this.typeCouplerMullions = new ArrayList<TypeCouplerMullion>();
                this.typeCouplerMullionMap = new HashMap<Integer, TypeCouplerMullion>();

                for (Series subRoutines : seriesSubRoutines) {

                    if (subRoutines.getMadeIn()) {
                        typeCouplerMullions = typeCouplerMullionEAO.findBySeriesId(subRoutines.getId());

                        for (TypeCouplerMullion typeCouplerMullion : typeCouplerMullions) {
                            typeCouplerMullionMap.put(typeCouplerMullion.getId().getId(), typeCouplerMullion);
                        }
                    }
                }

            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application not start: " + e.getMessage(), e);
            }
        }

    }

    /**
     * Init Type Glazing
     */
    private void initTypeGlazing() {

        //*********************************************************************
        // Init Type Glazings
        //*********************************************************************
        if (this.typeGlazings.size() == 0 || typeGlazingMap.size() == 0) {

            try {

                typeGlazings = typeGlazingEAO.findAllOrderById();

                for (TypeGlazing typeGlazing : typeGlazings) {
                    typeGlazingMap.put(typeGlazing.getId(), typeGlazing);
                }

            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application not start: " + e.getMessage(), e);
            }
        }
    }

    /**
     * Init SU Thickness
     *
     * @param seriesID, Series Identification Id
     */
    private void initSUThickness(int seriesID) {

        //*********************************************************************
        //Init Series Allowed SU Thick
        //*********************************************************************
        if (this._series != seriesID) {

            try {

                this.seriesAllowedSUThicks = new ArrayList<SeriesAllowedSUThick>();

                for (Series subRoutines : this.seriesSubRoutines) {

                    if (subRoutines.getMadeIn()) {
                        this.seriesAllowedSUThicks = seriesAllowedSUThickEAO.findBySeries(subRoutines.getId());

                        for (SeriesAllowedSUThick seriesAllowedSUThick : seriesAllowedSUThicks) {
                            this.seriesAllowedSUThickMap.put(seriesAllowedSUThick.getId(), seriesAllowedSUThick);
                        }
                    }
                }

            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application not start: " + e.getMessage(), e);
            }
        }
    }

    /**
     * Init SUType Object
     */
    private void initSUType() {

        //*********************************************************************
        //Init SUTypes
        //*********************************************************************
        if (this.suTypes.size() <= 0 || this.suFamilies.size() <= 0 || this.grids.size() <= 0) {

            try {

                this.suTypes = new ArrayList<SUType>();
                this.suFamilies = new ArrayList<SUFamily>();
                this.grids = new ArrayList<Grids>();
                this.color = new ArrayList<Color>();

                this.suTypesMap = new HashMap<Integer, SUType>();
                this.suFamilyMap = new HashMap<Integer, SUFamily>();
                this.gridsMap = new HashMap<Integer, Grids>();
                this.colorMap = new HashMap<Integer, Color>();

                this.suTypes = suTypeEAO.findAll();
                this.suFamilies = suFamilyEAO.findAllOrderById();
                this.grids = gridsEAO.findAll();
                this.color = colorEAO.findAll();

                for (SUType suType : suTypes) {
                    this.suTypesMap.put(suType.getId(), suType);
                }

                for (SUFamily suFamily : suFamilies) {
                    this.suFamilyMap.put(suFamily.getId(), suFamily);
                }

                for (Grids gridValue : grids) {
                    this.gridsMap.put(gridValue.getId(), gridValue);
                }

                for (Color colorValue : color) {
                    this.colorMap.put(colorValue.getId(), colorValue);
                }

            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application not start: " + e.getMessage(), e);
            }
        }

    }

    /**
     * Init Option Definitions
     */
    private void initOptionDefinitions() {

        //*********************************************************************
        //Init Options Definitions and Options Answers
        //*********************************************************************
        if (optionDefinitions.size() == 0 || optionDefinitionsMap.size() == 0 || optionAnswersAllowedMap.size() == 0) {

            try {

                this.optionDefinitions = new ArrayList<OptionDefinitions>();
                this.optionDefinitionsMap = new HashMap<Integer, OptionDefinitions>();

                this.optionDefinitions = optionsEAO.findAll();

                for (OptionDefinitions option : optionDefinitions) {
                    optionDefinitionsMap.put(option.getId(), option);

                    List<OptionAnswers> answers = optionAnswersEAO.findByOption(option.getId());
                    if (answers.size() > 0) {
                        optionAnswersAllowedMap.put(option.getId(), answers);
                    }
                }

            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application not start: " + e.getMessage(), e);
            }
        }
    }

    /**
     * Init Parts Object Collection
     */
    private void initPartsObjects() {


        //*********************************************************************
        // Init Part Collections
        //*********************************************************************
        if (this.parts.size() <= 0 || this.partsFamilies.size() <= 0 || this.partFamilySeries.size() <= 0 ||
                this.partsCostPrices.size() <= 0 || this.pricingGroups.size() <= 0) {

            try {

                this.parts = new ArrayList<Parts>();
                this.partsFamilies = new ArrayList<PartsFamily>();
                this.partFamilySeries = new ArrayList<PartFamilySeries>();
                this.partFamilyStations = new ArrayList<PartFamilyStation>();
                this.partsCostPrices = new ArrayList<PartsCostPrice>();
                this.pricingGroups = new ArrayList<PricingGroup>();

                this.parts = partsEAO.findAllReadOnly();
                this.partsFamilies = partsFamilyEAO.findAll();
                this.partFamilySeries = partFamilySeriesEAO.findAll();
                this.partFamilyStations = partFamilyStationEAO.findAll();
                this.partsCostPrices = partsCostPriceEAO.findAll();
                this.pricingGroups = pricingGroupEAO.findAll();

                for (Parts partsValue : parts) {
                    partsMap.put(partsValue.getId(), partsValue);
                }

                for (PartsFamily partsFamily : partsFamilies) {
                    partsFamiliesMap.put(partsFamily.getId(), partsFamily);
                }

                for (PartFamilySeries pFSeries : partFamilySeries) {
                    partFamilySeriesMap.put(pFSeries.getId(), pFSeries);
                }

                for (PartsCostPrice partsCostPrice : partsCostPrices) {
                    partsCostPriceMap.put(partsCostPrice.getId().getPartid(), partsCostPrice);
                }

                for (PricingGroup pricingGroup : pricingGroups) {
                    pricingGroupsMap.put(pricingGroup.getId(), pricingGroup);
                }

                for (PartFamilyStation familyStation : partFamilyStations) {
                    partFamilyStationMap.put(familyStation.getPartFamilyStationPK().getPartFamilyId(), familyStation);
                }

            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application not start: " + e.getMessage(), e);
            }
        }

    }

    //******************************************<PUBLIC METHODS>********************************************************

    /**
     * Obtain an application base rules instance
     *
     * @return ApplicationBaseRulesApp
     */
    public static ApplicationBaseRulesApp getInstance() {
        if (instance == null) {
            //Instantiate new Application Base
            instance = new ApplicationBaseRulesApp();
        }

        return instance;
    }

    /**
     * Obtain an application base rules instance
     *
     * @param series, Series Identification
     * @return ApplicationBaseRulesApp
     */
    public static ApplicationBaseRulesApp getInstance(int series) {
        if (instance == null) {
            //Instantiate new Application Base
            instance = new ApplicationBaseRulesApp();
        }

        //Init Application Base Rules
        instance.initApplicationBaseRules(series);

        return instance;
    }

    /**
     * Obtain an application base rules instance
     *
     * @param series,  Series Identification
     * @param company, Company Identification
     * @return ApplicationBaseRulesApp
     */
    public static ApplicationBaseRulesApp getInstance(int series, int company) {
        if (instance == null) {
            //Instantiate new Application Base
            instance = new ApplicationBaseRulesApp();
        }

        //Init Application Base Rules
        instance.initApplicationBaseRules(series);

        return instance;
    }

    //**********************************************<GETTERS & SETTERS>************************************************

    /**
     * Return Series Identification Id
     *
     * @return int
     */
    public int getSeriesID() {
        return _series;
    }

    /**
     * Return Adjustment Ro
     *
     * @param id, Identification Id
     * @return AdjustmentRo
     */
    public AdjustmentRo getAdjustmentRos(int id) {
        return adjustmentRoMap.get(id);
    }

    /**
     * Return Parts Object
     *
     * @param id, Part Identification Id
     * @return Parts
     */
    public Parts getPart(int id) {
        return partsMap.get(id);
    }

    /**
     * Return default station for part family identification
     *
     * @param partFamilyId, Part Family Identification Id
     * @return Integer
     */
    public Integer getPartFamilyStation(int partFamilyId) {
        if (partFamilyStationMap.get(partFamilyId) != null) {
            return partFamilyStationMap.get(partFamilyId).getPartFamilyStationPK().getStationId();
        }

        return -1;
    }

    /**
     * Return Pricing Group Object
     *
     * @param id, Pricing Group Identification Id
     * @return PricingGroup
     */
    public PricingGroup getPricingGroup(int id) {
        return pricingGroupsMap.get(id);
    }

    /**
     * Return a List of Adjustment ROs
     *
     * @return List
     */
    public List<AdjustmentRo> getAdjustmentRos() {
        return adjustmentRos;
    }

    /**
     * Return a List of Adjustment ROs
     *
     * @param isHead, boolean
     * @return List
     */
    public List<AdjustmentRo> getAdjustmentRos(int seriesId, boolean isHead) {
        List<AdjustmentRo> isHeads = new ArrayList<AdjustmentRo>();
        for (AdjustmentRo adjustmentRo : adjustmentRos) {
            if (adjustmentRo.getAdjustmentRoPK().getSeriesId() == seriesId && adjustmentRo.getIsHead() == isHead) {
                isHeads.add(adjustmentRo);
            }
        }

        Collections.sort(isHeads, AdjustmentRo.AdjustmentRoComparator);

        return isHeads;
    }

    /**
     * Return Matrix Cell Collection
     *
     * @param id, Identification Id
     * @return List<Matrix>
     */
    public List<Matrix> getMatrixCells(int id) {
        return matrixMap.get(id);
    }

    /**
     * Return Matrix Header collection
     *
     * @return List
     */
    public List<MatrixHeader> getMatrixHeaders() {
        return matrixHeaders;
    }

    /**
     * Return a Matrix collection
     *
     * @return List
     */
    public List<Matrix> getMatrices() {
        return matrices;
    }

    /**
     * Return a Matrix Header Value
     *
     * @param id, Identification Id
     * @return Matrix Header
     */
    public MatrixHeader getMatrixHeader(int id) {
        return matrixHeaderMap.get(id);
    }

    /**
     * Return Commision Matrix Header
     *
     * @param id, Commision Id
     * @return MatrixHeader
     */
    public MatrixHeader getCommissionMatrixHeader(int id) {
        return commissionMatrixHeaderMap.get(id);
    }

    /**
     * Return Commission Matrix Cells
     *
     * @param id, Matrix Identification Id
     * @return List<Matrix>
     */
    public List<Matrix> getCommissionMatrixCells(int id) {
        return commissionMatrixMap.get(id);
    }

    /**
     * Return Type Matrix Diccionary List
     *
     * @return List<TypeMatrixDiccionary>
     */
    public List<TypeMatrixDiccionary> getTypeMatrixDictionaries() {
        return typeMatrixDictionaries;
    }

    /**
     * Return Type Matrix Diccionary
     *
     * @param id, Identification Id
     * @return TypeMatrixDiccionary
     */
    public TypeMatrixDiccionary getTypeMatrixDictionary(int id) {
        return typeMatrixDiccionaryMap.get(id);
    }

    /**
     * Return a List of Rules by series
     *
     * @param series, Series Identification Id
     * @return List
     */
    public List<Rules> getRules(int series) {

        //+++++++++++++++++++++++++++++++++++++++++++++++++++++
        //1. Get Rules From Selected Series
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++
        List<Rules> rulesSeries = new ArrayList<Rules>();

        //Get Rules by Series Identification
        List<Rules> rules = rulesMap.get(series);

        if (rules == null) {
            return rulesSeries;
        }

        //Adding Rules to Rules Series Collection
        rulesSeries.addAll(rules);

        //+++++++++++++++++++++++++++++++++++++++++++++++++++++
        //2. Get Rules from Remote Suppliers Sub-Routines
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++
        List<Rules> supplierRules = new ArrayList<Rules>();
        for (Rules rule : rules) {
            if (rule.getRuletype() == 9) {
                Series subroutine = seriesSubRoutinesMap.get(rule.getRulevalue());

                if (subroutine != null && subroutine.getSupplierId() > 0) {
                    supplierRules.addAll(ItemFrame.getApplicationRemoteBaseRules().getRules(subroutine.getSupplierId(),
                            subroutine.getSupplierSeriesId()));
                }
            }
        }

        rulesSeries.addAll(supplierRules);

        //Sort Rules by rule number
        Collections.sort(rules, RulesComparator.RULE_ID);

        return rulesSeries;
    }

    /**
     * Return Rule Value by series and rule number
     *
     * @param series,      Series Identification Id
     * @param rulesNumber, Rules Number Identification Id
     * @return Rules
     */
    public Rules getRule(int series, int rulesNumber) {
        List<Rules> rules = rulesMap.get(series);


        for (Rules rr : rules) {
            if (rr.getRulesPK().getId() == rulesNumber) {
                return rr;
            }
        }

        return null;
    }

    /**
     * Return a List of Rules by series apply to Shape Object
     *
     * @param series,      Series Identification Id
     * @param shapeObject, Shape Object Model
     * @return List
     */
    public List<Rules> getRulesShapeObject(int series, ShapeObject shapeObject) {

        //+++++++++++++++++++++++++++++++++++++++++++++++++++++
        //1. Get Rules from Selected Series
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++
        List<Rules> rules = rulesMap.get(series);

        List<Rules> rulesSeries = new ArrayList<Rules>();
        for (Rules rule : rules) {
            if (shapeObject.isMatchingRule(rule)) {
                rulesSeries.add(rule);
            }
        }

        //+++++++++++++++++++++++++++++++++++++++++++++++++++++
        //2. Get Rules from Remote Suppliers Sub-Routines
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++
        List<Rules> supplierRules = new ArrayList<Rules>();
        for (Rules rule : rules) {
            if (rule.getRuletype() == 9) {
                Series subroutine = seriesSubRoutinesMap.get(rule.getRulevalue());

                if (subroutine.getSupplierId() > 0) {
                    supplierRules.addAll(ItemFrame.getApplicationRemoteBaseRules().getRulesShapeObject(subroutine.getSupplierId(),
                            subroutine.getSupplierSeriesId(), shapeObject));
                }
            }
        }

        rulesSeries.addAll(supplierRules);

        return rulesSeries;
    }

    /**
     * Add Rules from Series Segments
     *
     * @param rules,          Rules Collection Objects
     * @param seriesSegments, Series Segments Collections Objects
     * @param shapeObject,    Shape Object
     * @return List
     */
    public List<Rules> addSubRules(List<Rules> rules, Map<Integer, SeriesSegmentExec> seriesSegments, ShapeObject shapeObject) {

        List<Rules> mr = new ArrayList<Rules>();

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //Iterate Series Segments
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        for (Map.Entry<Integer, SeriesSegmentExec> entry : seriesSegments.entrySet()) {
            SeriesSegmentExec seriesSegment = entry.getValue();

            if (seriesSegment.isRemote()) {
                mr.addAll(ItemFrame.getApplicationRemoteBaseRules().getRules(seriesSegment.getSupplierID(),
                        seriesSegment.getSeriesID()));
            } else {
                mr.addAll(this.rulesMap.get(seriesSegment.getSeriesID()));
            }
        }

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //Iterate Rules Matching Rules
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        List<Rules> shapeRules = new ArrayList<Rules>();
        for (Rules rule : mr) {
            if (shapeObject.isMatchingRule(rule)) {
                shapeRules.add(rule);
            }
        }

        rules.addAll(shapeRules);

        return rules;
    }

    public List<Rules> addSubRules(List<Rules> rules, Collection subs, ShapeObject shapeObject) {

        List<Rules> mR = new ArrayList<Rules>();

        for (Object s : subs.toArray()) {

            mR.addAll(rulesMap.get(Integer.parseInt(s.toString())));
        }

        List<Rules> rulesSeries = new ArrayList<Rules>();

        for (Rules rule : mR) {
            if (shapeObject.isMatchingRule(rule)) {
                rulesSeries.add(rule);
            }
        }

        rules.addAll(rulesSeries);

        return rules;

    }

    /**
     * Return a List of Rules by series apply to Shape Object
     *
     * @param series,   Series Identification Id
     * @param profiles, Profiles Object Model
     * @return List
     */
    public List<Rules> getRulesProfiles(int series, Profiles profiles) {

        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //1. Get Profiles Rules from Selected Series
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        List<Rules> rules = rulesMap.get(series);

        List<Rules> rulesSeries = new ArrayList<Rules>();
        for (Rules rule : rules) {
            if (profiles.isMatchingRule(rule)) {
                rulesSeries.add(rule);
            }
        }

        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //2. Get Rules Profiles from Remote Suppliers Sub-Routines
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        List<Rules> supplierRules = new ArrayList<Rules>();
        for (Rules rule : rules) {
            if (rule.getRuletype() == 9) {
                Series subroutine = seriesSubRoutinesMap.get(rule.getRulevalue());

                if (subroutine.getSupplierId() > 0) {
                    supplierRules.addAll(ItemFrame.getApplicationRemoteBaseRules().getRulesProfileObject(subroutine.getSupplierId(),
                            subroutine.getSupplierSeriesId(), profiles));
                }
            }
        }

        rulesSeries.addAll(supplierRules);

        return rulesSeries;
    }

    /**
     * Return a List of Rules by series
     *
     * @param series, Series Identification Id
     * @return List
     */
    public List<Rules> getOptionRules(int series) {

        //+++++++++++++++++++++++++++++++++++++++++++++++++++++
        //1. Get Option Rules for Series
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++
        List<Rules> optionRules = optionsRulesMap.get(series);

        List<Rules> rules = new ArrayList<Rules>();
        rules.addAll(optionRules);

        //+++++++++++++++++++++++++++++++++++++++++++++++++++++
        //2. Get Option Rules Segment for Supplier
        //+++++++++++++++++++++++++++++++++++++++++++++++++++++
        List<Rules> supplierOptionRules = new ArrayList<Rules>();
        for (Rules rule : rules) {
            if (rule.getRuletype() == 3) {
                Series subroutine = seriesSubRoutinesMap.get(rule.getRulevalue());
                
                if (subroutine != null && subroutine.getSupplierId() > 0) {
                	supplierOptionRules.addAll(ItemFrame.getApplicationRemoteBaseRules().getOptionRules(subroutine.getSupplierId(),
                			subroutine.getSupplierSeriesId()));
                }
            }
        }

        rules.addAll(supplierOptionRules);

        return rules;
    }

    /**
     * Return a List of Rule Test
     *
     * @param series, Series Identification Id
     * @return List
     */
    public List<RuleTest> getRuleTest(int series) {
        Map<RuleTestPK, RuleTest> rulesTestSeriesMap = rulesTestMap.get(series);

        List<RuleTest> ruleTestSeries = new ArrayList<RuleTest>();

        if (rulesTestSeriesMap == null) {
            return ruleTestSeries;
        }

        for (Map.Entry key : rulesTestSeriesMap.entrySet()) {
            ruleTestSeries.add((RuleTest) key.getValue());
        }

        return ruleTestSeries;
    }

    /**
     * Return a Rule Test from value identification
     *
     * @param seriesId,   Series Identification
     * @param ruleTestId, Rule Test Base Identification
     * @return RulesTest
     */
    public RuleTest getRuleTest(int seriesId, int ruleTestId) {
        Map<RuleTestPK, RuleTest> rulesTest = rulesTestMap.get(seriesId);
        return rulesTest.get(ruleTestId);
    }

    /**
     * Return a List of Rule Test by Rule Number
     *
     * @param ruleNo, Rule Number Identification Id
     * @param series, Series Identification Id
     * @return List
     */
    public List<RuleTest> getRuleTestByRuleNo(int ruleNo, int series) {

        Map<RuleTestPK, RuleTest> rulesTestSeriesMap = rulesTestMap.get(series);

        List<RuleTest> ruleTestSeries = new ArrayList<RuleTest>();
        for (Map.Entry key : rulesTestSeriesMap.entrySet()) {
            RuleTest test = (RuleTest) key.getValue();
            if (test.getRuleTestPK().getRuleno() == ruleNo) {
                ruleTestSeries.add((RuleTest) key.getValue());
            }
        }

        return ruleTestSeries;
    }

    /**
     * Return List of Rule Test by Rule Number
     *
     * @param rule, Rule Object for search
     * @return List<RuleTest>
     */
    public List<RuleTest> getRuleTestByRuleNo(Rules rule) {

        //Rule Test Series Values
        List<RuleTest> ruleTestSeries = new ArrayList<RuleTest>();

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //Get Rules Test for Manufacturing Rules
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        if (!rule.isRemote()) {

            Map<RuleTestPK, RuleTest> rulesTestSeriesMap = rulesTestMap.get(rule.getRulesPK().getSeriesId());

            for (Map.Entry key : rulesTestSeriesMap.entrySet()) {
                RuleTest test = (RuleTest) key.getValue();
                if (test.getRuleTestPK().getRuleno() == rule.getRulesPK().getId()) {
                    ruleTestSeries.add((RuleTest) key.getValue());
                }
            }
        }

        return ruleTestSeries;
    }

    /**
     * Return a List of Rule Test Values
     *
     * @param seriesId, Series Identification Id
     * @param ruleId,   Rule Identification Id
     * @param testId,   Test Identification Id
     * @return List
     */
    public List<RuleTestValue> getRuleTestValues(int seriesId, int ruleId, int testId) {

        //Get Rule Test Values by series Id
        Map<Integer, Map<Integer, List<RuleTestValue>>> ruleTestValuesRulesMap = new HashMap<Integer, Map<Integer, List<RuleTestValue>>>();
        if (ruleTestValuesMap.get(seriesId) != null) {
            ruleTestValuesRulesMap = ruleTestValuesMap.get(seriesId);
        }

        //Get Rule Test Values by rule Id
        Map<Integer, List<RuleTestValue>> ruleTestValuesMap = new HashMap<Integer, List<RuleTestValue>>();
        if (ruleTestValuesRulesMap.get(ruleId) != null) {
            ruleTestValuesMap = ruleTestValuesRulesMap.get(ruleId);
        }

        //Get Rule Test Collection by test Id
        List<RuleTestValue> rulesTestValues = new ArrayList<RuleTestValue>();
        if (ruleTestValuesMap.get(testId) != null) {
            rulesTestValues = ruleTestValuesMap.get(testId);
        }

        return rulesTestValues;
    }

    /**
     * Return a List of Rule Answers values
     *
     * @return List
     */
    public List<RuleAnswers> getRuleAnswers() {
        return ruleAnswers;
    }

    /**
     * Return a List of Rule Answers Values
     *
     * @param rule, Rule Object Value
     * @return List<RuleAnswers>
     */
    public List<RuleAnswers> getRuleAnswers(Rules rule) {

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //Return Rules Answers for Supplier
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        if (rule.isRemote()) {
            return ItemFrame.getApplicationRemoteBaseRules().getRuleAnswers(rule.getSupplierId());
        }

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //Return Rules Answers Local
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        return ruleAnswers;
    }

    /**
     * Return a Rule Answers from value identification
     *
     * @param ruleAnswersId, Rule Answers Identification
     * @return RuleAnswers
     */
    public RuleAnswers getRuleAnswer(int ruleAnswersId) {
        return ruleAnswersMap.get(ruleAnswersId);
    }

    /**
     * Return a Series Valid Openings List
     *
     * @return List
     */
    public List<SeriesValidOpeningShape> getSeriesValidOpeningShapes() {
        return seriesValidOpeningShapes;
    }

    /**
     * Return a Series Valid Openings Map
     *
     * @return Map
     */
    public Map<Integer, SeriesValidOpeningShape> getSeriesValidOpeningMap() {
        return seriesValidOpeningMap;
    }

    /**
     * Return a Series Valid Shapes List
     *
     * @return List
     */
    public List<SeriesValidShapes> getSeriesValidShapes() {
        return seriesValidShapes;
    }

    /**
     * Return a Series Valid Shapes
     *
     * @param id, Identification Id
     * @return SeriesValidShapes
     */
    public SeriesValidShapes getSeriesValidShapes(int id) {
        return seriesValidShapesMap.get(id);
    }

    /**
     * Return a Series Valid Opening from Identification Id
     *
     * @param id, Opening Identification Id
     * @return SeriesValidOpeningShape
     */
    public SeriesValidOpeningShape getSeriesValidOpeningById(int id) {
        if (seriesValidOpeningMap.get(id) == null) {
            return ItemFrame.getApplicationRemoteBaseRules().getSeriesValidOpeningById(id);
        }

        return seriesValidOpeningMap.get(id);
    }

    /**
     * Series Valid Opening Shape Manufacturing
     *
     * @param openingId, Opening Identification Id
     * @param shapeId,   Shape Identification Id
     * @return
     */
    public SeriesValidOpeningShapeMfg getSeriesValidOpeningMfg(int openingId, int shapeId) {

        SeriesValidOpeningShapeMfg seriesValidOpeningShapeMfg = new SeriesValidOpeningShapeMfg();

        for (SeriesValidOpeningShapeMfg validOpeningShapeMfg : seriesValidOpeningShapesMfg) {
            if (validOpeningShapeMfg.getId().getOpeningId() == openingId &&
                    validOpeningShapeMfg.getId().getShapeId() == shapeId) {
                seriesValidOpeningShapeMfg = validOpeningShapeMfg;

                break;
            }
        }

        return seriesValidOpeningShapeMfg;
    }

    /**
     * Return a List of Type Coupler Mullions
     *
     * @return List
     */
    public List<TypeCouplerMullion> getTypeCouplerMullions() {
        return typeCouplerMullions;
    }

    /**
     * Return a Type Coupler Mullion
     *
     * @param id, Identification Id
     * @return TypeCouplerMullion
     */
    public TypeCouplerMullion getTypeCouplerMullion(int id) {
        return typeCouplerMullionMap.get(id);
    }

    /**
     * Return Parts collection
     *
     * @return List
     */
    public List<Parts> getParts() {
        return parts;
    }

    /**
     * Return Parts Families collection
     *
     * @return List
     */
    public List<PartsFamily> getPartsFamilies() {
        return partsFamilies;
    }

    /**
     * Return Parts Family by Identification Id
     *
     * @param id, Parts Family Identification Id
     * @return PartsFamily
     */
    public PartsFamily getPartsFamily(int id) {
        return partsFamiliesMap.get(id);
    }

    /**
     * Return Part Families by Family Identification & Series Identification Id
     *
     * @param partFamilyId, Part Family Identification Id
     * @param seriesId,     Series Identification Id
     * @return PartFamilySeries
     */
    public PartFamilySeries getPartFamilySeries(int partFamilyId, int seriesId) {

        PartFamilySeriesPK seriesPK = new PartFamilySeriesPK(partFamilyId, seriesId);

        for (Map.Entry<PartFamilySeriesPK, PartFamilySeries> entry : partFamilySeriesMap.entrySet()) {

            PartFamilySeriesPK key = entry.getKey();
            if (key.equals(seriesPK)) {
                return entry.getValue();
            }
        }

        return null;
    }

    /**
     * Return Parts Cost Prices collection
     *
     * @return List
     */
    public List<PartsCostPrice> getPartsCostPrices() {
        return partsCostPrices;
    }

    /**
     * Return Pricing Groups collection
     *
     * @return List
     */
    public List<PricingGroup> getPricingGroups() {
        return pricingGroups;
    }

    /**
     * Return Series Allowed SU Thicks collection
     *
     * @return List
     */
    public List<SeriesAllowedSUThick> getSeriesAllowedSUThicks() {
        return seriesAllowedSUThicks;
    }

    /**
     * Return a List of SU Types
     *
     * @param uom, Unit of Metric
     * @return List
     */
    public List<SUType> getSuTypes(int uom) {

        List<SUType> selectSUTypes = new ArrayList<SUType>();
        for (SeriesAllowedSUThick thickness : seriesAllowedSUThicks) {
            for (SUType suType : suTypes) {

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

        //Sort collection by sort sequence
        Collections.sort(selectSUTypes, SUTypeObjectOrder.SORT_SEQ);

        return selectSUTypes;
    }

    /**
     * Return SUType Object
     *
     * @param id, SUType Identification Id
     * @return SUType
     */
    public SUType getSUType(int id) {
        if (suTypesMap.size() == 0) {

            for (SUType suType : suTypes) {
                suTypesMap.put(suType.getId(), suType);
            }


        }
        return suTypesMap.get(id);
    }

    /**
     * Return SU Family Collection
     *
     * @return List
     */
    public List<SUFamily> getSuFamilies() {
        return suFamilies;
    }

    /**
     * Return SU Family Object
     *
     * @param id, Identification Id
     * @return SUFamily
     */
    public SUFamily getSuFamily(int id) {
        return suFamilyMap.get(id);
    }

    /**
     * Return Type Glazing Collection
     *
     * @return List
     */
    public List<TypeGlazing> getTypeGlazings() {
        return typeGlazings;
    }

    /**
     * Return Type Glazing Object
     *
     * @param id, Type Glazing Identification Id
     * @return TypeGlazing
     */
    public TypeGlazing getTypeGlazing(int id) {
        return typeGlazingMap.get(id);
    }

    /**
     * Return Grids Collection Object
     *
     * @return List1
     */
    public List<Grids> getGrids() {
        return grids;
    }

    /**
     * Return Grids Object by Identification Id
     *
     * @param id, Grids Identification Id
     * @return Grids
     */
    public Grids getGrids(int id) {
        return gridsMap.get(id);
    }

    /**
     * Return Color Object by Identification Id
     *
     * @param id, Color Identification Id
     * @return Color
     */
    public Color getColor(int id) {
        return colorMap.get(id);
    }

    /**
     * Return Option Definitions Map
     *
     * @return Map
     */
    public Map<Integer, OptionDefinitions> getOptionDefinitionsMap() {
        return optionDefinitionsMap;
    }

    /**
     * Return Option Definitions
     *
     * @return List
     */
    public List<OptionDefinitions> getOptionDefinitions() {
        return optionDefinitions;
    }

    /**
     * Return Option Definition Object
     *
     * @param optionDefinitionId, Option Definition Identification Id
     * @return OptionDefinitions
     */
    public OptionDefinitions getOptionDefinitions(int optionDefinitionId) {
        return optionDefinitionsMap.get(optionDefinitionId);
    }

    /**
     * Return Option Answers List
     *
     * @param optionDefinitionId, Option Definition Identification Id
     * @return List
     */
    public List<OptionAnswers> getOptionAnswers(int optionDefinitionId) {
        return optionAnswersAllowedMap.get(optionDefinitionId);
    }

    /**
     * Return Option Answers Object
     *
     * @param optionAnswersId, Option Answers Identification Id
     * @return OptionAnswers
     */
    public OptionAnswers getOptionAnswersAll(int optionDefinitionId, int optionAnswersId) {
        List<OptionAnswers> answers = optionAnswersAllowedMap.get(optionDefinitionId);

        OptionAnswers optionAnswers = null;
        for (OptionAnswers optionAnswer : answers) {
            if (optionAnswer.getId().getId() == optionAnswersId) {
                optionAnswers = optionAnswer;
                break;
            }
        }

        return optionAnswers;
    }

    /**
     * Return Option Answers Object
     *
     * @param optionAnswersId, Option Answers Identification Id
     * @return OptionAnswers
     */
    public OptionAnswers getOptionAnswers(int optionDefinitionId, int optionAnswersId) {
        List<OptionAnswers> answers = optionAnswersAllowedMap.get(optionDefinitionId);

        OptionAnswers optionAnswers = null;
        for (OptionAnswers optionAnswer : answers) {
            if (optionAnswer.getId().getId() == optionAnswersId) {
                optionAnswers = optionAnswer;
                break;
            }
        }

        return optionAnswers;
    }

}

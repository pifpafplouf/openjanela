package org.openjanela.data;

import openjanela.model.eao.admin.companyPreferencesEAO.CompanyPreferencesEAO;
import openjanela.model.eao.admin.companyPreferencesEAO.CompanyPreferencesPersistenceEAO;
import openjanela.model.eao.admin.priceChangeReasonEAO.PriceChangeReasonEAO;
import openjanela.model.eao.admin.priceChangeReasonEAO.PriceChangeReasonPersistenceEAO;
import openjanela.model.eao.admin.systemUOMEAO.SystemUOMEAO;
import openjanela.model.eao.admin.systemUOMEAO.SystemUOMPersistenceEAO;
import openjanela.model.eao.admin.typeEndTypeEAO.TypeEndTypeEAO;
import openjanela.model.eao.admin.typeEndTypeEAO.TypeEndTypePersistenceEAO;
import openjanela.model.eao.admin.typeGlazingEAO.TypeGlazingEAO;
import openjanela.model.eao.admin.typeGlazingEAO.TypeGlazingPersistenceEAO;
import openjanela.model.eao.admin.typeLevelEAO.TypeLevelEAO;
import openjanela.model.eao.admin.typeLevelEAO.TypeLevelPersistenceEAO;
import openjanela.model.eao.admin.typeOpeningEAO.TypeOpeningEAO;
import openjanela.model.eao.admin.typeOpeningEAO.TypeOpeningPersistenceEAO;
import openjanela.model.eao.admin.typePriceCategoryEAO.TypePriceCategoryEAO;
import openjanela.model.eao.admin.typePriceCategoryEAO.TypePriceCategoryPersistenceEAO;
import openjanela.model.eao.admin.typeShapeEAO.TypeShapeEAO;
import openjanela.model.eao.admin.typeShapeEAO.TypeShapePersistenceEAO;
import openjanela.model.eao.admin.typeWildCardEAO.TypeWildCardEAO;
import openjanela.model.eao.admin.typeWildCardEAO.TypeWildCardPersistenceEAO;
import openjanela.model.eao.admin.userAdminEAO.UserAdminEAO;
import openjanela.model.eao.admin.userAdminEAO.UserAdminPersistenceEAO;
import openjanela.model.eao.admin.userGroupEAO.UserGroupEAO;
import openjanela.model.eao.admin.userGroupEAO.UserGroupPersistenceEAO;
import openjanela.model.eao.admin.mathOperatorEAO.*;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.orderEntry.OrderStatusEAO.OrderStatusEAO;
import openjanela.model.eao.orderEntry.OrderStatusEAO.OrderStatusPersistenceEAO;
import openjanela.model.eao.orderEntry.costingGroupEAO.CostingGroupEAO;
import openjanela.model.eao.orderEntry.costingGroupEAO.CostingGroupPersistenceEAO;
import openjanela.model.eao.partner.PartnerHolidaysEAO.PartnerHolidaysEAO;
import openjanela.model.eao.partner.PartnerHolidaysEAO.PartnerHolidaysPersistenceEAO;
import openjanela.model.eao.partner.attributeTypeEAO.AttributeTypeEAO;
import openjanela.model.eao.partner.attributeTypeEAO.AttributeTypePersistenceEAO;
import openjanela.model.eao.partner.partFamilySeriesEAO.PartFamilySeriesEAO;
import openjanela.model.eao.partner.partFamilySeriesEAO.PartFamilySeriesPersistenceEAO;
import openjanela.model.eao.partner.partnerEAO.PartnerDefaultEAO;
import openjanela.model.eao.partner.partnerEAO.PartnerDefaultPersistenceEAO;
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
import openjanela.model.eao.partner.suFamilyEAO.SUFamilyEAO;
import openjanela.model.eao.partner.suFamilyEAO.SUFamilyPersistenceEAO;
import openjanela.model.entities.admin.*;
import openjanela.model.entities.design.OpeningClassTypes;
import openjanela.model.entities.orderEntry.CostingGroup;
import openjanela.model.entities.orderEntry.OrderStatus;
import openjanela.model.entities.orderEntry.PricingGroup;
import openjanela.model.entities.partner.*;
import openjanela.model.entities.parts.*;

import org.apache.log4j.Logger;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 03-24-13
 *          Time: 03:23 PM
 */
public class ApplicationBaseApp {

    //Apache Log4j
    private static final Logger logger = Logger.getLogger(ApplicationBaseApp.class);

    //Application Base
    private static ApplicationBaseApp instance;

    //Series Identification value
    private int _company = -1;
    private int _series = -1;
    private int _partner = -1;
    private int _partner_group = -1;

    //********************************************************
    //Load Preferencies Values
    //********************************************************
    private CompanyPreferences companyPreferences;

    private List<Country> countries = new ArrayList<Country>();
    private List<CountryStates> states = new ArrayList<CountryStates>();
    private List<CountryHolidays> countryHolidays = new ArrayList<CountryHolidays>();
    private List<TypeOpening> typeOpenings = new ArrayList<TypeOpening>();
    private List<TypeLevel> typeLevels = new ArrayList<TypeLevel>();
    private List<PriceChangeReason> changeReasons = new ArrayList<PriceChangeReason>();
    private List<PartnerHolidays> partnerHolidays = new ArrayList<PartnerHolidays>();
    private List<TypeShape> typeShapes = new ArrayList<TypeShape>();
    private List<TypeEndType> typeEndTypes = new ArrayList<TypeEndType>();
    private List<TypePriceCategory> typePriceCategories = new ArrayList<TypePriceCategory>();
    private List<CostingGroup> costingGroups = new ArrayList<CostingGroup>();
    private List<MathOperator> mathOperators = new ArrayList<MathOperator>();
    private List<OrderStatus> orderStatus = new ArrayList<OrderStatus>();
    private List<Parts> parts = new ArrayList<Parts>();
    private List<Parts> originalParts = new ArrayList<Parts>();
    private List<PartsLabelPos> partsLabelPos = new ArrayList<PartsLabelPos>();
    private List<PartsFamily> partsFamilies = new ArrayList<PartsFamily>();
    private List<PartFamilySeries> partFamilySeries = new ArrayList<PartFamilySeries>();
    private List<PartFamilyStation> partFamilyStations = new ArrayList<PartFamilyStation>();
    private List<TypeAttribute> attributeTypes = new ArrayList<TypeAttribute>();
    private List<TypeWildCard> wildTypes = new ArrayList<TypeWildCard>();
    private List<PartsCostPrice> partsCostPrices = new ArrayList<PartsCostPrice>();
    private List<PricingGroup> pricingGroups = new ArrayList<PricingGroup>();
    private List<SystemUOM> systemUOMs = new ArrayList<SystemUOM>();
    private List<UserAdmin> userAdmins = new ArrayList<UserAdmin>();
    private List<UserGroup> userGroups = new ArrayList<UserGroup>();

    private List<PartnerDefault> partnerDefaults;
    private List<PartnerLineDiscount> partnerLineDiscounts;
    private List<PartnerGroupLineDiscount> partnerGroupLineDiscounts;

    private Map<String, Country> countriesMap = new HashMap<String, Country>();
    private Map<Integer, CountryStates> statesMap = new HashMap<Integer, CountryStates>();
    private Map<CountryHolidaysPK, CountryHolidays> countryHolidaysMap = new HashMap<CountryHolidaysPK, CountryHolidays>();
    private Map<String, List<CountryStates>> countryStatesMap = new HashMap<String, List<CountryStates>>();
    private Map<Integer, TypeCouplerMullion> typeCouplerMullionMap = new HashMap<Integer, TypeCouplerMullion>();
    private Map<Integer, TypeOpening> typeOpeningMap = new HashMap<Integer, TypeOpening>();
    private Map<Integer, TypeLevel> typeLevelMap = new HashMap<Integer, TypeLevel>();
    private Map<Integer, OrderStatus> orderStatusMap = new HashMap<Integer, OrderStatus>();
    private Map<Integer, PriceChangeReason> changeReasonMap = new HashMap<Integer, PriceChangeReason>();
    private Map<PartnerHolidaysPK, PartnerHolidays> partnerHolidaysMap = new HashMap<PartnerHolidaysPK, PartnerHolidays>();
    private Map<Integer, TypeShape> typeShapeMap = new HashMap<Integer, TypeShape>();
    private Map<Integer, TypeEndType> typeEndTypeMap = new HashMap<Integer, TypeEndType>();
    private Map<Integer, TypePriceCategory> typePriceCategoryMap = new HashMap<Integer, TypePriceCategory>();
    private Map<Integer, CostingGroup> costingGroupMap = new HashMap<Integer, CostingGroup>();
    private Map<Integer, MathOperator> mathEvalMap = new HashMap<Integer, MathOperator>();
    private Map<Integer, Parts> partsMap = new HashMap<Integer, Parts>();
    private Map<Integer, Parts> originalPartsMap = new HashMap<Integer, Parts>();
    private Map<Integer, PartsLabelPos> partsLabelPosMap = new HashMap<Integer, PartsLabelPos>();
    private Map<Integer, PartsFamily> partsFamiliesMap = new HashMap<Integer, PartsFamily>();
    private Map<PartFamilySeriesPK, PartFamilySeries> partFamilySeriesMap = new HashMap<PartFamilySeriesPK, PartFamilySeries>();
    private Map<Integer, PartFamilyStation> partFamilyStationMap = new HashMap<Integer, PartFamilyStation>();

    private Map<Integer, TypeAttribute> attributeTypeMap = new HashMap<Integer, TypeAttribute>();
    private Map<Integer, TypeWildCard> wildTypeMap = new HashMap<Integer, TypeWildCard>();
    private Map<Integer, PartsCostPrice> partsCostPriceMap = new HashMap<Integer, PartsCostPrice>();
    private Map<Integer, PricingGroup> pricingGroupsMap = new HashMap<Integer, PricingGroup>();
    private Map<PartnerDefaultPK, PartnerDefault> partnerDefaultsMap = new HashMap<PartnerDefaultPK, PartnerDefault>();
    private Map<PartnerLineDiscountPK, PartnerLineDiscount> partnerLineDiscountsMap = new HashMap<PartnerLineDiscountPK, PartnerLineDiscount>();
    private Map<PartnerGroupLineDiscountPK, PartnerGroupLineDiscount> partnerGroupLineDiscountsMap = new HashMap<PartnerGroupLineDiscountPK, PartnerGroupLineDiscount>();
    private Map<Integer, SystemUOM> systemUOMMap = new HashMap<Integer, SystemUOM>();
    private Map<Integer, UserAdmin> userAdminMap = new HashMap<Integer, UserAdmin>();
    private Map<Integer, UserGroup> userGroupMap = new HashMap<Integer, UserGroup>();

    //Entity Access Objects
    protected CompanyPreferencesEAO companyPrefEAO;
    protected TypeLevelEAO typeLevelEAO;
    protected TypeShapeEAO typeShapeEAO;
    protected TypeEndTypeEAO typeEndTypeEAO;
    protected TypePriceCategoryEAO typePriceCategoryEAO;
    protected TypeGlazingEAO typeGlazingEAO;
    protected CostingGroupEAO costingGroupEAO;
    protected OrderStatusEAO orderStatusEAO;
    protected PartsEAO partsEAO;
    protected PartsFamilyEAO partsFamilyEAO;
    protected PartFamilySeriesEAO partFamilySeriesEAO;
    protected PartsFamilyStationEAO partFamilyStationEAO;
    protected AttributeTypeEAO attributeTypeEAO;
    protected TypeWildCardEAO typeWildCardEAO;
    protected MathOperatorEAO mathOperatorEAO;
    protected PartsCostPriceEAO partsCostPriceEAO;
    protected PartsLabelPosEAO partsLabelPosEAO;
    protected PricingGroupEAO pricingGroupEAO;
    protected PartnerDefaultEAO partnerDefaultEAO;
    protected PartnerLineDiscountEAO partnerLineDiscountEAO;
    protected PartnerGroupLineDiscountEAO partnerGroupLineDiscountEAO;
    protected PartnerHolidaysEAO partnerHolidaysEAO;
    protected SystemUOMEAO systemUOMEAO;
    protected SUFamilyEAO suFamilyEAO;
    protected TypeOpeningEAO typeOpeningEAO;
    protected PriceChangeReasonEAO priceChangeReasonEAO;
    protected UserAdminEAO userAdminEAO;
    protected UserGroupEAO userGroupEAO;

    ExecutorService executorService = Executors.newFixedThreadPool(20);

    /**
     * Application Base Constructor
     */
    public ApplicationBaseApp() {

        //Init Entity Access Objects
        companyPrefEAO = new CompanyPreferencesPersistenceEAO();
        typeLevelEAO = new TypeLevelPersistenceEAO();
        typeShapeEAO = new TypeShapePersistenceEAO();
        typeEndTypeEAO = new TypeEndTypePersistenceEAO();
        typePriceCategoryEAO = new TypePriceCategoryPersistenceEAO();
        typeGlazingEAO = new TypeGlazingPersistenceEAO();
        costingGroupEAO = new CostingGroupPersistenceEAO();
        mathOperatorEAO = new MathOperatorPersistencenEAO();
        orderStatusEAO = new OrderStatusPersistenceEAO();
        partsEAO = new PartsPersistenceEAO();
        partsFamilyEAO = new PartsFamilyPersistenceEAO();
        partFamilySeriesEAO = new PartFamilySeriesPersistenceEAO();
        partFamilyStationEAO = new PartsFamilyStationPersistenceEAO();
        partsLabelPosEAO = new PartsLabelPosPersistenceEAO();
        attributeTypeEAO = new AttributeTypePersistenceEAO();
        partsCostPriceEAO = new PartsCostPricePersistenceEAO();
        pricingGroupEAO = new PricingGroupPersistenceEAO();
        partnerDefaultEAO = new PartnerDefaultPersistenceEAO();
        partnerLineDiscountEAO = new PartnerLineDiscountPersistenceEAO();
        partnerGroupLineDiscountEAO = new PartnerGroupLineDiscountPersistenceEAO();
        partnerHolidaysEAO = new PartnerHolidaysPersistenceEAO();
        systemUOMEAO = new SystemUOMPersistenceEAO();
        suFamilyEAO = new SUFamilyPersistenceEAO();
        typeWildCardEAO = new TypeWildCardPersistenceEAO();
        typeOpeningEAO = new TypeOpeningPersistenceEAO();
        priceChangeReasonEAO = new PriceChangeReasonPersistenceEAO();
        userAdminEAO = new UserAdminPersistenceEAO();
        userGroupEAO = new UserGroupPersistenceEAO();
    }

    /**
     * Init Application Base
     *
     * @param series,       Series Identification
     * @param partner,      Partner Identification
     * @param partnerGroup, Partner Group Identification
     */
    private void initApplicationBase(int series, int partner, int partnerGroup) {

        if (logger.isDebugEnabled()) {
            logger.debug("Init application base...");
        }

        final int param_series = series;
        final int param_partner = partner;
        final int param_partner_group = partnerGroup;

        executorService.execute(new Runnable() {
            public void run() {
                initCompanyPreferences();
            }
        });

        executorService.execute(new Runnable() {
            public void run() {
                initTypeOpenings();
            }
        });

        executorService.execute(new Runnable() {
            public void run() {
                initWildTypes();
            }
        });

        executorService.execute(new Runnable() {
            public void run() {
                initChildReasons();
            }
        });

        executorService.execute(new Runnable() {
            public void run() {
                initTypeLevels();
            }
        });

        executorService.execute(new Runnable() {
            public void run() {
                initTypeShapes();
            }
        });

        executorService.execute(new Runnable() {
            public void run() {
                initTypeEndTypes();
            }
        });

        executorService.execute(new Runnable() {
            public void run() {
                initTypeCategories();
            }
        });

        executorService.execute(new Runnable() {
            public void run() {
                initCostingGroups();
            }
        });

        executorService.execute(new Runnable() {
            public void run() {
                initMathOperators();
            }
        });

        executorService.execute(new Runnable() {
            public void run() {
                initPartsLabelPos();
            }
        });

        executorService.execute(new Runnable() {
            public void run() {
                initAttributeTypes();
            }
        });

        executorService.execute(new Runnable() {
            public void run() {
                initParts();
            }
        });

        executorService.execute(new Runnable() {
            public void run() {
                initPartnerDefaults(param_partner, param_partner_group);
            }
        });

        executorService.execute(new Runnable() {
            public void run() {
                initSystemUOMs();
            }
        });

        executorService.execute(new Runnable() {
            public void run() {
                initUserAdmin();
            }
        });

        executorService.execute(new Runnable() {
            public void run() {
                initUserGroups();
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                initOrderStatus();
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                initHolidays();
            }
        });

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //Update information series | partner | partner group
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
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
                        updateValues(param_series, param_partner, param_partner_group);
                    }
                }).start();
            }
        };

        timer.schedule(delayedThreadStartTask, 1000);


    }

    /**
     * Update Values
     *
     * @param series,       Series Identification
     * @param partner,      Partner Identification
     * @param partnerGroup, Partner Group Identification
     */
    private void updateValues(int series, int partner, int partnerGroup) {
        this._series = series;
        this._partner = partner;
        this._partner_group = partnerGroup;
    }

    /**
     * Init Company Preferences
     */
    private void initCompanyPreferences() {

        //*********************************************************************
        // Init Company Preferencies
        //*********************************************************************
        if (companyPreferences == null) {
            try {
                companyPreferences = companyPrefEAO.getPref();
            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application not start: " + e.getMessage(), e);
            }
        }
    }

    /**
     * Init Type Openings
     */
    private void initTypeOpenings() {

        //*********************************************************************
        // Init Type Openings
        //*********************************************************************
        if (typeOpenings.size() <= 0 || typeOpeningMap.size() <= 0) {
            try {

                typeOpenings = new ArrayList<TypeOpening>();
                typeOpeningMap = new HashMap<Integer, TypeOpening>();

                typeOpenings = typeOpeningEAO.findAllOpenings();

                for (TypeOpening typeOpening : typeOpenings) {
                    typeOpeningMap.put(typeOpening.getId(), typeOpening);
                }

            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application not start: " + e.getMessage(), e);
            }
        }

    }

    /**
     * Init Wild Types
     */
    private void initWildTypes() {

        //*********************************************************************
        // Init Type WildCards
        //*********************************************************************
        if (wildTypes.size() <= 0 || wildTypeMap.size() <= 0) {

            try {

                wildTypes = new ArrayList<TypeWildCard>();
                wildTypeMap = new HashMap<Integer, TypeWildCard>();

                wildTypes = typeWildCardEAO.findAll();

                for (TypeWildCard wildCard : wildTypes) {
                    wildTypeMap.put(wildCard.getId(), wildCard);
                }

            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application not start: " + e.getMessage(), e);
            }
        }
    }

    /**
     * Init Child Reasons
     */
    private void initChildReasons() {

        //*********************************************************************
        // Init Price Change reasons
        //*********************************************************************
        if (this.changeReasons.size() <= 0 || changeReasonMap.size() <= 0) {
            try {

                changeReasons = new ArrayList<PriceChangeReason>();
                changeReasonMap = new HashMap<Integer, PriceChangeReason>();

                changeReasons = priceChangeReasonEAO.findAll();

                for (PriceChangeReason change : changeReasons) {
                    changeReasonMap.put(change.getId(), change);
                }
            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application not start: " + e.getMessage(), e);
            }
        }
    }

    /**
     * Init Type Levels
     */
    private void initTypeLevels() {

        //*********************************************************************
        //Init type levels
        //*********************************************************************
        if (typeLevels.size() <= 0 || typeLevelMap.size() <= 0) {
            try {

                typeLevels = new ArrayList<TypeLevel>();
                typeLevelMap = new HashMap<Integer, TypeLevel>();

                typeLevels = typeLevelEAO.getAllLevels();

                for (TypeLevel level : typeLevels) {
                    typeLevelMap.put(level.getTypeLevelPK().getLevelId(), level);
                }

                for (TypeLevel level : typeLevels) {
                    typeLevelMap.put(level.getTypeLevelPK().getId(), level);
                }

            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application not start: " + e.getMessage(), e);
            }
        }

    }

    /**
     * Init Type Shapes
     */
    private void initTypeShapes() {

        //*********************************************************************
        //Init type shapes
        //*********************************************************************
        if (typeShapes.size() <= 0 || typeShapeMap.size() <= 0) {
            try {

                typeShapes = new ArrayList<TypeShape>();
                typeShapeMap = new HashMap<Integer, TypeShape>();

                typeShapes = typeShapeEAO.findReadOnly();

                for (TypeShape shape : typeShapes) {
                    typeShapeMap.put(shape.getId(), shape);
                }
            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application not start: " + e.getMessage(), e);
            }
        }
    }

    /**
     * Init Type End Types
     */
    private void initTypeEndTypes() {

        //*********************************************************************
        //Init End Types
        //*********************************************************************
        if (typeEndTypes.size() <= 0 || typeEndTypeMap.size() <= 0) {
            try {

                typeEndTypes = new ArrayList<TypeEndType>();
                this.typeEndTypeMap = new HashMap<Integer, TypeEndType>();

                typeEndTypes = typeEndTypeEAO.findAll();

                for (TypeEndType endtype : typeEndTypes) {
                    typeEndTypeMap.put(endtype.getId(), endtype);
                }

            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application not start: " + e.getMessage(), e);
            }
        }
    }

    /**
     * Init Type Categories
     */
    private void initTypeCategories() {

        //*********************************************************************
        //Init Type Price Categories
        //*********************************************************************
        if (typePriceCategories.size() <= 0 || typePriceCategoryMap.size() <= 0) {
            try {

                typePriceCategories = new ArrayList<TypePriceCategory>();
                typePriceCategoryMap = new HashMap<Integer, TypePriceCategory>();

                typePriceCategories = typePriceCategoryEAO.findTypePriceCategory();

                for (TypePriceCategory typePrice : typePriceCategories) {
                    typePriceCategoryMap.put(typePrice.getId(), typePrice);
                }

            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application not start: " + e.getMessage(), e);
            }
        }
    }

    /**
     * Init Costing Groups
     */
    private void initCostingGroups() {

        //*********************************************************************
        //Init Costing Group Options
        //*********************************************************************
        if (costingGroups.size() <= 0) {
            try {

                costingGroups = new ArrayList<CostingGroup>();
                costingGroupMap = new HashMap<Integer, CostingGroup>();

                costingGroups = costingGroupEAO.findAll();

                for (CostingGroup costingGroup : costingGroups) {
                    costingGroupMap.put(costingGroup.getId(), costingGroup);
                }

            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application not start: " + e.getMessage(), e);
            }
        }
    }

    /**
     * Init Math Operators
     */
    private void initMathOperators() {

        //*********************************************************************
        // Init Math Eval
        //*********************************************************************
        if (mathOperators.size() <= 0 || mathEvalMap.size() <= 0) {

            try {
                mathOperators = new ArrayList<MathOperator>();
                mathEvalMap = new HashMap<Integer, MathOperator>();

                mathOperators = mathOperatorEAO.findAll();

                for (MathOperator mathOperator : mathOperators) {
                    mathEvalMap.put(mathOperator.getId(), mathOperator);
                }

            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application not start: " + e.getMessage(), e);
            }
        }
    }

    /**
     * Init Parts Label Position
     */
    private void initPartsLabelPos() {

        //*********************************************************************
        // Parts Label Position
        //*********************************************************************
        if (partsLabelPos.size() <= 0 || partsLabelPosMap.size() <= 0) {

            try {
                partsLabelPos = new ArrayList<PartsLabelPos>();
                partsLabelPosMap = new HashMap<Integer, PartsLabelPos>();

                partsLabelPos = partsLabelPosEAO.findAll();

                for (PartsLabelPos partsLabel : partsLabelPos) {
                    partsLabelPosMap.put(partsLabel.getId(), partsLabel);
                }

            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application not start: " + e.getMessage(), e);
            }
        }
    }

    /**
     * Init Attribute Types
     */
    private void initAttributeTypes() {

        //*********************************************************************
        //Init Parts Options
        //*********************************************************************
        if (attributeTypes.size() <= 0) {
            try {

                attributeTypes = new ArrayList<TypeAttribute>();
                attributeTypeMap = new HashMap<Integer, TypeAttribute>();

                attributeTypes = this.attributeTypeEAO.findAll();

                for (TypeAttribute attribute : attributeTypes) {
                    attributeTypeMap.put(attribute.getId(), attribute);
                }

            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application not start: " + e.getMessage(), e);
            }
        }
    }

    /**
     * Init Parts
     */
    private void initParts() {

        if (parts.size() <= 0 || partsFamilies.size() <= 0 || partFamilySeries.size() <= 0 || partsCostPrices.size() <= 0 ||
                pricingGroups.size() <= 0 || partFamilyStations.size() <= 0 || partsMap.size() <= 0 ||
                originalPartsMap.size() <= 0 || partsFamiliesMap.size() <= 0 ||
                partFamilySeriesMap.size() <= 0 || partsCostPriceMap.size() <= 0 || pricingGroupsMap.size() <= 0) {

            try {

                parts = new ArrayList<Parts>();
                partsFamilies = new ArrayList<PartsFamily>();
                partFamilySeries = new ArrayList<PartFamilySeries>();
                partFamilyStations = new ArrayList<PartFamilyStation>();

                partsCostPrices = new ArrayList<PartsCostPrice>();
                pricingGroups = new ArrayList<PricingGroup>();

                partsMap = new HashMap<Integer, Parts>();
                originalPartsMap = new HashMap<Integer, Parts>();
                partsFamiliesMap = new HashMap<Integer, PartsFamily>();
                partFamilySeriesMap = new HashMap<PartFamilySeriesPK, PartFamilySeries>();
                partsCostPriceMap = new HashMap<Integer, PartsCostPrice>();
                pricingGroupsMap = new HashMap<Integer, PricingGroup>();
                partFamilyStationMap = new HashMap<Integer, PartFamilyStation>();

                parts = partsEAO.findAllReadOnly();
                originalParts = partsEAO.findAllReadOnly();
                partsFamilies = partsFamilyEAO.findAll();
                partFamilySeries = partFamilySeriesEAO.findAll();
                partFamilyStations = partFamilyStationEAO.findAll();
                partsCostPrices = partsCostPriceEAO.findAll();
                pricingGroups = pricingGroupEAO.findAll();

                for (Parts partsValue : parts) {
                    partsMap.put(partsValue.getId(), partsValue);

                }

                for (Parts partsValue : originalParts) {
                    originalPartsMap.put(partsValue.getId(), partsValue);
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

    /**
     * Init Partner Defaults
     *
     * @param partner,      Partner Identification
     * @param partnerGroup, Partner Group Identification
     */
    private void initPartnerDefaults(int partner, int partnerGroup) {

        //*********************************************************************
        //Init Partner Defaults
        //*********************************************************************
        if (this._partner != partner || this._partner_group != partnerGroup) {

            try {

                partnerDefaults = new ArrayList<PartnerDefault>();
                partnerLineDiscounts = new ArrayList<PartnerLineDiscount>();
                partnerGroupLineDiscounts = new ArrayList<PartnerGroupLineDiscount>();

                partnerDefaultsMap = new HashMap<PartnerDefaultPK, PartnerDefault>();
                partnerLineDiscountsMap = new HashMap<PartnerLineDiscountPK, PartnerLineDiscount>();
                partnerGroupLineDiscountsMap = new HashMap<PartnerGroupLineDiscountPK, PartnerGroupLineDiscount>();

                partnerDefaults = partnerDefaultEAO.findDefaults(partner);
                partnerLineDiscounts = partnerLineDiscountEAO.findByPartnerId(partner);
                partnerGroupLineDiscounts = partnerGroupLineDiscountEAO.findByGroupId(partnerGroup);

                for (PartnerDefault partnerDefault : partnerDefaults) {
                    partnerDefaultsMap.put(partnerDefault.getPartnerDefaultPK(), partnerDefault);
                }

                for (PartnerLineDiscount partnerLineDiscount : partnerLineDiscounts) {
                    partnerLineDiscountsMap.put(partnerLineDiscount.getId(), partnerLineDiscount);
                }

                for (PartnerGroupLineDiscount partnerGroupLineDiscount : partnerGroupLineDiscounts) {
                    partnerGroupLineDiscountsMap.put(partnerGroupLineDiscount.getId(), partnerGroupLineDiscount);
                }

            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application not start: " + e.getMessage(), e);
            }
        }
    }

    /**
     * Init System UOMs
     */
    private void initSystemUOMs() {

        //*********************************************************************
        //Init System UOM
        //*********************************************************************
        if (systemUOMs.size() <= 0 || systemUOMMap.size() <= 0) {

            try {

                systemUOMs = new ArrayList<SystemUOM>();
                systemUOMMap = new HashMap<Integer, SystemUOM>();

                systemUOMs = systemUOMEAO.findAll();

                for (SystemUOM systemUOM : systemUOMs) {
                    systemUOMMap.put(systemUOM.getId(), systemUOM);
                }

            } catch (GenericPersistenceEAOException e) {
                logger.error(e.getMessage(), e);
                throw new RuntimeException("Service application not start: " + e.getMessage(), e);
            }
        }
    }

    /**
     * Init User Admin
     */
    private void initUserAdmin() {

        //*********************************************************************
        //Init User List
        //*********************************************************************
        try {

            this.userAdmins = new ArrayList<UserAdmin>();
            this.userAdminMap = new HashMap<Integer, UserAdmin>();

            this.userAdmins = userAdminEAO.findByPartner(false, -1);

            for (UserAdmin userAdmin : this.userAdmins) {
                this.userAdminMap.put(userAdmin.getId(), userAdmin);
            }

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("Service application not start: " + e.getMessage(), e);
        }
    }

    /**
     * Init User Groups
     */
    private void initUserGroups() {

        //*********************************************************************
        //Init User Group List
        //*********************************************************************
        try {

            this.userGroups = new ArrayList<UserGroup>();
            this.userGroupMap = new HashMap<Integer, UserGroup>();

            this.userGroups = userGroupEAO.findAll();

            for (UserGroup userGroup : this.userGroups) {
                this.userGroupMap.put(userGroup.getId(), userGroup);
            }

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("Service application not start: " + e.getMessage(), e);
        }
    }

    /**
     * Init Order Status
     */
    private void initOrderStatus() {

        //*********************************************************************
        //Init User Group List
        //*********************************************************************
        try {

            this.orderStatus = new ArrayList<OrderStatus>();
            this.orderStatusMap = new HashMap<Integer, OrderStatus>();

            this.orderStatus = orderStatusEAO.findAll();

            for (OrderStatus orderStatus : this.orderStatus) {
                this.orderStatusMap.put(orderStatus.getId(), orderStatus);
            }

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("Service application not start: " + e.getMessage(), e);
        }
    }

    /**
     * Init Holidays
     */
    private void initHolidays() {

        //*********************************************************************
        //Init User Group List
        //*********************************************************************
        try {

            this.countryHolidays = new ArrayList<CountryHolidays>();
            this.countryHolidaysMap = new HashMap<CountryHolidaysPK, CountryHolidays>();

            this.partnerHolidays = new ArrayList<PartnerHolidays>();
            this.partnerHolidaysMap = new HashMap<PartnerHolidaysPK, PartnerHolidays>();

            this.partnerHolidays = partnerHolidaysEAO.findAll();

            for (CountryHolidays ch : this.countryHolidays) {
                this.countryHolidaysMap.put(ch.getCountryHolidaysPK(), ch);
            }

            for (PartnerHolidays ph : this.partnerHolidays) {
                this.partnerHolidaysMap.put(ph.getPartnerHolidaysPK(), ph);
            }

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("Service application not start: " + e.getMessage(), e);
        }
    }

    /**
     * Obtain an Application Base
     *
     * @return ApplicationBaseApp
     */
    public static ApplicationBaseApp getInstance() {
        if (instance == null) {
            instance = new ApplicationBaseApp();

            instance.initApplicationBase(-1, -1, -1);
        }

        return instance;
    }

    /**
     * Obtain an Application Base
     *
     * @param series,       Series Identification
     * @param partner,      Partner Identification
     * @param partnerGroup, Partner Group Identification
     * @return ApplicationBaseApp
     */
    public static ApplicationBaseApp getInstance(int series, int partner, int partnerGroup) {
        if (instance == null) {
            instance = new ApplicationBaseApp();
        }

        //Init Application Base
        instance.initApplicationBase(series, partner, partnerGroup);

        return instance;
    }

    //**********************************************<GETTERS & SETTERS>************************************************

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
     * Return a List of Type Levels
     *
     * @return List
     */
    public List<TypeLevel> getTypeLevels() {
        return typeLevels;
    }

    /**
     * Return a List of Type Levels Map
     *
     * @return Map
     */
    public Map<Integer, TypeLevel> getTypeLevelMap() {
        return typeLevelMap;
    }

    /**
     * Return a Type Level Object from value identification
     *
     * @param typeLevelId, Type Level Identification Id
     * @return TypeLevel
     */
    public TypeLevel getTypeLevel(int typeLevelId) {
        return typeLevelMap.get(typeLevelId);
    }

    /**
     * Return a List of Type Shapes
     *
     * @return List
     */
    public List<TypeShape> getTypeShapes() {
        return typeShapes;
    }

    /**
     * Return a List of End Types
     *
     * @return List
     */
    public List<TypeEndType> getTypeEndTypes() {
        return typeEndTypes;
    }


    /**
     * Return a List of Type Shapes Map
     *
     * @return Map
     */
    public Map<Integer, TypeShape> getTypeShapeMap() {
        return typeShapeMap;
    }

    /**
     * Return a Type Shape Object from value identification
     *
     * @param typeShapeId, Type Shape Identification Id
     * @return TypeShape
     */
    public TypeShape getTypeShape(int typeShapeId) {
        return typeShapeMap.get(typeShapeId);
    }

    /**
     * Return a List of Type Price Categories
     *
     * @return List
     */
    public List<TypePriceCategory> getTypePriceCategories() {
        return typePriceCategories;
    }

    /**
     * Return a List of Type Price Category Map
     *
     * @return Map
     */
    public Map<Integer, TypePriceCategory> getTypePriceCategoryMap() {
        return typePriceCategoryMap;
    }

    /**
     * Return a Type Price Category
     *
     * @param typePriceCategoryId, Type Price Category Identification
     * @return TypePriceCategory
     */
    public TypePriceCategory getTypePriceCategory(int typePriceCategoryId) {
        return typePriceCategoryMap.get(typePriceCategoryId);
    }

    /**
     * Return Costing Group collection
     *
     * @return List
     */
    public List<CostingGroup> getCostingGroups() {
        return costingGroups;
    }

    /**
     * Return Math Eval collection
     *
     * @return List
     */
    public List<MathOperator> getMathOperators() {
        return mathOperators;
    }

    /**
     * Return Math Eval with identification
     *
     * @param id, Identification Id
     * @return MathOperator
     */
    public MathOperator getMathEval(int id) {
        return mathEvalMap.get(id);
    }

    /**
     * Return Parts Label collection
     *
     * @return List
     */
    public List<PartsLabelPos> getPartsLabelPos() {
        return partsLabelPos;
    }

    /**
     * Return Parts Label Position identification
     *
     * @param id, Identification Id
     * @return PartsLabelPos
     */
    public PartsLabelPos getPartsLabelPos(int id) {
        return partsLabelPosMap.get(id);
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
     * Return Price Change Reason
     *
     * @return List
     */
    public List<PriceChangeReason> getChangeReasons() {
        return this.changeReasons;
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
     * Return Partner Defaults collection
     *
     * @return List
     */
    public List<PartnerDefault> getPartnerDefaults() {
        return partnerDefaults;
    }

    /**
     * Return Partner Default by Default type and Option
     *
     * @param defaultTypeId, Default Type Identification Id
     * @param optionId,      Option Identification Id
     * @return PartnerDefault
     */
    public PartnerDefault getPartnerDefault(int defaultTypeId, int optionId) {

        for (Map.Entry<PartnerDefaultPK, PartnerDefault> partnerDefault : partnerDefaultsMap.entrySet()) {
            PartnerDefaultPK key = partnerDefault.getKey();

            if (key.getDefaulttype() == defaultTypeId && key.getOptions() == optionId) {
                return partnerDefault.getValue();
            }
        }

        return null;
    }

    /**
     * Return Partner Line Discounts collection
     *
     * @return List
     */
    public List<PartnerLineDiscount> getPartnerLineDiscounts() {
        return partnerLineDiscounts;
    }

    /**
     * Return Partner Group Line Discounts collection
     *
     * @return List
     */
    public List<PartnerGroupLineDiscount> getPartnerGroupLineDiscounts() {
        return partnerGroupLineDiscounts;
    }

    /**
     * Return Systems Unit of Measure
     *
     * @return List
     */
    public List<SystemUOM> getSystemUOMs() {
        return systemUOMs;
    }

    /**
     * Return System Unit of Measure
     *
     * @param id, Identification Id
     * @return SystemUOM
     */
    public SystemUOM getSystemUOM(int id) {
        return systemUOMMap.get(id);
    }

    /**
     * Return Parts Object
     *
     * @param id, Identification Id
     * @return Parts
     */
    public Parts getPart(int id) {
        return partsMap.get(id);
    }

    /**
     * Return Original Part Identification
     *
     * @param id, Identification Id
     * @return Parts
     */
    public Parts getOriginalPart(int id) {
        return originalPartsMap.get(id);
    }

    /**
     * Return Pricing Group Object
     *
     * @param id, Identification Id
     * @return PricingGroup
     */
    public PricingGroup getPricingGroup(int id) {
        return pricingGroupsMap.get(id);
    }

    /**
     * Return Type Wild Card Collection
     *
     * @return List
     */
    public List<TypeWildCard> getWildTypes() {
        return wildTypes;
    }

    /**
     * Return Type Wild Card
     *
     * @param id, Identification Id
     * @return TypeWildCard
     */
    public TypeWildCard getWildtype(int id) {
        return wildTypeMap.get(id);
    }

    /**
     * Return All Type Openings Valid List
     *
     * @return List<TypeOpening>
     */
    public List<TypeOpening> getTypeOpenings() {
        return typeOpenings;
    }

    /**
     * Return All Type Opening by Opening Class Type
     *
     * @param openingClassType, Opening Type Class Value
     * @return List<TypeOpening>
     */
    public List<TypeOpening> getTypeOpenings(int openingClassType) {

        List<TypeOpening> openings = new ArrayList<TypeOpening>();

        for (TypeOpening typeOpening : typeOpenings) {

            if (openingClassType == OpeningClassTypes.PICTURE.getValue() && typeOpening.isPicture()) {
                openings.add(typeOpening);

                continue;
            }

            if (openingClassType == OpeningClassTypes.OUT_SWING.getValue() && typeOpening.isOutswing()) {
                openings.add(typeOpening);

                continue;
            }

            if (openingClassType == OpeningClassTypes.PICTURE.getValue() && typeOpening.isInswing()) {
                openings.add(typeOpening);

                continue;
            }

            if (openingClassType == OpeningClassTypes.S_SLIDER.getValue() && typeOpening.isSslider()) {
                openings.add(typeOpening);

                continue;
            }

            if (openingClassType == OpeningClassTypes.D_SLIDER.getValue() && typeOpening.isDslider()) {
                openings.add(typeOpening);

                continue;
            }

            if (openingClassType == OpeningClassTypes.N_SLIDER.getValue() && typeOpening.isNslider()) {
                openings.add(typeOpening);

                continue;
            }

            if (openingClassType == OpeningClassTypes.FOLDING.getValue() && typeOpening.isFolding()) {
                openings.add(typeOpening);

                continue;
            }

            if (openingClassType == OpeningClassTypes.TRANSOM.getValue() && typeOpening.isTransom()) {
                openings.add(typeOpening);

                continue;
            }

            if (openingClassType == OpeningClassTypes.SIDE_LIGHT.getValue() && typeOpening.isSidelight()) {
                openings.add(typeOpening);

                continue;
            }

            if (openingClassType == OpeningClassTypes.KICK_PANEL.getValue() && typeOpening.isKickpanel()) {
                openings.add(typeOpening);

                continue;
            }

            if (openingClassType == OpeningClassTypes.POCKET.getValue() && typeOpening.isPocket()) {
                openings.add(typeOpening);

                continue;
            }

            if (openingClassType == OpeningClassTypes.PIVOT.getValue() && typeOpening.isPivot()) {
                openings.add(typeOpening);

                continue;
            }

            if (openingClassType == OpeningClassTypes.LOUVERED.getValue() && typeOpening.isLouvered()) {
                openings.add(typeOpening);

                continue;
            }
        }

        return openings;
    }

    /**
     * Return Type Opening Object
     *
     * @param id, Identification Id
     * @return TypeOpening
     */
    public TypeOpening getTypeOpening(int id) {
        return typeOpeningMap.get(id);
    }

    /**
     * Return Tye End Type Object
     *
     * @param id, Identification Id
     * @return TypeEndType
     */
    public TypeEndType getEndType(int id) {
        return typeEndTypeMap.get(id);
    }

    /**
     * Return Price Change Reason
     *
     * @param id, Identification Id
     * @return PriceChangeReason
     */
    public PriceChangeReason getChangeReason(int id) {
        return changeReasonMap.get(id);
    }

    /**
     * Return Parts Family Object
     *
     * @param id, Identification Id
     * @return PartsFamily
     */
    public PartsFamily getPartsFamily(int id) {
        return partsFamiliesMap.get(id);
    }

    /**
     * Return Part Family Series
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
     * Return TypeAttribute
     *
     * @param id, Identification Id
     * @return TypeAttribute
     */
    public TypeAttribute getAttribute(int id) {
        return attributeTypeMap.get(id);
    }

    /**
     * Return User Admin collection
     *
     * @return List
     */
    public List<UserAdmin> getUserAdmins() {
        return userAdmins;
    }

    /**
     * Return User by his Primary key
     *
     * @param userId, User Identification Id
     * @return UserAdmin
     */
    public UserAdmin getUserAdmin(Integer userId) {
        return userAdminMap.get(userId);
    }

    /**
     * Init Collection of User Admin
     *
     * @param users, List
     */
    public void setUserAdmin(List<UserAdmin> users) {

        this.userAdmins = new ArrayList<UserAdmin>();
        this.userAdminMap = new HashMap<Integer, UserAdmin>();

        for (UserAdmin user : userAdmins) {
            this.userAdminMap.put(user.getId(), user);
        }
    }

    /**
     * Return User Group Collection
     *
     * @return List
     */
    public List<UserGroup> getUserGroups() {
        return userGroups;
    }

    /**
     * Return User Group Object
     *
     * @param groupId, Group Identification Id
     * @return UserGroup
     */
    public UserGroup getUserGroup(Integer groupId) {
        return userGroupMap.get(groupId);
    }

    /**
     * Return Company Preferences
     *
     * @return CompanyPreferences
     */
    public CompanyPreferences getCompanyPreferences() {
        return companyPreferences;
    }

    /**
     * Return Countries Collection
     *
     * @return List<Country>
     */
    public List<Country> getCountries() {
        return countries;
    }

    /**
     * Return Country by Identification Id
     *
     * @param countryId, Country Id
     * @return Country
     */
    public Country getCountry(String countryId) {
        return countriesMap.get(countryId);
    }

    /**
     * Return Country States by Country Id
     *
     * @param countryId, Country Identification Id
     * @return List
     */
    public List<CountryStates> getStates(String countryId) {
        return countryStatesMap.get(countryId);
    }

    /**
     * Return Contry State by Id
     *
     * @param stateId, State Identification Id
     * @return CountryState
     */
    public CountryStates getState(int stateId) {
        return statesMap.get(stateId);
    }

    /**
     * Return Order Status
     *
     * @return List<OrderStatus>
     */
    public List<OrderStatus> getOrderStatus() {
        return orderStatus;
    }

    /**
     * Return Order Status
     *
     * @param orderStatusId, Order Status Identification Id
     * @return OrderStatus
     */
    public OrderStatus getOrderStatus(int orderStatusId) {
        return orderStatusMap.get(orderStatusId);
    }

    /**
     * Return Partner Holidays
     *
     * @param partnerId,  Partner Identification Id
     * @param isSupplier, Partner is supplier
     * @return List<PartnerHolidays>
     */
    public List<PartnerHolidays> getPartnerHolidays(int partnerId, boolean isSupplier) {

        List<PartnerHolidays> phs = new ArrayList<PartnerHolidays>();

        for (PartnerHolidays ph : this.partnerHolidays) {
            if (ph.getPartnerHolidaysPK().getPartnerId() == partnerId && ph.isSupplier() == isSupplier) {
                phs.add(ph);
            }
        }

        return phs;
    }

    /**
     * Return Country Holidays
     *
     * @param countryId, Country Identification Id
     * @return List<CountryHolidays>
     */
    public List<CountryHolidays> getCountryHolidays(String countryId) {

        List<CountryHolidays> chs = new ArrayList<CountryHolidays>();

        for (CountryHolidays ch : this.countryHolidays) {
            if (ch.getCountryHolidaysPK().getCountryid().trim().equals(countryId.trim())) {
                chs.add(ch);
            }
        }

        return chs;
    }

    //*************************************************<Init Global Identification>*************************************

    /**
     * Return Company Identification
     *
     * @return int
     */
    public int get_company() {
        return _company;
    }

    /**
     * Set Company Identification
     *
     * @param _company, Company Id
     */
    public void set_company(int _company) {
        this._company = _company;
    }
}

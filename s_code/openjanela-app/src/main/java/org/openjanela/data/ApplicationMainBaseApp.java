package org.openjanela.data;

import openjanela.model.eao.admin.systemMeasurementEAO.SystemMeasurementEAO;
import openjanela.model.eao.admin.systemMeasurementEAO.SystemMeasurementPersistenceEAO;
import openjanela.model.eao.admin.systemUOMEAO.SystemUOMEAO;
import openjanela.model.eao.admin.systemUOMEAO.SystemUOMPersistenceEAO;
import openjanela.model.eao.admin.typeDefaultEAO.TypeDefaultEAO;
import openjanela.model.eao.admin.typeDefaultEAO.TypeDefaultPersistenceEAO;
import openjanela.model.eao.admin.typePartEAO.TypePartEAO;
import openjanela.model.eao.admin.typePartEAO.TypePartPersistenceEAO;
import openjanela.model.eao.admin.typeReqStageEAO.TypeReqStageEAO;
import openjanela.model.eao.admin.typeReqStageEAO.TypeReqStagePersistenceEAO;
import openjanela.model.eao.genericEAO.GenericPersistenceEAOException;
import openjanela.model.eao.partner.partnerEAO.PartnerEAO;
import openjanela.model.eao.partner.partnerEAO.PartnerPersistenceEAO;
import openjanela.model.eao.partner.productionLineEAO.ProductionLineEAO;
import openjanela.model.eao.partner.productionLineEAO.ProductionLinePersistenceEAO;
import openjanela.model.eao.partner.seriesEAO.SeriesEAO;
import openjanela.model.eao.partner.seriesEAO.SeriesPersistenceEAO;
import openjanela.model.eao.production.productionLineStationEAO.ProductionLineStationEAO;
import openjanela.model.eao.production.productionLineStationEAO.ProductionLineStationPersistenceEAO;
import openjanela.model.eao.production.productionStationsEAO.ProductionStationsEAO;
import openjanela.model.eao.production.productionStationsEAO.ProductionStationsPersistenceEAO;
import openjanela.model.entities.admin.*;
import openjanela.model.entities.partner.Partner;
import openjanela.model.entities.partner.ProductionLine;
import openjanela.model.entities.partner.Series;
import openjanela.model.entities.production.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-15-13
 *          Time: 12:23 PM
 */
public class ApplicationMainBaseApp {

    //Apache Log4j
    private static final Logger logger = Logger.getLogger(ApplicationBaseApp.class);

    //Application Base
    private static ApplicationMainBaseApp instance;

    private List<Partner> suppliers;
    private List<Series> series;
    private List<SystemUOM> systemUOMs;
    private List<SystemMeasurement> systemMeasurements;
    private List<TypeDefault> typeDefaults;
    private List<TypePart> typeParts;
    private List<TypeReqStage> typeReqStages;

    private List<ProductionLine> productionLines;
    private List<ProductionStations> productionStations;
    private List<ProductionLineStation> productionLineStations;

    private Map<Integer, Partner> suppliersMap;
    private Map<Integer, List<Series>> seriesMap;
    private Map<Integer, SystemUOM> systemUOMMap;
    private Map<Integer, SystemMeasurement> systemMeasurementMap;
    private Map<Integer, TypeDefault> typeDefaultMap;
    private Map<Integer, TypePart> typePartMap;
    private Map<Integer, TypeReqStage> typeReqStageMap;

    private Map<Integer, ProductionLine> productionLineMap;
    private Map<Integer, ProductionStations> productionStationsMap;
    private Map<Integer, List<ProductionStations>> productionLineStationsMap;

    //Entity Access Object
    private PartnerEAO partnerEAO;
    private SeriesEAO seriesEAO;
    private SystemUOMEAO systemUOMEAO;
    private SystemMeasurementEAO systemMeasurementEAO;
    private TypeDefaultEAO typeDefaultEAO;
    private TypePartEAO typePartEAO;
    private ProductionLineEAO productionLineEAO;
    private ProductionLineStationEAO productionLineStationEAO;
    private ProductionStationsEAO productionStationsEAO;
    private TypeReqStageEAO typeReqStageEAO;

    /**
     * Application Main Base
     */
    public ApplicationMainBaseApp() {

        partnerEAO = new PartnerPersistenceEAO();
        seriesEAO = new SeriesPersistenceEAO();
        systemUOMEAO = new SystemUOMPersistenceEAO();
        systemMeasurementEAO = new SystemMeasurementPersistenceEAO();
        typeDefaultEAO = new TypeDefaultPersistenceEAO();
        typePartEAO = new TypePartPersistenceEAO();
        productionLineEAO = new ProductionLinePersistenceEAO();
        productionLineStationEAO = new ProductionLineStationPersistenceEAO();
        productionStationsEAO = new ProductionStationsPersistenceEAO();
        typeReqStageEAO = new TypeReqStagePersistenceEAO();

        //Init Production Lines
        initProductionLine();

        //Init Executor Service
        initSupplierSeries();

        //Init System UOMs
        initSystemUOMs();

        //Init Type Defaults
        initTypeDefaults();

        //Init Type Req Stage
        initTypeReqStage();

    }

    /**
     * Init Supplier Series
     */
    private void initSupplierSeries() {

        //********************************************************
        //Series EAO
        //********************************************************
        try {

            suppliers = new ArrayList<Partner>();
            suppliersMap = new HashMap<Integer, Partner>();

            series = new ArrayList<Series>();
            seriesMap = new HashMap<Integer, List<Series>>();

            //Find all suppliers for series
            List<Integer> suppliersId = new ArrayList<Integer>();
            suppliersId.addAll(seriesEAO.findAllSuppliersForSeries());

            //**********************************************
            //Adding made in suppliers
            //**********************************************
            suppliersId.add(new Integer(0));

            for (Integer supplierId : suppliersId) {
                List<Series> seriesCollection = seriesEAO.findAllSeriesForSuppliers(supplierId);
                series.addAll(seriesCollection);

                seriesMap.put(supplierId, seriesCollection);
            }

            //**********************************************
            //Find all suppliers
            //**********************************************
            suppliers = partnerEAO.findSuppliersForIds(suppliersId);

            for (Partner supplier : suppliers) {
                suppliersMap.put(supplier.getId(), supplier);
            }

            //**********************************************
            //Create a Made In Supplier
            //**********************************************
            Partner partner = new Partner();
            partner.setId(0);
            partner.setPartnerid(0);
            partner.setCompanyName("Made In");

            suppliers.add(partner);

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("Service Application Main not start: " + e.getMessage(), e);
        }

    }

    /**
     * Init System UOMS
     */
    private void initSystemUOMs() {

        //********************************************************
        //Init System UOM EAO
        //********************************************************
        try {

            systemUOMs = new ArrayList<SystemUOM>();
            systemUOMMap = new HashMap<Integer, SystemUOM>();

            systemUOMs = systemUOMEAO.findAll();

            for (SystemUOM systemUOM : systemUOMs) {
                systemUOMMap.put(systemUOM.getId(), systemUOM);
            }

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("Service Application Main not start: " + e.getMessage(), e);
        }

        //********************************************************
        //Init System Measurement
        //********************************************************
        try {

            systemMeasurements = new ArrayList<SystemMeasurement>();
            systemMeasurementMap = new HashMap<Integer, SystemMeasurement>();

            systemMeasurements = systemMeasurementEAO.findAll();

            for (SystemMeasurement systemMeasurement : systemMeasurements) {
                systemMeasurementMap.put(systemMeasurement.getId(), systemMeasurement);
            }

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage());
            throw new RuntimeException("Service Application Main not start: " + e.getMessage(), e);
        }
    }

    /**
     * Init Type Defaults, Type parts
     */
    private void initTypeDefaults() {

        //********************************************************
        //Type Default
        //********************************************************
        try {

            typeDefaults = new ArrayList<TypeDefault>();
            typeDefaultMap = new HashMap<Integer, TypeDefault>();

            typeDefaults = typeDefaultEAO.findAll();

            for (TypeDefault typeDefault : typeDefaults) {
                typeDefaultMap.put(typeDefault.getId(), typeDefault);
            }

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("Service Application Main not start: " + e.getMessage(), e);
        }

        //**********************************************************
        //Type Parts
        //**********************************************************
        try {

            typeParts = new ArrayList<TypePart>();
            typePartMap = new HashMap<Integer, TypePart>();

            typeParts = typePartEAO.findAll();

            for (TypePart typePart : typeParts) {
                typePartMap.put(typePart.getId(), typePart);
            }

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("Service Application Main not start: " + e.getMessage(), e);
        }
    }

    /**
     * Init Production Lines
     */
    private void initProductionLine() {

        //**********************************************************
        //Production Line
        //**********************************************************
        try {

            productionLines = new ArrayList<ProductionLine>();
            productionLineMap = new HashMap<Integer, ProductionLine>();

            productionLines = productionLineEAO.findAllOrderByPrimaryKey();

            //------------------------------------------------------
            //Find All Production Line Stations
            //------------------------------------------------------
            String prodLineIds = "";

            for (ProductionLine productionLine : productionLines) {
                productionLineMap.put(productionLine.getId(), productionLine);

                if (prodLineIds.length() == 0) {
                    prodLineIds = productionLine.getId().toString();
                } else {
                    prodLineIds = prodLineIds + "," + productionLine.getId();
                }
            }

            productionLineStations = new ArrayList<ProductionLineStation>();

            if (prodLineIds.length() > 0) {
                productionLineStations = productionLineStationEAO.findByProductionLine(prodLineIds);
            }

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("Service Application Main not start: " + e.getMessage(), e);
        }

        //**********************************************************
        //Production Stations
        //**********************************************************
        try {

            productionStations = new ArrayList<ProductionStations>();
            productionStationsMap = new HashMap<Integer, ProductionStations>();

            productionStations = productionStationsEAO.findAllOrderById();

            //Find All Production Stations Views
            String prodStationIds = "";
            for (ProductionStations prodStation : productionStations) {
                if (prodStationIds.length() == 0) {
                    prodStationIds = prodStation.getId().toString();
                } else {
                    prodStationIds = prodStationIds + "," + prodStation.getId();
                }
            }

            for (ProductionStations station : productionStations) {
                productionStationsMap.put(station.getId(), station);
            }

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("Service Application Main not start: " + e.getMessage(), e);
        }

        //**********************************************************
        //Production Line Stations
        //**********************************************************
        productionLineStationsMap = new HashMap<Integer, List<ProductionStations>>();

        for (ProductionLineStation prodLineStation : productionLineStations) {

            //Get Production Line Station
            ProductionStations prodStation = productionStationsMap.get(prodLineStation.getId().getStationid());

            if (productionLineStationsMap.get(prodLineStation.getId().getProdlineid()) != null) {
                List<ProductionStations> productionStations = productionLineStationsMap.get(prodLineStation.getId().getProdlineid());
                productionStations.add(prodStation);

                productionLineStationsMap.put(prodLineStation.getId().getProdlineid(), productionStations);

            } else {

                List<ProductionStations> productionStations = new ArrayList<ProductionStations>();
                productionStations.add(prodStation);

                productionLineStationsMap.put(prodLineStation.getId().getProdlineid(), productionStations);
            }
        }
    }

    /**
     * Init Type Req Stage
     */
    private void initTypeReqStage() {

        //**********************************************************
        //Type Req Stage
        //**********************************************************
        try {

            typeReqStages = new ArrayList<TypeReqStage>();
            typeReqStageMap = new HashMap<Integer, TypeReqStage>();

            typeReqStages = typeReqStageEAO.findAll();

            for (TypeReqStage stage : typeReqStages) {
                typeReqStageMap.put(stage.getId(), stage);
            }

        } catch (GenericPersistenceEAOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("Service Application Main not start: " + e.getMessage(), e);
        }
    }

    //******************************************************************************************************************

    /**
     * Return Application Main Base
     *
     * @return Application Main Base
     */
    public static ApplicationMainBaseApp getInstance() {
        if (instance == null) {
            instance = new ApplicationMainBaseApp();
        }

        return instance;
    }

    //******************************************************************************************************************

    /**
     * Return a List Suppliers Ids
     *
     * @return List
     */
    public List<Integer> getSuppliersIds() {
        List<Integer> suppliersIds = new ArrayList<Integer>();
        suppliersIds.addAll(seriesMap.keySet());

        return suppliersIds;
    }

    /**
     * Return a List Suppliers
     *
     * @return List
     */
    public List<Partner> getSuppliers() {
        return suppliers;
    }

    /**
     * Return a Supplier
     *
     * @param id, Supplier Identification Id
     * @return Partner
     */
    public Partner getSupplier(int id) {
        return suppliersMap.get(id);
    }

    /**
     * Return List of Series
     *
     * @return List
     */
    public List<Series> getSeries() {
        return series;
    }

    /**
     * Return List of Series by supplier Id
     *
     * @param supplierId, Supplier Id
     * @return List<Series>
     */
    public List<Series> getSeries(int supplierId) {
        return seriesMap.get(supplierId);
    }

    /**
     * Return a Series
     *
     * @param supplierId, Supplier Identification Id
     * @param id,         Identification Id
     * @return Series
     */
    public Series getSeries(int supplierId, int id) {
        List<Series> series = seriesMap.get(supplierId);

        Series seriesValue = null;

        if (series != null && series.size() > 0) {
            for (Series seriesObj : series) {
                if (seriesObj.getId() == id) {
                    seriesValue = seriesObj;
                }
            }
        }

        return seriesValue;
    }

    /**
     * Return a Series
     *
     * @param id, Identification Id
     * @return Series
     */
    public Series getSeriesByID(int id) {


        if (series != null && series.size() > 0) {
            for (Series seriesObj : series) {
                if (seriesObj.getId() == id) {

                    return seriesObj;
                }
            }
        }

        return null;
    }

    /**
     * Return a Production Line
     *
     * @param prodLineId, Identification Id
     * @return ProductionLine
     */
    public ProductionLine getProductionLine(int prodLineId) {
        return productionLineMap.get(prodLineId);
    }
}

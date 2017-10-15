package dto;

import Model.DesignGlass;
import Presentation.ItemFrame;
import openjanela.model.entities.design.ConstructionMap;
import openjanela.model.entities.design.DesignGlassEntityObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 12-25-12
 * Time: 09:38 PM
 */
public class DesignGlassDTO {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(DesignGlassDTO.class);

    /**
     * Return a Design Glass Entity Object
     *
     * @param itemFrame,   ItemFrame Main Panel
     * @param designGlass, DesignGlass
     * @return DesignGlassEntityObject
     * @throws DTOTransformationError, Error
     */
    public static DesignGlassEntityObject getDesignGlassEntity(ItemFrame itemFrame, DesignGlass designGlass) throws DTOTransformationError {

        if (designGlass == null) {
            throw new DTOTransformationError();
        }

        DesignGlassEntityObject designGlassEntity = new DesignGlassEntityObject();

        ConstructionMap constructionMap = new ConstructionMap();
        constructionMap.set_a_assemblyLevel(designGlass.a_assemblyLevel);
        constructionMap.set_a_1Level(designGlass.a_1Level);
        constructionMap.set_a_2Level(designGlass.a_2Level);
        constructionMap.set_a_3Level(designGlass.a_3Level);
        constructionMap.set_a_4Level(designGlass.a_4Level);
        constructionMap.set_a_5Level(designGlass.a_5Level);
        constructionMap.set_a_6Level(designGlass.a_6Level);
        constructionMap.set_a_7Level(designGlass.a_7Level);
        constructionMap.set_a_8Level(designGlass.a_8Level);
        constructionMap.set_a_9Level(designGlass.a_9Level);
        constructionMap.set_a_10Level(designGlass.a_10Level);
        constructionMap.set_a_11Level(designGlass.a_11Level);
        constructionMap.set_a_12Level(designGlass.a_12Level);
        constructionMap.set_a_13Level(designGlass.a_13Level);
        constructionMap.set_a_14Level(designGlass.a_14Level);
        constructionMap.set_a_15Level(designGlass.a_15Level);
        constructionMap.set_a_16Level(designGlass.a_16Level);
        constructionMap.set_a_17Level(designGlass.a_17Level);
        constructionMap.set_a_18Level(designGlass.a_18Level);
        constructionMap.set_a_19Level(designGlass.a_19Level);
        constructionMap.set_a_20Level(designGlass.a_20Level);
        constructionMap.set_a_21Level(designGlass.a_21Level);
        constructionMap.set_a_22Level(designGlass.a_22Level);
        constructionMap.set_a_1Sequence(designGlass.a_1Sequence);
        constructionMap.set_a_2Sequence(designGlass.a_2Sequence);
        constructionMap.set_a_3Sequence(designGlass.a_3Sequence);
        constructionMap.set_a_4Sequence(designGlass.a_4Sequence);
        constructionMap.set_a_5Sequence(designGlass.a_5Sequence);
        constructionMap.set_a_6Sequence(designGlass.a_6Sequence);
        constructionMap.set_a_7Sequence(designGlass.a_7Sequence);
        constructionMap.set_a_8Sequence(designGlass.a_8Sequence);
        constructionMap.set_a_9Sequence(designGlass.a_9Sequence);
        constructionMap.set_a_10Sequence(designGlass.a_10Sequence);
        constructionMap.set_a_11Sequence(designGlass.a_11Sequence);
        constructionMap.set_a_12Sequence(designGlass.a_12Sequence);
        constructionMap.set_a_13Sequence(designGlass.a_13Sequence);
        constructionMap.set_a_14Sequence(designGlass.a_14Sequence);
        constructionMap.set_a_15Sequence(designGlass.a_15Sequence);
        constructionMap.set_a_16Sequence(designGlass.a_16Sequence);
        constructionMap.set_a_17Sequence(designGlass.a_17Sequence);
        constructionMap.set_a_18Sequence(designGlass.a_18Sequence);
        constructionMap.set_a_19Sequence(designGlass.a_19Sequence);
        constructionMap.set_a_20Sequence(designGlass.a_20Sequence);
        constructionMap.set_a_21Sequence(designGlass.a_21Sequence);
        constructionMap.set_a_22Sequence(designGlass.a_22Sequence);

        designGlassEntity.setConstructionMap(constructionMap);

        designGlassEntity.setLevelId(designGlass.a_levelID);
        designGlassEntity.setAssemblyID(designGlass.assemblyID);
        designGlassEntity.setSequenceId(designGlass.a_sequenceID);
        designGlassEntity.setAssemblyLevelId(designGlass.a_assemblyLevel);
        designGlassEntity.setSuID(designGlass.suID);
        designGlassEntity.setStockCode(designGlass.stockCode);
        designGlassEntity.setDescription(designGlass.description);
        designGlassEntity.setAbbrev(designGlass.abbrev);
        designGlassEntity.setMinArea(designGlass.minArea);
        designGlassEntity.setMinAreaImp(designGlass.minAreaImp);
        designGlassEntity.setMaxArea(designGlass.maxArea);
        designGlassEntity.setMaxAreaImp(designGlass.maxAreaImp);
        designGlassEntity.setMinWidth(designGlass.minWidth);
        designGlassEntity.setMinWidthImp(designGlass.minWidthImp);
        designGlassEntity.setMinHeight(designGlass.minHeight);
        designGlassEntity.setMinHeightImp(designGlass.minHeightImp);
        designGlassEntity.setMaxHeight(designGlass.maxHeight);
        designGlassEntity.setMaxHeightImp(designGlass.maxHeightImp);
        designGlassEntity.setWhRatio(designGlass.whRatio);
        designGlassEntity.setPricingUOMId(designGlass.pricingUOMId);
        designGlassEntity.setPriceActualSize(designGlass.priceActualSize);
        designGlassEntity.setCost(designGlass.cost);
        designGlassEntity.setCostActualSize(designGlass.costActualSize);
        designGlassEntity.setPriceMatrixId(designGlass.priceMatrixId);
        designGlassEntity.setPrice(designGlass.price);
        designGlassEntity.setPriceUser(designGlass.priceUser);
        designGlassEntity.setMinPricingArea(designGlass.minPricingArea);
        designGlassEntity.setMinPricingAreaImp(designGlass.minPricingAreaImp);
        designGlassEntity.setMinPrice(designGlass.minPrice);
        designGlassEntity.setCostGroupId(designGlass.costGroupId);
        designGlassEntity.setPriceGroupId(designGlass.priceGroupId);
        designGlassEntity.setStartDate(designGlass.startDate);
        designGlassEntity.setEndDate(designGlass.endDate);
        designGlassEntity.setPartnerGroupId(designGlass.partnerGroupId);
        designGlassEntity.setNextItem(designGlass.nextItem);
        designGlassEntity.setDisplay(designGlass.display);
        designGlassEntity.setWaste(designGlass.waste);
        designGlassEntity.setMadeIn(designGlass.madeIn);
        designGlassEntity.setSupplierId(designGlass.supplierId);
        designGlassEntity.setLeadTime(designGlass.leadTime);
        designGlassEntity.setMinCostArea(designGlass.minCostArea);
        designGlassEntity.setMinCostAreaImp(designGlass.minCostAreaImp);
        designGlassEntity.setProductionLine(designGlass.productionLine);
        designGlassEntity.setSortSeq(designGlass.sortSeq);
        designGlassEntity.setGlazingType(designGlass.glazingType);
        designGlassEntity.setCustom(designGlass.isCustom);
        designGlassEntity.setNumOfLeaves(designGlass.numOfLeaves);
        designGlassEntity.setThickness(designGlass.thickness);
        designGlassEntity.setThicknessImp(designGlass.thicknessImp);
        designGlassEntity.setLeaf1(designGlass.leaf1);
        designGlassEntity.setLeaf2(designGlass.leaf2);
        designGlassEntity.setLeaf3(designGlass.leaf3);
        designGlassEntity.setLeaf4(designGlass.leaf4);
        designGlassEntity.setSpacer1(designGlass.spacer1);
        designGlassEntity.setSpacer2(designGlass.spacer2);
        designGlassEntity.setSpacer3(designGlass.spacer3);
        designGlassEntity.setGlassToSpacer(designGlass.glassToSpacer);
        designGlassEntity.setGlassToSpacerImp(designGlass.glassToSpacerImp);
        designGlassEntity.setGas1(designGlass.gas1);
        designGlassEntity.setGas2(designGlass.gas2);
        designGlassEntity.setGas3(designGlass.gas3);
        designGlassEntity.setFilm1(designGlass.film1);
        designGlassEntity.setFilm2(designGlass.film2);
        designGlassEntity.setFilm3(designGlass.film3);
        designGlassEntity.setFilm4(designGlass.film4);
        designGlassEntity.setProcess1(designGlass.process1);
        designGlassEntity.setProcess2(designGlass.process2);
        designGlassEntity.setProcess3(designGlass.process3);
        designGlassEntity.setProcess4(designGlass.process4);
        designGlassEntity.setCavityProcess1(designGlass.cavityProcess1);
        designGlassEntity.setCavityProcess2(designGlass.cavityProcess2);
        designGlassEntity.setCavityProcess3(designGlass.cavityProcess3);
        designGlassEntity.setCavity1Process2(designGlass.cavity1Process2);
        designGlassEntity.setCavity2Process2(designGlass.cavity2Process2);
        designGlassEntity.setCavity3Process3(designGlass.cavity3Process3);
        designGlassEntity.setCavity1Process3(designGlass.cavity1Process3);
        designGlassEntity.setCavity2Process3(designGlass.cavity2Process3);
        designGlassEntity.setCavity3Process3(designGlass.cavity3Process3);
        designGlassEntity.setExternalProcess1(designGlass.externalProcess1);
        designGlassEntity.setExternalProcess2(designGlass.externalProcess2);
        designGlassEntity.setExternalProcess3(designGlass.externalProcess3);
        designGlassEntity.setExternalProcess4(designGlass.externalProcess4);
        designGlassEntity.setExternal1Process2(designGlass.external1Process2);
        designGlassEntity.setExternal2Process2(designGlass.external2Process2);
        designGlassEntity.setExternal3Process2(designGlass.external3Process2);
        designGlassEntity.setExternal4Process2(designGlass.external4Process2);
        designGlassEntity.setExternal1Process3(designGlass.external1Process3);
        designGlassEntity.setExternal2Process3(designGlass.external2Process3);
        designGlassEntity.setExternal3Process3(designGlass.external3Process3);
        designGlassEntity.setExternal4Process3(designGlass.external4Process3);
        designGlassEntity.setGlass1(designGlass.glass1);
        designGlassEntity.setGlass2(designGlass.glass2);
        designGlassEntity.setGlass3(designGlass.glass3);
        designGlassEntity.setGlass4(designGlass.glass4);
        designGlassEntity.setGlass1Process2(designGlass.glass1Process2);
        designGlassEntity.setGlass2Process2(designGlass.glass2Process2);
        designGlassEntity.setGlass3Process2(designGlass.glass3Process2);
        designGlassEntity.setGlass4Process2(designGlass.glass4Process2);
        designGlassEntity.setGlass1Process3(designGlass.glass1Process3);
        designGlassEntity.setGlass2Process3(designGlass.glass2Process3);
        designGlassEntity.setGlass3Process3(designGlass.glass3Process3);
        designGlassEntity.setGlass4Process3(designGlass.glass4Process3);
        designGlassEntity.setSealantPartId(designGlass.sealantPartId);
        designGlassEntity.setFamilyId(designGlass.familyId);
        designGlassEntity.setInsert1Id(designGlass.insert1Id);
        designGlassEntity.setInsert2Id(designGlass.insert2Id);
        designGlassEntity.setInsert3Id(designGlass.insert3Id);
        designGlassEntity.setLeafNo(designGlass.leafNo);
        designGlassEntity.setLeafIn(designGlass.leafIn);
        designGlassEntity.setLeafOut(designGlass.leafOut);
        designGlassEntity.setSpacerThick1(designGlass.spacerThick1);
        designGlassEntity.setSpacerThick2(designGlass.spacerThick2);
        designGlassEntity.setSpacerThick3(designGlass.spacerThick3);
        designGlassEntity.setAirSpace1(designGlass.airSpace1);
        designGlassEntity.setAirSpace2(designGlass.airSpace2);
        designGlassEntity.setAirSpace3(designGlass.airSpace3);
        designGlassEntity.setSpacerThick1I(designGlass.spacerThick1i);
        designGlassEntity.setSpacerThick2I(designGlass.spacerThick2i);
        designGlassEntity.setSpacerThick3I(designGlass.spacerThick3i);
        designGlassEntity.setAirSpace1I(designGlass.airSpace1i);
        designGlassEntity.setAirSpace2I(designGlass.airSpace2i);
        designGlassEntity.setAirSpace3I(designGlass.airSpace3i);
        designGlassEntity.setMeasure(designGlass.measure);
        designGlassEntity.setUdOpeningID(designGlass.udOpeningID);
        designGlassEntity.setShapeID(designGlass.shapeID);
        designGlassEntity.setWidthM(designGlass.widthM);
        designGlassEntity.setHeightM(designGlass.heightM);
        designGlassEntity.setWidthI(designGlass.widthI);
        designGlassEntity.setHeightI(designGlass.heightI);
        designGlassEntity.setWidthMN(designGlass.widthM);
        designGlassEntity.setHeightMN(designGlass.heightMN);
        designGlassEntity.setWidthIN(designGlass.widthIN);
        designGlassEntity.setHeightIN(designGlass.heightIN);
        designGlassEntity.setParentCol(designGlass.parentcol);
        designGlassEntity.setProdLine(designGlass.prodline);
        designGlassEntity.setStation(designGlass.station);
        designGlassEntity.setReport(designGlass.report);
        designGlassEntity.setDelivery(designGlass.delivery);
        designGlassEntity.setReqforstage(designGlass.reqforstage);
        designGlassEntity.setPartFamily(designGlass.partFamily);
        designGlassEntity.setPriceGroup(designGlass.priceGroup);
        designGlassEntity.setPriceCat(designGlass.priceCat);
        designGlassEntity.setGlassBomId(designGlass.glassBomID);
        designGlassEntity.setGridID(designGlass.gridID);
        designGlassEntity.setGridType(designGlass.gridType);
        designGlassEntity.setNoGridsH(designGlass.noGridsH);
        designGlassEntity.setNoGridsV(designGlass.noGridsV);
        designGlassEntity.setNoGridsR(designGlass.noGridsR);
        designGlassEntity.setNoGridsS(designGlass.noGridsS);

        if (!itemFrame.isSupplier) {
            designGlassEntity.setSupplierRemoteId(designGlass.supplierRemoteId);
            designGlassEntity.setSupplierSeriesId(designGlass.seriesSupplierId);
            designGlassEntity.setRemote(designGlass.remote);
        }

        return designGlassEntity;
    }

    /**
     * Return design glass model object
     *
     * @param designGlassEntity, DesignGlassEntityObject
     * @return DesignGlass
     * @throws DTOTransformationError, Error
     */
    public static DesignGlass getDesignGlassModel(DesignGlassEntityObject designGlassEntity) throws DTOTransformationError {

        if (designGlassEntity == null) {
            throw new DTOTransformationError();
        }

        DesignGlass designGlass = new DesignGlass();

        designGlass.a_1Level = designGlassEntity.getConstructionMap().get_a_1Level();
        designGlass.a_2Level = designGlassEntity.getConstructionMap().get_a_2Level();
        designGlass.a_3Level = designGlassEntity.getConstructionMap().get_a_3Level();
        designGlass.a_4Level = designGlassEntity.getConstructionMap().get_a_4Level();
        designGlass.a_5Level = designGlassEntity.getConstructionMap().get_a_5Level();
        designGlass.a_6Level = designGlassEntity.getConstructionMap().get_a_6Level();
        designGlass.a_7Level = designGlassEntity.getConstructionMap().get_a_7Level();
        designGlass.a_8Level = designGlassEntity.getConstructionMap().get_a_8Level();
        designGlass.a_9Level = designGlassEntity.getConstructionMap().get_a_9Level();
        designGlass.a_10Level = designGlassEntity.getConstructionMap().get_a_10Level();
        designGlass.a_11Level = designGlassEntity.getConstructionMap().get_a_11Level();
        designGlass.a_12Level = designGlassEntity.getConstructionMap().get_a_12Level();
        designGlass.a_13Level = designGlassEntity.getConstructionMap().get_a_13Level();
        designGlass.a_14Level = designGlassEntity.getConstructionMap().get_a_14Level();
        designGlass.a_15Level = designGlassEntity.getConstructionMap().get_a_15Level();
        designGlass.a_16Level = designGlassEntity.getConstructionMap().get_a_16Level();
        designGlass.a_17Level = designGlassEntity.getConstructionMap().get_a_17Level();
        designGlass.a_18Level = designGlassEntity.getConstructionMap().get_a_18Level();
        designGlass.a_19Level = designGlassEntity.getConstructionMap().get_a_19Level();
        designGlass.a_20Level = designGlassEntity.getConstructionMap().get_a_20Level();
        designGlass.a_21Level = designGlassEntity.getConstructionMap().get_a_21Level();
        designGlass.a_22Level = designGlassEntity.getConstructionMap().get_a_22Level();
        designGlass.a_1Sequence = designGlassEntity.getConstructionMap().get_a_1Sequence();
        designGlass.a_2Sequence = designGlassEntity.getConstructionMap().get_a_2Sequence();
        designGlass.a_3Sequence = designGlassEntity.getConstructionMap().get_a_3Sequence();
        designGlass.a_4Sequence = designGlassEntity.getConstructionMap().get_a_4Sequence();
        designGlass.a_5Sequence = designGlassEntity.getConstructionMap().get_a_5Sequence();
        designGlass.a_6Sequence = designGlassEntity.getConstructionMap().get_a_6Sequence();
        designGlass.a_7Sequence = designGlassEntity.getConstructionMap().get_a_7Sequence();
        designGlass.a_8Sequence = designGlassEntity.getConstructionMap().get_a_8Sequence();
        designGlass.a_9Sequence = designGlassEntity.getConstructionMap().get_a_9Sequence();
        designGlass.a_10Sequence = designGlassEntity.getConstructionMap().get_a_10Sequence();
        designGlass.a_11Sequence = designGlassEntity.getConstructionMap().get_a_11Sequence();
        designGlass.a_12Sequence = designGlassEntity.getConstructionMap().get_a_12Sequence();
        designGlass.a_13Sequence = designGlassEntity.getConstructionMap().get_a_13Sequence();
        designGlass.a_14Sequence = designGlassEntity.getConstructionMap().get_a_14Sequence();
        designGlass.a_15Sequence = designGlassEntity.getConstructionMap().get_a_15Sequence();
        designGlass.a_16Sequence = designGlassEntity.getConstructionMap().get_a_16Sequence();
        designGlass.a_17Sequence = designGlassEntity.getConstructionMap().get_a_17Sequence();
        designGlass.a_18Sequence = designGlassEntity.getConstructionMap().get_a_18Sequence();
        designGlass.a_19Sequence = designGlassEntity.getConstructionMap().get_a_19Sequence();
        designGlass.a_20Sequence = designGlassEntity.getConstructionMap().get_a_20Sequence();
        designGlass.a_21Sequence = designGlassEntity.getConstructionMap().get_a_21Sequence();
        designGlass.a_22Sequence = designGlassEntity.getConstructionMap().get_a_22Sequence();

        designGlass.a_levelID = designGlassEntity.getLevelId();
        designGlass.a_sequenceID = designGlassEntity.getSequenceId();
        designGlass.a_assemblyLevel = designGlassEntity.getAssemblyLevelId();
        designGlass.suID = designGlassEntity.getSuID();
        designGlass.assemblyID = designGlassEntity.getAssemblyID();
        designGlass.stockCode = designGlassEntity.getStockCode();
        designGlass.description = designGlassEntity.getDescription();
        designGlass.abbrev = designGlassEntity.getAbbrev();
        designGlass.minArea = designGlassEntity.getMinArea();
        designGlass.minAreaImp = designGlassEntity.getMinAreaImp();
        designGlass.maxArea = designGlassEntity.getMaxArea();
        designGlass.maxAreaImp = designGlassEntity.getMaxAreaImp();
        designGlass.minWidth = designGlassEntity.getMinWidth();
        designGlass.minWidthImp = designGlassEntity.getMinWidthImp();
        designGlass.minHeight = designGlassEntity.getMinHeight();
        designGlass.minHeightImp = designGlassEntity.getMinHeightImp();
        designGlass.maxHeight = designGlassEntity.getMaxHeight();
        designGlass.maxHeightImp = designGlassEntity.getMaxHeightImp();
        designGlass.whRatio = designGlassEntity.getWhRatio();
        designGlass.pricingUOMId = designGlassEntity.getPricingUOMId();
        designGlass.priceActualSize = designGlassEntity.isPriceActualSize();
        designGlass.cost = designGlassEntity.getCost();
        designGlass.costActualSize = designGlassEntity.isCostActualSize();
        designGlass.priceMatrixId = designGlassEntity.getPriceMatrixId();
        designGlass.price = designGlassEntity.getPrice();
        designGlass.priceUser = designGlassEntity.getPriceUser();
        designGlass.minPricingArea = designGlassEntity.getMinPricingArea();
        designGlass.minPricingAreaImp = designGlassEntity.getMinPricingAreaImp();
        designGlass.minPrice = designGlassEntity.getMinPrice();
        designGlass.costGroupId = designGlassEntity.getCostGroupId();
        designGlass.priceGroupId = designGlassEntity.getPriceGroupId();
        designGlass.startDate = designGlassEntity.getStartDate();
        designGlass.endDate = designGlassEntity.getEndDate();
        designGlass.partnerGroupId = designGlassEntity.getPartnerGroupId();
        designGlass.nextItem = designGlassEntity.getNextItem();
        designGlass.display = designGlassEntity.isDisplay();
        designGlass.waste = designGlassEntity.getWaste();
        designGlass.madeIn = designGlassEntity.isMadeIn();
        designGlass.supplierId = designGlassEntity.getSupplierId();
        designGlass.leadTime = designGlassEntity.getLeadTime();
        designGlass.minCostArea = designGlassEntity.getMinCostArea();
        designGlass.minCostAreaImp = designGlassEntity.getMinCostAreaImp();
        designGlass.productionLine = designGlassEntity.getProductionLine();
        designGlass.sortSeq = designGlassEntity.getSortSeq();
        designGlass.glazingType = designGlassEntity.getGlazingType();
        designGlass.isCustom = designGlassEntity.isCustom();
        designGlass.numOfLeaves = designGlassEntity.getNumOfLeaves();
        designGlass.thickness = designGlassEntity.getThickness();
        designGlass.thicknessImp = designGlassEntity.getThicknessImp();
        designGlass.leaf1 = designGlassEntity.getLeaf1();
        designGlass.leaf2 = designGlassEntity.getLeaf2();
        designGlass.leaf3 = designGlassEntity.getLeaf3();
        designGlass.leaf4 = designGlassEntity.getLeaf4();
        designGlass.spacer1 = designGlassEntity.getSpacer1();
        designGlass.spacer2 = designGlassEntity.getSpacer2();
        designGlass.spacer3 = designGlassEntity.getSpacer3();
        designGlass.glassToSpacer = designGlassEntity.getGlassToSpacer();
        designGlass.glassToSpacerImp = designGlassEntity.getGlassToSpacerImp();
        designGlass.gas1 = designGlassEntity.getGas1();
        designGlass.gas2 = designGlassEntity.getGas2();
        designGlass.gas3 = designGlassEntity.getGas3();
        designGlass.film1 = designGlassEntity.getFilm1();
        designGlass.film2 = designGlassEntity.getFilm2();
        designGlass.film3 = designGlassEntity.getFilm3();
        designGlass.film4 = designGlassEntity.getFilm4();
        designGlass.process1 = designGlassEntity.getProcess1();
        designGlass.process2 = designGlassEntity.getProcess2();
        designGlass.process3 = designGlassEntity.getProcess3();
        designGlass.process4 = designGlassEntity.getProcess4();
        designGlass.cavityProcess1 = designGlassEntity.getCavityProcess1();
        designGlass.cavityProcess2 = designGlassEntity.getCavityProcess2();
        designGlass.cavityProcess3 = designGlassEntity.getCavityProcess3();
        designGlass.cavity1Process2 = designGlassEntity.getCavity1Process2();
        designGlass.cavity2Process2 = designGlassEntity.getCavity2Process2();
        designGlass.cavity3Process3 = designGlassEntity.getCavity3Process3();
        designGlass.cavity1Process3 = designGlassEntity.getCavity1Process3();
        designGlass.cavity2Process3 = designGlassEntity.getCavity2Process3();
        designGlass.cavity3Process3 = designGlassEntity.getCavity3Process3();
        designGlass.externalProcess1 = designGlassEntity.getExternalProcess1();
        designGlass.externalProcess2 = designGlassEntity.getExternalProcess2();
        designGlass.externalProcess3 = designGlassEntity.getExternalProcess3();
        designGlass.externalProcess4 = designGlassEntity.getExternalProcess4();
        designGlass.external1Process2 = designGlassEntity.getExternal1Process2();
        designGlass.external2Process2 = designGlassEntity.getExternal2Process2();
        designGlass.external3Process2 = designGlassEntity.getExternal3Process2();
        designGlass.external4Process2 = designGlassEntity.getExternal4Process2();
        designGlass.external1Process3 = designGlassEntity.getExternal1Process3();
        designGlass.external2Process3 = designGlassEntity.getExternal2Process3();
        designGlass.external3Process3 = designGlassEntity.getExternal3Process3();
        designGlass.external4Process3 = designGlassEntity.getExternal4Process3();
        designGlass.glass1 = designGlassEntity.getGlass1();
        designGlass.glass2 = designGlassEntity.getGlass2();
        designGlass.glass3 = designGlassEntity.getGlass3();
        designGlass.glass4 = designGlassEntity.getGlass4();
        designGlass.glass1Process2 = designGlassEntity.getGlass1Process2();
        designGlass.glass2Process2 = designGlassEntity.getGlass2Process2();
        designGlass.glass3Process2 = designGlassEntity.getGlass3Process2();
        designGlass.glass4Process2 = designGlassEntity.getGlass4Process2();
        designGlass.glass1Process3 = designGlassEntity.getGlass1Process3();
        designGlass.glass2Process3 = designGlassEntity.getGlass2Process3();
        designGlass.glass3Process3 = designGlassEntity.getGlass3Process3();
        designGlass.glass4Process3 = designGlassEntity.getGlass4Process3();
        designGlass.sealantPartId = designGlassEntity.getSealantPartId();
        designGlass.familyId = designGlassEntity.getFamilyId();
        designGlass.insert1Id = designGlassEntity.getInsert1Id();
        designGlass.insert2Id = designGlassEntity.getInsert2Id();
        designGlass.insert3Id = designGlassEntity.getInsert3Id();
        designGlass.leafNo = designGlassEntity.getLeafNo();
        designGlass.leafIn = designGlassEntity.getLeafIn();
        designGlass.leafOut = designGlassEntity.getLeafOut();
        designGlass.spacerThick1 = designGlassEntity.getSpacerThick1();
        designGlass.spacerThick2 = designGlassEntity.getSpacerThick2();
        designGlass.spacerThick3 = designGlassEntity.getSpacerThick3();
        designGlass.airSpace1 = designGlassEntity.getAirSpace1();
        designGlass.airSpace2 = designGlassEntity.getAirSpace2();
        designGlass.airSpace3 = designGlassEntity.getAirSpace3();
        designGlass.spacerThick1i = designGlassEntity.getSpacerThick1I();
        designGlass.spacerThick2i = designGlassEntity.getSpacerThick2I();
        designGlass.spacerThick3i = designGlassEntity.getSpacerThick3I();
        designGlass.airSpace1i = designGlassEntity.getAirSpace1I();
        designGlass.airSpace2i = designGlassEntity.getAirSpace2I();
        designGlass.airSpace3i = designGlassEntity.getAirSpace3I();
        designGlass.measure = designGlassEntity.getMeasure();
        designGlass.udOpeningID = designGlassEntity.getUdOpeningID();
        designGlass.shapeID = designGlassEntity.getShapeID();
        designGlass.widthM = designGlassEntity.getWidthM();
        designGlass.heightM = designGlassEntity.getHeightM();
        designGlass.widthI = designGlassEntity.getWidthI();
        designGlass.heightI = designGlassEntity.getHeightI();
        designGlass.widthM = designGlassEntity.getWidthMN();
        designGlass.heightMN = designGlassEntity.getHeightMN();
        designGlass.widthIN = designGlassEntity.getWidthIN();
        designGlass.heightIN = designGlassEntity.getHeightIN();
        designGlass.parentcol = designGlassEntity.getParentCol();
        designGlass.prodline = designGlassEntity.getProdLine();
        designGlass.station = designGlassEntity.getStation();
        designGlass.report = designGlassEntity.getReport();
        designGlass.delivery = designGlassEntity.getDelivery();
        designGlass.reqforstage = designGlassEntity.getReqforstage();
        designGlass.partFamily = designGlassEntity.getPartFamily();
        designGlass.priceGroup = designGlassEntity.getPriceGroup();
        designGlass.priceCat = designGlassEntity.getPriceCat();
        designGlass.gridID = designGlassEntity.getGridID();
        designGlass.gridType = designGlassEntity.getGridType();
        designGlass.noGridsH = designGlassEntity.getNoGridsH();
        designGlass.noGridsV = designGlassEntity.getNoGridsV();
        designGlass.noGridsR = designGlassEntity.getNoGridsR();
        designGlass.noGridsS = designGlassEntity.getNoGridsS();

        designGlass.supplierRemoteId = designGlassEntity.getSupplierRemoteId();
        designGlass.seriesSupplierId = designGlassEntity.getSupplierSeriesId();
        designGlass.remote = designGlassEntity.isRemote();

        return designGlass;
    }

    /**
     * This method clone a javaBean properties methods
     *
     * @param designGlassEntity, DesignGlassEntityObject
     * @return DesignGlassEntityObject
     */
    public static DesignGlassEntityObject cloneDesignGlassOption(DesignGlassEntityObject designGlassEntity) throws
            DTOTransformationError {

        try {

            if (designGlassEntity == null) {
                throw new DTOTransformationError();
            }

            /* Clone DesignGlass entity object */
            DesignGlassEntityObject designGlass = (DesignGlassEntityObject) BeanUtils.cloneBean(designGlassEntity);
            designGlass.setId(null);

            /* Clone Construction Map object */
            ConstructionMap constructionMap = ConstructionMapDTO.cloneConstructionMap(designGlassEntity.getConstructionMap());
            designGlass.setConstructionMap(constructionMap);

            return designGlass;

        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        } catch (InstantiationException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        } catch (InvocationTargetException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        } catch (NoSuchMethodException e) {
            logger.error(e.getMessage(), e);
            throw new DTOTransformationError(e.getMessage(), e);
        }

    }
}
